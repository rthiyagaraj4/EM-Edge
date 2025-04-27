<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
25/04/2016	IN067051     Devindra							                Enhance TPN Ordering Functionality
--------------------------------------------------------------------------------------------------------------------
*/
%> 

<%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
  request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
  String locale = (String) session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/OncologyRegimen.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNRegimen.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNStdRegimen.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		


</HEAD> 

<% 
    String facility_id		= (String) session.getValue("facility_id");
	String iv_prep_yn       =request.getParameter("iv_prep_yn");
	if(iv_prep_yn == null || iv_prep_yn.equals("undefined")){iv_prep_yn="";}
	iv_prep_yn=iv_prep_yn.trim();
	String visible1="visible";
	String visible2="visible";
	String visible3="visible";
	if(iv_prep_yn.equals("7")){visible1="hidden";visible2="visible";visible3="hidden";}
	if(iv_prep_yn.equals("8")){visible1="hidden";visible2="hidden";visible3="visible";}
	String patient_id			= request.getParameter("patient_id");
	String weight				= request.getParameter("weight");
	String height				= request.getParameter("height");
	String encounter_id			= request.getParameter("encounter_id");
	String patient_class		= request.getParameter("patient_class");
	String bean_id				= "@TPNRegimenBean"+patient_id+encounter_id;
	String bean_name			= "ePH.TPNRegimenBean";
    String mode					= request.getParameter("mode"); 
	String bed_num				= request.getParameter("bed_num")==null?"":request.getParameter("bed_num"); //added for ML-MMOH-CRF-1089
	String tpn_screening_type	= "";
	String note_type			= "";
	String accession_num		="";
	String test_observ_dt_tm	="";
	String date_of_birth		="";
	String sex					="";
	if(mode==null){
		mode="";
	}
	TPNRegimenBean bean		= (TPNRegimenBean)getBeanObject(bean_id,bean_name,request) ;

	 HashMap record1=new HashMap(); 
     record1=bean.ChkAdMixture();
	 tpn_screening_type=CommonBean.checkForNull((String)record1.get("TPN_SCREENING_TYPE"));
	 note_type=CommonBean.checkForNull((String)record1.get("TPN_SCREENING_FORM_ID"));
	
	 boolean assesmentReqYn      = bean.isSiteSpecific("PH", "ASSESMENT_REQ_YN"); // Added for ML-MMOH-CRF-1126 - Start
	 
	 if(assesmentReqYn && !bean.chkAssesmentApplicableYn().equals("Y")){
		 visible1 = "hidden";
	 } // Added for ML-MMOH-CRF-1126 - End
	 
	if(!tpn_screening_type.equals("")){
		HashMap record3=new HashMap();
		record3=bean.ChkScreeningDetails(facility_id,encounter_id,note_type);
		accession_num=CommonBean.checkForNull((String)record3.get("ACCESSION_NUM"));
	}
	
	if(tpn_screening_type.equals("D")){
		HashMap patientage=new HashMap(); 
		patientage		= bean.ChkAPatientAge(patient_id);
		date_of_birth=CommonBean.checkForNull((String)patientage.get("DATE_OF_BIRTH"));
		sex=CommonBean.checkForNull((String)patientage.get("SEX"));
	}

	//String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	//String or_bean_name		= "eOR.OrderEntryBean";
	//OrderEntryBean ORbean	= (OrderEntryBean)mh.getBeanObject( or_bean_id, request, or_bean_name ) ;
  /*  ArrayList active_orders	= bean.getPatientActiveOrders(patient_id, patient_class, "");
	
	// String drug_description	= "";
	StringBuffer drug_description	=	new StringBuffer();
	int size				= active_orders.size();

	HashMap	record	= new HashMap();
	
	for (int i=0; i<size; i++) 
	{
		record					=	(HashMap)active_orders.get(i);
		drug_description.append((String)record.get("drug_desc"));
		drug_description.append(" , ");
	}*/	

/*  old code 
		if ((active_orders.get(i)) instanceof java.util.HashMap)
			record				= (HashMap)active_orders.get(i);

			drug_description	= (String)record.get("drug_desc");

		if(drug_description==null)
			drug_description	= "";
*/
     
	

%>

<!-- <BODY> -->
<body onMouseDown="" onKeyDown="lockKey()">
<FORM name="formTPNRegimenOptions" id="formTPNRegimenOptions">
<!-- Below table for CurrentRx details-->
<table border="0" width="100%" cellspacing="0" cellpadding="0">
<tr>
		<td align="left" width="15%">
		<input type="button" class="button" value='<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/>' onClick="javascript:callActiveOrdersforTPN('<%=patient_id%>','<%=encounter_id%>','<%=note_type%>');"></td>
		<td class="CURRTEXT" align="left" width="85%">&nbsp;
		<!-- <marquee scrollamount="3" title='<fmt:message key="ePH.ClickCurrentRxbuttontoViewCurrentMedication.label" bundle="${ph_labels}"/>'><font  style="font-weight:bold;color:black" size=1></font></marquee> -->
		</td>
		<%if(!tpn_screening_type.equals("")){%>
<td class="label" align="left" width="5%"><input type='button' class='button' 	onClick="ScreeningDetails('<%=patient_id%>','<%=encounter_id%>','<%=patient_class%>','<%=accession_num%>','<%=note_type%>','<%=date_of_birth%>','<%=sex%>','<%=tpn_screening_type%>')" 
		value='<fmt:message key="ePH.ScreeningDetails.label" bundle="${ph_labels}"/>'></td> 
		 <%}%>
 		<td class="label" align="center" width="15%"><input type='button' class='button' 						onClick="showDrugProfileforTPN('<%=patient_id%>','Prescription')" 
		value='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'></td> 
</tr>
</table>

<TABLE id="tab" name="tab" id="tab"  CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">

	<TR>
	<% 

	if(visible1.equals("visible")){ %>
	<td width='10%' id="assessment" class="CASECONDSELECTHORZ" onMouseOver="callOnMouseOver(this);"
	onMouseOut="callOnMouseOut(this,'tpnregimenassesment');" onClick="changeButtonColor(this,'PH_BUTTONS','tpnregimenassesment');" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white;cursor:pointer;" ><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></a></td>
		<%}
	if(visible2.equals("visible")){ %>
	<td width='10%' id="stdregimen" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this,'stdregimen');" onClick="changeButtonColor(this,'PH_BUTTONS','stdregimen');" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white;cursor:pointer;" ><fmt:message key="ePH.StandardRegimen.label" bundle="${ph_labels}"/></a></td>
	<%} if(visible3.equals("visible")){ %>
	<td width='10%' id="nonstdregimen" class="CAFIRSTSELECTHORZ"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this,'nonstdregimen');" onClick="changeButtonColor(this,'PH_BUTTONS','nonstdregimen');" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white;cursor:pointer;" ><fmt:message key="ePH.NonStandardRegimen.label" bundle="${ph_labels}"/></a></td>
	<%}%>
	<td class="white" width='80%' id="dummy"></td>
	</TR>
	</TABLE>

<input type="hidden" name="accession_num" id="accession_num" value="<%=accession_num%>">
<input type="hidden" name="test_observ_dt_tm" id="test_observ_dt_tm" value="<%=test_observ_dt_tm%>">
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name="patient_height" id="patient_height" value="<%=height%>">
<input type="hidden" name="patient_weight" id="patient_weight" value="<%=weight%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="QueryString" id="QueryString" value="<%=request.getQueryString()%>">
<input type="hidden" name="bed_num" id="bed_num" value="<%=bed_num%>"><!-- added for ML-MMOH-CRF-1089 -->
<!-- <input type="text" name ="temp" value = '<%//=drug_description%>'> -->
<%
if(iv_prep_yn.equals("7")) {%>
<SCRIPT>changeButtonColor(document.getElementById("stdregimen"),'PH_BUTTONS','stdregimen');</SCRIPT>
<%}else if(iv_prep_yn.equals("8")) { %>
	<SCRIPT>changeButtonColor(document.getElementById("nonstdregimen"),'PH_BUTTONS','nonstdregimen');</SCRIPT>
<%}%>
</FORM>
</BODY>
<% putObjectInBean(bean_id,bean,request); %>

<%if(!bean.chkAssesmentApplicableYn().equals("Y") && assesmentReqYn){ // Added for ML-MMOH-CRF-1126 - Start %>
<script type="text/javascript"> 
      document.getElementById("stdregimen").click();
<!-- Added for ML-MMOH-CRF-1126 - End --> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%} // Added for ML-MMOH-CRF-1126 - End %>

</HTML>

