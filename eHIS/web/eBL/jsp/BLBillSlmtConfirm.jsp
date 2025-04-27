<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           	    Developer Name
-----------------------------------------------------------------------------------------------
1            V210113             8157          NMC-JD-CRF-0072               Shikha Seth
2            V210211             8157          NMC-JD-CRF-0072               Shikha Seth
3            V210224             8157          NMC-JD-CRF-0072               Shikha Seth
4	     	 					 15771	       NMC-JD-SCF-0164		     	 Sethuraman D
5				 				 15858	       MOHE-CRF-0076		     	 Sethuraman D
6            V231128  			 51666 		   GHL-CRF-0642-US004			 Namrata Charate
 -->
<%@ page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*,eCommon.Common.CommonBean, java.net.*, eXH.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eBL.BLReportIdMapper"%>

<%
//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
	String strbilldoctypecode = request.getParameter("billdoctypecode");
	String strbilldocnum = request.getParameter("billdocnum");	
	String strbillpayableamt = request.getParameter("billpayableamt");	
	String strfacilityid = request.getParameter("facilityid");	
	String strpatientid  = request.getParameter("patientid");	
 	String strepisodetype = request.getParameter("episodetype");	
	String strepisodeid = request.getParameter("episodeid");
	String strvisitid = request.getParameter("visitid");		
	String strslmtpayername = request.getParameter("slmtpayername");	
	String struser = request.getParameter("loggeduser");	
	String strslmtidno = request.getParameter("slmtidno");
	String action_ind=request.getParameter("action");	
	String disabled_field="";
	String rec_ref=request.getParameter("rec_ref");
	//Added below Parm by Rajesh V - KDAH-CRF-339.2
	String totalCashAmtColl = request.getParameter("Cash_checklimit");
	String restrictEligibility = request.getParameter("restrictEligibility");
	
	//V210211
	Connection con = null;
	con	=	ConnectionManager.getConnection(request); 
	boolean siteCouponInSlmt = false;
	try {
		 siteCouponInSlmt = CommonBean.isSiteSpecific(con, "BL", "TO_ENABLE_COUPON_IN_SETTLEMENT");	
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		ConnectionManager.returnConnection(con, request);
	}
	//V210211
	
	if(totalCashAmtColl == null || "null".equals(totalCashAmtColl)){
		totalCashAmtColl = "0";
	}
	
	if(action_ind==null || action_ind.equals("")) action_ind="";
	

	if(action_ind.equals("modify")||action_ind.equals("add"))
	{
		disabled_field="disabled";
	}
	else{
		disabled_field="";
	}
	
	if ( strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
	{strbilldoctypecode ="";}

	if ( strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
	{strbilldocnum = "";}

	if ( strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
	{strbillpayableamt = "";}

	if ( strfacilityid == null || strfacilityid.equalsIgnoreCase("null")) 
	{strfacilityid = "";}

	if ( strpatientid == null || strpatientid.equalsIgnoreCase("null")) 
	{strpatientid = "";}

	if ( strepisodetype == null || strepisodetype.equalsIgnoreCase("null")) 
	{strepisodetype = "";}

	if ( strepisodeid == null || strepisodeid.equalsIgnoreCase("null")) 
	{strepisodeid = "";}

	if ( strvisitid == null || strvisitid.equalsIgnoreCase("null")) strvisitid = "";

	if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null"))  
	{strslmtpayername = "";}

	if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")) strslmtidno = "";

	if ( struser == null || struser.equalsIgnoreCase("null")) struser = "";
	
	%>

		<html>
  		<head>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>			<script language='javascript' ></script>		
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>		
			
		function billslmtprocess()
		{				
			var v_slmttype		= "";
			var v_cashslmtflag	= "";
			var v_instref		= "";
			var v_instdate		= "";
			var v_instremark	= "";
			var v_slmtidno		= "";
			var v_slmtpayername = "";
			var v_billslmtamt = "";	
			var v_slmtapprrefno = "";

			var v_rectype ="";
			var v_ext_acc_facility_id = "";
			var v_ext_acc_code = "";
			var v_ext_acc_dept = "";
			var v_online_approval = "";
			var v_batch_no = "";
			var v_sale_draft_no = "";
			var v_ext_acc_interface_yn = "";
			
			//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
			var v_cc_term_id_num = "";
			var v_cc_instbranch = "";
			var v_cc_trx_date_time = "";

			v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;					
			v_slmttype = parent.frames[0].document.forms[0].slmttype.value;		
			
			//Added by Sethu for GHL-CRF-0415 on 21/04/2017
			var slmtTypeCode = v_slmttype.substring(0,2);
			var v_application_id = "";
			v_application_id = parent.frames[1].document.forms[0].application_id.value

		
			parent.frames[0].document.forms[0].pagecloseind.value = "0";
				
			if (v_billslmtamt == null ) v_billslmtamt ="";
			if (v_slmttype == null ) v_slmttype = "";

			if (v_slmttype == "" && parseFloat(v_billslmtamt) > 0)
//				{	alert( "Settlement Type cannot be blank");
			{	alert(getMessage("BL9107","BL"));
				parent.frames[0].document.forms[0].slmttype.focus();
				return false;
			}

			if (v_slmttype != "" && parseFloat(v_billslmtamt) == 0)
//				{	alert( "Settlement Type cannot be selected for Zero amount");
			{	alert(getMessage("BL9522","BL"));
				parent.frames[0].document.forms[0].slmttype.focus();
				return false;
			}
			

			if (v_slmttype != "" &&  v_billslmtamt =="" )
//				{	alert( "Settlement Amount cannot be blank");
			{	alert(getMessage("BL9523","BL"));
				parent.frames[0].document.forms[0].billslmtamt.focus();
				return false;
			}

			var str = parent.frames[0].document.forms[0].slmttype.value;					
			v_cashslmtflag =str.charAt(2);		
			
			if (v_slmttype != "")
			{
				v_ext_acc_interface_yn = parent.frames[1].document.forms[0].ext_acc_interface_yn.value;
									
			}
				
			if (v_ext_acc_interface_yn == "Y" && v_slmttype != "")
			{					
				v_rectype = parent.frames[1].document.forms[0].rectype.value;
				v_ext_acc_facility_id = parent.frames[1].document.forms[0].ext_acc_fac_id.value;
				v_ext_acc_code = parent.frames[1].document.forms[0].acccode.value;
				v_ext_acc_dept = parent.frames[1].document.forms[0].dept.value;
				
				if ( v_rectype == "")
				{
//					alert("Receipt Type cannot be blank");
					alert(getMessage("BL9524","BL"));
					parent.frames[1].document.forms[0].rectype.focus();
					return false;
				}

				if ( v_ext_acc_code == "")
				{
//					alert("Account code cannot be blank");
					alert(getMessage("BL9525","BL"));
					parent.frames[1].document.forms[0].acccode.focus();
					return false;
				}

				if ( v_ext_acc_dept == "")
				{
//					alert("Accounting department cannot be blank");
					alert(getMessage("BL9526","BL"));
					parent.frames[1].document.forms[0].dept.focus();
					return false;
				}
			}				
			if (v_cashslmtflag != "Y" && v_slmttype != "")
			{
				if (v_application_id != "PAYTM")
				{ //  Condition added by Sethu for GHL-CRF-0415 on 21/04/2017
					v_instref = parent.frames[1].document.forms[0].instref.value;
					v_instdate = parent.frames[1].document.forms[0].instdate.value;

					//v_instremark = parent.frames[1].document.forms[0].instremark.value;

					v_instremark = parent.frames[1].document.forms[0].instremarkcode.value;		

					v_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;
					v_slmtpayername = parent.frames[1].document.forms[0].payername.value;
					v_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value;
					if (parent.frames[1].document.forms[0].onlineapproval.checked)
						v_online_approval = 'Y';
					else
						v_online_approval = 'N';

					v_batch_no = parent.frames[1].document.forms[0].batchno.value;
					v_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value;
					
					//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
					v_cc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;
					v_cc_trx_date_time = parent.frames[1].document.forms[0].cc_trx_date_time.value;
					v_cc_instbranch = parent.frames[1].document.forms[0].instbranch.value;
				}
				else if (applicationID == "PAYTM")
				{ // Added by Sethu for GHL-CRF-0415 on 21/04/2017
				
					v_instref = parent.frames[1].document.forms[0].instref.value; //PayTM User Code.
					v_batch_no = parent.frames[1].document.forms[0].batchno.value; //PayTM Promo Code.
					v_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value; //PayTM Transaction Receipt Number.
					v_instdate = parent.frames[1].document.forms[0].instdate.value; //PayTM Transaction date and time.
					v_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value; //PayTM Merchant Order ID.
				}

				if ( v_instref == "")
				{
//							alert("Instrument Ref cannot be blank");
					if (v_application_id != "PAYTM"){ // Added by Sethu for GHL-CRF-0415 on 21/04/2017
						alert(getMessage("BL6251","BL"));
						parent.frames[1].document.forms[0].instref.focus();
						return false;
					}
					/*
					else // Added by Sethu for GHL-CRF-0415 on 21/04/2017
					{
						alert(getMessage("BL9500","BL"));
						parent.frames[1].document.forms[0].instref.focus();
						return false;
					}
					*/

				}

				if ( v_instdate == "")
				{
//					alert("Instrument Date cannot be blank");
					alert(getMessage("BL6250","BL"));
					parent.frames[1].document.forms[0].instdate.focus();
					return false;
				}

				if (v_instremark == "" && (v_cashslmtflag == "A" || v_cashslmtflag == "B"))
				{
//					alert("Bank/Card Co. Name cannot be blank");
					alert(getMessage("BL9529","BL"));
					parent.frames[1].document.forms[0].instremark.focus();
					return false;
				}

				if (v_cashslmtflag == "A" && v_online_approval == "Y" && v_batch_no == "")
				{
//					alert("Batch No cannot be blank");
					alert(getMessage("BL9530","BL"));
					parent.frames[1].document.forms[0].batchno.focus();
					return false;
				}						

				if (v_slmtapprrefno == "" && v_cashslmtflag == "A")
				{
//					alert("Approval code cannot be blank");
					alert(getMessage("BL9531","BL"));
					parent.frames[1].document.forms[0].apprrefno.focus();
					return false;						
				}				
					
				
				if (v_cashslmtflag == "B" && v_slmtpayername == "")
				{
//					alert("Payer's name cannot be blank");
					alert(getMessage("BL9532","BL"));
					parent.frames[1].document.forms[0].payername.focus();
					return false;
				}

				if (v_cashslmtflag == "B" && v_slmtpayername != "" && v_slmtidno == "")
				{
//					alert("Payer's Ref Id cannot be blank");
					alert(getMessage("BL9533","BL"));
					parent.frames[1].document.forms[0].recrefidno.focus();
					return false;
				}	
				
				if (v_slmtapprrefno == "" && v_application_id == "PAYTM") // Added by Sethu for GHL-CRF-0415 on 21/04/2017
				{
//					alert("PayTM Transaction ID cannot be blank");
					alert(getMessage("BL9501","BL"));
					parent.frames[1].document.forms[0].recrefidno.focus();
					return false;
				}					


				

				if (v_cashslmtflag == "A" && v_online_approval == "N" && v_batch_no != "")
				{
//					alert("Online Approved credit card transaction can only have batch number");
					alert(getMessage("BL9534","BL"));
					parent.frames[1].document.forms[0].batchno.focus();
					return false;
				}						

				if (v_cashslmtflag == "A" && v_sale_draft_no == "")
				{
//					alert("Sale Draft No cannot be blank");
					alert(getMessage("BL9535","BL"));
					parent.frames[1].document.forms[0].saledraftno.focus();
					return false;
				}
				/*
				if (v_sale_draft_no == "" && slmtTypeCode == "PT") //Added by Sethu for GHL-CRF-0415 on 21/04/2017
				{
					alert(getMessage("BL9502","BL"));
					parent.frames[1].document.forms[0].saledraftno.focus();
					return false;
				}
				*/
			}
			else if (v_cashslmtflag == "Y" && v_slmttype != "")
			{
				v_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;
				v_slmtpayername = parent.frames[1].document.forms[0].payername.value;
			}			
				
			var genmesg = getMessage("BL9537","BL");

												
			parent.frames[2].location.href =  '../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&slmtamt='+v_billslmtamt+'&slmttypecode='+v_slmttype.substring(0,2)+'&slmtdocref='+v_instref+'&slmtdocrefdate='+v_instdate+'&slmtdocrefremark='+v_instremark+'&slmtidno='+v_slmtidno+'&slmtpayername='+v_slmtpayername+'&slmtapprrefno='+v_slmtapprrefno+'&onlineapproval='+v_online_approval+'&batchno='+v_batch_no+'&saledraftno='+v_sale_draft_no+'&rectype='+v_rectype+'&extaccfacid='+v_ext_acc_facility_id+'&extacccode='+v_ext_acc_code+'&extaccdept='+v_ext_acc_dept+'&genmesg='+genmesg; 					
		}
		
	function acceptbillslmt()
	{
		var v_instref = "";
		var v_instdate = "";
		var v_instremark = "";
		var v_slmtidno = "";
		var v_slmtpayername = "";
		var v_slmtapprrefno = "";
		var v_online_approval = "";
		var v_batch_no = "";
		var v_sale_draft_no = "";
		
		//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
		var v_cc_term_id_num = "";
		var v_cc_instbranch = "";
		var v_cc_trx_date_time = "";
		
		//V210224 start
		var siteCouponInSlmt = document.forms[0].siteCouponInSlmt.value;
		var str = parent.frames[0].document.forms[0].slmttype.value;				
		var v_cashslmtflag =str.charAt(2);		
		var v_couponflag =str.charAt(3);
		//V210224 end
		var slmt_type_main_frame = parent.frames[0].document.forms[0].slmttype.value;
		
		if(slmt_type_main_frame == "")
		{					
			alert(getMessage("BL9521","BL"));
			parent.frames[0].document.forms[0].slmttype.focus();
			return false;
		}

		 var credit_card_num_yn = parent.frames[1].document.forms[0].credit_card_num_yn.value;

		 var credit_card_co_yn = parent.frames[1].document.forms[0].credit_card_co_yn.value;

		 var approval_code_yn = parent.frames[1].document.forms[0].approval_code_yn.value;

		 var credit_card_check_yn = parent.frames[1].document.forms[0].credit_card_check_yn.value;

		var credit_card_machine_int_yn = parent.frames[1].document.forms[0].str_credit_card_machine_int_yn.value;
		if(credit_card_machine_int_yn == "") credit_card_machine_int_yn=" ";
		/* <!--Added by Monika for NMC-JD-CRF-0199 -->	 */
		var terminal_id_reqd_yn = parent.frames[1].document.forms[0].terminal_id_reqd_yn.value;
		var cc_terminal_id_enable = parent.frames[1].document.forms[0].cc_terminal_id_enable.value; 
		
		var v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;

		var v_slmttype = parent.frames[0].document.forms[0].slmttype.value;

		
		//Added by Sethu for GHL-CRF-0415 on 21/04/2017
		var slmtTypeCode = v_slmttype.substring(0,2);
		var v_application_id = parent.frames[1].document.forms[0].application_id.value;
		
		parent.frames[0].document.forms[0].pagecloseind.value = "0";				
		if (v_billslmtamt == null ) v_billslmtamt ="";
		if (v_slmttype == null ) v_slmttype = "";
		var cashier_cheque_yn=parent.frames[1].document.forms[0].cashier_cheque_yn.value;

		var sale_draft_reqd_yn = parent.frames[1].document.forms[0].sale_draft_reqd_yn.value;
		var payer_name_reqd_yn = parent.frames[1].document.forms[0].payer_name_reqd_yn.value;
		var payer_ref_reqd_yn = parent.frames[1].document.forms[0].payer_ref_reqd_yn.value;
		//Added against  CRF AAKH-CRF-0014  37864  15/07/2013
		var batch_no_reqd_yn = parent.frames[1].document.forms[0].batch_no_reqd_yn.value;
		var slmt_doc_ref_date_reqd_yn = parent.frames[1].document.forms[0].slmt_doc_ref_date_reqd_yn.value;
		
		//if(v_billslmtamt=="") //V210224
		if(v_billslmtamt=="" && !(siteCouponInSlmt =='true' && v_cashslmtflag == 'D' && v_couponflag=='Y')) //V210224
		{
			alert(getMessage("BL9776","BL"));
			parent.frames[0].document.forms[0].billslmtamt.focus();
			return false;
		}
		//V210224 start
		if(v_billslmtamt=="" && (siteCouponInSlmt =='true' && v_cashslmtflag == 'D' && v_couponflag=='Y'))
		{
			alert(getMessage('BL0934','BLEXT')); 			
			return false;
		}
		//V210224 end

		if (v_slmttype == "" && parseFloat(v_billslmtamt) > 0)
		{	
			alert(getMessage("BL9107","BL"));
			parent.frames[0].document.forms[0].slmttype.focus();
			return false;
		}
		if (v_slmttype != "" && parseFloat(v_billslmtamt) == 0)
		{	
			alert(getMessage("BL9522","BL"));
			parent.frames[0].document.forms[0].slmttype.focus();
			return false;
		}		

		if (v_slmttype != "" &&  v_billslmtamt =="" )
		{	
			alert(getMessage("BL9523","BL"));
			parent.frames[0].document.forms[0].billslmtamt.focus();
			return false;
		}
		// moved up can remove here
		//var str = parent.frames[0].document.forms[0].slmttype.value;				
		//var v_cashslmtflag =str.charAt(2);		
		//var v_couponflag =str.charAt(3);	 //V210113
		// moved up can remove here
		if (v_cashslmtflag != "Y" && v_slmttype != "" && v_couponflag=="") //V210113
		{
			if (v_application_id != "PAYTM" && v_application_id != "PAYSKY")
			{ //  Condition added by Sethu for GHL-CRF-0415 on 21/04/2017 and for MOHE-CRF-0076 on 08/08/2021
				v_instref = parent.frames[1].document.forms[0].instref.value;
				v_instdate = parent.frames[1].document.forms[0].instdate.value;
				v_instremark = parent.frames[1].document.forms[0].instremarkcode.value;		
				v_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;
				v_slmtpayername = parent.frames[1].document.forms[0].payername.value;
				v_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value;

				if (parent.frames[1].document.forms[0].onlineapproval.checked)
					v_online_approval = 'Y';
				else
					v_online_approval = 'N';

				v_batch_no = parent.frames[1].document.forms[0].batchno.value;
				v_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value;

				//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
				v_cc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;
				v_cc_trx_date_time = parent.frames[1].document.forms[0].cc_trx_date_time.value;
				v_cc_instbranch = parent.frames[1].document.forms[0].instbranch.value;
			}
			else if (v_application_id == "PAYTM")
			{
				// Added by Sethu for GHL-CRF-0415 on 21/04/2017				
				v_instref = parent.frames[1].document.forms[0].instref.value; //PayTM User Code.
				v_batch_no = parent.frames[1].document.forms[0].batchno.value; //PayTM Promo Code.
				v_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value; //PayTM Transaction Receipt Number.
				v_instdate = parent.frames[1].document.forms[0].instdate.value; //PayTM Transaction date and time.
				v_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value; //PayTM Merchant Order ID.
			}			
			else if (v_application_id == "PAYSKY")
			{
				// Added by Sethu for MOHE-CRF-0076 on 07/08/2021				
				v_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value; //PAYSKY Transaction Receipt Number.
				v_instdate = parent.frames[1].document.forms[0].instdate.value; //PAYSKY Transaction date and time.
				v_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value; //PAYSKY Merchant Order ID.
			}	

			if ( v_instref == "" && credit_card_num_yn == "Y")
			{
				alert(getMessage("BL6251","BL"));
				parent.frames[1].document.forms[0].instref.focus();
				return false;
			}
			else if (v_instref == "" && v_application_id == "PAYTM") // Added by Sethu for GHL-CRF-0415 on 21/04/2017
			{
				alert(getMessage("BL9500","BL"));
				parent.frames[1].document.forms[0].instref.focus();
				return false;
			}
			
			//alert("slmt_doc_ref_date_reqd_yn  "+slmt_doc_ref_date_reqd_yn);
			
			if ( v_instdate == "" && slmt_doc_ref_date_reqd_yn== "Y")
			{		
				alert(getMessage("BL6250","BL"));
				parent.frames[1].document.forms[0].instdate.focus();
				return false;
			}
			else if (v_instdate == "" && v_application_id == "PAYTM") // Added by Sethu for GHL-CRF-0415 on 21/04/2017
			{
				alert(getMessage("BL6250","BL"));
				parent.frames[1].document.forms[0].instdate.focus();
				return false;
			}
			else if (v_instdate == "" && v_application_id == "PAYSKY") // Added by Sethu for MOHE-CRF-0076 on 07/08/2021
			{ 
				alert(getMessage("BL6250","BL"));
				parent.frames[1].document.forms[0].instdate.focus();
				return false;
			}

		//						if (v_instremark == "" && (v_cashslmtflag == "A" || v_cashslmtflag == "B"))
			if (v_instremark == "" && (v_cashslmtflag != "Y") && credit_card_co_yn == "Y")
			{
			alert(getMessage("BL9529","BL"));
			parent.frames[1].document.forms[0].instremark.focus();
			return false;
			}

//			alert("batch_no_reqd_yn  "+batch_no_reqd_yn);
		
			if (v_cashslmtflag == "A" && v_online_approval == "Y" && v_batch_no == ""&& batch_no_reqd_yn=="Y")
			{
			alert(getMessage("BL9530","BL"));
			parent.frames[1].document.forms[0].batchno.focus();
			return false;
			}						

//			if (v_slmtapprrefno == "" && v_cashslmtflag == "A" && payer_ref_reqd_yn=="Y")
//  Commented  against incident  43719 on 25/09/2013

			if (v_slmtapprrefno == "" && v_cashslmtflag == "A" && approval_code_yn == "Y")
			{
			alert(getMessage("BL9531","BL"));
			parent.frames[1].document.forms[0].apprrefno.focus();
			return false;						
			}				


			if (v_cashslmtflag == "B" && v_slmtpayername == "" && payer_name_reqd_yn=="Y")
			{
			alert(getMessage("BL9532","BL"));
			parent.frames[1].document.forms[0].payername.focus();
			return false;
			}

			if (v_cashslmtflag == "A" && v_sale_draft_no == "" && sale_draft_reqd_yn=="Y")
			{
			alert(getMessage("BL9535","BL"));
			parent.frames[1].document.forms[0].saledraftno.focus();
			return false;
			}		

			if(payer_name_reqd_yn=="Y" && payer_ref_reqd_yn=="Y")
			{
				if ((v_cashslmtflag == "B" || v_cashslmtflag == "A") && v_slmtpayername != "" && v_slmtidno == "")
				{
					alert(getMessage("BL9533","BL"));
					parent.frames[1].document.forms[0].recrefidno.focus();
					return false;
				}							
			}	
			if (v_cashslmtflag == "A" && v_online_approval == "N" && v_batch_no != "")
			{
				alert(getMessage("BL9534","BL"));
				parent.frames[1].document.forms[0].batchno.focus();
				return false;
			}						
			/*if(sale_draft_reqd_yn=="Y" && v_sale_draft_no=="")
			{
			alert(getMessage("BL9535","BL"));
			parent.frames[1].document.forms[0].saledraftno.focus();
			return false;
			}*/
			//Commented the above If against 55178
			if(payer_name_reqd_yn=="Y" && v_slmtpayername=="")
			{
				alert(getMessage("BL9532","BL"));
				parent.frames[1].document.forms[0].payername.focus();
				return false;
			}
			if(payer_ref_reqd_yn=="Y" && v_slmtidno=="")
			{
				alert(getMessage("BL9533","BL"));
				parent.frames[1].document.forms[0].recrefidno.focus();
				return false;
			}
			/* Added By Monika against NMC-JD-CRF-0199  */
			if(v_cashslmtflag =="A" && cc_terminal_id_enable == "true"){
				v_cc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;
				if(terminal_id_reqd_yn == "Y" && v_cc_term_id_num == "")
				{
					var err = getMessage("CAN_NOT_BE_BLANK","common");
					err= err.replace('$',getLabel('eBL.TID_NO.label','BL')); 
					alert(err);
					parent.frames[1].document.forms[0].cc_term_id_num.focus();
					return false;
				}
			}
		}
		else if (v_cashslmtflag == "Y" && v_slmttype != "")
		{
			v_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;
			v_slmtpayername = parent.frames[1].document.forms[0].payername.value;
		}			
		
		var v_billslmtamt = "";			
		var v_billpayableamt = "";

		v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;				
		v_billpayableamt = parent.frames[0].document.forms[0].billpayableamt.value;			

		if ( parseFloat(Math.abs(v_billslmtamt)) > parseFloat(Math.abs(v_billpayableamt)))
		{
			
			//					alert("Allocated amount is greater than outstanding amount");
			alert(getMessage("BL7085","BL"));
			parent.frames[0].document.forms[0].billslmtamt.select();
			//parent.frames[0].document.forms[0].billslmtamt.focus();
			return false;
		}
		
		var instref="";
		var instdate="";
		var instremark="";
		var instbranch="";
		var onlineapproval="";
		var batchno="";
		var apprrefno="";
		var saledraftno="";
		var cashslmtflag="";
		var instbankname="";
		var cash_given="";
		var cash_return="";
		var short_desc="";
		var instremarkcode="";
		var billdoctype="";
		var slmt_type_short_desc="";
		var billdocnum="";
		var billpayableamt="";
		var total_amt_payable="";

		//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
		var cc_term_id_num = "";
		var cc_trx_date_time = "";
		

		/*var billdoctype=parent.frames[0].document.forms[0].billdoctype.value;
		if(billdoctype=="") billdoctype=" ";

		var billdocnum=parent.frames[0].document.forms[0].billdocnum.value;
		if(billdocnum=="") billdocnum=" ";	*/

		var billpayableamt=parent.frames[0].document.forms[0].billpayableamt.value;
		if(billpayableamt=="") billpayableamt=" ";	

		var billslmtamt=parent.frames[0].document.forms[0].billslmtamt.value;
		if(billslmtamt=="") billslmtamt=" ";


		var slmttype=parent.frames[0].document.forms[0].slmttype.value;
		slmttype = slmttype.substring(0,3);
		if(slmttype=="") slmttype=" ";	

		//Added by Sethu for GHL-CRF-0415 on 21/04/2017
		var slmtTypeCode = slmttype.substring(0,2);
		var v_application_id=parent.frames[1].document.forms[0].application_id.value;
		

		var payername = "";
		var recrefidno ="";
		var ext_acc_interface_yn="";
		var ext_acc_fac_id="";

		if (v_application_id != "PAYTM" && v_application_id != "PAYSKY") { //If condition Added by Sethu for GHL-CRF-0415 on 21/04/2017 and for MOHE-CRF-0076 on 08/08/2021
			payername=parent.frames[1].document.forms[0].payername.value;			
			if(payername=="") payername=" ";
			if(credit_card_machine_int_yn!= 'Y' && !CheckChars(parent.frames[1].document.forms[0].recrefidno))			
			{ 
		
				alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
				parent.frames[1].document.forms[0].recrefidno.select();
				return false;
			}
			else
			{ 
				recrefidno=parent.frames[1].document.forms[0].recrefidno.value;
				if(recrefidno=="") recrefidno=" ";
			}
			ext_acc_interface_yn=parent.frames[1].document.forms[0].ext_acc_interface_yn.value;
			if(ext_acc_interface_yn=="") acext_acc_interface_ynccode=" ";	
			ext_acc_fac_id=parent.frames[1].document.forms[0].ext_acc_fac_id.value;
			if(ext_acc_fac_id=="") ext_acc_fac_id=" ";	

			short_desc=parent.frames[1].document.forms[0].short_desc.value;			
			if(short_desc=="") short_desc=" ";
		}		

		if(v_cashslmtflag=="D" && v_application_id != "PAYTM" && v_application_id != "PAYSKY" && v_couponflag=="") //v_application_id != "PAYTM" Added by Sethu for GHL-CRF-0415 on 21/04/2017 //v_couponflag V210113 and for MOHE-CRF-0076 on 08/08/2021
		{ 
			if(v_slmtpayername=="" && payer_name_reqd_yn=="Y")
			{
				alert(getMessage("BL9532","BL"));
				parent.frames[1].document.forms[0].payername.focus();
				return false;
			}

			if(v_slmtidno=="" && payer_ref_reqd_yn=="Y")
			{
				alert(getMessage("BL9533","BL"));
				parent.frames[1].document.forms[0].recrefidno.focus();
				return false;
			}
		}
		
		if((v_cashslmtflag=="Y" ) || (v_cashslmtflag=="D" && v_couponflag=="Y") ) //v_couponflag V210113
		{
			instref=" ";
			instdate=" ";
			instremark=" ";
			instbranch=" ";		
			onlineapproval=" ";
			batchno=" ";
			apprrefno=" ";
			saledraftno=" ";
			cashslmtflag=" ";
			instbankname=" ";
			total_amt_payable=" ";
			//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
			cc_term_id_num =  " ";
			cc_trx_date_time = " ";
			if (cashier_cheque_yn=="Y")
			{		
				instref=parent.frames[1].document.forms[0].instref.value;		
				instdate=parent.frames[1].document.forms[0].instdate.value;
				instbankname=parent.frames[1].document.forms[0].instremark.value;
				instbranch=parent.frames[1].document.forms[0].instbranch.value;
				instremarkcode = parent.frames[1].document.forms[0].instremarkcode.value;
				if(instremarkcode=="") instremarkcode=" ";

				if(instref=="" && credit_card_num_yn == "Y")
				{
					alert(getMessage("BL6251","BL"));
					parent.frames[1].document.forms[0].instref.focus();
					return false;
				}
				if(instdate=="" )
				{ 
				alert(getMessage("BL6250","BL"));
				parent.frames[1].document.forms[0].instdate.focus();
				return false;
				}

				if(instbankname=="" && credit_card_co_yn =="Y")
				{
					alert(getMessage("BL9529","BL"));
					parent.frames[1].document.forms[0].instremark.focus();
					return false;
				}

				var	v_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;
				var	v_slmtpayername = parent.frames[1].document.forms[0].payername.value;
				if(v_slmtpayername=="" && payer_name_reqd_yn=="Y")
				{
					alert(getMessage("BL9532","BL"));
					parent.frames[1].document.forms[0].payername.focus();
					return false;
				}

				if(v_slmtidno=="" && payer_ref_reqd_yn=="Y")
				{
					alert(getMessage("BL9533","BL"));
					parent.frames[1].document.forms[0].recrefidno.focus();
					return false;
				}
				//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
				cc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;
				cc_trx_date_time = parent.frames[1].document.forms[0].cc_trx_date_time.value;
			}
			cash_given=parent.frames[1].document.forms[0].cash_given.value;			
			cash_return=parent.frames[1].document.forms[0].cash_return.value;
			if(cash_given=="")
			{
				if(!(siteCouponInSlmt =='true' && v_cashslmtflag=="D" && v_couponflag=="Y")) { //V210224
					alert(getMessage("BL9615","BL"));
					parent.frames[1].document.forms[0].cash_given.focus();
					return;
				} //V210224
			}
			else if(billslmtamt<0){

				if($('#rec_ref').val()=='F')
				{
							
					if(parseFloat(cash_given)>parseFloat(billslmtamt))
					{			
						alert(getMessage("BL9618","BL"));
						parent.frames[1].document.forms[0].cash_given.select();
						return false;
					}
				}
				else
				{
						
					if(parseFloat(cash_given)>parseFloat(billslmtamt))
					{				
						alert(getMessage("BL9618","BL"));
						parent.frames[1].document.forms[0].cash_given.select();
						return false;
					}		
				}
				
				
			}
			else{	

				if($('#rec_ref').val()=='F')
				{
					if(parseFloat(cash_given)<parseFloat(billslmtamt))
					{				
						alert(getMessage("BL9618","BL"));
						parent.frames[1].document.forms[0].cash_given.select();
						return false;
					}
				}
				else
				{						
					if(parseFloat(cash_given)<parseFloat(billslmtamt)) 
					{				
						alert(getMessage("BL9618","BL"));
						parent.frames[1].document.forms[0].cash_given.select();
						return false;
					}		
				}

			}				
		}
		else if (v_application_id == "PAYTM")		// Else If confition Added 	 by Sethu for GHL-CRF-0415 on 21/04/2017
		{
			cash_given="";
			cash_return="";

			instref=parent.frames[1].document.forms[0].instref.value;	
			if(instref=="") instref=" ";	
			instdate=parent.frames[1].document.forms[0].instdate.value;
			if(instdate=="") instdate=" ";				
			saledraftno=parent.frames[1].document.forms[0].saledraftno.value;
			if(saledraftno=="") saledraftno=" ";			
			cashslmtflag = parent.frames[1].document.forms[0].cashslmtflag.value;
			if(cashslmtflag=="") cashslmtflag=" ";
			total_amt_payable=parent.frames[0].document.forms[0].total_amt_payable.value;
			if(total_amt_payable=="") total_amt_payable=" ";
			//recrefidno=parent.frames[1].document.forms[0].apprrefno.value;
			apprrefno=parent.frames[1].document.forms[0].apprrefno.value;
			
			batchno=parent.frames[1].document.forms[0].batchno.value;
			if(batchno=="") batchno= " ";

			if (instref.length > 20){
				instref = instref.substring(0,20);
			}
		}
		else if (v_application_id == "PAYSKY")		// Else If confition Added by Sethu for MOHE-CRF-0076 on 07/08/2021
		{
			cash_given="";
			cash_return="";

			instdate=parent.frames[1].document.forms[0].instdate.value;
			if(instdate=="") instdate=" ";				
			saledraftno=parent.frames[1].document.forms[0].saledraftno.value;
			if(saledraftno=="") saledraftno=" ";			
			cashslmtflag = parent.frames[1].document.forms[0].cashslmtflag.value;
			if(cashslmtflag=="") cashslmtflag=" ";
			total_amt_payable=parent.frames[0].document.forms[0].total_amt_payable.value;
			if(total_amt_payable=="") total_amt_payable=" ";
			//recrefidno=parent.frames[1].document.forms[0].apprrefno.value;
			apprrefno=parent.frames[1].document.forms[0].apprrefno.value;
		}
		else 
		{
			cash_given="";
			cash_return="";

			if(credit_card_machine_int_yn != "Y" && !CheckChars(parent.frames[1].document.forms[0].instref))
			{
				alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
				parent.frames[1].document.forms[0].instref.select();
				return false;
			}
			else
			{
				instref=parent.frames[1].document.forms[0].instref.value;	
				if(instref=="") instref=" ";	
			}
			instdate=parent.frames[1].document.forms[0].instdate.value;
			if(instdate=="") instdate=" ";	
	
			if(v_cashslmtflag=="A")
			{		
				instremark=parent.frames[1].document.forms[0].instremark.value;
				if(instremark=="") instremark=" ";		
				instbankname=" ";
			}
			else
			{
				instbankname=parent.frames[1].document.forms[0].instremark.value;	
				if(instbankname=="") instbankname=" ";	
				instremark=" ";
			}

			instbranch=parent.frames[1].document.forms[0].instbranch.value;
			if(instbranch=="") instbranch=" ";

		//	var onlineapproval=eval("parent.frames[1].document.forms[0].onlineapproval");
			if(parent.frames[1].document.forms[0].onlineapproval.checked)
			{
				onlineapproval="checked";
			}
			else
			{
				onlineapproval="";
			}


			if(credit_card_machine_int_yn != "Y" && !CheckChars(parent.frames[1].document.forms[0].batchno))
			{

				alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
				parent.frames[1].document.forms[0].batchno.select();
				return false;
			}
			else
			{
				batchno=parent.frames[1].document.forms[0].batchno.value;
				if(batchno=="") batchno= " ";		
			}

			if(credit_card_machine_int_yn != "Y" && !CheckChars(parent.frames[1].document.forms[0].apprrefno))
			{

				alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
				parent.frames[1].document.forms[0].apprrefno.select();
				return false;
			}
			else
			{
				apprrefno=parent.frames[1].document.forms[0].apprrefno.value;
				if(apprrefno=="") apprrefno=" ";	
			}

			if(credit_card_machine_int_yn != "Y" && !CheckChars(parent.frames[1].document.forms[0].saledraftno))
			{

				alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
				parent.frames[1].document.forms[0].saledraftno.select();
				return false;
			}
			else
			{
				saledraftno=parent.frames[1].document.forms[0].saledraftno.value;
				if(saledraftno=="") saledraftno=" ";
			}
			cashslmtflag = parent.frames[1].document.forms[0].cashslmtflag.value;
			if(cashslmtflag=="") cashslmtflag=" ";

			instremarkcode = parent.frames[1].document.forms[0].instremarkcode.value;
			if(instremarkcode=="") instremarkcode=" ";


			total_amt_payable=parent.frames[0].document.forms[0].total_amt_payable.value;
			if(total_amt_payable=="") total_amt_payable=" ";

			//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
			cc_term_id_num = parent.frames[1].document.forms[0].cc_term_id_num.value;
			if(cc_term_id_num=="") cc_term_id_num=" ";
			cc_trx_date_time = parent.frames[1].document.forms[0].cc_trx_date_time.value;
			if(cc_trx_date_time=="") cc_trx_date_time=" ";
		}
		/*Added for KDAH CRF 339.2 - Rajesh V*/
		var restrictEligibility = $('#restrictEligibility').val();
		
		var cashForTaxCalc = 'N';
		if(restrictEligibility == "Y" ){
		
			var slmtTypeCode = slmttype.substring(0,2);
			
			var parmForCheck = 'calledFrom=blCashSlmt'+
								'&slmtTypeCode='+slmtTypeCode;
			$.ajax({
				type:"GET",
				url:"../jsp/BLCashSlmtRestrictAjax.jsp",
				data:parmForCheck,
				dataType:"text",
				async:false,
				success: function(data){
					cashForTaxCalc = $.trim(data);
				},
				 error: function(data){
					 cashForTaxCalc = 'N';
				  }
			});
			
			if(cashForTaxCalc == 'Y'){
				var obj;
				var cashCollected = 0;
				var totalCashAmtColl = $('#totalCashAmtColl').val();
				if(isNaN(totalCashAmtColl)){
					totalCashAmtColl = 0;
				}
				totalCashAmtColl = parseFloat(totalCashAmtColl)+parseFloat(v_billslmtamt);
				var strBillDocCode = $('#strBillDocCode').val();
				var strBillDocNum = $('#strBillDocNum').val();
				if(strBillDocCode != '' && strBillDocNum != ''){
					parmForCheck = 'calledFrom=BLPatientRecValidate'+
									'&docTypeCode='+strBillDocCode+
									'&docNum='+strBillDocNum+
									'&docDate='+
									'&episodeType='+'<%=strepisodetype%>'+
									'&episodeId='+'<%=strepisodeid%>'+
									'&visitId='+'<%=strvisitid%>'+
									'&patientId='+'<%=strpatientid%>'+
									'&slmtAmt='+totalCashAmtColl;
				}
				else{
					parmForCheck = 'calledFrom=BLPatientDepValidate'+
									'&patientId='+'<%=strpatientid%>'+
									'&depositAmt='+totalCashAmtColl;
				}

				if(parseFloat(totalCashAmtColl)>=0){
					var errorCheck = '';
					$.ajax({
						type:"GET",
						url:"../jsp/BLCashSlmtRestrictAjax.jsp",
						data:parmForCheck,
						dataType:"json",
						async:false,
						success: function(data){
							if(data.allowYn == 'N'){
								
								if(data.errorText != ''){
									errorCheck = errorCheck+data.errorText;
								}
								if(data.messageText != ''){
									if(errorCheck == ''){
										errorCheck = errorCheck+data.messageText;
									}
									else{
										errorCheck = errorCheck+"\n"+data.messageText;
									}
								}
								//V231128
								if(data.messageTextExtn != ''){
									if(errorCheck == ''){
										errorCheck = errorCheck+data.messageTextExtn;
									}
									else{
										
										errorCheck = errorCheck+"\n\n"+data.messageTextExtn.replace(/\\n/g,'\n');  
									}
								}
							}
						},
						 error: function(data){
							 
						  }
					});
					if(errorCheck != ''){
						alert(errorCheck);
						return false;
					}
				}
				
			}
		}
		// V210113 start
		var coupon=""; 
		var patMembershipID="";		
		var couponAndAmt ="";
		if (v_couponflag != '') {
			coupon=parent.frames[1].document.forms[0].couponcode.value; //shikha
			patMembershipID=parent.frames[1].document.forms[0].patMembershipID.value; //shikha
			couponAndAmt=parent.frames[1].document.forms[0].couponAndAmt.value; //shikha			
		}else {
			coupon="";
			patMembershipID="";
			couponAndAmt="";
		}		
		// V210113 end
		/*Added for KDAH CRF 339.2 - Rajesh V*/		
		if(coupon !== "") {
			instref = "COUPONS";
		}//V210224		
		/*Added for KDAH CRF 339.2 - Rajesh V*/
		//Commented by Sethu for GHL-SCF-1545 on 11/01/2021-->
		//var retVal=billdoctype+"::"+billdocnum+"::"+billpayableamt+"::"+billslmtamt+"::"+slmttype+"::"+encodeURIComponent(payername)+"::"+recrefidno+"::"+ext_acc_interface_yn+"::"+ext_acc_fac_id+"::"+instref+"::"+instdate+"::"+instremark+"::"+instbranch+"::"+onlineapproval+"::"+batchno+"::"+apprrefno+"::"+saledraftno+"::"+cashslmtflag+"::"+instbankname+"::"+cash_given+"::"+cash_return+"::"+short_desc+"::"+instremarkcode+"::"+total_amt_payable+"::"+credit_card_machine_int_yn+"::"+cashForTaxCalc+"::"+coupon+"::"+patMembershipID+"::"+couponAndAmt; // V210113    
		//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->
		var retVal=billdoctype+"::"+billdocnum+"::"+billpayableamt+"::"+billslmtamt+"::"+slmttype+"::"+encodeURIComponent(payername)+"::"+recrefidno+"::"+ext_acc_interface_yn+"::"+ext_acc_fac_id+"::"+instref+"::"+instdate+"::"+instremark+"::"+instbranch+"::"+onlineapproval+"::"+batchno+"::"+apprrefno+"::"+saledraftno+"::"+cashslmtflag+"::"+instbankname+"::"+cash_given+"::"+cash_return+"::"+short_desc+"::"+instremarkcode+"::"+total_amt_payable+"::"+credit_card_machine_int_yn+"::"+cashForTaxCalc+"::"+cc_term_id_num+"::"+cc_trx_date_time+"::"+coupon+"::"+patMembershipID+"::"+couponAndAmt; // V210113
	//	alert("BLBillSlmtConfirm.jsp :"+retVal);
		//prompt("",retVal);
		//alert(retVal);
		parent.window.returnValue = retVal;
		parent.window.close();
	}

	function enableAllElements_billslmt_remove()
	{
		document.forms[0].remove_button.disabled=false;
		//document.forms[0].cancel_button.disabled=false;
	}
	function remove_billslmt()
	{
		
		parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = "remove";
		parent.parent.document.getElementById('dialog_tag').close(); 
		/* parent.window.returnValue = "remove";
		parent.window.close(); */	
	}		

	function cancel()
	{
	//V210211 START
		var str = parent.frames[0].document.forms[0].slmttype.value;	
		var siteCouponInSlmt = document.forms[0].siteCouponInSlmt.value;
		var cash_slmt_flag =str.charAt(2);	
		var coupon_yn = str.charAt(3);	
		//V210211 END
		// V210113 start
		if ((siteCouponInSlmt== true || siteCouponInSlmt == 'true') && cash_slmt_flag=="D" && coupon_yn=="Y") {	//V210211
			var patientID =parent.frames[1].document.forms[0].patientid.value; 
			var LoggedUser =parent.frames[1].document.forms[0].LoggedUser.value; 
			var clientIpAddress =parent.frames[1].document.forms[0].clientIpAddress.value; 
			var cash_given =parent.frames[1].document.forms[0].cash_given.value; 	
			var coupon=parent.frames[1].document.forms[0].couponcode.value; 
			//V210224 start
			var coupons = parent.frames[1].document.forms[0].coupons.value;
			var action_ind = document.forms[0].action_ind.value;
			if(action_ind == "add" || (action_ind == "modify" && coupon != coupons) ) {
			//V210224 end
				//V210211
				if (coupon != "undefined" && coupon != undefined && coupon != "" ) {
					if(confirm(getMessage("BL0924","BLEXT"))) //BL9760
					{				
						var transactionid='';		
						var NuhdeekResponse = NuhdeekTransactions('RELEASE',patientID,coupon,transactionid, LoggedUser, clientIpAddress);		
						var NuhdeekResponseArr = NuhdeekResponse.split("$!^");		
						if (NuhdeekResponseArr[0] == 'S') {		
								parent.window.close();
						} else if (NuhdeekResponseArr[0]=='E') {
								alert(NuhdeekResponseArr[4]);
								return false;
						}
					}else {
						return false;	
					}				
				} //V210211
			} //V210224 
		}
		// V210113 end
		parent.parent.document.getElementById('dialog_tag').close(); 
		/* parent.window.close(); */
	}

	function enableAllElements_bill()
	{
		var len = parent.frames[1].document.forms[0].elements.length;
		for(var i=0;i<len;i++)
		{
			parent.frames[1].document.forms[0].elements(i).disabled=false;
		}
		document.forms[0].remove_button.disabled=true;
	}
</script>
		
  	</head>
	<body onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      onSelect="codeArrestThruSelect();">
	<form name='BillSlmtTypeForm' id='BillSlmtTypeForm' method='post' action=''  scrolling=no >	
	<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>	
	<tr>
	<td class="label" width="25%" ></td>
	<input type='hidden' name='rec_ref' id='rec_ref' id='rec_ref' value='<%=rec_ref%>'>
	<!--<td class="label" width="25%"><INPUT TYPE="button"  class="BUTTON" VALUE="    OK    " onClick='billslmtprocess()'></td>
	-->
<%
if(action_ind.equals("add"))
{
%>
<td class="label" width="25%"></td>
<td class="label" width="25%"><!-- <INPUT TYPE="button"  class="BUTTON" VALUE="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>    " onClick='billslmtprocess()' DISABLED> -->
<input type='button'  name="accept_button" id="accept_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" class='button' onclick='acceptbillslmt()'>
<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel()'></td>
<%			
}
else if(action_ind.equals("modify")) 
	{

%>
<td class="label" width="25%"><!-- <INPUT TYPE="button"  class="BUTTON" VALUE="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick='billslmtprocess()' DISABLED> -->
<input type='button'  name="accept_button" id="accept_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" class='button' onclick='acceptbillslmt()'>
<!--<input type='button' class='button' onclick='enableAllElements_billslmt_remove();remove_billslmt()' name="remove_button" id="remove_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>" <%=disabled_field%>>-->
<!--<input type='button' class='button' onclick='enableAllElements_bill()' name="modify_button" id="modify_button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" >-->
<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel()'></td>
	<%
	}
else{
	%>
	<td class="label" width="25%"><input type='button' class='button' onclick='enableAllElements_billslmt_remove();remove_billslmt()' name="remove_button" id="remove_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>" <%=disabled_field%>>

<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel()'></td>
<%
}
	%>
</tr>         
</table> 
<input type='hidden' name='totalCashAmtColl' id='totalCashAmtColl' id='totalCashAmtColl' value='<%=totalCashAmtColl %>'>
<input type='hidden' name='strBillDocCode' id='strBillDocCode' id='strBillDocCode' value='<%=strbilldoctypecode %>'>
<input type='hidden' name='strBillDocNum' id='strBillDocNum' id='strBillDocNum' value='<%=strbilldocnum %>'>
<input type='hidden' name='restrictEligibility' id='restrictEligibility' id='restrictEligibility' value='<%=restrictEligibility %>'>
<input type='hidden' name='siteCouponInSlmt' id='siteCouponInSlmt' value='<%=siteCouponInSlmt%>'>
<input type='hidden' name='action_ind' id='action_ind' value='<%=action_ind%>'>
</form>	 
</body>
</html>

