<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V230210			MMS-DM-CRF-0209.5	Namrata Charate
-----------------------------------------------------------------------------------
-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,eCommon.Common.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../../eBL/js/PkgParameter.js'></script> 
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script type="text/javascript">
	function assignValueToMainForm(obj1, obj2, obj3, obj4){
		var mfdr_YN = document.getElementById(obj1);
		var drugCat_YN = document.getElementById(obj2);
		var diagCat_YN = document.getElementById(obj3);
		var service_items_YN = document.getElementById(obj4); //V230210
		
		
		if(mfdr_YN.checked){
			parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].mul_fact_ded_rule_YN.value = "Y";
			if(drugCat_YN.checked)
				parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].drug_cat_YN.value = "Y";
			else
				parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].drug_cat_YN.value = "N";
			
			if(diagCat_YN.checked)
				parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].diag_cat_YN.value = "Y";
			else
				parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].diag_cat_YN.value = "N";
			
			//V230210
			if(service_items_YN.checked)
				parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].service_items_YN.value = "Y";
			else
				parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].service_items_YN.value = "N";
		}else{
			parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].mul_fact_ded_rule_YN.value = "N";
			parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].drug_cat_YN.value = "N";
			parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].diag_cat_YN.value = "N";
			parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].service_items_YN.value = "N"; //V230210
			
		}
		parent.parent.parent.BLColorIndctrDtlsFrame.document.forms[0].is_mul_fact_ded_rule_mod.value = "Y";
		
	}
	
	
	function fnEnableDisableDrugDiagatServ(obj,dest1,dest2,dest3){
		var destBox1 = document.getElementById(dest1);
		var destBox2 = document.getElementById(dest2);
		var destBox3 = document.getElementById(dest3);
		
		if(obj.checked){
			destBox1.disabled = false;
			destBox2.disabled = false;
			destBox3.disabled = false;
			
		}
		else{
			destBox1.checked = '';
			destBox2.checked = '';
			destBox3.checked = '';
			destBox1.disabled = true;
			destBox2.disabled = true;
			destBox3.disabled = true;
		}
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	boolean isMFDRApplicableForSite = false; 
	String mul_fact_ded_rule_YN = "N";
	String drug_cat_YN = "N";
	String diag_cat_YN = "N";
	String service_items_YN = "N";  //V230210
	String disabled = "";
	try
	{	
		try
		{
			isMFDRApplicableForSite = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_MULTI_FACT_DED_RULE");	
		}catch(Exception e){
			System.err.println("Exception while checking isMFDRApplicableForSite:" + isMFDRApplicableForSite);
			e.printStackTrace();
		}	
		mul_fact_ded_rule_YN = request.getParameter("mul_fact_ded_rule_YN");
		if(mul_fact_ded_rule_YN == null) mul_fact_ded_rule_YN = "N";
		drug_cat_YN = request.getParameter("drug_cat_YN");
		if(drug_cat_YN == null) drug_cat_YN = "N";
		diag_cat_YN = request.getParameter("diag_cat_YN");
		if(diag_cat_YN == null) diag_cat_YN = "N";
		System.err.println("mul_fact_ded_rule_YN:"+mul_fact_ded_rule_YN);
		service_items_YN = request.getParameter("service_items_YN");  //V230210
		if(service_items_YN == null) service_items_YN = "N";       //V230210               
		
%>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onLoad="assignValueToMainForm('mul_fact_ded_rule_YN','drug_cat_YN','diag_cat_YN','service_items_YN')">
	<form name='BLParamInsPolyDefn' id='BLParamInsPolyDefn' >
	<table>
	<tr>
		<td  class="label" width="50%"><fmt:message key="eBL.MultiFactorDeductibleRule.label" bundle="${bl_labels}"/></td>
		
	<td  class='fields' width="60%">
		<input type="checkbox" name="mul_fact_ded_rule_YN" id="mul_fact_ded_rule_YN" <%=mul_fact_ded_rule_YN.equals("Y")?"checked ":""%> value="<%=mul_fact_ded_rule_YN%>" 
		onClick="assignValueToMainForm('mul_fact_ded_rule_YN','drug_cat_YN','diag_cat_YN','service_items_YN');fnEnableDisableDrugDiagatServ(this,'drug_cat_YN','diag_cat_YN','service_items_YN');" <%=isMFDRApplicableForSite ? "" : "disabled" %>>
	</td>
	</tr>
	
	<tr>
		<td style="padding-left:30px;" class="label" width="40%"><fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></td>	
		
	<td  style="padding-left:30px;" class='fields' width="60%">
		<input type="checkbox" name="drug_cat_YN" id="drug_cat_YN"  <%=disabled%> <%=mul_fact_ded_rule_YN.equals("Y")? "":"disabled" %> <%=drug_cat_YN.equals("Y")?"checked ":""%>  value="<%=drug_cat_YN%>" onClick="assignValueToMainForm('mul_fact_ded_rule_YN','drug_cat_YN','diag_cat_YN','service_items_YN');" >
	</td>
	</tr>
	
	<tr>
		<td  style="padding-left:30px;" class="label" width="40%"><fmt:message key="eBL.DiagnosisCategory.label" bundle="${bl_labels}"/></td>	
	<td  style="padding-left:30px;" class='fields' width="60%">
		<input type="checkbox" name="diag_cat_YN" id="diag_cat_YN"  <%=disabled %> <%=mul_fact_ded_rule_YN.equals("Y")? "":"disabled" %> <%=diag_cat_YN.equals("Y")?"checked ":""%>  value="<%=diag_cat_YN%>" onClick="assignValueToMainForm('mul_fact_ded_rule_YN','drug_cat_YN','diag_cat_YN','service_items_YN');" >
	</td>
	
	</tr>
	<!-- V230210 -->
	<tr>
		<td  style="padding-left:30px;" class="label" width="40%"><fmt:message key= "eBL.ServicesandItem.label" bundle="${bl_labels}"/></td>		
	<td  style="padding-left:30px;" class='fields' width="60%">
		<input type="checkbox" name="service_items_YN" id="service_items_YN" id="service_items_YN" <%=disabled %> <%=mul_fact_ded_rule_YN.equals("Y")? "":"disabled" %> <%=service_items_YN.equals("Y")?"checked ":""%>  value="<%=service_items_YN%>" onClick="assignValueToMainForm('mul_fact_ded_rule_YN','drug_cat_YN','diag_cat_YN','service_items_YN');" >
	</td>
	
	</tr>
	
</table>

</form>	
</body>
</html>
<%
	}
	catch(Exception e)
	{
		System.out.println("Exception from BLParamInsPolyDefn.jsp :"+e);
		e.printStackTrace();
	}
	finally
	{
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con);
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

