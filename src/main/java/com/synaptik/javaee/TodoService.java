package com.synaptik.javaee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class TodoService {
	@GET
	public String get() {
		return "Hello Jimmy!";
	}
}
