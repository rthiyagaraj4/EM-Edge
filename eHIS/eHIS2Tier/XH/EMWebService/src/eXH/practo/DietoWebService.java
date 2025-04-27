package eXH.practo;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eXH.util.XHUtil;

@Path("/v1")
public class DietoWebService {
	public static String l_debug_YN = "N";
	public static String l_app_msg = "";
	
	//Added for KDAH-CRF-0533 on 11/12/2019
	@POST
	@Path("/DietoOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response OrderTrans(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			l_app_msg = " ::: Inside Dietto OrderTrans ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Actionkey : "+actionKey;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			DietoOrderTransaction diettoOrderTransaction = new DietoOrderTransaction();
			responseTxt = diettoOrderTransaction.processDietoRequest(actionKey);
			
			l_app_msg = " ::: Respose Text : "+responseTxt;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			str = responseTxt.split("#");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	//Added for KDAH-CRF-0586 on 04/05/2021
	@POST
	@Path("/SafeTransOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response SafeTransOrder(String actionKey) {
		String responseTxt = "";
		String[] str = null;
		
		try {
			
			l_debug_YN = XHUtil.getDebugYN();
			
			l_app_msg = " ::: Inside Dietto OrderTrans ::: ";
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Actionkey : "+actionKey;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			DietoOrderTransaction diettoOrderTransaction = new DietoOrderTransaction();
			responseTxt = diettoOrderTransaction.processSafeTransRequest(actionKey);
			
			l_app_msg = " ::: Respose Text : "+responseTxt;
			if (l_debug_YN.equals("Y"))	System.out.println(l_app_msg);
			
			str = responseTxt.split("#");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseTxt = "E#Exception Occured";
		}
		return Response.status(responseCode(str[0])).entity(str[1]).build();
	}
	
	public Response.Status responseCode(String code){
		if (code.equals("200")) {
			return Response.Status.OK;
		} else if (code.equals("400")) {
			return Response.Status.BAD_REQUEST;
		} else if (code.equals("401")) {
			return Response.Status.UNAUTHORIZED;
		} else if (code.equals("403")) {
			return Response.Status.FORBIDDEN;
		} else  {
			return Response.Status.INTERNAL_SERVER_ERROR;
		}
	}

}
