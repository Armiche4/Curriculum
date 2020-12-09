package modelo;

import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import paquete.App;

public class CV {

	
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<Personal>(new Personal());
	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<Contacto>(new Contacto());
	private ListProperty<Titulo> titulo=new SimpleListProperty<Titulo>(FXCollections.observableArrayList());
	private ListProperty<Experiencia> experiencia=new SimpleListProperty<Experiencia>(FXCollections.observableArrayList());
	private ListProperty<Conocimiento> conocimiento=new SimpleListProperty<Conocimiento>(FXCollections.observableArrayList());
	
	
	public final ObjectProperty<Personal> getPersonalProperty() {
		return personal;
	}

	
	public final Personal getPersonal() {
		return this.getPersonalProperty().get();
	}

	
	public final void setPersonal(Personal personal) {
		this.getPersonalProperty().set(personal)  ;
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
	
	public final ListProperty<Titulo> TituloListaProperty() {
		return this.titulo;
	}
	

	public final ObservableList<Titulo> getTituloLista() {
		return this.TituloListaProperty().get();
	}
	

	public final void setExperiencias(final ObservableList<Titulo> titulo) {
		this.TituloListaProperty().set(titulo);
	}
	
	
	
	public final ListProperty<Experiencia> experienciaProperty() {
		return this.experiencia;
	}
	


	public final ObservableList<Experiencia> getExperiencia() {
		return this.experienciaProperty().get();
	}
	


	public final void setExperiencia(final ObservableList<Experiencia> experiencia) {
		this.experienciaProperty().set(experiencia);
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
		
	public static void main(String[] args) {
		CV cv = new CV();
		
		cv.getPersonal().setNombre("Pedro");
		cv.getPersonal().setApellido("Norris");
		//cv.getPersonal().getNacionalidad.add(new Nacionalidad ("estadounidense"));
		
		Gson gson= FxGson.fullBuilder().setPrettyPrinting().create();
		
		
		String json= gson.toJson(cv);
		
		System.out.print(json);
		
	}
	
	
}
