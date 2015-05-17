package organizaciones.domain

class SitioWeb {

	String denominacion
	
	static constraints = {
    }
	
	static mapping = {
		table 'sitioweb'
		id column:'sitiowebid'

		version false
		autoTimestamp false
	}
	
}
