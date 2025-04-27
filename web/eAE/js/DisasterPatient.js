function apply()
{
	setTimeout('callapply()',800);
}
async function callapply() 
{
var adtmale		=0;
var chldmale	=0;
var inftmale	=0;
var adtfemale	=0;
var chldfemale	=0;
var inftfemale	=0;
var adtunknown	=0;
var chldunknown	=0;
var	inftunknown	=0;
if(f_query_add_mod.document.DisasterPatReg.adultmale.value!="")
	adtmale=f_query_add_mod.document.DisasterPatReg.adultmale.value;
if(f_query_add_mod.document.DisasterPatReg.childmale.value!="")
	chldmale=f_query_add_mod.document.DisasterPatReg.childmale.value;
if(f_query_add_mod.document.DisasterPatReg.infantmale.value!="")
	inftmale=f_query_add_mod.document.DisasterPatReg.infantmale.value;
if(f_query_add_mod.document.DisasterPatReg.adultfemale.value!="")
	adtfemale=f_query_add_mod.document.DisasterPatReg.adultfemale.value;
if(f_query_add_mod.document.DisasterPatReg.childfemale.value!="")
	chldfemale=f_query_add_mod.document.DisasterPatReg.childfemale.value;
if(f_query_add_mod.document.DisasterPatReg.infantfemale.value!="")
	inftfemale=f_query_add_mod.document.DisasterPatReg.infantfemale.value;
if(f_query_add_mod.document.DisasterPatReg.adultunknown.value!="")
	adtunknown=f_query_add_mod.document.DisasterPatReg.adultunknown.value;
if(f_query_add_mod.document.DisasterPatReg.childunknown.value!="")
	chldunknown=f_query_add_mod.document.DisasterPatReg.childunknown.value;
if(f_query_add_mod.document.DisasterPatReg.infantunknown.value!="")
	inftunknown=f_query_add_mod.document.DisasterPatReg.infantunknown.value;


	var total_dis_patients=	eval(adtmale)+eval(chldmale)+eval(inftmale)+eval(adtfemale)+eval(chldfemale)+eval(inftfemale)+eval(adtunknown)+eval(chldunknown)+eval(inftunknown);
	var max_pat_in_disaster_regn	= parseInt(f_query_add_mod.document.DisasterPatReg.max_pat_in_disaster_regn.value);
	if(total_dis_patients>max_pat_in_disaster_regn){
		var message = getMessage("AE_DISASTER_LIMIT",'AE').replace("50",max_pat_in_disaster_regn)
		alert(message);
	    messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
	}else{
	var adultflag=0;
	var femaleflag=0;
	var infantflag=0;
	var zeroflag=0;
	if((f_query_add_mod.document.DisasterPatReg.adultmale.value=="") && (f_query_add_mod.document.DisasterPatReg.childmale.value=="") && (f_query_add_mod.document.DisasterPatReg.infantmale.value==""))
	  {
	    
		adultflag=1; 
	  }	
	if((f_query_add_mod.document.DisasterPatReg.adultfemale.value=="") && (f_query_add_mod.document.DisasterPatReg.childfemale.value=="") && (f_query_add_mod.document.DisasterPatReg.infantfemale.value==""))
	  {
	    
		femaleflag=1; 
	  } 
	 if((f_query_add_mod.document.DisasterPatReg.adultunknown.value=="") && (f_query_add_mod.document.DisasterPatReg.childunknown.value=="") && (f_query_add_mod.document.DisasterPatReg.infantunknown.value==""))
	  {
	    
		infantflag=1;  
	  }	
	  if (f_query_add_mod.document.DisasterPatReg.adultmale.value!="0" && f_query_add_mod.document.DisasterPatReg.adultmale.value!="")
			zeroflag=1;
	 
	  if (f_query_add_mod.document.DisasterPatReg.childmale.value!="0" && f_query_add_mod.document.DisasterPatReg.childmale.value!="")
			zeroflag=1;
	 
	  if (f_query_add_mod.document.DisasterPatReg.infantmale.value!="0" && f_query_add_mod.document.DisasterPatReg.infantmale.value!="")
			zeroflag=1;
	  if (f_query_add_mod.document.DisasterPatReg.adultfemale.value!="0" && f_query_add_mod.document.DisasterPatReg.adultfemale.value!="")
			zeroflag=1;
	  if (f_query_add_mod.document.DisasterPatReg.childfemale.value!="0" && f_query_add_mod.document.DisasterPatReg.childfemale.value!="")
			zeroflag=1;
	  if (f_query_add_mod.document.DisasterPatReg.infantfemale.value!="0" && f_query_add_mod.document.DisasterPatReg.infantfemale.value!="")
			zeroflag=1;
	  if (f_query_add_mod.document.DisasterPatReg.adultunknown.value!="0" && f_query_add_mod.document.DisasterPatReg.adultunknown.value!="")
			zeroflag=1;
	  if (f_query_add_mod.document.DisasterPatReg.childunknown.value!="0" && f_query_add_mod.document.DisasterPatReg.childunknown.value!="")
			zeroflag=1;
	  if (f_query_add_mod.document.DisasterPatReg.infantunknown.value!="0" && f_query_add_mod.document.DisasterPatReg.infantunknown.value!="")
			zeroflag=1;
    // chkValue1(f_query_add_mod.document.DisasterPatReg.creat_attn_detail_yn);

 	 if (zeroflag==0)
 	 {
	   alert(getMessage("ANY_ONE_VALUE_ENTERED",'AE'));
	   messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
	 
 	 }
	else if(adultflag==1 && infantflag==1 && femaleflag==1)
	{
	   alert(getMessage("ANY_ONE_VALUE_ENTERED",'AE'));
	   messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=''";
	   f_query_add_mod.document.DisasterPatReg.adultmale.focus();
	}
    else if (f_query_add_mod.document.DisasterPatReg.pat_ser_grp_code.value=="")
	{
		var errors = "" ;
		var err = getMessage('CAN_NOT_BE_BLANK','Common');
		err = err.replace('$', getLabel("eMP.PatientSeries.label","MP"));
		errors = errors + err ;

		alert(errors) ;
		f_query_add_mod.document.DisasterPatReg.pat_ser_grp_code.focus();
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=''";
	}
	    else if (f_query_add_mod.document.DisasterPatReg.priority_zone.value=="")
	{
		var errors = "" ;
		var err = getMessage('CAN_NOT_BE_BLANK','Common');
		err = err.replace('$', getLabel("Common.PriorityZone.label","Common"));
		errors = errors + err ;

		alert(errors) ;
		f_query_add_mod.document.DisasterPatReg.priority_zone.focus();
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=''";
	}
	  else if (f_query_add_mod.document.DisasterPatReg.Disaster_Reference.value=="")
	{ 
		var errors = "" ;
		var err = getMessage('CAN_NOT_BE_BLANK','Common');
		if(f_query_add_mod.document.DisasterPatReg.allowSplChar.value=='true') 
		{ 
		err = err.replace('$', getLabel("eAE.DisasterReference.label","AE"));
		}
		else
		{ 
		err = err.replace('$', getLabel("eAE.DisRegnReference1.label","AE"));
		}
		errors = errors + err ;

		alert(errors) ;
		f_query_add_mod.document.DisasterPatReg.pat_ser_grp_code.focus();
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=''";
	}

	else if(f_query_add_mod.document.DisasterPatReg.creat_attn_detail_yn.value=='Y')
	{
		if (f_query_add_mod.document.DisasterPatReg.clinic_code.value=="")
		{
		    var errors = "" ;
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
			err = err.replace('$', getLabel("Common.Location.label","Common"));
			errors = errors + err ;
	
			alert(errors) ;
			f_query_add_mod.document.DisasterPatReg.clinic_code.focus();
			messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=''";
		}
		else if (f_query_add_mod.document.DisasterPatReg.service_code.value=="")
		{
		    var errors = "" ;
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
			err = err.replace('$', getLabel("Common.service.label","Common"));
			errors = errors + err;
			alert(errors) ;
			f_query_add_mod.document.DisasterPatReg.service_code.focus();
			messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=''";
		}
		else if (f_query_add_mod.document.DisasterPatReg.visit_type.value=="")
		{

		    var errors = "" ;
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
			err = err.replace('$', getLabel("Common.visittype.label","Common"));
			errors = errors + err;
			alert(errors) ;
			f_query_add_mod.document.DisasterPatReg.visit_type.focus();
			messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=''";
		}
	    else 
	    {
		f_query_add_mod.document.DisasterPatReg.clinic_code.disabled  = false;
		f_query_add_mod.document.DisasterPatReg.service_code.disabled = false;
		f_query_add_mod.document.DisasterPatReg.visit_type.disabled   = false;
		f_query_add_mod.document.DisasterPatReg.arrival_mode.disabled = false;
		f_query_add_mod.document.getElementById('mand1').style.visibility="visible";
		f_query_add_mod.document.getElementById('mand2').style.visibility="visible";
		f_query_add_mod.document.getElementById('mand3').style.visibility="visible";

		// Added for Billing

		//var bl_install = f_query_add_mod.document.DisasterPatReg.bl_install_yn.value;
		var bl_install = f_query_add_mod.document.getElementById('bl_install_yn').value;
		//var CaptureFinancialDetails = f_query_add_mod.document.DisasterPatReg.CaptureFinancialDetails.value;
		var CaptureFinancialDetails = f_query_add_mod.document.getElementById('CaptureFinancialDetails').value;
		f_query_add_mod.document.DisasterPatReg.is_financial_captured.value = CaptureFinancialDetails;

			if (bl_install=="Y" && CaptureFinancialDetails=="Y" )
			{
				var retval=await chkOnSub();
				var bl_success = f_query_add_mod.document.DisasterPatReg.bl_success.value;
				if (bl_success=="N")
				{
					var msg =getMessage('FINANCIAL_DET_MANDATORY','MP');
					messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num="+msg ;
				}
				else
				{
					f_query_add_mod.document.forms[0].action="../../servlet/eAE.DisasterRegistrationServlet"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
					 f_query_add_mod.document.DisasterPatReg.submit();
	                //f_query_add_mod.location.reload() ;	
				}
			}
            else
			{	
            	     f_query_add_mod.document.forms[0].action="../../servlet/eAE.DisasterRegistrationServlet";
            	     f_query_add_mod.document.forms[0].target="messageFrame";
					 f_query_add_mod.document.DisasterPatReg.submit();
	                 f_query_add_mod.document.DisasterPatReg.reset();
			 }

       }
	}
	else{

		f_query_add_mod.document.DisasterPatReg.clinic_code.disabled  = false;
		f_query_add_mod.document.DisasterPatReg.service_code.disabled = false;
		f_query_add_mod.document.DisasterPatReg.visit_type.disabled   = false;
		f_query_add_mod.document.DisasterPatReg.arrival_mode.disabled = false;
		f_query_add_mod.document.getElementById('mand1').style.visibility="visible";
		f_query_add_mod.document.getElementById('mand2').style.visibility="visible";
		f_query_add_mod.document.getElementById('mand3').style.visibility="visible";

		// Added for Billing

        var bl_install = f_query_add_mod.document.DisasterPatReg.bl_install_yn.value;
		var CaptureFinancialDetails = f_query_add_mod.document.DisasterPatReg.CaptureFinancialDetails.value;
		f_query_add_mod.document.DisasterPatReg.is_financial_captured.value = CaptureFinancialDetails;

			
			if (bl_install=="Y" && CaptureFinancialDetails=="Y" )
			{
				chkOnSub();
				var bl_success = f_query_add_mod.document.DisasterPatReg.bl_success.value;
				if (bl_success=="N")
				{
					var msg =getMessage('FINANCIAL_DET_MANDATORY','MP');
					messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num="+msg ;
				}
				else
				{
		             f_query_add_mod.document.forms[0].action="../../servlet/eAE.DisasterRegistrationServlet"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
					 f_query_add_mod.document.DisasterPatReg.submit();
	                 f_query_add_mod.location.reload() ;	
				}
			}
            else
			{
            	f_query_add_mod.document.forms[0].action="../../servlet/eAE.DisasterRegistrationServlet"; 
            	f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.DisasterPatReg.submit();
	            f_query_add_mod.document.DisasterPatReg.reset();
			}
	}
}
}

function chkValue1(obj)
{
	if (obj.checked == true)
	{
		f_query_add_mod.document.DisasterPatReg.creat_attn_detail_yn.value='Y';
		f_query_add_mod.document.DisasterPatReg.clinic_code.disabled  = false;
		f_query_add_mod.document.DisasterPatReg.service_code.disabled = false;
		f_query_add_mod.document.DisasterPatReg.visit_type.disabled   = false;
		f_query_add_mod.document.DisasterPatReg.arrival_mode.disabled = false;
		f_query_add_mod.document.DisasterPatReg.all.mand1.style.visibility="visible";
		f_query_add_mod.document.DisasterPatReg.all.mand2.style.visibility="visible";
		f_query_add_mod.document.DisasterPatReg.all.mand3.style.visibility="visible";
		f_query_add_mod.document.DisasterPatReg.cancel_mode.value="";
		if(f_query_add_mod.document.DisasterPatReg.bl_install_yn.value=="Y"){
			f_query_add_mod.document.DisasterPatReg.CaptureFinancialDetails.value="Y";
			f_query_add_mod.document.DisasterPatReg.CaptureFinancialDetails.checked=true;
			f_query_add_mod.document.DisasterPatReg.CaptureFinancialDetails.disabled=true;
		}

	}
	else if (obj.checked == false)
	{
		f_query_add_mod.document.DisasterPatReg.creat_attn_detail_yn.value='N';
		f_query_add_mod.document.DisasterPatReg.clinic_code.disabled  = true;
		f_query_add_mod.document.DisasterPatReg.service_code.disabled = true;
		f_query_add_mod.document.DisasterPatReg.visit_type.disabled   = true;
		f_query_add_mod.document.DisasterPatReg.arrival_mode.disabled = true;
		f_query_add_mod.document.DisasterPatReg.clinic_code.value     = "";
		f_query_add_mod.document.DisasterPatReg.service_code.value    = "";
		f_query_add_mod.document.DisasterPatReg.visit_type.value      = "";
		f_query_add_mod.document.DisasterPatReg.arrival_mode.value    = "";
		f_query_add_mod.document.getElementById('mand1').style.visibility="hidden";
		f_query_add_mod.document.getElementById('mand2').style.visibility="hidden";
		f_query_add_mod.document.getElementById('mand3').style.visibility="hidden";
		f_query_add_mod.document.DisasterPatReg.cancel_mode.value="Cancel";	
		if(f_query_add_mod.document.DisasterPatReg.bl_install_yn.value=="Y"){
			f_query_add_mod.document.DisasterPatReg.CaptureFinancialDetails.value="N";
			f_query_add_mod.document.DisasterPatReg.CaptureFinancialDetails.checked=false;
			f_query_add_mod.document.DisasterPatReg.CaptureFinancialDetails.disabled=false;
		}
	}
}
function chkValue(obj)
{
	if (obj.checked == true)
	{
		document.forms[0].creat_attn_detail_yn.value='Y';
		document.DisasterPatReg.clinic_code.disabled  = false;

		//document.DisasterPatReg.clinic_code.value  = document.DisasterPatReg.clinic_code_dflt.value;
		document.DisasterPatReg.clinic_code.value  = document.getElementById('clinic_code_dflt').value;
		populateVisitType(document.DisasterPatReg.clinic_code);

		setTimeout(function(){
			if(document.DisasterPatReg.service_code_dflt.value!="")
				document.DisasterPatReg.service_code.value  = document.DisasterPatReg.service_code_dflt.value;
			
			if(document.DisasterPatReg.visit_type_dflt.value!="")
				document.DisasterPatReg.visit_type.value  = document.DisasterPatReg.visit_type_dflt.value;
		},300);

		document.DisasterPatReg.service_code.disabled = false;
		document.DisasterPatReg.visit_type.disabled   = false;
		document.DisasterPatReg.arrival_mode.disabled = false;
		document.getElementById('mand1').style.visibility="visible";
		document.getElementById('mand2').style.visibility="visible";
		document.getElementById('mand3').style.visibility="visible";
		document.forms[0].cancel_mode.value="";
		if(document.forms[0].bl_install_yn.value=="Y"){
			document.forms[0].CaptureFinancialDetails.value="Y";
			document.forms[0].CaptureFinancialDetails.checked=true;
			document.forms[0].CaptureFinancialDetails.disabled=true;
		}


	}
	else if (obj.checked == false)
	{
		document.forms[0].creat_attn_detail_yn.value='N';
		document.DisasterPatReg.clinic_code.disabled  = true;
		document.DisasterPatReg.service_code.disabled = true;
		document.DisasterPatReg.visit_type.disabled   = true;
		document.DisasterPatReg.arrival_mode.disabled = true;
		document.DisasterPatReg.clinic_code.value     = "";
		document.DisasterPatReg.service_code.value    = "";
		document.DisasterPatReg.visit_type.value      = "";
		document.DisasterPatReg.arrival_mode.value    = "";
		document.getElementById('mand1').style.visibility="hidden";
		document.getElementById('mand2').style.visibility="hidden";
		document.getElementById('mand3').style.visibility="hidden";
		document.forms[0].cancel_mode.value="Cancel";	
		if(document.forms[0].bl_install_yn.value=="Y"){
			document.forms[0].CaptureFinancialDetails.value="N";
			document.forms[0].CaptureFinancialDetails.checked=false;
			document.forms[0].CaptureFinancialDetails.disabled=false;
		}

	}
}
function CheckForSpecChar(event){ 
    var strCheck = ' 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function chkValue2(obj)
{
	if (obj.checked == true){	
		document.forms[0].CaptureFinancialDetails.value="Y";
		document.forms[0].CaptureFinancialDetails.checked=true;
		//document.forms[0].CaptureFinancialDetails.disabled=true;
	}else if (obj.checked == false){		
		document.forms[0].CaptureFinancialDetails.value="N";
		document.forms[0].CaptureFinancialDetails.checked=false;
		document.forms[0].CaptureFinancialDetails.disabled=false;
	} 
}

function reset()  
{

	if(f_query_add_mod.document.DisasterPatReg.creat_attn_detail_yn.checked){
	f_query_add_mod.document.DisasterPatReg.creat_attn_detail_yn.value='Y';
	f_query_add_mod.document.DisasterPatReg.clinic_code.disabled  = false;
	f_query_add_mod.document.DisasterPatReg.service_code.disabled = false;
	f_query_add_mod.document.DisasterPatReg.visit_type.disabled   = false;
	f_query_add_mod.document.DisasterPatReg.arrival_mode.disabled = false;
	f_query_add_mod.document.getElementById('mand1').style.visibility="visible";
	f_query_add_mod.document.getElementById('mand2').style.visibility="visible";
	f_query_add_mod.document.getElementById('mand3').style.visibility="visible";
	}
	f_query_add_mod.location.reload() ;	
   // f_query_add_mod.document.DisasterPatReg.reset();
}

function onSuccess() 
{
	f_query_add_mod.location.reload() ;	
}
 

function populateVisitType(obj)
{
         
		ClearList(document.forms[0].visit_type);
		ClearList(document.forms[0].service_code);
		var location_code = obj.value;
		//Change done here.

		if (location_code == null || location_code ==  " " || location_code == "")
		{
			location_code = "null";
		}
		if(location_code == "null"){


				parent.frames[1].document.forms[0].clinic_code.value    = "";
				parent.frames[1].document.forms[0].service_code.value    = "";
				parent.frames[1].document.forms[0].visit_type.value      = "";
				
		}else{
			HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/DisasterRegistrationPopulate.jsp'><input type='hidden' name='process_id' id='process_id' value='"+obj.name+"'><input name='location_code' id='location_code' type='hidden' value='"+location_code+ "'></form></BODY></HTML>";
		
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.form1.submit();
		}
			
}

function ClearList(object)
{
    
    
	if (object)
	var length  =object.length;

var element = parent.f_query_add_mod.document.createElement('OPTION');
	element.text	=	'----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
    element.value="";
   

	
        for(i=1;i<length;i++)
            object.remove(1);
   

}
//DisasterMain
function allowValidMonth(obj)
		{
		if (obj.value>11)
			{
			alert(getMessage("MONTHS_CHECK",'Common'));
		     obj.focus();
		  return false
		}
		}
function setValues(val)
		{
		 document.forms[0].retValue.value = val;
 		 document.forms[0].mode.value = '2';
		}
function allowValidDate(obj)
		{
		if (obj.value>30)
			{
			alert(getMessage("DATE_NOT_LESS_THIRY_ONE",'AE'));
		     obj.focus();
		  return false
		}
		}
		
	function setage_adult(obj,target)
		{		
			
			if (obj.value!='')
			{
		       document.DisasterPatReg.adultmaleage_y.disabled = false;
		if (obj.value==0)
	   {	
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.value="";
			obj.focus();
			//obj.select();
	   }
			else if (obj.value>0)
				target.value='30';
				else 
				target.value='';
			}	
			else
			{	
			document.DisasterPatReg.adultmaleage_y.disabled = true;
			target.value='';
			}
		}
		
		function setage_adultmaleage(obj,target)
		{
		 
		
		   
		if (obj.value!='')
		{
			if (obj.value==0)
	   {	
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
      obj.value="";
			//obj.select();
	   }
		else if (obj.value!='')
		{
			target.value=target.value;
		}
			else
			target.value='';
		}
		else
			target.value='';
		}


//male
		function setage_child(obj,target)
		{
			if (obj.value!='')
			{
		    document.DisasterPatReg.childmaleage_y.disabled = false;
			if (obj.value==0)
	    {	
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
	    }
	   else if (obj.value>0)
				target.value='8';
				else 
				target.value='';
			}
	       else
			{	
			document.DisasterPatReg.childmaleage_y.disabled = true;
			target.value='';
			}
			}

		function setage_childmaleage(obj,target)
		{
		if (obj.value!='')
		{
			if (obj.value==0)
	   {	
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
	   }
		else if (obj.value!='')
		{
			target.value=target.value;
		}
		}
			else
			target.value='';
		}


		function setage_infant(obj,target)
		{
			if (obj.value!='')
			{
				document.DisasterPatReg.infantmaleage_m.disabled = false;
				document.DisasterPatReg.infantmaleage_d.disabled = false
			if (obj.value==0)
	   {	
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
	   }
			else if (obj.value>0)
				target.value='29';
				else 
				target.value='';
			}
			else
			{	
			document.DisasterPatReg.infantmaleage_m.disabled = true;
			document.DisasterPatReg.infantmaleage_d.disabled = true;
			document.DisasterPatReg.infantmaleage_m.value='';
			document.DisasterPatReg.infantmaleage_d.value='';
			}
			}
		function setage_infantmaleage(obj,target,obj1)
		{
		if ((obj.value!='') || (obj1.value!=''))
		{
       		document.DisasterPatReg.infantmale.value==target.value;
		}
		else
		{
			target.value='';
		}
		}


//female

function setage_adultF(obj,target)
		{
			
			if (obj.value!='')
			{
		       document.DisasterPatReg.adultfemaleage_y.disabled = false;
			if (obj.value==0)
			{	
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
			 }
			else if (obj.value>0)
				target.value='30';
				else 
				target.value='';
			}	
			else
			{	
			document.DisasterPatReg.adultfemaleage_y.disabled = true;
			target.value='';
			}
		}
		
	function setage_adultfemaleage(obj,target)
		{
		if (obj.value!='')
		{
			if (obj.value==0)
	   {	
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
	   }
		else if (obj.value!='')
		{
			target.value=target.value;
		}
		}
		else
		target.value='';
		}


		function setage_childF(obj,target)
		{
			if (obj.value!='')
			{
		    document.DisasterPatReg.childfemaleage_y.disabled = false;

			if (obj.value==0)
	   {	
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
	   }
		else if (obj.value>0)
				target.value='8';
				else 
				target.value='';
			}
	       else
			{	
			document.DisasterPatReg.childfemaleage_y.disabled = true;
			target.value='';
			}
			}

		function setage_childfemaleage(obj,target)
		{
			if (obj.value!='')
		{
			if (obj.value==0)
	   {	
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
	   }
		else if (obj.value!='')
		{
			target.value=target.value;
		}
		}
			else
			target.value='';
		}

		function setage_infantF(obj,target)
		{
			if (obj.value!='')
			{
				document.DisasterPatReg.infantfemaleage_m.disabled = false;
				document.DisasterPatReg.infantfemaleage_d.disabled = false
			if (obj.value==0)
	   {	
			alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
	   }
			else if (obj.value>0)
				target.value='29';
				else 
				target.value='';
			}
			else
			{	
			document.DisasterPatReg.infantfemaleage_m.disabled = true;
			document.DisasterPatReg.infantfemaleage_d.disabled = true;
			document.DisasterPatReg.infantfemaleage_d.value='';
			document.DisasterPatReg.infantfemaleage_m.value='';
			}
			}
		function setage_infantfemaleage(obj,target,obj1)
		{
		if ((obj.value!='') || (obj1.value!=''))
		{
       		document.DisasterPatReg.infantfemale.value==target.value;
		}
		else
		{
			target.value='';
		}
		}



//Unknown

function setage_adultU(obj,target)
		{
		var un_adult_age_for_dis_regn =document.forms[0].un_adult_age_for_dis_regn.value;
			if (obj.value!='')
			{
				document.DisasterPatReg.adultunknownage_y.disabled = false;
				document.DisasterPatReg.adultunknownage_y.focus();// Tuesday, June 01, 2010 PE_EXE

			if (obj.value==0)
			{	
		    alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
			}
			else if (obj.value!='')
			{

				if (obj.value>0)
				target.value=un_adult_age_for_dis_regn;
				else 
				target.value='';
			}	
			}
			else
			{	
			document.DisasterPatReg.adultunknownage_y.disabled = true;
			}
		}
		
		function setage_adultunknownage(obj,target)
		{

			var adultunknown =document.forms[0].adultunknown.value;
			var un_adult_age_for_dis_regn =document.forms[0].un_adult_age_for_dis_regn.value;
		if (obj.value!='')	
	  {
		if (obj.value==0)
			{	
		    alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
			}
	
		else if (obj.value!='')
		{
			target.value=target.value;
		}
		}
		else
			target.value='';
	}


		function setage_childU(obj,target)
		{
			if (obj.value!='')
			{
		    document.DisasterPatReg.childunknownage_y.disabled = false;
			if (obj.value==0)
			{	
		    alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
			}

			else if (obj.value>0)
				target.value='8';
				else 
				target.value='';
			}
	       else
			{	
			document.DisasterPatReg.childunknownage_y.disabled = true;
			target.value='';
			}
			}

		function setage_childunknownage(obj,target)
		{
		if (obj.value!='')	
	  {
		if (obj.value==0)
			{	
		    alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
			}
		else if (obj.value!='')
		{
			target.value=target.value;
		}
		}
		else
			target.value='';
		}

		function setage_infantU(obj,target)
		{
			if (obj.value!='')
			{
				document.DisasterPatReg.infantunknownage_m.disabled = false;
				document.DisasterPatReg.infantunknownage_d.disabled = false
		 if (obj.value==0)
			{	
		    alert(getMessage('AE_NUMBER_ZERO','AE'));
			obj.focus();
			obj.value="";
			//obj.select();
			}
			else if (obj.value>0)
				target.value='29';
				else 
				target.value='';
			}
			else
			{	
			document.DisasterPatReg.infantunknownage_m.disabled = true;
			document.DisasterPatReg.infantunknownage_d.disabled = true;
			document.DisasterPatReg.infantunknownage_d.value='';
			document.DisasterPatReg.infantunknownage_m.value='';
			}
			}
		function setage_infantunknownage(obj,target,obj1)
		{
		if ((obj.value!='') || (obj1.value!=''))
		{
       		document.DisasterPatReg.infantunknown.value==target.value;
		}
		else
		{
			target.value='';
		}
		}


///-------------------------///


















		function setfocus()
		{
			document.forms[0].adultmale.focus();

		}
//AEDisasterAreaPopulate
function cancelOperation()
{
	parent.window.returnValue = "";
	parent.window.close();
}
function blurgetReasonval(target_id,target)
{
	if(makeValidString(target))
		target.select();
	
	target.value=trimString(target.value);
	if(target.value == "")
	{
		document.forms[0].reasonForVisit_desc.value;		
		return;
	}
	checkTxtVal(target_id,target);
}

function checkTxtVal(target_id,target)
{
  if(document.forms[0].reasonForVisit_desc.value == "")
		Lookup(target_id,target);
  else
	    Lookup(target_id,target);
}

function submitValues()
{
	var temp1 = document.forms[0].clinic_code.value;
	if (temp1=="")
		{
			var errors = "" ;
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
			err = err.replace('$', getLabel("Common.Location.label","Common"));
			errors = errors + err + "<br>" ;
			alert(errors) ;
			document.forms[0].clinic_location.focus();
			return false ;
        }
	var temp2 = document.forms[0].service_code.value;
	if (temp2=="")
		{
		      var errors = "" ;
			  var err = getMessage('CAN_NOT_BE_BLANK','Common');
			  err = err.replace('$', getLabel("Common.service.label","Common"));
			  errors = errors + err;
			  alert(errors) ;
              document.forms[0].service_code.focus();
  			  return;
       }
	var temp3= document.forms[0].visit_type.value;
	if (temp3=="")
		{
			var errors = "" ;
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
			err = err.replace('$', getLabel("Common.visittype.label","Common"));
			errors = errors + err;
			alert(errors) ;
			document.forms[0].visit_type.focus();
			return;
        }
	var temp5 = document.forms[0].arrival_mode.value;
	if (temp5=="")
		{
			var errors = "" ;
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
			err = err.replace('$', getLabel("Common.ModeofArrival.label","Common"));
			errors = errors + err;
			alert(errors) ;
			document.forms[0].arrival_mode.focus();
			return;
        }
} 

// Added new for Billing Starts here.

async function getFinDtl(qryStr)
{
    var retVal;
	var dialogHeight= "90vh";
	var dialogWidth = "90vw";
	var dialogTop	= "72";
    var center = "1" ;                                                         
    var status="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments   = "" ;
    var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
    retVal =await top.window.showModalDialog(url,arguments,features);
    if(retVal==null) retVal="";
    return retVal;
        
}
async function chkOnSub()
{
    var package_flag="N";
    var ins_auth_flag="N";
    var upd_pat_flag="N";
    var show_hide_blng_class="HIDE";
	var clinic_code = f_query_add_mod.document.DisasterPatReg.clinic_code.value;
	var visit_type = f_query_add_mod.document.DisasterPatReg.visit_type.value;
	var facility_id = f_query_add_mod.document.DisasterPatReg.facility_id.value;
	var bl_interface_yn = f_query_add_mod.document.DisasterPatReg.bl_interface_yn.value;
	var bl_install_yn = f_query_add_mod.document.DisasterPatReg.bl_install_yn.value;
    var billing_group       = f_query_add_mod.document.DisasterPatReg.billing_group.value;
    var remarks       = f_query_add_mod.document.DisasterPatReg.remarks.value;
    var billing_mode        = f_query_add_mod.document.DisasterPatReg.billing_mode;
	var bl_data_from_repos_yn = "N";
	var data_source_id = f_query_add_mod.document.DisasterPatReg.change_data_source;
    if (data_source_id.value != '' && billing_group.value != '')
	{
		bl_data_from_repos_yn = "Y";
	}
	   
	if (billing_group.value != '')
			billing_mode.value = "Modify";
	var operation           = f_query_add_mod.document.DisasterPatReg.bl_operation.value;

	if(billing_mode.value=="Modify"){
		operation="Update";
	}
	
	if(operation=='Insert'){
		operation='';
		billing_mode.value = '';
	}
	f_query_add_mod.document.DisasterPatReg.bl_success.value = "N";
	var health_card_expired_yn = f_query_add_mod.document.DisasterPatReg.health_card_expired_yn.value;
	var calling_module_id	   = "AE";
	var calling_function_id	   = "VISIT_REGISTRATION";
	var disaster_yn="Y";
	var episode="";
    var record="";
    var qryStr="operation="+operation;
	qryStr += "&package_flag="+package_flag;
	qryStr += "&billing_mode="+billing_mode.value;
	qryStr += "&billing_group="+billing_group.value;

	qryStr += "&health_card_expired_yn="+health_card_expired_yn+"&clinic_code="+clinic_code+"&visit_type_code="+visit_type;
	qryStr += "&bl_interfaced_yn="+bl_interface_yn+ 
			"&bl_install_yn="+bl_install_yn+
			"&facilityId="+facility_id;
	qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
    qryStr +="&remarks="+remarks+"&episode="+episode+"&record="+record+"&disaster_regn_YN="+disaster_yn;
	qryStr +="&show_hide_blng_class="+show_hide_blng_class;

    var returnArray = new Array();
    returnArray = await getFinDtl(qryStr);
    if(returnArray.length>0)
    {
        billing_group.value         = returnArray[0];
        billing_mode.value          = "Modify"
		f_query_add_mod.document.DisasterPatReg.bl_success.value = "Y";
    }
    else
        return false;
     
    }
// Added new for Billing Ends here.

/*function checkMaxLen(obj){
		if (obj.value.length>200){
			var error = getMessage("REMARKS_CANNOT_EXCEED",'Common');
			error = error.replace("$",getLabel("Common.remarks.label","Common"));
			error = error.replace("#","200");
			alert(error)
			obj.focus(); 
		}
	}*/
function checkMaxLen(obj) {
    const maxLength = 200;
    if (obj.value.length > maxLength) {
        // Truncate the value to the maximum length
        obj.value = obj.value.substring(0, maxLength);

        // Get the error message
        var error = getMessage("REMARKS_CANNOT_EXCEED", 'Common');
        error = error.replace("$", getLabel("Common.remarks.label", "Common"));
        error = error.replace("#", maxLength);

        // Show the alert and focus on the input
        alert(error);
        obj.focus(); 
    }
}


function SpeCharCheck(which) {
fldval = which.value;
fldval = fldval.replace(/^\s+/,""); // strip leading spaces
if (/[^a-z0-9\s]/i.test(fldval)) { // only alphanumeric and space allowed
var error = getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED",'SM');
alert (error);
//alert ("You have entered one or more invalid characters - try again!");
which.value = "";
which.focus();
return false;
}
}

function coldisable()
{
	document.DisasterPatReg.adultmaleage_y.disabled = true
	document.DisasterPatReg.childmaleage_y.disabled = true
	document.DisasterPatReg.infantmaleage_m.disabled = true

	document.DisasterPatReg.adultfemaleage_y.disabled = true
	document.DisasterPatReg.childfemaleage_y.disabled = true
	document.DisasterPatReg.infantfemaleage_m.disabled = true

	document.DisasterPatReg.adultunknownage_y.disabled = true
	document.DisasterPatReg.childunknownage_y.disabled = true
	document.DisasterPatReg.infantunknownage_m.disabled = true

	document.DisasterPatReg.infantmaleage_d.disabled = true
	document.DisasterPatReg.infantfemaleage_d.disabled = true
	document.DisasterPatReg.infantunknownage_d.disabled = true
	
}


function allowValidNumber1(fld, e, maxInt, deci)
{
    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok

	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45 && count>0)
	{
		return false
	}

    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');
			//alert("dotOccurance : "+dotOccurance);

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                    //alert("APP-0001 Reached Maximum Integer value");
                    //return false;
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            //alert(objectValue.charAt(maxInt));
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
                    return false;
                }
            }
        }
    }
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789';

//	alert(e.getKeyCode())
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}

