<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
16-apr-2014      100           	Karthikeyan.K       created  for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139
1            V220826            34883           MMS-ME-SCF-0104                      Namrata
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page
	import="eBL.*,eBL.Common.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
<script>

//function load() {
//	document.title = "Associate Encounter";
//}
function checkEpisode(index)
{
	
	
	var objSel = eval("document.PkgSubscriptionAssociationDtlsForm.selectEncounter"+index);
	
	
	if (objSel.checked==true)
		{
	
			var episode_types = document.PkgSubscriptionAssociationDtlsForm.episode_types.value;	
			var packageCodeList= document.PkgSubscriptionAssociationDtlsForm.packageCodeList.value;	 
			
			var episode_type = eval("document.PkgSubscriptionAssociationDtlsForm.alPatientClass"+index).value;	
			var retArray= episode_types.split("|");
			var pkgArray= packageCodeList.split("|");
			
			for(i=0;i<retArray.length;i++)
				{		
				 if(retArray[i] != '' && retArray[i] != 'undefined' && retArray[i].indexOf(episode_type)<0)			
				 		{
					 
					 		
					 		alert(getMessage("BL8688","BL"));
					 		eval("document.PkgSubscriptionAssociationDtlsForm.selectEncounter"+index).checked=false;
					 		return  false; 
					 	}		
				 else if( (retArray[i] =='' && pkgArray[i]!='') && i <retArray.length-1)
					 {
					 	alert("Please complete all entries in package selection");
					 	eval("document.PkgSubscriptionAssociationDtlsForm.selectEncounter"+index).checked=false;
					 	return false;
					 }
				}
		isAcrossEncounter(index);  
	/* 	alert(index);
		alert($('#alVisitAdmDate'+index).val());
	 */	var alVisitAdmDate=$('#alVisitAdmDate'+index).val();
		

		$('#alvisitAdmDateHdn').val(alVisitAdmDate);
				var payerCode=$('#payerCode').val();
		var payerGrpCode=$('#payerGrpCode').val();
		
		var payerCodeExistingPkg=$('#payerCodeExistingPkg').val();
		var payerGrpCodeExistingPkg=$('#payerGrpCodeExistingPkg').val();
		
	//Added By Vijay For MMS-ICN-00015
	//alert("cust_group_code:"+payerGrpCode);
	if(payerGrpCode!="null" && payerGrpCode!='' && payerGrpCode!=null || payerCodeExistingPkg!="" && payerCodeExistingPkg!="null" && payerCodeExistingPkg!=null) //|| payerGrpCode!=null)//payerGrpCode!=null) ||payerGrpCode!='null')
	{
	// alert("test");
	$.ajax({	
	url:"../../eBL/jsp/BLPkgAscteValidation.jsp",
	type:"Post",
	dataType:"text",
	data:{
		 calledFrom:'patientPayerValidation',
		 payerCode:$('#payerCode').val(),
		 payerGrpCode:$('#payerGrpCode').val(),      
		 episodeId:  $("#alEpisodeId"+index).val(),   	
		 visitId:  $("#alVisitId"+index).val(), 
		 facility_id:$('#facility_id').val(),
		 payerCodeExistingPkg:payerCodeExistingPkg,
		 payerGrpCodeExistingPkg:payerGrpCodeExistingPkg
	},
	async:false,
	success:function(data){
		//Added by jeyachitra for edge support
	  if(data.indexOf('<!DOCTYPE html>')!=-1)
		{
			  data = data.replace(/<!DOCTYPE html>/gi, "");
			  data= trimString(data);
		}
	 var obj = jQuery.parseJSON(data);
	 //alert(obj.flag);
	
	if(obj.flag!='Y')
		{
		alert('Payer Group associated with Package is not present in Financial Details');
		eval("document.PkgSubscriptionAssociationDtlsForm.selectEncounter"+index).checked=false;
			return false;
		}
	}	
	});
	}

	//--- Ends ---
	
	}
		}
		

function isAcrossEncounter(index){
	var totalRecords=document.PkgSubscriptionAssociationDtlsForm.totalRecords.value;
	var acrossEncounterParameter=document.PkgSubscriptionAssociationDtlsForm.acrossEncounterParameter.value;
	if(acrossEncounterParameter=='N'){// if across encounter is not supported
		for(var i=0;i<totalRecords;i++){
		eval("document.PkgSubscriptionAssociationDtlsForm.selectEncounter"+i).checked=false;					
		}
		eval("document.PkgSubscriptionAssociationDtlsForm.selectEncounter"+index).checked=true;
	}
}

function loadMultipleEncounters(){
	
	var pkgSubscriptionAssociationDtlsForm=document.PkgSubscriptionAssociationDtlsForm;
	    var chkCount = 0; 
		for(var i=0; i<pkgSubscriptionAssociationDtlsForm.elements.length; i++)
		{
			var fieldName=pkgSubscriptionAssociationDtlsForm.elements[i].name;
			var indexFound=fieldName.indexOf("selectEncounter");
			if(indexFound!=-1){
				var fieldValue=pkgSubscriptionAssociationDtlsForm.elements[i].checked;
				if(fieldValue==true){
					pkgSubscriptionAssociationDtlsForm.elements[i].value=true;
					chkCount = 1;
				}
			}
		}
		
		if(chkCount == 0){
			alert("Select one encounter to be associated");
			return false;
		}
		var frmObj=document.PkgSubscriptionAssociationDtlsForm;
		var temp_jsp="../../eBL/jsp/PkgSubscriptionAssociationDtlsValidation.jsp?action=submit&totalRecords="+frmObj.totalRecords.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;		

			
			if(frmObj!="" && frmObj!=null && frmObj !=undefined )
			{
			/*Changed for MMS-JU-SCF-0151 PALANINARAYANAN  */
			var xmlString=formXMLStringMainPkgSub(frmObj);
			var updation=formValidation(xmlString,temp_jsp);
			xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
			}				

		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);	//any XML object can also be sent as a parameter
		
		if(xmlHttp.responseText.indexOf('<!DOCTYPE html>')!=-1)
		{
			xmlHttp.responseText = xmlHttp.responseText.replace(/<!DOCTYPE html>/gi, "");
		}
		var encounterCombinationString = trimString(xmlHttp.responseText);
	 
		var selectCheckBoxList=$('#selectCheckBoxList').val();
		
		var dataArrr=$.trim(selectCheckBoxList).split(',');
		
		var alvisitAdmDateHdn=$('#alvisitAdmDateHdn').val();
		var visitDatTime=$('#visitDatTime').val();
		
		//visitDatTime
		if(alvisitAdmDateHdn=='' ||alvisitAdmDateHdn==null||alvisitAdmDateHdn==undefined||alvisitAdmDateHdn=='undefined')
			{
			alvisitAdmDateHdn=visitDatTime;
			
			//return false;
			}
		//alert("ret value:" +chkCount + "::" + selectCheckBoxList+ "::" +alvisitAdmDateHdn + "::" + encounterCombinationString);
		window.returnValue = chkCount + "::" + selectCheckBoxList+ "::" +alvisitAdmDateHdn + "::" + encounterCombinationString ;
		
		window.close();

	
}


$(document).ready(function () {

	
 	$(".selectEncounterCheckBox").click(function(){
 		var objthis=$(this);
 		var index = $('#PkgSubscriptionAssociationDataSet tr').index($(this).closest('tr')) - 1;
		 
 		if($(this).is(":checked") == true) {
		 	 	 $.ajax({
			          url:"../../eBL/jsp/PkgAssociationExistingPackagesValidation.jsp",
			          type:'post',
					  async:false,
			          data: {
			        	  	  operation:    "encounterAssociationValidation",
			        	  	  patientId:  	$("#patientId").val(), 
			        		  encounterId:  $("#alEncounterId"+index).val(),
			        		  episodeId:  $("#alEpisodeId"+index).val(),   	
			        		  visitId:  $("#alVisitId"+index).val()   	
			          },          
			          success: function(data) {
			        	  if(data.indexOf('<!DOCTYPE html>')!=-1)
							{
			        		  data = data.replace(/<!DOCTYPE html>/gi, "");
			        		  data= trimString(data);
							}
		                  var obj = jQuery.parseJSON(data);
			        	  var returnVal =obj.flag;
			        	  var returnDesc= obj.desc;//Karthik modified code for MMS-RY-SCF-0065
				      	  if(returnVal=="FAIL" && returnDesc=="ENC_ALREADY_ASSOCIATED"){
			        		  alert("Encounter is Already associated to One or more Packages");
			        		  objthis.prop("checked",false);
			        		  
			        	  }
				      	  
				      	  if(returnVal=="FAIL" && returnDesc=="PAYER_NA_FIN_DTLS"){//Karthik modified code for MMS-RY-SCF-0065
			        		  alert("Payer Information not present in Patient Financial Details ");
			        		  objthis.prop("checked",false);			        		  
			        	  }
				      	  
			          }
			          
			        });  
 			}

	}); 

	  
});
</script>
<%-- JSP Page specific a8ttributes end --%>
<%
	System.err.println("PkgSubscriptionAssociationDtls.jsp?"+request.getQueryString());

	String facilityId = (String) session.getValue("facility_id");
	String payerCode = request.getParameter("payerCodeTemp");
	String payerGrpCode = request.getParameter("payerGrpCodeTemp");
	String payerCodeExistingPkg = request.getParameter("payer_code_temp");
	String payerGrpCodeExistingPkg = request.getParameter("payer_group_code_temp");
	//Added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622 Starts
	String packageCodeList = request.getParameter("packageCodeList");
	String package_seq_no = request.getParameter("package_seq_no");
	String eff_from_date = request.getParameter("eff_from_date");
	String function_id = request.getParameter("function_id");
	//Added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  Ends
	StringBuilder sbs = new StringBuilder();
	StringBuilder sb = new StringBuilder();
	String blngcodestr = "";
	String packageBlngClassCode = request.getParameter("packageBlngClassCode");
	StringTokenizer st = new StringTokenizer(packageBlngClassCode, "|");
	System.out.println("Total  PackagesaddList : " + st.countTokens());
	if (st.countTokens() > 0) {
		String s1 = packageBlngClassCode;
		String[] words = s1.split("\\|");
		for (String w : words) {
			sbs.append("'" + w + "'" + ",");
		}
		System.out.println("w words :" + sbs.toString());
		blngcodestr = sbs.toString();
		blngcodestr = blngcodestr.substring(0, blngcodestr.length() - 1);
	}
	
	System.err.println("function_id in subass:"+function_id);
	
	

	ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanList = (session
			.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG")) == null
					? new ArrayList<PkgAssociationExistingPackagesBean>()
					: (ArrayList<PkgAssociationExistingPackagesBean>) session
							.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");
							
	if (pkgAssociationExistingPackagesBeanList.size() > 0) {
		System.err.println("Total PackagesBeanList : " + pkgAssociationExistingPackagesBeanList.size());
		for (PkgAssociationExistingPackagesBean bean : pkgAssociationExistingPackagesBeanList) {
			System.err.println("bean" + bean.getExistingPkgBlngClassCode());
			sb.append("'" + bean.getExistingPkgBlngClassCode() + "'" + ",");
		}
		sbs.append(sb);
		blngcodestr = sbs.toString();
		blngcodestr = blngcodestr.substring(0, blngcodestr.length() - 1);
	}

	System.err.println("Final blngcodestr :" + blngcodestr);
	String patientId = request.getParameter("patientId");
	String episodeTypes = request.getParameter("packageEpisodeTypes");
	String selectCheckBoxList = request.getParameter("selectCheckBoxList");
	String visitDatTime = request.getParameter("alvisitAdmDateHidden");

	ArrayList<String> encounterListArray = new ArrayList<String>();
	String acrossEncounterParameter = request.getParameter("acrossEncounterParameter");
	Boolean siteSpec = false;
	Connection con = null;

	try {
		con = ConnectionManager.getConnection();
		siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "DISP_PKG_DATE_FIELDS_DUR_SUBS");
		System.out.println("SiteSpec" + siteSpec);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception in site specific " + e);
	}
	
	// Added the condition to check for called function id because if called from MPP, each package seq should be allowed to select its 
	// own encounter. If earlier session value is loaded then other sequence encounter will be loaded by default, which shouldnt happen
	
	if (session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS") != null && !"EBL_TRAN_PACKAGE_MAINTAIN".equals(function_id)) {
		HashMap<String, ArrayList<String>> packageSubscriptionAssociationEncounters = new HashMap<String, ArrayList<String>>();
		ArrayList<String> encounterCombinationArray = new ArrayList<String>();
		packageSubscriptionAssociationEncounters = (HashMap<String, ArrayList<String>>) session
				.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
		encounterCombinationArray = packageSubscriptionAssociationEncounters.get(patientId);
		if (encounterCombinationArray == null) {
			encounterCombinationArray = new ArrayList<String>();
		}
		for (int encCount = 0; encCount < encounterCombinationArray.size(); encCount++) {
			StringTokenizer stEncList = new StringTokenizer(encounterCombinationArray.get(encCount), "|");
			String headerEpisodeType = stEncList.nextToken();
			String encounterId = stEncList.nextToken();
			encounterListArray.add(encounterId);
		}
	}

	System.out.println(
			session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS") + "@@" + encounterListArray);

	session.removeAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");

	PreparedStatement pstmt = null;
	ResultSet rscurr = null;
	ArrayList<String> alPatientClass = new ArrayList<String>();
	ArrayList<String> alEpisodeId = new ArrayList<String>();
	ArrayList<String> alEncounterId = new ArrayList<String>();
	ArrayList<String> alVisitId = new ArrayList<String>();
	ArrayList<String> alVisitAdmDate = new ArrayList<String>();
	ArrayList<String> alChkOutDischrgDate = new ArrayList<String>();
	String assocEncQuery = "";

	try {
		if (siteSpec) {
			//MMS-SCF-0385 Karthik changed Query to Sort and prioritize latest Encounter first 
			System.out.println("Inside SiteSpec:" + siteSpec);
			assocEncQuery = "SELECT PATIENT_CLASS, EPISODE_ID,ENCOUNTER_ID, REPLACE(ENCOUNTER_ID,EPISODE_ID,'') VISIT_ID,to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') VISIT_ADM_DATE_TIME_1, VISIT_ADM_DATE_TIME, to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') DISCHARGE_DATE_TIME FROM PR_ENCOUNTER a WHERE PATIENT_ID =? and FACILITY_ID=? AND ((patient_class IN ('OP','EM') AND visit_status NOT IN ('99')) OR (patient_class IN ('IP','DC') AND adt_status NOT IN ('09'))) "; //V220826
			
			if(!"".equals(blngcodestr))
				assocEncQuery = assocEncQuery + " AND EXISTS (SELECT 1 FROM bl_blng_class b WHERE b.patient_category_code = SUBSTR (a.patient_class, 1, 1) AND blng_class_code IN (" + blngcodestr + "))";
					
			assocEncQuery = assocEncQuery + " order by VISIT_ADM_DATE_TIME desc";
		} else {
			assocEncQuery = "SELECT PATIENT_CLASS, EPISODE_ID,ENCOUNTER_ID, REPLACE(ENCOUNTER_ID,EPISODE_ID,'') VISIT_ID,to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') VISIT_ADM_DATE_TIME_1, VISIT_ADM_DATE_TIME ,to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') DISCHARGE_DATE_TIME FROM PR_ENCOUNTER WHERE PATIENT_ID =? and FACILITY_ID=? AND ((patient_class IN ('OP','EM') AND visit_status NOT IN ('99')) OR (patient_class IN ('IP','DC') AND adt_status NOT IN ('09'))) order by VISIT_ADM_DATE_TIME desc";//V220826
	
		}
		System.err.println("assocEncQuery:"+assocEncQuery);
		pstmt = con.prepareStatement(assocEncQuery);
		pstmt.setString(1, patientId);
		pstmt.setString(2, (String) session.getValue("facility_id"));
		rscurr = pstmt.executeQuery();
		
		if (rscurr != null)
			while (rscurr.next()) {
				String tmpPatientClass = rscurr.getString("PATIENT_CLASS");
				if (tmpPatientClass == null)
					tmpPatientClass = "";
				String tmpEpisodeId = rscurr.getString("EPISODE_ID");
				if (tmpEpisodeId == null)
					tmpEpisodeId = "";
				String tmpEncounterId = rscurr.getString("ENCOUNTER_ID");
				if (tmpEncounterId == null)
					tmpEncounterId = "";
				String tmpVisitId = rscurr.getString("VISIT_ID");
				if (tmpVisitId == null)
					tmpVisitId = "";
				String tmpVisitAdmDate = rscurr.getString("VISIT_ADM_DATE_TIME_1"); //V220826
				System.err.println("tmpVisitAdmDate is: "+rscurr.getString("VISIT_ADM_DATE_TIME"));
				if (tmpVisitAdmDate == null)
					tmpVisitAdmDate = "";
				String tmpChkOutDischrgDate = rscurr.getString("DISCHARGE_DATE_TIME");
				if (tmpChkOutDischrgDate == null)
					tmpChkOutDischrgDate = "";

				alPatientClass.add(tmpPatientClass);
				alEpisodeId.add(tmpEpisodeId);
				alEncounterId.add(tmpEncounterId);
				alVisitId.add(tmpVisitId);
				alVisitAdmDate.add(tmpVisitAdmDate);
				alChkOutDischrgDate.add(tmpChkOutDischrgDate);
			}
		if (rscurr != null)
			rscurr.close();
		pstmt.close();
	} catch (Exception e) {
		System.out.println("Error episodeTypeList=" + e.toString());
		e.printStackTrace();
	} finally {
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}
%>
<%
	if (alPatientClass.size() < 1) {
%>
<script>alert('Query caused No records');window.close();</script>
<%
	} else {
%>
<HTML>

<title><%=request.getParameter("title")%></title>
<body>
	<FORM name="PkgSubscriptionAssociationDtlsForm" id="PkgSubscriptionAssociationDtlsForm">
	<div class="scroll-container" style="max-height: 79vh; overflow-y: auto; overflow-x: hidden; border: 1px solid #ccc; padding: 5px; width: 99%;">
		<table id='PkgSubscriptionAssociationDataSet' border="1" width="100%"
			cellspacing='0' cellpadding='0'>
			<tr>
				<th width='10%'><fmt:message key="Common.patientclass.label"
						bundle="${common_labels}" /></th>
				<th width='10%'><fmt:message key="Common.episodeid.label"
						bundle="${common_labels}" /></th>
				<th width='10%'><fmt:message key="Common.encounterid.label"
						bundle="${common_labels}" /></th>
				<th width='10%'><fmt:message key="Common.VisitID.label"
						bundle="${common_labels}" /></th>
				<%
					if (siteSpec) {
				%>
				<th width='10%'><fmt:message key="eBL.VisitAdmissionDate.label"
						bundle="${bl_labels}" /></th>
				<th width='10%'><fmt:message
						key="eBL.CheckOutDischargeDate.label" bundle="${bl_labels}" /></th>
				<%
					}
				%>
				<th width='10%'><fmt:message key="Common.defaultSelect.label"
						bundle="${common_labels}" /></th>
				<td width='*'></td>
			</tr>

			<%
				for (int i = 0; i < alPatientClass.size(); i++) {
			%>
			<tr>
				<td><input readonly class="label" name="alPatientClass<%=i%>" id="alPatientClass<%=i%>"
					value="<%=alPatientClass.get(i)%>"></td>
				<td><input readonly class="label" id="alEpisodeId<%=i%>"
					name="alEpisodeId<%=i%>" value="<%=alEpisodeId.get(i)%>"></td>
				<td><input readonly class="label" id="alEncounterId<%=i%>"
					name="alEncounterId<%=i%>" value="<%=alEncounterId.get(i)%>"></td>
				<td><input readonly class="label" id="alVisitId<%=i%>"
					name="alVisitId<%=i%>" value="<%=alVisitId.get(i)%>"></td>
				<%
					if (siteSpec) {
				%>
				<td><input readonly class="label" id="alVisitAdmDate<%=i%>"
					name="alVisitAdmDate<%=i%>" value="<%=alVisitAdmDate.get(i)%>"></td>
				<td><input readonly class="label"
					id="alChkOutDischrgDate<%=i%>" name="alChkOutDischrgDate<%=i%>"
					value="<%=alChkOutDischrgDate.get(i)%>"></td>
				<%
					}
				%>
				<td align=center><input type="checkbox"
					class='selectEncounterCheckBox' name="selectEncounter<%=i%>" id="selectEncounter<%=i%>"
					<%=encounterListArray.contains(alEncounterId.get(i)) ? "checked" : ""%>
					value="false" onclick="checkEpisode(<%=i%>);"></td>
				<td></td>
			</tr>
			<%
				}
			%>
			<input type=hidden name=totalRecords id=totalRecords
				value="<%=alPatientClass.size()%>">
			<input type=hidden id=patientId name=patientId id=patientId value="<%=patientId%>">
			<input type=hidden name=acrossEncounterParameter id=acrossEncounterParameter
				value="<%=acrossEncounterParameter%>">
			<input type=hidden name=episode_types id=episode_types value="<%=episodeTypes%>">
			<input type=hidden name=packageCodeList id=packageCodeList
				value="<%=request.getParameter("packageCodeList")%>">

			<input type=hidden name=selectCheckBoxList id='selectCheckBoxList'
				value="<%=selectCheckBoxList%>">

			<input type=hidden name=alvisitAdmDateHdn id='alvisitAdmDateHdn'
				value="">

			<input type='hidden' name='indexhidden' id='indexhidden' id='indexhidden' value=''>
			<input type='hidden' name='visitDatTime' id='visitDatTime' id='visitDatTime'
				value='<%=visitDatTime%>'>

			<input type='hidden' name='payerGrpCode' id='payerGrpCode' id='payerGrpCode'
				value='<%=payerGrpCode%>'>
			<input type='hidden' name='payerCode' id='payerCode' id='payerCode'
				value='<%=payerCode%>'>

			<input type='hidden' name='payerCodeExistingPkg' id='payerCodeExistingPkg'
				id='payerCodeExistingPkg' value='<%=payerCodeExistingPkg%>'>
			<input type='hidden' name='payerGrpCodeExistingPkg' id='payerGrpCodeExistingPkg'
				id='payerGrpCodeExistingPkg' value='<%=payerGrpCodeExistingPkg%>'>
			<!-- Below hidden fields are added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  STRATS-->
			<input type='hidden' name='package_seq_no' id='package_seq_no' id='package_seq_no'
				value='<%=package_seq_no%>'>
				<input type='hidden' name='eff_from_date' id='eff_from_date' id='eff_from_date'
			value='<%=eff_from_date%>'>
			<input type='hidden' name='function_id' id='function_id' id='function_id'
			value='<%=function_id%>'>			
			<!-- Below hidden fields are added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  ENDS-->
		</table>
		</div>
		<TABLE width='100%' border='0' cellpadding='3' cellspacing='0'>
			<tr>
				<td width='25%' class='fields'></td>
				<td width='20%' class='fields'><input type='button'
					class='button'
					value='<fmt:message key="Common.Submit.label" bundle="${common_labels}" />'
					size='20' onClick='loadMultipleEncounters();'></td>
			</tr>
		</TABLE>
	</FORM>
</BODY>
</html>
<%
	}
%>

