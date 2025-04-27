<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.io.*,java.math.*,java.net.*,java.util.*,java.text.*,com.ehis.util.*,webbeans.op.CurrencyFormat,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/RCMTransactions.js"></script>

<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		ResultSet rst1=null;

		try
		{
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			System.err.println("params IN BLRCMTransGenerateBillResult.jsp is: "+params);
			
			con=ConnectionManager.getConnection(request);
			String sql = "";
			
			String facilityId = (String)session.getAttribute("facility_id");
			String locale = (String)session.getAttribute("LOCALE");
			String called_from_dashboard_YN = request.getParameter("called_from_dashboard_YN");
			if(called_from_dashboard_YN == null || called_from_dashboard_YN.equals("")) called_from_dashboard_YN = "N";
			System.err.println(" called_from_dashboard_YN= "+called_from_dashboard_YN);
			
			String visitId = checkForNull(request.getParameter("visitId"));
			String patientId =checkForNull(request.getParameter("patientId"));
			String episodeType = checkForNull(request.getParameter("episodeType"));
			String payerGrpCode = checkForNull(request.getParameter("payer_grp_code"));
			String payerCode = checkForNull(request.getParameter("payer_code"));
			String policyTypeCode =checkForNull(request.getParameter("policy_type_code"));
			String apprDocRefNum = checkForNull(request.getParameter("apprDocRefNum"));
			String apprDocRefTypeCode = checkForNull(request.getParameter("approval_doc_ref_type_code"));
			String claimId = checkForNull(request.getParameter("claimId"));
			String StateDurFrom = checkForNull(request.getParameter("State_dur_from"));
			String StateDurTo =checkForNull(request.getParameter("State_dur_to"));
			String insuranceStatus = checkForNull(request.getParameter("insurance_Status"));
			String claims_services_level = checkForNull(request.getParameter("claims_services_level"));
			int column_count = 1;
			String payer_Group = "", payer = "", policy_type = "", visit_Dt_Admit_Dt = "";
			String checkout_Dis_Dt = "";
			String patient_Name = "", bill_Doc_Type_Code = "", bill_Number = "", bill_Net_Amount = "", approved_Amt = "", receipt_Doc_Ref_No = "";
			String remarks = "", claim_Status = "", membershipNo = "";
			int bill_tot_rec = 0;
			int appr_tot_rec = 0;
			String var = "ApprDocNum_";
			String var1 = "BillNum_";
			String disabled = "";
			String listOfApprDocNum = "";
			String filePath="";
			String pathExist="";
			String writeAccess="";
			CurrencyFormat cf1 = new CurrencyFormat();	
			boolean amountRoundOff = true;
			int noofdecimal=2;			
			
%>
<HTML>
<HEAD>
<style>
.bordered-table {
    border-collapse: collapse;
    border: 1px solid #e0e0e0;
    width: 100%;
}

.bordered-table th, .bordered-table td {
    border: 1px solid #e0e0e0;
    padding: 8px;
}

.colored-cell {
    background-color: yellow; /* Default background color */
}

.no-border td {
    border: none; /* Remove borders for cells in the selected row */
}
</style>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>
		
<script>
function handleClick(row){
	var tot_rec = document.getElementById("appr_tot_rec").value;
	var img;
	for(var i=1;i<=tot_rec;i++)
	{
		if(i == row){
			if(document.getElementById("appr_"+i).style.display=="none"){
				document.getElementById("appr_"+i).style.display = "inline";
				img = document.getElementById("gifImage_"+i);
				img.src = "../../eCommon/images/nolines_minus.gif";
			}else{
				document.getElementById("appr_"+i).style.display = "none";
				img = document.getElementById("gifImage_"+i);
				img.src = "../../eCommon/images/nolines_plus.gif";
			}
		}
		else{
			document.getElementById("appr_"+i).style.display = "none";
			img = document.getElementById("gifImage_"+i);
			img.src = "../../eCommon/images/nolines_plus.gif";
		}
	}
}

function loadBtnFrame(){
	var listOfApprDocNum = document.getElementById("listOfApprDocNum").value;
	var insuranceStatus = document.getElementById("insuranceStatus").value;
	var claims_services_level = document.getElementById("claims_services_level").value;
	var appr_tot_rec = document.getElementById("appr_tot_rec").value;
	
	if(appr_tot_rec > 0)
		parent.frames[3].document.location.href = "../../eBL/jsp/BLRCMTransResultQryBtn.jsp?listOfApprDocNum="+listOfApprDocNum+"&p_ins_status="+insuranceStatus+"&p_level_of_srch="+claims_services_level;
	
}
</script>
    
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onLoad="loadBtnFrame();" >
<form name="BLRCMTransGenerateBillRes" id="BLRCMTransGenerateBillRes" enctype="multipart/form-data">


<%
	try{
			// Query to get file path for copying uploaded doc STARTS here 
			String sqlFilePath = "select record_appr_doc_path from bl_parameters where OPERATING_FACILITY_ID = ? ";
			pstmt = con.prepareStatement(sqlFilePath);
			pstmt.setString(1,facilityId);
			
			rst = pstmt.executeQuery();
			while(rst.next())
			{
				filePath = rst.getString(1) == null ? "" : rst.getString(1);
			}
			System.out.println("filePath in jsp "+filePath);
		/*	if(rst != null) rst.close();
			if(pstmt2 != null) pstmt2.close(); 
			*/
		//	filePath = filePath.replace("\\", "/");
			System.out.println("filePath  1 "+filePath);
			String separator = System.getProperty( "file.separator" );
			File f = new File(filePath);
			if(f.exists())
			{
				pathExist="true";
				File file1 = new File(filePath+separator+System.currentTimeMillis()+".txt"); 
				try
				{
					if (file1.createNewFile())
					{
						writeAccess="true";
						file1.delete();
					}
					else
					{
						writeAccess="false";
					}
				}
				catch (IOException e)
		        {
					writeAccess="false";
		        }
			}
			else
			{
				pathExist="false";
			}
			System.out.println("eclaim filePath after:" + filePath);
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in try of BLRCMTransGenerateBillResult.jsp --"+e.toString());
			e.printStackTrace();
		}
	
	try{
		pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
			rst = pstmt.executeQuery();	
			if ( rst != null && rst.next()) {
				if(rst.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
					amountRoundOff = false;
				}
			}

			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rst = pstmt.executeQuery();	
			while(rst.next())
			{
				noofdecimal  =  rst.getInt(1);		
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in try of BLRCMTransGenerateBillResult.jsp for currency setup --"+e.toString());
			e.printStackTrace();
		}
	
	
	try
	{
		sql = "SELECT (b.APPR_DOC_REF_TYPE_CODE||'/'||b.appr_doc_ref_number) as Appr_Doc_Ref_No, COUNT (*) as total "+
				"FROM BL_CLAIM_BILL_DTL b "+
				"WHERE b.operating_facility_id = ? ";				
				
		if(!"".equals(patientId)){
			sql = sql + " and b.patient_id = nvl(?,b.patient_id) ";
		}
		
		if(!"".equals(episodeType)){
			sql = sql + " and b.EPISODE_TYPE = nvl(?,b.EPISODE_TYPE) ";
		}
		
		if(!"".equals(visitId)){
			sql = sql + " and b.encounter_id = nvl(?,b.encounter_id) ";
		}
		
		if(!"".equals(payerGrpCode))
			sql = sql + " and (b.cust_group_code = nvl(?,b.cust_group_code)) ";
		
		if(!"".equals(payerCode))
			sql = sql + " and (b.cust_code = nvl(?,b.cust_code)) ";
		
		if(!"".equals(policyTypeCode))
			sql = sql + " and (b.policy_type_code = nvl(?,b.policy_type_code)) ";
		
		if(!"".equals(apprDocRefNum))
			sql = sql + " and (b.appr_doc_ref_number = nvl(?,b.appr_doc_ref_number)) ";
		
		if(!"".equals(apprDocRefTypeCode))
			sql = sql + " and (b.APPR_DOC_REF_TYPE_CODE = nvl(?,b.APPR_DOC_REF_TYPE_CODE)) ";
		
		if(!"".equals(claimId))
			sql = sql + " and (b.claim_id = nvl(?,b.claim_id)) ";
		
		if(!"".equals(StateDurFrom) && !"".equals(StateDurTo))
			sql = sql + " and (trunc(b.doc_ref_date) between NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
				" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
				" ,'DD-MON-YYYY HH24:MI:SS'))) ";					
				
		if("C".equals(claims_services_level)){
			if(!"**".equals(insuranceStatus))
				sql = sql + " and b.claim_status = ?  ";
		}

		if("S".equals(claims_services_level)){
			sql = sql + " and exists (select 1 from bl_claim_service_dtl a "+
				" WHERE a.operating_facility_id = b.operating_facility_id "+
				"   AND a.bill_doc_type_code    = b.bill_doc_type_code "+
				"   AND a.bill_doc_num          = b.bill_doc_num ";
				
			if(!"**".equals(insuranceStatus))
				sql = sql + " and a.claim_status = ?  )";
			else
				sql = sql + ")" ;
		}
		sql = sql + "GROUP BY b.APPR_DOC_REF_TYPE_CODE,b.appr_doc_ref_number ORDER BY b.APPR_DOC_REF_TYPE_CODE,b.appr_doc_ref_number asc";
		
		pstmt = con.prepareStatement(sql);
		
		System.err.println("patientId: "+patientId);
		System.err.println("apprDocRefNum: "+apprDocRefNum);
		System.err.println("claimId: "+claimId);
		
		pstmt.setString(column_count,facilityId);
		
		if(!"".equals(patientId))
			pstmt.setString(++column_count,patientId);
		if(!"".equals(episodeType))
			pstmt.setString(++column_count,episodeType);
		if(!"".equals(visitId))
			pstmt.setString(++column_count,visitId);
		if(!"".equals(payerGrpCode))
			pstmt.setString(++column_count,payerGrpCode);
		if(!"".equals(payerCode))
			pstmt.setString(++column_count,payerCode);
		if(!"".equals(policyTypeCode))
			pstmt.setString(++column_count,policyTypeCode);
		if(!"".equals(apprDocRefNum))
			pstmt.setString(++column_count,apprDocRefNum);
		if(!"".equals(apprDocRefTypeCode))
			pstmt.setString(++column_count,apprDocRefTypeCode);
		if(!"".equals(claimId))
			pstmt.setString(++column_count,claimId);
		if(!"".equals(StateDurFrom) && !"".equals(StateDurTo)){
			pstmt.setString(++column_count,StateDurFrom);
			pstmt.setString(++column_count,StateDurTo);
		}
		if("C".equals(claims_services_level)){
			if(!"**".equals(insuranceStatus))
				pstmt.setString(++column_count,insuranceStatus);
		}if("S".equals(claims_services_level)){
			if(!"**".equals(insuranceStatus))
				pstmt.setString(++column_count,insuranceStatus);
		}
		System.err.println("Sql is: "+sql);
		
		rst = pstmt.executeQuery();		

		while ( rst.next() )
		{
			apprDocRefNum = checkForNull(rst.getString("Appr_Doc_Ref_No"));
			
			int cnt = rst.getInt("total");	
			appr_tot_rec++;
			
			if(appr_tot_rec == 1 )
				listOfApprDocNum = apprDocRefNum;
			else
				listOfApprDocNum = listOfApprDocNum + "~~" + apprDocRefNum;						
			
			System.err.println("Manivel:"+listOfApprDocNum);
			if(appr_tot_rec == 1 ){
%>	
<TABLE class='grid' border=1 width="100%" cellspacing=0 cellpadding=3 align='center'>

		<td class='columnheadercenter' width="2%"><input type="checkbox" id="checkheader" name="checkheader" id="checkheader" onclick="payerCheck(this)" value=""/></td>
		<td class='columnheadercenter'  width="5%"><fmt:message key="eBL.claim_id.label" bundle="${bl_labels}"/></td>
		<td class='columnheadercenter'  width="10%"><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/>/<fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></td>
		<td class='columnheadercenter'  width="5%"><fmt:message key="Common.encountertype.label" bundle="${common_labels}" />/<fmt:message key="Common.identification.label" bundle="${common_labels}" /></td>
		<td class='columnheadercenter'  width="6%"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/>/ <fmt:message key="Common.admit.label" bundle="${common_labels}"/><fmt:message key="Common.date.label" bundle="${common_labels}"/></td> 
		<td class='columnheadercenter'  width="6%"><fmt:message key="Common.CheckOut.label" bundle="${common_labels}" />/ <fmt:message key="eBL.Discharge.label" bundle="${bl_labels}" /></td>
		<td class='columnheadercenter'  width="7%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'  width="7%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'  width="7%"><fmt:message key="eBL.BILL_NO.label" bundle="${bl_labels}" /></td>
		<td class='columnheadercenter'  width="5%"><fmt:message key="eBL.NET_BILL_AMT.label" bundle="${bl_labels}" /></td>
		<td class='columnheadercenter'  width="5%"><fmt:message key="eBL.Approved_Amt.label" bundle="${bl_labels}" /></td>
		<td class='columnheadercenter'  width="7%"><fmt:message key="eBL.Receipt_Doc_Reference_No.label" bundle="${bl_labels}" /></td>
		<td class='columnheadercenter'  width="9%"><fmt:message key="eBL.Remarks.label" bundle="${bl_labels}" /></td>
		<td class='columnheadercenter'  width="9%"><fmt:message key="eBL.CLAIM_STATUS.label" bundle="${bl_labels}" /></td>
		<td class='columnheadercenter'  width="10%"><fmt:message key="eBL.UploadDocuments.label" bundle="${bl_labels}" /></td>	
</TABLE>	
<%
			}	
%>
<table cellpadding='2' cellspacing=0 width="100%" align="center">
		<tr>
			<td>
				<input type="checkbox" id="check_payer<%=appr_tot_rec%>" name="check_payer<%=appr_tot_rec%>" onclick="check_payer('<%=appr_tot_rec%>','<%=apprDocRefNum%>');" value="">
				
				<img src="../../eCommon/images/nolines_plus.gif" alt="GIF Image" id="gifImage_<%=appr_tot_rec%>" onclick="handleClick(<%=appr_tot_rec%>)">
				<label for="gifImage_<%=appr_tot_rec%>" onclick="handleClick(<%=appr_tot_rec%>)"><fmt:message key="eBL.approval_ref_no.label" bundle="${bl_labels}" />:<%=apprDocRefNum%></label>
				<br>
				<div id="appr_<%=appr_tot_rec%>" name="appr_<%=appr_tot_rec%>" style='display:none'>
					<input type="hidden" id="appr_Num_<%=appr_tot_rec%>" name="appr_Num_<%=appr_tot_rec%>" value="<%=apprDocRefNum%>" >
					<table align='center'  cellpadding=3 cellspacing=1  width='100%' id="panel_categories_table" name="panel_categories_table" id="panel_categories_table" class="bordered-table">
						<tr>
							<td>
				
<%			
							System.err.println("apprDocRefNum is: "+apprDocRefNum);
							try
							{
								column_count = 1;
								sql = "SELECT b.claim_id as claim_Id, b.cust_group_code as  cust_group_code,"+
										"DECODE (b.cust_group_code,'**', 'All Payer Group',(SELECT grp.long_desc FROM ar_cust_group grp WHERE "+
										"grp.cust_group_code =  b.cust_group_code)) payer_Group, "+
										"b.cust_code as cust_code,DECODE (b.cust_code,'**', 'All Payer',(SELECT cust.long_name FROM ar_customer cust WHERE "+
										"cust.cust_code = b.cust_code)) payer, "+
										"b.POLICY_TYPE_CODE as POLICY_TYPE_CODE,DECODE (b.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc FROM bl_ins_policy_types pol "+
										"where pol.policy_type_code = b.policy_type_code AND pol.operating_facility_id  = b.operating_facility_id )) policy_type, "+
										"b.episode_type as episode_Type, b.encounter_id as encounter_ID, "+
										"to_char(b.visit_adm_date_time,'dd/MM/yyyy HH24:mi:ss') as visit_Dt_Admit_Dt, "+
										"to_char(b.chkout_dis_date_time,'dd/MM/yyyy HH24:mi:ss') as checkout_Dis_Dt, "+
										"b.patient_id as patient_ID, "+
										"(SELECT patient_name FROM mp_patient WHERE patient_id = b.patient_id) patient_Name, "+
										"b.bill_doc_type_code as bill_Doc_Type_Code, "+
										"b.bill_doc_num as bill_Number, "+
										"b.bill_net_amount as bill_Net_Amount, "+
										"b.approved_amt as approved_Amt, "+
										"b.receipt_ref_num as receipt_Doc_Ref_No, "+
										"b.remarks as remarks, "+
										"b.claim_status as claim_Status, "+
										"c.LIST_ELMT_LABEL as claim_status_desc, "+
										"b.MEMBERSHIP_NO as membership_no "+
										"FROM bl_claim_bill_dtl b, sm_list_item c  "+
										"WHERE b.operating_facility_id = ? "+
										"AND b.claim_status = c.LIST_ELMT_VALUE "+
										"AND c.MODULE_ID = 'BL' "+
										"AND c.LIST_REF = 'L_INS_CLAIM_STATUS' " +
										"AND (b.appr_doc_ref_type_code||'/'||b.appr_doc_ref_number) = nvl(?,(b.appr_doc_ref_type_code||'/'||b.appr_doc_ref_number))";
										
										if("C".equals(claims_services_level)){
											if(!"**".equals(insuranceStatus))
												sql = sql + " and b.claim_status = ?  ";
										}
					 

										if("S".equals(claims_services_level)){
											sql = sql + " and exists (select 1 from bl_claim_service_dtl a "+
												" WHERE a.operating_facility_id = b.operating_facility_id "+
												"   AND a.bill_doc_type_code    = b.bill_doc_type_code "+
												"   AND a.bill_doc_num          = b.bill_doc_num ";
												
											if(!"**".equals(insuranceStatus))
												sql = sql + " and a.claim_status = ? ) ";
											else
												sql = sql + ")" ;
											
										}
								
										
										pstmt = con.prepareStatement(sql);
										pstmt.setString(column_count,facilityId);
										pstmt.setString(++column_count,apprDocRefNum);
										
										if("C".equals(claims_services_level)){
											if(!"**".equals(insuranceStatus))
												pstmt.setString(++column_count,insuranceStatus);
										}if("S".equals(claims_services_level)){
											if(!"**".equals(insuranceStatus))
												pstmt.setString(++column_count,insuranceStatus);
										}
															
										System.err.println("Sql is: "+sql);
										
										rst1 = pstmt.executeQuery();		

										while ( rst1.next() )
										{
											disabled = "disabled";
											claimId = checkForNull(rst1.getString("claim_Id"));
											payer_Group = checkForNull(rst1.getString("payer_Group"));
											payer = checkForNull(rst1.getString("payer"));
											policy_type = checkForNull(rst1.getString("policy_type"));
											payerGrpCode = checkForNull(rst1.getString("cust_group_code"));
											payerCode = checkForNull(rst1.getString("cust_code"));
											policyTypeCode = checkForNull(rst1.getString("POLICY_TYPE_CODE"));
											episodeType = checkForNull(rst1.getString("episode_Type"));
											visitId = checkForNull(rst1.getString("encounter_ID"));
											visit_Dt_Admit_Dt = checkForNull(rst1.getString("visit_Dt_Admit_Dt"));
											checkout_Dis_Dt = checkForNull(rst1.getString("checkout_Dis_Dt"));
											patientId = checkForNull(rst1.getString("patient_ID"));
											patient_Name = checkForNull(rst1.getString("patient_Name"));
											bill_Doc_Type_Code = checkForNull(rst1.getString("bill_Doc_Type_Code"));
											bill_Number = checkForNull(rst1.getString("bill_Number"));
											bill_Net_Amount = checkForNull(rst1.getString("bill_Net_Amount"));
											if(amountRoundOff) {
												bill_Net_Amount = cf1.formatCurrency(bill_Net_Amount, noofdecimal);
											} else {
												bill_Net_Amount = BLReportIdMapper.truncateUptoTwoDecimal(bill_Net_Amount, noofdecimal);	
											}
											approved_Amt = checkForNull(rst1.getString("approved_Amt"));
											if(amountRoundOff) {
												approved_Amt = cf1.formatCurrency(approved_Amt, noofdecimal);
											} else {
												approved_Amt = BLReportIdMapper.truncateUptoTwoDecimal(approved_Amt, noofdecimal);	
											}
											receipt_Doc_Ref_No = checkForNull(rst1.getString("receipt_Doc_Ref_No"));
											remarks = checkForNull(rst1.getString("remarks"));
											claim_Status = checkForNull(rst1.getString("claim_Status"));
											membershipNo = checkForNull(rst1.getString("membership_no"));
											
											if(claim_Status.equalsIgnoreCase("P") || claim_Status.equalsIgnoreCase("C")){ 
												disabled = "";
											}
											
												System.err.println("disabled is: "+disabled);
											System.err.println("insuranceStatus is: "+insuranceStatus);
									
%>	
						
						<tr id='tr_<%=bill_tot_rec %>' onClick = "loadPolicyDetails('tr_<%=appr_tot_rec %>','<%=bill_tot_rec %>')" >   
						<td	 class='label' id='td_<%=bill_tot_rec%>_0' width="2%">&nbsp;</td>
						<td	 class='label' id='td_<%=bill_tot_rec%>_1' width="5%">	<%=claimId%> &nbsp;</td> 
						<td  class='label'	id='td_<%=bill_tot_rec%>_2' width="10%">	<%=payer_Group%>/<%=payer%> &nbsp;</td> 
						<td  class='label'	id='td_<%=bill_tot_rec%>_3' width="5%"> <%=episodeType%>/<%=visitId%> &nbsp;</td> 
						<td  class='label'	id='td_<%=bill_tot_rec%>_4' width="6%"> <%=visit_Dt_Admit_Dt%> &nbsp;</td>
						<td  class='label'	id='td_<%=bill_tot_rec%>_5' width="6%"> <%=checkout_Dis_Dt%>&nbsp;</td> 
						<td  class='label'	id='td_<%=bill_tot_rec%>_6' width="7%"> <%=patientId%> &nbsp;</td> 
						<td  class='label'	id='td_<%=bill_tot_rec%>_7' width="7%"> <%=patient_Name%> &nbsp;</td> 
						<td  class='label'	id='td_<%=bill_tot_rec%>_8' width="7%">	<%=bill_Doc_Type_Code%>/<%=bill_Number%> &nbsp;</td> 
						<td  class='label'	id='td_<%=bill_tot_rec%>_9' width="5%">  <%=bill_Net_Amount%> &nbsp;</td>
						<td  class='label'	id='td_<%=bill_tot_rec%>_10' width="5%"> <%=approved_Amt%> &nbsp;</td>
						<td  class='label'	id='td_<%=bill_tot_rec%>_11' width="7%"> <%=receipt_Doc_Ref_No%> &nbsp;</td> 
						<td  class='label'	id='td_<%=bill_tot_rec%>_12' width="9%"><a href="#" name="remarks_<%=bill_tot_rec%>" id="remarks_<%=bill_tot_rec%>" onclick="callRemarkPopup('<%=bill_Doc_Type_Code%>', '<%=bill_Number%>', '<%=apprDocRefNum%>','B','');">     <%=(remarks!= null && !remarks.equals(""))?remarks:"..."%></a> &nbsp;</td> 
						<td  class='label'	id='td_<%=bill_tot_rec%>_13' width="9%"> <%=checkForNull(rst1.getString("claim_status_desc"))%></td>
						<input type="hidden" id="claimID_<%=bill_tot_rec%>" name="claimID_<%=bill_tot_rec%>" value="<%=claimId%>" >
						<input type="hidden" id="patientId_<%=bill_tot_rec%>" name="patientId_<%=bill_tot_rec%>" value="<%=patientId%>" >
						<input type="hidden" id="apprDocRefNum_<%=bill_tot_rec%>" name="apprDocRefNum_<%=bill_tot_rec%>" value="<%=apprDocRefNum%>" >
						<input type="hidden" id="billDocTypeCode_<%=bill_tot_rec%>" name="billDocTypeCode_<%=bill_tot_rec%>" value="<%=bill_Doc_Type_Code%>" >
						<input type="hidden" id="billNum_<%=bill_tot_rec%>" name="billNum_<%=bill_tot_rec%>" value="<%=bill_Number%>" >
						
						
						
						<td class='label' id='td_<%=bill_tot_rec%>_14' width="10%">
							<input type="file" name="patFile_<%=bill_tot_rec%>" id="patFile_<%=bill_tot_rec%>" <%=disabled%> value=""  size=10 maxlength=40 onchange="getFileType('<%=bill_tot_rec%>')" onkeypress="return onkeyPressEvent(event);" >
						</td>	
						<input type="hidden"   id="DocUplYN<%=bill_tot_rec%>" 				name="DocUplYN<%=bill_tot_rec%>"  			value="N" />
						<input type="hidden" id="payerGrp_<%=bill_tot_rec%>" name="payerGrp_<%=bill_tot_rec%>" value="<%=payer_Group%>" >
						<input type="hidden" id="payerGrpCode_<%=bill_tot_rec%>" name="payerGrpCode_<%=bill_tot_rec%>" value="<%=payerGrpCode%>" >
						<input type="hidden" id="payer_<%=bill_tot_rec%>" name="payer_<%=bill_tot_rec%>" value="<%=payer%>" >
						<input type="hidden" id="payerCode_<%=bill_tot_rec%>" name="payerCode_<%=bill_tot_rec%>" value="<%=payerCode%>" >
						<input type="hidden" id="policyType_<%=bill_tot_rec%>" name="policyType_<%=bill_tot_rec%>" value="<%=policy_type%>" >
						<input type="hidden" id="policyTypeCode_<%=bill_tot_rec%>" name="policyTypeCode_<%=bill_tot_rec%>" value="<%=policyTypeCode%>" >
						<input type="hidden" id="episodeType_<%=bill_tot_rec%>" name="episodeType_<%=bill_tot_rec%>" value="<%=episodeType%>" >
						<input type="hidden" id="encounterId_<%=bill_tot_rec%>" name="encounterId_<%=bill_tot_rec%>" value="<%=visitId%>" >
						<input type="hidden" id="visitAdmitDt_<%=bill_tot_rec%>" name="visitAdmitDt_<%=bill_tot_rec%>" value="<%=visit_Dt_Admit_Dt%>" >
						<input type="hidden" id="checkoutDiscDt_<%=bill_tot_rec%>" name="checkoutDiscDt_<%=bill_tot_rec%>" value="<%=checkout_Dis_Dt%>" >
						
						<input type="hidden" id="patientName_<%=bill_tot_rec%>" name="patientName_<%=bill_tot_rec%>" value="<%=patient_Name%>" >
						<input type="hidden" id="netBillAmt_<%=bill_tot_rec%>" name="netBillAmt_<%=bill_tot_rec%>" value="<%=bill_Net_Amount%>" >
						<input type="hidden" id="apprBillAmt_<%=bill_tot_rec%>" name="apprBillAmt_<%=bill_tot_rec%>" value="<%=approved_Amt%>" >
						<input type="hidden" id="receiptDocRefNum_<%=bill_tot_rec%>" name="receiptDocRefNum_<%=bill_tot_rec%>" value="<%=receipt_Doc_Ref_No%>" >
						<input type="hidden" id="billRemarks_<%=bill_tot_rec%>" name="billRemarks_<%=bill_tot_rec%>" value="<%=remarks%>" >
						<input type="hidden" id="claimStatus_<%=bill_tot_rec%>" name="claimStatus_<%=bill_tot_rec%>" value="<%=claim_Status%>" >
						<input type="hidden" id="checkedStatus_<%=bill_tot_rec%>" name="checkedStatus_<%=bill_tot_rec%>" value="N" >
						<input type="hidden" id="claimsServicesLevel_<%=bill_tot_rec%>" name="claimsServicesLevel_<%=bill_tot_rec%>" value="<%=claims_services_level%>" >
						<input type="hidden" id="membershipNo_<%=bill_tot_rec%>" name="membershipNo_<%=bill_tot_rec%>" value="<%=membershipNo%>" >
						<input type="hidden" id="fileName_<%=bill_tot_rec%>" name="fileName_<%=bill_tot_rec%>" value="" >
						
						
						</tr>
<%
						
												bill_tot_rec++;
											}
%>

							</td>
						</tr>
					</table>
				</div>	
			</td>
		</tr>
					

<%
							}catch(Exception e){
								System.err.println("Query Result Exception= "+e.toString());
							}
												
					}
			}catch(Exception e){
				System.err.println("Query Result Exception= "+e.toString());
			}
%>	
	<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='<%=facilityId%>'>
	<input type = "hidden" id = "listOfApprDocNum" name = "listOfApprDocNum" value = "<%=listOfApprDocNum%>" >	
	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
	<input type='hidden' name='prevClicked' id='prevClicked' value='N'>
	<input type='hidden' name='rowClicked' id='rowClicked' value = ''>
	<input type="hidden" name="State_dur_from" id="State_dur_from" value="<%=StateDurFrom%>">
	<input type="hidden" name="State_dur_to" id="State_dur_to" value="<%=StateDurTo%>">
	<input type = "hidden" id = "tot_rec" name = "tot_rec" value = "<%=	bill_tot_rec%>" >
	<input type = "hidden" id = "appr_tot_rec" name = "appr_tot_rec" value = "<%=	appr_tot_rec%>" >
	<input type = "hidden" id = "bill_tot_rec" name = "bill_tot_rec" value = "<%=	bill_tot_rec%>" >
	<input type = "hidden" id = "p_action_id" name = "p_action_id" value = "" >
	<input type = "hidden" id = "insuranceStatus" name = "insuranceStatus" value = "<%=insuranceStatus%>" >
	<input type = "hidden" id = "claims_services_level" name = "claims_services_level" value = "<%=claims_services_level%>" >
	<input type='hidden' name='filePath' id='filePath' id='filePath' value='<%=filePath%>'>	 
	<input type='hidden' name='pathExist' id='pathExist' value='<%=pathExist%>'>	
	<input type='hidden' name='writeAccess' id='writeAccess' value="<%=writeAccess%>">
	<input type='hidden' name='called_from_dashboard_YN' id='called_from_dashboard_YN' id='called_from_dashboard_YN' value="<%=called_from_dashboard_YN%>">
	<input type='hidden' name='qry_search_params' id='qry_search_params' id='qry_search_params' value="<%=params%>">
	
</table>

<%					
		
		if(appr_tot_rec == 0){
%>	
<Script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
parent.frames[3].document.location.href = '../../eCommon/html/blank.html';	
</script>
<%
		}
%>
<Script>checkBoxEnableDisable(this);</script>		
</form>
<%	
		}catch(Exception e){
			out.println("Exception in BLRCMTransGenerateBillResult.jsp: "+e);
			System.err.println("Exception in BLRCMTransGenerateBillResult.jsp: "+e);
		}finally{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(con,request);		
		}
%>
</body>	
	
</HTML>

