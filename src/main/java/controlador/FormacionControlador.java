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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
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
import modelo.Telefono;
import modelo.Titulo;

public class FormacionControlador implements Initializable {

	//model
	
	//private ObjectProperty<Titulo> titulo = new SimpleObjectProperty<>(new Titulo());
	private ListProperty<Titulo>tituloLista=new SimpleListProperty<Titulo>(FXCollections.observableArrayList());
	
	//vista
	  @FXML
	    private SplitPane formacionVista;

	    @FXML
	    private TableView<Titulo> formacionTable;

	    @FXML
	    private TableColumn<Titulo, LocalDate> desdeColum;

	    @FXML
	    private TableColumn<Titulo, LocalDate> hastaColum;

	    @FXML
	    private TableColumn<Titulo, String> denominacionColum;

	    @FXML
	    private TableColumn<Titulo, String>  organizacionColum;

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
        dialog.setTitle("Nuevo Titulo");
   
    	
        // Set the button types.
       ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
       ButtonType ok = new ButtonType("OK");
        dialog.getDialogPane().getButtonTypes().addAll(ok, ButtonType.CANCEL);
              
        
       dialog.getDialogPane().setContent(nuevaVista);
       
       //dialog.showAndWait();
        
       Pair result= new Pair<>(nuevaDenominacion.getText(), nuevaOrganizador.getText());
     
  
         dialog.showAndWait();
      
        
        
        if (result!=null){
    	    
        	
        	//hastaColum.setCellValueFactory(new PropertyValueFactory<>(""));
        	
    		//organizacionColum.setCellValueFactory(new PropertyValueFactory<>("organizador"));
        	//denominacionColum.setCellValueFactory(new PropertyValueFactory<>("denominacion"));
        	
    		 	    		 	    	
    	    
    	    
    	    Titulo titulo = new Titulo() ;
    	  
    	   titulo.setdenominacion(nuevaDenominacion.getText());
    	  titulo.setorganizador(nuevaOrganizador.getText()); 
    	  titulo.setDesde(nuevoDesde.getValue());
    	  titulo.setHasta(nuevoHasta.getValue());
    
    	  tituloLista.add(titulo);
    	  
    	  //  formacionTable.getItems().add(titulo);
    	
    	   
    	}
    	
    }

    

    @FXML
    void onEliminarAction(ActionEvent event) {

    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Comfirmar borrado");
    	alert.setHeaderText("¿Seguro que quieres borrar?");
    	alert.setContentText(formacionTable.getSelectionModel().getSelectedItem().getdenominacion() +" se eliminara");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		formacionTable.getItems().remove(formacionTable.getSelectionModel().getSelectedItem());
    	} 
    	
    	
    	
    	
    }
    
    public final SplitPane getFormacionVista() {
		return formacionVista;
	}
    
    
	
    public FormacionControlador () throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/FormacionView.fxml"));
    	
    	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/NuevoTituloVista.fxml"));
    	loader2.setController(this);
		   loader.setController(this);
			
			loader.load();
			loader2.load();
    	
    }
    
    
    
    
    
	public void initialize(URL location, ResourceBundle resources) {
		
		
		formacionTable.itemsProperty().bindBidirectional(tituloLista);
		denominacionColum.setCellValueFactory(v->v.getValue().getdenominacionProperty());
		organizacionColum.setCellValueFactory(v->v.getValue().getorganizadorProperty());
		desdeColum.setCellValueFactory(v->v.getValue().getDesde());
		hastaColum.setCellValueFactory(v->v.getValue().getHasta());
		
		//denominacionColum.setCellFactory(TextFieldTableCell.forTableColumn());
		//organizacionColum.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		
	}





	public final ListProperty<Titulo> TituloListaProperty() {
		return this.tituloLista;
	}
	

	public final ObservableList<Titulo> getTituloLista() {
		return this.TituloListaProperty().get();
	}
	

	public final void setExperiencias(final ObservableList<Titulo> titulo) {
		this.TituloListaProperty().set(titulo);
	}
	

	
	
	
}
