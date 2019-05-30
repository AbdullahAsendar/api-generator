/**
 * 
 */
package net.asendar.apigenerator.util;

/**
 * @author asendar
 *
 */
public class ApiGeneratorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1890326860431135372L;

	/**
	 * 
	 */
	public ApiGeneratorException(String message) {
		super(message);
	}

	public ApiGeneratorException(Throwable e) {
		super(e);
	}

	public ApiGeneratorException(String format, Object... args) {
		super(String.format(format, args));
	}

	public ApiGeneratorException(String format, Throwable e, Object... args) {
		super(String.format(format, args), e);
	}

	public static final void fail(String message) {
		throw new ApiGeneratorException(message);
	}

	public static final void fail(Throwable e) {
		throw new ApiGeneratorException(e);
	}

	public static final void fail(String format, Object... args) {
		throw new ApiGeneratorException(format, args);
	}

	public static final void fail(String format, Throwable e, Object... args) {
		throw new ApiGeneratorException(format, e, args);
	}
}
