/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function apply() {
	var count = 0;
	var count1 = 0;
	var count2 = 0;
	var count3 = 0;
	var formObj = parent.f_query_add_mod.document.forms[0].staffass.value;
	var chkedValues = "";
	var check = document.forms[0].check;
	var total = 0;
	if($('#staffAssignmentId').is(':checked') == true)
		total++;
	var max = document.forms[0].fetchCount.value;
	for (var idx = 0; idx < max; idx++)
	{
		if ($('#roomListId'+idx).is(':checked') == true)
		{
			total++;
			chkedValues = chkedValues + check[idx].value + ",";
		}
	}
	if(total == 0)
	{
		alert(getMessage("APP-OT0215",'OT'));
		return false;
	}
	if(chkedValues.length != 0)
		chkedValues = chkedValues.substring(0, chkedValues.length-1);
	document.forms[0].room1.value = chkedValues;
/*
	 if($('#staffAssignmentId').is(':checked') == true)
	 {
		 count1 = count+1;
	 }
	 else{
		 count1;
	 }

	 var check=document.forms[0].check;
	 var txt="";
	 var i;

	 var roomCount = 0;
	 for (i=0;i<check.length;i++){

		 if (check[i].checked)
		 {
			 if(roomCount == 0)
			 {
				 document.forms[0].room1.value =check[i].value;
			 }
			 else if(roomCount == 1)
			 {
				 document.forms[0].room2.value =check[i].value;
			 }
			 else
			 {
				 document.forms[0].room3.value =check[i].value;
			 }
			 roomCount++;
	  		 txt=txt + check[i].value;
		 }
	 }
	 count3=count1+roomCount;

	  if(count3 < 1){
		alert(getMessage("APP-OT0215",'OT'));
        return false;
	 }

	 if(count3 > 3){
		alert(getMessage("APP-OT0214",'OT'));
		 return false;
	 }
*/
	if(checkvalid())
		parent.f_query_add_mod.document.forms[0].submit();
}

function reset() {
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
}

function onSuccess() {

f_query_add_mod.location.reload();
}


function check_eff(obj){
	if(obj.checked == true){
		obj.value='Y';
	}
	else{
		obj.value='N';
	}
}

function check_eff1(obj){
	if(obj.checked == true){
		obj.value='Y';
	}
	else{
		obj.value='N';
	}
}

function check_eff2(obj){
	if(obj.checked == true){
		obj.value='Y';
	}
	else{
		obj.value='N';
	}
}

function createOrder(that)
{
var count = 0;
var check=document.forms[0].check;
var staff=document.forms[0].staffass;
var txt="";
var txt1="";
var i;
var staff_name ="";
for (i=0;i<check.length;i++)
  {
  if (check[i].checked)
	{
	  count++;
	  txt=txt + check[i].value + " ";
    }
	else
	{

	}
   }
  if (staff.checked)
    {	count++;
		staff_name = "Staff Assignment";
		txt1 = txt1 + staff_name ;

	}
	if(count < 3)
		{


		}
		else
		{
		return false;
		}

}


function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

function checkvalid()
{
		var refresh_format = parent.f_query_add_mod.document.forms[0].Interval.value;
		var ref_interval=parent.f_query_add_mod.document.forms[0].RefreshInterval.value;
		var second_chk=5;
		var min_chk=1;
		var ref_int=false;
		var ref_frmt=false;
		var final_ref=false;
		if(ref_interval!=""){
			if(ref_interval<parseInt(second_chk) && refresh_format=="SS" || ref_interval<parseInt(min_chk) && refresh_format=="MM"){
			var error = getMessage("APP-OT0216","OT");
			error = error.replace("$",getLabel("eOT.AutoRefreshTime.Label","OT"));
			error = error.replace("#","5");
			alert(error);
			parent.f_query_add_mod.document.forms[0].RefreshInterval.focus();
			return false;
		}else if(ref_interval>=parseInt(second_chk) && refresh_format=="SS" || ref_interval>=parseInt(min_chk) && refresh_format=="MM"){
			final_ref =true;

		}

	}else{
		var error ="";
		if(refresh_format=="SS"){
		 error = getMessage("APP-OT0217","OT");
		error = error.replace("$",getLabel("eOT.AutoRefreshTime.Label","OT"));
		error = error.replace("#","5");
		alert(error);
		}else{
		error = getMessage("APP-OT0217","OT");
		error = error.replace("$",getLabel("eOT.AutoRefreshTime.Label","OT"));
		error = error.replace("#","5");
		alert(error);
		}

		parent.f_query_add_mod.document.forms[0].RefreshInterval.focus();

	}

		return final_ref;

}

async function preview()
{
	//var dialogTop = "80";
	//var dialogHeight = "80" ;
	//var dialogWidth = "80" ;
	console.log("In here");
	var dialogTop = "0";
	var dialogHeight = "650px" ;
	var dialogWidth = "1200px" ;
	var status = "no";
	var arguments = "" ;
	var staff = parent.f_query_add_mod.document.forms[0].staffass.value;
	var count = 0;
	var check = document.forms[0].check;
	var i;
	var txt = "";
	var txt1 = "";
	var param;
	var chkCount = 0;
	var chkedValues = "";
	var staffAssignmentId = $('#staffAssignmentId').val();
	if($('#staffAssignmentId').is(':checked') == true)
		chkCount++;
	var refreshIntervalId = $('#RefreshInterval').val();
	var intervalId = $('#Interval').val();
	var chkedArray = new Array();
	var j = 0;
	for (i=0; i < check.length; i++)
	{
		if (check[i].checked)
		{
			if(chkedValues.length == 0)
				chkedValues = chkedValues + "'";
			chkedValues = chkedValues + check[i].value + "','";
			chkedArray[j] = i;
			j++;
		}
	}
	if(chkedValues.length != 0)
		chkedValues = chkedValues.substring(0, chkedValues.length-2);
	chkCount += chkedArray.length;
	if(checkvalid())
	{
	if(chkCount > 0)	// Added by Chaitanya against IN:044804
	{
		if(chkedArray.length == 1)
		{
			param = "room_no="+$('#roomListId'+chkedArray[0]).val()+
						 "&room_name="+$('#roomListValue'+chkedArray[0]).val()+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=1"+
						 "&intervalId="+intervalId;
						 if($('#staffAssignmentId').is(':checked') == true)
							param += "&staffAssignmentId=Y";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eOT/jsp/OT_slate_screenFrame.jsp?"+param, arguments, features);
		}
		else if(chkedArray.length == 2)
		{
			var param0 = "room_no="+$('#roomListId'+chkedArray[0]).val()+
						 "&room_name="+$('#roomListValue'+chkedArray[0]).val()+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=2"+
						 "&intervalId="+intervalId;
			var param1 = "room_no="+$('#roomListId'+chkedArray[1]).val()+
						 "&room_name="+$('#roomListValue'+chkedArray[1]).val()+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=2"+
						 "&intervalId="+intervalId;
			param = param0 + "~" + param1;
			if($('#staffAssignmentId').is(':checked') == true)
				param += "&staffAssignmentId=Y";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eOT/jsp/OT_slate_screenFrame.jsp?"+param, arguments, features);
		}
		else if(chkedArray.length == 3 && ($('#staffAssignmentId').is(':checked') == false))
		{
			var param0 = "room_no="+$('#roomListId'+chkedArray[0]).val()+
						 "&room_name="+$('#roomListValue'+chkedArray[0]).val()+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=3"+
						 "&intervalId="+intervalId;
			var param1 = "room_no="+$('#roomListId'+chkedArray[1]).val()+
						 "&room_name="+$('#roomListValue'+chkedArray[1]).val()+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=3"+
						 "&intervalId="+intervalId;
			var param2 = "room_no="+$('#roomListId'+chkedArray[2]).val()+
						 "&room_name="+$('#roomListValue'+chkedArray[2]).val()+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=3"+
						 "&intervalId="+intervalId;
			param = param0 + "~" + param1 + "~~" + param2;
			if($('#staffAssignmentId').is(':checked') == true)
				param += "&staffAssignmentId=Y";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eOT/jsp/OT_slate_screenFrame.jsp?"+param, arguments, features);
		}
		else if(chkedArray.length >= 3)
		{
			param = "chkedValues="+chkedValues+
						 "&frameCount=4"+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&intervalId="+intervalId;
						 if($('#staffAssignmentId').is(':checked') == true)
							param += "&staffAssignmentId=Y";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eOT/jsp/OT_slate_screenFrame.jsp?"+param, arguments, features);
		}
		else if($('#staffAssignmentId').is(':checked') == true)
		{
			param = "staff="+staffAssignmentId+
						"&refreshIntervalId="+refreshIntervalId+
						"&staffAssignmentId=Y"+
						"&chkedValues="+chkedValues+
						"&intervalId="+intervalId;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eOT/jsp/OT_slate_screenFrame.jsp?"+param, arguments, features);
		}
	}
	else	// Added by Chaitanya against IN:044804
		alert(getMessage("APP-OT0215",'OT'));
}
}

var dashboardWindow;
function displayDashboard()
{
	var params = [
	              'height='+screen.height,
	              'width='+screen.width,
	              'fullscreen=yes' // only works in IE, but here for completeness
	          ].join(',');
	var staff = parent.f_query_add_mod.document.forms[0].staffass.value;
	var count = 0;
	var check = document.forms[0].check;
	var i;
	var txt = "";
	var txt1 = "";
	var param;
	var chkCount = 0;
	var chkedValues = "";
	var dbValuesArray = new Array();
	var staffAssignmentId;
	var dbValuesToSplit = "";
	var dbValuesToSplitArray = new Array();
	var dbValues = $('#dbValues').val();
	dbValuesArray = dbValues.split("~");
	var displayNamesArray = new Array();
	var displayNames = $('#roomCodeDisplay').val();
	displayNamesArray = displayNames.split(",")
	var refreshIntervalId = $('#refresh_interval').val();
	var intervalId = $('#refresh_interval_time').val();
	var chkedArray = new Array();
	for (var i=0; i < dbValuesArray.length; i++)
	{
		if(dbValuesArray[i].length > 0)
		{
			if(dbValuesArray[i] == 'Staff Assignment')
			{
				chkCount++;
				staffAssignmentId = 'Y';
			}
			else
			{
				dbValuesToSplit = dbValuesArray[i];
				chkedArray = dbValuesToSplit.split(",");
			}
		}
	}
	for(var f=0; f<chkedArray.length; f++)
	{
		if(chkedValues.length == 0)
			chkedValues = chkedValues + "'";
		chkedValues = chkedValues + chkedArray[f] + "','";
	}
	if(chkedValues.length != 0)
		chkedValues = chkedValues.substring(0, chkedValues.length-2);
	chkCount += chkedArray.length;
	if(checkvalid())
	{
	if(chkCount > 0)	// Added by Chaitanya against IN:044804
	{
		if(chkedArray.length == 1)
		{
			param = "room_no="+chkedArray[0]+
						 "&room_name="+displayNamesArray[0]+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=1"+
						 "&intervalId="+intervalId;
						 if(staffAssignmentId == 'Y')
							param += "&staffAssignmentId=Y";
			dashboardWindow = window.open("../../eOT/jsp/OT_slate_screenFrame.jsp?"+param,'PatientDashboard',params);
			dashboardWindow.moveTo(0,0);
			document.getElementById("displayBtn").disabled = true;
			document.getElementById("displayCloseBtn").disabled = false;
		}
		else if(chkedArray.length == 2)
		{
				var param0 = "room_no="+chkedArray[0]+
						"&room_name="+displayNamesArray[0]+
						"&refreshIntervalId="+refreshIntervalId+
						"&chkedValues="+chkedValues+
						 "&frameCount=2"+
						 "&intervalId="+intervalId;
				var param1 = "room_no="+chkedArray[1]+
						 "&room_name="+displayNamesArray[1]+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=2"+
						 "&intervalId="+intervalId;
			param = param0 + "~" + param1;
			if(staffAssignmentId == 'Y')
				param += "&staffAssignmentId=Y";
			dashboardWindow = window.open("../../eOT/jsp/OT_slate_screenFrame.jsp?"+param,'PatientDashboard',params);
			dashboardWindow.moveTo(0,0);
			document.getElementById("displayBtn").disabled = true;
			document.getElementById("displayCloseBtn").disabled = false;
		}
		else if(chkedArray.length == 3 && staffAssignmentId != 'Y')
		{
			var param0 = "room_no="+chkedArray[0]+
						 "&room_name="+displayNamesArray[0]+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=3"+
						 "&intervalId="+intervalId;
			var param1 = "room_no="+chkedArray[1]+
						 "&room_name="+displayNamesArray[1]+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=3"+
						 "&intervalId="+intervalId;
			var param2 = "room_no="+chkedArray[2]+
						 "&room_name="+displayNamesArray[2]+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&chkedValues="+chkedValues+
						 "&frameCount=3"+
						 "&intervalId="+intervalId;
			param = param0 + "~" + param1 + "~~" + param2;
			if(staffAssignmentId == 'Y')
				param += "&staffAssignmentId=Y";
			dashboardWindow = window.open("../../eOT/jsp/OT_slate_screenFrame.jsp?"+param,'PatientDashboard',params );
			dashboardWindow.moveTo(0,0);
			document.getElementById("displayBtn").disabled = true;
			document.getElementById("displayCloseBtn").disabled = false;
		}
		else if(chkedArray.length >= 3)
		{
			param = "chkedValues="+chkedValues+
						 "&frameCount=4"+
						 "&refreshIntervalId="+refreshIntervalId+
						 "&intervalId="+intervalId;
						 if(staffAssignmentId == 'Y')
							param += "&staffAssignmentId=Y";
			dashboardWindow = window.open("../../eOT/jsp/OT_slate_screenFrame.jsp?"+param, 'PatientDashboard', params);
			dashboardWindow.moveTo(0,0);
			dashboardWindow.moveTo(0,0);
			document.getElementById("displayBtn").disabled = true;
			document.getElementById("displayCloseBtn").disabled = false;
		}
		else if(staffAssignmentId == 'Y')
		{
			param = "staff="+staffAssignmentId+
						"&refreshIntervalId="+refreshIntervalId+
						"&staffAssignmentId=Y"+
						"&chkedValues="+chkedValues+
						"&intervalId="+intervalId;
			dashboardWindow = window.open("../../eOT/jsp/OT_slate_screenFrame.jsp?"+param, 'PatientDashboard', params);
			dashboardWindow.moveTo(0,0);
			document.getElementById("displayBtn").disabled = true;
			document.getElementById("displayCloseBtn").disabled = false;
		}
	}
	else	// Added by Chaitanya against IN:044804
		alert(getMessage("APP-OT0215",'OT'));
}
}
function closeDashboard()
{
	dashboardWindow.close();
	document.getElementById("displayBtn").disabled = false;
	document.getElementById("displayCloseBtn").disabled = true;
}
