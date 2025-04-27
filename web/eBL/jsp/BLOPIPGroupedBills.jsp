
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            New File            14520        MOHE-CRF-0075.1           Shikha Seth
2			 V210427			 14170		  MOHE-CRF-0075				Mohana Priya K
3			 V210511			 18503		  BL-MOHE-CRF-0075-
											OP/IP Grouped Bills- 3T     Mohana Priya K
4            V210723             20377        MOHE-CRF-0110				MuthuN/Nandhini M
5            V210823             23103        MOHE-SCF-0144				MuthuN
6  			 V211020											        Mohanapriya K
-----------------------------------------------------------------------------------
-->

<%@page import="java.sql.Date"%>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %><!-- V210823 --> 
<%@ page import ="eBL.*,eBL.Common.*,eBL.resources.*,java.sql.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eBL.*"   %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

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
<script language="JavaScript" src="../../eBL/js/BLOPIPGroupedBills.js"></script> 
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script type="text/javascript">
	$(document).ready(function(){   
		 $('#facilityid').val($('#facility_id').val()) ;         
		 getFacility('',$('#facilityid').val(),1);        
	 });
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function processScroll(){
	if (headTop < 0)
	{
		saveHeadPos();
	}
	if (headTop>0)
	{
		if (document.documentElement && document.documentElement.scrollTop)
			theTop = document.documentElement.scrollTop;
		else if (document.body)
			theTop = document.body.scrollTop;

		if (theTop>headTop)
			FloatHead1.style.top = (theTop-headTop) + 'px';
		else
			FloatHead1.style.top = '0px';
	}
}

function primaryPatValidation(obj)
{
	var patient_id=obj.value;	
	if(patient_id!=""){
		var function_id = "PAT_CHK";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;					
		xmlStr +=" /></root>";
		var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id="+function_id;					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);		
		if(responseText=="N")
		{
			alert(getMessage("INVALID_PATIENT","MP"));
			obj.select();
		}else if(responseText=="Y"){
			LoadPatientName(patient_id);
		}
	}
}

async function PatientIdLookup()
{	
	var pat_id=await PatientSearch();		
	if( pat_id != null )						
	document.getElementById('patient_id').value = pat_id ;
	if(pat_id!=undefined && pat_id!='')
	{
		LoadPatientName(pat_id);
		ChangeUpperCase(document.getElementById("patient_name"));
	}
}	

function LoadPatientName(pat_id)
{	
	var out;
	var response;
	var xmlhttp;    
	if (window.XMLHttpRequest) 
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		//xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		xmlHttp = new XMLHttpRequest();
	}
		xmlhttp.onreadystatechange=function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
		out = xmlhttp.responseText;
		var showdata = out.substring(out.indexOf("!")+1,out.length);
		response=showdata.split(":");
		var actual;
		for(var i=0;i<response.length;i++)
		{
			document.getElementById("patient_name").value = response[i];		
		}
			ChangeUpperCase(document.getElementById("patient_name"));
	}
	}
		xmlhttp.open("POST","../../eBL/jsp/BillingRecordApprovalGetPatienName.jsp?patientId="+pat_id,true);
		xmlhttp.send(null);
}		

function saveHeadPos(){
	parTable = document.getElementById("divHeadSep");
	if (parTable != null)
	{
		headTop = parTable.offsetTop + 3;
		FloatHead1 = document.getElementById("heading");
		FloatHead1.style.position = "relative";
	}
}

function lockbackSpace(){
	var mode = document.mode.value;
	if(mode=='modify' && window.event.keyCode==8)
	{
		//return false;
	}
}
</script>

</head>
<style>
	thead td, thead td.locked { 
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
<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String applyMode	=	new String();
	String locale		=	"";
	String p_user_name	= (String) session.getValue( "login_user" );
	String mode			=	"";
	String isUserCanAcess	=	"";
	Connection con = null;
	ResultSet rst = null;
	ResultSet rst2 = null;
	ResultSet rst3 = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	String facility_id = (String)session.getAttribute("facility_id");	

	int defaultDate = 1;
	String restrictDate = "";
	String sql="";
	int pat_id_len = 0;

	try
	{
		con = ConnectionManager.getConnection();
		sql ="select patient_id_length from mp_param";

		pstmt = con.prepareStatement(sql);
		rst = pstmt.executeQuery();

		if (rst != null && rst.next() )
		{
			pat_id_len = rst.getInt("patient_id_length") ;
		}
		} catch(Exception e) {
			pat_id_len = 15;//Setting Default Value if exception occured
			out.println(e.toString());
			e.printStackTrace();
		}
	finally 
	{
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(rst != null) {
				rst.close();
			}
			// ConnectionManager.returnConnection(con); //V211020
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	try{
			//con = ConnectionManager.getConnection();//V211020
			pstmt = con.prepareStatement("Select REC_APPRVL_DATE_DEFLT, REC_APPRVL_DATE_RESTRCT from bl_parameters");
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					defaultDate = rst.getInt("REC_APPRVL_DATE_DEFLT");
					restrictDate = rst.getString("REC_APPRVL_DATE_RESTRCT");			
					
					if(defaultDate == 0){
						defaultDate = 1;
					}
					
					if(restrictDate == null || "null".equals(restrictDate)){
						restrictDate = "";
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in getting days params from BL Parameter - >"+e);
			defaultDate = 1;
			restrictDate = "";
		} finally{
			pstmt = null;
			rst = null;
			ConnectionManager.returnConnection(con);
		}
	
	try  
	{		 
		locale  = 	(String)session.getAttribute("LOCALE");
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		String todaysDate=dateFormat.format(cal.getTime());
		String BilltodaysDate=dateFormat.format(cal.getTime());//added by nandhini
		cal.add(Calendar.DATE, -(defaultDate-1)); 
		String sevenDaysBeforeDate=dateFormat.format(cal.getTime());
		String BillsevenDaysBeforeDate=dateFormat.format(cal.getTime());//added by nandhini
%>

<BODY onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" style="padding-left:10px;padding-right:10px;padding-top:5px;">
 <form name="BLOPIPGroupedBills" id="BLOPIPGroupedBills" id="BLOPIPGroupedBills"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<TABLE width="100%" CELLSPACING='0' cellpadding='3' align="center" >
<tr>
	<td  class="columnheader" ><fmt:message key="eBL.ReportCriteria.label" bundle="${bl_labels}"/> </td>
</tr>	
</TABLE>
<br>
<TABLE width="100%" CELLSPACING='0' cellpadding='3' align="center" >	
	<tr>	
		<td width='10%' class='label'><fmt:message key="eBL.Facility.label" bundle="${bl_labels}"/></td>			
			<td class="fields" >
				<input type='text' name='facilityidName' id='facilityidName' id='facilityidName' size='20' maxlength='40' value=''  onblur='if(this.value!=""){ getFacility(facilityidName,facilityid,2) } else{ clearCode(facilityid); } '/>
				<input type='hidden' name='facilityid' id='facilityid' id='facilityid' value=''>
				<input type='button' class='button' name="facilityid_btn" id="facilityid_btn" value='?' onClick="getFacility(facilityidName,facilityid,2)" tabindex='2'>				
			&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type="text" name="patient_id" id="patient_id" id="patient_id" 		maxlength="<%=pat_id_len %>" onBlur="ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == ''){ patient_name.value=''; return PatientIdLookup(); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return PatientIdLookup()"     tabindex='2' />&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td class="label" ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>				
					<td><input type="text" name="patient_name" id="patient_name" id="patient_name"    maxlength="100"  onBlur="ChangeUpperCase( this );"     onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onfocus="ChangeUpperCase( this );" >							
				</td>				
				</tr>
				<tr>
				<td  class='label'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}" /></td>
				<td class='fields'>
				<select id="episode_type" name='episode_type' id='episode_type' >
					<option value='O'>
							<fmt:message key="Common.Outpatient.label"
								bundle="${common_labels}" />
					</option>
					<option value='I'>
							<fmt:message key="Common.inpatient.label"
								bundle="${common_labels}" />
					</option>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
			</td>
			<td class="label" ><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/> 
				<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td class='fields' >
					<input type='text' name="Effective_from" id="Effective_from" id="Effective_from" maxlength="10"  onBlur="isValidDate(this)" value="<%=sevenDaysBeforeDate%>">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_from');"  onKeyPress="return lockbackSpace();">					
				</td>
				<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td >
					<input type='text' name="Effective_to" id="Effective_to" id="Effective_to" maxlength="10" onBlur="isValidDate(this)" value="<%=todaysDate%>">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_to');"  onKeyPress="return lockbackSpace();">					
				</td>
				</tr>
				<tr>
				
				<td class="label" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class="fields">
					<input type="text" name="encounter_id" id="encounter_id" id="encounter_id"   maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){enCounterIdLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
					<input type='button' class='button' name="encounterbut" id="encounterbut" value='?' onClick="return enCounterIdLookup()"  tabindex='2'>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<!-- Added by Nandhini against V210723 Starts -->
			<td class="label" >
				<fmt:message key="eBL.FromBillDate.label" bundle="${bl_labels}"/> 
			</td>
			<td class='fields' >
				<input type='text' name="BillEffective_from" id="BillEffective_from" id="BillEffective_from" maxlength="10"  onBlur="isValidDate(this)" value="<%=BillsevenDaysBeforeDate%>">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('BillEffective_from');"  onKeyPress="return lockbackSpace();">		
			</td>
			<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td >
				<input type='text' name="BillEffective_to" id="BillEffective_to" id="BillEffective_to" maxlength="10" onBlur="isValidDate(this)" value="<%=BilltodaysDate%>">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('BillEffective_to');"  onKeyPress="return lockbackSpace();">		
			</td>
			<!-- Added by Nandhini V210723 Ends -->
			</tr>
			<tr>
	<!--V210511 Starts-->
				<td  class='label'><fmt:message key="Common.Language.label" bundle="${common_labels}" /></td>
				<td class='fields'>
				<select id="language_id" name='language_id' id='language_id' >
						<option value='ar'>
							<fmt:message key="eBL.Arabic.Label"
								bundle="${bl_labels}" />
						</option>
						<option value='en'>
							<fmt:message key="Common.English.label"
								bundle="${common_labels}" />
						</option>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
			</td> <!--V210511 Ends-->				
	</tr>	
	</table>		
		
	<input type='hidden' name='locale' id='locale'	id='locale'	value="<%=locale%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id"	value="BL"	>
	<input type="hidden" name="p_report_idOP" id="p_report_idOP" id="p_report_idOP"	value="BLOPBILL" >
	<input type="hidden" name="p_report_idIP" id="p_report_idIP" id="p_report_idIP"	value="BLIPBILL" >
	<input type="hidden" name="p_report_idOP_EN" id="p_report_idOP_EN" id="p_report_idOP_EN"	value="BLOPBILL_EN" > <!-- V210427 -->
	<input type="hidden" name="p_report_idIP_EN" id="p_report_idIP_EN" id="p_report_idIP_EN"	value="BLIPBILL_EN" > <!-- V210427 -->
	<input type="hidden" name="pgm_id" id="pgm_id"	id="pgm_id"	value=""	> 		
	<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facility_id%>"	>
	<input type="hidden" name="p_user_name" id="p_user_name" value="<%=p_user_name%>">	
	<input type="hidden" name="p_session_id" id="p_session_id" value="">	
	<input type='hidden' name='noOfCols' id='noOfCols' value=''>	
</form>
</BODY>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in BLCollectSumryReport.jsp::"+e);
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
</HTML>

