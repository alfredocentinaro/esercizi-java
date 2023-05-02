package iis.alessandrini.tabellefx;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ControllerNuovo {
    @FXML
    private Button btnInserisci;

    private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Accordion tendine;

    @FXML
    private TitledPane tabGenerale;

    @FXML
    private TitledPane tabIdentificazione;

    @FXML
    private TextField txtClasse;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtIndirizzo;

    @FXML
    private DatePicker txtNato;

    @FXML
    private TextField txtNome;

    @FXML
    private ChoiceBox<Sesso> txtSesso;

    @FXML
    void cancella(ActionEvent event) {
        this.txtNome.setText("");
        this.txtCognome.setText("");
        this.txtClasse.setText("");
        this.txtIndirizzo.setText("");
        this.txtNato.setValue(null);
        this.txtSesso.setValue(null);
    }

    private boolean valida()
    {
        boolean errore = false;

        if(txtNome.getText().isEmpty())
            errore = false;

        if(txtCognome.getText().isEmpty())
            errore = false;

        return errore;
    }

    @FXML
    void inserisci(ActionEvent event)
    {
        if (this.valida())
        {
            //prelevo i valori della form
            // TO DO aggiungi controlli
            String nome = this.txtNome.getText();
            String cognome = this.txtCognome.getText();
            String classe = this.txtClasse.getText();
            String indirizzo = this.txtIndirizzo.getText();
            LocalDate nato = this.txtNato.getValue();
            Sesso sesso = txtSesso.getValue();

            Alunno a = new Alunno(-1, nome, cognome, classe, nato, indirizzo, sesso);
            model.add(a);

            //chiude la finestra al termine dell'inserimento
            Stage stage = (Stage) btnInserisci.getScene().getWindow();
            stage.close();
        }
    }
    public void setModel(Model m)
    {
        this.model = m;
    }
    public Model getModel(){return this.model;}

    @FXML
    void initialize() {
        assert tabGenerale != null : "fx:id=\"tabGenerale\" was not injected: check your FXML file 'nuovo.fxml'.";
        assert tabIdentificazione != null : "fx:id=\"tabIdentificazione\" was not injected: check your FXML file 'nuovo.fxml'.";
        assert tendine != null : "fx:id=\"tendine\" was not injected: check your FXML file 'nuovo.fxml'.";
        assert txtClasse != null : "fx:id=\"txtClasse\" was not injected: check your FXML file 'nuovo.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'nuovo.fxml'.";
        assert txtIndirizzo != null : "fx:id=\"txtIndirizzo\" was not injected: check your FXML file 'nuovo.fxml'.";
        assert txtNato != null : "fx:id=\"txtNato\" was not injected: check your FXML file 'nuovo.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'nuovo.fxml'.";
        assert txtSesso != null : "fx:id=\"txtSesso\" was not injected: check your FXML file 'nuovo.fxml'.";

        this.txtSesso.setItems(FXCollections.observableArrayList(Sesso.values()));

        tendine.setExpandedPane(this.tabIdentificazione);
    }


}

