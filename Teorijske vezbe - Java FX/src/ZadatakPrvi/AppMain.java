package ZadatakPrvi;





import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppMain extends Application implements EventHandler<ActionEvent>{

	private Button[][] dugmici;
	private static int DIM = 4;
	private static int DIM_dugmeta = 50;
	private Label parni;
	private Label neparni;
	private Matrica matrica;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public AppMain() {
		this.matrica = new Matrica(DIM, 2);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane bp = new BorderPane();
		bp.setCenter(initCenter());		
		bp.setBottom(initBottom());
		Scene scene = new Scene(bp);
		primaryStage.setScene(scene);
		primaryStage.setTitle("dugmici");
		primaryStage.show();

	}

	private Pane initCenter() {
		GridPane gp = new GridPane();
		this.dugmici = new Button[DIM][DIM];
		gp.setPadding(new Insets(5));
		gp.setHgap(5);
		gp.setVgap(5);
		//ubacivanje delova
				for(int i = 0; i < DIM; i++) {
					for(int j = 0; j < DIM; j++) {
						// pravimo dugmice
						Button dugme = new Button("" + this.matrica.brojNaLokaciji(i, j));
						dugmici[i][j] = dugme;
						dugme.setPrefSize(DIM_dugmeta, DIM_dugmeta);
						// kolona pa vrsta
						gp.add(dugme, i, j);
						dugme.setOnAction(this);
					}
				}
				return gp;
	}
	
	private Pane initBottom() {
		FlowPane fp = new FlowPane();
		
		fp.setPadding(new Insets(5));
		fp.setHgap(5);
		fp.setVgap(5);
		parni = new Label("Kliknuto parnih");
		neparni = new Label("Kliknuto neparnih");
		fp.getChildren().addAll(parni, neparni);
		
		return fp;
	}

	@Override
	public void handle(ActionEvent event) {
		Button b = (Button) event.getSource();
		int broj =  Integer.parseInt( b.getText());
		this.matrica.odaberiBroj(broj);
		this.azurirajLabele();
		if(this.matrica.sviIsti()) {
			Alert a = new Alert(Alert.AlertType.INFORMATION, "Dva puta za redom kliknuto isto dugme");
			a.show();
		}
	}


	public void azurirajLabele() {
		this.parni.setText("Kliknuto parnih " + this.matrica.getBrParnih());
		this.neparni.setText("Kliknuto neparnih " + this.matrica.getBrNeparnih());
	}
	
}
