<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, java.sql.*, webbeans.eCommon.*,eCommon.Common.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String facility_id="", user_id="", fs_locn_code="", fs_locn_desc="", user_security_yn="";
	String user_name="";
	
	Connection con	=	null;
	Statement stmt	= null;
	ResultSet rs	= null;
	Statement stmt2		= null;
	ResultSet rs2		= null;
	String mysql		= "";	
	String sys_date		= "";
	String user_security_yn_old="";
	String sys_date_old="";
	String user_name_old="";
	try 
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		user_id		=	(String)session.getValue("login_user");
		Boolean isStartAndEndTimeAvailable 	 = CommonBean.isSiteSpecific(con, "FM","PULLING_LIST_START_END_TIME");/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014*/
		
		String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
		stmt		=	con.createStatement();

       user_security_yn_old=(String)session.getAttribute("user_security_yn");
		sys_date_old         = (String)session.getAttribute("sys_date");
		
		
		if(user_security_yn_old == null || user_security_yn_old.equals("null"))user_security_yn_old="";
		
		if(sys_date_old == null || sys_date_old.equals("null")) sys_date_old="";
		
		if(sys_date_old.equals("") || user_security_yn_old.equals("") )
		{
		String fm_param_query="select user_security_yn,  to_char(SYSDATE+nvl(NO_DAYS_CHECK_APPT_INQUIRY,1),'DD/MM/YYYY') SYDATE from fm_parameter where facility_id='"+facility_id+"'";
		

		rs = stmt.executeQuery(fm_param_query);
		if(rs.next())
		{
			user_security_yn = rs.getString("user_security_yn");
			sys_date		 = rs.getString("SYDATE");
			
		}
		sys_date=DateUtils.convertDate(sys_date,"DMY","en",localeName);
		if(rs != null)		rs.close();
		if(stmt != null)	stmt.close();

		if(user_security_yn == null || user_security_yn.equals("null"))user_security_yn="N";
       session.setAttribute("user_security_yn",user_security_yn);
		session.setAttribute("sys_date",sys_date);
		
		}else{

           user_security_yn=user_security_yn_old;
             sys_date=sys_date_old;
		}
		
		
		
		String fs_locn_query = "";
		//fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
		fs_locn_query="SELECT fs_Locn_Code,fm_Get_desc.Fm_storage_locn(FACILITY_ID,fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc FROM FM_STORAGE_LOCN WHERE Facility_Id = '"+facility_id+"'  AND   PERMANENT_FILE_AREA_YN = 'Y'  AND  eff_Status = 'E'   ORDER BY 2";
		if(user_security_yn.equals("Y"))
		{			

			if (!access_all.equals("*ALL"))
			{
			//fs_locn_query="SELECT fs_locn_code, fs_locn_short_desc fs_locn_desc FROM fm_user_access_rights_vw WHERE facility_id = '"+facility_id+"' AND appl_user_id='"+user_id+"'  AND TRACK_OUT_TO_OPD='Y' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
			fs_locn_query="SELECT A.FS_LOCN_CODE,  (CASE   WHEN A.FS_LOCN_CODE = '*ALL' THEN '*ALL'  ELSE B.SHORT_DESC  END) FS_LOCN_SHORT_DESC FROM   FM_USER_ACCESS_RIGHTS_VW A,  FM_STORAGE_LOCN_LANG_VW B WHERE A.FACILITY_ID = B.FACILITY_ID(+) AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+)  AND A.Facility_Id = '"+facility_id+"'  AND A.apPl_User_Id = '"+user_id+"'  AND B.LANGUAGE_ID='"+localeName+"'  AND a.PERMANENT_FILE_AREA_YN = 'Y' AND a.TRACK_OUT_TO_OPD = 'Y' ORDER BY 2";
			}
		}
		/*else
		{
			fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
		}*/
	%>
<html>
<head>
	<title></title>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
		
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMPractitionerComponent.js'></script>
	<script language='javascript' src='../../eFM/js/FMConfirmPullingList.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014 Start-->
	<script language='javascript'>
		function isValidTime(Obj) {
			var Value	= Obj.value;
			if(Value!=""){
				if(!(/^([0-1]?[0-9]|2[0-3]):([0-5][0-9])(:[0-5][0-9])?$/).test(Value) || Value.length!=5){
					var errors= getMessage("INVALID_TIME_FMT","SM");
					alert(errors);
					Obj.value='';
					Obj.focus();
				}
			}
			if(document.forms[0].end_time.value!="" && document.forms[0].start_time.value!=""){
				ChkTimeValidation(Obj);
			}
			
		}
		
		function ChkTimeValidation(Obj){
			var Todaydate = new Date(); 
			var Formatteddate = Todaydate.getDate() +"/" + Todaydate.getMonth() +"/" + Todaydate.getYear();
			var time1 = Formatteddate + " " + document.forms[0].start_time.value;
			var time2 = Formatteddate + " " + document.forms[0].end_time.value;
			var StartTime = new Date(time1);
			var EndTime = new Date(time2);
			var TimeDiff = EndTime.getTime() - StartTime.getTime();
			if(TimeDiff <= 0) {
				var message=getMessage("ED_TIME_LESS_EQL_ST_TIME","OA")+" "+document.forms[0].start_time.value;; 
				alert(message);
				document.forms[0].end_time.value="";
				document.forms[0].end_time.focus();
			}
		}
	
		function ChkTimeInput(fld, e){
		    var strCheck = ':0123456789';
			var whichCode = (window.Event) ? e.which : e.keyCode;
			if (whichCode == 13) return true; 
			var key = String.fromCharCode(whichCode);
			if (strCheck.indexOf(key) == -1) return false;
			if(key == ":" && fld.value.indexOf(key) != -1) return false;
		}

		function changeVal(obj)
		{
		document.forms[0].P_LOCATION_TYPE.value=obj.value;
		document.forms[0].fm_clinic_code.value='';
		document.forms[0].fm_clinic_desc.value='';
		if(obj.value !="")
		{
			if(document.forms[0].fm_clinic_desc.disabled == true)
				document.forms[0].fm_clinic_desc.disabled = false;
			if(document.forms[0].locn.disabled == true)
				document.forms[0].locn.disabled = false;
		}else
	{
    document.forms[0].fm_clinic_desc.disabled = true;
	document.forms[0].locn.disabled = true;
	}

	}

	async function searchCode(obj,target,obj1)
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
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"' and level_of_care_ind = 'A' and eff_status='E' and CARE_LOCN_TYPE_IND='"+p_location_type1+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
							
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{   
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"'  and level_of_care_ind = 'A' and eff_status='E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}				
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].fm_clinic_desc.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;

		retVal = await CommonLookup( tit, argumentArray );

		var arr=new Array();

		if(retVal != null && retVal != "" ) {	
			var retVal=unescape(retVal);
		    arr=retVal.split(",");
			document.forms[0].fm_clinic_desc.value=arr[1];
			document.forms[0].fm_clinic_code.value=arr[0];
		}
		else
		{
			document.forms[0].fm_clinic_desc.value="";
			document.forms[0].fm_clinic_code.value="";
		//	target.value='';
		}
}

function clearpatid()
{
	parent.frames[0].document.forms[0].patient_id.value='';
	parent.frames[0].document.getElementById("patientid1").onblur();
    parent.frames[0].document.forms[0].patient_id.focus();
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
async function callPractSearch(obj,target)
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
					var fm_pract_type = document.forms[0].fm_pract_type.value;
		
					//sql="SELECT  PRACTITIONER_ID practitioner_id  ,PRACTITIONER_NAME practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(primary_speciality_code,'"+localeName+"','2') primary_specialty  , POSITION_CODE job_title  ,gender gender  FROM  am_practitioner_lang_vw  WHERE pract_type =nvl('"+fm_pract_type+"',pract_type)   AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))   AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code))   AND   (  UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id))   OR UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name))  )   AND UPPER(gender) LIKE NVL(UPPER(?),UPPER(gender))   AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))   and language_id = '"+localeName+"' ORDER BY  PRACTITIONER_NAME ";

					//sql2="SELECT  PRACTITIONER_ID practitioner_id  ,PRACTITIONER_NAME practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(primary_speciality_code,'"+localeName+"','2') primary_specialty  ,POSITION_CODE  job_title  ,gender gender  FROM  am_practitioner_lang_vw  WHERE pract_type =nvl('"+fm_pract_type+"',pract_type)   AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))   AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code))   AND   (  UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id))   AND UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name))  )   AND UPPER(gender) LIKE NVL(UPPER(?),UPPER(gender))   AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))   and language_id = '"+localeName+"' ORDER BY  PRACTITIONER_NAME ";

					await getPractitioner_common(obj,target,fm_pract_type,"","Q1");
				}
				if(obj.name=="pract_id1")
				{
					var to_pract_type = document.forms[0].to_pract_type.value;
	
					// latest  sql="SELECT  PRACTITIONER_ID practitioner_id  ,PRACTITIONER_NAME practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(primary_speciality_code,'"+localeName+"','2') primary_specialty  ,POSITION_CODE job_title  ,gender gender  FROM  am_practitioner_lang_vw  WHERE pract_type =nvl('"+to_pract_type+"',pract_type)   AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))   AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code))   AND   (  UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id))   OR UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name))  )   AND UPPER(gender) LIKE NVL(UPPER(?),UPPER(gender)   AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))  and language_id = '"+localeName+"'  ORDER BY  PRACTITIONER_NAME ";
					
					// latest sql2="SELECT  PRACTITIONER_ID practitioner_id  ,PRACTITIONER_NAME practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(primary_speciality_code,'"+localeName+"','2') primary_specialty  , POSITION_CODE job_title  ,gender gender  FROM  am_practitioner_lang_vw  WHERE pract_type =nvl('"+to_pract_type+"',pract_type)   AND UPPER(pract_type) LIKE UPPER(NVL(?,pract_type))   AND UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code))   AND   (  UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id))   AND UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name))  )   AND UPPER(gender) LIKE NVL(UPPER(?),UPPER(gender)   AND UPPER(NVL(job_title,'123')) LIKE UPPER(NVL(?,NVL(job_title,'123')))   and language_id = '"+localeName+"' ORDER BY  PRACTITIONER_NAME ";
					await getPractitioner_common(obj,target,to_pract_type,"","Q1");
				}

				/*var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
				var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
				xmlStr	="<root><SEARCH " ;
				xmlStr += " practName_FName=\"" +practName_FName + "\"";
				xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
				xmlStr += " practId_FName=\"" + practId_FName + "\"";
				xmlStr += " sql=\"" +encodeURIComponent(sql)+ "\"";
				xmlStr += " sqlSec=\"" +encodeURIComponent(sql2)+ "\"";
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
					res_type = document.forms[0].fm_pract_type.value;
					sql="Select resource_id code,short_desc description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+p_resource_class1+"'  and  language_id='"+localeName+"' and resource_type=nvl('"+res_type+"',resource_type) and upper(resource_id) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
					await call_common(sql,"pract_id");
				}
				else
				{
					res_type = document.forms[0].to_pract_type.value;
					sql="Select resource_id code,short_desc description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+p_resource_class1+"'  and language_id='"+localeName+"' and resource_type=nvl('"+res_type+"',resource_type) and upper(resource_id) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
					await call_common(sql,"pract_id1");
				}
			}
			else if(p_resource_class1=='R')
			{//Room
			if(obj.name=="pract_id")
			{
				clinic_code = document.forms[0].fm_clinic_code.value;
				res_type	= document.forms[0].fm_pract_type.value;
				sql="select PRACTITIONER_ID code ,AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+localeName+"','2') description from op_pract_for_clinic_vw where clinic_code=nvl('"+clinic_code+"',clinic_code) and RESOURCE_CLASS=nvl('"+res_type+"',RESOURCE_CLASS) and Facility_id ='"+facilityid+"' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_SHORT_NAME) like upper(?) order by PRACTITIONER_SHORT_NAME";
				/*sql="select room_no code ,room_short_desc description from op_clinic_room_vw where clinic_code=nvl('"+clinic_code+"',clinic_code) and room_type=nvl('"+res_type+"',room_type) and Facility_id ='"+facilityid+"' and upper(room_no) like upper(?) and upper(room_short_desc)  like upper(?) order by  room_short_desc";*/
				await call_common(sql,"pract_id");
			}
			else
			{
				clinic_code = document.forms[0].fm_clinic_code.value;
				res_type	= document.forms[0].to_pract_type.value;
				sql="select PRACTITIONER_ID code ,AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+localeName+"','2') description from op_pract_for_clinic_vw where clinic_code=nvl('"+clinic_code+"',clinic_code) and RESOURCE_CLASS=nvl('"+res_type+"',RESOURCE_CLASS) and Facility_id ='"+facilityid+"' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_SHORT_NAME) like upper(?) order by PRACTITIONER_SHORT_NAME";
				await call_common(sql,"pract_id1");
			}
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

function enablepr(obj)
{
		document.forms[0].fm_pract_id.value='';
}
function enablepr1(obj)
{
		document.forms[0].to_pract_id.value='';
}
	
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014 End-->
</head> 
<body onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>

	<form name='ConfirmPullingListForm' id='ConfirmPullingListForm' action='../../servlet/eFM.FMConfirmPullingListServlet' method='post' target='messageFrame'>
		<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		
		<tr>
		<td class='label' width= '25%'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
		<td class='fields' width= '25%' ><select name='fs_locn_code' id='fs_locn_code' onchange='clearpatid();'  ><option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
		<%
	        if(stmt != null) stmt=null;
			stmt =	con.createStatement();
          //  String sql1 ="select appl_user_name from sm_appl_user where appl_user_id = '"+user_id+"'";
          
		 user_name_old=(String)session.getAttribute("user_name");
		if(user_name_old == null || user_name_old.equals("null")) user_name_old="";
			
			if(user_name_old.equals(""))
		  {
			String sql1 ="select appl_user_name,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') sydate from sm_appl_user_LANG_VW where appl_user_id='"+user_id+"' AND LANGUAGE_ID = '"+localeName+"'";
            rs=stmt.executeQuery(sql1);
			while(rs!=null&&rs.next())
			{
             user_name = rs.getString(1);
			}
		session.setAttribute("user_name",user_name);
		}else{
  user_name=user_name_old;

		}
           
			
			if(rs!=null) rs.close();
			rs = stmt.executeQuery(fs_locn_query);
			int count=0;
			String selected="";
			while(rs.next())
			{
				count++;
				fs_locn_code	=	rs.getString(1);
				fs_locn_desc	=	rs.getString(2);

				if(fs_locn_code == null)fs_locn_code="";
				if(fs_locn_desc == null)fs_locn_desc="";

				if(count==1)selected="";
				else selected="";

				out.println("<option value="+fs_locn_code+" "+selected+" >"+fs_locn_desc+"</option>");
			}
			if(rs != null)		rs.close();
		%>
		</select><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label' nowrap width='24%'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
		<td class='fields' width='26%' ><input type='text' id='conpulldate' name='appt_date' id='appt_date' value='<%=sys_date%>' size='10' maxlength='10'  onBlur='validDateObj(this,"DMY","<%=localeName%>");valChkDate(this)'><input type="image" src="../../eCommon/images/CommonCalendar.gif" tabindex=-1 onClick="return showCalendar('conpulldate');"><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		
	</tr>
	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 Start-->
	<% if(isStartAndEndTimeAvailable){%>
	<tr>
		<td class='label' ><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
		<td class='fields'><INPUT TYPE=TEXT   SIZE=5 MAXLENGTH=5 name='start_time' id='start_time'  onBlur="isValidTime(this)" onKeyPress='return(ChkTimeInput(this,event))'  ></td>
		<td class='label' ><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
		<td class='fields'><INPUT TYPE=TEXT   SIZE=5 MAXLENGTH=5 name='end_time' id='end_time'  onBlur="isValidTime(this);" onKeyPress='return(ChkTimeInput(this,event))'></td>
	</tr>
	<%}else{%>
		<input type='hidden' name='start_time' id='start_time' value=''>
		<input type='hidden' name='end_time' id='end_time' value=''>
	<%}%>
	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 End-->
	
	<tr>
	<td class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
<%
		// mysql = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E','Y') order by 2";
		 mysql = " SELECT Locn_Type,  ShOrt_Desc,  Care_Locn_Type_Ind FROM am_care_locn_type_lang_vw WHERE sys_User_def_Ind = 'S'  AND LANGUAGE_ID='"+localeName+"'  AND Locn_Type IN ('C',  'E',  'Y') ORDER BY 2";
		 rs = stmt.executeQuery(mysql);
 %>
		<td class='fields'><SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);"> 
		 <option value='' style='align:center'>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
<%
			String locn_type="";
            String short_desc="";
            while(rs.next() && rs !=null)
			{
                locn_type=rs.getString("care_locn_type_ind");
                short_desc=rs.getString("short_desc");
                out.println("<option value='"+locn_type+"'>"+short_desc);
			}
%>
		</SELECT> <img align='center' id='loc_type' src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type="text" name="fm_clinic_desc" id="fm_clinic_desc" size="15" maxlength="15" onblur='if(this.value != ""){searchCode(locn, fm_clinic_code,facility_id)};clearcliniccode(this);' disabled><input type="hidden" name="fm_clinic_code" id="fm_clinic_code" value='' ><input type='button' name='locn' id='locn' value='?' class='button'  onclick='searchCode(this, fm_clinic_code,facility_id)' disabled><img align='center' id='location1' src='../../eCommon/images/mandatory.gif'></img></td>

	</tr>
	<tr>
		
		<td class='label' nowrap><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name='p_resource_class1' id='p_resource_class1' id='res' onchange='practValidate(this);getResource(this)' onblur='//resourceOnBlur();'>
			<OPTION value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</OPTION>
			<OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></OPTION>
			<OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></OPTION>
			<OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/></OPTION>
			<OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/></OPTION> 
        </SELECT></td>

		<td class='label' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name='fm_pract_type' id='fm_pract_type' onClick='//checkpract()' onChange='enablepr(this);//validateTbs();'>
          <OPTION value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
        </SELECT>-<SELECT name='to_pract_type' id='to_pract_type' onClick='//checkpract()' onChange='enablepr1(this);'>
          <OPTION value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
        </SELECT>
		</td>
	</tr>
	<tr>
	<td class='label' nowrap><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="fm_pract_id" id="fm_pract_id" disabled onblur ="onblurcheck(this,fm_pract_id)" size="18" maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' class='button' disabled onclick="callPractSearch(this, fm_pract_id)">
		</td>
		<td class='label'><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="to_pract_id" id="to_pract_id" disabled onblur="onblurcheck(this,to_pract_id)" size="18" maxlength="15" ><input type='button' name='pract_id1' id='pract_id1' disabled value='?' class='button' onclick='callPractSearch(this, to_pract_id)'></td>
	</tr>

	<tr>
		<td class='label' nowrap><fmt:message key="Common.display.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name=confirm_yn tabindex=2>
			<option value='N'><fmt:message key="Common.NotConfirmed.label" bundle="${common_labels}"/></option>
			<option value='Y'><fmt:message key="Common.confirmed.label" bundle="${common_labels}"/></option>
			<option value='C'><fmt:message key="eFM.ApptCancelled.label" bundle="${fm_labels}"/></option>
			<option value='S'><fmt:message key="eFM.ScheduleCancelled.label" bundle="${fm_labels}"/></option>
			<option value='T'><fmt:message key="eFM.ApptTransfered.label" bundle="${fm_labels}"/></option>
			<option value='F'><fmt:message key="eFM.FileOutsideMRD.label" bundle="${fm_labels}"/></option>
		</select></td>
		<td class='label' nowrap>
		<fmt:message key="eFM.PullingListType.label" bundle="${fm_labels}"/></td>
		<td class='fields'><select name=pull_type >
			<option value='A'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.main.label" bundle="${common_labels}"/></option>
			<option value='S'><fmt:message key="eFM.Supplementary.label" bundle="${fm_labels}"/></option>
	</select></td>
	</tr>

	<tr>
		
		<td class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='fields' ><select name=p_gender tabindex=2>
			<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select></td>
		<td class='label' ><fmt:message key="eFM.GeneratedBy.label" bundle="${fm_labels}"/></td>
		<td class='fields' >
		<%
			if(user_security_yn.equals("Y"))
		{
		%>
			<input type='text' name='appl_user_name' id='appl_user_name' value="<%=user_name%>" size='30' disabled maxlength=60 ><input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=user_id%>' size='40' disabled maxlength=30 ><input type=button name=searchcode value='?' class=button onClick="search(appl_user_id,'<%=facility_id%>',appl_user_name)" disabled></td>
		<%
		}
		else
		{
		%>
			<input type='text' name='appl_user_name' id='appl_user_name' value="<%=user_name%>" size='30' disabled maxlength=60 ><input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=user_id%>' size='40' readonly maxlength=30 ><input type=button name=searchcode value='?' class=button onClick="search(appl_user_id,'<%=facility_id%>',appl_user_name)"></td>
		<%
		}
		%>
		</tr>
	
<!-- 	<tr>
		
		
	<td  class='button'>
	
	<%--<input type='button' name='subBotton' id='subBotton' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick='fetchResults(appt_date,fs_locn_code,p_gender,fm_clinic_code,fm_pract_id,to_pract_id,confirm_yn,appl_user_id,pull_type);'>--%>
	
	</td>
	</tr> -->
	<tr>
			<td colspan='4'>
			<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="frame_name" value="parent.frames[1].FMConfirmPullingListCriteriaFrame"/>
				<jsp:param name="form_name" value="ConfirmPullingListForm"/>
				<jsp:param name="messageframe_name" value="parent.parent.messageFrame"/>
				<jsp:param name="patientid_name" value="patient_id"/>
				<jsp:param name="fileno_name" value="p_file_no"/>
				<jsp:param name="filetype_name" value="file_type"/>
				<jsp:param name="volumeno_name" value="volume_no"/>
				<jsp:param name="doctype_appl_yn" value="Y"/>
				<jsp:param name="table_width" value="100"/>
				<jsp:param name="locn_code" value="f_curr_fs_locn"/>
			</jsp:include>
			
			</td>
		</tr>	
	
	<TR> <td>&nbsp;</td> </TR>
   <TR>
	<td  colspan="4" align='right'><input  type=button name=Add value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>'  class=button onClick="addFiles_confirm()"><input  type=button name=subBotton value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ShowAllFiles.label","fm_labels")%>'  class=button onClick="fetchResults(appt_date,fs_locn_code,p_gender,fm_clinic_code,fm_pract_id,to_pract_id,confirm_yn,appl_user_id,pull_type);"><input  type=button name=Clear value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  class=button onClick="ClearAllval()">
	</TD>
	</TR>
		</table>
		<script>
			if ('<%=count%>'==1)
			{
				document.forms[0].fs_locn_code.value = '<%=fs_locn_code%>';
			}
		</script>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='CBValStr' id='CBValStr' value=''>
		<input type='hidden' name='print_only_report' id='print_only_report' value=''>
		<input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''>
	   <input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''>
	   <input type="hidden" name="flag" id="flag" value=''>
		<input type="hidden" name="status" id="status" value=''>
		<input type="hidden" name="patid" id="patid" value=''>
		<input type="hidden" name="volumeno" id="volumeno" value=''>
			<input type="hidden" name="flno" id="flno" value=''>
			<input type='hidden' name='added_rem_remarks' id='added_rem_remarks' value=''>
			<input type='hidden' name='added_rem_remarks_values' id='added_rem_remarks_values' value=''>
			<input type='hidden' name='pat_file_vol' id='pat_file_vol' value=''>
			<input type='hidden' name='isStartAndEndTimeAvailable' id='isStartAndEndTimeAvailable' value='<%=isStartAndEndTimeAvailable%>'><!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014-->
		</form>
</body>
</html>
	<%
	if(rs != null)		rs.close();
	if(stmt != null)	stmt.close();
	if(rs2 != null)		rs2.close();
	if(stmt2 != null)	stmt2.close();
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

