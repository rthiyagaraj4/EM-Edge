<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
11/04/2019		ML-MMOH-CRF-1064	Kamalakannan G		11/04/2019		Ramesh Goli		IN066304
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />

<%
//start 32902
Connection conn=null;
conn=ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
// end 32902
	try {
		Hashtable hashObj = (Hashtable) XMLobj.parseXMLString(request);
		hashObj = (Hashtable) hashObj.get("SEARCH");
		String bean_id					= "CAClinicalHistoryBean" ;
		String bean_name				= "eCA.CAClinicalHistoryBean";
		String action = (String) hashObj.get("p_action") == null ? "": (String) hashObj.get("p_action");
	
		
		CAClinicalHistoryBean bean	= (CAClinicalHistoryBean)getBeanObject( bean_id, bean_name , request) ;
		//start 32902
		String ca_bean_id 						= "@CACommonGetPatientDtlBean";
		String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
		CACommonGetPatientDtlBean bean1			= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
		//end 32902
		if("PARENT_CHK".equals(action)){
			String hist_type = (String) hashObj.get("key") == null ? "": (String) hashObj.get("key");
			String histArr[] = hist_type.split("_");
			String event_class = "";
			hist_type = histArr[0];
			String flag = (String) hashObj.get("flag") == null ? "": (String) hashObj.get("flag");
			String eventList = (String) hashObj.get("eventList") == null ? "": (String) hashObj.get("eventList");
			LinkedHashMap<String,String> clntObj = bean.updateAllClinicalNotePrintingFlags(hist_type,flag,eventList);
			bean.parentAndChildChkFunc(hist_type,event_class,flag);
			out.println(clntObj);
		}else if("CLNT_CHILD_CHK".equals(action)){
			String hist_type = (String) hashObj.get("hist_type") == null ? "": (String) hashObj.get("hist_type");
			ArrayList list = bean.getClinicalNotePrintingEventClass(hist_type);
			out.println(list);
		}else if("CLNT_CHILD_INNER_CHK".equals(action)){
			String hist_type = (String) hashObj.get("hist_type") == null ? "": (String) hashObj.get("hist_type");
			String patient_id = (String) hashObj.get("patient_id") == null ? "": (String) hashObj.get("patient_id");
			String encounter_id = (String) hashObj.get("encounter_id") == null ? "": (String) hashObj.get("encounter_id");
			String date_from = (String) hashObj.get("date_from") == null ? "": (String) hashObj.get("date_from");
			String date_to = (String) hashObj.get("date_to") == null ? "": (String) hashObj.get("date_to");
			String arr[] = hist_type.split("_");
			String hist_rec = arr[0].trim();
			String event_class = arr[1];
			String flag		 = (String) hashObj.get("key") == null ? "": (String) hashObj.get("key");
			bean.updateValues(hist_type,flag);
			bean.parentAndChildChkFunc(hist_rec,event_class,flag);
			String checkFlag = bean.UIFunction(hist_rec);//testing
			bean.getDefaultClntMap(patient_id,encounter_id,date_from,date_to);
			String parentCheckflag = bean.getParentCheckFlag();
			out.println("changeCheckBox('"+checkFlag+"','"+hist_rec+"','"+parentCheckflag+"')");
		}else if("PRINTING_FINAL_LIST".equals(action)){
			System.out.println(bean.finalizePrintList());
		}else if("SELECT_ALL".equals(action)){
			String flag		 = (String) hashObj.get("flag") == null ? "": (String) hashObj.get("flag");
			String patient_id = (String) hashObj.get("patient_id") == null ? "": (String) hashObj.get("patient_id");
			String encounter_id = (String) hashObj.get("encounter_id") == null ? "": (String) hashObj.get("encounter_id");
			String date_from = (String) hashObj.get("date_from") == null ? "": (String) hashObj.get("date_from");
			String date_to = (String) hashObj.get("date_to") == null ? "": (String) hashObj.get("date_to");
			bean.getSelectAllListForPrint(flag);
			bean.selectAllCheckBox(flag, patient_id, encounter_id, date_from, date_to);
		}
		//start 32902
		else if("IS_PAT_RESTRICTED".equals(action)){
			int accessRightsViewPatient=0;
			String restPatientYN="";		
			String patient_id = (String) hashObj.get("patient_id") == null ? "": (String) hashObj.get("patient_id");
			String facility_id = (String) hashObj.get("facility_id") == null ? "": (String) hashObj.get("facility_id");
			String clinicianId = (String) hashObj.get("clinicianId") == null ? "": (String) hashObj.get("clinicianId");			
			accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902			
			if(!patient_id.equals("") || !patient_id.equals(null)){
			restPatientYN=bean1.getRestrictedPatientYN(patient_id);
			}            
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
		//end 32902
	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>
