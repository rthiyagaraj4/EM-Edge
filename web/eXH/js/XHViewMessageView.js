function searchProtocolID(){    		
			var tdesc="";
            var tcode="";
			var appID=document.getElementById("applnname").value;
			var commMode=document.getElementById("comm_mode").value;
			if(commMode == "outbound") commMode="O";
			else if(commMode == "inbound") commMode="I";
			
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("eXH.Gateway.Label",'XH');
            var target=this.document.forms[0].protocol_link_name;
			var id=this.document.forms[0].protocol_link_id;

            sql="SELECT PROTOCOL_LINK_ID code,PROTOCOL_LINK_NAME description FROM XH_PROTOCOL_LINK "+
                    "   WHERE UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND "+ 
                    "   UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) AND "+
					"	PROTOCOL_ID IN (SELECT PROTOCOL_ID FROM xh_protocol WHERE PROTCOL_MODE='"+commMode+"') ";
			if(appID != "")
			{
				sql=sql+" AND application_id ='"+appID+"'";
			}
			sql=sql+" ORDER BY 1";
			
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = "2"  ;
            argumentArray[7] = "DESC_CODE" ;
         
            retVal = await CommonLookup( tit, argumentArray );			
            
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			id.value=arr[0];
			
			if(arr[1] == undefined)	target.value="";
			else target.value=arr[1];            
}// End of searchProtocolLink

/*function onChangeApplication()
{	

	locale = document.getElementById("locale").value;		    
	moduleID = document.getElementById("sub_module").value;
	var functionID = document.getElementById("function_id").value;
	applicationID  = document.getElementById("applnname").options[document.getElementById("applnname").selectedIndex].value;	
	var commMode = document.getElementById("comm_mode").value;

	if(commMode == "inbound") commMode = "I";
	else commMode = "O";
	
	queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = '"+commMode+"' OR me.communication_type = '*') AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"+
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
					" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";
	queryFacility = "SELECT DISTINCT A.FACILITY_ID code, s.facility_name name FROM XH_DATA_GROUP_DETAIL a, sm_facility_param_lang_vw s  WHERE s.LANGUAGE_ID='"+locale+"' AND a.facility_id = s.facility_id AND a.application_id = NVL('"+applicationID+"', application_id) ";
	eval(sendRequest(queryEventType,'eventtype','All',"both"));	  

	  alert(queryEventType);

	if(functionID == "XH_J_MESSAGE_VWR_SIMULATOR" )		   
	{															    
		eval(sendRequest(queryFacility,'facility','All'));
	}
} */																  
function onChangeApplication()
{	
		
	locale = document.getElementById("locale").value;
	moduleID = document.getElementById("sub_module").value;
	var functionID = document.getElementById("function_id").value;
	applicationID  = document.getElementById("applnname").options[document.getElementById("applnname").selectedIndex].value;	
	var commMode = document.getElementById("comm_mode").value;

	if(applicationID=='' || applicationID==null)
	{
		document.getElementById("eventtype").disabled=true; 
	}
	 else
	{
		  document.getElementById("eventtype").disabled=false;
	}



	if(commMode == "inbound") commMode = "I";
	else commMode = "O";
	
	queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = '"+commMode+"' OR me.communication_type = '*') AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"+
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
					" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";
	queryFacility = "SELECT DISTINCT A.FACILITY_ID code, s.facility_name name FROM XH_DATA_GROUP_DETAIL a, sm_facility_param_lang_vw s  WHERE s.LANGUAGE_ID='"+locale+"' AND a.facility_id = s.facility_id AND a.application_id = NVL('"+applicationID+"', application_id) ";
	 
	eval(sendRequest(queryEventType,'eventtype','-------Select------',"both"));	  	   
	if(functionID == "XH_J_ADMINISTER_EVENTS" || functionID == "XF_J_ADMINISTER_EVENTS" || functionID == "XI_J_ADMINISTER_EVENTS")
	{		
		eval(sendRequest(queryFacility,'facility','All'));		  
	}				     										
}																    
										 

async function funClick()									    
{
			  var applicationName=document.getElementById("applnname").value;
	var applicationID=document.getElementById("applnname").options[document.getElementById("applnname").selectedIndex].value; 
	var  facilityID = document.getElementById("facility").options[document.getElementById("facility").selectedIndex].value;
   var  event_type=document.getElementById("eventtype").options[document.getElementById("eventtype").selectedIndex].value;

	var facilityName= document.getElementById("facility").value;		  
	var fields = new Array (this.document.forms[0].applnname,
					    this.document.forms[0].facility,this.document.forms[0].protocol_link_name,this.document.forms[0].eventtype,this.document.forms[0].interface_module); 
var names = new Array ( 
						getLabel("Common.Application.label","Common"),
						getLabel("Common.facility.label","Common"),getLabel("eXH.Gateway.Label","XH"),getLabel("Common.EventType.label","Common"),getLabel("eXH.InterfaceDomain.Label","Common"));
	if(!checkFields( fields, names, parent.messageFrame))													    
	{
																								 			   
	} 																		 
	else												 
	{
		var dialogHeight = "45vh";			    
		var dialogWidth  = "55vw";
		var dialogTop    = "230";
		var dialogLeft   = "230";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

 
	var arguments  =new Array();
	var url;
													   								  					 																							 
	url = "../../eXH/jsp/XHViewMessagSimulatorTreeMain.jsp?applicationName="+applicationName+
				"&applicationID="+applicationID+									    
				"&facilityID="+facilityID+"&facilityName="+facilityName+"&protocol_link_id="+document.forms[0].protocol_link_id.value+"&sub_module="+moduleID+"&protocolMode="+document.forms[0].comm_mode.value+"&event_type="+event_type; 
 
	await window.showModalDialog(url,arguments,features);							 
																			    
	}
}				
function onChangeCommMode1()
{
	var comm_mode = document.getElementById("comm_mode").value;
																																														 

	var moduleID = document.getElementById("sub_module").value;

	applicationID  = document.getElementById("applnname").options[document.getElementById("applnname").selectedIndex].value;
	locale = document.getElementById("locale").value;

	var flag = "false";

	document.getElementById("protocol_link_id").value = "";
	document.getElementById("protocol_link_name").value = "";

	if(comm_mode == "outbound")
	{
		

	//	if(msgStatus == "F") document.getElementById("msg_status").options[4] = new Option("Failed","F",false, true);
	//	else document.getElementById("msg_status").options[4] = new Option("Failed","F",false, false);		

		

		var queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me "+
					" WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = 'O' OR me.communication_type = '*')"+
					" AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) "+
					" AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"+
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
					" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";

		eval(sendRequest(queryEventType,'eventtype',getLabel("Common.all.label","common"),"both"));
		
	//	document.getElementById("inMsgStatusDiv").style.display="none";
	//	document.getElementById("outMsgStatusDiv").style.display="block";
		
	}
	if(comm_mode == "inbound")
	{
														 

		var queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me "+
					" WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = 'I' OR me.communication_type = '*')"+
					" AND M.APPLICATION_ID = NVL('"+applicationID+"',M.APPLICATION_ID) "+
					" AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"+
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
					" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";

		eval(sendRequest(queryEventType,'eventtype',getLabel("Common.all.label","common"),"both"));

	//	document.getElementById("outMsgStatusDiv").style.display="none";
	//	document.getElementById("inMsgStatusDiv").style.display="block";
	}
	
}																	 									 
