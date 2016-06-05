package tools.hexapod.heXchat.client;

import java.io.InputStream;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainClient extends Application {

	private static Client client;
	private static ObservableList<String> onlineUsers;
	private static TextArea inputText;
	private static TextArea messagesArea;
	
	public static void main(String[] args) {
		//client=new Client("localhost",3235);
		//client.connect();
		onlineUsers = FXCollections.observableArrayList (
			    "Вася", "Петя", "Коля", "Маша");
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("heXchat");
		primaryStage.getIcons().add(new Image("file:resources/images/icon.png"));
		primaryStage.setScene(createScene());
		primaryStage.show();

	}

	public Scene createScene() {
		HBox box = new HBox();
		
		ListView<String> onlineList=new ListView<String>();
		onlineList.setItems(onlineUsers);
		box.getChildren().add(onlineList);

		VBox rightBox = new VBox();
		
		HBox boxMessageEditor = new HBox();
		
		inputText = new TextArea();
		messagesArea = new TextArea();
		boxMessageEditor.getChildren().add(inputText);
		
		Image imageSend = new Image("file:resources/images/icon.png"); 
		Button buttonSend = new Button("",new ImageView(imageSend));
		
		buttonSend.setOnAction(new EventHandler<ActionEvent>() {
			//@Override 
		    public void handle(ActionEvent e) {
		        //System.out.println();
		        messagesArea.appendText(inputText.getText()+"\n");//inputText.getText());
		        inputText.setText("");
		        
		    }
		    
		});
		
		boxMessageEditor.getChildren().add(buttonSend);
		
		rightBox.getChildren().add(messagesArea);
		rightBox.getChildren().add(boxMessageEditor);
		
		box.getChildren().add(rightBox);
		
		Scene scene=new Scene(box, 800, 600);
		scene.getStylesheets().add("/tools/hexapod/heXchat/client/LightTheme.css");
		return scene;

	}


}
