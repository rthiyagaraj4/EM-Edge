function onsuccess(){
}

function showCalendarValidate(str){
		var flg = showCalendar(str);
		document.getElementById(str).focus();
		return flg;
}

function validateNumber(obj,lowlevel,highlevel,rownumber,numdigitsdec,critlow,crithigh,mindigits,module_id,shortdesc)
{
	var val = obj.value;
    var normabnormind = '';
	var normabnorminddesc = '';
	chkval = 10;
	if (val != null && val != '')
	{
		if(eval(mindigits) != 0)
		{
			if((val.length < eval(mindigits)))  
			{ 
				//alert(getMessage("MINIMUM_DIGITS","CA")+mindigits);
				var msg = getMessage("MIN_DIGITS_COMP","PH");
				msg=msg.replace("$$",shortdesc);
				msg=msg.replace("##",mindigits);
				alert(msg);
				obj.focus();
			}
		}
		if(!CheckForNumber(val))
		{
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
						alert(getMessage("INVALID_PRECISION","PH"));
						obj.focus();
					}
				}
				else
				{
					alert(getMessage("NO_DECIMAL","PH"));
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

			var n = parseFloat(val);

			var l =eval(lowlevel);
			var c = eval(critlow);

			if(l!=0 && n < l )
				normabnormind = lowstr;
			if(c!=0 && n<c)
				normabnormind = critlowstr;

			var h = eval(highlevel);
			var c = eval(crithigh);

			if(h!=0 && n >h )
				normabnormind = highstr;
			if(c!=0 && n>c)
				normabnormind = crithighstr;

			/*if (normabnormind == crithighstr || normabnormind == critlowstr)
			{ 
				normabnorminddesc = 'Critically Abnormal';
			}else if( normabnormind == lowstr || normabnormind == highstr)
			{
				normabnorminddesc = 'Abnormal';
			}*/

			if(module_id !="")
			{
				//eval("parent.addModifyFrame.document.getElementById("nor_")"+rownumber+".innerText = '"+normabnormind+"'");
				eval(parent.addModifyFrame.document.getElementById("norm_abnorm_ind_"+rownumber).value = '"+normabnormind+"'");
			}
			else
			{
				//eval("top.content.workAreaFrame.addModifyFrame.document.getElementById("nor_")"+rownumber+".innerText = '"+normabnormind+"'");
				eval(top.content.workAreaFrame.addModifyFrame.document.getElementById("norm_abnorm_ind_"+rownumber).value = '"+normabnormind+"'");
			}
		}
	}
	else
	{
		normabnormind = '';
		normabnorminddesc = '';
		if(module_id !="")
		{
			//eval("parent.addModifyFrame.document.getElementById("nor_")"+rownumber+".innerText = '"+normabnormind+"'");
			eval(parent.addModifyFrame.document.getElementById("norm_abnorm_ind_"+rownumber).value = '"+normabnormind+"'");
		}
		else
		{
			//eval("top.content.workAreaFrame.addModifyFrame.document.getElementById("nor_")"+rownumber+".innerText = '"+normabnormind+"'");
			eval(top.content.workAreaFrame.addModifyFrame.document.getElementById("norm_abnorm_ind_"+rownumber).value = '"+normabnormind+"'");
		}
		
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
        var desc = eval(top.content.workAreaFrame.addModifyFrame.document.getElementById("short_desc_"+n).innerText");

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


function apply(module_id,mode)
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
			var mandatoryyn = eval("parent.addModifyFrame.document.forms[0].mandatory_yn_"+n+".value");
			
			
			var strval = eval("parent.addModifyFrame.document.forms[0].str_id_"+n+".value");
			if(strval=="" || strval=="null")
			{
			 i++;
			}
			var strobj = eval("parent.addModifyFrame.document.forms[0].str_id_"+n+"");
			var desc = eval(parent.addModifyFrame.document.getElementById("short_desc_"+n).innerText");

			//alert('mandatoryyn ->'+mandatoryyn+'strval ->'+strval+'strobj ->'+strobj+'desc ->'+desc);
			if(mandatoryyn == 'Y' && strval == '')
			{
				//alert("1");
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
	}else{
		for(var n=1;n<=count;n++)
		{
			var mandatoryyn = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].mandatory_yn_"+n+".value");
			var strval = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].str_id_"+n+".value");
			var strobj = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].str_id_"+n+"");
			var desc = eval(top.content.workAreaFrame.addModifyFrame.document.getElementById("short_desc_"+n).innerText");

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
		 alert(getMessage('ATLEAT_ONE_VITAL_DATA_REQ','PH'));
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
				parent.window.close();
	    }else{ 
				if (top.content.workAreaFrame.addModifyFrame.document.forms[0].in_error.value =="Y"  || top.content.workAreaFrame.addModifyFrame.document.forms[0].in_replace.value =="Y" ){
							var qs = top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value;
							var loc=qs.indexOf('&battey_id');
							var substr=qs.substr(loc);
							var qstring=qs.replace(substr,"");
							top.content.workAreaFrame.location.href='../../ePH/jsp/DisDataCharting.jsp?'+qstring;
				}else{
     					    top.content.workAreaFrame.location.href='../../eCommon/html/blank.html' ;
				}
		}
}

function onSuccess(){
    var qs = top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value;
    top.content.workAreaFrame.location.href = '../../ePH/jsp/DisDataCharting.jsp?'+qs
}

function resetForm(module_id)
{
	if(module_id != ""){
		if(parent.toolsFrame.document.forms[0].query_string.value){
		   var qs = parent.toolsFrame.document.forms[0].query_string.value;
			parent.addModifyFrame.location.href = '../../ePH/jsp/DisDataChartingRecord.jsp?'+qs
		}
	}else{
		if( top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value){
		   var qs = top.content.workAreaFrame.toolsFrame.document.forms[0].query_string.value;
			top.content.workAreaFrame.addModifyFrame.location.href = '../../ePH/jsp/DisDataChartingRecord.jsp?'+qs
		}
	}
}

function validateDateTime(obj,val){
    if(obj.value != ''){
        if(val == 'E'){
            if(!doDateTimeChk(obj)){
                alert(getMessage('INVALID_DATE_TIME','PH'));
				obj.select();
                obj.focus();
            }
        }
        else if(val == 'D'){
            if(CheckDate(obj)){}
        }
        else if(val == 'T')
        {
            if(!chkTime(obj.value))
            {
                alert(getMessage('INVALID_TIME_FMT','PH'));
				obj.select();
                obj.focus();
            }
        }
    }
}

function chkNormalAbnormal(obj,row)
{
	return; // Currently deactivate the NormalAbmnormal activity and later if required enable it by remove this line
	if(top.content != null)
	{
		var abnstr = top.content.workAreaFrame.addModifyFrame.document.forms[0].abn_str.value;
	    var critabnstr = top.content.workAreaFrame.addModifyFrame.document.forms[0].crit_abn_str.value;
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
		    //eval("top.content.workAreaFrame.addModifyFrame.document.getElementById("nor_")"+row+".innerText = '"+abnstr+"'")
			eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].norm_abnorm_ind_"+row).value = abnstr;
		}
		else
		{
			//eval("parent.addModifyFrame.document.getElementById("nor_")"+row+".innerText = '"+abnstr+"'")
			eval("parent.addModifyFrame.document.forms[0].norm_abnorm_ind_"+row).value = abnstr;
		}
    }
    else if(obj.options[obj.options.selectedIndex].className == 'C')
    {
		if(top.content != null)
		{
			//eval("top.content.workAreaFrame.addModifyFrame.document.getElementById("nor_")"+row+".innerText = '"+critabnstr+"'")
	        eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].norm_abnorm_ind_"+row).value = critabnstr;
		}
		else
		{
			//eval("parent.addModifyFrame.document.getElementById("nor_")"+row+".innerText = '"+critabnstr+"'")
	        eval("parent.addModifyFrame.document.forms[0].norm_abnorm_ind_"+row).value = critabnstr;
		}
    }
    else
	{
		if(top.content != null)
		{
			//eval("top.content.workAreaFrame.addModifyFrame.document.getElementById("nor_")"+row+".innerText = '' ")
		}
		else
		{
			//eval("parent.addModifyFrame.document.getElementById("nor_")"+row+".innerText = '' ")
		}
	}
}

async function addDetailText(row)
{
    //var t = eval("top.content.workAreaFrame.addModifyFrame.document.forms[0].def_data_"+row+".value");
    var t = eval("parent.addModifyFrame.document.forms[0].def_data_"+row+".value");
    var url     = "../../ePH/jsp/Editor.jsp";
    var dialogTop   = "143";
    var dialogHeight    = "40vh" ;
    var dialogWidth = "50vw" ;
    var arguments   = t ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
    var returnval = await window.showModalDialog( url, arguments, features ) ;
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
            alert(getMessage("ONLY_NUMBER_ALLOWED","PH"));
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

function ameRep()
{
	var qs= parent.toolsFrame.document.forms[0].query_string.value;
	qs=qs+'&amerepMode=Y';
	top.content.workAreaFrame.location.href = '../../ePH/jsp/DisDataCharting.jsp?'+qs
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
function alignWidth()
{
	var totalRows =  document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = document.getElementById("dataTitleTable").rows(0).cells.length;
	for(var i=0;i<temp;i++) 
	{
		document.getElementById("dataTitleTable").rows(0).cells(i).width=
		document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
	}
}

//Functions for the file name DisDataViewErrorList.jsp & PatProblemViewErrorList.jsp-end

//Functions for the file name RemarksDialog.jsp-start

function doClose(){
	
	var obj=document.forms[0].comments;
	if(!obj.disabled){
		if(obj.value==null || obj.value==""){
			alert(getMessage('REMARKS_CANNOT_BLANK','PH'));
			
		}else{
			window.returnValue=document.forms[0].comments.value;
			window.close();
		}
	}else{
		window.close();
	}
}

function doCloseAllergyDianosis(){
		
		var obj=document.forms[0].comments;
		if(obj.value==null || obj.value==""){
			
			alert(getMessage('REMARKS_CANNOT_BLANK','PH'));
			//document.forms[0].cancelval.value='';
			window.returnValue=''; //document.forms[0].dummyvalue.value;
			//window.close();
		}else{
			window.returnValue=document.forms[0].comments.value;
			window.close();
		}
}

function doCloseAllergyDianosisRemark(){
		//window.returnValue=document.forms[0].cancelval.value;
		window.returnValue='';
		window.close();
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
