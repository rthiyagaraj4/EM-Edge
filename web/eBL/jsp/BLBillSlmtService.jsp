<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,eBL.BLReportIdMapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%!
private String validateAmountForNull(String input){
	try{
		if(input == null){
			input = "0";
		}
		
		if("".equals(input.trim())){
			input = "0";
		}
	}
	catch(Exception e){
		System.err.println("Exception in validateAmountForNull"+e);
		e.printStackTrace();
		input = "0";
	}
	return input;
	
} %>
<%
 	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";
	Connection con = null;
	PreparedStatement pstmt = null;PreparedStatement pstmt1 = null;
	ResultSet rs = null;  ResultSet rs1 = null;ResultSet rscurr=null;
	//ResultSet rs2 = null unused
	
	ResultSet rs2 = null; //muthu
	ResultSet rs3 = null; //muthu
	PreparedStatement pstmt2 = null; //muthu
	PreparedStatement pstmt3 = null; //muthu
	String str_ext_acc_facility_id = "", strfacilityid = "", strbilldoctypecode="", strbilldocnum="";
	String strmoduleid="",strfunctionid="",strroundingamt="",str_total_net_charge="",strbillpayableamt="";
	String struser=""; String  classval="",strItemServCode="";
	int noofdecimal=2, total_records=0,total_rec_for_check=0;
	double d_total_net_charge=0,d_billpayableamt=0;

	String slmt_amt_disabled_YN="";
	String called_frm="",alw_co_wit_bl_slmt_yn="N",str_episode_type="";
	String unavailed_yn="N";
	double tempSlmtNoRoundOff=0; // SCF 272
	boolean amtRoundOff = true;//Added V180123-Aravindh/MMS-JU-SCF-0102
	String readOnly = "";
%>

<HTML>
<HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language='javascript'>	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
				thead td, thead td.locked	{
				background-color: navy;
				color: white;
				position:relative;}	
				thead td {
				top: expression(document.getElementById("tbl-container").scrollTop-2); 
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
<%	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		CurrencyFormat cf1 = new CurrencyFormat();
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{	noofdecimal  =  rscurr.getInt(1);}	
			if(rscurr != null) rscurr.close();
			pstmt.close();
		}catch(Exception e) 
		{
			System.out.println("3="+e.toString());
		}
		
		//Added V180123-Aravindh/MMS-JU-SCF-0102 try
		try {
			pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
			
			rs = pstmt.executeQuery();	
			if ( rs != null && rs.next())
			{
				if(rs.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
					amtRoundOff = false;
				}
			}
		} catch(Exception e) {   
			e.printStackTrace();
			System.out.println("4="+e.toString());
		} finally {
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 		
		}

		//Added for MMS-RY-SCF-0089 Rajesh V
		if(!amtRoundOff){
			readOnly = "readonly";
		}
//		System.out.println("Query String in Service :"+request.getQueryString());
		strbilldoctypecode = request.getParameter("billdoctypecode");	
		if(strbilldoctypecode==null || strbilldoctypecode.equals("")) strbilldoctypecode="";		
		strbilldocnum = request.getParameter("billdocnum");	
		if(strbilldocnum==null || strbilldocnum.equals("")) strbilldocnum="";
		strfacilityid = request.getParameter("facilityid");	
		if(strfacilityid==null || strfacilityid.equals("")) strfacilityid="";
		struser = request.getParameter("loggeduser");		
		if(struser==null || struser.equals("")) struser="";	
		strmoduleid = request.getParameter("strmoduleid");		
		if(strmoduleid==null || strmoduleid.equals("")) strmoduleid="";	
		strfunctionid = request.getParameter("strfunctionid");		
		if(strfunctionid==null || strfunctionid.equals("")) strfunctionid="";
		
		

		strbillpayableamt = request.getParameter("billpayableamt");	
		if(strbillpayableamt==null || strbillpayableamt.equals("")) strbillpayableamt="0";

		d_billpayableamt = Float.parseFloat(strbillpayableamt);

		strroundingamt = request.getParameter("strroundingamt");
		if ( strroundingamt == null || strroundingamt.equalsIgnoreCase("null")) 
		{
			strroundingamt ="0";
		}
		
		//Added V180123-Aravindh/MMS-JU-SCF-0102 if-else condition
		if(amtRoundOff) {
			strroundingamt = cf1.formatCurrency(strroundingamt,noofdecimal);
		} else {
			//strroundingamt = BLReportIdMapper.truncateUptoTwoDecimal(strroundingamt,noofdecimal);
			strroundingamt = validateAmountForNull(strroundingamt);
		}
//		System.out.println("strroundingamt service1" + strroundingamt);

		slmt_amt_disabled_YN = request.getParameter("slmt_amt_disabled_YN");
		if(slmt_amt_disabled_YN == null) slmt_amt_disabled_YN="";

		called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";

		alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
		if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";

		str_episode_type=request.getParameter("episodetype");
		if(str_episode_type == null) str_episode_type="";
%>

<script>	

var firstTimeChange = 'Y';
/*Karthik added the below Scripts to add link for Package Details - Starts*/

async function openLinkScreen(pkgCode,pkgSeqNo,patientId){
	//alert(pkgCode+pkgSeqNo+patientId);
	var dialogUrl       = "../../eBL/jsp/BLBillSlmtPkgInfo.jsp?pkgCode="+pkgCode+"&pkgSeqNo="+pkgSeqNo+"&patientId="+patientId;  
	var dialogFeatures  = "dialogHeight:" + "51vh" + "; dialogWidth:" + "85vw" +" ; scroll=true; ";
	var returnVal = await top.window.showModalDialog(dialogUrl,null,dialogFeatures);
}

/*Karthik added the below Scripts to add link for Package Details - Ends*/
	function putdeci(object)
	{
		if(object.value!='')
		{
		var decimal=document.forms[0].noofdecimal.value;
		putDecimal(object,17,decimal);
		}
	}

	function funServiceDet()
	{
		var amt_sett=document.forms[0].billslmtamtdet.value;
		var sett_amt=parent.frames[2].document.forms[0].total_settled_amt.value;			
		if(amt_sett!="")
		{
		if(parseFloat(amt_sett)<parseFloat(sett_amt))
		{
			alert(getMessage("BL9628","BL"));
			 document.forms[0].billslmtamtdet.select();
			 return false;
		 }		
		var out_standing_amt=document.forms[0].billpayableamt.value;
		if(parseFloat(amt_sett)>parseFloat(out_standing_amt))
		{			
			alert(getMessage("BL9614","BL"));
			 document.forms[0].billslmtamtdet.select();
			 return false;
		}
		}//document.forms[0].submit();
	}


	function funCurStlmt()
	{		
		var total_records=document.forms[0].total_records.value;		
		var v_tot_curr_stlmt=document.forms[0].tot_curr_stlmt.value;
		var pay_amt=parent.frames[0].document.forms[0].billpayableamt.value;
		for(var j=0;j<total_records;j++)
		{
			var curr_set_t=eval("document.forms[0].curr_set"+j);
			var curr_set=curr_set_t.value;

			if(pay_amt < 0)
			{
			var temp=curr_set.indexOf('-');
			if(temp != -1 ) 
			{
				if(temp != 0 ) 
				{
					alert(getMessage("INVALID_NUMBER_FORMAT","common"));
					curr_set_t.focus();
					return false;
				}
			}
			}
			var unavailed_yn=eval("document.forms[0].unavailed_yn"+j);
			if(pay_amt>0 && curr_set<0)
			//if(parseFloat(Math.abs(pay_amt))>0 && parseFloat(Math.abs(curr_set))<0)//added parseFloat(Math.abs) for package billing
			{				
				if(unavailed_yn=="N")
				{									
					alert(getMessage("BL9863","BL"));
					curr_set_t.focus();
					return false;
				}
			}
			if(pay_amt<0 && curr_set>0)
			{				
				alert(getMessage("BL9863","BL"));
				curr_set_t.focus();	
				return false;
			}
		}

		for(var j=0;j<total_records;j++)
		{
			var pend_amt=eval("document.forms[0].pend_set"+j);
			var curr_set=eval("document.forms[0].curr_set"+j);

			if(curr_set.value=="")
			{
				curr_set.value=0.00;
				putdeci(curr_set);				
				curr_set.select();
				return false;
			}
			if ( parseFloat(Math.abs(curr_set.value)) > parseFloat(Math.abs(pend_amt.value)))
			{
			 alert(getMessage("BL9658","BL"));			
			curr_set.select();
			return false;
		}
		totCurrSlmt('Y');
	
	/*if(parseFloat(curr_set.value) >parseFloat(v_tot_curr_stlmt))
		{
			alert(getMessage("BL9621","BL"));
			curr_set.value=0.00;
			putdeci(curr_set);
			//curr_set.focus();
			curr_set.select();
			return false;
		}*/
	}
}

function callServDist()
{
	var decimal=document.forms[0].noofdecimal.value;
	var total_records=document.forms[0].total_records.value;	
	var rounding_amt = document.forms[0].strroundingamt.value;
	
	for(var j=0;j<total_records;j++)
	{
		if((j+1) == total_records)
		{
//			var charge_amt=eval("document.forms[0].charge_amt"+j);	
//			charge_amt.value = parseFloat(charge_amt.value)+parseFloat(rounding_amt);
//			var pend_amt=eval("document.forms[0].pend_set"+j);	
//			pend_amt.value = charge_amt.value;
//			putdeci(charge_amt);
//			putdeci(pend_amt);
		}
	}

	funCurrMultSlmt();

}

function funCurrMultSlmt()
{
	var s_amt=parent.frames[0].document.forms[0].billslmtamtdet.value;
	var p_amt=parent.frames[0].document.forms[0].billpayableamt.value;
	var decimal=document.forms[0].noofdecimal.value;

	//Added for MMS-RY-SCF-0089 Rajesh V
	var amtRoundOff = document.forms[0].amtRoundOff.value;
	/*Added Logic for fixing AMRI SCF*/
	var openingBalance = 0;
	var closingBalance = 0;
	/*Added Logic for fixing AMRI SCF*/
	
	if(s_amt!="")
	{
		var total_records=document.forms[0].total_records.value;	
		if(total_records>0)
		{
			for(var j=0;j<total_records;j++)
			{
				var pend_amt=eval("document.forms[0].pend_set"+j);			  
			    var v_pend_amt=pend_amt.value;
			    			
			    var curr_set=eval("document.forms[0].curr_set"+j);
			  
			 /*   if(p_amt>=0)
				{
					if(s_amt>=0)
				    {
						if(parseFloat(s_amt) > parseFloat(pend_amt.value))
						{				
							curr_set.value=v_pend_amt;				  
							putdeci(curr_set);
						}
						else
						{					
							if(parseFloat(s_amt)>0)
							{					 
								curr_set.value=s_amt;
								putdeci(curr_set);
							}
							else
							{
								curr_set.value=0;
								putdeci(curr_set);
							}				 				 
						 }
					}
					else
					{
						curr_set.value=0;
						putdeci(curr_set);
					}
				}
			    */
			  //  Added V180306-Gayathri/Starts
					if(p_amt>0)
					{
						if(j==0){
							if(parseFloat(v_pend_amt) < parseFloat(s_amt)){
								openingBalance=v_pend_amt;
							}
							else{
								openingBalance=s_amt;
							}
						}
						else{
							openingBalance=closingBalance;	
						}

					   	if((parseFloat(s_amt)-parseFloat(pend_amt.value))<0){
							closingBalance = 0;
						}
				    	else{
							closingBalance = parseFloat(s_amt)-parseFloat(pend_amt.value);
						}
					    	
					    if(parseFloat(closingBalance)<0){
							curr_set.value = 0;
							if(amtRoundOff == true || amtRoundOff =='true'){
								putdeci(curr_set);
							}						
						}
					    	
						else{
							if(j==0){
								curr_set.value=openingBalance;
							}
					    	else{
					    		curr_set.value=parseFloat(openingBalance)-parseFloat(closingBalance);	
							}
							if(amtRoundOff == true || amtRoundOff =='true'){
								putdeci(curr_set);
							}	
						}
					}
			    //Added V180306-Gayathri/Ends
						
						
					if(p_amt<0)
					{	
						/*Added Logic for fixing AMRI SCF*/
						if(j==0){
							openingBalance = s_amt;
						}
						else{
							openingBalance = closingBalance;
						}
						
						if((parseFloat(s_amt)-parseFloat(pend_amt.value))>0){
							closingBalance = 0;
						}
						else{
							closingBalance = parseFloat(s_amt)-parseFloat(pend_amt.value);
						}
							 
						if(parseFloat(closingBalance)>0){
							curr_set.value = 0;
							if(amtRoundOff == true || amtRoundOff =='true'){
								putdeci(curr_set);
							}
						}
						else{
							curr_set.value=parseFloat(openingBalance)-parseFloat(closingBalance);	
							if(amtRoundOff == true || amtRoundOff =='true'){
								putdeci(curr_set);
							}
						}
					//Commented Below Logic and added above logic for AMRISCF
					/*if(s_amt<0)
					{
						if(parseFloat(pend_amt.value) > parseFloat(s_amt))
						{				
							curr_set.value=pend_amt.value;				 
							putdeci(curr_set);
						}
						else
						{					
							if(parseFloat(s_amt)<0)
							{		
								curr_set.value=s_amt;				  						
								putdeci(curr_set);
							}
							else
							{
								curr_set.value=0;
								putdeci(curr_set);
							}				 				 
						 }
					}
					else
					{
						curr_set.value=0;
						putdeci(curr_set);
					}*/
				}
			
				//s_amt=Math.ceil(s_amt);
				s_amt=parseFloat(s_amt)-parseFloat(v_pend_amt);		
				if(amtRoundOff == true || amtRoundOff =='true'){
					s_amt=s_amt.toFixed(decimal);
				}
//				totCurrSlmt();
			}
			totCurrSlmt();
		}
	
	}

}

function totCurrSlmt(on_blur_check)
{
	var tot_curr_set=0.0;
	var tot_curr_set_no_roundoff=0.0;
	var tot_charge_amt=0.0;
	var v_curr_set="";
	var a1=new Array();
	var a2=new Array();
	var billpayableamt=parent.frames[0].document.forms[0].billpayableamt.value;
	var s_amt=parent.frames[0].document.forms[0].billslmtamtdet.value;
	var strroundingamt=document.forms[0].strroundingamt.value;	
	var total_records=document.forms[0].total_records.value;
	var decimal=document.forms[0].noofdecimal.value;

	for(var j=0;j<total_records;j++)
	{
		v_curr_charge_amt=eval("document.forms[0].charge_amt"+j);
		a2[j]=v_curr_charge_amt.value;
		
		if(a2[j]==""){a2[j]="0.0";}

		tot_charge_amt=parseFloat(tot_charge_amt) + parseFloat(a2[j]);
	}
	tot_charge_amt = tot_charge_amt.toFixed(decimal);
	document.forms[0].net_total.value=tot_charge_amt;
	putdeci(document.forms[0].net_total);
	//karthik added	- SCF 272		    
	var v_curr_set_no_roundoff="";			  
	var a1_no_roundoff=new Array();
    
	for(var j=0;j<total_records;j++)
	{
		v_curr_set=eval("document.forms[0].curr_set"+j);
		a1[j]=v_curr_set.value;
		if(a1[j]==""){a1[j]="0.0";}
		tot_curr_set=parseFloat(tot_curr_set) + parseFloat(a1[j]);
		
		//karthik added logic here - starts SCF 272 
		v_curr_set_no_roundoff=eval("document.forms[0].pend_set_no_roundoff"+j);
		a1_no_roundoff[j]=v_curr_set_no_roundoff.value;
		if(a1_no_roundoff[j]==""){a1_no_roundoff[j]="0.0";}	
		
		if(parseFloat(a1_no_roundoff[j]).toFixed(decimal)==parseFloat(a1[j]).toFixed(decimal)){
		tot_curr_set_no_roundoff=parseFloat(tot_curr_set_no_roundoff) + parseFloat(a1_no_roundoff[j]);
		}else{
		tot_curr_set_no_roundoff=parseFloat(tot_curr_set_no_roundoff) + parseFloat(a1[j]);	
		}
		//karthik added logic here - ends SCF 272 
		
	}
	//Changes for KDAH-318
	var billLevelTax = parent.frames[0].document.forms[0].billLevelTax.value;	
	var addlChargeAmt = parent.frames[0].document.forms[0].addlChargeAmtForBill.value;
	if(addlChargeAmt == ''){
		addlChargeAmt = 0;
	}

	if(billLevelTax == 'Y' && addlChargeAmt > 0 && firstTimeChange == 'Y'){	
		
		tot_curr_set = parent.frames[0].document.forms[0].billslmtamtdet.value;		
		firstTimeChange = 'N';
	}
	else{
		tot_curr_set = tot_curr_set.toFixed(decimal);
	}
	//Changes for KDAH-318
	
	//tot_curr_set_no_roundoff=tot_curr_set_no_roundoff.toFixed(decimal); SCF 272
	document.forms[0].tot_curr_stlmt.value=tot_curr_set;
	document.forms[0].tot_curr_stlmt_no_roundoff.value=tot_curr_set_no_roundoff;	//SCF 272


	var total_curr_stlmt=eval("document.forms[0].tot_curr_stlmt");	
	putdeci(total_curr_stlmt);
	if(parseFloat(billpayableamt) < parseFloat(tot_curr_set))
	{
		tot_curr_set=parseFloat(tot_curr_set) + parseFloat(strroundingamt);
		tot_curr_set = tot_curr_set.toFixed(decimal);
	}

	if(on_blur_check == 'Y')
	{
		parent.frames[0].document.forms[0].billslmtamtdet.value=tot_curr_set;
		var billslmtamtdet=eval("parent.frames[0].document.forms[0].billslmtamtdet");
		putdeci(billslmtamtdet);
	}
}

function ChkNumberInput1(fld, e, deci,sn)
{
	var strCheck ="";
	if(parent.frames[0].document.forms[0].billpayableamt.value < 0)
	{
		if (parseInt(deci)>0)
			strCheck = '-.0123456789';
		else
			strCheck = '-0123456789';	
	}
	else
	{
		if (parseInt(deci)>0)
			strCheck = '.0123456789';
		else
			strCheck = '0123456789';	
	}
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	
	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char
	if(key == "-" && fld.value.indexOf(key) != -1) return false; // Not more than one '-' char
}

function slmt_amt_disabled_YN() // Called coz when the Cashcounter/user doesnt have access to modify the amount, its should be disabled
{
	var alw_co_wit_bl_slmt_yn=document.forms[0].alw_co_wit_bl_slmt_yn.value;
	var called_frm=document.forms[0].called_frm.value;
	var str_episode_type=document.forms[0].str_episode_type.value;
	var slmt_amt_disabled_YN=document.forms[0].slmt_amt_disabled_YN.value;
	var total_records=document.forms[0].total_records.value;

	if(alw_co_wit_bl_slmt_yn == "Y" && called_frm=="CHECKOUT_VISIT" && str_episode_type == "E")
	{
		for(var j=0;j<total_records;j++)
		{
			var curr_set_t=eval("document.forms[0].curr_set"+j);
			curr_set_t.disabled=true;
		}
	}
	else
	{
		if(slmt_amt_disabled_YN=="Y")
		{
			for(var j=0;j<total_records;j++)
			{
				var curr_set_t=eval("document.forms[0].curr_set"+j);
				curr_set_t.disabled=true;
			}
		}
		else
		{
			for(var j=0;j<total_records;j++)
			{
				var curr_set_t=eval("document.forms[0].curr_set"+j);
				curr_set_t.disabled=false;
			}
		}
	}
}

	</script>	  

</HEAD>
	<BODY	 onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();"  onload='callServDist();slmt_amt_disabled_YN();' >
	<FORM name='BillSlmtDetForm' id='BillSlmtDetForm' method='post'  action=''  scrolling='NO' >
	<div>
	<table border='1' cellpadding='3' cellspacing='0' align='center' width='100%'>	
	<tr><th class='columnHeader' align="left" width='100%'><fmt:message key="eBL.SETTLEMENT_BY_SERVICES.label" bundle="${bl_labels}"/></th></tr>
	</table></div>
	<div id="tbl-container" STYLE="overflow: auto; height: 175px;   padding:3px; margin: 0px">
	<table border='1' cellpadding='3' cellspacing='0' align='center' width='100%'>	
	<thead><tr>
<%
		if(strmoduleid.equals("PH") || strmoduleid.equals("ST")) //&& (strfunctionid.equals("DIS")|| strfunctionid.equals("")))
		{
%>
			<td class='COLUMNHEADER' width='14%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='14%'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='18%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td width="11%" class='COLUMNHEADER'><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>			
			<td width="11%" class='COLUMNHEADER'><fmt:message key="eBL.AMT_SETTLED.label" bundle="${bl_labels}"/></td>	
			<td width="11%" class='COLUMNHEADER'><fmt:message key="eBL.PENDING_SETTLEMENT.label" bundle="${bl_labels}"/></td>	
			<td width="11%" class='COLUMNHEADER'><fmt:message key="eBL.CURRENT_SETTLEMENT.label" bundle="${bl_labels}"/></td>			
<%
			
		}
		else
		{
%>
			<!--<td class='COLUMNHEADER' width='2%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>-->
			<td class='COLUMNHEADER' width='14%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='14%'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td width="13%" class='COLUMNHEADER'><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>			
			<td width="13%" class='COLUMNHEADER'><fmt:message key="eBL.AMT_SETTLED.label" bundle="${bl_labels}"/></td>	
			<td width="13%" class='COLUMNHEADER'><fmt:message key="eBL.PENDING_SETTLEMENT.label" bundle="${bl_labels}"/></td>	
			<td width="13%" class='COLUMNHEADER'><fmt:message key="eBL.CURRENT_SETTLEMENT.label" bundle="${bl_labels}"/></td>			
<%		
		}
%>
	</tr></thead>
<%
	/**************Added for Package Billing*****************stsrts****/
	//to get the UNAVAIL PKG BLNG SERV CODE from bl_parameters
		String unavail_service_code= request.getParameter("unavail_service_code");
		if(unavail_service_code == null) unavail_service_code="";
/* Commented for PE Changes, value is passed from Main.jsp
		try
		{		
			pstmt = con.prepareStatement( "Select UNAVAIL_PKG_BLNG_SERV_CODE  from BL_PARAMETERS  where OPERATING_FACILITY_ID ='"+facilityid+"'");
			rs2 = pstmt.executeQuery();	
			while(rs2.next())
			{
				unavail_service_code  =  rs2.getString(1);
			}	
			if(rs2 != null) rs2.close();
			pstmt.close();
		}catch(Exception e) 
		{
			System.out.println("UNAVAIL_PKG_BLNG_SERV_CODE="+e.toString());
		}
*/
	/*******************Package Billing**********************ends******/
		//totalRecords=1;
		String strblngservdesc= "";
		int i=0;
		String sql="";
		String strServiceDate="",strTrxDate="";
		String strBlngservCode="";
		String strLongDesc="";
		String strUpdNetChargeAmt="", strNetChrgAmtAftRndAdj="", strUpdGrossChargeAmt="";
		String strPrtGrpHdrCode="",strPrtGrpLineCode="";
		String strTotalSettAmt="";
		String strTrxDocRef="";
		String strTrxDocRefLineNum="";
		String strTrxDocRefSeqNum="";
		String strOperatingFacId="";
		String strServQty="";
		/*Karthik added the below variables to add link for Package Details - Starts*/
		String strPkgInd="";
		String strPkgSeqNo="";
		String strPatientId="";
		/*Karthik added the below variables to add link for Package Details - ends*/
		String strAddlchargeExemptamt="";//Added V180308 by Gayathri-7668
		double dPendStlmt=0;
		double actUpdNetCharge=0;//Added V180308 by Gayathri-7668/Sarts
		try
		{
			if(strmoduleid.equals("PH") || strmoduleid.equals("ST"))//&& (strfunctionid.equals("DIS")|| strfunctionid.equals("")))
			{
				//Added one parameter V180308 by Gayathri-7668
				 sql="Select a.OPERATING_FACILITY_ID,a.TRX_DOC_REF,a.TRX_DOC_REF_LINE_NUM,a.TRX_DOC_REF_SEQ_NUM,to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),a.blng_serv_code,a.serv_item_desc,a.UPD_NET_CHARGE_AMT tot_Charge_amt,a.serv_qty,(a.UPD_NET_CHARGE_AMT + nvl(BILL_ROUNDING_AMT,0)) UPD_NET_CHRG_AMT_AFT_ROUND,to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'),PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,a.UPD_GROSS_CHARGE_AMT tot_gross_charge_amt,a.serv_item_code,a.package_ind,a.folio_remarks,a.patient_id,nvl(a.ADDL_CHARGE_EXEMPT_AMT,0) from bl_patient_charges_folio a,bl_blng_serv_lang_vw b,bl_bill_hdr c where a.blng_serv_code  = b.blng_serv_code  AND bill_doc_type_code=? AND bill_doc_num=? and a.bill_doc_type_code=c.DOC_TYPE_CODE and a.bill_doc_num=c.DOC_NUM   and b.language_id=?  union Select a.OPERATING_FACILITY_ID,a.TRX_DOC_REF,a.TRX_DOC_REF_LINE_NUM,a.TRX_DOC_REF_SEQ_NUM,to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),a.blng_serv_code,a.serv_item_desc,a.UPD_NET_CHARGE_AMT tot_Charge_amt,a.serv_qty,(a.UPD_NET_CHARGE_AMT + nvl(BILL_ROUNDING_AMT,0)) UPD_NET_CHRG_AMT_AFT_ROUND,to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'),PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,a.UPD_GROSS_CHARGE_AMT tot_gross_charge_amt,a.serv_item_code,a.package_ind,replace(a.FOLIO_REMARKS,'Package-',''),a.patient_id,nvl(a.addl_charge_exempt_amt,0)  from bl_patient_charges_folio a,BL_PACKAGE_LANG_VW b,bl_bill_hdr c where a.blng_serv_code  = b.package_code  AND bill_doc_type_code=? AND bill_doc_num=? and a.bill_doc_type_code=c.DOC_TYPE_CODE and a.bill_doc_num=c.DOC_NUM   and b.language_id=? and a.package_ind ='P' ";
//				 sql="Select a.OPERATING_FACILITY_ID,a.TRX_DOC_REF,a.TRX_DOC_REF_LINE_NUM,a.TRX_DOC_REF_SEQ_NUM,to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),a.blng_serv_code,a.serv_item_desc,a.UPD_NET_CHARGE_AMT tot_Charge_amt,a.serv_qty,(a.UPD_NET_CHARGE_AMT + nvl(BILL_ROUNDING_AMT,0)) UPD_NET_CHRG_AMT_AFT_ROUND,to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'),PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,a.UPD_GROSS_CHARGE_AMT tot_gross_charge_amt,a.serv_item_code from bl_patient_charges_folio a,bl_blng_serv_lang_vw b,bl_bill_hdr c where a.OPERATING_FACILITY_ID = a.OPERATING_FACILITY_ID and a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID and a.blng_serv_code  = b.blng_serv_code  AND bill_doc_type_code='"+strbilldoctypecode+"' AND bill_doc_num='"+strbilldocnum+"' and a.bill_doc_type_code=c.DOC_TYPE_CODE and a.bill_doc_num=c.DOC_NUM and a.blng_serv_code = b.blng_serv_code  and b.language_id='"+locale+"' ";
				 //a.OPERATING_FACILITY_ID = a.OPERATING_FACILITY_ID and a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID and a.blng_serv_code = b.blng_serv_code- Commented by MuthuN against 33583 on 9/25/2012
			}
			else
			{
				//Added one parameter V180308 by Gayathri-7668
				 sql="Select a.OPERATING_FACILITY_ID,a.TRX_DOC_REF, a.TRX_DOC_REF_LINE_NUM  ,a. TRX_DOC_REF_SEQ_NUM , to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),a.blng_serv_code, b.long_desc, a.UPD_NET_CHARGE_AMT tot_Charge_amt, a.serv_qty, (a.UPD_NET_CHARGE_AMT + nvl(BILL_ROUNDING_AMT,0)) UPD_NET_CHRG_AMT_AFT_ROUND,to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'),PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,a.UPD_GROSS_CHARGE_AMT tot_gross_charge_amt,null,a.package_ind,a.folio_remarks,a.patient_id,nvl(a.ADDL_CHARGE_EXEMPT_AMT,0)  from bl_patient_charges_folio a,bl_blng_serv_lang_vw b,bl_bill_hdr c where a.blng_serv_code  = b.blng_serv_code  AND a.bill_doc_type_code=? AND  a.bill_doc_num=? and a.bill_doc_type_code=c.DOC_TYPE_CODE and a.bill_doc_num=c.DOC_NUM and b.language_id=   ?  union Select a.OPERATING_FACILITY_ID,a.TRX_DOC_REF, a.TRX_DOC_REF_LINE_NUM  ,a. TRX_DOC_REF_SEQ_NUM , to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),a.blng_serv_code, b.long_desc, a.UPD_NET_CHARGE_AMT tot_Charge_amt, a.serv_qty, (a.UPD_NET_CHARGE_AMT + nvl(BILL_ROUNDING_AMT,0)) UPD_NET_CHRG_AMT_AFT_ROUND,to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'),PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,a.UPD_GROSS_CHARGE_AMT tot_gross_charge_amt,null,a.package_ind,replace(a.FOLIO_REMARKS,'Package-',''),a.patient_id,nvl(a.addl_charge_exempt_amt,0)  from bl_patient_charges_folio a,BL_PACKAGE_LANG_VW b,bl_bill_hdr c where a.blng_serv_code  = b.package_code  AND a.bill_doc_type_code=? AND  a.bill_doc_num=? and a.bill_doc_type_code=c.DOC_TYPE_CODE and a.bill_doc_num=c.DOC_NUM and b.language_id=   ? and a.package_ind ='P'";
//				 sql="Select a.OPERATING_FACILITY_ID,a.TRX_DOC_REF, a.TRX_DOC_REF_LINE_NUM  ,a. TRX_DOC_REF_SEQ_NUM , to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS'),a.blng_serv_code, b.long_desc, a.UPD_NET_CHARGE_AMT tot_Charge_amt, a.serv_qty, (a.UPD_NET_CHARGE_AMT + nvl(BILL_ROUNDING_AMT,0)) UPD_NET_CHRG_AMT_AFT_ROUND,to_char(TRX_DATE,'DD/MM/YYYY HH24:MI:SS'),PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,a.UPD_GROSS_CHARGE_AMT tot_gross_charge_amt,null  from bl_patient_charges_folio a,bl_blng_serv_lang_vw b,bl_bill_hdr c where a.OPERATING_FACILITY_ID = a.OPERATING_FACILITY_ID and a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID  and a.blng_serv_code  = b.blng_serv_code  AND a.bill_doc_type_code='"+strbilldoctypecode+"' AND  a.bill_doc_num='"+strbilldocnum+"' and a.bill_doc_type_code=c.DOC_TYPE_CODE and a.bill_doc_num=c.DOC_NUM and a.blng_serv_code  = b.blng_serv_code  and b.language_id=   '"+locale+"' ";
				 //a.OPERATING_FACILITY_ID = a.OPERATING_FACILITY_ID and a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID  and a.blng_serv_code  = b.blng_serv_code  and - Commented by MuthuN against 33583 on 9/25/2012
			}

/* 			if(d_billpayableamt>0)
			{
				sql=sql+" ORDER BY a.UPD_NET_CHARGE_AMT ";
			}
			else if(d_billpayableamt<0)
			{
				sql=sql+" ORDER BY a.UPD_NET_CHARGE_AMT DESC";
			} */
			//String sql="Select a.TRX_DOC_REF, a.TRX_DOC_REF_LINE_NUM  ,a. TRX_DOC_REF_SEQ_NUM ,  to_char(a.SERVICE_DATE,'DD/MM/YYYY HH24:MI:SS')   ,a.blng_serv_code, b.long_desc, a.UPD_NET_CHARGE_AMT tot_Charge_amt, c.TOT_SETTLED tot_settled_amt from bl_patient_charges_folio a,     bl_blng_serv_lang_vw b ,     bl_patient_charges_slmt_dtl_vw C where a.OPERATING_FACILITY_ID = a.OPERATING_FACILITY_ID and a.trx_doc_ref=c.trx_doc_ref and a.trx_doc_ref_line_num=c.trx_doc_ref_line_num  and a.trx_doc_ref_seq_num=c.trx_doc_ref_seq_num and a.blng_serv_code  = b.blng_serv_code AND bill_doc_type_code='"+strbilldoctypecode+"'	AND  bill_doc_num='"+strbilldocnum+"' and a.blng_serv_code  = b.blng_serv_code and b.language_id=  '"+locale+"' ";

//			System.out.println("sql_hggfhf:" +sql);
			pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			pstmt.setString(1,strbilldoctypecode);
			pstmt.setString(2,strbilldocnum);
			pstmt.setString(3,locale);
			pstmt.setString(4,strbilldoctypecode);
			pstmt.setString(5,strbilldocnum);
			pstmt.setString(6,locale);
			rs = pstmt.executeQuery();	

			if(rs != null)
			{
				rs.last();
				total_rec_for_check = rs.getRow();
				rs.beforeFirst();
			}

			while(rs.next())
			{
				strOperatingFacId =  rs.getString(1);
				strTrxDocRef =  rs.getString(2);
				strTrxDocRefLineNum =  rs.getString(3);	
				strTrxDocRefSeqNum  =  rs.getString(4);	
				strServiceDate =  rs.getString(5);	
				strBlngservCode =  rs.getString(6);	
				strLongDesc =  rs.getString(7);	
				strUpdNetChargeAmt =  rs.getString(8);	
				//strTotalSettAmt=  rs.getString(8);
				strServQty =  rs.getString(9);	
				strNetChrgAmtAftRndAdj = rs.getString(10);	
				strTrxDate = rs.getString(11);	
				strPrtGrpHdrCode = rs.getString(12);	
				strPrtGrpLineCode = rs.getString(13);	
				strUpdGrossChargeAmt =  rs.getString(14);	
				strItemServCode =  rs.getString(15);
				/*Karthik added the below variables to add link for Package Details - Starts*/
				strPkgInd =  rs.getString(16);	
				strPkgSeqNo =  rs.getString(17);
				strPatientId =  rs.getString(18);	
				/*Karthik added the below variables to add link for Package Details - Ends*/
				strAddlchargeExemptamt=rs.getString(19);//Added V180308 by Gayathri-7668


				if (strTrxDocRef == null) strTrxDocRef = "";
				if (strTrxDocRefLineNum == null) strTrxDocRefLineNum = "";
				if (strTrxDocRefSeqNum == null) strTrxDocRefSeqNum = "";
				if (strServiceDate == null) strServiceDate = "";
				if (strBlngservCode == null) strBlngservCode = "";
				if (strLongDesc == null) strLongDesc = "";
				if (strUpdNetChargeAmt == null) strUpdNetChargeAmt = "";
				if (strServQty == null) strServQty = "";
				if (strTrxDate == null) strTrxDate = "";
				if (strPrtGrpHdrCode == null) strPrtGrpHdrCode = "";
				if (strPrtGrpLineCode == null) strPrtGrpLineCode = "";
				if (strUpdGrossChargeAmt == null) strUpdGrossChargeAmt = "";
				if (strPkgInd == null) strPkgInd = "";
				if (strPkgSeqNo == null) strPkgSeqNo = "";
				if (strPatientId == null) strPatientId = "";
				if (strAddlchargeExemptamt == null) strAddlchargeExemptamt = "";//Added V180308 by Gayathri-7668
				
				String sql1= "Select sum(nvl(TOT_SETTLED ,0)) tot_settled_so_far  from  bl_patient_charges_slmt_dtl_vw C  where C.OPERATING_FACILITY_ID = '"+strOperatingFacId+"'  and C.trx_doc_ref='"+strTrxDocRef+"'  and C.trx_doc_ref_line_num='"+strTrxDocRefLineNum+"'  and C.trx_doc_ref_seq_num='"+strTrxDocRefSeqNum+"' ";
				pstmt1 = con.prepareStatement(sql1);
				rs1 = pstmt1.executeQuery();	
				while(rs1.next())
				{
					strTotalSettAmt=  rs1.getString(1);
			
					if (strTotalSettAmt == null) strTotalSettAmt = "";

					if(total_rec_for_check == (total_records+1))
					{
						strUpdNetChargeAmt = strNetChrgAmtAftRndAdj; 
					}
					String strUpdNetChargeAmtNoRoundOff=strUpdNetChargeAmt;//Karthik SCF 272
					//Added V180123-Aravindh/MMS-JU-SCF-0102 if-else condition
					if(amtRoundOff) {
						strUpdNetChargeAmt = cf1.formatCurrency(strUpdNetChargeAmt,noofdecimal);
					} else {
						//strUpdNetChargeAmt = BLReportIdMapper.truncateUptoTwoDecimal(strUpdNetChargeAmt,noofdecimal);
						strUpdNetChargeAmt = validateAmountForNull(strUpdNetChargeAmt);
					}
					String strTotalSettAmtNoRoundOff=strTotalSettAmt;//Karthik SCF 272
					//Added V180123-Aravindh/MMS-JU-SCF-0102 if-else condition
					if(amtRoundOff) {
					strTotalSettAmt = cf1.formatCurrency(strTotalSettAmt,noofdecimal);
					strAddlchargeExemptamt = cf1.formatCurrency(strAddlchargeExemptamt,noofdecimal);
					} else {
						//strTotalSettAmt = BLReportIdMapper.truncateUptoTwoDecimal(strTotalSettAmt,noofdecimal);
						//strAddlchargeExemptamt = BLReportIdMapper.truncateUptoTwoDecimal(strAddlchargeExemptamt,noofdecimal);
						strTotalSettAmt = validateAmountForNull(strTotalSettAmt);
						strAddlchargeExemptamt = validateAmountForNull(strAddlchargeExemptamt);
					}
						
					actUpdNetCharge=Double.parseDouble(strUpdNetChargeAmt)-Double.parseDouble(strAddlchargeExemptamt);//Added V180308 by Gayathri-7668
					
					dPendStlmt=actUpdNetCharge-Double.parseDouble(strTotalSettAmt);
					String strPendStlmt="";
					if(amtRoundOff) {
					 	strPendStlmt=cf1.formatCurrency(String.valueOf(dPendStlmt),noofdecimal);
					} else {
					 	//strPendStlmt=BLReportIdMapper.truncateUptoTwoDecimal(String.valueOf(dPendStlmt),noofdecimal);
						strPendStlmt = validateAmountForNull(String.valueOf(dPendStlmt));
					}
					/*karthik added code here - SCF 272*/
					if(strUpdNetChargeAmtNoRoundOff==null || "".equals(strUpdNetChargeAmtNoRoundOff)){
						strUpdNetChargeAmtNoRoundOff="0";
					}
					if(strTotalSettAmtNoRoundOff==null || "".equals(strTotalSettAmtNoRoundOff)){
						strTotalSettAmtNoRoundOff="0";
					}
					String strPendStlmtNoRoundOff=""+ (Double.parseDouble(strUpdNetChargeAmtNoRoundOff)-Double.parseDouble(strTotalSettAmtNoRoundOff));//Karthik
					if(strPendStlmtNoRoundOff==null || "".equals(strPendStlmtNoRoundOff)){
						strPendStlmtNoRoundOff="0";
					}
					tempSlmtNoRoundOff+=Double.parseDouble(strPendStlmtNoRoundOff);
					/*karthik added code here - SCF 272 */
					d_total_net_charge=d_total_net_charge+ Double.parseDouble(strUpdNetChargeAmt);
					//Added V180123-Aravindh/MMS-JU-SCF-0102 if-else condition
					if(amtRoundOff) {
						str_total_net_charge = cf1.formatCurrency(String.valueOf(d_total_net_charge),noofdecimal);
					} else {
						str_total_net_charge = BLReportIdMapper.truncateUptoTwoDecimal(String.valueOf(d_total_net_charge),noofdecimal);
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
<tbody>
<tr id=row<%=i%>>
<tr>
<%
	if(strmoduleid.equals("PH") || strmoduleid.equals("ST"))
	{
%>
<!--<td class=<%=classval%> width='2%'><input type="checkbox" name='selected_row<%=i%>' id='selected_row<%=i%>' value='<%=i%>' ></td>	-->
	<td class=<%=classval%> width="14%"><INPUT TYPE="TEXT" name='service_date<%=i%>' id='service_date<%=i%>' SIZE="15" MAXLENGTH="20" 	VALUE='<%=com.ehis.util.DateUtils.convertDate(strServiceDate,"DMYHMS","en",locale)%>'  onBlur='' readonly><input type='hidden' name='trx_doc_ref<%=i%>' id='trx_doc_ref<%=i%>' value='<%=strTrxDocRef%>' > </td>

<!--Added by muthu against Drug Penalty Issue on 04-06-12 Starts here -->
	<td class=<%=classval%> width="14%" >
	<%
		if(strItemServCode == null){
	%>
		<input type='text' name='billing_service_desc<%=i%>' id='billing_service_desc<%=i%>' size='15' maxlength='20' value="<%=strBlngservCode%>" readonly>
	
	<%
		}
		else
		{
	%>
		<input type='text' name='billing_service_desc<%=i%>' id='billing_service_desc<%=i%>' size='15' maxlength='20' value="<%=strItemServCode%>" readonly>
			
	<%
		}
	%>
	
	
		<input type='hidden' name='billing_service<%=i%>' id='billing_service<%=i%>' value="<%=strBlngservCode%>" readonly>
		<input type='hidden' name='trx_doc_ref_line_num<%=i%>' id='trx_doc_ref_line_num<%=i%>' value="<%=strTrxDocRefLineNum%>" > 
		<input type='hidden' name='trx_date<%=i%>' id='trx_date<%=i%>' value="<%=strTrxDate%>" > 
		<input type='hidden' name='prt_grp_hdr_code<%=i%>' id='prt_grp_hdr_code<%=i%>' value="<%=strPrtGrpHdrCode%>" > 
		<input type='hidden' name='prt_grp_line_code<%=i%>' id='prt_grp_line_code<%=i%>' value="<%=strPrtGrpLineCode%>" > 
		<input type='hidden' name='upd_net_charge_amt<%=i%>' id='upd_net_charge_amt<%=i%>' value="<%=strUpdNetChargeAmt%>" > 
		<input type='hidden' name='upd_gross_charge_amt<%=i%>' id='upd_gross_charge_amt<%=i%>' value="<%=strUpdGrossChargeAmt%>" > 
	</td>	

	<%
		//Added by muthuN against 33583 on 9/25/2012 Starts Here
		if(strblngservdesc == ""){
		try
		{
			//Below Query is modified by MuthuN against 33583 on 8/29/2012 & 9/25/2012
			//pstmt2 = con.prepareStatement("SELECT long_desc FROM  bl_blng_serv_lang_vw WHERE language_id = '"+locale+"' AND blng_serv_code = '"+strBlngservCode+"'");
			/* pstmt2 = con.prepareStatement("SELECT SERV_ITEM_DESC FROM bl_patient_charges_folio WHERE blng_serv_code = '"+strBlngservCode+"' and SERV_ITEM_CODE = '"+strItemServCode+"'");
			rs2 = pstmt2.executeQuery();	
			if ( rs2.next() && rs2 != null ) 
			{
				strblngservdesc =  rs2.getString(1);
			}		
			rs2.close();
			pstmt2.close();
			}*/
			if(strItemServCode != ""){
			 pstmt2 = con.prepareStatement("SELECT long_desc FROM mm_item_lang_vw WHERE ITEM_CODE = '"+strItemServCode+"' and language_id = '"+locale+"'");
			}
			else{
				pstmt2 = con.prepareStatement("SELECT long_desc FROM  bl_blng_serv_lang_vw WHERE language_id = '"+locale+"' AND blng_serv_code = '"+strBlngservCode+"'");
			}
			//pstmt2 = con.prepareStatement("SELECT SERV_ITEM_DESC FROM bl_patient_charges_folio WHERE blng_serv_code = '"+strBlngservCode+"' and SERV_ITEM_CODE = '"+strItemServCode+"'  and trx_doc_ref= '"+strTrxDocRef+"'  and trx_doc_ref_line_num= '"+strTrxDocRefLineNum+"'  and trx_doc_ref_seq_num='"+strTrxDocRefSeqNum+"'");
			rs2 = pstmt2.executeQuery();
			if ( rs2.next() && rs2 != null ) 
			{
				strblngservdesc =  rs2.getString(1);
			}		
			rs2.close();
			pstmt2.close();
			if(strblngservdesc == "" && strItemServCode != ""){
				pstmt3 = con.prepareStatement("SELECT long_desc FROM  bl_blng_serv_lang_vw WHERE language_id = '"+locale+"' AND blng_serv_code = '"+strBlngservCode+"'");
			rs3 = pstmt3.executeQuery();
			if ( rs3.next() && rs3 != null ) 
			{
				strblngservdesc =  rs3.getString(1);
			}	
			}
			if(rs3!=null && pstmt3!=null) {
			rs3.close();
			pstmt3.close();			
			}
		//Added by muthuN against 33583 on 9/25/2012 Ends Here	
			}
			catch(Exception e)
			{   
				e.printStackTrace();
				System.out.println("Exception in Drug Penalty query: "+e);
			}		
	%>
		<td class=<%=classval%> width="20%" class="fields"><input type='text' name='description<%=i%>' id='description<%=i%>' size='40' maxlength='100'  value='<%=strblngservdesc%>' readonly><input type='hidden' name='trx_doc_ref_seq_num<%=i%>' id='trx_doc_ref_seq_num<%=i%>' value="<%=strTrxDocRefSeqNum%>" > </td>
	<%
		}
		else
		{
			//Added by MuthuN against 33583 on 27-9-12
			if(strLongDesc == ""){
			pstmt3 = con.prepareStatement("SELECT long_desc FROM  bl_blng_serv_lang_vw WHERE language_id = '"+locale+"' AND blng_serv_code = '"+strBlngservCode+"'");
			rs3 = pstmt3.executeQuery();
			if ( rs3.next() && rs3 != null ) 
			{
				strLongDesc =  rs3.getString(1);
			}	
			}
			if(rs3!=null && pstmt3!=null) {
			rs3.close();
			pstmt3.close();			
			}
			//Added by MuthuN against 33583 on 27-9-12
	%>
		<td class=<%=classval%> width="20%" class="fields"><input type='text' name='description<%=i%>' id='description<%=i%>' size='40' maxlength='100'  value='<%=strLongDesc%>' readonly>
	
		<input type='hidden' name='trx_doc_ref_seq_num<%=i%>' id='trx_doc_ref_seq_num<%=i%>' value="<%=strTrxDocRefSeqNum%>" > </td>
	<%
		}
	%>
	<!--Added by muthu against Drug Penalty Issue on 04-06-12 Ends Here-->

	<td class=<%=classval%> width="5%" class="fields"><input type='text' name='serv_qty<%=i%>' id='serv_qty<%=i%>' size='5' maxlength='5'  value="<%=strServQty%>" style='text-align:right' onFocus='' readonly> </td>

	<td class=<%=classval%> width="11%" class="fields"><input type='text' name='charge_amt<%=i%>' id='charge_amt<%=i%>' size='11' maxlength='11'  value="<%=strUpdNetChargeAmt%>" style='text-align:right' onFocus='' readonly> </td>
	
	<td class=<%=classval%> width="11%" class="fields"><input type='text' name='settled_amt<%=i%>' id='settled_amt<%=i%>' size='11' maxlength='11'  value="<%=strTotalSettAmt%>" style='text-align:right'  onFocus='' readonly> </td>
	
	<td class=<%=classval%> width="11%" class="fields"><input type='text' name='pend_set<%=i%>' id='pend_set<%=i%>' size='11' maxlength='11'  value="<%=strPendStlmt%>" style='text-align:right' onFocus='' readonly><input type="hidden" name='pend_set_no_roundoff<%=i%>' id='pend_set_no_roundoff<%=i%>'  value="<%=strPendStlmtNoRoundOff%>"> </td>

	<td class=<%=classval%> width="11%" class="fields"><input type='text' name='curr_set<%=i%>' id='curr_set<%=i%>' size='11' maxlength='11'  value='' style='text-align:right' <%=readOnly %> onKeyPress='return(ChkNumberInput1(this,event,document.forms[0].noofdecimal.value))' <%="readonly".equals(readOnly)? "":"onBlur='putdeci(this);funCurStlmt()'" %>> </td>
<%
		}
		else
		{
%>
	<td class=<%=classval%> width="14%"><INPUT TYPE="TEXT" name='service_date<%=i%>' id='service_date<%=i%>' SIZE="15" MAXLENGTH="20" 	VALUE='<%=com.ehis.util.DateUtils.convertDate(strServiceDate,"DMYHMS","en",locale)%>'  onBlur='' readonly><input type='hidden' name='trx_doc_ref<%=i%>' id='trx_doc_ref<%=i%>' value='<%=strTrxDocRef%>' > </td>	
	
	<td class=<%=classval%> width="14%" >
		<input type='text' name='billing_service_desc<%=i%>' id='billing_service_desc<%=i%>' size='15' maxlength='20' value="<%=strBlngservCode%>" readonly>
			<%		
	/*Karthik added the below link to display Package Details */
	if(strPkgInd.equals("P")){ %>
		<a name='pkgLink_<%=i%>' id='pkgLink_<%=i%>' href="#" onClick ='openLinkScreen("<%=strBlngservCode%>","<%=strPkgSeqNo%>","<%=strPatientId%>");' > Dtls </a>
	<%} %>
		<input type='hidden' name='billing_service<%=i%>' id='billing_service<%=i%>' value="<%=strBlngservCode%>" readonly>
		<input type='hidden' name='trx_doc_ref_line_num<%=i%>' id='trx_doc_ref_line_num<%=i%>' value="<%=strTrxDocRefLineNum%>" > 
		<input type='hidden' name='trx_date<%=i%>' id='trx_date<%=i%>' value="<%=strTrxDate%>" > 
		<input type='hidden' name='prt_grp_hdr_code<%=i%>' id='prt_grp_hdr_code<%=i%>' value="<%=strPrtGrpHdrCode%>" > 
		<input type='hidden' name='prt_grp_line_code<%=i%>' id='prt_grp_line_code<%=i%>' value="<%=strPrtGrpLineCode%>" > 
		<input type='hidden' name='upd_net_charge_amt<%=i%>' id='upd_net_charge_amt<%=i%>' value="<%=strUpdNetChargeAmt%>" > 
		<input type='hidden' name='upd_gross_charge_amt<%=i%>' id='upd_gross_charge_amt<%=i%>' value="<%=strUpdGrossChargeAmt%>" > 
	</td>
	<td class=<%=classval%> width="20%" class="fields"><input type='text' name='description<%=i%>' id='description<%=i%>' size='25' maxlength='30'  value="<%=strLongDesc%>" readonly><input type='hidden' name='trx_doc_ref_seq_num<%=i%>' id='trx_doc_ref_seq_num<%=i%>' value="<%=strTrxDocRefSeqNum%>" > </td>
<% if(strBlngservCode.equals(unavail_service_code))
	{
				unavailed_yn="Y";
%>	
	<td class=<%=classval%> width="13%" class="fields"><input type='password' name='charge_amt<%=i%>' id='charge_amt<%=i%>' size='14' maxlength='10'  	value='<%=strUpdNetChargeAmt%>' style='text-align:center' onFocus='' readonly autocomplete="off"><!--V230508-41626 --></td>	
	<td class=<%=classval%> width="13%" class="fields"><input type='password' name='settled_amt<%=i%>' id='settled_amt<%=i%>' size='14' maxlength='10'  value='<%=strTotalSettAmt%>' style='text-align:center'  onFocus='' readonly autocomplete="off"><!--V230508-41626 --> </td>	
	<td class=<%=classval%> width="13%" class="fields"><input type='password' name='pend_set<%=i%>' id='pend_set<%=i%>' size='14' maxlength='10'  value='<%=strPendStlmt%>' style='text-align:center' onFocus='' readonly autocomplete="off"><!--V230508-41626 --><input type="hidden" name='pend_set_no_roundoff<%=i%>' id='pend_set_no_roundoff<%=i%>'  value="<%=strPendStlmtNoRoundOff%>"></td>
	<td class=<%=classval%> width="13%" class="fields"><input type='password' name='curr_set<%=i%>' id='curr_set<%=i%>' size='14' maxlength='10'  value=''  style='text-align:center' readonly autocomplete="off"><!--V230508-41626 -->	</td>
	<input type='hidden' name='unavailed_yn<%=i%>' id='unavailed_yn<%=i%>' value="<%=unavailed_yn%>" > 
	
<%	}else{

%>	
	<!--<td class=<%=classval%> width="20%" class="fields"><input type='text' name='description<%=i%>' id='description<%=i%>' size='25' maxlength='30'  value="<%=strLongDesc%>" readonly><input type='hidden' name='trx_doc_ref_seq_num<%=i%>' id='trx_doc_ref_seq_num<%=i%>' value="<%=strTrxDocRefSeqNum%>" > </td>-->
	
	<td class=<%=classval%> width="13%" class="fields"><input type='text' name='charge_amt<%=i%>' id='charge_amt<%=i%>' size='14' maxlength='10'  value='<%=strUpdNetChargeAmt%>' style='text-align:right' onFocus='' readonly> </td>
	
	<td class=<%=classval%> width="13%" class="fields"><input type='text' name='settled_amt<%=i%>' id='settled_amt<%=i%>' size='14' maxlength='10'  value='<%=strTotalSettAmt%>' style='text-align:right'  onFocus='' readonly> </td>
	
	<td class=<%=classval%> width="13%" class="fields"><input type='text' name='pend_set<%=i%>' id='pend_set<%=i%>' size='14' maxlength='10'  value='<%=strPendStlmt%>' style='text-align:right' onFocus='' readonly> <input type="hidden" name='pend_set_no_roundoff<%=i%>' id='pend_set_no_roundoff<%=i%>'  value="<%=strPendStlmtNoRoundOff%>"> </td>

	<td class=<%=classval%> width="13%" class="fields"><input type='text' name='curr_set<%=i%>' id='curr_set<%=i%>' size='14' maxlength='10'  value='' style='text-align:right' <%=readOnly %> onKeyPress='return(ChkNumberInput1(this,event,document.forms[0].noofdecimal.value))' <%="readonly".equals(readOnly)? "":"onBlur='putdeci(this);funCurStlmt()'" %>> </td>

<%	
	}
					}
%>	
</tr>
<%
					total_records++;
					i++;	
				}
				if(rs1 != null) rs1.close();
				pstmt1.close();
			}
			if(rs != null) rs.close();
			pstmt.close();
		}
		catch(Exception e) 
		{
			System.out.println("Error:"+e);
		}
		
%>  
	<tr> 
		<!--<td class="label" colspan="1" ><div align='right'>TOTAL</div></td>
			<td width='14%' class="fields"><input type='text' name='net_total' id='net_total' size='13' maxlength='30' 
			value='<%=str_total_net_charge%>'  style='text-align:right' readonly ></td>

				<td class="label" colspan="" ><div align='right'>Round-Off</div>
			<td width='4%' class="fields"><input type='text' name='round_off' id='round_off' size='15' maxlength='30' 
			value='<%=strroundingamt%>'  style='text-align:right' readonly ></td>-->
		
	<%
		if(strmoduleid.equals("PH") || strmoduleid.equals("ST"))  //&& (strfunctionid.equals("DIS")|| strfunctionid.equals("")))
		{
%>
			<td class="label" colspan="2" ><div align='right'>Round-Off</div>
			<td width='4%' class="fields"><input type='text' name='round_off' id='round_off' size='15' maxlength='30' 
			value='<%=strroundingamt%>'  style='text-align:right' readonly ></td>
			<td class="label" colspan="" ><div align='right'>Total</div>
			<td width='14%' class="fields"><input type='text' name='net_total' id='net_total' size='13' maxlength='30' 
			value='<%=str_total_net_charge%>'  style='text-align:right' readonly ></td>
		
			 <td class="label" colspan="2" ><div align='right'><fmt:message key="eBL.SETTLED_AMOUNT.label" bundle="${bl_labels}"/></div></td>
			 <td width='11%' class="fields"><input type='text' name='tot_curr_stlmt' id='tot_curr_stlmt' size='11' maxlength='30' 
			 value=''  style='text-align:right' readonly ></td>
<%
		}
		else
		{

%>
			<td class="label" colspan="1" ><div align='right'>Round-Off</div>
			<td width='4%' class="fields"><input type='text' name='round_off' id='round_off' size='15' maxlength='30' 
			value='<%=strroundingamt%>'  style='text-align:right' readonly ></td>
		
			<td class="label" colspan="" ><div align='right'>Total</div>
			<td width='14%' class="fields"><input type='text' name='net_total' id='net_total' size='13' maxlength='30' 
			value='<%=str_total_net_charge%>'  style='text-align:right' readonly ></td>

			<td class="label"  colspan="2" ><div align='right'><fmt:message key="eBL.SETTLED_AMOUNT.label" bundle="${bl_labels}"/></div></td>
			<td width='14%' class="fields"><input type='text' name='tot_curr_stlmt' id='tot_curr_stlmt' size='13' maxlength='30' 
			value=''  style='text-align:right' readonly ></td>

<%
		}
%>
	</tr>
<%	
	}catch(Exception e) 
	{ 
	}
	finally 
	{			
		ConnectionManager.returnConnection(con, request);	
	}
%>	
</tbody>
</table>
</div>
<input type="hidden" name='tot_curr_stlmt_no_roundoff' id='tot_curr_stlmt_no_roundoff'  value=''>
<INPUT TYPE="HIDDEN" name="pagecloseind" id="pagecloseind"   SIZE="50" MAXLENGTH="100" 	VALUE="0">	
<INPUT TYPE="HIDDEN" name="slmtdate" id="slmtdate"	   SIZE="20" MAXLENGTH="20" 	VALUE=""> 
<INPUT TYPE="HIDDEN" name="slmtdocrefdesc" id="slmtdocrefdesc" SIZE="50" MAXLENGTH="100"	VALUE="">	
<INPUT TYPE="HIDDEN" name="slmtdocref" id="slmtdocref"	   SIZE="50" MAXLENGTH="100" 	VALUE="">
<INPUT TYPE="HIDDEN" name="str_ext_acc_facility_id" id="str_ext_acc_facility_id" SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_ext_acc_facility_id%>'>
<INPUT TYPE="HIDDEN" name="strfacilityid" id="strfacilityid"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=strfacilityid%>'>
<input type= "hidden" name="locale" id="locale"  value='<%=locale%>'>
<input type= "hidden" name="noofdecimal" id="noofdecimal"  value='<%=noofdecimal%>'>
<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>
<input type='hidden' name="strroundingamt" id="strroundingamt" value='<%=strroundingamt%>'>
<input type='hidden' name="slmt_amt_disabled_YN" id="slmt_amt_disabled_YN" value='<%=slmt_amt_disabled_YN%>'>
<input type='hidden' name="called_frm" id="called_frm"  value='<%=called_frm%>'>
<input type='hidden' name="alw_co_wit_bl_slmt_yn" id="alw_co_wit_bl_slmt_yn"  value='<%=alw_co_wit_bl_slmt_yn%>'>
<INPUT TYPE="HIDDEN" name="str_episode_type" id="str_episode_type"	   SIZE="50" MAXLENGTH="100" 	VALUE='<%=str_episode_type%>'>
<input type='hidden' name='amtRoundOff' id='amtRoundOff' id='amtRoundOff' value='<%=amtRoundOff%>'>
</FORM>	

</BODY>
</HTML>

