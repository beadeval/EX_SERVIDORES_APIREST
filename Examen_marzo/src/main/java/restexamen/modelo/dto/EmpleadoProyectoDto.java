package restexamen.modelo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmpleadoProyectoDto {
	
    private int idProyecto;
    private int idEmpleado;
    private int diasPrevistos;
    private Date fechaIncorporacion;
}
