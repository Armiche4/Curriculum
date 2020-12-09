package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Idioma {

	private StringProperty certificacion = new SimpleStringProperty();
	
public Idioma() {
	
}


public Idioma(StringProperty certificacion) {
		super();
		this.certificacion = certificacion;
	}

public final String getcertificacion() {
	return certificacion.get();
}

public final StringProperty getcertificacionProperty() {
	return certificacion;
}

public final void setcertificacion(String certificacion) {
	this.certificacion.set(certificacion);
}

}