module com.alphagnfss.testproject {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;
	requires javafxsvg;


	opens com.alphagnfss.testproject to javafx.fxml;
	exports com.alphagnfss.testproject;
}