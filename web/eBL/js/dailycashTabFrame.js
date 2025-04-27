var dataArr = [];
var grpArr = [];


/* To Differentiate the tabs */
function fnShowMainTabDetails(object){
	if(object == 'Dailydayclrpt'){
		var updateVal = document.getElementById('called').value;
		if(updateVal=='rpttt'){
		   var RowIndex=parent.dailycashrpt.SetupSplGrp.document.getElementById("rowval").value;
		   var grpsave=parent.dailycashrpt.SetupSplGrp.document.getElementById("grpsave").value;
		   var totrec=parent.dailycashrpt.SetupSplGrp.document.getElementById("totrecords").value;
		   var grpSize=parent.dailycashrpt.SetupSplGrp.document.getElementById("grpSize").value;
		   if(totrec!=grpSize){
				 if(grpsave=="Y"){
					  if(RowIndex!=""){
						var servCodeVal=parent.dailycashrpt.SetupSplGrp.document.getElementById("select"+RowIndex).checked;
						var servGpCode=parent.dailycashrpt.SetupSplGrp.document.getElementById("ServGroupCode"+RowIndex).value;
						var servGpdesc=parent.dailycashrpt.SetupSplGrp.document.getElementById("LongDesc"+RowIndex).value;
						var shrtdesc=parent.dailycashrpt.SetupSplGrp.document.getElementById("ShortDesc"+RowIndex).value;
					
					   if(servGpCode!="" && servGpdesc!="" && shrtdesc!=""){
						   document.getElementById('called').value='abc';
						   	document.getElementById('Dailydayclrpt').className = "tabClicked";
							document.getElementById('Dailydayclrptspan').className = "tabSpanclicked";
							document.getElementById('setupsplgrp').className = "tabA";
							document.getElementById('setupsplgrpspan').className = "tabAspan";	
							parent.dailycashrpt.location.href = '../../eBL/jsp/GenerateDayColRpt.jsp';
						}else{
							if(servGpCode==''){
								parent.dailycashrpt.SetupSplGrp.document.getElementById("ServGroupCode"+RowIndex).focus();
								alert(getMessage("BL00948",'BL'));
								return false;
							}else if(servGpdesc==""){
								parent.dailycashrpt.SetupSplGrp.document.getElementById("LongDesc"+RowIndex).focus();
								alert(getMessage("BL00948",'BL'));
								return false;
							}
						}
				      }
					}
					else{
						alert(getMessage("BL0930",'BLEXT')); //save or discard changes message
						return false;
					}
				}
			   else if(totrec==grpSize){
				   document.getElementById('called').value='abc';
				   document.getElementById('Dailydayclrpt').className = "tabClicked";
				   document.getElementById('Dailydayclrptspan').className = "tabSpanclicked";
				   document.getElementById('setupsplgrp').className = "tabA";
				   document.getElementById('setupsplgrpspan').className = "tabAspan";	
				   parent.dailycashrpt.location.href = '../../eBL/jsp/GenerateDayColRpt.jsp';
						}
				    
		   }
		else if(updateVal=='maint'){
			var servGrpCode=parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("servGrpCode").value;
			var totrec=parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("totalRec").value;
			var grpSize=parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("grpSize").value;
			var serviceSave=parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("serviceSave").value;
			var gpSize=grpSize;
		    gpSize=++gpSize;
		    if(serviceSave=="N"){
				if(totrec!=grpSize){
					alert(getMessage("BL0930",'BLEXT')); //save or discard changes message
					return false;
				}else if(totrec==grpSize){
					document.getElementById('called').value='abc';
					document.getElementById('Dailydayclrpt').className = "tabClicked";
					document.getElementById('Dailydayclrptspan').className = "tabSpanclicked";
				    document.getElementById('setupsplgrp').className = "tabA";
					document.getElementById('setupsplgrpspan').className = "tabAspan";	
					parent.dailycashrpt.location.href = '../../eBL/jsp/GenerateDayColRpt.jsp';
					}
			}else{
				if(totrec==grpSize){
				 document.getElementById('called').value='abc';
				 document.getElementById('Dailydayclrpt').className = "tabClicked";
				 document.getElementById('Dailydayclrptspan').className = "tabSpanclicked";
				 document.getElementById('setupsplgrp').className = "tabA";
				 document.getElementById('setupsplgrpspan').className = "tabAspan";	
				 parent.dailycashrpt.location.href = '../../eBL/jsp/GenerateDayColRpt.jsp';
				} else if(totrec!=grpSize){
					alert(getMessage("BL0930",'BLEXT')); //save or discard changes message
					return false;
				}
			}
		}
		else{
			document.getElementById('called').value='abc';
			document.getElementById('Dailydayclrpt').className = "tabClicked";
			document.getElementById('Dailydayclrptspan').className = "tabSpanclicked";
		    document.getElementById('setupsplgrp').className = "tabA";
		    document.getElementById('setupsplgrpspan').className = "tabAspan";	
		    parent.dailycashrpt.location.href = '../../eBL/jsp/GenerateDayColRpt.jsp';
		}
		parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
	}
	else if(object == 'setupsplgrp'){
		var updVal = parent.dailycashreport.document.getElementById('called').value;
		if(updVal=='maint' || updVal=='create'){
			return false;
		/*	var totrec=parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("totalRec").value;
			var grpSize=parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("grpSize").value;
			var serviceSave=parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("serviceSave").value;
			var gpSize=grpSize;
		    gpSize=++gpSize;
			if(serviceSave=="N"){
				if(totrec!=grpSize){
					alert(getMessage("BL0930",'BLEXT')); //save or discard changes message
					return false;
				}
			}else{
				if(totrec==grpSize){
				 updVal='dailycashmenu';
				 document.getElementById('Dailydayclrpt').className = "tabClicked";
				 document.getElementById('Dailydayclrptspan').className = "tabSpanclicked";
				 document.getElementById('setupsplgrp').className = "tabA";
				 document.getElementById('setupsplgrpspan').className = "tabAspan";	
				 parent.dailycashrpt.location.href = '../../eBL/jsp/GenerateDayColRpt.jsp';
				}
			}  */
		} 
		document.getElementById('setupsplgrp').className = "tabClicked";
		document.getElementById('setupsplgrpspan').className = "tabSpanclicked";
		document.getElementById('Dailydayclrpt').className = "tabA";
		document.getElementById('Dailydayclrptspan').className = "tabAspan";	
		parent.dailycashrpt.location.href = '../../eBL/jsp/GenerateDayColRptTab.jsp';
	}
	else if(object == 'reportservgp'){	
		var updVal = parent.parent.dailycashreport.document.getElementById('called').value;
		if(updVal=='maint'){
			var totrec=parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("totalRec").value;
			var grpSize=parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("grpSize").value;
			var serviceSave=parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("serviceSave").value;
			var gpSize=grpSize;
		    gpSize=++gpSize;
			if(serviceSave=="N"){
				if(totrec!=grpSize){
					alert(getMessage("BL0930",'BLEXT')); //save or discard changes message
					return false;
				}
			}else{
				if(totrec==grpSize){
					parent.parent.dailycashreport.document.getElementById('called').value='rpttt';
					document.getElementById('reportservgp').className = "tabClicked";
					document.getElementById('reportservgpspan').className = "tabSpanclicked";
					document.getElementById('assocservgp').className = "tabA";
					document.getElementById('assocservgpspan').className = "tabAspan";	
					parent.SetupSplGrp.location.href= '../../eBL/jsp/SetupSplGrp.jsp';
					parent.parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
				}
			}
		}
		
		parent.parent.dailycashreport.document.getElementById('called').value='rpttt';
		document.getElementById('reportservgp').className = "tabClicked";
		document.getElementById('reportservgpspan').className = "tabSpanclicked";
		document.getElementById('assocservgp').className = "tabA";
		document.getElementById('assocservgpspan').className = "tabAspan";	
		parent.SetupSplGrp.location.href= '../../eBL/jsp/SetupSplGrp.jsp';
		parent.parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
	} 
	else if(object == 'assocservgp'){
		var updVal = parent.parent.dailycashreport.document.getElementById('called').value;
		if(updVal=='maint'){ 
			var servGrpCode=parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("servGrpCode").value;
			var totrec=parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("totalRec").value;
			var grpSize=parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("grpSize").value;
			var serviceSave=parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("serviceSave").value;
			var gpSize=grpSize;
		    gpSize=++gpSize;
			if(serviceSave=="N"){
				if(totrec!=grpSize){
					alert(getMessage("BL0930",'BLEXT')); //save or discard changes message
					return false;
				}
			}else{
				if(totrec==grpSize){
					parent.parent.dailycashreport.document.getElementById('called').value='assoc';
					
					document.getElementById('assocservgpspan').className = "tabSpanclicked";
					document.getElementById('reportservgp').className = "tabA";
					document.getElementById('reportservgpspan').className = "tabAspan";	
				    parent.SetupSplGrp.location.href = '../../eBL/jsp/AssociateServFrame.jsp?called=assocframe&servGpCode='+servGpCode+'&servGpdesc='+servGpdesc; 
				}
			}
		}
		else if(updVal=='rpttt'){
			var RowIndex=parent.SetupSplGrp.document.getElementById("rowval").value;
			var grpsave=parent.SetupSplGrp.document.getElementById("grpsave").value;
			var totrec=parent.SetupSplGrp.document.getElementById("totrecords").value;
			var grpSize=parent.SetupSplGrp.document.getElementById("grpSize").value;
			if(totrec!=grpSize){
				if(grpsave=="Y"){
					if(RowIndex!=""){
						var undFlag=parent.SetupSplGrp.document.getElementById("checkboxundef"+RowIndex).checked;
						var exmpFalg=parent.SetupSplGrp.document.getElementById("checkboxexempt"+RowIndex).checked;
						if(undFlag==true || undFlag=='true' || exmpFalg=='true' || exmpFalg==true){
							return false;
						}
						var servCodeVal=parent.SetupSplGrp.document.getElementById("select"+RowIndex).checked;
						var servGpCode=parent.SetupSplGrp.document.getElementById("ServGroupCode"+RowIndex).value;
						var servGpdesc=parent.SetupSplGrp.document.getElementById("LongDesc"+RowIndex).value;
						var shrtdesc=parent.SetupSplGrp.document.getElementById("ShortDesc"+RowIndex).value;
		
		   if(servGpCode!="" && servGpdesc!="" && shrtdesc!=""){
				parent.parent.dailycashreport.document.getElementById('called').value='assoc';
				
			   	document.getElementById('assocservgp').className = "tabClicked";
				document.getElementById('assocservgpspan').className = "tabSpanclicked";
				document.getElementById('reportservgp').className = "tabA";
				document.getElementById('reportservgpspan').className = "tabAspan";	
			    parent.SetupSplGrp.location.href = '../../eBL/jsp/AssociateServFrame.jsp?called=assocframe&servGpCode='+servGpCode+'&servGpdesc='+servGpdesc; 
			}else{
				if(servGpCode==''){
					parent.SetupSplGrp.document.getElementById("ServGroupCode"+RowIndex).focus();
					alert(getMessage("BL00948",'BL'));
					return false;
				}else if(servGpdesc==""){
					parent.SetupSplGrp.document.getElementById("LongDesc"+RowIndex).focus();
					alert(getMessage("BL00948",'BL'));
					return false;
				}
			}
	      }
		}
		else{
			alert(getMessage("BL0930",'BLEXT')); //save or discard changes message
			return false;
		}
	}
	   else if(totrec==grpSize){
		 if(RowIndex!=""){
			 //V210222
		      var undFlag=parent.SetupSplGrp.document.getElementById("checkboxundef"+RowIndex).checked;
	    	  var exmpFalg=parent.SetupSplGrp.document.getElementById("checkboxexempt"+RowIndex).checked;
			  if(undFlag==true || undFlag=='true' || exmpFalg=='true' || exmpFalg==true){  
				return false;
			  }  //V210222
				var servCodeVal=parent.SetupSplGrp.document.getElementById("select"+RowIndex).checked;
				var servGpCode=parent.SetupSplGrp.document.getElementById("ServGroupCode"+RowIndex).value;
				var servGpdesc=parent.SetupSplGrp.document.getElementById("LongDesc"+RowIndex).value;
				var shrtdesc=parent.SetupSplGrp.document.getElementById("ShortDesc"+RowIndex).value;
			
			   if(servGpCode!="" && servGpdesc!="" && shrtdesc!=""){
					parent.parent.dailycashreport.document.getElementById('called').value='assoc';
					
				   	document.getElementById('assocservgp').className = "tabClicked";
					document.getElementById('assocservgpspan').className = "tabSpanclicked";
					document.getElementById('reportservgp').className = "tabA";
					document.getElementById('reportservgpspan').className = "tabAspan";	
				    parent.SetupSplGrp.location.href = '../../eBL/jsp/AssociateServFrame.jsp?called=assocframe&servGpCode='+servGpCode+'&servGpdesc='+servGpdesc; 
				}else{
					if(servGpCode==''){
						parent.SetupSplGrp.document.getElementById("ServGroupCode"+RowIndex).focus();
						alert(getMessage("BL00948",'BL'));
						return false;
					}else if(servGpdesc==""){
						parent.SetupSplGrp.document.getElementById("LongDesc"+RowIndex).focus();
						alert(getMessage("BL00948",'BL'));
						return false;
					}
				}
		      }
		 }
		}
		parent.parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
		
	} 
	else if(object == 'createrptsergp'){	
		var updVal = parent.parent.parent.dailycashreport.document.getElementById('called').value;
		if(updVal=='maint'){
			var servGrpCode=parent.parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("servGrpCode").value;
			var totrec=parent.parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("totalRec").value;
			var grpSize=parent.parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("grpSize").value;
			var serviceSave=parent.parent.parent.dailycashrpt.SetupSplGrp.AssocService.document.getElementById("serviceSave").value;
			var gpSize=grpSize;
		    gpSize=++gpSize;
		    if(serviceSave=="N"){
		    	if(totrec!=grpSize){
					alert(getMessage("BL0930",'BLEXT')); //save or discard changes message
					return false;
				}
		    }else{
				if(totrec==grpSize){
					parent.parent.parent.dailycashreport.document.getElementById('called').value='create';
					document.getElementById('createrptsergp').className = "tabClicked";
					document.getElementById('createrptsergpspan').className = "tabSpanclicked";
					document.getElementById('Maintrptsergp').className = "tabA";
					document.getElementById('Maintrptsergpspan').className = "tabAspan";
					parent.AssocService.location.href = '../../eBL/jsp/CreateServReportingGp.jsp';
					parent.parent.parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
				}
			}
		}
		parent.parent.parent.dailycashreport.document.getElementById('called').value='create';
		document.getElementById('createrptsergp').className = "tabClicked";
		document.getElementById('createrptsergpspan').className = "tabSpanclicked";
		document.getElementById('Maintrptsergp').className = "tabA";
		document.getElementById('Maintrptsergpspan').className = "tabAspan";
		parent.AssocService.location.href = '../../eBL/jsp/CreateServReportingGp.jsp';
		parent.parent.parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
	} 
	else if(object=='Maintrptsergp'){
		parent.parent.parent.dailycashreport.document.getElementById('called').value='maint';
		var servcode=document.getElementById('servGrpCode').value;
		var servdesc=document.getElementById('servGrpDesc').value;
		document.getElementById('Maintrptsergp').className = "tabClicked";
		document.getElementById('Maintrptsergpspan').className = "tabSpanclicked";
		document.getElementById('createrptsergp').className = "tabA";
		document.getElementById('createrptsergpspan').className = "tabAspan";	
		parent.AssocService.location.href = '../../eBL/jsp/MaintainServReportingGp.jsp?called=servload&servGpCode='+servcode+'&servGpdesc='+servdesc;
		parent.parent.parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
	}
}   

/* from_To_Cash_Counter Logic */
function counterLookup_fm(){
	var facility=document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
	var sql="";	
	sql="select distinct cash_counter_code code, long_desc description from bl_cash_counter_lang_vw WHERE language_id = '"+locale+"' and upper(operating_facility_id) = '"+facility+"' AND UPPER (cash_counter_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) order by 2 " 
	var title									= 	getLabel("eBL.CASH_COUNTER.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.fm_cash_counter.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{
		formObj.fm_cash_counter.value			=   retVal[1];
		formObj.fm_cash_counter1.value 			= 	retVal[0];
	}
	else
	{	
		formObj.fm_cash_counter.value			=   "";
		formObj.fm_cash_counter1.value 			= 	"";	
	}	
}


function counterLookup(){
	var facility=document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
	var sql="";
	
	sql="select distinct cash_counter_code code, long_desc description from bl_cash_counter_lang_vw WHERE language_id = '"+locale+"' and upper(operating_facility_id) = '"+facility+"' AND UPPER (cash_counter_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) order by 2 " 
	var title									= 	getLabel("eBL.CASH_COUNTER.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.to_cash_counter.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{	
		formObj.to_cash_counter.value			=   retVal[1];
		formObj.to_cash_counter1.value 			= 	retVal[0];
	}
	else
	{	
		formObj.to_cash_counter.value			=   "";
		formObj.to_cash_counter1.value 			= 	"";	
	}	
}

/* from_To_Cash_Counter Logic validation*/
function validcashcount(){
	var formObj 	= document.forms[0];
	var facility_id = formObj.facilityId.value;
	var detail 		= formObj.detail.value;
	var delivery 	= formObj.delivery.value;
	var report_date = formObj.report_date.value;
	var p_language_id    = formObj.locale.value;
	var p_date_format  = 'DD/MM/YYYY';
	var fm_cash_counter1    = formObj.fm_cash_counter1.value;
	var to_cash_counter1    = formObj.to_cash_counter1.value;
	var to_cash_counter    = formObj.to_cash_counter.value;
	
	$.ajax({
		type : 'POST',
		url : "../jsp/GenerateDayColRpt.jsp?func_mode=cashcol&facility_id="
				+ facility_id + "&report_date=" + report_date + "&p_date_format="
				+ p_date_format + "&fm_cash_counter1=" + fm_cash_counter1 + "&to_cash_counter1=" 
				+ to_cash_counter1+ "&p_language_id="
				+ p_language_id,
		async : false,
		dataType : "text",
		success : function(data) {
			var n=trimString(data);
			var n1 = n.indexOf("~");
			var n2 = n.indexOf("~",n1+1);
			var e=n.indexOf("::");
			
			var error_id=n.substring(n1+1,n2);
			if(e!='-1'){
			   var error_text=n.substring(e,n1);
			}
			else{
				var error_text="";
			}
	
			if (error_text != '') {
				if(error_id==null||error_id=='null')
				{	
					alert(error_text);
				}
			} else if(error_id!=''){
				if(error_id=='BL7141' || error_id=='BL6389'){
					alert(getMessage(error_id, "BLEXT"));
					formObj.to_cash_counter1.value="";
					formObj.to_cash_counter.value="";
					return false;
				}
				else{
					alert(getMessage(error_id, "BL"));
					formObj.to_cash_counter1.value="";
					formObj.to_cash_counter.value="";
					return false;
				}
			}else{
				return true;
			}
		}
	});
}

function trimString(sInString){
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function focus_val(){ 
	document.getElementById("report_date").focus();
}

function mand_fld(){
	var report_date    = document.forms[0].report_date.value;
	if(report_date==''){
			document.getElementById("report_date").focus();
			alert(getMessage("BL00948",'BL'));
			return false;
	}else{
		return true;
	}
}

function DateChk(entered_date){
	var report_date    = document.forms[0].report_date.value;
	var locale    = document.forms[0].locale.value;
	if(entered_date.value!="") {   	
		if(validDate(report_date,'DMY',locale)){
			if(report_date!=getCurrentDate('DMY',locale) && isAfterNow(report_date,'DMY',locale)==true){
				alert(getMessage("BL6386",'BL'));
				entered_date.value = '';
				return false;
			}
		}else
		{	
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.value='';
			return false;
		}
	}
	else
	{
		return true;
	}
}

function dateRegEx(e){  //Added for Character Restriction in date field
  var pattern = new RegExp("^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\/\-]\d{4}$");
  if (e.value.search(pattern)===0){
    return true;
  }
  else {
    alert("Please provide valid date in format dd/mm/yyyy");
    document.getElementById(e.id).focus();
    return false; 
  } 
}


function include_detail(){
	var check=document.getElementById('detail').checked;
	if(check=='true' || check==true){
		document.getElementById('detail').value='Y';
		document.getElementById("delivery").style.visibility = "visible";
		document.getElementById("delv").style.visibility = "visible";
	}else{
		document.getElementById('detail').value='N';
		document.getElementById("delivery").style.visibility = "hidden";
		document.getElementById("delv").style.visibility = "hidden";
	}
}

function break_delivery(){
	var check=document.getElementById('delivery').checked;
	if(check=='true' || check==true){
		document.getElementById('delivery').value='Y';
	}else{
		document.getElementById('delivery').value='N';
	}
}


function run(){
	var formObj 	="";
	var dummyDoc = "" ;
	if(window.name =="content"){
		formObj 	= parent.frames[2].dailycashrpt.document;
		dummyDoc = window.frames["dummy_frame"].document;
	}else if(window.name =="dailycashrpt"){
		formObj=document;
		dummyDoc =  parent.window.frames["dummy_frame"].document;  //genereate button
	}
	var facility_id = formObj.getElementById('facilityId').value;
	var detail 		= formObj.getElementById('detail').value;
	var delivery 	= formObj.getElementById('delivery').value;
	var report_date = formObj.getElementById('report_date').value;
	var locale    = formObj.getElementById('locale').value;
	var p_date_format  = 'DD/MM/YYYY';
	var fm_cash_counter1    = formObj.getElementById('fm_cash_counter1').value;
	var to_cash_counter1    = formObj.getElementById('to_cash_counter1').value; 
	var user    = formObj.getElementById('user').value;
	var p_report_id="";
	
	if(report_date==''){   
		formObj.getElementById('report_date').focus();
		alert(getMessage("BL00948",'BL'));
		return false;
	}
	if(validDate(report_date,'DMY',locale)){
			if(report_date==getCurrentDate('DMY',locale) && isAfterNow(report_date,'DMY',locale)==true){
				alert(getMessage("BL6386",'BL'));
				entered_date.value = '';
				return false;
			}
	}
	
	if(detail=='Y'){
		p_report_id='BLRDCASH';
	}else{
		p_report_id='BLRDACOL';
	}
	
	$.ajax({
		type : "POST",
		url : "../jsp/GenerateDayColRpt.jsp?func_mode=generaterpt&facility_id="
				+ facility_id + "&detail=" + detail + "&delivery="
				+ delivery + "&report_date=" + report_date +"&fm_cash_counter1="+fm_cash_counter1+
				"&to_cash_counter1="+to_cash_counter1+"&p_language_id="
				+ locale + "&p_date_format=" + p_date_format,
		async : false,
		dataType : "text",
		success : function(data) {
			var n=trimString(data);
			var n1 = n.indexOf("~");
			var n2 = n.indexOf("~",n1+1);
			var e=n.indexOf("::");
			var error_id=n.substring(n1+1,n2);			
			if(e!='-1'){
			   var error_text=n.substring(e+1,n1);
			}
			else{
				var error_text="";
			}
			
			if (error_text != ''){   
				if(error_id==null||error_id=='null')
				{	
					alert(error_text);
				}
			}else if(error_id!= ''){   
				alert(getMessage(error_id, "BL"));
			}else{
				var htmlVal = "<html><body>";
				htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
				htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
				htmlVal += "<input type='hidden' name='P_FACILITY_ID' id='P_FACILITY_ID' value='"+facility_id+"'>";
				htmlVal += "<input type='hidden' name='p_opr_facility_id' id='p_opr_facility_id' value='"+facility_id+"'>";
				htmlVal += "<input type='hidden' name='p_module' id='p_module' value='BL'>";
				htmlVal += "<input type='hidden' name='p_operator' id='p_operator' value='"+user+"'>";
				htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='BL'>";
				htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
				htmlVal += "<input type='hidden' name='P_REPORT_DATE' id='P_REPORT_DATE' value='"+report_date+"'>";
				htmlVal += "<input type='hidden' name='P_CASH_COUNTER_CODE_FRM' id='P_CASH_COUNTER_CODE_FRM' value='"+fm_cash_counter1+"'>";
				htmlVal += "<input type='hidden' name='P_CASH_COUNTER_CODE_TO' id='P_CASH_COUNTER_CODE_TO' value='"+to_cash_counter1+"'>";
				if(detail=='Y'){
					htmlVal += "<input type='hidden' name='P_BREAK_BY_DELIVERY_NO' id='P_BREAK_BY_DELIVERY_NO' value='"+delivery+"'>";
				}   
				htmlVal += "</form></body></html>";				
				
				dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
				dummyDoc.dummy_frm.submit();		 
			}
		}
	});
}

function selected_serv(e){
	var RowIndex=e.parentNode.parentNode.rowIndex;
	document.forms[0].select.checked=false;
	document.getElementById("select"+RowIndex).checked=true;
	var servCodeVal=document.getElementById("select"+RowIndex).checked;
	var undFlag=document.getElementById("checkboxundef"+RowIndex).checked;
	var exmpFalg=document.getElementById("checkboxexempt"+RowIndex).checked;
	if(undFlag==true || undFlag=='true' || exmpFalg=='true' || exmpFalg==true){
		document.getElementById("Associate").disabled=true;
	}else{
		document.getElementById("Associate").disabled=false;
	}
	document.getElementById("rowval").value=RowIndex;
}

function AssocServ(obj){
	var RowIndex=document.getElementById("rowval").value;
	var grpsave=document.getElementById("grpsave").value;
	var totrec=document.getElementById("totrecords").value;
	var grpSize=document.getElementById("grpSize").value;
	if(totrec!=grpSize){
	if(grpsave=="Y"){
	  if(RowIndex!=""){
		var servCodeVal=document.getElementById("select"+RowIndex).checked;
		var servGpCode=document.getElementById("ServGroupCode"+RowIndex).value;
		var servGpdesc=document.getElementById("LongDesc"+RowIndex).value;
		var shrtdesc=document.getElementById("ShortDesc"+RowIndex).value;
	  if(obj=="associate"){
		   if(servGpCode!="" && servGpdesc!="" && shrtdesc!=""){
				parent.SetupSplGrptab.document.getElementById('assocservgp').className = "tabClicked";
				parent.SetupSplGrptab.document.getElementById('assocservgpspan').className = "tabSpanclicked";
				parent.SetupSplGrptab.document.getElementById('reportservgp').className = "tabA";
				parent.SetupSplGrptab.document.getElementById('reportservgpspan').className = "tabAspan";	
				parent.SetupSplGrp.location.href = '../../eBL/jsp/AssociateServFrame.jsp?called=associate&servGpCode='+servGpCode+'&servGpdesc='+servGpdesc;
			}else{
				if(servGpCode==''){
					document.getElementById("ServGroupCode"+RowIndex).focus();
					alert(getMessage("BL00948",'BL'));
					return false;
				}else if(servGpdesc==""){
					document.getElementById("LongDesc"+RowIndex).focus();
					alert(getMessage("BL00948",'BL'));
					return false;
					}
				}
	  		}
		}
		}
		else{
			alert(getMessage("BL0930",'BLEXT')); //save or discard changes message
			return false;
		}
	}else if(totrec==grpSize){
		  if(RowIndex!=""){
				var servCodeVal=document.getElementById("select"+RowIndex).checked;
				var servGpCode=document.getElementById("ServGroupCode"+RowIndex).value;
				var servGpdesc=document.getElementById("LongDesc"+RowIndex).value;
				var shrtdesc=document.getElementById("ShortDesc"+RowIndex).value;
			  if(obj=="associate"){
				   if(servGpCode!="" && servGpdesc!="" && shrtdesc!=""){
						parent.SetupSplGrptab.document.getElementById('assocservgp').className = "tabClicked";
						parent.SetupSplGrptab.document.getElementById('assocservgpspan').className = "tabSpanclicked";
						parent.SetupSplGrptab.document.getElementById('reportservgp').className = "tabA";
						parent.SetupSplGrptab.document.getElementById('reportservgpspan').className = "tabAspan";	
						parent.SetupSplGrp.location.href = '../../eBL/jsp/AssociateServFrame.jsp?called=associate&servGpCode='+servGpCode+'&servGpdesc='+servGpdesc;
					}else{
						if(servGpCode==''){
							document.getElementById("ServGroupCode"+RowIndex).focus();
							alert(getMessage("BL00948",'BL'));
							return false;
						}else if(servGpdesc==""){
							document.getElementById("LongDesc"+RowIndex).focus();
							alert(getMessage("BL00948",'BL'));
							return false;
							}
						}
			  		}
				}
		}
	
}

//setup special group exempted items checkbox  
function  checkExemValid(e,obj){ 
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var checkboxexempt=document.getElementById("checkboxexempt"+RowIndex).checked;
	if(obj!='0'){
		if(checkboxexempt==false){
			document.getElementById("checkboxexempt"+RowIndex).checked=true;
			document.getElementById("checkboxexempt"+RowIndex).value='Y';
		}else if(checkboxexempt==true){
			document.getElementById("checkboxexempt"+RowIndex).checked=false;
			alert(getMessage("BL6380", "BL"));
			return false;
		}
	} else{
		if(checkboxexempt==false){ 
			document.getElementById("checkboxexempt"+RowIndex).checked=false;
			document.getElementById("checkboxexempt"+RowIndex).value='N';
		}else if(checkboxexempt==true){
			document.getElementById("checkboxexempt"+RowIndex).checked=true;
			document.getElementById("checkboxundef"+RowIndex).checked=false;
			document.getElementById("checkboxexempt"+RowIndex).value='Y';
			document.getElementById("checkboxundef"+RowIndex).value='N';
		}
	}	
}

//setup special group undefined items checkbox
function checkUndefValid(e,obj){ 
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var checkboxundef=document.getElementById("checkboxundef"+RowIndex).checked;
	if(obj!='0'){
		if(checkboxundef==false){
			document.getElementById("checkboxundef"+RowIndex).checked=true;
			document.getElementById("checkboxundef"+RowIndex).value='Y';
		}else if(checkboxundef==true){
			document.getElementById("checkboxundef"+RowIndex).checked=false;
			alert(getMessage("BL6380", "BL"));
			return false;
		}
	}else{
		if(checkboxundef==false){ 
			document.getElementById("checkboxundef"+RowIndex).checked=false;
			document.getElementById("checkboxundef"+RowIndex).checked='N';
		}else if(checkboxundef==true){
			document.getElementById("checkboxundef"+RowIndex).checked=true;
			document.getElementById("checkboxexempt"+RowIndex).checked=false;
			document.getElementById("checkboxexempt"+RowIndex).value='N';
			document.getElementById("checkboxundef"+RowIndex).value='Y';
		}
	}
}
//To copy long desc to short desc
function shrtdesc(e){
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var longdesc=document.getElementById("LongDesc"+RowIndex).value;
	var shortdesc=document.getElementById("ShortDesc"+RowIndex).value;
	var servgrp=document.getElementById("ServGroupCode"+RowIndex).value;
	if(servgrp!=""){
		if(longdesc!="" && shortdesc==""){
			document.getElementById("ShortDesc"+RowIndex).value=longdesc;
		}
	}
}

//validate service grp
function validdesc(e){
	var RowIndex  =e.parentNode.parentNode.rowIndex;
	var id="LongDesc"+RowIndex;
	var longdesc  =document.getElementById("LongDesc"+RowIndex).value;
	var shortdesc=document.getElementById("ShortDesc"+RowIndex).value;
	var servgrp   =document.getElementById("ServGroupCode"+RowIndex).value;
	if(servgrp=="" && (longdesc != "" || shortdesc !="")){
		document.getElementById("ShortDesc"+RowIndex).value="";
		document.getElementById("LongDesc"+RowIndex).value="";
		document.getElementById("ServGroupCode"+RowIndex).focus();
		alert(getMessage("BL00948",'BL'));
		return false;
	}else if(longdesc=="" && (servgrp != "" && shortdesc !="")){
		document.getElementById("ShortDesc"+RowIndex).value="";
		document.getElementById("LongDesc"+RowIndex).focus();
		alert(getMessage("BL00948",'BL'));
		return false;
	}else if(shortdesc=="" && (servgrp != "" && longdesc !="")){
		//document.getElementById("ShortDesc"+RowIndex).value="";
		document.getElementById("ShortDesc"+RowIndex).focus();
		alert(getMessage("BL00948",'BL'));
		return false;
	}else if(servgrp !="" && longdesc =="" && shortdesc=="" && e.id==id){
		//document.getElementById("ShortDesc"+RowIndex).value="";
		document.getElementById("LongDesc"+RowIndex).focus();
		alert(getMessage("BL00948",'BL'));
		return false;
	}
}

//To check duplicate group code
function checkDuplicate(e){
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var currServGp=document.getElementById("ServGroupCode"+RowIndex).value;
	if( currServGp!=""){
		for(var m=1;m<RowIndex;m++){
			var servgp=document.getElementById("ServGroupCode"+m).value;
			if(currServGp==servgp){
				alert(getMessage("BL0931", "BLEXT"));
				document.getElementById("ServGroupCode"+RowIndex).value='';	
				document.getElementById("ServGroupCode"+RowIndex).focus();
				return false;
			}  
		}
	}
}


// to enable the next row in reporting service group
function enableNext(e){
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var enableRow=RowIndex+1;
	document.getElementById("totrecords").value=RowIndex;
	var servgp=document.getElementById("ServGroupCode"+RowIndex).value;
	var longdesc=document.getElementById("LongDesc"+RowIndex).value;
	var shortdesc=document.getElementById("ShortDesc"+RowIndex).value;
	if(RowIndex<14){
	if(servgp!=""){
		if(longdesc!="" && shortdesc!=""){   
			document.getElementById('serviceRow'+enableRow).disabled = false;			
			document.getElementById("selectbutton"+enableRow).disabled = false;
			document.getElementById("servgrpCodefld"+enableRow).disabled = false;
			document.getElementById("longdescFld"+enableRow).disabled = false;
			document.getElementById("shortDescfld"+enableRow).disabled = false;
			document.getElementById("checkboxundefFld"+enableRow).disabled = false;
			document.getElementById("checkboxexemptFld"+enableRow).disabled = false;			
			document.getElementById("ServGroupCode"+enableRow).readOnly="";
			document.getElementById("LongDesc"+enableRow).readOnly="";
			document.getElementById("ShortDesc"+enableRow).readOnly="";
			document.getElementById("checkboxundef"+enableRow).readOnly="";
			document.getElementById("checkboxexempt"+enableRow).readOnly="";
			
			document.getElementById("select"+enableRow).readOnly="";
			}
		}
	}
}

//Create service group tab
function serviceFromTo(obj, code){
	var servicetype=document.getElementById('ServiceType').value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
    var sql="";
	var title 	= '';
	
	if(servicetype=='I'){	
		sql="select item_code Code,SHORT_desc description from mm_item_lang_vw where  upper(language_id)=upper('"+locale+"') AND UPPER (item_code) LIKE UPPER (?) AND UPPER (SHORT_desc) LIKE UPPER (?) order by 1 desc";
		title	= 	getLabel("eBL.MaterialItems.label", "bl");
	}else{
		sql="SELECT BLNG_SERV_CODE Code,SHORT_DESC description FROM   BL_BLNG_SERV_LANG_VW WHERE 	UPPER(LANGUAGE_ID)=upper('"+locale+"') AND UPPER (BLNG_SERV_CODE) LIKE UPPER (?) AND UPPER (SHORT_DESC) LIKE UPPER (?) ";
		 title	= 	getLabel("eBL.BillingServices.label", "bl");
	}
	
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	code.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	DESC_CODE ;
		retVal 										=   CommonLookup( title, argumentArray );	
		if(retVal != null && retVal != "")
		{	
			code.value		=   retVal[0];
			obj.value 		= 	retVal[1];
		}
		else
		{	
			code.value			=   "";
			obj.value 		    = 	"";	
		}	
}

function shortDescChange(val){
	if(val.value=='N'){
		document.getElementById('shortdes').disabled=true;
	}else{
		document.getElementById('shortdes').disabled=false;
	}
}

function cleardata(){
	var length=0;
	var len=document.getElementById('servcount').value;
	if(len<8){
		length=8;
	}else{
		length=len;
	}
	var table = document.getElementById('servItemRows');
	var rowCount = table.rows.length;
	if(length<9){
		for(var m=length;m>=1;m--){
			table.deleteRow(m);
		}
	}
	else if(length>9){
		for(var m=length;m>=1;m--){
			table.deleteRow(m);
		}
	}	
	for(var i=0;i<8;i++){
		var row = table.insertRow(1);
		var newcell	= row.insertCell(0);
		newcell.innerHTML ="<td align='center' ><input type='text' style='width:100%;' name='servCode"+i+"' id='servCode"+i+"'  id='servCode"+i+"' style='width='100%';' value=''></td>";
		newcell.style.textAlign = "center";
		var newcell1	= row.insertCell(1);
		newcell1.innerHTML ="<td align='center' ><input type='text' style='width:100%;' name='servDesc"+i+"' id='servDesc"+i+"'  id='servDesc"+i+"' style='width='100%';' value=''></td>";
		newcell1.style.textAlign = "center";
		var newcell2	= row.insertCell(2);
		newcell2.innerHTML ="<td align='center' ><input type='checkbox'  name='servCheck"+i+"' id='servCheck"+i+"'  id='servCheck"+i+"' style='width='100%';' value='' onclick='selectserv(this)'></td>";
		newcell2.style.textAlign = "center";
	}
}

function displayServices(){
	var fromServItmCode=document.getElementById('servfrm').value;
	var toServItmCode=document.getElementById('servto').value;
	var shrtDescOpt=document.getElementById('shrtdesc').value;
	var searchTxt=document.getElementById('shortdes').value;
	var locale = document.forms[0].locale.value;
	var serv_item_ind=document.getElementById('ServiceType').value;
	var facility_id=document.forms[0].FacilityId.value;
    var formObj = document.forms[0];
   if(shrtDescOpt!='N'){
    	if(searchTxt==''){
    		document.getElementById("shortdes").focus();
			alert(getMessage("BL00948",'BL'));
			return false;
    	}
    }
	var sql="";
	$.ajax({
		type : 'POST',
		url : "../jsp/BLDisplayServices.jsp?facility_id="
				+ facility_id + "&fromServItmCode=" + fromServItmCode + "&toServItmCode="
				+ toServItmCode + "&shrtDescOpt=" + shrtDescOpt + "&searchTxt=" 
				+ searchTxt + "&locale="
				+ locale+ "&serv_item_ind="
				+ serv_item_ind,
        dataType: "text",
		async : false,
		success : function(data) {
			try{
				var n=trimString(data);
				var n1 = n.indexOf("[");
				var c=n.substring(n1);
				var json =JSON.parse(c); 
				var table = document.getElementById('servItemRows');
				var rowCount = table.rows.length;
				document.getElementById('servcount').value=json.length;
				if(json.length!=0){
					if( json.length<8){
						var n=8-json.length;
						for(var m=8;m>n;m--){
							table.deleteRow(m);
						}
					}
					else{
					 for(var m=8;m>=1;m--){
						table.deleteRow(m);
					}
				  }
				}
				for(var i=0; i<json.length; i++) {
					var row = table.insertRow(1);
					var obj = json[i];
					var newcell	= row.insertCell(0);
					newcell.innerHTML ="<td align='center' ><input type='text' style='width:100%;' name='servCode"+i+"' id='servCode"+i+"'  id='servCode"+i+"' style='width='100%';' value='"+obj.code+"'></td>";
					newcell.style.textAlign = "center";
					var newcell1	= row.insertCell(1);
					newcell1.innerHTML ="<td align='center' ><input type='text' style='width:100%;' name='servDesc"+i+"' id='servDesc"+i+"'  id='servDesc"+i+"' style='width='100%';' value='"+obj.description+"'></td>";
					newcell1.style.textAlign = "center";
					var newcell2	= row.insertCell(2);
					newcell2.innerHTML ="<td align='center' ><input type='checkbox'  name='servCheck"+i+"' id='servCheck"+i+"'  id='servCheck"+i+"' style='width='100%';' value='' onclick='selectserv(this)'></td>";
					newcell2.style.textAlign = "center";
				}
			}catch(e){
				alert("Exception in JSON  "+e.message);
			}
		},
		 error: function(data){
			 alert("Error in JSON  "+String(data));
		 }
	});
}

function selectserv(i){
	var table = document.getElementById('servItemRows');
	var RowIndex=i.parentNode.parentNode.rowIndex;
	var selectChkbox = table.rows[RowIndex].cells[2].getElementsByTagName('input')[0];
	var serviceInd=document.getElementById('ServiceType').value;
	
	var servicecount=document.getElementById('servcount').value;
	var index=servicecount-RowIndex;
	if('checkbox' == selectChkbox.type && true == selectChkbox.checked){
		dataArr.push(index);
	}else{
		dataArr=removeItemAll(dataArr,index)	;
	}
	
	if(dataArr!=null){
		document.getElementById("selectidx").value = "Y";
	}else{
		document.getElementById("selectidx").value = "N";
	}
}

//Function to remove element from JS array
function removeItemAll(arr, value) {
	var i = 0;
	while (i < arr.length) {
	if (arr[i] === value) {
		arr.splice(i, 1);
	} else {
		++i;
		}
	}
	return arr;
}

//Select all function
function selectallserv(){
	var servcounting = document.forms[0].servcount.value;	
	var selectall = document.getElementById("selectall");
	var j=servcounting-1;
	if(selectall.checked) {		
		document.getElementById("selectidx").value = "Y";
		for(var i=j;i>=0;i--){
			document.getElementById("servCheck"+i).checked = true;
			document.getElementById("servCheck"+i).value = "Y";
			dataArr.push(i);
		}
	}else{
		document.getElementById("selectidx").value = "N";
		for( i=0;i<servcounting;i++){			
			document.getElementById("servCheck"+i).checked = false;
			document.getElementById("servCheck"+i).value = "N";
			dataArr=removeItemAll(dataArr,i);
		}
	}
}

function associateServices(){
	var user=document.getElementById('user').value;
	var p_serv_ind=document.getElementById('ServiceType').value;
	var locale = document.forms[0].locale.value;
	var servGpCode=parent.AssocServtab.document.getElementById("servGrpCode").value;
	var selectall=document.getElementById('selectidx').value;
	var facility_id=document.forms[0].FacilityId.value;
	var count1=document.getElementById('servcount').value;
	var table1 = document.getElementById('servItemRows');
	var paramlen="";
	var params1 ="";
	//var param = [];
	for(var z=0;z<dataArr.length;z++){
		var idx =dataArr[z];
		var code1 = document.getElementById("servCode"+idx).value;
		var desc1 = document.getElementById("servDesc"+idx).value;
		//params1+= "@"+code1+"~"+desc1+"~"+p_serv_ind;
		params1+=code1+"~"+desc1+"~"+p_serv_ind+",,,,,";
	}
	parent.AssocServtab.document.getElementById("tempserviceVal").value=params1;   
	//var params1 = encodeURIComponent(params1);
	paramlen = dataArr.length;
    parent.AssocServtab.document.getElementById("servcnt").value=paramlen;
	if(selectall=='N'){
		alert(getMessage("BL9802", "BL"));
		return false;
	}else{  
		parent.parent.parent.dailycashreport.document.getElementById('called').value="maint";
		parent.AssocServtab.document.getElementById('Maintrptsergp').className = "tabClicked";
		parent.AssocServtab.document.getElementById('Maintrptsergpspan').className = "tabSpanclicked";
		parent.AssocServtab.document.getElementById('createrptsergp').className = "tabA";
		parent.AssocServtab.document.getElementById('createrptsergpspan').className = "tabAspan";	
		parent.AssocService.location.href = '../../eBL/jsp/MaintainServReportingGp.jsp?called=createserv&paramlen='+paramlen+"&servGpCode="+servGpCode+"&selectall="+selectall;
	}		
	

/*  
  
  $.ajax({
		type : "POST",
		url : "../jsp/BLAssociateServices.jsp?facility_id="
				+ facility_id + "&selectall=" + selectall + "&servGpCode="
				+ servGpCode +
				"&p_serv_ind="+p_serv_ind +"&user="
				+ user,
		async : false,
		data : { servCodeDesc: params1 },
		dataType : "text",
		success : function(data){
			var n=trimString(data);
			var n1 = n.indexOf("~");
			var n2 = n.indexOf("~",n1+1);
			var e=n.indexOf("::");
			var error_id=n.substring(n1+1,n2);	
			
			if(e!='-1'){
			   var error_text=n.substring(e+1,n1);
			}
			else{
				var error_text="";
			}
			
			if (error_text != ''){  
				if(error_id==null||error_id=='null')
				{	
					alert(error_text);
				}
			}else if(error_id!= ''){   
				alert(getMessage(error_id, "BL"));
			}else{  
				parent.parent.parent.dailycashreport.document.getElementById('called').value="maint";
				parent.AssocServtab.document.getElementById('Maintrptsergp').className = "tabClicked";
				parent.AssocServtab.document.getElementById('Maintrptsergpspan').className = "tabSpanclicked";
				parent.AssocServtab.document.getElementById('createrptsergp').className = "tabA";
				parent.AssocServtab.document.getElementById('createrptsergpspan').className = "tabAspan";	
				parent.AssocService.location.href = '../../eBL/jsp/MaintainServReportingGp.jsp?called=createserv&servCodeDesc='+params1+"&servGpCode="+servGpCode+"&selectall="+selectall;
			}			
		}
	});
	*/
}

//Maintain services tab
function servItemlkup(idx){
	var RowIndex=idx.parentNode.parentNode.rowIndex;
	var table = parent.AssocServtab.document.getElementById('MaintainserviceTbl');
	var serv_item_ind=document.getElementById('ServTypeval'+RowIndex).value;
	var facility=document.forms[0].FacilityId.value;
	var locale = document.forms[0].locale.value;
    var formObj = document.forms[0];	
    var serv_item_desc=document.getElementById('servitem'+RowIndex).value;
    var sql="";
	
	sql="Select code, description from (SELECT BLNG_SERV_CODE code,LONG_DESC description FROM  BL_BLNG_SERV_LANG_VW WHERE UPPER(LANGUAGE_ID)=UPPER('"+locale+"') "+
	"AND '"+serv_item_ind+"'  ='S' and  BLNG_SERV_CODE not in (select serv_item_code from BL_SERV_BY_REPORT_SERV_GROUP where UPPER(facility_id)= UPPER('"+facility+"') "+
	"and serv_item_ind='"+serv_item_ind+"'  ) union SELECT ITEM_CODE code,SHORT_DESC description FROM   MM_ITEM_LANG_VW WHERE UPPER(LANGUAGE_ID)=UPPER('"+locale+"') "+
	"AND '"+serv_item_ind+"'  ='I' and   ITEM_CODE not in (select serv_item_code from BL_SERV_BY_REPORT_SERV_GROUP where  UPPER(facility_id)= UPPER('"+facility+"') " +
	"and serv_item_ind='"+serv_item_ind+"' ) ) where  upper(code) like upper(?) and upper(description) like upper(?) order by 2";
	
	var title									= 	getLabel("eBL.BillingServices.label", "bl")+"/"+ getLabel("eBL.MaterialItems.label", "bl");
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	serv_item_desc;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );	
	if(retVal != null && retVal != "")
	{	
		document.getElementById('serviceitmDesc'+RowIndex).value=retVal[1];
		document.getElementById('servitem'+RowIndex).value=retVal[0];
	}
	else
	{	
		document.getElementById('serviceitmDesc'+RowIndex).value="";
		document.getElementById('servitem'+RowIndex).value="";
	}
}

//to enable the next row in Maintain service group
function enableNextRow(e){
	var RowIndex=e.parentNode.parentNode.rowIndex;
	var enableRow=RowIndex+1;
	document.getElementById("totalRec").value=RowIndex;
	var servitm=document.getElementById("ServTypeval"+RowIndex).value;
	var longdesc=document.getElementById("servitem"+RowIndex).value;
	var shortdesc=document.getElementById("serviceitmDesc"+RowIndex).value;
	if(servitm!=""){
		if(longdesc!="" && shortdesc!=""){   
			document.getElementById('servitmCode'+enableRow).disabled = false;		
			document.getElementById('ServTypeval'+enableRow).disabled = false;		//V210222
			document.getElementById("servitem"+enableRow).disabled = false;
			document.getElementById("servitembtn"+enableRow).disabled = false;
			document.getElementById("serviceitmDesc"+enableRow).disabled = false;
			document.getElementById("servitmCode"+enableRow).readOnly="";
			document.getElementById("servitem"+enableRow).readOnly="";
			document.getElementById("servitembtn"+enableRow).readOnly="";
		}
	}
}

function saveGroupService(){
	var totrec=document.getElementById("totrecords").value;
	var grpSize=document.getElementById("grpSize").value;
    var gpSize=grpSize;
    gpSize=++gpSize;
	var finArrValue="";
	var count=0;
	if(totrec!=grpSize){
	for(var z=gpSize;z<=totrec;z++){
		var ServGroupCode = document.getElementById("ServGroupCode"+z).value;
		var LongDesc = document.getElementById("LongDesc"+z).value;
		var ShortDesc = document.getElementById("ShortDesc"+z).value;
		var checkboxundef = document.getElementById("checkboxundef"+z).value;
		var checkboxexempt = document.getElementById("checkboxexempt"+z).value;
		
		if(ServGroupCode!=''){
			if(LongDesc==''){
				document.getElementById("LongDesc"+z).focus();
				alert(getMessage("BL00948",'BL'));
				return false;
			}else if(ShortDesc==''){
				document.getElementById("ShortDesc"+z).focus();
				alert(getMessage("BL00948",'BL'));
				return false;
				}
		}else{
			document.getElementById("ServGroupCode"+z).focus();
			alert(getMessage("BL00948",'BL'));
			return false;
		}//V210209
		
		finArrValue+=ServGroupCode+"~"+LongDesc+"~"+ShortDesc+"~"+checkboxundef+"~"+checkboxexempt+"@";
		count++;
		
	}
	document.getElementById("countval").value="";
	document.getElementById("countval").value=count;
	document.getElementById("grpArrCode").value="";
	document.getElementById("grpArrCode").value=finArrValue;
	document.BLrportserv.submit();
	//To avoid editing of saved records
	parent.SetupSplGrp.location.reload();
	document.getElementById("grpSize").value=totrec;
	}
	document.getElementById("grpsave").value="Y";
}

//Adding row for setup spl grp
function AddRow(){
	try{
		var table = document.getElementById('serviceTable1');
		var exemcount = document.getElementById("exemcount").value;
		var undefcount = document.getElementById("undefcount").value;
		var rowCount = table.rows.length;
		var index = rowCount ;
		document.getElementById("totrecords").value=index;
		var row = table.insertRow();
		var newcell	= row.insertCell(0);
		newcell.innerHTML ="<td align='center' ><input type='radio'  name='select' id='select'  id='select"+index+"' style='width='100%';' onclick='selected_serv(this)' value=''></td>";
		var newcell1	= row.insertCell(1);
		newcell1.innerHTML ="<td align='center' ><input type='text' style='width:100%;' maxlength='6' name='ServGroupCode"+index+"' id='ServGroupCode"+index+"'  id='ServGroupCode"+index+"'  onblur='ChangeUpperCase( this );checkDuplicate(this);' value=''></td>";
		newcell1.style.textAlign = "center";
		var newcell2	= row.insertCell(2);
		newcell2.innerHTML ="<td align='center' ><input type='text' style='width:100%;' name='LongDesc"+index+"' id='LongDesc"+index+"'  id='LongDesc"+index+"'  value='' onblur='shrtdesc(this);validdesc(this);'></td>";
		newcell2.style.textAlign = "center";
		var newcell3	= row.insertCell(3);
		newcell3.innerHTML ="<td align='center' ><input type='text' style='width:100%;' name='ShortDesc"+index+"' id='ShortDesc"+index+"'  id='ShortDesc"+index+"'  value='' onblur='validdesc(this);'></td>";
		newcell3.style.textAlign = "center";
		var newcell4	= row.insertCell(4);
		newcell4.innerHTML ="<td align='center' ><input type='checkbox'  name='checkboxundef"+index+"' id='checkboxundef"+index+"'  id='checkboxundef"+index+"' style='width='100%';' value='N' onclick='checkUndefValid(this,"+undefcount+")'></td>";
		newcell4.style.textAlign = "center";
		var newcell5	= row.insertCell(5);
		newcell5.innerHTML ="<td align='center' ><input type='checkbox'  name='checkboxexempt"+index+"' id='checkboxexempt"+index+"'  id='checkboxexempt"+index+"' style='width='100%';' value='N' onclick='checkExemValid(this,"+exemcount+")'></td>";
		newcell5.style.textAlign = "center";
	}catch(e){
		alert("Exception in setup spl grp add row  "+e.message);
	}
}

//save button   
function saveNewServ(){
	var servGrpCode=document.getElementById("servGrpCode").value;
	var servdesc=document.getElementById('servGrpDesc').value;
	var totrec=document.getElementById("totalRec").value;
	var grpSize=document.getElementById("grpSize").value;
	var gpSize=grpSize;
    gpSize=++gpSize;
    var serArrValue="";
	var count=0;
	if(totrec!=grpSize){
	  for(var j=gpSize;j<=totrec;j++){
		var ServTypeval = document.getElementById("ServTypeval"+j).value;
		var servitem = document.getElementById("servitem"+j).value;
		var serviceitmDesc = document.getElementById("serviceitmDesc"+j).value;
		if(ServTypeval!=''){
			if(servitem==''){
				document.getElementById("servitem"+j).focus();
				alert(getMessage("BL00948",'BL'));
				return false;
			}else if(serviceitmDesc==''){
				document.getElementById("serviceitmDesc"+j).focus();
				alert(getMessage("BL00948",'BL'));
				return false;
				}
		}
		
		serArrValue+=ServTypeval+"~"+servitem+"~"+serviceitmDesc+"@";
		count++;
	}
	document.getElementById("count").value="";
	document.getElementById("count").value=count;
	document.getElementById("servArrCode").value="";
	document.getElementById("servArrCode").value=serArrValue;
	document.MaintReportServ.submit();
	}
	document.getElementById("serviceSave").value="Y";
	document.getElementById("grpSize").value=totrec;
}

function servTypeChange(idx){
	var RowIndex=idx.parentNode.parentNode.rowIndex;
	document.getElementById('servitem'+RowIndex).value='';
	document.getElementById('serviceitmDesc'+RowIndex).value='';
  }

function AddRowServ(){
	try{
		var table = document.getElementById('MaintainserviceTbl');
		var rowCount = table.rows.length;
		var index = rowCount ;
		document.getElementById("totalRec").value=index;
		var row = table.insertRow();
		var newcell	= row.insertCell(0);
		newcell.innerHTML ="<td class='fields' nowrap> "+
			"<select id='ServTypeval"+index+"' style='width:90%;' name='ServTypeval"+index+"' id='ServTypeval"+index+"' onChange='servTypeChange(this)'> "+
				"<option value='S'>Billing Service</option> "+
				"<option value='I'>Material Item</option> "+
			"</select> "+
			"</td>";
		var newcell1	= row.insertCell(1);
		newcell1.innerHTML ="<td align='center' ><input type='text' style='width:90%;' maxlength='150' name='servitem"+index+"' id='servitem"+index+"'  id='servitem"+index+"' style='width='100%';' onblur='if(this.value!=''){servItemlkup(this);}' value=''>" +
				" <input type='button' name='servitembtn"+index+"' id='servitembtn"+index+"' id='servitembtn"+index+"' value='?' onClick='servItemlkup(this)'> "+
				"<input type='hidden' name='serv_item"+index+"' id='serv_item"+index+"' id='serv_item"+index+"'>"+
				"</td>";
		newcell1.style.textAlign = "left";
		var newcell2	= row.insertCell(2);
		newcell2.innerHTML ="<td align='center' colspan='2'><input type='text' style='width:100%;' maxlength='150' name='serviceitmDesc"+index+"' id='serviceitmDesc"+index+"'  id='serviceitmDesc"+index+"' style='width='100%';' value=''  onfocus='this.blur()' readonly></td>";
		newcell2.style.textAlign = "center";
		
	}catch(e){
		alert("Exception in maintain service add row  "+e.message);
	}
}

function reset(){
	self.location.reload();	
}

function onSuccess(){
	}

