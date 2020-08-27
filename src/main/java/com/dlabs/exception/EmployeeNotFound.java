package com.dlabs.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a EmployeeNotFound class
 */
@Slf4j
public class EmployeeNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFound(String str) {
		log.error(str);
	}
}
