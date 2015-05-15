package organizaciones.domain

class TipoDeRelacion {

	String denominacion
	Estado estado

	static constraints = {
	}

	static mapping = {
		table 'tipoderelacion'
		id column:'tipoderelacionid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}

	def String toString() {
		denominacion
	}

}
