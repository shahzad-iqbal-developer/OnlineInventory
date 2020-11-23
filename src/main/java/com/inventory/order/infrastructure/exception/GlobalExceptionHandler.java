package com.inventory.order.infrastructure.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OnlineInventoryException.class)
    public ResponseEntity<HttpErrorResponse> handleOnlineInventoryException(OnlineInventoryException ex) {
        return new ResponseEntity<>(new HttpErrorResponse.Builder()
                .timestamp(Timestamp.from(Instant.now()))
                .status(ex.getStatus())
                .error(ex.getStatus().getReasonPhrase())
                .message(ex.getMessage())
                .build(), new HttpHeaders(), ex.getStatus());
    }


    static class HttpErrorResponse {
        private Timestamp timestamp;
        private HttpStatus status;
        private String error;
        private String message;

        public static class Builder {
            private Timestamp timestamp;
            private HttpStatus status;
            private String error;
            private String message;

            public Builder timestamp(Timestamp timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public Builder status(HttpStatus status) {
                this.status = status;
                return this;
            }

            public Builder error(String error) {
                this.error = error;
                return this;
            }

            public Builder message(String message) {
                this.message = message;
                return this;
            }

            public HttpErrorResponse build() {
                HttpErrorResponse httpErrorResponse = new HttpErrorResponse();
                httpErrorResponse.timestamp = this.timestamp;
                httpErrorResponse.status = this.status;
                httpErrorResponse.error = this.error;
                httpErrorResponse.message = this.message;
                return httpErrorResponse;
            }
        }
    }
}
