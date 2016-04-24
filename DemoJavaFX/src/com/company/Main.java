package com.company;
import java.util.Properties;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tenjinMath.Lesson;
import tenjinMath.Module;
import tenjinMath.ModuleFactory;
import tenjinMath.Student;
import tenjinMath.Tenjin;
import tenjinMath.User;

public class Main extends Application implements EventHandler<ActionEvent>
{
    Stage window;
    Scene loginPage, homePage,createAccountPage, additionLessonPage;
    int index = 0;
    Button startLessonButton = new Button("Start Lesson");
    Button quitButton = new Button("Quit");
    Button nextButton = new Button("Next");
    Button prevButton = new Button("Prev");
    Button submitButton = new Button("Submit");
    Button helpButton = new Button("Help");
    ListView modulesOptions = new ListView();
    
 	private static final String configFileName = "Tenjin.config";
 	private static Properties tenjinProperties;
 	private static User currentUser;
 	private static Module currentModule;
 	private static Lesson currentLesson;

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

        /*
        *
        *
        * LOGIN PAGE
        *
        *
        */
        /*Create buttons for login page*/
        Button loginButton = new Button("Login");
        Button createButton = new Button("Create Account");
        Button exitButton = new Button("Exit");

        /*Creating the Drop Down Menu for selecting a Login Name*/
        ChoiceBox<String> dropDownMenu = new ChoiceBox<>();
        /*Need to load in all the login names stored in the system*/
        String[] loginNames = Tenjin.getUserList();
        
        for(int i = 0; i < loginNames.length; i++)
        {
            dropDownMenu.getItems().add(loginNames[i]);
        }

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



        /*
        *
        *
        * CREATE ACCOUNT PAGE
        *
        *
        */
        /*Create the main buttons for the Login page and the Create Account page*/
        Button cancelButton = new Button("Cancel");
        Button saveButton = new Button("Create Account");

        /*Grade level check boxes*/                 /*Amber*/
        ToggleGroup gradeLevel = new ToggleGroup();
        RadioButton gradek = new RadioButton("K");
        gradek.setToggleGroup(gradeLevel);
        gradek.setStyle("-fx-text-fill: #e8e8e8");

        RadioButton grade1 = new RadioButton("1");
        grade1.setToggleGroup(gradeLevel);
        grade1.setStyle("-fx-text-fill: #e8e8e8");

        RadioButton grade2 = new RadioButton("2");
        grade2.setToggleGroup(gradeLevel);
        grade2.setStyle("-fx-text-fill: #e8e8e8");

        RadioButton grade3 = new RadioButton("3");
        grade3.setToggleGroup(gradeLevel);
        grade3.setStyle("-fx-text-fill: #e8e8e8");

        RadioButton grade4 = new RadioButton("4");
        grade4.setToggleGroup(gradeLevel);
        grade4.setStyle("-fx-text-fill: #e8e8e8");

        RadioButton grade5 = new RadioButton("5");
        grade5.setToggleGroup(gradeLevel);
        grade5.setStyle("-fx-text-fill: #e8e8e8");

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
        
        HBox gradeLevelLayout = new HBox(15);
        gradeLevelLayout.getChildren().addAll(gradek, grade1, grade2, grade3, grade4, grade5);
        gradeLevelLayout.setAlignment(Pos.CENTER);

        VBox gradeLevelLabelLayout = new VBox(10);
        Label gradeLevelLabel = new Label("Select Level");
        gradeLevelLabel.setStyle("-fx-text-fill: #e8e8e8");
        gradeLevelLabelLayout.getChildren().addAll(gradeLevelLabel,gradeLevelLayout);
        gradeLevelLabelLayout.setAlignment(Pos.CENTER_LEFT);
        createAccountBorderPane.setCenter(gradeLevelLabelLayout);

        createAccountBorderPane.setPadding(new Insets(40,10,45,10));
        createAccountPage = new Scene(createAccountBorderPane, 325, 450);
        createAccountPage.getStylesheets().add("Style.css"); /*Amber*/


        /*
        *
        * HOME PAGE
        *
        *
        */
        /*Create buttons for home page*/
        Button logOutButton = new Button("Log Out");
        Button prefButton = new Button("Preferences"); //Amber
        Button viewProgressButton = new Button("View Progress");
        Button resumeLessonButton = new Button("Resume Lesson");

        /*if (!something is lesson in progress)*/
        resumeLessonButton.setDisable(true);

        /*creating the layout and look of the Home Page*/
        BorderPane homePageBorderPane = new BorderPane();

        VBox homePageLayout = new VBox(30);
        homePageLayout.getChildren().addAll(logOutButton, prefButton); //amber
        homePageLayout.setAlignment(Pos.TOP_CENTER);

        homePageBorderPane.setRight(homePageLayout);

        HBox homePageBottomLayout = new HBox(190);
        homePageBottomLayout.getChildren().addAll(viewProgressButton,startLessonButton,resumeLessonButton); //amber
        homePageBottomLayout.setAlignment(Pos.CENTER);
        homePageBorderPane.setBottom(homePageBottomLayout);

        Label homeLabel = new Label("Welcome to Tenjin!");
        homeLabel.setStyle("-fx-text-fill: #e8e8e8");
        StackPane homeLayout = new StackPane();
        homeLayout.getChildren().add(homeLabel); //amber
        homeLayout.setAlignment(Pos.CENTER);
        homePageBorderPane.setTop(homeLayout);
        
        /*Creating the Drop Down Menu for selecting a Module*/
        modulesOptions.getItems().addAll(ModuleFactory.getModuleNames());
        modulesOptions.setMinSize(130,190);
        modulesOptions.setMaxSize(130,190);
        
        Label moduleLabel = new Label("Select a Module");
        moduleLabel.setStyle("-fx-text-fill: #e8e8e8");
        VBox ModulesLayout = new VBox(25);
        ModulesLayout.getChildren().addAll(moduleLabel, modulesOptions);
        ModulesLayout.setAlignment(Pos.TOP_LEFT);
        homePageBorderPane.setLeft(ModulesLayout);
        
        homePageBorderPane.setPadding(new Insets(45,45,45,45));
        homePage = new Scene(homePageBorderPane, 800, 600);
        homePage.getStylesheets().add("Style.css"); /*Amber*/
        
        
        /*
        *
        * LESSON PAGE
        *
        *
        */
        /*Creating the Lesson Page*/
        
        
        /*
        * SET ACTION ON BUTTONS
        *
        *
        */
        /*Set actions for when the buttons are pressed at Login*/
        loginButton.setOnAction(e ->
        {
      	  	currentUser = new Student(dropDownMenu.getValue());
      	  	
            window.setTitle("Tenjin - Home Page");
            window.setScene(homePage);
        });
        createButton.setOnAction(e ->
        {
            window.setTitle("Tenjin - Create Account");
            window.setScene(createAccountPage);
        });
        exitButton.setOnAction(e ->
        {
            boolean answer = Confirmation.display("Tenjin - Quit", "Are you sure you want to quit?                                 ");
            if (answer)
                window.close();
        });
        
        /*Create Account buttons*/
        cancelButton.setOnAction(e ->
        {
            window.setTitle("Tenjin - Login");
            window.setScene(loginPage);
        });
        saveButton.setOnAction(e ->
        {
            /*Save profile, create profile object with information*/
      	  currentUser = new Student(uNameInput.getText());
      	  currentUser.setProperty("userName", uNameInput.getText());
      	  currentUser.setProperty("firstName", fNameInput.getText());
      	  
      	  RadioButton rb = (RadioButton)gradeLevel.getSelectedToggle();
      	  
      	  currentUser.setProperty("gradeLevel", rb.getText());
      	  
           String[] userNames = Tenjin.getUserList();
           dropDownMenu.getItems().clear();
           
           for(int i = 0; i < userNames.length; i++)
           {
               dropDownMenu.getItems().add(userNames[i]);
           }
      	  
            window.setTitle("Tenjin - Home Page");
            window.setScene(homePage);
        });
        
        /*Home Page buttons*/
        logOutButton.setOnAction(e ->
        {
            window.setTitle("Tenjin - Login");
            window.setScene(loginPage);
        });
        prefButton.setOnAction(e ->
        {
            boolean answer = Preferences.display("Tenjin - Preferences", "Select your background color."); //Amber
            if(answer)
                System.out.println("We need to save their preferences at this point");
        });
        startLessonButton.setOnAction(this);

        /*Lesson page buttons*/
        helpButton.setOnAction(e -> Help.display("Tenjin - Help", "Yes, you do need a lot of help"                           ));
        quitButton.setOnAction(e -> {
            boolean answer = Confirmation.display("Tenjin - Quit", "Are you sure you want to quit?                          ");
            if(answer)
            {
                window.setTitle("Tenjin - Home Page");
                window.setScene(homePage);
            }
        });

        /*Initial scene*/
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
        boolean answer = Confirmation.display("Tenjin - Quit", "Are you sure you want to quit?                                ");
        if(answer)
        {
            System.out.println("Save to file, progress stored");
            window.close();
        }
    }
    
    @Override
    public void handle(ActionEvent event)
    {
        if(event.getSource() == startLessonButton)
        {
            currentModule = ModuleFactory.getModule(modulesOptions.getSelectionModel().getSelectedItem().toString() , currentUser);

            //modulesOptions.getSelectionModel().getSelectedItem().
            if(currentModule != null)
            {
                currentLesson = currentModule.getLesson();
                window.setTitle("Tenjin - " + currentLesson.getLessonTitle());
                
                Label questionListLabel = new Label(currentLesson.getLessonTitle());
                questionListLabel.setStyle("-fx-text-fill: #e8e8e8");
                ListView<String> questionList = new ListView<>();
                for (int i = 0; i < currentLesson.getNumberOfQuestions(); i++)
                {
                    questionList.getItems().add(currentLesson.getQuestion(i).getShortQuestion());
                }
                //questionList.getItems().addAll("1 + 1 = ", "1 + 2 = ", "1 + 3 = ");
                //This is where we load all the question strings into the ListView

                VBox questionLayout = new VBox();
                questionLayout.getChildren().addAll(questionListLabel,questionList);
                questionLayout.setAlignment(Pos.TOP_LEFT);
                questionLayout.setPadding(new Insets(60, 20, 20, 20));

                HBox progressButtonLayout = new HBox(45);
                progressButtonLayout.getChildren().addAll(prevButton, nextButton, submitButton);
                progressButtonLayout.setAlignment(Pos.BASELINE_CENTER);
                progressButtonLayout.setPadding( new Insets(20, 20, 20, 20) );

                HBox quitHelpButtonLayout = new HBox(45);
                quitHelpButtonLayout.getChildren().addAll(helpButton, quitButton);
                quitHelpButtonLayout.setAlignment(Pos.TOP_RIGHT);
                quitHelpButtonLayout.setPadding(new Insets(80, 45, 45, 45));
                
                Label answerLabel = new Label("Insert your answer");
                answerLabel.setStyle("-fx-text-fill: #e8e8e8");
                TextField answerInput = new TextField();
                
                TextArea questionDisplay = new TextArea();
                questionDisplay.setEditable(false);
                questionDisplay.setMinSize(200,300);
                //questionDisplay.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                
                questionDisplay.setStyle(""
                        + "-fx-font-size: 50px;"
                        + "-fx-font-style: italic;"
                        + "-fx-font-weight: bold;"
                        + "-fx-font-family: fantasy;");
                String[] question = questionList.getItems().get(index).split("\\s+");
                //Text formatQuestion = new Text(question[0]+"\n"+question[1]+" "+question[2]+"\n"+"----------\n");
                Text formatQuestion = new Text(currentLesson.getQuestion(index).getLongQuestion());
                formatQuestion.setTextAlignment(TextAlignment.CENTER);
                questionDisplay.setText(formatQuestion.getText());

                VBox questionDisplayLayout = new VBox(15);
                questionDisplayLayout.getChildren().addAll(questionDisplay, answerLabel, answerInput);
                questionDisplayLayout.setPadding(new Insets(80,0,0,0));
                questionDisplayLayout.setAlignment(Pos.CENTER);

                BorderPane additionLessonBorderPane = new BorderPane();
                additionLessonBorderPane.setLeft(questionLayout);
                additionLessonBorderPane.setBottom(progressButtonLayout);
                additionLessonBorderPane.setRight(quitHelpButtonLayout);
                additionLessonBorderPane.setCenter(questionDisplayLayout);

                additionLessonPage = new Scene(additionLessonBorderPane, 800, 600);
                additionLessonBorderPane.getStylesheets().add("Style.css");
                questionList.getSelectionModel().select(index);
                
                answerInput.setOnAction(e -> {
               	 nextButton.fire();
                });
                
                submitButton.setOnAction(e -> {
               	 boolean answer = Confirmation.display("Tenjin - Submit", "Would you like to submit your lesson for grading?");
                   if (answer)
                   {
                  	 boolean[] results = currentLesson.gradeLesson();
                  	 int numCorrect = 0;
                  	 
                  	 for (int i = 0; i < currentLesson.getNumberOfQuestions(); i++)
                  	 {
                  		 if (results[i] == true)
                  		 {
                  			 questionList.getItems().set(i, "\u2713 " + currentLesson.getQuestion(i).getShortQuestion());
                  			 numCorrect++;
                  		 } else
                  		 {
                  			 questionList.getItems().set(i, "\u2717 " + currentLesson.getQuestion(i).getShortQuestion());
                  		 }
                  	 }
                  	 
                      questionDisplay.setStyle(""
                            + "-fx-font-size: 20px;"
                            + "-fx-font-style: italic;"
                            + "-fx-font-weight: bold;"
                            + "-fx-font-family: fantasy;");
                      questionDisplay.setText(new Text("Results:\n\nCorrect - " + numCorrect + "\nWrong - " + (currentLesson.getNumberOfQuestions() - numCorrect)).getText());
                  	 
                  	 prevButton.setVisible(false);
                  	 nextButton.setVisible(false);
                  	 submitButton.setVisible(false);
                  	 answerInput.setVisible(false);
                  	 answerLabel.setVisible(false);
                       //window.setScene(homePage);
                   }
                });
                
                nextButton.setOnAction(e -> {
               	 if (answerInput.getText() != null)
               	 {
               		 currentLesson.getQuestion(index).storeAnswer(answerInput.getText());
               		 answerInput.setText(null);
               		 questionList.getItems().set(index, currentLesson.getQuestion(index).getShortQuestion());
               	 }
               	 
               	 //questionList.getItems().add(currentLesson.getQuestion(i).getShortQuestion());
               	 if (index == currentLesson.getNumberOfQuestions() - 1)
               	 {
                      submitButton.fire();
               	 } else
               	 {
               		 index++;
               		 questionList.getSelectionModel().select(index);
               		 Text formatQuestion2 = new Text(currentLesson.getQuestion(index).getLongQuestion());
                      formatQuestion2.setTextAlignment(TextAlignment.CENTER);
                      questionDisplay.setText(formatQuestion2.getText());
               	 }
               	 answerInput.requestFocus();
                });
                
                prevButton.setOnAction(e -> {
               	 if (answerInput.getText() != null)
               	 {
               		 currentLesson.getQuestion(index).storeAnswer(answerInput.getText());
               		 answerInput.setText(null);
               		 questionList.getItems().set(index, currentLesson.getQuestion(index).getShortQuestion());
               	 }
               	 if (index > 0)
               	 {
               		 index--;
               		 questionList.getSelectionModel().select(index);
               		 Text formatQuestion2 = new Text(currentLesson.getQuestion(index).getLongQuestion());
                      formatQuestion2.setTextAlignment(TextAlignment.CENTER);
                      questionDisplay.setText(formatQuestion2.getText());
               	 }
               	 answerInput.requestFocus();
                });
                
                window.setScene(additionLessonPage);
                answerInput.requestFocus();


            }
            else
                System.out.println("Wait for the update patch for extended usability");
        }
    }

}
