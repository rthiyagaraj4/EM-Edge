<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%

String pid_length="";
Connection conn1 = null;
Statement stmt=null;
ResultSet rset=null;
try{
	conn1 = ConnectionManager.getConnection(request);
	try{
		stmt = conn1.createStatement();
		String sql4 = "select patient_id_length from mp_param";
		rset = stmt.executeQuery(sql4);
		if(rset != null)
		   if(rset.next())
			  pid_length = rset.getString(1);
			  
		if(pid_length==null || pid_length.equals(""))
		   pid_length = "20";
	}
	catch(Exception e){/* out.println("Excep4:"+e); */ e.printStackTrace();
	}

%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eMR/js/ReprintSickLeave.js'></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<script>
function changeCase(Obj)
	{
		Obj.value=Obj.value.toUpperCase();
	
	}
</script>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name='query_criteria_form' id='query_criteria_form'>
    <table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
    <tr>
        <td class='label' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
        <td class='fields' width='30%'> <input type='text' name='PatientId' id='PatientId' size='20' onBlur='changeCase(this)' maxlength='<%=pid_length%>'><input type='button' class='button'  name='butpat' id='butpat' value='?'  onclick='patqry()'></td>
        <td class='LABEL' width='10%'> <fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
        <td class='fields' width='30%'> <select name='PatientClass' id='PatientClass'><option value = ''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--<option value = 'OP'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/><option value = 'IP'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></select></td>
        <td class='LABEL' width='10%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
        <td class='fields' width='10%'> <input type="text" name="EncounterId" id="EncounterId" size="12" maxlength="12" onKeyPress='return allowValidNumber(this,event,12,0)' onblur='CheckNum(this)'></td>
    </tr>    
    <tr>
        <td class='LABEL' ><fmt:message key="Common.LeaveFrom.label" bundle="${common_labels}"/></td>
        <td class='fields'><input type='Select'  id='leave_date_from' name='LeaveFrom' id='LeaveFrom' size='10' maxlength='10' onBlur = "validDateObj(this,'DMY','<%=localeName%>')"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById("LeaveFrom").focus();return showCalendar('leave_date_from');" style="cursor='hand'"></img></td>
        <td class='LABEL'> <fmt:message key="Common.LeaveTo.label" bundle="${common_labels}"/></td>
        <td class='fields' colspan='2'> <input type='text' id='leave_date_to'name='LeaveTo' size='10' maxlength='10' onBlur = "validDateObj(this,'DMY','<%=localeName%>')"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById("LeaveTo").focus();return showCalendar('leave_date_to');" style="cursor='hand'"></img></td>
         <td class='button'><input type="button" class='Button' name="search_button" id="search_button" title='Search' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onclick="DisplyResult();"><input type="button" class='Button' name="clear_button" id="clear_button" title='Clear' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onclick="clearQry()"></td>
       </tr>
    </table>
</form>
</body>
</html>
<%if(rset!=null)rset.close();
	if(stmt!=null)stmt.close();

}
catch(Exception e){/* out.println("Excep1:"+e); */e.printStackTrace();}
finally
{

if(conn1!=null) ConnectionManager.returnConnection(conn1,request);
}
%>

