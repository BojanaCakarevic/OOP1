package ZadatakDrugi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	Button button;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("title");
		button = new Button();
		button.setText("click me");
		
		button.setOnAction(e -> System.out.println("hello"));
		
//		button.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				System.out.println("Im an anonymous inner class");
//			}
//		});

		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		Scene scene = new Scene(layout, 250, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

//	@Override
//	public void handle(ActionEvent event) {
//		if (event.getSource().equals(button))
//			System.out.println("something");
//	}

}
