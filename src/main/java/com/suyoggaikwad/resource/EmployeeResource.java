package com.suyoggaikwad.resource;

import com.suyoggaikwad.model.Employee;
import com.suyoggaikwad.service.EmployeeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/employees")
public class EmployeeResource {

    EmployeeService service = new EmployeeService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee addEmployee(Employee employee) {
        return service.addEmployee(employee);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Employee updateEmployee(@QueryParam("name") String name, @QueryParam("id") int id) {
        return service.updateEmployee(name, id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public  Employee deleteEmployee(@PathParam("name") String name) {
        return service.deleteEmployee(name);
    }

}
