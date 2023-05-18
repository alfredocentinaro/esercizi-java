package iis.alessandrini.tabellefx;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.EventListener;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller
{
    private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnElimina;

    @FXML
    private Button btnNuovo;

    @FXML
    private Button btnSalva;

    @FXML
    private TableColumn<Alunno, String> colClasse;

    @FXML
    private TableColumn<Alunno, String> colCognome;

    @FXML
    private TableColumn<Alunno, Integer> colId;

    @FXML
    private TableColumn<Alunno, String> colNome;

    @FXML
    private MenuItem elimina;

    @FXML
    private TabPane pannelloTabs;

    @FXML
    private Tab tabDettagli;

    @FXML
    private Tab tabGenerale;

    @FXML
    private TableView<Alunno> tablePrincipale;

    @FXML
    private TextField txtClasse;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtIndirizzo;

    @FXML
    private DatePicker txtNato;

    @FXML
    private TextField txtNome;

    @FXML
    private ChoiceBox<Sesso> txtSesso;

    @FXML
    void chiudi(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void elimina(ActionEvent event) {
        Alunno a = tablePrincipale.getSelectionModel().getSelectedItem();
        if (a != null)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Conferma eliminazione");
            alert.setHeaderText("Sei sicuro di eliminare questo record?");
            //alert.setContentText("Sei sicuro di eliminare questo record?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                //elimino dall'array list/tablevie
                this.model.remove(a);
                tablePrincipale.getItems().remove(a);
            }
        }
    }


    @FXML
    void salva(ActionEvent event) {
        Alunno a = tablePrincipale.getSelectionModel().getSelectedItem();
        if (a != null)
        {
            //a.setId(Integer.valueOf(this.txtId.getText()));
            a.setNome(this.txtNome.getText());
            a.setCognome(this.txtCognome.getText());
            a.setClasse(this.txtClasse.getText());
            a.setIndirizzo(this.txtIndirizzo.getText());
            a.setNascita(this.txtNato.getValue());
            a.setSesso(this.txtSesso.getValue());

            //salva i valori nella tableview
            this.txtId.commitValue();
            this.txtCognome.commitValue();
            this.txtClasse.commitValue();
            this.txtIndirizzo.commitValue();
            this.txtNato.commitValue();
            //this.txtSesso.setSelectionModel();

            this.model.scrivi();
            tablePrincipale.refresh();
        }
    }
    @FXML
    void info(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AlunniApplication.class.getResource("info.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 200); //devo fare il load prima altrimenti il controller risulta vuoto
        Stage stage = new Stage();
        stage.setTitle("Info AlunniGest");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void nuovo(ActionEvent event) throws IOException, ParseException {
        FXMLLoader fxmlLoader = new FXMLLoader(AlunniApplication.class.getResource("nuovo.fxml"));
        Parent p = fxmlLoader.load();

        ControllerNuovo controller = fxmlLoader.<ControllerNuovo>getController();
        controller.setModel(this.model);
        //this.model = controller.getModel();

        Stage stage = new Stage();
        Scene scene = new Scene(p, 700, 400);
        stage.setTitle("Inserisci Alunno");
        stage.setScene(scene);
        stage.show();

        //intercetta la chiusura della finestra e aggiorna
        stage.setOnHiding( e -> {

            tablePrincipale.getItems().clear();
            for (int i = 0; i < this.model.size(); i++) {
                tablePrincipale.getItems().add(this.model.get(i));
            }
            //tablePrincipale.refresh();

        } );
    }


    @FXML
    void initialize()
    {
        assert btnElimina != null : "fx:id=\"btnElimina\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert btnNuovo != null : "fx:id=\"btnNuovo\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert btnSalva != null : "fx:id=\"btnSalva\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert colClasse != null : "fx:id=\"colClasse\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert colCognome != null : "fx:id=\"colCognome\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert colId != null : "fx:id=\"colId\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert colNome != null : "fx:id=\"colNome\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert tabDettagli != null : "fx:id=\"tabDettagli\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert tabGenerale != null : "fx:id=\"tabGenerale\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert tablePrincipale != null : "fx:id=\"tablePrincipale\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert txtClasse != null : "fx:id=\"txtClasse\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert txtIndirizzo != null : "fx:id=\"txtIndirizzo\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert txtNato != null : "fx:id=\"txtNato\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'alunni-view.fxml'.";
        assert txtSesso != null : "fx:id=\"txtSesso\" was not injected: check your FXML file 'alunni-view.fxml'.";

        /**
         * Icone veloci
         */
        Image nuovo = new Image(getClass().getResourceAsStream("img/file-new-icon.png"));
        Image salva = new Image(getClass().getResourceAsStream("img/save-file-icon.png"));
        Image elimina = new Image(getClass().getResourceAsStream("img/remove-icon.png"));
        btnNuovo.setGraphic(new ImageView(nuovo));
        btnSalva.setGraphic(new ImageView(salva));
        btnElimina.setGraphic(new ImageView(elimina));

        //Creo il match logico campi tabella/classe: ricprds di creare metodi set/get nella classe corrispondente
        colId.setCellValueFactory(new PropertyValueFactory<Alunno, Integer>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<Alunno, String>("nome"));
        colCognome.setCellValueFactory(new PropertyValueFactory<Alunno, String>("cognome"));
        colClasse.setCellValueFactory(new PropertyValueFactory<Alunno, String>("classe"));

        tablePrincipale.setPlaceholder(new Label("Non ci sono alunni da mostrare"));
        this.txtSesso.setItems(FXCollections.observableArrayList(Sesso.values()));

        /*
        * Questo è il listener del cambio tab, in modo da aggiornare i campi di input rispetto alla linea della tabella
        */
        tabDettagli.setOnSelectionChanged(e ->
        {
            Alunno a = tablePrincipale.getSelectionModel().getSelectedItem();
            if (a != null)
            {
                this.txtId.setText(String.valueOf(a.getId()));
                this.txtClasse.setText(a.getClasse());
                this.txtCognome.setText(a.getCognome());
                this.txtNato.setValue(a.getNascita());
                this.txtNome.setText(a.getNome());
                this.txtIndirizzo.setText(a.getIndirizzo());
                this.txtSesso.setValue(a.getSesso());
            }
        });

    }

    public void setModel(Model m)
    {
        this.model = m;
    }
    
    public void initData() throws IOException, ParseException
    {
        //Carico i dati dalla sorgente
        model.leggi();
        for (int i=0; i < model.size(); i++)
        {
            tablePrincipale.getItems().add(model.get(i));
        }
    }
}

