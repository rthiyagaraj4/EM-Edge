<!DOCTYPE html>
<!--
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			V210517				17598			Common-ICN-0034				Mohana Priya K
----------------------------------------------------------------------------------------------
-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt = null; 
	ResultSet rsdt=null;
	ResultSet rs1	=null;ResultSet rs2=null;ResultSet rs3=null;	
	HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");			
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";	
	String classval=""; String strFacilityId=""; int total_records=0;
	String strPatientId="";String p_episode_id="";String p_visit_id="";String p_episode_type="";
	String p_encntr_to_date="";String p_encntr_from_date="";
	String strEpisodeType="";String strEpisodeId="";String strVisitId="";String strEncounterId="";String strAdmVstDate="";
	String strDischargeDate="";	String strAdmVstStatus="";String strCurrRoomNo="";String strCurrBedNo="",strPractId="",strLocnCode="";
	String strLocationDesc="";	String strPayerName="";
	String strPriviledge=""; String patln="";  String epsode_type_leb="";String system_date="";String function_id="",params="",p_ward_clinic_code="";
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
	String strTitle=(String) common_labels.getString("Common.PatientDetails.label");

	Properties p = (Properties)httpSession.getValue("jdbc");
	String ws_no = p.getProperty("client_ip_address");
	try
	{
		con	=	ConnectionManager.getConnection(request);

		strFacilityId = (String)httpSession.getValue("facility_id");
		if(strFacilityId==null) strFacilityId="";

		strPatientId = request.getParameter("sel_patient_id");
		if(strPatientId==null) strPatientId="";	
		
		p_episode_type = request.getParameter("sel_episode_type");
		if(p_episode_type==null) p_episode_type="";	
		
		p_episode_id = request.getParameter("sel_episode_id");
		if(p_episode_id==null) p_episode_id="";	
		
		p_visit_id = request.getParameter("sel_visit_id");
		if(p_visit_id==null) p_visit_id="";	
		
		p_encntr_to_date = request.getParameter("sel_encounter_to_date");
		if(p_encntr_to_date==null) p_encntr_to_date="";	
		
		p_encntr_from_date = request.getParameter("sel_encounter_from_date");
		if(p_encntr_from_date==null) p_encntr_from_date="";	
		
		function_id = request.getParameter("function_id");
		if(function_id==null) function_id="";

//		function_id = "EBL_ENTER_RECEIPT_REFUND";

		p_ward_clinic_code = request.getParameter("sel_ward_clinic_code");
		if(p_ward_clinic_code==null) p_ward_clinic_code="";	
		
		params = request.getQueryString();
		if(params==null) params="";	
		
		try
		{
			CallableStatement call = con.prepareCall("{ ? = call  get_patient_line(?,?)}");	
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.setString(2,strPatientId);
			call.setString(3,locale);
			call.execute();							
			patln = call.getString(1);				
			call.close();
			if ( patln == null ) patln = "";
			int ind=patln.indexOf("#");
			patln=patln.substring(0,ind);
			if ( patln == null ) patln = "";

			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			stmt = con.createStatement();
			rsdt = stmt.executeQuery(query_date) ;
			if( rsdt != null ) 
			{
				while( rsdt.next() )
				{  
					system_date = rsdt.getString(1);
				}
			}
			if (stmt != null) stmt.close(); //V210517
			if (rsdt != null) rsdt.close(); //V210517
			//stmt.close();
			//rsdt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in Sys Date :"+e);
			e.printStackTrace();
		}
%>
<HTML>
<HEAD>
</HEAD>
<script>

async function funSurgeryAddlCharges(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)
	{
		var params = document.forms[0].params.value;

		var center='1';
		var dialogTop = "70";
		var dialogHeight = "42" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	

		var param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id=SD00000866"+"&episode_type=I"+"&episode_id=10002544"+"&visit_id="+"&encounter_id=10002544"+"&pract_id=KATHRINA"+"&locn_code=IBA3"+"&role_pract_id=OPRSURG1||KATHRINA@@AMR1||DRANITA@@"+"&sec_key_main_oper_num=I080912001"+"&sec_key_main_order_id=OTIP00000014409"+"&str_order_catalog_code=0DTJ4ZZ|";	
		retVal= await window.showModalDialog("../../eBL/jsp/BLSurgeryAddlChargeFrame.jsp?"+param,arguments,features);
		var str =unescape(retVal);
		var arr = str.split(",");
		alert(arr[0]);
	}

async function funEnterReceiptRefund(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)
	{
		strPatientId="HC00004262";
		strEpisodeType="I";
		strEpisodeId="10019075";
		strEncounterId="10019075";
		strLocnCode="CCU";

		var params = document.forms[0].params.value;

		var center='1';
		var dialogTop = "70";
		var dialogHeight = "42" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+strPatientId+"&encounter_id="+strEncounterId+"&episode_type="+strEpisodeType+"&episode_id="+strEpisodeId+"&nursing_unit_code="+strLocnCode;	

		retVal= await window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);
	}
	
async function funAdhocDisc(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)
	{
		var params = document.forms[0].params.value;
		strPatientId = "HC00011186";
		strEpisodeType = "O";
		strEpisodeId = "10083669";
		strVisitId = "1";
		strEncounterId = "100836690001";
		strPractId = "AZWAN";
		strLocnCode = "";
		var center='1';
		var dialogTop = "10";
		var dialogHeight = "90vh" ;
		var dialogWidth = "90vw" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+strPatientId+"&episode_type="+strEpisodeType+"&episode_id="+strEpisodeId+"&visit_id="+strVisitId+"&encounter_id="+strEncounterId+"&pract_id="+strPractId+"&locn_code="+strLocnCode;	
		retVal= await window.showModalDialog("../../eBL/jsp/BLAdhocDiscFrame.jsp?"+param,arguments,features);
	}	

/*	function funEnterServiceRequest(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)
	{
		var params = document.forms[0].params.value;

		var center='1';
		var dialogTop = "70";
		var dialogHeight = "42" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
		var title="Enter Service Request";
		title=encodeURIComponent(title);	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+strPatientId+"&episode_type="+strEpisodeType+"&episode_id="+strEpisodeId+"&visit_id="+strVisitId+"&encounter_id="+strEncounterId+"&pract_id="+strPractId+"&locn_code="+strLocnCode;

		retVal=window.showModalDialog("../../eBL/jsp/BLEnterServiceRequestSearchMain.jsp?"+param,arguments,features);
	}	
*/
/*
	function funViewEncounterDet(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strLocnCode)
	{
		alert("ram");
		var visit_id = strVisitId;	

		var center='1';
		var dialogTop = "220";
		var dialogHeight = "100" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
		var title="";
		title=encodeURIComponent(title);	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		//var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"visit_id="+visit_id+"&patient_id="+strPatientId+"&episode_type="+strEpisodeType+"&episode_id="+strEpisodeId+"&visit_id="+visit_id+"&encounter_id="+strEncounterId;
		var billdoctypecode="HSBLOP";
		var strbilldocnum="50005306";
		var strblnggrpid="2C";

		var param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+billdoctypecode+"&"+"billdocnum="+strbilldocnum+"&"+"blnggrp="+strblnggrpid+"&episode_id="+strEpisodeId+"&visit_id="+visit_id+"&encounter_id="+strEncounterId;	
		alert(param);
		retVal=window.showModalDialog("../../eBL/jsp/BLBillSlmtMain.jsp?"+param,arguments,features);

		alert(retVal);
	}
*/


	async function funViewEncounterDet(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strLocnCode)
	{
		//var episode_type =strEpisodeType;
		//var patient_id = strPatientId;	
		var visit_id = strVisitId;	
		//var episode_id = strEpisodeId;	
		//var encounterid = strEncounterId;		
		var center='1';
		var dialogTop = "10px";
		var dialogHeight = "400px" ;
		var dialogWidth = "1100px" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
		var title="";
		title=encodeURIComponent(title);	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"visit_id="+visit_id+"&patient_id="+strPatientId+"&episode_type="+strEpisodeType+"&episode_id="+strEpisodeId+"&visit_id="+visit_id+"&encounter_id="+strEncounterId;
		retVal=await window.showModalDialog("../../eBL/jsp/BLViewEncounterBillDetMain.jsp?"+param,arguments,features);
	}

async function funVwEditVisitRegOrders(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)
	{
		var params = document.forms[0].params.value;
		var patient_class="";
		var center='1';
		var dialogTop = "70";
		var dialogHeight = "42" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+strPatientId+"&episode_type="+strEpisodeType+"&episode_id="+strEpisodeId+"&visit_id="+strVisitId+"&encounter_id="+strEncounterId+"&pract_id="+strPractId+"&locn_code="+strLocnCode+"&patient_class="+patient_class;	
		retVal= await window.showModalDialog("../../eBL/jsp/OrderEntryBillingFrameset.jsp?"+param,arguments,features);
		if(retVal=="undefined" || retVal=="2" || retVal==null)
		{
			alert("Cancelled");
		}
		else
		{
			alert("Success");
		}
	}	

	async function funVwEditBillReimburseAmt(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)
	{
		var params = document.forms[0].params.value;
		var patient_class="";
		var center='1px';
		var dialogTop = "0px";
		var dialogHeight = "95vh" ;
		var dialogWidth = "95vw" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+strPatientId+"&episode_type="+strEpisodeType+"&episode_id="+strEpisodeId+"&visit_id="+strVisitId+"&encounter_id="+strEncounterId+"&pract_id="+strPractId+"&locn_code="+strLocnCode+"&patient_class="+patient_class+"&"+params;	
		retVal=await window.showModalDialog("../../eBL/jsp/BLBillReimburseAmtCall.jsp?"+param,arguments,features);
		if(retVal == null || retVal == "null" || retVal == undefined || retVal == "undefined")
		{
			retVal == "";
		}

		if(retVal == "Y")
		{
			alert(getMessage("BL7356","BL"));
			return false;
		}
	}

	function no_record_check()
	{	
		var total_records=document.forms[0].total_records.value;			
		if(total_records==0)
		{
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			document.location.href="../../eCommon/html/blank.html";
		}			
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


<body onLoad="no_record_check();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
<form name='view_enctr_bill_det' id='view_enctr_bill_det' method='post' >
<%
		try
		{	
			if(!p_encntr_from_date.equals(""))
			{
				p_encntr_from_date = p_encntr_from_date+" 00:00:00";
			}
			else
			{	
				p_encntr_from_date = "01/01/1800 00:00:00";
			}

			if(!p_encntr_to_date.equals(""))
			{
				p_encntr_to_date = p_encntr_to_date+" 23:59:59";
			}
			else
			{
				p_encntr_to_date = system_date;
			}
			String sqlPatEncDet="Select EPISODE_TYPE, EPISODE_ID||'/'||VISIT_ID ENCOUNTER_ID, to_char(ADM_VISIT_DATE,'DD/MM/YYYY HH24:MI:SS') ADM_VISIT_DATE1, to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') DISCHR_DATE_TIME, ADM_VISIT_STATUS, CUR_ROOM_NUM, CUR_BED_NUM,LOCN_DESC,EPISODE_ID,VISIT_ID,PHYSICIAN_ID, LOCN_CODE from BL_ENCOUNTER_FOR_QRY_VW where NVL(LANGUAGE_ID,'"+locale+"') ='"+locale+"'   and FACILITY_ID = '"+strFacilityId+"' and PATIENT_ID  =  '"+strPatientId+"' and  ADM_VISIT_DATE between to_date('"+p_encntr_from_date+"','dd/mm/yyyy HH24:MI:SS') and to_date('"+p_encntr_to_date+"','dd/mm/yyyy HH24:MI:SS')";
			
			if(!p_episode_type.equals(""))
			{
				sqlPatEncDet=sqlPatEncDet+ " and EPISODE_TYPE='"+p_episode_type+"' ";
			}
			if(!p_episode_id.equals(""))
			{
				sqlPatEncDet=sqlPatEncDet+ " and EPISODE_ID='"+p_episode_id+"' ";
			}
			if(!p_visit_id.equals(""))
			{
				sqlPatEncDet=sqlPatEncDet+ " and VISIT_ID='"+p_visit_id+"' ";
			}

			if(!p_ward_clinic_code.equals(""))
			{
				sqlPatEncDet=sqlPatEncDet+ " and LOCN_CODE='"+p_ward_clinic_code+"' ";
			}

			if(p_episode_type.equals("R"))
			{
				sqlPatEncDet=sqlPatEncDet+ " UNION select 'R' EPISODE_TYPE, PATIENT_ID ENCOUNTER_ID, NULL ADM_VISIT_DATE, NULL DISCHR_DATE_TIME, NULL ADM_VISIT_STATUS, NULL CUR_ROOM_NUM, NULL CUR_BED_NUM, NULL LOCN_DESC, NULL EPISODE_ID, NULL VISIT_ID, NULL PHYSICIAN_ID, NULL LOCN_CODE from bl_patient_fin_dtls where patient_id='"+strPatientId+"'";
			}
			else
			{
				sqlPatEncDet=sqlPatEncDet+ " order by ADM_VISIT_DATE desc";
			}

//			sqlPatEncDet=sqlPatEncDet+ " order by to_date(ADM_VISIT_DATE,'dd/mm/yyyy HH24:MI:SS') desc";

//			System.out.println("sqlPatEncDet 1: "+sqlPatEncDet);
			HashMap sqlMap = new HashMap();
			sqlMap.put("sqlData",sqlPatEncDet);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("EPISODE_TYPE");
			displayFields.add("ENCOUNTER_ID");
			displayFields.add("ADM_VISIT_DATE1");
			displayFields.add("DISCHR_DATE_TIME");
			displayFields.add("ADM_VISIT_STATUS");
			displayFields.add("CUR_ROOM_NUM");
			displayFields.add("CUR_BED_NUM");
			displayFields.add("LOCN_DESC");
			displayFields.add("EPISODE_ID");
			displayFields.add("VISIT_ID");
			displayFields.add("PHYSICIAN_ID");
			displayFields.add("LOCN_CODE");
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
				<td class='COLUMNHEADER' colspan='10'><div align='left'><%=strTitle%>--<%=patln%></div> </td>
			</tr>
			<tr>		
				<td width="80%" class='label'>&nbsp;</td>			
				
<%			
				out.println(result.get(1));
%>
				</td>
			</tr>
		</table>
		</div>
		<div id="tbl-container" STYLE="overflow: auto; width: 100%; height: 480px;   padding:3px; margin: 0px">
		<table border='' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
		<thead>
			<tr>			
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
<%
			if(p_episode_type.equals("R"))
			{
%>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<%
			}
			else
			{
%>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
<%
			}
%>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.PRIMARY_PRIVILEGE.label"bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.PRIMARY_PAYER.label"bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.room.label" bundle="${common_labels}"/></td>			
				<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></td>			
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
				
				strEpisodeType = (String)records.get(0);
				if(strEpisodeType==null) strEpisodeType="";
				
				if(strEpisodeType.equals("R"))
				{
					strPatientId = (String)records.get(1);
					if(strPatientId==null) strPatientId="";
				}
				else
				{
					strEncounterId = (String)records.get(1);
					if(strEncounterId==null) strEncounterId="";
				}
				
				strAdmVstDate = (String)records.get(2);
				if(strAdmVstDate==null) strAdmVstDate="";
				
				strDischargeDate = (String)records.get(3);
				if(strDischargeDate==null) strDischargeDate="";
				
				strAdmVstStatus = (String)records.get(4);
				if(strAdmVstStatus==null) strAdmVstStatus="";
				
				strCurrRoomNo = (String)records.get(5);
				if(strCurrRoomNo==null) strCurrRoomNo="";
				
				strCurrBedNo = (String)records.get(6);
				if(strCurrBedNo==null) strCurrBedNo="";
				
				strLocationDesc = (String)records.get(7);
				if(strLocationDesc==null) strLocationDesc="";
				
				strEpisodeId = (String)records.get(8);
				if(strEpisodeId==null) strEpisodeId="";
				
				strVisitId = (String)records.get(9);
				if(strVisitId==null) strVisitId="";
				
				strPractId = (String)records.get(10);
				if(strPractId==null) strPractId="";

				strLocnCode = (String) records.get(11);
				if(strLocnCode==null) strLocnCode="";
				
				if(strEpisodeType.equals("I"))
				{																
					epsode_type_leb=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				}
				else if(strEpisodeType.equals("D"))
				{
					epsode_type_leb=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
				}
				else if(strEpisodeType.equals("O"))
				{
					epsode_type_leb=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				}
				 else if(strEpisodeType.equals("R"))
				{
					 epsode_type_leb=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
				}
				 else if(strEpisodeType.equals("E"))
				{
					 epsode_type_leb=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				}

				if(!strEpisodeId.equals(""))
				{
					String sqlEncounterId="select encounter_id from pr_encounter where episode_id='"+strEpisodeId+"' and facility_id='"+strFacilityId+"'";

					if(!strVisitId.equals("") && !strVisitId.equals("0"))
					{
						sqlEncounterId=sqlEncounterId+" and OP_EPISODE_VISIT_NUM='"+strVisitId+"'";
					}
					pstmt = con.prepareStatement(sqlEncounterId);
					rs1 = pstmt.executeQuery();	
					while(rs1.next())
					{
						strEncounterId= rs1.getString(1);
						if(strEncounterId==null) strEncounterId="";
					}
					if (rs1 != null)   rs1.close();
					if (pstmt != null) pstmt.close();
				}
				
				if(strEpisodeType.equals("R"))
				{						 
					String sqlPriviledge="Select LONG_DESC Priviledge, SHORT_NAME Payer_name From bl_patient_fin_dtls a, bl_blng_grp_lang_vw b, ar_customer_lang_vw c Where patient_id = '"+strPatientId+"' And a.blng_grp_id = b.blng_grp_id and b.language_id = '"+locale+"' and a.cust_code = c.cust_code and c.language_id = '"+locale+"' ";
				
					pstmt = con.prepareStatement(sqlPriviledge);
				    rs1 = pstmt.executeQuery();	
					while(rs1.next())
					{
						strPriviledge = rs1.getString(1);
						if(strPriviledge==null) strPriviledge="";
						 strPayerName = rs1.getString(2);
						 if(strPayerName==null) strPayerName="";
						}
						if (rs1 != null)   rs1.close();
						if (pstmt != null) pstmt.close();	
				}
				else if(strEpisodeType.equals("I")||strEpisodeType.equals("D"))
				{
					String sqlPriviledge1=" Select LONG_DESC Priviledge, SHORT_NAME Payer_name From bl_episode_fin_dtls a, bl_blng_grp_lang_vw b, ar_customer_lang_vw c Where patient_id = '"+strPatientId+"' And a.episode_type = '"+strEpisodeType+"' And a.episode_id ='"+strEpisodeId+"' And a.blng_grp_id = b.blng_grp_id and b.language_id = '"+locale+"'  and a.cust_code = c.cust_code and c.language_id = '"+locale+"' ";
					pstmt = con.prepareStatement(sqlPriviledge1);
					rs2 = pstmt.executeQuery();	
					while(rs2.next())
					{
						strPriviledge = rs2.getString(1);
						if(strPriviledge==null) strPriviledge="";
						strPayerName = rs2.getString(2);
						if(strPayerName==null) strPayerName="";
					}
					if (rs2 != null)   rs2.close();
					if (pstmt != null) pstmt.close();	
				}
				else if(strEpisodeType.equals("O")||strEpisodeType.equals("E"))
				{
					String sqlPriviledge2="Select LONG_DESC Priviledge, SHORT_NAME Payer_name From bl_visit_fin_dtls a, bl_blng_grp_lang_vw b, ar_customer_lang_vw c Where patient_id = '"+strPatientId+"' And a.episode_type ='"+strEpisodeType+"' And a.episode_id='"+strEpisodeId+"'  And a.visit_id = '"+strVisitId+"' And a.blng_grp_id = b.blng_grp_id and b.language_id = '"+locale+"' and a.cust_code = c.cust_code and c.language_id = '"+locale+"' ";

					pstmt = con.prepareStatement(sqlPriviledge2);
					rs3 = pstmt.executeQuery();	
					while(rs3.next())
					{
						strPriviledge = rs3.getString(1);
						if(strPriviledge==null) strPriviledge="";
						strPayerName = rs3.getString(2);
						if(strPayerName==null) strPayerName="";
					}
					if (rs3 != null)   rs3.close();
					if (pstmt != null) pstmt.close();	
				}

				strAdmVstDate = com.ehis.util.DateUtils.convertDate(strAdmVstDate,"DMYHMS","en",locale);
				strDischargeDate = com.ehis.util.DateUtils.convertDate(strDischargeDate,"DMYHMS","en",locale);
%>
		<tbody>
			<tr id=row<%=i%>>			
				<td class=<%=classval%> width='10%'><%=epsode_type_leb%></td>	
<%
				if(function_id.equals("EBL_QRY_PAT_ENCNTR"))
				{
%>
				<td class=<%=classval%> width='10%'><a name='doc_num<%=i%>' href="#" onClick="javascript:funViewEncounterDet('<%=strPatientId%>','<%=strEpisodeType%>','<%=strEpisodeId%>','<%=strVisitId%>','<%=strEncounterId%>','<%=strLocnCode%>')"><%=strEncounterId%></a></td>	 
<%
				}
			//	if(function_id.equals("EBL_ENTER_SERV_REQ"))
			if(function_id.equals("Serivice_Request"))
				{
%>
				
				<td class=<%=classval%> width='10%'><a name='doc_num<%=i%>' href="#" onClick="javascript:funEnterServiceRequest('<%=strPatientId%>','<%=strEpisodeType%>','<%=strEpisodeId%>','<%=strVisitId%>','<%=strEncounterId%>','<%=strPractId%>','<%=strLocnCode%>')"><%=strEncounterId%></a></td>	 
<%
				}

				if(function_id.equals("EBL_ENTER_RECEIPT_REFUND"))
				{
%>
				<td class=<%=classval%> width='10%'><a name='doc_num<%=i%>' href="#" onClick="javascript:funEnterReceiptRefund('<%=strPatientId%>','<%=strEpisodeType%>','<%=strEpisodeId%>','<%=strVisitId%>','<%=strEncounterId%>','<%=strPractId%>','<%=strLocnCode%>')"><%=strEncounterId%></a></td>	 
<%
				}

				if(function_id.equals("EBL_TEMP_DISC_FUN"))
				{
%>
				<td class=<%=classval%> width='10%'><a name='doc_num<%=i%>' href="#" onClick="javascript:funAdhocDisc('<%=strPatientId%>','<%=strEpisodeType%>','<%=strEpisodeId%>','<%=strVisitId%>','<%=strEncounterId%>','<%=strPractId%>','<%=strLocnCode%>')"><%=strEncounterId%></a></td>	 
<%
				}

				if(function_id.equals("SURGERY_ADDL_CHARGE_DTLS"))
				{
%>
				<td class=<%=classval%> width='10%'><a name='doc_num<%=i%>' href="#" onClick="javascript:funSurgeryAddlCharges('<%=strPatientId%>','<%=strEpisodeType%>','<%=strEpisodeId%>','<%=strVisitId%>','<%=strEncounterId%>','<%=strPractId%>','<%=strLocnCode%>')"><%=strEncounterId%></a></td>	 
<%
				}
				if(function_id.equals("EBL_VW_EDIT_OP_ORDERS"))
				{
%>
				<td class=<%=classval%> width='10%'><a name='doc_num<%=i%>' href="#" onClick="javascript:funVwEditVisitRegOrders('<%=strPatientId%>','<%=strEpisodeType%>','<%=strEpisodeId%>','<%=strVisitId%>','<%=strEncounterId%>','<%=strPractId%>','<%=strLocnCode%>')"><%=strEncounterId%></a></td>	 
<%
				}
				if(function_id.equals("EBL_OP_OVERRIDE_REIM_DTLS") || function_id.equals("EBL_IP_OVERRIDE_REIM_DTLS") ||  function_id.equals("EBL_OP_OVERIDE_UNBLD_REIM_DTLS") || function_id.equals("EBL_IP_OVERIDE_UNBLD_REIM_DTLS"))
				{
					if(strEpisodeType.equals("R"))
					{
%>
					<td class=<%=classval%> width='10%'><a name='doc_num<%=i%>' href="#"	 onClick="javascript:funVwEditBillReimburseAmt('<%=strPatientId%>','<%=strEpisodeType%>','<%=strEpisodeId%>','<%=strVisitId%>','<%=strEncounterId%>','<%=strPractId%>','<%=strLocnCode%>')"><%=strPatientId%></a></td> 
<%
					}
					else
					{
%>
					<td class=<%=classval%> width='10%'><a name='doc_num<%=i%>' href="#" onClick="javascript:funVwEditBillReimburseAmt('<%=strPatientId%>','<%=strEpisodeType%>','<%=strEpisodeId%>','<%=strVisitId%>','<%=strEncounterId%>','<%=strPractId%>','<%=strLocnCode%>')"><%=strEncounterId%></a></td> 
<%
					}
				}
%>
				<td class=<%=classval%> width="15%" ><%=(strAdmVstDate==null || strAdmVstDate.equals(""))?"&nbsp;":strAdmVstDate%></td>
				<td class=<%=classval%> width='15%'><%=(strDischargeDate==null || strDischargeDate.equals(""))?"&nbsp;":strDischargeDate%></td>	
				<td class=<%=classval%> width="12%"><%=(strPriviledge==null || strPriviledge.equals(""))?"&nbsp;":strPriviledge%></td>
				<td class=<%=classval%> width="12%"><%=(strPayerName==null || strPayerName.equals(""))?"&nbsp;":strPayerName%></td>		
				<td class=<%=classval%> width="10%"><%=(strLocationDesc==null || strLocationDesc.equals(""))?"&nbsp;":strLocationDesc%></td>					
				<td class=<%=classval%> width="6%"><%=(strAdmVstStatus==null || strAdmVstStatus.equals(""))?"&nbsp;":strAdmVstStatus%></td> 			
				<td class=<%=classval%> width="5%"><%=(strCurrRoomNo==null || strCurrRoomNo.equals(""))?"&nbsp;":strCurrRoomNo%></td>	
				<td class=<%=classval%> width="5%"><%=(strCurrBedNo==null || strCurrBedNo.equals(""))?"&nbsp;":strCurrBedNo%></td>
				<input type='hidden' name='pract_id' id='pract_id' value="<%=strPractId%>">
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
				<script></script>
<%
			 }
		}
		catch(Exception ee)
		{
			System.out.println("Exception in pat Enctr qry" +ee);
			ee.printStackTrace();
		}

	}
	catch(Exception eee)
	{
		System.out.println("Exception main"+ eee);
		eee.printStackTrace();
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>	
	<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>	
	<input type='hidden' name='params' id='params' value='<%=params%>'>	
	
</form>
	<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLViewPatEncounterDtls.jsp",searched));%>
</body>
</HTML>

