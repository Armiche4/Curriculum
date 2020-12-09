package modelo;

import java.time.LocalDate;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Personal {

	private StringProperty identificacion = new SimpleStringProperty();

	private StringProperty nombre = new SimpleStringProperty();

	private StringProperty apellido = new SimpleStringProperty();

	private ObjectProperty<LocalDate> fechaNacimiento = new SimpleObjectProperty<LocalDate>();

	private StringProperty direccion = new SimpleStringProperty();

	private StringProperty codigoPostal = new SimpleStringProperty();

	private StringProperty localidad = new SimpleStringProperty();

	private StringProperty pais = new SimpleStringProperty();

	private ListProperty<Nacionalidad> nacionalidades = new SimpleListProperty<Nacionalidad>(FXCollections.observableArrayList());

	public final String getIdentificacion() {
		return identificacion.get();
	}

	public final StringProperty getIdentificacionProperty() {
		return identificacion;
	}

	public final void setIdentificacion(String identificacion) {
		this.identificacion.set(identificacion);
	}

	public final String getNombre() {
		return nombre.get();
	}

	public final StringProperty getNombreProperty() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	public final String getApellido() {
		return apellido.get();
	}

	public final StringProperty getApellidoProperty() {
		return apellido;
	}

	public final void setApellido(String apellido) {
		this.apellido.set(apellido);
	}

	public final ObjectProperty<LocalDate> getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final void setFechaNacimiento(ObjectProperty<LocalDate> fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public final String getDireccion() {
		return direccion.get();
	}

	public final StringProperty getDireccionProperty() {
		return direccion;
	}

	public final void setDireccion(String direccion) {
		this.direccion.set(direccion);
	}

	public final String getCodigoPostal() {
		return codigoPostal.get();
	}

	public final StringProperty getCodigoPostalProperty() {
		return codigoPostal;
	}

	public final void setCodigoPostal(String codigoPostal) {
		this.codigoPostal.set(codigoPostal);
	}

	public final String getLocalidad() {
		return localidad.get();
	}

	public final StringProperty getLocalidadProperty() {
		return localidad;
	}

	public final void setLocalidad(String localidad) {
		this.localidad.set(localidad);
	}

	public final String getPais() {
		return pais.get();
	}

	public final StringProperty getPaisProperty() {
		return pais;
	}

	public final void setPais(String pais) {
		this.pais.set(pais);
	}

	public final ListProperty<Nacionalidad> nacionalidadesProperty() {
		return this.nacionalidades;
	}

	public final ObservableList<Nacionalidad> getNacionalidades() {
		return this.nacionalidadesProperty().get();
	}

	public final void setNacionalidades(final ObservableList<Nacionalidad> nacionalidades) {
		this.nacionalidadesProperty().set(nacionalidades);
	}

}
