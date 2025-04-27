<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF             			Developer Name
-------------------------------------------------------------------------------------------
1            V220107            26735      PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
2            V220329            29768      PMG2021-COMN-CRF-0089.3-TF-US001            Mohanapriya K
3	     V220418		30716	   PMG2021-COMN-CRF-0089.3-TF-US001/01		   Mohanapriya K
*/ %>
<%@page import="java.util.Hashtable"%>
<%@page import="java.io.*"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.sql.Date,java.sql.Timestamp,java.text.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,eBL.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.util.*"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="eRD.RadiologyExamBean"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="javax.servlet.ServletInputStream"%>
<%@page import="javax.sql.rowset.serial.SerialBlob"%>
<%@page import= "javax.sql.rowset.serial.SerialException"%>
<%@page import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*, eRD.* ,eRD.Common.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%
	Properties p = (Properties)session.getValue("jdbc");
	
	request.setCharacterEncoding("UTF-8");
	HashMap newhasInsuranceImageValues =new HashMap();
	
	String locale	= (String) p.getProperty("LOCALE");
	String User	= (String) p.getProperty("login_user");

			
	String functionMode = "";
	String retrived_url= "";
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 =null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	CallableStatement cstmt= null ;
	JSONObject obj=new JSONObject();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //newchng
	
	try {
		con = ConnectionManager.getConnection();
		functionMode = request.getParameter("functionMode");
		if (null == functionMode) {
			functionMode = "";
		}
		System.err.println("functionMode---"+functionMode);

		if ("retrive_url".equals(functionMode)) {
			String params =checkNull(request.getParameter("params"));
			String P_FACILITY_ID = checkNull(request.getParameter("P_FACILITY_ID"));
			String order_fac_id = checkNull(request.getParameter("order_fac_id")); //V220209
			System.err.println("order_fac_id---"+order_fac_id);
			String P_PATIENT_ID = checkNull(request.getParameter("P_PATIENT_ID"));
			String P_ENCOUNTER_ID = checkNull(request.getParameter("P_ENCOUNTER_ID"));
			String P_LOGIN_USER = checkNull(request.getParameter("P_LOGIN_USER"));
			String P_LANGUAGE_ID = checkNull(request.getParameter("P_LANGUAGE_ID"));
			String P_RESP_ID = checkNull(request.getParameter("P_RESP_ID"));
			String P_REQUEST_NUM = checkNull(request.getParameter("P_REQUEST_NUM"));
			String P_REQUEST_LINE_NUM = checkNull(request.getParameter("P_REQUEST_LINE_NUM"));
			String P_EXT_APPL_ACCESSION_NUM = checkNull(request.getParameter("P_EXT_APPL_ACCESSION_NUM"));
			String called = checkNull(request.getParameter("called"));
			System.err.println("called---"+called);
			String P_URL_TYPE="";
		if(("CN".equals(called))){
			String indicator = checkNull(request.getParameter("indicator"));
			String index = checkNull(request.getParameter("index"));
			System.err.println("indicator---"+indicator);
			
			if(!("null".equals(indicator))){
				if(indicator.equals("R")){
					P_URL_TYPE="R";
				}else if(indicator.equals("M")){
					P_URL_TYPE="M";
				}else{
					P_URL_TYPE="V";
				}
			}
			}else{
				P_URL_TYPE = checkNull(request.getParameter("P_URL_TYPE"));
			}
			try {
				pstmt=con.prepareStatement("select RD_RESULT.GET_URL(?,?,?,?,?,?,?,?,?,?,?) from dual");	//V220209 one param added	
				
				pstmt.setString(1,P_FACILITY_ID);
				pstmt.setString(2,P_PATIENT_ID);
				pstmt.setString(3,P_ENCOUNTER_ID);
				pstmt.setString(4,P_LOGIN_USER);
				pstmt.setString(5,P_LANGUAGE_ID);
				pstmt.setString(6,P_RESP_ID);
				pstmt.setString(7,P_REQUEST_NUM);
				pstmt.setString(8,P_REQUEST_LINE_NUM);
				pstmt.setString(9,P_EXT_APPL_ACCESSION_NUM);
				pstmt.setString(10,P_URL_TYPE);
				pstmt.setString(11,order_fac_id); //V220209
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					retrived_url =rs.getString(1);
				}
				obj.put("retrived_url",retrived_url);
				System.out.println("retrived_url" + retrived_url);
				out.println(obj);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("exception while retriving url" + e);
			} 
		
		}
		else if(functionMode.equals("CN_validation")){
			try {
				System.err.println("103--CN_validation");
				String P_FACILITY_ID = checkNull(request.getParameter("P_FACILITY_ID"));
				String P_PATIENT_ID = checkNull(request.getParameter("P_PATIENT_ID"));
				String P_ENCOUNTER_ID = checkNull(request.getParameter("P_ENCOUNTER_ID"));
				String P_LOGIN_USER = checkNull(request.getParameter("P_LOGIN_USER"));
				String P_LANGUAGE_ID = checkNull(request.getParameter("P_LANGUAGE_ID"));
				String P_RESP_ID = checkNull(request.getParameter("P_RESP_ID"));
				String P_REQUEST_NUM = checkNull(request.getParameter("P_REQUEST_NUM"));
				String P_REQUEST_LINE_NUM = checkNull(request.getParameter("P_REQUEST_LINE_NUM"));
				String P_EXT_APPL_ACCESSION_NUM = checkNull(request.getParameter("P_EXT_APPL_ACCESSION_NUM"));
				String indicator = checkNull(request.getParameter("indicator"));
				String REP_TYPE_TO = "{ call RD_RESULT.POPULATE_STATUS(?,?,?,?,?,?)}";
				cstmt = con.prepareCall(REP_TYPE_TO);
				cstmt.setString(1,P_FACILITY_ID);
				cstmt.setString(2,P_REQUEST_NUM);
				cstmt.setString(3,P_REQUEST_LINE_NUM);
				cstmt.setString(4,P_PATIENT_ID);
				cstmt.setString(5,indicator);
				
				System.err.println("p_facility_id="+P_FACILITY_ID+" P_PATIENT_ID "+P_PATIENT_ID+" P_REQUEST_NUM "+P_REQUEST_NUM+" P_REQUEST_LINE_NUM-"+P_REQUEST_LINE_NUM+" indicator "+indicator);
				cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
				cstmt.execute();
			
				String returnValue= checkNull(cstmt.getString(6));
				if(!returnValue.equals("")){
					obj.put("type",returnValue);
					System.err.println("returnValue populate-  "+returnValue);
					out.println(obj);
				}else{
					returnValue="";
					obj.put("type",returnValue);
					System.err.println("returnValue populate-  "+returnValue);
					out.println(obj);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("exception while populating option " + e);
			} 
	}else if(functionMode.equals("StatusValidation")){
			
			try {
				System.err.println("103--StatusValidation");
				String P_FACILITY_ID = checkNull(request.getParameter("P_FACILITY_ID"));
				String P_PATIENT_ID = checkNull(request.getParameter("P_PATIENT_ID"));
				String P_ENCOUNTER_ID = checkNull(request.getParameter("P_ENCOUNTER_ID"));
				String P_LOGIN_USER = checkNull(request.getParameter("P_LOGIN_USER"));
				String P_LANGUAGE_ID = checkNull(request.getParameter("P_LANGUAGE_ID"));
				String P_RESP_ID = checkNull(request.getParameter("P_RESP_ID"));
				String P_REQUEST_NUM = checkNull(request.getParameter("P_REQUEST_NUM"));
				String P_REQUEST_LINE_NUM = checkNull(request.getParameter("P_REQUEST_LINE_NUM"));
				String mod_date = checkNull(request.getParameter("mod_date"));
				String P_REP_TYPE_FROM = checkNull(request.getParameter("P_REP_TYPE_TO"));
				
				String REP_TYPE_TO = "{ call RD_RESULT.VALIDATE_STATUS(?,?,?,?,?,?,?)}"; //V220329 
				cstmt = con.prepareCall(REP_TYPE_TO);
				cstmt.setString(1,P_FACILITY_ID);
				cstmt.setString(2,P_REQUEST_NUM);
				cstmt.setString(3,P_REQUEST_LINE_NUM);
				cstmt.setString(4,P_REP_TYPE_FROM);
				if(!mod_date.equals("")){
					Timestamp m_date = new Timestamp(sdf.parse(mod_date).getTime());
					cstmt.setTimestamp(7,m_date);//newchng
				}else{
					cstmt.setTimestamp(7,null);//newchng
				} //V220418
				
				System.err.println("p_facility_id="+P_FACILITY_ID+" P_REQUEST_LINE_NUM "+P_REQUEST_LINE_NUM+" P_REQUEST_NUM "+P_REQUEST_NUM+" P_REP_TYPE_FROM "+P_REP_TYPE_FROM+" mod_date"+mod_date);
				cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
				cstmt.execute();
				String P_REP_TYPE_TO = checkNull(cstmt.getString(5));
				String P_ERROR_TEXT = checkNull(cstmt.getString(6));	
				
				System.err.println(" P_REP_TYPE_TO-"+P_REP_TYPE_TO);
				System.err.println("P_ERROR_TEXT-"+P_ERROR_TEXT);
				System.err.println(" P_REP_TYPE_TO P_REP_TYPE_TO-"+P_REP_TYPE_TO.equals(""));
				System.err.println("P_ERROR_TEXT-"+P_ERROR_TEXT.equals(""));
				String returnValue= "";
			
				obj.put("valid",P_REP_TYPE_TO+"~"+P_ERROR_TEXT);
				out.println(obj);
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("exception while validation " + e);
			} 
		}else if(functionMode.equals("modified_date")){
			
			try {
				System.err.println("203--modified_date");
				String P_FACILITY_ID = checkNull(request.getParameter("P_FACILITY_ID"));
				String P_REQUEST_NUM = checkNull(request.getParameter("P_REQUEST_NUM"));
				String P_REQUEST_LINE_NUM = checkNull(request.getParameter("P_REQUEST_LINE_NUM"));
				String mod_date="";
				pstmt1=con.prepareStatement("select RD_RESULT.GET_MODIFIED_DATE(?,?,?) from dual");	//V220209 one param added	
				
				pstmt1.setString(1,P_FACILITY_ID);
				pstmt1.setString(2,P_REQUEST_NUM);
				pstmt1.setString(3,P_REQUEST_LINE_NUM);
				
				rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					mod_date =checkNull(rs1.getString(1));
				}
				obj.put("mod_date",mod_date);
				out.println(obj);
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("exception while retriving mod_date " + e);
			} 
		}else if(functionMode.equals("patienthistory")){
			try{
				String limit_function_id = request.getParameter("limit_function_id") == null ? "" : request.getParameter("limit_function_id");
				System.out.println("is comming as empty in InvokePatientHistoryWrapper.jsp");
		//String queryString = request.getQueryString()== null?"":request.getQueryString();
		String login_id = request.getParameter("p_login_user") == null ? "" : request.getParameter("p_login_user");
		String login_pwd = request.getParameter("p_user_password") == null ? "" : request.getParameter("p_user_password");
		String mode = request.getParameter("mode") == null ? "V" : request.getParameter("mode");
		
		String facility_id = request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
		String resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
		String patient_id = request.getParameter("p_patient_id") == null ? "" : request.getParameter("p_patient_id");
	
		//String episode_id = request.getParameter("p_episode_id") == null ? "" : request.getParameter("p_episode_id");
		String encounter_id = request.getParameter("p_encounter_id") == null ? "" : request.getParameter("p_encounter_id");
		String accession_number = request.getParameter("accession_number") == null ? "" : request.getParameter("accession_number");
		String accession_type = request.getParameter("accession_type") == null ? "" : request.getParameter("accession_type");
		//locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
		
//Start : Added by Sridhar Reddy On 05/11/2008
		String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
		String contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num");
		String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
// END : Sridhar Reddy On 05/11/2008
	
		//IN066218 START
		String che_default_mode=request.getParameter("che_default_mode")==null?"T":request.getParameter("che_default_mode"); 
		String calling_from_2T=request.getParameter("calling_from_2T")==null?"N":request.getParameter("calling_from_2T");
		String history_type=request.getParameter("history_type")==null?"":request.getParameter("history_type");
		String event_class=request.getParameter("event_class")==null?"":request.getParameter("event_class");
		String from_date=request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String to_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String event_item=request.getParameter("event_item")==null?"":request.getParameter("event_item");
		String newPrameters="&che_default_mode="+che_default_mode+"&calling_from_2T="+calling_from_2T+"&history_type="+history_type+"&event_class="+event_class+"&from_date="+from_date+"&to_date="+to_date+"&event_item="+event_item;
		//IN066218 END.
		
		String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
		String show_others_unsinged_yn = request.getParameter("SHOW_OTHERS_UNSINGED_YN") == null ? "N" : request.getParameter("SHOW_OTHERS_UNSINGED_YN"); // added for ML-BRU-SCF-1588 [IN054952]
		String senior_radiologist_yn = request.getParameter("senior_radiologist_yn") == null ? "N" : request.getParameter("senior_radiologist_yn"); // added for ML-BRU-SCF-1588 [IN054952]
		//IN073001 Start
		String updateRDExamViewRequest = request.getParameter("updateRDExamViewRequest") == null ? "N" : request.getParameter("updateRDExamViewRequest");
		String request_num = request.getParameter("p_request_num") == null ? "" : request.getParameter("p_request_num");
		String request_line_num = request.getParameter("p_request_line_num") == null ? "" : request.getParameter("p_request_line_num");
		//IN073001 End.
		if(locale.equals(""))
		{
			System.out.println("locale value is comming as empty in InvokePatientHistoryWrapper.jsp");
		}
	
		session.putValue("LOCALE",locale);
		
		
		String param="patient_id="+patient_id+"&mode="+mode+"&facility_id="+facility_id+"&responsibility_id="+resp_id+"&login_user="+login_id+"&login_pwd="+login_pwd+"&accession_num="+accession_number+"&accession_type="+accession_type+"&episode_id="+encounter_id+"&encounter_id="+encounter_id+"&limit_function_id="+limit_function_id+"&locale="+locale+"&note_type="+note_type+"&contr_mod_accession_num="+contr_mod_accession_num+"&function_id="+function_id+"&show_others_unsinged_yn="+show_others_unsinged_yn+"&senior_radiologist_yn="+senior_radiologist_yn+""+newPrameters+"&p_review_rad_yn="+p_review_rad_yn+"&request_num="+request_num+"&request_line_num="+request_line_num+"&updateRDExamViewRequest="+updateRDExamViewRequest;
		//String param=request.getParameter("params")==null ?"":request.getParameter("params");
		System.err.println("1222"+param);
		obj.put("retrived_url",param);
		out.println(obj);

		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception while loading patient history- " + e);
		} 
	}

	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception from RadiologyExamAjax.jsp :" + e);
	} finally {
		ConnectionManager.returnConnection(con, request);
		if(pstmt!=null){
			pstmt.close();
		}
		if(pstmt1!=null){
			pstmt1.close();
		}
		if(rs!=null){
			rs.close();
		}
		if(cstmt!=null){
			cstmt.close();
		}
	}
	%>
<%!
public String checkNull(String inputString)
{
	if(inputString == null || inputString.equals("") ||  inputString.equalsIgnoreCase("null") )
		inputString = "";
	return inputString;
}
%>
