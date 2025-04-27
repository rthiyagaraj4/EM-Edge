<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
   <%
     String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   	request.setCharacterEncoding("UTF-8");

  %>

    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link   rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>	
    <script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
	<script language='javascript' src='../../eMO/js/MOBodyMovementQuery.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    
</head>
<body  onMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <center>
  <form name='BodyMovementForm' id='BodyMovementForm' target='result' >
   <table border='0' cellpadding='0' cellspacing='0' width='100%'>
    <% 
	   String	facility_id =  (String) session.getValue( "facility_id" ) ;
	   String regno         =   "";
	   
	   /*Below line added for this CRF Bru-HIMS-CRF-367*/ 	   
	   String locale = ((String)session.getAttribute("LOCALE")); 
	   String function_id=checkForNull(request.getParameter("function_id"));
	   String patientid=checkForNull(request.getParameter("pid")); 
	   String defaultdisable="";	  
	  if(function_id.equals("ViewMovementHistory"))	  	
			defaultdisable="disabled";
		else
			defaultdisable="";
		
	if(function_id.equals("ViewMovementHistory"))	  {   
   	%>
	<tr> <td colspan="7">&nbsp;</td></tr>
	<%}   //End this CRF Bru-HIMS-CRF-367 	%>
	<tr>
	 	 <td class='LABEL' nowrap><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
		 <td><input type='text' name="registration_no" id="registration_no" value="<%=regno%>" size='20'  maxlength="" onKeyPress="return CheckForSpecChars(event)" onBlur="ChangeToUpper(this)"onClick = '' <%=defaultdisable%>><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="searchCode(this, registration_no);" <%=defaultdisable%>>&nbsp;&nbsp;</td>
         <td>&nbsp;</td>
         <td class='LABEL' nowrap colspan="2"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
  		 <td class='LABEL' >&nbsp;&nbsp;<input type='text'  name='patient_id' id='patient_id'  value="<%=patientid%>" maxLength=10 size='20' onKeyPress="return CheckForSpecChars(event);"<%=defaultdisable%>><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="callPatient();" <%=defaultdisable%>>	</td>
		 <td colspan="2"></td>
		
	</tr>
	<tr> <td colspan="7">&nbsp;</td></tr>
	<!--Below line Added for this CRF Bru-HIMS-CRF-367 -->
	<tr>
	 	 <td class='LABEL' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		 <td >
		 <select name='facilityId' id='facilityId' ><option value='' selected> --------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------
    				    	<% 
							Connection con=null;
							Statement stmt=null;
							ResultSet rset=null ;
							String dataval="";	String idval=""; String selected_idval	= "";
try{    
	                            con = ConnectionManager.getConnection(request);	
    				    		stmt=con.createStatement();
    				    		rset=stmt.executeQuery("select facility_id,facility_name from SM_FACILITY_PARAM_LANG_VW where language_id='"+locale+"' order by 2 ");
    			    if(rset!=null){
    				     while(rset.next()){
    				    		   dataval=rset.getString("facility_name")==null?"":rset.getString("facility_name");
    				    		   idval=rset.getString("facility_id")==null?"":rset.getString("facility_id");
    				    		  // out.println("<option value='"+idval+ "' >"+dataval);
								  
								  if(idval.equals(facility_id))
    					          selected_idval = "selected";
	        			          else
			    		          selected_idval = "";
						         out.println("<option value='"+idval+"'" +selected_idval+">"+dataval+"</option>");
    						   
    				     }
    			    }
}catch(Exception e){
out.println(e);
}finally { 
	ConnectionManager.returnConnection(con,request);
}
								%> </select>
		 </td>        
         <td colspan="5">&nbsp;</td>		
	</tr> 
	
	<!--End this CRF Bru-HIMS-CRF-367-->
	
   </table>
   <table align='right' cellpadding="0" cellspacing="0" border="0">
	<tr>
		 <td align='right' class='button'>
		 <input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='submitPage();'>
		 <input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onclick='clearAll()' <%=defaultdisable%>>
		 </td>
	</tr>
   </table>
	
	     <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		 
		 <input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>

	 
  </form>
  
 </center>
</body>
<!--Below line added for this CRF  Bru-HIMS-CRF-367-->
<script>

if('<%=function_id%>'=="ViewMovementHistory"){
document.forms[0].search.click();
}
</script>

</html>

<%!
	// to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

