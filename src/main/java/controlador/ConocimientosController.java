package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Pair;
import modelo.Conocimiento;
import modelo.Contacto;
import modelo.Idioma;
import modelo.Telefono;


public class ConocimientosController implements Initializable {

	//model
	
	private ListProperty<Conocimiento> conocimiento=new SimpleListProperty<Conocimiento>(FXCollections.observableArrayList());
	
		
		//vista principal
	
	
	 @FXML
	    private HBox vista;

	    @FXML
	    private TableView<Conocimiento> conocimientoTable;

	    @FXML
	    private TableColumn<Conocimiento, String> denominacionColum;

	    @FXML
	    private TableColumn<Conocimiento.Nivel, String> nivelColum;

	    @FXML
	    private Button conocimientoBoton;

	    @FXML
	    private Button idiomaBoton;

	    @FXML
	    private Button eliminarBoton;
	    
	    //vista nuevo conocimiento
	    
	    @FXML
	    private GridPane nuevaVistaConocimiento;

	    @FXML
	    private TextField nuevaDenominacionConocimiento;

	    @FXML
	    private ComboBox<Conocimiento.Nivel> nuevoNivelConocimiento;

	    @FXML
	    private Button botonQuitarConocimiento;
	    
	    // vista nuevo idioma
	    
	    
	    @FXML
	    private GridPane nuevaVistaIdioma;

	    @FXML
	    private TextField nuevaDenominacionIdioma;

	    @FXML
	    private TextField nuevaCertificacionIdioma;

	    @FXML
	    private ComboBox<Conocimiento.Nivel> nuevoNivelIdioma;

	    @FXML
	    private Button botonQuitarIdioma;

	    @FXML
	    void onbotonQuitarIdiomaAction(ActionEvent event) {
	    	nuevoNivelIdioma.setValue(null);
	    	
	    }

	    @FXML
	    void onbotonQuitarConocimientoAction(ActionEvent event) {

	    	nuevoNivelConocimiento.setValue(null);
	    
	    	
	    }

	    @FXML
	    void onAnadirConocimientoAction(ActionEvent event) {

	    	// Create the custom dialog.
	        Dialog<Pair<String, String>> dialog = new Dialog<>();
	        dialog.setTitle("Nuevo Conocimiento");
	   
	    	
	        // Set the button types.
	       ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
	     
	        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
	        nuevoNivelConocimiento.getItems().setAll(Conocimiento.Nivel.values());     
	        
	       dialog.getDialogPane().setContent(nuevaVistaConocimiento);
	      
	       
	       //dialog.showAndWait();
	        
	     
	     
	  
	       Optional<Pair<String, String>> result = dialog.showAndWait();
	       
	       
	        if (result.isPresent()){
	    	    
	        	
	    		 	    		 	    	
	    	    Conocimiento cono = new Conocimiento() ;
	    	   
	    	    cono.setdenominacion(nuevaDenominacionConocimiento.getText());
	    	    cono.setNivel(nuevoNivelConocimiento.getValue());
	    	    
	    	    conocimientoTable.getItems().add(cono);
	    	 //revisar que se añade aunque no se pulse ok
	    	   
	    	  
	    	}
	       
	       
	    	
	    	
	    }

	    @FXML
	    void onAnadirIdioma(ActionEvent event) {
	    	
	    	// Create the custom dialog.
	        Dialog<Pair<String, String>> dialog = new Dialog<>();
	        dialog.setTitle("Nuevo Idioma");
	   
	    	
	        // Set the button types.
	       ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
	     
	        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
	        nuevoNivelIdioma.getItems().setAll(Conocimiento.Nivel.values());
	        
	       dialog.getDialogPane().setContent(nuevaVistaIdioma);
	       
	       //dialog.showAndWait();
	        
	     //  Pair result= new Pair<>(nuevaDenominacion.getText(), nuevaOrganizador.getText());
	     
	  
	       Optional<Pair<String, String>> result = dialog.showAndWait();
	       
	       
	        if (result.isPresent()){
	    	    
	        	
	    		 	    		 	    	
	    	    Conocimiento cono = new Conocimiento() ;
	    	   
	    	    cono.setdenominacion(nuevaDenominacionIdioma.getText());
	    	    cono.setNivel(nuevoNivelIdioma.getValue());
	    	    
	    	    conocimientoTable.getItems().add(cono);
	    	 //revisar que se añade aunque no se pulse ok
	    	   
	    	  
	    	}
	    	

	    }

	    @FXML
	    void onEliminarAction(ActionEvent event) {

	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Comfirmar borrado");
	    	alert.setHeaderText("¿Seguro que quieres borrar?");
	    	alert.setContentText(conocimientoTable.getSelectionModel().getSelectedItem().getdenominacion()+" se eliminara");

	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    		conocimientoTable.getItems().remove(conocimientoTable.getSelectionModel().getSelectedItem());
	    	} 
	    	
	    	
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			
			conocimientoTable.itemsProperty().bindBidirectional(conocimiento);
			//denominacionColum.setCellValueFactory(v->v.getValue().getidioma());
			denominacionColum.setCellValueFactory(v->v.getValue().getdenominacionProperty());
			//nivelColum.setCellValueFactory(v->v.getValue().getNivel().get());
			nivelColum.setCellValueFactory(new PropertyValueFactory<>("nivel"));
			
			
		}
	
		public ConocimientosController() throws IOException {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ConocimientosView.fxml"));
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/NuevoConocimientoVista.fxml"));
			FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/NuevoIdiomaVista.fxml"));
			
		 	loader2.setController(this);
		 	loader3.setController(this);
			   loader.setController(this);
				
				loader.load();
				loader2.load();
				loader3.load();
		}
		
		
		public final ListProperty<Conocimiento> conocimientoProperty() {
			return this.conocimiento;
		}
		


		public final ObservableList<Conocimiento> getConocimiento() {
			return this.conocimientoProperty().get();
		}
		


		public final void setConocimiento(final ObservableList<Conocimiento> conocimiento) {
			this.conocimientoProperty().set(conocimiento);
		}

		public final HBox getVista() {
			return vista;
		}
		
		
}
