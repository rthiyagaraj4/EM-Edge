<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
04/12/2012		IN036440		ChowminyaG		 Default value of discrete measure do not show the default value in vital sign battery
10/12/2012		IN036447		ChowminyaG		 Multiple Reference Range of integer numeric discrete measure do not display in Vital sign battery 
14/02/2013		IN036756		ChowminyaG		 Record Vital Signs->Defined Discrete Measure Components are not displayed 
11/12/2013      IN034536		Nijitha S		Bru-HIMS-CRF-133
03/06/2014	  	IN037701		Chowminya		 SKR-CRF-0036
13/07/2021		21303			Ramesh Goli		 SKR-SCF-1623
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.io.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCA/js/DisDataCharting.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
    Connection con = null;
    try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = p.getProperty( "login_user" ) ;

		con = ConnectionManager.getConnection(request);
		PreparedStatement stmt  = null;
		PreparedStatement stmt1 = null;
		ResultSet rset = null ;
		ResultSet rset1 = null ;
		
		String clinicianid		=	(String) session.getAttribute("ca_practitioner_id") == null ? "" : (String) session.getAttribute("ca_practitioner_id");
		String facilityId = (String) session.getValue( "facility_id" ) ;
		String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String episodetype = request.getParameter("episode_type")==null?"I":request.getParameter("episode_type");
		String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String visitid = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
		if(visitid.equals("") && episodetype.equals("I")) visitid = "1";
		String batteryid = request.getParameter("battey_id")==null?"":request.getParameter("battey_id");
		batteryid = batteryid.trim();
		String patientid = request.getParameter("patient_id");
		String admdttime = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
		String locncode = request.getParameter("location_code")==null?"": request.getParameter("location_code");

		String patsex = request.getParameter("patsex")==null?"U": request.getParameter("patsex");//[IN036447]
		String amerepMode=request.getParameter("amerepMode")==null?"N":request.getParameter("amerepMode");
		//IN034536 Starts
		String isPatientEncMovement = request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
		String	p_queue_date = request.getParameter("p_queue_date")==null?"":request.getParameter("p_queue_date");
		String	Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
		//IN034536 Ends

		/*if(patsex.equals("Male")) patsex = "M";
		else if(patsex.equals("Female")) patsex = "F";
		else patsex = "U";*///[IN036447]

		String out_mode = request.getParameter("out_mode")==null?"": request.getParameter("out_mode");
		String dob = request.getParameter("dob")==null?"": request.getParameter("dob");
		String lastrecorddate = request.getParameter("last_record_date")==null?"":request.getParameter("last_record_date");
		String amendMode = request.getParameter("amendMode")==null?"":request.getParameter("amendMode");
		String replaceMode = request.getParameter("replaceMode")==null?"":request.getParameter("replaceMode");
		String newlastrecorddate = request.getParameter("new_last_record_date")==null?"":request.getParameter("new_last_record_date");
		String module_id = request.getParameter("module_id")==null?"": request.getParameter("module_id");
		String location_type = request.getParameter("location_type")==null?"": request.getParameter("location_type");
		    
		String readOnly = "";
		String listDisabled = "";
		String disabled = "";
		String errorRemarks = "";
		String longTextVal = "";
		String called_from = request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");//IN037701
		
		if(amendMode.equals("Y"))
		{
			lastrecorddate = newlastrecorddate;
			readOnly = "readOnly";
			listDisabled = "disabled";
		}

		if(replaceMode.equals("Y"))
		{
			lastrecorddate = newlastrecorddate;
			readOnly = "readOnly";
			listDisabled = "disabled";
		}

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
		int defseq = 0; //IN036756
		int crtseq = 0; //IN036756

		String	normabnormind = "";
		String refrangetype = "";
		String range = "";
		String optype = "";
		String chartId = ""; //21303
		String mandatoryyn = "";
		String sysdatetime = "";

		int maxsize = 8;
		int i = 0;
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
		String qs = request.getQueryString();
%>
</head>
<!-- added below code for IN035857	PMG2012-CRF-0017 START -->
<script>
function loadMainPageFirst(check)
			{	
				var qs = "<%=qs%>";
				qs = qs+'&out_mode=showpage';
				if(check == 'Error')
					qs += '&new_last_record_date='+document.forms[0].date.value+' '+document.forms[0].time.value;
					location.href = '../../eCA/jsp/DisDataChartingRecord.jsp?'+qs
			}
</SCRIPT>
<!-- added below code for IN035857	PMG2012-CRF-0017 END -->
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onKeyPress='' >
<form name='DisDataCharting_form' id='DisDataCharting_form' action='../../servlet/eCA.VitalSignRecordServlet' method='post' target='messageFrame'> 
<table  id='detailTab' width="100%" cellspacing='0' cellpadding='3' border=0 align='center'>
<!-- added below code for IN035857	PMG2012-CRF-0017 START -->
<%
		
	if(amerepMode.equals("N"))
	{
		if(lastrecorddate.equals(""))
			dateStatus = "New";
		else
			dateStatus = "<a href='javascript:loadMainPageFirst()' >"+lastrecorddate+"</a>";
			
%>

		<tr>
			<td class=label ><b><fmt:message key="eCA.LastRecordedDateTime.label" bundle="${ca_labels}"/>:</td>
			<td  class=label id=td1 colspan=4><b><%=dateStatus%></b></td>
		</tr>	
		<tr>
			<td class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.Variable.label" bundle="${common_labels}"/></font></td>
			<td class='COLUMNHEADERCENTER' width='10%'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADERCENTER' width='8%'><fmt:message key="Common.Units.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADERCENTER' width='16%'><fmt:message key="eCA.NormalRange.label" bundle="${ca_labels}"/></td>
			<td class='COLUMNHEADERCENTER' width='36%'><fmt:message key="eCA.NormalInd.label" bundle="${ca_labels}"/>.</font></td>	
		</tr>
<!-- added below code for IN035857	PMG2012-CRF-0017 END -->
<% 
}else if(amerepMode.equals("Y"))
	{ 
%>
	<tr>
		<td>
			<table class='grid' border=0 width="100%" cellspacing='0' cellpadding='3' align='center'>
			<tr>
				<td class='gridData' width='25%' ><fmt:message key="Common.recordeddatetime.label" bundle="${common_labels}"/></td> 
				<td width='25%' class='gridData'><b><%=newlastrecorddate%></b></td> 
<% 
			if (amendMode.equals("Y"))
			{
%>			
				<td  colspan=2 width='50%' id='spanning'  class='gridData'><b><fmt:message key="Common.MarkError.label" bundle="${common_labels}"/></b></td>
<% 
			}
			else if (replaceMode.equals("Y"))
			{
%>
				<td  colspan=2  id='spanning'   width='50%' class='gridData'><b><fmt:message key="eCA.ReplaceValue.label" bundle="${ca_labels}"/></b></td>
<%
			}
			else
			{
%>
				<td  colspan=2  id='spanning' width='50%' class='gridData'></td>
<%
			}
%>
			</tr>
			</table>
		</td>
	</tr>
<% 
	}

	if(amerepMode.equals("Y"))
	{
		if (!amendMode.equals("Y"))
		{ 
%>			
			<tr>
				<td class='columnheadercenter'  width='10%'><fmt:message key="Common.Variable.label" bundle="${common_labels}"/>1</font></td>
				<td class='columnheadercenter'  width='20%'><fmt:message key="Common.OldValue.label" bundle="${common_labels}"/></td>
				<td class='columnheadercenter'  width='20%'><fmt:message key="Common.NewValue.label" bundle="${common_labels}"/></td>
				<td class='columnheadercenter'  width='15%'><fmt:message key="Common.Units.label" bundle="${common_labels}"/></td>
				<td class='columnheadercenter'  width='15%'><fmt:message key="eCA.NormalRange.label" bundle="${ca_labels}"/></td>
				<td class='columnheadercenter'  width='10%'><fmt:message key="eCA.NormalInd.label" bundle="${ca_labels}"/></font></td>	
				<td class='columnheadercenter'></td>
				<td class='columnheadercenter'  width='10%'><fmt:message key="Common.Error.label" bundle="${common_labels}"/></td>
			</tr>
<% 
		}
		else
		{ 
%>
			<tr>
				<td class='columnheadercenter'   width='30%'><fmt:message key="Common.Variable.label" bundle="${common_labels}"/></font></td>
				<td class='columnheadercenter'  width='25%'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
 				<td class='columnheadercenter'></td>
				<td class='columnheadercenter'  width='11%'><fmt:message key="Common.Units.label" bundle="${common_labels}"/></td>
				<td class='columnheadercenter'  width='15%'><fmt:message key="eCA.NormalRange.label" bundle="${ca_labels}"/></td>
				<td class='columnheadercenter'   width='13%'><fmt:message key="eCA.NormalInd.label" bundle="${ca_labels}"/></font></td>	
				<td class='columnheadercenter'  width='2%'></td>
				<td class='columnheadercenter'  width='4%' colspan=2><input type='checkbox' name=chkAll onclick='checkAll(this)'><fmt:message key="Common.Error.label" bundle="${common_labels}"/></td>
			</tr>
<% 
		} 
	} 

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
		
		StringBuffer sql = new StringBuffer();
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" select HIGH_STR,LOW_STR,ABN_STR,CRIT_STR,CRIT_HIGH_STR,CRIT_LOW_STR,HIGH_STR_DESC,LOW_STR_DESC,ABN_STR_DESC,CRIT_HIGH_STR_DESC ");
		sql.append(" ,CRIT_LOW_STR_DESC,CRIT_STR_DESC from cr_clin_event_param ");
			
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
		}
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		
		if(!out_mode.equals(""))
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			//if else condition added IN037701 start
			if("CA_SPC".equals(called_from))
			{
				sql.append(" SELECT   a.discr_msr_id, a.short_desc, a.unit_of_measure, a.result_type, a.num_digits_max, a.num_digits_min, a.num_digits_dec, a.mandatory_yn, DECODE (NVL (b.discr_msr_id, 'Y'), 'Y', 'I', 'U') operation_type, b.discr_msr_result_num default_num, b.discr_msr_result_str default_str, b.discr_msr_result_data default_data, b.norm_abnorm_ind, b.error_remarks error_remarks, accession_num, ref_range_type, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi:ss') sysdatetime,(SELECT DECODE (b.norm_abnorm_ind, high_str, high_symbol_icon, low_str, low_symbol_icon, crit_str, crit_symbol_icon,abn_str, abn_symbol_icon, crit_high_str, crit_high_symbol_icon, crit_low_str, crit_low_symbol_icon, '' )FROM cr_clin_event_param) normal_range_symbol, (SELECT DECODE (b.norm_abnorm_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code, abn_str, abn_color_code, crit_high_str, crit_high_color_code,crit_low_str, crit_low_color_code,'')FROM cr_clin_event_param) normal_range_color,b.chart_id FROM am_discr_msr_battery_spc_view a, ca_encntr_discr_msr b WHERE a.discr_msr_battery_id = ?   AND ? = b.facility_id(+)  AND a.discr_msr_id = b.discr_msr_id(+)AND b.encounter_id(+) = ?  AND NVL (b.error_yn(+), 'N') = 'N' /* and  b.visit_id(+)= ?             */ AND b.test_observ_dt_tm(+) = TO_DATE (?, 'dd/mm/yyyy hh24:mi:ss') ORDER BY a.order_srl_no"); //b.chart_id added for 21303
			}
			else
			{
				sql.append(" SELECT  a.discr_msr_id ");
				sql.append(" ,a.short_desc ");
				sql.append(" ,a.unit_of_measure ");
				sql.append(" ,a.result_type ");
				sql.append(" ,a.num_digits_max ");
				sql.append(" ,a.num_digits_min ");
				sql.append(" ,a.num_digits_dec ");
				sql.append(" ,a.mandatory_yn ");
				sql.append(" ,decode(nvl(b.discr_msr_id,'Y'),'Y','I','U') operation_type ");				
				sql.append(" ,b.DISCR_MSR_RESULT_NUM default_num ");          
				sql.append(" ,b.DISCR_MSR_RESULT_STR  default_str ");          
				sql.append(" ,b.DISCR_MSR_RESULT_DATA default_data ");   
				sql.append(" ,b.NORM_ABNORM_IND ");
				sql.append(" ,b.ERROR_REMARKS error_remarks ");
				sql.append(" ,ACCESSION_NUM,REF_RANGE_TYPE, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysdatetime ");
				sql.append(" ,b.chart_id "); //21303
				sql.append(" FROM am_discr_msr_battery_view a,ca_encntr_discr_msr b ");
				sql.append(" WHERE a.DISCR_MSR_BATTERY_ID	= ?  ");
				sql.append(" and ? = b.facility_id(+)  ");
				sql.append(" and a.discr_msr_id = b.discr_msr_id(+) ");
				sql.append(" and b.ENCOUNTER_ID   (+) = ? AND nvl(b.ERROR_YN (+),'N' )='N' /* and  b.visit_id(+)= ? 			*/");
				sql.append(" and b.TEST_OBSERV_DT_TM(+)= to_date(?,'dd/mm/yyyy hh24:mi:ss') ");	
				sql.append(" order by  a.ORDER_SRL_NO ");
			}
			//IN037701 end
			stmt = con.prepareStatement(sql.toString());
					
			stmt.clearParameters();
			stmt.setString(1,batteryid);
			stmt.setString(2,facilityId);
			stmt.setString(3,episodeid);
			stmt.setString(4,lastrecorddate);
		}
		else
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" SELECT  a.discr_msr_id ");
			//sql.append(" SELECT  discr_msr_id "); //commentted--[IN036440]
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
			sql.append(" , REF_RANGE_TYPE, ref_range_seq, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysdatetime ");//IN036756
			sql.append(" ,'' chart_id "); //21303
			//sql.append(" FROM am_discr_msr_battery_view "); //commentted--[IN036440]
			//sql.append(" where DISCR_MSR_BATTERY_ID = ?  order by ORDER_SRL_NO ");
			sql.append(" FROM am_discr_msr_battery_view a, AM_DISCR_MSR_REF_RNG_NUM b "); //--[IN036440]
			//sql.append(" where DISCR_MSR_BATTERY_ID = ? and a.discr_msr_id = b.discr_msr_id(+)    AND patient_sex in ('A',?) AND (TO_DATE (?, 'dd/mm/yyyy') <= DECODE (start_age_units,'D', TRUNC (SYSDATE) - start_age,'M', ADD_MONTHS (TRUNC (SYSDATE), -1 * start_age),'Y', ADD_MONTHS (TRUNC (SYSDATE), -12 * start_age) )) AND (TO_DATE (?, 'dd/mm/yyyy') >= DECODE (end_age_units,'D', TRUNC (SYSDATE) - end_age, 'M', ADD_MONTHS (TRUNC (SYSDATE), -1 * end_age),'Y', ADD_MONTHS (TRUNC (SYSDATE), -12 * end_age) )) ORDER BY order_srl_NO ");//--[IN036440]--[IN036447]
			sql.append(" where DISCR_MSR_BATTERY_ID = ? and a.discr_msr_id = b.discr_msr_id(+)   ORDER BY order_srl_NO ");//--[IN036440]--[IN036447]
			stmt = con.prepareStatement(sql.toString());
			stmt.clearParameters();
			stmt.setString(1,batteryid);
			//stmt.setString(2,patsex); //--[IN036447]
		        //stmt.setString(3,dob);
			//stmt.setString(4,dob);
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
			chartId = ""; //21303
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
			chartId = rset.getString("chart_id"); //21303
			if("DRUG".equals(chartId)) //21303 
				optype="I";   //21303
			defnum = rset.getString("default_num")==null?"":rset.getString("default_num");
			defstr = rset.getString("default_str")==null?"":rset.getString("default_str");

			if(!out_mode.equals(""))
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
			}
			else
			{
				defseq = rset.getInt("ref_range_seq");//IN036756
			}
			mandatoryyn = rset.getString("mandatory_yn")==null?"N":rset.getString("mandatory_yn");
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
				valsql.append( " and patient_sex in ('A',?) "); //--[IN036447]
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
				crtseq = rset1.getInt("ref_range_seq");//IN036756
			}
			if(!out_mode.equals(""))
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
		
			if (!errorRemarks.equals("Æ"))
			{
				readOnly = "readOnly";
				listDisabled = "disabled";
			}
			if(refrangetype.equals("M") && defseq != crtseq ) //IN036756
			{
			} else{
%>
			<tr>
				<td width="30%" id="short_desc_<%=i%>"><%=shortdesc%></td>
				<!-- <td width="30%" colspan="<%=colspanvalue%>"> -->
				<td width="10%" colspan="<%=colspanvalue%>"> <!--  modified for IN035857	PMG2012-CRF-0017 -->
<%
				shortdesc = java.net.URLEncoder.encode(shortdesc,"UTF-8"); // ADDED BY LK
				if(discrmsrresulttype.equals("L"))
				{
					int k = i;
%>
					<Select name='str_id_<%=i%>' id='str_id_<%=i%>' onChange="javascript:chkNormalAbnormal(this,'<%=i%>')" <%=listDisabled%>>
						<option value=''>&nbsp; -----Select------&nbsp;</option>
<%
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
							if(dfltyn.equals("Y"))
								sel="selected";
							if(dat.equals(defstr))
							{
								if(normal.equals("A")) normabnormind = abnstr_desc;
								else if(normal.equals("C")) normabnormind = critstr_desc  ;
								sel = "selected";
							}
							else
								sel = "";
								out.println("<option class='"+normal+"' value='"+dat+"' "+sel+" >"+dat+"</option>");
								k++;
						}
					}
					if(rset1 != null) rset1.close();
					if(stmt1 != null) stmt1.close();
%>
					</Select>
<%
					if(defstr.equals(""))
					{
						disabled="disabled";
					}
				}
				else if(discrmsrresulttype.equals("C"))
				{
					String chk = "";
					if(defstr.equals("Y"))
						chk = "checked";
					out.println("<input type='checkbox' name='str_id_"+i+"' id='str_id_"+i+"' value='Y' "+chk+" "+readOnly+">");
				}
				else if(discrmsrresulttype.equals("F"))
				{
					String display = "";
					if(defdata.indexOf("<html>")==-1)
						display = defdata;
					out.println("<textarea name='str_id_"+i+"' rows='3' cols='71'>"+longTextVal+"</textarea>");
				}
				else if(discrmsrresulttype.equals("N"))
				{
					if (numdigitsmax==0) { numdigitsmax=22 ; maxsize=22;}
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defnum+"'  OnKeyPress =\"return allowValidNumber(this,event,'"+numdigitsmax+"','"+numdigitsdec+"')\" onBlur=\"  validateNumber(this,'"+numreflow+"','"+numrefhigh+"','"+i+"','"+numdigitsdec+"','"+numcritlow+"','"+numcrithigh+"','"+numdigitsmin+"','"+module_id+"','"+shortdesc+"','"+min_value+"','"+max_value+"')\"  "+readOnly+">");
					if(defnum.equals(""))
					{
						disabled="disabled";
					}
				}
				else if(discrmsrresulttype.equals("I"))
				{
					if(numdigitsmax == 0) maxsize = 3;
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defnum+"'  OnKeyPress =\"return allowValidNumber(this,event,'"+numdigitsmax+"',0)\" onBlur=\"  validateNumber(this,'"+numreflow+"','"+numrefhigh+"','"+i+"','"+numdigitsdec+"','"+numcritlow+"','"+numcrithigh+"','"+numdigitsmin+"','"+module_id+"','"+shortdesc+"')\" "+readOnly+">"); 
				}
				else if(discrmsrresulttype.equals("H"))
				{
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='60' maxlength='4000' value = '"+defstr+"' "+readOnly+ " >");
				}
				
				else
				{
					if(discrmsrresulttype.equals("E"))
					{
						maxsize = 16;
						chkType = "return CheckForSpecCharsForDateTime(event)";
					}
					else if(discrmsrresulttype.equals("D"))
					{
						 maxsize = 10;
						 chkType = "return CheckForSpecCharsForDate(event)";
					}
					else if(discrmsrresulttype.equals("T"))
					{
						 maxsize =5;
						 chkType = "return CheckForSpecChars(event)";
					}
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defstr+"' OnKeyPress =\""+chkType+"\" onblur= \" return validateDateTime(this,'"+discrmsrresulttype+"'); \"  "+readOnly+">");
					if(defstr.equals(""))
					{
						disabled="disabled";
					}
				}

				if(mandatoryyn.equals("Y") && !discrmsrresulttype.equals("C"))
					out.println("<img align=center src='../../eCommon/images/mandatory.gif'></img>");
%>
			</td>
				
	<!-- 		<td nowrap id='abcd'> -->  <!-- commented for PMG2012-CRF-0017 -->

<%
			}
			if(replaceMode.equals("Y") && disabled.equals(""))
			{
				%><td nowrap id='abcd'> <% //for PMG2012-CRF-0017
				if (errorRemarks.equals("Æ"))
				{ 
%>
				<input type='checkbox' name=errorChk<%=count%> onclick='callRemarksBox(this,"<%=count%>","<%=errorRemarks%>",<%=i%>);' <%=disabled%>>
<%
				}
				if(discrmsrresulttype.equals("L")  && !(defstr.equals("")) && errorRemarks.equals("Æ"))
				{
					int k = i; 
%>
					<Select name='str_id1_<%=i%>' id='str_id1_<%=i%>' onChange="javascript:chkNormalAbnormal(this,'<%=i%>')" >
						<option value=''>&nbsp; -----Select------&nbsp;</option>
<%

					stmt1 = con.prepareStatement(" select ref_rng_desc,NORM_ABNORM_IND,DFLT_YN from am_discr_msr_ref_rng_list where  discr_msr_id= ?");
					stmt1.clearParameters();
					stmt1.setString(1,discrmsrid);
					rset1 = stmt1.executeQuery();
					if(rset1 != null)
					{
						while(rset1.next())
						{
							dat = rset1.getString("ref_rng_desc").trim();
							String normal = rset1.getString("NORM_ABNORM_IND")==null?"N":rset1.getString("NORM_ABNORM_IND");
							String dfltyn = rset1.getString("DFLT_YN")==null?"N":rset1.getString("DFLT_YN");
							if(dfltyn.equals("Y"))
								sel = "selected";
							if(dat.equals(defstr))
							{
								if(normal.equals("A")) normabnormind = abnstr_desc;
								else if(normal.equals("C")) normabnormind = critstr_desc  ;
								sel = "selected";
							}
							else
								sel = "";
							out.println("<option class='"+normal+"' value='"+dat+"' "+sel+" >"+dat+"</option>");
							k++;
						}
					}
					if(rset1 != null)rset1.close();	
					if(stmt1 != null)stmt1.close();
%>
					</Select>
<%
					if(defstr.equals(""))
					{
						disabled="disabled";
					}
				}
				else if(discrmsrresulttype.equals("C"))
				{
					String chk = "";
					if(defstr.equals("Y"))
						chk = "checked";
					out.println("<input type='checkbox' name='str_id1_"+i+"' id='str_id1_"+i+"' value='Y' "+chk+">");
				}
				else if(discrmsrresulttype.equals("F"))
				{
					String display = "";
					if(defdata.indexOf("<html>")==-1)
						display = defdata;
					out.println("<textarea name='str_id1_"+i+"' rows='3' cols='71'>"+display+"</textarea>");
				}
				else if(discrmsrresulttype.equals("N") &&  !(defnum.equals("")) && errorRemarks.equals("Æ") )
				{
					out.println("<input type='text' name='str_id1_"+i+"' id='str_id1_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defnum+"'  OnKeyPress =\"return allowValidNumber(this,event,'"+numdigitsmax+"','"+numdigitsdec+"')\" onBlur=\" if(this.value!= '') validateNumber(this,'"+numreflow+"','"+numrefhigh+"','"+i+"','"+numdigitsdec+"','"+numcritlow+"','"+numcrithigh+"','"+numdigitsmin+"','"+module_id+"','"+shortdesc+"')\"  disabled >");

					if(defnum.equals(""))
					{
						disabled="disabled";
					}
				}
				else if (!(defstr.equals("")) && errorRemarks.equals("Æ"))
				{
					if(discrmsrresulttype.equals("E"))
						maxsize = 16;
					else if(discrmsrresulttype.equals("D"))
						 maxsize = 10;
					else if(discrmsrresulttype.equals("T"))
						 maxsize =5;
					out.println("<input type='text' name='str_id1_"+i+"' id='str_id1_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defstr+"' onblur= \" return validateDateTime(this,'"+discrmsrresulttype+"'); \" >");
					if(defstr.equals(""))
					{
						disabled="disabled";
					}
				}

				if(!errorRemarks.equals("Æ"))//means null so no comments should come
				{
					disabled = "checked disabled";
				}
%>
			</td>

<%
		if(!discrmsrresulttype.equals("F"))
		{
%>
			<td width="10%"><%=numuom%></td>
			<td width="13%"><%=range%></td>
			<td width="11%" id='nor_<%=i%>'><%=normabnormind%></td>
			<td  width='2%'>
				
			<input type='hidden' name='remarks<%=count%>' id='remarks<%=count%>' value=''><input type='hidden' name='flag<%=count%>' id='flag<%=count%>' value='N'></td>
			<td id='remID<%=count%>' align ='left' width='4%'>
<%
			if(errorRemarks.equals("Æ"))//means null so no comments should come
			{
				out.println("&nbsp;");
			}
			else	
			{
				out.println("<a href='javascript:showRemarks(\""+errorRemarks+"\",\"y\",\""+count+"\")' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</b></a>");
			}
%>
			</td>
			<!--<td>-->  <!-- commented for PMG2012-CRF-0017 -->
<%
		}
		count++;
	} 
	else if(amendMode.equals("Y") )
	{
		if(!errorRemarks.equals("Æ"))//means null so no comments should come
		{
			disabled="checked disabled";
		}
%>
			<!-- </td> -->  <!-- commented for PMG2012-CRF-0017 -->
<%
		if(!discrmsrresulttype.equals("F"))
		{
%>
			<td width="10%"><%=numuom%></td>
			<td width="13%"><%=range%></td>
			<td width="11%" id='nor_<%=i%>'><%=normabnormind%></td>
			<td align ='left' width='2%'><input type='checkbox' name=errorChk<%=count%> onclick='callRemarksBox(this,"<%=count%>");' <%=disabled%>>
				
			<input type='hidden' name='remarks<%=count%>' id='remarks<%=count%>' value=''><input type='hidden' name='flag<%=count%>' id='flag<%=count%>' value='N'></td>
			<td id='remID<%=count%>' align ='left' width='4%'>
<%
			if(errorRemarks.equals("Æ"))//means null so no comments should come
			{
				out.println("&nbsp;");
			}
			else
			{
				out.println("<a href='javascript:showRemarks(\""+errorRemarks+"\",\"y\",\""+count+"\")' ><b>!</b></a>");
			}
%>
			</td>
			<!--<td>-->  <!-- commented for PMG2012-CRF-0017 -->
<%
		}
		count++;
	}
	else
	{
		if(!discrmsrresulttype.equals("F"))
		{
		if(refrangetype.equals("M") && defseq != crtseq) //IN036756
		{
		} else
		{
%>
			<td width="10%"><%=numuom%></td>
			<td width="15%"><%=range%></td>
			<td width="15%" id='nor_<%=i%>'><%=normabnormind%></td>

			<td id='remID<%=count%>' align ='left' width='4%'>
<%
			if(errorRemarks.equals("Æ"))//means null so no comments should come
			{
				out.println("&nbsp;");
			}
			else
			{
				out.println("<a href='javascript:showRemarks(\""+errorRemarks+"\",\"y\",\""+count+"\")' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Error.label","common_labels")+"</b></a>");
			}
%>
			</td>
			<!--<td> -->  <!-- commented for PMG2012-CRF-0017 -->
<%
		}
		}
	}
%>
			
		<input type="hidden" name="item_id_<%=i%>" id="item_id_<%=i%>" value="<%=discrmsrid%>" >
		<input type="hidden" name="uom_id_<%=i%>" id="uom_id_<%=i%>" value="<%=numuom%>" >
		<input type="hidden" name="normal_low_<%=i%>" id="normal_low_<%=i%>" value="<%=numreflow%>" >
		<input type="hidden" name="normal_high_<%=i%>" id="normal_high_<%=i%>" value="<%=numrefhigh%>" >
		<input type="hidden" name="num_digits_dec_<%=i%>" id="num_digits_dec_<%=i%>" value="<%=numdigitsdec%>" >	
		<input type="hidden" name="op_type_<%=i%>" id="op_type_<%=i%>" value="<%=optype%>" >
		<input type="hidden" name="result_type_<%=i%>" id="result_type_<%=i%>" value="<%=discrmsrresulttype%>" >
		<input type="hidden" name="num_crit_low_<%=i%>" id="num_crit_low_<%=i%>" value="<%=numcritlow%>" >					
		<input type="hidden" name="num_crit_high_<%=i%>" id="num_crit_high_<%=i%>" value="<%=numcrithigh%>" >	
		<input type="hidden" name="accession_num_<%=i%>" id="accession_num_<%=i%>" value="<%=accessionnum%>" >
		<input type="hidden" name="def_data_<%=i%>" id="def_data_<%=i%>" value='<%=defdata%>' >	
		<input type="hidden" name="norm_abnorm_ind_<%=i%>" id="norm_abnorm_ind_<%=i%>" value='<%=normabnormind%>' >		
		<input type="hidden" name="mandatory_yn_<%=i%>" id="mandatory_yn_<%=i%>" value='<%=mandatoryyn%>' >			
		<!--</td>-->  <!-- commented for PMG2012-CRF-0017 -->
	</tr>
<%
		disabled = ""; //reinitializing
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
    </table>
	<input type="hidden" name="no_of_rec" id="no_of_rec" value="<%=i%>" >
	<input type="hidden" name="last_record_date" id="last_record_date" value="<%=lastrecorddate%>" >
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>" >
	<input type="hidden" name="episode_id" id="episode_id" value="<%=episodeid%>" >
	<input type="hidden" name="episode_type" id="episode_type" value="<%=episodetype%>" >
	<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>" >
	<input type="hidden" name="visit_id" id="visit_id" value="<%=visitid%>" >
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>" >
	<input type="hidden" name="clinician_id" id="clinician_id" value="<%=clinicianid%>" >
	<input type="hidden" name="adm_dt_time" id="adm_dt_time" value="<%=admdttime%>" >
	<input type="hidden" name="locn_code" id="locn_code" value="<%=locncode%>" >
	<input type="hidden" name="low_str" id="low_str" value="<%=lowstr_desc%>" >
	<input type="hidden" name="high_str" id="high_str" value="<%=highstr_desc%>" >
	<input type="hidden" name="abn_str" id="abn_str" value="<%=abnstr_desc%>" >
	<input type="hidden" name="crit_low_str" id="crit_low_str" value="<%=critlowstr_desc%>" >
	<input type="hidden" name="crit_high_str" id="crit_high_str" value="<%=crithighstr_desc%>" >
	<input type="hidden" name="crit_abn_str" id="crit_abn_str" value="<%=critabnstr%>" >
	<input type="hidden" name="battery_id" id="battery_id" value="<%=batteryid%>" >	
	<input type="hidden" name="sys_date_time" id="sys_date_time" value="<%=sysdatetime%>" >
	<input type="hidden" name="in_error" id="in_error" value="<%=amendMode%>" >
	<input type="hidden" name="in_replace" id="in_replace" value="<%=replaceMode%>" >
	<input type="hidden" name="module_id" id="module_id" value='<%=module_id%>' >
	<input type="hidden" name="location_type" id="location_type" value='<%=location_type%>' >
	<input type="hidden" name="replaceError_count" id="replaceError_count" value='<%=count%>' >
	<input type="hidden" name="patsex" id="patsex" value="<%=patsex%>" >
	<input type="hidden" name="dob" id="dob" value="<%=dob%>" >
	<!--IN034536 Starts-->
	<input type="hidden" name="isPatientEncMovement" id="isPatientEncMovement" value='<%=isPatientEncMovement%>' >
	<input type="hidden" name="p_queue_date" id="p_queue_date" value="<%=p_queue_date%>" >
	<input type="hidden" name="Sydate" id="Sydate" value="<%=Sydate%>" >
	<!--IN034536 Ends -->
	<!-- IN037701 start -->
	<input type="hidden" name="disc_id" id="disc_id" value=''>
	<input type=hidden name=qs value="<%=qs %>">
	<input type=hidden name=dup_yn value=''>
	<!-- IN037701 - end-->
</form>
<%
	if(out_mode!=null && out_mode.equals("showpage"))
	{} 
	else
	{
%>
<script>
		//resetForm("pageload");
</script>
<%
	}
%>

</body>
</html>

<%
	}
	catch ( Exception e)
	{
		//out.println("Out "+e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	
%>

