package dev.web;

import java.util.Collection;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.project.beans.Company;
import com.project.beans.Customer;
import com.project.exceptions.DAOException;
import com.project.exceptions.FacadeException;
import com.project.facade.AdminFacade;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/admin")
public class AdminService {

	@Context
	HttpServletRequest request;
	@Context
	private HttpServletResponse response;
	AdminFacade adminFacade = null;
	// Gson gson = new Gson();

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("createcompany")
	public Response createCompany(Company company) {

		HttpSession session = request.getSession(false);
		AdminFacade adminFacade = (AdminFacade) session.getAttribute("facade");
		try {
			adminFacade.createCompany(company);
			return Response.ok(company).status(200).build();
		} catch (FacadeException e) {
			return Response.ok(e.getMessage()).status(500).build();
		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("createcustomer")
	public Response createCustomer(Customer customer) {

		HttpSession session = request.getSession(false);
		AdminFacade adminFacade = (AdminFacade) session.getAttribute("facade");
		try {
			adminFacade.createCustomer(customer);
			return Response.ok(customer).status(200).build();
		} catch (FacadeException e) {
			return Response.ok(e.getMessage()).status(500).build();
		}

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("deletecompany/{compName}")
	public Response removeCompany(@PathParam("compName") String compName) {

		HttpSession session = request.getSession(false);
		AdminFacade adminFacade = (AdminFacade) session.getAttribute("facade");
		try {
			long compId = adminFacade.getCompanyIdByName(compName);
			adminFacade.removeCompany(adminFacade.getCompanyById(compId));
			return Response.ok().status(200).build();
		} catch (FacadeException e) {
			return Response.ok(e.getMessage()).status(500).build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("updatecompany")
	public Response updateCompany(Company company) {

		HttpSession session = request.getSession(false);
		AdminFacade adminFacade = (AdminFacade) session.getAttribute("facade");
		try {

			// long compId = adminFacade.getCompanyIdByName(compName);
			// adminFacade.removeCompany(adminFacade.getCompanyById(compId));
			adminFacade.updateCompany(company);
			return Response.ok().status(200).build();
		} catch (FacadeException e) {
			e.printStackTrace();
			return Response.ok(e.getMessage()).status(500).build();
		}

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("deletecustomer/{custName}")
	public Response removeCustomer(@PathParam("custName") String custName) {

		HttpSession session = request.getSession(false);
		AdminFacade adminFacade = (AdminFacade) session.getAttribute("facade");
		try {
			//long compId = adminFacade.getCompanyIdByName(compName);
			adminFacade.removeCustomer(adminFacade.getCustomerByName(custName));
			return Response.ok().status(200).build();
		} catch (FacadeException e) {
			return Response.ok(e.getMessage()).status(500).build();
		}


	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("updatecustomer")
	public Response updateCustomer(Customer customer) {

		HttpSession session = request.getSession(false);
		AdminFacade adminFacade = (AdminFacade) session.getAttribute("facade");
		try {
			adminFacade.updateCustomer(customer);
			return Response.ok().status(200).build();
		} catch (FacadeException e) {
			e.printStackTrace();
			return Response.ok(e.getMessage()).status(500).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getcustomer/{custName}")
	public Response getCustomer(@PathParam("custName") String custName) {

		HttpSession session = request.getSession(false);
		AdminFacade adminFacade = (AdminFacade) session.getAttribute("facade");
		Customer customer = null;
		try {
			//customer = adminFacade.getCustomerByName(custName);
			customer = adminFacade.getCustomerByName(custName);
			return Response.ok(customer).status(200).build();

		} catch (FacadeException e) {
			e.printStackTrace();
			return Response.ok(e.getMessage()).status(500).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getcompany/{compName}")
	public Response getCompany(@PathParam("compName") String compName) {

		HttpSession session = request.getSession(false);
		AdminFacade adminFacade = (AdminFacade) session.getAttribute("facade");
		Company company = null;
		try {
			company = adminFacade.getCompanyById(adminFacade.getCompanyIdByName(compName));
			return Response.ok(company).status(200).build();

		} catch (FacadeException e) {
			e.printStackTrace();
			return Response.ok(e.getMessage()).status(500).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getcustomers")
	public Response getAllCustomers() {

		HttpSession session = request.getSession(false);
		AdminFacade adminFacade = (AdminFacade) session.getAttribute("facade");
		Collection<Customer> customers = null;
		try {

			customers = adminFacade.getAllCustomers();
			GenericEntity<Collection<Customer>> genericEntity = new GenericEntity<Collection<Customer>>(customers) {
			};
			return Response.ok(genericEntity).status(200).build();
		} catch (FacadeException e) {
			e.printStackTrace();
			return Response.ok(e.getMessage()).status(500).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getcompanies")
	public Response getAllCompanies() {

		HttpSession session = request.getSession(false);
		AdminFacade adminFacade = (AdminFacade) session.getAttribute("facade");
		Collection<Company> companies = null;
		try {
			companies = adminFacade.getAllCompanies();
			GenericEntity<Collection<Company>> genericEntity = new GenericEntity<Collection<Company>>(companies) {
			};
			return Response.ok(genericEntity).status(200).build();
		} catch (FacadeException e) {
			e.printStackTrace();
			return Response.ok(e.getMessage()).status(500).build();
		}
	}

}
