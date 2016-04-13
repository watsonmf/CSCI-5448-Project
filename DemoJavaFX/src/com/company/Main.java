package com.company;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application
{

    Stage window;
    Scene loginPage, homePage,createAccountPage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        /*Set the main window for the GUI with the title*/
        window = primaryStage;
        window.setTitle("Tenjin - Login");

        /*Create the main buttons for the Login page and the Create Account page*/
        Button loginButton = new Button("Login");
        Button createButton = new Button("Create Account");
        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Create Account");
        Button logOutButton = new Button("Log Out");
        Button exitButton = new Button("Exit");
        /*Practice for creating a separate window*/
        Button helpButton = new Button("Help");

        /*Grade level check boxes*/                 /*Amber*/
        CheckBox gradek = new CheckBox("K");
        gradek.setStyle("-fx-text-fill: #e8e8e8");

        CheckBox grade1 = new CheckBox("1");
        grade1.setStyle("-fx-text-fill: #e8e8e8");

        CheckBox grade2 = new CheckBox("2");
        grade2.setStyle("-fx-text-fill: #e8e8e8");

        CheckBox grade3 = new CheckBox("3");
        grade3.setStyle("-fx-text-fill: #e8e8e8");

        CheckBox grade4 = new CheckBox("4");
        grade4.setStyle("-fx-text-fill: #e8e8e8");

        CheckBox grade5 = new CheckBox("5");
        grade5.setStyle("-fx-text-fill: #e8e8e8");

        /*Set actions for when the buttons are pressed*/
        loginButton.setOnAction(e ->
        {
            window.setTitle("Tenjin - Home Page");
            window.setScene(homePage);
        });
        createButton.setOnAction(e ->
        {
            window.setTitle("Tenjin - Create Account");
            window.setScene(createAccountPage);
        });
        cancelButton.setOnAction(e ->
        {
            window.setTitle("Tenjin - Login");
            window.setScene(loginPage);
        });
        saveButton.setOnAction(e ->
        {
            /*Save profile, create profile object with information*/
            window.setTitle("Tenjin - Home Page");
            window.setScene(homePage);
        });
        logOutButton.setOnAction(e ->
        {
            window.setTitle("Tenjin - Login");
            window.setScene(loginPage);
        });
        exitButton.setOnAction(e ->
        {
            boolean answer = Confirmation.display("Tenjin - Quit", "Are you sure you want to quit?");
            if(answer)
                window.close();
        });

        /*Practice for creating a separate window*/
        helpButton.setOnAction(e -> Help.display("Tenjin - Help", "Yes, you do need a lot of help"));

        /*Creating the Drop Down Menu for selecting a Login Name*/
        ChoiceBox<String> dropDownMenu = new ChoiceBox<>();
        /*Need to load in all the login names stored in the system*/
        dropDownMenu.getItems().add("anwomack");
        dropDownMenu.getItems().add("eeakins");
        dropDownMenu.getItems().addAll("mwatkins","balfano");


        /*Creating the layout and look of the Login Page*/
        BorderPane loginBorderPane = new BorderPane();

        VBox loginLayout = new VBox(25);
        loginLayout.getChildren().addAll(dropDownMenu,loginButton);
        loginLayout.setAlignment(Pos.CENTER);

        HBox loginLayout2 = new HBox(30);
        loginLayout2.getChildren().addAll(createButton,exitButton);
        loginLayout2.setAlignment(Pos.CENTER);

        loginBorderPane.setCenter(loginLayout);
        loginBorderPane.setBottom(loginLayout2);

        loginBorderPane.setPadding(new Insets(10,10,45,10));
        loginPage = new Scene(loginBorderPane, 325, 450);
        loginPage.getStylesheets().add("Style.css");        /*Amber*/

        /*Creating the layout and look of the Create Account Page*/
        BorderPane createAccountBorderPane = new BorderPane();

        /*Create the form fields for the Create Account Page*/
        Label uNameLabel = new Label("Username");
        uNameLabel.setStyle("-fx-text-fill: #e8e8e8");
        TextField uNameInput = new TextField();
        Label fNameLabel = new Label("First Name");
        fNameLabel.setStyle("-fx-text-fill: #e8e8e8");
        TextField fNameInput = new TextField();

        VBox nameInputLayout = new VBox(20);
        nameInputLayout.getChildren().addAll(uNameInput,uNameLabel,fNameInput,fNameLabel);
        nameInputLayout.setAlignment(Pos.CENTER_LEFT);

        HBox createAccountLayout = new HBox(25);
        createAccountLayout.getChildren().addAll(saveButton,cancelButton);
        createAccountLayout.setAlignment(Pos.CENTER);

        createAccountBorderPane.setTop(nameInputLayout);
        createAccountBorderPane.setBottom(createAccountLayout);

        createAccountBorderPane.setPadding(new Insets(40,10,45,10));
        createAccountPage = new Scene(createAccountBorderPane, 325, 450);
        createAccountPage.getStylesheets().add("Style.css"); /*Amber*/

         /*AMBER*/

        HBox gradeLevelLayout = new HBox(15);
        gradeLevelLayout.getChildren().addAll(gradek, grade1, grade2, grade3, grade4, grade5);
        gradeLevelLayout.setAlignment(Pos.CENTER);
        createAccountBorderPane.setCenter(gradeLevelLayout);

        /*creating the layout and look of the Home Page*/
        BorderPane homePageBorderPane = new BorderPane();

        HBox homePageLayout = new HBox(40);
        homePageLayout.getChildren().addAll(logOutButton,helpButton);
        homePageLayout.setAlignment(Pos.CENTER);

        homePageBorderPane.setBottom(homePageLayout);

        homePageBorderPane.setPadding(new Insets(10,10,45,10));
        homePage = new Scene(homePageBorderPane, 800, 600);
        homePage.getStylesheets().add("Style.css"); /*Amber*/

        window.setScene(loginPage);
        window.setOnCloseRequest(e ->
        {
            e.consume();
            closeProgram();
        });
        window.show();
    }

    private void closeProgram()
    {
        boolean answer = Confirmation.display("Tenjin - Quit", "Are you sure you want to quit?");
        if(answer)
        {
            System.out.println("Save to file, progress stored");
            window.close();
        }
    }

}
