 var message     = "";
//function for create mode
function create()
{
	f_query_add_mod.location.href="../../eMR/jsp/TermSetCritforPatientClassFrameSet.jsp";
	}

function searchDetails()
  {
	 var frmobj=parent.f_query_header.document.form_add_mod ;
	 if(frmobj.criteria_val.value == 'Accuracy')
	  {
		 var fields = new Array (frmobj.criteria_val,frmobj.listValue,frmobj.listValue1);			    
		  var names = new Array (getLabel("Common.criteria.label","common"),getLabel("eMR.ListValue.label","MR"),getLabel("eMR.AccuracyDescription.label","MR"));
	  }
	  else
	  {
		  var fields = new Array (frmobj.criteria_val,frmobj.listValue);			    
		  var names = new Array (getLabel("Common.criteria.label","common"),getLabel("eMR.ListValue.label","MR"));	
	  }
	  var	msgFrame=parent.parent.messageFrame;
	  if(parent.f_query_header.checkFieldsofMst(fields, names, msgFrame))
		{	
  //parent.frames[1].location.href='../../eMR/jsp/AccuracyForPatientClassDetail.jsp?accuracy_code='+frmobj.accuracy_code.value;
  parent.frames[1].location.href='../../eMR/jsp/TermSetCritforPatientClassDetail.jsp?criteria='+frmobj.criteria_val.value+'&List_val='+frmobj.listValue.value+'&add_List='+frmobj.listValue1.value;
  parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp";

		}
  }
//function for query mode
function query(){
	frames[1].location.href='../../eMR/jsp/TermSetCritforPatientClassQuery.jsp';
}

function onSuccess() {
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.reload();
}

//function to check whether on apply,the flow can be proceeded...
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
//function whether the flow can proceed if on click of apply
function checkIfApply()
{
	var url=parent.frames[2].frames[1].frames[1].location.href;
	url=url.toLowerCase();
	if(url.indexOf("blank")==-1)
		return true;
	else
		return false;
}
function apply()
{
	var msgFrame= parent.frames[2].frames[2];
	
  if((! checkIsValidForProceed()) || (! checkIfApply()) )
	{
		message  = getMessage("APPLY_NOT_VALID",'MR');
		msgFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var frmObj=parent.frames[2].frames[1].frames[1].document.detail_form;
	var tot_rec=frmObj.total_records.value;

    for(i=0;i<tot_rec;i++){
		var select=eval("frmObj.select_yn"+i).checked;
		if(select==true)
			eval("frmObj.select_yn"+i).value='Y';
		else
			eval("frmObj.select_yn"+i).value='N';
		
		//alert(eval("frmObj.select_yn"+i).value);
	}

	for(i=0;i<tot_rec;i++){
		var select=eval("frmObj.default_yn"+i).checked;
		if(select==true)
			eval("frmObj.default_yn"+i).value='Y';
		else
			eval("frmObj.default_yn"+i).value='N';

	}

	
	parent.frames[2].frames[1].frames[1].document.forms[0].action='../../servlet/eMR.TermSetCritforPatientClassServlet';
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();

}
function reset()
{
	var loc=frames[2].document.forms[0]

	if (loc!=null )
	{
			f_query_add_mod.document.forms[0].reset();
	}
	else  if(loc==null)
	{
		f_query_add_mod.location.reload();
	}
}


	
function PopulateVal(obj)
{
	//form_add_mod.location.href="../../eCommon/jsp/AccuracyForPatientClassPopulateVal.jsp?criteriaVal="+ obj";
	parent.f_query_detail.location.href="../../eCommon/html/blank.html";
	var obj_type = document.forms[0].listValue;
	var length  = obj_type.length;
	for(i=0;i<length;i++) 
	{
		obj_type.remove(1);
	}

	if(obj.value == 'Accuracy')
	{
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.Certain.label","Common"); 
		opt_type.value='Certain';
		document.forms[0].listValue.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.Uncertain.label","Common"); 
		opt_type.value='Uncertain';
		document.forms[0].listValue.add(opt_type)
	}
	else if(obj.value == 'Encounter_stage')
	{
		document.getElementById("img1").style.visibility="hidden";
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.admission.label","Common"); 
		opt_type.value='admission';
		document.forms[0].listValue.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.Intermediate.label","Common"); 
		opt_type.value='Intermediate';
		document.forms[0].listValue.add(opt_type)
			var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.Discharge.label","Common"); 
		opt_type.value='Discharge';
		document.forms[0].listValue.add(opt_type)
	}
	else if(obj.value == 'Nature')
	{
		document.getElementById("img1").style.visibility="hidden";
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.Actual.label","Common"); 
		opt_type.value='Actual';
		document.forms[0].listValue.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.Potential.label","Common"); 
		opt_type.value='Potential';
		document.forms[0].listValue.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.Wellness.label","Common"); 
		opt_type.value='Wellness';
		document.forms[0].listValue.add(opt_type)
	}
	else if(obj.value == 'Priority')
	{
		document.getElementById("img1").style.visibility="hidden";
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.Normal.label","Common"); 
		opt_type.value='Normal';
		document.forms[0].listValue.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.High.label","Common"); 
		opt_type.value='High';
		document.forms[0].listValue.add(opt_type)
		var opt_type= document.createElement('Option');
		opt_type.text=getLabel("Common.Critical.label","Common"); 
		opt_type.value='Critical';
		document.forms[0].listValue.add(opt_type)
	}
	else if(obj.value =='')
	{
		document.getElementById("img1").style.visibility="hidden";

	}
		
}

function addListitem(obj1)
{
			var obj_type = document.forms[0].listValue1;
			var length  = obj_type.length;
			for(i=0;i<length;i++) 
			{
				obj_type.remove(1);
			}
		parent.f_query_detail.location.href="../../eCommon/html/blank.html";
		if((obj1.value == 'Certain') || (obj1.value == 'Uncertain'))
		{
			document.getElementById("img1").style.visibility='visible';
			var HTMLVal = new String();
			HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../jsp/TermSetCritforPatientClassPopulate.jsp?accuracyVal=" + obj1.value + "'></form></BODY></HTML>";
			parent.parent.frames[2].document.write(HTMLVal);
			parent.parent.frames[2].document.form1.submit();
			


		}
		else
			document.getElementById("img1").style.visibility='hidden';		
}

function clearResult()
{
	parent.f_query_detail.location.href="../../eCommon/html/blank.html";
}

function chk1(obj,j)
{
	if (obj.checked == false)
	{
		eval("document.forms[0].default_yn"+j).checked= false;
		//eval("document.forms[0].default_yn"+j).value="N";
	}

}

function chk2(obj,j)
{
	if (obj.checked == true && eval("document.forms[0].select_yn"+j).checked == false)
	{
		
		obj.checked = false;
		obj.value="N";
		eval("document.forms[0].select_yn"+j).value="N";
		eval("document.forms[0].select_yn"+j).checked= false;
	}

}

