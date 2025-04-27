<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.DrugMasterBean, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<%	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

	String locale			= (String)session.getAttribute("LOCALE");
	String bean_id		= "DrugMasterBean" ;
	String bean_name	= "ePH.DrugMasterBean";
	String mode			= request.getParameter("mode");
	DrugMasterBean bean = (DrugMasterBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	boolean	ext_result	=	bean.checkExternalProduct();
%>
<html>
<head>
<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script language="JavaScript" src="../js/PhCommon.js"></script>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../ePH/js/DrugMaster.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
/*function tab_click1(id)
{


	selectTab(id);
	
	showTabDetail(id);
}*/
</script>
</head>
<%
String item_code		= request.getParameter( "item_code" );
	if(item_code==null)	item_code	=	"";
	String form_code		= request.getParameter( "form_code" );
	if(form_code==null)	form_code	=	"";
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' topmargin="0">
<form name="drugMasterButtons" id="drugMasterButtons">
<table border="0" width="100%" cellspacing="0" cellpadding="0">
<tr>	
		<td width= "140%" class="white">
	<ul id="tablist" class="tablist" style="padding-left:0px">
			<li class="tablistitem" title='<fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/>'>
				<a onclick="tab_click1('characteristics_tab')" class="tabClicked" id="characteristics_tab" >
					<span class="tabSpanclicked" id="characteristics_tabspan"><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="ePH.DosageDispDetails.label" bundle="${ph_labels}"/>'>
				<a onclick="tab_click1('dosage_tab')" class="tabA" id="dosage_tab" >
					<span class="tabAspan" id="dosage_tabspan"><fmt:message key="ePH.DosageDispDetails.label" bundle="${ph_labels}"/></span>
				</a>
			</li>
			
		<li class="tablistitem" title='<fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>'>
				<a onclick="tab_click1('trade_tab')" class="tabA" id="trade_tab" >
			<span class="tabAspan" id="trade_tabspan"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></span>
				</a>
			</li>	

		  
				<li class="tablistitem" title='<fmt:message key="ePH.GenricIngredints.label" bundle="${ph_labels}"/>'>
				<a onclick="tab_click1('generic_tab')" class="tabA" id="generic_tab" >
					<span class="tabAspan" id="generic_tabspan"><fmt:message key="ePH.GenricIngredints.label" bundle="${ph_labels}"/></span>
				</a>
			</li>	
			
<%	if(ext_result) {	%> 
			<li class="tablistitem" title='<fmt:message key="ePH.DrugDataBaseInterface.label" bundle="${ph_labels}"/>'>
				<a onclick="tab_click1('external_tab')" class="tabA" id="external_tab" >
					<span class="tabAspan" id="external_tabspan"><fmt:message key="ePH.DrugDataBaseInterface.label" bundle="${ph_labels}"/></span>
				</a>
			</li>

		<%	}	%> 	

		<li class="tablistitem" title='<fmt:message key="ePH.WeightRecording.label" bundle="${ph_labels}"/>'>
				<a onclick="tab_click1('weightrecording_tab')" class="tabA" id="weightrecording_tab" >
					<span class="tabAspan" id="weightrecording_tabspan"><fmt:message key="ePH.AgeGroups.label" bundle="${ph_labels}"/></span>
				</a>
			</li>

		<li class="tablistitem" title='<fmt:message key="ePH.SlidingScaleTemplate.label" bundle="${ph_labels}"/>'>
				<a onclick="tab_click1('sliding_scale_tab')" class="tabA" id="sliding_scale_tab" >
					<span class="tabAspan" id="sliding_scale_tabspan"><fmt:message key="ePH.SlidingScaleTemplate.label" bundle="${ph_labels}"/></span>
				</a>
			</li>	
		<li class="tablistitem" title='<fmt:message key="ePH.SupportiveDrugs.label" bundle="${ph_labels}"/>'><!-- Added for TH-KW-CRF-0007 -->
				<a onclick="tab_click1('support_drugs_tab')" class="tabA" id="support_drugs_tab" >
					<span class="tabAspan" id="support_drugs_tabspan"><fmt:message key="ePH.SupportiveDrugs.label" bundle="${ph_labels}"/></span>
				</a>
			</li>	

		</ul>
	<!-- The below line is required to change the select state of Demograph tab initially selected -->
		<script>prevTabObj='characteristics_tab'</script>


	</td>
	</tr>
</table>

<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
<input type="hidden" name="form_code" id="form_code" value="<%=form_code%>">
</form>
</body>
<script>
<% if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) { %>
//document.getElementById("characteristics").click();
characteristics_tab.click();
<% } %>
</script>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

