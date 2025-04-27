 var mealTypesObj={};
 var excludedMealTypes={};
 var preExcludedMealtypes={}; // this variable is used to hold the exclusions already recorded
 var distinctMealTypes=[];
 //CRF-428
 var changedFlag=false;
 var closeWindowFlag=false;
 var pastMealFlag=false;
 var expiredMealsArray=[];
 //CRF-428
 $(document).ready(function() {
	enableSelectBtn();
    populateMealTypes();
    getDistinctMealTypes();
    mergeDefaults();
    formExclusionsTable();
    $("#ok").prop('disabled', true);
//CRF-428

	window.onbeforeunload = function() {
		if(!closeWindowFlag) {
			var obj={};
			obj.excludedMealTypes=preExcludedMealtypes;
			obj.changedFlag=changedFlag;
			window.returnValue = obj;
			//window.close();
			
			parent.document.getElementById('dialog_tag').close();
		}
	};
//CRF-428
  });

 var defaults={};

 populateMealTypes=function() {
	 var mealTypesObj1= $("#mealTypes").val();
	 var obj=window.dialogArguments;

	 mealTypesObj=obj.mealTypes;
	 //preExcludedMealtypes=obj.excludedMealTypes;
	 excludedMealTypes=obj.excludedMealTypes;

	 $.each(excludedMealTypes,function(index) {
	 	preExcludedMealtypes[index]=excludedMealTypes[index];
	 });
	 $.each(mealTypesObj,function(index) {
	 	addCheckbox(this.Meal_Code,this.Short_Desc,index);
	 	//defaults[this.Meal_Code]="N";
	 });
 }

 addCheckbox=function (code,text,index) {
    var container 		= $('#checkboxcontainer');
    var container_tr    = $('#checkboxcontainer tr:last');
    var chkbox = "<label for='" + text + "'>" + text + "</label></td><td><input id='"+code+"' type='checkbox' value='N' name='" + text + "' id='" + text + "' onclick='enableSelectBtn()'/>";

	if(index%2==0) {
		$("<tr><td style='min-width:25%'  noWrap class='label'>"+chkbox+"</td></tr>").appendTo(container);
	}
	else {
		$("<td style='min-width:25%'  noWrap class='label'>"+chkbox+"</td>").appendTo(container_tr);
	}
    //chkbox.appendTo(container);
}

formExclusionsTable = function() {
	var table		= $('#excludedMealTypesTable');

	$("#excludedMealTypesTable").find("tr").remove();
	if(distinctMealTypes.length>0) {
		var row=$('<tr><th>Diet Order Date</th></tr>').appendTo(table);
	}

	$.each(distinctMealTypes,function(iter) {
		$('<th>'+distinctMealTypes[iter]+'</th>').appendTo(row);
	});

	$.each(excludedMealTypes,function(key,value) {
		var obj=this;
		var date=key;
		var dateMomentObj = moment(date, "DD/MM/YYYY");
		var row1=$("<tr><td>"+date+"</td></tr>").appendTo(table);
		var isPastDateFlag=moment().diff(dateMomentObj, 'days');
		var today=moment().format("DD/MM/YYYY");

		$.each(obj,function(iter) {
			var expiredMealFlag="N";
			if (today==date) expiredMealFlag=checkMealTiming(iter);
			var img = "<img src=\"../../eDS/css/exclusions.png\" title=\"Click to Revoke\" onclick=\"remove('"+date+"','"+iter+"');enableOkBtn()\"/>";
			if(isPastDateFlag>0) img = "<img src='../../eDS/css/stop.png'/>";
			if(expiredMealFlag=="Y") img = "<img src='../../eDS/css/stop.png'/>";
			var text= obj[iter]=='Y'?img:"";
			//$('<td/>', {text : text}).appendTo(row1);
			if(text=="") $('<td/>', {text : " "}).appendTo(row1);
			else $('<td align="center">'+text+'</td>').appendTo(row1);
		});
	});
	enableOkBtn();
}
getDistinctMealTypes = function() {
	/*$.each(excludedMealTypes,function(key,value) {
		var obj=this;
		alert(distinctMealTypes);
		$.each(obj,function(iter) {
			if($.inArray(iter,distinctMealTypes)==-1) {
				distinctMealTypes.push(iter);
				defaults[iter]="N";
			}
		});
	});*/
	 $.each(mealTypesObj,function(index) {
	 	distinctMealTypes.push(this.Short_Desc);
	 	defaults[this.Meal_Code]="N";
	 });
}
mergeDefaults = function() {
	$.each(excludedMealTypes,function(key,value) {
		var obj=this;
		var tempobj=$.extend( {}, defaults, obj);
		excludedMealTypes[key]=tempobj;
	});
}
addExclusions = function() {
	var flag=checkValidDates();
	var pastMealFlag=false;
	expiredMealsArray=[];

	if(flag=='-1') {
		//alert("Start Date Cannot be Greater than End Date");
		return;
	}
	if(checkOrderDates()) {
		alert("Meal Exclusion Date should be within Diet Order Date");
		
		return;
	}
	var checkedMealTypesCount=checkMealTypesMandatory();
	if(checkedMealTypesCount==0) {
		alert("Atleast One Meal Type should be selected");
		
		return;
	}
	var checkedMealTypes = [];
	var dateArray = [];
	var fromDate=$("#fromdate").val();
	var toDate=$("#todate").val();
	var today=moment().format("DD/MM/YYYY");
	var expiredMealFlag="N";

	checkedMealTypes[0]="";
	$("input:checkbox:checked").each(function(index){
		checkedMealTypes[index]=$(this).attr('id');
	});
	dateArray=getDateRange(fromDate, toDate,'DD/MM/YYYY');
	$.each(dateArray,function(index) {
		$.each(checkedMealTypes,function(iter) {
			expiredMealFlag="N";
			if (today==dateArray[index]) {expiredMealFlag=checkMealTiming(checkedMealTypes[iter]);}
			if(!(expiredMealFlag=="Y")) {
				if(excludedMealTypes[dateArray[index]]==null){
					excludedMealTypes[dateArray[index]]={};
					excludedMealTypes[dateArray[index]][checkedMealTypes[iter]]="Y";
				}
				else  excludedMealTypes[dateArray[index]][checkedMealTypes[iter]]="Y";
			}
			else {
				expiredMealsArray.push(checkedMealTypes[iter]);
				pastMealFlag=true;
			}
		});
	});
	mergeDefaults();
	formExclusionsTable();
	changedFlag=true;//CRF-428
	var msg="Only current and future meal(s) can be excluded. The following meal(s) are expired for the current day \n \n";
	$.each(expiredMealsArray,function(index,value) {
	msg=msg+getMealTypeDesc(value)+"\n";
	});
	if(pastMealFlag==true) alert(msg);
}
function getDateRange(fromDate, toDate, dateFormat) {
	var dates = [];
	var fromDate_moment = moment(fromDate,dateFormat);
	var toDate_moment = moment(toDate,dateFormat);
	var diff = toDate_moment.diff(fromDate_moment, 'days');
	/*if(!fromDate_moment.isValid() || !toDate_moment.isValid() || diff <= 0) {
		return;
	}*/
	dates.push(fromDate_moment.format(dateFormat));
	for(var i = 0; i < diff; i++) {
		dates.push(fromDate_moment.add(1,'d').format(dateFormat));
	}
	return dates;
};
remove = function (date,mealType) {
	excludedMealTypes[date][mealType]="N";
	var flag="N";
	$.each(excludedMealTypes[date],function(key,value) {
		if(value=="Y") flag="Y"
	});
	if(flag=="N") delete excludedMealTypes[date]
	formExclusionsTable();
	changedFlag=true;//CRF-428
}
checkMealTiming = function (mealType) {
	var flag="N";
	 $.each(mealTypesObj,function(index) {
	 	if(this.Meal_Code==mealType) {
			var irreg_end_time=this.Irregular_End_Time;//CRF-428
			var next_meal_start_time=this.Next_Meal_Start_Time;
			var endTime=irreg_end_time;
			if (endTime=="") endTime=next_meal_start_time;
			var currentTimeObj=moment();
			var endTimeObj=moment(endTime,'HH:mm');
			var duration = moment.duration(endTimeObj.diff(currentTimeObj));
			var hours = duration.asHours();
			if(hours<0) flag= "Y";
			//break;
		}
	 });
	 return flag;
}
function checkForSpecCharsforID(event) {
	var strCheck = '0123456789/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) return false;
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function checkValidDates(){
	var fromDate=$("#fromdate").val();
	var toDate=$("#todate").val();
	//var flag=compareDate(fromDate,toDate);
	var flag=compareDate(toDate,fromDate);
	if(fromDate!="" && toDate!=""){
	//var flag=moment(fromDate).isAfter(toDate, 'days');	
	/*var startDate = new Date(fromDate);
	var endDate = new Date(toDate);*/
	/*if (startDate < endDate){
	// Do something
	flag=false;
	}else{
		flag=true;
	}*/	
	
	if(flag== -1)
	{	
		alert("Start Date Cannot be Greater than End Date");		
		$("#fromdate").val("");
		$("#fromdate").focus();
		flag=false;
		return false;
	}
	}
	return flag;
}

function checkOrderDates(){
	var fromDate=$("#fromdate").val();
	var toDate=$("#todate").val();
	var orderFromDate=$("#order_from_date").val();
	var orderToDate=$("#order_to_date").val();
	var fromDateMomentObj=moment(fromDate,"DD/MM/YYYY");
	var toDateMomentObj=moment(toDate,"DD/MM/YYYY");
	var orderFromDateMomentObj=moment(orderFromDate,"DD/MM/YYYY");
	var orderToDateMomentObj=moment(orderToDate,"DD/MM/YYYY");
	var range = moment.range(orderFromDateMomentObj, orderToDateMomentObj);
	var flag1 = fromDateMomentObj.within(range);
	var flag2 = toDateMomentObj.within(range);
	if(flag1 == false || flag2 == false) {
		return true;
	}
	else return false;
}
function checkMealTypesMandatory() {
	var length=$("input:checkbox:checked").length;
	return length;
}
function enableSelectBtn() {
	var fromDate=$("#fromdate").val();
	var toDate=$("#todate").val();
	var length=$("input:checkbox:checked").length;
	if(fromDate!="" && toDate!="" && length>0) $("#btnSelect").prop('disabled', false);
	else $("#btnSelect").prop('disabled', true);
}
function enableOkBtn() {
	/*var tableRows=$("#excludedMealTypesTable").find("tr").length - 1;
	if(tableRows>0) $("#ok").prop('disabled', false);
	else $("#ok").prop('disabled', true);*/
	$("#ok").prop('disabled', false);
}
function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}
function moveExclusions () {
	if(checkIfAllMealTypesExcluded()) {
		alert("Atleast one meal should be selected for the Diet Order");
		
		return;
	}
	closeWindowFlag=true;
	var obj={};
	obj.excludedMealTypes=excludedMealTypes;
	obj.changedFlag=changedFlag;
	window.returnValue = obj;
	window.close();
}
function cancelExclusions () {
	closeWindowFlag=true;
	var obj={};
	obj.excludedMealTypes=preExcludedMealtypes;
	obj.changedFlag=changedFlag;
	window.returnValue = obj;
	//window.close();
	parent.document.getElementById('dialog_tag').close();
}
function checkIfAllMealTypesExcluded() {
	var flag=false;
	var fromDate=$("#order_from_date").val();
	var toDate=$("#order_to_date").val();

	var fromDate_moment = moment(fromDate,'DD/MM/YYYY');
	var toDate_moment = moment(toDate,'DD/MM/YYYY');
	var diffInDays = parseInt(toDate_moment.diff(fromDate_moment, 'days'))+1;
	var count_excludedMeals=getNumberOfExcludedMeals();
	var maxMealsForOrder=parseInt(diffInDays)*parseInt(mealTypesObj.length);

	if(parseInt(count_excludedMeals)==maxMealsForOrder) flag=true; ;
	return flag;
}
function getNumberOfExcludedMeals() {
	var count=0;
	$.each(excludedMealTypes,function(key,value) {
		var obj=this;
		$.each(obj,function(iter) {
			if(obj[iter]=='Y') count++;
		});
	});
	return count;
}
getMealTypeDesc = function (mealTypeCode) {
	var desc="";
	$.each(mealTypesObj,function(index) {
	if(this.Meal_Code==mealTypeCode){
		desc=this.Short_Desc;
	}
});
return desc;
}

