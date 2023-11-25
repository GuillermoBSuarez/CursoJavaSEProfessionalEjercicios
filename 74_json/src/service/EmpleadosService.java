package service;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Empleado;

public class EmpleadosService {
	
	/* Implementar la lógica de negocio de una aplicación para manejo de empleados
	
	CONSTRUCTOR
	public EmpleadosService() {
		File file = new File(dir);
		if (!file.exists()) {
			try { file.createNewFile(); }
			catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	NO HAY CONSTRUCTOR SOBRECARGADO porque sólo lo queremos para crear el fichero si no lo hubiese,
	pero el programa está pensado para manejar una BD que se supone existe, así pues no lo incluimos
	y el dir con la ruta del archivo lo incluimos en el getEmpleados() */

	private Stream<Empleado> getEmpleados() {
		String dir = "c:\\temp\\empleados.json";
		Gson gson = new Gson();
		try ( FileReader reader = new FileReader(dir); ) {
			Empleado[] empleados = gson.fromJson(reader, Empleado[].class);
			return Arrays.stream(empleados);
		} catch (Exception e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
	public List<Empleado> listaEmpleadosPorDepartamento (String departamento){
		return getEmpleados()											// Stream<Empleado>
				.filter( e -> e.getDepartamento().equals(departamento) )// Stream<Empleado>
				.toList();												// List<Empleado>
	}

	public Empleado empleadoMayorSalario() {
		return getEmpleados()															// Stream<Empleado>
				.max( (e1, e2) -> Double.compare(e1.getSalario(), e2.getSalario()) )	// Optional<Empleado>
				.orElse(null);
	}
	
	public Empleado empleadoPorMail (String email) {
		return getEmpleados()											// Stream<Empleado>
				.filter( a -> a.getEmail().equals(email) )				// Stream<Empleado>
				.findFirst()											// Optional<Empleado>	
				.orElse(null);
	}
}