package OnlineProdavnica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Online_prodavnica.Patike;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class onlineProdavnica extends Application {

	private TextField vrsta;
	private TextField tip;
	private TextField boja;
	private TextField budzet;
	private Label labelVrsta;
	private Label labelTip;
	private Label labelBoja;
	private Label labelBudzet;
	private Button pretrazi;
	private Button reset;
	private ArrayList<Patike> patike;
	private ListView<String> lista;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Online prodavnica patika");
		primaryStage.setScene(new Scene(initGui(), 550, 250));
		primaryStage.show();
	}

	private BorderPane initGui() {
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(20));
		bp.setRight(initRight());
		bp.setLeft(initLeft());
		return bp;
	}

	private BorderPane initLeft() {
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10));
		bp.setCenter(initCenter());
		bp.setBottom(initBottom());
		return bp;
	}

	private HBox initBottom() {
		HBox hb = new HBox();
		hb.setSpacing(20);

		pretrazi = new Button("Pretrazi");
		reset = new Button("Reset");

		pretrazi.setOnAction(this::pretrazi);
		reset.setOnAction(this::reset);

		hb.getChildren().add(pretrazi);
		hb.getChildren().add(reset);

		return hb;
	}

	private GridPane initCenter() {
		GridPane gp = new GridPane();

		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(5));

		vrsta = new TextField();
		tip = new TextField();
		boja = new TextField();
		budzet = new TextField();
		labelVrsta = new Label("Vrsta: ");
		labelTip = new Label("Tip: ");
		labelBoja = new Label("Boja: ");
		labelBudzet = new Label("Budzet: ");

		gp.add(labelVrsta, 0, 0);
		gp.add(labelTip, 0, 1);
		gp.add(labelBoja, 0, 2);
		gp.add(labelBudzet, 0, 3);

		gp.add(vrsta, 1, 0);
		gp.add(tip, 1, 1);
		gp.add(boja, 1, 2);
		gp.add(budzet, 1, 3);

		return gp;
	}

	private BorderPane initRight() {
		BorderPane bp = new BorderPane();
		ucitajPatike();
		bp.setCenter(lista = new ListView<>());
		return bp;
	}

	private void ucitajPatike() {
		try (BufferedReader br = new BufferedReader(new FileReader("res\\patike.txt"))) {
			int brPatika = Integer.parseInt(br.readLine().trim());

			patike = new ArrayList<>();
			for (int i = 0; i < brPatika; i++) {
				String[] s = br.readLine().split(",");

				String markaa = s[0].trim();
				int broj = Integer.parseInt(s[1].trim());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fajl za citanje ne postoji" + e.getMessage());
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	public void pretrazi(ActionEvent e) {

		if (ispravno()) {
			String vrstaa = vrsta.getText().trim();
			String tipp = tip.getText().trim();
			String bojaa = boja.getText().trim();
			double budzett = Double.parseDouble(budzet.getText().trim());

			for (Patike p : patike) {
				System.out.println(p);
				if (p.getVrsta().equalsIgnoreCase(vrstaa) && p.getTip().equalsIgnoreCase(tipp)
						&& p.getBoja().equalsIgnoreCase(bojaa) && p.getCena() <= budzett) {
					lista.getItems().add(p.toString());
				}
			}
			new Alert(Alert.AlertType.INFORMATION, "Nema proizvoda koji vam odgovara.").showAndWait();
		}
	}

	public void reset(ActionEvent e) {
		vrsta.setText("");
		tip.setText("");
		boja.setText("");
		budzet.setText("");
		lista.getItems().clear();
	}

	private boolean ispravno() {
		if (praznoPolje()) {
			new Alert(Alert.AlertType.ERROR,"Nisu popunjena sva polja").showAndWait();
			return false;
		}
		try {
		String vrstaa = vrsta.getText().trim();
		String tipp = tip.getText().trim();
		String bojaa = boja.getText().trim();
		double budzett = Double.parseDouble(budzet.getText().trim());
		return true;
	} catch( NumberFormatException nfe) {
		new Alert(Alert.AlertType.ERROR, "Podaci nisu ispravno uneti").showAndWait();
		return false;
	}
		}

	private boolean praznoPolje() {
		if (vrsta.getText().equals("") || tip.getText().equals("") || boja.getText().equals("")
				|| budzet.getText().equals(""))
			return true;
		return false;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
