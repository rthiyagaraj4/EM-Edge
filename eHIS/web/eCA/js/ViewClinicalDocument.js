	/*
		Author	: Arvind Singh Pal
		Purpose : Created For GHL-CRF-0043 
		Date		: 12 November 2009

	*/
	
	
	async function loadViewPage(){	

					var dialogHeight= "80vh" ;
					var dialogWidth	= "61vw" ;
					var dialogTop	= "10px" ;
					var dialogLeft	= "40" ;
					var status = "no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=auto; status:no";
					var arguments	= "" ;

					var patient_id = document.forms[0].patient_id.value;	
					var enc_id	= document.forms[0].enc_id.value;					

					var params = 'patient_id='+patient_id+'&enc_id='+enc_id;		
					retVal = await top.window.showModalDialog("../../eCA/jsp/ViewClinicalDocumentMain.jsp?"+params ,arguments,features);
						
	}


	function makeDetailsVisible(obj)
	{


				var val =obj.value;	
				var rows;
				var lessCriteriaRows="120px,*,0%";
				var moreCriteriaRows="200px,*,0%";	

				if (document.forms[0].more.value==getLabel("Common.lesscriteria.label","COMMON"))
					bool='no';
				else 
					bool='yes';
				
				if (val==getLabel("Common.search.label","COMMON"))
					bool='no';
				
				if(bool == 'no')
				{			
						document.getElementById("moreCriteria").style.display="none";
						document.forms[0].more.value=getLabel("Common.morecriteria.label","COMMON");				
						
						if(parent.ViewFrameSet.rows==moreCriteriaRows)
							parent.ViewFrameSet.rows = lessCriteriaRows;	
						else
							parent.ViewFrameSet.rows = "120px,*,30px";

				}
				else if(bool == 'yes')
				{
					
						document.getElementById("moreCriteria").style.display="inline";
						document.forms[0].more.value=getLabel("Common.lesscriteria.label","COMMON");
									
						if(parent.ViewFrameSet.rows ==lessCriteriaRows)
							parent.ViewFrameSet.rows = moreCriteriaRows;
						else
							parent.ViewFrameSet.rows = "200px,*,30px";

				}
	}
	function clearViewForm(){	
		
			
			document.view_document.reset();		
			
			dateChange(document.getElementById("from_date"),document.getElementById("to_date"),document.getElementById("locale").value,"from_date");
			showViewResult();
		
			//if(document.getElementById("default_enct").value!="")
				//document.getElementById("encounter").value=document.getElementById("default_enct").value;

			//if(document.getElementById("enc_id").value!=""){				
				//document.getElementById("encounter").value=document.getElementById("enc_id").value;				
			//}
			//alert(document.getElementById("default_enct").value);
			//document.getElementById("moreCriteria").style.display="none";
			//document.forms[0].more.value=getLabel("Common.morecriteria.label","COMMON");

			 // Shaiju commented for the issue 17413

			//parent.ViewFrameSet.rows = "150px,0%,0%";
			//parent.ViewResult.location.href = "../../eCommon/html/blank.html";
			 //parent.ViewResult.location.reload();
	}

function showViewResult(){
	
			var from_date=document.getElementById("from_date").value;
			var to_date=document.getElementById("to_date").value;			
			var indno=trimString(document.getElementById("indno").value);
			var practitioner_id=document.getElementById("p_practitioner_id").value;
			var pract_type=document.getElementById("pract_type").value;
			var encounter=document.getElementById("encounter").value;
			var cnt=document.getElementById("task_cnt").value;
			var patient_id=document.getElementById("patient_id").value;	
			var enc_id=document.getElementById("enc_id").value;

			var appl_task = "";
			if (cnt != "" && parseInt(cnt) > 0)
			{
				for (var i=0;i<cnt ; i++)
				{
					var taskID = document.getElementById('task_'+i);
					if (taskID.checked)
					{
						appl_task +="'"+taskID.value+"',";
					}
					
				}
				var strLen = appl_task.length; 		
				appl_task = appl_task.slice(0,strLen-1); 
				
			}	
			if(appl_task !=null && appl_task !=''){
			
					//document.getElementById("moreCriteria").style.display="none";
					//document.forms[0].more.value=getLabel("Common.morecriteria.label","COMMON");
					//parent.ViewFrameSet.rows = "150px,*,30px";	
					parent.document.getElementById("ViewCriteria").style.height="17vh";
					parent.document.getElementById("ViewResult").style.height="77vh";
					parent.document.getElementById("pagination").style.height="6vh";
					
		
					parent.ViewResult.location.href = "../../eCA/jsp/ViewClinicalDocumentResult.jsp?patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&indno="+indno+"&practitioner_id="+practitioner_id+"&pract_type="+pract_type+"&encounter="+encounter+"&appl_task="+appl_task+"&enc_id="+enc_id;
			}
			else{

					alert(getMessage("ATLEAST_ONE_APPTASKS_SELECTED","CA"));
			}
	}

	function ViewDocPrevNext(obj)
	{	
	
			var objID = obj.id;	
			var totalPage=parseInt(parent.frames[1].view_form.totalPage.value);	
			//alert('totalPage=='+totalPage);
			var start="";
			var end="";
			var displstart="";
			if(objID=='lastPage'){				
						
						 var mode =totalPage%3;
						
						 //start=parseInt(totalPage/3)*3+mode;
						 if(mode==0)
							 start=totalPage-2;
						 else if(mode==1)
							start=totalPage;
						 else
							start=totalPage-1;						
						 end=totalPage;	
						  displstart=Math.ceil(totalPage/3);	
						 
			}
			if(objID=='firstPage'){
						 start=1;
						 end=3;	
						 displstart=start;

			}
			if(objID=='nextPage'){
				 start=document.getElementById("start").value;
			     end=document.getElementById("end").value;					 
				 displstart=parseInt(document.getElementById("displstart").value)+1;

			}
			if(objID=='prevPage'){				
				 start=parseInt(document.getElementById("start").value)-6;				 
				 end = start+2;	
				 
				 // if(document.getElementById("displstart").value !=2)
					//displstart=document.getElementById("displstart").value-2;
				 // else
					 displstart=parseInt(document.getElementById("displstart").value)-1;		

			}
			
			var patient_id = document.getElementById("patientid").value;
			var from_date=document.getElementById("fromdate").value;
			var to_date=document.getElementById("todate").value;
			var indno=document.getElementById("indno").value;
			var practitioner_id=document.getElementById("performed_by_id").value;
			var pract_type=document.getElementById("pract_type").value;
			var encounter=document.getElementById("encounter_id").value;
			var appl_task=document.getElementById("appl_task").value;
			var enc_id=document.getElementById("enc_id").value;
			//alert('from_date==='+from_date)
			
			parent.ViewResult.location.href = "../../eCA/jsp/ViewClinicalDocumentResult.jsp?patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&indno="+indno+"&practitioner_id="+practitioner_id+"&pract_type="+pract_type+"&encounter="+encounter+"&appl_task="+appl_task+"&enc_id="+enc_id+"&start="+start+"&end="+end+"&displstart="+displstart;

	
	}

	async function fnGetPractitionerId(obj)
	{
			if (obj != undefined && obj.name == "Practitioner_Name")
			{
				if (trimString(obj.value) == "")
				{			
					document.view_document.p_practitioner_id.value = "";
					return false;
				}
			}	
			var Practitioner_Name = trimString(document.view_document.Practitioner_Name.value);
			var facilityId = document.view_document.facilityId.value;
			var pract_type = document.view_document.pract_type.value;
			
			var search_code="";
			var search_desc="";	
			search_code="p_practitioner_id";
			search_desc= "practitioner_name";
		   
			var SQL_SELECT ="select a.practitioner_id code, a.practitioner_name description from am_practitioner a ";
			SQL_SELECT=SQL_SELECT+" Where upper(a.practitioner_id) like upper(?) and upper(a.practitioner_name) like upper(?) ";	

			if((pract_type !=null && pract_type !='' && pract_type !='all'))
			SQL_SELECT=SQL_SELECT+"AND a.pract_type ='"+pract_type+"'";

			
			var title="Practitioner Lookup";		
			var serviceVal   ="";
			var search_desc	= "";
			var argArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();
			var datatypesArray = new Array();

			argArray[0] = SQL_SELECT;
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = datatypesArray;
			argArray[4] = "1,2";
			argArray[5] = Practitioner_Name;
			argArray[6] = DESC_LINK;
			argArray[7] = CODE_DESC;	
			retArray =await CommonLookup( title, argArray );	
			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if (retArray != null && retArray != '' && retArray != "null")
			{		 
				document.view_document.p_practitioner_id.value = arr[0];
				document.view_document.Practitioner_Name.value = arr[1];	 	
			}
			else
				{
				document.view_document.p_practitioner_id.value = "";
				document.view_document.Practitioner_Name.value = "";		 
			}	

	}
	function changeFields(event){
			document.view_document.p_practitioner_id.value="";
			document.view_document.Practitioner_Name.value="";
	}

	function checkForNum(event)
		{
			var strCheck = '0123456789';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
			if( (event.keyCode >= 97) && (event.keyCode <= 122) )
				return (event.keyCode -= 32);
			return true ;
	}
function allowNumeric(obj)
{
	var strCheck = '123456789';
	if (strCheck.indexOf(obj.value) == -1)
	{
		 alert(getMessage("INVALID_NUMBER_FORMAT", "COMMON"));
		obj.focus();
		 return false;
	}
		
}
function dateChange(obj1,obj2,locale,callFrom)
{		

	   var validateDate = "";
	   var yearfromDate= "";
	   var yeartoDate= "";
		var fromDate=obj1.value;
		var toDate=obj2.value;		
		//alert(locale);
		//var locale=locale.value;		
		var patient_id = document.getElementById("patient_id").value;		
		
		if (callFrom == "from_date")
		{
			validateDate = obj1;
		}else
		{
			validateDate = obj2;
		}		
		if(chkDateTime(validateDate,"DMYHM",locale))
		{		
			/*if (fromDate != "")
				yearfromDate = fromDate.substr(6,4);
			if (toDate != "")			
				yeartoDate = toDate.substr(6,4);
		
			if(yearfromDate.length >=2 && yeartoDate >=2)
			{	*/		
				//alert('from'+ fromDate);
				//alert('toDate'+ toDate);
				//alert('patient_id'+ patient_id);


				var xmlStr ="<root><SEARCH ";
				xmlStr += "fromDate=\""+ fromDate +"\" " ;
				xmlStr += "toDate=\""+ toDate +"\" " ;
				xmlStr += "patient_id=\""+ patient_id +"\" " ;			
				xmlStr += "locale=\""+ locale +"\" " ;			
				xmlStr +=" /></root>" ;					
				var xmlHttp = new XMLHttpRequest() ;
				var xmlDoc = "" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "ViewClinicalDocumentIntermediate.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				eval(responseText);	

				/*if((document.getElementById("encounter").options.length > 1)&& document.getElementById("encounter").selectedIndex==0))
				{
					document.getElementById("encounter").selectedIndex=1;
				}
				else if(document.getElementById("encounter").selectedIndex==0)
				{
					document.getElementById("encounter").selectedIndex=0;
				}*/

			//}
		}
	}

function addEncounterList(encounter_id)
{	
	var element = document.createElement('OPTION') ;
	var formObj = eval("document.view_document.encounter");	
	
	var enc_id = document.getElementById("enc_id").value;
	var default_enct = document.getElementById("default_enct").value;	
	
	var select=getLabel("Common.defaultSelect.label","Common")	
		select='-----'+select+'-------';
	
	if (encounter_id == select)	
		element.value =  "";
	else 
		element.value =  encounter_id ;

	element.text = encounter_id ;
	if(encounter_id == default_enct)
	{
		element.selected ="selected";
	}
	formObj.add(element);
	
	
	if (formObj.options.length > 1&&document.getElementById("encounter").selectedIndex==0)
	{
		formObj.options[1].selected = true;
	}
	
}
function clearEncounterList()
{
	var formObj = eval("document.view_document.encounter");
	var len = formObj.options.length ;
	for(var i=0;i<len;i++)
	{
		formObj.remove('atc_class_l2_code') ;
	}
	
}

function chkDateTime(toDate,format,locale)
{	
	if(toDate.value != '') 
	{		
		var from_date = document.getElementById("from_date");
		var to_date = document.getElementById("to_date")

		// Added by Sridhar Reddy on 28/06/2009 to fix INCIDENT IN011617
		
		if(validDateObj(toDate,format,locale))
		{			
			if(from_date.value != "" || to_date.value != "")
			{
				if (chkToDate(from_date,to_date,format,locale))				
					return true;
				else
					return false;
			}
			return true;
		}else
			return false;
	}
	return true;
}
function chkToDate(fromDate,toDate,format,locale)
	{
	if(fromDate.value != "")
	{		
		if(!isBeforeNow(fromDate.value,format,locale))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
			fromDate.select();
			fromDate.focus();
			fromDate.value="";
			return false;
				
		}else
		{ 
		  if( toDate.value != "")
			{
				if(isBeforeNow(toDate.value,format,locale))
				{
					if(isAfter(toDate.value,fromDate.value, format, locale))
						return true;
					else
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						toDate.select();
						toDate.focus();
						return false;
					}
				}
				else
				  {
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					toDate.select();
					toDate.focus();
					return false;
				  }
			}
		}
	}else
	{		
		if((toDate.value!=""))
		{
		  if(!isBeforeNow(toDate.value, format, locale.value))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				toDate.select();
				toDate.focus();
				return false;
			}
		}
	}
}
function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}


function collapseExpand(obj,index)
{
	var tdObj = eval(document.getElementById("tableId"+index));
	if(obj.value == ' - ')
	{
		tdObj.style.display = 'none';
		obj.value = ' + ';
	}
	else if(obj.value == ' + ')
	{
		tdObj.style.display = 'inline';
		obj.value = ' - ';
	}
}
function getFile(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,extimageapplid)
{
	//alert("getFile");
	if(parent.messageFrameReference == null) //added for the condition, called_from = "OR" in FlowSheetEvents.jsp
	{
		messageFrameReference = 	parent.messageFrameReference;
	}
	var htmlVal = "<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link> </head> <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'> <form name=tempForm method=post action='../../eCA/jsp/CAOpenExternalApplication.jsp'><input type=hidden name=Histrectype value='"+Histrectype+"'><input type=hidden name=Contrsysid value='"+Contrsysid+"'><input type=hidden name=Accessionnum value='"+Accessionnum+"'><input type=hidden name=Contrsyseventcode value='"+Contrsyseventcode+"'><input type=hidden name=extimageapplid value='"+extimageapplid+"'></form></body></html>"

	parent.messageFrameReference.document.write(htmlVal);
	parent.messageFrameReference.document.tempForm.submit();
 
}

function setSelectFirstEncounterID(objName)
{
	if (document.getElementById("encounter"))
	{
		document.getElementById("encounter").selectedIndex=1;
	}
}

