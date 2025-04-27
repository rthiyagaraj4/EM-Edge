//Note: to support indexOf method on IE
if (!Array.prototype.indexOf)
{
  Array.prototype.indexOf = function(elt /*, from*/)
  {
	var len = this.length >>> 0;

	var from = Number(arguments[1]) || 0;
	from = (from < 0)
		 ? Math.ceil(from)
		 : Math.floor(from);
	if (from < 0)
	  from += len;

	for (; from < len; from++)
	{
	  if (from in this &&
		  this[from] === elt)
		return from;
	}
	return -1;
  };
};

//Note: to support contains method on IE
Array.prototype.contains = function (element) {
	for (var i = 0; i < this.length; i++) {
		if (this[i] == element) {
			return true;
		}
	}
	return false;
}

	//ML-MMOH-CRF-1651 US001 Starts		
		var date2 = new Date();  
		var year2 = date2.getFullYear();  
		var month2 = date2.getMonth()+1; 
		 if(month2 < 10)   month2 = "0" + month2;  
		 var day2 = date2.getDate(); 	
		 if(day2 < 10)   day2 = "0" + day2; 
		 var currentDate = ""  +day2 + "/"+ month2 + "/" + year2 ; 
	//ML-MMOH-CRF-1651 US001 Ends
 
 	//Non- FUnction Source : The below code will be executed on loading of this script: - Start
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var countChkbox = 0; //To count the number of Check boxes appearing in current Page
	var chkPlaceOrderCount = 0; //To count total Selected Rows in Current Page
	var jsonDataObject = new Object();
	jsonDataObject.facilityid 	= parent.parent.frames[1].document.forms[0].facility_id.value;
//	jsonDataObject.speciality 	= parent.parent.frames[1].document.getElementById("hdnHdrSpeciality").value;
	document.getElementById("hdnSpeciality").value = jsonDataObject.speciality;
	jsonDataObject.encounterId 	= parent.parent.frames[1].document.getElementById("encounterId_EM").value;
	jsonDataObject.patientId 	= parent.parent.frames[1].document.getElementById("patientid_EM").value;
	jsonDataObject.locationType = parent.parent.frames[1].document.getElementById("loctype_EM").value;
	
	if(jsonDataObject.locationType == "Y")
			jsonDataObject.locationType = "D";
	
	if(parent.parent.frames[1].document.getElementById("location_EM").value == "")
		jsonDataObject.locationCode = "";
	else
		jsonDataObject.locationCode = parent.parent.frames[1].document.getElementById("hdnlocation_EM").value;
	

//	jsonDataObject.restype 		= parent.parent.frames[1].document.getElementById("resourceType_1").value; 
	jsonDataObject.restype 		= 'P';
	if(parent.parent.frames[1].document.getElementById("practitioner_name_EM").value == "")
		jsonDataObject.resource		= "";
	else
		jsonDataObject.resource 	= parent.parent.frames[1].document.getElementById("practitioner_EM").value; 

	jsonDataObject.date	= parent.parent.frames[1].document.getElementById("date_EM").value; 
	jsonDataObject.status		= parent.parent.frames[1].document.getElementById("status_EM").value;
	jsonDataObject.priorityZone		= parent.parent.frames[1].document.getElementById("priorityZone").value; 
	jsonDataObject.treatmentArea		= parent.parent.frames[1].document.getElementById("treatmentArea").value;
	jsonDataObject.PreviousDate_display		= parent.parent.frames[1].document.forms[0].PreviousDate_display.value;	//ML-MMOH-CRF-1651 US001 
	var jsonData = JSON.stringify(jsonDataObject);
	var param="jsonData="+jsonData+"&language_Id=en&mode=searchEMMealOrder";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	
	var jsonObjResponse=eval('(' + retVal + ')');
	
	//Getting Meal Record List::
	var orderList=new Array();
	orderList = jsonObjResponse.jsonOrderList;
	var divOrderList = document.getElementById("divOrderList_EM");
	var row_ind1 = 0;
	
	var from = document.getElementById("from").value;
	var to = document.getElementById("to").value;
	
	var start = "";
	var end = "";
	if(from == "")
	  start = 0; 
	else
	  start = from;
	  
	if(to == "")
	  end = 13; 
	else
	  end = to;
	//ML-MMOH-CRF-1651 US001 Starts
	var searchDate = parent.parent.frames[1].document.getElementById("date_EM").value;
	var flag = compareDate(searchDate,currentDate); //Added Against ML-MMOH-SCF-2135
	if(flag == 1 || flag == -1)
	{
		document.getElementById("hrefNextMealOrder").innerHTML="";
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
	}
	//ML-MMOH-CRF-1651 US001 Ends
	else{
	
	if(orderList!=null)
	{
		//getting maximum record
	    if(orderList.length == 0){
			document.getElementById("hrefNextMealOrder").innerHTML="";
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
		}
		else{	
		
			if(orderList.length <= end)
			{
				end = orderList.length;
				document.getElementById("hrefNextMealOrder").innerHTML="";
			}

			for(var itr=start;parseInt(itr,10) <parseInt(end,10);itr++){
					var newRow3 = divOrderList.insertRow(row_ind1);
					var specialityCode= orderList[itr].specialityCode;
					parent.parent.frames[1].document.getElementById("hdnHdrSpeciality").value=specialityCode;
					
					var newCellDesc = fnInsertCell(newRow3);
					if(orderList[itr].patient_id != "")
						newCellDesc.appendChild(document.createTextNode(orderList[itr].patient_id));
					else
						newCellDesc.innerHTML = "&nbsp;"
					
					var newCellDesc2 = fnInsertCell(newRow3);
					if(orderList[itr].Encounterid == "")					
						newCellDesc2.innerHTML = "&nbsp;";
					else
						newCellDesc2.innerHTML = orderList[itr].Encounterid;
					newCellDesc2.id = "enctRow"+ row_ind1;
					newCellDesc2.value = orderList[itr].Encounterid;
						
					var newCellDesc2 = fnInsertCell(newRow3);
					if(orderList[itr].patient_name != "")
						newCellDesc2.appendChild(document.createTextNode(orderList[itr].patient_name));
					else
						newCellDesc2.innerHTML = "&nbsp;"
						
					var newCellDesc2 = fnInsertCell(newRow3);
					if(orderList[itr].VisitDate != "")
						newCellDesc2.appendChild(document.createTextNode(orderList[itr].VisitDate));
					else
						newCellDesc2.innerHTML = "&nbsp;"
					
					var newCellDesc2 = newRow3.insertCell(newRow3.cells.length);
					//Added Against ML-MMOH-CRF-0600 starts Here
					newCellDesc2.align="right";
					newCellDesc2.colspan="3%";
					newCellDesc2.setAttribute="nowrap";
					//Added Against ML-MMOH-CRF-0600 Ends Here
					var tmpChkDate = orderList[itr].chkPlaceOrderDate;
					if(orderList[itr].serving_date!="undefined" && orderList[itr].serving_date==currentDate)	//ML-MMOH-CRF-1651 US001
					{
					if(orderList[itr].status == 'Y') 
						newCellDesc2.className = "OAYELLOW";
					else if(orderList[itr].status == 'N') 
						newCellDesc2.className = "OAGREEN";
					else
						newCellDesc2.className = "OARED";
					}
					else
						newCellDesc2.className = "OARED";
					//Added Against ML-MMOH-CRF-0600 Starts Here
					if(orderList[itr].pending_Ack != "1")					
						newCellDesc2.innerHTML = "&nbsp;";
					else
						newCellDesc2.innerHTML = "<img src='../../eDS/css/Action_Pending.PNG' onClick=\"Tip(PendingMealAckToolTip('"+orderList[itr].patient_id+"'))\" onmouseout='UnTip();'></img>";					
					//Added Against ML-MMOH-CRF-0600 Ends Here
				
					var sel = "&nbsp;";
					var locale = document.getElementById("locale").value
					 var flag1 = compareDate(tmpChkDate,currentDate); //Added Against ML-MMOH-SCF-2135
					//if(flag1 == 1 || flag1 == -1)
					if(flag1 == 0 || flag1 == -1) //Modified flag as 0 against ML-MMOH-SCF-2565
					{
						var tempApptArray = new Array();
						var tempEnctArray = new Array();
						tempApptArray = parent.globalForApptRecord;
						tempEnctArray = parent.globalForEnctRecord;
						// For retrieving the checked records from global variable while traversing the previous/next page:
						if( (tempApptArray.length > 0 && ( ExistsInArray(tempApptArray, orderList[itr].ApptNo) ) ) || 
							(tempEnctArray.length > 0 && ( ExistsInArray(tempEnctArray, orderList[itr].Encounterid) ) ) )
						{ 
						//Added Against ML-MMOH-CRF-0600 Starts Here
						if(orderList[itr].pending_Ack != "1")
							sel = "<input type='checkbox' name='placeOrderchk"+ row_ind1 +"' id='placeOrderchk"+ row_ind1 +"' onclick=chkPlaceOrder(this) value='' checked>";
						else
							sel = "<input type='checkbox' name='placeOrderchk"+ row_ind1 +"' id='placeOrderchk"+ row_ind1 +"' onclick=chkPlaceOrder(this) value='' checked disabled>";
						//Added Against ML-MMOH-CRF-0600 Ends Here
							chkPlaceOrderCount++;
							var nChkPlaceorder = document.getElementById("hdnplaceorder").value;
							document.getElementById("hdnplaceorder").value = ++nChkPlaceorder;
	
							if(document.getElementById("hdnplaceorder").value > 0)
								parent.qa_query_result_tail.document.getElementById("btnplaceOrder").disabled = false;
						}	
						else
						{
						//Added Against ML-MMOH-CRF-0600 Starts Here
						if(orderList[itr].pending_Ack != "1")						
							sel = "<input type='checkbox' name='placeOrderchk"+ row_ind1 +"' id='placeOrderchk"+ row_ind1 +"' onclick=chkPlaceOrder(this) value=''>";
						else
							sel = "<input type='checkbox' name='placeOrderchk"+ row_ind1 +"' id='placeOrderchk"+ row_ind1 +"' onclick=chkPlaceOrder(this) value='' disabled>";
						//Added Against ML-MMOH-CRF-0600 Ends Here							
						}
						countChkbox++;
					}
					
					
					var newCellDesc2 = newRow3.insertCell(newRow3.cells.length);
					newCellDesc2.innerHTML = sel;
					newCellDesc2.align = "center";
					
					row_ind1++;
					
			}
			document.getElementById("totchkRowsInCurrPage").value = countChkbox; //Total Rows of having Checkbox in Current Page
			if(countChkbox==0)
			{
				document.getElementById("chkAll").disabled = true;
			}else if(chkPlaceOrderCount == countChkbox)
				document.getElementById("chkAll").checked = true;
		}
	}else
	{
		document.getElementById("hrefNextMealOrder").innerHTML="";
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
	}
	}
	//Non- FUnction Source : The below code will be executed on loading of this script: - End
	
	//Function: For creating new cell on row:
	function fnInsertCell(newRow)
	{
			var newCellDesc = newRow.insertCell(newRow.cells.length);
				newCellDesc.className = "lable";
				
				newCellDesc.colSpan = "1";
				newCellDesc.align = "left";
				newCellDesc.setAttribute("border", "0px");
				newCellDesc.style.fontSize ="10pt"
				newCellDesc.style.color = "#4E387E"
				
				return newCellDesc;
	}
	
	//Function: For counting the selected and unselected Rows to enable/disable the placeorder button :
	function chkPlaceOrder(obj) {
		var nChkPlaceorder = document.getElementById("hdnplaceorder").value;

		if(obj.checked === true ) {
			document.getElementById("hdnplaceorder").value = ++nChkPlaceorder;
		}else
		{
			document.getElementById("hdnplaceorder").value = --nChkPlaceorder;
		}

		//If all rows are selected, then select ALL checkbox will be checked::
		if(document.getElementById("hdnplaceorder").value == document.getElementById("totchkRowsInCurrPage").value)
			document.getElementById("chkAll").checked = true;
		else
			document.getElementById("chkAll").checked = false;

		if(document.getElementById("hdnplaceorder").value > 0)
			parent.qa_query_result_tail.document.getElementById("btnplaceOrder").disabled = false;
		else
			parent.qa_query_result_tail.document.getElementById("btnplaceOrder").disabled = true;
			
	}
	
	//Added Against ML-MMOH-SCF-2135
	function compareDate(date1,date2) {
	var flag="";
    if(date1.length > 0 && date2.length > 0 ) {
			var date1_array = date1.split(" ");
			var date1_temp= date1_array[0];
			
			var date2_array = date2.split(" ");
			var date2_temp = date2_array[0];
			
	        var date1array = date1_temp.split("/");
            var date2array = date2_temp.split("/");
            
			var date1dt = new Date(date1array[2],date1array[1]-1,date1array[0]);
			var date2dt = new Date(date2array[2],date2array[1]-1,date2array[0]);
            var date3dt = new Date(date2array[2],date2array[1]-1,date2array[0]-1);
			
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi
			if(Date.parse(date1dt) > Date.parse(date2dt)) { //Future Date Validation
                flag=1;
            }
			else if(Date.parse(date1dt) == Date.parse(date2dt)) { //Current Date Validation
				flag=0;
			}
			else if(Date.parse(date1dt) == Date.parse(date3dt)){ //Previous Date Validation
				flag=0;
			}
			else flag=-1;
			
    }
	return flag;
	}
//Function :: Compare with current Date. It returns true if the given date is current or Future Date/ returns false if the given Date is past Date.
function compareWithCurrentDate(sDate) {  
		//Date1:
		
		//var date1 = Date(sDate[2],sDate[1]-1,sDate[0]);
		var date1 = new Date(sDate);
		var date2 = new Date();  
	
		var year1 = date1.getFullYear(); 
		var month1 = date1.getMonth(); 
		
		if(month1 < 10)   month1 = "0" + month1; 
		var day1 = date1.getDate(); 
		if(day1 < 10)   day1 = "0" + day1; 
		var pastDate = "" + year1 + month1 + day1; 
		//Date2:
		
		var year2 = date2.getFullYear();  
		var month2 = date2.getMonth(); 
		 if(month2 < 10)   month2 = "0" + month2;  
		 //var day2 = date2.getDate()-1; 
		 var day2 = date2.getDate()-1; 	//ML-MMOH-CRF-1651 US001
		 if(day2 < 10)   day2 = "0" + day2; 
		 var currentDate = "" + year2 + month2 + day2; 
		 if(pastDate < currentDate)   
			return false; 
		 else 
			return true;
	 }
 


// Function : For traverse to the previous/next page:
	function traversePage(start, end)
	{
		chkGlobalValues();
		parent.qa_query_result.location.href = "../../eDS/jsp/PlaceMealOrderEMResult.jsp?from="+start+"&to="+end;
	}
	
	
	
	//Function: For updating global values based on the row selection by the user:
	function chkGlobalValues()
	{ 	var divOrderList = parent.qa_query_result.document.getElementById("divOrderList_EM");

		for(var i=0;i<divOrderList.rows.length; i++)
		{
			var sEnctid = parent.qa_query_result.document.getElementById("enctRow"+i).value;
			
			// If this record is checked, then updating into global variable..
			if(parent.qa_query_result.document.getElementById("placeOrderchk"+i) != null && parent.qa_query_result.document.getElementById("placeOrderchk"+i).checked)
			{
				var nglobalCount;
				if(parent.globalForEnctRecord == "undefined")
					nglobalCount = 0;
				else
					nglobalCount = parent.globalForEnctRecord.length;
				if( (parent.globalForEnctRecord == "undefined" || parent.globalForEnctRecord.length == 0) || (parent.globalForEnctRecord.length > 0 && !(ExistsInArray(parent.globalForEnctRecord, sEnctid))) )
				{ 
					parent.globalForEnctRecord[nglobalCount] = sEnctid;
				}
			}
			
			else if(parent.qa_query_result.document.getElementById("placeOrderchk"+i) != null && !parent.qa_query_result.document.getElementById("placeOrderchk"+i).checked) // If this record is not checked, then remove it from the global variable if it has..
			{ 
				var nPos = searchIndexOf(parent.globalForEnctRecord,sEnctid);
				if((parent.globalForEnctRecord.length > 0) && (ExistsInArray(parent.globalForEnctRecord,sEnctid)))
				{
					parent.globalForEnctRecord.splice(nPos, 1);
				}
					
			}
		}
	}
	
	//Note: to support contains method on IE
function ExistsInArray(obj, element) {
	for (var i = 0; i < obj.length; i++) {
		if (obj[i] == element) {
			return true;
		}
	}
	return false;
}

//Function indexOf
function searchIndexOf(obj, element)
{
	 for (var i = 0; i < obj.length; i++) {
             if (obj[i] === element) { 
			 return i; 
			 }
         }
         return -1;

};


	//Function: For Selecting all the Records if it is and viceversa:
	function checkAll(obj)
	{
		var divOrderList = parent.qa_query_result.document.getElementById("divOrderList_EM");
		var nChkPlaceorder = parent.qa_query_result.document.getElementById("hdnplaceorder").value;
		
		if(obj.checked)
		{
			for(var i=0;i<divOrderList.rows.length; i++)
			{
				if( parent.qa_query_result.document.getElementById("placeOrderchk"+i) != null && parent.qa_query_result.document.getElementById("placeOrderchk"+i).disabled !=true )//Added Against ML-MMOH-CRF-0600
				{
					parent.qa_query_result.document.getElementById("placeOrderchk"+i).checked = true;
					nChkPlaceorder++;
				}
			}
			parent.qa_query_result.document.getElementById("hdnplaceorder").value = document.getElementById("totchkRowsInCurrPage").value;
		}else
		{
			for(var i=0;i<divOrderList.rows.length; i++)
			{
				if( parent.qa_query_result.document.getElementById("placeOrderchk"+i) != null )
				{
					parent.qa_query_result.document.getElementById("placeOrderchk"+i).checked = false;
				}
			}
			nChkPlaceorder = 0;
			parent.qa_query_result.document.getElementById("hdnplaceorder").value = 0;
		}
		chkGlobalValues();
		
		//parent.qa_query_result.document.getElementById("hdnplaceorder").value = nChkPlaceorder;
		if(parent.qa_query_result.document.getElementById("chkAll").checked && nChkPlaceorder>0)//Added Against ML-MMOH-CRF-0600
			parent.qa_query_result_tail.document.getElementById("btnplaceOrder").disabled = false;
		else
			parent.qa_query_result_tail.document.getElementById("btnplaceOrder").disabled = true;
	}

//Added Against ML-MMOH-CRF-0600 starts Here ToolTip	
function  PendingMealAckToolTip(patientid)
   {	   
   	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var param="patientid="+patientid+"&patient_type=EM&mode=pendingMealOrderAckDetail";
	xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;	
	var jsonObjResponse=eval('(' + retVal + ')');	
	var orderList=new Array();
	orderList = jsonObjResponse.jsonMealPendingList;
 	
	var OrderDate=getLabel("eDS.OrderDate.Label","ds_labels");
	var MealType=getLabel("eDS.MealType.Label","ds_labels");
	var Status=getLabel("eDS.Status.Label","ds_labels");
	
	var tab_dat  = "<table id ='tooltiptable1' cellpadding='3' cellspacing=0 border='1' class='BOX' width='100%' height='100%' align='center'>";
	tab_dat     += "<tr>"
	tab_dat     += "<th   nowrap > <B> "+OrderDate+"</B> </a> </th>"	
	tab_dat     += "<th   nowrap > <B>"+MealType+" </B> </a> </th>"	
	tab_dat     += "<th   nowrap > <B>"+Status+"</B> </a> </th>"
	tab_dat     += "</tr> ";	
	
	for(var i=0;i<orderList.length;i++)
	{
		tab_dat     += "<tr>"
		tab_dat     += "<td class='label' > "+(orderList[i].serving_date).substring(0,10)+" </td>"
		tab_dat     += "<td class='label' >"+orderList[i].mealtypeDesc+" </td>"
		tab_dat     += "<td class='label' >"+orderList[i].status+"</td>"
		tab_dat     += "</tr> ";	
	}	
	tab_dat     += "</table> ";
   	return tab_dat;
   }
//Added Against ML-MMOH-CRF-0600 Ends Here ToolTip
	 

