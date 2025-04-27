<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
 1           V210211            12033       AMS-CRF-00249            Ram kumar S
*/%>


<%@page import="java.util.Iterator"%>
<%@page import="eBL.BLFinDtlsBGPayerBean"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="eBL.Common.BlRepository"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%!
private String decodeParam(String input){
	String output = "";
	if(input!=null){
		output = URLDecoder.decode(input);
	}
	return output;
}

private String checkForNull(String inputString) {
		if(inputString == null || "null".equals(inputString)){
			inputString = "";
		}
		return inputString;
}
%>
<%request.setCharacterEncoding("UTF-8"); 
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String selection = request.getParameter("selection");
String blngGroup = request.getParameter("blngGroup");
String payerCode = request.getParameter("payerCode");
String payer = request.getParameter("payer");
String policy = request.getParameter("policy");
String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");

String patient_id = request.getParameter("patient_id");
String episode_type = request.getParameter("episode_type");
String function_id = request.getParameter("function_id");
String blnggrp = request.getParameter("blnggrp");
String ageVale = request.getParameter("ageVal");//Added Against V210211
String encounter_date = request.getParameter("encounter_date");
String citizen_yn = request.getParameter("citizen_yn");
String ext_blng_grp = request.getParameter("ext_blng_grp");

String selectClause = "";
String whereClause = "";
String finalQuery = "";
String payerHdnVal = "";
String patientClass = "";

BLFinDtlsBGPayerBean bgPayerBean = null;

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rst = null;
%>
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eBL/js/BLFinDtlsBGPayerLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
$(document).ready(function(){
	
	$('.ancTag').click(function(){
		//var indx = this.rownum;
		var indx = $(this).data('rownum');
		var billingGroup = $('#blngHdn_'+indx).val();
		//parent.window.returnValue = escape(billingGroup);
		//parent.window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = escape(billingGroup);
    
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();
	});
	
	var selection = '<%=selection%>';
	if(selection == 'B'){
		var totalCnt = $('#totalCnt').val();
		if(totalCnt == 1){
			$('.ancTag').click();
		}
	}
});
</script>
<style type="text/css">
div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 125px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}

table {
	width: 95%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120px;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
TD.LABEL_LOCAL
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: RIGHT;
  /*TEXT-ALIGN: RIGHT;*/
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}
</style>
</head>
<body>
<form action="">
	<%
	int cnt = 0;
	try{
	con = ConnectionManager.getConnection(request);
	blngGroup = decodeParam(blngGroup);
	payerCode = decodeParam(payerCode);
	payer = decodeParam(payer);
	policy = decodeParam(policy);
	
	if("B".equals(selection)){
		patient_id = decodeParam(patient_id);
		episode_type = decodeParam(episode_type);
		function_id = decodeParam(function_id);
		blnggrp = decodeParam(blnggrp);
		encounter_date = decodeParam(encounter_date);
		citizen_yn = decodeParam(citizen_yn);
		ext_blng_grp = decodeParam(ext_blng_grp);
		ageVale=decodeParam(ageVale);//Added Against V210211
		if(ageVale == null) ageVale="";//Added Against V210211
		
		HashMap values = new HashMap();
		values.put("locale",locale);
		values.put("facility_id",facility_id);
		values.put("patient_id",patient_id);
		values.put("episode_type",episode_type);
		values.put("function_id",function_id);
		values.put("blnggrp",blnggrp);
		values.put("encounter_date",encounter_date);
		values.put("citizen_yn",citizen_yn);
		values.put("ext_blng_grp",ext_blng_grp);
		values.put("AgeValidation",ageVale);  //Added Against V210211
		selectClause = BlRepository.getBlKeyValue("SQL_BL_BLNG_GRP_LKUP",values,"BGLKUP_BG_PAYER");
								
		//whereClause = " AND   UPPER (short_desc) like UPPER('"+blngGroup+"%') ";
		whereClause = "";
		finalQuery = selectClause+whereClause;
		pstmt = con.prepareStatement(finalQuery);
		pstmt.setString(1,blngGroup+"%");
		rst = pstmt.executeQuery();
		if(rst!=null){
		%>

			<table class='grid' border='1' width='95%' cellpadding='3' border='1'  cellspacing=0 align="center" id='tblResults'>
			<div id='tableContainer'> 
			<thead>
			<tr>
				<td class='COLUMNHEADER' width='40%' nowrap>
					<fmt:message bundle="${common_labels }" key="Common.description.label"></fmt:message>
				</td>
				<td class='COLUMNHEADER' width='20%' nowrap>
					<fmt:message bundle="${common_labels }" key="Common.code.label"></fmt:message>
				</td>
				<td  class='COLUMNHEADER' width='40%' nowrap>
					<fmt:message bundle="${bl_labels }" key="eBL.EXPLANATORY_NOTE.label"></fmt:message>
				</td>
			</tr>
			</thead>
			 	
			<tbody>
			<%
			cnt=0;
			String hdnValue="";
			while(rst.next()){ 
				cnt++;
				hdnValue = "";
				hdnValue = 	checkForNull(rst.getString("blng_grp_id"))+"^~^"+
						checkForNull(rst.getString("srt_desc"))+"^~^"+
						checkForNull(rst.getString("dtl_desc"))+"^~^"+
						checkForNull(rst.getString("cap_ref_src_yn"))+"^~^"+
						checkForNull(rst.getString("ref_src_mn_mand_yn"))+"^~^"+
						checkForNull(rst.getString("ref_src_sb_mand_yn"))+"^~^"+
						checkForNull(rst.getString("currency_code"))+"^~^"+
						checkForNull(rst.getString("currency_desc"))+"^~^"+
						checkForNull(rst.getString("pr_payer_employer_id_mand_yn"))+"^~^"+
						checkForNull(rst.getString("package_yn"))+"^~^"+
						checkForNull(rst.getString("pkg_avail_yn"))+"^~^";
			%>
			<tr>
				<td class='label' nowrap>
					<a href='#' class='ancTag' data-rownum='<%=cnt%>'>
						<span id='blngGrp_<%=cnt %>'><%=rst.getString("srt_desc") %></span>
					</a>
				</td>
				<td class='label' nowrap>
					<span id='blngGrpCode_<%=cnt %>'><%=rst.getString("blng_grp_id") %></span>
				</td>
				<td class='label' nowrap>
					<span id='blngGrpExpl_<%=cnt %>'><%=rst.getString("dtl_desc") %></span>
				</td>
				<input type='hidden' name='blngHdn_<%=cnt %>' id='blngHdn_<%=cnt %>' id='blngHdn_<%=cnt %>' value='<%=hdnValue%>'>
			</tr>
			<%} %>
				</tbody>
				</div>
				</table>
		<%}
	}
	else if("P".equals(selection)){
		int start = 0 ;
		int end = 0 ;
		int i=1;
		
		String from = checkForNull(request.getParameter("from"));
		String to = checkForNull(request.getParameter("to"));
		
		
		
		
		if ( from.length()== 0 )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		if ( to.length()==0)
		  	end = 20 ;
		else
			end = Integer.parseInt( to ) ;
		
		patient_id = decodeParam(patient_id);
		episode_type = decodeParam(episode_type);
		function_id = decodeParam(function_id);
		blnggrp = decodeParam(blnggrp);
		encounter_date = decodeParam(encounter_date);
		citizen_yn = decodeParam(citizen_yn);
		ext_blng_grp = decodeParam(ext_blng_grp);
		
		//Convert Episode Type to Patient Class
		if("O".equals(episode_type)){
			patientClass = "OP";
		}
		else if("I".equals(episode_type)){
			patientClass = "IP";
		}
		else if("D".equals(episode_type)){
			patientClass = "DC";		
		}
		else if("E".equals(episode_type)){
			patientClass = "EM";
		}
		else if("R".equals(episode_type)){
			patientClass = "XT";
		}
		BLFinDtlsBGPayerBean callingBean = new BLFinDtlsBGPayerBean();
		LinkedHashMap bgPayerMap = callingBean.getPayerDetails(facility_id, blngGroup, payer, payerCode, policy, patientClass, start, end);
		int totalRecords = 0;
		if(!bgPayerMap.isEmpty()){
			if(bgPayerMap.containsKey("totalRecords")){
				totalRecords =  (Integer) bgPayerMap.get("totalRecords");
				bgPayerMap.remove("totalRecords");
			}
		}
		/*selectClause = "select hdr.blng_grp_id, "+
		        "(select short_desc from BL_BLNG_GRP blng_grp where blng_grp_id = hdr.blng_grp_id) billing_desc, "+
		        "hdr.CUST_GROUP_CODE, "+ 
		        "decode(hdr.CUST_GROUP_CODE,'**','All Payer Group', "+
		            "(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, "+ 
		        "hdr.CUST_CODE, "+ 
		        "decode(hdr.CUST_CODE,'**','All Payer', "+
		            "(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, "+ 
		        "hdr.POLICY_TYPE_CODE, (select pol.long_desc policy_type from bl_ins_policy_types pol "+ 
		             "where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )  policy_type "+
				"from BL_PAYERS_PRIORITY_BY_BG hdr ";
		
		whereClause = "where hdr.operating_facility_id = ? ";
		if(!"".equals(blngGroup)){
			whereClause += " and hdr.blng_grp_id = '"+blngGroup+"' ";
		}
		if(!"".equals(payerCode)){
			whereClause += " and hdr.cust_group_code = '"+payerCode+"' ";		
		}
		if(!"".equals(payer)){
			whereClause += " and hdr.cust_code = '"+payer+"' ";
		}
		if(!"".equals(policy)){
			whereClause += " and hdr.policy_type_code = '"+policy+"' ";
		}
		
		finalQuery = selectClause+whereClause;
		pstmt = con.prepareStatement(finalQuery);
		pstmt.setString(1, facility_id);
		rst = pstmt.executeQuery();*/
		
		
		HashMap values = new HashMap();
		values.put("locale",locale);
		values.put("facility_id",facility_id);
		values.put("patient_id",patient_id);
		values.put("episode_type",episode_type);
		values.put("function_id",function_id);
		values.put("blnggrp",blnggrp);
		values.put("encounter_date",encounter_date);
		values.put("citizen_yn",citizen_yn);
		values.put("ext_blng_grp",ext_blng_grp);
		selectClause = BlRepository.getBlKeyValue("SQL_BL_BLNG_GRP_LKUP",values,"BGLKUP");
								
		whereClause = " AND   blng_grp_id ='"+blngGroup+"' ";
		
		finalQuery = selectClause+whereClause;
		pstmt = con.prepareStatement(finalQuery);
		rst = pstmt.executeQuery();
		if(rst !=null && rst.next()){
			payerHdnVal = 	checkForNull(rst.getString("blng_grp_id"))+"^~^"+
					checkForNull(rst.getString("srt_desc"))+"^~^"+
					checkForNull(rst.getString("dtl_desc"))+"^~^"+
					checkForNull(rst.getString("cap_ref_src_yn"))+"^~^"+
					checkForNull(rst.getString("ref_src_mn_mand_yn"))+"^~^"+
					checkForNull(rst.getString("ref_src_sb_mand_yn"))+"^~^"+
					checkForNull(rst.getString("currency_code"))+"^~^"+
					checkForNull(rst.getString("currency_desc"))+"^~^"+
					checkForNull(rst.getString("pr_payer_employer_id_mand_yn"))+"^~^"+
					checkForNull(rst.getString("package_yn"))+"^~^"+
					checkForNull(rst.getString("pkg_avail_yn"))+"^~^";
		}
		//
		if(!bgPayerMap.isEmpty()){
			
			
			if ( !(start <= 1) )
				out.println("<a href='javascript:movePrevthis("+start+","+end+")'   text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if(totalRecords > end)
				out.println("<a id='nextvalue' href='javascript:moveNextthis("+start+","+end+")'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		%>
			
			<table class='grid' border='1' width='95%' cellpadding='3'  cellspacing=0 align="center" id='tblResults'>
				<div id='tableContainer'> 
				<thead>
				<tr>
					<td width='20%' class='COLUMNHEADER' nowrap>
						<fmt:message bundle="${bl_labels }" key="eBL.BillingGroup.label"></fmt:message>
					</td>
					<td width='20%' class='COLUMNHEADER' nowrap>
						<fmt:message bundle="${bl_labels }" key="eBL.PAYER_GROUP.label"></fmt:message>
					</td>
					<td width='20%' class='COLUMNHEADER' nowrap>
						<fmt:message bundle="${bl_labels }" key="eBL.PAYER.label"></fmt:message>
					</td>
					<td width='20%' class='COLUMNHEADER' nowrap>
						<fmt:message bundle="${bl_labels }" key="eBL.POLICY.label"></fmt:message>
					</td>
					<td width='20%' class='COLUMNHEADER' nowrap>
						<fmt:message bundle="${common_labels }" key="Common.priority.label"></fmt:message>
					</td>
				</tr>
				</thead>
				<tbody style="height: 20px;">
				<%
				cnt=0;
				for (Iterator iterator = bgPayerMap.keySet().iterator(); iterator.hasNext();) {
					Integer keyValue = (Integer) iterator.next();
					bgPayerBean = (BLFinDtlsBGPayerBean) bgPayerMap.get(keyValue);
					cnt++;
				%>
				<tr>
					<td class='label' nowrap>
						<a href='#' class='ancResults' data-rownum='<%=cnt%>'>
							<span id='billing_<%=cnt %>'>
								<%=checkForNull(bgPayerBean.getBlngGrpDesc()) %>
							</span>
						</a>
						<input type='hidden' name='billingCode_<%=cnt %>' id='billingCode_<%=cnt %>' id='billingCode_<%=cnt %>' value='<%=checkForNull(bgPayerBean.getBlngGrpCode()) %>'>
					</td>
					<td class='label' nowrap>
						<span id='payerGroup_<%=cnt %>'>
							<%=checkForNull(bgPayerBean.getCustGrpDesc()) %>
						</span>
						<input type='hidden' name='payerGroupCode_<%=cnt %>' id='payerGroupCode_<%=cnt %>' id='payerGroupCode_<%=cnt %>' value='<%=checkForNull(bgPayerBean.getCustGrpCode()) %>'>
					</td>
					<td class='label' nowrap>
						<span id='payer_<%=cnt %>'>
							<%=checkForNull(bgPayerBean.getCustDesc()) %>
						<span id='billing_<%=cnt %>'>
						<input type='hidden' name='payerCode_<%=cnt %>' id='payerCode_<%=cnt %>' id='payerCode_<%=cnt %>' value='<%=checkForNull(bgPayerBean.getCustCode()) %>'>
					</td>
					<td class='label' nowrap>
						<span id='policy_<%=cnt %>'>
							<%=checkForNull(bgPayerBean.getPolicyDesc()) %>
						</span>
						<input type='hidden' name='policyCode_<%=cnt %>' id='policyCode_<%=cnt %>' id='policyCode_<%=cnt %>' value='<%=checkForNull(bgPayerBean.getPolicyCode()) %>'>						
					</td>
					<td class='label' nowrap>
						<span id='priority_<%=cnt %>'>
							<%=checkForNull(bgPayerBean.getPriority()) %>
						</span>
					</td>
				</tr>
				<%} %>
					</table>
		<%}
	}
	
}
catch(Exception e){
	System.err.println("Exception in getting BLFinDtlsBGPayerResults -> "+e);
}
finally{
	ConnectionManager.returnConnection(con);
}


%>
<input type='hidden' name='payerHdnVal' id="payerHdnVal" value='<%=payerHdnVal%>'>
<input type='hidden'  name='totalCnt' id='totalCnt' value='<%=cnt%>'>


<input type='hidden' name='blngGroupCode' id="blngGroupCode" value='<%=blngGroup%>'>
<input type='hidden'  name='payerGroupCode' id='payerGroupCode' value='<%=payerCode%>'>
<input type='hidden' name='payerCode' id="payerCode" value='<%=payer%>'>
<input type='hidden'  name='policyCode' id='policyCode' value='<%=policy%>'>
<input type='hidden' name='patient_id' id="patient_id" value='<%=patient_id%>'>
<input type='hidden'  name='episode_type' id='episode_type' value='<%=episode_type%>'>

<input type='hidden'  name='ext_blng_grp' id='ext_blng_grp' value='<%=ext_blng_grp%>'>
<input type='hidden' name='function_id' id="function_id" value='<%=function_id%>'>
<input type='hidden'  name='blnggrp' id='blnggrp' value='<%=blnggrp%>'>
<input type='hidden'  name='ageVale' id='ageVale' value='<%=ageVale%>'><!-- Added Against V210211 -->
<input type='hidden' name='encounter_date' id="encounter_date" value='<%=encounter_date%>'>
<input type='hidden'  name='citizen_yn' id='citizen_yn' value='<%=citizen_yn%>'>
</form>
</body>
	</TBODY>	
	
	</div>


</html>

