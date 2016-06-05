package tools.hexapod.heXchat.server;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class ServerMain extends Application {

	private static Server server;
		
	public static void main(String[] args) {
		int port = 3235;
		server=new Server(port);
		server.setDaemon(true);
		server.start();	
		launch(args);
	
	}
		

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Client");
		primaryStage.setScene(createScene());
		primaryStage.show();

	}

		public Scene createScene() {
			HBox box = new HBox();
			box.getChildren().add(new Button("Start"));
			return new Scene(box, 200, 100);

		}
}
