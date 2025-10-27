package com.ecommerce.orderpaymentservice.domain.model.tokenprovider.gateway;


import com.ecommerce.orderpaymentservice.domain.model.usersession.UserSession;

/**
 * Defines a contract to validate jwt tokens
 */
public interface TokenProviderRepository {

    UserSession validateToken(String token);
}
