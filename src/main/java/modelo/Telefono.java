package modelo;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefono {

	public enum TipoTelefono {
	    MOVIL(1),
	    DOMICILIO(2);
		TipoTelefono(int i){
			
		}
		
	  }
	
	
private StringProperty numero = new SimpleStringProperty();
private ObjectProperty<TipoTelefono>tipoTelefono=new SimpleObjectProperty<>();
	
	public Telefono(){
		
	}
	
	


	public Telefono(StringProperty numero, ObjectProperty<TipoTelefono> tipoTelefono) {
		super();
		this.numero = numero;
		this.tipoTelefono = tipoTelefono;
	}




	public final ObjectProperty<TipoTelefono> tipoTelefonoProperty() {
		return this.tipoTelefono;
	}
	

	public final TipoTelefono getTipoTelefono() {
		return this.tipoTelefonoProperty().get();
	}
	

	public final void setTipoTelefono(final TipoTelefono tipoTelefono) {
		this.tipoTelefonoProperty().set(tipoTelefono);
	}
	
	

public final StringProperty numeroProperty() {
	 return this.numero;
	
}

public final String getNumero() {
	 return numeroProperty().get();
	
}
	public final void setNumero(final String numero) {
		
		this.numeroProperty().set(numero);
		
	}
	
	
	
}
