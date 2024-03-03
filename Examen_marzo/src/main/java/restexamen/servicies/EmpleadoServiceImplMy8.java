package restexamen.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restexamen.modelo.entities.Empleado;
import restexamen.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImplMy8 implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepository erepo;

	@Override
	public Empleado insertOne(Empleado empleado) {
		return erepo.save(empleado);
	}

	@Override
	public Empleado updateOne(Empleado empleado) {
		try {
			return erepo.save(empleado);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteOne(int idEmpleado) {
		try {
			if (buscarUno(idEmpleado) != null) {
				erepo.deleteById(idEmpleado);
				return true;
			}else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public Empleado buscarUno(int idEmpleado) {
		return erepo.findById(idEmpleado).orElse(null);
	}

	@Override
	public List<Empleado> buscarTodos() {
		return erepo.findAll();
	}

	@Override
	public Empleado findDirectoresPorProyecto(int idProyecto) {
		return erepo.findDirectoresPorProyecto(idProyecto);
	}
	
	@Override
	public List<Empleado> findEmpleadosSinProyecto() {
		
		return erepo.findEmpleadosSinProyecto();
	}


}
