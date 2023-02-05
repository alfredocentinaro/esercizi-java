package com.centinaro.testimc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class IMCController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalcola;

    @FXML
    private Button btnCancella;

    @FXML
    private ChoiceBox<Sesso> chcSesso;

    @FXML
    private MenuItem cancellaMenu;

    @FXML
    private MenuItem chiudi;

    @FXML
    private ImageView immagine;

    @FXML
    private MenuItem info;
    @FXML
    private TitledPane pannello;

    @FXML
    private Label risultato;

    @FXML
    private TextField txtAltezza;

    @FXML
    private TextField txtPeso;

    @FXML
    void chiudi(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void popInfo(ActionEvent event) throws IOException {

        //ObservableList<Window> windows = Window.getWindows();

        FXMLLoader fxmlLoader = new FXMLLoader(IMCApplication.class.getResource("PannelloInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 200);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void calcola(ActionEvent event) throws FileNotFoundException
    {

        if (!this.valida())
            return;

        double altezza = Double.valueOf(this.txtAltezza.getText());
        double peso = Double.valueOf(this.txtPeso.getText());
        Sesso s = this.chcSesso.getValue();


        IMC  imc = new IMC(altezza, peso, s);
        Stato stato = imc.statoIMC();
        if (stato == Stato.Sottopeso)
        {
            FileInputStream input = new FileInputStream("src/main/resources/img/pollice-blu.png");
            Image image = new Image(input);
            this.immagine.setImage(image);
        }


        if (stato == Stato.Normopeso)
        {
            FileInputStream input = new FileInputStream("src/main/resources/img/pollice-verde.png");
            Image image = new Image(input);
            this.immagine.setImage(image);
        }

        if (stato == Stato.Sovrappeso)
        {
            FileInputStream input = new FileInputStream("src/main/resources/img/pollice-giallo.png");
            Image image = new Image(input);
            this.immagine.setImage(image);
        }

        if (stato == Stato.Obeso)
        {
            FileInputStream input = new FileInputStream("src/main/resources/img/pollice-verde.png");
            Image image = new Image(input);
            this.immagine.setImage(image);
        }

        this.risultato.setText("Il tuo IMC è: " + String.valueOf(Math.floor(imc.calcolaIMC())));
    }

    @FXML
    void cancella(ActionEvent event) {
        this.txtPeso.setText("");
        this.txtAltezza.setText("");
        this.chcSesso.getValue();

        this.reset();
    }

    @FXML
    void cambia(KeyEvent event) { this.reset(); this.valida();}
    @FXML
    void validaAltezza(KeyEvent event) {
        txtAltezza.setStyle(null);
    }

    @FXML
    void validaPeso(KeyEvent event) {
        txtPeso.setStyle(null);
    }



    void reset()
    {
        txtAltezza.setStyle(null);
        txtPeso.setStyle(null);
    }

    boolean valida()
    {
        boolean errore = true;

        if(txtAltezza.getText().isEmpty() || txtAltezza.getText().matches(".*[a-zA-Z].*"))
        {
            txtAltezza.setStyle("-fx-background-color:#9c2b2e; -fx-border-color:#e84e4f");
            errore = false;
        }

        if(txtPeso.getText().isEmpty() || txtPeso.getText().matches(".*[a-zA-Z].*"))
        {
            txtPeso.setStyle("-fx-background-color:#9c2b2e; -fx-border-color:#e84e4f");
            errore = false;
        }

        return errore;
    }

    @FXML
    void initialize() {
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'IMC-view.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'IMC-view.fxml'.";
        assert cancellaMenu != null : "fx:id=\"cancellaMenu\" was not injected: check your FXML file 'IMC-view.fxml'.";
        assert chcSesso != null : "fx:id=\"chcSesso\" was not injected: check your FXML file 'IMC-view.fxml'.";
        assert chiudi != null : "fx:id=\"chiudi\" was not injected: check your FXML file 'IMC-view.fxml'.";
        assert immagine != null : "fx:id=\"immagine\" was not injected: check your FXML file 'IMC-view.fxml'.";
        assert info != null : "fx:id=\"info\" was not injected: check your FXML file 'IMC-view.fxml'.";
        assert risultato != null : "fx:id=\"risultato\" was not injected: check your FXML file 'IMC-view.fxml'.";
        assert txtAltezza != null : "fx:id=\"txtAltezza\" was not injected: check your FXML file 'IMC-view.fxml'.";
        assert txtPeso != null : "fx:id=\"txtPeso\" was not injected: check your FXML file 'IMC-view.fxml'.";


        this.chcSesso.setItems(FXCollections.observableArrayList(Sesso.values()));

    }

}
