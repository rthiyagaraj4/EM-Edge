<!DOCTYPE html>
<!-- 
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1            V210504            16777	      PMG2021-COMN-CRF-0076      Ram kumar S
2								30618		  PMG2021-COMN-CRF-0076.2    Manivel N
 -->


<%@ page
	import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,  "
	contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
	
<%!private String checkForNull(String inputString) {
	return (inputString == null) ? "" : inputString;
}%>
<%!public String PkgAmtPriceFormat(String str) {
	if (str == null || str.equals("")) {
		str = "0.00";
	} else {
		str = String.format("%.2f", Float.parseFloat(str));
	}
	return str;
}%>	


<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = 	(String)session.getAttribute("LOCALE");
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
	
	int index = 0;
	
	Connection con = null;

	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;
	PreparedStatement pstmt4 = null;
	ResultSet rst4 = null;

	String patientid = request.getParameter("patientid");
	if(patientid == null) patientid = "";
	System.err.println("200--servv "+patientid);
	
	String facility_id = request.getParameter("facility_id");
	if(facility_id == null) facility_id = "";	
	
	String package_code = request.getParameter("sel_package_code");
	if(package_code == null) package_code = "";
	
	String package_seq_no = request.getParameter("sel_package_seq_no");
	if(package_seq_no == null) package_seq_no = "";
	
	String parent_pkg_serv_ind = request.getParameter("parent_pkg_serv_ind");
	if(parent_pkg_serv_ind == null) parent_pkg_serv_ind = "";
	
	String parent_pkg_serv_code = request.getParameter("parent_pkg_serv_code");
	if(parent_pkg_serv_code == null) parent_pkg_serv_code = "";
	
	int noofdecimal = Integer.parseInt(request.getParameter("noofdecimal")!=null ? request.getParameter("noofdecimal") : "2");
	
	String pkgServLmtDtlsPrivYN = request.getParameter("pkgServLmtDtlsPrivYN");
	if(pkgServLmtDtlsPrivYN == null) pkgServLmtDtlsPrivYN = "N";
	System.err.println("pkgServLmtDtlsPrivYN:"+pkgServLmtDtlsPrivYN);	
	
	String pkg_short_desc = "";
	String classval="fields";
	String pkg_service_long_desc = "";
	String pkg_service_long_des = "";
	String modifyStatus = "";

	String pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "",
			qtyFldDisabled = "", indicatorFldDisabled = "", grossNetDisabled="";	

	String eff_from_date = "";
	String eff_to_date = "";
	String package_amt = "";
	String deposit_amt = "";
	String utilized_amt = "";
	String blng_class_code = "";
	String cust_group_code = "";
	String cust_code = "";
	String cust_price = "";
	String encounter_associate_yn = "";
	String prac_name = "";
	String addl_chg_value = "";
	String operating_facility_id = "";
	String total_disc = "";
	
	String pkg_serv_ind = "";
	String pkg_serv_code = "";
	String rate_charge_ind = "";
	String order_catalog_code = "";
	int factor_rate_int = 0;//
	int qty_limit_int = 0;//
	String amt_limit_ind = "";
	int amt_limit_int = 0;//

	String incl_home_medication_yn = "";
	String incl_home_medication_yn1 = "";
	String home_med_enable_yn="";
	String home_med_enbl_disbl="";
	String replaceable_yn = "";
	String replaceable_yn1 = "";
	String daily_limit_ind = "";
	int daily_qty_limit_int;
	int daily_amt_limit_int;//
	String daily_amt_limit_gross_net = "";
	String replaceable_serv_code = "";
	String rep_serv_ord_cat_code = "";
	String refund_yn = "";
	int refund_rate_int = 0;//
	String apply_fact_for_srv_lmt_yn = "";

	int utilized_serv_qty_int = 0;//
	int utilized_serv_amt1_int = 0;//
	String auto_refund_yn1 = "";
	String split_allowed_yn = "";
	String encounter_name = "";
	String utilized_serv_qty_intg="";
	String encounter_id = "";

	String useraccess = "N";

	String episode_id = "";
	String visit_id = "";
	String episode_type = "";
	String long_desc = "";
	String factor_YN = "";
	String qty_limit = "";
	String amt_limit = "";
	String daily_qty_limit = "";
	String refund_rate = "";
	String utilized_serv_qty = "";
	String utilized_serv_amt = "";
	String auto_refund_yn = "";
	String daily_amt_limit = "";
	int utilized_serv_amt_int = 0;
	String exclude_all = "N";
	String hdn_is_newly_added_row_YN = "N";
	String hdn_row_marked_for_del = "N";
	
	String rowid = "";
	String tableid = "maintainTrtPkgDtls";
	String defaultPkgCode = "";
	String order_catalog_yn ="N";
	String across_enc_YN="";
	String defaultPkgSeq = "";
	String defaultEffFromDate = "";
	String refundchck="";
	String refndYNdisable="";
	ArrayList<String> pkgServiceDetailsCombination = new ArrayList<String>();
	String pkgDetailsCombinationString =request.getParameter("pkgDetailsCombinationString") == null ? "" :request.getParameter("pkgDetailsCombinationString");
	System.err.println("queryString->"+request.getQueryString());
	int count = 0;
	int cnt = 0, dbcnt = 0;

	boolean pkg_serv_ind_lmt=false;
	String PKG_LIMIT_IND_BY="";
	String pkg_serv_lmt_YN="N";
	boolean pkg_serv_lmt=false;
	String daily_pkg_lmt_yn="N";
	String p_daily_pkg_serv_lmt="N";
	String p_daily_pkg_serv_lmt_ind="N";
	
	String chk_exclude_all_YN = "N";
	String is_rec_mod_YN = "N";
	String exclString = "";
	String excludeAllDisabled = "";
	String excludeAllReadonly = "";
	
	
	is_rec_mod_YN = request.getParameter("is_excl_mod_YN") == null ? "N" :request.getParameter("is_excl_mod_YN");
	exclString = request.getParameter("excl_string") == null ? "N" :request.getParameter("excl_string");
	order_catalog_yn = request.getParameter("order_catalog_yn") == null ? "N" :request.getParameter("order_catalog_yn");
	across_enc_YN = request.getParameter("across_enc_YN") == null ? "N" :request.getParameter("across_enc_YN");

	pkg_serv_lmt_YN = request.getParameter("pkg_serv_lmt_YN") == null ? "N" :request.getParameter("pkg_serv_lmt_YN");
	daily_pkg_lmt_yn = request.getParameter("daily_pkg_lmt_yn") == null ? "N" :request.getParameter("daily_pkg_lmt_yn");
	p_daily_pkg_serv_lmt = request.getParameter("p_daily_pkg_serv_lmt") == null ? "" :request.getParameter("p_daily_pkg_serv_lmt");
	p_daily_pkg_serv_lmt_ind = request.getParameter("p_daily_pkg_serv_lmt_ind") == null ? "" :request.getParameter("p_daily_pkg_serv_lmt_ind");
	
	try {
			con = ConnectionManager.getConnection(request);
			HttpSession httpSession = request.getSession(false);
			
			System.err.println("pkg_serv_lmt_YN,536===>>"+pkg_serv_lmt_YN);
			if(pkg_serv_lmt_YN.equals("Y"))
			{
				try 
				{
					pstmt4 = con.prepareStatement("SELECT NVL (daily_pkg_lmt_yn, 'N') p_daily_limit_chk_yn,pkg_serv_lmt_by p_daily_pkg_serv_lmt_ind,daily_pkg_lmt_by p_daily_pkg_serv_lmt FROM bl_parameters WHERE operating_facility_id = ?");
				
					System.err.println("facility_id,395==>>"+facility_id);
					pstmt4.setString(1,facility_id); 
					rst4 = pstmt4.executeQuery() ;

					if( rst4 != null ) 
					{	
						while( rst4.next() )
						{  
							daily_pkg_lmt_yn = rst4.getString("p_daily_limit_chk_yn");							
							p_daily_pkg_serv_lmt_ind  = rst4.getString("p_daily_pkg_serv_lmt_ind");
							p_daily_pkg_serv_lmt = rst4.getString("p_daily_pkg_serv_lmt");

							if(daily_pkg_lmt_yn.equals("")){
								daily_pkg_lmt_yn="N";
							}
							if("".equals(p_daily_pkg_serv_lmt)){
								p_daily_pkg_serv_lmt="B";
							}
							if("".equals(p_daily_pkg_serv_lmt_ind)){
								p_daily_pkg_serv_lmt_ind="R";
							}
							System.err.println("daily_pkg_lmt_yn===>>"+daily_pkg_lmt_yn);
							System.err.println("p_daily_pkg_serv_lmt===>>"+p_daily_pkg_serv_lmt);
							System.err.println("p_daily_pkg_serv_lmt_ind===>>"+p_daily_pkg_serv_lmt_ind);
						}
					}
				}
				catch(Exception exe){
					exe.printStackTrace();
				}
			}
			else
			{
				indicatorFldDisabled="disabled";
				amtFldDisabled = "disabled";
				qtyFldDisabled = "disabled"; 
				grossNetDisabled="disabled";
			}
			
			System.err.println("daily_pkg_lmt_yn,577===>>"+daily_pkg_lmt_yn);
			System.err.println("order_catalog_yn,577===>>"+order_catalog_yn);

			if(daily_pkg_lmt_yn.equals("Y") && order_catalog_yn.equals("N") && across_enc_YN.equals("N"))
			{
				if(!p_daily_pkg_serv_lmt.equals("")){
					if(p_daily_pkg_serv_lmt_ind.equals("Q")){
						indicatorFldDisabled="";
						amtFldDisabled = "disabled";
						qtyFldDisabled = ""; 
						grossNetDisabled="";
					}else if(p_daily_pkg_serv_lmt_ind.equals("A")){
						indicatorFldDisabled="";
						amtFldDisabled = "";
						qtyFldDisabled = "disabled"; 
						grossNetDisabled="";
					}else if(p_daily_pkg_serv_lmt_ind.equals("B")){
						indicatorFldDisabled="";
						amtFldDisabled = "";
						qtyFldDisabled = ""; 
						grossNetDisabled="";
					}else{
						indicatorFldDisabled="disabled";
						amtFldDisabled = "disabled";
						qtyFldDisabled = "disabled"; 
						grossNetDisabled="disabled";
					}
				}else
				{
					indicatorFldDisabled="disabled";
					amtFldDisabled = "disabled";
					qtyFldDisabled = "disabled"; 
					grossNetDisabled="disabled";
				}
			}
			else
			{
				indicatorFldDisabled="disabled";
				amtFldDisabled = "disabled";
				qtyFldDisabled = "disabled"; 
				grossNetDisabled="disabled";
			}
%>
<html>
<head>
<style>
#table-wrapper {
  position:relative;
}
#table-scroll {
  height:410px; 
  overflow:auto;  
  margin-top:20px;
}
#table-wrapper table {
  width:100%;
}
#table-wrapper table  {
  background:white;
  color:black;
}
#table-wrapper table thead tr {
  position:relative; 
  top: expression(offsetParent.scrollTop);
  z-index:2;
  height:20px;
  width:35%;
}	

</style>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eBL/js/json2.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/MaintainTreamentPackage.js"></script>
<script language="JavaScript" src="../../eBL/js/MaintainTreamentPackageExclude.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<title>Package Exclusions</title>
<body onload="disableExclForAuthorisation('<%=pkgServLmtDtlsPrivYN%>')">
<form name="MaintainTreatmentPkgExclForm" id="MaintainTreatmentPkgExclForm" id="MaintainTreatmentPkgExclForm"	action="" target="messageFrame" onload="disableExclForAuthorisation('<%=pkgServLmtDtlsPrivYN%>')">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" >
					<tr>
						<td>
							<div id="table-wrapper">
								<div id="table-scroll" style="width:100vw;overflow-x: scroll;overflow-y: scroll;">
								<table width='100%' align="center" cellpadding="4" class='grid'  cellspacing="0" id="maintainTrtPkgExclDtls">
			
								<thead>
								<tr>
									<td class='COLUMNHEADER' style="text-align:center;">Service Ind</td>
									<td class='COLUMNHEADER' style="text-align:center;">Service Code</td>
									<td class='COLUMNHEADER' style="text-align:center;">Rate/Charge</td>
									<td class='COLUMNHEADER' style="text-align:center;">Exclude all </td>
									<td class='COLUMNHEADER' style="text-align:center;">Qty Limit</td>
									<td class='COLUMNHEADER' style="text-align:center;">Limit Ind</td>
									<td class='COLUMNHEADER' style="text-align:center;">Amount Limit</td>
									<td class='COLUMNHEADER' style="text-align:center;">Home Medication</td>
									<td class='COLUMNHEADER' style="text-align:center;">Replaceable</td>
									<td class='COLUMNHEADER' style="text-align:center;">Replaceable Service</td>
									<td class='COLUMNHEADER' style="text-align:center;">Daily Limit Indicator</td>
									<td class='COLUMNHEADER' style="text-align:center;">Daily Qty Limit</td>
									<td class='COLUMNHEADER' style="text-align:center;">Daily Amount Limit </td>
									<td class='COLUMNHEADER' style="text-align:center;">Refund</td>
									<td class='COLUMNHEADER' style="text-align:center;">Refund Rate</td>
									<td class='COLUMNHEADER' style="text-align:center;">Auto Refund</td>
									<td class='COLUMNHEADER' style="text-align:center;">Split Allowed</td>
									<td class='COLUMNHEADER' style="text-align:center;">Appl Factor</td>
									<td class='COLUMNHEADER' style="text-align:center;">Utilized Qty</td>
									<td class='COLUMNHEADER' style="text-align:center;">Utilized Amount</td>
									<td class='COLUMNHEADER' style="text-align:center;">Delete</td>
								</tr>
								</thead>
								<tbody>
<%
			if("Y".equals(is_rec_mod_YN)){
				if(!"".equals(exclString)){
					String[] exclRecordsArr = exclString.split("::");
					System.err.println("exclRecordsArr:"+exclRecordsArr.length);
					for(int i=0;i<exclRecordsArr.length;i++){
						System.err.println("exclRecordsArr:"+exclRecordsArr[i]);
						String[] exclRow = exclRecordsArr[i].split("~~");
						
						index++;	
						rate_charge_ind = exclRow[0];
						System.err.println("rate_charge_ind====>>488 " + rate_charge_ind);
						
						pkg_serv_ind = exclRow[2];
						System.err.println("pkg_serv_ind====>>488 " + pkg_serv_ind);
						pkg_serv_code = exclRow[1];
						System.err.println("pkg_serv_code====>>488 " + pkg_serv_code);

						order_catalog_code = "";
						System.err.println("order_catalog_code====>>488 " + order_catalog_code);
						
						amt_limit_ind = exclRow[4];
						System.err.println("amt_limit_ind====>>488 " + amt_limit_ind);
						
						incl_home_medication_yn1 = exclRow[14];
						home_med_enable_yn = exclRow[24];
						
						replaceable_yn = exclRow[7];
						
						daily_limit_ind = exclRow[18];
						if(daily_limit_ind == null || " ".equals(daily_limit_ind)) daily_limit_ind = "";

						System.err.println("replaceable_yn ====>> " + replaceable_yn);
						if(("Y").equals(home_med_enable_yn)){
							home_med_enbl_disbl="";
							if(("Y").equals(incl_home_medication_yn1)){
									incl_home_medication_yn="checked readonly";
							}
							else{
								incl_home_medication_yn="unchecked";
							}
							
								//replaceable_yn="checked";
							}
							else{	
								home_med_enbl_disbl="disabled";
								//replaceable_yn="unchecked";
							}
							
							System.err.println("incl_home_medication_yn1-->"+incl_home_medication_yn1);
							if(("Y").equals(replaceable_yn)){
								replaceable_yn="checked";
							}
							else{	
								replaceable_yn="unchecked";
							}
						System.err.println("replaceable_yn====>> " + replaceable_yn);
						
						System.err.println("daily_limit_ind====>>" + daily_limit_ind);
						
						daily_amt_limit_gross_net = exclRow[17];
						System.err.println("daily_amt_limit_gross_net====>>" + daily_amt_limit_gross_net);
						
						replaceable_serv_code = exclRow[8];
						if(replaceable_serv_code == null || " ".equals(replaceable_serv_code)) replaceable_serv_code = "";
						System.err.println("replaceable_serv_code====>>" + replaceable_serv_code);
						
						refund_yn = exclRow[9];
						System.err.println("refund_yn====>>" + refund_yn);
						
						apply_fact_for_srv_lmt_yn = exclRow[12];
						System.err.println("apply_fact_for_srv_lmt_yn====>>" + apply_fact_for_srv_lmt_yn);
						
						auto_refund_yn = exclRow[11];
						if(auto_refund_yn == null || auto_refund_yn.equals(" ")) auto_refund_yn = "N";
						
						split_allowed_yn = exclRow[13];
						
						daily_qty_limit = exclRow[19];
						
						qty_limit = exclRow[5];
						if(qty_limit == null || qty_limit.equals(" ")) qty_limit = "";
						
						amt_limit = exclRow[6];
						if(amt_limit == null || amt_limit.equals(" ")) amt_limit = "";
						
						daily_amt_limit = exclRow[16];
						if(daily_amt_limit == null || daily_amt_limit.equals(" ")) daily_amt_limit = "";
						
						refund_rate = exclRow[10];
						if(refund_rate == null || " ".equals(refund_rate)) refund_rate = "";
						
						System.err.println("refund_rate=="+refund_rate);
							
						utilized_serv_qty_intg = exclRow[25];
						utilized_serv_amt = exclRow[26];	
						System.err.println("utilized_serv_qty_int :: " + utilized_serv_qty_intg);
					
						rowid = exclRow[22];
						pkg_service_long_desc = exclRow[27];
						
						exclude_all = exclRow[3];	
						if(exclude_all == null || exclude_all.equals(" ")) exclude_all = "N";
						if("Y".equals(exclude_all)){
							excludeAllDisabled = "disabled";
							excludeAllReadonly = "readonly";
						} else {
							excludeAllDisabled = "";
							excludeAllReadonly = "";						
						}

						hdn_is_newly_added_row_YN = exclRow[20];
						if(hdn_is_newly_added_row_YN == null || hdn_is_newly_added_row_YN.equals(" ")) hdn_is_newly_added_row_YN = "N";
						
						hdn_row_marked_for_del = exclRow[21];
						if(hdn_row_marked_for_del == null || hdn_row_marked_for_del.equals(" ")) hdn_row_marked_for_del = "N";					

						System.err.println("order_catalog_code :: ======================>855>" + order_catalog_code);
						System.err.println("daily_limit_ind :: " + daily_limit_ind);

						System.err.println("amt_limit_ind :: " + amt_limit_ind);
						System.err.println("daily_amt_limit_gross_net :: " + daily_amt_limit_gross_net);
						System.err.println("daily_limit_ind :: " + daily_limit_ind);
						System.err.println("amt_limit :: " + amt_limit);
						System.err.println("daily_qty_limit :: " + daily_qty_limit);
						System.err.println("daily_amt_limit :: " + daily_amt_limit);
						System.err.println("pkg_service_long_desc :: "+pkg_service_long_desc);
						System.err.println("rowid ::=!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! "+ rowid);
						System.err.println("classval :: "+classval+" index="+index);
						System.err.println("pkg_service_long_des-->"+pkg_service_long_desc);
						String disable="";
						String disabled="";
						
						if(replaceable_yn.equals("unchecked")) {
							disable="disabled";
							replaceable_yn1="N";
						}else if(replaceable_yn.equals("checked") && rep_serv_ord_cat_code.equals("")){
							replaceable_yn1="Y";
							disabled="disabled";
						}else{
							replaceable_yn1="Y";
							disable="";
							disabled="";
						}
						System.err.println("replaceable_yn1-"+replaceable_yn1);
						System.err.println("replaceable_yn-"+replaceable_yn);
						if(("Y").equals(refund_yn)){
							refundchck="checked";
							refndYNdisable="";
						}
						else{	
							refundchck="unchecked";
							refndYNdisable="disabled";
						}					
						
						System.err.println(disabled);
						System.err.println(disable);
						cnt++;
						if("N".equals(hdn_is_newly_added_row_YN))
							dbcnt++;
						System.err.println("cnt-->"+cnt);
						if(i==0){
							System.err.println("cnt1-->1");
							pkg_service_long_des=exclRow[27];
							System.err.println("pkg_service_long_des-->"+pkg_service_long_des);
						}
						System.err.println("pkg_service_long_des-->"+pkg_service_long_des);					
	%>
										<tr id='row1<%=index%>'  onclick="showExclPackageServiceDesc(<%=count%>,'<%=pkg_service_long_desc%>');">
											<td class='fields' nowrap>
												<select style="width: 150px;"
												name="pkg_serv_ind<%=index%>"  id='pkg_serv_ind<%=index%>'
												onChange='onCustServiceTypeChange(this,"<%=index%>");'
												<%=modifyStatus%>>
												<%
													if(!"G".equals(parent_pkg_serv_ind) && !"C".equals(parent_pkg_serv_ind)){
												%>
													<option value='G'
														<%=pkg_serv_ind.equals("G") ? "selected" : ""%>><fmt:message
															key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}" /></option>	
												<%
													}
													if(!"C".equals(parent_pkg_serv_ind)){
												%>														
													<option value='C' <%=pkg_serv_ind.equals("C") ? "selected" : ""%>>
														<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}" />
													</option>
												<%
													}
												%>												
													<option value='S' <%=pkg_serv_ind.equals("S") ? "selected" : ""%>>
														<fmt:message key="Common.BillingService.label" bundle="${common_labels}" />
													</option>
													<option value='P' <%=pkg_serv_ind.equals("P") ? "selected" : ""%>>
														<fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}" />
													</option>
													<option value='M' <%=pkg_serv_ind.equals("M") ? "selected" : ""%>>
														<fmt:message key="eBL.Items.label" bundle="${bl_labels}" />
													</option>
												</select>
											</td>
											
											<td class='fields' nowrap>
											<input name="pkg_serv_code<%=index%>" id="pkg_serv_code<%=index%>" type="text" id="pkg_serv_code<%=index%>" size="20" value='<%=pkg_serv_code%>' onblur='if(this.value!=""){exclServLookup(<%=index%>,this,pkg_serv<%=index%>);}'> 
											<input type='hidden' name='pkg_serv<%=index%>' id='pkg_serv<%=index%>' id='pkg_serv<%=index%>' value=''>
											<input type="button" name="button_pkg_serv_code<%=index%>"  id="button_pkg_serv_code<%=index%>" value="?" onClick='exclServLookup(<%=index%>,pkg_serv_code<%=index%>,pkg_serv<%=index%>);' >
											</td>
						
											<td  class="fields" 	  >
												<input type="text"  size='10'  style="text-align:center;"  name="rate_charge_ind<%=index%>" id="rate_charge_ind<%=index%>"  value="<%=rate_charge_ind%>" readonly />
											</td>
											
											<td  class="fields" 	 nowrap>
											<input type="checkbox" size='20' style="text-align:center;"  name="chk_exclude_all<%=index %>" id="chk_exclude_all<%=index %>"  value="<%=exclude_all%>" <%=("Y".equals(exclude_all)) ? "checked" : ""%> onClick='handleExclAll(this,"<%=index%>");'/>
											</td>
											
											<td  class="fields" 	>
												   <input type="text" size='10'  style="text-align:center;"  name="qty_limit<%=index%>" id="qty_limit<%=index%>"  value='<%=qty_limit%>' onBlur='validateExclFactorLmt(document.forms[0].rate_charge_ind<%=index%>,this,<%=index%>,2);' onkeypress='return ChkNumberInput(this,event,"0");' <%=excludeAllReadonly%> >
											</td>	
	<% System.err.println("Check1"); %>
											<td  align="left" nowrap>
												<select style="width:100px;" name='amt_limit_ind<%=index%>' id='amt_limit_ind<%=index%>' onChange='validateExclFactorLmt(document.forms[0].rate_charge_ind<%=index%>,this,<%=index%>,3);' <%=excludeAllDisabled%>>
													<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
													<option value='A' <%=(amt_limit_ind.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
													<option value='P'  <%=(amt_limit_ind.equals("P")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
													<!-- <option value='U'  <%=(amt_limit_ind.equals("U")?"selected":"") %> ><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option> -->
												</select>
											</td>

											<td  class="fields" 	 nowrap>
													<input type="text" style="text-align:center;"  name="amt_limit<%=index%>"   id="amt_limit<%=index%>" value='<%=amt_limit%>' onBlur='validateExclFactorLmt(document.forms[0].rate_charge_ind<%=index%>,this,<%=index%>,4);' onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")'<%=excludeAllReadonly%> >
											</td>			

											<td class='fields'  nowrap>
												<input type="checkbox" name="incl_home_medication_yn<%=index %>" id="incl_home_medication_yn<%=index %>"  value="<%=incl_home_medication_yn1%>" <%=incl_home_medication_yn%> <%=home_med_enbl_disbl%> onClick='chkExclHomeMed(<%=index%>)'/>
												<input type='hidden' name="home_med_enable_yn<%=index %>" id="home_med_enable_yn<%=index %>" value="<%=home_med_enable_yn%>"
											</td>
											
											<td class='fields'   nowrap><input type="checkbox" name="replaceable_yn<%=index %>" id="replaceable_yn<%=index %>"  value="<%=replaceable_yn1%>" <%=replaceable_yn%> onClick='chkExclReplacable(this,<%=index%>);enableExclReplc(this,<%=index%>);'/></td>

											<td  class="fields" 	nowrap>   
												<input name="replaceable_serv_code<%=index%>" id="replaceable_serv_code<%=index%>" type="text" id="replaceable_serv_code<%=index%>" size="10" value="<%=replaceable_serv_code%>" onblur='if(this.value!=""){repExclServLookup(<%=index%>,this,rep_pkg_serv<%=index%>)}' <%= disable%> > 
												<input type='hidden' name='rep_pkg_serv<%=index%>' id='rep_pkg_serv<%=index%>'  value=''>
												<input type="button" name="button_rep_pkg_serv_code<%=index%>"  id="button_rep_pkg_serv_code<%=index%>" value="?" onClick='repExclServLookup(<%=index%>,replaceable_serv_code<%=index%>,rep_pkg_serv<%=index%>)' <%= disable%>>
											</td>

											<td class='fields'  nowrap >
												<select style="width:150px;" name='daily_limit_ind<%=index%>' id='daily_limit_ind<%=index%>'  <%=modifyStatus%> <%=indicatorFldDisabled%> onchange='dailyExclLmtIndicatorOnChange(this,<%=index%>)' >
													<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
												<%if(!daily_limit_ind.equals("")){
												if("G".equals(p_daily_pkg_serv_lmt) || "B".equals(p_daily_pkg_serv_lmt)) { %>
													<option value="G" <%="G".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
												<% } if("I".equals(p_daily_pkg_serv_lmt) || "B".equals(p_daily_pkg_serv_lmt)) {%>
													<option value="I" <%="I".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="eBL.PIPD.label" bundle="${bl_labels}"/></option>
												<% }
												}else{ %>
													<option value="G" <%="G".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
													<option value="I" <%="I".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="eBL.PIPD.label" bundle="${bl_labels}"/></option>
												<% }%>
												</select>
											</td>
											<%	if(!daily_limit_ind.equals("")){%>
											<td  class="fields" 	 nowrap>
												<input type="text" style="text-align:center;" name="daily_qty_limit<%=index%>" id="daily_qty_limit<%=index%>" value="<%=daily_qty_limit%>" <%=qtyFldDisabled%> <%=excludeAllDisabled%> onkeypress='return ChkNumberInput(this,event,"0");'/>
											</td>
											<td  class="fields" 	  nowrap>
												<input type="text"  style="text-align:center;" name="daily_amt_limit<%=index%>" id="daily_amt_limit<%=index%>"  value="<%=daily_amt_limit%>" <%=amtFldDisabled%> <%=excludeAllDisabled%> onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")'/>
												<select style="width:100px;" name='GrossNet<%=index%>' id='GrossNet<%=index%>'  onChange='validateGrossNetInd(this,"<%=index%>");' <%=grossNetDisabled%> <%=excludeAllDisabled%> >
													<option value='G' <%=(daily_amt_limit_gross_net.equals("G")?"selected":"") %> ><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
													<option value='S'  <%=(daily_amt_limit_gross_net.equals("N")?"selected":"") %> ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
												</select>
											</td>
											<%}else{%>
											<td  class="fields" 	 nowrap>
												<input type="text" style="text-align:center;" name="daily_qty_limit<%=index%>" id="daily_qty_limit<%=index%>"  value="<%=daily_qty_limit%>" <%=qtyFldDisabled%> <%=excludeAllDisabled%> onkeypress='return ChkNumberInput(this,event,"0");'/>

											</td>
											<td  class="fields" 	  nowrap>
												<input type="text"  style="text-align:center;" name="daily_amt_limit<%=index%>" id="daily_amt_limit<%=index%>" value="<%=daily_amt_limit%>"  <%=amtFldDisabled%> <%=excludeAllDisabled%> onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")'/>
												<select style="width:100px;" name='GrossNet<%=index%>' id='GrossNet<%=index%>'  onChange='validateGrossNetInd(this,"<%=index%>");' <%=grossNetDisabled%> <%=excludeAllDisabled%> >
													<option value='G' <%=(daily_amt_limit_gross_net.equals("G")?"selected":"") %> ><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
													<option value='S'  <%=(daily_amt_limit_gross_net.equals("N")?"selected":"") %> ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
												</select>
											</td>
											<%}%>
	<% System.err.println("Check2"); %>										
											<td class='fields'  nowrap><input type="checkbox" name="refund_yn<%=index %>" id="refund_yn<%=index %>"  value='<%=refund_yn%>' onClick='exclRefundChk(this,<%=index%>)' <%=refundchck%> /></td>

											<td  class="fields"  nowrap>
												<input type="text" style="text-align:center;" maxlength='4' name="refund_rate<%=index%>" id="refund_rate<%=index%>"  value="<%=refund_rate%>" <%=refndYNdisable%> onkeypress='return ChkNumberInput(this,event,"<%=noofdecimal%>")' onBlur='validPercentageForRefund(this,"auto_refund_yn<%=index%>")'/>
											</td>

											<% if(!auto_refund_yn.equals("") && auto_refund_yn.equals("Y")){%>
											<td class='fields'   nowrap><input type="checkbox" name="auto_refund_yn<%=index %>" id="auto_refund_yn<%=index %>"  value='<%=auto_refund_yn%>' checked   onClick='exclAutoRefundChk(<%=index%>)' <%=refndYNdisable%> /></td>
											<%}else{%>
											<td class="fields" 	nowrap><input type="checkbox" name="auto_refund_yn<%=index %>" id="auto_refund_yn<%=index %>"  value='<%=auto_refund_yn%>' onClick='exclAutoRefundChk(<%=index%>)' <%=refndYNdisable%> />&nbsp;
											</td>
											<%}%>
											
											<% if(!split_allowed_yn.equals("") && split_allowed_yn.equals("Y")){%>
											<td class='fields'  nowrap><input type="checkbox" name="split_allowed_yn<%=index%>" id="split_allowed_yn<%=index%>"  value="<%=split_allowed_yn%>" onClick='exclSplitChk(<%=index%>)' checked /></td>
											<%}else{%>
											<td class="fields" 	 nowrap><input type="checkbox" name="split_allowed_yn<%=index%>" id="split_allowed_yn<%=index%>"  value="<%=split_allowed_yn%>" onClick='exclSplitChk(<%=index%>)' />
											&nbsp;
											</td>
											<%}%>										

											<td class='fields' nowrap><input type="checkbox" name="apply_fact_for_srv_lmt_yn<%=index%>" id="apply_fact_for_srv_lmt_yn<%=index%>"  value="<%=apply_fact_for_srv_lmt_yn%>" onClick='applExclFactChk(<%=index%>)' disabled <%=("Y".equals(apply_fact_for_srv_lmt_yn)) ? "checked" : "" %> nowrap/></td>

											<td  class="fields" 	 nowrap>
												<input type="text" style="text-align:center;"  name="utilized_serv_qty<%=index%>" id="utilized_serv_qty<%=index%>"  value="<%=utilized_serv_qty_intg%>" disabled/>
											</td>
											<td  class="fields" 	 nowrap>
												<input type="text" style="text-align:center;"  name="utilized_serv_amt<%=index%>" id="utilized_serv_amt<%=index%>"  value="<%=utilized_serv_amt%>" disabled/>
											</td>
	<% System.err.println("Check3"); %>
											<td class='fields'  nowrap>
												<input type="checkbox" name="radio<%=index%>" id="radio<%=index%>"  onClick="markRowForDel(this,<%=index%>,this)" <%=("Y".equals(hdn_row_marked_for_del)) ? "checked" : ""%> />
												<input type="hidden" id="hdn_is_newly_added_row_YN_<%=index%>" name="hdn_is_newly_added_row_YN_<%=index%>" value='N'/>
												<input type="hidden" id="hdn_row_marked_for_del_<%=index%>" name="hdn_row_marked_for_del_<%=index%>" value='N'/>
											</td>												  
											
											<input type="hidden" id="hdn_pkg_serv_ind<%=index%>" 			name="hdn_pkg_serv_ind<%=index%>"   value='<%=pkg_serv_ind%>'/>
											<input type="hidden" id="hdn_pkg_serv_code<%=index%>" 			name="hdn_pkg_serv_code<%=index%>" value='<%=pkg_serv_code%>'/>
											<input type="hidden" id="hdn_rate_charge_ind<%=index%>" 			name="hdn_rate_charge_ind<%=index%>" value='<%=rate_charge_ind%>'/>
											<input type="hidden" id="hdn_order_catalog_code<%=index%>" 			name="hdn_order_catalog_code<%=index%>" value='<%=order_catalog_code%>'/>

											<input type="hidden" id="hdn_qty_limit<%=index%>" 			name="hdn_qty_limit<%=index%>" value='<%=qty_limit%>'/>
											<input type="hidden" id="hdn_amt_limit_ind<%=index%>" 			name="hdn_amt_limit_ind<%=index%>" value='<%=amt_limit_ind%>'/>
											<input type="hidden" id="hdn_amt_limit<%=index%>" 			name="hdn_amt_limit<%=index%>" value='<%=amt_limit%>'/>
											<input type="hidden" id="hdn_incl_home_medication_yn<%=index%>" 			name="hdn_incl_home_medication_yn<%=index%>" value='<%=incl_home_medication_yn1%>'/>
											<input type="hidden" id="hdn_replaceable_yn<%=index%>" 			name="hdn_replaceable_yn<%=index%>" value='<%=replaceable_yn1%>'/>
											<input type="hidden" id="hdn_replaceable_serv_code<%=index%>" 			name="hdn_replaceable_serv_code<%=index%>" value='<%=replaceable_serv_code%>'/>
											<input type="hidden" id="hdn_daily_limit_ind<%=index%>" 			name="hdn_daily_limit_ind<%=index%>" value='<%=daily_limit_ind%>'/>
											<input type="hidden" id="hdn_daily_qty_limit<%=index%>" 			name="hdn_daily_qty_limit<%=index%>" value='<%=daily_qty_limit%>'/>
											<input type="hidden" id="hdn_daily_amt_limit<%=index%>" 			name="hdn_daily_amt_limit<%=index%>" value='<%=daily_amt_limit%>'/>
											<input type="hidden" id="hdn_daily_amt_limit_gross_net<%=index%>" 			name="hdn_daily_amt_limit_gross_net<%=index%>" value='<%=daily_amt_limit_gross_net%>'/>
											<input type="hidden" id="hdn_refund_yn<%=index%>" 			name="hdn_refund_yn<%=index%>" value='<%=refund_yn%>'/>
											<input type="hidden" id="hdn_refund_rate<%=index%>" 			name="hdn_refund_rate<%=index%>" value='<%=refund_rate%>'/>
											<input type="hidden" id="hdn_auto_refund_yn<%=index%>" 			name="hdn_auto_refund_yn<%=index%>" value='<%=auto_refund_yn%>'/>
											<input type="hidden" id="hdn_utilized_serv_qty<%=index%>" 			name="hdn_utilized_serv_qty<%=index%>" value='<%=utilized_serv_qty_intg%>'/>
											<input type="hidden" id="hdn_utilized_serv_amt<%=index%>" 			name="hdn_utilized_serv_amt<%=index%>" value='<%=utilized_serv_amt%>'/>
											<input type="hidden" id="hdn_apply_fact_for_srv_lmt_yn<%=index%>" 			name="hdn_apply_fact_for_srv_lmt_yn<%=index%>" value='<%=apply_fact_for_srv_lmt_yn%>'/>
	<% System.err.println("Check4"); %>
											<input type="hidden" id="hdn_split_allowed_yn<%=index%>" 			name="hdn_split_allowed_yn<%=index%>" value='<%=split_allowed_yn%>'/>

											<input type="hidden" id="hdn_rowid<%=index%>" 			name="hdn_rowid<%=index%>" value='<%=rowid%>'/>
											<input type="hidden" id="hdn_package_code<%=index%>" 			name="hdn_package_code<%=index%>" value='<%=defaultPkgCode%>'/>
											<input type="hidden" id="hdn_package_seq_no<%=index%>" 			name="hdn_package_seq_no<%=index%>" value='<%=defaultPkgSeq%>'/>
											<input type="hidden" id="pkg_service_long_desc<%=index%>" 			name="pkg_service_long_desc<%=index%>" value='<%=pkg_service_long_desc%>'/>   
											<input type='hidden' name='index' id='index' id='index' value='<%=index%>' >
										</tr>
	<%
					}
				} 
			}
			else 
			{
			
				String sqlstr1 = "select EXCL_SERV_IND pack_serv,EXCL_SERV_CODE pkg_serv_code,rate_charge_ind,null order_catalog_code,"
				+" qty_limit, amt_limit_ind,amt_limit,incl_home_medication_yn,replaceable_yn,daily_limit_ind,"
				+" daily_qty_limit, daily_amt_limit, daily_amt_limit_gross_net, replaceable_serv_code, refund_yn,refund_rate,"
				+" apply_fact_for_srv_lmt_yn,round(utilized_serv_qty,2) utilized_serv_qty, utilized_serv_amt,auto_refund_yn," 
				+" split_allowed_yn,rowid,blpackage.get_description(EXCL_SERV_IND,EXCL_SERV_CODE,'"+ locale + "') pkg_service_long_desc,"
				+" blcommonproc.bl_pharm_service_yn ('en',EXCL_SERV_IND,EXCL_SERV_CODE) home_medication_enable_yn, EXCLUDE_YN "
				+" from bl_package_sub_excl where OPERATING_FACILITY_ID = '" + facility_id + "' AND PATIENT_ID = '"+ patientid + "'"
				+" AND PACKAGE_CODE = '"+ package_code +"' AND PACKAGE_SEQ_NO = '"+ package_seq_no +"' AND PKG_SERV_CODE = '"+ parent_pkg_serv_code +"'";
				
				System.err.println("sqlstr excl:"+sqlstr1);
				pstmt1 = con.prepareStatement(sqlstr1);
				rs1 = pstmt1.executeQuery();
				if (rs1 != null) {
					while (rs1.next()){
						index = rs1.getRow();	
						pkg_serv_ind = checkForNull(rs1.getString("pack_serv"));
						System.err.println("pkg_serv_ind====>>488 " + pkg_serv_ind);
						pkg_serv_code = checkForNull(rs1.getString("pkg_serv_code"));
						System.err.println("pkg_serv_code====>>488 " + pkg_serv_code);
						rate_charge_ind = checkForNull(rs1.getString("rate_charge_ind"));
						System.err.println("rate_charge_ind====>>488 " + rate_charge_ind);
						order_catalog_code = checkForNull(rs1.getString("order_catalog_code"));
						System.err.println("order_catalog_code====>>488 " + order_catalog_code);
						
						amt_limit_ind = checkForNull(rs1.getString("amt_limit_ind"));
						System.err.println("amt_limit_ind====>>488 " + amt_limit_ind);
						
						incl_home_medication_yn1 = checkForNull(rs1.getString("incl_home_medication_yn"));
						home_med_enable_yn = checkForNull(rs1.getString("home_medication_enable_yn"));
						replaceable_yn = checkForNull(rs1.getString("replaceable_yn"));
						daily_limit_ind = checkForNull(rs1.getString("daily_limit_ind"));
						System.err.println("replaceable_yn ====>> " + replaceable_yn);
						if(("Y").equals(home_med_enable_yn)){
							home_med_enbl_disbl="";
							if(("Y").equals(incl_home_medication_yn1)){
									incl_home_medication_yn="checked readonly";
							}
							else{
								incl_home_medication_yn="unchecked";
							}
							
								//replaceable_yn="checked";
							}
							else{	
								home_med_enbl_disbl="disabled";
								//replaceable_yn="unchecked";
							}
							
							System.err.println("incl_home_medication_yn1-->"+incl_home_medication_yn1);
							if(("Y").equals(replaceable_yn)){
								replaceable_yn="checked";
							}
							else{	
								replaceable_yn="unchecked";
							}
						System.err.println("replaceable_yn====>> " + replaceable_yn);
						
						System.err.println("daily_limit_ind====>>" + daily_limit_ind);
						
						daily_amt_limit_gross_net = checkForNull(rs1.getString("daily_amt_limit_gross_net"));
						System.err.println("daily_amt_limit_gross_net====>>" + daily_amt_limit_gross_net);
						replaceable_serv_code = checkForNull(rs1.getString("replaceable_serv_code"));
						System.err.println("replaceable_serv_code====>>" + replaceable_serv_code);
						
						refund_yn = checkForNull(rs1.getString("refund_yn"));
						System.err.println("refund_yn====>>" + refund_yn);
						
						apply_fact_for_srv_lmt_yn = checkForNull(rs1.getString("apply_fact_for_srv_lmt_yn"));
						System.err.println("apply_fact_for_srv_lmt_yn====>>" + apply_fact_for_srv_lmt_yn);
						
						auto_refund_yn = checkForNull(rs1.getString("auto_refund_yn"));
						split_allowed_yn = checkForNull(rs1.getString("split_allowed_yn"));
						
						daily_qty_limit = checkForNull(rs1.getString("daily_qty_limit"));
						qty_limit = checkForNull(rs1.getString("qty_limit"));
						amt_limit = checkForNull(rs1.getString("amt_limit"));
						daily_amt_limit = checkForNull(rs1.getString("daily_amt_limit"));
						refund_rate = checkForNull(rs1.getString("refund_rate"));
						
						System.err.println("refund_rate=="+refund_rate);
							
						utilized_serv_qty_intg = checkForNull(rs1.getString("utilized_serv_qty"));
						utilized_serv_amt = checkForNull(rs1.getString("utilized_serv_amt"));	
						System.err.println("utilized_serv_qty_int :: " + utilized_serv_qty_intg);
					
						rowid = checkForNull(rs1.getString("rowid"));
						pkg_service_long_desc = checkForNull(rs1.getString("pkg_service_long_desc"));
						
						exclude_all = checkForNull(rs1.getString("EXCLUDE_YN"));
						if("Y".equals(exclude_all)){
							excludeAllDisabled = "disabled";
							excludeAllReadonly = "readonly";
						}						

						System.err.println("order_catalog_code :: ======================>855>" + order_catalog_code);
						System.err.println("daily_limit_ind :: " + daily_limit_ind);

						System.err.println("amt_limit_ind :: " + amt_limit_ind);
						System.err.println("daily_amt_limit_gross_net :: " + daily_amt_limit_gross_net);
						System.err.println("daily_limit_ind :: " + daily_limit_ind);
						System.err.println("amt_limit :: " + amt_limit);
						System.err.println("daily_qty_limit :: " + daily_qty_limit);
						System.err.println("daily_amt_limit :: " + daily_amt_limit);
						System.err.println("pkg_service_long_desc :: "+pkg_service_long_desc);
						System.err.println(
								"rowid ::=!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! "
										+ rowid);
						System.err.println("classval :: "+classval+" index="+index);
						System.err.println("pkg_service_long_des-->"+pkg_service_long_desc);
						String disable="";
						String disabled="";
						
						if(replaceable_yn.equals("unchecked")) {
							disable="disabled";
							replaceable_yn1="N";
						}else if(replaceable_yn.equals("checked") && rep_serv_ord_cat_code.equals("")){
							replaceable_yn1="Y";
							disabled="disabled";
						}else{
							replaceable_yn1="Y";
							disable="";
							disabled="";
						}
						System.err.println("replaceable_yn1-"+replaceable_yn1);
						System.err.println("replaceable_yn-"+replaceable_yn);
						if(("Y").equals(refund_yn)){
								refundchck="checked";
								refndYNdisable="";
							}
							else{	
								refundchck="unchecked";
								refndYNdisable="disabled";
							}					
						
						System.err.println(disabled);
						System.err.println(disable);
						cnt++;
						dbcnt++;
						System.err.println("cnt-->"+cnt);
						if(cnt==1){
							System.err.println("cnt1-->1");
							pkg_service_long_des=checkForNull(rs1.getString("pkg_service_long_desc"));
							System.err.println("pkg_service_long_des-->"+pkg_service_long_des);
						}
						System.err.println("pkg_service_long_des-->"+pkg_service_long_des);
					
%>								
									<tr id='row1<%=index%>'  onclick="showExclPackageServiceDesc(<%=count%>,'<%=pkg_service_long_desc%>');">
										<td class='fields' nowrap>
											<select style="width: 150px;"
											name="pkg_serv_ind<%=index%>"  id='pkg_serv_ind<%=index%>'
											onChange='onCustServiceTypeChange(this,"<%=index%>");'
											<%=modifyStatus%>>
											<%
												if(!"G".equals(parent_pkg_serv_ind)){
											%>
												<option value='G'
													<%=pkg_serv_ind.equals("G") ? "selected" : ""%>><fmt:message
														key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}" /></option>	
											<%
												}
												if(!"C".equals(parent_pkg_serv_ind)){
											%>														
												<option value='C' <%=pkg_serv_ind.equals("C") ? "selected" : ""%>>
													<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}" />
												</option>
											<%
												}
											%>												
												<option value='S' <%=pkg_serv_ind.equals("S") ? "selected" : ""%>>
													<fmt:message key="Common.BillingService.label" bundle="${common_labels}" />
												</option>
												<option value='P' <%=pkg_serv_ind.equals("P") ? "selected" : ""%>>
													<fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}" />
												</option>
												<option value='M' <%=pkg_serv_ind.equals("M") ? "selected" : ""%>>
													<fmt:message key="eBL.Items.label" bundle="${bl_labels}" />
												</option>
											</select>
										</td>
										
										<td class='fields' nowrap>
										<input name="pkg_serv_code<%=index%>"  type="text" id="pkg_serv_code<%=index%>" size="20" value='<%=pkg_serv_code%>' onblur='if(this.value!=""){exclServLookup(<%=index%>,this,pkg_serv<%=index%>);checkExclDuplicate(<%=index%>);}'> 
										<input type='hidden' name='pkg_serv<%=index%>'  id='pkg_serv<%=index%>' value=''>
										<input type="button" name="button_pkg_serv_code<%=index%>"  id="button_pkg_serv_code<%=index%>" value="?" onClick='exclServLookup(<%=index%>,pkg_serv_code<%=index%>,pkg_serv<%=index%>);checkExclDuplicate(<%=index%>);' >
										</td>
			        
										<td  class="fields" 	  >
											<input type="text"  size='10'  style="text-align:center;"  name="rate_charge_ind<%=index%>"  id="rate_charge_ind<%=index%>" value="<%=rate_charge_ind%>" readonly />
										</td>
										
										<td  class="fields" 	 nowrap>
										<input type="checkbox" size='20' style="text-align:center;"  name="chk_exclude_all<%=index %>"   id="chk_exclude_all<%=index %>" value="<%=exclude_all%>" <%=("Y".equals(exclude_all)) ? "checked" : ""%> onClick='handleExclAll(this,"<%=index%>");'/>
										</td>
										
										<td  class="fields" 	>
											   <input type="text" size='10'  style="text-align:center;"  name="qty_limit<%=index%>"   id="qty_limit<%=index%>" value='<%=qty_limit%>' onBlur='validateExclFactorLmt(document.forms[0].rate_charge_ind<%=index%>,this,<%=index%>,2);' onkeypress='return ChkNumberInput(this,event,"0");' <%=excludeAllReadonly%> >
										</td>	
<% System.err.println("Check1"); %>
										<td  align="left" nowrap>
											<select style="width:100px;" name='amt_limit_ind<%=index%>' id='amt_limit_ind<%=index%>' onChange='validateExclFactorLmt(document.forms[0].rate_charge_ind<%=index%>,this,<%=index%>,3);' <%=excludeAllDisabled%>>
												<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
												<option value='A' <%=(amt_limit_ind.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
												<option value='P'  <%=(amt_limit_ind.equals("P")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option><!--
												<option value='U'  <%=(amt_limit_ind.equals("U")?"selected":"") %> ><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option>-->
											</select>
										</td>

										<td  class="fields" 	 nowrap>
												<input type="text" style="text-align:center;"  name="amt_limit<%=index%>"   id="amt_limit<%=index%>" value='<%=amt_limit%>' onBlur='validateExclFactorLmt(document.forms[0].rate_charge_ind<%=index%>,this,<%=index%>,4);' onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")' <%=excludeAllReadonly%> >
										</td>			

										<td class='fields'  nowrap>
											<input type="checkbox" name="incl_home_medication_yn<%=index %>"  id="incl_home_medication_yn<%=index %>" value="<%=incl_home_medication_yn1%>" <%=incl_home_medication_yn%> <%=home_med_enbl_disbl%> onClick='chkExclHomeMed(<%=index%>)'/>
											<input type='hidden' name="home_med_enable_yn<%=index %>"  id="home_med_enable_yn<%=index %>" value="<%=home_med_enable_yn%>"
										</td>
										
										<td class='fields'   nowrap><input type="checkbox" name="replaceable_yn<%=index %>"  id="replaceable_yn<%=index %>" value="<%=replaceable_yn1%>" <%=replaceable_yn%> onClick='chkExclReplacable(this,<%=index%>);enableExclReplc(this,<%=index%>);'/></td>

										<td  class="fields" 	nowrap>   
											<input name="replaceable_serv_code<%=index%>"  type="text" id="replaceable_serv_code<%=index%>" size="10" value="<%=replaceable_serv_code%>" onblur='if(this.value!=""){repExclServLookup(<%=index%>,this,rep_pkg_serv<%=index%>)}' <%= disable%> > 
											<input type='hidden' name='rep_pkg_serv<%=index%>'  id='rep_pkg_serv<%=index%>' value=''>
											<input type="button" name="button_rep_pkg_serv_code<%=index%>"  id="button_rep_pkg_serv_code<%=index%>" value="?" onClick='repExclServLookup(<%=index%>,replaceable_serv_code<%=index%>,rep_pkg_serv<%=index%>)' <%= disable%>>
										</td>

										<td class='fields'  nowrap >
											<select style="width:150px;" name='daily_limit_ind<%=index%>'  id='daily_limit_ind<%=index%>' <%=modifyStatus%> <%=indicatorFldDisabled%> onchange='dailyExclLmtIndicatorOnChange(this,<%=index%>)' >
												<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
											<%if(!daily_limit_ind.equals("")){
											if("G".equals(p_daily_pkg_serv_lmt) || "B".equals(p_daily_pkg_serv_lmt)) { %>
												<option value="G" <%="G".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
											<% } if("I".equals(p_daily_pkg_serv_lmt) || "B".equals(p_daily_pkg_serv_lmt)) {%>
												<option value="I" <%="I".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="eBL.PIPD.label" bundle="${bl_labels}"/></option>
											<% }
											}else{ %>
												<option value="G" <%="G".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
												<option value="I" <%="I".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="eBL.PIPD.label" bundle="${bl_labels}"/></option>
											<% }%>
											</select>
										</td>
										<%	if(!daily_limit_ind.equals("")){%>
										<td  class="fields" 	 nowrap>
											<input type="text" style="text-align:center;" name="daily_qty_limit<%=index%>"  id="daily_qty_limit<%=index%>" value="<%=daily_qty_limit%>" <%=qtyFldDisabled%> <%=excludeAllDisabled%> onkeypress='return ChkNumberInput(this,event,"0");'/>
										</td>
										<td  class="fields" 	  nowrap>
											<input type="text"  style="text-align:center;" name="daily_amt_limit<%=index%>"  id="daily_amt_limit<%=index%>" value="<%=daily_amt_limit%>" <%=amtFldDisabled%> <%=excludeAllDisabled%> onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")' />
											<select style="width:100px;" name='GrossNet<%=index%>' id='GrossNet<%=index%>' onChange='validateGrossNetInd(this,"<%=index%>");' <%=grossNetDisabled%> <%=excludeAllDisabled%> >
												<option value='G' <%=(daily_amt_limit_gross_net.equals("G")?"selected":"") %> ><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
												<option value='S'  <%=(daily_amt_limit_gross_net.equals("N")?"selected":"") %> ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
											</select>
										</td>
										<%}else{%>
										<td  class="fields" 	 nowrap>
											<input type="text" style="text-align:center;" name="daily_qty_limit<%=index%>"  id="daily_qty_limit<%=index%>" value="<%=daily_qty_limit%>" <%=qtyFldDisabled%> <%=excludeAllDisabled%> onkeypress='return ChkNumberInput(this,event,"0");'/>

										</td>
										<td  class="fields" 	  nowrap>
											<input type="text"  style="text-align:center;" name="daily_amt_limit<%=index%>"  id="daily_amt_limit<%=index%>" value="<%=daily_amt_limit%>"  <%=amtFldDisabled%> <%=excludeAllDisabled%> onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")'/>
											<select style="width:100px;" name='GrossNet<%=index%>'  id='GrossNet<%=index%>' onChange='validateGrossNetInd(this,"<%=index%>");' <%=grossNetDisabled%> <%=excludeAllDisabled%> >
												<option value='G' <%=(daily_amt_limit_gross_net.equals("G")?"selected":"") %> ><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
												<option value='S'  <%=(daily_amt_limit_gross_net.equals("N")?"selected":"") %> ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
											</select>
										</td>
										<%}%>
<% System.err.println("Check2"); %>										
										<td class='fields'  nowrap><input type="checkbox" name="refund_yn<%=index %>"  id="refund_yn<%=index%>" value='<%=refund_yn%>' onClick='exclRefundChk(this,<%=index%>)' <%=refundchck%> /></td>

										<td  class="fields"  nowrap>
											<input type="text" style="text-align:center;" maxlength='4' name="refund_rate<%=index%>"  id="refund_rate<%=index%>" value="<%=refund_rate%>" <%=refndYNdisable%> onkeypress='return ChkNumberInput(this,event,"<%=noofdecimal%>")' onBlur='validPercentageForRefund(this,"auto_refund_yn<%=index%>")'/>
										</td>

										<% if(!auto_refund_yn.equals("") && auto_refund_yn.equals("Y")){%>
										<td class='fields'   nowrap><input type="checkbox" name="auto_refund_yn<%=index %>"  id="auto_refund_yn<%=index%>" value='<%=auto_refund_yn%>' checked   onClick='exclAutoRefundChk(<%=index%>)' <%=refndYNdisable%> /></td>
										<%}else{%>
										<td class="fields" 	nowrap><input type="checkbox" name="auto_refund_yn<%=index %>"  id="auto_refund_yn<%=index %>" value='<%=auto_refund_yn%>' onClick='exclAutoRefundChk(<%=index%>)' <%=refndYNdisable%> />&nbsp;
										</td>
										<%}%>
										
										<% if(!split_allowed_yn.equals("") && split_allowed_yn.equals("Y")){%>
										<td class='fields'  nowrap><input type="checkbox" name="split_allowed_yn<%=index%>"  id="split_allowed_yn<%=index%>" value="<%=split_allowed_yn%>" onClick='exclSplitChk(<%=index%>)' checked /></td>
										<%}else{%>
										<td class="fields" 	 nowrap><input type="checkbox" name="split_allowed_yn<%=index%>"  id="split_allowed_yn<%=index%>" value="<%=split_allowed_yn%>" onClick='exclSplitChk(<%=index%>)' />
										&nbsp;
										</td>
										<%}%>										

										<td class='fields' nowrap><input type="checkbox" name="apply_fact_for_srv_lmt_yn<%=index%>"  id="apply_fact_for_srv_lmt_yn<%=index%>" value="<%=apply_fact_for_srv_lmt_yn%>" onClick='applExclFactChk(<%=index%>)' disabled <%=("Y".equals(apply_fact_for_srv_lmt_yn)) ? "checked" : "" %> nowrap/></td>

										<td  class="fields" 	 nowrap>
											<input type="text" style="text-align:center;"  name="utilized_serv_qty<%=index%>"  id="utilized_serv_qty<%=index%>" value="<%=utilized_serv_qty_intg%>" disabled/>
										</td>
										<td  class="fields" 	 nowrap>
											<input type="text" style="text-align:center;"  name="utilized_serv_amt<%=index%>"  id="utilized_serv_amt<%=index%>" value="<%=utilized_serv_amt%>" disabled/>
										</td>
<% System.err.println("Check3"); %>
										<td class='fields'  nowrap>
											<input type="checkbox" name="radio<%=index%>" id="radio<%=index%>"  onClick="markRowForDel(this,<%=index%>,this)" <%=("Y".equals(hdn_row_marked_for_del)) ? "checked" : ""%> />
											<input type="hidden" id="hdn_is_newly_added_row_YN_<%=index%>" name="hdn_is_newly_added_row_YN_<%=index%>" value='N'/>
											<input type="hidden" id="hdn_row_marked_for_del_<%=index%>" name="hdn_row_marked_for_del_<%=index%>" value='N'/>
										</td>												  
										
										<input type="hidden" id="hdn_pkg_serv_ind<%=index%>" name="hdn_pkg_serv_ind<%=index%>"   value='<%=pkg_serv_ind%>'/>
										<input type="hidden" id="hdn_pkg_serv_code<%=index%>" name="hdn_pkg_serv_code<%=index%>" value='<%=pkg_serv_code%>'/>
										<input type="hidden" id="hdn_rate_charge_ind<%=index%>" name="hdn_rate_charge_ind<%=index%>" value='<%=rate_charge_ind%>'/>
										<input type="hidden" id="hdn_order_catalog_code<%=index%>" name="hdn_order_catalog_code<%=index%>" value='<%=order_catalog_code%>'/>

										<input type="hidden" id="hdn_qty_limit<%=index%>" name="hdn_qty_limit<%=index%>" value='<%=qty_limit%>'/>
										<input type="hidden" id="hdn_amt_limit_ind<%=index%>" name="hdn_amt_limit_ind<%=index%>" value='<%=amt_limit_ind%>'/>
										<input type="hidden" id="hdn_amt_limit<%=index%>" name="hdn_amt_limit<%=index%>" value='<%=amt_limit%>'/>
										<input type="hidden" id="hdn_incl_home_medication_yn<%=index%>" name="hdn_incl_home_medication_yn<%=index%>" value='<%=incl_home_medication_yn1%>'/>
										<input type="hidden" id="hdn_replaceable_yn<%=index%>" name="hdn_replaceable_yn<%=index%>" value='<%=replaceable_yn1%>'/>
										<input type="hidden" id="hdn_replaceable_serv_code<%=index%>" name="hdn_replaceable_serv_code<%=index%>" value='<%=replaceable_serv_code%>'/>
										<input type="hidden" id="hdn_daily_limit_ind<%=index%>" name="hdn_daily_limit_ind<%=index%>" value='<%=daily_limit_ind%>'/>
										<input type="hidden" id="hdn_daily_qty_limit<%=index%>" name="hdn_daily_qty_limit<%=index%>" value='<%=daily_qty_limit%>'/>
										<input type="hidden" id="hdn_daily_amt_limit<%=index%>" name="hdn_daily_amt_limit<%=index%>" value='<%=daily_amt_limit%>'/>
										<input type="hidden" id="hdn_daily_amt_limit_gross_net<%=index%>" name="hdn_daily_amt_limit_gross_net<%=index%>" value='<%=daily_amt_limit_gross_net%>'/>
										<input type="hidden" id="hdn_refund_yn<%=index%>" name="hdn_refund_yn<%=index%>" value='<%=refund_yn%>'/>
										<input type="hidden" id="hdn_refund_rate<%=index%>" name="hdn_refund_rate<%=index%>" value='<%=refund_rate%>'/>
										<input type="hidden" id="hdn_auto_refund_yn<%=index%>" name="hdn_auto_refund_yn<%=index%>" value='<%=auto_refund_yn%>'/>
										<input type="hidden" id="hdn_utilized_serv_qty<%=index%>" name="hdn_utilized_serv_qty<%=index%>" value='<%=utilized_serv_qty_intg%>'/>
										<input type="hidden" id="hdn_utilized_serv_amt<%=index%>" name="hdn_utilized_serv_amt<%=index%>" value='<%=utilized_serv_amt%>'/>
										<input type="hidden" id="hdn_apply_fact_for_srv_lmt_yn<%=index%>" name="hdn_apply_fact_for_srv_lmt_yn<%=index%>" value='<%=apply_fact_for_srv_lmt_yn%>'/>
<% System.err.println("Check4"); %>
										<input type="hidden" id="hdn_split_allowed_yn<%=index%>" name="hdn_split_allowed_yn<%=index%>" value='<%=split_allowed_yn%>'/>

										<input type="hidden" id="hdn_rowid<%=index%>" name="hdn_rowid<%=index%>" value='<%=rowid%>'/>
										<input type="hidden" id="hdn_package_code<%=index%>" name="hdn_package_code<%=index%>" value='<%=defaultPkgCode%>'/>
										<input type="hidden" id="hdn_package_seq_no<%=index%>" name="hdn_package_seq_no<%=index%>" value='<%=defaultPkgSeq%>'/>
										<input type="hidden" id="pkg_service_long_desc<%=index%>" name="pkg_service_long_desc<%=index%>" value='<%=pkg_service_long_desc%>'/>   
										
									</tr>
<%
									}
								}	
			}
%>				
										<input type='hidden' name='facility_id' id='facility_id'  value='<%=facility_id%>'>
										<input type='hidden' name='locale' id='locale'  value="<%=locale%>" >
										<input type='hidden' name='dbcnt' id='dbcnt'  value='<%=dbcnt%>'>
										<input type='hidden' name='cnt' id='cnt'  value='<%=cnt%>'>	
										<input type='hidden' name='index' id='index'  value='<%=index%>' >
										<input type="hidden"  name="hdn_pack_code" id="hdn_pack_code" value='<%=package_code%>'/>
										<input type="hidden"  name="hdn_pack_seq_no" id="hdn_pack_seq_no" value='<%=package_seq_no%>'/>
										<input type="hidden"  name="parent_pkg_serv_ind" id="parent_pkg_serv_ind" value='<%=parent_pkg_serv_ind%>'/>
										<input type="hidden"  name="parent_pkg_serv_code" id="parent_pkg_serv_code" value='<%=parent_pkg_serv_code%>'/>
										
										<input type='hidden' name='indicatorFldDisabled' id='indicatorFldDisabled'  value='<%=indicatorFldDisabled%>'> 
										<input type='hidden' name='amtFldDisabled' id='amtFldDisabled'  value='<%=amtFldDisabled%>'>
										<input type='hidden' name='qtyFldDisabled' id='qtyFldDisabled'  value='<%=qtyFldDisabled%>'>
										<input type='hidden' name='grossNetDisabled' id='grossNetDisabled'  value='<%=grossNetDisabled%>'>
										<input type='hidden' name='noofdecimal' id='noofdecimal'  value='<%=noofdecimal%>'>	
										
										<input type='hidden' name='pkg_serv_lmt_YN' id='pkg_serv_lmt_YN'  value='<%=pkg_serv_lmt_YN%>'>
										<input type='hidden' name='daily_pkg_lmt_yn' id='daily_pkg_lmt_yn'  value='<%=daily_pkg_lmt_yn%>'>
										<input type='hidden' name='p_daily_pkg_serv_lmt' id='p_daily_pkg_serv_lmt'  value='<%=p_daily_pkg_serv_lmt%>'>
										<input type='hidden' name='p_daily_pkg_serv_lmt_ind' id='p_daily_pkg_serv_lmt_ind'  value='<%=p_daily_pkg_serv_lmt_ind%>'>

										<input type='hidden' name='rowcount' id='rowcount'   value='' >
										<input type='hidden' name='pkgServLmtDtlsPrivYN'  id='pkgServLmtDtlsPrivYN' value='<%=pkgServLmtDtlsPrivYN%>' >
										
									</tbody>
								</table>
							</div>
							</div>	
						</td>
					</tr>
					<tr>
						<td>
							<table width="100%" border="0" cellspacing="0" cellpadding="5">
								<tr>
									<td width="15%" >Package Service Details</td>
									<td>
										<span class="txtgray">
											<input name="pkg_service_long_desc"  type="text" id="pkg_service_long_desc" value="<%=pkg_service_long_des%>" size="50" readonly />
											<input type="button" name="button6" id="button6"  value="Replace Service" disabled/>
										</span>	
										<input type="button" class="button" name="Add"  id="Add" value="Add" onClick="addExclRow(); " />		
										<input type="button" class="button" name="Save"  id="Save" value="Save" onClick="sendBackExclValues();" />			
										<input type="button" class="button" name="Close"  id="Close" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick="window.close()" />										
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
<%
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in MainTreatmentPackageServiceDtls.jsp:"+e);
			
		}
		finally 
		{
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
			if(rst4 != null) rst4.close();
			if(pstmt4 != null) pstmt4.close();
			ConnectionManager.returnConnection(con, request);
		}
%>		

