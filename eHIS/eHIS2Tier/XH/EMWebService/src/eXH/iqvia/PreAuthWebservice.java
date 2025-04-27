package eXH.iqvia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import eXH.util.ConnectionManager;
import eXH.util.EMDataSource;
import eXH.util.XHUtil;

@Path("/i1")
public class PreAuthWebservice {
	public String l_errcd = "N", responseTxtErrCode=StringUtils.EMPTY;
	public String l_in_JSON = StringUtils.EMPTY, responseTxt = StringUtils.EMPTY,l_app_msg = StringUtils.EMPTY;
	
	@POST
	@Path("/license/payer-license/{CUST_CODE}")
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response PayerLicenseRequest(@PathParam("CUST_CODE") String Cust_Code)
	{
		System.out.println("::: Inside PayerLicenseRequest:::"+Cust_Code);
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		
		String p_response="", errorCode = "", errorMsg = "";
		PreparedStatement pstmt = null;
			
		String l_app_key="<REQUEST_TYPE>PAYER$!^<REQUEST_FIELD>CUST_CODE$!^<REQUEST_ID>"+Cust_Code+"$!^";

		System.out.println("***Inside to call payer license package or procedure...."+l_app_key);
		try
		{   

			dbConn = EMDataSource.getConnection();
			ostmt = dbConn.prepareCall("{ CALL XHPAYER.PAYER_REQUEST_BUILD(?,?,?,?) }" );
			ostmt.setString(1,l_app_key);
			ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			ostmt.execute();
			p_response = ostmt.getString(2);
			errorCode = ostmt.getString(3);
			errorMsg = ostmt.getString(4);
			 
				System.out.println(" ::: p_response ::: "+p_response+" ::: p_errorCode :::"+errorCode+" ::: p_errorMsg :::"+errorMsg);

				if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
				{
					 responseTxt=p_response;
				}
				else
				{
					 responseTxt=p_response;
				}
			

			
		}
		catch(Exception exp)
		{
			System.out.println("***Inside to call procedure - Exception at executing procedure..."+exp);
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(null, ostmt, null);
		}
		
		System.out.println("***Inside to call package or procedure -- responseTxt...."+responseTxt);
		
		String[] str = errorCode.split("#");
		
		System.out.println("::: error code:::"+ errorCode);
		
		if ("S".equals(errorCode))
		{
			
			return Response.ok(responseTxt).header("Access-Control-Allow-Origin", "*")
		      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
		      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
		}	else 
		{
			return Response.serverError().header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
		}
	
	}
	
	
	
	@POST
	@Path("/license/provider-license/{FACILITY_CODE}")
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response ProviderLicenseRequest(@PathParam("FACILITY_CODE") String Facility_Code)
	{
		
	System.out.println("::: Inside ProviderLicenseRequest:::"+Facility_Code);
	String responseTxt="",l_debug_YN="" ;
	Connection dbConn = null;
	ResultSet rs=null;
	CallableStatement ostmt = null;
	
	String p_response="", errorCode = "", errorMsg = "";
	PreparedStatement pstmt = null;
	String l_debug_yn = "";
	
	String l_app_key="<REQUEST_TYPE>FACILITY$!^<REQUEST_FIELD>FACILITY_CODE$!^<REQUEST_ID>"+Facility_Code+"$!^";

	System.out.println("***Inside to call ProviderLicense package or procedure...."+l_app_key);
	try
	{   

		dbConn = EMDataSource.getConnection();
		ostmt = dbConn.prepareCall("{ CALL XHPAYER.FACILITY_REQUEST_BUILD(?,?,?,?) }" );
		ostmt.setString(1,l_app_key);
		ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
		ostmt.execute();
		p_response = ostmt.getString(2);
		errorCode = ostmt.getString(3);
		errorMsg = ostmt.getString(4);
		 
			System.out.println(" ::: p_response ::: "+p_response+" ::: p_errorCode :::"+errorCode+" ::: p_errorMsg :::"+errorMsg);

			if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
			{
				 responseTxt=p_response;
			}
			else
			{
				 responseTxt=p_response;
			}
		

		
	}
	catch(Exception exp)
	{
		System.out.println("***Inside to call procedure - Exception at executing procedure..."+exp);
		exp.printStackTrace(System.err);
	}
	finally
	{			
		
		XHUtil.closeDBResources(null, ostmt, null);
	}
	
	System.out.println("***Inside to call package or procedure -- responseTxt...."+responseTxt);
	
	String[] str = errorCode.split("#");
	
	System.out.println("::: error code:::"+ errorCode);
	
	if ("S".equals(errorCode))
	{
		
		return Response.ok(responseTxt).header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}	else 
	{
		return Response.serverError().header("Access-Control-Allow-Origin", "*")
		      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
		      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
}		
	
	@POST
	@Path("/patient/{PATIENT_ID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response PatientRequest(@PathParam("PATIENT_ID") String Patient_Id)
	{
		
	System.out.println("::: Inside PatientRequest:::"+Patient_Id);
	String responseTxt="",l_debug_YN="" ;
	Connection dbConn = null;
	ResultSet rs=null;
	CallableStatement ostmt = null;
	
	String p_response="", errorCode = "", errorMsg = "";
	PreparedStatement pstmt = null;
	String l_debug_yn = "";
	
	String l_app_key="<REQUEST_TYPE>PATIENT$!^<REQUEST_FIELD>PATIENT_ID$!^<REQUEST_ID>"+Patient_Id+"$!^";

	System.out.println("***Inside to call PatientRequest package or procedure...."+l_app_key);
	try
	{   

		dbConn = EMDataSource.getConnection();
		ostmt = dbConn.prepareCall("{ CALL XHPAYER.PATIENT_REQUEST_BUILD(?,?,?,?) }" );
		ostmt.setString(1,l_app_key);
		ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
		ostmt.execute();
		p_response = ostmt.getString(2);
		errorCode = ostmt.getString(3);
		errorMsg = ostmt.getString(4);
		 
			System.out.println(" ::: p_response ::: "+p_response+" ::: p_errorCode :::"+errorCode+" ::: p_errorMsg :::"+errorMsg);

			if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
			{
				 responseTxt=p_response;
			}
			else
			{
				 responseTxt=p_response;
			}
		

		
	}
	catch(Exception exp)
	{
		System.out.println("***Inside to call procedure - Exception at executing procedure..."+exp);
		exp.printStackTrace(System.err);
	}
	finally
	{			
		
		XHUtil.closeDBResources(null, ostmt, null);
	}
	
	System.out.println("***Inside to call package or procedure -- responseTxt...."+responseTxt);
	
	String[] str = errorCode.split("#");
	
	System.out.println("::: error code:::"+ errorCode);
	
	if ("S".equals(errorCode))
	{
		
		return Response.ok(responseTxt).header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}	else 
	{
		return Response.serverError().header("Access-Control-Allow-Origin", "*")
		      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
		      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
}		

	
	@POST
	@Path("/pharmacy-preauth-respsonse")
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response PreAuthRequest(String actionKey, @Context HttpHeaders headers)
	{
		System.out.println("::: IQVIA PreAuthRequest ::: ");
		String[] str = null;
		try 
		{
			l_app_msg = "::: Inside IQVIA PreAuthRequest INBOUND MESSAGE ::: ";
			System.out.println(l_app_msg+" :::: ");
			IqviaInboundTransaction IqviaInboundMedicationTrans= new IqviaInboundTransaction();
			responseTxtErrCode = IqviaInboundMedicationTrans.InboundDetails("IQVIA", actionKey, "O25");
			System.out.println("IQVIA Insert Operation ResponseTxt(l_errcd) ::::  "+responseTxtErrCode);
			
			str = responseTxtErrCode.split("#");	
			
			System.out.println("strstrstrstrstrstrstrstrstrstr Z::::  "+Arrays.toString(str));	
			
		}
		catch (Exception e)
		{
				e.printStackTrace();
				responseTxt = "E$!^Exception Occured";
				System.out.println("::: Inside IQVIA PreAuthRequest Exception::: "+responseTxt);	
		}
		

		if ("S".equals(str[0]))
		{
			
			return Response.ok(str[0]).header("Access-Control-Allow-Origin", "*")
		      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
		      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
		}	else 
		{
			return Response.serverError().header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
		}
	}     
	
	@POST
	@Path("/eligibility-check-respsonse")
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response EligibilityRequest(String actionKey, @Context HttpHeaders headers)
	{
		System.out.println("::: IQVIA Eligibility Check Response ::: ");
		String[] str = null;
		try 
		{
			l_app_msg = "::: Inside IQVIA Eligibility Check Response INBOUND MESSAGE ::: ";
			System.out.println(l_app_msg+" :::: ");
			IqviaInboundTransaction IqviaInboundMedicationTrans= new IqviaInboundTransaction();
			responseTxtErrCode = IqviaInboundMedicationTrans.InboundDetails("IQVIA", actionKey, "I08");
			System.out.println("IQVIA Insert Operation ResponseTxt(l_errcd) ::::  "+responseTxtErrCode);
			
			str = responseTxtErrCode.split("#");	
			
			System.out.println("strstrstrstrstrstrstrstrstrstr Z::::  "+Arrays.toString(str));	
		}
		catch (Exception e)
		{
				e.printStackTrace();
				responseTxt = "E$!^Exception Occured";
				System.out.println("::: Inside IQVIA PreAuthRequest Exception::: "+responseTxt);	
		}
		

		if ("S".equals(str[0]))
		{
			
			return Response.ok(str[0]).header("Access-Control-Allow-Origin", "*")
		      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
		      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
		}	else 
		{
			return Response.serverError().header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
		}
	}     
	
	

}
