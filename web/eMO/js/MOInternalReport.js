	
	 function ClearFrame()
	{
	if(parent.group_head.document.SearchVisit)
	{
	   parent.group_head.location.href = '../../eMO/jsp/MOInternalReportQueryCriteria.jsp?param=';
	   parent.code_desc.document.location.href='../../eCommon/html/blank.html' ;
	} 
	}
	
	async function showAllowedOperations1(area_code,registration_no,facility_id,patient_id,exportation_doc_iss_date)
	{
		if(area_code=="*")area_code="";
	    if(area_code==""&&exportation_doc_iss_date=="")
		{
		 //sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID = 'MOBLABEL'";	
		 sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report_LANG_VW where module_id = 'MO' and LANGUAGE_ID='"+localeName+"' AND REPORT_ID = 'MOBLABEL'";	
		}else if(area_code==""&&(exportation_doc_iss_date!=""))
		{
		// sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID in ('MOBLABEL','MOBEXDOC')";	
		sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report_LANG_VW where module_id = 'MO' and LANGUAGE_ID='"+localeName+"' AND REPORT_ID in ('MOBLABEL','MOBEXDOC')";		
		}
		else if(area_code!=""&&(exportation_doc_iss_date==""))
		{
		 //sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID in ('MOBLABEL','MOBFREEZ')";		
		 sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report_LANG_VW where module_id = 'MO' AND LANGUAGE_ID='"+localeName+"'  and REPORT_ID in ('MOBLABEL','MOBFREEZ')";	
		}		
		else
		{
		 //sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID in ('MOBLABEL','MOBFREEZ','MOBEXDOC')";	
		 sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report_LANG_VW where module_id = 'MO' and LANGUAGE_ID='"+localeName+"' AND REPORT_ID in ('MOBLABEL','MOBFREEZ','MOBEXDOC')";	
		}
	
		var reportParamNames = "p_facility_id,P_FM_REGISTRATION_NO,P_TO_REGISTRATION_NO";
		var reportParamValues = ""+facility_id+","+registration_no+","+registration_no;
	    
	  
	    //<html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>
        //htmlFor.append("</head><body class='message'>");
        
         var dialogHeight    = '400px' ;
         var dialogWidth = '1000px' ;
         var dialogTop = '';
         var arguments =   ''; 
 		// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
         var getUrl        =  "../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MOINTERNALREPORT&step=1&sqlString="+escape(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patient_id;
         var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;
         retVal            =  await window.showModalDialog(getUrl,arguments,features); 
                 
	

	}
	function showResultPage()
	{
		//document.forms[0].search.disabled=true;
		var rno       = document.forms[0].registration_no.value;
		var pid       = document.forms[0].patient_id.value;
		var frmdate   = document.forms[0].startdate1.value;
		var todate    = document.forms[0].startdate2.value;
		var burial_no = document.forms[0].burial_permit_no.value;
		var obt_frm  = document.forms[0].obt_frm.value;
	    

var  greg_fromdate = "";
			var greg_todate  = "";
			if(frmdate!="")
				greg_fromdate = convertDate(frmdate,"DMY",localeName,"en");
			if(todate!="")
				greg_todate = convertDate(todate,"DMY",localeName,"en");
			
		if(document.forms[0].print_embalm.checked){
				document.forms[0].search.disabled=true;
				parent.code_desc.document.location.href='../../eCommon/html/blank.html' ;  					
				parent.code_desc.location.href= "../jsp/EmbalmQueryResult.jsp?function=REPRINT&patientId="+pid		+"&dateofApplication="+greg_fromdate+"&todate="+greg_todate+"&burial_no="+burial_no+"&obt_frm="+obt_frm
				document.forms[0].search.disabled=false;		
		}else{
	    if(frmdate!=""&&todate!="")
		{
			var  greg_fromdate = convertDate(frmdate,"DMY",localeName,"en");
			var greg_todate = convertDate(todate,"DMY",localeName,"en");
			if(isBefore(greg_fromdate,greg_todate,"DMY",'en'))
			{
				parent.code_desc.document.location.href='../../eCommon/html/blank.html' ;  
				document.forms[0].search.disabled=true;
				//parent.code_desc.location.href= "../jsp/MOInternalReportQueryResult.jsp?rno="+rno+"&pid="+pid+"&frmdate="+frmdate+"&todate="+todate+"&burial_no="+burial_no+"&obt_frm="+obt_frm
				parent.code_desc.location.href= "../jsp/MOInternalReportQueryResult.jsp?rno="+rno+"&pid="+pid+"&frmdate="+greg_fromdate+"&todate="+greg_todate+"&burial_no="+burial_no+"&obt_frm="+obt_frm;
					/*if(doDateCheck(document.forms[0].startdate1,document.forms[0].startdate2,parent.messageFrame)==true) 
			{	
			parent.code_desc.document.location.href='../../eCommon/html/blank.html' ;  
			document.forms[0].search.disabled=true;
			parent.code_desc.location.href= "../jsp/MOInternalReportQueryResult.jsp?rno="+rno+"&pid="+pid
			+"&frmdate="+frmdate+"&todate="+todate+"&burial_no="+burial_no+"&obt_frm="+obt_frm
				
			}*/

			}	
			else
			{
				parent.code_desc.document.location.href='../../eCommon/html/blank.html' ;  
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));			
				document.forms[0].startdate1.focus();
				document.forms[0].search.disabled=false;
				parent.messageFrame.document.location.href='../../eCommon/html/blank.html' ;  
			}
		}
		else
		{
			var  greg_fromdate = "";
			var greg_todate  = "";
			if(frmdate!="")
				greg_fromdate = convertDate(frmdate,"DMY",localeName,"en");
			if(todate!="")
				greg_todate = convertDate(todate,"DMY",localeName,"en");

			document.forms[0].search.disabled=true;
			parent.code_desc.document.location.href='../../eCommon/html/blank.html' ;  
			//parent.code_desc.location.href= "../jsp/MOInternalReportQueryResult.jsp?rno="+rno+"&pid="+pid		+"&frmdate="+frmdate+"&todate="+todate+"&burial_no="+burial_no+"&obt_frm="+obt_frm
			parent.code_desc.location.href= "../../eMO/jsp/MOInternalReportQueryResult.jsp?rno="+rno+"&pid="+pid		+"&frmdate="+greg_fromdate+"&todate="+greg_todate+"&burial_no="+burial_no+"&obt_frm="+obt_frm
		
		   }
		}
		
	}
	
	async function searchCode(obj,target)
	{

	if(document.forms[0].print_embalm.checked){

	var patientid = PatientSearch('','','','','','','Y','','N','MO');
	if(patientid!=null){
	 document.getElementById("patient_id").value = patientid;
	 document.getElementById("patient_id").focus();
	}else{
		document.getElementById("patient_id").value = "";
	}


	}else{


			var dialogHeight   = "28" ;
			var dialogWidth	   = "43" ;
			var status		   = "no";
			var arguments	   = "" ;
			var sql			   ="";
			var search_code	   ="";
			var search_desc    ="";
			var retVal         =    new String();
			var argumentArray  =new Array(8);
            var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit			   ="";				
			var facilityId	   = "";
			facilityId		   = document.forms[0].facility_id.value;
			var fieldLegend = new Array() ;
		    //fieldLegend["CODE_LEGEND"] = "Registration No"
		    //fieldLegend["DESC_LEGEND"] = "Patient Name"
			tit= getLabel("eMO.RegistrationDtls.label","MO");
			if(obj.name=="pat_search")
		   {fieldLegend["CODE_LEGEND"] = getLabel("Common.patientId.label","Common");
		    fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");
			
			sql="select patient_id code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?)  order by 2";
		   }else if(obj.name=="burial_search")
		   {fieldLegend["CODE_LEGEND"] = getLabel("eMO.BurialPermitNumber.label","MO");
		    fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");
			
		   sql="select BURIAL_PERMIT_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(BURIAL_PERMIT_NO) like upper(?) and upper(patient_name) like upper(?)   order by 2";
		  }else{
		  fieldLegend["CODE_LEGEND"] = getLabel("Common.registrationno.label","Common");
		  fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");
		  sql="select registration_no code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?)  order by 2";
		 }			
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				argumentArray[8] = fieldLegend;
				retVal = await CommonLookup( tit, argumentArray );
	
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			var arr	=ret1.split(",");
			
			target.value= arr[0];
			
			//	parent.criteria.location.href = '../../eMO/jsp/MORegnDtlsQueryCriteria.jsp?param='+arr[0];
				
		}
		else
		{	
			document.forms[0].registration_no.value= "";
		}
	}
	}

	function diplayEmbalm(obj){
		if(obj.checked){
			document.forms[0].registration_no.value= "";
			document.forms[0].registration_no.disabled = true;
			document.forms[0].RegBut.disabled = true;
			document.forms[0].burial_permit_no.value= "";
			document.forms[0].burial_permit_no.disabled = true;
			document.forms[0].burial_search.disabled = true;
			document.forms[0].obt_frm.disabled = true;
			document.forms[0].obt_frm.selectedIndex=0;
			
		}else{
			document.forms[0].registration_no.disabled = false;
			document.forms[0].RegBut.disabled = false;
			document.forms[0].burial_permit_no.disabled = false;
			document.forms[0].burial_search.disabled = false;
			document.forms[0].obt_frm.disabled = false;
		}


	}
