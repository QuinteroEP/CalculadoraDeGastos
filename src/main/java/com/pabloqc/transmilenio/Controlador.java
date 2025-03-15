//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.pabloqc.transmilenio;

import java.text.NumberFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controlador {
    @FXML
    private TextField costTravel;

    @FXML
    private TextField costFood;

    @FXML
    private TextField costExtra;

    @FXML
    private TextField doubleDays;

    @FXML
    private TextField classDays;

    @FXML
    private Label transportCost;

    @FXML
    private Label foodCost;

    @FXML
    private Label weeklyCosts;

    @FXML
    private Label monthlyCosts;

    @FXML
    public void initialize() {
        makeNumeric(costTravel);
        makeNumeric(costFood);
        makeNumeric(costExtra);
        makeNumeric(doubleDays);
        makeNumeric(classDays);

        this.weeklyCosts.setText("");
        this.foodCost.setText("");
        this.monthlyCosts.setText("");
        this.transportCost.setText("");
    }

    public String getDays() {
        return this.classDays.getText();
    }

    public String getDoubleDays() {
        return this.doubleDays.getText();
    }

    public String getCostTransport() {
        return this.costTravel.getText();
    }

    public String getCostFood() {
        return this.costFood.getText();
    }

    public String getCostExtras() {
        return this.costExtra.getText();
    }

    //Solo valores numericos
    private void makeNumeric(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    private void calcularCostos() {
        int travel = Integer.parseInt(this.getCostTransport(), 10);
        int food = Integer.parseInt(this.getCostFood(), 10);
        int days = Integer.parseInt(this.getDays(), 10);
        int doubleTrips = Integer.parseInt(this.getDoubleDays(), 10);
        int extras = Integer.parseInt(this.getCostExtras(), 10);
        
        int costoTransporte = (travel * days + travel * doubleTrips)*2;
        int costoAlimentacion = food * days;
        int costoSemanal = costoTransporte + costoAlimentacion + extras;
        int costoMensual = costoSemanal * 4;

        //Formato
        NumberFormat numberFormat = NumberFormat.getInstance();

        this.weeklyCosts.setText("Gastos semanales totales: " + numberFormat.format(costoSemanal));
        this.monthlyCosts.setText("Gastos mensuales totales: " + numberFormat.format(costoMensual));

        this.foodCost.setText("Gastos semanales en comida: " + numberFormat.format(costoAlimentacion));
        this.transportCost.setText("Gastos semanales en transporte: " + numberFormat.format(costoTransporte));
    }
}
