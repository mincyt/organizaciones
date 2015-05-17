package organizaciones.domain

class Ciudad {

	String denominacion
	SubRegion subregion
	Estado estado


	static constraints = {
	}

	static mapping = {
		id column:'ciudadid'
		estado column: 'estadoid'
		subregion column: 'subregionid'
		version false
		autoTimestamp false
	}

	def String toString() {
		denominacion
	}
}
