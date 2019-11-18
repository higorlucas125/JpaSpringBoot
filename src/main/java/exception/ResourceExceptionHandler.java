package exception;

import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

// Saiba mais sobre a anotação : https://medium.com/@jovannypcg/understanding-springs-controlleradvice-cd96a364033f
// Ele permite que você lide com exceções em todo o aplicativo, não apenas em um controlador individual.
// Você pode pensar nisso como um interceptador de exceções geradas por métodos anotados com
@ControllerAdvice
public class ResourceExceptionHandler {
    //Criar uma respota para quando não encotnrar nada no end_point
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFond (ObjectNotFoundException e, HttpServletRequest request){
        StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
