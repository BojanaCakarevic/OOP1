package pv2512;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class Predmeti extends Application {

	private TextField naziv;
	private TextField godina;
	private TextField bodovi;
	private ComboBox<Integer> brojPredispitnih;
	private TextField usmeni;
	private Label labelNaziv;
	private Label labelGodina;
	private Label labelBodovi;
	private Label labelBrojPredispitnih;
	private Label labelUsmeni;
	Button sacuvaj;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Unos predmeta");
		primaryStage.setScene(new Scene(initGUI(), 500, 300));
		primaryStage.show();
	}

	private BorderPane initGUI() {
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(20));
		bp.setCenter(initCenter());
		bp.setBottom(initBottom());
		return bp;
	}

	private GridPane initCenter() {
		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(10));
		
		naziv = new TextField();
		godina = new TextField();
		bodovi = new TextField();
		usmeni = new TextField();
		brojPredispitnih = new ComboBox<>(FXCollections.observableArrayList(1, 2, 3, 4, 5));
		labelNaziv = new Label("Naziv predmeta: ");
		labelGodina = new Label("Godina: ");
		labelBodovi = new Label("Bodovi sa predispitnih obaveza: ");
		labelBrojPredispitnih = new Label("Broj predispitnih obaveza: ");
		labelUsmeni = new Label("Bodovi sa usmenog: ");
		
		gp.add(labelNaziv, 0, 0);
		gp.add(labelGodina, 0, 1);
		gp.add(labelBodovi, 0, 2);
		gp.add(labelBrojPredispitnih, 0, 3);
		gp.add(labelUsmeni, 0, 4);
		
		gp.add(naziv, 1, 0);
		gp.add(godina, 1, 1);
		gp.add(bodovi, 1, 2);
		gp.add(brojPredispitnih, 1, 3);
		brojPredispitnih.setPrefSize(170, brojPredispitnih.getPrefHeight());
		gp.add(usmeni, 1, 4);
		
		
		return gp;
	}

	private HBox initBottom() {
		HBox hb = new HBox();
		sacuvaj = new Button("Sacuvaj");
		sacuvaj.setOnAction(this::sacuvaj);
		hb.getChildren().add(sacuvaj);
		hb.setAlignment(Pos.CENTER);
		return hb;
	}

	// Obraditi slucaj kada predmet vec postoji u fajlu
	private void sacuvaj(ActionEvent e) {
		if(ispravno()) {
			try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("res\\faajl.txt", true)))) {
				pw.println(naziv.getText() + ", " + godina.getText() + ", " + bodovi.getText() + ", " + brojPredispitnih.getSelectionModel().getSelectedIndex() + ", " +usmeni.getText());
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
		naziv.clear();
		godina.clear();
		bodovi.clear();
		usmeni.clear();
		brojPredispitnih.getSelectionModel().clearSelection();
	}

	public boolean praznaPolja() {
		if (naziv.getText().equals("") || godina.getText().equals("") || bodovi.getText().equals("")
				|| usmeni.getText().equals("") || brojPredispitnih.getSelectionModel().getSelectedItem() == null)
			return true;
		return false;
	}

	public boolean ispravno() {
		if (praznaPolja()) {
			new Alert(Alert.AlertType.INFORMATION, "Nisu popunjena sva polja").showAndWait();
			return false;
		}
		
		// Dodati dodatna ogranicenja
		try {
			String nazivv = naziv.getText();
			int god = Integer.parseInt(godina.getText());
			int bodovii = Integer.parseInt(bodovi.getText());
			int usmenii = Integer.parseInt(usmeni.getText());
			if (bodovii + usmenii != 100)
				return false;
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
