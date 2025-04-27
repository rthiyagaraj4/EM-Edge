<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
18/10/2023     32902             Krishna Pranay    	                  19/10/2023                                         Ramesh G                              MMS-DM-CRF-0210	
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />

<%
Connection conn=null;
conn=ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
	try {
		Hashtable hashObj = (Hashtable) XMLobj.parseXMLString(request);
		hashObj = (Hashtable) hashObj.get("SEARCH");
				String ca_bean_id 						= "@CACommonGetPatientDtlBean";
				String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
				CACommonGetPatientDtlBean bean1			= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
				String action = (String) hashObj.get("p_action") == null ? "": (String) hashObj.get("p_action");
		 if("IS_PAT_RESTRICTED".equals(action)){
			int accessRightsViewPatient=0;
			String restPatientYN="";		
			String patientid = (String) hashObj.get("patientid") == null ? "": (String) hashObj.get("patientid");
			String facility_id = (String) hashObj.get("facility_id") == null ? "": (String) hashObj.get("facility_id");
			String practitioner_id = (String) hashObj.get("practitioner_id") == null ? "": (String) hashObj.get("practitioner_id");

			
			accessRightsViewPatient=bean1.getAccessRightsViewPatient(practitioner_id,facility_id);	//32902
			restPatientYN=bean1.getRestrictedPatientYN(patientid);
            
            if(accessRightsViewPatient == 1 && restPatientYN.equals("Y")){
    			out.println("N");
    		}else if(accessRightsViewPatient == 1 && restPatientYN.equals("N")){
    			out.println("N");
    		}else if(accessRightsViewPatient == 0 && restPatientYN.equals("Y")){
    			out.println("Y");
    		}else{
    			out.println("N");
    		}
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>
