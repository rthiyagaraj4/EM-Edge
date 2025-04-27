function reset()
{
	bl_cashier_login_frame.location.reload();
}

function create()
{
}

function apply()
{
}



function callapply()
{
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	
	var cashcounter = document.forms[0].cashcounter.value;
	var called_frm = document.forms[0].called_frm.value;

	if ((cashcounter == null) || (cashcounter == '') ||(cashcounter == ' '))
	{
		return(false);
	}
	var opening_balance = document.forms[0].opening_balance.value;		
	var loin = getMessage('BL9326','BL');
	var param="cashcounter="+cashcounter+"&opening_balance="+opening_balance+"&loin="+loin;
	var temp_jsp="../../servlet/eBL.BLLogInCashCounterServlet?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);

	if(responseText=="SUCCESS")
	{
		alert(getMessage('BL9326','BL'));
		if(called_frm == "DISC_FUN")
		{
			window.returnValue="SUCCESS";
			window.close();
		}
		else
		{
			parent.frames[1].location.href ='../../eBL/jsp/BLLogInCashCounterAdv.jsp?refresh_flag=Y';
			parent.frames[2].location.href ='../../eBL/jsp/BLLogInCashCounterQuery.jsp';
			document.menu_form.Login.disabled = true;		
		}
	}	
}

function trimString(sInString)
{
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}
