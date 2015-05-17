package organizaciones.domain

import java.util.Date;

class Escalafon {

	Date fechaDeFinalizacion
	Date fechaDeInicio
	String denominacion
	String sigla
	Boolean vigente
	Estado estado
	
	static constraints = {
	}

	static mapping = {
		id column:'escalafonid'
		estado column: 'estadoid'
		fechaDeInicio column: 'fechadeinicio'
		fechaDeFinalizacion column: 'fechadefinalizacion'
		dateCreated column: 'creadocuando'
		lastUpdated column: 'modificadocuando'
	}

	def String toString() {
		denominacion
	}

}
