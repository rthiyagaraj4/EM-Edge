<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    Connection con=null;
	Statement stmt = null;
	ResultSet rs =null;
try{
	con 		= ConnectionManager.getConnection(request);

	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String pat_length="";
	stmt=con.createStatement();
	rs=stmt.executeQuery("select patient_id_length from mp_param where MODULE_ID='MP'");
	if (rs!=null&&rs.next())
       pat_length = rs.getString(1);

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


	</head>
	<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="GroupSearchCreate" id="GroupSearchCreate" id="GroupSearchCreate" method="post" action="../../servlet/eOA.GenerateGroupPatientsServlet">
	<table cellpadding='1' cellspacing='1' width='100%' border='0'>
		<tr>
		<td class = 'label'  width = '20%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td width='30%' class='fields'>
						
						<input type=text name='PatientId' id='PatientId' id="PatientId" size="<%=pat_length%>" maxlength="<%=pat_length%>"  value='' onBlur="changeCase(this),FnPatientValidation();" disabled><input type=button name='commonLookup' id='commonLookup' id="commonLookup"  value='?' class='button' onclick='callPatientSearch(); ' disabled> <img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td><!--  ChangeUpperCase(this); -->
		<td width='50%'><input type="button" name="AddPatientQueue" id="AddPatientQueue" id="AddPatientQueue" class='button' value="Add" disabled onclick="FnAddToQueue();"> </td>
		</tr>
		<tr></tr>
		<tr></tr>
			
	</table>
	<input type="hidden" name="HidSelectedPatIdsInsert" id="HidSelectedPatIdsInsert" id="HidSelectedPatIdsInsert" >
	<input type="hidden" name="group_id" id="group_id" id="group_id" >
	<input type="hidden" name="mode" id="mode" id="mode" value="insert">
	<input type="hidden" name="group_name" id="group_name" id="group_name" >
	<div id="DivPatListQueue"></div>
	</form> 
	
	
	

<script>

async function callPatientSearch(){
	 var patientId=await PatientSearch();
	 if (patientId!=null && patientId!=''){
	  	//alert(parent.frames[0].GroupSearchCriteria.group_location_id.value)
	  	FnChkAlreadyExistsInGroup(patientId);
	 }
}

function FnChkAlreadyExistsInGroup(patientId){
	var LocnCode	= $("#group_location_id",parent.frames[0].GroupSearchCriteria).val();
	 $.ajax({  
	     url:'../../eOA/jsp/GetGroupLocation.jsp',  
	     type:'post',  
	     data:{'patientId':patientId,'action':'get_patient_details','LocnCode':LocnCode},
	     dataType: 'json',
	     success: function(data) {
	      	if(data.IsAlreadyExists==0){
	      		GlbPatDetails	= data.recordslist;
	      		$("#PatientId").val(patientId);
				
	      	}else{
	      	 	var Message	= getMessage("PATIENT_ALREADY_ASSIGNED", "OA");
	      	 	Message		= Message.replace("#",data.group_name);
	      	 	alert(Message);
	      		GlbPatDetails	= "";
	      		$("#PatientId").val("");
	       	}
	     },
	     error: function(jqXHR, textStatus, errorThrown) {
	         alert("incoming Text " + jqXHR.responseText);
	     }
	 });
}


function changeCase(Obj){
	Obj.value=Obj.value.toUpperCase();
	if(Obj.value !=""){
		var HTML="<html><body onKeyDown = 'lockKey()'><form name='chkpatient_id' id='chkpatient_id' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='chkpatient_id_valid'><input type=hidden name='patient_id' id='patient_id' value='"+Obj.value+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
		parent.messageFrame.document.chkpatient_id.submit();
		
	}
}

function FnAddToQueue(){
	parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp";
	var patid	= $("#PatientId").val();
	if(patid==""){
		alert(getMessage("PATIENT_SELECT", "OA"));
		return false
	}
	var recordlist	= eval(GlbPatDetails);
	var DisplayData		= "";
	var patient_id		= "";
	var patient_data	= "";
	var tdclass			= "";
	var tdid			= "";
	/*$.each(GlbExistingIds,function(i,v){
		alert(v);
	});*/
	
	
	if(FnInArray(patid,GlbExistingIds)==false){


		if($("#tablepatlist").is(':visible')==false){
			DisplayData		= "<table border='1' width='99%' style='border-spacing:0px ;border-collapse: collapse;' id='tablepatlist' ><tr><th width='80%'><b>"+getLabel("eOA.SelectedPatientList.label","OA")+"</b></th><th  width='20%'>"+getLabel("Common.all.label","Common")+"</b><input type='checkbox' name='chkallnewpatients' id='chkallnewpatients' id='chkallnewpatients' checked > </th></tr>";
		}
		
		//if($("#pat_id_chk").length > 0)
		$.each(recordlist,function(index,value){
			patient_id		= value.patient_id;
			patient_data	= value.patient_line;
			tdclass			= "AR_QRYEVEN";
			
			DisplayData		+= "<tr>";
			DisplayData		+= "<td class="+tdclass+" valign='top'>";
			DisplayData		+= "<a href='javascript:viewPatientDetails(\""+patient_id+"\")'>+</a><font size=1>"+patient_data+"</font></td>";
			DisplayData		+= "<td class="+tdclass+" > <input type=checkbox name='pat_id_chk' id='pat_id_chk' value='"+patient_id+"' checked  /> </td></tr>";
			
		});
		if($("#tablepatlist").is(':visible')==false){
			DisplayData			+="</table>";
			$("#DivPatListQueue").html(DisplayData);
		}else{
			$("#tablepatlist").append(DisplayData);
		}
		fxheaderInit('tablepatlist',480);
		
	}else{
		alert(getMessage("PATIENT_ALREADY_AVAILABLE_IN_LIST", "OA"));
		$("#PatientId").val("");
		return false;
	}
	GlbExistingIds.push(patid);
	$("#PatientId").val("");
	GlbPatDetails	= "";
}

//Select/Deselect All checkboxes when the "Select All" checkbox is clicked
$(document).on('click', "input[name='chkallnewpatients']", function() {
    var isChecked = $(this).prop('checked'); // Get the state of the "Select All" checkbox
    $("input[name='pat_id_chk']").prop('checked', isChecked); // Set all checkboxes to match "Select All"
});

// Update the "Select All" checkbox based on individual checkbox states
$(document).on('click', "input[name='pat_id_chk']", function() {
    var allChecked = $("input[name='pat_id_chk']").length === $("input[name='pat_id_chk']:checked").length;
    $("input[name='chkallnewpatients']").prop('checked', allChecked); // If all are checked, mark "Select All" as checked
});


function FnInArray(needle, haystack) {
    var length = haystack.length;
    for(var i = 0; i < length; i++) {
        if(haystack[i] == needle)
        	return true;
    }
    return false;
}

function FnInsert(){
	var VarPatIds		= FnGetCheckdValues();
	var VarPatCount		= FnGetCheckedCount();
	$("#HidSelectedPatIdsInsert").val("");
	var VarMaxPatient	= $("#max_patient",parent.frames[0].GroupSearchCriteria).val();
	var VarCheckCount	= parseInt($("#Existing_Group_Members",parent.frames[0].GroupSearchCriteria).val())+VarPatCount;
	var IsError			= 0;
	if(VarPatIds==""){
		alert(getMessage("ATLEAST_ONE_SELECTED", "common"));
		parent.parent.commontoolbarFrame.document.location.reload();
		IsError	= 1;
	}else if(VarCheckCount > VarMaxPatient){
		alert(getMessage("MAX_PAT_LIMIT_REACHED", "OA"));
		parent.parent.commontoolbarFrame.document.location.reload();
		IsError	= 1;
	}
	if(IsError==0){
		$("#HidSelectedPatIdsInsert").val(VarPatIds);
		$("#group_id").val($("#group_id",parent.frames[0].GroupSearchCriteria).val());
		$("#group_name").val($("#group_name",parent.frames[0].GroupSearchCriteria).val());
		$("#GroupSearchCreate").submit();
	}
}


function FnGetCheckedCount(){
	var count	= 0;
	$("input[name='pat_id_chk']").filter(':checked').each(function() {
		count	= count + 1;
	});
	return parseInt(count);
}


function FnGetCheckdValues(){
	var VarPatIds	= "";
	$("input[name='pat_id_chk']").filter(':checked').each(function() {
		VarPatIds+=$(this).val()+"|";
	});
	if(VarPatIds!=''){
		VarPatIds	= VarPatIds.slice(0,-1);
	}
	return VarPatIds;
}

//$("input[name='chkallnewpatients']").live('click',function() 
	$(document).on('click', "input[name='chkallnewpatients']", function(){
	var checked = $(this).attr('checked');
	if(checked == 'checked') {
		$("input[name='pat_id_chk']").attr("checked", true);
	} else {
		$("input[name='pat_id_chk']").attr("checked", false);
	}
});

//$("input[name='pat_id_chk']").live('click',function()
  $(document).on('click', "input[name='pat_id_chk']", function(){
	if($("input[name='pat_id_chk']").length == $("input[name='pat_id_chk']").filter(':checked').length) {
		$("input[name='chkallnewpatients']").attr("checked", true);
	} else {
		$("input[name='chkallnewpatients']").attr("checked", false);
	}
});


function FnPatientValidation(){
	
	var patientId	= $("#PatientId").val();
	if(patientId!=''){
		$.ajax({  
		     url:'../../eOA/jsp/GetGroupLocation.jsp',  
		     type:'post',  
		     data:{'patientId':patientId,'action':'chk_valid_patient'},
		     dataType: 'json',
		     success: function(data) {
			      if(data.pat_status!="" || data.pat_status!=null){
			    	  var pat_status	= data.pat_status;
					  var ErrorMessage	= "";
			    	  if (pat_status=="SUSPENDED"){  
			    		 ErrorMessage= getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'); 
			          }else if (pat_status=="DECEASED"){
						 ErrorMessage= getMessage('PAT_DECEASED_NOT_ALLOWED','MP'); 
					  }else if (pat_status=="SECURED"){
						 ErrorMessage= getMessage('SECURED_NOT_ALLOWED','COMMON'); 
					  }else if (pat_status=="INACTIVE"){
						 ErrorMessage= getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'); 
					  }else if (pat_status=="BLACKLISTED_PATIENT"){
						 ErrorMessage= getMessage('BLACKLISTED_PATIENT','MP'); 
					  }else if ( pat_status=="INVALID_PATIENT"){
						 ErrorMessage	= getMessage('INVALID_PATIENT','MP');
					  }else if(pat_status.indexOf("PATIENT_MERGED_VALID") > -1){
						 var valid_patient_id	= pat_status.split("$");
						  if(pat_status.length>0){
							  ErrorMessage	= getMessage('PATIENT_MERGED_VALID','MP');
							  ErrorMessage	= ErrorMessage.replace("#",valid_patient_id[1]);
						  }
					  }
					  if(ErrorMessage!=''){
						alert(ErrorMessage);
						$("#PatientId").val("");
						
					  }else{
						  FnChkAlreadyExistsInGroup(patientId);
					  }
	
			      }
		     },
		     error: function(jqXHR, textStatus, errorThrown) {
		         alert("incoming Text " + jqXHR.responseText);
		     }
		 });
	}
	
}

function changeCase(Obj){
    Obj.value=Obj.value.toUpperCase();
	
}


</script>

<%}catch(Exception e){
	e.printStackTrace();
}finally{
    if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>
</body>
</html>

