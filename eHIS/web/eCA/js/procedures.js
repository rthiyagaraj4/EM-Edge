/*
-----------------------------------------------------------------------
Date       		Edit History     	 	  Name        	Description
-----------------------------------------------------------------------
25/01/2013    	IN037196			 Ramesh Kannnan S 	Alpha-CA-Record Procedures-Modified details are not displayed .
20/01/2012		CHL-CRF [IN035950]	 Ramesh G			CHL-CRF [IN035950]
05/03/2013		CHL-CRF [IN038313]	 Nijitha S			CHL-CRF [IN038313]
------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------
05/08/2015	IN037505		Karthi L	?			?				[SRR20056-SCF-9373 ] - After select Start Date/time and Duration, System doesn?t calculate and display Ending date/time.
15/03/2022  36285          Hariharan k       	           MMs-DM-CRF-0221.v1.0(003)
-------------------------------------------------------------------------
*/

var viewErrButton='';



function apply() 
{
	var frameRef=parent.frame2;
	var procCode = frameRef.document.OPProc_form.code.value;	
	var encounterID = frameRef.document.OPProc_form.encounterid.value;
	var startDate = frameRef.document.OPProc_form.date;
	var endDate    = frameRef.document.OPProc_form.enddate;
	var locale	= frameRef.document.OPProc_form.locale.value;


	var enablePriSecProc = "N";// 36285
	if(frameRef.document.OPProc_form.enablePriSecProc)
		enablePriSecProc = frameRef.document.OPProc_form.enablePriSecProc.value;// 36285
	var format = "DMYHM";
	if(!ValidateStartDateTime1(startDate,endDate,format,locale,frameRef))// 36285
		return false;// 36285

	
	if(enablePriSecProc == "Y"){// 36285
		


		var fields = new Array (frameRef.document.OPProc_form.code_set,
						frameRef.document.OPProc_form.code,
						frameRef.document.OPProc_form.description1,
						frameRef.document.OPProc_form.classifition_type,// 36285
						frameRef.document.OPProc_form.date,
						frameRef.document.OPProc_form.practitioner
	
						
						)
	
	}
	
	else{	
		
		
		var fields = new Array (frameRef.document.OPProc_form.code_set,// 36285
					frameRef.document.OPProc_form.code,
					frameRef.document.OPProc_form.description1,
					frameRef.document.OPProc_form.date,
					frameRef.document.OPProc_form.practitioner
					)}
	
	if(enablePriSecProc == "Y"){// 36285
		
		var names = new Array (getLabel("eCA.ProcedureSet.label","CA"),getLabel("Common.ProcedureCode.label","COMMON"),getLabel("Common.description.label","Common"),getLabel("eCA.ClassificationType.label","CA"),getLabel("Common.date.label","Common"),getLabel("Common.practitioner.label","Common"));
		}// 36285
	
	else{
		var names = new Array (getLabel("eCA.ProcedureSet.label","CA"),getLabel("Common.ProcedureCode.label","COMMON"),getLabel("Common.description.label","Common"),getLabel("Common.date.label","Common"),getLabel("Common.practitioner.label","Common"));
	}// 36285
	
	
	
	
	/*
	 * alert("------------enablePriSecProc------>"+enablePriSecProc);//36285
	 * if(enablePriSecProc == "N"){//36285
	 * fields.push(frameRef.document.OPProc_form.classifition_type);//36285
	 * names.push(getLabel("eCA.ClassificationType.label","CA"));//36285 }
	 */
	
	var obj = new Array (frameRef.document.OPProc_form.code,
					frameRef.document.OPProc_form.hpi,
					frameRef.document.OPProc_form.proceduresummary,
					frameRef.document.OPProc_form.findings,
					frameRef.document.OPProc_form.impression,
					frameRef.document.OPProc_form.disposition,
					frameRef.document.OPProc_form.anaesthesDet,
					frameRef.document.OPProc_form.indication,
					frameRef.document.OPProc_form.monitor,
					frameRef.document.OPProc_form.events,
					frameRef.document.OPProc_form.postProcedure,
					frameRef.document.OPProc_form.specimen);

				var lab = new Array (getLabel("Common.ProcedureCode.label","COMMON"),getLabel("eCA.HPI.label","CA"),getLabel("eCA.ProcedureSummary.label","CA"),getLabel("Common.Findings.label","Common"),getLabel("eCA.Impression.label","CA"),getLabel("Common.Disposition.label","Common"),getLabel("Common.AnaesthesiaDetails.label","Common"),getLabel("eCA.Indication.label","CA"),getLabel("Common.Monitoring.label","Common"),getLabel("Common.Events.label","COMMON"),getLabel("eCA.PostProcedureStdOrders.label","CA"),getLabel("eCA.SpecimenSent.label","CA"));
				//var lab = new Array ("Procedure Code","HPI","Procedure Summary","Findings","Impression","Disposition","Anaesthesia Details","Indication ","Monitoring","Events","Post Procedure Std. Orders" ,"Specimen Sent");
				//var max	= new Array ("10","500","2000","500","200","200","500","500","500","500","500","500");
				var max	= new Array ("30","500","2000","500","200","200","500","500","500","500","500","500");
		

		var messgeFrameRef;
		var modal_yn = frameRef.document.OPProc_form.modal_yn.value;
		var mode = frameRef.document.OPProc_form.mode.value;
		var p_called_from_widget =  frameRef.document.OPProc_form.p_called_from_widget.value;
	
		if(modal_yn == "Y"){

			messgeFrameRef = parent.messageFrame;
			//alert("in if");
			//parent.frames[1].document.location.reload();			
			//parent.frame2.document.location.reload();
			//var query_string = parent.frame1.document.forms[0].qryStr.value;
			var query_string = parent.frames[1].document.forms[0].qryStr.value;
			//console.log(parent.frames[1].document.forms[0]);
			//console.log("qryStr: " + query_string)

			parent.frame3.location.href="../../eCA/jsp/PatProcQueryTools.jsp?"+query_string+"&viewErrButton="+viewErrButton;


		}else{
			//CHL-CRF Start.[IN035950]
			if(p_called_from_widget!=""){
				messgeFrameRef = parent.messageFrame;
				parent.frames[1].document.location.reload();
				var query_string = parent.frames[1].document.forms[0].qryStr.value;
				parent.frame3.location.href="../../eCA/jsp/PatProcQueryTools.jsp?"+query_string+"&viewErrButton="+viewErrButton;
			}else{
			//CHL-CRF End.[IN035950]
				messgeFrameRef = top.content.messageFrame;	
				top.content.workAreaFrame.frame1.document.location.reload();
				var query_string = top.content.workAreaFrame.frame1.document.forms[0].qryStr.value;			
				parent.frame3.location.href="../../eCA/jsp/PatProcQueryTools.jsp?"+query_string+"&viewErrButton="+viewErrButton;
			} //CHL-CRF [IN035950]
		}
		
		if(ChkFielditems(fields, names,messgeFrameRef))		
		 {
				//CHL-CRF Start.[IN035950]
				//if(CheckMaxLen1(lab,obj,max,messgeFrameRef)){
				if(CheckMaxLen1(lab,obj,max,messgeFrameRef,p_called_from_widget)){	
				//CHL-CRF End.[IN035950]
					if(mode!='update'){
            
            // by marwan for EDGE - form submission is added after form string writing through script tag to avoid racing issues
						parent.blankFrameIntermediate.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempFormProc' id='tempFormProc' method = 'post' action='../../eCA/jsp/ProceduresIntermediate.jsp'><input type='hidden' name='procCode' id='procCode' value = \""+procCode+"\"><input type='hidden' name='encounterID' id='encounterID' value = \""+encounterID+"\"><input type='hidden' name='mode' id='mode' value = \""+mode+"\"></form> <script> var form = document.getElementById('tempFormProc'); form.submit(); </script> </body></html>");
						
						// console.log(parent.blankFrameIntermediate.document);
						// parent.blankFrameIntermediate.document.getElementById("tempFormProc").submit();
					}else{
						
						frameRef.document.OPProc_form.dup_chk.value = "Y";
						frameRef.document.OPProc_form.submit();
					}
					
		 }
	}
}
//CHL-CRF Start.[IN035950]
//function CheckMaxLen1(lab,obj,max,messageFrame)
function CheckMaxLen1(lab,obj,max,messageFrame,p_called_from_widget)
//CHL-CRF End.[IN035950]
	{
		//alert(max);
	var frameRef=parent.frame2;
	var errors = "" ;
	var modal_yn = frameRef.document.OPProc_form.modal_yn.value;
	for( var i=0; i<obj.length; i++ )
	{
		if(obj[i].value.length > max[i])
		//errors = errors  +  "APP-SM0045 - " + lab[i] + " cannot exceed " + max[i]  + " characters...." + "<br>";
		errors = errors  + getMessage("REMARKS_CANNOT_EXCEED","Common")+ "<br>" ;
		errors = errors.replace('$',lab[i]);
		errors = errors.replace('#',max[i]);
	}

	if ( errors.length != 0 )
	{
		if(modal_yn == "Y")
		{
			parent.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+errors ;
		}
		else
		{
			//CHL-CRF Start.[IN035950]
			if(p_called_from_widget!=""){
				parent.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+errors ;
			}else{
			//CHL-CRF Start.[IN035950]
				top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num="+errors ;
			}//CHL-CRF [IN035950]
		}
		
		return false ;
	}
	return true ;
}


function Date_Transform (date) {
	var tst=date;
	var arr = new Array();
	arr = tst.split("/");
	var strDay = arr[0];
	var strMonth = arr[1];
	var strYear = arr[2];
	var dt1= strYear + "-" + strMonth + "-" + strDay;
}

function onSuccess()
{
/*	if(modal_yn == "Y"){

	}else{
		var query_string = top.content.workAreaFrame.frame1.document.forms[0].qryStr.value;
		top.content.workAreaFrame.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+query_string
		top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
	*/
}

function clearform(modal_yn){
	
	var mode = document.getElementById("mode").value;
	var p_called_from_widget = parent.frame2.document.forms[0].p_called_from_widget.value; //CHL-CRF [IN035950]
	if(modal_yn == "Y")
		{
		
		if(mode=="OR")
			{
				var query_string = parent.frame2.document.forms[0].qryStr.value;
				parent.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+query_string;
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}
			else
			{
			var query_string = parent.frame1.document.forms[0].qryStr.value;
			//alert('query_string.. in if...'+query_string);
			//top.content.workAreaFrame.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+query_string
			parent.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+query_string
			parent.frame3.location.href="../../eCA/jsp/PatProcQueryTools.jsp?"+query_string
			//top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}

	}
	else{
		//CHL-CRF Start.[IN035950]
		if(p_called_from_widget!=""){
			var query_string = parent.frame1.document.forms[0].qryStr.value;
			parent.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+query_string
			parent.frame3.location.href="../../eCA/jsp/PatProcQueryTools.jsp?"+query_string
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		}else{
		//CHL-CRF End.[IN035950]
			var query_string = top.content.workAreaFrame.frame1.document.forms[0].qryStr.value;		
			top.content.workAreaFrame.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+query_string
			parent.frame3.location.href="../../eCA/jsp/PatProcQueryTools.jsp?"+query_string		
			top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		}//CHL-CRF [IN035950]
	}
}

function cancel_a(modal_yn)
{
	if(modal_yn == "Y"){
		parent.window.close();
	}else{
		top.content.workAreaFrame.location.href = '../../eCommon/html/blank.html' ;
		top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";

	}
}


function ChkFielditems(fields, names, messageFrame)
{
	//	var modal_yn = frameRef.document.OPProc_form.modal_yn.value;
	var errors="";
	for (var i=0 ; i<fields.length ; i++)
	{

		if (trimCheck(fields[i].value))
		{
			fields[i].value=trimString(fields[i].value);
		}
		else

		  errors = errors + getMessage("CAN_NOT_BE_BLANK","Common")	+ "<br>" ;
		  errors = errors.replace('$',names[i]);
	
	 }
	 if (errors.length !=0)
   		{
			//	 if(modal_yn == "Y"){
			//			parent.messageFrame.document.location.href="../../eCA/jsp/error1.jsp?err_num="+errors;
			//	 }else{
					//parent.scrolling = "yes";
					messageFrame.document.location.href="../../eCA/jsp/error1.jsp?err_num="+errors;
					//top.location.href="../../eCA/jsp/error1.jsp?err_num="+errors;
						
					//alert("messageFrame.scrolling"+messageFrame.scrolling);

			//	}
	 		return false ;
		 }
	 return true ;
 }

 function Date_Transform (transform,messageFrame) {
 		dateset = transform[0];
 		dateset1 = transform[1];
 		if(dateset1.value=="") {
 			dateset.value="";
 		}
 		else {
 			var tst=dateset1.value;
 			var arr = new Array();
 			arr = tst.split("/");
 			var strDay = arr[0];
 			var strMonth = arr[1];
 			var strYear = arr[2];
 			var dt= strYear + "-" + strMonth + "-" + strDay;
 			dateset.value= dt;

 		}
 	}

////////////////////// function related to Canned Text
function closeCannedTextWindow()
{
//	alert(1);
	var text_blk_id = "", text_blk = "", block_id = "";
	var returnArray		= new Array();
	var arrTextBlockID	= new Array();
	var arrTextBlock	= new Array();
	//to put some value in the clipboard
	if(document.forms[0].select!=null)
	{
//		console.log(document.forms[0].select);
//		var clipBoardVal=document.forms[0].select.createTextRange();
//		clipBoardVal.select();
//		clipBoardVal.execCommand("copy","","");
		
		var inputElement = document.forms[0].select;
	    inputElement.select();
	    document.execCommand("copy");
	}
	//ends here	
	var totalBlocks	= parent.RecClinicalNotesCTFrame.document.forms[0].totalBlocks.value;
	var selectIndex = 0;
	var text='';
	for(var i=0; i<totalBlocks; i++)
	{
		block_id		=	eval("parent.RecClinicalNotesCTFrame.document.forms[0].block_id"+i);
		if(block_id.checked==true)
		{
			text_block_id		=	eval("parent.RecClinicalNotesCTFrame.document.forms[0].text_blk_id"+i).value;
			text_block			=	eval("parent.RecClinicalNotesCTFrame.document.getElementById('text_blk"+i+"')").innerText ;
			

			arrTextBlockID[selectIndex]	=	text_block_id; 
			arrTextBlock[selectIndex]	=	text_block; 
			selectIndex++;
			text=text+text_block;
		}
	}
//alert('arrTextBlockID=>'+arrTextBlockID);
//alert('arrTextBlockID=>'+arrTextBlock);
//arrTextBlock=arrTextBlock
	returnArray[0] = arrTextBlockID;
	returnArray[1] = arrTextBlock;
	var returnArray1=returnArray[1];
	parent.window.returnValue = text;
	parent.parent.document.getElementById("dialog_tag").close(); 
}


function checkminutes1(obj,flag,format){
	
	var locale =document.forms[0].locale.value;
	if(obj != "" ){
		if(isAfterNow(obj.value,format, locale)){
			if(flag=='S'){
			alert(getMessage("FROM_DATE_GREATER_SYSDATE","CA"));
			
			}
			else{
			document.OPProc_form.Hrs.value="0";
			document.OPProc_form.Min.value="0";	
			alert(getMessage("END_TIME_MORE_SYS_TIME","CA"));
			}
	    obj.value="";
//	    obj.select();
	    obj.focus();
	    return false;
       }
	   else
         return true;
	 }

}
function ValidateStartDateTime1(frodate,toodate,format,locale,frameRef1)
{
	var frdate = frodate.value;
	var todate = toodate.value;
	
	/*if(!validDateObj(frodate,"DMYHM",locale) || !validDateObj(toodate,"DMYHM",locale) )
	{
		return false;
	}*/
	
	if(frdate != "" )
	{
		//alert('here 2');
		if(!isBeforeNow(frdate,format, locale))
		{
			alert(getMessage("START_TIME_LESS_SYS_TIME","CA"));
			frodate.focus();
			return false;
		}
		else
		{	
			if(todate != "")
			{
				if(!isBeforeNow(todate,format, locale))
				{
					alert(getMessage("END_TIME_MORE_SYS_TIME","CA"));
					toodate.focus();
					return false;
				}

				if(!isAfter(todate,frdate,format,locale) )
				{
					alert(getMessage("END_TIME_LESS_START_TIME","CA"));
//					frameRef1.Hrs.value = 0;
//					frameRef1.Min.value = 0;	
					toodate.focus();
					return false;
				}

			}
		}
	}

	return true;
}
			
				
/*
function ValidateEndDateTime1(date,obj,flag,format)
{
	var locale =document.forms[0].locale.value;
	if(obj != "" ){
		if(checkminutes1(obj,flag,format)){
			if(!isBeforeNow(obj.value,format, locale)){
				alert(getMessage("START_TIME_LESS_END_TIME","CA"));
				obj.value="";
				//obj.select();
				document.forms[0].Hrs.value = 0;
				document.forms[0].Min.value = 0;
				obj.focus();
				return false;
			}
			else{
	
				return true;
			}
		}
	}
}


function callDateStartVisit(from,today,format) 
{ 
	 if(from.value != "" && today.value !="" )
	 {	
		var locale =document.forms[0].locale.value;
			
		if(isBefore(from.value, today.value, format, locale))
		{
			var msg = getMessage("START_GR_EQ_VISIT","CA")
			alert(msg);
			from.focus();
			from.select();
			return false;
		}
		else 
			return true;
	 }
	 return true;
}
*/


//Functions for the file name ProcQueryResult.jsp && PatProcViewErrorList.jsp-start

function callDetails(code, pat_id, srl_no,term_set_id,encounter_id){
	var modal_yn = document.forms[0].modal_yn.value;
	var p_called_from_widget = document.forms[0].p_called_from_widget.value;
	//CHL-CRF Start.[IN035950]
		//parent.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+document.forms[0].qryStr.value+"&mode=update&code="+code+"&pat_id="+pat_id+"&srl_no="+srl_no+"&term_set_id="+term_set_id+"&encounter_id1="+encounter_id;
		parent.frame2.location.href="../../eCA/jsp/AddModifyOPProc.jsp?"+document.forms[0].qryStr.value+"&mode=update&code="+code+"&pat_id="+pat_id+"&srl_no="+srl_no+"&term_set_id="+term_set_id+"&encounter_id1="+encounter_id+"&p_called_from_widget="+p_called_from_widget;
		//parent.frame3.location.href='../../eCA/jsp/PatProcQueryTools.jsp?errorModify=Y&patient_id='+document.forms[0].Patient_Id.value+'&Encounter_Id='+document.forms[0].Encounter_Id.value+'&modal_yn='+modal_yn+'&mode=update';	
		parent.frame3.location.href='../../eCA/jsp/PatProcQueryTools.jsp?errorModify=Y&patient_id='+document.forms[0].Patient_Id.value+'&Encounter_Id='+document.forms[0].Encounter_Id.value+'&modal_yn='+modal_yn+'&mode=update'+"&p_called_from_widget="+p_called_from_widget;	
	//CHL-CRF End.[IN035950]
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	

}

async function showDetails( proCode,srl_no){
					var patient_id=document.forms[0].patient_id.value;
					var retVal;
					var dialogHeight="80vh;";//updated by Arvind @ 05-12-08
					var dialogWidth="65vw;";
//					var dialogTop=200; +'; dialogTop:' + dialogTop +
					var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
					retVal= await top.window.showModalDialog('../../eCA/jsp/PatProcViewErrorListDet.jsp?patient_id='+patient_id+'&proCode='+proCode+'&srl_no='+srl_no,arguments,features);	 
		}

async function showDescription(obj)
{
	var dialogHeight= "290px;" ; //Updated by Arvind @ 04-12-08
    var dialogWidth = "450px;" ;
	var a = document.forms[0].description.value;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
	//window.showModalDialog("../../eMR/jsp/RecDaignosisLongDescDialog.jsp?longDesc="+a,"",features);
	await window.showModalDialog("../../eCA/jsp/PatProcLongDescDialog.jsp?longDesc="+a,"",features);
}
function scrollTitle(){
	  var y = document.body.scrollTop;

	  if(y == 0){
		document.getElementById("divDataTitle").style.position = 'static';
		document.getElementById("divDataTitle").style.posTop  = 0;
	  }else{
		document.getElementById("divDataTitle").style.position = 'relative';
		document.getElementById("divDataTitle").style.posTop  = y-2;
	  }
}


//Functions for the file name ProcQueryResult.jsp && PatProcViewErrorList.jsp-end


//Functions for the file name AddModifyOPProc.jsp-start
//var dt1
function checkIsNull(obj)
	{
		if(trimCheck(obj.value)=='')
			return true;
		else
			return false;
	}


function callCheckDateTime(dateTimeObj)
{
	//Below condition is added by Archana Dhal on 20/01/ 2010 related to IN18233
	var visit_adm_date_time = "";
	l_locale = document.OPProc_form.locale.value; // added for SRR20056-SCF-9395 [IN037505]
	
	if(document.OPProc_form.visit_adm_date_time != null)
	{
	  visit_adm_date_time=document.OPProc_form.visit_adm_date_time.value;
	  //Below end of brace is commented by Archana Dhal on 3/31/2010.
	//}
	
	//if(checkIsNull(dateTimeObj))
		//return false;
	if(dateTimeObj.value !="")
	{
       //Below condition is commented by Archana Dhal on 4/8/2010 related to IN20580
		/*if(validDateObj(dateTimeObj,'DMYHM')==false){		
			//alert(getMessage("INVALID_DATE_TIME","CA"));
				dateTimeObj.value='';
				document.forms[0].Hrs.value = 0;
				document.forms[0].Min.value = 0;
				dateTimeObj.select();
				return false;
		}*/
		// commented for SRR20056-SCF-9395 [IN037505] - Start
		/*if(doDateTimeChk(dateTimeObj)==false)	
			{
				alert(getMessage("INVALID_DATE_TIME","CA"));
				dateTimeObj.value='';
				document.forms[0].Hrs.value = 0;
				document.forms[0].Min.value = 0;
				return false;
			}

			else
			{
				if( document.OPProc_form.modal_yn.value == "Y"){
					parent.messageFrame.location.href = "../../eCA/jsp/CAError.jsp";			
				}else{
					//top.content.messageFrame.location.href = "../../eCA/jsp/CAError.jsp";//[IN038313]
					//[IN038313] Starts
					if(null!=top.content && null!=top.content.messageFrame)
					{
					top.content.messageFrame.location.href = "../../eCA/jsp/CAError.jsp";
					}
					//[IN038313] Ends
				}
				
			} */
			// commented for SRR20056-SCF-9395 [IN037505] - End
			//Below condition is added by Archana Dhal on 4/8/2010 related to IN20580
			//if(validDateObj(dateTimeObj,'DMYHM')==false){	 - commented for SRR20056-SCF-9395 [IN037505]
			if(validDateObj(dateTimeObj,'DMYHM',l_locale)==false){	// added for SRR20056-SCF-9395 [IN037505]
			//alert(getMessage("INVALID_DATE_TIME","CA"));
				dateTimeObj.value='';
				document.forms[0].Hrs.value = 0;
				document.forms[0].Min.value = 0;
				dateTimeObj.select();
				return false;
		    }
			if(isAfter(dateTimeObj.value,visit_adm_date_time, "DMYHM",l_locale)) // added for SRR20056-SCF-9395 [IN037505]
			//if(isAfter(dateTimeObj.value,visit_adm_date_time, "DMYHM")) - commented for SRR20056-SCF-9395 [IN037505]
				return true;
			else
			{
				alert(getMessage("CANNOT_BE_GREATER_THAN_ADM_DATE","CA")); 
        dateTimeObj.value = '';
				dateTimeObj.select();				
				return false;
			}

		}	
   }//null condition end here.Modified by Archana Dhal on 3/31/2010 related to IN020388.
}
function DateTransform1 (date)
	{
		var tst=date;
		var arr = new Array();
		arr = tst.split("/");
		var strDay = arr[0];
		var strMonth = arr[1];
		var strYear = arr[2];
		var dt1= strYear + "-" + strMonth + "-" + strDay;
		return dt1
	}

function checkproccode(obj)
	{

		if (obj.value == null || obj.value =='' || obj.value == ' ')
		{ 
         var msg= getMessage("CAN_NOT_BE_BLANK",'Common');
		 msg= msg.replace('$',getLabel("CA.ProcedureCode.label","CA"))
		parent.frames[1].frames[1].frames[1].frames[2].document.write(msg);
	}
}

function showCalendarValidate(str){
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}

function getObject(obj){
		parent.frame3.document.forms[0].objName.value=obj.name;
}


//Functions for the file name AddModifyOPProc.jsp-end

//Functions for the file name PatProcQueryTools.jsp-start

async function showErrorList(){
					var patient_id=document.forms[0].patient_id.value;
					var retVal;
					var dialogHeight="600px;";//Updated by Arvind @ 05-12-08
					var dialogWidth="900px;";
					var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
				retVal= await window.showModalDialog('../../eCA/jsp/PatProcViewErrorList.jsp?patient_id='+patient_id,arguments,features);	
				
}

function markError()
{	
	var curr_level	= parent.frame2.document.OPProc_form.curr_level.value;
	if(curr_level != "")
		var current_level = parseInt(curr_level,10);		
	if(current_level > 0)
	{
		confirm_flag = confirm(getMessage("RECODING_IN_PROGRESS","MR"));

		if(confirm_flag)
			markingAsError();
	}
	else
	{
		markingAsError();			
	}
}


async function markingAsError()
{
	var value=parent.frame2.document.forms[0].errorRemarks.value;
	var locale	= parent.frame2.document.OPProc_form.locale.value;
	var comments;
	var retVal;
	var dialogHeight = '250px;' ;
	var dialogWidth = '350px;' ;
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	retVal 			= await window.showModalDialog('../../eCA/jsp/RemarksDialog.jsp?allDia=Y&resultStr='+encodeURIComponent(value,"UTF-8")+'&locale='+locale,arguments,features);	
	if(retVal != null && retVal != '' && retVal != undefined)
	{											
		viewErrButton='Y';	
		parent.frame2.document.forms[0].errorRemarks.value=retVal;				
		parent.frame2.document.getElementById("disMar").innerHTML="<font color=yellow  size=2>Marked for Error &nbsp;&nbsp;</font>";	
	}
	else if(retVal == undefined)
	{
		viewErrButton='Y';
		parent.frame2.document.forms[0].errorRemarks.value=value;				
		parent.frame2.document.getElementById("disMar").innerHTML="<font color=yellow  size=2>Marked for Error &nbsp;&nbsp;</font>";	

	}
	else
	{
		viewErrButton='N';	
		parent.frame2.document.getElementById("disMar").innerText="";
		parent.frame2.document.forms[0].errorRemarks.value="";
	}	

}

async function canTextValue(){
	if (document.forms[0].objName.value==''){
			document.forms[0].objName.value='dummy';
	}
	
	var obj=eval("parent.frame2.document.forms[0]."+document.forms[0].objName.value);
	
	var Encounter_Id=document.forms[0].Encounter_Id.value;
	var dialogHeight	=	"400px;" ;
	var dialogWidth	    =	"600px;" ;//updated by Arvind @ 05-12-08
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/PatProcCannedTextMain.jsp?Encounter_Id='+Encounter_Id;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status;
	retArray			=	await window.showModalDialog(action_url,arguments,features);
	//alert("===="+retArray+"=====");
	var arrTextBlockID;	
	var arrTextBlock;	
	//	if( retArray != null ){
		if( retArray != null && retArray != ''){
			obj.value=retArray;
			//obj.focus();
		}	
	document.forms[0].objName.value='';
}

/*
function allowDateFormat(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		return true ;	
}
*/
//Functions for the file name PatProcQueryTools.jsp-end
var flag= true;
function populatePractitioner(val)
{
 if(document.forms[0] != null)
	{
	var practitioner=document.forms[0].practitioner.options.value;
	escape(practitioner);
		var messgeFrameRef;
		var frameRef=parent.frame2;
		
		var modal_yn = frameRef.document.OPProc_form.modal_yn.value;
	
		if(modal_yn == "Y"){
///						alert();
///						alert(parent.messageFrame);
			messgeFrameRef = parent.messageFrame;

		}else{
			messgeFrameRef = top.content.messageFrame;
		}

	if(document.forms[0].practitioner.options.selectedIndex!=0)
	{
		document.forms[0].practitioner1.disabled=false;
	}
	else if(document.forms[0].practitioner.options.selectedIndex==0)
	{
		document.forms[0].practitioner1.disabled=true;
	}
	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><BODY onKeyDown='lockKey()' CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='PopulateProcedureValues.jsp?pract_name="+practitioner+"'></form></BODY></HTML>";
		messgeFrameRef.document.write(HTMLVal);
		messgeFrameRef.document.forms[0].submit();

//var mode = frameRef.document.OPProc_form.mode.value;
if(val!="first")
delete_values(frameRef.document.forms[0].practitioner1);
		
	}

}

function delete_values(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
	selected.remove(selected.options[0]);
	var opt		=	parent.frames[1].document.createElement("OPTION");
	opt.text	=	"     ------ Select ------     ";
	opt.value	=	"";
	field.add(opt);
}

function checkPractitioner()
{
if(document.forms[0] != null)
	{
	
	//document.forms[0].searchpract2.disabled=true;
	}
}

// this function has no name !! 
// ----------------------------
//function (field)
//{
//	var mode=document.forms[0].mode.value;
//	var selected = field;
//	if(mode=='update')
//	{
//		var pract=document.forms[0].practitioner.value;
//		var obj=pract.split('|');
//		for(i=0;i<(obj.length-1);i++){
//				name=obj[i];
//				//alert(name);
//		}
//		//alert(pract);
//		for(i=0;i< selected.options.length;i++)
//		{	//alert('hii');
//		//alert(selected.options[i].value);
//			if(name==(selected.options[i].value)){
//				//alert('hii');
//			selected.remove(selected.options[i]);
//			}
//		}
//	}
//}

function chkDupPract(obj)
{	
	if(obj.name == "practitioner")
	{ 
		var listValue = obj.value;
		var split_id = listValue.split("|");
		var doc_id = split_id[0];
		


		if(document.OPProc_form.practitioner1.value != "")
		{
			if(doc_id == document.OPProc_form.practitioner1.value)
			{   
				alert(getMessage("PRACT_CHOSEN","CA"));
				document.OPProc_form.practitioner.value = "";
			}
		}
	}
	else if(obj.name == "practitioner1")
	{
		var doc_id = obj.value;
		if(document.OPProc_form.practitioner.value != "")
		{
			var doc1_id_name = document.OPProc_form.practitioner.value;
			var split_id = doc1_id_name.split("|");
			var doc1_id = split_id[0];
		}
		if(doc_id == doc1_id)
		{
			alert(getMessage("PRACT_CHOSEN","CA"));
			document.OPProc_form.practitioner1.value = "";
		}
	}
	else if(obj.name == "anaesthetists1")
	{
		var anaes1 = document.OPProc_form.anaesthetists1.value;
		var anaes2 = document.OPProc_form.anaesthetists2.value;
		var anaes3 = document.OPProc_form.anaesthetists3.value;
		if(anaes1 != "" && anaes2 != "")
		{
			if(anaes1 == anaes2)
			{   
				alert(getMessage("ANAES_ALREADY_CHOSEN","CA"));
				document.OPProc_form.anaesthetists1.value = "";
			}
		}
		if(anaes1 != "" &&  anaes3 != "")
		{
			if(anaes1 == anaes3)
			{
				alert(getMessage("ANAES_ALREADY_CHOSEN","CA"));
				document.OPProc_form.anaesthetists1.value = "";
			}
		}
	}
	else if(obj.name == "anaesthetists2")
	{
		var anaes1 = document.OPProc_form.anaesthetists1.value;
		var anaes2 = document.OPProc_form.anaesthetists2.value;
		var anaes3 = document.OPProc_form.anaesthetists3.value;
		if(anaes2 != "" && anaes1 != "")
		{
			if(anaes2 == anaes1)
			{
				alert(getMessage("ANAES_ALREADY_CHOSEN","CA"));
				document.OPProc_form.anaesthetists2.value = "";
			}
		}
		if(anaes2 != "" &&  anaes3 != "")
		{
			if(anaes2 == anaes3)
			{
				alert(getMessage("ANAES_ALREADY_CHOSEN","CA"));
				document.OPProc_form.anaesthetists2.value = "";
			}
		}
	}
	else if(obj.name == "anaesthetists3")
	{
		var anaes1 = document.OPProc_form.anaesthetists1.value;
		var anaes2 = document.OPProc_form.anaesthetists2.value;
		var anaes3 = document.OPProc_form.anaesthetists3.value;
		if(anaes3 != "" && anaes1 != "")
		{
			if(anaes3 == anaes1)
			{
				alert(getMessage("ANAES_ALREADY_CHOSEN","CA"));
				document.OPProc_form.anaesthetists3.value = "";
			}
		}
		if(anaes3 != "" && anaes2 != "")
		{
			if(anaes3 == anaes2)
			{
				alert(getMessage("ANAES_ALREADY_CHOSEN","CA"));
				document.OPProc_form.anaesthetists3.value = "";
			}
		}
	}
}
function showTable(obj)
{
	
	if(obj.value!=null && obj.value!=""){
		
		var code_set = obj.value;
		var split_val = code_set.split("~");
		//alert(split_val[0]);alert(split_val[1]);
		document.OPProc_form.proc_set.value = split_val[0];
		document.OPProc_form.proc_set_desc.value = split_val[1];
		//document.OPProc_form.all.proc_CODE.style.display='inline';
		//document.OPProc_form.all.proc_DESC.style.display='inline';
		document.OPProc_form.code.readOnly=false;
		//document.OPProc_form.description1.readOnly=false;
		document.OPProc_form.search_button.disabled=false;
	}else{
		//document.OPProc_form.all.proc_CODE.style.display='none';
		//document.OPProc_form.all.proc_DESC.style.display='none';	
		document.OPProc_form.code.readOnly=true;
		//document.OPProc_form.description1.readOnly=true;
		document.OPProc_form.search_button.disabled=true;
	}
	document.OPProc_form.description1.readOnly=true;
	document.OPProc_form.code.value = "";
	document.OPProc_form.description.value = "";
	document.OPProc_form.description1.value = "";
	document.OPProc_form.exclamation.style.visibility='hidden';
	
	var modal_yn = document.OPProc_form.modal_yn.value ;
	//alert("modal_yn  = "+modal_yn);
	//Commented For Script Error Issue while recording.
	/*if(modal_yn == "Y"){
		parent.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num=" ;
	}else{
		top.content.messageFrame.location.href="../../eCA/jsp/error1.jsp?err_num=";
	}*/
}
/*function show_window1()
{
	var dob = document.OPProc_form.dob.value;
	var age = document.OPProc_form.age.value;
	var sex = document.OPProc_form.sex.value;
	var searchtext = document.OPProc_form.code.value;
	var practitioner_id = document.OPProc_form.practitionernameSESSION.value;
	var term_set_id = document.OPProc_form.code_set.value;
	var p_auth_yn = "N";
	var retVal =    new String();
	var dialogHeight= "27.22" ;
	var dialogWidth = "44" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal = window.showModalDialog("../../eMR/jsp/TermCodeSearchMainFrame.jsp?term_set_id="+term_set_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex,arguments,features);

	if(retVal != null)
	{
		var arr = new Array();
		retcode = retVal.split("/");
		alert(retVal);
		document.OPProc_form.code.value = retcode;
		document.OPProc_form.code.onblur();
	}
	
}*/


async function callTermCode(obj){
	

		var temp_term_code = "";
		var term_code_associated = "";
		var mode ="";
		
		var mulitple_yn = "";
		var term_set_id= document.OPProc_form.proc_set.value;	
		var retVal = new String();
		var dialogHeight= "420px;" ;  
		var dialogWidth = "740px;" ;
		var status = "no";
		var dialogUrl       = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+document.OPProc_form.proc_set_desc.value+"&term_set_id="+term_set_id+"&mulitple_yn="+mulitple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated ;
		if(mode == '2'){
			dialogUrl+= "&Db_term_code="+term_code_associated;
		}
		var dialogArguments = term_set_id ;
		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var returnVal = await window.showModalDialog(dialogUrl, term_set_id, dialogFeatures);
		
		if( returnVal == null || returnVal == "" ){
			
		}else{
			
			var retValCode = returnVal.split("~");
			var retVal		 = retValCode[0].split("||");
			
			
			term_code		 = retVal[0];
			term_code_desc	 = retVal[1];
			term_code_desc	 = unescape(term_code_desc);
			level_desc		 = retVal[2];
			level			 = retVal[3];
		
			document.OPProc_form.code.value = term_code;
			document.OPProc_form.code.readOnly = true;
			document.OPProc_form.description1.value = term_code_desc;
			document.OPProc_form.description1.readOnly = true;
			document.OPProc_form.description.value = term_code_desc;
			document.OPProc_form.code.onblur();
		}
	
}
function populatePract_blur(obj)
{
	
	if(obj.value!='')
	{

		populatePract()
	}
	else
	{	
		document.forms[0].pract.value = "";
		document.forms[0].practitioner.value = "";
		document.forms[0].pract1.value="";
		document.forms[0].practitioner1.value = "";
		document.forms[0].pract2.value="";
		document.forms[0].practitioner2.value = "";
		document.forms[0].pract1.readOnly=true;
		document.forms[0].pract2.readOnly=true;
		document.forms[0].searchpract2.disabled= true;
		document.forms[0].searchpract3.disabled= true;

	}

}


async function populatePract()
{		
		var target			= document.forms[0].pract;
		var stdval          = document.forms[0].pract.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale =document.forms[0].locale.value;
       
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= getLabel("Common.practitioner.label","Common");

	
		//var sql="Select std_comp_id, std_comp_desc from am_standard_comp where eff_status = `E` and std_comp_result_type= `"+val+"` ";
		//var sql="Select practitioner_id, practitioner_name from am_pract_for_facility_vw where operating_facility_id = `"+facilityid+"` and eff_status = `E`";
        var sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";
/*
		search_code="a.practitioner_id";
		search_desc="b.practitioner_name";
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		
		*/
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

		//	var retVal=unescape(retVal);
			//arr=retVal.split("::");
			


		   //	document.forms[0].pract.value = arr[0];
		   
		//	document.forms[0].practitioner.value = arr[1]+"|"+escape(arr[0]);
			//alert(document.forms[0].practitioner.value);
			document.forms[0].pract.value =retVal[0].split(',')[1];
			document.forms[0].practitioner.value = retVal[0].split(',')[0];
			document.forms[0].pract1.readOnly = false;
			document.forms[0].searchpract2.disabled=false;

			if(retVal[1] == document.forms[0].pract1.value)
			{
				document.forms[0].pract.value = "";
 			    document.forms[0].practitioner.value = "";
				alert(getMessage("PRACT_SAME","CA"));

			}
			/*else
			{
		   	document.forms[0].pract.value = arr[0];
		   	document.forms[0].practitioner.value = arr[1];
			}*/
				
		}
		else
		{
			document.forms[0].pract.value = "";
			document.forms[0].practitioner.value = "";
			document.forms[0].pract1.value="";
			document.forms[0].pract2.value="";
			document.forms[0].pract1.readOnly = true;
			document.forms[0].pract2.readOnly = true;
			document.forms[0].searchpract2.disabled=true;
			document.forms[0].searchpract3.disabled=true;
			
		} 

}

async function populateNurse()
{
var target			= document.forms[0].nurse;
var facilityid      = document.forms[0].facilityid.value;
var locale			=document.forms[0].locale.value;
var retVal			=  new String();
var title			= getLabel("Common.ScrubNurse.label","COMMON");

var sql="Select b.practitioner_name description,a.practitioner_id code from am_pract_for_facility A, AM_PRACTITIONER_LANG_VW B where a.facility_id= '"+facilityid+"'and a.eff_status='E' and b.pract_type='NS' and a.practitioner_id = b.practitioner_id and b.language_id = '"+locale+"' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 1";

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
		retVal = await CommonLookup( title, argArray );
		
if (retVal != null && retVal != '' && retVal != "null")
		{
		document.forms[0].nurse.value = retVal[0].split(',')[1];
		document.forms[0].scrubnurse.value = retVal[0].split(',')[0]
		}

else
		{
			document.forms[0].nurse.value = "";
			document.forms[0].scrubnurse.value = "";
		} 

}

function populatePract2_blur(obj)
{
	
	if(obj.value!='')
	{

		populatePract2()
	}
	else
	{
		document.forms[0].pract1.value = "";
 		document.forms[0].practitioner1.value = "";
		document.forms[0].pract2.value="";
		document.forms[0].practitioner2.value = "";

		//document.forms[0].pract1.readOnly=true;
		document.forms[0].pract2.readOnly=true;
		//document.forms[0].searchpract1.disabled= true;
		document.forms[0].searchpract3.disabled= true;

	}

}


async function populatePract2()
{
		var target			= document.forms[0].pract1;
		var stdval          = document.forms[0].practitioner1.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
       
		var retVal			=  new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.practitioner.label","Common");

		var sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";

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

		if (retVal != null && retVal != '' && retVal != "null")
		{
			if(retVal[1] == document.forms[0].pract.value || retVal[1] == document.forms[0].pract2.value)
			{
				document.forms[0].pract1.value = "";
 			    document.forms[0].practitioner1.value = "";
				alert(getMessage("PRACT_SAME","CA"));
			}
			else
			{
		   	document.forms[0].pract1.value = retVal[0].split(',')[1];
		   	document.forms[0].practitioner1.value = retVal[0].split(',')[0];
			
			document.forms[0].pract2.readOnly=false;
			document.forms[0].searchpract3.disabled= false;
			}
		}
		else
		{
			document.forms[0].pract1.value = "";
			document.forms[0].pract2.value = "";
			document.forms[0].practitioner1.value = "";
			document.forms[0].pract2.readOnly=true;
			document.forms[0].searchpract3.disabled= true;
		} 
}

function populatePract3_blur(obj)
{
	
	if(obj.value!='')
	{

		populatePract3()
	}
	else
	{
		document.forms[0].pract2.value = "";
 		document.forms[0].practitioner2.value = "";
		
		//document.forms[0].pract1.readOnly=true;
		//document.forms[0].pract2.readOnly=true;
		//document.forms[0].searchpract1.disabled= true;
		//document.forms[0].searchpract2.disabled= true;

	}

}

async function populatePract3()
{
		var target			= document.forms[0].pract2;
		var stdval          = document.forms[0].practitioner2.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.practitioner.label","Common");
		
		var sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";

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

		if (retVal != null && retVal != '' && retVal != "null")
		{
			if(retVal[1] == document.forms[0].pract.value || retVal[1] == document.forms[0].pract1.value)
			{
				document.forms[0].pract2.value = "";
 			    document.forms[0].practitioner2.value = "";
				alert(getMessage("PRACT_SAME","CA"));
			}
			else
			{
		   	document.forms[0].pract2.value = retVal[0].split(',')[1];
		   	document.forms[0].practitioner2.value = retVal[0].split(',')[0];
			}
		}
		else
		{
			document.forms[0].pract2.value = "";
			document.forms[0].practitioner2.value = "";
		} 
}

async function populateLocation()
{
		var target			= document.forms[0].loc;
		var stdval          = document.forms[0].Location.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.Location.label","Common");
		
		var sql="Select a.clinic_code code , a.short_desc description from op_clinic_lang_VW a where a.FACILITY_ID = '"+facilityid+"' and a.language_id = '"+locale+"' and a.eff_status = 'E' and a.care_locn_type_ind = 'E' and  upper(a.clinic_code) like upper(?) and upper(a.short_desc) like upper(?) order by a.short_desc";

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

		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.forms[0].loc.value = retVal[0].split(',')[1];
		   	document.forms[0].Location.value = retVal[0].split(',')[0];
		}
		else
		{
			document.forms[0].loc.value = "";
			document.forms[0].Location.value = "";
		} 
}

//function callAudit(srl_no)
async function callAudit(srl_no,encounter_id) //IN037196
{
	var facility_id     = document.forms[0].facility_id.value; 
	//var Encounter_Id    = document.forms[0].Encounter_Id.value; //IN037196
	var Encounter_Id    = encounter_id; //IN037196
	var Patient_Id    = document.forms[0].Patient_Id.value; //IN037196

	var retVal			= new String();
	var dialogTop		= "20vh";  //updated by Arvind @04-12-08
	var dialogHeight	= "35vh" ;
	var dialogWidth		= "40vw" ;
	var features		= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;

	retVal = await top.window.showModalDialog('../../eCA/jsp/ViewAuditLogMain.jsp?facility_id='+facility_id+'&Encounter_Id='+Encounter_Id+'&srl_no='+srl_no+'&Patient_Id='+Patient_Id,arguments,features);//IN037196

}
function CheckForSpecChars1(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckForPromptSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*!#$%^&()+,./:<>?{}[]`~@| ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function CheckForSpecChars2(event){
	
    var strCheck ='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/._';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

//start 36285
function validatePrimaryClassificationAvaliableYN(){
	
	var patient_id= document.forms[0].patientid.value;
	
	var code_set=document.forms[0].code_set.value;
	
	var proc_code_scheme="";
	if(code_set!=''){

		var  schemvalues=code_set.split('~');
		proc_code_scheme=schemvalues[0];
		

	}
	var facility_id=document.forms[0].facility_id.value;
	var classifition_type=document.forms[0].classifition_type.value;
	
	
	
	
	var xmlDoc 		= "" ;
	var xmlHttp = new XMLHttpRequest();
	// var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrimarySecClasification.jsp?patient_id="+patient_id+"&proc_code_scheme="+proc_code_scheme+"&facility_id="+facility_id, false ) ;
	xmlHttp.send( xmlDoc ) ;
	
	responseText	= xmlHttp.responseText ;
	// console.log(responseText);
	retVal = responseText	;
	retVal = retVal.replace(/^\s+|\s+$/g,'');
	
	if(retVal==0 && classifition_type =='S'){
		alert("Primary procedure not recorded cannot proceed.");
		document.forms[0].classifition_type.value="";
		document.forms[0].classifition_type.select();
	document.forms[0].classifition_type.focus();
	
	
	}
	else if(retVal >=1 && classifition_type =='P')
	{
		alert("Already Primary procedure recorded cannot proceed. ");
		document.forms[0].classifition_type.value="";
		document.forms[0].classifition_type.select();
		document.forms[0].classifition_type.focus();
	
		
	}
	
	document.forms[0].p_classifition_type.value=classifition_type;
}
//end 36285

