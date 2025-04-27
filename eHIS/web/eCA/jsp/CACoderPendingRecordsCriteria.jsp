<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		          Rev.Date		 Rev.Name		        Description
--------------------------------------------------------------------------------------------------------------
03/08/2020		IN073540			chandrashekar raju							        AAKH-CRF-0122.1
01/09/2020	        		        Chandra	                                            AAKH-SCF-0448

---------------------------------------------------------------------------------------------------------------
*/
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD>
	
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
        Properties p;
		session 		              = request.getSession(false);
		p 				              = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale 	              = (String) p.getProperty("LOCALE");
        String bean_id				  = "CACoderFunction" ;
	    String bean_name			  = "eCA.CACoderFunction";
		CACoderFunction bean	      = (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
		String toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		String frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,1,"M");
%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
  <form name="coderPendingSearch" id="coderPendingSearch" >
			<table cellpadding=3 cellspacing=0 border=0  width="100%" align="center" >

			
	  <tr>
            <td class="label" nowrap ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class="field" >
			<input align="center" type='text'  name='p_patient_id' id='p_patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" onBlur="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'
			onfocus="callPatientLookup();" onClick="callPatientLookup();"></td>
			<td class="label" ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
			<td class="label" >&nbsp&nbsp<input type="text" name="dt_from" id="dt_from"  value='<%=frDate%>' onBlur='chkDateTime(this,"DMY","<%=locale%>","CODER");'
			 maxlength="10" size="10" >
			<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');"  onblur='dt_from.focus()'><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td class="label" ><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
			<td class="label" ><input type="text" name="dt_to" id="dt_to" value='<%=toDate%>' maxlength="10" size="10" onBlur='chkDateTime(this,"DMY","<%=locale%>","CODER");'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" onblur='dt_to.focus()' ><img src='../../eCommon/images/mandatory.gif'></img></td>
	  </tr>
	   
		<tr>     
		     <td></td>
			 <td></td>
			 <td></td>
			 <td></td>
			 <td align="left" >
			   <input type="button" name="btnSearch" id="btnSearch" class="button"   value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'   onClick="showCoderPendingRecords()">
			   <input type="button" name="btnReset" id="btnReset" class="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="clearsearch()">		
		     </td>
       </tr> 
 </table>
 <input type='hidden' name ='locale' value ='<%=locale%>'/><!-- Added for AAKH-SCF-0448 -->
<script>
showCoderPendingRecords();
</script>
</form>

<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

