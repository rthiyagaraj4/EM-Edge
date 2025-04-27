<!DOCTYPE html>

<%--
	FileName	: addAmbulatoryStatus.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

      <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eAM/js/AmbulatoryStatus.js' language='javascript'></script>

      	
      </head>

      <body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()'  onKeyDown = 'lockKey()'>

	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String ambulatory_status="";
		String longdesc="";
		String shortdesc="";
		//String effdatefrom="";
		//String effdateto="";
		String effstatus="";
		String codeTextAttribute="";
		String otherTextAttribute="";
		String checkBoxAttribute="";
		String eventFunctionForCase="";
		boolean newAmbulatoryStatus=false;
	%>
	<%
		ambulatory_status=request.getParameter("ambulatory_status");
		if(ambulatory_status==null){
			ambulatory_status="";
			longdesc="";
			shortdesc="";
		//	effdatefrom="";
		//	effdateto="";
			effstatus="E";
			codeTextAttribute="";
			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
			newAmbulatoryStatus=true;
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
		}else{
			Connection conn = ConnectionManager.getConnection(request);
			Statement stmt=null;
			PreparedStatement pstmt = null;
			ResultSet rset=null;
			try{

				stmt = conn.createStatement();
				String sql = "select ambulatory_status,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from am_ambulatory_status where ambulatory_status=?";
				
				
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	ambulatory_status);
				rset		 = pstmt.executeQuery();
				
				rset.next();
				ambulatory_status=rset.getString("ambulatory_status");
				longdesc=rset.getString("long_desc");
				shortdesc=rset.getString("short_desc");
				effstatus=rset.getString("eff_status");

				if(effstatus.equals("D"))
				{
					otherTextAttribute="READONLY";
					checkBoxAttribute="";

				}else
				{

					otherTextAttribute="";
					checkBoxAttribute="CHECKED";
				}
					if (rset!= null) rset.close();
					if (stmt != null) stmt.close();
			}catch(Exception e){

					   }
			finally {
					
					ConnectionManager.returnConnection(conn,request);
				}

					codeTextAttribute="READONLY";
					newAmbulatoryStatus=false;
					eventFunctionForCase="";
				}

	%>

<form name='ambulatorystatus_form' id='ambulatorystatus_form' action='../../servlet/eAM.AmbulatoryStatusServlet' method='post' target='messageFrame'>
      	<div align='left'><!--align='left'-->
      	<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>

      	<table border='0' cellpadding='0' cellspacing='0'  align='center' style="position:absolute;top:30%;left:25%;" width='auto'><!--width='100%'-->
		<tr>
				<td width='10%'>&nbsp;</td>
      			<td>&nbsp;</td>
      			<td>&nbsp;</td>
		      	<td width='10%'>&nbsp;</td>
      	</tr>

      		<tr>
	      		<td>&nbsp;</td>
      		    <td   class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td><!--width='40%'-->
      		    <td class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2'-->
      		    <input type='text' name='ambulatory_status' id='ambulatory_status'  onBlur="makeValidString(this);changeCase(this)" onKeyPress="return CheckForSpecChars(event)"  value="<%=ambulatory_status%>" size='2' maxlength='2' <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
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
      		    <td   class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td><!--width='40%' -->
      		    <td class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2'-->
      		    <input type='text' onBlur="makeValidString(this)"  name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> >
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
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
      		<td   class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td><!--width='40%'-->
		    <td class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2'-->
		    <input type='text'  onBlur="makeValidString(this)" name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> >
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
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
		     <td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><!--width='40%' -->
		     <td   class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2'-->
		      	<input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
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
<%  if(newAmbulatoryStatus){%>

<input type='hidden' name='function' id='function' value='insert'>
<input type='hidden' name='function_name' id='function_name' value='insert'>

<%}else{%>

<input type='hidden' name='function' id='function' value='modify'>
<input type='hidden' name='function_name' id='function_name' value='modify'>
 <%}%>

</form>
</body>
</html>

