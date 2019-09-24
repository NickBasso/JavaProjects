package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        primaryStage.setTitle("Test JavaFX");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Employee JohnBollocks = new Employee("John", "Bollocks", "Manager", 24, 13821.78);
        JohnBollocks.printSalary();
        JohnBollocks.printAge();
        JohnBollocks.printName();
        JohnBollocks.printSurname();
        JohnBollocks.printRole();

        JohnBollocks.setSalary(25000.212);
        JohnBollocks.printSalary();

        launch(args);
    }
}
