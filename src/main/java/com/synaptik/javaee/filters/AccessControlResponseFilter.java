package com.synaptik.javaee.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class AccessControlResponseFilter implements ContainerResponseFilter {
	public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
		containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", "http://localhost:3000");
		containerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
		containerResponseContext.getHeaders().add("Access-Control-Allow-Headers", "Content-Type");
		containerResponseContext.getHeaders().add("Access-Control-Max-Age", "10");
	}
}
