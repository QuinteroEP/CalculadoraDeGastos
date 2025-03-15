//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.pabloqc.transmilenio;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Costos extends Application {
    public Costos() {
    }

    public void start(Stage stage) throws IOException {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(Costos.class.getResource("/com/pabloqc/transmilenio/Pantalla.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 652, 400);
        stage.setTitle("Calculadora de costos");
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
