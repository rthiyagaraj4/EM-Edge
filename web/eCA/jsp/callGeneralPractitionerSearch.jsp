<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
22/04/2024  50627    Twinkle Shah    22/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------------------
*/
%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%@page import ="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
   <%
    request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get("SEARCH") ;
	String  practName_FValue = (String) hash.get("practName_FValue")==null?"":(String) hash.get("practName_FValue") ;
	String  practName_FName = (String) hash.get("practName_FName")==null?"":(String) hash.get("practName_FName") ;
	String  specialty_code1 = (String) hash.get("specialty_code1")==null?"":(String) hash.get("specialty_code1") ; //ttt
	String  sql = (String) hash.get("sql")==null?"":(String) hash.get("sql");
	sql = java.net.URLDecoder.decode(sql,"UTF-8");
		session.putValue("sql",sql);

	String  sqlSec = (String) hash.get("sqlSec")==null?"":(String) hash.get("sqlSec") ;
	sqlSec = java.net.URLDecoder.decode(sqlSec,"UTF-8");
	session.putValue("sqlSec",sqlSec);

	String  practitioner_type = (String) hash.get("practitioner_type")==null?"":(String) hash.get("practitioner_type");
	String  specialty_code = (String) hash.get("specialty_code")==null?"":(String) hash.get("specialty_code") ;
	String  job_title = (String) hash.get("job_title")==null?"": (String) hash.get("job_title");
	String  gender = (String) hash.get("gender")==null?"":(String) hash.get("gender");	
	String  patient_id = (String) hash.get("patient_id")==null?"":(String) hash.get("patient_id");	
	String  encounter_id = (String) hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");	
	String  facility_id = (String) hash.get("facility_id")==null?"":(String) hash.get("facility_id");	

hash.clear();

  boolean cernerIdSiteSpecific = false;
  Connection conn=null;
  try{
	  conn=ConnectionManager.getConnection(request);
	  cernerIdSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","CERNER_PRACTITIONER_ID");
 }catch(Exception ex){
  ex.printStackTrace();
 }finally{ 
		if (conn != null) ConnectionManager.returnConnection(conn,request);
}  
%>
	var retVal = 	new String();
	var dialogTop = "60" ;
	var dialogHeight= "37" ;
	var dialogWidth	= "65" ;
	/*Below line added for this CRF ML-MMOH-CRF-0862*/
	if("<%=cernerIdSiteSpecific%>" =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	var objName="<%=practName_FName%>";
    arguments='';

retVal = window.showModalDialog("<%=request.getContextPath()%>/eCA/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code1%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);

PractLookupRetVal(retVal,objName,facility_id,patient_id,encounter_id);
			


  
   
   



		
	
                    
       				
	
	


