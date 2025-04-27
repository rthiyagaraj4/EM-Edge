//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{
	
//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
//window.f_query_add_mod.location.href="../../eXH/jsp/APIbasedInboundSelectMaster.jsp";		
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
	

window.frames[2].frames[0].Remove1();
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
f_query_add_mod_detail.frames[0].location.href="../../eCommon/html/Left.html";
		f_query_add_mod_detail.frames[1].location.href="../../eCommon/html/RearrangementLayertools.html";
		f_query_add_mod_detail.frames[2].location.href="../../eCommon/html/dummy.html";

	}
}

//********************************************************************************************
//FUNCTION arrangeTree 
//********************************************************************************************

function arrangeTree(){
//	alert("arrangeTree");
//		parent.f_query_add_mod_detail.frames[0].location.href="../../eCommon/html/Left.html";
//		parent.f_query_add_mod_detail.frames[1].location.href="../../eCommon/html/dummy.html";
	

//		parent.frames[1].frames[0].location.href="../../eCommon/html/Left.html";   
//	 	parent.frames[1].frames[1].location.href="../../eCommon/html/dummy.html";  
}
//********************************************************************************************
//FUNCTION arrangeTree1 
//********************************************************************************************

function arrangeTree1(){	
//		alert("arrangeTree111");
parent.f_query_add_mod_detail.frames[2].location.href="../../eCommon/html/dummy.html";
	 	//parent.f_query_add_mod_tree_detail.frames[1].location.href="../../eXH/jsp/RearrangementLayerRightNavigator.jsp";
}

//********************************************************************************************
//function qrySystUsrDefStr
//*******************************************************************************************
function qrySystUsrDefStr(obj) {
		var appl_name	=	document.forms[0].application_id.value;
		var event_type	=	document.forms[0].event_type_id.value;
	
	

		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " appl_name=\""+appl_name+"\"";
		xmlStr += " event_type=\""+event_type+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","RearrangementLayerQryStructures.jsp?func_mode=qryStructures",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);	
		//parent.f_query_add_mod_detail.frames[0].location.href="../../eXH/jsp/RearrangementLayerleftNavigator.jsp";
       // parent.f_query_add_mod_detail.frames[1].location.href="../../eXH/jsp/RearrangementLayertools.jsp";
		//parent.f_query_add_mod_detail.frames[2].location.href="../../eXH/jsp/RearrangementLayerRightNavigator.jsp";

		parent.f_query_add_mod_detail.frames[0].location.href="../../eXH/html/Leftdervation.html";
		parent.f_query_add_mod_detail.frames[1].location.href="../../eXH/html/RearrangementLayertoolsdervatio.html";
		parent.f_query_add_mod_detail.frames[2].location.href="../../eXH/html/dummyderivation.html";
	
}


//********************************************************************************************
//function setSystUsrDefStr
//*******************************************************************************************

function setSystUsrDefStr(systDefStr,usrDefStr)	{ 

		
	if(usrDefStr.length>0)
	{
    var inputdata=Trim(usrDefStr);
    var inp=inputdata.substring(0,(inputdata.length-3));
	f_query_add_mod.document.forms[0].SysDefStr.value = unescape(systDefStr);
	f_query_add_mod.document.forms[0].SystemDefind_id.value=unescape(systDefStr);
	f_query_add_mod.document.forms[0].UsrDefStr.value =  unescape(inp);



   }
   else
	{
    f_query_add_mod.document.forms[0].SysDefStr.value = unescape(systDefStr);
    var k1=systDefStr.indexOf("|");
    var input=systDefStr.substring(0,(k1));
	f_query_add_mod.document.forms[0].UsrDefStr.value = unescape(input);
	}


//../../eXH/html/Leftdervation.html
//../../eXH/html/RearrangementLayertoolsdervatio.html
//../../eXH/html/dummyderivation.html



/*window.parent.f_query_add_mod_detail.frames[0].location.href="../../eXH/html/Leftdervation.html";
		window.parent.f_query_add_mod_detail.frames[1].location.href="../../eXH/html/RearrangementLayertoolsdervatio.html";
		window.parent.f_query_add_mod_detail.frames[2].location.href="../../eXH/html/dummyderivation.html";*/
//parent.f_query_add_mod_detail.frames[0].location.href="../../eCommon/html/Left.html";
//	parent.f_query_add_mod_detail.frames[1].location.href="../../eCommon/html/dummy.html";
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

            sql="SELECT application_id code,application_name description FROM XH_APPLICATION "+
                    "   WHERE UPPER(application_id) LIKE UPPER(?) AND "+ 
                    "           UPPER(application_name) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
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
           //f_query_add_mod.document.forms[0].event_type.focus();

}// End of searchEventType


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
function Trim(str)
{ 
while(str.charAt(0) == (" ") )
  {  str = str.substring(1);
  }
  while(str.charAt(str.length-1) == "," )
  {  str = str.substring(0,str.length-1);
  }
  return str;
}
