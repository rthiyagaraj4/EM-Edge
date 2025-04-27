<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con 			= null;
	Statement  stmt			= null;
	ResultSet  rs 			= null;
	ResultSet rset	= null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String function_id							= checkForNull(request.getParameter("function_id"));
		String function_name						= checkForNull(request.getParameter("function_name"));
		String wherecondn							= checkForNull(request.getParameter("wherecondn"));
		String operstn								= checkForNull(request.getParameter("oper_stn_id"));
		String call_function						= checkForNull(request.getParameter("call_function"));
		String facilityID							= (String)session.getValue("facility_id");
		String loginUser							= (String)session.getValue("login_user");
		String practitioner_id						= checkForNull(request.getParameter("practitioner_id"));
		String encounterID_repDischargeAdvice		= checkForNull(request.getParameter("encounter_id"));
		String bl_install_yn						= checkForNull(request.getParameter("bl_install_yn"));
		String p_called_from_ca						= checkForNull(request.getParameter("p_called_from_ca"));
		String systemdate	= "";
		String patient_id_length	= "";
	
		StringBuffer sbSql							= new StringBuffer();
		sbSql.append(" select a.oper_stn_id oper_stn_id,a.routine_tfr_yn, to_char(sysdate,'dd/mm/rrrr') systemdate,(select patient_id_length  from mp_param where  module_id = 'MP' )patient_id_length from am_oper_stn a, am_user_for_oper_stn b 	   ");
		sbSql.append(" where a.facility_id='"+facilityID+"' and a.facility_id=b.facility_id	   ");
		sbSql.append(" and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"'   ");
		sbSql.append( " and trunc(sysdate) between b.eff_date_from and ");
		sbSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sbSql.toString());
		
		if(rs!=null)
		{
			while(rs.next())
			{
				systemdate		= checkForNull(rs.getString("systemdate"));
				if(!(systemdate==null || systemdate.equals("")))
				operstn			= checkForNull(rs.getString("oper_stn_id"));
				patient_id_length	= checkForNull(rs.getString("patient_id_length"));
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
	 	
	%>

<head>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<Script src="../../eIP/js/IPLookup.js" language="JavaScript"></Script>
	<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
	<Script src="../../eIP/js/IPPractitionerComponent.js" language="JavaScript"></Script>	
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Supporting Js File For Fixed Header with scroll.... -->
	<style type="text/css">
		table.mt {border-width: 1px;border-spacing:0px ;border-collapse: collapse;}
		table.mt th {border-width: 1px;padding: 1px;;white-space: normal; text-align:left;word-wrap:normal;}
		table.mt td {border-width: 1px;padding: 1px;text-align: left;vertical-align:middle;white-space:normal;word-wrap: break-word; word-break: break-all;}
		table td {padding:2px;}
	</style>
<script>
		// below code is added for the 17600 end  Wednesday, December 23, 2009
		function clearResultpage()
		{
			parent.frames[2].location.href ='../../eCommon/html/blank.html';
		}

// Added by Sridhar on Jan 3rd 2006...
// This Function will check for empty values before calling up the common lookup func..
function BeforeGetPractitioner(obj, target, details)
{
	if(details == 'from')
	{
		if(document.forms[0].from_practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].from_practid.value =""
	}
	else
	{
		if(document.forms[0].practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].practid.value =""
	}

}
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)	{
		arr=retVal.split("~");
		document.forms[0].practid.value=arr[0];
		document.forms[0].practid_desc.value=arr[1];			
		
	}
	else{
		document.forms[0].practid.value="";
		document.forms[0].practid_desc.value="";			
	
	}
}

// By Annadurai 2/6/2004 ., to use Common Lookup. starts.,
function getPractitionerLocal(obj, target, details)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";

	practName_FName=target.name;
	practName_FValue=target.value;
	if(details == 'from')
		practId_FName=document.forms[0].from_practid.name;
	else
		practId_FName=document.forms[0].practid.name;

	var facility_id		= "<%=facilityID%>";
	var locale			= "<%=locale%>";
		getPractitioner(obj, target, facility_id, "","","Q3");

} // End of getToPractitioner.

function submitPage(){
	$("[name=search]").attr("disabled",true);
	var nursing_unit	= $("#nursing_unit").val();
	var dis_date_from	= $("#dis_date_from").val();
	var dis_date_to		= $("#dis_date_to").val();
	var Splcode			= $("#Splcode").val();
	var practid			= $("#practid").val();
	var patient_id		= $("[name=patient_id]").val();
	var encounter_id	= $("#encounter_id").val();
	var oper_stn_id		= $("#oper_stn_id").val();
	var p_called_from_ca	= $("#p_called_from_ca1").val();
	if(nursing_unit=="" && dis_date_from=="" && dis_date_to=="" && Splcode=="" && practid=="" && patient_id=="" && encounter_id==""){
		 alert(getMessage('ATLEAST_ONE_VALUE','IP'));
		 $("[name=search]").attr("disabled",false);
		 return;
	}

	$.ajax({  
	     url:'../../eIP/jsp/getdetailsIP.jsp',  
	     type:'post',  
	     data:{'action':'initiate_pre_discharge','nursing_unit':nursing_unit,'dis_date_from':dis_date_from,'dis_date_to':dis_date_to,'Splcode':Splcode,'practid':practid,'patient_id':patient_id,'encounter_id':encounter_id,'oper_stn_id':oper_stn_id},
	     dataType: 'json',
	     success: function(data) {
	       	 $("[name=search]").attr("disabled",false);
	    	 var ResultString			= "";
	    	 var recordlist				= "";
	    	 var res_header_spec_pract	= ""
	    	 var class_name				= "";
	    	 var passvalue				= "";
	    	 if(data.rowcnt > 0){
	    		recordlist		= eval(data.recordslist);
	    		ResultString	+= "<form name='InitiatePreDischargeResult' id='InitiatePreDischargeResult' id='InitiatePreDischargeResult'  method='post' action='../../servlet/eIP.InitiatePreDischargeServlet'>";
	    		ResultString	+= "<table border='1' width='99%' style='border-spacing:0px ;border-collapse: collapse;' id='dataTable' class='mt'>";
	    		ResultString	+= "<tr>";
	    		ResultString	+=    "<th>&nbsp;</th>";
	    		ResultString	+=    "<th>"+getLabel('Common.AdmissionDateTime.label','Common')+"</th>";
	    		ResultString	+=    "<th>"+getLabel('Common.encounterid.label','Common')+"</th>";
	    		ResultString	+=    "<th>"+getLabel('Common.patientId.label','Common')+"</th>";
	    		ResultString	+=    "<th>"+getLabel('Common.PatientName.label','Common')+"</th>";
	    		ResultString	+=    "<th>"+getLabel('Common.gender.label','Common')+"</th>";
	    		ResultString	+=    "<th>"+getLabel('Common.nursingUnit.label','Common')+"</th>";
	    		ResultString	+=    "<th>"+getLabel('Common.bedno.label','Common')+"</th>";
	    		ResultString	+=    "<th>"+getLabel('Common.roomno.label','Common')+"</th>";
	    		ResultString	+=    "<th>"+getLabel('Common.currentlocation.label','Common')+"</th>";
	    		ResultString	+=    "<th width='8%'> "+getLabel('eIP.PreDischargeInitiated.label','eIP')+"</th>";
				ResultString	+= "</tr>";
				var pre_dis_checked		= "";
				var existing_pat_id		= "";
				$.each(recordlist,function(index,value){
					class_name			= value.classValue;
					passvalue			= value.encounter_id+"~"+value.patient_id;
					
					if(res_header_spec_pract!=value.res_header_spec_pract){
						ResultString	+= "<tr><td colspan='13'  class='CAGROUPHEADING' >"+value.res_header_spec_pract+"</td></tr>";
					}
					if(value.pre_dis_initiate_yn=='Y'){
						pre_dis_checked	= "checked";
						existing_pat_id		+= passvalue+"|";
					}else{
						pre_dis_checked	= "";
					}
					ResultString		+= "<tr>";
					ResultString		+= 		"<td class='"+class_name+"'><a href='javascript:closeWin(\""+value.encounter_id+"\",\""+value.patient_id+"\")'>+</a></td>";
					ResultString		+= 		"<td class='"+class_name+"'>"+value.admission_date_time+"</td>";
					ResultString		+= 		"<td class='"+class_name+"'>"+value.encounter_id+"</td>";
					ResultString		+= 		"<td class='"+class_name+"'>"+value.patient_id+"</td>";
					ResultString		+= 		"<td class='"+class_name+"' width='100px;'>"+value.patient_name+"</td>";
					ResultString		+= 		"<td class='"+class_name+"'>"+value.gender+"</td>";
					ResultString		+= 		"<td class='"+class_name+"'>"+value.nursing_unit_short_desc+"</td>";
					ResultString		+= 		"<td class='"+class_name+"'>"+value.bed_no+"</td>";
					ResultString		+= 		"<td class='"+class_name+"'>"+value.room_no+"</td>";
					ResultString		+= 		"<td class='"+class_name+"'>"+value.location_desc+"</td>";
					ResultString		+= 		"<td class='"+class_name+"' width='8%'><input type='checkbox' name='checkbox' id='checkbox' id='checkbox' value=\""+passvalue+"\" "+pre_dis_checked+" /></td>";
					ResultString		+= "</tr>";
					res_header_spec_pract	= value.res_header_spec_pract;
				});
				ResultString	+= "</table>";
				if(existing_pat_id!=""){
					existing_pat_id	= existing_pat_id.slice(0,-1);
				}
				
				ResultString	+= "<input type='hidden' name='existing_pat_id' id='existing_pat_id' id='existing_pat_id' value='"+existing_pat_id+"'/>";
				ResultString	+= "<input type='hidden' name='selectedpat_id' id='selectedpat_id' id='selectedpat_id'/>";
				ResultString	+= "<input type='hidden' name='selectedenc_id' id='selectedenc_id' id='selectedenc_id' />";
				ResultString	+= "<input type='hidden' name='mode' id='mode' id='mode' value='update' />";
				ResultString	+= "<input type='hidden' name='p_called_from_ca' id='p_called_from_ca' id='p_called_from_ca' value='"+p_called_from_ca+"' />";
				// For Update on form submit hidden fields start
				ResultString	+= "<input type='hidden' name='res_nursing_unit' id='res_nursing_unit' id='res_nursing_unit' value='"+nursing_unit+"' />";
				ResultString	+= "<input type='hidden' name='res_dis_date_from' id='res_dis_date_from' id='res_dis_date_from' value='"+dis_date_from+"' />";
				ResultString	+= "<input type='hidden' name='res_dis_date_to' id='res_dis_date_to' id='res_dis_date_to' value='"+dis_date_to+"' />";
				ResultString	+= "<input type='hidden' name='res_Splcode' id='res_Splcode' id='res_Splcode' value='"+Splcode+"' />";
				ResultString	+= "<input type='hidden' name='res_practid' id='res_practid' id='res_practid' value='"+practid+"' />";
				ResultString	+= "<input type='hidden' name='res_patient_id' id='res_patient_id' id='res_patient_id' value='"+patient_id+"' />";
				ResultString	+= "<input type='hidden' name='res_encounter_id' id='res_encounter_id' id='res_encounter_id' value='"+encounter_id+"' />";				
				
				// For Update on form submit hidden fields end

				ResultString	+= "</form>"; 
				$("#divresultlist").html(ResultString);

				
				if($("#dataTable").length > 0){
					var height=420;
					if(p_called_from_ca=='Y'){
						height=360;
					}
		    		fxheaderInit('dataTable',height);	
		    	}
	    	 }else{
	    		 alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
	    		 $("#divresultlist").html("");
	      	 }
		 } ,
	     error: function(jqXHR, textStatus, errorThrown) {
	         alert("incoming Text " + jqXHR.responseText);
	     }
 	});  
	/*Below line added fro this CRF GHL-CRF-0468*/
	if(parent.messageFrame){
      	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}		
	//End this CRF GHL-CRF-0468	

}

	
	
	function FnReset(value){
		if(value=='all'){
			document.forms[0].reset();
		}
		
		if(parent.messageFrame)
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		$("#divresultlist").html("");
		document.forms[0].search.disabled=false;
	}
	
	function FnGetCheckdValues(){
		var VarCheckedValues	= "";
		$("input[name='checkbox']").filter(':checked').each(function() {
			VarCheckedValues+=$(this).val()+"|";
		});
		if(VarCheckedValues!=''){
			VarCheckedValues	= VarCheckedValues.slice(0,-1);
		}
		return VarCheckedValues;
	}
	function FnApply(){
		var VarCheckedValues=FnGetCheckdValues();
		
		var IsError			= 0;
		var existing_pat_id = $("#existing_pat_id").val();	
		var encids_patids	= "";
		var enc_ids_grp		= "";
		var pat_ids_grp		= "";
		var AllIds			= '';		
		if(existing_pat_id!=VarCheckedValues){
			if(VarCheckedValues!=""){
				AllIds			= VarCheckedValues.split("|");
			}
			if(AllIds!=""){
				$.each(AllIds,function(index,value){
					encids_patids	= value.split("~");
					enc_ids_grp		+= encids_patids[0]+"|#|";
					pat_ids_grp		+= encids_patids[1]+"|#|";					
										
				});
			}
			
			
				$("#selectedpat_id").val(pat_ids_grp);
				$("#selectedenc_id").val(enc_ids_grp);
				$("#InitiatePreDischargeResult").submit();			
			
		
		}else{
			var error_id=getMessage("NO_CHANGE_TO_SAVE","common");
			parent.frames[1].location.href ='../../eIP/jsp/InitiatePreDischargeCriteria.jsp';
			parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+ error_id;
		}
	}
	

</script>
</head>
	<body onSelect="codeArrestThruSelect();" onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="FocusFirstElement();//checkForMPRequest();">
		<form name='Inpatientlookup_Form' id='Inpatientlookup_Form' action='../../eIP/jsp/BookingReferenceLookupResult.jsp' target='result' >
			<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
				<tr>
					<td class='label' width='25%' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'><input type=text name="nursing_unit_desc" id="nursing_unit_desc" size=15 maxlength='15' onblur="BeforeGetNursingUnit(this, '<%=facilityID%>','to');"><input type=hidden  name="nursing_unit" id="nursing_unit" id="nursing_unit" size=15 ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="getNursingUnitValue(nursing_unit_desc, '<%=facilityID%>','to');" ></td>
					<td class='label' width='25%' nowrap><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
					<td class='fields' width='25%'  nowrap><input type='text' id="dis_date_from" maxlength='10' size='10' name='from_date' id='from_date'  value="" onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].dis_date_from.focus();return showCalendar('dis_date_from');"> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="dis_date_to" value="" maxlength='10' size='10' name='to_date' id='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].dis_date_to.focus();return showCalendar('dis_date_to',null);"></td>
				</tr>
				<tr>
					<td  class='label' width='25%' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'  nowrap><input type=text name=specialty_desc size=15 maxlength='15' onblur="BeforeGetSpecialtyValue(this, '<%=facilityID%>','to');"><input type=hidden class=label name=Splcode id="Splcode" size=15 readonly><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick="getSpecialtyValue(specialty_desc, '<%=facilityID%>','to');"></td>
					<td  class='label' width='25%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'  nowrap><input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid,practid_desc,'to');" value=""><input type='hidden' name='practid' id='practid' id="practid" value="" size="15" maxlength="15" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid, practid_desc,'to');"></td>
				</tr>
				<tr>
					<td class='label' width='25%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'  nowrap><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' id="encounter_id" onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this);"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan=6 style="margin-left:-5px;">
						<jsp:include page="IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id_length"  value="<%=patient_id_length%>" /></jsp:include>
					</td>
				</tr>
			</table>	
	<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
		<tr>
			<td width = "75%" class='white' >&nbsp;</td>
			<td width = "25%" class='white' align="right"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='FnReset("clearresult")'>

			</td>
		</tr>
	</table>

	<input type='hidden' name='operstn' id='operstn' value="<%=operstn%>" >
	<input type='hidden' name='wherecondn' id='wherecondn' value="<%=wherecondn%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>" >
	<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
	<input type='hidden' name='bl_install' id='bl_install' value="<%=bl_install_yn%>" >
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' id='oper_stn_id' value="<%=operstn%>" >
	<input type='hidden' name='p_called_from_ca1' id='p_called_from_ca1' id='p_called_from_ca1' value="<%=p_called_from_ca%>" >
	
	
</form>
	<div id="divresultlist" style="margin-left:10px;margin-top:20px;"></div>
</body>
<% 
	if(rset != null) rset.close(); 
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	
}catch(Exception e)	
{
	

	e.printStackTrace();
}
finally
{
	if(con != null)
	ConnectionManager.returnConnection(con,request);
}
%>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

