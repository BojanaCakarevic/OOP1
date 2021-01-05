package ZadatakCetvrti;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Automobili extends Application {
	

		private class Car implements Comparable<Car> {
		String model, manufacturer;
		double price;
		int km, state;
		boolean used;

		public Car(String model, String manufacturer, double price, int km, int state, boolean used) {
			this.model = model;
			this.manufacturer = manufacturer;
			this.price = price;
			this.km = km;
			this.state = state;
			this.used = used;
		}

		@Override
		public int compareTo(Car that) {
			int rez = this.model.compareTo(that.model);
			if(rez == 0) {
				rez = this.km - that.km;
			} return rez;
		}
		
		@Override
		public String toString() {
			if(used)
				return "Model " + model + "-" + manufacturer + ", used: yes" ;
			else
				return "Model " + model + "-"  + manufacturer + ", used: no" ;
		}

}
		private static final int INSETS = 5;
		
		private TextField model;
		private TextField manufacturer;
		private TextField price;
		private TextField km;
		private ComboBox<Integer> state;
		final ToggleGroup group = new ToggleGroup();
		RadioButton used;
		RadioButton not;
		private List<Car> cars = new ArrayList<Car>();
		GridPane left = new GridPane();
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			primaryStage.setTitle("Unos predmeta");
			primaryStage.setScene(new Scene(initGui(), 400, 300));
			primaryStage.show();
		}
		
		private BorderPane initGui() {
			BorderPane root = new BorderPane();
			root.setLeft(initLeft());
			root.setBottom(initBottom());
			root.setCenter(initCenter());
			
			return root;
		}
		
		private GridPane initLeft() {
			left.setPadding(new Insets(INSETS));
			left.setHgap(INSETS);
			left.setVgap(INSETS * 2);
			left.add(new Label("You have entered in this session: "), 0, 0);
			return left;
		}
		
		private FlowPane initBottom() {
			FlowPane fp = new FlowPane();
			fp.setAlignment(Pos.CENTER);
			fp.setPadding(new Insets(INSETS));
			Button save = new Button("add");
			fp.getChildren().add(save);
			return fp;
		}
		

		
		private GridPane initCenter() {
			GridPane center = new GridPane();
			center.setPadding(new Insets(INSETS));
			center.setHgap(INSETS);
			center.setVgap(INSETS * 2);
			center.add(new Label("Model:"), 0, 0);
			center.add(new Label("Manufacturer:"), 0, 1);
			center.add(new Label("Price:"), 0, 2);
			center.add(new Label("KM:"), 0, 3);
			center.add(new Label("State:"), 0, 4);
			center.add(new Label("Used:"), 0, 5);
			
			model = new TextField();
			manufacturer = new TextField();
			price = new TextField();
			km = new TextField();
			state = new ComboBox<>(FXCollections.observableArrayList(1, 2, 3, 4, 5));
			used = new RadioButton("Yes");
			used.setToggleGroup(group);
	        not = new RadioButton("No");
	        not.setToggleGroup(group);
	        center.add(model, 1, 0);
			center.add(manufacturer, 1, 1);
			center.add(price, 1, 2);
			center.add(km, 1, 3);
			state.setPrefSize(170, state.getPrefHeight());
			center.add(state, 1, 4);
			center.add(used, 1, 5);
	        center.add(not, 1, 6);
	        
	        return center;
		}
		
}
