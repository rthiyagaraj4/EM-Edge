<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,ePH.*,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="ePH.MedicationPlanSheet.label" bundle="${ph_labels}" /></title>
<%	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<style type="text/css"> 
			TH {background:none;COLOR: black;background-color:white;}
			@media print {
			thead { display: table-header-group; }
			tfoot { display: table-footer-group; }}
			@media screen {
			thead { display: block; }
			tfoot { display: block; }}
			.wrapword{COLOR:black;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;word-wrap: break-word;word-break: keep-all;display: inline-block;}
		</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form action="" name="formMedicationPlannerPrint" id="formMedicationPlannerPrint" method="post" >
<%
	try {
		String  strarrKey[] = new String[4];
		MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); 
		DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( "DispMedicationBean", "ePH.DispMedicationBean",request);
		medplan_bean.setObject(dispBean);
		medplan_bean.setLanguageId(locale);
		
		String sysdate = dispBean.getTodaysDate();
		if(sysdate.equals(""))
			sysdate = com.ehis.util.DateUtils.getCurrentDate("DMY", locale);
		String facility_id = (String) session.getValue("facility_id");
		HashMap hshDrugMap = medplan_bean.getMedPlan_DrugDetails();
		Set <String> hshKeys = new HashSet<String>();
		hshKeys = hshDrugMap.keySet();
		HashMap hshtemp = new HashMap();
		int i=0;
		String plan_recorded="",chkdrug="";
		boolean boolmedplan=false,boolmedplanlocal=false;
		if(hshKeys!=null && hshKeys.size()>0){
			for(String key:hshKeys){
				hshtemp = (HashMap)hshDrugMap.get(key);
				plan_recorded = (String)hshtemp.get("plan_recorded");
				chkdrug = (String)hshtemp.get("chkdrug");
				if(plan_recorded.equals("Y") && chkdrug.equals("E"))
					boolmedplan=true;
			}
		}
%>
			
	<%	if(boolmedplan){ %>
			<br>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
				<thead>
					<tr>
						<th colspan="9" style="font-size:13"><%=medplan_bean.getStrSiteName()%></th>
					</tr>
					<tr>
						<th colspan="9" style="font-size:13"><%=medplan_bean.getStrFacility_DispLoc()%></td>
					</tr>
					<tr>
						<th colspan="9" style="font-size:13"> Medication Plan Sheet</td>
					</tr>
					<tr>
						<th colspan="3" style="text-align:left">Patient ID : <%=patient_id%></th>
						<th colspan="5" style="text-align:left">Patient Name : <%=dispBean.getPatient_name(patient_id,medplan_bean.getStrPrimaryLangID())%></th>
						<th style="text-align:left">Dispensing Date : <%=sysdate%></th>
					</tr>
					<tr>
						<th class="COLUMNHEADER" >No.</th>
						<th class="COLUMNHEADER" >Drug Name</th>
						<th class="COLUMNHEADER" >Qty Issue&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></th>
						<th class="COLUMNHEADER" >How To Take</th>
						<th class="COLUMNHEADER" >Morning</th>
						<th class="COLUMNHEADER" >Afternoon</th>
						<th class="COLUMNHEADER" >Evening</th>
						<th class="COLUMNHEADER" >Night</th>
						<th class="COLUMNHEADER" >Important Notes</th>
					</tr>
				</thead>
	<%				for(String key:hshKeys){
						hshtemp = (HashMap)hshDrugMap.get(key);
						strarrKey = key.split("_");
						plan_recorded = (String)hshtemp.get("plan_recorded");
						chkdrug = (String)hshtemp.get("chkdrug");
						if(plan_recorded.equals("Y") && chkdrug.equals("E")){
	%>
				<tr>
					<td width="1%" class="wrapword"><%=++i%></td>
					<td width="15%" class="wrapword"><%=(String)hshtemp.get("drug_name")%>&nbsp;</td>
					<td width="8%" class="wrapword" style='text-align:center;'><%=(String)hshtemp.get("qty_issue")%>&nbsp;</td>
					<td width="18%" class="wrapword"><%=(String)hshtemp.get("howtotake")%>&nbsp;</td>
					<td width="8%" class="wrapword" style='text-align:center;'><%=(String)hshtemp.get("morning")%>&nbsp;</td>
					<td width="8%" class="wrapword" style='text-align:center;'><%=(String)hshtemp.get("afternoon")%>&nbsp;</td>
					<td width="8%" class="wrapword" style='text-align:center;'><%=(String)hshtemp.get("evening")%>&nbsp;</td>
					<td width="8%" class="wrapword" style='text-align:center;'><%=(String)hshtemp.get("night")%>&nbsp;</td>
					<td width="26%" class="wrapword"><%=(String)hshtemp.get("impnote")%>&nbsp;</td>
				</tr>
	<%			}}		%>
				<tr>
					<td class="label" colspan="8" style="text-align:right"><fmt:message key="Common.total.label" bundle="${common_labels}" /> <fmt:message	key="Common.Price.label" bundle="${common_labels}" /> :&nbsp;</td>
					<td class="label"><%=medplan_bean.getStrTotal_gross_charge_amount()%>&nbsp;</td>
				</tr>
	<%			} %>
				</table>
	<%			hshDrugMap = medplan_bean.getMedPlan_Local_DrugDetails();
				hshKeys = hshDrugMap.keySet();i=0;
				if(hshKeys!=null && hshKeys.size()>0){
					for(String key:hshKeys){
						hshtemp = (HashMap)hshDrugMap.get(key);
						plan_recorded = (String)hshtemp.get("plan_recorded");
						chkdrug = (String)hshtemp.get("chkdrug");
						if(plan_recorded.equals("Y") && chkdrug.equals("E"))
							boolmedplanlocal = true;
					}
				}
				if(boolmedplanlocal){
	%>			<br>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
				<thead>
					<tr>
						<th colspan="9" style="font-size:13"><%=medplan_bean.getStrSiteNameLocal()%></th>
					</tr>
					<tr>
						<th colspan="9" style="font-size:13"><%=medplan_bean.getStrFacility_DispLocLocal()%></td>
					</tr>
					<tr>
						<th colspan="9" style="font-size:13">Pelan Medikasi</td>
					</tr>
					<tr>
						<th colspan="3" style="text-align:left">No.Pendaftaran : <%=patient_id%></th>
						<th colspan="5" style="text-align:left">Nama Pesakit : <%=dispBean.getPatient_name(patient_id,medplan_bean.getStrLocalLangID())%></th>
						<th style="text-align:left">Tarikh Pemberian : <%=sysdate%></th>
					</tr>
					<tr>
						<th class="COLUMNHEADER" >No.</th>
						<th class="COLUMNHEADER" >Nama Ubat Awda</th>
						<th class="COLUMNHEADER" >Kuantiti Dibekalkan&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></th>
						<th class="COLUMNHEADER" >Cara Penggunaan</th>
						<th class="COLUMNHEADER" >Pagi</th>
						<th class="COLUMNHEADER" >Tengah Hari</th>
						<th class="COLUMNHEADER" >Petang</th>
						<th class="COLUMNHEADER" >Malam</th>
						<th class="COLUMNHEADER" >Nota Penting</th>
					</tr>
				</thead>
	<%				for(String key:hshKeys){
						hshtemp = (HashMap)hshDrugMap.get(key);
						strarrKey = key.split("_");
						plan_recorded = (String)hshtemp.get("plan_recorded");
						chkdrug = (String)hshtemp.get("chkdrug");
						if(plan_recorded.equals("Y") && chkdrug.equals("E")){
	%>	
				<tr>
					<td width="1%" class="wrapword"><%=++i%></td>
					<td width="15%" class="wrapword"><%=(String)hshtemp.get("drug_name")%>&nbsp;</td>
					<td width="8%" class="wrapword" style='text-align:center;'><%=(String)hshtemp.get("qty_issuelocal")%>&nbsp;</td>
					<td width="18%" class="wrapword"><%=(String)hshtemp.get("howtotake")%>&nbsp;</td>
					<td width="8%" class="wrapword" style='text-align:center;'><%=(String)hshtemp.get("morninglocal")%>&nbsp;</td>
					<td width="8%" class="wrapword" style='text-align:center;'><%=(String)hshtemp.get("afternoonlocal")%>&nbsp;</td>
					<td width="8%" class="wrapword" style='text-align:center;'><%=(String)hshtemp.get("eveninglocal")%>&nbsp;</td>
					<td width="8%" class="wrapword" style='text-align:center;'><%=(String)hshtemp.get("nightlocal")%>&nbsp;</td>
					<td width="26%" class="wrapword"><%=(String)hshtemp.get("impnote")%>&nbsp;</td>
				</tr>	
	<%		}} %>
				<tr>
					<td class="label" colspan="8" style="text-align:right">Jumlah Harga Ubat :&nbsp;</td>
					<td class="label"><%=medplan_bean.getStrTotal_gross_charge_amount()%>&nbsp;</td>
				</tr>
				</table>
	<%		} %>	
		<br>	
		
<%} catch (Exception exception) {
		exception.printStackTrace();
	}
%>
</form>
</body>
<script>
	window.onload=function(){
		window.print();
		window.focus();
		//window.close();
		window.onfocus=function(){ window.close();}
	}
</script>
</html>

