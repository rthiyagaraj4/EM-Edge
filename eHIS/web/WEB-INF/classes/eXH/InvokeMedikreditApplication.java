/***************************************************************************************************************
 * Author   :   Prithvirajan. R
 * Desc     :	This class is used to invoke the external Medikredit application
 ***************************************************************************************************************/

package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Map;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.io.InputStream;
import java.io.DataOutputStream;
import java.io.*;

import java.util.ArrayList;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class InvokeEGLapplication
 */
public class InvokeMedikreditApplication extends HttpServlet {

	boolean isDebugYN = false; 

	String l_debug_YN = "",l_errcd = "",l_errmsg = "";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		String responseTxt=null;
		String l_app_msg = "",l_st_status = "";
		try
		{
			Map<String, String> reqParams = XHUtil.getRequestParams(request);
			String callType = reqParams.get("callType");
			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;


			System.out.println(" ::: isDebugYN ::: "+isDebugYN);

			System.out.println(" ::: reqParams ::: "+reqParams);
			System.out.println(" ::: callType ::: "+callType);			
		
			if("MedikreditApplication".equals(callType)) 
			{
					//responseTxt=processRequest(reqParams);
					responseTxt=processRequest(reqParams);
					PrintWriter resp = response.getWriter();
					resp.write(responseTxt);
					resp.flush();
					resp.close();
			}
		
			if ("ECLAIMSEC".equals(callType) || "ECLAIMSUPD".equals(callType) || "ECLAIMSCL".equals(callType) || "ECLAIMVAL".equals(callType) || "ECLAIMSBATCH".equals(callType) || "ECLAIMSBATCHREC".equals(callType))
			{

				l_app_msg = " ::: Get ST Application status.. ";
				if (isDebugYN)	System.out.println(l_app_msg);

				l_st_status = getSTApplicationStatus();
				if (l_st_status.indexOf("Error")>=0)
				{
					l_errcd = "E";
					l_errmsg = l_errcd + "$!^" + l_app_msg + "$!^" + l_st_status;
				}
				l_app_msg = " ::: l_st_status : "+l_st_status;
				if (isDebugYN)	System.out.println(l_app_msg);


				if(l_st_status.equals("true"))
				{
					
					if("ECLAIMSEC".equals(callType)) {
							responseTxt=EClaimsEligibilityTransaction(reqParams);
							if(isDebugYN) {
							System.out.println("InvokeExternalApplication:::final response.... " +responseTxt);
							}
							PrintWriter resp = response.getWriter();
							resp.flush();
							resp.write(responseTxt);
							resp.close(); 
					}
					if("ECLAIMSUPD".equals(callType)) {
							responseTxt=EClaimsEligibilityTransaction(reqParams);
							if(isDebugYN) {
								System.out.println("InvokeMedikreditApplication:::UpdateDetails response.... " +responseTxt);
							}
							PrintWriter resp = response.getWriter();
							resp.flush();
							resp.write(responseTxt);
							resp.close(); 
					}
					if("ECLAIMSCL".equals(callType)) {
							responseTxt=EClaimsClaimsTransaction(reqParams);
							if(isDebugYN) {
								System.out.println("InvokeExternalApplication:::final response.... " +responseTxt);
							}
							PrintWriter resp = response.getWriter();
							resp.flush();
							resp.write(responseTxt);
							resp.close(); 
					}
					if("ECLAIMVAL".equals(callType)) {
							responseTxt=EClaimsValidateTransaction(reqParams);
							if(isDebugYN) {
								System.out.println("InvokeMedikreditApplication:::final response.... " +responseTxt);
							}
							PrintWriter resp = response.getWriter();
							resp.flush();
							resp.write(responseTxt);
							resp.close(); 
					}
					if("ECLAIMSBATCH".equals(callType)) {
							responseTxt=EClaimsBatchProcessing(reqParams);
							if(isDebugYN) {
								System.out.println("InvokeMedikreditApplication:::final response.... " +responseTxt);
							}
							PrintWriter resp = response.getWriter();
							resp.flush();
							resp.write(responseTxt);
							resp.close(); 
					}
					if("ECLAIMSBATCHREC".equals(callType)) {
							System.out.println("Inside Call Type ECLAIMSBATCHREC ");
							ArrayList<String> responseArray=null;
							responseArray = new ArrayList(EClaimsBatchRecs(reqParams));
							if(isDebugYN) {
								System.out.println("InvokeMedikreditApplication:::final response.... " +responseArray);
							}
							PrintWriter resp = response.getWriter();
							resp.flush();
							resp.write(responseArray.toString());
							resp.close(); 
					}
					
				}
				else{

					l_errcd = "E";
					l_errmsg = l_errcd + "$!^$!^" + l_app_msg + "$!^" + "ST Application is Not Running, Please Contact System Administrator";
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(l_errmsg);
					resp.close();
				}
			}
			if("ECLAIMSERA".equals(callType)) 
			{
					responseTxt=EClaimsERAProcessing(reqParams);
					if(isDebugYN) {
						System.out.println("InvokeExternalApplication:::final response.... " +responseTxt);
					}
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}

		}
		catch (Exception exp) 
		{
			exp.printStackTrace(System.err);
		}
    }
    
   
	private String  processRequest(Map<String, String> reqParams) throws Exception 
	{

            String encounter_id="";
			int dependant_num=0;
			int dependant_relation=0;
			Date start_encounter_date=null;
			Date end_encounter_date=null;
            
			encounter_id=reqParams.get("encounter_id");

			/*
			if(reqParams.get("encounter_id")!=null && reqParams.get("encounter_id")!="")
			{
             encounter_id=reqParams.get("encounter_id");
			}
			*/
			if(reqParams.get("start_encounter_date")!=null && reqParams.get("start_encounter_date")!="")
			{
              //start_encounter_date=XHUtil.convertStrToDate();
			}
			if(reqParams.get("end_encounter_date")!=null && reqParams.get("end_encounter_date")!="")
			{
             // end_encounter_date=XHUtil.convertStrToDate(); 
			}  
		    if(reqParams.get("dependant_num")!=null && reqParams.get("dependant_num")!="")
			{
                dependant_num=Integer.parseInt(reqParams.get("dependant_num"));
			}
			if(reqParams.get("dependant_relation")!=null && reqParams.get("dependant_relation")!="")
			{
              dependant_relation=Integer.parseInt(reqParams.get("dependant_relation"));
			}


			String responseTxt="";
			String p_response="";
			String xml_data="";
			String errorCode="";
			String errorMsg="";
			CallableStatement ostmt = null;
			Connection dbConn = null;
			try
			{
					dbConn = ConnectionManager.getConnection();

					ostmt = dbConn.prepareCall("{ CALL xfinsurance_oth.xmldata(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" );
					ostmt.setString(1,"MEDIKREDIT");  //Application id
					ostmt.setString(2,"ECLAIMSPL");
					ostmt.setString(3,"INS");
					ostmt.setString(4,reqParams.get("facility_id"));
					ostmt.setString(5,reqParams.get("patient_id"));
					ostmt.setString(6,encounter_id);
					ostmt.setString(7,reqParams.get("bill_num"));
					ostmt.setDate(8,start_encounter_date);  //date
					ostmt.setDate(9,end_encounter_date);    //date
					ostmt.setString(10,reqParams.get("membership_num"));
					ostmt.setInt(11,dependant_num);
					ostmt.setInt(12,dependant_relation);
					ostmt.setString(13,reqParams.get("wca_number"));
					ostmt.setString(14,"0");    //outbound type   --0-EligTrx,1-ClaimTrx,2-EocTrx
					ostmt.setString(15,reqParams.get("cust_code"));
					ostmt.setString(16,reqParams.get("user_id"));
					ostmt.setString(17,reqParams.get("ws_no"));
					ostmt.setString(18,"ONLINE");   // :DISPOSITIONFLAG,--ONLINE
                   
				    System.out.println("MEDIKREDIT");
				    System.out.println("ECLAIMSPL");
					System.out.println("INS");
					System.out.println(reqParams.get("facility_id"));
					System.out.println(reqParams.get("patient_id"));
					System.out.println(encounter_id);
					System.out.println(reqParams.get("bill_num"));
					System.out.println(start_encounter_date);
					System.out.println(end_encounter_date);
					System.out.println(reqParams.get("membership_num"));
					System.out.println(dependant_num);
					System.out.println(dependant_relation);
					System.out.println(reqParams.get("wca_number"));
					System.out.println("0");
					System.out.println(reqParams.get("cust_code"));
					System.out.println(reqParams.get("user_id"));
					System.out.println(reqParams.get("ws_no"));
					System.out.println(reqParams.get("ONLINE"));


                    ostmt.registerOutParameter(19,java.sql.Types.VARCHAR);
					ostmt.registerOutParameter(20,java.sql.Types.VARCHAR);
					ostmt.registerOutParameter(21,java.sql.Types.VARCHAR);
					ostmt.registerOutParameter(22,java.sql.Types.VARCHAR);
					ostmt.execute();

					xml_data = ostmt.getString(19);
					p_response = ostmt.getString(20);
					errorCode = ostmt.getString(21);
					errorMsg = ostmt.getString(22);


					if((errorMsg != null) && (errorMsg.trim().length()>0)) 
					{
						responseTxt=errorMsg;	
					}
					else
					{
							 responseTxt=p_response;
					} 
					System.out.println("(InvokeEGLapplication:processRequest) responseTxt "+p_response);
					System.out.println("(InvokeEGLapplication:processRequest) errorCode "+errorCode);
					System.out.println("(InvokeEGLapplication:processRequest) errorMsg "+errorMsg);
			}
			catch(Exception exp)
			{
				System.out.println("(InvokeEGLapplication:processRequest) Exception at executing procedure");
				exp.printStackTrace(System.err);
			}
			finally
			{			
				XHUtil.closeDBResources(null, ostmt, dbConn);
			}
			return responseTxt;	
	 }
	 public String getSTApplicationStatus(){

		String l_app_msg = "", l_element_id = "";
		String l_segment_id = "ELC", l_standard_code = "ECLASTD";
		String l_st_folder = "";
		String l_file_name = "";;
		String l_st_status  = "false";

		File myTestFile = null;
		boolean isDirectory = false;
      
	    l_app_msg = "Retrieving ST Folder name...";
		if (isDebugYN) System.out.println(l_app_msg);	

		l_element_id = "ST_FOLDER";

		l_st_folder = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
		if (l_st_folder.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_st_folder;
		}
		l_app_msg = " ::: l_st_folder : "+l_st_folder;
		if (isDebugYN) System.out.println(l_app_msg);

		 l_app_msg = "Retrieving ST file name..";
		if (isDebugYN) System.out.println(l_app_msg);	

		l_element_id = "ST_FILE";

		l_file_name = FetchStdCntrlSeg(l_segment_id, l_element_id, l_standard_code);
		if (l_file_name.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_st_folder;
		}
		l_app_msg = " ::: l_file_name : "+l_file_name;
		if (isDebugYN) System.out.println(l_app_msg);
		
		try{

			l_app_msg = "::: Before Checking the Folder ::: ";
	        if (isDebugYN) System.out.println(l_app_msg);

			l_st_status = "false";

			l_app_msg = " ::: directoryName : "+ l_st_folder +" ::: fileName : "+l_file_name;
	        if (isDebugYN) System.out.println(l_app_msg);

			try
			{
				File folder = new File(l_st_folder);

				isDirectory = folder.isDirectory();

				l_app_msg = "::: L_ST_FOLDER.folder.isDirectory() ::: "+isDirectory;
		        if (isDebugYN) System.out.println(l_app_msg);

			}
			catch (Exception foe)
			{
				l_app_msg = "::: Error in accessing the Folder : "+foe.getMessage();
				if (isDebugYN) System.out.println(l_app_msg);
				
				foe.printStackTrace();
				
				return l_st_status; 
			}

			
			try
			{
				if (isDirectory)
				{
					myTestFile = new File(l_st_folder + File.separator + l_file_name);

					l_app_msg = " ::: File Name ::: "+myTestFile;
					if (isDebugYN) System.out.println(l_app_msg);

					if (myTestFile.canRead()) {
						System.out.println(myTestFile.getAbsolutePath() + "Can Read: ");
						l_st_status = "true";
					} else {
						System.out.println(myTestFile.getAbsolutePath() + " Cannot Read: ");
						l_st_status = "false";
					}
				}			
				
			}
			catch (Exception fe)
			{
				l_app_msg = "::: Error in accessing the file : "+fe.getMessage();
				if (isDebugYN) System.out.println(l_app_msg);
				
				fe.printStackTrace();
				
				return l_st_status; 
			}
			


			

			/*

			File folder = new File(l_st_folder);
			
			File[] listOfFiles = folder.listFiles();

			l_app_msg = "::: List of Files array Length: "+listOfFiles.length ;
			if (isDebugYN) System.out.println(l_app_msg);				


			for (int i = 0; i < listOfFiles.length; i++) 
			{
				if (listOfFiles[i].isFile()) 
				{
					if (isDebugYN)  System.out.println(listOfFiles[i].getName());
					if ((listOfFiles[i].getName().toLowerCase()).equals(l_file_name.toLowerCase())) 
					{
						l_st_status = "true";

					}
				}
			}
			*/
		}
		catch(Exception e)
		{
			l_app_msg = "::: Error in getSTApplicationStatus : "+e.getMessage();
			if (isDebugYN) System.out.println(l_app_msg);
			
			e.printStackTrace();
			
			return l_st_status; 
		}

        l_app_msg = "::: File l_st_status : "+l_st_status;
		if (isDebugYN) System.out.println(l_app_msg);
		
		return l_st_status;


	}

    
	private String EClaimsEligibilityTransaction(Map reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;

		String paramString=reqParams.get("paramString").toString();

		if(isDebugYN) {
		System.out.println("InvokeExternalApplication.java:::EClaimsEligibilityTransaction...paramString...."+paramString);
		}

		try
		{   

			EClaimsEligibilityTransaction EClaimsEligiTrans = new EClaimsEligibilityTransaction();
				
			responseTxt = EClaimsEligiTrans.ProcessRequest("ECLAIMPROF1","ECLAIMS", paramString);
			if(isDebugYN) System.out.println("(InvokeExternalApplication:EClaimsEligibilityTransaction) responseTxt "+responseTxt);

			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}				
			
		}
		catch(Exception exp)
		{
			if(isDebugYN) System.out.println("(InvokeExternalApplication:EClaimsEligibilityTransaction) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		 if(isDebugYN) System.out.println("InvokeExternalApplication.java EClaimsEligibilityTransaction:::responseTxt...."+responseTxt);
		return responseTxt;	
	}

	private String EClaimsClaimsTransaction(Map reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;

		String paramString=reqParams.get("paramString").toString();

		if(isDebugYN) {
		System.out.println("InvokeExternalApplication.java:::EClaimsClaimsTransaction...paramString...."+paramString);
		}

		try
		{   

			EClaimsClaimsTransaction EClaimsClaimsTrans = new EClaimsClaimsTransaction();
				
			responseTxt = EClaimsClaimsTrans.ProcessRequest("ECLAIMPROF1","ECLAIMS", paramString);
			if(isDebugYN) System.out.println("(InvokeExternalApplication:EClaimsClaimsTransaction) responseTxt "+responseTxt);

			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}				
			
		}
		catch(Exception exp)
		{
			if(isDebugYN) System.out.println("(InvokeExternalApplication:EClaimsClaimsTransaction) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		 if(isDebugYN) System.out.println("InvokeExternalApplication.java EClaimsClaimsTransaction:::responseTxt...."+responseTxt);
		return responseTxt;	
	}
    private String EClaimsBatchProcessing(Map reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;

		String paramString=reqParams.get("paramString").toString();

		if(isDebugYN) {
		System.out.println("InvokeExternalApplication.java:::EClaimsClaimsTransaction...paramString...."+paramString);
		}

		try
		{   

			EClaimsBatchTransaction EClaimsBatchTrans = new EClaimsBatchTransaction();
				
			responseTxt = EClaimsBatchTrans.ProcessRequest("ECLAIMPROF1","ECLAIMS", paramString);
			if(isDebugYN) System.out.println("(InvokeExternalApplication:EClaimsBatchProcessing) responseTxt "+responseTxt);

			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}				
			
		}
		catch(Exception exp)
		{
			if(isDebugYN) System.out.println("(InvokeExternalApplication:EClaimsBatchProcessing) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		 if(isDebugYN) System.out.println("InvokeExternalApplication.java EClaimsClaimsTransaction:::responseTxt...."+responseTxt);
		return responseTxt;	
	}
	
	private String EClaimsERAProcessing(Map reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;

		String paramString=reqParams.get("paramString").toString();

		if(isDebugYN) {
		System.out.println("InvokeExternalApplication.java:::EClaimsClaimsTransaction...paramString...."+paramString);
		}

		try
		{   

			EClaimsERATransaction EClaimsERATrans = new EClaimsERATransaction();
				
			responseTxt = EClaimsERATrans.ProcessRequest("ECLAIMPROF1","ECLAIMS", paramString);
			if(isDebugYN) System.out.println("(InvokeExternalApplication:EClaimsERAProcessing) responseTxt "+responseTxt);

			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}				
			
		}
		catch(Exception exp)
		{
			if(isDebugYN) System.out.println("(InvokeExternalApplication:EClaimsERAProcessing) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		 if(isDebugYN) System.out.println("InvokeExternalApplication.java EClaimsERAProcessing:::responseTxt...."+responseTxt);
		return responseTxt;	
	}
	private String EClaimsValidateTransaction(Map reqParams) throws Exception 
	{
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;

		String paramString=reqParams.get("paramString").toString();

		if(isDebugYN) {
		System.out.println("InvokeExternalApplication.java:::EClaimsValidateTransaction...paramString...."+paramString);
		}

		try
		{   

			EClaimsClaimsTransaction EClaimsClaimsTrans = new EClaimsClaimsTransaction();
				
			responseTxt = EClaimsClaimsTrans.ValidateTransaction(paramString);
			if(isDebugYN) System.out.println("(InvokeExternalApplication:EClaimsValidateTransaction) responseTxt "+responseTxt);

			if (responseTxt.indexOf("Error")==0)
			{
				return responseTxt;
			}				
			
		}
		catch(Exception exp)
		{
			if(isDebugYN) System.out.println("(InvokeExternalApplication:EClaimsValidateTransaction) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		 if(isDebugYN) System.out.println("InvokeExternalApplication.java EClaimsValidateTransaction:::responseTxt...."+responseTxt);
		return responseTxt;	
	}
	public String FetchStdCntrlSeg(String segmentID, String elementId, String standardCode){

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchStdCntrlSeg ::: ";
		if (isDebugYN) System.out.println(l_app_msg);	

		l_app_msg = " ::: Segment ID : "+ segmentID + " ::: Element ID : " + elementId + " ::: Standard Code : "+ standardCode;
		if (isDebugYN) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Retrieving "+ elementId + " Value...";
		if (isDebugYN) System.out.println(l_app_msg);	

		try
		{
			dbConn =  ConnectionManager.getConnection();
			query = "SELECT NVL(DEFAULT_VALUE,'') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG " 
						+ " WHERE SEGMENT_ID = ? "
						+ " AND STANDARD_CODE = ? "
						+ " AND ELEMENT_ID = ? ";

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, segmentID);
			pstmt.setString(2, standardCode);
			pstmt.setString(3, elementId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_field_value = rs.getString("DEFAULT_VALUE");
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}
		finally
		{			
			closeDBResources(rs, pstmt, dbConn);			
		}		

		return l_field_value;
	}
	public static void closeDBResources(ResultSet rs, PreparedStatement stmt, Connection conn)
	{
		try {
			if(rs != null) rs.close();
		}
		catch(Exception exp) {
		}
		finally  {
			try {
				if(stmt != null) stmt.close();
			}
			catch(Exception exp) {
			}
			finally  {
				try {
					if(conn != null) ConnectionManager.returnConnection(conn);					
				}
				catch (Exception exp) { }				
			}
		}
	}

	
	public ArrayList<String> EClaimsBatchRecs(Map reqParams){

		Connection dbConn = null;
		ResultSet rs=null, rs1=null, rs2=null;
		PreparedStatement pstmt = null, pstmt1 = null, pstmt2 = null;

		String query = "", query1 = "", query2 = "", querystr = "", query3 = "";
		String l_app_msg = "", l_field_value = "", l_doc_no = "", l_doc_type = "", l_checked_value = "";

		String l_patient_class = "", l_episode_type = "", l_settlement_ind = "", l_where_values = "";

		String l_patient_id = "", l_encounter_id = "", l_episode_id = "", l_visit_id = "", l_membership_num_sap = "", l_dependant_num_sap = "", l_dependant_relation_sap = "", l_cust_code = "", l_operating_facility_id = "", l_wca_number_sap = "", l_credit_auth_ref = "", l_doc_date = "", l_patientidnum = "", l_membership_surname = "", l_membership_initial = "", l_blng_grp_id = "";
		
		String l_trans_ref_no = "", l_event_type = ""; 
		int l_srl_no = 0;

		String l_dest_code = "", l_claim_type = "";

		ArrayList<String> batchArray = null;

		String paramString=reqParams.get("paramString").toString();

		if(isDebugYN) {
			System.out.println("InvokeMedikreditApplication.java:::EClaimsBatchRecs...paramString...."+paramString);
		}

		l_app_msg = " ::: Inside EClaimsBatchRecs ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		try
		{
			batchArray = new ArrayList<String>();
			dbConn =  ConnectionManager.getConnection();
			query = paramString;

			query1 = "select nvl(DESTINATION_CODE_SAP,'') DESTINATION_CODE_SAP, nvl(CLAIM_TYPE,'') CLAIM_TYPE from BL_CUST_DEST_MST a, pr_encounter b"
								+" where B.PATIENT_ID = ? and B.EPISODE_ID = ? and  CUST_CODE = ? "
								+" and  trunc(VISIT_ADM_DATE_TIME) between EFF_FROM_DATE and NVL(EFF_TO_DATE, SYSDATE)  ";

			query2 = "select nvl(DESTINATION_CODE_SAP,'') DESTINATION_CODE_SAP, nvl(CLAIM_TYPE,'') CLAIM_TYPE from BL_BLNG_GRP_DEST_MST a, pr_encounter b"
								+" where B.PATIENT_ID = ? and B.EPISODE_ID = ? and  BLNG_GRP_ID = ? "
								+" and  trunc(VISIT_ADM_DATE_TIME) between EFF_FROM_DATE and NVL(EFF_TO_DATE, SYSDATE) ";

			pstmt = dbConn.prepareStatement(query);			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				l_doc_no = ""; l_doc_type = "";

				l_patient_id			= rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
				l_encounter_id			= rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID"); 
				l_episode_id			= rs.getString("EPISODE_ID")==null?"":rs.getString("EPISODE_ID");
				l_visit_id				= rs.getString("VISIT_ID")==null?"":rs.getString("VISIT_ID");
				l_patient_class			= rs.getString("PATIENT_CLASS")==null?"":rs.getString("PATIENT_CLASS");
				l_membership_num_sap	= rs.getString("MEMBERSHIP_NUM_SAP")==null?"":rs.getString("MEMBERSHIP_NUM_SAP");
				l_dependant_num_sap		= rs.getString("DEPENDANT_NUM_SAP")==null?"":rs.getString("DEPENDANT_NUM_SAP");
				l_dependant_relation_sap = rs.getString("DEPENDANT_RELATION_SAP")==null?"":rs.getString("DEPENDANT_RELATION_SAP");
				l_cust_code				= rs.getString("CUST_CODE")==null?"":rs.getString("CUST_CODE");
				l_operating_facility_id = rs.getString("OPERATING_FACILITY_ID")==null?"":rs.getString("OPERATING_FACILITY_ID"); 
				l_wca_number_sap		= rs.getString("WCA_NUMBER_SAP")==null?"":rs.getString("WCA_NUMBER_SAP");
				l_credit_auth_ref		= rs.getString("EVENT_TYPE")==null?"":rs.getString("EVENT_TYPE");
				l_doc_date				= rs.getString("DOC_DATE")==null?"":rs.getString("DOC_DATE");
				l_patientidnum			= rs.getString("PATIENTIDNUM")==null?"":rs.getString("PATIENTIDNUM"); 
				l_membership_surname	= rs.getString("MEMBERSHIP_SURNAME")==null?"":rs.getString("MEMBERSHIP_SURNAME");
				l_membership_initial	= rs.getString("MEMBERSHIP_INITIAL")==null?"":rs.getString("MEMBERSHIP_INITIAL"); 
				l_blng_grp_id			= rs.getString("BLNG_GRP_ID")==null?"":rs.getString("BLNG_GRP_ID"); 				

				l_doc_type				= rs.getString("DOC_TYPE_CODE")==null?"":rs.getString("DOC_TYPE_CODE");
				l_doc_no				= rs.getString("DOC_NUM")==null?"":rs.getString("DOC_NUM");
				l_settlement_ind		= rs.getString("SETTLEMENT_IND")==null?"":rs.getString("SETTLEMENT_IND");

				if (l_patient_class.equals("OP")) {
					l_episode_type = "O";
				}
				if (l_patient_class.equals("EM")) {
					l_episode_type = "E";
				}
				if (l_patient_class.equals("IP")) {
					l_episode_type = "I";
				}
				if (l_patient_class.equals("DC")) {
					l_episode_type = "D";
				}
				if (l_patient_class.equals("")) {
					l_episode_type = "X";
				}				

				if (l_settlement_ind.equals("X") || l_settlement_ind.equals("R"))
				{
					querystr = query1;
					l_where_values = l_cust_code;
				}
				else if (l_settlement_ind.equals("C"))
				{
					querystr = query2;
					l_where_values = l_blng_grp_id;
				}

				rs1=null; 
				rs2=null;

				pstmt1 = null; 
				pstmt2 = null;
				
				pstmt1 = dbConn.prepareStatement(querystr);		
				pstmt1.setString(1, l_patient_id);
				pstmt1.setString(2, l_episode_id);
				pstmt1.setString(3, l_where_values);
				rs1 = pstmt1.executeQuery();
				while(rs1.next())
				{
					l_dest_code = rs1.getString("DESTINATION_CODE_SAP");
					l_claim_type = rs1.getString("CLAIM_TYPE");
				}

				XHUtil.closeDBResources(rs1, pstmt1, null);
				
				query3 = "Select FACILITY_ID, PATIENT_ID, EPISODE_ID, VISIT_ID, DOC_TYPE_CODE, DOC_NUM, a.trans_type, a.event_type, SRL_NO, CASE_NUM, CLAIM_NUM, APPROVAL_STATUS, 						B.STATUS_DESC "
								+"  from xf_eclaims_trx_hdr a, XH_TRANS_STATUS b "
								+"	where srl_no in (select max(SRL_NO) from xf_eclaims_trx_hdr "
								+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
								+"							and DOC_TYPE_CODE = ? and DOC_NUM = ? and APPROVAL_STATUS in('P','W','A','99'))"
								+"			AND  A.APPROVAL_STATUS = B.STATUS_CODE(+) AND B.TRANS_EVENT = 'ECL' AND B.TRANS_TYPE = A.EVENT_TYPE ";

				System.out.println("query3...."+query3);

				pstmt2 = dbConn.prepareStatement(query3);
				pstmt2.setString(1, l_operating_facility_id);
				pstmt2.setString(2, l_patient_id);
				pstmt2.setString(3, l_episode_id);
				pstmt2.setString(4, l_visit_id);
				pstmt2.setString(5, l_doc_type);
				pstmt2.setInt(6, Integer.parseInt(l_doc_no));

				rs2 = pstmt2.executeQuery();

				while(rs2.next())
				{
				   l_event_type = rs2.getString("EVENT_TYPE")==null?"":rs2.getString("EVENT_TYPE"); 
				   l_srl_no =  rs2.getInt("SRL_NO");				   
				}
				l_trans_ref_no = String.valueOf(l_srl_no);


				l_checked_value = "<PATIENT_ID>"+l_patient_id+"$!^<ENCOUNTER_ID>"+l_encounter_id+"$!^<EPISODE_ID>"+l_episode_id+"$!^<VISIT_ID>"+l_visit_id+"$!^<EPISODE_TYPE>"+l_episode_type+"$!^<REQUEST>#REQUEST#$!^<REQUEST_TYPE>ECLREQ$!^<MEMBER_ID>"+l_membership_num_sap+"$!^<DEPD_CODE>"+l_dependant_num_sap+"$!^<DEPD_RELN>"+l_dependant_relation_sap+"$!^<CUST_CD>"+l_cust_code+"$!^<DEST_CD>"+l_dest_code+"$!^<USER>#USER_ID#$!^<FACILITY_ID>"+l_operating_facility_id+"$!^<TRANS_ID>XXX$!^<WCA_NUM>"+l_wca_number_sap+"$!^<WS_NO>#WS_NO#$!^<BILL_DOC_TYPE_CODE>"+l_doc_type+"$!^<BILL_DOC_NO>"+l_doc_no+"$!^<AUTHORIZATION_NUM>"+l_credit_auth_ref+"$!^<BILL_DATE>"+l_doc_date+"$!^<TRANS_REF_ID>"+l_trans_ref_no+"$!^<PATIENT_ID_NUM>"+l_patientidnum+"$!^<EVENT_TYPE>"+l_event_type+"$!^<MEMBER_SURNAME>"+l_membership_surname+"$!^<MEMBER_INITIAL>"+l_membership_initial+"$!^<BLNG_GRP_ID>"+l_blng_grp_id+"$!^<SETTLEMENT_IND>"+l_settlement_ind+"$!^<CLAIM_TYPE>"+l_claim_type+"$!^";	

				if(isDebugYN) {
					System.out.println("InvokeExternalApplication.java:::EClaimsBatchRecs...l_checked_value...."+l_checked_value);
				}

				batchArray.add(l_doc_type+"**"+l_doc_no+"**"+l_checked_value);

				XHUtil.closeDBResources(rs2, pstmt2, null);
			}

			if(isDebugYN) {
				System.out.println("InvokeExternalApplication.java:::EClaimsBatchRecs...batchArray.size...."+batchArray.size());
			}
			
		}
		catch(Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
			System.out.println(l_field_value);
		}
		finally
		{			
			XHUtil.closeDBResources(rs2, pstmt2, null);
			XHUtil.closeDBResources(rs1, pstmt1, null);
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}		

		return batchArray;
	}	

}