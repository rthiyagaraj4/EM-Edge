<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230210								MMS-DM-CRF-0209.5			Namrata Charate
*/ %>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>

<script>
function showMainTabDetails(called_for){
	var mul_fact_ded_rule_YN = document.forms[0].mul_fact_ded_rule_YN.value;
	var drug_cat_YN = document.forms[0].drug_cat_YN.value;
	var diag_cat_YN = document.forms[0].diag_cat_YN.value;
	var service_items_YN = document.forms[0].service_items_YN.value; //V230210
	
	parent.TabsDataFrame.location.href ='../../eBL/jsp/BLParametersInsMain.jsp?mul_fact_ded_rule_YN='+mul_fact_ded_rule_YN+"&drug_cat_YN="+drug_cat_YN+"&diag_cat_YN="+diag_cat_YN+"&service_items_YN="+service_items_YN;
}
</script>


<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String mul_fact_ded_rule_YN = request.getParameter("mul_fact_ded_rule_YN");
	if(mul_fact_ded_rule_YN==null || mul_fact_ded_rule_YN.equals("")) mul_fact_ded_rule_YN="N";
	
	String drug_cat_YN = request.getParameter("drug_cat_YN");
	if(drug_cat_YN == null) drug_cat_YN = "N";
	String diag_cat_YN = request.getParameter("diag_cat_YN");
	if(diag_cat_YN == null) diag_cat_YN = "N";
	String service_items_YN = request.getParameter("service_items_YN"); //V230210
	if(service_items_YN == null) service_items_YN = "N"; //V230210
	
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="showMainTabDetails('INSURANCE');">
<form name="frmBLParamTab" id="frmBLParamTab" >

<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist' style="padding-left:0px">
			<li class="tablistitem" title='Insurance'>
				<a onclick="showMainTabDetails('INSURANCE')" class="tabA" id="insurance_params" >
					<span class="tabAspan" id="INSURANCEspan">					
					Insurance						
					</span></a>
			</li>
	
		</ul>
	</td>	
	</tr>
	<input type='hidden' name = 'mul_fact_ded_rule_YN' id='mul_fact_ded_rule_YN' value='<%=mul_fact_ded_rule_YN%>'>
	<input type='hidden' name = 'drug_cat_YN' id='drug_cat_YN' value='<%=drug_cat_YN%>'>
	<input type='hidden' name = 'diag_cat_YN' id='diag_cat_YN' value='<%=diag_cat_YN%>'>
	<input type='hidden' name = 'service_items_YN' id='service_items_YN' value='<%=service_items_YN%>'> <!-- V230210 -->
</table>  
</form>
</body>
</html>

