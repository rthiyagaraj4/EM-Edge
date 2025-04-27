<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,com.ehis.util.*,webbeans.op.CurrencyFormat,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs	=null;
	PreparedStatement pstmt1 = null ;
	ResultSet rs1	=null;

	HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");			
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";	
	String classval=""; String strFacilityId=""; int total_records=0;
	int noofdecimal = 2;
	String strPatientId="", strNursingUnitCode = "", strCalledFrom="",strCalledFor="";
	String strBlngGrpId="", strBlngGrpDesc="", strUnbilledAmt="", strBilledAmt="", strPaidAmt="", strOutstAmt="", strInvAmt="", strRemarks="", strEpisodeType="";
	String strCustGrpCode="", strCustCode="";
	String params = "";
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
	java.util.ResourceBundle bl_messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
	String strTitle=(String) bl_labels.getString("eBL.PAT_ENCOUNTER_DETAILS.label");

	try
	{
		con	=	ConnectionManager.getConnection(request);

		CurrencyFormat cf = new CurrencyFormat();

		strFacilityId = (String)httpSession.getValue("facility_id");
		if(strFacilityId==null) strFacilityId="";

		strPatientId = request.getParameter("patient_id");
		if(strPatientId==null) strPatientId="";	

		strNursingUnitCode = request.getParameter("nursing_unit_code");
		if(strNursingUnitCode==null) strNursingUnitCode="";	

		strCalledFrom = request.getParameter("called_from");
		if(strCalledFrom==null) strCalledFrom="";	


		strCalledFor = request.getParameter("called_for");
		if(strCalledFor==null) strCalledFor="";	

		
		params = request.getQueryString();
		if(params==null) params="";	

		try
		{		
			pstmt1 = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs1 = pstmt1.executeQuery();	
			while(rs1.next())
			{
				noofdecimal  =  rs1.getInt(1);		
			}	
			rs1.close();
			pstmt1.close();
			
		}
		catch(Exception e)
		{
			System.out.println("3="+e.toString());
		}
%>
<HTML>
<HEAD>
</HEAD>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
		
		<style>
		thead td, thead td.locked	{
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
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

<script>

function hideToolTip(obj,imgObj,row)	
{ 
	dynamichide(obj, window.event,row);	 
}

function callMouseOver(obj)	
{
	currClass = obj.className ;
	obj.className = 'selectedcontextMenuItem';
}

function callOnMouseOut(obj)
{
	obj.className = 'contextMenuItem';
}

function resizeWindow(orderctlHDR)
{
	var orderctlHDR1 = orderctlHDR.id;

	var wdth = document.getElementById('orderctlHDR1').offsetWidth;
	var hght1 = document.getElementById('orderctlHDR1').offsetHeight;		
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;	

	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight

	var z = bodwidth- (event.x + wdth);	
	
	var x 	  = event.x;
	var y 	  = event.y;	

	x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
	y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);	

	if(x<bodwidth){
		x= wdth1;			
	}else{			
		x = getPos(orderctlHDR).x;
	}
	if(y<bodheight){			
		y = hght;
		
	}else
	{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
	}

	document.getElementById("tooltiplayer").style.posLeft= x;
	document.getElementById("tooltiplayer").style.posTop = y;
	document.getElementById("tooltiplayer").style.visibility='visible';

}
function displayToolTip(orderctlHDR,imgObj,i,strPatientId,strEpisodeType,strEpisodeId,strEncounterId)
{
	callMouseOverOnTD(orderctlHDR,imgObj,i);
	buildTable(i);
	resizeWindow(orderctlHDR)
}

function buildTable(curr_rec)
{
	var val = ("Bill/Payment Details,Diagnosis,Procedures");
	var row  = ("Bill/Payment Details,Diagnosis,Procedures");
	var rowval   = val.split (",");		
	rowval1      = row.split(",");
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<rowval.length; i++ ) {
		var colval  = rowval[i]
		var colval1 = rowval1[i];
        if (colval != "")
         {     
				tab_dat     += "<tr>"
				if(colval1 == "Bill/Payment Details"){
				tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href='javascript:funViewEncounterDet("+curr_rec+")'>"+colval+" </a></td>";
				}
				else if(colval1 == "Diagnosis"){
				tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:funAmend()>"+colval+" </a></td>";
				}else{
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:funCancel()>"+colval+" </a></td>";
				}
				tab_dat     += "</tr> ";
		}
	  }
		tab_dat     += "</table> "
		document.getElementById("t").innerHTML = tab_dat;
}

function funViewEncounterDet(curr_rec)
{
	var strPatientId="", strEpisodeType="", strEpisodeId="", strEncounterId="";

	var total_records = document.forms[0].total_records.value;
	for(var i=0;i<total_records;i++)
	{
		if(i == curr_rec)
		{
			var pat_id = eval(document.getElementById('pat_id'+curr_rec));
			strPatientId = pat_id.innerText;

			var enc_id = eval(document.getElementById('enc_id'+curr_rec));
			strEpisodeId = enc_id.innerText;

			strEncounterId = strEpisodeId;

			var episode_type = eval("document.forms[0].episode_type"+curr_rec);
			strEpisodeType = episode_type.value;
		}
	}
	var center='1';
	var dialogTop = "320";
	var dialogHeight = "25" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title="";
	title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+strPatientId+"&episode_type="+strEpisodeType+"&episode_id="+strEpisodeId+"&encounter_id="+strEncounterId;
	retVal=window.showModalDialog("../../eBL/jsp/BLViewEncounterBillDetMain.jsp?"+param,arguments,features);
}

function getBlngGrpSearch(blng_grp_id)
{
	var billing_group=blng_grp_id;
	
	if((billing_group!=""))
	{
		var retVal;
		var dialogHeight= "400px" ;
		var dialogWidth	= "700px" ;
		var dialogTop = "0" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLBillingGrpDetFrame.jsp?billing_group=	"+billing_group;
		retVal = top.window.showModalDialog(url,arguments,features);
	}
}

function getCustDet(cust_grp_code,cust_code)
{
	if((cust_code!=""))
	{
		var retVal;
		var dialogHeight= "400px" ;
		var dialogWidth	= "700px" ;
		var dialogTop = "350" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLCustomerDetFrame.jsp?cust_code="+cust_code+"&cust_grp_code="+cust_grp_code;
		retVal = top.window.showModalDialog(url,arguments,features);
	}
}

</script>
<body onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
<form name='BLNursingUnitQueryForm' id='BLNursingUnitQueryForm' action="" method="post" target="">
<%
		try
		{				
			String sqlPatEncDet="";
			if(strCalledFor.equals("CIP"))
			{
				if(strCalledFrom.equals("FSB"))
				{
					 sqlPatEncDet="Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.blng_grp_id BLNG_GRP_ID from (Select blng_grp_id,sum(upd_net_charge_amt) Unbilled_amt,0 Billed_amt ,0 Paid_amt,0 Outstdg_amt,0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"') group by blng_grp_id union Select a.blng_grp_id, 0 Unbilled_amt, sum(BILL_AMT) Billed_amt ,sum(BILL_PAID_AMT) Paid_amt,sum(BILL_TOT_OUTST_AMT) Outstdg_amt,sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"') group by a.blng_grp_id) x group by x.blng_grp_id";
				}
				else if(strCalledFrom.equals("FSP"))
				{
					sqlPatEncDet = "Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.cust_group_code CUST_GRP_CODE,x.cust_code CUST_CODE from (Select cust_group_code,cust_code,  sum(upd_net_charge_amt) Unbilled_amt, 0 Billed_amt , 0 Paid_amt, 0 Outstdg_amt, 0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"') group by a.cust_group_code,a.cust_code union Select  a.cust_group_code,a.cust_code, 0 Unbilled_amt,  sum(BILL_AMT) Billed_amt , sum(BILL_PAID_AMT) Paid_amt, sum(BILL_TOT_OUTST_AMT) Outstdg_amt, sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"') group by a.cust_group_code,a.cust_code) x group by x.cust_group_code,x.cust_code";
				}
			}
			else if(strCalledFor.equals("TED"))
			{
				if(strCalledFrom.equals("FSB"))
				{
//					 sqlPatEncDet="Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.blng_grp_id BLNG_GRP_ID from (Select blng_grp_id,sum(upd_net_charge_amt) Unbilled_amt,0 Billed_amt ,0 Paid_amt,0 Outstdg_amt,0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) and exists (select 'X' from IP_DISCHARGE_ADVICE c where c.ENCOUNTER_ID=a.ENCOUNTER_ID and c.DIS_ADV_STATUS <> '9' and trunc(c.EXPECTED_DISCHARGE_DATE)=trunc(sysdate)) group by blng_grp_id union Select a.blng_grp_id, 0 Unbilled_amt, sum(BILL_AMT) Billed_amt ,sum(BILL_PAID_AMT) Paid_amt,sum(BILL_TOT_OUTST_AMT) Outstdg_amt,sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) and exists (select 'X' from IP_DISCHARGE_ADVICE c where c.ENCOUNTER_ID=a.ENCOUNTER_ID and c.DIS_ADV_STATUS <> '9' and trunc(c.EXPECTED_DISCHARGE_DATE)=trunc(sysdate)) group by a.blng_grp_id) x group by x.blng_grp_id";
					sqlPatEncDet="Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.blng_grp_id BLNG_GRP_ID from (Select blng_grp_id,sum(upd_net_charge_amt) Unbilled_amt,0 Billed_amt ,0 Paid_amt,0 Outstdg_amt,0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) group by blng_grp_id union Select a.blng_grp_id, 0 Unbilled_amt, sum(BILL_AMT) Billed_amt ,sum(BILL_PAID_AMT) Paid_amt,sum(BILL_TOT_OUTST_AMT) Outstdg_amt,sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.blng_grp_id) x group by x.blng_grp_id";
				}
				else if(strCalledFrom.equals("FSP"))
				{
//					sqlPatEncDet = "Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.cust_group_code CUST_GRP_CODE,x.cust_code CUST_CODE from (Select cust_group_code,cust_code,  sum(upd_net_charge_amt) Unbilled_amt, 0 Billed_amt , 0 Paid_amt, 0 Outstdg_amt, 0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) and exists (select 'X' from IP_DISCHARGE_ADVICE c where c.ENCOUNTER_ID=a.ENCOUNTER_ID and c.DIS_ADV_STATUS <> '9' and trunc(c.EXPECTED_DISCHARGE_DATE)=trunc(sysdate)) group by a.cust_group_code,a.cust_code union Select  a.cust_group_code,a.cust_code, 0 Unbilled_amt,  sum(BILL_AMT) Billed_amt , sum(BILL_PAID_AMT) Paid_amt, sum(BILL_TOT_OUTST_AMT) Outstdg_amt, sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"'  and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) and exists (select 'X' from IP_DISCHARGE_ADVICE c where c.ENCOUNTER_ID=a.ENCOUNTER_ID and c.DIS_ADV_STATUS <> '9' and trunc(c.EXPECTED_DISCHARGE_DATE)=trunc(sysdate)) group by a.cust_group_code,a.cust_code) x group by x.cust_group_code,x.cust_code";
					sqlPatEncDet = "Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.cust_group_code CUST_GRP_CODE,x.cust_code CUST_CODE from (Select cust_group_code,cust_code,  sum(upd_net_charge_amt) Unbilled_amt, 0 Billed_amt , 0 Paid_amt, 0 Outstdg_amt, 0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.cust_group_code,a.cust_code union Select  a.cust_group_code,a.cust_code, 0 Unbilled_amt,  sum(BILL_AMT) Billed_amt , sum(BILL_PAID_AMT) Paid_amt, sum(BILL_TOT_OUTST_AMT) Outstdg_amt, sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"'  and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.cust_group_code,a.cust_code) x group by x.cust_group_code,x.cust_code";
				}
			}
			else if(strCalledFor.equals("TDP"))
			{
				if(strCalledFrom.equals("FSB"))
				{
					 sqlPatEncDet="Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.blng_grp_id BLNG_GRP_ID from (Select blng_grp_id,sum(upd_net_charge_amt) Unbilled_amt,0 Billed_amt ,0 Paid_amt,0 Outstdg_amt,0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and exists (Select 'X' from PR_ENCOUNTER b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and b.facility_id='"+strFacilityId+"' and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.ASSIGN_CARE_LOCN_CODE='"+strNursingUnitCode+"' and trunc(b.DISCHARGE_DATE_TIME)=trunc(sysdate)) group by blng_grp_id union Select a.blng_grp_id, 0 Unbilled_amt, sum(BILL_AMT) Billed_amt ,sum(BILL_PAID_AMT) Paid_amt,sum(BILL_TOT_OUTST_AMT) Outstdg_amt,sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where exists (Select 'X' from PR_ENCOUNTER b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and b.facility_id='"+strFacilityId+"' and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.ASSIGN_CARE_LOCN_CODE='"+strNursingUnitCode+"' and trunc(b.DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.blng_grp_id) x group by x.blng_grp_id";
				}
				else if(strCalledFrom.equals("FSP"))
				{
					sqlPatEncDet = "Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.cust_group_code CUST_GRP_CODE,x.cust_code CUST_CODE from (Select cust_group_code,cust_code,  sum(upd_net_charge_amt) Unbilled_amt, 0 Billed_amt , 0 Paid_amt, 0 Outstdg_amt, 0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and a.cust_code is not null and exists (Select 'X' from PR_ENCOUNTER b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and  b.facility_id='"+strFacilityId+"' and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.ASSIGN_CARE_LOCN_CODE='"+strNursingUnitCode+"' and trunc(b.DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.cust_group_code,a.cust_code union Select  a.cust_group_code,a.cust_code, 0 Unbilled_amt,  sum(BILL_AMT) Billed_amt , sum(BILL_PAID_AMT) Paid_amt, sum(BILL_TOT_OUTST_AMT) Outstdg_amt, sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where a.cust_code is not null and exists (Select 'X' from PR_ENCOUNTER b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and b.facility_id='"+strFacilityId+"' and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.ASSIGN_CARE_LOCN_CODE='"+strNursingUnitCode+"' and trunc(b.DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.cust_group_code,a.cust_code) x group by x.cust_group_code,x.cust_code";
				}
			}
/*
			HashMap sqlMap = new HashMap();
			sqlMap.put("sqlData",sqlPatEncDet);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("UNBILLED_AMT");
			displayFields.add("BILLED_AMT");
			displayFields.add("PAID_AMT");
			displayFields.add("OUTST_AMT");
			displayFields.add("INC_AMT");
			if(strCalledFrom.equals("FSB"))
			{
				displayFields.add("BLNG_GRP_ID");
			}
			else if(strCalledFrom.equals("FSP"))
			{
				displayFields.add("CUST_GRP_CODE");
				displayFields.add("CUST_CODE");
			}
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			//out.println("resutl==>"+result.size());
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
			{
*/
%>
<!--		<div>
		<table border='0' cellpadding='0' cellspacing='0' align = 'center' id='' width='100%'>						
			<tr>	
			<td width="80%" class="white">&nbsp;</td>
			<td width="20%" class="white">&nbsp;
<%			
//				out.println(result.get(1));
%>
				</td>
			</tr>
		</table>
		</div>
		-->
		<div id="tbl-container" STYLE="overflow: auto; height: 160px;   padding:3px; margin: 0px">
		<table border='1' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
		<thead>
			<tr>		
<%
			if(strCalledFrom.equals("FSB"))
			{
%>
				<td class='COLUMNHEADER' width='40%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
<%
			}
			else if(strCalledFrom.equals("FSP"))
			{
%>
				<td class='COLUMNHEADER' width='40%'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/>/<fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
<%
			}
%>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.PAID_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.INV_AMT.label" bundle="${bl_labels}"/></td>
			</tr>
		</thead>
<%
			pstmt = con.prepareStatement(sqlPatEncDet);
			rs = pstmt.executeQuery();	
			if( rs != null) 
			{
			while(rs.next())
			{
				int i=0;
/*	
			int i=0;	
			ArrayList records=new ArrayList();
			for(int j=2; j<result.size(); j++)
			{
*/
   				if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
/*
				records=(ArrayList) result.get(j);		
			
				strUnbilledAmt = (String)records.get(0);
				if(strUnbilledAmt==null) strUnbilledAmt="0";

				strBilledAmt = (String)records.get(1);
				if(strBilledAmt==null) strBilledAmt="0";

				strPaidAmt = (String)records.get(2);
				if(strPaidAmt==null) strPaidAmt="0";

				strOutstAmt = (String)records.get(3);
				if(strOutstAmt==null) strOutstAmt="0";

				strInvAmt = (String)records.get(4);
				if(strInvAmt==null) strInvAmt="0";

				if(strCalledFrom.equals("FSB"))
				{
					strBlngGrpId = (String)records.get(5);
					if(strBlngGrpId==null) strBlngGrpId="";
				}
				else if(strCalledFrom.equals("FSP"))
				{
					strCustGrpCode = (String)records.get(5);
					if(strCustGrpCode==null) strCustGrpCode="";

					strCustCode = (String)records.get(6);
					if(strCustCode==null) strCustCode="";
				}
*/
				strUnbilledAmt = rs.getString(1);
				if(strUnbilledAmt==null) strUnbilledAmt="0";

				strBilledAmt = rs.getString(2);
				if(strBilledAmt==null) strBilledAmt="0";

				strPaidAmt = rs.getString(3);
				if(strPaidAmt==null) strPaidAmt="0";

				strOutstAmt = rs.getString(4);
				if(strOutstAmt==null) strOutstAmt="0";

				strInvAmt = rs.getString(5);
				if(strInvAmt==null) strInvAmt="0";

				if(strCalledFrom.equals("FSB"))
				{
					strBlngGrpId = rs.getString(6);
					if(strBlngGrpId==null) strBlngGrpId="";
				}
				else if(strCalledFrom.equals("FSP"))
				{
					strCustGrpCode = rs.getString(6);
					if(strCustGrpCode==null) strCustGrpCode="";

					strCustCode = rs.getString(7);
					if(strCustCode==null) strCustCode="";
				}
				strUnbilledAmt = cf.formatCurrency(strUnbilledAmt, noofdecimal);
				strBilledAmt = cf.formatCurrency(strBilledAmt, noofdecimal);
				strPaidAmt = cf.formatCurrency(strPaidAmt, noofdecimal);
				strOutstAmt = cf.formatCurrency(strOutstAmt, noofdecimal);
				strInvAmt = cf.formatCurrency(strInvAmt, noofdecimal);

				try
				{		
					pstmt1 = con.prepareStatement( " select SHORT_DESC from bl_blng_grp_lang_vw where language_id='"+locale+"' and blng_grp_id='"+strBlngGrpId+"'");
					rs1 = pstmt1.executeQuery();	
					while(rs1.next())
					{
						strBlngGrpDesc  =  rs1.getString(1);		
					}	
					if(rs1!=null) rs1.close();
					pstmt1.close();
				}
				catch(Exception e)
				{
					System.out.println("Exception in strBlngGrpDesc="+e.toString());
				}	
				if(strBlngGrpDesc == null) strBlngGrpDesc="";
%>
		<tbody>
			<tr id=row<%=i%>>
<%
				if(strCalledFrom.equals("FSB"))			
				{
%>
<!--
				<td class=<%=classval%> width='40%'><%=strBlngGrpDesc%></td>	 
-->
				<td class=<%=classval%> width='40%'><a href="javascript:getBlngGrpSearch('<%=strBlngGrpId%>');"><%=strBlngGrpId%></a></td>	 
<%
				}
				else if(strCalledFrom.equals("FSP"))
				{
%>
				<td class=<%=classval%> width='40%'><a href="javascript:getCustDet('<%=strCustGrpCode%>','<%=strCustCode%>');"><%=strCustGrpCode%>/<%=strCustCode%></a></td>	 
<%
				}
%>
<!--
				<td width='10%' wrap style='cursor:pointer' class='gridDataBlue' id="blng_grp_id_<%=i%>"><%=strBlngGrpId%></td>
-->
				<td class=<%=classval%> width='12%'><DIV id='unb_amt<%=i%>' style='text-align:right'><%=strUnbilledAmt%></DIV></td>	 
				<td class=<%=classval%> width='12%'><DIV id='billd_amt<%=i%>' style='text-align:right'><%=strBilledAmt%></DIV></td>	
				<td class=<%=classval%> width='12%'><DIV id='paid_amt<%=i%>' style='text-align:right'><%=strPaidAmt%></DIV></td>	 				
				<td class=<%=classval%> width='12%'><DIV id='outst_amt<%=i%>' style='text-align:right'><%=strOutstAmt%></DIV></td>	 
				<td class=<%=classval%> width='12%'><DIV id='inv_amt<%=i%>' style='text-align:right'><%=strInvAmt%></DIV></td>	 
			</tr>
<%
				i++;
				total_records++; 
			}//for loop
				rs.close();
			}
%>
		</tbody>
		</table>
		</div>
<%
				out.flush();
/*
			}
			else
*/
			if(total_records == 0)
			{


			 %>
<!--
		<div id="tbl-container" STYLE="overflow: auto; width: 615px; height: 195px;   padding:3px; margin: 0px">
		<table border='1' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
		<thead>
			<tr>			
				<td class='COLUMNHEADER' width='40%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.PAID_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.INV_AMT.label" bundle="${bl_labels}"/></td>
			</tr>
		</thead>
			<tbody>
-->
<%
		String noRecord = bl_messages.getString("BL9813");
%>
<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));
</script>

<!--
			<tr>
					<td colspan='10'><div align='center'><%=noRecord%> </div></td>
			</tr>

			</tbody>
			</table></div>
-->
<%
			}
		}
		catch(Exception ee)
		{
			System.err.println("Exception in Fin Summary Qury Result" +ee); 
		}

	}
	catch(Exception eee)
	{
		System.err.println("Exception main"+ eee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
	<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>	
	<input type='hidden' name='params' id='params' value='<%=params%>'>	

	<script>parent.frames[2].location.href='../../eCommon/html/blank.html';</script>

	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:12%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='t'></td>
			</tr>
		</table>
	</div>
	
</form>
<!--	<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLNursingUnitQueryResultsFinSummaryBody.jsp",searched));%> -->
</body>
</HTML>

