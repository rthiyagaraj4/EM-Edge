<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%! String reportgroupid;String longdesc;String shortdesc;String effdatefrom;String effdateto;String effstatus;String reportserviceid;String dfltprinterid;int dfltnoofcopies;%>
<% reportgroupid = request.getParameter("reportgroup_id");
	Connection conn=null;
	try{
		  request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);

	Statement stmt =conn.createStatement();
	ResultSet rset=null;
	ResultSet rs=null;

try{
	%>
<script>

function checkFields1( fields, names, messageFrame) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	{
		     msg=getMessage("CAN_NOT_BE_BLANK",'Common');
			 msg.replace('$',names[i])
//			errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			errors = errors + msg + "<br>" ;
		}
	}
	if ( errors.length != 0 ) {

		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
		return false ;
	}
	return true ;
}

function ChkNumberInput1(fld, e)
{
   var strCheck = '0123456789';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

</script>

	
	<html><head><%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body  onMouseDown='CodeArrest()';onKeyDown = 'lockKey()';  onload='FocusFirstElement()'>

	</head><body OnMouseDown='CodeArrest()'; onKeyDown = 'lockKey()'; >
<%
	String sql = "select report_group_id,report_service_id,long_desc,short_desc,eff_date_from,eff_date_to,eff_status,dflt_printer_id,dflt_no_of_copies from sm_report_group where report_group_id='"+reportgroupid+"'";
	rset = stmt.executeQuery(sql);
	if(rset != null) {
		rset.next();
		reportgroupid = rset.getString("report_group_id");
		longdesc = rset.getString("long_desc");
		shortdesc = rset.getString("short_desc");
		dfltprinterid = rset.getString("dflt_printer_id")==null ? "" : rset.getString("dflt_printer_id");
		dfltnoofcopies = rset.getInt("dflt_no_of_copies");
		if(rset.getString("eff_date_from")==null) {
			effdatefrom = "" ;
		}
		else {
			String temp = rset.getString("eff_date_from");
			effdatefrom = temp.substring(8,10)+ "/" + temp.substring(5,7) + "/" + temp.substring(0,4);
		}
		if(rset.getString("eff_date_to")==null) {
			effdateto = "";
		}
		else {
			String temp1 = rset.getString("eff_date_to");
			effdateto = temp1.substring(8,10)+ "/" + temp1.substring(5,7) + "/" + temp1.substring(0,4);
		}
		effstatus = rset.getString("eff_status");
		reportserviceid = rset.getString("report_service_id");

		if ( reportserviceid == null ) reportserviceid = "" ;
	}
	if(rset != null) rset.close();
	%>
	<form name='reportgroup_form' id='reportgroup_form' action='../../servlet/eSM.ReportGroupServlet' method='post' target='messageFrame'>
	<div><br><br><br><br><br><br><br>
	<%
		if ( effstatus.equals("E") )
		{
	%>
		<table border='0' cellpadding='0' cellspacing='0' width='auto' width='90%' align='center'>
		<TR>
			<td width='10%'>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td width='10%'>&nbsp;</td>
		</TR>
		<tr>
			<td>&nbsp;</td>
			<td class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='2'>
			 <input type='text' name='id' id='id' value='<%=reportgroupid%>' size='10' maxlength='8' readonly >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>	</td>
			<td>&nbsp;</td>
		</tr>

		<TR>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</TR>
		<tr>
			<td>&nbsp;</td>
			<td class='label'><!--width='40%'--><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' onBlur='makeValidString(this);'  maxlength='30' value='<%=longdesc%>'>
			<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td>&nbsp;</td>
		</tr>
		<TR>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</TR>
		<tr>
				<td>&nbsp;</td>
				<td  nowrap class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td colspan='2' class='fields'><!--width='60%'--><input type='text' onBlur='makeValidString(this);'   name='short_desc' id='short_desc' size='15' maxlength='15' value='<%=shortdesc %>'>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td>&nbsp;</td>
		</tr>
	<%
        rs = stmt.executeQuery("Select Printer_Id,printer_name from sm_printer where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by printer_name ");
	%>	
		<TR>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</TR>
		<tr>
			<td>&nbsp;</td>
			<td class='label'><!--width='40%'--><fmt:message key="eSM.DefaultPrinter.label" bundle="${sm_labels}"/></td>
			<td class='fields' colspan='3'><!--width='60%'--><select name='Dflt_Printer_Id' id='Dflt_Printer_Id'>

			<option value=''>&nbsp;------- ------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------- -------&nbsp;
		<%
      	if( rs != null )
      	{
			while(rs.next()) {
			String printerid = rs.getString( "Printer_Id" )==null ? "" :  rs.getString( "Printer_Id" );
			String printername = rs.getString( "Printer_Name" )== null ? "" : rs.getString( "Printer_Name" );

			if(dfltprinterid.equals(printerid))
				{%>
			    <option value='<%=printerid%>' selected>	<%=printername%>
			<%}
			 else
				{%>
					<option value='<%=printerid%>'><%=printername%>
				<%}
		}
	 }

	 %>
		</select>&nbsp;</td>
		</tr>
		<TR>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			 <td>&nbsp;</td>
		 </TR>
		 
		<tr>
			<td>&nbsp;</td>
			<td class='label'><!--width='40%'--><fmt:message key="eSM.NumberofCopies.label" bundle="${sm_labels}"/></td>
			<td class='fields' colspan='2'><!--width='60%'--><input type='text' name='Dflt_No_Of_Copies' id='Dflt_No_Of_Copies' value='<%=dfltnoofcopies%>' size='2' maxlength='2' onblur='CheckNum(this)' onKeyPress="return ChkNumberInput1(this,event)">
		</td>
			<td>&nbsp;</td>
		</tr>
		<TR>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
		</TR>
	
   
		<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' onblur='CheckDate(this)'  value='<%=effdatefrom%>' >
	
		<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  onblur='CheckDate(this)'  value='<%=effdateto%>'>

		<tr>
			<td>&nbsp;</td>
			<td class='label'><!--width='40%'--><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='2'><!--width='60%'--><input type='checkbox' name='eff_status' id='eff_status' value='E'
		<%
	if  ( effstatus.equals("E") )
	{%>
		checked >&nbsp;
	<%}
	else{%>
		>&nbsp;
	<%}%>
		</td>
		<td>&nbsp;</td>
	</tr>
	<TR>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		</TR> 
</table>
</div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>
<%}
else if ( effstatus.equals("D") )
{%>


		<table border='0' cellpadding='0' cellspacing='0' width='auto' width='90%' align='center'>
		<TR>
			<td width='10%'>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td width='10%'>&nbsp;</td>
		</TR>
		<tr>
			<td>&nbsp;</td>
			<td class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='2'>
			 <input type='text' name='id' id='id' value='<%=reportgroupid%>' size='10' maxlength='8' readonly >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>	</td>
			<td>&nbsp;</td>
		</tr>

		<TR>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</TR>
		<tr>
			<td>&nbsp;</td>
			<td class='label'><!--width='40%'--><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' onBlur='makeValidString(this);'  maxlength='30' value='<%=longdesc%>' readonly>
			<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td>&nbsp;</td>
		</tr>
		<TR>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</TR>
		<tr>
				<td>&nbsp;</td>
				<td  nowrap class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td colspan='2' class='fields'><!--width='60%'--><input type='text' onBlur='makeValidString(this);'   name='short_desc' id='short_desc' size='15' maxlength='15' value='<%=shortdesc %>' readonly>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td>&nbsp;</td>
		</tr>

	
	<%
		if(rs != null) rs.close();
        rs = stmt.executeQuery("Select Printer_Name  from sm_printer where printer_id='" + dfltprinterid + "'");
        String printername="";
	if(rs.next()) printername = rs.getString("printer_name");
	%>
		<TR>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</TR>
		<tr>
			<td>&nbsp;</td>
			<td class='label'><!--width='40%'--><fmt:message key="eSM.DefaultPrinter.label" bundle="${sm_labels}"/></td>

			<td class='fields' colspan='3'><input type='text' size='60' name='Dflt_Printer_Id1' id='Dflt_Printer_Id1' value='<%=printername%>'
	readonly>&nbsp;<input type='hidden' name='Dflt_Printer_Id' id='Dflt_Printer_Id'  value='<%=dfltprinterid%>'></td>
	</tr>
	
	<TR>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</TR>
	<tr>
		<td>&nbsp;</td>
		<td class='label'><fmt:message key="eSM.NumberofCopies.label" bundle="${sm_labels}"/></td>
		<td class='fields' colspan='2'><input type='text' size='2' name='Dflt_No_Of_Copies' id='Dflt_No_Of_Copies' value='<%=dfltnoofcopies%>'
	readonly>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<TR>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</TR>
	
   
   <input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' onblur='CheckDate(this)'  value='<%=effdatefrom%>' readonly>
	
	
	<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  onblur='CheckDate(this)'  value='<%=effdateto%>' readonly>
	
		<tr>
			<td>&nbsp;</td>
			<td class='label'><!--width='40%'--><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='2'><!--width='60%'--><input type='checkbox' name='eff_status' id='eff_status' value='E'
		<%
	if  ( effstatus.equals("E") )
	{%>
		checked >&nbsp;
	<%}
	else{%>
		>&nbsp;
	<%}%>
		</td>
		<td>&nbsp;</td>
	</tr>
	<TR>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		</TR> 
</table>
</div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>
	<%
}	if(rs != null) rs.close();
	if(stmt != null) stmt.close();	
}
catch ( Exception e )
{
	out.println( e.getMessage() ) ;
}

%>
</body>
</html>
<%
}catch(Exception e){out.println(e);}
finally { 
			ConnectionManager.returnConnection(conn,request);
		}	
%>

