<!DOCTYPE html>
<!-- 
Sr No        Version           Incident             SCF/CRF             Developer Name
----------------------------------------------------------------------------------------
1            V210622                  	      PMG2021-COMN-CRF-0076      PalaniNarayanan
2	     V210730           16777	      PMG2021-COMN-CRF-0076      Mohana Priya
3			 V211118		   23078	        PMG2021-COMN-CRF-0076.1      Manivel Natarajan
4								30618		  PMG2021-COMN-CRF-0076.2    		  Manivel N
----------------------------------------------------------------------------------------
-->

<%@ page
	import="java.sql.*, webbeans.eBL.*, webbeans.eCommon.*, webbeans.op.CurrencyFormat, java.io.*, java.util.*, eBL.Common.*,com.ehis.util.*,java.text.*,eXH.InterfaceUtil,eBL.*"
	contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
System.err.println("serv jsp--");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
	String locale = (String) session.getAttribute("LOCALE");
%>
<html>
<head>
<style>
#table-wrapper {
	position: relative;
}

#table-scroll {
	height: 200px;
	width: 512px;
	overflow: scroll;
}

div.ex1 {
	height: 200px;
	width: 1900px;
	overflow: scroll;
}

div.ex2 {
	height: 200px;
	width: 1900px;
	overflow: scroll;
}

#table-wrapper table {
	width: 100%;
}

#table-wrapper table {
	background: white;
	color: black;
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
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
<script language='javascript' src='../../eBL/js/json2.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eBL/js/MaintainTreamentPackage.js"></script>
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
patientid1 = request.getParameter("patinetId_new");
System.err.println("200--servv "+patientid1);
String pkg_short_desc = "";
String classval="fields";
String pkg_service_long_desc = "";
String pkg_service_long_des = "";
String pkgServLmtDtlsPrivYN = "N";//V211118
pkgServLmtDtlsPrivYN = request.getParameter("pkgServLmtDtlsPrivYN");
if(pkgServLmtDtlsPrivYN == null) pkgServLmtDtlsPrivYN = "N";
System.err.println("pkgServLmtDtlsPrivYN in dtls:"+pkgServLmtDtlsPrivYN);

String pkgServDtlsAuthStr = request.getParameter("pkgServDtlsAuthStr");
if(pkgServDtlsAuthStr == null) pkgServDtlsAuthStr = "";
System.err.println("pkgServDtlsAuthStr in dtls:"+pkgServDtlsAuthStr);
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MTP</title>
</head>

<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"
	onScroll="processScroll()" onSelect="codeArrestThruSelect();" onload="disableForAuthorisation('<%=pkgServLmtDtlsPrivYN%>')">
	<form name='frmMaintainTreatserv' id='frmMaintainTreatserv' method='post' onload="disableForAuthorisation(<%=pkgServLmtDtlsPrivYN%>);">
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
<%!public String PkgqtyFormat(String str) {
			if (str == null || str.equals("")) {
				str = "0.00";
			} else {
				str = String.format("%.2f", Float.parseFloat(str));
			}
			return str;
		}%>

		<%
			String pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "",
					qtyFldDisabled = "", indicatorFldDisabled = "", grossNetDisabled="";
			//String disable="";
			//String disabled="";
			String modifyStatus = "";

			String facility_id = "";
			String userid = "";
			String function_id = "";
			String privlege_code = "";
			String ws_no = "";
			//String patientid1 = "";
			java.util.Properties p = null;
			//facility_id = (String) session.getValue("facility_id");
			userid = (String) session.getValue("login_user");

			function_id = "EBL_TRAN_PACKAGE_MAINTAIN";
			privlege_code = "MODIFY_PKG_SERV_LMT_DTLS_MTPKG";
			p = (java.util.Properties) session.getValue("jdbc");
			ws_no = p.getProperty("client_ip_address");
		//	String called = checkForNull(request.getParameter("calledfrom"));
		//	System.err.println("called--"+called);
			String params = request.getQueryString();
			int index = 0;
			
			// V211118
			int selectedItemIndex = 0;
			selectedItemIndex = Integer.parseInt(request.getParameter("selectedItemIndex"));
			System.err.println("selectedItemIndex:"+selectedItemIndex);



			// V211118 Ends

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt1 = null;
			ResultSet rs1 = null;
			PreparedStatement pstmt3 = null;
			ResultSet rst3 = null;
			PreparedStatement pstmt4 = null;
			ResultSet rst4 = null;

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
			String prac_name = "";
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
			String incl_home_medication_yn1 = "";
			String home_med_enable_yn="";
			String home_med_enbl_disbl="";
			String replaceable_yn = "";
			String replaceable_yn1 = "";
			String daily_limit_ind = "";
		//	int daily_qty_limit_int = 0;
			int daily_qty_limit_int;
		//	int daily_amt_limit_int = 0;
			int daily_amt_limit_int;//
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
			String utilized_serv_qty_intg="";
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
			//String utilized_serv_qty="";
			//String utilized_serv_amt="";
			int utilized_serv_amt_int = 0;
			//int utilized_serv_amt_int =0;
			String rowid = "";
		//	String classval="";
		//	String pkg_service_long_desc = "";
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
			System.err.println("pkgDetailsCombinationString->"+pkgDetailsCombinationString);
			int count = 0;
			int cnt = 0;
			int noofdecimal = 2;
			boolean pkg_serv_ind_lmt=false;
			String pkg_serv_ind_lmt_YN = "N";
			String PKG_LIMIT_IND_BY="";
			String pkg_serv_lmt_YN="N";
			boolean pkg_serv_lmt=false;
			String daily_pkg_lmt_yn="N";
			String p_daily_pkg_serv_lmt="N";
			String p_daily_pkg_serv_lmt_ind="N";
			try {
				con = ConnectionManager.getConnection(request);
				HttpSession httpSession = request.getSession(false);
				
				try{
					pkg_serv_ind_lmt = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_PKG_SERV_IND_LIMIT");
					System.err.println("pkg_serv_ind_lmt-->"+pkg_serv_ind_lmt);
					if (pkg_serv_ind_lmt)
						pkg_serv_ind_lmt_YN = "Y";
					else
						pkg_serv_ind_lmt_YN = "N";
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
				try{
					pkg_serv_lmt = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_DAILY_PKG_SERV_LIMIT");
					System.err.println("pkg_serv_lmt-->"+pkg_serv_lmt);
					if (pkg_serv_lmt)
						pkg_serv_lmt_YN = "Y";
					else
						pkg_serv_lmt_YN = "N";
					
					System.err.println("pkg_serv_lmt_YN-->"+pkg_serv_lmt_YN);
				}catch(Exception e){
					e.printStackTrace();
				}	
				
				try{				
					pstmt = con.prepareStatement(" select nvl(no_of_decimal,2) from  sm_acc_entity_param where acc_entity_id='ZZ'");

					rs = pstmt.executeQuery();
					if (rs.next() && rs != null)
						noofdecimal = rs.getInt(1);				
				} catch (Exception e) {
					System.err.println("Exception Getting Number of Decimals. " + e.toString());
					noofdecimal = 2;
					e.printStackTrace();
				} finally {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}			
			
				//String facility_id = (String)httpSession.getValue("facility_id");
		%>
		<center>
			<table width="100%" border="1" cellspacing="0" cellpadding="3">
			<tr>
				<td class="pad4side">
					<table width="100%" border="0"
							cellspacing="0" cellpadding="1">
						<tr>
							<td class="CAGROUPHEADING">Package Service Details</td>
						</tr>
					</table>
				 </td>
			</tr> 
			<tr>
				<td>
					<div id="table-wrapper">
						<div class="ex2">
							<table cellpadding="0" cellspacing="0" width="100%"
									id="maintainTrtPkgDtls" name="maintainTrtPkgDtls" id="maintainTrtPkgDtls" border="1">
								<div id="tableContainer">
									<thead style="position: sticky; top: 0px;">
										<tr >
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Indicator</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Package
												Services</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Rate
												Charge</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Order
												Catalog Code</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Rate
												Indicator</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Factor
												Rate</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Qty
												Limit</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Limit
												Ind</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Amount
												Limit</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Group/Service
												level</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Home
												Medication Group</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Replaceable</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Replaceable
												Service</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Replaceable
												Catalog</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Daily
												Limit Indicator</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Daily
												Qty Limit</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Daily
												Amount Limit</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Refund</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Refund
												Rate</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Auto
												Refund</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Closed</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Utilized
												Qty</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Utilized
												Amount</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Appl
												Factor</td>
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>Split
												Allowed</td>
									   <!--   		<td class='COLUMNHEADER' style="text-align: center;" nowrap>Service
												Limit</td>   -->
											<td class='COLUMNHEADER' style="text-align: center;" nowrap>&nbsp;</td>												
											
										</tr>
									</thead>
									<tbody>
										<%
											try {

														String patinetId_new = checkForNull(request.getParameter("patinetId_new"));

														String operating_facility_id_new = checkForNull(request.getParameter("operating_facility_id_new"));
														operating_facility_id_new=operating_facility_id_new.replaceAll("\\s", "");
														facility_id=operating_facility_id_new;
														System.err.println("facility_id===>>"+facility_id+"val");
														String package_code_new = checkForNull(request.getParameter("package_code_new"));
														String package_seq_no_new = checkForNull(request.getParameter("package_seq_no_new"));
														String calledfrom = checkForNull(request.getParameter("calledfrom"));
														if(calledfrom == null) calledfrom = "";
														order_catalog_yn = checkForNull(request.getParameter("order_catalog_yn"));
														across_enc_YN = checkForNull(request.getParameter("across_enc_yn"));
														
														visit_id = checkForNull(request.getParameter("visit_id"));
														episode_id = checkForNull(request.getParameter("episode_id"));
														episode_type = checkForNull(request.getParameter("episode_type"));


														//String pkg = (String) pkgServiceDetailsCombination.get(0);
														String pkg = pkgDetailsCombinationString;
														StringTokenizer stEncList = new StringTokenizer(pkg, "|");
														//System.err.println("stEncList===>>"+stEncList);
															
															System.err.println("enc_assoc_YN===>>"+across_enc_YN);

														defaultPkgCode = stEncList.hasMoreTokens() ? stEncList.nextToken() : "";
														defaultPkgSeq = stEncList.hasMoreTokens() ? stEncList.nextToken() : "";
													//	defaultEffFromDate = stEncList.hasMoreTokens() ? stEncList.nextToken() : "";
													defaultEffFromDate =checkForNull(request.getParameter("eff_from_date"));
													
														System.err.println("defaultEffFromDate===>>"+defaultEffFromDate);
														
														try {
															pstmt3 = con.prepareStatement("select PKG_LIMIT_IND_BY from bl_parameters where operating_facility_id = ?"); //--:PARAMETER.P_PKG_LIMIT_IND_BY-- value is B - both, G - group, S - service
															System.err.println("facility_id===>>"+facility_id);
															pstmt3.setString(1,facility_id); 
															rst3 = pstmt3.executeQuery() ;
														}
														catch(Exception ex){
															ex.printStackTrace();
														}
														if( rst3 != null ) 
														{	
															while( rst3.next() )
															{  
																PKG_LIMIT_IND_BY = rst3.getString("PKG_LIMIT_IND_BY");
															//	str_charge_logic = rsst.getString(2);
															//	payerGrpBySetup  = rsst.getString(3);
															
																System.err.println("PKG_LIMIT_IND_BY===>>"+PKG_LIMIT_IND_BY);
															}
														}
														System.err.println("pkg_serv_lmt_YN,536===>>"+pkg_serv_lmt_YN);
														if(pkg_serv_lmt_YN.equals("Y")){
															try {
																/*	pstmt4 = con.prepareStatement("SELECT NVL (daily_pkg_lmt_yn, 'N'),pkg_serv_lmt_by,daily_pkg_lmt_by INTO p_daily_limit_chk_yn,p_daily_pkg_serv_lmt_ind,p_daily_pkg_serv_lmt FROM bl_parameters WHERE operating_facility_id = ?");
																*/
																	pstmt4 = con.prepareStatement("SELECT NVL (daily_pkg_lmt_yn, 'N') p_daily_limit_chk_yn,pkg_serv_lmt_by p_daily_pkg_serv_lmt_ind,NVL(daily_pkg_lmt_by,'') p_daily_pkg_serv_lmt FROM bl_parameters WHERE operating_facility_id = ?");
																
																	System.err.println("facility_id,395==>>"+facility_id);
																	pstmt4.setString(1,facility_id); 
																	rst4 = pstmt4.executeQuery() ;
															}catch(Exception exe){
																	exe.printStackTrace();
																}
															if( rst4 != null ) 
																{	
																while( rst4.next() )
																{  
																daily_pkg_lmt_yn = rst4.getString("p_daily_limit_chk_yn");
																p_daily_pkg_serv_lmt = rst4.getString("p_daily_pkg_serv_lmt");
																p_daily_pkg_serv_lmt_ind  = rst4.getString("p_daily_pkg_serv_lmt_ind");

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
														else{
															indicatorFldDisabled="disabled";
															amtFldDisabled = "disabled";
															qtyFldDisabled = "disabled"; 
															grossNetDisabled="disabled";
														} //V210901
														
														System.err.println("daily_pkg_lmt_yn,577===>>"+daily_pkg_lmt_yn);
														System.err.println("order_catalog_yn,577===>>"+order_catalog_yn);
													//	System.err.println("enc_assoc_YN,577===>>"+enc_assoc_YN);
														if(daily_pkg_lmt_yn.equals("Y") && order_catalog_yn.equals("N") && across_enc_YN.equals("N")){
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
															}else{
																indicatorFldDisabled="disabled";
																amtFldDisabled = "disabled";
																qtyFldDisabled = "disabled"; 
																grossNetDisabled="disabled";
															}
														}else{
															indicatorFldDisabled="disabled";
															amtFldDisabled = "disabled";
															qtyFldDisabled = "disabled"; 
															grossNetDisabled="disabled";
														}
														
														String sqlstr1 = "";
														if (!calledfrom.equals("UPDATE")) {
															System.err.println("952===>>");
															sqlstr1 = "select  pkg_serv_ind pack_serv,pkg_serv_code,rate_charge_ind,null order_catalog_code,rate_ind factor_rate_ind,factor_rate,qty_limit,amt_limit_ind,"
																	+ "amt_limit,group_service_ind,incl_home_medication_yn,replaceable_yn,daily_limit_ind,daily_qty_limit,daily_amt_limit,daily_amt_limit_gross_net,"
																	+ "replaceable_serv_code,rep_serv_ord_cat_code,refund_yn,refund_rate,apply_fact_for_srv_lmt_yn,close_package_yn,utilized_serv_qty,"
																	+ "utilized_serv_amt,auto_refund_yn,split_allowed_yn,rowid,blpackage.get_description(pkg_serv_ind,pkg_serv_code,'"
																	+ locale + "') pkg_service_long_desc from bl_package_sub_dtls" + " where patient_id = '"
																	+ patientid1 + "' and " + "operating_facility_id = '" + operating_facility_id + "' and "
																	+ "package_code = '" + defaultPkgCode + "' and package_seq_no = '" + defaultPkgSeq
																	+ "'";
														} else {
															System.err.println("453===>>");
															sqlstr1 = "select pkg_serv_ind pack_serv,pkg_serv_code,rate_charge_ind,null order_catalog_code,rate_ind factor_rate_ind,factor_rate,qty_limit,amt_limit_ind,"
																	+ "amt_limit,group_service_ind,incl_home_medication_yn,replaceable_yn,daily_limit_ind,daily_qty_limit,daily_amt_limit,daily_amt_limit_gross_net,"
																	+ "replaceable_serv_code,rep_serv_ord_cat_code,refund_yn,refund_rate,apply_fact_for_srv_lmt_yn,close_package_yn,round(utilized_serv_qty,2) utilized_serv_qty,"
																	+ "utilized_serv_amt,auto_refund_yn,split_allowed_yn,rowid,blpackage.get_description(pkg_serv_ind,pkg_serv_code,'"
																	+ locale + "') pkg_service_long_desc,blcommonproc.bl_pharm_service_yn ('en',pkg_serv_ind,pkg_serv_code) home_medication_enable_yn from bl_package_sub_dtls" + " where patient_id = '"
																	+ patinetId_new + "' and " + "operating_facility_id = '"+ operating_facility_id_new
																	+"' and " + "package_code = '" + package_code_new + "' and package_seq_no = '"
																	+ package_seq_no_new + "'";

															defaultPkgCode = package_code_new;
															defaultPkgSeq = package_seq_no_new;

															System.err.println("defaultPkgCode after update==========>>" + defaultPkgCode);
															System.err.println("defaultPkgSeq after update ==========>>" + defaultPkgSeq);
														}
														System.err.println("sqlstr1 ==========>>"+sqlstr1 );
														pstmt1 = con.prepareStatement(sqlstr1);
														rs1 = pstmt1.executeQuery();
														if (rs1 != null) {
															while (rs1.next()) {
																index = rs1.getRow();

																pkg_serv_ind = checkForNull(rs1.getString("pack_serv"));
																System.err.println("pkg_serv_ind====>>488 " + pkg_serv_ind);
																pkg_serv_code = checkForNull(rs1.getString("pkg_serv_code"));
																System.err.println("pkg_serv_code====>>488 " + pkg_serv_code);
																rate_charge_ind = checkForNull(rs1.getString("rate_charge_ind"));
																System.err.println("rate_charge_ind====>>488 " + rate_charge_ind);
																order_catalog_code = checkForNull(rs1.getString("order_catalog_code"));
																System.err.println("order_catalog_code====>>488 " + order_catalog_code);
																factor_rate_ind = checkForNull(rs1.getString("factor_rate_ind"));
																System.err.println("factor_rate_ind====>>488 " + factor_rate_ind);
																amt_limit_ind = checkForNull(rs1.getString("amt_limit_ind"));
																System.err.println("amt_limit_ind====>>488 " + amt_limit_ind);
																
																group_service_ind = checkForNull(rs1.getString("group_service_ind"));
																if(group_service_ind.equals("")){
																	group_service_ind="B";
																}
																System.err.println("group_service_ind====>>488 " + group_service_ind);
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
																	
														/*			if(("Y").equals(incl_home_medication_yn1)){
																			incl_home_medication_yn="checked readonly";
																	}
																	else{
																		incl_home_medication_yn="unchecked";
																	}
																*/	
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
																rep_serv_ord_cat_code = checkForNull(rs1.getString("rep_serv_ord_cat_code"));
																System.err.println("rep_serv_ord_cat_code====>>" + rep_serv_ord_cat_code);
																refund_yn = checkForNull(rs1.getString("refund_yn"));
																System.err.println("refund_yn====>>" + refund_yn);
																
																apply_fact_for_srv_lmt_yn = checkForNull(rs1.getString("apply_fact_for_srv_lmt_yn"));
																System.err.println("apply_fact_for_srv_lmt_yn====>>" + apply_fact_for_srv_lmt_yn);
																close_package_yn = checkForNull(rs1.getString("close_package_yn"));
																auto_refund_yn = checkForNull(rs1.getString("auto_refund_yn"));
																split_allowed_yn = checkForNull(rs1.getString("split_allowed_yn"));
																
																daily_qty_limit = checkForNull(rs1.getString("daily_qty_limit"));
																qty_limit = checkForNull(rs1.getString("qty_limit"));
																amt_limit = checkForNull(rs1.getString("amt_limit"));
																daily_amt_limit = checkForNull(rs1.getString("daily_amt_limit"));
																refund_rate = checkForNull(rs1.getString("refund_rate"));
																factor_rate = checkForNull(rs1.getString("factor_rate"));
																System.err.println("refund_rate=="+refund_rate);
															/*	factor_rate_int = rs1.getInt("factor_rate");
																factor_rate = checkForNull(Integer.toString(factor_rate_int));
																
																	
																qty_limit_int = rs1.getInt("qty_limit");
																qty_limit = checkForNull(Integer.toString(qty_limit_int));
																amt_limit_int = rs1.getInt("amt_limit");
																amt_limit = checkForNull(Integer.toString(amt_limit_int));

																daily_qty_limit_int = rs1.getInt("daily_qty_limit");
																System.err.println("daily_qty_limit_int====>>" + daily_qty_limit_int);
																daily_qty_limit = checkForNull(Integer.toString(daily_qty_limit_int));
																daily_amt_limit_int = rs1.getInt("daily_amt_limit");
																daily_amt_limit = checkForNull(Integer.toString(daily_amt_limit_int));
																
																
																refund_rate_int = rs1.getInt("refund_rate");
																System.err.println("refund_rate_int,872====>>" + refund_rate_int);
																refund_rate = checkForNull(Integer.toString(refund_rate_int));
																System.err.println("refund_rate====>>873" + refund_rate_int);
																*/
													
																utilized_serv_qty_intg = checkForNull(rs1.getString("utilized_serv_qty"));
																utilized_serv_amt = checkForNull(rs1.getString("utilized_serv_amt"));	
																System.err.println("utilized_serv_qty_int :: " + utilized_serv_qty_intg);
															
																rowid = checkForNull(rs1.getString("rowid"));
																pkg_service_long_desc = checkForNull(rs1.getString("pkg_service_long_desc"));

																System.err
																		.println("order_catalog_code :: ======================>855>" + order_catalog_code);
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
																System.err.println("cnt-->"+cnt);
																if(cnt==1){
																	System.err.println("cnt1-->1");
																	pkg_service_long_des=checkForNull(rs1.getString("pkg_service_long_desc"));
																	System.err.println("pkg_service_long_des-->"+pkg_service_long_des);
																}
																System.err.println("pkg_service_long_des-->"+pkg_service_long_des);
											%>

										<tr id='row1<%=index%>'  onclick="showPackageServiceDesc(<%=count%>,'<%=pkg_service_long_desc%>');">
											<td class='fields' nowrap>
													<select style="width: 150px;"
													name="pkg_serv_ind<%=index%>" id='pkg_serv_ind<%=index%>'
													onChange='onCustServiceTypeChange(this,"<%=index%>");grpServiceVal(this,"<%=index%>",1);'
													<%=modifyStatus%>>
														<option value='G'
															<%=pkg_serv_ind.equals("G") ? "selected" : ""%>><fmt:message
																key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}" /></option>
														<option value='C'
															<%=pkg_serv_ind.equals("C") ? "selected" : ""%>><fmt:message
																key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}" /></option>
														<option value='S'
															<%=pkg_serv_ind.equals("S") ? "selected" : ""%>><fmt:message
																key="Common.BillingService.label"
																bundle="${common_labels}" /></option>
														<option value='P'
															<%=pkg_serv_ind.equals("P") ? "selected" : ""%>><fmt:message
																key="eBL.PackageGrouping.label" bundle="${bl_labels}" /></option>
														<option value='M'
															<%=pkg_serv_ind.equals("M") ? "selected" : ""%>><fmt:message
																key="eBL.Items.label" bundle="${bl_labels}" /></option>
													</select>
												</td>
												<td class='fields' nowrap>
												<input name="pkg_serv_code<%=index%>" id="pkg_serv_code<%=index%>" type="text"  size="20" value=<%=pkg_serv_code%> onblur='if(this.value!=""){servlookup(<%=index%>,this,pkg_serv<%=index%>);checkduplicate(<%=index%>);}'> 
												<input type='hidden' name='pkg_serv<%=index%>' id='pkg_serv<%=index%>'  value=''>
												<input type="button" name="button_pkg_serv_code<%=index%>"  id="button_pkg_serv_code<%=index%>" value="?" onClick='servlookup(<%=index%>,pkg_serv_code<%=index%>,pkg_serv<%=index%>);checkduplicate(<%=index%>);' >
			       								 </td>
			        
											      <td  class="fields" 	  >
								     				<input type="text"  size='10'  style="text-align:center;"  name="rate_charge_ind<%=index%>"  id="rate_charge_ind<%=index%>" value="<%=rate_charge_ind%>" readonly />
								    			 </td>
											      <td  class="fields" 	 nowrap>
								                     <input type="text" size='20' style="text-align:center;"  name="order_catalog_code<%=index %>"   id="order_catalog_code<%=index %>" value="<%=order_catalog_code%>" disabled />
								              	 </td>
								           		 <td class='fields' nowrap >
													<% if(factor_rate_ind.equals("G") || factor_rate_ind.equals("C")){ %>
													<select name='factor_rate_ind<%=index%>'   id='factor_rate_ind<%=index%>' onChange='onIndChange(this,"<%=index%>")' <%=modifyStatus%>>
														<option value='S' <%=factor_rate_ind.equals("S")?"selected":""%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option>
														<option value='R' <%=factor_rate_ind.equals("R")?"selected":""%> ><fmt:message key="eBL.AsPerRule.label" bundle="${bl_labels}"/></option>
														<option value='P' <%=factor_rate_ind.equals("P")?"selected":""%> ><fmt:message key="eBL.PRICE_CLASS.label" bundle="${bl_labels}"/></option>
													</select>
													<%}else{%>	
													<select name='factor_rate_ind<%=index%>'  id='factor_rate_ind<%=index%>' onChange='onIndChange(this,"<%=index%>")' <%=modifyStatus%>>
														<option value='S' <%=factor_rate_ind.equals("S")?"selected":""%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option>
														<option value='R' <%=factor_rate_ind.equals("R")?"selected":""%> ><fmt:message key="eBL.AsPerRule.label" bundle="${bl_labels}"/></option>
														<option value='U' <%=factor_rate_ind.equals("U")?"selected":""%> ><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></option>
														<option value='P' <%=factor_rate_ind.equals("P")?"selected":""%> ><fmt:message key="eBL.PRICE_CLASS.label" bundle="${bl_labels}"/></option>
														<option value='X' <%=factor_rate_ind.equals("X")?"selected":""%> ></option>
													</select>
													<%}%>
													</td>
													<td  class="fields" >
										               <input type="text" size='10' style="text-align:center;"  name="factor_rate<%=index%>"  id="factor_rate<%=index%>" value=<%=factor_rate%>  onfocus="resetAlertFlag()">
										             </td>
										             <td  class="fields" 	>
										              	   <input type="text" size='10'  style="text-align:center;"  name="qty_limit<%=index%>"   id="qty_limit<%=index%>" value=<%=qty_limit%>>
										              </td>
										            <td  align="left" nowrap>
														<select style="width:100px;" name='amt_limit_ind<%=index%>' id='amt_limit_ind<%=index%>' onChange='grpServiceVal(this,"<%=index%>",2);validatefactorlmt(document.forms[0].rate_charge_ind<%=index%>,this,<%=index%>,3);'>
															<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
															<option value='A' <%=(amt_limit_ind.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
															<option value='P'  <%=(amt_limit_ind.equals("P")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
															<option value='U'  <%=(amt_limit_ind.equals("U")?"selected":"") %> ><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option>
														</select>
													</td>
												     <td  class="fields" 	 nowrap>
										                 	<input type="text" style="text-align:center;"  name="amt_limit<%=index%>"  id="amt_limit<%=index%>" value=<%=amt_limit%>>
										              </td>
										            <%if("Y".equals(pkg_serv_ind_lmt_YN)) {%>
										               <td  align="left" nowrap>
																<select style="width:100px;" name='GrpsSrvind<%=index%>'  id='GrpsSrvind<%=index%>' onChange='validateGrpservInd(this,"<%=index%>");' disabled>
																	<option value="B" <%=(group_service_ind.equals("B")?"selected":"") %> ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
																	<option value='G' <%=(group_service_ind.equals("G")?"selected":"") %> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
																	<option value='S'  <%=(group_service_ind.equals("S")?"selected":"") %> ><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
																	
																</select>
															</td>
								             		<%} else{%>
								              
										               <td  align="left" nowrap>
														<select style="width:100px;" name='GrpsSrvind<%=index%>'  id='GrpsSrvind<%=index%>' onChange='validateGrpservInd(this,"<%=index%>");' disabled>
															<option value="B"><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
															<option value='G' <%=(group_service_ind.equals("G")?"selected":"") %> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
															<option value='S'  <%=(group_service_ind.equals("S")?"selected":"") %> ><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
															
														</select>
														</td>
													<%} %>
				             						
										               <td class='fields'  nowrap><input type="checkbox" name="incl_home_medication_yn<%=index %>" id="incl_home_medication_yn<%=index %>" value="<%=incl_home_medication_yn1%>" <%=incl_home_medication_yn%> <%=home_med_enbl_disbl%> onClick='chkhomemed(<%=index%>)'/></td>
										           
									               <td class='fields'   nowrap><input type="checkbox" name="replaceable_yn<%=index %>"  id="replaceable_yn<%=index %>" value="<%=replaceable_yn1%>" <%=replaceable_yn%> onClick='chkReplacable(this,<%=index%>);enableReplc(this,<%=index%>);'/></td>
									            
								               <td  class="fields" 	nowrap>   
									              <input name="replaceable_serv_code<%=index%>" id="replaceable_serv_code<%=index%>" type="text"  size="20" value="<%=replaceable_serv_code%>" onblur='if(this.value!=""){repservlookup(<%=index%>,this,rep_pkg_serv<%=index%>)}' <%= disable%> > 
												<input type='hidden' name='rep_pkg_serv<%=index%>'  id='rep_pkg_serv<%=index%>' value=''>
												<input type="button" name="button_rep_pkg_serv_code<%=index%>" id="button_rep_pkg_serv_code<%=index%>" value="?" onClick='repservlookup(<%=index%>,replaceable_serv_code<%=index%>,rep_pkg_serv<%=index%>)' <%= disable%>>
								              </td>
								           	  <td  class="fields" nowrap>
								              	 <input name="rep_serv_ord_cat_code<%=index%>"  type="text" id="rep_serv_ord_cat_code<%=index%>" size="20" value="<%=rep_serv_ord_cat_code%>" onblur='if(this.value!=""){repOrdCatLookup(<%=index%>,this,rep_ord_<%=index%>)}' <%=disabled%> <%= disable%> > 
												<input type='hidden' name='rep_ord_<%=index%>'  id='rep_ord_<%=index%>' value=''>
												<input type="button" name="button_serv_orcat_code<%=index%>"  id="button_serv_orcat_code<%=index%>" value="?" onClick='repOrdCatLookup(<%=index%>,rep_serv_ord_cat_code<%=index%>,rep_ord_<%=index%>)' <%= disable%> <%=disabled%> >
								              </td>
								        
							           		<td class='fields'  nowrap >
												<select style="width:150px;" name='daily_limit_ind<%=index%>'  id='daily_limit_ind<%=index%>' <%=modifyStatus%> <%=indicatorFldDisabled%> onchange='dailyLmtIndicatorOnChange(this,<%=index%>)' >
													<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
														<%	if(!daily_limit_ind.equals("")){
														if("G".equals(daily_limit_ind) || "B".equals(daily_limit_ind)) { %>
															<option value="G" <%="G".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
														<% } if("I".equals(daily_limit_ind) || "B".equals(daily_limit_ind)) {%>
															<option value="I" <%="I".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="eBL.PIPD.label" bundle="${bl_labels}"/></option>
														<% }
														}else{ %>
															<option value="G" <%="G".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
															<option value="I" <%="I".equals(daily_limit_ind)?" selected ":""%> ><fmt:message key="eBL.PIPD.label" bundle="${bl_labels}"/></option>
													<% 	}%>
												</select>
				
												</td>
													<%	if(!daily_limit_ind.equals("")){%>
									             <td  class="fields" 	 nowrap>
									              	<input type="text" style="text-align:center;" name="daily_qty_limit<%=index%>"  id="daily_qty_limit<%=index%>" value="<%=daily_qty_limit%>" <%=qtyFldDisabled%> />
									              
									              </td>
									              <td  class="fields" 	  nowrap>
									            	<input type="text"  style="text-align:center;" name="daily_amt_limit<%=index%>"  id="daily_amt_limit<%=index%>" value="<%=daily_amt_limit%>" <%=amtFldDisabled%> />
									             	<select style="width:100px;" name='GrossNet<%=index%>'  id='GrossNet<%=index%>' onChange='validateGrossNetInd(this,"<%=index%>");' <%=grossNetDisabled%>>
														<option value='G' <%=(daily_amt_limit_gross_net.equals("G")?"selected":"") %> ><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
														<option value='S'  <%=(daily_amt_limit_gross_net.equals("N")?"selected":"") %> ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
													</select>
									              </td>
													<%}else{%>
													<td  class="fields" 	 nowrap>
									              	<input type="text" style="text-align:center;" name="daily_qty_limit<%=index%>"  id="daily_qty_limit<%=index%>" value="<%=daily_qty_limit%>" <%=qtyFldDisabled%> />
									              
									              </td>
									              <td  class="fields" 	  nowrap>
									            	<input type="text"  style="text-align:center;" name="daily_amt_limit<%=index%>"  id="daily_amt_limit<%=index%>" value="<%=daily_amt_limit%>"  <%=amtFldDisabled%> />
									             	<select style="width:100px;" name='GrossNet<%=index%>' id='GrossNet<%=index%>'  onChange='validateGrossNetInd(this,"<%=index%>");' <%=grossNetDisabled%> >
														<option value='G' <%=(daily_amt_limit_gross_net.equals("G")?"selected":"") %> ><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
														<option value='S'  <%=(daily_amt_limit_gross_net.equals("N")?"selected":"") %> ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
													</select>
									              </td>
													<%}%>
	             								<td class='fields'  nowrap><input type="checkbox" name="refund_yn<%=index %>"  id="refund_yn<%=index%>" value='<%=refund_yn%>' onClick='refundchk(this,<%=index%>)' <%=refundchck%> /></td>
												   
												   <td  class="fields"  nowrap>
              										<input type="text" style="text-align:center;" name="refund_rate<%=index%>"  id="refund_rate<%=index%>" value="<%=refund_rate%>" <%=refndYNdisable%> />
											    </td>
									            
							              		
									            <% if(!auto_refund_yn.equals("") && auto_refund_yn.equals("Y"))
									              {%>
									               <td class='fields'   nowrap><input type="checkbox" name="auto_refund_yn<%=index %>" id="auto_refund_yn<%=index%>" value='<%=auto_refund_yn%>' checked   onClick='autorefundchk(<%=index%>)' /></td>
									             <%} 
									              else{
									            	  %>
									            	<td class="fields" 	nowrap><input type="checkbox" name="auto_refund_yn<%=index %>" id="auto_refund_yn<%=index %>" value='<%=auto_refund_yn%>' onClick='autorefundchk(<%=index%>)' />
									             &nbsp;
									              </td>
									              <%  
									              }%>
									             <% if(!close_package_yn.equals("") && close_package_yn.equals("Y"))
									              {%>
									               <td class='fields'  nowrap><input type="checkbox" name="close_package_yn<%=index%>"  id="close_package_yn<%=index%>" value='<%=close_package_yn%>' checked disabled /></td>
									             <%} 
									              else{
									            	  %>
									            	<td class="fields" 	 nowrap><input type="checkbox" name="close_package_yn<%=index%>"  id="close_package_yn<%=index%>" value='<%=close_package_yn%>' disabled />
									             &nbsp;
									              </td>
									              <%  
									              }%>
              									<td  class="fields" 	 nowrap>
          											<input type="text" style="text-align:center;"  name="utilized_serv_qty<%=index%>"  id="utilized_serv_qty<%=index%>" value="<%=utilized_serv_qty_intg%>" disabled/>
             									 </td>
            									 <td  class="fields" 	 nowrap>
            										 <input type="text" style="text-align:center;"  name="utilized_serv_amt<%=index%>"  id="utilized_serv_amt<%=index%>" value="<%=utilized_serv_amt%>" disabled/>
             									 </td>
             									<% if(!apply_fact_for_srv_lmt_yn.equals("") )
										              {%>
										               <td class='fields' nowrap><input type="checkbox" name="apply_fact_for_srv_lmt_yn<%=index%>"  id="apply_fact_for_srv_lmt_yn<%=index%>" value="<%=apply_fact_for_srv_lmt_yn%>" onClick='applfactchk(<%=index%>)' disabled nowrap/></td>
										            
										             <%} 
										              else{
										            	  %>
										            	<td class="fields" 	nowrap><input type="checkbox" name="apply_fact_for_srv_lmt_yn<%=index %>"  id="apply_fact_for_srv_lmt_yn<%=index%>" value="<%=apply_fact_for_srv_lmt_yn%>" onClick='applfactchk(<%=index%>)'  disabled nowrap/>
										             &nbsp;
										              </td>
										              <%  
										              }%>
                								<% if(!split_allowed_yn.equals("") && split_allowed_yn.equals("Y"))
									            	   {
            										 %>
									           		<td class='fields'  nowrap><input type="checkbox" name="split_allowed_yn<%=index%>"  id="split_allowed_yn<%=index%>" value="<%=split_allowed_yn%>" onClick='splitchk(<%=index%>)' checked /></td>
									             <%} 
									              else{
									            	  %>
									            	<td class="fields" 	 nowrap><input type="checkbox" name="split_allowed_yn<%=index%>"  id="split_allowed_yn<%=index%>" value="<%=split_allowed_yn%>" onClick='splitchk(<%=index%>)' />
									             &nbsp;
									              </td>
									              <%  
									              }%>
											<td class='fields'  nowrap>
													<input type="checkbox" name="radio<%=index%>" id="radio<%=index%>"  onClick="selRow(<%=index%>,this)"  />
													<input type="hidden" 	id="hdn_is_newly_added_row_YN_<%=index%>" 			name="hdn_is_newly_added_row_YN_<%=index%>" value='N'/>
													<input type="hidden" 	id="hdn_row_marked_for_del_<%=index%>" 			name="hdn_row_marked_for_del_<%=index%>" value='N'/>
											</td>												  
												  
											<td class='fields' nowrap>
												<a  href="#" onclick="openDetails(<%=index%>,'<%=pkgServLmtDtlsPrivYN%>');">Dtls</a>
												<input type="hidden" id="is_excl_mod_YN_<%=index%>" name="is_excl_mod_YN_<%=index%>" value='N'/>
												<input type="hidden" id="excl_string_<%=index%>" name="excl_string_<%=index%>" value=''/>
											</td>
										 
									              
              
              				
              				<input type="hidden" 	id="hdn_pkg_serv_ind<%=index%>" 			name="hdn_pkg_serv_ind<%=index%>"   value='<%=pkg_serv_ind%>'/>
              				<input type="hidden" 	id="hdn_pkg_serv_code<%=index%>" 			name="hdn_pkg_serv_code<%=index%>" value='<%=pkg_serv_code%>'/>
              				<input type="hidden" 	id="hdn_rate_charge_ind<%=index%>" 			name="hdn_rate_charge_ind<%=index%>" value='<%=rate_charge_ind%>'/>
              				<input type="hidden" 	id="hdn_order_catalog_code<%=index%>" 			name="hdn_order_catalog_code<%=index%>" value='<%=order_catalog_code%>'/>
              				<input type="hidden" 	id="hdn_factor_rate_ind<%=index%>" 			name="hdn_factor_rate_ind<%=index%>" value='<%=factor_rate_ind%>'/>
              				<input type="hidden" 	id="hdn_factor_rate<%=index%>" 			name="hdn_factor_rate<%=index%>" value='<%=factor_rate%>'/>
              				<input type="hidden" 	id="hdn_qty_limit<%=index%>" 			name="hdn_qty_limit<%=index%>" value='<%=qty_limit%>'/>
              				<input type="hidden" 	id="hdn_amt_limit_ind<%=index%>" 			name="hdn_amt_limit_ind<%=index%>" value='<%=amt_limit_ind%>'/>
              				<input type="hidden" 	id="hdn_amt_limit<%=index%>" 			name="hdn_amt_limit<%=index%>" value='<%=amt_limit%>'/>
              				<input type="hidden" 	id="hdn_incl_home_medication_yn<%=index%>" 			name="hdn_incl_home_medication_yn<%=index%>" value='<%=incl_home_medication_yn1%>'/>
              				<input type="hidden" 	id="hdn_replaceable_yn<%=index%>" 			name="hdn_replaceable_yn<%=index%>" value='<%=replaceable_yn1%>'/>
                   			<input type="hidden" 	id="hdn_replaceable_serv_code<%=index%>" 			name="hdn_replaceable_serv_code<%=index%>" value='<%=replaceable_serv_code%>'/>
              				<input type="hidden" 	id="hdn_group_service_ind<%=index%>" 			name="hdn_group_service_ind<%=index%>" value='<%=group_service_ind%>'/>
              				<input type="hidden" 	id="hdn_rep_serv_ord_cat_code<%=index%>" 			name="hdn_rep_serv_ord_cat_code<%=index%>" value='<%=rep_serv_ord_cat_code%>'/>
               				<input type="hidden" 	id="hdn_daily_limit_ind<%=index%>" 			name="hdn_daily_limit_ind<%=index%>" value='<%=daily_limit_ind%>'/>
               				<input type="hidden" 	id="hdn_daily_qty_limit<%=index%>" 			name="hdn_daily_qty_limit<%=index%>" value='<%=daily_qty_limit%>'/>
              				<input type="hidden" 	id="hdn_daily_amt_limit<%=index%>" 			name="hdn_daily_amt_limit<%=index%>" value='<%=daily_amt_limit%>'/>
              	          	<input type="hidden" 	id="hdn_daily_amt_limit_gross_net<%=index%>" 			name="hdn_daily_amt_limit_gross_net<%=index%>" value='<%=daily_amt_limit_gross_net%>'/>
              	            <input type="hidden" 	id="hdn_refund_yn<%=index%>" 			name="hdn_refund_yn<%=index%>" value='<%=refund_yn%>'/>
              				<input type="hidden" 	id="hdn_refund_rate<%=index%>" 			name="hdn_refund_rate<%=index%>" value='<%=refund_rate%>'/>
              				<input type="hidden" 	id="hdn_auto_refund_yn<%=index%>" 			name="hdn_auto_refund_yn<%=index%>" value='<%=auto_refund_yn%>'/>
              				<input type="hidden" 	id="hdn_close_package_yn<%=index%>" 			name="hdn_close_package_yn<%=index%>" value='<%=close_package_yn%>'/>
              				<input type="hidden" 	id="hdn_utilized_serv_qty<%=index%>" 			name="hdn_utilized_serv_qty<%=index%>" value='<%=utilized_serv_qty_intg%>'/>
              				<input type="hidden" 	id="hdn_utilized_serv_amt<%=index%>" 			name="hdn_utilized_serv_amt<%=index%>" value='<%=utilized_serv_amt%>'/>
              				<input type="hidden" 	id="hdn_apply_fact_for_srv_lmt_yn<%=index%>" 			name="hdn_apply_fact_for_srv_lmt_yn<%=index%>" value='<%=apply_fact_for_srv_lmt_yn%>'/>
              				
               				<input type="hidden" 	id="hdn_split_allowed_yn<%=index%>" 			name="hdn_split_allowed_yn<%=index%>" value='<%=split_allowed_yn%>'/>
               				
              				<input type="hidden" 	id="hdn_rowid<%=index%>" 			name="hdn_rowid<%=index%>" value='<%=rowid%>'/>
              				<input type="hidden" 	id="hdn_package_code<%=index%>" 			name="hdn_package_code<%=index%>" value='<%=defaultPkgCode%>'/>
              				<input type="hidden" 	id="hdn_package_seq_no<%=index%>" 			name="hdn_package_seq_no<%=index%>" value='<%=defaultPkgSeq%>'/>
               				<input type="hidden" 	id="pkg_service_long_desc<%=index%>" 			name="pkg_service_long_desc<%=index%>" value='<%=pkg_service_long_desc%>'/>              				
    				 </tr>
		             <%
		    
            }
		  }
		  %>
		      <input type="hidden" 	id="hdn_pack_code" 			name="hdn_pack_code" id="hdn_pack_code" value='<%=defaultPkgCode%>'/>
              <input type="hidden" 	id="hdn_pack_seq_no" 			name="hdn_pack_seq_no" id="hdn_pack_seq_no" value='<%=defaultPkgSeq%>'/>
			  <input type="hidden" 	id="visit_id" 			name="visit_id" id="visit_id" value='<%=visit_id%>'/>
              <input type="hidden" 	id="episode_id" 			name="episode_id" id="episode_id" value='<%=episode_id%>'/>
			  <input type="hidden" 	id="episode_type" 			name="episode_type" id="episode_type" value='<%=episode_type%>'/>
			<%				
     	}
		catch(Exception ex){
			ex.printStackTrace();
			System.err.println("exception in pkg serv details:"+ex);
		} 
		finally{
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
			if (rst3 != null) rst3.close();
			if(pstmt3 != null) pstmt3.close();	
	
       }
       
/*	if(cnt>0){
		System.out.println("classval"+classval);
		out.println("<script>");
		out.println("highlightRow1(1,'"+classval+"')");
		//out.println("showPackageServiceDetails(1,pkg_short_desc1,pkg_service_long_desc1)"); pkg_short_desc1="+pkg_short_desc1+" /pkg_service_long_desc1=="+pkg_service_long_desc1
		out.println("</script>");	
		
		}	*/
 /*    	if(cnt<=0){
    	// int balc=10-count;
    	int balc=10-cnt;
			for(int i=0;i<balc;i++){
				*/
				%>
				<!-- 
		         <tr>
			       <td  class='fields' nowrap><select name="service11" id="service11" id="service11">
			         <option>Service</option>
			         <option>Drug</option>
			         </select></td>
			       <td  class='fields' nowrap><input name="textfield12" id="textfield12" type="text" id="textfield12" size="20" />
			         <input name="button" id="button" type="button" id="button"  value="?" /></td>
			       <td   class='fields' nowrap>&nbsp;</td>
			       <td  class='fields' nowrap>&nbsp;</td>
			       <td  class='fields' nowrap><select name="service2" id="service2" id="service2">
			         <option selected="selected">Standard</option>
			         </select></td>
			       <td  class='fields' nowrap>1</td>
			       <td  class='fields' nowrap>1</td>
			       <td  class='fields' nowrap><select name="service21" id="service21" id="service21">
			         </select></td>
			       <td  class='fields' nowrap><input name="textfield21" id="textfield21" type="text" id="textfield21" size="15" /></td>
			       <td  class='fields' nowrap><input type="checkbox" name="checkbox2" id="checkbox2" id="checkbox2" /></td>
			       <td  class='fields' nowrap><input type="checkbox" name="checkbox3" id="checkbox3" id="checkbox3" /></td>
			       <td  class='fields' nowrap>&nbsp;</td>
			       <td  class='fields' nowrap>&nbsp;</td>
			       <td  class='fields' nowrap><select name="service31" id="service31" id="service31">
			         </select></td>
			       <td  class='fields' nowrap>&nbsp;</td>
			       <td  class='fields' nowrap><input name="textfield32" id="textfield32" type="text" id="textfield32" size="15" /></td>
			       <td  class='fields' nowrap><input type="checkbox" name="checkbox4" id="checkbox4" id="checkbox4" /></td>
			       <td  class='fields' nowrap>&nbsp;</td>
			       <td  class='fields' nowrap><input type="checkbox" name="checkbox5" id="checkbox5" id="checkbox5" /></td>
			       <td  class='fields' nowrap><input type="checkbox" name="checkbox6" id="checkbox6" id="checkbox6" /></td>
			       <td  class='fields' nowrap>&nbsp;</td>
			       <td  class='fields' nowrap>&nbsp;</td>
			       <td  class='fields' nowrap><input type="checkbox" name="checkbox7" id="checkbox7" id="checkbox7" /></td>
			       <td   class='fields' nowrap><input type="checkbox" name="checkbox8" id="checkbox8" id="checkbox8" /></td>
			       <td   class='fields' nowrap><a href="#">Dtls</a></td>
			       <td   class='fields' nowrap><input type="radio" name="radio" id="radio" id="radio" value="radio" /></td>
		          </tr>
		          
		          -->
		           <%   /*
			}
		}
     
			*/
		%>
		
		 </tbody>
		</div>
		           	
		        	
		           	 <input type='hidden' name='index' id='index'  value='<%=index%>' >
		           	
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
	            <td  ><span class="txtgray">
	              <input type="text" name="pkg_service_long_desc"  id="pkg_service_long_desc" value="<%=pkg_service_long_des%>" size="50" readonly />
	              <input type="button" name="Replace_Service"  id="Replace_Service" value="Replace Service" disabled />
	            </span>
				 <input type="button" name="Add" id="Add"  value="Add" onClick="addRow(<%=tableid%>); " />
		       	 <!-- <input type="button" name="Delete" id="Delete" id="Delete" value="Delete" onClick="deleteRow();" /> -->
				 <input type="button" name="Modify" id="Modify"  value="Modify" onClick="ModifyRecords('pkgServDtls');" <%= "Y".equals(pkgServLmtDtlsPrivYN) ? "disabled" : ""%> />
				</td>

				 <td colspan="6" >&nbsp;</td>
			   
         	 </tr>
          </table>
         </td>
       </tr>
          <input type='hidden' name='patientid1' id='patientid1'  value='<%=patientid1%>'>
          <input type='hidden' name='blng_class_code'  id='blng_class_code' value='<%=blng_class_code%>'>
       <!--   <input type="hidden" name="pkg_service_long_desc" id="pkg_service_long_desc" id="pkg_service_long_desc" value="<%=pkg_service_long_desc%>" > -->  
          <input type='hidden' name='cust_group_code'  id='cust_group_code' value='<%=cust_group_code%>'>
          <input type='hidden' name='cust_code' id='cust_code'  value='<%=cust_code%>'> 
          <input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'> 
          <input type='hidden' name='facility_id' id='facility_id'  value='<%=facility_id%>'>
          <input type='hidden' name='userid' id='userid' value='<%=userid%>'>
          <input type='hidden' name='ws_no' id='ws_no'  value='<%=ws_no%>'>
          <input type='hidden' name='dbcnt' id='dbcnt'  value='<%=cnt%>'>
		  <input type='hidden' name='cnt' id='cnt'  value='<%=cnt%>'>
          <input type='hidden' name='privlege_code'  id='privlege_code' value='<%=privlege_code%>'>
          <input type='hidden' name='locale' id='locale'  value="<%=locale%>" >
          <input type='hidden' name='rowcount' id='rowcount'   value='' >
          <input type='hidden' name='defaultPkgCode' id='defaultPkgCode'  value='<%=defaultPkgCode%>'>
          <input type='hidden' name='orderCatlogyn' id='orderCatlogyn'  value='<%=order_catalog_yn%>'>   
          <input type='hidden' name='pkgServIndLmtYN' id='pkgServIndLmtYN'  value='<%=pkg_serv_ind_lmt_YN%>'> 
          <input type='hidden' name='defaultPkgSeq' id='defaultPkgSeq'  value='<%=defaultPkgSeq%>'>
          <input type='hidden' name='defaultEffFromDate' id='defaultEffFromDate'  value='<%=defaultEffFromDate%>'>
		  
          
		<input type='hidden' name='PKG_LIMIT_IND_BY' id='PKG_LIMIT_IND_BY'  value='<%=PKG_LIMIT_IND_BY%>'>

		<input type='hidden' name='indicatorFldDisabled' id='indicatorFldDisabled'  value='<%=indicatorFldDisabled%>'> 
		<input type='hidden' name='amtFldDisabled' id='amtFldDisabled'  value='<%=amtFldDisabled%>'>
		<input type='hidden' name='qtyFldDisabled' id='qtyFldDisabled'  value='<%=qtyFldDisabled%>'>
		<input type='hidden' name='grossNetDisabled' id='grossNetDisabled'  value='<%=grossNetDisabled%>'>
		<input type='hidden' name='selectedItemIndex' id='selectedItemIndex'  value='<%=selectedItemIndex%>'>

		<input type='hidden' name='pkg_serv_lmt_YN' id='pkg_serv_lmt_YN'  value='<%=pkg_serv_lmt_YN%>'>
		<input type='hidden' name='daily_pkg_lmt_yn' id='daily_pkg_lmt_yn'  value='<%=daily_pkg_lmt_yn%>'>
		<input type='hidden' name='p_daily_pkg_serv_lmt' id='p_daily_pkg_serv_lmt'  value='<%=p_daily_pkg_serv_lmt%>'>
		<input type='hidden' name='p_daily_pkg_serv_lmt_ind' id='p_daily_pkg_serv_lmt_ind'  value='<%=p_daily_pkg_serv_lmt_ind%>'>

		<input type='hidden' name='noofdecimal' id='noofdecimal'  value='<%=noofdecimal%>'>	

		<input type='hidden' name='pkgServDtlsAuthStr'  id='pkgServDtlsAuthStr' value='<%=pkgServDtlsAuthStr%>'>		  
		<input type='hidden' name='pkgServLmtDtlsPrivYN'  id='pkgServLmtDtlsPrivYN' value='<%=pkgServLmtDtlsPrivYN%>'> 

      </table>					
</center>                       
</form>                         
</body>                         
</html>
<%
	}
	catch(Exception e )
	{ 
		out.println(e);
	}
	finally
	{	
		ConnectionManager.returnConnection(con, request);
	}
%> 
	

