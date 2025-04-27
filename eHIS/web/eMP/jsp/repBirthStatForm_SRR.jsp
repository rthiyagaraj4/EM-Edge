<%@ page import="java.sql.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<!--Below two files should be includd inthe same order as is  -->
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../js/repBirthStat_SRR.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

<script>
function validateYear(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'YY',localeName)==false)
				{
				alert(getMessage("INVALID_YEAR_FMT", "SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}

function setDate(Object){ 

//var currentDate = new Date();
var format="";
if(Object.name=='ds_from_date1' || Object.name=='ds_to_date1')
	format="DMY"
else if(Object.name=='ds_from_date2' || Object.name=='ds_to_date2')
	format="MY"
else
    format="YY"

       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,format,localeName))
        {
          return true;
        }
        else
        {
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
	}
</script>
<%

	String p_module_id		= "MP" ;
	String p_report_id		= "MPBTSTAT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");
	String locale				  = (String)session.getValue("LOCALE");

	Connection con = null;
	ResultSet rset=null;
	ResultSet rset1=null;
	Statement stmt=null;
	Statement stmt1=null;
	PreparedStatement pstmt = null ;
	String unit_of_gest_nb="";
%>
<body onLoad="changeReportType(document.forms[0].dmy_ind)" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'> 
<br>
<center>
	<form name="repBirthStat" id="repBirthStat" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table cellspacing='0' cellpadding='3' align='center' border="0" width="80%">

		 <!-- <tr>
				<td width='20%'>&nbsp;</td>
				<td width='20%'>&nbsp;</td>
				<td width='15%'>&nbsp;</td>
				<td width='25%'>&nbsp;</td>
		</tr> -->
		<tr>
			<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='facilityid' id='facilityid'>
				<%
					try
					{
					
					String fid;
					String fname;
					con = ConnectionManager.getConnection(request);
					

					//String sql1 = "select 'All' facility_id, '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";
					String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2 ";

					pstmt=con.prepareStatement(sql1);
					rset=pstmt.executeQuery();

					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						if(fid.equals("All"))
						out.println("<option value='All'  selected>"+fname+"</option>");
						else
                        out.println("<option value='"+fid+ "' >"+fname+"</option>");
					   }
					}
                    String sql_new = "select unit_of_gest_nb from mp_param";
					stmt1=con.createStatement();
                    rset1=stmt1.executeQuery(sql_new);

             	   if(rset1!=null && rset1.next()) {
						unit_of_gest_nb = rset1.getString("unit_of_gest_nb");							  
				   }
				   
					if(unit_of_gest_nb==null || unit_of_gest_nb=="")unit_of_gest_nb="";
				   if (rset1 != null) rset1.close();
				   if (stmt1 != null) stmt1.close();


					}catch(Exception e) { }
					finally
					{
						try 
						{
						if(pstmt!=null) pstmt.close();
						if(rset!=null) rset.close();
						}
						catch(Exception e) { }
					}
					%>
				</select>
			</td>
			<td class="label" ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name="dmy_ind" id="dmy_ind" onChange="changeReportType(this)">
				<option value='D'><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
				<option value='M'><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
				<option value='Y'><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>
			<tr>
			<td class="label" ><fmt:message key="eMP.WeightRange.label" bundle="${mp_labels}"/></td>
			<td class='fields'><select name='p_range_id' id='p_range_id'>
					<option value="">-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
				<%
					try
					{
					stmt=con.createStatement();
					String rid;
					String rangedesc;
					String sql1 = "select range_id, short_desc from am_summ_range_lang_vw where range_type = 'W' and language_id='"+localeName+"' order by 2 ";			

					rset=stmt.executeQuery(sql1);
					if(rset!=null)
					{
					   while(rset.next())
					   {
						rid=rset.getString("range_id");
						rangedesc=rset.getString("short_desc");
                        out.println("<option value='"+rid+"' >"+rangedesc+"</option>");
					   }
					}
					}catch(Exception e) { out.println(e);}
					finally
					{
						try
						{
						if(rset!=null) rset.close();
						if(stmt !=null) stmt.close();
						if(con!=null) ConnectionManager.returnConnection(con,request);
						}
						catch(Exception e) { out.println(e);}

					} %>
				</select><img src='../images/mandatory.gif'></img>
			</td>
			<td colspan=2>&nbsp;</td>
			</tr>
			<tr>
				<td colspan=1>&nbsp;</td>
				<td  class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td colspan=1>&nbsp;</td>
				<td class='querydata' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>				
			</tr>

			<tr>
				<td class="label" ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>

				<td class='fields' ><input type="text" id='regnagenatstatfrom' name="ds_from_date1" id="ds_from_date1" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img name="from_date_cal" src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('regnagenatstatfrom').focus();return showCalendar('regnagenatstatfrom');"><img id="ds_from_date1_img" style="visibility:visible"; src='../images/mandatory.gif'></img>
				</td>
				<td>&nbsp;</td>
				<td class='fields' ><input type="text" id='regnagenatstatto' name="ds_to_date1" id="ds_to_date1" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img name="to_date_cal" src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('regnagenatstatto').focus();return showCalendar('regnagenatstatto');"><img id="ds_to_date1_img" style="visibility:visible"; src='../images/mandatory.gif'></img>
				</td>
			</tr>
<!-- previous code onBlur="CheckMonth(this)" -->
			<tr>
				<td class="label" ><fmt:message key="Common.month.label" bundle="${common_labels}"/>/<fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" id='regnagenatstatfrom1' name="ds_from_date2" id="ds_from_date2" size="7" maxlength="7" onBlur='if(validDateObj(this,"MY",localeName)){setDate(this)};'><img name="from_month_cal" src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('regnagenatstatfrom1').focus();return showCalendar('regnagenatstatfrom1', 'mm/y', null);"><img id="ds_from_date2_img" style="visibility:hidden;" src='../images/mandatory.gif'></img>
				</td>
				<td>&nbsp;</td>
				<td class='fields' ><input type="text" id='regnagenatstatto1' name="ds_to_date2" id="ds_to_date2" size="7" maxlength="7" onBlur='if(validDateObj(this,"MY",localeName)){setDate(this)};'><img name="to_month_cal" src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('regnagenatstatto1').focus();return showCalendar('regnagenatstatto1', 'mm/y', null);"><img id="ds_to_date2_img" style="visibility:hidden"; src='../images/mandatory.gif'></img>
				</td>
			</tr>

			<tr>
				<td class="label" ><fmt:message key="Common.year.label" bundle="${common_labels}"/> </td>
				<td class='fields' ><input type="text" name="ds_from_date3" id="ds_from_date3" size="4" maxlength="4" onBlur='if(validDateObj(this,"YY",localeName)){setDate(this)};'><img id="ds_from_date3_img" style="visibility:hidden"; src='../images/mandatory.gif'></img>
				</td>
				<td>&nbsp;</td>
				<td class='fields' ><input type="text" name="ds_to_date3" id="ds_to_date3" size="4" maxlength="4" onBlur='if(validDateObj(this,"YY",localeName)){setDate(this)};'><img id="ds_to_date3_img" style="visibility:hidden"; src='../images/mandatory.gif'></img>
				</td>
			</tr>
		<tr>
			<td class='label' ><fmt:message key="eMP.Gravida.label" bundle="${mp_labels}"/></td>
			<td class='fields'><input type='text' name='p_fm_gravida' id='p_fm_gravida' size=2 maxlength=2 onKeyPress='return allowValidNumber(this,event,2,0)'></td>
			<td>&nbsp;</td>
			<td class='fields'><input type='text' name='p_to_gravida' id='p_to_gravida' size=2 maxlength=2 onKeyPress='return allowValidNumber(this,event,2,0)'></td>
		</tr>

		<tr>
			<td class='label' ><fmt:message key="eMP.Parity.label" bundle="${mp_labels}"/></td>
			<td class='fields'><input type='text' name='p_fm_parity' id='p_fm_parity' size=2 maxlength=2 onKeyPress='return allowValidNumber(this,event,2,0)'></td>
			<td>&nbsp;</td>
			<td class='fields'><input type='text' name='p_to_parity' id='p_to_parity' size=2 maxlength=2 onKeyPress='return allowValidNumber(this,event,2,0)'></td>
		</tr>

		<tr>
			<td class='label' ><fmt:message key="eMP.Gestation.label" bundle="${mp_labels}"/></td>
			<td class='fields'><input type='text' name='p_fm_gestation' id='p_fm_gestation' size=3 maxlength=3 onKeyPress='return allowValidNumber(this,event,2,0)' onblur='enableGestDays(this);'>&nbsp;<%if(unit_of_gest_nb.equals("W")) { %>
			<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text' disabled name='p_fm_gest_period' id='p_fm_gest_period' size="2" maxlength="1" align="center"  onblur='validateDate(this);' onKeyPress='return(ChkNumberInput(this,event,0));'> <fmt:message key="Common.days.label" bundle="${common_labels}"/>
		<% } else { 
					%>
				<fmt:message key="Common.days.label" bundle="${common_labels}"/>
				<input type="hidden" name="p_fm_gest_period" id="p_fm_gest_period"	value=""><%}%>
			</td>
			<td>&nbsp;</td>
			<td class='fields'><input type='text' name='p_to_gestation' id='p_to_gestation' size=3 maxlength=3 onKeyPress='return allowValidNumber(this,event,2,0)' onblur='enableGestDays(this);'>&nbsp;<%if(unit_of_gest_nb.equals("W")) { %>
			<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text' disabled name='p_to_gest_period' id='p_to_gest_period' size="2" maxlength="1" align="center"  onblur='validateDate(this);' onKeyPress='return(ChkNumberInput(this,event,0));'> <fmt:message key="Common.days.label" bundle="${common_labels}"/>
		<% } else { 
					%>
				<fmt:message key="Common.days.label" bundle="${common_labels}"/>
				<input type="hidden" name="p_to_gest_period" id="p_to_gest_period"	value=""><%}%>
			</td>
		</tr>

		<tr>
			<!-- <td class="label" ><fmt:message key="eMP.natureofdelivery.label" bundle="${mp_labels}"/></td> -->
			<td class="label" ><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></td>
			<td class='fields' ><input type="text" name="p_fm_nod_type" id="p_fm_nod_type" size="4" maxlength="4"><input type='button' name='fm_nod' id='fm_nod' value='?' class='button' onclick='searchCode(this, p_fm_nod_type)' tabindex=-1>
			</td>
			<td>&nbsp;</td>
			<td class='fields' ><input type="text" name="p_to_nod_type" id="p_to_nod_type" size="4" maxlength="4"><input type='button' name='to_nod' id='to_nod' value='?' class='button' onclick='searchCode(this, p_to_nod_type)' tabindex=-1>
			</td>
		</tr>

		<tr>
			<!-- <td class="label" ><fmt:message key="eMP.BirthAttendant.label" bundle="${mp_labels}"/></td> -->
			<td class="label" ><fmt:message key="eMP.AttendingNurse.label" bundle="${mp_labels}"/></td>
			<td class='fields' ><input type="text" name="p_fm_attend_midwife" id="p_fm_attend_midwife" size="15" maxlength="15"><input type='button' name='fm_attend' id='fm_attend' value='?' class='button' onclick='searchCode(this, p_fm_attend_midwife)' tabindex=-1>
			</td>
			<td>&nbsp;</td>
			<td class='fields' ><input type="text" name="p_to_attend_midwife" id="p_to_attend_midwife" size="15" maxlength="15"><input type='button' name='to_attend' id='to_attend' value='?' class='button' onclick='searchCode(this, p_to_attend_midwife)' tabindex=-1>
			</td>
		</tr>

		<tr>
			<td class="label" ><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type="text" name="p_fm_attend_pract" id="p_fm_attend_pract" size="15" maxlength="15"><input type='button' name='fm_pract' id='fm_pract' value='?' class='button' onclick='searchCode(this, p_fm_attend_pract)' tabindex=-1>
			</td>
			<td>&nbsp;</td>
			<td class='fields' ><input type="text" name="p_to_attend_pract" id="p_to_attend_pract" size="15" maxlength="15"><input type='button' name='to_pract' id='to_pract' value='?' class='button' onclick='searchCode(this, p_to_attend_pract)' tabindex=-1>
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="eMP.BornWhere.label" bundle="${mp_labels}"/></td>
			<td class='fields'><select name="p_born_where" id="p_born_where">
				<option value="I" selected><fmt:message key="eMP.InFacility.label" bundle="${mp_labels}"/></option>
				<option value='H'><fmt:message key="Common.home.label" bundle="${common_labels}"/></option>
				<option value='A'><fmt:message key="eMP.Ambulance.label" bundle="${mp_labels}"/></option>
				<option value='O'><fmt:message key="eMP.OtherModesofTpt.label" bundle="${mp_labels}"/></option>
				<option value="B"><fmt:message key="eMP.BeforeArrival.label" bundle="${mp_labels}"/></option>
				</select>
			</td>
			<td colspan=2>&nbsp;</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name="p_outcome" id="p_outcome" onChange="enableFields(this)">
				<option value="L" selected><fmt:message key="eMP.Live.label" bundle="${mp_labels}"/></option>
				<option value="S"><fmt:message key="eMP.StillBorn.option.label" bundle="${mp_labels}"/></option>
				<option value=""><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<td class='label' ><fmt:message key="eMP.IndicatorMark.label" bundle="${mp_labels}"/></td>
			<td class='fields'><select name="p_indicator_mark" id="p_indicator_mark" disabled>
				<option value="" selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value="F" ><fmt:message key="eMP.Fresh.label" bundle="${mp_labels}"/></option>
				<option value="M"><fmt:message key="eMP.Macerated.label" bundle="${mp_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan=4>&nbsp;</td>
		</tr>

		</table>

		<br>

<input type="hidden" name="p_dtype" id="p_dtype"			value="D">
<input type="hidden" name="p_facility_id" id="p_facility_id" 		value="<%= p_facility_id%>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<input type="hidden" name="ds_from_date" id="ds_from_date"			value="">
<input type="hidden" name="ds_to_date" id="ds_to_date"			value="">
<!-- for month/year validation, populated from validatemonth_year() in repBirthStat.js******************* -->
<input type="hidden" name="p_fm_mon" id="p_fm_mon"			value="">
<input type="hidden" name="p_fm_year" id="p_fm_year"			value="">
<input type="hidden" name="p_to_mon" id="p_to_mon"			value="">
<input type="hidden" name="p_to_year" id="p_to_year"			value="">
<input type="hidden" name="unit_of_gest_nb" id="unit_of_gest_nb"		value="<%=unit_of_gest_nb%>">
<input type="hidden" name="locale" id="locale"		value="<%=locale%>">
<!-- ********************************************************** -->

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
	</form>

</center>
</body>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

