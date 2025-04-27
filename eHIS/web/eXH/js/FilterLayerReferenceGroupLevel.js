function CheckForSpecCharsforNumber(event)
{
    var strCheck = '123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
} 
function record()
{
	document.forms[0].Filter_group_code.value=document.forms[0].Filter_group_code1.value;
	if(this.document.forms[0].actualmode.value=='')  
	{ 
		this.document.forms[0].actualmode.value='I';								    
	}
	var fields = new Array (  document.forms[0].Filter_group_code,
						document.forms[0].Application_type,document.forms[0].Protocol_link_type,
					    document.forms[0].Facility_type, document.forms[0].Event_type,document.forms[0].Message_type					     
					   );
	var names = new Array ( getLabel("Common.GroupCode.label","common"),
						getLabel("Common.Application.label","common"),getLabel("eXH.ProtocolLinkId.Label","XH"),
						getLabel("Common.facility.label","common"),getLabel("Common.EventType.label","common"),getLabel("Common.MessageType.label","common"));
	if(!checkFieldsofMst( fields, names, parent.messageFrame,'1'))
	{
	}
	else
	{


	
		this.document.forms[0].submit();
		document.forms[0].filterdeschidden.value=document.forms[0].Filter_group_desc.value
		document.forms[0].Applhidden.value=document.forms[0].Application_type_id.value;
		document.forms[0].gatewayhidden.value=document.forms[0].Protocol_Link_id.value;
		document.forms[0].facihidden.value=document.forms[0].Facility__id.value;
		document.forms[0].Msghidden.value=document.forms[0].Message__id.value;
		document.forms[0].eventhidden.value=document.forms[0].Event__id.value;
		parent.frames[3].document.location.href='../../eXH/jsp/FilterLayerGroupLevalAdd.jsp?Filter_group_code='+document.forms[0].Filter_group_code1.value+'&Filter_group_desc='+document.forms[0].filterdeschidden.value+'&applicationId='+document.forms[0].Applhidden.value+'&facilityId='+document.forms[0].facihidden.value+'&Message_type='+document.forms[0].Msghidden.value+'&eventType='+document.forms[0].eventhidden.value+'&Protocol_type='+document.forms[0].gatewayhidden.value+'&Total_level='+document.forms[0].Total_level.value+'&act_mode=U' 
	}
	parent.commontoolbarFrame.document.location.reload();
}
function Delete(mode)  
{
	this.document.forms[0].actualmode.value=mode;					    
	this.document.forms[0].submit(); 
	this.document.location.reload();
}
function hide()
{
    if(document.forms[0].actualmode.value=='U')
	{
		document.forms[0].deletebutton.disabled=false;
		document.forms[0].Filter_group_code1.disabled=true;
	}
	else
	{ 
	    document.forms[0].deletebutton.disabled=true; 
	}
}
function cancel()
{
	this.document.forms[0].reset();										    
	this.document.location.reload();
}
  function funAdd()
{			   																	     
	var Filter_groupcode="";
	var Filter_groupdesc="";
	var Totallevel="";
	var url='&Filter_group_code='+Filter_groupcode+'&Filter_group_desc='+Filter_groupdesc+
	'&applicationId='+document.forms[0].applicationId.value+'&facilityId='+document.forms[0].facilityId.value+
	'&Message_type='+document.forms[0].Message_type.value+'&eventType='+document.forms[0].eventType.value+'&Protocol_type='+document.forms[0].Protocol_type.value+'&Total_level='+Totallevel+'&act_mode=I'+'&fun_id='+document.forms[0].fun_id.value;
   parent.frames[3].location.href='../../eXH/jsp/FilterLayerGroupLevalAdd.jsp?'+url;
   parent.frames[4].location.href="../../eCommon/jsp/MstCodeError.jsp";		   		 	      
	
} 												 
function  func1(Filter_groupcode,Filter_groupdesc,applicationId,facilityId,Messagetype,
		eventType,Protocoltype,Totallevel)
{
    var url='&Filter_group_code='+Filter_groupcode+'&Filter_group_desc='+Filter_groupdesc+
    '&applicationId='+applicationId+'&facilityId='+facilityId+
	'&Message_type='+Messagetype+'&eventType='+eventType+'&Protocol_type='+Protocoltype+'&Total_level='+Totallevel+'&act_mode=U';
	 parent.frames[3].location.href="../../eXH/jsp/FilterLayerGroupLevalAdd.jsp?"+url; 
     parent.frames[4].location.href="../../eCommon/jsp/MstCodeError.jsp";
}  
 
function funAction(typ)
{
	parent.frames[4].location.href="../../eCommon/jsp/MstCodeError.jsp";
	if(typ=='N')
	{
		var act = '../../eXH/jsp/FilterLayerGroupLevalSearch.jsp?action_type=N';
		this.document.forms[0].action = act;
		this.document.forms[0].target="";
		this.document.forms[0].submit();
	}
	else
	{
		var act = '../../eXH/jsp/FilterLayerGroupLevalSearch.jsp?action_type=P';
		this.document.forms[0].action = act;
		this.document.forms[0].target="";
		this.document.forms[0].submit();
	}
} 



