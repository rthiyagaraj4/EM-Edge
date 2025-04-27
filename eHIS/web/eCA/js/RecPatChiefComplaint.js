async function ViewComplaint()
{
	var encounter_id = document.RecPatChiefComplaintAddModifyForm.encounter_id.value;
	var complaint = document.RecPatChiefComplaintAddModifyForm.complaint_desc.value;
	/*Added by Archana on 5/27/2010  for IN021646*/
	complaint				= encodeURIComponent(complaint);
	var spltCode = document.RecPatChiefComplaintAddModifyForm.spltCode.value;
	/*Commented by Archana on 4/19/2010 at 10:30 AM for IN020735*/
	//var dialogHeight	= "33.75";
	//var dialogWidth		= "45";
    /*Added by Archana on 4/19/2010 at 10:30 AM for IN020735*/
	var dialogHeight	= "80vh";	
	var dialogWidth		= "80vw";
	var dialogTop		= "2";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll=auto; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";


	retVal = await window.showModalDialog("../../eCA/jsp/RecPatChiefComplaintDiagLookupMain.jsp?encounter_id="+encounter_id+"&complaint="+complaint+"&spltCode="+spltCode,arguments,features);

	if(retVal == null)
	{
		document.RecPatChiefComplaintAddModifyForm.complaint_id.value = "";
		document.RecPatChiefComplaintAddModifyForm.complaint_desc.value = "";
		document.RecPatChiefComplaintAddModifyForm.complaint_details.value = "";
	}
	else
	{
		var splitval = retVal.split("`");
		document.RecPatChiefComplaintAddModifyForm.complaint_id.value=splitval[0];
		document.RecPatChiefComplaintAddModifyForm.complaint_desc.value=splitval[1];
		document.RecPatChiefComplaintAddModifyForm.complaint_details.value=splitval[2];
	}
	document.RecPatChiefComplaintAddModifyForm.flag.value='true'
}

function apply()
{

	//CHL-CRF Start.[IN035950]
	var path="";
	if(parent.RecPatChiefComplaintAddModifyFrame!=undefined){
		path="parent.RecPatChiefComplaintAddModifyFrame."
	}
	var mode = eval(path+"document.RecPatChiefComplaintAddModifyForm.mode.value");
		
	if(mode=="insert"){		
		var open_in_modal	=	eval(path+"document.RecPatChiefComplaintAddModifyForm.open_in_modal");
	}else{
			var open_in_modal	=	parent.RecPatChiefComplaintResultFrame.document.RecPatChiefComplaintResultForm.open_in_modal;
	}
	var callFromWidget =  eval(path+"document.RecPatChiefComplaintAddModifyForm.p_called_from_widget.value");
	
	var complaint_details = eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details.value");
	var msg = "";
	var messageFrame = "";
	
	if(open_in_modal.value=="Y"){
		messageFrame= parent.AEMessageFrame;
	}else{
		if(callFromWidget==""){
			messageFrame= top.content.messageFrame; 
		}else{	
			var frame = "";
			if(top.document.getElementById('dialog-body'))
				frame=top.document.getElementById('dialog-body').contentWindow;
			else
				frame = parent;
			
			messageFrame= frame.messageFrame;			
		}
	}
	if (complaint_details != "")
	{
		if (complaint_details.length > 0 )
		{
			 msg = fnChkMaxLength(complaint_details,'Complaint details');			
		}		
	}
	if (msg == "")
	{	
 		if(mode=="insert")
		{
			/*var fields = new Array(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_desc"),eval(path+"document.RecPatChiefComplaintAddModifyForm.onset_date"),eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details"));
			var names = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"),getLabel("eCA.ComplaintDetails.label","CA"));
			var fields2 = new Array(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_desc"),eval(path+"document.RecPatChiefComplaintAddModifyForm.onset_date"),eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details"));
			var names2 = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"),getLabel("eCA.ComplaintDetails.label","CA"));*/
			// 37744 STARTS
			var fields = new Array(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_desc"),eval(path+"document.RecPatChiefComplaintAddModifyForm.onset_date"));
			var names = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"));
			var fields2 = new Array(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_desc"),eval(path+"document.RecPatChiefComplaintAddModifyForm.onset_date"));
			var names2 = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"));
	
			if(eval(path+"document.RecPatChiefComplaintAddModifyForm.chComplaintMandYN.value")=="Y"){
				fields.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details"));
				names.push(getLabel("eCA.ComplaintDetails.label","CA"));
				fields2.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details"));
				names2.push(getLabel("eCA.ComplaintDetails.label","CA"));
			}
			if(eval(path+"document.RecPatChiefComplaintAddModifyForm.chRemarksMandYN.value")=="Y"){
				fields.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.remarks"));
				names.push(getLabel("Common.remarks.label","CA"));
				fields2.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.remarks"));
				names2.push(getLabel("Common.remarks.label","CA")); 
			}// 37744 ENDS
		}else{
			/*var fields = new Array(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_desc"),eval(path+"document.RecPatChiefComplaintAddModifyForm.onset_date"),eval(path+"document.RecPatChiefComplaintAddModifyForm.err_remarks"),eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details"));
			var names = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"),getLabel("Common.ErrorRemarks.label","Common"),getLabel("eCA.ComplaintDetails.label","CA"));
			var fields1 = new Array(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_desc"),eval(path+"document.RecPatChiefComplaintAddModifyForm.onset_date"),eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details"));
			var names1 = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"),getLabel("eCA.ComplaintDetails.label","CA"));*/
			// 37744 STARTS
			var fields = new Array(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_desc"),eval(path+"document.RecPatChiefComplaintAddModifyForm.onset_date"));
			var names = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"));
			var fields2 = new Array(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_desc"),eval(path+"document.RecPatChiefComplaintAddModifyForm.onset_date"));
			var names2 = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"));
		
			if(eval(path+"document.RecPatChiefComplaintAddModifyForm.chComplaintMandYN.value")=="Y"){
				fields.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details"));
				names.push(getLabel("eCA.ComplaintDetails.label","CA"));
				fields2.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details"));
				names2.push(getLabel("eCA.ComplaintDetails.label","CA"));
			}
			if(eval(path+"document.RecPatChiefComplaintAddModifyForm.chRemarksMandYN.value")=="Y"){
				fields.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.remarks"));
				names.push(getLabel("Common.remarks.label","CA"));
				fields2.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.remarks"));
				names2.push(getLabel("Common.remarks.label","CA"));
			}// 37744 ENDS
			
			if(eval(path+"document.RecPatChiefComplaintAddModifyForm.error_yn.checked") == true){
				fields.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.err_remarks"));
				names.push(getLabel("Common.ErrorRemarks.label","CA"));
				fields2.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.err_remarks"));
				names2.push(getLabel("Common.ErrorRemarks.label","CA"));
			}// 37744 ENDS
				
		 }
		 
		 if(eval(path+"document.RecPatChiefComplaintAddModifyForm.error_yn")!= null)
		 {
			 if(eval(path+"document.RecPatChiefComplaintAddModifyForm.error_yn.checked") == true)
			 {	
				eval(path+"document.RecPatChiefComplaintAddModifyForm.error_yn.value= 'Y'") ;
				
				if(checkFields(fields, names,messageFrame))
				{
					 if(open_in_modal.value!="Y")
					{
						eval(path+"document.RecPatChiefComplaintAddModifyForm.submit()");
				    }
					else
					{					
						eval(path+"document.RecPatChiefComplaintAddModifyForm.target='AESubmitFrame'");
						eval(path+"document.RecPatChiefComplaintAddModifyForm.submit()");
		           }
				}
			}
			else
			{
				eval(path+"document.RecPatChiefComplaintAddModifyForm.error_yn.value='N'");				
			
				if(checkFields(fields2, names2,messageFrame))
				{
				    if(open_in_modal.value!="Y")
					{
						eval(path+"document.RecPatChiefComplaintAddModifyForm.submit()");
				    }
					else
					{
						eval(path+"document.RecPatChiefComplaintAddModifyForm.target='AESubmitFrame'");
						eval(path+"document.RecPatChiefComplaintAddModifyForm.submit()");
		           }
				}
			}
		 }
		else
		{
			/*var fields2 = new Array(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_desc"),eval(path+"document.RecPatChiefComplaintAddModifyForm.onset_date"),eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details"));
			var names2 = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"),getLabel("eCA.ComplaintDetails.label","CA"));*/
			// 37744 STARTS
			var fields2 = new Array(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_desc"),eval(path+"document.RecPatChiefComplaintAddModifyForm.onset_date"));
			var names2 = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"));
			
			if(eval(path+"document.RecPatChiefComplaintAddModifyForm.chComplaintMandYN.value")=="Y"){
				fields2.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.complaint_details"));
				names2.push(getLabel("eCA.ComplaintDetails.label","CA"));
			}
			if(eval(path+"document.RecPatChiefComplaintAddModifyForm.chRemarksMandYN.value")=="Y"){
				fields2.push(eval(path+"document.RecPatChiefComplaintAddModifyForm.remarks"));
				names2.push(getLabel("Common.remarks.label","CA"));
			}
			// 37744 ENDS
			if(checkFields(fields2, names2,messageFrame))
			{
			 	//f_query_add_mod.frames[1].document.ChiefComplaintDiagResultfrm.action="../../servlet/eCA.RecPatChiefComplaintServlet";
				//f_query_add_mod.frames[1].document.ChiefComplaintDiagResultfrm.target=messageFrame;
		
				if(open_in_modal.value!="Y"){
		 			eval(path+"document.RecPatChiefComplaintAddModifyForm.action='../../servlet/eCA.RecPatChiefComplaintServlet'");
		 			var msgframe = "";
					if(top.document.getElementById('dialog-body'))
					{
						msgframe=top.document.getElementById('dialog-body').contentWindow.messageFrame;
						msgframe.name="messageframe1";
						msgframe="messageframe1";
					}
					else
         			{
						if(parent.messageframe)
						msgframe="messageframe";
						else
						msgframe="messageFrame";
					}
					
					eval(path+"document.RecPatChiefComplaintAddModifyForm.target='"+msgframe+"'");
					
					eval(path+"document.RecPatChiefComplaintAddModifyForm.submit()");			
				}else{
					eval(path+"document.RecPatChiefComplaintAddModifyForm.action='../../servlet/eCA.RecPatChiefComplaintServlet'");
					eval(path+"document.RecPatChiefComplaintAddModifyForm.target='AESubmitFrame'");
					eval(path+"document.RecPatChiefComplaintAddModifyForm.submit()");
				}
			}	
		} 
	}else{
	    var errors
		if (msg != "")		
			errors = msg;			
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors;		
       return false ;		
	}
	
	/*
	var mode = parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.mode.value;
	if(mode=="insert"){		
		var open_in_modal	=	parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.open_in_modal;
	}else{
			var open_in_modal	=	parent.RecPatChiefComplaintResultFrame.document.RecPatChiefComplaintResultForm.open_in_modal;

			//alert("modify mode"+Calling_From.value);
	}
	var complaint_details = parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_details.value;
	var msg = "";

	var messageFrame = "";
	//alert("complaint_details"+complaint_details);

	
		 if(open_in_modal.value=="Y"){
			messageFrame= parent.AEMessageFrame;
		}
		else
		{
			messageFrame= top.content.messageFrame; 
		}

		
	if (complaint_details != "")
	{
		if (complaint_details.length > 0 )
		{
			 msg = fnChkMaxLength(complaint_details,'Complaint details');			
		}		
	}

	if (msg == "")
	{			
		if(mode=="insert")
		{
           //alert("insert");
			var fields = new Array(parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_desc,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.onset_date,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_details);

			var names = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"),getLabel("eCA.ComplaintDetails.label","CA"));
			var fields2 = new Array(parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_desc,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.onset_date,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_details);

			var names2 = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"),getLabel("eCA.ComplaintDetails.label","CA"));
			//var names = new Array ("Complaint","Onset Datetime");
		}
		else
		{		     

			var fields = new Array(parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_desc,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.onset_date,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.err_remarks,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_details);

			var names = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"),getLabel("Common.ErrorRemarks.label","Common"),getLabel("eCA.ComplaintDetails.label","CA"));

			var fields1 = new Array(parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_desc,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.onset_date,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_details);

			var names1 = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"),getLabel("eCA.ComplaintDetails.label","CA"));
		 }
		 
		 if(parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.error_yn!= null)
		 {
			 //alert("here error");
			 if(parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.error_yn.checked == true)
			 {	
				parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.error_yn.value = 'Y';
				//if(checkFields(fields, names,top.content.messageFrame))
				if(checkFields(fields, names,messageFrame))
				{
					//alert("here error23523");
					 if(open_in_modal.value!="Y")
					{
						parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.submit();
				    }
					else
					{
					//alert("else"+parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.target);
					parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.target="AESubmitFrame";
			        parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.submit();
		           }
				}
			}
			else
			{
				parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.error_yn.value = 'N';
				//if(checkFields(fields1, names1,top.content.messageFrame))
				if(checkFields(fields1, names1,messageFrame))
				{
                      
					//alert("complaint_details2"+complaint_details);
				    //alert("2");
				    if(open_in_modal.value!="Y")
					{
						parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.submit();
				    }
					else
					{
					//alert("else"+parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.target);
					parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.target="AESubmitFrame";
			        parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.submit();
		           }				//parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.submit();
				}
			}
		 }
		else
		{
			var fields2 = new Array(parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_desc,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.onset_date,parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_details);

			var names2 = new Array (getLabel("Common.Complaint.label","Common"),getLabel("Common.OnsetDateTime.label","COMMON"),getLabel("eCA.ComplaintDetails.label","CA"));

			//if(checkFields(fields2, names2,top.content.messageFrame))
			if(checkFields(fields2, names2,messageFrame))
			{

				if(open_in_modal.value!="Y"){

				parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.submit();
			
				}else{
					//alert("3"+parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.target);
		    	parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.target="AESubmitFrame";
			parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.submit();
		  }
		 }	
		} 
	}else{
	    var errors

		if (msg != "")		
			errors = msg;		
		
		//top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors;		
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors;		
       return false ;		
	}*/
	//CHL-CRF Start.[IN035950]
 }

async function showCalendarValidate(str){
	var flg = await showCalendar(str,null,'hh:mm',null);
	document.getElementById(str).focus();
	//document.getElementById(str).focus();
	return flg;
}

function onSuccess()
{
	//alert("test");
	parent.frames[0].location.reload();
	parent.frames[1].location.reload();
}

function Clearpage()
{
	//CHL-CRF Start.[IN035950]
	mode =  parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.mode.value;	
	var	p_called_from_widget = parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.p_called_from_widget.value;	
	var Encounter_ID = parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.encounter_id;
		
	if(mode=="modify"){		
		var open_in_modal =	parent.RecPatChiefComplaintResultFrame.document.RecPatChiefComplaintResultForm.open_in_modal;			
	}else{ 
		var open_in_modal  = parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.open_in_modal;
	}
	if(open_in_modal.value!="Y"){ 
		if(mode =="modify"){			
			var qstr="";
			if(p_called_from_widget!=""){
				qstr=parent.RecPatChiefComplaintResultFrame.document.RecPatChiefComplaintResultForm.qrystr.value;
			}else{
				qstr= parent.document.CC_main.qrystr.value;	
			}
			parent.RecPatChiefComplaintAddModifyFrame.location.href="RecPatChiefComplaintAddModify.jsp?"+qstr;
		}else{ 
			if(p_called_from_widget!=""){
				var qstr=parent.RecPatChiefComplaintResultFrame.document.RecPatChiefComplaintResultForm.qrystr.value;
				parent.RecPatChiefComplaintAddModifyFrame.location.href="RecPatChiefComplaintAddModify.jsp?"+qstr;
			}else{
				parent.frames[1].location.reload();
			}
		}
	}else{
		parent.frames[1].location.href="../../eCA/jsp/RecPatChiefComplaintAddModify.jsp?encounter_id="+Encounter_ID.value+"&open_in_modal="+open_in_modal.value+"&mode="+mode+"&clear=clear";
	}
	//CHL-CRF End.[IN035950]
}

async function showdiagnosis(complaint_id,complaint_desc)
{
	/*Added by Archana on 3/10/2010 at 3:07 PM for IN019870 start*/
	while(complaint_desc.indexOf("CHIEFDOUBLEQUOTE")!= -1)
	{
	  complaint_desc = complaint_desc.replace("CHIEFDOUBLEQUOTE","\"");
	}
	while(complaint_desc.indexOf("CHIEFSINGLEQUOTE")!= -1)
	{
	   complaint_desc = complaint_desc.replace("CHIEFSINGLEQUOTE","'");
	}
	//alert("complaint_desc"+complaint_desc);
	//end
	var encounter_id = parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.encounter_id.value;
	var dialogWidth = "50vw";
	var dialogHeight = "50vh";
	var features		="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;

	retVal = await window.showModalDialog("../../eCA/jsp/RecPatChiefComplaintDiagViewMain.jsp?encounter_id="+encounter_id+"&complaint_id="+complaint_id+"&complaint_desc="+complaint_desc,arguments,features);
}

async function ViewAllDiag()
{
	var encounter_id = parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.encounter_id.value;
	var dialogWidth = "60vw";
	var dialogHeight = "60vh";
	var features		="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;

	retVal = await window.showModalDialog("../../eCA/jsp/RecPatChiefComplaintViewAllDiagMain.jsp?Encounter_Id="+encounter_id,arguments,features);
}

function updateChiefComplaint(complaint_desc,complaint_text,onset_datetime,complaint_id,remarks,mode,encounter_id)
{
	parent.RecPatChiefComplaintAddModifyFrame.location.href="../../eCA/jsp/RecPatChiefComplaintAddModify.jsp?complaint_desc="+complaint_desc+"&complaint_text="+complaint_text+"&onset_datetime="+onset_datetime+"&complaint_id="+complaint_id+"&remarks="+remarks+"&mode="+mode+"&encounter_id="+encounter_id;

}

function cancel_page()
{
		mode =  parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.mode.value;
	if(mode=="modify")
	{
		
		var open_in_modal	=	parent.RecPatChiefComplaintResultFrame.document.RecPatChiefComplaintResultForm.open_in_modal;
			//alert("modify mode"+Calling_From.value);
           
		}else
     {
		var open_in_modal = 			parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.open_in_modal;

		}

	//var Calling_From	=	parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.Calling_From;
	if(open_in_modal.value!="Y"){



	top.content.messageFrame.document.location.href='../../eCA/jsp/blank.jsp';
	
	//window.close();
	//parent.frames[0].RecPatChiefComplaintResultFrame.location.href = '../../eCA/jsp/blank.jsp' ;
	//parent.frames[1].RecPatChiefComplaintAddModifyFrame.location.href = '../../eCA/jsp/blank.jsp' ;

	top.content.workAreaFrame.RecPatChiefComplaintResultFrame.location.href = '../../eCA/jsp/blank.jsp' ;
	top.content.workAreaFrame.RecPatChiefComplaintAddModifyFrame.location.href = '../../eCA/jsp/blank.jsp' ;
//	top.content.workAreaFrame.RecPatChiefComplaintActionButtonFrame.location.href = '../../eCA/jsp/blank.jsp' ;
  }else{
		parent.window.close();
	}

}

async function showRemarks(complaint_text,complaint_desc,remarks,complaint_id,facility_id,encounter_id)
{
	/*Added by Archana on 3/10/2010 at 3:07 PM for IN019870 start*/
	while(complaint_text.indexOf("CHIEFDOUBLEQUOTE")!= -1)
	{
	  complaint_text = complaint_text.replace("CHIEFDOUBLEQUOTE","\"");
	}
	while(complaint_text.indexOf("CHIEFSINGLEQUOTE")!= -1)
	{
	   complaint_text = complaint_text.replace("CHIEFSINGLEQUOTE","'");
	}
	//end
	//alert("complaint_text"+complaint_text);
	var encounter_id = parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.encounter_id.value;
	var dialogWidth = "38vw";
	var dialogHeight ="62vh";
	var features	 ="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;

	retVal =await top.window.showModalDialog("../../eCA/jsp/RecPatChiefComplaintDetailsMain.jsp?complaint_text="+complaint_text+"&complaint_desc="+complaint_desc+"&remarks="+remarks+"&complaint_id="+complaint_id+"&facility_id="+facility_id+"&encounter_id="+encounter_id,arguments,features);
}


/*function CheckForNumber_L(Objval,obj1) {
		val = Objval.value;
		
	if ( trimCheck(val) && isNaN(val) == false && val >=0)
  		return true;
	else
	{
		if ( val.length > 0 ) {
			if(obj1.name=="onset_date")
	  			document.forms[0].onset_date.value='';
  			alert(getMessage("ONLY_NUMBER_ALLOWED","CA"));
			Objval.select();
  			Objval.focus();
  			return false;
  			
  		}
	}
}

function checkDays(Obj,obj1)
{
	if( Obj.value  > 31) 
	{   
		alert(getMessage("DAYS_CHECK","Common"));
		Obj.focus(); 
		if (obj1.name=="onset_date")
				document.forms[0].onset_date.value=''; 

	}
}
function checkMonth(Obj,obj1)
{
	if( Obj.value  > 11) 
	{ 
		alert(getMessage("MONTHS_CHECK","Common"));
		Obj.focus(); 
		if (obj1.name=="onset_date")
				document.forms[0].onset_date.value='';
	}
}
function calci(Obj)
{
	var hide= document.forms[0].ServerDate.value;
	strDateArray = hide.split("/");
	if (strDateArray.length != 3) ;
	else 
	{
		strDay = strDateArray[0];
		strMonth = strDateArray[1];
		strYearTime = strDateArray[2];
		strYear = strYearTime.split("  ")[0];
		strTime = strYearTime.split("  ")[1];
	}
	if(Obj.name == 'b_age' || Obj.value >0)
	{
		
		var yy=document.forms[0].b_age.value;
		days = new Date();
		gdate = days.getDate();
		gmonth = days.getMonth();
		gyear = days.getFullYear();
		age = strYear - yy;
		document.forms[0].onset_date.value=strDay+"/"+strMonth+"/"+age + "  " + strTime;
		document.forms[0].text5.value=document.forms[0].onset_date.value;
	}
	
	if(Obj.name == 'b_months' || (document.forms[0].b_months.value >0 && document.forms[0].b_months.value <12))
	{
		if(document.forms[0].text5.value == '') 
			document.forms[0].text5.value=document.forms[0].ServerDate.value;
		var hide1=document.forms[0].text5.value;
		var mm=document.forms[0].b_months.value;
		strDateArray1 = hide1.split("/");
		strDay1 = strDateArray1[0];
		strMonth1 = strDateArray1[1];
		strYear_Time1 = strDateArray1[2];
		strYear1 = strYear_Time1.split("  ")[0];
		strTime1 = strYear_Time1.split("  ")[1];
		strMonth1=strMonth1-mm;
		if(strMonth1 <=0)
		{
			strMonth1=12+strMonth1;
			strYear1=strYear1-1;
		}
		
		if(strMonth1 == "1") strMonth1="01";
		if(strMonth1 == "2") strMonth1="02";
		if(strMonth1 == "3") strMonth1="03";
		if(strMonth1 == "4") strMonth1="04";
		if(strMonth1 == "5") strMonth1="05";
		if(strMonth1 == "6") strMonth1="06";
		if(strMonth1 == "7") strMonth1="07";
		if(strMonth1 == "8") strMonth1="08";
		if(strMonth1 == "9") strMonth1="09";

		if(strDay == "1") strDay="01";
		if(strDay == "2") strDay="02";
		if(strDay == "3") strDay="03";
		if(strDay == "4") strDay="04";
		if(strDay == "5") strDay="05";
		if(strDay == "6") strDay="06";
		if(strDay == "7") strDay="07";
		if(strDay == "8") strDay="08";
		if(strDay == "9") strDay="09";
		
		document.forms[0].onset_date.value=strDay+"/"+strMonth1+"/"+strYear1 + "  " + strTime1;		
		document.forms[0].text6.value=document.forms[0].onset_date.value;
	}
	if(Obj.name == 'b_days' || (document.forms[0].b_days.value >0 && document.forms[0].b_days.value <32))
	{		
			if(document.forms[0].text6.value == '')  
			document.forms[0].text6.value=document.forms[0].ServerDate.value;
		var hide2= document.forms[0].text6.value;
		var dd=document.forms[0].b_days.value;
		strDateArray2 = hide2.split("/");

		strDay2 = strDateArray2[0];
		strMonth2= strDateArray2[1];
		strYear_Time2 = strDateArray2[2];
		strYear2 = strYear_Time2.split("  ")[0];
		strTime2 = strYear_Time2.split("  ")[1];
		strDay = strDay2 - dd;
		if(strDay <= 0 )
		{
			strMonth2=strMonth2-1;
			if(strMonth2 == 2)
			{
				if(leapyear(strYear2))
				{
					strDay=29+strDay+2;
				}
				else
					strDay=28+strDay;
			}
			else
			{
				if((strMonth2 == 4) || (strMonth2 == 6) || (strMonth2 == 9) || (strMonth2 == 11))
				{
					strDay=30+strDay;
				}
				else
				{
					strDay=31+strDay-1;
				}
			}
		}

		if(strMonth2 == "1") strMonth2="01";
		if(strMonth2 == "2") strMonth2="02";
		if(strMonth2 == "3") strMonth2="03";
		if(strMonth2 == "4") strMonth2="04";
		if(strMonth2 == "5") strMonth2="05";
		if(strMonth2 == "6") strMonth2="06";
		if(strMonth2 == "7") strMonth2="07";
		if(strMonth2 == "8") strMonth2="08";
		if(strMonth2 == "9") strMonth2="09";
		if(strDay == "1") strDay="01";
		if(strDay == "2") strDay="02";
		if(strDay == "3") strDay="03";
		if(strDay == "4") strDay="04";
		if(strDay == "5") strDay="05";
		if(strDay == "6") strDay="06";
		if(strDay == "7") strDay="07";
		if(strDay == "8") strDay="08";
		if(strDay == "9") strDay="09";

		document.forms[0].onset_date.value=strDay+"/"+strMonth2+"/"+strYear2 + "  " + strTime2;

	}
}
function leapyear(a) 
{
	if(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))
		return true;
	else
		return false;
}*/

/*function checkForCurrentDate()
{
	var currDate = document.forms[0].onset_datetime.value;
	var fromDate1 = document.forms[0].onset_date.value;

	if(fromDate1 !="")
	{
		fromDate = fromDate1.split(" ");
		var retVal = checkDt(fromDate[0]);
		
	 if(retVal)
		{
		  
		 var splitdate =fromDate[0].split("/");
		 var cursplit = currDate.split(" ");
		 var splitdate1 =cursplit[0].split("/");
		var from_date  =new Date(eval(splitdate[2]), eval(splitdate[1])-1, eval(splitdate[0]));
		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]));
			
			if(Date.parse(to_date) < Date.parse(from_date))
			{
					alert(getMessage("ONSET_DATE_GREATER_SYSDATE","CA"));		
					document.forms[0].onset_date.value = currDate;
					return false		   
			}
			else
				return true;
		
		}
		else
		{
			return true;
		}
	}
}*/

function checkForCurrentDate(obj,format,locale,dob)
{
	var open_in_modal	=	parent.RecPatChiefComplaintResultFrame.document.RecPatChiefComplaintResultForm.open_in_modal.value;
	//alert(open_in_modal);
	if(obj.value !="")
	{		
		if(validDate(obj.value,format,locale)==false)
		{	
			alert(getMessage("INVALID_DATE_TIME","CA"));
			obj.select();
			return false;
		}
		if(isBeforeNow(obj.value, format,locale))
		{
			if(open_in_modal=='Y')
				{
					if(doDateTimeChk(obj)==false)	
					{
						alert(getMessage("INVALID_DATE_TIME","CA"));
						obj.value='';				
						document.forms[0].onset_date.value = getCurrentDate("DMYHM",locale);
						return false;
						}
				}
	
			if(isBefore(obj.value,dob,format,locale) )
				{						
					alert(getMessage("LESS_THAN_BDAY_DATE","CA"));
					
					obj.value= "";
					document.forms[0].onset_date.value = getCurrentDate("DMYHM",locale);
					return false;
			}
			

			else	
				{
					
					return true;
			}
				
		}
		else
		{
			
			alert(getMessage("ONSET_DATE_GREATER_SYSDATE","CA"));		
			document.forms[0].onset_date.value = getCurrentDate("DMYHM",locale);
			return false;
		}	
	}
}

function show_rem (obj)
{
	if(obj.checked)
	{
		
		document.getElementById("sh_rem").style='display';
		document.getElementById("recordButton").disabled=false;
		
	}
	else 
	{
		document.getElementById("err_remarks").value="";
		document.getElementById("sh_rem").style.display="none";
		//document.getElementById("recordButton").disabled=true;
	}
	

}

async function show_errList ()
{
  
  var retVal ="";
  var facility_id =document.getElementById("facility_id").value;
  var encounter_id =document.getElementById("encounter_id").value;
  
  var arguments="";
  var dialogHeight='45vh';
  var dialogWidth='42vw';
  var fetures ='dialogHeight:'+dialogHeight+';dialogWidth:'+dialogWidth+';scroll=auto;status=no'  ;

  retVal =await window.showModalDialog('../../eCA/jsp/RecPatChiefCompViewErrorList.jsp?facility_id='+facility_id+'&encounter_id='+encounter_id,arguments,fetures);
}

function show_det(complaint_id,complaint_desc,complaint_text,onset_datetime,remarks,encounter_id,patient_id,relationship_id)
{

	var open_in_modal	=	parent.RecPatChiefComplaintResultFrame.document.RecPatChiefComplaintResultForm.open_in_modal.value;
	var p_called_from_widget	=	parent.RecPatChiefComplaintResultFrame.document.RecPatChiefComplaintResultForm.p_called_from_widget.value; //IN035950
	/*Added by Archana on 3/10/2010 at 3:07 PM for IN019870 start*/
	while(complaint_text.indexOf("CHIEFDOUBLEQUOTE")!= -1)
	{
	  complaint_text = complaint_text.replace("CHIEFDOUBLEQUOTE","\"");
	}
	while(complaint_text.indexOf("CHIEFSINGLEQUOTE")!= -1)
	{
	   complaint_text = complaint_text.replace("CHIEFSINGLEQUOTE","'");
	}
	//end
	//alert("complaint_text"+complaint_text);

	//parent.RecPatChiefComplaintAddModifyFrame.location.href="RecPatChiefComplaintAddModify.jsp?mode=modify&complaint_desc="+complaint_desc+"&complaint_text="+complaint_text+"&onset_datetime="+onset_datetime+"&complaint_id="+complaint_id+"&remarks="+remarks+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&relationship_id="+relationship_id+"&open_in_modal="+open_in_modal+"" ; // IN035950
	parent.RecPatChiefComplaintAddModifyFrame.location.href="RecPatChiefComplaintAddModify.jsp?mode=modify&complaint_desc="+complaint_desc+"&complaint_text="+complaint_text+"&onset_datetime="+onset_datetime+"&complaint_id="+complaint_id+"&remarks="+remarks+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&relationship_id="+relationship_id+"&open_in_modal="+open_in_modal+"&p_called_from_widget="+p_called_from_widget ; //IN035950
	//IN035950 Start.
	if(p_called_from_widget!=""){
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}else{
	//IN035950 End.
		if(top.content!=null)
			top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';	
		else
			parent.AEMessageFrame.location.href='../../eCommon/jsp/error.jsp';
	
	}//IN035950

}

function ismaxlength(obj)
	{

		var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
		if (obj.getAttribute && parseInt(obj.value.length)>mlength)
			{
				var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
				msg = msg.replace("$","Remarks");
				msg = msg.replace("#",mlength);					
				alert(msg);
				obj.focus();
				//obj.value=obj.value.substring(0,mlength);
			}
	}


function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode;
	if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
		return false;
	else
		return true;
}

function getViewCode(objCode)
{

	if(objCode.name=='complaint_desc')
	{
		/*Commented below line and the following code is added by Archana on 5/28/2010  for IN021646*/
		//complaint_id(objCode);

			ViewComplaint();
	}
	
	if(objCode.name=='ComplaintSrch')
	{
		if(document.RecPatChiefComplaintAddModifyForm.flag.value=='false')
			return false
		else
			ViewComplaint();
	}
			
}

 function complaint_id(objCode)
{
    	var open_in_modal	=	parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.open_in_modal;

	var complaints = objCode.value;
	
	var encounter_id = document.RecPatChiefComplaintAddModifyForm.encounter_id.value;
	var locale = document.RecPatChiefComplaintAddModifyForm.locale.value;
	var spltCode = document.RecPatChiefComplaintAddModifyForm.spltCode.value;
	if(complaints == '')
	{
		document.RecPatChiefComplaintAddModifyForm.flag.value='true'
		return false
	}
	else
	{	
		if(top.content!=null)
		{
			top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
		}
		else
		{
			
			parent.AEMessageFrame.location.href='../../eCommon/jsp/error.jsp';
		}

		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='RecPatChiefComplaintIntermediate.jsp'><input type=hidden name='complaint_id' id='complaint_id' value='"+complaints+"'><input type=hidden name='encounter_id' id='encounter_id' value='"+encounter_id+"'><input type=hidden name='spltCode' id='spltCode' value='"+spltCode+"'><input type=hidden name='locale' id='locale' value='"+locale+"'></form></body></html>";		

		if(top.content!=null)
		{
		parent.RecPatChiefComplaintBlankFrame.document.write(HtmlVal);
		parent.RecPatChiefComplaintBlankFrame.document.tempform.submit();
		}
		else
		{
				parent.AESubmitFrame.document.write(HtmlVal);
		        parent.AESubmitFrame.document.tempform.submit();
		}
		
	}
}

function resetValues()
{
	//(var i=0;i<5;i++){}

	//top.content.messageFrame.document.location.href='../../eCA/jsp/blank.jsp';
	if(top.content!=null)
	{
		top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	}
	else
	{
		//CHL-CRF Start.[IN035950]
		var path="";
		if(parent.RecPatChiefComplaintAddModifyFrame!=undefined){
			path="parent.RecPatChiefComplaintAddModifyFrame."
		}
		var callFromWidget =  eval(path+"document.RecPatChiefComplaintAddModifyForm.p_called_from_widget.value");
		if(callFromWidget!=""){
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		}else{
		//CHL-CRF End.[IN035950]
			parent.AEMessageFrame.location.href='../../eCommon/jsp/error.jsp'; //IN035950
		}//CHL-CRF [IN035950]
	}
	
}
function setValue()
{
	document.RecPatChiefComplaintAddModifyForm.flag.value='false'
}
async function callFunction(encounter_id,complaint,spltCode)
{
	
	var dialogHeight	= "80vh";
	var dialogWidth		= "80vw";
	var dialogTop		= "3";	
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal = await window.showModalDialog("../../eCA/jsp/RecPatChiefComplaintDiagLookupMain.jsp?encounter_id="+encounter_id+"&complaint="+complaint+"&spltCode="+spltCode,arguments,features);	
	
	return retVal;
}
function fnChkMaxLength(objVal,objDesc){
	var valLength	 = objVal.length;	
	//alert("parseInt(valLength)"+parseInt(valLength));
	var msg ="";
	/*Maximum size is changed from 4000 to 2000 now(modified by Archana on 3/18/2010 at 4:45 PM for IN019870)*/
	if (parseInt(valLength)  > 1300)//Maximum size is changed from 2000 to 1300.(modified by Archana on 3/24/2010 at 2:12 PM for IN019870)
	{		
		msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
		msg = msg.replace("$",objDesc);
		msg = msg.replace("#",1300);		
		return msg;
	}
	return msg;	
}

