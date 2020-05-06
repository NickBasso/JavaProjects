package core;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Arrays;

public class Main extends Application {

    static Pane root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Graphs");
        primaryStage.setScene(new Scene(root, 1000, 650));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void printDistancesTable(String[][] stringDistance){
        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(stringDistance));
        data.remove(0);//remove titles from data
        TableView<String[]> table = new TableView<String[]>();
        table.setLayoutX(20);
        table.setLayoutY(230);
        table.setEditable(false);

        for (int i = 0; i < stringDistance[0].length; i++) {
            TableColumn tc = new TableColumn(stringDistance[0][i]);
            final int colNo = i;
            tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            tc.setPrefWidth(90);
            tc.setSortable(false);

            if(i == 0){
                tc.setStyle("-fx-font-weight: bold;  -fx-alignment: center;");
            } else {
                tc.setStyle("-fx-alignment: center;");
            }

            table.getColumns().add(tc);
        }
        table.setItems(data);
        root.getChildren().add(table);
    }

    public static void printGraphCentersTable(String[][] GraphCentersTable){
        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(GraphCentersTable));
        data.remove(0);//remove titles from data
        TableView<String[]> table = new TableView<String[]>();
        table.setLayoutX(420);
        table.setLayoutY(230);
        table.setEditable(false);

        for (int i = 0; i < GraphCentersTable[0].length; i++) {
            TableColumn tc = new TableColumn(GraphCentersTable[0][i]);
            final int colNo = i;
            tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            tc.setPrefWidth(90);
            tc.setSortable(false);

            if(i == 0){
                tc.setStyle("-fx-font-weight: bold;  -fx-alignment: center;");
            } else {
                tc.setStyle("-fx-alignment: center;");
            }

            table.getColumns().add(tc);
        }
        table.setItems(data);
        root.getChildren().add(table);
    }
}
