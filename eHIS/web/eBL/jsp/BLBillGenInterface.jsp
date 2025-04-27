<!DOCTYPE html>
<%@page import="eBL.billreceipt.model.BLBillGenInterfaceInBean"%>
<%@ page  import="eBL.*,eBL.Common.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" 			contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@page import="eBL.billreceipt.request.BillReceiptRequest"%>
<%@page import="eBL.billreceipt.bc.BillReceiptBC"%>
<%@page import="eBL.Common.BlRepository"%>
    <!--  By Vijay  -->
<html>

<head>

<%
Connection con=null;
ResultSet rs=null;
PreparedStatement pstmt=null;

String pFacilityId="";
String syDate="";
String curDate="";
String cusId="";
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	
		HttpSession httpSession = request.getSession(false);				
		
		pFacilityId = (String)httpSession.getValue("facility_id");
		String patientId=request.getParameter("patient_id");
		String episodeId=request.getParameter("episode_id");
		String episodeType=request.getParameter("episode_type");
		String	strLoggedUser	=  (String) session.getValue("login_user");	
		String futureYn = request.getParameter("futureYN");
	
		if (strLoggedUser==null) strLoggedUser = "";
		/* System.out.println("logged user "+ strLoggedUser);
		 */
			
		System.out.println("episodeType"+ episodeType);
		String visitId=request.getParameter("visit_id");
		/* System.out.println("visit id "+visitId); */
		
		try
		{
			con	=	ConnectionManager.getConnection(request);	
			
			
			//Getting service Location 
			LinkedHashMap<String,String> serviceLocn = new LinkedHashMap<String,String>();
			BillReceiptRequest brRequest = new BillReceiptRequest();
			brRequest.setLocale(locale);
			brRequest.setFacilityId(pFacilityId);
			
			BillReceiptBC receiptBC = new BillReceiptBC();
			serviceLocn = receiptBC.getServiceLocation(brRequest);
			request.setAttribute("serviceLocn", serviceLocn);
			
			
			//Getting current date 
				curDate=receiptBC.getDate();
			 //System.out.println("curDate "+curDate);
			 
				
			 //Getting date 30 days from current date for All records 
			syDate=receiptBC.getAllRecordsDate();
 			//System.out.println("syDate "+syDate);			
 		
 				//Getting facility details
			LinkedHashMap<String,String> getFacDtls=new LinkedHashMap<String,String>();
 			BLBillGenInterfaceInBean inBean= new BLBillGenInterfaceInBean();
 			inBean.setLoggedUser(strLoggedUser);
 			inBean.setLanguageId(locale);
 			getFacDtls=receiptBC.getFacilityDetails(inBean);
 			request.setAttribute("getFacDtls",getFacDtls);
				
 			//Getting Customer Id 
			cusId=BLReportIdMapper.getCustomerId();
				/* System.out.println("customer Id"+cusId); */
			
			
		
			
			
		}catch(Exception e)
		{
			out.println("Error="+e);
			
		}
		finally
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}

		
		
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javaScript" src='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eBL/js/BLChargePatient.js"></script>
<script language="javascript" src="../../eBL/js/BLBillGenInterfaceJs.js"></script>
<script language="javascript" src="../../eBL/js/BLChargePatientSearch.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<!--<link rel="stylesheet" type="text/css"	href="../../eBL/html/ui.dropdownchecklist.css" />
<link rel="stylesheet" type="text/css" href="../../eBL/html/main.css" />-->
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<!--<script language="javascript" src="../../eBL/js/ui.core.js"></script>
<script language="javascript" src="../../eBL/js/ui.dropdownchecklist.js"></script>-->
<script language="javascript" src="../../eBL/js/AutoFillSearchCriteria.js"></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<script>

$(document).ready(function(){
	$('#tableContainer').hide();
	
	
	var sy_date=$('#sy_date').val();
	var currentdate=$('#cur_date').val();
	var customer_id=$('#site_id').val();
	$('#episode_type').val($('#episodeType').val());
	$('#encounter').val('S');
	$('#patient').val('S');
	$('#patient_no').val($('#patient_id').val());
	$('#episode_id').val($('#episodeId').val());
	$('#visitid').val($('#id_visit').val());
	$('#prmodule').attr('disabled','disabled');
	$('#pr_module').attr('disabled','disabled');
	$('#prmodulelookup').attr('disabled','disabled');
	$('#facility_name').attr('disabled','disabled');
/* if(customer_id=='ALMO')
	{
		$("#criteria option[value='O']").remove();
		$("#criteria option[value='C']").remove();
		$("#criteria option[value='F']").attr('disabled','disabled');
		$("#criteria").val('N');
	}
 else{
	 	$("#criteria option[value='N']").remove();
		$("#criteria option[value='O']").remove();
		$("#criteria option[value='C']").remove();
 	 	$('#criteria').val('F');
 	 }*/
if($('#records').val()=='A')
	{

	//alert('sy_date' + sy_date);
	$('#encounter_from_date').val(sy_date);
	$('#encounter_to_date').val(currentdate);
	
//	alert('from_date'+$('#encounter_from_date').val(sy_date));
	//alert('to_date'+$('#encounter_to_date').val(today));
	}
else
	{
	$('#encounter_from_date').val(currentdate);
	$('#encounter_to_date').val(currentdate);
	}
$('#records').change(function()
	{
	if($('#records').val()=='T')
		{
		$('#encounter_from_date').val(currentdate);
		$('#encounter_to_date').val(currentdate);	
		}
	else
		{
		var sy_date=$('#sy_date').val();
		$('#encounter_from_date').val(sy_date);
		$('#encounter_to_date').val(currentdate);
		}
});

$('#patient').change(function()
		{
	if($('#patient').val()=='S')
		{
		$('#patient_no').removeAttr('readonly');
		$('#patlookup').removeAttr('disabled');
		$('#encounter').removeAttr('disabled');
		$('#encounter').val('A');
		}
	
	else
		{
		//alert('else');
		$('#patient_no').attr('readonly','true');
		$('#patlookup').attr('disabled','disabled');
		$('#patient_no').val('');
		$('#episode_id').val('');
		$('#episodeid').val('');
		$('#visitid').val('');
		
		$('#encounter').attr('disabled','disabled');
		$('#encounter').val('A');
		}
		});
		
$('#modules').change(function(){
	if($('#modules').val()=='A')
		{
		$('#prmodule').attr('disabled','disabled');
		$('#pr_module').attr('disabled','disabled');
		$('#prmodulelookup').attr('disabled','disabled');
		$('#prmodule').val('');
		$('#pr_module').val('');
		}
	else
		{
		$('#prmodule').removeAttr('disabled');
		$('#pr_module').removeAttr('disabled');
		$('#prmodulelookup').removeAttr('disabled');
		}
		
});

$('#episode_type').change(function()
	{	
	if($('#episode_type').val()=='A')
		{
		$('#episode_id').attr('disabled','disabled');
		$('#visitid').attr('disabled','disabled');
		$('#episodeidlookup').attr('disabled','disabled');	
		$('#episode_id').val('');
		$('#episodeid').val('');
		$('#visitid').val('');
		$('#encounter').attr('disabled','disabled');
		}
	else
		{
		$('#episode_id').removeAttr('disabled');
		$('#visitid').removeAttr('disabled');
		$('#episodeidlookup').removeAttr('disabled');
		$('#encounter').removeAttr('disabled');
		}
	
	});
	
frame_call();
});

function frame_call(){
	var indx=$(parent.result_frame.document).find('#bilgeninterface tr:last').attr('data-id');
	var visitid=$('#visitid').val();
	var episode_id=$('#episode_id').val();
	var records=$('#records').val();
	var modules=$('#modules').val();
	var prmodule=$('#prmodule').val();
	var pr_module=$('#pr_module').val();
	//var prkeymain=$('#prkeymain').val();
	var episode_type=$('#episode_type').val();
	var patient=$('#patient').val();
	var patient_no=$('#patient_no').val();
	var encounter=$('#encounter').val();
	var service_location_code=$('#serviceLocation').val();
	var service_location_desc=$("#serviceLocation option:selected").text();
	var encounter_from_date=$('#encounter_from_date').val();
	var encounter_to_date=$('#encounter_to_date').val();
	var module_id=$('#prmodule').val();
	var site_id=$('#site_id').val();
	var futureYn = $('#futureYn').val();
	
	
	if($('#modules').val()=='S'){
		if(module_id ==''){
			alert(getMessage('BL00954','BL'));
			return false;
		}
	}
	parent.dummy_frame.location.href= '../../eCommon/jsp/process.jsp';
var url="../../eBL/jsp/BLBillGenInterfaceSearchResult.jsp?&episode_id="+episode_id+"&visit_id="+visitid+"&records="+records+"&modules="+modules+
"&prmodule="+prmodule+
"&pr_module="+pr_module+
//"&prkeymain="+prkeymain+
"&episode_type="+episode_type+
"&patient="+patient+
"&patient_no="+patient_no+
"&encounter="+encounter+
"&service_location_code="+service_location_code+
"&service_location_desc="+service_location_desc+
"&encounter_from_date="+encounter_from_date+
"&encounter_to_date="+encounter_to_date+
"&module_id="+module_id+
"&site_id="+site_id+
"&futureYn="+futureYn;
parent.result_frame.location.href=url;
//parent.dummy_frame.location.href='../../eCommon/html/blank.html';
}
function process_btn(){
	var indx=$(parent.result_frame.document).find('#bilgeninterface tr:last').attr('data-id');
	
	var dynamicParams="";
	var indx=$(parent.result_frame.document).find('#bilgeninterface tr:last').attr('data-id');
	var facility_id=$('#facilityid').val();
	var locale=$('#locale').val();
	var user_id=$('#strLoggedUser').val();
	var episode_type=$('#episode_type').val();
	var count=0;
	 for (var i=1;i<=indx;i++)
		{

		if($(parent.result_frame.document).find('#selectindividual_'+i).prop("checked"))
			 {	 var check=trimString($(parent.result_frame.document).find('#mod_'+i).text());
				
		dynamicParams+='primarykey_id'+i+'='+$.trim($(parent.result_frame.document).find('#module_'+i).text())+'&'+
						'primarykey_main'+i+'='+$.trim($(parent.result_frame.document).find('#primarykey_'+i).text())+'&'+
						'seckeymoduleid'+i+'='+$.trim($(parent.result_frame.document).find('#mod_'+i).text())+'&'+
						'seckeymain'+i+'='+$.trim($(parent.result_frame.document).find('#secondarykey_'+i).text())+'&'+
						'seckeylineno'+i+'='+$.trim($(parent.result_frame.document).find('#lin_'+i).text())+'&'+
						'pat_id'+i+'='+$.trim($(parent.result_frame.document).find('#patId_'+i).val())+'&'+
						'epiid'+i+'='+$.trim($(parent.result_frame.document).find('#epiId_'+i).val())+'&'+
						'vis_id'+i+'='+$.trim($(parent.result_frame.document).find('#visId_'+i).val())+'&';
	
					
		count++;
	}			
		}
	 
	 if(count<1)
		{
		
		alert(getMessage('BL1259','BL'));
		 return ;
		}
		 $.ajax({
		 	
		 	type:'POST',
		 	url:"../../servlet/eBL.BLBillGenInterfaceServlet?indx="+indx+"&facility_id="+facility_id+"&locale="+locale+"&user_id="+user_id+"&episode_type="+episode_type,
		 	data:dynamicParams,
		 	async:false,
		 	success:function(data){
		 		if(data.Success=='N')
		 			{
		 		alert(data.error);
		 			}
		 		else
		 			{
		 			$(parent.parent.BillReceiptTab.document).find('#billCumReceipt').click();
					$(parent.parent.BillReceiptTab.document).find('#billCumReceipt').addClass('CASECONDSELECTHORZ');
		 			}
		 		}
		 });
}
</script>
</head>
<body>
<form name='billinterface' id='billinterface'  id='billinterface'>
<div id="tableContainer">
<table>	
<tr>
<td class="label" width="2%"><fmt:message key="Common.facility.label"	bundle="${common_labels}"/> </td>
<td width="16%" class="fields">
		<select name='facility_name' id='facility_name' id='facility_name' style="width: 200px;">
						<!-- 	<option value=''>All </option> -->
							<c:forEach var="facDtls" items="${getFacDtls }">      						
      							<option value="${facDtls.key }">${facDtls.value } </option>
      						</c:forEach>						
      					</select>	</td>

</tr>
</table>


<table>

<tr>	
		 <td class="label" width="2%"><fmt:message key="eBL.records.label"	bundle="${bl_labels}"/></td>	 
		<td width="5%" class="fields">		
		 <select name='records' id='records'id='records' style="width: 120px;" >
		 <option value='A'>All Records</option>
						
							-------
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							-------
						</option>
								<option value='T'>Todays Records</option>
						</option>
				</select></td>
		
		<td class="label" width="2%"><fmt:message key="eBL.modules.label"	bundle="${bl_labels}"/>
		</td>
		 <td id="" width='5%' class="fields">
		 <select name='modules' id='modules'id='modules'  style="width: 140px;">
		 <option value='A'>All Modules</option>
						
							-------
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							-------
						</option>
								<option value='S'>Specific Module</option>
						</option>
				</select></td>
		 
	 	 		 	
		 		 <td class="label" width="3%"><fmt:message key="eBL.prmodule.label"	bundle="${bl_labels}"/>
		</td>
		<td class="fields" width="2%"><input type='text' name='prmodule' id='prmodule' id='prmodule' size='03' maxlength='22'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(pr_module,prmodule,1,1);} else { fnClearCode(pr_module);}">
		<input type='text' name='pr_module' id='pr_module' id='pr_module' size='05' maxlength='22'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(pr_module,prmodule,1,2);} else { fnClearCode(prmodule);}">
		<input type='button' class='button' id='prmodulelookup' name='prmodulelookup' id='prmodulelookup' value='?' onClick="callCommonLookupCode(pr_module,prmodule,1,2);" tabindex='2'>
		
		</td> 	
		 <td class="label" width="3%"><fmt:message key="eBL.servicelocation.label"bundle="${bl_labels}"/>
		</td>
		 <td id="" width='3%' class="fields">
		<select name='serviceLocation' id='serviceLocation' id='serviceLocation' style="width: 175px;">
							<option value=''> </option>
							<c:forEach var="serviceLoc" items="${serviceLocn }">      						
      							<option value="${serviceLoc.key }">${serviceLoc.value } </option>
      						</c:forEach>						
      					</select>
    
      					</td>
									
		
		</tr>
	
	<tr>
	 	 	
		
		 <td class="label" width="2%"><fmt:message key="Common.patient.label"	bundle="${common_labels}"/>
		</td>								
	
		 <td id="" width='5%' class="fields">
		 <select name='patient' id='patient'id='patient' style="width: 120px;" >
		 <option value='A'>All Patients</option>
						
							-------
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							-------
						</option>
								<option value='S'>Specific Patient</option>
						</option>
				</select></td>	
	
	 <td class="label" width="4%"><fmt:message key="eBL.patientno.label" bundle="${bl_labels}"/>
		</td>								
		<td class="fields" width="4%"><input type='text' name='patient_no' id='patient_no' id='patient_no' size='20' maxlength='22'  value=''  onBlur=" "><input type='button'
					class='button' name='patlookup' id='patlookup' id='patlookup' value='?'
					onClick="return getPatID()" tabindex='2'>
		
		</td> 
		<td class="label" width="5%"><fmt:message
		key="eBL.chargedate.label" bundle="${common_labels}" /></td>
					
				<td width='5%' class="fields"><input type='text'
					name='encounter_from_date' id='encounter_from_date' id="encounter_from_date" size='15' maxlength='30'
					value=''
					onBlur='isValidDateTime(encounter_from_date);'  >
					<img src="../../eCommon/images/CommonCalendar.gif"
					onClick="return showCalendar('encounter_from_date','dd/mm/yyyy','hh:mm:ss');"/> </td>
					
					
<td class="label" width="5%"><fmt:message
							key="eBL.tochargedate.label" bundle="${common_labels}" /></td>
				<td width='5%' class="fields"><input type='text'
					name='encounter_to_date' id='encounter_to_date' id='encounter_to_date' size='25' maxlength='30' value=''
					onBlur='isValidDateTime(encounter_to_date);'>
					<img src="../../eCommon/images/CommonCalendar.gif"
					onClick="return showCalendar('encounter_to_date','dd/mm/yyyy','hh:mm:ss');"/>
					</td>									
		
	</tr>
<tr>
	 <td class="label" width="5%"><fmt:message key="Common.EpisodeType.label"	bundle="${common_labels}"/>
		</td>
 <td id="" width='3%' class="fields">
		<select id="episode_type" name='episode_type' id='episode_type'  style="width: 120px;" >
						<option value='A'>
							
							<fmt:message key="Common.all.label" bundle="${common_labels}" />
						
						</option>
						<option value='D'>
							<fmt:message key="Common.daycare.label" bundle="${common_labels}" />
						</option>
						<option value='E'>
							<fmt:message key="Common.emergency.label"
								bundle="${common_labels}" />
						</option>
						<option value='I'>
							<fmt:message key="Common.inpatient.label"
								bundle="${common_labels}" />
						</option>
						<option value='O'>
							<fmt:message key="Common.Outpatient.label"
								bundle="${common_labels}" />
						</option>
						<option value='R'>
							<fmt:message key="Common.referral.label"
								bundle="${common_labels}" />
						</option>
				</select></td>
 		 <td class="label" width="2%"><fmt:message key="Common.encounter.label"	bundle="${common_labels}"/>
		</td>
		 <td id="" width='3%' class="fields">
		<select id="encounter" name='encounter' id='encounter' style="width: 140px;" >
								<option value='A'>All Encounter</option>
		
							-------
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							-------
						</option>
								<option value='S'>Specific Encounter</option>
						</option>
			</select></td>
	
		 <td class="label" width="2%"><fmt:message key="Common.episodeid.label"	bundle="${common_labels}"/>
		</td>								
	
	
	 	<td class="fields" width="5%"><input type='text' name='episode_id' id='episode_id' id='episode_id' size='05' maxlength='22'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(visitid,episode_id,2,1);} else { fnClearCode(visitid);} ">
	 	<input type='text' name='visitid' id='visitid' id='visitid' size='03' maxlength='22'  value=''  onBlur="if(this.value!=''){ callCommonLookupCode(visitid,episode_id,2,2);} else { fnClearCode(episode_id);} ">
		<input type='button' class='button' id='episodeidlookup' name='episodeidlookup' id='episodeidlookup' value='?' onClick="callCommonLookupCode(visitid,episode_id,2,2);" tabindex='2'>
		</td> 			
		
      					<td width="10%">
		<INPUT TYPE='button' name='search' id='search' id='search' class="BUTTON" VALUE="Search" size='5' onClick='frame_call();'>
		

							

	
</tr>	

</table>	
</div>	
<table  width="100%">

<tr>
<td>
</td>
<td>
</td>
<td>
</td>
<td>
</td>
<td>
</td>
<td>
</td>
	<td width=5%>	<INPUT TYPE='button' name='clear' id='clear' id='clear' class="BUTTON" VALUE="Reset" size='5' onClick='clear_fields();'></td>
<td   align="right"   width="8%"><INPUT TYPE='button' name='process' id='process' id='process' class="BUTTON" VALUE="Process" size='5' onClick='process_btn();'></td>
	</tr>
	</table>
	<input type='hidden' name='locale' id='locale' id='locale' value="<%=locale %>">
	<input type='hidden' name='sy_date' id='sy_date' id='sy_date' value="<%=syDate %>">
	<input type='hidden' name='cur_date' id='cur_date' id='cur_date' value="<%=curDate %>">
	<input type='hidden' name='patient_id' id='patient_id' id='patient_id' value="<%=patientId %>">
	<input type='hidden' name='episodeId' id='episodeId' id='episodeId' value="<%=episodeId %>">
	<input type='hidden' name='id_visit' id='id_visit' id='id_visit' value="<%=visitId %>">
	<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value="<%=episodeType %>">
	<input type='hidden' name='facilityid' id='facilityid' id='facilityid' value="<%=pFacilityId %>">
	<input type='hidden' name='strLoggedUser' id='strLoggedUser' id='strLoggedUser' value="<%=strLoggedUser %>">
	<input type='hidden' name='site_id' id='site_id' id='site_id' value="<%=cusId %>">
	<input type='hidden' name='todayDate' id='todayDate' id='todayDate' value=''>
	<input type='hidden' name='servlocdesc' id='servlocdesc' id='servlocdesc' value=" ">
	<input type='hidden' name='futureYn' id='futureYn' id='futureYn' value="<%=futureYn%>">


</form>
</body>
</html>

