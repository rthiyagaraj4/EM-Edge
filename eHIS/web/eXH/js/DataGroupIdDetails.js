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
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
//		alert("Delete");
		window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
//		if (confirm(getMessage("DELETE_RECORD"))){
//			alert("Conf Del ");
			apply();
//		}
}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{

// frames[1].document.forms[0].dg_code,
	alert("DataGroupIdDetails apply");
	var fields = new Array (  
						  frames[1].document.forms[0].application_name,
					      frames[1].document.forms[0].facility_name,
						  frames[1].document.forms[0].mesg_type,
					      frames[1].document.forms[0].event_type,
						  frames[1].document.forms[0].segment_type,
					      frames[1].document.forms[0].protocol_linkName);

// getLabel("eXH.Data.Label","XH"),

	var names = new Array ("Application ID","Facility Id","Message Type","Event Type","Segment Type","Protocol Link Id");
  
	if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
   
	}else
		{  
//			alert("Mode : "+frames[1].document.forms[0].act_mode.value);
//          alert("dg_code : "+frames[1].document.forms[0].dg_code.value);
//			alert("protocol_link_id : "+frames[1].document.forms[0].protocol_link_id.value);
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

function searchApplication(){

            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Application" ;
            var target=this.document.forms[0].application_name;
            var appl_id=this.document.forms[0].application_id;
/*
            sql="SELECT application_name description,application_id code FROM XH_APPLICATION "+
                    "   WHERE UPPER(application_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(application_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
            sql="SELECT application_id code,application_name description FROM XH_APPLICATION "+
                    "   WHERE UPPER(application_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(application_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                appl_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                appl_id.value=tcode;
            }
}// End of searchApplication

//********************************************************************************************
//function searchFacility
//*******************************************************************************************

function searchFacility(){

            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Facility" ;
            var target=this.document.forms[0].facility_name;
            var faclty_id=this.document.forms[0].facility_id;
/*
            sql="SELECT b.facility_name description,a.facility_id code FROM XP_PARAM_FOR_FACILITY a, "+
                    "  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(b.facility_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT a.facility_id code,b.facility_name description FROM XP_PARAM_FOR_FACILITY a, "+
                    "  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(b.facility_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

			argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
     //     argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                faclty_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                faclty_id.value=tcode;
            }
}// End of searchFacility

//********************************************************************************************
//function searchMessageType
//*******************************************************************************************

function searchMessageType(){

			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Message Type" ;
            var target=this.document.forms[0].mesg_type;
            var mesg_id=this.document.forms[0].mesg_type_id;
/*
            sql="SELECT description description,message_type code FROM XH_MESSAGE_TYPE "+
                    "   WHERE UPPER(message_type) LIKE UPPER(?) AND "+ 
                    "           UPPER(description) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT message_type code,description description FROM XH_MESSAGE_TYPE "+
                    "   WHERE UPPER(message_type) LIKE UPPER(?) AND "+ 
                    "           UPPER(description) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
    //      argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                mesg_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                mesg_id.value=tcode;
            }
}// End of searchMessageType

//********************************************************************************************
//function searchEventType
//*******************************************************************************************

function searchEventType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Event Type" ;
            var target=this.document.forms[0].event_type;
            var event_id=this.document.forms[0].event_type_id;
/*
            sql="SELECT EVENT_NAME description,EVENT_TYPE code FROM XH_EVENT_TYPE_LANG_VW "+
                    "   WHERE UPPER(EVENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(EVENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT distinct EVENT_TYPE code,EVENT_NAME description FROM XH_EVENT_TYPE_LANG_VW "+
                    "   WHERE UPPER(EVENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(EVENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
     //     argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                event_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                event_id.value=tcode;
            }
}// End of searchEventType

//********************************************************************************************
//function searchSegmentType
//*******************************************************************************************

function searchSegmentType(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Segment Type" ;
            var target=this.document.forms[0].segment_type;
            var segment_id=this.document.forms[0].segment_type_id;
/*
            sql="SELECT SEGMENT_NAME description,SEGMENT_TYPE code FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			sql="SELECT SEGMENT_TYPE code,SEGMENT_NAME description FROM XH_SEGMENT "+
                    "   WHERE UPPER(SEGMENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(SEGMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
      //    argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                segment_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            }
}// End of searchSegmentType

//********************************************************************************************
//function searchProtocolLink
//*******************************************************************************************

function searchProtocolLink(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Protocol Link" ;
            var target=this.document.forms[0].protocol_linkName;
            var prot_link_id=this.document.forms[0].protocol_link_id;
/*
            sql="SELECT PROTOCOL_LINK_NAME description,PROTOCOL_LINK_ID code FROM XH_PROTOCOL_LINK "+
                    "   WHERE UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND "+ 
                    "   UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?)"+
                    "           ORDER BY 1 ";
*/
            sql="SELECT PROTOCOL_LINK_ID code,PROTOCOL_LINK_NAME description FROM XH_PROTOCOL_LINK "+
                    "   WHERE UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND "+ 
                    "   UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?)"+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	//      argumentArray[4] = "2,1";
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                prot_link_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                prot_link_id.value=tcode;
            }
}// End of searchProtocolLink

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

//	alert("fn mdfy dg_code : "+obj.getAttribute('dg_code'));
//	alert("fn mdfy application_id : "+obj.getAttribute('application_id'));
//	alert("fn mdfy application_name : "+obj.getAttribute('application_name'));
//	alert("fn mdfy facility_id : "+obj.getAttribute('facility_id'));
//	alert("fn mdfy facility_name : "+obj.getAttribute('facility_name'));
//	alert("fn mdfy protocol_link_id : "+obj.getAttribute('protocol_link_id'));
//	alert("fn mdfy protocol_linkName : "+obj.getAttribute('protocol_linkName'));
	alert(this.document.forms[0].name);
	alert(parent.frames[1].document.forms[0].name);
	parent.frames[1].document.forms[0].dg_code.value = obj.getAttribute('dg_code');
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
//	var act = '../../eXH/jsp/DataGroupDetailsSelectMaster.jsp';
	var act = '../../eXH/jsp/DataGroupDetailsAddModify.jsp';
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
