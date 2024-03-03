package restexamen.servicies;

import java.util.List;

import restexamen.modelo.entities.Proyecto;

public interface ProyectoService {
	Proyecto insertOne(Proyecto proyecto);
	Proyecto updateOne(Proyecto proyecto);
	boolean deleteOne(int idProyecto);
	Proyecto buscarUno(int idProyecto);
	List<Proyecto> buscarTodos();

}
