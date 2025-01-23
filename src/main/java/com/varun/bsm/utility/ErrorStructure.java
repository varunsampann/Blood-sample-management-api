package com.varun.bsm.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorStructure <T>{

        private int status;
        private String message;
        private T rootCause;
//
//
//        public int getStatus() {
//            return status;
//        }
//        public void setStatus(int status) {
//            this.status = status;
//        }
//        public String getMessage() {
//            return message;
//        }
//        public void setMessage(String message) {
//            this.message = message;
//        }
//        public String getRootCause() {
//            return rootCause;
//        }
//        public void setRootCause(String rootCause) {
//            this.rootCause = rootCause;
//        }
//
//        public static ErrorStructure create(int status, String message, String rootCause) {
//            ErrorStructure error = new ErrorStructure();
//            error.setMessage(message);
//            error.setStatus(status);
//            error.setRootCause(rootCause);
//            return error;
//        }

    }



