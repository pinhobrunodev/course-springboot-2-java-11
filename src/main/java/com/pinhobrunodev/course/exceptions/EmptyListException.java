package com.pinhobrunodev.course.exceptions;

import com.pinhobrunodev.course.utils.MessageUtils;

public class EmptyListException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyListException() {
		super(MessageUtils.EMPTY_LIST_EXCEPTION);
	}

}
