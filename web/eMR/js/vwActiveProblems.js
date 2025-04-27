function query() {
	f_query_add_mod.location.href ="../../eMR/jsp/mrblank.jsp?step_1=10";
}

async function authorize(obj)
{
	var pat_id = document.forms[1].patID.value;

	if(obj.value=="Sensitive")
	{
		var val1 = 'V' ;
		var val2 = 'Ass' ;
		var val3='C'
		if('Y'=="PatientQueue")
			val3="O";
		var val = val1+'/'+val2+'/'+val3+'/';

		var retVal = 	new String();
		var dialogHeight= "9vh" ;
		var dialogWidth	= "25vw" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../eMR/jsp/AuthorizeMRAccess.jsp?constr="+val,arguments,features);
		if(retVal=="T")
		{
			window.location.href='../../eMR/jsp/vwActiveProblemsquery.jsp?sensitive_disp=Y&Patient_Id='+pat_id;
			document.getElementById("authorize").value = "Normal";
		}
		/*else
		{			
			window.location.href='../../eMR/jsp/vwActiveProblemsquery.jsp?sensitive_disp=Y&Patient_Id='+pat_id;
		}*/		
	}
	else
	{																			
		window.location.href='../../eMR/jsp/vwActiveProblemsquery.jsp?sensitive_disp=N&Patient_Id='+pat_id
		document.getElementById("authorize").value = "Sensitive";
	}
}


function chkpasswd() {
	var p1 = document.Authorize_form.appl_user_passwd.value;	
	var p2 = document.Authorize_form.screen_passwd.value;	
	var ar = document.Authorize_form.access_rights.value;
	var nr = document.Authorize_form.no_records.value;	
	if (nr==0 || ar == "N")
	{
		alert(getLabel("eMR.UnauthorisedUser.label","MR"));
	}
	else if (p1 != p2)
	{
		alert(getMessage("PWD_MISMATCH",'SM'));
	}
	else
	{
		parent.parent.window.returnValue = "T" ;
		parent.parent.window.close();
	}

}

function closeAuthorization(){
	//parent.parent.parent.window.returnValue = "F";
	window.close();
}
function reset()
{}
