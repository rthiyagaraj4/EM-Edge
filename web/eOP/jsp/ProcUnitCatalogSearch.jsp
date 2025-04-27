<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%	
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Statement stmt=null;
	ResultSet rs =null;
	String called_from=request.getParameter("called_from");
	
	String facility_id=(String)session.getValue("facility_id");	
	try{
	
%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>	
	<script src='../js/ProcUnitCatalog.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
	TD.BLANKROW{
		FONT-SIZE: 2 pt; 
	}

	</style>
<script>

function PopulateResult()
{
	temp='';
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	//document.forms[0].clinic_code.value=document.forms[0].clinic_code_desc.value;
	var clinic_code=document.forms[0].clinic_code.value;
	var dept_code=document.forms[0].dept_code.value;
	
	var called_from='<%=called_from%>';
	
	if(clinic_code!="" && dept_code!=""){
	if (called_from=="1")		parent.frames[1].location.href='../../eOP/jsp/AddModifyProcUnitCatalog.jsp?clinic_code='+clinic_code+'&fromSelect=fromSelect';
	}

	else
	{
		var err=getMessage("CAN_NOT_BE_BLANK","COMMON");
		err= err.replace('$',getLabel('Common.clinic.label','Common'));
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+err
		
	}



}
function PopulateValues(obj)
{
	var called_from='<%=called_from%>';
	
	
	if(obj.value!="")
	{
		var clinic_code=obj.value;
		document.forms[0].Search.disabled=false;
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='clinicTempForm' id='clinicTempForm' method='post' action='../../eOP/jsp/PopulateClinicValues.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'></form></body></html>";	
		parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.frames[2].document.forms[0].submit();
	}
/*	else
	{
		//var clinic_code=obj.value;
		
		document.forms[0].Search.disabled=true;
		parent.parent.frames[1].location.href='../../eOP/jsp/ClinicMain.jsp?called_from='+called_from;
	}*/
}


function ChkClinic()
{

	
	if(document.forms[0].clinic_code.value == '')
	{
		document.forms[0].Search.disabled=true;
	}

}
</script>
</head>
<body onLoad='FocusFirstElement();ChkClinic();' onKeyDown='lockKey();'>
<form name='Search_form' id='Search_form'>
  <table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
	<tr>
		<td width="20%" >&nbsp;</td>
		<td width="70%" >&nbsp;</td>
		<td width="2%" >&nbsp;</td>
		<td width="10%" >&nbsp;</td>
	</tr>
	 <tr>
	  	<td align='right' width="20%" class='label'>&nbsp;&nbsp;<fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/> &nbsp;&nbsp;</td>
		 <td align='left' class=label id=td5>
		 <%
			//if(count>15) commented this condition and made true always to get through search and
			//				left the else part as it is for future modification.
		
			if(true)
			{	 
		 %>
			 
			 &nbsp;<select name="clinic_code" id="clinic_code" onchange="PopulateValues(this)">
				<option value=''>&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------&nbsp;</option>
				 <%
				 con = ConnectionManager.getConnection(request);
				 stmt=con.createStatement();
				 String sql="select CLINIC_CODE,long_DESC from OP_CLINIC where eff_status='E' "+"and facility_id='"+facility_id+"' "+"and procedure_unit_yn='Y' order by long_DESC ";
				// out.println(sql);
//				 "+"and procedure_unit_yn='Y' 
				 rs=stmt.executeQuery(sql);
				 
					if(rs!=null)
					{
					   while(rs.next())
					   {%>
							<option value='<%=rs.getString("CLINIC_CODE")%>'><%=rs.getString("long_DESC")%></option>
					 <%}
					}
					
				%>
			 </select>
			<img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<%
			}
			%>
			
		
		<td>&nbsp;</td>
		<td align=center>&nbsp;<input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' name='Search' onclick='PopulateResult()' ></td>		
   	</tr>
	<table border='0' cellpadding='1' cellspacing='0' width='90%' align='center' id=tab style='visibility:hidden'>
	
 <tr><td colspan='4' class='BLANKROW'>&nbsp;</td></tr>
	<tr>
	<td class=label align=right width='20%'><fmt:message key="eOP.ProcedureUnitType.label" bundle="${op_labels}"/>&nbsp;&nbsp;</td>
	<td align=left class=label id=td1 width='30%'></td>
	<td class=label align=right width='20%'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td align=left class=label id=td2 width='30%'></td>
	</tr>
	<tr><td colspan='4'  class='BLANKROW'>&nbsp;</td></tr> 

	<tr>
		<td class=label align=right><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align=left class=label id=td3></td>
		<td class=label align=right><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align=left class=label id=td4></td>
	</tr>
<tr><td colspan='4'  class='BLANKROW'>&nbsp;</td></tr>
	<tr>
		<td class=label align=right><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align=left class=label id=td6></td>
		<td>&nbsp;&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
<input type=hidden name=called_from value='<%=called_from%>'>
<input type=hidden name=facility_id value='<%=facility_id%>'>
<input type=hidden name=dept_code value=''>
</form>
<%
}
catch ( Exception e ){out.println(e.toString());}
finally{
		if ( stmt != null ) stmt.close() ;
		if ( rs != null ) rs.close() ;
		ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>

