//********************************************************************************************
//FUNCTION CREATE
//********************************************************************************************
function create()
{
//window.commontoolbarFrame.document.forms[0].apply.style.display='block';
window.f_query_add_mod.location.href="../../eXH/jsp/ApplicationAddModifyMaster.jsp?mode=I";		
window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION QUERY
//********************************************************************************************
function query()
{
		//window.commontoolbarFrame.document.forms[0].apply.style.display='none';
		window.f_query_add_mod.location.href="../../eXH/jsp/ApplicationAddModifyQueryCriteria.jsp";		
		window.messageFrame.location.href="../../eCommon/html/blank.html";

}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{

//frames[1].document.forms[0].hl7_version.readOnly=false;
//frames[1].document.forms[0].field_sep.readOnly=false;

var fields = new Array ( frames[1].document.forms[0].appl_id,
					      frames[1].document.forms[0].appl_name,
					      frames[1].document.forms[0].facility,
					      frames[1].document.forms[0].hl7_version,
					      frames[1].document.forms[0].field_sep) ;

var names = new Array ( getLabel("eXH.ID.Label","XH"),
						getLabel("eXH.Name.Label","XH"),
						getLabel("eXH.ApplicationFacilityName.Label","XH"),
						getLabel("eXH.HL7Version.Label","XH"),
						getLabel("eXH.FieldSeparator.Label","XH"));
  
	if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
   
	}else
		{
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
//function onLoadMethod
//********************************************************************************************

function onLoadMethod()
{
if (this.document.forms[0].act_mode.value=='I')
{
  this.document.forms[0].in_use.checked=true;
}
/*
if (this.document.forms[0].act_mode.value=='U')
{

var selectbox=this.document.forms[0].lang_id;
for( var j=0;j<selectbox.options.length;j++)
{
	if(selectbox.options[j].value==this.document.forms[0].language_id.value)
	{
	selectbox.options[j].selected=true; 
	}
}

}
*/
}
//********************************************************************************************
//function validatecheckbox
//********************************************************************************************

function validatecheckbox(obj)
{
if(obj.checked==true)
	obj.value="Y";
	else
	obj.value="N";
}
//********************************************************************************************
//function funSubmit
//*******************************************************************************************
function funSubmit()
{
	// #MOD#01
	alert("frmName : "+this.document.forms[0].name);
	var act = '../../eXH/jsp/ApplicationQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	// #MOD#02
				alert("formNam : "+this.document.forms[0].name);
	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

	this.document.forms[0].appl_id.value = obj.getAttribute('appl_id');
	this.document.forms[0].appl_name.value = obj.getAttribute('appl_name');
	this.document.forms[0].facility.value = obj.getAttribute('facility');
//	this.document.forms[0].hl7_version.value = obj.getAttribute('hl7_version');
//	this.document.forms[0].field_seperator.value = obj.getAttribute('field_seperator');
	this.document.forms[0].enabled.value = obj.getAttribute('enabled');
	this.document.forms[0].lang_id.value = obj.getAttribute('lang_id');
	var act = '../../eXH/jsp/ApplicationAddModifyMaster.jsp';
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

