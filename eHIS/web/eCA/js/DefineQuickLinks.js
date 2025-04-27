/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
20/01/2017		IN061898	Raja S			23/01/2017		Ramesh G			ML-MMOH-CRF-0550
15/03/2017		IN051294	Krishna Gowtham J									MO-CRF-20087
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
04/11/2020		IN073728	Nijithas		04/11/2020		Ramesh G		    MO-CRF-20101.16
03/02/2022      IN27709     Suji Keerthi.G  03/02/2022      Ramesh G            GHL-CRF-0658
---------------------------------------------------------------------------------------------------------------
*/ 
function create()
{
	// panel. rows='8%,70%,0,8%';
	document.getElementsByName("panel")[0].rows='8%,70%,0,8%' ;
	f_query_add_mod.location.href='../../eCA/jsp/DefineQuickLinksAddModify.jsp?mode=insert';
	
}


function query()
{
	
	//panel. rows='8%,70%,0,8%';
	document.getElementsByName("panel")[0].rows='8%,70%,0,8%' ;
	f_query_add_mod.location.href='../../eCA/jsp/DefineQuickLinksQueryCriteria.jsp';
			
}
function apply()
{	

	if(f_query_add_mod.document.QuickLink_Form != null)
	{
		
		var ql_type = f_query_add_mod.document.QuickLink_Form.ql_type.value;
		var ql_type1 = f_query_add_mod.document.QuickLink_Form.ql_type1.value;
		
		var function_id = f_query_add_mod.document.QuickLink_Form.function_id.value;
		var url = f_query_add_mod.document.QuickLink_Form.url.value;
		var desc = f_query_add_mod.document.QuickLink_Form.desc.value;
		var function_spec = f_query_add_mod.document.QuickLink_Form.function_spec.value;
		var global = f_query_add_mod.document.QuickLink_Form.global.value;
		var eff_status = f_query_add_mod.document.QuickLink_Form.eff_status.value;
		var mode = f_query_add_mod.document.QuickLink_Form.mode.value;
		var fields = new Array(f_query_add_mod.document.QuickLink_Form.ql_type);
		var names = new Array (getLabel("eCA.QuickLinkType.label",'CA'));

		if(checkFieldsofMst(fields, names, messageFrame))
		{
			if(ql_type == 'QF')
			{
				fields = new Array(f_query_add_mod.document.QuickLink_Form.function_name,f_query_add_mod.document.QuickLink_Form.desc);
				names = new Array (getLabel("Common.Function.label",'common'),getLabel("Common.description.label",'common'));
				if(checkFieldsofMst(fields, names, messageFrame)){
					f_query_add_mod.document.QuickLink_Form.submit();
					reset();					
				}
			}
			if(ql_type == 'AF')
			{
				fields = new Array(f_query_add_mod.document.QuickLink_Form.function_name);
				names = new Array (getLabel("Common.Function.label",'common'));
				if(checkFieldsofMst(fields, names, messageFrame))
				{
					f_query_add_mod.document.QuickLink_Form.submit();
					reset();
				}
			}
			if(ql_type == 'EX')
			{
				fields = new Array(f_query_add_mod.document.QuickLink_Form.url,f_query_add_mod.document.QuickLink_Form.desc);
				names = new Array (getLabel("eCA.ExternalURL.label",'CA'),getLabel("Common.description.label",'common'));
				if(checkFieldsofMst(fields, names, messageFrame)){
					f_query_add_mod.document.QuickLink_Form.submit();
					reset();					
				}
			}
			if(ql_type == 'AM'){				
									
				fields = new Array(f_query_add_mod.document.QuickLink_Form.function_adpt);
				names = new Array (getLabel("eCA.AdaptiveMenu.label",'CA'));
				if(checkFieldsofMst(fields, names, messageFrame))
				{
					paneldetails.document.Linked_form.ql_type.value=f_query_add_mod.document.QuickLink_Form.ql_type.value;	
					paneldetails.document.Linked_form.adpt_function_name.value=f_query_add_mod.document.QuickLink_Form.adpt_id.value;	
					paneldetails.document.Linked_form.desc.value=f_query_add_mod.document.QuickLink_Form.desc.value;	
					paneldetails.document.Linked_form.eff_status.value=f_query_add_mod.document.QuickLink_Form.eff_status.value;	
					paneldetails.document.Linked_form.action = '../../servlet/eCA.QuickLinksServlet';
					paneldetails.document.Linked_form.target = 'messageFrame';
					paneldetails.document.Linked_form.submit();
					reset();
				}
			}				
	
		}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}

function reset()
{
	if(f_query_add_mod.document.getElementById("mode"))
	{
					
		var mode = f_query_add_mod.document.getElementById("mode").value;
		if(mode=="insert")
		{
			
			if(f_query_add_mod.document.forms[0])
			{
				
				f_query_add_mod.document.forms[0].reset();				
				f_query_add_mod.location.href='../../eCA/jsp/DefineQuickLinksAddModify.jsp';					
				// panel.rows='8%,70%,*,8%';
				document.getElementsByName('panel')[0].setAttribute('rows','8%,70%,*,8%');
				paneldetails.location.href='../../eCommon/html/blank.html';	
				paneladd.location.href='../../eCommon/html/blank.html';	
				f_query_add_mod.document.getElementById("criteria").innerHTML ='';
				
			}
		}
		else
		{
			
			f_query_add_mod.location.reload();

		}
	}
	else
	{
		if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();

	}
}

  
function showFields(obj)
{
	var mode = document.getElementById("mode").value;

	if(obj.value != null && obj.value != '')
	{

		if(obj.value=='AM'){			
			document.getElementById("adpt").style.display ='';
			document.getElementById("desc_field").style.display ='none';
			document.getElementById("functionHide").style.display ='none';
			document.getElementById("External_URL").style.display ='none';
			document.getElementById("scope_id").style.display ='none';			
			document.getElementById("searchBoxBG").style.display ='';
			document.getElementById("criteria").style.display ='none';		
			
		}
		else{			
			// parent.panel.rows='8%,70%,*,8%';	
//			console.log("NEW" + parent.document.getElementsByName('panel')[0]) ;
			parent.document.getElementsByName('panel')[0].setAttribute('rows', '8%,70%,*,8%');
			

			document.QuickLink_Form.function_adpt.value = '';
			document.QuickLink_Form.desc.value = '';
			document.getElementById("desc_field").style.display ='';
			document.getElementById("functionHide").style.display ='';			
			document.getElementById("adpt").style.display ='none';			
			document.getElementById("External_URL").style.display ='';
			document.getElementById("scope_id").style.display ='';
			parent.frames[2].location.href="../../eCommon/html/blank.html"
			parent.frames[3].location.href="../../eCommon/html/blank.html"	
		}
		if(obj.value == 'AF' || obj.value == 'EX')
		{
			if(obj.value == 'AF')
			{
				document.QuickLink_Form.desc.disabled = true;
				document.QuickLink_Form.desc.value = '';
				document.QuickLink_Form.url.disabled = true;
				document.QuickLink_Form.url.value = '';
				document.QuickLink_Form.function_name.disabled = false;
				document.QuickLink_Form.search_ref.disabled = false;
			}
			else if(obj.value == 'EX')
			{
				document.QuickLink_Form.url.disabled = false;
				document.QuickLink_Form.function_name.disabled = true;
				document.QuickLink_Form.function_name.value = '';
				document.QuickLink_Form.function_id.value = '';
				document.QuickLink_Form.search_ref.disabled = true;
				document.QuickLink_Form.desc.disabled = false;
			}
			document.QuickLink_Form.global.checked = true;
			document.QuickLink_Form.global.disabled = true;
			document.QuickLink_Form.global.value = 'Y';
			document.QuickLink_Form.global1.value = 'Y';
			document.QuickLink_Form.function_spec.checked = false;
			document.QuickLink_Form.function_spec.disabled = true;
			document.QuickLink_Form.function_spec.value = 'N';
			document.QuickLink_Form.function_spec1.value = 'N';
			document.QuickLink_Form.function_name.value = '';
			document.QuickLink_Form.function_id.value = '';
			document.getElementById("criteria").style.display ='none';
		}
		
		else
		{
			
			document.QuickLink_Form.desc.disabled = false;
			document.QuickLink_Form.global.checked = false;
			document.QuickLink_Form.global.disabled = false;
			document.QuickLink_Form.global.value = 'N';
			document.QuickLink_Form.global1.value = 'N';
			document.QuickLink_Form.function_spec.checked = false;
			document.QuickLink_Form.function_spec.disabled = false;
			document.QuickLink_Form.function_spec.value = 'N';
			document.QuickLink_Form.function_spec1.value = 'N';
		}
		if(obj.value == 'QF')
		{
			document.QuickLink_Form.url.disabled = true;
			document.QuickLink_Form.url.value = '';
			document.QuickLink_Form.function_name.disabled = false;
			document.QuickLink_Form.search_ref.disabled = false;
			document.QuickLink_Form.function_spec.checked = true;
			document.QuickLink_Form.function_spec.value = 'Y';
			document.QuickLink_Form.function_spec1.value = 'Y';
			document.getElementById("searchBoxBG").style.display ='';
			if(document.getElementById("function_name").value != '' && document.getElementById("function_id").value != '')
			{
				document.getElementById("criteria").style.display ='';
				enableCriteria(document.getElementById("function_id").value);
			}
		}
		else
		{
			document.getElementById("searchBoxBG").style.display ='inline';
		}
		if(obj.value == 'QF' || obj.value == 'AF')
			document.QuickLink_Form.mand_fun.style.display = '';
		else
			document.QuickLink_Form.mand_fun.style.display = 'none';

		if(obj.value == 'QF' || obj.value == 'EX')
			document.QuickLink_Form.mand_desc.style.display = '';
		else
			document.QuickLink_Form.mand_desc.style.display = 'none';

		if(obj.value == 'EX')
		{
			document.QuickLink_Form.mand_url.style.display = '';
			document.getElementById('ExtApp').style.display='';
			document.getElementById("browser_chk").style.display=''; //IN27709
			document.getElementById("validateURL").innerHTML = "<b><font size='1' color=red>( "+getLabel('eCA.ValidateURL.label','CA')+" )<br>(<B>Note: Only below fields can be used as URL parameter values (Ex : Patient_id=~PATIENT_ID`) which can be replaced with actuals values in transaction.</B> <br/>~PATIENT_ID`,~ENCOUNTER_ID`,~FACILITY_ID`,~NRIC`,~LOGIN_USERID`,~PATIENT_NAME`,~AGE`,~GENDER`,~VISIT_TYPE_DESC`)</font></font></b>"; //IN27709
		}
		else
		{
			document.QuickLink_Form.mand_url.style.display = 'none';
			document.getElementById('ExtApp').style.display='none';
			document.getElementById("browser_chk").style.display='none'; //IN27709
			document.getElementById("validateURL").innerHTML = '';
		}
	}
	else
	{		
		// parent.panel.rows='8%,34%,*,8%';
		parent.document.getElementsByName('panel')[0].setAttribute('rows', '8%,34%,*,8%');

		parent.frames[2].location.href="../../eCommon/html/blank.html"
		parent.frames[3].location.href="../../eCommon/html/blank.html"	
		
		document.location.href='../../eCA/jsp/DefineQuickLinksAddModify.jsp?mode=insert';
	}
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	
}

function setValue(obj)
{
	if(obj.name == 'function_spec')
	{
		if(obj.checked == true)
		{
			obj.value = 'Y';
			document.QuickLink_Form.function_spec1.value = 'Y';
		}
		else
		{
			obj.value = 'N';
			document.QuickLink_Form.function_spec1.value = 'N';
		}
	}
	else if(obj.name == 'global')
	{
		if(obj.checked == true)
		{
			obj.value = 'Y';
			document.QuickLink_Form.global1.value = 'Y';
		}
		else
		{
			obj.value = 'N';
			document.QuickLink_Form.global1.value = 'N';
		}
	}
}
async function getAdptFunction()
{
	
	var retVal				= new String();
	var dialogTop			= "160";
	var dialogHeight		= "480px" ;
	var dialogWidth			= "750px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_text			= document.QuickLink_Form.function_adpt.value;
	var ql_type			= document.QuickLink_Form.ql_type.value;		
	var target				= document.QuickLink_Form.function_adpt;
	
	var title				= getLabel("Common.Function.label",'common');	 
	retVal = await window.showModalDialog("../../eCA/jsp/QuickLinksFunctionSearchMain.jsp?search_text="+search_text+"&ql_type="+ql_type+"&title="+title+"&CA=CA",arguments,features);		
	// console.log(retVal);
	var arr = new Array();	
	var adpt_id = "";
	var search_text			= document.QuickLink_Form.function_adpt.value;
	if (retVal != null && retVal != ''&&retVal !='undefined' )
	{

		var retVal = unescape(retVal);
		arr = retVal.split("::");
		
		document.QuickLink_Form.function_adpt.value = arr[0];
		document.QuickLink_Form.adpt_id.value = arr[1];	
		adpt_id = document.QuickLink_Form.adpt_id.value;
		
		if(document.getElementById("ql_type").value == 'AM')
		{
		// parent.panel.rows='8%,20%,*,8%';
		parent.document.getElementsByName('panel')[0].setAttribute('rows', '8%,20%,*,8%');

		//parent.frames[2].location.href='../../eCA/jsp/AdaptiveMenuLinkedFunctionsOrder.jsp?load=load';
		
		parent.frames[2].location.href='../../eCA/jsp/AdaptiveMenuLinkedFunctionsOrder.jsp?adpt_id='+adpt_id+'&ql_type='+ql_type+'&load=load';
		parent.frames[3].location.href='../../eCA/jsp/AdaptiveMenuLinkedFunctions.jsp?mode=insert';			
		}
	}
	else
	{
		document.QuickLink_Form.function_adpt.value = '';
		document.QuickLink_Form.adpt_id.value = '';
	}	


}
function getAdptFunction1(obj)
{
	if(obj.value != null && obj.value != '')
	{
		getAdptFunction();
	}
	else
	{
		document.QuickLink_Form.adpt_id.value = '';
		document.QuickLink_Form.desc.value = '';
		document.getElementById("criteria").style.display ='none';
	}

}
function loadLinkedFunck(obj)
{	
	if(obj.value ==null || obj.value =='')
	{	
		parent.frames[2].location.href="../../eCommon/html/blank.html"
			parent.frames[3].location.href="../../eCommon/html/blank.html"
	}

}
async function getFunction()
{
	
	var retVal				= new String();
	var dialogTop			= "160";
	var dialogHeight		= "480px" ;//updated by Arvind @ 08-12-08
	var dialogWidth			= "750px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_text			= document.QuickLink_Form.function_name.value;
	var ql_type			    = document.QuickLink_Form.ql_type.value;	
	var target				= document.QuickLink_Form.function_name;
	
	
	var title				= getLabel("Common.Function.label",'common');
	// retVal = window.showModalDialog("../../eCA/jsp/QuickLinksFunctionSearchMain.jsp?search_text="+search_text+"&ql_type="+ql_type+"&title="+title,arguments,features);
	retVal = await window.showModalDialog("../../eCA/jsp/QuickLinksFunctionSearchMain.jsp?search_text="+search_text+"&ql_type="+ql_type+"&title="+encodeURIComponent(title,"UTF-8")+"&AM=AM",arguments,features); 
	// console.log(retVal) ;
	var arr = new Array();	
	var search_text	= document.QuickLink_Form.function_name.value;
	if (retVal != null && retVal != '' && retVal !='undefined' )
	{

		var retVal = unescape(retVal);
		arr = retVal.split("::");

		document.QuickLink_Form.function_name.value = arr[0];
		document.QuickLink_Form.function_id.value = arr[1];		
		if(document.getElementById("ql_type").value == 'AF')
			document.QuickLink_Form.desc.value = arr[0];
	}
	else
	{
		document.QuickLink_Form.function_name.value = '';
		document.QuickLink_Form.function_id.value = '';

	}

	var function_id = document.QuickLink_Form.function_id.value;
	document.QuickLink_Form.global.disabled=false;
	if(function_id != null && function_id != '')
	{
		if(document.getElementById("ql_type").value == 'QF')
		{
			document.getElementById("criteria").style.display ='';
			document.getElementById("searchBoxBG").style.display ='inline';
			enableCriteria(function_id);
		}
		else{
			document.getElementById("criteria").style.display = 'none';
			document.getElementById("searchBoxBG").style.display ='none';
		}
	
		if(function_id=="PREVIOUS_NOTES"){
			document.QuickLink_Form.global.disabled=true;
		}
		//Added below if for IN061898
		if(function_id=="CA_TASK_LIST"){
			document.QuickLink_Form.global.disabled=true;
			document.QuickLink_Form.global.checked=false;
			document.QuickLink_Form.global.value = "N";
			
		}
	}
}

function getFunction1(obj)
{
	if(obj.value != null && obj.value != '')
	{
		getFunction();
	}
	else
	{
		document.QuickLink_Form.function_id.value = '';
		document.QuickLink_Form.desc.value = '';
		document.getElementById("criteria").style.display ='none';
	}
}
function validateURL(obj)
{
	if(obj.value != '')
	{
		var urlPattern = /^(http:\/\/www.|https:\/\/www.|ftp:\/\/www.|www.){1}[0-9A-Za-z\.\-]+\.[0-9A-Za-z\.\-\/]*$/; 
		if(!urlPattern.test(obj.value))
		{
			var ipPattern = /^(http:\/\/|https:\/\/|ftp:\/\/)(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3}){1}[0-9A-Za-z\-\/\.]*$/;
			
			if(!ipPattern.test(obj.value))
			{
				var addPattern = /^(http:\/\/|https:\/\/|ftp:\/\/){1}[0-9A-Za-z\-]+:(\d{4})\/{1}[0-9A-Za-z\-\/\.]*$/;
			
				if(!addPattern.test(obj.value))
				{
					var get_confirmation = confirm(getMessage("NOT_STANDARD_URL","CA"))
					if(!get_confirmation)
						obj.focus();
				}
			}
		}
	}
}

function enableCriteria(obj)
{

	var ql_ref = document.QuickLink_Form.ql_ref.value;
	var mode = document.QuickLink_Form.mode.value;
	var locale = document.QuickLink_Form.locale.value;
	var facilityId = document.QuickLink_Form.facilityId.value;
	var clinician_id = document.QuickLink_Form.clinician_id.value;
	var pract_type = document.QuickLink_Form.pract_type.value;
	var grphistory_type= document.QuickLink_Form.grphistory_type.value;//IN071596
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/DefineQuickLinksIntermediate.jsp?function_id="+obj+"&ql_ref="+ql_ref+"&mode="+mode+"&locale="+locale+"&facilityId="+facilityId+"&clinician_id="+clinician_id+"&pract_type="+pract_type+"&grphistory_type="+grphistory_type, false);//IN071596
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = responseText.replace(/<!DOCTYPE html>/gi, ''); // removing <!DOCTYPE html> string
	// console.log(responseText) ;
	eval( responseText ) ;
}

function setStatus(obj)
{
		if(obj.checked == true)
		obj.value = 'E';
	else
		obj.value = 'D';
}

function enableActual(obj,index)
{
	var listTypeElement = document.getElementById("list_type"+index);
	var list_type = eval(listTypeElement).value;
	if(obj.checked == true)
	{
		if(list_type == 'V')
		{
			eval(document.getElementById("actual_val_text"+index)).disabled = false;
			eval(document.getElementById("search_ref"+index)).disabled = false;
		}
		else
			eval(document.getElementById("actual_val"+index)).disabled = false;
		eval(document.getElementById("relative_val"+index)).disabled = true;
		eval(document.getElementById("relative_val"+index)).value = '';
		eval(document.getElementById("value_type"+index)).value = 'A';
	}
	else
	{
		if(list_type == 'V')
		{
			var dependency = eval(document.getElementById("dependency"+index)).value;		
			var count = document.getElementById("count").value;
			var arr = new Array();
			arr = dependency.split("|");
			for(var l=0;l<arr.length;l++)
			{
				for(j=0;j<count;j++)
				{
					if(eval(document.getElementById("column_id"+j)).value == arr[l])
					{					
						var depend_value =eval("document.QuickLink_Form.depend_value"+j);
						depend_value .value = "";						
					}
				}
			}
			//eval("document.getElementById("depend_value")"+index).value = "";
			//eval("document.getElementById("dependency")"+index).value = "";
			eval(document.getElementById("actual_val_text"+index)).disabled = true;
			eval(document.getElementById("actual_val_text"+index)).value = '';
			eval(document.getElementById("actual_val"+index)).value = '';
			eval(document.getElementById("search_ref"+index)).disabled = true;
		}
		else
		{
			eval(document.getElementById("actual_val"+index)).disabled = true;
			eval(document.getElementById("actual_val"+index)).value = '';
		}
		eval(document.getElementById("relative_val"+index)).disabled = false;
		eval(document.getElementById("value_type"+index)).value = 'R';
	}
}

function onSuccess()
{
	f_query_add_mod.location.href='../../eCA/jsp/DefineQuickLinksAddModify.jsp?mode=insert';
	//frames[2].location.href='../../eCommon/html/blank.html';	
	//frames[3].location.href='../../eCommon/html/blank.html';	
	create();
}

async function openLookup(i,histtype)//IN073728
{	
	// console.log(histtype);
	//IN073728 Starts
	if(undefined ==histtype)
		histtype = "";
	//IN073728 Ends
	var target = eval("document.QuickLink_Form.actual_val_text"+i+histtype);//IN073728
	var source = eval("document.QuickLink_Form.query"+i+histtype).value;//IN073728
	var column_id = eval("document.QuickLink_Form.column_id"+i+histtype).value;//IN073728
	
	var title = eval("document.QuickLink_Form.column_desc"+i+histtype).value;//IN073728
	var locale = document.QuickLink_Form.locale.value;
	var facilityId = document.QuickLink_Form.facilityId.value;
	var clinician_id = document.QuickLink_Form.clinician_id.value;
	var pract_type = document.QuickLink_Form.pract_type.value;
	var depend_column_id = eval("document.QuickLink_Form.dep_col_Id"+i+histtype).value;//IN073728
	var depend_value = '\''+eval("document.QuickLink_Form.depend_value"+i+histtype).value+'\'';//IN073728
	var function_id = document.getElementById("function_id").value;
	var evn_calss ="";//IN072762
	var evn_grp  ="";//IN072762
	if(function_id == "FLOW_SHEET_NEW")//IN069654
	var grphistory_type= eval(document.getElementById("grphistory_type")).value;//IN069654
//Adding start for IN072762
	if(grphistory_type =="MEDN" && column_id == "EVENT_CLASS")
		 searchOrderType(target,i);
	else if(grphistory_type =="MEDN" && column_id == "EVENT_ITEM"){
		   evn_calss = eval(document.getElementById("actual_val"+(i-2))).value;
		   evn_grp   = eval(document.getElementById("actual_val_text"+(i-1))).value;
		   searchDrugName (target,i,evn_calss,evn_grp)
    }else{//Adding and for IN072762
	// IN051294 start
	//if (function_id == "PREVIOUS_NOTES" && column_id == "NOTE_TYPE")
	if ((function_id == "PREVIOUS_NOTES" && column_id == "NOTE_TYPE")||(function_id == "PHYSICIAN_NOTES" && column_id == "NOTE_TYPE"))
	//IN051294 ends
	{
		if (depend_value == "''")
		{
			source = source+" order by 2";		
		}else{		
			source = source+" and NOTE_GROUP_ID = "+depend_value+" order by 2"
		}
	}
	
	locale = '\''+locale+'\'';
	facilityId = '\''+facilityId+'\'';
	clinician_id = '\''+clinician_id+'\'';
	pract_type = '\''+pract_type+'\'';
	//hist_rec_type = '\''+grphistory_type+'\'';//IN069654//IN073728
	hist_rec_type = '\''+histtype+'\'';//IN073728
	var sql = "";
	
	if(source.indexOf('?') != -1)
	{
	 source = source.replace(/\?/g,'^');
	}

	if(source.indexOf('&&') != -1)
	{
		var ret = construct(source);
		source = ret[0];
		for(var k=1;k<ret.length;k++)
		{
			var param = ret[k];
			if(param == "LANGUAGE_ID")
				source = source.replace('?',locale);
			else if(param == "FACILITY_ID")
				source = source.replace('?',facilityId);
			else if(param == "PRACTITIONER_ID")
				source = source.replace('?',clinician_id);
			else if(param == "PRACT_TYPE")
				source = source.replace('?',pract_type);
			if(function_id == "FLOW_SHEET_NEW"){//IN069654 starts
			 if(param == "HIST_REC_TYPE")
				source = source.replace('?',hist_rec_type);
			}//IN069654ends
			else if(param == depend_column_id)
			{
				//Added By Jyothi on 02/06/2010 to fix IN020967
				if(function_id == "BY_LOCATION" && param == 'PATIENT_CLASS')
				{
					if(depend_value == "'IP'" || depend_value == "'DC'")
						source = source.replace('?','\'W\'');
					else if(depend_value == "'OP'" || depend_value == "'EM'")
						source = source.replace('?','\'C\'');
					else
						source = source.replace('?','\'\'');
				}
				else
					source = source.replace('?',depend_value);
			}
		}
	}
	
	if(source.indexOf('^') != -1)
	{
		source=source.replace(/\^/g,'?');
	}
	sql = source;
	
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "2,1";
	argArray[5] = trimString(target.value);
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	var retVal = await CommonLookup( title, argArray )
	// console.log(retVal) ;
	if (retVal != null && retVal != '' && retVal != "null")
	{
		
		eval(document.getElementById("actual_val_text"+i+histtype)).value = retVal[0].split(',')[1]; //retVal[1];//IN073728
		eval(document.getElementById("actual_val"+i+histtype)).value = retVal[0].split(',')[0]; // retVal[0];//IN073728
	}
	else
	{
		eval(document.getElementById("actual_val_text"+i+histtype)).value = "";//IN073728
		eval(document.getElementById("actual_val"+i+histtype)).value = "";//IN073728
	}

	var dependency = eval(document.getElementById("dependency"+i+histtype)).value;//IN073728
	var count = document.getElementById("count").value;
	if(dependency != '' && dependency != null)
	{
		
		if(eval(document.getElementById("actual_val"+i+histtype)).value != '')//IN073728
		{
			var arr = new Array();
			arr = dependency.split("|");
			for(var l=0;l<arr.length;l++)
			{
				for(j=0;j<count;j++)
				{
					if(eval(document.getElementById("column_id"+j+histtype)).value == arr[l])//IN073728
					{
						if (function_id != "PREVIOUS_NOTES" && column_id != "NOTE_TYPE")
						{							
							eval(document.getElementById("actual_val_text"+j+histtype)).disabled = false;//IN073728
							eval(document.getElementById("search_ref"+j+histtype)).disabled = false;//IN073728
						}
						eval(document.getElementById("depend_value"+j+histtype)).value = eval(document.getElementById("actual_val"+i+histtype)).value;//IN073728
					}
				}
			}
		}
	}
	else
	{
		
	if(eval(document.getElementById("actual_val"+i)).value != '')
		{
			var arr = new Array();
			arr = dependency.split("|");
			for(var l=0;l<arr.length;l++)
			{
				for(j=0;j<count;j++)
				{
					if(eval(document.getElementById("column_id"+j+histtype)).value == arr[l])//IN073728
					{
						eval(document.getElementById("actual_val_text"+j+histtype)).disabled = false;//IN073728
						eval(document.getElementById("search_ref"+j+histtype)).disabled = false;//IN073728
						eval(document.getElementById("depend_value"+j+histtype)).value = "";//IN073728
					}
				}
			}
		}
	}
	}

}
function openLookup1(obj,i,histtype)//IN073728
{	
	//IN073728 Starts
	if(undefined ==histtype)
		histtype = "";
	//IN073728 Ends
	if(obj.value != null && obj.value !='') {		
		openLookup(i,histtype);//IN073728
	}else if(obj.value =='')
	{
		var actualVal = document.getElementById("actual_val"+i+histtype);
	    eval(actualVal).value = '';//IN073728
		var dependency = eval(document.getElementById("dependency"+i+histtype)).value;//IN073728		
		var count = document.getElementById("count").value;
		var arr = new Array();
		arr = dependency.split("|");
		for(var l=0;l<arr.length;l++)
		{
			for(j=0;j<count;j++)
			{
				if(eval(document.getElementById("column_id"+j+histtype)).value == arr[l])//IN073728
				{					
					if (document.getElementById("function_id").value != "PREVIOUS_NOTES")
					{
						eval(document.getElementById("actual_val_text"+j+histtype)).disabled = true;//IN073728
						eval(document.getElementById("search_ref"+j+histtype)).disabled = true;//IN073728		
						eval(document.getElementById("actual_val"+j+histtype)).value = '';//IN073728
						eval(document.getElementById("actual_val_text"+j+histtype)).value = '';//IN073728
						if (document.getElementById("function_id").value == "BY_LOCATION")
						{
							var depend_value =eval("document.QuickLink_Form.depend_value"+j+histtype);//IN073728
							depend_value .value = "";
							eval(document.getElementById("actual_val_text"+j+histtype)).disabled = false;//IN073728

						}

					}else{
						var depend_value =eval("document.QuickLink_Form.depend_value"+j+histtype);//IN073728
						depend_value .value = "";						
					}	
					
				}
			}
		}
	}
}

function construct(query)
{
	var retVal = "";
	var count = 0;
	if(query.indexOf("~") != -1)
		query = query.replace(/~/g,"'");
	if(query.indexOf("&&") == query.lastIndexOf("&&"))
		retVal = new Array(2);
	else
	{
		var start_index = 0;
		while(true)
		{
			start_index = query.indexOf("&&", start_index);
			if(start_index == -1)
				break;
			else
			{
				count++;
				start_index += 2;
			}
		}
		retVal = new Array(count+1);
	}
	count = 1;
	
	while(query.indexOf("&&") != -1)
	{
		var paramValue = query.substring(query.indexOf("&&")+2,query.indexOf("##"));
		var substr = query.substring(query.indexOf("&&"),query.indexOf("##")+2);
		query = query.replace(substr,"?");
		retVal[count] = paramValue;
		count++;
	}
	retVal[0] = query;
	return retVal;
}

function makeEnable(obj,i,histtype)//IN073728
{	
	//IN073728 Starts
	if(undefined ==histtype)
		histtype = "";
//IN073728 Ends
		
	if(obj.checked == true)
	{
		obj.value = 'Y';
		var dependency = eval(document.getElementById("dependency"+i+histtype)).value;//IN073728
		var count = document.getElementById("count").value;	
		
		if(dependency != '' && dependency != null)
		{
			var arr = new Array();
			arr = dependency.split("|");
			for(var l=0;l<arr.length;l++)
			{
				for(j=0;j<count;j++)
				{
					
					if(eval(document.getElementById("column_id"+j+histtype)).value == arr[l])//IN073728
					{
						if(eval(document.getElementById("actual_check"+j+histtype)) != null)//IN073728
						{							
							if(eval(document.getElementById("actual_check"+j+histtype)).checked == true)//IN073728
							{//alert("1");
								eval(document.getElementById("actual_val_text"+j+histtype)).disabled = false;//IN073728
								eval(document.getElementById("search_ref"+j+histtype)).disabled = false;//IN073728
								eval(document.getElementById("depend_value"+j+histtype)).value = eval(document.getElementById("actual_val"+i+histtype)).value;//IN073728
								//eval("document.getElementById("relative_val")"+i).disabled=false;
							}
							else
							{//alert("2");
								eval(document.getElementById("relative_val"+j+histtype)).disabled = false;//IN073728
								eval(document.getElementById("relative_val"+j+histtype)).value = '';//IN073728
							}
						}
						else
						{							
							if (arr[l] == "VIEW_MODE")
							{//alert("3");
								eval(document.getElementById("actual_val"+j+histtype)).disabled = true;	//changed//IN073728	
								eval(document.getElementById("actual_val"+j+histtype)).options[0].selected = true;
								eval(document.getElementById("actual_val"+j+histtype)).value="";//IN073728
								//eval("document.getElementById("actual_val_text")"+j).disabled = true;

							}else{//alert("4");
								eval(document.getElementById("actual_val_text"+j+histtype)).disabled = false;//IN073728
								eval(document.getElementById("search_ref"+j+histtype)).disabled = false;//IN073728
								eval(document.getElementById("depend_value"+j+histtype)).value = eval(document.getElementById("actual_val"+i+histtype)).value;//IN073728
							}
						}
					}
				}
			}
		}
	}
	else
	{
		
		obj.value = 'N';
		var dependency = eval(document.getElementById("dependency"+i+histtype)).value;//IN073728
		//dependency="";
		//alert("dependency "+dependency);
		var count = document.getElementById("count").value;
		if(dependency != '' && dependency != null)
		{
			var arr = new Array();
			arr = dependency.split("|");
			for(var l=0;l<arr.length;l++)
			{
				for(j=0;j<count;j++)
				{
					if(eval(document.getElementById("column_id"+j+histtype)).value == arr[l])//IN073728
					{
						if(eval(document.getElementById("actual_check"+j+histtype)) != null)//IN073728
						{
							if(eval(document.getElementById("actual_check"+j+histtype)).checked == true)//IN073728
							{
								eval(document.getElementById("actual_val_text"+j+histtype)).disabled = true;//IN073728
								eval(document.getElementById("search_ref"+j+histtype)).disabled = true;//IN073728
								eval(document.getElementById("actual_val"+j+histtype)).value = '';//IN073728
								eval(document.getElementById("actual_val_text"+j+histtype)).value = '';//IN073728
							}
							else
							{
								eval(document.getElementById("relative_val"+j+histtype)).disabled = false;//IN073728
								eval(document.getElementById("relative_val"+j+histtype)).value = '';//IN073728
							}
						}
						else
						{
							if (arr[l] == "VIEW_MODE")
							{
								eval(document.getElementById("actual_val"+j+histtype)).disabled = false;	//changed//IN073728
								eval(document.getElementById("actual_val"+j+histtype)).options[0].selected = true;//IN073728
								eval(document.getElementById("actual_val"+j+histtype)).value="";//IN073728
							}else{
								eval(document.getElementById("actual_val_text"+j+histtype)).disabled = true;//IN073728
								eval(document.getElementById("search_ref"+j+histtype)).disabled = true;//IN073728
								eval(document.getElementById("actual_val"+j+histtype)).value = '';//IN073728
								eval(document.getElementById("actual_val_text"+j+histtype)).value = '';//IN073728
							}
						}
					}
				}
			}
		}
	}
}

function staticTitle()
{
	var scrollXY = document.body.scrollTop;
	//IN073728 Starts
	var function_id =  document.getElementById("function_id").value;
	if(function_id == "FLOW_SHEET_NEW"){
		var totalHistTypesCount=document.getElementById("totalHistTypes").value;
		for(var i=0;i<totalHistTypesCount;i++){
			var histtype =  document.getElementById("eventHistStr"+i).value;
			if(undefined!=document.getElementById('ql_crit_div'+i+histtype) && document.getElementById('ql_crit_div'+i+histtype).style.display=="inline" )
			{
				var currPos = document.getElementById('ql_crit_div'+i+histtype).offsetTop;

				if(parseInt(scrollXY)>200){
					document.getElementById("ql_crit_div").style.position = 'relative';
					document.getElementById("ql_crit_div").style.posTop  = parseInt(scrollXY)-222;
					}
				else if(parseInt(scrollXY)==0)
				{
					document.getElementById("ql_crit_div").style.posTop  = 0;
			
				}
				return;
			}
		}
	
	}
	
	else{//IN073728 Ends
		var currPos = document.getElementById('ql_crit_div').offsetTop;

		if(parseInt(scrollXY)>200){
			document.getElementById("ql_crit_div").style.position = 'relative';
			document.getElementById("ql_crit_div").style.posTop  = parseInt(scrollXY)-222;
			}
		else if(parseInt(scrollXY)==0)
		{
			document.getElementById("ql_crit_div").style.posTop  = 0;
	
		}
	}//IN073728
	
}
function alignWidth(){
	var function_id =  document.getElementById("function_id").value;
	if(function_id != "FLOW_SHEET_NEW"){//IN073728
	var totalRows =  document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = document.getElementById("dataTitleTable").rows[2].cells.length;
	for(var i=0;i<temp;i++) {
		document.getElementById("dataTitleTable").rows[2].cells[i].width=document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
	}
	}//IN073728
}
/*Below function added by channaveer B on 14/04/2010 for External application*/
function callExternalList()
{
	var parameterName = document.getElementById("parameterName").value;
	var param_name = document.getElementById("param_list").value;
	var  new_value = parameterName+"="+param_name;

	if(param_name !=null && param_name !="" && parameterName != null && parameterName != "" )
	{
        document.getElementById("externalParamResult").focus();
		if (QuickLink_Form.externalParamResult.value=="")
		{
			 // QuickLink_Form.externalParamResult.document.execCommand("paste","",new_value);
			QuickLink_Form.externalParamResult.value = new_value ;
		}else
		{
			// QuickLink_Form.externalParamResult.document.execCommand("paste","",new_value+"&");
			QuickLink_Form.externalParamResult.value = new_value+"&"+QuickLink_Form.externalParamResult.value;
			
		}
		document.getElementById("parameterName").value = "";
		document.getElementById("param_list").value = "";
	}else{
		if(parameterName == "" || param_name != "")
		{
			alert(getMessage("PARAM_LIST_NOT_BLNK","CA"));
			document.getElementById("parameterName").focus();
		}
		else if(parameterName != "" || param_name == "")
		{
			alert(getMessage("PARAM_LIST_NOT_BLNK","CA"));
			document.getElementById("param_list").focus();
		}
			//alert(getMessage("PARAM_LIST_NOT_BLNK","CA"));
			// document.getElementById("parameterName").focus();
	}
}
/*ends here*/
/*Below function added by channaveer B on 22/04/2010 for External application*/
function CheckForSpecChars(event){
	
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}
/*ends here */
// Added By Channaveer B on 30/07/2010 
//called from Quick link setup to check Maxlength of a textarea.
function chkMaxLenForLongTest(textarea_name,maxLen)
{	
	
	if (maxLen == undefined || maxLen == null || maxLen == "")
	{
		maxLen = 3000;
	}
	
	var textArea	 = eval("document.forms[0]."+textarea_name);
	var val	 = textArea.value;
	var valLength	 = val.length;	
	if (parseInt(valLength)  > maxLen)
	{		
		var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
		msg = msg.replace("$","Constructed Parameter list");
		msg = msg.replace("#",maxLen);
		alert(msg);
		textArea.focus();
		return false;
	}
	
}
//IN071596 starts
function selecthistype(obj)
{
	
	document.QuickLink_Form.grphistory_type.value=obj.value;
	enableCriteria(document.getElementById("function_id").value);//added for IN072762
}
//IN071596 ends
//Adding start for IN072762
async function searchOrderType(target,i){ 
	var formObj = document.QuickLink_Form;
								
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;


	
	var language_id=document.QuickLink_Form.locale.value;

	argumentArray[0]   = "Select  ORDER_TYPE_CODE code,short_desc description from or_order_type where upper(ORDER_TYPE_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) and ORDER_CATEGORY =  'PH' ";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";	
   	argumentArray[5]   = trimString(target.value);
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal=await CommonLookup(getLabel("Common.GenericName.label","Common"), argumentArray );
	
	if (retVal != null && retVal != '' && retVal != "null")
	{
		
		eval(document.getElementById("actual_val_text"+i)).value = retVal[1];
		eval(document.getElementById("actual_val"+i)).value = retVal[0];
	}
	else
	{
		eval(document.getElementById("actual_val_text"+i)).value = "";
		eval(document.getElementById("actual_val"+i)).value = "";
	}
}

function assignevngrp(obj,i,histtype){
	
		//IN073728 Starts
		if(undefined ==histtype)
			histtype = "";
		//IN073728 Ends

	    eval(document.getElementById("actual_val_text"+i+histtype)).value = obj.value;
		eval(document.getElementById("actual_val"+i+histtype)).value =obj.value;

}

async function searchDrugName(target,i,evn_class,evn_grp){
	var formObj =document.QuickLink_Form;
	
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		var language_id=document.QuickLink_Form.locale.value;
		if(evn_grp=='D' || evn_grp=='E'){
			if(evn_class != "")
			     argumentArray[0]   = "SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG, or_order_catalog b WHERE  DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DRUG_YN='Y' and ph_drug.drug_code  =b.order_catalog_code and b.order_type_code = '"+evn_class+"' AND LANGUAGE_ID ='"+language_id+"'";
			else
				argumentArray[0]   = "SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DRUG_YN='Y' AND LANGUAGE_ID ='"+language_id+"' ";


		}else if(evn_grp=='M'){ 
			if(evn_class != ""){
			argumentArray[0]   = "SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG, or_order_catalog b WHERE  DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DRUG_YN='N' and ph_drug.drug_code  =b.order_catalog_code and b.order_type_code = '"+evn_class+"' AND LANGUAGE_ID ='"+language_id+"'";
		}else{
			argumentArray[0]   = "SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DRUG_YN='N' AND LANGUAGE_ID ='"+language_id+"'";
		}
		}else{
			if(evn_class != ""){
				alert(evn_class)
			argumentArray[0]   = "SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG, or_order_catalog b WHERE  DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  and ph_drug.drug_code  =b.order_catalog_code and b.order_type_code = '"+evn_class+"' AND LANGUAGE_ID ='"+language_id+"'";
		    }else{
			argumentArray[0]   = "SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID ='"+language_id+"'";
		   }
		}

		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = trimString(target.value);
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = DESC_CODE ; 
		retVal=await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
		if (retVal != null && retVal != '' && retVal != "null")
		{
			eval(document.getElementById("actual_val_text"+i)).value = retVal[1];
			eval(document.getElementById("actual_val"+i)).value = retVal[0];
		}
		else
		{
			eval(document.getElementById("actual_val_text"+i)).value = "";
			eval(document.getElementById("actual_val"+i)).value = "";
		}
	}
//adding end for 
//IN073728 Starts
function selHistType(histSeq)
{ 
	
	var totalHistTypesCount=document.getElementById("totalHistTypes").value;//sivva
	var hist=document.getElementById("eventHistStr"+histSeq).value;
	for(var i=0;i<totalHistTypesCount;i++){
		if(i==histSeq){
			document.getElementById("histTab"+i).className='tabClicked'
			document.getElementById("histTabSpan"+i).className='tabSpanclicked';
			
		}else{
			document.getElementById("histTab"+i).className='tabA'
			document.getElementById("histTabSpan"+i).className='tabAspan';
		}
	}
	document.QuickLink_Form.grphistory_type.value=hist;
	
	enableCriteria(document.getElementById("function_id").value);//added for IN072762
}

function selHistTypeNew(index){
	var totalHistTypesCount=document.getElementById("totalHistTypes").value;
	var histtype;

	for(var i=0;i<totalHistTypesCount;i++){
		if(i==index){
			histtype =  document.getElementById("eventHistStr"+i).value;
			document.getElementById("histTab"+i).className='tabClicked'
			document.getElementById("histTabSpan"+i).className='tabSpanclicked';
			document.getElementById("ql_crit_div"+histtype).style.display = "";
			
			document.getElementById("dataTable"+histtype).style.display = "";
			document.getElementById("histtypeSelected"+histtype).value = "Y";
		}else{
			histtype =  document.getElementById("eventHistStr"+i).value;
		
			document.getElementById("histTab"+i).className='tabA'
			document.getElementById("histTabSpan"+i).className='tabAspan';
			document.getElementById("ql_crit_div"+histtype).style.display = "none";
			document.getElementById("dataTable"+histtype).style.display = "none";
		}
	}
	
}


function enableActualCEH(obj,index,histtype)
{
	var list_type = eval(document.getElementById("list_type"+index+histtype)).value;
	
	if(obj.checked == true)
	{
		if(list_type == 'V')
		{
			eval(document.getElementById("actual_val_text"+index+histtype)).disabled = false;
			eval(document.getElementById("search_ref"+index+histtype)).disabled = false;
		}
		else
			eval(document.getElementById("actual_val"+index+histtype)).disabled = false;
		
		eval(document.getElementById("relative_val"+index+histtype)).disabled = true;
		eval(document.getElementById("relative_val"+index+histtype)).value = '';
		eval(document.getElementById("value_type"+index+histtype)).value = 'A';
	}
	else
	{
		if(list_type == 'V')
		{
			var dependency = eval(document.getElementById("dependency"+index+histtype)).value;		
			var count = document.getElementById("count").value;
			var arr = new Array();
			arr = dependency.split("|");
			for(var l=0;l<arr.length;l++)
			{
				for(j=0;j<count;j++)
				{
					if(eval(document.getElementById("column_id"+j+histtype)).value == arr[l])
					{					
						var depend_value =eval("document.QuickLink_Form.depend_value"+j+histtype);
						depend_value .value = "";						
					}
				}
			}
			
			eval(document.getElementById("actual_val_text"+index+histtype)).disabled = true;
			eval(document.getElementById("actual_val_text"+index+histtype)).value = '';
			eval(document.getElementById("actual_val"+index+histtype)).value = '';
			eval(document.getElementById("search_ref"+index+histtype)).disabled = true;
		}
		else
		{
			eval(document.getElementById("actual_val"+index+histtype)).disabled = true;
			eval(document.getElementById("actual_val"+index+histtype)).value = '';
		}
		eval(document.getElementById("relative_val"+index+histtype)).disabled = false;
		eval(document.getElementById("value_type"+index+histtype)).value = 'R';
		
	}
	
}
//IN073728 Ends
