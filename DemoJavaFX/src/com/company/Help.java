package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Help
{
    public  static void display(String title, String message)
    {
        Stage window = new Stage();

        window.initModality((Modality.APPLICATION_MODAL));
        //block interactions with other windows until this window is dealt with
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(150);

        Label label = new Label();
        label.setText(message);
        label.setStyle("-fx-text-fill: #e8e8e8");   /*AMBER*/

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("Style.css");    /*Amber*/

        window.setScene(scene);
        window.showAndWait();

    }
}
