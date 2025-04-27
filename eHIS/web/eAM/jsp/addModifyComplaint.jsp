<!DOCTYPE html>
<%--
	FileName	: addModifyComplaint.jsp
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
      


      	<!-- Added by sri -->
      	<script>
      	function change() {
      	 if (complaint_form.eff_status.checked == true)
      	 	complaint_form.eff_status.value="E";
      	 else
      		complaint_form.eff_status.value="D";
      	}
      	
		function CheckMaxLen(lab,obj,max) {
		if(obj.value.length >= max) {
			return false;
		} else return true;

}

	function CheckMaxLength(Obj)
	{
		if(Obj.value.length >200){
			alert(getMessage("DESCRIPTION_CHECK_200","AM"));
			Obj.focus();
			}
	
	
	}
      	</script>
      	<!-- Added by sri ends here -->

      </head>

      <body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>


<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
   String code="";
   String desc="";
   //String Description="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   //String eventFunctionForDate="";
   boolean newcomplaint=false;
   String sql="";
%>
<%
	code=request.getParameter("complaint_code");
	if(code==null){
		code="";
		desc="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		newcomplaint=true;
		//eventFunctionForDate="OnBlur='CheckDate(this)'";
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
		   Connection conn = ConnectionManager.getConnection(request);
	       Statement stmt=null;
		   PreparedStatement pstmt = null;
	    	ResultSet rset=null;
     try{

		sql = "select complaint_code,complaint_desc,eff_status from am_complaint where complaint_code=?";
		pstmt   = conn.prepareStatement(sql);
		pstmt.setString	(	1,	code		);

		rset		 = pstmt.executeQuery();
		rset.next();
		code=rset.getString("complaint_code");
		desc=rset.getString("complaint_desc");

		//eventFunctionForDate="OnBlur='CheckDate(this)'";


		effstatus=rset.getString("eff_status");
		if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			checkBoxAttribute="";

		}else{

			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
		}
			if(rset!=null) 	rset.close();
	     	if(stmt!=null) 	stmt.close();
	     }catch(Exception e){
			e.toString();
	     }
	     finally{
			
	     	ConnectionManager.returnConnection(conn,request);
		 }
		codeTextAttribute="READONLY";
		newcomplaint=false;
		eventFunctionForCase="";
	}

%>

      	<form name='complaint_form' id='complaint_form' action='../../servlet/eAM.ComplaintServlet' method='post' target='messageFrame'>
<div>
      	<BR><BR><BR><BR><BR><BR><BR><BR><BR>

      	<table border='0' cellpadding='0' cellspacing='0'  width='60%' align='center' >

      	<tr>
									
									<td width="45%">&nbsp;</td>
									<td>&nbsp;</td>
									<td width='10%'>&nbsp;</td>
		</tr>


      		<tr>
      			
      		    <td  class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td><!--width='40%' -->
      		    <td  class='fields'><!--width='60%' colspan='2'-->
      		    <input type='text' onKeyPress="return CheckForSpecChars(event)"  name='complaint_code' id='complaint_code' value="<%=code%>" size='8' maxlength='8' <%=codeTextAttribute%> <%=eventFunctionForCase%>>&nbsp;
      		    <img src='../../eCommon/images/mandatory.gif' align='center'></img>
      		    </td>
      			<td>&nbsp;</td>
      		</tr>

		<tr>
						
						<td >&nbsp;</td>
						<td >&nbsp;</td>
						<td >&nbsp;</td>
		</tr>

		<tr>
		
		<td   class='label' valign="middle"><fmt:message key="Common.description.label" bundle="${common_labels}"/> </td>
		<td  class='fields'>
		<input type='text'   name='complaint_desc' id='complaint_desc' value="<%=desc%>" size='53' maxlength='60' <%=otherTextAttribute%> onBlur="makeValidString(this)" ></td>
		<td   align='left'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img><!--width='40%'-->
		</td>
		</tr>
  	<tr>
						
						<td >&nbsp;</td>
						<td >&nbsp;</td>
						<td >&nbsp;</td>
	</tr>
	<tr>
      			
      		    
				 <td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>  </td>
      		     <td  class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()">
      		     </td>
      		     <td >&nbsp;</td>
      	</tr>
		<tr>
									
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td width='10%'>&nbsp;</td>
		</tr>

      	
     
      	</div>

    <%  if(newcomplaint){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>



      	</form>
      	</body>
      	</html>

