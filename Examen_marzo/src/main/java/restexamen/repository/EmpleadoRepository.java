package restexamen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.EmpleadoProyecto;

public interface EmpleadoRepository extends JpaRepository <Empleado, Integer> {
	
	 //Empleados (directores) de un proyecto pasado por idProyecto
	 /*@Query("select e from Empleado e where e.proyecto.idProyecto = ?1")
	 public List<Empleado> findDirectorPorProyecto(int idProyecto);*/
	
	 //Empleados (directores) de un proyecto pasado por idProyecto
	 @Query("SELECT p.director FROM Proyecto p WHERE p.idProyecto = ?1")
	 Empleado findDirectoresPorProyecto(int idProyecto);
	 
	 //Empleados sin proyecto
	 @Query("select e from Empleado e where e.idEmpleado not in (select eep.empleado.idEmpleado from EmpleadoProyecto eep)")
	 List<Empleado> findEmpleadosSinProyecto();


}
