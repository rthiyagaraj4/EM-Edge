<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eAE/js/AEPatientTMTQuery.js'></script>
<script language='javascript' src='../../eAE/js/AEPractitionerComponent.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function chkMandatory()
	{
		alert(document.form(0).patbytrmtroom_datefrom.value);
/*	if(f_patientByCriteria.AEPatientByCriteriaForm.ae_patbycriteria_datefrom.value=='' )
	  {
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK",'SM'));
		f_patientByCriteria.AEPatientByCriteriaForm.ae_patbycriteria_datefrom.focus();
		return false; */
return true;
	  }
</script>
</head> 
<body onLoad='callfocus()' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center>
<form name='AEPatientTMTSearchForm' id='AEPatientTMTSearchForm'>
<table border='0' cellpadding='2' cellspacing='0' width='100%' height='10'>
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	java.sql.Statement			stmt		=	null;
	 ResultSet			rs			=	null;


	String	date_sys				=	"";
	String	date_sys1			=	"";
	String	facility_id				=	"";
	String	clinic_type				=	"";
	String	clinic_code				=	"",		clinic_desc				=	"";
	String	open_to_all_pract_yn	=	"";
	String	p_sql					=	"";    // oper_stn_id             =	"";
	String	p_patient_id_length		=	"",     login_user_id			=	"";
	StringBuffer query_location  = new StringBuffer();	
	StringBuffer query_operator_station  = new StringBuffer();	
	String locale				= (String)session.getAttribute("LOCALE");
	 String sql_sys="";
	int		rowIndex				=	1;
	
	//Added for this AAKH-CRF-0010 [IN:038535]
	String FIVE_LEVEL_TRIAGE_APPL_YN="N";
	String priorty_zone_check="";
	String priority_zone_all_codes="";
	String priority_zone_code="";
    String priority_where = "";
    Boolean isPriorityZoneAppl			= false;//Added By Shanmukh for MMS-DM-CRF-0147
	/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	String sql              ="";
	/* crf  SKR-CRF-0021 [IN028173] end */
try
	{
	     request.setCharacterEncoding("UTF-8");
		con				=	(Connection)	ConnectionManager.getConnection(request);
		isPriorityZoneAppl			=	CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");//Added By Shanmukh for MMS-DM-CRF-0147
		facility_id		=	(String)		session.getValue("facility_id");
		login_user_id	=	(String)		session.getValue("login_user");
		
		/*query_operator_station.append(" select oper_stn_id, long_desc oper_stn_desc ");
		query_operator_station.append(" from am_user_for_oper_stn_vw ");
		query_operator_station.append(" where appl_user_id = ? and facility_id = ? ");

		pstmt		=	con.prepareStatement(query_operator_station.toString());

		pstmt.setString	(	1,	login_user_id	);
		pstmt.setString	(	2,	facility_id		);

		rs			=	pstmt.executeQuery();

		if(rs.next())
		{
			oper_stn_id		=	rs.getString("oper_stn_id");
		}
        if(rs!=null)	rs.close(); 
		if(pstmt!=null)	pstmt.close();*/
		
		/*Below line added for this CRF AAKH-CRF-0010 [IN:038535]*/		
      try{		
		     stmt = con.createStatement();
			 rs   = stmt.executeQuery("select FIVE_LEVEL_TRIAGE_APPL_YN  from ae_param where OPERATING_FACILITY_ID='"+facility_id+"'");
		     if(rs!=null && rs.next()){
			   FIVE_LEVEL_TRIAGE_APPL_YN=rs.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
			   if(FIVE_LEVEL_TRIAGE_APPL_YN.equals("Y")) priorty_zone_check = "CHECKED";
			 }
			   if(rs!=null) rs.close();
			   if(stmt!=null) stmt.close();	
         }catch(Exception e){
            e.printStackTrace();
        }	
       
	   try{
	      stmt = con.createStatement();
	      if(!FIVE_LEVEL_TRIAGE_APPL_YN.equals("Y")){
	    	  priority_where	= " and priority_zone not in ('B','W') ";
	      }
	      if(isPriorityZoneAppl){//Added By Shanmukh for MMS-DM-CRF-0147
			  rs = stmt.executeQuery("SELECT PRIORITY_ZONE FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' "+priority_where+" order by PRIORITY_ZONE_ORDER asc");
		  }else{
		  rs = stmt.executeQuery("SELECT PRIORITY_ZONE FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and EFF_STATUS='E' "+priority_where+" order by PRIORITY_ZONE_ORDER asc");}	   
	      while(rs!=null && rs.next()){
					priority_zone_code	= rs.getString("PRIORITY_ZONE");
					priority_zone_all_codes	= priority_zone_all_codes + priority_zone_code + ",";	   
	      }
			if(!priority_zone_all_codes.equals("")&&priority_zone_all_codes.length()> 0)			
			          priority_zone_all_codes=priority_zone_all_codes.substring(0,priority_zone_all_codes.length()-1);
			
	      if(rs!=null) rs.close();
		  if(stmt!=null) stmt.close();	
	   }catch(Exception e1){
	   e1.printStackTrace();
	   }
	  /*End AAKH-CRF-0010 [IN:038535]*/

		try
			{
				sql_sys = "select to_char(SYSDATE,'dd/mm/yyyy hh24:mi') date_sys,to_char(SYSDATE-1,'dd/mm/yyyy hh24:mi') date_sys1 from dual";

				stmt = con.createStatement();
				rs   = stmt.executeQuery(sql_sys);
				
			if (rs.next())
				{
					date_sys = rs.getString(1);
					date_sys1 = rs.getString(2);
					date_sys1=DateUtils.convertDate(date_sys1,"DMYHM","en",locale);
					date_sys=DateUtils.convertDate(date_sys,"DMYHM","en",locale);
				}

				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}		
				finally
		{
			if(rs!=null) rs.close();
			if (stmt!=null )stmt.close();
		}
		
		try
		{
			p_sql	= "select patient_id_length from mp_param where module_id='MP'";

			stmt	= con.createStatement();

			rs		= stmt.executeQuery(p_sql);

			while (rs.next())
			{
				p_patient_id_length = rs.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if (stmt!=null )stmt.close();
		}
	%>


	<tr>
		<td class='LABEL' width="25%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='field' width="25%"><select name='clinic_code' id='clinic_code' tabindex=1 onChange="clear_chk_select1();populateDynamicValues('TreatmentArea');">
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  -----</option>
<%
		try
		{
			query_location.append("select a.clinic_code, a.long_desc clinic_desc, a.clinic_type,  a.open_to_all_pract_yn,a.speciality_code from op_clinic_lang_vw a,(select day_no from sm_day_of_week   where day_of_week = rtrim(to_char(sysdate,'DAY'))) b  where decode(b.day_no,'1',working_day_1,'2',working_day_2,'3',  working_day_3,'4', working_day_4,'5',working_day_5,'6',  working_day_6,'7',working_day_7)='Y'  and a.facility_id = ? and language_id ='"+locale+"' and a.clinic_type  = 'C' and a.level_of_care_ind = 'E' and a.eff_status = 'E' order by 2");
			
			
			pstmt		=	con.prepareStatement(query_location.toString());
			pstmt.setString	(	1,	facility_id		);
			//pstmt.setString	(	2,	facility_id		);
			//pstmt.setString	(	4,	login_user_id	);

			rs			=	pstmt.executeQuery(); 
			String spec_code="";
			while(rs.next())
			{
				clinic_code				=	rs.getString("clinic_code");
				clinic_desc				=	rs.getString("clinic_desc");
				clinic_type				=	rs.getString("clinic_type");
				open_to_all_pract_yn	=	rs.getString("open_to_all_pract_yn");
				spec_code               =   rs.getString("speciality_code");

	%>
			<option value='<%=clinic_code%>' ><%=clinic_desc%></option>
		    

	    	<script>self.openToAllPractionerYN[<%=rowIndex%>]='<%=open_to_all_pract_yn%>';
			self.clinicType[<%=rowIndex%>]='<%=clinic_type%>';
			self.specialtyForClinc[<%=rowIndex%>]='<%=spec_code%>'; 
			</script> 
	<%			
			 rowIndex++;
			}
	
			if(rs!=null)rs.close();
			if(pstmt!=null)	pstmt.close();

	%>
		</select></td>

<%     }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		    if(rs!=null) rs.close(); 
			if(pstmt!=null)	pstmt.close();
		}
	%>

	</select></td>
		<td class='LABEL' width="25%" ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
		<td class='field' width="25%"><select name='treatment_area_code' id='treatment_area_code' tabindex=2 onChange='checkTreatmentGender()'>
		<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
		</select></td>
	</tr>
	<tr>
		<td class='LABEL' width="25%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='field' width="25%" ><input type=text name=practitioner_desc size=30 maxlength=30 onBlur="beforeGetPractitioner2(practitioner_id,practitioner_desc);" ><input type=hidden name='practitioner_id' id='practitioner_id' ><input type=button class=button value='?' name='Practitioner_lookup_button' id='Practitioner_lookup_button' onClick="getPractitioner2(practitioner_id,practitioner_desc);"><input type='hidden' name='prev_pract_name' id='prev_pract_name' value="">
		<td class='LABEL' width="25%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='field' width="25%"><input type='text' name='patient_id' id='patient_id'  tabindex=4 onKeyPress="return(CheckForSpecChars(event))"  value="" size='20' maxlength='<%=p_patient_id_length%>' onBlur='changeCase(this);'><input type='button' class='BUTTON' value="?"  name='patient_search' id='patient_search' onClick = 'callPatientSearch()'></td>
	</tr>
	
	<tr>
		<td class = 'LABEL' width ='25%'><fmt:message key="Common.DateFrom.label" bundle="${common_labels}" /></td>
		<td class = 'field' width='25%'><input type = 'text' id ='pattrmtfrom' name= 'patbytrmtroom_datefrom' maxlength = '16' value='<%=date_sys1%>' size ='18' onBlur="if(validDateObj(this,'DMYHM','<%=localeName%>')){doDate(this)}"><img src="../../eCommon/images/CommonCalendar.gif" onClick = "return showCalendar('pattrmtfrom','hh:mm');"></img></td>

		<td class ='LABEL' width='25%'><fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
		<td class='field' width ='25%'><input type='text' id='pattrmtto' name='patbytrmtroom_to' id='patbytrmtroom_to' maxlenght='16' value='<%=date_sys%>' size='18'onBlur="if(validDateObj(this,'DMYHM','<%=localeName%>')){doDate(this)}"><img src ="../../eCommon/images/CommonCalendar.gif" onClick= "return showCalendar('pattrmtto','hh:mm');"></img>
		</td>
	</tr>

    <tr>
		  <td class='LABEL' width="25%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='field' width="25%"><select name='priority' id='priority' tabindex=5>
		<option value=''>&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
		
    <!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
		<%
			if(isPriorityZoneAppl){//Added By Shanmukh for MMS-DM-CRF-0147
				sql="SELECT PRIORITY_ZONE ,PRIORITY_ZONE_TAB_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? "+priority_where+"  order by PRIORITY_ZONE_ORDER ";
			}else{
			sql="SELECT PRIORITY_ZONE ,PRIORITY_ZONE_TAB_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' "+priority_where+"  order by PRIORITY_ZONE_ORDER ";}
				
			    pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rs    = pstmt.executeQuery();
				while(rs!=null && rs.next())
				{
				out.println("<option value='"+rs.getString(1)+"'>");	     
			   out.println(rs.getString(2));
			   out.println("</option>"); 
				}
		    
			
		    if(rs!=null)rs.close();
			if(pstmt!=null)	pstmt.close();
		 %>
		 
		
		</select></td>
		<!--CRF  SKR-CRF-0021 [IN028173] end-->
		
		<td class='LABEL' width="25%"><fmt:message key="eAE.OrderByPriority.label" bundle="${ae_labels}"/></td>
		<%if(FIVE_LEVEL_TRIAGE_APPL_YN.equals("Y")){%>
		<td class='field' width="25%"><input type='checkbox' name='order_by_priority' id='order_by_priority' tabindex=7 value='<%=FIVE_LEVEL_TRIAGE_APPL_YN%>' <%=priorty_zone_check%>> </td>
		<%
			}
		else
			{
			%><td class='field' width="25%"><input type='checkbox' name='order_by_priority' id='order_by_priority' tabindex=7 value='Y'> </td><%
			}
		%>
		<!--Above line modified for this CRF 038535-->
	</tr>
	<tr>

		<td class='LABEL' width="25%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='field' width="25%"><select name='gender' id='gender' tabindex=6> 
		<option value=''>&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;</option>
		<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
		<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select></td>
        <td>&nbsp;</td>
		<td class='button' width="25%"><input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' name='refresh' onClick='showQueryResult()' tabindex=8>&nbsp;<input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' name='clear' onClick='ClearFunction()' tabindex=9></td>
	</tr>
</table>
<%	
	query_operator_station.setLength(0);
    query_location.setLength(0);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
				if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
 	<input type='hidden' name='patient_gender' id='patient_gender' value=''>
	<input type='hidden' name='clinic_type' id='clinic_type' value=''>
	<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>'>
    <input type='hidden' name='chk_Select1' id='chk_Select1' value=''>
    <input type='hidden' name='sysdate' id='sysdate' value='<%=date_sys%>'>
	<input type='hidden' name='FIVE_LEVEL_TRIAGE_APPL_YN' id='FIVE_LEVEL_TRIAGE_APPL_YN' value='<%=FIVE_LEVEL_TRIAGE_APPL_YN%>'>
	<!--Below line added for this CRF AAKH-CRF-0010 [IN:038535]-->
	<input type='hidden' name='priority_zone_all_codes' id='priority_zone_all_codes' id="priority_zone_all_codes" value='<%=priority_zone_all_codes%>' >
	
<script>
		parent.parent.frames[0].document.forms[0].reset.disabled=false;
	</script>

</form>
</center>
</body>
</html>
		

