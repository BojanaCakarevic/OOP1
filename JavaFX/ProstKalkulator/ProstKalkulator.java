package ProstKalkulator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ProstKalkulator extends Application {
	
	private TextField prviBroj = new TextField() ;
	private TextField drugiBroj = new TextField() ;
	private ComboBox<String> operacija ;
	private Label rezLabel = new Label();
	private Button izracunaj = new Button("Izracunaj");
	private Button ocisti = new Button("Ocisti");
	
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane glavni = new BorderPane();
		glavni.setPadding(new Insets(10));
		glavni.setCenter(napraviOpisPanel());
		glavni.setBottom(napraviKontrolniPanel());
		
		izracunaj.setOnAction(this::izracunaj);
		ocisti.setOnAction(this::ocisti);
		
		primaryStage.setTitle("Prost kalkulator");
		primaryStage.setScene(new Scene(glavni, 300, 250));
		primaryStage.show();
	}

	
	private GridPane napraviOpisPanel() {
		GridPane g = new GridPane();
		g.setHgap(20);
		g.setVgap(20);
		g.add(new Label("Prvi broj: "), 0, 0);
		g.add(new Label("Drugi broj: "), 0, 1);
		g.add(new Label("Operacija: "), 0, 2);
		g.add(new Label("Rezultat: "), 0, 3);
		
		g.add(prviBroj, 1, 0);
		g.add(drugiBroj, 1, 1);
		operacija = new ComboBox<>(FXCollections.observableArrayList(" + (saberi)", " - (oduzmi)", " * (pomnozi) ", " / (podeli) "));
		g.add(operacija, 1, 2);
		operacija.getSelectionModel().select(1);
		g.add(rezLabel, 1, 3);
		
		return g;
	}

	private HBox napraviKontrolniPanel() {
		HBox hb = new HBox();
		hb.setSpacing(15);
		hb.getChildren().add(izracunaj);
		hb.getChildren().add(ocisti);
		return hb;
	}
	
	private void izracunaj(ActionEvent e) {
		if(prviBroj.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije unesen prvi broj").showAndWait() ;
			return;
		}
		
		if(drugiBroj.getText().length() == 0) {
			new Alert(Alert.AlertType.ERROR, "Nije unesen drugi broj").showAndWait() ;
			return;
		}
		
		
		int broj1, broj2;
		try {
			broj1 = Integer.parseInt(prviBroj.getText());
		} catch(NumberFormatException nfe) {
			new Alert(Alert.AlertType.ERROR, prviBroj.getText() + " nije broj").showAndWait();
			return;
		}
		
		try {
			broj2 = Integer.parseInt(drugiBroj.getText());
		} catch(NumberFormatException nfe) {
			new Alert(Alert.AlertType.ERROR, drugiBroj.getText() + " nije broj").showAndWait();
			return;
		}
		
		int izabranaOperacija = operacija.getSelectionModel().getSelectedIndex();
		
		if(izabranaOperacija == 3 && broj2 == 0){
			new Alert(Alert.AlertType.ERROR, "Deljenje nulom nije dozvoljeno").showAndWait();
			return;
	}
		
		int rez = 0;
		switch(izabranaOperacija) {
		case 0: rez = broj1 + broj2;
		break;
		case 1: rez = broj1 - broj2;
		break;
		case 2: rez = broj1 * broj2;
		break;
		case 3: rez = broj1 / broj2;
		break;
		}
		
		rezLabel.setText(Integer.toString(rez));
		
	}
	
	private void ocisti(ActionEvent e) {
		prviBroj.setText("");
		drugiBroj.setText("");
		operacija.getSelectionModel().select(1);
	}

}
