<%@page import="eBL.BLReportIdMapper"%>
<%@page import="blPolicy.EncounterSpecificDefinitionBean"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
/*
Sr No        Version           TFS/Incident        SCF/CRF            		 			  Developer Name
--------------------------------------------------------------------------------------------------------
1		    V211026	    		25297		PMG2021-MMS-CRF-0004-TF-US001/01-Hyper link    Mohana Priya K
--------------------------------------------------------------------------------------------------------
*/
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	String siteId = "";
	String strQueryString= checkForNull(request.getParameter("queryString"));
	if(strQueryString.length()==0)	strQueryString= request.getQueryString();
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecAddTable.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function showServiceRcrd(obj){
	//alert(obj)
	var serv = "incExCriteria_"+obj;
	var val = document.getElementById(serv).value;
	/*if(!(val == 'S' || val=='C' || val=='G' || val=='L')){
		alert('Exclusions not available for selected Criteria');
		return false;
	}*/
	var patClass = document.getElementById("ptClass_"+obj).value;
	var blngCode = document.getElementById("bg_code_"+obj).value;
	var payerGroup = document.getElementById('payerGroup').value;
	var payer = document.getElementById('payer').value;
	var policy = document.getElementById('policy').value;
	var patientId = document.forms[0].patientId.value;
	var mode = document.getElementById('mode').value;
	var startDate = document.getElementById("effFrom_"+obj).value;
	var endDate = document.getElementById("effTo_"+obj).value;
	
	var visitId = document.getElementById('visitId').value;
	var acctSeq = document.getElementById('acctSeq').value;
	var priority = document.getElementById('priority').value;
	var episodeType = document.getElementById('episodeType').value;
	var episodeId = document.getElementById("episodeId").value;
	
	var encEpsd = document.getElementById("episode_"+obj).value;
	var gender = document.getElementById("gender_"+obj).value;
	var ageGroup = document.getElementById("hdn_age_group_"+obj).value;
	var clinicNursInd = document.getElementById("clinic_"+obj).value;
	var clinicNursCode = document.getElementById("clinic_code_"+obj).value;
	var spltyCode = document.getElementById("spec_code_"+obj).value;
	//alert(val);
	var dialogUrl       = "../../eBL/jsp/RcrdApprovalPolicyDetailsPreApprovalPopupFrame.jsp?title=Service Limit&rowNumber="+obj+"&criteria="+val+"&patClass="+patClass+"&blngCode="+blngCode+
						"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&mode="+mode+"&startDate="+startDate+"&endDate="+endDate+"&patientId="+patientId+
						'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
						"&encEpsd="+encEpsd+"&gender="+gender+"&ageGroup="+ageGroup+"&clinicNursInd="+clinicNursInd+"&clinicNursCode="+clinicNursCode+"&spltyCode="+spltyCode;
	//pArgumentArray[9] = title;

	//var dialogArguments = pArgumentArray ;
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "70" +" ; scroll=auto; ";

	var returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);	
}

function movePrevthis(start,end)
{
	var params =  document.forms[0].queryString.value;
	

//	var params =  document.forms[0].queryString.value;
 	
  
 var strt = start-20;
 var endd= end-20;
	
 
	document.location.href="../../eBL/jsp/RcrdApprovalPolicyDetailsInclExcl.jsp?from="+strt+"&to="+endd+"&"+params;
	
	}
	
function moveNextthis(start,end)
{
	var params =  document.forms[0].queryString.value;



	
	var strt = start +20;
	var endd= end+20;


	document.location.href="../../eBL/jsp/RcrdApprovalPolicyDetailsInclExcl.jsp?from="+strt+"&to="+endd+"&"+params;

	
}
function applyFilter(criteria,bgCode,bgDesc){
	var params =  document.forms[0].queryString.value;
	var frm = document.forms[0];
	var start = document.forms[0].from.value;
	var end = document.forms[0].to.value;
	//parent.frames[0].location.href="../../eBL/jsp/PolicyDetailsData.jsp?from="+start+"&to="+end+"&criteria_Filter="+criteria.value+
	document.location.href="../../eBL/jsp/RcrdApprovalPolicyDetailsInclExcl.jsp?criteria_Filter="+criteria.value+	
			"&episodeFilter="+frm.episodeFilter.value+"&ptClassFilter="+frm.ptClassFilter.value+
			"&ageGroupFilter="+frm.hdn_age_groupFilter.value+"&genderFilter="+frm.genderFilter.value+
			"&clinicIndFilter="+frm.clinicFilter.value+"&clinicFilter="+frm.clinic_codeFilter.value+
			"&specFilter="+frm.spec_codeFilter.value+"&effFromFilter="+frm.effFrom_filter.value+
			"&specDescFilter="+escape(frm.spec_descFilter.value)+"&clinicDescFilter="+escape(frm.clinic_descFilter.value)+
			"&ageGroupDescFilter="+escape(frm.age_groupFilter.value)+
			"&bgCodeFilter="+bgCode.value+"&bgDescFilter="+escape(bgDesc.value)+
			"&title=Include Exclude Details"+
			"&source=PolicyDetailsData"+
			"&startDate="+frm.startDate.value+
			"&endDate="+frm.endDate.value+
			"&mode=modify"+
			"&payergroupCode="+frm.payerGroup.value+
			"&payerCode="+frm.payer.value+
			"&policyCode="+frm.policy.value+
			"&patinetId="+frm.patientId.value+
			"&visitId="+frm.visitId.value+
			"&acctSeq="+frm.acctSeq.value+
			"&priority="+frm.priority.value+
			"&episodeType="+frm.episodeType.value+
			"&episodeId="+frm.episodeId.value;
}

function resetFilter(){
	var params =  document.forms[0].queryString.value;
	var frm = document.forms[0];
	document.location.href="../../eBL/jsp/RcrdApprovalPolicyDetailsInclExcl.jsp?"+
	"title=Include Exclude Details"+
	"&source=PolicyDetailsData"+
	"&startDate="+frm.startDate.value+
	"&endDate="+frm.endDate.value+
	"&mode=modify"+
	"&payergroupCode="+frm.payerGroup.value+
	"&payerCode="+frm.payer.value+
	"&policyCode="+frm.policy.value+
	"&patinetId="+frm.patientId.value+
	"&visitId="+frm.visitId.value+
	"&acctSeq="+frm.acctSeq.value+
	"&priority="+frm.priority.value+
	"&episodeType="+frm.episodeType.value+
	"&episodeId="+frm.episodeId.value;
}
//Added for MOHE-CRF-0114
async function showDiagCopayRcrd(obj){
	//alert("38")
	var serv = "incExCriteria_"+obj;
	var val = document.getElementById(serv).value;
	/*if(!(val == 'S' || val=='C' || val=='G' || val=='L')){
		alert('Exclusions not available for selected Criteria');
		return false;
	}*/
	var patClass = document.getElementById("ptClass_"+obj).value;
	var blngCode = document.getElementById("bg_code_"+obj).value;
	var payerGroup = document.getElementById('payerGroup').value;
	var payer = document.getElementById('payer').value;
	var policy = document.getElementById('policy').value;
	var patientId = document.forms[0].patientId.value;
	var mode = document.getElementById('mode').value;
	var startDate = document.getElementById("effFrom_"+obj).value;
	var endDate = document.getElementById("effTo_"+obj).value;
	
	var visitId = document.getElementById('visitId').value;
	var acctSeq = document.getElementById('acctSeq').value;
	var priority = document.getElementById('priority').value;
	var episodeType = document.getElementById('episodeType').value;
	var episodeId = document.getElementById("episodeId").value;
	
	var encEpsd = document.getElementById("episode_"+obj).value;
	var gender = document.getElementById("gender_"+obj).value;
	var ageGroup = document.getElementById("hdn_age_group_"+obj).value;
	var clinicNursInd = document.getElementById("clinic_"+obj).value;
	var clinicNursCode = document.getElementById("clinic_code_"+obj).value;
	var spltyCode = document.getElementById("spec_code_"+obj).value;
	//alert(val);
	var dialogUrl       = "../../eBL/jsp/RcrdPolicyDetailsDiagCopayPopupFrame.jsp?title=Diagnosis Type&rowNumber="+obj+"&criteria="+val+"&patClass="+patClass+"&blngCode="+blngCode+
						"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&mode="+mode+"&startDate="+startDate+"&endDate="+endDate+"&patientId="+patientId+
						'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
						"&encEpsd="+encEpsd+"&gender="+gender+"&ageGroup="+ageGroup+"&clinicNursInd="+clinicNursInd+"&clinicNursCode="+clinicNursCode+"&spltyCode="+spltyCode;
	//pArgumentArray[9] = title;

	//var dialogArguments = pArgumentArray ;
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "50" +" ; scroll=auto; ";

	var returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);	
}

</script>
<style>

	div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 160px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}		

		</style>
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
String prevTab = "inclExclCoverage";
String mode = checkForNull(request.getParameter("mode"));
List<EncounterSpecificDefinitionBean> policyList = null; 
String checked = "";
String disabled = "";
String exclDisabled = "";
//String facility_id = (String)session.getAttribute("facility_id");
String payerGroup = checkForNull(request.getParameter("payergroupCode"));
String payer = checkForNull(request.getParameter("payerCode"));
String policy = checkForNull(request.getParameter("policyCode"));
String patientId = checkForNull(request.getParameter("patinetId"));
String startDate = checkForNull(request.getParameter("startDate"));
String endDate = checkForNull(request.getParameter("endDate"));

String visitId = checkForNull(request.getParameter("visitId"));
String acctSeq = checkForNull(request.getParameter("acctSeq"));
String priority = checkForNull(request.getParameter("priority"));
String episodeType = checkForNull(request.getParameter("episodeType"));
String episodeId = checkForNull(request.getParameter("episodeId"));
String auth = checkForNull(request.getParameter("auth"));

String criteria_Filter = checkForNull(request.getParameter("criteria_Filter"));
String bgCodeFilter = checkForNull(request.getParameter("bgCodeFilter"));
String bgDescFilter = checkForNull(request.getParameter("bgDescFilter"));
bgDescFilter = java.net.URLDecoder.decode(bgDescFilter,"UTF-8");
String episodeFilter = checkForNull(request.getParameter("episodeFilter"));
String ptClassFilter = checkForNull(request.getParameter("ptClassFilter"));
String ageGroupFilter = checkForNull(request.getParameter("ageGroupFilter"));
String genderFilter = checkForNull(request.getParameter("genderFilter"));
String clinicIndFilter = checkForNull(request.getParameter("clinicIndFilter"));
String clinicFilter = checkForNull(request.getParameter("clinicFilter"));
String specFilter = checkForNull(request.getParameter("specFilter"));
String effFromFilter = checkForNull(request.getParameter("effFromFilter"));
String clinicDescFilter = checkForNull(request.getParameter("clinicDescFilter"));
clinicDescFilter = java.net.URLDecoder.decode(clinicDescFilter,"UTF-8");
String specDescFilter = checkForNull(request.getParameter("specDescFilter"));
specDescFilter = java.net.URLDecoder.decode(specDescFilter,"UTF-8");
String ageGroupDescFilter = checkForNull(request.getParameter("ageGroupDescFilter"));
ageGroupDescFilter = java.net.URLDecoder.decode(ageGroupDescFilter,"UTF-8");

Boolean isDiagBasedCopayAppl = false;//MOHE-CRF-0114

//Traverse
int start = 0 ;
int end = 0 ;

String from = checkForNull(request.getParameter("from"));
String to = checkForNull(request.getParameter("to"));

if ( from.length()== 0 )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to.length()==0)
  	end = 20;
else
	end = Integer.parseInt( to ) ;
//Traverse
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;

Boolean siteSpecRefPrice = false; //Added V181008-Aravindh/AAKH-CRF-0107

//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
Boolean SiteSpec_across_enc = false;
String Site_across_enc = "N";
//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
try{
	con = ConnectionManager.getConnection(request);
	siteId = BLReportIdMapper.getCustomerId();
	siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181008-Aravindh/AAKH-CRF-0107
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
	SiteSpec_across_enc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_PREAPP_ACR_ENT_YN");
	if (SiteSpec_across_enc) {
		Site_across_enc = "Y";
	} else {
		Site_across_enc = "N";
	}
	isDiagBasedCopayAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "DIAG_BASED_COPAY_DEFN");//MOHE-CRF-0114
	
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
		HashMap<String,List<EncounterSpecificDefinitionBean>> fmtDetailsMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
		EncounterSpecificDefinitionBean fmtDtlsBean = null;
		if(policyList == null || policyList.isEmpty())
		{
			System.err.println("RcrdApprovalPolicyDetailsInclExcl.jsp");
			//String sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_DTL");
			if(patientId == null || "".equals(patientId)){
				//String sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_DTL");//V211026
				String sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEFN_INCL_EXCL_DTL");//V211026
				
				if(!("".equals(criteria_Filter))){
					sqlCoverage += "and hdr.serv_excl_incl_crit = '"+criteria_Filter+"' ";
				}
				if(!("".equals(bgCodeFilter))){
					sqlCoverage += "and hdr.blng_serv_code = '"+bgCodeFilter+"' ";
				}
				if(!("".equals(episodeFilter))){
					sqlCoverage += "and hdr.episode_or_encounter_flag = '"+episodeFilter+"' ";
				}
				if(!("".equals(ptClassFilter))){
					sqlCoverage += "and hdr.patient_class = '"+ptClassFilter+"' ";
				}
				if(!("".equals(ageGroupFilter))){
					sqlCoverage += "and hdr.AGE_GROUP_CODE = '"+ageGroupFilter+"' ";
				}
				if(!("".equals(genderFilter))){
					sqlCoverage += "and hdr.SEX = '"+genderFilter+"' ";
				}
				if(!("".equals(clinicIndFilter))){
					sqlCoverage += "and hdr.clinic_nursing_ind = '"+clinicIndFilter+"' ";
				}
				if(!("".equals(clinicFilter))){
					sqlCoverage += "and hdr.clinic_nursing_code = '"+clinicFilter+"' ";
				}
				if(!("".equals(specFilter))){
					sqlCoverage += "and hdr.splty_code = '"+specFilter+"' ";
				}
				if(!("".equals(effFromFilter))){
					sqlCoverage += "and to_char(hdr.effective_from,'dd/mm/yyyy') = '"+effFromFilter+"' ";
				}
				sqlCoverage += 	" order by hdr.cust_code desc ";//V211026
				System.err.println("sqlCoverage in RcrdApprovalPolicyDetailsInclExcl.jsp:"+sqlCoverage);
				pstmt = con.prepareStatement(sqlCoverage);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,payerGroup);
				pstmt.setString(7,payer);
				pstmt.setString(8,policy);
				pstmt.setString(9,facility_id);
				pstmt.setString(10,payerGroup);
				pstmt.setString(11,payer);
				pstmt.setString(12,policy);
				rst = pstmt.executeQuery();
			}
			else{
				String partSql = "";
				String partExclSql = "";
				
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
					partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_ID");
				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
					partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_OE");
				}
				else if("R".equals(episodeType)){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
					partExclSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_EXCL_R");
				}
				
				
				String sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_FIRST_PART")+partExclSql+BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_SECOND_PART")+partSql;

				if(!("".equals(criteria_Filter))){
					sqlCoverage += "and hdr.serv_excl_incl_crit = '"+criteria_Filter+"' ";
				}
				if(!("".equals(bgCodeFilter))){
					sqlCoverage += "and hdr.blng_serv_code = '"+bgCodeFilter+"' ";
				}
				if(!("".equals(episodeFilter))){
					sqlCoverage += "and hdr.episode_or_encounter_flag = '"+episodeFilter+"' ";
				}
				if(!("".equals(ptClassFilter))){
					sqlCoverage += "and hdr.patient_class = '"+ptClassFilter+"' ";
				}
				if(!("".equals(ageGroupFilter))){
					sqlCoverage += "and hdr.AGE_GROUP_CODE = '"+ageGroupFilter+"' ";
				}
				if(!("".equals(genderFilter))){
					sqlCoverage += "and hdr.SEX = '"+genderFilter+"' ";
				}
				if(!("".equals(clinicIndFilter))){
					sqlCoverage += "and hdr.clinic_nursing_ind = '"+clinicIndFilter+"' ";
				}
				if(!("".equals(clinicFilter))){
					sqlCoverage += "and hdr.clinic_nursing_code = '"+clinicFilter+"' ";
				}
				if(!("".equals(specFilter))){
					sqlCoverage += "and hdr.splty_code = '"+specFilter+"' ";
				}
				if(!("".equals(effFromFilter))){
					sqlCoverage += "and to_char(hdr.effective_from,'dd/mm/yyyy') = '"+effFromFilter+"' ";
				}
				System.err.println("sqlCoverage in fin dtls view:"+sqlCoverage);
				pstmt = con.prepareStatement(sqlCoverage);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,payerGroup);
				pstmt.setString(7,payer);
				pstmt.setString(8,policy);
				pstmt.setString(9,patientId);
				
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					pstmt.setString(10,episodeType);
					pstmt.setString(11,episodeId);
					pstmt.setString(12,acctSeq);
					pstmt.setString(13,priority);
					
					pstmt.setString(14,facility_id);
					pstmt.setString(15,payerGroup);
					pstmt.setString(16,payer);
					pstmt.setString(17,policy);
					pstmt.setString(18,patientId);
					
					pstmt.setString(19,episodeType);
					pstmt.setString(20,episodeId);
					pstmt.setString(21,acctSeq);
					pstmt.setString(22,priority);

				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					pstmt.setString(10,episodeType);
					pstmt.setString(11,episodeId);
					pstmt.setString(12,visitId);
					pstmt.setString(13,acctSeq);
					pstmt.setString(14,priority);
					
					pstmt.setString(15,facility_id);
					pstmt.setString(16,payerGroup);
					pstmt.setString(17,payer);
					pstmt.setString(18,policy);
					pstmt.setString(19,patientId);
					
					pstmt.setString(20,episodeType);
					pstmt.setString(21,episodeId);
					pstmt.setString(22,visitId);
					pstmt.setString(23,acctSeq);
					pstmt.setString(24,priority);
				}
				else if("R".equals(episodeType)){
					
					pstmt.setString(10,episodeType);
					pstmt.setString(11,acctSeq);
					pstmt.setString(12,priority);
					
					pstmt.setString(13,facility_id);
					pstmt.setString(14,payerGroup);
					pstmt.setString(15,payer);
					pstmt.setString(16,policy);
					pstmt.setString(17,patientId);
					
					pstmt.setString(18,episodeType);
					pstmt.setString(19,acctSeq);
					pstmt.setString(20,priority);
				}
				

				rst = pstmt.executeQuery();
			}
			
			try{
			System.err.println("Step1:");	
			if(rst!=null){
				System.err.println("Step2:");	
				policyList = new ArrayList<EncounterSpecificDefinitionBean>();
				int rsCnt = 0;
				while (rst.next()) {
					System.err.println("Step3:");	
					fmtDtlsBean = new EncounterSpecificDefinitionBean();
					fmtDtlsBean.setPatClass(rst.getString("patient_class"));
					fmtDtlsBean.setAgeGroup(rst.getString("AGE_GROUP_CODE"));
					fmtDtlsBean.setAgeGroupDesc(rst.getString("age_group_desc"));
					fmtDtlsBean.setGender(rst.getString("SEX"));
					fmtDtlsBean.setEpisodeEncounter(rst.getString("episode_or_encounter_flag"));
					fmtDtlsBean.setClinicNurs(rst.getString("clinic_nursing_ind"));
					fmtDtlsBean.setClinicNursCode(rst.getString("clinic_nursing_code"));
					fmtDtlsBean.setClinicNursDesc(rst.getString("clinic_nursing_desc"));
					fmtDtlsBean.setSpecCode(rst.getString("splty_code"));
					fmtDtlsBean.setSpecDesc(rst.getString("spec_desc"));
					fmtDtlsBean.setInclExclCriteria(rst.getString("serv_excl_incl_crit"));
					fmtDtlsBean.setBillServCode(rst.getString("blng_serv_code"));
					fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
					fmtDtlsBean.setBillServChk(rst.getString("special_service_yn"));
					fmtDtlsBean.setInclExclInd(rst.getString("excl_incl_ind"));
					fmtDtlsBean.setInclExclIndChk(rst.getString("ovride_incl_excl_yn"));
					fmtDtlsBean.setInclusionBasis(rst.getString("copay_ind"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("per_day_amt_limit_gross_net"));
					if(Integer.parseInt(rst.getString("total"))>0){
						fmtDtlsBean.setServLimit("Y");
					}
					else{
						fmtDtlsBean.setServLimit("N");
					}
					fmtDtlsBean.setValue(rst.getString("copay_val"));
					fmtDtlsBean.setValueChk1(rst.getString("include_policy_level_copay_yn"));
					fmtDtlsBean.setValueChk2(rst.getString("pre_approval_yn"));
					fmtDtlsBean.setValueChk3(rst.getString("cumm_cvrg_with_oth_payers_yn"));
					fmtDtlsBean.setValueChk4(rst.getString("last_payer_coverage_yn"));
					fmtDtlsBean.setServItemQty(rst.getString("qty_capping"));
					fmtDtlsBean.setAmtPerVisit(rst.getString("amount_capping"));
					fmtDtlsBean.setAmtPerIPDay(rst.getString("per_day_amount_limit"));
					fmtDtlsBean.setNoOfDays(rst.getString("no_of_days_limit"));
					fmtDtlsBean.setStartDate(rst.getString("effective_from"));
					fmtDtlsBean.setEndDate(rst.getString("effective_to"));
					fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
					fmtDtlsBean.setPatLimitAmt(rst.getString("patient_amount_limit"));
					fmtDtlsBean.setStatus("U");
					if(siteSpecRefPrice) {
					fmtDtlsBean.setCoverRefPrice(rst.getString("cover_ref_price"));//Added V181008-Aravindh/AAKH-CRF-0107
					}
					fmtDtlsBean.setExlinclacrossenc(rst.getString("across_enc_exlincl_yn")); //Added V190326-Dhananjay/MMS-DM-CRF-0158
					System.err.println("Step4:");	
					try{
						System.err.println("Step5:"+checkForNull(rst.getString("DIAG_BASED_COPAY_DEFN")));
						fmtDtlsBean.setDiagCopaySetup(checkForNull(rst.getString("DIAG_BASED_COPAY_DEFN")));//Added for MOHE-CRF-0114
					}catch(Exception e){
						System.err.println("Exception e:"+e);
					}
					System.err.println("Step6:");	
					policyList.add(fmtDtlsBean);
					rsCnt++;
				}
				
				/*if(rsCnt<1){
					EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
					titleBean.setStartDate(checkForNull(startDate));
					titleBean.setEndDate(checkForNull(endDate));
					policyList = new ArrayList<EncounterSpecificDefinitionBean>();
					policyList.add(titleBean);
				}*/
			}
			else{
				/*EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
				titleBean.setStartDate(checkForNull(startDate));
				titleBean.setEndDate(checkForNull(endDate));
				policyList = new ArrayList<EncounterSpecificDefinitionBean>();
				policyList.add(titleBean);*/
			}		
			}catch(Exception e){
				System.err.println("Main Error = "+e);
			}
		}

		pstmt = null;
		rst = null;
		String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
		pstmt = con.prepareStatement(inclExclSql);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();
		
		if(rst!=null){
			while(rst.next()){
				criteriaMap.put(rst.getString("code"),rst.getString("description"));
			}	
		}

}
catch(Exception e){
	System.err.println("Exception "+e);
}
finally{
	ConnectionManager.returnConnection(con);
	pstmt = null;
	rst = null;
}
%>
	<form  id="frmPolicyInclExclCoverage">	
	<table width='90%' align="center">
	<tr>
		<td width='70%'>
		</td>
		<td width='14%' align='right'>
			<%
		if ( !(start <= 1) )
			out.println("<A HREF='javascript:movePrevthis("+start+","+end+")'   text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
			%>
		</td>
		<td width='2%'></td>
		<td width='14%' align='left'>
		<%
		if(policyList.size() > end)
			out.println("<A id='nextvalue' HREF='javascript:moveNextthis("+start+","+end+")'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		%>
		</td>
	</tr>
	</table>
		
		
      	<table class='grid' border='1' width='220%' cellpadding='3'  cellspacing=0 align="center" id='PolicyInclExcl'>  
      	<div id="tableContainer">
      	<thead>  
      		<tr>
      			<td class='COLUMNHEADER' nowrap colspan="18" align="center"></td>
      			<td class='COLUMNHEADER' nowrap colspan="12" align="center"><fmt:message key="eBL.CoverageDetails.label" bundle="${bl_labels}"/></td>
      		</tr>
      		<tr>
      			<td class='COLUMNHEADER' nowrap>S No</td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EpisodeEncounter.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.HCMasterAgeGroup.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>							
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ClinicNu.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ClinicNuDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.SpecDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.IncExcCriteria.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.BGServiceDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Special Service");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.IncExcInd.label" bundle="${bl_labels}"/></td>
				<% if(siteSpecRefPrice) { %>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.CoverRefPrice.label" bundle="${bl_labels}"/></td><!-- Added V181008-Aravindh/AAKH-CRF-0107 -->
				<% } %>
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Override Incl/Excl");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.InclusionBasis.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Include Policy Level Coverage");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<!-- <td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Pre Approval Required");' onMouseOut='hideToolTip();' class = 'img' ></td>  -->
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Coverage includes Other Payers");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' onMouseOver='showToolTip("Last Payer");' onMouseOut='hideToolTip();' class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ServItemQty.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.AmtVisit.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.AmtIPDay.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>Gross / Net</td>
				<% if(isDiagBasedCopayAppl){ //MOHE-CRF-0114%>				
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
				<% } %>	
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatCopay.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></td>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<% if ("Y".equals(Site_across_enc)) { %>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Preacrossenc.label" bundle="${bl_labels}" /></td>
				<% } %>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends -->
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>Delete Record</td>
			 </tr>
			 <tr>
			 	<td nowrap><input type='button' id='apply_filter' value='Search' onclick='applyFilter(criteriaFilter,bg_code_filter,bg_desc_filter)'>&nbsp;
			 	<input type='button' id='apply_filter' value='Reset' onclick='resetFilter()'></td>
			 	<td nowrap><select id='episodeFilter' name='episodeFilter' id='episodeFilter'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='E' <%=("E".equals(episodeFilter))?"selected":"" %>>Episode</option>
						<option value='N' <%=("N".equals(episodeFilter))?"selected":"" %>>Encounter</option>
						<option value='A' <%=("A".equals(episodeFilter))?"selected":"" %>>All</option>
					</select>
				</td>
				<td nowrap>
					<select id='ptClassFilter' name='ptClassFilter' id='ptClassFilter'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='OP' <%=("OP".equals(ptClassFilter))?"selected":"" %>>OP</option>
						<option value='IP' <%=("IP".equals(ptClassFilter))?"selected":"" %>>IP</option>
						<option value='DC' <%=("DC".equals(ptClassFilter))?"selected":"" %>>DC</option>
						<option value='XT' <%=("XT".equals(ptClassFilter))?"selected":"" %>>EX</option>
						<option value='EM' <%=("EM".equals(ptClassFilter))?"selected":"" %>>EM</option>
						<option value='**' <%=("**".equals(ptClassFilter))?"selected":"" %>>All</option>
					</select>
				</td>
				<td nowrap>
					<input type='text' name='age_groupFilter' id='age_groupFilter' id='age_groupFilter' length='15' value='<%=ageGroupDescFilter %>' onblur='if(this.value.length>0){ callCommonValidation(5,this,hdn_age_groupFilter); } else{ fnClearCode(hdn_age_groupFilter); }'>
					<input type='hidden' name='hdn_age_groupFilter' id='hdn_age_groupFilter' id='hdn_age_groupFilter' value='<%=ageGroupFilter%>'>
					<input type='button' id='age_but_Filter' value='?' onclick='callCommonValidation(5,age_groupFilter,hdn_age_groupFilter)'>					
				</td>
				<td nowrap>
					<select id='genderFilter' name='genderFilter' id='genderFilter'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='M' <%=("M".equals(genderFilter))?"selected":"" %>>Male</option>
						<option value='F' <%=("F".equals(genderFilter))?"selected":"" %>>Female</option>
						<option value='A' <%=("A".equals(genderFilter))?"selected":"" %>>Both</option>
					</select>
				</td>
				<td nowrap>
					<select id='clinicFilter' name='clinicFilter' id='clinicFilter' >
					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='C' <%=("C".equals(clinicIndFilter))?"selected":"" %>>Clinic</option>
						<option value='N' <%=("N".equals(clinicIndFilter))?"selected":"" %>>Nursing Unit</option>
						<option value='A' <%=("A".equals(clinicIndFilter))?"selected":"" %>>All</option>
					</select>
				</td>
				<td nowrap>
					<input type='text' id='clinic_codeFilter' name='clinic_codeFilter' id='clinic_codeFilter' value='<%=clinicFilter %>' size='4' onblur='if(this.value.length>0){ callBGDescCode(1,clinicFilter,clinic_descFilter,clinic_codeFilter); } else{ fnClearCode(clinic_descFilter); }'> 
					<input type='text' id='clinic_descFilter' name='clinic_descFilter' id='clinic_descFilter' value='<%=clinicDescFilter %>' size='20' onblur='if(this.value.length>0){ callBGDesc(1,clinicFilter,clinic_descFilter,clinic_codeFilter); } else{ fnClearCode(clinic_codeFilter); }'>
					<input type='button' id='clinic_butFilter' value='?' onclick='callBGDesc(1,clinicFilter,clinic_descFilter,clinic_codeFilter)'>
				</td> 
				<td nowrap>
					<input type='text' id='spec_codeFilter' name='spec_codeFilter' id='spec_codeFilter' size='5' value='<%=specFilter %>' onblur='if(this.value.length>0){ callCommonValidationSpecCode(spec_descFilter,spec_codeFilter,clinicFilter,clinic_codeFilter); } else{ fnClearCode(spec_descFilter); }'>
					<input type='text' id='spec_descFilter' name='spec_descFilter' id='spec_descFilter' size='20' value='<%=specDescFilter %>' onblur='if(this.value.length>0){ callCommonValidationSpec(spec_descFilter,spec_codeFilter,clinicFilter,clinic_codeFilter); } else{ fnClearCode(spec_codeFilter); }'>
					<input type='button' id='spec_butFilter' value='?' onclick='callCommonValidationSpec(spec_descFilter,spec_codeFilter,clinicFilter,clinic_codeFilter)'>					
				</td>
				<td nowrap>
					<select name='criteriaFilter' id='criteriaFilter'>		
					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>			
					<%
					for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
						String type = (String) iterator.next();
						if(type.equals(criteria_Filter)){
					%>	
						<option value='<%=type%>' selected="selected"><%=criteriaMap.get(type) %></option>
					<%}
						else{%>
							<option value='<%=type%>'><%=criteriaMap.get(type) %></option>
						<%}
					}
					%>
					</select>
				</td>
				<td nowrap>
					<input type='text' id='bg_code_filter' name='bg_code_filter' id='bg_code_filter' size='12'   value='<%=bgCodeFilter %>' onblur="if(this.value!=''){ if(criteriaFilter.value!=''){ callBGDescCode(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ alert('Please select Incl/Excl Criteria'); } } else{ fnClearCode(bg_desc_filter); } " >
					<input type='text' id='bg_desc_filter' name='bg_desc_filter' id='bg_desc_filter'  size='20'  value='<%=bgDescFilter %>' onblur="if(this.value!=''){ if(criteriaFilter.value!=''){ callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ alert('Please select Incl/Excl Criteria'); } } else{ fnClearCode(bg_code_filter); }">
					<input type='button' id='bg_but_filter' value='?'  onclick="if(criteriaFilter.value!=''){ callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ alert('Please select Incl/Excl Criteria'); }" >					
				</td>
				<!-- Added V181011-Aravindh/AAKH-CRF-0107/if-else condition  -->
				<%if(siteSpecRefPrice) { %>
				<td  nowrap colspan='17'>&nbsp;</td>
				<% } else {
				%>
				<td  nowrap colspan='16'>&nbsp;</td>
				<%
				}
				%>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<%if("Y".equals(Site_across_enc)) {%>
					<td  nowrap colspan='1'>&nbsp;</td>
				<%} %>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends -->
				<td nowrap>
					<input type='text' id='effFrom_filter' name='effFrom_filter' id='effFrom_filter' value='<%=effFromFilter %>' size='10' onblur='isValidDate(this);'>
					<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_filter' onClick='return showCalendar("effFrom_filter")' />
				</td>
			 </tr>
			  </thead>
			 <TBODY>
			<%
				int tableIndex = 1;
				 int tindex =0;
					for (EncounterSpecificDefinitionBean policyBean1 : policyList) {
						tindex++;	
						if(tindex < start)
						{					
							continue;
						}
						if(tindex > end)
							break;
			%>	
			 <tr>
			 	<td nowrap class='fields'>
			 		<%=tindex %>
			 	</td>
				<td nowrap class='fields'>
						<%if("E".equals(policyBean1.getEpisodeEncounter())){ %>
							<fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/>
						<%}

						else if("N".equals(policyBean1.getEpisodeEncounter())){ %>
							<fmt:message key="eBL.Encounter.label" bundle="${bl_labels}"/>
						<%}
						
						else if("A".equals(policyBean1.getEpisodeEncounter())){ %>
							<fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/>
						<%}%>
						<input type='hidden' name='episode_<%= tableIndex%>' id='episode_<%= tableIndex%>' value='<%=policyBean1.getEpisodeEncounter()%>'>
				</td>
				<td nowrap class='fields'>
						<%if("OP".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="Common.OP.label" bundle="${common_labels}"/>
						<%}
						else if("IP".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="Common.IP.label" bundle="${common_labels}"/>
						<%}
						else if("DC".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="Common.DC.label" bundle="${common_labels}"/>
						<%}
						else if("XT".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="eBL.EX.label" bundle="${bl_labels}"/>
						<%}
						else if("EM".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="eBL.EM.label" bundle="${bl_labels}"/>
						<%}
						else if("**".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/>
						<%} %>
					</select>
					<input type='hidden' name='ptClass_<%= tableIndex%>' id='ptClass_<%= tableIndex%>' value='<%=policyBean1.getPatClass()%>'>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getAgeGroupDesc()) %>
					<input type='hidden' name='hdn_age_group_<%= tableIndex%>' id='hdn_age_group_<%= tableIndex%>' value='<%=policyBean1.getAgeGroup()%>'>
				</td>
				<td nowrap class='fields'>
						<%if("M".equals(policyBean1.getGender())){ %>
							Male
						<%}
						else if("F".equals(policyBean1.getGender())){ %>
							Female
						<%}
						else if("A".equals(policyBean1.getGender())){ %>
							Both
						<%} %>
						<input type='hidden' name='gender_<%= tableIndex%>' id='gender_<%= tableIndex%>' value='<%=policyBean1.getGender()%>'>
				</td>

				<td nowrap class='fields'>
						<%if("C".equals(policyBean1.getClinicNurs())){ %>
							<fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
						<%}
						else if("N".equals(policyBean1.getClinicNurs())){ %>
							<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						<%}
						else if("A".equals(policyBean1.getClinicNurs())){ %>
							<fmt:message key="Common.all.label" bundle="${common_labels}"/>
						<%} %>
					</select>
					<input type='hidden' name='clinic_<%= tableIndex%>' id='clinic_<%= tableIndex%>' value='<%=policyBean1.getClinicNurs()%>'>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getClinicNursDesc())%>
					<input type='hidden' name='clinic_code_<%= tableIndex%>' id='clinic_code_<%= tableIndex%>' value='<%=policyBean1.getClinicNursCode()%>'>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getSpecDesc())%>
					<input type='hidden' name='spec_code_<%= tableIndex%>' id='spec_code_<%= tableIndex%>' value='<%=policyBean1.getSpecCode()%>'>
				</td>				
				<td nowrap class='fields'>
					<%=checkForNull(criteriaMap.get(policyBean1.getInclExclCriteria())) %>
					<input type='hidden' name='incExCriteria_<%= tableIndex%>' id='incExCriteria_<%= tableIndex%>' value='<%=policyBean1.getInclExclCriteria()%>'>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getBillServDesc())%>	
					<input type='hidden' name='bg_code_<%= tableIndex%>' id='bg_code_<%= tableIndex%>' value='<%=policyBean1.getBillServCode()%>'>		
				</td>
				<td nowrap class='fields'>	
					<%if("Y".equals(policyBean1.getBillServChk())){ 
						out.print("Y");
					} else{
						out.print("N");
					} %>
				</td>
				<td nowrap class='fields'>
						<%if("I".equals(policyBean1.getInclExclInd())){ %>
							<fmt:message key="Common.Include.label" bundle="${common_labels}"/>
						<%} else if("E".equals(policyBean1.getInclExclInd())){ %>
							<fmt:message key="Common.Exclude.label" bundle="${common_labels}"/>
						<%} %>
						
					</Select>
				</td>
				<!-- Added V181008-Aravindh/AAKH-CRF-0107/Starts -->
				<% if(siteSpecRefPrice) { %>
				<td class='fields' nowrap>
					<% if("Y".equals(policyBean1.getCoverRefPrice())) { 
						out.print("Y");
					 } else { 
						out.print("N");
					 } %>
				</td>
				<% } %>
				<!-- Added V181008-Aravindh/AAKH-CRF-0107/Ends -->
				<td nowrap class='fields'>
					<%if("Y".equals(policyBean1.getInclExclIndChk())){ 
						out.print("Y");
					} else{ 
						out.print("N");
					} %>
				</td>
				<td nowrap class='fields'>
						<%if("P".equals(policyBean1.getInclusionBasis())){ %>
							<fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"/>
						<%} else if("R".equals(policyBean1.getInclusionBasis())){ %>
							<fmt:message key="eBL.RATE.label" bundle="${bl_labels}"/>
						<%} else if("F".equals(policyBean1.getInclusionBasis()) && !"ALKA".equals(siteId)){ %>
							<fmt:message key="Common.Fixed.label" bundle="${common_labels}"/>
						<%} %>
						
					</Select>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getValue()) %>
				</td>
				<td nowrap class='fields'>
					<%if("Y".equals(policyBean1.getValueChk1())){ 
						out.print("Y");
					} else{ 
						out.print("N");
					} %>
				</td>

				<td nowrap class='fields'>		
					<%if("Y".equals(policyBean1.getValueChk3())){ 
						out.print("Y");
					} else{ 
						out.print("N");
					} %>
				</td>
				<td nowrap class='fields'>	
					<%if("Y".equals(policyBean1.getValueChk4())){ 
						out.print("Y");
					} else{ 
						out.print("N");
					} %>					
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getServItemQty())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getAmtPerVisit())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getAmtPerIPDay())%>
				</td>
				<td nowrap class='fields'>
						<% if(("G").equals(policyBean1.getAmtGrossNet())){ %>
							<fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%} else if(("N").equals(policyBean1.getAmtGrossNet())){ %>
							<fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%} %>					
					</select>
				</td>
				<% if(isDiagBasedCopayAppl){ //MOHE-CRF-0114%>
				<td class='fields' nowrap>
				<% try {
					System.err.println("Step7:");
					%>
					<%if("Y".equals(policyBean1.getDiagCopaySetup())){ %>					
					<input type="checkbox" id='chkDiagBasedCopayYN_<%= tableIndex%>' checked disabled name='chkDiagBasedCopayYN_<%= tableIndex%>' onclick="chkDiagBasedCopayYN(<%= tableIndex%>);">
						<a href='javascript:showDiagCopayRcrd(<%= tableIndex%>)' name="diagBasedCopayLink_<%= tableIndex%>" id='diagBasedCopayLink_<%= tableIndex%>' style='visibility: visible;'>Dtls</a>			
					
					<%}
					else{%>
						<input type="checkbox" id='chkDiagBasedCopayYN_<%= tableIndex%>'  disabled name='chkDiagBasedCopayYN_<%= tableIndex%>' onclick="chkDiagBasedCopayYN(<%= tableIndex%>);">
						<a href='javascript:showDiagCopayRcrd(<%= tableIndex%>)' name="diagBasedCopayLink_<%= tableIndex%>" id='diagBasedCopayLink_<%= tableIndex%>' style='visibility: hidden;'>Dtls</a>
					<%} %>
				</td>
					<%
					System.err.println("Step8:");
					}catch(Exception e){
						System.err.println("Exception e:"+e);
					}
					%>
				</td>				
				<% } %>				
				<td class='fields' nowrap>
					<%=checkForNull(policyBean1.getPatCopay())%>
				</td>
				<td class='fields' nowrap>
					<%=checkForNull(policyBean1.getPatLimitAmt())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getNoOfDays())%>
				</td>
				<td class='fields' nowrap>	
				<%if("Y".equals(policyBean1.getServLimit())){ %>					
					<input type="checkbox" id='serviceLmt_<%= tableIndex%>' checked disabled name='serviceLmt_<%= tableIndex%>' onclick="enableDisableLink(<%= tableIndex%>);">
						<a href='javascript:showServiceRcrd(<%= tableIndex%>)' name="serviceLink_<%= tableIndex%>" id='serviceLink_<%= tableIndex%>' style='visibility: visible;'>Dtls</a>			
					
				<%}
				else{%>
					<input type="checkbox" id='serviceLmt_<%= tableIndex%>'  disabled name='serviceLmt_<%= tableIndex%>' onclick="enableDisableLink(<%= tableIndex%>);">
					<a href='javascript:showServiceRcrd(<%= tableIndex%>)' name="serviceLink_<%= tableIndex%>" id='serviceLink_<%= tableIndex%>' style='visibility: hidden;'>Dtls</a>
				<%} %>
				</td>
				
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<% if("Y".equals(Site_across_enc)) { %>
				<td class='fields' nowrap>
					<% if("Y".equals(policyBean1.getExlinclacrossenc())) { 
						out.print("Y");
					 } else { 
						out.print("N");
					 } %>
				</td>
				<% } %>
				 
				 <!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends --> 
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getStartDate())%>		
					<input type='hidden' name='effFrom_<%= tableIndex%>' id='effFrom_<%= tableIndex%>' value='<%=policyBean1.getStartDate()%>'>	
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getEndDate())%>
					<input type='hidden' name='effTo_<%= tableIndex%>' id='effTo_<%= tableIndex%>' value='<%=policyBean1.getEndDate()%>'>
				</td>				
				

				<td nowrap class='fields'>
				<%if("Y".equals(policyBean1.getDelFlag())){
					out.print("Y");
				} else{ 
					out.print("&nbsp;");
				} %>
				</td>
			</tr>
			<%
			tableIndex++;
			} %>
      	</table>
      	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
      	<input type='hidden' name='inclRowCount' id='inclRowCount' value='<%=tableIndex -1 %>'>
      	<input type='hidden' name='mode' id='mode' value='<%= mode%>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
      	<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>'>
      	<input type='hidden' name='startDate' id='startDate' value='<%=startDate%>'>
      	<input type='hidden' name='endDate' id='endDate' value='<%=endDate%>'>
		<input type='hidden' name='pageInfo' id='pageInfo' value='inclExclCoverage'>
      	
      	<input type='hidden' name='visitId' id='visitId' value='<%=visitId%>'>
      	<input type='hidden' name='acctSeq' id='acctSeq' value='<%=acctSeq%>'>
      	<input type='hidden' name='priority' id='priority' value='<%=priority%>'>
      	<input type='hidden' name='episodeType' id='episodeType' value='<%=episodeType%>'>
      	<input type='hidden' name='episodeId' id='episodeId' value='<%=episodeId%>'>
      	<input type='hidden' name='auth' id='auth' value='<%=auth%>'>
      	<input type='hidden' name='queryString' id='queryString' value="<%=strQueryString%>">
      	<input type='hidden' name='from' id='from' value="<%=from%>">
		<input type='hidden' name='to' id='to' value="<%=to%>">
     </form>
     <div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
     </body>
</TBODY>	
	
	</div>
    <%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
    private String checkForStatus(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
     %>
	 <div class='COLUMNHEADER' name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:10%; visibility:hidden; background-color:blue;'>
	 	<table id='tooltiptable' cellpadding="0" cellspacing=0 border-collapse=collapse  style='position:absolute;' width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='menu_table'></td>
				</td>
			</tr>
		</table>
	</div>
</html>

