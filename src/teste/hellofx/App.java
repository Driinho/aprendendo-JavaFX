package teste.hellofx;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teste.hellofx.classes.Sistema;

public class App extends Application {

    private static Stage stage;

    private static Scene loginScene;
    private static Scene cadastroScene;
    private static Scene menuScene;
    public static Sistema sistema = new Sistema("Login");

    URL loginFXML = getClass().getResource("/teste/hellofx/layout/layoutLogin.fxml");
    URL cadastroFXML = getClass().getResource("/teste/hellofx/layout/layoutCadastro.fxml");
    URL menuFXML = getClass().getResource("/teste/hellofx/layout/layoutMenu.fxml");

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("Login");

        Parent fxmlLogin = FXMLLoader.load(loginFXML);
        loginScene = new Scene(fxmlLogin);

        Parent fxmlCadastro = FXMLLoader.load(cadastroFXML);
        cadastroScene = new Scene(fxmlCadastro);

        Parent fxmlMenu = FXMLLoader.load(menuFXML);
        menuScene = new Scene(fxmlMenu);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void trocarTela(int tela) {
        switch (tela) {
            case 1:
                stage.setScene(loginScene);
                break;

            case 2:
                stage.setScene(cadastroScene);
                break;

            case 3:
                stage.setScene(menuScene);
                break;
        }
    }
}
