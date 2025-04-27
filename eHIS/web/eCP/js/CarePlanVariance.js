//This file is saved on 07/11/2005.



function getVarianceReason(obj)
{
 clearVarianceReason();
 var variance_cause=obj.value;
 var xmlDoc="" ;
 var xmlHttp = new XMLHttpRequest() ;
 xmlStr ="<root><SEARCH " ;
 xmlStr +=" /></root>" ;
 //xmlDoc.loadXML( xmlStr);
 var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
 xmlHttp.open( "POST",'../../eCP/jsp/CarePlanVarianceDynamicValues.jsp?variance_cause='+variance_cause+'&mode=1',false);
 xmlHttp.send( xmlDoc ) ;
 responseText=xmlHttp.responseText ;
 eval(responseText);
}

function addVarianceReason(code,value)
{
   var element = document.createElement('OPTION');
   element.value =  code;
   element.text = value;
   parent.care_plan_header.document.forms[0].Variance_Reason.add(element);
}


function clearVarianceReason()
{
   var len = eval("document.forms[0].Variance_Reason.options.length") ;
   for(var i=0;i<len;i++)
   {
          eval("document.forms[0].Variance_Reason.remove(\"Variance_Reason\")") ;
   }
	var tp 		= "  ---"+getLabel("Common.defaultSelect.label","Common")+"---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.forms[0].Variance_Reason.add(opt)") ;
}


function checkForMax(obj)
{
	var val=obj.value;
        if(obj.name=='Variance_Remarks')
	    str=getLabel("Common.remarks.label","Common");
        else
	    str=getLabel("eCP.ActionPlan.label","CP");
	if(val.length > 200)
        {
		//message="APP-CP0033 "+ str +" Length cannnot be more than 200";
			message=getMessage("LENGTH_CANT_EXCEED_200","CP");
			message=message.replace("$",str);
            alert(message);
			obj.select();
			obj.focus();
	}
}

function ChangeStatus(obj,index)
{
  var select="";
  if(obj.checked==true)
  {
      obj.value="Y";
      select="Y";
  }
  else
  {
      obj.value="N";
      select="N";
  }
 var xmlDoc="" ;
 var xmlHttp = new XMLHttpRequest() ;
 xmlStr ="<root><SEARCH " ;
 xmlStr +=" /></root>" ;
 //xmlDoc.loadXML( xmlStr); 
 var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
 xmlHttp.open("POST",'../../eCP/jsp/CarePlanVarianceDynamicValues.jsp?select_mode=3'+'&select_yn1='+select+'&index='+index,false);
 xmlHttp.send( xmlDoc ) ;
 responseText=xmlHttp.responseText;
 eval(responseText);
}


function LoadDetail()
{
   var formObj=document.CarePlanVarianceHeader_Form;
   var variance_cause=formObj.Variance_Cause.value;
   var variance_reason=formObj.Variance_Reason.value;
   var variance_remark=formObj.Variance_Remarks.value;
   var variance_action_plan=formObj.Action_Plan.value;
   var p_care_plan_id=formObj.p_care_plan_id.value;
   var p_md_care_plan_id=formObj.p_md_care_plan_id.value;
   var p_var_comp_type=formObj.p_var_comp_type.value;
   var p_term_code=formObj.p_term_code.value;
   var p_term_set_id=formObj.p_term_set_id.value;
   var p_outcome_code=formObj.Expected_Outcome.value;
   var p_goal_code=formObj.p_goal_code.value;
   var select_yn=formObj.select_yn.value;
   formObj.reset();
   var message  = getMessage("VAR_CAUSE_REASON_NOT_BLANK","CP");
   if(variance_cause!='' && variance_reason!='')
   {
  parent.care_plan_dtls.location.href='../../eCP/jsp/CarePlanVarianceDetail.jsp?variance_cause1='+variance_cause+'&variance_reason='+variance_reason+'&variance_remark='+variance_remark+'&variance_action_plan='+variance_action_plan+'&mode=2'+'&p_care_plan_id='+p_care_plan_id+'&p_md_care_plan_id='+p_md_care_plan_id+'&p_var_comp_type='+p_var_comp_type+'&p_goal_code='+p_goal_code+'&p_outcome_code='+p_outcome_code+'&p_term_code='+p_term_code+'&p_term_set_id='+p_term_set_id+'&select_yn=Y';
   }
   else if(variance_cause=='' && variance_reason=='')
   {
     alert(message);
   }
   else if(variance_cause=='')
   {
     alert(message);
   }
   else if(variance_reason=='')
   {
     alert(message);
   }
}

async function getRemarks(obj)
{
   var dialogHeight= "20vh" ;
   var dialogWidth= "25vw" ;
   var dialogLeft="10";
   var dialogTop="10";
   var status = "no";
   var arguments= "" ;
   var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";dialogTop:"+dialogTop+";";
   //var retVals=window.showModalDialog("../../eCP/jsp/CarePlanVarianceFrameset.jsp?remarks="+obj+"&mode=1",arguments,features);
   await window.showModalDialog("../../eCP/jsp/CarePlanVarianceFrameset.jsp?remarks="+obj+"&mode=1",arguments,features);
}

async function getActionPlan(obj)
{
   var dialogHeight= "20vh" ;
   var dialogWidth= "25vw" ;
   var dialogLeft="10";
   var dialogTop="10";
   var status = "no";
   var arguments= "" ;
   var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";dialogTop:"+dialogTop+";";
   await window.showModalDialog("../../eCP/jsp/CarePlanVarianceFrameset.jsp?actionplan="+obj+"&mode=2",arguments,features);
}

function closeWindow(obj)
{
   if(obj=='Buttons')
   {
   parent.window.close();
   }
   else
   {
     window.close();
   }
}

function ClearHeader()
{
  document.CarePlanVarianceHeader_Form.reset();
}

function SubmitRecord()
{
   var formObj=parent.care_plan_dtls.document.CarePlanVarianceDetail_Form;
   if(formObj != undefined)
   {
   var size=formObj.size.value;
   var k=parseInt(0);
   var select_yn="";
   var select=parseInt(0);
   var message="";
   for(k=0;k<size;k++)
   {
     select_yn=eval('formObj.select'+k).value;
     if(select_yn=='Y')
        select++;
   }

   if(select>0)
   {
     formObj.submit();
   }
   else
   {
     message=getMessage("VAR_ATLEAST_1_CAUSE_REASON","CP");
     alert(message);
   }
   }
   else
	{
  	   message=getMessage("ATLEAST_1_VAR_CAUSE_REASON","CP");
       alert(message);
	}
}

function onSuccess(error_num,error_value)
{
window.returnValue="SUCCESS";
window.close();
}
