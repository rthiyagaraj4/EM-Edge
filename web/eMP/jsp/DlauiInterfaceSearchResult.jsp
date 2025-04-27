<!DOCTYPE html>
<HTML>

<%@ page import = "java.util.*,java.sql.*,java.net.*" %>
<%@ page import ="webbeans.eCommon.ConnectionManager,webbeans.eCommon.*,com.ehis.util.DateUtils"%>
<%@ page import = "eMP.DLAInterfaceUtil" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8"); 
String locale = ((String)session.getAttribute("LOCALE"));	
%>

<HEAD>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String function_id = (String)session.getAttribute("dla_function_id");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eMP/js/dlainterface.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

					   
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<form name="view_dla_interface_result_form" id="view_dla_interface_result_form" id="view_dla_interface_result_form"  method="post" action="../../servlet/eMP.DLATransactionServlet">

<%

String national_id = (String)request.getParameter("national_id"); if(national_id == null) national_id = "";
String user_name = "";
String pass_word = "";
String first_name = "";
String serach_mode = "";
String sur_name = "";
String dob = "";
String nationality = "";
String nationality_code = "";
String fathername = "";
String mothername = "";
String address = "";
String gender = "";
String usr_title = "";
String deceased_yn = "";
String deceased_date = "";
String loc_code = "";
String loc_desc = "";
String address_1 = "";
String address_2 = "";
String address_3 = "";
String address_4 = "";
String dla_town = "";
String dla_area = "";
String dla_region = "";
String ret_title_eng = "";
String ret_title_thai = "";
String gender_disp = "";
String deceased_yn_disp = "Y";
String middleName = "";
String estDOB = "N";
String tempDOB = "";

String dla_area_code = "";
String dla_region_code = "";
String dla_town_code = "";

//String tempYear = "";
//String tempDeceasedDate = "";

int age = 0;
//int deceasedAge = 0;

String query = "";
String dateFormat = "";
//String dispDateFormat = "dd/MM/yyyy";
//String ageCalDateFormat = "dd-MM-yyyy";
//String procDateFormat = "yyyy-MM-dd";
//String ageCal = "";
String patient_id = "";
String dispDOB = ""; // Display variable for DOB, used only for display purpose
String dispDecDate = ""; // Display variable for deceased date, used only for display purpose

String currentDate = "";
String currentMonth = "";

boolean isWrongDecDateFormat = false;
boolean isWrongDOBFormat = false;

Connection sqlServerCon = null; 
PreparedStatement pstmt = null;
ResultSet rs = null;
CallableStatement  call = null;

try
{
	// Getting current date & month. Used incase of unknown date (yyyy0000 format)
	GregorianCalendar gregorianCal = new GregorianCalendar();
	currentDate = "" + gregorianCal.get(Calendar.DAY_OF_MONTH);	
	currentMonth = "" + (gregorianCal.get(Calendar.MONTH)+1);
	if(Integer.parseInt(currentDate) < 10) currentDate = "0" + currentDate;
	if(Integer.parseInt(currentMonth) < 10) currentMonth = "0" + currentMonth;

	String today_datetime1 = (String)session.getAttribute("today_datetime");	
	String dla_machine_name1 = (String)session.getAttribute("dla_machine_name");
	
	sqlServerCon = DLAInterfaceUtil.getConnection("DLAP");
	dateFormat = "yyyyMMdd";

	query = DLAInterfaceUtil.getSqlDBQueryByNationalID();

	pstmt = sqlServerCon.prepareStatement(query);
	pstmt.setString(1,dla_machine_name1 + "/" + today_datetime1);
	pstmt.setString(2,national_id);
	rs = pstmt.executeQuery();
	
	if(rs.next())
	{
		first_name = DLAInterfaceUtil.checkForNull(rs.getString(2));		
		sur_name = DLAInterfaceUtil.checkForNull(rs.getString(3));
		middleName = DLAInterfaceUtil.checkForNull(rs.getString(21));
		dob = DLAInterfaceUtil.checkForNull(rs.getString(4));	
		nationality = DLAInterfaceUtil.checkForNull(rs.getString(6));
		nationality_code = DLAInterfaceUtil.checkForNull(rs.getString(5));
		fathername = DLAInterfaceUtil.checkForNull(rs.getString(7));
		mothername = DLAInterfaceUtil.checkForNull(rs.getString(8));		
		address = DLAInterfaceUtil.checkForNull(rs.getString(16));
		gender = DLAInterfaceUtil.checkForNull(rs.getString(10));
		usr_title = DLAInterfaceUtil.checkForNull(rs.getString(13));
		deceased_yn = DLAInterfaceUtil.checkForNull(rs.getString(11));		
		deceased_date = DLAInterfaceUtil.checkForNull(rs.getString(12));
		loc_code = DLAInterfaceUtil.checkForNull(rs.getString(14));
		loc_code = loc_code.trim();
	//	loc_desc = DLAInterfaceUtil.checkForNull(rs.getString(15));
		address_1 = DLAInterfaceUtil.checkForNull(rs.getString(16));
		address_2 = DLAInterfaceUtil.checkForNull(rs.getString(17));
		address_3 = DLAInterfaceUtil.checkForNull(rs.getString(18));
		address_4 = DLAInterfaceUtil.checkForNull(rs.getString(19));

		if(address_1.length() > 30) address_1 = address_1.substring(0,30);
		if(address_2.length() > 30)	address_2 = address_2.substring(0,30);
		if(address_3.length() > 30)	address_3 = address_3.substring(0,30);
		if(address_4.length() > 30)	address_4 = address_4.substring(0,30);		

		gender_disp = DLAInterfaceUtil.checkForNull(rs.getString(20));
		ret_title_thai = usr_title;
			
		if(rs != null) rs.close(); 
		if(pstmt != null) pstmt.close();		

	/*	if(dob != null)
		{
			int dobLength = dob.length();
			if(dobLength != 8)
			{
				for (int i = 0; i < (8 - dobLength); i++)
				{
					dob = "0" + dob;
				}
			}
		}
	*/	
		if(dob != null && dob.length() == 8)
		{			
			// If Date & Month are 0000, then replacing with 0101
			if( "00".equals( dob.substring(6) ) ) 
			{
				dob = dob.substring(0,6) + "01";
				estDOB = "Y";
			}
			if( "00".equals( dob.substring(4,6) ) ) 
			{
				dob = dob.substring(0,4) + "01" + dob.substring(6);
				estDOB = "Y";
			}			

			if("0000".equals(dob.substring(0,4))) 
			{
				isWrongDOBFormat = true;
				dispDOB = dob.substring(6,8) + "/" + 
								dob.substring(4,6) + "/0000";
			}
			else
			{
				tempDOB = dob.substring(6,8) + "/" + 
											dob.substring(4,6) + "/" +
											dob.substring(0,4);
				if("th".equalsIgnoreCase(locale))
				{
					dispDOB = tempDOB;
				}
				else
				{
					dispDOB = dob.substring(6,8) + "/" + 
								dob.substring(4,6) + "/" +
								(Integer.parseInt(dob.substring(0,4)) - 543);
				}
				
				isWrongDOBFormat = !(DateUtils.validDate(tempDOB,"DMY","th"));
				isWrongDOBFormat = DateUtils.isAfterNow(tempDOB,"DMY","th");
			}
		}
		else
		{
			dispDOB = dob;
			isWrongDOBFormat = true;
		}

		if("Y".equalsIgnoreCase(deceased_yn))
		{			
		/*	if(deceased_date != null)
			{
				int deceasedDateLength = deceased_date.length();
				if(deceasedDateLength != 8)
				{
					for (int i = 0; i < (8 - deceasedDateLength); i++)
					{
						deceased_date = "0" + deceased_date;
					}
				}
			}
		*/	if(deceased_date != null && !deceased_date.equals("0") && deceased_date.length() == 8)
			{
				if("0000".equals(deceased_date.substring(0,4))) 
				{
					isWrongDecDateFormat = true;
					dispDecDate = deceased_date.substring(6,8) + "/" + 
										deceased_date.substring(4,6) + "/0000";
				}
				else
				{
					String tempDecDate = deceased_date.substring(6,8) + "/" + 
											deceased_date.substring(4,6) + "/" +
											deceased_date.substring(0,4);
					if("th".equalsIgnoreCase(locale))
					{
						dispDecDate = tempDecDate;
					}
					else
					{
						dispDecDate = deceased_date.substring(6,8) + "/" + 
										deceased_date.substring(4,6) + "/" +
										(Integer.parseInt(deceased_date.substring(0,4)) - 543);
					}
					
					isWrongDecDateFormat = !(DateUtils.validDate(tempDecDate,"DMY","th"));
					isWrongDecDateFormat = DateUtils.isAfterNow(tempDecDate,"DMY","th");					
					if(!isWrongDOBFormat) isWrongDecDateFormat = DateUtils.isBefore(tempDecDate,tempDOB,"DMY","th");
				}
			}
			else
			{
				dispDecDate = deceased_date;
				isWrongDecDateFormat = true;
			}
		}		

		if(isWrongDOBFormat || isWrongDecDateFormat)
		{
			String errMsg = "";
			java.util.Locale loc = new java.util.Locale(locale);
			java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle( "eMP.resources.Messages",loc);			

			if(isWrongDOBFormat)
			{
				errMsg = labels.getString("INVALID_DOB");
				if(errMsg == null || "".equals(errMsg))
				{
					errMsg = "Invalid Date of Birth, Do You Want To Continue?";
				}
			}
			else
			{
				errMsg = labels.getString("INVALID_DESEASED_DATE");
				if(errMsg == null || "".equals(errMsg))
				{
					errMsg = "Invalid Deceased Date, Do You Want To Continue?";
				}
			}
			%>
				<SCRIPT> 
				var imageFormObj = parent.image_frame.view_dla_interface_result_form1;			
				imageFormObj.document.getElementById("image_body").style.visibility = "hidden";
				if( !confirm('<%= errMsg %>') )
				{
					parent.message_frame.location.href = "../../eCommon/html/blank.html";
					parent.image_frame.location.href   = "../../eCommon/html/blank.html";
					parent.action_frame.location.href  = "../../eCommon/html/blank.html";
				}
				else
				{
					imageFormObj.document.getElementById("image_body").style.visibility = "visible";
				}
				</SCRIPT>
			<%
		}
		else
		{
			String gregDOB = DLAInterfaceUtil.convert_to_greg_date_2t(dob,"th","yyyymmdd");			

			if("Y".equalsIgnoreCase(deceased_yn))
			{			
				String gregDeceasedDate = DLAInterfaceUtil.convert_to_greg_date_2t(deceased_date,"th","yyyymmdd");
										
				age = DateUtils.yearsBetween(
							DLAInterfaceUtil.convertStringDateFormats(gregDOB,"yyyy-MM-dd","dd/MM/yyyy"),
							DLAInterfaceUtil.convertStringDateFormats(gregDeceasedDate,"yyyy-MM-dd","dd/MM/yyyy"),
							"DMY","en");
			}
			else
			{
				age = DateUtils.yearsBetween(
							DLAInterfaceUtil.convertStringDateFormats(gregDOB,"yyyy-MM-dd","dd/MM/yyyy"),
							DateUtils.getCurrentDate("DMY","en"),
							"DMY","en");
			}				
		}
						
		// Retrieving the descriptions for the corresponding codes for patient(SQL Server)		
		nationality = DLAInterfaceUtil.getDescFromCode("SELECT long_desc FROM mp_country_lang_vw WHERE country_code='"+nationality_code+"' AND language_id='"+locale+"'");
		if(nationality == null || nationality.equalsIgnoreCase(""))
		{
			nationality_code = "UP";
			nationality = DLAInterfaceUtil.getDescFromCode("SELECT long_desc FROM mp_country_lang_vw WHERE country_code='UP' AND language_id='"+locale+"'");
		}
		ret_title_eng = DLAInterfaceUtil.getDescFromCode("SELECT name_prefix FROM mp_name_prefix WHERE name_prefix_loc_lang='"+usr_title+"'");		
		
		dla_town = DLAInterfaceUtil.getDescFromCode("SELECT long_desc FROM mp_res_town_lang_vw WHERE res_town_code='"+loc_code+"' AND language_id='"+locale+"'");
		if(loc_code.length() >= 4) 
		{
			dla_area = DLAInterfaceUtil.getDescFromCode("SELECT long_desc FROM mp_res_area_lang_vw WHERE res_area_code='"+loc_code.substring(0,4)+"' AND language_id='"+locale+"'");			
		}
		if(loc_code.length() >= 2)
		{
			dla_region = DLAInterfaceUtil.getDescFromCode("SELECT long_desc FROM mp_region_lang_vw WHERE region_code='"+loc_code.substring(0,2)+"' AND language_id='"+locale+"'");			
		}

		if(dla_town != null && !dla_town.equalsIgnoreCase("")) 
		{
			loc_desc = dla_town;
			dla_town_code = loc_code;
		}
		if(dla_area != null && !dla_area.equalsIgnoreCase(""))
		{
			loc_desc = loc_desc+" "+dla_area;
			dla_area_code = loc_code.substring(0,4);
		}
		if(dla_region != null && !dla_region.equalsIgnoreCase(""))
		{
			loc_desc = loc_desc+" "+dla_region;
			dla_region_code = loc_code.substring(0,2);
		}

		if(address_1 != null)
			address = address_1;
		if(address_2 != null)
			address = address+" "+address_2;
		if(address_3 != null)
			address = address+" "+address_3;
		if(address_4 != null)
			address = address+" "+address_4;

		if(!deceased_yn.equalsIgnoreCase("Y"))	
		{
			deceased_yn = "N";
			deceased_yn_disp = "";
		}
		

		String new_req = (String)session.getAttribute("new_req");

		if(new_req != null && new_req.equalsIgnoreCase("Y"))
		{												 
			String today_datetime = (String)session.getAttribute("today_datetime");
			String req_search = (String)session.getAttribute("req_search");
			String dla_machine_name = (String)session.getAttribute("dla_machine_name");

			DLAInterfaceUtil.updatePurgeStatus(today_datetime,dla_machine_name,req_search);
			session.removeAttribute("new_req");
		}
	

%>
<table cellspacing=0 cellpadding=4 width='100%' align=center>
<tr>
<td class='COLUMNHEADER' width='30%'><fmt:message key="eMP.searchresult.label" bundle="${mp_labels}"/> </td>
<td class='COLUMNHEADER' width='30%'></td>
<td class='COLUMNHEADER' width='20%'></td>
<td class='COLUMNHEADER' width='20%'></td>
</tr>

<tr>
<td class="label"><%= DLAInterfaceUtil.getLabelPrompt(locale,"FirstName") %></td>
<td class='fields'>
	<input type=text name= usr_title id="usr_title" value="<%=usr_title%>" size=10 disabled>&nbsp;
	<input type=text name= usr_name id="usr_name" value='<%=first_name%>' maxlength="80" size=25 disabled>
</td>
<td class="label"><%= DLAInterfaceUtil.getMiddleNamePrompt(locale) %></td>
<td>
	<input type=text name="middleName" id="middleName" id="middleName" value='<%=middleName%>' maxlength="80" size=25 disabled>
</td>
</tr>
<tr>
<td class="label">
	<%= DLAInterfaceUtil.getLabelPrompt(locale,"FamilyName") %>
</td>
<td>
	<input type=text name= sur_name id="sur_name" value='<%=sur_name%>' maxlength="80" size=25 disabled>
</td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></td>
<td>
<table>
<tr>
<td class='fields'>
	<input type=text name= usr_dob id="usr_dob" value='<%=dispDOB%>' size=10 disabled >
</td>
<td class="label"><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
<td class='fields'>
	<input type="text" name="age" id="age" id="age" value="<%=age%>" size=3 disabled>
	<fmt:message key="Common.Years.label" bundle="${common_labels}"/>
</td>
</tr>
</table>
</td>
<td class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=text name= gender_disp id="gender_disp" value='<%=gender_disp%>' size=10 disabled></td>
</tr>

<tr>
<td class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
<td class='fields'>
	<input type=text name= nationlity_id id="nationlity_id" value='<%=nationality_code%>' maxlength="4" size=10 disabled>&nbsp;
	<input type=text name= nationlity id="nationlity" value='<%=nationality%>' size=25 disabled>
</td>
<td class="label">
		<fmt:message key="eMP.CitizenId.label" bundle="${common_labels}"/>
</td>
<td class='fields'>
	<input type="text" name="national_id" id="national_id" id="national_id"  value="<%=national_id%>" maxlength="20" size=25 disabled></td>
</tr>

</table>

<table cellspacing=0 cellpadding=4 width='100%' align=center>
	<tr>
	<td class="label"><fmt:message key="Common.Address.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text name= addr id="addr" value='<%=address%>' size=25 disabled></td>
	</tr>
	<tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<input type=text name="loc_code" id="loc_code" id="loc_code" value='<%=loc_code%>' size=10 disabled>
		<input type=text name="loc_desc" id="loc_desc" id="loc_desc" value='<%=loc_desc%>' size=40 disabled>
	</td>
	</tr>
	<tr>
	<td class="label">
		(<fmt:message key="eMP.Tumbon.label" bundle="${mp_labels}"/>/<fmt:message key="eMP.District.label" bundle="${mp_labels}"/>/<fmt:message key="eMP.Province.label" bundle="${mp_labels}"/>)
	</td>
	<td class="label">&nbsp;</td>
	</tr>
	<tr>
	<td class="label"><fmt:message key="eMP.Father.label" bundle="${mp_labels}"/></td>
		<td class='fields'>
			<input type=text name= father_name id="father_name" value='<%=fathername%>' maxlength="30" size=25 disabled>
		</td>
	</tr>
	<tr>
	<td class="label"><fmt:message key="Common.Mother.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text name= mother_name id="mother_name"  value='<%=mothername%>' maxlength="30" size=25 disabled></td>
	</tr>
	<tr>
	<td class="label">
		<fmt:message key="eMP.DeceasedStatus.label" bundle="${mp_labels}"/>
	</td>
	<td class='fields'>
		<input type=text name="deceased_status" id="deceased_status" id="deceased_status"  value='<%=deceased_yn_disp%>' size=1 disabled>
		<input type="hidden" name="deceased_yn" id="deceased_yn" id="deceased_yn"  value='<%=deceased_yn%>'>
	</td>
	</tr>
	<tr>
	<td class="label">
		<fmt:message key="Common.DeceasedDate.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type=text name="deceased_date" id="deceased_date" id="deceased_date"  value='<%=dispDecDate%>' size=25 disabled>
	</td>
	</tr>
</table>

<!-- Hidden fields used in dlainterface.js - getAccept function for returning the values back to MP pages-->

<INPUT TYPE="hidden" name="mode" id="mode" VALUE="">
<INPUT TYPE="hidden" name="flag" id="flag" VALUE="<%= request.getParameter("mode")%>">
<input type='hidden' name='address_1' id='address_1' value="<%=address_1%>">
<input type='hidden' name='address_2' id='address_2' value="<%=address_2%>">
<input type='hidden' name='address_3' id='address_3' value="<%=address_3%>">
<input type='hidden' name='address_4' id='address_4' value="<%=address_4%>">

<input type='hidden' name='national_id_name' id='national_id_name' value="<%=national_id%>">
<input type='hidden' name='user_name' id='user_name' value="<%=user_name%>">
<input type='hidden' name='pass_word' id='pass_word' value="<%=pass_word%>">
<input type='hidden' name='serach_mode' id='serach_mode' value="<%=serach_mode%>">
<input type='hidden' name='first_name' id='first_name' value="<%=first_name%>">
<input type='hidden' name='sur_name1' id='sur_name1' value="<%=sur_name%>">
<input type='hidden' name='dla_usr_name' id='dla_usr_name' value="<%=user_name%>">
<input type='hidden' name='dla_usr_pswd' id='dla_usr_pswd' value="<%=pass_word%>">	
<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">	
<input type='hidden' name='dla_town' id='dla_town' value="<%=dla_town%>">
<input type='hidden' name='dla_area' id='dla_area' value="<%=dla_area%>">
<input type='hidden' name='dla_region' id='dla_region' value="<%=dla_region%>">

<input type='hidden' name='dla_town_code' id='dla_town_code' value="<%=dla_town_code%>">
<input type='hidden' name='dla_area_code' id='dla_area_code' value="<%=dla_area_code%>">
<input type='hidden' name='dla_region_code' id='dla_region_code' value="<%=dla_region_code%>">

<input type='hidden' name='ret_title_eng' id='ret_title_eng' value="<%=ret_title_eng%>">
<input type='hidden' name='ret_title_thai' id='ret_title_thai' value="<%=ret_title_thai%>">
<input type='hidden' name='nat_code' id='nat_code' value="<%=nationality_code%>">
<input type='hidden' name='gender' id='gender' value="<%=gender%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<input type='hidden' name='estDOB' id='estDOB' value="<%=estDOB%>">

<%
	}
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
finally
{	
	try
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();							
		if(call != null) call.close();		
		DLAInterfaceUtil.closeConnection(sqlServerCon);
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
}
%>

</form>

</body>
</html>


