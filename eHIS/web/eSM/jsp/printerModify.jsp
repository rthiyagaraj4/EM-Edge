<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%! String printerid;String printername;String queuename;String effdatefrom;String effdateto;String effstatus;String printertype;String reportservice;%>
<% printerid = request.getParameter("printer_id"); %>
<html>
	<head>
	<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="JavaScript"> 
		function check(obj) {
		if (printer_form.eff_status.checked){
			printer_form.printer_type.disabled = false;
			printer_form.report_service.disabled = false;
		}else{
			printer_form.printer_type.disabled=true;
			printer_form.report_service.disabled =true; 
		}
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown = 'lockKey()'; OnMouseDown="CodeArrest()" onload='FocusFirstElement()'>
<%

Connection conn=null;
Statement stmt = null;
			try{
			request.setCharacterEncoding("UTF-8");
			conn = ConnectionManager.getConnection(request);
	
	ResultSet rset;
	ResultSet rs;
	String sel="";
	stmt = conn.createStatement();
	String sql = "select printer_id,printer_type,printer_name,queue_name,eff_date_from,eff_date_to,eff_status,REPORT_SERVICE_ID from sm_printer where printer_id='"+printerid+"'";
	rset = stmt.executeQuery(sql);
	if(rset != null) {
		rset.next();
		printerid = rset.getString("printer_id");
		printername = rset.getString("printer_name");
		queuename = rset.getString("queue_name");
		printertype=rset.getString("printer_type");
		reportservice=rset.getString("REPORT_SERVICE_ID");
		if(reportservice == null)
			reportservice="";

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
		printertype = rset.getString("printer_type");
	}
	if(rset != null) rset.close();
	//if(stmt != null) stmt.close();
%>
	<form onLoad = 'check(this)' name='printer_form' id='printer_form' action='../../servlet/eSM.PrinterServlet' method='post' target='messageFrame'> 
		<div><br><br><br><br><br><br><br>
			<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
				<tr>
					<td width='25%'>&nbsp;</td>
					<td width='25%'>&nbsp;</td>
					<td width='25%'>&nbsp;</td>
					<td width='25%'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
					<td colspan='2'><input type='text' name='printer_id' id='printer_id' value='<%=printerid%>' size='20' readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
<%
	if ( effstatus.equals("E") )
	{
%>	

		</td><td>&nbsp;</td></tr>
		<TR><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></TR>
		<tr>
		<td class='label' nowrap><fmt:message key="eSM.PrinterName.label" bundle="${sm_labels}"/></td>
		<td colspan='2' nowrap><input type='text' name='printer_name' id='printer_name' size='60'  onBlur='makeValidString(this)'  maxlength='60' value='<%=printername%>'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>	</td>
		<td>&nbsp;</td>
		</tr>
		<TR>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		</TR>
		<tr>
		<td class='label'><fmt:message key="eSM.QueueName.label" bundle="${sm_labels}"/></td>
		<td colspan='2' nowrap><input type='text' name='queue_name' id='queue_name' size='60'  onBlur='makeValidString(this)'  maxlength='60' value='<%=queuename%>'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
		<td>&nbsp;</td>
		</tr>
		
		<TR>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		</TR>
		<tr>
		<td class='label'><fmt:message key="eSM.PrinterType.label" bundle="${sm_labels}"/></td>
		<td colspan='2'><select name='printer_type' id='printer_type'>
<%
	      	if(printertype.equals("S")||printertype==null)
	      	{
			%>
	      		<option value='S'><fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='D'><fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='I'><fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>
				<option value='B'><fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;
		<%}

		else if(printertype.equals("D"))
	      	{%>
	      		<option value='D'><fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='S'><fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='I'><fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>
				<option value='B'><fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;
		<%}
		else if(printertype.equals("I"))
	      	{%>
	      		<option value='I'><fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='S'><fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='D'><fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>
				<option value='B'><fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;
		<%}
		else if(printertype.equals("L"))
	      	{%>

	      		<option value='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>
	      		<option value='S'><fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='D'><fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='I'><fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='B'><fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;
		<%}
		else if(printertype.equals("B"))
	      	{%>

	      		<option value='B'>&nbsp;<fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='S'>&nbsp;<fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='D'>&nbsp;<fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='I'>&nbsp;<fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      		<option value='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>

		<%}%>



		</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		<td>&nbsp;</td>
		</tr>
		<TR>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		</TR>

		<tr>
			   	  <td class='label' nowrap><fmt:message key="eSM.ReportService.label" bundle="${sm_labels}"/></td>
			   	  <td colspan='2'>
			   	  <select name='report_service' id='report_service'>
			   	      <option value =''>&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----&nbsp;
			   	<%
			   		String sql1="Select REPORT_SERVICE_ID,REPORT_SERVICE_NAME  from sm_report_service where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by report_service_name ";

			  	      rs = stmt.executeQuery(sql1);

			   	      if( rs != null )
			   	      {
			   	          while( rs.next() )
			   	          {
			   			String reportserviceid = rs.getString( "REPORT_SERVICE_ID" ) ;
			   			if(reportservice.equals(reportserviceid))
			   				sel="SELECTED";
			   			else
			   				sel="";
			   			String reportservicename=rs.getString( "REPORT_SERVICE_NAME");
			   	%>
			   			<OPTION VALUE="<%= reportserviceid %>" <%=sel%>><%=reportservicename%>

			   	<%
			   	          }
			   	      }
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
			   	%>
						</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
			   	  </td>
			   	  <td>&nbsp;</td>
			       </tr>
			       <tr>
			       	<td>&nbsp;</td>
			       	<td>&nbsp;</td>
			       	<td>&nbsp;</td>
			       	<td>&nbsp;</td>
			   </tr>


		
		<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' onblur='CheckDate(this)'  value='<%=effdatefrom%>' >
		
		<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  onblur='CheckDate(this)'  value='<%=effdateto%>'>

		<tr ><td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><td class='fields'  colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
		<%
		if  ( effstatus.equals("E") )
		{%>
			checked >&nbsp;
		<%}
	else{
		%>
		>&nbsp;
		<%}%>
	</td><td>&nbsp;</td></tr>
	<TR><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></TR> 
	</table>
	</div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>
<%}
if ( effstatus.equals("D") )
{%>
	</td><td>&nbsp;</td></tr>
	<TR><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></TR>
	<tr><td class='label' nowrap><fmt:message key="eSM.PrinterName.label" bundle="${sm_labels}"/></td>
	<td colspan='2' nowrap>&nbsp;<input type='text' name='printer_name' id='printer_name' size='60' maxlength='60' onBlur='makeValidString(this)' value='<%=printername%>' readonly>&nbsp;
	<img src='../../eCommon/images/mandatory.gif'></img></td>
	<td>&nbsp;</td></tr>
	<TR><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></TR>
	<tr>
	<td class='label'><fmt:message key="eSM.QueueName.label" bundle="${sm_labels}"/></td>
	<td colspan='2' nowrap>&nbsp;<input type='text'  onBlur='makeValidString(this)'  name='queue_name' id='queue_name' size='60'  maxlength='60' value='<%=queuename%>' readonly >&nbsp;
	<img src='../../eCommon/images/mandatory.gif'></img></td>
	<td>&nbsp;</td>
	</tr>
	
	<TR><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></TR>
	<tr>
	<td class='label'><fmt:message key="eSM.PrinterType.label" bundle="${sm_labels}"/></td>
	<td colspan='2'>&nbsp;<select name='printer_type' id='printer_type' disabled>
<%
 	if(printertype.equals("S")||printertype==null)
	{%>
			<option value='S'><fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='D'><fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='I'><fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>
			<option value='B'><fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;
	<%}

	else if(printertype.equals("D"))
	{%>
	      	<option value='D'><fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='S'><fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='I'><fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>
			<option value='B'><fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;
	<%}
	else if(printertype.equals("I"))
	{%>
	      	<option value='I'><fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='S'><fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='D'><fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>
			<option value='B'><fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;
	<%}
	else if(printertype.equals("L"))
	 {%>

	      	<option value='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>
	      	<option value='S'><fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='D'><fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='I'><fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='B'><fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;
	<% }
	else if(printertype.equals("B"))
	 {%>

	      	<option value='B'><fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='S'><fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='D'><fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='I'><fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      	<option value='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>

	<% }%>

		</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
		<td>&nbsp;</td>
		</tr>
		<TR><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></TR>

<tr>	
	
	<td class='label' nowrap><fmt:message key="eSM.ReportService.label" bundle="${sm_labels}"/></td>
	<td colspan='2'>&nbsp;<select name='report_service' id='report_service' disabled>
	
	<%
			   		String sql1="Select REPORT_SERVICE_ID,REPORT_SERVICE_NAME  from sm_report_service where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by report_service_name ";

			  	      rs = stmt.executeQuery(sql1);

			   	      if( rs != null )
			   	      {
			   	          while( rs.next() )
			   	          {
			   			String reportserviceid = rs.getString( "REPORT_SERVICE_ID" ) ;
			   			if(reportservice.equals(reportserviceid))
			   				sel="SELECTED";
			   			else
			   				sel="";
			   			String reportservicename=rs.getString( "REPORT_SERVICE_NAME");
			   	%>
			   			<OPTION  Value= '<%=reportserviceid%>' <%=sel%>><%=reportservicename%>

			   	<%
			   	          }
			   	      }
				
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
			   	%>
			                 </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
			   	  </td>
			   	  <td>&nbsp;</td>
			       </tr>
			   <tr>
			       	<td>&nbsp;</td>
			       	<td>&nbsp;</td>
			       	<td>&nbsp;</td>
			       	<td>&nbsp;</td>
			   </tr>

	
	<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' onblur='CheckDate(this)'  value='<%=effdatefrom%>' readonly>
	
	<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  onblur='CheckDate(this)'  value='<%=effdateto%>' readonly>

	<tr>
	<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='label' colspan='2'>&nbsp;<input type='checkbox'  name='eff_status' id='eff_status' value='E' 
	<%
	if  ( effstatus.equals("E") )
	{%>
		checked >&nbsp;
	<%}

	else
		{%>
		>&nbsp;
		<%}%>
	</td>
	<td>&nbsp;</td>
	</tr>
	<TR><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
    </TR> 
	</table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>
<%}
%>
</body>
</html>
<%
}catch(Exception e){out.println(e);}
finally {				
			ConnectionManager.returnConnection(conn,request);
		}	
%>

