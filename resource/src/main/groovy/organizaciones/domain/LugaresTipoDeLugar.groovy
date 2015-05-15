package organizaciones.domain

class LugaresTipoDeLugar {

	Lugar lugar
	TipoDeLugar tipoDeLugar
	
    static constraints = {
    }

	static mapping = {
		table 'lugarestipodelugar'
		lugar column: 'lugarid'
		tipoDeLugar column: 'tipodelugarid'
		version false
		autoTimestamp false
    }
}
