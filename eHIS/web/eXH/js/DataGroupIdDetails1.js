//********************************************************************************
var result1    =   false;
var message1   =   "";
var flag1      =   "";
var INT     = "Integer" ;
var LONG    = "Long"    ;
var FLOAT   = "Float"   ;
var DOUBLE  = "Double"  ;
var STRING  = "String"  ;
var CODE_LINK       = "1"   ;
var DESC_LINK       = "2"   ;
var CODE_DESC_LINK  = "1,2" ;
var CODE_DESC       = "CODE_DESC" ;
var DESC_CODE       = "DESC_CODE" ;
var radioval    = "D"         ;
var firstCodeVal = "" ;
var firstDescVal = "" ; 
//*************************
//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{
//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
window.f_query_add_mod.location.href="../../eXH/jsp/DataGroupDetailsSelectMaster.jsp?mode=I";		
window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='none';
		window.f_query_add_mod.location.href="../../eXH/jsp/DataGroupDetailQueryCriteria.jsp";		
		window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{

// frames[1].document.forms[0].dg_code,
//	alert("apply");
	var fields = new Array (  
					      frames[1].document.forms[0].application_name,
					      frames[1].document.forms[0].facility_name,
						  frames[1].document.forms[0].mesg_type,
					      frames[1].document.forms[0].event_type,
						  frames[1].document.forms[0].segment_type,
					      frames[1].document.forms[0].protocol_linkName);

// getLabel("eXH.Data.Label","XH"),

	var names = new Array ( 
						getLabel("eXH.ApplicationID.Label","XH"),
						getLabel("eXH.FacilityId.Label","XH"),
						getLabel("eXH.MessageType.Label","XH"),
						getLabel("eXH.EventType.Label","XH"),
						getLabel("eXH.SegmentType.Label","XH"),
						getLabel("eXH.ProtocolLinkId.Label","XH"));
  
	if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
   
	}else
		{  
//			alert("Apply .... Submit");
//			alert("Mode : "+frames[1].document.forms[0].act_mode.value);
//			alert("Code : "+frames[1].document.forms[0].application_name.value);
//			alert("Desc : "+frames[1].document.forms[0].facility_name.value);
			window.f_query_add_mod.document.forms[0].submit();
			
		}
window.commontoolbarFrame.document.location.reload();
}
//********************************************************************************************
//FUNCTION RESET 
//********************************************************************************************
function reset()
{

	
	if(window.f_query_add_mod.document.forms[0])
    {
	 window.f_query_add_mod.document.forms[0].reset();
	}
}

//********************************************************************************************
//function searchApplication
//*******************************************************************************************

function searchApplication(var obj)
{
   
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="Application" ;
	//var temp=this.document.forms[0].v_birth_place_desc;
	
	var sql= "select application_name,application_id from xh_application ";
	
  	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	alert(retVal);
		
}


//*******************************************************************************************
//function funAction
//*******************************************************************************************

function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	funSubmit();
}
//*******************************************************************************************
