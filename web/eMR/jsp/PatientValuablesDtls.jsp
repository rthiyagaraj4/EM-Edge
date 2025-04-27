<!DOCTYPE html>
<%
/**
	@Function used to Record patient Valueables from MR/IP/AE/OP modules...
	@Author - Sridhar R 
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.ConnectionManager, java.sql.*, java.util.*,com.ehis.util.*,java.text.*,eCommon.XSSRequestWrapper" %>
<script>

function chkDateVal(obj)
{
	if(obj.value != '' )
	{
		if(!doDateTimeChk(obj))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'));
			obj.value = "";
			obj.focus();
			return;
		}
	}
}
function checkFromDate(obj)
{
	if(validDateObj(obj,'DMYHM',localeName))
	{
		var next_exe_date = convertDate(obj.value,'DMYHM',localeName,'en');
		var sysdate1 = convertDate(document.forms[0].recordedTime.value,'DMYHM',localeName,'en');
		if(!isAfter(next_exe_date,sysdate1,'DMYHM','en'))
		{
			var error=getMessage("MRDATE1_LT_DATE2",'MR');
			error = error.replace('$', getLabel("Common.returndatetime.label","Common"));
			error = error.replace('#', getLabel("Common.recordeddatetime.label","Common"));
			alert(error);
			obj.value = '';
			obj.focus();
			obj.select();
			return false;
		}
		else if(!isBeforeNow(next_exe_date,'DMYHM','en'))
		{
			var error=getMessage("MRDATE1_GT_DATE2",'MR');
			error = error.replace('$', getLabel("Common.returndatetime.label","Common"));
			error = error.replace('#', getLabel("Common.SystemDate.label","Common"));
			alert(error);
			obj.value = '';
			obj.focus();
			obj.select();
			return false;
		}
	}
}


function callReturned_chk(obj)
{
  if(obj.checked==true)
	{
	  obj.value="Y";
			document.forms[0].returnedby_desc.disabled  =false;
			document.forms[0].button1.disabled			=false;
			document.forms[0].returnedby.disabled		=false;

			document.forms[0].witness_desc.disabled		=false;
			document.forms[0].button2.disabled			=false;
			document.forms[0].witnessid.disabled		=false;

			document.forms[0].returned_datetime.disabled=false;
			document.getElementById("rel_img").disabled					=false;
		    document.getElementById("mand_gif1").style.visibility  = "visible";
		    document.getElementById("mand_gif2").style.visibility  = "visible";
		    document.getElementById("mand_gif3").style.visibility  = "visible";
	}
  else
	{
	  obj.value="N";
	        document.forms[0].returnedby_desc.disabled  =true;
			document.forms[0].button1.disabled			=true;
			document.forms[0].returnedby.disabled		=true;

			document.forms[0].witness_desc.disabled		=true;
			document.forms[0].button2.disabled			=true;
			document.forms[0].witnessid.disabled		=true;

			document.forms[0].returned_datetime.disabled=true;
			document.getElementById("rel_img").disabled					=true;

			document.forms[0].returnedby_desc.value='';
            document.forms[0].returnedby.value='';
			if(document.forms[0].witness_id.value == '')
			{
				document.forms[0].witness_desc.value='';
				document.forms[0].witnessid.value='';
			}
			document.forms[0].returned_datetime.value='';


	    document.getElementById("mand_gif1").style.visibility = "hidden";
		document.getElementById("mand_gif2").style.visibility = "hidden";
		document.getElementById("mand_gif3").style.visibility = "hidden";
	}
}

async function callReturnby()
{
	
	var locale=document.forms[0].locale.value;
	var val_txt=document.forms[0].returnedby_desc.value
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	tit=getLabel("Common.returnedby.label","Common");
	//sql="select appl_user_id code,appl_user_name description  from sm_appl_user where upper(appl_user_name)  like upper(?) and upper(appl_user_id ) like upper(?)";
	sql="select appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where upper(appl_user_id)  like upper(?) and upper(appl_user_name) like upper(?) and language_id='"+locale+"' and eff_status='E' ";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = val_txt;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit,argumentArray);
	if(retVal != null && retVal != "" )
			{
		var ret1=unescape(retVal);
		
		arr=ret1.split(",");
		document.forms[0].returnedby_desc.value=arr[1];
		document.forms[0].returnedby.value=arr[0];
		//alert("returnedby value in mr==="+document.forms[0].returnedby.value);
	}
}


async function callwitness()
{
	var locale=document.forms[0].locale.value;
	var val_txt=document.forms[0].witness_desc.value
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.returned.label","Common")+" "+getLabel("Common.Witness.label","Common");

	sql="select appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where UPPER(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) and language_id='"+locale+"' and eff_status='E' ";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = val_txt;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit,argumentArray);
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		
		arr=ret1.split(",");
		document.forms[0].witness_desc.value=arr[1];
		document.forms[0].witnessid.value=arr[0];
	
		 
	}
}


function getPractitionerId(obj,target)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";

	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName	= document.forms[0].witnessid.name;

	var facility_id	= document.forms[0].facilityId.value;

	getPractitioner(obj, target,facility_id,"Q2");

	/*
	var sql = "Select a.practitioner_id practitioner_id,a.practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title from am_pract_for_facility_vw a, am_practitioner b, am_pract_type d, am_speciality e  WHERE a.practitioner_id = b.practitioner_id and b.primary_speciality_code = e.speciality_code and  b.pract_type = d.pract_type and b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR   UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL) AND operating_facility_id= '"+facility_id+"'";
	var sql2 = "Select a.practitioner_id practitioner_id,a.practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title from am_pract_for_facility_vw a, am_practitioner b, am_pract_type d, am_speciality e  WHERE a.practitioner_id = b.practitioner_id and b.primary_speciality_code = e.speciality_code and  b.pract_type = d.pract_type and b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND   UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL) AND operating_facility_id= '"+facility_id+"'";

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
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	

	*/



} // End of getPractitioner();

// To set the values to Attending Practitioner when using  
// GeneralPratitionerLookup. It'll be called by the GeneralPratitionerLookup.
function PractLookupRetVal(retVal,objName)
{
	var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].witnessid.value=arr[0];
			document.forms[0].witness_desc.value=arr[1];			
		}
		else
		{
			document.forms[0].witnessid.value="";
			document.forms[0].witness_desc.value="";			
			document.forms[0].witness_desc.focus();
		}
		
} // End of PractLookupRetVal().

async function receivedcallwitness()
{
	var locale=document.forms[0].locale.value;
	var val_txt=document.forms[0].received_witness_desc.value	
		
	
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.received.label","Common")+" "+ getLabel("Common.Witness.label","Common");

	sql="select appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where UPPER(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) and language_id='"+locale+"' and eff_status='E' ";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = val_txt;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit,argumentArray);
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		
		arr=ret1.split(",");
		document.forms[0].received_witness_desc.value=arr[1];
		document.forms[0].received_witnessid.value=arr[0];		

	}
}
</script>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_Id	= (String)session.getValue("facility_id");
	String loginUser	= (String)session.getValue("login_user");
	String locale       = (String)session.getAttribute("LOCALE"); 
	String patientId	= checkForNull(request.getParameter("patientId"));
	String locn_code	= checkForNull(request.getParameter("locn_code"));
	String splty_code	= checkForNull(request.getParameter("splty_code"));
	String encounterId	= checkForNull(request.getParameter("encounterId"));
	String call_function= checkForNull(request.getParameter("call_function"));
//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	Connection con			= null;
	ResultSet rset			= null;
	ResultSet rs			= null;
	PreparedStatement pstmt	= null;
	String recorded_By		= ""; 
	String recorded_Date	= "";
	String remarks			= "";
	String witness_id		= "";
	String sysdate			= "";
	String function			= "";
	String practitioner_name= "";
	String returned_yn		= ""; 
	String returned_date	= "";
	String returned_id		= "";
	String returned_user_name="";
	String chk_attribute     = "";
	String sysdate_display	 = "";
	String dualdate			= "";
	String returned_date_display ="";
	String chk_enable		="";
	String chk_value		= "";
	String sysdate12        = "";
	String chk_returned_yn  = "";
	String witness_name     = "";
	//Added for this CRF HSA-CRF-0222 [IN:050567]
	String received_witness_id="";
    String received_witness_name="";
    String received_pract_name="";
	String received_pract_diabled = "";
	String witness_pass_validate_yn="";
	
	//int countRec = 0; 
  
	try 
    {
		con = ConnectionManager.getConnection(request);
		
		/*Below line added for this CRF HSA-CRF-0222 [IN:050567]*/
		pstmt = con.prepareStatement("select witness_pass_validate_yn from MR_PARAMETER");
		rset = pstmt.executeQuery();
	    if(rset!=null && rset.next()) {
	    witness_pass_validate_yn=checkForNull(rset.getString("witness_pass_validate_yn"),"N");
		}
		if(rset!=null)rset.close();	
	    if(pstmt!=null)pstmt.close();
		/*End this CRF HSA-CRF-0222 [IN:050567]*/
		
		//StringBuffer sql = new StringBuffer("Select added_by_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate, returned_yn,to_char(returned_date,'dd/mm/yyyy hh24:mi') returned_date,RETURNED_BY_ID, to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, valuable_details, witness_id from PR_PATIENT_VALUABLES where encounter_id=? and patient_id=? and facility_id=? ");   
		/*Monday, May 03, 2010 , SRR20056-SCF-4436-IN021088 ,*/
		//Modified for this CRF CRF HSA-CRF-0222 [IN:050567]
		StringBuffer sql = new StringBuffer("Select added_by_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate, returned_yn,to_char(returned_date,'dd/mm/yyyy hh24:mi') returned_date,returned_by_id,sm_get_desc.sm_appl_user(returned_by_id,?,1) return_by_name , to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, valuable_details, witness_id , sm_get_desc.sm_appl_user(witness_id,?,1) witness_name ,am_get_desc.am_practitioner(witness_id,?,1) pract_name, received_witness_id, sm_get_desc.sm_appl_user(received_witness_id,?,1) received_witness_name, am_get_desc.am_practitioner(received_witness_id,?,1) received_pract_name  from PR_PATIENT_VALUABLES where encounter_id=? and patient_id=? and facility_id=? ");  
        
	 	//pstmt=con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 pstmt=con.prepareStatement(sql.toString());
         pstmt.setString(1,locale);
         pstmt.setString(2,locale);
         pstmt.setString(3,locale);
		 pstmt.setString(4,locale);
		 pstmt.setString(5,locale);
         pstmt.setString(6,encounterId);
		 pstmt.setString(7,patientId);
		 pstmt.setString(8,facility_Id);
		 rs	 = pstmt.executeQuery();
         /*if(rs != null){
			rs.last();
			countRec = rs.getRow();
            rs.beforeFirst();
		}*/
		/*if(countRec > 0) function = "modify";
		else function = "insert";*/
		
		if(rs.next()) 
		{
			sysdate12		= rs.getString("sdate");
			recorded_By		= checkForNull(rs.getString("ADDED_BY_ID"));
			recorded_Date	= checkForNull(rs.getString("ADDED_DATE"));
			remarks			= checkForNull(rs.getString("VALUABLE_DETAILS"));
			witness_id		= checkForNull(rs.getString("witness_id"));
			witness_name	= checkForNull(rs.getString("witness_name"));
			practitioner_name= checkForNull(rs.getString("pract_name"));
			//if(practitioner_name.equals(""))
			//	practitioner_name = witness_name;
			
			returned_yn		= checkForNull(rs.getString("returned_yn"));
			returned_date   = checkForNull(rs.getString("returned_date"));
			returned_id		= checkForNull(rs.getString("returned_by_id"));
			returned_user_name= checkForNull(rs.getString("return_by_name"));
			//Added for this CRF CRF HSA-CRF-0222 [IN:050567]
			received_witness_id= checkForNull(rs.getString("received_witness_id"));
            received_witness_name= checkForNull(rs.getString("received_witness_name"));
            //received_pract_name= checkForNull(rs.getString("received_pract_name"));
			//if(received_pract_name.equals(""))received_pract_name = received_witness_name;
			if(!received_witness_name.equals("")) received_pract_diabled="disabled";			
			
			//End CRF HSA-CRF-0222 [IN:050567]
			
			
			function		= "modify";
			
		} 
		else
		{
			function		= "insert";
		}

		
	if(pstmt!=null)pstmt.close();
	if(remarks.equals("") && returned_yn.equals(""))
	{
		chk_returned_yn="disabled";
	}

	else if(returned_yn.equals("Y"))
       chk_returned_yn="disabled";
	
	if(returned_yn.equals("Y"))
	{
		chk_attribute="checked";
		chk_enable="disabled";
		chk_value="Y";
	}
	else
	{
       chk_attribute= "";
	   chk_enable  = "";
	   chk_value="N";
	}
	
	SimpleDateFormat dateFormatTime = new SimpleDateFormat( "dd/MM/yyyy hh:mm" ) ;
	sysdate	= dateFormatTime.format(new java.util.Date()) ;  
	sysdate_display = DateUtils.convertDate(sysdate,"DMYHM","en",locale);
	if(returned_date.equals(""))
		returned_date_display = "";
	else
		returned_date_display = DateUtils.convertDate(returned_date,"DMYHM","en",locale);
	if(recorded_Date != null || recorded_Date != "")
	{
		sysdate_display = DateUtils.convertDate(recorded_Date,"DMYHM","en",locale);
	}
	 if(recorded_By != null && recorded_By != "")
       loginUser = recorded_By;
   	
	if(remarks == null) remarks="";
	//pstmt = con.prepareStatement("select appl_user_name from sm_appl_user where appl_user_id = '"+returned_id+"'");
	/*Monday, May 03, 2010 , SRR20056-SCF-4436-IN021088 ,*/
	/*
	if(!witness_id.equals("") && returned_id.equals(""))
	{
		pstmt = con.prepareStatement("select appl_user_name, to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from SM_APPL_USER_LANG_VW where appl_user_id = '"+witness_id+"' AND language_id='"+locale+"'");
		String str="select appl_user_name, to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from SM_APPL_USER_LANG_VW where appl_user_id = '"+witness_id+"' AND language_id='"+locale+"'";
	}else{

		pstmt = con.prepareStatement("select appl_user_name, to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from SM_APPL_USER_LANG_VW where appl_user_id = '"+returned_id+"' AND language_id='"+locale+"'");
		
		String str2="select appl_user_name, to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from SM_APPL_USER_LANG_VW where appl_user_id = '"+returned_id+"' AND language_id='"+locale+"'";
	}
	rset = pstmt.executeQuery();
	if(rset.next())
	{
		
		if(sysdate == null)
		{
			sysdate = "";
			sysdate_display = "";
		}
		else
			sysdate_display = DateUtils.convertDate(sysdate,"DMYHM","en",locale);

		if(!witness_id.equals("")){
			practitioner_name = rset.getString(1);
		out.println("practitioner_name====="+practitioner_name);
		}


		if(!returned_id.equals("")){
			returned_user_name = rset.getString(1);
	out.println("returned_user_name====="+returned_user_name);
		}
	}
	
	if(rset!=null)rset.close();	
	if(pstmt!=null)pstmt.close();
	

   
	
	
		if(recorded_Date == null || recorded_Date == "")
		{
			if(rset!=null)rset.close();	
			if(pstmt!=null)pstmt.close();
			pstmt = con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from dual");
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				dualdate = rset.getString(1);
			}

			if(rset!=null)rset.close();	
			if(pstmt!=null)pstmt.close();

			sysdate_display = DateUtils.convertDate(dualdate,"DMYHM","en",locale);
		}
		else
		{
			sysdate_display = DateUtils.convertDate(recorded_Date,"DMYHM","en",locale);
		}
	*/
	}catch(Exception e) {/* out.println(e.toString()); */ e.printStackTrace();}
    finally
    {
		//if (rs != null) rset.close();
        ConnectionManager.returnConnection(con,request);
	}
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
    <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eMR/js/PatientValuables.js' language='javascript'></script>  
	<script src='../../eMR/js/MRPractitionerComponent.js' language='javascript'></script>  
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	
</head>
<script>

function checkForNull(inString)
{
	return (trimCheck(inString))	?	inString	:	"";
}

function CloseWin()
{
	parent.parent.document.getElementById("dialog_tag").close();

}


</script>

<body onKeyDown="lockKey()">
	<form name='PatientValuables' id='PatientValuables' method="POST" action='../../servlet/eMR.PatientValuablesServlet'> 
	<table border=0 cellspacing=0 cellpadding=3 width='100%'>
	<!--Below lines removed by  munisekhar  for IN35532 on Thursday, Oct 04, 2012  --->
		
		<tr>
			<td width="25%" class='label' ><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></td>
			<td width="25%" class='fields'><input type=text name="recordedBy" id="recordedBy" size="20" maxLength='20' readonly value="<%= loginUser%>"></td>
			<td width="25%" class='label'  ><fmt:message key="Common.recordeddatetime.label" bundle="${common_labels}"/></td>
			<td width="25%" class='fields'><INPUT TYPE="text" name="recordedTime" id="recordedTime" size="16" maxlength="16"  value="<%=sysdate_display%>" readonly ></td>
		</tr>
		<tr>
			<td class='label' scope="session" ><fmt:message key="Common.PatientValuables.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan=3><textarea style="resize:none" name="remarks" <%=chk_enable%> rows=10 cols=80 maxLength='2000' 
			><%=remarks%></textarea><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>  
<%	if(!call_function.equals("MR_REC_PAT_VAL"))
	{	%>
		<tr>
			<td class='label'  scope="session"><fmt:message key="Common.Witness.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='witness_desc' id='witness_desc' value="<%=witness_name%>" size='25' maxlength='30' onChange="getPractitionerId(witnessid, this); "><input type='hidden' name='witnessid' id='witnessid' value=""><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerId(witnessid, witness_desc);"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>
<%	}
	else if(call_function.equals("MR_REC_PAT_VAL"))
	{	%>
	   <!--Below line Added for this CRF HSA-CRF-0222 [IN:050567] -->
	   <tr>
			<td class='label'><fmt:message key="Common.received.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Witness.label" bundle="${common_labels}"/></td>
			<%-- <td class='fields' >
				<INPUT TYPE="text" value="<%=received_witness_name%>" onBlur="if(this.value !='')receivedcallwitness();" maxlength='30' size="30" NAME="received_witness_desc" <%=received_pract_diabled%> <% if("disabled".equals(received_pract_diabled))%> style="background-color: #e0e0e0; color: #a0a0a0; cursor: not-allowed;">
				<input type="button"  onclick="receivedcallwitness();"  class=button value="?" <%=received_pract_diabled%>>
				<INPUT TYPE="hidden" name="received_witnessid" id="received_witnessid" value="<%=received_witness_id%>">
				<img src='../../eMP/images/mandatory.gif' >
			</td> --%>
			
			<td class='fields'>
			    <input 
			        type="text" 
			        value="<%=received_witness_name%>" 
			        onBlur="if(this.value != '') receivedcallwitness();" 
			        maxlength="30" 
			        size="30" 
			        name="received_witness_desc" 
			        <%=received_pract_diabled%> 
			        <% if("disabled".equals(received_pract_diabled)) { %>
			            style="background-color: #e0e0e0; color: #a0a0a0; cursor: not-allowed;"
			        <% } %>>
			    <input 
			        type="button" 
			        onclick="receivedcallwitness();"  
			        class="button" 
			        value="?" 
			        <%=received_pract_diabled%>>
			    <input 
			        type="hidden" 
			        name="received_witnessid" 
			        id="received_witnessid" 
			        value="<%=received_witness_id%>">
			    <img src='../../eMP/images/mandatory.gif'>
			</td>
			
			<td colspan='2'>&nbsp;</td>
			
	   <!--End HSA-CRF-0222 [IN:050567] -->
		<tr>
			<td class='label'><fmt:message key="Common.returned.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="checkbox"  value="<%=chk_value%>"   <%=chk_attribute%> <%=chk_returned_yn%> name="returned" onclick="callReturned_chk(this);"></td>
			<td class='label' ><fmt:message key="Common.returndatetime.label" bundle="${common_labels}"/></td>
			<td class='fields' >
			<!-- Below line is commented by Akhilesh because unnecessary function called. -->
			<!--<input type='text' size="14" disabled maxlength="17" onBlur="checkFromDate(this);chkDateVal(this);" name='returned_datetime' id='returned_datetime' id="startlater" value="<%=returned_date%>" <%=chk_enable%> >-->
			<input type='text' size="14" disabled maxlength="17" onBlur="checkFromDate(this);" name='returned_datetime' id='returned_datetime' id="startlater" value="<%=returned_date_display%>" <%=chk_enable%>><img id='rel_img' name="date_picker" <%=chk_enable%> disabled  name="calendertime"   src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].returned_datetime.focus(); return showCalendar('returned_datetime',null,'hh:mm');"/><img src='../../eMP/images/mandatory.gif' style="visibility:hidden" id='mand_gif3'></td>
		</tr>
		<tr> <!--Below line modified for this CRF HSA-CRF-0222 [IN:050567] --> 
			<td class='label' ><fmt:message key="Common.returnedby.label" bundle="${common_labels}"/></td>
			<td class='fields' ><INPUT TYPE="text" onBlur="if(this.value !='')callReturnby();" value="<%=returned_user_name%>" <%=chk_enable%> disabled NAME="returnedby_desc" maxlength='30' size="30"><input type="button" disabled class=button name="button1" id="button1" onclick="callReturnby();" value="?"><img src='../../eMP/images/mandatory.gif'  style="visibility:hidden" id='mand_gif1'> <INPUT TYPE="hidden" name="returnedby" id="returnedby" value="<%=returned_id%>" >
			<td class='label' ><fmt:message key="Common.returned.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Witness.label" bundle="${common_labels}"/> </td>
			<td class='fields' ><INPUT TYPE="text" disabled value="<%=witness_name%>" <%=chk_enable%>  onBlur="if(this.value !='')callwitness();" maxlength='30' size="30" NAME="witness_desc" ><input type="button" disabled onclick="callwitness();" name="button2" id="button2" class=button value="?"><INPUT TYPE="hidden" name="witnessid" id="witnessid" value="<%=witness_id%>"><img src='../../eMP/images/mandatory.gif' style="visibility:hidden" id='mand_gif2'></td>
<%	}	%>
		<tr><td colspan='4' class="label">&nbsp;</td></tr>
		<tr style="text-align: right;">
			<td colspan = '4' class='button' ><input type='button' class='button' name='record' id='record' <%=chk_enable%> value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onClick='callRecord(this);'><input type='button' class='button' name='close' id='close' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick='CloseWin();'></td>
		</tr>
		<tr><td colspan='4' class="label">&nbsp;</td></tr>
		</table>
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facility_Id%>">
		<input type='hidden' name='patientId' id='patientId' value="<%=patientId%>">
		<input type='hidden' name='encounterId' id='encounterId' value="<%=encounterId%>">
		<input type='hidden' name='functions' id='functions' value="<%=function%>">
		<input type='hidden' name='nursing_unit' id='nursing_unit' value="<%=locn_code%>">
		<input type='hidden' name='splity_code' id='splity_code' value="<%=splty_code%>">	
		<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>">
		<input type='hidden' name='systemdate' id='systemdate' value="<%=sysdate12%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		<input type='hidden' name='witness_id' id='witness_id' value="<%=witness_id%>">
		<!--below line added for this CRF HSA-CRF-0222 -->
		<input type='hidden' name='witness_pass_validate_check' id='witness_pass_validate_check' value="<%=witness_pass_validate_yn%>">
	</form>
 </body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

