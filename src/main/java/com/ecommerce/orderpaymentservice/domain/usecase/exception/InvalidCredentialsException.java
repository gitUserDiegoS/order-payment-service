package com.ecommerce.orderpaymentservice.domain.usecase.exception;


import com.ecommerce.orderpaymentservice.domain.bussinesexception.BusinessException;
import com.ecommerce.orderpaymentservice.domain.bussinesexception.ErrorCodes;

public class InvalidCredentialsException extends BusinessException {
    public InvalidCredentialsException(String message) {
        super(message, ErrorCodes.UNAUTHORIZED);
    }
}
