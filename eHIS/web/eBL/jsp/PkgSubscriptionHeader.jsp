<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,eBL.PkgSubsBean " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>  
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<!--<script language="javascript" src='../../eBL/js/PkgDef.js'></script>-->
<script language="javascript" src='../../eBL/js/PkgSubs.js'></script> 
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
async function pkgSubscriptionWindow(){
	var patientId = document.frmPkgDefHeader.patientId.value;
	var alvisitAdmDateHidden = $('#alvisitAdmDateHidden').val();
	var siteSpec=$(parent.PkgSubscriptionDtls.document).find('#site_spec').val();
	var siteBLPkgBlngGrpYN=$(parent.PkgSubscriptionDtls.document).find('#siteBLPkgBlngGrpYN').val();//Added By Shikha For GHL-CRF-0520.1

	if (patientId == '') {
		alert("Please Provide Patient ID");
	} else {
		var pkgSubsDoc = parent.PkgSubscriptionDtls.document;
		var selectCheckBoxList = $(pkgSubsDoc).find(
				"input[name=existingPkgChecked]:checked").map(function() {
			return this.value;
		}).get().join(",");
		var dateArray = selectCheckBoxList.split(',');

		var dateAr = "";
		var dte = "";
		/* 	alert('dateARray '+dateArray)
			alert('dateArray.length '+dateArray.length);
		 */
		var len = $(parent.PkgSubscriptionDtls.document).find(
				'#pkgSubsExistingPkgTbl tr').length;

		var payer_code='';
		var payer_group_code=''; 
			 
		var  payer_code_temp='';
		var payer_group_code_temp='';
		var payer_group_code='';				
			
	//if (siteSpec == 'true') {
		
if(selectCheckBoxList.length>0){
	for (i = 0; i <= len; i++) {
		for ( var j = 0; j <= dateArray.length; j++) {
			if (i == dateArray[j]) {				
				if(parent.PkgSubscriptionDtls.document.getElementById("payer_group_code"+i).value!=null && parent.PkgSubscriptionDtls.document.getElementById("payer_group_code"+i).value!="null")	{ 
					payer_code+=parent.PkgSubscriptionDtls.document.getElementById("payer_code"+i).value+","+payer_code_temp;
					payer_code_temp=payer_code;
					payer_code='';
					payer_group_code+=parent.PkgSubscriptionDtls.document.getElementById("payer_group_code"+i).value+","+payer_group_code_temp;							
					payer_group_code_temp=payer_group_code;	
					payer_group_code='';						
				}					
			else{
				if(payer_group_code_temp=='') 
				{
					payer_group_code_temp='';
					payer_code_temp='';
				}						
				}
					
				dte = parent.PkgSubscriptionDtls.document
							.getElementById("from_date" + i).value;					
				dateAr += dte + ",";
				}
			}
		}
	}

	//var episodeIdList=$(pkgSubsDoc).find("input[name=existingPkgEpiType]").map(function () {return this.value;}).get().join("|");
	$("#selectCheckBoxList").val(selectCheckBoxList);
	var frmObj = parent.PkgSubscriptionDtls.document.frmPkgSubs;
	if (frmObj != "" && frmObj != null && frmObj != undefined) {
		/* Karthik added validation here to perform extra check for Multi encounter cases while subscription - Starts */
		var isEmptyPackageCode = parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_0.value;
		if (isEmptyPackageCode == '' && selectCheckBoxList == '') {
			alert("Please Select a Package");
		} else {
			var totalRecords = parent.PkgSubscriptionDtls.document.frmPkgSubs.total_records.value;
			var packageCodeList = '';
			var packageEpisodeType = '';
			var packageBlngClassCode='';
			var packageBlngGrpCode='';
			var payerGrpCode="";
			var payerCode="";
			var payerGrpCodeTemp="";
			var payerCodeTemp="";
		for(var i=0;i<totalRecords;i++){
			payerGrpCode='';
			payerCode='';					
			packageCodeList += eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+i).value + "|";
			packageEpisodeType+= eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.episodeType_"+i).value + "|";
			packageBlngClassCode+= eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blng_class_code"+i).value + "|";
		//Added By Shikha For GHL-CRF-0520.1
		if(siteBLPkgBlngGrpYN=="Y"){					
			packageBlngGrpCode+= eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blngGrpCode_"+i).value + "|"; 
		}//Added By Shikha For GHL-CRF-0520.1
			if(eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_"+i).value!="null"&&eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_"+i).value!=null&&eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_"+i).value!='')
			{	
				payerGrpCode+=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_"+i).value+","+payerGrpCodeTemp;
				payerGrpCodeTemp=payerGrpCode;
				payerCode+=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerCode_"+i).value+","+payerCodeTemp;
				payerCodeTemp=payerCode;
			}
			else{						
					if(payerGrpCodeTemp==''){
						payerGrpCodeTemp='';
						payerCodeTemp='';
					}
				}			
	}					
		
	var pkgCodeArray=selectCheckBoxList.split(',');
	if(pkgCodeArray===undefined) pkgCodeArray='';
	for (var i = 0; i < pkgCodeArray.length; i++) {
			packageCodeList += $(pkgSubsDoc).find("input[name=existingPkgCode"+pkgCodeArray[i]+"]").val()  + "|";
			packageEpisodeType += $(pkgSubsDoc).find("input[name=existingPkgEpiType"+pkgCodeArray[i]+"]").val()  + "|";
		}

	var URL="../../eBL/jsp/PkgSubscriptionAssociationDtlsValidation.jsp?action=across_encounter_check&packageCodeList="+packageCodeList+"&packageEpisodeTypes="+packageEpisodeType ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlHttp.open("POST",URL,false);
	xmlHttp.send();
	var responseText=trimString(xmlHttp.responseText);
	var acrossEncounterParameter="N";
	if(responseText.indexOf("SUCCESS_ACROSS_ENCOUNTER")!=-1){ // If across encounter is true as SUCCESS_ACROSS_ENCOUNTER is  found
		acrossEncounterParameter="Y";
	}else{//across encounter is false as SUCCESS_ACROSS_ENCOUNTER is  found
		acrossEncounterParameter="N";	
	}
	var dialogUrl="";
	var title = "Associate Encounter";
	//Added By Shikha For GHL-CRF-0520.1
	if(siteBLPkgBlngGrpYN=="Y"){
			dialogUrl = "../../eBL/jsp/PkgSubscriptionAssociationDtls.jsp?patientId="
					+ patientId
					+ "&acrossEncounterParameter="
					+ acrossEncounterParameter
					+ "&packageCodeList="
					+ packageCodeList
					+ "&packageEpisodeTypes="
					+ packageEpisodeType
					+ "&selectCheckBoxList="
					+ selectCheckBoxList
					+ "&alvisitAdmDateHidden="
					+ alvisitAdmDateHidden
					+ "&packageBlngClassCode="
					+ packageBlngClassCode
					+ "&packageBlngGrpCode="
					+ packageBlngGrpCode //Added By Shikha For GHL-CRF-0520.1
					+"&payerCodeTemp="
					+ payerCodeTemp
					+ "&payerGrpCodeTemp="
					+ payerGrpCodeTemp
					+"&payer_code_temp="
					+ payer_code_temp
					+ "&payer_group_code_temp="
					+ payer_group_code_temp
					+ "&title="
					+title;
		}else{
				dialogUrl = "../../eBL/jsp/PkgSubscriptionAssociationDtls.jsp?patientId="
					+ patientId
					+ "&acrossEncounterParameter="
					+ acrossEncounterParameter
					+ "&packageCodeList="
					+ packageCodeList
					+ "&packageEpisodeTypes="
					+ packageEpisodeType
					+ "&selectCheckBoxList="
					+ selectCheckBoxList
					+ "&alvisitAdmDateHidden="
					+ alvisitAdmDateHidden
					+ "&packageBlngClassCode="
					+ packageBlngClassCode
					+"&payerCodeTemp="
					+ payerCodeTemp
					+ "&payerGrpCodeTemp="
					+ payerGrpCodeTemp
					+"&payer_code_temp="
					+ payer_code_temp
					+ "&payer_group_code_temp="
					+ payer_group_code_temp
					+ "&title="
					+title;
		}
		var dialogFeatures  = "dialogHeight:" + "60vh" + "; dialogWidth:" + "70vw" +" ; scroll=auto; ";
		var returnVal = await window.showModalDialog(dialogUrl,null,dialogFeatures);
		var dataArr = $.trim(returnVal).split('::');
		if (dataArr[0] == 1)
		parent.PkgSubscriptionDtls.document.frmPkgSubs.Add.disabled= true;
		else
		parent.PkgSubscriptionDtls.document.frmPkgSubs.Add.disabled= false;				
		
	if (siteSpec == 'true') {		
		if(selectCheckBoxList!=''){			
			var dataArrr = $.trim(dataArr[1]).split(',');
			var alvisitAdmDateHdn = dataArr[2];
			if (returnVal == 'undefined' || returnVal == undefined) {
				var dataArr = selectCheckBoxList.split(',');
				var existingDate = dateAr.split(',');
				var length = $(parent.PkgSubscriptionDtls.document)
						.find('#pkgSubsExistingPkgTbl tr').length;
				for ( var i = 0; i <= length; i++) {
					for ( var j = 0; j <= existingDate.length; j++) {
						if (i == existingDate[j]) {
							parent.PkgSubscriptionDtls.document
									.getElementById("from_date" + i).value = existingDate[i];
							parent.PkgSubscriptionDtls.document
							.getElementById("fromdatehdn" + i).value = existingDate[i];
							/* $.ajax({
								url:"../../eBL/jsp/PkgAssociationExistingPackagesPersistance.jsp",
								type:'post',
								data:{
								  existingPkgCode: $(parent.PkgSubscriptionDtls.document).find('#existingPkgCode'+i).val(),
								  existingPkgSeqNo:$(parent.PkgSubscriptionDtls.document).find('#existingPkgSeqNo'+i).val(),
								  existingPkgEpiType:$(parent.PkgSubscriptionDtls.document).find('#existingPkgEpiType'+i).val(),
								  existingPkgFrmDte:$(parent.PkgSubscriptionDtls.document).find('#fromdate'+i).val(),
								  operation: 'modify'
								},
								async:false,
								success: function(data) {
								}
							});    */						
						}
					}
				}
				return false;
			}

		if (returnVal != 'undefined' || returnVal != undefined) {
			$('#alvisitAdmDateHidden').val(alvisitAdmDateHdn);
			var length = $(parent.PkgSubscriptionDtls.document)
					.find('#pkgSubsExistingPkgTbl tr').length;
			if (alvisitAdmDateHdn != '') {
				for ( var i = 0; i <= length; i++) {
					for ( var j = 0; j <= dataArrr.length; j++) {
						if (i == dataArrr[j]) {
							parent.PkgSubscriptionDtls.document
									.getElementById("from_date"
											+ i).value = alvisitAdmDateHdn;
							parent.PkgSubscriptionDtls.document
							.getElementById("fromdatehdn"
									+ i).value = alvisitAdmDateHdn;					
							
							/* callvalidate(i, 'null',
									'Pkgsubsheader'); */
						$.ajax({
								url:"../../eBL/jsp/PkgAssociationExistingPackagesPersistance.jsp",
								type:'post',
								data:{
								  existingPkgCode: $(parent.PkgSubscriptionDtls.document).find('#existingPkgCode'+i).val(),
								  existingPkgSeqNo:$(parent.PkgSubscriptionDtls.document).find('#existingPkgSeqNo'+i).val(),
								  existingPkgEpiType:$(parent.PkgSubscriptionDtls.document).find('#existingPkgEpiType'+i).val(),
								  existingPkgFrmDte:$(parent.PkgSubscriptionDtls.document).find('#from_date'+i).val(),
								  operation: 'modify'
								},
								async:false,
								success: function(data) {
								}
							});							
						}
					}
				}
			 }
			}					
		  }
		}
		if(selectCheckBoxList!=''){
				 $.ajax({
					 url:"../../eBL/jsp/PkgAssociationExistingPackagesValidation.jsp",
					 type:'post',
					  async:false,
					 data: {
						  operation:    "encounterChecked"	  
					 },          
					 success: function(data) {
						 var obj = jQuery.parseJSON(data);
					  var returnVal =obj.flag;
						  if(returnVal=="FAIL"){
						  $("#noEncounterToAssociate").val('true');
						  }else{
						  $("#noEncounterToAssociate").val('false');  
						  }
					 }					 
				   });  
			}
		 }
		}
	}
}
</script>
</head>

<% 
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	Statement stmt				= null;
	ResultSet rs = null;ResultSet rscurr=null;
	String sysDate="";
	String sysDateTime="";
	int noofdecimal=2;
	String PatIDLen = "";//Added by lakshmi for patient id lenght
	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;
	String facility_id			= (String)session.getAttribute("facility_id");
	ArrayList<String>	episodeTypeList	=	new ArrayList<String>();
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	try {
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
		} catch(Exception ex) {
			System.err.println("Error in PkgSubscriptionHeader.jsp for getting site3TierAlmoFeature Connection: "+ex);
			ex.printStackTrace();
		}	
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

	//Added against GHL-CRF-0631
	boolean isSiteSpec = false;
	String siteBLPkgBlngGrpYN = "N";	
	try {
			isSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "BL_CAL_BY_FACILITY");
			if (isSiteSpec)
				siteBLPkgBlngGrpYN = "Y";
			else
				siteBLPkgBlngGrpYN = "N";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in isSiteSpec_GHL " + e);
		}
	//Added against GHL-CRF-0631
	
	//add below 2 hidden fields for NMC-JD-CRF-0084 05-02-2021 STARTS
	boolean blPkgDepositSubscription = false;
		try{
			blPkgDepositSubscription = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_PKG_DEPOSIT_SUBSCRIPTION_YN");
			}catch(Exception ex) {
				System.err.println("Error in PkgSubscriptionHeader.jsp for getting site3TierAlmoFeature Connection: "+ex);
				ex.printStackTrace();
			}
	//add below 2 hidden fields for NMC-JD-CRF-0084 05-02-2021 ENDS

	try
	{
		String params = request.getQueryString();		
		String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;
		//Added by lakshmi against patient id length issue starts here
		try{
				String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
				pstmt1=con.prepareStatement(sqlLen);
				rs1=pstmt1.executeQuery();
				while(rs1.next() && rs1!=null){
					PatIDLen   = (rs1.getString("PATIENT_ID_LENGTH")==null)?"0":rs1.getString("PATIENT_ID_LENGTH");
				}
				if(rs1!=null) rs1.close();
				if(pstmt1!=null) pstmt1.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception @ Patient Id Length :"+e);
				e.printStackTrace();
			}
	//Added by lakshmi against patient id length issue ends here
		
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				if( rs.next() )
					sysDate = rs.getString(1); 
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception @ HEADER sysDate :"+e);
			e.printStackTrace();
		}

	//add for NMC-JD-CRF-0084 05-02-2021 STARTS
	try
	{
		String query_date_time="select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_date_time) ;
		if( rs != null ) 
		{
			if( rs.next() )
				sysDateTime = rs.getString(1); 
		}
	if (rs != null)   rs.close();
	if (stmt != null)   stmt.close();
	}		
	catch(Exception e)
	{
		System.out.println("Exception @ sysdate  :"+e);
		e.printStackTrace();
	}
	
	//add for NMC-JD-CRF-0084 05-02-2021 ENDS

		try{		
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
				rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					noofdecimal  =  rscurr.getInt(1);		
				}	
				if(rscurr != null) rscurr.close();
				pstmt.close();
			}catch(Exception e) {System.out.println("3="+e.toString());
				e.printStackTrace();
			}
		
		/* Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Starts*/
		String siteParam="";				
		
			try{
				String siteParamSql = "Select CUSTOMER_ID from SM_SITE_PARAM ";
				pstmt = con.prepareStatement(siteParamSql);		
				rs1 = pstmt.executeQuery();
				if(rs1 != null){
					while(rs1.next()){
						siteParam = rs1.getString("CUSTOMER_ID");
						if(siteParam==null){
							siteParam="";
						}
					}
				}			
				pstmt = null;
				rs1 = null;			
			}
			catch(Exception e)
			{
					System.out.println("Exception in getting bl_param"+e);
			}		
		/* Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Ends*/

   %>
   <script>
   function select_pat_id()
	{	
		document.forms[0].patientId.focus();
	}	  
   </script>
		
	<body onLoad="select_pat_id();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
	
	<form name='frmPkgDefHeader' id='frmPkgDefHeader' >
	<table border='0' cellpadding='1' cellspacing='1' align='center' width='100%'>
	<tr>		
		<td class="label" width="25%"><b><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></b>
		<INPUT TYPE="TEXT"  name="patientId" id="patientId" SIZE="10" maxlength='<%=PatIDLen%>' VALUE='' tabindex ='1' onKeyPress='changeToUpper()' onBlur="callPatValidation(this);" ><input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return getPatID()" tabindex='2'><img src='../../eCommon/images/mandatory.gif'>
		<!-- Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Starts  -->	
		<% //Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		if(siteParam.equals("ALMO") || site3TierAlmoFeature == true){ %>
			<a name='assocPkgLink' id='assocPkgLink' href="#" onClick ="pkgSubscriptionWindow()" > Associate Encounter </a>		
		<%}//Ended V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1 %>
		<!--  Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - ends   -->	 
		</td>	
	</tr>
</table>

<input type='hidden' name='strMessageId' id='strMessageId' id='strMessageId' value="" >
<input type='hidden' name='strErrorText' id='strErrorText' id='strErrorText'  value="" >
<input type='hidden' name='alvisitAdmDateHidden' id='alvisitAdmDateHidden' id='alvisitAdmDateHidden' value=''>

<input type='hidden' name='params' id='params' value="<%=params%>" >
<input type='hidden' name='episode_id' id='episode_id' value="" >
<input type='hidden' name='visit_id' id='visit_id' value="" >
<input type='hidden' name='siteParam' id='siteParam' value="<%=siteParam%>" >
<input type='hidden' name='strPackageSeqno' id='strPackageSeqno' value="" >
<input type='hidden' name='function_id' id='function_id' id='function_id' value="<%=function_id%>" >
<input type='hidden' name='facilityId' id='facilityId' value="<%=facility_id%>" >
<input type='hidden' name='selectCheckBoxList' id='selectCheckBoxList' id='selectCheckBoxList' value=''>
<input type='hidden' name='noEncounterToAssociate' id='noEncounterToAssociate' id='noEncounterToAssociate' value='true'>
<input type='hidden' name='siteBLPkgBlngGrpYN' id='siteBLPkgBlngGrpYN' id='siteBLPkgBlngGrpYN' value='<%=siteBLPkgBlngGrpYN%>'>
<!-- add below 2 hidden fields for NMC-JD-CRF-0084 05-02-2021 STARTS-->
<input type='hidden' name='blPkgDepositSubscription' id='blPkgDepositSubscription' value="<%=blPkgDepositSubscription%>" >
<input type='hidden' name='sysdateparam' id='sysdateparam' value="<%=sysDateTime%>" >
<!-- add below 2 hidden fields for NMC-JD-CRF-0084 05-02-2021 EndS-->
</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{
		System.out.println("Exception from Package defintion header :"+e);
		e.printStackTrace();
	}
	finally
	{
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		if(pstmt !=null) pstmt.close();
		if(rs1!=null) rs1.close();//Added by lakshmi against patient id length 
		if(pstmt1 !=null) pstmt1.close();//Added by lakshmi against patient id length
		if(con !=null) ConnectionManager.returnConnection(con, request);
	}
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

