package organizaciones.domain

class TipoDeLugar {

	String denominacion
	Estado estado

	static constraints = {
	}

	static mapping = {
		table 'tipodelugar'
		id column:'tipodelugarid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}
}
