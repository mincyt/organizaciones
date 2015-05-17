package organizaciones.domain

class Lugar {

	String calle
	String codigoPostal
	String numeroDeCalle
	String oficina
	String piso
	Barrio barrio
	Ciudad ciudad
	Estado estado
	Pais pais
	Region region
	SubRegion subregion
	
    static constraints = {
    }

	static mapping = {
		id column: 'lugarid'
		codigoPostal column: 'codigopostal'
		numeroDeCalle column: 'numerodecalle'
		estado column: 'estadoid'
		barrio column: 'barrioid'
		ciudad column: 'ciudadid'
		subregion column: 'subregionid'
		region column: 'regionid'
		pais column: 'paisid'
		version false
		autoTimestamp false

	}

}
