package organizaciones.domain

class SubRegion {

	String denominacion
	Region region
	Estado estado
	
	
    static constraints = {
    }
	
	static mapping = {
		table 'subregion'
		id column:'subregionid'
		estado column: 'estadoid'
		region column: 'regionid'
		version false
		autoTimestamp false
	}
	
}
