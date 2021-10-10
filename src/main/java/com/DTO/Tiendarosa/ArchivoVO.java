package com.DTO.Tiendarosa;

public class ArchivoVO {
	private Long id_usuario;
	private String nombre;
	private String nitprove;
	private int precio;
	private int iva;
	private int venta;
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNitprove() {
		return nitprove;
	}
	public void setNitprove(String nitprove) {
		this.nitprove = nitprove;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getVenta() {
		return venta;
	}
	public void setVenta(int venta) {
		this.venta = venta;
	}
	

}
