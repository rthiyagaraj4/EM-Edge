//This file is saved on 18/10/2005


var message		= "" ;
async function showCarePlansForCurPatient(patientid,mdcpid)
{
	var queryString = "";
	queryString = "patient_id="+patientid+"&mdcpid="+mdcpid;

	var dialogHeight ='90vh';
	var dialogWidth = '80vw' ;
	var dialogTop	= '150';
	var dialogLeft = '50' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
	var arguments = "";
	var retVals = await top.window.showModalDialog("../../eCP/jsp/AssignCareManagerCarePlanLookup.jsp?"+queryString,arguments,features);
}

async function viewAssignMgr(call_mode,target)
{ 
	var frmobj=parent.frames[1].document.assign_cmgr_addmodify ;
	var facility_id=frmobj.facility_id.value;
	var care_manager=frmobj.assign_cmgr_desc.value;
	var locale=frmobj.locale.value;

	if((call_mode=='T') && (care_manager == ''))
	{
           frmobj.assign_cpmgr_id.value='';
           frmobj.assign_cmgr_desc.value='';
	   return false;
	}
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
 		//argumentArray[0] ="select practitioner_id code, practitioner_name description from am_pract_for_facility_vw where operating_facility_id ='"+facility_id+"' and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) and eff_status = 'E' ";
 		argumentArray[0] ="SELECT A.practitioner_id code, B.practitioner_name description FROM am_pract_for_facility_vw A, AM_PRACTITIONER_LANG_VW B WHERE A.operating_facility_id ='"+facility_id+"' AND B.LANGUAGE_ID ='"+locale+"' AND UPPER(B.practitioner_id) LIKE UPPER(?) AND UPPER(B.practitioner_name) LIKE UPPER(?) AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND A.eff_status = 'E'";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await viewAssessNoteShowModal(getLabel("eCP.CareManager.label","CP"), argumentArray );
		if(retVal != null && retVal != "") {
			var ret1=unescape(retVal);
			 var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
			target.value = arr[1] ;
			frmobj.assign_cpmgr_id.value = arr[0];			
		}	else{
			target.value ="";
			frmobj.assign_cpmgr_id.value ="";
//			parent.frames[1].location.href='../../eCommon/html/blank.html';
		}
}

async function viewAssessNoteShowModal(title, pArgumentArray) {

    var retVal = new String();
    /*
    var dialogHeight= "30" ;
    var dialogWidth = "50" ;
    */
    
    var dialogTop   = "10px";
    var dialogHeight= "450px" ;
    var dialogWidth = "700px" ;
    
    var status = "no";
	//var fin_Val=pArgumentArray.split(",");
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;

	firstCodeVal = "" ;
	firstDescVal = "" ;

    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;
    
    // added for PE on 26th April 2010
    
    if (pArgumentArray[5] != "")
    {
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "GET", "../../eCommon/jsp/CommonLookupResult.jsp?callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		responseText = trimString(responseText);
		eval(responseText) ;
	}
    if(firstCodeVal == "")
    {

		var dialogUrl       = "../../eCommon/jsp/CommonLookup.jsp?title="+title;
		
		pArgumentArray[9] = title;

		var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
        
		//var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
        
        var returnVal = "";  
        
        returnVal =   await top.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
        
        if( returnVal == null || returnVal == "" )
            return "";
        else
            return returnVal.split("\"") ;
		
     }
	 
     else
     {
         if(pArgumentArray[7] == CODE_DESC )
         {
            var temp = firstCodeVal
            firstCodeVal = firstDescVal
            firstDescVal = temp
         }
		 
          returnVal = firstCodeVal + "\"" + firstDescVal

         return returnVal.split("\"") ;
     }
}
async function viewCarePlans(call_mode,target)
{ 
	var frmobj=parent.frames[0].document.assign_care_manager;
	var care_manager=frmobj.care_plan_desc.value;
	var care_plan_id=frmobj.mdcp_id.value;
	if((call_mode=='T') && (care_manager == ''))
	{
           frmobj.care_plan_id.value='';
           frmobj.care_plan_desc.value='';
	   return false;
	}

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

		argumentArray[0]= "select care_plan_id code, nvl(goal_statement,care_plan_id) description from cp_pat_care_plan where md_care_plan_id=  '"+care_plan_id+ "' and upper(care_plan_id) like upper(?) and upper(goal_statement) like upper(?) and current_status in ('O','F')";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(getLabel("eCP.CarePlans.label","CP"), argumentArray );
		if(retVal != null && retVal != "") {
			var ret1=unescape(retVal);
			 var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
			target.value = arr[1] ;
			frmobj.care_plan_id.value = arr[0];
		}	else{
			target.value ="";
			frmobj.care_plan_id.value ="";
		}
		setTimeout("fillData()",5);
}

function recAssignCareMgr()
{

	var frmObj = parent.parent.frames[0].document.assign_care_manager ;
	var frmObj1 = parent.frames[1].document.assign_cmgr_addmodify;

	var vCPId		= frmObj.care_plan_id.value;
	var vCPMgrId	= frmObj1.assign_cpmgr_id.value;

	var fields=new Array(vCPId,vCPMgrId);
	var names = new Array (getLabel("eCP.CarePlans.label","CP"),getLabel("eCP.CarePlanManagerId.label","CP"));
        
	if(mandatory(fields,names) == false)
	{
		return false;
	}
	else
	{
			var frmObj2	= parent.frames[1].document.assign_cmgr_addmodify;
			frmObj2.action="../../servlet/eCP.AssignCareManagerServlet";
			frmObj2.target="messageFrame";
			frmObj2.submit();
			setTimeout("refresh1()",500);	
	}

}
function refresh1()
{
	parent.frames[0].location.reload();
	parent.frames[1].location.reload();
}
function clrForms()
{
		var frmObj = parent.parent.frames[0].document.assign_care_manager ;
		var patient_id = frmObj.patient_id.value;
		frmObj.care_plan_id.value ="";
		frmObj.care_plan_desc.value = "";
		var frmObj1 = parent.frames[1].document.assign_cmgr_addmodify;
		frmObj1.assign_cmgr_desc.value ="";
		frmObj1.assign_cpmgr_id.value = "";

		var url = '../../eCP/jsp/AssignCareManagerQueryResult.jsp?patient_id='+patient_id;
		parent.frames[0].location.href = url;

		var url1 = '../../eCP/jsp/AssignCareManagerHeader.jsp?patient_id='+patient_id;
		parent.parent.frames[0].location.href = url1;
}

function fillData()
{
		var frmObj = parent.frames[0].document.assign_care_manager;

		var patient_id = frmObj.patient_id.value;
		var mdcp_id	   = frmObj.mdcp_id.value;
		var cp_id	   = frmObj.care_plan_id.value;
		
		var url = '../../eCP/jsp/AssignCareManagerQueryResult.jsp?patient_id='+patient_id+'&mdcp_id='+mdcp_id+'&cp_id='+cp_id;
		var url1 = '../../eCP/jsp/AssignCareManagerAddModify.jsp?patient_id='+patient_id+'&mdcp_id='+mdcp_id+'&cp_id='+cp_id;
		var url2 = '../../eCP/jsp/AssignCareManagerToolbar.jsp?patient_id='+patient_id+'&mdcp_id='+mdcp_id+'&cp_id='+cp_id;

		parent.frames[1].frames[0].location.href = url;
		parent.frames[1].frames[1].location.href = url1;
		parent.frames[1].frames[2].location.href = url2;
}

function mandatory( fields, names) 	
{

	var errors = "" ;
	var errors1 = "" ;
    for( var i=0; i<fields.length; i++ ) 
	{
		if (fields[i]==""||fields[i]==null)
		{
			if(errors == "")
			{
				errors =  getMessage("CAN_NOT_BE_BLANK","Common");
				errors=errors.replace("$",names[i]);
			}
			else
			{
				errors1 =  getMessage("CAN_NOT_BE_BLANK","Common");
				errors1=errors1.replace("$",names[i]);
				errors =  errors + " " + errors1;
			}
		}
	}
    if ( errors.length != 0 ) 
	{
		alert(errors);
        return false ;
    }
    
	return true ;
}


