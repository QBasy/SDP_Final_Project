/*package Singleton_Adapter_Window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Window extends Application {
    private static Window instance;
    public static Window getInstance() {
        if (instance == null) {
            return new Window();
        } else {
            return instance;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        Label label = new Label("Hello, JavaFX!");

        Scene scene = new Scene(label, 300, 200);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}*/
