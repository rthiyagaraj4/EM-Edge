package eXH.iqvia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import eXH.util.EMDataSource;
import eXH.util.XHUtil;

@Path("/p1")
public class IqviaPractitionerWebService {


	public String l_errcd = "N", responseTxtErrCode=StringUtils.EMPTY; 
	String l_in_JSON = StringUtils.EMPTY, responseTxt = StringUtils.EMPTY, l_practitioner_id = StringUtils.EMPTY, l_app_msg = StringUtils.EMPTY;


	@POST
	@Path("/practitioner")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Response PractitionerRequest(String actionKey, @Context HttpHeaders headers) {

		System.out.println("::: IQVIA PractitionerRequest ::: ");
		String[] str = null;
		try {

			l_app_msg = "::: Inside IQVIA INBOUND MESSAGE ::: ";
			System.out.println(l_app_msg+" :::: "+l_practitioner_id);

			IqviaInboundTransaction IqviaInboundPractTrans = new IqviaInboundTransaction();
			responseTxtErrCode = IqviaInboundPractTrans.InboundDetails("IQVIA", actionKey, "I08");
			System.out.println("IQVIA Insert Operation ResponseTxt ::::  "+responseTxtErrCode);	
			
			str = responseTxtErrCode.split("#");	
			
			System.out.println("strstrstrstrstrstrstrstrstrstr Z::::  "+Arrays.toString(str));	
			
			if("S".equals(str[0])){
				responseTxt = IqviaPract(actionKey, responseTxtErrCode);	
				System.out.println("IQVIA PractitionerRequest Insert Operation ResponseTxt ::::  "+responseTxt);	
			}else{
				responseTxt = "Error in Loading the request message Status";
				System.out.println("PractitionerRequest Response TXT ERROR ::::"+responseTxt);
			}


		} catch (Exception e) {

			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
			System.out.println("::: Inside IQVIA PractitionerRequest Exception::: "+responseTxt);	

		}

		str = responseTxt.split("#");	
		return Response.status(responseCode(str[0])).entity(str[1]).build();

	}



	private String IqviaPract(String actionKey, String responseTxtErrCode){

		String returnPractIdFinalMessage="The Practitioner Id cannot be blank";	

		String[] str = null;

		try {

			System.out.println("::: Inside IQVIA Method:::" );
			JSONParser parser = new JSONParser(); JSONObject json = (JSONObject) parser. parse(actionKey);

			JSONArray identifier_array = (JSONArray)json.get("identifier");

			for(int i=0; i<identifier_array.size(); i++) {
				JSONObject jsonObj = (JSONObject) identifier_array.get(i);
				String identifier_use = (String) jsonObj.get("use");

				if(identifier_use !=null){
					if("usual".equals(identifier_use)){
						l_practitioner_id = (String)jsonObj.get("value");
					}				
				}
			}

			l_app_msg = "::: Fetching Practitioner ID ::: ";
			System.out.println(l_app_msg);

			l_app_msg = "Practitioner ID : " + l_practitioner_id;
			System.out.println(l_app_msg);

			String practitionerId = "SELECT * FROM AM_PRACTITIONER WHERE PRACTITIONER_ID =" + "'" +l_practitioner_id+ "'";

			l_app_msg = "::: Inside IQVIA  practitionerId ::: ";
			System.out.println(l_app_msg+" :::: "+practitionerId);

			Connection dbConn = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmtForSelect = null;
			ResultSet rs = null;

			int practitionerIdCount = 0;

			try
			{

				dbConn = EMDataSource.getConnection();

				pstmtForSelect = dbConn.prepareStatement(practitionerId, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				rs = pstmtForSelect.executeQuery();

				if (rs != null) 
				{
					rs.last();   
					practitionerIdCount = rs.getRow();
				}

				l_app_msg = "::: Inside IQVIA  practitionerIdCount ::: ";
				System.out.println(l_app_msg+" :::: "+practitionerIdCount);

				if(practitionerIdCount > 0 ){

					l_app_msg = "::: Inside IQVIA  PractitionerId already Exists so UPDATE OPERATION::: ";
					System.out.println(l_app_msg+" :::: "+l_practitioner_id);

					IqviaPractitionerUpdateTransaction IqviaPractUpdate = new IqviaPractitionerUpdateTransaction();
					responseTxt = IqviaPractUpdate.PractUpdateTransRequestMethod("IQVIA", actionKey);

					str = responseTxt.split("#");
					System.out.println("Response TXT str 111111::::"+Arrays.toString(str));	

					updateXH_Inbound_MessageStatus(actionKey, str[0], str[1]);

					System.out.println("IQVIA Update Operation ResponseTxt :::: "+responseTxt);

				}else{

					l_app_msg = "::: Inside IQVIA  PractitionerId does not exists so INSERT OPERATION::: ";
					System.out.println(l_app_msg+" :::: "+l_practitioner_id);

					IqviaPractitionerTransaction IqviaPractInsert = new IqviaPractitionerTransaction();
					responseTxt = IqviaPractInsert.PractInsertTransRequestMethod("IQVIA", actionKey);

					str = responseTxt.split("#");
					System.out.println("Response TXT str 1111111::::"+Arrays.toString(str));	

					updateXH_Inbound_MessageStatus(actionKey, str[0], str[1]);

					System.out.println("IQVIA Insert Operation ResponseTxt :::: "+responseTxt);	

				}

			}catch (Exception exp) {
				exp.printStackTrace(System.err);
				System.out.println("(IqviaTransaction :: InsertPratitioner) Exception " + exp);
			}		
			finally {
				XHUtil.closeDBResources(null, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}	


		} catch (Exception exp) {

			System.out.println("( ::: IQVIAWebService:IqviaTransactions) Exception at executing procedure ::: "+exp.getMessage());
			exp.printStackTrace(System.err);
			return returnPractIdFinalMessage;

		}

		return responseTxt;

	}	


	private void updateXH_Inbound_MessageStatus(String actionKey, String responseTxtErrCode, String responseTxtErrMsg){

		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;


		try {

			String l_mesid = StringUtils.EMPTY;

			System.out.println("::: Inside IQVIA updateXH_Inbound_MessageStatus :::" );
			System.out.println("::: Inside IQVIA updateXH_Inbound_MessageStatus responseTxtErrCode ::: "+responseTxtErrCode);


			String latestInsertedRow = "SELECT MAX(MESSAGE_ID)AS MESGID FROM XH_INBOUND_MESSAGE " +
					"WHERE APPLICATION_ID='IQVIA' AND MESSAGE_STATUS IS NULL";

			l_app_msg = "::: Inside IQVIA  latestInsertedRow ::: ";
			System.out.println(l_app_msg+" :::: "+latestInsertedRow);

			dbConn = EMDataSource.getConnection();

			pstmt = dbConn.prepareStatement(latestInsertedRow);

			rs = pstmt.executeQuery();

			rs.next();
			l_mesid = rs.getString("mesgid");

			l_app_msg = "::: Inside Update iNBOUND l_mesid ::: ";
			System.out.println(l_app_msg+" :::: "+l_mesid);


			int updateCount = 0;

			String practupdatestmt = StringUtils.EMPTY;

			practupdatestmt = "UPDATE XH_INBOUND_MESSAGE SET MESSAGE_STATUS =" + "'" + responseTxtErrCode + "' , "+
					"ERR_MSG =" + "'" + responseTxtErrMsg + "' WHERE MESSAGE_ID =" + "'" +l_mesid+ "'";


			l_app_msg = "::: Inside Update iNBOUND STATUS practupdatestmt ::: ";
			System.out.println(l_app_msg+" :::: "+practupdatestmt);


			pstmt = dbConn.prepareStatement(practupdatestmt);		

			updateCount = pstmt.executeUpdate();

			if (updateCount == 1) {
				System.out.println("updateXH_Inbound_MessageStatus  Record Updated Successfully");
				l_errcd = "S";
				dbConn.commit();
			} else {
				System.out.println("updateXH_Inbound_MessageStatus  Error in Updating the record");
				l_errcd = "E";
				dbConn.rollback();
			}


		} catch (Exception exp) {

			System.out.println("( ::: IQVIAWebService:IqviaTransactions) Exception at executing procedure ::: "+exp.getMessage());
			exp.printStackTrace(System.err);

		}finally {
			XHUtil.closeDBResources(null, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}	

	}
	
	@POST
	@Path("/practitioner-role")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Response PractitionerRoleRequest(String actionKey, @Context HttpHeaders headers) {

		System.out.println("::: IQVIA PractitionerRole ::: ");
		String[] str = null;
		try {

			l_app_msg = "::: Inside IQVIA INBOUND MESSAGE ::: ";
			System.out.println(l_app_msg+" :::: "+l_practitioner_id);

			IqviaInboundTransaction IqviaInboundPractTrans = new IqviaInboundTransaction();
			responseTxtErrCode = IqviaInboundPractTrans.InboundDetails("IQVIA", actionKey, "I08");
			System.out.println("IQVIA PractitionerRoleRequest Insert Operation ResponseTxt(l_errcd)::::  "+responseTxtErrCode);	

			str = responseTxtErrCode.split("#");	
						
			System.out.println("strstrstrstrstrstrstrstrstrstr Zzzzzzzzzzzzzzzzzzzzz::::  "+Arrays.toString(str));	
			
			if("S".equals(str[0])){
				responseTxt = IqviaPractRole(actionKey, responseTxtErrCode);	
				System.out.println("IQVIA PractitionerRoleRequest Insert Operation ResponseTxt::::  "+responseTxt);	
			}else{
				responseTxt = "Error in Loading the request message Status";
				System.out.println("PractitionerRoleRequest Response TXT ERROR ::::"+responseTxt);
			}


		} catch (Exception e) {

			e.printStackTrace();
			responseTxt = "E$!^Exception Occured";
			System.out.println("::: Inside IQVIA PractitionerRoleRequest Exception::: "+responseTxt);	

		}

		str = responseTxt.split("#");
		return Response.status(responseCode(str[0])).entity(str[1]).build();

	}
		
	private String IqviaPractRole(String actionKey, String responseTxtErrCode){

		String returnPractIdFinalMessage="The Practitioner Id cannot be blank";	

		String[] str = null;

		try {

			System.out.println("::: Inside IQVIA Method :::" );
			JSONParser parser = new JSONParser(); JSONObject json = (JSONObject) parser. parse(actionKey);

			JSONArray identifier_array = (JSONArray)json.get("identifier");

			for(int i=0; i<identifier_array.size(); i++) {
				JSONObject jsonObj = (JSONObject) identifier_array.get(i);
						l_practitioner_id = (String)jsonObj.get("value");
			}

			l_app_msg = "::: Fetching Practitioner ID ::: ";
			System.out.println(l_app_msg);

			l_app_msg = "Practitioner ID : " + l_practitioner_id;
			System.out.println(l_app_msg);

			String practitionerId = "SELECT * FROM AM_PRACTITIONER WHERE PRACTITIONER_ID =" + "'" +l_practitioner_id+ "'";

			l_app_msg = "::: Inside IQVIA  practitionerId ::: ";
			System.out.println(l_app_msg+" :::: "+practitionerId);

			Connection dbConn = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmtForSelect = null;
			ResultSet rs = null;

			int practitionerIdCount = 0;

			try
			{

				dbConn = EMDataSource.getConnection();

				pstmtForSelect = dbConn.prepareStatement(practitionerId, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				rs = pstmtForSelect.executeQuery();

				if (rs != null) 
				{
					rs.last();   
					practitionerIdCount = rs.getRow();
				}

				l_app_msg = "::: Inside IQVIA  practitionerIdCount ::: ";
				System.out.println(l_app_msg+" :::: "+practitionerIdCount);

				if(practitionerIdCount > 0 ){

					l_app_msg = "::: Inside IQVIA  PractitionerId already Exists so UPDATE OPERATION::: ";
					System.out.println(l_app_msg+" :::: "+l_practitioner_id);

					IqviaPractitionerRoleUpdateTransaction IqviaPractRoleUpdate = new IqviaPractitionerRoleUpdateTransaction();
					responseTxt = IqviaPractRoleUpdate.PractRoleUpdateTransRequestMethod("IQVIA", actionKey);

					str = responseTxt.split("#");
					System.out.println("Response TXT str ::::"+Arrays.toString(str));	

					updateXH_Inbound_MessageStatus(actionKey, str[0], str[1]);

					System.out.println("IQVIA Update Operation ResponseTxt :::: "+responseTxt);

				}else{
					
					l_app_msg = "::: Inside IQVIA PractitionerId does not exists so INSERT OPERATION ::: ";
					System.out.println(l_app_msg+" :::: "+l_practitioner_id);

					IqviaPractitionerRoleUpdateTransaction IqviaPractRoleUpdate = new IqviaPractitionerRoleUpdateTransaction();
					responseTxt = IqviaPractRoleUpdate.PractRoleUpdateErrorMethod("IQVIA", actionKey);
					
					//responseTxt ="E#Error in Updating the record, Practitioner ID not available";
							
					str = responseTxt.split("#");
					System.out.println("Response TXT str ::::"+Arrays.toString(str));	

					updateXH_Inbound_MessageStatus(actionKey, str[0], str[1]);

					System.out.println("IQVIA Insert Operation ResponseTxt :::: "+responseTxt);	

				}

			}catch (Exception exp) {
				exp.printStackTrace(System.err);
				System.out.println("(IqviaTransaction :: InsertPratitioner) Exception " + exp);
			}		
			finally {
				XHUtil.closeDBResources(null, pstmt, null);
				EMDataSource.returnConnection(dbConn);
			}	


		} catch (Exception exp) {

			System.out.println("( ::: IQVIAWebService:IqviaTransactions) Exception at executing procedure ::: "+exp.getMessage());
			exp.printStackTrace(System.err);
			return returnPractIdFinalMessage;

		}

		return responseTxt;

	}
	
	public Response.Status responseCode(String code){
		if (code.equals("S")) {
			return Response.Status.OK;
		} else if (code.equals("E")) {
			return Response.Status.BAD_REQUEST;
		} else if (code.equals("E")) {
			return Response.Status.UNAUTHORIZED;
		} else if (code.equals("E")) {
			return Response.Status.FORBIDDEN;
		} else  {
			return Response.Status.INTERNAL_SERVER_ERROR;
		}
	}
}
