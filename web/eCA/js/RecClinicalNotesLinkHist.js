
//Functions for the file name RecClinicalNotesLinkRepCriteria.jsp-start

function getcomponent()
{
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var locale		= document.forms[0].locale.value;

		var title=getLabel("Common.Component.label","Common");
		 
		var sectioncode=document.RecClinicalLinkHistNoteCriteriaForm.section.value;
		var sql="SELECT  COMP_ID,CA_GET_DESC.CA_TEMPLATE_LABEL(PROMPT_TEXT,`"+locale+"`,'2') SHORT_DESC,ITEM_TYPE FROM ca_section_discr_msr_vw where sec_hdg_code=`"+sectioncode+"`";

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;

		retVal		= CommonLookup( title, argArray )
		 
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{

			var retVal=unescape(retVal);
		   	 arr=retVal.split("::");

		    //ocument.forms[0].comp_val.value=arr[1];
			document.forms[0].comp_id.value=arr[0];
		
	
			//var id=document.forms[0].comp_val.value;
			//var val=document.forms[0].comp_val.value;
						
		//document.forms[0].comp_id.value=val;	//parent.RecClinicalNotesLinkHistNoteCriteriaFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkHistNoteCriteria.jsp?id="+id+"&val="+val+" ";
		}
		else
		{
			document.forms[0].comp_id.value="";
			document.forms[0].comp_val.value="";
		}
		
}


function makeVisible(obj)
{
	//if(obj.value == 'Less Criteria >>')
	if(obj.value ==getLabel("Common.lesscriteria.label","COMMON")+' >>')
	{
		document.getElementById("moreCriteria").style.display = 'none';
		parent.document.getElementById('RecClinicalNotesLinkHistNoteCriteriaFrame').style.height="23vh";
		parent.document.getElementById('CenterFrame').style.height="73vh";
		parent.document.getElementById('InsideFrame').style.height="73vh";
		parent.document.getElementById('messageFrameReference').style.height="3vh";
	/*	parent.notes.rows = "22%,67%,3%%";
		parent.notesexp.rows = "40%,10%,40%,10%";*/
		document.forms[0].more.value="More Criteria >>";
		document.forms[0].more.value=getLabel("Common.morecriteria.label","COMMON")+" >>";
	}
	else
	{
		document.getElementById("moreCriteria").style='display';
		parent.document.getElementById('RecClinicalNotesLinkHistNoteCriteriaFrame').style.height="30vh";
		parent.document.getElementById('CenterFrame').style.height="66vh";
		parent.document.getElementById('InsideFrame').style.height="66vh";
		parent.document.getElementById('messageFrameReference').style.height="3vh";
		//parent.notes.rows = "32%,*,3%"; 
		//parent.notesexp.rows = "39%,11%,39%,11%";
		document.forms[0].more.value="Less Criteria >>";
		document.forms[0].more.value=getLabel("Common.lesscriteria.label","COMMON")+" >>";
	}
}


function clearClick()
{	
	
	var qrystr = parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.RecClinicalLinkHistNoteCriteriaForm.query_string.value;	
	parent.RecClinicalNotesLinkHistNoteCriteriaFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkHistNoteCriteria.jsp?"+qrystr;
}


function checkIsNull(obj)
{
	if(trimCheck(obj.value)=='')
		return true;
	else
		return false;
}

/*
function checkDateWithCurrentDate(toDateTime)
{
	var toDate = toDateTime.split(" ");
	var toarray = toDate[0].split("/");
	var enteredDate = new Date(toarray[2],toarray[1],toarray[0]);

	var today = new Date();
	var date= today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getYear();
	today = new Date(year,month,date);
	if(enteredDate > today)
	{
		return true;
	}
	return false;
}





function checkPeriodFromTo()
{
	
	var from_date_time	=	document.forms[0].from_date_time;
	var to_date_time	=	document.forms[0].to_date_time;
	if(checkIsNull(from_date_time) && checkIsNull(to_date_time) ) 
	{
		return true;
	}

	if(checkIsNull(from_date_time)==false)
	if(!doDateTimeChk(from_date_time))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		from_date_time.select();
		from_date_time.focus();
		return false;
	}
    if(checkIsNull(to_date_time)==false)
	if(!doDateTimeChk(to_date_time)) 
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	if(checkIsNull(to_date_time)==false)
	if(checkDateWithCurrentDate(to_date_time.value))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("FROM_DATE_GREATER_SYSDATE","CA");		
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	if(!checkIsNull(to_date_time) && !checkIsNull(from_date_time))
	if(!ValidateDateTime(from_date_time,to_date_time))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("TO_DT_GR_EQ_FM_DT","CA");		
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	
	
	
	parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
	return true;
}
*/

function showCalendarValidate(str){
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}


function showSearchLinkResult()
{
	
	var patient_id      = document.forms[0].patient_id.value;
	var encounter_id      = document.forms[0].encounter_id.value;
	var result_linked_rec_type = document.forms[0].result_linked_rec_type.value;
	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time	=	document.forms[0].to_date_time.value;
	var author			=	document.forms[0].author.value;
	var note_group		=		document.forms[0].note_group.value;
	var note_type		=	document.forms[0].note_type.value;
	var section			=	document.forms[0].section.value;
	var order_by1		=	document.forms[0].order_by1.value;
	var order_by2		=	document.forms[0].order_by2.value;
	if(parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.getElementById('current_encounter').checked==true)
		parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.RecClinicalLinkHistNoteCriteriaForm.current_encounter.value='Y';
	else
		parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.RecClinicalLinkHistNoteCriteriaForm.current_encounter.value='N';
	
	var current_encounter	=	parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.RecClinicalLinkHistNoteCriteriaForm.current_encounter.value;

	parent.RecClinicalNotesLinkHistNoteTreeFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkHistNoteTree.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&result_linked_rec_type="+result_linked_rec_type+"&author="+author+"&note_group="+note_group+"&note_type="+note_type+"&section="+section+"&current_encounter="+current_encounter+"&order_by1="+order_by1+"&order_by2="+order_by2+"";
}


function populatenotetype()
{
	document.forms[0].note_type.disabled=false;
	var length  =parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.RecClinicalLinkHistNoteCriteriaForm.note_type.length;	
			
			for(i=1;i<length;i++)
			{
			  parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.RecClinicalLinkHistNoteCriteriaForm.note_type.remove(1);
			}
	var note_group     = document.forms[0].note_group.value;
	

	HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkHistNoteTypePopulate.jsp'><input type=hidden name='note_group' id='note_group' value='"+note_group+"'></form></body></html>";
	parent.messageFrameReference.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrameReference.document.dummy_form.submit();
}


function populatesection()
{
	document.forms[0].section.disabled=false;
	var length  =parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.RecClinicalLinkHistNoteCriteriaForm.section.length;	
			
			for(i=1;i<length;i++)
			{
			  parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.RecClinicalLinkHistNoteCriteriaForm.section.remove(1);
			}

		var note_type     = document.forms[0].note_type.value;

		HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkHistSectionPopulate.jsp'><input type=hidden name='note_type' id='note_type' value='"+note_type+"'></form></body></html>";
		parent.messageFrameReference.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrameReference.document.dummy_form.submit();
}

//Functions for the file name RecClinicalNotesLinkHistNoteCriteria.jsp-end


//Functions for the file name RecClinicalNotesLinkHistNoteAddButtons.jsp-start

var i=1;
function addToDiv()
{
	if(parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("data")!=null)
	{ 
	var patient_id = parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("patient_id").value;
	var encounter_id = parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("encounter_id").value;
	var accession_num =parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("accession_num").value;
	var section_hdg_code =parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("section_hdg_code").value;
	var subsection_hdg_code =parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("subsection_hdg_code").value;
	var facility_id =parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("facility_id").value;

   
	
	//if(parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("data")!=null)
	//{ 
		
		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/RecClinicalNotesLinkHistNoteIntermediate.jsp?accession_num="+accession_num+"&section_hdg_code="+section_hdg_code+"&subsection_hdg_code="+subsection_hdg_code+"&facility_id="+facility_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&mode=addToBean", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		parent.RecClinicalNotesLinkHistNoteSelectButtons.RecClinicalNotesLinkHistNoteSelectButtonsForm.select.disabled = false;
		
		
		/*
		var prevDivHTML =parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("data").innerHTML;
		
	
		
		var finalDiv = 	parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.document.getElementById("finalDiv").innerHTML;
		
		finalDiv +=  prevDivHTML;
		parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.document.getElementById("finalDiv").innerHTML = finalDiv;
        parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.document.getElementById("inHTML").value=finalDiv;
	 
	 	
		parent.RecClinicalNotesLinkHistNoteSelectButtons.RecClinicalNotesLinkHistNoteSelectButtonsForm.select.disabled = false;
				
		if(i>1)
		parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.document.getElementById("finalDiv").scrollIntoView(false);
		i++; */
	}
	else				
	  alert(getMessage("ENSURE_SELECTION","CA"));	
	
}
//Functions for the file name RecClinicalNotesLinkHistNoteAddButtons.jsp-end





//Functions for the file name RecClinicalNotesLinkHistNoteSelectButtons.jsp-start

function clearFormApprove()
{
	
	
		
	if(parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.document.forms[0]!=null){
		
		var patient_id = parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("patient_id").value;
		var encounter_id = parent.RecClinicalNotesLinkHistNoteAddTextHdrFrame.document.getElementById("encounter_id").value;
		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/RecClinicalNotesLinkHistNoteIntermediate.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&mode=clearBean", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		
		
		//parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.document.getElementById("finalDiv").innerHTML =  "";
		parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.document.getElementById('finalDiv').innerHTML =  "";
		document.forms[0].select.disabled = true;
	}
}
function returnDataApprove()
{
	//var returnValue = parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.document.getElementById("finalDiv").innerHTML;

	var returnValue = parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.document.getElementById('finalDiv').innerHTML;
	//var returnValue = parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.document.getElementById("inHTML").value;
	
	
	//document.applets[0].innerHTML;
	
	
	if(returnValue=='')
		 alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));
		else
	{
		parent.window.returnValue = returnValue;		
		parent.window.close();
	}
}


function chkToDate(toDate)
{
	if(toDate.value != '') 
	{ 
		if(!(doDateTimeChk(toDate)) )
		{
			toDate.focus();
			toDate.select();
			msg = getMessage("INVALID_DATE_TIME","CA");
			alert(msg);
			return false;
		}
	}
}

function doDateCheck1(fromDate,toDate,currDate,format,locale)
{
	if((!fromDate.value=="")&&(!toDate.value==""))
	{
	if(isBeforeNow(fromDate.value, format, locale))
	{
		if(isBeforeNow(toDate.value, format, locale))
		{
			if(isAfter(toDate.value, fromDate.value, format, locale))
				return true;
			else
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
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
	else
	{
		alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
		fromDate.select();
		fromDate.focus();
		return false;
	}
	}


}
function reloadSelPage()
{
	patient_id =parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.RecClinicalLinkHistNoteCriteriaForm.patient_id.value;
	encounter_id =parent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.RecClinicalLinkHistNoteCriteriaForm.encounter_id.value;
	
	parent.RecClinicalNotesLinkHistNoteSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkHistNoteSelectedText.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;


}

