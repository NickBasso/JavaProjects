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

    public Button CreateNodeButton;
    public Button AddNodeButton;
    public TextField NodeNameTextField;
    public TextField NodeWeightTextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CreateNodeButton.setVisible(true);

        NodeNameTextField.setDisable(true);
        NodeNameTextField.setText("");

        NodeWeightTextField.setDisable(true);
        NodeWeightTextField.setText("");

        AddNodeButton.setVisible(true);
        AddNodeButton.setDisable(true);

    }

    public void handleResetAllMouseClicked(){
        System.out.println("Reset all mouse clicked!");

        CreateNodeButton.setDisable(false);
        CreateNodeButton.setVisible(true);

        NodeNameTextField.setDisable(true);
        NodeNameTextField.setText("");

        NodeWeightTextField.setDisable(true);
        NodeWeightTextField.setText("");

        AddNodeButton.setVisible(true);
        AddNodeButton.setDisable(true);
    }

    public void handleCreateNodeButtonClick(){
        System.out.println("Create node button clicked!");
        NodeNameTextField.setDisable(false);
        NodeNameTextField.setText("");

        NodeWeightTextField.setDisable(false);
        NodeWeightTextField.setText("");

        CreateNodeButton.setDisable(true);
        /*if(button.getText() == "Button clicked"){
            button.setText("OK");
        } else {
            button.setText("Button clicked");
        }

        //button.setVisible(false);*/

        //Button button = new Button("Hello bitch");
    }

    public void handleEnterNodeNameOnKeyTyped(){
        String NodeName = NodeNameTextField.getText();
        String nodeWeight = NodeWeightTextField.getText();
        System.out.println("On key typed worked!");

        if(NodeName.length() > 0 && nodeWeight.length() > 0 && isIntegerString(nodeWeight) == true){
            AddNodeButton.setDisable(false);
        } else {
            AddNodeButton.setDisable(true);
        }
    }

    public void handleEnterNodeWeightOnKeyTyped(){
        String NodeName = NodeNameTextField.getText();
        String nodeWeight = NodeWeightTextField.getText();
        System.out.println("On key typed worked!");

        if(NodeName.length() > 0 && nodeWeight.length() > 0 && isIntegerString(nodeWeight) == true){
            AddNodeButton.setDisable(false);
        } else {
            AddNodeButton.setDisable(true);
        }
    }

    public void handleEnterNodeWeightInputChanged(){
        String NodeName = NodeNameTextField.getText();
        String nodeWeight = NodeWeightTextField.getText();
        System.out.println("On Input CHanged worked!");

        if(NodeName.length() > 0 && nodeWeight.length() > 0){
            AddNodeButton.setDisable(false);
        }
    }

    public void handleEnterNodeNameOnAction(){
        String NodeName = NodeNameTextField.getText();
        String nodeWeight = NodeWeightTextField.getText();
        System.out.println("On Action worked!");

        if(NodeName.length() > 0 && nodeWeight.length() > 0){
            AddNodeButton.setDisable(false);
        }
    }

    public void handleEnterNodeNameKeyPressed(){
        String NodeName = NodeNameTextField.getText();
        String nodeWeight = NodeWeightTextField.getText();
        System.out.println(NodeName);

        if(NodeName.length() > 0 && nodeWeight.length() > 0){
            AddNodeButton.setDisable(false);
        }
    }

    public void handleEnterNodeNameOnMouseExited(){
        String NodeName = NodeNameTextField.getText();
        String nodeWeight = NodeWeightTextField.getText();
        System.out.println(NodeName);

        if(NodeName.length() > 0 && nodeWeight.length() > 0){
            AddNodeButton.setDisable(false);
        }
    }

    public void handleEnterNodeWeightOnMouseExited(){
        String NodeName = NodeNameTextField.getText();
        String nodeWeight = NodeWeightTextField.getText();
        System.out.println(nodeWeight);

        if(NodeName.length() > 0 && nodeWeight.length() > 0){
            AddNodeButton.setDisable(false);
        }
    }

    public void handleEnterNodeNameOnTouchPressed(){
        if(NodeNameTextField.getText().equals("")){

        } else {
            System.out.println(NodeNameTextField.getText());
        }
    }

    public void handleAddNodeButtonClick(){
        System.out.println("Add node clicked!");


        if(!NodeNameTextField.getText().equals("")) {
            System.out.println("Node " + NodeNameTextField.getText() + " with Weight " + NodeWeightTextField.getText() + " added!");
        } else {
            System.out.println("How did you fool my \"Add node\" logic!?");
        }

        NodeNameTextField.setText("");
        NodeNameTextField.setDisable(true);

        NodeWeightTextField.setText("");
        NodeWeightTextField.setDisable(true);

        AddNodeButton.setDisable(true);
        CreateNodeButton.setDisable(false);
    }

    ///////////////////////// Non-controller methods /////////////////////////

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
