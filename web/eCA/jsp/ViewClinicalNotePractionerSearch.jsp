<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language=javascript>
function callfunction(){
var target=top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].performed_by;
var splval= top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].performed_by.value;
var facilityid=top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].facilityid.value;

var retVal=  new String();
var dialogTop	= "40";
var dialogHeight= "10" ;
var dialogWidth= "40" ;
var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
var arguments	= "" ;
var search_desc	= "";
var title="Practioner ID";
var locale = top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].locale.value;
//var sql="SELECT A.practitioner_id code, practitioner_name description from AM_PRACT_FOR_FACILITY A,AM_PRACTITIONER_LANG_VW B where A.eff_status='E' and upper(B.practitioner_name) like upper(?) and B.practitioner_id like ? AND A.PRACTITIONER_ID = B.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' ";
var sql=" Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where UPPER(b.practitioner_name) like upper(?) AND a.practitioner_id like upper(?) AND a.facility_id = '"+facilityid+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' ";
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
if(top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].performed_by.value!="" ){
retArray = CommonLookup(title,argArray);
if(retArray != null && retArray !=""){
top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].performed_by.value = retArray[1];
top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].performed_by_code.value=retArray[0];

top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc.focus();
//parent.frames[3].document.forms[0].id.disabled=false;
}//if
else
{
	top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].performed_by.value= "";
	top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].performed_by_code.value="";

	top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc.focus();
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
		
		String perform=request.getParameter("perform")==null?"":request.getParameter("perform");	
		String performed_by_code="";
		String performed_by="";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		int count=0;
		
		try
		{
				PreparedStatement pstmt=null;
				ResultSet rset=null;
				con=ConnectionManager.getConnection(request);
        if (!perform.equals("")){
						perform=perform+"%";
						}
			StringBuffer sql= new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select practitioner_id,AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1') practitioner_name from "); 
			sql.append("AM_PRACT_FOR_FACILITY where EFF_STATUS ='E' AND "); 
			sql.append("practitioner_id like ?");  




		    pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,perform);
			rset=pstmt.executeQuery();
					while(rset.next())
					{	
							performed_by_code=rset.getString("practitioner_id");
							performed_by=rset.getString("practitioner_name");
							   count=count+1;
					}   
      
//out.println("Tab Count="+count);
  if (count==1)
		{
		      out.println("<script>");
		 	out.println("top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].performed_by_code.value='"+performed_by_code+"'");
			out.println("top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].performed_by.value='"+performed_by+"'");
			out.println("top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.document.forms[0].med_anc.focus()");
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
				//out.println("Exception in ViewClinicalNotePractionerSearch.jsp"+ex.toString());//COMMON-ICN-0181
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

