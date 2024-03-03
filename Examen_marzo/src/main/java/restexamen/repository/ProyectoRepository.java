package restexamen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import restexamen.modelo.entities.Proyecto;

public interface ProyectoRepository extends JpaRepository <Proyecto, Integer>{
	

}
