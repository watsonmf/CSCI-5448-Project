package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Confirmation
{
    static boolean answer;

    public  static boolean display(String title, String message)
    {
        Stage window = new Stage();

        window.initModality((Modality.APPLICATION_MODAL));
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(150);

        Label label = new Label();
        label.setText(message);
        label.setStyle("-fx-text-fill: #e8e8e8");   /*AMBER*/

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setOnAction(e ->
        {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e ->
        {
            answer = false;
            window.close();
        });


        BorderPane borderPane = new BorderPane();

        HBox buttonLayout = new HBox(10);
        buttonLayout.getChildren().addAll(yesButton, noButton);
        buttonLayout.setAlignment(Pos.CENTER);

        StackPane titleLayout = new StackPane();
        titleLayout.getChildren().add(label);
        titleLayout.setAlignment(Pos.CENTER);
        borderPane.setTop(titleLayout);
        borderPane.setBottom(buttonLayout);

        borderPane.setPadding(new Insets(10,10,20,10));
        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add("Style.css");    /*Amber*/

        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
