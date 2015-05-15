package organizaciones.domain

import java.util.Date;

class Comentario {

	String texto
	Estado estado

	static constraints = {
	}

	static mapping = {
		tablePerHierarchy false
		id column:'comentarioid'
		estado column: 'estadoid'
		version false
		dateCreated column: 'creadocuando'
		lastUpdated column: 'modificadocuando'
	}

	def String toString() {
		texto
	}
}
