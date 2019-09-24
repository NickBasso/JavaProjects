package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    //Employee JohnBollocks = new Employee("John", "Bollocks", "Manager", 24, 13821.78);
    //JohnBollocks.printSalary();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("goodtogo");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        Employee JohnBollocks = new Employee("John", "Bollocks", "Manager", 24, 13821.78);
        JohnBollocks.printSalary();
    }
}
