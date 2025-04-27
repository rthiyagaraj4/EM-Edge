/* This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release */

var SupplementaryMeals={};
var SupplementaryMealsarr={};
var OnLoad_SupplementaryMealsarr={};//will contain the on load meal type
var sno;
var meal_Type_Arr=[];
//The below parameter are used to hold the loaded value in search field on click of hyper link starts
var modification_flag=false;
var loaded_sno;
var loaded_SupplementaryMeals={};
var loaded_meal_type="";
var dtglobal=new Date();

//The below parameter are used to hold the loaded value in search field on click of hyper link ends
/*newreset = function(){

//location.reload();
//location.href = location.href;
//location.href = location.pathname

//location.pathname
//window.self.window.self.window.window.location = window.location

var dataModifyFlag=checkDataModification();

	if(!dataModifyFlag){	

	if(!confirm(getMessage("DS_UNSAVED_CHANGE_LOST","DS"))){
		return;
	}
	//return getMessage("DS_UNSAVED_CHANGE_LOST","DS");
}

clearField();
	SupplementaryMealsarr={};
	OnLoad_SupplementaryMealsarr={};
	getSavedSupplementaryMeal();
	FormSupplementaryOrderTable();	
}*/
function reset(){
	var params="";
	params+="&encounterId="+parent.frames[2].document.getElementById("encounterId").value;
	params+="&patientId="+parent.frames[2].document.getElementById("patientId").value;
	params+="&locationCode="+parent.frames[2].document.getElementById("locationCode").value;
	params+="&patientClass="+parent.frames[2].document.getElementById("patientClass").value;
	params+="&room="+parent.frames[2].document.getElementById("room").value;
	params+="&bed="+parent.frames[2].document.getElementById("bed").value;
	params+="&locationType="+parent.frames[2].document.getElementById("locationType").value;
	params+="&dateOfBirth="+parent.frames[2].document.getElementById("dateOfBirth").value;
	params+="&gender="+parent.frames[2].document.getElementById("gender").value;
	var url = "../../eDS/jsp/PlaceSupplementaryOrder.jsp?"+params;
	parent.frames[2].document.location.href=url;
			
	var error="";
	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
}

function apply(){
	var dataModifyFlag=checkDataModification();
	if(dataModifyFlag){
		var error=getMessage("DS_UPD_REC","DS");
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+trim(error);
		return;
	}
	var patientId=$("#patientId").val();
	var encounterId=$("#encounterId").val();
	var locale=$("#locale").val();
	var facility_id=$("#facility_id").val();
	var date=$("#date").val();
	var params="mode=INSERT_SUPPLEMENTARY_MEAL_ORDER";
	params+="&patientId="+patientId;
	params+="&encounterId="+encounterId;
	params+="&locale="+locale;
	params+="&facility_id="+facility_id;
	params+="&date="+date
	params+="&SupplementaryMealsarr="+encodeURIComponent(JSON.stringify(SupplementaryMealsarr));

	var jsonArguments	= {
			'SupplementaryMealsarr':JSON.stringify(SupplementaryMealsarr),
			'mode':'INSERT_SUPPLEMENTARY_MEAL_ORDER',
			'patientId':patientId,
			'encounterId':encounterId,
			'locale':locale,
			'facility_id':facility_id,
			'date':date
		  };

	$.ajax({  
		 url:'../../servlet/eDS.SupplementaryOrderServlet',  
		 type: 'post',  
		 data: jsonArguments,
		 dataType: 'json'
		 
	 });	
	
	//Added Against Start ML-MMOH-CRF-0825-US007
	var suppl_diet_order_yn=$("#suppl_diet_order_yn").val();
	var current_date = document.getElementById("current_date").value;
	var date=new Date();
	var hour=date.getHours();
	if(hour<=9){
		hour="0"+""+hour;
	}
	var minute=date.getMinutes();
	if(minute<=9){
		minute="0"+""+minute;
	}
	var sysTime = hour+":"+minute;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getSuplMealType&facility_id="+facility_id;//+"&mealTypeCode="+mealTypeCode;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);	
	var retVal = trimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("???");
	for(var i=0; i < retVal_arr.length; i++){
		var mealCode_Arr = retVal_arr[i].split(":::");
		var meal_type_code= mealCode_Arr[0];
		var meal_type_desc= mealCode_Arr[1];
		var ServingStartTimeSUP= mealCode_Arr[2];
			if(ServingStartTimeSUP==null || ServingStartTimeSUP=="null" || ServingStartTimeSUP== "undefined"){
				ServingStartTimeSUP="";
			}		
		var ServingEndTimeSUP= mealCode_Arr[3];
			if(ServingEndTimeSUP==null || ServingEndTimeSUP=="null" || ServingEndTimeSUP== "undefined"){
				ServingEndTimeSUP="";
			}
		var IrregularStartTimeSUP= mealCode_Arr[4];
			if(IrregularStartTimeSUP==null || IrregularStartTimeSUP=="null" || IrregularStartTimeSUP== "undefined") 
			IrregularStartTimeSUP="";
		var IrregularEndTimeSUP= mealCode_Arr[5];
			if(IrregularEndTimeSUP==null || IrregularEndTimeSUP=="null" || IrregularEndTimeSUP== "undefined"){
				IrregularEndTimeSUP="";
			}
		var MealOrder= mealCode_Arr[6];
		var nextServingStartTimeSUP= mealCode_Arr[7];
			if(ServingStartTimeSUP=="" && ServingEndTimeSUP=="" && IrregularStartTimeSUP=="" && IrregularEndTimeSUP==""){
			IrregularEndTimeSUP = nextServingStartTimeSUP;
			}
		
		if(suppl_diet_order_yn == "Y" && IrregularStartTimeSUP!="" && IrregularEndTimeSUP!="" && IrregularStartTimeSUP < sysTime && IrregularEndTimeSUP > sysTime){
				var msg=getMessage("DS_IRREGULAR_DIET_ORDER","DS");
				msg=msg.replace("#", current_date);
				msg+=""+meal_type_desc;
			//Added Against ML-MMOH-CRF-0825-US007(ICN-68623) Starts Here
			for (x in SupplementaryMealsarr) 
			{
				var MealTypeValue = SupplementaryMealsarr[x].Meal_Type_Code;
				if(MealTypeValue==meal_type_code){
					alert(msg);
					break ;
				}
			}
			//Added Against ML-MMOH-CRF-0825-US007(ICN-68623) Ends Here
		}
	}
	//Added Against End ML-MMOH-CRF-0825-US007 
	//window.close();
	clearField();
	SupplementaryMealsarr={};
	OnLoad_SupplementaryMealsarr={};
	
	 var params="";
	params+="&encounterId="+parent.frames[2].document.getElementById("encounterId").value;
	params+="&patientId="+parent.frames[2].document.getElementById("patientId").value;
	params+="&locationCode="+parent.frames[2].document.getElementById("locationCode").value;
	params+="&patientClass="+parent.frames[2].document.getElementById("patientClass").value;
	params+="&room="+parent.frames[2].document.getElementById("room").value;
	params+="&bed="+parent.frames[2].document.getElementById("bed").value;
	params+="&locationType="+parent.frames[2].document.getElementById("locationType").value;
	params+="&dateOfBirth="+parent.frames[2].document.getElementById("dateOfBirth").value;
	params+="&gender="+parent.frames[2].document.getElementById("gender").value;
	var url = "../../eDS/jsp/PlaceSupplementaryOrder.jsp?"+params;
	parent.frames[2].document.location.href=url;	
	
	/*getSavedSupplementaryMeal();
	FormSupplementaryOrderTable();*/
	var msg=getMessage("DS_OPER_COMPLETE","DS");
	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+trim(msg);	
	return;
}

async function itemLookUp(){
	var locale=$("#locale").val();
	var itemType=$('#itemtype').val();
	
	var sql = "SELECT A.FOOD_ITEM_CODE CODE, A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.ITEM_TYPE) LIKE UPPER('"+itemType+"') AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID = '"+locale+"'";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = $("#item").val();
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	retArr = await CommonLookup("Food Item", argumentArray);
	var str =unescape(retArr);
	var arr = str.split(",");
	if (retArr != null  && retArr != "") {
		$("#item").val(arr[1]);
		$("#itemcode").val(arr[0]);
	}
}

FormSupplementaryOrderTable = function(){
	var table	= $('#SupplementaryOrderTable');

	$("#SupplementaryOrderTable").find("tr").remove();
			
	var row=$('<tr><th>'+getLabel("Common.date.label","common")+'</th></tr>').addClass("thwrap").appendTo(table);	
	$('<th>'+getLabel("eDS.SupplementaryDietFor.Label","DS")+'</th>').appendTo(row);
	$('<th>'+getLabel("eOT.ItemType.Label","ot_labels")+'</th>').appendTo(row);
	$('<th>'+getLabel("eDS.FoodItem.Label","DS")+'</th>').appendTo(row);
	$('<th>'+getLabel("eOT.qty.Label","ot_labels")+'</th>').appendTo(row);
	$('<th>'+getLabel("eDS.MealType.Label","DS")+'</th>').appendTo(row);
	$('<th>'+getLabel("Common.Instructions.label","common")+'</th>').appendTo(row);
	$('<th><input type="checkbox" name="BulkSelect" id="BulkSelect" id="BulkSelect" onclick="selectDeSelectAll()"></th>').appendTo(row);
	
	var isDataAvailabel=false;
		$.each(SupplementaryMealsarr, function (i, item){
	
			var SupplementaryMealsarrList=item;
	
			var row1=$("<tr><td>"+item.Date+"</td></tr>").appendTo(table);
					
					$('<td align="left">'+item.SupplementaryOrderForDesc+'</td>').appendTo(row1);
					$('<td align="left">'+item.Item_Type_Desc+'</td>').appendTo(row1);
					$('<td align="left"><a class="loadDataClass" id="loadDataLink_"'+item.sno+' name="loadDataLink" href="#" onclick=loadData("'+item.sno+'")>'+item.Item_Desc+'</a></td>').appendTo(row1);
					$('<td align="left">'+item.Qty+'</td>').appendTo(row1);
					if(item.Meal_Type_Desc==" " || item.Meal_Type_Desc=="undefinded"){
						$('<td align="left">&nbsp;</td>').appendTo(row1);
					}else{
					$('<td align="left">'+item.Meal_Type_Desc+'</td>').appendTo(row1);
					}
					if(trim(item.Instructions)==" " || trim(item.Instructions)=="undefined" ||trim(item.Instructions)=="null" || trim(item.Instructions)==""){
						$('<td align="left">&nbsp;</td>').appendTo(row1);
					}else{
					$('<td align="left"style=" word-break: break-all" >'+item.Instructions+'</td>').appendTo(row1);
					}
					var img = "<img src=\"../../eDS/css/exclusions.png\" title=\"Click to Remove\" onclick=\"removeSupplementaryMealItem('"+item.sno+"');\"/>";
					
			//$('<td align="center">'+img+'</td>').appendTo(row1);
			$('<td align="center"><input type="checkbox" class="checkBoxClass" onclick="indivualCheckBoxClicked()" name="selectedItem" id="selectedItem" id="checkbox_"'+item.sno+' value='+item.sno+'></td>').appendTo(row1);
					
			isDataAvailabel=true;		
	
		});
		if(!isDataAvailabel){
			$('#BulkSelect').prop("disabled",true);
		}
		$('#cancelButton').prop("disabled",true);
	return;
}
loadData	=	function(sno){
	var isDisabled = $('.loadDataClass').prop('disabled');
	
	if(isDisabled){return;}
	if(modification_flag){
		if(!window.confirm(getMessage("DS_UNSAVED_CHANGE_LOST","DS"))){
			return;
		}
	}
	$('.checkBoxClass').prop("disabled",true);
	$('#BulkSelect').prop("disabled",true);
	$('#cancelButton').prop("disabled",true);
	loaded_sno=sno;

	var itemlist=SupplementaryMealsarr[sno];
	
	loaded_SupplementaryMeals=itemlist;
	$("#supplementaryfor").val(itemlist.SupplementaryOrderForCode)
	$("#date").val(itemlist.Date);	
	//$("mealType option[value="+itemlist.Meal_Type_Code+"]").attr("selected","selected");	
	
	$("#itemtype").val(itemlist.Item_Type_Code);
	$("#item").val(itemlist.Item_Desc);
	$("#itemcode").val(itemlist.Item_Code);
	$("#qty").val(itemlist.Qty);
	$("#Instructions").val(itemlist.Instructions);
	modification_flag=true;
	loaded_meal_type=itemlist.Meal_Type_Code;
	$("#supplementaryfor").prop("disabled", true);
	return;
}
addSupplementaryFood = function(){

	//first validation
	//Check if the newly adding data are already there or not in the arr (only for insert mode but not for update mode)
	//add to 
	
	var SupplementaryOrderForCode=$('#supplementaryfor').val();
	var SupplementaryOrderForDesc=$('#supplementaryfor :selected').text();
	var Date=$('#date').val();
	//var Meal_Type_Code=$("#mealType").val();
	//var Meal_Type_Desc=$("#mealType :selected").text();
	var Item_Type_Code=$('#itemtype').val();
	var Item_Type_Desc=$('#itemtype :selected').text();
	var Item_Desc=$('#item').val();
	var Item_Code=$('#itemcode').val();
	var Qty=$('#qty').val();
	var Instructions=$('#Instructions').val();	
	var Attendent_Label_Name=$("#Attendent_Label_Name").val();

	var error="";
	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	
	var supplementaryOrderFor_Arr =[];
		if(SupplementaryOrderForCode=="B"){
			supplementaryOrderFor_Arr.push(
			{
				"SupplementaryOrderForDesc":"Patient",
				"SupplementaryOrderForCode":"P"
			},
			{
				"SupplementaryOrderForDesc":Attendent_Label_Name,
				"SupplementaryOrderForCode":"A"
			}
			);
		}else {
			supplementaryOrderFor_Arr.push({
				"SupplementaryOrderForDesc":SupplementaryOrderForDesc,
				"SupplementaryOrderForCode":SupplementaryOrderForCode
			});
		}
	/*var meal_Type_Arr=[];
	$('#mealType option:selected').each(function() {

		meal_Type_Arr.push({
			"Meal_Type_Code":$(this).val(),
			"Meal_Type_Desc":$(this).text()
		});
});*/
	
	var flag=checkSupplementaryFood();//checking for mandatory fields
	if(flag==true){
		//check the data range
		var maximum_days_allowed=$("#maximum_days_allowed").val();
		var date=$('#date').val();
		var locale=$('#locale').val();
		flag=grayOutCalendarValidation(date,maximum_days_allowed);
		if(!flag){
			var sysdate=getCurrentDate("DMH",locale);
			var maxdate=addDays(dtglobal,maximum_days_allowed);		
			var maxToDate=changeDate(maxdate);
			var fieldName=getLabel("Common.date.label","common");
			var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
			var msgArray=msg.split("#");
			var error="";
			//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
			error+=fieldName;
			error+=msgArray[1];
			error+=sysdate;
			error+=msgArray[2];
			error+=maxToDate;
	        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				return
		}
		//check for duplicate record
		flag=checkDuplciateRecord(supplementaryOrderFor_Arr,meal_Type_Arr,Date,Item_Type_Code,Item_Code);
		if(!flag){
			alert(getMessage("DS_FOODITM_EXIST","DS"));
			
		}
	}
	if(flag==true){	
	
	if((modification_flag)){
				SupplementaryMeals={
					"SupplementaryOrderForCode": loaded_SupplementaryMeals.SupplementaryOrderForCode, 
					"SupplementaryOrderForDesc":loaded_SupplementaryMeals.SupplementaryOrderForDesc,
					"Date":  Date,
					"Meal_Type_Code":loaded_SupplementaryMeals.Meal_Type_Code,
					"Meal_Type_Desc":loaded_SupplementaryMeals.Meal_Type_Desc,
					"Item_Type_Code":Item_Type_Code,
					"Item_Type_Desc":Item_Type_Desc,
					"Item_Code":Item_Code,
					"Item_Desc":Item_Desc,
					"Qty":Qty,
					"Instructions":Instructions,
					"Status":loaded_SupplementaryMeals.Status,
					"remarks":loaded_SupplementaryMeals.remarks,
					"sno":loaded_sno
				};
		
		SupplementaryMealsarr[loaded_sno]=SupplementaryMeals;		
		modification_flag=false;
		loaded_sno="";
	}else{
	$.each(supplementaryOrderFor_Arr,function(index) {
			if(meal_Type_Arr.length>0){
			$.each(meal_Type_Arr,function(i){
				SupplementaryMeals={
					"SupplementaryOrderForCode": supplementaryOrderFor_Arr[index].SupplementaryOrderForCode, 
					"SupplementaryOrderForDesc":supplementaryOrderFor_Arr[index].SupplementaryOrderForDesc,
					"Date":  Date,
					"Meal_Type_Code":meal_Type_Arr[i].Meal_Type_Code,
					"Meal_Type_Desc":meal_Type_Arr[i].Meal_Type_Desc,
					"Item_Type_Code":Item_Type_Code,
					"Item_Type_Desc":Item_Type_Desc,
					"Item_Code":Item_Code,
					"Item_Desc":Item_Desc,
					"Qty":Qty,
					"Instructions":Instructions,
					"Status":" ",
					"remarks":" ",
					"sno":sno
				};			
			SupplementaryMealsarr[sno]=SupplementaryMeals;			
				sno=parseInt(sno)+1;
			});
			}else{
				SupplementaryMeals={
					"SupplementaryOrderForCode": supplementaryOrderFor_Arr[index].SupplementaryOrderForCode, 
					"SupplementaryOrderForDesc":supplementaryOrderFor_Arr[index].SupplementaryOrderForDesc,
					"Date":  Date,
					"Meal_Type_Code":" ",
					"Meal_Type_Desc":" ",
					"Item_Type_Code":Item_Type_Code,
					"Item_Type_Desc":Item_Type_Desc,
					"Item_Code":Item_Code,
					"Item_Desc":Item_Desc,
					"Qty":Qty,
					"Instructions":Instructions,
					"Status":" ",
					"remarks":" ",
					"sno":sno				
			}			
			SupplementaryMealsarr[sno]=SupplementaryMeals;			
			sno=parseInt(sno)+1;
			}
			
	});//supplementaryOrderFor_Arr iterates ends
	}
	
	FormSupplementaryOrderTable();
	clearField();
	$('.checkBoxClass').prop("disabled",false);
	$('#BulkSelect').prop("disabled",false);
	$('#cancelButton').prop("disabled",true);
	}//if ends
	return;
}//addSupplementaryFood ends
checkSupplementaryFood = function(){	
	var SupplementaryOrderForCode=$('#supplementaryfor').val();
	var SupplementaryOrderForDesc=$('#supplementaryfor :selected').text();
	var date=$('#date').val();
	var itemtype_code=$('#itemtype').val();
	var itemtype_desc=$('#itemtype :selected').text();
	var item_desc=$('#item').val();
	var item_code=$('#itemcode').val();
	var qty=$('#qty').val();
	var Instructions=$('#Instructions').val();
	var flag=true;
	
	var error="";
	if(date=='' || date=='null' || date=='undefined'){
		var field=getLabel("Common.date.label","common");
		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace("$",field);
		//alert(msg);
		error+=msg+"<br>";
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
		flag=false;
	//}else if(itemtype_desc=='' || itemtype_desc=='null' || itemtype_desc=='undefined'){
	//}else if(itemtype_code=='' || itemtype_code=='null' || itemtype_code=='undefined'){
	}if(itemtype_code=='' || itemtype_code=='null' || itemtype_code=='undefined'){
		//alert("itemtype_desc is blank");//ItemType
		var field=getLabel("eOT.ItemType.Label","OT");
		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace("$",field);
		//alert(msg);
		error+=msg+"<br>";
		flag=false;
	//}else if(item_desc=='' || item_desc=='null' || item_desc=='undefined'){
	}if(item_desc=='' || item_desc=='null' || item_desc=='undefined'){	
		var field=getLabel("eDS.FoodItem.Label","DS");
		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace("$",field);
		//alert(msg);		
		error+=msg+"<br>";
		flag=false;
	//}else if(qty=='' || qty=='null' || qty=='undefined'){
	}if(qty=='' || qty=='null' || qty=='undefined'){
		var field=getLabel("eOT.qty.Label","OT");
		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace("$",field);
		//alert(msg);
		error+=msg+"<br>";
		flag=false;
	//}else if(parseInt(qty)<=0){
	}if(parseInt(qty)<=0){
		var field=getLabel("eOT.qty.Label","OT");
		var msg=getMessage("CANNOT_BE_ZERO","OT");
		//alert(field);//Commented 06-Sep-16
		msg=msg.replace("&",field);
		//alert(msg);
		error+=msg+"<br>";
		flag=false;
	}
	if(!flag){
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+trim(error);
	}
	return flag;
	return;
}

loadPatientInfo = function(){
	var params="";
	var patientId=$("#patientId").val();
	var encounterId=$("#encounterId").val();
	var facility_id=$("#facility_id").val();
	var url="../../eCommon/jsp/pline.jsp?";
	params+="Patient_ID="+patientId;
	params+="&EncounterId="+encounterId;
	params+="&Facility_Id="+facility_id;

	var source=url+params;
	$("#PatientBanner").load(source);
	return;
}

function checkDuplciateRecord(supplementaryOrderFor_Arr,meal_Type_Arr,Date,Item_Type_Code,Item_Code){
var tempSupplementaryMeals={};
	
var flag=true;
	
	if(modification_flag){
	
		$.each(SupplementaryMealsarr, function (i, item){
			
			var SupplementaryMealsarrList=item;
	
				if(loaded_sno!=item.sno){
	
					if(item.Date==tempSupplementaryMeals.Date && 
						item.SupplementaryOrderForCode==tempSupplementaryMeals.SupplementaryOrderForCode &&
						item.Meal_Type_Code==tempSupplementaryMeals.Meal_Type_Code &&
						item.Item_Type_Code==tempSupplementaryMeals.Item_Type_Code &&
						item.Item_Code==tempSupplementaryMeals.Item_Code 
					){
						flag=false;
					}
				}
			
		});	
	}else{
	$.each(supplementaryOrderFor_Arr,function(index) {
			if(meal_Type_Arr.length>0){
			$.each(meal_Type_Arr,function(i){
					tempSupplementaryMeals={
					"SupplementaryOrderForCode": supplementaryOrderFor_Arr[index].SupplementaryOrderForCode,
					"Date":  Date,
					"Meal_Type_Code":meal_Type_Arr[i].Meal_Type_Code,
					"Item_Type_Code":Item_Type_Code,
					"Item_Code":Item_Code
				};				
				
				$.each(SupplementaryMealsarr, function (i, item){					
					var SupplementaryMealsarrList=item;
					if(item.Date==tempSupplementaryMeals.Date && 
						item.SupplementaryOrderForCode==tempSupplementaryMeals.SupplementaryOrderForCode &&
						item.Meal_Type_Code==tempSupplementaryMeals.Meal_Type_Code &&
						item.Item_Type_Code==tempSupplementaryMeals.Item_Type_Code &&
						item.Item_Code==tempSupplementaryMeals.Item_Code						
					){						
						flag=false;
					}
				});				
			});
			}else{
					tempSupplementaryMeals={
					"SupplementaryOrderForCode": supplementaryOrderFor_Arr[index].SupplementaryOrderForCode,
					"Date":  Date,
					"Meal_Type_Code":" ",
					"Item_Type_Code":Item_Type_Code,
					"Item_Code":Item_Code
				};
				$.each(SupplementaryMealsarr, function (i, item){					
					var SupplementaryMealsarrList=item;
					if(item.Date==tempSupplementaryMeals.Date && 
						item.SupplementaryOrderForCode==tempSupplementaryMeals.SupplementaryOrderForCode &&
						item.Meal_Type_Code==tempSupplementaryMeals.Meal_Type_Code &&
						item.Item_Type_Code==tempSupplementaryMeals.Item_Type_Code &&
						item.Item_Code==tempSupplementaryMeals.Item_Code						
					){
						flag=false;
					}
				});	
			}
	});
	}

	return flag;
}
getSavedSupplementaryMeal	=	function(){	
	var patientId=$("#patientId").val();
	var encounterId=$("#encounterId").val();
	var locale=$("#locale").val();
	var facility_id=$("#facility_id").val();
	var date=$("#date").val();
	var params="mode=Get_SUPPLEMENTARY_MEAL_ORDER";
	params+="&patientId="+patientId;
	params+="&encounterId="+encounterId;
	params+="&locale="+locale;
	params+="&facility_id="+facility_id;
	params+="&Record_type=Current_And_Future";	
	var OldDataExist=false;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.SupplementaryOrderServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;

	//SupplementaryMealsarr
	var jsonObjResponse=eval('(' + retVal + ')');

	var tempSupplementaryMeals=new Array();
	tempSupplementaryMeals = jsonObjResponse;
	sno=1;
	$.each(tempSupplementaryMeals, function (i, item){
			
		SupplementaryMealsarr[sno]=item;
		OnLoad_SupplementaryMealsarr[sno]=item;
		sno=parseInt(sno)+1;
		OldDataExist=true;
			
	});
	if(!OldDataExist){
		sno=1;
	}
	return;
}
viewAllRecord	= 	function(){

	var encounterId=$("#encounterId").val();
	var locale=$("#locale").val();
	var facility_id=$("#facility_id").val();
	
	var params="";
	
	params+="encounter_id="+encounterId;
	params+="&locale="+locale;
	params+="&facility_id="+facility_id;


	
	var url = "../../eDS/jsp/DisplayOldSupplementaryOrder.jsp?"+params;
	var dialogFeatures = "dialogHeight:" + "600px" + "; dialogWidth:" + "900px" + "; scroll:no; status:no;";
	var arguments = "";
	var returnVal =  window.showModalDialog(url, arguments, dialogFeatures);
	
}

function removeSupplementaryMealItem(sno){
	delete SupplementaryMealsarr[sno];	
		//FormSupplementaryOrderTable();
}
function clearField(){
	$("#supplementaryfor").val("B")
	$("#date").val("");	
	//$("mealType option[value="+itemlist.Meal_Type_Code+"]").attr("selected","selected");	
	
	$("#itemtype").val("");
	$("#item").val("");
	$("#itemcode").val("");
	$("#qty").val("");
	$("#Instructions").val("");
	meal_Type_Arr=[];
	$("#supplementaryfor").prop("disabled", false);
	return;
}
function grayOutCalendar(fieldid,p_maxdate,locale){
		var dt=new Date();
		var c_date=dt.getDate();
		var c_month=dt.getMonth();
		var c_year=dt.getFullYear();
		if(locale=="th"){
			c_year=c_year+543;
		}
		var setdate=new Date(c_year,c_month,c_date);
		var max_date=addDays(setdate,p_maxdate);
		$.datepicker.setDefaults($.extend({showMonthAfterYear: false}, $.datepicker.regional[locale]));
		$("#"+fieldid).datepicker({
		dateFormat:'dd/mm/yy',
		minDate:setdate ,
		maxDate:max_date,
		showOn: 'image',
		changeYear:true
		});
			$('#'+fieldid).focusin(function(){
			$('#'+fieldid).datepicker('widget').css({top: '25%',left: '50%'});
		});
		$('#'+fieldid).datepicker('show');
}

	checkDataModification=function(){

	var origArrayGroups = OnLoad_SupplementaryMealsarr;
	var modifiedArrayGroups = SupplementaryMealsarr;
	var closeWindowFlag=true;
	var modifyFlag=true;

	var on_load_count = getCount(OnLoad_SupplementaryMealsarr);
	var new_count = getCount(SupplementaryMealsarr);

	if(on_load_count!=new_count){
		modifyFlag=false;
	}

	var diff = {};
	for (var prop in modifiedArrayGroups) {
	    if(modifiedArrayGroups[prop] != origArrayGroups[prop])
	    {
	        diff[prop] = origArrayGroups[prop];
			modifyFlag=false;
	    }    
	};	

	return modifyFlag;
	}
function getCount(obj) {
    var count = 0,
        prop;
    for (prop in obj) {
        if (obj.hasOwnProperty(prop) ) {
            count += 1;
        }
    }
    return count;
}
async function mealTypeSpFoodItems(obj,fecthedMealTypes)
{
		if(modification_flag){
		var mealtype=loaded_meal_type;
		
		if(trimString(mealtype)==""){
			mealtype="N";
		}
		}else{
			mealtype="";
		}
		fecthedMealTypes=fecthedMealTypes.substring(0,(fecthedMealTypes.length-1));		
		var dialogUrl1 = "../../eDS/jsp/MealTypesForFrequency.jsp?&fecthedMealTypes="+fecthedMealTypes+"&mealtype="+mealtype;
		var dialogArguments = mealTypesArray;
		var dialogFeatures = "dialogHeight:12;dialogWidth:15;status:no;scroll:no";
		var returnVal =await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
				
		if(returnVal!="" && returnVal!="null" && returnVal!="undefined" && returnVal!=undefined)
		{
		var retValArr=returnVal.split("*");

		meal_Type_Arr=[];
		$.each(retValArr, function (i, item){
			var indivaualmealarr=item.split("@");
			if(indivaualmealarr.length>0){
			if(indivaualmealarr[0]!="" && indivaualmealarr[1]!=""){
			meal_Type_Arr.push({
			"Meal_Type_Code":indivaualmealarr[0],
			"Meal_Type_Desc":indivaualmealarr[1].replace("#"," ")
			});				
			}
			}
		});
		}			
}

selectDeSelectAll	=function(){
    $("#BulkSelect").click(function () {
	var link = $(".loadDataClass");
        $(".checkBoxClass").prop('checked', $(this).prop('checked'));
	if($(this).prop('checked')){
		link.prop('disabled',true);
		$('#cancelButton').prop("disabled",false);
	}else{
		link.prop('disabled',false);
		$('#cancelButton').prop("disabled",true);
	}
    });
}

indivualCheckBoxClicked	= function(){
		if($(".checkBoxClass").length == $(".checkBoxClass:checked").length) {
			$("#BulkSelect").attr("checked", "checked");
		} else {
			$("#BulkSelect").removeAttr("checked");
		}
		var link = $(".loadDataClass");
		var href = $('.loadDataClass').attr('href');
		
		if($(".checkBoxClass:checked").length>0){

			//link.removeAttr("href",href);
			//link.data('disabled');
			link.prop('disabled',true);			
			$('#cancelButton').prop("disabled",false);
			
		}else{
			
			//link.attr("href", link.data("href"));
			//link.attr("href", href);
			link.prop('disabled',false);
			$('#cancelButton').prop("disabled",true);
			
		}
		}
	//});
	//});
RemoveItem =function(){
	var RemoveItem = [];
            $.each($("input[name='selectedItem']:checked"), function(){            
                RemoveItem.push($(this).val());
				removeSupplementaryMealItem($(this).val());
            });
			FormSupplementaryOrderTable();			
}

function addDays(theDate, days) {
    return new Date(theDate.getTime() + days*24*60*60*1000);
}

function grayOutCalendarValidation(p_selecteddate,p_maxdate){
	var maxdate=p_maxdate;
	var date = addDays(new Date(), p_maxdate);
	var date1=date.getDate();
	var month=date.getMonth();
	var year=date.getFullYear();
	var locale=$("#locale").val();
	var selecteddate=p_selecteddate;

	month+=1;
		if(date1<=9){
				date1="0"+""+date1;
			    }
		if(month<=9){
				month="0"+""+month;
			    }
	var futDate=date1 + "/" + month + "/" + year;
	selecteddate = convertDate(selecteddate,'DMY',locale,'en');

	var flag = compareDate(futDate,selecteddate);
	if(flag==-1){
			return false;
		   }
	else{
		var sysdate=getCurrentDate("DMH",'en');
		flag=compareDate(selecteddate,sysdate);
		if(flag==-1){
			return false;
		}else{
		return true;
		}
	}
}

function changeDate(date){
	//var date= new Date(theDate.getTime() + days*24*60*60*1000);
	var date1=date.getDate();
	var month=date.getMonth();
	var year=date.getFullYear();
	var locale=$("#locale").val();
	month+=1;
		if(date1<=9){
				date1="0"+""+date1;
			    }
		if(month<=9){
				month="0"+""+month;
			    }
	var futDate=date1 + "/" + month + "/" + year;
	futDate = convertDate(futDate,'DMY','en',locale);
	return futDate;
}

function textAreaLimit(field, maxlen) {
	if (field.value.length > maxlen + 1){
		var strMsg = getMessage("DS_MAXLEN_CHARS","DS");
		$("#"+field.id).focus();
		$("#"+field.id).select();
		
		var arrMsg = strMsg.split("#");
		alert(arrMsg[0] + maxlen + arrMsg[1]);
		return;
	}
	if (field.value.length > maxlen)
	field.value = field.value.substring(0, maxlen);
}
clearFoodItem	=function(){
	$("#itemcode").val("");
	$("#item").val("");

}

