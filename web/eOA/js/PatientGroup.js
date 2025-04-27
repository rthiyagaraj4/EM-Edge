function apply(){
	if(patgroupserachresult.document.PatGrpRes!=null){
		if(patgroupserachresult.document.PatGrpRes.mode.value=='insert'){
			patgroupserachresult.FnInsert();
		}else{
			window.commontoolbarFrame.document.location.reload();
		}
	}else
		window.commontoolbarFrame.document.location.reload();
}
function deleterecord(){
	if(patgroupserachresult.document.PatGrpRes!=null){
		if(patgroupserachresult.document.PatGrpRes.mode.value=='delete'){
			patgroupserachresult.FnDelete();
		}else{
			window.commontoolbarFrame.document.location.reload();
		}
	}else
		window.commontoolbarFrame.document.location.reload();
}

function onSuccess(){
	parent.frames[2].frames[1].location.href = '../../eCommon/html/blank.html';
} 
function query(){
	parent.frames[2].frames[1].location.href = '../../eOA/jsp/PatientGroupQuery.jsp';
	parent.frames[2].frames[2].location.href = '../../eCommon/html/blank.html';
	
}
function create(){
	parent.frames[2].frames[1].location.href = '../../eOA/jsp/PatientGroupCriteria.jsp';
	parent.frames[2].frames[2].location.href = '../../eCommon/html/blank.html';
}

function reset(){
	create();
}

function callgroupname(obj,target,mode){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";	   
	tit=getLabel("Common.GroupName.label",'Common');
	sql ="select group_id code, group_name description from oa_group_hdr where eff_status='E' and  upper(group_id) like upper(?) and upper(group_name) like upper(?) order by 2";				
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );	
	if(retVal != null && retVal != "" ) {
              var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
	    document.forms[0].group_name.value=arr[1];	
	    document.forms[0].group_id.value=arr[0];
	    var GroupId		= document.forms[0].group_id.value;
	    callGroupLocation(GroupId,mode);
    } else {
		clearValues(mode,'document');
    }
}

function callGroupLocation(GroupId,mode){  
	 $.ajax({  
      url:'../../eOA/jsp/GetGroupLocation.jsp',  
      type:'post',  
      data:{'GroupId':GroupId},
      dataType: 'json',
      success: function(data) {
	     	 if(data.isJsonResults==1){
	     		var ResultString	= "";
	     		ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('Common.Location.label','Common')+" : "+data.LOCN_NAME+"</span>";
	     		ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('Common.MIN.label','Common')+" "+getLabel('Common.Patients.label','Common')+" : "+data.MIN_PATIENTS+"</span>";
	     		ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('Common.Max.label','Common')+" "+getLabel('Common.Patients.label','Common')+" : "+data.MAX_PATIENTS+"</span>";
	     		if(data.TotMemberInGroup > 0){
	     			ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('eOA.TotalPatientsLinkedInGroup.label','OA')+" : "+data.TotMemberInGroup+"</span>";
	     		}
	     		$("#min_patient").val(data.MIN_PATIENTS);
	     		$("#max_patient").val(data.MAX_PATIENTS);
	     		$("#Existing_Group_Members").val(data.TotMemberInGroup);
	     		$("#group_location_id").val(data.LOCN_CODE);
	     		$("#TdLocationResult").html(ResultString);
	    	    if(mode=='insert')
	    	    	$("#PatientSearchContainer").show();
	    	    if(mode=='delete')
	    	    	parent.frames[2].location.href = "../../eOA/jsp/PatientGroupResult.jsp?&GroupId="+GroupId+"&mode="+mode;
	     	 }else{
	     		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
	     		clearValues(mode,'document');
	     	 }
      } ,
      error: function(jqXHR, textStatus, errorThrown) {
          alert("incoming Text " + jqXHR.responseText);
      }
  });  
}

function clearValues(mode,formvalue){
	
	var formName	= document; 
	if(formvalue=='parent'){
		formName=parent.frames[1].document;
	}
	
	$("#group_name",formName).val("");
	$("#min_patient",formName).val("");
	$("#max_patient",formName).val("");
	$("#group_id",formName).val("");
	$("#Existing_Group_Members",formName).val("");
	$("#group_location_id",formName).val("");
	$("#TdLocationResult",formName).html("");
	if(mode=='insert')
		$("#PatientSearchContainer",formName).hide();
	parent.frames[2].location.href = "../../eCommon/html/blank.html";
}





