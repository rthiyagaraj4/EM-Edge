<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,java.util.*,com.ehis.util.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale							= (String)session.getAttribute("LOCALE");
	String loginUser						= (String)session.getValue("login_user");
	String facility_id						= (String)session.getValue("facility_id");
	String p_oper_stn_id					= checkForNull(request.getParameter("oper_stn_id"));
	String routine_tfr_yn					= checkForNull(request.getParameter("routine_tfr_yn"),"N");
	String systemdatetime					= checkForNull(request.getParameter("sydate"));
	String priority_applicable_yn			= checkForNull(request.getParameter("priority_applicable_yn"),"N");
	String change_bed_class_yn				= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	String deactivate_pseudo_bed_yn			= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String bl_interfaced_yn					= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
	String bed_block_period_max_type		= checkForNull(request.getParameter("bed_block_period_max_type"));
	String jsp_name							= checkForNull(request.getParameter("jsp_name"));
	String win_height						= checkForNull(request.getParameter("win_height"));
	String win_width						= checkForNull(request.getParameter("win_width"));
	String call_function					= checkForNull(request.getParameter("call_function"));
	String modal							= checkForNull(request.getParameter("modal"));
	String dialogTop						= checkForNull(request.getParameter("dialogTop"));
	String module							= checkForNull(request.getParameter("module"));
	String model_window						= checkForNull(request.getParameter("model_window"));
	String function_id						= checkForNull(request.getParameter("function_id"));
	String prog_id							= checkForNull(request.getParameter("prog_id"));
	String practitioner_id					= checkForNull(request.getParameter("practitioner_id"));
	String bed_block_period_max_str			= checkForNull(request.getParameter("bed_block_period_max_int"));
	int bed_block_period_max_int			= 0;
	if(! bed_block_period_max_str.equals(""))
		bed_block_period_max_int			= Integer.parseInt(bed_block_period_max_str);
	
	String strPri1		= "";
	String strDftUnts1	= "";
%>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
	<Script src="../../eIP/js/IPPractitionerComponent.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<script>

function compareDates(Obj)
{
	if(validDateObj(Obj,"DMY",localeName))
	{
		if(document.forms[0].from_date.value !='' && document.forms[0].to_date.value !='')// DateUtils.js
		{
			var fromDt = convertDate(document.forms[0].from_date.value,"DMY",localeName,"en");
			var toDt = convertDate(document.forms[0].to_date.value,"DMY",localeName,"en");

			//if(isAfter(fromDt,toDt,'DMY',localeName))
			if(isAfter(fromDt,toDt,'DMY',"en"))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].to_date.select();
			}
		}
	}
}

function BeforeGetPractitioner(obj, target, details)
{
	if(details == 'from')
	{
		if(document.forms[0].from_practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].from_practid.value =""
	}
	else if(details == 'to')
	{
		if(document.forms[0].practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].practid.value =""
	}
}

function getPractitionerLocal(obj, target, details)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";

	practName_FName=target.name;
	practName_FValue=target.value;
	if(details == 'from')
		practId_FName=document.forms[0].from_practid.name;
	else
		practId_FName=document.forms[0].practid.name;

	var	locale = document.forms[0].locale.value;
	var facility_id		= "<%=facility_id%>";

	getPractitioner(obj, target, facility_id, "","","Q2");

	/*
	
	var sql = " select A.PRACTITIONER_ID PRACTITIONER_ID , am_get_desc.AM_PRACTITIONER(b.PRACTITIONER_ID,'"+locale+"',1) PRACTITIONER_NAME ,am_get_desc.AM_PRACT_TYPE(b.PRACT_TYPE,'"+locale+"',2) PRACTITIONER_TYPE ,am_get_desc.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,'"+locale+"',2 ) PRIMARY_SPECIALTY , DECODE(B.GENDER,'M','Male','F','Female','U','Unknown') GENDER , am_get_desc.AM_POSITION(b.position_code,'"+locale+"',1) JOB_TITLE from AM_PRACT_FOR_FACILITY A , AM_PRACTITIONER B where A.PRACTITIONER_ID = B.PRACTITIONER_ID and B.PRACT_TYPE LIKE (?) and B.PRIMARY_SPECIALITY_CODE LIKE UPPER(?) and (UPPER(B.PRACTITIONER_ID) LIKE UPPER(NVL(?,B.PRACTITIONER_ID)) or UPPER(am_get_desc.AM_PRACTITIONER(b.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER(NVL(?,B.PRACTITIONER_NAME)) ) and B.GENDER LIKE (?) and ( b.POSITION_CODE LIKE (?) or b.POSITION_CODE is NULL ) and A.FACILITY_ID= '"+facility_id+"' ";
	
	var sql2 = " select A.PRACTITIONER_ID PRACTITIONER_ID , am_get_desc.AM_PRACTITIONER(b.PRACTITIONER_ID,'"+locale+"',1) PRACTITIONER_NAME ,am_get_desc.AM_PRACT_TYPE(b.PRACT_TYPE,'"+locale+"',2) PRACTITIONER_TYPE ,am_get_desc.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,'"+locale+"',2 ) PRIMARY_SPECIALTY , DECODE(B.GENDER,'M','Male','F','Female','U','Unknown') GENDER , am_get_desc.AM_POSITION(b.position_code,'"+locale+"',1) JOB_TITLE from AM_PRACT_FOR_FACILITY A , AM_PRACTITIONER B where A.PRACTITIONER_ID = B.PRACTITIONER_ID and B.PRACT_TYPE LIKE (?) and B.PRIMARY_SPECIALITY_CODE LIKE UPPER(?) and (UPPER(B.PRACTITIONER_ID) LIKE UPPER(NVL(?,B.PRACTITIONER_ID)) or UPPER(am_get_desc.AM_PRACTITIONER(b.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER(NVL(?,B.PRACTITIONER_NAME)) ) and B.GENDER LIKE (?) and ( b.POSITION_CODE LIKE (?) or b.POSITION_CODE is NULL ) and A.FACILITY_ID= '"+facility_id+"' ";


	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc.loadXML( xmlStr );
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	

	*/
} // End of getPractitioner.

// To be called by the GeneralPractitionerSearch to set Practitioner.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName == "from_practid_desc")
		{
			document.forms[0].from_practid.value=arr[0];
			document.forms[0].from_practid_desc.value=arr[1];			
		}
		else
		{
			document.forms[0].practid.value=arr[0];
			document.forms[0].practid_desc.value=arr[1];			
		}
	}
	else
	{
		if(objName == "from_practid_desc")
		{
			document.forms[0].from_practid.value="";
			document.forms[0].from_practid_desc.value="";			
		}
		else
		{
			document.forms[0].practid.value="";
			document.forms[0].practid_desc.value="";			
		}
	}

}

	function OffsetDate(sysdatetime,strPri1,strDftUnts1)
	{
		//we are taking the sysdate to get the current time...cause the local machine may have a wrong time setting ...so we may not want to depend on the local time setiings...on the better side we save time with the local Date() object of JS.. 
		var result = "";
		var days= strPri1;
		if(days!='')
		{
			var sysdate = sysdatetime.substring(0,10);
			var systime = sysdatetime.substring(11,16);
			//building current date object from sysdate to avoid local machine date setting errors
			var dateArray = sysdate.split("/");
			sysdate1=dateArray[1]+"/"+dateArray[0]+"/"+dateArray[2]
			var tempdate = Date.parse(sysdate1);
			var currentDate=new Date(tempdate);
			var timeArray = systime.split(":");
			systime1=dateArray[1]+"/"+dateArray[0]+"/"+dateArray[2]+" "+timeArray[0]+":"+timeArray[1]
			var tempdatetime = Date.parse(systime1);
			var currentDateTime=new Date(tempdatetime);
			var dwm = strDftUnts1;
			var currentMonth=currentDate.getMonth();
			var presentDate=currentDate.getDate();
			var presentTime=currentDateTime.getHours();
			var finaldate;
			if(dwm=='D')
			{
				finaldate=presentDate-eval(days);
				currentDate.setDate(finaldate);
				result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
			}
			else if(dwm=='W')
			{
				finaldate=presentDate-eval(days*7);
				currentDate.setDate(finaldate);
				result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
			}
			else if(dwm=='H') 
			{
				finaldate=presentTime-eval(days);
				currentDateTime.setHours(finaldate);
				result = currentDateTime.getDate()+"/"+eval(currentDateTime.getMonth()+1)+"/"+currentDateTime.getFullYear()+" "+currentDateTime.getHours()+":"+currentDateTime.getMinutes();
			}
			else
			{
				currentDate.setMonth(eval(currentMonth+eval(days)));
				result = currentDate.getDate()+"/"+eval(currentDate.getMonth()+1)+"/"+currentDate.getFullYear();
			}
			document.forms[0].pri_target1.value= result;
		}
		else
		{
			document.forms[0].pri_target1.value="";
		}
		return result;
	}

	function submitPage()
	{
		var systemdatetime = document.forms[0].sys_date_time.value;
		var strPri1 =  document.forms[0].pri_val.value.split("~");
		var strDftUnts1 =  document.forms[0].pri_unt.value.split("~");;
		var retValP2 = OffsetDate(systemdatetime,strPri1[0],strDftUnts1[0]);
		var retValP3 =OffsetDate(systemdatetime,strPri1[1],strDftUnts1[1]);
		document.forms[0].pri_target1.value = retValP2 +"~"+retValP3;
		   //Code changes starts by Srinivas YN For SRR20056-SCF-7177 [IN:027133] on 19/09/2011
		   var chk_status = document.getElementById('myCheckBox').status; 
       
		   if(chk_status==true)	
			{
			document.forms[0].loc_lang.value='th';
			}
			//Code changes ends by Srinivas YN For SRR20056-SCF-7177 [IN:027133] on 19/09/2011
		var condition=""
		for(var i=0; i<document.forms[0].elements.length; i++)
				condition+= document.forms[0].elements[i].name +"="+ document.forms[0].elements[i].value+"&"
		document.forms[0].search.disabled=true;
		
		if(document.forms[0].modal.value == 'yes')
			parent.frames[1].location.href= '../../eIP/jsp/IPLookupResultForAmendTrn.jsp?<%=request.getQueryString()%>&'+condition
		else
			parent.frames[2].location.href= '../../eIP/jsp/IPLookupResultForAmendTrn.jsp?<%=request.getQueryString()%>&'+condition	
	}

	function clearAll()
	{
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html'; 
		document.forms[0].search.disabled=false;
	}


	
	// Added by Sridhar on 3 FEB 2004
	// Function will check for empty values before calling up the common lookup func..
	function beforeGetSpecialty(aSpecialtID, Facility_ID, details)
	{
		if(details == 'from')
		{
			if(document.forms[0].from_Splcode_desc.value != "")
			{
				getSpecialty(aSpecialtID, Facility_ID, details)
			}
			else
			{
				document.forms[0].from_Splcode_desc.value="";
				document.forms[0].from_Splcode.value="";
			}
		}
		else if(details == 'to')
		{
			if(document.forms[0].Splcode_desc.value != "")
			{
				getSpecialty(aSpecialtID, Facility_ID,details)
			}
			else
			{
				document.forms[0].Splcode_desc.value="";
				document.forms[0].Splcode.value="";
			}
		}
	}

	function beforeGetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID, details)
	{
		if(details == 'from')
		{
			if(document.forms[0].from_nursing_unit_desc.value != "")
			{
				getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID, details)
			}
			else
			{
				document.forms[0].from_nursing_unit.value = "";
				document.forms[0].from_nursing_unit.value = "";
			}
		}
		else
		{
			if(document.forms[0].nursing_unit_desc.value != "")
			{
				getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID, details)
			}
			else
			{
				document.forms[0].to_nursing_unit.value = "";
				document.forms[0].nursing_unit.value = "";
			}
		}
	}


	// By Annadurai 2/7/2004 starts..
	// To get the nursing unit using CommonLookup.
	async function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID, details)
	{
		var nursingUnit = aNursingUnit.value;
		var facilityId	= aFacilityId;
		var loginUserId	= aLoginUser;
		var	operStnID	= pOperStnID;
		var call_function =document.forms[0].function_id.value;
		var tit			= getLabel("Common.nursingUnit.label","Common");
		var dialogHeight			= "60vh" ;
		var dialogWidth				= "50vw" ;
		var status					= "no";
		var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
		var arguments				= "" ;
		var retVal =    new String();
		
		var jsp_name = "";
		if(details == 'from')
		{
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnit)+"&login_user="+loginUserId+"&oper_id="+operStnID+"&title="+encodeURIComponent(tit)+"&facility_id="+facilityId+"&call_function="+call_function+"&open_location_yn=Y";
		}
		else
		{
			jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnit)+"&login_user="+loginUserId+"&oper_id="+operStnID+"&title="+encodeURIComponent(tit)+"&facility_id="+facilityId+"&call_function="+call_function;
		}

		var retVal =  await window.showModalDialog(jsp_name,arguments,features);
		var arr=new Array();

		if(retVal != null && retVal != "" )
		{
			arr=retVal.split("~");

			if(details == 'from')
			{
				if((aNursingUnit.name == "from_nursing_unit_lookup") || (aNursingUnit.name == "from_nursing_unit_desc"))
				{
					document.forms[0].from_nursing_unit.value		=	arr[0];
					document.forms[0].from_nursing_unit_desc.value	=	arr[1];
				}
				else if((aNursingUnit.name == "from_nursing_unit_to_lookup") || (aNursingUnit.name == "from_nursing_unit_to_desc"))
				{
					document.forms[0].from_to_nursing_unit.value			=	arr[0];
					document.forms[0].from_nursing_unit_to_desc.value	=	arr[1];
				}
			}
			else if(details == 'to')
			{
				if((aNursingUnit.name == "nursing_unit_lookup") || (aNursingUnit.name == "nursing_unit_desc"))
				{
					document.forms[0].nursing_unit.value		=	arr[0];
					document.forms[0].nursing_unit_desc.value	=	arr[1];
				}
				else if((aNursingUnit.name == "nursing_unit_to_lookup") || (aNursingUnit.name == "nursing_unit_to_desc"))
				{
					document.forms[0].to_nursing_unit.value			=	arr[0];
					document.forms[0].nursing_unit_to_desc.value	=	arr[1];
				}
			}
		}
		else
		{
			if(details == 'from')
			{
				if((aNursingUnit.name == "from_nursing_unit_lookup") || (aNursingUnit.name == "from_nursing_unit_desc"))
				{
					document.forms[0].from_nursing_unit_desc.value	= "";
					document.forms[0].from_nursing_unit.value		= "";
					document.forms[0].from_nursing_unit_desc.focus();
				}
				else if((aNursingUnit.name == "from_nursing_unit_to_lookup") || (aNursingUnit.name == "from_nursing_unit_to_desc"))
				{
					document.forms[0].from_nursing_unit_to_desc.value = "";
					document.forms[0].from_nursing_unit.value		 = "";
					document.forms[0].from_nursing_unit_to_desc.focus();
				}
			}
			else if(details == 'to')
			{
				if((aNursingUnit.name == "nursing_unit_lookup") || (aNursingUnit.name == "nursing_unit_desc"))
				{
					document.forms[0].nursing_unit_desc.value	= "";
					document.forms[0].nursing_unit.value		= "";
					document.forms[0].nursing_unit_desc.focus();
				}
				else if((aNursingUnit.name == "nursing_unit_to_lookup") || (aNursingUnit.name == "nursing_unit_to_desc"))
				{
					document.forms[0].nursing_unit_to_desc.value = "";
					document.forms[0].to_nursing_unit.value		 = "";
					document.forms[0].nursing_unit_to_desc.focus();
				}
			}
		}
	} // End of getNursingUnit().

	function compareFrom()
	{
		fromVal	=	document.forms[0].nursing_unit.value;
		toVal	=	document.forms[0].to_nursing_unit.value;
		if(fromVal != null && toVal != '')
		{
			if(toVal < fromVal)
			{
				alert(getMessage('TO_NRS_UT_GR_FR_NR_UT','IP'));
				document.forms[0].nursing_unit_to_desc.value='';
				document.forms[0].to_nursing_unit.value	='';
				document.forms[0].nursing_unit_to_lookup.focus();
			}
		}
	}

	// To get the specialty using CommonLookup.
	async function getSpecialty(aSpecialtID, Facility_ID, details)
	{
		var target			= "";
		var code			= "";
		if(details == 'from')
		{
			target			= document.forms[0].from_Splcode_desc;
		}
		else if(details == 'to')
		{
			target			= document.forms[0].Splcode_desc;
		}
		var FacilityID		= Facility_ID;
		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var locale = document.forms[0].locale.value;	

		sql = "Select speciality_code code,short_desc description from AM_SPECIALITY_LANG_VW where eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+locale+"' ";

		tit = getLabel("Common.speciality.label","Common");

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1, 2";
		argumentArray[5] = aSpecialtID.value;
		argumentArray[6] = CODE_DESC_LINK;
		argumentArray[7] = CODE_DESC;

		
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			if(details == 'from')
			{
				document.forms[0].from_Splcode.value=arr[0];
				document.forms[0].from_Splcode_desc.value=arr[1];
			}
			else if(details == 'to')
			{
				document.forms[0].Splcode.value=arr[0];
				document.forms[0].Splcode_desc.value=arr[1];
			}
		}
		else
		{
			if(details == 'from')
			{
				document.forms[0].from_Splcode_desc.value="";
				document.forms[0].from_Splcode.value="";
			}
			else if(details == 'to')
			{
				document.forms[0].Splcode_desc.value="";
				document.forms[0].Splcode.value="";
			}
		} 
	} 
</script>
<%
		Connection con	= null;
		Statement stmt	= null;
		ResultSet rs	= null;
		try
		{
			con = ConnectionManager.getConnection(request);
	
			strPri1="~";
			strDftUnts1="~";

		%>
	</head>
	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad='FocusFirstElement();' >
		<form name='Inpatientlookup_Form' id='Inpatientlookup_Form' action='../../eIP/jsp/BookingReferenceLookupResult.jsp' target='result' >
			<table cellspacing=0 cellpadding=3 align='center' width='100%' border='0'>

			<tr>
					<td class='label' width="25%"></td>
					<td class='querydata' colspan='1'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class='label' width="25%"></td>
					<td class='querydata' colspan='1'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					
			</tr>


			<tr>
				<td nowrap class='label' width='25%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			
				<td width='25%' class='fields' nowrap><input type=text name="from_nursing_unit_desc" id="from_nursing_unit_desc" maxlength=15 size=15 onblur="beforeGetNursingUnit(this,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>','from');" ><input type=button class=button name=from_nursing_unit_lookup value='?' onClick="getNursingUnit(from_nursing_unit_desc,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>','from')"><input type=hidden name="from_nursing_unit" id="from_nursing_unit"></td>


				<td  width='25%' class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					
				<td  width='25%' class='fields' ><input type=text name="nursing_unit_desc" id="nursing_unit_desc" maxlength=15 size=15 onblur="beforeGetNursingUnit(this,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>','to');" ><input type=button class=button name=nursing_unit_lookup value='?' onClick="getNursingUnit(nursing_unit_desc,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>','to')"><input type=hidden name="to_nursing_unit" id="to_nursing_unit"><input type=hidden name="nursing_unit" id="nursing_unit" ></td>
					
			</tr>
			
			<tr>
				
				<td  width='25%' class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
					
				
				<td  width='25%' class='fields'><input type=text name='from_Splcode_desc' id='from_Splcode_desc' maxlength=15 size=15 onblur="beforeGetSpecialty(this, '<%=facility_id%>','from');" ><input type=hidden name='from_Splcode' id='from_Splcode' ><input type=button name='from_Splcode_lookup' id='from_Splcode_lookup' value='?' class=button onClick="getSpecialty(from_Splcode_desc,'<%=facility_id%>','from');"></td>

				<td   width='25%' class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
					
				<td width='25%' class='fields'><input type=text name='Splcode_desc' id='Splcode_desc' maxlength=15 size=15 onblur="beforeGetSpecialty(this, '<%=facility_id%>','to');" ><input type=hidden name='Splcode' id='Splcode' ><input type=button name='Splcode_lookup' id='Splcode_lookup' value='?' class=button onClick="getSpecialty(Splcode_desc,'<%=facility_id%>','to');"></td>
					
			</tr>	

			<tr>
				<td  width='25%' class='label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					
				
				<td  width='25%' class='fields'><input type='text' name='from_practid_desc' id='from_practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].from_practid,from_practid_desc,'from');" value=""><input type='hidden' name='from_practid' id='from_practid' value="" size="15" maxlength="15" ><input type='button' name='from_pract_id_search' id='from_pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].from_practid,from_practid_desc,'from');"></td>

				<td   width='25%' class='label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					
				<td  width='25%' class='fields'><input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid,practid_desc,'to');" value=""><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid,practid_desc,'to');"></td>
			</tr>
		
			<tr>
				<td class='label' width='25%'><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
				<td width='25%' class='fields'>
				
				<input type='text' id="adm_date_from" maxlength='10' size='10' name='from_date' id='from_date'  value="" onBlur='compareDates(this);'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].adm_date_from.focus();return showCalendar('adm_date_from');"/> - <input type='text' id="adm_date_to" value="" maxlength='10' size='10' name='to_date' id='to_date' onBlur='compareDates(this);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].adm_date_to.focus();return showCalendar('adm_date_to',null);"/></td>
					
				<td class='label' width='25%' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
						
				<td width='25%' class='fields' nowrap><input type='text' maxlength='12' size='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0);" onBlur=" CheckNum(this);;"></td>
				</tr>
				<tr>
					<td  class='label' width='25%' nowrap><fmt:message key="eIP.TransferType.label" bundle="${ip_labels}"/></td>

					<td width='25%' class='fields' nowrap><select name='transfer_type' id='transfer_type'><option value="">---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---
					<%
							StringBuffer sql = new StringBuffer();
							sql.append("select TRANSFER_TYPE_CODE,SHORT_DESC from ip_transfer_type_lang_vw where language_id='"+locale+"' and eff_status='E' order by SHORT_DESC ");
							stmt = con.createStatement();
							rs = stmt.executeQuery(sql.toString());
							if(rs!=null)
							{
								while( rs.next() )
								{
									String code = rs.getString("TRANSFER_TYPE_CODE");
									String desc = rs.getString("SHORT_DESC");
									out.print("<option value=\""+code+"\">"+desc);
								}
								if(rs!=null) rs.close();
								if(stmt!=null) stmt.close();
							}
					%>
					</select>
					</td>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				</table>
				<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
						<jsp:include page="IPPatientDetailCriteria.jsp" ><jsp:param name="flush" value="true" /></jsp:include>
				</table>
			<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
					<td align='right' class='white'>
						<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'>
						<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'>

					</td>
				</tr>
			</table>

		<input type='hidden' name='jsp_name' id='jsp_name' value='<%=jsp_name%>' >
		<input type='hidden' name='win_height' id='win_height' value='<%=win_height%>' >
		<input type='hidden' name='win_width' id='win_width' value='<%=win_width%>' >
		<input type='hidden' name='param' id='param' value='<%=call_function%>' >	
		<input type='hidden' name='dialogTop' id='dialogTop' value='<%=dialogTop%>' >
		<input type='hidden' name='modal' id='modal' value='<%=modal%>' >
		<input type='hidden' name='module' id='module' value='<%=module%>' >
		<input type='hidden' name='model_window' id='model_window' value='<%=model_window%>' >
		<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>' >
		<input type='hidden' name='call_function' id='call_function' value='<%=call_function%>' >
		<input type='hidden' name='prog_id' id='prog_id' value='<%=prog_id%>' >
		<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>' >
		<input type='hidden' name='sys_date_time' id='sys_date_time' value='<%=systemdatetime%>'>
		<input type='hidden' name='pri_val' id='pri_val' value='<%=strPri1%>'>
		<input type='hidden' name='pri_unt' id='pri_unt' value='<%=strDftUnts1%>'>
		<input type='hidden' name='pri_target1' id='pri_target1' value=''>
		<input type='hidden' name='operStation' id='operStation' value='<%=p_oper_stn_id%>'>

		<!-- // Added by Sridhar R on Mar 11 2005.. for passing parameters to result page...-->
		<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=p_oper_stn_id%>'>
		<input type='hidden' name='routine_tfr_yn' id='routine_tfr_yn' value='<%=routine_tfr_yn%>'>
		<input type='hidden' name='bed_block_period_max_int' id='bed_block_period_max_int' value='<%=bed_block_period_max_int%>'>
		<input type='hidden' name='sydate' id='sydate' value='<%=systemdatetime%>'>
		<input type='hidden' name='priority_applicable_yn' id='priority_applicable_yn' value='<%=priority_applicable_yn%>'>
		<input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='<%=change_bed_class_yn%>'>
		<input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='<%=deactivate_pseudo_bed_yn%>'>
		<input type='hidden' name='bl_interfaced_yn' id='bl_interfaced_yn' value='<%=bl_interfaced_yn%>'>
		<input type='hidden' name='bed_block_period_max_type' id='bed_block_period_max_type' value='<%=bed_block_period_max_type%>'>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>

		</form>
	</body>
<%	}catch(Exception e)
	{
		out.println(" Exception in tryCatch in IPLookupCriteriaForAmendTrn.jsp : "+e);
	}
	finally
	{
		if(stmt != null)stmt.close();
		if(rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}

%>

