<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
      <head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
      	
		<script language="javascript" src="../js/MRASAScore.js"></script>
<script>
function CheckForSpecCharsLocal(event){ 
    //var strCheck = '.0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*';
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

</script>
      </head>

      <body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>


<%
   String asascore="";
   String patient_physical_desc="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   //String eventFunctionForDate="";
   boolean newAsascore = false;
   String sql="";
   Connection conn=null;
%>
<%
try{
	conn=ConnectionManager.getConnection(request);
	asascore=request.getParameter("asa_score_code");
		
	if(asascore==null){
		asascore="";
		patient_physical_desc="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		newAsascore=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
	       //Statement stmt=null;
		   PreparedStatement stmt=null;
	    	ResultSet rset=null;
     try{

		if(asascore.equals(""))
		asascore="+";

		//stmt = conn.createStatement();

		sql = "select ASA_SCORE_CODE,PATIENT_PHYSICAL_STATUS,eff_status from MR_ASA_SCORE where ASA_SCORE_CODE =?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,asascore);
		rset = stmt.executeQuery();
		rset.next();
		asascore=rset.getString("ASA_SCORE_CODE");
		patient_physical_desc=rset.getString("PATIENT_PHYSICAL_STATUS");
		


		effstatus=rset.getString("eff_status");
		if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			checkBoxAttribute="";
		}else{

			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
		}

	     }catch(Exception e){
			e.toString();
	     }
	     finally{
	     	if(stmt!=null)
	     	stmt.close();
	     	if(rset!=null)
	     	rset.close();
	     }
		codeTextAttribute="READONLY";
		newAsascore=false;
		eventFunctionForCase="";
	}

%>

      	<form name='MRASAScore_form' id='MRASAScore_form' action='../../servlet/eMR.MRASAScoreServlet' method='post' target='messageFrame'>
      	<div align='left'>
		<BR><BR><BR><BR><BR><BR><BR><BR><BR>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	
      		<tr>
      		    <td width='50%' class='label'><fmt:message key="Common.Class.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='asa_score_code' id='asa_score_code' onKeyPress="return CheckForSpecCharsLocal(event);" size='4' maxlength='5' <%=codeTextAttribute%> <%=eventFunctionForCase%> value="<%=asascore%>">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      			
      		<tr>
      		    <td  class='label'><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.PhysicalStatus.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='patient_physical_status' id='patient_physical_status' size='40' maxlength='40' value="<%=patient_physical_desc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>      			
      					
      		<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
      		</tr>
			
      	</table>
      	</div>
    <%  if(newAsascore){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
      	</form>
      	</body>
      	</html>
<%
}catch(Exception e){/* out.println(e.toString()); */e.printStackTrace();}
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

