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

//********************************************************************************************
//function searchFacility
//*******************************************************************************************

function searchFacility(){
	var formObj				= document.frames.Datagroupdetails_setup_form;
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
//	alert("Facility Qry : "+formObj.sql_xh_Application_select.value);
	var strQry				= "SELECT FACILITY_ID,FACILITY_NAME FROM xp_param_for_facility";
	argumentArray[0]		= strQry;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "1,2";
	argumentArray[5]		= formObj.facility_name.value ;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( "Facility", argumentArray );

	if(retVal != null && retVal != "" )  {
		formObj.facility_name.value		=	 retVal[1] ;
		formObj.facility_id.value			=	 retVal[0];
		
		formObj.facility_name.disabled	=	  true;
		formObj.FacilitySearch.disabled	=	  true;

	}
}
//********************************************************************************************
//function searchMessageType
//*******************************************************************************************

function searchMessageType(){
	var formObj				= document.frames.Datagroupdetails_setup_form;
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
//	alert("MsgTyp Qry : "+formObj.sql_xh_Application_select.value);
	var strQry				= "SELECT MESSAGE_TYPE,DESCRIPTION FROM XH_MESSAGE_TYPE";
	argumentArray[0]		= strQry;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "1,2";
	argumentArray[5]		= formObj.mesg_type.value ;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( "Message Type", argumentArray );

	if(retVal != null && retVal != "" )  {
		formObj.mesg_type.value		=	 retVal[1] ;
		formObj.mesg_type_id.value		=	 retVal[0];
		
		formObj.mesg_type.disabled	=	  true;
		formObj.MessageTypeSearch.disabled	=	  true;

	}
}
//********************************************************************************************
//function searchEventType
//*******************************************************************************************

function searchEventType(){
	var formObj				= document.frames.Datagroupdetails_setup_form;
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
//	alert("EventTyp Qry : "+formObj.sql_xh_Application_select.value);
	var strQry				= "SELECT EVENT_TYPE,EVENT_NAME FROM XH_EVENT_TYPE_LANG_VW";
	argumentArray[0]		= strQry;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "1,2";
	argumentArray[5]		= formObj.event_type.value ;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( "Event Type", argumentArray );

	if(retVal != null && retVal != "" )  {
		formObj.event_type.value		=	 retVal[1] ;
		formObj.event_type_id.value		=	 retVal[0];
		
		formObj.event_type.disabled			=	  true;
		formObj.EventTypeSearch.disabled	=	  true;

	}
}
//********************************************************************************************
//function searchSegmentType
//*******************************************************************************************

function searchSegmentType(){
	var formObj				= document.frames.Datagroupdetails_setup_form;
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
//	alert("SegmentTyp Qry : "+formObj.sql_xh_Application_select.value);
	var strQry				= "SELECT SEGMENT_TYPE,SEGMENT_NAME FROM XH_SEGMENT";
	argumentArray[0]		= strQry;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "1,2";
	argumentArray[5]		= formObj.segment_type.value ;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( "Segment Type", argumentArray );

	if(retVal != null && retVal != "" )  {
		formObj.segment_type.value		=	 retVal[1] ;
		formObj.segment_type_id.value	=	 retVal[0];
		
		formObj.segment_type.disabled		=	  true;
		formObj.SegmentTypeSearch.disabled	=	  true;

	}
}
//********************************************************************************************
//function searchProtocolLink
//*******************************************************************************************

function searchProtocolLink(){
	var formObj				= document.frames.Datagroupdetails_setup_form;
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
//	alert("ProtocolLink Qry : "+formObj.sql_xh_Application_select.value);
	var strQry				= "SELECT PROTOCOL_LINK_ID,PROTOCOL_LINK_NAME FROM XH_PROTOCOL_LINK";
	argumentArray[0]		= strQry;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "1,2";
	argumentArray[5]		= formObj.protocol_linkName.value ;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( "Protocol Link", argumentArray );

	if(retVal != null && retVal != "" )  {
		formObj.protocol_linkName.value		=	 retVal[1] ;
		formObj.protocol_link_id.value		=	 retVal[0];
		
		formObj.protocol_linkName.disabled	=	  true;
		formObj.ProtocolLinkSearch.disabled	=	  true;

	}
}
//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	// #MOD#01
	var act = '../../eXH/jsp/DataGroupDetailsQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	// #MOD#02
	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

	alert("fn mdfy dg_code : "+obj.getAttribute('dg_code'));
	alert("fn mdfy application_id : "+obj.getAttribute('application_id'));
	alert("fn mdfy application_name : "+obj.getAttribute('application_name'));
	alert("fn mdfy facility_id : "+obj.getAttribute('facility_id'));
	alert("fn mdfy facility_name : "+obj.getAttribute('facility_name'));
	alert("fn mdfy protocol_link_id : "+obj.getAttribute('protocol_link_id'));
	alert("fn mdfy protocol_linkName : "+obj.getAttribute('protocol_linkName'));
	this.document.forms[0].dg_code.value = obj.getAttribute('dg_code');
	this.document.forms[0].application_id.value = obj.getAttribute('application_id');
	this.document.forms[0].facility_id.value = obj.getAttribute('facility_id');
	this.document.forms[0].protocol_link_id.value = obj.getAttribute('protocol_link_id');
	this.document.forms[0].mesg_type_id.value = obj.getAttribute('mesg_type_id');
	this.document.forms[0].event_type_id.value = obj.getAttribute('event_type_id');
	this.document.forms[0].segment_type_id.value = obj.getAttribute('segment_type_id');
	this.document.forms[0].dg_desc.value = obj.getAttribute('dg_desc');
	this.document.forms[0].application_name.value = obj.getAttribute('application_name');
	this.document.forms[0].facility_name.value = obj.getAttribute('facility_name');
	this.document.forms[0].protocol_linkName.value = obj.getAttribute('protocol_linkName');
	this.document.forms[0].mesg_type.value = obj.getAttribute('mesg_type');
	this.document.forms[0].event_type.value = obj.getAttribute('event_type');
	this.document.forms[0].segment_type.value = obj.getAttribute('segment_type');

//	this.document.forms[0].lang_id.value = obj.getAttribute('lang_id');
	var act = '../../eXH/jsp/DataGroupDetailsSelectMaster.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
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
