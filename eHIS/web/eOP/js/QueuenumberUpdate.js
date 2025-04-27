
//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Started-->
function CloseUpdateQueueNo() 
{
	window.returnValue = "ok";
	parent.window.close();
}

//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Started-->
function UpdateQueueNumber(Patient_id,QUEUE_NUM,encntrid,fac_id)
	{
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eOP.UpdateQueueNumberServlet?Patient_id="+Patient_id+"&QUEUE_NUM="+QUEUE_NUM+"&encntrid="+encntrid+"&fac_id="+fac_id, false);
	xmlHttp.send(xmlDoc);
	var response = trimString(xmlHttp.responseText);
	if(response=='ok')
		{
		//alert(getLabel("eCommon.RECORD_INSERTED.label","Common"));
		alert(getMessage('RECORD_INSERTED','SM'));
		CloseUpdateQueueNo();
		}
	else
		{
		alert(getMessage('FAILED_TRANSACTION','SM'));
		}
	}

//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Started-->
function UpdateQueueNo()
	{
	var Patient_id = document.getElementById("patientid").value;
	var QUEUE_NUM = document.getElementById("queue_no").value;
	var encntrid = document.getElementById("encntrid").value;
	var fac_id = document.getElementById("fac_id").value;
	var clinic_code = document.getElementById("clinic_code").value;
    	if(QUEUE_NUM=="")
  			{
  			QUEUE_NUM="0";
  			}
			var xmlStr = "<root><SEARCH Patient_id=\""+Patient_id+"\" QUEUE_NUM=\""+QUEUE_NUM+"\" encntrid=\""+encntrid+"\" clinic_code=\""+clinic_code+"\" action='checkQueueNoExists' /></root>";
			var temp_jsp="../../eOP/jsp/OPIntermediate.jsp";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			var responseText = xmlHttp.responseText;
			var response = trimString(xmlHttp.responseText);
			if(response=="true")
				{
				document.getElementById("queue_no").value = "";
				alert(getMessage('QUEUE_NO_EXISTS','OP'));
				return false;
				}
			else
				{
				UpdateQueueNumber(Patient_id,QUEUE_NUM,encntrid,fac_id);
				return true;
				}
		}
		

function checkspecialandalphanumericOP1(textObj)
{
	var ValidChars = /^[a-zA-Z0-9]+$/;
	var pasteData = window.clipboardData.getData("Text"); 
	pasteData = trimString(pasteData);
	if(ValidChars.test(pasteData))
	{
		textObj.value = pasteData;
	}
	else 
		return false; 
}

function Check_SpecCharsValidationOP1(event)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}
