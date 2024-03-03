package restexamen.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.EmpleadoProyecto;
import restexamen.repository.EmpleadoProyectoRepository;

@Service
public class EmpleadoProyectoServiceImplMy8 implements EmpleadoProyectoService{

	@Autowired
	private EmpleadoProyectoRepository eprepo;
	
	@Override
	public EmpleadoProyecto insertOne(EmpleadoProyecto empleadoProyecto) {
		return eprepo.save(empleadoProyecto);
	}

	@Override
	public EmpleadoProyecto updateOne(EmpleadoProyecto empleadoProyecto) {
		try {
			return eprepo.save(empleadoProyecto);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteOne(int idEntrada) {
		try {
			if (buscarUno(idEntrada) != null) {
				eprepo.deleteById(idEntrada);
				return true;
			}else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public EmpleadoProyecto buscarUno(int idEntrada) {
		return eprepo.findById(idEntrada).orElse(null);
	}

	@Override
	public List<EmpleadoProyecto> buscarTodos() {
		return eprepo.findAll();
	}

	@Override
	public List<Empleado> findEmpleadoPorProyecto(int idProyecto) {
		return eprepo.findEmpleadoPorProyecto(idProyecto);
	}

}
