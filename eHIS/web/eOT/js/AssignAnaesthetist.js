/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function saveAnaesthetist()
{
	var frmObj=document.forms[0];
	var anaestheticcode=document.forms[0].Anaesthetiest1_code.value;
	var Anaesthetiest2_code=document.forms[0].Anaesthetiest2_code.value;
	var facility_id_1=document.forms[0].facility_id_1.value;
	var booking_no_1=document.forms[0].booking_no_1.value;
	if(Anaesthetiest2_code=="")
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var anaesthetist=getLabel("Common.Anaesthetist.label","Common");
		
		alert(msgArray[0]+anaesthetist+msgArray[1]);
		return;
	}
	var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="BookingValidation.jsp?booking_no="+booking_no_1+"&facility_id="+facility_id_1+"&anaestheticcode="+anaestheticcode+"&saveanaes=YES";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText = trimString(xmlHttp.responseText);
		var retVal = trimString(xmlHttp.responseText);
		window.returnValue=retVal;
		window.close();
}



async function searchAssignAnaesthetist(obj)
	{
	var frmObj=document.forms[0];
	var locale=frmObj.locale.value;
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var facility_id_1=document.forms[0].facility_id_1.value;


var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='MA') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var Anaesthetist=getLabel("Common.Anaesthetist.label","Common");
	returnedValues = await CommonLookup(Anaesthetist,argumentArray );
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
	document.forms[0].Anaesthetiest2_code.value=arr[1];
		document.forms[0].Anaesthetiest1_code.value=arr[0];
	}
else
	{
document.forms[0].Anaesthetiest1_code.value="";
document.forms[0].Anaesthetiest2_code.value="";
	}
}

function enterKeyCheck(event){
	if(event.keyCode == 13)return false;
}

async function AssignTheatre(obj){
	var formObj			= document.assigntheatreForm;
	var locale			= formObj.locale.value;
	var result			= false ;
	var message			= "" ;
	var flag			= "" ;
	var function_id		= "";
	var flg				= "";
	var argumentArray	= new Array();
	var dataNameArray	= new Array();
	var dataValueArray	= new Array();
	var dataTypeArray	= new Array();
	var facility_id_1	= document.forms[0].facility_id_1.value;
	var sql="SELECT SHORT_DESC DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID ='"+facility_id_1+"' AND upper(SHORT_DESC) like upper(?) AND upper(OPER_ROOM_CODE) like upper(?) order by 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	var Theatre =getLabel("Common.Theatre.label","Common");
	
	
	returnedValues = await CommonLookup(Theatre, argumentArray );
	var ret1=unescape(returnedValues);
	
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
	document.forms[0].theatre.value=arr[1];
		document.forms[0].theatre_code.value=arr[0];
	}
else
	{
document.forms[0].theatre.value="";
document.forms[0].theatre_code.value="";
	}
}
function savetheatre()
{  
	var frmObj=document.forms[0];
	var theatre_code=document.forms[0].theatre_code.value;
	var theatre=document.forms[0].theatre.value;
	var facility_id_1=document.forms[0].facility_id_1.value;
	var order_id_1=document.forms[0].order_id_1.value;
	var booking_num_1=document.forms[0].booking_num_1.value;
	   
	if(theatre=='' || theatre== null)
	{
		var tit=getLabel("Common.Theatre.label","Common")
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var err_msg=msg.split("&")		 
		alert(err_msg[0]+""+tit+""+err_msg[1]);
		return;
	}
	var ret=new Array();

	var sql="SELECT 'X' FROM OT_BOOKING_TIME_SLOTS WHERE OPERATING_FACILITY_ID	= '"+facility_id_1+"' AND BOOKING_DATE = TRUNC(SYSDATE) AND OPER_ROOM_CODE = '"+theatre_code+"'";

	var param="sql="+sql;
	var ret1=true;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var resTxt=xmlHttp.responseText;
	resTxt=eval(resTxt);
	var flag1=false;
	if(resTxt!='X') 
	{
		ret1=confirm(getMessage("APP-OT0192","OT"));
		flag1=true;
	}
	if(ret1==true && flag1==false)
	{
		var sql1="SELECT 'X'  FROM OT_BOOKING_TIME_SLOTS  WHERE OPERATING_FACILITY_ID	= '"+facility_id_1+"'  AND BOOKING_DATE = TRUNC(SYSDATE)  AND TO_CHAR(BOOKING_TIME,'HH24:MI')	>= TO_CHAR(SYSDATE,'HH24:MI') AND STATUS= 10 AND OPER_ROOM_CODE =  '"+theatre_code+"'";

		var param="sql="+sql1;
		var ret1=true;

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		var resTxt1=xmlHttp.responseText;
		resTxt1=eval(resTxt1);
			if(resTxt1!='X')
			{
		    ret1=confirm(getMessage("APP-OT0193","OT"));
			}
	}

	if(ret1==true)
	{
	    var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="VerificationValidation.jsp?facility_id="+facility_id_1+"&order_id_1="+order_id_1+"&booking_num_1="+booking_num_1+"&theatre_code="+theatre_code;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		ret=retVal.split("##");
		var p_status=ret[0];
		var p_msg_txt=ret[1];
		var p_msg_lang_txt=ret[2];

		if(p_status=="S")
		{
			window.returnValue="RECORD_INSERT";
			alert(getMessage("RECORD_INSERTED","SM"));
			window.close();
		}
		if(p_status=="E")
			alert(p_msg_txt)
			window.close();
	}
}
