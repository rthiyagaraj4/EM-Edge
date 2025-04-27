//Newly Created for KDAH-CRF-0359.1
//Global variable for DietType
var dietTypesArray = new Array();
var dietArray = new Array();	
var dietSelectedArray = new Array();
var dietTypeStr;
var k1=0;//ICN-064175
var dietflag=0;
//Global variable for MealType
var mealTypesArray = new Array();
var mealArray = new Array();
var mealSelectedArray = new Array();
var mealTypeStr;
var z1=0;//ICN-064175
var mealflag=0;
//Global Variable for Result Menu
//ICN-64263
var menucount=1;
var menucount2=15;
function apply()
 {
 if(FoodItemModifyCriteria.document.forms[0].ExistingFoodItem.value=="")
		{			
		    var error =getMessage('DS_EXISTING_ITEM_CHECK','DS');
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
			return false;
		
		}

else if(FoodItemModifyCriteria.document.forms[0].NewFoodItem.value=="")
		{			
		    var error =getMessage('DS_NEW_ITEM_CHECK','DS');
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
			return false;
		
		}
		else
		{	
		var selectedMenus=FoodItemModifyCriteria.document.forms[0].selectedMenus.value;

		var selectedMenusArray=selectedMenus.split(",");
		selectedMenus="";
		for (var i=0; i < selectedMenusArray.length; i++)
		{
		if(i != (selectedMenusArray.length)-1)
		selectedMenus+="'"+selectedMenusArray[i]+"'"+",";
		else
		selectedMenus+="'"+selectedMenusArray[i]+"'";
		}
		
		var NewFoodItemCode=FoodItemModifyCriteria.document.forms[0].NewFoodItem.value;
		var ExistingFoodItem=FoodItemModifyCriteria.document.forms[0].ExistingFoodItem.value;
		var facility_id=FoodItemModifyCriteria.document.forms[0].facility_id.value;
		var Modified_By_Id=FoodItemModifyCriteria.document.forms[0].Modified_By_Id.value;
		var Modified_At_Ws_No=FoodItemModifyCriteria.document.forms[0].Modified_At_Ws_No.value;
		
		
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlHttp.open("POST","../../servlet/eDS.FoodItemModifyServlet",false);	
	xmlHttp.open("POST","../../servlet/eDS.FoodItemModifyServlet?selectedMenus="+selectedMenus+"&NewFoodItemCode="+NewFoodItemCode+"&ExistingFoodItem="+ExistingFoodItem+"&facility_id="+facility_id+"&Modified_By_Id="+Modified_By_Id+"&Modified_At_Ws_No="+Modified_At_Ws_No,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 

messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + retVal;
		
		//var formObj = FoodItemModifyCriteria.document.forms[0];
			/*formObj.method='post';
			formObj.action="../../servlet/eDS.FoodItemModifyServlet";*/
			//formObj.submit();
			//return true;
			//alert("error"+error);
			   //var error1 ="Operation Compl";
			//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + retVal;
		
		}
 }

async function ItemLookup(obj) {	
clearFilter();
	var locale = document.getElementById("language_id").value;	
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT A.FOOD_ITEM_CODE CODE,A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID LIKE '"+locale+"'";    
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retArr = await CommonLookup("Item", argumentArray);
  if(retArr.length == 1){
      retArr = retArr[0].split(',');
  }
	if (retArr != null && retArr != "")
	{ 
  		document.getElementById("ExistingFoodItem").value = retArr[0];
  		document.getElementById("ExistingFoodDesc").value = retArr[1];
	}
} 

async function ItemLookupNew(obj) 
  {	
	var locale = document.getElementById("language_id").value;	
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT A.FOOD_ITEM_CODE CODE,A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID LIKE '"+locale+"'";    
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retArr = await CommonLookup("Item", argumentArray);
  if(retArr.length == 1){
      retArr = retArr[0].split(',');
  }
	if (retArr != null && retArr != "") 
	{
		document.getElementById("NewFoodItem").value = retArr[0];
		document.getElementById("NewFoodDesc").value = retArr[1];
	}
  }

function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
    return "";
}

//Starts for DietTypes
async function dietTypeFoodItems(fetchedDietTypes)
{		
		var ExistingItemcode=document.getElementById("ExistingFoodItem").value;		
		var diettype = document.getElementById("diettype").value; 
		var dialogUrl1 = "../../eDS/jsp/DietTypesForFoodItemModify.jsp?&fetchedDietTypes="+fetchedDietTypes+"&diettype="+diettype+"&ExistingItemcode="+ExistingItemcode;		
		var dialogArguments = dietTypesArray;		
	    var dialogFeatures = "dialogHeight:11.5;dialogWidth:15;status:no;scroll:no";
		returnVal2 = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
    // console.log("dietTypeFoodItems" + returnVal2);		
	if(returnVal2)
	 {
			var dietcode="";
			var diettypeselected="";	
			var dietArraynew = new Array();
			var dietArraynew = returnVal2.split("*");	
		for (var i1=0; i1 < dietArraynew.length;i1++)
		{	
			var temp=dietArraynew[i1].indexOf("@");
			if(i1==dietArraynew.length-1)
			{		
				diettypeselected+=dietArraynew[i1].substring(0,temp).split("_").join(" ");			
				dietcode+="'"+dietArraynew[i1].substring(0,temp).split("_").join(" ")+"'";			
							
			}
		   else
		   {		  
			   diettypeselected+=dietArraynew[i1].substring(0,temp).split("_").join(" ")+",";
			   dietcode+="'"+dietArraynew[i1].substring(0,temp).split("_").join(" ")+"'"+",";		   
			   
		   }
		}	
		document.getElementById("diettype").value="";
		document.getElementById("diettype").value=diettypeselected;
		document.getElementById("dietcode").value="";
		document.getElementById("dietcode").value=dietcode;
		document.getElementById("dietTypesId").style.display="none";
		document.getElementById("dietfilter").style.display="";	
		document.getElementById("diettypelabel").style.display="none";
		document.getElementById("diettypelink").style.display="";	
		document.getElementById("clearFilter").style.display="";		
	}
	else
	{
		if(dietflag == 1)
		{
			dietflag=0;
			document.getElementById("diettype").value="";
			document.getElementById("dietcode").value="";
		}
	}
}		

function getDietTypes(fetchedDietTypes,diettype)
 {
    	var dietArray = fetchedDietTypes.split(",");
	var dietSelectedArray=diettype.split(",");	
	var tableObj = null;
	var found_flag = false;
	var code = null;
	var dietTypeDesc;
	tableObj = document.getElementById("AbleM");
	var selObj = "";
	var row_ind = 0;				
	for (var i=0; i < dietArray.length;)
		{
			var sel="";
			if( i % 2 == 0)
			{
				var newRow = tableObj.insertRow(row_ind);
				
				var newCellDesc = newRow.insertCell(newRow.cells.length);
				
				newCellDesc.className = "label";
				
				if(dietArray[i+1] != null && dietArray[i+1] != 'undefined' && dietArray[i+1] != undefined)
					newCellDesc.appendChild(document.createTextNode(dietArray[i+1]));
				sel="<input type='hidden' name='diettype' id='diettype'"+row_ind+" value='"+dietArray[i]+"'>";
				var newCellCBox = newRow.insertCell(newRow.cells.length);
				
				var dietTypesind="dietType_"+row_ind;
				
				if(dietArray[i+1] != null && dietArray[i+1] != 'undefined')
					dietTypeDesc = dietArray[i+1];
					
				if(dietTypeDesc != "" && dietTypeDesc != "undefined" && dietTypeDesc != null && dietTypeDesc != undefined)
				{
					var dietTypeDescArr = dietTypeDesc.split(" ");
					for(var j=1 ; j <=dietTypeDescArr.length;j++)
					{
						dietTypeDesc = dietTypeDesc.replace(" ","#");
					}
				}
				if(dietTypeDesc != "undefined" && dietTypeDesc != null)
				{
				var temp_diet=dietArray[i];
				
			   temp_diet=temp_diet.split(' ').join('_');
				
					//code = dietArray[i]+"@"+dietTypeDesc;	
					code = temp_diet+"@"+dietTypeDesc;	
					}

				
			var checkedYn = ""
			var disabledYn = "";			
			for(var m=0;m<dietSelectedArray.length;m++)
			{
				if(dietArray[i] != null && dietSelectedArray[m]==trim(dietArray[i]))
				 checkedYn="checked";
			}
				
			if((diettype == "" || diettype == "null") && (code != null))
				sel+="<input type=\"checkbox\" value=" +code+ " name=" + dietTypesind + " id=" + dietTypesind + " "+checkedYn+" onclick=\"setStatus1("+row_ind+",this.value)\" >"
			else if(code != null && code != undefined)
				sel+="<input type=\"checkbox\" value=" +code+ " name=" + dietTypesind + " id=" + dietTypesind + " "+checkedYn+" "+"disabled = true onclick=\"setStatus1("+row_ind+",this.value)\" >"
			newCellCBox.innerHTML = sel;
			row_ind++;
		}
			i++;
	}
	
}

function getDietTypesFoodItems() {
		for (var i=0; i < dietTypesArray.length ;i++ )
		{
			if(dietTypesArray[i] == undefined){
				dietTypesArray[i] = "";
			}
		}	
	dietTypeStr=dietTypesArray.join("*");	
	parent.document.getElementById('dialog-body').contentWindow.returnValue = dietTypeStr;
//	top.returnValue = dietTypeStr;
	parent.document.getElementById("dialog_tag").close(); 
}

function setStatus1(ind,dietTypes)
{
	chkBox = document.getElementById(("dietType_" + ind));		
	var temp=document.getElementById(("dietType" + ind));
	if(chkBox != null || chkBox != "")
	{
		if(chkBox.checked == true)
		{		
			dietTypesArray[ind]=dietTypes;			
			k1++;
			//ICN-064175
			if(k1 >= document.getElementById("dietmaxRecord").value)			
		            document.getElementById("dietTypeSelectAll").checked=true;			
		  }
		else
		{ 
			document.getElementById("dietTypeSelectAll").checked=false;
		    	dietTypesArray[ind]="";
			k1--;//ICN-064175
		}
	}
}

function getdietTypeSelectAll(obj,maxRecord)
{ 
		k1=0;//ICN-064175
		if(document.getElementById('dietTypeSelectAll').checked)
		{
			for (var i=0; i < maxRecord;i++)
			{	
				document.getElementById("dietType_"+i).checked=true;
				setStatus1(i,document.getElementById("dietType_"+i).value);
			}
		}
		else
		{
			for (var i=0; i < maxRecord;i++)
			{	
				dietTypesArray.length=0;
				document.getElementById("dietType_"+i).checked=false;
				dietflag=1;
				k1=0;//ICN-064175
			}
		}
}

//MealTypes Lookup
async function mealTypeSpFoodItems(fetchedMealTypes)
{
		var ExistingItemcode=document.getElementById("ExistingFoodItem").value;
		var dietcode=document.getElementById("dietcode").value;		
		var mealtype = document.getElementById("mealtype").value;		
		var dialogUrl1 = "../../eDS/jsp/MealTypesForFoodItemModify.jsp?&fetchedMealTypes="+fetchedMealTypes+"&mealtype="+mealtype+"&dietcode="+dietcode+"&ExistingItemcode="+ExistingItemcode;
		var dialogArguments = mealTypesArray;	
		var dialogFeatures = "dialogHeight:11.5;dialogWidth:15;status:no;scroll:no";
		returnVal2 = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);	
		console.log("mealTypeSpFoodItems: " + returnVal2);
    if(returnVal2)
		{
			var mealcode="";
			var mealtypeselected="";			
            		var mealArraynew = new Array();
			var mealArraynew = returnVal2.split("*");			
			for (var i1=0; i1 < mealArraynew.length;i1++)
			{			
				var temp=mealArraynew[i1].indexOf("@");
				if(i1==mealArraynew.length-1)
				{
				
					/*mealtypeselected+=mealArraynew[i1].substring(0,temp);
					mealcode+="'"+mealArraynew[i1].substring(0,temp)+"'";*/
					mealtypeselected+=mealArraynew[i1].substring(0,temp).split("_").join(" ");
					mealcode+="'"+mealArraynew[i1].substring(0,temp).split("_").join(" ")+"'";
				}
			   else
			   {
				  /* mealtypeselected+=mealArraynew[i1].substring(0,temp)+",";
				   mealcode+="'"+mealArraynew[i1].substring(0,temp)+"'"+",";*/
				   mealtypeselected+=mealArraynew[i1].substring(0,temp).split("_").join(" ")+",";
				   mealcode+="'"+mealArraynew[i1].substring(0,temp).split("_").join(" ")+"'"+",";
			   }
			}			
			document.getElementById("mealtype").value="";
			document.getElementById("mealtype").value=mealtypeselected;
			document.getElementById("mealcode").value="";
			document.getElementById("mealcode").value=mealcode;
			document.getElementById("mealTypesId").style.display="none";
			document.getElementById("mealfilter").style.display="";
			document.getElementById("mealtypelabel").style.display="none";
			document.getElementById("mealtypelink").style.display="";	
			document.getElementById("clearFilter").style.display="";		
	  }
	  else
		{
			if(mealflag == 1)
			{mealflag=0;
				document.getElementById("mealType").value="";
				document.getElementById("mealcode").value="";
			}
		}
}		
		
		
function getMealTypes(fetchedMealTypes,mealtype)
{	
	var mealArray = fetchedMealTypes.split(",");
	var mealSelectedArray=mealtype.split(",");
	var tableObj = null;
	var found_flag = false;
	var code = null;
	var mealTypeDesc;
	tableObj = document.getElementById("AbleM");
	var selObj = "";
	var row_ind = 0;	
	for (var i=0; i < mealArray.length;)
	{
		var sel="";
		if( i % 2 == 0)
		{
			var newRow = tableObj.insertRow(row_ind);
			
			var newCellDesc = newRow.insertCell(newRow.cells.length);
			
			newCellDesc.className = "label";
			
			if(mealArray[i+1] != null && mealArray[i+1] != 'undefined')
				newCellDesc.appendChild(document.createTextNode(mealArray[i+1]));
			sel="<input type='hidden' name='mealType' id='mealType'"+row_ind+" value='"+mealArray[i]+"'>";
			var newCellCBox = newRow.insertCell(newRow.cells.length);
			
			var mealTypesind="mealType_"+row_ind;
			
			if(mealArray[i+1] != null && mealArray[i+1] != 'undefined')
				mealTypeDesc = mealArray[i+1];
			if(mealTypeDesc != "" && mealTypeDesc != "undefined" && mealTypeDesc != null)
			{
				var mealTypeDescArr = mealTypeDesc.split(" ");
				for(var j=1 ; j <=mealTypeDescArr.length;j++)
				{
					mealTypeDesc = mealTypeDesc.replace(" ","#");
				}
			}
			if(mealTypeDesc != "undefined" && mealTypeDesc != null)
			{
			var temp_meal=mealArray[i];
				
			   temp_meal=temp_meal.split(' ').join('_');
				
					//code = mealArray[i]+"@"+mealTypeDesc;		
					code = temp_meal+"@"+mealTypeDesc;	
				
            }				
		var checkedYn = ""
		var disabledYn = "";
		for(var m=0;m<mealSelectedArray.length;m++)
	    {
			if(mealArray[i] != null && mealSelectedArray[m]==trim(mealArray[i]))
			checkedYn="checked";
		}
		
		if((mealtype == "" || mealtype == "null") && (code != null))
			sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" onclick=\"setStatus("+row_ind+",this.value)\" >"
		else if(code != null && code != undefined)
			sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" "+"disabled = true onclick=\"setStatus("+row_ind+",this.value)\" >"
		newCellCBox.innerHTML = sel;
		row_ind++;
	 }
		i++;
  }	
}

function getMealTypesSpFoodItems()
{
		for (var i=0; i < mealTypesArray.length ;i++ )
		{
			if(mealTypesArray[i] == undefined)
			{
				mealTypesArray[i] = "";
			}
		}
	mealTypeStr=mealTypesArray.join("*");
	parent.document.getElementById('dialog-body').contentWindow.returnValue = mealTypeStr;
	// top.returnValue = mealTypeStr;
	parent.document.getElementById("dialog_tag").close(); 
}

function setStatus(ind,mealTypes)
{  
	chkBox = document.getElementById(("mealType_" + ind));
	if(chkBox != null || chkBox != "")
	{
		if(chkBox.checked == true)
		{
			mealTypesArray[ind]=mealTypes;
			z1++;
			//ICN-064175
			if(z1 >= document.getElementById("MealmaxRecord").value)			
            			document.getElementById("mealTypeSelectAll").checked=true;			
		}
		else
		{
			
			document.getElementById("mealTypeSelectAll").checked=false;
			mealTypesArray[ind]="";
			z1--;//ICN-064175
		}
	}
}

function getmealTypeSelectAll(obj,maxRecord)
{ 
   z1=0;//ICN-064175
	if(document.getElementById('mealTypeSelectAll').checked)
	{
		for (var i=0; i < maxRecord;i++)
		{	
		   document.getElementById("mealType_"+i).checked=true;
			setStatus(i,document.getElementById("mealType_"+i).value);//[IN:064114] 
		}
	}
	else
	{
		for (var i=0; i < maxRecord;i++)
		{	
			mealTypesArray.length=0;
			document.getElementById("mealType_"+i).checked=false;
			mealflag=1;
			z1=0;//ICN-064175
		}
	}
}
	
//ClearFilter
function clearFilter()
{
    document.getElementById("dietcode").value="";
	document.getElementById("diettype").value="";
	document.getElementById("dietTypesId").style.display="";
	document.getElementById("dietfilter").style.display="none";	
	document.getElementById("diettypelabel").style.display="";
	document.getElementById("diettypelink").style.display="none";
	document.getElementById("mealcode").value="";
	document.getElementById("mealtype").value="";
	document.getElementById("mealTypesId").style.display="";
	document.getElementById("mealfilter").style.display="none";
	document.getElementById("mealtypelabel").style.display="";
	document.getElementById("mealtypelink").style.display="none";	
	document.getElementById("clearFilter").style.display="none";
}

function search()
{
		if(document.getElementById("ExistingFoodItem").value == "")
		{			
		    document.getElementById('selectedMenus').value="";
			document.getElementById('removedMenus').value="";
			document.getElementById('searchexisting_itemcode').value="";
			alert(getMessage('DS_EXISTING_ITEM_CHECK','DS'));			
		}
		//Added against ICN-64263 Starts Here
		else if(document.getElementById("NewFoodItem").value == "")
		{			
		    document.getElementById('selectedMenus').value="";
			document.getElementById('removedMenus').value="";
			document.getElementById('searchexisting_itemcode').value="";
			alert(getMessage('DS_NEW_ITEM_CHECK','DS'));			
		}
		//Added against ICN-64263 Ends Here
		else
		{		
				document.getElementById("NewFoodDesc").disabled=false;
	            		document.getElementById("newlookup").disabled=false;
				document.getElementById("newitemmandatory").style.display="";
				var ExistingFoodItem = document.getElementById("ExistingFoodItem").value;
				var NewFoodItem = document.getElementById("NewFoodItem").value;//Added against ICN-64263
				var DietType=document.getElementById("dietcode").value;
				var MealType = document.getElementById("mealcode").value;
                document.getElementById('selectedMenus').value="";
			    document.getElementById('removedMenus').value="";	
				document.getElementById('searchexisting_itemcode').value=document.getElementById("ExistingFoodItem").value;				
				parent.FoodItemModifyResult.location.href ="../../eDS/jsp/FoodItemModifyFrame.jsp?ExistingFoodItem="+ExistingFoodItem+"&DietType="+DietType+"&MealType="+MealType+"&NewFoodItem="+NewFoodItem;//Modified against ICN-64263 
				
		}
}	


//Checkbox check After Search


function selectMenu(menu_code){

		
		var selMenus =parent.parent.FoodItemModifyCriteria.document.getElementById('selectedMenus');
		
		var remMenus = parent.parent.FoodItemModifyCriteria.document.getElementById('removedMenus');
		
		
		var selMenus_Arr=selMenus.value.split(',');
		
		var removedMenus_Arr=remMenus.value.split(',');	
		var selectflag='false';
		var removeflag='false';
		//Selected Menus
		    for(var i=0;i<selMenus_Arr.length;i++) {
					
					if(selMenus_Arr[i] == menu_code)
					selectflag=i;
						}
						
				/* if(selectflag == 'false' && selMenus.value!='')
				{
                selMenus.value = 	selMenus.value +','+menu_code;  
                }		
				else if(selectflag == 'false' && selMenus.value =='')
				{
				selMenus.value = 	selMenus.value+menu_code;
				}*/
				
				//Removed Menus
				for(var i=0;i<removedMenus_Arr.length;i++) {
					
					
					if(removedMenus_Arr[i] == menu_code)
					{
				
					removeflag=i;
					}
					}
					
		/*if(removeflag != 'false' && remMenus.value!='' && removeflag != '0' ){
			remMenus.value = 	remMenus.value.replace(','+menu_code,''); 
		}
		else if(removeflag == '0' && remMenus.value!='' && removedMenus_Arr.length > 1){
			remMenus.value = 	remMenus.value.replace(menu_code+',','');
		}
     else if(removeflag == '0' && remMenus.value!='' && removedMenus_Arr.length == 1){
			remMenus.value = 	remMenus.value.replace(menu_code,'');
		}*/
	
	/*if(selMenus.value!=''){
			selMenus.value = 	selMenus.value +','+menu_code;
		}else{
			selMenus.value = 	selMenus.value+menu_code;
		}*/
		
		if(selMenus.value!='' && selectflag == 'false'){
			selMenus.value = 	selMenus.value +','+menu_code;
		}
		else if(selectflag == 'false'){
			selMenus.value = 	selMenus.value+menu_code;
		}

		/*if(remMenus.value!=menu_code ){
			remMenus.value = 	remMenus.value.replace(','+menu_code,''); 
		}else{
			remMenus.value = 	remMenus.value.replace(menu_code,'');
		}*/
		if(remMenus.value!=menu_code && removeflag != '0'){
			remMenus.value = 	remMenus.value.replace(','+menu_code,''); 
		}
		else if(remMenus.value!=menu_code && removeflag == '0'){
			remMenus.value = 	remMenus.value.replace(menu_code+',',''); 
		}
		else{
			remMenus.value = 	remMenus.value.replace(menu_code,'');
		}
		

	}
	
	function removeMenu(menu_code){
	
		var selMenus =parent.parent.FoodItemModifyCriteria.document.getElementById('selectedMenus');
		var remMenus = parent.parent.FoodItemModifyCriteria.document.getElementById('removedMenus');
		
			var selMenus_Arr=selMenus.value.split(',');
		
		var removedMenus_Arr=remMenus.value.split(',');	
		var selectflag='false';
		var removeflag='false';
		//Selected Menus
		    for(var i=0;i<selMenus_Arr.length;i++) {
					
					if(selMenus_Arr[i] == menu_code)
					selectflag=i;
						}
						//Removed Menus
				for(var i=0;i<removedMenus_Arr.length;i++) {
					
					
					if(removedMenus_Arr[i] == menu_code)
					{
					
					removeflag=i;
					}
					}
		
		if(remMenus.value!='' && removeflag == 'false'){
			remMenus.value = 	remMenus.value +','+menu_code;
		}else if(removeflag == 'false'){
			remMenus.value = 	remMenus.value+menu_code;
		}
		
				
	
		if(selMenus.value!=menu_code && selectflag != '0'){
			selMenus.value = 	selMenus.value.replace(','+menu_code,''); 
		}
		else if(selMenus.value!=menu_code && selectflag == '0'){
		selMenus.value = 	selMenus.value.replace(menu_code+',','');
		}
		else{
			selMenus.value = 	selMenus.value.replace(menu_code,'');
		}	
	

	}
//ICN-64263 Changes starts Here
function addRemoveMenu1(obj,menu_code,start,end)
{

      if(obj.checked==true) {
			selectMenu(menu_code);
			menucount++;
			
			if(menucount > end)
			document.getElementById("chkAll1").checked=true;
		}
		else {
			removeMenu(menu_code);
			document.getElementById("chkAll1").checked=false;
			menucount--;
		}
}

function addRemoveMenu2(obj,menu_code,start,end)
{
      if(obj.checked==true) {
			selectMenu(menu_code);
			menucount2++;
			
			if(menucount2 > end)
			document.getElementById("chkAll2").checked=true;
		}
		else {
			removeMenu(menu_code);
			document.getElementById("chkAll2").checked=false;
			menucount2--;
		}
}

//ICN-64263 Changes Starts Here
function MenuSelectAll1(obj,start,end)
{

  menucount=start;
  const table = document.querySelectorAll('#result')[0];
  const checkboxes = table.querySelectorAll('input[type="checkbox"]');
  
     if(obj.checked==true) {
    	checkboxes.forEach(checkbox => checkbox.checked = true);
		for (var i=start; i <= end;i++)
		{	
		   if(document.getElementById("menu_code_"+i))
		   {
			    //document.getElementById("check_"+i).checked=true;
				var menucode=document.getElementById("menu_code_"+i).value;
				selectMenu(menucode);			
				menucount++;
			}
		}
	}
	else {
   	 	checkboxes.forEach(checkbox => checkbox.checked = false);
		for (var i=start; i <= end;i++)
		  {	
			if(document.getElementById("menu_code_"+i))
			{
			    //document.getElementById("check_"+i).checked=false;
				var menucode=document.getElementById("menu_code_"+i).value;
				removeMenu(menucode);
				menucount=start;				
			}
		  }
	}

}


function MenuSelectAll2(obj,start,end)
{
    menucount2=start;
    const table = document.querySelectorAll('#result')[1];
    const checkboxes = table.querySelectorAll('input[type="checkbox"]');
     if(obj.checked==true) {
    	checkboxes.forEach(checkbox => checkbox.checked = true);
		for (var i=start; i <= end;i++)
		{	
		   if(document.getElementById("menu_code_"+i))
		   {
			    //document.getElementById("chk_"+i).checked=true;
				var menucode=document.getElementById("menu_code_"+i).value;
				selectMenu(menucode);
				menucount2++;
			}
		}
	}
	else {
		checkboxes.forEach(checkbox => checkbox.checked = false);
		for (var i=start; i <= end;i++)
		  {	
			if(document.getElementById("menu_code_"+i))
			{
			    //document.getElementById("chk_"+i).checked=false;
				var menucode=document.getElementById("menu_code_"+i).value;
				removeMenu(menucode);
				menucount2=start;		
			}
		 }
	}

}
//ICN-64263 Changes Ends Here
//Reset
function reset()
{	
window.location.reload();
}

function setFieldToUpperCase(obj) 
{
	obj.value = obj.value.toUpperCase();
	return obj;
}

function checkAlpha(event)
{
	var strCheck = '~!@#$%^&*()+=`{}|[]<>"\'';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) != -1) return false;  
	return true ;
}

function checkForSpecCharsforID(event)
{
	var strCheck = '0123456789/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function localTrimString(sInString) 
{
  return sInString.replace(/^\s+|\s+$/g,"");
}

