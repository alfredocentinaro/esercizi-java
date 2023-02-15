package iis.tris;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

    private Tavolo tavolo;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem btnAnnulla;

    @FXML
    private MenuItem btnInfo;

    @FXML
    private Label casella0;

    @FXML
    private Label casella1;

    @FXML
    private Label casella2;

    @FXML
    private Label casella3;

    @FXML
    private Label casella4;

    @FXML
    private Label casella5;

    @FXML
    private Label casella6;

    @FXML
    private Label casella7;

    @FXML
    private Label casella8;
    @FXML
    private Label lblMessaggio;
    @FXML
    void annulla(ActionEvent event) {
        int ultima = this.tavolo.getUltimaCarta();
        switch(ultima)
        {
            case 0:
                casella0.setText("");
                this.tavolo.get(0).setScelta(Scelta.Vuota);
                break;
            case 1:
                casella1.setText("");
                this.tavolo.get(1).setScelta(Scelta.Vuota);
                break;
            case 2:
                casella2.setText("");
                this.tavolo.get(2).setScelta(Scelta.Vuota);
                break;
            case 3:
                casella3.setText("");
                this.tavolo.get(3).setScelta(Scelta.Vuota);
                break;
            case 4:
                casella4.setText("");
                this.tavolo.get(4).setScelta(Scelta.Vuota);
                break;
            case 5:
                casella5.setText("");
                this.tavolo.get(5).setScelta(Scelta.Vuota);
                break;
            case 6:
                casella6.setText("");
                this.tavolo.get(6).setScelta(Scelta.Vuota);
                break;
            case 7:
                casella7.setText("");
                this.tavolo.get(7).setScelta(Scelta.Vuota);
                break;
            case 8:
                casella8.setText("");
                this.tavolo.get(8).setScelta(Scelta.Vuota);
                break;


        }

        //scambio il turno
        if (this.tavolo.getTurno() == Turno.Giocatore_O)
            this.tavolo.setTurno(Turno.Giocatore_X);
        else
            this.tavolo.setTurno(Turno.Giocatore_O);
    }

    @FXML
    void chiudi(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void click0(MouseEvent event)
    {
        if (this.tavolo.get(0).getScelta() != Scelta.Vuota)
            return;

        if (this.tavolo.getTurno() == Turno.Giocatore_O)
        {

            casella0.setText("O");
            casella0.setStyle("-fx-text-fill:RED; -fx-font-size: 60;");
            this.tavolo.get(0).setScelta(Scelta.O);
            this.tavolo.setTurno(Turno.Giocatore_X);
        }
        else
        {
            casella0.setText("X");
            casella0.setStyle("-fx-text-fill:BLUE; -fx-font-size: 60;");
            this.tavolo.get(0).setScelta(Scelta.X);
            this.tavolo.setTurno(Turno.Giocatore_O);
        }

        if (this.tavolo.controllaVincitore())
        {
            this.lblMessaggio.setText("Giocatore " + this.tavolo.vincitore() + " ha vinto!" );
        }
        else
            this.lblMessaggio.setText("E' il turno di " + this.tavolo.getTurno());

        tavolo.setUltimaCarta(0);

    }

    @FXML
    void click1(MouseEvent event)
    {
        if (this.tavolo.get(1).getScelta() != Scelta.Vuota)
            return;

        if (this.tavolo.getTurno() == Turno.Giocatore_O)
        {
            casella1.setText("O");
            casella1.setStyle("-fx-text-fill:RED; -fx-font-size: 60;");
            this.tavolo.get(1).setScelta(Scelta.O);
            this.tavolo.setTurno(Turno.Giocatore_X);
        }
        else
        {
            casella1.setText("X");
            casella1.setStyle("-fx-text-fill:BLUE; -fx-font-size: 60;");
            this.tavolo.get(1).setScelta(Scelta.X);
            this.tavolo.setTurno(Turno.Giocatore_O);
        }

        if (this.tavolo.controllaVincitore())
        {
            this.lblMessaggio.setText("Giocatore " + this.tavolo.vincitore() + " ha vinto!" );
        }
        else
            this.lblMessaggio.setText("E' il turno di " + this.tavolo.getTurno());

        tavolo.setUltimaCarta(1);
    }

    @FXML
    void click2(MouseEvent event)
    {
        if (this.tavolo.get(2).getScelta() != Scelta.Vuota)
            return;

        if (this.tavolo.getTurno() == Turno.Giocatore_O)
        {
            casella2.setText("O");
            casella2.setStyle("-fx-text-fill:RED; -fx-font-size: 60;");
            this.tavolo.get(2).setScelta(Scelta.O);
            this.tavolo.setTurno(Turno.Giocatore_X);
        }
        else
        {
            casella2.setText("X");
            casella2.setStyle("-fx-text-fill:BLUE; -fx-font-size: 60;");
            this.tavolo.get(2).setScelta(Scelta.X);
            this.tavolo.setTurno(Turno.Giocatore_O);
        }

        if (this.tavolo.controllaVincitore())
        {
            this.lblMessaggio.setText("Giocatore " + this.tavolo.vincitore() + " ha vinto!" );
        }
        else
            this.lblMessaggio.setText("E' il turno di " + this.tavolo.getTurno());

        tavolo.setUltimaCarta(2);
    }

    @FXML
    void click3(MouseEvent event)
    {
        if (this.tavolo.get(3).getScelta() != Scelta.Vuota)
            return;

        if (this.tavolo.getTurno() == Turno.Giocatore_O)
        {
            casella3.setText("O");
            casella3.setStyle("-fx-text-fill:RED; -fx-font-size: 60;");
            this.tavolo.get(3).setScelta(Scelta.O);
            this.tavolo.setTurno(Turno.Giocatore_X);
        }
        else
        {
            casella3.setText("X");
            casella3.setStyle("-fx-text-fill:BLUE; -fx-font-size: 60;");
            this.tavolo.get(3).setScelta(Scelta.X);
            this.tavolo.setTurno(Turno.Giocatore_O);
        }

        if (this.tavolo.controllaVincitore())
        {
            this.lblMessaggio.setText("Giocatore " + this.tavolo.vincitore() + " ha vinto!" );
        }
        else
            this.lblMessaggio.setText("E' il turno di " + this.tavolo.getTurno());

        tavolo.setUltimaCarta(3);
    }

    @FXML
    void click4(MouseEvent event)
    {
        if (this.tavolo.get(4).getScelta() != Scelta.Vuota)
            return;

        if (this.tavolo.getTurno() == Turno.Giocatore_O)
        {
            casella4.setText("O");
            casella4.setStyle("-fx-text-fill:RED; -fx-font-size: 60;");
            this.tavolo.get(4).setScelta(Scelta.O);
            this.tavolo.setTurno(Turno.Giocatore_X);
        }
        else
        {
            casella4.setText("X");
            casella4.setStyle("-fx-text-fill:BLUE; -fx-font-size: 60;");
            this.tavolo.get(4).setScelta(Scelta.X);
            this.tavolo.setTurno(Turno.Giocatore_O);
        }

        if (this.tavolo.controllaVincitore())
        {
            this.lblMessaggio.setText("Giocatore " + this.tavolo.vincitore() + " ha vinto!" );
        }
        else
            this.lblMessaggio.setText("E' il turno di " + this.tavolo.getTurno());

        tavolo.setUltimaCarta(4);
    }

    @FXML
    void click5(MouseEvent event)
    {
        if (this.tavolo.get(5).getScelta() != Scelta.Vuota)
            return;

        if (this.tavolo.getTurno() == Turno.Giocatore_O)
        {
            casella5.setText("O");
            casella5.setStyle("-fx-text-fill:RED; -fx-font-size: 60;");
            this.tavolo.get(5).setScelta(Scelta.O);
            this.tavolo.setTurno(Turno.Giocatore_X);
        }
        else
        {
            casella5.setText("X");
            casella5.setStyle("-fx-text-fill:BLUE; -fx-font-size: 60;");
            this.tavolo.get(5).setScelta(Scelta.X);
            this.tavolo.setTurno(Turno.Giocatore_O);
        }

        if (this.tavolo.controllaVincitore())
        {
            this.lblMessaggio.setText("Giocatore " + this.tavolo.vincitore() + " ha vinto!" );
        }
        else
            this.lblMessaggio.setText("E' il turno di " + this.tavolo.getTurno());

        tavolo.setUltimaCarta(5);
    }

    @FXML
    void click6(MouseEvent event)
    {
        if (this.tavolo.get(6).getScelta() != Scelta.Vuota)
            return;

        if (this.tavolo.getTurno() == Turno.Giocatore_O)
        {
            casella6.setText("O");
            casella6.setStyle("-fx-text-fill:RED; -fx-font-size: 60;");
            this.tavolo.get(6).setScelta(Scelta.O);
            this.tavolo.setTurno(Turno.Giocatore_X);
        }
        else
        {
            casella6.setText("X");
            casella6.setStyle("-fx-text-fill:BLUE; -fx-font-size: 60;");
            this.tavolo.get(6).setScelta(Scelta.X);
            this.tavolo.setTurno(Turno.Giocatore_O);
        }

        if (this.tavolo.controllaVincitore())
        {
            this.lblMessaggio.setText("Giocatore " + this.tavolo.vincitore() + " ha vinto!" );
        }
        else
            this.lblMessaggio.setText("E' il turno di " + this.tavolo.getTurno());

        tavolo.setUltimaCarta(6);
    }

    @FXML
    void click7(MouseEvent event)
    {
        if (this.tavolo.get(7).getScelta() != Scelta.Vuota)
            return;

        if (this.tavolo.getTurno() == Turno.Giocatore_O)
        {
            casella7.setText("O");
            casella7.setStyle("-fx-text-fill:RED; -fx-font-size: 60;");
            this.tavolo.get(7).setScelta(Scelta.O);
            this.tavolo.setTurno(Turno.Giocatore_X);
        }
        else
        {
            casella7.setText("X");
            casella7.setStyle("-fx-text-fill:BLUE; -fx-font-size: 60;");
            this.tavolo.get(7).setScelta(Scelta.X);
            this.tavolo.setTurno(Turno.Giocatore_O);
        }

        if (this.tavolo.controllaVincitore())
        {
            this.lblMessaggio.setText("Giocatore " + this.tavolo.vincitore() + " ha vinto!" );
        }
        else
            this.lblMessaggio.setText("E' il turno di " + this.tavolo.getTurno());

        tavolo.setUltimaCarta(7);
    }

    @FXML
    void click8(MouseEvent event)
    {
        if (this.tavolo.get(8).getScelta() != Scelta.Vuota)
            return;

        if (this.tavolo.getTurno() == Turno.Giocatore_O)
        {
            casella8.setText("O");
            casella8.setStyle("-fx-text-fill:RED; -fx-font-size: 60;");
            this.tavolo.get(8).setScelta(Scelta.O);
            this.tavolo.setTurno(Turno.Giocatore_X);
        }
        else
        {
            casella8.setText("X");
            casella8.setStyle("-fx-text-fill:BLUE; -fx-font-size: 60;");
            this.tavolo.get(8).setScelta(Scelta.X);
            this.tavolo.setTurno(Turno.Giocatore_O);
        }

        if (this.tavolo.controllaVincitore())
        {
            this.lblMessaggio.setText("Giocatore " + this.tavolo.vincitore() + " ha vinto!" );
        }
        else
            this.lblMessaggio.setText("E' il turno di " + this.tavolo.getTurno());

        tavolo.setUltimaCarta(8);
    }

    @FXML
    void info(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TrisApplication.class.getResource("info.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500 , 200);
        Stage stage = new Stage();
        stage.setTitle("Info JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void nuovapartita(ActionEvent event)
    {
        this.tavolo.nuovaPartita();
        casella0.setText("");
        casella1.setText("");
        casella2.setText("");
        casella3.setText("");
        casella4.setText("");
        casella5.setText("");
        casella6.setText("");
        casella7.setText("");
        casella8.setText("");

    }

    @FXML
    void initialize() {
        assert btnAnnulla != null : "fx:id=\"btnAnnulla\" was not injected: check your FXML file 'tris-view.fxml'.";
        assert btnInfo != null : "fx:id=\"btnInfo\" was not injected: check your FXML file 'tris-view.fxml'.";
        assert casella0 != null : "fx:id=\"casella0\" was not injected: check your FXML file 'tris-view.fxml'.";
        assert casella1 != null : "fx:id=\"casella1\" was not injected: check your FXML file 'tris-view.fxml'.";
        assert casella2 != null : "fx:id=\"casella2\" was not injected: check your FXML file 'tris-view.fxml'.";
        assert casella3 != null : "fx:id=\"casella3\" was not injected: check your FXML file 'tris-view.fxml'.";
        assert casella4 != null : "fx:id=\"casella4\" was not injected: check your FXML file 'tris-view.fxml'.";
        assert casella5 != null : "fx:id=\"casella5\" was not injected: check your FXML file 'tris-view.fxml'.";
        assert casella6 != null : "fx:id=\"casella6\" was not injected: check your FXML file 'tris-view.fxml'.";
        assert casella7 != null : "fx:id=\"casella7\" was not injected: check your FXML file 'tris-view.fxml'.";
        assert casella8 != null : "fx:id=\"casella8\" was not injected: check your FXML file 'tris-view.fxml'.";

        this.tavolo = new Tavolo();
        this.tavolo.inserisci(new Casella(0, Scelta.Vuota));
        this.tavolo.inserisci(new Casella(1, Scelta.Vuota));
        this.tavolo.inserisci(new Casella(2, Scelta.Vuota));
        this.tavolo.inserisci(new Casella(3, Scelta.Vuota));
        this.tavolo.inserisci(new Casella(4, Scelta.Vuota));
        this.tavolo.inserisci(new Casella(5, Scelta.Vuota));
        this.tavolo.inserisci(new Casella(6, Scelta.Vuota));
        this.tavolo.inserisci(new Casella(7, Scelta.Vuota));
        this.tavolo.inserisci(new Casella(8, Scelta.Vuota));

        this.tavolo.setTurno(Turno.Giocatore_O); //TO DO: imposta giocatore iniziale casuale
    }

}
