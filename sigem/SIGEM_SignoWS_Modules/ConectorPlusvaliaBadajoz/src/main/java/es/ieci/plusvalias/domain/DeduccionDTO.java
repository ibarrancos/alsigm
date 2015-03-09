package es.ieci.plusvalias.domain;

// Generated 30-jun-2010 12:15:53 by Hibernate Tools 3.2.4.CR1

/**
 * DeduccionDTO generated by hbm2java
 */
public class DeduccionDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer anyos;
	private Integer porcentaje;

	public DeduccionDTO() {
	}

	public DeduccionDTO(Integer anyos) {
		this.setAnyos(anyos);
	}

	public DeduccionDTO(Integer anyos, Integer porcentaje) {
		this.setAnyos(anyos);
		this.setPorcentaje(porcentaje);
	}

	public void setAnyos(Integer anyos) {
		this.anyos = anyos;
	}

	public Integer getAnyos() {
		return anyos;
	}

	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Integer getPorcentaje() {
		return porcentaje;
	}
}