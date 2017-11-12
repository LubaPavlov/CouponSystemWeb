package dev.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.beans.Company;
import com.project.beans.Coupon;
import com.project.exceptions.FacadeException;
import com.project.facade.AdminFacade;
import com.project.facade.CompanyFacade;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/company")
public class CompanyService {
	@Context
	HttpServletRequest request;
	@Context
	private HttpServletResponse response;
	CompanyFacade companyFacade = null;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getcoupons")
	public Response getAllCoupons() {

		HttpSession session = request.getSession(false);
		CompanyFacade companyFacade = (CompanyFacade)session.getAttribute("facade");
		Collection<Coupon> coupons = null;
		try {
			coupons = companyFacade.getAllCoupons();
			GenericEntity<Collection<Coupon>> genericEntity = new GenericEntity<Collection<Coupon>>(coupons) {
			};
			return Response.ok(genericEntity).status(200).build();
		} catch (FacadeException e) {
			e.printStackTrace();
			return Response.ok(e.getMessage()).status(500).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("coupon")
	public Response createCoupon(Coupon coupon) {

		HttpSession session = request.getSession(false);
		CompanyFacade companyFacade = (CompanyFacade)session.getAttribute("facade");
		try {
				companyFacade.createCoupon(coupon);
				return Response.ok(coupon).status(200).build();
		} catch (FacadeException e) {
				return Response.ok(e.getMessage()).status(500).build();
		}
	}

	@DELETE
	@Path("deletecoupon/{couponId}")
	public Response deleteCoupon(@PathParam("couponId") long couponId) {
		HttpSession session = request.getSession(false);
		CompanyFacade companyFacade = (CompanyFacade)session.getAttribute("facade");
			Coupon coupon;
			try {
				coupon = companyFacade.getCoupon(couponId);
				companyFacade.removeCoupon(coupon);
				return Response.ok().status(200).build();
			} catch (FacadeException e) {
				e.printStackTrace();
				return Response.ok(e.getMessage()).status(500).build();
			}
	}
	
}
