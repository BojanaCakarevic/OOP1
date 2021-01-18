package d_08;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class d_08 extends Application {

	private TextField predmet;
	private TextField vrednost;
	private Button addItem;
	private Button print;
	private ListView<String> lista;
	private ObservableList<String> listaPregled;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Checkout");
		primaryStage.setScene(new Scene(initGui(), 500, 250));
		primaryStage.show();
	}

	private BorderPane initGui() {
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(20, 20, 20, 20));
		bp.setLeft(initLeft());
		bp.setRight(initRight());
		return bp;
	}

	private VBox initLeft() {
		VBox vb = new VBox();
		vb.setSpacing(10);

		predmet = new TextField();
		vrednost = new TextField();

		addItem = new Button("Add Item");
		print = new Button("Print");

		vb.getChildren().add(predmet);
		vb.getChildren().add(vrednost);
		vb.getChildren().add(addItem);
		vb.getChildren().add(print);

		addItem.setOnAction(this::addItem);
		print.setOnAction(this::print);

		return vb;
	}

	private BorderPane initRight() {
		BorderPane bp = new BorderPane();	
		listaPregled = FXCollections.observableArrayList();
		bp.setCenter(lista = new ListView<>(listaPregled));
		return bp;
	}


	public static void main(String[] args) {
		launch(args);
	}

	public void addItem(ActionEvent e) {
		if(!validacija()) {
			new Alert(Alert.AlertType.ERROR, "Neispravno uneseni podaci o predmetu").showAndWait();
		} else {
			listaPregled.add(predmet.getText() + " - " + vrednost.getText());
		}
	}

	public void print(ActionEvent e) {
		if(validacija()) {
			try ( PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("res\\fajl.txt", true))) ){
				pw.println(predmet.getText() + ", " + vrednost.getText());
		} catch( Exception io ) {
			new Alert(Alert.AlertType.ERROR, "Greska pri upisivanju u fajl").showAndWait();
			}
			new Alert(AlertType.INFORMATION, "Predmet uspesno unesen u fajl").showAndWait();
			reset();
		} else
			new Alert(Alert.AlertType.ERROR, "Neispravno uneti podaci o predmetima").showAndWait() ;
	}
	
	private void reset() {
		predmet.setText("");
		vrednost.setText("");
		lista.getItems().clear();
	}
	
	private boolean praznaPolja() {
		if (predmet.getText().equals("") || vrednost.getText().equals(""))
			return true;
		return false;
	}

	private boolean validacija() {
		if (praznaPolja())
			return false;
		else {
			try {
				String p = predmet.getText();
				double v = Double.parseDouble(vrednost.getText().trim());
				return true;
			} catch (NumberFormatException nfe) {
				return false;
			}
		}
	}

}
