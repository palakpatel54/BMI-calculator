package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Random;

public class Main extends Application {
	private TextField weightField;
    private TextField heightField;
    private Label resultLabel;

	public static void main(String args[]) {
		launch(args);
	}
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		 primaryStage.setTitle("BMI Calculator");

	        Label weightLabel = new Label("Weight (kg):");
	        Label heightLabel = new Label("Height (cm):");
	        weightField = new TextField();
	        heightField = new TextField();
	        Button calculateButton = new Button("Calculate BMI");
	        resultLabel = new Label();

	        calculateButton.setOnAction(event -> calculateBMI());

	        VBox root = new VBox(10);
	        root.setAlignment(Pos.CENTER);
	        root.getChildren().addAll(weightLabel, weightField, heightLabel, heightField, calculateButton, resultLabel);

	        Scene scene = new Scene(root, 300, 200);
	        primaryStage.setScene(scene);

	        primaryStage.show();
	    }

	private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText()) / 100.0; // Convert to meters
            double bmi = weight / (height * height);

            String bmiCategory;
            if (bmi < 18.5) {
                bmiCategory = "Underweight";
            } else if (bmi < 24.9) {
                bmiCategory = "Normal weight";
            } else if (bmi < 29.9) {
                bmiCategory = "Overweight";
            } else {
                bmiCategory = "Obese";
            }

	 resultLabel.setText(String.format("BMI: %.2f (%s)", bmi, bmiCategory));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }
}

