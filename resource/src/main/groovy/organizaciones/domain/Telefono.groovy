package organizaciones.domain

class Telefono {

	String ddi
	String ddn
	String extension
	String numero
	String prefijo
	TipoDeTelefono tipoDeTelefono
		
    static constraints = {
    }
	
	static mapping = {
		id column:'telefonoid'
		tipoDeTelefono column: 'tipodetelefonoid'
		version false
		autoTimestamp false
	}
	
}
