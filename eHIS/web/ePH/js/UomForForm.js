  //saved on 27/10/2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var firstTime	="";


function create() {
	f_query_add_mod.location.href="../../ePH/jsp/UomForFormFrames.jsp?mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/UomForFormQueryCriteria.jsp" ;
}

function apply() {

	if(!proceedOnApply())	{
		if( f_query_add_mod.f_formOfDrug.document.formUomForForm.formOfDrug.value!="" )	{
			navigation(f_query_add_mod.f_UOMDetails.document.ApplicableUomForm,"apply");
			//alert(formApply(f_query_add_mod.f_UOMDetails.document.ApplicableUomForm,PH_CONTROLLER  )) ;
			eval( formApply(f_query_add_mod.f_UOMDetails.document.ApplicableUomForm,PH_CONTROLLER  ) ) ;
			if ( message == 'PH_ATLEAST_ONE_SELECTED' ){
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("ATLEAST_ONE_SELECTED","Common");
			}else
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;

			if( result ) {
				onSuccess();
			}   
		}
		else	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
        return false;
			
		}
	}
	else	{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
        return false;
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function reset() {

	 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();

		if(url.indexOf("uomforformquerycriteria")!=-1)
			f_query_add_mod.document.query_form.reset();
		else if(url.indexOf("uomforformframes")!=-1)
			f_query_add_mod.location.href="../../ePH/jsp/UomForFormFrames.jsp?mode="+MODE_INSERT;
}

function onSuccess() {
f_query_add_mod.location.href="../../ePH/jsp/UomForFormFrames.jsp?mode="+MODE_INSERT;
}

function callApplicableUom()
{
	var code	=	f_formOfDrug.document.formUomForForm.formOfDrug.value;
	f_buttons.location.href="../../ePH/jsp/UomForFormButtons.jsp?form_code="+code;
	f_UOMDetails.location.href="../../eCommon/html/blank.html";
	firstTime="Y";
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}

function callSelect(code,from)
{

	if(from=="onSuccess")
	{
		if(firstTime=="Y")	{
			f_query_add_mod.f_UOMDetails.location.href="../../ePH/jsp/ApplicableUomForForm.jsp?firstTime=Y&form_code="+code;
			firstTime="N";
		}
	}
	else	{
	f_buttons.document.getElementById("select").className="HIGHER_LEVEL_LINK";
	f_buttons.document.getElementById("select_col").className="clicked";
	f_buttons.document.getElementById("association").className="SUB_LEVEL_LINK";
	f_buttons.document.getElementById("association_col").className="normal";
	
		if(firstTime=="Y")	{
			f_UOMDetails.location.href="../../ePH/jsp/ApplicableUomForForm.jsp?firstTime=Y&form_code="+code;
			firstTime="N";
		}
		else	
		navigation(f_UOMDetails.document.ApplicableUomForm,"select");
		//f_UOMDetails.location.href="../../ePh/jsp/ApplicableUomForForm.jsp?firstTime=N&form_code="+code;
	}
}

function callAssociation(code)
{

f_buttons.document.getElementById("select").className="SUB_LEVEL_LINK";
f_buttons.document.getElementById("select_col").className="normal";
f_buttons.document.getElementById("association").className="HIGHER_LEVEL_LINK";
f_buttons.document.getElementById("association_col").className="clicked";

navigation(f_UOMDetails.document.ApplicableUomForm,"associate");
}


function navigation(frmObj,link)
{  
	//alert("navigation");
	
	if(link!="apply")	{
	//alert("navigation---1");
	start		=	f_UOMDetails.document.getElementById("start").value;
	end			=	f_UOMDetails.document.getElementById("end").value;
	f_UOMDetails.document.getElementById("frm_link").value=link;
	}
	else
	{
		//alert("navigation---2");
	start		=	f_query_add_mod.f_UOMDetails.document.getElementById("start").value;
	end			=	f_query_add_mod.f_UOMDetails.document.getElementById("end").value;
	f_query_add_mod.f_UOMDetails.document.getElementById("frm_link").value=link;
	f_query_add_mod.f_UOMDetails.document.getElementById("mode").value=MODE_INSERT;
	}

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var arrObj = frmObj.elements;
	//alert("arrObj---->"+arrObj);
    //alert("arrObj---->"+frmObj.length);
    
	var frmObjs = new Array()
	if(frmObj.name == null)	
		frmObjs = frmObj
   	else frmObjs[0] = frmObj
	var xmlStr ="<root><SEARCH ";
	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;
       // alert("arrObj---146-->"+arrObj.type);
		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)	{
					arrObj[i].value="Y";
					val = arrObj[i].value;
				}
				else
				{
					arrObj[i].value="N";
					val = arrObj[i].value;
				}
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
			}
			else if(arrObj[i].type == "select-multiple" )
			{       //alert("arrObj---165-->"+arrObj[i].type);
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
			}
			else
				val = arrObj[i].value;

			val = checkSpl( val ) ;
			//alert("val---->"+val);

			xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
		}
	}
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","UomForFormStore.jsp",false);
//alert(xmlStr);
	xmlHttp.send(xmlDoc);
//alert(xmlHttp.responseText );

	if(link=="previous")	{	
	start	=	parseInt(start)-14;
	end		=	parseInt(end)-14;
	var isAssociate	=	f_UOMDetails.document.getElementById("isAssociate").value;
	if(isAssociate=='true')
	f_UOMDetails.location.href="../../ePH/jsp/ApplicableUomForForm.jsp?firstTime=N&link=associate&from="+start+"&to="+end;
	else
	f_UOMDetails.location.href="../../ePH/jsp/ApplicableUomForForm.jsp?firstTime=N&from="+start+"&to="+end;
	}
	else if(link=="next")	{
	start	=	parseInt(start)+14;
	end		=	parseInt(end)+14;
	var isAssociate	=	f_UOMDetails.document.getElementById("isAssociate").value;
	if(isAssociate=='true')	{
	f_UOMDetails.location.href="../../ePH/jsp/ApplicableUomForForm.jsp?firstTime=N&link=associate&from="+start+"&to="+end;
	}
	else	{
	f_UOMDetails.location.href="../../ePH/jsp/ApplicableUomForForm.jsp?firstTime=N&from="+start+"&to="+end;

	}	//f_UOMDetails.location.href="../../ePH/jsp/ApplicableUomForForm.jsp?firstTime=N&from="+start+"&to="+end;
	}
	else if(link=="associate")	{
	f_UOMDetails.location.href="../../ePH/jsp/ApplicableUomForForm.jsp?firstTime=N&link=associate";
	}
	else if(link=="select")	{
	f_UOMDetails.location.href="../../ePH/jsp/ApplicableUomForForm.jsp?firstTime=N";
	}
}

function unCheckOthers(objno)	{
	//alert("name");

	frmObj		=	f_UOMDetails.document.ApplicableUomForm;
	arrObj		=	frmObj.elements;
	frmelement	=	eval("frmObj.default_"+objno);
	found		=	false;
	var isAssociate	=	f_UOMDetails.document.getElementById("isAssociate").value;

if(isAssociate=='false')	{
	for(i=0; i<arrObj.length; i++)	{
		if(arrObj[i].type=="checkbox")	{
			if(arrObj[i].name.substr(0,1)=="d" && arrObj[i].name!=frmelement.name)	{
				var len		=	arrObj[i].name.length;
				var suffix	=	arrObj[i].name.substr(8,len);	
				
				flag		=	eval("frmObj.flag_"+suffix+".value");
				element		=	eval("frmObj.default_"+suffix);
				classval	=	f_UOMDetails.document.getElementById("sel_td_"+suffix).className;
			default_status	=	eval("frmObj.def_status_"+suffix+".value");

				if(flag=="U" || (flag=="DB" && element.checked))
				td			=	f_UOMDetails.document.getElementById("td_"+suffix).className;

				if(flag=="U" && td=="DATACHANGE" && element.checked) {
					f_UOMDetails.document.getElementById("td_"+suffix).className=classval;
				}
				else if(flag=="DB" && element.checked && default_status=="checked")
				{  
					f_UOMDetails.document.getElementById("td_"+suffix).className='DATACHANGE';
				}
				
			}
		}
	}
}

		for(i=0; i<arrObj.length; i++)	{
			if(arrObj[i].type=="checkbox")	{
				if(arrObj[i].name.substr(0,1)=="d" && arrObj[i].name!=frmelement.name)	{
				arrObj[i].checked=false;
				}
				}
		}

}

function disableFormofDrug()	{
	f_formOfDrug.document.formUomForForm.formOfDrug.disabled=true;
}

async function showUOMDesc(uom_code)	{

			var dialogHeight= "30vh" ;
			var dialogWidth	= "40vw" ;
			var dialogTop = "205";
			var dialogLeft="225";
			var center = "1" ;
			var status="no";
			var scrolling="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; dialogLeft :" + dialogLeft +";scroll:"+scrolling;
			var arguments	= "" ;
			retVal = await window.showModalDialog("../../ePH/jsp/UOMDescDetailLookup.jsp?code="+uom_code,arguments,features);

}

function proceedOnApply() {
    var url = f_query_add_mod.location.href;
	var result;
    url = url.toLowerCase();

	if (url.indexOf("blank.html")!=-1)
		result	= true;
    else if(url.indexOf("uomforformquery")!=-1)
		result	=	true;
	else
		result	=	false;

	return result;
}
