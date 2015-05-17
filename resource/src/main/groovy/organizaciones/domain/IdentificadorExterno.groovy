package organizaciones.domain

import java.util.Date;

class IdentificadorExterno {

	Organizacion autoridaddedesignacion
	String denominacion
	Date fechaDeFinalizacion
	Date fechaDeInicio
	String sigla
	Estado estado
	
	static constraints = {
	}

	static mapping = {
		table 'identificadorexterno'
		id column:'identificadorexternoid'
		estado column: 'estadoid'
		autoridaddedesignacion column: 'autoridaddedesignacion'
		fechaDeInicio column: 'fechadeinicio'
		fechaDeFinalizacion column: 'fechadefinalizacion'
		dateCreated column: 'creadocuando'
		lastUpdated column: 'modificadocuando'
	}

	def String toString() {
		denominacion
	}
}
