function record()
{
	

	
	var fields = new Array (  
						  document.forms[0].ele_val_id,document.forms[0].element_controlID);
	var names = new Array ( 
						getLabel("Common.Element.label","common"),getLabel("eXH.CtrlElementId.Label","XH"));

if(!checkFields( fields, names, parent.messageFrame))
	{
	}
else
	{

var Standard_code=parent.frames[1].document.forms[0].standard_code.value;
this.document.forms[0].standard_code.value= Standard_code;
var act='../../eXH/jsp/InterfaceSantdardsCtrlrecordquery.jsp';
this.document.forms[0].action=act;
//this.document.forms[0].standard_code.value= Standard_code;
this.document.forms[0].target="messageFrame";
this.document.forms[0].submit();
	}

}
function Deleterecord(Mode)
{
	
		//.document.forms[0].segment_type_id.value);
	var Standard_code=parent.frames[1].document.forms[0].standard_code.value;


this.document.forms[0].act_mode.value =Mode;
//this.document.forms[0].element_name.value =num;
//this.document.forms[0].segment_type_id.value=segment_type_id
this.document.forms[0].standard_code.value= Standard_code;

var act='../../eXH/jsp/InterfaceSantdardsCtrlrecordquery.jsp';
this.document.forms[0].standard_code.value= Standard_code;

this.document.forms[0].action=act;
//this.document.forms[0].standard_code.value= Standard_code;
this.document.forms[0].target="messageFrame";
this.document.forms[0].submit();

}
function CheckForSpecCharsforID(event){

    var strCheck = '0123456789';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )

	
	return (event.keyCode -= 32);
	return true ;
}
function funCancel()
{  


document.location.reload();
}
function hide()
{

if(document.forms[0].act_mode.value=='U')
	{

document.forms[0].element_name.disabled=true;
document.forms[0].Delete.disabled=false;
	}
	else
	{

		
		document.forms[0].element_name.disabled=false;
		document.forms[0].Delete.disabled=true;
	}

}
