package organizaciones.domain

class CasillaPostal {

	String denominacion
	Estado estado

	static constraints = {
	}

	static mapping = {
		table 'casillapostal'
		id column:'casillapostalid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}

	def String toString() {
		denominacion
	}

}
