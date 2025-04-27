function onSuccess() 
{
    //funDisiplineList()
	//alert('Operation Completed successfully');
}

function reset()
{
    window.frames[1].location.reload()
}
function checkCodes(obj)
{
if(obj.value=="'")
obj.value="''"
}


function clearPage()
{
     parent.frames[2].location.href='../../eCommon/html/blank.html' 
}

function clearResult()
{
    parent.frames[2].location.href ='../../eCommon/html/blank.html'
}

function funQATransactionSearch(obj)
{
	var sql ;
	var where = ' WHERE 1=1';
	//var where = ' WHERE';
	/*if (funQASearchValidation(obj) ==false)
	{
		obj.PATIENT_CLASS.focus();
	}*/
	//var ENCOUNTER_ID = obj.ENCOUNTER_ID.value;
	var PATIENT_ID = obj.PatientId.value;
	var PATIENT_CLASS = obj.PATIENT_CLASS.value;
	//var ASSIGN_CARE_LOCN_CODE = obj.ASSIGN_CARE_LOCN_CODE.VALUE;
	var PERIOD_FROM = obj.PERIOD_FROM.value;
	var PERIOD_TO = obj.PERIOD_TO.value;
	var STATUS = obj.STATUS.value;
	var CLINIC_GRP = obj.clinical_group.value;
	var CLINIC_IND = obj.clinical_ind.value;
	var ORDER_BY=obj.ORDER_BY.value;
	var sentinel=obj.sentinel.value;
	
		
	if ((PATIENT_ID != null) &&(PATIENT_ID !='') )
	{
			where += " AND PATIENT_ID='"+PATIENT_ID+"'";
	}
	if ((PATIENT_CLASS != null) &&(PATIENT_CLASS !='') )
	{     
			where += " AND PATIENT_CLASS='"+PATIENT_CLASS+"'";
	}
	if (  ((PERIOD_FROM != null) &&(PERIOD_FROM !='')) && 
		((PERIOD_TO != null) &&(PERIOD_TO !=''))  )
	{
			where += " AND TRUNC(ENCOUNTER_START_DATE) BETWEEN to_date('"+PERIOD_FROM+"','dd/mm/yyyy') "+
						" AND to_date('"+PERIOD_TO+"','dd/mm/yyyy') ";
	}
	if ((STATUS != null) &&(STATUS !='') )
	{
		if(STATUS=='Complete' || STATUS=='Partial')
			where += " AND STATUS_DESC='"+STATUS+"'";
	}
	
	if ((CLINIC_GRP != null) &&(CLINIC_GRP !='') )
	{
		where += " AND QIND_GROUP_ID='"+CLINIC_GRP+"'";
	}

	if ((CLINIC_IND != null) &&(CLINIC_IND !='') )
	{
		where += " AND QIND_CLIND_ID='"+CLINIC_IND+"'";
	}
	if ((sentinel != null) &&(sentinel !='') )
	{
		where += " AND SENTINEL_YN='"+sentinel+"'";
	}


		sql = 	"SELECT FACILITY_ID,ENCOUNTER_ID,PATIENT_NAME, decode(sex,'M','Male','F','Female','U','Unknown') gender,PATIENT_CLASS, PATIENT_ID,QIND_CLIND_ID,QIND_CLIND_Desc,to_char(ENCOUNTER_START_DATE,'dd/mm/yyyy') ENCOUNTER_START_DATE, CLIND_ANALYSIS_STATUS, STATUS_DESC,INCL_DIAG_CODE,INCL_PROC_CODE, SYS_USER_CREATED FROM qa_clind_ind_trn_analysis";
       sql = sql+where+ " ORDER BY "+ORDER_BY+" DESC ";
      // sql = sql+where;
  
		//alert(sql);
		sql=escape(sql);
		document.QA_SEARCH_FORM.sql.value=sql;
		parent.frames[2].location.href = '../../eQA/jsp/QAAnalyzePartialIndSearchResult.jsp?sql='+sql;

}


async function funQAComplication(obj,indicatorid)
{
 	var retVal =    new String();               
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	tit="Complication Code"
	sql="Select COMPL_CODE code, COMPL_DESCRIPTION description from QA_QIND_CLIND_COMPL where  upper(COMPL_CODE) like upper(?) and upper(COMPL_DESCRIPTION) like upper(?) and   QIND_CLIND_ID='"+ indicatorid+"' order by 1";					
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );				
	if(retVal != null && retVal != "" )
	{					
		var ret1=unescape(retVal);
		arr=ret1.split(",");
	
		document.forms[0].INCL_COMPL_CODE.value = arr[0];
		document.forms[0].COMPL_DESCRIPTION.value = arr[1];
	}else
	{
		document.forms[0].INCL_COMPL_CODE.value="";
		document.forms[0].COMPL_DESCRIPTION.value="";
	}

}


async  function funPatient()
{
	var patid=await PatientSearch('','','','','','','Y','','','OTHER');
	if( patid ==null)patid="";
	document.forms[0].PatientId.value = patid;
}

function PatValidations(obj)
{
	
	if(document.forms[0].PatientId.value!='')
	{
	    var fields = new Array (document.forms[0].PatientId); 
        var names = new Array (getLabel("Common.patientId.label","Common"));
		var patient_id = document.forms[0].PatientId.value;
		var error_jsp="";
		var messageFrame="";
	    var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'></form></BODY></HTML>";
	    parent.messageFrame.document.write(HTMLVal);
	    parent.messageFrame.valid_form.submit();
	}
}

/*function checkAttributes(obj,arr)
{
	 for(k=0;k<arr.length;k++)
	{
			if (obj.getAttribute(arr[k])=='Y') 
			{
				return true;
			}
	}
	return(false);

	
}*/


/******  Added from the  QADirRecordOfClinIndSearchResult.jsp ******/

function fun(obj)
{
	
	var dialogTop			= "0";
	var dialogHeight		= "10" ;
	var dialogWidth			= "60" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title="Analyze Indicator";
	var column_descriptions = escape("Practitioner id, Practitioner Name, Facility"); 
	
	var strEncounterId=obj.ENCOUNTER_ID;
	//var strFacilityId=obj.FACILITY_ID;
	//var strClindStatus=obj.CLIND_ANALYSIS_STATUS;
	var strDiagCode=obj.INCL_DIAG_CODE;
	var strProcCode=obj.INCL_PROC_CODE;
	var SYS_USER_CREATED=obj.SYS_USER_CREATED;
	var PATIENT_CLASS=obj.PATIENT_CLASS;
	var strIndicator=obj.QIND_CLIND_Desc;
	var strIndicatorId=obj.QIND_CLIND_ID;
	var PATIENT_ID=obj.PATIENT_ID;
	if (strDiagCode == 'null')
		strDiagCode='';

	if (strProcCode == 'null')
		strProcCode='';

	//alert(PATIENT_ID);
	var par = 'ENCOUNTER_ID='+obj.ENCOUNTER_ID+'&'+'PATIENT_NAME='+obj.PATIENT_NAME+'&'+'FACILITY_ID='+obj.FACILITY_ID+'&'+'CLIND_ANALYSIS_STATUS='+obj.CLIND_ANALYSIS_STATUS+'&'+'INCL_DIAG_CODE='+strDiagCode+'&'+'INCL_PROC_CODE='+strProcCode+'&'+'SYS_USER_CREATED='+obj.SYS_USER_CREATED+'&'+'PATIENT_CLASS='+obj.PATIENT_CLASS+'&'+ 'QIND_CLIND_DESC='+obj.QIND_CLIND_Desc+'&'+'QIND_CLIND_ID='+obj.QIND_CLIND_ID+'&'+'title='+title+'&'+'Analyzepart=yes';
	

	/* alert("strEncounterId:"+strEncounterId);
	alert("strFacilityId:"+strFacilityId);
	alert("strClindStatus:"+strClindStatus);
	alert("strDiagCode:"+strDiagCode);
	alert("strProcCode:"+strProcCode);
	alert("SYS_USER_CREATED:"+SYS_USER_CREATED);
	alert("PATIENT_CLASS:"+PATIENT_CLASS);
	alert("strIndicator:"+strIndicator);
	alert("strIndicatorId:"+strIndicatorId); */
	//alert(obj.PATIENT_NAME);


	var id1=obj.ENCOUNTER_ID;
	

	var x =event.x-6 ;
	var y =event.y -6;
		//x     = x + (document.getElementById("tooltip").offsetWidth);
      //  y     = y + (document.getElementById("tooltip").offsetHeight);

	var tab_dat;
		tab_dat="<table><TR ><TD nowrap class='oalabel' ENCOUNTER_ID='"+strEncounterId+"' PATIENT_ID='"+PATIENT_ID+"' PATIENT_CLASS='"+PATIENT_CLASS+"' onClick='patchart(this);'><a href='#' onClick='hidetooltip();'>Patient Chart</a></TD></TR><TR><TD nowrap class='oalabel' par='"+par+"' SYS_USER_CREATED='"+SYS_USER_CREATED+"' onClick='fun1(this);'><a href='#'  onClick='hidetooltip();'>Analyze</a></TD></TR></table>";
		
		//alert(tab_dat);
		document.getElementById("tooltipdata").innerHTML=tab_dat;
		y+=document.body.scrollTop;
        x+=document.body.scrollLeft;
        document.getElementById("tooltip").style.posLeft= 3;
        document.getElementById("tooltip").style.posTop = y;
		
	document.getElementById("tooltip").style.visibility="visible";
	/*document.getElementById("id1").style.display="";
	var alt='document.getElementById("a")' + id1 +'.style.visibility="visible";';
	alt=alt+'document.getElementById("a")'+ id1 +'.style.posLeft=10'
	//alt=alt+'document.getElementById("a")'+ id1 +'.style.posLeft=100;'
	alt=alt+'document.getElementById("a")'+ id1 +'.style.posposTop=' + y + ';'
	eval(alt);
	//eval(alt1);
	alert(alt); */
	//alert(par);
	//retVal=window.showModalDialog("../../eQA/jsp/QAIndicatorEntryMain.jsp?"+par,arguments,features);

	
}
function hidetooltip()
{
	document.getElementById("tooltip").style.visibility='hidden';
}
	
function submitFormN()
{
	//alert('1');
 	var from = new Number(document.forms[0].from.value );
	var to = new Number(document.forms[0].to.value );
	var maxval = new Number(document.forms[0].max_records.value );
	document.forms[0].from.value = from + maxval;
	document.forms[0].to.value = to + maxval;
	document.forms[0].submit();
	
}

function submitFormP()
{
	//alert('1');
	var from = new Number(document.forms[0].from.value );
	var to = new Number(document.forms[0].to.value );
	var maxval = new Number(document.forms[0].max_records.value );
	document.forms[0].from.value = from - maxval;
	document.forms[0].to.value = to - maxval;
	document.forms[0].submit();

	
}

/******  Added from the  QADisciplineSearch.jsp ******/

function cancel()
{
	parent.window.close();
}



function apply()
{
    /*parent.frames[0].document.Discipline_Frame.method = "POST";
	parent.frames[0].document.Discipline_Frame.action = '../../servlet/eQA.QADirRecordOfClinIndicatorsServlet';
	parent.frames[0].document.Discipline_Frame.target = "qa_message_frame";
	parent.frames[0].document.Discipline_Frame.submit();
	alert('1');*/

}
	  
/********* Added from QAIndicatorList.jsp ********/

//function fun1(par1,SYS_USER_CREATED1)
function fun1(obj)
{
	var dialogTop			= "120";
	var dialogHeight		= "26" ;
	var dialogWidth		= "39" ;
	var features			    = 	"dialogTop:"+dialogTop+
										"; dialogHeight:" + dialogHeight + 
										"; dialogWidth:" + dialogWidth +
										";status=no;scroll:no" ;
	var arguments			= "" ;
	var title="Indicator Entry";
	var SYS_USER_CREATED=obj.SYS_USER_CREATED;
	var par=obj.par;

	
	
/*	if (SYS_USER_CREATED =='S')
	{
	alert("APP-QA5002 System generated indicator. Modification not allowed");
	return false;
	}

	if ((master_sys_user_created =='S') && (trn_sys_user_created =='E'))
	{
	alert("APP-QA5005 System Indicator. Entry not allowed");
	return false;
	} 

	var par = "QIND_CLIND_ID="+qind_clind_id+'&'+
	"CLIND_ANALYSIS_STATUS="+clind_analysis_status+'&'+
	"QIND_CLIND_DESC="+qind_clind_desc+'&'+
	"INCL_PROC_CODE="+incl_proc_code+'&'+
	"INCL_DIAG_CODE="+incl_diag_code+'&'+
	"SYS_USER_CREATED="+trn_sys_user_created+'&'+
	"rowVal="+optionstat+'&'+
	"ENCOUNTER_ID="+encounter_id;*/

	var appobj = '';
	var app_check = '';
	var app_yn = 'N';

	var retVal=window.showModalDialog("../../eQA/jsp/QAIndividualIndicatorEntry.jsp?"+par,arguments,features);

	
	var retVal;
    if (retVal != null)
    {
	
	var ret=retVal.split("|")
	//	alert(retVal);
	var encounter_id=ret[0];
	   
		clind_analysis_status=ret[1];
	   
		qind_clind_id =ret[2];
	   
		incl_diag_code= ret[3];
	   
		incl_proc_code =ret[4];
	   
		incl_compl_code=ret[5];
	   
		incl_comments=ret[6];
	   
		patient_class=ret[7];
	   
		incl_yn=ret[8];
	   
		rowVal=ret[9];
	   	
		//alert("incl_compl_code:"+ incl_compl_code);
		var QA_SEARCH_FORM = parent.frames[1].QA_SEARCH_FORM;
		var sql=QA_SEARCH_FORM.sql.value;
		//parent.frames[2].location.href = '../../eQA/jsp/QAAnalyzePartialIndSearchResult.jsp?sql='+sql;
				
		HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='../../servlet/eQA.QAAnlyzRecordOfClinIndicatorsServlet'><input type='hidden' name='encounter_id' id='encounter_id' value='"+encounter_id+"'><input type='hidden' name='clind_analysis_status' id='clind_analysis_status' value='"+clind_analysis_status+"'><input type='hidden' name='qind_clind_id' id='qind_clind_id' value='"+qind_clind_id+"'><input type='hidden' name='incl_diag_code' id='incl_diag_code' value='"+incl_diag_code+"'><input type='hidden' name='incl_proc_code' id='incl_proc_code' value='"+incl_proc_code+"'><input type='hidden' name='incl_compl_code' id='incl_compl_code' value='"+incl_compl_code+"'><input type='hidden' name='incl_comments' id='incl_comments' value='"+incl_comments+"'><input type='hidden' name='incl_yn' id='incl_yn' value='"+incl_yn+"'><input type='hidden' name='patient_class' id='patient_class' value='"+patient_class+"'><input type='hidden' name='p_sql' id='p_sql' value='"+sql+"'></form></BODY></HTML>";
		parent.blankFrame.document.write(HTMLVal);

        if(parent.blankFrame.document.form1!=null)
        parent.blankFrame.document.form1.submit(); 

		
		/*HTMLVal = "<HTML><BODY><form name='form2' id='form2' method='post' action='../../servlet/eQA.QAAnlyzRecordOfClinIndicatorsServlet'><input type='hidden' name='encounter_id' id='encounter_id' value='"+encounter_id+"'></form></BODY></HTML>";
        parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
        if(parent.blankFrame.document.form2!=null)*/
       // parent.blankFrame.document.form2.submit(); 




		//parent.frames[2].location.reload()
		

		//apply();
			
		}

}

function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

/******** Added from QAIndividualIndicatorEntry.jsp *********/

function funCancel()
{
	parent.window.close();
}

function collectData()
{
 encounter_id=document.forms[0].ENCOUNTER_ID.value;
clind_analysis_status=document.forms[0].CLIND_ANALYSIS_STATUS.value;
qind_clind_id=document.forms[0].QIND_CLIND_ID.value;
incl_diag_code=document.forms[0].INCL_DIAG_CODE.value;
incl_proc_code=document.forms[0].INCL_PROC_CODE.value;
incl_compl_code=document.forms[0].INCL_COMPL_CODE.value;
incl_comments=document.forms[0].INCL_COMMENTS.value;
patient_class=document.forms[0].PATIENT_CLASS.value;

var obj = document.forms[0].INCL_FOR_YES_YN;
var rowVal = document.forms[0].rowVal.value;


ret=encounter_id+"|"+clind_analysis_status+"|"+qind_clind_id+"|"+incl_diag_code+"|"+incl_proc_code+"|"+incl_compl_code+"|"+incl_comments+"|"+patient_class;

if (document.forms[0].INCL_FOR_YES_YN[0].checked == true)
{
ret=ret+"|Y|"+rowVal
}
else
{
ret=ret+"|N|"+rowVal
}
//alert("ret:"+ret);
	parent.window.returnValue = ret;
	parent.window.close();

//apply();
	

}
function disableAll()
{
	var prop = document.forms[0].close_property.value;
	if (prop=='disabled=true')
	{
		var allElements = document.forms[0].elements;
		for (i=0;i<allElements.length;i++)
		{
			try
			{
				eval('document.forms[0].'+allElements[i].name+'.'+prop);
			}
			catch(e)
			{
			}
		}
	}
}


function funShowNote()
{
	var dialogTop			= "111";
	var dialogHeight		= "30" ;
	var dialogWidth			= "39" ;
	var features			= 		"dialogTop:"+dialogTop+
									"; dialogHeight:" + dialogHeight + 
									"; dialogWidth:" + dialogWidth +
									";status=no;" ;
	var arguments			= "" ;
	var title="Indicator Reference Note";
	var QUERY_PARAM = document.forms[0].QUERY_STRING.value;

	var par = QUERY_PARAM;

	retVal=window.showModalDialog("../../eQA/jsp/QAIndicatorReferenceNote.jsp?"+par,arguments,features);

	
}

function patchart(obj)
{

	var strEncounterId=obj.ENCOUNTER_ID;
	var PATIENT_CLASS=obj.PATIENT_CLASS;
	var PATIENT_ID=obj.PATIENT_ID;


HTMLVal = "<HTML><BODY><form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>";
HTMLVal += "<input type='hidden' name='patient_id' id='patient_id' value= '"+PATIENT_ID+"'>"; 
//HTMLVal += "<input type='hidden' name='encounter_id' id='encounter_id' value= '"+strEncounterId+"'>";
HTMLVal += "<input type='hidden' name='patient_class' id='patient_class' value= '"+PATIENT_CLASS+"'>";
HTMLVal += "<input type='hidden' name='mode' id='mode' value= 'V'>"; 
HTMLVal += "<input type='hidden' name='from_service_yn' id='from_service_yn' value= 'Y'>"; 			
HTMLVal += "</form>";
HTMLVal += "</body></html>";
//alert('in patchart');
parent.qa_message_frame.document.write(HTMLVal);
parent.qa_message_frame.document.historyForm.submit();
	
}

function getClindInd()
{
	var clinical_group=document.getElementById("clinical_group").value;
	HTMLVal = "<HTML><BODY><form name='ClindIndForm' id='ClindIndForm' action='../../eQA/jsp/QAgetClinicalIndicator.jsp'>";
	HTMLVal += "<input type='hidden' name='clinical_group' id='clinical_group' value= '"+clinical_group+"'>"; 
	HTMLVal += "</form>";
	HTMLVal += "</body></html>";
	parent.blankFrame.document.write(HTMLVal);
	parent.blankFrame.document.ClindIndForm.submit();

}

