<!DOCTYPE html>
<!-- 
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
07/08/2013	  IN073540      chandrashekar raju 		    AAKH-CRF-0122.1
01/09/2020	        		        Chandra	             AAKH-SCF-0448

-----------------------------------------------------------------------
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD>
   <title>
         Pending Doctor Documentation
   </title>
	<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
	<script language='javascript' src='../../eCA/js/CoderFunction.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 Properties p;
		session 		              = request.getSession(false);
		p 				              = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale 	              = (String) p.getProperty("LOCALE");
        String bean_id				  = "CACoderFunction" ;
	    String bean_name			  = "eCA.CACoderFunction";
		CACoderFunction bean	      = (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
		String toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		String frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,7,"d");
		String function_id =request.getParameter("function_id")==null?"":request.getParameter("function_id");
%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
  <form name="pendingDocumentationform" id="pendingDocumentationform"  >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">

			<tr>
			     <td class="label"   nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				 <td class="field" width="30%">&nbsp;
				   <input align="center" type='text'  name='p_patient_id' id='p_patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" onBlur="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'
				   onfocus="callPatientLookup();" onClick="callPatientLookup();"></td>
				 <td class='label'  width="10%" ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
				 <td class="field" ><input type='textbox' id='fromDt' name='dt_from' id='dt_from' value='<%=frDate%>' size=10 maxlength=10 onBlur='chkDateTime(this,"DMY","<%=locale%>");''></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('dt_from')"><img src='../../eCommon/images/mandatory.gif'></img>
				&nbsp<input type='textbox' id='toDt' name='dt_to' id='dt_to' value='<%=toDate%>' size=10 maxlength=10 onBlur='chkDateTime(this,"DMY","<%=locale%>");'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('dt_to')"></input><img src='../../eCommon/images/mandatory.gif'></img></td>
				<td class="field" width ="10%"></td>
          </tr>
		    <tr>

			  
			    <td class='button'  colspan=4><input type=button name='search' id='search' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='showPendingQueryRecords()'><input type=button name='clear' id='clear' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearValues()'></td> 
          </tr>

</table>
     <input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'/>
	 <input type='hidden' name ='locale' value ='<%=locale%>'/><!-- Added for AAKH-SCF-0448 -->

	 <script>
	   showPendingQueryRecords();
	 </script>
</form>

<% putObjectInBean(bean_id,bean,request); %>
</body>

</html>

