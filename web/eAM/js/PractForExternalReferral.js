 var practList= new Array();
 var effStatus= new Array();

 function create() 
{ 
f_query_add_mod.location.href = "../../eAM/jsp/ExtPractitionerReferralQueryMain.jsp?facilityId="+facId ;
}

function query()
{
	frames[1].location.href ="../../eAM/jsp/queryPractForExternalReferralPage.jsp" ;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply()
{
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	if(parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0]!=null)
	{
   var msg=getMessage('NO_CHANGE_TO_SAVE','Common');
 
	var cntr =  parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].count_chk.value;
	var finalString =  "";
	for (var i=0;i<parseInt(cntr);i++)
	{
		var select = eval("parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].select"+i)
			if (select != undefined && select.checked == true) //Modified by suji keerthi for BSP-SCF-0088
			{
			var Enablechk = eval("parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].Enablechk"+i)
			if(Enablechk.checked==true)
				{
					if(finalString == "")
					finalString = Enablechk.value + "$" + "E"
					else
					finalString = finalString+ "`" + Enablechk.value + "$" + "E"
				}
				else
				{
					if(finalString=="")
					finalString = Enablechk.value + "$" + "D"
					else
					finalString = finalString+ "`" + Enablechk.value + "$" + "D";
				}
			}
		}
    parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].finalString.value=finalString;

	//parent.frames[2].document.frames[1].document.frames[1].document.forms[0].finalSelect.value=finalString;

	if(finalString.length>0)
	{
 	parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].action="../../servlet/eAM.PractForExternalReferralServlet";
    parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].target="messageFrame";
	
	parent.frames[2].document.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].submit();
	
	}
	else
	{
	commontoolbarFrame.location.reload();
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
		return false;
	}
/*if(f_query_add_mod.document.frames[1].document.forms[0].finalPractList.value == '')
messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=1'
	else
	{*/
}
else
{
 
 commontoolbarFrame.location.reload();
// var msg="APP-AM0029 Apply is not a valid operation here";
var msg=getMessage("AM0100","AM")
messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
return false;
}
	//}
}

var facId='';
function onSuccess()
{
facId=parent.frames[2].document.frames[1].document.frames[0].document.forms[0].referral_code.value;
	create();

}

function reset()
{
/*	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
/*	if(f_query_add_mod.document.forms[0])
	{
		alert("1");
		f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.FocusFirstElement();
	}
	else
	{
		alert("2");
		f_query_add_mod.frames[0].document.forms[0].reset();
		f_query_add_mod.frames[1].location.href = "../../eCommon/html/blank.html";
	}*/
if(parent.frames[1].frames[1])
{
	if(f_query_add_mod.document.forms[0])
	{
	if(f_query_add_mod.document.forms[0].name=="query_form")
	{
			f_query_add_mod.document.location.reload();

	}else
	{

	}
	}else 
	{
	f_query_add_mod.document.location.reload();
	}
}


}

var totElements;
var totPracts=new Array();
var totChk=new Array();
var u=0;

function populateValues()
{
	if(parent.frames[2].document.forms[0])
	{
		totElements=parent.frames[2].document.forms[0].totCount.value;
		for(v=0;v<totElements;v++)
		{
			if(eval('parent.frames[2].document.forms[0].chk'+v).value == totChk[v])
				eval('parent.frames[2].document.forms[0].chk'+v).checked
		}
	}
}

function chkPractitionerList()
{
	var fields = new Array ( 	parent.frames[0].document.forms[0].referral_code,
						parent.frames[0].document.forms[0].splty_code
						    );
		var names = new Array (
							getLabel("eAM.ExternalReferral.label","AM"),
							getLabel("Common.primaryspeciality.label","Common")
					      );
		if(parent.frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2])) {
			return true;
		}
		else
		return false
}

	function changeEnable(Obj,Obj1,totApptCount,str3)
	{

		
			if(totApptCount > 0 && str3 =='Y')
			{
			alert(parent.frames[1].getMessage('FUTURE_APPT_EXISTS','AM'));
			Obj.checked=true;
			}
		else
		{
		var arr = new Array();
		arr = Obj1.value.split("$");
			if(Obj.checked)
			{
				arr[1]="Y";
			}
			else
				arr[1]="N";
			
			Obj1.value=arr[0]+"$"+arr[1]+"$"+arr[2]+"$"+Obj.name;
			practList+=Obj1.value+"~";
			parent.frames[1].document.forms[0].finalPractList.value=practList;
		}
			
	}
	function refreshFinalValues()
	{
	practList='';
	}

function chkEnable(Obj,Obj1,totApptCount)
{
	if(totApptCount > 0)
	{
	alert(parent.frames[1].getMessage('FUTURE_APPT_EXISTS','AM'));
	Obj.checked=true;
	}
	else
	{
		Obj1.disabled=false;
		var arr=new Array();
		if(Obj.checked)
		{
		arr=Obj.value.split("$");
		Obj.value=arr[0]+"$"+"E"+"$"+arr[2];
		effStatus+=Obj.value+"~";
		}
		else
		{
			arr=Obj.value.split("$");
			var practid = arr[0].substring(2,arr[0].length-1);
			//var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH PractID=\""+practid+"\" /></root>"
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ValidatePract.jsp",false)

			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText);

			if (parent.frames[1].document.forms[0].pract_id_exists.value=='N')
			{
				Obj.value=arr[0]+"$"+"D"+"$"+arr[2];
				effStatus+=Obj.value+"~";
			}
			else
				Obj.checked=true;

		}
		if (parent.frames[1].document.forms[0].pract_id_exists.value=='N')
		{
			parent.frames[1].document.forms[0].effStatus.value=effStatus;
		}
	}
}

var temp='';
function finalSelect(Obj1,Obj3)
{
	if(Obj1.checked && Obj3.checked)
	{
	//temp=parent.frames[1].document.forms[0].totAssignreassign.value+"`"+parent.frames[1].document.forms[0].effStatus.value;
	temp+=Obj3.value+"`"
	parent.frames[1].document.forms[0].finalSelect.value=temp;
	}
}

	function changeEnable(Obj,Obj1)
	{
		var arr = new Array();
		arr = Obj1.value.split("$");
			if(Obj.checked)
			{
				arr[1]="Y";
			}
			else
				arr[1]="N";
			
			Obj1.value=arr[0]+"$"+arr[1]+"$"+arr[2];
	}
	
	async function showPractWindow(practID)
	{
	
	    var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	    var dialogHeight    = "70vh" ;
	    var dialogWidth = "80vw" ;
	    var dialogLeft="";
	    var arguments   = "" ;
	    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	    var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;
	}
	        
	function submitPrevNext(from, to){
	
	    document.forms[0].totAssignreassign.value=parent.frames[0].assignReassign;
	   document.forms[0].effStatus.value=parent.frames[0].effStatus;
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
	}
	function chkAllow(totApptCount,Obj)
	{
		if(totApptCount > 0){
			alert(getMessage('FUTURE_APPT_EXISTS','AM'));
			Obj.checked=true;
			}
				
	}

		function focusObj()
	{
			document.forms[0].referral_code.focus();
	}
	
	function dispBlank()
	{
	document.forms[0].splty_code.value=''
	parent.frames[1].location.href='../../eCommon/html/blank.html'
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num='
	}

	function dispBlankResult()
	{

	parent.frames[1].location.href='../../eCommon/html/blank.html'
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num='
	}
	
	function generateSpeciality(obj1)
	{	
		
		var Referral_Source = obj1.value;
	    var obj = document.forms[0].splty_code;
		var length = obj.length;
		for(i=0;i<length;i++)
		{
			obj.remove(1);
		}

		//To populate the speciality based on referral
		if(Referral_Source!="")
		{
			var HTMLVal = " <html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eAM/jsp/GenSpltyForExtPractitioner.jsp'><input type='hidden' name='Ref_Src' id='Ref_Src' value='"+Referral_Source+"'></form></body></html>";
			parent.dummy.document.write(HTMLVal);
			parent.dummy.document.dum_form.submit();
		}
	}
	function callPractitioner()
	{
	
		
	if(chkPractitionerList())
	{
		var splty_code=document.forms[0].splty_code.value;
		var referral_code= document.forms[0].referral_code.value;

		var search_by=document.forms[0].search_by.value;
		var search_txt=document.forms[0].search_txt.value;

		if(parent.frames[1].document.forms[0])
			parent.frames[1].document.forms[0].submit();
		parent.frames[1].location.href='../../eAM/jsp/PractForExternalReferralResult.jsp?splty_code='+splty_code+'&referral_code='+referral_code+'&search_by='+search_by+'&search_txt='+search_txt+'&facility_id='+"<%=fid%>"
	}
	}

