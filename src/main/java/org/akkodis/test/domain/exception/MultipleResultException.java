package org.akkodis.test.domain.exception;

public class MultipleResultException extends RuntimeException {

  public MultipleResultException() {
  }

  public MultipleResultException(String message) {
    super(message);
  }

  public MultipleResultException(String message, Throwable cause) {
    super(message, cause);
  }

  public MultipleResultException(Throwable cause) {
    super(cause);
  }

  public MultipleResultException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}