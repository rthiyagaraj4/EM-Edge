var result = false ;
var message = "" ;
var flag = "" ;
var mode=0;



var firstTime=true;
var pageNum=1;


function create(){

	mode=1;
	
	ConstituentPrecipitationLimitFrames.location.href="../../ePH/jsp/ConstituentPrecipitationLimitFrames.jsp?mode="+mode ;
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
}

function query(){
	
	mode=3;
	ConstituentPrecipitationLimitFrames.location.href="../../ePH/jsp/ConstituentPrecipitationLimitFrames.jsp?mode="+mode ;
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
}

function apply()
{	
	
if(mode==1){
		frmobj=ConstituentPrecipitationLimitFrames.ConstituentPrecipitationLimitAddmodify.document.forms[0];


		var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
		var blankObject 	= false ;
		var cnt = parseInt(frmobj.cnt.value);
		var fields = new Array();
		var names= new Array();
		var value_check='';
//alert(frmobj.innerHTML);

		for(var frmCount=0; frmCount<cnt; frmCount++)
		{
			fields=new Array(eval("frmobj.Gen_Name_Limit_From_"+frmCount));
			names=new Array("Constituent Generic Name Limiting From");

			if(checkFieldsofMst(fields, names, messageFrame, errorPage))
			{
				fields=new Array(eval("frmobj.Mol_Name_From_"+frmCount));
				names=new Array("Molecule Name Limiting From");
				if(checkFieldsofMst(fields, names, messageFrame, errorPage))
				{
					fields=new Array(eval("frmobj.Gen_Name_Limit_To_"+frmCount));
					names=new Array("Constituent Generic Name Limiting To");
					if(checkFieldsofMst(fields, names, messageFrame, errorPage))
					{
						fields=new Array(eval("frmobj.Mol_Name_To_"+frmCount));
						names=new Array("Molecule Name Limiting To");
						if(checkFieldsofMst(fields, names, messageFrame, errorPage))
						{
							fields=new Array(eval("frmobj.Con_ConCen_From_Min_"+frmCount));
							names=new Array("Constituent Concentration From Min");
							if(checkFieldsofMst(fields, names, messageFrame, errorPage))
							{
									fields=new Array(eval("frmobj.Con_ConCen_From_Max_"+frmCount));
									names=new Array("Constituent Concentration From Max");
									if(checkFieldsofMst(fields, names, messageFrame, errorPage))
									{		checkRange(eval("frmobj.Con_ConCen_From_Min_"+frmCount),eval("frmobj.Con_ConCen_From_Max_"+frmCount));
											fields=new Array(eval("frmobj.Con_ConCen_To_Min_"+frmCount));
											names=new Array("Constituent Concentration To Min");
											if(checkFieldsofMst(fields, names, messageFrame, errorPage))
											{
											fields=new Array(eval("frmobj.Con_ConCen_To_Max_"+frmCount));
											names=new Array("Constituent Concentration To Max");
												if(checkFieldsofMst(fields, names, messageFrame, errorPage))
												{														checkRange(eval("frmobj.Con_ConCen_To_Min_"+frmCount),eval("frmobj.Con_ConCen_To_Max_"+frmCount));
																fields=new Array(eval("frmobj.precipitation_indicator_"+frmCount));
																names=new Array("Precipitation Indicator");
																if(checkFieldsofMst(fields, names, messageFrame, errorPage))
																{fields=new Array(eval("frmobj.precipitation_alert_msg_"+frmCount));
																names=new Array("Precipitation Alert Message");
																					if(checkFieldsofMst(fields, names, messageFrame, errorPage))
																					{
																					
																					//fields	= new Array(eval("frmobj.Gen_Name_Limit_From_"+frmCount),eval("frmobj.Gen_Name_Limit_To_"+frmCount), eval("frmobj.Mol_Name_From_"+frmCount), eval("frmobj.Mol_Name_To_"+frmCount),eval("frmobj.Con_ConCen_From_Min_"+frmCount),eval("frmobj.Con_ConCen_From_Max_"+frmCount),eval("frmobj.Con_ConCen_To_Min_"+frmCount),eval("frmobj.Con_ConCen_To_Max_"+frmCount),eval("frmobj.precipitation_indicator_"+frmCount),eval("frmobj.precipitation_alert_msg_"+frmCount));
																					//names	= new Array("Constituent Generic Name Limiting From","Constituent Generic Name Limiting To","Molecule Name Limiting From", "Molecule Name Limiting To","Constituent Concentration From Min","Constituent Concentration From max","Constituent Concentration To Min","Constituent Concentration To Max","Precipitation Indicator","Precipitation Alert Message");
																					//blankObject  = checkFieldsofMst(fields, names, messageFrame, errorPage) ;
																												if(blankObject==true)
																												{

																												//break;
																												//frmCount=0;
																												//cnt=0;
																												}
																												value_check = 'V';
																												

																					//eval(formApply(frmobj,PH_CONTROLLER) ) ;
																					//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
																						
																				
																				//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
																					}else
																					{
																					eval("frmobj.precipitation_alert_msg_"+frmCount).focus();
																					return false;
																					}
																}else
																{
																eval("frmobj.precipitation_indicator_"+frmCount).focus();
																return false;
																}
												}else
												{
												eval("frmobj.Con_ConCen_To_Max_"+frmCount).focus();
												return false;
												}
											}else
											{
											eval("frmobj.Con_ConCen_To_Min_"+frmCount).focus();
											return false;
											}
									}else
									{
									eval("frmobj.Con_ConCen_From_Max_"+frmCount).focus();
									return false;
									}
							}else
							{
							eval("frmobj.Con_ConCen_From_Min_"+frmCount).focus();
							return false;
							}
						}else
						{
						eval("frmobj.Mol_Name_To_"+frmCount).focus();
						return false;
						}
					}else
					{
					eval("frmobj.Gen_Name_Limit_To_"+frmCount).focus();
					return false;
					}
			}else
			{
				eval("frmobj.Mol_Name_From_"+frmCount).focus();
				return false;
			}

			}else
			{
				eval("frmobj.Gen_Name_Limit_From_"+frmCount).focus();
				break;
			}
		

		}
		
		if(value_check=='V')
		{
				
					eval(formApply(frmobj,PH_CONTROLLER) ) ;
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		}
				
		
		if( result ) 
			{
			onSuccess(frmobj);

			}
			
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;


	}else
	{
		frmobj=ConstituentPrecipitationLimitFrames.ConstituentPrecipitationLimitDisplayResult.document.forms[0];
		
		
		eval(formApply(frmobj,PH_CONTROLLER) ) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		if( result ) 
			{
			onSuccess(frmobj);

			}
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
	}
}



function reset()
{
		obj=ConstituentPrecipitationLimitFrames.document;

	//	url1=ConstituentPrecipitationLimitQueryFrame.document.location.href;
		if (typeof(obj)=="object")
		{
			url=obj.location.href;
			create();
	
			
		}
		else
		{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
}

function onSuccess(frmobj)
{
	
			create();
	
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;

		

}
function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
function checkIsNotZero(obj, appendObj) {
	if (obj.value == "0") {
		obj.select();
		alert(getMessage("ZERO_NOT_ALLOWED","PH") + appendObj);
		return true;
	}
	//else {
		//checkSplChars(obj);
	//}
}

function checkSplChars(obj, mode)	{
	if(!CheckChars(obj)) {
		obj.select();
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		return true;
	}
	else {
		if (mode == undefined)
			validNumber(obj);
	}
}

function validNumber(obj) {
	if (obj.value != "") {
		CheckNum(obj);
	}
}


function getMolName(obj,flag_From_To,cnt){

	

		var bean_id 	= document.FormConstituentPresLimitAddmodify.bean_id.value ;
		var bean_name 	= document.FormConstituentPresLimitAddmodify.bean_name.value ;
		
		var Gen_Name_Limit 	= obj.value ;
	
		
		//var Gen_Name_Limit_To 	    = obj.value ;

	if (Gen_Name_Limit.value == "" && flag_From_To == 'F' ) {
		//clearListItems("document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt);
		clearListItems(eval("document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt));
		//document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM.value="";
		eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_"+cnt).value="";
		return;
	}
	if (Gen_Name_Limit.value == "" && flag_From_To == 'T' ) {
	//	clearListItems("document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+cnt);
		clearListItems(eval("document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+cnt));
		//document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_+cnt+.value="";
		eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_"+cnt).value="";
		return;
	}
	//if (Gen_Name_Limit_To.value == "") {
	//	clearListItems("document.FormConstituentPresLimitAddmodify.Mol_Name_To");
	//	return;
	//}
	assignBean(document.FormConstituentPresLimitAddmodify);
	var arrayObject = new Array();
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePH/jsp/ConstituentPrecipitationLimitValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=POPULATE_MOLE" + "&Gen_Name_Limit=" + Gen_Name_Limit+ "&flag_From_To=" + flag_From_To+"&cnt="+cnt, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function getConstGenericUom(obj,cnt){



		var bean_id 	= document.FormConstituentPresLimitAddmodify.bean_id.value ;
		var bean_name 	= document.FormConstituentPresLimitAddmodify.bean_name.value ;
		eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_Min_"+cnt).value="";
		eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_Max_"+cnt).value="";
		eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_Min_"+cnt).value="";
		eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_Max_"+cnt).value="";	
	var Gen_To_UOM 	= obj.value ;
	var Gen_To_UOM_code 	= obj.options(obj.selectedIndex).text ;

	assignBean(document.FormConstituentPresLimitAddmodify);
	var arrayObject = new Array();
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePH/jsp/ConstituentPrecipitationLimitValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CONST_GENRIC_UOM&cnt="+cnt+"&Gen_To_UOM="+Gen_To_UOM+"&Gen_To_UOM_code="+Gen_To_UOM_code, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}


function getConstGenericUomConv(cnt){



		var bean_id 	= document.FormConstituentPresLimitAddmodify.bean_id.value ;
		var bean_name 	= document.FormConstituentPresLimitAddmodify.bean_name.value ;

		var Gen_To_UOM_Conv_index = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_Conv_"+cnt).selectedIndex;
		var Gen_To_UOM_Conv = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_Conv_"+cnt).options(Gen_To_UOM_Conv_index).text;	

	assignBean(document.FormConstituentPresLimitAddmodify);
	var arrayObject = new Array();
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePH/jsp/ConstituentPrecipitationLimitValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CONST_GENRIC_UOM_CONV&cnt="+cnt+"&Gen_To_UOM_Conv="+Gen_To_UOM_Conv, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
}


function clearListItems(listObject) {
	
	var select_option = " --" + getLabel("Common.defaultSelect.label", "Common") + "-- ";
	var len = eval(listObject + ".options.length");
	for (i = 0; i < len; i++) {
		eval(listObject + ".remove(0)");
	}
	var listOption = createListOption("", select_option);
	eval(listObject + ".add(listOption)");
}



function addListItem(listObject, code, text, selectedValue) {
	if (selectedValue == null) {
		selectedValue = "";
	}
	var listOption = createListOption(code, text, selectedValue);
	eval(listObject + ".add(listOption)");
}

function createListOption(code, text, selectedValue) {
	var listOption = document.createElement("OPTION");
	listOption.text = text;
	listOption.value = code;
	if (code == selectedValue) {
		listOption.selected = true;
	}
	return listOption;
}

function assignBean(frmObject) {
	bean_id = frmObject.bean_id.value;
	bean_name = frmObject.bean_name.value;
	xmlDom ="";
	xmlHttp = new XMLHttpRequest();
}

function getXMLString(arrayObject) {
	xmlStr = "<root><SEARCH ";
	if (arrayObject != null) {
		for (index = 0; index < arrayObject.length; index++) {
			xmlStr += arrayObject[index].name + "=\"" + arrayObject[index].value + "\" ";
		}
	}
	xmlStr += " /></root>";
	return xmlStr;
}

 function generateRow(obj,num) {
	var Gen_Name_Limit_From_index = eval("document.FormConstituentPresLimitAddmodify.Gen_Name_Limit_From_"+num).selectedIndex;
	var Gen_Name_Limit_From = eval("document.FormConstituentPresLimitAddmodify.Gen_Name_Limit_From_"+num).options(Gen_Name_Limit_From_index).text;
	var Gen_Name_Limit_From_value = eval("document.FormConstituentPresLimitAddmodify.Gen_Name_Limit_From_"+num).options(Gen_Name_Limit_From_index).value;
	var Gen_Name_Limit_To_index = eval("document.FormConstituentPresLimitAddmodify.Gen_Name_Limit_To_"+num).selectedIndex;
	var Gen_Name_Limit_To = eval("document.FormConstituentPresLimitAddmodify.Gen_Name_Limit_To_"+num).options(Gen_Name_Limit_To_index).text;
	var Gen_Name_Limit_To_value = eval("document.FormConstituentPresLimitAddmodify.Gen_Name_Limit_To_"+num).options(Gen_Name_Limit_To_index).value;
	var Mol_Name_From_index = eval("document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+num).selectedIndex;
	var Mol_Name_From = eval("document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+num).options(Mol_Name_From_index).text;
	var Mol_Name_From_value = eval("document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+num).options(Mol_Name_From_index).value;
	var Mol_Name_To_index = eval("document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+num).selectedIndex;
	var Mol_Name_To = eval("document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+num).options(Mol_Name_To_index).text;
	var Mol_Name_To_value = eval("document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+num).options(Mol_Name_To_index).value;
	//var Con_ConCen_From_Min = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_Min_"+num).value;
	var Con_ConCen_From_Min = "";
	//var Con_ConCen_From_Max = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_Max_"+num).value;
	var Con_ConCen_From_Max = "";
	//var Con_ConCen_To_Min = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_Min_"+num).value;
	var Con_ConCen_To_Min = "";
	//var Con_ConCen_To_Max = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_Max_"+num).value;
	var Con_ConCen_To_Max = "";
	var Con_ConCen_From_UOM = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_"+num).value;
	var Con_ConCen_From_UOM_index = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_"+num).selectedIndex;
	var Con_ConCen_From_UOM_txt = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_"+num).options(Con_ConCen_From_UOM_index).text;
	
	var Con_ConCen_To_UOM = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_"+num).value;
	var Con_ConCen_From_UOM_Conv = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_Conv_"+num).value;
	var Con_ConCen_To_UOM_Conv = eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_Conv_"+num).value;
	var precipitation_indicator_index = eval("document.FormConstituentPresLimitAddmodify.precipitation_indicator_"+num).selectedIndex;
	var precipitation_indicator = eval("document.FormConstituentPresLimitAddmodify.precipitation_indicator_"+num).options(precipitation_indicator_index).text;
	//var precipitation_indicator_value ='W';
	var chkFlaf1='F';
	var chkFlaf2='T';

	var precipitation_alert_msg = eval("document.FormConstituentPresLimitAddmodify.precipitation_alert_msg_"+num).value;
	var Con_Alert_YN = eval("document.FormConstituentPresLimitAddmodify.Con_Alert_YN_"+num).value;
	var count = document.FormConstituentPresLimitAddmodify.cnt.value;
	document.FormConstituentPresLimitAddmodify.cnt.value=Number(document.FormConstituentPresLimitAddmodify.cnt.value)+1;
	count=parseInt(count);
	  var tbl = document.getElementById('ConstPrescLimit');
	  var cnt1=1;
	  var cnt=cnt1;
 /* for(cal=1;cal<cnt;cal++)
  {
	if(eval("document.AltDisplocnDeatil.select_"+cal)==null)
	 {
		cnt=cal;
	 }
  }*/
//  alert("cnt"+cnt);
  //  var lastRow = tbl.rows.length;
  // creates a new row
  //alert(checkForNewRow(num));
  var rwid=getSelectedRowId(obj)+1;
  var row = tbl.insertRow(rwid);
  var oCell = row.insertCell(0);
  var classvalue;		  
   
  if (Number(cnt)%2 == 0)
	 classvalue = "QRYEVEN" ;
  else
	 classvalue = "QRYODD" ;

//var d=document.getElementById('div'+num+'1');
//oCell.innerHTML+="<TR>"
oCell.className=classvalue;
oCell.innerHTML="<td ><SELECT name='Gen_Name_Limit_From_"+count+"' id='Gen_Name_Limit_From_"+count+"' ><OPTION value='"+Gen_Name_Limit_From_value+"'>"+Gen_Name_Limit_From+"</option></select></td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

//d=document.getElementById('div'+num+'2');
//d.innerHTML+="<TR>"
oCell = row.insertCell(1);
oCell.align="center"
oCell.className=classvalue;
oCell.innerHTML="<td  ><SELECT name='Mol_Name_From_"+count+"' id='Mol_Name_From_"+count+"' ><OPTION value='"+Mol_Name_From_value+"'>"+Mol_Name_From+"</option></select></td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

oCell = row.insertCell(2);
oCell.align="center"
oCell.className=classvalue;
//d=document.getElementById('div'+num+'3');
//d.innerHTML+="<TR>"
oCell.innerHTML="<td ><SELECT name='Gen_Name_Limit_To_"+count+"' id='Gen_Name_Limit_To_"+count+"' ><OPTION value='"+Gen_Name_Limit_To_value+"'>"+Gen_Name_Limit_To+"</option></select></td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

oCell = row.insertCell(3);
oCell.align="center"
oCell.className=classvalue;
//d=document.getElementById('div'+num+'3');
//d.innerHTML+="<TR>"
oCell.innerHTML="<td ><SELECT name='Mol_Name_To_"+count+"' id='Mol_Name_To_"+count+"' ><OPTION value='"+Mol_Name_To_value+"'>"+Mol_Name_To+"</option></select></td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

oCell = row.insertCell(4);
oCell.align="center"
oCell.className=classvalue;
//d=document.getElementById('div'+num+'3');
//d.innerHTML+="<TR>"
oCell.innerHTML="<td><input type='text' name='Con_ConCen_From_Min_"+count+"' id='Con_ConCen_From_Min_"+count+"' maxlength='8' size='4' value='"+Con_ConCen_From_Min+"' onKeyPress='return allowValidNumber(this,event,5,2);' onBlur=\"checkRange(Con_ConCen_From_Min_"+count+",Con_ConCen_From_Max_"+count+");validateOverlapRange("+count+",'F',Con_ConCen_From_UOM_"+count+");chkOverLap(Con_ConCen_From_Min_"+count+",Con_ConCen_From_Max_"+count+","+count+",'F',Con_ConCen_From_UOM_"+count+");\">-<input type='text' name='Con_ConCen_From_Max_"+count+"' id='Con_ConCen_From_Max_"+count+"' maxlength='8' size='4' value='"+Con_ConCen_From_Max+"' onKeyPress='return allowValidNumber(this,event,5,2);' onBlur=\"checkRange(Con_ConCen_From_Min_"+count+",Con_ConCen_From_Max_"+count+");validateOverlapRange("+count+",'F',Con_ConCen_From_UOM_"+count+");chkOverLap(Con_ConCen_From_Min_"+count+",Con_ConCen_From_Max_"+count+","+count+",'F',Con_ConCen_From_UOM_"+count+");\">&nbsp;<input type='text' name='Con_ConCen_From_UOM_txt_"+count+"' id='Con_ConCen_From_UOM_txt_"+count+"' size='3' value='"+Con_ConCen_From_UOM_txt+"' readonly>    <input type='text' name='Con_ConCen_From_UOM_Conv_"+count+"' id='Con_ConCen_From_UOM_Conv_"+count+"' size='6' value='"+Con_ConCen_From_UOM_Conv+"' readonly><INPUT TYPE='hidden' name='Con_ConCen_From_UOM_"+count+"' id='Con_ConCen_From_UOM_"+count+"' VALUE='"+Con_ConCen_From_UOM+"'></td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

oCell = row.insertCell(5);
oCell.align="center"
oCell.className=classvalue;
//d=document.getElementById('div'+num+'3');
//d.innerHTML+="<TR>"
oCell.innerHTML="<td><input type='text' name='Con_ConCen_To_Min_"+count+"' id='Con_ConCen_To_Min_"+count+"' maxlength='8' size='4' value='"+Con_ConCen_To_Min+"' onKeyPress='return allowValidNumber(this,event,5,2);' onBlur=\"checkRange(Con_ConCen_To_Min_"+count+",Con_ConCen_To_Max_"+count+");validateOverlapRange("+count+",'T',Con_ConCen_From_UOM_"+count+");chkOverLap(Con_ConCen_To_Min_"+count+",Con_ConCen_To_Max_"+count+","+count+",'T',Con_ConCen_From_UOM_"+count+");\">-<input type='text' name='Con_ConCen_To_Max_"+count+"' id='Con_ConCen_To_Max_"+count+"' maxlength='8' size='4' value='"+Con_ConCen_To_Max+"' onKeyPress='return allowValidNumber(this,event,5,2);' onBlur=\"checkRange(Con_ConCen_To_Min_"+count+",Con_ConCen_To_Max_"+count+");validateOverlapRange("+count+",'T',Con_ConCen_From_UOM_"+count+");chkOverLap(Con_ConCen_To_Min_"+count+",Con_ConCen_To_Max_"+count+","+count+",'T',Con_ConCen_From_UOM_"+count+");\">&nbsp;<input type='text' name='Con_ConCen_To_UOM_"+count+"' id='Con_ConCen_To_UOM_"+count+"' size='3' value='"+Con_ConCen_From_UOM_txt+"' readonly>    <input type='text' name='Con_ConCen_To_UOM_Conv_"+count+"' id='Con_ConCen_To_UOM_Conv_"+count+"' size='6' value='"+Con_ConCen_To_UOM_Conv+"' readonly></td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

oCell = row.insertCell(6);
oCell.align="center"
oCell.className=classvalue;
//d=document.getElementById('div'+num+'3');
//d.innerHTML+="<TR>"
oCell.innerHTML="<td ><SELECT name='precipitation_indicator_"+count+"' id='precipitation_indicator_"+count+"' ><OPTION value='W'>Warning</option><OPTION value='E'>Error</option><OPTION value='N'>Information</option></select></td>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

oCell = row.insertCell(7);
oCell.align="center"
oCell.className=classvalue;
//d=document.getElementById('div'+num+'3');
//d.innerHTML+="<TR>"
oCell.innerHTML="<input type='text' name='precipitation_alert_msg_"+count+"' id='precipitation_alert_msg_"+count+"' maxlength='300' size='80' value='"+precipitation_alert_msg+"'>";
//d.innerHTML+="</TR>"
//d.innerHTML+="<BR>"

oCell = row.insertCell(8);
oCell.align="center"
oCell.className=classvalue;
oCell.innerHTML="<td align='center' class='"+classvalue+"' width='2%' ><input type='checkbox' name='Con_Alert_YN_"+count+"' id='Con_Alert_YN_"+count+"' value='E' onChange='changeValue(this);' checked><input type='button' class='button' name=rem_"+count+" onClick='removeRow(this);' value='X ' > </td>";
//<input type='button' name='rem' id='rem'    onClick='removeRow("+rwid+")' value='---' >



}


  function removeRow(obj)
{

   // grab the element again!
    var tbl = document.getElementById('ConstPrescLimit');
    var n=getSelectedRowId(obj);

	tbl.deleteRow(n);
	document.FormConstituentPresLimitAddmodify.cnt.value=Number(document.FormConstituentPresLimitAddmodify.cnt.value)-1;
	//UpdateCount(n,'M');
}

function getSelectedRowId(row)
{
  return  row.parentNode.parentNode.rowIndex
}


  

 
 

 function changeValue(chkObj)
 {
	 if(chkObj.checked==true)
	 {
		chkObj.checked=true;
	    chkObj.value='E';
	 }else
	 {
		chkObj.checked=false;
	    chkObj.value='D';
	 }
 }
function Modify(obj) {

		mode=2;
		var const_from_code=obj.cells[1].innerText;
		var mol_from_code=obj.cells[2].innerText;
		var const_to_code=obj.cells[3].innerText;
		var mol_to_code=obj.cells[4].innerText;
		var const_presc_limit_alert=obj.cells[5].innerText;
		var seq_no=obj.cells[6].value;
		
		var func_name = '';
		parent.location.href="../../ePH/jsp/ConstituentPrecipitationLimitFrames.jsp?mode="+mode+"&const_from_code="+const_from_code+"&mol_from_code="+mol_from_code+"&const_to_code="+const_to_code+"&mol_to_code="+mol_to_code+"&const_presc_limit_alert="+const_presc_limit_alert+"&func_name=QUERY&seq_no="+seq_no;
	//	document.location.href="../../ePH/jsp/ConstituentPrecipitationLimitAddModify.jsp?mode="+mode ;
	//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
}

function iconEnable(obj,num)
{
if(obj.value!='')
eval("document.FormConstituentPresLimitAddmodify.addRow_"+num).disabled=false;
else
eval("document.FormConstituentPresLimitAddmodify.addRow_"+num).disabled=true;
		
}



function checkRange(min,max){

	
	var obj1=parseInt(min.value);
    var obj2=parseInt(max.value);

if(obj1 > obj2)
 {
	//alert("Greater");
	alert(getMessage("PH_MIN_GREATER_MAX","PH"));
    min.focus();
	min.value='';
	return false;
 }
}

function enableRow(obj,cnt)
{
	
	eval("document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt).disabled=false;
	eval("document.FormConstituentPresLimitAddmodify.Gen_Name_Limit_To_"+cnt).disabled=false;

}
function CheckPositiveNumber1(obj){
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.select();
            obj.focus();
			return false
        }
        else if ( obj.value.length == 0 )
            obj.value = "";
    }
	return true;
}

function validateOverlapRange(num,chkFlag,uom) {
	
	
		var bean_id 	= document.FormConstituentPresLimitAddmodify.bean_id.value ;
		var bean_name 	= document.FormConstituentPresLimitAddmodify.bean_name.value ;
		var Con_ConCen_Min="";
		var Con_ConCen_Max="";
		var uom=uom.value;
	
		if(chkFlag=='F')
		{
		Con_ConCen_Min	= trimString(eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_Min_"+num).value);
		Con_ConCen_Max	= trimString(eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_Max_"+num).value);
		}else
		{
		Con_ConCen_Min	= trimString(eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_Min_"+num).value);
		Con_ConCen_Max	= trimString(eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_Max_"+num).value);

		}
		
		var Gen_Name_Limit_From	= trimString(eval("document.FormConstituentPresLimitAddmodify.Gen_Name_Limit_From_"+num).value);
		var Gen_Name_Limit_To	= trimString(eval("document.FormConstituentPresLimitAddmodify.Gen_Name_Limit_To_"+num).value);
		

	assignBean(document.FormConstituentPresLimitAddmodify);
	var arrayObject = new Array();
	xmlStr = getXMLString(arrayObject);
	xmlDom.loadXML(xmlStr);
	xmlHttp.open("POST", "../../ePH/jsp/ConstituentPrecipitationLimitValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CONST_GENRIC_RANGE&Con_ConCen_Min="+Con_ConCen_Min+"&Con_ConCen_Max="+Con_ConCen_Max+"&chkFlag="+chkFlag+"&num="+num+"&Gen_Name_Limit_From="+Gen_Name_Limit_From+"&Gen_Name_Limit_To="+Gen_Name_Limit_To+"&uom="+uom, false);
	xmlHttp.send(xmlDom);
	responseText = xmlHttp.responseText;
	eval(responseText);
	}

	function callInfo(cnt,chkFlag)
	{
	  
		   if(chkFlag=='F')
			{
			eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_Min_"+cnt).value="";
			eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_Max_"+cnt).value="";
			alert(getMessage("CON_RANGE_OVERLAP", "PH"));

        	}else
			{
			eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_Min_"+cnt).value="";
			eval("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_Max_"+cnt).value="";
			alert(getMessage("CON_RANGE_OVERLAP", "PH"));
      
			}
	}


	function chkOverLap(From,To,num,chkFlag,uom)
	{
		
	var frmobj=document.forms[0];
	var cnt = parseInt(frmobj.cnt.value);
	var from = parseFloat(From.value);
	var to = parseFloat(To.value);
	var uom =uom.value;


	var rangeMin = new Array(); 
	var rangeMax = new Array(); 
	var rangeUom = new Array(); 
	var range_flag = new Array(false,false,false,false); 

	//if(cnt==7)
	//cnt=cnt;
	//else
	//cnt=cnt+1;
	
	
	for(var frmCount=0; frmCount<cnt; frmCount++)
		{

		
		if(chkFlag=='F')
			{
			rangeMin[frmCount] = new Array(eval("frmobj.Con_ConCen_From_Min_"+frmCount).value);
			rangeMax[frmCount] = new Array(eval("frmobj.Con_ConCen_From_Max_"+frmCount).value);
			rangeUom[frmCount] = new Array(eval("frmobj.Con_ConCen_From_UOM_"+frmCount).value);
			}else
			{
			rangeMin[frmCount] = new Array(eval("frmobj.Con_ConCen_To_Min_"+frmCount).value);
			rangeMax[frmCount] = new Array(eval("frmobj.Con_ConCen_To_Max_"+frmCount).value);
			rangeUom[frmCount] = new Array(eval("frmobj.Con_ConCen_From_UOM_"+frmCount).value);
			}
		
		}

	for(var frmCount=0; frmCount<cnt; frmCount++)
		{
		if(frmCount != num)
			{
				range_flag[0] = getChk_range(parseFloat(rangeMin[frmCount]),parseFloat(rangeMax[frmCount]),from,uom,rangeUom[frmCount]);
				range_flag[1] = getChk_range(parseFloat(rangeMin[frmCount]),parseFloat(rangeMax[frmCount]),to,uom,rangeUom[frmCount]);
				range_flag[2] = getChk_range(from,to,parseFloat(rangeMin[frmCount]),uom,rangeUom[frmCount]);
				range_flag[3] = getChk_range(from,to,parseFloat(rangeMax[frmCount]),uom,rangeUom[frmCount]);

	
			if(range_flag[0]==true||range_flag[1] ==true ||range_flag[2]== true||range_flag[3]==true)
				{
				callInfo(num,chkFlag);
				return false;
				}

			}
		}



		
	}

	function getChk_range(list_from,list_to,no,uomOld,uomNew){


		if(no >= list_from && no <= list_to && uomOld==uomNew )
		{
			//alert(" true "+list_from+"---"+list_to+"---"+no+"---"+uomOld+"---"+uomNew)
			return true;
		}
		else
		{
			//alert(" false "+list_from+"---"+list_to+"---"+no+"---"+uomOld+"---"+uomNew)
			return false;
		}
	}

