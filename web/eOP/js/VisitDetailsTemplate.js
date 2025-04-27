function create() 
{
    f_query_add_mod.location.href = "../../eOP/jsp/addModifyVisitDetailsTemplate.jsp" ;
}

     function onSuccess()
   {
    f_query_add_mod.location.reload();
    }
    
	 
	 function apply()
         {
  	  if (!(checkIsValidForProceed()))
         {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
     	return false;
          }		
		 var fields=new  
		Array(f_query_add_mod.document.forms[0].code,f_query_add_mod.document.forms[0].code_desc,f_query_add_mod.document.forms[0].location_desc);
	     var names= new Array(getLabel("Common.code.label","common"),getLabel("Common.description.label","common"),getLabel("Common.Location.label","common"));
		 		 
		 if(f_query_add_mod.checkFields( fields,names,messageFrame))
	     {
		  f_query_add_mod.document.forms[0].code.disabled=false;
		   f_query_add_mod.document.forms[0].submit();
		   }			
			
			 }
		
      	
	function query() {
	  
	f_query_add_mod.location.href ="../../eOP/jsp/queryCriteriaVisitDetailsTemplate.jsp";

}  
  function reset()
	 {
	
      //if(f_query_add_mod.document.location.href.indexOf("queryCriteriaVisitDetailsTemplate.jsp") != -1)
		 // return false;
	    //else 
			if(f_query_add_mod.document.location.href.indexOf("queryResultVisitDetailsTemplate.jsp") != -1)
		        return false;
		 else
		  f_query_add_mod.document.location.reload();
      }	

	  function onBlurgetCli(fac_id ,target)
      {
		if(target.value =="")
		{	
			target.value="";
			document.forms[0].location_code.value="";	
			clearValues();
			return;
		}
        getClinic(fac_id,target);
	}
       

  async function getClinic(fac_id,target)
      {
	    
		
		var retVal =    new String();
        var argumentArray  = new Array() ;
        var dataNameArray  = new Array() ;
        var dataValueArray = new Array() ;
        var dataTypeArray  = new Array() ;
        var tit="";	
        var sql;
		var locn_type_code=document.forms[0].locn_type_desc.value;
		tit=getLabel('Common.Location.label','Common');
        	   
		  if(target.name=='location_desc'){
			  sql ="select clinic_code code ,long_desc description from op_clinic where facility_id = '"+fac_id+"' and clinic_type='"+locn_type_code+"' and eff_status = 'E' and upper(clinic_code) like upper(?) and  upper(long_desc) like upper(?) order by long_desc";		  
		  }	
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;				
				retVal = await CommonLookup( tit, argumentArray );			
					
				if(retVal != null && retVal != "" )
                {
     	             var ret1=unescape(retVal);
				 	 arr=ret1.split(",");
					 if(arr[1]==undefined) arr[1]="";	
					 target.value=arr[1];		
					 prev_locn = document.forms[0].location_code.value;
					 document.forms[0].location_code.value=arr[0];	   
					 var cur_locn = arr[0];
					 aa(cur_locn,prev_locn);
						  
				 }
}


function aa(cur_locn,prev_locn){

	var HTMLVal = new String();		
	var u=cur_locn;
	if(cur_locn!=prev_locn) {		
		clearValues();
		var flag="visit_details";
		HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/getservice.jsp'><input type='hidden' name='flag' id='flag' value='"+flag+"'><input type='hidden' name='locn_code' id='locn_code' value='"+u+"'></form></BODY></HTML>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.form1.submit();
	}

}

function onBlurotherResourceLookUp(fac_id ,target)
{   
		if(target.value =="") {			
			document.forms[0].other_res_desc.value="";
			document.forms[0].other_res_code.value="";
			return;
		}
		otherResourceLookUp(fac_id,target);
}

async function otherResourceLookUp(fac_id,target)
{
	//var clinic_code = target.value;
	var clinic_code = document.forms[0].location_code.value;
	var other_resType=document.forms[0].other_res_type_desc.value;
	var facility_id = fac_id;
	locale=document.forms[0].locale.value;
	var sql="SELECT PRACTITIONER_ID code, DECODE(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2'),'R', AM_GET_DESC.AM_FACILITY_ROOM(facility_id, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2'),		 'O',AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2')) description FROM op_pract_for_clinic WHERE facility_id='"+facility_id+"'  AND resource_class='"+other_resType+"' AND clinic_code='"+clinic_code+"' AND eff_status='E' AND  UPPER(PRACTITIONER_ID) LIKE UPPER(?) AND(UPPER(am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2)) LIKE UPPER(?) OR  UPPER(am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2)) IS NULL) ORDER BY 2";
	
	var tit				= getLabel('Common.resource.label','Common');
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var arr			= new Array() ;

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.forms[0].other_res_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].other_res_desc.value=arr[1];
		document.forms[0].other_res_code.value=arr[0];
	}
}

function onBlurCallContactReasonSearch(fac_id,target)
{	  
	if(target.value == "")
	{
		 document.forms[0].reason_desc.value="";
		 document.forms[0].reason_code.value="";
		 return;
	}
	
	CallContactReasonSearch(fac_id,target);
}
 async function CallContactReasonSearch(fac_id,target)
{
	var tit				= getLabel("Common.ReasonforVisit.label",'Common')
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;	
    var  locale=document.forms[0].locale.value;
	
	var sql="select contact_reason_code code,contact_reason description from am_contact_reason_lang_vw where VISIT_REGISTRATION_YN = 'Y' and eff_status='E' and upper(contact_reason_code) like upper(?) and upper(contact_reason)   like upper(?) and language_id='"+locale+"'";			

	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=target.value;
	argumentArray[6]	= CODE_LINK;
	argumentArray[7]	= CODE_DESC;	
	
	retVal = await CommonLookup( tit, argumentArray );		
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].reason_desc.value=arr[1];
		document.forms[0].reason_code.value=arr[0];			
	}		
}

function popSubservice(obj)
{
	var service_code=obj.name;
	var service_code_value=obj.value;
	var flag ="sub service";
	ClearList(obj);
	//ClearList(parent.frames[3].document.forms[0].subservice_code);
	removeitems(document.forms[0].sub_service_desc);
 
   HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/getservice.jsp'><input type='hidden' name='flag' id='flag' value='"+flag+"'><input type='hidden' name='service_code' id='service_code' value='"+service_code_value+"'></form></BODY></HTML>";
    var message_frame=parent.parent.frames[2];
    parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();
}
 function removeitems(obj)
{
    var len=obj.length;
    var i=1;
    while(i<len)
    {
        len=obj.length
        obj.remove(i)
    }
}

function onBlurCallCatalogSearch(fac_id,target)
{
	target.value = trimString(target.value);
		 
	if(target.value == "")
	{
		 document.forms[0].order_cat_desc.value="";
		 document.forms[0].order_cat_code.value="";
		 return;
	}
		
	CallCatalogSearch(fac_id,target);
}

async function CallCatalogSearch(fac_id,target)
{
	var module_id='OP';
	var order_type="";
	var order_category="";
	var mode="";
	var searchtext=target.value;

	var clinic_code = document.forms[0].location_code.value;

	var dialogTop	= "56";
	var dialogHeight= "400px" ;
	var dialogWidth = "700px" ;
	var status = "no";
	var scroll = "no";
	var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
	var arguments   = "" ;			
	var retVal=await window.showModalDialog("../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+escape(searchtext)+"&called_from=OP&mode="+mode+"&order_category="+order_category+"&order_type="+order_type+"&p_clinic_code="+clinic_code,arguments,features);

	if(retVal != null && retVal != "")
	{
		var valarr=retVal.split("&");
		document.forms[0].order_cat_desc.value=valarr[1];
		document.forms[0].order_cat_code.value=valarr[0];
	}	
}

function  onBlurcallPractSearchQuery(obj,facility_id,target)
{
		if(target.value =="") {				
			document.forms[0].practitioner_desc.value="";
			document.forms[0].practitioner_code.value="";
			return;
		}
		callPractSearchQuery(obj,facility_id,target);
}



function callPractSearchQuery(obj,facility_id,target)
{
	var locationSpeciality="";
	var open_to_all_pract_yn = document.Visit_Details_Template.open_pract_yn.value;
	var locncode=document.Visit_Details_Template.location_code.value;
	var visitadmtype=document.Visit_Details_Template.visit_type_desc.value;
	var ptype=target.value;
	var targetname=target;	
	if (open_to_all_pract_yn == "Y") {
	getPractitioner(obj,targetname,facility_id,locationSpeciality,'',locncode,'','','','',"Q4");
	} else {					   getPractitioner(obj,targetname,facility_id,locationSpeciality,'',locncode,'','',ptype,visitadmtype,"Q3");	
	}	
}

function PractLookupRetVal(retVal,objName)
{
	var arr;	
	if (retVal != null && retVal != "")
	{
		arr=retVal.split("~"); 
		document.forms[0].practitioner_desc.value=arr[1];
		document.forms[0].practitioner_code.value=arr[0];			
	}	
}

function getValue(obj)
{
       var locn_type_code="";  
	   locn_type_desc=document.forms[0].locn_type_desc.value;
	   if(locn_type_desc=="")
	   {
		    document.forms[0].location_desc.value="";	
		    document.forms[0].service_desc.value="";	
		    document.forms[0].sub_service_desc.value="";	
			document.forms[0].visit_type_desc.value="";	
			document.forms[0].practitioner_desc.value="";	
			document.forms[0].other_res_type_desc.value="";	
			document.forms[0].other_res_desc.value="";	
			document.forms[0].order_cat_desc.value="";	
			document.forms[0].reason_desc.value="";	
			document.forms[0].room_desc.value="";	
	 
			ClearList(obj);
			removeitems(document.forms[0].service_desc);
			removeitems(document.forms[0].room_desc);
			removeitems(document.forms[0].visit_type_desc);
			removeitems(document.forms[0].sub_service_desc);
	
	} else {
			document.forms[0].service_desc.value="";	
			document.forms[0].sub_service_desc.value="";	
			document.forms[0].visit_type_desc.value="";	
			document.forms[0].practitioner_desc.value="";	
			document.forms[0].other_res_type_desc.value="";	
			document.forms[0].other_res_desc.value="";	
			document.forms[0].order_cat_desc.value="";	
			document.forms[0].reason_desc.value="";	
			document.forms[0].room_desc.value="";	
			document.forms[0].location_desc.value="";	  
			document.forms[0].locn_type_code.value=locn_type_code;	
			removeitems(document.forms[0].service_desc);
			removeitems(document.forms[0].room_desc);
			removeitems(document.forms[0].visit_type_desc);
			removeitems(document.forms[0].sub_service_desc);
	}
}
function clearValues(obj)
{
	    document.forms[0].service_desc.value="";	
	    document.forms[0].sub_service_desc.value="";	
		document.forms[0].visit_type_desc.value="";	
		document.forms[0].practitioner_desc.value="";	
		document.forms[0].other_res_type_desc.value="";	
		document.forms[0].other_res_desc.value="";	
		document.forms[0].order_cat_desc.value="";	
		document.forms[0].reason_desc.value="";	
		document.forms[0].room_desc.value="";	
		removeitems(document.forms[0].service_desc);
		removeitems(document.forms[0].room_desc);
		removeitems(document.forms[0].visit_type_desc);
		removeitems(document.forms[0].sub_service_desc);
}



function ClearList(object)
{
	var list1   = "";
    var length  ="";
    //var element = document.Visit_Details_Template.document.createElement('OPTION');
	var element = document.createElement('OPTION');

	if(object != null){
		var obj = object.name;
		}
    element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
    element.value="";   
	
if(obj=='location_desc' || obj=='locn_type_desc'){	
		var length  =document.Visit_Details_Template.service_desc.length;
		//var element = document.Visit_Details_Template.document.createElement('OPTION');
		var element = document.createElement('OPTION');
		element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
		element.value="";
	    for(i=1;i<length;i++)
          document.Visit_Details_Template.service_desc.remove(1);

		var length  =document.Visit_Details_Template.visit_type_desc.length;
        for(i=1;i<length;i++)
          document.Visit_Details_Template.visit_type_desc.remove(1);
        var length  =document.Visit_Details_Template.room_desc.length;
        for(i=1;i<length;i++)
          document.Visit_Details_Template.room_desc.remove(1);
		  
		  ClearList(document.Visit_Details_Template.room_desc);
		ClearList(document.Visit_Details_Template.visit_type_desc);
		ClearList(document.Visit_Details_Template.service_desc);
	
	}	
	if(obj=='service_desc'){	
		var length  =document.Visit_Details_Template.sub_service_desc.length;
		//var element = document.Visit_Details_Template.document.createElement('OPTION');
		var element = document.createElement('OPTION');
		element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
		element.value="";
	    for(i=1;i<length;i++)
          document.Visit_Details_Template.sub_service_desc.remove(1);	
	}	
}

function deleterecord()
{
	if (! (checkIsValidForProceed()) || f_query_add_mod.document.Visit_Details_Template.function_name.value =='insert')
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }	
	
	if(f_query_add_mod.document.Visit_Details_Template.function_name.value !='insert')
	{		
		if(confirm(getMessage('DELETE_RECORD','COMMON')))
		{
			f_query_add_mod.document.Visit_Details_Template.code.disabled = false;
			f_query_add_mod.document.Visit_Details_Template.function_name.value = 'delete';
			f_query_add_mod.document.Visit_Details_Template.submit();
   		    f_query_add_mod.location.href='../../eCommon/html/blank.html';	
    	} else {
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='	
		}
       
	}	
}

function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("cntrl")==-1) && (url.indexOf("query")==-1))
  return true;
 else
  return false;
}

function clearOthResource(obj) {	
	document.Visit_Details_Template.other_res_desc.value = "";
	document.Visit_Details_Template.other_res_code.value = "";	
}

