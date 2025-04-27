<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	 String facilityId					= (String)session.getValue("facility_id");
%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
     	request.setCharacterEncoding("UTF-8");

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eMO/js/MOBurialPermit.js' ></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script language='javascript' src='../../eCommon/js/dchk.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

 <%	
 try{
     Connection con 					= null;
	 java.sql.Statement stmt						= null;
	 ResultSet rset					    = null;
	 String sqlstr						= "";
	 String patient_id_length			= "";
	 String sys_date                    = "";
try
  {
    con	= ConnectionManager.getConnection(request);
	stmt = con.createStatement();

    sqlstr = "select patient_id_length,to_char(sysdate,'dd/mm/yyyy') sdate from mp_param";
    rset = stmt.executeQuery(sqlstr);
    if(rset != null)
       if(rset.next())
	  {
          patient_id_length                  = rset.getString("patient_id_length");
		  sys_date                           = rset.getString("sdate");
	  } 
          
    if(patient_id_length==null || patient_id_length.equals(""))
       patient_id_length = "20";
	 %>  
<body onLoad='' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center >
<form name='MOQueryBurialPermitForm' id='MOQueryBurialPermitForm' >   
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
<tr><td colspan='6'>&nbsp;</th></tr> 
<tr>
	<td class='LABEL' align='RIGHT'><fmt:message key="eMO.DeceasedPatientID.label" bundle="${mo_labels}"/></td>
	<td>&nbsp;<input type='text'  name='patient_id' id='patient_id'  value=""  maxLength='<%=patient_id_length%>' size='20' onKeyPress="return CheckForSpecChars(event)"   onBlur="" ><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="searchCode3(this,document.forms[0].patient_id);" ></td>
    <td class='LABEL' align='RIGHT'><fmt:message key="eMO.BurialPermitNumber.label" bundle="${mo_labels}"/></td>
	<td>&nbsp;<input type='text' name='burial_permit_no' id='burial_permit_no' value='' tabindex=3 size='13' maxlength='12' onKeyPress='return CheckForSpecChars(event)' onBlur=''><input type='button' class='BUTTON' value='?' name='bur_per_no_search' id='bur_per_no_search' onClick ='searchCode2(this,document.forms[0].burial_permit_no)'></td>
    <td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>

<tr>
	<td align='right' class='LABEL'><fmt:message key="eMO.ApprovedDateFrom.label" bundle="${mo_labels}"/></td>
	<td>&nbsp;<input type='text' id='patfrom' value='<%=sys_date%>' maxlength='10'  size=9 tabindex=4 name='bur_per_approve_datefrom' size='15' onBlur='CheckDate(this);'><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('patfrom');"></td>

	<td align='right' class='LABEL'><fmt:message key="eMO.ApprovedDateTo.label" bundle="${mo_labels}"/></td>
	<td>&nbsp;<input type='text' id='patto'  value='<%=sys_date%>' maxlength='10'  size=9 tabindex=5 name='bur_per_approve_dateto' size='15' onblur='dtchk(this);'><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('patto');"></td>
		<td>&nbsp;</td>
		<td >&nbsp;</td>
</tr>  
<tr>
   	<td class='LABEL' align='right'>Approved By</td>
	<td>&nbsp;<input type="text" name="burial_permit_app_desc" id="burial_permit_app_desc" value="" size="30" maxlength="30" onBlur='beforeGetPractitioner(document.forms[0].pract_id,burial_permit_app_desc);'><input type='button' name='pract_id' id='pract_id' value='?' class='button' onclick='searchCode(this, burial_permit_app_by)'>
	<input type='hidden' name='burial_permit_app_by' id='burial_permit_app_by' value =''>
	</td>
	
	<td >&nbsp;</td>
	<td align='right'><input type='button' class='BUTTON' value='Search' tabindex=8 name='search' id='search' onClick='parent.callSearch(patient_id,burial_permit_no,bur_per_approve_datefrom,bur_per_approve_dateto,burial_permit_app_by,parent.messageFrame)'>
	<input type='button' class='BUTTON' value='Clear' tabindex=9 onClick="parent.clear()"></td>
	<td colspan=2>&nbsp;</td>
</tr>
<tr><td colspan=6 class=label height=5></td></tr>	
</table>
<input type=hidden name='facilityId' id='facilityId' value='<%=facilityId%>'>
<input type=hidden name='sys_date' id='sys_date' value='<%=sys_date%>'>
<input type=hidden name='mode' id='mode' value='query'>
</form>
<script>
	//parent.frames[0].document.forms[0].reset.disabled=true;
	parent.frames[0].document.forms[0].apply.disabled=true;
</script>
</body>   
	<% 
	if(rset!=null) rset.close();
    if(stmt!=null) stmt.close();
} catch(Exception e){out.println("sub : "+e);}
   finally
    {
    	if(con!=null)		
		ConnectionManager.returnConnection(con,request);
    }
%>
</html>
<%}
catch(Exception e1)
{
	out.println("main "+e1);
}
%>

