function checkcurrdate(dates) 
{		
	var fromarray;
	var toarray;
	var date = dates.value;
	var d =  new Date(); 
	fromarray =date.split("/");
	var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
	var todt = new Date(d.getYear(),d.getMonth() + 1,d.getDate());	

	if(date.length > 0 )
	{		
		if(dates.name=='msg_dt1')
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{				
				alert(getMessage("XH1010",'XH'));
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}	

		if(dates.name=='msg_dt2')
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{				
				alert(getMessage("XH1010",'XH'));
				return false;
			}
			else 
				if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}	
		if(dates.name=='msg_date')
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{				
				alert(getMessage("XH1010",'XH'));
				return false;
			}
			else 
				if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}	
		else
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{				
				alert(getMessage("XH1010",'XH'));
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
			{
				return true;
			}
		}
	}
	else return true;	
}

function isAfterCurrDate(obj)
{
	var date = obj.value;
	var locale = document.getElementById("locale").value;	

	if(isValidDate(obj) && date.length > 0 )
	{
		if(!isBeforeNow(date,'DMY',locale))
		{
			alert(getMessage("XH1010",'XH'));
			obj.value = "";
			obj.focus();
			return false;
		}
		else
		{
			if(!compareDates())
			{
				obj.value = "";
				obj.focus();
				return false;
			}
		}
	}
}

function isValidDate(obj)
{	
	var date = obj.value;
	var locale = document.getElementById("locale").value;

	if(date.length > 0 )
	{
		if(!validDate(date,'DMY',locale))
		{
			var msg = getMessage("INVALID_VALUE",'COMMON');
			msg = msg.replace('#','Date Format');
			alert(msg);

			obj.value = "";
			obj.focus();
			return false;
		}
		else
		{
			return true;
		}
	}
}

//**********************************************COMPARE DATE*********************************************
function compare(date1,date2) 
{
	var fromarray;
	var toarray;
	var frmdat = date1.value;
	var todat = date2.value;
	var d = new Date(); 
	fromarray = frmdat.split("/");
	toarray = todat.split("/");
	var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
	var todt = new Date(toarray[2],toarray[1],toarray[0]);	

	if((frmdat.length > 0) && (todat.length > 0))
	{
		if(Date.parse(todt) < Date.parse(fromdt))
		{	
			alert(getMessage("XH1009",'XH'));
			return false;
		}
		else 
		{
			if(Date.parse(todt) >= Date.parse(fromdt)) 
			return true;
		}
	}	
	else return true;
}
//********************************************OPEN RESULT PAGE*****************************************************
function func1()
{  
	module = document.forms[0].interface_module.value;	
	sub_module=document.forms[0].sub_module.value;	
	
	if(module == "")
	{		
		alert(getMessage('XH1034','XH'));	
		document.forms[0].interface_module.focus();
		return false;
	}
	if(sub_module == "")
	{
		alert(getMessage('XH1034','XH'));	
		document.forms[0].sub_module.focus();
		return false;
	}
	comm_mode = document.forms[0].comm_mode.value;
	dispMode = document.forms[0].dispMode.value;	
	
	if(comm_mode == "outbound")
	{
		this.document.forms[0].Rule.value='O';
		if(dispMode == "display")
		{
			this.document.forms[0].action='../../eXH/jsp/ViewEventsOutboundDtlTest1.jsp';
		}
		else
		{
			this.document.forms[0].action='../../servlet/eXH.GenerateOutboundEventsToXLServlet';
		}
	}
	else if(comm_mode == "inbound")
	{
		this.document.forms[0].Rule.value='I';	
		if(dispMode == "display")
		{
			this.document.forms[0].action='../../eXH/jsp/ViewEventsInboundDtlTest1.jsp';		
		}
		else
		{
			this.document.forms[0].action='../../servlet/eXH.GenerateInboundEventsToXLServlet';
		}
	}
	else if(comm_mode == "InterActive")
	{
		this.document.forms[0].Rule.value='I';	
		this.document.forms[0].action='../../eXH/jsp/ViewEventsInteractiveDtlTest1.jsp';
	}
	this.document.forms[0].submit();
	document.forms[0].interface_module.value = module;
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

//********************************************Change Protocol Value**************************************************
function changeProtocolVal()
{
//	document.getElementById("protocol_link_id").value=document.getElementById("protocol_link_name").value;
}
//


//*****************************************************TABVALUE**************************************************
function tab_click(obj)
{
	var div1=document.getElementById("general");
	var div2=document.getElementById("auditional");
	var div3=document.getElementById("audit");
	var tab1=document.getElementById("search_tab");			 
	var tabspan1=document.getElementById("search_tab_tabspan");
	var tab2=document.getElementById("additional_tab");
	var tabspan2=document.getElementById("additional_tab_tabspan");
	var tab3=document.getElementById("audit_tab");
	var tabspan3=document.getElementById("audit_tab_tabspan");
	this.document.forms[0].tabValue.value=obj;

	if(obj == 'search_tab')
	{  					
		tab1.className='tabClicked';				
		tabspan1.className='tabSpanclicked';				
		tab2.className='tabA';
		tabspan2.className='tabAspan';
		tab3.className='tabA';
		tabspan3.className='tabAspan';

		div1.style.display='block';
		div2.style.display='none';
		div3.style.display='none';
	}
	if(obj == 'additional_tab')
	{
		tab1.className='tabA';
		tabspan1.className='tabAspan';
		tab2.className='tabClicked';
		tabspan2.className='tabSpanclicked';
		tab3.className='tabA';
		tabspan3.className='tabAspan';

		div1.style.display='none';
		div2.style.display='block';
		div3.style.display='none';
	}
	if(obj == 'audit_tab')
	{
		tab1.className='tabA';
		tabspan1.className='tabAspan';
		tab2.className='tabA';
		tabspan2.className='tabAspan';
		tab3.className='tabClicked';
		tabspan3.className='tabSpanclicked';

		div1.style.display='none';
		div2.style.display='none';
		div3.style.display='block';
	}

//	parent.f_query_add_mod.location.href='../../eXH/jsp/ViewEventsOutboundHeader.jsp';
//	parent.messageFrame.location.href='../../eCommon/html/blank.html';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

//*******************************************************************************************************************
function onChangeApplication()
{	
/*	var function_id=parent.document.getElementById("function_id").value;
	document.getElementById("function_id").value=function_id;
	var act="../../eXH/jsp/ViewEventsOutboundHeader.jsp";
	this.document.forms[0].action=act;
//	this.document.forms[0].target="f_query_header";
	this.document.forms[0].submit();
*/
	locale = document.getElementById("locale").value;
	moduleID = document.getElementById("sub_module").value;
	var functionID = document.getElementById("function_id").value;
	applicationID  = document.getElementById("applnname").options[document.getElementById("applnname").selectedIndex].value;	
//	alert("applicationID : "+applicationID);
//	alert("moduleID : "+moduleID);
	var commMode = document.getElementById("comm_mode").value;
																		  
	if(commMode == "inbound") commMode = "I";
	else commMode = "O";
//	alert("commMode : "+commMode);

	queryEventType = "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type = '"+commMode+"' OR me.communication_type = '*') AND M.APPLICATION_ID = '"+applicationID+"' AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'"+
					" AND m.event_type IN (SELECT EVENT_TYPE FROM XH_DATA_GROUP_DETAIL WHERE DATA_GROUP_ID IN "+
					" (SELECT DATA_GROUP_ID FROM xh_protocol_link xpl,xh_protocol xp WHERE xp.protocol_id=xpl.protocol_id and xp.INTERFACE_MODULE_ID='"+moduleID+"'))";
	queryFacility = "SELECT DISTINCT A.FACILITY_ID code, s.facility_name name FROM XH_DATA_GROUP_DETAIL a, sm_facility_param_lang_vw s  WHERE s.LANGUAGE_ID='"+locale+"' AND a.facility_id = s.facility_id AND a.application_id = NVL('"+applicationID+"', application_id) ";
		eval(sendRequest(queryEventType,'eventtype','All',"both"));
	if(functionID =='XH_J_ADMINISTER_INTRC_EVENTS'){
//		alert("ADMINISTER_INTRC_EVENTS");																				   
		queryEventType	= "SELECT DISTINCT me.EVENT_TYPE code, me.EVENT_NAME name FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me	 WHERE me.LANGUAGE_ID='"+locale+"' AND (me.communication_type ='"+commMode+"' OR me.communication_type = '*')	  AND M.APPLICATION_ID = '"+applicationID+"' AND m.event_TYPE = ME.EVENT_TYPE AND m.event_type != 'A19'";
		eval(sendRequest(queryEventType,'eventtype','All',"both"));   
		 //queryFacility = "SELECT s.FACILITY_ID code, s.facility_name name FROM sm_facility_param s  WHERE s.LANGUAGE_ID='"+locale+"' "; 
	//	eval(sendRequest(queryFacility,'facility','All')); 		
	}



	if(functionID == "XH_J_ADMINISTER_EVENTS" || functionID == "XF_J_ADMINISTER_EVENTS" || functionID == "XI_J_ADMINISTER_EVENTS")
	{		
		eval(sendRequest(queryFacility,'facility','All'));					 
	}
																													   

}
//*******************************************************************************************************************
function populateApplication()
{
	var selectApp=document.getElementById("applnname");
	for(var i=0;i<selectApp.options.length;i++)
	{	
		if(selectApp.options[i].value=='<%=applicationId%>')
		{
			selectApp.options[i].selected=true;
		}
	}
}
//****************************************************************************************************************
async function searchProtocolID(){     		
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

//****************************************************************************************************************

function onChangeCommMode(obj)
{
/*	var mod_name	=	obj.value;
	mod_name = mod_name.substring(mod_name.indexOf("_")+1,mod_name.length);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";	
	xmlStr += " base_unit=\""+mod_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AjaxUtil.jsp?func_mode=setTables",false);	
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);	
*/		
	locale = document.getElementById("locale").value;	
	moduleID = obj.options[obj.selectedIndex].value;	
	subModuleQuery = "SELECT INTERFACE_MODULE_ID code, INTERFACE_DESC name FROM XH_INTERFACE WHERE MODULE_ID='"+moduleID+"'";
	eval(sendRequest(subModuleQuery,'sub_module',getLabel("Common.defaultSelect.label",'common')));
}
function clearOptions()	{ 
	var list_obj	=document.forms[0].sub_module;
	var len =list_obj.options.length;
	for(var i=0;i<len;i++) {
		list_obj.remove("sub_module");
	}

	var tp = getLabel("Common.defaultSelect.label",'common');
	var opt = document.createElement("OPTION");
	opt.text = tp ;
	opt.value = "" ;
	list_obj.add(opt);
}

function addOption(id,desc)	
{ 
	var element = document.createElement('OPTION');
	element.value		=  '_'+id ;
	element.text		= desc ;
	document.forms[0].sub_module.add(element);
}

function validateFields()
{
	var flag=true;
	flag=checkcurrdate(document.forms[0].msg_dt1);
	if(flag)
	{
		flag=checkcurrdate(document.forms[0].msg_dt2);
	}
	else
	{
		document.forms[0].msg_dt1.focus();
		return;
	}	
	if(flag)
	{		
		flag=checkcurrdate(document.forms[0].msg_date);
	}
	else
	{
		document.forms[0].msg_dt2.focus();
		return;
	}
	if(flag)
	{		
		flag=checkcurrdate(document.forms[0].last_processed_date);
	}
	else
	{		
		document.forms[0].msg_date.focus();				   
		return;
	}
	if(flag)
	{		
		flag=checkcurrdate(document.forms[0].last_processed_date);
	}																		   
	else
	{
		document.forms[0].last_processed_date.focus();				   
		return;
	}
	if(flag)
	{		
		flag=checkcurrdate(document.forms[0].modifieddate);
	}																		   
	else
	{
		document.forms[0].modifieddate.focus();				   
		return;
	}
	if(flag)
	{		
		flag=checkcurrdate(document.forms[0].addeddate);
	}
	else
	{
		document.forms[0].modifieddate.focus();				 
		return;
	}
	if(flag)
	{
		flag=compare(document.forms[0].msg_dt1,document.forms[0].msg_dt2); 
	}
	else
	{
		document.forms[0].addeddate.focus();					 
		return;
	}
	
	if(flag)
	{		
		flag=func1();		
	}
}

function compareDates()
{
	locale = document.getElementById("locale").value;
	msg_dt1 = document.forms[0].msg_dt1.value;
	msg_dt2 = document.forms[0].msg_dt2.value;

	if(msg_dt1.length > 0 && msg_dt2.length > 0)
	{
		if(!isBefore(msg_dt1,msg_dt2,'DMY',locale))
		{
			alert(getMessage("XH1009",'XH'));
			return false;
		}
		else
		{																	   
			return true;
		}
	}
	else
	{
		return true;
	}
}
function hotStateImage(obj)
{	
	obj.className = 'linkClass2';
}

function restorePrevState(obj)
{
	obj.className = 'linkClass1';

}

function submitFormOnEnter()
{
	lockKey(); // eCommon method
	var keyPressed = event.keyCode;
	if(keyPressed == 13) func1();
}

