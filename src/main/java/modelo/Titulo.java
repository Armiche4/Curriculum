package modelo;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Titulo {

	
	private ObjectProperty<LocalDate> desde = new SimpleObjectProperty<LocalDate>();
	
	private ObjectProperty<LocalDate> hasta = new SimpleObjectProperty<LocalDate>();
	
	private StringProperty denominacion = new SimpleStringProperty();

	private StringProperty organizador = new SimpleStringProperty();
	
			
	public Titulo() {
	
	
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
	
	public final void setdenominacion(final String denominacion) {
		this.denominacion.set(denominacion);
	}
	
	
	public final String getorganizador() {
		return organizador.get();
	}

	public final StringProperty getorganizadorProperty() {
		return organizador;
	}

	public final void setorganizador(final String organizador) {
		this.organizador.set(organizador);
	}



	public void setDesde(LocalDate value) {
		this.desde.set(value);
		
	}



	public void setHasta(LocalDate value) {
		this.hasta.set(value);
		
	}
	
	
	
	
	
	
	
	
	
}
