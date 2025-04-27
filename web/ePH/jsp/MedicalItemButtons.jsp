<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<%	
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String bean_id	="MedicalItemBean";
	String bean_name	="ePH.MedicalItemBean";
	String mode			= request.getParameter("mode");
	String Drug_code_value			= request.getParameter("Drug_code_value");

	MedicalItemBean bean = (MedicalItemBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	
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
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/MedicalItem.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function tab_click1(id)
{   
	
    selectTab(id);
	showTabDetail(id)
}
function showTabDetail(id)
{  
	link	=	id;
	if(link=="trade_tab" )
	{
	if(checkMandatoryFields()){
	 var formObj=parent.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm;
     var Drug_code_value=formObj.Drug_code_value.value;
     var mode=document.MedicalItemButtons.mode.value;
	// alert(mode)
    parent.f_tab_detail.location.href="../../ePH/jsp/MedicalItemDetail.jsp?link="+link+"&Drug_code_value="+Drug_code_value+"&mode="+mode;
    parent.f_tab_add_detail.location.href="../../ePH/jsp/MedicalItemAddDetail.jsp?link="+link+"&Drug_code_value="+Drug_code_value+"&mode="+mode;;
	}
	}
}

function checkMandatoryFields()	{
	var formObj			=parent.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm;
	var val=parent.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.in_formulary_yn.checked
	var messageFrame	=	parent.parent.messageFrame;
    if(val==true)
	{

    var fields = new Array ( formObj.drug_code, formObj.item_code, formObj.drug_desc,formObj.pres_base_uom,formObj.stock_uom,formObj.generic_name);
	var names = new Array ( getLabel("Common.code.label","Common"), getLabel("Common.ItemCode.label","Common"),  getLabel("Common.description.label","Common"),getLabel("ePH.PrescribingUnit.label","PH"),
		getLabel("ePH.DispensingUnit.label","PH"),getLabel("ePH.GenericName.label","PH"));
	}
	else if(val==false)
	{

	var fields = new Array ( formObj.drug_code, formObj.drug_desc,formObj.pres_base_uom,formObj.stock_uom,formObj.generic_name);
	var names = new Array ( getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),getLabel("ePH.PrescribingUnit.label","PH"),
		getLabel("ePH.DispensingUnit.label","PH"),getLabel("ePH.GenericName.label","PH"));
	}
   
	if(parent.MedicalItemAddModifyFrame.checkFieldsofMst( fields, names, messageFrame) )	{
		
		disableMainForm();
		return true;
	}
	else
		return false;
}
function disableMainForm()	
	{
	var arrObj =parent.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.elements;
    for(var i=0;i<arrObj.length;i++)
           arrObj[i].disabled=true;
    }


</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' topmargin="0">
<form name="MedicalItemButtons" id="MedicalItemButtons">
<table border="0" width="100%" cellspacing="0" cellpadding="0">
<tr>	
		<td width= "160%" class="white">
		<ul id="tablist" class="tablist" >
		<li class="tablistitem" title='<fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>'>
		<a onclick="tab_click1('trade_tab')" class="tabA" id="trade_tab" >
		<span class="tabAspan" id="trade_tabspan"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></span>
		</a>
		</li>	
		</ul>
		</td>
		</tr>
		</table>
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="Drug_code_value" id="Drug_code_value" value="<%=Drug_code_value%>">
		</form>
  <script>
<% if(mode.equals("2")) { %>
trade_tab.click();
<% } %>
</script>

</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

