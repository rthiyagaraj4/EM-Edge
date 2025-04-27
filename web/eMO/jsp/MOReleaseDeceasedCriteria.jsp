<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	  <%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	  <script language='javascript' src='../../eCommon/js/common.js'></script>
	  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>	  
	  <script language='javascript' src='../../eMO/js/MOReleaseDeceased.js'></script>	  
	  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
	  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	  <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   <%String patientid      = request.getParameter("param")==null?"":request.getParameter("param");
   String	facilityId 	   = (String) session.getValue( "facility_id" ) ;
   String first      = request.getParameter("first")==null?"":request.getParameter("first");
   %>
</head>

<body OnMouseDown='CodeArrest()' onload='firstfocus();' onKeyDown="lockKey()">
   <form name="RDeceased_form1" id="RDeceased_form1" action="" method="post" >
   <br><br>
	 <table border="0" cellpadding="0" cellspacing="0" align='center' width='75%'>
     <tr><td colspan='4'>&nbsp;</td></tr>
     <tr>
    	  <td align='left' width='13%'>&nbsp;</td>
	      <td class='LABEL' align='right' width="9%" nowrap><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
  		   <td class='LABEL' align='left'width="16%" nowrap>&nbsp;
		   <input type='text'  name=patient_id  value="<%=patientid%>"  size="18" maxlength="16" onKeyPress="return(CheckForSpecChars(event))" onblur="chkman(this);"><input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="searchCode(this, patient_id);" >&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
		  </td>	
		    <td align='left' width='20%'>&nbsp;</td>
	    </tr>
				<tr><td colspan='4'>&nbsp;</td></tr>	   
 </table>
 <input type=hidden name ="first" value='<%=first%>'>
 <input type=hidden name ="facilityId" value='<%=facilityId%>'>
	<input type=hidden name ="patientid" value='<%=patientid%>'>
 </form>
 </body>
</html>	

