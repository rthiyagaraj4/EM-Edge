/**
File Name			: DocumentOPMealServed.js
File Description		: This is to document/acknowledge the placed order .
CRF#				: Bru-HIMS-CRF-230
Author				: Abirami
Date				: Aug-2013
**/
//For Loading Speciality:
function loadSpeciality(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var param="language_Id=en&mode=initialLoad";
	var speciality = new Array();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.DocumentOPMealServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	
	//Load 1 : Getting Speciality List::
	var specList=new Array();
	specList = jsonObjResponse.specList;
	
	var obj = document.getElementById("speciality");
	while(obj.length > 0){
			obj.remove(0);
		}
	// ML-MMOH-CRF-0597
	 if(specList.length!=1){
		    var Entry = document.createElement("OPTION");
		    var msg = "----select----";
		    Entry.text = msg;
		    Entry.value= "";
		    obj.add(Entry);
	       for(var itr=0; itr < specList.length;itr++){
			  
				var Entry = document.createElement("option");
				Entry.value = specList[itr].specCode;
				Entry.text  = specList[itr].specDesc;
				obj.add(Entry);
			   }
	 }
	 else   {
		       for(var itr=0; itr < specList.length;itr++){
			    var Entry = document.createElement("option");
				Entry.value = specList[itr].specCode;
				Entry.text  = specList[itr].specDesc;
				obj.add(Entry);
            }
	 }
	// ML-MMOH-CRF-0597
	//Load 2 :Getting location type List::
	var locList=new Array();
	locList = jsonObjResponse.locList;
	
	var obj = document.getElementById("loctype");
	while(obj.length > 0){
			obj.remove(0);
		}
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	
	if(locList!=null)
	{
		for(var itr=0; itr < locList.length;itr++){
				var Entry = document.createElement("option");
				Entry.value = locList[itr].LocCode;
				Entry.text  = locList[itr].LocDesc;
				obj.add(Entry);
		}
	}
	
	//Load 3 : Getting Meal List::
	var mealList=new Array();
	mealList = jsonObjResponse.mealList;
	
	var obj = document.getElementById("mealType");
	while(obj.length > 0){
			obj.remove(0);
		}
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	
	if(mealList!=null)
	{
		for(var itr=0; itr < mealList.length;itr++){
				var Entry = document.createElement("option");
				Entry.value = mealList[itr].mealType;
				Entry.text  = mealList[itr].mealDesc;
				obj.add(Entry);
		}
	}
	
}

function hideEMSearchCriteria() {
	document.forms[0].mealOrderFor[0].checked = true;
	
	for(var i=0;i<document.getElementsByClassName("Row_EMPatient").length;i++) {
		document.getElementsByClassName("Row_EMPatient")[i].style.display='none';
	}		

}

function getMealPlanDetails() {
	var isOPOrder=true;
	if(document.forms[0].mealOrderFor[0].checked == true) {
		isOPOrder=true;
	}
	else {
		isOPOrder=false;
	}
	
	if (isOPOrder==true) {getMealPlanDetails_OP();}
	
	else if (isOPOrder==false) {getMealPlanDetails_EM();}
}
//Function : For displaying the MealPlan Details
function getMealPlanDetails_OP()
{	
	var formObj = parent.Docquery_add_mod.document.forms[0];
	var mealtype = getLabel("eOT.MealType.Label","ot");
	var servingDate = getLabel("Common.date.label","common");
	var speciality = getLabel("Common.speciality.label","common");
	
	var fields = new Array (formObj.mealType, formObj.servingdate, formObj.speciality);
	var names = new Array (mealtype,servingDate,speciality);
	if(checkFieldsofMst( fields, names, parent.messageFrame)){
		parent.Docresult_add_mod.location.href='../../eDS/jsp/DocumentMealServedOPRecord.jsp?from=&to=';
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
	}
}

function getMealPlanDetails_EM()
{	
	var formObj = parent.Docquery_add_mod.document.forms[0];
	var mealtype = getLabel("eOT.MealType.Label","ot");
	var servingDate = getLabel("Common.date.label","common");
	var location = getLabel("Common.Location.label","common");
	var fields = new Array (formObj.mealType_EM, formObj.servingdate_EM, formObj.location_EM);
	var names = new Array (mealtype,servingDate,location);
	if(checkFieldsofMst( fields, names, parent.messageFrame)){
		parent.Docresult_add_mod.location.href='../../eDS/jsp/DocumentMealServedEMRecord.jsp?from=&to=';
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
	}
}

function chkStatus(obj, row) {
	var isOPOrder=true;
	if(parent.frames.Docquery_add_mod.document.forms[0].mealOrderFor[0].checked == true) {
		isOPOrder=true;
	}
	else {
		isOPOrder=false;
	}
	if (isOPOrder==true) {chkStatus_OP(obj, row);}
	
	else if (isOPOrder==false) {chkStatus_EM(obj, row);}
}

function chkStatus_OP(obj, row)
{
	var throwMsg = false;
	var isMealComplaints = document.getElementById("isMealComplaints").value; //Added Against ML-MMOH-CRF-1125
	//Added Against ML-MMOH-CRF-1125 Starts Here
	if(isMealComplaints=="true"){
	var othersDesc = document.getElementById("othersComp"+row).value;
	var complaintDesc = document.getElementById("complaintDesc"+row).value;
	}
	//Added Against ML-MMOH-CRF-1125 Ends Here
	//Added Against Start ML-MMOH-CRF-681	
	// status (Serverd-MS Accept-MA Reject-MR)
	var check_point = obj.value ;
	if(check_point == "MR"){
		document.getElementById("cmp"+row).style.visibility="visible";
		//Added Against ML-MMOH-CRF-1125 Starts Here
		if(isMealComplaints=="true"){
		if(complaintDesc!=""){
			document.getElementById("othersLink"+row).style.visibility="visible";
			document.getElementById("othersLink"+row).disabled=true;
			document.getElementById("complaintDesc"+row).disabled=false;
			document.getElementById("bt"+row).disabled=false;
		}else if(othersDesc!=""){
			document.getElementById("othersLink"+row).style.visibility="visible";
			document.getElementById("complaintDesc"+row).disabled=true;
			document.getElementById("bt"+row).disabled=true;
		}else{
			document.getElementById("othersLink"+row).style.visibility="visible";
		}
		}
		//Added Against ML-MMOH-CRF-1125 Ends Here
		document.getElementById("MealReplaceYn"+row).disabled=false;
		document.getElementById("MealReplaceYn"+row).options[0].selected=true;
	}else if(check_point == "MA"){
		document.getElementById("cmp"+row).style.visibility="hidden";
		//Added Against ML-MMOH-CRF-1125 Starts Here
		if(isMealComplaints=="true"){
		if(othersDesc != ""){
			document.getElementById("othersComp"+row).value = "";
			document.getElementById("othersLink"+row).style.visibility="hidden";
		}else{
			document.getElementById("othersLink"+row).style.visibility="hidden";
		}
			document.getElementById("complaintDesc"+row).disabled=false;
			document.getElementById("bt"+row).disabled=false;
		}
		//Added Against ML-MMOH-CRF-1125 Starts Here
		document.getElementById("MealReplaceYn"+row).value="N";
		document.getElementById("MealReplaceYn"+row).disabled=true;
	}
	else{
		document.getElementById("cmp"+row).style.visibility="hidden";
		//Added Against ML-MMOH-CRF-1125 Starts Here
		if(isMealComplaints=="true"){
			document.getElementById("othersLink"+row).style.visibility="hidden";
			document.getElementById("complaintDesc"+row).disabled=false;
			document.getElementById("bt"+row).disabled=false;
		}
		//Added Against ML-MMOH-CRF-1125 Starts Here
			document.getElementById("MealReplaceYn"+row).value="N";
			document.getElementById("MealReplaceYn"+row).disabled=true;
	}				
	//Added Against End ML-MMOH-CRF-681	
	if(trim(parent.frames.Docresult_add_mod.document.getElementById("hdnstatus"+row).value) != "" && obj.value == "")
		throwMsg = true;
	
	if(parent.frames.Docresult_add_mod.document.getElementById("hdnstatus"+row).value == 'MA' || parent.frames.Docresult_add_mod.document.getElementById("hdnstatus"+row).value == 'MR')
		{
			if(obj.value != 'MA' && obj.value != 'MR' )
			{
				throwMsg = true;
			}
		}		
		if(throwMsg)
		{
			alert(getMessage("DS_CANT_SELECT","DS"));
			obj.value = parent.frames.Docresult_add_mod.document.getElementById("hdnstatus"+row).value;
			//Added Against Start ML-MMOH-CRF-683	
			if(obj.value =="MR"){
				document.getElementById("MealReplaceYn"+row).disabled=false;
				document.getElementById("MealReplaceYn"+row).options[0].selected=true;
				//Added Against ML-MMOH-CRF-1125 Starts Here
				if(isMealComplaints=="true"){
				if(othersDesc!=""){
					document.getElementById("othersLink"+row).style.visibility="visible";
					document.getElementById("cmp"+row).style.visibility="visible";
					document.getElementById("complaintDesc"+row).disabled=true;
					document.getElementById("bt"+row).disabled=true;
				}
				else{
					document.getElementById("othersLink"+row).style.visibility="visible";
					document.getElementById("cmp"+row).style.visibility="visible";
					document.getElementById("complaintDesc"+row).disabled=false;
					document.getElementById("bt"+row).disabled=false;
				}
				}
				//Added Against ML-MMOH-CRF-1125 Ends Here
			}
			//Added Against End ML-MMOH-CRF-683	
			return false;
		}
			
}

function chkStatus_EM(obj, row)
{
	var throwMsg = false;
	//Added Against Start ML-MMOH-CRF-681
	var isMealComplaints = document.getElementById("isMealComplaints").value; //Added Against ML-MMOH-CRF-1125
	//Added Against ML-MMOH-CRF-1125 Starts Here
	if(isMealComplaints=="true"){
		var othersDesc = document.getElementById("othersComp"+row).value;
		var complaintDesc = document.getElementById("complaintDesc"+row).value;
	}
	//Added Against ML-MMOH-CRF-1125 Ends Here
	var check_point = obj.value ;
	if(check_point == "MR"){
		document.getElementById("cmp"+row).style.visibility="visible"; //Added Against ML-MMOH-CRF-683
		//Added Against ML-MMOH-CRF-1125 Starts Here
		if(isMealComplaints=="true"){
		if(complaintDesc!=""){
			document.getElementById("othersLink"+row).style.visibility="visible";
			document.getElementById("othersLink"+row).disabled=true;
			document.getElementById("complaintDesc"+row).disabled=false;
			document.getElementById("bt"+row).disabled=false;
		}else if(othersDesc!=""){
			document.getElementById("othersLink"+row).style.visibility="visible";
			document.getElementById("complaintDesc"+row).disabled=true;
			document.getElementById("bt"+row).disabled=true;
		}else{
			document.getElementById("othersLink"+row).style.visibility="visible";
		}
		}
		//Added Against ML-MMOH-CRF-1125 Ends Here
		document.getElementById("MealReplaceYn"+row).disabled=false;
		document.getElementById("MealReplaceYn"+row).options[0].selected=true;
	}else{
		document.getElementById("cmp"+row).style.visibility="hidden"; //Added Against ML-MMOH-CRF-683	
		//Added Against ML-MMOH-CRF-1125 Starts Here
		if(isMealComplaints=="true"){
		if(othersDesc != ""){
			document.getElementById("othersComp"+row).value = "";
			document.getElementById("othersLink"+row).style.visibility="hidden";
		}else{
			document.getElementById("othersLink"+row).style.visibility="hidden";
		}
			document.getElementById("complaintDesc"+row).disabled=false;
			document.getElementById("bt"+row).disabled=false;
		}
		//Added Against ML-MMOH-CRF-1125 Starts Here
		   document.getElementById("MealReplaceYn"+row).disabled=true;
		   document.getElementById("MealReplaceYn"+row).value="N";
	}				
	//Added Against End ML-MMOH-CRF-681	
	if(trim(parent.frames.Docresult_add_mod.document.getElementById("hdnstatus_EM"+row).value) != "" && obj.value == "")
		throwMsg = true;
	
	if(parent.frames.Docresult_add_mod.document.getElementById("hdnstatus_EM"+row).value == 'MA' || parent.frames.Docresult_add_mod.document.getElementById("hdnstatus_EM"+row).value == 'MR'){
			if(obj.value != 'MA' && obj.value != 'MR' )
				throwMsg = true;
			}		
	if(throwMsg){
		alert(getMessage("DS_CANT_SELECT","DS"));
		obj.value = parent.frames.Docresult_add_mod.document.getElementById("hdnstatus_EM"+row).value;
		//Added Against Start ML-MMOH-CRF-683	
		if(obj.value =="MR"){
			document.getElementById("MealReplaceYn"+row).disabled=false;
			document.getElementById("MealReplaceYn"+row).options[0].selected=true;
			//Added Against ML-MMOH-CRF-1125 Starts Here
			if(isMealComplaints=="true"){
			if(othersDesc!=""){
				document.getElementById("othersLink"+row).style.visibility="visible";
				document.getElementById("cmp"+row).style.visibility="visible";
				document.getElementById("complaintDesc"+row).disabled=true;
				document.getElementById("bt"+row).disabled=true;
			}
			else{
				document.getElementById("othersLink"+row).style.visibility="visible";
				document.getElementById("cmp"+row).style.visibility="visible";
				document.getElementById("complaintDesc"+row).disabled=false;
				document.getElementById("bt"+row).disabled=false;
			}
			}
			//Added Against ML-MMOH-CRF-1125 Ends Here
		}
		//Added Against End ML-MMOH-CRF-683	
		return false;
	}
}

function apply() {
	var isOPOrder=true;
	if(document.forms[0].mealOrderFor[0].checked == true) {
		isOPOrder=true;
	}
	else {
		isOPOrder=false;
	}
	
	if (isOPOrder==true) {apply_OP();}
	
	else if (isOPOrder==false) {apply_EM();}
}

//Function : For updating the records
function apply_OP()
{
	//ML-MMOH-CRF-0687
	var formObj =document.forms[0];
	var isComplaintCnt = formObj.isComplaintCnt.value;
	var isMealComplaints = formObj.isMealComplaints.value;//Added Against ML-MMOH-CRF-1125 
	var chkYN="";
	if(isComplaintCnt=="true" || isMealComplaints=="true") //Added Against ML-MMOH-SCF-1681
		chkYN="Y";
	else	
		chkYN="N";
	//ML-MMOH-CRF-0687 
	var flag_check = true;
	var divOrderList 	= parent.Docresult_add_mod.document.getElementById("divDocOPOrderList");
	var tmpLocale 		= parent.Docquery_add_mod.document.getElementById("locale");
	var bRecordUpd 		= false;
	for(var i=0;i<divOrderList.rows.length; i++)
	{ 		
	var tmpstatus 		= parent.frames.Docresult_add_mod.document.getElementById("status"+i).value;
	var langVisitDate 	= convertDate(parent.frames.Docresult_add_mod.document.getElementById("visitDate"+i).value,'DMYHM',tmpLocale,'en');
	var langAckDate   	= convertDate(parent.frames.Docresult_add_mod.document.getElementById("ackDate"+i).value,'DMYHM',tmpLocale,'en');
	/* Added Against Start ML-MMOH-CRF-0683 [IN062278]*/
	var complaint_desc = parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+ i).value;
	//Added Newly Against ML-MMOH-CRF-1125 Starts Here
	if(isMealComplaints=="true"){
		var othersComp_desc = parent.frames.Docresult_add_mod.document.getElementById("othersComp"+ i).value;
	}
	//Added Newly Against ML-MMOH-CRF-1125 Ends Here
	if(complaint_desc!="" && complaint_desc!=undefined){
	var complaint_code = parent.frames.Docresult_add_mod.document.getElementById("complaintCode"+ i).value;
	}else{
	parent.frames.Docresult_add_mod.document.getElementById("complaintCode"+ i).value="";
	}
	/* Added Against End ML-MMOH-CRF-0683 [IN062278]*/			
		if(tmpstatus != "" && langAckDate == "")
		{
			var error=getMessage("DS_DATETIME_NOT_BLANK","DS");//"Date / Time Cannot be Blank"; 
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
			return false;
		}
		/* Added Against Start ML-MMOH-CRF-0683 [IN062278]*/
		else if(tmpstatus=="MR"){
		//Modified Against ML-MMOH-CRF-1125 Starts Here 
		if(isMealComplaints=="true"){
			 if (complaint_code == "" || complaint_desc == ""  && othersComp_desc==""){	
				var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS") //"APP-SM0073 Complaints cannot be blank";
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
				flag_check = 'false';
				return false;
			}
		}
		else{
			if (complaint_code == "" || complaint_desc == ""){
				var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS") //"APP-SM0073 Complaints cannot be blank";
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
				flag_check = 'false';
				return false;
			}
		//Modified Against ML-MMOH-CRF-1125 Ends Here 
			}
		}
		/* Added Against End ML-MMOH-CRF-0683 [IN062278]*/
		//Validation : atleast one record should be updated:
		var hdnstatus 	= parent.frames.Docresult_add_mod.document.getElementById("hdnstatus"+i).value;
		var hdnackdate 	= parent.frames.Docresult_add_mod.document.getElementById("hdnackDate"+i).value;
	
		if(hdnstatus != tmpstatus || hdnackdate != langAckDate)
		{ 
			bRecordUpd = true;
		}
		var flag = compareDate(langVisitDate, langAckDate);
		if(flag != 0 || (langVisitDate == "" && langAckDate != "")){
			var error=getMessage("DS_STATDAT_VISDAT_SAME","DS");//"Status Date Should be Same as Visit Date."; 
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
			return false;
		}else{
			var error=""; 
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
		}
	}
	bRecordUpd=true;//Atleast One Record Should Be Updated
	if(!bRecordUpd)
	{
		var error=getMessage("DS_UPD_REC","DS");//"Atleast One Record Should Be Updated."; 
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
		return false;
	}
	
	if (flag_check){
		submitForm();
		//ML-MMOH-CRF-0687
		if(chkYN=="Y"){	
			error="";
			top.frames[1].location.href=top.frames[1].location.href;
		}
		//ML-MMOH-CRF-0687
	}
}

//Function : For updating the records
function apply_EM()
{	
	//ML-MMOH-CRF-0687
	var formObj =document.forms[0];
	var isComplaintCnt = formObj.isComplaintCnt.value;
	var isMealComplaints = formObj.isMealComplaints.value;//Added Against ML-MMOH-CRF-1125 
	var chkYN="";
	if(isComplaintCnt=="true" || isMealComplaints=="true") //Added Against ML-MMOH-SCF-1681
		chkYN="Y";
	else	
		chkYN="N";
	//ML-MMOH-CRF-0687
	var flag_check = true;
	var divOrderList 	= parent.Docresult_add_mod.document.getElementById("divDocEMOrderList");
	var tmpLocale 		= parent.Docquery_add_mod.document.getElementById("locale");
	var bRecordUpd 		= false;
	for(var i=0;i<divOrderList.rows.length; i++)
	{ 
		
	 var tmpstatus 		= parent.frames.Docresult_add_mod.document.getElementById("status_EM"+i).value;
	 var langVisitDate 	= convertDate(parent.frames.Docresult_add_mod.document.getElementById("visitDate_EM"+i).value,'DMYHM',tmpLocale,'en');
	 var langAckDate   	= convertDate(parent.frames.Docresult_add_mod.document.getElementById("ackDate_EM"+i).value,'DMYHM',tmpLocale,'en');
	 /* Added Against Start ML-MMOH-CRF-0683 [IN062278]*/
	 var complaint_desc = parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+ i).value;
	 //Added Newly Against ML-MMOH-CRF-1125 Starts Here
	 if(isMealComplaints=="true"){
	 	var othersComp_desc = parent.frames.Docresult_add_mod.document.getElementById("othersComp"+ i).value;
	 }
	 //Added Newly Against ML-MMOH-CRF-1125 Ends Here
  	 if(complaint_desc!="" && complaint_desc!=undefined){
	 var complaint_code = parent.frames.Docresult_add_mod.document.getElementById("complaintCode"+ i).value;
	 }else{
	 parent.frames.Docresult_add_mod.document.getElementById("complaintCode"+ i).value="";
	}
	/* Added Against End ML-MMOH-CRF-0683 [IN062278]*/
		if(tmpstatus != "" && langAckDate == "")
		{
			var error=getMessage("DS_DATETIME_NOT_BLANK","DS");//"Date / Time Cannot be Blank"; 
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
			return false;
		}	
		/* Added Against Start ML-MMOH-CRF-0683 [IN062278]*/
		else if(tmpstatus=="MR"){
		//Modified Against ML-MMOH-CRF-1125 Starts Here 
		if(isMealComplaints=="true"){
			 if (complaint_code == "" || complaint_desc == ""  && othersComp_desc==""){	
				var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS") //"APP-SM0073 Complaints cannot be blank";
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
				flag_check = 'false';
				return false;
			}
		}
		else{
			if (complaint_code == "" || complaint_desc == ""){
				var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS") //"APP-SM0073 Complaints cannot be blank";
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
				flag_check = 'false';
				return false;
			}
		//Modified Against ML-MMOH-CRF-1125 Ends Here 
			}
		}
		/* Added Against End ML-MMOH-CRF-0683 [IN062278]*/
		//Validation : atleast one record should be updated:
		var hdnstatus 	= parent.frames.Docresult_add_mod.document.getElementById("hdnstatus_EM"+i).value;
		var hdnackdate 	= parent.frames.Docresult_add_mod.document.getElementById("hdnackDate_EM"+i).value;
	
		if(hdnstatus != tmpstatus || hdnackdate != langAckDate)
		{ 
			bRecordUpd = true;
		}
		var flag = compareDate(langVisitDate, langAckDate);

		//if(flag != 0 || (langVisitDate == "" && langAckDate != "")){
		if((langVisitDate == "" && langAckDate != "")){	//ML-MMOH-CRF-1651 US002
			var error=getMessage("DS_STATDAT_VISDAT_SAME","DS");//"Status Date Should be Same as Visit Date."; 
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
			return false;
		}else
		{
			var error=""; 
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
		}
	}
	bRecordUpd=true;//Atleast One Record Should Be Updated
	if(!bRecordUpd)
	{
		var error=getMessage("DS_UPD_REC","DS");//"Atleast One Record Should Be Updated."; 
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
		return false;
	}
	
	if (flag_check){
		submitForm_EM();
		//ML-MMOH-CRF-0687
		if(chkYN=="Y"){	
			error="";
			top.frames[1].location.href=top.frames[1].location.href;
		}
		//ML-MMOH-CRF-0687
	}
}

//Function : For submitting this form to the servlet
function submitForm(){	
	var formObj = parent.Docresult_add_mod.document.forms[0];
	var mealtype = document.getElementById("mealType").value;
	var servingDate = document.getElementById("servingdate").value;
	var speciality = document.getElementById("speciality").value;
	var nRows = parent.Docresult_add_mod.document.getElementById("totalRows").value;
	
	formObj.method='post';	
	var params = "mealtype="+mealtype+"&servingDate="+servingDate+"&speciality="+speciality+"&nRows="+nRows+"&OPFlag=Y";
	formObj.action="../../servlet/eDS.DocumentOPMealServlet?mode=applyDocMealOrder&" + params;
	
	formObj.submit();
}

function submitForm_EM(){ 
	
	var formObj = parent.Docresult_add_mod.document.forms[0];
	var mealtype = document.getElementById("mealType_EM").value;
	var servingDate = document.getElementById("servingdate_EM").value;
	var speciality = "";
	var nRows = parent.Docresult_add_mod.document.getElementById("totalRows_EM").value;
	
	formObj.method='post';
	
	var params = "mealtype="+mealtype+"&servingDate="+servingDate+"&speciality="+speciality+"&nRows="+nRows+"&OPFlag=N";
	formObj.action="../../servlet/eDS.DocumentOPMealServlet?mode=applyDocMealOrder&" + params;
	
	formObj.submit();
}

function setStatusForAll() {
	var isOPOrder=true;
	if(parent.frames.Docquery_add_mod.document.forms[0].mealOrderFor[0].checked == true) {
		isOPOrder=true;
	}
	else {
		isOPOrder=false;
	}
	
	if (isOPOrder==true) {setStatusForAll_OP();}
	
	else if (isOPOrder==false) {setStatusForAll_EM();}	
}

//Function: For Setting Header status value to status of all rows/records of the table:
			// Status --> (Served-MS)  (Accept-MA)  (Reject-MR)   
function setStatusForAll_OP(){
	var divOrderList = parent.frames.Docresult_add_mod.document.getElementById("divDocOPOrderList");
	var isMealComplaints = parent.frames.Docresult_add_mod.document.getElementById("isMealComplaints").value;//Added Against MOH-CRF-1125	
	for(var i=0;i<divOrderList.rows.length; i++)
	{ 
		var tmpRowStatus =parent.frames.Docresult_add_mod.document.getElementById("hdnstatus"+i).value;
		var newRowStatus = parent.frames.Docresult_add_mod.document.getElementById("setStatus").value;
		
		if(isMealComplaints=="true"){
			var othersDesc = parent.frames.Docresult_add_mod.document.getElementById("othersComp"+i).value; 
			var complaintDesc = parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).value;
		}
		if(tmpRowStatus != "" && newRowStatus == "")
			continue;			
		if(newRowStatus == 'MS')
		{
			if (tmpRowStatus != 'MA' && tmpRowStatus != 'MR')
			{
				parent.frames.Docresult_add_mod.document.getElementById("status"+i).value = parent.frames.Docresult_add_mod.document.getElementById("setStatus").value ;
			}
			//Added Against Start ML-MMOH-CRF-681			
			parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="hidden";
			//Added Against ML-MMOH-CRF-1125 Starts Here
			if(isMealComplaints=="true"){
				parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="hidden";
			}
			//Added Against ML-MMOH-CRF-1125 Ends Here
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=true;	
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).value = "N";
			if(isMealComplaints=="true"){
			if(tmpRowStatus == 'MR'){
			if(complaintDesc!=""){
				parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).disabled=true;
				parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).disabled=false;
				parent.frames.Docresult_add_mod.document.getElementById("bt"+i).disabled=false;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=false;	
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).value = "N";
			}else if(othersDesc!=""){
				parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).disabled=true;
				parent.frames.Docresult_add_mod.document.getElementById("bt"+i).disabled=true;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=false;	
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).value = "N";
			}else{
				parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=false;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).value = "N";
			}
			}
			}
			//Added Against End ML-MMOH-CRF-681					
		}else
		{
			parent.frames.Docresult_add_mod.document.getElementById("status"+i).value = parent.frames.Docresult_add_mod.document.getElementById("setStatus").value ;
			//Added Against Start ML-MMOH-CRF-681
			if(newRowStatus == "MR"){
				parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="visible";//Added Against  ML-MMOH-CRF-683
				//Added Against ML-MMOH-CRF-1125 Starts Here
				if(isMealComplaints=="true"){
				if(complaintDesc!=""){
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).disabled=true;
					parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).disabled=false;
					parent.frames.Docresult_add_mod.document.getElementById("bt"+i).disabled=false;
				}else if(othersDesc!=""){
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
					parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).disabled=true;
					parent.frames.Docresult_add_mod.document.getElementById("bt"+i).disabled=true;
				}else{
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
				}
				}
				//Added Against ML-MMOH-CRF-1125 Ends Here
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=false;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).options[0].selected=true;
			}else{
				parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="hidden";//Added Against  ML-MMOH-CRF-683
				//Added Against ML-MMOH-CRF-1125 Starts Here
				if(isMealComplaints=="true"){
				if(othersDesc != ""){
					parent.frames.Docresult_add_mod.document.getElementById("othersComp"+i).value = "";
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="hidden";
				}
				else{
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="hidden";
				}
					parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).disabled=false;
					parent.frames.Docresult_add_mod.document.getElementById("bt"+i).disabled=false;
				}
				//Added Against ML-MMOH-CRF-1125
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=true;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).value = "N";
			}	 	
			//Added Against End ML-MMOH-CRF-681
		}
	}
}

//Function: For Setting Header status value to status of all rows/records of the table:
function setStatusForAll_EM(){
	var divOrderList = parent.frames.Docresult_add_mod.document.getElementById("divDocEMOrderList");
	var isMealComplaints = parent.frames.Docresult_add_mod.document.getElementById("isMealComplaints").value;//Added Against MOH-CRF-1125
	for(var i=0;i<divOrderList.rows.length; i++)
	{ 
		var tmpRowStatus =parent.frames.Docresult_add_mod.document.getElementById("hdnstatus_EM"+i).value;
		var newRowStatus = parent.frames.Docresult_add_mod.document.getElementById("setStatus").value;
		//Added Newly Against ML-MMOH-CRF-1125 Starts Here
		if(isMealComplaints=="true"){
			var othersDesc = parent.frames.Docresult_add_mod.document.getElementById("othersComp"+i).value; 
			var complaintDesc = parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).value;
		}
		//Added Newly Against ML-MMOH-CRF-1125 Ends Here
		if(tmpRowStatus != "" && newRowStatus == "")
			continue;
			
		if(newRowStatus == 'MS')
		{
			if (tmpRowStatus != 'MA' && tmpRowStatus != 'MR')
			{
				parent.frames.Docresult_add_mod.document.getElementById("status_EM"+i).value = parent.frames.Docresult_add_mod.document.getElementById("setStatus").value ;
			}
			//Added Against Start ML-MMOH-CRF-681	
			parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="hidden";//Added Against  ML-MMOH-CRF-683
			//Added Against ML-MMOH-CRF-1125 Starts Here
			if(isMealComplaints=="true"){
				parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="hidden";
			}
			//Added Against ML-MMOH-CRF-1125 Ends Here
			parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=true;	
			parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).value = "N";
			//Added Against End ML-MMOH-CRF-681
			//Added Against ML-MMOH-CRF-1125-US4 Starts Here
			if(isMealComplaints=="true"){
			if(tmpRowStatus == 'MR'){
			if(complaintDesc!=""){
				parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).disabled=true;
				parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).disabled=false;
				parent.frames.Docresult_add_mod.document.getElementById("bt"+i).disabled=false;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=false;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).value = "N";
			}else if(othersDesc!=""){
				parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).disabled=true;
				parent.frames.Docresult_add_mod.document.getElementById("bt"+i).disabled=true;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=false;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).value = "N";
			}else{
				parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="visible";
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=false;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).value = "N";
			}
			}
			}
			//Added Against ML-MMOH-CRF-1125-US4 Ends Here
		}else
		{
			parent.frames.Docresult_add_mod.document.getElementById("status_EM"+i).value = parent.frames.Docresult_add_mod.document.getElementById("setStatus").value ;
			//Added Against Start ML-MMOH-CRF-681
			if(newRowStatus == "MR"){
				parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="visible";//Added Against  ML-MMOH-CRF-683
				//Added Against ML-MMOH-CRF-1125 Starts Here
				if(isMealComplaints=="true"){
				if(complaintDesc!=""){
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).disabled=true;
					parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).disabled=false;
					parent.frames.Docresult_add_mod.document.getElementById("bt"+i).disabled=false;
				}else if(othersDesc!=""){
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
					parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).disabled=true;
					parent.frames.Docresult_add_mod.document.getElementById("bt"+i).disabled=true;
				}else{
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="visible";
				}
				}
				//Added Against ML-MMOH-CRF-1125 Ends Here
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).options[0].selected=true;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=false;
			}else{
				parent.frames.Docresult_add_mod.document.getElementById("cmp"+i).style.visibility="hidden";//Added Against  ML-MMOH-CRF-683
				//Added Against ML-MMOH-CRF-1125 Starts Here
				if(isMealComplaints=="true"){
				if(othersDesc != ""){
					parent.frames.Docresult_add_mod.document.getElementById("othersComp"+i).value = "";
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="hidden";
				}
				else{
					parent.frames.Docresult_add_mod.document.getElementById("othersLink"+i).style.visibility="hidden";
				}
				parent.frames.Docresult_add_mod.document.getElementById("complaintDesc"+i).disabled=false;
				parent.frames.Docresult_add_mod.document.getElementById("bt"+i).disabled=false;
				}
				//Added Against ML-MMOH-CRF-1125 Ends Here
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).disabled=true;
				parent.frames.Docresult_add_mod.document.getElementById("MealReplaceYn"+i).value = "N";
			}	 	
			//Added Against End ML-MMOH-CRF-681
		}
	}
}

function setDateForAll() {
	var isOPOrder=true;
	if(parent.frames.Docquery_add_mod.document.forms[0].mealOrderFor[0].checked == true) {
		isOPOrder=true;
	}
	else {
		isOPOrder=false;
	}
	
	if (isOPOrder==true) {setDateForAll_OP();}
	
	else if (isOPOrder==false) {setDateForAll_EM();}	
}

//Function: For Setting Header Date value to Date of all rows/records of the table:
function setDateForAll_OP(){
	var divOrderList = parent.frames.Docresult_add_mod.document.getElementById("divDocOPOrderList");	
	for(var i=0;i<divOrderList.rows.length; i++)
	{
		parent.frames.Docresult_add_mod.document.getElementById("ackDate"+i).value = parent.frames.Docresult_add_mod.document.getElementById("setDate").value ;
	}
}

//Function: For Setting Header Date value to Date of all rows/records of the table:
function setDateForAll_EM(){

	var divOrderList = parent.frames.Docresult_add_mod.document.getElementById("divDocEMOrderList");	
	for(var i=0;i<divOrderList.rows.length; i++)
	{
		parent.frames.Docresult_add_mod.document.getElementById("ackDate_EM"+i).value = parent.frames.Docresult_add_mod.document.getElementById("setDate").value ;
	}
}

//FOr creating new cell on row:
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

/* This function is to show the search criteria for OP or Emergency Patients based on the selection */

function showSearchCriteria(obj) {
//	parent.placeMealOrderOPResult.location.href='../../eCommon/html/blank.html';
	var error=""; 
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	
	if(obj.value=='OP') {
		for(var i=0;i<document.getElementsByClassName("Row_OutPatient").length;i++) {
			document.getElementsByClassName("Row_OutPatient")[i].style='display';
		}
		for(var i=0;i<document.getElementsByClassName("Row_EMPatient").length;i++) {
			document.getElementsByClassName("Row_EMPatient")[i].style.display='none';
//			document.getElementsByClassName("Row_EMPatient")[i].style.visibility='hidden';
		}
//		resetEMFields();
	}
	else if(obj.value=='EM') {
		for(var i=0;i<document.getElementsByClassName("Row_OutPatient").length;i++) {
			document.getElementsByClassName("Row_OutPatient")[i].style.display='none';
//			document.getElementById("Row_OutPatient")[i].style.visibility='hidden';
		}
		for(var i=0;i<document.getElementsByClassName("Row_EMPatient").length;i++) {
			document.getElementsByClassName("Row_EMPatient")[i].style='display';
		}
//		resetOPFields();
		populateFieldsForAE();
	}
}

//Function: For pre-populating the search criteria fields for AE patients
function populateFieldsForAE(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var param="language_Id=en&mode=initialLoad";
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.DocumentOPMealServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;

	var jsonObjResponse=eval('(' + retVal + ')');	

	//Getting location type List::
	var locList=new Array();
	locList = jsonObjResponse.locList;
	
	var obj = document.getElementById("loctype_EM");
	while(obj.length > 0){
			obj.remove(0);
		}
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	
	if(locList!=null)
	{
		for(var itr=0; itr < locList.length;itr++){
				var Entry = document.createElement("option");
				Entry.value = locList[itr].LocCode;
				Entry.text  = locList[itr].LocDesc;
				if(locList[itr].LocCode=='C'){ Entry.selected=true;}
				obj.add(Entry);
		}
	}
	obj.disabled=true;
	
	//Load 3 : Getting Meal List::
	var mealList=new Array();
	mealList = jsonObjResponse.mealList_EM;
	var obj = document.getElementById("mealType_EM");
	while(obj.length > 0){
			obj.remove(0);
		}
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	
	if(mealList!=null)
	{
		for(var itr=0; itr < mealList.length;itr++){
				var Entry = document.createElement("option");
				Entry.value = mealList[itr].mealType;
				Entry.text  = mealList[itr].mealDesc;
				obj.add(Entry);
		}
	}

	//Getting Priority Zone List::
	var priorityZoneList=new Array();
	priorityZoneList = jsonObjResponse.priorityZoneList;	
	var obj = document.getElementById("priorityZone");
	while(obj.length > 0){
			obj.remove(0);
		}
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	
	if(priorityZoneList!=null)
	{
		for(var itr=0; itr < priorityZoneList.length;itr++){
				var Entry = document.createElement("option");
				Entry.value = priorityZoneList[itr].pZoneCode;
				Entry.text  = priorityZoneList[itr].pZoneDesc;
				obj.add(Entry);
		}
	}	
	//Getting mulitifacility value::
	/*var multifacility = jsonObjResponse.multifacility;
	var obj = document.getElementById("alterfacility");	
	var isAlternateBooking=document.getElementById("alternateBooking").value;
	if(multifacility == "Y")
		obj.disabled=false;
	else
		obj.disabled=true;
		
	if(isAlternateBooking=="Y")  obj.disabled=true;*/
}

function getTreatmentArea() {
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var facilityId=document.getElementById("facility_id").value;
	var clinicCode=document.getElementById("hdnlocation_EM").value;
//	var clinicCode='2S2S';
	var locale=document.getElementById("locale").value;
	var obj = document.getElementById("treatmentArea");
	var priorityZone=document.all("priorityZone").options[document.all("priorityZone").selectedIndex].text;
	if(priorityZone=="----select----") {priorityZone="";}
	
	var param="language_Id="+locale+"&facilityId="+facilityId+"&clinicCode="+clinicCode+"&mode=getTreatmentArea&priorityZone="+priorityZone;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.DocumentOPMealServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;

	var jsonObjResponse=eval('(' + retVal + ')');
	
	var trmntAreaCodeArr=new Array();
	var trmntAreaDescArr=new Array();
	
	trmntAreaCodeArr= jsonObjResponse.treatmentAreaCode;
	trmntAreaDescArr=jsonObjResponse.treatmentAreaDesc;
	
	while(obj.length > 0){
		obj.remove(0);
	}
	var Entry = document.createElement("OPTION");
	var msg = "----Select----";
	Entry.text = msg;
	Entry.value= "";
	obj.add(Entry);
	if(trmntAreaCodeArr!=null) {
		for(var j=0; j < trmntAreaCodeArr.length; j++){
			var Entry = document.createElement("option");
			Entry.value  = trmntAreaCodeArr[j];
			Entry.text  = trmntAreaDescArr[j];
			obj.add(Entry);
		}
	}
} 

//Added Against ML-MMOH-CRF-1125 Starts Here
async function complaintsLookup(obj, index) {
	var formObj = document.forms[0];
	var locale = document.getElementById("locale").value;
	var isMealComplaints = formObj.isMealComplaints.value;//Added Against ML-MMOH-CRF-1125
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT COMPLAINTS.LONG_DESC DESCRIPTION, COMPLAINTS.COMPLAINT_CODE  CODE FROM DS_COMPLAINTS_LANG_VW COMPLAINTS WHERE UPPER(COMPLAINTS.LONG_DESC) LIKE UPPER(?) AND UPPER(COMPLAINTS.COMPLAINT_CODE) LIKE UPPER(?) AND COMPLAINTS.LANGUAGE_ID= '"
			+ locale + "' AND   COMPLAINTS.EFF_STATUS='E'";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.getElementById("complaintDesc" + index).value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
//	var title = "TITLE";
	var title=getLabel("eOT.Complaints.Label","OT");
	returnedValues = await CommonLookup(title, argumentArray);
	var link ="";
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		document.getElementById("complaintDesc" + index).value = arr[1];
		document.getElementById("complaintCode" + index).value = arr[0];
		//Added Newly Against ML-MMOH-CRF-1125 Starts Here
		if(isMealComplaints=="true"){
			document.getElementById("othersLink"+ index).disabled=true;
			document.getElementById("othersLink"+ index).removeAttribute('href');
		}
		//Added Newly Against ML-MMOH-CRF-1125 Ends Here
	} else {
		document.getElementById("complaintDesc" + index).value = '';
		document.getElementById("complaintCode" + index).value = '';
		//Added Newly Against ML-MMOH-CRF-1125 Starts Here
		if(isMealComplaints=="true"){
			 document.getElementById("othersLink"+index).disabled=false;
			 document.getElementById("othersLink"+index).style.cursor = 'hand';
			 document.getElementById("othersLink"+index).setAttribute('href', 'javascript:OtherComplaints('+index+')');
		}
		//Added Newly Against ML-MMOH-CRF-1125 Ends Here		
	}
}

async function OtherComplaints(index){
	var isDisableChk = document.getElementById("complaintDesc"+index).value; //ICN-1125US003
	if(isDisableChk!="" && isDisableChk!=null)
	return;
	var others = "";	
	var othersCmpHdr = "";
	othersCmpHdr = document.getElementById("othersComp"+index).value;
	if(others != "" || others != null || others == undefined){
		if(othersCmpHdr != ""){
			 others = othersCmpHdr;
		}
		else{
			 othersCmpHdr = others;
		}
	}
	else{
		othersCmpHdr = "";
	}
	var dialogUrl1 = "../../eDS/jsp/OtherComplaints.jsp?&othersCmpHdr="+encodeURIComponent(othersCmpHdr)+"&index="+index;	
	var dialogArguments = others;
	var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";
	returnOthersCmp = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if(returnOthersCmp != null){
		others = returnOthersCmp;
		if(others!= ""){
		document.getElementById("othersLink"+index).disabled=false; 
		document.getElementById("complaintDesc"+index).disabled=true;
		document.getElementById("bt"+index).disabled=true;
		}else{
		document.getElementById("othersLink"+index).disabled = false; 
		document.getElementById("complaintDesc"+index).disabled = false;
		document.getElementById("bt"+index).disabled = false;		
		}
	}
		document.getElementById("othersComp"+index).value = others;
	if(returnOthersCmp == undefined && othersCmpHdr =="" && others==""){
		document.getElementById("othersLink"+index).enabled=true; 
		document.getElementById("complaintDesc"+index).enabled=true;
		document.getElementById("bt"+index).enabled=true;
		returnOthersCmp = dialogArguments;
	}
}	

function getOthersCompliants(val) {
	var others = "";	
	others = val;
	window.returnValue = others;
	window.close();
}

function textAreaLimit1(field, maxlen) {
	//if (field.value.length > maxlen + 1) //Commented Against ML-MMOH-CRF-1816
	if (field.value.length > maxlen)
	field.value = field.value.substring(0, maxlen);
}

function enableOthers_OP(index){	
	var formObj = parent.Docresult_add_mod.document.forms[0];
	var status = formObj.document.getElementById("status"+index).value;
	if(document.getElementById("complaintDesc"+index).value==""){
	var isMealComplaints = document.getElementById("isMealComplaints").value;
	if(isMealComplaints=='true'){
	if(status!="" && status=="MR"){
		var Others = "Others";
		var empty = "empty";		
		var link = "<a id='othersLink"+index+"' name='othersLink"+index+"' style='visibility:visible'  href='javascript:OtherComplaints("+index+");'> "+Others+" </a>"+"<input type=hidden id='othersComp"+index+"' name='othersComp"+index+"' id='othersComp"+index+"' value='"+empty+"'>";
		document.getElementById("othersLink"+index).disabled=false;
		document.getElementById("othersLink"+index).style.cursor = 'hand';
		document.getElementById("othersLink"+index).setAttribute('href', 'javascript:OtherComplaints('+index+')');
	}
	}
	}	
}

function enableOthers_EM(index){
	var formObj = parent.Docresult_add_mod.document.forms[0];
	var status_EM = formObj.document.getElementById("status_EM"+index).value;
	if(document.getElementById("complaintDesc"+index).value==""){
	var isMealComplaints = document.getElementById("isMealComplaints").value;
	if(isMealComplaints=='true'){
	if(status_EM!="" && status_EM=="MR"){
		var Others = "Others";
		var empty = "empty";		
		var link = "<a id='othersLink"+index+"' name='othersLink"+index+"' style='visibility:visible'  href='javascript:OtherComplaints("+index+");'> "+Others+" </a>"+"<input type=hidden id='othersComp"+index+"' name='othersComp"+index+"' id='othersComp"+index+"' value='"+empty+"'>";
		document.getElementById("othersLink"+index).disabled=false;
		document.getElementById("othersLink"+index).style.cursor = 'hand';
		document.getElementById("othersLink"+index).setAttribute('href', 'javascript:OtherComplaints('+index+')');
	}
	}
	}	
}
//Added Against ML-MMOH-CRF-1125 Ends Here

