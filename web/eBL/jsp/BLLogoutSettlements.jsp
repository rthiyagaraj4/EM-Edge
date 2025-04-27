
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<!-- 
currencyFormat() JS Method was replaced by putDecimal() on 8/19/2008 by manivel for ICN 5134
-->
<%
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	CurrencyFormat cf = new CurrencyFormat();
	String facility_id = "";
	String login_user = "";
	String cashcounter = "";
	String called_frm = "";
	String hand_without_counter_chk_out = "";

	//unused variable, commented on 09/06/05
	//int intMaxCount = 14;
	//int intCount = 0;

	double doubleCreditAmt = 0.0;
	double doubleCashBillAmt = 0.0;
	
	double doubleTotReceiptAmt = 0.0;
	double doubleTotCancelAmt = 0.0;
	double doubleOpeningBalance = 0.0;
	int integerCashBillCnt=0;
	int integerCreditBillCnt=0;
	int noofdecimal=2;
	double totcash=0;
	double totcheq=0;
	int rowCount=0; //sarathkumar defined field make as siteSpecific GDOH-CRF-0117
	
	String strErrorLevel="";
	String strSysMessageId="";
	String strErrorText="";
	String slmt_flag="";	

	String strSlmtArray = "";
	String strCreditAmt = "0";
	String strCashBillAmt  = "0";
	String strOpeningBalance="0";
	String login_time = "0";
	String logout_time = "0";
	String strCashBillCnt="0";
	String strCreditBillCnt="0";
	String strCashHandedOver="",strcheqHandedOver="";
	
	String stmtcode="";
	String cash_ctr_logout_with_cb_yn="",cash_ctr_logout_rep_ind="";
	Connection con = null;
	request.setCharacterEncoding("UTF-8");
	try
	{
		//Connection 
		con = ConnectionManager.getConnection(request);
		String locale	= (String)session.getAttribute("LOCALE");
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");
		cashcounter = (String)request.getParameter("cashcounter");
		login_time = (String)request.getParameter("login_time");		
		login_time=com.ehis.util.DateUtils.convertDate(login_time,"DMYHMS",locale,"en");

		called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";
		//System.out.println("login_time :"+login_time);
	}
	catch(Exception eX)
	{
			out.println("Error= "+eX);
	}
	try
	{
		PreparedStatement pstmt = null;
		ResultSet rscurr=null;
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{
			noofdecimal  =  rscurr.getInt(1);		
		}	
		rscurr.close();
		pstmt.close();
	}
	catch(Exception e)
	{
	 System.out.println("3="+e.toString());
	}


	
	String ss=session.getAttribute("ssv").toString(); //sarathkumar added code make as siteSpecific GDOH-CRF-0117...
%>

<html>
<head>
	<script language='javascript' src='../js/BLAmount.js'></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script> 
function funClosingBal(f_mode)
{
	var obj='';
	var act_value=0;
	var noofdecimal = document.forms[0].noofdecimal.value;
	var slmt_flag_value="";
	var slmt_flag_arr = new Array();
	slmt_flag_value = document.forms[0].slmt_flag.value;
	slmt_flag_arr = slmt_flag_value.split("|");		
	var slmt_array = funGetSettlmentArray();	
	if(f_mode=='ONB')
	{		
		for (i=0;i<slmt_array.length-1;i++)
		{
			obj = eval('document.forms[0].'+slmt_array[i]+'_act');			
			act_value = obj.value;
			if(act_value=="")act_value=0;
			if (slmt_flag_arr[i] == "Y"	)
			{		
				parent.report_frame.document.forms[0].tot_closing_bal.value = parseFloat(document.forms[0].tot_opening_bal.value) +parseFloat(act_value);	
				
			}
		}
	}else{		
		parent.report_frame.document.forms[0].tot_closing_bal.value = eval(document.forms[0].tot_opening_bal.value) +eval(document.forms[0].tot_act.value);
	}
//	currencyFormat(parent.report_frame.document.forms[0].tot_closing_bal);
	putDecimal(parent.report_frame.document.forms[0].tot_closing_bal,17,noofdecimal);
}
function funSetAmt()
{
	var noofdecimal = document.forms[0].noofdecimal.value;

	parent.report_frame.document.forms[0].tot_credit_bills_amt.value = document.forms[0].tot_credit_bills_amt.value;
	parent.report_frame.document.forms[0].tot_cash_bills_amt.value = document.forms[0].tot_cash_bills_amt.value;
	parent.report_frame.document.forms[0].tot_opening_bal.value = document.forms[0].tot_opening_bal.value;
	parent.report_frame.document.getElementById("cash_bill_cnt1").innerText = parent.detail_frame.document.forms[0].cash_bill_cnt.value;	
	parent.report_frame.document.getElementById("credit_bill_cnt1").innerText = parent.detail_frame.document.forms[0].credit_bill_cnt.value;	
//	currencyFormat(parent.report_frame.document.forms[0].tot_cash_bills_amt);
//	currencyFormat(parent.report_frame.document.forms[0].tot_credit_bills_amt);
//	currencyFormat(parent.report_frame.document.forms[0].tot_opening_bal);
	putDecimal(parent.report_frame.document.forms[0].tot_cash_bills_amt,17,noofdecimal);
	putDecimal(parent.report_frame.document.forms[0].tot_credit_bills_amt,17,noofdecimal);
	putDecimal(parent.report_frame.document.forms[0].tot_opening_bal,17,noofdecimal);
//	parent.report_frame.document.forms[0].cashcnt.value = document.forms[0].cash_bill_cnt.value;
	//parent.report_frame.document.forms[0].credit_bill_cnt.value = document.forms[0].credit_bill_cnt.value;

	funClosingBal('ONL');
	
}

function putDecimal_local(Obj,maxvalue,deci)
{
var temp1=Obj;
var temp4=Obj.length;
var count=parseInt(maxvalue) -parseInt(deci);
if (parseInt(deci) > 0)
{
if(temp1.indexOf('.') <0)
{
	if (temp4 <= parseInt(maxvalue))
	{
		if(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
		{
			var temp2=temp1.substring(0,count);
			var temp3=temp2+"."+temp1.substring(count,temp1.length)
			if(temp3.length-1 < parseInt(maxvalue))
			{
				for(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)
				{
				temp3+="0";
				}
			}
return temp3;
		}
         
		else if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
		{
		var temp3=temp1+'.';
		for(var m=0;m<deci;m++)
		temp3+="0";
return temp3;
		
		}
      if (temp1.length == 0 )
	 {
	 		temp3="0.";
			for(var m=0;m<deci;m++)
			temp3+="0";
return temp3;
	 
	 }
   
 
 }

}
else
   {
	
	var temp5=temp1.indexOf('.');
	var temp7=temp1.substring(0,temp5);
	var temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));
	if(temp6.length >1)
	   {
	return temp7+"."+temp6;
	   }else
	   {
	return temp7+"."+temp6+"0";
	   }
   }
 }
}

function funGetSettlmentArray()
{
	var slmt_array = new Array();
	var slmt_array_value = document.forms[0].slmt_array.value;
	slmt_array = slmt_array_value.split("|");	
	return(slmt_array);
}

function funActualAmountCheck(obj)
{
	var noofdecimal = document.forms[0].noofdecimal.value;
	var res = checkNumber(obj);
	
	var arr = new Array();
	arr = obj.name.split('_');

	var objDis = eval('document.forms[0].'+arr[0]+'_dis');
	
	var objRcp = eval('document.forms[0].'+arr[0]+'_rcp');

	var objCan = eval('document.forms[0].'+arr[0]+'_can');
//added for crf-13
	//var orgrcp = eval('document.forms[0].'+arr[0]+'_orgrcp');
	var objhoa = eval('document.forms[0].'+arr[0]+'_hoa');
	if(	objDis.value == 0 || objDis.value ==""){	
		//alert("Discr does not  exists");
//		obj.value=0;
		eval('document.forms[0].'+arr[0]+'_dis').value= parseFloat(objRcp.value) - (parseFloat(objCan.value)+parseFloat(objhoa.value));
	}
	
	if (res == true)
	{
		//added for crf-13 commented line 225 and added line 233
//		var diffAmt = parseFloat(objRcp.value) - (parseFloat(objCan.value);
		var diffAmt = parseFloat(objRcp.value) - (parseFloat(objCan.value)+parseFloat(objhoa.value));
		

	//	var diffAmt = parseFloat(orgrcp.value) - parseFloat(objCan.value);
		diffAmt = Math.round(diffAmt*100)/100;
		if(	objDis.value !=0){			
		objDis.value = 	diffAmt - obj.value;//changed
				
	}
//		currencyFormat(obj);
//		currencyFormat(objDis);
		putDecimal(obj,17,noofdecimal);
		putDecimal(objDis,17,noofdecimal)
	}

	var slmt_array = funGetSettlmentArray();
	var tot_act = 0;
	var tot_dis = 0;
	for (i=0;i<slmt_array.length;i++)
	{
		if ( (slmt_array[i] == null) || (slmt_array[i] =='')) break;
			obj = eval('document.forms[0].'+slmt_array[i]+'_act');			
			tot_act = tot_act + eval(((obj.value==null)||(obj.value==''))? 0 : obj.value);
			obj = eval('document.forms[0].'+slmt_array[i]+'_dis');			
			tot_dis = tot_dis + eval(((obj.value==null)||(obj.value==''))? 0 : obj.value);
	}
	
	document.forms[0].tot_act.value = tot_act;
	document.forms[0].tot_dis.value = tot_dis;
//	currencyFormat(document.forms[0].tot_act);
//	currencyFormat(document.forms[0].tot_dis);
	putDecimal(document.forms[0].tot_act,17,noofdecimal);
	putDecimal(document.forms[0].tot_dis,17,noofdecimal);	
	funClosingBal('ONB');
	
}
function totDisActAmt()
{
	var noofdecimal = document.forms[0].noofdecimal.value;
	var slmt_array = funGetSettlmentArray();
	var tot_act = 0;
	var tot_dis = 0;
	var tot_hao = 0;
	for (i=0;i<slmt_array.length;i++)
	{
		if ( (slmt_array[i] == null) || (slmt_array[i] =='')) break;
			obj = eval('document.forms[0].'+slmt_array[i]+'_act');
			tot_act = tot_act + eval(((obj.value==null)||(obj.value==''))? 0 : obj.value);
			

			obj = eval('document.forms[0].'+slmt_array[i]+'_hoa');
			tot_hao = tot_hao + eval(((obj.value==null)||(obj.value==''))? 0 : obj.value);
			


			obj = eval('document.forms[0].'+slmt_array[i]+'_dis');			
			tot_dis = tot_dis + eval(((obj.value==null)||(obj.value==''))? 0 : obj.value);

			
	}
	
	document.forms[0].tot_act.value = tot_act;
	document.forms[0].tot_dis.value = tot_dis;
	document.forms[0].tot_hoa.value = tot_hao;
//	currencyFormat(document.forms[0].tot_act);
//	currencyFormat(document.forms[0].tot_dis);
	putDecimal(document.forms[0].tot_act,17,noofdecimal);
	putDecimal(document.forms[0].tot_dis,17,noofdecimal);	
	putDecimal(document.forms[0].tot_hoa,17,noofdecimal);	

}
function cal_tot_hoAmt()
{
	var noofdecimal = document.forms[0].noofdecimal.value;
	var slmt_flag_value="";
	var slmt_flag_arr = new Array();
	slmt_flag_value = document.forms[0].slmt_flag.value;
	slmt_flag_arr = slmt_flag_value.split("|");		
	var totCash = 0;
	var totCheq = 0;
	var totCash = parseFloat(document.forms[0].cashHandedOver.value);
	
	var totCheq = parseFloat(document.forms[0].cheqHandedOver.value);	
	
	var hoamt=0;
	var slmt_array = funGetSettlmentArray();	
	for (i=0;i<slmt_array.length;i++)
	{			
		obj = eval('document.forms[0].'+slmt_array[i]+'_rcp');		
		if(totCheq>0){
		if (slmt_flag_arr[i] == "B"	)
		{
			if(obj.value >totCheq)
			{	
				hoamt = totCheq
				eval('document.forms[0].'+slmt_array[i]+'_hoa').value=hoamt;				
				totCheq=0;
				putDecimal(eval('document.forms[0].'+slmt_array[i]+'_hoa'),17,noofdecimal);
				

			}else{					
					hoamt=obj.value;					
					eval('document.forms[0].'+slmt_array[i]+'_hoa').value=hoamt;
					totCheq=totCheq-obj.value;
					//eval('document.forms[0].'+slmt_array[i]+'_orgrcp').value=totCheq;
					putDecimal(eval('document.forms[0].'+slmt_array[i]+'_hoa'),17,noofdecimal);
				}
		}
		}
	if(totCash>0){		
	if (slmt_flag_arr[i] == "Y"	)
		{	
			if(obj.value >totCash)
			{
				hoamt = totCash
				eval('document.forms[0].'+slmt_array[i]+'_hoa').value=hoamt;
				totCash=0;
				putDecimal(eval('document.forms[0].'+slmt_array[i]+'_hoa'),17,noofdecimal);
			}else{
					hoamt=obj.value;
					eval('document.forms[0].'+slmt_array[i]+'_hoa').value=hoamt;
					totCash=totCash-obj.value;		
					putDecimal(eval('document.forms[0].'+slmt_array[i]+'_hoa'),17,noofdecimal);
				}
		}	
	}
		
			
		if(totCheq==0 && totCash==0)break;	
	}
			var v_hao=0;
			var v_rcp=0;
			var v_hoa=0;
			var v_can=0;
			for (i=0;i<slmt_array.length;i++)
			{	
				/*if(slmt_flag_arr[i]!=""){
				if (slmt_flag_arr[i] != "B"	|| slmt_flag_arr[i] != "Y")
				{
					eval('document.forms[0].'+slmt_array[i]+'_orgrcp').value=eval('document.forms[0].'+slmt_array[i]+'_rcp').value;
				}
				}*/

				if (slmt_flag_arr[i] == "B"	|| slmt_flag_arr[i] == "Y"){
					v_hao = parseFloat(eval('document.forms[0].'+slmt_array[i]+'_hoa').value);
					v_rcp = parseFloat(eval('document.forms[0].'+slmt_array[i]+'_rcp').value);
					v_can = parseFloat(eval('document.forms[0].'+slmt_array[i]+'_can').value);					
					if(v_hao!=""){
					eval('document.forms[0].'+slmt_array[i]+'_dis').value = v_rcp-(v_can+v_hao);
						putDecimal(eval('document.forms[0].'+slmt_array[i]+'_dis'),17,noofdecimal);
						//eval('document.forms[0].'+slmt_array[i]+'_orgrcp').value=v_rcp-v_hao;
					}else{
						eval('document.forms[0].'+slmt_array[i]+'_dis').value = eval('document.forms[0].'+slmt_array[i]+'_rcp').value-v_can;
						//eval('document.forms[0].'+slmt_array[i]+'_orgrcp').value=eval('document.forms[0].'+slmt_array[i]+'_rcp').value;
						putDecimal(eval('document.forms[0].'+slmt_array[i]+'_dis'),17,noofdecimal);
						}
				}
				/*if(slmt_flag_arr[i]!="")
				{			
				if (slmt_flag_arr[i] != "B"	|| slmt_flag_arr[i] != "Y")
				{
					eval('document.forms[0].'+slmt_array[i]+'_orgrcp').value=eval('document.forms[0].'+slmt_array[i]+'_rcp').value;
				}
				}*/

	}
}

function funFormat()
{
	

		var noofdecimal = document.forms[0].noofdecimal.value;
		var logoutSuccesful = getMessage('BL9322','BL');	
		var logoutSubmit = getMessage('BL9323','BL');
		//document.write(alert(logoutSuccesful));
		document.forms[0].logoutSuccesful.value=logoutSuccesful;
		document.forms[0].logoutSubmit.value=logoutSubmit;
		

//	alert(document.form(0).str.value);

	
	var slmt_array = funGetSettlmentArray();
	var obj = new Object();

	for (i=0;i<slmt_array.length;i++)
	{
		if ( (slmt_array[i] == null) || (slmt_array[i] =='')) break;
		obj = eval('document.forms[0].'+slmt_array[i]+'_can');
//		currencyFormat(obj);
		putDecimal(obj,17,noofdecimal);
		obj = eval('document.forms[0].'+slmt_array[i]+'_rcp');
//		currencyFormat(obj);
		putDecimal(obj,17,noofdecimal);	

	}
		var tot_can = document.forms[0].tot_can;
		var tot_rcp = document.forms[0].tot_rcp;	
//		currencyFormat(tot_can);
		putDecimal(tot_can,17,noofdecimal);
//		currencyFormat(tot_rcp);
		putDecimal(tot_rcp,17,noofdecimal);
		funSetAmt();
		cal_tot_hoAmt(); //added for CRF -13
		totDisActAmt();
	
	
}

function funValidate()
{
	var cashcounter = parent.top_frame.document.forms[0].cashcounter.value;
	if ( (cashcounter == '') || (cashcounter == null) ||(cashcounter == ' ') )	
	{	
		alert(getMessage('BL9538','BL'));
		return(false);
	}
		var slmt_array = funGetSettlmentArray();
	
		for (i=0;i<slmt_array.length;i++)
		{
			if ( (slmt_array[i] == null) || (slmt_array[i] =='')) break;
	
			obj = eval('document.forms[0].'+slmt_array[i]+'_dis');
				
			if (!((obj.value == null) || (obj.value =='') || (obj.value == 0) ))
			{
				alert(getMessage('BL1288','BL'));
				return(false);
			}
/*
			else
			{
				return(true);
			}
*/
		}
	return(true);
}


function funActCanAmtCheck(obj)
{	
	var arr = new Array();
	arr = obj.name.split('_');
	var objCan = eval('document.forms[0].'+arr[0]+'_can');
	var objRcp = eval('document.forms[0].'+arr[0]+'_rcp');
	var objAct = eval('document.forms[0].'+arr[0]+'_act');
	var objDis = eval('document.forms[0].'+arr[0]+'_dis');
	//added for crf-13
	//var objorgrcp = eval('document.forms[0].'+arr[0]+'_orgrcp');
	var objhoa = eval('document.forms[0].'+arr[0]+'_hoa');
		 
	var canAmt = objCan.value;
	var rcpAmt = objRcp.value;
	var actAmt = objAct.value
	var disAmt = objDis.value;
//added for crf-13
	//var orgrcp = objorgrcp.value;
	var hoaAmt = objhoa.value;

// Added by manivel on 8/19/2008 for ICN 5134
//added for crf-13 commented line 474 and added line 475
//	var diffAmt = parseFloat(rcpAmt) - parseFloat(canAmt);
	var diffAmt = parseFloat(rcpAmt) - (parseFloat(canAmt)+parseFloat(hoaAmt));

  //var diffAmt = parseFloat(orgrcp) - parseFloat(canAmt);
	diffAmt = Math.round(diffAmt*100)/100;

	if(actAmt!=0 && (diffAmt)!=actAmt)
	{
		//alert('Discrepency exits, Cannot Close Cash Counter');
		
		alert(getMessage('BL1288','BL'));
		objAct.focus();
	}
	
}
	
//sarathkumar added below script make as siteSpecific GDOH-CRF-0117 beginning...
$(document).ready(function(){
	if($('#SiteSpecific').val() == 'true'){
		var rowcount=$('#rowCounts').val();
		var i=1;
		for(i=1;i<=rowcount;i++){	
			$('#actamt_'+i).val($('#disamt_'+i).val());
			$('#actamt_'+i).focus();
			$('#actamt_'+i).blur();			
		}	
	}
});
////sarathkumar added rowCount make as siteSpecific GDOH-CRF-0117 ending.

</script>
</head>
<body  onLoad='funFormat()'>
	<form name='settlement_form' id='settlement_form' action='../../servlet/eBL.BLLogoutSettlementsServlet' target='dummy_frame' method='post'>
	<center>

		<table border="1" width="100%" cellspacing='0' cellpadding='3'>
		<!--<td width='5%' class="COLUMNHEADER" ><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
		<td width='15%' class="COLUMNHEADER"></td>
        <td width='15%' class="COLUMNHEADER"><fmt:message key="Common.TotalCount.label" bundle="${common_labels}"/></td>
		<td width='15%' class="COLUMNHEADER"><fmt:message key="eBL.CANCELLED_COUNT.label" bundle="${bl_labels}"/></td>
		<td width='15%' class="COLUMNHEADER"><fmt:message key="eBL.BOUNCED_COUNT.label" bundle="${bl_labels}"/></td>
		<td width='15%' class="COLUMNHEADER"><fmt:message key="eBL.CANCEL_AMT.label" bundle="${bl_labels}"/></td>	
		<td width='15%' class="COLUMNHEADER"><fmt:message key="eBL.RECEIPT_AMT.label" bundle="${bl_labels}"/> </td>
		<td width='15%' class="COLUMNHEADER"><fmt:message key="eBL.ACTUAL_AMT.label" bundle="${bl_labels}"/> </td>
		<td width='15%' class="COLUMNHEADER"><fmt:message key="eBL.DISCREPANCY_AMT.label" bundle="${bl_labels}"/></td>
		-->
		<TR>
		<td width='28%' class="COLUMNHEADER" colspan="9"><fmt:message key="eBL.SETTLEMENT_WISE_COLLECTION.label" bundle="${bl_labels}"/></td>
		</TR>
		<TR>		
		<td width='28%' class="COLUMNHEADER" ><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
        <td width='7%' class="COLUMNHEADER"><fmt:message key="Common.TotalCount.label" bundle="${common_labels}"/></td>
		<td width='7%' class="COLUMNHEADER"><fmt:message key="eBL.CANCELLED_COUNT.label" bundle="${bl_labels}"/></td>
		<td width='7%' class="COLUMNHEADER"><fmt:message key="eBL.BOUNCED_COUNT.label" bundle="${bl_labels}"/></td>
		<td width='10%' class="COLUMNHEADER"><fmt:message key="eBL.CANCEL_AMT.label" bundle="${bl_labels}"/></td>	
		<td width='10%' class="COLUMNHEADER"><fmt:message key="eBL.RECEIPT_AMT.label" bundle="${bl_labels}"/> </td>
		<td width='10%' class="COLUMNHEADER"><fmt:message key="eBL.ACTUAL_AMT.label" bundle="${bl_labels}"/> </td>
		<td width='11%' class="COLUMNHEADER"><fmt:message key="eBL.HO_AMOUNT.label" bundle="${bl_labels}"/></td>
		<td width='10%' class="COLUMNHEADER"><fmt:message key="eBL.DISCREPANCY_AMT.label" bundle="${bl_labels}"/></td>		
		</TR>
		<tr>
<%
	try
	{			
		
			try{
				String sql1 = "	SELECT nvl(CASH_REQUEST_AMT,0),nvl(CHQ_REQUEST_AMT,0) FROM bl_handed_reqt WHERE LOGIN_DATE_TIME=(SELECT LOGIN_DATE_TIME FROM   BL_CASH_COUNTER_SLMT_HDR WHERE  OPERATING_FACILITY_ID = '"+facility_id+"'	AND    CASH_COUNTER_USER_ID  = '"+login_user+"' AND    LOGOUT_DATE_TIME     IS NULL) AND STATUS='A' ";
//				System.out.println("sql1 gfdgdgdf :"+sql1);
				PreparedStatement pstmt = con.prepareStatement(sql1);														
				ResultSet rs = pstmt.executeQuery() ;
					while(rs.next())
					{											
						strCashHandedOver = rs.getString(1);						
						strcheqHandedOver = rs.getString(2);
						totcash =totcash + Double.parseDouble(strCashHandedOver);
						totcheq =totcheq + Double.parseDouble(strcheqHandedOver);
					}						
					rs.close();
					pstmt.close();
			}catch(Exception e)
					{
						//out.println("Error request chk GET ctr = "+e);
						//System.out.println("Error request chk GET ctr :"+e);
						e.printStackTrace();
					}	
		try
		{
			String sql1 = 	" SELECT   SUM(NVL(x.receipt_amt,0)) receipt_amt, "+
			"	SUM(NVL(x.cancel_amt,0))  cancel_amt, "+
			"	x.slmt_type_code, "+
			"	y.cash_slmt_flag, "+
			"	y.SHORT_DESC, "+
			" SUM(tot_cnt) TOTAL_CNT, SUM(can_cnt) CANCEL_CNT,  SUM(bou_cnt) BOUNCED_CNT "+
			" FROM	"+
			" (	 SELECT 		NVL(a.doc_amt,0) receipt_amt, "+
			"	0                cancel_amt, "+
			"	a.SLMT_TYPE_CODE slmt_type_code, 1 tot_cnt, 0 can_cnt, 0 bou_cnt  "+
			"	FROM bl_receipt_refund_hdrdtl_vw a  	 "+				 
			"	WHERE  a.cash_counter_facility_id = ?  "+    //1	facility_id
			"	AND   a.recpt_refund_ind IS NOT NULL  "+
			"	AND   a.cash_counter_code     = ?	"+	 //2 cashcounter
			"	AND   a.doc_date              BETWEEN to_date(?,'dd/mm/yyyy hh24:mi:ss') AND "+	 // 3 login_date_time
			"	SYSDATE				"+		
			"	AND a.cash_ctrl_doc_type_code IS NULL "+
			"	UNION ALL "+
			"	SELECT 		0  receipt_amt,  "+
			"	NVL(a.doc_amt,0) cancel_amt, "+
			"	a.SLMT_TYPE_CODE  slmt_type_code, 1 tot_cnt, " + 
			"   decode(b.cancelled_ind,'Y',1,0) can_cnt, decode(b.bounced_yn,'Y',1,0) bou_cnt " +
			"	FROM      bl_receipt_refund_hdrdtl_vw a , bl_cancelled_bounced_trx b "+
			"	WHERE     b.cash_counter_facility_id = ? "+	// 4 facility_if
			"	AND       b.recpt_refund_ind IS NOT NULL  "+
			"	AND       b.cash_counter_code     = ?	"+	//5 cashcounter
			"	AND   b.cancelled_date             BETWEEN  to_date(?,'dd/mm/yyyy hh24:mi:ss')   AND  "+ //6 login_time
			"	SYSDATE	"+				
			"	AND  a.doc_type_code = b.doc_type_code "+
			"	AND  a.doc_number = b.doc_number "+
			"	AND  a.DOC_SRNO = b.DOC_SRNO "+
			"	AND b.cash_ctrl_doc_type_code IS NULL "+
			" ) x, "+
			" bl_slmt_type y, sy_acc_entity z "+
			" WHERE x.slmt_type_code = y.slmt_type_code "+
			" AND   z.acc_entity_id = ?  "+
			" AND   y.acc_entity_code = z.acc_entity_code  "+
			" GROUP BY x.SLMT_TYPE_CODE,cash_slmt_flag,Y.short_Desc ";


			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, facility_id);
			pstmt.setString(2,cashcounter);
			pstmt.setString(3, login_time);
			pstmt.setString(4, facility_id);	
			pstmt.setString(5,cashcounter);
			pstmt.setString(6, login_time);
			pstmt.setString(7, facility_id);


			ResultSet rs = pstmt.executeQuery() ;

			//unused variable, commented on 09/06/05
			//String strColorClass = "QRYODD";
			boolean alternate = true;
			while(rs.next())
			{
				rowCount++; //sarathkumar added rowCount make as siteSpecific GDOH-CRF-0117
				
				if (alternate)
				{
					alternate = false;
					//strColorClass = "QRYODD";
				}
				else
				{
					alternate = true;
					//strColorClass = "QRYEVEN";
				}
				strSlmtArray = strSlmtArray+rs.getString(3)+"|";
				//System.out.println("strSlmtArray :"+strSlmtArray);

				slmt_flag = slmt_flag+rs.getString(4)+"|";
			 	//System.out.println("slmt_flag :"+slmt_flag);
				

			
				
				//out.println("<table border='0' width='100%' cellspacing='0' cellpadding='3'>");
				
				
				out.println("<tr>");
				
									
							
			 stmtcode=rs.getString(3);
			 

			//out.println("<td width='4%' class='label'>"+"<input type='text' readonly name='"+rs.getString(3)+"' id='"+rs.getString(3)+"' maxlength='3' size='3' tabindex='0' value='"+rs.getString(3)+"' > </td>");
			out.println("<input type='HIDDEN' readonly name='"+rs.getString(3)+"' id='"+rs.getString(3)+"' value='"+rs.getString(3)+"' > ");
			out.println("<td width='28%' class='label' size='36' > <b>"+rs.getString(5)+"</b></td>");
			out.println("<td width='7%'class='fields'>"+"<input type='text' style='text-align:right'  readonly name='' id='' maxlength='25' size='5' tabindex='0' value='"+rs.getString(6)+"'> </td>");
			out.println("<td width='7%'  class='fields'>"+"<input type='text' style='text-align:right'  readonly name='' id='' maxlength='25' size='5' tabindex='0' value='"+rs.getString(7)+"'> </td>");
			out.println("<td  width='7%' class='fields'>"+"<input type='text' style='text-align:right'  readonly name='' id='' maxlength='25' size='5' tabindex='0' value='"+rs.getString(8)+"'> </td>");
			out.println("<td width='10%'  class='fields'>"+"<input type='text' style='text-align:right' readonly name='"+rs.getString(3)+"_can' id='"+rs.getString(3)+"_can'  maxlength='15' size='12' tabindex='0' value='"+cf.formatCurrency(String.valueOf(Double.parseDouble(rs.getString(2))),noofdecimal)+"'  onBlur='funActCanAmtCheck(this)'> </td>");
			out.println("<td width='10%'  class='fields'>"+"<input type='text' style='text-align:right' readonly name='"+rs.getString(3)+"_rcp' id='"+rs.getString(3)+"_rcp' maxlength='15' size='12' tabindex='0' value='"+cf.formatCurrency(String.valueOf(Double.parseDouble(rs.getString(1))),noofdecimal)+"' onBlur='funActCanAmtCheck(this)'> </td>");
			//sarathkumar added id actamt_  disamt_ make as siteSpecific GDOH-CRF-0117
			out.println("<td  width='10%' class='fields'>"+"<input type='text' style='text-align:right' name='"+rs.getString(3)+"_act' id='"+rs.getString(3)+"_act'  id='actamt_"+rowCount+"'  maxlength='15' size='10' tabindex='0' value=''  onBlur='funActualAmountCheck(this);funActCanAmtCheck(this)'> </td>");	
			//out.println("<input type='HIDDEN' readonly name='"+rs.getString(3)+"_orgrcp' id='"+rs.getString(3)+"_orgrcp' value='' > ");
			out.println("<td  width='11%' class='fields'>"+"<input type='text' style='text-align:right' name='"+rs.getString(3)+"_hoa' id='"+rs.getString(3)+"_hoa' maxlength='15' size='11' tabindex='0' value='0.00' onBlur='' readonly> </td>");
			
			out.println("<td  width='10%' class='fields'>"+"<input type='text' style='text-align:right'  readonly name='"+rs.getString(3)+"_dis' id='"+rs.getString(3)+"_dis' id='disamt_"+rowCount+"' maxlength='15' size='10' tabindex='0' value='"+cf.formatCurrency(String.valueOf(Double.parseDouble(rs.getString(1))-Double.parseDouble(rs.getString(2))),noofdecimal)+"'  onBlur='funActCanAmtCheck(this)'> </td>");

				out.println("</tr>");
				 


				doubleTotReceiptAmt = doubleTotReceiptAmt + rs.getDouble(1);
				doubleTotCancelAmt  = doubleTotCancelAmt +  rs.getDouble(2);
				


			}

			
			rs.close();
			pstmt.close();
			if(!cashcounter.equals(""))
			{
			try
				{
					CallableStatement call = con.prepareCall("{ call bl_cash_counter_check.cash_credit_amt(?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?) }");						

					

					call.setString(1,facility_id);
					call.setString(2,login_user);
					call.setString(3,cashcounter);
					call.setString(4,login_time);
					call.registerOutParameter(5,java.sql.Types.DOUBLE); 
					call.registerOutParameter(6,java.sql.Types.DOUBLE); 
					call.registerOutParameter(7,java.sql.Types.DOUBLE); 
					call.registerOutParameter(8,java.sql.Types.VARCHAR);					
					call.registerOutParameter(9,java.sql.Types.INTEGER); 
					call.registerOutParameter(10,java.sql.Types.INTEGER);
					call.registerOutParameter(11,java.sql.Types.VARCHAR);
        			call.registerOutParameter(12,java.sql.Types.VARCHAR);
					call.registerOutParameter(13,java.sql.Types.VARCHAR);

					call.execute();
      
					doubleCashBillAmt = call.getDouble(5);          
					doubleCreditAmt = call.getDouble(6);   
					doubleOpeningBalance = call.getDouble(7);   
					logout_time = call.getString(8);
					if(logout_time==null) logout_time="";
					integerCashBillCnt = call.getInt(9);
					integerCreditBillCnt = call.getInt(10);
					strErrorLevel = call.getString(11);
					strSysMessageId = call.getString(12);
					strErrorText = call.getString(13);

					if(strErrorLevel==null) strErrorLevel="";
					if(strSysMessageId==null) strSysMessageId="";
					if(strErrorText==null) strErrorText="";

				//	System.out.println("strErrorLevel sett:"+strErrorLevel);
				//	System.out.println("strSysMessageId:"+strSysMessageId);
				//	System.out.println("strErrorText:"+strErrorText);		

					strCashBillAmt  =	String.valueOf(doubleCashBillAmt);
					if(strCashBillAmt==null) strCashBillAmt="";
					strCreditAmt= String.valueOf(doubleCreditAmt);
					if(strCreditAmt==null) strCreditAmt="";
					strOpeningBalance = String.valueOf(doubleOpeningBalance);
					if(strOpeningBalance==null) strOpeningBalance="";
					strCashBillCnt = String.valueOf(integerCashBillCnt);
					if(strCashBillCnt==null) strCashBillCnt="";
					strCreditBillCnt = String.valueOf(integerCreditBillCnt);
					if(strCreditBillCnt==null) strCreditBillCnt="";		

					call.close();
				}
				catch(Exception exp)
				{
					//out.println("error="+exp);
					exp.printStackTrace();
				}
		}
		}
		catch(Exception exp)
		{
		}
		// commented in Bangalore on 13/10/2005
		//ConnectionManager.returnConnection(con,request);

	//added by ram 28-10-2008 for checking logout report option
		try{
		PreparedStatement pstmt = null;
		ResultSet rsblparm=null;
		pstmt = con.prepareStatement( "SELECT  CASH_CNTR_LOGOUT_WITH_CB_YN,CASH_CTR_LOGOUT_REP_IND,HAND_WITHOUT_COUNTER_CHK_OUT FROM BL_PARAMETERS WHERE operating_facility_id='"+facility_id+"'");		
		rsblparm = pstmt.executeQuery();	
		
		while(rsblparm.next())
		{
			cash_ctr_logout_with_cb_yn  =  rsblparm.getString(1);		
			cash_ctr_logout_rep_ind  =  rsblparm.getString(2);		
			hand_without_counter_chk_out  =  rsblparm.getString(3);		
		}	
		rsblparm.close();
		pstmt.close();
		//System.out.println("cash_ctr_logout_with_cb_yn "+cash_ctr_logout_with_cb_yn);
		//System.out.println("cash_ctr_logout_rep_ind "+cash_ctr_logout_rep_ind);

		}catch(Exception e)
		{
			System.out.println("bl_param="+e.toString());
		}//end ram

			
	}
	catch(Exception sql)
	{
	}
	finally{ // Added in Bangalore on 13/10/2005
				if(con!=null) {
					ConnectionManager.returnConnection(con, request);
				}
	}


if ((strErrorLevel.equals("10") && (!strErrorText.equals(""))) ||!strSysMessageId.equals(""))
			{
  if (strErrorLevel.equals("10") && !strErrorText.equals(""))
  {
%>
	<script>
	
	
	   var strErrorMessage = '<%=strErrorText%>';
       alert("error :"+strErrorMessage);
//	   return;
	 </script>
 <%
   }
	

   if(!strSysMessageId.equals(""))
    {
   %>
	  <script>
    	  alert(getMessage('<%=strSysMessageId%>','BL'));
//		  return;
	  </script>
    <%
	 }
	}
%>

		</tr>
		
		<tr>
				<td width='28%'><div align='right'><b> <fmt:message key="eBL.TOTAL_SLMT.label" bundle="${bl_labels}"/></b></div></td>	 

				<td width="7%">&nbsp;</td>
				<td width='7%'>&nbsp;</td>	
				<td width='7%'>&nbsp;</td>	

				<td  width="10%" class="fields"><input type='text' style='text-align:right; font-weight:bold' readonly name='tot_can' id='tot_can' maxlength='25' size='10' tabindex='0' value='<%=doubleTotCancelAmt %>'> </td>

				<td width="10%" class='fields'><input type='text' style='text-align:right; font-weight:bold' readonly name='tot_rcp' id='tot_rcp' maxlength='25' size='10' tabindex='0' value='<%=doubleTotReceiptAmt %>'> </td>

				<td width="10%" class='fields'><input type='text' style='text-align:right; font-weight:bold'  readonly name='tot_act' id='tot_act' maxlength='25' size='10' tabindex='0' value='0'> </td>

				<td width="11%" class='fields'><input type='text' style='text-align:right; font-weight:bold'  readonly name='tot_hoa' id='tot_hoa' maxlength='25' size='11' tabindex='0' value='0'> </td>

				<td width="10%" class='fields'><input type='text' style='text-align:right; font-weight:bold'  readonly name='tot_dis' id='tot_dis' maxlength='25' size='10' tabindex='0' value='0'> </td>
			</tr>
		</table>
<!--		<table border="1" width="100%" cellspacing='0' cellpadding='3'>
			<tr>
				<td width='32%'><div align='right'><b> <fmt:message key="eBL.TOTAL_SLMT.label" bundle="${bl_labels}"/></b></div></td>	 

				<td width="7%">&nbsp;</td>
				<td width='7%'>&nbsp;</td>	
				<td width='7%'>&nbsp;</td>	

				<td  width="10%" class="fields"><input type='text' style='text-align:right; font-weight:bold' readonly name='tot_can' id='tot_can' maxlength='25' size='12' tabindex='0' value='<%=doubleTotCancelAmt %>'> </td>

				<td width="10%" class='fields'><input type='text' style='text-align:right; font-weight:bold' readonly name='tot_rcp' id='tot_rcp' maxlength='25' size='12' tabindex='0' value='<%=doubleTotReceiptAmt %>'> </td>

				<td width="10%" class='fields'><input type='text' style='text-align:right; font-weight:bold'  readonly name='tot_act' id='tot_act' maxlength='25' size='12' tabindex='0' value='0'> </td>

				<td width="7%" class='fields'><input type='text' style='text-align:right; font-weight:bold'  readonly name='tot_hoa' id='tot_hoa' maxlength='25' size='12' tabindex='0' value='0'> </td>

				<td width="10%" class='fields'><input type='text' style='text-align:right; font-weight:bold'  readonly name='tot_dis' id='tot_dis' maxlength='25' size='12' tabindex='0' value='0'> </td>
			</tr>
		</table>
-->
		<input type='hidden' name='tot_credit_bills_amt' id='tot_credit_bills_amt' value='<%= strCreditAmt %>'>
		<input type='hidden' name='tot_cash_bills_amt' id='tot_cash_bills_amt' value='<%= strCashBillAmt %>'>
		<input type='hidden' name='tot_opening_bal' id='tot_opening_bal' value='<%= strOpeningBalance %>'>
		<input type='hidden' name='tot_closing_bal' id='tot_closing_bal' value='<%= strOpeningBalance %>'>
		<input type='hidden' name='logout_time' id='logout_time' value='<%= logout_time%>'>
		<input type='hidden' name='login_time' id='login_time'  value='<%= login_time%>'>
		<input type='hidden' name='slmt_array' id='slmt_array' value='<%= strSlmtArray %>'>
		<input type='hidden' name='cash_counter' id='cash_counter' value='<%=cashcounter%>'>
		<input type='hidden' name='error_level' id='error_level' value='<%=strErrorLevel%>'>
		<input type='hidden' name='error_text' id='error_text' value='<%=strErrorText%>'>
		<input type='hidden' name='cash_bill_cnt' id='cash_bill_cnt' value='<%=strCashBillCnt%>'>
		<input type='hidden' name='credit_bill_cnt' id='credit_bill_cnt' value='<%=strCreditBillCnt%>'>
		<input type='hidden' name='stmtcode' id='stmtcode' value='<%=stmtcode%>'>
		<input type='hidden' name='logoutSuccesful' id='logoutSuccesful' value=''>
		<input type='hidden' name='logoutSubmit' id='logoutSubmit' value=''>
		<input type='hidden' name='noofdecimal' id='noofdecimal' value='<%=noofdecimal%>'>	
		<input type='hidden' name='cash_ctr_logout_rep_ind' id='cash_ctr_logout_rep_ind' value='<%=cash_ctr_logout_rep_ind%>'>	
		<input type='hidden' name='cash_ctr_logout_with_cb_yn' id='cash_ctr_logout_with_cb_yn' value='<%=cash_ctr_logout_with_cb_yn%>'>	
		<input type='hidden' name='called_frm' id='called_frm' value='<%=called_frm%>'>	
		<input type='hidden' name='slmt_flag' id='slmt_flag' value='<%=slmt_flag%>'>	
		<!--<input type='hidden' name='cashHandedOver' id='cashHandedOver' value='<%=strCashHandedOver%>'>	
		<input type='hidden' name='cheqHandedOver' id='cheqHandedOver' value='<%=strcheqHandedOver%>'>	-->
		<input type='hidden' name='cashHandedOver' id='cashHandedOver' value='<%=totcash%>'>	
		<input type='hidden' name='cheqHandedOver' id='cheqHandedOver' value='<%=totcheq%>'>		
		<input type='hidden' name='hand_without_counter_chk_out' id='hand_without_counter_chk_out' value='<%=hand_without_counter_chk_out%>'>
		
		<!-- sarathkumar added two fields make as siteSpecific GDOH-CRF-0117 -->	
		<input type='hidden' name='rowCounts' id='rowCounts' id='rowCounts' value='<%=rowCount%>'>
		<input type='hidden' name='SiteSpecific' id='SiteSpecific' id='SiteSpecific' value='<%=ss %>'
	
</form>
</body>
</html>


