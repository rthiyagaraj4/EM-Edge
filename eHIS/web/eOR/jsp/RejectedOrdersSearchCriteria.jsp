<!DOCTYPE html>
<%--
 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
10/01/2018  	IN061893		Kamalakannan G  		10/01/2018 		 Ramesh G 		ML-MMOH-CRF-0545
17/01/2018  	IN066340		Kamalakannan G  		17/01/2018 		 Ramesh G 		ML-MMOH-CRF-0545
---------------------------------------------------------------------------------------------------------------------------------------------

--%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@page  import="java.util.*,eOR.* ,webbeans.eCommon.ConnectionManager ,eOR.Common.*" %>
<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOR/js/RejectedOrders.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script> 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//String mode	   = request.getParameter( "mode" ) ;commented for checkstyle
	String bean_id = "Or_RejectOrders" ;
	String bean_name = "eOR.RejectOrder";
	String date_from="",date_to="";//,currentDate;commented for checkstyle
	Properties p = (Properties)session.getValue("jdbc");
	String locale= (String) p.getProperty("LOCALE");
	String ordcat=request.getParameter("ordcat")==null?"":request.getParameter("ordcat");
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id");
	RejectOrder bean = (RejectOrder)getBeanObject( bean_id, bean_name , request ) ;
	bean.setLanguageId(localeName);
	int patient_id_length = bean.getPatientIdLength();
	if (date_from.equals(""))
	{
		date_to		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		date_from	= com.ehis.util.DateUtils.minusDate(date_to,"DMYHM",locale,7,"d");
	}
	else
	{
		date_to = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMYHM","en",locale);				
	}	
%>
	<form name='rejectorders' id='rejectorders' target='messageFrame' >
		<table cellpadding=3  border='0'  width="100%"  align=right  >
			<tr>
				<td  class='label' id='patientId_lbl_td' colspan=1 width="20%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields' id='patientId_td' >
						<input type='text' name='patientId' id='patientId' value=''  onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength='<%=patient_id_length%>'><input type=button name=search value='?'  class=button tabIndex="4" onClick="PatientLookup()" >
				</td>
				<td class="label"   width='20%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/><!-- commented for 066340 &nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>--></td>
				<td class='fields' width='35%' >
					<input type="text" maxlength=16 size="16" value='<%=date_from%>' name="date_from" onBlur='chkDateTime(this,"DMYHM","<%=locale%>"); '><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('date_from');" /> &nbsp;
					<!-- commented for 066340 <fmt:message key="Common.to.label" bundle="${common_labels}"/>-->
					<input type="text" maxlength=16 size="16" value='<%=date_to%>' name="date_to" onBlur='chkDateTime(this,"DMYHM","<%=locale%>");'><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('date_to');" ><img src='../../eMP/images/mandatory.gif'align='center'></img>
				</td>
			</tr>
			<tr>
				<input type="hidden" name="ordcat" id="ordcat" value="<%=ordcat%>">
				<input type="hidden" name="ca_practitioner_id" id="ca_practitioner_id" value="<%=ca_practitioner_id%>">
			</tr>
			<tr>
				<td class='button' colspan=4>
				<input type='button' class='button' name='search_btn' id='search_btn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='populateResult()'>
				<input type='button' name='clear' id='clear' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'>
				</td>
			</tr>
		</table>
	</form>
	<script language='javascript'>	
		parent.resultframe.location.href = "../../eOR/jsp/RejectedOrdersSearchResult.jsp?date_from=<%=date_from%>&date_to=<%=date_to%>&ordcat=<%=ordcat%>&ca_practitioner_id=<%=ca_practitioner_id%>";
		parent.rejectOrdersButtonFrame.location.href = '../../eOR/jsp/RejectedOrderbtnframeset.jsp';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</body>
</html>

