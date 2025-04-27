<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	Statement stmt				= null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;
	String classval="";
	try
	{
		con	=	ConnectionManager.getConnection(request);

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");

		int i=0,noofdecimal=2;

		String doc_type_code="",doc_num="", checked_var="CHECKED";

		String locale="", str_facility_id="", strloggeduser="", strclientip="", str_patient_id="", str_episode_type="", str_episode_id="", str_visit_id="", str_encounter_id="", str_module_id="", str_function_id="";

		String blng_serv_code="",blng_serv_desc="",serv_item_code="",serv_item_desc="",service_date="",org_net_charge_amt="",reimbursable_yn="N",reimbursable_ind="",net_reimbursable_amt="",override_reimbursable_yn="N",serv_module_id="",blng_grp_id="";

		String trx_doc_ref="",trx_doc_ref_line_num="",trx_doc_ref_seq_num="";

		double v_org_net_charge_amt=0, v_net_reimbursable_amt=0;
		
		CurrencyFormat cf1 = new CurrencyFormat();

		String query_string=request.getQueryString();

		try
		{
			locale	= (String)session.getAttribute("LOCALE");	
			if(locale==null || locale.equals("")) locale="en";	

			str_facility_id = (String) session.getValue("facility_id");
			if (str_facility_id==null) str_facility_id = "";

			strloggeduser	=  (String) session.getValue("login_user");	
			if (strloggeduser==null) strloggeduser = "";

			strclientip = p.getProperty("client_ip_address");
			if (strclientip==null) strclientip = "";

			str_patient_id = request.getParameter("patient_id");	
			if(str_patient_id==null) str_patient_id="";	
			
			str_episode_type = request.getParameter("episode_type");	
			if(str_episode_type==null) str_episode_type="";	
		
			str_episode_id = request.getParameter("episode_id");	
			if(str_episode_id==null) str_episode_id="";	

			str_visit_id = request.getParameter("visit_id");	
			if(str_visit_id==null) str_visit_id="";	
		
			str_encounter_id = request.getParameter("encounter_id");	
			if(str_encounter_id==null) str_encounter_id="";	

			str_module_id     =  request.getParameter("module_id");	
			if(str_module_id == null) str_module_id="";

			doc_type_code =  request.getParameter("billdoctypecode");
			if(doc_type_code == null) doc_type_code="";

			doc_num =  request.getParameter("billdocnum");
			if(doc_num == null) doc_num="";

			str_function_id =  request.getParameter("function_id");
			if(str_function_id == null) str_function_id="";
		}
		catch(Exception e)
		{
			System.err.println("Error in BLBillListDtls.jsp - fetching values:"+e);
		}
%>
	<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-5); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		</style>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>		
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language='javascript' src='../../eBL/js/BLBillReimburseAmtDetails.js'></script>
		<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
</head>
<script>
var flag_YN = "N";//Modified by Muthukumar against crf-668 on 14-11-11
var retVal=new Array();//Modified by Muthukumar against crf-668 on 14-11-11
function reimburse_check()
{
	var total_records = document.forms[0].total_records.value;

	for(var i=0;i<total_records;i++)
	{
		var stup_reimb_type_hid = eval("document.forms[0].stup_reimb_type_hid_"+i);
		stup_reimb_type_hid = stup_reimb_type_hid.value;
		
		var stup_reimb_type_id = "stup_reimb_type_"+i;

		var stup_reimb_type = eval(parent.frames[1].document.getElementById(stup_reimb_type_id));

		if(stup_reimb_type_hid == "F")
		{
			stup_reimb_type.innerText = getLabel("eBL.FULL.label","BL");
		}
		else if(stup_reimb_type_hid == "P")
		{
			stup_reimb_type.innerText = getLabel("eBL.PART.label","BL");
		}
		else if(stup_reimb_type_hid == "N")
		{
			stup_reimb_type.innerText = getLabel("eBL.NA.label","BL");
		}
		else
		{
			stup_reimb_type.innerText = "";
		}
	}
}

function load_audit_dtls(sel_rec)
{
	var tot_rec = document.forms[0].total_records.value;
	var rec_to_load;

	for(var i=0;i<tot_rec;i++)
	{
		if(i==sel_rec)
		{
			var trx_doc_ref = eval("document.forms[0].trx_doc_ref_"+i);
			trx_doc_ref = trx_doc_ref.value;

			var trx_doc_ref_line_num = eval("document.forms[0].trx_doc_ref_line_num_"+i);
			trx_doc_ref_line_num = trx_doc_ref_line_num.value;

			var trx_doc_ref_seq_num = eval("document.forms[0].trx_doc_ref_seq_num_"+i);
			trx_doc_ref_seq_num = trx_doc_ref_seq_num.value;
	
			parent.frames[2].location.href = "../../eBL/jsp/BLBillReimburseAmtBillServAuditDetails.jsp?trx_doc_ref="+trx_doc_ref+"&trx_doc_ref_line_num="+trx_doc_ref_line_num+"&trx_doc_ref_seq_num="+trx_doc_ref_seq_num;
//			break;
		}
	}
}

function check_for_override(sel_rec)
{
	var tot_rec = document.forms[0].total_records.value;
	var locale = document.forms[0].locale.value;
	var override_reimbursable_yn = eval("document.forms[0].override_reimbursable_yn_"+sel_rec);
	//var retVal=new Array(); //commented by Muthukumar against crf-668 on 14-11-11
	override_reimbursable_yn = override_reimbursable_yn.value;

	var serv_date = document.getElementById('serv_date_'+sel_rec);
	serv_date = serv_date.innerText;

	serv_date = convertDate(serv_date,'DMYHMS',locale,"en");

	var serv_module_id= eval("document.forms[0].serv_module_id_"+sel_rec);
	serv_module_id = serv_module_id.value;

	var blng_serv_code = eval("document.forms[0].blng_serv_code_"+sel_rec);
	blng_serv_code = blng_serv_code.value;

	var serv_item_code = eval("document.forms[0].serv_item_code_"+sel_rec);
	serv_item_code = serv_item_code.value;

	var override_YN = eval("document.forms[0].override_YN_"+sel_rec);

	if(override_YN.checked)
	{
		if(override_reimbursable_yn == "N")
		{
			alert(getMessage("BL6326","BL"));//Needs to be added in JAVA resource bundle
			override_YN.checked=false;
			return false;
		}
//commented by Muthukumar against crf-668 on 14-11-11
		/*else
		{
			authScr(sel_rec,serv_date,blng_serv_code,serv_item_code,serv_module_id);
		}*/
//commented by Muthukumar against crf-668 on 14-11-11
// Added by Muthukumar against crf-668 on 14-11-11 Starts Here
		else if (flag_YN == "N" && override_reimbursable_yn == "Y"){
                   authScr(sel_rec,serv_date,blng_serv_code,serv_item_code,serv_module_id);			
				   }		

		else if (flag_YN == "Y" && override_reimbursable_yn == "Y"){		
			var reimb_override_allow_YN = eval("document.forms[0].reimb_override_allow_YN_"+sel_rec);
			reimb_override_allow_YN.value = retVal[0];

			var max_part_serv_reim_per = eval("document.forms[0].max_part_serv_reim_per_"+sel_rec);
			max_part_serv_reim_per.value = retVal[1];

			var max_part_serv_reim_amt = eval("document.forms[0].max_part_serv_reim_amt_"+sel_rec);
			max_part_serv_reim_amt.value = retVal[2];
		
			var override_control = eval("document.forms[0].override_control_"+sel_rec);			
			override_control.value = retVal[3];

			var reimb_reason_code = eval("document.forms[0].reimb_reason_code_"+sel_rec);
			reimb_reason_code.value = retVal[4];
			
			document.forms[0].existing_reason_code.value = reimb_reason_code.value;	

			var curr_reimb_YN = eval("document.forms[0].curr_reimb_YN_"+sel_rec);
			curr_reimb_YN.disabled = false;
			
			if(override_control.value != 'F')	
				curr_reimb_items_check(sel_rec);		
		}	
// Added by Muthukumar against crf-668 on 14-11-11 Ends Here
	}
	else
	{
		var override_reimbursable_yn = eval("document.forms[0].curr_reimb_YN_"+sel_rec);
		var curr_reimb_type = eval("document.forms[0].curr_reimb_type_"+sel_rec);
		var curr_rev_amt = eval("document.forms[0].curr_rev_amt_"+sel_rec);
			
		override_reimbursable_yn.checked = false;
		override_reimbursable_yn.disabled = true;
	
		curr_reimb_type.value = "";
		curr_reimb_type.disabled = true;

		curr_rev_amt.value = "";
		curr_rev_amt.disabled = true;
	}
}

async function authScr(sel_rec,serv_date,blng_serv_code,serv_item_code,serv_module_id)
{	
	var existing_reason_code = document.forms[0].existing_reason_code.value;
	//var retVal=new Array();//commented by Muthukumar against crf-668 on 14-11-11
	var dialogHeight= "16vh" ;
	var dialogWidth	= "25vw" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	var url = "../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?called_frm=BILL_REIMB_AMT&blng_serv_date="+serv_date+"&blng_serv_code="+blng_serv_code+"&serv_item_code="+serv_item_code+"&serv_module_id="+serv_module_id+"&existing_reason_code="+existing_reason_code;
	retVal =await window.showModalDialog(url,arguments,features);
	if(retVal==null) retVal="";
	if(retVal.length>0)
	{	
		if(retVal[0] == "Y")
		{
			flag_YN = "Y";//Modified by Muthukumar against crf-668 on 14-11-11
			var reimb_override_allow_YN = eval("document.forms[0].reimb_override_allow_YN_"+sel_rec);
			reimb_override_allow_YN.value = retVal[0];

			var max_part_serv_reim_per = eval("document.forms[0].max_part_serv_reim_per_"+sel_rec);
			max_part_serv_reim_per.value = retVal[1];

			var max_part_serv_reim_amt = eval("document.forms[0].max_part_serv_reim_amt_"+sel_rec);
			max_part_serv_reim_amt.value = retVal[2];

			var override_control = eval("document.forms[0].override_control_"+sel_rec);
			override_control.value = retVal[3];

			var reimb_reason_code = eval("document.forms[0].reimb_reason_code_"+sel_rec);
			reimb_reason_code.value = retVal[4];

			document.forms[0].existing_reason_code.value = reimb_reason_code.value;			

			var curr_reimb_YN = eval("document.forms[0].curr_reimb_YN_"+sel_rec);
			curr_reimb_YN.disabled = false; 
			
			
			if(override_control.value != 'F')	
				curr_reimb_items_check(sel_rec);
		}
/*
		else if(retVal[0] == "N")
		{
			alert(getMessage("BL6327","BL"));
			return false;
		}
*/
	}
	else
	{
		var override_YN = eval("document.forms[0].override_YN_"+sel_rec);
		override_YN.checked = false;
		var curr_reimb_YN = eval("document.forms[0].curr_reimb_YN_"+sel_rec);
		curr_reimb_YN.checked = false;
		var curr_reimb_type = eval("document.forms[0].curr_reimb_type_"+sel_rec);
		curr_reimb_type.value = "";
		var curr_rev_amt = eval("document.forms[0].curr_rev_amt_"+sel_rec);
		curr_rev_amt.value = "";
	}
}

function curr_reimb_items_check(sel_rec)
{
	var noofdecimal = document.forms[0].noofdecimal.value;
	var override_control1 = eval("document.forms[0].override_control_"+sel_rec);
	//override_control = override_control.value; //commented by Muthukumar against crf-668 on 14-11-11
	override_control = override_control1.value;

	var net_chrg_amt = document.getElementById('net_chrg_amt_'+sel_rec);
	net_chrg_amt = net_chrg_amt.innerText;

	var stup_reimb_YN = eval("document.forms[0].stup_reimb_YN_"+sel_rec);

	var stup_reimb_type = eval("document.forms[0].stup_reimb_type_hid_"+sel_rec);
	stup_reimb_type = stup_reimb_type.value;

	var stup_reimb_amt = document.getElementById('stup_reimb_amt_'+sel_rec);
	stup_reimb_amt = stup_reimb_amt.innerText;

	var curr_reimb_YN = eval("document.forms[0].curr_reimb_YN_"+sel_rec);
	var curr_reimb_type = eval("document.forms[0].curr_reimb_type_"+sel_rec);
	var curr_rev_amt = eval("document.forms[0].curr_rev_amt_"+sel_rec);

	if(override_control == "F")
	{
		if(curr_reimb_YN.checked)
		{
			if(stup_reimb_type == "F")
			{
				curr_reimb_type.value = 'P';
				curr_rev_amt.value = 0;
				curr_rev_amt.disabled = false;
				curr_reimb_type.DISABLED;
			}
			else if(stup_reimb_type == "P")
			{
				curr_reimb_type.value = 'F';
				curr_rev_amt.value = net_chrg_amt;
				curr_reimb_type.disabled = false;
				curr_rev_amt.DISABLED;
			}
			else if(stup_reimb_type == "N")
			{
				curr_reimb_type.value = 'F';
				curr_rev_amt.value = net_chrg_amt;
				curr_reimb_type.disabled = false;
				curr_rev_amt.disabled = true;
			}
		}
		else
		{
			curr_reimb_type.value = "N";

			if(stup_reimb_YN.checked || stup_reimb_type == "N")
			{
				curr_rev_amt.value = 0;
				curr_rev_amt.disabled = true;
			}
		}
	}
	else if(override_control == "R")
	{
		if(stup_reimb_YN.checked)
	  	{
			curr_reimb_YN.checked = false;
			curr_reimb_type.value = "N";
  		    curr_rev_amt.value = 0;
		}
		else
		{
			curr_reimb_YN.checked = true;
			if(stup_reimb_type == "F")
				curr_reimb_type.value = "P";
			else if(stup_reimb_type == "P")
				curr_reimb_type.value = "F";
			else if(stup_reimb_type == "N")
			{
				curr_reimb_type.value = "F";
				curr_rev_amt.value = net_chrg_amt;
			}
		}
	}
	if(curr_rev_amt.value != "")
	{
		put_decimal(curr_rev_amt,noofdecimal);
	}
}

function curr_reimb_type_chg(sel_rec)
{

	var noofdecimal = document.forms[0].noofdecimal.value;

	var override_control = eval("document.forms[0].override_control_"+sel_rec);
	override_control = override_control.value;

	var net_chrg_amt = document.getElementById('net_chrg_amt_'+sel_rec);
	net_chrg_amt = net_chrg_amt.innerText;

	var stup_reimb_YN = eval("document.forms[0].stup_reimb_YN_"+sel_rec);

	var stup_reimb_type = eval("document.forms[0].stup_reimb_type_hid_"+sel_rec);
	stup_reimb_type = stup_reimb_type.value;

	var stup_reimb_amt =document.getElementById('stup_reimb_amt_'+sel_rec);
	stup_reimb_amt = stup_reimb_amt.innerText;

	var curr_reimb_YN = eval("document.forms[0].curr_reimb_YN_"+sel_rec);
	var curr_reimb_type = eval("document.forms[0].curr_reimb_type_"+sel_rec);
	var curr_rev_amt = eval("document.forms[0].curr_rev_amt_"+sel_rec);

	if(override_control == "F")
	{
		if(curr_reimb_YN.checked)
		{
//		if(stup_reimb_type == "N")
//			{
				if(curr_reimb_type.value == "F")
				{
					curr_rev_amt.value = net_chrg_amt;
					curr_reimb_type.disabled = false;
					curr_rev_amt.disabled = true;
				}
				else if(curr_reimb_type.value == "P")
				{
					curr_rev_amt.value = 0;
					curr_reimb_type.disabled = false;
					curr_rev_amt.disabled = false;
				}
				else if(curr_reimb_type.value == "N")
				{
					curr_reimb_type.value = "F";
					curr_rev_amt.value = net_chrg_amt;
					curr_reimb_type.disabled = false;
					curr_rev_amt.disabled = true;
				}
				else
				{
					curr_reimb_type.value = "F";
					curr_rev_amt.value = net_chrg_amt;
					curr_reimb_type.disabled = false;
					curr_rev_amt.disabled = true;
				}
//			}
		}
		else
		{
			curr_reimb_type.value = "N";

			if(stup_reimb_YN.checked || stup_reimb_type == "N")
			{
				curr_rev_amt.value = 0;
				curr_rev_amt.disabled = true;
			}
		}
	}
	else if(override_control == "R")
	{
		if(stup_reimb_YN.checked)
	  	{
			curr_reimb_YN.checked = false;
			curr_reimb_type.value = "N";
  		    curr_rev_amt.value = 0;
		}
		else
		{
			curr_reimb_YN.checked = true;
			if(stup_reimb_type == "F")
				curr_reimb_type.value = "P";
			else if(stup_reimb_type == "P")
				curr_reimb_type.value = "F";
			else if(stup_reimb_type == "N")
			{
				curr_reimb_type.value = "F";
				curr_rev_amt.value = net_chrg_amt;
			}
		}
	}

	if(curr_rev_amt.value != "")
	{
		put_decimal(curr_rev_amt,noofdecimal);
	}
}

function chk_for_allwd_amt(sel_rec)
{
	var curr_rev_amt = eval("document.forms[0].curr_rev_amt_"+sel_rec);

	if(CheckForChar(curr_rev_amt))
	{
		var allowed_amt = get_allowed_amt(sel_rec);
		var	perc_amt_label = get_perc_amt_messg(sel_rec);
		var noofdecimal = document.forms[0].noofdecimal.value;

		put_decimal(curr_rev_amt,noofdecimal);

		var curr_reimb_type = eval("document.forms[0].curr_reimb_type_"+sel_rec);
		curr_reimb_type = curr_reimb_type.value;

		var net_chrg_amt = document.getElementById('net_chrg_amt_'+sel_rec);
		net_chrg_amt = net_chrg_amt.innerText;

		if(curr_reimb_type == 'P')
		{
			if(eval(curr_rev_amt.value) > eval(allowed_amt))
			{
				var mess_disp = getMessage("BL6328","BL");
				mess_disp = mess_disp.replace("%1",perc_amt_label);
					
				alert(mess_disp);
				curr_rev_amt.value = "";
				return false;
			}
			if(eval(net_chrg_amt) < eval(curr_rev_amt.value)) 
			{
				var mess_disp = getMessage("BL6328","BL");
				mess_disp = mess_disp.replace("%1",net_chrg_amt);
				alert(mess_disp);
				curr_rev_amt.value = "";
				return false;
			}
		
			if (eval(curr_rev_amt.value) <= 0)
			{
				alert(getMessage("BL1188","BL"));
				curr_rev_amt.value = "";
				return false;
			}	
			put_decimal(curr_rev_amt,noofdecimal);
		}
	}
}

function get_allowed_amt(sel_rec)
{
	var reimb_override_allow_YN = eval("document.forms[0].reimb_override_allow_YN_"+sel_rec);
	reimb_override_allow_YN = reimb_override_allow_YN.value;

	var max_part_serv_reim_per = eval("document.forms[0].max_part_serv_reim_per_"+sel_rec);
	max_part_serv_reim_per = max_part_serv_reim_per.value;

	var max_part_serv_reim_amt = eval("document.forms[0].max_part_serv_reim_amt_"+sel_rec);
	max_part_serv_reim_amt = max_part_serv_reim_amt.value;

	var override_control = eval("document.forms[0].override_control_"+sel_rec);
	override_control = override_control.value;

	var allowd_amt = document.getElementById('net_chrg_amt_'+sel_rec);
	allowd_amt = allowd_amt.innerText;

	if(max_part_serv_reim_per != "" && max_part_serv_reim_amt != "")
	{
		allowd_amt = eval(allowd_amt) * max_part_serv_reim_per/100;

		if(allowd_amt<max_part_serv_reim_amt)
	 	  return allowd_amt;
		else
	 	  return max_part_serv_reim_amt;
	}
	else if(max_part_serv_reim_per == "" && max_part_serv_reim_amt != "")
	{
		if(allowd_amt < max_part_serv_reim_amt)
 			return allowd_amt;
		else
 			return max_part_serv_reim_amt;
	}
	else if(max_part_serv_reim_per != "" && max_part_serv_reim_amt == "")
	{
	   	allowd_amt = allowd_amt * max_part_serv_reim_per/100;
   		return allowd_amt;
	}
	else
	{
		return allowd_amt;
	}
}

function get_perc_amt_messg(sel_rec)
{
	var reimb_override_allow_YN = eval("document.forms[0].reimb_override_allow_YN_"+sel_rec);
	reimb_override_allow_YN = reimb_override_allow_YN.value;

	var max_part_serv_reim_per = eval("document.forms[0].max_part_serv_reim_per_"+sel_rec);
	max_part_serv_reim_per = max_part_serv_reim_per.value;

	var max_part_serv_reim_amt = eval("document.forms[0].max_part_serv_reim_amt_"+sel_rec);
	max_part_serv_reim_amt = max_part_serv_reim_amt.value;

	var override_control = eval("document.forms[0].override_control_"+sel_rec);
	override_control = override_control.value;

	var allowd_amt = document.getElementById('net_chrg_amt_'+sel_rec);
	allowd_amt = allowd_amt.innerText;

	var perc_label = getLabel("Common.Percent.label","common");

	if(max_part_serv_reim_per != "" && max_part_serv_reim_amt != "")
	{
		allowd_amt = eval(allowd_amt) * max_part_serv_reim_per/100;

		if(allowd_amt<max_part_serv_reim_amt)
			return (max_part_serv_reim_per+" "+perc_label);
		else
			return max_part_serv_reim_amt;
	}
	else if(max_part_serv_reim_per == "" && max_part_serv_reim_amt != "")
	{
		if(allowd_amt < max_part_serv_reim_amt)
 			return allowd_amt;
		else
 			return max_part_serv_reim_amt;
	}
	else if(max_part_serv_reim_per != "" && max_part_serv_reim_amt == "")
	{
	   	allowd_amt = allowd_amt * max_part_serv_reim_per/100;
   		return (max_part_serv_reim_per+" "+perc_label);
	}
	else
	{
		return allowd_amt;
	}
}

function CheckForChar(Obj)
{
	var check_var = Obj.value;

	numList = '1234567890.';
	
	for (i=0;i<check_var.length;i++)
	{
		if (numList.indexOf(check_var.charAt(i)) == -1) 
		{
			alert(getMessage("INVALID_NUMBER_FORMAT","Common"));
			Obj.select();
			return false;  
		}
	}
	return true;
}

function disable_but()
{
	parent.parent.frames[0].document.forms[0].home.disabled = true;
}
</script>

<BODY onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onLoad="disable_but();reimburse_check();load_audit_dtls('0');">
<FORM name='BLBillReimbAmtBillServDtlsForm' id='BLBillReimbAmtBillServDtlsForm' method='post' onLoad="" action="" method="" target="">	
	<div id="tbl-container" STYLE="overflow: auto; width: 100%; height: 340px;   padding:3px; margin: 0px">
		<table border='1' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>
	<thead>
		<tr>
			<td class='COLUMNHEADER' colspan='11' align='left'><fmt:message key="eBL.LIST_OF_SERV.label" bundle="${bl_labels}"/></td>
		</tr>
		<tr><td></td></tr>
		<tr>			
			<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='30%'><fmt:message key="eBL.SERVICE_DATE.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.NET_CHARGE.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.DFND_REIMB.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.DFN_REIMB_TYPE.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.DFN_REIMB_AMT.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.override.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.CURR_REIMB.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.CURR_REIMB_TYPE.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.REVISED_AMT.label" bundle="${bl_labels}"/></td>
		</tr>
	</thead>
	<tbody>
<%
		try
		{
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
				System.err.println("3="+e.toString());
			}

			String strsql="";

			if(str_function_id.equals("EBL_OP_OVERRIDE_REIM_DTLS") || str_function_id.equals("EBL_IP_OVERRIDE_REIM_DTLS"))
			{
				strsql="SELECT BLNG_SERV_CODE,SERV_ITEM_CODE,to_char(SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS') SERVICE_DATE,ORG_NET_CHARGE_AMT,REIMBURSABLE_YN,REIMBURSABLE_IND,NET_REIMBURSABLE_AMT,DECODE('"+locale+"','en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)) SERV_ITEM_DESC,TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,OVERRIDE_REIMBURSABLE_YN,MODULE_ID,a.BLNG_GRP_ID FROM BL_PATIENT_CHARGES_FOLIO A, BL_BILL_HDR B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.BILL_DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.BILL_DOC_NUM = B.DOC_NUM AND A.Operating_Facility_Id='"+str_facility_id+"' AND A.PATIENT_ID = '"+str_patient_id+"' AND NVL(A.ORG_NET_CHARGE_AMT,0)>0 AND B.DOC_TYPE_CODE='"+doc_type_code+"' AND B.DOC_NUM='"+doc_num+"'";
			}
			else if(str_function_id.equals("EBL_OP_OVERIDE_UNBLD_REIM_DTLS") || str_function_id.equals("EBL_IP_OVERIDE_UNBLD_REIM_DTLS"))
			{
				strsql="SELECT BLNG_SERV_CODE,SERV_ITEM_CODE,to_char(SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS') SERVICE_DATE,ORG_NET_CHARGE_AMT,REIMBURSABLE_YN,REIMBURSABLE_IND,NET_REIMBURSABLE_AMT,DECODE('"+locale+"','en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)) SERV_ITEM_DESC,TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,OVERRIDE_REIMBURSABLE_YN,MODULE_ID,a.BLNG_GRP_ID FROM BL_PATIENT_CHARGES_FOLIO A Where Operating_Facility_Id='"+str_facility_id+"' AND PATIENT_ID = '"+str_patient_id+"' And Episode_Type='"+str_episode_type+"' And (( Episode_Type IN ('O','E','I','D') And NVL(Episode_Id,99999999) = Nvl('"+str_episode_id+"',99999999)) OR Episode_Type NOT IN ('O','E','I','D')) And (( Episode_Type IN ('O','E') And Nvl(Visit_Id,9999)=Nvl('"+str_visit_id+"',9999)) OR Episode_Type NOT IN ('O','E')) AND NVL(ORG_NET_CHARGE_AMT,0)>0 And NVL(TRX_STATUS,'O')='O' And NVL(BILLED_FLAG,'N')='N' And BILL_DOC_TYPE_CODE IS NULL And Cust_Code Is Null";
			}

//			System.err.println("strsql "+strsql);	

			stmt = con.createStatement();
			rs = stmt.executeQuery(strsql) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					blng_serv_code = rs.getString(1);
					if(blng_serv_code == null) blng_serv_code="";

					serv_item_code = rs.getString(2);
					if(serv_item_code == null) serv_item_code="";

					service_date = rs.getString(3);
					if(service_date == null) service_date="";

					org_net_charge_amt=rs.getString(4);
					if(org_net_charge_amt == null) org_net_charge_amt="0";
					org_net_charge_amt = cf1.formatCurrency(org_net_charge_amt, noofdecimal);
					v_org_net_charge_amt = Double.parseDouble(org_net_charge_amt);

					reimbursable_yn = rs.getString(5);
					if(reimbursable_yn == null) reimbursable_yn="N";

					reimbursable_ind =rs.getString(6);
					if(reimbursable_ind == null) reimbursable_ind="";

					net_reimbursable_amt=rs.getString(7);
					if(net_reimbursable_amt == null) net_reimbursable_amt="0";
					net_reimbursable_amt = cf1.formatCurrency(net_reimbursable_amt, noofdecimal);
					v_net_reimbursable_amt = Double.parseDouble(net_reimbursable_amt);

					serv_item_desc=rs.getString(8);
					if(serv_item_desc == null) serv_item_desc="&nbsp;";

					trx_doc_ref=rs.getString(9);
					if(trx_doc_ref == null) trx_doc_ref="";
					
					trx_doc_ref_line_num=rs.getString(10);
					if(trx_doc_ref_line_num == null) trx_doc_ref_line_num="";
					
					trx_doc_ref_seq_num=rs.getString(11);
					if(trx_doc_ref_seq_num == null) trx_doc_ref_seq_num="";

					override_reimbursable_yn=rs.getString(12);
					if(override_reimbursable_yn == null) override_reimbursable_yn="N";

					serv_module_id = rs.getString(13);
					if(serv_module_id == null) serv_module_id="";

					blng_grp_id = rs.getString(14);
					if(blng_grp_id == null) blng_grp_id="";

					if(reimbursable_yn.equals("Y"))
					{
						checked_var="CHECKED";
					}
					else
					{
						checked_var="";
					}

					try
					{		
						pstmt1 = con.prepareStatement( " select SHORT_DESC from bl_blng_serv_lang_vw where blng_serv_code='"+blng_serv_code+"' and language_id='"+locale+"'");
						rs1 = pstmt1.executeQuery();	
						while(rs1.next())
						{
							blng_serv_desc  =  rs1.getString(1);		
						}		
						if(blng_serv_desc == null) blng_serv_desc="";
						rs1.close();
						pstmt1.close();
					}
					catch(Exception e)
					{
						System.err.println("Billing Serv Desc Fetching="+e.toString());
					}

					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
%>
			<tr>
				<td class=<%=classval%> width='20%'><a href="javascript:load_audit_dtls('<%=i%>');" title="Click for Audit Details"><div id='blng_serv_desc_<%=i%>'><%=blng_serv_desc%></div></a></td>
				<td class=<%=classval%> width='20%'><div id='item_desc_<%=i%>'><%=serv_item_desc%></div></td>
				<td class=<%=classval%> width='20%'><div id='serv_date_<%=i%>'><%=com.ehis.util.DateUtils.convertDate(service_date,"DMYHMS","en",locale)%></div></td>
				<td class=<%=classval%> width='20%'><div id='net_chrg_amt_<%=i%>' style='text-align:right'><%=org_net_charge_amt%></div></td>
				<td class=<%=classval%> width='20%'><div align='center'><input type="checkbox" name="stup_reimb_YN_<%=i%>" id="stup_reimb_YN_<%=i%>" <%=checked_var%> DISABLED></input></div></td>
				<td class=<%=classval%> width='20%'><div id="stup_reimb_type_<%=i%>" align='center'></div>
<!--			<select name="stup_reimb_type_<%=i%>" id="stup_reimb_type_<%=i%>" DISABLED>
				<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value='F'><fmt:message key="eBL.FULL.label" bundle="${bl_labels}"/></option>
				<option value='P'><fmt:message key="eBL.PART.label" bundle="${bl_labels}"/></option>
				<option value='N'><fmt:message key="eBL.NA.label" bundle="${bl_labels}"/></option>
				</select>
-->
				</td>
				<td class=<%=classval%> width='20%'><div id='stup_reimb_amt_<%=i%>' style='text-align:right'><%=net_reimbursable_amt%></div></td>
				<td class=<%=classval%> width='20%'><div align='center'><input type="checkbox" name="override_YN_<%=i%>" id="override_YN_<%=i%>" onClick="check_for_override('<%=i%>')"></div></td>
				<td class=<%=classval%> width='20%'><div align='center'><input type="checkbox" name="curr_reimb_YN_<%=i%>" id="curr_reimb_YN_<%=i%>" DISABLED onClick="curr_reimb_items_check('<%=i%>');"></input></div></td>
				<td class=<%=classval%> width='20%'>
					<select name="curr_reimb_type_<%=i%>" id="curr_reimb_type_<%=i%>" DISABLED onChange="curr_reimb_type_chg('<%=i%>');">
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='F'><fmt:message key="eBL.FULL.label" bundle="${bl_labels}"/></option>
						<option value='P'><fmt:message key="eBL.PART.label" bundle="${bl_labels}"/></option>
						<option value='N'><fmt:message key="eBL.NA.label" bundle="${bl_labels}"/></option>
					</select>
				</td>
				<td class=<%=classval%> width='20%'><input type='text' name="curr_rev_amt_<%=i%>" id="curr_rev_amt_<%=i%>" onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value));' value="" onBlur="chk_for_allwd_amt('<%=i%>');" DISABLED style='text-align:right'></td>
			</tr>
			<input type='hidden' name='blng_serv_code_<%=i%>' id='blng_serv_code_<%=i%>' value="<%=blng_serv_code%>">
			<input type='hidden' name='serv_item_code_<%=i%>' id='serv_item_code_<%=i%>' value="<%=serv_item_code%>">
			<input type='hidden' name='stup_reimb_type_hid_<%=i%>' id='stup_reimb_type_hid_<%=i%>' value="<%=reimbursable_ind%>">
			<input type='hidden' name='override_reimbursable_yn_<%=i%>' id='override_reimbursable_yn_<%=i%>' value="<%=override_reimbursable_yn%>">			
			<input type='hidden' name='trx_doc_ref_<%=i%>' id='trx_doc_ref_<%=i%>' value="<%=trx_doc_ref%>">
			<input type='hidden' name='trx_doc_ref_line_num_<%=i%>' id='trx_doc_ref_line_num_<%=i%>' value="<%=trx_doc_ref_line_num%>">
			<input type='hidden' name='trx_doc_ref_seq_num_<%=i%>' id='trx_doc_ref_seq_num_<%=i%>' value="<%=trx_doc_ref_seq_num%>">
			<input type='hidden' name='serv_module_id_<%=i%>' id='serv_module_id_<%=i%>' value="<%=serv_module_id%>">			
			<input type='hidden' name='blng_grp_id_<%=i%>' id='blng_grp_id_<%=i%>' value="<%=blng_grp_id%>">						
			<input type='hidden' name='reimb_override_allow_YN_<%=i%>' id='reimb_override_allow_YN_<%=i%>' value="">			
			<input type='hidden' name='max_part_serv_reim_per_<%=i%>' id='max_part_serv_reim_per_<%=i%>' value="">			
			<input type='hidden' name='max_part_serv_reim_amt_<%=i%>' id='max_part_serv_reim_amt_<%=i%>' value="">			
			<input type='hidden' name='override_control_<%=i%>' id='override_control_<%=i%>' value="">	
			<input type='hidden' name='reimb_reason_code_<%=i%>' id='reimb_reason_code_<%=i%>' value="">	

			<input type="hidden" name="rtn_stup_reimb_YN_<%=i%>" id="rtn_stup_reimb_YN_<%=i%>"	value="" >	
			<input type="hidden" name="rtn_stup_reimb_type_<%=i%>" id="rtn_stup_reimb_type_<%=i%>"	value="" >	
			<input type="hidden" name="rtn_stup_reimb_amt_<%=i%>" id="rtn_stup_reimb_amt_<%=i%>"	value="" >	

			<input type="hidden" name="rtn_curr_reimb_YN_<%=i%>" id="rtn_curr_reimb_YN_<%=i%>"	value="" >	
			<input type="hidden" name="rtn_curr_reimb_type_<%=i%>" id="rtn_curr_reimb_type_<%=i%>"	value="" >	
			<input type="hidden" name="rtn_curr_rev_amt_<%=i%>" id="rtn_curr_rev_amt_<%=i%>"	value="" >	
			
<%			
					i++;
				}//while		
			}//rs 
			stmt.close();
			rs.close();
		}
		catch(Exception e)
		{
			System.err.println("Exception in main qry :"+e);
		}
%>  
	</tbody>
	</table>
	</div>

	<input type='hidden' name='bill_doc_type_code' id='bill_doc_type_code' value="<%=doc_type_code%>">
	<input type='hidden' name='bill_doc_num' id='bill_doc_num' value="<%=doc_num%>">	
	<input type="hidden" name="locale" id="locale"	value="<%=locale%>" >
	<input type="hidden" name="total_records" id="total_records"	value="<%=i%>" >
	<input type="hidden" name="noofdecimal" id="noofdecimal"	value="<%=noofdecimal%>" >
	<input type="hidden" name="existing_reason_code" id="existing_reason_code" value="">	

	<input type="hidden" name="patient_id" id="patient_id"	value="<%=str_patient_id%>" >	
	<input type="hidden" name="episode_type" id="episode_type"	value="<%=str_episode_type%>" >	
	<input type="hidden" name="episode_id" id="episode_id"	value="<%=str_episode_id%>" >	
	<input type="hidden" name="visit_id" id="visit_id"	value="<%=str_visit_id%>" >	
	<input type="hidden" name="encounter_id" id="encounter_id"	value="<%=str_encounter_id%>" >	
	<input type="hidden" name="module_id" id="module_id"	value="<%=str_module_id%>" >	
	<input type="hidden" name="episode_type" id="episode_type"	value="<%=str_episode_type%>" >	
	<input type="hidden" name="module_id" id="module_id"	value="<%=str_module_id%>" >	
	<input type="hidden" name="function_id" id="function_id"	value="<%=str_function_id%>" >	
	<input type="hidden" name="query_string" id="query_string"	value="<%=request.getQueryString()%>" >	
</form>
</BODY>
<script>
	var total_records = document.forms[0].total_records.value;
	var function_id = document.forms[0].function_id.value;

//	alert(total_records);
	if(total_records == 0)
	{
		if(function_id == "EBL_OP_OVERIDE_UNBLD_REIM_DTLS" || function_id == "EBL_IP_OVERIDE_UNBLD_REIM_DTLS")
		{
			/* parent.window.returnValue = "Y";
			parent.window.close(); */
			 var dialogBody = parent.parent.parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = "Y";
			    
			const dialogTag = parent.parent.parent.document.getElementById('dialog_tag');    
			dialogTag.close();
		}
	}
</script>
</HTML>
<%
	}
	catch(Exception ee)
	{
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

