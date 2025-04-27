<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

      <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eAM/js/Grade.js' language='javascript'></script>
		
		
      	
     

      </head>

      <body OnMouseDown='CodeArrest()' onLoad="FocusFirstElement();" onKeyDown = 'lockKey()'>
<%
   request.setCharacterEncoding("UTF-8");

   String longdesc="",shortdesc="",effstatus="",codeTextAttribute="",otherTextAttribute="",otherAttribute="",checkBoxAttribute="",eventFunctionForCase="",sql="";
   boolean newSpeciality		=	false;
  
%>
<%
	String gradecode=request.getParameter("grade_code");
	if(gradecode==null){
		gradecode				=	"";
		longdesc				=	"";
		shortdesc				=	"";
		effstatus				=	"E";		
		checkBoxAttribute		=	"CHECKED";
		codeTextAttribute		=	"";
		otherTextAttribute		=	"";	
		newSpeciality			=	true;
		eventFunctionForCase	=	"OnBlur='ChangeUpperCase(this)'";
	}else{
		Connection conn			=	null;
	    java.sql.Statement stmt	=	null;
	    ResultSet rset			=	null;
     try{
		conn = ConnectionManager.getConnection(request);

		stmt = conn.createStatement();
		sql =  "select grade_code,long_desc,short_desc,eff_status  from am_grade where grade_code='"+gradecode+"'";
		
		rset = stmt.executeQuery(sql);
		rset.next();
		gradecode				=	rset.getString("grade_code");
		longdesc				=	rset.getString("long_desc");
		shortdesc				=	rset.getString("short_desc");		
		effstatus				=rset.getString("eff_status");
		if(effstatus.equals("D"))
		{
			otherTextAttribute	=	"READONLY";
			checkBoxAttribute	=	"";					
		}else{

			otherTextAttribute		=	"";
			checkBoxAttribute		=	"CHECKED";
			otherAttribute			=	"";	
		}
	 }catch(Exception e){
			e.toString();
	 }
	 finally
	 {     
		    if(rset!=null)    	rset.close();	 
	     	if(stmt!=null)    	stmt.close();
	     	ConnectionManager.returnConnection(conn,request);	
	 }
		codeTextAttribute	=	"READONLY";	
		eventFunctionForCase=	"";
	}
%>

      	<form name='grade_form' id='grade_form' action='../../servlet/eAM.GradeServlet' method='post' target='messageFrame'>
      	<div>
      	<br><br><br><br><br><br><br>
      	
      	<table border='0' cellpadding='0' cellspacing='0' width='auto' align="center">
      		<tr>
      			<td width='10%' class="label">&nbsp;</td> 
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
				<td width='10%' class="label">&nbsp;</td>
			</tr>
      		<tr>
      		    <td class="label">&nbsp;</td>
      		    <td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td class="fields">
      		    <input type='text'  onKeyPress="return CheckForSpecCharacs(event)" name='grade_code' id='grade_code' value="<%=gradecode%>" size='2' maxlength='2' <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
      		    <td class="label">&nbsp;</td>
      		</tr>
      		<tr class="label">
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
		    </tr>
      		<tr>
      		    <td class="label">&nbsp;</td>
      		    <td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class="fields">
      		    <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this)"  >
      		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
      		    <td class="label">&nbsp;</td>
      		</tr>
      		<tr class="label">
      		     <td class="label">&nbsp;</td>  
      		     <td class="label">&nbsp;</td>
			     <td class="label">&nbsp;</td>
			     <td class="label">&nbsp;</td>
		    </tr>
      		<tr>
      		    <td class="label">&nbsp;</td> 
      		    <td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		        <td class="fields">
		        <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this)" >
		        <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		        <td class="label">&nbsp;</td>
      		</tr>
      		<tr class="label">
      			<td class="label">&nbsp;</td>
      			<td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
		</tr>
      		      	
      		<tr>
      		     <td class="label">&nbsp;</td>	 
      		     <td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class="fields">
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="Change1()"></td>
      		     <td class="label">&nbsp;</td>
      		</tr>
      		<tr class="label">
      			<td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
		    </tr>
      	</table>
      	</div>
		 <%  if(newSpeciality){%>
      		<input type='hidden' name='function' id='function' value='insert'>
      		<input type='hidden' name='function_name' id='function_name' value='insert'>
      <%}else{%>
      		<input type='hidden' name='function' id='function' value='modify'>
      		<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
      		<input type='hidden' name='eff_date_from' id='eff_date_from' >
      		<input type='hidden' name='eff_date_to' id='eff_date_to' >
   
      		
      	</form>
      	</body>
      	</html>

