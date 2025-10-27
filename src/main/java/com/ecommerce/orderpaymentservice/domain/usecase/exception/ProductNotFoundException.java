package com.ecommerce.orderpaymentservice.domain.usecase.exception;


import com.ecommerce.orderpaymentservice.domain.bussinesexception.BusinessException;
import com.ecommerce.orderpaymentservice.domain.bussinesexception.ErrorCodes;

public class ProductNotFoundException extends BusinessException {
    public ProductNotFoundException(String message) {
        super(message, ErrorCodes.NOT_FOUND);
    }
}
