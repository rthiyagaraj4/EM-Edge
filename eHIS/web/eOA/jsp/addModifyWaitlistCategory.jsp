<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eOA/js/WaitlistCategory.js' language='javascript'></script>
    <script>
	
      	function FocusFirstElement()
		{
		  waitlist_form.waitlist_code.focus();
		}
		function Change1(){
      	 if (waitlist_form.eff_status.checked == true)
	      	 	waitlist_form.eff_status.value	=	"E";
	      	 else
      		    waitlist_form.eff_status.value	=	"D";     	      	
      	}    

     </script>
      	

      </head>

      <body OnMouseDown='CodeArrest()' onLoad="FocusFirstElement();" onKeyDown = 'lockKey()'>
<%
   String code			=	"";
   String longdesc				=	"";
   String shortdesc				=	"";
   String effstatus				=	"";
   String codeTextAttribute		=	"";
   String otherTextAttribute	=	"";
   String checkBoxAttribute		=	"";
   String eventFunctionForCase	=	"";
   String sql					=	""; 
   boolean newCode		=	false;
  
%>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	code=request.getParameter("code");
	if((code=="") || (code==null)){
		
		code				=	"";
		longdesc				=	"";
		shortdesc				=	"";
		effstatus				=	"E";
		codeTextAttribute		=	"";
		otherTextAttribute		=	"";
		checkBoxAttribute		=	"CHECKED";
		newCode			        =	true;
		eventFunctionForCase	=	"OnBlur='ChangeUpperCase(this)'";
	}else{
		
		Connection conn			=	null;
	    java.sql.Statement stmt	=	null;
		PreparedStatement pstmt=null;
	    ResultSet rset			=	null;
     try{
		conn = ConnectionManager.getConnection(request);

		stmt = conn.createStatement();
	//	sql =  "select WAITLIST_CATEGORY_CODE,LONG_DESC,SHORT_DESC,EFF_STATUS from OA_WAITLIST_CATEGORY where WAITLIST_CATEGORY_CODE='"+code+"'"; 
		sql =  "select WAITLIST_CATEGORY_CODE,LONG_DESC,SHORT_DESC,EFF_STATUS from OA_WAITLIST_CATEGORY where WAITLIST_CATEGORY_CODE=?"; 
		
		//rset = stmt.executeQuery(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,code);
		rset = pstmt.executeQuery();
		rset.next();
		code				=	rset.getString("WAITLIST_CATEGORY_CODE");
		longdesc				=	rset.getString("long_desc");
		shortdesc				=	rset.getString("short_desc");
		
	
		effstatus=rset.getString("eff_status");
		if(effstatus.equals("D"))
		{
			otherTextAttribute	=	"READONLY";
			checkBoxAttribute	=	"";

		}else{

			otherTextAttribute		=	"";
			checkBoxAttribute		=	"CHECKED";
		}
	 }catch(Exception e){
			//e.toString();
			e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	 }
	 finally
	 {     
		    if(rset!=null)    	rset.close();	 
	     	if(stmt!=null)    	stmt.close();
	     	ConnectionManager.returnConnection(conn,request);	
	 }
		codeTextAttribute	=	"READONLY";
		newCode		=	false;
		eventFunctionForCase=	"";
	}
%>

      	<form name='waitlist_form' id='waitlist_form' action='../../servlet/eOA.WaitlistCategoryServlet' method='post' target='messageFrame'>
      	<div>
      	<br><br><br><br><br><br><br>
      	
      	<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
      		<tr>
      			<td>&nbsp;</td> 
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

      		<tr>
      		    <td>&nbsp;</td>
      		 
				<td  class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>

      		    <td class='fields'><input type='text'  onKeyPress="return CheckForSpecChars(event)"  name='waitlist_code' id='waitlist_code' value="<%=code%>" size='4' maxlength='4'  <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

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

      		    <td    class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>

      		    <td class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this)"  >
      		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

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

      		    <td class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>

		        <td class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this)" >
		        <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

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
				 
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

      		     <td  class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="Change1()"></td>

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
    <%  
	
	if(newCode){%>
      		<input type='hidden' name='function' id='function' value='insert'>
      		<input type='hidden' name='function_name' id='function_name' value='insert'>
      <%}else{%>
      		<input type='hidden' name='function' id='function' value='modify'>
      		<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
      		
      	</form>
      	</body>
      	</html>

