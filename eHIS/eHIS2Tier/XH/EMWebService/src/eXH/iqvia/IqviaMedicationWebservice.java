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


@Path("/m1")
public class IqviaMedicationWebservice 
{
	public String l_errcd = "N", responseTxtErrCode=StringUtils.EMPTY;
	String l_in_JSON = StringUtils.EMPTY, responseTxt = StringUtils.EMPTY, l_item_code = StringUtils.EMPTY, l_app_msg = StringUtils.EMPTY;
	
	@POST
	@Path("/medication")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Response MedicationRequest(String actionKey, @Context HttpHeaders headers)
	{
		System.out.println("::: IQVIA MedicationRequest ::: ");
		String[] str = null;
		try 
		{
			l_app_msg = "::: Inside IQVIA INBOUND MESSAGE ::: ";
			System.out.println(l_app_msg+" :::: "+l_item_code);
			IqviaInboundTransaction IqviaInboundMedicationTrans= new IqviaInboundTransaction();
			responseTxtErrCode = IqviaInboundMedicationTrans.InboundDetails("IQVIA", actionKey, "I08");
			System.out.println("IQVIA Insert Operation ResponseTxt(l_errcd) ::::  "+responseTxtErrCode);
			
			str = responseTxtErrCode.split("#");	
			
			System.out.println("strstrstrstrstrstrstrstrstrstr Z::::  "+Arrays.toString(str));	
			
			if("S".equals(str[0])){
				responseTxt = IqviaMedication(actionKey, responseTxtErrCode);	
				System.out.println("IQVIA MedicationRequest Insert Operation ResponseTxt ::::  "+responseTxt);	
			}else{
				responseTxt = "Error in Loading the request message Status";
				System.out.println("MedicationRequest Response TXT ERROR ::::"+responseTxt);
			}

		}
		catch (Exception e)
		{
				e.printStackTrace();
				responseTxt = "E$!^Exception Occured";
				System.out.println("::: Inside IQVIA MedicationRequest Exception::: "+responseTxt);	
		}
		
		
		str = responseTxt.split("#");

		if("S".equals(str[0])){
			System.out.println("::: Inside IQVIA MedicationRequest ::: "+responseTxt);		
			return Response.status(200).entity(responseTxt).build();
		}else if("E".equals(str[0])){
			return Response.status(404).entity(responseTxt).build();
		}else{
			return Response.status(404).entity(responseTxt).build();
		}
	}
	
	private String IqviaMedication(String actionKey, String responseTxtErrCode)
	{
		String returnItemCodeFinalMessage="The ItemCode cannot be blank";	

		String[] str = null;
		
		try
		{
			System.out.println("::: Inside IQVIA Method:::" );
			JSONParser parser = new JSONParser(); 
			JSONObject json = (JSONObject) parser. parse(actionKey);
			JSONObject jsonObj=(JSONObject)json.get("code");
			JSONArray coding_array = (JSONArray)jsonObj.get("coding");
			
			for(int i=0; i<coding_array.size(); i++)
			{
				JSONObject json_Obj = (JSONObject) coding_array.get(i);
				String code_coding_code = (String) json_Obj.get("code");
				
				if(code_coding_code !=null)
				{
					l_item_code=(String) json_Obj.get("code");
				}
			
			}
			
			l_app_msg = "::: Fetching ItemCode ::: ";
			System.out.println(l_app_msg);

			l_app_msg = "ItemCode : " + l_item_code;
			System.out.println(l_app_msg);
			
			String ItemCode = "SELECT * FROM MM_ITEM WHERE ITEM_CODE =" + "'" +l_item_code+ "'";
			
			l_app_msg = "::: Inside IQVIA  ItemCode ::: ";
			System.out.println(l_app_msg+" :::: "+ItemCode);
			
			Connection dbConn = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmtForSelect = null;
			ResultSet rs = null;
			
			int ItemCodeCount = 0;
			
			try
			{
				dbConn = EMDataSource.getConnection();
				pstmtForSelect = dbConn.prepareStatement(ItemCode, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = pstmtForSelect.executeQuery();
				if (rs != null) 
				{
					rs.last();   
					ItemCodeCount = rs.getRow();
				}
				
				l_app_msg = "::: Inside IQVIA  ItemCodeCount ::: ";
				System.out.println(l_app_msg+" :::: "+ItemCodeCount);
				
				if(ItemCodeCount > 0 )
				{
					l_app_msg = "::: Inside IQVIA  ItemCode already Exists so UPDATE OPERATION::: ";
					System.out.println(l_app_msg+" :::: "+l_item_code);
					IqviaMedicationUpdateTransaction IqviaMedicationUpdate = new IqviaMedicationUpdateTransaction();
					responseTxt = IqviaMedicationUpdate.MedicationUpdateTransRequestMethod("IQVIA", actionKey);
					
					str = responseTxt.split("#");
					System.out.println("Response TXT str ::::"+Arrays.toString(str));
					
					updateXH_Inbound_MessageStatus(actionKey, str[0], str[1]);

					System.out.println("IQVIA Update Operation ResponseTxt :::: "+responseTxt);
				} 
				else
				{
					l_app_msg = "::: Inside IQVIA  ItemCode does not exists so INSERT OPERATION::: ";
					System.out.println(l_app_msg+" :::: "+l_item_code);
					
					IqviaMedicationTransaction IqviaMedicationInsert = new IqviaMedicationTransaction();
					responseTxt = IqviaMedicationInsert.MedicationInsertTransRequestMethod("IQVIA", actionKey);
					
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
			return returnItemCodeFinalMessage;

		}

		return responseTxt;

		

		
	}

	
	
private void updateXH_Inbound_MessageStatus(String actionKey, String responseTxtErrCode, String responseTxtErrMsg)
{

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

	
	
	
	
	
	
	
		
	
}
