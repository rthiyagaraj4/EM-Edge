function create() 
{
	f_query_add_mod.location.href = "../../eIP/jsp/PractForNursUnitMain.jsp?operation=insert&function_id="+document.forms[0].function_id.value+"";
	
}

function query() {
	f_query_add_mod.location.href ="../../eIP/jsp/NursUnitPractQueryCriteria.jsp?function_id="+document.forms[0].function_id.value+" " ;
	/*var paramStr = "../../eIP/jsp/NursUnitPractQueryCriteria.jsp?param=create&called_from=1";
	var params = (f_query_add_mod.location.href).split('&');

		for (i=1;i<params.length ;++i )
		{
			if 	(params[i].indexOf('function_id')>-1)
			{
				paramStr = paramStr + '&' + params[i];
			}
		}

	f_query_add_mod.location.href = paramStr ;*/
}

function apply() 
{
	
	//var function_name = parent.frames[1].frames[1].frames[1].document.forms[0].function_name.value;
	var function_name = frames[1].frames[1].document.forms[0].function_name.value;
	var proceed = false;
	if(function_name == "nurs")
	{
		//if(parent.frames[1].frames[1].frames[1].document.forms[0].function_code_desc.value == "")
		if(frames[1].frames[1].document.forms[0].function_code_desc.value == "")
		{
			var msg = getMessage('NU_NOTNULL','IP');
			messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0';
		}
		else
		{
			proceed = true;
		}
	}

	if(function_name == "pract")
	{
		//if(parent.frames[1].frames[1].frames[1].document.forms[0].practitioner_name.value == "")
		if(frames[1].frames[1].document.forms[0].practitioner_name.value == "")
		{
			var msg = getMessage('CAN_NOT_BE_BLANK','Common');
			msg = msg.replace('$',getLabel('Common.practitioner.label','Common'));
			messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
		}
		else
		{
			proceed = true;
		}
	}

	if(proceed)
	{	 
		var isSimplifyPractNursUnit = frames[1].frames[2].document.forms[0].isSimplifyPractNursUnit.value;
		if(isSimplifyPractNursUnit == "true"){
			var start = frames[1].frames[2].document.forms[0].start.value;
			var end = frames[1].frames[2].document.forms[0].end.value;
			
			var c_code_str = "";
			var d_code_str = "";
			var a_code_str = "";
			
			var page = Math.ceil(end / 14);
			
			for(var i = start; i <= end; i++){
				
				var code_fld =  eval("frames[1].frames[2].document.forms[0].removeCode"+i+"");
				
				if(code_fld){
					
					var code =  eval("frames[1].frames[2].document.forms[0].Code"+i+".value");
					
					if(code_fld.value == "N"){
						if(c_code_str == ""){
							c_code_str = code;
						}else{
							c_code_str = c_code_str + ","+ code;				
						}
					}else{
						if(d_code_str == ""){
							d_code_str = code;
						}else{
							d_code_str = d_code_str + ","+ code;				
						}
					}
					
					if(a_code_str == ""){
						a_code_str = code;
					}else{
						a_code_str = a_code_str + ","+ code;				
					}
					
				}
			}
			setSession(a_code_str,c_code_str,d_code_str,page)
		}
		frames[1].frames[2].document.forms[0].action="../../servlet/eIP.NursUnitPractServlet";
		//parent.frames[1].frames[1].frames[2].document.forms[0].target="messageFrame";
		frames[1].frames[2].document.forms[0].target="messageFrame";
		//parent.frames[1].frames[1].frames[2].document.forms[0].submit();
		frames[1].frames[2].document.forms[0].submit();
	}
}

function reset() 
{
	var loc=frames[1].document.forms[0]
	if (loc!=null )
	{
			f_query_add_mod.document.forms[0].reset();
	}
	else if(frames[1].frames[0])
	{
		create();
	}
}

function onSuccess() 
{
	
	if(f_query_add_mod.frames[1].document.forms[0].operation.value=='insert')
	{
		f_query_add_mod.location.href = "../../eIP/jsp/PractForNursUnitMain.jsp?operation=insert";
	}
	else if(f_query_add_mod.frames[1].document.forms[0].operation.value=='modify')
	{
		f_query_add_mod.frames[1].location.href = "../../eCommon/html/blank.html";
	}
}

function checkVal()
{
	var SelectYNStr	=	parent.frames[1].document.forms[0].SelectYNStr.value;
	var fm_cnt=document.forms[0].fm_disp.value;
	var to_cnt=document.forms[0].to_disp.value;

	for (i=fm_cnt; i<=to_cnt;i++)
	{
		var chk		=	eval("document.forms[0].select_yn"+i)
		
		if(chk.checked)
		{
			if((SelectYNStr.indexOf(chk.name+"~")) == -1)
				SelectYNStr += chk.name+"~";
		}
	}
	parent.frames[1].document.forms[0].SelectYNStr.value	=	SelectYNStr;
}

function SelectCBValue(obj1, obj2)
{
	var count;
	var count1;
	var del_obj=obj1.name;
	var del_chk=obj1.checked;
	var del_locn_obj="delete_yn"+obj2;
	var temp_cb_str="";
	var temp_locn_str="";
	var chk_locn=eval('document.forms[0].delete_yn'+obj2);

	if(!(del_chk))
	{
		var SelectYNStr	= parent.frames[1].document.forms[0].SelectYNStr.value;
		if(SelectYNStr =="")SelectYNStr.value="";

		var split=SelectYNStr.split('~');
		for (i=0; i<(split.length-1); i++)
		{
			if(split[i] != del_obj)
			{
				temp_cb_str += split[i]+"~";
			}
			else
			{
				temp_cb_str=temp_cb_str;
			}
		}
		SelectYNStr=temp_cb_str;

		parent.frames[1].document.forms[0].SelectYNStr.value=SelectYNStr;
	}
}

function DeleteCBValue(obj1, obj2)
{}

function dispRecord()
{
	var SelectYNStr	=	parent.frames[1].document.forms[0].SelectYNStr.value;
	if(SelectYNStr != "")
	{
		var val	=	SelectYNStr.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			if(assign!="")
			{
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
}

function selectFunction(obj)
{
	
	var val = obj.id;
	parent.frames[1].location.href="../../eIP/jsp/PractForNursUnitQuery.jsp?function_id=PRACTITIONER_FOR_NURSING_UNIT&Function="+val+"&operation=insert";
	parent.frames[2].location.href="../../eCommon/html/blank.html"
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
}

// moved from PractForNursUnitQuery.jsp

// Added by Sridhar on 6 APR 2004
// This is fired on onClick of the button.... 
// Function will check for empty values & call CommonLookup only when the value in the textbox is empty..
async function checkTxtVal(target_id,target)
{
	
	if(document.forms[0].function_code_desc.value == "")
		await Lookup(target_id,target);
	
}

// Added by Sridhar on 5 APR 2004
// Function will check for empty values before calling up the common lookup func..
function beforeGetNursingUnit(target_id,target)
{
	
	if(document.forms[0].nurs_desc_hid.value != document.forms[0].function_code_desc.value)
	{
		if(document.forms[0].function_code_desc.value != "")
		{	
			 Lookup(target_id,target);
		}	
		else
			if(document.forms[0].function_code_desc.value == "")
			 {
				
			    document.forms[0].nurs_desc_hid.value = "";
				document.forms[0].function_code.value = "";
				
				if(document.forms[0].query.value=="IPOnlineReport")
				{
				  parent.frames[1].location.href="../../eIP/jsp/PractForNursUnitQuery.jsp?query=IPOnlineReport&Function=nurs&operation=insert";
				  parent.frames[2].location.href="../../eCommon/html/blank.html"
				}
				else
				{
				  parent.frames[1].location.href="../../eIP/jsp/PractForNursUnitQuery.jsp?Function=nurs&operation=insert";
				  parent.frames[2].location.href="../../eCommon/html/blank.html"
				}
			 }
	 }
}

function PopulateValues(obj)
{
	
	var val		 = obj.value.toUpperCase();
	var Function = document.forms[0].Function.value; 
	obj.value = val;
	

	if(val!="")
	{
		var function_code=val;
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='nursingunit' id='nursingunit' method='post' action='../../eIP/jsp/PopNursUnitPractValues.jsp'><input type='hidden' name='function_code' id='function_code' value='"+function_code+"'><input type='hidden' name='Function' id='Function' value='"+Function+"'></form></body></html>";	
		parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.frames[2].document.forms[0].submit();

		if(document.forms[0].search_txt!=null)
		{
			document.forms[0].search_txt.value = "";
			document.forms[0].search_by.value  = "00";
			document.forms[0].search_txt.disabled = true;
		}
	}
}

// Added by Sridhar on 6 APR 2004
// This is fired on onClick of the button.... 
// Function will check for empty values & call CommonLookup only when the value in the textbox is empty..

function checkPractTxtVal(obj,target,facility_id)
{
	if(document.forms[0].practitioner_name.value == "")
		getPractitioner(obj,target,facility_id,"","","Q2");
}

// Added by Sridhar on 5 APR 2004
// Function will check for empty values before calling up the common lookup func..
function beforeGetPractitioner(obj,target,facility_id)
{
		if(document.forms[0].pract_desc_hid.value != document.forms[0].practitioner_name.value)
		{
			if(document.forms[0].practitioner_name.value != "")
				getPractitioner(obj,target,facility_id,"","","Q2");
			else if(document.forms[0].practitioner_name.value == "")
			{
				document.forms[0].pract_desc_hid.value = "";
				document.forms[0].function_code.value  = "";
				parent.frames[1].location.href="../../eIP/jsp/PractForNursUnitQuery.jsp?Function=pract&operation=insert";
				parent.frames[2].location.href="../../eCommon/html/blank.html"
			}
		}
	
}

function PractLookupRetVal(retVal,objName)
{
	var arr;

	if (retVal != null)
	{
		arr=retVal.split("~");
	
		if(objName=="practitioner_name")
		{
			var obj="";
			document.forms[0].function_code.value=arr[0];
			document.forms[0].practitioner_name.value=arr[1];
			document.forms[0].pract_desc_hid.value = document.forms[0].practitioner_name.value
			var target_id=document.forms[0].function_code;
			PopulateValues(target_id);
		}
	}
	else
	{
		if(objName=="practitioner_name")
			document.forms[0].function_code.value="";
			document.forms[0].practitioner_name.value="";
	}
}



function submitPrevNext(from, to, start, end)
{

	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	var isSimplifyPractNursUnit  = document.forms[0].isSimplifyPractNursUnit.value; 
	if(isSimplifyPractNursUnit == 'true'){
		var c_code_str = "";
		var d_code_str = "";
		var a_code_str = "";
		
		var page = Math.ceil(end / 14);
		
		for(var i = start; i <= end; i++){
			
			var code_fld =  eval("document.forms[0].removeCode"+i+"");
			
			if(code_fld){
				
				var code =  eval("document.forms[0].Code"+i+".value");
				
				if(code_fld.value == "N"){
					if(c_code_str == ""){
						c_code_str = code;
					}else{
						c_code_str = c_code_str + ","+ code;				
					}
				}else{
					if(d_code_str == ""){
						d_code_str = code;
					}else{
						d_code_str = d_code_str + ","+ code;				
					}
				}
				
				if(a_code_str == ""){
					a_code_str = code;
				}else{
					a_code_str = a_code_str + ","+ code;				
				}
				
			}
		}
		setSession(a_code_str,c_code_str,d_code_str,page);
		reloadresultPageOfNurseUnitPract("A");
		
	}else{
		if(confirm(getMessage('WANT_TO_SAVE','common')))
		{
				document.forms[0].isOnApply.value = 'Y';		
				document.forms[0].action="../../servlet/eIP.NursUnitPractServlet";
				document.forms[0].target="messageFrame";
				document.forms[0].submit();
			
		}
		else
		{
			reloadresultPageOfNurseUnitPract("A");
		}
	}
}
function submitPrevNext1(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

	
async function showPractWindow(practID)
{
	var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	var dialogHeight    = "400px" ;
	var dialogWidth     = "700px" ;
	var dialogLeft      ="300";
	var arguments       = "" ;
	var features        = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	var reportURL   = await window.showModalDialog( url, arguments, features ) ;
}

/*
Function Name :	RemSelectAll()
Purpose : To Uncheck the Select All CheckBox when atleast 
		  one of the CheckBox is Un Checked..
*/
function RemSelectAll()
{
	//document.forms[0].chkAll.checked = false;
}

function selectAll(Obj,start,end)
{
	
	if(Obj.checked)
	{

		for(var i=start;i<=end;i++)
		{

			if(eval("document.forms[0].select_yn"+i))
			{
		
				eval("document.forms[0].select_yn"+i).checked=true;
				eval("document.forms[0].removeCode"+i).value="N";

				
			}
			
		}

		/*var search_by = parent.frames[1].document.forms[0].search_by.value;
		var search_txt = parent.frames[1].document.forms[0].search_txt.value;

		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='PractforNursUnitDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='search_by' id='search_by' value='"+search_by+"'><input type='hidden' name='search_txt' id='search_txt' value='"+search_txt+"'><input type='hidden' name='Function' id='Function' value='"+document.forms[0].Function.value+"'><input type='hidden' name='function_code' id='function_code' value='"+document.forms[0].function_code.value+"'></form></BODY></HTML>";
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.form1.submit();*/
	}
	else
	{
	
		for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].select_yn"+i))
			{
				eval("document.forms[0].select_yn"+i).checked=false;
				eval("document.forms[0].removeCode"+i).value="Y";
			}
		}
		/*var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='PractforNursUnitDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'><input type='hidden' name='Function' id='Function' value='"+document.forms[0].Function.value+"'><input type='hidden' name='function_code' id='function_code' value='"+document.forms[0].function_code.value+"'> </form></BODY></HTML>";
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.form1.submit();*/
	}

}

function chkForSelectAll(start,end)
{

	if(parent.frames[3].document.forms[0].E.value == 'selectAll')
	{
		selectAll(document.forms[0].chkAll,start,end)
	}
}

//function moved from AddModifyNursUNitPract.jsp
function focusTxt()
{
	NursUnitPract_form.nursing_unit.focus();
}	

function reloadresultPageOfNurseUnitPract(frame)
{
	if(frame == 'C')
	{
		var url="";
		url='../eIP/jsp/PractForNursUnitResult.jsp?search_by='+document.forms[0].search_by.value+'&search_txt='+ document.forms[0].search_txt.value+'&from='+document.forms[0].from.value+'&to='+document.forms[0].to.value+'&start='+document.forms[0].start.value+'&end='+document.forms[0].end.value+'&mode='+document.forms[0].mode.value+'&function_code='+document.forms[0].function_code.value+'&operation='+document.forms[0].operation.value+'&Function='+document.forms[0].Function.value;

		//parent.frames[3].location.href='../eCommon/html/blank.html';

		parent.frames[2].document.location.href=url;
		

		parent.frames[3].location.reload();
		parent.parent.frames[2].location.href='../eCommon/jsp/MstCodeError.jsp';
		
	}	
	else if(frame == 'A')
	{
    var url="";	
    url='../../eIP/jsp/PractForNursUnitResult.jsp?search_by='+document.forms[0].search_by.value+'&search_txt='+ document.forms[0].search_txt.value+'&from='+document.forms[0].from.value+'&to='+document.forms[0].to.value+'&start='+document.forms[0].start.value+'&end='+document.forms[0].end.value+'&mode='+document.forms[0].mode.value+'&function_code='+document.forms[0].function_code.value+'&operation='+document.forms[0].operation.value+'&Function='+document.forms[0].Function.value;
     parent.frames[2].document.location.href=url;
		//parent.frames[3].location.href='../eCommon/html/blank.html';
		parent.frames[3].location.reload();
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
		
	}		
}


function setSession(a_code_str,c_code_str,d_code_str,page){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = "<root><SEARCH a_clinic_id='"+a_code_str+"' c_clinic_id='"+c_code_str+"' d_clinic_id='"+d_code_str+"' page = '"+page+"' action='setPractForNursUnitSession' /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open('POST', '../../eIP/jsp/IPintermediate.jsp',false);
	xmlHttp.send(xmlDoc);
	var res =  xmlHttp.responseText;
}



