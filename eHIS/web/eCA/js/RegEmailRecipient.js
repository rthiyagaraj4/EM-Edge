function create()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/RegEmailRecipientAddModify.jsp?mode=insert';
}

function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/RegEmailRecipientQueryCriteria.jsp?mode=update';
}

 function apply()
 {
	if(f_query_add_mod.document.forms[0])
	{	
			f_query_add_mod.document.forms[0].mailer_id.value=f_query_add_mod.document.forms[0].mailerId.value
			f_query_add_mod.document.forms[0].mailer_name.value=f_query_add_mod.document.forms[0].mailerName.value
			f_query_add_mod.document.forms[0].email_id.value=f_query_add_mod.document.forms[0].emailId.value
		
			if(f_query_add_mod.document.forms[0].authoriseChkBox.disabled == true) f_query_add_mod.document.forms[0].authoriseChkBox.disabled = false;

			if(f_query_add_mod.document.forms[0].authoriseChkBox.checked == true)
				f_query_add_mod.document.forms[0].authoriseChkBox.value = 'Y';
			else
				f_query_add_mod.document.forms[0].authoriseChkBox.value = 'N';

		var fields = new Array (f_query_add_mod.document.forms[0].mailerId,
							f_query_add_mod.document.forms[0].mailerName,
							f_query_add_mod.document.forms[0].emailId
							);

	
		var names = new Array ( f_query_add_mod.getLabel("eCA.RegisteredRecipientID.label",'CA'),							f_query_add_mod.getLabel("eCA.RegisteredRecipientName.label",'CA'),
				f_query_add_mod.getLabel("eCA.EmailId.label",'CA')
						);

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{	
			f_query_add_mod.document.RegEmailRecipientForm.submit();	
		}
	
	}
	
	else
	{
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
  }


function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/RegEmailRecipientAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{   
		f_query_add_mod.location.href='../../eCA/jsp/RegEmailRecipientAddModify.jsp?mode=update&mailer_id='+f_query_add_mod.document.forms[0].mailer_id.value;
	}
	else     
		  f_query_add_mod.location.href='../../eCommon/html/blank.html';
}


function reset()
{

	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
	if(f_query_add_mod.document.forms[0])
	{
	if(f_query_add_mod.document.forms[0].authorized)
	{
		if(f_query_add_mod.document.forms[0].authorized.value == 'N')
			f_query_add_mod.document.getElementById("viewPwdID").style.display = 'none';
	}
	if(f_query_add_mod.document.forms[0].mode)
	{
		if(f_query_add_mod.document.forms[0].mode.value=="insert")
		{
			f_query_add_mod.document.forms[0].mailerId.disabled=false;
			f_query_add_mod.document.forms[0].mailerId.focus();
		}
	}
	}

}
function checkForMode(objCheck)
{
	var mode = document.forms[0].mode.value;
	
	if(mode == 'update')
	{		
		if(objCheck.checked== true)
		{
			document.forms[0].eff_status.value='E'
		}
		else
		{
			document.forms[0].eff_status.value='D'
		}
	}
}

async function viewPwd(){
	var mailer_id="";
	var mode="";
	mailer_id = parent.f_query_add_mod.document.forms[0].mailerId.value;
	mode = parent.f_query_add_mod.document.forms[0].mode.value;
	
	if(mailer_id!="" && mailer_id!=''){		
		var retVal	=	"";
		var dialogHeight =	"8" ;
		var dialogWidth	= "20" ;
		var dialogTop	= "390" ;
		var dialogLeft	= "590" ;
		var title = getLabel("Common.view.label","COMMON");
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+";status=no;scroll=no"; 
		retVal =await window.showModalDialog("../../eCA/jsp/RegEmailRecipientViewPwd.jsp?title="+encodeURIComponent(title,"UTF-8")+"&mailer_id="+mailer_id+"&mode="+mode,arguments,features);
	}else{
		alert(getMessage("REGISTERED_RECIPIENT_CANT_BE_BLANK","CA"));	
		return;
	}
}
function chkPwd(obj){

	if(obj.value =="" || obj.value =='' )
	{
		alert(getMessage("ENTER_PWD","SM"));
		return
	}
	else if(obj.value.toUpperCase() != document.RegEmailRecipientVerifyPwd.actualPwd.value.toUpperCase())
	{
		alert(getMessage("PWD_MISMATCH","SM"));
		return
	}
	else
	{
		window.returnValue=true;	
		window.close();
	}
}
async function managePwd(){

	var mailer_id =parent.f_query_add_mod.document.forms[0].mailer_id.value;	
	/*************verify the password***********start***********************/
	var retVal	=	"";
	var dialogHeight =	"4" ;
	var dialogWidth	= "20" ;
	var dialogTop	= "390" ;
	var dialogLeft	= "590" ;
	var title = getLabel("Common.ConfirmPassword.label","COMMON");
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+";status=no;scroll=no"; 
	retVal =await window.showModalDialog("../../eCA/jsp/RegEmailRecipientVerifyPwd.jsp?title="+encodeURIComponent(title,"UTF-8"),arguments,features);
	/*************verify the password***********end***********************/
	if(retVal !=null && retVal==true){
		var dialogHeight= "20" ;
		var dialogWidth	= "40" ;
		var title = getLabel("Common.changepassword.label","COMMON");
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=NO"; 
		retVal = await window.showModalDialog("../../eCA/jsp/RegEmailRecipientManagePwdFrames.jsp?mailer_id="+mailer_id+"&mode="+parent.f_query_add_mod.document.forms[0].mode.value+"&srl_no="+parent.f_query_add_mod.document.forms[0].srl_no.value+"&title="+encodeURIComponent(title,"UTF-8"),arguments,features);
	}
}

function changePwd(){
	var qryString="srl_no="+(parseInt(parent.RegEmailRecipientManagePwdTop.document.RegEmailRecipientManagePwdTop.srl_no.value)+1)+"&mailer_id="+parent.RegEmailRecipientManagePwdTop.document.RegEmailRecipientManagePwdTop.mailer_id.value+"&mode="+parent.RegEmailRecipientManagePwdTop.document.RegEmailRecipientManagePwdTop.mode.value;		
	parent.RegEmailRecipientManagePwdBtm.location.href="RegEmailRecipientManagePwdBtm.jsp?"+qryString;
}
function CheckDateTime(objText,format,locale)
{
	var locale		= document.forms[0].locale.value;
	if(objText.value !='' && objText.value !="")
	{ 
		var maxEffDate		= document.forms[0].maxEffDate.value;

		if(!doDateTimeChk(objText))
		{
			alert(getMessage("INVALID_DATE_TIME","CA"))
			objText.select();
			return false
		}
		if(!isAfterNow(objText.value, format, locale)){			
			alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
			objText.select();
			objText.focus();
			return false;	
		}	
		if(!isAfter(objText.value,maxEffDate,format,locale)){
			alert(getMessage("EFF_DATES_OVERLAP","CA"))
			objText.select();
			return false
		}
		
		
	}
} 
function showCalendarValidate(str){
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}
function clearBeanValues(){
	var xmlHttp 		= new XMLHttpRequest() ;
	xmlStr				= "<root><SEARCH " ;
	xmlStr				+= "key=\"clearBean\" ";
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegEmailRecipientIntermediate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	parent.window.close();
}
function addToList(){
	if(document.RegEmailRecipientManagePwdBtm.from_date.value == ""){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
		return false;
	}
	CheckDateTime(document.RegEmailRecipientManagePwdBtm.from_date,"DMYHM",document.RegEmailRecipientManagePwdBtm.locale.value);

	var xmlHttp 		=  new XMLHttpRequest() ;
	xmlStr				= "<root><SEARCH " ;
	xmlStr				+= "key=\"addToList\" ";
	xmlStr				+= "srl_no=\""+document.RegEmailRecipientManagePwdBtm.srl_no.value+"\" ";
	xmlStr				+= "from_date=\""+document.RegEmailRecipientManagePwdBtm.from_date.value+"\" ";
	xmlStr				+= "password=\""+document.RegEmailRecipientManagePwdBtm.password.value+"\" ";
	xmlStr 			+=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegEmailRecipientIntermediate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	parent.RegEmailRecipientManagePwdTop.location.href="../../eCA/jsp/RegEmailRecipientManagePwdTop.jsp?mailer_id="+document.RegEmailRecipientManagePwdBtm.mailer_id.value+"&mode="+document.RegEmailRecipientManagePwdBtm.mode.value+"&srl_no="+document.RegEmailRecipientManagePwdBtm.srl_no.value;
	parent.RegEmailRecipientManagePwdBtm.location.href="../../eCommon/html/blank.html";	
}

function chkValidEmail(obj)
{
	if(obj.value != '')
	{
		var pattern = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
		if(pattern.test(obj.value) == false)
		{  
			alert(getMessage("INVALID_EMAIL_ID","CA"));
			obj.focus();
			return false;
		}
	}
}

function checkForPassword(obj)
{
	var mailerId = document.RegEmailRecipientForm.mailerId;
	if(mailerId.value == '')
	{
		alert(getMessage("REGISTERED_RECIPIENT_CANT_BE_BLANK","CA"));
		obj.checked = false;
		return;
	}
	else
	{
		if(obj.checked == true)
		{
			document.RegEmailRecipientForm.password.value = mailerId.value +"xxxx";
			document.getElementById("viewPwdID").style.display = 'inline';
			mailerId.disabled = true;
		}
		else
		{
			document.RegEmailRecipientForm.password.value = '';
			document.getElementById("viewPwdID").style.display = 'none';
			mailerId.disabled = false;
		}
	}
}
