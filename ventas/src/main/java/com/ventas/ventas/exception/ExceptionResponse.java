package com.ventas.ventas.exception;

import java.util.Date;
import java.util.Map;

public class ExceptionResponse {
    private Date timestamp;
    private String mensaje;
    private String detalles;
    private Map<String, String> errorsValidation;

        public ExceptionResponse() {

    }

    public ExceptionResponse(Date timestamp, String mensaje, String detalles) {
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    /** en caso de errores del tipo validación */
    public ExceptionResponse(Date timestamp, String mensaje, String detalles, Map<String, String> errorsValidation) {
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
        this.errorsValidation = errorsValidation;
    }



    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getDetalles() {
        return detalles;
    }
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    public Map<String, String> getErrorsValidation() {
        return errorsValidation;
    }
    public void setErrorsValidation(Map<String, String> errorsValidation) {
        this.errorsValidation = errorsValidation;
    }
    
}
