package restexamen.servicies;

import java.util.List;

import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.EmpleadoProyecto;

public interface EmpleadoService {
	
	Empleado insertOne(Empleado empleado);
	Empleado updateOne(Empleado empleado);
	boolean deleteOne(int idEmpleado);
	Empleado buscarUno(int idEmpleado);
	List<Empleado> buscarTodos();
    Empleado findDirectoresPorProyecto(int idProyecto);
    List<Empleado> findEmpleadosSinProyecto();

}
