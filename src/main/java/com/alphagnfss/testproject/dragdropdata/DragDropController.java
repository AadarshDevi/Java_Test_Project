package com.alphagnfss.testproject.dragdropdata;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class DragDropController {

	private static final int BUFFER_SIZE = 4096;
	@FXML
	public BorderPane root;
	@FXML
	public ListView<Label> listView;
	@FXML
	public Label filepath;
	private AudioInputStream convertedStream;
	private SourceDataLine currentLine;
	private Thread playbackThread;
	private volatile boolean isPlaying = false;


	@FXML
	public void initialize() {

		listView.setOnDragOver(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent dragEvent) {
				if (dragEvent.getGestureSource() != listView
						&& dragEvent.getDragboard().hasFiles()) {
					/* allow for both copying and moving, whatever user chooses */
					dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
				dragEvent.consume();
			}
		});

		listView.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				boolean success = false;
				if (db.hasFiles()) {
					// dropped.setText(db.getFiles().toString());
					for (File file : db.getFiles()) {
						Label label = new Label(file.getAbsolutePath());
						label.setOnMouseClicked(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent mouseEvent) {
								filepath.setText(label.getText());
								try {
									runMedia(label.getText());
								} catch (UnsupportedAudioFileException e) {
									throw new RuntimeException(e);
								} catch (IOException e) {
									throw new RuntimeException(e);
								} catch (LineUnavailableException e) {
									throw new RuntimeException(e);
								}
							}
						});
						listView.getItems().add(label);
						System.out.println(file.getAbsolutePath());
					}
					success = true;
				}
				event.setDropCompleted(success);

				event.consume();
			}
		});
	}

	public void runMedia(String audioFilePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// Stop any current playback
		stopMedia();

		AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(audioFilePath));
		AudioFormat baseFormat = audioStream.getFormat();
		System.out.println(baseFormat);

		AudioFormat targetFormat = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED,
				baseFormat.getSampleRate(),
				16,
				baseFormat.getChannels(),
				baseFormat.getChannels() * 2,
				baseFormat.getSampleRate(),
				false
		);

		convertedStream = AudioSystem.getAudioInputStream(targetFormat, audioStream);

		DataLine.Info info = new DataLine.Info(SourceDataLine.class, targetFormat);
		currentLine = (SourceDataLine) AudioSystem.getLine(info);
		currentLine.open(targetFormat);

		isPlaying = true;
		currentLine.start();

		// Playback in background thread (NON-BLOCKING)
		playbackThread = new Thread(() -> {
			byte[] bufferBytes = new byte[BUFFER_SIZE];
			int readBytes;
			try {
				while (isPlaying && (readBytes = convertedStream.read(bufferBytes)) != -1) {
					if (isPlaying) {
						currentLine.write(bufferBytes, 0, readBytes);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				currentLine.drain();
				currentLine.close();
				currentLine = null;
				isPlaying = false;
			}
		});
		playbackThread.setDaemon(true); // Dies when app closes
		playbackThread.start();
	}


	private void stopMedia() {
		isPlaying = false;

		if (currentLine != null) {
			currentLine.drain();
			currentLine.stop();
			currentLine.close();
			currentLine = null;
		}

		if (playbackThread != null && playbackThread.isAlive()) {
			playbackThread.interrupt();
		}
		playbackThread = null;

		if (convertedStream != null) {
			try {
				convertedStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			convertedStream = null;
		}
	}
}