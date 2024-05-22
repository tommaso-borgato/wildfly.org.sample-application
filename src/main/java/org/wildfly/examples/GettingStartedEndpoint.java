package org.wildfly.examples;

import jakarta.inject.Inject;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.Serializable;

@Path("/")
public class GettingStartedEndpoint implements Serializable {

	@Inject
	private GettingStartedService service;

	@GET
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello(final @PathParam("name") String name) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
		String response = service.hello(name);
		return Response.ok(response).build();
	}
}
