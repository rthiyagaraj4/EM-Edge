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


function searchleval()
	{

if(document.forms[0].Filter_group_desc_id.value=='')
		{
		}
		else
		{
		this.document.forms[0].action='../../eXH/jsp/FilterLayerLevalNumber.jsp?filter_code='+this.document.forms[0].Filter_group_desc_id.value;
this.document.forms[0].submit();
		}
	}
function record()
{

var fields = new Array (  document.forms[0].Filter_group_desc,
						document.forms[0].Filter_Element_Type,document.forms[0].Filter_Element_desc,
					    document.forms[0].Filter_subtype_Type, document.forms[0].Filter_subtype_desc,document.forms[0].Filter_Element_Code					     
					   );


var names = new Array ( getLabel("Common.GroupCode.label","common"),
						getLabel("eXH.FilterType.Label","XH"),getLabel("eXH.FilterTypedesc.Label","XH"),
						getLabel("eXH.FilterSubType.Label","XH"),getLabel("eXH.FilterSubDesc.Label","XH"),getLabel("eXH.ElementCode.Label","XH"));



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
function Delete(mode)
{
this.document.forms[0].action='../../eXH/jsp/FilterLayarGroupFilterRecord.jsp';
this.document.forms[0].target='messageFrame';
this.document.forms[0].actualmode.value=mode;
this.document.forms[0].submit();
}
function cancel()
{
	this.document.forms[0].reset();
}
function hide()
{
    if(document.forms[0].actualmode.value=='U')
	{
	document.forms[0].deletebutton.disabled=false;
	document.forms[0].Filter_group_desc.disabled=true;
	document.forms[0].FiltergroupTypeSearch.disabled=true;
	}
	else
	{
    document.forms[0].deletebutton.disabled=true;
	}
}
  function funAdd()
{
	
  parent.frames[3].location.href='../../eXH/jsp/FilterLayerGroupFilterLevalAdd.jsp?actualmode=I';

parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
	
}
function func1(Filter_groupcode,level_number,filter_element_type,filter_element_type_desc,filter_subtype_code,
		filter_subtype_desc,element_code_name,h)
{
var type_query="";
var subtype_query=""; 
var loockup_query="";
var url="";
 
var cou=document.forms[0].countfield.value;

for(var q=1;q<=cou;q++)
	{

if(h==q)
		{

var type_query=document.getElementById(h+"type_value").value;
var subtype_query=document.getElementById(h+"subtype_value").value;
var loockup_query=document.getElementById(h+"lookquery_value").value;

		}

	}

 var url='&Filter_group_code='+Filter_groupcode+'&level_number='+level_number+
      '&filter_element_type='+filter_element_type+'&filter_element_type_desc='+filter_element_type_desc+
	  '&filter_subtype_code='+filter_subtype_code+'&filter_subtype_desc='+filter_subtype_desc+'&element_code_name='+element_code_name+'&type_query='+type_query+'&subtype_query='+subtype_query+'&loockup_query='+loockup_query+'&actualmode=U';
	

		
	
		
	
	 

	 
	 
	 parent.frames[3].location.href="../../eXH/jsp/FilterLayerGroupFilterLevalAdd.jsp?"+url; 
	  
} 
