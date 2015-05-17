package organizaciones.domain

class TaxonomiaOrganizacional {

	String denominacion
	Estado estado
	
    static constraints = {
    }

	static mapping = {
		table 'taxonomiaorganizacional'
		id column: 'taxonomiaorganizacionalid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}

	def String toString() {
		denominacion
	}	
}
