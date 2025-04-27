<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*,eBL.BLReportIdMapper" contentType="text/html;charset=UTF-8" %>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;	
	ResultSet rs2				= null;	
	ResultSet rss				= null;	
	
	
	String classval="";
	boolean amountRoundOff = true; //Added V180125-Subha/MMS-JU-SCF-0102
	boolean pkgDepApplicable_YN=true;
	String pkgDepAdjAppl="";
	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		pkgDepApplicable_YN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","PKG_DEP_ADJ_APPL_YN");
		if(pkgDepApplicable_YN){
			pkgDepAdjAppl="Y";
		}
		else{
			pkgDepAdjAppl="N";
		}
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		CurrencyFormat cf1 = new CurrencyFormat();
		String query_string=request.getQueryString();
		//System.err.println("query_string in BLAdhocDisc.jsp:"+query_string);
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	

		String str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
//		System.err.println("strclientip "+strclientip);
		
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

		String str_function_id     =  request.getParameter("function_id");	
		if(str_function_id == null) str_function_id="";

		String str_module_id     =  request.getParameter("module_id");	
		if(str_module_id == null) str_module_id="";

		String str_clinic_code     =  request.getParameter("locn_code");	
		if(str_clinic_code == null) str_clinic_code="";

		String str_visit_type_code     =  request.getParameter("visit_type_code");	
		if(str_visit_type_code == null) str_visit_type_code="";

		String str_blng_grp_id     =  request.getParameter("blnggrp");
		if(str_blng_grp_id == null) str_blng_grp_id="";

		String called_frm     =  request.getParameter("called_frm");
		if(called_frm == null) called_frm="";

		String str_doc_no     =  request.getParameter("doc_no");
		if(str_doc_no == null) str_doc_no="";

		String str_store_code     =  request.getParameter("store_code");
		if(str_store_code == null) str_store_code="";

		String p_slmt_reqd_yn = request.getParameter("slmt_reqd_yn");	
		if(p_slmt_reqd_yn==null) p_slmt_reqd_yn="";	
		
		String str_custmr_id = request.getParameter("customer_id");	
		if(str_custmr_id==null) str_custmr_id="";
		
		
		
		String allow_chkout_with_bill_stmt_yn = request.getParameter("allow_chkout_with_bill_stmt_yn");
		if(allow_chkout_with_bill_stmt_yn == null) allow_chkout_with_bill_stmt_yn="N";
		/***********Added for ghl-crf-1.2******************************/
		String called_for_reg_chg = request.getParameter("called_for_reg_chg");
		if(called_for_reg_chg == null) called_for_reg_chg="N";
		/***************end*********************************************/
		
		String blng_serv_code ="", serv_desc="",act_gross_amt="",trx_doc_ref="",blng_serv_date="",trx_doc_ref_line_num="", serv_item_code="", serv_item_desc=""; //blng_grp_id="", policy_type_code="" UNUSED
		
		int i=0,noofdecimal=2,cnt=0;

		String upd_gross_charge_amt="", upd_disc_amt="", upd_net_charge_amt="", adhoc_disc_amt="";

		double v_act_gross_amt=0, v_upd_gross_charge_amt=0, v_upd_disc_amt=0, v_upd_net_charge_amt=0;

		double v_tot_upd_gross_charge_amt=0, v_tot_upd_disc_amt=0, v_tot_upd_net_charge_amt=0;

		String existing_reason_code="" ;
		String package_ind,sql1;
		/**************Added for package biling*************starts********************/
		String strpackageseqno = request.getParameter("strpackageseqno");	
		if(strpackageseqno==null) strpackageseqno="";	
		//System.out.println("strpackageseqno in AdhocDisc.jsp:"+strpackageseqno);
		String package_enabled_yn = request.getParameter("package_enabled_yn");	
		if(package_enabled_yn==null) package_enabled_yn="";	
		String pkg_codes_for_disc = request.getParameter("pkg_codes_for_disc");	
		if(pkg_codes_for_disc==null) pkg_codes_for_disc="";
		//System.out.println("v in AdhocDisc.jsp:"+package_enabled_yn);
		/**************Added for package biling*************ends********************/
		String strChargeLogic=""; 
		String bl_items_sl_no = request.getParameter("bl_items_sl_no");
		if (bl_items_sl_no == null) bl_items_sl_no = "";
		
		

%>
	<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<STYLE TYPE="text/CSS">

/* This style is used for locking the table's heading  */

div#tbl-container {
height: 245px;
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
		function show_perc_text(i)
		{
			var disc_list = eval(document.getElementById("disc_list"+i));			

			if(disc_list.value=="P")
			{
				var pert_amt_disp=eval(document.getElementById("pert_amt_disp"+i));
				pert_amt_disp.style="display";
			}
			else
			{
				var pert_amt_disp=eval(document.getElementById("pert_amt_disp"+i));
				pert_amt_disp.style.display='none';
			}
		}

		async function callAdhocDisc(i)
		{
//alert(1);
			var adhoc_user_id="";
			var adhoc_reason_desc="";
			var trx_ind="1";
			var total_records=document.forms[0].total_records.value;

			var patient_id = document.forms[0].patient_id.value;
			var episode_type = document.forms[0].episode_type.value;
			var episode_id = document.forms[0].episode_id.value;
			var visit_id = document.forms[0].visit_id.value;
			var module_id = document.forms[0].module_id.value;
			var decimal = document.forms[0].noofdecimal.value;

			var existing_reason_code = document.forms[0].existing_reason_code.value;

			var trx_doc_ref_seq_num_count = eval("document.forms[0].trx_doc_ref_seq_num_count"+i);
			trx_doc_ref_seq_num_count = trx_doc_ref_seq_num_count.value;

			var blng_serv_code = eval("document.forms[0].blng_serv_code"+i);	
			blng_serv_code = blng_serv_code.value;

			var serv_item_code = eval("document.forms[0].serv_item_code"+i);	
			serv_item_code = serv_item_code.value;

			var serv_item_desc = eval(document.getElementById("serv_item_desc"+i));	
			serv_item_desc = encodeURIComponent(serv_item_desc.innerText);
//alert("serv_item_desc:"+serv_item_desc);
			var upd_net_charge_amt = eval(document.getElementById("net_amt"+i));	
			upd_net_charge_amt = upd_net_charge_amt.innerText;
//alert("upd_net_charge_amt:"+upd_net_charge_amt);
			var act_gross_amt = eval("document.forms[0].act_gross_amt"+i);	
			act_gross_amt = act_gross_amt.value;	
//alert("act_gross_amt:"+act_gross_amt);
			var upd_gross_charge_amt = eval(document.getElementById("gross_amt"+i));	
			upd_gross_charge_amt = upd_gross_charge_amt.innerText;	
//alert("upd_gross_charge_amt:"+upd_gross_charge_amt);
			var upd_disc_amt = eval(document.getElementById("disc_amt"+i));	
			upd_disc_amt = upd_disc_amt.innerText;	
//alert("upd_disc_amt:"+upd_disc_amt);

			var trx_doc_ref_line_no = eval("document.forms[0].trx_doc_ref_line_no"+i);	
			trx_doc_ref_line_no = trx_doc_ref_line_no.value;	
//alert("trx_doc_ref_line_no:"+trx_doc_ref_line_no);
			var trx_doc_ref = eval("document.forms[0].trx_doc_ref"+i);	
			trx_doc_ref = trx_doc_ref.value;	
//alert("trx_doc_ref:"+trx_doc_ref);
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
			
			if(eval(act_gross_amt)<0)
			{
				trx_ind="-1";
			}
			else
			{
				trx_ind="1";
			}

			var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"patient_id="+patient_id+"&"+"episode_type="+episode_type+"&"+"episode_id="+episode_id+"&"+"visit_id="+visit_id+"&"+"blng_serv_code="+blng_serv_code+"&"+"serv_item_code="+serv_item_code+"&"+"serv_item_desc="+serv_item_desc+"&"+"upd_net_charge_amt="+upd_net_charge_amt+"&"+"act_gross_amt="+act_gross_amt+"&"+"upd_gross_charge_amt="+upd_gross_charge_amt+"&"+"upd_disc_amt="+upd_disc_amt+"&"+"trx_doc_ref_line_no="+trx_doc_ref_line_no+"&"+"trx_doc_ref="+trx_doc_ref+"&"+"trx_doc_ref_seq_num_count="+trx_doc_ref_seq_num_count+"&"+"existing_reason_code="+existing_reason_code+"&trx_ind="+trx_ind+"&called_frm_frame=S&module_id="+module_id;

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

						var adhoc_user_id = eval("document.forms[0].adhoc_user_id"+i);	
						adhoc_user_id.value=arr[0];

						var disc_reason_code = eval("document.forms[0].disc_reason_code"+i);	
						disc_reason_code.value = arr[1];

						document.forms[0].existing_reason_code.value = adhoc_reason_code;

						var serv_retArr = refresh_serv_disc(i,trx_doc_ref,trx_doc_ref_line_no,existing_reason_code,patient_id,episode_type,episode_id,visit_id);

						var serv_arr_msg = new Array();
						serv_arr_msg=serv_retArr.split("|");
						
						var serv_upd_gross_charge_amt = eval(parent.frames[1].document.getElementById("gross_amt"+i));
						serv_upd_gross_charge_amt.innerText = serv_arr_msg[0];
						
						var serv_upd_disc_amt = eval(parent.frames[1].document.getElementById("disc_amt"+i));	
						serv_upd_disc_amt.innerText = serv_arr_msg[1];

						var serv_upd_net_charge_amt = eval(parent.frames[1].document.getElementById("net_amt"+i));
						serv_upd_net_charge_amt.innerText = serv_arr_msg[2];

						var serv_act_gross_amt = eval("parent.frames[1].document.forms[0].act_gross_amt"+i);	
						serv_act_gross_amt.value = serv_arr_msg[3];

						var tot_rec_by_ser = parent.frames[1].document.forms[0].total_records.value;
						var temp_tot_gross_amt=0, temp_tot_disc_amt=0, temp_tot_net_amt=0; 

						for(var j=0;j<tot_rec_by_ser;j++)
						{
							var tot_serv_upd_gross_charge_amt = eval(parent.frames[1].document.getElementById("gross_amt"+j));
							temp_tot_gross_amt = temp_tot_gross_amt+eval(tot_serv_upd_gross_charge_amt.innerText);

							var tot_serv_upd_disc_amt = eval(parent.frames[1].document.getElementById("disc_amt"+j));	
							temp_tot_disc_amt = temp_tot_disc_amt+eval(tot_serv_upd_disc_amt.innerText);

							var tot_serv_upd_net_charge_amt = eval(parent.frames[1].document.getElementById("net_amt"+j));
							temp_tot_net_amt = temp_tot_net_amt+eval(tot_serv_upd_net_charge_amt.innerText);
						}
						temp_tot_gross_amt = temp_tot_gross_amt.toFixed(decimal);
						temp_tot_disc_amt = temp_tot_disc_amt.toFixed(decimal);
						temp_tot_net_amt = temp_tot_net_amt.toFixed(decimal);
						parent.frames[2].document.forms[0].tot_serv_gross_amt.value = temp_tot_gross_amt;
						parent.frames[2].document.forms[0].tot_serv_disc_amt.value = temp_tot_disc_amt;
						parent.frames[2].document.forms[0].tot_serv_net_amt.value = temp_tot_net_amt;

						putdeci(parent.frames[2].document.forms[0].tot_serv_gross_amt);
						putdeci(parent.frames[2].document.forms[0].tot_serv_disc_amt);
						putdeci(parent.frames[2].document.forms[0].tot_serv_net_amt);

						document.forms[0].tot_upd_gross_charge_amt.value = parent.frames[2].document.forms[0].tot_serv_gross_amt.value;
						document.forms[0].tot_upd_disc_amt.value = parent.frames[2].document.forms[0].tot_serv_disc_amt.value;
						document.forms[0].tot_upd_net_charge_amt.value = parent.frames[2].document.forms[0].tot_serv_net_amt.value;

						callByService(i);
					}
				}
			}
		}
		
		function callByService(i)
		{
			var trx_doc_ref = eval("document.forms[0].trx_doc_ref"+i);	
			trx_doc_ref = trx_doc_ref.value;	

			var trx_doc_ref_line_no = eval("document.forms[0].trx_doc_ref_line_no"+i);	
			trx_doc_ref_line_no = trx_doc_ref_line_no.value;	

			var gross_amt = eval(document.getElementById("gross_amt"+i));	
			gross_amt = gross_amt.innerText;	

			var disc_amt = eval(document.getElementById("disc_amt"+i));	
			disc_amt = disc_amt.innerText;	

			var net_amt = eval(document.getElementById("net_amt"+i));	
			net_amt = net_amt.innerText;	

			var tot_upd_gross_charge_amt = document.forms[0].tot_upd_gross_charge_amt.value;	

			var tot_upd_disc_amt = document.forms[0].tot_upd_disc_amt.value;	

			var tot_upd_net_charge_amt = document.forms[0].tot_upd_net_charge_amt.value;	
	
			var query_string =  document.forms[0].query_string.value; 
			parent.frames[2].location.href="../../eBL/jsp/BLAdhocDiscByPayer.jsp?trx_doc_ref="+trx_doc_ref+"&trx_doc_ref_line_no="+trx_doc_ref_line_no+"&selected_serv_rec="+i+"&gross_amt="+gross_amt+"&disc_amt="+disc_amt+"&net_amt="+net_amt+"&tot_upd_gross_charge_amt="+tot_upd_gross_charge_amt+"&tot_upd_disc_amt="+tot_upd_disc_amt+"&tot_upd_net_charge_amt="+tot_upd_net_charge_amt+"&"+query_string;
		}

		function call_first_serv()
		{
			
			var total_records = document.forms[0].total_records.value;
			if(total_records >0 )
			{
				var trx_doc_ref = eval("document.forms[0].trx_doc_ref"+0);	
				trx_doc_ref = trx_doc_ref.value;	

				var trx_doc_ref_line_no = eval("document.forms[0].trx_doc_ref_line_no"+0);	
				trx_doc_ref_line_no = trx_doc_ref_line_no.value;	

				var gross_amt = eval(document.getElementById("gross_amt"+0));	
				gross_amt = gross_amt.innerText;	

				var disc_amt = eval(document.getElementById("disc_amt"+0));	
				disc_amt = disc_amt.innerText;	

				var net_amt = eval(document.getElementById("net_amt"+0));	
				net_amt = net_amt.innerText;	

				var tot_upd_gross_charge_amt = document.forms[0].tot_upd_gross_charge_amt.value;	

				var tot_upd_disc_amt = document.forms[0].tot_upd_disc_amt.value;	

				var tot_upd_net_charge_amt = document.forms[0].tot_upd_net_charge_amt.value;	
				
				var query_string =  document.forms[0].query_string.value; 
				parent.frames[2].location.href="../../eBL/jsp/BLAdhocDiscByPayer.jsp?trx_doc_ref="+trx_doc_ref+"&trx_doc_ref_line_no="+trx_doc_ref_line_no+"&selected_serv_rec=0"+"&gross_amt="+gross_amt+"&disc_amt="+disc_amt+"&net_amt="+net_amt+"&tot_upd_gross_charge_amt="+tot_upd_gross_charge_amt+"&tot_upd_disc_amt="+tot_upd_disc_amt+"&tot_upd_net_charge_amt="+tot_upd_net_charge_amt+"&"+query_string;
			}
		}
</script>

<BODY onLoad="call_first_serv();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
<FORM name='AdhocDicountsbyServiceForm' id='AdhocDicountsbyServiceForm' action="" method=''>	

<div id='tbl-container'>	
	<table border='1' cellpadding='3' cellspacing='0' width='100%'>	
	<thead>
		<tr>
		
			<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td>					
			<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.SERVICE_DATE.label" bundle="${bl_labels}"/></td>		
			<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></td>		
			<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.NetAmount.label" bundle="${common_labels}"/></td>
		</tr>
	</thead>
	<tbody>
<%
StringBuffer strbuf = new StringBuffer();

//	bl_items_sl_no = "QFSTSI-659,1";
	StringTokenizer str1 = new StringTokenizer(bl_items_sl_no ,";");
	StringTokenizer str = null;
	String strbufquery="";
	String tempValue=null;

	StringBuffer stbuf = new StringBuffer();
	int flag = 0;
	int flagMain = 0;
	
	
	  while (str1.hasMoreElements())
	 {
	 
	   tempValue = 	str1.nextToken();
	    
	   if(tempValue.length()>0)
		{
		str = new StringTokenizer(tempValue,",");	
		if(str.hasMoreElements())
		 {
			if(flagMain == 1) strbuf.append(" OR ");
				strbuf.append("(SEC_KEY_MAIN = '"+str.nextToken()+"'  AND (");
				flagMain = 1;
	  	        flag = 0;	 		  
		while(str.hasMoreElements())
		 {
	 
		if(flag ==1)   strbuf.append(" OR ");       
		  strbuf.append("SEC_KEY_LINE_NO LIKE ('"+str.nextToken()+"%')");
		 flag = 1;
		 }	
		strbuf.append("))");
	 }
		}
	}
	 

	 if(bl_items_sl_no.length()==0)
		  strbufquery="SEC_KEY_MAIN='"+str_doc_no+"'";
	 else 
		 strbufquery=strbuf.toString();
		try
		{
			
			try
			{		
				pstmt = con.prepareStatement( " select nvl(charge_logic_yn,'N') from  bl_parameters where operating_facility_id = '"+str_facility_id+"'");
				ResultSet rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					strChargeLogic  =  rscurr.getString(1);		
				}		
				rscurr.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("3  1="+e.toString());
			}
			
			//Added V180125-Subha/MMS-JU-SCF-0102 try
			try {
					pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
					
					rs = pstmt.executeQuery();	
					if ( rs != null && rs.next())
					{
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
			String query="";
			int column_count = 1;
			if(strChargeLogic.equals("Y"))
				
			{	
				 strsql="Select TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,BLNG_SERV_CODE,to_char(SERVICE_DATE,'dd/mm/yyyy HH24:MI:SS'),SUM(ACT_GROSS_AMT),SUM(UPD_GROSS_CHARGE_AMT),SUM(UPD_DISC_AMT),SUM(UPD_NET_CHARGE_AMT),count(TRX_DOC_REF_SEQ_NUM),SUM(ADHOC_DISC_AMT),SERV_ITEM_CODE,DECODE('en','en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)) SERV_ITEM_DESC,PACKAGE_IND From Bl_Patient_Charges_Folio"
						 	+" where patient_id = ?"
				 			+" and episode_type = ?"
						 	+" AND ( (? IN('O','E') and episode_id = ? and visit_id   = ?)" 
				            +" OR ( ? IN('I','D') and episode_id = ?)" 
							+" OR ? = 'R')" 
							+" AND NVL (billed_flag, 'N') = 'N'";		
				
			}

			else
			{
			 strsql="Select TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,BLNG_SERV_CODE,to_char(SERVICE_DATE,'dd/mm/yyyy HH24:MI:SS'),SUM(ACT_GROSS_AMT),SUM(UPD_GROSS_CHARGE_AMT),SUM(UPD_DISC_AMT),SUM(UPD_NET_CHARGE_AMT),count(TRX_DOC_REF_SEQ_NUM),SUM(ADHOC_DISC_AMT),SERV_ITEM_CODE,DECODE('en','en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)) SERV_ITEM_DESC,PACKAGE_IND From Bl_Patient_Charges_Folio" 
			+" where episode_type = ?" 
			+" and patient_id   = ?"  
			+" and episode_id = NVL(? ,EPISODE_ID)" 
			+" and visit_id   = NVL(? ,VISIT_ID)" 
			+" and nvl(confirmed_yn,'N')='Y'" 
			+" and nvl(billed_flag,'N') != 'Y'" 
			+" and bill_doc_type_code is null" 
			+" and (nvl(package_ind,'X') = 'S' or (nvl(package_trx_ind,'X')='Y' and nvl(package_ind,'X') = 'P') )" 
			+" and nvl(trx_finalize_ind,'N')= 'Y'"  
				//+" and nvl(ins_pkg_pat_ind,'N') != 'K'" commented for package billing  added  next line
			+"  and nvl(package_trx_yn,'N') !='Y'" 
			+" and bill_doc_type_code is null" 
			+" and (nvl(trx_status,'N')<>'C'"  
			+" or ( nvl(trx_status,'N')='C'"  
			+" and ( ( REV_ADJ_TRX_IND in ('R', 'B','A')"  
		    +" and (ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM,ORIG_DOC_REF_SEQ_NUM) in" 
			+" (select trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM"  
            +" from bl_patient_charges_folio where trx_status = 'C'" 
            +" and bill_doc_type_code is not null" 
           // +" and operating_facility_id = '"+str_facility_id+"'" //Commented by MuthuN against 34961
            +" and patient_id = ?"  
            +" AND ( (? IN('O','E') and episode_id = NVL(? ,EPISODE_ID) and visit_id   = NVL(? ,VISIT_ID) )" 
            +" OR ( ? IN('I','D') and episode_id = NVL(? ,EPISODE_ID))" 
			+" OR ? = 'R') ))" 
			+" OR ( (trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM) in" 
			+" ( select ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM ,ORIG_DOC_REF_SEQ_NUM" 
           	+" from bl_patient_charges_folio"  
            +" where trx_status = 'C' "           		
          //  +" and operating_facility_id = '"+str_facility_id+"' " //Commented by MuthuN against 34961
           	+" and patient_id = ? " 
            +" and ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID))" 
            +" OR(? IN('I','D') and episode_id = NVL(?,EPISODE_ID))" 
            +" OR ? = 'R' )" 
           	+" and bill_doc_type_code is not null" 
           	+" and ORIG_DOC_REF is not null"  
            +" )))))";
				 try{
					 query="Select count(*) cnt From Bl_Patient_Charges_Folio" 
							+" where episode_type = ?" 
							+" and patient_id   = ?"  
							+" and episode_id = NVL(? ,EPISODE_ID)" 
							+" and visit_id   = NVL(? ,VISIT_ID)" 
							+" and nvl(confirmed_yn,'N')='Y'" 
							+" and nvl(billed_flag,'N') != 'Y'" 
							+" and bill_doc_type_code is null" 
							+" and (nvl(package_ind,'X') = 'S' or (nvl(package_trx_ind,'X')='Y' and nvl(package_ind,'X') = 'P') )" 
							+" and nvl(trx_finalize_ind,'N')= 'Y'"  
								//+" and nvl(ins_pkg_pat_ind,'N') != 'K'" commented for package billing  added  next line
							//+"  and nvl(package_trx_yn,'N') !='Y'" 
							+" and bill_doc_type_code is null" 
							+" AND (SETTLEMENT_IND = 'X' "
							+" AND  'Y' in (select ALL_PAYERS_BILL_TOGETHER_YN from BL_PARAMETERS WHERE OPERATING_FACILITY_ID = ?) or  SETTLEMENT_IND <> 'X') "								
							+" and (nvl(trx_status,'N')<>'C'"  
							+" or ( nvl(trx_status,'N')='C'"  
							+" and ( ( REV_ADJ_TRX_IND in ('R', 'B','A')"  
						    +" and (ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM,ORIG_DOC_REF_SEQ_NUM) in" 
							+" (select trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM"  
				            +" from bl_patient_charges_folio where trx_status = 'C'" 
				            +" and bill_doc_type_code is not null" 
				           // +" and operating_facility_id = '"+str_facility_id+"'" //Commented by MuthuN against 34961
				            +" and patient_id = ?"  
				            +" AND ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID) )" 
				            +" OR ( ? IN('I','D') and episode_id = NVL(?,EPISODE_ID))" 
							+" OR ? = 'R') ))" 
							+" OR ( (trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM) in" 
							+" ( select ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM ,ORIG_DOC_REF_SEQ_NUM" 
				           	+" from bl_patient_charges_folio"  
				            +" where trx_status = 'C' "           		
				          //  +" and operating_facility_id = '"+str_facility_id+"' " //Commented by MuthuN against 34961
				           	+" and patient_id = ? " 
				            +" and ( (? IN('O','E') and episode_id = NVL(? ,EPISODE_ID) and visit_id   = NVL(? ,VISIT_ID))" 
				            +" OR(? IN('I','D') and episode_id = NVL(? ,EPISODE_ID))" 
				            +" OR ? = 'R' )" 
				           	+" and bill_doc_type_code is not null" 
				           	+" and ORIG_DOC_REF is not null"  
				            +" )))))";
							System.err.println("bill_serv_code :"+query);
				 	//stmt2 = con.createStatement();
					
			/* Fixed SQL Injection for Common-ICN-0222 */
				 		column_count = 1;
					 	pstmt = con.prepareStatement(query);
					 	pstmt.setString(column_count, str_episode_type);
					 	pstmt.setString(++column_count, str_patient_id);
					 	pstmt.setString(++column_count, str_episode_id);
					 	pstmt.setString(++column_count, str_visit_id);
					 	pstmt.setString(++column_count, str_facility_id);
					 	pstmt.setString(++column_count, str_patient_id);	
						pstmt.setString(++column_count, str_episode_type);
						pstmt.setString(++column_count, str_episode_id);
						pstmt.setString(++column_count, str_visit_id);
						pstmt.setString(++column_count, str_episode_type);
						pstmt.setString(++column_count, str_episode_id);
						pstmt.setString(++column_count, str_episode_type);
					 	pstmt.setString(++column_count, str_patient_id);
					 	pstmt.setString(++column_count, str_episode_type);
					 	pstmt.setString(++column_count, str_episode_id);
					 	pstmt.setString(++column_count, str_visit_id);
					 	pstmt.setString(++column_count, str_episode_type);
						pstmt.setString(++column_count, str_episode_id);
						pstmt.setString(++column_count, str_episode_type);
	
						rs2 = pstmt.executeQuery() ;
					if( rs2 != null ) 
					{
						while( rs2.next() )
						{
							cnt = rs2.getInt(1);
						}			
					}
				 }	
				catch(Exception e)
				{
					System.out.println("error in date" +e);
				}
				 finally{
					 rs2.close();
					 pstmt.close();
				 }
			}
			if(str_module_id.equals("PH") || str_module_id.equals("ST"))
			{
				strsql = strsql	+ " and (TRX_DOC_REF,TRX_DOC_REF_LINE_NUM) in (select TRX_DOC_REF,TRX_DOC_REF_LINE_NUM from bl_patient_charges_interface where "+ strbufquery+")";
			}
			strsql=strsql+" GROUP BY TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,SERV_ITEM_CODE,DECODE('en','en',serv_item_desc,NVL(SERV_ITEM_DESC_OTH_LANG,serv_item_desc)),BLNG_SERV_CODE,to_char(SERVICE_DATE,'dd/mm/yyyy HH24:MI:SS'),PACKAGE_IND";
			

			//stmt = con.createStatement();
			System.err.println("BLAdhocDISC ############### strSQL "+strsql);
			column_count = 1;
			pstmt = con.prepareStatement(strsql);	
			//pstmt.setString(column_count, locale);
			if(strChargeLogic.equals("Y"))	
			{	
				pstmt.setString(column_count, str_patient_id);	
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_visit_id);
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_episode_type);
			}else{	
				pstmt.setString(column_count, str_episode_type);
				pstmt.setString(++column_count, str_patient_id);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_visit_id);
				pstmt.setString(++column_count, str_patient_id);	
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_visit_id);
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_patient_id);	
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_visit_id);
				pstmt.setString(++column_count, str_episode_type);
				pstmt.setString(++column_count, str_episode_id);
				pstmt.setString(++column_count, str_episode_type);
				
			}
			//pstmt.setString(++column_count, locale);
			
			rs = pstmt.executeQuery();
			if( rs != null ) 
			{
				while( rs.next() )
				{  

					trx_doc_ref = rs.getString(1);
					if(trx_doc_ref == null) trx_doc_ref="";
					trx_doc_ref_line_num = rs.getString(2);
					if(trx_doc_ref_line_num == null) trx_doc_ref_line_num="";
					blng_serv_code = rs.getString(3);
					if(blng_serv_code == null) blng_serv_code="";
					blng_serv_date = rs.getString(4);
					if(blng_serv_date == null) blng_serv_date="";

					if(!locale.equals("en"))
					{
						if(!blng_serv_date.equals(""))
							blng_serv_date=com.ehis.util.DateUtils.convertDate(blng_serv_date,"DMYHMS","en",locale);
					}
					
					act_gross_amt = rs.getString(5);
					if(act_gross_amt == null) act_gross_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						act_gross_amt = cf1.formatCurrency(act_gross_amt, noofdecimal);
					} else {
						act_gross_amt = BLReportIdMapper.truncateUptoTwoDecimal(act_gross_amt, noofdecimal);
					}
					v_act_gross_amt = Double.parseDouble(act_gross_amt);

					upd_gross_charge_amt = rs.getString(6);
					if(upd_gross_charge_amt == null) upd_gross_charge_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_gross_charge_amt = cf1.formatCurrency(upd_gross_charge_amt, noofdecimal);
					} else {
						upd_gross_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_gross_charge_amt, noofdecimal);
					}
					v_upd_gross_charge_amt = Double.parseDouble(upd_gross_charge_amt);
					v_tot_upd_gross_charge_amt = v_tot_upd_gross_charge_amt+v_upd_gross_charge_amt;

					upd_disc_amt = rs.getString(7);
					if(upd_disc_amt == null) upd_disc_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_disc_amt = cf1.formatCurrency(upd_disc_amt, noofdecimal);
					}else {
						upd_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_disc_amt, noofdecimal);
					}
					v_upd_disc_amt = Double.parseDouble(upd_disc_amt);
					v_tot_upd_disc_amt = v_tot_upd_disc_amt+v_upd_disc_amt;

					upd_net_charge_amt = rs.getString(8);
					if(upd_net_charge_amt == null) upd_net_charge_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						upd_net_charge_amt = cf1.formatCurrency(upd_net_charge_amt, noofdecimal);
					} else {
						upd_net_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_net_charge_amt, noofdecimal);
					}
					v_upd_net_charge_amt = Double.parseDouble(upd_net_charge_amt);
					v_tot_upd_net_charge_amt = v_tot_upd_net_charge_amt+v_upd_net_charge_amt;

					String trx_doc_ref_seq_num_count = rs.getString(9);
//					System.err.println("trx_doc_ref_seq_num_count:"+trx_doc_ref_seq_num_count);

					adhoc_disc_amt = rs.getString(10);
					if(adhoc_disc_amt == null) adhoc_disc_amt="0";
					//Added V180125-Subha/MMS-JU-SCF-0102 if-else condition
					if(amountRoundOff) {
						adhoc_disc_amt = cf1.formatCurrency(adhoc_disc_amt, noofdecimal);
					} else {
						adhoc_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(adhoc_disc_amt, noofdecimal);
					}
					double db_adhoc_disc_amt=Double.parseDouble(adhoc_disc_amt);

					serv_item_code = rs.getString(11);
					if(serv_item_code == null) serv_item_code="";

					serv_item_desc = rs.getString(12);
					if(serv_item_desc == null) serv_item_desc="&nbsp;";
					
					package_ind =  rs.getString(13);
					if(package_ind == null) package_ind="";
					
					
//					System.err.println("trx_doc_ref @@" +trx_doc_ref);
//					System.err.println("trx_doc_ref_line_num @@" +trx_doc_ref_line_num);
//					System.err.println("blng_serv_code @@" +blng_serv_code);
//					System.err.println("blng_serv_date @@" +blng_serv_date);

//					System.err.println("serv_item_code @@" +serv_item_code);
//					System.err.println("serv_item_desc @@" +serv_item_desc);


					if(blng_serv_code==null) blng_serv_code="";
					
					
					
					
				
					

				 	try
					{
				 		if(package_ind.equals("P"))
				 			sql1= " select SHORT_DESC from bl_package_lang_vw where PACKAGE_CODE=? and LANGUAGE_ID =? ";
				 			
				 		else
							sql1= " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE=? and LANGUAGE_ID =? ";
						
						
					System.err.println(" BLAdhocDisc  service desctiption strsql sql1 "+sql1);
						/* stmt1 = con.createStatement();
						rs1 = stmt1.executeQuery(sql1);	 */
						pstmt = con.prepareStatement(sql1);
						pstmt.setString(1, blng_serv_code);
						pstmt.setString(2, locale);
						rs1 = pstmt.executeQuery();
		
						while(rs1.next())
						{
						   serv_desc  =  rs1.getString(1);	
//						   System.err.println("serv_desc :"+serv_desc);
						}	
						rs1.close();
						pstmt.close();
					}
					catch(Exception e)
					{
						System.err.println("1="+e.toString());
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
			
			
			
			<td class=<%=classval%> width='30%'><div id="billing_service<%=i%>">
					
				
				
				<%  if(package_ind.equals("P")) { %>				
				<%=serv_desc%>
				<%} else { %>				
				<a name='blng_serv_anchor<%=i%>' href="#" onClick="javascript:callByService('<%=i%>')" ><%=serv_desc%></a>
				<% } %>				
				</div></td>
				<input type="hidden" name="blng_serv_code<%=i%>" id="blng_serv_code<%=i%>"	value="<%=blng_serv_code%>" >
				<td class=<%=classval%> width='30%'><div id="serv_item_desc<%=i%>"><%=serv_item_desc%></div></td>
				<input type="hidden" name="serv_item_code<%=i%>" id="serv_item_code<%=i%>"	value="<%=serv_item_code%>" >
				<td class=<%=classval%> width='10%' ><div id="serv_date<%=i%>"><%=blng_serv_date%></div></td>
				<td class=<%=classval%> width='10%' ><div id="gross_amt<%=i%>" style='text-align:right'><%=upd_gross_charge_amt%></div></td>
<!--
				<td class=<%=classval%> width="15%"><div align='right'><a name='disc_amt<%=i%>' href="#" onClick="callByService('<%=i%>');javascript:callAdhocDisc('<%=i%>')" ><%=upd_disc_amt%></a></div></td>	
-->
				<td class=<%=classval%> width="10%">
<!--				
				<div style='text-align:right' id='disc_amt<%=i%>'><%=upd_disc_amt%></div>
-->
<%

/* Code added by Karthik to fetch billing group id for null cases - Starts */
String qry_for_blng_grp="";

if(str_blng_grp_id.equals("")){
	
	if( str_episode_type.equals("I") ||  str_episode_type.equals("D") ){
		qry_for_blng_grp="select BLNG_GRP_ID from BL_EPISODE_FIN_DTLS where OPERATING_FACILITY_ID= ? and EPISODE_ID= ? and  PATIENT_ID= ?  ";
	}	else if( str_episode_type.equals("O") ||  str_episode_type.equals("E") ){
		qry_for_blng_grp="select BLNG_GRP_ID from BL_VISIT_FIN_DTLS   where  OPERATING_FACILITY_ID= ? and EPISODE_ID= ? and visit_id= ? and  PATIENT_ID= ? ";
	}	else{ //if str_episode_type.equals("R")
		qry_for_blng_grp="select BLNG_GRP_ID from BL_PATIENT_FIN_DTLS where PATIENT_ID= ? ";
	}
	
//	System.out.println("blng grp fetch qry: "+qry_for_blng_grp);
	
	try
	{		
		pstmt=con.prepareStatement(qry_for_blng_grp);
		column_count = 1;
		if( str_episode_type.equals("I") ||  str_episode_type.equals("D") ){
			pstmt.setString(column_count,str_facility_id);	
			pstmt.setString(++column_count,str_episode_id);
			pstmt.setString(++column_count,str_patient_id);
		} else if( str_episode_type.equals("O") ||  str_episode_type.equals("E") ){
			pstmt.setString(column_count,str_facility_id);
			pstmt.setString(++column_count,str_episode_id);
			pstmt.setString(++column_count,str_visit_id);
			pstmt.setString(++column_count,str_patient_id);
		}else{			//if str_episode_type.equals("R")					
			pstmt.setString(column_count,str_patient_id);
		}
		rss = pstmt.executeQuery();
		if (rss!=null)
		{
			if (rss.next())
			{
				str_blng_grp_id = rss.getString(1);
				if(str_blng_grp_id==null) str_blng_grp_id="";
			}
		}
		if (rss != null)   rss.close();
		if (pstmt != null)   pstmt.close();
	}
	catch(Exception e)
	{
		System.out.println("error while fetching blng_grp_id" +e);
	}
	
}


/*Code added by Karthik to disable link when max discount percentage or max discount amount is null - Starts*/
	String currdate="";
	String str_serv_max_disc_per="";
	String str_serv_max_disc_amt = "";
	String settlement_ind="";
	
			try
			{		
				String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
				pstmt=con.prepareStatement(query_date);
				rss = pstmt.executeQuery();
				if (rss!=null)
				{
					if (rss.next())
					{
						currdate = rss.getString(1);
					}
				}
				if (rss != null)   rss.close();
				if (pstmt != null)   pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("error in date" +e);
			}
			try	{
				//	System.out.println(" $$$$$ "+str_facility_id+"~"+blng_serv_code+"~"+strloggeduser+"~"+currdate+"~"+serv_item_code);
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
					
					if(call!=null)
					call.close();	

				}
			catch(Exception e)
			{
				System.out.println("error in date" +e);
			}

			try
			{		
				String query_slmt_ind="select SETTLEMENT_IND from bl_blng_grp where blng_grp_id= ? ";
				pstmt=con.prepareStatement(query_slmt_ind);
				pstmt.setString(1, str_blng_grp_id);
				rss = pstmt.executeQuery();
				if (rss!=null)
				{
					if (rss.next())
					{
						settlement_ind = rss.getString(1);
					}
				}
				if (rss != null)   rss.close();
				if (pstmt != null)   pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("error in date" +e);
			}
			
/*			System.out.println("$$$$$ in str_serv_max_disc_per:"+str_serv_max_disc_per);
			System.out.println("$$$$$ in str_serv_max_disc_amt:"+str_serv_max_disc_amt);
			System.out.println("$$$$$ in blng_grp_id:"+str_blng_grp_id);			
			System.out.println("$$$$$ in settlement_ind:"+settlement_ind);
			System.out.println("$$$$$ in v_upd_gross_charge_amt!=0 :"+v_upd_gross_charge_amt);
			System.out.println("$$$$$ in db_adhoc_disc_amt :"+db_adhoc_disc_amt);
			System.out.println("$$$$$ in v_upd_disc_amt :"+v_upd_disc_amt);
			*/

/*Code added by Karthik to disable link when max discount percentage or max discount amount is null - Ends*/

			if(db_adhoc_disc_amt == v_upd_disc_amt && v_upd_gross_charge_amt != 0 && (!str_serv_max_disc_per.equals("") || !str_serv_max_disc_amt.equals("")) && (settlement_ind.equalsIgnoreCase("C") ||settlement_ind.equalsIgnoreCase("X")) )
			{
%>

				<a href="#" onClick="callAdhocDisc('<%=i%>')" ><div id='disc_amt<%=i%>' align='right'><%=upd_disc_amt%></div></a>
<!--
				<div id='disc_amt<%=i%>' align='right'><%=upd_disc_amt%></div>
-->
<%
			}
			else
			{
%>
				<div id='disc_amt<%=i%>' align='right'><%=upd_disc_amt%></div>
<%
			}
%>
				
				</td>	

				<td class=<%=classval%> width='10%'><div style='text-align:right' id="net_amt<%=i%>"><%=upd_net_charge_amt%></div></td>

				<input type="hidden" name="trx_doc_ref_line_no<%=i%>" id="trx_doc_ref_line_no<%=i%>"	value="<%=trx_doc_ref_line_num%>" >
				<input type="hidden" name="trx_doc_ref<%=i%>" id="trx_doc_ref<%=i%>"	value="<%=trx_doc_ref%>" >
				<input type="hidden" name="act_gross_amt<%=i%>" id="act_gross_amt<%=i%>"	value="<%=act_gross_amt%>" >
				
				<input type="hidden" name="disc_reason_code<%=i%>" id="disc_reason_code<%=i%>"	value="" >
				<input type="hidden" name="adhoc_user_id<%=i%>" id="adhoc_user_id<%=i%>"	value="<%=strloggeduser%>" >
				<input type="hidden" name="trx_doc_ref_seq_num_count<%=i%>" id="trx_doc_ref_seq_num_count<%=i%>"	value="<%=trx_doc_ref_seq_num_count%>" >
				
			</tr>
<%			
//					System.err.println("bill_serv_code :"+blng_serv_code);
//					System.err.println("blng_grp_id :"+blng_grp_id);
//					System.err.println("policy_type_code :"+policy_type_code);
//					System.err.println("upd_disc_amt :"+upd_disc_amt);
//					System.err.println("act_gross_amt :"+act_gross_amt);	
					i++;
				}//while		
			}//rs 
		}
		catch(Exception e)
		{
			System.err.println("Exception in main qry :"+e);
		}
		finally{	
			if(pstmt != null) pstmt.close();
			if(rs!=null) rs.close();
		}
%> 

	</tbody>
	</table>
	<input type="hidden" name="total_records" id="total_records"	value="<%=i%>" >
	<input type="hidden" name="noofdecimal" id="noofdecimal"	value="<%=noofdecimal%>" >
	<input type="hidden" name="checked_services" id="checked_services" value="">
	<input type="hidden" name="patient_id" id="patient_id"	value="<%=str_patient_id%>" >
	<input type="hidden" name="episode_type" id="episode_type"	value="<%=str_episode_type%>" >
	<input type="hidden" name="episode_id" id="episode_id"	value="<%=str_episode_id%>" >
	<input type="hidden" name="visit_id" id="visit_id"	value="<%=str_visit_id%>" >
	<input type="hidden" name="encounter_id" id="encounter_id"	value="<%=str_encounter_id%>" >
	<input type="hidden" name="function_id" id="function_id"	value="<%=str_function_id%>" >
	<input type="hidden" name="module_id" id="module_id"	value="<%=str_module_id%>" >
	<input type="hidden" name="clinic_code" id="clinic_code"	value="<%=str_clinic_code%>" >
	<input type="hidden" name="visit_type_code" id="visit_type_code"	value="<%=str_visit_type_code%>" >
	<input type="hidden" name="blnggrp" id="blnggrp"	value="<%=str_blng_grp_id%>" >
	<input type="hidden" name="existing_reason_code" id="existing_reason_code" value="<%=existing_reason_code%>">
	<input type="hidden" name="query_string" id="query_string"	value="<%=query_string%>" >
	<input type="hidden" name="called_frm" id="called_frm"  value="<%=called_frm%>">	
	<input type="hidden" name="called_butt" id="called_butt"  value="">
	<input type="hidden" name="doc_no" id="doc_no"  value="<%=str_doc_no%>">
	<input type="hidden" name="store_code" id="store_code"  value="<%=str_store_code%>">
	<input type= 'hidden' name="slmt_reqd_yn" id="slmt_reqd_yn"  value='<%=p_slmt_reqd_yn%>'>
	<input type="hidden" name="user_id" id="user_id"  value="<%=strloggeduser%>">
	<input type="hidden" name="ws_no" id="ws_no"  value="<%=strclientip%>">
	<input type="hidden" name="machine_id" id="machine_id"  value="<%=strclientip%>">	

	<input type="hidden" name="tot_upd_gross_charge_amt" id="tot_upd_gross_charge_amt"  value="<%=v_tot_upd_gross_charge_amt%>">	
	<input type="hidden" name="tot_upd_disc_amt" id="tot_upd_disc_amt"  value="<%=v_tot_upd_disc_amt%>">	
	<input type="hidden" name="tot_upd_net_charge_amt" id="tot_upd_net_charge_amt"  value="<%=v_tot_upd_net_charge_amt%>">	

	<input type="hidden" name="allow_chkout_with_bill_stmt_yn" id="allow_chkout_with_bill_stmt_yn"  value="<%=allow_chkout_with_bill_stmt_yn%>">	
<!-- added for ghl-crf-1.2-->
	<input type="hidden" name="called_for_reg_chg" id="called_for_reg_chg"  value="<%=called_for_reg_chg%>">	
<!--end-->
	<input type="hidden" name="strpackageseqno" id="strpackageseqno"  value="<%=strpackageseqno%>">	
	<input type="hidden" name="package_enabled_yn" id="package_enabled_yn"  value="<%=package_enabled_yn%>">	
	<input type="hidden" name="pkg_codes_for_disc" id="pkg_codes_for_disc"  value="<%=pkg_codes_for_disc%>">
</form>
</BODY>

<%
	System.out.println("strChargeLogic-->"+strChargeLogic+"i-->"+i+"cnt-->"+cnt);
if(strChargeLogic.equals("N")&& i==0 && cnt >0)
		{
		if(("Y").equals(pkgDepAdjAppl)){
%>
<script>
//Commented by Gayathri for AMRI-SCF-0444
	window.returnValue=' | |N';
	window.close();
	//parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=' | |N';
	//parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
</script>
<%
		}
		}
		else{
			if(i==0 ){
				%>
				<script>
	window.returnValue=' | |N';
	window.close();
	//parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=' | |N';
	//parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();

</script>
<%
			}
		}
%>
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

