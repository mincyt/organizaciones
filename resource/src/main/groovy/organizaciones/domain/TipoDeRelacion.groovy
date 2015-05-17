package organizaciones.domain

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

class TipoDeRelacion {

	@Id
	@GeneratedValue
	@Column(name="tipoderelacionid")
	Long id
	
	String denominacion

	@ManyToOne
	@JoinColumn(name="estadoid")
	Estado estado

	static constraints = {
	}

	static mapping = {
		table 'tipoderelacion'
		id column:'tipoderelacionid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}

	def String toString() {
		denominacion
	}
}
