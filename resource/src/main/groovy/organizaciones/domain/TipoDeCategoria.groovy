package organizaciones.domain

class TipoDeCategoria {

	String denominacion
	Estado estado

	static constraints = {
	}

	static mapping = {
		table 'tipodecategoria'
		id column:'tipodecategoriaid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}

	def String toString() {
		denominacion
	}
}
