<!DOCTYPE html>
<!--
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			 V210517			 17598			Common-ICN-0034				Mohana Priya K
----------------------------------------------------------------------------------------------
-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eBL.*,webbeans.op.CurrencyFormat,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rscurr=null;
	//ResultSet rs=null;
	ResultSet rs1=null;	ResultSet rs2=null;	ResultSet rs3=null;		
	HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");			
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";
	CurrencyFormat cf = new CurrencyFormat();
	String classval="";		int noofdecimal=2;String p_facility_id="";
	String strEpisodeType="";String strPatientId="";String strVisitId="";String strEpisodeId="";String strEncounterId="";
	String strDocType="";String strDocNum="";String strDocDate="";
	String strBillAmt="";String strDepAdjust="";String strDisAmt="";String strRoundAmt="";
	String strBillPaidAmt="";String strOutstandAmt="";String strCancelled="";String strBillTotAdjAmt="";
	String strBillTotExmtAmt="";	String strBillTotWriteOffAmt="";String strCustName="";String strBillGrpDesc="";
	String strPolicyNum="";String strFacilityId="";String strPolicyDesc="";String sqlEnctrDet="";String strQuerystring="";
	String strTotBilledAmt="0";String strTotBillsPaidAmt="0";String strTotOutStdAmt="0";String strTotUnBilledAmt="0";
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	//java.util.Locale loc = new java.util.Locale(locale);
	//java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eCommon.resources.M",loc);
	//String noRecFound="";

	try{
			con	=	ConnectionManager.getConnection(request);
			p_facility_id = (String)httpSession.getValue("facility_id");
			if(p_facility_id==null || p_facility_id.equals("")) p_facility_id="";
	//		noRecFound =(String) bl_labels.getString("Common.NO_RECORD_FOUND.label");		
			
			strEpisodeType = request.getParameter("episode_type");
			if(strEpisodeType==null || strEpisodeType.equals("")) strEpisodeType="";

			strPatientId = request.getParameter("patient_id");
			if(strPatientId==null || strPatientId.equals("")) strPatientId="";	

			strVisitId = request.getParameter("visit_id");
			if(strVisitId==null || strVisitId.equals("")) strVisitId="";	

			strEpisodeId = request.getParameter("episode_id");
			if(strEpisodeId==null || strEpisodeId.equals("")) strEpisodeId="";

			strEncounterId=request.getParameter("encounter_id");
			if(strEncounterId==null || strEncounterId.equals("")) strEncounterId="";
			
			strQuerystring=request.getQueryString();
			if(strQuerystring==null || strQuerystring.equals("")) strQuerystring="";

		try{		
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
				rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					noofdecimal  =  rscurr.getInt(1);		
				}	
				if(rscurr != null) rscurr.close(); //V210517
				if (pstmt != null) pstmt.close();	//V210517
				//rscurr.close();
				//pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("3="+e.toString());
				e.printStackTrace();
			}
%>
<html>
<head>
<script>
async function callchardet(strDocType,strDocNum,strDocDate)
{
	var query_string = document.forms[0].query_string.value;
	var facility_id = document.forms[0].facility_id.value;
	//		var doc_type = document.forms[0].doc_type.value;		
	//		var doc_num = document.forms[0].doc_num.value;
	//var doc_date = document.forms[0].doc_date.value;
	var locale = document.forms[0].locale.value;		
	var doc_date = convertDate(strDocDate,"DMYHMS",locale,"en");		
	//alert("doc_date "+doc_date);
	var center='1';
	var dialogTop = "10px";
	var dialogHeight = "90vh" ;
	var dialogWidth = "90vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title="";
	title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"query_string="+query_string+"&"+"facility_id="+facility_id+"&"+"doc_type="+strDocType+"&"+"doc_num="+strDocNum+"&"+"doc_date="+doc_date;
	retVal=await window.showModalDialog("../../eBL/jsp/BLViewEncounterBillChrDetMain.jsp?"+param,arguments,features);
}

async function callunbillchardet(strDocType,strDocNum,strDocDate)
{	
	var query_string=document.forms[0].query_string.value;		
	var facility_id = document.forms[0].facility_id.value;

	//var doc_type = document.forms[0].doc_type.value;		
	//var doc_num = document.forms[0].doc_num.value;
	//var doc_date = document.forms[0].doc_date.value;
	var locale = document.forms[0].locale.value;	
	var doc_date = convertDate(strDocDate,"DMYHMS",locale,"en");		
	var center='1';
	var dialogTop = "320";
	var dialogHeight = "70vh" ;
	var dialogWidth = "80vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title="";
	title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"query_string="+query_string+"&"+"facility_id="+facility_id+"&"+"doc_type="+strDocType+"&"+"doc_num="+strDocNum+"&"+"doc_date="+doc_date;;
	retVal=await top.window.showModalDialog("../../eBL/jsp/BLViewEncounterUnBillChrDetMain.jsp?"+param,arguments,features);
}
async function callpaymentdet(strDocType,strDocNum,strDocDate)
{
	var query_string=document.forms[0].query_string.value;
	var facility_id = document.forms[0].facility_id.value;
	//var doc_type = document.forms[0].doc_type.value;		
	//var doc_num = document.forms[0].doc_num.value;
	//var doc_date = document.forms[0].doc_date.value;	
	var locale = document.forms[0].locale.value;		
	var doc_date = convertDate(strDocDate,"DMYHMS",locale,"en");	
	var center='1';
	var dialogTop = "320";
	var dialogHeight = "60vh" ;
	var dialogWidth = "90vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title="";
	title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"query_string="+query_string+"&"+"facility_id="+facility_id+"&"+"doc_type="+strDocType+"&"+"doc_num="+strDocNum+"&"+"doc_date="+doc_date;
	retVal=await window.showModalDialog("../../eBL/jsp/BLViewEncounterPaymentDetMain.jsp?"+param,arguments,features);
}


function displayToolTip(strDepAdjust,strDisAmt,strBillTotExmtAmt,strBillTotAdjAmt,strRoundAmt)
{			
	buildTable(strDepAdjust,strDisAmt,strBillTotExmtAmt,strBillTotAdjAmt,strRoundAmt);
	resizeWindow();
}

function buildTable(strDepAdjust,strDisAmt,strBillTotExmtAmt,strBillTotAdjAmt,strRoundAmt)
{
	//	var dep_amt_label='<fmt:message key="eBL.ADJUST_DEPOSIT.label" bundle="${bl_labels}"/>';
	var dep_amt_label='<fmt:message key="eBL.ADJUSTED_DEPOSIT.label" bundle="${bl_labels}"/>';
	var desc_amt_label='<fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/>';
	//	var exempt_amt_label='<fmt:message key="eBL.EXEMPT_AMOUNT.label" bundle="${bl_labels}"/>';
	var exempt_amt_label='<fmt:message key="eBL.EXEMPTION_AMOUNT.label" bundle="${bl_labels}"/>';
	//	var adj_amt_label='<fmt:message key="eBL.ADJUST_AMT.label" bundle="${bl_labels}"/>';
	var adj_amt_label='<fmt:message key="eBL.ADJUSTMENT_AMT.label" bundle="${bl_labels}"/>';
	var writoff_amt_label='<fmt:message key="eBL.WRITOFF_ROUND.label" bundle="${bl_labels}"/>';

	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='1'   class='columnHeader' width='100%' height='100%' align='center'>"
	
	tab_dat		+= "<th class='columnHeader' width='20%'>"+dep_amt_label+"</th>";
	tab_dat		+= "<th class='columnHeader' width='20%'>"+desc_amt_label+"</th>";
	tab_dat		+= "<th class='columnHeader' width='20%'>"+exempt_amt_label+"</th>"
	tab_dat		+= "<th class='columnHeader' width='20%'>"+adj_amt_label+"</th>";
	tab_dat		+= "<th class='columnHeader' width='20%'>"+writoff_amt_label+"</th>"

	tab_dat     += "<tr>";
	
	//tab_dat     += "<td class='fields' width='20%'>"+strDepAdjust+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+strDepAdjust+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+strDisAmt+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+strBillTotExmtAmt+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+strBillTotAdjAmt+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+strRoundAmt+"</td>";
	tab_dat     += "</tr> ";
	tab_dat     += "</table> ";
	document.getElementById('t').innerHTML = tab_dat;
}

function resizeWindow()
{
	bodwidth = parent.frames[0].document.body.offsetWidth;
	bodheight = parent.frames[0].document.body.offsetHeight;

	var x =event.x;
	var y =event.y;

	x = x + (document.getElementById('tooltiplayer').offsetWidth);
	y = y + (document.getElementById('tooltiplayer').offsetHeight);

	if(x<bodwidth)
	{
		x =event.x;
	}
	else
	{
		x = x - (document.getElementById('tooltiplayer').offsetWidth);
	}

	if(y<bodheight)
	{
		 y =event.y;
	}
	else
	{
		y = y - (document.getElementById('tooltiplayer').offsetHeight);
	}
	
	y+=document.body.scrollTop;
	x+=document.body.scrollLeft;
	document.getElementById('tooltiplayer').style.left= "10px";
	document.getElementById('tooltiplayer').style.top = "-200px";
	document.getElementById('tooltiplayer').style.backgroundColor = "white";
	document.getElementById('tooltiplayer').style.visibility='visible';
}

function hideToolTip()	
{
	document.getElementById('tooltiplayer').style.visibility = 'hidden'
}
	
</script>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>	
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
<script language="javascript" src="../../eBL/js/BLPatientEncounters.js"></script>
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
</head>

<body onLoad='' onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
<form name='view_enctr_bill_det' id='view_enctr_bill_det' method='post' >
 <%        
	try{
			sqlEnctrDet="SELECT  DOC_TYPE_CODE ,DOC_NUM , to_char(DOC_DATE,'DD/MM/YYYY HH24:MI:SS') DOCM_DATE, BILL_AMT, NVL(PREPAY_ADJ_AMT,0)+ NVL(DEPOSIT_ADJ_AMT,0) DEPOSIT_ADJUSTED,NVL(OVERALL_DISC_AMT,0)+NVL(MAN_DISC_AMT,0) DISCOUNT_AMT,BILL_ROUNDING_AMT     ROUNDED_AMT,   BILL_PAID_AMT ,BILL_TOT_OUTST_AMT, DECODE(BILL_STATUS,'C','CANCELLED','') CANCELLED ,BILL_TOT_ADJUST_AMT,   BILL_TOT_EXEMPT_AMT,BILL_TOT_WRITE_OFF_AMT   ,C.LONG_NAME CUSTOMER_NAME, B.LONG_DESC BLNG_GRP_DESC,POLICY_NUMBER,		A.OPERATING_FACILITY_ID  OP_FACILITY_ID ,  D.LONG_DESC POLICY_DESC FROM BL_BILL_HDR A, BL_BLNG_GRP_LANG_VW B,AR_CUSTOMER_LANG_VW C,BL_INS_POLICY_TYPES_LANG_VW D WHERE  A.BLNG_GRP_ID = B.BLNG_GRP_ID AND B.LANGUAGE_ID = '"+locale+"'   AND A.CUST_CODE = C.CUST_CODE(+)  AND C.LANGUAGE_ID(+) = '"+locale+"' AND A.POLICY_TYPE_CODE = D.POLICY_TYPE_CODE(+) AND A.OPERATING_FACILITY_ID = D.OPERATING_FACILITY_ID(+) AND D.LANGUAGE_ID(+) = '"+locale+"'  AND PATIENT_ID ='"+strPatientId+"' AND EPISODE_TYPE = '"+strEpisodeType+"'  and ('"+strEpisodeType+"' = 'R' OR ('"+strEpisodeType+"' <> 'R' and EPISODE_ID   = '"+strEpisodeId+"')  OR      ('"+strEpisodeType+"' in ('O','E') and EPISODE_ID   = '"+strEpisodeId+"' and VISIT_ID   = '"+strVisitId+"')) order by DOC_DATE desc";
					
			//AND EPISODE_TYPE = '"+strEpisodeType+"'  AND NVL(EPISODE_ID,'"+strEpisodeId+"')   =DECODE(EPISODE_TYPE,'R', NVL (EPISODE_ID,'99999999'),EPISODE_ID)  AND NVL(VISIT_ID,'9999')     =  DECODE(EPISODE_TYPE,'O',VISIT_ID, 'E',VISIT_ID,NVL(VISIT_ID,'"+strVisitId+"'))";			
			HashMap sqlMap = new HashMap();
			sqlMap.put("sqlData",sqlEnctrDet);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("DOC_NUM");
			displayFields.add("DOCM_DATE");
			displayFields.add("BILL_AMT");
			displayFields.add("DEPOSIT_ADJUSTED");
			displayFields.add("DISCOUNT_AMT");
			displayFields.add("ROUNDED_AMT");
			displayFields.add("BILL_PAID_AMT");
			displayFields.add("BILL_TOT_OUTST_AMT");
			displayFields.add("CANCELLED");
			displayFields.add("BILL_TOT_ADJUST_AMT");
			displayFields.add("BILL_TOT_EXEMPT_AMT");
			displayFields.add("BILL_TOT_WRITE_OFF_AMT");
			displayFields.add("CUSTOMER_NAME");
			displayFields.add("BLNG_GRP_DESC");
			displayFields.add("POLICY_NUMBER");					
			displayFields.add("OP_FACILITY_ID");
			displayFields.add("POLICY_DESC");

			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) {
%>	
<div>
	<table  cellpadding=3 cellspacing=0 width="100%" align="center">
	<tr>
	<td ></td>		
	<td >
	<%
		// For display the previous/next link
	     out.println(result.get(1));		
	%>
	</td></tr>
	</table></div>
	<div id="tbl-container" STYLE="overflow: auto; /* width: 1020px; */ height: 240px;   padding:3px; margin: 0px">
	<table border='1' cellpadding='3' cellspacing='0' align = 'center' id='enctr_bill_det' width='100%'>			
		<thead><tr>			
			<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='18%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='13%'><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='8%'><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='8%'><fmt:message key="eBL.PAID_AMT.label" bundle="${bl_labels}"/></td>	
			<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='1%'></td>
		</tr></thead>
<%				
	int i=0;			
	ArrayList records=new ArrayList();
	for(int j=2; j<result.size(); j++)
	{			

		if(i % 2 == 0 )
		{
			classval	=	"QRYEVEN";
		}
		else
		{
			classval	=	"QRYODD";
		}

		records=(ArrayList) result.get(j);	
		strDocType=(String)records.get(0);						
		if ( strDocType== null || strDocType.equalsIgnoreCase("null")){
			strDocType="";}						
		strDocNum=(String)records.get(1);
		if ( strDocNum== null || strDocNum.equalsIgnoreCase("null")){
			strDocNum="";}
		strDocDate=(String)records.get(2);						
		if ( strDocDate== null || strDocDate.equalsIgnoreCase("null")){
			strDocDate="";}						
		strBillAmt=(String)records.get(3);
		if ( strBillAmt== null || strBillAmt.equalsIgnoreCase("null")){
			strBillAmt="0";}
			strBillAmt = cf.formatCurrency(strBillAmt, noofdecimal);
		strDepAdjust=(String)records.get(4);						
		if ( strDepAdjust== null || strDepAdjust.equalsIgnoreCase("null")){
			strDepAdjust="";}									
			strDepAdjust = cf.formatCurrency(strDepAdjust, noofdecimal);
		strDisAmt=(String)records.get(5);
		if ( strDisAmt== null || strDisAmt.equalsIgnoreCase("null")){
			strDisAmt="0";}
			strDisAmt = cf.formatCurrency(strDisAmt, noofdecimal);
		strRoundAmt=(String)records.get(6);						
		if ( strRoundAmt== null || strRoundAmt.equalsIgnoreCase("null")){
			strRoundAmt="0";}	
			strRoundAmt = cf.formatCurrency(strRoundAmt, noofdecimal);
		strBillPaidAmt=(String)records.get(7);
		if ( strBillPaidAmt== null || strBillPaidAmt.equalsIgnoreCase("null")){
			strBillPaidAmt="0";}
			strBillPaidAmt = cf.formatCurrency(strBillPaidAmt, noofdecimal);

		strOutstandAmt=(String)records.get(8);						
		if ( strOutstandAmt== null || strOutstandAmt.equalsIgnoreCase("null")){
			strOutstandAmt="0";}		
			strOutstandAmt = cf.formatCurrency(strOutstandAmt, noofdecimal);
		strCancelled=(String)records.get(9);
		if ( strCancelled== null || strCancelled.equalsIgnoreCase("null")){
			strCancelled="";}
		strBillTotAdjAmt=(String)records.get(10);						
		if ( strBillTotAdjAmt== null || strBillTotAdjAmt.equalsIgnoreCase("null")){
			strBillTotAdjAmt="0";}	
			strBillTotAdjAmt = cf.formatCurrency(strBillTotAdjAmt, noofdecimal);

		strBillTotExmtAmt=(String)records.get(11);
		if ( strBillTotExmtAmt== null || strBillTotExmtAmt.equalsIgnoreCase("null")){
			strBillTotExmtAmt="0";}
			strBillTotExmtAmt = cf.formatCurrency(strBillTotExmtAmt, noofdecimal);

		strBillTotWriteOffAmt=(String)records.get(12);						
		if ( strBillTotWriteOffAmt== null || strBillTotWriteOffAmt.equalsIgnoreCase("null")){
			strBillTotWriteOffAmt="0";}						
			strBillTotWriteOffAmt = cf.formatCurrency(strBillTotWriteOffAmt, noofdecimal);

		strCustName=(String)records.get(13);
		if ( strCustName== null || strCustName.equalsIgnoreCase("null")){
			strCustName="";}
		strBillGrpDesc=(String)records.get(14);
		if ( strBillGrpDesc== null || strBillGrpDesc.equalsIgnoreCase("null")){
			strBillGrpDesc="";}
			strPolicyNum=(String)records.get(15);
		if ( strPolicyNum== null || strPolicyNum.equalsIgnoreCase("null")){
			strPolicyNum="";}
//		strFacilityId=(String)records.get(16);
//		if ( strFacilityId== null || strFacilityId.equalsIgnoreCase("null")){							strFacilityId="";}

		strPolicyDesc=(String)records.get(17);
		if ( strPolicyDesc== null || strPolicyDesc.equalsIgnoreCase("null")){
			strPolicyDesc="";}

		strDocDate = com.ehis.util.DateUtils.convertDate(strDocDate,"DMYHMS","en",locale);				
%>		<tbody>	
		<tr id=row<%=i%>>			
			<td class=<%=classval%> width='8%' ><%=strDocType%></td>	 
			<td class=<%=classval%> width="8%" align='"right'><a name='doc_num<%=i%>' href="#" onClick="javascript:callchardet('<%=strDocType%>','<%=strDocNum%>','<%=strDocDate%>')"><%=strDocNum%></a> </td>		
			<td class=<%=classval%> width="18%"><%=strDocDate%></td>
			<td class=<%=classval%> width="15%"><%=strBillGrpDesc%></td>
			<td class=<%=classval%> width="15%"><%=strCustName%></td>
			<td class=<%=classval%> width="13%"><%=strPolicyDesc%></td>
			<td class=<%=classval%> width="8%" style='text-align:right'><%=strBillAmt%></td>	
			
<%			
		if(Float.parseFloat(strBillPaidAmt)!=0)
		{			
%>
			<td class=<%=classval%> width="8%" style='text-align:right'><a name='paid_amt' href="#" onClick="javascript:callpaymentdet('<%=strDocType%>','<%=strDocNum%>','<%=strDocDate%>')"><%=strBillPaidAmt%></a></td>
<%
		}
	else{
		
%>
			<td width="10%" class=<%=classval%> style='text-align:right'><%=strBillPaidAmt%></td>
<%			
	}
%>
			<td class=<%=classval%> width="8%" style='text-align:right'><%=strOutstandAmt%></td>  
			<td class=<%=classval%> width="1%"><a href='#' onMouseOver='displayToolTip(<%=strDepAdjust%>,<%=strDisAmt%>,<%=strBillTotExmtAmt%>,<%=strBillTotAdjAmt%>,<%=strRoundAmt%>)' onMouseOut='hideToolTip()' onFocus='displayToolTip(<%=strDepAdjust%>,<%=strDisAmt%>,<%=strBillTotExmtAmt%>,<%=strBillTotAdjAmt%>,<%=strRoundAmt%>)'
			onBlur='hideToolTip()' > >> </a></td>
		</tr>
			 <%
				i++;		
 			}//while
			%>			
		</tbody>
		</table>
		</div>	
<%
		out.flush();		
		} else {
%>
	<div id="tbl-container" STYLE="overflow: auto; /* width: 1020px; */ height: 240px;   padding:3px; margin: 0px">
	<table border='1' cellpadding='3' cellspacing='0' align = 'center' id='enctr_bill_det' width='100%'>			
	<thead><tr>			
		<th class='COLUMNHEADER' width='8%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>
		<th class='COLUMNHEADER' width='8%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></th>
		<th class='COLUMNHEADER' width='18%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
		<th class='COLUMNHEADER' width='15%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></th>
		<th class='COLUMNHEADER' width='15%'><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></th>
		<th class='COLUMNHEADER' width='13%'><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></th>
		<th class='COLUMNHEADER' width='8%'><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></th>
		<th class='COLUMNHEADER' width='8%'><fmt:message key="eBL.PAID_AMT.label" bundle="${bl_labels}"/></th>	
		<th class='COLUMNHEADER' width='8%'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></th>
		<th class='COLUMNHEADER' width='1%'></th>
	</tr></thead>
	<tbody>
<%
	java.util.Locale loc = new java.util.Locale("en");
	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
	String noRecord = bl_labels.getString("BL9811");
%>
	<tr>
		<td colspan='10'><div align='center'><%=noRecord%></div></td>
	</tr>
	</tbody>
	</table></div>
	<script></script>
<%
	//if (rs != null)   rs.close();
	//if (pstmt != null) pstmt.close();	
	}
	}catch(Exception ee)
	{
		System.out.println("Exception in qry" +ee);
		ee.printStackTrace();
	}
%>		
<%
try{	
	if(strEpisodeType.equals("D") || strEpisodeType.equals("I"))
	{
		String sqlDI="Select tot_billed_amt, tot_bills_paid_amt, tot_outst_amt, tot_unbld_amt from bl_episode_fin_dtls Where  operating_facility_id ='"+p_facility_id+"' and EPISODE_TYPE =  '"+strEpisodeType+"' and  EPISODE_ID   ='"+strEpisodeId+"'";
			pstmt = con.prepareStatement(sqlDI);
			rs1 = pstmt.executeQuery();	
			while(rs1.next())
			{
				strTotBilledAmt  =  rs1.getString(1);	
				if(strTotBilledAmt==null) strTotBilledAmt="0";
				strTotBilledAmt = cf.formatCurrency(strTotBilledAmt, noofdecimal);

				strTotBillsPaidAmt  =  rs1.getString(2);	
				if(strTotBillsPaidAmt==null) strTotBillsPaidAmt="0";
				strTotBillsPaidAmt = cf.formatCurrency(strTotBillsPaidAmt, noofdecimal);

				strTotOutStdAmt  =  rs1.getString(3);	
				if(strTotOutStdAmt==null) strTotOutStdAmt="0";
				strTotOutStdAmt = cf.formatCurrency(strTotOutStdAmt, noofdecimal);

				strTotUnBilledAmt  =  rs1.getString(4);	
				if(strTotUnBilledAmt==null) strTotUnBilledAmt="0";
				strTotUnBilledAmt = cf.formatCurrency(strTotUnBilledAmt, noofdecimal);	
			}
			if (rs1 != null)   rs1.close();
			if (pstmt != null) pstmt.close();				
	}
	else if(strEpisodeType.equals("E") || strEpisodeType.equals("O"))
	{
		String sqlEO="Select tot_billed_amt, tot_unbld_amt, b.bill_paid_amt, tot_outst_amt  from bl_visit_fin_dtls a,(Select sum(nvl(bill_paid_amt,0)+nvl(prepay_adj_amt,0)+nvl(deposit_adj_amt,0)) bill_paid_amt from bl_bill_hdr b where episode_type='"+strEpisodeType+"' and patient_id='"+strPatientId+"' and operating_facility_id='"+p_facility_id+"' and EPISODE_ID   	='"+strEpisodeId+"' and visit_id = '"+strVisitId+"') b Where a.operating_facility_id = '"+p_facility_id+"' and a.EPISODE_TYPE =  '"+strEpisodeType+"' and a.EPISODE_ID   ='"+strEpisodeId+"' and a.visit_id = '"+strVisitId+"'";
	
		pstmt = con.prepareStatement(sqlEO);
		rs2 = pstmt.executeQuery();	

		while(rs2.next())
		{
			strTotBilledAmt  =  rs2.getString(1);	
			if(strTotBilledAmt==null) strTotBilledAmt="0";
			strTotBilledAmt = cf.formatCurrency(strTotBilledAmt, noofdecimal);

			strTotUnBilledAmt  =  rs2.getString(2);	
			if(strTotUnBilledAmt==null) strTotUnBilledAmt="0";
			strTotUnBilledAmt = cf.formatCurrency(strTotUnBilledAmt, noofdecimal);

			strTotBillsPaidAmt  =  rs2.getString(3);	
			if(strTotBillsPaidAmt==null) strTotBillsPaidAmt="0";
			strTotBillsPaidAmt = cf.formatCurrency(strTotBillsPaidAmt, noofdecimal);

			strTotOutStdAmt  =  rs2.getString(4);	
			if(strTotOutStdAmt==null) strTotOutStdAmt="0";
			strTotOutStdAmt = cf.formatCurrency(strTotOutStdAmt, noofdecimal);
		}
			if (rs2 != null)   rs2.close();
			if (pstmt != null) pstmt.close();			
	}
	else{
			String sqlall="Select tot_billed_ref_amt,  tot_outst_ref_amt,  tot_unbld_ref_amt ,b.bill_paid_amt from bl_patient_fin_dtls a, (Select sum(nvl(bill_paid_amt,0)+nvl(prepay_adj_amt,0)+nvl(deposit_adj_amt,0)) bill_paid_amt from bl_bill_hdr b where episode_type='R' and patient_id='"+strPatientId+"' and operating_facility_id='"+p_facility_id+"') b Where  patient_id = '"+strPatientId+"'";             
			pstmt = con.prepareStatement(sqlall);
			rs3 = pstmt.executeQuery();	
			while(rs3.next())
			{
				strTotBilledAmt  =  rs3.getString(1);	
				if(strTotBilledAmt==null) strTotBilledAmt="0";
				strTotBilledAmt = cf.formatCurrency(strTotBilledAmt, noofdecimal);
				
				strTotOutStdAmt  =  rs3.getString(2);	
				if(strTotOutStdAmt==null) strTotOutStdAmt="0";
				strTotOutStdAmt = cf.formatCurrency(strTotOutStdAmt, noofdecimal);
				
				strTotUnBilledAmt  =  rs3.getString(3);	
				if(strTotUnBilledAmt==null) strTotUnBilledAmt="0";
				strTotUnBilledAmt = cf.formatCurrency(strTotUnBilledAmt, noofdecimal);

				strTotBillsPaidAmt  =  rs3.getString(4);	
				if(strTotBillsPaidAmt==null) strTotBillsPaidAmt="0";
				strTotBillsPaidAmt = cf.formatCurrency(strTotBillsPaidAmt, noofdecimal);	
			}								
			if (rs3 != null)   rs3.close();
			if (pstmt != null) pstmt.close();
		}
		}catch(Exception e1)
		{
			System.out.println("Exception summary" + e1);
		}
		strTotBilledAmt= cf.formatCurrency(strTotBilledAmt, noofdecimal);
		strTotBillsPaidAmt= cf.formatCurrency(strTotBillsPaidAmt, noofdecimal);
		strTotOutStdAmt= cf.formatCurrency(strTotOutStdAmt, noofdecimal);
		strTotUnBilledAmt = cf.formatCurrency(strTotUnBilledAmt, noofdecimal);
%>
	<div >
	<table border='0' cellpadding='3' cellspacing='0' align = 'center' width='100%'>
		<th class='COLUMNHEADER' COLSPAN='4' align="left"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></th>
		<tr>
			<td class="label" width="25%"><fmt:message key="eBL.BILLED_AMT.label"   bundle="${bl_labels}"/></td>			
			<td class='fields' width="25%"><%=strTotBilledAmt%></td>  
			<td class="label" width="25%"><fmt:message key="eBL.PAID_AMT.label"   bundle="${bl_labels}"/></td>			
			<td class='fields' width="25%"><%=strTotBillsPaidAmt%></td>  
			<!--<td class='fields' width="25%"><a name='paid_amt' href="javascript:callpaymentdet()"><%=strTotBillsPaidAmt%></a></td>-->
		</tr>
		<tr>
			<td class="label" width="25%"><fmt:message key="Common.outstandingamount.label"   bundle="${common_labels}"/></td>		
			<td class='fields' width="25%"><%=strTotOutStdAmt%></td>  
			<td class="label" width="25%"><fmt:message key="eBL.UNBILLED_AMT.label"   bundle="${bl_labels}"/></td>			

<%	
	strTotUnBilledAmt = cf.formatCurrency(strTotUnBilledAmt, noofdecimal);
	if(Float.parseFloat(strTotUnBilledAmt)!=0)
	{		
%>			
		<td class='fields' width="25%"><a name='unbilled_amt' href="#" onClick="callunbillchardet('<%=strDocType%>','<%=strDocNum%>','<%=strDocDate%>')"><%=strTotUnBilledAmt%></a></td>
<%
	}else{	
%>
		<td class='fields' width="25%"><%=strTotUnBilledAmt%></td>			
<%		
	}		
%>
	</tr>
	</table>
	</div>
<%
	}catch(Exception eee)
		{
			System.out.println("Exception main"+ eee);
		}
		finally 
		{				
			if(con!=null) {
				ConnectionManager.returnConnection(con, request);
			}
		}
%>
<input type='hidden' name='query_string' id='query_string' value='<%=strQuerystring%>' >
<input type='hidden' name='facility_id' id='facility_id' value='<%=p_facility_id%>' >
<input type='hidden' name='doc_type' id='doc_type' value='<%=strDocType%>' >
<input type='hidden' name='doc_num' id='doc_num' value='<%=strDocNum%>' >
<input type='hidden' name='doc_date' id='doc_date' value='<%=strDocDate%>' >
<input type='hidden' name='locale' id='locale' value='<%=locale%>' >
<input type='hidden' name='noofdecimal' id='noofdecimal' value='<%=noofdecimal%>' >

<div name='tooltiplayer' id='tooltiplayer' style='position:relative; width:75%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=3 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='t'></td>
				</td>
			</tr>
		</table>
	</div>
</form>
</body>
<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLViewEncounterBillDet.jsp",searched));%>
</html>

