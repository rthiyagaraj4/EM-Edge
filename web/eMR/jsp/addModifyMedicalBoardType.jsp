<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
      <head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		
	
	<Script Language="JavaScript" src="..//js/MRMaster.js"></script>
      </head>

    <body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>

<%
   request.setCharacterEncoding("UTF-8"); 
   String med_board_type_code="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   boolean status = false;
   StringBuffer sql = new StringBuffer();
   StringBuffer sql_check = new StringBuffer();
   String board_type_exist_yn	="";

   Connection conn=null;
%>
<%
try
{
	conn=ConnectionManager.getConnection(request);
	
	med_board_type_code=request.getParameter("MED_BOARD_TYPE_CODE");
	if(med_board_type_code==null){
		med_board_type_code="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		status=true;
		//eventFunctionForDate="OnBlur='CheckDate(this)'";
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
		    PreparedStatement stmt=null;
	    	ResultSet rset=null;
  try{

		sql.append("select MED_BOARD_TYPE_CODE,long_desc,short_desc,eff_status from mr_medical_board_type where MED_BOARD_TYPE_CODE=?");
		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(1,med_board_type_code);
		rset = stmt.executeQuery();

		while(rset.next())
		 {
			med_board_type_code=rset.getString("MED_BOARD_TYPE_CODE");
			longdesc=rset.getString("long_desc");
			shortdesc=rset.getString("short_desc");
		 

			effstatus=rset.getString("eff_status");
			if(effstatus.equals("D")){
				otherTextAttribute="READONLY";
				checkBoxAttribute="";
			}else{

				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
			}
		 }
		if(rset!=null)
	     	rset.close();
	 	if(stmt!=null)
	     	stmt.close();
		
		sql_check.append("select 1 from mr_medical_board where MED_BOARD_TYPE_CODE = ? ");
		stmt = conn.prepareStatement(sql_check.toString());
		stmt.setString(1,med_board_type_code);
		rset = stmt.executeQuery();
		while(rset.next())
		{
				board_type_exist_yn="EXIT";
		}
			
		if(rset != null)	rset.close(); 
		if(stmt != null)	stmt.close();
		
	     }
		 catch(Exception e){
			out.println("Exception @ try :"+e.toString());
	     }
	    
		codeTextAttribute="READONLY";
		status=false;
		eventFunctionForCase="";
	}

%>

      	<form name='medboardtype_form' id='medboardtype_form' action='../../servlet/eMR.MedicalBoardTypeServlet' method='post' target='messageFrame'>
      	<div align='left'>
      	<BR><BR><BR><BR><BR><BR><BR><BR><BR><br>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	
      		<tr>
      		    <td  width='50%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='med_board_typecode' id='med_board_typecode' value="<%=med_board_type_code%>" size='7' maxlength='4' onKeyPress="return CheckForSpecChars(event)"  <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td  class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
     		    <td  class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			
      		<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
      		</tr>
			
      	</table>
      	</div>
    <%  if(status){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
		<input type='hidden' name='Board_type_status' id='Board_type_status' value='<%=board_type_exist_yn%>'>
     	</form>
      	</body>
      	</html>

<%
}
catch(Exception e){
	out.println("Exception @ addModifymedicalBoardType.jsp"+e.toString());
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

