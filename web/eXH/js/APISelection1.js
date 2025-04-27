//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{
	
//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
window.f_query_add_mod.location.href="../../eXH/jsp/APIbasedInboundSelectMaster.jsp";		
window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
	/*
		//window.commontoolbarFrame.document.forms[0].apply.style.display='none';
		window.f_query_add_mod.location.href="../../eXH/jsp/APIbasedInboundQueryCriteria.jsp";		
		window.messageFrame.location.href="../../eCommon/html/blank.html";
*/
}
//********************************************************************************************
//FUNCTION DELETE
//********************************************************************************************
function deleterecord()
{
//	alert("deleterecord");
//	   if(!frames[1].document.APIbased_Inb_Select){		
			if(frames[2].document.APIbased_Inb_AddMod){
				window.f_query_add_mod_detail.document.forms[0].act_mode.value = 'D';
//				alert("APIbased_Inb_AddMod del");
				apply();
			}
			else if(frames[1].document.APIbased_Inb_Select){
				window.f_query_add_mod.document.forms[0].act_mode.value = 'D';
//				alert("APIInb_Select del");
				apply();
			}
//		}
		else{
			window.commontoolbarFrame.document.location.reload();
		}
}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{

	if(frames[1].document.APIbased_Inb_Select){

	var fields = new Array (  
					      frames[1].document.forms[0].application_name,
						  frames[1].document.forms[0].facility_name,
						  frames[1].document.forms[0].event_type,
						  frames[1].document.forms[0].segment_type,
						  frames[1].document.forms[0].inboundapi_name);
	
	var names = new Array ( 
						getLabel("eXH.Application.Label","XH"),
						getLabel("eXH.Facility.Label","XH"),
						getLabel("eXH.EventType.Label","XH"),
						getLabel("eXH.SegmentType.Label","XH"),
						getLabel("eXH.InboundAPI.Label","XH"));

	if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
   
	}else
		{  
		  if(!frames[2].document.APIbased_Inb_AddMod){
				if(frames[1].document.forms[0].act_mode.value='D'){
					alert("Del API Inb Hdr Rcrd");
				}
				else{
					alert(" Subm API Inb Hdr Pg");
				}

//			window.f_query_add_mod.document.forms[0].submit();
		  }

		  else if(frames[2].document.APIbased_Inb_AddMod){

		  var fields = new Array (  
					      frames[2].document.forms[0].arg_serial_no,
						  frames[2].document.forms[0].arg_id,
						  frames[2].document.forms[0].arg_name,
						  frames[2].document.forms[0].element_pos,
  					      frames[2].document.forms[0].element_val);
	
		  var names = new Array ( 
						getLabel("eXH.ArgSerialNo.Label","XH"),
						getLabel("eXH.ArgID.Label","XH"),
						getLabel("eXH.ArgName.Label","XH"),
						getLabel("eXH.ElementPos.Label","XH"),
						getLabel("eXH.ElementVal.Label","XH"));
  
		if(!f_query_add_mod_detail.checkFieldsofMst( fields, names, messageFrame))
		{
   
		}else
			{  
				if(frames[2].document.forms[0].act_mode.value='D'){
					alert("Del API Inb Dtl Rcrd");
				}
				else{
					alert(" Subm API Inb Detl Pg");
				}
//			window.f_query_add_mod.document.forms[0].submit();
			}
		}
	   }
	}

//	alert("97");

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
//function funAdd
//*******************************************************************************************
function funAdd()
{
//	alert("funAdd API");
//	alert("Loc : "+parent.f_query_add_mod_detail.location);
	alert("141");
	window.f_query_add_mod.location.href="../../eXH/jsp/framcon123.jsp";	
	
}

//********************************************************************************************
//function funSearch
//*******************************************************************************************
function funSearch()
{
//	alert("funSearch API Based");
//	alert("Loc : "+parent.f_query_add_mod_detail.location);
	parent.f_query_add_mod_detail.location.href="../../eXH/jsp/APIbasedInboundSearchResult.jsp";	
	parent.f_query_add_mod_detail.location.href="../../eXH/jsp/APIbasedInboundQueryResult.jsp";		
}

//********************************************************************************************
//function searchApplication
//*******************************************************************************************

function searchApplication(){
    
		alert("APISelection1");
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
         alert(argumentArray);
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
            var appl_id=this.document.forms[0].application_id.value;
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

			//alert("appl_id : "+appl_id);
/*
			sql="SELECT EVENT_TYPE,EVENT_NAME FROM XH_EVENT_TYPE WHERE EVENT_TYPE IN "+
					"	(SELECT EVENT_TYPE FROM XH_APPLICATION_EVENT_TYPE WHERE APPLICATION_ID='"+appl_id+"') "+
				    "   AND UPPER(EVENT_TYPE) LIKE UPPER(?) AND "+ 
                    "           UPPER(EVENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
*/
			alert("sql : "+sql);

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
                segment_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                segment_id.value=tcode;
            }
}// End of searchSegmentType


//********************************************************************************************
//function searchInboundAPI
//*******************************************************************************************

function searchInboundAPI(){

            var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Inbound API" ;
            var target=this.document.forms[0].inboundapi_name;
            var inbound_id=this.document.forms[0].inboundapi_id;

            sql="SELECT API_DESC description,API_CODE code FROM XH_API "+
                    "   WHERE API_TYPE='I' AND UPPER(API_CODE) LIKE UPPER(?) AND "+ 
                    "           UPPER(API_DESC) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
            argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                inbound_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                inbound_id.value=tcode;
            }
}// End of searchInboundAPI

//********************************************************************************************
//function searchElement
//*******************************************************************************************

function searchElement(){
 //   alert("searchElement");
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Element" ;
            var target=this.document.forms[0].element_pos;
            var elmnt_id=this.document.forms[0].element_id;

            sql="SELECT element_id code,element_name description FROM XH_ELEMENT_CROSSREF "+
                    "   WHERE UPPER(element_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(element_name) LIKE UPPER(?) "+
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
                elmnt_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                elmnt_id.value=tcode;
            }
}// End of searchElement

//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	
	// #MOD#01
	var act = '../../eXH/jsp/APIbasedInboundQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	alert("frm1 : "+parent.frames[1].document.forms[0].name);
	alert("frm2 : "+this.document.forms[0].name);

	parent.frames[1].document.forms[0].application_id.value=obj.getAttribute('application_id');
	parent.frames[1].document.forms[0].application_name.value=obj.getAttribute('application_name');
	parent.frames[1].document.forms[0].facility_id.value=obj.getAttribute('facility_id');
	parent.frames[1].document.forms[0].facility_name.value=obj.getAttribute('facility_name');
	parent.frames[1].document.forms[0].event_type_id.value=obj.getAttribute('event_type_id');
	parent.frames[1].document.forms[0].event_type.value=obj.getAttribute('event_type');
	parent.frames[1].document.forms[0].segment_type_id.value=obj.getAttribute('segment_type_id');
	parent.frames[1].document.forms[0].segment_type.value=obj.getAttribute('segment_type');
	parent.frames[1].document.forms[0].inboundapi_id.value=obj.getAttribute('inboundapi_id');
	parent.frames[1].document.forms[0].inboundapi_name.value=obj.getAttribute('inboundapi_name');

	this.document.forms[0].arg_serial_no.value = obj.getAttribute('arg_serial_no');
	this.document.forms[0].arg_id.value = obj.getAttribute('arg_id');
	this.document.forms[0].arg_name.value = obj.getAttribute('arg_name');
	this.document.forms[0].element_pos.value = obj.getAttribute('element_pos');
	this.document.forms[0].element_val.value = obj.getAttribute('element_val');

	var act = '../../eXH/jsp/APIbasedInboundAddModify.jsp';
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
