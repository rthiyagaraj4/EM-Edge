<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%@page import ="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
	//String tel_no="";
	//String mobile_no="";
	//String pager_no="";
	//String job_title_pract_dtls="";
	//String pract_type="";
	//String pract_type_desc="";

/////////////////////////////////////////////////////////////
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get("SEARCH") ;
	String  practName_FValue = (String) hash.get("practName_FValue")==null?"":(String) hash.get("practName_FValue") ;
	String  practName_FName = (String) hash.get("practName_FName")==null?"":(String) hash.get("practName_FName") ;
	


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

	hash.clear();

 	//Added for this CRF ML-MMOH-CRF-0862
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
 	//End this CRF ML-MMMOH-CRF-0862
%>

async function practSearch(){

	var retVal = 	new String();
	var dialogTop = "0vh" ;
	var dialogHeight= "92vh" ;
	var dialogWidth	= "97vw" ;
	/*Below line added for this CRF ML-MMOH-CRF-0862*/
	if("<%=cernerIdSiteSpecific%>" =="true") {        	
	    dialogWidth="97vw";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	var sqlArray= new Array();
	var objName="<%=practName_FName%>";
	   arguments='';
	
	retVal = await window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>"+"&title="+getLabel('Common.practitioner.label','Common'),arguments,features);
	PractLookupRetVal(retVal,objName);
}
practSearch();
