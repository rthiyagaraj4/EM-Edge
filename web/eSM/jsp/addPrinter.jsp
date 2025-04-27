<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<script src='../../eCommon/js/common.js' language='javascript'></script>

<html>
<head>
   <%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onLoad="FocusFirstElement()";>
<%

Connection con=null;
Statement stmt = null;
			try{
	        request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	ResultSet rs =null;
%>
<form name='printer_form' id='printer_form' action='../../servlet/eSM.PrinterServlet' method='post' target='messageFrame'>
<div>
<br><br><br><br><br><br><br>
  <table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
  <tr>
  	<td width='25%'>&nbsp;</td>
  	<td width='25%'>&nbsp;</td>
  	<td width='25%'>&nbsp;</td>
  	<td width='25%'>&nbsp;</td>
  </tr>
    <tr>
      <td class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
      <td class='fields' colspan='2'><input type='text' name='printer_id' id='printer_id' size='20' maxlength='20'onKeyPress="return CheckForSpecChars(event)" onBlur='ChangeUpperCase(this)';>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
      <td>&nbsp;</td>
    </tr>
    <tr>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
   </tr>
    <tr>
      <td class='label'><fmt:message key="eSM.PrinterName.label" bundle="${sm_labels}"/></td>
      <td class='fields' colspan='2'><input type='text' name='printer_name' id='printer_name' size='60' onBlur="makeValidString(this)" maxlength='60' >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
   </tr>
    <tr>
      <td class='label'><fmt:message key="eSM.QueueName.label" bundle="${sm_labels}"/></td>
      <td class='fields' colspan="2"><input type='text' name='queue_name' id='queue_name' size='60' onBlur="makeValidString(this)" maxlength='60'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
   </tr>
    <tr>
	  <td  class='label'><fmt:message key="eSM.PrinterType.label" bundle="${sm_labels}"/></td>
	  <td class='fields' colspan='2'>
	  <select name='printer_type' id='printer_type'>
	      <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
	      <option value ='S'><fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/> &nbsp;
	      <option value ='D'><fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/> &nbsp;
	      <option value ='I'><fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/> &nbsp;
	      <option value ='L'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>
	      <option value ='B'><fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/> &nbsp;

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

     <tr>
   	  <td class='label' nowrap><fmt:message key="eSM.ReportService.label" bundle="${sm_labels}"/></td>
   	  <td class='fields' colspan='2'>
   	  <select name='report_service' id='report_service'>
   	      <option value =''>-------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------
   	<%
   		String sql1="Select REPORT_SERVICE_ID,REPORT_SERVICE_NAME  from sm_report_service where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by report_service_name ";

  	      rs = stmt.executeQuery(sql1);

   	      if( rs != null )
   	      {
   	          while( rs.next() )
   	          {
   			String reportserviceid = rs.getString( "REPORT_SERVICE_ID" ) ;
   			String reportservicename=rs.getString( "REPORT_SERVICE_NAME");
   	%>
   			<OPTION VALUE='<%= reportserviceid %>'><%=reportservicename%>

   	<%
   	          }
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
   	      }
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


    <input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10'   onblur='CheckDate(this)' maxlength='10'>
       <input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10'  onblur='CheckDate(this)' maxlength='10'>
	<tr>
	<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      <td class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E' checked>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
</tr>
  </table>

</div>
<input type='hidden' name='function' id='function' value='insert'>
<input type='hidden' name='eff_date_from' id='eff_date_from' >
<input type='hidden' name='eff_date_to' id='eff_date_to' >
<input type='hidden' name='function_name' id='function_name' value='insert'>

</form>

</body>
</html>
<%
}catch(Exception e){//out.println(e);
	e.printStackTrace();
}
			finally {
				
	ConnectionManager.returnConnection(con,request);
}	
%>

