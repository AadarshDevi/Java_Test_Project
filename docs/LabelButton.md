# SVG LabelButton (SLB)

    ⓘ The code in this section was written with the guidance of Perplexity.

A LabelButton is a Label that acts like a Button. An SVG LabelButton is a LabelButton that has a SVG as its icon.

## FXML Hierarchy
```
SVGLabelButtonTest.fxml
|-- BorderPane (root)
    |-- Label (fx:id="label" styleClass="label")
        |-- SVGPath (fx:id="svg-path" styleClass="svg-path")
|-- Controller: Controller.java
|-- External CSS: Stylesheet.css
```

##### Default View
<img src="/docs/res/LabelButton/slb_default.png" alt="default_view">

##### Hover View
<img src="/docs/res/LabelButton/slb_hover.png" alt="hover_view">

##### Selected View
<img src="/docs/res/LabelButton/slb_selected.png" alt="selected_view">

## Controller
```java
	
//	label.setOnMouseClicked(event -> {
//		if(!selected.get()) {
//		label.getStyleClass().add("selected");
//			selected.set(true);
//		} else {
//				label.getStyleClass().remove("selected");
//			selected.set(false);
//		}
//				System.out.println(label.getStyle());
//		});
```
**_The code for this section will be in Controller.java._**<br>
Below we have the two JavaFX Components, the Label and SVGPath. We are getting them from the fxml.

```java
import javafx.scene.control.Label;

@FXML private Label label;
@FXML private SVGPath svgPath;
```

Once we get our Label and SVGPath we can now give them their CSS Classes.<br>
The Label and the SVGPath will have 3 states: Default, Hover, and Selected. Default and Hover states are taken
care by the External CSS. The only state that has to be coded manually is the Selected state.
This is done in the `initialize()` method.

```java
import javafx.fxml.FXML;

@FXML public void initialize() {}
```

In `initialize()` we will have a boolean, selected. This boolean will keep track if the
button is selected or not. Our boolean will be the AtomicBoolean. It is Boolean. For the others, it is a that is thread-safe boolean.

```java
AtomicBoolean selected = new AtomicBoolean(false);
```

## External CSS
```css
/* Default Style */
.label {
    -fx-background-color: #ffffff;
}

.label .svg-path {
    -fx-stroke: black;
}

/* Hover Style */
.label:hover {
    -fx-background-color: #fafafa;
}

.label:hover .svg-path {
    -fx-stroke: #00e1ff;
}

/* Selected Style */
.label.selected {
    -fx-background-color: #ffc0c0;
}

.label.selected .svg-path {
    -fx-stroke: #785bff;
}
```

