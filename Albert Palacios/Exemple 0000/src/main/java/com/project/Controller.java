package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;


public class Controller {

    @FXML
    private Text display;
    
    private double num1 = 0;
    private String operator = "";
    private boolean startNew = true;

    @FXML
    private void actionNumber(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (startNew || display.getText().equals("0")) {
            display.setText(value);
            startNew = false;
        } else {
            display.setText(display.getText() + value);
        }
    }

    @FXML
    private void actionDot() {
        if (startNew) {
            display.setText("0.");
            startNew = false;
        } else if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    @FXML
    private void actionClear() {
        display.setText("0");
        num1 = 0;
        operator = "";
        startNew = true;
    }

    @FXML
    private void actionAdd() {
        setOperator("+");
    }

    @FXML
    private void actionSubtract() {
        setOperator("-");
    }

    @FXML
    private void actionMultiply() {
        setOperator("*");
    }

    @FXML
    private void actionDivide() {
        setOperator("/");
    }

    private void setOperator(String op) {
        num1 = Double.parseDouble(display.getText());
        operator = op;
        startNew = true;
    }

    @FXML
    private void actionEquals() {
        if (operator.isEmpty()) return;

        double num2 = Double.parseDouble(display.getText());
        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> (num2 == 0) ? 0 : num1 / num2;
            default -> 0;
        };

        display.setText((result % 1 == 0) ? String.valueOf((int) result) : String.valueOf(result));
        startNew = true;
        operator = "";
    }
}
