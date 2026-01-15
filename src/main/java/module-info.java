module com.alphagnfss.testproject {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;
	requires javafxsvg;
	requires javafx.graphics;
	requires javafx.media;
	requires java.desktop;

	opens com.alphagnfss.testproject to javafx.fxml;
	opens com.alphagnfss.testproject.changablecss to javafx.fxml;
	opens com.alphagnfss.testproject.svglabelbutton to javafx.fxml;
	opens com.alphagnfss.testproject.theming to javafx.fxml;
	opens com.alphagnfss.testproject.list_view_theme_testing to javafx.fxml;
	opens com.alphagnfss.testproject.dragdropdata to javafx.fxml;

	exports com.alphagnfss.testproject;
	exports com.alphagnfss.testproject.svglabelbutton;
	exports com.alphagnfss.testproject.changablecss;
	exports com.alphagnfss.testproject.theming;
	exports com.alphagnfss.testproject.list_view_theme_testing;
	exports com.alphagnfss.testproject.dragdropdata;
}