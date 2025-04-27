<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230210								MMS-DM-CRF-0209.5			Namrata Charate
*/ %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String params	= request.getQueryString() == null ? "" : request.getQueryString();
	System.err.println("Params in rule tab are: "+params);
	String mode	= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String cat_type = request.getParameter("cat_type") == null ? "" : request.getParameter("cat_type");
//	String cat_code = request.getParameter("cat_code") == null ? "" : request.getParameter("cat_code");;
	
	String drugCatTab_YN = "N";
	String diagCatTab_YN = "N";
	String ServicesAndItemsCatTab_YN = "N";  //V230210
	String disabled = "";
	String deduct_Cat = "";
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	String facility_id = (String)session.getAttribute("facility_id");
	String last_link = "";		
	try{
			
		con = ConnectionManager.getConnection(request);
		
		String qry_MFDRMandYN = "select NVL(MFDR_DRUG_CAT_APPL_YN,'N') MFDR_DRUG_CAT_APPL_YN, NVL(MFDR_DIAG_CAT_APPL_YN,'N') MFDR_DIAG_CAT_APPL_YN ,NVL(MFDR_SERV_ITEM_CAT_APPL_YN,'N') MFDR_SERV_ITEM_CAT_APPL_YN from bl_parameters where OPERATING_FACILITY_ID = '"+facility_id+"'";
	
		pstmt = con.prepareStatement(qry_MFDRMandYN);
		rst = pstmt.executeQuery();
					
		if(rst != null){
			while(rst.next()) {
				drugCatTab_YN = rst.getString("MFDR_DRUG_CAT_APPL_YN");
				diagCatTab_YN = rst.getString("MFDR_DIAG_CAT_APPL_YN");
				ServicesAndItemsCatTab_YN = rst.getString("MFDR_SERV_ITEM_CAT_APPL_YN");    //V230210
				}
			}
	//	System.err.println("Value of MFDR is: "+MFDRMandYN);
		System.err.println("Value of drugCatTab_YN is: "+drugCatTab_YN);
		System.err.println("Value of diagCatTab_YN is: "+diagCatTab_YN);
		System.err.println("Value of ServicesAndItemsCatTab_YN is: "+ServicesAndItemsCatTab_YN);  //V230210
		//V221017
		}catch(Exception e){
			System.err.println("Exception is: "+e);
		}finally{
			if(rst !=null) rst.close();
			if(pstmt !=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con);
		}
		
		if(diagCatTab_YN.equals("Y"))
			last_link = "DiagnosisCategoryDetails";
		else if(drugCatTab_YN.equals("Y"))
			last_link = "DrugCategoryDetails";
		else if(ServicesAndItemsCatTab_YN.equals("Y"))     //V230210
			last_link = "ServicesAndItemsCategoryDetails";    //V230210
		else
			last_link = "";
		
		if(cat_type.equals("2"))
			deduct_Cat = "DrugCategoryDetails";
		else if(cat_type.equals("1"))
			deduct_Cat = "DiagnosisCategoryDetails";
		else if(cat_type.equals("3"))                     //V230210
			deduct_Cat = "ServicesAndItemsCategoryDetails";     //V230210
		else
			deduct_Cat = "";
		
		System.err.println("last_link: "+last_link);
		System.err.println("deduct Category is: "+deduct_Cat); 
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eBL/js/BLMultiFactorDeductRule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="fnLoadTabDtls();" >
<form name="frmMultiFactorDeductRuleTab" id="frmMultiFactorDeductRuleTab"  >
<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
				<%if(diagCatTab_YN.equals("N"))
					disabled = "disabled";
				else
					disabled="";
				%>
				<li class="tablistitem" title='Diagnosis Category' <%=disabled%>>
				<a <%=disabled%> onclick="fnShowMainTabDetails('DiagnosisCategoryDetails')" class="tabA" id="DiagnosisCategoryDetails">
					<span class="tabAspan" id="DiagnosisCategoryDetailsspan">
						<fmt:message key="eBL.DiagnosisCategory.label" bundle="${bl_labels}"/>
					</span>
				</a>
				</li>
				<%if(drugCatTab_YN.equals("N"))
					disabled = "disabled";
				else
					disabled="";
				%>
				<!-- V221128 -->
				<li class="tablistitem" title='Drug Category'>
				<a <%=disabled%> onclick="fnShowMainTabDetails('DrugCategoryDetails')" class="tabA" id="DrugCategoryDetails"  >
					<span class="tabAspan" id="DrugCategoryDetailsspan">
						<fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/>
					</span>
				</a>
				</li>
				<!-- V230210 starts  -->
				<%if(ServicesAndItemsCatTab_YN.equals("N"))
					disabled = "disabled";
				else
					disabled="";
				%>
				<li class="tablistitem" title='Services and Item'>
				<a <%=disabled%> onclick="fnShowMainTabDetails('ServicesAndItemsCategoryDetails')" class="tabA" id="ServicesAndItemsCategoryDetails"  >
					<span class="tabAspan" id="ServicesAndItemsCategoryDetailsspan">
						<fmt:message key="eBL.ServicesandItem.label" bundle="${bl_labels}"/>
					</span>
				</a>
				</li> <!-- V230210 ends  -->
				
		</ul>
	</td>
</tr>
<input type='hidden' name='last_link' id='last_link' value="<%= last_link %>"/>
<input type='hidden' name='mode' id='mode' value="<%=mode%>" />
<!-- <input type='hidden' name='cat_type' id='cat_type' value="<%=cat_type%>" /> -->
<input type='hidden' name='prevTabObj' id='prevTabObj' value="" />
<input type="hidden" name="params" id="params" value=<%=params%>>
<input type="hidden" name="deduct_Cat" id="deduct_Cat" value=<%=deduct_Cat%>>
</table>
<script>
changeMainTabClass("DiagnosisCategoryDetails",parent.MultiFactorDeductRuleTab)
</script> 
</form>
</body>
</html>

