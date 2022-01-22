package ec.edu.espe.arquitectura.examen.exception;

public class EntityExistsException extends RuntimeException{

    public EntityExistsException(String msg) {
        super(msg);
    }
    
}
