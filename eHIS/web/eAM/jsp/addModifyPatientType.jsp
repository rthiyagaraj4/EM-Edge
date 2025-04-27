<!DOCTYPE html>
<%--
	FileName	:addModifyPatientType.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
 <html>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'> </script>
<script src='../../eAM/js/PatientType.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String longdes="";
	String shortdes="";
	String en="";
	String fnval="insert";
	String stat="",stat1="";
	String chk="checked";
	String patient=request.getParameter("patient_type");
	try
	{
      con = ConnectionManager.getConnection(request);
	if(patient!=null )
	{
		fnval="modify";
		pstmt=con.prepareStatement("select * from am_patient_type where patient_type=?");
		pstmt.setString(1,patient);
		rset=pstmt.executeQuery();
		rset.next();
		longdes=rset.getString("long_desc");
		shortdes=rset.getString("short_desc");
		en=rset.getString("eff_status");
		if(fnval.equals("modify") && en.equals("D"))
			{chk="";stat1="READONLY";}
}
	if(patient==null)
		patient="";
%>
	</head>
	<body  OnMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown = 'lockKey()'>
		<form name='patient_form' id='patient_form' action='../../servlet/eAM.PatientTypeServlet' method='post' target='messageFrame'>
			<div >
			<br><br><br><br><br><br><br><br><br><br>

		<table border='0' cellpadding='0' cellspacing='0' align='center' width='auto' >

					<tr>
						<td width='10%'>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td width='10%'>&nbsp;</td>
					</tr>

    				<tr>
    					<td>&nbsp;</td>
    				     <td class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
    				     <td  class='fields'><!--colspan='2'-->&nbsp;&nbsp;
    				     <%if(fnval.equals("modify"))
    				     { stat="readonly";   }
    				     out.print("<input type='text' name='patient_type' id='patient_type' SIZE='4' maxlength='4'  onKeyPress='return CheckForSpecChars(event)'  value='"+patient+"' "+ stat+" onBlur=ChangeUpperCase(this)>");
    				     %>
    				    <img align='center' src='../../eCommon/images/mandatory.gif'>
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
				    <td>&nbsp;</td>
    				     <td  class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
    				     <td  class='fields' ><!--colspan='2'-->&nbsp;&nbsp;
    				     <input type='text' onBlur="makeValidString(this)" name='long_desc' id='long_desc' SIZE='30' maxlength='30' value="<%=longdes%>" <%out.print(stat1);%>>&nbsp<img  align='center'  src='../../eCommon/images/mandatory.gif'>
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
			    	<td>&nbsp;</td>
    				     <td  class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
    				     <td  class='fields' ><!--colspan='2'-->&nbsp;&nbsp;
    				     <input type='text'  onBlur="makeValidString(this)" name='short_desc' id='short_desc' value="<%=shortdes%>" SIZE='15' maxlength='15' <%out.print(stat1);%>> <img  align='centre'  src='../../eCommon/images/mandatory.gif' >
    				    </td>
    				    <td>&nbsp;</td>
			   	 </tr>

					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

    				     <% }
    				    	  catch(Exception e){e.printStackTrace();}
    				    	  finally
    				    	  {
    				    	  if(rset!=null)	rset.close();
							  if(stmt!=null)	stmt.close();
    				    	  if(pstmt!=null)	pstmt.close();
    				    	  ConnectionManager.returnConnection(con,request);
    				    	  }%>

    				     </td>
    			</tr>

      			<tr>
      				<td>&nbsp;</td>
				    <td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				    <td class='fields' ><!--colspan='2'-->&nbsp;
				    <input type='checkbox' name='eff_status' id='eff_status' value='E' <%out.print(chk);%>></td>
				    <td>&nbsp;</td>
    			</tr>

					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

  			</table>

  			</td>
  			</tr>
  			</table>

  		</div>
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>

		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
	</form>
</body>
</html>

