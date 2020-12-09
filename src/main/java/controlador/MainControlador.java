package controlador;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.apache.commons.io.FileUtils;
import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Tab;

import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import modelo.CV;
import paquete.App;

public class MainControlador implements Initializable {

	// Sub-controladores

	private PersonalControlador personaControlador = new PersonalControlador();

	private ContactoController contactoControlador = new ContactoController();
	
	private FormacionControlador formacionControlador = new FormacionControlador();
	
	private ExperienciaController experienciaController = new ExperienciaController();
	
	private ConocimientosController conocimientosController = new ConocimientosController();
	
	// Model

	private ObjectProperty<CV> cv = new SimpleObjectProperty();

	// vista

	@FXML
	private BorderPane MainView;

	@FXML
	private Tab personal;

	@FXML
	private Tab contactos;

	@FXML
	private Tab formacion;

	@FXML
	private Tab experiencia;

	@FXML
	private Tab conocimiento;


	private File archivo;

	@FXML
	void OnAbrirAction(ActionEvent event) {

		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("¿Que archivo vas a abrir?");
		filechooser.getExtensionFilters().add(new ExtensionFilter("Curriculum Vitae (*.cv)", "*.cv"));
		filechooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos(*)", "*.*"));
		File cvFile = filechooser.showOpenDialog(App.getPrimaryStage());

		if (cvFile != null) {
			Gson gson = FxGson.fullBuilder().setPrettyPrinting().create();

			try {
				String json = FileUtils.readFileToString(cvFile, StandardCharsets.UTF_8);

				cv.set(gson.fromJson(json, CV.class));

				archivo = cvFile;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@FXML
	void OnGuardarAction(ActionEvent event) {

		if (archivo != null) {
			Gson gson = FxGson.fullBuilder().setPrettyPrinting().create();

			String json = gson.toJson(cv.get());

			try {
				FileUtils.writeStringToFile(archivo, json, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (archivo == null) {
			OnGuardarComoAction(event);
		}
	}

	@FXML
	void OnGuardarComoAction(ActionEvent event) {

		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("¿Donde vas a guardar?");
		filechooser.getExtensionFilters().add(new ExtensionFilter("Curriculum Vitae (*.cv)", "*.cv"));
		filechooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos(*)", "*.*"));
		File cvFile = filechooser.showSaveDialog(App.getPrimaryStage());

		if (cvFile != null) {
			Gson gson = FxGson.fullBuilder().setPrettyPrinting().create();

			String json = gson.toJson(cv.get());

			try {
				FileUtils.writeStringToFile(cvFile, json, StandardCharsets.UTF_8);

				archivo = cvFile;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@FXML
	void OnNuevoAction(ActionEvent event) {
		System.out.println("Has pulsado nuevo");
		archivo = null;
		cv.set(new CV());

	}

	@FXML
	void OnSalirAction(ActionEvent event) {

		App.getPrimaryStage().close();

	}

	public BorderPane getView() {
		return MainView;
	}

	public MainControlador() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/VistaPrincipal.fxml"));
		loader.setController(this);

		loader.load();

	}

	public void initialize(URL location, ResourceBundle resources) {

		personal.setContent(personaControlador.getVistaPersonal());

		contactos.setContent(contactoControlador.getVista());
		
		formacion.setContent(formacionControlador.getFormacionVista());
		
		experiencia.setContent(experienciaController.getVista());
		
		conocimiento.setContent(conocimientosController.getVista());
		

		cv.addListener((o, ov, nv) -> onCVChanged(o, ov, nv));

		cv.set(new CV());

	}

	private void onCVChanged(ObservableValue<? extends CV> o, CV ov, CV nv) {
		
		if (nv != null) {

			personaControlador.getPersonalProperty().unbind();
			contactoControlador.getContactosProperty().unbind();
			formacionControlador.TituloListaProperty().unbind();
			experienciaController.experienciasProperty().unbind();
			conocimientosController.conocimientoProperty().unbind();
			// desbinder resto de controladores

		}
		if (nv != null) {

			personaControlador.getPersonalProperty().bind(nv.getPersonalProperty());
			contactoControlador.getContactosProperty().bind(nv.getContactosProperty());
			formacionControlador.TituloListaProperty().bind(nv.TituloListaProperty());
			experienciaController.experienciasProperty().bind(nv.experienciaProperty());
			conocimientosController.conocimientoProperty().bind(nv.conocimientoProperty());
//bindear el resto de controladores
		}

	}
}
