/* 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
19/09/2013	IN043490		Ramesh G		When the Relationship is updated for a patient the genogram is not displayed correctly. 
19/09/2013	IN043568		Ramesh G		Add Social/Emotional/Interpersonal Relationships and Add Medical History In Remarks there is no wrapping of text entered
23/09/2013	IN043647		Ramesh G		After a Transaction is done the page needs to be refreshed to view the genogram
5/11/2013	IN000000		Chowminya G		Wrong alert message in Medical History screen
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
var WSHShell=new ActiveXObject("WScript.Shell"); 
//Add Famil Membur 

function addFamilyMember(){
	var dialogHeight ='42' ;
	var dialogWidth = '65' ;
	var dialogTop	= '70';
	var dialogLeft = '130' ;
	var screen_width=screen.width;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments	= "";
	var patient_id	= document.genogramTranbtnFrm.patient_id.value;
	
	//window.open("../../eCA/jsp/CAGenogramAddFamilMumberFrameSet.jsp?patient_id="+patient_id,"",arguments,features);
	window.showModalDialog("../../eCA/jsp/CAGenogramAddFamilMumberFrameSet.jsp?patient_id="+patient_id+"&mode=INSERT",arguments,features);
	parent.framePrint.location.href = "../../eCA/jsp/CAPatientGenogram.jsp?patient_id="+patient_id+"&mode=INSERT";  //IN043647
}
function onSuccess()
{
	var patient_id	= parent.genogramAddFamilyMemberBtn.document.forms[0].patient_id.value;		
	parent.genogramAddFamilyMemberDtls.location.href='../../eCA/jsp/CAGenogramAddFamilyDtls.jsp?patient_id='+patient_id+"&mode=INSERT" ;	
}

function changeFMExist(str){
	var fmExistMember = document.getElementById("fmExists");
	for(var i=0;i<fmExistMember.length;i++){
		
		if(fmExistMember[i].checked){
			if((fmExistMember[i].value)=="Y"){
				document.getElementById("patId").disabled = false;
				document.getElementById("patId_").disabled = false;
			}else if((fmExistMember[i].value)=="N"){
				document.getElementById("patId").disabled = true;
				document.getElementById("patId").value = "";
				document.getElementById("patId_").disabled = true;
				getOldGenogramDetails("");
				parent.genogramAddFamilyMemberFram.document.getElementById("relationShipTypeValue").value="";
				getRelationComboValuesTemp();
				parent.genogramAddFamilyMemberFram.document.getElementById("relationWith").innerHTML ="&nbsp";
				parent.genogramAddFamilyMemberFram.document.getElementById('relationShipTypeValue').disabled = true;
				parent.genogramAddFamilyMemberFram.document.getElementById('relst').style.display='none';
				parent.genogramAddFamilyMemberFram.document.getElementById('relationValue').disabled = true;
				parent.genogramAddFamilyMemberFram.document.getElementById('rel').style.display='none';
				document.getElementById("selectNonPatID").value	= "";
				document.getElementById("genoId").value			= "";
				document.getElementById("selectNonPatSex").value 	= "";
				document.getElementById("selectNonPatName").value = "";
			}
		}
	}
}
function selectRow( idVal){	
	var totalRows = document.getElementById("displayTable").getElementsByTagName('tr');
	var gridSrlNo= document.getElementById("gridSrlNo"+idVal).value;
	var formSrlNo= document.genogramAddFamilyDtlsFrm.selectSrlNo.value;	
	if(gridSrlNo!=formSrlNo){
		for(var i=1;i<totalRows.length;i++){
			if(idVal==i){
				var totalCells=totalRows[i].cells;
				for(var j=0;j<totalCells.length;j++){
					totalCells[j].className="gridDataSelect";
				}
			}else{
				var totalCells=totalRows[i].cells;
				for(var j=0;j<totalCells.length;j++){
					totalCells[j].className="gridData";
				}
			}
		}
		document.getElementById("selectNonPatID").value	= document.getElementById("gridNonPatId"+idVal).value;
		document.getElementById("genoId").value			= document.getElementById("gridGenoId"+idVal).value;
		document.getElementById("selectNonPatSex").value 	= document.getElementById("gridNonPatSex"+idVal).value;
		document.getElementById("selectNonPatName").value = document.getElementById("gridNonPatName"+idVal).value;
		document.genogramAddFamilyDtlsFrm.selectSrlNo.value 		= document.getElementById("gridSrlNo"+idVal).value;  //IN043490
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		parent.genogramAddFamilyMemberBtn.document.getElementById("addMember").value = "Add Member";
		parent.genogramAddFamilyMemberFram.document.getElementById('modifiedDetails').style.display='none';
		parent.genogramAddFamilyMemberFram.document.getElementById('familyRelation').style.display='inline';
		parent.genogramAddFamilyMemberFram.document.getElementById('coupleDetails').style.display='inline';
		parent.genogramAddFamilyMemberFram.document.getElementById('parentDetails').style.display='none';
		parent.genogramAddFamilyMemberFram.document.getElementById('childDetails').style.display='none';
		parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.mode.value="INSERT";
		parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.relationShipTypeValue.value="";
		getRelationComboValuesTemp();
	
		if((parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.relationShipTypeValue.value)=="CHILD"){
			if(document.getElementById("selectNonPatName").value!=""){
				parent.genogramAddFamilyMemberFram.document.getElementById("relationWith").innerHTML ="Of "+ document.getElementById("selectNonPatName").value+" and";
			}else{
				parent.genogramAddFamilyMemberFram.document.getElementById("relationWith").innerHTML ="";
			}
			parent.genogramAddFamilyMemberFram.document.getElementById('selectNonPatID1').style.display='inline';
			parent.genogramAddFamilyMemberFram.document.getElementById('selectNonPatID1_').style.display='inline';
		
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root><SEARCH ";
			xmlStr+=" condition=\"NONPATIENTCOUPLEDTLS\" ";
			xmlStr+=" non_patient_id=\""+document.getElementById("selectNonPatID").value+"\"";
			xmlStr+=" geno_id=\""+document.getElementById("genoId").value+"\"";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
			xmlHttp.open("POST", url, false);
			xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
			xmlHttp.send(xmlDoc);	
			var nonPatCoupDtls = trim(xmlHttp.responseText);
			var nonPatCoupLen = eval("parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.selectNonPatID1.length") ;
			for(var i=0;i<nonPatCoupLen;i++)
			{
				eval("parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.selectNonPatID1.remove(\"selectNonPatID1\")") ;
			}
			var tp = "-------------- "+getLabel("Common.defaultSelect.label","Common")+" --------------" ;
			var nonPatCoupopt = eval("document.createElement(\"OPTION\")") ;
			nonPatCoupopt.text = tp ;
			nonPatCoupopt.value = "" ;
			eval("parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.selectNonPatID1.add(nonPatCoupopt)") ;
			if(nonPatCoupDtls!=""){
				var nonPatCoup = nonPatCoupDtls.split("|");
				for(var k=0;k<nonPatCoup.length;k++){
					var nonPatCoup_ = (nonPatCoup[k]).split("~");
					var nonPatCoupopt1 = eval("document.createElement(\"OPTION\")") ;
					nonPatCoupopt1.text = nonPatCoup_[2]+" - "+nonPatCoup_[3] ;
					nonPatCoupopt1.value = nonPatCoup_[0]+"|"+nonPatCoup_[1]+"|"+nonPatCoup_[4] ;
						eval("parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.selectNonPatID1.add(nonPatCoupopt1)") ;
				}
			}
		}else{
			if(document.getElementById("selectNonPatName").value!=""){
				parent.genogramAddFamilyMemberFram.document.getElementById("relationWith").innerHTML ="Of "+ document.getElementById("selectNonPatName").value;
			}else{
				parent.genogramAddFamilyMemberFram.document.getElementById("relationWith").innerHTML ="";
			}
		}
	}
}
function getRelationComboValuesTemp(){
	var len =  eval("parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.relationValue.length") ;
		for(var i=0;i<len;i++)
		{
			eval("parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.relationValue.remove(\"relationValue\")") ;
		}
		var tp = "-------------- "+getLabel("Common.defaultSelect.label","Common")+" --------------" ;
		var opt = eval("document.createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval("parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.relationValue.add(opt)") ;
		
		parent.genogramAddFamilyMemberFram.document.getElementById('noOfChildsId').style.display='none';
		parent.genogramAddFamilyMemberFram.document.getElementById('childDetails').style.display='none';
		parent.genogramAddFamilyMemberFram.document.getElementById('coupleDetails').style.display='inline';
		parent.genogramAddFamilyMemberFram.document.getElementById('parentDetails').style.display='none';
		if((parent.genogramAddFamilyMemberFram.parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value)!=""){
			parent.genogramAddFamilyMemberFram.document.getElementById('relationWith').innerHTML = "Of  "+parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value;
		}
		parent.genogramAddFamilyMemberFram.document.getElementById('selectNonPatID1').style.display='none';
		parent.genogramAddFamilyMemberFram.document.getElementById('selectNonPatID1_').style.display='none';
}
function selectRowValues(idVal){	
	var totalRows = document.getElementById("displayTable").getElementsByTagName('tr');	
	for(var i=1;i<totalRows.length;i++){
		if(idVal==i){
			var totalCells=totalRows[i].cells;
			for(var j=0;j<totalCells.length;j++){
				totalCells[j].className="gridDataUpdate";
			}
		}else{
			var totalCells=totalRows[i].cells;
			for(var j=0;j<totalCells.length;j++){
				totalCells[j].className="gridData";
			}
		}
	}
	document.getElementById("selectNonPatID").value=document.getElementById("gridNonPatId"+idVal).value;
	document.getElementById("genoId").value=document.getElementById("gridGenoId"+idVal).value;
	document.getElementById("selectSrlNo").value=document.getElementById("gridSrlNo"+idVal).value;
	document.getElementById("selectNonPatSex").value = document.getElementById("gridNonPatSex"+idVal).value;
	
	parent.genogramAddFamilyMemberBtn.document.getElementById("addMember").value = "Modify Member";
	var patient_id	= parent.genogramAddFamilyMemberBtn.document.forms[0].patient_id.value;
	parent.genogramAddFamilyMemberFram.document.getElementById('modifiedDetails').style.display='inline';
	parent.genogramAddFamilyMemberFram.document.getElementById('familyRelation').style.display='none';
	parent.genogramAddFamilyMemberFram.document.getElementById('coupleDetails').style.display='none';
	parent.genogramAddFamilyMemberFram.document.getElementById('parentDetails').style.display='none';
	parent.genogramAddFamilyMemberFram.document.getElementById('childDetails').style.display='none';
		
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" condition=\"GETNONPATIENTDTLS\" ";
	xmlStr+=" non_patient_id=\""+document.getElementById("selectNonPatID").value+"\"";
	xmlStr+=" srlNo=\""+document.getElementById("selectSrlNo").value+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);	
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	
}
function assignRelationValueModify(relValueModify){
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" condition=\"GETRELATIONCOMBOVALUES\" ";
	xmlStr+=" relTypeId=\"COUPLE\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc); 
	var resultVal = trim(xmlHttp.responseText);
	parent.genogramAddFamilyMemberFram.document.getElementById('modifyRelationFieldSet').style.display='inline';
	var resVal = relValueModify.split('|');
	var table = parent.genogramAddFamilyMemberFram.document.getElementById("modifyRelationTable");
	var tableRows = table.getElementsByTagName('tr');
	var rowCount = tableRows.length;
	for (var x=rowCount-1; x>0; x--) {
	   table.deleteRow(x);
	}	
	for(var i=0;i<resVal.length;i++){
		addModifyRelationRow(resultVal,resVal[i]);
	}
}
function addModifyRelationRow(resultVal,resVal){
	var table = parent.genogramAddFamilyMemberFram.document.getElementById("modifyRelationTable");
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
		var resVal_ = resVal.split("~");
		
		var element1 = document.createElement("select");
			element1.id="relationValueModify"+(rowCount);
			element1.name="relationValueModify"+rowCount;
			element1.style.width="200px";
			
				var valArr = resultVal.split("|");
				for(var j=0;j<valArr.length;j++){
					var valArr_ = (valArr[j]).split("~");							
					var genderoption1 = document.createElement("option");
						genderoption1.value	= valArr_[0] ;
						genderoption1.text 	= valArr_[1] ;
						element1.add(genderoption1);
				}
				
			element1.value = resVal_[0];
		var element2 = document.createElement("input");
				element2.type = "hidden";
				element2.id="rel_toGenoIdModify"+rowCount;
				element2.name="rel_toGenoIdModify"+rowCount;
				element2.value=resVal_[1];
		var element3 = document.createElement("input");
				element3.type = "hidden";
				element3.id="rel_srlNoModify"+rowCount;
				element3.name="rel_srlNoModify"+rowCount;
				element3.value=resVal_[2];
		var element4 = document.createElement("input");
				element4.type = "hidden";
				element4.id="rel_personModify"+rowCount;
				element4.name="rel_personModify"+rowCount;
				element4.value=resVal_[4];;
				
		var newCell1 = row.insertCell(0);
			newCell1.className = 'gridData';
			newCell1.appendChild(element1);
			newCell1.appendChild(element2);
			newCell1.appendChild(element3);
			newCell1.appendChild(element4);
			
		var element4 = document.createElement("input");
			element4.id="rel_dateModify"+rowCount;
			element4.name="rel_dateModify"+rowCount;
			element4.type = "text";
			element4.size="14";
			element4.maxlength="16";
			element4.value = resVal_[3];
		
		
		var img1 = document.createElement('img');
			img1.src = "../../eCommon/images/CommonCalendar.gif";
			img1.id = "dofimgCh"+rowCount;
			img1.onclick = function(){ eval("parent.genogramAddFamilyMemberFram.document.getElementById('rel_dateModify"+rowCount+"').select()");return showCalendar_geno('rel_dateModify'+rowCount,'','','');};
		var img2 = document.createElement('img');					
		img2.src = "../../eCommon/images/mandatory.gif";
		
		
			
		var newCell2 = row.insertCell(1);
			newCell2.className = 'gridData';
			newCell2.appendChild(element4);
			newCell2.appendChild(img1);
			newCell2.appendChild(img2);
			
		var newCell3 = row.insertCell(2);
			newCell3.className = 'gridData';
			newCell3.innerHTML=resVal_[4];			
	parent.genogramAddFamilyMemberFram.document.getElementById("relModifyCount").value=rowCount;
}
function genoPatientDetails(){
	var target	= document.forms[0].geno_person_desc.value;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var tit=getLabel("Common.ChiefComplaint.label","ca_labels");
	var tit="Existing Family Members";
	var retVal				=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	sql = "SELECT NON_PATIENT_ID CODE,NAME description FROM CA_GENOGRAM_ATTRIBUTE where  ";

	sql=sql+" upper(NON_PATIENT_ID) like upper(?) and upper(NAME) like upper(?) ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );

	var arr=new Array();

	if(retVal != null && retVal != "" ){
		var retVal=unescape(retVal);
		arr=retVal.split(",");
		document.forms[0].geno_person_id.value=arr[0];
		document.forms[0].geno_person_desc.value=arr[1];
		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr+=" condition=\"GENONONPATIENTFAMILYDTLS\" ";
		xmlStr+=" non_patient_id=\""+arr[0]+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
		xmlHttp.open("POST", url, false);
		xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
		xmlHttp.send(xmlDoc);	
		eval(xmlHttp.responseText);
	
		//getOldGenogramDetails(arr[0]);
	}else{
		document.forms[0].geno_person_id.value="";
		document.forms[0].geno_person_desc.value="";

	}
}
function getOldGenogramDetails(familyDetails){	
	
	var table = document.getElementById("displayTable");
	var tableRows = table.getElementsByTagName('tr');
	var rowCount = tableRows.length;
	for (var x=rowCount-1; x>0; x--) {
	   table.deleteRow(x);
	}
	if(familyDetails!=""){
		var rowData = familyDetails.split("|");
		var rowDataCount = rowData.length;	
		for(var i=0;i<rowDataCount;i++){		
				addRow(rowData[i]);
		}
		var table1 = document.getElementById("displayTable");
		var rowCount1 = table1.rows.length;
		if(rowCount1>1){
			parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.relationShipTypeValue.disabled = false;
			parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.relationValue.disabled = false;
			parent.genogramAddFamilyMemberFram.document.getElementById('relst').style.display='inline';
			parent.genogramAddFamilyMemberFram.document.getElementById('rel').style.display='inline';
			parent.genogramAddFamilyMemberFram.document.getElementById('relationSD').style.display='inline';
		}
		document.getElementById("totalRecords").value = rowCount1;
	}
	
}
function addRow(dataobj){
	var table = document.getElementById("displayTable");
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);		
	var cellData = dataobj.split("~");
	var cell1 = row.insertCell(0);
		cell1.className = 'gridData';
		cell1.innerHTML ='&nbsp;';
		
	var cell2 = row.insertCell(1);
		cell2.className = 'gridData';
		cell2.innerHTML = cellData[1];
		
	var cell3 = row.insertCell(2);
		cell3.className = 'gridData';
		cell3.innerHTML = cellData[3];
		
	var cell4 = row.insertCell(3);
		cell4.className = 'gridData';
		cell4.innerHTML = cellData[5];
		
	var cell5 = row.insertCell(4);
		cell5.className = 'gridData';
		cell5.innerHTML =cellData[4];
		
	var cell6 = row.insertCell(5);
		cell6.className = 'gridData';
		cell6.innerHTML = cellData[6];
		
	var cell7 = row.insertCell(6);
		cell7.className = 'gridData';
		cell7.innerHTML = cellData[7];
		
	var cell8 = row.insertCell(7);
		cell8.className = 'gridData';
		cell8.innerHTML = cellData[8];
		
	var element1 = document.createElement("input");
		element1.type = "hidden";
		element1.id="gridNonPatId"+rowCount;
		element1.name="gridNonPatId"+rowCount;
		element1.value= cellData[2];
		
	var element2 = document.createElement("input");
		element2.type = "hidden";
		element2.id="gridGenoId"+rowCount;
		element2.name="gridGenoId"+rowCount;
		element2.value= cellData[10];
		
	var element3 = document.createElement("input");
		element3.type = "hidden";
		element3.id="gridSrlNo"+rowCount;
		element3.name="gridSrlNo"+rowCount;
		element3.value= cellData[0];
		
	var element4 = document.createElement("input");
		element4.type = "hidden";
		element4.id="gridNonPatSex"+rowCount;
		element4.name="gridNonPatSex"+rowCount;
		element4.value= cellData[9];
		
	var element5 = document.createElement("input");
		element5.type = "hidden";
		element5.id="gridNonPatName"+rowCount;
		element5.name="gridNonPatName"+rowCount;
		element5.value= cellData[3];
	
	row.appendChild(element1);
	row.appendChild(element2);
	row.appendChild(element3);
	row.appendChild(element4);
	row.appendChild(element5);	
	row.onclick = function(){selectRow(rowCount);};
	row.ondblclick = function(){selectRowValues(rowCount);};
}

function getRelationComboValues(obj,val){	
	if(obj.value!=""){
		var relTypeId = obj.value;
		if(obj.value=="COUPLE" && val=="FAMILY"){
			document.getElementById('noOfChildsId').style.display='none';
			document.getElementById('childDetails').style.display='none';
			document.getElementById('coupleDetails').style.display='inline';
			document.getElementById('parentDetails').style.display='none';
			if((parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value)!=""){
				document.getElementById('relationWith').innerHTML = "Of  "+parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value;
			}
			document.getElementById('selectNonPatID1').style.display='none';
			document.getElementById('selectNonPatID1_').style.display='none';
		}else if(obj.value=="CHILD" && val=="FAMILY"){
			document.getElementById('noOfChildsId').style.display='inline';
			document.getElementById('childDetails').style.display='inline';
			document.getElementById('coupleDetails').style.display='none';
			document.getElementById('parentDetails').style.display='none';
			if((parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value)!=""){
				document.getElementById('relationWith').innerHTML = "Of  "+parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value+" and ";
				document.getElementById('selectNonPatID1').style.display='inline';
				document.getElementById('selectNonPatID1_').style.display='inline';
			}else{
				document.getElementById('relationWith').innerHTML = "";
				document.getElementById('selectNonPatID1').style.display='none';
				document.getElementById('selectNonPatID1_').style.display='none';
			}
			if((parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value)!=""){
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr+=" condition=\"NONPATIENTCOUPLEDTLS\" ";
				xmlStr+=" non_patient_id=\""+parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatID.value+"\"";
				xmlStr+=" geno_id=\""+parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.genoId.value+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
				xmlHttp.open("POST", url, false);
				xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
				xmlHttp.send(xmlDoc);	
				var nonPatCoupDtls = trim(xmlHttp.responseText);
				var nonPatCoupLen = eval("document.genogramAddFamilyMemberFrm.selectNonPatID1.length") ;
				for(var i=0;i<nonPatCoupLen;i++)
				{
					eval("document.genogramAddFamilyMemberFrm.selectNonPatID1.remove(\"selectNonPatID1\")") ;
				}
				var tp = "-------------- "+getLabel("Common.defaultSelect.label","Common")+" --------------" ;
				var nonPatCoupopt = eval("document.createElement(\"OPTION\")") ;
				nonPatCoupopt.text = tp ;
				nonPatCoupopt.value = "" ;
				eval("document.genogramAddFamilyMemberFrm.selectNonPatID1.add(nonPatCoupopt)") ;
				if(nonPatCoupDtls!=""){
					var nonPatCoup = nonPatCoupDtls.split("|");
					for(var k=0;k<nonPatCoup.length;k++){
						var nonPatCoup_ = (nonPatCoup[k]).split("~");
						var nonPatCoupopt1 = eval("document.createElement(\"OPTION\")") ;
						nonPatCoupopt1.text = nonPatCoup_[2]+" - "+nonPatCoup_[3] ;
						nonPatCoupopt1.value = nonPatCoup_[0]+"|"+nonPatCoup_[1]+"|"+nonPatCoup_[4];
							eval("document.genogramAddFamilyMemberFrm.selectNonPatID1.add(nonPatCoupopt1)") ;
					}
				}
			}
		}else if(obj.value=="PAR" && val=="FAMILY"){
			document.getElementById('noOfChildsId').style.display='none';
			document.getElementById('childDetails').style.display='none';
			document.getElementById('coupleDetails').style.display='none';
			document.getElementById('parentDetails').style.display='inline';
			if((parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value)!=""){
				document.getElementById('relationWith').innerHTML = "Of  "+parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value;
			}
			document.getElementById('selectNonPatID1').style.display='none';
			document.getElementById('selectNonPatID1_').style.display='none';
			relTypeId = "COUPLE";
		}		
		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr+=" condition=\"GETRELATIONCOMBOVALUES\" ";
		xmlStr+=" relTypeId=\""+relTypeId+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
		xmlHttp.open("POST", url, false);
		xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
		xmlHttp.send(xmlDoc); 
		var resultVal = trim(xmlHttp.responseText);
		if(obj.value=="PAR" && val=="FAMILY"){	
			var len = eval("document.genogramAddFamilyMemberFrm.relationValueFaMo.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddFamilyMemberFrm.relationValueFaMo.remove(\"relationValueFaMo\")") ;
			}
			var tp = "-------------- "+getLabel("Common.defaultSelect.label","Common")+" --------------" ;
			var opt = eval("document.createElement(\"OPTION\")") ;
			opt.text = tp ;
			opt.value = "" ;
			eval("document.genogramAddFamilyMemberFrm.relationValueFaMo.add(opt)") ;
			if(resultVal!=""){
				var valArr = resultVal.split("|");			
				for(var j=0;j<valArr.length;j++){
					var valArr_ = (valArr[j]).split("~");
					var opt1 = eval("document.createElement(\"OPTION\")") ;
					opt1.text = valArr_[1] ;
					opt1.value = valArr_[0] ;
						eval("document.genogramAddFamilyMemberFrm.relationValueFaMo.add(opt1)") ;
				}
			}
		}else if(obj.value=="COUPLE" && val=="FAMILY"){	
			var len = eval("document.genogramAddFamilyMemberFrm.relationValue.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddFamilyMemberFrm.relationValue.remove(\"relationValue\")") ;
			}
			var tp = "-------------- "+getLabel("Common.defaultSelect.label","Common")+" --------------" ;
			var opt = eval("document.createElement(\"OPTION\")") ;
			opt.text = tp ;
			opt.value = "" ;
			eval("document.genogramAddFamilyMemberFrm.relationValue.add(opt)") ;
			if(resultVal!=""){
			var valArr = resultVal.split("|");
				for(var j=0;j<valArr.length;j++){
					var valArr_ = (valArr[j]).split("~");
					var opt1 = eval("document.createElement(\"OPTION\")") ;
					opt1.text = valArr_[1] ;
					opt1.value = valArr_[0] ;
						eval("document.genogramAddFamilyMemberFrm.relationValue.add(opt1)") ;
				}
			}
		}else if(obj.value=="CHILD" && val=="FAMILY"){	
			var len = eval("document.genogramAddFamilyMemberFrm.relationValueCh0.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddFamilyMemberFrm.relationValueCh0.remove(\"relationValueCh0\")") ;
			}
			var tp = "-------------- "+getLabel("Common.defaultSelect.label","Common")+" --------------" ;
			var opt = eval("document.createElement(\"OPTION\")") ;
			opt.text = tp ;
			opt.value = "" ;
			eval("document.genogramAddFamilyMemberFrm.relationValueCh0.add(opt)") ;
			if(resultVal!=""){
			var valArr = resultVal.split("|");
				for(var j=0;j<valArr.length;j++){
					var valArr_ = (valArr[j]).split("~");
					var opt1 = eval("document.createElement(\"OPTION\")") ;
					opt1.text = valArr_[1] ;
					opt1.value = valArr_[0] ;
						eval("document.genogramAddFamilyMemberFrm.relationValueCh0.add(opt1)") ;
				}
			}
		}else if(val=="RELATION"){
			//var relation_val = eval("document.genogramAddSEIRelationFrm.emoRelationShipValue.value");				
			var len = eval("document.genogramAddSEIRelationFrm.emoRelationId.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddSEIRelationFrm.emoRelationId.remove(\"emoRelationId\")") ;
			}
			var tp = "-------------- "+getLabel("Common.defaultSelect.label","Common")+" --------------" ;
			var opt = eval("document.createElement(\"OPTION\")") ;
			opt.text = tp ;
			opt.value = "" ;
			eval("document.genogramAddSEIRelationFrm.emoRelationId.add(opt)") ;
			if(resultVal!=""){
				var valArr = resultVal.split("|");
				for(var j=0;j<valArr.length;j++){
					var valArr_ = (valArr[j]).split("~");
					var opt1 = eval("document.createElement(\"OPTION\")") ;
					opt1.text = valArr_[1] ;
					opt1.value = valArr_[0] ;
						eval("document.genogramAddSEIRelationFrm.emoRelationId.add(opt1)") ;
				}
			}
		}
		/*if(val=="RELATION"){
			//var relation_val = eval("document.genogramAddSEIRelationFrm.emoRelationShipValue.value");				
			var len = eval("document.genogramAddSEIRelationFrm.emoRelationId.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddSEIRelationFrm.emoRelationId.remove(\"emoRelationId\")") ;
			}
			var tp = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
			var opt = eval("document.createElement(\"OPTION\")") ;
			opt.text = tp ;
			opt.value = "" ;
			eval("document.genogramAddSEIRelationFrm.emoRelationId.add(opt)") ;
			var valArr = resultVal.split("|");
			for(var j=0;j<valArr.length;j++){
				var valArr_ = (valArr[j]).split("~");
				var opt1 = eval("document.createElement(\"OPTION\")") ;
				opt1.text = valArr_[1] ;
				opt1.value = valArr_[0] ;
					eval("document.genogramAddSEIRelationFrm.emoRelationId.add(opt1)") ;
			}
		}else if(val=="FAMILY"){
			//var relation_val = eval("document.genogramAddSEIRelationFrm.emoRelationShipValue.value");	
			var len = eval("document.genogramAddFamilyDtlsFrm.relationValue.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddFamilyDtlsFrm.relationValue.remove(\"relationValue\")") ;
			}
			var tp = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
			var opt = eval("document.createElement(\"OPTION\")") ;
			opt.text = tp ;
			opt.value = "" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt)") ;
			var valArr = resultVal.split("|");
			for(var j=0;j<valArr.length;j++){
				var valArr_ = (valArr[j]).split("~");
				var opt1 = eval("document.createElement(\"OPTION\")") ;
				opt1.text = valArr_[1] ;
				opt1.value = valArr_[0] ;
					eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt1)") ;
			}
		}*/
	}else if(obj.value=="" && val=="FAMILY"){
		var len =  eval("document.genogramAddFamilyMemberFrm.relationValue.length") ;
		for(var i=0;i<len;i++)
		{
			eval("document.genogramAddFamilyMemberFrm.relationValue.remove(\"relationValue\")") ;
		}
		var tp = "-------------- "+getLabel("Common.defaultSelect.label","Common")+" --------------" ;
		var opt = eval("document.createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval("document.genogramAddFamilyMemberFrm.relationValue.add(opt)") ;
		
		document.getElementById('noOfChildsId').style.display='none';
		document.getElementById('childDetails').style.display='none';
		document.getElementById('coupleDetails').style.display='inline';
		document.getElementById('parentDetails').style.display='none';
		if((parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value)!=""){
			document.getElementById('relationWith').innerHTML = "Of  "+parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatName.value;
		}
		document.getElementById('selectNonPatID1').style.display='none';
		document.getElementById('selectNonPatID1_').style.display='none';
	}else if(obj.value=="" && val=="RELATION"){
		var len = eval("document.genogramAddSEIRelationFrm.emoRelationId.length") ;
		for(var i=0;i<len;i++)
		{
			eval("document.genogramAddSEIRelationFrm.emoRelationId.remove(\"emoRelationId\")") ;
		}
		var tp = "-------------- "+getLabel("Common.defaultSelect.label","Common")+" --------------" ;
		var opt = eval("document.createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval("document.genogramAddSEIRelationFrm.emoRelationId.add(opt)") ;
	}
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}


function getPatientDtls(obj,val,val1,val2)
{ 
	var pat_id =  '';
	if(val2=='OnBlur'){
		pat_id =  obj.value;
	}else if(val2=='OnClick'){
		pat_id =  PatientSearch();
	}
	if(pat_id != null && pat_id!=undefined){
		if((obj.value)==undefined){
			var obj_ = eval(obj);
			obj_.value=pat_id;
		}else{
			obj.value = pat_id;
		}
		/* not Required
		var totalRec = document.getElementById("totalRecords").value;
		var indexPatId = document.getElementById("indexPatId").value;
		if((pat_id==indexPatId)&&(totalRec==1)){
			document.getElementById("relationShipTypeValue").value="";
			document.getElementById("relationShipTypeValue").disabled = true;
			var len = eval("document.genogramAddFamilyDtlsFrm.relationValue.options.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddFamilyDtlsFrm.relationValue.remove(\"relationValue\")") ;
			}
			
			document.getElementById("relationValue").disabled = true;
			document.getElementById('relst').style.display='none';
			document.getElementById('rel').style.display='none';	
		}else{
			document.getElementById("relationShipTypeValue").value="";
			document.getElementById("relationShipTypeValue").disabled = false;
			var len = eval("document.genogramAddFamilyDtlsFrm.relationValue.options.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddFamilyDtlsFrm.relationValue.remove(\"relationValue\")") ;
			}
			document.getElementById("relationValue").disabled = false;
			document.getElementById('relst').style.display='inline';
			document.getElementById('rel').style.display='inline';
		}
		*/
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr+=" condition=\"GETPATIENTDTLS\" ";
		xmlStr+=" patient_id=\""+pat_id+"\"";
		xmlStr+=" condition1=\""+val+"\" ";
		xmlStr+=" condition2=\""+val1+"\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
		xmlHttp.open("POST", url, false);
		xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		
	}
	//document.getElementById("patientId").focus();
	
}
function addChildrens(){
	var noOfChilds = parseInt(document.genogramAddFamilyMemberFrm.noOfChilds.value);
	var noOfChilds_ = parseInt(document.genogramAddFamilyMemberFrm.noOfChilds_.value);
	
	
	if(noOfChilds != noOfChilds_){
		if(noOfChilds > noOfChilds_){
			//add Childs;
			var count = noOfChilds - noOfChilds_;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root><SEARCH ";
			xmlStr+=" condition=\"GETRELATIONCOMBOVALUES\" ";
			xmlStr+=" relTypeId=\"CHILD\"";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
			xmlHttp.open("POST", url, false);
			xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
			xmlHttp.send(xmlDoc); 
			var resultVal = trim(xmlHttp.responseText);
			
			for(var i=noOfChilds_;i<noOfChilds;i++){
				addChild_(resultVal);
			}
			
		}else if(noOfChilds<noOfChilds_){
			var table = document.getElementById("childDtlsTable");				
			var count = noOfChilds_ - noOfChilds;
			for(var i=noOfChilds_;i>noOfChilds;i--){
				var table = document.getElementById("childDtlsTable");
					table.deleteRow(i-1);
			}
			
		}
		document.genogramAddFamilyMemberFrm.noOfChilds_.value = noOfChilds;
	}
}
function addChild_(resultVal){
	var img = document.createElement('img');
		img.src = "../../eCommon/images/mandatory.gif";
				
	var table = document.getElementById("childDtlsTable");
	var rowCount = table.rows.length;				
	var row = table.insertRow(rowCount);
		row.id = "rowID"+rowCount;
	var newTable = document.createElement("Table");
	
	var newRow1 = newTable.insertRow(0);
		var newCell11 = newRow1.insertCell(0);
			newCell11.className = 'label';
			newCell11.style.width="350px";
			newCell11.innerHTML="Relation";
			
		var element1 = document.createElement("select");
			element1.id="relationValueCh"+(rowCount);
			element1.name="relationValueCh"+rowCount;
			element1.style.width="200px";
			
				var genderoption1 = document.createElement("option");
					genderoption1.value	= "";
					genderoption1.text 	= "-------------- "+getLabel("Common.defaultSelect.label","Common")+" --------------" ;
					element1.add(genderoption1);						
			
				var valArr = resultVal.split("|");
				for(var j=0;j<valArr.length;j++){
					var valArr_ = (valArr[j]).split("~");							
					var genderoption2 = document.createElement("option");
						genderoption2.value	= valArr_[0] ;
						genderoption2.text 	= valArr_[1] ;
						element1.add(genderoption2);
				}
			
		var newCell12 = newRow1.insertCell(1);
			//newCell2.style.width="60%";
			newCell12.appendChild(element1);
			newCell12.appendChild(img);
			//newCell2.innerHTML="Test";
	var newRow8 =newTable.insertRow(1);
		var newCell81 = newRow8.insertCell(0);
			newCell81.className = 'label';
			newCell81.style.width="350px";
			newCell81.innerHTML="Sibling Position";
			
		var element9 = document.createElement("input");
			element9.id="rec_sibling_positionCh"+rowCount;
			element9.name="rec_sibling_positionCh"+rowCount;
			element9.type = "text";
			element9.style.width="150px";						
			element9.value = (rowCount+1);
		
		var img6 = document.createElement('img');
		img6.src = "../../eCommon/images/mandatory.gif";
		
		var newCell82 = newRow8.insertCell(1);
			newCell82.appendChild(element9);
			newCell82.appendChild(img6);
			
	var newRow2 =newTable.insertRow(2);
		var newCell21 = newRow2.insertCell(0);
			newCell21.className = 'label';
			newCell21.style.width="350px";
			newCell21.innerHTML="Patient ID";
			
		var element2 = document.createElement("input");
			element2.id="rec_patient_idCh"+rowCount;
			element2.name="rec_patient_idCh"+rowCount;
			element2.type = "text";
			element2.size="30";
			element2.maxlength="30";
			element2.onkeypress = function(){return CheckForSpecChars(event);}
			element2.onblur = function(){getPatientDtls(this,'CHILD',rowCount,'OnBlur');}; 
			element2.value = "";
		var element3 = document.createElement("button");
			element3.value ="?";
			element3.onclick = function(){getPatientDtls('document.forms[0].rec_patient_idCh'+rowCount,'CHILD',rowCount,'OnClick');};
		
		
		var newCell22 = newRow2.insertCell(1);
			newCell22.appendChild(element2);
			newCell22.appendChild(element3);
			
	var newRow3 =newTable.insertRow(3);
		var newCell31 = newRow3.insertCell(0);
			newCell31.className = 'label';
			newCell31.style.width="350px";
			newCell31.innerHTML="Name";
			
		var element4 = document.createElement("input");
			element4.id="rec_patient_nameCh"+rowCount;
			element4.name="rec_patient_nameCh"+rowCount;
			element4.type = "text";
			element4.style.width="150px";						
			element4.value = "";
		
		var img1 = document.createElement('img');
		img1.src = "../../eCommon/images/mandatory.gif";
		
		var newCell32 = newRow3.insertCell(1);
			newCell32.appendChild(element4);
			newCell32.appendChild(img1);
			
	var newRow4 =newTable.insertRow(4);
		var newCell41 = newRow4.insertCell(0);
			newCell41.className = 'label';
			newCell41.style.width="350px";
			newCell41.innerHTML="Date of Birth";
			
		var element5 = document.createElement("input");
			element5.id="date_of_birthCh"+rowCount;
			element5.name="date_of_birthCh"+rowCount;
			element5.type = "text";
			element5.size="14";
			element5.maxlength="16";
			element5.value = "";
		
		var img2 = document.createElement('img');					
		img2.src = "../../eCommon/images/mandatory.gif";
		
		var img3 = document.createElement('img');
			img3.src = "../../eCommon/images/CommonCalendar.gif";
			img3.id = "dofimgCh"+rowCount;
			img3.onclick = function(){ eval("document.forms[0].date_of_birthCh"+rowCount+".select()");return showCalendar('date_of_birthCh'+rowCount,'','','');};
		var newCell42 = newRow4.insertCell(1);
			newCell42.appendChild(element5);
			newCell42.appendChild(img3);
			newCell42.appendChild(img2);
			
	var newRow5 =newTable.insertRow(5);
		var newCell51 = newRow5.insertCell(0);
			newCell51.className = 'label';
			newCell51.style.width="350px";
			newCell51.innerHTML="Gender";
			
		var element6 = document.createElement("select");
			element6.id="genderCh"+rowCount;
			element6.name="genderCh"+rowCount;
			element6.onchange=function(){setGenderHidden(this,'gender_hiddenCh'+rowCount);};
			var element6Option1 = document.createElement("option");
				element6Option1.value	= "";
				element6Option1.text 	= "-------------- Select --------------";
				element6.add(element6Option1);
			var element6Option2 = document.createElement("option");
				element6Option2.value	= "M";
				element6Option2.text 	= "Male";
				element6.add(element6Option2);
			var element6Option3 = document.createElement("option");
				element6Option3.value	= "F";
				element6Option3.text 	= "Female";
				element6.add(element6Option3);
			var element6Option4 = document.createElement("option");
				element6Option4.value	= "U";
				element6Option4.text 	= "Unknown";
				element6.add(element6Option4);
				
			var element61 = document.createElement("input");
				element61.type = "hidden";
				element61.id="gender_hiddenCh"+rowCount;
				element61.name="gender_hiddenCh"+rowCount;
				element61.value="";
				
		var img4 = document.createElement('img');
		img4.src = "../../eCommon/images/mandatory.gif";
			
		var newCell52 = newRow5.insertCell(1);
			newCell52.appendChild(element6);
			newCell52.appendChild(img4);
			newCell52.appendChild(element61);
			
	var newRow6 =newTable.insertRow(6);
		var newCell61 = newRow6.insertCell(0);
			newCell61.className = 'label';
			newCell61.style.width="350px";
			newCell61.innerHTML="Deceased Date/Time";
			
		var element7 = document.createElement("input");
			element7.id="deceasedDateCh"+rowCount;
			element7.name="deceasedDateCh"+rowCount;
			element7.type = "text";
			element7.size="14";
			element7.maxlength="16";
			element7.value = "";
		var img5 = document.createElement('img');
			img5.src = "../../eCommon/images/CommonCalendar.gif";
			img5.id = "ddimgCh"+rowCount;
			img5.onclick = function(){ eval("document.forms[0].deceasedDateCh"+rowCount+".select()");return showCalendar('deceasedDateCh'+rowCount,'','','');};
		var newCell62 = newRow6.insertCell(1);
			newCell62.appendChild(element7);
			newCell62.appendChild(img5);
			
	var newRow7 =newTable.insertRow(7);
		var newCell71 = newRow7.insertCell(0);
			newCell71.className = 'label';
			newCell71.style.width="350px";
			newCell71.innerHTML="Deceased Remarks";
			
		var element8 = document.createElement("input");
			element8.id="deceased_remarksCh"+rowCount;
			element8.name="deceased_remarksCh"+rowCount;
			element8.type = "text";
			element8.style.width="150px";
			element8.onkeypress = function(){if (this.value.length > 249) { return false; }}
			element8.onblur = function(){controlLength(this);};
			element8.value = "";
		
		var newCell72 = newRow7.insertCell(1);
			newCell72.appendChild(element8);
			
	
		
			

	var newFieldSet = document.createElement('fieldset');
		var newLegend = document.createElement('legend');
			newLegend.innerHTML ="Child Details - "+(rowCount+1);
		newFieldSet.style.width="100%";
		newFieldSet.appendChild(newLegend);
		newFieldSet.appendChild(newTable);
		
	var cell1 = row.insertCell(0);
		cell1.appendChild(newFieldSet);

}
function setGenderHidden(obj,val){	
	//eval("document.all."+val+".value=obj.value;");
	document.getElementById(val).value=obj.value;
}
function addnewMemberDetails(){
	var relationFromNonPatID		= parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatID.value;
	var totalRecords				= parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.totalRecords.value;
	var indexPatId					= parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.indexPatId.value;
	var totalGridPatIds 			= parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.totalGridPatIds.value;
	var rec_patient_id				= parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.rec_patient_id.value;
	
	var mode 						= parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.mode.value;
	var relationShipTypeValue		= parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.relationShipTypeValue.value;
	var arrTotGridPatIds 			= totalGridPatIds.split(",");
	var submitFlag = false;
	parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.selectNonPatID.value = parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatID.value;
	parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.genoId.value = parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.genoId.value;
	parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.selectSrlNo.value = parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectSrlNo.value;
	parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.selectNonPatSex.value = parent.genogramAddFamilyMemberDtls.document.genogramAddFamilyDtlsFrm.selectNonPatSex.value;
	var formobj= parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm;
	
	if(totalRecords==1){
		// Records not available in the genogram for this patient, So first time allowed  only index patient.
		if(rec_patient_id==indexPatId){
			//Record Insert logic
			parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.stroeFirstIndexPat.value="Y";
			submitFlag=true;
		}else{
			alert('Add index patient details to proceed...');
			
		}
		if(submitFlag){
			var fields = new Array (formobj.rec_patient_name,formobj.date_of_birth,formobj.gender_hidden);
			//var names = new Array (getLabel("Common.code.label",'common_labels'),getLabel("Common.description.label",'common_labels'),getLabel("eCA.RiskFactorType.label",'CA'));
			var names = new Array ('Name','Date of Birth','Gender');
			if(!checkFieldsofMst( fields, names, parent.messageFrame)){
				submitFlag=false;
			}			
		}
	}else{
		//Relation From PatientId not Available ,Record not allowed to insert.
		//if(relationFromNonPatID!="" ||(rec_patient_id==indexPatId && mode=="MODIFY")){
		if(relationFromNonPatID!=""){
			// Grid Data indexPat is Available or not, In Case Indexpat available go to if, other wise else
			var flag = false;
			for(var i= 0;i<arrTotGridPatIds.length;i++){
				if(indexPatId==arrTotGridPatIds[i]){
					flag = true;
					break;
				}
			}
			if(flag){
				//Record Insert logic
				submitFlag=true;
			}else{
				// IndexPat Record not available in the Grid Data, So first time allowed  only index patient.
				if(relationShipTypeValue=="PAR"){
					if((formobj.rec_patient_idFa.value)==indexPatId){
						submitFlag=true;
					}else if((formobj.rec_patient_idMo.value)==indexPatId){
						submitFlag=true;
					}
				
				}else if(relationShipTypeValue=="CHILD"){
					var totalChilds = parseInt(formobj.noOfChilds_.value);
					for(var k=0;k<totalChilds;k++){
						if((eval('formobj.rec_patient_idCh'+k+'.value'))==indexPatId){
							submitFlag=true;
							break;
						}
					}					
				}else{
					if(rec_patient_id==indexPatId)
						submitFlag=true;
				}				
				if(!submitFlag){
					alert('Add index patient details to proceed...');
				}	
			}
			if(mode=="MODIFY"){
				if(submitFlag){					
					var fields = new Array (formobj.rec_patient_nameModify,formobj.date_of_birthModify,formobj.gender_hiddenModify);
					//var names = new Array (getLabel("Common.code.label",'common_labels'),getLabel("Common.description.label",'common_labels'),getLabel("eCA.RiskFactorType.label",'CA'));
					var names = new Array ('Name','Date of Birth','Gender');
					var relVal = formobj.relModifyCount.value;
					for(var i=0;i<relVal;i++){
						fields.push(eval('formobj.rel_dateModify'+(i+1)));
						names.push('Relation Start Date for '+eval('formobj.rel_personModify'+(i+1)+'.value'));
					}
					if(!checkFieldsofMst( fields, names, parent.messageFrame)){
						submitFlag=false;
					}
				}
			}else{
				if(submitFlag){
				
					if((formobj.relationShipTypeValue.value)=="COUPLE" || (formobj.relationShipTypeValue.value)==""){
						var fields = new Array (formobj.relationShipTypeValue,formobj.relationValue,formobj.relationStartDate,formobj.rec_patient_name,formobj.date_of_birth,formobj.gender);						
						var names = new Array ('RelationShip Type','Relation','Relation Start Date','Name','Date of Birth','Gender');					
						if(!checkFieldsofMst( fields, names, parent.messageFrame))						
							submitFlag=false;						
					}else if((formobj.relationShipTypeValue.value)=="CHILD"){						
						var totalChilds = parseInt(formobj.noOfChilds_.value);
						var fields = new Array (formobj.relationShipTypeValue,formobj.selectNonPatID1,formobj.relationValueCh0,formobj.rec_sibling_positionCh0,formobj.rec_patient_nameCh0,formobj.date_of_birthCh0,formobj.genderCh0);						
						var names = new Array ('RelationShip Type','Selected Person Family Relater','Child Details - 1 - Relation','Child Details - 1 - Sibling Position','Child Details - 1 - Name','Child Details - 1 - Date of Birth','Child Details - 1 - Gender');					
						for(var i=1;i<totalChilds;i++){
							fields.push(eval('formobj.relationValueCh'+i));
							names.push('Child Details - '+(i+1)+' - Relation');
							fields.push(eval('formobj.rec_sibling_positionCh'+i));
							names.push('Child Details - '+(i+1)+' - Sibling Position');
							fields.push(eval('formobj.rec_patient_nameCh'+i));
							names.push('Child Details - '+(i+1)+' - Name');
							fields.push(eval('formobj.date_of_birthCh'+i));
							names.push('Child Details - '+(i+1)+' - Date of Birth');
							fields.push(eval('formobj.genderCh'+i));
							names.push('Child Details - '+(i+1)+' - Gender');
						}
						if(!checkFieldsofMst( fields, names, parent.messageFrame))						
							submitFlag=false;
						
						
					}else if((formobj.relationShipTypeValue.value)=="PAR"){						
						var fields = new Array (formobj.relationShipTypeValue,formobj.rec_patient_nameFa,formobj.date_of_birthFa,formobj.rec_patient_nameMo,formobj.date_of_birthMo,formobj.relationValueFaMo,formobj.relationStartDateFaMo);						
						var names = new Array ('RelationShip Type','Father - Name','Father - Date of Birth','Mother - Name','Mother - Date of Birth','Father and Mother Relation','Father and Mother Relation Start Date');					
						if(!checkFieldsofMst( fields, names, parent.messageFrame))						
							submitFlag=false;						
					}
				}
			}
		}else{
			alert('Select Reference Person row in Family Members Grid.');
		}
	}	
	
	if(submitFlag){		
		parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.action="../../servlet/eCA.CAGenogramServlet";
		parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.target="messageFrame";
		parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.method="post";
		parent.genogramAddFamilyMemberFram.document.genogramAddFamilyMemberFrm.submit();
	}
	
}
//Add Famil Member  End.
// Relation Start.

function clearEmoRelation(){
	document.genogramAddSEIRelationFrm.emoRelationTypeId.value="";
	document.genogramAddSEIRelationFrm.relationRemarks.value="";
	getRelationComboValues(document.genogramAddSEIRelationFrm.emoRelationTypeId,'RELATION');
}

//Relation End.

//Common functions Start.

//Common Functions End.







function printit() 
{

	try {
		parent.frames[0].focus();
		if (document.all){
			var i = 0;		
			while( i < parent.frames[0].document.applets.length ){
				var j = 0 ;
				while ( !parent.frames[0].document.applets[i].isActive() && j++ <=75000 )
					window.status = i;
					i++;
				}
			window.setTimeout("BLOCKED SCRIPTWSHShell.SendKeys('%fu');",1);
			window.setTimeout("BLOCKED SCRIPTSetPaperSize();", 1);
			window.print();	
		}
	} catch (e) {	
		alert ("An exception occured: " + e + "\nCode is: " + e.number + "\nDescription is: " + e.description);
		alert('Please verify that your print settings have a Landscape orientation and minimum margins.');
	}
}
function SetPaperSize() {
	WSHShell.sendKeys("%a{TAB}.2{TAB}0{TAB}0{TAB}0{ENTER}");
}


function getPatGenogram(){
	//var dialogHeight ='45' ;
	//var dialogWidth = '65' ;
	//var dialogTop	= '80';
	//var dialogLeft = '130' ;
	//var screen_width=screen.width;

	//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	//var arguments	= "";
	//var patient_id	= document.genogramTranbtnFrm.patient_id.value;	
	//var timeStamp 	= new Date().getTime();
	//window.showModalDialog("../../eCA/jsp/CAPatientGenogramFrameset.jsp?<%=request.getQueryString()%>",arguments,features);
	//window.open("../../eCA/jsp/CAPatientGenogramFrameset.jsp?patient_id="+patient_id+"&timeStamp="+timeStamp,"",arguments,features);
	//window.showModalDialog("../../eCA/jsp/CAPatientGenogram.jsp?patient_id="+patient_id+"&timeStamp="+timeStamp,arguments,features);
	//alert(parent.parent.genogramTranFrame.style.scrolling);
	parent.parent.genogramTranFrame.location.href='../../eCA/jsp/CAPatientGenogramFrameset.jsp' ;
	//parent.parent.genogramTranFrame.style.scrolling='auto';
}

function addFamilyMemberClear(){
	var patient_id	= document.genogramAddFamilybtnFrm.patient_id.value;
	parent.genogramAddFamilyMemberDtls.location.href='../../eCA/jsp/CAGenogramAddFamilyDtls.jsp?patient_id='+patient_id+'&mode=INSERT';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	document.getElementById("addMember").value = "Add Member";
}
function addSEIRelation(){
	
	var dialogHeight ='37' ;
	var dialogWidth = '65' ;
	var dialogTop	= '80';
	var dialogLeft = '130' ;
	var screen_width=screen.width;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments	= "";
	var patient_id	= document.genogramTranbtnFrm.patient_id.value;	
	
	//var timeStamp 	= new Date().getTime();
	//window.open("../../eCA/jsp/CAGenogramAddFamilMumberFrameSet.jsp?patient_id="+patient_id,"",arguments,features);
	window.showModalDialog("../../eCA/jsp/CAGenogramSEIRelationFrameSet.jsp?patient_id="+patient_id+"&mode=INSERT",arguments,features);
	parent.framePrint.location.href = "../../eCA/jsp/CAPatientGenogram.jsp?patient_id="+patient_id+"&mode=INSERT"; //IN043647
}
function addRelation(obj){
	var relation_val = eval("document.genogramAddFamilyDtlsFrm.relationShipTypeValue.value");	
	var len = eval("document.genogramAddFamilyDtlsFrm.relationValue.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.genogramAddFamilyDtlsFrm.relationValue.remove(\"relationValue\")") ;
	}
	var tp = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt = eval("document.createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
		
	if(relation_val=="PA"){
		var opt1 = eval("document.createElement(\"OPTION\")") ;
		opt1.text = " Father" ;
		opt1.value = "FA" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt1)") ;
		var opt2 = eval("document.createElement(\"OPTION\")") ;
		opt2.text = " Mother" ;
		opt2.value = "MO" ;	
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt2)") ;
			
		document.getElementById('relStDate').style.display='none';
		document.getElementById('sibpos').style.display='none';
		//document.getElementById("HLink").innerHTML="<A href=\"javascript:addnewMemberDetails()\"><B> + </B> </A>";
	}else if(relation_val=="CO"){
		//eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt)") ;
		
		var opt1 = eval("document.createElement(\"OPTION\")") ;
		opt1.text = " Married " ;
		opt1.value = "MA" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt1)") ;
		
		var opt2 = eval("document.createElement(\"OPTION\")") ;
		opt2.text = " Married/Separated " ;
		opt2.value = "MS" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt2)") ;
		
		var opt3 = eval("document.createElement(\"OPTION\")") ;
		opt3.text = " Back Together After Separation " ;
		opt3.value = "BS" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt3)") ;
			
		var opt4 = eval("document.createElement(\"OPTION\")") ;
		opt4.text = " Divorce " ;
		opt4.value = "DI" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt4)") ;
			
		var opt5 = eval("document.createElement(\"OPTION\")") ;
		opt5.text = " Divorce and Reconciled " ;
		opt5.value = "DR" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt5)") ;
			
		var opt6 = eval("document.createElement(\"OPTION\")") ;
		opt6.text = " Living Together " ;
		opt6.value = "LT" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt6)") ;
		
		var opt7 = eval("document.createElement(\"OPTION\")") ;
		opt7.text = " Living Together and Separated " ;
		opt7.value = "LS" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt7)") ;
		
		var opt8 = eval("document.createElement(\"OPTION\")") ;
		opt8.text = " Secret Affair " ;
		opt8.value = "SA" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt8)") ;
			
		var opt9 = eval("document.createElement(\"OPTION\")") ;
		opt9.text = " Gay Couple " ;
		opt9.value = "GC" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt9)") ;
			
		var opt10 = eval("document.createElement(\"OPTION\")") ;
		opt10.text = " Lesbian Couple " ;
		opt10.value = "LC" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt10)") ;	

		document.getElementById('relStDate').style.display='inline';
		document.getElementById('sibpos').style.display='none';
		
	}else if(relation_val=="CH"){
		//eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt)") ;
		var opt1 = eval("document.createElement(\"OPTION\")") ;
		opt1.text = " Son " ;
		opt1.value = "SO" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt1)") ;
		var opt2 = eval("document.createElement(\"OPTION\")") ;
		opt2.text = " Daughter " ;
		opt2.value = "DA" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt2)") ;
		
		var opt3 = eval("document.createElement(\"OPTION\")") ;
		opt3.text = " Adopted " ;
		opt3.value = "AD" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt3)") ;
			
		var opt4 = eval("document.createElement(\"OPTION\")") ;
		opt4.text = " Foster " ;
		opt4.value = "FO" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt4)") ;
			
		var opt5 = eval("document.createElement(\"OPTION\")") ;
		opt5.text = " Abortion " ;
		opt5.value = "AB" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt5)") ;
		
		var opt6 = eval("document.createElement(\"OPTION\")") ;
		opt6.text = " Still Birth " ;
		opt6.value = "SB" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt6)") ;
		
		var opt7 = eval("document.createElement(\"OPTION\")") ;
		opt7.text = " Miscarriage " ;
		opt7.value = "MI" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt7)") ;
		
		var opt8 = eval("document.createElement(\"OPTION\")") ;
		opt8.text = " Unknow Sex" ;
		opt8.value = "US" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt8)") ;
		
		var opt9 = eval("document.createElement(\"OPTION\")") ;
		opt9.text = " Identical Twins " ;
		opt9.value = "IT" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt9)") ;
		
		var opt10 = eval("document.createElement(\"OPTION\")") ;
		opt10.text = " Frqaternal Twins " ;
		opt10.value = "FT" ;
			eval("document.genogramAddFamilyDtlsFrm.relationValue.add(opt10)") ;	
			
		document.getElementById('relStDate').style.display='none';
		document.getElementById('sibpos').style.display='inline';
		
	}
	
}
function getPatientDtls_(objCode)
{ 
	var pat_id =  PatientSearch();
	if(pat_id != null){
		document.getElementById("rec_patient_id").value = pat_id;
		var totalRec = document.getElementById("totalRecords").value;
		var indexPatId = document.getElementById("indexPatId").value;
		if((pat_id==indexPatId)&&(totalRec==1)){
			document.getElementById("relationShipTypeValue").value="";
			document.getElementById("relationShipTypeValue").disabled = true;
			var len = eval("document.genogramAddFamilyDtlsFrm.relationValue.options.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddFamilyDtlsFrm.relationValue.remove(\"relationValue\")") ;
			}
			
			document.getElementById("relationValue").disabled = true;
			document.getElementById('relst').style.display='none';
			document.getElementById('rel').style.display='none';	
		}else{
			document.getElementById("relationShipTypeValue").value="";
			document.getElementById("relationShipTypeValue").disabled = false;
			var len = eval("document.genogramAddFamilyDtlsFrm.relationValue.options.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddFamilyDtlsFrm.relationValue.remove(\"relationValue\")") ;
			}
			document.getElementById("relationValue").disabled = false;
			document.getElementById('relst').style.display='inline';
			document.getElementById('rel').style.display='inline';
		}
		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr+=" condition=\"GETPATIENTDTLS\" ";
		xmlStr+=" patient_id=\""+pat_id+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
		xmlHttp.open("POST", url, false);
		xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
		xmlHttp.send(xmlDoc);		
		eval(xmlHttp.responseText);
		
		document.getElementById('rec_patient_name').readOnly =true;
		document.getElementById('date_of_birth').readOnly =true;
		document.getElementById('dofimg').disabled =true;
		document.getElementById("gender").disabled = true;
	}else{
		document.getElementById('rec_patient_name').readOnly =false;
		document.getElementById('date_of_birth').readOnly =false;
		document.getElementById('dofimg').disabled =false;
		document.getElementById("gender").disabled = false;
	}
	
	//document.getElementById("patientId").focus();
	
}

function mandatoryRelation(pat_id,relationShipType){
		var indexPatId = document.getElementById("indexPatId").value;
		//if((pat_id==indexPatId && relationShipType=="")){
		if(relationShipType==""){
			document.getElementById("relationShipTypeValue").value="";
			document.getElementById("relationShipTypeValue").disabled = true;
			var len = eval("document.genogramAddFamilyDtlsFrm.relationValue.options.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddFamilyDtlsFrm.relationValue.remove(\"relationValue\")") ;
			}
			
			document.getElementById("relationValue").disabled = true;
			document.getElementById('relst').style.display='none';
			document.getElementById('rel').style.display='none';			
			
		}else{
			document.getElementById("relationShipTypeValue").value="";
			document.getElementById("relationShipTypeValue").disabled = false;
			var len = eval("document.genogramAddFamilyDtlsFrm.relationValue.options.length") ;
			for(var i=0;i<len;i++)
			{
				eval("document.genogramAddFamilyDtlsFrm.relationValue.remove(\"relationValue\")") ;
			}
			document.getElementById("relationValue").disabled = false;
			document.getElementById('relst').style.display='inline';
			document.getElementById('rel').style.display='inline';
			
		}
		if((pat_id!="")){
			document.getElementById('rec_patient_name').readOnly =true;
			document.getElementById('date_of_birth').readOnly =true;
			document.getElementById('dofimg').disabled =true;
			document.getElementById("gender").disabled = true;			
			
		}else{
			document.getElementById('rec_patient_name').readOnly =false;
			document.getElementById('date_of_birth').readOnly =false;
			document.getElementById('dofimg').disabled =false;
			document.getElementById("gender").disabled = false;
		}
}
function CheckDateNew(Object2,focusflag) {
	var datefield = Object2;
    if (ChkDateNew(Object2) == false) {
		//alert(getMessage("INVALID_DATE_FMT","CA"));		
        if(focusflag == null){
            datefield.select();
            datefield.focus();
        }
        return false;
    }
    else {
        return true;
    }
}

function ChkDateNew(Object3) {
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();
	var strYearArray = new Array();

    strDate = datefield.value;
    if (strDate.length == 0) return true;

	if(Object3.value.indexOf('.') > 0) return false;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYearArray = strDateArray[2].split(" ");
		strYear = strYearArray[0];
    }

    if (strYear.length < 4 || strYear.length > 4) return false;

    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

    if (strYear < 1800) return false;

        if (strMonth>12 || strMonth<1)  return false;

    if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) return false;

    if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDay > 30 || strDay < 1)) return false;

    if (strMonth == 2) {
        if (strDay < 1) return false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) return false;
        }
        else {
            if (strDay > 28) return false;
        }
    }
    return true;
}
function checkPeriodFromTo(from,format,locale,lable)
{	
	
	var currDate = getCurrentDate(format,locale);
 	if(from.value !="")
	{
		if(!validDateObj(from,format,locale))
		{
			//alert(getMessage("INVALID_DATE_TIME","CA"));
			from.select();
			from.focus();
			return false;
		}
		
		if(!isBeforeNow(from.value,"DMY",locale))
		{
			//alert(getMessage("FROM_DATE_GREATER_SYSDATE","CA"));
			alert(lable+" Should Not Be Greater than Current Date");
			from.select();
			from.focus();
			return false;
		}
		
	}

	return true;
}





function clickFromRelation(){
	var fromRelation	= "";
	if((document.genogramFamilyMemberDtlsFrm.fromRelation.length)!=undefined){
	
		for(var i=0;i<(document.genogramFamilyMemberDtlsFrm.fromRelation.length);i++){
			if(document.genogramFamilyMemberDtlsFrm.fromRelation[i].checked)
				fromRelation = document.genogramFamilyMemberDtlsFrm.fromRelation[i].value;
		}
	}else{
		
		if(document.genogramFamilyMemberDtlsFrm.fromRelation.checked){
				fromRelation = document.genogramFamilyMemberDtlsFrm.fromRelation.value;	
		}
	}
	if(fromRelation!=""){
		var fromRelArr = fromRelation.split("|");
		document.genogramFamilyMemberDtlsFrm.genoId.value	= fromRelArr[0];
		document.genogramFamilyMemberDtlsFrm.srlNo.value		= fromRelArr[1];
		document.genogramFamilyMemberDtlsFrm.fromRelationId.value	= fromRelArr[2];
		refreshRelationDtls();
	}
}
function clickToRelation(){
	var toRelation	= "";
	if((document.genogramFamilyMemberDtlsFrm.toRelation.length)!=undefined){
		for(var i=0;i<(document.genogramFamilyMemberDtlsFrm.toRelation.length);i++){
			if(document.genogramFamilyMemberDtlsFrm.toRelation[i].checked)
				toRelation = document.genogramFamilyMemberDtlsFrm.toRelation[i].value;
		}
	}else{
		if(document.genogramFamilyMemberDtlsFrm.toRelation.checked)
				toRelation = document.genogramFamilyMemberDtlsFrm.toRelation.value;
	}
	if(toRelation!=""){
		var toRelArr = toRelation.split("|");		
		document.genogramFamilyMemberDtlsFrm.toRelationId.value	= toRelArr[2];
		refreshRelationDtls();
	}
	
}
function refreshRelationDtls(){
	
	var fromRelation	= document.genogramFamilyMemberDtlsFrm.fromRelationId.value;
	var toRelation		= document.genogramFamilyMemberDtlsFrm.toRelationId.value;
	var patient_id		= document.genogramFamilyMemberDtlsFrm.patient_id.value;
	if(fromRelation!="" && toRelation!=""){
		parent.genogramSEIRelationDtlsFrame.location.href='../../eCA/jsp/CAGenogramSEIRelationDtls.jsp?patient_id='+patient_id+'&fromRelationId='+fromRelation+'&toRelationId='+toRelation;
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	}else{
		parent.genogramSEIRelationDtlsFrame.location.href='../../eCA/jsp/CAGenogramSEIRelationDtls.jsp?patient_id='+patient_id;
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	}
}
function addEmoRelation(){	
	var fromRelation	= parent.genogramFamilyMemberDtlsFrame.document.genogramFamilyMemberDtlsFrm.fromRelationId.value;
	var toRelation		= parent.genogramFamilyMemberDtlsFrame.document.genogramFamilyMemberDtlsFrm.toRelationId.value;
	
	if(fromRelation=="" || toRelation==""){
		alert('Please select From Relation and To Relation....');
	}else if(fromRelation==toRelation){
		alert('From Relation and To Relation should not be the same person...');
	}else{
		var len = document.genogramAddSEIRelationFrm.relationRemarks.value.length;
		if(len>250){
			alert('Max.limit of Remarks is 250 Characters.');
			document.genogramAddSEIRelationFrm.relationRemarks.select();
		}else{
			document.genogramAddSEIRelationFrm.fromRelationId.value = fromRelation;
			document.genogramAddSEIRelationFrm.toRelationId.value = toRelation;
			document.genogramAddSEIRelationFrm.genoId.value = parent.genogramFamilyMemberDtlsFrame.document.genogramFamilyMemberDtlsFrm.genoId.value;
			document.genogramAddSEIRelationFrm.srlNo.value = parent.genogramFamilyMemberDtlsFrame.document.genogramFamilyMemberDtlsFrm.srlNo.value;
			var submitFlag=true;
			var fields = new Array (document.genogramAddSEIRelationFrm.emoRelationTypeId,document.genogramAddSEIRelationFrm.emoRelationId);		
			var names = new Array ('Relationship Type','Relationship');
			if(!checkFieldsofMst( fields, names, parent.messageFrame)){
				submitFlag=false;
			}else{
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr+=" condition=\"GETVALIDATIONESI\" ";
				xmlStr+=" fromRelation=\""+fromRelation+"\"";
				xmlStr+=" toRelation=\""+toRelation+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
				xmlHttp.open("POST", url, false);
				xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
				xmlHttp.send(xmlDoc); 
				var resultVal = trim(xmlHttp.responseText);
				if(resultVal!="0"){
					alert('Only one Relation allowed between two persons.');
					submitFlag=false;
				}
			}
			if(submitFlag){
				document.genogramAddSEIRelationFrm.action="../../servlet/eCA.CAGenogramServlet";
				document.genogramAddSEIRelationFrm.target="messageFrame";
				document.genogramAddSEIRelationFrm.method="post";
				document.genogramAddSEIRelationFrm.submit();
			}
		}
	}
}
function removeRelaitons(){
	var totalRelations	= parent.genogramSEIRelationDtlsFrame.document.genogramSEIRelationDtlsFrm.totalRelations.value;
	var selectedRelations = 0;
	var selRelValues = "";
	for(var i=0;i<totalRelations;i++){
		if(eval('parent.genogramSEIRelationDtlsFrame.document.genogramSEIRelationDtlsFrm.selectRelation'+i+'.checked')){
			if(selectedRelations!=0){				
				selRelValues = selRelValues+"|"+eval('parent.genogramSEIRelationDtlsFrame.document.genogramSEIRelationDtlsFrm.selectRelation'+i+'.value');				
			}else{				
				selRelValues = selRelValues+eval('parent.genogramSEIRelationDtlsFrame.document.genogramSEIRelationDtlsFrm.selectRelation'+i+'.value');
			}
			selectedRelations++;
		}
	}
	if(selectedRelations>0){
		var fromRelation	= parent.genogramFamilyMemberDtlsFrame.document.genogramFamilyMemberDtlsFrm.fromRelationId.value;
		var toRelation		= parent.genogramFamilyMemberDtlsFrame.document.genogramFamilyMemberDtlsFrm.toRelationId.value;
		parent.genogramAddSEIRelationFrame.document.genogramAddSEIRelationFrm.fromRelationId.value = fromRelation;
		parent.genogramAddSEIRelationFrame.document.genogramAddSEIRelationFrm.toRelationId.value = toRelation;
		parent.genogramAddSEIRelationFrame.document.genogramAddSEIRelationFrm.genoId.value = parent.genogramFamilyMemberDtlsFrame.document.genogramFamilyMemberDtlsFrm.genoId.value;
		parent.genogramAddSEIRelationFrame.document.genogramAddSEIRelationFrm.srlNo.value  = parent.genogramFamilyMemberDtlsFrame.document.genogramFamilyMemberDtlsFrm.srlNo.value;
		parent.genogramAddSEIRelationFrame.document.genogramAddSEIRelationFrm.mode.value   = "RemoveEmotionalRelation";
		parent.genogramAddSEIRelationFrame.document.genogramAddSEIRelationFrm.removeRelations.value  = selRelValues;
		
		parent.genogramAddSEIRelationFrame.document.genogramAddSEIRelationFrm.action="../../servlet/eCA.CAGenogramServlet";
		parent.genogramAddSEIRelationFrame.document.genogramAddSEIRelationFrm.target="messageFrame";
		parent.genogramAddSEIRelationFrame.document.genogramAddSEIRelationFrm.method="post";
		parent.genogramAddSEIRelationFrame.document.genogramAddSEIRelationFrm.submit();
		
	}else{
		alert('Select one Relation...');
	}
	
}
function onSuccessEmotionalRelation(valueDtls)
{
	var patient_id	= parent.genogramFamilyMemberDtlsFrame.document.genogramFamilyMemberDtlsFrm.patient_id.value;
	var relatonValArr = valueDtls.split("|");
	parent.genogramSEIRelationDtlsFrame.location.href='../../eCA/jsp/CAGenogramSEIRelationDtls.jsp?patient_id='+patient_id+'&fromRelationId='+relatonValArr[2]+'&toRelationId='+relatonValArr[3];
	parent.genogramAddSEIRelationFrame.location.href='../../eCA/jsp/CAGenogramAddSEIRelation.jsp?patient_id='+patient_id;	
}
function clearMsg(){
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
function controlLength(obj){
	var len = obj.value.length;
	if(len>250){
		alert('Max.limit of Remarks is 250 Characters.');
		obj.select();
	}
}
function trim(str) {
        return str.replace(/^\s+|\s+$/g,"");
}


function getBack(){
	parent.parent.genogramTranFrame.location.href='../../eCA/jsp/CAPatientGenogramTranFrameset.jsp';
}
//IN043568 Start.
function ShowComments(val,fromRelationId,toRelationId){	
		var dialogHeight ='20' ;
		var dialogWidth = '30' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		window.showModalDialog('../../eCA/jsp/CAGenogramRelationRemarks.jsp?fromRelationId='+fromRelationId+'&toRelationId='+toRelationId+'&val='+val,arguments,features);

}
//IN043568 Start.
//======================================
//Medical History Starts
function addMedicalHistory(){
	var dialogHeight ='37' ;
	var dialogWidth = '65' ;
	var dialogTop	= '80';
	var dialogLeft = '130' ;
	var screen_width=screen.width;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments	= "";
	var patient_id	= document.genogramTranbtnFrm.patient_id.value;	
	
	window.showModalDialog("../../eCA/jsp/CAGenogramMedicalHistoryFrameSet.jsp?patient_id="+patient_id+"&mode=INSERT",arguments,features);
	parent.framePrint.location.href = "../../eCA/jsp/CAPatientGenogram.jsp?patient_id="+patient_id+"&mode=INSERT";  //IN043647
}

function showExistingMedHisRelations(){
	var fromRelation	= "";
	if((document.genogramMedicalHisForMemberDtlsFrm.fromRelation.length)!=undefined){
	
		for(var i=0;i<(document.genogramMedicalHisForMemberDtlsFrm.fromRelation.length);i++){
			if(document.genogramMedicalHisForMemberDtlsFrm.fromRelation[i].checked)
				fromRelation = document.genogramMedicalHisForMemberDtlsFrm.fromRelation[i].value;
		}
	}else{
		
		if(document.genogramMedicalHisForMemberDtlsFrm.fromRelation.checked){
				fromRelation = document.genogramMedicalHisForMemberDtlsFrm.fromRelation.value;	
		}
	}
	if(fromRelation!=""){
		var fromRelArr = fromRelation.split("|");
		document.genogramMedicalHisForMemberDtlsFrm.genoId.value	= fromRelArr[0];
		document.genogramMedicalHisForMemberDtlsFrm.srlNo.value		= fromRelArr[1];
		document.genogramMedicalHisForMemberDtlsFrm.fromRelationId.value	= fromRelArr[2];
		refreshMedHisRelationDtls();
	}
}

function refreshMedHisRelationDtls(){
	var fromRelation	= document.genogramMedicalHisForMemberDtlsFrm.fromRelationId.value;
	var patient_id		= document.genogramMedicalHisForMemberDtlsFrm.patient_id.value;
	if(fromRelation!=""){
		parent.genogramMedicalHisRelationDtlsFrame.location.href='../../eCA/jsp/CAGenogramMedicalHisRelationDtls.jsp?patient_id='+patient_id+'&fromRelationId='+fromRelation;
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	}else{
		parent.genogramMedicalHisRelationDtlsFrame.location.href='../../eCA/jsp/CAGenogramMedicalHisRelationDtls.jsp?patient_id='+patient_id;
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	}
}

function clearMedHisReln(){
	document.genogramAddMedicalHisRelationFrm.emoRelationTypeId.value="";
	document.genogramAddMedicalHisRelationFrm.relationRemarks.value="";
}

function addNewMedHisEmoRelation(){
	var fromRelation	= parent.genogramMedicalHisForMemberDtlsFrame.document.genogramMedicalHisForMemberDtlsFrm.fromRelationId.value;
	
	if(fromRelation==""){
		alert('Please select one Family Member....');
	}
	else{
		var len = document.genogramAddMedicalHisRelationFrm.relationRemarks.value.length;
		if(len>250){
			alert('Max.limit of Remarks is 250 Characters.');
			document.genogramAddMedicalHisRelationFrm.relationRemarks.select();
		}else{
			document.genogramAddMedicalHisRelationFrm.fromRelationId.value = fromRelation;
			document.genogramAddMedicalHisRelationFrm.genoId.value = parent.genogramMedicalHisForMemberDtlsFrame.document.genogramMedicalHisForMemberDtlsFrm.genoId.value;
			document.genogramAddMedicalHisRelationFrm.srlNo.value = parent.genogramMedicalHisForMemberDtlsFrame.document.genogramMedicalHisForMemberDtlsFrm.srlNo.value;
			var submitFlag = true;				
			var fields = new Array (document.genogramAddMedicalHisRelationFrm.emoRelationTypeId);
			var names = new Array ('Medical History Type');
			if(!checkFieldsofMst( fields, names, parent.messageFrame)){
				submitFlag=false;
			}else{
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr+=" condition=\"GETVALIDATIONMH\" ";
				xmlStr+=" fromRelation=\""+fromRelation+"\"";
				xmlStr+=" relationId=\""+document.genogramAddMedicalHisRelationFrm.emoRelationTypeId.value+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				var url = "../../eCA/jsp/CAGenogramIntermediate.jsp";
				xmlHttp.open("POST", url, false);
				xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
				xmlHttp.send(xmlDoc); 
				var resultVal = trim(xmlHttp.responseText);
				if(resultVal!="0"){
					alert('Selected Medical History Type / Group already recorded.');
					submitFlag=false;
				}
			}			
			if(submitFlag){
				document.genogramAddMedicalHisRelationFrm.action="../../servlet/eCA.CAGenogramServlet";
				document.genogramAddMedicalHisRelationFrm.target="messageFrame";
				document.genogramAddMedicalHisRelationFrm.method="post";
				document.genogramAddMedicalHisRelationFrm.submit();
			}
		}
	}
}

function onSuccessMedHisRelation(valueDtls){

	var patient_id	= parent.genogramMedicalHisForMemberDtlsFrame.document.genogramMedicalHisForMemberDtlsFrm.patient_id.value;
	var relatonValArr = valueDtls.split("|");
	parent.genogramMedicalHisRelationDtlsFrame.location.href='../../eCA/jsp/CAGenogramMedicalHisRelationDtls.jsp?patient_id='+patient_id+'&fromRelationId='+relatonValArr[2];
	parent.genogramAddMedicalHisRelationFrame.location.href='../../eCA/jsp/CAGenogramAddMedicalHisRelation.jsp?patient_id='+patient_id;	
}

function removeMedHisRelaitons(){
	var totalRelations	= parent.genogramMedicalHisRelationDtlsFrame.document.genogramMedicalHisRelationDtlsFrm.totalRelations.value;
	var selectedRelations = 0;
	var selRelValues = "";
	for(var i=0;i<totalRelations;i++){
		if(eval('parent.genogramMedicalHisRelationDtlsFrame.document.genogramMedicalHisRelationDtlsFrm.selectRelation'+i+'.checked')){
			if(selectedRelations!=0){
				selRelValues = selRelValues+"|"+eval('parent.genogramMedicalHisRelationDtlsFrame.document.genogramMedicalHisRelationDtlsFrm.selectRelation'+i+'.value');				
			}else{				
				selRelValues = selRelValues+eval('parent.genogramMedicalHisRelationDtlsFrame.document.genogramMedicalHisRelationDtlsFrm.selectRelation'+i+'.value');
			}
			selectedRelations++;
		}
	}
	if(selectedRelations>0){
		var fromRelation	= parent.genogramMedicalHisForMemberDtlsFrame.document.genogramMedicalHisForMemberDtlsFrm.fromRelationId.value;
		
		parent.genogramAddMedicalHisRelationFrame.document.genogramAddMedicalHisRelationFrm.fromRelationId.value = fromRelation;
		
		parent.genogramAddMedicalHisRelationFrame.document.genogramAddMedicalHisRelationFrm.genoId.value = parent.genogramMedicalHisForMemberDtlsFrame.document.genogramMedicalHisForMemberDtlsFrm.genoId.value;
		parent.genogramAddMedicalHisRelationFrame.document.genogramAddMedicalHisRelationFrm.srlNo.value  = parent.genogramMedicalHisForMemberDtlsFrame.document.genogramMedicalHisForMemberDtlsFrm.srlNo.value;
		parent.genogramAddMedicalHisRelationFrame.document.genogramAddMedicalHisRelationFrm.mode.value   = "RemoveMedHistory";
		parent.genogramAddMedicalHisRelationFrame.document.genogramAddMedicalHisRelationFrm.removeRelations.value  = selRelValues;
		
		parent.genogramAddMedicalHisRelationFrame.document.genogramAddMedicalHisRelationFrm.action="../../servlet/eCA.CAGenogramServlet";
		parent.genogramAddMedicalHisRelationFrame.document.genogramAddMedicalHisRelationFrm.target="messageFrame";
		parent.genogramAddMedicalHisRelationFrame.document.genogramAddMedicalHisRelationFrm.method="post";
		parent.genogramAddMedicalHisRelationFrame.document.genogramAddMedicalHisRelationFrm.submit();
		
	}else{
		//alert('Select one Relation...');
		alert('Select one Medical History Type...');//IN000000
	}
	
}
//Medical History Ends
function showCalendar_geno(id, date_format,time_format,modal_yn){ 
	//var el = eval("parent.genogramAddFamilyMemberFram.document.all."+id);
	var el = parent.genogramAddFamilyMemberFram.document.getElementById(id);
	var isModal="isDiv";
	var timeSet="";
	if ( (date_format==undefined) || (date_format=='') || (date_format==null) || (date_format=='null'))
	{
			timeSet="dd/mm/yyyy"
	}
	else 
	{
			timeSet=date_format
	}
	if ( (time_format!=undefined) && (time_format!='') && (time_format!=null) && (time_format!='null') )
	{

		timeSet = timeSet +' '+ time_format;
	}
	if ( ( ! document.getElementById("CACalanderFun") ) && parent.genogramAddFamilyMemberFram.document.getElementById(id).type!='hidden')
	{
		
		 parent.genogramAddFamilyMemberFram.document.getElementById(id).blur();
	}

	if(enableFlag)
	{
			return false
	}
	else
	{
		enableFlag=true;
	}			
	showInModal(el,timeSet);
	return false;
	
}
