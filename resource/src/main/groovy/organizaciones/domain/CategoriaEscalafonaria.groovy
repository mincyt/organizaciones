package organizaciones.domain

import java.util.Date;

class CategoriaEscalafonaria {

	Date fechaDeFinalizacion
	Date fechaDeInicio
	String denominacion
	String sigla
	Boolean vigente
	Escalafon escalafon
	Estado estado
	
	static constraints = {
	}

	static mapping = {
		table 'categoriaescalafonaria'
		id column:'categoriaescalafonariaid'
		escalafon column:'escalafonid'
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
