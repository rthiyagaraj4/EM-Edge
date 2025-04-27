//variables for pagination
var currentPageNo					= 1;
var recordsPerPage					= 10;

async function callModalWindow(req_id, pat_id, faci_id,request_status_id,overdue_status,consent_letter)
	{
		
       
        var sqlString = "";
         
		 if(request_status_id == '6')
		{
          sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in('MRACKLTR' ,'MRBOBABAL') ";
		}else{
              if(overdue_status == 'Y'){
                 sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in('MRACKLTR' ,'MRBRCLTR') ";
		      }else{

				  if(request_status_id == '2'){
                     if(consent_letter == '0'){
                         sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in('MRACKLTR' ,'MRBMRAPP','MRBMRCFR' ,'MRRSDLTR') ";
					 }else{
                         sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in('MRACKLTR' ,'MRBMRAPP' ,'MRRSDLTR') ";
					 }
				  }else{
                  var reportAndStatus = {};
				  reportAndStatus[1]	=  "'MRBMRCFR'";
                  //reportAndStatus[2]	=  "'MRACKLTR' ,'MRBMRAPP' ,'MRRSDLTR'";
                  reportAndStatus[5]	=  "'MRACKLTR' ,'MRBOBABAL'";
			      //reportAndStatus[6]	=  "'MRACKLTR' ,'MRBOBABAL'";
                  reportAndStatus[7]	=  "'MRACKLTR'";
			      //reportAndStatus[0]	=  "'MRACKLTR' ,'MRBRCLTR'";
			      reportAndStatus[4]	=  "'MRBOBABAL'";

		          sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in("+reportAndStatus[request_status_id]+") ";
				  }
		       }
		}

          reportParamNames = "p_request_id,p_facility_id,p_patient_id";
		  reportParamValues = ""+req_id+","+faci_id+","+pat_id+"";
          
		  var dialogHeight	= '25vh';
		  var dialogWidth	= '65vw';
		  var dialogTop		= '58';
		  var retVal		= new String();
		  var arguments		=	'';

          var getUrl		=    "../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=REVISE_MEDICAL_REPORT&step=1&sqlString="+encodeURIComponent(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+pat_id;

		  var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status=no;' ;
		  retVal = await window.showModalDialog(getUrl,arguments,features); parent.window.close();
        
	}

function FnListAllStatus(){
    //variables for search criteria
	var national_id_no		= $("input[name$='national_id_no']").val();
	var other_alt_type		= $("input[name$='other_alt_type']").val();
	var other_alt_Id		= $("input[name$='other_alt_Id']").val();
	var alt_id1_no			= $("input[name$='alt_id1_no']").val();
	var alt_id2_no			= $("input[name$='alt_id2_no']").val();
	var alt_id3_no			= $("input[name$='alt_id3_no']").val();
	var alt_id4_no			= $("input[name$='alt_id4_no']").val();
	var PatientId			= $("input[name$='PatientId']").val();
	var status_to_show		= $("input[name$='status_to_show']").val();
	var from_date			= $("input[name$='from_date']").val();
    var to_date				= $("input[name$='to_date']").val();
    var action				= 'reportStatusList';
	
 	var jsonArguments	=	{
								'national_id_no'	:national_id_no,
								'other_alt_type'	:other_alt_type, 
								'other_alt_Id'		:other_alt_Id, 
								'alt_id1_no'		:alt_id1_no, 
								'alt_id2_no'		:alt_id2_no, 
								'alt_id3_no'		:alt_id3_no, 
								'alt_id4_no'		:alt_id4_no, 
								'PatientId'			:PatientId, 
								'status_to_show'	:status_to_show,
								'from_date'			:from_date,
								'to_date'			:to_date,
								'action'			:action,
								'isPagination'		:'Y',
								'recordsPerPage'	:recordsPerPage,
								'currentPageNo'		:currentPageNo
							}
	$.ajax({
			 url:'../../servlet/eMR.ListingReportStatusServlet',
			 type: 'post',
			 data: jsonArguments,
			 dataType: 'json',
			 success: function(data) {

				 if(data.rowCountHdr == 0){
                    alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				 } else{
				var DisplayData		= "";
				
				DisplayData = "<table width='98%' border='1' style='border-spacing:0px ;border-collapse: collapse;' id='tablepatlist' class='mt'><tr><th ><b>"+getLabel("eMR.RequestID.label","MR")+"</b></th><th ><b>"+getLabel("Common.RequestDate.label","Common")+"</b></th><th ><b>"+getLabel("Common.patientId.label","Common")+"</b></th><th style='width:20%'><b>"+getLabel("Common.PatientName.label","Common")+"</b></th><th style='width:5%' ><b>"+getLabel("Common.gender.label","Common")+"</b></th><th style='width:15%'><b>"+getLabel("Common.practitioner.label","Common")+"</b></th><th style='width:11%' ><b>"+getLabel("eMR.CollectDate.label","MR")+"</b></th><th style='width:9%'><b>"+getLabel("Common.RequestStatus.label","Common")+"</b></th></tr>";
                
				var recordsList=eval(data.recordsList);
				var request_id		 ="";
				var request_date	 ="";
				var patient_id		 ="";
				var patient_name	 ="";
				var sex				 ="";
				var practitioner_name="";
				var collect_date	 ="";
				var request_status	 ="";
				var request_status_id="";
				var revise_status	 ="";
				var appt_date		 ="";
				var med_board_type	 ="";
				var appt_ref_no		 ="";
				var overdue_status   ="";
				var curr_date		 ="";
				var faci_id			 ="";
                var consent_letter	 ="";

				$.each(recordsList,function(index,value){
                       request_id		= value.request_id;
	    			   request_date		= value.request_date;
	    	   		   patient_id		= value.patient_id;
	    	   		   patient_name		= value.patient_name;
	    			   sex				= value.sex;
	    			   practitioner_name= value.practitioner_name;
	    			   collect_date		= value.collect_date;
	    			   request_status	= value.request_status;
					   request_status_id= value.request_status_id
					   revise_status	= value.revise_status;
					   appt_date		= value.appt_date;
					   med_board_type	= value.med_board_type;
					   appt_ref_no		= value.appt_ref_no;
					   overdue_status	= value.overdue_status;
					   curr_date		= value.curr_date;
					   faci_id			= value.faci_id;
					   consent_letter   = value.consent_letter
                       
					   tdclass			= "QRYODD";

					   if(practitioner_name == ''){
                          practitioner_name = "&nbsp;";
                       }
					   if(collect_date == ''){
                          collect_date = "&nbsp;";
                       }

					  if(sex == null ){
						sex="";
					  }else if (sex == "M"){
						sex = getLabel("Common.male.label","Common");
					  }else if (sex == "F"){
						sex = getLabel("Common.female.label","Common");
					  }else{
						sex = getLabel("Common.unknown.label","Common");
	     			  }

					   DisplayData		+= "<tr>";
					   DisplayData		+= "<td class="+tdclass+" align='center' nowrap><a href=javascript:callModalWindow('"+request_id+"','"+patient_id+"','"+faci_id+"','"+request_status_id+"','"+overdue_status+"','"+consent_letter+"')>"+request_id+"</a></td>";
                       
                       DisplayData		+= "<td class="+tdclass+" align='center' >"+request_date+"</td>";
					   DisplayData		+= "<td class="+tdclass+" align='center' >"+patient_id+"</td>";
					   DisplayData		+= "<td class="+tdclass+" align='center'>"+patient_name+"</td>";
					   DisplayData		+= "<td class="+tdclass+" align='center' >"+sex+"</td>";
					   DisplayData		+= "<td class="+tdclass+" align='center' >"+practitioner_name+"</td>";
					   DisplayData		+= "<td class="+tdclass+" align='center' >"+collect_date+"</td>";
					   DisplayData		+= "<td class="+tdclass+" align='center' >"+request_status+"</td></tr>";
				});

				if($("#tablepatlist").is(':visible')==false){
					DisplayData			+="</table>";
				}
		

				var pagiContent			= "";
	    	     if(data.noOfPages > 1){
	    		     pagiContent			= FnGetPagiContent(parseInt(data.noOfPages),parseInt(data.currentPageNo),parseInt(data.noOfRecords));
	    		     $("#paginatoinContainer").html(pagiContent);
	    	     } else{
	    		     $("#paginatoinContainer").html("");
	    	       }

				$("#listReportStatus").html(DisplayData);
				fxheaderInit('tablepatlist',210);
			 }
			 }
		 });
}

function FnGetPagiContent(noOfPages,curPageNo,noOfRecords){
	var pagicontent		 = "";
	if(curPageNo > 1 ){
		pagicontent	    += "<span><a onclick='FnPagiClick("+(curPageNo-1)+")' style='cursor:pointer;' href='javascript:void(0);'>" +getLabel('Common.previous.label','common_labels')+ "&nbsp </a></span>";
	}
	if(curPageNo>=1 && curPageNo != noOfPages){
		pagicontent	    += "<span><a onclick='FnPagiClick("+(curPageNo+1)+")' style='cursor:pointer;'  href='javascript:void(0);'>"  +getLabel('Common.next.label','common_labels')+ "</a></span>";
	}
	return pagicontent;
}

function FnPagiClick(curPageNo){
	currentPageNo	= curPageNo;
	FnListAllStatus();
}

