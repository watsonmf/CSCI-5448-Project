package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * Created by awomack on 4/13/16.
 */
public class Preferences {

    static boolean answer;

    public  static boolean display(String title, String message)
    {
        Stage window = new Stage();

        window.initModality((Modality.APPLICATION_MODAL));
        window.setTitle(title);
        window.setMinWidth(325);
        window.setMinHeight(450);

        Label label = new Label();
        label.setText(message);
        label.setStyle("-fx-text-fill: #e8e8e8");   /*AMBER*/

        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");
        saveButton.setOnAction(e ->
        {
            answer = true;
            window.close();
        });
        cancelButton.setOnAction(e ->
        {
            answer = false;
            window.close();
        });
        /*Creating the Drop Down Menu for selecting a Login Name*/
        ChoiceBox<String> dropDownMenu = new ChoiceBox<>();
        /*Need to load in all the login names stored in the system*/
        dropDownMenu.getItems().add("blue");
        dropDownMenu.getItems().add("red");
        dropDownMenu.getItems().addAll("white","black");

        VBox backgroundLayout = new VBox(25);
        backgroundLayout.getChildren().add(dropDownMenu);
        backgroundLayout.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();

        HBox buttonLayout = new HBox(10);
        buttonLayout.getChildren().addAll(saveButton, cancelButton);
        buttonLayout.setAlignment(Pos.CENTER);

        StackPane titleLayout = new StackPane();
        titleLayout.getChildren().add(label);
        titleLayout.setAlignment(Pos.CENTER);
        borderPane.setTop(titleLayout);
        borderPane.setCenter(dropDownMenu);
        borderPane.setBottom(buttonLayout);

        borderPane.setPadding(new Insets(10,10,20,10));
        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add("Style.css");    /*Amber*/

        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
