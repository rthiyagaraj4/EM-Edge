<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css"; 
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>

	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/QueryDispSpecialDrug.js"></script> 

	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- 		Added CheckDateLeap funtion for  RollForward from SRR - SRR20056-SCF-9386 [IN:056580]  -->
 

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">

<%
	String	bean_id			=	"QueryPresVsDispDrugsBean" ;
	String	bean_name		=	"ePH.QueryPresVsDispDrugsBean";
	QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id,bean_name,request ) ;
	
	bean.setLanguageId(locale);
	String drug_query=PhRepository.getPhKeyValue( "SQL_QUERY_DISP_SPECIAL_DRUG_SELECT1" ); 

	
%>
<form name="FormQueryDispSpecialDrug" id="FormQueryDispSpecialDrug" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" topmargin="0">
	<tr >
		<td align="left" class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
		<td  align="left" >&nbsp;&nbsp;
	<input type=text  maxlength="40" size="40" name="Drug_Name" id="Drug_Name"  ><INPUT TYPE="button" name="Drug_Name_Button" id="Drug_Name_Button" VALUE="?" CLASS="button" 
	onfocus="DrugSearch(document.FormQueryDispSpecialDrug.Drug_Name)"
	onClick="DrugSearch(document.FormQueryDispSpecialDrug.Drug_Name)">&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</td>
		</TR>
		<Tr>
		<td class="label" align="left" >
		<fmt:message key="ePH.DispenseDateFrom.label" bundle="${ph_labels}"/></td>
		<td  align="left">&nbsp;&nbsp;  
		<input type=text  name="Dispense_Date_From" id="Dispense_Date_From" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%= locale %>')" value="<%=com.ehis.util.DateUtils.convertDate(bean.getSysdate(),"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('Dispense_Date_From');" >&nbsp;<img src="../../eCommon/images/mandatory.gif">		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- 		Added CheckDateLeap funtion for  RollForward from SRR - SRR20056-SCF-9386 [IN:056580]  -->
		<fmt:message key="Common.to.label" bundle="${common_labels}"/> 
		<input type=text  name="Dispense_Date_To" id="Dispense_Date_To" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%= locale %>')" value="<%=com.ehis.util.DateUtils.convertDate(bean.getSysdate(),"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('Dispense_Date_To');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"><!-- 		Added CheckDateLeap funtion for  RollForward from SRR - SRR20056-SCF-9386 [IN:056580]  -->
		</td>
		</tr> 
<tr>
<td align=right colspan=6>	<input type="button" class="button" name="search" id="search" 
value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResultPage()"></td>
</tr>
</table>

	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="Drug_Code" id="Drug_Code" >
	<INPUT TYPE="hidden" name="Drug_Query" id="Drug_Query"  value="<%=drug_query%>">
	<INPUT TYPE="hidden" name="language_id" id="language_id"  value="<%=locale%>">

<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
</html>

