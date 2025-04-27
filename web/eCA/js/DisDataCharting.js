/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
14/02/2013  IN036756		ChowminyaG   Record Vital Signs->Defined Discrete Measure Components are not displayed 
03/06/2014	IN037701		Chowminya	 SKR-CRF-0036
---------------------------------------------------------------------------------------------------------------
*/

function onsuccess(){
		var qs = parent.toolsFrame.document.forms[0].query_string.value;
		parent.location.href = '../eCA/jsp/DisDataCharting.jsp?'+qs;
		top.content.messageFrame.location.href='../eCommon/jsp/error.jsp';
}

function amend(){
		var qs = parent.toolsFrame.document.forms[0].query_string.value;
		qs=qs+'&amendMode=Y';
		top.content.workAreaFrame.location.href = '../../eCA/jsp/DisDataCharting.jsp?'+qs
}

function replace(){
		var qs = parent.toolsFrame.document.forms[0].query_string.value;
		qs=qs+'&replaceMode=Y';
		top.content.workAreaFrame.location.href = '../../eCA/jsp/DisDataCharting.jsp?'+qs
}

async function showErrorList(){
		var patient_id=document.forms[0].patient_id.value;
		var retVal;
		var dialogHeight ='20';
		var dialogWidth = '50';
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
		retVal 			= await window.showModalDialog('../../eCA/jsp/DisDataViewErrorList.jsp?patient_id='+patient_id,arguments,features);	
}

function showCalendarValidate(str){
		var flg = showCalendar(str);
		document.getElementById(str).focus();
		return flg;
}

function callGo(){
	//alert("callGo")
		var date=document.forms[0].date.value;
		var patient_id=document.forms[0].patient_id.value;
		//top.content.messageFrame.document.href="../../eCommon/jsp/error.jsp";
		var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eCA/jsp/DisDataChartDateIncrement.jsp'><input type='hidden' name='flag' id='flag' value='go'><input type='hidden' name='date' id='date' value='"+date+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'></form></BODY></HTML>";
		top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		top.content.messageFrame.document.form1.submit();
}

async function checkAll(obj){
	if(obj.checked){
			var check='n';
			for(i=0;i<(top.content.workAreaFrame.addModifyFrame.document.getElementById("detailTab").rows.length-2);i++){
				temp=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].errorChk"+i);
				if(temp.disabled==false){
					check='y';
					temp.checked=true;
				}
			}
		var comments;
		var retVal;
		var dialogHeight ='7' ;
		var dialogWidth = '30' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		if(check=='y')	{
			retVal 			= await window.showModalDialog('../../eCA/jsp/RemarksDialog.jsp',arguments,features);
		}
		if(retVal!=null){
			for(i=0;i<(top.content.workAreaFrame.addModifyFrame.document.getElementById("detailTab").rows.length-2);i++){
					var rem=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].remarks"+i);
					var temp=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].errorChk"+i);
					var flag=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].flag"+i);
					var id=eval("top.content.workAreaFrame.addModifyFrame.document.getElementById('remID'"+i+")");
					if(temp.disabled==false && flag.value!='Y'){
						rem.value=retVal;
						flag.value='Y';
						id.innerHTML="<a href='javascript:showRemarks(\""+retVal+"\",\"n\",\""+i+"\")' ><b>!</b></a>";
					}
			}
		}
		else //if he presses the close button on comment dialog then uncheck all checked
		{
			for(i=0;i<(top.content.workAreaFrame.addModifyFrame.document.getElementById("detailTab").rows.length-2);i++)	{
				var temp=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].errorChk"+i);
				var flag=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].flag"+i);
				//var id=eval("document.getElementById("remID")"+i);
				if(temp.disabled==false && flag.value!='Y')
					temp.checked=false;
			}
			obj.checked=false;
		}
	}else{
		for(i=0;i<(top.content.workAreaFrame.addModifyFrame.document.getElementById("detailTab").rows.length-2);i++)	{
			var temp=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].errorChk"+i);
			var flag=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].flag"+i);
			var rem=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].remarks"+i);
			var id=eval("top.content.workAreaFrame.addModifyFrame.document.getElementById('remID'"+i+")");
			if(temp.disabled==false){
				temp.checked=false;
				rem.value="";
				flag.value='N';
				id.innerHTML="";
			}
		}
	}
}


async function showRemarks(value,disabled,count){
	var rem=eval("document.forms[0].remarks"+count);
	var id=document.getElementById('remID'+count);
	var dialogHeight ='7' ;
	var dialogWidth = '30' ;
	if (disabled==null){
		disabled='y';
	}
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	retVal 			=await window.showModalDialog('../../eCA/jsp/RemarksDialog.jsp?resultStr='+value+'&disabled='+disabled,arguments,features);
	if(retVal!=null){
		rem.value=retVal;
		id.innerHTML="<a href='javascript:showRemarks(\""+retVal+"\",\"n\",\""+count+"\")' ><b>!</b></a>";
	}
}

function validateNumber(obj,lowlevel,highlevel,rownumber,numdigitsdec,critlow,crithigh,mindigits,module_id,shortdesc,minValue,maxValue)
{
	var val = obj.value;
    var normabnormind = '';
	var normabnorminddesc = '';
	chkval = 10;
	
	if (val != null && val != '')
	{
		if(eval(mindigits) != 0)
		{
			var arr =  new Array();
			arr = val.split(".");
			var num = "";
			var frac = "";
			if(val.indexOf(".") >= 0)
			{
				num = arr[0].length;
				frac = arr[1].length;
			}
			else
				var num = arr[0].length;
			if((num < eval(mindigits)))  
			{ 
				var msg = getMessage("MIN_DIGITS_COMP","CA");
				msg=msg.replace("$$",shortdesc);
				msg=msg.replace("##",mindigits);
				alert(msg);
				obj.value="";
				obj.focus();
				return;
			}
		}
		if(minValue!=0 && maxValue!=0)
		{
			if(parseFloat(val) < minValue || parseFloat(val) > maxValue)
			{	
				var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
				msg =msg.replace('(1)',minValue);
				msg =msg.replace('(2)',maxValue);
				alert(msg);
				obj.value="";
				obj.focus();
				return;
			} 
		}
		else if(minValue!=0)
		{
			if(parseFloat(val) < minValue)
			{	
				var msg = getMessage("MIN_VAL_GRT_OR_EQL_TO","OR");
				msg =msg+" "+minValue;
				alert(msg);
				obj.value="";
				obj.focus();
				return;
			} 
		}
		else if(minValue==0 && maxValue!=0)
		{
		   if(parseFloat(val) < 0 || parseFloat(val) > maxValue)
		   {	
				var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
				msg =msg.replace('(1)',"0");
				msg =msg.replace('(2)',maxValue);
				alert(msg);
				obj.value=""
				obj.focus();
				return;
			} 
		}
		
		if(!CheckForNumber(val))
		{
			obj.value="";
			obj.focus();
		}
		else
		{
			var n = obj.value;

			if((n.indexOf(".")) >= 0)
			{
				if(numdigitsdec !=0)
				{	
					var arr =  new Array();
					arr = n.split(".");
					var num = arr[0].length;
					var frac = arr[1].length;
					
					if (frac > numdigitsdec )
					{
						alert(getMessage("INVALID_PRECISION","CA"));
						obj.value="";
						obj.focus();
					}
				}
				else
				{
					alert(getMessage("NO_DECIMAL","CA"));
					obj.value="";
					obj.focus();
				}
			}

			var lowstr = "";
			var highstr = "";
			var critlowstr = "";		
			var crithighstr = "";
			if(module_id !="")
			{
				lowstr = parent.addModifyFrame.document.forms[0].low_str.value;
				highstr = parent.addModifyFrame.document.forms[0].high_str.value;
				critlowstr = parent.addModifyFrame.document.forms[0].crit_low_str.value;
				crithighstr = parent.addModifyFrame.document.forms[0].crit_high_str.value;
            }
			else
			{
				lowstr = top.content.workAreaFrame.addModifyFrame.document.forms[0].low_str.value;
				highstr = top.content.workAreaFrame.addModifyFrame.document.forms[0].high_str.value;
				critlowstr = top.content.workAreaFrame.addModifyFrame.document.forms[0].crit_low_str.value;
				crithighstr = top.content.workAreaFrame.addModifyFrame.document.forms[0].crit_high_str.value;
			}

			if((lowlevel != '' && parseFloat(lowlevel) != 0) && (highlevel != '' &&  parseFloat(highlevel) != 0)   && (critlow != '' && parseFloat(critlow) != 0) &&  (crithigh != 0 && parseFloat(crithigh) != ''))
			{
				if(parseFloat(val) >= parseFloat(critlow) && parseFloat(val) < parseFloat(lowlevel))
					normabnormind = lowstr;
				else if(parseFloat(val) > parseFloat(crithigh))
					normabnormind = crithighstr;
				else if(parseFloat(val) < parseFloat(critlow))
					normabnormind = critlowstr;
				else if(parseFloat(val) > parseFloat(highlevel) && parseFloat(val) <= parseFloat(crithigh))
					normabnormind = highstr;
			}
			else
			{
				if((lowlevel != '' && parseFloat(lowlevel) != 0))
				{
					if((critlow != '' && parseFloat(critlow) != 0))
					{
						if(parseFloat(val) < parseFloat(critlow)) 
							normabnormind = critlowstr;
						else if((parseFloat(val) >= parseFloat(critlow)) && (parseFloat(val) < parseFloat(lowlevel))) 
							normabnormind = lowstr;
					}
					else if(parseFloat(val) < parseFloat(lowlevel)) 
						normabnormind = lowstr;
				}

				if((highlevel != '' &&  parseFloat(highlevel) != 0))
				{
					if((crithigh != '' && parseFloat(crithigh) != 0))
					{
						if(parseFloat(val) > parseFloat(crithigh)) 
							normabnormind = crithighstr;
						else if((parseFloat(val) <= parseFloat(crithigh)) && (parseFloat(val) > parseFloat(highlevel))) 
							normabnormind = highstr;
					}
					else if(parseFloat(val) > parseFloat(highlevel)) 
						normabnormind = highstr;
				}
			}

			if(module_id !="")
			{
				parent.addModifyFrame.document.getElementById('nor_'+rownumber).innerText = normabnormind;
				parent.addModifyFrame.document.getElementById('norm_abnorm_ind_'+rownumber).value = normabnormind;
			}
			else
			{
				top.content.workAreaFrame.addModifyFrame.document.getElementById('nor_'+rownumber).innerText = normabnormind;
				top.content.workAreaFrame.addModifyFrame.document.getElementById('norm_abnorm_ind_'+rownumber).value = normabnormind;
			}
		}
	}
	else
	{
		normabnormind = '';
		normabnorminddesc = '';
		if(module_id !="")
		{
			parent.addModifyFrame.document.getElementById('nor_'+rownumber).innerText = normabnormind;
			parent.addModifyFrame.document.getElementById('norm_abnorm_ind_'+rownumber).value = normabnormind;
		}
		else
		{
			top.content.workAreaFrame.addModifyFrame.document.getElementById('nor_'+rownumber).innerText = normabnormind;
			top.content.workAreaFrame.addModifyFrame.document.getElementById('norm_abnorm_ind_'+rownumber).value = normabnormind;
		}
		
	}
}

async function callRemarksBox(obj,count,disVar,var1)
{
if(var1!=undefined){
		var disableText=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].str_id1_"+var1);
		if (obj.checked==true){
			disableText.disabled=false;
		}else{
			disableText.disabled=true;
		}
}

//alert(count);
//alert(top.content.workAreaFrame.addModifyFrame.document.getElementById("detailTab").rows.cells.length);
//disVar this variable is used for displaying the heading in the ErrorRemarks modal window
	var rem=eval("document.forms[0].remarks"+count);
	var flag=eval("document.forms[0].flag"+count);
	var id=eval(document.getElementById("remID"+count));
	if(obj.checked){	
		var comments;
		var retVal;
		var dialogHeight ='7' ;
		var dialogWidth = '30' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		retVal 			= await window.showModalDialog('../../eCA/jsp/RemarksDialog.jsp?disVar='+disVar,arguments,features);
		
		if(retVal!=null){
			rem.value=retVal;
			flag.value='Y';
			id.innerHTML="<a href='javascript:showRemarks(\""+retVal+"\",\"n\",\""+count+"\")' ><b>!</b></a>";
		}else
			obj.checked=false;
	}else{
		rem.value='';
		flag.value='N';
		id.innerHTML="";
	}
}

function update(){
	//alert("update");
	var count = top.content.workAreaFrame.addModifyFrame.document.DisDataCharting_form.no_of_rec.value;
    var proceed = "T";
    for(var n=1;n<=count;n++)
    {
		var strval = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].str_id1_"+n);
		if (!(strval)) continue;
		 var mandatoryyn = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].mandatory_yn_"+n+".value");
        var strval = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].str_id1_"+n+".value");
		  var strobj = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].str_id1_"+n+"");
        var desc = eval("top.content.workAreaFrame.addModifyFrame.document.getElementById('short_desc_'"+n+").innerText");

//		alert('mandatoryyn ->'+mandatoryyn+'strval ->'+strval+'strobj ->'+strobj+'desc ->'+desc);
        if(mandatoryyn == 'Y' && strval == '')
        {
            var msg = getMessage('CAN_NOT_BE_BLANK','Common');
			msg =msg.replace('$',desc);
			alert(msg);
			//alert(desc+' cannot be null ... ');
            strobj.focus();
            proceed = "F";
            break;
        }
        else
            proceed = "T";
    }
	if(proceed == "T"){
//		top.content.workAreaFrame.toolsFrame.document.F.record.disabled	=	true;
        top.content.workAreaFrame.addModifyFrame.document.DisDataCharting_form.submit();
	}
}


function apply(module_id)
{
	
	var count = 0;
	var bat_id = "";
	if(module_id != ""){
		count = parent.addModifyFrame.document.DisDataCharting_form.no_of_rec.value;
		bat_id = parent.addModifyFrame.document.DisDataCharting_form.battery_id.value;
	}else{
		count = top.content.workAreaFrame.addModifyFrame.document.DisDataCharting_form.no_of_rec.value;
		bat_id = top.content.workAreaFrame.addModifyFrame.document.DisDataCharting_form.battery_id.value;	
	}
	
	var proceed = "T";
	var i=0;
	if(module_id != ""){
		for(var n=1;n<=count;n++)
		{
			if(eval("parent.addModifyFrame.document.forms[0].str_id_"+n))//IN036756
			{
				var mandatoryyn = eval("parent.addModifyFrame.document.forms[0].mandatory_yn_"+n+".value");
				
				
				var strval = eval("parent.addModifyFrame.document.forms[0].str_id_"+n+".value");
				if(strval=="" || strval=="null")
				{
				 i++;
				}
				var strobj = eval("parent.addModifyFrame.document.forms[0].str_id_"+n+"");
				var desc = parent.addModifyFrame.document.getElementById('short_desc_'+n).innerText;

				if(mandatoryyn == 'Y' && strval == '')
				{
					var msg = getMessage('CAN_NOT_BE_BLANK','Common');

					msg =msg.replace('$',desc);
					alert(msg);
					//alert(desc+' cannot be null ... ');
					strobj.focus();
					proceed = "F";
					break;
				}
				else
					proceed = "T";
			}//IN036756
		}
	}else{
		for(var n=1;n<=count;n++)
		{
			if(eval("parent.addModifyFrame.document.forms[0].str_id_"+n))//IN036756
			{
				var mandatoryyn = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].mandatory_yn_"+n+".value");
				var strval = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].str_id_"+n+".value");
				var strobj = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].str_id_"+n+"");
				var desc = eval("top.content.workAreaFrame.addModifyFrame.document.getElementById('short_desc_'"+n+").innerText");

		//		alert('mandatoryyn ->'+mandatoryyn+'strval ->'+strval+'strobj ->'+strobj+'desc ->'+desc);
				if(mandatoryyn == 'Y' && strval == '')
				{
					var msg = getMessage('CAN_NOT_BE_BLANK','Common');
					msg =msg.replace('$',desc);
					alert(msg);
					//alert(desc+' cannot be null ... ');
					strobj.focus();
					proceed = "F";
					break;
				}
				else
					proceed = "T";
			}	//IN036756
		}
	}

	/*if(bat_id != "" && count == 0)
	{
		alert(getCAMessage("NO_DISCR_MSR"));
		proceed = "";
	}
	else if(bat_id == "")
	{
		alert(getCAMessage("NO_BATTERY"));
		proceed = "";			
	}*/
	if(i==count)
		 alert(getMessage('ATLEAT_ONE_VITAL_DATA_REQ','CA'));
	else
	{

	if(proceed == "T"){
		if(module_id != ""){
			parent.toolsFrame.document.F.record.disabled	=	true;
		    parent.addModifyFrame.document.DisDataCharting_form.submit();
		}else{
			top.content.workAreaFrame.toolsFrame.document.F.record.disabled	=	true;
		    top.content.workAreaFrame.addModifyFrame.document.DisDataCharting_form.submit();
		}
	}
  }
}

function cancelform(module_id){

		if(module_id != ""){
				//parent.window.close();
			parent.parent.document.getElementById('dialog_tag').close();
	    }else{ 
				if (top.content.workAreaFrame.addModifyFrame.document.forms[0].in_error.value =="Y"  || top.content.workAreaFrame.addModifyFrame.document.forms[0].in_replace.value =="Y" ){
							var qs = top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value;
							var loc=qs.indexOf('&battey_id');
							var substr=qs.substr(loc);
							var qstring=qs.replace(substr,"");
							top.content.workAreaFrame.location.href='../../eCA/jsp/DisDataCharting.jsp?'+qstring;
				}else{
     					    top.content.workAreaFrame.location.href='../../eCommon/html/blank.html' ;
				}
		}
}

function cancelform1(module_id){

		if(module_id != ""){
				//parent.window.close();
			parent.parent.document.getElementById('dialog_tag').close();
	    }else{ 
							var qs = top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value;
							var loc=qs.indexOf('&battey_id');
							var substr=qs.substr(loc);
							var qstring=qs.replace(substr,"");
							top.content.workAreaFrame.location.href='../../eCA/jsp/DisDataCharting.jsp?'+qstring;
				}
}

function onSuccess(){
    var qs = top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value;
    top.content.workAreaFrame.location.href = '../../eCA/jsp/DisDataCharting.jsp?'+qs
}

function resetForm(module_id)
{
	if(module_id != ""){
		if(parent.toolsFrame.document.forms[0].query_string.value){
		   var qs = parent.toolsFrame.document.forms[0].query_string.value;
			parent.addModifyFrame.location.href = '../../eCA/jsp/DisDataChartingRecord.jsp?'+qs;
		}
	}else{

		if( top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value){
		   var qs = top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value;
			top.content.workAreaFrame.addModifyFrame.location.href = '../../eCA/jsp/DisDataChartingRecord.jsp?'+qs;
		}
	}
}

function validateDateTime(obj,val){
    if(obj.value != ''){
        if(val == 'E'){
            if(!doDateTimeChk(obj)){
                alert(getMessage('INVALID_DATE_TIME','CA'));
				//obj.select();
              //  obj.focus();
                obj.value="";
            }
        }
        else if(val == 'D'){
            if(CheckDate(obj)){}
        }
        else if(val == 'T')
        {
            if(!chkTime(obj.value))
            {
                alert(getMessage('INVALID_TIME_FMT','CA'));
				//obj.select();
               // obj.focus();
                obj.value="";
            }
        }
    }
}

function chkNormalAbnormal(obj,row)
{
	if(top.content != null)
	{
		var abnstr = document.getElementById('abn_str').value;
	    var critabnstr = document.getElementById('crit_abn_str').value;
	}
	else
	{
		var abnstr = parent.addModifyFrame.document.forms[0].abn_str.value;
	    var critabnstr = parent.addModifyFrame.document.forms[0].crit_abn_str.value;
	}
    if(obj.options[obj.options.selectedIndex].className == 'A')
    {
		if(top.content != null)
		{
		    eval("top.content.workAreaFrame.addModifyFrame.document.getElementById('nor_'"+row+").innerText = '"+abnstr+"'")
			eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].norm_abnorm_ind_"+row+").value = " + abnstr);
		}
		else
		{
			 eval("parent.addModifyFrame.document.getElementById('nor_'"+row+").innerText = '"+abnstr+"'")
			eval("parent.addModifyFrame.document.forms[0].norm_abnorm_ind_"+row).value = abnstr;
		}
    }
    else if(obj.options[obj.options.selectedIndex].className == 'C')
    {
		if(top.content != null)
		{
			eval("top.content.workAreaFrame.addModifyFrame.document.getElementById('nor_'"+row+").innerText = '"+critabnstr+"'")
	        eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].norm_abnorm_ind_"+row).value = critabnstr;
		}
		else
		{
			eval("parent.addModifyFrame.document.getElementById('nor_'"+row+").innerText = '"+critabnstr+"'")
	        eval("parent.addModifyFrame.document.forms[0].norm_abnorm_ind_"+row).value = critabnstr;
		}
    }
    else
	{
		if(top.content != null)
		{
			document.getElementById('nor_' + row).innerText = '';

		}
		else
		{
			parent.addModifyFrame.document.getElementById('nor_'"+row).innerText = '' ;
		}
	}
}

async function addDetailText(row)
{
    //var t = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].def_data_"+row+".value");
    var t = eval("parent.addModifyFrame.document.forms[0].def_data_"+row+".value");
    var url     = "../../eCA/jsp/Editor.jsp";
    var dialogTop   = "143";
    var dialogHeight    = "26" ;
    var dialogWidth = "50" ;
    var arguments   = t ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
    var returnval =await window.showModalDialog( url, arguments, features ) ;
	//if(top.content.workAreaFrame != null)
	{
		//eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].def_data_"+row).value = returnval;
	}
	//else
	{
		eval("parent.addModifyFrame.document.forms[0].def_data_"+row).value = returnval;
	}
}
function CheckForNumber(val) {
    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
            alert(getMessage("ONLY_NUMBER_ALLOWED","CA"));
			return false;
        }
}
function checkChange(thisObj){return true;
/*if(thisObj.value==document.forms[0].defnum.value)
return true;
else
	return false;*/
}



//Functions for the file name DisDataChartAmendReplace.jsp-start

function returnVal()
{
	var retVal='';
	if(document.getElementById("amRe").checked)
			retVal=document.getElementById("amRe").value;
	else if(document.getElementById("amRe1").checked)
			retVal=document.getElementById("amRe1").value;
	document.parentWindow.returnValue =retVal;
	document.parentWindow.close();
}

function returnValCan()
{
	document.parentWindow.returnValue ="cancel";
	document.parentWindow.close();
}


//Functions for the file name DisDataChartAmendReplace.jsp-end


//Functions for the file name DisDataChartingRecord.jsp-start


async function checkNewValue(obj){
//	alert('count Value == '+document.forms[0].replaceError_count.value);
	countValue=document.forms[0].replaceError_count.value;
	if(obj.checked){
			var check='n';
			for(i=0;i<countValue;i++){
				temp=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].errorChk"+i);
				if(temp.disabled==false){
					check='y';
					temp.checked=true;
				}
			}
		var comments;
		var retVal;
		var dialogHeight ='7' ;
		var dialogWidth = '30' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		if(check=='y')	{
			retVal 			= await window.showModalDialog('../../eCA/jsp/RemarksDialog.jsp',arguments,features);
		}
		if(retVal!=null){
			for(i=0;i<countValue;i++){
					var rem=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].remarks"+i);
					var temp=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].errorChk"+i);
					var flag=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].flag"+i);
					var id=eval(top.content.workAreaFrame.addModifyFrame.document.getElementById("remID"+i));
					if(temp.disabled==false && flag.value!='Y'){
						rem.value=retVal;
						flag.value='Y';
						id.innerHTML="<a href='javascript:showRemarks(\""+retVal+"\",\"n\",\""+i+"\")' ><b>!</b></a>";
					}
			}
		}
		else //if he presses the close button on comment dialog then uncheck all checked
		{
			for(i=0;i<countValue;i++)	{
				var temp=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].errorChk"+i);
				var flag=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].flag"+i);
				//var id=eval("document.getElementById("remID")"+i);
				if(temp.disabled==false && flag.value!='Y')
					temp.checked=false;
			}
			obj.checked=false;
		}
	}else{
		for(i=0;i<countValue;i++)	{
			var temp=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].errorChk"+i);
			var flag=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].flag"+i);
			var rem=eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].remarks"+i);
			var id=eval("top.content.workAreaFrame.addModifyFrame.document.getElementById('remID'"+i+")");
			if(temp.disabled==false){
//				=false;
				rem.value="";
				flag.value='N';
				id.innerHTML="";
			}
		}
	}
}

//Functions for the file name DisDataChartingRecord.jsp-end

//Functions for the file name DisDataChartingTools.jsp-start

function ameRep()
{
	var qs= parent.toolsFrame.document.forms[0].query_string.value;
	qs=qs+'&amerepMode=Y';
	top.content.workAreaFrame.location.href = '../../eCA/jsp/DisDataCharting.jsp?'+qs
}

//Functions for the file name DisDataChartingTools.jsp-end



//Functions for the file name DisDataViewErrorList.jsp & PatProblemViewErrorList.jsp-start

async function showRemarks(value,disabled,count)
{
	var dialogHeight ='7' ;
	var dialogWidth = '30' ;
	if (disabled==null){
		disabled='y';
	}
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	retVal 			= await window.showModalDialog('../../eCA/jsp/RemarksDialog.jsp?resultStr='+value+'&disabled='+disabled,arguments,features);
}
		
function scrollTitle()
{
  var y = document.body.scrollTop;

  if(y == 0){
	document.getElementById("divDataTitle").style.position = 'static';
	document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	document.getElementById("divDataTitle").style.position = 'relative';
	document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}
/*function alignWidth()
{
	var totalRows =  document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = document.getElementById("dataTitleTable").rows[0].cells.length;
	for(var i=0;i<temp;i++) 
	{
		document.getElementById("dataTitleTable").rows[0].cells[i].width=document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
	}
}*/

	function alignWidth()
	{
	var totalRows =  parent.frame1.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = parent.frame1.document.getElementById("dataTitleTable").rows[1].cells.length;
	for(var i=0;i<temp;i++) {
		parent.frame1.document.getElementById("dataTitleTable").rows[1].cells[i].width=parent.frame1.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
	}
	}
//Functions for the file name DisDataViewErrorList.jsp & PatProblemViewErrorList.jsp-end

//Functions for the file name RemarksDialog.jsp-start

function doClose(){	
	var obj=document.forms[0].comments;
	
	if(!obj.disabled){
		if(obj.value==null || obj.value==""){
			alert(getMessage('REMARKS_CANNOT_BLANK','CA'));
			
		}else{
			window.returnValue=document.forms[0].comments.value;
			returnValue=replaceSplChars(returnValue);
			window.close();
		}
	}else{
		window.close();
	}
}
function CheckForSpecChars(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
 }

function doCloseAllergyDianosis()
{
		var obj=document.forms[0].comments;
		var locale	= document.forms[0].locale.value;
		var obj1 = trimString(obj.value);
		if(obj1==null || obj1=="" || obj1=="null")
		{
					alert(getMessage('REMARKS_CANNOT_BLANK','CA'));
					//document.forms[0].cancelval.value='';
					window.returnValue=''; //document.forms[0].dummyvalue.value;
					//window.close();
		}else{
					window.returnValue=trimString(document.forms[0].comments.value);
					//returnValue=replaceSplChars(returnValue);
					//alert("returnValue.length"+returnValue.length);
				   if(returnValue.length > 60)
			       {
					var msg = getMessage('RMRKS_MAX_LENGTH_CNT','CA');
					msg = msg.replace('$','60');
					alert(msg);	
					window.returnValue='';
				 }else
				 {
					window.returnValue=trimString(document.forms[0].comments.value);
					//returnValue=replaceSplChars(returnValue);
					parent.document.getElementById("dialog_tag").close(); 
	             }
	         }
}


function replaceSplChars(input)
{
	while (input.indexOf("\n")!=-1)
	{
		input = input.replace("\n","<br>");	
	}
   return input;
}

function doCloseAllergyDianosisRemark(){
		//window.returnValue=document.forms[0].resComments.value;
		window.returnValue=document.forms[0].resComments.value;
		parent.document.getElementById("dialog_tag").close(); 
}

//Functions for the file name RemarksDialog.jsp-end

function enterCheck()
{
	//alert("hii");
	whichCode = event.keyCode;
	//alert(whichCode)
    if(whichCode== 13)
	{
		event.keyCode=0;
	}

}

function CheckForSpecCharsForDate(event)
{
    var strCheck = "0123456789/";
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckForSpecCharsForDateTime(event)
{
    var strCheck = "0123456789/ :";
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


function maxCharChk(obj)
{
	
	if(obj.value.length > 60)
	{
		var msg = getMessage('RMRKS_MAX_LENGTH_CNT','CA');
		msg = msg.replace('$','60');
		alert(msg);
		obj.focus();
	}
}


function ismaxlength(obj)
{

	   var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
		if (obj.getAttribute && parseInt(obj.value.length)>mlength)
			{
				var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
				msg = msg.replace("$","Remarks");
				msg = msg.replace("#",mlength);					
				alert(msg);
				obj.focus();
				//obj.value=obj.value.substring(0,mlength);
			}
}
//IN037701 - start
function discrete_add(obj)
{	
	getPanelId(obj);

	var panel_id = parent.addModifyFrame.document.DisDataCharting_form.battery_id.value ;
	var disc_id = parent.addModifyFrame.document.DisDataCharting_form.disc_id.value ;
	var patient_id = parent.addModifyFrame.document.DisDataCharting_form.patient_id.value ;
	var last_record_date = parent.addModifyFrame.document.DisDataCharting_form.last_record_date.value ;
	var episode_id = parent.addModifyFrame.document.DisDataCharting_form.episode_id.value ;
	var patient_class = parent.addModifyFrame.document.DisDataCharting_form.patient_class.value ;
	var qs = parent.addModifyFrame.document.DisDataCharting_form.qs.value ;
	if(disc_id != "")
	{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += " disc_id=\""+ disc_id + "\" ";
		xmlStr += " panel_id=\""+ panel_id + "\" ";
		xmlStr += " patient_id=\""+ patient_id + "\" ";
		xmlStr += " last_record_date=\""+ last_record_date + "\" ";
		xmlStr += " episode_id=\""+ episode_id + "\" ";
		xmlStr += " patient_class=\""+ patient_class + "\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
		xmlHttp.open( "POST", "AddVitalInitialAssessmentSPC.jsp", false );
		xmlHttp.send(xmlDoc) ;
		responseText = xmlHttp.responseText ;
		var ret = eval(responseText);
		
		if(!ret)
			alert(getMessage('DUP_VITAL_CHK','CA'));
	}	
	parent.addModifyFrame.document.location.href='../../eCA/jsp/DisDataChartingRecord.jsp?'+qs;
}
async function getPanelId(target)
{
		var target				= "";	
	    var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;
	    var tit=getLabel("Common.DiscreteMeasure.label","Common");
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;

		sql = "select discr_msr_id code, short_desc description from am_discr_msr where eff_status = 'E' and result_type NOT IN ('G', 'V', 'Z') and vs_appl_yn='Y'";
		sql=sql+"and upper(discr_msr_id) like upper(?) and upper(short_desc) like upper(?) ";
       
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	var arr=new Array();
	if(retVal != null && retVal != "" )
	{
		var retVal=unescape(retVal);		
		arr=retVal.split(",");
		parent.addModifyFrame.document.DisDataCharting_form.disc_id.value=arr[0];
	}
	else
	{
		parent.addModifyFrame.document.DisDataCharting_form.disc_id.value="";
	}
}

function resetFormSPC(module_id)
{
	if(module_id != ""){
		if(parent.toolsFrame.document.forms[0].query_string.value){
			var qs = parent.toolsFrame.document.forms[0].query_string.value;
			parent.addModifyFrame.location.href = '../../eCA/jsp/DisDataChartingRecord.jsp?'+qs;
		}
	}else{
		if( top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value){
			var qs = top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value;
			top.content.workAreaFrame.addModifyFrame.location.href = '../../eCA/jsp/DisDataChartingRecord.jsp?'+qs;
		}
	}
}
//IN037701 - end


