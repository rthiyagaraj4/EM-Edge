function create()
{
	frames[1].location.href='../../eMR/jsp/AgentforAllergenCriteria.jsp';

}
function query()
{
	frames[1].location.href='../../eMR/jsp/AgentforAllergenQueryCriteria.jsp';
}
 function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
function apply()
{
		if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

var flag=true;
var submit=true;
	 var fields = new Array (frames[1].document.forms[0].sel_rec_type,
		frames[1].document.forms[0].adv_evnt_type,
		 frames[1].document.forms[0].code_val,
		 frames[1].document.forms[0].long_desc,
		 frames[1].document.forms[0].Short_desc
                );

    var names = new Array ( getLabel("eMR.AdverseEventTypeIndicator.label","mr"),
							getLabel("eMR.AdverseEventTypeDesc.label","mr"),
							getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
                           getLabel("Common.shortdescription.label","Common")
						   );
	if(frames[1].checkFieldsofMst(fields, names, messageFrame)) 
	{
		var array;
		var adv_evnt_type=frames[1].document.forms[0].adv_evnt_type.value;
		array=adv_evnt_type.split("|");
		frames[1].document.forms[0].adv_agnt_code_val.value=array[0];
		frames[1].document.forms[0].adv_agnt_desc_val.value=array[1];
		frames[1].document.forms[0].sel_rec_type.disabled=false;
		frames[1].document.forms[0].submit();
	}
}
function medBoard_change() 
	{
	
	 if (document.forms[0].eff_status.checked == true)
		document.forms[0].eff_status.value="E";
	 else
		document.forms[0].eff_status.value="D";
	}

function get_adv_events(obj)
{
	var adv_evnt_val=obj.value;
//alert(adv_evnt_val);
	if(adv_evnt_val !="")
	{
	document.forms[0].adv_evnt_type.disabled=false;
	}else
	{
			document.forms[0].adv_evnt_type.options.selectedIndex=0;

	document.forms[0].adv_evnt_type.disabled=true;
	}

	var xmlDoc= ""
	var xmlHttp = new XMLHttpRequest()
    xmlStr ="<root><SEARCH ADV_EVENT_TYPE_IND=\""+adv_evnt_val+"\" steps='1'/></root>"
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
    xmlHttp.open("POST","AdverseEventType.jsp",false)
    xmlHttp.send(xmlDoc)
    responseText=xmlHttp.responseText
    responseText = trimString(responseText)
	responseText = responseText.replace(/<[^>]*>/g, ''); // remove any HTML tags from js response
    eval(responseText)
}

function disable()
{
	if(document.forms[0].mode)
	{
	if(document.forms[0].mode.value=="insert")
	{
	document.forms[0].adv_evnt_type.disabled=true;
	}
	/*else
	{
	document.forms[0].adv_evnt_type.disabled=false;
	}*/
	}
}

function reset() {


		if(f_query_add_mod.document.forms[0])
		   f_query_add_mod.document.forms[0].reset();


}
