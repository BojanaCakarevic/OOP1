package ZadatakPeti;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class pv_25122020 extends Application {

	public static final String FILE = "predmeti.txt";
	private TextField nazivPredmeta;
	private TextField godina;
	private TextField predispitniBodovi;
	private ComboBox<Integer> brObaveza;
	private TextField usmeniBodovi;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Predmeti");
		primaryStage.setScene(new Scene(initGUI(), 500, 300));
		primaryStage.show();
	}

	private BorderPane initGUI() {
		BorderPane koren = new BorderPane();
		koren.setPadding(new Insets(10));
		koren.setBottom(initDole());
		koren.setCenter(initCenter());
		return koren;
	}

	private GridPane initCenter() {
		GridPane centar = new GridPane();
		centar.setPadding(new Insets(5));
		centar.setHgap(5);
		centar.setVgap(10);
		
		centar.add(new Label("Naziv predmeta: "), 0, 0);
		centar.add(new Label("Godina: "), 0, 1);
		centar.add(new Label("Bodovi sa predispitnih: "), 0, 2);
		centar.add(new Label("Broj predispitnih obaveza: "), 0, 3);
		centar.add(new Label("Bodovi sa usmenog: "), 0, 4);
	
		nazivPredmeta = new TextField();
		godina = new TextField();
		predispitniBodovi = new TextField();
		brObaveza = new ComboBox<>(FXCollections.observableArrayList(1, 2, 3, 4, 5));
		usmeniBodovi = new TextField();
		
		centar.add(nazivPredmeta, 1, 0);
		centar.add(godina, 1, 1);
		centar.add(predispitniBodovi, 1, 2);
		brObaveza.setPrefSize(170, brObaveza.getPrefHeight());
		centar.add(brObaveza, 1, 3);
		centar.add(usmeniBodovi, 1, 4);
		
		return centar;
	}

	private FlowPane initDole() {
		FlowPane dole = new FlowPane();
		dole.setAlignment(Pos.CENTER);
		Button sacuvajDugme = new Button("Sacuvaj");
		sacuvajDugme.setOnAction(e -> {
			sacuvaj(e);
		});
		dole.getChildren().add(sacuvajDugme);

		return dole;
	}

	private void sacuvaj(ActionEvent e) {
		if (ispravniPodaci()) {
			try (PrintWriter izlaz = new PrintWriter(new BufferedWriter(new FileWriter(FILE, true)))) {
				izlaz.println(nazivPredmeta.getText() + ", " + godina.getText() + ", " + predispitniBodovi.getText() + ", " + brObaveza.getSelectionModel().getSelectedIndex() + ", " +usmeniBodovi.getText());
			} catch (Exception io) {
				new Alert(Alert.AlertType.ERROR, "Greska prilikom upisivanja u fajl").showAndWait();
			}
			new Alert(Alert.AlertType.INFORMATION, "Predmet uspesno unesen u fajl").showAndWait();
			reset();
		} else {
			new Alert(Alert.AlertType.ERROR, "Neispravno uneseni podaci o predmetu").showAndWait();
		}
	}

	private void reset() {
		nazivPredmeta.setText("");
		godina.setText("");
		predispitniBodovi.setText("");
		brObaveza.getSelectionModel().clearSelection();
		usmeniBodovi.setText("");
	}

	private boolean ispravniPodaci() {
		if (praznoPolje(nazivPredmeta) || praznoPolje(godina) || praznoPolje(predispitniBodovi) || praznoPolje(usmeniBodovi) || brObaveza.getSelectionModel().getSelectedItem() == null ) {
			return false;
		} else {
			try {
				int god = Integer.parseInt(godina.getText().trim());
				int bodoviPred = Integer.parseInt(predispitniBodovi.getText().trim());
				int bodoviUsmeni = Integer.parseInt(usmeniBodovi.getText().trim());
				if (bodoviPred + bodoviUsmeni != 100)
					return false;
				return true;
			} catch( NumberFormatException nfe) {
				return false;
			}
		}
	}

	private boolean praznoPolje(TextField polje) {
		return polje.getText() == null || polje.getText().trim().isEmpty();
	}
	
}
