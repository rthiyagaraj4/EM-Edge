<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language=javascript>
function callfunction(){
var target=top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc;
var splval= top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc.value;
var facilityid=top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].facilityid.value;

var retVal=  new String();
var dialogTop	= "40";
var dialogHeight= "10" ;
var dialogWidth= "40" ;
var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
var arguments	= "" ;
var search_desc	= "";
var title="Service ID";
var locale = top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].locale.value;

var sql="SELECT service_code code, short_desc description from am_service_lang_vw where eff_status='E' and upper(short_desc) like upper(?) and service_code like UPPER(?) and language_id = '"+locale+"' ";

var argArray = new Array();
var namesArray = new Array();
var valuesArray = new Array();
var datatypesArray = new Array();
argArray[0] = sql;
argArray[1] = namesArray;
argArray[2] = valuesArray;
argArray[3] = datatypesArray;
argArray[4] = "2,1";
argArray[5] = target.value;
argArray[6] = DESC_LINK;
argArray[7] = DESC_CODE;
if(top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc.value!="" ){
retArray = CommonLookup(title,argArray);
if(retArray != null && retArray !=""){
top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc.value = retArray[1];
top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc_code.value=retArray[0];

top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].from_date.focus();
//parent.frames[3].document.forms[0].id.disabled=false;
}//if
else
{
	top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc.value= "";
	top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc_code.value="";

	top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].from_date.focus();
//	parent.frames[3].document.forms[0].id.disabled=false;

}
}//if
top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}
//callfunction
</script>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		request.setCharacterEncoding("UTF-8");	
		Connection con=null;
		
		String service=request.getParameter("service")==null?"":request.getParameter("service");	
		//out.println("Speci="+speci);
		String service_code="";
		String service_desc="";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		int count=0;
		try
		{
				PreparedStatement pstmt=null;
				ResultSet rset=null;
				con=ConnectionManager.getConnection(request);
        if (!service.equals("")){
						service=service+"%";
						}
			StringBuffer sql= new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select service_code,AM_GET_DESC.AM_SERVICE(service_code,?,'2') short_desc from "); 
			sql.append("am_service where EFF_STATUS ='E' AND "); 
			sql.append("service_code like UPPER(?)");  

			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,service);
			rset=pstmt.executeQuery();
					while(rset.next())
					{	
							service_code=rset.getString("service_code");
							service_desc=rset.getString("short_desc");
							   count=count+1;
					}   
      
//out.println("Tab Count="+count);
  if (count==1)
		{
		      out.println("<script>");
		 	out.println("top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc_code.value='"+service_code+"'");
			out.println("top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc.value='"+service_desc+"'");
			out.println("top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].from_date.focus()");
			//out.println("parent.frames[1].document.forms[0].flagSpecialty.value='true' ");
			out.println("top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp' ");

		out.println("</script>");
		 } 
    if(count>1 || count==0)
		{
			%>
		<script language=javascript>
			//parent.frames[0].document.forms[0].id.disabled=true;
			callfunction();
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



        <% 

		}//if 
	if (rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
	}
	catch(Exception ex)
	{
				//out.println("Exception in ViewClinicalNoteServiceSearch.jsp"+ex.toString());//COMMON-ICN-0181
				ex.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if (con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
<input type= "hidden" name="locale" id="locale" value="<%=locale%>">
</body>
</html>

