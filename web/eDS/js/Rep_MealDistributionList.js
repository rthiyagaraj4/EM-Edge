	function checkNull(){
		var flag;
	 	var error="";
	 	var formObj = parent.content.f_query_rep.MealDistributionListForm;


	 	var date=formObj.date.value;
	 	var date_label=getLabel("Common.date.label","Common");

	 	var kitchen=formObj.kitchen.value;
	 	var kitchen_label=getLabel("eOT.Kitchen.Label","OT");

	 	if(date=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",date_label)+"<br>";
	 	}
	 	if(kitchen=="") {
	 		flag=false;
	 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_label)+"<br>";
	 	}
	 	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
		if(flag==false) return false; else return true;
	 }

	 function getItemCode(mode){
		if(document.MealDistributionListForm["itemCodeFrom"].value!=""){
			showLookup(mode);
		}
	 }

async function showLookup(mode){

		var itemCodeFrom = document.MealDistributionListForm["itemCodeFrom"];
		var itemCodeTo = document.MealDistributionListForm["itemCodeTo"];

		var itemTypeFrom = document.MealDistributionListForm["itemTypeFrom"];
		var itemTypeTo = document.MealDistributionListForm["itemTypeTo"];

		var itemCodeHiddenFrom = document.MealDistributionListForm["Hid_itemCodeFrom"];
		var itemCodeHiddenTo = document.MealDistributionListForm["Hid_itemCodeTo"];

		var itemCode=(mode=="Item_Code_From")?itemCodeFrom.value:itemCodeTo.value;
		var itemType=(mode=="Item_Code_From")?itemTypeFrom.value:itemTypeTo.value;

		var formObj = document.forms[0];
		var locale = document.MealDistributionListForm["locale"].value;
		var result = false;
		var message = "";
		var flag = "";
		var function_id = "";
		var argumentArray = new Array();
		var dataNameArray = new Array();
		var dataValueArray = new Array();
		var dataTypeArray = new Array();
		var sql="select A.food_item_code code,A.short_desc description from ds_items A where A.eff_status = 'E' and A.item_type = '"+itemType+"' and A.language_id = '"+locale+"' and upper(A.SHORT_DESC) like upper(?) and upper(A.food_item_code) like upper(?) order by 2";

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = itemCode;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		var title = "TITLE";
		retArr = await CommonLookup(title, argumentArray);
		if(retArr!=null && retArr != undefined && retArr != ''){
			var ret1=unescape(retArr);
		 	arr=ret1.split(",");
			if(mode=="Item_Code_From"){
			itemCodeFrom.value=arr[1];
			itemCodeHiddenFrom.value = arr[0];
			}else{
			itemCodeTo.value=arr[1];
			itemCodeHiddenTo.value = arr[0];
			}
		}
	}

	 function run() {
		var flag = checkNull();
		if(flag==true){
			getConvertDate();

		}
	 }
	function clearFields(){
		if(document.MealDistributionListForm["itemCodeFrom"].value =="")
			document.MealDistributionListForm["PARAM10"].value = ""
		else
			document.MealDistributionListForm["PARAM10"].value = document.MealDistributionListForm["Hid_itemCodeFrom"].value
		if(document.MealDistributionListForm["itemCodeTo"].value =="")
			document.MealDistributionListForm["PARAM11"].value = "";
		else
			document.MealDistributionListForm["PARAM11"].value = document.MealDistributionListForm["Hid_itemCodeTo"].value
	}
	function getConvertDate(){
		var locale=parent.content.f_query_rep.MealDistributionListForm["locale"].value
		var datepattrn=parent.content.f_query_rep.MealDistributionListForm["datepattrn"].value
		var date=parent.content.f_query_rep.MealDistributionListForm["date"].value
        var isMealType=parent.content.f_query_rep.MealDistributionListForm["isMealType"].value;//Added against ML-MMOH-CRF-1965
			//content.IBADateValidator.convertDateJS(date,locale,'en',datepattrn,callBackFromDate);
			//function callBackFromDate(mealDistDate){

				parent.content.f_query_rep.MealDistributionListForm["PARAM1"].value = date;
				parent.content.f_query_rep.MealDistributionListForm["p_report_id"].value = "DSRMLDST";
				parent.content.f_query_rep.MealDistributionListForm["report_id"].value = "DSRMLDST";
				parent.content.f_query_rep.MealDistributionListForm["P_kitchen_code"].value = parent.content.f_query_rep.MealDistributionListForm["kitchen"].value;
				parent.content.f_query_rep.MealDistributionListForm["PARAM2"].value = parent.content.f_query_rep.MealDistributionListForm["wardCodeFrom"].value
				parent.content.f_query_rep.MealDistributionListForm["PARAM3"].value = parent.content.f_query_rep.MealDistributionListForm["wardCodeTo"].value
				parent.content.f_query_rep.MealDistributionListForm["PARAM4"].value = parent.content.f_query_rep.MealDistributionListForm["dietTypeFrom"].value
				parent.content.f_query_rep.MealDistributionListForm["PARAM5"].value = parent.content.f_query_rep.MealDistributionListForm["dietTypeTo"].value
				parent.content.f_query_rep.MealDistributionListForm["PARAM6"].value = parent.content.f_query_rep.MealDistributionListForm["mealClassFrom"].value
				parent.content.f_query_rep.MealDistributionListForm["PARAM7"].value = parent.content.f_query_rep.MealDistributionListForm["mealClassTo"].value
				parent.content.f_query_rep.MealDistributionListForm["PARAM8"].value = parent.content.f_query_rep.MealDistributionListForm["itemTypeFrom"].value
				parent.content.f_query_rep.MealDistributionListForm["PARAM9"].value = parent.content.f_query_rep.MealDistributionListForm["itemTypeTo"].value
				//Added Against ML-MMOH-CRF-1965...starts
			    
               			if(isMealType == "true"){ 
				parent.content.f_query_rep.MealDistributionListForm["P_meal_type"].value = parent.content.f_query_rep.MealDistributionListForm["mealType"].value
				}
				//Added Against ML-MMOH-CRF-1965...ends
				var formObj=parent.content.f_query_rep.MealDistributionListForm;
				formObj.action= "../../eCommon/jsp/report_options.jsp";
				formObj.submit();

			//}

		}
// modified by N Munisekhar on 20-May-2013 against [IN039994]
	function reset(){
	  var formObj = parent.content.f_query_rep.MealDistributionListForm;
	  formObj.reset();
//		content.location.href = contextPath+"/MealDistributionListAction.do?method="+loadMethod
		}

	function getSysDate(){
		//var locale = document.getElementById("locale").value;
		var locale=document.MealDistributionListForm["locale"].value;
		var currentTime = new Date()
		var month = currentTime.getMonth() + 1;
		var day = currentTime.getDate();
		var year = currentTime.getFullYear();
		if(month < 10)
			month="0"+month;
		if(day < 10)
			day="0"+day;
		sysDate = day+"/"+month+"/"+year;
		var date=convertDate(sysDate,'DMY','en',locale);
		document.MealDistributionListForm["date"].value=date;
	}

	function isValidDate(obj){
		if(obj.value!=""){
			var flag=true;
			var RE_NUM =  /^\/?\d+$/;
			var str_date = obj.value;
			var arr_date = str_date.split('/');
			if (arr_date.length != 3) {
//				alert(getMessage('INVALID_DATE_FMT','SM'));
				alert("APP-SM0035 Invalid Date Format");
				obj.focus;
				return;
			}

			if(arr_date[0]!=null)
			{
			if (arr_date[0].length !=2 ) flag=false;
			}
			if(arr_date[1]!=null)
			{
			if (arr_date[1].length !=2 ) flag=false;
			}
			if(arr_date[2]!=null)
			{
			if (arr_date[2].length !=4 ) flag=false;
			}
			if (!arr_date[0]) flag=false;
			if (!RE_NUM.exec(arr_date[0])) flag=false;
			if (!arr_date[1]) flag=false;
			if (!RE_NUM.exec(arr_date[1])) flag=false;
			if (!arr_date[2]) flag=false;
			if (arr_date[2].length!=4) flag=false;
			var dt_date = new Date();
			dt_date.setDate(1);
			if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
			dt_date.setMonth(arr_date[1]-1);
			var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
			dt_date.setDate(arr_date[0]);
			if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

			if (flag==false){
//				alert(getMessage('INVALID_DATE_FMT','SM'));
				alert("APP-SM0035 Invalid Date Format");
				obj.focus;
				return;
			}
		}

		return true;
	}

	function showCal(id, format, showsTime, showsOtherMonths, name) {
		fmt = format;
		{
			calend = format;
			if (showsTime) {
				time = true;
			} else {
				time = false;
			}

			var cal;
			currentDateElement = document.getElementById(id);
			cal = new PopupWindow();
			cal.offsetX = 50;
			cal.offsetY = 50;
			cal.setSize(250, 200);
			cal.autoHide();
			cal.setUrl("../../framework/jsp/Calendar.jsp");
			cal.refresh();
			cal.showPopup(name);
			return false;
		}
	}
