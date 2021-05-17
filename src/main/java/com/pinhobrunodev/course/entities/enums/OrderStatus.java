package com.pinhobrunodev.course.entities.enums;

public enum OrderStatus {

	/*
	 * Atribuir manualmante um valor numerico para cada tipo enumerado ( evitar quebra do bd)
	 */
	
	WAITING_PAYMENT(1), 
	PAID(2), 
	SHIPPED(3),
	DELIVERED(4), 
	CANCELED(5);
	
	
	// Codigo do tipo enumerado
	private int code;
	
	private OrderStatus(int code) {
		this.code=code;
	}
	
	// criar um metodo para que seja acessivel 
	public int getCode() {
		return code;
	}
	
	//Converter um valor numerico para enumerado (static pois vai funcionar sem precisar instanciar)
	public static  OrderStatus valueOf(int code) {
		// Percorrendo todos os valores possiveis do OrderStatus
		for(OrderStatus  value : OrderStatus.values()) {
			// Ex: Se codigo do waiting_payment for igual ao codigo que to querendo,retorno ele
			if(value.getCode() == code) {
				return value;
			}
		}
		// Se nao achar
		throw new  IllegalArgumentException("Invalid order status code");
	}
}
