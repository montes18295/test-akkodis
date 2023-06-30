package org.akkodis.test.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.akkodis.test.domain.exception.ArgumentNullException;
import org.akkodis.test.domain.exception.MultipleResultException;
import org.akkodis.test.domain.exception.ResourceNotFoundException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
public class ExceptionHandleController {

  Logger logger = LoggerFactory.getLogger(ExceptionHandleController.class);

  @Autowired
  private MessageSource messageSource;

  /**
   * <p>Manejo de la excepción ResourceNotFoundException. </p>
   * <p>Para cuando no es encuentra un recurso. </p>
   *
   * @param resourceNotFoundException exception lanzada.
   * @return MessageError objeto con la información a devolver.
   */
  @ExceptionHandler({ResourceNotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public MessageError handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {

    String message = messageSource.getMessage(
            resourceNotFoundException.getMessage(), null, Locale.getDefault());

    logger.warn(message);

    return new MessageError(message);
  }

  /**
   * <p>Manejo de la excepción MultipleResultException.</p>
   * <p>Para cuando se realiza una acción no permitida.</p>
   *
   * @param multipleResultException exception lanzada.
   * @return MessageError objeto con la información a devolver.
   */
  @ExceptionHandler({MultipleResultException.class})
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public MessageError handleMultipleResultException(MultipleResultException multipleResultException) {

    String message = messageSource.getMessage(
            multipleResultException.getMessage(), null, Locale.getDefault());

    logger.warn(message);

    return new MessageError(message);
  }

  /**
   * <p>Manejo de la excepción ArgumentNullException.</p>
   * <p>Para cuando un método obtiene parámetros no Nullables a null.</p>
   *
   * @param argumentNullException exception lanzada.
   * @return MessageError objeto con la información a devolver.
   */
  @ExceptionHandler({ArgumentNullException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public MessageError handleArgumentNullException(ArgumentNullException argumentNullException) {

    String message = messageSource.getMessage(
            argumentNullException.getMessage(), null, Locale.getDefault());

    logger.warn(message);

    return new MessageError(message);

  }

  /**
   * Clase para devolver en el manejo de excepciones de los controladores.
   */
  @Data
  @AllArgsConstructor
  private class MessageError {

    private String message;

  }

}
