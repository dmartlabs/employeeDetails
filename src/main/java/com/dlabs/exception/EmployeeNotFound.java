package com.dlabs.exception;

/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a EmployeeNotFound class
 */
public class EmployeeNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFound(String msg) {
		super(msg);
	}
}
