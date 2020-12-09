package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.GridPane;

import javafx.util.Pair;
import modelo.Contacto;
import modelo.Email;

import modelo.Telefono;
import modelo.Web;


public class ContactoController implements Initializable {

	//model
	
	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<Contacto>(new Contacto());
	
	//vista
	   @FXML
	    private SplitPane vista;	
	
	
	  @FXML
	    private TableView<Telefono> telefonoTabla;

	    @FXML
	    private Button anadirTelefeno = new Button();

	    @FXML
	    private Button eliminarTelefono = new Button();

	    @FXML
	    private TableView<Email> emailTabla;

	    @FXML
	    private Button anadirCorreo = new Button();

	    @FXML
	    private Button eliminarCorreo = new Button();

	    @FXML
	    private TableView<Web> webTabla;

	    @FXML
	    private Button anadirWeb = new Button();

	    @FXML
	    private Button eliminarWeb = new Button();
	    
	    @FXML
	    private TableColumn<Email,String> emailColumna;
	    
	    
	    @FXML
	    private TableColumn<Telefono, String> numeroColumna;

	    @FXML
	    private TableColumn<Telefono.TipoTelefono, String> tipoColumna;
	    
	    @FXML
	    private TableColumn<Web, String> webColumna;

	    @FXML
	    void OnAnadirWebAction(ActionEvent event) {


	    
	     	TextInputDialog dialog = new TextInputDialog("http://");
	    	dialog.setTitle("Nueva web");
	    	dialog.setHeaderText("Crear una nueva dirección web");
	    	dialog.setContentText("URL:");
	    	
	    	Optional<String> result = dialog.showAndWait();
	    	if (result.isPresent()){
	    
	    		webColumna.setCellValueFactory(new PropertyValueFactory<>("url"));
	    		 	    		 	    	
	    	    Web web = new Web(result.get()) ;
	    	   
	    	    contacto.get().getWeb().add(web);
	    	    
	    	   //webTabla.getItems().add(web);
	    	}
	    
	    	
	    }

	    @FXML
	    void OnEliminarCorreoAction(ActionEvent event) {

	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Comfirmar borrado");
	    	alert.setHeaderText("¿Seguro que quieres borrar?");
	    	alert.setContentText(emailTabla.getSelectionModel().getSelectedItem().getDireccion()+" se eliminara");

	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    		emailTabla.getItems().remove(emailTabla.getSelectionModel().getSelectedItem());
	    	} 
	   
	    }
	    
	    

	    @FXML
	    void OnEliminarWebAction(ActionEvent event) {

	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Comfirmar borrado");
	    	alert.setHeaderText("¿Seguro que quieres borrar?");
	    	alert.setContentText(webTabla.getSelectionModel().getSelectedItem().geturl()+" se eliminara");

	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    		webTabla.getItems().remove(webTabla.getSelectionModel().getSelectedItem());
	    	} 
	   
	    	
	    	
	    }

	    @FXML
	    void OnanadirCorreoAction(ActionEvent event) {
	    	
	    	TextInputDialog dialog = new TextInputDialog();
	    	dialog.setTitle("Nuevo e-mail");
	    	dialog.setHeaderText("Crear una nueva dirección de correo electronico");
	    	dialog.setContentText("Correo:");
	    	//dialog.showAndWait();
	    	
	    	Optional<String> result = dialog.showAndWait();
	    	if (result.isPresent()){
	    
	    		emailColumna.setCellValueFactory(new PropertyValueFactory<>("direccion"));
	    		
	    		 	    		 	    	
	    	    Email email = new Email(result.get()) ;
	    	    
	    	    contacto.get().getEmail().add(email);
	    	  // emailTabla.getItems().add(email);
	    	}
	    	

	    }

	    @FXML
	    void OneliminarTelefonoAction(ActionEvent event) {

	    	
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Comfirmar borrado");
	    	alert.setHeaderText("¿Seguro que quieres borrar?");
	    	alert.setContentText(telefonoTabla.getSelectionModel().getSelectedItem().getNumero()+" se eliminara");

	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    		telefonoTabla.getItems().remove(telefonoTabla.getSelectionModel().getSelectedItem());
	    	} 
	   
	    	
	    	
	    	
	    	
	    }

	    @FXML
	    void onanadirTelefenoAction(ActionEvent event) {

	    	// Create the custom dialog.
	        Dialog<Pair<String, String>> dialog = new Dialog<>();
	        
	        dialog.setTitle("Nuevo telefono");
	    	dialog.setHeaderText("Introduzca un nuevo número de teléfono");
	    	//dialog.setGraphic(new ImageView(this.getClass().getResource("/images/cv64x64.png").toString()));
	    	
	    	
	        // Set the button types.
	      ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);

		       Button aceptar = new Button("OK");
	        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
	        
	        TextField texto = new TextField();
	        texto.setPromptText("Número de teléfono");
	        ComboBox<Telefono.TipoTelefono> combotelefono = new ComboBox<>();
	        combotelefono.getItems().setAll(Telefono.TipoTelefono.values());
	        combotelefono.setPromptText("Selecciona un tipo");
	        
	        GridPane gridPane = new GridPane();
	        
	       gridPane.setHgap(5);
	        gridPane.setVgap(5);

	       
	        gridPane.add(new Label("Tipo Teléfono:"), 0, 0);
	        gridPane.add(combotelefono, 1, 0);
	        gridPane.add(new Label("Número:"), 0, 2);
	        gridPane.add(texto, 1, 2);
	       
	    	
	       dialog.getDialogPane().setContent(gridPane);
	        
	        //new Pair<>(texto.getText(), combotelefono.getValue());
	     
	        
	        Optional<Pair<String, String>> result = dialog.showAndWait();
	        
	       // loginButtonType( e->onAñadirTelefonoAction());
	        
	        if (result.isPresent()){
	    	    
	        	numeroColumna.setCellValueFactory(new PropertyValueFactory<>("numero"));
	        	tipoColumna.setCellValueFactory(new PropertyValueFactory<>("tipoTelefono"));
	    		 	    		 	    	
	    	    Telefono tele = new Telefono() ;
	    	   
	    	    tele.setNumero(texto.getText());
	    	    tele.setTipoTelefono(combotelefono.getValue());
	    	    
	    	   //telefonoTabla.getItems().add(tele);
	    	    contacto.get().getTelefono().add(tele);
	    	    
	    	 //revisar que se añade aunque no se pulse ok
	    	}
	    	
	    }
	
	
		public final ObjectProperty<Contacto> getContactosProperty() {
			return contacto;
		}

		
		public final Contacto getContactos() {
			return this.getContactosProperty().get();
		}

		
		public final void setContactos(Contacto contacto) {
			this.getContactosProperty().set(contacto)  ;
		}
		
	
	
	public final SplitPane getVista() {
			return vista;
		}

	

	public ContactoController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ContactoView.fxml"));
		   loader.setController(this);
			
			loader.load();
		
	}
	
	
		
	
	@Override
	public void initialize(URL location, ResourceBundle resources)  {
		contacto.addListener((o,ov,nv) ->onContatosChanged(o,ov,nv));		
		anadirTelefeno.setOnAction(e -> onanadirTelefenoAction(e));
		eliminarTelefono.setOnAction(e -> OneliminarTelefonoAction(e));
		anadirCorreo.setOnAction(e ->OnanadirCorreoAction(e));
		eliminarCorreo.setOnAction(e ->OnEliminarCorreoAction(e));
		anadirWeb.setOnAction(e ->OnAnadirWebAction(e));
		eliminarWeb.setOnAction(e ->OnEliminarWebAction(e));
	}

	private void onContatosChanged(ObservableValue<? extends Contacto> o, Contacto ov, Contacto nv) {
		if(ov!= null) {
			emailTabla.itemsProperty().unbindBidirectional(nv.emailProperty());
			webTabla.itemsProperty().unbindBidirectional(nv.webProperty());
			telefonoTabla.itemsProperty().unbindBidirectional(nv.telefonoProperty());

			
		}
if(nv!= null) {
			

	emailTabla.itemsProperty().bindBidirectional(nv.emailProperty());
	webTabla.itemsProperty().bindBidirectional(nv.webProperty());
	telefonoTabla.itemsProperty().bindBidirectional(nv.telefonoProperty());

		}
		
	}

}
