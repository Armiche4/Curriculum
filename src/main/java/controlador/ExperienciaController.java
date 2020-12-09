package controlador;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Pair;
import modelo.Contacto;
import modelo.Experiencia;
import modelo.Personal;
import modelo.Telefono;
import modelo.Web;


public class ExperienciaController implements Initializable {

	
	//model
	
	//private ObjectProperty<Experiencia> experiencia = new SimpleObjectProperty<>(new Experiencia());
	private ListProperty<Experiencia> experiencia = new SimpleListProperty<Experiencia>(FXCollections.observableArrayList());
	
	
	//vista
	  @FXML
	    private HBox vista;

	    @FXML
	    private TableView<Experiencia> experienciaTable;

	    @FXML
	    private TableColumn<Experiencia, LocalDate> desdeColum;

	    @FXML
	    private TableColumn<Experiencia, LocalDate> hastaColum;

	    @FXML
	    private TableColumn<Experiencia, String> DenominacionColum;

	    @FXML
	    private TableColumn<Experiencia, String> empleadorColum;

	    @FXML
	    private Button anadirBoton;

	    @FXML
	    private Button eliminarBoton;
	    
	    //vista desplegable
	    
	    @FXML
	    private GridPane nuevaVista;

	    @FXML
	    private TextField nuevaDenominacion;

	    @FXML
	    private TextField nuevaOrganizador;

	    @FXML
	    private DatePicker nuevoDesde;

	    @FXML
	    private DatePicker nuevoHasta;

	
	    
	    

	    @FXML
	    void onAnadirAction(ActionEvent event) {

	    	// Create the custom dialog.
	        Dialog<Pair<String, String>> dialog = new Dialog<>();
	        dialog.setTitle("Nueva Experiencia");
	   
	    	
	        // Set the button types.
	       ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
	       ButtonType ok = new ButtonType("OK");
	        dialog.getDialogPane().getButtonTypes().addAll(ok, ButtonType.CANCEL);
	              
	        
	       dialog.getDialogPane().setContent(nuevaVista);
	       
	       //dialog.showAndWait();
	       Optional<Pair<String, String>> result = dialog.showAndWait();
	        
	       // loginButtonType( e->onAñadirTelefonoAction());
	        
	        if (result.isPresent()){
	    	    
	        	//DenominacionColum.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
	        	//empleadorColum.setCellValueFactory(new PropertyValueFactory<>("empleador"));
	        	
	       
	    	    Experiencia exp = new Experiencia() ;
	    	   
	    	    exp.setdenominacion(nuevaDenominacion.getText());
	    	    exp.setempleador(nuevaOrganizador.textProperty().get());
	    	    exp.setDesde(nuevoDesde.getValue());
	    	    exp.setHasta(nuevoHasta.getValue());
	    	    
	    	    //experienciaTable.getItems().add(exp);
	    	    experiencia.add(exp);
	    	 //revisar que se añade aunque no se pulse ok
	    	}      
	      
	     
	  
	    	
	    }

	    @FXML
	    void onEliminarAction(ActionEvent event) {

	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Comfirmar borrado");
	    	alert.setHeaderText("¿Seguro que quieres borrar?");
	    	alert.setContentText(experienciaTable.getSelectionModel().getSelectedItem().getdenominacion() +" se eliminara");

	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    		experienciaTable.getItems().remove(experienciaTable.getSelectionModel().getSelectedItem());
	    	} 
	    	
	    	
	    	
	    	
	    }

		public final HBox getVista() {
			return vista;
		}
		
		public final ListProperty<Experiencia> experienciasProperty() {
			return this.experiencia;
		}
		

		public final ObservableList<Experiencia> getExperiencias() {
			return this.experienciasProperty().get();
		}
		

		public final void setExperiencias(final ObservableList<Experiencia> experiencias) {
			this.experienciasProperty().set(experiencias);
		}
		    
		

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			experienciaTable.itemsProperty().bind(experiencia);
			
			
			DenominacionColum.setCellValueFactory(v->v.getValue().getdenominacionProperty() );
			empleadorColum.setCellValueFactory(v->v.getValue().getempleadorProperty());	
			desdeColum.setCellValueFactory(v->v.getValue().getDesde());
			hastaColum.setCellValueFactory(v->v.getValue().getHasta());
			
		 	//DenominacionColum.setCellFactory(TextFieldTableCell.forTableColumn());
        	//empleadorColum.setCellFactory(TextFieldTableCell.forTableColumn());
    		 	    		 	    	
			
		}
	    
		public ExperienciaController () throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ExperienciaView.fxml"));
	    	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/NuevoExperienciaVista.fxml"));
	    	loader2.setController(this);
			   loader.setController(this);
				
				loader.load();
				loader2.load();
	    	
	    	
	    	
	    }


	
	
}
