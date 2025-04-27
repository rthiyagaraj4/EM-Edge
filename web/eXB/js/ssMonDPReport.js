/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function showDateCriteria()
{
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	document.getElementById('dateLTR').style.display = 'none';
	document.getElementById('dateTR').style.display = 'none';

	var funcSelected = document.getElementById('ssDPFunc').value;
	var isProcessed = document.getElementById('isProcessEligible').value;
	var isConfirmed = document.getElementById('isConfirmEligible').value;
	var ssFieldValidation = document.getElementById('ssFieldValidation').value;
	var errorRecordSize = document.getElementById('errorRecordSize').value;
	var locale = document.getElementById('locale').value;
	var jobWhat = document.getElementById('jobWhat').value;
	var dateFormat = "DMYHMS";
	var isErrExists = true;

	if(errorRecordSize > 0)
	{
		var message = getMessage('XH0097','xh');
		alert(message);
		document.getElementById('ssDPFunc').selectedIndex = 0;
		return false;
	}
	else if(jobWhat != "")
	{
		var message = getMessage('XH0098','xh');
		if(jobWhat == 'D')
		{
			message = message.replace('$',getLabel('eXH.UPLOAD.Label','xh'));			
		}
		else if(jobWhat == 'P')
		{
			message = message.replace('$',getLabel('Common.Process.label','common'));			
		}
		else if(jobWhat == 'C')
		{
			message = message.replace('$',getLabel('eXH.CONFIRMATION.Label','xh'));
		}
		alert(message);
	}
	else if(funcSelected == 'P' || funcSelected == 'C' || funcSelected == 'D')
	{
		var uploadDate = document.getElementById('tempUploadDate').value;
		var confirmDate = document.getElementById('tempConfirmDate').value;
		var processDate = document.getElementById('tempProcessDate').value;		

		var msg = getMessage("XH0091","XH");		

		if(ssFieldValidation == '0')
		{
			alert(getMessage("XH0092","XH"));
		}
		else if(ssFieldValidation == '1')
		{
			alert(getMessage("XH0090","XH"));
		}
		else if(ssFieldValidation == 'BGID')
		{
			msg = msg.replace('$',getLabel('Common.BillingGroup.label','common'));
			alert(msg);
		}
		else if(ssFieldValidation == 'CGID')
		{
			msg = msg.replace('$',getLabel('eXH.CustomerGroup.label','XH'));
			alert(msg);
		}
		else if(ssFieldValidation == 'CC')
		{
			msg = msg.replace('$',getLabel('Common.CustomerCode.label','common'));
			alert(msg);
		}
		else if(ssFieldValidation == 'PTC')
		{
			msg = msg.replace('$',getLabel('eXH.PolicyTypeCode.label','XH'));
			alert(msg);
		}
		else if(funcSelected == 'D')
		{
			if(jobWhat == 'D')
			{
				var msg = getMessage("XH0099","XH");
				msg = msg.replace('$', getLabel('eXH.UPLOAD.Label', 'xh'));
				alert(msg);
			}
			else if(processDate != "-" && isBefore(processDate, uploadDate, dateFormat, locale))
			{
				var msg = getMessage("XH0100","XH");
				alert(msg);				
			}
			else if(confirmDate != "-" && isBefore(confirmDate, uploadDate, dateFormat, locale))
			{
				var msg = getMessage("XH0101","XH");
				alert(msg);				
			}
			else if(confirmDate == "-" && uploadDate != "-")
			{
				var msg = getMessage("XH0101","XH");
				alert(msg);				
			}
			else isErrExists = false;
		}
		else if(funcSelected == 'P')
		{
			if(jobWhat == 'P')
			{
				var msg = getMessage("XH0099","XH");
				msg = msg.replace('$', getLabel('Common.Process.label', 'common'));
				alert(msg);
			}
			else if(uploadDate == "-" || (processDate != "-" && isBefore(uploadDate, processDate, dateFormat, locale)))
			{
				var msg = getMessage("XH0102","XH");
				alert(msg);
			}
			else if(processDate != "-" && isBefore(confirmDate, processDate, dateFormat, locale))
			{
				var msg = getMessage("XH0101","XH");
				alert(msg);	
			}
			else isErrExists = false;
		}
		else if(funcSelected == 'C')
		{
			if(jobWhat == 'C')
			{
				var msg = getMessage("XH0099","XH");
				msg = msg.replace('$', getLabel('eXH.CONFIRMATION.Label', 'xh'));
				alert(msg);
			}
			else if(uploadDate == "-" || (confirmDate != "-" && isBefore(uploadDate, confirmDate, dateFormat, locale)))
			{
				var msg = getMessage("XH0103","XH");
				alert(msg);	
			}
			else if(processDate == "-" || (confirmDate != "-" && isBefore(processDate, confirmDate, dateFormat, locale)))
			{
				var msg = getMessage("XH0104","XH");
				alert(msg);				
			}
			else isErrExists = false;
		}
		else
		{
			isErrExists = false;
		}
		if(isErrExists) 
		{
			document.getElementById('dateLTR').style.display = 'none';
			document.getElementById('dateTR').style.display = 'none';
			document.getElementById('ssDPFunc').selectedIndex = 0;
			return false;
		}
	}
	else if(funcSelected == 'OPD' || funcSelected == 'IPD')
	{
		var url = '../../eXB/jsp/ssMonOPDCriteria.jsp';
		var arguments = new Array();
		var dialogTop = "350";
		var dialogHeight = "10" ;
		var dialogLeft = "400" ;
		var dialogWidth  = "30" ;	
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
		var opdData = window.showModalDialog(url,arguments,features);
		document.getElementById("opdDate").value = opdData.opdDate;
		document.getElementById("custCode").value = opdData.custCode;
	}
	else
	{
		isErrExists = false;
	}

	if(!isErrExists && (funcSelected == 'S' || funcSelected == 'E'))
	{
		var dataUploadDate = document.getElementById('dataUploadDate').value;
		if(dataUploadDate != "-") dataUploadDate = formatDate(dataUploadDate, 'DMYHMS', 'DMYHM', locale);
		else dataUploadDate = "";
		document.getElementById('p_from_date').value = dataUploadDate;
		document.getElementById('p_to_date').value = "";
		document.getElementById('dateLTR').style.display = 'block';
		document.getElementById('dateTR').style.display = 'block';
	}
	else
	{
		if(isErrExists) document.getElementById('ssDPFunc').selectedIndex = 0;
		document.getElementById('dateLTR').style.display = 'none';
		document.getElementById('dateTR').style.display = 'none';
	}
}

function apply() 
{
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	var funcSelected = f_query_add_mod.document.getElementById('ssDPFunc').value;
	var locale = f_query_add_mod.document.getElementById('locale').value;
	
	if(funcSelected == "")
	{
		var msg = "Function cannot be blank.";		
		alert(msg);
		f_query_add_mod.document.getElementById('ssDPFunc').focus();
		cleanUp();
		return false;
	}
	else if(funcSelected == "P" || funcSelected == "C" || funcSelected == "D"  || funcSelected == "OPD" || funcSelected == "CP")
	{
		var isProcessJobExists = f_query_add_mod.document.getElementById('isProcessJobExists').value;
		var isConfirmJobExists = f_query_add_mod.document.getElementById('isConfirmJobExists').value;
		var jobWhat = f_query_add_mod.document.getElementById('jobWhat').value;	
		var isErrExists = true;

		if(funcSelected == 'D')
		{
			if(jobWhat == 'D')
			{
				var msg = getMessage("XH0099","XH");
				msg = msg.replace('$', getLabel('eXH.UPLOAD.Label', 'xh'));
				alert(msg);
			}
			else isErrExists = false;
		}
		else if(funcSelected == 'P')
		{
			if(jobWhat == 'P')
			{
				var msg = getMessage("XH0099","XH");
				msg = msg.replace('$', getLabel('Common.Process.label', 'common'));
				alert(msg);
			}
			else 
			{
				var ssPrivUploadCount = f_query_add_mod.document.getElementById('ssPrivUploadCount').value;
				var isCorrectData = checkDataCorrectness(ssPrivUploadCount);
				if(isCorrectData)
				{
					isErrExists = false;
				}
				else
				{					
					isErrExists = "true";
				}
			}
		}
		else if(funcSelected == 'C')
		{
			if(jobWhat == 'C')
			{
				var msg = getMessage("XH0099","XH");
				msg = msg.replace('$', getLabel('eXH.CONFIRMATION.Label', 'xh'));
				alert(msg);
			}
			else isErrExists = false;
		}

		if(isErrExists == 'true')
		{
			f_query_add_mod.document.getElementById('ssDPFunc').selectedIndex = 0;
			cleanUp();
			return false;
		}
		else
		{
			f_query_add_mod.document.forms[0].action = '../../servlet/eXB.SSMonDPServlet';
		}				
	}
	else if(funcSelected == "S" || funcSelected == "E")
	{
		if(funcSelected == "S")
		{
			f_query_add_mod.document.getElementById('p_report_id').value = 'XBPRVUPD_SKR';
		}
		else if(funcSelected == "E")
		{
			f_query_add_mod.document.getElementById('p_report_id').value = 'XBUNSSCTZN_SKR';
		}
		else if(funcSelected == "IPD")
		{
			f_query_add_mod.document.getElementById('p_report_id').value = 'XBSSIPDRPT_SKR';
		}
		
		var dateTo = f_query_add_mod.document.getElementById('p_to_date').value;
		if(dateTo == '')
		{
			dateTo = getCurrentDate('DMYHM',locale);
		}
		f_query_add_mod.document.getElementById('P_PROCESS_DATE_FROM').value = f_query_add_mod.document.getElementById('p_from_date').value;
		f_query_add_mod.document.getElementById('P_PROCESS_DATE_TO').value = dateTo;		
		f_query_add_mod.document.dummyForm.action = '../../eCommon/jsp/report_options.jsp';				
	}

	var isValidUser = userAuthentication();

	if(isValidUser == true)
	{
		if(funcSelected == "P" || funcSelected == "C" || funcSelected == "D"  || funcSelected == "OPD" || funcSelected == "CP")
		{
			f_query_add_mod.document.forms[0].submit();
		}
		else if(funcSelected == "S" || funcSelected == "E" || funcSelected == "IPD" )
		{
			f_query_add_mod.document.dummyForm.submit();
		}
	}

	window.commontoolbarFrame.document.location.reload();
}

function dateFieldValidations()
{
	var fromDateObj = f_query_add_mod.document.getElementById('p_from_date');
	var toDateObj = f_query_add_mod.document.getElementById('p_to_date');
	var locale = f_query_add_mod.document.getElementById('locale').value;

	var fields = new Array(fromDateObj) ;
	var names = new Array('From Date');  
	if(!f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		return false;
	}
	else if(xbDaysBetween(fromDateObj.value, toDateObj.value,'DMYHM', locale) > 31)
	{		
		alert('Days cannot be greater than 31');
		return false;
	}
	else return true;
}

function reset()
{	
	f_query_add_mod.document.forms[0].reset();
}

function initFunc()
{
	var resMsg = document.getElementById("resultMessage").value;
	var statusCode = document.getElementById("statusCode").value;
	var funcSelected = document.getElementById("funcSelected").value;	
	var jobWhat = document.getElementById("jobWhat").value;	

	if(statusCode == "0" && funcSelected == "P" && jobWhat != "P")
	{
		showProcResWindow();
	}
	else if(funcSelected == "DE")
	{
		initErrorScr(resMsg, statusCode);
	}
	else if(statusCode == "0")
	{
		parent.messageFrame.location.href="../../eXH/jsp/DisplayRefResult.jsp?message="+document.getElementById("resultMessage").value;
	}
}

function showProcResWindow()
{
	var noExPrivExtended = document.getElementById("noExPrivExtended").value;
	var noExPrivRemoved = document.getElementById("noExPrivRemoved").value;
	var noPrivilegeAdded = document.getElementById("noPrivilegeAdded").value;
	var noPrivilegeInvalid = document.getElementById("noPrivilegeInvalid").value;
	var dataBypassed = document.getElementById("dataBypassed").value;

	var url = '../../eXB/jsp/ssMonDPProcessResult.jsp?noexprivextended='+noExPrivExtended+'&noexprivremoved='+noExPrivRemoved+'&noprivilegeadded='+noPrivilegeAdded+'&noPrivilegeInvalid='+noPrivilegeInvalid+'&dataBypassed='+dataBypassed;
	var arguments = new Array();
	var dialogTop = "350";
	var dialogHeight = "10" ;
	var dialogLeft = "400" ;
	var dialogWidth  = "25" ;	
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	window.showModalDialog(url,arguments,features);
}

function dispError()
{
	var url = '../../eXB/jsp/ssMonDPDispError.jsp';
	var arguments = new Array();
	var dialogTop = "350";
	var dialogHeight = "27" ;
	var dialogLeft = "10" ;
	var dialogWidth  = "250" ;	
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	window.showModalDialog(url,arguments,features);
	parent.f_query_add_mod.document.location.reload();
}  

function showErr(errMsg)
{
	var url = '../../eXB/jsp/ssMonDPError.jsp?errMsg='+errMsg;
	var arguments = new Array();
	var dialogTop = "400";
	var dialogHeight = "10" ;
	var dialogLeft = "180" ;
	var dialogWidth  = "50" ;	
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	window.showModalDialog(url,arguments,features);
}

function opdDataProcess()
{
	var opdDate = document.getElementById("opdDate").value;
	if(opdDate == "")
	{
		var message = getMessage('CAN_NOT_BE_BLANK','common');
		message = message.replace('$', 'Output Month/Year');
		alert(message);
		document.getElementById('opdDate').focus();
		return false;
	}

	var payer1 = document.getElementById("payer1").value;
	var payer2 = document.getElementById("payer2").value;
	var payer3 = document.getElementById("payer3").value;
	var custCode = "";

	if(payer1 != "null" && payer1 != null && payer1 != "") custCode = custCode + payer1;
	if(payer2 != "null" && payer2 != null && payer2 != "") 
	{
		if(custCode == "") custCode = custCode + payer2;
		else custCode = custCode + "|" + payer2;
	}
	if(payer3 != "null" && payer3 != null && payer3 != "") 
	{
		if(custCode == "") custCode = custCode + payer3;
		else custCode = custCode + "|" + payer3;
	}

	if(custCode == "")
	{
		var message = getMessage('CAN_NOT_BE_BLANK','common');
		message = message.replace('$', 'Payer Code');
		alert(message); 
		document.getElementById('payer1').focus();
		return false;
	}

	var retObj = new Object();
	retObj.opdDate = opdDate;
	retObj.custCode = custCode	
	window.close();
	window.returnValue = retObj;
}

function initErrorScr(msg, statusCode)
{
	if(msg != null && msg != "" && msg != "null")
	{
		alert(msg);
		window.close();
	}	
}

function reloadPage()
{
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	parent.f_query_add_mod.document.location.reload();
}

function userAuthentication()
{
	var url = '../../eXB/jsp/ssMonDPValidateUser.jsp';
	var arguments = new Array();
	var dialogTop = "300";
	var dialogHeight = "10" ;
	var dialogLeft = "400" ;
	var dialogWidth  = "26" ;	
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	var msg = window.showModalDialog(url,arguments,features);
	if(msg == 'VALID') return true;
	else 
	{
		if(msg != null)	alert(msg);
		return false;
	}
}

function validateUser()
{
	var userID = document.getElementById('userID').value;
	var password = document.getElementById('password').value;

	if(userID == "")
	{
		var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
		msg = msg.replace('$', getLabel('eXH.AUTH_USER_ID.Label','xh'));
		alert(msg);
		document.getElementById('userID').focus();
		return false;
	}
	else if(password == "")
	{
		var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
		msg = msg.replace('$', getLabel('Common.PIN.label','common'));
		alert(msg);
		document.getElementById('password').focus();
		return false;
	}
	else
	{
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";	
		xmlStr += " userID=\""+userID+"\"";
		xmlStr += " password=\""+password+"\"";
		xmlStr += " actionReq=\""+document.getElementById('actionReq').value+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../servlet/eXB.SSMonDPDynaValServlet",false);	
		xmlHttp.send(xmlDoc);
		
		window.close();		
		window.returnValue = trimString(xmlHttp.responseText);
	}
}

function xbDaysBetween(fromDate,toDate,format,locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=daysBetween&fromDate="+fromDate+"&toDate="+toDate+"&format="+format+"&locale="+locale;
	xhr.open("POST",url,false);
	xhr.setRequestHeader("Content-Type","text/plain")
	xhr.send("");
	var xmlText = xbTrimFunc(xhr.responseText)
	return(xmlText);
}

function xbTrimFunc(inString)
{
	var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        startPos++;
        ch = inString.charAt(startPos);
    }

    // where do we end?
    endPos = inString.length - 1;
    ch = inString.charAt(endPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        endPos--;
        ch = inString.charAt(endPos);
    }
    // get the string
    outString = inString.substring(startPos, endPos + 1);
	if (startPos>endPos)
	{
		return '';
	}
	else
	    return outString;
}

function cleanUp()
{
	window.commontoolbarFrame.document.location.reload();	
}

function checkDataCorrectness(ssPrivUploadCount)
{
	var url = '../../eXB/jsp/ssMonDPDataChk.jsp?ssPrivUploadCount='+ssPrivUploadCount;
	var arguments = new Array();
	var dialogTop = "350";
	var dialogHeight = "7" ;
	var dialogLeft	= "330" ;
	var dialogWidth  = "42" ;	
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	var flag = window.showModalDialog(url,arguments,features);
	return flag;
}

function validatePrivCount()
{
	if(!checkField(document.getElementById("userSSPrivCount"), "Count")) return;
	if(!CheckNum(document.getElementById("userSSPrivCount"))) return;
	var flag = false;
	var ssPrivUploadCount = document.getElementById("ssPrivUploadCount").value;
	var userSSPrivCount = document.getElementById("userSSPrivCount").value;

	if(userSSPrivCount == ssPrivUploadCount) 
	{
		flag = true;	
	}
	else
	{
		alert(getMessage('XH0109','xh'));
	}
	window.close();
	window.returnValue = flag;
}
