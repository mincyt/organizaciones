package organizaciones.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Idioma {

	@Id
	@GeneratedValue
	@Column(name="idiomaid")
	Long id

	@Column(name="identificadoriso")
	String identificadorISO

	@Column(name="nombreiso")
	String nombreISO
	String denominacion

	@ManyToOne
	@JoinColumn(name="estadoid")
	Estado estado

	static constraints = {
	}

	static mapping = {
		id column:'idiomaid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}

	def String toString() {
		denominacion
	}
}
