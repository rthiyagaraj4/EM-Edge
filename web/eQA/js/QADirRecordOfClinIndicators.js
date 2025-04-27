function onSuccess() 
{
    funDisiplineList();
	parent.qa_discipline_result.location.reload();
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

function funDisiplineList()
{
	var from=""
    var to="" 
     if(document.forms[0])
	 {
		var obj=document.forms[0].QIND_QUERY.value;
		var list=document.forms[0].QIND_DISCIPLINE_ID;
        if(list.options[list.selectedIndex].value =="-1"){
	     parent.qa_discipline_result.location.href ='../../eCommon/html/blank.html';
	     }else{
		obj=obj+"&"+list.name+"="+list.value+"&QIND_DISCIPLINE_DESC="+list.options[list.selectedIndex].text;
		parent.qa_discipline_result.location.href ='../../eQA/jsp/QAIndicatorList.jsp?'+obj+'&from=1&to=14';
		}
	}
	else
	{
		var obj=parent.frames[0].document.forms[0].QIND_QUERY.value;
		var list=parent.frames[0].document.forms[0].QIND_DISCIPLINE_ID;
		from=parent.frames[1].document.forms[0].from.value  

		to=parent.frames[1].document.forms[0].to.value  
     	obj=obj+"&"+list.name+"="+list.value+"&QIND_DISCIPLINE_DESC="+list.options[list.selectedIndex].text;
        parent.qa_discipline_result.location.href ='../../eQA/jsp/QAIndicatorList.jsp?'+obj+'&from='+from+'&to='+to;
	 }
}
function clearPage()
{
     parent.frames[2].location.href='../../eCommon/html/blank.html' 
}
function funQASearchValidation(obj)
{
	if ( (obj.ENCOUNTER_ID.value == '')||(obj.ENCOUNTER_ID.value == null) )
	{
			if(obj.PATIENT_CLASS.value =='')
			{ 
				obj.PATIENT_CLASS.focus();
				alert(getMessage('PAT_CLASS_MANDATORY'));
		        parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
				return false;
			}
	}
}

function clearResult()
{
    parent.frames[2].location.href ='../../eCommon/html/blank.html'
	document.forms[0].ASSIGN_CARE_LOCN_CODE.value ="";
}

function funQATransactionSearch(obj)
{
	var sql ;
	var where = ' WHERE 1=1';
	if (funQASearchValidation(obj) ==false)
	{
		obj.PATIENT_CLASS.focus();
	}
	var ENCOUNTER_ID = obj.ENCOUNTER_ID.value;
	var PATIENT_ID = obj.PatientId.value;
	var PATIENT_CLASS = obj.PATIENT_CLASS.value;
	var ASSIGN_CARE_LOCN_CODE = obj.ASSIGN_CARE_LOCN_CODE.value;
	var PERIOD_FROM = obj.PERIOD_FROM.value;
	var PERIOD_TO = obj.PERIOD_TO.value;
	var PRACTITIONER_ID = obj.PRACTITIONER_ID.value;
	var STATUS = obj.STATUS.value;
	var INCL_ANALYZED_YN = obj.INCL_ANALYZED_YN.value;
	var ORDER_BY = obj.ORDER_BY.value;

	if ((ENCOUNTER_ID != null) &&(ENCOUNTER_ID !='') )
	{
		where += " AND ENCOUNTER_ID="+ENCOUNTER_ID;
	}
	if ((PRACTITIONER_ID!= null) &&(PRACTITIONER_ID!='') )
	{
		where += " AND PRACTITIONER_ID='"+PRACTITIONER_ID+"'";
	}
	if ((PATIENT_ID != null) &&(PATIENT_ID !='') )
	{
			where += " AND PATIENT_ID='"+PATIENT_ID+"'";
	}
	if ((PATIENT_CLASS != null) &&(PATIENT_CLASS !='') )
	{     
			where += " AND PATIENT_CLASS='"+PATIENT_CLASS+"'";
	}

	if ((ASSIGN_CARE_LOCN_CODE != null) &&(ASSIGN_CARE_LOCN_CODE !='') )
	{     
			where += " AND ASSIGN_CARE_LOCN_CODE='"+ASSIGN_CARE_LOCN_CODE+"'";
	}

	if (  ((PERIOD_FROM != null) &&(PERIOD_FROM !='')) || 
		((PERIOD_TO != null) &&(PERIOD_TO !=''))  )
	{
			where += " AND TRUNC(VISIT_ADM_DATE_TIME) BETWEEN  nvl(to_date('"+PERIOD_FROM+"','dd/mm/yyyy'), to_date(to_char(VISIT_ADM_DATE_TIME, 'dd/mm/yyyy'),'dd/mm/yyyy')) "+
						" AND nvl(to_date('"+PERIOD_TO+"','dd/mm/yyyy'), to_date(to_char(VISIT_ADM_DATE_TIME, 'dd/mm/yyyy'), 'dd/mm/yyyy')) ";
	}
	if ((STATUS != null) &&(STATUS !='') )
	{
		where += " AND STATUS='"+STATUS+"'";
	}
	if (INCL_ANALYZED_YN == 'N')
	{
		where += " AND NVL(QIND_ANALYSIS_STATUS,'0')<>'9'";
	}

		sql = 	"SELECT FACILITY_ID||ENCOUNTER_ID FAC_ENC_ID,FACILITY_ID FACID ,STATUS ENC_STATUS,       	nvl(QIND_ANALYSIS_STATUS,' ') QIND_ANALYSIS_STATUS ,	ENCOUNTER_ID   ENCOUNTER_ID,				ASSIGN_CARE_LOCN_CODE  ASS_LOCN,	PATIENT_NAME PATIENT_NAME,decode(sex,'M','Male','F','Female','U','Unknown') gender ,PATIENT_ID PATIENT_ID,NVL(PRACTITIONER_ID,' ') PRACTITIONER_ID,to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy') DATE_TIME ,PATIENT_CLASS PATIENT_CLASS   FROM	QA_PR_MP_QIND_ENCOUNTER_VW";
        sql = sql+where+ " ORDER BY "+ORDER_BY+" DESC ";
  
		sql=escape(sql);

   if(!(ENCOUNTER_ID=="" && PATIENT_CLASS==""))
	{

	parent.frames[2].location.href = '../../eQA/jsp/QADirRecordOfClinIndSearchResult.jsp?sql='+sql;
	}

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

/*	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	var title="Complication Search";

	var column_sizes = escape("30%,70%");               
	var column_descriptions = escape("Code,Description"); 
	var sql ;

	var params=document.forms[0].QIND_CLIND_ID.value;
	sql=escape(" SELECT  COMPL_CODE COM_CODE,COMPL_DESCRIPTION COMPL_DESCRIPTION  FROM QA_QIND_CLIND_COMPL   WHERE  QIND_CLIND_ID   = '"+params+"'");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?"+param,arguments,features);
	var arr=new Array();

	if(retVal == null) retVal='';
	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("::");
			document.forms[0].INCL_COMPL_CODE.value = arr[0];
			document.forms[0].COMPL_DESCRIPTION.value=arr[0];
		}
		else		
		{
			document.forms[0].INCL_COMPL_CODE.value ="";
			document.forms[0].COMPL_DESCRIPTION.value="";

		}
	}*/

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

async function funQAPractioner(obj,target)
{ 	
	var retVal =    new String();               
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	tit="Practitioner Search"
	sql="Select PRACTITIONER_ID code, PRACTITIONER_NAME description from AM_PRACTITIONER where eff_status='E' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?) order by 1";					
	
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
	
		document.forms[0].PRACTITIONER_ID.value = arr[0];
	}else
	{
	target.value="";
	}
}

async function funPatient()
{
	var patid=await PatientSearch('','','','','','','Y','','','OTHER');
	if( patid ==null)patid="";
	document.forms[0].PatientId.value = patid;
}


function checkAttributes(obj,arr)
{
	for(k=0;k<arr.length;k++)
	{
			if (obj.getAttribute(arr[k])=='Y') 
			{
				return true;
			}
	}
	return(false);
}


/******  Added from the  QADirRecordOfClinIndSearchResult.jsp ******/

async function fun(obj)
{

	var dialogTop			= "10vh" ;
	var dialogHeight		= "65vh" ;
	var dialogWidth			= "65vw" ;
	var features			= "dialogTop:" + dialogTop +"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title="Indicator Entry Transaction ";
	var column_descriptions = escape("Practitioner id, Practitioner Name, Facility"); 
	var par = 
		'ENCOUNTER_ID='+obj.ENCOUNTER_ID+'&'+
		'FACILITY_ID='+obj.FACILITY_ID+'&'+
		'PATIENT_NAME='+obj.PATIENT_NAME+'&'+
		'PATIENT_ID='+obj.PATIENT_ID+'&'+
		'PATIENT_CLASS='+obj.PATIENT_CLASS+'&'
		'title='+title;
	
		retVal= await window.showModalDialog("../../eQA/jsp/QAIndicatorEntryMain.jsp?"+par,arguments,features);
}
	
function submitFormN()
{
	var from = new Number(document.forms[0].from.value );
	var to = new Number(document.forms[0].to.value );
	var maxval = new Number(document.forms[0].max_records.value );
	document.forms[0].from.value = from + maxval;
	document.forms[0].to.value = to + maxval;
	document.forms[0].submit();
}

function submitFormP()
{
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

function filterRecs(frObj)
{
	var arr = new Array();
	var elements = frObj.all;
	var rec_id = '';
	var attrib = '';
	var val = '';
	for (l=0;l<elements.length;l++)
	{
			rec_values = checkAttributeNull(elements[l],'REC_VALUES')
			if (rec_values == '') 
			{
				continue;
			}
			else
			{
				rec_id = checkAttributeNull(elements[l],'REC_ID');
				arr.push(rec_id);
			}
	}
	return(arr);
}

function apply()
{
var list=document.forms[0].QIND_DISCIPLINE_ID;
   if(list.options[list.selectedIndex].value !="-1"){
    parent.frames[0].document.Discipline_Frame.method = "POST";
	parent.frames[0].document.Discipline_Frame.action = '../../servlet/eQA.QADirRecordOfClinIndicatorsServlet';
	parent.frames[0].document.Discipline_Frame.target = "qa_message_frame";
	parent.frames[0].document.Discipline_Frame.submit();}
}
	  
/********* Added from QAIndicatorList.jsp ********/

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
	var query_param = document.forms[0].QUERY_PARAM.value;
	var encounter_id = document.forms[0].ENCOUNTER_ID.value;
	var splitValue=unescape(obj.value);
	splitValue.split("||")
	var arr=new Array()

	arr=splitValue.split("||");
	qind_clind_id =arr[0]  
	master_sys_user_created=arr[1] 
	trn_sys_user_created=arr[2]  
	qind_clind_desc=arr[3]  
	incl_proc_code=arr[4]  
	incl_diag_code=arr[5]  
	clind_analysis_status=arr[6]  
	optionstat=arr[7]  
	optionstat=eval(optionstat)+1
	
/* 	if (trn_sys_user_created =='S')
	{
	alert("APP-QA5002 System generated indicator. Modification not allowed");
	return false;
	}

	if ((master_sys_user_created =='S') && (trn_sys_user_created =='E'))
	{
	alert("APP-QA5005 System Indicator. Entry not allowed");
	return false;
	} */
	
	var par = query_param + '&' +
	"QIND_CLIND_ID="+qind_clind_id+'&'+
	"CLIND_ANALYSIS_STATUS="+clind_analysis_status+'&'+
	"QIND_CLIND_DESC="+qind_clind_desc+'&'+
	"INCL_PROC_CODE="+incl_proc_code+'&'+
	"INCL_DIAG_CODE="+incl_diag_code+'&'+
	"SYS_USER_CREATED="+trn_sys_user_created+'&'+
	"rowVal="+optionstat+'&'+
	"ENCOUNTER_ID="+encounter_id;
	
	var appobj = '';
	var app_check = '';
	var app_yn = 'N';

	var retVal=window.showModalDialog("../../eQA/jsp/QAIndividualIndicatorEntry.jsp?"+par,arguments,features);
    if (retVal != null)
    {
  
	var ret=retVal.split("|")
		
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
	   
			if (incl_yn == 'Y')
			{			
				eval("document.forms[0].INCL_FOR_NO"+rowVal+".checked=false")
				eval("document.forms[0].INCL_FOR_YES"+rowVal+".checked=true")
			}
			else
			{
					eval("document.forms[0].INCL_FOR_NO"+rowVal+".checked=true")
					eval("document.forms[0].INCL_FOR_YES"+rowVal+".checked=false")
			}
		
		 
		HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='../../eQA/jsp/QAIndicatorDataCollection.jsp'><input type='hidden' name='encounter_id' id='encounter_id' value='"+encounter_id+"'><input type='hidden' name='clind_analysis_status' id='clind_analysis_status' value='"+clind_analysis_status+"'><input type='hidden' name='qind_clind_id' id='qind_clind_id' value='"+qind_clind_id+"'><input type='hidden' name='incl_diag_code' id='incl_diag_code' value='"+incl_diag_code+"'><input type='hidden' name='incl_proc_code' id='incl_proc_code' value='"+incl_proc_code+"'><input type='hidden' name='incl_compl_code' id='incl_compl_code' value='"+incl_compl_code+"'><input type='hidden' name='incl_comments' id='incl_comments' value='"+incl_comments+"'><input type='hidden' name='incl_yn' id='incl_yn' value='"+incl_yn+"'><input type='hidden' name='patient_class' id='patient_class' value='"+patient_class+"'></form></BODY></HTML>";
        parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
        if(parent.blankFrame.document.form1!=null)
        parent.blankFrame.document.form1.submit();
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
function setStatus()
{
		document.forms[0].CLIND_ANALYSIS_STATUS.value = '9';
}
function checkCommentsManatory()
{
	if ((document.forms[0].SYS_USER_CREATED == 'S')
			&& (document.forms[0].H_CLIND_ANALYSIS_STATUS.value =='5'))
	{
		if ((document.forms[0].INCL_COMMENTS.value == '') ||
			(document.forms[0].INCL_COMMENTS.value == ' ') )
		{
			alert(getMessage('COMMENTS_ENTER'));
			return false;
		}
	}
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
	parent.window.returnValue = ret;
	parent.window.close();

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
function getElement(obj,xmldat)
{
	var allElements = obj.elements;
	for (i=0;i<allElements.length;i++)
	{
		if (xmldat == allElements[i].name)
		{
			return(allElements[i]);
		}
	}
}
function funXML()
{
	////////////////////////////////////////////////////////
	eval('document.forms[0].close_button.'+document.forms[0].close_property.value);

	document.forms[0].CLIND_ANALYSIS_STATUS.value = document.forms[0].H_CLIND_ANALYSIS_STATUS.value;

	var formObject = document.forms[0];
	var xml_element_name = formObject.name+'_XML';

	var xml_data = getElement(formObject,xml_element_name).value;


	if ( (xml_data == null) || 	(xml_data == '') ||(xml_data == 'null'))
	{
		return;
	}

	var root_node = formObject.name;
	var xmlDoc="";
	xmlDoc.loadXML(xml_data);
	var nodeList = xmlDoc.selectNodes(root_node); // Node List
	var node = nodeList.nextNode();
	var elementObj = '';
	var attributes = node.attributes;

	for (l =0;l<attributes.length;l++)
	{
		elementObj = getElement(formObject,attributes[l].name);
			if (elementObj != null)
			{
				
				elementObj.value = attributes[l].value;
				if (elementObj.type=='radio')
				{

					if (attributes[l].value == 'Y')
					{
						eval('document.forms[0].'+elementObj.name+'[0].checked=true');
					}
					else
					{
						eval('document.forms[0].'+elementObj.name+'[1].checked= true');
					}
					
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

async function getLocation(obj, target){
  var pat_class=document.forms[0].PATIENT_CLASS.value;
  var facility = document.forms[0].facility_id.value;
  if ((pat_class=="")||(pat_class==null)){
      alert(getMessage('PAT_CLASS_MANDATORY'));
  }
  else {
	var retVal =    new String();               
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	tit="Location Search"

	 if ((pat_class=='DC') || (pat_class=='IP')){
     	sql="Select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT where EFF_STATUS ='E' and upper(NURSING_UNIT_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) AND FACILITY_ID ='"+facility+"' order by 1";		
	 }
	 else if ((pat_class=='EM') || (pat_class=='OP')){
     	sql="Select CLINIC_CODE code, SHORT_DESC description from OP_CLINIC where EFF_STATUS ='E' and upper(CLINIC_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) AND FACILITY_ID ='"+facility+"' order by 1";		
	 }
  
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray  ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray  ;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.forms[0].ASSIGN_CARE_LOCN_CODE.value ;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );				
	if(retVal != null && retVal != "" )
	{					
		var ret1=unescape(retVal);
		arr=ret1.split(",");
	
		document.forms[0].ASSIGN_CARE_LOCN_CODE.value = arr[0];
	}else{
	     target.value="";
	}
  }
}	



function Incl_Encounter()
{
	var chkBox=document.forms[0].INCL_ANALYZED_YN;		
if(chkBox.checked)
	{
	  chkBox.value='Y';
	}
else
	{
        chkBox.value='N';
	}
}

