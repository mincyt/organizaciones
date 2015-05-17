package organizaciones.domain


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Column

@Entity
class Estado {
	
	@Id
	@GeneratedValue
	@Column(name="estadoid")
	Long id
	
	String denominacion 
	
	def String toString() {
		denominacion
	}
	
}
