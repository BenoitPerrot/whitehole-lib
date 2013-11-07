package org.whitehole.infra.json;


public class JsonException extends RuntimeException {

	private static final long serialVersionUID = -1957349673491618346L;

	private final String _message;
	private final Throwable _cause;

	public JsonException(String message) {
		_message = message;
		_cause = null;
	}

	public JsonException(String message, Throwable cause) {
		_message = message;
		_cause = cause;
	}

	public String getMessage() {
		return _message;
	}

	public Throwable getCause() {
		return _cause;
	}

}
