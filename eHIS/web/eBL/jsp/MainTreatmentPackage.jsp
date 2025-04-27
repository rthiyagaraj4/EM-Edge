<!DOCTYPE html>
<!-- 
Sr No        Version           Incident             SCF/CRF             Developer Name
----------------------------------------------------------------------------------------
1            V210622                  	      PMG2021-COMN-CRF-0076      PalaniNarayanan
2	     V210730           16777	      PMG2021-COMN-CRF-0076      Mohana Priya
3	         V211022           23078	        PMG2021-COMN-CRF-0076.1      Mohana Priya
4			 V211118		   23078	        PMG2021-COMN-CRF-0076.1      Manivel Natarajan
5								30618		  PMG2021-COMN-CRF-0076.2    		  Manivel N
6			V240131						RBU-GHL-CRF-0026-US003				Namrata Charate
----------------------------------------------------------------------------------------
-->


<%@ page import="java.sql.*, webbeans.eBL.*, webbeans.eCommon.*, webbeans.op.CurrencyFormat, java.io.*, java.util.*, eBL.Common.*,com.ehis.util.*,java.text.*,eXH.InterfaceUtil,eBL.*" 
contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
%>
<html>
<head>
<style>
#table-wrapper {
  position:relative;
}
#table-scroll {
 height: 200px;
 width: 512px; 
  overflow: scroll;
}

div.ex1 {
	height: 190px;
	width: 1900px;
	overflow: scroll;
}
/*
div.ex2 {
	height: 200px;
	width: 1900px;
	overflow: scroll;
}	*/

#table-wrapper table {
  width:100%;
}
#table-wrapper table  {
  background:white;
  color:black;
}
#table-wrapper table thead tr {
	position: relative;
	top: expression(offsetParent.scrollTop);
	z-index: 2;
	height: 20px;
	width: 35%;
}

TD.YELLOW 
		{			
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		
		.LocalYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border: 1x;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
SPAN.LABEL
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT;
  /*TEXT-ALIGN: RIGHT;*/
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}
SPAN.SpanYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
</style>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eBL/js/json2.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/MaintainTreamentPackage.js"></script>
<!-- 
<script language="javascript" src='../js/PkgAdhocDiscount.js'></script> 
 -->

<script type="text/javascript">
var headTop = -1;
var FloatHead1;
function processScroll()
{
	if (headTop < 0)
	{
		saveHeadPos();
	}
	if (headTop>0)
	{
		if (document.documentElement && document.documentElement.scrollTop)
			theTop = document.documentElement.scrollTop;
		else if (document.body)
			theTop = document.body.scrollTop;
		if (theTop>headTop)
			FloatHead1.style.top = (theTop-headTop) + 'px';
		else
			FloatHead1.style.top = '0px';
	}
}

function saveHeadPos()
{
	parTable = document.getElementById("divHeadSep");
	if (parTable != null)
	{
		headTop = parTable.offsetTop + 3;
		FloatHead1 = document.getElementById("heading");
		FloatHead1.style.position = "relative";
	}
}
	
function lockKey()
{	 
	if(event.keyCode == 93)
		alert("Welcome to eHIS");
}

function lockbackSpace()
{

 var mode = document.mode.value;

 if(mode=='modify' && window.event.keyCode==8)
  {
   
  }
}
	 
	

function Noprevileage()
{
	alert(getMessage("BL0938","BL"));
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String patientid1 = "";
patientid1 = request.getParameter("patid");
System.err.println("200--maintreatpkg "+patientid1);
String pkg_short_desc = "";
String order_catalog_yn="";
String pkg_short_des= "";
String classval="";
//String pkg_service_long_desc = "";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MTP</title>
</head>

<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"  onScroll="processScroll()"   onSelect="codeArrestThruSelect();" >
<form name='frmMaintainTreat' id='frmMaintainTreat' method='post' >
<%!
private String checkForNull(String inputString)
{

	return (inputString == null) ? "" :	inputString;
}
%>
			<%!public String PkgAmtPriceFormat(String str) {
		if (str == null || str.equals("") || str.equals("E")) {
			str = "0.00";
		} else {
			str = String.format("%.2f", Float.parseFloat(str));
		}
		return str;
	
	}%>

		<%
			String pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "",
					qtyFldDisabled = "", indicatorFldDisabled = "";
			String modifyStatus = "";

			String calenderPrivileageYN = "N", modifyPractPrivYN = "N", assDeassEncPrivYN = "N", pkgServLmtDtlsPrivYN = "N", adhocDiscPrivYN = "N", cancelPkgPrivYN = "N"; // V211118
			String facility_id = "";
			String userid = "";
			String function_id = "";
			String ws_no = "";
			String OP_YN = "N";
			String pkg_adhoc_disc_amt = "0";
			//String patientid1 = "";
			java.util.Properties p = null;
			facility_id = (String) session.getValue("facility_id");
			userid = (String) session.getValue("login_user");

			function_id = "EBL_TRAN_PACKAGE_MAINTAIN";
			p = (java.util.Properties) session.getValue("jdbc");
			ws_no = p.getProperty("client_ip_address");
			//patientid1 = request.getParameter("patid");
			String params = request.getQueryString();
			int index = 0;
			
			// Added for PMG2021-COMN-CRF-0076.1
			String bean_id			= "bl_PkgAdhocDiscountBean" ;
			String bean_name		= "eBL.PkgAdhocDiscountBean";
			PkgAdhocDiscountBean bean	= (PkgAdhocDiscountBean)getBeanObject( bean_id, bean_name, request ) ;
			HashMap adhocDiscountDtls	= bean.getAdhocDiscountDtls();
			bean.clearBean();
			session.removeAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
	
			try { // V211118
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				con = ConnectionManager.getConnection(request);

				String responseText = "";
				String sql = "select privlege_code, NVL(allowed_yn,'N') from bl_user_privileges where user_code = '" + userid
						+ "' and function_id = '" + function_id + "' and sysdate <= NVL(eff_to_date,sysdate) ";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					if("MODIFY_EFF_FROM_MTPKG".equals(rs.getString(1)))
						calenderPrivileageYN = checkForNull(rs.getString(2));
					else if("MODIFY_PRAC_NAME_MTPKG".equals(rs.getString(1)))
						modifyPractPrivYN = checkForNull(rs.getString(2));
					else if("MODIFY_ASSOC_DEASSOC_MTPKG".equals(rs.getString(1)))
						assDeassEncPrivYN = checkForNull(rs.getString(2));
					else if("MODIFY_PKG_SERV_LMT_DTLS_MTPKG".equals(rs.getString(1)))
						pkgServLmtDtlsPrivYN = checkForNull(rs.getString(2));	
					else if("ALLOW_ADHOC_DISC_ENTRY_MTPKG".equals(rs.getString(1)))
						adhocDiscPrivYN = checkForNull(rs.getString(2));	
					else if("ALLOW_CANCEL_PACKAGE_MTPKG".equals(rs.getString(1)))
						cancelPkgPrivYN = checkForNull(rs.getString(2));						
				}
			} catch (Exception e) {
				System.err.println(e);
			}			
			
			System.err.println("PrivileageYN:"+calenderPrivileageYN+"/"+modifyPractPrivYN+"/"+assDeassEncPrivYN+"/"+pkgServLmtDtlsPrivYN+"/"+adhocDiscPrivYN+"/"+cancelPkgPrivYN);
			
			String effDateAuthStr = "", cnclPackAuthStr = "", adhocDiscAuthStr = "", assDeassAuthStr = "", pkgServDtlsAuthStr = "";
			
			if("Y".equals(calenderPrivileageYN)){
				effDateAuthStr = userid + "##" + " " + "##" + "Y"; 
			}
			
			if("Y".equals(cancelPkgPrivYN)){
				cnclPackAuthStr = userid + "##" + " " + "##" + "Y"; 
			}
			
			if("Y".equals(adhocDiscPrivYN)){
				adhocDiscAuthStr = userid + "##" + " " + "##" + "Y"; 
			}
			
			if("Y".equals(assDeassEncPrivYN)){
				assDeassAuthStr = userid + "##" + " " + "##" + "Y"; 
			}
			
			if("Y".equals(pkgServLmtDtlsPrivYN)){
				pkgServDtlsAuthStr = userid + "##" + " " + "##" + "Y"; 
			}			

			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt1 = null;
			ResultSet rs1 = null;

			String package_code = "";
		//	String pkg_short_desc = "";
			String package_seq_no = "";
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
			String across_encounter_yn = "";
			String prac_name = "";
			String physician_id = "";
			String addl_chg_value = "";
			String operating_facility_id = "";
			String total_disc = "";
			//serv dtls
			String pkg_serv_ind = "";
			String pkg_serv_code = "";
			String rate_charge_ind = "";
			String order_catalog_code = "";
			String factor_rate_ind = "";
			int factor_rate_int = 0;//
			int qty_limit_int = 0;//
			String amt_limit_ind = "";
			int amt_limit_int = 0;//
			String group_service_ind = "";
			String incl_home_medication_yn = "";
			String replaceable_yn = "";
			String daily_limit_ind = "";
			int daily_qty_limit_int = 0;//
			int daily_amt_limit_int = 0;//
			String daily_amt_limit_gross_net = "";
			String replaceable_serv_code = "";
			String rep_serv_ord_cat_code = "";
			String refund_yn = "";
			int refund_rate_int = 0;//
			String apply_fact_for_srv_lmt_yn = "";
			String close_package_yn = "";
			int utilized_serv_qty_int = 0;//
			int utilized_serv_amt1_int = 0;//
			String auto_refund_yn1 = "";
			String split_allowed_yn = "";
			String encounter_name = "";

			String encounter_id = "";

			String useraccess = "N";

			String episode_id = "";
			String visit_id = "";
			String episode_type = "";
			String long_desc = "";
			String factor_rate = "";
			String qty_limit = "";
			String amt_limit = "";
			String daily_qty_limit = "";
			String refund_rate = "";
			String utilized_serv_qty = "";
			String utilized_serv_amt = "";
			String auto_refund_yn = "";
			String daily_amt_limit = "";
			String rowid = "";
			String defaultPkgCode = "";
			String defaultPkgSeq = "";
			String defaultEffFromDate = "";
			
	//		String hdrdetailsString="";
		
	//		ArrayList<String> pkghdrDetailsCombination = new ArrayList<String>();

	//		HashMap<String,ArrayList<String>>  pkghdrDetailsEncounters=new HashMap<String,ArrayList<String>>();
		

			ArrayList<String> pkgServiceDetailsCombination = new ArrayList<String>();
			String pkgDetailsCombinationString = "";
			String pkgDetailsCombinationString12="";

			int count = 0;
			int cnt = 0;
			
			String discount_string = "";

			try {
				con = ConnectionManager.getConnection(request);
				HttpSession httpSession = request.getSession(false);
				//String facility_id = (String)httpSession.getValue("facility_id");
		%>
		<center>

			<table width="100%" border="1" cellspacing="0" cellpadding="4">
				<tr>
					<td class="pad4side">
						<table width="100%" border="0"
							cellspacing="0" cellpadding="1">
							<tr>
								<td class="CAGROUPHEADING">Package Details</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<div id="table-wrapper">
							<div class="ex1">
								<table cellpadding="0" cellspacing="0" width="124%"
									id="panel_categories_header_table"
									name="panel_categories_header_table" id="panel_categories_header_table" border="1">
										<div id="tableContainer">
										<thead>
											<tr>
												<td class='COLUMNHEADER' width='4%' align="center" nowrap>Pkg
													Code</td>
												<td class='COLUMNHEADER' width='4%' align="center" nowrap>Pkg
													Seq No</td>
												<td class='COLUMNHEADER' width='3%' align="center" nowrap>Billing
													Class</td>
												<td class='COLUMNHEADER' width='4%' align="center" nowrap>Cust
													Grp Code</td>
												<td class='COLUMNHEADER' width='4%' align="center" nowrap>Cust
													Code</td>
												<td class='COLUMNHEADER' width='4%' align="center" nowrap>Pkg
													Amt</td>
												<td class='COLUMNHEADER' width='4%' align="center" nowrap>Total
													Discount</td>
												<td class='COLUMNHEADER' width='4%' align="center" nowrap>Deposit
													Amt</td>
												<td class='COLUMNHEADER' width='4%' align="center" nowrap>Addl.
													Charge</td>
												<td class='COLUMNHEADER' width='4%' align="center" nowrap>Utilized
													Amt</td>
												<td class='COLUMNHEADER' width='8%' align="center" nowrap>Eff From
													Date</td>
												<td class='COLUMNHEADER' width='8%' align="center" nowrap>Eff To
													Date</td>
												<td class='COLUMNHEADER' width='10%' align="center" nowrap>Practitioner
													Name</td>
												<td class='COLUMNHEADER' width='10%' align="center" nowrap>Encounter
													ID</td>
									
												<td class='COLUMNHEADER' width='4%' align="center"  nowrap>Associate
													/ Deassociate</td>
												<td class='COLUMNHEADER' width='4%' align="center"  nowrap>Adhoc
													Discount</td>
												<td class='COLUMNHEADER' width='4%' align="center" nowrap>Cancel
													Package</td>													 
												<td class='COLUMNHEADER' width='4%' align="center"  nowrap>Cancel
													Reason</td>
												<td class='COLUMNHEADER' width='4%' align="center"  nowrap>Cancel
													Unprocessed Orders</td>
													 
												<td class='COLUMNHEADER' width='8%' align="center" nowrap>Report</td>
												
											</tr>
										</thead>
										<tbody>
											<%
												try {

														String sqlstr = "select a.package_code, a.package_seq_no,to_char(a.eff_from_date, 'dd/mm/yyyy hh24:mi:ss') eff_from_date,to_char(a.eff_to_date, 'dd/mm/yyyy hh24:mi:ss') eff_to_date,"
																+ "a.package_amt,a.deposit_amt,a.utilized_amt,a.blng_class_code,a.cust_group_code,a.cust_code,a.cust_price,case when b.episode_type in ('I','E') then b.encounter_id else to_number(b.encounter_id||lpad(visit_id,4,'0')) end encounter_id,"
																+ "case when b.patient_id is not null then 'Y' else 'N' end encounter_associate_yn,a.physician_id,a.across_encounter_yn,(select am.short_name from am_practitioner am where am.practitioner_id=a.physician_id) prac_name,a.order_catalog_yn,"
																+ "a.addl_chg_value,a.operating_facility_id,a.patient_id,b.encounter_id episode_id,b.visit_id,b.episode_type,(select short_desc from bl_package_lang_vw p where p.operating_facility_id = a.operating_facility_id and p.package_code = a.package_code and upper(language_id) = upper('"
																+ locale + "')) package_short_desc,"
																+ "blpackage.get_total_discount_for_pkg(A.OPERATING_FACILITY_ID,a.PATIENT_ID,a.package_code,a.PACKAGE_SEQ_NO,a.PACKAGE_AMT,b.episode_type,b.encounter_id,b.visit_id) total_discount, blpackage.get_discount_for_pkg_str(a.operating_facility_id,a.patient_id,a.package_code,a.package_seq_no,'','',a.package_amt,b.episode_type,b.encounter_id,b.visit_id) discount_string, NVL(OP_YN,'N') OP_YN,  "
																+ " blpackage.get_adhoc_discount_for_pkg(a.operating_facility_id, a.patient_id,a.package_code,a.package_seq_no, a.package_amt, b.episode_type,b.encounter_id,b.visit_id) pkg_adhoc_disc_amt "
																+ " from bl_package_sub_hdr a, bl_package_encounter_dtls b "
																+ " where a.patient_id='" + patientid1
																+ "' AND a.OPERATING_FACILITY_ID = '"+facility_id
																+ "' and a.status = 'O' and a.operating_facility_id = b.operating_facility_id(+) and a.patient_id = b.patient_id(+) and a.package_code = b.package_code(+) and a.package_seq_no = b.package_seq_no(+) order by a.package_seq_no desc"; //V211022
System.err.println("sqlstr:"+sqlstr);
														/*String sqlstr="select a.PACKAGE_CODE,a.PACKAGE_SEQ_NO,to_char(a.EFF_FROM_DATE, 'dd/mm/yyyy hh24:mi:ss') EFF_FROM_DATE,to_char(a.EFF_TO_DATE, 'dd/mm/yyyy hh24:mi:ss') EFF_TO_DATE,"+
														"a.PACKAGE_AMT,a.DEPOSIT_AMT,a.UTILIZED_AMT,a.BLNG_CLASS_CODE,a.CUST_GROUP_CODE,a.CUST_CODE,a.CUST_PRICE,case when b.episode_type in ('I','E') then b.encounter_id else to_number(b.encounter_id||lpad(visit_id,4,'0')) end encounter_id,"+
														"case when b.patient_id is not null then 'Y' else 'N' end encounter_associate_yn,(select am.SHORT_NAME from am_practitioner am where am.PRACTITIONER_ID=a.PHYSICIAN_ID) prac_name,"+
														"a.ADDL_CHG_VALUE,A.OPERATING_FACILITY_ID,a.PATIENT_ID,b.encounter_id episode_id,b.visit_id,b.episode_type from bl_package_sub_hdr a, bl_package_encounter_dtls b "+
														"where a.patient_id='"+patientid1+"' and a.status = 'O' and a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID(+) and a.patient_id = b.patient_id(+) and a.PACKAGE_CODE = b.PACKAGE_CODE(+) and a.PACKAGE_SEQ_NO = b.PACKAGE_SEQ_NO(+)
														*/
														System.err.println("sqlstr in pkg header : "+sqlstr);
														pstmt = con.prepareStatement(sqlstr);
														rs = pstmt.executeQuery();

														if (rs != null) {
															while (rs.next()) {
																package_code = checkForNull(rs.getString("package_code"));
																package_seq_no = checkForNull(rs.getString("package_seq_no"));
																eff_from_date = checkForNull(rs.getString("eff_from_date"));
																System.err.println("eff_from_date->"+eff_from_date);
																eff_to_date = checkForNull(rs.getString("eff_to_date"));
																package_amt = checkForNull(rs.getString("package_amt"));
																deposit_amt = checkForNull(rs.getString("deposit_amt"));
																utilized_amt = checkForNull(rs.getString("utilized_amt"));
																blng_class_code = checkForNull(rs.getString("blng_class_code"));
																cust_group_code = checkForNull(rs.getString("cust_group_code"));
																cust_code = checkForNull(rs.getString("cust_code"));
																cust_price = checkForNull(rs.getString("cust_price"));
																encounter_name = checkForNull(rs.getString("encounter_id"));
																encounter_associate_yn = checkForNull(rs.getString("encounter_associate_yn"));
																across_encounter_yn = checkForNull(rs.getString("across_encounter_yn"));
																prac_name = checkForNull(rs.getString("prac_name"));
																physician_id = checkForNull(rs.getString("physician_id"));
																System.err.println("physician_id->"+physician_id);
																addl_chg_value = checkForNull(rs.getString("addl_chg_value"));
																operating_facility_id = checkForNull(rs.getString("operating_facility_id"));
																total_disc = checkForNull(rs.getString("total_discount"));

																episode_id = checkForNull(rs.getString("episode_id"));
																visit_id = checkForNull(rs.getString("visit_id"));
																episode_type = checkForNull(rs.getString("episode_type"));
																pkg_short_desc = checkForNull(rs.getString("package_short_desc"));
																order_catalog_yn = checkForNull(rs.getString("order_catalog_yn"));
																OP_YN = checkForNull(rs.getString("OP_YN"));
																pkg_adhoc_disc_amt = checkForNull(rs.getString("pkg_adhoc_disc_amt"));

																System.err.println(" order_catalog_yn " + order_catalog_yn);
																System.err.println("visit_id " + visit_id);
																System.err.println(" episode_type" + episode_type);
																System.err.println("long_desc " + long_desc);
																long_desc = pkg_short_desc;

																pkgDetailsCombinationString = package_code + "|" + package_seq_no + "|" + eff_from_date;
																pkgDetailsCombinationString12=package_code;
																pkgServiceDetailsCombination.add(pkgDetailsCombinationString);
																System.err.println("pkgServiceDetailsCombination !!!!!!!!!!!!!!!!!!!!!!!!!!!"
																		+ pkgServiceDetailsCombination);
																System.err.println("count-->"+count);
																count++;
																if(count==1){
																	pkg_short_des=checkForNull(rs.getString("package_short_desc"));
																	System.err.println("pkg_short_des-->"+pkg_short_des);
																}
																classval="fields";
																
																discount_string = checkForNull(rs.getString("discount_string"));
																System.err.println("discount_string:"+discount_string);
																
																/* String totalDiscQry = "select NVL(sum((case when discount_type = 'R' then (PACKAGE_AMT*(discount/100)) else discount end)),0) total_discount from bl_package_adhoc_discount a, bl_package_sub_hdr b where a.patient_id = '"+patientid1+"' and A.PACKAGE_SEQ_NO = '"+package_seq_no+"' and a.patient_id = b.patient_id and a.package_seq_no = b.package_seq_no";

																PreparedStatement pstmtTotalDiscQry = con.prepareStatement(totalDiscQry);
																ResultSet rsTotalDiscQry = pstmtTotalDiscQry.executeQuery();
																String totAdhocDiscAmt = "0";

																while (rsTotalDiscQry.next()) {
																	totAdhocDiscAmt = rsTotalDiscQry.getString(1);
																}
																
																rsTotalDiscQry.close();
																pstmtTotalDiscQry.close(); */
																
											%>

											<tr id='row<%=count%>' >
												
		 										<%
												if (!package_code.equals("")) {
												%>
												<td class="fields" width='4%' href="#" name='package_code<%=count%>' id='package_code<%=count%>' value="<%=package_code%>" nowrap> <a href="#" onclick="highlightRow(<%=count%>,'<%=classval%>');showPackageServiceDetails(<%=count%>,'<%=pkg_short_desc%>');"><%=package_code%></td>
												<%
													} else {
												%>
												<td class="fields" width='4%' name='package_code<%=count%>' id='package_code<%=count%>' value="<%=package_code%>"
													nowrap>&nbsp;</td>
												<%
													}
												%>
												<%
													if (!package_seq_no.equals("")) {
												%>
												<td class="fields" width='4%' name='package_seq_no<%=count%>' id='package_seq_no<%=count%>' value="<%=package_seq_no%>"
													nowrap><%=package_seq_no%></td>
												<%
													} else {
												%>
												<td class="fields" width='4%' name='package_seq_no<%=count%>' id='package_seq_no<%=count%>' value="<%=package_seq_no%>"
													nowrap>&nbsp;</td>
												<%
													}
												%>
												<%
													if (!blng_class_code.equals("")) {
												%>

												<td class="fields" width='4%' name='blng_class_code<%=count%>' id='blng_class_code<%=count%>'
													nowrap><%=blng_class_code%></td>
													<input type='hidden' name='hid_blng_class_code_<%=count%>' id='hid_blng_class_code_<%=count%>' value='<%=blng_class_code != null ? blng_class_code : ""%>' />													
												<%
													} else {
												%>
												<td class="fields" width='4%' name='blng_class_code<%=count%>' id='blng_class_code<%=count%>'
													nowrap>&nbsp;
													<input type='hidden' name='hid_blng_class_code_<%=count%>' id='hid_blng_class_code_<%=count%>' value='<%=blng_class_code != null ? blng_class_code : ""%>' />												
												</td>
												<%
													}
												%>
												<%
													if (!cust_group_code.equals("")) {
												%>

												<td class="fields" width='4%' name='cust_group_code_<%=count%>' id='cust_group_code_<%=count%>'
													nowrap><%=cust_group_code%></td>
												<%
													} else {
												%>
												<td class="fields" width='4%' name='cust_group_code_<%=count%>' id='cust_group_code_<%=count%>'
													nowrap>&nbsp;</td>
												<%
													}
												%>

												<%
													if (!cust_code.equals("")) {
												%>

												<td class="fields" width='4%' name='cust_code_<%=count%>' id='cust_code_<%=count%>'
													nowrap><%=cust_code%></td>
												<%
													} else {
												%>
												<td class="fields" width='4%' name='cust_code_<%=count%>' id='cust_code_<%=count%>'
													nowrap>&nbsp;</td>
												<%
													}
												%>

												<%
													if (!package_amt.equals("")) {
												%>

												<td class="fields" width='4%' name='package_amt<%=count%>' id='package_amt<%=count%>'
													nowrap><%=PkgAmtPriceFormat(package_amt)%></td>
												<%
													} else {
												%>
												<td class="fields" width='4%' name='package_amt<%=count%>' id='package_amt<%=count%>'
													nowrap>&nbsp;</td>
												<%
													}
												%>

												<%
													if (!total_disc.equals("")) {
												%>
												<td class="fields" width='4%' name='total_disc<%=count%>' id='total_disc<%=count%>'
													nowrap onMouseOver="displayToolTip('<%=discount_string%>',this)" onMouseOut='hideToolTip()' onFocus="displayToolTip('<%=discount_string%>',this)"
													onBlur='hideToolTip()'>
													<span class="LABEL" name='doc_num<%=count%>' id='doc_num<%=count%>'><%=PkgAmtPriceFormat(total_disc)%></span>&nbsp;
													</td>
												<%
													} else {
												%>
												<td class="fields" width='4%' name='total_disc<%=count%>' id='total_disc<%=count%>'
													nowrap>&nbsp;</td>
												<%
													}
												%>
												<%
													if (!deposit_amt.equals("")) {
												%>
												<td class="fields" width='4%' name='deposit_amt1<%=count%>' id='deposit_amt1<%=count%>'
													nowrap><%=deposit_amt%></td>
												<%
													} else {
														System.err.println("deposit_amt,604-"+deposit_amt);
												%>
												<td class="fields" width='4%' name='deposit_amt1<%=count%>' id='deposit_amt1<%=count%>'
													nowrap>&nbsp;</td>
												<%
													}
												%>

												<%
													if (!addl_chg_value.equals("")) {
												%>

												<td class="fields" width='4%' name='addl_chg_value<%=count%>' id='addl_chg_value<%=count%>'
													nowrap><%=PkgAmtPriceFormat(addl_chg_value)%></td>
												<%
													} else {
												%>
												<td class="fields" width='4%' name='addl_chg_value<%=count%>' id='addl_chg_value<%=count%>'
													nowrap>&nbsp;</td>
												<%
													}
												%>

												<%
													if (!utilized_amt.equals("")) {
												%>
												<td class="fields" width='4%' name='utilized_amt<%=count%>' id='utilized_amt<%=count%>'
													nowrap><%=utilized_amt%></td>
												<%
													} else {
												%>
												<td class="fields" width='4%' name='utilized_amt<%=count%>' id='utilized_amt<%=count%>'
													nowrap>&nbsp;</td>
												<%
													
													}
												%>

												<td class='fields' width='8%' style="text-align: center;"
													nowrap>
													<input type='text' name='eff_from_date<%=count%>' id='eff_from_date<%=count%>' size='10' maxlength='10' value="<%=eff_from_date%>"  onBlur="isValidDateTime(this)" <%="N".equals(calenderPrivileageYN) ? "readonly" : ""%> >
													<img src="../../eCommon/images/CommonCalendar.gif" onClick="chkPrivForEffDateChange('eff_from_date<%=count%>','dd/mm/yyyy','hh:mm:ss')" name="eff_from<%=count%>" id="eff_from<%=count%>" onKeyPress="return lockbackSpace();">
													<input name="db_eff_from_date<%=count%>" type="hidden" id="db_eff_from_date<%=count%>" value="<%=eff_from_date%>">
												</td>
												<td class="fields" width='8%' style="text-align: center;"
													nowrap><input type='text' name='eff_to_date<%=count%>'
													id='eff_to_date<%=count%>' size='10' maxlength='10' onKeyPress="return lockbackSpace();"
													value="<%=eff_to_date%>" readonly>
												</td>
												<td class="fields" width='10%' style="text-align: center;"
													nowrap><input type="text" name="prac_name<%=count%>"
													id="prac_name<%=count%>" value="<%=prac_name%>" onBlur='if(this.value!=""){Prac_lkup(this,prac_code<%=count%>)} else{fnClearCode(prac_code<%=count%>)}'/><input
													name="prac_code<%=count%>" type="hidden"
													id="prac_code<%=count%>" value="<%=physician_id%>"> <input  
													name="prac_btn<%=count%>" type="button"
													id="prac_btn<%=count%>" value="?"
													onclick="Prac_lkup(prac_name<%=count%>,prac_code<%=count%>)" >
												</td>
												<td class="fields" width='10%' style="text-align: center;"
													nowrap><input type="text"
													name="encounter_name<%=count%>"
													id="encounter_name<%=count%>" value="<%=encounter_name%>" readonly />
												</td>
												<%
													if (encounter_associate_yn.equals("Y")) {
												%>
		
												<td class="fields" width='4%' style="text-align: center;"
													nowrap><input name="enc_checkbox_dtl<%=count%>"
													type="checkbox" id="enc_checkbox_dtl<%=count%>"
													value="<%=encounter_associate_yn%>" checked
													onclick="closeEncDetails('<%=encounter_associate_yn%>','<%=count%>','<%=package_code%>','<%=package_seq_no%>','<%=eff_from_date%>','<%=facility_id%>','<%=patientid1%>'); ">
											
													<input type='hidden' name='hid_enc_checkbox_dtl<%=count%>' id='hid_enc_checkbox_dtl<%=count%>' value='<%=encounter_associate_yn != null ? encounter_associate_yn : ""%>' />
													<input type='hidden' name='hid_enc_deass_chkb_<%=count%>' id='hid_enc_deass_chkb_<%=count%>' value='' />
												</td>

												<%
												} else {
												%>
					  									<td class="fields" width='4%' style="text-align: center;"
													nowrap><input name="enc_checkbox_dtl<%=count%>"
													type="checkbox" id="enc_checkbox_dtl<%=count%>"
													value="<%=encounter_associate_yn%>"
													onclick="openEncDetails('<%=package_code%>','<%=package_seq_no%>','<%=eff_from_date%>','<%=count%>');isValidEffFromDtChange('<%=count%>'); ">
													
													<input type='hidden' name='hid_enc_checkbox_dtl<%=count%>' id='hid_enc_checkbox_dtl<%=count%>' value='<%=encounter_associate_yn != null ? encounter_associate_yn : ""%>' />
													<input type='hidden' name='hid_enc_deass_chkb_<%=count%>' id='hid_enc_deass_chkb_<%=count%>' value='' />
													
												</td>		
												
												<%
													}
												%>
												<td class="fields" width='4%' style="text-align: center;"
													nowrap ><a href="#"
													id="adhocDisc<%=count%>" name="adhocDisc<%=count%>" onClick="displayAdhocDiscountDtls('<%=patientid1%>','<%=package_code%>','<%=package_seq_no%>','<%=long_desc%>','<%=package_amt%>','<%=episode_type%>','<%=episode_id%>','<%=visit_id%>','<%=cust_group_code%>','<%=cust_code%>' ,'<%=function_id%>', '<%=count%>');"><span id = "adhocDiscDisp_<%=count%>"><%=PkgAmtPriceFormat(pkg_adhoc_disc_amt)%></span> 
												</td>
													
												<td class="fields" width='4%' style="text-align: center;"
													nowrap><input name="cancel_chk<%=count%>"
													type="checkbox" id="cancel_chk<%=count%>"
													onClick="cancelSelectedPackage('<%=count%>')" />
													
													<input type='hidden' name='hid_cancel_pkg_YN_<%=count%>' id='hid_cancel_pkg_YN_<%=count%>' value='N' />
												</td>											

												<td class="fields" width='4%' style="text-align: center;"
													nowrap>
													<input type="text" name="cancel_resn<%=count%>" id="cancel_resn<%=count%>" value="" onBlur="funReasonId(<%=count%>);" readonly />
													<input type='button' value='?' class='button' id="button_<%=count%>" disabled onClick="funReasonId(<%=count%>);" />
												</td>

												<td class="fields" width='4%' style="text-align: center;"
													nowrap><input name="chb_cncl_unprocess_ord_<%=count%>"
													type="checkbox" id="chb_cncl_unprocess_ord_<%=count%>"
													onClick="cancelUnprocessOrd('<%=count%>')" disabled/>
													
													<input type='hidden' name='hid_cncl_unprocess_ord_<%=count%>' id='hid_cncl_unprocess_ord_<%=count%>' value='N' />
												</td>												

												<td class="fields" width='8%' style="text-align: center;"
													nowrap>
											<!--		<input type="submit"
													name="Audit_Report<%=count%>" id="Audit_Report<%=count%>"
													value="Audit" disabled /> &nbsp; 
													-->
													<input type="button"
													name="Utilization_Report<%=count%>"
													id="Utilization_Report<%=count%>" value="Utilization"
													onClick="displayUtilizationDtls('<%=patientid1%>','<%=package_code%>','<%=package_seq_no%>','<%=pkg_short_des%>');" /></td>
												</td>

												<input type="hidden" id="package_code<%=count%>"
													name="package_code<%=count%>" value='<%=package_code%>' />
												<input type="hidden" id="package_seq_no<%=count%>"
													name="package_seq_no<%=count%>" value='<%=package_seq_no%>' />
												  
            									<input type="hidden" 	id="order_catalog_yn<%=count%>" name="order_catalog_yn<%=count%>"   value='<%=order_catalog_yn%>'/>
												<input type="hidden" 	id="enc_assoc_yn<%=count%>" name="enc_assoc_yn<%=count%>"   value='<%=encounter_associate_yn%>'/>
												<input type="hidden" 	id="across_enc_assoc_yn<%=count%>" name="across_enc_assoc_yn<%=count%>"   value='<%=across_encounter_yn%>'/>
            
												<input type="hidden" id="package_amt<%=count%>"
													name="package_amt<%=count%>" value='<%=package_amt%>' />
												<input type="hidden" name="deposit_amt<%=count%>" id="deposit_amt<%=count%>"
												value='<%=deposit_amt%>' />
												<input type="hidden" id="operating_facility_id<%=count%>"
													name="operating_facility_id<%=count%>"
													value='<%=operating_facility_id%>' />
												<input type="hidden" id="cust_group_code<%=count%>"
													name="cust_group_code<%=count%>"
													value='<%=cust_group_code%>'>
												<input type="hidden" id="cust_code<%=count%>"
													name="cust_code<%=count%>" value='<%=cust_code%>'>
												<input type='hidden' name='cancel_code<%=count%>'
													id='cancel_code<%=count%>' value='' />
									<!--			<input type='hidden' name='userid' id='userid' value='<%=userid%>'>
												<input type='hidden' name='ws_no' id='ws_no' value='<%=ws_no%>'>
          -->
												<input type="hidden" id="long_desc<%=count%>"
													name="long_desc<%=count%>" value='<%=long_desc%>' />
												<input type="hidden" id="episode_type<%=count%>"
													name="episode_type<%=count%>" value='<%=episode_type%>' />
												<input type="hidden" id="episode_id<%=count%>"
													name="episode_id<%=count%>" value='<%=episode_id%>' />
												<input type="hidden" id="visit_id<%=count%>"
													name="visit_id<%=count%>" value='<%=visit_id%>' />
												<input type="hidden" id="total_disc<%=count%>"
													name="total_disc<%=count%>" value='<%=visit_id%>' />

												<input type="hidden" id="count1<%=count%>"
													name="count1<%=count%>" value='<%=count%>' />
												<input type='hidden' name='pkg_short_desc<%=count%>' id='pkg_short_desc<%=count%>' value='<%=pkg_short_desc%>'>
										<!--		<input type='hidden' name='patid' id='patid' value = '<%=patientid1%>'>	
												<input type='hidden' name='pkg_short_desc' id='pkg_short_desc' value = '<%=pkg_short_desc%>'>	
												<input type='hidden' name='rowClicked' id='rowClicked' value = '-1'>		-->
												<input type='hidden' name='pkgDetailsCombinationString1<%=count%>' id='pkgDetailsCombinationString1<%=count%>' value = '<%=pkgDetailsCombinationString12%>'>
												<input type="hidden" id="delimAdhocDiscStr_<%=count%>"
													name="delimAdhocDiscStr_<%=count%>" value='' />
												<input type="hidden" id="isAdhocDiscountMod_<%=count%>"
													name="isAdhocDiscountMod_<%=count%>" value='N' />
												<input type="hidden" id="encAssString_<%=count%>"
													name="encAssString_<%=count%>" value='' />	
												<input type="hidden" id="hidOPYN_<%=count%>"
													name="hidOPYN_<%=count%>" value='<%=OP_YN%>' />													
											</tr>
											<%
												}

														}

													} catch (Exception ex) {
														ex.printStackTrace();
														System.err.println("exception in pkg details:" + ex);
													} finally {
														if (rs != null)
															rs.close();
														if (pstmt != null)
															pstmt.close();
													}
											
									/*	if(count>0){
												//System.out.println("classval"+classval+" pkg_short_desc1="+pkg_short_desc1);
												out.println("<script>");
												out.println("highlightRow(1,'"+classval+"')");
												//out.println("showPackageServiceDetails1(1)");
												out.println("</script>");
											}	*/
									if(count==0)
										{%>
										 <script>
										 	parent.BLMaintaintreatmentPackageHdr.location.href = "../../eCommon/html/blank.html";
											parent.BLMaintaintreatmentPackage.location.replace("../../eCommon/html/blank.html");
											alert("There is no open Package for this patient.");
										</script>
										 <%}
										if (count < 7) {
											int bal = 7 - count;
											for (int i = count+1; i < bal; i++) {
											//count++;
											%>
											<tr>
												
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>
												<%
													if (calenderPrivileageYN.equals("N")) {
												%>
												<td class='fields' width='8%' style="text-align: center;" nowrap><input
													type='text' name='pre_eff_from_date<%=i%>'
													id='pre_eff_from_date<%=i%>' size='10' maxlength='10'
													disabled> <img
													src="../../eCommon/images/CommonCalendar.gif"
													name="pre_eff_from<%=i%>" id="pre_eff_from<%=i%>"
													onClick='Noprevileage();' disabled></td>
												<%
													} else {
												%>
												<td class='fields' width='8%' style="text-align: center;" nowrap><input
													type='text' name='pre_eff_from_date<%=i%>'
													id='pre_eff_from_date<%=i%>' size='10' maxlength='10' disabled>
													<img src="../../eCommon/images/CommonCalendar.gif"
													name="pre_eff_from<%=i%>" id="pre_eff_from<%=i%>"
													onClick="return showCalendar('pre_eff_from_date<%=i%>','yyyy-mm-dd','hh:mm:ss');" disabled>
												</td>
												<%
													}
												%>
												<td class="fields" width='8%' style="text-align: center;" nowrap><input
													type='text' name='pre_eff_to_date<%=i%>'
													id='pre_eff_to_date<%=i%>' size='10' maxlength='10'
													value="" disabled></td>
												<td class="fields" width='10%' style="text-align: center;" nowrap><input
													type="text" name="prac_name<%=i%>"
													id="prac_name<%=i%>" value="" disabled /> <input
													name="prac_btn<%=i%>" type="button"
													id="prac_btn<%=i%>" title="?" value="?"
													onclick="Prac_lkup()" disabled></td>
												<td class="fields" width='10%' style="text-align: center;" nowrap><input
													type="text" name="encounter_name<%=i%>"
													id="encounter_name<%=i%>" disabled value="" /></td>
												<td class="fields" width='4%' style="text-align: center;" nowrap><input
													name="enc_checkbox_dtl<%=i%>" type="checkbox"
													id="enc_checkbox_dtl<%=i%>"
													value="<%=encounter_associate_yn%>"
													onclick="openEncDetails('<%=package_code%>'); "></td>
												<td class="fields" width='4%' style="text-align: center;" nowrap><a
													href="#" onclick="openDiscDetails();">Links</td>

												<td class="fields" width='4%' style="text-align: center;"  nowrap><input
													name="cancel_chk<%=i%>" type="checkbox"
													id="cancel_chk<%=i%>" /></td>
													
												<td class="fields" width='4%' style="text-align: center;"  nowrap><input
													type="text" name="cancel_resn<%=i%>"
													id="cancel_resn<%=i%>" value='' /><input type='button'
													value='?' class='button' onClick="funReasonId('C')" /></td>
													
												<td class="fields" width='4%' align="left" nowrap>&nbsp;</td>

												<td class="fields" width='8%' style="text-align: center;" nowrap>
										<!--		<input
													type="submit" name="Audit_Report<%=i%>"
													id="Audit_Report<%=i%>" value="Audit" disabled />
													&nbsp;-->
													<input type="submit"
													name="Utilization_Report<%=i%>"
													id="Utilization_Report<%=i%>" value="Utilization" disabled /></td>
												</td>
											</tr>
											<%
												}
													}
											%>
										</tbody>
									</div>
								</table>

							</div>
						</div>
					</td>
				</tr>
				<tr>&nbsp;&nbsp;&nbsp;</tr>
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0"
							cellpadding="5">
							<tr>
								<td width="10%">Package Description</td>
								<td>
									<span class="txtgray"> 
										<input name="Package_Description" id="Package_Description" type="text"
										id="Package_Description" value="<%=pkg_short_des%>" readonly />
									</span>
								</td>
								<td colspan="6">&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>
			 </table>
			 <input type='hidden' name='rowClicked' id='rowClicked' value = '-1'>	
			 <input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'> 
          <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		  <input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		  <input type="hidden" id="totcount" name="totcount" value='<%=count%>' />
		  <input type="hidden" id="hdrModified" name="hdrModified" value='N' />
		  <input type='hidden' name='patid' id='patid' value = '<%=patientid1%>'>	
		  <input type='hidden' name='userid' id='userid' value='<%=userid%>'>
		  <input type='hidden' name='ws_no' id='ws_no' value='<%=ws_no%>'>
		<input type='hidden' name='calenderPrivileageYN' id='calenderPrivileageYN' value='<%=calenderPrivileageYN%>'> 
		<input type='hidden' name='modifyPractPrivYN' id='modifyPractPrivYN' value='<%=modifyPractPrivYN%>'> 
		<input type='hidden' name='assDeassEncPrivYN' id='assDeassEncPrivYN' value='<%=assDeassEncPrivYN%>'> 
		<input type='hidden' name='pkgServLmtDtlsPrivYN' id='pkgServLmtDtlsPrivYN' value='<%=pkgServLmtDtlsPrivYN%>'> 
		<input type='hidden' name='adhocDiscPrivYN' id='adhocDiscPrivYN' value='<%=adhocDiscPrivYN%>'> 
		<input type='hidden' name='cancelPkgPrivYN' id='cancelPkgPrivYN' value='<%=cancelPkgPrivYN%>'> 	
		
		<input type='hidden' name='effDateAuthStr' id='effDateAuthStr' value='<%=effDateAuthStr%>'>
		<input type='hidden' name='adhocDiscAuthStr' id='adhocDiscAuthStr' value='<%=adhocDiscAuthStr%>'>
		<input type='hidden' name='cnclPackAuthStr' id='cnclPackAuthStr' value='<%=cnclPackAuthStr%>'>
		<input type='hidden' name='assDeassAuthStr' id='assDeassAuthStr' value='<%=assDeassAuthStr%>'>
		<input type='hidden' name='pkgServDtlsAuthStr' id='pkgServDtlsAuthStr' value='<%=pkgServDtlsAuthStr%>'>
		
		
</center>
</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
	<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='3'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='t'></td>
				<!-- </td> -->
			</tr>
		</table>
	</div>

</body> 
</html>
<%
	}
	catch(Exception e )
	{ 
		//out.println(e);
		e.printStackTrace();
	}
	finally
	{	
		ConnectionManager.returnConnection(con, request);
	}
%> 
	

