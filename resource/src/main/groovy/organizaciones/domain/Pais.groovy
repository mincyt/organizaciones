package organizaciones.domain

class Pais {

	String codigoISO2
	String codigoISO3
	String denominacion
	String gentilicio
	String nombreISO
	Estado estado
	
	
    static constraints = {
    }
	
	static mapping = {
		id column:'paisid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}
}
