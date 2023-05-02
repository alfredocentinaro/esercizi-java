package iis.alessandrini.tabellefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class AlunniApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ParseException {
        Model model = new Model();

        FXMLLoader fxmlLoader = new FXMLLoader(AlunniApplication.class.getResource("alunni-view.fxml"));
        Parent p = fxmlLoader.load();

        Controller controller = fxmlLoader.<Controller>getController();
        controller.setModel(model);
        controller.initData();

        //Scene scene = new Scene(fxmlLoader.load(), 600, 400); devo fare il load prima altrimenti il controller risulta vuoto
        Scene scene = new Scene(p, 700, 350);
        stage.setTitle("Gestione Alunni");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
