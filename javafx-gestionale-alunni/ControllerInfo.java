package iis.alessandrini.tabellefx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerInfo {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView img;

    @FXML
    void initialize() {
        assert img != null : "fx:id=\"img\" was not injected: check your FXML file 'info.fxml'.";

        Image image = new Image(getClass().getResourceAsStream("img/logo.png"));
        img.setImage(image);
    }

}
