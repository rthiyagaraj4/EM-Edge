/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
18/09/2012	  IN33558		 Nijitha s	 Incident No: IN33558 - Link Doc in Record Clinical Note Displays Error.
04/10/2012	IN33558.1		 Dinesh T	 Incident No: IN33558 - Link Doc in Record Clinical Note Displays Error.
11/02/2013	  IN037164		 Chowminya G No Prompt for password for sensitive diagnosis in result link section in clinical notes
21/02/2012	  IN036181		 Chowminya G	 reports which has special characters such as an airstrisk (*) or a semicolon 
19/03/2013    IN038773       Chowminya G Issue on the Result link doc in clinical notes for the Result Category of Dept Diagnostics.
28/11/2014	IN052716		Ramesh G		Result Link In Template Based Section In  Clinical Notes For ?Table? And ?Text?. 
24/05/2016	  	IN055439	Karthi L		MO_CRF_20102
---------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
31/03/2017	IN061907	Krishna Gowtham J	26/02/2017	Ramesh G		ML-MMOH-CRF-0559
15/04/2023	   38981        Krishna Pranay   16/04/2023     Ramesh G     ML-MMOH-CRF-1986

------------------------------------------------------------------------------------------------------------------------------
*/
function show_descnew(obj)
{
	
     parent.messageFrameReference.location.href="../../eCommon/html/blank.html";
	if(obj.value!="" || obj.value!= null)
	{
			var htmlVal = "";
			
			htmlVal = "<form name=tempForm2 method=post action='../../eCA/jsp/RecClinicalNotesLinkDiagCodeDesc.jsp'><input type=hidden name=diag_code value='"+obj.value+"'></form>"
			parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',htmlVal);
		
            parent.messageFrameReference.document.tempForm2.submit();
			
	}
}

String.prototype.replaceAll=function(s1, s2) {return this.split(s1).join(s2)}//IN036181

function Clear_Allnew()
{
	
	parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.reset();

}


function enableCode(obj)
{

	if(!obj.value=="")
	{
		parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.search_button.disabled=false;
		parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code.value="";
		parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code_desc.value="";
	}
	else 

	{
		parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.search_button.disabled=true;
		parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code.value="";
		parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code_desc.value="";
	}

}


/*function doDateCheck(from,to,obj,obj1) {
			if(CheckSystemDateLesserDiag(obj,obj1)){
				if(!doDateCheckAlert(from,to)){
					alert(getMessage("FROM_DATE_GREAT_EFF","CA"));
					//alert('APP-SM0005 From Date Should Not Be Less than To Date');
					obj.select();
					obj.focus();
					return false;
				}
			}
		}
		*/
   function doDateCheck(from_date,to_date,format,locale)
{
	if (!(from_date.value == null || from_date.value == "" ))
	{
		if(!isBeforeNow(from_date.value, format, locale))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
			from_date.select();
			from_date.focus();
			return false;
		}
		else
			{
				if (!(to_date.value == null || to_date.value == "" ))
					
					{
						if(isBeforeNow(to_date.value, format, locale))
						{
							if(isAfter(to_date.value, from_date.value, format, locale))
								return true;
							else
								{
									alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
									return false;
								}
						}
						else
							{
								alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
								to_date.select();
								to_date.focus();
								return false;
							}
					}
			}
	}
	else
		{
		  if((!to_date.value==""))
			{
			  if(!isBeforeNow(to_date.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					to_date.select();
					to_date.focus();
					return false;
				}
			}
		}
}

function showCalendarValidate(str){
			var flg = showCalendar(str,null,null);
			document.getElementById(str).focus();
			return flg;
}

async function show_windownew(scheme,scheme_desc){
			var s = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.scheme.value;
			scheme_desc= parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.scheme_desc.value 
			var Encounter_Id= parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.encounter_id.value ;
		    var  p_auth_yn="Y";
			var term_set_id = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code_set.value;
			var speciality_code = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.specialty_code.value;
			var practitioner_id = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.practitioner_id.value;
			var dob = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.Dob.value;
	        var age = "";
	        var sex = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.sex.value;

/*			alert("Encounter_Id ="+Encounter_Id+"=");
			alert("term_set_id ="+term_set_id+"=");
			alert("speciality_code ="+speciality_code+"=");
			alert("practitioner_id ="+practitioner_id+"=");
			alert("dob ="+dob+"=");
			alert("sex ="+sex+"=");*/

            if (s == 5){
				var retVal = "test Value";
				var dialogHeight= "28" ;
				var dialogWidth = "43" ;
				var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
				var arguments   = "" ;
				retVal = await window.showModalDialog("../../eCA/html/eCISLUE.html",arguments,features);
				var arr = new Array();
				arr = retVal.split("|");
				var stra = arr[0];
				var strc = arr[1];
				var strb = arr[2];
				parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code.value         = stra;
            }

			if (s == 1 || s == 2){
                var retVal =    new String();
                var dialogHeight= "33" ; // modified by kishore kumar n on 10/12/2008 for CRF 0387.
                var dialogWidth = "44" ;
                var status = "no";
	            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
                var cause_ind='';

				retVal =await window.showModalDialog("../../eMR/jsp/TermCodeSearchMainFrame.jsp?speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);

                if (!(retVal == null)){
                    var retdata;
                    if(scheme=="2"){
			             retdata=retVal.split("/") ;
		                retVal=retdata[0];
					}
				   parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code.value=retVal;
				   parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code.onblur();
                  
				}
			}
		}

function funSearchnew()
{
parent.messageFrameReference.location.href="../../eCommon/html/blank.html";
var fromdate =  parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.txtFromDate.value;
var todate =  parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.txtToDate.value;

var diagcode =  parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code.value;

var diagtype =  parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.diag_type.value;
var orderby1 =  parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.order_by1.value;

var orderby2 = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.order_by2.value;
var encstatus = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.current_encounter.value;
var includestatus =  parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.include_Support_Diag.value;//38981
var patient_id = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.patient_id.value;
var encounter_id = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.encounter_id.value;
var term_set_id = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code_set.value;
var sec_hdg_code = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.sec_hdg_code.value;
var result_linked_rec_type = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.result_linked_rec_type.value;
var call_from_link_doc_btn = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.call_from_link_doc_btn.value;//IN061907

var radio="";

if (parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.problems_radio[0].checked)
radio=parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.problems_radio[0].value;
else
radio=parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.problems_radio[1].value;	

//alert(fromdate+','+todate+','+radio+','+criteria+','+diagcode+','+diagtype+','+orderby1+','+orderby2+','+encstatus);
if (parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.current_encounter.checked==true)
		encstatus="Y";
else
		encstatus="N";
//38981 start
if (parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.include_Support_Diag.checked==true)
	includestatus="Y";
else
	includestatus="N";
//38981 end
var htmlVal = "";
//IN061907 start			
//htmlVal = "<form name=tempForm3 method=post target= RecClinicalNotesLinkDiagResultFrame action='../../eCA/jsp/RecClinicalNotesLinkDiagResult.jsp'><input type=hidden name=patient_id value='"+patient_id+"'><input type=hidden name=encounter_id value='"+encounter_id+"'><input type=hidden name=from_date_time value='"+fromdate+"'><input type=hidden name=to_date_time value='"+todate+"'><input type=hidden name=diagcode value='"+diagcode+"'><input type=hidden name=diagtype value='"+diagtype+"'><input type=hidden name=orderby1 value='"+orderby1+"'><input type=hidden name=orderby2 value='"+orderby2+"'><input type=hidden name=encstatus value='"+encstatus+"'><input type=hidden name=radio value='"+radio+"'><input type=hidden name=term_set_id value='"+term_set_id+"'><input type=hidden name=sec_hdg_code value='"+sec_hdg_code+"'><input type=hidden name=result_linked_rec_type value='"+result_linked_rec_type+"'></form>"
//htmlVal = "<form name=tempForm3 method=post target= RecClinicalNotesLinkDiagResultFrame action='../../eCA/jsp/RecClinicalNotesLinkDiagResult.jsp'><input type=hidden name=patient_id value='"+patient_id+"'><input type=hidden name=encounter_id value='"+encounter_id+"'><input type=hidden name=from_date_time value='"+fromdate+"'><input type=hidden name=to_date_time value='"+todate+"'><input type=hidden name=diagcode value='"+diagcode+"'><input type=hidden name=diagtype value='"+diagtype+"'><input type=hidden name=orderby1 value='"+orderby1+"'><input type=hidden name=orderby2 value='"+orderby2+"'><input type=hidden name=encstatus value='"+encstatus+"'><input type=hidden name=radio value='"+radio+"'><input type=hidden name=term_set_id value='"+term_set_id+"'><input type=hidden name=sec_hdg_code value='"+sec_hdg_code+"'><input type=hidden name=result_linked_rec_type value='"+result_linked_rec_type+"'><input type=hidden name=call_from_link_doc_btn value='"+call_from_link_doc_btn+"'></form>"
htmlVal = "<form name=tempForm3 method=post target= RecClinicalNotesLinkDiagResultFrame action='../../eCA/jsp/RecClinicalNotesLinkDiagResult.jsp'><input type=hidden name=patient_id value='"+patient_id+"'><input type=hidden name=encounter_id value='"+encounter_id+"'><input type=hidden name=from_date_time value='"+fromdate+"'><input type=hidden name=to_date_time value='"+todate+"'><input type=hidden name=diagcode value='"+diagcode+"'><input type=hidden name=diagtype value='"+diagtype+"'><input type=hidden name=orderby1 value='"+orderby1+"'><input type=hidden name=orderby2 value='"+orderby2+"'><input type=hidden name=encstatus value='"+encstatus+"'><input type=hidden name=includestatus value='"+includestatus+"'><input type=hidden name=radio value='"+radio+"'><input type=hidden name=term_set_id value='"+term_set_id+"'><input type=hidden name=sec_hdg_code value='"+sec_hdg_code+"'><input type=hidden name=result_linked_rec_type value='"+result_linked_rec_type+"'><input type=hidden name=call_from_link_doc_btn value='"+call_from_link_doc_btn+"'></form>"//38981

//IN061907

parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',htmlVal);           parent.messageFrameReference.document.tempForm3.submit();

//parent.RecClinicalNotesLinkDiagResultFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkDiagResult.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&from_date_time="+fromdate+"&to_date_time="+todate+"&criteria="+criteria+"&diagcode="+diagcode+"&diagtype="+diagtype+"&orderby1="+orderby1+"&orderby2="+orderby2+"&encstatus="+encstatus+"";

}
 
function scrollTitle()
{
	
  var y = parent.RecClinicalNotesLinkDiagResultFrame.RecClinicalNotesLinkDiagResultForm.document.body.scrollTop;

  if(y == 0){
	parent.RecClinicalNotesLinkDiagResultFrame.RecClinicalNotesLinkDiagResultForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.RecClinicalNotesLinkDiagResultFrame.RecClinicalNotesLinkDiagResultForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.RecClinicalNotesLinkDiagResultFrame.RecClinicalNotesLinkDiagResultForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.RecClinicalNotesLinkDiagResultFrame.RecClinicalNotesLinkDiagResultForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}

function scrollTitle1()
{
	
  var y = document.body.scrollTop;
  //alert(y);

  if(y == 0){
	  document.getElementById("divDataTitle").style.position = 'static';
	  document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	  document.getElementById("divDataTitle").style.position = 'relative';
	  document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}	


var ret_str='';
function Reassaign(obj)
{
	var return_format=parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code=parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].sec_hdg_code.value;
	var result_linked_rec_type=parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].result_linked_rec_type.value;
	var includestatus= parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.includestatus.value;//38981
	
	//alert('sec_hdg_code...'+sec_hdg_code+'...result_linked_rec_type..'+result_linked_rec_type);
	if(obj.checked)
	{
		var chkval = obj.value;
		//ret_str=parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.ret_value[parseInt(chkval)].value+"@";
			
		ret_str=eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.ret_value"+chkval+".value")+"�";
		//parent.RecClinicalNotesLinkDiagSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&ret_str="+encodeURIComponent(ret_str,"UTF-8")+"";//IN33558
		//parent.RecClinicalNotesLinkDiagSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&ret_str="+ret_str+"";//IN33558
		parent.RecClinicalNotesLinkDiagSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&ret_str="+ret_str+"&includestatus="+includestatus+"";//38981
		parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.chk_value"+chkval+".value")
			//alert("remval"+remval);
			//parent.ret_str=parent.ret_str+parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.ret_value[parseInt(remval)].value+"@";
			//parent.RecClinicalNotesLinkDiagSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&remval="+encodeURIComponent(remval,"UTF-8")+"&ret_str="+encodeURIComponent(ret_str,"UTF-8")+"&removebean=Y";//IN033558.1
			//parent.RecClinicalNotesLinkDiagSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&remval="+encodeURIComponent(remval,"UTF-8")+"&ret_str="+ret_str+"&removebean=Y";//IN033558.1
			parent.RecClinicalNotesLinkDiagSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&includestatus="+includestatus+"&remval="+encodeURIComponent(remval,"UTF-8")+"&ret_str="+ret_str+"&removebean=Y";//38981

	
		}	
}

function chkunchk(objCheck)
{
	var index = 0;
	if(objCheck.checked==false)
	{
		parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.ctrlChkBox.checked=false
	}
	else
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.count.value; cnt++)
		{
			val = eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.ctrlChkBox.checked=true
		}
	}	
}


function perform(ctrlChkBoxObj)
{
	var return_format=parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value;
	
	var sec_hdg_code = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.result_linked_rec_type.value;
	var includestatus= parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.includestatus.value;//38981

	var val ="";
	var retstr2="";
    var strval="";
	parent.messageFrameReference.location.href="../../eCommon/html/blank.html"
	if(ctrlChkBoxObj.checked==true)
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.count.value; cnt++)
		{
			
			val = eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.chkbox"+cnt);
			if(!val.checked)
            {
				val.checked = true;
            strval=eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.ret_value"+cnt);
			retstr2 = retstr2 + strval.value+"�";
			}
			
			
		}
		//Below 'escape(retstr2)' is removed and only retstr2 is passed,modified by Archana DHal on 10/14/2010 related to incident IN024424.
		//HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='result_linked_rec_type' id='result_linked_rec_type' value='"+result_linked_rec_type+"'></form>";
		HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='result_linked_rec_type' id='result_linked_rec_type' value='"+result_linked_rec_type+"'><input type=hidden name='includestatus' id='includestatus' value='"+includestatus+"'></form>";//38981

		parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
		
		parent.messageFrameReference.document.dummy_form.target = "RecClinicalNotesLinkDiagSelectedTextFrame";
		parent.messageFrameReference.document.dummy_form.submit();
		parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;
		
	}
	
	else
	{
		for(cnt=0; cnt<parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.count.value; cnt++)
		{
			
			val = eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.chkbox"+cnt);
			val.checked = false;
			strval=eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.ret_value"+cnt);
			retstr2 = retstr2 + strval.value+"�";
		}
		
		//parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&flag=clear&ret_str="+escape(retstr2);
	 	parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp?sec_hdg_code=&result_linked_rec_type=&return_format=&flag=clear&ret_str=";
		
	}


}


function selText(obj1)
{
	var return_format=parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value;
	var sec_hdg_code = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.result_linked_rec_type.value;

	
	var clearchkval='';
	var clearremval='';
	if(!obj1.checked)
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.RecClinicalNotesLinkDiagSelectedTextForm.clear"+clearchkval+".value");

		
	 	parent.RecClinicalNotesLinkDiagSelectedTextFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp?return_format="+return_format+"&remval="+encodeURIComponent(clearremval,"UTF-8")+"&removebean=Y&sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type;
		makeresultcheck(clearremval)

	}
}
function makeresultcheck(remval)
{
	
	for(cnt=0; cnt<parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.chk_value"+cnt+".value");
					
			if(strval==remval)
		{
				val.checked = false
   
			parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.ctrlChkBox.checked = false 
		}

	}
	
   
  
}
	

function returnDataApprove()
{
	//  MO_CRF_20102[IN055439] - Start
		//IN061907 start
		/*if(document.getElementById("chkt").checked) {
			parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
		}*/
		var dispResLinkHYMLYN = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].dispResLinkHYMLYN.value; //IN061907
		//parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
		if(dispResLinkHYMLYN == "Y")
		{
			if(parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.chkl.checked) 
			{
				parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value='HTML';
			}
			else
			{
				
				parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
			}
		}
		else
		{
			if(parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.chkl.checked) 
			{
				parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value='';
			}
			else
			{
				parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value='TEXT';
			}
		}
		//IN061907 ends
	//  MO_CRF_20102[IN055439] - End
	var str = parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.getElementById("innerhtml").value;
	var str_header = parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.getElementById("innerhtml_header").value;
	var includestatus= parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.includestatus.value;//38981

	var return_format=parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value;
	var returnValue='';
	if(return_format=="TEXTLINK")
	{
		//IN052716 Start.
		//returnValue=parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.forms[0].temp.value;
		var strtext = parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.getElementById("innertext").value;
		var strtext_header = parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.getElementById("innertext_header").value;
		//38981 start
		if(strtext!=null || strtext != '' || strtext!= " "){
			if(includestatus == "Y")
			{ 
				if(strtext_header==null || strtext_header == '' || strtext_header == " ")
				{ 

				//	strtext="<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class=''  style='font-size:12'><b>"+getLabel("Common.Accuracy.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.onsetdate.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.description.label",'Common')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel("Common.Stage.label",'COMMON')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.code.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.scheme.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.DiagnosisRemarks.label",'ca')+"</b></td></tr>"+strtext+"</table>";
					strtext="<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class=''  style='font-size:12'><b>"+getLabel("Common.Accuracy.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.onsetdate.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.description.label",'Common')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel("Common.Stage.label",'COMMON')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.code.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.scheme.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.DiagnosisRemarks.label",'ca')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.SupportingDiag.label",'ca')+"</b></td></tr>"+strtext+"</table>";
				}
				else
				{
					strtext= strtext_header+" "+strtext+"</table>";
				}
				
			}
			else
			{
			if(strtext_header==null || strtext_header == '' || strtext_header == " ")
			{ 
			//	strtext="<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class=''  style='font-size:12'><b>"+getLabel("Common.Accuracy.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.onsetdate.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.description.label",'Common')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel("Common.Stage.label",'COMMON')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.code.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.scheme.label",'Common')+"</b></td></tr>"+strtext+"</table>";
				strtext="<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class=''  style='font-size:12'><b>"+getLabel("Common.Accuracy.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.onsetdate.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.description.label",'Common')+"</b></td><td align='center' class=''  style='font-size:12'><b>"+getLabel("Common.Stage.label",'COMMON')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.code.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("Common.scheme.label",'Common')+"</b></td><td align='center' class='' style='font-size:12'><b>"+getLabel("eCA.DiagnosisRemarks.label",'ca')+"</b></td></tr>"+strtext+"</table>";//38981

			}
			else
			{
				strtext= strtext_header+" "+strtext+"</table>";
			}
		}     //38981 end
			returnValue=strtext;
			returnValue=encodeURIComponent(returnValue,"UTF-8");//IN038773
		}
		//IN052716 End.
	}
	else if(return_format=="TEXT")
	{
		//returnValue=parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.forms[0].temp.value;
		returnValue=encodeURIComponent(parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.getElementById('finalDiv1').innerText,"UTF-8");//IN038773
		
	}
	else
	{
	
	
		//38981 start
	if(str==null || str == '' || str == " "){
		//returnValue='';	
	}
	else
		{
		   if(includestatus == "Y")
			{ 
			   if(str_header==null || str_header == '' || str_header == " ")
				{ 
				
				   //str="<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel("Common.Accuracy.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.onsetdate.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.description.label",'Common')+"</b></td><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel("Common.Stage.label",'COMMON')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.code.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.scheme.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("eCA.DiagnosisRemarks.label",'ca')+"</b></td></tr>"+str+"</table>";
				   str="<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel("Common.Accuracy.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.onsetdate.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.description.label",'Common')+"</b></td><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel("Common.Stage.label",'COMMON')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.code.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.scheme.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("eCA.DiagnosisRemarks.label",'ca')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("eCA.SupportingDiag.label",'ca')+"</b></td></tr>"+str+"</table>";


				}
				else
				{
					str= str_header+" "+str+"</table>";
				}
			}  
		   else
		   {
	      if(str_header==null || str_header == '' || str_header == " ")
	         {
	//	str="<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel("Common.Accuracy.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.onsetdate.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.description.label",'Common')+"</b></td><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel("Common.Stage.label",'COMMON')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.code.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.scheme.label",'Common')+"</b></td></tr>"+str+"</table>";
		str="<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel("Common.Accuracy.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.onsetdate.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.description.label",'Common')+"</b></td><td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+getLabel("Common.Stage.label",'COMMON')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.code.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("Common.scheme.label",'Common')+"</b></td><td align='center' class='columnHeadercenter' style='font-size:12'><b>"+getLabel("eCA.DiagnosisRemarks.label",'ca')+"</b></td></tr>"+str+"</table>";//38981
	}
	else
	{
		str= str_header+" "+str+"</table>";
	}
     }//38981 end
	returnValue=str;
	returnValue=encodeURIComponent(returnValue,"UTF-8");//IN038773
	}
	}
	returnValue = returnValue.replaceAll("+","%20");//IN036181
	if(returnValue=='')
	alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));
	else
	{
		parent.window.returnValue=decodeURIComponent(returnValue,"UTF-8");//IN036181
	//	parent.window.returnValue=trimString(returnValue);//IN038773
		parent.window.close();	
	}
	
}

function clearFormApprove()
{

	if(parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm != null)
	{
	var return_format=parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value;
	
	var sec_hdg_code = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.result_linked_rec_type.value;

	parent.RecClinicalNotesLinkDiagSelectedTextFrame.document.location = "../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&return_format="+return_format+"&flag=clear&ret_str=";
	
	/*var obj = parent.RecClinicalNotesLinkDiagResultFrame.document.getElementById("chkbox");
//	alert(obj.length);
	for(i=0;i<obj.length;i++)
	obj[i].checked = false;*/
	for(cnt=0; cnt<parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.count.value; cnt++)
	{
			val = eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.chkbox"+cnt);
			strval=eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.chk_value"+cnt+".value");
						
            val.checked = false

	}

	parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.ctrlChkBox.checked=false
	}
	
}

function chgretn(Obj)
{

if(Obj.value == 't')
parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value='TEXTLINK';
else
parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value='';

}
function alignWidthIcd()
{
	var totalRows =  document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = document.getElementById("dataTitleTable").rows(0).cells.length;
	for(var i=0;i<temp;i++) 
	{
		document.getElementById("dataTitleTable").rows(0).cells(i).width=document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
	}
}

function scrollTitleIcd()
{
   var y = document.body.scrollTop;
   if(y == 0){
		document.getElementById("divDataTitle").style.position = 'static';
   }else{
		document.getElementById("divDataTitle").style.position = 'relative';
		document.getElementById("divDataTitle").style.posTop  = y-2;
   }
}

function CheckForSpecCharsNoCaps(event)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*. ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function closew(code)
{
	window.returnValue = code;
	window.close();
}

function showLongDescription(a)
{
	var dialogHeight= "20" ;
    var dialogWidth = "23" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	window.showModalDialog("../../eMR/jsp/PatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
}
//IN037164 - Start
function showToolTip(obj,authorizeyn)
{
	var displayText = '<table cellpadding=0 cellspacing=0 border=0><td class=YELLOW>'
	
	if(authorizeyn == 'N')
	{
		displayText += getLabel("eCA.ClicktoAuthorize.label","CA");
	}

	displayText += '</td></table>';
	document.getElementById("authorizeMode").innerHTML = displayText;
	document.getElementById("authorizeMode").style.top  = obj.offsetTop+15; 
	document.getElementById("authorizeMode").style.left  = obj.offsetLeft-20 ;
	document.getElementById("authorizeMode").style.visibility='visible' ;
}

function hideToolTip()
{
	document.getElementById("authorizeMode").style.visibility='hidden' ;
}

async function CallAuathorize(patientid,mode,authorize,term_set_id,diagtype,encounter_id,diagcode,from_date_time,to_date_time,encstatus,prob_status,result_linked_rec_type,sec_hdg_code,orderby1,orderby2)
{
	var params="term_set_id="+term_set_id+"&diagtype="+diagtype+"&encounter_id="+encounter_id+"&diagcode="+diagcode+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_id="+patientid+"&encstatus="+encstatus+"&radio="+prob_status+"&result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"&orderby1="+orderby1+"&orderby2="+orderby2;
	if(authorize == 'Y')
	{
		var ind= params.lastIndexOf("&authorize");
		if(ind!=-1)
			params=params.substring(0,ind);
		params+="&authorize=N";
		window.location.href='RecClinicalNotesLinkDiagResult.jsp?'+params;
	}
	else
	{
		var val1 = 'V' ;
		var val2 = 'Ass' ;
		var val3='C'
		if('<%=context_value%>'=="PatientQueue")
			val3="O";
		var val = val1+'/'+val2+'/'+val3+'/';
		var retVal = 	new String();
		var dialogHeight= "9" ;
		var dialogWidth	= "25" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments	= "" ;
					
		retVal =await window.showModalDialog("AuthorizeMRAccess.jsp?constr="+val,arguments,features);

		if(retVal=="T")
		{	
			var ind= params.lastIndexOf("&authorize");
			if(ind!=-1)
				params=params.substring(0,ind);
			params+="&authorize=Y";
			window.location.href='RecClinicalNotesLinkDiagResult.jsp?'+params;
		}
		else
		{
			var ind= params.lastIndexOf("&authorize");
			if(ind!=-1)
				params=params.substring(0,ind);
			params+="&authorize=N";
			window.location.href='RecClinicalNotesLinkDiagResult.jsp?'+params;
		}
	}
			
}
//IN037164 - End
//IN061907 start
function selectall()
{
	var return_format=parent.RecClinicalNotesLinkDiagCriteriaFrame.document.forms[0].return_format.value;
	
	var sec_hdg_code = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.sec_hdg_code.value;
	var result_linked_rec_type = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.result_linked_rec_type.value;
	var call_from_link_doc_btn = parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.call_from_link_doc_btn.value;
	var val ="";
	var retstr2="";
    var strval="";
	parent.messageFrameReference.location.href="../../eCommon/html/blank.html"
	
	for(cnt=0; cnt<parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.count.value; cnt++)
	{
		
		val = eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.chkbox"+cnt);
		if(!val.checked)
		{
			val.checked = true;
		strval=eval("parent.RecClinicalNotesLinkDiagResultFrame.document.RecClinicalNotesLinkDiagResultForm.ret_value"+cnt);
		retstr2 = retstr2 + strval.value+"�";
		}
		
		
	}
	
	HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/RecClinicalNotesLinkDiagSelectedText.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+retstr2+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'><input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'><input type=hidden name='result_linked_rec_type' id='result_linked_rec_type' value='"+result_linked_rec_type+"'><input type=hidden name='call_from_link_doc_btn' id='call_from_link_doc_btn' value='"+call_from_link_doc_btn+"'></form>";
	parent.messageFrameReference.document.body.insertAdjacentHTML('beforeend',HTMLVal);
	
	parent.messageFrameReference.document.dummy_form.target = "RecClinicalNotesLinkDiagSelectedTextFrame";
	parent.messageFrameReference.document.dummy_form.submit();
	parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;	
}	
//IN061907 ends

