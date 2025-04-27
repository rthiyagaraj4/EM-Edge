var prevObjID;
var prevImgObj;
//end
var disappeardelay= 250;
function apply(){
	
	
	if(f_query_add_mod_top.document.clinic_event_param_form_top.sym_color[0].checked)
		f_query_add_mod.document.clinic_event_param_form.symbol_colour.value=f_query_add_mod_top.document.clinic_event_param_form_top.sym_color[0].value;
	else 
		f_query_add_mod.document.clinic_event_param_form.symbol_colour.value=f_query_add_mod_top.document.clinic_event_param_form_top.sym_color[1].value;
	 
	f_query_add_mod.document.clinic_event_param_form.high_value_symbol.value=spliturl(f_query_add_mod_top.document.clinic_event_param_form_top.symbolicobj0);
	f_query_add_mod.document.clinic_event_param_form.low_value_symbol.value=spliturl(f_query_add_mod_top.document.clinic_event_param_form_top.symbolicobj1);
	f_query_add_mod.document.clinic_event_param_form.abnormal_value_symbol.value=spliturl(f_query_add_mod_top.document.clinic_event_param_form_top.symbolicobj2);
	f_query_add_mod.document.clinic_event_param_form.critical_value_symbol.value=spliturl(f_query_add_mod_top.document.clinic_event_param_form_top.symbolicobj3);
	f_query_add_mod.document.clinic_event_param_form.criticallow_value_symbol.value=spliturl(f_query_add_mod_top.document.clinic_event_param_form_top.symbolicobj4);
	f_query_add_mod.document.clinic_event_param_form.criticalhigh_value_symbol.value=spliturl(f_query_add_mod_top.document.clinic_event_param_form_top.symbolicobj5);
	
	//alert("high"+f_query_add_mod.document.clinic_event_param_form.high_value_symbol.value);

	var high_value =  f_query_add_mod_top.document.clinic_event_param_form_top.high_value.value
	var low_value = f_query_add_mod_top.document.clinic_event_param_form_top.low_value.value
	var abnml_value = f_query_add_mod_top.document.clinic_event_param_form_top.abnml_value.value
	var crtcl_value = f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_value.value
	var crtcl_low_value = f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_low_value.value
	var crtcl_high_value = f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_high_value.value   
	var high_value_desc =  f_query_add_mod_top.document.clinic_event_param_form_top.high_value_desc.value
	var low_value_desc =  f_query_add_mod_top.document.clinic_event_param_form_top.low_value_desc.value
	var abnml_value_desc =  f_query_add_mod_top.document.clinic_event_param_form_top.abnml_value_desc.value
	var crtcl_value_desc =  f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_value_desc.value
	var crtcl_low_value_desc =  f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_low_value_desc.value
	var crtcl_high_value_desc =  f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_high_value_desc.value
		
	var mode = f_query_add_mod_top.document.clinic_event_param_form_top.mode.value
	f_query_add_mod.document.clinic_event_param_form.high_value.value = high_value
	f_query_add_mod.document.clinic_event_param_form.low_value.value = low_value
	f_query_add_mod.document.clinic_event_param_form.abnml_value.value = abnml_value
	f_query_add_mod.document.clinic_event_param_form.crtcl_value.value = crtcl_value
	f_query_add_mod.document.clinic_event_param_form.crtcl_low_value.value = crtcl_low_value
	f_query_add_mod.document.clinic_event_param_form.crtcl_high_value.value = crtcl_high_value
	f_query_add_mod.document.clinic_event_param_form.high_value_desc.value = high_value_desc
	f_query_add_mod.document.clinic_event_param_form.low_value_desc.value = low_value_desc
	f_query_add_mod.document.clinic_event_param_form.abnml_value_desc.value = abnml_value_desc
	f_query_add_mod.document.clinic_event_param_form.crtcl_value_desc.value = crtcl_value_desc
	f_query_add_mod.document.clinic_event_param_form.crtcl_low_value_desc.value = crtcl_low_value_desc
	f_query_add_mod.document.clinic_event_param_form.crtcl_high_value_desc.value = crtcl_high_value_desc

	f_query_add_mod.document.clinic_event_param_form.delta_value.value =  f_query_add_mod_top.document.clinic_event_param_form_top.delta_value.value
	f_query_add_mod.document.clinic_event_param_form.mode.value = mode

	var fields = new Array ( f_query_add_mod_top.document.clinic_event_param_form_top.high_value,
						f_query_add_mod_top.document.clinic_event_param_form_top.low_value,
						f_query_add_mod_top.document.clinic_event_param_form_top.abnml_value,
						f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_value,
						f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_low_value,
						f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_high_value,
			            f_query_add_mod_top.document.clinic_event_param_form_top.high_value_desc,
			            f_query_add_mod_top.document.clinic_event_param_form_top.low_value_desc,
			            f_query_add_mod_top.document.clinic_event_param_form_top.abnml_value_desc,
			            f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_value_desc,
			            f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_low_value_desc,
			            f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_high_value_desc
			
					    );
		
		var names = new Array ( f_query_add_mod_top.getLabel("Common.HighValue.label",'common'),
							f_query_add_mod_top.getLabel("Common.LowValue.label",'common'),
							f_query_add_mod_top.getLabel("eCA.AbnormalValue.label",'CA'),
							f_query_add_mod_top.getLabel("eCA.CriticalValue.label",'CA'),
							f_query_add_mod_top.getLabel("Common.CriticalLowValue.label",'common'),
							f_query_add_mod_top.getLabel("Common.CriticalHighValue.label",'common'),
							f_query_add_mod_top.getLabel("Common.HighValue.label",'common'),
							f_query_add_mod_top.getLabel("Common.LowValue.label",'common'),
							f_query_add_mod_top.getLabel("eCA.AbnormalValue.label",'CA'),
							f_query_add_mod_top.getLabel("eCA.CriticalValue.label",'CA'),
							f_query_add_mod_top.getLabel("Common.CriticalLowValue.label",'common'),
							f_query_add_mod_top.getLabel("Common.CriticalHighValue.label",'common')
					      );


	var fields2 = new Array ( f_query_add_mod_top.document.clinic_event_param_form_top.high_value,
						f_query_add_mod_top.document.clinic_event_param_form_top.low_value,
						f_query_add_mod_top.document.clinic_event_param_form_top.abnml_value,
						f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_value,
						f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_low_value,
						f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_high_value
			            
					    );

	var names2 = new Array ( f_query_add_mod_top.getLabel("Common.HighValue.label",'common'),
							f_query_add_mod_top.getLabel("Common.LowValue.label",'common'),
							f_query_add_mod_top.getLabel("eCA.AbnormalValue.label",'CA'),
							f_query_add_mod_top.getLabel("eCA.CriticalValue.label",'CA'),
							f_query_add_mod_top.getLabel("Common.CriticalLowValue.label",'common'),
							f_query_add_mod_top.getLabel("Common.CriticalHighValue.label",'common')
							
					      );

		var descObj;
		var descObjValue;
		var colorObj;
		var colorObjValue;
		var descObjDupl;
		var descObjValueDupl;
		var colorObjDupl;
		var colorObjValueDupl;
		var status = "S";
		var msg = "";

		for(var i=0;i<6;i++)
		{
			descObj = eval(f_query_add_mod_top.document.getElementById("value"+i));
			if(descObj != null)
				descObjValue = descObj.value;

			colorObj = eval(f_query_add_mod_top.document.getElementById("color"+i));
			if(colorObj != null)
				colorObjValue = colorObj.style.backgroundColor;

			for(var j=0;j<6;j++)
			{
				descObjDupl = eval(f_query_add_mod_top.document.getElementById("value"+j));
				if(descObjDupl != null)
					descObjValueDupl = descObjDupl.value;

				colorObjDupl = eval(f_query_add_mod_top.document.getElementById("color"+j));
				if(colorObjDupl != null)
					colorObjValueDupl = colorObjDupl.style.backgroundColor;

				if(descObj != descObjDupl)
				{
					if(descObjValue == descObjValueDupl)
					{
						if(colorObjValue != colorObjValueDupl)
						{
						    msg = getMessage("COLOR_DESC_NOT_SYNC","CA");
							msg = msg.replace("$$",descObjValue);
							msg = msg.replace("$$",descObjValue);
							if(window.confirm(msg) == true)
							{
								colorObjDupl.style.backgroundColor = colorObj.style.backgroundColor;
								status = "S";
							}
							else
								status = "F";
						}
					}
				}				
			}
		}

		f_query_add_mod.document.clinic_event_param_form.high_value_color.value = f_query_add_mod_top.document.clinic_event_param_form_top.high_value_color.style.backgroundColor;
		f_query_add_mod.document.clinic_event_param_form.low_value_color.value = f_query_add_mod_top.document.clinic_event_param_form_top.low_value_color.style.backgroundColor;
		f_query_add_mod.document.clinic_event_param_form.abnml_value_color.value = f_query_add_mod_top.document.clinic_event_param_form_top.abnml_value_color.style.backgroundColor;
		f_query_add_mod.document.clinic_event_param_form.crtcl_value_color.value = f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_value_color.style.backgroundColor;
		f_query_add_mod.document.clinic_event_param_form.crtcl_low_value_color.value = f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_low_value_color.style.backgroundColor;
		f_query_add_mod.document.clinic_event_param_form.crtcl_high_value_color.value = f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_high_value_color.style.backgroundColor;
		
		if(status == "S")
		{
			if(f_query_add_mod_top.checkFieldsofMst( fields, names, messageFrame))
			{
				if (checkUnique(fields2,names2)){
				var fields1 = new Array (  f_query_add_mod_top.document.clinic_event_param_form_top.high_value,
							f_query_add_mod_top.document.clinic_event_param_form_top.low_value,
							f_query_add_mod_top.document.clinic_event_param_form_top.abnml_value,
							f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_value,
							f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_low_value,
							f_query_add_mod_top.document.clinic_event_param_form_top.crtcl_high_value
					);
				var names = new Array ( f_query_add_mod_top.getLabel("Common.HighValue.label",'common'),
								f_query_add_mod_top.getLabel("Common.LowValue.label",'common'),
								f_query_add_mod_top.getLabel("eCA.AbnormalValue.label",'CA'),
								f_query_add_mod_top.getLabel("eCA.CriticalValue.label",'CA'),
								f_query_add_mod_top.getLabel("Common.CriticalLowValue.label",'common'),
								f_query_add_mod_top.getLabel("Common.CriticalHighValue.label",'common')
							  );
				
				f_query_add_mod.document.forms[0].submit();				
				
				} else {
					return false;
				}
			}
		}
		else
		{
			commontoolbarFrame.location.reload();
			return false;
		}
	}



function reset(){
		if(f_query_add_mod.document.forms[0].name == "clinic_event_param_form")
			f_query_add_mod.document.clinic_event_param_form.reset() ;
		if(f_query_add_mod_top.document.forms[0].name == "clinic_event_param_form_top")
			f_query_add_mod_top.document.clinic_event_param_form_top.reset() ;
}

function spliturl(obj)
{
		var temp=obj.src;
		url=temp.split("/");
		var tempurl=url[url.length-1];
		return tempurl;
}
function onSuccess(){
	f_query_add_mod_top.location.reload();
	f_query_add_mod.location.reload();
 }

function checkUnique(fields,names) {
	for (var i=0;i < fields.length - 1; i++) {
		for(var j=i+1; j < fields.length;j++) {
			if (fields[i].value == fields[j].value) {
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+names[i] + " And " + names[j] + " Cannot be Same..." ;
				return false;
			}
		}
	}
	return true;
}

async function getColor(object){ //for color table
	var retVal = "";
	var dialogHeight = "400px";
	var dialogWidth =	"400px";
	var dialogTop = "150";
	var status = "no";
	var dialogLeft = "560";
	var arguments ="";
	var action_url = '../../eCA/jsp/ColorTable.jsp';
	var features =	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop:" + dialogTop +" ;dialogLeft:" + dialogLeft ; 
	retVal =await window.showModalDialog(action_url,arguments,features);

	if (object=="high")
	{
	   document.clinic_event_param_form_top.high_value_color.style.backgroundColor = retVal;
	   parent.f_query_add_mod.document.clinic_event_param_form.high_value_color.value = retVal;
	}
	else if (object=="low")
	{
		document.clinic_event_param_form_top.low_value_color.style.backgroundColor = retVal;
		parent.f_query_add_mod.document.clinic_event_param_form.low_value_color.value = retVal;
	}
	else if (object=="abnormal")
	{
		document.clinic_event_param_form_top.abnml_value_color.style.backgroundColor = retVal;
		parent.f_query_add_mod.document.clinic_event_param_form.abnml_value_color.value = retVal;
	}
	else if (object=="critical")
	{
		document.clinic_event_param_form_top.crtcl_value_color.style.backgroundColor = retVal;
		parent.f_query_add_mod.document.clinic_event_param_form.crtcl_value_color.value = retVal;
	}
	else if (object=="criticallow")
	{
		document.clinic_event_param_form_top.crtcl_low_value_color.style.backgroundColor = retVal;
		parent.f_query_add_mod.document.clinic_event_param_form.crtcl_low_value_color.value = retVal
	}
	else if(object=="criticalhigh")
	{
		document.clinic_event_param_form_top.crtcl_high_value_color.style.backgroundColor = retVal;
		parent.f_query_add_mod.document.clinic_event_param_form.crtcl_high_value_color.value = retVal
	}	
}




function chkDescAndColor(obj,rowNum,color)
{
	var objchkDesc;
	var objchk;
	var objchkColor = eval(document.getElementById(color+"_value_color"));
	var objchkLabel = eval(document.getElementById("label"+rowNum));
	var objchkLabelvalue = objchkLabel.innerText;
	var objChkColorValue = objchkColor.style.backgroundColor;
	var objLabelValue;
	var msg;
	for(var i=0;i<6;i++)
	{
		objchkDesc=    eval(document.getElementById(color+"_value_desc"));
		objchk =       eval(document.getElementById(color+"_value_color"));
		objLabelValue =eval(document.getElementById("label"+i)).innerText;
		if(objchkDesc != obj)
		{
			if(objchkDesc.value == obj.value)
			{
				if(objChkColorValue != objchk.style.backgroundColor)
				{
					msg = getMessage("COLOR_DESC_NOT_SYNC","CA");
					msg = msg.replace('$$',objchkLabelvalue);			
					msg = msg.replace('$$',objLabelValue);

					if(window.confirm(msg) == true)
					{						        
						objchkColor.style.backgroundColor = objchk.style.backgroundColor;
					}
					break;
				}
			}
		}
	 }
}
function dynamichide(m, e,row)
	{
		
		if (!this.isContained(m, e))
		{
			this.delayhidemenu(row)
		}
	}

	function isContained(m, e)
	{

		var e=window.event || e
		var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
		while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
		if (c==m)
			return true
		else
			return false
	}

	function delayhidemenu(row)
	{

		this.delayhide=setTimeout("hidemenu()", this.disappeardelay) //hide menu
		if(eval(document.getElementById("orderctl"+row)))
		   eval(document.getElementById("orderctl"+row)).className='gridDataBlue';
		if(eval(document.getElementById("imgArrow"+row)))
		   eval(document.getElementById("imgArrow"+row)).src = "../../eCommon/images/inactiveArrow.gif";
	}

	function hidemenu()
	{
		document.getElementById("tooltiplayer").style.visibility = 'hidden';
	}
	//end
