package com.synaptik.javaee;

import com.synaptik.javaee.data.Todo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class TodoService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todo> getAll() {
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Todo incoming) {

	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(@PathParam("id") Long id, Todo incoming) {

	}

	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") Long id) {
	}
}
