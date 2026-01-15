package com.alphagnfss.testproject.list_view_theme_testing;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ListViewTestController {

	@FXML
	public ListView<String> listView;

	@FXML
	public void initialize() {
		int noOfItems = 25;
		for (int i = 0; i < noOfItems; i++)
			listView.getItems().add("A Long Funny Movie Name With A Number Of " + (i + 1));
	}
}
