package organizaciones.domain

class Region {

	String codigoISO
	String denominacion
	String nombreISO
	Pais pais
	Estado estado
	
	
    static constraints = {
    }
	
	static mapping = {
		id column:'regionid'
		estado column: 'estadoid'
		pais column: 'paisid'
		version false
		autoTimestamp false
	}

}
