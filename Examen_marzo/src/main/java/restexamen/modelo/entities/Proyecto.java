package restexamen.modelo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity // Indica que esta clase es una entidad JPA
@Table(name="Proyectos") // Especifica el nombre de la tabla en la base de datos
@Data // Anotación de Lombok para generar automáticamente getters, setters, toString, etc.
@NoArgsConstructor // Constructor sin argumentos generado automáticamente por Lombok

public class Proyecto {
	
	    @Id // Indica que este campo es la clave primaria de la entidad
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de valores para la clave primaria
	    @Column(name="id_proyecto") // Especifica el nombre de la columna en la base de datos
	    private int idProyecto; // Identificador único del cliente
	    private String descripcion;
		@Temporal(TemporalType.DATE)
		@Column(name="fecha_inicio")
	    private Date fechaInicio;
		@Column(name="dias_previstos")
	    private int diasPrevistos;
		@ManyToOne
		@JoinColumn(name="director")
	    private Empleado director;
	    private String estado;

}
