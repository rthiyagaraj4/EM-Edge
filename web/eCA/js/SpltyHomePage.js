var dtArr = new Array();

function populateControl()
{
	var to = document.forms[0].cur_idx_value.value;
	var queryString=document.forms[0].queryString.value;
	var from_date=dtArr[to];
	var to_date=dtArr[parseInt(to)+1];
		
	parent.unitFrame.location.href = "../../eCA/jsp/SpltyHomePageEvents.jsp?to_date="+to_date+"&from_date="+from_date+"&"+queryString;

	
}

function loadHomePage()
{	
	document.getElementById("home_tab").className='tabClicked';
	document.getElementById("home_tabspan").className='tabSpanclicked';
	document.getElementById("hist_tab").className='tabA';
	document.getElementById("hist_tabspan").className='tabAspan';
	var queryString =parent.recMatConsTabsFrame.document.matConsTabsForm.queryString.value;

	parent.recMatConsDetailsFrame.location.href = '../../eCA/jsp/SpltyHomePage.jsp?'+queryString;
}

function closep()

{
	 parent.recMatConsTabsFrame.location.href = '../../eCommon/html/blank.html';
	 parent.recMatConsDetailsFrame.location.href = '../../eCommon/html/blank.html';
	 parent.recMatConsBtnsFrame.location.href = '../../eCommon/html/blank.html';

	 //parent.recMatConsTabsFrame.document.matConsTabsForm.prevSecHdgCode.value
}

function loadHistoryPage()
{	
	document.getElementById("home_tab").className='tabA';
	document.getElementById("home_tabspan").className='tabAspan';
	document.getElementById("hist_tab").className='tabClicked';
	document.getElementById("hist_tabspan").className='tabSpanclicked';
	var queryString =parent.recMatConsTabsFrame.document.matConsTabsForm.queryString.value;

	parent.recMatConsDetailsFrame.location.href = '../../eCA/jsp/CycleFrame.jsp?'+queryString;
}

async function callLinkresult(result_linked_rec_type,patient_id,module_id,cycle_no,encounter_id,FromDate,ToDate,episode_type,keyRef)
{
	var retVal			=	"";
	var dialogTop		=	"80" ;
	var dialogHeight	=	"30" ;
	var dialogWidth		=	"80" ;
	var status			=	"no";
	var arguments		=	"" ;
	var sql				=	"";
	var search_code		=	"";
	var search_desc		=	"";
	var title			=	"";
	var param			=	"";
	var action_url		=   "";
	action_url		=	'../../eCA/jsp/SpltyHomePageHistMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url			+=	"?result_linked_rec_type="+result_linked_rec_type+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&module_id="+module_id+"&cycle_no="+cycle_no+"&FromDate="+FromDate+"&ToDate="+ToDate+"&keyRef="+keyRef;
	retVal				=await	window.showModalDialog(action_url,arguments,features);
	parent.controlsFrame.location.reload();
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
				 parent.unitFrame.document.getElementById("unitTitleTable").rows(0).height =   parent.dataFrame.document.getElementById("dataTitleTable").rows(0).offsetHeight;
			//}

			
        }

		function alignHeight()
		{
			var totalRows =  parent.dataFrame.document.getElementById("dataTable").rows.length;
			var totalRows =  parent.unitFrame.document.getElementById("unitTable").rows.length-2;
			//alert("left :"+parent.unitFrame.document.getElementById("unitTable").rows.length);
			//alert("right :"+parent.dataFrame.document.getElementById("dataTable").rows.length);
			var counter = eval(totalRows);
            for(var i=0;i<counter;i++){
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
	if(top.content != null)
		top.content.workAreaFrame.details.dataFrame.document.forms[0].graphValuesOnChk.value = "";
	else
		parent.parent.details.dataFrame.document.forms[0].graphValuesOnChk.value = "";
	
	if(document.forms[0].chkGraph){
		var counter = document.forms[0].chkGraph.length;
		var check=0;
		var eventKeys = "";
		var resultNum = "";
		var resultUOM = "";
		var eventDesc = "";
		var eventDate = "";
		var tempeventKeys = "";
		var totCols = "";
		if(top.content != null)
			totCols = top.content.workAreaFrame.details.dataFrame.document.forms[0].totCols.value;
		else
			totCols = parent.parent.details.dataFrame.document.forms[0].totCols.value;

		//if(counter >1){
		if(document.forms[0].chkGraph.length != undefined || document.forms[0].chkGraph.length != null){
			for(var i=0;i<counter;i++){
				if(document.forms[0].chkGraph[i].checked){
					eventKeys +="^"+document.forms[0].chkGraph[i].value;
					resultUOM +="^"+document.forms[0].UOM[i].value;
					eventDesc +="^"+document.forms[0].desc[i].value;
					check++;
				}
			}
		}
		else{
			eventKeys += "^"+document.forms[0].chkGraph.value;
			resultUOM += "^"+document.forms[0].UOM.value;
			eventDesc += "^"+document.forms[0].desc.value;
			check++;
		}

/*************************************************************************/
		for(var r=0;r<resultUOM.length;r++)
		{
			resultUOM = resultUOM.replace(" ","#");
		}

		for(var t=0;t<eventDesc.length;t++)
		{
			eventDesc = eventDesc.replace(" ","?");
		}

		var tempRowValues = " ";
		var totCols = "";		
		var totRows = "";
		if(top.content != null)
		{
			totCols = top.content.workAreaFrame.details.dataFrame.document.forms[0].totCols.value;
			totRows = top.content.workAreaFrame.details.unitFrame.document.forms[0].rowsForGraph.value;
		}
		else
		{
			totCols = parent.parent.details.dataFrame.document.forms[0].totCols.value;
			totRows = parent.parent.details.unitFrame.document.forms[0].rowsForGraph.value;
		}


		var testVar = "";
		var chkTest = "";

		for(var y=0;y<parseInt(totRows,10);y++)
		{	
			tempRowValues = "";
			chkTest = eval("document.forms[0].chkGraphID"+y);
			if(chkTest != undefined && chkTest != null && (chkTest.checked)) 
			{
				for(var t=0;t<parseInt(totCols,10);t++)
				{
					if(top.content != null)
					{
						testVar = eval("top.content.workAreaFrame.details.dataFrame.document.forms[0].hidden"+y+"Values"+t);
					}
					else
					{
						testVar = eval("parent.parent.details.dataFrame.document.forms[0].hidden"+y+"Values"+t);
					}
					tempRowValues += ">"+testVar.value;
				}
				if(top.content != null)
				{
					top.content.workAreaFrame.details.dataFrame.document.forms[0].graphValuesOnChk.value += tempRowValues+"^%^";
				}
				else
				{
					parent.parent.details.dataFrame.document.forms[0].graphValuesOnChk.value += tempRowValues+"^%^";
				}
			}
		}
			var tempGrafValues = ""; 
			if(top.content != null)
			{
				tempGrafValues = top.content.workAreaFrame.details.dataFrame.document.forms[0].graphValuesOnChk.value;
			}
			else
			{
				tempGrafValues = parent.parent.details.dataFrame.document.forms[0].graphValuesOnChk.value;
			}

			var totalRows = parent.dataFrame.document.dataForm.totRows.value;
			var totalCols = parent.dataFrame.document.dataForm.finalTotCols.value;
			var visID = "";
			var hiddenColumns = "";
			for(var i=0;i<totalCols;i++)
			{
				visID = eval("parent.dataFrame.document.getElementById("visID")"+i);
				hiddenColumns += "!!" + visID.innerText;
			}
			parent.dataFrame.document.dataForm.hiddenColumns.value = hiddenColumns;			
/*************************************************************************/

		if(check >0 && check <11){
			eventKeys = eventKeys.substring(1);
		}else{
			if(check == 0)
			{
				alert(getMessage('NO_EVENTS_SELECTED','CA'));
				return false;
			}
			else if(check > 10)
			{
				alert(getMessage('NO_OF_EVENTS_MORE_THAN_10','CA'));
				return false;
			}
		}
		//alert(eventKeys);
		var dialogHeight= "35" ;//"29"
		var dialogWidth	= "50" ;//"42"
		var dialogTop	= "10";
		var dialogLeft	= "40";//"85"
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";

		var called_from_or = "";
		if(top.content != null){
			called_from_or ="N";
		}else{
			called_from_or = "Y"; 
		}
		var htmlValue = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form action='../../eCA/jsp/FlowSheetEventsGraphParams.jsp' method='post' name='frmEvent' id='frmEvent'><input type='hidden' name='eventKeys' id='eventKeys' value="+eventKeys+"><input type='hidden' name='resultUOM' id='resultUOM' value="+resultUOM+"><input type='hidden' name='eventDesc' id='eventDesc' value="+eventDesc+"><input type='hidden' name='dateNumvals' id='dateNumvals' value='"+tempGrafValues+"'><input type='hidden' name='totCols' id='totCols' value="+totCols+"><input type='hidden' name='eventDate' id='eventDate' value="+eventDate+"><input type='hidden' name='hiddenColumns' id='hiddenColumns' value='"+hiddenColumns+"'><input type='hidden' name='called_from_or' id='called_from_or' value="+called_from_or+"></form></body></html>"

		if(top.content != null){
			messageFrameReference.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			messageFrameReference.document.forms[0].submit();
		}else if(parent.parent.messageFrame!=null){
			parent.parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			parent.parent.messageFrame.document.forms[0].submit();
		}else{
			parent.parent.parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlValue);
			parent.parent.parent.messageFrame.document.forms[0].submit();
		}
	}
//	var url = "../jsp/FlowSheetGraphFrame.jsp?eventKeys="+eventKeys;
//	retVal = window.showModalDialog(url,'',features);
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
			tdObjectValues = eval("parent.dataFrame.document.getElementById("values")"+rowNumber+"ForGraphs"+t).value;
			concTdObjValues = concTdObjValues + tdObjectValues +">";
		}
		parent.addToGrpFrame.document.write("<html><form name='RecMatAddToGrpFrom' id='RecMatAddToGrpFrom' action='../../eCA/jsp/ChartRecordingAddToGrpIntermediate.jsp'><input type='hidden' name='ChkdBoxes' id='ChkdBoxes' value = '"+obj.checked+"'><input type='hidden' name='desc' id='desc' value = '"+shortDesc+"'><input type='hidden' name='code' id='code' value = '"+discrMsrID+"'><input type='hidden' name='concTdObjValues' id='concTdObjValues' value = '"+concTdObjValues+"'><input type='hidden' name='uom' id='uom' value = '"+uom+"'><input type='hidden' name='noOfChkdBoxes' id='noOfChkdBoxes' value = '"+document.flowSheetEventsForm.noOfChkdBoxes.value+"'><input type='hidden' name='calledFrom' id='calledFrom' value='RecMat'></form></html>");
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
	obj.innerHTML = "<a href=`javascript:expandColumn(\""+colNum+"\",\""+oldText+"\",\""+oldWidth+"\")` title='Click here to view "+oldText+"'>+</a>";
	objDup.innerHTML = "<a href=`javascript:expandColumn(\""+colNum+"\",\""+oldText+"\",\""+oldWidth+"\")` title='Click here to view "+oldText+"'>+</a>";
	
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
			dupColIDs.style.display = "inline";
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
	
	obj.innerHTML = "<img src='../../eCA/images/graph.gif' style='visibility:hidden' ></img><a href=`javascript:collapseColumn(\""+colNum+"\")`title='Click here to collapse the column'>"+oldText+"</a><br>";
	obj.noWrap = true;
	objDup.innerHTML = "<a href=`javascript:collapseColumn(\""+colNum+"\")`>"+oldText+"</a><br>";

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
			colIDs.style="display";
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

	var dialogTop		=	"90" ;
	var dialogHeight= "100" ;
	var dialogWidth = "80" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	"../../eCA/jsp/ChartRecordingGroupGraphMain.jsp?sentFromGraph="+sentFromGraph+"&flagGraph="+flagGraph+"&allDatesForGraph="+allDatesForGraph+"&numOfchkedBoxes="+noOfChkdBoxes+"&calledFrom=RecMat&noOfGroups="+noOfGroups;
	var retVal =await window.showModalDialog(action_url,arguments,features);		
}

async function enterQuickText(eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,singleMultiFlag)
{
	
	var qsForComments = document.forms[0].queryStringForComments.value;
	var viewConfRes = document.forms[0].viewConfRes.value;
	var graphorder = document.forms[0].graphorder.value;
	var flowsheetCompId = document.forms[0].flowsheetCompId.value;
	var errorEvent = document.forms[0].errorEvent.value;
	
	if(singleMultiFlag == null)
		{
		singleMultiFlag='M';
	     }

	document.forms[0].txtFlagQuickText.value = 'Y';
	var tempValues = "";
	var count=0;
	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			//alert(arrObjects[i]);
			count++;
		}
	}

	if(count == 0 && singleMultiFlag == "M"){
		alert(getMessage("EVENTS_FOR_QUICKTEXT","CA"));
		return false;
	}
	count =0;

	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			//alert(arrValues[i]);
			tempValues+= "~"+arrValues[i];
			count++;
		}
	}

	if(count == 0){
		tempValues+= "~"+eventDate+"`"+Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;
		count =1;
	}


	if(tempValues != ""){
		tempValues = tempValues.substring(1);
	}

	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;	
	
	var retVal =await window.showModalDialog("../../eCA/jsp/FlowSheetEventsQuickTextMain.jsp?qsForComments="+qsForComments+"&quickTextCodes="+tempValues+"&singleMultiFlag="+singleMultiFlag+"&noOfEvents="+count+"&graphorder="+graphorder+"&flowsheetCompId="+flowsheetCompId+"&errorEvent="+errorEvent+"&viewConfRes="+viewConfRes,'',features);
	//var retVal = window.open("../../eCA/jsp/FlowSheetEventsQuickTextMain.jsp?quickTextCodes="+tempValues);	
	//retVal =1;
	if(retVal != null && retVal != undefined && retVal != ""){
		var totalRows = document.dataForm.totRows.value;
		var totalCols = document.dataForm.totCols.value;	
		for(var i=0;i<arrObjects.length;i++){
			if(arrObjects[i] != null){
				var temp1 = arrClassValues[i];
				arrObjects[i].className = temp1;
				var temp = document.getElementById('image'+arrObjects[i].id);
				temp.style='display';			
			}			
		}
		arrObjects = new Array();
		arrValues = new Array();
		arrClassValues = new Array();
	}else{
		for(var i=0;i<arrObjects.length;i++){
			if(arrObjects[i] != null){
				var temp1 = arrClassValues[i];
				arrObjects[i].className = temp1;
			}
		}
		arrObjects = new Array();
		arrValues = new Array();
		arrClassValues = new Array();
	}
	alignHeight(); //to realign the units and data tables
	return false;
	
}

