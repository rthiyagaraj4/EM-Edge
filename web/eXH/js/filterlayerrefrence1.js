function recordGroupwise()
{

var fields = new Array (  document.forms[0].Filter_group_desc,
						document.forms[0].Filter_Element_Type,document.forms[0].Filter_Element_desc,
					    document.forms[0].Filter_subtype_Type, document.forms[0].Filter_subtype_desc,document.forms[0].Filter_Element_Code					     
					   );


var names = new Array ( 
						getLabel("eXH.FilterGroupCode.Label","XH"),
						getLabel("eXH.FilterType.Label","XH"),getLabel("eXH.FilterTypedesc.Label","XH"),
						getLabel("eXH.FilterSubType.Label","XH"),getLabel("FilterSubDesc","XH"),getLabel("eXH.ElementCode.Label","XH"));
if(!checkFieldsofMst( fields, names, parent.messageFrame,'1'))
	{


	}
	else
	{


this.document.forms[0].action='../../eXH/jsp/FilterLayarGroupFilterRecord.jsp';

this.document.forms[0].target='messageFrame';
this.document.forms[0].submit();
//
	}
}
function cancel()
{
		
	this.document.forms[0].reset();
}

function CheckForSpecCharsforID(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
function getValue()
{


}
function DeleteGroupwise(mode)
{
this.document.forms[0].action='../../eXH/jsp/FilterLayarGroupFilterRecord.jsp';
this.document.forms[0].target='messageFrame';
this.document.forms[0].actualmode.value=mode;
this.document.forms[0].submit();
}
function record()
{

	
	if(this.document.forms[0].actualmode.value=='')
	{
this.document.forms[0].actualmode.value='I';
	}


var fields = new Array (  document.forms[0].Filter_group_code,
						document.forms[0].Application_type,document.forms[0].Protocol_link_type,
					    document.forms[0].Facility_type, document.forms[0].Event_type,document.forms[0].Message_type					     
					   );


var names = new Array ( 
						getLabel("Common.GroupCode.label","common"),
						getLabel("Common.Application.label","common"),getLabel("eXH.Protocol.Label","XH"),
						getLabel("Common.facility.label","common"),getLabel("Common.EventType.label","common"),getLabel("Common.MessageType.label","common"));
if(!checkFieldsofMst( fields, names, parent.messageFrame,'1'))
	{


	}
	else
	{
		var act='../../eXH/jsp/FilterLayarGroupRecord.jsp';

document.forms[0].action=act;
document.forms[0].target='messageFrame';
this.document.forms[0].submit();
	}
	parent.commontoolbarFrame.document.location.reload();
}

function Delete(mode)
{
	
this.document.forms[0].actualmode.value=mode;
this.document.forms[0].submit();

}
function hide()
{
    if(document.forms[0].actualmode.value=='U')
	{
	document.forms[0].deletebutton.disabled=false;
	}
	else
	{ 
    document.forms[0].deletebutton.disabled=true;
	}
}
