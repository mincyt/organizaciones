package organizaciones.domain

class TipoDeOrganizacion {

	String denominacion

	static constraints = {
	}

	static mapping = {
		table 'tipodeorganizacion'
		id column:'tipodeorganizacionid'
		version false
		autoTimestamp false
	}

	def String toString() { denominacion }
}
