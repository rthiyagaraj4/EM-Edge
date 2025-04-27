
/***********************************************************
/*                  SetupParameter.JS
/***********************************************************/

function create() {
content.location.href=contextPath+"/SetupParameterAction.do?method="+loadMethod+"&vo.functionId="+functionId
}

//========================================================
//  validate  receipt date  with delivery date
//========================================================
function onApplyValidation()
{
var error="";
var fieldReceipt = new Array(content.document.SetupParameterForm["vo.cutOffTimeForLinRecptTo"].value,content.document.SetupParameterForm["vo.cutOffTimeForLinRecpt2To"].value,content.document.SetupParameterForm["vo.cutOffTimeForLinRecpt3To"].value);
var fieldDelivery = new Array(content.document.SetupParameterForm["vo.cutOffTimeForLinenDelv"].value,content.document.SetupParameterForm["vo.cutOffTimeForLinenDelv2"].value,content.document.SetupParameterForm["vo.cutOffTimeForLinenDelv3"].value);
var legend =new Array("com.iba.ehis.lc.setUpParameter.cut-OffTimeForAcceptance","com.iba.ehis.lc.setUpParameter.cut-OffTimeForDelivery");
	if(fieldDelivery[0]!=""){
	IBADateValidator.isDateTimeGreaterThanJS(fieldDelivery[0],fieldReceipt[0],'en',callBackFunction1);
	function callBackFunction1(data){
		if(!data){ 
	 getServerMessage("APP-LC00025");
	 var servermessage1 =dwrMessage;
	 var msg1=servermessage1.split("#");
	 getServerMessage(legend[0]);
	 var legend_key1 = dwrMessage;
	 getServerMessage(legend[1]);
	 var legend_key2 = dwrMessage;
	 error =error+msg1[0]+" "+ legend_key2+":1   " + msg1[1] +"   "+ legend_key1+":1";
	 content.document.SetupParameterForm["cutOffTimeForLinenDelv1"].setFocus;
	 content.document.SetupParameterForm["cutOffTimeForLinenDelv1"].value="";
	 messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		}
	else
		{
		if(fieldDelivery[1]!=""){
		IBADateValidator.isDateTimeGreaterThanJS(fieldDelivery[1],fieldReceipt[1],'en',callBackFunction2);
		function callBackFunction2(data1){
		if(!data1){ 
					 getServerMessage("APP-LC00025");
					 var servermessage2 =dwrMessage;
					 var msg2=servermessage2.split("#");
					 getServerMessage(legend[0]);
					 var legend_key2 = dwrMessage;
					 getServerMessage(legend[1]);
					 var legend_key3 = dwrMessage;
					 var error1 =error+msg2[0]+" "+ legend_key3+":2   " + msg2[1] +"   "+ legend_key2+":2";
					 content.document.SetupParameterForm["cutOffTimeForLinenDelv2"].setFocus;
					 content.document.SetupParameterForm["cutOffTimeForLinenDelv2"].value="";
					 messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error1;
									
				}
				else
				{
					if(fieldDelivery[2]!=""){
				IBADateValidator.isDateTimeGreaterThanJS(fieldDelivery[2],fieldReceipt[2],'en',callBackFunction3);
					function callBackFunction3(data2){
						if(!data2){		
					 getServerMessage("APP-LC00025");
					 var servermessage3 =dwrMessage;
					 var msg3=servermessage3.split("#");
					 getServerMessage(legend[0]);
					 var legend_key4 = dwrMessage;
					 getServerMessage(legend[1]);
					 var legend_key5 = dwrMessage;
					 var error2 =error+msg3[0]+" "+ legend_key5+":3   " + msg3[1] +"   "+ legend_key4+":3";
					 content.document.SetupParameterForm["cutOffTimeForLinenDelv3"].setFocus;
					 content.document.SetupParameterForm["cutOffTimeForLinenDelv3"].value="";
					 messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error2;
					}
					else
						{content.SetupParameterForm.submit();}
					}
				}else
						{content.SetupParameterForm.submit();}
		}}}else
						{content.SetupParameterForm.submit();}
	}
}
}else
						{content.SetupParameterForm.submit();}

}

function validateDate(arg)
{
var error="";
var fieldReceipt = new Array(document.SetupParameterForm["vo.cutOffTimeForLinRecptTo"].value,document.SetupParameterForm["vo.cutOffTimeForLinRecpt2To"].value,document.SetupParameterForm["vo.cutOffTimeForLinRecpt3To"].value);
var fieldDelivery = new Array(document.SetupParameterForm["vo.cutOffTimeForLinenDelv"].value,document.SetupParameterForm["vo.cutOffTimeForLinenDelv2"].value,document.SetupParameterForm["vo.cutOffTimeForLinenDelv3"].value);
var legend =new Array("com.iba.ehis.lc.setUpParameter.cut-OffTimeForAcceptance","com.iba.ehis.lc.setUpParameter.cut-OffTimeForDelivery");
//alert(fieldReceipt[arg]+" "+fieldDelivery[arg]);
IBADateValidator.isDateTimeGreaterThanJS(fieldDelivery[arg],fieldReceipt[arg],'en',callBackFunction);
	function callBackFunction(data){//alert(data)
		if(!data){
	getServerMessage("APP-LC00025");
	 var servermessage1 =dwrMessage;
	 var msg1=servermessage1.split("#");
	 getServerMessage(legend[0]);
	 var legend_key1 = dwrMessage;
	 getServerMessage(legend[1]);
	 var legend_key2 = dwrMessage;
	 var t1=parseInt(arg)+1;
	 error =error+msg1[0]+" "+ legend_key2+":"+t1+"   " + msg1[1] +"   "+ legend_key1+":"+t1;
	 parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			if(arg!='0')
			{	arg=parseInt(arg)+1;
				document.SetupParameterForm["cutOffTimeForLinenDelv"+arg].setFocus;
				document.SetupParameterForm["cutOffTimeForLinenDelv"+arg].value="";
			}
			else
			{
				document.SetupParameterForm["cutOffTimeForLinenDelv"].setFocus;
				document.SetupParameterForm["cutOffTimeForLinenDelv"].value="";
			}

		}
	else
		{
	 	 parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		}
	}
}
//===================== functin apply()=============
function apply() {
	 onApplyValidation();

}


//========================== RESET =============
 function reset()
 {
   content.location.href=contextPath+"/SetupParameterAction.do?method="+loadMethod+"&vo.functionId="+functionId
 }
  //==================== checkNull =============
function checkNullLocal()
 { 
 	var flag;
  	var fieldName=new Array("com.iba.ehis.lc.setUpParameter.cut-OffTimeForAcceptance","com.iba.ehis.lc.setUpParameter.cut-OffTimeForDelivery","com.iba.ehis.lc.setUpParameter.allowLinenThanStock");
	var fields = new Array(content.document.SetupParameterForm["cutOffTimeForLinenRecpt"],content.document.SetupParameterForm["cutOffTimeForLinenDelv"],content.document.SetupParameterForm["vo.stdStockChk"]);
	flag=checkNullDS(fieldName,fields);
	if(flag==false) return false; else return true;
 }
 

//=================================
function CurrDate(){	
		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		scNow = currDate.getSeconds();
		//alert(time)
		mon = mon+1;
		var year = currDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		var convert1= date + "/" + mon + "/" + year;
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		
		//convert1=convert1+" "+hrNow+ ":" +mnNow;
	return convert1;

}
//==============================================
function getTime()
{

	var DateTimeVal=document.getElementById("vo.cutOffTimeForLinRecptTo").value;
	var temp=DateTimeVal.substring(11,17);
	var DateTimeVal=document.getElementById("vo.cutOffTimeForLinenDelv").value;
	var temp1=DateTimeVal.substring(11,17);
	document.getElementById("cutOffTimeForLinenRecpt").value=temp;
	document.getElementById("cutOffTimeForLinenDelv").value=temp1;

	var DateTimeVal2=document.getElementById("vo.cutOffTimeForLinRecpt2To").value;
	var temp2=DateTimeVal2.substring(11,17);
	var DateTimeVal3=document.getElementById("vo.cutOffTimeForLinenDelv2").value;
	var temp3=DateTimeVal3.substring(11,17);
	document.getElementById("cutOffTimeForLinenRecpt2").value=temp2;
	document.getElementById("cutOffTimeForLinenDelv2").value=temp3;

	var DateTimeVal4=document.getElementById("vo.cutOffTimeForLinRecpt3To").value;
	var temp4=DateTimeVal4.substring(11,17);
	var DateTimeVal5=document.getElementById("vo.cutOffTimeForLinenDelv3").value;
	var temp5=DateTimeVal5.substring(11,17);
	document.getElementById("cutOffTimeForLinenRecpt3").value=temp4;
	document.getElementById("cutOffTimeForLinenDelv3").value=temp5; 

	var DateTimeVal6=document.getElementById("vo.cutOffTimeForLinRecpt2Fr").value;
	var temp6=DateTimeVal6.substring(11,17);
	document.getElementById("cutOffTimeForLinRecpt2Fr").value=temp6;

	var DateTimeVal7=document.getElementById("vo.cutOffTimeForLinRecpt3Fr").value;
	var temp7=DateTimeVal7.substring(11,17);
	document.getElementById("cutOffTimeForLinRecpt3Fr").value=temp7;
	

}
// setting the cut-off  receive and delivery  Date&Time 
//========================================================
function getTime1()
{
	var recptTime=document.getElementById("cutOffTimeForLinenRecpt").value;
	var delvTime=document.getElementById("cutOffTimeForLinenDelv").value;
	document.getElementById("cutOffTimeForLinRecpt2Fr").value=recptTime;
	if(recptTime=='')
	{
	document.getElementById("vo.cutOffTimeForLinRecptTo").value="";
	}
	else
	{
	var cDate=CurrDate();
	var temp=cDate+" "+recptTime;
	document.getElementById("vo.cutOffTimeForLinRecptTo").value=temp;
	document.getElementById("vo.cutOffTimeForLinRecpt2Fr").value=temp;
	var temp1=cDate+" "+"00:00";
	document.getElementById("vo.cutOffTimeForLinRecptFr").value=temp1;

	}
	if(delvTime=='')
	{
	document.getElementById("vo.cutOffTimeForLinenDelv").value=""
	}
	else
	{
	var cDate=new Date();	
	var day=document.getElementById("vo.cutOfDaysForLinenDelv").value;
	var cDate;
	var msecsInADay = 86400000;
	var temp1;
	if(day!="0")
		{
		var totalMsecs=parseInt(msecsInADay)*parseInt(day);
		cDate=new Date(cDate.getTime() + totalMsecs);
		var date = cDate.getDate();
		var mon = cDate.getMonth();
		mon = mon+1;
		var year = cDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		var convert1= date + "/" + mon + "/" + year;
		temp1=convert1+" "+delvTime;
		}
		else
		{
		cDate=CurrDate();
		temp1=cDate+" "+delvTime;
		}	
		document.getElementById("vo.cutOffTimeForLinenDelv").value=temp1;
	
	}


}
function getTime2()
{
	var recptTime2=document.getElementById("cutOffTimeForLinenRecpt2").value;
	var delvTime2=document.getElementById("cutOffTimeForLinenDelv2").value;
	document.getElementById("cutOffTimeForLinRecpt3Fr").value=recptTime2;

	if(recptTime2=='')
	{
	document.getElementById("vo.cutOffTimeForLinRecpt2To").value="";
	}
	else
	{
		
	var cDate=CurrDate();
	var temp=cDate+" "+recptTime2;
	document.getElementById("vo.cutOffTimeForLinRecpt2To").value=temp;
	document.getElementById("vo.cutOffTimeForLinRecpt3Fr").value=temp;
	}
	if(delvTime2=='')
	{
	document.getElementById("vo.cutOffTimeForLinenDelv2").value=""
	}
	else
	{
	var cDate=new Date();	
	var day=document.getElementById("vo.cutOfDaysForLinenDelv2").value;
	var cDate;
	var msecsInADay = 86400000;
	var temp1;
	if(day!="0")
		{
		var totalMsecs=parseInt(msecsInADay)*parseInt(day);
		cDate=new Date(cDate.getTime() + totalMsecs);
		var date = cDate.getDate();
		var mon = cDate.getMonth();
		mon = mon+1;
		var year = cDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		var convert1= date + "/" + mon + "/" + year;
		temp1=convert1+" "+delvTime2;
		}
		else
		{
		cDate=CurrDate();
		temp1=cDate+" "+delvTime2;
		}	
		document.getElementById("vo.cutOffTimeForLinenDelv2").value=temp1;
	}


}
function getTime3()
{
	var recptTime3=document.getElementById("cutOffTimeForLinenRecpt3").value;
	var delvTime3=document.getElementById("cutOffTimeForLinenDelv3").value;
	if(recptTime3=='')
	{
	document.getElementById("vo.cutOffTimeForLinRecpt3To").value="";
	}
	else
	{
		
	var cDate=CurrDate();
	var temp=cDate+" "+recptTime3;
	document.getElementById("vo.cutOffTimeForLinRecpt3To").value=temp;
	}
	if(delvTime3=='')
	{
	document.getElementById("vo.cutOffTimeForLinenDelv3").value=""
	}
	else
	{
	var cDate=new Date();	
	var day=document.getElementById("vo.cutOfDaysForLinenDelv3").value;
	var cDate;
	var msecsInADay = 86400000;
	var temp1;
	if(day!="0")
		{
		var totalMsecs=parseInt(msecsInADay)*parseInt(day);
		cDate=new Date(cDate.getTime() + totalMsecs);
		var date = cDate.getDate();
		var mon = cDate.getMonth();
		mon = mon+1;
		var year = cDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		var convert1= date + "/" + mon + "/" + year;
		temp1=convert1+" "+delvTime3;
		}
		else
		{
		cDate=CurrDate();
		temp1=cDate+" "+delvTime3;
		}	
		document.getElementById("vo.cutOffTimeForLinenDelv3").value=temp1;
	}


}
//=============================================
function showDayNo()
{
var obj=document.getElementById("cutOfDaysForLinenDelv");
if(parseInt(obj.value)<2)
	{
	document.getElementById("vo.cutOfDaysForLinenDelv").value=obj.value;
	document.getElementById("dayNo").style.visibility="hidden";
	}
else if(obj.value=="")
	{	
		document.getElementById("vo.cutOfDaysForLinenDelv").value="";
		document.getElementById("dayNo").style.visibility="hidden";
		document.getElementById("dayNo").value="";
	}
else
	{document.getElementById("dayNo").style.visibility="visible";}
}
function showDayNo2()
{
var obj=document.getElementById("cutOfDaysForLinenDelv2");
if(parseInt(obj.value)<2){
	document.getElementById("vo.cutOfDaysForLinenDelv2").value=obj.value;
	document.getElementById("dayNo2").style.visibility="hidden";
	}
else if(obj.value=="")
	{
	document.getElementById("vo.cutOfDaysForLinenDelv2").value="";
	document.getElementById("dayNo2").style.visibility="hidden";
		document.getElementById("dayNo2").value="";
	}
else{document.getElementById("dayNo2").style.visibility="visible";}
}
function showDayNo3()
{
var obj=document.getElementById("cutOfDaysForLinenDelv3");
if(parseInt(obj.value)<2){
	document.getElementById("vo.cutOfDaysForLinenDelv3").value=obj.value;
	document.getElementById("dayNo3").style.visibility="hidden";
	}
else if(obj.value=="")
	{
	document.getElementById("dayNo3").style.visibility="hidden";
	document.getElementById("vo.cutOfDaysForLinenDelv3").value="";
	document.getElementById("dayNo3").value="";
	}
else{document.getElementById("dayNo3").style.visibility="visible";}
}

function setDayNo(obj)
{
var obName=trimString(obj.name);
	if(obName=="dayNo")
		{document.getElementById("vo.cutOfDaysForLinenDelv").value=obj.value;}
	else if(obName=="dayNo2")
		{document.getElementById("vo.cutOfDaysForLinenDelv2").value=obj.value;}
	else if(obName=="dayNo3")
		{document.getElementById("vo.cutOfDaysForLinenDelv3").value=obj.value;}
}
// hide dayNo text box
//======================
function hidedayNo()
{
	//alert(document.getElementById("vo.cutOfDaysForLinenDelv").value)
	if(parseInt(document.getElementById("vo.cutOfDaysForLinenDelv").value)<2)
	{document.getElementById("dayNo").style.visibility="hidden";}
	if(document.getElementById("vo.cutOfDaysForLinenDelv").value=="")
	{document.getElementById("dayNo").style.visibility="hidden";}
	
	if(parseInt(document.getElementById("vo.cutOfDaysForLinenDelv2").value)<2){
	document.getElementById("dayNo2").style.visibility="hidden";}
	if(document.getElementById("vo.cutOfDaysForLinenDelv").value=="")
	{document.getElementById("dayNo2").style.visibility="hidden";}
	
	if(parseInt(document.getElementById("vo.cutOfDaysForLinenDelv3").value)<2){
	document.getElementById("dayNo3").style.visibility="hidden";}
	if(document.getElementById("vo.cutOfDaysForLinenDelv").value=="")
	{document.getElementById("dayNo3").style.visibility="hidden";}


	
}
//==========================================
 function defaultDayStatus()
{
var val=document.getElementById("vo.cutOfDaysForLinenDelv");
var val2=document.getElementById("vo.cutOfDaysForLinenDelv2").value;
var val3=document.getElementById("vo.cutOfDaysForLinenDelv3").value;

var el = document.getElementsByTagName("SELECT").item(1);
if (el != null) 
	{
	for (i=0; i<el.options.length; i++) 
		{
           	if(el.options(i).value==val.value)
       		{
				el.options(i).selected=true;
   			}
			else if(parseInt(val.value)>=2)
			{
				el.options(parseInt(el.options.length)-1).selected=true;
				document.getElementById("dayNo").style.visibility="visible";
				document.getElementById("dayNo").value=val;
			}
			
		}
	}
var el2 = document.getElementsByTagName("SELECT").item(2);
if (el2 != null) 
	{
	for (i=0; i<el2.options.length; i++) 
		{

		   	if(el2.options(i).value==val2)
       		{
			 el2.options(i).selected=true;
   			}
			else if(parseInt(val2)>=2)
			{
				
				el2.options(parseInt(el2.options.length)-1).selected=true;
				document.getElementById("dayNo2").style.visibility="visible";
				document.getElementById("dayNo2").value=val2;
			}
			
		}
	}
var el3 = document.getElementsByTagName("SELECT").item(3);
if (el3 != null) 
	{
		for (i=0; i<el3.options.length; i++) 
		{
           	if(el3.options(i).value==val3)
       		{
			 el3.options(i).selected=true;
   			}
			else if(parseInt(val3)>=2)
			{
				el3.options(parseInt(el3.options.length)-1).selected=true;
				document.getElementById("dayNo3").style.visibility="visible";
				document.getElementById("dayNo3").value=val3;
			}
		}
	}
}
//==================================================================================================

function  checkReceipt(obj)
{
	
	if(obj.value!="")
	{
	var receipt="";
	var receipt2="";

	if(obj.name=='cutOffTimeForLinenRecpt2'){receipt=document.getElementById("cutOffTimeForLinenRecpt").value;}
	else if(obj.name=='cutOffTimeForLinenRecpt3'){receipt=document.getElementById("cutOffTimeForLinenRecpt2").value;}
	
	receipt2=obj.value;
	var fromTime = CurrDate();
	fromTime=fromTime+" "+receipt;
	var toTime =  CurrDate();
	toTime=toTime+" "+receipt2;
	var legend =new Array("com.iba.ehis.lc.setUpParameter.cut-OffTimeForAcceptance");
		IBADateValidator.isDateTimeGreaterThanJS(toTime,fromTime,'en',callBackFunction);
		function callBackFunction(data){
			if(!data){
			 getServerMessage("APP-LC00023");
			 var servermessage =dwrMessage;
			 var msg=servermessage.split("#");
			 var message_key=msg[0]
			 var message=msg[1]
			 getServerMessage(legend[0]);
			 var legend_key0 = dwrMessage;
			if(obj.name=='cutOffTimeForLinenRecpt2'){
			 error =message_key+""+ legend_key0 +" 1 " +  message +" "+ legend_key0+" 2 ";}
			else if(obj.name=='cutOffTimeForLinenRecpt3'){
			 error =message_key+""+ legend_key0 +"2 "+  message +" "+ legend_key0+"3 ";}
			 parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			obj.value="";
		
				 
			}else
			{
			 error =""
			 parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			}
		
		}
	}
	

}
//====================================================
function checkNumber(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
			parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
}
//====================== check time format  ===============
function verify(timeBox){
//	alert(timeBox.value.length)
	if(timeBox.value!="")
			{
				if(parseInt(timeBox.value.length)<=parseInt(5))
				{
							   time=timeBox.value;
							   time1=time.split(':')
							   if (!/\d{2}:\d{2}/.test(time)){ 
									getServerMessage("APP-LC00019");
									var servermessage =dwrMessage;
									alert(servermessage)
									timeBox.value='';
									timeBox.focus();
								   return false;
							   }
							   else if (time1[0] >23 || time1[1]>59) {
									getServerMessage("APP-LC00019");
									var servermessage1 =dwrMessage;
									alert(servermessage1)
							timeBox.value='';
							timeBox.focus();
							return false;
							}
							else return true;
		}else
		{
			timeBox.value='';
				getServerMessage("APP-LC00019");
				var servermessage2 =dwrMessage;
		        alert(servermessage2)
					timeBox.focus();
					return false;
		}
	}
	else
	{
		getServerMessage("APP-LC00019");
		var servermessage2 =dwrMessage;
		alert(servermessage2)
		timeBox.focus();
		return false;
	}
}

function showCutOffRows()
{
	var row=document.getElementById("vo.noOfcutOfTimings").value;
	if(row=='0')
	{
		document.getElementById("row1").style.visibility="hidden";
		document.getElementById("row2").style.visibility="hidden";
		document.getElementById("row3").style.visibility="hidden";
		document.getElementById("headerLabel").style.visibility="visible";
		if(document.getElementById("dayNo").value!="")
		{
			document.getElementById("dayNo").style.visibility="hidden";
		}
		document.getElementById("dayNo2").style.visibility="hidden";
		document.getElementById("dayNo3").style.visibility="hidden";
		document.getElementById("vo.cutOffTimeForLinRecptFr").value="";
		document.getElementById("vo.cutOffTimeForLinRecpt2Fr").value="";
		document.getElementById("vo.cutOffTimeForLinRecpt3Fr").value="";
		document.getElementById("vo.cutOffTimeForLinRecptTo").value="";
		document.getElementById("vo.cutOffTimeForLinRecpt2To").value="";
		document.getElementById("vo.cutOffTimeForLinRecpt3To").value="";
		document.getElementById("vo.cutOffTimeForLinenDelv").value="";
		document.getElementById("vo.cutOffTimeForLinenDelv2").value="";
		document.getElementById("vo.cutOffTimeForLinenDelv3").value="";

		document.getElementById("cutOffTimeForLinenDelv").value="";
		document.getElementById("cutOffTimeForLinenDelv2").value="";
		document.getElementById("cutOffTimeForLinenDelv3").value="";

		document.getElementById("cutOffTimeForLinenRecpt").value="";
		document.getElementById("cutOffTimeForLinenRecpt2").value="";
		document.getElementById("cutOffTimeForLinenRecpt3").value="";


		
	}
	else if(row=='2'){
		document.getElementById("row1").style.visibility="visible";
		document.getElementById("row2").style.visibility="visible";
		document.getElementById("row3").style.visibility="hidden";
		document.getElementById("dayNo3").style.visibility="hidden";
		document.getElementById("headerLabel").style.visibility="hidden";
		if(document.getElementById("dayNo").value!="")
		{document.getElementById("dayNo").style.visibility="visible";}
		if(document.getElementById("dayNo2").value!="")
		{document.getElementById("dayNo2").style.visibility="visible";}
		if(document.getElementById("vo.noOfcutOfTimings").value==2)
			{
			document.getElementById("cutOffTimeForLinenRecpt2").value="23:59";
			document.getElementById("cutOffTimeForLinenRecpt2").disabled=true;
			var dt=CurrDate();
			document.getElementById("vo.cutOffTimeForLinRecpt2To").value=dt+" 23:59";
			document.getElementById("vo.cutOffTimeForLinRecpt3To").value="";
			document.getElementById("vo.cutOffTimeForLinRecpt3Fr").value="";
			document.getElementById("vo.cutOffTimeForLinenDelv3").value="";
			}

		}
	else if(row=='3'){
		document.getElementById("row1").style.visibility="visible";
		document.getElementById("row2").style.visibility="visible";
		document.getElementById("row3").style.visibility="visible";
		document.getElementById("headerLabel").style.visibility="hidden";
		if(document.getElementById("dayNo").value!="")
		{document.getElementById("dayNo").style.visibility="visible";}
		if(document.getElementById("dayNo2").value!="")
		{document.getElementById("dayNo2").style.visibility="visible";}
		if(document.getElementById("dayNo3").value!="")
		{document.getElementById("dayNo3").style.visibility="visible";}
		}
		if(document.getElementById("vo.noOfcutOfTimings").value==3)
			{
			document.getElementById("cutOffTimeForLinenRecpt2").disabled=false;
			document.getElementById("cutOffTimeForLinenRecpt2").value=document.getElementById("cutOffTimeForLinRecpt3Fr").value;
			var dt=CurrDate();
			document.getElementById("vo.cutOffTimeForLinRecpt3To").value=dt+" 23:59";
			document.getElementById("cutOffTimeForLinenRecpt3").value="23:59";

			}
};
//=================================
function  checkDelivery(obj)
{
	if(obj.value!="")
	{
	var fromTime="";
	var toTime="";
	
	if(obj.name=='cutOffTimeForLinenDelv2'){fromTime=document.getElementById("vo.cutOffTimeForLinenDelv").value;
	toTime=document.getElementById("vo.cutOffTimeForLinenDelv2").value;
	}
	else if(obj.name=='cutOffTimeForLinenDelv3'){fromTime=document.getElementById("vo.cutOffTimeForLinenDelv2").value;
		toTime=document.getElementById("vo.cutOffTimeForLinenDelv3").value;
	}
	//alert(toTime+" "+fromTime)
	
		IBADateValidator.isDateTimeGreaterThanJS(toTime,fromTime,'en',callBackFunction);
		function callBackFunction(data){ 
			if(!data){
			 var error="";
			 getServerMessage("APP-LC00023");
			 var servermessage =dwrMessage;
			 var msg=servermessage.split("#");
			 var message_key=msg[0]
			 var message=msg[1]
			 getServerMessage("com.iba.ehis.lc.setUpParameter.cut-OffTimeForDelivery");
			 var legend_key0 = dwrMessage;

			if(obj.name=='cutOffTimeForLinenDelv2'){  
			 error =message_key+""+ legend_key0 +" 1 " +  message +" "+ legend_key0+" 2 ";}
			else if(obj.name=='cutOffTimeForLinenDelv3'){ 
			 error =message_key+""+ legend_key0 +" 2 "+  message +" "+ legend_key0+" 3 ";}
			 parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			 obj.value="";
			}else
			{
			var error =""
			 parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			}
		
		}
	}
}
