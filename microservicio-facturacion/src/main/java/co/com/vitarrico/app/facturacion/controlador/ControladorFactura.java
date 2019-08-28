package co.com.vitarrico.app.facturacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.vitarrico.app.facturacion.dominio.dto.factura.FacturaDto;
import co.com.vitarrico.app.facturacion.dominio.servicio.IServicioFactura;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadFactura;

@RestController
public class ControladorFactura {

	@Autowired
	private IServicioFactura servicioFactura;

	@GetMapping(value = "/facturas")
	public List<EntidadFactura> obtenerProductos() {
		return servicioFactura.listar();
	}

	@PostMapping(value = "/crear-factura")
	public EntidadFactura crearFactura(@RequestBody FacturaDto factura) {
		return servicioFactura.crearFactura(factura);
	}

	@GetMapping(value = "/factura/{id}")
	public EntidadFactura buscarProductoPorId(@PathVariable(value = "id") Long id) {
		return servicioFactura.buscarFacturaPorId(id);
	}
}
