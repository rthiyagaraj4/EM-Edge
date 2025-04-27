/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------

23/03/2023	   38981        Krishna Pranay   23/03/2023     Ramesh G     ML-MMOH-CRF-1986
30/03/2023    42995        Krishna Pranay   30/03/2023     Ramesh G    CA-ML-MMOH-CRF-1986
05/04/2023    43287        Krishna Pranay   05/04/2023     Ramesh G    CA-ML-MMOH-CRF-1986

--------------------------------------------------------------------------------------------------------------------
*/
async function View_Encounter(patient_id,encounter_id)
{
	var retval = "";
	var dialogHeight= "80vh" ;
	var dialogWidth	= "70vw" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;" ;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eCA/jsp/ProblemListEncounterSearchMain.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id,arguments,features);
	if(retVal!=null)
		document.radioform.encounter_id.value = retVal;
	else
		document.radioform.encounter_id.value = "";
}


function show_desc(obj)
{

	if(obj.value!="" || obj.value!= null)
	{
			var htmlVal = "";
			htmlVal = "<html><head><link ref='stylesheet' type='text\css' href='../../eCommon/html/href='../../eCommon/html/IeStyle/css'> </link> </head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> <body onKeyDown='lockKey()'> <form name=tempForm method=post action='../../eCA/jsp/ProblemListGetCodeDescription.jsp'><input type=hidden name=diag_code value='"+obj.value+"'></form></body></html>"

			if(top.content!=null)
			{
				top.content.messageFrame.document.write(htmlVal);
				top.content.messageFrame.tempForm.submit();
			}
			else
			{
				top.problemframeEncounter.document.write(htmlVal);
				top.problemframeEncounter.tempForm.submit();
			}
	}
}


function scrollTitle(){
  var x = document.body.scrollTop;
  if(x == 0){
   document.getElementById("divTitleTable").style.position = 'relative';
   document.getElementById("divTitleTable").style.posTop  = 0;  
  }else{
	document.getElementById("divTitleTable").style.position = 'relative';
	document.getElementById("divTitleTable").style.posTop  = x-2;
  }

}


function Clear_All()
{
	if(top.content!=null){
		document.forms[0].search_button.disabled=true;
		//top.content.workAreaFrame.problemsframe0.document.radioform.reset();
		document.getElementById('radioform').reset();
	}
	else
		top.problemsframe0.document.getElementById('radioform').reset();

}


/*function doDateCheck(from,to,obj,obj1) {
			if(CheckSystemDateLesser(obj,obj1)){
				if(!doDateCheckAlert(from,to)){
					alert(getMessage("FROM_DATE_GREAT_EFF",'CA'));
					obj.select();
					obj.focus();
					return false;
				}
			}
		}*/

function doDateCheck(fromDate,toDate,currDate,format,locale)
{
	if((!fromDate.value==""))
	{
		if(!isBeforeNow(fromDate.value, format, locale))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
			fromDate.value="";
			//fromDate.select();
			fromDate.focus();
			return false;
		}
		else
		{		
			if((!toDate.value==""))
			{
				if(isBeforeNow(toDate.value, format, locale))
				{
					if(isAfter(toDate.value, fromDate.value, format, locale))
						return true;
					else
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
						toDate.value="";
						toDate.focus();
						return false;
					}
			    }
				else
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					//toDate.select();
					toDate.value="";
					toDate.focus();
					return false;
				}
			}
		}	
	}
	else
	{
			if((!toDate.value==""))
			{
				if(!isBeforeNow(toDate.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					//toDate.select();
					toDate.value="";
					toDate.focus();
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

		async function show_window1(scheme,scheme_desc){			
			var s = document.radioform.scheme.value;			
			scheme_desc= document.radioform.scheme_desc.value 
			var Encounter_Id= ""//document.radioform.Encounter_Id.value ;
		    var  p_auth_yn="Y";
		     
            if (s == 5){
				var retVal = "test Value";
				var dialogHeight= "95vh" ;
				var dialogWidth = "70vw" ;
				var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
				var arguments   = "" ;
				retVal = await window.showModalDialog("../../eCA/html/eCISLUE.html",arguments,features);
				var arr = new Array();
				arr = retVal.split("|");
				var stra = arr[0];
				var strc = arr[1];
				var strb = arr[2];
				document.radioform.code.value         = stra;
            }

			if (s == 1 || s == 2){

				/*


                var retVal =    new String();
                var dialogHeight= "27.22" ;
                var dialogWidth = "44" ;
                var status = "no";
	            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
                var cause_ind='';
				retVal = window.showModalDialog("PaintConsultationFrame.jsp?title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=",arguments,features);
               */
				//new starts


	var dob = document.forms[0].dob.value;
	var age = document.forms[0].age.value;
	var sex = document.forms[0].sex1.value;
	var searchtext = ""//document.forms[0].diagprob_code.value;
	var practitioner_id = document.forms[0].Practitioner_Id.value;
	var term_set_id = document.forms[0].code_set.value;
	var Encounter_Id = document.forms[0].Encounter_Id.value;
	var speciality_code = document.forms[0].speciality_code.value;

	var p_auth_yn = "N";
	var retVal =    new String();
	var dialogHeight= "95vh" ;
	var dialogWidth = "80vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	age='47';
	//alert("dob..."+dob+"...age.."+age+"..sex.."+sex+"..searchtext.."+searchtext+"..practitioner_id.."+practitioner_id+"..term_set_id.."+term_set_id+"..Encounter_Id...."+Encounter_Id+"...speciality_code..."+speciality_code);
	retVal = await window.showModalDialog("../../eMR/jsp/TermCodeSearchMainFrame.jsp?speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);

//new ends


				if (!(retVal == null)){
                    var retdata;
                    if(scheme=="2"){
			             retdata=retVal.split("/") ;
		                retVal=retdata[0];
					}

				   document.radioform.code.value=retVal;
				   document.radioform.code.onblur();
                   document.radioform.encounter_id.focus();
				}
			}
		}

 function callForOrderBy(obj){
	  document.radioform.orderBy.value=obj;
	  funSearch();
}

	function changeColor(object){
			 scrollLeft=document.body.scrollLeft;
            if(object.style.color=='yellow'){
                reOrder='1';
                object.style.color='pink';
			  document.radioform.reOrder.value=reOrder;
               return;
            }
            if(object.style.color=='pink'){
                reOrder='2';
                object.style.color='yellow';
			  document.radioform.reOrder.value=reOrder;
                return;
            }
            reOrder='1';
            for(i=0;i<document.anchors.length;i++){
                document.anchors(i).style.color='white';
            }
            object.style.color='pink';
/*
            if(object.style.color=='white'){
                reOrder='1';
                object.style.color='pink';
			  document.radioform.reOrder.value=reOrder;
				return
            }
			
			if(object.style.color=='pink'){
                reOrder='2';
                object.style.color='white';
			  document.radioform.reOrder.value=reOrder;
			  return
            }
*/
        }


function CheckSystemDateLesser(from,today) { //args objects 1st is this object & second is the date in dd/mm/yyyy
 if(today != "" && from.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 )
				{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) < Date.parse(fromdt))
						{
							var msg =getMessage("START_DATE_GREATER_SYSDATE",'common');
							alert(msg);
							//top.messageframe.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							if(top.content!=null)
							{
								top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp?';
							}
								return true;
						}
				}
			return true;
	 }
	 return true;
}

function enableCode(obj)
{

	if(!obj.value=="")
	{
		document.forms[0].search_button.disabled=false;
		document.forms[0].code.value="";
		document.forms[0].code_desc.value="";
	}
	else 

	{
		document.forms[0].search_button.disabled=true;
		document.forms[0].code.value="";
		document.forms[0].code_desc.value="";
	}

}

function alignHeading()
{
	
	if(parent.problemsframe0.document.getElementById("th1") != null) 
	{
											
			parent.problemsframe0.document.getElementById("th1").width =	eval(document.getElementById("tb1").offsetWidth);
				
				for(j=0;j < document.getElementById("tb1").rows[0].cells.length; j++) 
				{
					
					var wid=eval(document.getElementById("tb1").rows[0].cells[j].offsetWidth);
										
					if(parent.problemsframe0.document.getElementById("th1").rows[2].cells[j] != null)
						{
						   parent.problemsframe0.document.getElementById("th1").rows[2].cells[j].width=wid;
						}
				}
	}
}

function scrollTitleForLinkEnc(){
  var x = document.getElementById("mainDiv").scrollTop;
  if(x == 0){
   document.getElementById("EncDetails").style.position = 'relative';
   //document.getElementById("EncDetails1").style.position = 'relative';
   document.getElementById("EncDetails").style.posTop  = 0;  
  // document.getElementById("EncDetails1").style.posTop  = 0;  
  }else{
	document.getElementById("EncDetails").style.position = 'relative';
	//document.getElementById("EncDetails1").style.position = 'relative';
	document.getElementById("EncDetails").style.posTop  = x-2;
	//document.getElementById("EncDetails1").style.posTop  = x-2;
  }
}

/*38981 start
function ShowRemarksDiag(curr_remarks) {
	var retVal;
	var dialogTop		= "310";
 	var dialogHeight	= "14" ;
 	var dialogWidth		= "28" ;
	var dialogLeft		= "240" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	retVal 				= window.showModalDialog("../../eCA/jsp/ShowRemarksFrame.jsp?curr_remarks="+curr_remarks,arguments,features);
 
} //38981 end
*/

//42995 start
async function ShowRemarksDiag(patientid,diag_code,term_set_id,term_code_short_desc,occur_srl_no) ///42995
{
	var dialogHeight= "37vh" ;
    var dialogWidth = "30vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var title="Remark";
	var arg = "";
	//window.showModalDialog("../../eCA/jsp/ShowRemarksFrame.jsp?curr_remarks="+encodeURIComponent(curr_remarks)+"&patient_id="+patientid+"&diag_code="+diag_code+"&term_set_id="+term_set_id+"&term_code_short_desc="+term_code_short_desc+"&occur_srl_no="+occur_srl_no+"&title="+encodeURIComponent(title),arg, features );
	await window.showModalDialog("../../eCA/jsp/ShowRemarksFrame.jsp?patient_id="+patientid+"&diag_code="+diag_code+"&term_set_id="+term_set_id+"&term_code_short_desc="+term_code_short_desc+"&occur_srl_no="+occur_srl_no+"&title="+encodeURIComponent(title),arg, features );//43287
}//42995 end

//38981 start
async function ShowSupporting(diag_code,occur_srl_no,patientid,term_set_id,title)
{ 
	var dialogHeight= "80vh" ;
    var dialogWidth = "65vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	await window.showModalDialog("../../eCA/jsp/ShowSupportingFrame.jsp?diag_code="+diag_code+"&title="+encodeURIComponent(title)+"&occur_srl_no="+occur_srl_no+"&patient_id="+patientid+"&term_set_id="+term_set_id,arguments,features);
}
//38981 end

