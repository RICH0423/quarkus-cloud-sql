package org.rich.gcp.sql;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.rich.gcp.sql.entity.Customer;
import org.rich.gcp.sql.repository.CustomerRepository;
import org.rich.gcp.sql.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class Application {

    @Inject
    GreetingService service;

    @Inject
    CustomerRepository customerRepository;

    @GET
    @Path("/customers")
    @Produces(MediaType.TEXT_PLAIN)
    public List<Customer> getCustomers() {
        return customerRepository.listAll();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam String name) {
        return service.greeting(name);
    }
}