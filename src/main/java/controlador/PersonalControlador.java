package controlador;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modelo.Nacionalidad;
import modelo.Personal;

public class PersonalControlador implements Initializable {

	
	//model
	
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<>(new Personal());
	
	
	//vista
	  @FXML
	    private GridPane vistaPersonal;
	
	  public final GridPane getVistaPersonal() {
		return vistaPersonal;
	}




	@FXML
	    private TextField identificacionText;

	    @FXML
	    private TextField nombreText;

	    @FXML
	    private TextField apellidosText;

	    @FXML
	    private TextField localidadText;

	    @FXML
	    private ListView<Nacionalidad> nacionalidadList= new ListView<Nacionalidad>();

	    @FXML
	    private ComboBox<String> paisCombo = new ComboBox<String>();

	    @FXML
	    private DatePicker naciemientoDate;

	    @FXML
	    private Button masButton;

	    @FXML
	    private Button menosButton;
	    
	    @FXML
	    private TextArea direccionText;
	    
	    @FXML
	    private TextField codigoPostalText;

	
	    
	    
	    
	    @FXML
	    void onNuevaNacionAction(ActionEvent event) {
	    	String tabla[]=anadirNacion();
	    	
	    	
			ChoiceDialog panel = new ChoiceDialog(tabla[0],tabla);
	    	panel.setTitle("Nacionalidad");
	    	 panel.setHeaderText("Añade una nacionalidad"); 
	    	// panel.setContentText("please select the day of the week");
	    	 
	    	 Optional<String> result =panel.showAndWait();
	    	
	    	 if ( result.isPresent() )
	    	 {
	    	
	    	
	    	
	    	//Nacionalidad n =new Nacionalidad(panel.getSelectedItem().toString());
	    	Nacionalidad m =new Nacionalidad(result.get());
	    	//personal.setNacionalidades(nombres);
	    	//nombres.add(m);
		    
	    	personal.get().getNacionalidades().add(m);
	    	
	    	
	    	
	    	
	    	 }
	    }

	    @FXML
	    void onQuitarNacionAction(ActionEvent event) {

	    		    	
	    	personal.get().getNacionalidades().remove( nacionalidadList.getSelectionModel().selectedItemProperty().getValue());
	    	
	    	
	    }
	
	
	    public PersonalControlador () throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/PersonalVista.fxml"));
			   loader.setController(this);
				
				loader.load();
				
	    	
	    	
	    }
	    
	    public final ObjectProperty<Personal> getPersonalProperty() {
			return personal;
		}

		
		public final Personal getPersonal() {
			return this.getPersonalProperty().get();
		}

		
		public final void setPersonal(Personal personal) {
			this.getPersonalProperty().set(personal)  ;
		}
	    
	    
	public void initialize(URL location, ResourceBundle resources) {

personal.addListener((o,ov,nv) ->onPersonalChanged(o,ov,nv));		
anadirPais();


		
	}
	
	
	private  String[]  anadirNacion() {
		File csvFile = new File ("C:\\Users\\Usuario\\eclipse-workspace\\Curriculum\\src\\main\\resources\\csv\\nacionalidades.csv");
		String pais;
		String textStr[] = null ;
		try {
			pais = (FileUtils.readFileToString(csvFile, StandardCharsets.UTF_8));
			
			  textStr = pais.split("\\r\\n|\\n|\\r");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 return textStr;
	}	 
			 
			 
			 
		
	private void anadirPais() {
		File csvFile = new File ("C:\\Users\\Usuario\\eclipse-workspace\\Curriculum\\src\\main\\resources\\csv\\paises.csv");

		try {
			String pais =(FileUtils.readFileToString(csvFile, StandardCharsets.UTF_8));
			 String textStr[] = pais.split("\\r\\n|\\n|\\r");
			paisCombo.setItems(FXCollections.observableArrayList(textStr));
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

	private void onPersonalChanged(ObservableValue<? extends Personal> o, Personal ov, Personal nv) {
	
		System.out.println(nv);

		System.out.println(ov);
		
		if(ov!= null) {
			nombreText.textProperty().unbindBidirectional(ov.getNombreProperty());
			apellidosText.textProperty().unbindBidirectional(ov.getApellidoProperty());
			naciemientoDate.valueProperty().unbindBidirectional(ov.getFechaNacimiento());
			identificacionText.textProperty().unbindBidirectional(nv.getIdentificacionProperty());
			direccionText.textProperty().unbindBidirectional(nv.getDireccionProperty());
			codigoPostalText.textProperty().unbindBidirectional(nv.getCodigoPostalProperty());
			localidadText.textProperty().unbindBidirectional(nv.getLocalidadProperty());
			nacionalidadList.itemsProperty().unbindBidirectional(nv.nacionalidadesProperty());
			paisCombo.valueProperty().unbindBidirectional(nv.getPaisProperty());
			
		}
if(nv!= null) {
			
	nombreText.textProperty().bindBidirectional(nv.getNombreProperty());
	apellidosText.textProperty().bindBidirectional(nv.getApellidoProperty());
	naciemientoDate.valueProperty().bindBidirectional(nv.getFechaNacimiento());
	identificacionText.textProperty().bindBidirectional(nv.getIdentificacionProperty());
	direccionText.textProperty().bindBidirectional(nv.getDireccionProperty());
	codigoPostalText.textProperty().bindBidirectional(nv.getCodigoPostalProperty());
	localidadText.textProperty().bindBidirectional(nv.getLocalidadProperty());
	nacionalidadList.itemsProperty().bindBidirectional(nv.nacionalidadesProperty());
	paisCombo.valueProperty().bindBidirectional(nv.getPaisProperty());

		}
		
	}

}
