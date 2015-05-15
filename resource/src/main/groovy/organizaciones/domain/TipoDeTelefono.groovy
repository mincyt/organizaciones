package organizaciones.domain

class TipoDeTelefono {

	String denominacion
	Estado estado
	
    static constraints = {
    }
	
	static mapping = {
		table 'tipodetelefono'
		id column:'tipodetelefonoid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}
	
}
