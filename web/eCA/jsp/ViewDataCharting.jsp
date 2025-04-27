<!DOCTYPE html>
<%
/*  							 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		Vijay K												SKR-CRF-0036
17/06/2014	  IN049714		Nijitha												OPD/AE Medical Record
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.text.*,java.io.*,java.sql.*,webbeans.eCommon.*,java.util.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String strTitle = "";
	String called_from = request.getParameter("called_from");
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//SPC
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<%if(!"CA_SPC".equals(p_called_from)){%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<%}%>
<%
	String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
	String content_ID = request.getParameter("content_ID");
	String sessionStyle = "";
	if(!"".equals(prefStyleSheet))
	{
		sessionStyle=prefStyleSheet;
	}
%>

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCA/js/DisDataCharting.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
			function printpage()
			{
				window.print()
			}

			function clearLayer()
			{
				hidePopUp();
			}
			function showToolTip(obj,objcount,text)
			{	
				if(text.length>15)
				{
					var tab_dat  = "<table class='grid' id='tooltiptable1'  width='' height='10' align='center'>"
					tab_dat   =  tab_dat+"<tr bgcolor='lightyellow' >" ;
					tab_dat    = tab_dat+ "<td class = 'contextMenuItem' style='padding-left:10px;padding-right:10px' >"+text+"</td>" ;
					tab_dat     =tab_dat+ "</tr>" ;		
					tab_dat     =tab_dat+ "</table> ";		
			
					document.getElementById("descLink").innerHTML = tab_dat;	
					document.getElementById("descLink").style.top  = obj.offsetTop;
					if(objcount=="5")
					{
						document.getElementById("descLink").style.left  = obj.offsetLeft+37;
					}
					else
					{
						document.getElementById("descLink").style.left  = obj.offsetLeft+80;
					}
					document.getElementById("descLink").style.visibility='visible' ;
				}
				else
				{
					hidePopUp();
				}
			}

			function hidePopUp()
			{
				if(document.getElementById("descLink"))
					document.getElementById("descLink").style.visibility='hidden' ;
			}
			function scrollTitle()	
			{
				var scrollXY = document.body.scrollTop;	
				document.getElementById("divTitleTable").style.position = 'relative';
				document.getElementById("divTitleTable").style.posTop  = scrollXY-2;	
			}

	</script>
	

<%
    Connection con =null;
	try
	{
		String login_user = p.getProperty( "login_user" ) ;
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rset=null ;
		PreparedStatement stmt  = null;
		PreparedStatement stmt1 = null;
		
		ResultSet rset1 = null ;
    
		PreparedStatement pstmtCheck = null;
		String past_visit   = "";
		String patientline  = "";
		String dob		    = "";	
		String sex		    = "";			
		String qs = request.getQueryString();
		String lastrecorddate = "";
		String qs1 = qs;
		String facilityid = (String) session.getValue("facility_id");
		String pat_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String visitid = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
		String Patient_Id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
		if(visitid.equals("")) visitid="";
		String[] pat_details;
		String clinicianid		=	(String) session.getAttribute("ca_practitioner_id") == null ? "" : (String) session.getAttribute("ca_practitioner_id");
		String episodetype = request.getParameter("episode_type")==null?"I":request.getParameter("episode_type");
		String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		if(visitid.equals("") && episodetype.equals("I")) visitid = "1";
		String batteryid = "";
		String patientid = request.getParameter("patient_id");
		String admdttime = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
		String locncode = request.getParameter("location_code")==null?"": request.getParameter("location_code");
		String patsex = request.getParameter("patsex")==null?"U": request.getParameter("patsex");
		String out_mode = request.getParameter("out_mode")==null?"": request.getParameter("out_mode");
		String newlastrecorddate = request.getParameter("new_last_record_date")==null?"":request.getParameter("new_last_record_date");
		String location_type = request.getParameter("location_type")==null?"": request.getParameter("location_type");
		String patient_name = request.getParameter("pat_name")==null?"": request.getParameter("pat_name");
		String patient_age = request.getParameter("patient_age")==null?"": request.getParameter("patient_age");
		String pat_sex = request.getParameter("pat_sex")==null?"": request.getParameter("pat_sex");
		String option_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");
		String readOnly = "";
		String errorRemarks = "";
		String longTextVal = "";
		String legend_type = "";
		
		String accessionnum = "" ;                  
		String discrmsrid = "" ;                   
		String discrmsrresulttype = "" ;          

		String colspanvalue = "";
		int numdigitsdec = 0;

		String defnum =  "" ;
		String defstr =  "" ;
		String defdata =  "" ;
		Clob defaultdata = null;
		String chkType =  "" ;
		String shortdesc = "";
		int defseq = 0; 
		int crtseq = 0; 

		String	normabnormind = "";
		String refrangetype = "";
		String range = "";
		String optype = "";

		String mandatoryyn = "";
		String sysdatetime = "";

		int maxsize = 8;
		
		int count = 0;
		
		String dat = "";
		String sel = "";

		String highstr = "";
		String lowstr = "";
		String abnstr = "";
		String critstr = "";
		String crithighstr = "";
		String critlowstr = "";
		String critabnstr = "";
  
		String highstr_desc = "";
		String lowstr_desc = "";
		String abnstr_desc = "";
		String critstr_desc = "";
		String crithighstr_desc = "";
		String critlowstr_desc = "";
		String dateStatus = "";
		int numdigitsmax = 0;
		int numdigitsmin = 0;
		String numuom = "";
		String numreflow = "";
		String numrefhigh = "";
		String numcritlow = "";
		String numcrithigh = "";
		int min_value = 0;
		int max_value = 0;
			
		String normal_range_symbol = "";
		String normalRangeColor = "";
		String lastrecorddatelabel= "";
		
		ResultSet rslRst		= null;
			
		if(patient_age.equals("")){
		patient_age  = request.getParameter("Age")==null?"": request.getParameter("Age");
		}
		if(pat_sex.equals("")){
		pat_sex  = request.getParameter("Sex")==null?"": request.getParameter("Sex");
		}
		
		String strSqlPat = "Select sex, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth from Pr_encounter a, Mp_patient b where a.ENCOUNTER_ID=? and facility_id=? and A.PATIENT_ID = b.PATIENT_ID";
		pstmt = con.prepareStatement(strSqlPat);
			
		pstmt.setString	(	1,	episodeid);
		pstmt.setString	(	2,	facilityid	);
		rset = pstmt.executeQuery();

		if(rset.next())
		{
			sex = rset.getString("sex");
			dob = rset.getString("date_of_birth");
		}
		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();
		
		String strSqlPatienLine = "select get_patient.get_line_detail(?,?,?) patient_line from dual";
		pstmt = con.prepareStatement(strSqlPatienLine);
			
		pstmt.setString	(	1,	facilityid	);
		pstmt.setString	(	2,	episodeid);
		pstmt.setString	(	3,	locale);

		rset = pstmt.executeQuery();

		if(rset.next())
		patientline = rset.getString("patient_line");

		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();

		strTitle = "Printing - Vital Signs";
		
%>
		<title><%=strTitle%></title></head>
<%
		String retvalue = "";
		
		boolean proceed = false;
		boolean func_appl_yn = true;
		//IN049714 Starts
		/*pstmtCheck = con.prepareStatement(" select ca_get_func_appl_past_visit(?,?,?,?,?) from dual");
		pstmtCheck.clearParameters();
		pstmtCheck.setString(1,facilityid);                // facid
		pstmtCheck.setString(2,"VITAL_SIGNS");              // p_function
		pstmtCheck.setString(3,episodeid);        // p_episode_id
		pstmtCheck.setString(4,pat_class);         // p_episode_type
		pstmtCheck.setString(5,Patient_Id);      // p_patient_id    
           
		rset = pstmtCheck.executeQuery();

		while(rset!=null && rset.next())
		{
			past_visit = rset.getString(1);
		}

		if(rset!=null) rset.close();
		if(pstmtCheck!=null) pstmtCheck.close();

        if(past_visit!=null && past_visit.equalsIgnoreCase("FALSE")) 
		{
			func_appl_yn = false;
%>	
		<script>
			alert(getMessage("CA_DIAG_PROCEDURE","CA"));
			window.close();
			proceed = false;
		</script> 
<%   
		}*/
		//IN049714 Ends
%>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onScroll='scrollTitle()' style='overflow-x:hidden;overflow-y:scroll'>
<form name='ViewDisDataCharting_form' id='ViewDisDataCharting_form' target='messageFrame'>
<% 		
		
		if(func_appl_yn)
		{      
			String sqlstr="select CA_GET_BATTERY_ID(?,?,?) from dual";

			pstmt=con.prepareStatement(sqlstr);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,pat_class);
			pstmt.setString(3,episodeid);
			rset=pstmt.executeQuery();

			if(rset != null && rset.next())
			{
                retvalue = rset.getString(1)==null?"**":rset.getString(1);
				retvalue=retvalue.trim();  //retvalue trimed trim() by Arvind for ICN 18983 - REopen
                if(retvalue.indexOf("**") >=0)
                    out.println("<script>alert(getMessage('NO_VITAL_SIGN_BATTERY','CA'))</script>");
                else
				{
					batteryid = retvalue;
					
                    qs1 = qs;
                    proceed = true;
                }
			}

			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();
	
			StringBuffer sql=new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" SELECT to_char(test_observ_dt_tm,'dd/mm/yyyy hh24:mi:ss')");
			sql.append(" test_observ_dt_tm,to_char(test_observ_dt_tm,'dd/mm/yyyy hh24:mi') lbl_test_observ_dt FROM ca_encntr_discr_msr WHERE test_observ_dt_tm");
            sql.append(" =(SELECT MAX(test_observ_dt_tm) FROM ca_encntr_discr_msr");  
            sql.append(" WHERE facility_id = ? AND ENCOUNTER_ID = ?) and facility_id = ? AND ENCOUNTER_ID = ? AND ROWNUM=1");  
            		
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,facilityid);
			pstmt.setString(2,episodeid); 
			pstmt.setString(3,facilityid);
			pstmt.setString(4,episodeid); 
			rset=pstmt.executeQuery();
			//IN037701 Starts
			/*StringBuffer sqlPastEnc=new StringBuffer();
			if(rset==null)
			{
					//sqlPastEnc.append(" SELECT encounter_id FROM PR_ENCOUNTER WHERE PATIENT_ID = ? AND TRUNC(VISIT_ADM_DATE_TIME) = TRUNC(SYSDATE)  AND ENCOUNTER_ID <> ?");
					sqlPastEnc.append(" select encounter_id,to_char(TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi:ss') test_observ_dt_tm,to_char(test_observ_dt_tm,'dd/mm/yyyy hh24:mi') lbl_test_observ_dt  from ca_encntr_discr_msr where patient_id = ? and facility_id = ? and TRUNC(TEST_OBSERV_DT_TM) = TRUNC(SYSDATE) AND ROWNUM=1");
					pstmt=con.prepareStatement(sqlPastEnc.toString());
					pstmt.setString(1,Patient_Id);
					pstmt.setString(2,facilityid);
					rset=pstmt.executeQuery();
					if(rset!=null && rset.next())
					{
						lastrecorddate = rset.getString("test_observ_dt_tm")==null?"":rset.getString("test_observ_dt_tm");
						lastrecorddatelabel = rset.getString("lbl_test_observ_dt")==null?"":rset.getString("lbl_test_observ_dt");
					}
					
			}*/
			//IN037701 Ends
	        if(rset!=null && rset.next())
			{
				lastrecorddate = rset.getString("test_observ_dt_tm")==null?"":rset.getString("test_observ_dt_tm");
				lastrecorddatelabel = rset.getString("lbl_test_observ_dt")==null?"":rset.getString("lbl_test_observ_dt");
				
	        }
			//if(!patientline.equals(""))
			//{
				StringTokenizer tkn_patdetails = new StringTokenizer(patientline,",|");
				pat_details = new String[tkn_patdetails.countTokens()];
				int i = 0;
				while(tkn_patdetails.hasMoreTokens())
				{
					pat_details[i] = tkn_patdetails.nextToken();
					i++;
				}
			//}
			
			
			String frameSet = "*,7%";
			

			if(!module_id.equals(""))
			{
				frameSet = "*,7%";
			}
			
			if(!lastrecorddate.equals(""))
				dateStatus = "<label>"+com.ehis.util.DateUtils.convertDate(lastrecorddatelabel,"DMYHM","en",locale)+"</label>";
			
		if(!batteryid.equals(""))
		{
		
%>
<table class='grid' width="100%" height='100%' cellspacing='0' cellpadding='0' border='0' align='center'>
		

		<tr>
			<td class='label'><b><fmt:message key="eCA.LastRecordedDateTime.label" bundle="${ca_labels}"/>&nbsp;<b><%=dateStatus%></b></td>
			
		</tr>
		
		<tr id="divTitleTable">	
			<th width='30%'><div class='columnHeadercenter' nowrap width='30%'><fmt:message key="Common.Variable.label" bundle="${common_labels}"/></div></th>
			<th width='10%'><div class='columnHeadercenter' nowrap width='10%'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></div></th>
			<th width='8%'><div class='columnHeadercenter' nowrap width='8%'><fmt:message key="Common.Units.label" bundle="${common_labels}"/></div></th>
			<th width='16%'><div class='columnHeadercenter' nowrap width='16%'><fmt:message key="eCA.NormalRange.label" bundle="${ca_labels}"/></div></th>
			<th width='36%'><div class='columnHeadercenter' nowrap width='36%'><fmt:message key="eCA.NormalInd.label" bundle="${ca_labels}"/></div></th>	
		</tr>
<% 
	
 
    try 
	{
		if(clinicianid.equals(""))
		{
			stmt = con.prepareStatement("select func_role_id from sm_appl_user a where appl_user_id = ? and func_role ='P'");
			stmt.setString(1,login_user);
			rset = stmt.executeQuery();
			
			if(rset != null && rset.next())
				clinicianid = rset.getString("func_role_id") == null ? "" : rset.getString("func_role_id");
			
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
		}
		
		
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" select HIGH_STR,LOW_STR,ABN_STR,CRIT_STR,CRIT_HIGH_STR,CRIT_LOW_STR,HIGH_STR_DESC,LOW_STR_DESC,ABN_STR_DESC,CRIT_HIGH_STR_DESC ");
		sql.append(" ,CRIT_LOW_STR_DESC,CRIT_STR_DESC,LEGEND_TYPE from cr_clin_event_param ");
			
		stmt = con.prepareStatement(sql.toString());
		rset = stmt.executeQuery();

		if(rset != null && rset.next())
		{
			highstr = rset.getString("HIGH_STR") == null ? "" : rset.getString("HIGH_STR");
			lowstr = rset.getString("LOW_STR") == null ? "" : rset.getString("LOW_STR");
			abnstr = rset.getString("ABN_STR") == null ? "" : rset.getString("ABN_STR");
			critstr = rset.getString("CRIT_STR") == null ? "" : rset.getString("CRIT_STR");
			crithighstr = rset.getString("CRIT_HIGH_STR") == null ? "" : rset.getString("CRIT_HIGH_STR");
			critlowstr = rset.getString("CRIT_LOW_STR") == null ? "" : rset.getString("CRIT_LOW_STR");
							
			highstr_desc = rset.getString("HIGH_STR_DESC") == null ? "" : rset.getString("HIGH_STR_DESC");
			lowstr_desc = rset.getString("LOW_STR_DESC") == null ? "" : rset.getString("LOW_STR_DESC");
			abnstr_desc = rset.getString("ABN_STR_DESC") == null ? "" : rset.getString("ABN_STR_DESC");
			crithighstr_desc = rset.getString("CRIT_HIGH_STR_DESC") == null ? "" : rset.getString("CRIT_HIGH_STR_DESC");
			critlowstr_desc = rset.getString("CRIT_LOW_STR_DESC") == null ? "" : rset.getString("CRIT_LOW_STR_DESC");
			critstr_desc = rset.getString("CRIT_STR_DESC") == null ? "" : rset.getString("CRIT_STR_DESC");
			
			legend_type = rset.getString("legend_type")==null?"S":rset.getString("legend_type");
			
		}
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		
		if(!lastrecorddate.equals(""))
		{
		
			if(sql.length() > 0) sql.delete(0,sql.length());
			//sql.append(" SELECT  a.discr_msr_id ");
			//sql.append(" ,a.short_desc ");
			//sql.append(" ,a.unit_of_measure ");
			//sql.append(" ,a.result_type ");
			//sql.append(" ,a.num_digits_max ");
			//sql.append(" ,a.num_digits_min ");
			//sql.append(" ,a.num_digits_dec ");
			//sql.append(" ,a.mandatory_yn ");
			//sql.append(" ,decode(nvl(b.discr_msr_id,'Y'),'Y','I','U') operation_type ");
			//sql.append(" ,b.DISCR_MSR_RESULT_NUM default_num ");          
			//sql.append(" ,b.DISCR_MSR_RESULT_STR  default_str ");          
			//sql.append(" ,b.DISCR_MSR_RESULT_DATA default_data ");   
			//sql.append(" ,b.NORM_ABNORM_IND ");
			//sql.append(" ,b.ERROR_REMARKS error_remarks ");
			//sql.append(" ,ACCESSION_NUM,REF_RANGE_TYPE, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysdatetime ");
		//	sql.append(" ,(select DECODE(b.NORM_ABNORM_IND,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR  ,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol ");
			//sql.append(" ,(select DECODE(b.NORM_ABNORM_IND,HIGH_STR,HIGH_COLOR_CODE,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,ABN_COLOR_CODE,CRIT_HIGH_STR,CRIT_HIGH_COLOR_CODE,CRIT_LOW_STR  ,CRIT_LOW_COLOR_CODE,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_color ");
		//	sql.append(" FROM am_discr_msr_battery_view a,ca_encntr_discr_msr b ");
		//	sql.append(" WHERE a.DISCR_MSR_BATTERY_ID	= ?  ");
		//	sql.append(" and ? = b.facility_id(+)  ");
		//	sql.append(" and a.discr_msr_id = b.discr_msr_id(+) ");
		//	sql.append(" and b.ENCOUNTER_ID   (+) = ? AND nvl(b.ERROR_YN (+),'N' )='N' /* and  b.visit_id(+)= ? 			*/");
		//	sql.append(" and b.TEST_OBSERV_DT_TM(+)= to_date(?,'dd/mm/yyyy hh24:mi:ss') ");	
		//	sql.append(" order by  a.ORDER_SRL_NO ");
			
			
			sql.append(" SELECT   a.discr_msr_id, a.short_desc, a.unit_of_measure, a.result_type, a.num_digits_max, a.num_digits_min, a.num_digits_dec, a.mandatory_yn, DECODE (NVL (b.discr_msr_id, 'Y'), 'Y', 'I', 'U') operation_type, b.discr_msr_result_num default_num, b.discr_msr_result_str default_str, b.discr_msr_result_data default_data, b.norm_abnorm_ind, b.error_remarks error_remarks, accession_num, ref_range_type, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi:ss') sysdatetime,(SELECT DECODE (b.norm_abnorm_ind, high_str, high_symbol_icon, low_str, low_symbol_icon, crit_str, crit_symbol_icon,abn_str, abn_symbol_icon, crit_high_str, crit_high_symbol_icon, crit_low_str, crit_low_symbol_icon, '' )FROM cr_clin_event_param) normal_range_symbol, (SELECT DECODE (b.norm_abnorm_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code, abn_str, abn_color_code, crit_high_str, crit_high_color_code,crit_low_str, crit_low_color_code,'')FROM cr_clin_event_param) normal_range_color FROM am_discr_msr_battery_spc_view a, ca_encntr_discr_msr b WHERE a.discr_msr_battery_id = ?   AND ? = b.facility_id(+)  AND a.discr_msr_id = b.discr_msr_id(+)AND b.encounter_id(+) = ?  AND NVL (b.error_yn(+), 'N') = 'N' /* and  b.visit_id(+)= ?             */ AND b.test_observ_dt_tm(+) = TO_DATE (?, 'dd/mm/yyyy hh24:mi:ss') ORDER BY a.order_srl_no");

			stmt = con.prepareStatement(sql.toString());
					
			stmt.clearParameters();
			stmt.setString(1,batteryid);
			stmt.setString(2,facilityid);
			stmt.setString(3,episodeid);
			stmt.setString(4,lastrecorddate);
			
		}
		else
		{
		
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" SELECT  a.discr_msr_id ");
			sql.append(" , short_desc ");
			sql.append(" ,unit_of_measure ");
			sql.append(" ,result_type ");
			sql.append(" ,num_digits_max ");
			sql.append(" ,num_digits_min ");
			sql.append(" ,num_digits_dec ");
			sql.append(" ,mandatory_yn ");
			sql.append(" ,'I' operation_type ");
			sql.append(" ,NUM_DFLT_RESULT default_num ");          
			sql.append(" ,null  default_str ");          
			sql.append(" ,null default_data ");    
			sql.append(" ,NULL NORM_ABNORM_IND ");
			sql.append(" ,null error_remarks ");
			sql.append(" ,null ACCESSION_NUM ");
			sql.append(" , REF_RANGE_TYPE, ref_range_seq, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysdatetime ");
			
			sql.append(" FROM am_discr_msr_battery_view a, AM_DISCR_MSR_REF_RNG_NUM b ");
			
			sql.append(" where DISCR_MSR_BATTERY_ID = ? and a.discr_msr_id = b.discr_msr_id(+)   ORDER BY order_srl_NO ");
			stmt = con.prepareStatement(sql.toString());
			stmt.clearParameters();
			stmt.setString(1,batteryid);
			
		}

		rset=stmt.executeQuery();
			
		while (rset.next())
		{
			errorRemarks = "";
			sysdatetime = "";
			discrmsrid = "";
			shortdesc = "";
			discrmsrresulttype = "";
			optype = "";
			defnum = "";
			defstr = "";
			longTextVal = "";
			min_value = 0;
			max_value = 0;
			i++;
			
			errorRemarks= rset.getString("error_remarks")==null?"Æ":rset.getString("error_remarks"); 
			sysdatetime = rset.getString("sysdatetime");
			discrmsrid = rset.getString("discr_msr_id");
			shortdesc = rset.getString("short_desc");
			discrmsrresulttype = rset.getString("result_type");
			
			optype = rset.getString("operation_type");
			defnum = rset.getString("default_num")==null?"":rset.getString("default_num");
			defstr = rset.getString("default_str")==null?"":rset.getString("default_str");

			if(!lastrecorddate.equals(""))
			{
				defaultdata = rset.getClob(12);
				if(defaultdata != null)
				{
					BufferedReader rd = new BufferedReader(defaultdata.getCharacterStream());
					char[] longTextContent = new char[(int)defaultdata.length()];

					rd.read(longTextContent,0,(int)defaultdata.length());
					longTextVal = new String(longTextContent);

					rd.close();
				}
				normal_range_symbol = rset.getString("normal_range_symbol")==null?"":rset.getString("normal_range_symbol");
				normalRangeColor = rset.getString("normal_range_color")==null?"":rset.getString("normal_range_color");
				
				
						if(legend_type.equals("S"))
							normalRangeColor = rset.getString("normal_range_symbol")==null?"":rset.getString("normal_range_symbol");
				
			}
			else
			{
				defseq = rset.getInt("ref_range_seq");//IN036756
			}
			
			refrangetype = rset.getString("ref_range_type")==null?"":rset.getString("ref_range_type");
			normabnormind = rset.getString("NORM_ABNORM_IND")==null?"":rset.getString("NORM_ABNORM_IND");
						
			if(normabnormind.equals(highstr))
				normabnormind = highstr_desc;
			else if(normabnormind.equals(lowstr))
				normabnormind = lowstr_desc;
			else if(normabnormind.equals(abnstr))
				normabnormind = abnstr_desc;
			else if(normabnormind.equals(critstr))
				normabnormind = critstr_desc; 
			else if(normabnormind.equals(crithighstr))
				normabnormind = crithighstr_desc;
			else if(normabnormind.equals(critlowstr))
				normabnormind = critlowstr_desc;

						

			numdigitsmax = rset.getInt("num_digits_max");
			numdigitsmin = rset.getInt("num_digits_min");
			numdigitsdec = rset.getInt("num_digits_dec");
			maxsize = numdigitsmax;
			accessionnum = rset.getString("ACCESSION_NUM")==null?"":rset.getString("ACCESSION_NUM");
			numuom = "";
			numreflow = "";    
			numrefhigh = "";   
			numcritlow = "";   
			numcrithigh = "";  
			
			range = "";
			
			StringBuffer valsql = new StringBuffer();
			
			valsql.append(" select num_uom, num_ref_low,num_ref_high,num_crit_low,num_crit_high ");
			valsql.append(" ,ref_range_seq, min_value, max_value from am_discr_msr_ref_rng_num a, am_discr_msr b");
			valsql.append(" WHERE a.discr_msr_id = b.discr_msr_id AND a.discr_msr_id = ?");
			
			if(refrangetype.equals("M"))
			{
				valsql.append( " and patient_sex in ('A',?) "); 
				valsql.append(" and ( to_date( ?,'dd/mm/yyyy') <= ");				
				valsql.append("decode(START_AGE_UNITS,'D',trunc(sysdate)-START_AGE,'M',add_months(trunc(sysdate),-1*START_AGE),'Y',add_months(trunc(sysdate),-12*START_AGE))) ");
				valsql.append(" and ( to_date( ?,'dd/mm/yyyy') >= ");
				valsql.append("decode(END_AGE_UNITS,'D',trunc(sysdate)-END_AGE,'M',add_months(trunc(sysdate),-1*END_AGE),'Y',add_months(trunc(sysdate),-12*END_AGE)) )");
			}
			stmt1 = con.prepareStatement(valsql.toString());
			
			stmt1.clearParameters();
			stmt1.setString(1,discrmsrid);
			if(refrangetype.equals("M"))
			{
				stmt1.setString(2,patsex);
				stmt1.setString(3,dob);
				stmt1.setString(4,dob);
			}
			rset1=stmt1.executeQuery();

			if(rset1.next())
			{
				numuom = rset1.getString("num_uom") == null ? "" : rset1.getString("num_uom");
				numreflow = rset1.getString("num_ref_low") == null ? "" : rset1.getString("num_ref_low");
				numrefhigh = rset1.getString("num_ref_high") == null ? "" : rset1.getString("num_ref_high");
				numcritlow = rset1.getString("num_crit_low") == null ? "" : rset1.getString("num_crit_low");
				numcrithigh = rset1.getString("num_crit_high") == null ? "" : rset1.getString("num_crit_high");
				min_value = rset1.getInt("min_value");
				max_value = rset1.getInt("max_value");
				crtseq = rset1.getInt("ref_range_seq");
			}
			if(!lastrecorddate.equals(""))
			{
				defseq = crtseq;
			}

			if(rset1 != null)rset1.close();
			if(stmt1 != null)stmt1.close();

			if(!numreflow.equals("") && !numrefhigh.equals("") )
				range = numreflow+" - "+numrefhigh;
			else if(!numreflow.equals(""))
				range = "(>="+numreflow+")";
			else if(!numrefhigh.equals(""))
				range = "(<="+numrefhigh+")";

			if(discrmsrresulttype.equals("F")) colspanvalue = "8";
			else colspanvalue = "";
		
			
			if(refrangetype.equals("M") && defseq != crtseq )
			{
			} else{
%>
			<tr>
				<td width="30%" class='gridData' id="short_desc_<%=i%>"><%=shortdesc%></td>
				
				<td width="10%" class='gridData' colspan="<%=colspanvalue%>"> 
<%
				if(discrmsrresulttype.equals("L"))
				{
				
					int k = i;
					stmt1 = con.prepareStatement(" select ref_rng_desc,NORM_ABNORM_IND,DFLT_YN from am_discr_msr_ref_rng_list where  discr_msr_id= ?");
					stmt1.clearParameters();
					stmt1.setString(1,discrmsrid);
					rset1=stmt1.executeQuery();
					if(rset1 != null)
					{
						while(rset1.next())
						{
							dat = rset1.getString("ref_rng_desc").trim();
							String normal = rset1.getString("NORM_ABNORM_IND")==null?"N":rset1.getString("NORM_ABNORM_IND");
							String dfltyn = rset1.getString("DFLT_YN")==null?"N":rset1.getString("DFLT_YN");
							
							if(dat.equals(defstr))
							{
								if(normal.equals("A")) normabnormind = abnstr_desc;
								else if(normal.equals("C")) normabnormind = critstr_desc  ;
								out.println("<label>"+dat+"</label>");
							}
							k++;
						}
					}
					if(rset1 != null) rset1.close();
					if(stmt1 != null) stmt1.close();
%>
					
<%
					
				}
				else if(discrmsrresulttype.equals("C"))
				{
					String chk = "";
					if(defstr.equals("Y"))
						chk = "checked";
					
					if(chk.equals("checked"))
					{
					out.println("<label>Yes</label>");
					}
					else
					{
					out.println("<label>No</label>");
					}
				}
				else if(discrmsrresulttype.equals("F"))
				{
					String display = "";
					if(defdata.indexOf("<html>")==-1)
						display = defdata;
					
					out.println("<label>"+longTextVal+"</label>");
				}
				else if(discrmsrresulttype.equals("N"))
				{
					if (numdigitsmax==0) { numdigitsmax=22 ; maxsize=22;}
					
					out.println("<label >"+defnum+"</label>");
					
				}
				else if(discrmsrresulttype.equals("I"))
				{
					if(numdigitsmax == 0) maxsize = 3;
					
					out.println("<label >"+defnum+"</label>");
				}
				else if(discrmsrresulttype.equals("H"))
				{
					out.println("<label >"+defstr+"</label>");
				}
				else
				{
					out.println("<label >"+defstr+"</label>");
					
				}

				
%>
			&nbsp;</td>
	
<%
			}
			
	
		
		if(!discrmsrresulttype.equals("F"))
		{
		if(refrangetype.equals("M") && defseq != crtseq) 
		{
		} else
		{
		
%>
			<td class='gridData' width="10%"><%=numuom%>&nbsp;</td>
			<td class='gridData' width="15%"><%=range%>&nbsp;</td>
			<%
			if(!normalRangeColor.equals(""))
				{
					if(legend_type.equals("S"))
					{
			%>
					<td class='gridData' width="15%" id='nor_<%=i%>'><font  style='background-image:url("../../eCA/images/<%=normalRangeColor%>");size:1;width:16px;height:16px'>&nbsp;&nbsp;</font>&nbsp;<%=normabnormind%>&nbsp;</td>
			<%			
					}
					else
					{
			%>
					<td class='gridData' width="15%" id='nor_<%=i%>'><font  style='background-color:<%=normalRangeColor%>;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<%=normabnormind%>&nbsp;</td>
			<%		}	
			}else{
			%>
				<td class='gridData' width="15%" id='nor_<%=i%>'>&nbsp;</td>
			<%
			}
		}
		}
	
%>
	</tr>
	
	<input type=hidden name='batteryid' id='batteryid' value=<%=batteryid%>>	
	
	
	
<%
		
	}

	if(rset != null) rset.close();
	if(stmt != null) stmt.close();

	String batteryDesc = "";

	stmt = con.prepareStatement("SELECT SHORT_DESC FROM AM_DISCR_MSR WHERE DISCR_MSR_ID = ?");
	stmt.setString(1,batteryid);
	rset = stmt.executeQuery();

	while(rset.next())
	{
		batteryDesc = rset.getString("SHORT_DESC") == null ? "": rset.getString("SHORT_DESC");
	}
			
    if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	if(rset1!=null) rset1.close();
	if(stmt1!=null) stmt1.close();

	if(!(batteryid.equals("")) && i == 0)
	{				
		out.println("<script>var msg = getMessage('NO_DISCR_MSR','CA');</script>");
		out.println("<script>msg = msg.replace('$$',',"+batteryDesc+", ');</script>");
		out.println("<script>alert(msg);</script>");
		out.println("<script>window.close();</script>");
	}
	else if(batteryid.equals(""))
	{
		out.println("<script>alert(getMessage('NO_BATTERY','CA'))</script>");
		out.println("<script>window.close();</script>");
	}
	}
	catch(Exception e)
	{
		//out.println("Inqq   "+e.toString());//common-icn-0181
		e.printStackTrace();
	}
%>
<%

	PreparedStatement pstmtclr = null;
	ResultSet rslRstclr		= null;
	HashMap mapDescColor = new HashMap();
	ArrayList listDesc = new ArrayList();
	
    StringBuffer sblQry		= new StringBuffer();
	String low_value_color ="";
    String high_value_color ="";
	String abnml_value_color ="";
	String crtcl_value_color ="";
	String crtcl_low_value_color ="";
	String crtcl_high_value_color ="";
	String high_value_desc ="";
	String low_value_desc ="";
	String abnml_value_desc	= "";
	String crtcl_value_desc	= "";
	String crtcl_low_value_desc	= "";
	String crtcl_high_value_desc	= "";
	String deltaValue	= "";
	


	sblQry.append("SELECT high_str_desc,high_color_code,low_str_desc,low_color_code,abn_str_desc,abn_color_code,crit_str_desc,crit_color_code,crit_high_str_desc,crit_high_color_code,crit_low_str_desc,crit_low_color_code,DELTA_FAIL_STR, HIGH_SYMBOL_ICON, LOW_SYMBOL_ICON, ABN_SYMBOL_ICON, CRIT_SYMBOL_ICON, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_SYMBOL_ICON, LEGEND_TYPE FROM cr_clin_event_param_lang_vw where language_id=? ");
	pstmtclr = con.prepareStatement(sblQry.toString());
	pstmtclr.setString(1,locale);
	rslRstclr = pstmtclr.executeQuery();


	if(rslRstclr.next())
	{
		legend_type = rslRstclr.getString("LEGEND_TYPE") == null ? "S" : rslRstclr.getString("LEGEND_TYPE");

		high_value_desc = rslRstclr.getString("high_str_desc") == null ? "" : rslRstclr.getString("high_str_desc");
		high_value_color = rslRstclr.getString("high_color_code") == null ? "" : rslRstclr.getString("high_color_code");
		if(legend_type.equals("S"))
			high_value_color = rslRstclr.getString("HIGH_SYMBOL_ICON") == null ? "" : rslRstclr.getString("HIGH_SYMBOL_ICON");

		mapDescColor.put(high_value_desc,high_value_color);
		listDesc.add(high_value_desc);

		low_value_desc = rslRstclr.getString("low_str_desc") == null ? "" : rslRstclr.getString("low_str_desc");
		low_value_color = rslRstclr.getString("low_color_code") == null ? "" : rslRstclr.getString("low_color_code");
		if(legend_type.equals("S"))
			low_value_color = rslRstclr.getString("LOW_SYMBOL_ICON") == null ? "" : rslRstclr.getString("LOW_SYMBOL_ICON");
	   
		if(!(mapDescColor.containsKey(low_value_desc)))
		{
			mapDescColor.put(low_value_desc,low_value_color);
			listDesc.add(low_value_desc);
		}

		abnml_value_desc = rslRstclr.getString("abn_str_desc") == null ? "" : rslRstclr.getString("abn_str_desc");
		abnml_value_color = rslRstclr.getString("abn_color_code") == null ? "" : rslRstclr.getString("abn_color_code");
		if(legend_type.equals("S"))
			abnml_value_color = rslRstclr.getString("ABN_SYMBOL_ICON") == null ? "" : rslRstclr.getString("ABN_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(abnml_value_desc)))
		{
			mapDescColor.put(abnml_value_desc,abnml_value_color);
			listDesc.add(abnml_value_desc);
		}

		crtcl_value_desc = rslRstclr.getString("crit_str_desc") == null ? "" : rslRstclr.getString("crit_str_desc");
		crtcl_value_color = rslRstclr.getString("crit_color_code") == null ? "" : rslRstclr.getString("crit_color_code");
		if(legend_type.equals("S"))
			crtcl_value_color = rslRstclr.getString("CRIT_SYMBOL_ICON") == null ? "" : rslRstclr.getString("CRIT_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(crtcl_value_desc)))
		{
			mapDescColor.put(crtcl_value_desc,crtcl_value_color);
			listDesc.add(crtcl_value_desc);
		}

		crtcl_high_value_desc = rslRstclr.getString("crit_high_str_desc") == null ? "" : rslRstclr.getString("crit_high_str_desc");
		crtcl_high_value_color = rslRstclr.getString("crit_high_color_code") == null ? "" : rslRstclr.getString("crit_high_color_code");
		if(legend_type.equals("S"))
			crtcl_high_value_color = rslRstclr.getString("CRIT_HIGH_SYMBOL_ICON") == null ? "" : rslRstclr.getString("CRIT_HIGH_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(crtcl_high_value_desc)))
		{
			mapDescColor.put(crtcl_high_value_desc,crtcl_high_value_color);
			listDesc.add(crtcl_high_value_desc);
		}  

		crtcl_low_value_desc = rslRstclr.getString("crit_low_str_desc") == null ? "" : rslRstclr.getString("crit_low_str_desc");
		crtcl_low_value_color = rslRstclr.getString("crit_low_color_code") == null ? "" : rslRstclr.getString("crit_low_color_code");
		if(legend_type.equals("S"))
			crtcl_low_value_color = rslRstclr.getString("CRIT_LOW_SYMBOL_ICON") == null ? "" : rslRstclr.getString("CRIT_LOW_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(crtcl_low_value_desc)))
		{
			mapDescColor.put(crtcl_low_value_desc,crtcl_low_value_color);
			listDesc.add(crtcl_low_value_desc);
		}

		deltaValue = rslRstclr.getString("DELTA_FAIL_STR") == null ? "" : rslRstclr.getString("DELTA_FAIL_STR");

		out.println("<input type=hidden name='mode' id='mode' value='update'>");
	}
	else
	{
		out.println("<input type=hidden name='mode' id='mode' value='insert'>");
	}

%>
<tr>
<td colspan=5>
	<table cellspacing=0 width='100%' border=0 >
		<tr>
		<%
		String listValues = "";
		String listValuesdisp = "";
		String mapValues = "";

		for(int indexlstDsc=0;indexlstDsc<listDesc.size();indexlstDsc++)
		{
			listValues = (String) listDesc.get(indexlstDsc);
			listValuesdisp = listValues;
			/*if(listValues.length()>15)
				listValuesdisp=listValues.substring(0,16);
			else
				listValuesdisp=listValues;*/
			mapValues = (String) mapDescColor.get(listValues);
			if(legend_type.equals("S"))
			{
	%>
			<td  width='15%' nowrap>
				<font style='background:url("../../eCA/images/<%=mapValues%>");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><%=listValuesdisp%></font>
			</td>
	<%
			}
			else{%>
				<td>
					<font style='background-color:<%=mapValues%>;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;
					<font size=1><%=listValuesdisp%></font>
				</td>
				<%}
		}
		if(legend_type.equals("S"))
		{
	%>
			<td  width='15%' nowrap>
				<font style='background:url("../../eCA/images/NI_Normal.gif");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></font>
			</td>
	<%
		}
		else
		{
	%>
			<td  width='15%' nowrap>
				<font style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></font>
			</td>
	<%
			}
		
	%>
			</tr>
		</table>
		
		</td>
	</tr>
</table>
<div id='descLink' style='position:absolute; visibility:hidden;overflow:overflow'></div>
<%
			}
			else
			{
				out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr></table>");		
			}
		}
		else
		{
			out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr></table>");		
		}
%>
</form>
</body>	
</html>

<%	
		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();  
		if(rslRst!=null) rslRst.close();	
	}
	catch ( Exception e) { }
    finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	}
%>

