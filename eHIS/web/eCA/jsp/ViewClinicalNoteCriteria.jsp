<!-- 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?       	      100            ?           created
30/01/2014  	EMR1508      Dinesh T       Transcribed note is not shown in the result page
10/07/2013		IN038643	 Karthi L		A new field by name "Speciality" have been introduced as search filter in View Clinical Notes function in Clinician Access		
26/8/2013	IN042640		Karthi L	Alignment problem 	
26/08/2013	IN042677		Karthi L		Specialty ï¿½webpage dialog is displayed to select specialty.   
18/09/2013	  IN043437	   Karthi L		By selecting Specialty having Special characters we get wrong message prompt.
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
05/10/2016	IN047572			Karthi L										[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the â??View Clinical Notesâ?? and â??Clinical Event Historyâ??				
15/03/2017		IN051294		Krishna Gowtham J									MO-CRF-20087
--------------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	// added by Arvind @ 04-11-08 
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
			 //end
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />

<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script Language="JavaScript" src="../../eCA/js/DateValidation.js"></script>
<script Language="JavaScript" src='../../eCA/js/ViewClinicalNote.js'></script>
<script Language="JavaScript" src='../../eCommon/js/dchk.js'> </script>
<script language='javascript' src='../../eCA/js/DateCheck.js' ></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%


java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
String locale			= (String) p.getProperty("LOCALE");

String note_group       ="";
String note_group_desc  ="";
String note_type		="";
String note_type_desc="";
String toDate	="";
String dfltDate	="";
String checkEnc = "";
String encVal = "";
String patient_line	= request.getParameter("patient_line")==null?"":request.getParameter("patient_line");
String function_id	= request.getParameter("function_id")==null?"":request.getParameter("function_id");
String episode_type	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
String encounter_id	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String patient_id	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String accession_number = request.getParameter("accession_num") == null ? "" : request.getParameter("accession_num");	
String called_function_id	=request.getParameter("called_function_id")==null?"":request.getParameter("called_function_id");//CHL_CRF_0010
//IN051294 start
ResultSet rs = null;
Connection con = null;
HashMap map = new HashMap();
String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
String sqlFilter = "";
PreparedStatement stmtsql = null;
con = ConnectionManager.getConnection(request);
StringTokenizer strToken = null;
String column_id ="";
String column_desc ="";
String value_type ="";
String actual_value ="";
String date_time_rel_id ="";
String date_time_rel_val ="";
String date_time_rel_unit ="";
String relative_value ="";
String final_value ="";
String fromDate	="";
String toDateTemp ="";
String field_desc = "";
String date_ind = "", date_val = "", date_unit = "", date_ref = "";
String performed_by = "";
String performed_by_desc = "";
String med_anc = "";
String med_anc_desc = "";
String specialty = "";
String specialty_desc = "";
String attend_pract = "";
String attend_pract_desc = "";
String status_code = "";
String aSel = "", uSel = "", tSel = "", mSel = "", eSel = "", nSel = "", dSel = "", auSel = "", daSel = "";
String group_by = "";
String order_by = "";
String default_sql = "";
int Existance_Count = 0;
StringBuffer default_query = new StringBuffer();
String login_user	= (String)session.getValue("login_user");
String resp_id	= (String)session.getValue("responsibility_id");
String facilityId = (String)session.getValue("facility_id");
//IN051294 ends		
String querystring = (request.getQueryString()==null)?"":request.getQueryString();
String facilityid		= (String) session.getValue("facility_id");

try
{
//IN051294 start
	if(ql_ref.equals("") && !default_yn.equals("N"))
	{
		default_sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = 'PHYSICIAN_NOTES' AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";
		stmtsql = con.prepareStatement(default_sql);
		
		stmtsql.setString(1,login_user);
		stmtsql.setString(2,resp_id);
		stmtsql.setString(3,locale);
		rs = stmtsql.executeQuery();
		if(rs.next())
		{
			Existance_Count = rs.getInt("EXISTANCE_COUNT");
		}
		if(rs != null) rs.close();
		if(stmtsql != null) stmtsql.close();

		default_query.append("select A.QUICK_LINK_REF from ");
		if(Existance_Count>0)
			default_query.append(" SM_QUICK_LINK_FOR_USER A where A.APPL_USER_ID = ? ");
		else
			default_query.append(" SM_QUICK_LINK_RESP A where A.RESP_ID = ? ");
		default_query.append(" and OPTION_ID = 'PHYSICIAN_NOTES' and LINK_TYPE = 'F' and DEFAULT_YN = 'Y'");
		default_query.append(" and added_facility_id = ? ");
			
		stmtsql = con.prepareStatement(default_query.toString());
		if(Existance_Count>0)
			stmtsql.setString(1,login_user);
		else
			stmtsql.setString(1,resp_id);
		stmtsql.setString(2,facilityId);
		rs = stmtsql.executeQuery();
		if(rs.next())
		{
			ql_ref = rs.getString(1) == null ? "" : rs.getString(1);
		}

		if(stmtsql != null) stmtsql.close();
		if(rs != null) rs.close();
	}

	if(!ql_ref.equals(""))
		{
			
			sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID and OPTION_ID = 'PHYSICIAN_NOTES') COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
			stmtsql = con.prepareStatement(sqlFilter);
			stmtsql.setString(1,ql_ref);
			rs = stmtsql.executeQuery();

			while(rs.next())
			{
				column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
				column_desc = rs.getString("COLUMN_DESC") == null ? "" : rs.getString("COLUMN_DESC");
				value_type = rs.getString("VALUE_TYPE") == null ? "" : rs.getString("VALUE_TYPE");
				actual_value = rs.getString("ACTUAL_VALUE") == null ? "" : rs.getString("ACTUAL_VALUE");
				date_time_rel_id = rs.getString("DATETIME_RELATIVE_IND") == null ? "" : rs.getString("DATETIME_RELATIVE_IND");
				date_time_rel_val = rs.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs.getString("DATETIME_RELATIVE_VAL");
				date_time_rel_unit = rs.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs.getString("DATETIME_RELATIVE_UNIT");
				relative_value = rs.getString("RELATIVE_FIELD_REF") == null ? "" : rs.getString("RELATIVE_FIELD_REF");
				if(value_type.equals("A"))
					final_value = actual_value;
				else
				{
					if(column_id.equals("PERIOD_FROM") || column_id.equals("PERIOD_TO"))
					{
						if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
						{
							final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
						}
						else
							final_value = "";
					}
					else
						final_value = relative_value;
				}

				map.put(column_id,final_value);


			}
			
			if(stmtsql != null) stmtsql.close();
			if(rs != null) rs.close();
		}

if(ql_ref.equals(""))
{	
	if(accession_number.equals(""))
	{
		checkEnc = " checked ";
		encVal = "Y";
	}
	else
	{
		checkEnc = "";
		encVal = "N";
	}
}
else if(!ql_ref.equals(""))
{
	field_desc = (String) map.get("LIMIT_TO_CURRENT_ENCOUNTER") == null ? "" : (String) map.get("LIMIT_TO_CURRENT_ENCOUNTER");
	if(field_desc.equals("Y"))
	{
		checkEnc = " checked ";
		encVal = "Y";
	}
	else
	{
		checkEnc = "";
		encVal = "N";
	}
}
		if(ql_ref.equals(""))
		{
			toDate		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			fromDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,7,"d");
		}
		else if(!ql_ref.equals(""))
		{
			field_desc = (String) map.get("PERIOD_FROM") == null ? "" : (String) map.get("PERIOD_FROM");
			String currDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			int noOfdays = 0;
			if(!field_desc.equals(""))
			{
				strToken = new StringTokenizer(field_desc,"|");
				if(strToken.hasMoreTokens())
				{
					date_ind = strToken.nextToken();
					date_val = strToken.nextToken();
					date_unit = strToken.nextToken();
					date_ref = strToken.nextToken();
				}
				noOfdays = Integer.parseInt(date_val);
				if(date_ind.equals("B"))
					fromDate = com.ehis.util.DateUtils.minusDate(currDate,"DMY",locale,noOfdays,date_unit);
				else if(date_ind.equals("A"))
					fromDate = com.ehis.util.DateUtils.plusDate(currDate,"DMY",locale,noOfdays,date_unit);
			}
			else
			{
				toDateTemp		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
				fromDate	= com.ehis.util.DateUtils.minusDate(toDateTemp,"DMY",locale,7,"d");
			}
			
			field_desc = (String) map.get("PERIOD_TO") == null ? "" : (String) map.get("PERIOD_TO");
			if(!field_desc.equals(""))
			{
				strToken = new StringTokenizer(field_desc,"|");
				if(strToken.hasMoreTokens())
				{
					date_ind = strToken.nextToken();
					date_val = strToken.nextToken();
					date_unit = strToken.nextToken();
					date_ref = strToken.nextToken();
				}
				noOfdays = Integer.parseInt(date_val);
				if(date_ind.equals("B"))
					toDate = com.ehis.util.DateUtils.minusDate(currDate,"DMY",locale,noOfdays,date_unit);
				else if(date_ind.equals("A"))
					toDate = com.ehis.util.DateUtils.plusDate(currDate,"DMY",locale,noOfdays,date_unit);

			}
			else
			{
				toDate		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			}
			
			field_desc = (String) map.get("NOTE_GROUP") == null ? "" : (String) map.get("NOTE_GROUP");
			if(!field_desc.equals(""))
			{
				note_group = field_desc;
				sqlFilter = "SELECT NOTE_GROUP_DESC FROM CA_NOTE_GROUP WHERE NOTE_GROUP = ?";
				stmtsql = con.prepareStatement(sqlFilter);
				stmtsql.setString(1,note_group);
				rs = stmtsql.executeQuery();
				if(rs.next())
					note_group_desc = rs.getString("NOTE_GROUP_DESC") == null ? "" : rs.getString("NOTE_GROUP_DESC");
				
				if(rs != null) rs.close();
				if(stmtsql != null) stmtsql.close();
			}
			
			field_desc = (String) map.get("NOTE_TYPE") == null ? "" : (String) map.get("NOTE_TYPE");
			if(!field_desc.equals(""))
			{
				note_type = field_desc;
				sqlFilter = "SELECT NOTE_TYPE_DESC FROM CA_NOTE_TYPE WHERE NOTE_TYPE = ?";
				stmtsql = con.prepareStatement(sqlFilter);
				stmtsql.setString(1,note_type);
				rs = stmtsql.executeQuery();
				if(rs.next())
					note_type_desc = rs.getString("NOTE_TYPE_DESC") == null ? "" : rs.getString("NOTE_TYPE_DESC");
				
				if(rs != null) rs.close();
				if(stmtsql != null) stmtsql.close();
			}
			
			field_desc = (String) map.get("PERFORMED_BY") == null ? "" : (String) map.get("PERFORMED_BY");
			if(!field_desc.equals(""))
			{
				performed_by = field_desc;
				sqlFilter = "SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = ? and EFF_STATUS = 'E'";
				stmtsql = con.prepareStatement(sqlFilter);
				stmtsql.setString(1,performed_by);
				rs = stmtsql.executeQuery();
				if(rs.next())
					performed_by_desc = rs.getString("PRACTITIONER_NAME") == null ? "" : rs.getString("PRACTITIONER_NAME");
				
				if(rs != null) rs.close();
				if(stmtsql != null) stmtsql.close();
			}
			
			field_desc = (String) map.get("MEDANC_SERV") == null ? "" : (String) map.get("MEDANC_SERV");
			if(!field_desc.equals(""))
			{
				med_anc = field_desc;
				sqlFilter = "SELECT SHORT_DESC FROM AM_SERVICE WHERE SERVICE_CODE = ? and EFF_STATUS = 'E'";
				stmtsql = con.prepareStatement(sqlFilter);
				stmtsql.setString(1,med_anc);
				rs = stmtsql.executeQuery();
				if(rs.next())
					med_anc_desc = rs.getString("SHORT_DESC") == null ? "" : rs.getString("SHORT_DESC");
				
				if(rs != null) rs.close();
				if(stmtsql != null) stmtsql.close();
			}
			
			field_desc = (String) map.get("SPECIALITY") == null ? "" : (String) map.get("SPECIALITY");
			if(!field_desc.equals(""))
			{
				specialty = field_desc;
				sqlFilter = "SELECT SHORT_DESC FROM AM_SPECIALITY WHERE SPECIALITY_CODE = ? and EFF_STATUS = 'E'";
				stmtsql = con.prepareStatement(sqlFilter);
				stmtsql.setString(1,specialty);
				rs = stmtsql.executeQuery();
				if(rs.next())
					specialty_desc = rs.getString("SHORT_DESC") == null ? "" : rs.getString("SHORT_DESC");
				
				if(rs != null) rs.close();
				if(stmtsql != null) stmtsql.close();
			}
			
			field_desc = (String) map.get("ATTEND_PRACT") == null ? "" : (String) map.get("ATTEND_PRACT");
			if(!field_desc.equals(""))
			{
				attend_pract = field_desc;
				sqlFilter = "SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = ? and EFF_STATUS = 'E'";
				stmtsql = con.prepareStatement(sqlFilter);
				stmtsql.setString(1,attend_pract);
				rs = stmtsql.executeQuery();
				if(rs.next())
					attend_pract_desc = rs.getString("PRACTITIONER_NAME") == null ? "" : rs.getString("PRACTITIONER_NAME");
				
				if(rs != null) rs.close();
				if(stmtsql != null) stmtsql.close();
			}
			
			field_desc = (String) map.get("STATUS") == null ? "" : (String) map.get("STATUS");
			if(!field_desc.equals(""))
			{
				status_code = field_desc;
				
				if(status_code.equals("A"))
				{
					auSel = "selected"; uSel = ""; tSel = ""; mSel = ""; eSel = "";
				}
				else if(status_code.equals("U"))
				{
					auSel = ""; uSel = "selected"; tSel = ""; mSel = ""; eSel = "";
				}
				else if(status_code.equals("T"))
				{
					auSel = ""; uSel = ""; tSel = "selected"; mSel = ""; eSel = "";
				}
				else if(status_code.equals("M"))
				{
					auSel = ""; uSel = ""; tSel = ""; mSel = "selected"; eSel = "";
				}
				else if(status_code.equals("E"))
				{
					auSel = ""; uSel = ""; tSel = ""; mSel = ""; eSel = "selected";
				}
			}
			
			field_desc = (String) map.get("GROUP_BY") == null ? "" : (String) map.get("GROUP_BY");
			if(!field_desc.equals(""))
			{
				group_by = field_desc;
				
				if(group_by.equals("N"))
				{
					nSel = "selected"; daSel = "";
				}
				else if(group_by.equals("D"))
				{
					nSel = ""; daSel = "selected";
				}
			}
			
			field_desc = (String) map.get("ORDER_BY") == null ? "" : (String) map.get("ORDER_BY");
			if(!field_desc.equals(""))
			{
				order_by = field_desc;
				
				if(order_by.equals("A"))
				{
					aSel = "selected"; dSel = "";
				}
				else if(order_by.equals("D"))
				{
					aSel = ""; dSel = "selected";
				}
			}
			
			
		}
		
//IN051294 ends
	
	/*toDate		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	dfltDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,7,"d");*/ //commented for IN051294
%>


<body  class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='ClinicalNote' id='ClinicalNote'>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	
    <tr>
	<td class="label" width='25%'><fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/></td>
	<td class='fields' width='25%'>
		  <input type='text' name='note_group_desc' id='note_group_desc' value="<%=note_group_desc%>" size="20"  onBlur='getNoteGroups(this)'><input type='button' name='note_desc_search' id='note_desc_search' value='?' class='button' onClick='getNoteGroups(this);'>
		<input type='hidden' name='note_group' id='note_group' value="<%=note_group%>">	
		</td>
		

		<td class="label" width='25%'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
        <td class='fields' width='25%'>
		<input type='text' name='note_type_desc' id='note_type_desc' value="<%=note_type_desc%>" size="20"  disabled onBlur='getnotetype(this)' ><input type='button' name='note_type_search' id='note_type_search' value='?' class='button' onClick='getnotetype(this);' disabled>
		<input type='hidden' name='note_type' id='note_type' value="<%=note_type%>">	
		</td>
			<!--IN051294 starts-->
<%
if(!note_group.equals(""))
{
%>
		<script>
		notetypeenable();
		</script>
<%
}
%>
<!--IN051294 ends-->	
        </tr>
        <tr>
        
	    <td class=label  width='25%'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/></td>
		<!--IN051294 start-->
 	    <!--<td class='fields' width='25%'>
        <input type='text' name="performed_by" id="performed_by" value=""  size='20' maxlength='20' 
	    onkeypress="" onBlur="servicePract(this)"  ><input type='button' class='button' value='?'  name='search_ref' id='search_ref' onClick="servicePract(this)">
	    </td>-->
		
		<td class='fields' width='25%'>
        <input type='text' name="performed_by" id="performed_by" value="<%=performed_by_desc%>"  size='20' maxlength='20' 
	    onkeypress="" onBlur="servicePract(this)"  ><input type='button' class='button' value='?'  name='search_ref' id='search_ref' onClick="servicePract(this)">
	    </td>
		<!--IN051294 ends-->

	    <td class=label width='25%'><fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/></td>
	    <!--IN051294 starts-->
		<!--<td class='fields' width='25%'>
		<input type='text' name="med_anc" id="med_anc" value=""  size='20' maxlength='20' 
	    onkeypress="" onBlur="getMedService(this)" ><input type='button' class='button' value='?'  name='search_ref2' id='search_ref2' onClick="getMedService(this)">
	    </td>-->
		
		<td class='fields' width='25%'>
		<input type='text' name="med_anc" id="med_anc" value="<%=med_anc_desc%>"  size='20' maxlength='20' 
	    onkeypress="" onBlur="getMedService(this)" ><input type='button' class='button' value='?'  name='search_ref2' id='search_ref2' onClick="getMedService(this)">
	    </td>
		<!--IN051294 ends-->
    </tr> 

    <tr>
	
	<td class=label  width='25%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<!--IN051294 Start-->
	<!--<td class='fields' colspan=1><input type='text' size=10 maxlength='10' name='from_date' id='from_date' value='<%=dfltDate%>'onblur='CheckDate(this);ftDateChecknew2(this,to_date,"<%=toDate%>","DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('from_date');"><b>&nbsp;&nbsp;-&nbsp;</b>--><!--Commented for IN051294-->
	
	<td class='fields' colspan=1><input type='text' size=10 maxlength='10' name='from_date' id='from_date' value='<%=fromDate%>'onblur='CheckDate(this);ftDateChecknew2(this,to_date,"<%=toDate%>","DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('from_date');"><b>&nbsp;&nbsp;-&nbsp;</b>
	<input type='text' size=10 maxlength='10' name='to_date' id='to_date' value='<%=toDate%>' onblur='CheckDate(this);ftDateChecknew2(from_date,this, "<%=toDate%>","DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('to_date');">
	
	</td>
	<!--IN051294 ends-->
	<td class=label width='25%' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<!--IN051294 Start-->
		<!--<td class='fields' width='25%'><select name='status' id='status'><option value=''>----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----</option>
		<option value='2'><fmt:message key="Common.Transcribed.label" bundle="${common_labels}"/></option><!--EMR1508-->
		<!--<option value='3'><fmt:message key="Common.Unauthorized.label" bundle="${common_labels}"/></option>
		<option value='4'><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></option>
		<option value='5'><fmt:message key="Common.Modified.label" bundle="${common_labels}"/></option>
		<option value='9'><fmt:message key="Common.InError.label" bundle="${common_labels}"/></option>
		</select>
		</td> Commented for IN051294-->
		
		<td class='fields' width='25%'><select name='status' id='status'><option value=''>----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- -----</option>
		<option value='2'<%=tSel%>><fmt:message key="Common.Transcribed.label" bundle="${common_labels}"/></option><!--EMR1508-->
		<option value='3'<%=uSel%>><fmt:message key="Common.Unauthorized.label" bundle="${common_labels}"/></option>
		<option value='4'<%=auSel%>><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></option>
		<option value='5'<%=mSel%>><fmt:message key="Common.Modified.label" bundle="${common_labels}"/></option>
		<option value='9'<%=eSel%>><fmt:message key="Common.InError.label" bundle="${common_labels}"/></option>
		</select>
		</td>
		<!--IN051294 ends-->
	</tr>
    
	<tr>
    
    
		<td class='label' width='25%'><fmt:message key="eCA.LimittoCurrentEncounter.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%'>
		<input type="checkbox" <%=checkEnc%> value="<%=encVal%>" name="primary" onclick="setCheck()">
		</td>
	<!--  added for BRU-HIMS-CRF-356 [IN038643] - Start -->

		<td class='label' ><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
		<td class='fields'  ><input type='text'  name='specialty' id='specialty' value="<%=specialty_desc%>"  onKeyPress='' onBlur='getSpecialty1(this)' size='20' maxlength='20'><input type='button' name='search' id='search' value='?'  class='button' onClick="if(document.forms[0].specialty.value == '')getSpecialty()"><input type="hidden" name="speciality_code" id="speciality_code" value=''></td> <!-- modified for IN043437 -->
	</tr>
	<!--  added for BRU-HIMS-CRF-356 [IN038643] - End -->
		
		
	<!--</tr> 
	<tr> -->
		<td class='label' width='25%'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
		<SELECT name="group" id="group">
		<!--IN051294 Start-->
		<!--<option value='1' selected><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option>
		<option value='4'><fmt:message key="Common.date.label" bundle="${common_labels}"/></option> Commented for IN051294-->
		
		<option value='1' selected <%=nSel%>><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option>
		<option value='4' <%=daSel%>><fmt:message key="Common.date.label" bundle="${common_labels}"/></option>
		</SELECT>&nbsp; /&nbsp;
		<SELECT name="order" id="order">
		<!--<option value='A' selected ><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
		<option value='D' ><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option> Commented for IN051294-->
		
		<option value='A' selected <%=aSel%>><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
		<option value='D' <%=dSel%>><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option>
		<!--IN051294 ends-->
		</SELECT>
		</td>

		<!--<td class=label width='25%'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td> 
		<td class='fields'  width='25%'>
		<SELECT name="order" id="order">
		<option value='A' selected><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
		<option value='D'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option>
		</SELECT>
		</td> -->
		<td class='label' ><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
		
		<!--IN051294 start-->
		<!--<td class='fields'  ><input type='text'  name='attend_pract_desc' id='attend_pract_desc' value='' onBlur='getPractitioner1(this)' size='20' maxlength='20'><input type='button' name='search' id='search' value='?'  class='button' onClick="if(document.forms[0].attend_pract_desc.value == '')getPractitioner()"><input type="hidden" name="attend_pract_code" id="attend_pract_code" value=''></td>-->
		
		<td class='fields'  ><input type='text'  name='attend_pract_desc' id='attend_pract_desc' value="<%=attend_pract_desc%>" onBlur='getPractitioner1(this)' size='20' maxlength='20'><input type='button' name='search' id='search' value='?'  class='button' onClick="if(document.forms[0].attend_pract_desc.value == '')getPractitioner()"><input type="hidden" name="attend_pract_code" id="attend_pract_code" value=''></td>
		<!--IN051294 start-->
		
	</tr>
	<tr >
	<td class="label"><fmt:message key="eCA.RefNo.label" bundle="${ca_labels}"/></td><td class="fields" colspan=2><input type="text" name="ref_no" id="ref_no" value="" width="30%" size="50" maxlength = '100'></td>
	
	

	<td  width='25%'><input type="button" class='Button' name="searchresult_button" id="searchresult_button" title='Search Result' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="this.disabled=true;search_result();"><input type="button" class='Button' name="clear_form" id="clear_form" title='Clear Criteria' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clear_result()'></td> <!-- td align = 'right' removed for IN042640 --> 
		
	</tr>
	
</table>
<!-- added by arvind @ 04-11-08 -->

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end -->
<input type=hidden value='<%=querystring%>' name='querystring' ></input>
<input type=hidden value='<%=facilityid%>' name='facilityid' ></input>
<input type=hidden value='' name='performed_by_code' id='performed_by_code' ></input>
<input type=hidden value='' name='med_anc_code' id='med_anc_code' ></input>
<input type=hidden value='<%=locale%>' name='locale'>
<input type="hidden" name="patient_line" id="patient_line" value="<%=patient_line%>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<input type="hidden" name="episode_type" id="episode_type" value="<%=episode_type%>">
<input type="hidden" name="encounter_id" id="encounter_id"	value="<%=encounter_id%>">
<input type='hidden' name ='patient_id' value='<%=patient_id%>'> 
<input type='hidden' name ='called_function_id' value='<%=called_function_id%>'> <!--CHL_CRF_0010-->
<input type='hidden' name='Splcode_desc_hid' id='Splcode_desc_hid' value=''> <!-- IN043437 -->
<input type='hidden' name='practCode_desc_hid' id='practCode_desc_hid' value=''> <!-- MMS-QH-CRF-0177 [IN047572]  -->
</form>
</body>
<%

}catch(Exception e)
{

//out.println("EXCEPTION"+e.toString());//COMMON-ICN-0181
e.printStackTrace();//COMMON-ICN-0181
	
}

%>
<script>
	if('<accession_number>' != '')
		document.forms[0].searchresult_button.click();
</script>
</html>

