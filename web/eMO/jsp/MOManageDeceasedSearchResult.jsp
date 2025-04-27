<!DOCTYPE html>
<%@page import="java.sql.PreparedStatement"%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@ page import ="java.sql.Statement,java.sql.ResultSet,java.sql.Connection,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	String locale = ((String)session.getAttribute("LOCALE"));
	int cnt=0;
	String backgroundheader="style='color:black'";
	String causeOfDeathReg="N";        
	String colordisplay="";
	String  no_days_mortuary="";
	String  burial_permit_reqd_yn="N";
	String  HOURS="";
	String  MINUTES="";
	String  RELIGION="";
	String	REGISTRATION_NO		 = "";
	String	MO_REGN_DATE_TIME	 = "";
	String	PATIENT_NAME		 = ""; 
	String	PATIENT_ID			 = ""; 
	String	AGE					 = "";	
	String	SEX					 = "";
	//String	sex_converted		 = "" ;
	String	PM_YN				 = "";	
	String  pm_yn_converted      = "" ;
	String  encounter_id		 = "";
	String	POSTMORTEM_STATUS	 = "";
	String brought_dead_yn       =""; 
	String bur_per_no="";
	String postmortem_type ="";
	String area_type_desc="";
	String highriskbody="";
	String dispose_body_yn="";
	String  AREA_TYPE			 = "";
	String	assign_area_code	 = "";	
	String	assign_area_code_desc	 = "";	

	String	assign_area_desc	 = "";	
    String or_installyn          ="";  
	String  bed_no               = "";
    String order_catalog_code ="";
    String rfid_tag_num ="";
	String POSTMORTEM_STATUS_DESC="";
	String BODY_PART_OBTAINED_FROM_DESC="";
	String queue_refresh_interval="0";
    String BDY_PRT_OBT_FROM="";
    request.setCharacterEncoding("UTF-8");

	String fac_id				 = (String) session.getValue( "facility_id" ) ;
	String login_user			= (String) session.getValue("login_user");//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
	StringBuffer  sql				     = new StringBuffer();
	String assign_area_code_prev = "";
	String patient_class	= "";
	String area_code	        = request.getParameter("area_code");
	String registration_id		= request.getParameter("registration_no");
	String patient_id			= request.getParameter("patient_id");
	String function_id			= request.getParameter("function_id");
    if(function_id == null) function_id = "";

	String burial_permit_no		= request.getParameter("burial_permit_no")==null?"":request.getParameter("burial_permit_no");
	String obtained_from			= request.getParameter("obt_frm")==null?"":request.getParameter("obt_frm");
	
	StringBuffer sql1 = new StringBuffer();
	String gender				= request.getParameter("gender");
	String parameters			=  request.getQueryString() ;
	if(parameters==null)parameters="";
	String called_from_ca		= request.getParameter("called_from_ca")==null?"N":request.getParameter("called_from_ca");
	String callfrommoreg		= request.getParameter("callfrommoreg")==null?"":request.getParameter("callfrommoreg");
	 

	String BODY_PART_OBTAINED_FROM		= request.getParameter("body_part_obtained_from")==null?"":request.getParameter("body_part_obtained_from");

	if(callfrommoreg.equals("callfrommanage"))callfrommoreg="";

	StringBuffer sql2 = new StringBuffer();
	int count = 0;
	String frmdate					  = request.getParameter("frmdate")==null||request.getParameter("frmdate").equals("")?"01/01/1800 00:00":request.getParameter("frmdate");
	String todate                     = request.getParameter("todate")==null?"":request.getParameter("todate");
    String atype                      = request.getParameter("atype")==null?"":request.getParameter("atype");
	String pmstatus					  = request.getParameter("pmstatus")==null?"":request.getParameter("pmstatus");
	String rstatus                    = request.getParameter("rstatus")==null?"":request.getParameter("rstatus");
	String CLAIMANT_TYPE  			  ="";   // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
	String RELEASE_TO_FACILITY		  ="";   // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg


	String external="N";
	if(area_code == null || area_code.equals("null"))    area_code = "";
	if(registration_id == null || registration_id.equals("null"))	   registration_id = "";
	if(patient_id == null || patient_id.equals("null"))				   patient_id = "";
	if(gender == null || gender.equals("null"))						   gender = "";
    if(gender.equals("M"))											
	gender="MALE";
	else if(gender.equals("F"))										
	gender="FEMALE";

	int i			= 1;
	int maxRecord	= 0;
	java.sql.Statement stmt	= null;
	ResultSet rset	= null;
	java.sql.Statement stmt1	= null;
	ResultSet rset1	= null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    String hide_pat_unauth_pract = "N";
   	String access_res_pat_yn = "N";

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int start = 0 ;
	int end = 0 ;
	int l=1;
    if ( from == null )
	start = 1 ;
	else
	start = Integer.parseInt( from ) ;
    if ( to == null )
	end = 8 ;
	else
	end = Integer.parseInt( to ) ;
        int sCount=start;//22856
	 //Added for this CRF ML-MMOH-CRF-0860.2
	 Boolean increasedaddressLength=false;

	try {
		
		conn     = ConnectionManager.getConnection(request);	
		stmt	 = conn.createStatement();
		
	//Added for this CRF ML-MMOH-CRF-0860.2
	 increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","INCREASED_ADDRESS_LINE_LENGTH");
				JSONObject json = new JSONObject(); // added by mujafar for ML-MMOH-CRF-0996 start
				json			 = eMO.MOCommonBean.getMOParam(conn, fac_id); 
				String enable_rfid_yn = (String)json.get("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996 end

%>
	<HTML>
	<head>
	

	<script language='javascript' src='../../eCommon/js/common.js'></script>	
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script src="../../eMO/js/MOManageDeceased.js"></script>
	<script src="../../eMO/js/MORegisterAttn.js"></script>
	<%
     String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eMO/js/MORegDetailsQuery.js'> </script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


    <% 
	if(callfrommoreg.equals("") || callfrommoreg.equals("releaseDeceased")  ){%>
	<script>
	var refreshparam;
	var checkout_yn;
	var queue_refresh_interval =parent.frames[1].document.forms[0].queue_refresh_interval.value;
	if(queue_refresh_interval != ""){
	refreshparam=queue_refresh_interval*60*1000;
	self.setInterval('callSamepage()',refreshparam);
	parent.frames[1].document.getElementById('sys_date').innerHTML = getCurrentDate("HM","<%=locale%>");	

	}else{
		var msg=getMessage('CAN_NOT_BE_BLANK','common');
		msg=msg.replace('$',getLabel('Common.RefreshInterval.label','common'));
		alert(msg);
		parent.frames[1].QueryLocnForDayResult.queue_refresh_interval.focus();
		parent.frames[1].document.forms[0].search.disabled=false;
		parent.frames[3].location.href='../../eCommon/html/blank.html';
   
		
		}
    </script>
 <% } %>
   
 

	
	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
	<form name='QueryLocnForDayResult' id='QueryLocnForDayResult' >
	<%

	//Added by Ajay Hatwate for MMS-DM-CRF-0210
    pstmt = conn.prepareStatement("select (select HIDE_PAT_UNAUTH_PRACT_YN from CA_PARAM_BY_FACILITY where facility_id = ?) hide_pat_unauth_pract_yn, (SELECT a.access_res_pat_yn FROM ca_access_view_restr_patient a WHERE a.practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = ?) AND a.facility_id = ? AND (   (    a.access_from_date IS NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) ))access_res_pat_yn from dual ");
   	pstmt.setString(1, fac_id);
   	pstmt.setString(2, login_user);
   	pstmt.setString(3, fac_id);
   	rset = pstmt.executeQuery();
   	rset.next();
   	hide_pat_unauth_pract = checkForNull(rset.getString("hide_pat_unauth_pract_yn"),"N");
   	access_res_pat_yn = checkForNull(rset.getString("access_res_pat_yn"), "N");
   // System.out.println(hide_pat_unauth_pract + " : hide_pat_unauth_pract; " +access_res_pat_yn + " : access_res_pat_yn");
    if(pstmt!=null) pstmt.close();
    if(rset!=null) rset.close();
	//End of MMS-DM-CRF-0210
	
	
	

	String orinst="Select OPERATIONAL_YN from SM_MODULES_FACILITY where module_id='OR' and FACILITY_ID='"+fac_id+"'";
     rset = stmt.executeQuery(orinst);	
     if(rset.next())
	 {
	  or_installyn=rset.getString("OPERATIONAL_YN")==null?"":rset.getString("OPERATIONAL_YN");
	 }
	 if(rset!=null)rset.close();
	 if(stmt!=null)stmt.close();
	
   if((or_installyn.equals("Y")) && (!(callfrommoreg.equals("callfrommoreg"))))
	{
    sql.setLength(0);
	sql.append(" where NVL(BODY_PART_OBTAINED_FROM,'*') like '"+BODY_PART_OBTAINED_FROM+"%' and postmortem_status like '"+pmstatus+"%' and  facility_id='"+fac_id+"' and NVL(area_code,decode(registration_no,null,'$','*')) like '"+area_code+"%' and  NVL(patient_id,'*') like '"+patient_id+"%' and sex like '"+gender+"%' and NVL(registration_no,'*') like '"+registration_id+"%' and NVL(AREA_TYPE,'*') like '"+atype+"%' and (to_date(substr(BODY_RECEIVED_DATE,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy')  ");
	
	if(!todate.equals(""))
	 {
	 sql.append(" and to_date('"+todate+"','dd/mm/yyyy'))");
	 }else
	  {
	  sql.append(" and sysdate");
	  }
	 //sql.append(" or to_date(substr(ord_date_time,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy') ");
	 if(!todate.equals(""))
	 {
	 //sql.append(" and to_date('"+todate+"','dd/mm/yyyy'))");
	  }else
	  {
	     //sql.append(" and sysdate)");
	  }
	  
	   if(callfrommoreg.equals("RevertRelease")){
		 sql.append("  AND release_body_date is not null ");
	  }else{
		sql.append("and (('"+rstatus+"' is null) or ( '"+rstatus+"' is not null and '"+rstatus+"'='C' and release_body_date is null) or ('"+rstatus+"' is not null and '"+rstatus+"'='R' and release_body_date is not null ))");
	  }
	
	 if(callfrommoreg.equals("releaseDeceased"))
	  {
		 sql.append("  AND area_type = 'R' ");
	  }
	 if(callfrommoreg.equals("ExpoOfDeceased"))
	  {
		 sql.append("  AND exportation_doc_iss_date IS NULL AND exportation_reqd_yn = 'Y'  ");
	  }
	 
	 if(obtained_from.equals("C"))
     {
       sql.append(" and  BODY_PART_OBTAINED_FROM is  null");
     }else if(obtained_from.equals("A")||obtained_from.equals("U")||obtained_from.equals("D")||(!obtained_from.equals("C")))
     {
       sql.append(" and  BODY_PART_OBTAINED_FROM like '"+obtained_from+"%'");
     }else 
	  if(callfrommoreg.equals(""))
	  {
	  }else
	  if(callfrommoreg.equals("callfrombdyprt"))
	  {
	    sql.append(" and  BODY_PART_OBTAINED_FROM is not null");
	  }else if(callfrommoreg.equals("callfrommoreg"))
	  { sql.append(" and  BODY_PART_OBTAINED_FROM is  null");
	  }

      sql.append(" and  NVL(BURIAL_PERMIT_NO,'*') LIKE '"+burial_permit_no+"%'");
      //Added by Ajay Hatwate fior MMS-DM-CRF-0210
     if(access_res_pat_yn.equals("N") && hide_pat_unauth_pract.equals("Y")){
    	 sql.append(" and patient_id in (select patient_id from mp_patient mp where mp.patient_id = patient_id  and mp.restrict_reinstate_yn ='N') ");
     }
	
	  sql.append(" order by area_code,registration_no");	  
	
	
	  sql1.append("select count(distinct(registration_no))total from MO_MANAGE_DECEASED_VW ");
	  
	  sql1.append(sql.toString());
	  if(stmt!=null)stmt.close();
	  if(rset!=null)rset.close();

	  stmt	 = conn.createStatement();
	  rset = stmt.executeQuery(sql1.toString());	
      sql1.setLength(0);
	  if(rset.next())
	  maxRecord = rset.getInt("total");
	  if(maxRecord == 0) 
		{
		  %>
		  
	  <script>//parent.MOFrame.location.href='../../eCommon/html/blank.html';
		  alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); </script> 
	  <%
		}
	  else 
		{ 
		  %>
		   <script>
			/*var oldurl = 	parent.MOFrame.location.href;
			if(oldurl.indexOf("blank.html")!=-1)
			{
					parent.MOFrame.location.href='../../eMO/jsp/MOManagePatTabs.jsp'; 
			}*/
			</script> 
		  <%
	/*  sql1.append("select BODY_PART_OBTAINED_FROM, HIGH_RISK_BODY_YN,MO_GET_DESC.MO_AREA(AREA_CODE,'"+localeName+"','2') AREA_DESC,AREA_TYPE_DESC,AREA_CODE,REGISTRATION_NO,BODY_RECEIVED_DATE, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) PATIENT_NAME,PATIENT_ID, AGE, SEX, PM_YN, POSTMORTEM_STATUS,POSTMORTEM_STATUS_DESC, AREA_TYPE,BED_NO,ENCOUNTER_ID, DISPOSE_BODY_YN, MLC_YN,BROUGHT_DEAD_YN,POSTMORTEM_TYPE, POSTMORTEM_TYPE_DESC, STATUS, ORDER_CATALOG_CODE,RELEASE_BODY_DATE,BODY_PART_OBTAINED_FROM_DESC,BURIAL_PERMIT_NO from MO_MANAGE_DECEASED_VW"); */
	    //sql1.append("SELECT EXTERNAL_YN,body_part_obtained_from, high_risk_body_yn, area_desc, area_type_desc,area_code, registration_no, body_received_date, patient_name,patient_id, age, sex, pm_yn, postmortem_status, postmortem_status_desc,area_type, bed_no, encounter_id, dispose_body_yn, mlc_yn, brought_dead_yn, postmortem_type, postmortem_type_desc, status, order_catalog_code, release_body_date, body_part_obtained_from_desc, burial_permit_no,FLOOR (NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')) no_days_mortuary,trunc(((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI') ) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24) hours,trunc(((((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE )  - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')  ) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24) - trunc(((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24)) *60) minutes,religion,(select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+fac_id+"') burial_permit_reqd_yn,rfid_tag_num FROM mo_manage_deceased_vw");
	// Below Query Modified Against CRF Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg	
	sql1.append("SELECT EXTERNAL_YN,body_part_obtained_from, high_risk_body_yn, area_desc, area_type_desc,area_code, registration_no, body_received_date, patient_name,patient_id, age, sex, pm_yn, postmortem_status, postmortem_status_desc,area_type, bed_no, encounter_id, dispose_body_yn, mlc_yn, brought_dead_yn, postmortem_type, postmortem_type_desc, status, release_body_date, body_part_obtained_from_desc, burial_permit_no,FLOOR (NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')) no_days_mortuary,trunc(((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI') ) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24) hours,trunc(((((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE )  - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')  ) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'), SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24) - trunc(((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')) - trunc((NVL (TO_DATE (release_body_date, 'DD/MM/YYYY HH24:MI'),SYSDATE ) - TO_DATE (body_received_date, 'DD/MM/YYYY HH24:MI')))) * 24)) *60) minutes,religion,(select BURIAL_PERMIT_REQD_YN from MO_PARAMETER where facility_id = '"+fac_id+"') burial_permit_reqd_yn,rfid_tag_num,(Select CLAIMANT_TYPE from MO_CLAIMANT_VW where FACILITY_ID=mo_manage_deceased_vw.FACILITY_ID and REGISTRATION_NO=mo_manage_deceased_vw.REGISTRATION_NO and PATIENT_ID=mo_manage_deceased_vw.PATIENT_ID)CLAIMANT_TYPE, (Select RELEASE_TO_FACILITY from MO_CLAIMANT_VW where FACILITY_ID=mo_manage_deceased_vw.FACILITY_ID and REGISTRATION_NO=mo_manage_deceased_vw.REGISTRATION_NO and PATIENT_ID=mo_manage_deceased_vw.PATIENT_ID)RELEASE_TO_FACILITY FROM mo_manage_deceased_vw");
		
	  sql1.append(sql.toString());
      if(rset!=null)rset.close();
      if(stmt!=null)stmt.close();
	  stmt	 = conn.createStatement();
	  rset = stmt.executeQuery(sql1.toString());
	  sql1.setLength(0);
	%>
	
	
   <table border='0' cellpadding='0' cellspacing='0' width='101%' id='TitleTab'>
<tr>
        <td align=left width='10%'>
            <table align=left >
                
            </table>
        </td>
        <td  width='10%'>
            <table  align=right>
                <tr>
                    <td >
	

    <%
if ( !(start <= 1) )
	out.println("<A HREF='../jsp/MOManageDeceasedSearchResult.jsp?function_id="+function_id+"&from="+(start-8)+"&to="+(end-8)+"&area_code="+URLEncoder.encode(area_code)+"&registration_no="+URLEncoder.encode(registration_id)+"&patient_id="+URLEncoder.encode(patient_id)+"&burial_permit_no="+URLEncoder.encode(burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&gender="+URLEncoder.encode(gender)+"&called_from_ca="+URLEncoder.encode(called_from_ca)+"&callfrommoreg="+URLEncoder.encode(callfrommoreg)+"&body_part_obtained_from="+URLEncoder.encode(BODY_PART_OBTAINED_FROM)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&atype="+URLEncoder.encode(atype)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+8) > maxRecord ) )
	out.println("<A HREF='../jsp/MOManageDeceasedSearchResult.jsp?function_id="+function_id+"&from="+(start+8)+"&to="+(end+8)+"&area_code="+URLEncoder.encode(area_code)+"&registration_no="+URLEncoder.encode(registration_id)+"&patient_id="+URLEncoder.encode(patient_id)+"&burial_permit_no="+URLEncoder.encode(burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&gender="+URLEncoder.encode(gender)+"&called_from_ca="+URLEncoder.encode(called_from_ca)+"&callfrommoreg="+URLEncoder.encode(callfrommoreg)+"&body_part_obtained_from="+URLEncoder.encode(BODY_PART_OBTAINED_FROM)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&atype="+URLEncoder.encode(atype)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
                </tr>
            </table>
        </td>
    </tr>
</table>
    <!--backgroundheader added by shagar for ML-MMOH-CRF-0749 -->

 

	<table border="1" width="115%" cellspacing='1px' cellpadding='0'>
	<th <%=backgroundheader%>>&nbsp;</th>
	<th <%=backgroundheader%> rowspan=1 ><fmt:message key="eCA.Sno.label" bundle="${common_labels}"/></th><!-- 22856 -->
	<th <%=backgroundheader%>><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></th> 
	<th <%=backgroundheader%> nowrap><fmt:message key="Common.RegnDate/Time.label" bundle="${common_labels}"/></th>
    <th <%=backgroundheader%> align = "center" nowrap>
	<%if(obtained_from.equals("C"))
     {%>
	 <fmt:message key="Common.deceased.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/>
	 <%}else{%>
	<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
	<%}%>
	
	<th <%=backgroundheader%>><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="eMO.PMYN.label" bundle="${mo_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="eMO.PostmortemStatus.label" bundle="${mo_labels}"/></th>
	<th <%=backgroundheader%> nowrap><fmt:message key="eMO.DurationinMortuary.label" bundle="${mo_labels}"/></th>
	<th <%=backgroundheader%> nowrap><fmt:message key="Common.religion.label" bundle="${common_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
	<%
	if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
	{
	%>
	<th <%=backgroundheader%> nowrap><fmt:message key="eMO.RFIDTag.label" bundle="${mo_labels}"/> </th>
	<%
	}
	if(!obtained_from.equals("C"))
     {%>
	<th <%=backgroundheader%> nowrap ><fmt:message key="eMO.BodyPartType.label" bundle="${mo_labels}"/></th>
	<%}%>	<!--nowrap removed below by Santhosh for ML-MMOH-CRF-1947>-->
	<th <%=backgroundheader%>><fmt:message key="eMO.BurialPermitNo.label" bundle="${mo_labels}"/></th>

	<% 
	String classValue	= "";
	int rowIndex		= 1;
	if ( start != 1 )
	for( int j=1; j<start; l++,j++ ){
	rset.next() ;
    }
	while (rset.next()&&l<=end)
	{
	classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
	rowIndex++;
	
	//order_catalog_code		= rset.getString("order_catalog_code");
	//order_catalog_code= (order_catalog_code == null)?"":order_catalog_code;
	CLAIMANT_TYPE		= rset.getString("CLAIMANT_TYPE");   // Added Against Bru-HIMS-CRF-366 [IN-039612]
	CLAIMANT_TYPE= (CLAIMANT_TYPE == null)?"":CLAIMANT_TYPE; // Added Against Bru-HIMS-CRF-366 [IN-039612]
	RELEASE_TO_FACILITY		= rset.getString("RELEASE_TO_FACILITY");  //Added Against Bru-HIMS-CRF-366 [IN-039612]
	RELEASE_TO_FACILITY= (RELEASE_TO_FACILITY == null)?"":RELEASE_TO_FACILITY; //Added Against Bru-HIMS-CRF-366 [IN-039612]
	
	dispose_body_yn		= rset.getString("dispose_body_yn");
	dispose_body_yn= (dispose_body_yn == null)?"":dispose_body_yn;
	assign_area_desc		= rset.getString("AREA_DESC");
	assign_area_desc 		= (assign_area_desc == null)?"":assign_area_desc;
	assign_area_code		= rset.getString("AREA_CODE");
	assign_area_code 		= (assign_area_code == null)?"":assign_area_code;
	REGISTRATION_NO			= rset.getString("REGISTRATION_NO"); 
	REGISTRATION_NO 		= (REGISTRATION_NO == null)?"":REGISTRATION_NO;
	MO_REGN_DATE_TIME		= rset.getString("body_received_date"); 
	MO_REGN_DATE_TIME 		= (MO_REGN_DATE_TIME == null)?"":MO_REGN_DATE_TIME;
	if(MO_REGN_DATE_TIME!=null && !MO_REGN_DATE_TIME.equals(""))
		MO_REGN_DATE_TIME	=  DateUtils.convertDate(MO_REGN_DATE_TIME,"DMYHM","en",localeName); 
	PATIENT_NAME			= rset.getString("PATIENT_NAME");
	PATIENT_NAME 			= (PATIENT_NAME == null)?"":PATIENT_NAME;
	PATIENT_ID				= rset.getString("PATIENT_ID");
	PATIENT_ID 				= (PATIENT_ID == null)?"":PATIENT_ID;
	burial_permit_reqd_yn         =rset.getString("burial_permit_reqd_yn")==null?"":rset.getString("burial_permit_reqd_yn");
	brought_dead_yn         =rset.getString("BROUGHT_DEAD_YN")==null?"":rset.getString("BROUGHT_DEAD_YN");
	brought_dead_yn         =rset.getString("BROUGHT_DEAD_YN")==null?"":rset.getString("BROUGHT_DEAD_YN");
	BDY_PRT_OBT_FROM =rset.getString("BODY_PART_OBTAINED_FROM")==null?"":rset.getString("BODY_PART_OBTAINED_FROM");
	AGE						= rset.getString("AGE");
	AGE 					= (AGE == null)?"":AGE;
	SEX						= rset.getString("SEX");
	SEX 					= (SEX == null)?"":SEX;
	if(SEX!=null && !SEX.equals("") && SEX.equals("Male"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(SEX!=null && !SEX.equals("") && SEX.equals("Female"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(SEX!=null && !SEX.equals("") && SEX.equals("Unknown"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");


	bur_per_no						= rset.getString("BURIAL_PERMIT_NO");
	bur_per_no 					= (bur_per_no == null)?"":bur_per_no;

	no_days_mortuary						= rset.getString("no_days_mortuary");
	external=rset.getString("EXTERNAL_YN")==null?"N":rset.getString("EXTERNAL_YN");

	 if(no_days_mortuary.length()==2)
		{
		no_days_mortuary = "&nbsp;&nbsp;"+no_days_mortuary;
		}
		if(no_days_mortuary.length()==1)
		{
		no_days_mortuary = "&nbsp;&nbsp;&nbsp;"+no_days_mortuary;
		}
	if( no_days_mortuary.equals("&nbsp;&nbsp;&nbsp;0") ){ no_days_mortuary="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; }
   String days ="   Days";

    if( no_days_mortuary.equals("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")){
	 days = "";
    }
	no_days_mortuary = no_days_mortuary + days ;

	HOURS						= rset.getString("HOURS");

	   if(HOURS.length()==1)
		{
		HOURS = "0"+HOURS;
		}
		String hours1 ="h:";

	/*	if( HOURS.equals("00") ){
			HOURS="&nbsp;&nbsp;&nbsp;";
			hours1="&nbsp;&nbsp;&nbsp;";

		} */

	
	HOURS = HOURS + hours1 ;

	MINUTES						= rset.getString("MINUTES");

    if(MINUTES.length()==1)
		{
		MINUTES = "0"+MINUTES;
		}
	String minutes1 ="m";
	MINUTES = MINUTES + minutes1 ;

	String hours_minutes ="";
	 hours_minutes = HOURS + MINUTES ;

	RELIGION						= rset.getString("RELIGION");
	RELIGION 					= (RELIGION == null)?"&nbsp;":RELIGION;

	PM_YN					= rset.getString("PM_YN");
	PM_YN 					= (PM_YN == null)?"":PM_YN;	
	if(PM_YN!=null && !PM_YN.equals("") && PM_YN.equals("N"))
		pm_yn_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
	else if(PM_YN!=null && !PM_YN.equals("") && PM_YN.equals("Y"))
		pm_yn_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");

	assign_area_desc		= rset.getString("AREA_DESC");
	assign_area_desc 		= (assign_area_desc == null)?"":assign_area_desc;
	//area_type_desc          = rset.getString("AREA_TYPE_DESC")==null?"":rset.getString("AREA_TYPE_DESC");
	POSTMORTEM_STATUS		= rset.getString("POSTMORTEM_STATUS");
	POSTMORTEM_STATUS 		= (POSTMORTEM_STATUS == null)?"":POSTMORTEM_STATUS;
	//POSTMORTEM_STATUS_DESC		= rset.getString("POSTMORTEM_STATUS_DESC");
	//POSTMORTEM_STATUS_DESC 		= (POSTMORTEM_STATUS_DESC == null)?"":POSTMORTEM_STATUS_DESC;

	if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("N"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("A"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.NotRequested.label","mo_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("R"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("S"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("E"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("C"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
	
	//BODY_PART_OBTAINED_FROM_DESC		= rset.getString("BODY_PART_OBTAINED_FROM_DESC");
	//BODY_PART_OBTAINED_FROM_DESC=(BODY_PART_OBTAINED_FROM_DESC == null)?"":BODY_PART_OBTAINED_FROM_DESC;

	if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("A"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.AmputatedBodyPart.label","mo_labels");
	else if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("D"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.DeadFetus.label","mo_labels");
	else if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("U"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.UnidentifiedBodyPart.label","mo_labels");
	else 
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");




	highriskbody 		=  rset.getString("HIGH_RISK_BODY_YN")==null?"":rset.getString("HIGH_RISK_BODY_YN"); 
	if(highriskbody.equals("Y"))
	{
	colordisplay="style='background-color:orange'";
	}else 
		{
		colordisplay="";
	}
	postmortem_type 		=  rset.getString("postmortem_type")==null?"":rset.getString("postmortem_type"); 
	AREA_TYPE		= rset.getString("AREA_TYPE");
	AREA_TYPE 		= (AREA_TYPE == null)?"":AREA_TYPE;
	
	if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("R"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("S"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StorageArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("P"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("O"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");


	bed_no			= rset.getString("BED_NO");
	bed_no 			= (bed_no == null)?"":bed_no;
	encounter_id	= rset.getString("encounter_id");
	encounter_id	= (encounter_id == null)?"":encounter_id;
	rfid_tag_num	= rset.getString("rfid_tag_num")==null?"": rset.getString("rfid_tag_num");
	
	if(called_from_ca.equals("Y"))
	{
		sql2.append("SELECT count(*) from MO_MORTUARY_REGN_VW where facility_id='"+fac_id+"' and encounter_id = '"+encounter_id+"' and 	registration_no='"+REGISTRATION_NO+"'");
		// and ATTEND_PRACTITIONER_ID is not null"); //modified for ML-BRU-SCF-0829 [IN:039636]
		stmt1 = conn.createStatement();
		rset1 = stmt1.executeQuery(sql2.toString());
		while(rset1.next())
		{
			count = rset1.getInt(1);
		}
		 if(stmt1!=null) stmt1.close();
	     if(rset1!=null) rset1.close();
	}
	
	sql2.setLength(0);
	sql2.append("select patient_class from pr_encounter where encounter_id = '"+encounter_id+"' and facility_id='"+fac_id+"'");
	stmt1 = conn.createStatement();
	rset1 = stmt1.executeQuery(sql2.toString());
	patient_class="";//modified for ML-BRU-SCF-0829 [IN:039636]
	while(rset1.next())
	{
	 patient_class = rset1.getString(1);
	}	
	//modified for ML-BRU-SCF-0829 [IN:039636] - start
	if(patient_class != null && patient_class.equals("")){
		patient_class="XT";
		encounter_id="";
	}
	//modified for ML-BRU-SCF-0829 [IN:039636] - end
	if(stmt1!=null) stmt1.close();
	if(rset1!=null) rset1.close();
	sql2.setLength(0);
	if(assign_area_code.equals("") &&(!REGISTRATION_NO.equals("")))
		{
		assign_area_code="Unassigned";
		assign_area_code_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
		}
	
	if(REGISTRATION_NO.equals(""))
		{
		assign_area_code="Unregistered";
		assign_area_code_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Unregistered.label","mo_labels");
		}
	if(assign_area_code.equals(assign_area_code_prev)){}
	else{
		assign_area_code_prev=assign_area_code;
	if(assign_area_code.equals("Unassigned")||assign_area_code.equals("Unregistered"))
	{%>
		<tr><th <%=backgroundheader%> colspan=16 align=left><B><%=assign_area_code_desc%></B></th></tr>
	<%}else {%>
	<tr><th <%=backgroundheader%> colspan=16 align=left><B><%=assign_area_desc%>/<%=assign_area_code_desc%>/<%=area_type_desc%></B></th></tr>
	<tr>
	<%}
	} 

	if(!encounter_id.equals(""))
	 {
	String deathcnt="Select count(*) cnt from mr_death_register_diag_dtl  where  facility_id='"+fac_id+"' and    encounter_id='"+encounter_id+"' and diagnosis_group='C' ";
	

	stmt1	 = conn.createStatement();
	rset1 = stmt1.executeQuery(deathcnt);
	 
	 if(rset1.next())
	  {
	   cnt=rset1.getInt("cnt");

	  if(cnt>0)
		  {
		  causeOfDeathReg="Y"; 
		  }else
		  {
		  causeOfDeathReg="N"; 
		  }
	  }
	  
	  }
	if(rset1!=null)rset1.close();
	if(stmt1!=null)stmt1.close();
	if(postmortem_type.equals("M"))
		{
	%> 
	<td style='background-color:maroon;color:white' width='3%'>&nbsp;P</td>
	<%}else if(postmortem_type.equals("C")){%>
	<td style='background-color:yellow;color:maroon' width='3%'>&nbsp;P</td>
	<%}else{%>
	<td>&nbsp;</Td>
	<%}%>
	<td><%=sCount++ %> </td><!-- 22856 -->
	<td class='<%=classValue%>' <%=colordisplay%>> <font size='1'><%=REGISTRATION_NO%></td>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size='1'><%=MO_REGN_DATE_TIME%></td>

	<%
		
	if(assign_area_code.equals("Unassigned"))
	{   if(callfrommoreg.equals("callfrommoreg")||callfrommoreg.equals("releaseDeceased") ||   callfrommoreg.equals("ExpoOfDeceased")||callfrommoreg.equals("callfrombdyprt"))
		{
	    if(brought_dead_yn.equals("Y"))
	    {%><!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
        <td  style='background-color:black;color:white;'>
		<a name='desc1' style="color:white" href='javascript:showOperations("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(bur_per_no)%>","<%=java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(causeOfDeathReg)%>","<%=external%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
	
		 <%}else
		   {%>
		<td class='<%=classValue%>' <%=colordisplay%>>
		<a name='desc1' href='javascript:showOperations("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(bur_per_no)%>","<%=java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(causeOfDeathReg)%>","<%=external%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
	 <%}}else		
		if(called_from_ca.equals("N")&&callfrommoreg.equals(""))
		{
	    if(brought_dead_yn.equals("Y"))
	    {%>		
		<td  style='background-color:black;'>
		<a name='desc1' style="color:white" 
		href='javascript:showAllowedOperations("a","<%=java.net.URLEncoder.encode(assign_area_desc)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(PATIENT_NAME)%>","<%=java.net.URLEncoder.encode(SEX)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(POSTMORTEM_STATUS)%>","<%=java.net.URLEncoder.encode(assign_area_code)%>","<%=java.net.URLEncoder.encode(AREA_TYPE)%>","<%=java.net.URLEncoder.encode(bed_no)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(or_installyn)%>","<%=java.net.URLEncoder.encode(order_catalog_code)%>","<%=java.net.URLEncoder.encode(encounter_id)%>")' > <font size=1><%=PATIENT_NAME%></a></td>
	<%	}else{%><!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
		<td class='<%=classValue%>' <%=colordisplay%>>
		<a name='desc1' href='javascript:showAllowedOperations("a","<%=java.net.URLEncoder.encode(assign_area_desc)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(PATIENT_NAME)%>","<%=java.net.URLEncoder.encode(SEX)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(POSTMORTEM_STATUS)%>","<%=java.net.URLEncoder.encode(assign_area_code)%>","<%=java.net.URLEncoder.encode(AREA_TYPE)%>","<%=java.net.URLEncoder.encode(bed_no)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(or_installyn)%>","<%=java.net.URLEncoder.encode(order_catalog_code)%>","<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' > <font size=1><%=PATIENT_NAME%></a></td>
		<%}
	
		}
		//if(called_from_ca.equals("Y") && count == 1) //modified for ML-BRU-SCF-0829 [IN:039636]
		if(called_from_ca.equals("Y"))
		{if(brought_dead_yn.equals("Y"))
	    {%>
	<td  style='background-color:black;'>
     <a name='desc1' style="color:white"  href='javascript:showChart("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(patient_class)%>","<%=java.net.URLEncoder.encode(patient_id)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
		<%}else{%>
	        <td class='<%=classValue%>' <%=colordisplay%>>
			<a name='desc1'href='javascript:showChart("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(patient_class)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
		<%}%>
	
	
	<%}//modified for ML-BRU-SCF-0829 [IN:039636] start
	//if(called_from_ca.equals("Y") && count == 0)
	//{ if(brought_dead_yn.equals("Y"))
	    //{%>
	   <!-- <td  style='background-color:black;color=white' > -->
		<!-- <font size=1><%=PATIENT_NAME%></td> -->	
	<%//}else{%>
	<%//}%>
	<!-- <td class='<%=classValue%>' <%=colordisplay%>>	 -->
		<!-- <font size=1><%=PATIENT_NAME%></td> -->
	<%//}//modified for ML-BRU-SCF-0829 [IN:039636] end
	}else {
		 if(callfrommoreg.equals("callfrommoreg")||callfrommoreg.equals("releaseDeceased") || callfrommoreg.equals("ExpoOfDeceased")||callfrommoreg.equals("callfrombdyprt"))
		{
	   if(brought_dead_yn.equals("Y"))
	    {%>	<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->	
		<td  style='background-color:black;'>
	   <a name='desc1' style='color:white' href='javascript:showOperations("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(bur_per_no)%>","<%=java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(causeOfDeathReg)%>","<%=external%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
	
	   <%}else{%><!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
	 	<td class='<%=classValue%>' <%=colordisplay%>>
		 <a name='desc1' href='javascript:showOperations("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(bur_per_no)%>","<%=java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(causeOfDeathReg)%>","<%=external%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
	
	   <%}
		
		}else	if(called_from_ca.equals("N")&&callfrommoreg.equals("")){
		
		 if(brought_dead_yn.equals("Y"))
	    {%>		
		 <!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
		 <td  style='background-color:black;color:white;'>
		 <a name='desc1' style='color:white'  href='javascript:showAllowedOperations("b","<%=java.net.URLEncoder.encode(assign_area_desc)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(PATIENT_NAME)%>","<%=java.net.URLEncoder.encode(SEX)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(POSTMORTEM_STATUS)%>","<%=java.net.URLEncoder.encode(assign_area_code)%>","<%=java.net.URLEncoder.encode(AREA_TYPE)%>","<%=java.net.URLEncoder.encode(bed_no)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(or_installyn)%>","<%=java.net.URLEncoder.encode(order_catalog_code)%>","<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' ><font size=1><%=PATIENT_NAME%></a></td>
		
		 <%}else{%>
		<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
		<td class='<%=classValue%>' <%=colordisplay%>>
		<a name='desc1'  href='javascript:showAllowedOperations("b","<%=java.net.URLEncoder.encode(assign_area_desc)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(PATIENT_NAME)%>","<%=java.net.URLEncoder.encode(SEX)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(POSTMORTEM_STATUS)%>","<%=java.net.URLEncoder.encode(assign_area_code)%>","<%=java.net.URLEncoder.encode(AREA_TYPE)%>","<%=java.net.URLEncoder.encode(bed_no)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(or_installyn)%>","<%=java.net.URLEncoder.encode(order_catalog_code)%>","<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' ><font size=1><%=PATIENT_NAME%></a></td>
		 <%}
		}else if(callfrommoreg.equals("RevertRelease")) {%>
		<td class='<%=classValue%>' <%=colordisplay%>>
		<a name='desc1'  href='javascript:RevertRelease("<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>")' ><font size=1><%=PATIENT_NAME%></a></td>
		 <%}
		//if(called_from_ca.equals("Y") && count == 1){//modified for ML-BRU-SCF-0829 [IN:039636]
		if(called_from_ca.equals("Y") ){
		if(brought_dead_yn.equals("Y"))
	    {%>
			<td  style='background-color:black;color:white'>
		    <a name='desc1' style='color:white' ; href="javascript:showChart('<%=encounter_id%>','<%=patient_class%>','<%=java.net.URLEncoder.encode(PATIENT_ID)%>')" ><font size=1><%=PATIENT_NAME%></a></td>
		<%}else{%>
			
		<td class='<%=classValue%>' <%=colordisplay%>>
		<a name='desc1' href="javascript:showChart('<%=encounter_id%>','<%=patient_class%>','<%=java.net.URLEncoder.encode(PATIENT_ID)%>')" ><font size=1><%=PATIENT_NAME%></a></td>
		<%}}//modified for ML-BRU-SCF-0829 [IN:039636] 
		//if(called_from_ca.equals("Y") && count == 0){
		//if(brought_dead_yn.equals("Y"))
	    //{%>
		<!-- <td  style='background-color:black;color:white'>
		<font size=1><%=PATIENT_NAME%></td> -->
		<%//}else
			//{%>
			<!-- <td class='<%=classValue%>' <%=colordisplay%>  ><font size=1><%=PATIENT_NAME%></td> -->
			
		<%//}}
		}%>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=PATIENT_ID%></td>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=AGE%></td>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=SEX%></td>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=pm_yn_converted%></td>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=POSTMORTEM_STATUS_DESC%></td> 
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1>&nbsp;&nbsp;<%=no_days_mortuary%>&nbsp;&nbsp;&nbsp;<%=hours_minutes%></td>
	<td class='<%=classValue%>' <%=colordisplay%> nowrap> <font size=1><%=RELIGION%></td>
	<%if(encounter_id.equals(""))
     {%>
	 <td class='<%=classValue%>' <%=colordisplay%>> <font size=1>&nbsp;</td>
	 <%}else
		{%>
			<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=encounter_id%></td>
		<%}%>
	<%if(bed_no.equals(""))
     {%>
	 <td class='<%=classValue%>' <%=colordisplay%>> <font size=1>&nbsp;</td>
	 <%}else
		{%>
			<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=bed_no%></td>
		<%}%>
		<%
		if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
		{
		if(rfid_tag_num.equals(""))
     {%>
	 <td class='<%=classValue%>' <%=colordisplay%>> <font size=1>&nbsp;</td>
	 <%}else
		{%>
			<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=rfid_tag_num%></td>
		<%}
		}
		%>
	<%if(!obtained_from.equals("C"))
     {%>
	<td class='<%=classValue%>' <%=colordisplay%>><font size=1> <%=BODY_PART_OBTAINED_FROM_DESC%></td>
	<%}%>

	<%if(bur_per_no.equals(""))
     {%>
	 <td class='<%=classValue%>' <%=colordisplay%>> <font size=1>&nbsp;</td>
	 <%}else
		{%><!--Style Added by Santhosh for ML-MMOH-CRF-1947>-->
			<td class='<%=classValue%>' <%=colordisplay%> style='word-wrap:break-word;width:300px;'> <font size=1><%=bur_per_no%></td>
		<%}%>
		</tr>
	<%			
	l++;
		}
		
		
	  if(rset!=null) rset.close();
	  if(stmt!=null) stmt.close();
	i++;
	}



	   }else 
		{  
          sql.setLength(0);	  
	      sql.append("   where NVL(BODY_PART_OBTAINED_FROM,'*') like '"+BODY_PART_OBTAINED_FROM+"%' and postmortem_status like '"+pmstatus+"%'  and facility_id='"+fac_id+"' and NVL(area_code,decode(registration_no,null,'$','*')) like '"+area_code+"%' and NVL(patient_id,'*') like '"+patient_id+"%' and sex like '"+gender+"%' and registration_no like '"+registration_id+"%' and NVL(AREA_TYPE,'*') like '"+atype+"%' and to_date(substr(BODY_RECEIVED_DATE,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy' )"); 
	     
		 

	  if(!todate.equals(""))
		{
		  sql.append(" and to_date('"+todate+"','dd/mm/yyyy')");
		}else
		{
		 sql.append(" and sysdate");
		}

		sql.append("and (('"+rstatus+"' is null) or ( '"+rstatus+"' is not null and '"+rstatus+"'='C' and release_body_date is null) or ('"+rstatus+"' is not null and '"+rstatus+"'='R' and release_body_date is not null ))");
	    
		 if(callfrommoreg.equals("releaseDeceased"))
		 {
			 sql.append("  AND area_type = 'R'  ");
		 }
		 if(callfrommoreg.equals("ExpoOfDeceased"))
		 {
			 sql.append("  AND exportation_doc_iss_date IS NULL AND exportation_reqd_yn = 'Y'  ");
		 }
        if(obtained_from.equals("C"))
         {
              sql.append(" and  BODY_PART_OBTAINED_FROM is  null");
         }else if(obtained_from.equals("A")||obtained_from.equals("U")||obtained_from.equals("D"))
          {
            sql.append(" and  BODY_PART_OBTAINED_FROM like '"+obtained_from+"%'");
          }else  if(callfrommoreg.equals(""))
	      {
	      } else  if(callfrommoreg.equals("callfrombdyprt"))
	      {
	        sql.append(" and  BODY_PART_OBTAINED_FROM is not null");
	      }else if(callfrommoreg.equals("callfrommoreg"))
	      { sql.append(" and  BODY_PART_OBTAINED_FROM is  null");
	      }

	
		sql.append(" and  NVL(BURIAL_PERMIT_NO,'*') LIKE '"+burial_permit_no+"%'");
		sql.append(" order by area_code,registration_no");	  
    	sql1.append("select count(*) as total from MO_MORTUARY_REGN_VW");
	    sql1.append(sql.toString());
		stmt	 = conn.createStatement();
	    rset = stmt.executeQuery(sql1.toString());	
	    sql1.setLength(0);
	    if(rset.next())
	    maxRecord = rset.getInt("total");
	    if(maxRecord == 0) 
			{
			%>
	      <script>//parent.MOFrame.location.href='../../eCommon/html/blank.html';
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script> 
	    <%
			}
		else 
		{ 
			%>
			 <script>
					/*var oldurl = 	parent.MOFrame.location.href;
					if(oldurl.indexOf("blank.html")!=-1)
					{
							
							parent.MOFrame.location.href='../../eMO/jsp/MOManagePatTabs.jsp';
					}*/

			</script> 
			<%
     	//sql1.append("select BODY_PART_OBTAINED_FROM,BURIAL_PERMIT_NO,BROUGHT_DEAD_YN, MO_GET_DESC.MO_AREA('"+fac_id+"',AREA_CODE,'"+localeName+"','2') AREA_DESC,AREA_CODE,HIGH_RISK_BODY_YN,area_type_desc,REGISTRATION_NO,body_received_date,decode('"+localeName+"', 'en', PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG, PATIENT_NAME))  PATIENT_NAME,PATIENT_ID,AGE,SEX,PM_YN,POSTMORTEM_STATUS,POSTMORTEM_STATUS_DESC,AREA_TYPE,BED_NO,encounter_id,dispose_body_yn,MLC_YN,POSTMORTEM_TYPE,BODY_PART_OBTAINED_FROM_DESC, POSTMORTEM_TYPE_DESC, 'REGD' STATUS, RELEASE_BODY_DATE, ORDER_CATALOG_CODE,RFID_TAG_NUM,EXTERNAL_YN from MO_MORTUARY_REGN_VW");
		sql1.append("select BODY_PART_OBTAINED_FROM,BURIAL_PERMIT_NO,BROUGHT_DEAD_YN, MO_GET_DESC.MO_AREA('"+fac_id+"',AREA_CODE,'"+localeName+"','2') AREA_DESC,AREA_CODE,HIGH_RISK_BODY_YN,area_type_desc,REGISTRATION_NO,body_received_date,decode('"+localeName+"', 'en', PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG, PATIENT_NAME))  PATIENT_NAME,PATIENT_ID,AGE,SEX,PM_YN,POSTMORTEM_STATUS,POSTMORTEM_STATUS_DESC,AREA_TYPE,BED_NO,encounter_id,dispose_body_yn,MLC_YN,POSTMORTEM_TYPE,BODY_PART_OBTAINED_FROM_DESC, POSTMORTEM_TYPE_DESC, 'REGD' STATUS, RELEASE_BODY_DATE,RFID_TAG_NUM,EXTERNAL_YN from MO_MORTUARY_REGN_VW");

		
	    sql1.append(sql.toString());
		stmt	 = conn.createStatement();
		rset = stmt.executeQuery(sql1.toString());
	    sql1.setLength(0);
	  %>
	
	 	<p>
    <table align='right'>
    <tr>
    <td>
	
    <%
if ( !(start <= 1) )
	out.println("<A HREF='../jsp/MOManageDeceasedSearchResult.jsp?function_id="+function_id+"&from="+(start-8)+"&to="+(end-8)+"&area_code="+URLEncoder.encode(area_code)+"&registration_no="+URLEncoder.encode(registration_id)+"&patient_id="+URLEncoder.encode(patient_id)+"&burial_permit_no="+URLEncoder.encode(burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&gender="+URLEncoder.encode(gender)+"&called_from_ca="+URLEncoder.encode(called_from_ca)+"&callfrommoreg="+URLEncoder.encode(callfrommoreg)+"&body_part_obtained_from="+URLEncoder.encode(BODY_PART_OBTAINED_FROM)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&atype="+URLEncoder.encode(atype)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+8) > maxRecord ) )
	out.println("<A HREF='../jsp/MOManageDeceasedSearchResult.jsp?function_id="+function_id+"&from="+(start+8)+"&to="+(end+8)+"&area_code="+URLEncoder.encode(area_code)+"&registration_no="+URLEncoder.encode(registration_id)+"&patient_id="+URLEncoder.encode(patient_id)+"&burial_permit_no="+URLEncoder.encode(burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&gender="+URLEncoder.encode(gender)+"&called_from_ca="+URLEncoder.encode(called_from_ca)+"&callfrommoreg="+URLEncoder.encode(callfrommoreg)+"&body_part_obtained_from="+URLEncoder.encode(BODY_PART_OBTAINED_FROM)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&atype="+URLEncoder.encode(atype)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table >
</p>
<BR><BR>
	  <!-- backgroundheader added by shagar for ML-MMOH-CRF-0749-->
	  <table border="1" width="115%" cellspacing='1px' cellpadding='0'>
	<th <%=backgroundheader%>>&nbsp;</th>
	<th <%=backgroundheader%>> <fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></th> 
	<th <%=backgroundheader%>><fmt:message key="Common.RegnDate/Time.label" bundle="${common_labels}"/></th>
	<th <%=backgroundheader%> align = "center">
	<%if(obtained_from.equals("C"))
     {%>
	<fmt:message key="Common.deceased.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/>
	 <%}else{%>
	<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
	<%}%>
	</td>

	<th <%=backgroundheader%>><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="eMO.PMYN.label" bundle="${mo_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="eMO.PostmortemStatus.label" bundle="${mo_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
	<th <%=backgroundheader%>><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
	<%
	if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
	{
	%>
	<th <%=backgroundheader%>><fmt:message key="eMO.RFIDTag.label" bundle="${mo_labels}"/> </th>
	<%
	}
	if(!obtained_from.equals("C"))
     {%>
	<th <%=backgroundheader%>><fmt:message key="eMO.BodyPartType.label" bundle="${mo_labels}"/> </th>
	 <%}%>
	<th <%=backgroundheader%>><fmt:message key="eMO.BurialPermitNo.label" bundle="${mo_labels}"/> </th>
	<%
	String classValue	= "";
	int rowIndex		= 1;
	
	for( int j=1; j<start; l++,j++ ){
	rset.next() ;
    }
	
	
	while (rset.next()&&l<=end)
	{
	classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
	rowIndex++;
	dispose_body_yn		= rset.getString("dispose_body_yn");
	dispose_body_yn= (dispose_body_yn == null)?"":dispose_body_yn;
	assign_area_desc		= rset.getString("AREA_DESC");
	assign_area_desc 		= (assign_area_desc == null)?"":assign_area_desc;
	assign_area_code		= rset.getString("AREA_CODE");
	assign_area_code 		= (assign_area_code == null)?"":assign_area_code;
	BDY_PRT_OBT_FROM =rset.getString("BODY_PART_OBTAINED_FROM")==null?"":rset.getString("BODY_PART_OBTAINED_FROM");
	REGISTRATION_NO			= rset.getString("REGISTRATION_NO"); 
	REGISTRATION_NO 		= (REGISTRATION_NO == null)?"":REGISTRATION_NO;
	//BODY_PART_OBTAINED_FROM_DESC		= rset.getString("BODY_PART_OBTAINED_FROM_DESC");
	//BODY_PART_OBTAINED_FROM_DESC=(BODY_PART_OBTAINED_FROM_DESC == null)?"":BODY_PART_OBTAINED_FROM_DESC;
	if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("A"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.AmputatedBodyPart.label","mo_labels");
	else if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("D"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.DeadFetus.label","mo_labels");
	else if(BDY_PRT_OBT_FROM!=null && !BDY_PRT_OBT_FROM.equals("") && BDY_PRT_OBT_FROM.equals("U"))
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.UnidentifiedBodyPart.label","mo_labels");
	else 
		BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");

	bur_per_no						= rset.getString("BURIAL_PERMIT_NO");
	bur_per_no 					= (bur_per_no == null)?"":bur_per_no;
	brought_dead_yn= rset.getString("brought_dead_yn")==null?"":rset.getString("brought_dead_yn");
	//area_type_desc          = rset.getString("AREA_TYPE_DESC")==null?"":rset.getString("AREA_TYPE_DESC");
	highriskbody 		=  rset.getString("HIGH_RISK_BODY_YN")==null?"":rset.getString("HIGH_RISK_BODY_YN"); 
	if(highriskbody.equals("Y"))
		{
	colordisplay="style='background-color:orange'";
		}else 
		{
		colordisplay="";
	}
	MO_REGN_DATE_TIME		= rset.getString("body_received_date"); 
	MO_REGN_DATE_TIME 		= (MO_REGN_DATE_TIME == null)?"":MO_REGN_DATE_TIME;
	if(MO_REGN_DATE_TIME!=null && !MO_REGN_DATE_TIME.equals(""))
		MO_REGN_DATE_TIME	=  DateUtils.convertDate(MO_REGN_DATE_TIME,"DMYHM","en",localeName); 
	PATIENT_NAME			= rset.getString("PATIENT_NAME");
	PATIENT_NAME 			= (PATIENT_NAME == null)?"":PATIENT_NAME;
	PATIENT_ID				= rset.getString("PATIENT_ID");
	PATIENT_ID 				= (PATIENT_ID == null)?"":PATIENT_ID;
	AGE						= rset.getString("AGE");
	AGE 					= (AGE == null)?"":AGE;
	SEX						= rset.getString("SEX");
	SEX 					= (SEX == null)?"":SEX;
	if(SEX!=null && !SEX.equals("") && SEX.equals("Male"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(SEX!=null && !SEX.equals("") && SEX.equals("Female"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(SEX!=null && !SEX.equals("") && SEX.equals("Unknown"))
		SEX = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

		//sex_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

	PM_YN					= rset.getString("PM_YN");
	PM_YN 					= (PM_YN == null)?"":PM_YN;	
	if(PM_YN!=null && !PM_YN.equals("") && PM_YN.equals("N"))
		pm_yn_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
	else if(PM_YN!=null && !PM_YN.equals("") && PM_YN.equals("Y"))
		pm_yn_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");

	//assign_area_desc		= rset.getString("AREA_DESC");
	//assign_area_desc 		= (assign_area_desc == null)?"":assign_area_desc;
	POSTMORTEM_STATUS		= rset.getString("POSTMORTEM_STATUS");
	POSTMORTEM_STATUS 		= (POSTMORTEM_STATUS == null)?"":POSTMORTEM_STATUS;
	//POSTMORTEM_STATUS_DESC		= rset.getString("POSTMORTEM_STATUS_DESC");
	//POSTMORTEM_STATUS_DESC 		= (POSTMORTEM_STATUS_DESC == null)?"":POSTMORTEM_STATUS_DESC;
	
	if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("N"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("A"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.NotRequested.label","mo_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("R"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("S"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("E"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
	else if(POSTMORTEM_STATUS!=null && !POSTMORTEM_STATUS.equals("") && POSTMORTEM_STATUS.equals("C"))
		POSTMORTEM_STATUS_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

	AREA_TYPE		= rset.getString("AREA_TYPE");
	AREA_TYPE 		= (AREA_TYPE == null)?"":AREA_TYPE;

	if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("R"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("S"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StorageArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("P"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemArea.label","mo_labels");
	else if(AREA_TYPE!=null && !AREA_TYPE.equals("") && AREA_TYPE.equals("O"))
		area_type_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");

	bed_no			= rset.getString("BED_NO");
	bed_no 			= (bed_no == null)?"":bed_no;
	encounter_id	= rset.getString("encounter_id");
	encounter_id	= (encounter_id == null)?"":encounter_id;
	postmortem_type         = rset.getString("POSTMORTEM_TYPE")==null?"":rset.getString("POSTMORTEM_TYPE");   
	
	rfid_tag_num         = rset.getString("RFID_TAG_NUM")==null?"":rset.getString("RFID_TAG_NUM");   
	//mlc_yn=rset.getString("mlc_yn")==null?"":rset.getString("mlc_yn");   
	external=rset.getString("EXTERNAL_YN")==null?"N":rset.getString("EXTERNAL_YN"); 
	if(called_from_ca.equals("Y"))
	{
		sql2.append("SELECT count(*) from MO_MORTUARY_REGN_VW where facility_id='"+fac_id+"' and encounter_id = '"+encounter_id+"' and 	registration_no='"+REGISTRATION_NO+"'");
		//and ATTEND_PRACTITIONER_ID is not null"); //modified for ML-BRU-SCF-0829 [IN:039636]
		stmt1 = conn.createStatement();
		rset1 = stmt1.executeQuery(sql2.toString());
		while(rset1.next())
		{
			count = rset1.getInt(1);
		}
		 if(stmt1!=null) stmt1.close();
	     if(rset1!=null) rset1.close();
	}
	sql2.setLength(0);
	sql2.append("select patient_class from pr_encounter where encounter_id = '"+encounter_id+"' and facility_id='"+fac_id+"'");
	stmt1 = conn.createStatement();
	rset1 = stmt1.executeQuery(sql2.toString());
	patient_class="";//modified for ML-BRU-SCF-0829 [IN:039636]
	while(rset1.next())
	{
	 patient_class = rset1.getString(1);
	}
	//modified for ML-BRU-SCF-0829 [IN:039636] - start
	if(patient_class != null && patient_class.equals("")){
		patient_class="XT";
		encounter_id="";
	}
	//modified for ML-BRU-SCF-0829 [IN:039636] - end
	     if(stmt1!=null) stmt1.close();
	     if(rset1!=null) rset1.close();
	sql2.setLength(0);
	
	if(!encounter_id.equals(""))
	 {
	String deathcnt="Select count(*) cnt from PR_DIAGNOSIS_ENC_DTL where  FACILITY_ID='"+fac_id+"' and   ENCOUNTER_ID='"+encounter_id+"' and CAUSE_OF_DEATH_YN='Y'";
	stmt1	 = conn.createStatement();
	rset1 = stmt1.executeQuery(deathcnt);
	 
	 if(rset1.next())
	  {
	  cnt= rset1.getInt("cnt");
		  if(cnt>0)
		  {
		  causeOfDeathReg="Y"; 
		  }else
		  {
		  causeOfDeathReg="N"; 
		  }
	  }
	 }
	
	
	if(rset1!=null)rset1.close();
	if(stmt1!=null)stmt1.close();
	if(assign_area_code.equals("") &&(!REGISTRATION_NO.equals("")))
		{
		assign_area_code="Unassigned";
		assign_area_code_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
		}
	
	if(REGISTRATION_NO.equals(""))
		{
		assign_area_code="Unregistered";
		assign_area_code_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Unregistered.label","mo_labels");
		}
	
	if(assign_area_code.equals(assign_area_code_prev)){}
	else{
		assign_area_code_prev=assign_area_code;
	if(assign_area_code.equals("Unassigned")||assign_area_code.equals("Unregistered"))
	{%>
		<tr><th <%=backgroundheader%> colspan=13 align=left><B><%=assign_area_code_desc%></B></th></tr>
	<%}else {%>
	<tr><th <%=backgroundheader%> colspan=13 align=left><B><%=assign_area_desc%>/<%=assign_area_code_desc%>/<%=area_type_desc%></B></th></tr>
	<tr>
	<%}%>
	<%

	} 
		
	if(postmortem_type.equals("M"))
		{
	%> 
	<td style='background-color:maroon;color:white' width=3%>&nbsp;P</td>
	<%}else if(postmortem_type.equals("C")){%>
	<td style='background-color:yellow;color:maroon' width=3%>&nbsp;P</td>
	<%}else{%>
	<td>&nbsp;</Td>
	<%}%>
	<td class='<%=classValue%>' <%=colordisplay%> > <font size=1><%=REGISTRATION_NO%></td>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=MO_REGN_DATE_TIME%></td>
	
	<%
	if(assign_area_code.equals("Unassigned"))
	{   if(callfrommoreg.equals("callfrommoreg")||callfrommoreg.equals("releaseDeceased") || callfrommoreg.equals("ExpoOfDeceased")||callfrommoreg.equals("callfrombdyprt"))
		{
	    if(brought_dead_yn.equals("Y")){%>
		<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
		<td  style='background-color:black;color:white;'>
		
		<a name='desc1'style="color:white"  href='javascript:showOperations("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(bur_per_no)%>","<%=java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(causeOfDeathReg)%>","<%=external%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
        <%}else{%>	
		<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
		<td class='<%=classValue%>' <%=colordisplay%>>
		<a name='desc1' href='javascript:showOperations("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(bur_per_no)%>","<%=java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(causeOfDeathReg)%>","<%=external%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
        
		<%}%>
		<%}else		
		if(called_from_ca.equals("N")&&callfrommoreg.equals(""))
		{if(brought_dead_yn.equals("Y")){%>
		<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
		<td  style='background-color:black;color:white;'>
		<a name='desc1' style='color:white' href='javascript:showAllowedOperations("a","<%=java.net.URLEncoder.encode(assign_area_desc)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(PATIENT_NAME)%>","<%=java.net.URLEncoder.encode(SEX)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(POSTMORTEM_STATUS)%>","<%=java.net.URLEncoder.encode(assign_area_code)%>","<%=java.net.URLEncoder.encode(AREA_TYPE)%>","<%=java.net.URLEncoder.encode(bed_no)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(or_installyn)%>","<%=java.net.URLEncoder.encode(order_catalog_code)%>","<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' > <font size=1><%=PATIENT_NAME%></a></td>
		<%}else{	%>		
		<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
		<td class='<%=classValue%>' <%=colordisplay%>>
		<a name='desc1'  href='javascript:showAllowedOperations("a","<%=java.net.URLEncoder.encode(assign_area_desc)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(PATIENT_NAME)%>","<%=java.net.URLEncoder.encode(SEX)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(POSTMORTEM_STATUS)%>","<%=java.net.URLEncoder.encode(assign_area_code)%>","<%=java.net.URLEncoder.encode(AREA_TYPE)%>","<%=java.net.URLEncoder.encode(bed_no)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(or_installyn)%>","<%=java.net.URLEncoder.encode(order_catalog_code)%>","<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' > <font size=1><%=PATIENT_NAME%></a></td>
		
	<%
		}}
		
		//if(called_from_ca.equals("Y") && count == 1) //modified for ML-BRU-SCF-0829 [IN:039636]
		if(called_from_ca.equals("Y") )
			{
			
			if(brought_dead_yn.equals("Y")){%>
		<td  style='background-color:black;color:white;'>
		<a name='desc1' style="color:white" href='javascript:showChart("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(patient_class)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
		
			<%}else{%>
		<td class='<%=classValue%>' <%=colordisplay%>><a name='desc1' href='javascript:showChart("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(patient_class)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
		<%}%>
		
	<%}//modified for ML-BRU-SCF-0829 [IN:039636]
	//if(called_from_ca.equals("Y") && count == 0)
	//{%>
		<!-- <font size=1><%=PATIENT_NAME%> -->
		<%//}
	}else {%>
		<%
		 if(callfrommoreg.equals("callfrommoreg")||callfrommoreg.equals("releaseDeceased") || callfrommoreg.equals("ExpoOfDeceased")||callfrommoreg.equals("callfrombdyprt"))
		{ if(brought_dead_yn.equals("Y")){%>
		<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
		<td  style='background-color:black;color:white;'>
		<a name='desc1'style="color:white"  
	   href='javascript:showOperations("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(bur_per_no)%>","<%=java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(causeOfDeathReg)%>","<%=external%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
	<%}else	{%>
	<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
	<td class='<%=classValue%>' <%=colordisplay%>>
	   <a name='desc1' href='javascript:showOperations("<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(bur_per_no)%>","<%=java.net.URLEncoder.encode(BDY_PRT_OBT_FROM)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(causeOfDeathReg)%>","<%=external%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' > <font size=1><%=PATIENT_NAME%></a></td>	
		<%}
		}else	if(called_from_ca.equals("N")&&callfrommoreg.equals("")){
		if(brought_dead_yn.equals("Y")){%>
			{<td  style='background-color:black;color:white;'>
		<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
		<a name='desc1'style="color:white"  
	  href='javascript:showAllowedOperations("b","<%=java.net.URLEncoder.encode(assign_area_desc)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(PATIENT_NAME)%>","<%=java.net.URLEncoder.encode(SEX)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(POSTMORTEM_STATUS)%>","<%=java.net.URLEncoder.encode(assign_area_code)%>","<%=java.net.URLEncoder.encode(AREA_TYPE)%>","<%=java.net.URLEncoder.encode(bed_no)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(or_installyn)%>","<%=java.net.URLEncoder.encode(order_catalog_code)%>","<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' ><font size=1><%=PATIENT_NAME%></a></td>}
		<%}else{%>
		<!--Below Script Condition Changed Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
		<td class='<%=classValue%>' <%=colordisplay%>>
	   <a name='desc1' href='javascript:showAllowedOperations("b","<%=java.net.URLEncoder.encode(assign_area_desc)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(PATIENT_NAME)%>","<%=java.net.URLEncoder.encode(SEX)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(POSTMORTEM_STATUS)%>","<%=java.net.URLEncoder.encode(assign_area_code)%>","<%=java.net.URLEncoder.encode(AREA_TYPE)%>","<%=java.net.URLEncoder.encode(bed_no)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(or_installyn)%>","<%=java.net.URLEncoder.encode(order_catalog_code)%>","<%=java.net.URLEncoder.encode(encounter_id)%>","<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>","<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>")' ><font size=1><%=PATIENT_NAME%></a></td>
		<%}
		}else if(callfrommoreg.equals("RevertRelease")) {%>
		<td class='<%=classValue%>' <%=colordisplay%>>
		<a name='desc1'  href='javascript:RevertRelease("b","<%=java.net.URLEncoder.encode(assign_area_desc)%>","<%=java.net.URLEncoder.encode(REGISTRATION_NO)%>","<%=java.net.URLEncoder.encode(PATIENT_NAME)%>","<%=java.net.URLEncoder.encode(SEX)%>","<%=java.net.URLEncoder.encode(PM_YN)%>","<%=java.net.URLEncoder.encode(POSTMORTEM_STATUS)%>","<%=java.net.URLEncoder.encode(assign_area_code)%>","<%=java.net.URLEncoder.encode(AREA_TYPE)%>","<%=java.net.URLEncoder.encode(bed_no)%>","<%=java.net.URLEncoder.encode(PATIENT_ID)%>","<%=java.net.URLEncoder.encode(or_installyn)%>","<%=java.net.URLEncoder.encode(order_catalog_code)%>","<%=java.net.URLEncoder.encode(encounter_id)%>")' ><font size=1><%=PATIENT_NAME%></a></td>
		 <%}
		//if(called_from_ca.equals("Y") && count == 1){ //modified for ML-BRU-SCF-0829 [IN:039636]
		if(called_from_ca.equals("Y") && count == 1){
	
		if(brought_dead_yn.equals("Y")){%>
			<td  style='background-color:black;color:white;'>
		   <a name='desc1'  style='color:white;'href="javascript:showChart('<%=encounter_id%>','<%=patient_class%>','<%=java.net.URLEncoder.encode(PATIENT_ID)%>')" ><font size=1><%=PATIENT_NAME%></a></td>
			<%}else{%>
		<td class='<%=classValue%>' <%=colordisplay%>>
			<a name='desc1' href="javascript:showChart('<%=encounter_id%>','<%=patient_class%>','<%=java.net.URLEncoder.encode(PATIENT_ID)%>')" ><font size=1><%=PATIENT_NAME%></a></td>
		<%}%>	
		<%}//modified for ML-BRU-SCF-0829 [IN:039636] 
		//if(called_from_ca.equals("Y") && count == 0){
			//if(brought_dead_yn.equals("Y")){
			%><!-- <td  style='background-color:black;color:white;'> -->
		<!-- <font size=1><%=PATIENT_NAME%></td> -->
			<%//}else{%>
		<!-- <font size=1><%=PATIENT_NAME%></td> -->
			<%//}%>
		
		<%//}
		}%>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=PATIENT_ID%></td>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=AGE%></td>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=SEX%></td>
	<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=pm_yn_converted%></td>
	<td class='<%=classValue%>'<%=colordisplay%>> <font size=1><%=POSTMORTEM_STATUS_DESC%></td>
	<%if(encounter_id.equals(""))
     {%>
	 <td class='<%=classValue%>' <%=colordisplay%>> <font size=1>&nbsp;</td>
	 <%}else
		{%>
			<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=encounter_id%></td>
		<%}%>
	<%if(bed_no.equals(""))
     {%>
	 <td class='<%=classValue%>' <%=colordisplay%>> <font size=1>&nbsp;</td>
	 <%}else
		{%>
			<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=bed_no%></td>
		<%}%>
		<%
		if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
		{
		if(rfid_tag_num.equals(""))
     {%>
	 <td class='<%=classValue%>' <%=colordisplay%>> <font size=1>&nbsp;</td>
	 <%}else
		{%>
			<td class='<%=classValue%>' <%=colordisplay%>> <font size=1><%=rfid_tag_num%></td>
		<%}
		}
		%>
	
	<%if(!obtained_from.equals("C"))
     {%>
	<td class='<%=classValue%>' <%=colordisplay%>><font size=1> <%=BODY_PART_OBTAINED_FROM_DESC%></td>
	<%}%>

	<%if(bur_per_no.equals(""))
     {%>
	 <td class='<%=classValue%>' <%=colordisplay%>> <font size=1>&nbsp;</td>
	 <%}else
		{%><!--Style Added by Santhosh for ML-MMOH-CRF-1947>-->
			<td class='<%=classValue%>' <%=colordisplay%> style='word-wrap:break-word;width:300px;'> <font size=1><%=bur_per_no%></td>
		<%}%>
		</tr>
	<%			
	l++;
		}
		
		if(rset!=null) rset.close();
	  if(stmt!=null) stmt.close();
	i++;
	

	
	}
	}
	%>
	</table>
	
	
	<br><center>
	<%	  if(callfrommoreg.equals("callfrombdyprt"))
	  { %>
	<script>parent.frames[0].document.forms[0].search.disabled=false</script>
	  <%}else{%>
	<script>parent.frames[1].document.forms[0].search.disabled=false</script>
	<%}%>
	<%  
		if (rset != null ) rset.close() ;
		if (rset1!= null)  rset1.close();
		if (stmt != null ) stmt.close() ;	
		if (stmt1!= null)  stmt1.close();
	}	
	catch ( Exception e ){
		out.println("Exception in MOManageDeceasedSearchResult "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}
	%>
	</center>
<input type='hidden' name='called_from_ca' id='called_from_ca' value=<%=called_from_ca%>>
<input type='hidden' name='parameters' id='parameters' value=<%=parameters%>>
<input type='hidden' name='callfrommoreg' id='callfrommoreg' value="<%=callfrommoreg%>">
<input type='hidden' name='registration_no' id='registration_no' value="<%=REGISTRATION_NO%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<input type='hidden' name='burial_permit_reqd_yn' id='burial_permit_reqd_yn' value="<%=burial_permit_reqd_yn%>">

    <% 
	if(callfrommoreg.equals("") || callfrommoreg.equals("releaseDeceased")  ){%>
	
	<input type='hidden' name='queue_refresh_interval' id='queue_refresh_interval' value="<%=queue_refresh_interval%>">
 <% } %>
<input type='hidden' name='embalm_completed' id='embalm_completed' id="embalm_completed" value="">
<!-- Below line added for this ML-MMOH-CRF-0860.2-->
<input type='hidden' name='increasedaddressLength' id='increasedaddressLength' id="increasedaddressLength" value="<%=increasedaddressLength%>"> 

</form>
</body>

</html>

<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>


