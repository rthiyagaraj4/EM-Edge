<!DOCTYPE html>
<%--
	FileName		: addModifyPatientInstructions.jsp
	Version	    : 3	
	Modified On	: 03-08-2009
--%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAM/js/PatientInstructions.js' language='javascript'></script>  
	</head>
<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String instruction_id="";
		String instruction_desc="";		
		String effstatus="";
		String codeTextAttribute="";
		String otherTextAttribute="";
		String checkBoxAttribute="";
		boolean function_check=false;

		instruction_id=request.getParameter("instruction_id");
		if(instruction_id==null){
			instruction_id="";
			instruction_desc="";			
			effstatus="D";
			codeTextAttribute="";
			otherTextAttribute="";
			checkBoxAttribute="";
			function_check=true;
		}else{
			Connection conn = ConnectionManager.getConnection(request);
			Statement stmt=null;
			PreparedStatement pstmt = null;
			ResultSet rset=null;
			try{

				String sql = "select instruction_id,instruction_desc,eff_status from am_pat_instructions where instruction_id=?";
								
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	instruction_id		);

				rset		 = pstmt.executeQuery();
				rset.next();
				instruction_id=rset.getString("instruction_id");
				instruction_desc=rset.getString("instruction_desc");							
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
					if (pstmt != null) pstmt.close();
			}catch(Exception e){

				   }
			finally {					
					ConnectionManager.returnConnection(conn,request);				
					}  

					codeTextAttribute="READONLY";
					function_check=false;					
			}

%>
		
<form name='patientinstructions_form' id='patientinstructions_form' action='../../servlet/eAM.PatientInstructionsServlet' method='post' target='messageFrame'>
      	
      	<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>

      	<table border='0' cellpadding='0' cellspacing='0'  align='center'  width='100%'>
			<tr>
	      		<td width="40%" class='label'><fmt:message key="eAM.InstructionID.label" bundle="${am_labels}"/></td>
      		    <td class='fields'><input type='text' name='instruction_id' id='instruction_id'  onBlur="CheckNumber(this);changeCase(this)" onKeyPress="return CheckForSpecChar(event)"  value="<%=instruction_id%>" size='8' maxlength='8' <%=codeTextAttribute%>><img src='../../eCommon/images/mandatory.gif'></img></td>     
			</tr> 
			<tr>
					<td class='label'><fmt:message key="eAM.InstructionDescript.label" bundle="${am_labels}"/></td>
					<td class='fields'><Textarea rows='2' cols='50' size='200' maxlength='200' name='instruction_desc'   onkeypress='checkMaxLimit(this,200);return CheckForSpecChardesc(event)' onBlur="makeValidString(this,200)" <%=otherTextAttribute%>><%=instruction_desc%></Textarea><img src='../../eCommon/images/mandatory.gif'></img></td>	
      		</tr>   	
   	      	<tr>      		
				   <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				   <td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>			
			</tr>		

</table>
<%  if(function_check){%>

<input type='hidden' name='function' id='function' value='insert'>
<input type='hidden' name='function_name' id='function_name' value='insert'>

<%}else{%>

<input type='hidden' name='function' id='function' value='modify'>
<input type='hidden' name='function_name' id='function_name' value='modify'>
 <%}%>

</form>
</body>
</html>

