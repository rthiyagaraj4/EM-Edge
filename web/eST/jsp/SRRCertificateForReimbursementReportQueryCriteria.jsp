<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
				<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/SRRCertificateForReimbursement.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	</head>
	<%
		
	String bean_id1 = "RTVHistoryBean";
	String bean_name1 = "eST.RTVHistoryBean";
	RTVHistoryBean bean1 = (RTVHistoryBean) getBeanObject( bean_id1,bean_name1,request );
	bean1.setLanguageId(locale);
   // String rdonly="";
	String bean_id		= "SRRCertificateForReimbursementBean" ;
	String bean_name	= "eST.SRRCertificateForReimbursementBean";
	SRRCertificateForReimbursementBean bean	= (SRRCertificateForReimbursementBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);

		
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		//java.util.Date date_time	 	= new java.util.Date();
	     String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);


		 ArrayList alParam = new ArrayList();
	
		alParam.add(facility_id);
		alParam.add(user_name);
		alParam.add(locale);


		//String document_type_code	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT   a.doc_type_code code, b.short_desc description FROM st_trn_doc_type a, sy_doc_type_master_lang_vw b WHERE b.language_id LIKE ? AND a.facility_id LIKE (?) AND a.doc_type_code LIKE UPPER ('%') AND UPPER (b.short_desc) LIKE UPPER ('%') AND a.doc_type_code = b.doc_type_code",alParam));

		String store_code = bean1.getListOptionTag(bean1.getListOptionArrayList("SELECT st.store_code , mm.short_desc FROM mm_store_lang_vw mm, ST_USER_ACCESS_FOR_STORE st,ST_STORE ststr,ST_ACC_ENTITY_PARAM stpa  WHERE mm.store_code = st.store_code AND mm.store_code = ststr.store_code AND mm.eff_status = 'E' AND st.srt_allowed_yn = 'Y' AND ststr.srt_allowed_yn = 'Y' AND mm.facility_id LIKE (?) AND st.user_id LIKE (?) AND mm.language_id LIKE (?) ORDER BY 2",alParam));
		
		
		
		

		int pat_length				=		Integer.parseInt(bean.checkForNull((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_ID_LENGTH"))).get("PATIENT_ID_LENGTH"),"0"));
	%>
	<body onLoad="FocusFirstElement();">
		<form name="CertificateForReimbursementCriteria" id="CertificateForReimbursementCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
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
				<td class=fields >&nbsp;&nbsp;<input type='text' name='patient_id' id='patient_id' size=20 maxLength="<%=pat_length%>" value="" ><input type='button' class='button' value="?" onclick="searchPatient();"></td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_disp_date_from size=10 maxlength=10 class="DATE" value="<%=currentdate%>"   onBlur="CheckDate(this,'<%=locale%>'); isAfterCurrDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_disp_date_from');" ></img>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></td>

					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_disp_date_to size=10 maxlength=10 class="DATE" value="<%=currentdate%>"  onBlur="DateCheck(currentdate,p_disp_date_to); validate_date(this,'TO_DATE_LESS_FROM');"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_disp_date_to');" ></img>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></td>
				</tr>
                 <tr>
			     <td class=label align=right><fmt:message key="Common.Sale.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input class="NUMBER" type="text" size="12" maxlength="8" 
						onKeyPress="return isValidInteger();" name="sale_doc_no_from" id="sale_doc_no_from" 
						onBlur="return checkIntegerFormat(this);" ></td>  
					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input class="NUMBER" type="text" size="12" maxlength="8" 
						onKeyPress="return isValidInteger();" name="sale_doc_no_to" id="sale_doc_no_to" 
						onBlur="return checkIntegerFormat(this);" ></td> 

				</tr>
				<tr>
			<td class="label" align=right><fmt:message key="Common.Store.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<select name="store" id="store"><%=store_code%>	</select>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></td>
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

			
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STCERTREIM_SRR">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
			<INPUT TYPE="hidden" name="P_DOC_NO" id="P_DOC_NO" VALUE="">
			<INPUT TYPE="hidden" name="P_DOC_DATE" id="P_DOC_DATE" VALUE="">
			<INPUT TYPE="hidden" name="P_STORE_CODE" id="P_STORE_CODE" VALUE="">
			<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="">

			
		</form>
			
<%
putObjectInBean(bean_id1,bean1,request);
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

