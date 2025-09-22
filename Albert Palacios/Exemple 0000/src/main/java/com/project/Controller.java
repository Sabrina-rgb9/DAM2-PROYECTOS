package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private Button unoButton;
    private Button dosButton;
    private Button tresButton;
    private Button cuatroButton;
    private Button cincoButton;
    private Button seisButton;
    private Button sieteButton;
    private Button ochoButton;
    private Button nueveButton;
    private Button ceroButton;
    private Button sumButton;
    private Button restButton;
    private Button multiButton;
    private Button diviButton;
    private Button equalButton;
    private Button clearButton;
    private Button comaButton;



    @FXML
    private Text displayText; // Agrega esto para mostrar el número en la interfaz

    private StringBuilder currentInput = new StringBuilder();

    @FXML
    private void actionUno(ActionEvent event) {
        currentInput.append("1");
        updateDisplay();
    }

    @FXML
    private void actionDos(ActionEvent event) {
        currentInput.append("2");
        updateDisplay();
    }

    @FXML
    private void actionTres(ActionEvent event) {
        currentInput.append("3");
        updateDisplay();
    }

    @FXML
    private void actionCuatro(ActionEvent event) {
        currentInput.append("4");
        updateDisplay();
    }

    @FXML
    private void actionCinco(ActionEvent event) {
        currentInput.append("5");
        updateDisplay();
    }

    @FXML
    private void actionSeis(ActionEvent event) {
        currentInput.append("6");
        updateDisplay();
    }

    @FXML
    private void actionSiete(ActionEvent event) {
        currentInput.append("7");
        updateDisplay();
    }

    @FXML
    private void actionOcho(ActionEvent event) {
        currentInput.append("8");
        updateDisplay();
    }

    @FXML
    private void actionNueve(ActionEvent event) {
        currentInput.append("9");
        updateDisplay();
    }

    @FXML
    private void actionCero(ActionEvent event) {
        currentInput.append("0");
        updateDisplay();
    }

    private void updateDisplay() {
        if (displayText != null) {
            displayText.setText(currentInput.toString());
        }
    }

    private double obtenerNumeroActual() {
        try {
            return Double.parseDouble(currentInput.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @FXML
    private void actionSum(ActionEvent event) {
        // Lógica para el botón "+"
        double primerNumero = obtenerNumeroActual();
        String operacion = "+";
        // Luego, cuando se presione "=", realizar la operación
        equalButton.setOnAction(e -> {
            double segundoNumero = obtenerNumeroActual();
            double resultado = 0;
            switch (operacion) {
                case "+":
                    resultado = primerNumero + segundoNumero;
                    break;
                // Agrega más casos para otras operaciones
            }
            System.out.println("Resultado: " + resultado);
        });
    }

    @FXML
    private void actionRest(ActionEvent event) {
        // Lógica para el botón "-"
        // Aquí puedes agregar la lógica para la resta
        double primerNumero = obtenerNumeroActual();
        String operacion = "-";
        equalButton.setOnAction(e -> {
            double segundoNumero = obtenerNumeroActual();
            double resultado = 0;
            switch (operacion) {
                case "-":
                    resultado = primerNumero - segundoNumero;
                    break;
                case "*":
                    resultado = primerNumero * segundoNumero;
                    break;
                case "/":
                    if (segundoNumero != 0) {
                        resultado = primerNumero / segundoNumero;
                    } else {
                        System.out.println("Error: Has dividido por cero");
                    }
                    break;

            }
        });
    }

}
