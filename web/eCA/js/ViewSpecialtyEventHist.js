var dtArr = new Array();

function populateControl()
{
	var to = document.forms[0].cur_idx_value.value;
	var queryString=document.forms[0].queryString.value;
	var to_date=dtArr[to];
	var from_date=dtArr[parseInt(to)+1];
	parent.unitFrame.location.href = "../../eCA/jsp/ViewSpecialtyEventHistEvents.jsp?to_date="+to_date+"&from_date="+from_date+"&"+queryString;
}

function loadPrevNext(obj)
{
	var idx_value	= document.forms[0].idx_value.value;
	var cur_idx_value = document.forms[0].cur_idx_value.value;
	if(obj.name=="next" && parseInt(cur_idx_value)<parseInt(idx_value))
	{
	cur_idx_value=parseInt(cur_idx_value)+1;
	document.forms[0].cur_idx_value.value=cur_idx_value;
	//alert(cur_idx_value+" of "+idx_value);
	document.forms[0].label_cap.value=(cur_idx_value+1)+" of "+idx_value;
	checkDisable();
	populateControl();
	}else if(obj.name=="prev" && parseInt(cur_idx_value)>0)
	{
	cur_idx_value=parseInt(cur_idx_value)-1;
	document.forms[0].cur_idx_value.value=parseInt(cur_idx_value);
	//alert(cur_idx_value+" of "+idx_value);
	document.forms[0].label_cap.value=(cur_idx_value+1)+" of "+idx_value;
	checkDisable();
	populateControl();
	}
	
	
}

function checkDisable()
{
var idx_value	= document.forms[0].idx_value.value;
var cur_idx_value = document.forms[0].cur_idx_value.value;
cur_idx_value=parseInt(cur_idx_value)+1;
 if(parseInt(cur_idx_value)==parseInt(idx_value))
	{
		document.forms[0].next.disabled=true;
		document.forms[0].prev.disabled=false;
	}
	if(parseInt(cur_idx_value)<parseInt(idx_value))
	{
		document.forms[0].next.disabled=false;
		document.forms[0].prev.disabled=false;
	}
	if(parseInt(cur_idx_value)==1)
	{
	document.forms[0].next.disabled=false;
	document.forms[0].prev.disabled=true;
	}
}

function alignUnitsAndData(){

			var totalRows =  parent.dataFrame.document.getElementById("dataTable").rows.length;
	        var counter = totalRows-1;
            var temp = parent.dataFrame.document.getElementById("dataTitleTable").rows(0).cells.length;
         	for(var i=0;i<temp;i++) {							
				parent.dataFrame.document.getElementById("dataTitleTable").rows(0).cells(i).width=parent.dataFrame.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;				
			}
             
			 //if(temp < 4)
			//{
				//parent.dataFrame.document.getElementById("dataTitleTable").rows(0).height = parent.unitFrame.document.getElementById("unitTitleTable").rows(0).offsetHeight;
			//}
			//else
			//{
				var height = parent.dataFrame.document.getElementById("dataTitleTable").rows(0).offsetHeight;
				parent.unitFrame.document.getElementById("unitTitleTable").height = height+2;
			//}

			
        }

		function alignHeight()
		{
			var totalRows =  parent.dataFrame.document.getElementById("dataTable").rows.length;
			var totalRows =  parent.unitFrame.document.getElementById("unitTable").rows.length-2;
			//alert("left :"+parent.unitFrame.document.getElementById("unitTable").rows.length);
			//alert("right :"+parent.dataFrame.document.getElementById("dataTable").rows.length);
			var counter = eval(totalRows);
            for(var i=0;i<=counter;i++){
				var hgt=eval(parent.dataFrame.document.getElementById("dataTable").rows(i).offsetHeight);
				
				var hgt1=eval(parent.unitFrame.document.getElementById("unitTable").rows(i).offsetHeight);

//				alert("Left ="+hgt+"--- Right ="+hgt1+"--- i="+i+"---");
				
				if(parseInt(hgt,10) >= parseInt(hgt1,10)){
					parent.unitFrame.document.getElementById("unitTable").rows(i).height = parseInt(hgt,10);
				}else if(parseInt(hgt,10) < parseInt(hgt1,10)){
					parent.dataFrame.document.getElementById("dataTable").rows(i).height = parseInt(hgt1,10);				
				}	
			 }
        }

		function scrollFrame(){
          parent.unitFrame.document.body.scrollTop=
          parent.dataFrame.document.body.scrollTop;
          setTimeout("scrollTitle()",50);
        }

        function scrollTitle(){
          var x = parent.dataFrame.document.body.scrollTop;
          var y = parent.unitFrame.document.body.scrollTop;
          if(y == 0){
           parent.dataFrame.document.getElementById("divDataTitle").style.position = 'static';
           parent.dataFrame.document.getElementById("divDataTitle").style.posTop  = 0;
           parent.unitFrame.document.getElementById("divUnitTitle").style.position = 'static';
           parent.unitFrame.document.getElementById("unitTitleTable").style.position = 'static';
           parent.unitFrame.document.getElementById("unitTitleTable").style.posTop  = y;
          }else{
            parent.unitFrame.document.getElementById("divUnitTitle").style.position = 'relative';
            parent.unitFrame.document.getElementById("unitTitleTable").style.position = 'relative';
           parent.unitFrame.document.getElementById("unitTitleTable").style.posTop  = y-2;
           parent.dataFrame.document.getElementById("divDataTitle").style.position = 'relative';
           parent.dataFrame.document.getElementById("divDataTitle").style.posTop  = y-2;
          }

        }

		 function alignDivs(){
                 var x = document.body.clientHeight;
                 var y = document.body.clientWidth;
                 //alert(parent.unitFrame.document.getElementById("unitTitleTable").style.posLeft);
                 parent.unitFrame.document.getElementById("divUnitTitle").style.position = 'relative';
                 parent.unitFrame.document.getElementById("unitTitleTable").style.offsetLeft = y;
                 //alert(x);alert(y);

        }


async function getText(disc_id,strConvDt,ACCESSION_NUM,EVENT_CODE,image)
{
	var win_height		= "28";
	var win_width		= "50";
	var win_scroll_yn	= "yes";
	var retVal = new String();
	var dialogHeight = win_height ;
	var dialogWidth = win_width ;
	var dialogTop = "122";
	var status = "no";
	var scroll = win_scroll_yn;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
	var arguments	= ACCESSION_NUM ;
	ACCESSION_NUM	=	escape(ACCESSION_NUM);
	retVal =await window.showModalDialog("../../eCA/jsp/ViewSpecialtyEventText.jsp?disc_id="+disc_id+"&strConvDt="+strConvDt+"&Accessionnum="+ACCESSION_NUM+"&Contrsyseventcode="+EVENT_CODE+"&image="+image,arguments,features);
	/*for(var i=0;i<arrObjects.length;i++){
	if(arrObjects[i] != null){
		var temp1 = arrClassValues[i];
		arrObjects[i].className = temp1;
	}
}
arrObjects = new Array();
arrValues = new Array();
arrClassValues = new Array();*/
return false;
}


function openGraph()
{
	alert("In Process...............");
}


function constructValsForGraph(rowNumber,obj)
{
	if(parent.dataFrame.document.forms[0] != null)
	{
		var noOfChkdBoxes = parseInt(parent.unitFrame.document.flowSheetEventsForm.noOfChkdBoxes.value);
		
		if(obj.checked == true)
		{
			parent.unitFrame.document.flowSheetEventsForm.noOfChkdBoxes.value = noOfChkdBoxes+1;
		}
		else if(obj.checked == false)
			parent.unitFrame.document.flowSheetEventsForm.noOfChkdBoxes.value = noOfChkdBoxes-1;
		
		var shortDesc = document.getElementById('desc'+rowNumber).value;
		var discrMsrID = document.getElementById('disc_id'+rowNumber).value;
		var uom = document.getElementById('uom'+rowNumber).value;
		if(uom == "")
		{
			uom = " ";
		}
		
		var numOfDates = parent.dataFrame.document.getElementById("totCols").value;
		var tdObjectValues = "";
		var concTdObjValues = "";
		for(var t=0;t<parseInt(numOfDates,10);t++)
		{
			if(eval("parent.dataFrame.document.getElementById("visibility")"+rowNumber+"ID"+t).style.display == 'inline')
			{
				tdObjectValues = eval("parent.dataFrame.document.getElementById("values")"+rowNumber+"ForGraphs"+t).value;
				concTdObjValues = concTdObjValues + tdObjectValues +">";
			}
		}
		parent.addToGrpFrame.document.write("<html><form name='RecMatAddToGrpFrom' id='RecMatAddToGrpFrom' action='../../eCA/jsp/ChartRecordingAddToGrpIntermediate.jsp'><input type='hidden' name='ChkdBoxes' id='ChkdBoxes' value = '"+obj.checked+"'><input type='hidden' name='desc' id='desc' value = '"+shortDesc+"'><input type='hidden' name='code' id='code' value = '"+discrMsrID+"'><input type='hidden' name='concTdObjValues' id='concTdObjValues' value = '"+concTdObjValues+"'><input type='hidden' name='uom' id='uom' value = '"+uom+"'><input type='hidden' name='noOfChkdBoxes' id='noOfChkdBoxes' value = '"+document.flowSheetEventsForm.noOfChkdBoxes.value+"'><input type='hidden' name='calledFrom' id='calledFrom' value='RecMat'><input type='hidden' name='patient_id' id='patient_id' value='"+document.flowSheetEventsForm.patient_id.value+"'><input type='hidden' name='calledFrom' id='calledFrom' value='RecMat'><input type='hidden' name='encounter_id' id='encounter_id' value='"+document.flowSheetEventsForm.encounter_id.value+"'></form></html>");
		parent.addToGrpFrame.document.RecMatAddToGrpFrom.submit();
	}
	else
	{
		obj.checked = false;
		alert(getMessage("NO_DATA_AVAILABLE","CA"));
		return;
	}
}

function limitTheGraphs(obj){
	/*var counter = document.forms[0].chkGraph.length;
	var check=0;
	if(counter >1){
		for(var i=0;i<counter;i++){
			if(document.forms[0].chkGraph[i].checked){
				check++;
			}
		}

		if(check > 3){
			alert('CA0123 - Only three events can be selected');
			obj.checked = false;
			return false;
		}
	}*/
	return true;
}

function alignUnitsAndTitle(){
	var temp = parent.unitFrame.document.getElementById("unitTitleTable").rows(0).cells.length;
	var total = parent.unitFrame.document.getElementById("unitTable").rows.length;
	total = total-1;

	var counter = parent.unitFrame.document.getElementById("unitTable").rows(total).cells.length;
//var counter = parent.unitFrame.document.getElementById("unitTable").rows(parent.unitFrame.document.getElementById("unitTable").rows.length-1).cells.length;
	for(var i=0;i<counter;i++){
		parent.unitFrame.document.getElementById("unitTitleTable").rows(0).cells(i).width=	parent.unitFrame.document.getElementById("unitTable").rows(total).cells(i).offsetWidth;

//		parent.unitFrame.document.getElementById("unitTitleTable").rows(0).cells(i).width=	parent.unitFrame.document.getElementById("unitTable").rows(counter).cells(i).offsetWidth;
	}
}

function collapseColumn(colNum)
{
	var totalRows = document.dataForm.totRows.value;
	var totalCols = document.dataForm.totCols.value;	
	//alert("Columns = "+totalCols);
	//alert("Rows = "+totalRows);
	var obj = document.getElementById('visID'+colNum);
	var objDup = document.getElementById('visIDup'+colNum);
	var objPrev = document.getElementById('visID'+(parseInt(colNum,10)+1));	
	var oldText = obj.innerText;
	var oldWidth = obj.width;
	obj.width = "10%";
	objDup.width = "10%";
	obj.height = parent.unitFrame.document.getElementById("unitTitleTable").rows[0].height;	
	obj.innerHTML = "<a href=`javascript:expandColumn(\""+colNum+"\",\""+oldText+"\",\""+oldWidth+"\")` title='Click here to view "+oldText+"'>+&nbsp;</a>";
	//objDup.innerHTML = "<a href=`javascript:expandColumn(\""+colNum+"\",\""+oldText+"\",\""+oldWidth+"\")` title='Click here to view "+oldText+"'>+&nbsp;</a>";
	
	var colIDs = "";
	var dupColIDs = "";
	for(var i=0;i<totalRows;i++)
	{
		colIDs = document.getElementById('visibility'+i+'ID'+colNum);
		if(colIDs != undefined)
		{
			colIDs.style.display = "none";	
		}
		dupColIDs = document.getElementById('duplicate'+i+'ID'+colNum);
		if(dupColIDs != undefined)
		{
			dupColIDs.style='display';
		}
		
	}
	alignHeight();
}

function expandColumn(colNum,oldText,oldWidth)
{
	var totalRows = document.dataForm.totRows.value;
	var totalCols = document.dataForm.totCols.value;	
	var obj = document.getElementById('visID'+colNum);
	var objDup = document.getElementById('visIDup'+colNum);
	obj.width = oldWidth;
	objDup.width = oldWidth;
	
	obj.innerHTML = "<a href=`javascript:collapseColumn(\""+colNum+"\")`title='Click here to collapse the column'>"+oldText+"</a><br>";
	obj.noWrap = true;
	//objDup.innerHTML = "<a href=`javascript:collapseColumn(\""+colNum+"\")`>"+oldText+"</a><br>";

	var colIDs = "";
	var sepID = "";
	var duplicateID = "";
	var dupID = "";
	var imageFlowTxtVis = "";
	for(var i=0;i<totalRows;i++)
	{
		/*imageFlowTxtVis = eval("document.getElementById("imageFlowTextVis")"+i+"ID"+colNum);
		if(imageFlowTxtVis != undefined)
		{
			imageFlowTxtVis.style.display = "inline";
		}*/
		colIDs = document.getElementById('visibility'+i+'ID'+colNum);
		if(colIDs != undefined)
		{
			colIDs.style='display';
		}
		duplicateID = document.getElementById('duplicate'+i+'ID'+colNum);	
		if(duplicateID != undefined)
		{
			duplicateID.style.display = "none";
		}
		//document.dataForm.totCols.value = parseInt(totalCols,10) + 1;
		
	}
	
	alignHeight();
}

 function displayToolTip(toolTip){
			//alert(toolTip);
			var tempArray = toolTip.split("$");
			var temp="<DIV STYLE='BACKGROUND-COLOR:yellow'>";
			temp+=toolTip;
			temp +="</DIV>";
				parent.messageFrame.document.body.innerHTML = temp;
			
		}

        function hideToolTip(){
			parent.messageFrame.document.body.innerHTML = "";
		}


async function openWinForGrouping()
{
	if(parent.dataFrame.document.forms[0] == null)
	{
		alert(getMessage("NO_DATA_AVAILABLE","CA"));
		return;	
	}
	if(parent.unitFrame.document.flowSheetEventsForm.noOfChkdBoxes.value == 0)
	{
		alert(getMessage("NO_GRAPH_SELECTED","CA"));
		return;
	}

	var noOfChkdBoxes = parent.unitFrame.document.flowSheetEventsForm.noOfChkdBoxes.value;
	var allDatesForGraph = "";

	if(parent.dataFrame.document.forms[0] != null)
		allDatesForGraph = parent.dataFrame.document.forms[0].allDatesForGraph.value;
	var sentFromGraph = parent.unitFrame.document.flowSheetEventsForm.sentFromGraph.value;
	var flagGraph = parent.unitFrame.document.flowSheetEventsForm.flagGraph.value;
	var noOfGroups = parent.unitFrame.document.flowSheetEventsForm.noOfGroups.value;
	var patient_id = parent.unitFrame.document.flowSheetEventsForm.patient_id.value;
	var encounter_id = parent.unitFrame.document.flowSheetEventsForm.encounter_id.value;
	var facility_id = parent.unitFrame.document.flowSheetEventsForm.facility_id.value;

	var dialogTop		=	"90" ;
	var dialogHeight= "100" ;
	var dialogWidth = "80" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	"../../eCA/jsp/ChartRecordingGroupGraphMain.jsp?sentFromGraph="+sentFromGraph+"&flagGraph="+flagGraph+"&allDatesForGraph="+allDatesForGraph+"&numOfchkedBoxes="+noOfChkdBoxes+"&calledFrom=RecMat&noOfGroups="+noOfGroups+"&facility_id="+facility_id+"&encounterId="+encounter_id+"&patient_id="+patient_id;
	var retVal =await window.showModalDialog(action_url,arguments,features);	
	if(retVal != undefined)
	{
		parent.unitFrame.document.flowSheetEventsForm.noOfGroups.value = retVal;
	}
}

