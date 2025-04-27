<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.* ,eCommon.XSSRequestWrapper" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
try{
	Connection con 				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs				=null;
	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	String group_name		= request.getParameter("group_name")==null?"":request.getParameter("group_name");
	String group_id			= request.getParameter("group_id")==null?"":request.getParameter("group_id");

%>

	<html>
	<head>	
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
	<script language='javascript' src='../../eOA/js/PatientGroup1.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style type="text/css">
    table.mt {border-width: 1px;border-spacing:0px ;border-collapse: collapse;}
    table.mt th {border-width: 1px;padding: 1px;;white-space: normal; text-align:left;}
    table.mt td {border-width: 1px;padding: 1px;text-align: left;vertical-align:middle;white-space:normal;word-wrap: break-word; word-break: break-all;}
</style>

	</head>
	<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="GroupSearchCriteria" id="GroupSearchCriteria" method="post" action="../../servlet/eOA.GenerateGroupPatientsServlet">
	<table cellpadding='1' cellspacing='1' width='100%' border='0'>
		<tr>
		<td class = 'label'  width = '10%' nowrap><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
					<td width='10%' class='fields'>
						<input type="hidden" name="group_id"  id="group_id" value='<%=group_id%>'>
						<input type="hidden" name="min_patient" id="min_patient" >
						<input type="hidden" name="max_patient"  id="max_patient" >	
						<input type="hidden" name="Existing_Group_Members" id="Existing_Group_Members" >
						<input type="hidden" name="group_location_id" id="group_location_id" >
						<input type="hidden" name="HidSelectedPatIds" id="HidSelectedPatIds">
						<input type="text" name="group_name" id="group_name" onblur='if(this.value!=""){callgroupname(this,document.forms[0].group_name,"delete")}else{clearValues();}' value="<%=group_name%>"> <input type="button" name="group_name_lookup" id="group_name_lookup" value="?" class="button" onclick="callgroupname(this,document.forms[0].group_name,'insert')"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
						<input type="hidden" name="mode" id="mode" value="delete">
					</td>
		</tr>
		<tr></tr>
	</table>
	<div id="DivLocationResult" style="margin-top:20px;margin-left:10px;"></div>
	<br/>
	<div id="DivPatientDetails" style="margin-top:20px;margin-left:10px;"></div>
	
	
	
	

<script>

function clearAll(){
	parent.frames[2].location.href ="../../eCommon/html/blank.html";
}



/*function FnShowExistingPatientsDetails(GroupId){
	 $.ajax({  
	     url:'../../eOA/jsp/GetGroupLocation.jsp',  
	     type:'post',  
	     data:{'GroupId':GroupId,'action':'get_existing_grp_patient_details'},
	     dataType: 'json',
	     success: function(data) {
	      	var recordlist=eval(data.recordslist);
	      	var DisplayData		= "";
	      	var patient_id		= "";
	      	var patient_data	= "";
	      	var tdclass			= "";		
	    	if(data.count > 0){
	    		DisplayData		= "<table border='1' width='98%' style='border-spacing:0px ;border-collapse: collapse;' id='dataTable' class='mt'><tr><th width='80%'><b>"+getLabel("Common.PatientDetails.label","Common")+"</b></th><th  width='20%'><b>"+getLabel("Common.delete.label","Common")+" "+getLabel("Common.all.label","Common")+"</b><input type='checkbox' name='chkallexistingpatients' id='chkallexistingpatients' > </th></tr>";
			    $.each(recordlist,function(index,value){
			    	patient_id		= value.patient_id;
			    	patient_data	= value.patient_line;
			    	tdclass			= value.tdclass;
			    	DisplayData		+= "<tr>";
			    	DisplayData		+= "<td class="+tdclass+" valign='top'>";
			      	DisplayData		+= "<a href='javascript:viewPatientDetails(\""+patient_id+"\")'>+</a><font size=1>"+patient_data+"</font></td>";
			
			    	DisplayData		+= "<td class="+tdclass+" > <input type=checkbox name='existingpatid' id='existingpatid' value='"+patient_id+"' > </td></tr>";
	            });
			    DisplayData			+="</table>";
	    	}
	    	$("#DivPatientDetails").html(DisplayData);
	    	if($("#dataTable").length > 0){
	    		fxheaderInit('dataTable',350);	
	    	}
	     },
	     error: function(jqXHR, textStatus, errorThrown) {
	         alert("incoming Text " + jqXHR.responseText);
	     }
	 });

}
*/
/*//$("input[name='chkallexistingpatients']").live('click',function() 
	$(document).on('click', "input[name='chkallnewpatients']", function(){
/*	var checked = $(this).attr('checked');
	if(checked == 'checked') {
		$("input[name='existingpatid']").attr("checked", true);
	} else {
		$("input[name='existingpatid']").attr("checked", false);
	}
});


//$("input[name='existingpatid']").live('click',function() 
  $(document).on('click', "input[name='existingpatid']", function(){
	if($("input[name='existingpatid']").length == $("input[name='existingpatid']").filter(':checked').length) {
		$("input[name='chkallexistingpatients']").attr("checked", true);
	} else {
		$("input[name='chkallexistingpatients']").attr("checked", false);
	}
});
*/
function FnShowExistingPatientsDetails(GroupId){
	$.ajax({  
	     url: '../../eOA/jsp/GetGroupLocation.jsp',  
	     type: 'post',  
	     data: {'GroupId': GroupId, 'action': 'get_existing_grp_patient_details'},
	     dataType: 'json',
	     success: function(data) {
	      	var recordlist = eval(data.recordslist);
	      	var DisplayData = "";
	      	var patient_id = "";
	      	var patient_data = "";
	      	var tdclass = "";		
	    	if (data.count > 0) {
	    		DisplayData = "<table border='1' width='98%' style='border-spacing:0px ;border-collapse: collapse;' id='dataTable' class='mt'><tr><th width='80%'><b>"+getLabel("Common.PatientDetails.label", "Common")+"</b></th><th  width='20%'><b>"+getLabel("Common.delete.label", "Common")+" "+getLabel("Common.all.label", "Common")+"</b><input type='checkbox' name='chkallexistingpatients' id='chkallexistingpatients' > </th></tr>";
			    $.each(recordlist, function(index, value) {
			    	patient_id = value.patient_id;
			    	patient_data = value.patient_line;
			    	tdclass = value.tdclass;
			    	DisplayData += "<tr>";
			    	DisplayData += "<td class="+tdclass+" valign='top'>";
			      	DisplayData += "<a href='javascript:viewPatientDetails(\""+patient_id+"\")'>+</a><font size=1>"+patient_data+"</font></td>";
			    	DisplayData += "<td class="+tdclass+" > <input type=checkbox name='existingpatid' id='existingpatid' value='"+patient_id+"' > </td></tr>";
	            });
			    DisplayData += "</table>";
	    	}
	    	$("#DivPatientDetails").html(DisplayData);
	    	if ($("#dataTable").length > 0) {
	    		fxheaderInit('dataTable', 350);	
	    	}
	     },
	     error: function(jqXHR, textStatus, errorThrown) {
	         alert("incoming Text " + jqXHR.responseText);
	     }
	});
}

// Select/Deselect All checkboxes when the "Select All" checkbox is clicked
$(document).on('click', "input[name='chkallexistingpatients']", function(){
	var isChecked = $(this).prop('checked');  // Check the state of the "Select All" checkbox
	$("input[name='existingpatid']").prop('checked', isChecked); // Set all checkboxes based on "Select All"
});

// Update the "Select All" checkbox based on individual checkbox states
$(document).on('click', "input[name='existingpatid']", function(){
	var allChecked = $("input[name='existingpatid']").length === $("input[name='existingpatid']:checked").length;
	$("input[name='chkallexistingpatients']").prop('checked', allChecked); // If all are checked, mark "Select All" as checked
});

function FnDelete(){
	var VarPatIds=FnGetCheckdValues();
	var IsError			= 0;
	if(VarPatIds==""){
		alert(getMessage("ATLEAST_ONE_SELECTED", "common"));
		parent.parent.commontoolbarFrame.document.location.reload();
		IsError	=1;
	}
	if(IsError==0){
		$("#HidSelectedPatIds").val(VarPatIds);
		$("#GroupSearchCriteria").submit();
	}
}

function FnGetCheckdValues(){
	var VarPatIds	= "";
	$("input[name='existingpatid']").filter(':checked').each(function() {
		VarPatIds+=$(this).val()+"|";
	});
	if(VarPatIds!=''){
		VarPatIds	= VarPatIds.slice(0,-1);
	}
	return VarPatIds;
}

<%if(!group_id.equals("") && !group_name.equals("")){%>
	callGroupLocation('<%=group_id%>');
<%}%>	

function callGroupLocation(GroupId){  
	 $.ajax({  
     url:'../../eOA/jsp/GetGroupLocation.jsp',  
     type:'post',  
     data:{'GroupId':GroupId},
     dataType: 'json',
     success: function(data) {
	     	 if(data.isJsonResults==1){
	     		var ResultString	= "<table border='1' width='100%' style='border-spacing:0px ;border-collapse: collapse;' ><tr><th colspan='2'><b>"+getLabel("Common.GroupDetails.label","Common")+"</b></th></tr>";
	     		ResultString		+= "<tr><td class='AR_QRYEVEN' width='50%'>"+getLabel('Common.Location.label','Common')+"</td><td class='AR_QRYEVEN' width='50%'>"+data.LOCN_NAME+"</td></tr>";
	     		ResultString		+= "<tr><td class='AR_QRYODD' width='50%'>"+getLabel('Common.MIN.label','Common')+" "+getLabel('Common.Patients.label','Common')+"</td><td class='AR_QRYODD' width='50%'>"+data.MIN_PATIENTS+"</td></tr>";
	     		ResultString		+= "<tr><td class='AR_QRYEVEN' width='50%'>"+getLabel('Common.Max.label','Common')+" "+getLabel('Common.Patients.label','Common')+"</td><td class='AR_QRYEVEN' width='50%'>"+data.MAX_PATIENTS+"</td></tr>";
	     		if(data.TotMemberInGroup > 0){
	     			ResultString+="<tr><td class='AR_QRYODD' width='50%'>"+getLabel('eOA.TotalPatientsLinkedInGroup.label','OA')+"</td><td class='AR_QRYODD' width='50%'>"+data.TotMemberInGroup+"</td></tr>";
	     		}
	     		ResultString		+="</table>";
	     		
	     		$("#min_patient").val(data.MIN_PATIENTS);
	     		$("#max_patient").val(data.MAX_PATIENTS);
	     		$("#Existing_Group_Members").val(data.TotMemberInGroup);
	     		$("#group_location_id").val(data.LOCN_CODE);
	     		$("#DivLocationResult").html(ResultString);
	     		$("#PatientId",parent.frames[1].GroupSearchCreate).attr("disabled",false);
	     		$("#commonLookup",parent.frames[1].GroupSearchCreate).attr("disabled",false);
	     		$("#AddPatientQueue",parent.frames[1].GroupSearchCreate).attr("disabled",false);
	     		if(data.TotMemberInGroup > 0){
	     			FnShowExistingPatientsDetails(GroupId);
	     		}else{
	     			$("#DivPatientDetails").html("");
	     		}
	     	 }else{
	     		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
	     		clearValues();
	     	 }
	     	$("#PatientId",parent.frames[1].GroupSearchCreate).val("");
	    	$("#DivPatListQueue",parent.frames[1].GroupSearchCreate).html("");
	       	parent.frames[1].GlbExistingIds.length=0;
     } ,
     error: function(jqXHR, textStatus, errorThrown) {
         alert("incoming Text " + jqXHR.responseText);
     }
 });  
}

</script>

<%}catch(Exception e){
	e.printStackTrace();
}%>
</form> 
</body>
</html>

