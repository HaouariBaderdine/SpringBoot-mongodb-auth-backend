package com.example.demo.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/*
 * Maintenant, nous créons une AuthEntryPointJwtclasse qui implémente
 * l' AuthenticationEntryPointinterface. Ensuite, nous remplaçons
 * la commence()méthode. Cette méthode sera déclenchée à chaque fois
 * qu'un utilisateur non authentifié demande une ressource HTTP sécurisée
 * et un AuthenticationExceptionest renvoyé.
 */

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("Unauthorized error: {}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	}
	
	/*
	 * HttpServletResponse.SC_UNAUTHORIZEDest le code d'état 401 .
	 * Il indique que la demande nécessite une authentification HTTP.
	 */

}
