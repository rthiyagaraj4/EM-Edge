//********************************************************************************************
//function protocolLinkSearch
//*******************************************************************************************
var mainInUse="Y"; // Variable used for enabled check box

async function protocolLink(protocolID,protocolName,applicationID,proprotocolid,protocolMode){	
	var formObj				= document.frames.Master_client_comm_form;
	var appID = document.getElementById(applicationID).value;
	
	

	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
	var strQry				= "SELECT PROTOCOL_LINK_ID code,PROTOCOL_LINK_NAME description FROM XH_PROTOCOL_LINK "+
								"   WHERE UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) AND "+ 								
								"	UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND UPPER(APPLICATION_ID)='"+appID+"' AND "+
								"	PROTOCOL_ID IN (SELECT protocol_id FROM xh_protocol WHERE protcol_mode='"+protocolMode+"') "+
								"	ORDER BY 1 ";
//	argumentArray[0]		= formObj.strQry.value;
	argumentArray[0]		= strQry;
//	alert("srch Input Api Qry : "+argumentArray[0]);
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "2,1";
//	argumentArray[5]		= document.getElementById(applicationID).value;
	argumentArray[5]		= document.getElementById(protocolName).value;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( "Protocol Link", argumentArray );

	if(retVal != null && retVal != "" )  {
		document.getElementById(protocolName).value	= retVal[1] ;							    
		document.getElementById(protocolID).value = retVal[0];
	//	formObj.protocolLinkVal.disabled	=  true;
		formObj.protocolLinkVal.disabled	=  true;

		 getProtoclId(document.getElementById(protocolID).value,appID,proprotocolid);	 


	}
}			  
 function setProtocolId(proc_id,proprotocolidname) {	  
		document.getElementById(proprotocolidname).value=proc_id;   
	
 }

function getProtoclId(proc_id,appID,proprotocolidname) {
		var proc_id	=	proc_id;												     
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " base_unit1=\""+proc_id+"\"";
		xmlStr += " base_unit2=\""+appID+"\"";	   
		xmlStr += " base_unit3=\""+proprotocolidname+"\"";	   		  
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open("POST","CommunicationClientGetProtocol.jsp?func_mode=getProtocol",false);		   
		xmlHttp.send(xmlDoc);		

		eval(xmlHttp.responseText);	
}


	function setFrames(msg,protocolName,fieldName,checkField)
	{

		
		 parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;	
		 document.getElementById(checkField).checked=false;
		 document.getElementById(checkField).value='N';
			document.getElementById(fieldName).style.display = "none";
		  fieldName = fieldName + "_nodisp";	
		 document.getElementById(fieldName).style.display = "block";
	}

//********************************************************************************************
//FUNCTION CREATE()
//********************************************************************************************
function create()
{
	window.f_query_add_mod.location.href="../../eXH/jsp/CommunicationClientMaster.jsp?mode=I&locale=en";	
	window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
//********************************************************************************************
//FUNCTION QUERY()
//********************************************************************************************
function query()
{
	window.f_query_add_mod.location.href="../../eXH/jsp/CommunicationSettingsForClientQueryCriteria.jsp";
	window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
		
}

//********************************************************************************************
//FUNCTION deleterecord()
//********************************************************************************************
function deleterecord()
{
	window.f_query_add_mod.document.forms[0].tab_mode.value = 'D';
	apply();
}

//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{ 		
	// condition check to avoid script errors in the query criteria & result page.
	if((f_query_add_mod.document.forms[0] != null) && f_query_add_mod.document.forms[0].main_outbound_in_use) 
	{
		var fields;
		var names;
		var fieldsCount=0;
		var namesCount=0;

		outbound=f_query_add_mod.document.forms[0].id.value;
		inbound=f_query_add_mod.document.forms[0].inID.value;			

		fields = new Array ( f_query_add_mod.document.forms[0].client_id,f_query_add_mod.document.forms[0].client_name)
		names = new Array ( getLabel("Common.identification.label","Common"),getLabel("Common.name.label","Common"));
		fieldsCount=1;
		namesCount=1;

		outboundFlag=true;	
		inboundFlag=true;
		tempFlag=true;

		var tab1=window.f_query_add_mod.document.getElementById("out");
		var tabspan1=window.f_query_add_mod.document.getElementById("out_tabspan");
		var tab2=window.f_query_add_mod.document.getElementById("inb");
		var tabspan2=window.f_query_add_mod.document.getElementById("inb_tabspan");

		if(f_query_add_mod.document.forms[0].main_outbound_in_use.checked==true)
		{
			for(i=0;i<outbound;i++) // Check for any empty protocol link field
			{	 
				temp="out"+i;	
				if(f_query_add_mod.document.getElementById(temp).value == "")
				{
					fieldsCount=fieldsCount+1;
					namesCount=namesCount+1;

					fields[fieldsCount]=f_query_add_mod.document.getElementById(temp);				
					names[namesCount]=getLabel("eXH.ProtocolLink.Label","XH");				

					i=outbound;
					outboundFlag=false;
				}
			}
			
			for(i=0;i<outbound;i++) // Check for any empty Log dir field
			{	 
				temp="out"+i+"_reportOPDir";		
				outboundInUse = "out_out"+i;
				
				if(f_query_add_mod.document.getElementById(temp).value == "" &&
					f_query_add_mod.document.getElementById(outboundInUse).value == 'Y')
				{	
					fieldsCount=fieldsCount+1;
					namesCount=namesCount+1;

					fields[fieldsCount]=f_query_add_mod.document.getElementById(temp);
					names[namesCount] = getLabel('eXH.EnabledGateway.Label','XH');

					i=outbound;
				//	tempFlag=false;
					outboundFlag=false;
				}	 
			}
			if(!outboundFlag)
			{
				var out_disp=window.f_query_add_mod.document.getElementById("outbounddiv");
				var in_disp=window.f_query_add_mod.document.getElementById("inbounddiv");
				if(!f_query_add_mod.checkFields( fields, names, messageFrame))
				{
					out_disp.style.display='block';
					in_disp.style.display='none';
					tab1.className='tabClicked';
					tabspan1.className='tabSpanclicked';
					tab2.className='tabA';
					tabspan2.className='tabAspan';	
				}
			}
		}
		if(outboundFlag && f_query_add_mod.document.forms[0].main_inbound_in_use.checked==true)
		{
			flag=false;
			for(i=0;i<inbound;i++) // Check for any empty protocol link field
			{	 
				temp="in"+i;				
				if(f_query_add_mod.document.getElementById(temp).value == "")
				{
					fieldsCount=fieldsCount+1;
					namesCount=namesCount+1;

					fields[fieldsCount]=f_query_add_mod.document.getElementById(temp);				
					names[namesCount]=getLabel("eXH.ProtocolLink.Label","XH");				

					i=inbound;
					inboundFlag=false;
				}
			}
			for(i=0;i<inbound;i++)  // Check for any empty Log dir field
			{	 
				temp="in"+i+"_reportOPDir";			
				inboundInUse = "in_in"+i;
				
				if(f_query_add_mod.document.getElementById(temp).value == "" &&
					f_query_add_mod.document.getElementById(inboundInUse).value == 'Y')
				{	
					fieldsCount=fieldsCount+1;
					namesCount=namesCount+1;

					fields[fieldsCount]=f_query_add_mod.document.getElementById(temp);
					names[namesCount]=getLabel('eXH.EnabledGateway.Label','XH');

					i=inbound;	
					inboundFlag=false;
				}
			}
			if(!inboundFlag)
			{
				var out_disp=window.f_query_add_mod.document.getElementById("outbounddiv");
				var in_disp=window.f_query_add_mod.document.getElementById("inbounddiv");
				if(!f_query_add_mod.checkFields( fields, names, messageFrame))
				{
					out_disp.style.display='none';
					in_disp.style.display='block';

					tab2.className='tabClicked';
					tabspan2.className='tabSpanclicked';
					tab1.className='tabA';
					tabspan1.className='tabAspan';	
				}
			}
		}
		if(!f_query_add_mod.checkFields( fields, names, messageFrame))
		{  
			var out_disp=window.f_query_add_mod.document.getElementById("outbounddiv");
			var in_disp=window.f_query_add_mod.document.getElementById("inbounddiv");

			var tab1=window.f_query_add_mod.document.getElementById("out");
			var tabspan1=window.f_query_add_mod.document.getElementById("out_tabspan");
			var tab2=window.f_query_add_mod.document.getElementById("inb");
			var tabspan2=window.f_query_add_mod.document.getElementById("inb_tabspan");

			if(!outboundFlag)
			{
				out_disp.style.display='block';
				in_disp.style.display='none';
				tab1.className='tabClicked';
				tabspan1.className='tabSpanclicked';
				tab2.className='tabA';
				tabspan2.className='tabAspan';				
			}
			else if(!inboundFlag)
			{
				out_disp.style.display='none';
				in_disp.style.display='block';

				tab2.className='tabClicked';
				tabspan2.className='tabSpanclicked';
				tab1.className='tabA';
				tabspan1.className='tabAspan';
			}
		}
		else
		{
			window.f_query_add_mod.document.forms[0].submit();
		}
		
	/*	if(!f_query_add_mod.checkFields( fields, names, messageFrame))
		{			
		}
		else if(outboundFlag && inboundFlag)
		{
			window.f_query_add_mod.document.forms[0].submit();
		}
	*/
	}
	window.commontoolbarFrame.document.location.reload();	
}
//********************************************************************************************
//FUNCTION RESET()
//********************************************************************************************
function reset()
{			
	if(window.f_query_add_mod.document.forms[0])
	{
		window.f_query_add_mod.document.forms[0].reset();
		var inboundID = window.f_query_add_mod.document.forms[0].inID.value;
		var outboundID = window.f_query_add_mod.document.forms[0].id.value;
		
		for(i=0;i<outboundID;i++)
		{	
			var t = "out_out"+i+"_cb";
			var t1 = "out_out"+i+"_cb_nodisp";
					
			window.f_query_add_mod.document.getElementById(t).style.display = 'none';			
			window.f_query_add_mod.document.getElementById(t1).style.display = 'block';
		}
		for(i=0;i<inboundID;i++)
		{	
			var t = "in_in"+i+"_cb";
			var t1 = "in_in"+i+"_cb_nodisp";
					
			window.f_query_add_mod.document.getElementById(t).style.display = 'none';			
			window.f_query_add_mod.document.getElementById(t1).style.display = 'block';
		}

		// Check to avoid script errors in the query criteria & result page.
		if(f_query_add_mod.document.forms[0].main_outbound_in_use)	
		onLoadOfpage();
	}
}
//********************************************************************************************
//function funOnOutbound
//********************************************************************************************
function funOnOutbound()
{
	outbounddiv.style.display='block';
}
//********************************************************************************************
//function funOffOutbound
//********************************************************************************************

function funOffOutbound()
{
	outbounddiv.style.display='none';
}
//********************************************************************************************
//function funOnInbound
//********************************************************************************************

function funOnInbound()
{
	inbounddiv.style.display='block';
}
//********************************************************************************************
//function funOffInbound
//********************************************************************************************
function funOffInbound()
{
	inbounddiv.style.display='none';
}
//********************************************************************************************
//function validatecheckbox
//********************************************************************************************
function validatecheckbox(obj)
{
	var out_disp=document.getElementById("outbounddiv");
	var in_disp=document.getElementById("inbounddiv");

	document.getElementById("message").value = "";	     

	if(obj.checked==true)
	{ 
		obj.value="Y";
		mainInUse="N"
	}
	else 
	{	
		obj.value="N";
		mainInUse="N" // mainInUse="N" indicates check box is unchecked and will not again enabled in onLoadPage.
	}	
	onLoadOfpage();

}
//********************************************************************************************
//function onLoadOfpage
//********************************************************************************************
function onLoadOfpage()
{		
	if(window.f_query_add_mod)
	{			
		if (window.f_query_add_mod.document.forms[0].mode.value=='I' && mainInUse=="Y")
		{
			window.f_query_add_mod.document.forms[0].main_in_use.checked=true;
			window.f_query_add_mod.document.forms[0].main_in_use.value='Y';
		}
		mainInUse="Y";// mainInUse="N" indicates flow is coming from validatecheckbox and check box is unchecked.

		var out_disp=window.f_query_add_mod.document.getElementById("outbounddiv");
		var in_disp=window.f_query_add_mod.document.getElementById("inbounddiv");

		var tab1=window.f_query_add_mod.document.getElementById("out");
		var tabspan1=window.f_query_add_mod.document.getElementById("out_tabspan");
		var tab2=window.f_query_add_mod.document.getElementById("inb");
		var tabspan2=window.f_query_add_mod.document.getElementById("inb_tabspan");

		if(window.f_query_add_mod.document.forms[0].dmode.value=='null')
		{
			if(window.f_query_add_mod.document.forms[0].main_inbound_in_use.checked==true)
			{
				out_disp.style.display='none';
				in_disp.style.display='block';

				tab2.className='tabClicked';
				tabspan2.className='tabSpanclicked';
				tab1.className='tabA';
				tabspan1.className='tabAspan';
			}
			if(window.f_query_add_mod.document.forms[0].main_outbound_in_use.checked==true)
			{
				out_disp.style.display='block';
				in_disp.style.display='none';
				tab1.className='tabClicked';
				tabspan1.className='tabSpanclicked';
				tab2.className='tabA';
				tabspan2.className='tabAspan';
			}
		}

		if((window.f_query_add_mod.document.forms[0].main_inbound_in_use.checked==true)&&(window.f_query_add_mod.document.forms[0].dmode. value=='I'))
		{
			out_disp.style.display='none';
			in_disp.style.display='block';
			tab2.className='tabClicked';
			tabspan2.className='tabSpanclicked';
			tab1.className='tabA';		   
			tabspan1.className='tabAspan';
		}

		if((window.f_query_add_mod.document.forms[0].main_outbound_in_use.checked==true)&&(window.f_query_add_mod.document.forms[0].dmode. value=='O'))
		{
			out_disp.style.display='block';
			in_disp.style.display='none';
			tab1.className='tabClicked';
			tabspan1.className='tabSpanclicked';
			tab2.className='tabA';
			tabspan2.className='tabAspan';
		}

		if((window.f_query_add_mod.document.forms[0].main_outbound_in_use.checked==false)&&(window.f_query_add_mod.document.forms[0].main_inbound_in_use.checked==false))
		{
			out_disp.style.display='none';
			in_disp.style.display='none';
			tab1.className='tabA';
			tabspan1.className='tabAspan';
			tab2.className='tabA';
			tabspan2.className='tabAspan';
		}
	}
	else
	{
		if (this.document.forms[0].mode.value=='I' && mainInUse=="Y")
		{
			this.document.forms[0].main_in_use.checked=true;
			this.document.forms[0].main_in_use.value='Y';
		}
		mainInUse="Y";// mainInUse="N" indicates flow is coming from validatecheckbox and check box is unchecked.

		var out_disp=document.getElementById("outbounddiv");
		var in_disp=document.getElementById("inbounddiv");

		var tab1=document.getElementById("out");
		var tabspan1=document.getElementById("out_tabspan");
		var tab2=document.getElementById("inb");
		var tabspan2=document.getElementById("inb_tabspan");

		if(this.document.forms[0].dmode.value=='null')
		{
			if(this.document.forms[0].main_inbound_in_use.checked==true)
			{
				out_disp.style.display='none';
				in_disp.style.display='block';

				tab2.className='tabClicked';
				tabspan2.className='tabSpanclicked';
				tab1.className='tabA';
				tabspan1.className='tabAspan';
			}
			if(this.document.forms[0].main_outbound_in_use.checked==true)
			{
				out_disp.style.display='block';
				in_disp.style.display='none';
				tab1.className='tabClicked';
				tabspan1.className='tabSpanclicked';
				tab2.className='tabA';
				tabspan2.className='tabAspan';
			}
		}

		if((this.document.forms[0].main_inbound_in_use.checked==true)&&(this.document.forms[0].dmode. value=='I'))
		{
			out_disp.style.display='none';
			in_disp.style.display='block';
			tab2.className='tabClicked';
			tabspan2.className='tabSpanclicked';
			tab1.className='tabA';
			tabspan1.className='tabAspan';
		}

		if((this.document.forms[0].main_outbound_in_use.checked==true)&&(this.document.forms[0].dmode. value=='O'))
		{
			out_disp.style.display='block';
			in_disp.style.display='none';
			tab1.className='tabClicked';
			tabspan1.className='tabSpanclicked';
			tab2.className='tabA';
			tabspan2.className='tabAspan';
		}

		if((this.document.forms[0].main_outbound_in_use.checked==false)&&(this.document.forms[0].main_inbound_in_use.checked==false))
		{
			out_disp.style.display='none';
			in_disp.style.display='none';
			tab1.className='tabA';
			tabspan1.className='tabAspan';
			tab2.className='tabA';
			tabspan2.className='tabAspan';
		}
		parent.messageFrame.location.href="../../eXH/jsp/DisplayRefResult.jsp?message="+document.getElementById("message").value;
	}	
}
//********************************************************************************************
//function validatecheckbox1
//********************************************************************************************
function validatecheckbox1(obj,fieldName,repOPDir,protocolid,checkField)	   
{
	var fieldNamebase=fieldName;
	
	parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";	
	if(obj.checked==true)
    { 
	   obj.value="Y";
		temp = repOPDir+"1";
		document.getElementById(temp).value = document.getElementById(repOPDir).value;
		document.getElementById(fieldName).style.display = "block";
		fieldName = fieldName + "_nodisp";		
		document.getElementById(fieldName).style.display = "none";
		 verifyOffLineSeq(protocolid,fieldNamebase,checkField);
	}
	else 
	{	
	  obj.value="N";
		temp = repOPDir+"2";
		document.getElementById(temp).value = document.getElementById(repOPDir).value;
		document.getElementById(fieldName).style.display = "none";
		fieldName = fieldName + "_nodisp";	
		document.getElementById(fieldName).style.display = "block";
	}
	  
}
//********************************************************************************************
//function callJSPs
//********************************************************************************************

function callJSPs(str)
{
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	var tab1=document.getElementById("out");
    var tabspan1=document.getElementById("out_tabspan");
    var tab2=document.getElementById("inb");
    var tabspan2=document.getElementById("inb_tabspan");

	if (str=='out')
	{	
		tab1.className='tabClicked';
	    tabspan1.className='tabSpanclicked';
		tab2.className='tabA';
		tabspan2.className='tabAspan';
		funOffInbound();
		if(document.forms[0].main_outbound_in_use.checked==true)
		{			
			funOnOutbound();		 
		}
		else
		{	
			alert(getMessage( 'XH1006','XH' ));
			tab1.className='tabA';
	        tabspan1.className='tabAspan';			
		}
		
	}
	if (str=='inb')
	{				
		tab1.className='tabA';
		tabspan1.className='tabAspan';
		tab2.className='tabClicked';
		tabspan2.className='tabSpanclicked';

		funOffOutbound();

		if(document.forms[0].main_inbound_in_use.checked==true)
		{
			funOnInbound();
		}
		else
		{
			alert(getMessage( 'XH1005','XH'));
			tab2.className='tabA';
	        tabspan2.className='tabAspan';
		}
	}	
}						 

//********************************************************************************************
//function funSubmit
//********************************************************************************************
function funSubmit()
{
	var act = '../../eXH/jsp/CommunicationClientMaster.jsp?';
	this.document.forms[0].action = act;
	this.document.forms[0].target='f_query_add_mod';
	this.document.forms[0].submit();
}
//********************************************************************************************
//function funAction
//********************************************************************************************
function funAction(typ)
{
	if((typ=='NI')||(typ=='PI'))
    {
		document.forms[0].dmode.value = 'I';
	}
	else document.forms[0].dmode.value = 'O';
	document.forms[0].action_type.value = typ;
	if(validateFields())
	{
		funSubmit();
	}

}
//********************************************************************************************

//********************************************************************************************
//function addProtocolLinkID
//********************************************************************************************
async function addProtocolLinkID(applicationID,applicationName,protocol_link_id,client_id,inOutID,protocol_mode,clientName)
{	
	
	INBOUND_YN = document.getElementById("INBOUND_YN").value;
	OUTBOUND_YN = document.getElementById("OUTBOUND_YN").value;
	mainInUse = document.getElementById("IN_USE_YN").value;

	if(protocol_mode == "O")
	{		   
		in_use=document.getElementById("out_"+inOutID).value;		
	}
	else
	{		
		in_use=document.getElementById("in_"+inOutID).value;
	}
	retValue=await window.showModalDialog("../../eXH/jsp/AddProtocolLinkID.jsp?"+
				"applicationID="+applicationID+
				"&applicationName="+applicationName+
				"&protocol_mode="+protocol_mode+
				"&protocol_link_id="+protocol_link_id+
				"&client_id="+client_id+
				"&in_use="+in_use+
				"&clientName="+clientName+
				"&INBOUND_YN="+INBOUND_YN+
				"&OUTBOUND_YN="+OUTBOUND_YN+
				"&mainInUse="+mainInUse
				,'','dialogHeight:90vh; dialogWidth:65vw; center:0; status: no; dialogLeft :0vw; dialogTop :0vh;');
}
//********************************************************************************************

//********************************************************************************************
//function add()
//********************************************************************************************
function addProtocol()
{	
	this.document.forms[0].target='f_query_add_mod';
	document.forms[0].submit();	
	//window.close();
	const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}
//********************************************************************************************

//********************************************************************************************
//function deleteProtocolLinkID()
//********************************************************************************************

function deleteProtocolLinkID(mode,application_id,facility_id,client_id,protocol_link_id)
{
	document.getElementById("update_mode").value=mode;
	document.getElementById("del_application_id").value=application_id;
	document.getElementById("del_facility_id").value=facility_id;
	document.getElementById("del_client_id").value=client_id;
	document.getElementById("del_protocol_link").value=protocol_link_id;
	document.forms[0].submit();	
}
//********************************************************************************************

function forwardRequest()
{
	var req=document.getElementById("forward_request").value;
	if(req == "Y")
	{	 
		if(confirm(getMessage('XH0055','XH')))
		{
			document.getElementById("update_mode").value='deleteStatus';
			document.forms[0].submit();
		}
	}
}

function pathValidation(obj,templogDir)
{
	path = obj.value;
	var msg = getMessage('INVALID_VALUE','COMMON');
	var flag = true;

	if(path != "")
	{
		if(!path.charAt(0).match(/^[a-zA-z]/))  
		{		
			flag = false;
		}
		if(path.charAt(1) == "" ||!path.charAt(1).match(/^[:]/) || !path.charAt(2).match(/^[\/\\]/))
		{
			flag = false;
		}
	}
	if(!flag)
	{
		msg = msg.replace("#","Folder structure");
		alert(msg);
		//obj.focus();
		obj.value = "";
	}
	else
	{
		templogDir.value = obj.value;
	}
}

function checkSpecialChar(obj)
{
	var flag = false;
//	flag = CheckChars(obj);

	var str = obj.value;
    var specCharsExist = true;
    for (u=0;u<str.length;u++)
	{
		if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==42) ||(str.charCodeAt(u)==45));
		else
		{
			alert(getMessage('CANNOT_BE_SPECIAL_CHAR','COMMON'));
			obj.focus();
			return;		
		}
	}        	
}

function recordsNotFound(){	   
	var count = document.getElementById("count").value;
	if(count == 0)
	{
		alert(getMessage('XH1021','XH'));
		window.close();
	}
}

function validateFields()
{
	// condition check to avoid script errors in the query criteria & result page.
//	if((f_query_add_mod.document.forms[0] != null) && f_query_add_mod.document.forms[0].main_outbound_in_use) 
	{
		var fields;
		var names;
		var fieldsCount=0;
		var namesCount=0;

		outbound=parent.f_query_add_mod.document.forms[0].id.value;
		inbound=parent.f_query_add_mod.document.forms[0].inID.value;			

		fields = new Array ( parent.f_query_add_mod.document.forms[0].client_id,parent.f_query_add_mod.document.forms[0].client_name)
		names = new Array ( getLabel("Common.identification.label","Common"),getLabel("Common.name.label","Common"));
		fieldsCount=1;
		namesCount=1;

		outboundFlag=true;	
		inboundFlag=true;
		tempFlag=true;

		var tab1=parent.f_query_add_mod.document.getElementById("out");
		var tabspan1=parent.f_query_add_mod.document.getElementById("out_tabspan");
		var tab2=parent.f_query_add_mod.document.getElementById("inb");
		var tabspan2=parent.f_query_add_mod.document.getElementById("inb_tabspan");

		if(parent.f_query_add_mod.document.forms[0].main_outbound_in_use.checked==true)
		{

		
			for(i=0;i<outbound;i++) // Check for any empty protocol link field
			{	 
				temp="out"+i;	
				if(parent.f_query_add_mod.document.getElementById(temp).value == "")
				{
					fieldsCount=fieldsCount+1;
					namesCount=namesCount+1;

					fields[fieldsCount]=parent.f_query_add_mod.document.getElementById(temp);				
					names[namesCount]=getLabel("eXH.ProtocolLink.Label","XH");				

					i=outbound;
					outboundFlag=false;
				}
			}
			
			for(i=0;i<outbound;i++) // Check for any empty Log dir field
			{	 
				temp="out"+i+"_reportOPDir";		
				outboundInUse = "out_out"+i;
				
				if(parent.f_query_add_mod.document.getElementById(temp).value == "" &&
					parent.f_query_add_mod.document.getElementById(outboundInUse).value == 'Y')
				{	
					fieldsCount=fieldsCount+1;
					namesCount=namesCount+1;

					fields[fieldsCount]=parent.f_query_add_mod.document.getElementById(temp);
					names[namesCount] = getLabel('eXH.EnabledGateway.Label','XH');

					i=outbound;
				//	tempFlag=false;
					outboundFlag=false;
				}	 
			}
			if(!outboundFlag)
			{
				var out_disp=parent.f_query_add_mod.document.getElementById("outbounddiv");
				var in_disp=parent.f_query_add_mod.document.getElementById("inbounddiv");
				if(!parent.f_query_add_mod.checkFields( fields, names, parent.messageFrame))
				{
					out_disp.style.display='block';
					in_disp.style.display='none';
					tab1.className='tabClicked';
					tabspan1.className='tabSpanclicked';
					tab2.className='tabA';
					tabspan2.className='tabAspan';	
				}
			}


		}
		if(outboundFlag && parent.f_query_add_mod.document.forms[0].main_inbound_in_use.checked==true)
		{	  

			
			flag=false;
			for(i=0;i<inbound;i++) // Check for any empty protocol link field
			{	 
				temp="in"+i;				
				if(parent.f_query_add_mod.document.getElementById(temp).value == "")
				{
					fieldsCount=fieldsCount+1;
					namesCount=namesCount+1;

					fields[fieldsCount]=parent.f_query_add_mod.document.getElementById(temp);				
					names[namesCount]=getLabel("eXH.ProtocolLink.Label","XH");				

					i=inbound;
					inboundFlag=false;
				}
			}
			for(i=0;i<inbound;i++)  // Check for any empty Log dir field
			{	 
				temp="in"+i+"_reportOPDir";			
				inboundInUse = "in_in"+i;
				
				if(parent.f_query_add_mod.document.getElementById(temp).value == "" &&
					parent.f_query_add_mod.document.getElementById(inboundInUse).value == 'Y')
				{	
					fieldsCount=fieldsCount+1;
					namesCount=namesCount+1;

					fields[fieldsCount]=parent.f_query_add_mod.document.getElementById(temp);
					names[namesCount]=getLabel('eXH.EnabledGateway.Label','XH');

					i=inbound;	
					inboundFlag=false;
				}
			}
			if(!inboundFlag)
			{
				var out_disp=parent.f_query_add_mod.document.getElementById("outbounddiv");
				var in_disp=parent.f_query_add_mod.document.getElementById("inbounddiv");
				if(!parent.f_query_add_mod.checkFields( fields, names, parent.messageFrame))
				{
					out_disp.style.display='none';
					in_disp.style.display='block';

					tab2.className='tabClicked';
					tabspan2.className='tabSpanclicked';
					tab1.className='tabA';
					tabspan1.className='tabAspan';	
				}
			}
		}
		if(!parent.f_query_add_mod.checkFields( fields, names, parent.messageFrame))
		{  
			var out_disp=parent.f_query_add_mod.document.getElementById("outbounddiv");
			var in_disp=parent.f_query_add_mod.document.getElementById("inbounddiv");

			var tab1=parent.f_query_add_mod.document.getElementById("out");
			var tabspan1=parent.f_query_add_mod.document.getElementById("out_tabspan");
			var tab2=parent.f_query_add_mod.document.getElementById("inb");
			var tabspan2=parent.f_query_add_mod.document.getElementById("inb_tabspan");

			if(!outboundFlag)
			{
				out_disp.style.display='block';
				in_disp.style.display='none';
				tab1.className='tabClicked';
				tabspan1.className='tabSpanclicked';
				tab2.className='tabA';
				tabspan2.className='tabAspan';				
			}
			else if(!inboundFlag)
			{
				out_disp.style.display='none';
				in_disp.style.display='block';

				tab2.className='tabClicked';
				tabspan2.className='tabSpanclicked';
				tab1.className='tabA';
				tabspan1.className='tabAspan';
			}
			return false;
		}
		else
		{
			return true;
		}
	}
}

function verifyOffLineSeq(protocolid,fieldName,checkField){ 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " protocolId=\""+document.getElementById(protocolid).value+"\""	;
	xmlStr += " protocolName=\""+protocolid+"\""	;
	xmlStr += " fieldName=\""+fieldName+"\""	;
	xmlStr += " checkField=\""+checkField+"\""	;	   	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../servlet/eXH.CommClientOfflineResponseServlet", false ) ;
	xmlHttp.send(xmlDoc);

	eval(xmlHttp.responseText);		  
	
												    
}

