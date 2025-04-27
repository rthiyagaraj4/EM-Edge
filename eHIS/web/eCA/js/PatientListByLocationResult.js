/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           		created
04/1/2012     	101            		Chowminya      		Incident No: IN030239 - <Search Patient by location, to restore missing locations>
30/01/2012		IN030566			Ramesh G			When we place another Order of the same category the Pin No. is prompted again 
														even if the Patient chart is not closed.
18/6/2012		IN032928			Dinesh T			Added the database hit code to check the status which 
														is present in the Manage patient queue function of OP
12/12/2012		IN028236			Vijayakumar k		Tab->Enter does not work in Clinican Access->By Location screen. 
														In 5x, clinicians could choose next patient from the list of patients by tab-enter. But now, though the next patient gets highlighted when tab-ed, patient chart for that patient does not open up on Enter

22/01/2013		IN030532			Karthi L			CA Patient List to have option to call a specific patient queue no
27/02/2013 		IN038171			vijayakumar k 		TP ID: 281807 Unable to Copy & paste from 3 tire to any text
13/01/2014		MV_13012014			Vijayakumar K		patClick_ has been moved from PatListByLocationResult.jsp
------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     	Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
21/04/2014		IN048617			Karthi L											This is an issue for integration between Queue Management System and generating queue number in CA.
09/08/2016		IN064836		Krishna Gowtham			09/08/2017		Ramesh G		ML-MMOH-CRF-0566.1
08/07/2020     IN072994          Chandrashekar raju    	08/07/2020			Ramesh G              Modified for MMS-DM-CRF-0170.1
08/07/2020     IN072184          Chandrashekar raju     	08/07/2020       Ramesh G      Modified for MMS-DM-CRF-0157.2	
 18/10/2023     32902             Krishna Pranay    	     19/10/2023      Ramesh G      MMS-DM-CRF-0210	

---------------------------------------------------------------------------------------------------------------
*/  
var babyDetails = new Array();
var motherName = new Array();
episodeIdArr = new Array();
patient_class = new Array();
scan_count_required_yn=new Array();//Added for IN072994
alert_required_yn= new Array();//Added for IN072994
remarks_required_yn=new Array();//Added for IN072994
var scrollValue=0;

/*var babyDetails = new Array();
	var motherName = new Array();

	patIdArr = new Array();
	visitIdArr = new Array();
	episodeIdArr = new Array();
	locnCodeArr = new Array();
	locnType = new Array();
	episodeTypeArr = new Array();
	pLineArr = new Array();
	bed_no = new Array();
	room_no = new Array()
	discharge_date = new Array()
	visit_adm_date = new Array()
	episode_status = new Array()
	pat_sex = new Array()
	pat_dob = new Array();
	pat_age = new Array();
	patient_class = new Array();*/

function clearLayer()
{
	hidePopUp();
}        
function showMotherLinks(episodeid,obj,babyCount)
{
	var babyLegend = "";
	if(babyCount > 1)
	babyLegend = "Babies";
	else
	babyLegend = "Baby";
	var tabdata = "<html><head><link rel='stylesheet' type='text/css' 		href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><table cellpadding=0 cellspacing=0 border=1 bordercolor=BLACK><tr><th><font size=1><b>"+babyLegend+" of "+motherName[episodeid]+"</b></font></th></tr><tr><td><table cellpadding=0 cellspacing=0 border=1><tr><td class=SENPAT nowrap>Patient ID</td><td class=SENPAT nowrap>Name</td><td class=SENPAT nowrap>Sex</td><td class=SENPAT nowrap>Date of Birth</td><td class=SENPAT nowrap>Time</td><td class=SENPAT nowrap>Weight</td><td class=SENPAT nowrap>Length</td><td class=SENPAT nowrap>Circumference</td><td class=SENPAT nowrap>Apgar Score</td></tr>";
	if(babyDetails[episodeid] != '')
	{
		tabdata +=babyDetails[episodeid]+"</td></tr></table></table></body></html>";
		if(document.getElementById('motherLink')){
		document.getElementById('motherLink').innerHTML = tabdata;
		document.getElementById('motherLink').style.top  = obj.offsetTop;
		document.getElementById('motherLink').style.left  = obj.offsetLeft+50 ;
		document.getElementById('motherLink').style.visibility='visible' ;
		}
		else
		{
			parent.document.getElementById('motherLink').innerHTML = tabdata;
			parent.document.getElementById('motherLink').style.top  = obj.offsetTop;
			parent.document.getElementById('motherLink').style.left  = obj.offsetLeft+50 ;
			parent.document.getElementById('motherLink').style.visibility='visible' ;
		}
	}
	else
	{
		hidePopUp();
	}
}

function hidePopUp()
{
	if(document.getElementById('motherLink'))
	document.getElementById('motherLink').style.visibility='hidden' ;
	else
		parent.document.getElementById('motherLink').style.visibility='hidden' ;
}

function patClick(ind)
{
	self.document.PatCriteriaFrm.encounter_id.value = episodeIdArr[ind];		
	self.document.PatCriteriaFrm.patient_class.value = patient_class[ind];		
	/*alert(self.document.PatCriteriaFrm.encounter_id.value);
	alert(self.document.PatCriteriaFrm.patient_class.value);*/
	self.document.PatCriteriaFrm.submit();
}
//[IN030566] Starts
function patClick_new(ind,pat_id,encId)//Added encId parameter
{
     //32902 start
    var restPatientYN =document.getElementById("restPatientYN"+ind).value;
    var accessRightsViewPatient =document.getElementById("accessRightsViewPatient").value;  
    if(pat_id !=="" && restPatientYN =="Y" && accessRightsViewPatient==0){
  	restrictOpenVIPPat(pat_id,restPatientYN,accessRightsViewPatient);
       return;
     } 
    //32902 end

  //Adding start for IN072184
	var retval="";
	var entry_type ="";
	//Adding for IN072994
	var temp_scan_count_required_yn=scan_count_required_yn[ind];
	var temp_alert_required_yn=alert_required_yn[ind]; 
	var temp_remarks_required_yn=remarks_required_yn[ind];
	var speciality = "";
	if(self.document.PatCriteriaFrm.speciality != undefined){
		
		speciality = self.document.PatCriteriaFrm.speciality.value;
	}
	else
	{
		
		speciality = "";
//Adding end for MMS-DM-CRF--0170.1
	if(temp_scan_count_required_yn =='Y'){//Added if Condition for MMS-DM-CRF--0170.1
         if(pat_id !="" && self.document.PatCriteriaFrm.bar_code_site_yn.value=='Y' && (self.document.PatCriteriaFrm.bar_code_scaned_YN.value=='N' || self.document.PatCriteriaFrm.bar_code_scaned_YN.value=="") && temp_alert_required_yn == 'Y'){
	          retval=callManualScanRemarks(pat_id,encId,temp_remarks_required_yn,patient_class[ind],speciality);
         }else if(pat_id != "" && self.document.PatCriteriaFrm.bar_code_site_yn.value=='Y' && (self.document.PatCriteriaFrm.bar_code_scaned_YN.value=='Y'|| (temp_scan_count_required_yn == 'Y' && temp_alert_required_yn =='N' ))){
			 
			 if(self.document.PatCriteriaFrm.bar_code_scaned_YN.value=='Y' && temp_scan_count_required_yn == 'Y')//Added for IN072994
				    entry_type = "S";//Added for IN072994
			 else{
				 
				    entry_type = "M";//Added for IN072994
	          retval=scanBarcodeCount(pat_id,encId,patient_class[ind],entry_type,speciality);
			 }
         }
	}
	}
	//Adding end for IN072184
	if(retval != undefined){//Added only if condition for IN072184
	self.document.PatCriteriaFrm.encounter_id.value = episodeIdArr[ind];		
	self.document.PatCriteriaFrm.patient_class.value = patient_class[ind];	
	//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;		
	var xmlDoc = ""; 
	//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	var	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/EnterOrderValidate.jsp?patient_id="+pat_id+"&p_encounter_id="+encId, false ) ;//IN032928
	xmlHttp.send( xmlDoc ) ;

	if(trimString(xmlHttp.responseText)=="true")
	{
		self.document.PatCriteriaFrm.submit();
	}	
	else if(trimString(xmlHttp.responseText)=="false")//IN032928
	{
		alert(getMessage("VISIT_CANCELLED","CA"));
	}//IN032928
    }
  }
//}
//[IN030566] Ends
function viewReferral(ref)
{
	var retVal = 	new String();
	/*var dialogHeight= "42" ;
	var dialogTop = "100" ;
	var dialogWidth	= "64" ;*/
	var dialogHeight= "85vh" ;
	var dialogWidth	= "75vw" ;
	var dialogTop	= "0vh";
	
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var retVal = top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref,arguments,features);
}

/*function moveFrame(objVal)
{
	var temp = document.body.scrollLeft;
	scrollValue = temp;
	var obj=" ";

	if(eval(objVal+'.PatResultFr.LocnResultTitle.location.href.indexOf(".jsp")') != -1) 
	//if(eval(objVal+".PatResultFr.LocnResultTitle.location.href.indexOf(".jsp")") != -1)
	{
		obj=eval(objVal+".PatResultFr.LocnResultTitle.document.body.scrollLeft");
		obj = temp;
	}
}*/

function moveFrame()
{
	var temp = document.body.scrollLeft;
	scrollValue = temp;

	if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.location.href.indexOf(".jsp") != -1)
	{
		top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.body.scrollLeft = temp;
	}
}



//alert('111'+scrollValue);
//------------------------new functions for fixed frame sorting-------------

var reOrder='';
var anchorID='';
function callForOrderBy(obj)
{
	
	var qryStr = top.content.workAreaFrame.PatResultFr.LocnResultLocation.document.forms[0].url.value;

	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].order_by.value=obj;
	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].re_order.value=reOrder;
	top.content.workAreaFrame.PatCriteriaFr.document.forms[0].anchor_id.value=anchorID;	

	//deleting the old locn_type
	val=qryStr.indexOf("&locn_type=");
	len=qryStr.length;
	sr1=qryStr.substring(0,val+1);
	sr2=qryStr.substring(val+11,len);
	qryStr=sr1+sr2;

	var locType=top.content.workAreaFrame.PatCriteriaFr.document.forms[0].locn_type.value;

	var url = qryStr + '&locn_type=' + locType + '&orderBy=' + obj + '&reOrder=' + reOrder + '&anchorID=' + anchorID + '&leftScrolling=' + scrollValue;

	top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatientListByLocationResult.jsp?'+url;
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
		document.anchors[i].style.color='white';
	}
	object.style.color='pink';
	
}

/*function storeValues(locn_type,objVal)
{	
	var obj=" ";
	if(locn_type != 'null'){		
		obj=eval(objVal+".PatCriteriaFr.document.forms[0].locn_type.value");
		obj=locn_type;
		//top.content.workAreaFrame.PatCriteriaFr.document.forms[0].locn_type.value=locn_type;
	}
}*/

function storeValues(locn_type)
{
	if(locn_type != 'null')
		top.content.workAreaFrame.PatCriteriaFr.document.forms[0].locn_type.value=locn_type;
}

  var reOrder='';
     var scrollLeft=0;

  function callForOrderByLoc(obj){            
			
			var qryStr = top.content.workAreaFrame.PatResultFr.LocnResultLocation.document.forms[0];
			scrollValue = document.body.scrollLeft;	
			top.content.workAreaFrame.PatCriteriaFr.document.forms[0].order_by.value=obj;
			top.content.workAreaFrame.PatCriteriaFr.document.forms[0].re_order.value=reOrder;
			top.content.workAreaFrame.PatCriteriaFr.document.forms[0].anchor_id.value=anchorID;
			
			if(qryStr == null)
            {
               if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.formLocnResultLocation)
			    {				  
				  
				  
				   qryStr = document.forms[0].url.value;
			   }
			   else{
				   
				    				   
                qryStr = top.content.workAreaFrame.PatCriteriaFr.PatCriteriaFrm.url.value;	
			   }
				
            }
            else
            {	
				 
				  qryStr = qryStr.url.value;
            }				
          
			var url=qryStr+'&orderBy='+obj+'&reOrder='+reOrder+'&anchorID=' + anchorID +'&leftScrolling='+scrollValue;           
		 
		   top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatListByLocationResult.jsp?'+url;
        }


	var currClass = '';
	var url='';
    /*function callOnMouseOver(obj)
	{
                            currClass = obj.className ;
                             if("H" == "H")
                                obj.className = 'FIRSTSELECTED';
                             else
                                obj.className = 'FIRSTNORMAL';
                        }

 function callOnMouseOut(obj)
{
                            obj.className = currClass;
 }*/
  function callOnMouseOver(obj){
		if(obj.className != "WHITE"){
			currClass = obj.className ;
			 if("H" == "H") 	obj.className = 'FIRSTSELECTED';
			 else	obj.className = 'FIRSTNORMAL';
		 }
	  }

	function callOnMouseOut(obj){
		if(obj.className != "WHITE"){
			obj.className = currClass;
		}
	}



     function display(from)
	{
						cellref = document.getElementById("tab").rows[0].cells
                            if("H" == "V")
                                cellref = document.getElementById("tab").rows

                            for(i=0; i<cellref .length; i++){
                                if("H" == "H")
                                    cellref[i].className = 'FIRSTNORMAL'
                                else
                                cellref[i].cells[0].className = 'SECONDNORMAL'

							 }
                            if("H" == "H")
							{
                                from.className = "FIRSTSELECTED"
                                currClass ="FIRSTSELECTED";
                              }
                             else
							 {
                                from.className = "FIRSTNORMAL";
                                currClass ="FIRSTNORMAL";
                              }
	}



	 function displayLoc(from){
		if(from.className != "WHITE"){
			cellref = document.getElementById("locnTab").rows[0].cells
			if("H" == "V")
				cellref = document.getElementById("locnTab").rows

			for(i=0; i<cellref .length; i++){
				if("H" == "H"){
					if(cellref[i].className != "WHITE"){
						cellref[i].className = 'FIRSTNORMAL';
					}
				}else{
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
			  }else{
				  if(from.className != "WHITE"){
					from.className = "FIRSTNORMAL";
					currClass ="FIRSTNORMAL";
				  }
				}
		}
   }

   
	function showPrevLocn(){ //Modified --[IN030239] - Start
		var qryStr = top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].queryString.value;
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
			var from=eval(document.forms[0].from_disp.value)-2;
			var to=eval(document.forms[0].to_disp.value)-2;
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
			if(eval(cur_pos)>eval(to))
			{
				var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
			}

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
					//**checking for whether to display label on right side or not
					if(eval(cur_pos)>eval(to))
					{
						url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
					}
					//**ends here
				}
			}
		}
		top.content.workAreaFrame.PatResultFr.LocnResultLocation.location.href="../../eCA/jsp/PatListByLocationPatLocn.jsp?"+url;
	}

	function showNextLocn()
	{
		var pat_type =  document.forms[0].pat_type.value;
		var cur_pos=document.forms[0].currentPos.value;
		var qryStr   =  top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].queryString.value;
		qryStr=qryStr.substring(0,qryStr.length-10);
		//alert("qryStr:   "+qryStr);
		if(document.forms[0].flagYN.value=='true' || document.forms[0].flagYN.value==true)
		{
			//alert('true');
			var from=eval(document.forms[0].from_disp.value)+3;
			var to=eval(document.forms[0].to_disp.value)+2;
			var url = qryStr+'&pat_type='+pat_type+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';

			//**checking for whether to display label on right side or not
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

			//**checking for whether to display label on right side or not
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
		//Modified --[IN030239] - End
		}
		top.content.workAreaFrame.PatResultFr.LocnResultLocation.location.href="../../eCA/jsp/PatListByLocationPatLocn.jsp?"+url;

	}
	
	function fillUrl(val){
		if (val == "Summary")
			document.forms[0].url.value=parent.parent.PatResultFr.LocnResultPatClass.document.forms[0].url.value;
		else
			document.forms[0].url.value=top.content.workAreaFrame.PatResultFr.LocnResultPatClass.document.forms[0].url.value;
	}

/*function alignHeading(objVal)
			{				
				var obj = "";
				if(eval(objVal+".PatResultFr.LocnResultTitle.document.getElementById("TitleTab")") != null) 
				{
					obj = eval(objVal+".PatResultFr.LocnResultTitle.document.getElementById("TitleTab").width");					
					obj =	eval(document.getElementById("PatCriteriaTbl").offsetWidth);
					for (j=0; j < document.getElementById("PatCriteriaTbl").rows(0).cells.length; j++) 
					{
						var wid=eval(document.getElementById("PatCriteriaTbl").rows(0).cells(j).offsetWidth);
						if(eval(objVal+".PatResultFr.LocnResultTitle.document.getElementById("TitleTab").rows(0).cells(j)") != null)
						{
							obj = eval(objVal+".PatResultFr.LocnResultTitle.document.getElementById("TitleTab").rows(0).cells(j).width")
							obj=wid;
						}
					}
				}
			}*/
function alignHeading()
{
	
	if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById("TitleTab") != null) 
	{
		top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById("TitleTab").width =	eval(document.getElementById("PatCriteriaTbl").offsetWidth);
		
		for (j=0; j < document.getElementById("PatCriteriaTbl").rows[0].cells.length; j++) 
		{
			
			var wid=eval(document.getElementById("PatCriteriaTbl").rows[0].cells[j].offsetWidth);
			if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById("TitleTab").rows[0].cells[j] != null)
			{
				top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById("TitleTab").rows[0].cells[j].width=wid;
				
			}
		}
	}
	if(top.content.workAreaFrame.PatResultFr.LocnResultLocation.document.forms[0] != null) 
	{
top.content.workAreaFrame.PatResultFr.LocnResultLocation.document.forms[0].url.value = top.content.workAreaFrame.PatCriteriaFr.document.forms[0].url.value;

	}
	

}

//shaiju
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
			if(top.content.workAreaFrame.PatResultFr.LocnResult.document.anchors[i].style.color=='pink' || top.content.workAreaFrame.PatResultFr.LocnResult.document.anchors[i].style.color=='yellow')
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
		var qms_locn_code = top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].P_locn_code.value; // added for CRF 192 IN030532

		
		top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].action = '../jsp/PatListByLocationResult.jsp?orderBy='+orderBy+'&reOrder='+reOrder+'&anchorID='+anchorID+ '&locn_code='+qms_locn_code;
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

async function getConfirm(i)
{
	var patient_id = eval("self.document.PatCriteriaFrm.patient_id"+i+".value");
	var referral_id = eval("self.document.PatCriteriaFrm.referral_id"+i+".value");
	var location_code = eval("self.document.PatCriteriaFrm.location_code"+i+".value");
	var practitioner_Id = eval("self.document.PatCriteriaFrm.practitioner_Id"+i+".value");
	var sex = eval("self.document.PatCriteriaFrm.sex"+i+".value");
	var function_id = self.document.PatCriteriaFrm.function_id.value;
	
   //32902 start
    var restPatientYN =document.getElementById("restPatientYN"+i).value;
   var accessRightsViewPatient =document.getElementById("accessRightsViewPatient").value;  
    if(patient_id !=="" && restPatientYN =="Y" && accessRightsViewPatient==0){
  	restrictOpenVIPPat(patient_id,restPatientYN,accessRightsViewPatient);
       return;
     } 
    //32902 end
   
	var encounterId = episodeIdArr[i];
	var dialogTop		= "72";
	var dialogHeight	= "41";
	var dialogWidth		= "65";
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "";

	var retVal =await window.showModalDialog("../../eIP/jsp/PaintReferralPatientDetails.jsp?function_id="+function_id+"&encounterId="+encounterId+"&patientid="+patient_id+"&called_from=CA&call_function=BedSideReferral&referralID="+referral_id,arguments,features);
	
	if(retVal == 'Success')
		document.location.reload();
}
//IN038171 starts
//IN028236 starts
/*
function activateEnterKeyCA(){
var whichCode = event.keyCode;
var e = event.target.tagName;
if (whichCode == 13 && e != "TEXTAREA") 
	{		
		event.cancelBubble = false;
		event.returnValue = true;
		return true;
	}else if(whichCode != 9){
		event.cancelBubble = true;
		event.returnValue = false;
		return false;
	}
}*/
//IN038171 ends
// added for CRF-025 - IN030466
function researchPatient(patient_id){
		var queryString = "<%=request.getQueryString()%>";//document.refForm.queryString.value;
		var queryString = "";
		var dialogHeight= "37.5" ;
		var dialogWidth	= "50" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes;  status:" + status;
		window.showModalDialog("../../eCA/jsp/ResearchPatient.jsp?patient_id="+patient_id+queryString,arguments,features);
		//return false;
}
//IN028236 ends
// added below function for CRF 172 IN030532 - Start
function callPatient(patient_id,EncounterId,queue_num){


			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			 
			var param="&callfunc=callTicket&queue_num="+queue_num+"&patient_id="+patient_id+"&encounter_id="+EncounterId;

			var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);
			alert(responseText); //added for IN048617
			setTimeout('location.reload(true);',1000)
}
// added for IN048617 - Start
function callNextPatient(){ 

	
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			 
			var param="&callfunc=callNextTicket";//Modified for the SCF - ML-Bru-SCF-1074
//			var param="&callfunc=callNextTicket&room_num="+room_num;
	
			var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);
			//Added for the SCF - ML-Bru-SCF-1074
			if(responseText!=''){
				alert(responseText)
			}
			setTimeout('callSamepage()',1000)
}
// added for IN048617 - End
function callSamepage()
{
	// IN048617 - Start
	//var reload = parent.frames[0].document.location.href;
	//reload.refresh.click(); 	
	parent.frames[0].location.reload;
	// IN048617 - End
}
//END
//MV_13012014 starts
function patClick_(id){		
	for(var i=0;i<episodeIdArr.length;i++){
		if(i==id){
			if(document.getElementById('rta'+i)!=null)
				document.getElementById('rta'+i).className='gridDataSelectNew';
			if(document.getElementById('rtb'+i)!=null)
				document.getElementById('rtb'+i).className='gridDataSelectNew';
			if(document.getElementById('rtc'+i)!=null)
				document.getElementById('rtc'+i).className='gridDataSelectNew';
			if(document.getElementById('rtd'+i)!=null)
				document.getElementById('rtd'+i).className='gridDataSelectNew';
			if(document.getElementById('rte'+i)!=null)
				document.getElementById('rte'+i).className='gridDataSelectNew';
			if(document.getElementById('rtf'+i)!=null)
				document.getElementById('rtf'+i).className='gridDataSelectNew';
			if(document.getElementById('rtg'+i)!=null)
				document.getElementById('rtg'+i).className='gridDataSelectNew';
			if(document.getElementById('rth'+i)!=null)
				document.getElementById('rth'+i).className='gridDataSelectNew';
			if(document.getElementById('rti'+i)!=null)
				document.getElementById('rti'+i).className='gridDataSelectNew';
			if(document.getElementById('rtj'+i)!=null)
				document.getElementById('rtj'+i).className='gridDataSelectNew';
			if(document.getElementById('rtk'+i)!=null)
				document.getElementById('rtk'+i).className='gridDataSelectNew';
			if(document.getElementById('rtl'+i)!=null)
				document.getElementById('rtl'+i).className='gridDataSelectNew';
			if(document.getElementById('rtm'+i)!=null)
				document.getElementById('rtm'+i).className='gridDataSelectNew';
			if(document.getElementById('rtn'+i)!=null)
				document.getElementById('rtn'+i).className='gridDataSelectNew';
			if(document.getElementById('rto'+i)!=null)
				document.getElementById('rto'+i).className='gridDataSelectNew';
			if(document.getElementById('rtp'+i)!=null)
					document.getElementById('rtp'+i).className='gridDataSelectNew';
			if(document.getElementById('rtq'+i)!=null)
				document.getElementById('rtq'+i).className='gridDataSelectNew';
			if(document.getElementById('rtr'+i)!=null)			
				document.getElementById('rtr'+i).className='gridDataSelectNew';
			
		}else{
			if(document.getElementById('rta'+i)!=null)
				document.getElementById('rta'+i).className='gridData';
			if(document.getElementById('rtb'+i)!=null)
				document.getElementById('rtb'+i).className='gridData';
			if(document.getElementById('rtc'+i)!=null)
				document.getElementById('rtc'+i).className='gridData';
			if(document.getElementById('rtd'+i)!=null)
				document.getElementById('rtd'+i).className='gridData';
			if(document.getElementById('rte'+i)!=null)
				document.getElementById('rte'+i).className='gridData';
			if(document.getElementById('rtf'+i)!=null)
				document.getElementById('rtf'+i).className='gridData';
			if(document.getElementById('rtg'+i)!=null)
				document.getElementById('rtg'+i).className='gridData';
			if(document.getElementById('rth'+i)!=null)
				document.getElementById('rth'+i).className='gridData';
			if(document.getElementById('rti'+i)!=null)
				document.getElementById('rti'+i).className='gridData';
			if(document.getElementById('rtj'+i)!=null)
				document.getElementById('rtj'+i).className='gridData';
			if(document.getElementById('rtk'+i)!=null)
				document.getElementById('rtk'+i).className='gridData';
			if(document.getElementById('rtl'+i)!=null)
				document.getElementById('rtl'+i).className='gridData';
			if(document.getElementById('rtm'+i)!=null)
				document.getElementById('rtm'+i).className='gridData';
			if(document.getElementById('rtn'+i)!=null)
				document.getElementById('rtn'+i).className='gridData';
			if(document.getElementById('rto'+i)!=null)
				document.getElementById('rto'+i).className='gridData';
			if(document.getElementById('rtp'+i)!=null)
				document.getElementById('rtp'+i).className='gridData';
			if(document.getElementById('rtq'+i)!=null)
				document.getElementById('rtq'+i).className='gridData';
			if(document.getElementById('rtr'+i)!=null)			
				document.getElementById('rtr'+i).className='gridData';
				
		}
	}
}
//MV_13012014 ends
//IN064836 start
async function ReferralRegAuditTrial(i){                               
	var retVal = new String();
	var referral_id = eval("self.document.PatCriteriaFrm.referral_id"+i+".value");
	var dialogHeight= "30" ;                                                 
	
	var dialogWidth              = "70" ;

	var status = "no";                                             
	var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status; 
	retVal =await window.showModalDialog("../../eIP/jsp/ReferralRegAuditTrialFrame.jsp?referral_id="+referral_id,arguments,features);
}
//IN064836 ends
//Adding start for IN072184
async function callManualScanRemarks(patient_id,encounter_id,remarks_mandetory_yn,patient_class,speciality){//remarks_mandetory_yn,patient_class,speciality Added for IN072994
	var retVal = new String();
	var dialogHeight= "17" ;                                                 
	
	var dialogWidth              = "40" ;

	var status = "no";                                             
	var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status; 
	retVal =await window.showModalDialog("../../eOR/jsp/BarCodeManualEntryReason.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&remarks_mandetory_yn="+remarks_mandetory_yn+"&patient_class="+patient_class+"&speciality="+speciality+"&module_id=CA&menu_id=PATIENT_LIST_BY_LOCATION&entry_type=M",arguments,features);
		return retVal;
}

function scanBarcodeCount(patient_id,encounter_id,patient_class,entry_type,speciality){//remarks_mandetory_yn,patient_class,speciality Added for IN072994
	var retVal = "";
	var menu_id ="PATIENT_LIST_BY_LOCATION";
	var module_id ="CA";
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " patient_id=\""+patient_id+"\"";
		xmlStr += " encounter_id=\""+encounter_id+"\"";
		xmlStr += " menu_id=\""+menu_id+"\"";
		xmlStr += " module_id=\""+module_id+"\"";
        xmlStr += " entry_type=\""+entry_type+"\"";
        xmlStr += " patient_class=\""+patient_class+"\"";
        xmlStr += " speciality=\""+speciality+"\"";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open("POST","../../eOR/jsp/BarCodeManualEntryReasonSave.jsp?",false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText;
		return true;
}

//Adding end for IN072184

