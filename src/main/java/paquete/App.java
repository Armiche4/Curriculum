package paquete;




import controlador.MainControlador;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	
	private MainControlador vista;
	
	private static Stage primaryStage;




	@Override
	public void start(Stage primaryStage) throws Exception {
		
		App.primaryStage = primaryStage;
		
		vista = new MainControlador();
		
		Scene scene = new Scene(vista.getView());
		
		primaryStage.setTitle("Curriculum");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("/images/cv64x64.png") );
		
		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	


	public static final Stage getPrimaryStage() {
		return primaryStage;
	}

	
}
