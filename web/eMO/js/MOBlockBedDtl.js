function enableData()
{
if(document.forms[0].area_code.value!="")
{
document.forms[0].search_bed.disabled=false;
document.forms[0].bed_no.disabled=false;
document.forms[0].bed_no.value="";
}else{
document.forms[0].bed_no.disabled=true;
document.forms[0].search_bed.disabled=true;
document.forms[0].bed_no.value="";
}


}

function BedCheck()
{
  var area_code = document.forms[0].area_code.value;
  var bed_no =document.forms[0].bed_no.value;
  var patient_id =document.forms[0].patient_id.value;


  var bedVaild='Y';
  if(area_code!="" && bed_no != "")
  {
    var xmlDoc=new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH bed_no=\""+bed_no+"\" area_code=\""+area_code+"\" patient_id=\""+patient_id+"\"  bedVaild=\""+bedVaild+"\"/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MOCapacityCheck.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);


	if(responseText=="Invalid")
		{

			var error = getMessage('INVALID_VALUE','Common');
			error = error.replace('#',getLabel("Common.Location.label","Common"));
			alert(error);	    	
			document.forms[0].bed_no.value = '';
			document.forms[0].bed_no.select();
		}
  }

}

/*function validate1(obj)
{  

if(obj.value!="")
{
val1=obj.value.length	

if(val1<16)
		{
	//alert("APP-SM0004 Invalid Date Format");
	alert(getMessage("INVALID_DATE_FMT","SM"));
	
	obj.focus();
	return false;
		}
if(doDateTimeChk(obj)==false)
{
// alert("APP-SM0004 Invalid Date Format");
 alert(getMessage("INVALID_DATE_FMT","SM"));
  obj.focus();
  return false;
}
if(ValidateDateTime(document.forms[0].system_date,obj)==false) 
{
alert(getMessage('BLK_DATE_TIME'));
obj.focus();
return false;
}

}
}
*/

function validate1(obj)
{

var Sys_date=document.forms[0].system_date.value;

if(obj.value!="")
		{
		if(!validDateObj(obj,"DMYHM",localeName))
		{
			obj.value="";
			return ;
		}
		else{
		var obj1=convertDate(obj.value,"DMYHM",localeName,"en");

		
		if(isBefore(Sys_date,obj1,'DMYHM',localeName)==false)
			{
				alert(getMessage("BLK_DATE_TIME","MO"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;

			
		}
}

}


function apply()
{
/*area_type=frames[1].document.forms[0].area_code
bed_no=frames[1].document.forms[0].bed_no
blocked_until=frames[1].document.forms[0].blocked_until
reason=frames[1].document.forms[0].remarks*/

 
var error_page = "../../eCommon/jsp/MstCodeError.jsp";	

var fields = new Array (f_query_add_mod.document.forms[0].area_code,f_query_add_mod.document.forms[0].bed_no,f_query_add_mod.document.forms[0].blocked_until,f_query_add_mod.document.forms[0].remarks)
var names = new Array (getLabel("Common.area.label","Common"),getLabel("Common.Location.label","Common"),getLabel("Common.blockeduntil.label","Common"),getLabel("Common.reason.label","Common"));

//frames[1].document.forms[0].submit();
if(f_query_add_mod.checkFields(fields,names,messageFrame))
 {
f_query_add_mod.document.forms[0].action="../../servlet/eMO.BlockBedServlet"; 
	f_query_add_mod.document.forms[0].target="messageFrame"	 
f_query_add_mod.document.forms[0].submit();
 }

}

function checkForMaxLimit(obj)
{
   if ( obj.value.length > 100 )
    {
		alert(getMessage('REASON_CANT_MORE','MO'));
		document.forms[0].remarks.select();
    }
}


function reset()
{
f_query_add_mod.location.reload();

}
function onSuccess() {
f_query_add_mod.location.reload();
}	


async function searchBed()
{
	var retVal =    new String();
	var area_code   =document.forms[0].area_code.value;
	var retVal = "";
	var dialogHeight= "90vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop ="60";
	var status = "no";
	var arguments	= " ";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
    var retVal=	await window.showModalDialog("../../eMO/jsp/MOBayAvailabilityChart.jsp?area_code="+area_code+"&bed_status=V&disable=yes",arguments,features);
    if(retVal != null && retVal != "" )
     {
	  document.forms[0].bed_no.value=retVal;
	 }
	
	


}
