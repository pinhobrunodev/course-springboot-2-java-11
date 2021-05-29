package com.pinhobrunodev.course.exceptions;

import com.pinhobrunodev.course.utils.MessageUtils;

public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super(MessageUtils.CLIENT_NOT_FOUND);
	}
	
	
}
