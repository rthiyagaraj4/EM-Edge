<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*,eBL.BLReportIdMapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	ResultSet rs				= null;	
	ResultSet rs1				= null;	
	CallableStatement  cstmt1 	= null;
	String classval="" ;
	int noofdecimal=2;
	boolean amountRoundOff = true; //Added V180125-Subha/MMS-JU-SCF-0102
	boolean siteSpecNMC=false;//Added V190820-MuthuN/NMC-JD-SCF-0015
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	//Added V200323-MuthuN/NMC-JD-CRF-050
	boolean preConfigDiscAmt_YN=false;//Added V200323-MuthuN/NMC-JD-CRF-050
	String preConfigDiscAmt="";
	String settlementIndfolio="";//NMC-JD-SCF-055
	//Added V200323-MuthuN/NMC-JD-CRF-050
	try
	{
		con	=	ConnectionManager.getConnection(request);
		siteSpecNMC = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_CMN_FUN_ME_YN");//Added V190820-MuthuN/NMC-JD-SCF-0015

		//Added V200323-MuthuN/NMC-JD-CRF-050
		preConfigDiscAmt_YN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ADDITIONAL_ADHOC");
		if(preConfigDiscAmt_YN){
			preConfigDiscAmt="Y";
		}
		else{
			preConfigDiscAmt="N";
		}
		//Added V200323-MuthuN/NMC-JD-CRF-050

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		CurrencyFormat cf1 = new CurrencyFormat();
		String query_string=request.getQueryString();

		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	

		String str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";

		String str_custmr_id = request.getParameter("customer_id");	
		if(str_custmr_id==null) str_custmr_id="";
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1		
		try {
			site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
			} catch(Exception ex) {
				System.err.println("Error in BlAdhocDiscByPayer.jsp for getting site3TierAlmoFeature Connection: "+ex);
				ex.printStackTrace();
			}
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}		
			rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("3="+e.toString());
		}
		
		//Added V180125-Subha/MMS-JU-SCF-0102 try
		try {
			pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
			rs = pstmt.executeQuery();	
			if ( rs != null && rs.next()) {
				if(rs.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
					amountRoundOff = false;
				}
			}
		} catch(Exception e) {   
			e.printStackTrace();
			System.out.println("4="+e.toString());
		} finally {
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 		
		}
	
		//Added V171212-Gayathri/MMS-DM-CRF-0118/Starts
		Boolean SiteSpec_VAT=false;
		String SiteSpecific_VAT ="";
		try
		{
			SiteSpec_VAT = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","VAT_CHANGES_APPLICABLE_YN");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(SiteSpec_VAT){
			SiteSpecific_VAT="Y";
		}
		else{
			SiteSpecific_VAT="N";
		}
		//Added V171212-Gayathri/MMS-DM-CRF-0118/Ends
		String str_module_id     =  request.getParameter("module_id");	
		if(str_module_id == null) str_module_id="";
		String str_patient_id = request.getParameter("patient_id");	
		if(str_patient_id==null) str_patient_id="";	
		
		String str_episode_type = request.getParameter("episode_type");	
		if(str_episode_type==null) str_episode_type="";	
	
		String str_episode_id = request.getParameter("episode_id");	
		if(str_episode_id==null) str_episode_id="";	

		String str_visit_id = request.getParameter("visit_id");	
		if(str_visit_id==null) str_visit_id="";	
	
		String str_encounter_id = request.getParameter("encounter_id");	
		if(str_encounter_id==null) str_encounter_id="";	

		String selected_serv_rec = request.getParameter("selected_serv_rec");
		if(selected_serv_rec==null) selected_serv_rec="";	

		String tot_upd_gross_charge_amt = request.getParameter("tot_upd_gross_charge_amt");
		if(tot_upd_gross_charge_amt==null) tot_upd_gross_charge_amt="0";		
		//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
		if(amountRoundOff) {
			tot_upd_gross_charge_amt = cf1.formatCurrency(tot_upd_gross_charge_amt, noofdecimal);
		} else {
			tot_upd_gross_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(tot_upd_gross_charge_amt, noofdecimal);	
		}

		String tot_upd_disc_amt = request.getParameter("tot_upd_disc_amt");
		if(tot_upd_disc_amt==null) tot_upd_disc_amt="0";	
		//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
		if(amountRoundOff) {
			tot_upd_disc_amt = cf1.formatCurrency(tot_upd_disc_amt, noofdecimal);
		} else {
			tot_upd_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(tot_upd_disc_amt, noofdecimal);
		}

		String tot_upd_net_charge_amt = request.getParameter("tot_upd_net_charge_amt");
		if(tot_upd_net_charge_amt==null) tot_upd_net_charge_amt="0";		
		//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
		if(amountRoundOff) {
			tot_upd_net_charge_amt = cf1.formatCurrency(tot_upd_net_charge_amt, noofdecimal);
		} else {
			tot_upd_net_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(tot_upd_net_charge_amt, noofdecimal);
		}

		String blng_serv_code ="", serv_desc="",blng_grp_id="",blng_grp_desc="", policy_type_code="", cust_code="", cust_long_name="", policy_desc="", adhoc_disc_amt="",act_gross_amt="", serv_item_code="",serv_item_desc="", org_gross_amt="";
		
		String trx_doc_ref="",trx_doc_ref_line_no="",trx_doc_ref_seq_no="", str_addl_charge_for_payer="",str_addl_chg_value="";

		int i=0;
		double addl_charge_for_payer=0;
		
		String upd_gross_charge_amt="", upd_disc_amt="" , upd_net_charge_amt="" , existing_reason_code="" ;

		String org_disc_amt="";//NMC-JD-CRF-050

		trx_doc_ref = request.getParameter("trx_doc_ref");	
		if(trx_doc_ref==null) trx_doc_ref="";	
		
		trx_doc_ref_line_no = request.getParameter("trx_doc_ref_line_no");	
		if(trx_doc_ref_line_no==null) trx_doc_ref_line_no="";	
		
		String   trx_doc_ref_seq_num="";
		String  str_color_code  ="";
		String  str_color_band ="";
		String str_settlement_ind="";
		String  str_trx_status ="";		
		String discountYesNo="";//Added by Vijay A.P. for PMG CRF
%>
	<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<STYLE TYPE="text/CSS">
/* This style is used for locking the table's heading  */

	TD.YW{
		BACKGROUND-COLOR:YELLOW;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}

	TD.GY{
		BACKGROUND-COLOR:GREY;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
	}

		TD.GR{
		BACKGROUND-COLOR:GREEN;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
			TD.DC{
		BACKGROUND-COLOR:DARKCYAN;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
			}
			TD.BL{
		BACKGROUND-COLOR:BLUE;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
			}

			TD.PK{
		BACKGROUND-COLOR:PINK;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
			}
			TD.WH{
		BACKGROUND-COLOR:WHITE;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
			}		


/* This style is used for locking the table's heading  */

div#tbl-container {
height: 225px;
overflow: auto;
}

thead td, thead td.locked	{
position:relative;
}

thead td {
top: expression(document.getElementById("tbl-container").scrollTop-2); 
z-index: 20;
}

</STYLE>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>		
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eBL/js/BLAdhocDisc.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<script>
async function callAdhocDisc(i)
{
	var adhoc_user_id="";
	var adhoc_reason_code="";
	var total_records=document.forms[0].total_records.value;
			
	var patient_id = document.forms[0].patient_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var episode_id = document.forms[0].episode_id.value;
	var visit_id = document.forms[0].visit_id.value;
	var module_id = document.forms[0].module_id.value;
	var decimal = document.forms[0].noofdecimal.value;
	var existing_reason_code = document.forms[0].existing_reason_code.value;

	var selected_serv_rec = document.forms[0].selected_serv_rec.value;
	selected_serv_rec=eval(selected_serv_rec);

	var blng_serv_code = eval("document.forms[0].blng_serv_code"+i);	
	blng_serv_code = blng_serv_code.value;

	var serv_item_code = eval("document.forms[0].serv_item_code"+i);	
	serv_item_code = serv_item_code.value;

	var serv_item_desc = eval(document.getElementById("serv_item_desc"+i));	
	serv_item_desc = encodeURIComponent(serv_item_desc.innerText);

	var upd_net_charge_amt = eval(document.getElementById("net_amt"+i));	
	upd_net_charge_amt = upd_net_charge_amt.innerText;
	var act_gross_amt = eval("document.forms[0].act_gross_amt"+i);	
	act_gross_amt = act_gross_amt.value;	
	var upd_gross_charge_amt = eval(document.getElementById("gross_amt"+i));	
	upd_gross_charge_amt = upd_gross_charge_amt.innerText;	
	var upd_disc_amt = eval(document.getElementById("disc_amt"+i));
	upd_disc_amt = upd_disc_amt.innerText;
			
	//Added V200326-MuthuN/NMC-JD-CRF-050
	var org_disc_amt = eval(document.getElementById("org_disc_amt"+i));
	org_disc_amt = org_disc_amt.value;
	//Added V200326-MuthuN/NMC-JD-CRF-050
			
	var trx_doc_ref = eval("document.forms[0].trx_doc_ref"+i);	
	trx_doc_ref = trx_doc_ref.value;	
	var trx_doc_ref_line_no = eval("document.forms[0].trx_doc_ref_line_no"+i);	
	trx_doc_ref_line_no = trx_doc_ref_line_no.value;	
	var trx_doc_ref_seq_no = eval("document.forms[0].trx_doc_ref_seq_no"+i);	
	trx_doc_ref_seq_no = trx_doc_ref_seq_no.value;	

	var disc_allowed_yn=eval("document.forms[0].dis_yes_no"+i);
	disc_allowed_yn=disc_allowed_yn.value;			
	if(disc_allowed_yn=="N")
	{
		alert('Adhoc Discount not applicable for the copay amount');
		return;
	}	
			
	//cust code details
	var cust_code_ref = eval("document.forms[0].cust_code"+i);	
			
	var cust_code	=	cust_code_ref.value;
	var retVal="";
	var dialogHeight= "70vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop = "10" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll=no; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;	
	//var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var title="";//"Adhoc Discount";
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"patient_id="+patient_id+"&"+"episode_type="+episode_type+"&"+"episode_id="+episode_id+"&"+"visit_id="+visit_id+"&"+"blng_serv_code="+blng_serv_code+"&"+"serv_item_code="+serv_item_code+"&"+"serv_item_desc="+serv_item_desc+"&"+"upd_net_charge_amt="+upd_net_charge_amt+"&"+"act_gross_amt="+act_gross_amt+"&"+"upd_gross_charge_amt="+upd_gross_charge_amt+"&"+"upd_disc_amt="+upd_disc_amt+"&"+"trx_doc_ref="+trx_doc_ref+"&"+"trx_doc_ref_line_no="+trx_doc_ref_line_no+"&"+"trx_doc_ref_seq_no="+trx_doc_ref_seq_no+"&"+"existing_reason_code="+existing_reason_code+"&called_frm_frame=P&module_id="+module_id+"&cust_code="+cust_code+"&org_disc_amt="+org_disc_amt;//Added V200326-MuthuN/NMC-JD-CRF-050

	retVal= await window.showModalDialog("../../eBL/jsp/BLAdhocDiscDtlsEditFrame.jsp?"+param,arguments,features);			

	if (retVal != null || retVal!="")
	{
		if(retVal!='undefined' && retVal!=undefined)
		{
			var retVal=unescape(retVal);			
			if(retVal != null && retVal.length>0)
			{
				arr=retVal.split("|");					
				adhoc_user_id = arr[0];
				adhoc_reason_code = arr[1];

				var disc_reason_code = eval("document.forms[0].disc_reason_code"+i);	
				disc_reason_code.value = adhoc_reason_code;

				var adhoc_user_id = eval("document.forms[0].adhoc_user_id"+i);	
				adhoc_user_id.value=adhoc_user_id;

				document.forms[0].existing_reason_code.value = adhoc_reason_code;

				var payer_retArr = refresh_payer_disc(i,trx_doc_ref,trx_doc_ref_line_no,trx_doc_ref_seq_no,existing_reason_code,patient_id,episode_type,episode_id,visit_id);

				var payer_arr_msg = new Array();
				payer_arr_msg=payer_retArr.split("|");
						
				var payer_upd_gross_charge_amt = eval(document.getElementById("gross_amt"+i));
				payer_upd_gross_charge_amt.innerText = payer_arr_msg[0];
						
				var payer_upd_disc_amt = eval(document.getElementById("disc_amt"+i));	
				payer_upd_disc_amt.innerText = payer_arr_msg[1];

				var payer_upd_net_charge_amt = eval(document.getElementById("net_amt"+i));
				payer_upd_net_charge_amt.innerText = payer_arr_msg[2];

				var payer_act_gross_amt = eval("document.forms[0].act_gross_amt"+i);	
				payer_act_gross_amt.value = payer_arr_msg[3];
						
				/* Added V180116-Aravindh/MMSVAT Starts*/
				var payer_addl_chrg_amt = eval(document.getElementById("addl_charge_for_payer"+i));
				payer_addl_chrg_amt.innerText = payer_arr_msg[4];
				/* Added V180116-Aravindh/MMSVAT Ends*/

				var serv_retArr = refresh_serv_disc(i,trx_doc_ref,trx_doc_ref_line_no,existing_reason_code,patient_id,episode_type,episode_id,visit_id);

				var serv_arr_msg = new Array();
				serv_arr_msg=serv_retArr.split("|");
						
				var serv_upd_gross_charge_amt = eval(parent.frames[1].document.getElementById("gross_amt"+selected_serv_rec));
				serv_upd_gross_charge_amt.innerText = serv_arr_msg[0];
						
				var serv_upd_disc_amt = eval(parent.frames[1].document.getElementById("disc_amt"+selected_serv_rec));	
				serv_upd_disc_amt.innerText = serv_arr_msg[1];

				var serv_upd_net_charge_amt = eval(parent.frames[1].document.getElementById("net_amt"+selected_serv_rec));
				serv_upd_net_charge_amt.innerText = serv_arr_msg[2];

				var serv_act_gross_amt = eval("parent.frames[1].document.forms[0].act_gross_amt"+selected_serv_rec);	
				serv_act_gross_amt.value = serv_arr_msg[3];

				parent.frames[3].document.getElementById("tot_gross_amt").innerText = serv_arr_msg[0];
					
				parent.frames[3].document.getElementById("tot_disc_amt").innerText = serv_arr_msg[1];

				parent.frames[3].document.getElementById("tot_net_amt").innerText = serv_arr_msg[2];

				var tot_rec_by_ser = parent.frames[1].document.forms[0].total_records.value;
				var temp_tot_gross_amt=0, temp_tot_disc_amt=0, temp_tot_net_amt=0; 

				for(var i=0;i<tot_rec_by_ser;i++)
				{
					var tot_serv_upd_gross_charge_amt = eval(parent.frames[1].document.getElementById("gross_amt"+i));
					temp_tot_gross_amt = temp_tot_gross_amt+eval(tot_serv_upd_gross_charge_amt.innerText);

					var tot_serv_upd_disc_amt = eval(parent.frames[1].document.getElementById("disc_amt"+i));	
					temp_tot_disc_amt = temp_tot_disc_amt+eval(tot_serv_upd_disc_amt.innerText);

					var tot_serv_upd_net_charge_amt = eval(parent.frames[1].document.getElementById("net_amt"+i));
					temp_tot_net_amt = temp_tot_net_amt+eval(tot_serv_upd_net_charge_amt.innerText);
				}
				temp_tot_gross_amt = temp_tot_gross_amt.toFixed(decimal);
				temp_tot_disc_amt = temp_tot_disc_amt.toFixed(decimal);
				temp_tot_net_amt = temp_tot_net_amt.toFixed(decimal);

				document.forms[0].tot_serv_gross_amt.value = temp_tot_gross_amt;
				document.forms[0].tot_serv_disc_amt.value = temp_tot_disc_amt;
				document.forms[0].tot_serv_net_amt.value = temp_tot_net_amt;
						
				putdeci(document.forms[0].tot_serv_gross_amt);
				putdeci(document.forms[0].tot_serv_disc_amt);
				putdeci(document.forms[0].tot_serv_net_amt);

//						document.forms[0].target='payer_frame';
//						document.forms[0].action="../../eBL/jsp/BLAdhocDiscByPayer.jsp";
//						document.forms[0].submit();
			}
		}
	}
}	
		
async function callAddlChargeDistri(sel_rec)
{
	var trx_doc_ref = eval("document.forms[0].trx_doc_ref"+sel_rec);	
	trx_doc_ref = trx_doc_ref.value;	

	var trx_doc_ref_line_no = eval("document.forms[0].trx_doc_ref_line_no"+sel_rec);	
	trx_doc_ref_line_no = trx_doc_ref_line_no.value;	

	var trx_doc_ref_seq_no = eval("document.forms[0].trx_doc_ref_seq_no"+sel_rec);	
	trx_doc_ref_seq_no = trx_doc_ref_seq_no.value;	

	var addl_charge_for_payer = eval(document.getElementById("addl_charge_for_payer"+sel_rec));	
	addl_charge_for_payer = addl_charge_for_payer.innerText;				

	var retVal="";
	var dialogHeight= "41vh" ;
	var dialogWidth	= "40vw" ;
	var dialogTop = "10" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll=no; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;	

	var title="";
	var arguments = "" ;

	var param = "title="+title+"&trx_doc_ref="+trx_doc_ref+"&trx_doc_ref_line_no="+trx_doc_ref_line_no+"&trx_doc_ref_seq_no="+trx_doc_ref_seq_no+"&total_addl_charge_for_payer="+addl_charge_for_payer;

	retVal= await window.showModalDialog("../../eBL/jsp/BLAddlServChargeDtlsFrame.jsp?"+param,arguments,features);
}

function chkForIncl(sel_row)
{
	var sel_row_serv_incl_for_disc=eval("document.forms[0].serv_incl_for_disc"+sel_row);	

	if(sel_row_serv_incl_for_disc.value == "YES")
	{
		sel_row_serv_incl_for_disc.checked = true;
	}
	else
	{
		sel_row_serv_incl_for_disc.checked=false;
	}

}
</script>

<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
<FORM name='AdhocDicountsbyPayerForm' id='AdhocDicountsbyPayerForm' action="" method=''>

<table cellpadding='3' cellspacing='0'  width='100%'>
	<tr>
		<td width='35%' class='label' >&nbsp;</td>
		<td width='20%' class='label'><div align="right"><b><fmt:message key="Common.total.label" bundle="${common_labels}"/></b></div></td>
		<td width='15%' class="fields"><div align="right"><input type='text' name='tot_serv_gross_amt' id='tot_serv_gross_amt' size='5' maxlength='30' value='<%=tot_upd_gross_charge_amt%>' readonly style='text-align:right' ></div></td>
		<td width='15%' class="fields"><div align="right"><input type='text' name='tot_serv_disc_amt' id='tot_serv_disc_amt' size='5'  maxlength='30' value='<%=tot_upd_disc_amt%>' readonly style='text-align:right'></div></td>
		<td width='15%' class="fields"><div align="right"><input type='text' name='tot_serv_net_amt' id='tot_serv_net_amt' size='5'  maxlength='30' value='<%=tot_upd_net_charge_amt%>' readonly style='text-align:right'></div></td>
	</tr>
</table>
<div id='tbl-container'>
	<table border='1' cellpadding='3' cellspacing='0' width='100%'>	
	<thead>
		<tr>			
		
			<%	//Added site3TierAlmoFeatureYN V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		if(str_custmr_id.equals("ALMO") || site3TierAlmoFeature == true)
		{  
			cstmt1  =  con.prepareCall("{ call BLCOMMONPROC.GET_COLOR_CODE(?,?,?,?,?,?,?)}");		
		%>
			<td class='COLUMNHEADER' width='3%'>Color ind</td>		
			<td class='COLUMNHEADER' width='12%'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td>
			<%}else { %>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td>
			<%} %>	
		
			
			<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></td>		
			<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.NetAmount.label" bundle="${common_labels}"/></td>
<!--		<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.Included.label" bundle="${common_labels}"/></td>
-->
			<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.DISC_APPL.label" bundle="${bl_labels}"/></td>
			<!-- Added V190820-MuthuN/NMC-JD-SCF-0015 -->
			<td class='COLUMNHEADER' width='5%'>
			<%if(siteSpecNMC){%>			
				<fmt:message key="eBL.Vat_Charges.label" bundle="${bl_labels}"/>
			<%} else {%>
				<fmt:message key="eBL.ADDL_CHARGE.label" bundle="${bl_labels}"/>
			<%}%>
			</td>
			<!-- Added V190820-MuthuN/NMC-JD-SCF-0015 -->
		</tr>
	</thead>
	<tbody>
<%
		try
		{		
	
			String strsql = "select BLNG_SERV_CODE,BLNG_GRP_ID,POLICY_TYPE_CODE,CUST_CODE,UPD_GROSS_CHARGE_AMT,NVL(UPD_DISC_AMT,0),UPD_NET_CHARGE_AMT,TRX_DOC_REF_SEQ_NUM,ACT_GROSS_AMT,NVL(ADHOC_DISC_AMT,0),SERV_ITEM_CODE,DECODE(?,'en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)) SERV_ITEM_DESC, ORG_GROSS_CHARGE_AMT,TRX_DOC_REF_SEQ_NUM, org_disc_amt,SETTLEMENT_IND from bl_patient_charges_folio"
			+" where operating_facility_id = ?"
			+" and episode_type = ?"
			+" and patient_id   = ?"
			//Commented V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 start
			/* +" and episode_id = NVL('"+str_episode_id+"',EPISODE_ID)"
			+" and visit_id   = NVL('"+str_visit_id+"',VISIT_ID)" */
			//Commented V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 end
			//Added V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 start
			+" AND ((? IN ('O', 'E') AND episode_id = NVL (?, episode_id) AND visit_id = NVL (?, visit_id))"
			+" OR (? IN ('I', 'D') AND episode_id = NVL (?, episode_id)) OR ? = 'R')"
			//Added V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 end
			+" and TRX_DOC_REF = ?"
			+" and TRX_DOC_REF_LINE_NUM = ?"
			+" and nvl(confirmed_yn,'N')='Y'"
			+" and nvl(billed_flag,'N') != 'Y'"
			+" and bill_doc_type_code is null"
			+" and ( nvl(package_ind,'X') = 'S' or (nvl(package_trx_ind,'X')='Y' and nvl(package_ind,'X') = 'P') )"
			+" and nvl(trx_finalize_ind,'N')= 'Y'" 
			+" and nvl(ins_pkg_pat_ind,'N') != 'K'"
			+" and bill_doc_type_code is null"
			+" and (nvl(trx_status,'N')<>'C'" 
			+" or ( nvl(trx_status,'N')='C' and ( ( REV_ADJ_TRX_IND in ('R', 'B','A') and (ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM,ORIG_DOC_REF_SEQ_NUM) in (select trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM from bl_patient_charges_folio where trx_status = 'C' and bill_doc_type_code is not null and operating_facility_id = ? and patient_id = ? AND ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID)) OR ( ? IN('I','D') and episode_id = NVL(?,EPISODE_ID)) OR ? = 'R'))) or ( (trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM) in ( select ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM ,ORIG_DOC_REF_SEQ_NUM from bl_patient_charges_folio where trx_status = 'C' and operating_facility_id = ? and patient_id = ? and ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID)) OR(? IN('I','D') and episode_id = NVL(?,EPISODE_ID)) or ? = 'R' ) and bill_doc_type_code is not null and ORIG_DOC_REF is not null ))))) order by  nvl(priority ,9999)";//NMC-JD-CRF-050

			pstmt = con.prepareStatement(strsql);
			pstmt.setString(1, locale);
			pstmt.setString(2, str_facility_id);
			pstmt.setString(3, str_episode_type);
			pstmt.setString(4, str_patient_id);
			pstmt.setString(5, str_episode_type);
			pstmt.setString(6, str_episode_id);
			pstmt.setString(7, str_visit_id);
			pstmt.setString(8, str_episode_type);
			pstmt.setString(9, str_episode_id);
			pstmt.setString(10, str_episode_type);
			pstmt.setString(11, trx_doc_ref);
			pstmt.setString(12, trx_doc_ref_line_no);
			pstmt.setString(13, str_facility_id);
			pstmt.setString(14, str_patient_id);
			pstmt.setString(15, str_episode_type);
			pstmt.setString(16, str_episode_id);
			pstmt.setString(17, str_visit_id);
			pstmt.setString(18, str_episode_type);
			pstmt.setString(19, str_episode_id);
			pstmt.setString(20, str_episode_type);
			pstmt.setString(21, str_facility_id);
			pstmt.setString(22, str_patient_id);
			pstmt.setString(23, str_episode_type);
			pstmt.setString(24, str_episode_id);
			pstmt.setString(25, str_visit_id);
			pstmt.setString(26, str_episode_type);
			pstmt.setString(27, str_episode_id);
			pstmt.setString(28, str_episode_type);
			
			rs1 = pstmt.executeQuery();	

			if( rs1 != null ) 
			{
				while( rs1.next() )
				{  
					blng_serv_code = rs1.getString(1);
					if(blng_serv_code == null) blng_serv_code="";

					blng_grp_id = rs1.getString(2);
					if(blng_grp_id == null) blng_grp_id="";

					policy_type_code = rs1.getString(3);	
					if(policy_type_code == null) policy_type_code="";

					cust_code = rs1.getString(4);
					if(cust_code == null) cust_code="";
					
					upd_gross_charge_amt = rs1.getString(5);
					if(upd_gross_charge_amt == null) upd_gross_charge_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_gross_charge_amt = cf1.formatCurrency(upd_gross_charge_amt, noofdecimal);
					} else {
						upd_gross_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_gross_charge_amt, noofdecimal);
					}

					upd_disc_amt = rs1.getString(6);
					if(upd_disc_amt == null) upd_disc_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_disc_amt = cf1.formatCurrency(upd_disc_amt, noofdecimal);
					} else {
						upd_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_disc_amt, noofdecimal);
					}
					double db_upd_disc_amt=Double.parseDouble(upd_disc_amt);

					upd_net_charge_amt = rs1.getString(7);
					if(upd_net_charge_amt == null) upd_net_charge_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_net_charge_amt = cf1.formatCurrency(upd_net_charge_amt, noofdecimal);
					} else {
						upd_net_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_net_charge_amt, noofdecimal);
					}

					trx_doc_ref_seq_no = rs1.getString(8);
					if(trx_doc_ref_seq_no == null) trx_doc_ref_seq_no="";
					
					act_gross_amt = rs1.getString(9);
					if(act_gross_amt == null) act_gross_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						act_gross_amt = cf1.formatCurrency(act_gross_amt, noofdecimal);
					} else {
						act_gross_amt = BLReportIdMapper.truncateUptoTwoDecimal(act_gross_amt, noofdecimal);
					}
					double db_act_gross_amt=Double.parseDouble(act_gross_amt);

					adhoc_disc_amt = rs1.getString(10);
					if(adhoc_disc_amt == null) adhoc_disc_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						adhoc_disc_amt = cf1.formatCurrency(adhoc_disc_amt, noofdecimal);
					} else {
						adhoc_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(adhoc_disc_amt, noofdecimal);
					}
					double db_adhoc_disc_amt=Double.parseDouble(adhoc_disc_amt);

					serv_item_code = rs1.getString(11);
					if(serv_item_code == null) serv_item_code="";

					serv_item_desc = rs1.getString(12);
					if(serv_item_desc == null) serv_item_desc="&nbsp;";

					org_gross_amt = rs1.getString(13);
					if(org_gross_amt == null) org_gross_amt="0";

					//NMC-JD-CRF-050
					org_disc_amt = rs1.getString(15);
					if(org_disc_amt == null) org_disc_amt="0";
					System.err.println("698, org_disc_amt==>"+org_disc_amt);
					//NMC-JD-CRF-050
					
					//NMC-JD-SCF-055
					settlementIndfolio =rs1.getString(16);
					if(settlementIndfolio == null) settlementIndfolio="";
					System.err.println("672, settlementIndfolio==>"+settlementIndfolio);
					//NMC-JD-SCF-055

					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						org_gross_amt = cf1.formatCurrency(org_gross_amt, noofdecimal);
					} else {
						org_gross_amt = BLReportIdMapper.truncateUptoTwoDecimal(org_gross_amt,noofdecimal);
					}
					double db_org_gross_amt=Double.parseDouble(org_gross_amt);
					
					trx_doc_ref_seq_num =  rs1.getString(14);
					str_color_band	= "WH";

			if(str_custmr_id.equals("ALMO") && cust_code.length()==0)
					{
						try
						{
						cstmt1.setString(1,str_facility_id);
						cstmt1.setString(2,trx_doc_ref);
						cstmt1.setString(3,trx_doc_ref_line_no);
						cstmt1.setString(4,trx_doc_ref_seq_num);
						cstmt1.registerOutParameter(5,java.sql.Types.VARCHAR);
						cstmt1.registerOutParameter(6,java.sql.Types.VARCHAR);
						cstmt1.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt1.execute();					
						
						str_trx_status=cstmt1.getString(5);
						if(str_trx_status==null)  str_trx_status ="";
						
						str_settlement_ind=cstmt1.getString(6);		
						if(str_settlement_ind==null)  str_settlement_ind ="";
						
						str_color_code=cstmt1.getString(7);
						if(str_color_code==null)  str_color_code ="";
						
					//	if(str_settlement_ind.equals("C") || str_settlement_ind.equals("R") || str_settlement_ind.equals("X"))
						str_color_band =  str_color_code;
					//	else
					//		str_color_band = "WH";
						}catch(Exception  ee1)  {
						ee1.printStackTrace();
						}
						if(cstmt1 != null ) cstmt1.close();						
					}

					try
					{
						String sql1= " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE=? and LANGUAGE_ID =? ";
						pstmt = con.prepareStatement(sql1);
						pstmt.setString(1, blng_serv_code);
						pstmt.setString(2, locale);
						rs = pstmt.executeQuery();	

						while(rs.next())
						{
						   serv_desc  =  rs.getString(1);	
						   if(serv_desc == null) serv_desc="";
						}	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//System.err.println("1="+e.toString());
					}
					finally{
						rs.close();
						pstmt.close();
					}

					try
					{
						String sql2= " select SHORT_DESC from BL_BLNG_GRP_LANG_VW where BLNG_GRP_ID=? and LANGUAGE_ID =? ";
						pstmt = con.prepareStatement(sql2);
						pstmt.setString(1, blng_grp_id);
						pstmt.setString(2, locale);
						rs = pstmt.executeQuery();	
		
						while(rs.next())
						{
						   blng_grp_desc  =  rs.getString(1);
						   if(blng_grp_desc == null) blng_grp_desc="";				   
						}	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//System.err.println("2="+e.toString());
					}
					finally{
						rs.close();
						pstmt.close();
					}
					
					try
					{
						String sql3= " select SHORT_NAME from AR_CUSTOMER_LANG_VW where CUST_CODE=? and LANGUAGE_ID =? ";
						pstmt = con.prepareStatement(sql3);
						pstmt.setString(1, cust_code);
						pstmt.setString(2, locale);
						rs = pstmt.executeQuery();	
		
						while(rs.next())
						{
						   cust_long_name  =  rs.getString(1);	
   						   if(cust_long_name == null) cust_long_name="";
						}	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//System.err.println("3="+e.toString());
					}
					finally{
						rs.close();
						pstmt.close();
					}

					try							
					{
						String sql4= " select SHORT_DESC from BL_INS_POLICY_TYPES_LANG_VW where POLICY_TYPE_CODE=? and LANGUAGE_ID =? ";
						pstmt = con.prepareStatement(sql4);
						pstmt.setString(1, policy_type_code);
						pstmt.setString(2, locale);
						rs = pstmt.executeQuery();	

						while(rs.next())
						{
						   policy_desc  =  rs.getString(1);	
   						   if(policy_desc == null) policy_desc="";
						}	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//System.err.println("4="+e.toString());
					}
					finally{
						rs.close();
						pstmt.close();
					}

					try							
					{
					//Modified the Query V171212-Gayathri/MMS-DM-CRF-0118
					String sql_addl_charge_for_payer="";
					
					if(("Y").equals(SiteSpecific_VAT)){
						 sql_addl_charge_for_payer=" Select DECODE (nvl(rule_coverage,'N'), 'E', nvl(rule_coverage,'N'), 'Y'), Sum(Nvl(Addl_Charge_Amt,0)) From  BL_PAT_CHRG_FOLIO_ADDL_CHARGE where TRX_DOC_REF = ? and TRX_DOC_REF_LINE_NUM = ? and Trx_Doc_Ref_Seq_Num = ? and operating_facility_id=? AND rule_code IS NOT NULL group by DECODE (nvl(rule_coverage,'N'), 'E', nvl(rule_coverage,'N'), 'Y')";
					}
					else{		
						
						sql_addl_charge_for_payer= " Select Sum(Nvl(Addl_Charge_Amt,0)) From  BL_PAT_CHRG_FOLIO_ADDL_CHARGE where TRX_DOC_REF = ? and TRX_DOC_REF_LINE_NUM = ? and Trx_Doc_Ref_Seq_Num = ? and operating_facility_id= ? ";
						
					}
						//stmt = con.createStatement();
						/* Fixed SQL Injection for Common-ICN-0222 */
			
					 	pstmt = con.prepareStatement(sql_addl_charge_for_payer);
			
					 		pstmt.setString(1, trx_doc_ref);
						 	pstmt.setString(2, trx_doc_ref_line_no);
						 	pstmt.setString(3, trx_doc_ref_seq_no);
						 	pstmt.setString(4, str_facility_id);
						
						rs = pstmt.executeQuery();	
						str_addl_charge_for_payer="0";
						while(rs.next())
						{							
					//27-Feb-20 GHL-ICN-0062(Invalid Column Index)
					if(("Y").equals(SiteSpecific_VAT)){
						str_addl_chg_value=rs.getString(1);
						str_addl_charge_for_payer  =  rs.getString(2);
					}else{
						str_addl_charge_for_payer  =  rs.getString(1);
					}
					//27-Feb-20 GHL-ICN-0062(Invalid Column Index)
							if(str_addl_charge_for_payer == null && ("").equals(str_addl_charge_for_payer)) str_addl_charge_for_payer="0";
						}	
						
						//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
						if(amountRoundOff) {
							str_addl_charge_for_payer = cf1.formatCurrency(str_addl_charge_for_payer, noofdecimal);
						} else {
							str_addl_charge_for_payer = BLReportIdMapper.truncateUptoTwoDecimal(str_addl_charge_for_payer,noofdecimal);
						}
						addl_charge_for_payer = Double.parseDouble(str_addl_charge_for_payer);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						//System.err.println("sql_addl_charge_for_payer:"+e.toString());
					} 
					finally{
						rs.close();
						pstmt.close();
					}
			
					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}

				/* Added By Vijay A.P. For PMG CRF 0002 */
					try{
						//if("".equals(cust_code))
						if(cust_code.equals(""))
						{
							pstmt=con.prepareStatement("select blcommon.chk_disc_allow_for_cash_copay(?,?,?,?,?,?,?,?,?,?,?,?,?) discountYesNo from dual");
							pstmt.setString(1, str_facility_id);
							pstmt.setString(2, str_episode_id);
							pstmt.setString(3, str_episode_type);
							pstmt.setString(4, str_visit_id);
							pstmt.setString(5, str_patient_id);
							pstmt.setString(6, cust_code);
							pstmt.setString(7, "S");
							pstmt.setString(8, null);
							pstmt.setString(9, null);
							pstmt.setString(10,blng_serv_code);
							pstmt.setString(11, trx_doc_ref);
							pstmt.setString(12, trx_doc_ref_line_no);
							pstmt.setString(13, trx_doc_ref_seq_num);
							rs = pstmt.executeQuery();	
							
							if(rs!=null)
							{
								while(rs.next())
								{
									discountYesNo=rs.getString("discountYesNo");								
								}
							}						
						}
					}catch(Exception e){
						System.out.println("Exception in blng_serv_code"+e);
						e.printStackTrace();						
					}
					finally{
						rs.close();
						pstmt.close();
					}
%>
		<tr>
		
			<%	
			if(str_color_band.equals("WH")) str_color_band = classval;
		if(str_custmr_id.equals("ALMO") || site3TierAlmoFeature == true) 	//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeature & AAKH-SCF-0404.1
		{  %>
			<td class='<%=str_color_band%>' width='3%'>&nbsp</td>			
				<td class=<%=classval%> width='12%'><div id="billing_service<%=i%>">
			<%}else { %>
		<td class=<%=classval%> width='15%'><div id="billing_service<%=i%>">
			<%} %>				
			<font size=1><%=serv_desc%></font></div></td>
			<input type="hidden" name="blng_serv_code<%=i%>" id="blng_serv_code<%=i%>"	value="<%=blng_serv_code%>" >
			<td class=<%=classval%> width='15%'><div id="serv_item_desc<%=i%>"><font size=1><%=serv_item_desc%></font></div></td>
			<input type="hidden" name="serv_item_code<%=i%>" id="serv_item_code<%=i%>"	value="<%=serv_item_code%>" >
			<td class=<%=classval%> width='15%'><div id="billing_group<%=i%>"><font size=1><%=blng_grp_desc%></font></div></td>
			<input type="hidden" name="blng_grp_id<%=i%>" id="blng_grp_id<%=i%>"	value="<%=blng_grp_id%>" >
			<td class=<%=classval%> width='15%'><div id="payer<%=i%>"><font size=1><%=(cust_long_name==null || cust_long_name.equals(""))?"&nbsp;":cust_long_name%></font></div></td>
			<input type="hidden" name="cust_code<%=i%>" id="cust_code<%=i%>"	value="<%=cust_code%>" >
			<td class=<%=classval%> width='15%'><div id="policy<%=i%>"><font size=1><%=(policy_desc==null || policy_desc.equals(""))?"&nbsp;":policy_desc%></font></div></td>
			<input type="hidden" name="policy_type_code<%=i%>" id="policy_type_code<%=i%>"	value="<%=policy_type_code%>" >
			<td class=<%=classval%> width='5%' ><div style='text-align:right' id="gross_amt<%=i%>"><%=upd_gross_charge_amt%></div></td>
			<td class=<%=classval%> width="5%">
<%
/*Code added by Karthik to disable link when max discount percentage or max discount amount is null - Starts*/
	String currdate="";
	String max_disc_per="";
	String max_disc_amt="";
	String str_serv_max_disc_per="";
	String str_serv_max_disc_amt = "";
	String str_payer_max_disc_per="";
	String str_payer_max_disc_amt="";
	String settlement_ind="";	
	
		try
		{		
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			pstmt=con.prepareStatement(query_date);
			rs = pstmt.executeQuery();
			if (rs!=null)
			{
				if (rs.next())
				{
					currdate = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error in date" +e);
		}
		try	{
				CallableStatement  call = 
				con.prepareCall("{ ? = call  blcore.Check_Service_discount(?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?)}");	
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.setString(2,str_facility_id);
				call.setString(3,blng_serv_code);
				call.setString(4,strloggeduser);
				call.setString(5,currdate);
				if(str_module_id.equals("PH") || str_module_id.equals("ST") || str_module_id.equals("PS") || str_module_id.equals("MM"))
				{
					call.setString(6,serv_item_code);
				}
				else
				{
					call.setString(6,"");
				}
				call.registerOutParameter(7,java.sql.Types.VARCHAR);
				call.registerOutParameter(8,java.sql.Types.VARCHAR);
				call.registerOutParameter(9,java.sql.Types.VARCHAR);
				call.registerOutParameter(10,java.sql.Types.VARCHAR);
				call.execute();				
				
				str_serv_max_disc_per = call.getString(7);		
				if(str_serv_max_disc_per==null) str_serv_max_disc_per="";

				str_serv_max_disc_amt = call.getString(8);		
				if(str_serv_max_disc_amt==null) str_serv_max_disc_amt="";					

				str_payer_max_disc_per = call.getString(9);		
				if(str_payer_max_disc_per==null) str_payer_max_disc_per="";

				str_payer_max_disc_amt = call.getString(10);		
				if(str_payer_max_disc_amt==null) str_payer_max_disc_amt="";

				if(call!=null)
				call.close();	
			}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error in date" +e);
		}
		
		try
		{		
			String query_slmt_ind="select SETTLEMENT_IND from bl_blng_grp where blng_grp_id=?";
			pstmt=con.prepareStatement(query_slmt_ind);
			pstmt.setString(1, blng_grp_id);
			rs = pstmt.executeQuery();
			if (rs!=null)
			{
				if (rs.next())
				{
					settlement_ind = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.out.println("error in date" +e);
		}
		
		settlement_ind = settlementIndfolio;//NMC-JD-SCF-055

		/*System.out.println("$$$$$ in str_payer_max_disc_per:"+str_payer_max_disc_per);
		System.out.println("$$$$$ in str_payer_max_disc_amt:"+str_payer_max_disc_amt);
		System.out.println("$$$$$ in str_serv_max_disc_per:"+str_serv_max_disc_per);
		System.out.println("$$$$$ in str_serv_max_disc_amt:"+str_serv_max_disc_amt);
		System.out.println("$$$$$ in blng_grp_id:"+blng_grp_id);			
		System.out.println("$$$$$ in settlement_ind:"+settlement_ind);*/
		
		if(cust_code.equals("")){
			max_disc_per=str_serv_max_disc_per;
			max_disc_amt=str_serv_max_disc_amt;					
		}else{				
			max_disc_per=str_payer_max_disc_per;
			max_disc_amt=str_payer_max_disc_amt;
		}		
		
/*Code added by Karthik to disable link when max discount percentage or max discount amount is null - Ends*/

		if(db_adhoc_disc_amt == db_upd_disc_amt && db_act_gross_amt!=0 && db_org_gross_amt != 0 && (!max_disc_per.equals("") || !max_disc_amt.equals("")))
		{
%>
			<a href="#" onClick="callAdhocDisc('<%=i%>')" ><div id='disc_amt<%=i%>' align='right'><%=upd_disc_amt%></div></a>
<%
		}//Added V200323-MuthuN/NMC-JD-CRF-050
		else if(db_act_gross_amt!=0 && db_org_gross_amt != 0 && (!max_disc_per.equals("") || !max_disc_amt.equals("")) && (settlement_ind.equalsIgnoreCase("C")) && preConfigDiscAmt.equals("Y"))
		{
%>
		<a href="#" onClick="callAdhocDisc('<%=i%>')" ><div id='disc_amt<%=i%>' align='right'><%=upd_disc_amt%></div></a>
<%
		}//Added V200323-MuthuN/NMC-JD-CRF-050
		else
		{
%>
			<div id='disc_amt<%=i%>' align='right'><%=upd_disc_amt%></div>
<%
		}
%>
			</td>	
			<td class=<%=classval%> width='5%' ><div style='text-align:right' id="net_amt<%=i%>"><%=upd_net_charge_amt%></div></td>
<%
			if((db_adhoc_disc_amt == db_upd_disc_amt) && db_act_gross_amt!=0 && db_org_gross_amt != 0)
			{
%>
			<td class=<%=classval%> width='5%' ><div align='center'><INPUT TYPE="checkbox" name="serv_incl_for_disc<%=i%>" id="serv_incl_for_disc<%=i%>" value="YES" CHECKED onClick="chkForIncl('<%=i%>');"></div></td>
<%
			}
			else
			{
%>
			<td class=<%=classval%> width='5%' ><div align='center'><INPUT TYPE="checkbox" name="serv_incl_for_disc<%=i%>" id="serv_incl_for_disc<%=i%>" value="NO" onClick="chkForIncl('<%=i%>');"></div></td>
<%
			}
		//Added V171212-Gayathri/MMS-DM-CRF-0118
if("Y".equals(SiteSpecific_VAT)){
	
	if(!("".equals(str_addl_chg_value)))
	{
%>
	<!-- Added V190820-MuthuN/NMC-JD-SCF-0015 -->
<%if(siteSpecNMC){%>
	<td class=<%=classval%> width='5%' ><div style='text-align:right'><a id="addl_charge_for_payer<%=i%>" href="#" onClick="callAddlChargeDistri('<%=i%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_VAT_CHARGE_DTL.label","bl_labels")%>"><%=str_addl_charge_for_payer%></a></div></td>
<%} else {%>
	<td class=<%=classval%> width='5%' ><div style='text-align:right'><a id="addl_charge_for_payer<%=i%>" href="#" onClick="callAddlChargeDistri('<%=i%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_ADDL_CHARGE_DTL.label","bl_labels")%>"><%=str_addl_charge_for_payer%></a></div></td>
<%}%>
	<!-- Added V190820-MuthuN/NMC-JD-SCF-0015 -->
<%
	}
	else
	{
%>
	<td class=<%=classval%> width='5%' ><div style='text-align:right' id="addl_charge_for_payer<%=i%>" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_ADDL_CHARGE_DTL.label","bl_labels")%>"><%=str_addl_charge_for_payer%></div></td>
<%
	}
}
else{
		if(addl_charge_for_payer != 0)
		{
%>
			<td class=<%=classval%> width='5%' ><div style='text-align:right'><a id="addl_charge_for_payer<%=i%>" href="#" onClick="callAddlChargeDistri('<%=i%>')" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_ADDL_CHARGE_DTL.label","bl_labels")%>"><%=str_addl_charge_for_payer%></a></div></td>
<%
			}
			else
			{
%>
			<td class=<%=classval%> width='5%' ><div style='text-align:right' id="addl_charge_for_payer<%=i%>" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_ADDL_CHARGE_DTL.label","bl_labels")%>"><%=str_addl_charge_for_payer%></div></td>
<%
			}
}
%>
			<input type="hidden" name="act_gross_amt<%=i%>" id="act_gross_amt<%=i%>"	value="<%=act_gross_amt%>" >
			<input type="hidden" name="trx_doc_ref<%=i%>" id="trx_doc_ref<%=i%>"	value="<%=trx_doc_ref%>" >
			<input type="hidden" name="trx_doc_ref_line_no<%=i%>" id="trx_doc_ref_line_no<%=i%>"	value="<%=trx_doc_ref_line_no%>" >
			<input type="hidden" name="trx_doc_ref_seq_no<%=i%>" id="trx_doc_ref_seq_no<%=i%>"	value="<%=trx_doc_ref_seq_no%>" >
			<input type="hidden" name="discount_allowed_yn<%=i%>" id="discount_allowed_yn<%=i%>"	value="" >
			<input type="hidden" name="disc_reason_code<%=i%>" id="disc_reason_code<%=i%>"	value="" >
			<input type="hidden" name="adhoc_disc_amt<%=i%>" id="adhoc_disc_amt<%=i%>"	value="<%=adhoc_disc_amt%>" >
			<input type="hidden" name="adhoc_user_id<%=i%>" id="adhoc_user_id<%=i%>"	value="<%=strloggeduser%>" >
			<input type="hidden" name="dis_yes_no<%=i%>" id="dis_yes_no<%=i%>" id="dis_yes_no<%=i%>" value="<%=discountYesNo%>">
			<!-- Added V200330-MuthuN/NMC-JD-CRF-050 -->
			<input type="hidden" name="org_disc_amt<%=i%>" id="org_disc_amt<%=i%>"	value="<%=org_disc_amt%>" >
			<!-- Added V200330-MuthuN/NMC-JD-CRF-050 -->
		</tr>
<%			
					cust_long_name="";
					policy_desc="";
					i++;
				}//while		
			}//rs 
			
			/* Fixed SQL Injection for Common-ICN-0222 */
			if (rs1 != null)   rs1.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in main qry :"+e);
		}
%>  
	</tbody>
	</table>
	<input type="hidden" name="module_id" id="module_id"	value="<%=str_module_id%>" >
	<input type="hidden" name="total_records" id="total_records"	value="<%=i%>" >
	<input type="hidden" name="noofdecimal" id="noofdecimal"	value="<%=noofdecimal%>" >
	<input type="hidden" name="checked_services" id="checked_services" value="">
	<input type="hidden" name="existing_reason_code" id="existing_reason_code" value="<%=existing_reason_code%>">
	<input type="hidden" name="trx_doc_ref" id="trx_doc_ref"	value="<%=trx_doc_ref%>" >
	<input type="hidden" name="trx_doc_ref_line_no" id="trx_doc_ref_line_no"	value="<%=trx_doc_ref_line_no%>" >
	<input type="hidden" name="patient_id" id="patient_id"	value="<%=str_patient_id%>" >
	<input type="hidden" name="episode_type" id="episode_type"	value="<%=str_episode_type%>" >
	<input type="hidden" name="episode_id" id="episode_id"	value="<%=str_episode_id%>" >
	<input type="hidden" name="visit_id" id="visit_id"	value="<%=str_visit_id%>" >
	<input type="hidden" name="selected_serv_rec" id="selected_serv_rec" value="<%=selected_serv_rec%>">
	<!-- Added V200327-MuthuN/NMC-JD-CRF-050 -->
	<input type="hidden" name="preConfigDiscAmt" id="preConfigDiscAmt" value="<%=preConfigDiscAmt%>">
	<!-- Added V200327-MuthuN/NMC-JD-CRF-050 -->

</form>
<script>
	parent.frames[3].location.href="../../eBL/jsp/BLAdhocDiscBtn.jsp?<%=query_string%>"
</script>
</BODY>
</HTML>
<%
	}catch(Exception ee)
	{
		ee.printStackTrace();
		System.err.println("Error in main Adhoc disc " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>

