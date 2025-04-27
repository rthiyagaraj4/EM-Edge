  var bean_id = "";
var bean_name = "";
var formObj="";

function searchDrugCode(obj){
	//alert("the drug code"+obj);
	var formObj=document.frames.PhDispDrugBatchDetails;
	var arrDrug = DrugSearch("D",obj);	
	if (arrDrug != ""){
		formObj.p_drug_code.value = arrDrug[0];
		formObj.drug_desc.value = arrDrug[1];
		formObj.drug_desc.readOnly=true;
		populateTradeName(formObj.p_drug_code.value);

		replaceSpecialChar(formObj.drug_desc.value);
	}
}
function run() {

	var frmObject = f_query_add_mod.document.PhDispDrugBatchDetails;
	if(f_query_add_mod.document.PhDispDrugBatchDetails)
	{
		var fields= new Array (frmObject.p_drug_code,frmObject.p_fm_date1,frmObject.p_to_date1);
		var names= new Array (getLabel("Common.DrugName.label","Common"),getLabel("ePH.DispensedDateFrom.label","PH"),getLabel("ePH.DispensedDateTo.label","PH"));
		var ref=parent.parent.frames[2];
		
		var msgFrame= frames[2];
		if(checkFields(fields,names,msgFrame) ) 
		{      

			var p_fm_date="";
			var p_to_date="";
			
		   	p_fm_date=frmObject.p_fm_date1.value;
			//alert("p_fm_date--->"+p_fm_date);
		    frmObject.p_fm_date.value = convertDate(frmObject.p_fm_date1.value,'DMY',frmObject.p_language_id.value,"en");
		   	p_to_date=frmObject.p_to_date1.value;
			//alert("p_to_date--->"+p_to_date);
			frmObject.p_to_date.value = convertDate(frmObject.p_to_date1.value,'DMY',frmObject.p_language_id.value,"en");
			if(parent.doDateCheck(frmObject.p_fm_date1,frmObject.p_to_date1,msgFrame)) 
			{
			frmObject.submit();

			}
			else
			{

				//alert("Should be Less than To Date Time");
				f_query_add_mod.document.PhDispDrugBatchDetails.p_fm_date1.select;
			}

		}

	}
}

function reset() {
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	f_query_add_mod.location.reload();
	//f_query_add_mod.PhDispDrugBatchDetails.drug_desc.readOnly=false;
	//f_query_add_mod.PhDispDrugBatchDetails.drug_desc.focus();
}



function clearList()	{
	var len	= document.PhDispDrugBatchDetails.p_trade_id.options.length;
	for(var i=0;i<len;i++) {
		document.PhDispDrugBatchDetails.p_trade_id.remove(0) ;
	}

	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---" ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.PhDispDrugBatchDetails.p_trade_id.add(opt);
	return;
}

function populateTradeName(drug_code)
{
	bean_id		=	document.PhDispDrugBatchDetails.bean_id.value;
	bean_name	=	document.PhDispDrugBatchDetails.bean_name.value;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

        var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " drug_code=\""+drug_code+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhDispDrugBatchDetailsValidate.jsp",false);
	xmlHttp.send(xmlDoc);

	eval(xmlHttp.responseText);
	return;
}

function addList(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.PhDispDrugBatchDetails.p_trade_id.add(element);
}

function replaceSpecialChar(values) {
//	alert("values"+values);
	var formObj=document.frames.PhDispDrugBatchDetails;
	var strCheck = new Array("@", "!", "~" ,"#" ,"$" ,"%" ,"^" ,"*" ,"(" ,")" ,"_" ,"-" ,"+" ,"=" ,"`" ,"?" ,";" ,":" ,"'","<" ,">","/","\\","|","{","]","[","}" ,".");
	var lenValue  = strCheck.length;
	for(var i=0;i<lenValue;i++){
		while(values.indexOf(strCheck[i]) != -1 ){
			while(values.indexOf(strCheck[i]) != -1){
			values = values.replace(strCheck[i],"");
			formObj.drug_desc.value=values;
			}
			i++;
		}
	}
	return values;
}
//Coding for  handling patieng Age:
/*function checkSeqNo(obj)
	{ alert("klxm");
		var str		=	obj.value;
		if((parseInt(str)<0)||((str.charAt(0)=="0")&&(str.length==1))||(str=="000")||(str=="00"))
		{
			var fieldname	=	 getLabel("Common.SequenceNo.label","Common");
			alert(getMessage("ZERO_NOT_ALLOWED","PH")+""+fieldname);
			
			obj.value		=	"";
			obj.focus();
		}

	}*/
	function CheckForSequence(event)
	{	//alert("inside sequence event");
	    var strCheck = '1234567890';
	    var whichCode = (window.Event) ? event.which : event.keyCode;
	    key = String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	
	    return true ;
	}
	function ChkSplChars(obj)
{
	var str=obj.value;
	
	var chk="1234567890";
	for(var i=0; i<str.length; i++)
	{
		
		  if (chk.indexOf(str.charAt(i)) == -1) 
			{
				  alert(getMessage("INVALID_NUMBER_FORMAT", "PH"));
				  obj.select();
				  obj.focus();
				  return;
			}
	}
}
