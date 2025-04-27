<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String p_module_id		= "FM" ;
	String p_report_id		= "FMBDFDCT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>
<HEAD>
<script>
function searchCodePrac2(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = "<%=p_facility_id%>";
	var tit="";	
	var locale = "<%= localeName %>";		
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);
	
		
		if(obj.name=="fsPractFromButton")
			getPractitioner(obj,target,'','','','','','','','',"Q2");		
			return;            
	
	var retVal=CommonLookup(tit,argumentArray);

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=retVal[0];
		            
}


function PractLookupRetVal(retVal,objName)
{

	var arr;

	if (retVal != null)
	{
		arr=retVal.split("~");
	
		if(objName=="p_pract_id")
			document.forms[0].p_pract_id.value=arr[0];
		else
			document.forms[0].p_pract_id.value=arr[0];
						
	}
	else
	{
		
		if(objName=="fsPractFromButton")
			document.forms[0].p_pract_id.value="";
		else
			document.forms[0].p_pract_id.value="";
						
	}
	
}
</script>
<TITLE></TITLE>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eFM/js/FMFileDeficiencyReport_SRR.js" language="javascript"></script>
<script src="../../eFM/js/checkSystemDate.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eOP/js/OPPractitionerComponent.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onMouseDown="CodeArrest();" onLoad="document.forms[0].p_pract_id.focus()" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="Doctor" id="Doctor" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
 <%
	Connection conn = ConnectionManager.getConnection(request);
	Statement stmt=null;
	ResultSet rset=null;
	String today ="";
	String file_type_code="";
    String file_type_desc="";
	 String sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";

 
 try
 {
	
	stmt = conn.createStatement();
	rset = stmt.executeQuery(sql);
	if (rset.next())
	{
	today = rset.getString("today");
	}
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
 }
 	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		//ConnectionManager.returnConnection(conn,request);
	}
%>

			<table width='70%' cellPadding="5" cellSpacing="0"  align='center' >

			<tr>
					<td  colspan="4" class='label'>&nbsp;</td>
			</tr>


			<tr>
					<td  class='label' width='30%'>&nbsp;</td>
					<td class='querydata' width='30%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td  class='label' width='10%'>&nbsp;</td>
					<td  class='querydata' width='30%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
			
			<tr>
						<td class='label'><fmt:message key="eFM.ResponsiblePractitioner.label" bundle="${fm_labels}"/></td>
						<td	class='fields' colspan="3"><input type='text' 
						name='p_pract_id' id='p_pract_id' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this); if(document.Doctor.p_pract_id.value !=""){searchCodePrac2(fsPractFromButton,this);} ' value=''  size="17" maxlength="15" maxlength="8" ><input type='button' name='fsPractFromButton' id='fsPractFromButton' value='?' class='button' onclick='searchCodePrac2(this,p_pract_id)'>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></td>
			</tr>

			<tr>
						<td class='label'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
						<td	class='fields'><input type='text' id="date_from"
						name='p_from_date' id='p_from_date' value=''  size="10"	maxlength="10" onBlur='validDateObj(this,"DMY","<%=localeName%>");'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');"/>
						<td class='label'>&nbsp;</td>
						<td class='fields'><input type='text' id="date_to" 
						name='p_to_date' id='p_to_date' value=''  size="10"	maxlength="10" onBlur='validDateObj(this,"DMY","<%=localeName%>");'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');"/></td>
			</tr>			
				
	<tr><td class='label' width='20%' ><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></td>
	<td  class='fields'><select name="p_file_type" id="p_file_type" >
	<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
   <%
   try
     {
	stmt = conn.createStatement();
	rset = stmt.executeQuery("SELECT FILE_TYPE_CODE,SHORT_DESC FROM MR_FILE_TYPE_LANG_VW WHERE FACILITY_ID ='"+p_facility_id+"' AND LANGUAGE_ID='"+localeName+"' AND EFF_STATUS ='E' ");
  while(rset.next())
	{
	file_type_code = rset.getString("FILE_TYPE_CODE");
	if(file_type_code==null) file_type_code="";
	file_type_desc = rset.getString("SHORT_DESC");
	if(file_type_desc==null) file_type_desc="";
		%>
	<option value='<%=file_type_code%>'><%=file_type_desc%>
	<% }
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
     }
 	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	 } %>
	
	</select> </td>
			<td class='label' width='18%'><fmt:message key="eFM.DeficiencyCriteria.label" bundle="${fm_labels}"/></td>
			<td  class='fields' ><select name="p_deficiency_status" id="p_deficiency_status" >
			<option value='ALL' > <fmt:message key="Common.Both.label" bundle="${common_labels}"/> </option>
             <option value='O' ><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
			   <option value='C' ><fmt:message key="Common.close.label" bundle="${common_labels}"/></option>
			   <!-- <option value='X' ><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option> -->
			   
			   </select> </td>
			
			
			</tr>
			
			<tr><td colspan="4" class='label'>&nbsp;</td></tr>		
			
			</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="today" id="today"				value="<%=today%>">
	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
</BODY>
</HTML>

