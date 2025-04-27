var func ;

function addFuncTypeToBlankFrame(formHTML){
	document.addEventListener('DOMContentLoaded', function() {
	    // Reference to the iframe element
	    var blankFrame = document.getElementById('blankFrame');

	    // Ensure the iframe has loaded its content before manipulating it
	    blankFrame.onload = function() {
	        // Access the iframe's document
	        var blankFrameDocument = blankFrame.contentDocument || blankFrame.contentWindow.document;

	        // Ensure the body is available
	        if (blankFrameDocument.body) {
	            // Write the form HTML into the iframe's body
	            blankFrameDocument.body.innerHTML = formHTML;
	        } else {
	            // Retry if body is not yet available
	            blankFrameDocument.addEventListener('DOMContentLoaded', function() {
	                blankFrameDocument.body.innerHTML = formHTML;
	            });
	        }
	        // Close the document to complete the writing process
	        blankFrameDocument.close();
	    };
	});						
}


function create() {
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="81vh";
	document.getElementById("blankFrame").style.height="0vh";
	document.getElementById("messageFrame").style.height="9vh";
	func = blankFrame.document.tempForm.func.value
	if(func=="REPORT_TYPE")
	{
		f_query_add_mod.location.href = "../../eMR/jsp/addModifyReportType.jsp" ;
	}
	if(func=="APPLICATION_TYPE")
	{
		f_query_add_mod.location.href = "../../eMR/jsp/addModifyApplicationType.jsp" ;
	}
	if(func=="MEDICAL_BOARD_TYPE")
	{
 
		f_query_add_mod.location.href ="../../eMR/jsp/addModifyMedicalBoardType.jsp";
	}
	if(func=="MEDICAL_BOARD")
	{
 
		f_query_add_mod.location.href ="../../eMR/jsp/addModifyMedicalBoard.jsp";
	}
	if(func=="MR_REPORT_GROUP")
	{
 
		f_query_add_mod.location.href ="../../eMR/jsp/addModifyReportGroupSetup.jsp";
	}
	//Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
	if(func=="REQUESTOR_TYPE")
	{
 
		f_query_add_mod.location.href ="../../eMR/jsp/RequestorTypeAddModify.jsp";
	}
	
	if(func=="CHKLIST_FOR_MEDICAL_REPORT") // // added by mujafar for ML-MMOH-CRF-0762
	{
 
		f_query_add_mod.location.href ="../../eMR/jsp/ChecklistMedReportAddModify.jsp";
	}
	
 
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	func = blankFrame.document.tempForm.func.value
	if(func=="REPORT_TYPE")
	{
		
	f_query_add_mod.location.href = "../../eMR/jsp/ReportTypeQueryCriteria.jsp" ;
	}
	if(func=="APPLICATION_TYPE")
	{
		
	f_query_add_mod.location.href = "../../eMR/jsp/ApplicationTypeQueryCriteria.jsp" ;
	}
	if(func=="MEDICAL_BOARD_TYPE")
	{
		
	f_query_add_mod.location.href = "../../eMR/jsp/MedicalBoardTypeQueryCriteria.jsp";
	}
	if(func=="MEDICAL_BOARD")
	{

	f_query_add_mod.location.href = "../../eMR/jsp/MedicalBoardQueryCriteria.jsp";
	}
	if(func=="MR_REPORT_GROUP")
	{
		
	f_query_add_mod.location.href = "../../eMR/jsp/ReportGroupSetupQueryCriteria.jsp";
	}
	//Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
	if(func=="REQUESTOR_TYPE")
	{
		
	f_query_add_mod.location.href = "../../eMR/jsp/RequestorTypeQueryCriteria.jsp";
	}
	
	if(func=="CHKLIST_FOR_MEDICAL_REPORT") // added by mujafar for ML-MMOH-CRF-0762
	{
		
	f_query_add_mod.location.href = "../../eMR/jsp/CheckListQueryCriteria.jsp";
	}
	
	
	
}

function apply() {
		if (! (checkIsValidForProceed()) ){
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	
	func = blankFrame.document.tempForm.func.value;
	if(func=="MEDICAL_BOARD")
	{
		var fields = new Array (f_query_add_mod.document.MedicalBoardFrm.medical_board_code,
					f_query_add_mod.document.MedicalBoardFrm.long_desc,
					f_query_add_mod.document.MedicalBoardFrm.short_desc,
				f_query_add_mod.document.MedicalBoardFrm.medical_board_type_code);

		var names = new Array ( getLabel("Common.code.label","Common"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"),getLabel("eMR.MedicalBoardType.label","MR"));

		var field = new Array (	f_query_add_mod.document.MedicalBoardFrm.medical_board_code);

		var name = new Array ( getLabel("Common.code.label","Common"));
		
	}
	else if(func=="MEDICAL_BOARD_TYPE")
	{
		var fields = new Array (f_query_add_mod.document.medboardtype_form.med_board_typecode,
						f_query_add_mod.document.medboardtype_form.long_desc,
						f_query_add_mod.document.medboardtype_form.short_desc);

		var names = new Array (getLabel("Common.code.label","Common"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"));

		var field = new Array (	f_query_add_mod.document.medboardtype_form.med_board_typecode);
 
		var name = new Array ( getLabel("Common.code.label","Common"));

	}
	//Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
	else if(func=="REQUESTOR_TYPE")
	{
		var fields="";  // added by mujafar for ML-MMOH-CRF-0762 start
		var names = "";
		
		if(f_query_add_mod.document.requestorTypeForm.classification_appl_yn.value == "true")
		{
			fields = new Array (f_query_add_mod.document.requestorTypeForm.requestor_type_code,
						f_query_add_mod.document.requestorTypeForm.long_desc,
						f_query_add_mod.document.requestorTypeForm.short_desc,
						f_query_add_mod.document.requestorTypeForm.class_indicator);
			
			 names = new Array (getLabel("Common.code.label","Common"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"),
					getLabel("Common.Classification.label","Common"));
					
		}
		else
		{
			fields = new Array (f_query_add_mod.document.requestorTypeForm.requestor_type_code,
						f_query_add_mod.document.requestorTypeForm.long_desc,
						f_query_add_mod.document.requestorTypeForm.short_desc);
						
			 names = new Array (getLabel("Common.code.label","Common"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"));
		}
         // added by mujafar for ML-MMOH-CRF-0762 end
		
		

		var field = new Array (	f_query_add_mod.document.requestorTypeForm.requestor_type_code);
 
		var name = new Array ( getLabel("Common.code.label","Common"));

	}
	else if(func=="CHKLIST_FOR_MEDICAL_REPORT") // added by mujafar for ML-MMOH-CRF-0762
	{
		var fields="";  
		var names = "";
		
		fields = new Array (f_query_add_mod.document.checkListForm.chk_list_code,
						f_query_add_mod.document.checkListForm.long_desc,
						f_query_add_mod.document.checkListForm.short_desc);
						
					
						
			 names = new Array (getLabel("eMR.CheckLists.label","MR") + " " + getLabel("Common.code.label","common"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"));
					
					
	var field = new Array (	f_query_add_mod.document.checkListForm.chk_list_code);
 
		var name = new Array ( getLabel("Common.code.label","Common"));
		
		
	}
	else if(func=="MR_REPORT_GROUP"){
//			var oldvalue=parent.frames[1].frames[1].document.forms[0].order_serial_no.value;
			var oldvalue=f_query_add_mod.document.forms[0].order_serial_no.value;
			var newvalue=f_query_add_mod.document.forms[0].serial_no.value;
			if(eval(newvalue)==0 || eval(newvalue)< 0){ 
				var msg=getMessage('INVALID_SERIAL_NO','MR');
				parent.frames[1].frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				return false;
			 }else{
				var GroupCode_lbl	=	f_query_add_mod.getLabel("Common.GroupCode.label","Common");
				var GroupName_lbl	=	f_query_add_mod.getLabel("Common.GroupName.label","Common");
				var report_lbl			=	f_query_add_mod.getLabel("Common.report.label","Common");
				var Level2_lbl			=	f_query_add_mod.getLabel("eMR.level2group.label","eMR");
				var Master_lbl			=	f_query_add_mod.getLabel("eMR.Master.label","eMR");
				var OrderSrlNo_lbl	=	f_query_add_mod.getLabel("Common.OrderSrlNo.label","Common");
				var Level3_lbl			=	f_query_add_mod.getLabel("Common.Level.label","Common")+"3";
				var Level1_lbl			=	f_query_add_mod.getLabel("eMR.level1group.label","eMR");
				var Range_lbl			=	f_query_add_mod.getLabel("Common.Range.label","Common");

				var Group_type_lbl		= 	f_query_add_mod.getLabel("Common.GroupType.label","Common");
				/*Added by Rameswar on  17-08-2016 for ML-MMOH-SCF-0467*/
				if(oldvalue==newvalue){
				//				parent.frames[1].frames[1].document.forms[0].newstatus.value="Y";
					f_query_add_mod.document.forms[0].newstatus.value="Y";
				}else{
				//				parent.frames[1].frames[1].document.forms[0].newstatus.value="N";
					f_query_add_mod.document.forms[0].newstatus.value="N";
				}
//				alert(f_query_add_mod.document.ReportGroupFrm.Report_Id.value)
				if(f_query_add_mod.document.ReportGroupFrm.Report_Id.value=="MRBRADEX" ||			f_query_add_mod.document.ReportGroupFrm.Report_Id.value=="MRBLABRG" || f_query_add_mod.document.ReportGroupFrm.Report_Id.value=="MROPCSMB" || f_query_add_mod.document.ReportGroupFrm.Report_Id.value=="MRIPCSMB" || f_query_add_mod.document.ReportGroupFrm.Report_Id.value=="MROPCSMS" || f_query_add_mod.document.ReportGroupFrm.Report_Id.value=="MRIPCSBD" || f_query_add_mod.document.ReportGroupFrm.Report_Id.value=="MRDCPROS") {

					if(f_query_add_mod.document.ReportGroupFrm.Group_type.value=="S" && f_query_add_mod.document.ReportGroupFrm.function_name.value=="insert"){
						var fields = new Array (f_query_add_mod.document.ReportGroupFrm.group_code,f_query_add_mod.document.ReportGroupFrm.group_name,f_query_add_mod.document.ReportGroupFrm.Report_Id,f_query_add_mod.document.ReportGroupFrm.Main_Group_desc,f_query_add_mod.document.ReportGroupFrm.type,f_query_add_mod.document.ReportGroupFrm.serial_no);
						var names = new Array ( GroupCode_lbl,GroupName_lbl,report_lbl,Level2_lbl,Master_lbl,OrderSrlNo_lbl);
					}else if(f_query_add_mod.document.ReportGroupFrm.Group_type.value=="G" && f_query_add_mod.document.ReportGroupFrm.function_name.value=="insert"){
						var fields = new Array (f_query_add_mod.document.ReportGroupFrm.group_code,f_query_add_mod.document.ReportGroupFrm.group_name,f_query_add_mod.document.ReportGroupFrm.Report_Id,f_query_add_mod.document.ReportGroupFrm.Main_Group_desc,f_query_add_mod.document.ReportGroupFrm.LEVEL3_CODE_INSERT,f_query_add_mod.document.ReportGroupFrm.range,f_query_add_mod.document.ReportGroupFrm.type,f_query_add_mod.document.ReportGroupFrm.serial_no);
						var names = new Array (GroupCode_lbl,GroupName_lbl,report_lbl,Level2_lbl,Level3_lbl,Range_lbl,Master_lbl,OrderSrlNo_lbl);
					}
					//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
					else if(f_query_add_mod.document.ReportGroupFrm.Report_Id.value=="MROPCSMS" || f_query_add_mod.document.ReportGroupFrm.Report_Id.value=="MRDCPROS"){
						var fields = new Array (f_query_add_mod.document.ReportGroupFrm.group_code,f_query_add_mod.document.ReportGroupFrm.group_name,f_query_add_mod.document.ReportGroupFrm.Report_Id,f_query_add_mod.document.ReportGroupFrm.range,f_query_add_mod.document.ReportGroupFrm.type,f_query_add_mod.document.ReportGroupFrm.serial_no);
						var names = new Array ( GroupCode_lbl,GroupName_lbl,report_lbl,Range_lbl,Master_lbl,OrderSrlNo_lbl);
					}else{
						var fields = new Array (f_query_add_mod.document.ReportGroupFrm.group_code,f_query_add_mod.document.ReportGroupFrm.group_name,f_query_add_mod.document.ReportGroupFrm.Report_Id,f_query_add_mod.document.ReportGroupFrm.type,f_query_add_mod.document.ReportGroupFrm.serial_no);
						var names = new Array (GroupCode_lbl,GroupName_lbl,report_lbl,Master_lbl,OrderSrlNo_lbl);
					}
				}else{
							/*Added For incident 17000 for 5.x Modification On 12/9/2009*/
						if(f_query_add_mod.document.ReportGroupFrm.Group_type.options.selectedIndex==1){/*Added by Rameswar on  17-08-2016 for ML-MMOH-SCF-0467 -Start*/
							if(f_query_add_mod.document.ReportGroupFrm.Report_Id.value =='MRBPD207' && f_query_add_mod.document.ReportGroupFrm.type.value =='BC'){
							 var fields = new Array (f_query_add_mod.document.ReportGroupFrm.group_code,f_query_add_mod.document.ReportGroupFrm.group_name,f_query_add_mod.document.ReportGroupFrm.Report_Id,f_query_add_mod.document.ReportGroupFrm.type,f_query_add_mod.document.ReportGroupFrm.Main_Group_desc,f_query_add_mod.document.ReportGroupFrm.serial_no,f_query_add_mod.document.ReportGroupFrm.group_type_new);
						   var names = new Array (GroupCode_lbl,GroupName_lbl,report_lbl,Master_lbl,Level1_lbl,OrderSrlNo_lbl,Group_type_lbl);	
						   /*Added by Rameswar on  17-08-2016 for ML-MMOH-SCF-0467 -End*/	
							}else{
						   var fields = new Array (f_query_add_mod.document.ReportGroupFrm.group_code,f_query_add_mod.document.ReportGroupFrm.group_name,f_query_add_mod.document.ReportGroupFrm.Report_Id,f_query_add_mod.document.ReportGroupFrm.type,f_query_add_mod.document.ReportGroupFrm.Main_Group_desc,f_query_add_mod.document.ReportGroupFrm.serial_no);
						   var names = new Array (GroupCode_lbl,GroupName_lbl,report_lbl,Master_lbl,Level1_lbl,OrderSrlNo_lbl);	
						   }					
					   }else{/*Added by Rameswar on  17-08-2016 for ML-MMOH-SCF-0467 -Start*/
					   	if(f_query_add_mod.document.ReportGroupFrm.Report_Id.value =='MRBPD207' && f_query_add_mod.document.ReportGroupFrm.type.value =='BC'){
					   		var fields = new Array (f_query_add_mod.document.ReportGroupFrm.group_code,f_query_add_mod.document.ReportGroupFrm.group_name,f_query_add_mod.document.ReportGroupFrm.Report_Id,f_query_add_mod.document.ReportGroupFrm.type,f_query_add_mod.document.ReportGroupFrm.serial_no,f_query_add_mod.document.ReportGroupFrm.group_type_new);
						   var names = new Array (GroupCode_lbl,GroupName_lbl,report_lbl,Master_lbl,OrderSrlNo_lbl,Group_type_lbl);
						   /*Added by Rameswar on  17-08-2016 for ML-MMOH-SCF-0467 -End*/
					   		}else{
						   var fields = new Array (f_query_add_mod.document.ReportGroupFrm.group_code,f_query_add_mod.document.ReportGroupFrm.group_name,f_query_add_mod.document.ReportGroupFrm.Report_Id,f_query_add_mod.document.ReportGroupFrm.type,f_query_add_mod.document.ReportGroupFrm.serial_no);
						   var names = new Array (GroupCode_lbl,GroupName_lbl,report_lbl,Master_lbl,OrderSrlNo_lbl);
						}
					   }
				}

					var field = new Array (	f_query_add_mod.document.ReportGroupFrm.group_code);
					var name = new Array (GroupCode_lbl);
 	}

	}else{ 
		
		// site specific check added by mujafar for ML-MMOH-CRF-0704
		
		
		
		if(f_query_add_mod.document.HighRisk_form.holiday_duration_applicable.value == 'true')
		{  
		var fields = new Array (f_query_add_mod.document.HighRisk_form.high_risk_code,
					f_query_add_mod.document.HighRisk_form.long_desc,
					f_query_add_mod.document.HighRisk_form.short_desc,
					f_query_add_mod.document.HighRisk_form.duration_days); 

		var names = new Array ( getLabel("Common.code.label","Common"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"),
					getLabel("Common.duration.label","Common"));
					
		
		
		}
		else
		{ 
			var fields = new Array (f_query_add_mod.document.HighRisk_form.high_risk_code,
					f_query_add_mod.document.HighRisk_form.long_desc,
					f_query_add_mod.document.HighRisk_form.short_desc);
					

		var names = new Array ( getLabel("Common.code.label","Common"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common"));
					
					
			
		}
		

		var field = new Array (	f_query_add_mod.document.HighRisk_form.high_risk_code);

		var name = new Array ( getLabel("Common.code.label","Common"));
	
	}
//		alert(messageFrame.location.href)
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
			if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','../../eCommon/jsp/MstCodeError.jsp')){
				if(func=="MEDICAL_BOARD"){
					f_query_add_mod.document.MedicalBoardFrm.medical_board_type_code.disabled=false;
					f_query_add_mod.document.MedicalBoardFrm.submit();
				}
				else if(func=="MEDICAL_BOARD_TYPE"){
					f_query_add_mod.document.medboardtype_form.submit();
				}
				//Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
				else if(func=="REQUESTOR_TYPE"){
					f_query_add_mod.document.requestorTypeForm.submit();
				}
				else if(func=="CHKLIST_FOR_MEDICAL_REPORT") // added by mujafar for ML-MMOH-CRF-0762
				{
					
					f_query_add_mod.document.checkListForm.submit();
					
				}
				
				
				else if(func=='MR_REPORT_GROUP'){
					if(f_query_add_mod.document.ReportGroupFrm.function_name.value == "modify"){
						f_query_add_mod.document.ReportGroupFrm.Report_Id_hid.value = f_query_add_mod.document.ReportGroupFrm.Report_Id.value;
					}
//						alert(f_query_add_mod.document.forms[0].name)
						f_query_add_mod.document.forms[0].submit();

				}else{
					f_query_add_mod.document.HighRisk_form.submit();
				}
				//var fn_status = f_query_add_mod.document.HighRisk_form.function_name.value ;
			}
		}
	}

function onSuccess() {

	/*if(f_query_add_mod.document.forms[0].name=="ReportGroupFrm"){
//		parent.frames[2].frames[0].location.href="../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y&module_id=MR&function_id=MR_REPORT_GROUP&function_name=Report%20Group&function_type=F&access=YYYNN";
	}*/

		f_query_add_mod.location.reload();
}


 function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
function reset(){
		if(f_query_add_mod.document.forms[0])
//			f_query_add_mod.document.forms[0].reset();
			f_query_add_mod.location.reload();
}

function medBoard_change() 
	{
	
	 if (MedicalBoardFrm.eff_status.checked == true)
		MedicalBoardFrm.eff_status.value="E";
	 else
		MedicalBoardFrm.eff_status.value="D";
	}

	//added on 4/21/2005 by kishore from MR_Code_Setup
var expand = "";
var temparr = new Array();
var count = 0;
var prev='a';
var prevcol='ECMENUHIGHERLEVELCOLOR';
var sec_hdg_cd=new Array();
var logic_seq_no=new Array();

function goHomePage(){
		parent.location.href='../../eCommon/jsp/dmenu.jsp';
}

function chcol(ro)
{
		if(prev!='a')
		document.getElementById('t').rows(prev).cells(0).className=prevcol
		prevcol=ro.cells(0).className
		ro.cells(0).className="MENUSELECTEDCOLOR"
		prev=ro.rowIndex;
}

function callJSPs(val)
{
	/*
			Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
	*/
	if(val == 'BLOOD_GROUP')
		{
		parent.frames[1].location.href = '../../eMR/jsp/BloodGroup.jsp?module_id=MR&function_id=BLOOD_GROUP&function_name='+encodeURIComponent(getLabel("Common.bloodgroup.label","Common"))+'&function_type=F&access=YYYNN';
		}
	else if(val == 'RHESUS_FACTOR'){
		parent.frames[1].location.href = '../../eMR/jsp/RhesusFactor.jsp?module_id=MR&function_id=RHESUS_FACTOR&function_name='+encodeURIComponent(getLabel("eMR.RhesusFactor.label","MR"))+'&function_type=F&access=YYYNN';
	}
	else if(val == 'ALLERGY_TYPE'){
		parent.frames[1].location.href = '../../eMR/jsp/AllergyType.jsp?module_id=MR&function_id=ALLERGY_TYPE&function_name='+encodeURIComponent(getLabel("Common.AllergyType.label","Common"))+'&function_type=F&access=YYYNN';
	}
	else if(val == 'MDS_FOR_PAT_CLASS'){
		parent.frames[1].location.href = '../../eMR/jsp/MDSForPatientClass.jsp?module_id=MR&function_id=MDS_FOR_PAT_CLASS&function_name='+encodeURIComponent(getLabel("eMR.MDSforPatClass.label","MR"))+'&function_type=F&access=YYYNN';
	}
	else if(val == 'HIGH_RISK'){
		parent.frames[1].location.href = '../../eMR/jsp/HighRisk.jsp?module_id=MR&function_id=HIGH_RISK&function_name='+encodeURIComponent(getLabel("Common.HighRisk.label","Common"))+'&function_type=F&access=YYYNN';
	}
	else if(val == 'MEDICAL_EVENT_TYPE'){
		parent.frames[1].location.href = '../../eMR/jsp/MedicalEventType.jsp?module_id=MR&function_id=MEDICAL_EVENT_TYPE&function_name='+encodeURIComponent(getLabel("Common.MedicalEventType.label","Common"))+'&function_type=F&access=YYYNN';
	}
	else if(val == 'TABULATION_LIST'){
		parent.frames[1].location.href = '../../eMR/jsp/DiagGroup.jsp?module_id=MR&function_id=USRDEF_DIG_GROUP&function_name='+encodeURIComponent(getLabel("eMR.TabulationList.label","MR"))+'&function_type=F&access=YYYNN';
	}
	
	else if(val == 'ICD_CODE'){
		parent.frames[1].location.href = '../../eMR/jsp/ICDCode.jsp?module_id=MR&function_id=ICD_CODE&function_name='+encodeURIComponent(getLabel("Common.ICDCode.label","Common"))+'&function_type=F&access=NNYNN';
	}
	
	/*else if( val == 'MR_DIAG_GROUP')
	{
	parent.frames[1].location.href = '../../eMR/jsp/MRDiagGroup.jsp?module_id=MR&function_id=MR_DIAG_GROUP&function_name='+encodeURIComponent(getLabel("eMR.DiagnosisProcedureGroup.label","MR"))+'&function_type=F&access=YYYYN';
	}*/
	/*else if(val == 'ICD_CODE_FOR_DIAG_GROUP' )
	{
	parent.frames[1].location.href = '../../eMR/jsp/ICDForDiagGroup.jsp?module_id=MR&function_id=ICD_CODE_FOR_DIAG_GROUP&function_name='+encodeURIComponent(getLabel("eMR.CodeForDiagnosisProcedureGroup.label","MR"))+'&function_type=F&access=YYYNN';
	}*/
	else if(val == 'Requestor_MR' )
	{
	parent.frames[1].location.href = '../../eMR/jsp/Requestor.jsp?module_id=MR&function_id=Requestor_MR&function_name='+encodeURIComponent(getLabel("Common.Requestor.label","Common"))+'&function_type=F&access=YYYNN';
	}

	/*
	else if(val == 'REPORT_TYPE' )
	{
	
	parent.frames[1].location.href = '../../eMR/jsp/ReportType.jsp?module_id=MR&function_id=REPORT_TYPE&function_name=Report Type &function_type=F&access=YYYNN';
	}
	*/
	else if(val == 'APPLICATION_TYPE' )
	{
	
	parent.frames[1].location.href = '../../eMR/jsp/ApplicationType.jsp?module_id=MR&function_id=APPLICATION_TYPE&function_name='+encodeURIComponent(getLabel("eMR.ApplicationType.label","MR"))+'&function_type=F&access=YYYNN';
	}
	else if(val == 'MEDICAL_BOARD_TYPE' )
	{
	
	parent.frames[1].location.href = '../../eMR/jsp/MedicalBoardType.jsp?module_id=MR&function_id=MEDICAL_BOARD_TYPE&function_name='+encodeURIComponent(getLabel("eMR.MedicalBoardType.label","MR"))+'&function_type=F&access=YYYNN';
	}
	//Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
	else if(val == 'REQUESTOR_TYPE' )
	{
	
	parent.frames[1].location.href = '../../eMR/jsp/RequestorTypeFrames.jsp?module_id=MR&function_id=REQUESTOR_TYPE&function_name='+encodeURIComponent(getLabel("eMR.RequestorType.label","MR"))+'&function_type=F&access=YYYNN';
	}
	else if(val == 'MEDICAL_BOARD' )
	{
	
	parent.frames[1].location.href = '../../eMR/jsp/MedicalBoardMasterSetup.jsp?module_id=MR&function_id=MEDICAL_BOARD&function_name='+encodeURIComponent(getLabel("eMR.MedicalBoard.label","MR"))+'&function_type=F&access=YYYNN';
	}
	else if(val == 'Adverse_Event_Type' )
	{
		
	parent.frames[1].location.href = '../../eMR/jsp/AdverseEventTypeSetUp.jsp?module_id=MR&function_id=Adverse_Event_Type&function_name='+encodeURIComponent(getLabel("eMR.AdverseEventType.label","MR"))+'&function_type=F&access=YYYNN';
	
	}
	else if(val == 'Agent_for_Adv_Event_Type' )
	{
		
	parent.frames[1].location.href = '../../eMR/jsp/AgentforAllergenSetup.jsp?module_id=MR&function_id=Agent_for_Adv_Event_Type&function_name='+encodeURIComponent(getLabel("eMR.Allergen.label","MR"))+'&function_type=F&access=YYYNN';
	
	}
	else if(val == 'Adverse_Reaction' )
	{
		
	parent.frames[1].location.href = '../../eMR/jsp/AdverseReactionSetUp.jsp?module_id=MR&function_id=Adverse_Reaction&function_name='+encodeURIComponent(getLabel("Common.AdverseReaction.label","Common"))+'&function_type=F&access=YYYNN';
	
	}
}
function callReportJSP()
{
	parent.frames[1].location.href = '../../eMR/jsp/ReportCodeSetup.jsp?module_id=MR&function_id=MR_REPORT_CODE_SETUP&function_name=PD/PL Report Link for Masters&function_type=F&access=YYYNN';
}
function callReportGrpJSP(grp)
{
	parent.frames[1].location.href = '../../eMR/jsp/ReportGroupMaster.jsp?module_id=MR&function_id=MR_REPORT_GROUP&function_name=PD/PL/SS Report Group&function_type=F&access=YYYNN';
}
function callSSOrderJSP()
{
  parent.frames[1].location.href = '../../eMR/jsp/SSOrderCatalogLinkFrames.jsp?module_id=MR&function_id=MR_SSOrderCatalog_Link&function_name='+encodeURIComponent(getLabel("eMR.OrderCatalogforSSReports.label","MR"))+'&function_type=F&access=YYYNN';
}
function callListReportJSP()
{
  parent.frames[1].location.href = '../../eMR/jsp/TLLinkFrames.jsp?module_id=MR&function_id=MR_Tabulation_List&function_name=PD/PL/SS Report Link for Master&function_type=F&access=YYYNN';
}

/*function callJSPsfortab()
{
	parent.frames[1].location.href = '../../eMR/jsp/ICDCodeForTabList.jsp?module_id=MR&function_id=ICD_CODE_FOR_TAB_LIST&function_name='+encodeURIComponent(getLabel("eMR.ICDCodeForTabulationList.label","MR"))+'&function_type=F&access=YYYNN';
}
/
function callLoadingJSP()
{
	parent.frames[1].location.href = '../../eMR/jsp/ICDCodeForDagger.jsp?module_id=MR&function_id=ASTERISK_FOR_DAGGER&function_name='+encodeURIComponent(getLabel("eMR.AsteriskCodeforDaggerCode.label","MR"))+'&function_type=F&access=YYYNN';
}
*/
function refreshPage()
{
	parent.frames[0].location.href='../../eMR/jsp/MR_Code_Setup.jsp?expand='+expand
}
//Function for addModifyApplicationType.jsp
function change() 
{
	if (HighRisk_form.eff_status.checked == true)
		HighRisk_form.eff_status.value="E";
	else
		HighRisk_form.eff_status.value="D";
 }
 function change1() 
{
	if (HighRisk_form.eff_status.checked == true)
		HighRisk_form.eff_status.value="E";
	else
		HighRisk_form.eff_status.value="D";
 }
//Function for addModifyMedicalBoardType.jsp
 function change() 
{
	if(medboardtype_form.eff_status.checked == false)
	{
		if(medboardtype_form.Board_type_status.value=='EXIT')
		{
			alert(getMessage('ALREADY_EXIST_MBOARD','MR'))
			medboardtype_form.eff_status.checked=true;
			return false;
		}
	}
	 if (medboardtype_form.eff_status.checked == true)
		medboardtype_form.eff_status.value="E";
	 else
		medboardtype_form.eff_status.value="D";
}

/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
function changeReqType() 
{
	if(requestorTypeForm.eff_status.checked == false)
	{
		if(requestorTypeForm.requestor_type_status.value=='EXIT')
		{
			alert(getMessage('ALREADY_EXIST_REQTYPE','MR'))
			requestorTypeForm.eff_status.checked=true;
			return false;
		}
	}
	 if (requestorTypeForm.eff_status.checked == true)
		requestorTypeForm.eff_status.value="E";
	 else
		requestorTypeForm.eff_status.value="D";
}

function changeCheckList()  // added by mujafar for ML-MMOH-CRF-0762
{
	
	 if (checkListForm.eff_status.checked == true)
		checkListForm.eff_status.value="E";
	 else
		checkListForm.eff_status.value="D";
}



function CheckForSpecCharsInReqType(event){ 
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
/*End ML-MMOH-CRF-0707*/

/*function callMedicalRecord()
{
		
	parent.frames[1].location.href = '../../eMR/jsp/NewMedicalReportFrames.jsp?module_id=MR&function_id=NewMedical_Record&function_name=New Medical Record &function_type=F&access=YYYNN';

}*/
