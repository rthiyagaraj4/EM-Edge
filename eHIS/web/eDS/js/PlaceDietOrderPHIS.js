//Added against MMS-KH-CRF-0029.1 Starts Here
function trim(str) {
	if(str != "" && str != null){
		return str.replace(/^\s+|\s+$/g,'');
	}
    return "";
}
async function drugFoodInteraction()
{
	var language_Id =document.getElementById("languageId").value;
	var mealClass=document.getElementById("mealClass").value;
	var facility=document.getElementById("addedFacilityId").value;
	var dietTypes=document.getElementById("dietType").value;
	var encounter = document.getElementById("encounterId").value;
	var fromDate=document.getElementById("dateForMeanu").value;
	var dateTo=$("#dateTo").val();
	var mode = "drug";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	var param="locale="+language_Id+"&mClass="+mealClass+"&addedFacilityId="+facility+"&dietType="+dietTypes+"&encounterId="+encounter+"&fromDate="+fromDate+"&dateTo="+dateTo+"&mode="+mode; 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
	xmlHttp.send(xmlDoc);
  //Added against MMS-KH-SCF-0078 by Gomathi
	var retVal = (xmlHttp.responseText);
	retVal = retVal.substring(1, retVal.length-1);
	retVal = trim(retVal);	
	var restrict = retVal.split(",");
	
	var retValLen = retVal.length/9;
	var count =0;
	var countInc =8;
	var val = [];
	var val1 = [];
	for(var i=1;i<=retValLen;i++){
				for(var j=count;j<=countInc;j++){
						 val.push(restrict[j]);
					}
					if(val[8]==" E" || val[8]==" E]")
					{
						val1.push(val);
					}
					val = [];
					count=count+9;
					countInc = countInc+9;
	}	
	var listToStr = val1.join('');
	var arr = listToStr.split(",");
  //Added against MMS-KH-SCF-0078 by Gomathi
	var param1="func_mode=getretVal&ret_val="+encodeURIComponent(val1)+"&fromDate="+fromDate+"&dateTo="+dateTo;
	if(val1!="" )	//Added Against ICN-72016
	{ 
 		var retVal2;
		var dialogUrl1 = "../../eDS/jsp/AlertValidation.jsp?"+param1;
		var dialogArguments = "";
		var dialogFeatures = "dialogHeight:15;dialogWidth:30;status:no;scroll:yes";			
		retVal2 = await window.showModalDialog(dialogUrl1, dialogArguments ,dialogFeatures);
			
	}
	 if(arr[7]==" N")		//Added Against ICN-72015   //Added against MMS-KH-SCF-0078 by Gomathi
	{
	parent.parent.parent.frames[2].document.getElementById("remarksImg").style.visibility = 'visible';	
	}
}	 		
			
async function editMenu() 
{
	var fromDate = document.getElementById("dateFrom").value;
	var dateTo = document.getElementById("dateTo").value;
	var mode = "updateEditMenu";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	var param="mode="+mode; 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
	xmlHttp.send(xmlDoc);
    //Added against MMS-KH-SCF-0078 by Gomathi
	var retVal = (xmlHttp.responseText);
	retVal = retVal.substring(1, retVal.length-1);
	retVal = trim(retVal);
	var restrict = retVal.split(",");
	
	var retValLen = retVal.length/9;
	var count =0;
	var countInc =8;
	var val = [];
	var val1 = [];
	for(var i=1;i<=retValLen;i++){
				for(var j=count;j<=countInc;j++){
						 val.push(restrict[j]);
					}
					if(val[8]==" E" || val[8]==" E]")
					{
						val1.push(val);
					}
					val = [];
					count=count+9;
					countInc = countInc+9;
	}	
	var listToStr = val1.join('');
	var arr = listToStr.split(",");
	  //Added against MMS-KH-SCF-0078 by Gomathi
	var param1="func_mode=getretVal&ret_val="+encodeURIComponent(val1);
	 //if(retVal!="" && (trim(restrict[8])=="E" || trim(restrict[8])=="E]"))	//Added Against ICN-72016
	 if(val1!="")	
		{ 
	 		var retVal2;
			var dialogUrl1 = "../../eDS/jsp/AlertValidation.jsp?"+param1;
			var dialogArguments = "";
			var dialogFeatures = "dialogHeight:15;dialogWidth:30;status:no;scroll:yes";			
			retVal2 = await window.showModalDialog(dialogUrl1, dialogArguments ,dialogFeatures);
		}
		
		if(arr[7]==" N")   //Added against MMS-KH-SCF-0078 by Gomathi
		{
			alert("Remarks Should be Mandatory");
			window.close();
			}
		 else if(arr[7]==" Y")  //Added against MMS-KH-SCF-0078 by Gomathi
		{
			} 
		 }

async function applyFinal()
{
	var language_Id =document.getElementById("languageId").value;
	var mealClass=document.getElementById("mealClass").value;
	var facility=document.getElementById("addedFacilityId").value;
	var dietTypes=document.getElementById("dietType").value;
	var encounter = document.getElementById("encounterId").value;
	var fromDate=document.getElementById("dateForMeanu").value;
	var dateTo=$("#dateTo").val();
	var mode = "drug";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	var param="locale="+language_Id+"&mClass="+mealClass+"&addedFacilityId="+facility+"&dietType="+dietTypes+"&encounterId="+encounter+"&fromDate="+fromDate+"&dateTo="+dateTo+"&mode="+mode; 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
	xmlHttp.send(xmlDoc);
    //Added against MMS-KH-SCF-0078 by Gomathi
	var retVal = (xmlHttp.responseText);
	retVal = retVal.substring(1, retVal.length-1);
	retVal = trim(retVal);
	var restrict = retVal.split(",");
  //Added against MMS-KH-SCF-0078 by Gomathi
	var retValLen = retVal.length/9;
	var count =0;
	var countInc =8;
	var val = [];
	var val1 = [];
	for(var i=1;i<=retValLen;i++){
				for(var j=count;j<=countInc;j++){
						 val.push(restrict[j]);
					}
					if(val[8]==" E" || val[8]==" E]")
					{
						val1.push(val);
					}
					val = [];
					count=count+9;
					countInc = countInc+9;
	}	
	var listToStr = val1.join('');
	var arr = listToStr.split(",");
	var param1="func_mode=getretVal&ret_val="+encodeURIComponent(val1)+"&fromDate="+fromDate+"&dateTo="+dateTo;
	  //Added against MMS-KH-SCF-0078 by Gomathi
	var mode = "applyMenu";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	var param="mode="+mode; 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
	xmlHttp.send(xmlDoc);
    //Added against MMS-KH-SCF-0078 by Gomathi
	var retVal1 = (xmlHttp.responseText);
	retVal1 = retVal1.substring(1, retVal1.length-1);
	retVal1 = trim(retVal1);
	var restrict_1 = retVal1.split(",");
	var Len = retVal1.length/9;
	var count1 =0;
	var countInc1 =8;
	var valApp = [];
	var val1App = [];
	for(var m=1;m<=Len;m++){
				for(var n=count1;n<=countInc1;n++){
						 valApp.push(restrict_1[n]);
					}
					if(valApp[8]==" E" || valApp[8]==" E]")
					{
						val1App.push(valApp);
					}
					valApp = [];
					count1=count1+9;
					countInc1 = countInc1+9;
	}	
	var listToStr1 = val1App.join('');
	var arr1 = listToStr1.split(",");
	var param2="func_mode=getretVal&ret_val="+encodeURIComponent(val1App)+"&fromDate="+fromDate+"&dateTo="+dateTo;
	  //Added against MMS-KH-SCF-0078 by Gomathi
	var mode = "cancelMenu";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	var param="mode="+mode; 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
	xmlHttp.send(xmlDoc);
  //Added against MMS-KH-SCF-0078 by Gomathi
	var retVal2 = (xmlHttp.responseText);
	retVal2 = retVal2.substring(1, retVal2.length-1);
	retVal2 = trim(retVal2);	
	var param3="func_mode=getretVal&ret_val="+encodeURIComponent(retVal2);
	var restrict_2 = retVal2.split(",");
	var Len1 = retVal2.length/9;
	var count2 =0;
	var countInc2 =8;
	var valApp2 = [];
	var val1App2 = [];
	for(var p=1;p<=Len1;p++){
				for(var q=count2;q<=countInc2;q++){
						 valApp2.push(restrict_2[q]);
					}
					if(valApp2[8]==" E" || valApp2[8]==" E]")
					{
						val1App2.push(valApp2);
					}
					valApp2 = [];
					count2=count2+9;
					countInc2 = countInc1+2;
	}	
	var listToStr2 = val1App2.join('');
	var arr2 = listToStr2.split(",");
	  //Added against MMS-KH-SCF-0078 by Gomathi
	if(arr[1]!=arr2[1])
	{
		var rem = encodeURIComponent((returnRemarks));
		if((arr[7]==" N" && (rem=="" || rem=="null")) || (arr[7]==" Y"))
		{
		var retVal4;
			var dialogUrl1 = "../../eDS/jsp/AlertValidation.jsp?"+param1;
			var dialogArguments = "";
			var dialogFeatures = "dialogHeight:15;dialogWidth:30;status:no;scroll:yes";			
			retVal4 = await window.showModalDialog(dialogUrl1, dialogArguments ,dialogFeatures);
		return arr[7];
	}
	}
	else if((val1App!=""))   //Added against MMS-KH-SCF-0078 by Gomathi
	{
		var rem = encodeURIComponent((returnRemarks));	
		if((arr1[7]==" N" && (rem=="" || rem=="null")) || (arr1[7]==" Y"))	//Added Against ICN:72582
		{
      var retVal3;
      var dialogUrl1 = "../../eDS/jsp/AlertValidation.jsp?"+param2;
      var dialogArguments = "";
      var dialogFeatures = "dialogHeight:15;dialogWidth:30;status:no;scroll:yes";			
      retVal3 = await window.showModalDialog(dialogUrl1, dialogArguments ,dialogFeatures);
      return arr1[7];
	}
	}
	return 1;
}

async function groupOrder()
{
    var language_Id =document.getElementById("languageId").value;
    var mealClass=document.getElementById("mealClass").value;
    var facility=document.getElementById("addedFacilityId").value;
    var dietTypes=document.getElementById("dietType").value;
    encountID = encounter_IDs(); 
    document.getElementById("encounter").value = encountID;
    var fromDate=document.getElementById("dateFrom").value;
    var dateTo=document.getElementById("dateTo").value;
    var mode = "drugGroup";
    var xmlDoc = "";
    var xmlHttp = new XMLHttpRequest();
    var xmlStr ="<root></root>";
    var param="locale="+language_Id+"&mClass="+mealClass+"&addedFacilityId="+facility+"&dietType="+dietTypes+"&encounterId="+encountID+"&fromDate="+fromDate+"&dateTo="+dateTo+"&mode="+mode; 
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", "../../servlet/eDS.PlaceBulkDietOrderServlet?"+param,false);
    xmlHttp.send(xmlDoc);
    //Added against MMS-KH-SCF-0078 by Gomathi
    var retVal = (xmlHttp.responseText);	
	  retVal = retVal.substring(1, retVal.length-1);
    var restrict = retVal.split(",");
	
	var Len = retVal.length/10;
	var count1 =0;
	var countInc1 =9;
	var valGroup = [];
	var val1Group = [];
	for(var m=1;m<=Len;m++){
				for(var n=count1;n<=countInc1;n++){
						 valGroup.push(restrict[n]);
					}
					if(valGroup[8]==" E" || valGroup[8]==" E]")
					{
						val1Group.push(valGroup);
					}
					valGroup = [];
					count1=count1+10;
					countInc1 = countInc1+10;
	}	
	var listToStr = val1Group.join('');
	var arr = listToStr.split(",");
  //Added against MMS-KH-SCF-0078 by Gomathi
	
    var param1="func_mode=groupOrder&ret_val="+encodeURIComponent(val1Group)+"&fromDate="+fromDate+"&dateTo="+dateTo;
    //if(retVal!="" && (trim(restrict[8])=="E" || trim(restrict[8])=="E]"))	//Added Against ICN-72016
    if(val1Group!="")	//Added Against ICN-72016
    { 
      var retVal2;
      var dialogUrl1 = "../../eDS/jsp/AlertValidation.jsp?"+param1;
      var dialogArguments = "";
      var dialogFeatures = "dialogHeight:15;dialogWidth:30;status:no;scroll:yes";			
      retVal2 = await window.showModalDialog(dialogUrl1, dialogArguments ,dialogFeatures);	
    }
    var val = [];
    var warning_id;
    var drugIDs = [];
    var retValLen = restrict.length/10;
    var count =0;
    var countInc =9;
    for(var i=1;i<=retValLen;i++){
    for(var j=count;j<=countInc;j++)
    {
      val.push(restrict[j]);
      warning_id = val[7] + "," + val[9];
    }
      drugIDs.push(warning_id);
      count=count+10;
      countInc = countInc+10;
      val = [];
    }
    return drugIDs;
	}
	 		
//Added against MMS-KH-CRF-0029.1 Ends Here	
