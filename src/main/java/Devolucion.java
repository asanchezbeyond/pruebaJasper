import java.text.SimpleDateFormat;
import java.util.Date;

public class Devolucion {
	
	private Integer devolucionCliente;
	private String cif;
	private String presta;
	private Date fecha;
	private String comercial;
	private String observaciones;
	private String imei;
	private String descripcion;
	private Integer cantidad;
	
	public Devolucion(Integer devolucionCliente, String cif, String presta, Date fecha, String comercial,
			String observaciones, String imei, String descripcion, Integer cantidad) {
		this.devolucionCliente = devolucionCliente;
		this.cif = cif;
		this.presta = presta;
		this.fecha = fecha;
		this.comercial = comercial;
		this.observaciones = observaciones;
		this.imei = imei;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}

	public Integer getDevolucionCliente() {
		return devolucionCliente;
	}

	public String getCif() {
		return cif;
	}

	public String getPresta() {
		return presta;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getComercial() {
		return comercial;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public String getImei() {
		return imei;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public String getFechaToString(){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(fecha);
	}

}
