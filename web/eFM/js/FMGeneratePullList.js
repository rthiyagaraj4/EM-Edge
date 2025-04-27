function apply()
{
	var insert_check =	parent.frames[2].frames[1].document.forms[0].pull_list_yn.checked;
	if(insert_check)
	{
		parent.frames[2].frames[1].document.forms[0].method='post';
		parent.frames[2].frames[1].document.forms[0].action='../../servlet/eFM.FMGeneratePullingListServlet';
		parent.frames[2].frames[1].document.forms[0].target='messageFrame';
		parent.frames[2].frames[1].document.forms[0].submit();
	}
	else
	{
		parent.frames[2].frames[1].location.href='../../eCommon/html/blank.html';
		var msg="";
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
		return false;
	}
}





function create()
{
	parent.frames[2].frames[1].location.href='../../eFM/jsp/FMGeneratePullListMain.jsp'
}
function reset()
{
	parent.frames[2].frames[1].location.href='../../eFM/jsp/FMGeneratePullListMain.jsp'
}

function doDateTimeChk(obj)
{
	var comp=obj
	obj=obj.value
	var dttime = obj.split(" ");
	var dtArr=new Array()
	dtArr=obj.split("/")
	var dt
	var time
	var retval=true
	if(dttime == ""){}
	else if(dttime.length>1)
	{
		dt=dttime[0]
		time=dttime[1]

		if(!checkDt(dt) )
		{
			retval= false
			comp.focus()
		}
		else
		{
			if(time==null || time=="")
			{
				alert(getMessage("FM_INVALID_DATE_TIME","FM"))
				retval= false;
				comp.focus()
			}
			else
			{
				if(!chkTime(time))
				{
					retval= false
					alert(getMessage("FM_INVALID_DATE_TIME","FM"))
					comp.focus()
				}
				else
				{
					var today = new Date();
					var entDate = new Date(parseInt(dtArr[2]),parseInt(dtArr[1]-1),parseInt(dtArr[0]));
					if(!CompDates(entDate,today))
					{
						retval= false
						alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"))
						comp.focus()
					}
				}
			}
		}
	}
	else
	{
		retval= false
		alert(getMessage("FM_INVALID_DATE_TIME","FM"))
		comp.focus()
	}
	if(retval)
	{
		//callDateFunction(comp)
	}
	return retval
}
function CompDates(dat1,dat2)
{
	var comp = true;
	if (dat1.getFullYear() > dat2.getFullYear()){
		comp = true;
	}else if (dat1.getFullYear() == dat2.getFullYear()){
		if (dat1.getMonth() > dat2.getMonth()){
			comp = true;
		}else if (dat1.getMonth() == dat2.getMonth()){
			if (dat1.getDate() > dat2.getDate()){
				comp = true;
			}else if (dat1.getDate() == dat2.getDate()){
				comp = true;
			}else if (dat1.getDate() < dat2.getDate()){
				comp = false;	
			}
		}else if (dat1.getMonth() < dat2.getMonth()){
			comp = false;
		}
	}else if (dat1.getFullYear() < dat2.getFullYear()){
		comp = false;
	}
	return comp;
}
function chkTime(time1)
{
	var retval=true;

	if( (time1.charAt(time1.length-1) )!=":")
	{
		var time1arr=new Array()
		time1arr=time1.split(":")

		if(time1arr.length==2)
		{
			var time1hr=time1arr[0]
			var time1min=time1arr[1]

			time1hr=eval(time1hr)
			time1min=eval(time1min)
			if(time1hr<=23)
			{
				if(time1min>=60)
				{
						retval=false;
				}
			}
			else
					retval=false;
		}
		else
			retval=false;
	}
	else
			retval=false;
	return retval
}
function checkDt(date1)
{
retval=true
var date1arr=new Array()
date1arr=date1.split("/")
if(date1arr.length==3)
{
	var date1d=date1arr[0]
	var date1m=date1arr[1]
	var date1y=date1arr[2]

	date1d=eval(date1d)
	date1m=eval(date1m)
	date1yy=eval(date1y);

	if(date1m<=12)
	{
		if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
		{
		retval= false}

		if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30))
		{
		retval= false}

		if ((date1y.length <4) || (date1y.length >4))
			{
			retval= false}
			}
		else
		{
		retval= false;}
	}
	else
	{retval= false;}
	return retval;
}
function fetchResult(obj)
{
	var val = obj.value;
	if((val != "")) //&& (val1 !=""))
	{
	   var appl_user = document.forms[0].appl_user_id.value;
	parent.frames[1].location.href="../../eFM/jsp/FMGeneratePullListResult.jsp?fs_locn_code="+val+"&appl_user="+appl_user;
		parent.frames[2].location.href="../../eFM/jsp/FMGeneratePullListNote.jsp";
		var msg="";
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
		 
	}
	else
	{
		parent.frames[1].location.href="../../eCommon/html/blank.html";
		parent.frames[2].location.href="../../eCommon/html/blank.html";
		var msg=getMessage("FILE_STORAGE_NOT_BLANK","FM");
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
		return false;
	}
}
function subForm()
{
	document.forms[0].appl_user_id.value = appl_user_id;
	document.forms[0].method='post';
	document.forms[0].action='../../servlet/eFM.FMGeneratePullingListServlet';
	document.forms[0].target=parent.parent.frames[2].name;
	document.forms[0].submit();
}
function onSuccess()
{
	parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.href='../../eFM/jsp/FMGeneratePullListCriteria.jsp';
}

function valChkDate(from,to,till) 
{
	
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	var tilldate = till.value ;

	if(todate !="")
	{
	
	//Commented by Ashwini on 24-Nov-2020 for ML-MMOH-CRF-1503
	/*if(!parent.frames[1].isAfterNow(todate,"DMY",localeName))
	{
		var error = getMessage("APPT_DATE_NOT_LESS_CURRDATE","FM");
		parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
		to.focus();
		to.select();
		return false;
	}
	else
	{
		parent.frames[1].document.forms[0].to_appt_date_disp.value=todate;
		parent.frames[1].document.forms[0].to_appt_date.value=todate;
		parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return true;
	}*/
	
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		tillarray = tilldate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		var tilldt = new Date(tillarray[2],tillarray[1],tillarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			var error = getMessage("APPT_DATE_NOT_LESS_CURRDATE","FM");
			parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
			to.focus();
			to.select();
			return false;
		}
		else if(Date.parse(todt) > Date.parse(tilldt)) 
		{	
			if(Date.parse(fromdt) != Date.parse(tilldt))
			{		
				var error = getMessage("APPT_DATE_NOT_GRT_CURRDATE","FM");
				parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
				to.focus();
				to.select();
				return false;
			}
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) 
		{
			parent.frames[1].document.forms[0].to_appt_date_disp.value=todate;
			parent.frames[1].document.forms[0].to_appt_date.value=todate;
			parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return true;
		}
	}
	return true;
	}
	/*else
	{
			var msg=getMessage("APPT_DATE_CANNOT_BLANK","FM");
			parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			to.focus();		    
			return false;
	}*/
}
function generateFunc()
{


	
	var p_appt_date		 = document.forms[0].fm_appt_date.value; 
	var p_fm_clinic_code = document.forms[0].fm_clinic_code.value;
	var p_to_clinic_code = document.forms[0].to_clinic_code.value;
	var p_fm_pract_id	 = document.forms[0].fm_pract_id.value;
	var p_to_pract_id	 = document.forms[0].to_pract_id.value;
	var pull_list_gen_by_gender	 = document.forms[0].pull_list_gen_by_gender.value;

	var p_fs_locn_code	 = parent.frames[0].document.forms[0].fs_locn_code.value;
	var p_gender	 = parent.frames[1].document.forms[0].p_gender.value;
	
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
	var start_time		= document.forms[0].start_time.value;
	var end_time		= document.forms[0].end_time.value;
	var error			= "";
	var isProceed		= true;
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/
	
   if(document.forms[0].print_req_slip.checked==true)
	{	
        document.forms[0].print_req_slip1.value="Y";
		}else{
			
          document.forms[0].print_req_slip1.value="N";
	}
	// code added for 20196 date:Wednesday, March 24, 2010

	if(!parent.frames[2].valChkDate(document.forms[0].sysdate,document.forms[0].fm_appt_date,document.forms[0].sys_date)){
		isProceed	= false;
	}
	
	if(p_appt_date=="")    {	
		error = getMessage('CAN_NOT_BE_BLANK','common');
		error = error.replace('$',getLabel("Common.apptdate.label","common"))+"<br>";
		//parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
		isProceed	= false;
     }
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
	if(start_time!="" || end_time!=""){
		if(start_time=="" || end_time==""){
			error	+=  getMessage('START_END_TIME_CANNOT_BE_BLANK','FM');;
			isProceed	= false;
		}
	}
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/
	
	if(error!="" && isProceed==false){
		parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
	}
	
     if(isProceed)
	 {	
		var p_pull_type = document.forms[0].print_pull_list_type.value;
		if(parent.frames[2].CheckString(getLabel("Common.locationcode.label","common"), document.forms[0].fm_clinic_code,document.forms[0].to_clinic_code, parent.parent.frames[2]))
		
		if(parent.frames[2].CheckString(getLabel("Common.resourceid.label","common"), document.forms[0].fm_pract_id,document.forms[0].to_pract_id, parent.parent.frames[2]))	
		{
		
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' 	action='../../eFM/jsp/FMGeneratePullListConfirm.jsp'><input name='p_appt_date' id='p_appt_date' type='hidden' value='"+p_appt_date+"'><input name='p_fm_clinic_code' id='p_fm_clinic_code' type='hidden' value='"+p_fm_clinic_code+"'><input name='p_to_clinic_code' id='p_to_clinic_code' type='hidden' value='"+p_to_clinic_code+"'><input name='p_fm_pract_id' id='p_fm_pract_id' type='hidden' value='"+p_fm_pract_id+"'><input name='p_to_pract_id' id='p_to_pract_id' type='hidden' value='"+p_to_pract_id+"'><input name='p_gender' id='p_gender' type='hidden' value='"+p_gender+"'><input name='p_fs_locn_code' id='p_fs_locn_code' type='hidden' value='"+p_fs_locn_code+"'><input name='p_pull_type' id='p_pull_type' type='hidden' value='"+p_pull_type+"'><input name='pull_list_gen_by_gender' id='pull_list_gen_by_gender' type='hidden' value='"+pull_list_gen_by_gender+"'></form></BODY></HTML>";
				
			parent.parent.frames[2].document.write(HTMLVal);
			parent.parent.frames[2].document.form1.submit();
			parent.frames[1].document.forms[0].generate.disabled=true;
		}
	}
}
function chngclinic(obj)
{
	if(obj.name=="fm_clinic_code")
		parent.frames[1].document.forms[0].to_clinic_code.value=obj.value;
	if(obj.name=="fm_pract_id")
		parent.frames[1].document.forms[0].to_pract_id.value=obj.value;
}

function searchCode(target,facility_id,target_name)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
				var dispDescFirst="dispDescFirst";			
				tit=getLabel("Common.user.label","common");
				sql="select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facility_id+"` ";
				search_code="APPL_USER_ID";
				search_desc= "APPL_USER_NAME";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);
			if (retVal!=null){
				if (!(unescape(retVal) == null))
				{
					arr=unescape(retVal).split("::");
					target_name.value=arr[0];
					target.value=arr[1];
				}
			}else {
				target.value="";
				target_name.value="";
			}

	}

function practValidate(Obj)
		{
			document.forms[0].P_RESOURCE_CLASS.value=Obj.value;
			document.forms[0].fm_pract_id.value='';
			document.forms[0].to_pract_id.value='';
			if(Obj.value=='')
			{
				document.forms[0].fm_pract_id.value='';
				document.forms[0].to_pract_id.value='';
				document.forms[0].fm_pract_id.disabled=true;
				document.forms[0].pract_id.disabled=true;
				document.forms[0].pract_id1.disabled=true;
				document.forms[0].to_pract_id.disabled=true;				
			}
			else
			{
				document.forms[0].fm_pract_id.disabled=false;
				document.forms[0].to_pract_id.disabled=false;
				document.forms[0].pract_id.disabled=false;
				document.forms[0].pract_id1.disabled=false;				
			}
		}

function getResource(Obj)
		{
			var carelocn="";
			var resource1 = document.forms[0].p_resource_class1.value;
			var n=document.forms[0].fm_pract_type.options.length;
			for(var i=0;i<n;i++)
			{
				document.forms[0].fm_pract_type.remove("clinic");
				document.forms[0].to_pract_type.remove("clinic");
			}
			var opt=document.createElement("OPTION");
			opt.text=" -------"+getLabel("Common.defaultSelect.label","common")+"------ ";
			opt.value="";
			document.forms[0].fm_pract_type.add(opt);	
			var opt1=document.createElement("OPTION");
			opt1.text=" -------"+getLabel("Common.defaultSelect.label","common")+"------ ";
			opt1.value="";
			document.forms[0].to_pract_type.add(opt1);	
			if(!(resource1 == null || resource1 == ""))
			{
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH resource1=\""+resource1+"\" steps='1' /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","../../eOA/jsp/ReportsServerSide.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				eval(responseText)
			}
		}

function callPractSearch(obj,target) 
		{
			var practName_FName="";
			var practName_FValue="";
			var practId_FName="";

			practName_FName=target.name;
			practName_FValue=target.value;
			practId_FName=document.forms[0].fm_pract_id.name;
			var facilityid = document.forms[0].facility_id.value;
			var p_resource_class1=document.forms[0].p_resource_class1.value;
			var clinic_code='';
			var sql="";
			var sql2="";
			if(p_resource_class1=='P')
			{
				if(obj.name=="pract_id")
				{
					var fm_pract_type = parent.frames[1].document.forms[0].fm_pract_type.value;
					
				//latest	sql="SELECT  PRACTITIONER_ID practitioner_id  ,PRACTITIONER_NAME practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"','1') practitioner_type ,AM_GET_DESC.AM_SPECIALITY(primary_speciality_code,'"+localeName+"','2') primary_specialty  , POSITION_CODE job_title  ,gender gender  FROM  am_practitioner_lang_vw  WHERE pract_type =nvl('"+fm_pract_type+"',pract_type)   AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))   AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code))   AND   (  UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id))   OR UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name))  )   AND UPPER(gender) LIKE NVL(UPPER(?),UPPER(gender))   AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))   and language_id = '"+localeName+"' ORDER BY  PRACTITIONER_NAME ";

					//latest sql2=" SELECT  PRACTITIONER_ID practitioner_id  ,PRACTITIONER_NAME practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(primary_speciality_code,'"+localeName+"','2') primary_specialty  , POSITION_CODE job_title  ,gender gender  FROM  am_practitioner_lang_vw  WHERE pract_type =nvl('"+fm_pract_type+"',pract_type)   AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))   AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code))   AND   (  UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id))   AND UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name))  )   AND UPPER(gender) LIKE NVL(UPPER(?),UPPER(gender))   AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))   and language_id = '"+localeName+"' ORDER BY  PRACTITIONER_NAME ";
					getPractitioner_common(obj,target,fm_pract_type,"","Q1");
				}
				if(obj.name=="pract_id1")
				{
					var to_pract_type = parent.frames[1].document.forms[0].to_pract_type.value;
	
					//latest sql="SELECT  PRACTITIONER_ID practitioner_id   ,PRACTITIONER_NAME practitioner_name   ,AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(primary_speciality_code,'"+localeName+"','2') primary_specialty  ,POSITION_CODE job_title   ,gender gender  FROM  am_practitioner_lang_vw  WHERE pract_type =nvl('"+to_pract_type+"',pract_type)   AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))   AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code))   AND   (  UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id))   OR UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name))   )   AND UPPER(gender) LIKE NVL(UPPER(?),UPPER(gender))   AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))   and language_id = '"+localeName+"' ORDER BY  PRACTITIONER_NAME ";

					//latest sql2="SELECT  PRACTITIONER_ID practitioner_id   ,PRACTITIONER_NAME practitioner_name   ,AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(primary_speciality_code,'"+localeName+"','2') primary_specialty  , POSITION_CODE job_title   ,gender gender  FROM  am_practitioner_lang_vw  WHERE pract_type =nvl('"+to_pract_type+"',pract_type)   AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))   AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code))   AND   (  UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id))   AND UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name))   )   AND UPPER(gender) LIKE NVL(UPPER(?),UPPER(gender))   AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))  and language_id = '"+localeName+"'  ORDER BY  PRACTITIONER_NAME ";
					getPractitioner_common(obj,target,to_pract_type,"","Q1");
				}

				/*var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
				var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
				xmlStr	="<root><SEARCH " ;
				xmlStr += " practName_FName=\"" +practName_FName + "\"";
				xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
				xmlStr += " practId_FName=\"" + practId_FName + "\"";
				xmlStr += " sql=\"" +escape(sql)+ "\"";
				xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
				xmlStr += " practitioner_type=\"" + "" + "\"";
				xmlStr += " specialty_code=\"" + "" + "\"";
				xmlStr += " job_title=\"" + "" + "\"";
				xmlStr += " gender=\"" + "" + "\"";
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);	*/
			}
			else if(p_resource_class1=='E' || p_resource_class1=='O')
			{
				//Equipment and others
				if(obj.name=="pract_id")
				{
					res_type = parent.frames[1].document.forms[0].fm_pract_type.value;
					sql="Select resource_id code,short_desc description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+p_resource_class1+"'  and  language_id='"+localeName+"' and resource_type=nvl('"+res_type+"',resource_type) and upper(resource_id) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
					call_common(sql,"pract_id");
				}
				else
				{
					res_type = parent.frames[1].document.forms[0].to_pract_type.value;
					sql="Select resource_id code,short_desc description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+p_resource_class1+"'  and  language_id='"+localeName+"' and resource_type=nvl('"+res_type+"',resource_type) and upper(resource_id) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
					call_common(sql,"pract_id1");
				}
			}
			else if(p_resource_class1=='R')
			{//Room
			if(obj.name=="pract_id")
			{
				clinic_code = parent.frames[1].document.forms[0].fm_clinic_code.value;
				res_type = parent.frames[1].document.forms[0].fm_pract_type.value;
				sql="select PRACTITIONER_ID code ,AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+localeName+"','2') description from op_pract_for_clinic_vw where clinic_code=nvl('"+clinic_code+"',clinic_code) and RESOURCE_CLASS=nvl('"+res_type+"',RESOURCE_CLASS) and Facility_id ='"+facilityid+"' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_SHORT_NAME) like upper(?) order by PRACTITIONER_SHORT_NAME";
				/*sql="select room_no code ,room_short_desc description from op_clinic_room_vw where clinic_code=nvl('"+clinic_code+"',clinic_code) and room_type=nvl('"+res_type+"',room_type) and Facility_id ='"+facilityid+"' and upper(room_no) like upper(?) and upper(room_short_desc)  like upper(?) order by  room_short_desc";*/
				call_common(sql,"pract_id");
			}
			else
			{
				clinic_code = parent.frames[1].document.forms[0].to_clinic_code.value;
				res_type = parent.frames[1].document.forms[0].to_pract_type.value;
				sql="select PRACTITIONER_ID code ,AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+localeName+"','2') description from op_pract_for_clinic_vw where clinic_code=nvl('"+clinic_code+"',clinic_code) and RESOURCE_CLASS=nvl('"+res_type+"',RESOURCE_CLASS) and Facility_id ='"+facilityid+"' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_SHORT_NAME) like upper(?) order by PRACTITIONER_SHORT_NAME";
				call_common(sql,"pract_id1");
			}
		}
	}

async function call_common(sql,objName)
	{
		var tit				= getLabel("Common.resource.label","common");
		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var yyy;
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
	
		if(objName=="pract_id")
		{     
			argumentArray[5] = document.forms[0].fm_pract_id.value;
		}
		else 
		{
			argumentArray[5] = document.forms[0].to_pract_id.value;
		}
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )	
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			if(objName=="pract_id")
			{
				document.forms[0].fm_pract_id.value=arr[0];
			}
			else
			{
				document.forms[0].to_pract_id.value=arr[0];
			}
		}
		else
		{
			if(objName=="pract_id")
			{
				document.forms[0].fm_pract_id.focus();
				document.forms[0].fm_pract_id.value="";
			}
			else	
			{
				document.forms[0].to_pract_id.focus();
				document.forms[0].to_pract_id.value="";
			}
		}
	}
function onblurcheck(obj,target)
	{
		if(target.value == "")
		{
			if(obj.name=="fm_pract_id")
			{
				document.forms[0].fm_pract_id.value ="";
				return;
			}
			if(obj.name=="to_pract_id")
			{
				document.forms[0].to_pract_id.value="";
				return;
			}
		}
		callPractSearch(obj,target)
	}
function enablepr(obj)
	{
		document.forms[0].fm_pract_id.value='';
	}

function enablepr1(obj)
	{
		document.forms[0].to_pract_id.value='';
	}

/*function search(obj,target,obj1)
	{
		var retVal = 	new String();
		var dialogHeight= "28" ;
		var dialogWidth	= "43" ;
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";
		var facilityid = document.forms[0].facility_id.value;
		var p_location_type1=document.forms[0].p_location_type1.value;
			
		var facility=obj1.value;
		if(obj.name=="locn")
		{
			tit=getLabel("Common.Location.label","common");
			if(p_location_type1!='')
			{
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"` and level_of_care_ind = `A` and CARE_LOCN_TYPE_IND=`"+p_location_type1+"` ";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"` and level_of_care_ind = `A`";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}
		if(obj.name=="locn1")
		{
			tit=getLabel("Common.Location.label","common");
			if(p_location_type1!='')
			{
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"` and level_of_care_ind = `A` and CARE_LOCN_TYPE_IND=`"+p_location_type1+"`";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"` and level_of_care_ind = `A`"
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

		if (!(retVal == null))
		{
			target.value=retVal;
		}
		else
			target.focus();
	}*/
	
async function search(obj,target,obj1)
	{  
	
		var retVal = 	new String();
		var dialogHeight= "28" ;
		var dialogWidth	= "43" ;
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";
		var facilityid = document.forms[0].facility_id.value;
		var p_location_type1=document.forms[0].p_location_type1.value;
			
		var facility=obj1.value;
/*Added eff_status='E' in below Query by Senthil on 14-Oct-2011 [IN029281]*/
		if(obj.name=="locn")
		{
			tit=getLabel("Common.Location.label","common");
			if(p_location_type1!='')
			{    
				sql="select clinic_code code, long_desc description  from   op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"' and level_of_care_ind = 'A' and eff_status='E' and CARE_LOCN_TYPE_IND='"+p_location_type1+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{    
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"' and level_of_care_ind = 'A' and eff_status='E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}
		if(obj.name=="locn1")
		{
			tit=getLabel("Common.Location.label","common");
			if(p_location_type1!='')
			{
				sql="select clinic_code code, long_desc description from  op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"' and level_of_care_ind = 'A' and eff_status='E' and CARE_LOCN_TYPE_IND='"+p_location_type1+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"' and level_of_care_ind = 'A' and eff_status='E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)"
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}		
		/*

		if (!(retVal == null))
		{
			target.value=retVal;
		}
		else
			target.focus();*/
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK  ;
		argumentArray[7] = CODE_DESC ;

		retVal = await CommonLookup( tit, argumentArray );

		var arr=new Array();

		if(retVal != null && retVal != "" ) {	
			var retVal=unescape(retVal);
		    arr=retVal.split(",");
			target.value=arr[0];
		}
		else
		{
			target.value="";
		}
	}



function changeVal(obj)
	{
		document.forms[0].P_LOCATION_TYPE.value=obj.value;
		document.forms[0].fm_clinic_code.value='';
		document.forms[0].to_clinic_code.value='';
		if(obj.value != null)
		{
			if(document.forms[0].fm_clinic_code.disabled == true)
				document.forms[0].fm_clinic_code.disabled = false;
			if(document.forms[0].locn.disabled == true)
				document.forms[0].locn.disabled = false;
			if(document.forms[0].to_clinic_code.disabled == true)
				document.forms[0].to_clinic_code.disabled = false;
			if(document.forms[0].locn1.disabled == true)
				document.forms[0].locn1.disabled = false;
		}
	}
function chng_appt_date(obj)
	{
	/*	if(obj.value == 'A')
		{
			document.forms[0].p_order_term.value = '';
			document.getElementById("ordID").innerHTML	     = "&nbsp;";
		}
		else if(obj.value == 'T')
		{
			document.getElementById("ordID").innerHTML = "<select name='p_order_term' id='p_order_term'><option value='asc' selected>"+ getLabel('Common.ascending.label','common') +"</option><option value='desc'>"+ getLabel('Common.descending.label','common') +"</option></select>";	
		} */
        if(obj.value=='M')
		{
		//	document.forms[0].fm_appt_date.value   =document.forms[0].sys_date.value;
		//	document.forms[0].fm_appt_date.readOnly=true;
		//	document.getElementById("calend").style.display="none";
		document.forms[0].fm_appt_date.readOnly=false;				
			document.getElementById("calend").style.display="inline";
			document.getElementById("calend").style.visibility="visible";
		}
		else
		{
			document.forms[0].fm_appt_date.readOnly=false;				
			document.getElementById("calend").style.display="inline";
			document.getElementById("calend").style.visibility="visible";
		}
	}
function assignvalue(obj)
	{
		if(obj.checked==true)
			obj.value='Y';
		else
			obj.value='N';
	}
function EnableDisableBox(obj,getVal)
	{
		if(obj.checked==true)
		{
			obj.value='Y';
			if(getVal=='G')
			{
				document.forms[0].order_by_pull_list.disabled=false;
				if(document.forms[0].print_tel_no) {
					document.forms[0].print_tel_no.checked=false;
					document.forms[0].print_tel_no.disabled=false;
				}
				if(document.forms[0].print_bar_code) {
					document.forms[0].print_bar_code.checked=false;
					document.forms[0].print_bar_code.disabled=false;
				}
			}
			else
			{
				document.forms[0].gen_tracer.value="Y";
			}
		}
		else
		{
			obj.value='N';
			if (getVal=='G')
			{
				document.forms[0].order_by_pull_list.disabled=true;
				if(document.forms[0].print_tel_no) {
					document.forms[0].print_tel_no.checked=false;
					document.forms[0].print_tel_no.disabled=true;
				}
				if(document.forms[0].print_bar_code) {
					document.forms[0].print_bar_code.checked=false;
					document.forms[0].print_bar_code.disabled=true;
				}
			}
			else
			{
				document.forms[0].gen_tracer.value="N";
			}
		}
	}
	function PractLookupRetVal(retVal,objName)
	{
		var arr;
		if(!(retVal == null))
		{
			arr=retVal.split("~");
			if(objName=="fm_pract_id")
			{				
				document.forms[0].fm_pract_id.value=arr[0];
				
			}
			else
			{
				document.forms[0].to_pract_id.value=arr[0];
			}
		}
		else
		{
			if(objName=="fm_pract_id")
			{
				document.forms[0].fm_pract_id.focus();
				document.forms[0].fm_pract_id.value="";
			}
			else	
			{
				document.forms[0].to_pract_id.focus();
				document.forms[0].to_pract_id.value="";
			}
		}
	}

function doOnlineReportPrinting(msg,fm_appt_date,to_appt_date,fm_clinic_code,to_clinic_code,fm_pract_id,to_pract_id,p_gender,pull_list_yn,fs_locn_code,appl_user_id,p_gen_report,print_tel_no,print_bar_code,gen_tracer,operation_type,order_by_pull_list,print_pull_list_type,p_order_term,p_pull_list_seq,p_print_req_slip)
	{
 	 parent.frames[1].document.forms[0].generate.disabled=false;
	 var flag="true";
	   HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' 	action='../eFM/jsp/FMGeneratePullListConfirm.jsp'><input name='fm_appt_date' id='fm_appt_date' type='hidden' value='"+fm_appt_date+"'><input name='to_appt_date' id='to_appt_date' type='hidden' value='"+to_appt_date+"'><input name='fm_clinic_code' id='fm_clinic_code' type='hidden' value='"+fm_clinic_code+"'><input name='to_clinic_code' id='to_clinic_code' type='hidden' value='"+to_clinic_code+"'><input name='fm_pract_id' id='fm_pract_id' type='hidden' value='"+fm_pract_id+"'><input name='to_pract_id' id='to_pract_id' type='hidden' value='"+to_pract_id+"'><input name='p_gender' id='p_gender' type='hidden' value='"+p_gender+"'><input name='pull_list_yn' id='pull_list_yn' type='hidden' value='"+pull_list_yn+"'><input name='fs_locn_code' id='fs_locn_code' type='hidden' value='"+fs_locn_code+"'><input name='appl_user_id' id='appl_user_id' type='hidden' value='"+appl_user_id+"'><input name='p_gen_report' id='p_gen_report' type='hidden' value='"+p_gen_report+"'><input name='print_tel_no' id='print_tel_no' type='hidden' value='"+print_tel_no+"'><input name='print_bar_code' id='print_bar_code' type='hidden' value='"+print_bar_code+"'><input name='gen_tracer' id='gen_tracer' type='hidden' value='"+gen_tracer+"'><input name='operation_type' id='operation_type' type='hidden' value='"+operation_type+"'><input name='order_by_pull_list' id='order_by_pull_list' type='hidden' value='"+order_by_pull_list+"'><input name='print_pull_list_type' id='print_pull_list_type' type='hidden' value='"+print_pull_list_type+"'><input name='p_order_term' id='p_order_term' type='hidden' value='"+p_order_term+"'><input name='p_print_req_slip' id='p_print_req_slip' type='hidden' value='"+p_print_req_slip+"'><input name='flag' id='flag' type='hidden' value='"+flag+"'><input name='p_pull_list_seq' id='p_pull_list_seq' type='hidden' value='"+p_pull_list_seq+"'></form></BODY></HTML>";
		parent.parent.frames[3].document.write(HTMLVal);
		parent.parent.frames[3].document.form1.submit();

	
	parent.parent.frames[2].location.href="../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=1";
	
  }  

/*	function disable_pulltype()
	{
		document.forms[0].print_pull_list_type.value="M";
		document.forms[0].print_pull_list_type.disabled=true;

	}  */

