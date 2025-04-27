function getcomponent()
{
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var locale = document.forms[0].locale.value;
		var search_desc="";
		var title = getLabel("Common.Component.label","Common");
		var result_linked_rec_type      = document.forms[0].hist_rec_type.value; 
		var target  = document.forms[0].comp_id;

		var sql="Select event_code code, short_desc description from CR_CLN_EVT_MST_LANG_VW where hist_rec_type = '"+result_linked_rec_type+"' and language_id = '"+locale+"' and UPPER(short_desc) like upper(?) AND event_code like upper(?)";

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
		retVal = await CommonLookup( title, argArray )

		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{

			var retVal=unescape(retVal);
		   	 arr=retVal.split("::");

		    	
				document.forms[0].comp_id.value=arr[0];
				document.forms[0].comp_id_code.value=arr[1];
		}
		else
		{
			document.forms[0].comp_id.value="";
			document.forms[0].comp_id_code.value="";
		}
		
}

function makeVisible(obj)
{
	
	if(obj.value == 'Less Criteria >>')
	{
	document.getElementById("moreCriteria").style.display = 'none';
	parent.notes.rows = "23%,*,3%";
	parent.notes1.rows = "50%,10%,30%,10%";
	
	document.forms[0].more.value="More Criteria >>";
	}
	else
	{
		
	document.getElementById("moreCriteria").style.display = 'inline';
	
		parent.notes.rows = "43%,*,3%";
		parent.notes1.rows = "48%,11%,30%,11%";
		document.forms[0].more.value="Less Criteria >>";
	}
}

function clearClick()
{	


	
	parent.RecClinicalNotesLinkHistRepResultFramenew.location.href="../../eCommon/html/blank.html";
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.location.href="../../eCommon/html/blank.html";
    parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.location.href="../../eCA/jsp/RecClinicalNotesLinkHistRepShowButtons.jsp";
    parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.location.href="../../eCA/jsp/RecClinicalNotesLinkHistRepSelectButtons.jsp";
	//document.location.reload();	
}


function checkIsNull(obj)
{
	if(trimCheck(obj.value)=='')
		return true;
	else
		return false;
}


/*function checkDateWithCurrentDate(toDateTime)
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
		from_date_time.value='';
		//from_date_time.select();
		from_date_time.focus();
		return false;
	}
    if(checkIsNull(to_date_time)==false)
	if(!doDateTimeChk(to_date_time)) 
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		//to_date_time.select();
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	if(checkIsNull(to_date_time)==false)
	if(checkDateWithCurrentDate(to_date_time.value))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("FROM_DATE_GREATER_SYSDATE","CA");		
		
		//to_date_time.select();
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	if(!checkIsNull(to_date_time) && !checkIsNull(from_date_time))
	if(!ValidateDateTime(from_date_time,to_date_time))
	{
		parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("TO_DT_GR_EQ_FM_DT","CA");		
		///to_date_time.select();
		
		to_date_time.value='';
		to_date_time.focus();
		return false;
	}
	
	
	
	parent.messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
	return true;
}

*/
function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}

function showSearchLinkResult1()
{
	
 	if(parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm != null)
	{	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value=',';		
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.location.href="../../eCommon/html/blank.html";
    parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.location.href="../../eCA/jsp/SpltyHomePageHistRepShowButtons.jsp";
    //parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.location.href="../../eCA/jsp/RecClinicalNotesLinkHistRepSelectButtons.jsp";

	}

	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time	=	document.forms[0].to_date_time.value;
	var patient_id      = document.forms[0].patient_id.value;
	var encounter_id      = document.forms[0].encounter_id.value;
	var return_format      = document.forms[0].return_format.value;
	var result_linked_rec_type      = document.forms[0].hist_rec_type.value;
	var event_group		=		document.forms[0].event_group.value;
	var class1			=	document.forms[0].class1.value;
	var abnormal		=	document.forms[0].abnormal.value;
	var comp_id			=	document.forms[0].comp_id.value;
	
	var comp_id_code		=	document.forms[0].comp_id_code.value;
	//alert("comp_id_code"+comp_id_code);
	var comp_val		=	document.forms[0].comp_val.value;
	var search_criteria		=	document.forms[0].search_criteria.value;
	//var current_encounter	=	document.forms[0].current_encounter.value;
	var order_by1		=	document.forms[0].order_by1.value;
	
	var order_by2		=	document.forms[0].order_by2.value;
	
	if(parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.current_encounter.checked==true)
	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.current_encounter.value='Y';
	else
	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.current_encounter.value='N';
	
	var current_encounter	=	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.current_encounter.value
	
	//alert(current_encounter);
	//alert(parent.RecClinicalNotesLinkHistRepResultFrame.name);
	
	parent.RecClinicalNotesLinkHistRepResultFramenew.location.href = "../../eCA/jsp/SpltyHomePageHistRepResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_id="+patient_id+"&hist_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&event_group="+event_group+"&class1="+class1+"&abnormal="+abnormal+"&comp_id="+comp_id+"&comp_id_code="+comp_id_code+"&comp_val="+comp_val+"&search_criteria="+search_criteria+"&current_encounter="+current_encounter+"&order_by1="+order_by1+"&order_by2="+order_by2+" &encounter_id="+encounter_id; 
	
}


function perform(obj)
{
	if(obj.checked==true)
	{
		var return_format	= parent.frames[0].document.forms[0].return_format.value ;
		var index			= obj.value;

		var rowobj			= eval("document.RecClinicalNotesLinkMedResultForm.chk_value"+index);
		var rowid			= rowobj.value;

		var searchobj		=	eval("document.RecClinicalNotesLinkMedResultForm.ret_value"+index);
		var searchstr		=	searchobj.value;
		
		var cat='';
		var temp='';

		while(true)
		{
            index++;  
			
			var histtype =  eval("document.RecClinicalNotesLinkMedResultForm.hist_data_type"+index);	

			if(histtype != null)
			{
				if(return_format == 'TEXT' && histtype.value == "HTM")
				{
					alert(getMessage("NO_TABLE_RETURN_RECORDS","CA"));
					//alert("APP-CA0152 Records returned in table format not allowed");
					obj.checked = false;
					return false;
				}
			}
			rowobj1=eval("document.RecClinicalNotesLinkMedResultForm.chk_value"+index);

			if(rowobj1 != null)
			{
				var rowid1=rowobj1.value;
				var searchobj1=eval("document.RecClinicalNotesLinkMedResultForm.ret_value"+index);
				var searchstr1=searchobj1.value;

				if(searchstr1.indexOf(searchstr)!=-1)
				{
					var chkobj=eval("document.RecClinicalNotesLinkMedResultForm.chkbox"+index);

					if(chkobj.checked==false)
					{
					  chkobj.checked=true;

					  if(temp != rowid1)
						   cat=cat+","+ rowid1;
					}
		        }
				else
				   break;
	           
			    temp=rowid1;
			}
			else
				break;
		}
			 
		parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value+=cat;
	}
	else
	{
		
		var index= obj.value;
		
		var rowobj=eval("document.RecClinicalNotesLinkMedResultForm.chk_value"+index);
		var rowid=rowobj.value;
		
		var searchobj=eval("document.RecClinicalNotesLinkMedResultForm.ret_value"+index);
		var searchstr=searchobj.value;
		
		var catrem='';

		while(true)
			{

		index++;
		
		rowobj1=eval("document.RecClinicalNotesLinkMedResultForm.chk_value"+index);
		
		if(rowobj1 != null)
				{
		var rowid1=rowobj1.value;
		
		var searchobj1=eval("document.RecClinicalNotesLinkMedResultForm.ret_value"+index);
		var searchstr1=searchobj1.value;
		
		 
		 if(searchstr1.indexOf(searchstr)!=-1)
				{
				 
				  var chkobj=eval("document.RecClinicalNotesLinkMedResultForm.chkbox"+index);
				  chkobj.checked=false;
				   catrem =catrem +","+ rowid1;
		
				}
				else
				{
					break;
				}

			}
			else
				{
				break;
				}
	}
 	             				 
	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value+=catrem;			 
	
		
			

	}

 var disbutval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value;
 //alert(disbutval);
 if( disbutval != '' || disbutval != ',' )
	{
   
  	parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.document.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=false;
    parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.document.RecClinicalNotesLinkHistRepSelectButtonsnewForm.select.disabled=false;

	}
	else
	{
   parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.document.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=true;
   parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.document.RecClinicalNotesLinkHistRepSelectButtonsnewForm.select.disabled=true;
	}

 
}


function perform1()
{

	
		var prev=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value
		if(prev != ',' || prev != '')
	{

        
		var str=prev.split(',');
        
		var count1=document.RecClinicalNotesLinkMedResultForm.countcheck.value;
		
		var	rowobjnew='';
		var rowidnew='';
		
		
		for(u=1;u<=count1;u++)
		{
			
			
            var rowobjct=eval("document.RecClinicalNotesLinkMedResultForm.chk_value"+u);
		    var rowidct=rowobjct.value; 
			for(p=1;p<str.length;p++)
		{
			if(rowidct == str[p])
			{
             var rowchkbox=eval("document.RecClinicalNotesLinkMedResultForm.chkbox"+u);
			 rowchkbox.checked=true;
			 break;
			}
			
		}
			
		}
		
	
	}

	
	
}


function showItems()
{
	
var remval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value	
//alert('remval'+(remval!=''));
if(remval !='')
	{
	removeItems();
	}



var selectitems=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value;
var module_id=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.module_id.value;
var cycle_no=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.cycle_no.value;
var keyRef=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.keyRef.value;
var patient_id=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.patient_id.value;

var hist_rec_type=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.hist_rec_type.value;
var return_format=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.return_format.value;
/*alert("selectitems="+selectitems);
alert("patient_id="+patient_id);
alert("hist_rec_type="+hist_rec_type);
alert("return_format="+return_format);*/
parent.messageFrameReference.location.href="../../eCommon/html/blank.html";
HTMLVal = "<form name='patientcare_dummy_form' id='patientcare_dummy_form' method='post' action='../../eCA/jsp/SpltyHomePageHistRepSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+selectitems+"'><input type=hidden name='patient_id' id='patient_id' value='"+patient_id+"'><input type=hidden name='hist_rec_type' id='hist_rec_type' value='"+hist_rec_type+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='module_id' id='module_id' value='"+module_id+"'><input type=hidden name='cycle_no' id='cycle_no' value='"+cycle_no+"'><input type=hidden name='keyRef' id='keyRef' value='"+keyRef+"'></form>";
parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
//alert('escape(selectitems)'+escape(selectitems));		
parent.messageFrameReference.document.patientcare_dummy_form.target = "RecClinicalNotesLinkHistSelectedTextFramenew";
parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value='';
parent.messageFrameReference.document.patientcare_dummy_form.submit();
	



}




function removeItems()
{
var selectval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value ;
//alert('selectval'+selectval);
var remval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value ;
//alert('remval'+remval);

    if(remval != '')
	{
		var remarr=remval.split(',');
        
		var remarrlen=remarr.length;
//		alert('remarrlen'+remarrlen);
				
		var	rowobjrem='';
		var rowidnewrem='';
		var chkcatrem='';
		var tmpcatrem='';
		
		
		for(p=1;p<remarrlen;p++)
		{
			//alert('selectval.lastIndexOf(remarr[p])'+selectval.lastIndexOf(remarr[p]));
			if(selectval.lastIndexOf(remarr[p])>0)
			{
            chkcatrem=selectval.substring(0,selectval.lastIndexOf(remarr[p])-1)+selectval.substring(selectval.lastIndexOf(remarr[p])+remarr[p].length,selectval.length);
			 
			}
			selectval=chkcatrem;
			
			
		}
			
	}
    if(chkcatrem == '')
	{
    chkcatrem=',';
	}
	
  	parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value=chkcatrem;	
 
	}

function performchkbox(obj)
{
	if(obj.checked==true)
	{
        var index= obj.value;
		var histtype =  eval("document.RecClinicalNotesLinkMedResultForm.hist_data_type"+index);

		var return_format = parent.frames[0].document.forms[0].return_format.value ;
		
		if(return_format == 'TEXT' && histtype.value == "HTM")
		{
			alert(getMessage("NO_TABLE_RETURN_RECORDS","CA"));
			obj.checked = false;
			
			return false;
		}
			

		var rowobj=eval("document.RecClinicalNotesLinkMedResultForm.chk_value"+index);
		var rowid=rowobj.value;
		parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value+=","+rowid;
	}
	else
	{
		
		var indexchk= obj.value;
		
		var rowobjchk=eval("document.RecClinicalNotesLinkMedResultForm.chk_value"+indexchk);
		var rowidchk=rowobjchk.value;

		var searchobj1=eval("document.RecClinicalNotesLinkMedResultForm.ret_value"+indexchk);
		var searchstr1=searchobj1.value;
		//alert('searchstr1'+searchstr1);
		
	   var remval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value;
	 
	    if(remval != '' || remval != ',')
		{
	 parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value+=","+rowidchk;
		}
		else
		{
         parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value=","+rowidchk;
		}
		
		
	}
	//alert('valuesindiv'+parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value);
	
	var disbutval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value;

	//alert(disbutval);

 if( disbutval != '' || disbutval != ',' )
	{
	parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.document.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=false;
	parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.document.RecClinicalNotesLinkHistRepSelectButtonsnewForm.select.disabled=false;
	}
	else
	{
    parent.RecClinicalNotesLinkHistRepShowButtonsFramenew.document.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=true;
    parent.RecClinicalNotesLinkHistRepSelectButtonsFramenew.document.RecClinicalNotesLinkHistRepSelectButtonsnewForm.select.disabled=true;
	}
}

function showAuto()
{
	
var remval=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value	
//alert('remval'+(remval!=''));
if(remval !='')
	{
	removeItems();
	}



var selectitems=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value;
var module_id=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.module_id.value;
var cycle_no=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.cycle_no.value;
var keyRef=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.keyRef.value;
var patient_id=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.patient_id.value;

var hist_rec_type=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.hist_rec_type.value;
var return_format=parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.return_format.value;
/*alert("selectitems="+selectitems);
alert("patient_id="+patient_id);
alert("hist_rec_type="+hist_rec_type);
alert("return_format="+return_format);*/
parent.messageFrameReference.location.href="../../eCommon/html/blank.html";
HTMLVal = "<form name='patientcare_dummy_form' id='patientcare_dummy_form' method='post' action='../../eCA/jsp/SpltyHomePageHistRepSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+selectitems+"'><input type=hidden name='patient_id' id='patient_id' value='"+patient_id+"'><input type=hidden name='hist_rec_type' id='hist_rec_type' value='"+hist_rec_type+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='module_id' id='module_id' value='"+module_id+"'><input type=hidden name='cycle_no' id='cycle_no' value='"+cycle_no+"'><input type=hidden name='keyRef' id='keyRef' value='"+keyRef+"'><input type=hidden name='check' id='check' value='xyz'></form>";
parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
//alert('escape(selectitems)'+escape(selectitems));		
parent.messageFrameReference.document.patientcare_dummy_form.target = "RecClinicalNotesLinkHistSelectedTextFramenew";
parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.remitems.value='';
parent.messageFrameReference.document.patientcare_dummy_form.submit();
	



}

function returnDataApprove_df()
{
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.action='../../servlet/eCA.SpltyHomePageServlet';
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.target='messageFrameReference';
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.method='post';
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.submit();
}

function returnDataApprove()
{
	if(parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm==null)
	{
	showAuto();
	}
	else
	{
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.action='../../servlet/eCA.SpltyHomePageServlet';
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.target='messageFrameReference';
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.method='post';
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.submit();
	
	}
}

function scrollTitle()
{
	
  var y = parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.RecClinicalNotesLinkHistRepResultFramenew.document.RecClinicalNotesLinkMedResultForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}

function scrollTitle1()
{
	
  var y = parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.RecClinicalNotesLinkHistSelectedTextFramenew.document.RecClinicalNotesLinkMedSelectedTextForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}

async function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)
{
	
	//alert("Histrectype"+Histrectype);
	//alert("Contrsysid"+Contrsysid);
	//alert("Accessionnum"+Accessionnum);
	//alert("Contrsyseventcode"+Contrsyseventcode);

	//document.forms[0].txtFlagQuickText.value = 'Y';
	var win_height		= "28";
	var win_width		= "50";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){
		win_height		= "23";
		win_width		= "37";
		win_scroll_yn	= "no";
}


var retVal = new String();
var dialogHeight = win_height ;
var dialogWidth = win_width ;
var dialogTop = "122";
var status = "no";
var scroll = win_scroll_yn;
var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
var arguments	= Accessionnum ;

Accessionnum	=	escape(Accessionnum);
retVal =await window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);
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

function chgretn(Obj)
{

if(Obj.value == 't')
parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format.value='TEXTLINK';
else
parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.forms[0].return_format.value='';

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

