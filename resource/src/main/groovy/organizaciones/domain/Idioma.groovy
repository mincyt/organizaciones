package organizaciones.domain

class Idioma {

	String identificadorISO
	String nombreISO
	String denominacion
	Estado estado
	
    static constraints = {
    }

	static mapping = {
		id column:'idiomaid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}

	def String toString() {
		denominacion
	}
	
}
