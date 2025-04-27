function scrollTitle()
{
	var scrollXY = document.body.scrollTop;
	if(scrollXY == 0)
	{
		document.getElementById("divTabHead").style.position = 'static';
		document.getElementById("divTabHead").style.posTop  = 0;
	}
	else
	{
		document.getElementById("divTabHead").style.position = 'relative';
		document.getElementById("divTabHead").style.posTop  = scrollXY;
	}
}

function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/LocationForPractitioner.jsp';
}

function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaLocationForPractMain.jsp';
}

function apply()
{
	if(f_query_add_mod.AddModify!=null)
	{
		var from = f_query_add_mod.AddModify.document.Section_form.eff_from_date;
		var to = f_query_add_mod.AddModify.document.Section_form.eff_to_date;
		var format ="DMY";
		var locale =f_query_add_mod.AddModify.document.Section_form.locale.value;
		var mode =f_query_add_mod.AddModify.document.Section_form.mode.value;

		if(mode=="modify")
		{
			if(!validate_date1(from,to,format,locale))
			{
				messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
				return false;
			}
		}
		else if(mode=="insert")
		{
			if(!validate_date(from,to,format,locale))
			{
				messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
				return false;
			}
		}
		var fields = new Array( f_query_add_mod.Header.document.LPract.pctr, f_query_add_mod.AddModify.document.Section_form.locn_type, f_query_add_mod.AddModify.document.Section_form.loca, f_query_add_mod.AddModify.document.Section_form.eff_from_date);
		var names = new Array (getLabel("Common.practitioner.label","COMMON"),getLabel("Common.locationtype.label","COMMON"),getLabel("Common.Location.label","COMMON"),getLabel("Common.EffectiveFrom.label","COMMON"));

		if(checkFieldsofMst( fields, names, messageFrame))
		{
			f_query_add_mod.AddModify.document.Section_form.action="../../servlet/eCA.LocationForPractServlet";
			f_query_add_mod.AddModify.document.Section_form.target="messageFrame";
			f_query_add_mod.AddModify.document.Section_form.method="post";
			f_query_add_mod.AddModify.document.Section_form.submit();
		}
		f_query_add_mod.AddModify.document.Section_form.loca.value="";
		f_query_add_mod.AddModify.document.Section_form.locn_code.value ="";
		//f_query_add_mod.AddModify.document.Section_form.eff_from_date.value="";
	}
	else
	{
		message  = getMessage("NOT_VALID","CA");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
}

function reset()
{
	f_query_add_mod.location.reload();
}

function deleterecord()
{  	
	if(f_query_add_mod.AddModify!=null)
	{
		var status =f_query_add_mod.AddModify.document.Section_form.mode.value;
		if(f_query_add_mod.AddModify.document.Section_form.mode!=null)
		{
			if(status != "insert")
			{
				var model="delete";
				f_query_add_mod.AddModify.document.Section_form.mode.value = model;
				f_query_add_mod.AddModify.document.Section_form.method ="post"
				f_query_add_mod.AddModify.document.Section_form.target ="messageFrame"
				f_query_add_mod.AddModify.document.Section_form.action="../../servlet/eCA.LocationForPractServlet";

				//var confirmDelete = window.confirm(messageArray["DELETE_RECORD"]);
				var confirmDelete = window.confirm(getMessage("DELETE_RECORD","Common"));	
				if(confirmDelete==true)
				{
					f_query_add_mod.AddModify.document.Section_form.target="messageFrame";
					f_query_add_mod.AddModify.document.Section_form.method="post";
					f_query_add_mod.AddModify.document.Section_form.submit();
				}
				else if(confirmDelete==false)
				{
					commontoolbarFrame.location.reload();
				}
			}
			else
			{
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("RECORD_CANNOT_DELETE","CA");
			}
		}
		else
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	else
	{
		message  = getMessage("INVALID_OPERATION","CA");
		message = message.replace("$","Delete");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false;
	}
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

function enableSearch1(event)
{
	if(parent.frames[0].document.forms[0].pctr.value)
	{
		searchEnable1(parent.frames[0].document.forms[0].searchpctr);
	}
}
function searchEnable1(obj)
{
	if(parent.frames[0].document.forms[0].searchpctr.disabled==true)
	{
		parent.frames[0].document.forms[0].searchpctr.disabled=false;
	}
}

function onSuccess()
{
	if(f_query_add_mod.AddModify.document.Section_form.mode.value=='delete')
	{
		var practitioner_id=f_query_add_mod.AddModify.document.Section_form.practitioner_id.value;
		f_query_add_mod.Result.location.reload();  
		f_query_add_mod.AddModify.document.Section_form.target="messageFrame";
		f_query_add_mod.AddModify.location.href='../../eCA/jsp/LocationForPractDetail.jsp?practitioner_id='+practitioner_id;
		return false;
	}
	
	if(f_query_add_mod.AddModify.document.Section_form.mode.value=="insert" || f_query_add_mod.AddModify.document.Section_form.mode.value=="modify") 
	{
		f_query_add_mod.Result.location.reload();
	}

    f_query_add_mod.AddModify.document.Section_form.locn_type.value='';
	f_query_add_mod.AddModify.document.Section_form.locn_type.disabled=false;
	f_query_add_mod.AddModify.document.Section_form.locn_code.disabled=false;
	f_query_add_mod.AddModify.document.Section_form.locn_code.value='';
	//.f_query_add_mod.AddModify.document.Section_form.eff_from_date.value='';
	f_query_add_mod.AddModify.document.Section_form.to_date.value='';
	f_query_add_mod.AddModify.document.Section_form.eff_to_date.value='';

	if(f_query_add_mod.AddModify.document.Section_form.mode.value=='modify')
	{
		f_query_add_mod.AddModify.document.Section_form.mode.value='insert'
	}  
}

function clearValFrame()
{
	parent.frames[1].location.href="../../eCommon/html/blank.html";	
	parent.frames[2].location.href="../../eCA/jsp/LocationForPractDetail.jsp";
	parent.frames[0].document.forms[0].pctr.value='';
	parent.frames[0].document.forms[0].practitioner_id.value='';
	var txtSpl = parent.frames[0].document.forms[0].spl.value;
}

function chekcSplTxt(txtSpl)
{
	if(txtSpl.value == '')
	{
		parent.frames[0].document.forms[0].spl_code.value='';
	}
}

function PopulateName1(obj)
{
	var speciality = document.forms[0].spl_code.value;
	var practitioner_id=obj;
	parent.Result.location.href="../../eCA/jsp/LocationForPractList.jsp?practitioner_id="+practitioner_id.toUpperCase()+"&speciality_id="+speciality;
	parent.AddModify.location.href="../../eCA/jsp/LocationForPractDetail.jsp?practitioner_id="+practitioner_id.toUpperCase()+"&speciality_id="+speciality;
}

function checkRec(obj)
{
	if (obj.value!="")
	{ 		
		HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='locForm' id='locForm' method='post' action='LocationForPractQueryCriteria.jsp'><input type=hidden name='pract' id='pract' value='"+obj.value+"' </form></body></html>"
		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.locForm.submit();
	}
}

/*function PopulateName(obj)
{
var speciality = parent.frames[1].frames[0].document.forms[0].spl.value;
var practitioner_id=obj;
parent.frames[1].frames[1].location.href="../../eCA/jsp/LocationForPractList.jsp?practitioner_id="+practitioner_id.toUpperCase()+"&speciality_id="+speciality;

parent.frames[1].frames[2].location.href="../../eCA/jsp/LocationForPractDetail.jsp?practitioner_id="+practitioner_id.toUpperCase()+"&speciality_id="+speciality;
}*/

function loadfunctionmsg()
{
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

//functions for LocationForPractDetail.jsp-start

function doDateChecknew(from,to)
{
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;

	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	
		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
	return true;
}

/*function validate_to_date(from,obj,format,locale)
{
	if(obj != null && obj.value != "" )
	{
		if(CheckDate(obj))
		{
			if(isBeforeNow(obj.value,format,locale))
			{
				if (!isBefore(from.value,obj.value,format,locale))
				{
				  var msg=getMessage("REMARKS_MUST_GR_EQUAL","Common");
				  msg = msg.replace('$'," To Date");
				  msg = msg.replace('#'," Date");	
				  alert(msg);	
				  obj.value		= getCurrentDate(format,locale);
				  obj.select();
				  obj.focus();
				}
				else
					return true;
			}
			else
			{
				alert(getMessage("DATE_TIME_GREATER_SYSDATE","CA"));
				obj.select();
				obj.focus();
			}
		}
		else
			return false;
	}
}*/


/*function validate_to_date(obj)
{
	if(obj.value.length>0)
	{
		if(obj.value!=document.forms[0].eff_from_date1.value)
		{
			CheckDate(obj);
		}
		if(!doDateChecknew(document.forms[0].eff_from_date,document.forms[0].eff_to_date))
		{   
		  var msg=getMessage("REMARKS_MUST_GR_EQUAL","Common");
		  msg = msg.replace('$'," To Date");
		  msg = msg.replace('#'," Date");	
		  alert(msg);	
			obj.select();
			obj.focus();
		}
	}
}*/

/*function validate_from_date(obj,format,locale)
{
	if(obj!=null)
	{
		if(CheckDate(obj))
		{
			if(isBeforeNow(obj.value,format, locale))
			{
				alert(getMessage("FROM_DATE_GREAT_SYS","CA"));
				obj.value= getCurrentDate(format, locale);
				return false;
			}
			else
				return true;
		}
		else
			return false;
	}
}*/
function validate_date(from,to,format,locale)
{		
	if(from.value !="")
	{ 
		if(!isAfterNow(from.value,format, locale))
		{
			alert(getMessage("FROM_DATE_GREAT_SYS","CA"));
			from.value= getCurrentDate(format, locale);
			return false;
		}
	}
	if(to.value !="")
	{
		if(!isBefore(from.value,to.value,format,locale))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			
			to.select();
			to.value="";
			
			return false;
		}
	}
	return true;
}

function validate_date1(from,to,format,locale)
{		
	if(to.value !="")
	{
		if(!isBefore(from.value,to.value,format,locale))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));			
			to.select();
			to.value="";
			
			return false;
		}
	}
	return true;
}

/*function validate_from_date(obj)
{
	if(obj.value!=document.forms[0].eff_from_date1.value)
	{
		if(obj.value.length>0)
		{
			CheckDate(obj);
			DateValidation(obj);
		}
	}
}*/
/*
function doDateCheck1(from,to,messageFrame,val) 
{
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	//alert(fromdate);
	//alert(todate);
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		//alert('passed');
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	

		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			//alert('inside');
			if(val=="1")  
			{   alert(getMessage("FROM_DATE_GREAT_EFF","CA"));
				to.select();
				to.focus();
			}
			else if(val=="2") 
			{ 
					alert(getMessage("TO_DATE_LESS_EFF_DATE","CA"));
					from.select();
					from.focus();
			}
			else if(val=="3")
			{	
				var msg=getMessage("REMARKS_MUST_GR_EQUAL","Common");
				msg = msg.replace('$'," To Date");
				msg = msg.replace('#'," Date");	
				alert(msg);
				to.select();
				to.focus();
			}
			else if(val=="4")
			{	   	alert(getMessage("FROM_DATE_GREAT_SYS","CA"));
					to.select();
					to.focus();
			}
			return false;
		}
	}
	else if(Date.parse(todt) >= Date.parse(fromdt)) 
	{
		//alert('inside false');
		return true;
	}
	return true;
}
*/
/*
function DateValidation(obj)
{
	curdate = document.forms[0].to_date;
	var msg = getMessage("FROM_DATE_GREAT_SYS","CA")
	if(doDateCheckAlert(curdate,obj) == false	 ) 
	{
		obj.focus();
		obj.select();
		alert(msg);
	}
}
*/
/*
function doDateCheckAlert(from,to) 
{
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) 
			{
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
	}	
	return true;
}
*/
function encode_utf8(text) 
{
	text = text.replace(/\r\n/g,"\n");
	var utftext = "";
	for(var n=0; n<text.length; n++)
	{
		var c=text.charCodeAt(n);
		if (c<128) 
			utftext += String.fromCharCode(c);
		else if((c>127) && (c<2048)) 
		{
			utftext += String.fromCharCode((c>>6)|192);
			utftext += String.fromCharCode((c&63)|128);
		}
		else 
		{
			utftext += String.fromCharCode((c>>12)|224);
			utftext += String.fromCharCode(((c>>6)&63)|128);
			utftext += String.fromCharCode((c&63)|128);
		}
	}
	return utftext;
}	 

async function populateLoca()
{ 
	var target			= document.forms[0].loca;
	var facilityid      = document.forms[0].facility_id.value;
	var locn_type		=document.forms[0].locn_type.value;
	var retVal			=  new String();
	var title			= getLabel("Common.Location.label","common");
	var sql="SELECT short_desc description ,locn_code code FROM ca_locn_vw where locn_type = '"+locn_type+"' and facility_id = '"+facilityid+"' and upper(locn_code) like upper(?) and upper(short_desc) like upper(?)   order by 1 ";

	//var sql="Select b.practitioner_name description,a.practitioner_id code from am_pract_for_facility A, AM_PRACTITIONER_LANG_VW B where a.facility_id= '"+facilityid+"'and a.eff_status='E' and b.pract_type='NS' and a.practitioner_id = b.practitioner_id and b.language_id = '"+locale+"' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 1";

	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();			
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal      = await CommonLookup( title, argArray );
	var ret1=unescape(retVal);
 	var arr=ret1.split(",");
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		}
		
	if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].loca.value = arr[1];
		document.forms[0].locn_code.value =arr[0]
	}
	else
	{
		document.forms[0].loca.value = "";
		document.forms[0].locn_code.value = "";
	} 
	document.forms[0].flag.value='true';
}	  

async function getPractCode(objCode)
{
	if(objCode.name=='pctr')
	{
		 practitioner_id(objCode)
	}

	if(objCode.name == "searchpctr")
	{
		
		if(document.LPract.flag.value=='false')
			return false
		else			
			await getPractitionerId13(document.LPract.pctr)
	}			
}

function practitioner_id(objCode)
{
	
	var practitioner = objCode.value
	var speciality = document.LPract.spl_code.value;

	if(practitioner == '')
	{		
		document.LPract.flag.value='true';
		return false
	}
	else
	{
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/LocationForPractIntermediate.jsp'><input type='hidden' name='practitioner' id='practitioner' value="+practitioner+"><input type=hidden name='speciality' id='speciality' value='"+speciality+"'><input type=hidden name='selFunVal' id='selFunVal' value='Pract'></form></body></html>";
	
		parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.blankFrame.document.getElementById('tempform1').submit();
    }
}  

function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode
	
	if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
		return false
	
	return true
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
} 

function resetValues()
{
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}
function setValue()
{
	document.forms[0].flag.value='false';
}	 

async function getPractitionerId13(target)
{
	
	var speciality = document.forms[0].spl_code.value;
	var facility_id = document.forms[0].facility_id.value;
	var field=document.forms[0].spl_code;
	var name="Speciality";	
	var search_code="";
	var search_desc="";
	var sql="";
	search_code="practitioner_id";
	search_desc= "practitioner_name";

    if(document.forms[0].spl.value)
	{
		sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b,am_practitioner c where b.practitioner_id = a.func_role_id and b.practitioner_id = c.practitioner_id and c.eff_status='E' and b.operating_facility_id ='"+facility_id+"' and b.primary_speciality_code='"+speciality+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 2";
	}
	
	if(!(document.forms[0].spl.value))
	{
		sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b,am_practitioner c where b.practitioner_id = a.func_role_id and b.practitioner_id = c.practitioner_id and c.eff_status='E' and b.operating_facility_id ='"+facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 2";
	}
	
	var title="LocationPract";
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = await CommonLookup( title, argArray );
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
	
	if (retArray != null && retArray != '' && retArray != "null")
	{
	
		document.forms[0].practitioner_id.value = arr[0];
		document.forms[0].pctr.value = arr[1];
		PopulateName1(arr[0]);
	}
}

async function callFunction(sql,title,target)
{
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = await CommonLookup( title, argArray );
	var ret1=unescape(retArray);
 	var arr=ret1.split(",");
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		}
	
	if (retArray != null && retArray != '' && retArray != "null")
	{
		
		PopulateName(arr[0]);
	}
	return retArray;
}
function PopulateName(obj)
{	
	var speciality = parent.Header.document.forms[0].spl_code.value;
	var practitioner_id=obj;
	parent.Result.location.href="../../eCA/jsp/LocationForPractList.jsp?practitioner_id="+practitioner_id.toUpperCase()+"&speciality_id="+speciality;
	parent.AddModify.location.href="../../eCA/jsp/LocationForPractDetail.jsp?practitioner_id="+practitioner_id.toUpperCase()+"&speciality_id="+speciality;
}


async function getLocaCode(objCode)
{
	var locType = document.forms[0].locn_type.value;

	if (locType != "")
	{	
		if(objCode.name=='loca')
		{
			locn_code(objCode)
		}

		if(objCode.name == "locaSerch")
		{  
			if(document.forms[0].flag.value=='false')
				return false
			else				
				await populateLoca()
		}
	}
	else
	{	
		message  = getMessage("CAN_NOT_BE_BLANK","COMMON");
		message = message.replace('$'," Location Type");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
}

function locn_code(objCode)
{
	var locationcode = objCode.value;
	var locn_type	=  document.Section_form.locn_type.value;
	
	if(locationcode == '')
	{
		document.forms[0].flag.value ='true';
		return false
	}
	else
	{
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/LocationForPractIntermediate.jsp'><input type='hidden' name='locationcode' id='locationcode' value='"+locationcode+"'><input type='hidden' name='locn_type' id='locn_type' value='"+locn_type+"'><input type=hidden name='selFunVal' id='selFunVal' value='Location'></form></body></html>";
		parent.frames[3].document.write(HTMLVal);
		parent.frames[3].document.tempform1.submit(); 

    }
}
  
async function callFunction1(sql,title,target)
{
	var argArray		= new Array();
    var namesArray		= new Array();
    var valuesArray		= new Array();
    var datatypesArray	= new Array();
		
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal = await CommonLookup( title, argArray );
	return retVal;
} 

async function getLoctnCode(objCode)
{
	if(objCode.name=='locn_code')
	{
		locaSerch(objCode);
	}
	else if(objCode.name=="buttonloctn")
	{
	await	populateLocatn();
	}
}

async function populateLocatn()
{
	var target			= document.forms[0].locn_code;
	var facility_id = document.forms[0].facility_id.value;
	var locn_type		=document.forms[0].locn_type.value;
	var retVal			=  new String();
	var title			= getLabel("Common.Location.label","common");

	var sql ="SELECT short_desc description ,locn_code code FROM ca_locn_vw where locn_type = '"+locn_type+"' and facility_id = '"+facility_id+"'  and  upper(locn_code) like upper(?) and upper(short_desc) like upper(?) order by 1";

	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal      = await CommonLookup( title, argArray );
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		}

	if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].locn_code.value = arr[1];
		document.forms[0].locaSerch.value = arr[0]
	}
	else
	{
		document.forms[0].locn_code.value = "";
		document.forms[0].locaSerch.value = "";
	} 
	document.forms[0].flag.value='true';
} 

function locaSerch(objCode)
{
	var locationcode1 = objCode.value;
	var locn_type	=  document.forms[0].locn_type.value;
	
	if(locationcode1 == '')
	{
		document.forms[0].flag.value ='true';
		return false
	}
	else
	{  
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/LocationForPractIntermediate.jsp'><input type='hidden' name='locationcode1' id='locationcode1' value='"+locationcode1+"'><input type='hidden' name='locn_type' id='locn_type' value='"+locn_type+"'><input type=hidden name='selFunVal' id='selFunVal' value='Location1'></form></body></html>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.tempform1.submit(); 
	}
}

async function callFunction2(sql,title,target)
{ 
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal = await CommonLookup( title, argArray );
	return retVal;
}

async function getSplCode(objCode)
{
	if(objCode.name=='spl')
	{
		spl_code(objCode)
	}

	if(objCode.name == "splSearch")
	{		
		if(document.forms[0].flag.value=='false')
			return false
		else {
			await populateSpl()}
	}	 
}

async function populateSpl()
{ 
	var target			= document.forms[0].spl;
	var retVal			=  new String();

	var title			= getLabel("Common.speciality.label","common");
	var sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();		
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal      = await CommonLookup( title, argArray );
	
	
			var ret1=unescape(retVal);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined ||arr[0]==undefined) 
	 		{
		 		arr[1]="";	
		 		arr[0]="";	
	 		} 
		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].spl.value = arr[1];
		document.forms[0].spl_code.value = arr[0]
	}
    else
	{
		document.forms[0].spl.value = arr[1];
		document.forms[0].spl_code.value =arr[0];
	} 
	document.forms[0].flag.value='true';

}

function spl_code(objCode)
{
	var specialitycode = objCode.value;
	if(specialitycode == '')
	{
		document.forms[0].flag.value ='true';
		return false
	}
	else
	{		
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/LocationForPractIntermediate.jsp'><input type='hidden' name='specialitycode' id='specialitycode' value='"+specialitycode+"'><input type=hidden name='selFunVal' id='selFunVal' value='Speciality'></form></body></html>";
		
		parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.blankFrame.document.getElementById('tempform1').submit();
    }
}

async function callFunction3(sql,title,target)
{
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal = await CommonLookup( title, argArray );
	return retVal;
} 

async function getPrimarySpacilityCode(objCode)
{
	if(objCode.name=='speciality')
	{
		prime_spl_code(objCode)
	}

	if(objCode.name == "primeSearch")
	{		
		if(document.forms[0].flag.value=='false')
			return false
		else
			await populatePrimeSpl()
	}						  
}

async function populatePrimeSpl()
{ 
	var target			= document.forms[0].speciality;
	var retVal			=  new String();
	var title			= getLabel("Common.speciality.label","common");
	var sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();		
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal      = await CommonLookup( title, argArray );
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		}
	
	if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].speciality.value = arr[1];
		document.forms[0].prime_spl_code.value = arr[0];
	}
	else
	{
		document.forms[0].speciality.value = "";
		document.forms[0].prime_spl_code.value = "";
	} 
	document.forms[0].flag.value='true';
}

function prime_spl_code(objCode)
{
	var primespeciality = objCode.value;
	
	if(primespeciality == '')
	{
		document.forms[0].flag.value ='true';
		return false
	}
	else
	{
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/LocationForPractIntermediate.jsp'><input type='hidden' name='primespeciality' id='primespeciality' value='"+primespeciality+"'><input type=hidden name='selFunVal' id='selFunVal' value='PrimeSpeciality'></form></body></html>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.tempform1.submit();  
    }
}

async function callFunction4(sql,title,target)
{
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal = await CommonLookup( title, argArray );
	return retVal;
}

function getPractitioners(Object)
{ 
	if(Object.name=='pract_name')
	{
		var target  = document.forms[0].pract_name;

		if((target.value) == "null" || (target.value ==""))
		{					 
			return false;			
		}
		else
		{
			showPractrWindow();
		}
	}
	else if(Object.name=='pract')
	{		
		showPractrWindow();
	}
}

 async function showPractrWindow()
{
	var target			= document.forms[0].pract_name;
	var retVal			=  new String();
	var title			= getLabel("Common.practitioner.label","common");
	var p_facility_id= document.getElementById('facility_id').value;
	// var sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	var sql="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id   and b.operating_facility_id ='"+p_facility_id +"' and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal      =await  CommonLookup( title, argArray );
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		}
	

	if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].pract_name.value = arr[1];
		document.forms[0].pract_id.value = arr[0]
	}  
	else
	{
		document.forms[0].pract_name.value = "";
		document.forms[0].pract_id.value = "";
	} 
}

