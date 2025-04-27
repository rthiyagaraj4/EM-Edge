<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
23-Oct-2012      100           	Karthikeyan.K       created
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page    import ="eBL.*,eBL.Common.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<%-- JSP Page specific a8ttributes end --%>
<script>
	$(document).ready(function () {		
		$("#exportExcelButton").click(function(){	
			window.open('../../eBL/jsp/BLPkgPriceQueryDownloadExcelFile.jsp?jobId='+$("#jobIdSelected").val() ,'_top');
		 });
		
	});
</script>
<%!
	public String checkNull(String str){
		if(str==null || "null".equals(str)){
			return "";
		}
		return str;
	}
	public String formatDate(String inputDate){
		if(inputDate==null || inputDate.equals("")){
			return "";
		}
		else
		{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Timestamp inputTimeStamp = null;
		String outputDate=inputDate;
		long longTimeStamp = 0;
		inputTimeStamp = Timestamp.valueOf(inputDate);
		longTimeStamp = inputTimeStamp.getTime();
		outputDate=sdf.format(longTimeStamp);
		return outputDate;	
		}
	}
%>

<%
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	String type=checkNull(request.getParameter("type"));
	if(type.equals("")) type="withouterror";
	String jobId=checkNull(request.getParameter("jobId"));
	try {
			con = ConnectionManager.getConnection(request);
			StringBuffer strSql = new StringBuffer();		
			StringBuffer strSql_disc = new StringBuffer();
			if(type.equals("withouterror")){
				System.err.println("69,inside withouterror");
				strSql.append(BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITHOUT_ERROR_PRICE"));
				
				strSql_disc.append(BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITHOUT_ERROR_DISC"));
			}
			else if(type.equals("witherror")){
				System.err.println("75,inside else if withouterror");
				strSql.append(BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_PRICE"));
				
				strSql_disc.append(BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_DISC"));
			}

		if(!jobId.equals("")){
			System.err.println("82,inside jobid not equals to null");
			//strSql.append(" and req.JOB_NO = "+jobId );
			strSql.append("AND (req.operating_facility_id,req.session_id,req.pgm_date,req.user_id) in (select  operating_facility_id,session_id,pgm_date,user_id from bl_package_price_updtn_req  where job_no  = "+jobId+" )");
		}
		else if(jobId.equals("")){
			System.err.println("87,inside else if jobid not equals to null");
			strSql.append(" and req.job_no  = '' ");			
		}
		
		if(!jobId.equals("")){
			System.err.println("93,inside jobid not equals to null");
			strSql_disc.append("AND (req.operating_facility_id,req.session_id,req.pgm_date,req.user_id) in (select  operating_facility_id,session_id,pgm_date,user_id from bl_package_price_updtn_req  where job_no  = "+jobId+" )");
		}
		else if(jobId.equals("")){
			System.err.println("97,inside else if jobid not equals to null");
			strSql_disc.append(" and req.job_no  = '' ");
		}
		
		if(type.equals("witherror")){
			System.err.println("102,inside witherror");
			strSql.append(" union "+BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_PRICE_REQ"));
			
			strSql_disc.append(" union "+BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_DISC_REQ"));
			
			if(!jobId.equals("")){
				System.err.println("108,inside not equals witherror");
				strSql.append(" and req.job_no  = "+jobId+" ");
				strSql_disc.append(" and req.job_no  = "+jobId+" ");
			}
			else if(jobId.equals("")){
				System.err.println("113,inside not equals witherr");
				strSql.append(" and req.job_no  = '' ");
				strSql_disc.append(" and req.job_no  = '' ");				
			}
			
			strSql.append(" union "+BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_PRICE_REQ_FOR_STAR"));
			
			strSql_disc.append(" union "+BlRepository.getBlKeyValue("BL_PKG_PRICE_PROCESSED_WITH_ERROR_DISC_REQ_FOR_STAR"));
			
			if(!jobId.equals("")){
				System.err.println("124-->");
				strSql.append(" and req.job_no  = "+jobId+" ");
				strSql_disc.append(" and req.job_no  = "+jobId+" ");
			}
			else if(jobId.equals("")){
				System.err.println("129-->");
				strSql.append(" and req.job_no  = '' ");
				strSql_disc.append(" and req.job_no  = '' ");			
			}
		}	
%>
<BODY onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
<div id="BLPkgPriceQueryResultRecDiv" STYLE="width:100%; height:120; overflow: auto;"> 
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr>
		<th width='5%'><fmt:message key="Common.PackageCode.label" bundle="${common_labels}" /></th>
		<th width='10%'><fmt:message key="eBL.PackageDesc.Label" bundle="${bl_labels}" /></th>
		<th width='10%'><fmt:message key="eBL.StdCustPrice.label" bundle="${bl_labels}" /></th>
		<th width='5%'><fmt:message key="eBL.BulkPkgPrice.label" bundle="${bl_labels}" /></th>
		<th width='10%'><fmt:message key="eBL.BillingClass.Label" bundle="${bl_labels}" /></th>
		<th width='10%'><fmt:message key="eBL.PackagePriceType.label" bundle="${bl_labels}" /></th>
		<th width='5%'><fmt:message key="eBL.PercentageOrAmt.label" bundle="${bl_labels}" /></th>
		<th width='5%'><fmt:message key="eBL.MarkUpDown.label" bundle="${bl_labels}" /></th>
		<th width='5%'><fmt:message key="eBL.ROUND_OFF.label" bundle="${bl_labels}" /></th>
		<th width='5%'><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}" /></th>
		<th width='10%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}" /></th>
		<th width='10%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}" /></th>	
		<%
		if(type.equals("witherror")){%>
			<th width='10%'><fmt:message key="eBL.ErrorDesc.label" bundle="${bl_labels}" /></th>
		<% } %>			
	</tr>

<%				
		stmt = con.prepareStatement(strSql.toString());
		rs = stmt.executeQuery();	
		
		String package_code="";
		String package_desc="";
		String cust_group_code="";
		String bulk_pkg_price="";
		String blng_grp_id = "";
		String blng_class_code="";
		String std_cust_price="";	
		String amount="";
		String price_type="";		
		String mark_up_ind="";
		String round_off="";
		String round_indicator="";
		String eff_from_date="";
		String eff_to_date="";		
		String job_err_msg="";		

		while (rs.next()) {			
			System.out.println("185,inside while");			
			package_code = checkNull(rs.getString("PACKAGE_CODE"));					
// 				if(package_code=="**"){
			System.out.println("188,inside package code");
// 					bulk_pkg_price="Bulk";
// 				}
// 				else{
			System.out.println("192,inside package code");
// 					bulk_pkg_price="Package";
// 				}				
			
			bulk_pkg_price=checkNull(rs.getString("Bulk_Individual"));			
			package_desc =  checkNull(rs.getString("SHORT_DESC"));				
		//	cust_group_code =  checkNull(rs.getString("CUST_GROUP_CODE"));				
// 				if(cust_group_code==""){
// 					std_cust_price="Standard";
// 				}
// 				else{
// 					std_cust_price="Customer";
// 				}		
			
			std_cust_price= checkNull(rs.getString("Standard_Customer"));		
			blng_class_code = checkNull(rs.getString("BLNG_CLASS_CODE"));
			if(!"**".equals(blng_class_code)){
				blng_class_code = checkNull(BLHelper.fetchDescription(BlRepository.getBlKeyValue("BLPKGPRICEQUERY_BLNGCLASS_DESC"),blng_class_code,con));
			}
			
			price_type = checkNull(rs.getString("PRICE_TYPE"));
			if(price_type.equals("P")){
				price_type="Percentage";	
			}else{
				price_type="Amount";	
			}					
			amount = checkNull(rs.getString("AMOUNT_PERCENTAGE"));					
			mark_up_ind = checkNull(rs.getString("MARK_UP_IND"));				
			if(mark_up_ind.equals("D")){
				mark_up_ind="Down";	
			}				
			else if("U".equals(mark_up_ind)){
				mark_up_ind="Up";	
			}
			else{
				mark_up_ind="None";
			}
			
			round_off =checkNull( rs.getString("ROUNDING_BY_INTEGER"));				
			round_indicator = checkNull(rs.getString("ROUND_MARK_UP_IND"));							
			if(round_indicator.equals("D")){
				round_indicator="Down";	
			}
			else if("U".equals(round_indicator)){
				round_indicator="Up";	
			}	
			else{
				round_indicator="None";
			}
			
			eff_from_date = rs.getString("EFF_FROM_DATE");				
			if (eff_from_date == null)
				eff_from_date = "";
			else
				eff_from_date=formatDate(eff_from_date);					
			eff_to_date = rs.getString("EFF_TO_DATE");
			if (eff_to_date == null)
				eff_to_date = "";
			else
				eff_to_date=formatDate(eff_to_date);					
			if(type.equals("witherror")){
				job_err_msg = checkNull(rs.getString("JOB_ERROR_MESG"));
		 }				
%>
					
	<tr>
		<td class='fields'><%=package_code%>&nbsp;</td>
		<td class='fields'><%=package_desc%>&nbsp;</td>
		<td class='fields'><%=std_cust_price%> &nbsp;</td>
		<td class='fields'><%=bulk_pkg_price %>&nbsp;</td>
		<td class='fields'><%=blng_class_code %>&nbsp; </td>
		<td class='fields'><%=price_type %>&nbsp; </td>
		<td class='fields'><%=amount %>&nbsp; </td>
		<td class='fields'><%=mark_up_ind %>&nbsp;</td>
		<td class='fields'><%=round_off %>&nbsp;</td>
		<td class='fields'><%=round_indicator %>&nbsp;</td>
		<td class='fields'><%=eff_from_date %>&nbsp;</td>
		<td class='fields'><%=eff_to_date %>&nbsp;</td>
			<%
		if(type.equals("witherror")){%>
			<td class='fields'><%=job_err_msg %>&nbsp;</td>
		<% } %>	
	</tr>

		<%
		 }//endwhile
		 if (rs != null)  
			 rs.close();
		 if (stmt != null)
			stmt.close();
		%>
		</td></tr>
</table>
</div>
<br><div id="BLPkgPriceQueryResultRec2Div" STYLE="width:100%; height:120; overflow: auto;"> 
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr>
		<th width='5%'><fmt:message key="Common.PackageCode.label" bundle="${common_labels}" /></th>
		<th width='10%'><fmt:message key="eBL.PackageDesc.Label" bundle="${bl_labels}" /></th>
		<th width='10%'><fmt:message key="eBL.StdCustPrice.label" bundle="${bl_labels}" /></th>
		<th width='5%'><fmt:message key="eBL.BulkPkgPrice.label" bundle="${bl_labels}" /></th>	
		<th width='10%'><fmt:message key="eBL.BillingGroupId.label" bundle="${bl_labels}" /></th>
		<th width='10%'><fmt:message key="eBL.BillingClass.label" bundle="${bl_labels}" /></th>
		<th width='10%'><fmt:message key="eBL.RevisedDiscountValue.label" bundle="${bl_labels}" /></th>
		<th width='5%'><fmt:message key="eBL.RevisedDiscountType.label" bundle="${bl_labels}" /></th>
		<th width='10%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}" /></th>
		<th width='10%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}" /></th>	
	<%if(type.equals("witherror")){%>
		<th width='10%'><fmt:message key="eBL.ErrorDesc.label" bundle="${bl_labels}" /></th>
	<% } %>	
	</tr>
	<%
	//stmt = con.prepareStatement(strSql.toString());
	stmt = con.prepareStatement(strSql_disc.toString());	
	rs = stmt.executeQuery();
	
	job_err_msg="";
	while (rs.next()) {		
		System.out.println(" 315,sql: Inside while");
		package_code = checkNull(rs.getString("PACKAGE_CODE"));				
		package_desc =  checkNull(rs.getString("SHORT_DESC"));	
		std_cust_price= checkNull(rs.getString("Standard_Customer"));	
		bulk_pkg_price=checkNull(rs.getString("Bulk_Individual"));	
		blng_class_code = checkNull(rs.getString("BLNG_CLASS_CODE"));
		blng_grp_id = checkNull(rs.getString("BLNG_GRP_ID"));
		
		if(!"**".equals(blng_class_code)){
			System.out.println("324,sql: Inside while");
			blng_class_code = checkNull(BLHelper.fetchDescription(BlRepository.getBlKeyValue("BLPKGPRICEQUERY_BLNGCLASS_DESC"),blng_class_code,con));
		}				
		
		if(!"**".equals(blng_grp_id)){
			System.out.println("324,sql: Inside while");
			blng_grp_id = checkNull(BLHelper.fetchDescription(BlRepository.getBlKeyValue("BLPKGPRICEQUERY_BLNGGRP_DESC"),rs.getString("BLNG_GRP_ID"),con));
		}

		price_type = checkNull(rs.getString("PRICE_TYPE"));
		if(price_type.equals("P")){
			price_type="%";	
		}else{
			price_type="Amount";	
		}		
		amount = checkNull(rs.getString("AMOUNT_PERCENTAGE"));			
		eff_from_date = rs.getString("EFF_FROM_DATE");
		if (eff_from_date == null)
			eff_from_date = "";
		else
			eff_from_date=formatDate(eff_from_date);			
		eff_to_date = rs.getString("EFF_TO_DATE");
		if (eff_to_date == null)
			eff_to_date = "";
		else
			eff_to_date=formatDate(eff_to_date);			
		if(type.equals("witherror")){
			job_err_msg = checkNull(rs.getString("JOB_ERROR_MESG"));
	 }
	%>
	<tr>
		<td class='fields'><%=package_code%>&nbsp;</td>
		<td class='fields'><%=package_desc%>&nbsp;</td>
		<td class='fields'><%=std_cust_price%> &nbsp;</td>
		<td class='fields'><%=bulk_pkg_price %>&nbsp;</td>		
		<td class='fields'><%=blng_grp_id%> &nbsp;</td>
		<td class='fields'><%=blng_class_code %>&nbsp; </td>
		<td class='fields'><%=amount %>&nbsp; </td>
		<td class='fields'><%=price_type %>&nbsp; </td>		
		<td class='fields'><%=eff_from_date %>&nbsp;</td>
		<td class='fields'><%=eff_to_date %>&nbsp;</td>
	<%		if(type.equals("witherror")){%>
			<td class='fields'><%=job_err_msg %>&nbsp;</td>
	<% } %>	
	</tr>	
	<%}	%>
</table>
</div>
<br><center>
</center>
<%
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
			out.println(e.toString());
		} finally {
		if (con != null)
			ConnectionManager.returnConnection(con, request);
		}	
%>
<table border="0" width="90%" cellspacing='0' cellpadding='0' >
	<tr>
		<td  width="100%" align="right"> 
		<input type="button" id='exportExcelButton' value="Export to Excel" >
		</td>
	</tr>
</table>
<input type="hidden" id="jobIdSelected" value="<%=jobId%>">
</BODY>
</HTML>

