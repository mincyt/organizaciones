package organizaciones.domain

import java.util.Date;

class Email {

	String denominacion
	
	static constraints = {
	}

	static mapping = {
		id column:'emailid'
		version false
		autoTimestamp false
	}

	def String toString() {
		denominacion
	}

}
