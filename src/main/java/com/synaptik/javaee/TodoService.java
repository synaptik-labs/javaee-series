package com.synaptik.javaee;

import com.synaptik.javaee.data.TodoInput;
import com.synaptik.javaee.entities.Todo;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Api(tags={"todo"})
public class TodoService {
	@Inject
	TodoEJB ejb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Fetches all to dos")
	@ApiResponses({
			@ApiResponse(code=200, message="Success")
	})
	public List<Todo> getAll() {
		return ejb.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Creates a new todo")
	@ApiResponses({
			@ApiResponse(code=204, message="Success")
	})
	public void create(@ApiParam(required = true) TodoInput incoming) {
		Todo todo = new Todo();
		todo.setDescription(incoming.getDescription());
		ejb.create(todo);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Updates a new todo")
	@ApiResponses({
			@ApiResponse(code=204, message="Success"),
			@ApiResponse(code=404, message="Not Found")
	})
	public void update(
		@ApiParam(required = true) @PathParam("id") Long id,
		@ApiParam(required = true) TodoInput incoming) {
		Todo todo = new Todo();
		todo.setDescription(incoming.getDescription());

		ejb.update(id, todo);
	}

	@DELETE
	@Path("{id}")
	@ApiOperation(value="Removes a new todo")
	@ApiResponses({
			@ApiResponse(code=204, message="Success"),
			@ApiResponse(code=404, message="Not Found")
	})
	public void remove(@ApiParam(required = true) @PathParam("id") Long id) {
		ejb.remove(id);
	}
}
