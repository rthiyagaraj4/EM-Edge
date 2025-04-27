var GlbPatDetails	= "";
var GlbExistingIds	= new Array();
function apply(){
	if(f_query_add_mod.document.forms[0]==null){
		if(frames[1].frames[1].GroupSearchCreate.chkallnewpatients){
			frames[1].frames[1].FnInsert();
		}else{
			window.commontoolbarFrame.document.location.reload();
		}
	}else{
		window.commontoolbarFrame.document.location.reload();
	}
}
function deleterecord(){
	if(f_query_add_mod.document.forms[0]==null){
		if(frames[1].frames[0].GroupSearchCriteria.chkallexistingpatients){
			frames[1].frames[0].FnDelete();
		}else{
			window.commontoolbarFrame.document.location.reload();
		}
	}else{
		window.commontoolbarFrame.document.location.reload();
	}
}

function onSuccess(mode,group_id,group_name){
	var error_id=encodeURIComponent(getMessage("RECORD_INSERTED","SM"));
	var params="";
	if(mode=='insert'){
		parent.parent.frames[1].frames[1].document.location.href = '../eOA/jsp/PatientGrpCreate.jsp';	
	}else if(mode=='delete'){
		
	}
	params	= "?group_name="+group_name+"&group_id="+group_id;
	parent.parent.frames[1].frames[0].document.location.href="../eOA/jsp/PatientGrpDetails.jsp"+params;
	parent.parent.frames[2].document.location.href="../eCommon/jsp/error.jsp?err_num="+ error_id;
} 

function query(){	
	 f_query_add_mod.location.href ="../../eOA/jsp/PatientGroupQueryPage.jsp";
	
}
function create(){	 
	f_query_add_mod.location.href	= "../../eOA/jsp/PatientGroupsFrameset.jsp";
}

function reset(){
	if(f_query_add_mod.document.forms[0]){
		f_query_add_mod.document.forms[0].reset();
	}else{
		f_query_add_mod.location.href	= "../../eOA/jsp/PatientGroupsFrameset.jsp";
	}
}

async function callgroupname(obj,target,mode){
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
	    callGroupLocation(GroupId);
    } else {
		clearValues();
    }
}



function clearValues(){
	var formName	= document; 
	$("#group_name",formName).val("");
	$("#min_patient",formName).val("");
	$("#max_patient",formName).val("");
	$("#group_id",formName).val("");
	$("#Existing_Group_Members",formName).val("");
	$("#group_location_id",formName).val("");
	$("#DivLocationResult",formName).html("");
	$("#DivPatientDetails",formName).html("");
	$("#PatientId",parent.frames[1].GroupSearchCreate).val("");
	$("#PatientId",parent.frames[1].GroupSearchCreate).attr("disabled",true);
	$("#commonLookup",parent.frames[1].GroupSearchCreate).attr("disabled",true);
	$("#AddPatientQueue",parent.frames[1].GroupSearchCreate).attr("disabled",true);
	$("#DivPatListQueue",parent.frames[1].GroupSearchCreate).html("");
	parent.frames[1].GlbPatDetails	= "";
	parent.frames[1].GlbExistingIds.length=0;
	
}
function FnRemoveGlobalValues(){
	GlbPatDetails	= "";
	GlbExistingIds.length=0;
}
async function viewPatientDetails(p_patient_id) {  
	var title = getLabel("eMP.ViewPatientDetails.label","MP");
	var dialogHeight= "90vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop="65";
	var dialogLeft="1";	
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	await window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);
}

