package organizaciones.domain

class Barrio {

	String denominacion
	Ciudad ciudad
	Estado estado
	
	
	static constraints = {
	}
	
	static mapping = {
		id column:'barrioid'
		estado column: 'estadoid'
		subregion column: 'ciudadid'
		version false
		autoTimestamp false
	}
	
	def String toString() {
		denominacion
	}

}
