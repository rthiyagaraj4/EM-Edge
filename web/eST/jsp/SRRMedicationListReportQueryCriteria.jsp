<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, eST.*, eST.Common.*,ePH.*,ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
<head>
		<%
	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");	
	String doc_type_code=""; 
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String currentdate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	String facility_id  = (String)session.getValue( "facility_id" );
	String login_user	= (String)session.getValue("login_user");
	String bean_id = "RTVHistoryBean";
	String bean_name = "eST.RTVHistoryBean";
	String rdonly="";

	RTVHistoryBean bean = (RTVHistoryBean) getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	
		 ArrayList params = new ArrayList();	
		
		params.add(facility_id);
		params.add(login_user);						    
		params.add(locale);			 

	String store_code = bean.getListOptionTag(bean.getListOptionArrayList("SELECT st.store_code , mm.short_desc FROM mm_store_lang_vw mm, ST_USER_ACCESS_FOR_STORE st,ST_STORE ststr,ST_ACC_ENTITY_PARAM stpa  WHERE mm.store_code = st.store_code AND mm.store_code = ststr.store_code AND mm.eff_status = 'E' AND st.srt_allowed_yn = 'Y' AND ststr.srt_allowed_yn = 'Y' AND mm.facility_id LIKE (?) AND st.user_id LIKE (?) AND mm.language_id LIKE (?) ORDER BY 2",params));
	
   doc_type_code = (String)((HashMap)bean.fetchRecord("SELECT a.doc_type_code FROM st_trn_doc_type a  WHERE a.facility_id=?  AND a.trn_type ='SAL' ",facility_id)).get("DOC_TYPE_CODE");
		
	int pat_length				=		Integer.parseInt(bean.checkForNull((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_ID_LENGTH"))).get("PATIENT_ID_LENGTH"),"0"));
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eST/js/SRRMedicationList.js"></script>  
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>			   
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	




</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="SRRSalesRtnVoucherForm" id="SRRSalesRtnVoucherForm" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >	    
<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='80%' align='center' >
			<tr>
			<td width='80%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">			    
				
				
			
				<tr>
				<td align="right" colspan=4>&nbsp;</td>
				</tr>
																			 
				<tr>
				<td class=label align=right><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class=fields >&nbsp;&nbsp;<input type='text' name='patient_id' id='patient_id' size=20 maxLength="<%=pat_length%>" value="" ><input type='button' class='button' value="?" onclick="callPatientLookup();"></td>	 	  
				</tr>																		   
				<!-- Added if conditions  onblur of dates ==by sandhya-->	
				<tr>
					<td class=label align=right><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_disp_date_from size=10 maxlength=10 class="DATE" value="<%=currentdate%>"  onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_disp_date_from))validate_date(this,'TO_DATE_LESS_FROM')"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_disp_date_from');" ></img>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></td>				   

					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_disp_date_to size=10 maxlength=10 class="DATE" value="<%=currentdate%>"  onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_disp_date_to))validate_date(this,'TO_DATE_LESS_FROM')"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_disp_date_to');" ></img>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></td>
				</tr>															    							   
                 <tr>					 				   
			     <td class=label align=right><fmt:message key="eST.SalesDocNo.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input class="NUMBER" type="text" size="12" maxlength="8" 
						onKeyPress="return isValidInteger();"  name="sale_doc_no_from" id="sale_doc_no_from" 
						onBlur="numberValidation(this,document.forms[0].sale_doc_no_to)"  ></td>    
					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input class="NUMBER" type="text" size="12" maxlength="8" 
						onKeyPress="return isValidInteger();" name="sale_doc_no_to" id="sale_doc_no_to" 
						onBlur="numberValidation(document.forms[0].sale_doc_no_from,this)" ></td>    				  	 						 
																					  
				</tr>																    		   
				<tr>																								    
			<td class="label" align=right><fmt:message key="Common.Store.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<select name="store" id="store"><%=store_code%>	</select>&nbsp;<IMG			   SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></td>
                  <td  class="label" ></td>
					<td  class="button" ><input type="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResult()">&nbsp;<input type="button" name="print" id="print" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' class="button" onClick="showPrint('');" disabled></td>

				</tr>
				<tr>
				<td align="right" colspan=4>&nbsp;</td>
				</tr>														 

			   
			
                
				</table>
				</td>  											    

				</tr>
			</table>
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">		  
<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="ST">
<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="Y">
<INPUT TYPE="hidden" name="doc_type_code" id="doc_type_code" VALUE="<%=doc_type_code%>"> 	
 <INPUT TYPE="hidden" name="action_type" id="action_type" VALUE="R">
																			   

</form>																   

</body>
</html>																   

