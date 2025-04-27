/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function populateOption()
{
	
	var patient_id=document.forms[0].patient_id.value;
	//alert("patient_id"+patient_id);
	var url_desc=document.forms[0].url_desc.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " patient_id=\""+ patient_id + "\" ";	
	xmlStr += " url_desc=\""+ url_desc + "\" ";	
	xmlStr += " /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SlateScanPatientParams.jsp",false);
	xmlHttp.send(xmlDoc);
	retVal = trimString(xmlHttp.responseText);
	//alert(retVal);
	if(retVal!="" && retVal!="undeifned" && retVal!=null)
	{
	var oper_num=new Array();
	var all_vals=new Array();
	var all_opers=new Array();
	var sch_type="";
	if(url_desc=="OTCheckInToOR")
	{
		oper_num=retVal.split("#");
		
		
	}
	else if(url_desc=="OTCheckIn")
	{
		all_vals=retVal.split("###");
		
		sch_type= all_vals[1];
		all_opers=all_vals[0];
				
		oper_num= all_opers.split("#");
		
		
	}
	var scan_option= document.forms[0].scan_option;
	var len=scan_option.length;
	var j=1;
	if(oper_num[1]=="" && oper_num.length > 1)
	{
		  oper_num.length=1;
	 
	}
	if(oper_num[0]!="" && oper_num[1]!="" && oper_num.length > 1)
	{
		  oper_num.length=oper_num.length-1;
	 
	}
	if(oper_num.length>1)
	{
		document.forms[0].document.getElementById("acc_num").innerHTML="Accession Number&nbsp";
		document.forms[0].scan_option_1.style.visibility='visible';
	}
	if(oper_num.length==1)
	{
			document.forms[0].operation_number.value=oper_num;
	}
	for(len=0;len<oper_num.length;len++){
			scan_option.options[j++]=new Option(oper_num[len],oper_num[len]);
			if(oper_num.length==1 && sch_type=="")
		  {
				callBarcodeFunction();
				window.close();
				
		  }
	  }
	  if(sch_type!=null && sch_type!="null" && sch_type!=""){
		  document.forms[0].sch_type.value=sch_type;
		  if(document.forms[0].sch_type.value!="" && oper_num.length==1)
		  {
				callBarcodeFunction();
				window.close();
		  }
		 // alert("document.forms[0].sch_type.value"+document.forms[0].sch_type.value);
	}
	}
}
