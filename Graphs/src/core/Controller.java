package core;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    // Create node
    public Button CreateNodeButton;
    public Button AddNodeButton;
    public TextField NodeNameTextField;
    public TextField NodeWeightTextField;

    // Create edge
    public Button CreateEdgeButton;
    public Button AddEdgeButton;
    public TextField EdgeOneNameTextField;
    public TextField EdgeTwoNameTextField;
    public TextField EdgeWeightTextField;

    // Check
    public static boolean isFindGraphCenterClicked = false;

    // Initialize graph
    WeightedGraph graph = new WeightedGraph();

    // Start application initial settings
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize(URL url, ResourceBundle resourceBundle) worked!");

        // create node init
        CreateNodeButton.setVisible(true);
        NodeNameTextField.setDisable(true);
        NodeNameTextField.setText("");
        AddNodeButton.setVisible(true);
        AddNodeButton.setDisable(true);

        // create edge init
        CreateEdgeButton.setVisible(true);
        EdgeOneNameTextField.setDisable(true);
        EdgeOneNameTextField.setText("");
        EdgeTwoNameTextField.setDisable(true);
        EdgeTwoNameTextField.setText("");
        EdgeWeightTextField.setDisable(true);
        AddEdgeButton.setVisible(true);
        AddEdgeButton.setDisable(true);

    }

    // Button controllers

    public void handleFindGraphCentersButtonOnAction(){
        System.out.println("handleFindGraphCentersButtonOnAction() worked!");
        isFindGraphCenterClicked = true;

        WeightedGraph.drive();
    }

    public void handleResetEdgeInputButtonMouseClicked(){
        System.out.println("handleResetEdgeInputButtonMousceClicked() worked!");

        CreateEdgeButton.setDisable(false);
        CreateEdgeButton.setVisible(true);

        EdgeOneNameTextField.setText("");
        EdgeOneNameTextField.setDisable(true);

        EdgeTwoNameTextField.setText("");
        EdgeTwoNameTextField.setDisable(true);

        EdgeWeightTextField.setText("");
        EdgeWeightTextField.setDisable(true);

        AddEdgeButton.setVisible(true);
        AddEdgeButton.setDisable(true);
    }

    public void handleAddEdgeButtonClick(){
        System.out.println("handleAddEdgeButtonClick() worked!");

        String EdgeOneName = EdgeOneNameTextField.getText();
        String EdgeTwoName = EdgeTwoNameTextField.getText();
        String EdgeWeight = EdgeWeightTextField.getText();
        WeightedGraph.Edge edge = new WeightedGraph.Edge(EdgeOneName, EdgeTwoName, Long.valueOf(EdgeWeight));

        System.out.println("Edge " + EdgeOneName + " to " + EdgeTwoName + " with weight " + EdgeWeight+ " added!");

        graph.Edges.add(edge);

        graph.edges++;

        EdgeOneNameTextField.setText("");
        EdgeOneNameTextField.setDisable(true);

        EdgeTwoNameTextField.setText("");
        EdgeTwoNameTextField.setDisable(true);

        EdgeWeightTextField.setText("");
        EdgeWeightTextField.setDisable(true);

        AddEdgeButton.setDisable(true);
        CreateEdgeButton.setDisable(false);
    }

    public void handleEnterEdgeWeightOnKeyTyped(){
        System.out.println("handleEnterEdgeWeightOnKeyTyped() worked!");

        if(isPositiveNumeric(EdgeWeightTextField.getText()) == true){
            String EdgeOneName = EdgeOneNameTextField.getText();
            String EdgeTwoName = EdgeTwoNameTextField.getText();
            String edgeWeight = EdgeWeightTextField.getText();
            WeightedGraph.Edge edge = new WeightedGraph.Edge(EdgeOneName, EdgeTwoName, Long.valueOf(edgeWeight));

            if(EdgeOneName.length() > 0 && EdgeTwoName.length() > 0
                    && !EdgeOneName.equals(EdgeTwoName) && WeightedGraph.VerticesContainsName(EdgeOneName)
                    && WeightedGraph.VerticesContainsName(EdgeTwoName)
                    && graph.EdgeExists(EdgeOneName, EdgeTwoName) == false){
                AddEdgeButton.setDisable(false);
            } else {
                AddEdgeButton.setDisable(true);
            }
        } else {
            AddEdgeButton.setDisable(true);
        }
    }

    public void handleEnterEdgeOneNameOnKeyTyped(){
        System.out.println("handleEnterEdgeOneNameOnKeyTyped() worked!");

        if(isPositiveNumeric(EdgeWeightTextField.getText()) == true){
            String EdgeOneName = EdgeOneNameTextField.getText();
            String EdgeTwoName = EdgeTwoNameTextField.getText();
            String edgeWeight = EdgeWeightTextField.getText();
            WeightedGraph.Edge edge = new WeightedGraph.Edge(EdgeOneName, EdgeTwoName, Long.valueOf(edgeWeight));

            if(EdgeOneName.length() > 0 && EdgeTwoName.length() > 0
                    && !EdgeOneName.equals(EdgeTwoName) && WeightedGraph.VerticesContainsName(EdgeOneName)
                    && WeightedGraph.VerticesContainsName(EdgeTwoName)
                    && graph.EdgeExists(EdgeOneName, EdgeTwoName) == false){
                AddEdgeButton.setDisable(false);
            } else {
                AddEdgeButton.setDisable(true);
            }
        } else {
            AddEdgeButton.setDisable(true);
        }
    }

    public void handleEnterEdgeTwoNameOnKeyTyped(){
        System.out.println("handleEnterEdgeTwoNameOnKeyTyped() worked!");

        if(isPositiveNumeric(EdgeWeightTextField.getText()) == true){
            String EdgeOneName = EdgeOneNameTextField.getText();
            String EdgeTwoName = EdgeTwoNameTextField.getText();
            String edgeWeight = EdgeWeightTextField.getText();
            WeightedGraph.Edge edge = new WeightedGraph.Edge(EdgeOneName, EdgeTwoName, Long.valueOf(edgeWeight));

            if(EdgeOneName.length() > 0 && EdgeTwoName.length() > 0
                    && !EdgeOneName.equals(EdgeTwoName) && WeightedGraph.VerticesContainsName(EdgeOneName)
                    && WeightedGraph.VerticesContainsName(EdgeTwoName)
                    && graph.EdgeExists(EdgeOneName, EdgeTwoName) == false){
                AddEdgeButton.setDisable(false);
            } else {
                AddEdgeButton.setDisable(true);
            }
        } else {
            AddEdgeButton.setDisable(true);
        }
    }

    public void handleCreateEdgeButtonClick(){
        System.out.println("Create edge button worked!");

        EdgeOneNameTextField.setText("");
        EdgeOneNameTextField.setDisable(false);

        EdgeTwoNameTextField.setText("");
        EdgeTwoNameTextField.setDisable(false);

        EdgeWeightTextField.setText("");
        EdgeWeightTextField.setDisable(false);

        CreateEdgeButton.setDisable(true);
    }

    public void handleResetAllMouseClicked(){
        System.out.println("handleResetAllMouseClicked() worked!");

        CreateNodeButton.setDisable(false);
        CreateNodeButton.setVisible(true);

        NodeNameTextField.setDisable(true);
        NodeNameTextField.setText("");

        AddNodeButton.setVisible(true);
        AddNodeButton.setDisable(true);
    }

    public void handleCreateNodeButtonClick(){
        System.out.println("handleCreateNodeButtonClick() worked!");

        NodeNameTextField.setDisable(false);
        NodeNameTextField.setText("");

        CreateNodeButton.setDisable(true);
    }

    public void handleEnterNodeNameOnKeyTyped(){
        System.out.println("handleEnterNodeNameOnKeyTyped() worked!");

        String NodeName = NodeNameTextField.getText();
        //WeightedGraph.Vertex vertex = new WeightedGraph.Vertex(-1, NodeName);

        if(NodeName.length() > 0 && graph.VerticesContainsName(NodeName) == false){
            AddNodeButton.setDisable(false);
        } else {
            AddNodeButton.setDisable(true);
        }
    }

    public void handleAddNodeButtonClick(){
        System.out.println("handleAddNodeButtonClick() worked!");

        if(!NodeNameTextField.getText().equals("")) {
            System.out.println("Node " + NodeNameTextField.getText() + " added!");

            WeightedGraph.Vertex vertex = new WeightedGraph.Vertex(graph.vertices + 1, NodeNameTextField.getText());
            graph.Vertices.add(vertex);
            graph.vertices++;
        } else {
            System.out.println("How did you fool my \"Add node\" logic!?");
        }

        NodeNameTextField.setText("");
        NodeNameTextField.setDisable(true);

        AddNodeButton.setDisable(true);
        CreateNodeButton.setDisable(false);
    }

    ///////////////////////// Non-controller methods /////////////////////////

    public static boolean isPositiveNumeric(String a){
        return a.matches("\\d+");
    }

    public static boolean isIntegerString(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            long x = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
