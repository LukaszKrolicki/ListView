package com.example.listview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Label selectedLabel = new Label();
        Button selectFirst = new Button("Select First");
        ListView<String> list = new ListView<String>();
        ObservableList<String> names = FXCollections.observableArrayList("Patrick","Michael","" +
                "KEN");
        list.getItems().addAll(names);
        list.getSelectionModel().selectedItemProperty().addListener(observable -> {
            selectedLabel.setText(list.getSelectionModel().getSelectedItem());
        });

        selectFirst.setOnAction(e->list.getSelectionModel().selectFirst());

        //setting properties
        //list.setOrientation(Orientation.HORIZONTAL);
        //list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //multiple selection with ctrl pressed
        root.getChildren().addAll(selectedLabel,list,selectFirst);
        Scene scene = new Scene(root,500,500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}