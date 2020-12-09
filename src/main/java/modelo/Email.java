package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Email {


private StringProperty direccion = new SimpleStringProperty();


	
	public Email(){
		
	}


	public Email(String direccion) {
		super();
		this.direccion.set(direccion);
	
	}

	
	

public final StringProperty direccionProperty() {
	 return this.direccion;
	
}

public final String getDireccion() {
	 return direccionProperty().get();
	
}
	public final void setDireccion(final String direccion) {
		
		this.direccionProperty().set(direccion);
		
	}
	
	@Override
	public String toString() {
		return "Email [" + direccion + "]";
	}
	
	
	
}
