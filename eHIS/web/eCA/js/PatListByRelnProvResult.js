/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
10/30/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210
--------------------------------------------------------------------------------------------------------
*/
var babyDetails = new Array();
var motherName = new Array();    
episodeIdArr = new Array();
patient_class = new Array();
patientIdArr = new Array();

var scrollValue=0;
patCount=0;
function clearLayer()
{
	hidePopUp();
}
function showMotherLinks(episodeid,obj)
{
	var tabdata = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><table cellpadding='3' cellspacing=0 border=1 bordercolor=BLACK><tr><td class='columnheader'><font size=1><b><fmt:message key='eCA.Babiesof.label' bundle='${ca_labels}'/>"+motherName[episodeid]+"</b></font></td></tr><tr><td><table cellpadding='3' cellspacing=0 border=1><tr><td class=SENPAT nowrap><fmt:message key='Common.patientId.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.name.label' bundle='${common_labels}'/> </td><td class=SENPAT nowrap><fmt:message key='Common.gender.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.birthDate.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.time.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.weight.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.length.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.Circumference.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.patientId.label' bundle='${common_labels}'/><fmt:message key='Common.Apgarscore.label' bundle='${common_labels}'/></td></tr>";
	if(babyDetails[episodeid] != '')
	{
		tabdata +=babyDetails[episodeid]+"</td></tr></table></table></body></html>";
		document.getElementById("motherLink").innerHTML = tabdata;
		document.getElementById("motherLink").style.top  = obj.offsetTop;
		document.getElementById("motherLink").style.left  = obj.offsetLeft+50 ;
		document.getElementById("motherLink").style.visibility='visible' ;
	}
	else
	{
		hidePopUp();
	}
}
function hidePopUp()
{
	document.getElementById("motherLink").style.visibility='hidden' ;
}
function patClick(ind)
{	
	refreshArray();
	document.PatCriteriaFrm.encounter_id.value = episodeIdArr[ind] ;
	document.PatCriteriaFrm.patient_class.value = patient_class[ind];
	document.PatCriteriaFrm.patient_id.value =patientIdArr[ind]; 
	
	//Start.32902
	var restPatientYN=document.getElementById("restPatientYN"+ind).value; 
	var accessRightsViewPatient=document.getElementById("accessRightsViewPatient").value; 
	if(patientIdArr[ind] !=="" && restPatientYN =="Y" && accessRightsViewPatient==0)
	{
	  	restrictOpenVIPPat(patientIdArr[ind],restPatientYN,accessRightsViewPatient);
	}
	else
	{
	document.PatCriteriaFrm.submit();
	}
	//end. 32902
}
function viewReferral(ref)
{
	var retVal = 	new String();
	/*
	var dialogHeight= "32" ;
	var dialogTop = "100" ;
	var dialogWidth	= "50" ;
	*/
	var dialogHeight= "85vh" ;
	var dialogWidth	= "75vw" ;
	var dialogTop	= "0vh";
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var retVal = top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref,arguments,features);
}
function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;
	top.content.workAreaFrame.PatResultFr.RelnResultTitle
	if(top.content.workAreaFrame.PatResultFr.RelnResultTitle.location.href.indexOf(".jsp") != -1)
	{
		top.content.workAreaFrame.PatResultFr.RelnResultTitle.document.body.scrollLeft=temp;
	}
}
//------------------------new functions for fixed frame sorting-------------
//added by ankur
var reOrder='';
var anchorID='';
function callForOrderBy(obj)
{
	var qryStr = top.content.workAreaFrame.PatResultFr.RelnResultLocation.document.forms[0].url.value;
	scrollValue = document.body.scrollLeft;
	//saving the value in criteria frame
	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].order_by.value=obj;
	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].re_order.value=reOrder;
	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].anchor_id.value=anchorID;
	var locn_code = top.content.workAreaFrame.PatCriteriaFr.document.forms[0].relnCode.value;
	
		if(locn_code=='ALL')
		locn_code='';
	
	//deleting the old locn_type
	val=qryStr.indexOf("&locn_type=");
	len=qryStr.length;
	sr1=qryStr.substring(0,val+1);
	sr2=qryStr.substring(val+11,len);
	qryStr=sr1; //+sr2;
	var locType=top.content.workAreaFrame.PatCriteriaFr.document.forms[0].locn_type.value;
	var url=qryStr+'&locn_type='+locType+'&orderBy='+obj+'&reOrder='+reOrder+'&anchorID='+anchorID+'&leftScrolling='+scrollValue+'&locn_code='+locn_code;
	top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatListByRelnProvResult.jsp?'+url;
}

function changeColor(object)
{
	anchorID=object.id;
	//scrollLeft=document.body.scrollLeft;
	if(object.style.color=='yellow')
	{
		reOrder='1';
		object.style.color='pink';
		return;
	}
	if(object.style.color=='pink')
	{
		reOrder='2';
		object.style.color='yellow';
		return;
	}
	reOrder='1';
	for(i=0;i<document.anchors.length;i++)
	{
		//document.anchors(i).style.color='white';

		//Updated by Arvind @02-12-2008
		document.anchors[i].style.color='white';
	}
	object.style.color='pink';
}

function storeValues(locn_type)
{
	if(locn_type!='null')
		top.content.workAreaFrame.PatCriteriaFr.document.forms[0].locn_type.value=locn_type;
}

		
		 
		 var currClass = '';
	 function callOnMouseOver(obj){
		currClass = obj.className ;
		 if("H" == "H")
			obj.className = 'FIRSTSELECTED';
		 else
			obj.className = 'FIRSTNORMAL';
	}

	function callOnMouseOut(obj){
		obj.className = currClass;
	}

	function display(from){
		cellref = document.getElementById("tab").rows[0].cells
		if("H" == "V")
			cellref = document.getElementById("tab").rows

		for(i=0; i<cellref .length; i++){
			if("H" == "H")
				cellref[i].className = 'FIRSTNORMAL'
			else
			cellref[i].cells[0].className = 'SECONDNORMAL'
		 }
		 if("H" == "H"){
			from.className = "FIRSTSELECTED"
			currClass ="FIRSTSELECTED";
		  }
		  else{
			from.className = "FIRSTNORMAL";
			currClass ="FIRSTNORMAL";
			}
	 }
 var currClass = '';
	  var url='';
	 function callOnMouseOver(obj){
		if(obj.className != "WHITE"){
			currClass = obj.className ;
			 if("H" == "H")
				obj.className = 'FIRSTSELECTED';
				else
				obj.className = 'FIRSTNORMAL';
		 }
	}

	function callOnMouseOut(obj){
		if(obj.className != "WHITE"){
			obj.className = currClass;
		}
	}

	function display(from){
		if(from.className != "WHITE"){
			cellref = document.getElementById("locnTab").rows[0].cells
			if("H" == "V")
				cellref = document.getElementById("locnTab").rows

			for(i=0; i<cellref .length; i++){
				if("H" == "H"){
					if(cellref[i].className != "WHITE"){
						cellref[i].className = 'FIRSTNORMAL';
					}
				}
				else{
					if(cellref[i].cells[0].className != "WHITE"){
						cellref[i].cells[0].className = 'SECONDNORMAL';
					}
				}
			 }
			 if("H" == "H"){
				if(from.className !="WHITE"){
					from.className = "FIRSTSELECTED"
					currClass ="FIRSTSELECTED";
				}
			  }
			  else{
				  if(from.className != "WHITE"){
					from.className = "FIRSTNORMAL";
					currClass ="FIRSTNORMAL";
				  }
				}
			}
		}
		
	function displayClass(from){
		cellref = document.getElementById("tab").rows[0].cells
		if("H" == "V")
			cellref = document.getElementById("tab").rows

		for(i=0; i<cellref .length; i++){
			if("H" == "H")
				cellref[i].className = 'FIRSTNORMAL'
			else
			cellref[i].cells[0].className = 'SECONDNORMAL'
		 }
		 if("H" == "H"){
			from.className = "FIRSTSELECTED"
			currClass ="FIRSTSELECTED";
		  }
		  else{
			from.className = "FIRSTNORMAL";
			currClass ="FIRSTNORMAL";
			}
	 }


function showPrevLocn(){

		var qryStr = parent.RelnResultPatClass.document.forms[0].queryString.value;
		qryStr=qryStr.substring(0,qryStr.length-10);
		var pat_type =  document.forms[0].pat_type.value;
		var cur_pos=document.forms[0].currentPos.value;
		if(document.forms[0].flagYN.value=='true' || document.forms[0].flagYN.value==true)
		{
			var from=eval(document.forms[0].from_disp.value)-2;
			var to=eval(document.forms[0].to_disp.value)-3;
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
			if(eval(cur_pos)>eval(to))
			{
				var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
			}
		}
		if(document.forms[0].flagYN.value==false || document.forms[0].flagYN.value=="false")
		{
			//alert("false");
			var from=eval(document.forms[0].from_disp.value)-2;
			var to=eval(document.forms[0].to_disp.value)-2;
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
			if(eval(cur_pos)>eval(to))
			{
				var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
			}
			//**ends here
			if(eval(cur_pos)<=to && eval(cur_pos)>=from)
			{
				from=eval(from)-1;
				url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=true';
			}
			//code for chaecking when the from become < 0
			if(eval(from)<0)
			{
				if(eval(cur_pos)>=0 && eval(cur_pos)<=2)//spacial case
				{
					from=0;
					to=2;
					url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=true';
				}
				else
				{
					from=0;
					to=1;
					url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
					if(eval(cur_pos)>eval(to))
					{
						url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
					}
			//**ends here
				}
			}
		}
		self.location.href="../../eCA/jsp/PatListByRelnProvLocn.jsp?"+url;
	}

	function showNextLocn(){
		var qryStr   =  parent.RelnResultPatClass.document.forms[0].queryString.value;
		qryStr=qryStr.substring(0,qryStr.length-10);
	
		var pat_type =  document.forms[0].pat_type.value;
		var cur_pos=document.forms[0].currentPos.value;
		if(document.forms[0].flagYN.value=='true' || document.forms[0].flagYN.value==true)
		{
			var from=eval(document.forms[0].from_disp.value)+3;
			var to=eval(document.forms[0].to_disp.value)+2;
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
			if(eval(cur_pos)>eval(to))
			{
				var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
			}
			//**ends here
		}
		if(document.forms[0].flagYN.value==false || document.forms[0].flagYN.value=="false")
		{
			var from=eval(document.forms[0].from_disp.value)+2;
			var to=eval(document.forms[0].to_disp.value)+2;
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
			if(eval(cur_pos)>eval(to))
			{
				var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
			}
			//**ends here
			if(eval(cur_pos)<=to && eval(cur_pos)>=from)
			{
				to=eval(to)+1;
				url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=true';
			}

		}
		//var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to;
		//alert("url :"+url);
		self.location.href="../../eCA/jsp/PatListByRelnProvLocn.jsp?"+url;

	}
	function fillUrl()
	{
//		if(parent.RelnResultPatClass.document.forms[0].url!=null)
//		document.forms[0].url.value=parent.RelnResultPatClass.document.forms[0].url.value;
		document.forms[0].url.value=top.content.workAreaFrame.PatResultFr.RelnResultPatClass.document.forms[0].url.value;
	}

//function for PatListByRelnProvTitle.jsp starts
var reOrder='';
var scrollLeft='';
function callForOrderByRel(obj)
{
			//var qryStr = top.content.workAreaFrame.PatResultFr.RelnResultLocation.document.forms[0].url.value;
			var qryStr = top.content.workAreaFrame.PatResultFr.RelnResultLocation.document.forms[0];
			scrollValue = document.body.scrollLeft;
			//alert(qryStr);

			//var qryStr = parent.MedServResultLocation.document.forms[0] ; //formLocnResultLocation
			
			if(qryStr == null)
            {
               if(top.content.workAreaFrame.PatResultFr.RelnResultLocation.formLocnResultLocation)
				{ qryStr = document.forms[0].url.value;}
			   else
				{ qryStr = top.content.workAreaFrame.PatCriteriaFr.PatCriteriaFrm.url.value;}
				
            }
            else
            {
                
				qryStr = qryStr.url.value;
            }


			var url=qryStr+'&orderBy='+obj+'&reOrder='+reOrder+'&leftScrolling='+scrollValue;
			top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatListByRelnProvResult.jsp?'+url;
}


function navigate(start,end)
{

	if(document.forms[0].prev != null)
	document.forms[0].prev.disabled='true';

	if(document.forms[0].nex != null)
	document.forms[0].nex.disabled='true';

	top.content.workAreaFrame.PatResultFr.LocnResult.document.getElementById("from").value=start ;
	top.content.workAreaFrame.PatResultFr.LocnResult.document.getElementById("to").value=end ;

	var flag1=false;


	for(i=0;i<top.content.workAreaFrame.PatResultFr.LocnResult.document.anchors.length;i++)
	{
			if(top.content.workAreaFrame.PatResultFr.LocnResult.document.anchors(i).style.color=='pink' || top.content.workAreaFrame.PatResultFr.LocnResult.document.anchors(i).style.color=='yellow')
			{
				flag1=true;
				break;
			}
	}
		if(!flag1)
		{
			//alert('into');
			top.content.workAreaFrame.PatCriteriaFr.document.getElementById("order_by").value="";
			top.content.workAreaFrame.PatCriteriaFr.document.getElementById("re_order").value="";
			top.content.workAreaFrame.PatCriteriaFr.document.getElementById("anchor_id").value="";
		}
		var orderBy=top.content.workAreaFrame.PatCriteriaFr.document.getElementById("order_by").value;
		var reOrder=top.content.workAreaFrame.PatCriteriaFr.document.getElementById("re_order").value;
		var anchorID=top.content.workAreaFrame.PatCriteriaFr.document.getElementById("anchor_id").value;
		//----------ends here--
//		alert(top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].form.value);
	if(top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].form.value == "Location")
	{

		top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].action = '../jsp/PatListByLocationResult.jsp?orderBy='+orderBy+'&reOrder='+reOrder+'&anchorID='+anchorID;
	}
	//----------------
	if(top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].form.value == "MedService")
	{

		top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].action = '../jsp/PatListByMedServiceResult.jsp?orderBy='+orderBy+'&reOrder='+reOrder+'&anchorID='+anchorID;
	}


	if(top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].form.value == "Relation")
	{
		top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].action = '../jsp/PatListByRelnProvResult.jsp?orderBy='+orderBy+'&reOrder='+reOrder+'&anchorID='+anchorID;
	}

	top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].method = 'post'
    top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].target = ''
    top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].submit() ; 

}

// shaiju test functions for table sort

function setDataType(cValue)
  {
    // THIS FUNCTION CONVERTS DATES AND NUMBERS FOR PROPER ARRAY
    // SORTING WHEN IN THE SORT FUNCTION
    var isDate = new Date(cValue);
    if (isDate == "NaN")
      {
        if (isNaN(cValue))
          {
            // THE VALUE IS A STRING, MAKE ALL CHARACTERS IN
            // STRING UPPER CASE TO ASSURE PROPER A-Z SORT
            cValue = cValue.toUpperCase();
            return cValue;
          }
        else
          {
            // VALUE IS A NUMBER, TO PREVENT STRING SORTING OF A NUMBER
            // ADD AN ADDITIONAL DIGIT THAT IS THE + TO THE LENGTH OF
            // THE NUMBER WHEN IT IS A STRING
            var myNum;
            myNum = String.fromCharCode(48 + cValue.length) + cValue;
            return myNum;
          }
        }
  else
      {
        // VALUE TO SORT IS A DATE, REMOVE ALL OF THE PUNCTUATION AND
        // AND RETURN THE STRING NUMBER
        //BUG - STRING AND NOT NUMERICAL SORT .....
        // ( 1 - 10 - 11 - 2 - 3 - 4 - 41 - 5  etc.)
        var myDate = new String();
        myDate = isDate.getFullYear() + " " ;
        myDate = myDate + isDate.getMonth() + " ";
        myDate = myDate + isDate.getDate(); + " ";
        myDate = myDate + isDate.getHours(); + " ";
        myDate = myDate + isDate.getMinutes(); + " ";
        myDate = myDate + isDate.getSeconds();
        //myDate = String.fromCharCode(48 + myDate.length) + myDate;
        return myDate ;
      }
  }
function sortTable(col, tableToSort)
  {	
  //alert("col.."+col+"...tableToSort.."+tableToSort.name);
    var iCurCell = col + tableToSort.cols;
	//alert("iCurCell.."+iCurCell);
    var totalRows = tableToSort.rows.length;
    var bSort = 0;
    var colArray = new Array();
    var oldIndex = new Array();
    var indexArray = new Array();
    var bArray = new Array();
    var newRow;
    var newCell;
    var i;
    var c;
    var j;
    // ** POPULATE THE ARRAY colArray WITH CONTENTS OF THE COLUMN SELECTED
    for (i=1; i <tableToSort.rows.length; i++)
      {
        colArray[i - 1] = setDataType(tableToSort.cells(iCurCell).innerText);
        iCurCell = iCurCell + tableToSort.cols;
      }
	  //alert("colArray.."+colArray);
    // ** COPY ARRAY FOR COMPARISON AFTER SORT
    for (i=0; i < colArray.length; i++)
      {
        bArray[i] = colArray[i];
      }
    // ** SORT THE COLUMN ITEMS
    //alert ( colArray );
    colArray.sort();
    //alert ( colArray );
    for (i=0; i < colArray.length; i++)
      { // LOOP THROUGH THE NEW SORTED ARRAY
        indexArray[i] = (i+1);
        for(j=0; j < bArray.length; j++)
          { // LOOP THROUGH THE OLD ARRAY
            if (colArray[i] == bArray[j])
              {  // WHEN THE ITEM IN THE OLD AND NEW MATCH, PLACE THE
                // CURRENT ROW NUMBER IN THE PROPER POSITION IN THE
                // NEW ORDER ARRAY SO ROWS CAN BE MOVED ....
                // MAKE SURE CURRENT ROW NUMBER IS NOT ALREADY IN THE
                // NEW ORDER ARRAY
                for (c=0; c<i; c++)
                  {
                    if ( oldIndex[c] == (j+1) )
                    {
                      bSort = 1;
                    }
                      }
                      if (bSort == 0)
                        {
                          oldIndex[i] = (j+1);
                        }
                          bSort = 0;
                        }
          }
    }
  // ** SORTING COMPLETE, ADD NEW ROWS TO BASE OF TABLE ....
  for (i=0; i<oldIndex.length; i++)
    {
      newRow = tableToSort.insertRow();
      for (c=0; c<tableToSort.cols; c++)
        {
          newCell = newRow.insertCell();
          newCell.innerHTML = tableToSort.rows[oldIndex[i]].cells[c].innerHTML;
        }
      }
  //MOVE NEW ROWS TO TOP OF TABLE ....
  for (i=1; i<totalRows; i++)
    {
      tableToSort.moveRow((tableToSort.rows.length -1),1);
    }
  //DELETE THE OLD ROWS FROM THE BOTTOM OF THE TABLE ....
  for (i=1; i<totalRows; i++)
    {
      tableToSort.deleteRow();
    }
  }



//test fn ends

