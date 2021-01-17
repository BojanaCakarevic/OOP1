package Fibonacci;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Button previous;
	private Button next;
	private Label broj;
	private Fibonaci f;
	private int pozicija;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Fibonaci");
		primaryStage.setScene(new Scene(initGui(), 200, 200));
		primaryStage.show();
	}
	
	public Main() {
		this.pozicija = 1;
		this.f = new Fibonaci();
	}
	
	private BorderPane initGui() {
		BorderPane bp = new BorderPane();
		bp.setCenter(initCenter());
		bp.setBottom(initBottom());
		bp.setPadding(new Insets(10));
		return bp;
	}

	private HBox initBottom() {
		HBox hb = new HBox();
		hb.setSpacing(30);
		hb.setAlignment(Pos.CENTER);
		
		previous = new Button("Previous");
		next = new Button("Next");
		
		previous.setOnAction(this::previous);
		next.setOnAction(this::next);
		
		hb.getChildren().add(previous);
		hb.getChildren().add(next);
		
		return hb;
	}

	private VBox initCenter() {
		VBox vb = new VBox();
		broj = new Label(" " + this.pozicija);
		this.broj.setFont(new Font("Arial", 50));
		this.broj.setTextFill(Color.RED);
		
		vb.getChildren().add(broj);
		vb.setAlignment(Pos.CENTER);
		return vb;
	}
	
	private void previous(ActionEvent e) {
		if(this.pozicija == 1) {
			new Alert(Alert.AlertType.ERROR, "Ne postoji prethodnik ovog broja u Fibonacijevom nizu").showAndWait() ;
			return;
		} else {
			this.pozicija--;
			updateLabels(f.manji());
		}
	}
	
	private void next(ActionEvent e) {
		this.pozicija++;
		if (this.pozicija == 11) {
			new Alert(Alert.AlertType.ERROR, "Poslednja pozicija").showAndWait();
			return;
		} else {
			updateLabels(f.veci());
		}
	}

	public static void main(String[] a) {
		launch(a);
	}

private void updateLabels(int vrednost) {
		this.broj.setText(" " + vrednost);
	}

}
