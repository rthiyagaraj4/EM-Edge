<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.CallableStatement,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,java.util.ArrayList,java.util.HashMap,eOT.*,eOT.Common.*,java.sql.Types" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
</head>

 <link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link> 
 <script language="JavaScript" src="../../eCommon/js/common.js"></script> 
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>

<script language="javascript">

function changeTab(objStr){
	selectTab(objStr);
	var old_objStr = "";
	if(objStr=="OperationsProcedures")
		old_objStr = "Operation/Procedures";
	else if(objStr=="Assessment")
		old_objStr = "Assessment";
	var frmObj=document.RecordAnesthesiaTabForm;

	var params=frmObj.params.value;
	params=params+"&tab_name3="+old_objStr;
	parent.pre_anesth_tab_details_frame.location.href="../../eOT/jsp/AT_PreAnaesTabFrames.jsp?"+params;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String locale = (String)session.getAttribute("LOCALE");
	java.util.Properties prop = null;
	prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String facility_id=(String) session.getAttribute("facility_id");
	String patient_id	  = request.getParameter( "patient_id" );
	String encounter_id	  = request.getParameter( "encounter_id" );
	String current_medication_button = "hidden"; // initially hide this button and if records found, then enable it.
	String drugs_found_YN = "N",modules = "",ph_module_yn = "N",sql = "";
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	CallableStatement cstmt= null ;
	try{
		connection = ConnectionManager.getConnection(request);
		cstmt=connection.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		modules=cstmt.getString(2);
		if(modules.indexOf("|PH")>=0)
			ph_module_yn = "Y";
		
		if(ph_module_yn.equals("Y")){
			sql = "SELECT A.DRUG_CODE, C.DRUG_DESC, A.STRENGTH, C.STRENGTH_UOM, C.FORM_CODE, A.DOSAGE, A.DOSAGE_UOM_CODE, A.FREQ_CODE, G.FREQ_DESC, TO_CHAR(A.START_DATE, 'DD/MM/YYYY HH24:MI') START_DATE, TO_CHAR(A.END_DATE, 'DD/MM/YYYY HH24:MI') END_DATE FROM PH_PATIENT_DRUG_PROFILE A, PH_DRUG_LANG_VW C, AM_FREQUENCY_LANG_VW G WHERE C.LANGUAGE_ID='"+locale+"' AND G.LANGUAGE_ID='"+locale+"' AND A.PATIENT_ID=? AND A.DRUG_CODE = C.DRUG_CODE AND A.FREQ_CODE=G.FREQ_CODE AND A.DRUG_CODE = C.DRUG_CODE AND (C.DRUG_CODE IN ( SELECT DRUG FROM OT_DRUGS_FOR_NOTIFICATION WHERE NVL(NOTIFY_PRE_ANESTHESIA_YN,'N') = 'Y' AND DEFN_TYPE='D') OR C.GENERIC_ID IN ( SELECT DRUG FROM OT_DRUGS_FOR_NOTIFICATION WHERE NOTIFY_PRE_ANESTHESIA_YN = 'Y' AND DEFN_TYPE='G')) AND TO_DATE(A.END_DATE,'DD/MM/YYYY HH24:MI') >= TO_DATE(SYSDATE,'DD/MM/YYYY HH24:MI') AND TO_DATE(SYSDATE,'DD/MM/YYYY HH24:MI') BETWEEN TO_DATE(A.START_DATE,'DD/MM/YYYY HH24:MI') AND TO_DATE(A.END_DATE,'DD/MM/YYYY HH24:MI') AND A.DISCONT_DATE_TIME IS NULL AND A.ON_HOLD_DATE_TIME IS NULL AND NVL(A.CANCEL_YN,'N')='N' AND NVL(A.STOP_YN,'N')='N' ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO ";

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			resultset = pstmt.executeQuery();
			while(resultset.next()){
				drugs_found_YN = "Y";
				current_medication_button = "button";
			}
		}
	}catch(Exception e){
		System.err.println("67:Err Msg in AT_PreAnaesthesiaTabs.jsp"+e.getMessage());
	} finally{
		try{
			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			if(cstmt!=null)cstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
%>

<form name="RecordAnesthesiaTabForm" id="RecordAnesthesiaTabForm">
<table id="tab_buttons" cellspacing=0 cellpadding=3  border="0" width="100%">
	<tr>
	<td class="button" width= "25%">
		<input type="<%=current_medication_button%>" class="button" value='<fmt:message key="eOT.CurrentMedicationAlert.Label"  bundle="${ot_labels}"/>' onclick="callCurrentRx();">	
	</td>
	</tr>
</table>

<table id="tab" cellspacing=0 cellpadding=3  border="0" width="100%">
<tr>	
	<ul id="tablist" class="tablist" >
	<li class=tablistitem title='<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>'>
	 <a class="tabClicked" onclick="changeTab('OperationsProcedures');" id="OperationsProcedures"> 
		<span class="tabSpanclicked" id="OperationsProceduresspan">
			<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/> 
		</span>
	</a>
	</li>

	<li class="tablistitem" title='<fmt:message key="Common.Assessment.label" bundle="${common_labels}"/>'>
	 <a class="tabA"  onclick="changeTab('Assessment');" id="Assessment"> 
		<span class="tabAspan" id="Assessmentspan">
			<fmt:message key="Common.Assessment.label"  bundle="${common_labels}"/> 
		</span>
	</a>
	</li>
</ul>
</tr>
</table>
	<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="patient_class" id="patient_class" value='<%=request.getParameter("patient_class")%>'>
	<input type="hidden" name="drugs_found_YN" id="drugs_found_YN" value="<%=drugs_found_YN%>">
	<input type="hidden" name="current_medication_button" id="current_medication_button" value="<%=current_medication_button%>">
</form>
</body>
</html>
	<!-- The below line is required to change the select state of Initial tab selected -->
	
	<script>changeTab('OperationsProcedures');</script>
	<script>
	prevTabObj='OperationsProcedures';
	</script>
<script>
if (document.RecordAnesthesiaTabForm.drugs_found_YN.value == "Y" )
	callCurrentRx();
</script>

