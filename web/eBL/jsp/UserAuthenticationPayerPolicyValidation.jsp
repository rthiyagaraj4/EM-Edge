<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
1-Jan-2014      100           	Karthikeyan.K          created
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page
	import="webbeans.eCommon.*,eBL.*,eBL.Common.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//System.out.println("$$$$ UserAuthenticationPayerPolicyValidation.jsp page called" + request.getQueryString());
%>
<%!

	/* 
	MMS-SCF-0355 - Added by Karthikeyan on 26/05/2014 
	Successful Authentication returns "Y", failed Authentication returns "N"
	*/
	String isAuthenticatedUser(Connection con,String facilityId,String loggedUser,String responsibilityId,String functionId,String custGroupCode,String custCode,String policyTypeCode,String privilageCode,java.sql.Date curDate) throws SQLException{
				
	CallableStatement calStmt = con.prepareCall("{ call blpolicyuseraccessdtls.get_bl_multi_privlege_yn(?,?,?,?,?,?,?,?,?,?,?) }");
	calStmt.setString(1,facilityId);
	calStmt.setString(2,loggedUser);
	calStmt.setString(3,responsibilityId);
	calStmt.setString(4,functionId);
	calStmt.setString(5,custGroupCode);
	calStmt.setString(6,custCode);
	calStmt.setString(7,policyTypeCode);
	calStmt.setString(8,privilageCode);
	calStmt.setDate(9,curDate);
	calStmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	calStmt.registerOutParameter(11,java.sql.Types.VARCHAR);
	calStmt.execute();	
	String privilageValue = calStmt.getString(10);	
	String validAuthenticatedUser = calStmt.getString(11);
	System.err.println("54, validAuthenticatedUser==>"+validAuthenticatedUser);
	if(calStmt!=null){
		calStmt.close();
	}
	
	if(validAuthenticatedUser==null) validAuthenticatedUser="N";		
	return validAuthenticatedUser;
}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<HTML>
<HEAD>
</HEAD>
<body>
<%
	String calledFromPage=null; 
	String loggedUser=null;
	Connection con=null;

	calledFromPage=request.getParameter("calledFromPage");
	if(calledFromPage==null)calledFromPage="";

	if(calledFromPage.equals("SAVE_SUCCESSFULLY_LOGGED_IN_USER")){	
		loggedUser= request.getParameter("successfulUser"); 
		session.setAttribute("succesfully_logged_in_user",loggedUser);
		out.println("@@@SUCCESS@@@");
	}else{		
	try {
		con=ConnectionManager.getConnection(request);
		request.setCharacterEncoding("UTF-8");
		Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		hash = (Hashtable) hash.get("SEARCH");		
		System.out.println(hash);
   		String validAuthenticatedUser="N";   		
   		boolean validateAllPayers=false;

		String functionId="";
		String privilageCode="";
		String custGroupCode="";
		String custCode="";
		String policyTypeCode="";
		String episodeType="";

   		if(calledFromPage.equals("POLICY_DEFN_CREATE")){  
   			loggedUser=(String)session.getAttribute("login_user");
   			custGroupCode=request.getParameter("payerCode");
   			custCode=request.getParameter("payer");
   			policyTypeCode=request.getParameter("policy");
   			if(custGroupCode==null) custGroupCode="";
   			if(custCode==null) custCode="";
   			if(policyTypeCode==null) policyTypeCode="";
			functionId="POLICY_DEFN";
			privilageCode="CREATE_PLCY";
   		}  
   		
   		if(calledFromPage.equals("POLICY_DEFN_MODIFY")){  
   			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");									
   			custGroupCode=(String)hash.get("payerCode2");
   			custCode=(String)hash.get("payerCode");
   			policyTypeCode=(String)hash.get("policyTypeCode");  
			functionId="POLICY_DEFN";
			privilageCode="MODIFY_PLCY";
   		}  
   		/* Added V190517-Aravindh/NMC-JD-CRF-0010/Starts */
   		if(calledFromPage.equals("POLICY_DEFN_APPROVE")){  
   			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");   			
			custGroupCode=request.getParameter("payerCode");
   			custCode=request.getParameter("payer");
   			policyTypeCode=request.getParameter("policy");
   			if(custGroupCode==null) custGroupCode="";
   			if(custCode==null) custCode="";
   			if(policyTypeCode==null) policyTypeCode="";
			functionId="POLICY_DEFN";
			privilageCode="APPRV_UNAPPRV_PLCY";
   		}
   		/* Added V190517-Aravindh/NMC-JD-CRF-0010/Ends */
   		if(calledFromPage.equals("MOD_FIN_DTLS_VAL_ALL")){  
    			loggedUser=(String)session.getAttribute("login_user");
//    			custGroupCode=request.getParameter("payerCode");
//    			custCode=request.getParameter("payer");
//    			policyTypeCode=request.getParameter("policy");
//    			String calledModuleId = request.getParameter("blngClass");   			

   			custGroupCode=(String)hash.get("payerCode");
   			custCode=(String)hash.get("payer");
   			policyTypeCode=(String)hash.get("policy");
   			String calledModuleId = (String)hash.get("blngClass");   			
   			
   			if(custGroupCode==null) custGroupCode="";
   			if(custCode==null) custCode="";
   			if(policyTypeCode==null) policyTypeCode="";
			if(calledModuleId == null) calledModuleId="";
   			
			if("OP".equals(calledModuleId)){
				functionId="OP_VISIT";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("EM".equals(calledModuleId) || "AE".equals(calledModuleId)){
				functionId="REG_ATTENDANCE";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("IP".equals(calledModuleId) || "DC".equals(calledModuleId)){
				functionId="IP_ADMMISION";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("MP".equals(calledModuleId) || "".equals(calledModuleId)){
				functionId="REG_PATIENT";
				privilageCode="ASSOCIATE_CUST_PLCY";
			} 	
			
			validateAllPayers=true;
			
   		}
   		
   		if(calledFromPage.equals("MOD_FIN_DTLS_VAL_ALL_AUTH")){  
//  			loggedUser=request.getParameter("authorizedUser");
//    			custGroupCode=request.getParameter("payerCode");
//    			custCode=request.getParameter("payer");
//    			policyTypeCode=request.getParameter("policy");
//    			String calledModuleId = request.getParameter("blngClass");
   			
   			loggedUser=(String)hash.get("authorizedUser");
   			custGroupCode=(String)hash.get("payerCode");
   			custCode=(String)hash.get("payer");
   			policyTypeCode=(String)hash.get("policy");
   			String calledModuleId = (String)hash.get("blngClass");		
		
   			
   			if(custGroupCode==null) custGroupCode="";
   			if(custCode==null) custCode="";
   			if(policyTypeCode==null) policyTypeCode="";
			if(calledModuleId == null) calledModuleId="";
   			
			if("OP".equals(calledModuleId)){
				functionId="OP_VISIT";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("EM".equals(calledModuleId) || "AE".equals(calledModuleId)){
				functionId="REG_ATTENDANCE";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("IP".equals(calledModuleId) || "DC".equals(calledModuleId)){
				functionId="IP_ADMMISION";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("MP".equals(calledModuleId) || "".equals(calledModuleId)){
				functionId="REG_PATIENT";
				privilageCode="ASSOCIATE_CUST_PLCY";
			} 	
			
			validateAllPayers=true;
   		}
   		
   		if(calledFromPage.equals("MOD_FIN_DTLS")){  
   			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");
   			custGroupCode=(String)hash.get("ins_cust_group_code");
   			custCode=(String)hash.get("cust_3");
   			policyTypeCode=(String)hash.get("policy_type_code"); 
   			episodeType=(String)hash.get("episode_type");
   			
   			if("O".equals(episodeType)){
   				functionId="OP_VISIT";
   				privilageCode="MODIFY_CUST_PLCY";
   			}
   			else if("E".equals(episodeType)){
   				functionId="REG_ATTENDANCE";
   				privilageCode="MODIFY_CUST_PLCY";
   			} 
   			else if(("I".equals(episodeType)) || ("D".equals(episodeType))){
   				functionId="IP_ADMMISION";
   				privilageCode="MODIFY_CUST_PLCY";
   			}
   			else if("R".equals(episodeType)){
   				functionId="REG_PATIENT";
   				privilageCode="MODIFY_CUST_PLCY";
   			}   			
   		}  

   		if(calledFromPage.equals("ENC_SPEC_PLCY")){
   			loggedUser= (session.getAttribute("succesfully_logged_in_user")==null)?(String)session.getAttribute("login_user") : (String)session.getAttribute("succesfully_logged_in_user");
   			custGroupCode=request.getParameter("payerGroup");
   			custCode=request.getParameter("payer");
   			policyTypeCode=request.getParameter("policy");   			
			functionId="ENCOUNTR_POLCY";
			privilageCode="MODIFY_ENC_PLCY";
   		}
   		
  	//start-added for MMS CRF 125- Pradeepa 
  	
  	// System.out.println("successfulUser:"+request.getParameter("successfulUser"));
 	// System.out.println("calledFromPage:"+request.getParameter("calledFromPage"));
  	
   		if(calledFromPage.equals("PKG_PRIC_BULK_UPDATE")){
  			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");
  			System.out.println("loggedUser:"+loggedUser);
   			custGroupCode="**";//request.getParameter("");
   			custCode="**";//request.getParameter("");
   			policyTypeCode="**";//request.getParameter("");   			
			functionId="PKG_BULK_UPDATE";
			privilageCode="PKG_PRICE_UPD";
   		}	
   		
   		if(calledFromPage.equals("PKG_DISC_BULK_UPDATE")){
  			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");
  			System.out.println("loggedUser:"+loggedUser);
   			custGroupCode="**";//request.getParameter("");
   			custCode="**";//request.getParameter("");
   			policyTypeCode="**";//request.getParameter("");   			
			functionId="PKG_BULK_UPDATE";
			privilageCode="PKG_DISC_UPD";
   		}	
   		
   		if(calledFromPage.equals("Billed")){
  			
   			System.out.println("Called from billed");
   			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");
  			System.out.println("loggedUser:"+loggedUser);
   			custGroupCode="**";//request.getParameter("");
   			custCode="**";//request.getParameter("");
   			policyTypeCode="**";//request.getParameter("");   			
			functionId="RECORD_APPROVAL";
			privilageCode="CHG_APPR_STATUS_FOR_BILLED_REC";
   		}
	
   	//end- added for MMS CRF 125- Pradeepa 
   	
   

   		String facilityId=(String)session.getAttribute("facility_id");
   		String responsibilityId=(String)session.getAttribute("responsibility_id");
   		java.sql.Date curDate= new java.sql.Date(new java.util.Date().getTime());
   		
		/* 
		MMS-SCF-0355 - Added by Karthikeyan on 26/05/2014 
		The below logic loads the default loaded policies for the default billing group from the session
		and seperates them from new policies and provides them different previlage for authentication. 
		*/
   		if(validateAllPayers==true){
   			
   			ArrayList<String> defaultLoadedCustomerList=session.getAttribute("BL_DEFAULT_LOADED_BLNG_GROUP_INFO")==null ? new ArrayList<String>() : (ArrayList<String>)session.getAttribute("BL_DEFAULT_LOADED_BLNG_GROUP_INFO") ;
   					  			
   			StringTokenizer stCustGrpTok=new StringTokenizer(custGroupCode,"|");
   			StringTokenizer stCustCodeTok=new StringTokenizer(custCode,"|");
   			StringTokenizer stCustPlcyTok=new StringTokenizer(policyTypeCode,"|");
   			
   			String defaultCustGroupCode="";
   			String defaultCustCode="";
   			String defaultPolicyTypeCode="";
   			String newCustGroupCode="";
   			String newCustCode="";
   			String newPolicyTypeCode="";
   			boolean defaultPolicyAvailable=false;
   			boolean newPolicyAvailable=false;
   			
   			while(stCustGrpTok.hasMoreTokens()){
   				String stCustGrpTemp= stCustGrpTok.nextToken();
   				String stCustCodeTemp=stCustCodeTok.nextToken();
   				String stCustPlcyTemp=stCustPlcyTok.nextToken();
   				
   				if( stCustGrpTemp!=null && !stCustGrpTemp.equals("") ){
   				String strDefaultInfo = stCustGrpTemp+"|"+stCustCodeTemp+"|"+stCustPlcyTemp;
  			
   					if(defaultLoadedCustomerList.contains(strDefaultInfo)){
   						defaultCustGroupCode+=stCustGrpTemp+"|";
   						defaultCustCode+=stCustCodeTemp+"|";
   						defaultPolicyTypeCode+=stCustPlcyTemp+"|";
   						defaultPolicyAvailable=true;
	   				}else{
	   					newCustGroupCode+=stCustGrpTemp+"|";
	   					newCustCode+=stCustCodeTemp+"|";
	   					newPolicyTypeCode+=stCustPlcyTemp+"|";
	   					newPolicyAvailable=true;
	   				}
   				}
   			}  	
   			
   			
  /*   		System.out.println("**************   ALL POLICY LIST     ******************");
   			System.out.println(custGroupCode);
   			System.out.println(custCode);
   			System.out.println(policyTypeCode); 
    		System.out.println("**************   NEW POLICY LIST     ******************");
   			System.out.println(newCustGroupCode);
   			System.out.println(newCustCode);
   			System.out.println(newPolicyTypeCode);
			System.out.println("**************   DEFAULT POLICY LIST     ******************");
   			System.out.println(defaultCustGroupCode);
   			System.out.println(defaultCustCode);
   			System.out.println(defaultPolicyTypeCode); */
   			
   						
   			/*	For Validating Newly added customer Group			*/  
   			if(newPolicyAvailable==true){
   			validAuthenticatedUser=isAuthenticatedUser(con,facilityId,loggedUser,responsibilityId,functionId,newCustGroupCode,newCustCode,newPolicyTypeCode,privilageCode,curDate);
   			}else{
   				validAuthenticatedUser="Y"; 
   			}
 			/*	For Validating Default loaded customer Group		*/
			if(defaultPolicyAvailable==true && validAuthenticatedUser.equals("Y")){
			privilageCode="DFLT_CUST_PLCY";
		   	validAuthenticatedUser=isAuthenticatedUser(con,facilityId,loggedUser,responsibilityId,functionId,defaultCustGroupCode,defaultCustCode,defaultPolicyTypeCode,privilageCode,curDate);	
			}	   		
   		}else{   /*For Regular validations where a policy is authenticated for a user*/	
		validAuthenticatedUser=isAuthenticatedUser(con,facilityId,loggedUser,responsibilityId,functionId,custGroupCode,custCode,policyTypeCode,privilageCode,curDate);
   		}
			
		if(validAuthenticatedUser.equals("Y")){
		out.println("@@@SUCCESS@@@");
		}else{
		out.println("@@@FAILED@@@");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception from PayerMaterialValidation.jsp :"+ e);
	}finally{
		ConnectionManager.returnConnection(con);
	}

}


%>
</body>
</HTML>
