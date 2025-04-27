/*  
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
22/01/2019	IN69244		Ramya Maddena	25/01/2019		Ramesh Goli	   MMS-KH-CRF-0005.1
28/06/2020	IN072777	Ramesh Goli		01/07/2020		Ramesh G		AAKH-CRF-0097.2
28/06/2020	IN073549	Ramesh Goli		01/07/2020		Ramesh G		CA-AAKH-CRF-0097.2/01-Task List
31/05/2021  IN017999    Chandrashekar a                                AAKH-CRF-0132.1
28/06/2021  IN020774    Chandrashekar a                                AAKH-CRF-132.1
09/06/2021				Ramesh Goli										MMS-QF-SCF-0653
19/10/2023              Srinivasa N T                                  AAKH-CRF-0165
--------------------------------------------------------------------------------------------------------------------
*/

function discretecompsearch(obj,target)
{
	
				//var locale = document.forms[0].locale.value;
                var tit = getLabel("Common.DiscreteComponent.label","common");
                sql = "Select  discr_msr_id code,short_desc description from AM_DISCR_MSR where upper(DISCR_MSR_ID) like upper(?) and upper(SHORT_DESC) like upper(?) order by short_desc ";					
			
			var retVal =    new String();               
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				 		
		
				retVal = await CommonLookup( tit, argumentArray );
alert(retVal)				
				if(retVal != null && retVal != "" )                             
                {					
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];					
					document.forms[0].disc_comp.value=arr[0];
				}
				else{
					target.value="";					
					document.forms[0].disc_comp.value="";
				}
				
				
}

function Vitalcontrol(){
	
		var disc_comp = document.getElementById("disc_comp").value;
		var short_desc=document.getElementById("short_desc").value;
		var from_date=document.getElementById("from_date").value;
		var date_to=document.getElementById("date_to").value;
        var patient_class="";
		var added_date = "";
		var added_facility_id = "";
		//alert("disc_comp===="+disc_comp);
		parent.VitalSignFrame.location.href = "../../eCA/jsp/VitalSignResult.jsp?discr_msr_id="+disc_comp+"&from_date="+from_date+"&to_date="+date_to+"&short_desc="+short_desc+"&added_date="+added_date+"&added_facility_id="+added_facility_id+"&patient_class="+patient_class+""; 
		
	}
	
function clear()
{
	//alert("Test1");
parent.VitalSignFrame.location.reload();
}

function chkDateTime(obj,format,locale)
{
	if(obj.value != '') 
	{		
		var from_date = document.getElementById("date_from");
		var to_date = document.getElementById("date_to");
		
		if(validDateObj(obj,format,locale))
		{			
			if(from_date.value != "" || to_date.value != "")
			{
				ftDateCheck(from_date,to_date,format,locale);
			}
		}
	}
}

function ftDateCheck(from,to,format,locale)
{
	
		if(from.value=="" && to.value=="")
		{
			alert("Period can't be empty");
			return;
		}
		if(!(from.value == "" ))
		{
			if(!isBeforeNow(from.value,format,locale))
			{
			
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				from.select();
				from.focus();
				return false;
				
			}
			else
			{ 
				if(!(to.value == "" ))
				{
				   if(isBeforeNow(to.value,format,locale))

				   {
					   if(isAfter(to.value,from.value, format, locale))
					   {
						   return true;
					   }
					   else
					   {
							alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
							to.select();
							to.focus();
							return false;
					   }
				   }
				   else
				   {
						alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
						to.select();
						to.focus();
						return false;
				   }
				}
			}
			if(!to.value=="")
			{
			 			 
			}
				
		}
		else
		{
			if((!to.value==""))
			{
				if(!isBeforeNow(to.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					to.select();
					to.focus();
					return false;
				}
			}
		}
}

function clickAll(){
	var totalDiscrIds = (document.forms[0].totalDiscrIds.value).split(',');
	if(document.getElementById('select_all').checked){
		for(var i=0;i<totalDiscrIds.length;i++){
			document.getElementById('M'+totalDiscrIds[i]).checked =true;
			selectGrp(document.getElementById('M'+totalDiscrIds[i]),totalDiscrIds[i]);
		}
		
	}else{
		for(var i=0;i<totalDiscrIds.length;i++){
			document.getElementById('M'+totalDiscrIds[i]).checked =false;
			selectGrp(document.getElementById('M'+totalDiscrIds[i]),totalDiscrIds[i]);
		}
	}
}

function clickAllVal(){
	//alert(175);
	var totalDiscrIds = (document.forms[0].totalDiscrIds.value).split(',');
	var totalChartCount = parent.VitalSignDetals.document.VitalSignResultFormDetals.totalCharts.value;
	//alert(totalChartCount);
	if(document.getElementById('select_all').checked){
		for(var i=0;i<totalDiscrIds.length;i++){//alert(161)
			document.getElementById('C'+totalDiscrIds[i]).value ='Y';
			document.getElementById('C'+totalDiscrIds[i]).checked=true;
		}
/*		for(var i=0;i<totalChartCount;i++){
			parent.VitalSignDetals.document.getElementById('ChartID'+i).checked = true;
		}*/
	}else{
		for(var i=0;i<totalDiscrIds.length;i++){//alert(167)
			document.getElementById('C'+totalDiscrIds[i]).value ='N';
		document.getElementById('C'+totalDiscrIds[i]).checked=false;
		}
/*		for(var i=0;i<totalChartCount;i++){
			parent.VitalSignDetals.document.getElementById('ChartID'+i).checked = false;
		}*/
	}
}
function selectGrp(obj,valDis){
	
	var count = document.getElementById('MV'+valDis).value;
	if(obj.checked){
		for(var i=0;i<count;i++){
			document.getElementById('C'+valDis+i).checked =true;
			document.getElementById('C'+valDis+i).value="Y";
		}		
	}else{
		for(var i=0;i<count;i++){
			document.getElementById('C'+valDis+i).checked =false;
			document.getElementById('C'+valDis+i).value="N";
		}
		document.getElementById('select_all').checked= false;
	}
	selectDiscreatList();	//IN072777
	parent.VitalSignDetals.location.href = "../../eCA/jsp/VitalSignApplicableChartDetails.jsp?selectedDiscret="+parent.VitalSignDetals.document.getElementById('selectedDiscret').value;	//IN072777
	
}
function selectEvent(obj,valDis){
	
	if(!obj.checked){		
		//document.getElementById(pobj).checked=false;  //IN072777
		document.getElementById('select_all').checked= false;
		obj.value="N";
		var count = document.getElementById('MV'+valDis).value;
		var j=0;
		for(var i=0;i<count;i++){
			if(document.getElementById('C'+valDis+i).checked){
				j++
				//break;//Commented for IN020774
			}
		}
		//if(j==0) Commented for IN020774
		if(j!=count)//Added for IN020774
			document.getElementById('M'+valDis).checked=false;
	}else{
		//adding start for IN020774
		var count = document.getElementById('MV'+valDis).value;
		var j=0;
		for(var i=0;i<count;i++){
			if(document.getElementById('C'+valDis+i).checked){
				j++
			}
		}
		if(j==count){//Adding end for IN020774
		  document.getElementById('M'+valDis).checked=true;  //IN072777
		}
		obj.value="Y";
	}
	selectDiscreatList();	//IN072777
	parent.VitalSignDetals.location.href = "../../eCA/jsp/VitalSignApplicableChartDetails.jsp?selectedDiscret="+parent.VitalSignDetals.document.getElementById('selectedDiscret').value;	//IN072777
}

function ackResult(){
	//Adding start for IN017999
	var confirmFlag =true;
	var totalDiscrIds = (parent.VitalSignFrame.document.VitalSignResultForm.totalDiscrIds.value).split(',');//Adding start for IN20763
	var j=0;
	var isVitalSearchByBedNo =parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.isVitalSearchByBedNo.value;
	var bed_no               ="";
	var patient_id           =parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.patient_id.value;
	var enc_id =              parent.parent.TaskListRightFilterFrame.document.getElementById("en_id").value

	 for(var i=0;i<totalDiscrIds.length;i++){
		var count = parent.VitalSignFrame.document.getElementById('MV'+totalDiscrIds[i]).value;
		for(var k=0;k<count;k++){
		if(parent.VitalSignFrame.document.getElementById('C'+totalDiscrIds[i]+k).checked){
			if(j==0){
				j++;
			}
		}
	  }
	}//Adding end for IN20763
	// IN072777 Start.
	var totalChartCount = parent.VitalSignDetals.document.VitalSignResultFormDetals.totalCharts.value;
	var selectedChartDetails ="";
	for(var i=0;i<totalChartCount;i++){
		if(parent.VitalSignDetals.document.getElementById('ChartID'+i).checked){
			if(""==selectedChartDetails)
				selectedChartDetails = parent.VitalSignDetals.document.getElementById('ChartID'+i).value;
			else
				selectedChartDetails=selectedChartDetails+","+parent.VitalSignDetals.document.getElementById('ChartID'+i).value;
		}
	}
	if(selectedChartDetails !=""){
		if(j>0){//Added if condition for IN20763
		if(parent.parent.TaskListRightFilterFrame != undefined){
		
		 if(isVitalSearchByBedNo!='false'){
			if(parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.bed_no!= undefined)
				bed_no           = parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.bed_no.value;
			if(bed_no != ""){
			  var msg        = "Bed. No related interfaced vital sign observations shall be moved to respective patient ID: $ and Encounter ID: # Do you want to proceed";
			  msg = msg.replace('$', patient_id);
			  msg = msg.replace('#', enc_id);
			  confirmFlag = confirm(msg);
		  }else{
			  var msg   = "Interfaced vital sign observations shall be moved to respective patient ID: $ and Encounter ID: # Do you want to proceed";
			  msg = msg.replace('$', patient_id);
			  msg = msg.replace('#', enc_id);
			  confirmFlag = confirm(msg);
		  }
		 }
		}

		if(confirmFlag){//Adding end for IN017999
		parent.VitalSignFrame.document.VitalSignResultForm.selectedChartDetails.value=selectedChartDetails;
		if(isVitalSearchByBedNo!='false')
			parent.VitalSignFrame.document.VitalSignResultForm.encounter_id.value =enc_id;//Added for IN020914
		// IN072777 End.
			var Record =document.getElementById("Record").value;
			parent.VitalSignFrame.document.VitalSignResultForm.action='../../servlet/eCA.CAVitalSignServlet?Record='+Record;
			parent.VitalSignFrame.document.VitalSignResultForm.target='messageFrame';
			parent.VitalSignFrame.document.VitalSignResultForm.method='post';
			parent.VitalSignFrame.document.VitalSignResultForm.submit();
		}else{
			 return false;
		}
	  }else{//Added for IN20763
			alert("Atleast Select Anyone Record To Proceed");
	  }
	// IN072777 Start.
   }else{
		alert("Atleast one chart ID to be selected.");
	}
	// IN072777 End.
	
}

function update(){
	
	var Record =document.getElementById("Delete").value;
	
	parent.VitalSignFrame.document.VitalSignResultForm.action='../../servlet/eCA.CAVitalSignServlet?Record='+Record;
	parent.VitalSignFrame.document.VitalSignResultForm.target='messageFrame';
	parent.VitalSignFrame.document.VitalSignResultForm.method='post';
	parent.VitalSignFrame.document.VitalSignResultForm.submit();
}
//AAKH-CRF-0097.1
function critical(){
	
	var Record =document.getElementById("Critical").value;
	
	parent.VitalSignFrame.document.VitalSignResultForm.action='../../servlet/eCA.CAVitalSignServlet?Record='+Record;
	parent.VitalSignFrame.document.VitalSignResultForm.target='messageFrame';
	parent.VitalSignFrame.document.VitalSignResultForm.method='post';
	parent.VitalSignFrame.document.VitalSignResultForm.submit();
}

function ackResultGraph(){
	//Adding start for IN017999
		var confirmFlag =true;
		var totalDiscrIds = (parent.VitalSignDetals.document.VitalSignResultFormDetals.totalDiscrIds.value).split(',');//Adding start for IN20763
	    var j=0;
		var isVitalSearchByBedNo =parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.isVitalSearchByBedNo.value;
		var bed_no               ="";
		var patient_id           =parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.patient_id.value;
		var enc_id =              parent.parent.TaskListRightFilterFrame.document.getElementById("en_id").value

		for(var i=0;i<totalDiscrIds.length;i++){
		    var count = parent.VitalSignDetals.document.getElementById('MV'+totalDiscrIds[i]).value;
		   for(var k=0;k<count;k++){
		      if(parent.VitalSignDetals.document.getElementById('C'+totalDiscrIds[i]+k).checked){
			     if(j==0){
				j++;
			     }
		      }
	       }
	   }//Adding end for IN20763
		// IN072777 Start.
		var totalChartCount = parent.VitalSignDetals.document.VitalSignResultFormDetals.totalCharts.value;
		var selectedChartDetails ="";
		for(var i=0;i<totalChartCount;i++){
			if(parent.VitalSignDetals.document.getElementById('ChartID'+i).checked){
				if(""==selectedChartDetails)
					selectedChartDetails = parent.VitalSignDetals.document.getElementById('ChartID'+i).value;
				else
					selectedChartDetails=selectedChartDetails+","+parent.VitalSignDetals.document.getElementById('ChartID'+i).value;
			}
		}	
		parent.VitalSignDetals.document.VitalSignResultFormDetals.selectedChartDetails.value=selectedChartDetails;
	if(selectedChartDetails !=""){
		// IN072777 End.
		  if(j>0){//Added if condition for IN20763
		   if(parent.parent.TaskListRightFilterFrame != undefined){
			
			 if(isVitalSearchByBedNo!='false'){
				if(parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.bed_no!= undefined)
					bed_no           = parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.bed_no.value;
			  if(bed_no != ""){
				  var msg        = "Bed. No related interfaced vital sign observations shall be moved to respective patient ID: $ and Encounter ID: # Do you want to proceed";
				  msg = msg.replace('$', patient_id);
				  msg = msg.replace('#', enc_id);
				  confirmFlag = confirm(msg);
			  }else{
				  var msg   = "Interfaced vital sign observations shall be moved to respective patient ID: $ and Encounter ID: # Do you want to proceed";
				  msg = msg.replace('$', patient_id);
				  msg = msg.replace('#', enc_id);
				  confirmFlag = confirm(msg);
			  }
			 }
			}
		   if(confirmFlag){//Adding end for IN017999
		   if(isVitalSearchByBedNo!='false')//Added for IN020914
		      parent.VitalSignDetals.document.VitalSignResultFormDetals.encounter_id.value =enc_id;//Added for IN020914
			var Record =document.getElementById("Record").value;
			parent.VitalSignDetals.document.VitalSignResultFormDetals.action='../../servlet/eCA.CAVitalSignServlet?Record='+Record;
			parent.VitalSignDetals.document.VitalSignResultFormDetals.target='messageFrame';
			parent.VitalSignDetals.document.VitalSignResultFormDetals.method='post';
			parent.VitalSignDetals.document.VitalSignResultFormDetals.submit();
		   }else//Added for IN017999
		     return false;
	   }else{//Added for IN20763
	  	alert("Atleast Select Anyone Record To Proceed");
	   }
		// IN072777 Start.
   	}else{
			alert("Atleast one chart ID to be selected.");
		}
		// IN072777 End.
	
	}

	function updateGraph(){
		
		var Record =document.getElementById("Delete").value;
		
		parent.VitalSignDetals.document.VitalSignResultFormDetals.action='../../servlet/eCA.CAVitalSignServlet?Record='+Record;
		parent.VitalSignDetals.document.VitalSignResultFormDetals.target='messageFrame';
		parent.VitalSignDetals.document.VitalSignResultFormDetals.method='post';
		parent.VitalSignDetals.document.VitalSignResultFormDetals.submit();
	}
	function criticalGraph(){
		
		var Record =document.getElementById("Critical").value;
		
		parent.VitalSignDetals.document.VitalSignResultFormDetals.action='../../servlet/eCA.CAVitalSignServlet?Record='+Record;
		parent.VitalSignDetals.document.VitalSignResultFormDetals.target='messageFrame';
		parent.VitalSignDetals.document.VitalSignResultFormDetals.method='post';
		parent.VitalSignDetals.document.VitalSignResultFormDetals.submit();
	}

//AAKH-CRF-0097.1
function detailsExpended(disMsrId){
	var totalRec = document.getElementById(disMsrId+"Total").value;
	for(var i=0;i<totalRec;i++){
		document.getElementById(disMsrId+"_"+i).style.display="";
	}
	document.getElementById(disMsrId).innerHTML="<img  src=\"..\\..\\eCA\\images\\tri_down.gif\" onClick=\"detailsColapsed('"+disMsrId+"')\"/>";
	
}
function detailsColapsed(disMsrId){
	var totalRec = document.getElementById(disMsrId+"Total").value;
	for(var i=0;i<totalRec;i++){
		document.getElementById(disMsrId+"_"+i).style.display="none";
	}
	document.getElementById(disMsrId).innerHTML="<img  src=\"..\\..\\eCommon\\images\\tri.gif\" onClick=\"detailsExpended('"+disMsrId+"')\"/>";
}
function selectAll(disMsrId)
{
		var selectValues="";
		var totalRec = document.getElementById(disMsrId+"Total").value;
		for(var i=0;i<totalRec;i++){
			document.getElementById("C"+disMsrId+i).disabled=false;
			document.getElementById("C"+disMsrId+i).checked=true;
			document.getElementById('C'+disMsrId+i).value="Y";			
			if(selectValues!=="")
				selectValues = selectValues+","+(document.getElementById('CR'+disMsrId+"_"+i).value)+"~"+(document.getElementById('CV'+disMsrId+"_"+i).value);
			else {
				selectValues = (document.getElementById('CR'+disMsrId+"_"+i).value)+"~"+(document.getElementById('CV'+disMsrId+"_"+i).value);
				
			}
		}
		var patientId=document.getElementById( "patient_id").value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;	
		xmlStr += "selectedValues=\""+ selectValues + "\" " ;	
		xmlStr += "functionId=\"SELECTALL\" " ;
		xmlStr += "patientId=\""+ patientId+ "\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open( "POST", "InterfacedVitalSignIntermediate.jsp", false ) ;
		xmlHttp.send(xmlDoc ) ;
		responseText=xmlHttp.responseText;
		unCheckPreDisMsr(disMsrId);	
		parent.VitalSignGraphDetals.location.href = "../../eCA/jsp/InterfacedVitalSignGraphDetals.jsp?patient_id="+patientId+"&disMsrId="+disMsrId; 
}
//IN072777 Start.
function getChartDetails(disMsrId){

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;		
	xmlStr += "functionId=\"APPLCHARTS\" " ;
	xmlStr += "disMsrId=\""+ disMsrId+ "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/InterfacedVitalSignIntermediate.jsp", false);//IN071596
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	document.getElementById("applCharts").innerHTML=responseText;
	document.VitalSignResultFormDetals.totalCharts.value=document.VitalSignResultFormDetals.totChartCount.value;
	//IN072777 End.
}
function unCheckPreDisMsr(disMsrId)
{
	var preDisMsrCount;
	var predDisMsrId = document.getElementById("preDisMsrId").value;
	if((predDisMsrId!=="") && (predDisMsrId!==disMsrId)){
		preDisMsrCount = document.getElementById(predDisMsrId+"Total").value;
		for(var i=0;i<preDisMsrCount;i++){
			document.getElementById("C"+predDisMsrId+i).checked=false;
			document.getElementById('C'+predDisMsrId+i).value="N";
			document.getElementById("C"+predDisMsrId+i).disabled=true;
		}
		document.getElementById("M"+predDisMsrId).checked=false;
		detailsColapsed(predDisMsrId);
	}
	document.getElementById("preDisMsrId").value = disMsrId;
	
	
}
function countCheck(obj,disMsrId,selRecord){
	var patientId=document.getElementById( "patient_id").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var selectValues =(document.getElementById('CR'+selRecord).value)+"~"+(document.getElementById('CV'+selRecord).value);
	xmlStr ="<root><SEARCH " ;	
	xmlStr += "selectedValues=\""+ selectValues + "\" " ;
	if(!obj.checked){		
		document.getElementById(disMsrId).checked= false;
		obj.value="N";					
		xmlStr += "functionId=\"DELETEMAP\" " ;		
	}else{
		obj.value="Y";
		xmlStr += "functionId=\"ADDMAP\" " ;
	}
	xmlStr += "patientId=\""+ patientId+ "\" " ;
		xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open( "POST", "InterfacedVitalSignIntermediate.jsp", false ) ;
	xmlHttp.send(xmlDoc ) ;
	responseText=(xmlHttp.responseText).replace(/^\s+|\s+$/gm,'');
	if(responseText==0){
		var predDisMsrId = document.getElementById("preDisMsrId").value;
		if(predDisMsrId!==""){
			preDisMsrCount = document.getElementById(predDisMsrId+"Total").value;
			for(var i=0;i<preDisMsrCount;i++){
				document.getElementById("C"+predDisMsrId+i).checked=false;
				document.getElementById('C'+predDisMsrId+i).value="N";
				document.getElementById("C"+predDisMsrId+i).disabled=true;
			}
			document.getElementById("M"+predDisMsrId).checked=false;
			detailsColapsed(predDisMsrId);
		}
		document.getElementById("preDisMsrId").value = "";	
		parent.VitalSignGraphDetals.location.href = "../../eCA/jsp/blank.jsp"; 
		getChartDetails(''); //IN073549
	}else
		parent.VitalSignGraphDetals.location.href = "../../eCA/jsp/InterfacedVitalSignGraphDetals.jsp?patient_id="+patientId+"&disMsrId="+disMsrId; 
}
//IN072777 Start.
function selectDiscreatList(){
	var totalDiscrIds = (document.forms[0].totalDiscrIds.value).split(',');
	var j=0;
	var selectDiscreat = "";
	for(var i=0;i<totalDiscrIds.length;i++){
		if(document.getElementById('M'+totalDiscrIds[i]).checked){
			if(j==0){
				j++;
				selectDiscreat=totalDiscrIds[i];
			}else{
				selectDiscreat=selectDiscreat+","+totalDiscrIds[i];
			}
		}
		
	}
	parent.VitalSignDetals.document.getElementById('selectedDiscret').value=selectDiscreat;
}
function selectAllChart(obj){
	var totalChartCount = document.forms[0].totalCharts.value;
	if(obj.checked){
		for(var i=0;i<totalChartCount;i++){
			document.getElementById('ChartID'+i).checked = true;
		}
	}else{
		for(var i=0;i<totalChartCount;i++){
			document.getElementById('ChartID'+i).checked = false;
		}
	}
}
//IN072777 End.
function ackResultDT(){
	var confirmFlag =true;
	var totalDiscrIds = (parent.VitalSignFrame.document.VitalSignResultForm.totalDiscrIds.value).split(',');
	//alert("totalDiscrIds::"+totalDiscrIds)
	var j=0;
	var isVitalSearchByBedNo =parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.isVitalSearchByBedNo.value;
	var bed_no               ="";
	var patient_id           =parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.patient_id.value;
	var enc_id =              parent.parent.TaskListRightFilterFrame.document.getElementById("en_id").value
	 //for(var i=0;i<totalDiscrIds.length;i++){
		var count = parent.VitalSignFrame.document.VitalSignResultForm.totDiscCount.value;
		for(var k=0;k<count;k++){ 
			//alert('C'+totalDiscrIds[k]+"::"+parent.VitalSignFrame.document.getElementById('C'+totalDiscrIds[k]).checked)
		 if(parent.VitalSignFrame.document.getElementById('C'+totalDiscrIds[k]).checked){ //alert("J::"+j)
			if(j==0){
				j++;
			}
		}
	  //}
	}
	var totalChartCount = parent.VitalSignDetals.document.VitalSignResultFormDetals.totalCharts.value; //alert("totalChartCount::"+totalChartCount)
	var selectedChartDetails ="";
	for(var i=0;i<totalChartCount;i++){
		if(parent.VitalSignDetals.document.getElementById('ChartID'+i).checked){
			if(""==selectedChartDetails)
				selectedChartDetails = parent.VitalSignDetals.document.getElementById('ChartID'+i).value;
			else
				selectedChartDetails=selectedChartDetails+","+parent.VitalSignDetals.document.getElementById('ChartID'+i).value;
		}
	}//alert("selectedChartDetails::"+selectedChartDetails);
	if(selectedChartDetails !=""){
		if(j>0){
		if(parent.parent.TaskListRightFilterFrame != undefined){
		 if(isVitalSearchByBedNo!='false'){
			if(parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.bed_no!= undefined)
				bed_no           = parent.parent.TaskListRightFilterFrame.document.TaskListFilterForm.bed_no.value;
			if(bed_no != ""){
			  var msg        = "Bed. No related interfaced vital sign observations shall be moved to respective patient ID: $ and Encounter ID: # Do you want to proceed";
			  msg = msg.replace('$', patient_id);
			  msg = msg.replace('#', enc_id);
			  confirmFlag = confirm(msg);
		  }else{
			  var msg   = "Interfaced vital sign observations shall be moved to respective patient ID: $ and Encounter ID: # Do you want to proceed";
			  msg = msg.replace('$', patient_id);
			  msg = msg.replace('#', enc_id);
			  confirmFlag = confirm(msg);
		  }
		 }
		}
		if(confirmFlag){
		parent.VitalSignFrame.document.VitalSignResultForm.selectedChartDetails.value=selectedChartDetails;
		if(isVitalSearchByBedNo!='false')
			parent.VitalSignFrame.document.VitalSignResultForm.encounter_id.value =enc_id;//Added for IN020914
			var Record =document.getElementById("Record").value;
			parent.VitalSignFrame.document.VitalSignResultForm.action='../../servlet/eCA.CAVitalSignServlet?Record='+Record;
			parent.VitalSignFrame.document.VitalSignResultForm.target='messageFrame';
			parent.VitalSignFrame.document.VitalSignResultForm.method='post';
			parent.VitalSignFrame.document.VitalSignResultForm.submit();
		}else{
			 return false;
		}
	  }else{
			alert("Atleast Select Anyone Record To Proceed");
	  }
   }else{
		alert("Atleast one chart ID to be selected.");
	}
}
function updateDT(){
	var Record =document.getElementById("Delete").value;
	parent.VitalSignFrame.document.VitalSignResultForm.action='../../servlet/eCA.CAVitalSignServlet?Record='+Record;
	parent.VitalSignFrame.document.VitalSignResultForm.target='messageFrame';
	parent.VitalSignFrame.document.VitalSignResultForm.method='post';
	parent.VitalSignFrame.document.VitalSignResultForm.submit();
}
function criticalDT(){
	var Record =document.getElementById("Critical").value;
	parent.VitalSignFrame.document.VitalSignResultForm.action='../../servlet/eCA.CAVitalSignServlet?Record='+Record;
	parent.VitalSignFrame.document.VitalSignResultForm.target='messageFrame';
	parent.VitalSignFrame.document.VitalSignResultForm.method='post';
	parent.VitalSignFrame.document.VitalSignResultForm.submit();
}
function selectEventDT(obj,valDis){
	if(!obj.checked){ 
		//alert(document.getElementById('C'+valDis).checked)
		document.getElementById('select_all').checked= false;
		obj.value="N";
	}else{
		obj.value="Y";
	}
	selectDiscreatListDT();	
	parent.VitalSignDetals.location.href = "../../eCA/jsp/VitalSignApplicableChartDetails.jsp?selectedDiscret="+parent.VitalSignDetals.document.getElementById('selectedDiscret').value;
}
function selectDiscreatListDT(){
	var totalDiscrIds = (parent.VitalSignFrame.document.VitalSignResultForm.totalDiscrIds.value).split(',');
	var j=0;
	var selectDiscreat = "";
	for(var i=0;i<totalDiscrIds.length;i++){
		if(parent.VitalSignFrame.document.getElementById('C'+totalDiscrIds[i]).checked){
			if(j==0){
				j++;
				selectDiscreat=parent.VitalSignFrame.document.getElementById('MV'+totalDiscrIds[i]).value;
			}else{
				selectDiscreat=selectDiscreat+","+parent.VitalSignFrame.document.getElementById('MV'+totalDiscrIds[i]).value;
			}
		}
	}
	parent.VitalSignDetals.document.getElementById('selectedDiscret').value=selectDiscreat; 
}
