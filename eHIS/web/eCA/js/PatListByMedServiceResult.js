/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created

30/01/2012	IN030566		Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.
6/11/2023     32902             Krishna Pranay    	     7/11/2023      Ramesh G      MMS-DM-CRF-0210	

---------------------------------------------------------------------------------------------------------------
*/

var babyDetails = new Array();
var motherName = new Array();
episodeIdArr = new Array();
patient_class = new Array();
var scrollValue=0;
patCount=0;

function clearLayer()
{
	hidePopUp();
}

function showMotherLinks(episodeid,obj)
{
	var tabdata = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>"+
							"<body onKeyDown='lockKey()'><table cellpadding=3 width='100%' align='center' cellspacing=0 border=1 bordercolor=BLACK>"+
							"<tr><td class='columnheader'><font size=1><b><fmt:message key='eCA.Babiesof.label' bundle='${ca_labels}'/>"+motherName[episodeid]+"</b></font></td></tr>"+
							"<tr><td><table cellpadding=3 cellspacing=0 border=1 width='100%' align='center'>"+
							"<tr><td class=SENPAT nowrap><fmt:message key='Common.patientId.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.name.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.gender.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.DateofBirth.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.time.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.weight.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.length.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.Circumference.label' bundle='${common_labels}'/></td><td class=SENPAT nowrap><fmt:message key='Common.Apgarscore.label' bundle='${common_labels}'/></td></tr>";

	if(babyDetails[episodeid] != '' && babyDetails[episodeid] !=null && babyDetails[episodeid] .length !=0)
	{
		tabdata +=babyDetails[episodeid]+"</td></tr></table></table></body></html>";
		document.getElementById("motherLink").innerHTML = tabdata;
		document.getElementById("motherLink").style.top  = obj.offsetTop;
		document.getElementById("motherLink").style.left  = obj.offsetLeft+50 ;
		document.getElementById("motherLink").style.visibility='visible' ;
	}else if(babyDetails[episodeid] .length !=0)
	{
		hidePopUp();
	}
}

function hidePopUp()
{
	
	if(document.getElementById("motherLink")){
		document.getElementById("motherLink").style.visibility='hidden' ;
	}else{
		parent.document.getElementById("motherLink").style.visibility='hidden' ;
	}
}

function patClick(ind,patId)
{
	 //32902 start
    var restPatientYN =document.getElementById("restPatientYN"+ind).value;
    var accessRightsViewPatient =document.getElementById("accessRightsViewPatient").value;  
    if(patId !=="" && restPatientYN =="Y" && accessRightsViewPatient==0){
  	restrictOpenVIPPat(patId,restPatientYN,accessRightsViewPatient);
       return;
     } 
    //32902 end
    
	refreshArray();
	
	document.PatCriteriaFrm.encounter_id.value=episodeIdArr[ind] ;
	document.PatCriteriaFrm.patient_class.value =patient_class[ind];
	
	//[IN030566] Starts
	//self.document.PatCriteriaFrm.submit();
	/*var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;		
	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/EnterOrderValidate.jsp?patient_id="+patId, false ) ;
	xmlHttp.send( xmlDoc ) ;*/	
		
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var	xmlStr	= "<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
	var url = "../../eOR/jsp/EnterOrderValidate.jsp?patient_id="+patId;
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	
	if(trimString(xmlHttp.responseText)=="true")
	{
		self.document.PatCriteriaFrm.submit();
	}	
	//[IN030566] Ends
}

function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;
	if(parent.frames[2].location.href.indexOf(".jsp") != -1)
	{
		parent.frames[2].document.body.scrollLeft=temp;
	}
}
var reOrder='';
var anchorID='';
/*function callForOrderBy(obj)
{
	var qryStr = parent.MedServResultLocation.document.forms[0].url.value;
	parent.parent.PatCriteriaFr.document.forms[0].order_by.value=obj;
	parent.parent.PatCriteriaFr.document.forms[0].re_order.value=reOrder;
	parent.parent.PatCriteriaFr.document.forms[0].anchor_id.value=anchorID;
	val=qryStr.indexOf("&locn_type=");
	len=qryStr.length;
	sr1=qryStr.substring(0,val+1);
	sr2=qryStr.substring(val+11,len);
	qryStr=sr1+ sr2;
	var locType=top.content.workAreaFrame.PatCriteriaFr.document.forms[0].locn_type.value;
	var url=qryStr+'&locn_type='+locType+'&orderBy='+obj+'&reOrder='+reOrder+'&anchorID='+anchorID+'&leftScrolling='+scrollValue;
	top.content.workAreaFrame.PatResultFr.LocnResult.location.href='PatListByMedServiceResult.jsp?'+url;
}

function changeColor(object)
{
	anchorID=object.id;
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
		document.anchors(i).style.color='white';
	object.style.color='pink';
}*/

function storeValues(locn_type)
{
	//alert(locn_type);
	if(locn_type!='null')
		top.content.workAreaFrame.PatCriteriaFr.document.forms[0].locn_type.value = locn_type;
}

 var currClass = '';
  var url='';
	/* function callOnMouseOver(obj){
		currClass = obj.className ;
		 if("H" == "H")
			obj.className = 'FIRSTSELECTED';
		 else
			obj.className = 'FIRSTNORMAL';
	}

	function callOnMouseOut(obj){
		obj.className = currClass;
	}*/

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

	 function displayService(from){
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


		function showPrevLocn(){
		var qryStr = top.content.workAreaFrame.PatResultFr.MedServResultPatClass.document.forms[0].queryString.value;
		var pat_type =  document.forms[0].pat_type.value;
		var cur_pos=document.forms[0].currentPos.value;

		//var count = qryStr.indexOf("&pat_type=");
		//qryStr = qryStr.substring(0,count);
		//qryStr=qryStr.substring(0,qryStr.length-10);
		qryStr = qryStr+'&pat_type='+pat_type;

		if(document.forms[0].flagYN.value=='true' || document.forms[0].flagYN.value==true)
		{
			var from=eval(document.forms[0].from_disp.value)-5;
			var to=eval(document.forms[0].to_disp.value)-6;
			var url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
			//**checking for whether to display label on right side or not
			if(eval(cur_pos)>eval(to))
			{
				var url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
			}
			//**ends here
		}
		if(document.forms[0].flagYN.value==false || document.forms[0].flagYN.value=="false")
		{
			var from=eval(document.forms[0].from_disp.value)-5;
			var to=eval(document.forms[0].to_disp.value)-5;
			var url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
			//**checking for whether to display label on right side or not
			if(eval(cur_pos)>eval(to))
			{
				var url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
			}
			//**ends here
			if(eval(cur_pos)<=to && eval(cur_pos)>=from)
			{
				from=eval(from)-1;
				url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=true';
			}
			//code for chaecking when the from become < 0
			if(eval(from)<0)
			{
				if(eval(cur_pos)>=0 && eval(cur_pos)<=5)//spacial case
				{
					from=0;
					to=5;
					url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=true';
				}
				else
				{
					from=0;
					to=4;
					url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
					//**checking for whether to display label on right side or not
					if(eval(cur_pos)>eval(to))
					{
						var url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
					}
					//**ends here
				}
			}
		}

		self.location.href="../../eCA/jsp/PatListByMedServicePatLocn.jsp?"+url;
	}

	function showNextLocn(){ 
		var qryStr   =  top.content.workAreaFrame.PatResultFr.MedServResultPatClass.document.forms[0].queryString.value;
		var pat_type =  document.forms[0].pat_type.value;
		var cur_pos  =	document.forms[0].currentPos.value;
		/*var count = qryStr.indexOf("&pat_type=");
		qryStr = qryStr.substring(0,count);*/
		//qryStr=qryStr.substring(0,qryStr.length-10);
		qryStr = qryStr+'&pat_type='+pat_type;
		if(document.forms[0].flagYN.value=='true' || document.forms[0].flagYN.value==true){
			var from=eval(document.forms[0].from_disp.value)+6;
			var to=eval(document.forms[0].to_disp.value)+5;
			var url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
			//**checking for whether to display label on right side or not
			if(eval(cur_pos)>eval(to))
			{
				var url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
			}
			//**ends here
		}
		if(document.forms[0].flagYN.value==false || document.forms[0].flagYN.value=="false")
		{
			var from=eval(document.forms[0].from_disp.value)+5;
			var to=eval(document.forms[0].to_disp.value)+5;
			var url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false';
			//**checking for whether to display label on right side or not
			if(eval(cur_pos)>eval(to))
			{
				var url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=false&flagLastYN=true';
			}
			//**ends here
			if(eval(cur_pos)<=to && eval(cur_pos)>=from)
			{
				to=eval(to)+1;
				url = qryStr+'&start_disp='+from+'&end_disp='+to+'&labelCounter='+cur_pos+'&flagYN=true';
			}

		}
		self.location.href="../../eCA/jsp/PatListByMedServicePatLocn.jsp?"+url;
	}
	function fillUrl()
	{
		document.forms[0].url.value=top.content.workAreaFrame.PatResultFr.MedServResultPatClass.document.forms[0].url.value;
	}

//function for PatListByMedServicePatTitle.jsp starts
		var reOrder='';
		var scrollLeft=''; 
		function callForOrderBy(obj){ 
			
			var qryStr = parent.MedServResultLocation.document.forms[0] ;
			scrollValue = document.body.scrollLeft;
			top.content.workAreaFrame.PatCriteriaFr.document.forms[0].order_by.value=obj;
			top.content.workAreaFrame.PatCriteriaFr.document.forms[0].re_order.value=reOrder;
			top.content.workAreaFrame.PatCriteriaFr.document.forms[0].anchor_id.value=anchorID;
			if(qryStr == null)
            {
               if(top.content.workAreaFrame.PatResultFr.MedServResultTitle.formLocnResultLocation)
			    qryStr = document.forms[0].url.value;
			   else
                qryStr = top.content.workAreaFrame.PatCriteriaFr.PatCriteriaFrm.url.value;
				
            }
            else
            {
                qryStr = qryStr.url.value;
            }


			var url=qryStr+'&orderBy='+obj+'&reOrder='+reOrder+'&leftScrolling='+scrollValue+ '&anchorID=' + anchorID;
			parent.LocnResult.location.href='PatListByMedServiceResult.jsp?'+url;
		}

		function changeColor(object){
			anchorID=object.id;
			//scrollLeft=document.body.scrollLeft;
			if(object.style.color=='yellow'){
				reOrder='1';
				object.style.color='pink';
				return;
			}
			if(object.style.color=='pink'){
				reOrder='2';
				object.style.color='yellow';
				return;
			}
			reOrder='1';
			for(i=0;i<document.anchors.length;i++){
				document.anchors[i].style.color='white';
			}
			object.style.color='pink';
		}
		//function for PatListByMedServicePatTitle.jsp ends

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

