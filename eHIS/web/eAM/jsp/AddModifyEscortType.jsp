<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
/*
*
*	Application		:	eAM
*   File Name       :	AddModifyEscortType.jsp
*	
*
*	Created On		:	19-02-2005
*/
%>	
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>


<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'> </script>
<script src='../../eAM/js/EscortType.js' language='javascript'></script>
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
//	String dat="";
	//String escorttype="";
	String longdes="";
	String shortdes="";
	String en="";
	String fnval="insert";
	//SimpleDateFormat formatter=null;
	String stat="",stat1="";
	String chk="checked";
	String escort=request.getParameter("escort_type");
	try
	{
     con = ConnectionManager.getConnection(request);
	if(escort!=null )
	{
		fnval="modify";
		pstmt=con.prepareStatement("select * from am_escort_type where escort_type_code=?");
		pstmt.setString(1,escort);
		rset=pstmt.executeQuery();
		rset.next();
		longdes=rset.getString("long_desc");
		shortdes=rset.getString("short_desc");
		en=rset.getString("eff_status");
		if(fnval.equals("modify") && en.equals("D"))
			{chk="";stat1="READONLY";}
}
	if(escort==null)
		escort="";
%>
	</head>
	<body  OnMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown = 'lockKey()'>
		<form name='escort_form' id='escort_form' action='../../servlet/eAM.EscortTypeServlet' method='post' target='messageFrame'>
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
    				     <td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
    				     <td  class='fields' ><!--colspan='2'-->&nbsp;&nbsp;
    				     <%if(fnval.equals("modify"))
    				     { stat="readonly";   }
    				     out.print("<input type='text' name='escort_type' id='escort_type' SIZE='10' maxlength='10'  onKeyPress='return CheckForSpecChars(event)'  value='"+escort+"' "+ stat+" onBlur=ChangeUpperCase(this)>");
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
    				     <td   class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
    				     <td   class='fields' ><!--colspan='2'-->&nbsp;&nbsp;
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
    				     <td   class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
    				     <td   class='fields' ><!--colspan='2'-->&nbsp;&nbsp;
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
							 

    				     <% 
							 if(rset!=null)	rset.close();
							  if(stmt!=null)	stmt.close();
    				    	  if(pstmt!=null)	pstmt.close();
						 }
    				    	  catch(Exception e){e.printStackTrace();}
    				    	  finally
    				    	  {
    				    	 
    				    	  ConnectionManager.returnConnection(con,request);
    				    	  }%>

    				     </td>
    			</tr>

      			<tr>
      				<td>&nbsp;</td>
				    <td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				    <td  class='fields' ><!--colspan='2'-->&nbsp;
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

