
var viewId;

function tabClicked(evt) {
	var selectedTabPane = evt.getTabPane();
	viewId = selectedTabPane.id;
}
function complaint()
	{
		var moduleId="LC";
		var functionId="LC_LODGE_COMPLAINT";
	parent.content.location.href=contextPath+"/LodgeComplaintAction.do?method="+loadMethod+"&functionId="+functionId
		

	}
    	   
function checkNull() {
	var flag;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.lodgeComplaint.complaintNo", "com.iba.ehis.lc.lodgeComplaint.complaintDate", "com.iba.ehis.lc.lodgeComplaint.complaintSourceType","com.iba.ehis.lc.lodgeComplaint.complaintAgnSourceType","com.iba.ehis.lc.lodgeComplaint.complaintActivity","com.iba.ehis.lc.complaint","com.iba.ehis.lc.lodgeComplaint.complaintBy");
	var fields = new Array(document.LodgeComplaintForm["vo.complaintNum"], document.LodgeComplaintForm["vo.complaintDate"], document.LodgeComplaintForm["vo.complaintSourceType"],document.LodgeComplaintForm["vo.complaintAgainstSourceType"],document.LodgeComplaintForm["vo.complaintActivity"],document.LodgeComplaintForm["vo.complaint"],document.LodgeComplaintForm["vo.complaintBy"]);
	var key_value=new Array();
 	for(j=0;j<fieldName.length;j++)
 	{
 		if(fields[j].value=="")
		{	
	 		getServerMessage(fieldName[j]);
	 		key_value[j]=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
	 		msgArray=msg.split('#');
	 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
	 		flag=false;
 		}
 	}
	parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}
function checkNull1() {
	var flag;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.lodgeComplaint.refNo", "com.iba.ehis.lc.lodgeComplaint.dateTime", "com.iba.ehis.lc.linenItem","com.iba.ehis.lc.requestForCleaningLinen.quantity");
	var fields = new Array(document.LodgeComplaintForm["refNo"], document.LodgeComplaintForm["dateTime1"], document.LodgeComplaintForm["linenItem"],document.LodgeComplaintForm["qty"]);
	var key_value=new Array();
 	for(j=0;j<fieldName.length;j++)
 	{
 		if(fields[j].value=="")
		{	
	 		getServerMessage(fieldName[j]);
	 		key_value[j]=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
	 		msgArray=msg.split('#');
	 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
	 		flag=false;
 		}
 	}
	parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}
//==============================================================
function complaintCommonLookup(mode)
	{
			if(mode=="complaintSource"){
								if(document.getElementById("complaintSourceDesc").value!="")
									{showLookup();}
							
			}
			else if(mode=="complaintAgainstSourceDesc"){
								if(document.getElementById("complaintAgainstSourceDesc").value!="")
									{showLookupAgn();}
							
			}
			else if(mode=="refNo"){
								if(document.getElementById("refNo").value!="")
									{showLookupRefNo();}
							
			}
			else if(mode=="linenDesc"){
								if(document.getElementById("linenDesc").value!="")
									{showRefNoDetail();}
								else
								document.getElementById("linenItem").value="";

							
			}

	}
function showLookup1() {
	var sourceType=document.getElementById("vo.complaintSourceType").value;
	var sourceCode=document.getElementById("vo.complaintSource").value;
	var user=document.getElementById("laundry").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	if(user=="Laundry")
	{	argArray[0] = "ehis.lc.lodgeComplaint.getlaundryLinen"
		namesArray[0]="languageId";
		valuesArray[0] = document.getElementById("languageId").value;
	}
	else
	{
	argArray[0] = "ehis.lc.requestForLinen.getlinen"

	namesArray[0]="languageId";
	namesArray[1]="sourceType";
	namesArray[2]="sourceCode";
	valuesArray[0] = document.getElementById("languageId").value;
	valuesArray[1] = sourceType;
	valuesArray[2] = sourceCode;
	}

	

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("linenDesc").value;
	retArr = Lookup("LinenItemCode", argArray);
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			if(user=="Laundry")
			{
				document.getElementById("linenItem").value=retArr[0];
				document.getElementById("linenDesc").value=retArr[1];

			}
			else{
			var linenTxt=document.getElementById("linenItem");
			linenTxt.value = retArr[0];
			document.getElementById("linenDesc").value=retArr[1];
			}
			}
			else
			{
				
				document.getElementById("linenItem").value="";
				document.getElementById("linenDesc").value="";
							
			}
	
}		
function showLookup() {
	var sourceType=document.getElementById("vo.complaintSourceType").value;
	var facilityId=document.getElementById("vo.addedFacilityId").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	if(sourceType=="W")
		{	argArray[0] = "ehis.lc.standardStock.nursingUnit"
		    
			namesArray[0]="facilityId";
		    namesArray[1]="languageId";	
			
			valuesArray[0]=document.getElementById("vo.addedFacilityId").value;
			valuesArray[1]=document.getElementById("languageId").value;
		}
		else if(sourceType=="C"){
			argArray[0] = "ehis.lc.standardStock.clinic"
			
			namesArray[0]="facilityId";
		    namesArray[1]="languageId";	
			
			valuesArray[0]=document.getElementById("vo.addedFacilityId").value;
			valuesArray[1]=document.getElementById("languageId").value;
		}
		else if(sourceType=="D"){
			argArray[0] = "ehis.lc.standardStock.deptCode";
		
		    namesArray[1]="languageId";	
			valuesArray[1]=document.getElementById("languageId").value;
		}else{
			argArray[0] = "ehis.lc.standardStock.nursingUnit";
			
			namesArray[0]="facilityId";
		    namesArray[1]="languageId";	
			
			valuesArray[0]=document.getElementById("vo.addedFacilityId").value;
			valuesArray[1]=document.getElementById("languageId").value;
		}

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("complaintSourceDesc").value;

	if(sourceType=="W"){
		getServerMessage("com.iba.ehis.lc.ward");
		retArr = Lookup(dwrMessage, argArray);
	}else if(sourceType=="C"){
		getServerMessage("com.iba.ehis.lc.clinic");
		retArr = Lookup(dwrMessage, argArray);
	}else if(sourceType=="D"){
		getServerMessage("com.iba.ehis.lc.department");
		retArr = Lookup(dwrMessage, argArray);
	}else{
		getServerMessage("com.iba.ehis.lc.ward");
		retArr = Lookup(dwrMessage, argArray);
	}

	var txtUser = document.getElementById("vo.complaintSource");

	if(retArr!=null){
		//Set the data in to the fields
		txtUser.value = retArr[0];
		document.getElementById("complaintSourceDesc").value = retArr[1];
		}
		else
		{document.getElementById("complaintSourceDesc").value = "";}
	}

function showLookupAgn() {
	var sourceType=document.getElementById("vo.complaintAgainstSourceType").value;
	var sourceCode=document.getElementById("vo.complaintSource").value;
	var facilityId=document.getElementById("vo.addedFacilityId").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	if(sourceType=="W")
		{	argArray[0] = "ehis.lc.standardStock.nursingUnit"
		    namesArray[0]="facilityId";
		    namesArray[1]="languageId";	
			valuesArray[0]=document.getElementById("vo.addedFacilityId").value;
			valuesArray[1]=document.getElementById("languageId").value;
			if(sourceCode!=''){
			namesArray[2] = "fcode";
			valuesArray[2] = sourceCode;}
		}
		else if(sourceType=="C"){
			argArray[0] = "ehis.lc.standardStock.clinic"

			namesArray[0]="facilityId";
		    namesArray[1]="languageId";	
			
			valuesArray[0]=document.getElementById("vo.addedFacilityId").value;
			valuesArray[1]=document.getElementById("languageId").value;
			if(sourceCode!=''){
			namesArray[2] = "fcode";
			valuesArray[2] = sourceCode;}
		}else if(sourceType=="D"){	
			argArray[0] = "ehis.lc.standardStock.deptCode"

			namesArray[1]="languageId";	
			valuesArray[1]=document.getElementById("languageId").value;
			if(sourceCode!=''){
			namesArray[2] = "fcode";
			valuesArray[2] = sourceCode;}
		}else{
			argArray[0] = "ehis.lc.standardStock.nursingUnit"

			namesArray[0]="facilityId";
		    namesArray[1]="languageId";	
			
			valuesArray[0]=document.getElementById("vo.addedFacilityId").value;
			valuesArray[1]=document.getElementById("languageId").value;
			if(sourceCode!=''){
			namesArray[2] = "fcode";
			valuesArray[2] = sourceCode;}
		}

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("complaintAgainstSourceDesc").value;
	getServerMessage("com.iba.ehis.lc.lodgeComplaint.againstsourceCode");
	retArr = Lookup(dwrMessage, argArray);
	var txtUser = document.getElementById("vo.complaintAgainstSource");
	if(retArr!=null)
		{
		//Set the data in to the fields
		txtUser.value = retArr[0];
		document.getElementById("complaintAgainstSourceDesc").value = retArr[1];
		}
		else
		{
		document.getElementById("complaintAgainstSourceDesc").value = "";
		document.getElementById("vo.complaintAgainstSource").value="";
		}
	}
	
//=========  date default===============
function CurrDate(){	
		
	var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		
		mon = mon+1;
		var year = currDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		var convert1= date + "/" + mon + "/" + year;
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		
		convert1=convert1+" "+hrNow+ ":" +mnNow;
		
		var rdate=document.getElementById("vo.complaintDate");
		var rdate1=document.getElementById("dateTime");
			rdate.value=convert1;
			rdate1.value=convert1;
}

function reasonlist(){
	if(LodgeComplaintForm["laundry"].value=="Laundry"){
		//disableSourceTypes();
			LodgeComplaint.getLaundryReason(document.getElementById("languageId").value, setLaundryData);
		}else{
			LodgeComplaint.getWardsReason(document.getElementById("languageId").value,setWardsdata);
		}
	}	 

function setWardsdata(data){
	var i=0;
	var defectReason;
	defectReason=LodgeComplaintForm["vo.complaint"];
	for(prop in data){
		DWRUtil.removeAllOptions(defectReason);
		DWRUtil.addOptions(defectReason, data, prop);
		}
	}

function setLaundryData(data){
	var i=0;
	var defectReason;
	defectReason=LodgeComplaintForm["vo.complaint"];
	
	for(prop in data){
			DWRUtil.removeAllOptions(defectReason);
			DWRUtil.addOptions(defectReason, data, prop);
		}
	}

function disableSourceTypes(){
	LodgeComplaintForm["complaintSourceDesc"].disabled=true;
	document.getElementById("bt2").disabled=true;
	}

function hideListBlock(obj){
	if(obj.value=="7"){
		document.getElementById("lowerBlock").style.visibility="hidden";
		document.getElementById("tableid").style.visibility="hidden";
		document.getElementById("listContentLayer").style.visibility="hidden";
	}else{
		document.getElementById("lowerBlock").style.visibility="visible";
		document.getElementById("tableid").style.visibility="visible";
		document.getElementById("listContentLayer").style.visibility="visible";
		}
	}
function showLookupRefNo() {
	var complaintActivity=document.getElementById("vo.complaintActivity").value;
	if(complaintActivity!=""){
	
	var facilityId=document.getElementById("vo.addedFacilityId").value;
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	if(complaintActivity=="1")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivityOnelookup"
	if(complaintActivity=="2")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivityTwolookup"
	if(complaintActivity=="3")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivityThreelookup"
	if(complaintActivity=="4")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivityFourlookup"
	if(complaintActivity=="5")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivityFivelookup"
	if(complaintActivity=="6")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivitySixlookup"
	//alert(complaintActivity+"==="+facilityId)
	namesArray[0]=facilityId;

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("refNo").value;
	getServerMessage("com.iba.ehis.lc.lodgeComplaint.refno");
	var label = dwrMessage;
	retArr = Lookup(label, argArray);
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			var linenTxt=document.getElementById("refNo");
			var dateTime=document.getElementById("dateTime");
			var locale=document.getElementById("vo.locale").value;
			linenTxt.value = retArr[1];
			dateTime.value=retArr[0];
			 IBADateValidator.convertDateJS(dateTime.value,"en",locale,"dd/MM/yyyy HH:mm",RDTocallbackMethod);
				function  RDTocallbackMethod(fdate){
					document.getElementById("dateTime1").value=fdate;
	
			} 
			// showRefNoDetail();
			}
			else{document.getElementById("refNo").value="";}
	}
	else{
		getServerMessage("com.iba.ehis.lc.lodgeComplaint.scactivity");
		var label = dwrMessage;
		alert(label)
	}
	
}		

function reset()
{
	complaint();
}

function getComplaintNo(){
	LodgeComplaint.getcomplaintNo(document.getElementById("vo.addedFacilityId").value,setComplaintNo);
}

function setComplaintNo(data){
	var obj=document.LodgeComplaintForm["vo.complaintNum"];
	var max=0;
	var temp=0;
	var i = 0;
	var popArray = new Array();
		for(prop in data){
			popArray[i] = prop;
			i++;
		 }
	for (var j=0; j <popArray.length;j++ ){
		if(parseInt(popArray[j])>parseInt(max))	
			max=parseInt(popArray[j]);
			}
		obj.value=parseInt(max)+1;
		
	}

function checkNumber1(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >0)
        return true;
   	else 
		if ( val == 0 ) {
            	getServerMessage("APP-LC00018");
				parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
				return false;
        }else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
				parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
}
//====================================
function showRefNoDetail() {
	if(document.getElementById("refNo").value!=""){
	var complaintActivity=document.getElementById("vo.complaintActivity").value;
	var reqNo=document.getElementById("refNo").value;
	var locale=document.getElementById("vo.locale").value;
	if(complaintActivity!=""){
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	if(complaintActivity=="1")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivityOnelookupDetail"
	if(complaintActivity=="2")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivityTwolookupDetail"
	if(complaintActivity=="3")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivityThreelookupDetail"
	if(complaintActivity=="4")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivityFourlookupDetail"
	if(complaintActivity=="5")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivityFivelookupDetail"
	if(complaintActivity=="6")
	argArray[0] = "ehis.lc.lodgeComplaint.CActivitySixlookupDetail"
	//alert(complaintActivity+"==="+reqNo)
	namesArray[0]="requestNo";
    valuesArray[0]=reqNo;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("refNo").value;
	getServerMessage("com.iba.ehis.lc.lodgeComplaint.refno");
	var label = dwrMessage;
	retArr = Lookup(label, argArray);
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			document.getElementById("qty").value=retArr[1];
			var Code=retArr[0];
			LodgeComplaint.getLinenDesc(Code,locale,callbackmethod);
			function callbackmethod(data)
				{
				for(prop in data){
								document.getElementById("linenDesc").value=data[prop];
								document.getElementById("linenItem").value=prop;
							}
				}
			
			}
			else{document.getElementById("qty").value="";
			document.getElementById("linenDesc").value="";
			}
	}
	else{
		getServerMessage("com.iba.ehis.lc.lodgeComplaint.scactivity");
		var label = dwrMessage;
		alert(label)
	}
	}else
	{
		getServerMessage("com.iba.ehis.lc.selectforbutton");
		var label1 = dwrMessage;
		getServerMessage("com.iba.ehis.lc.lodgeComplaint.refNo");
		var label2 = dwrMessage;
		alert(label1+" "+label2+"..")
	}
}		