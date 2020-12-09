package modelo;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Conocimiento {

	
	
	private StringProperty denominacion = new SimpleStringProperty();
	private ObjectProperty<Nivel>nivel=new SimpleObjectProperty<>();
	private ObjectProperty<Idioma>idioma=new SimpleObjectProperty<>();
	
	


	public enum Nivel {
	    BASICO(0),
	    MEDIO(1),
	    AVANZADO(2);
	    Nivel(int i){
			
		}
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
	
	
	public final ObjectProperty<Nivel> getNivel() {
		return nivel;
	}

	public final void setNivel(Nivel nivel2) {
		this.nivel.set(nivel2);
	}
	
	public final Idioma getidioma() {
		return idioma.get();
	}

	public final ObjectProperty<Idioma> getcertificacionProperty() {
		return idioma;
	}

	public final void setcertificacion(Idioma certificacion) {
		this.idioma.set(certificacion);
	}


	
	
}
