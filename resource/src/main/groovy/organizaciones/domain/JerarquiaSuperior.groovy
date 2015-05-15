package organizaciones.domain

class JerarquiaSuperior {

	String denominacion
	Estado estado
	
	static mapping = {
		table 'jerarquiasuperior'
		id column: 'jerarquiasuperiorid'
		estado column: 'estadoid'
		dateCreated column: 'creadocuando'
		lastUpdated column: 'modificadocuando'
	}

	def String toString() {
		denominacion
	}

}
