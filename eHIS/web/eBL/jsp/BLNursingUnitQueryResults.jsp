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

	HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");			
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";	
	String classval=""; String strFacilityId=""; int total_records=0;
	int noofdecimal = 2;
	String strNursingUnitCode = "", strCalledFrom="";
	String strPatientId="", strPatientName="", strEncounterId="", strAdmVstDate="", strDischargeDate="", strExpectDischargeDate="", strBlngGrpId="";
	String strUnbilledAmt="", strBilledAmt="", strPaidAmt="", strOutstAmt="", strInvAmt="", strRemarks="", strEpisodeType="";
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
		
		
		params = request.getQueryString();
		if(params==null) params="";	

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				noofdecimal  =  rs.getInt(1);		
			}	
			rs.close();
			pstmt.close();
			
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
		<script language="javascript" src="../../eBL/js/BLNursingUnitBillingDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
	
		<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
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
/*
function resizeWindow(orderctlHDR)
{
	var orderctlHDR1 = orderctlHDR.id;

	var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
	var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;		
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
alert(x);
alert(y);
	document.getElementById("tooltiplayer").style.posLeft= x;
	document.getElementById("tooltiplayer").style.posTop = y;
	document.getElementById("tooltiplayer").style.visibility='visible';

}
*/
function resizeWindow(orderctlHDR)
{
	var orderctlHDR1 = orderctlHDR.id;

	var wdth = document.getElementById('orderctlHDR1').offsetWidth;
	var hght1 = document.getElementById('orderctlHDR1').offsetHeight;		
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;	

	bodwidth = parent.frames[0].document.body.offsetWidth;
	bodheight = parent.frames[0].document.body.offsetHeight;

	var x =event.x;
	var y =event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth);
	y = y + (document.getElementById("tooltiplayer").offsetHeight);

	if(x<bodwidth){
		x= wdth1;			
	}else{			
		x = getPos(orderctlHDR).x;
	}
/*	if(x<bodwidth)
			x = event.x ;
		else
			x = x - (document.getElementById("tooltiplayer").offsetWidth);
*/
	if(y<bodheight)
	{
		 y =event.y;
	}
	else
	{
		y = y - (document.getElementById("tooltiplayer").offsetHeight);
	}
	
	y+=document.body.scrollTop;
//	x+=document.body.scrollLeft;

	document.getElementById("tooltiplayer").style.left= x+"px";
	document.getElementById("tooltiplayer").style.top = y-12+"px";
	document.getElementById("tooltiplayer").style.backgroundColor="white";
	document.getElementById("tooltiplayer").style.border= "1px solid black";
	document.getElementById("tooltiplayer").style.visibility='visible';
}

function displayToolTip(orderctlHDR,orderctlHDR1,imgObj,i,strPatientId,strEpisodeType,strEpisodeId,strEncounterId)
{
	callMouseOverOnTD(orderctlHDR,orderctlHDR1,imgObj,i);
	buildTable(i);
	resizeWindow(orderctlHDR);
}

function hideToolTip1()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}

function buildTable(curr_rec)
{
//	var val = ("Bill/Payment Details,Diagnosis,Procedures");
	var temp_val = getLabel("eBL.BILL_PYMT_DTLS.label","BL")+","+getLabel("Common.diagnosis.label","common")+","+getLabel("Common.Procedures.label","common");

	var val=(temp_val);
	var row  = ("Bill/Payment Details,Diagnosis,Procedures");
	var rowval   = val.split (",");		
	rowval1      = row.split(",");
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<rowval.length; i++ ) 
	{
		var colval  = rowval[i];
		var colval1 = rowval1[i];
        if (colval != "")
        {     
				tab_dat     += "<tr>"
				if(colval1 == "Bill/Payment Details")
				{
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href='javascript:funViewEncounterDet("+curr_rec+")'>"+colval+" </a></td>";
				}
				else if(colval1 == "Diagnosis")
				{
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href='javascript:funViewDiagDet("+curr_rec+")'>"+colval+" </a></td>";
				}
				else
				{
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href='javascript:funViewProcsDet("+curr_rec+")'>"+colval+" </a></td>";
				}
				tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";
	document.getElementById("t").innerHTML = tab_dat;
}

async function funViewEncounterDet(curr_rec)
{
	var strPatientId="", strEpisodeType="", strEpisodeId="", strEncounterId="";

	var total_records = document.forms[0].total_records.value;
	for(var i=0;i<total_records;i++)
	{
		if(i == curr_rec)
		{
			var pat_id = eval(document.getElementById("pat_id"+curr_rec));
			strPatientId = pat_id.innerText;

			var enc_id = eval(document.getElementById("enc_id"+curr_rec));
			strEpisodeId = enc_id.innerText;

			strEncounterId = strEpisodeId;

			var episode_type = eval("document.forms[0].episode_type"+curr_rec);
			strEpisodeType = episode_type.value;
		}
	}
	var center='1';
	var dialogTop = "320";
	var dialogHeight = "70vh" ;
	var dialogWidth = "70vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title="";
	title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+strPatientId+"&episode_type="+strEpisodeType+"&episode_id="+strEpisodeId+"&encounter_id="+strEncounterId;
	retVal=await top.window.showModalDialog("../../eBL/jsp/BLViewEncounterBillDetMain.jsp?"+param,arguments,features);
}

async function funViewDiagDet(curr_rec)
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

	var dialogHeight = "70vh" ;
	var dialogWidth = "70vw" ;
	var dialogTop = "75";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";status=no;scroll=no" ;
	var arguments   = "" ;
	var params = "../../eCA/jsp/PatProblemList.jsp?patient_id="+strPatientId+"&encounter_id="+strEncounterId+"&modal_yn=Y&called_mod=BL";
	var retVal = await top.window.showModalDialog(params,arguments,features);
}

async function funViewProcsDet(curr_rec)
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

	var dialogHeight = "70vh" ;
	var dialogWidth = "70vw" ;
	var dialogTop = "75";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";status=no;scroll=no" ;
	var arguments   = "" ;
	var params = "../../eBL/jsp/BLNursingUnitPatientProcedureDetailsFrame.jsp?patient_id="+strPatientId+"&encounter_id="+strEncounterId+"&modal_yn=Y&called_mod=BL";
	var retVal = await top.window.showModalDialog(params,arguments,features);
}

async function ViewBLDtl(episodeid,visitid,patientid)
{
  var retVal                                   =          new String();

            var episode1                              ="";
            /* var dialogTop                             = "200px";
        	var dialogHeight                         = "400px" ; 
        	var dialogWidth                          = "700px" ; */
        	var dialogTop                             = "0vh";
        	var dialogHeight                         = "90vh" ; 
        	var dialogWidth                          = "90vw" ; 
            var features                                = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
            var arguments                            = "" ;
            var search_desc                         =""; 
            var title                                      =getLabel("eBL.PAT_ENCOUNTER_FIN_DTLS.label","BL");
		    var column_sizes = escape("");               
            var column_descriptions ="";       
            var param =            "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episodeid="+
            episodeid+"&"+"visitid="+visitid+"&"+"patientid="+patientid+"&episode1="+episode1;
            retVal= await top.window.showModalDialog("../../eBL/jsp/BLFinDtlQryMain.jsp?"+param,arguments,features);
}
</script>
<body onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();">
<form name='BLNursingUnitQueryForm' id='BLNursingUnitQueryForm' action="" method="post" target="">
<%
		try
		{
			String sqlPatEncDet="";

			if(strCalledFrom.equals("TDP"))
			{
				sqlPatEncDet="Select b.PATIENT_ID PATIENT_ID,decode('"+locale+"','en',patient_name,PATIENT_NAME_LOC_LANG) PATIENT_NAME,c.EPISODE_ID ENCOUNTER_ID,to_char(b.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') ADM_VISIT_DATE,to_char(b.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') DISCHR_DATE_TIME,e.SHORT_DESC BLNG_GRP_DESC,c.TOT_UNBLD_AMT UNBILLED_AMT,c.TOT_BILLED_AMT BILLED_AMT,c.TOT_BILLS_PAID_AMT PAID_AMT,c.TOT_OUTST_AMT OUTST_AMT,c.TOT_AR_AMT_TRANSFERRED INC_AMT,c.REMARK REMARKS,c.EPISODE_TYPE EPISODE_TYPE,to_char(b.EXP_DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') EXP_DISCHARGE_DATE_TIME from PR_ENCOUNTER B,bl_episode_fin_dtls c, mp_patient d, bl_blng_grp_lang_vw e where a.FACILITY_ID = '"+strFacilityId+"' b.EPISODE_ID = c.EPISODE_ID and b.FACILITY_ID=c.operating_FACILITY_ID and b.patient_id = c.patient_id and c.patient_id = d.patient_id and c.blng_grp_id = e.blng_grp_id and b.ASSIGN_CARE_LOCN_CODE='"+strNursingUnitCode+"' and e.language_id='"+locale+"' and trunc(b.DISCHARGE_DATE_TIME) = trunc(sysdate)";
			}
			else
			{
				sqlPatEncDet="Select a.PATIENT_ID PATIENT_ID,decode('"+locale+"','en',patient_name,PATIENT_NAME_LOC_LANG) PATIENT_NAME,a.OPEN_EPISODE_ID ENCOUNTER_ID,to_char(a.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') ADM_VISIT_DATE,to_char(b.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') DISCHR_DATE_TIME,e.SHORT_DESC BLNG_GRP_DESC,c.TOT_UNBLD_AMT UNBILLED_AMT,c.TOT_BILLED_AMT BILLED_AMT,c.TOT_BILLS_PAID_AMT PAID_AMT,c.TOT_OUTST_AMT OUTST_AMT,c.TOT_AR_AMT_TRANSFERRED INC_AMT,c.REMARK REMARKS,c.EPISODE_TYPE EPISODE_TYPE,to_char(b.EXP_DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') EXP_DISCHARGE_DATE_TIME from IP_OPEN_EPISODE a, PR_ENCOUNTER B,bl_episode_fin_dtls c, mp_patient d, bl_blng_grp_lang_vw e where a.FACILITY_ID = '"+strFacilityId+"' and a.FACILITY_ID = b.FACILITY_ID and b.FACILITY_ID = c.OPERATING_FACILITY_ID and a.OPEN_EPISODE_ID = B.EPISODE_ID and b.EPISODE_ID = c.EPISODE_ID and a.patient_id = b.patient_id and b.patient_id = c.patient_id and c.patient_id = d.patient_id and c.blng_grp_id = e.blng_grp_id and b.ASSIGN_CARE_LOCN_CODE='"+strNursingUnitCode+"' and e.language_id='"+locale+"'";
			}
			
			if(strCalledFrom.equals("CIP"))
			{
				sqlPatEncDet = sqlPatEncDet+" and b.DISCHARGE_DATE_TIME is NULL";
			}
			else if(strCalledFrom.equals("TED"))
			{
//				sqlPatEncDet = sqlPatEncDet+" and b.DISCHARGE_DATE_TIME is NULL and trunc(b.EXP_DISCHARGE_DATE_TIME) = trunc(sysdate) and exists (select 'X' from IP_DISCHARGE_ADVICE f where f.ENCOUNTER_ID=b.ENCOUNTER_ID and f.DIS_ADV_STATUS <> '9' and trunc(f.EXPECTED_DISCHARGE_DATE)=trunc(sysdate))";
				sqlPatEncDet = sqlPatEncDet+" and b.DISCHARGE_DATE_TIME is NULL and trunc(b.EXP_DISCHARGE_DATE_TIME) = trunc(sysdate)";
			}
			else if(strCalledFrom.equals("TDP"))
			{
				sqlPatEncDet = sqlPatEncDet+" and trunc(b.DISCHARGE_DATE_TIME) = trunc(sysdate)";
			}

				
			sqlPatEncDet=sqlPatEncDet+ " order by to_date(b.VISIT_ADM_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') desc";

			HashMap sqlMap = new HashMap();
			sqlMap.put("sqlData",sqlPatEncDet);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("PATIENT_ID");
			displayFields.add("PATIENT_NAME");
			displayFields.add("ENCOUNTER_ID");
			displayFields.add("ADM_VISIT_DATE");
			displayFields.add("DISCHR_DATE_TIME");
			displayFields.add("BLNG_GRP_DESC");
			displayFields.add("UNBILLED_AMT");
			displayFields.add("BILLED_AMT");
			displayFields.add("PAID_AMT");
			displayFields.add("OUTST_AMT");
			displayFields.add("INC_AMT");
			displayFields.add("REMARKS");
			displayFields.add("EPISODE_TYPE");
			displayFields.add("EXP_DISCHARGE_DATE_TIME");
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			//out.println("resutl==>"+result.size());
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
			{

%>
		<div>
		<table border='0' cellpadding='0' cellspacing='0' align = 'center' id='' width='100%'>						
			
			<tr>	
			<td width="80%" class="white">&nbsp;</td>
			<td width="20%" class="white">&nbsp;
<%			
				out.println(result.get(1));
%>
				</td>
			</tr>
		</table>
		</div>
		<div id="tbl-container" STYLE="overflow: auto; padding:3px; margin: 0px; height: 155px">
		<table border='1' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>
		<thead>
			<tr>			
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
<%
				if(strCalledFrom.equals("CIP") || strCalledFrom.equals("TED"))
				{
%>
				<td class='COLUMNHEADER' width='8%'><fmt:message key="eIP.ExpectesDischargeDate.label" bundle="${ip_labels}"/></td>
<%
				}
				else
				{
%>
				<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
<%
				}
%>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.PAID_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.INV_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>			
			</tr>
		</thead>
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
			
				strPatientId = (String)records.get(0);
				if(strPatientId==null) strPatientId="";
				
				strPatientName = (String)records.get(1);
				if(strPatientName==null) strPatientName="";

				strEncounterId = (String)records.get(2);
				if(strEncounterId==null) strEncounterId="";
				
				strAdmVstDate = (String)records.get(3);
				if(strAdmVstDate==null) strAdmVstDate="";
				
				strDischargeDate = (String)records.get(4);
				if(strDischargeDate==null) strDischargeDate="";

				strBlngGrpId = (String)records.get(5);
				if(strBlngGrpId==null) strBlngGrpId="";

				strUnbilledAmt = (String)records.get(6);
				if(strUnbilledAmt==null) strUnbilledAmt="0";

				strBilledAmt = (String)records.get(7);
				if(strBilledAmt==null) strBilledAmt="0";

				strPaidAmt = (String)records.get(8);
				if(strPaidAmt==null) strPaidAmt="0";

				strOutstAmt = (String)records.get(9);
				if(strOutstAmt==null) strOutstAmt="0";

				strInvAmt = (String)records.get(10);
				if(strInvAmt==null) strInvAmt="0";

				strRemarks = (String)records.get(11);
				if(strRemarks==null) strRemarks="&nbsp;";

				strEpisodeType = (String)records.get(12);
				if(strEpisodeType==null) strEpisodeType="";

				strExpectDischargeDate = (String)records.get(13);
				if(strExpectDischargeDate==null) strExpectDischargeDate="";

	
				if(!strAdmVstDate.equals(""))
					strAdmVstDate = com.ehis.util.DateUtils.convertDate(strAdmVstDate,"DMYHMS","en",locale);
				if(!strDischargeDate.equals(""))
					strDischargeDate = com.ehis.util.DateUtils.convertDate(strDischargeDate,"DMYHMS","en",locale);
				if(!strExpectDischargeDate.equals(""))
					strExpectDischargeDate = com.ehis.util.DateUtils.convertDate(strExpectDischargeDate,"DMYHMS","en",locale);

				if(strExpectDischargeDate.equals("") || strExpectDischargeDate == null) strExpectDischargeDate="&nbsp;";
				if(strDischargeDate.equals("") || strDischargeDate == null) strDischargeDate="&nbsp;";

				strUnbilledAmt = cf.formatCurrency(strUnbilledAmt, noofdecimal);
				strBilledAmt = cf.formatCurrency(strBilledAmt, noofdecimal);
				strPaidAmt = cf.formatCurrency(strPaidAmt, noofdecimal);
				strOutstAmt = cf.formatCurrency(strOutstAmt, noofdecimal);
				strInvAmt = cf.formatCurrency(strInvAmt, noofdecimal);
%>
		<tbody>
			<tr id=row<%=i%> onMouseOver="hideToolTip(this,'imgArrow<%=i%>','<%=i%>');">	
			<!-- <td class=<%=classval%> width='10%'><%=strPatientId%></td>	 -->
				<td width='10%' wrap style='cursor:pointer' class='<%=classval%>' id="patient_id_<%=i%>" onclick="displayToolTip(this,document.getElementById('pat_name'+<%=i%>),'imgArrow<%=i%>','<%=i%>','<%=strPatientId%>','<%=strEpisodeType%>','<%=strEncounterId%>','<%=strEncounterId%>')" ><DIV id='pat_id<%=i%>'> <%=strPatientId%><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>' ></DIV></td>
				<td class=<%=classval%> width='15%' id='pat_name<%=i%>'><DIV ><%=strPatientName%></DIV></td>	 
				<td class=<%=classval%> width='8%'><DIV id='enc_id<%=i%>'><a href="javascript:ViewBLDtl('<%=strEncounterId%>','','<%=strPatientId%>');"><%=strEncounterId%></DIV></a></td>	 
				<td class=<%=classval%> width='8%'><DIV id='adm_vst_date<%=i%>'><%=strAdmVstDate%></DIV></td>
<%
				if(strCalledFrom.equals("CIP") || strCalledFrom.equals("TED"))
				{
%>
				<td class=<%=classval%> width='8%'><DIV id='dischr_date<%=i%>'><%=strExpectDischargeDate%></DIV></td>	 
<%
				}
				else
				{
%>
				<td class=<%=classval%> width='8%'><DIV id='dischr_date<%=i%>'><%=strDischargeDate%></DIV></td>	 
<%
				}
%>

				<td class=<%=classval%> width='15%'><DIV id='blng_grp_id<%=i%>'><%=strBlngGrpId%></DIV></td>	 
				<td class=<%=classval%> width='10%'><DIV id='unb_amt<%=i%>' style='text-align:right'><%=strUnbilledAmt%></DIV></td>	 
				<td class=<%=classval%> width='10%'><DIV id='billd_amt<%=i%>' style='text-align:right'><%=strBilledAmt%></DIV></td>	
				<td class=<%=classval%> width='10%'><DIV id='paid_amt<%=i%>' style='text-align:right'><%=strPaidAmt%></DIV></td>	 				
				<td class=<%=classval%> width='10%'><DIV id='outst_amt<%=i%>' style='text-align:right'><%=strOutstAmt%></DIV></td>	 
				<td class=<%=classval%> width='10%'><DIV id='inv_amt<%=i%>' style='text-align:right'><%=strInvAmt%></DIV></td>	 
				<td class=<%=classval%> width='10%'><DIV id='remarks<%=i%>'><%=strRemarks%></DIV></td>	
				<input type='hidden' name='episode_type<%=i%>' id='episode_type<%=i%>' value='<%=strEpisodeType%>'>
			</tr>
<%
				i++;
				total_records++; 
			}//for loop
%>
		</tbody>
		</table>
		</div>
<%
				out.flush();
			}
			else
			{

			 %>
		<div id="tbl-container" STYLE="overflow: auto; padding:3px; margin: 0px; height: 155px">
		<table border='1' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
		<thead>
			<tr>			
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
<%
				if(strCalledFrom.equals("CIP") || strCalledFrom.equals("TED"))
				{
%>
				<td class='COLUMNHEADER' width='8%'><fmt:message key="eIP.ExpectesDischargeDate.label" bundle="${ip_labels}"/></td>
<%
				}
				else
				{
%>
				<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
<%
				}
%>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.PAID_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.INV_AMT.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>			
			</tr>
		</thead>
			<tbody>
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
-->
			</tbody>
			</table></div>
<%
			}
		}
		catch(Exception ee)
		{
			System.err.println("Exception in Nursing Unit Query Results" +ee); 
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
	<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLNursingUnitQueryResults.jsp",searched));%>
</body>
</HTML>

