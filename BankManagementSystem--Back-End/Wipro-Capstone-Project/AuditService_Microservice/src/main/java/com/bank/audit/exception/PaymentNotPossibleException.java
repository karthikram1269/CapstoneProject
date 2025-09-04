package com.bank.audit.exception;

public class PaymentNotPossibleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentNotPossibleException(String message) {
        super(message);
    }
}