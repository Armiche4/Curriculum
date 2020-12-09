package modelo;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Experiencia {

	
	private ObjectProperty<LocalDate> desde = new SimpleObjectProperty<LocalDate>();
	
	private ObjectProperty<LocalDate> hasta = new SimpleObjectProperty<LocalDate>();
	
	private StringProperty denominacion = new SimpleStringProperty();

	private StringProperty empleador = new SimpleStringProperty();
	
			
	public Experiencia() {
	
	
	}

	

	public final ObjectProperty<LocalDate> getDesde() {
		return desde;
	}

	public final void setDesde(ObjectProperty<LocalDate> desde) {
		this.desde = desde;
	}

	public final ObjectProperty<LocalDate> getHasta() {
		return hasta;
	}

	public final void setHasta(ObjectProperty<LocalDate> hasta) {
		this.hasta = hasta;
	}

	public final String getdenominacion() {
		return denominacion.get();
	}

	public final StringProperty getdenominacionProperty() {
		return denominacion;
	}	
	
	public final void setdenominacion(String denominacion) {
		this.denominacion.set(denominacion);
	}
	
	
	public final String getempleador() {
		return empleador.get();
	}

	public final StringProperty getempleadorProperty() {
		return empleador;
	}

	public final void setempleador(String empleador) {
		this.empleador.set(empleador);
	}



	@Override
	public String toString() {
		return  denominacion + " " + empleador ;
	}



	public void setDesde(LocalDate value) {
		this.desde.setValue(value);
		
	}
	
	
	public void setHasta(LocalDate value) {
		this.hasta.setValue(value);
		
	}
	
	
	
	
	
	
	
}
