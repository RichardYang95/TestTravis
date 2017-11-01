import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Calculator extends Application {
	//Declare calc controls
	TextField txtnum1, txtnum2;
	Button add, sub, div, mul, clear;
	Label answerField;

	@Override
	public void start(Stage stage) {
		//Initialize calc controls
		txtnum1 = new TextField();
		txtnum2 = new TextField();
		add = new Button("+");
		sub = new Button("-");
		mul = new Button("x");
		div = new Button("/");
		clear = new Button("Clear");
		answerField = new Label("0");
		answerField.setAlignment(Pos.CENTER);
		answerField.setStyle("-fx-border-color: #000; -fx-padding: 5px;");

		//Place calc controls in a gridpane
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);		
		root.setVgap(10);
		root.add(answerField, 0, 0, 2, 1);
		root.add(txtnum1, 0, 1);
		root.add(txtnum2, 1, 1);
		root.add(add, 0, 2);
		root.add(sub, 1, 2);
		root.add(mul, 0, 3);
		root.add(div, 1, 3);
		root.add(clear, 0, 4, 2, 1);

		//Set widths of calc controls
		setWidths();
		
		//Set code logic for calc controls
		attachCode();
		
		//Set up scene
		Scene scene = new Scene(root, 200, 200);
		stage.setTitle("Calculator");
		stage.setScene(scene);
		stage.show();
	}

	//Set widths for calc controls
	public void setWidths() {
		txtnum1.setPrefWidth(70);
		txtnum2.setPrefWidth(70);
		add.setPrefWidth(70);
		sub.setPrefWidth(70);
		mul.setPrefWidth(70);
		div.setPrefWidth(70);
		clear.setPrefWidth(150);
		answerField.setPrefWidth(150);
	}

	//Set code logic for each calc control
	public void attachCode() {
		add.setOnAction(e -> btncode(e));
		sub.setOnAction(e -> btncode(e));
		mul.setOnAction(e -> btncode(e));
		div.setOnAction(e -> btncode(e));
		clear.setOnAction(e -> btncode(e));
	}

	//Code logic for each control
	public void btncode(ActionEvent e) {
		int num1, num2, answer;
		char symbol;
		
		//Clear btn is clicked
		if(e.getSource() == clear) {
			txtnum1.setText("");
			txtnum2.setText("");
			answerField.setText("0");
			txtnum1.requestFocus();
			return;
		}
		
		//Scan input numbers from textfield
		num1 = Integer.parseInt(txtnum1.getText());
		num2 = Integer.parseInt(txtnum2.getText());
		
		//Operation btns are clicked
		if(e.getSource() == add) {
			symbol = '+';
			answer = num1 + num2;
		}
		else if(e.getSource() == sub) {
			symbol = '-';
			answer = num1 - num2;
		}
		else if(e.getSource() == mul) {
			symbol = 'x';
			answer = num1 * num2;
		}
		else {
			//Divide by 0 error
			if (num2 == 0) {
				answerField.setText("Error: Divide by zero!");
				return;
			}
			symbol = '/';
			answer = num1 / num2;
		}
		
		//display answer
		answerField.setText(num1 + " " + symbol + " " + num2 + " = " + answer);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

