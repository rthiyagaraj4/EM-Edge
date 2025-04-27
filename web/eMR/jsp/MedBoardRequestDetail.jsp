<!DOCTYPE html>
<%
/*
 ****************************************************************************************
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 23 MARCH 2005
* @Function		: MEDICAL_BOARD_REQUEST
 ****************************************************************************************
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eMR/js/MedBoardRequest.js' language='javascript'></script>	
	<script src='../../eMR/js/MedBoardReqTransaction.js' language='javascript'></script>	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function localValidations()// do not remove the func.. used for natAltIDComponent.jsp
	{
	}

	function FocusFirstElement1(){
	if(document.MedBoardReqDetailForm){
		if(document.MedBoardReqDetailForm.search!=null){
	document.MedBoardReqDetailForm.search.focus();
	}
	}
	}

</script>


<%
	String locale = (String) session.getValue("LOCALE");
	Connection con				= null;
	PreparedStatement detailStmt= null;
	Statement Stmt				= null;
	ResultSet detailRS			= null;
	request.setCharacterEncoding("UTF-8");
	String Facility_Id			= (String) session.getValue("facility_id");
	String request_id			= checkForNull(request.getParameter("request_id"));
	String call_function		= checkForNull(request.getParameter("call_function"));
	String nat_id_prompt			= "";	String accept_national_id_no_yn	= "";
	String alt_id1_type				= "";	
	String patient_id			= "";
	String patient_name			= "";
	String nameprefix			= "";
	String familyname			= "";
	String firstname			= "";
	String secondname			= "";
	String thirdname			= "";
	String namesuffix			= "";
	String gender				= "";
	String gender_desc			= "";
	String date_of_birth		= "";
	String place_of_birth_code	= "";
	String  place_of_birth_desc	= "";
	String nationality_code		= "";
	String nationality_long_desc= "";
	String national_id_no		= "";
	String alt_id1_no			= "";
	String alt_id2_no			= "";
	String alt_id3_no			= "";
	String alt_id4_no			= "";
	String alt_id1_exp_date		= "";
	String alt_id2_exp_date		= "";
	String alt_id3_exp_date		= "";
	String alt_id4_exp_date		= "";
	String oth_alt_id_type		= "";
	String oth_alt_id_no		= "";
	String eth_grp				= "";
	String eth_sub_grp			= ""; 
	String res_addr_line1		= "";
	String res_addr_line2		= "";
	String res_addr_line3		= "";
	String res_addr_line4		= "";
	String res_town_code		= "";
	String res_town_desc		= "";
	String res_area_code		= "";
	String res_area_desc		= "";
	String res_region_code		= "";
	String res_region_desc		= "";		
	String res_country_code		= "";
	String res_country_desc		= "";
	String citizen				= "";
	String legal				= "";
	String postal_code			= "";
	String mail_addr_line1		= "";
	String mail_addr_line2		= "";
	String mail_addr_line3		= "";
	String mail_addr_line4		= "";
	String mail_town_code		= "";
	String mail_town_desc		= "";
	String mail_area_code		= "";
	String mail_area_desc		= "";
	String mail_postal_code		= "";
	String mail_region_code		= "";
	String mail_region_desc		= "";
	String mail_country_code	= "";
	String mail_country_desc	= "";
	String other_tel_no			= "";
	String oth_contact_no		= "";
	String email_id				= "";
	String years				= "";
	String months				= "";
	String days					= "";
	/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
	String alt_addr_line1	= "";
	String alt_addr_line2	= "";
	String alt_addr_line3	= "";
	String alt_addr_line4	= "";
	String alt_postal_code  = "";
	String alt_postal_desc  = "";
	String alt_country_code = "";
	String alt_country_desc = "";
	String alt_area_code	= "";
	String alt_area_desc	= "";
	String alt_town_code	= "";
	String alt_town_desc	= "";
	String alt_region_code	= "";
	String alt_region_desc	= "";
	/*End*/
	
try
{
	con = ConnectionManager.getConnection(request);
	if(!request_id.equals(""))
	{
		StringBuffer ExeSQL = new StringBuffer();

		ExeSQL.append("SELECT a.oth_Contact_No,");
		ExeSQL.append("        To_char(a.Date_Of_Birth,'dd/mm/yyyy') Date_Of_Birth,");
		ExeSQL.append("        Calculate_age(To_char(a.Date_Of_Birth,'dd/mm/yyyy'),1) Years,");
		ExeSQL.append("        Calculate_age(To_char(a.Date_Of_Birth,'dd/mm/yyyy'),2) Months,");
		ExeSQL.append("        Calculate_age(To_char(a.Date_Of_Birth,'dd/mm/yyyy'),3) Days,");
		ExeSQL.append("        a.eMail_Id,");
		ExeSQL.append("        a.Gender,");
		ExeSQL.append("        a.Patient_Id,");
		ExeSQL.append("        decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) Patient_Name,");
		ExeSQL.append("        a.res_Addr_Line1,");
		ExeSQL.append("        a.res_Addr_Line2,");
		ExeSQL.append("        a.res_Addr_Line3,");
		ExeSQL.append("        a.res_Addr_Line4,");
		ExeSQL.append("        a.res_tel_No,");
		ExeSQL.append("        a.Name_Prefix,");
		ExeSQL.append("        a.First_Name,");
		ExeSQL.append("        a.Second_Name,");
		ExeSQL.append("        a.Third_Name,");
		ExeSQL.append("        a.Family_Name,");
		ExeSQL.append("        a.Name_Suffix,");
		ExeSQL.append("        a.Citizen_yn,");
		ExeSQL.append("        a.Legal_Illegal_yn,");
		ExeSQL.append("        a.alt_Id1_No,");
		ExeSQL.append("        To_char(a.alt_Id1_exp_Date,'dd/mm/yyyy') alt_Id1_exp_Date,");
		ExeSQL.append("        a.alt_Id2_No,");
		ExeSQL.append("        To_char(a.alt_Id2_exp_Date,'dd/mm/yyyy') alt_Id2_exp_Date,");
		ExeSQL.append("        a.alt_Id3_No,");
		ExeSQL.append("        To_char(a.alt_Id3_exp_Date,'dd/mm/yyyy') alt_Id3_exp_Date,");
		ExeSQL.append("        a.alt_Id4_No,");
		ExeSQL.append("        To_char(a.alt_Id4_exp_Date,'dd/mm/yyyy') alt_Id4_exp_Date,");
		ExeSQL.append("        a.oth_alt_Id_Type oth_alt_Id_Type,");
		ExeSQL.append("        a.oth_alt_Id_No oth_alt_Id_No,");
		ExeSQL.append("        a.Mail_Addr_Line1,");
		ExeSQL.append("        a.Mail_Addr_Line2,");
		ExeSQL.append("        a.Mail_Addr_Line3,");
		ExeSQL.append("        a.Mail_Addr_Line4,");
		ExeSQL.append("        a.National_Id_No,");
		ExeSQL.append("        a.Birth_Place_Code Birth_Place_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_birth_place(b.Birth_Place_Code,'"+locale+"','1') Birth_Place_desc,");
		ExeSQL.append("        a.Ethnic_grp_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_race(d.Race_Code,'"+locale+"','1') Race_Description,");
		ExeSQL.append("        a.Mail_Area_Code Mail_Area_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_res_area(e.res_Area_Code,'"+locale+"','1') Mail_Area_Description,");
		ExeSQL.append("        a.Mail_Town_Code Mail_Town_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_res_town(f.res_Town_Code,'"+locale+"','2') Mail_Town_Description,");
		ExeSQL.append("        a.Mail_Region_Code Mail_Region_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_region(g.Region_Code,'"+locale+"','1') Mail_Region_Description,");
		ExeSQL.append("        a.Mail_Postal_Code Mail_Postal_Code,");
		ExeSQL.append("        a.Mail_Country_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_country(i.Country_Code,'"+locale+"','2') Mail_Country_Description,");
		ExeSQL.append("        a.res_Area_Code res_Area_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_res_area(j.res_Area_Code,'"+locale+"','1') res_Area_Description,");
		ExeSQL.append("        a.res_Town_Code res_Town_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_res_town(f.res_Town_Code,'"+locale+"','2') res_Town_Description,");
		ExeSQL.append("        a.res_Region_Code res_Region_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_region(g.Region_Code,'"+locale+"','1') res_Region_Description,");
		ExeSQL.append("        mp_Get_desc.Mp_postal_code(q.Postal_Code,'"+locale+"','2') res_Postal_Description,");
		ExeSQL.append("        a.res_Country_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_country(i.Country_Code,'"+locale+"','2') res_Country_Description,");
		ExeSQL.append("        mp_Get_desc.Mp_country(o.Country_Code,'"+locale+"','1') Nationality_desc,");
		ExeSQL.append("        a.Nationality_Code Nationality_Code ");
		ExeSQL.append(" , a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc ");//Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
		ExeSQL.append(" FROM   ");
		ExeSQL.append("		   MR_REPORT_REQUEST_HDR a,");
		ExeSQL.append("        MP_BIRTH_PLACE b,");
		ExeSQL.append("        MP_ETHNIC_GROUP c,");
		ExeSQL.append("        MP_RACE d,");
		ExeSQL.append("        MP_RES_AREA e,");
		ExeSQL.append("        MP_RES_TOWN f,");
		ExeSQL.append("        MP_REGION g,");
		ExeSQL.append("        MP_POSTAL_CODE h,");
		ExeSQL.append("        MP_COUNTRY i,");
		ExeSQL.append("        MP_RES_AREA j,");
		ExeSQL.append("        MP_RES_TOWN k,");
		ExeSQL.append("        MP_REGION l,");
		ExeSQL.append("        MP_POSTAL_CODE m,");
		ExeSQL.append("        MP_COUNTRY n,");
		ExeSQL.append("        MP_COUNTRY o,");
		ExeSQL.append("        MP_ALTERNATE_ID_TYPE p,");
		ExeSQL.append("        MP_POSTAL_CODE q");
		ExeSQL.append(" WHERE  ");
		ExeSQL.append("		   a.Birth_Place_Code = b.Birth_Place_Code (+) ");
		ExeSQL.append("        AND a.Ethnic_grp_Code = c.Ethnic_Group_Code (+) ");
		ExeSQL.append("        AND a.Race_Code = d.Race_Code (+) ");
		ExeSQL.append("        AND a.Mail_Area_Code = e.res_Area_Code (+) ");
		ExeSQL.append("        AND a.Mail_Town_Code = f.res_Town_Code (+) ");
		ExeSQL.append("        AND a.Mail_Region_Code = g.Region_Code (+) ");
		ExeSQL.append("        AND a.Mail_Postal_Code = h.Postal_Code (+) ");
		ExeSQL.append("        AND a.Mail_Country_Code = i.Country_Code (+) ");
		ExeSQL.append("        AND a.res_Area_Code = j.res_Area_Code (+) ");
		ExeSQL.append("        AND a.res_Town_Code = k.res_Town_Code (+) ");
		ExeSQL.append("        AND a.res_Region_Code = l.Region_Code (+) ");
		ExeSQL.append("        AND a.res_Postal_Code = m.Postal_Code (+) ");
		ExeSQL.append("        AND a.res_Country_Code = n.Country_Code (+) ");
		ExeSQL.append("        AND a.Nationality_Code = o.Country_Code (+) ");
		ExeSQL.append("        AND a.oth_alt_Id_No = p.alt_Id_Type (+) ");
		ExeSQL.append("        AND a.Mail_Postal_Code = q.Postal_Code (+) ");
		ExeSQL.append("		   AND facility_id = '"+Facility_Id+"' ");
		ExeSQL.append("		   AND request_id = '"+request_id+"' ");

		
		detailStmt = con.prepareStatement(ExeSQL.toString());
		detailRS = detailStmt.executeQuery();

		if(detailRS !=null && detailRS.next())
		{
			patient_id				= checkForNull(detailRS.getString("PATIENT_ID"));
			patient_name			= checkForNull(detailRS.getString("PATIENT_NAME"));

			date_of_birth			= checkForNull(detailRS.getString( "date_of_birth" ));
			if(!(date_of_birth==null || date_of_birth.equals("")))
				date_of_birth =  DateUtils.convertDate(date_of_birth,"DMY","en",locale);

			years					= checkForNull(detailRS.getString( "years" ));
			months					= checkForNull(detailRS.getString( "months" ));
			days					= checkForNull(detailRS.getString( "days" ));
			gender					= checkForNull(detailRS.getString( "gender" ));
			if(gender.equals("M")) 
				gender_desc = "Male";
			else if(gender.equals("F")) 
				gender_desc = "Female";
			else if(gender.equals("U")) 
				gender_desc = "Unknown";

			nameprefix				= checkForNull(detailRS.getString( "NAME_PREFIX" ));
			firstname				= checkForNull(detailRS.getString( "FIRST_NAME" ));
			secondname				= checkForNull(detailRS.getString( "SECOND_NAME"));
			thirdname				= checkForNull(detailRS.getString( "THIRD_NAME" ));
			familyname				= checkForNull(detailRS.getString( "FAMILY_NAME" ));
			namesuffix				= checkForNull(detailRS.getString( "NAME_SUFFIX" ));
			citizen					= checkForNull(detailRS.getString("CITIZEN_YN"));
			legal					= checkForNull(detailRS.getString("LEGAL_ILLEGAL_YN"));
			alt_id1_exp_date		= checkForNull(detailRS.getString( "ALT_ID1_EXP_DATE"));
			alt_id2_exp_date		= checkForNull(detailRS.getString( "ALT_ID2_EXP_DATE" ));
			alt_id3_exp_date		= checkForNull(detailRS.getString( "ALT_ID3_EXP_DATE" ));
			alt_id4_exp_date		= checkForNull(detailRS.getString( "ALT_ID4_EXP_DATE" ));
			alt_id1_no				= checkForNull(detailRS.getString( "ALT_ID1_NO" ));
			alt_id2_no				= checkForNull(detailRS.getString( "ALT_ID2_NO" ));
			alt_id3_no				= checkForNull(detailRS.getString( "ALT_ID3_NO" ));
			alt_id4_no				= checkForNull(detailRS.getString( "ALT_ID4_NO" ));
			oth_alt_id_no			= checkForNull(detailRS.getString( "OTH_ALT_ID_NO" ));
			oth_alt_id_type			= checkForNull(detailRS.getString( "OTH_ALT_ID_TYPE" ));
			place_of_birth_desc		= checkForNull(detailRS.getString( "birth_place_desc" ));
			place_of_birth_code		= checkForNull(detailRS.getString( "BIRTH_PLACE_CODE" ));
			eth_grp					= checkForNull(detailRS.getString( "ETHNIC_GRP_CODE" ));
			eth_sub_grp				= checkForNull(detailRS.getString( "RACE_DESCRIPTION" ));
			national_id_no			= checkForNull(detailRS.getString( "NATIONAL_ID_NO" ));
			nationality_code		= checkForNull(detailRS.getString( "NATIONALITY_CODE" ));
			nationality_long_desc	= checkForNull(detailRS.getString( "NATIONALITY_DESC" ));
			
			res_addr_line1			= checkForNull(detailRS.getString( "RES_ADDR_LINE1" ));
			res_addr_line2			= checkForNull(detailRS.getString( "RES_ADDR_LINE2" ));
			res_addr_line3			= checkForNull(detailRS.getString( "RES_ADDR_LINE3" ));
			res_addr_line4			= checkForNull(detailRS.getString( "RES_ADDR_LINE4" ));
			res_town_code			= checkForNull(detailRS.getString( "RES_TOWN_CODE" ));
			res_town_desc			= checkForNull(detailRS.getString( "RES_TOWN_DESCRIPTION" ));
			res_area_code			= checkForNull(detailRS.getString( "RES_AREA_CODE" ));
			res_area_desc			= checkForNull(detailRS.getString( "RES_AREA_DESCRIPTION" ));
			res_region_code			= checkForNull(detailRS.getString( "RES_REGION_CODE"));
			res_region_desc			= checkForNull(detailRS.getString( "RES_REGION_DESCRIPTION"));
			postal_code				= checkForNull(detailRS.getString( "RES_POSTAL_DESCRIPTION" ));
			res_country_desc		= checkForNull(detailRS.getString( "RES_COUNTRY_DESCRIPTION" ));
			res_country_code		= checkForNull(detailRS.getString( "RES_COUNTRY_CODE" ));

			mail_addr_line1			= checkForNull(detailRS.getString( "MAIL_ADDR_LINE1" ));
			mail_addr_line2			= checkForNull(detailRS.getString( "MAIL_ADDR_LINE2" ));
			mail_addr_line3			= checkForNull(detailRS.getString( "MAIL_ADDR_LINE3" ));
			mail_addr_line4			= checkForNull(detailRS.getString( "MAIL_ADDR_LINE4" ));
			mail_town_code			= checkForNull(detailRS.getString("MAIL_TOWN_CODE"));
			mail_town_desc			= checkForNull(detailRS.getString("MAIL_TOWN_DESCRIPTION"));
			mail_area_code			= checkForNull(detailRS.getString("MAIL_AREA_CODE"));
			mail_area_desc			= checkForNull(detailRS.getString("MAIL_AREA_DESCRIPTION"));
			mail_region_code		= checkForNull(detailRS.getString("MAIL_REGION_CODE"));
			mail_region_desc		= checkForNull(detailRS.getString("MAIL_REGION_DESCRIPTION"));
			mail_postal_code		= checkForNull(detailRS.getString("MAIL_POSTAL_CODE"));
			mail_country_code		= checkForNull(detailRS.getString("MAIL_COUNTRY_CODE"));
			mail_country_desc		= checkForNull(detailRS.getString("MAIL_COUNTRY_DESCRIPTION"));

			/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(detailRS.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(detailRS.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(detailRS.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(detailRS.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(detailRS.getString("alt_area_code"));
			alt_area_desc		= checkForNull(detailRS.getString("alt_area_desc"));
			alt_town_code		= checkForNull(detailRS.getString("alt_town_code"));
			alt_town_desc		= checkForNull(detailRS.getString("alt_town_desc"));
			alt_region_code		= checkForNull(detailRS.getString("alt_region_code"));
			alt_region_desc		= checkForNull(detailRS.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(detailRS.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(detailRS.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(detailRS.getString("alt_country_code"));
			alt_country_desc	= checkForNull(detailRS.getString("alt_country_desc"));
			/*End*/

			oth_contact_no			= checkForNull(detailRS.getString( "OTH_CONTACT_NO" ));
			other_tel_no			= checkForNull(detailRS.getString( "RES_TEL_NO" ));
			email_id				= checkForNull(detailRS.getString( "EMAIL_ID" ));
		}

		if(detailRS!=null)	detailRS.close();
		if(detailStmt!=null)detailStmt.close();
	}

	String contactSql=" SELECT nat_id_prompt, accept_national_id_no_yn FROM MP_PARAM where module_id='MP'";

	Stmt	= con.createStatement();
	detailRS	= Stmt.executeQuery(contactSql);

	if(detailRS.next() && detailRS != null)
	{
		nat_id_prompt			= checkForNull(detailRS.getString("nat_id_prompt"));
		accept_national_id_no_yn= checkForNull(detailRS.getString("accept_national_id_no_yn"));
	}
	if(detailRS !=null) detailRS.close();
	if(Stmt !=null) Stmt.close();

	String alt_id_sql=" SELECT short_desc FROM MP_ALTERNATE_ID_TYPE_LANG_VW a , MP_PARAM b WHERE a.alt_id_type = b.alt_id1_type and b.module_id='MP' and a.language_id='"+locale+"'";

	Stmt= con.createStatement();
	detailRS	= Stmt.executeQuery(alt_id_sql);

	if(detailRS.next() && detailRS != null)
	{
		alt_id1_type			= checkForNull(detailRS.getString("short_desc"));
	}
	if(detailRS !=null) detailRS.close();
	if(Stmt !=null) Stmt.close();

}catch(Exception exp)
{
	//out.println("Exception in MedBoardRequestDetail.jsp : "+exp.toString());
	exp.printStackTrace();
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

<body  onload='FocusFirstElement1()' OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>
	<form name='MedBoardReqDetailForm' id='MedBoardReqDetailForm'  method=post >
		<table border="0" width="100%" cellspacing='0' cellpadding='1'>
<%			if(call_function.equals("MEDICAL_BOARD_REQUEST"))
			{	%>
				<tr>		
					<td  colspan='4'>
						<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name ="function_id" value= "" /> 	
						<jsp:param name ="patient_id" value= "" /> 	
						<jsp:param name ="alert_reqd_yn" value= "Y" /> 		
						<jsp:param name ="bodyFrame" value= "parent.frames[2]" /> 	
						<jsp:param name ="submitFrame" value= "parent.frames[4]" />
						</jsp:include>
					</td>
				</tr>
			<%	}
				else
				{	%>
					<tr><td class="COLUMNHEADER" colspan=4><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td></tr> 
					<tr>
						<td  width="20%"  class='label'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td  width="25%"  class=querydata ><%=patient_id%></td>
						<td  width="30%"  class='label'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
						<td   class=querydata ><%=patient_name%><input type="hidden" name="patient_name" id="patient_name" value="<%=patient_name%>" ></td>
					</tr>
					<tr>
				<%	if(accept_national_id_no_yn.equals("Y"))
					{	%>
						<td  class='label'><%=nat_id_prompt%></td>
						<td  class='querydata'><%=national_id_no%></td>
				<%	}else{	%>
							<td class='label'>&nbsp;</td>
							<td class='label'>&nbsp;</td>
				<%	}	%>

				<%	if(!alt_id1_type.equals(""))
					{	%>
						<td  class='label'><%=alt_id1_type%></td>
						<td  class='querydata'><%=alt_id1_no%></td>
				<%	}else{	%>
							<td class='label'>&nbsp;</td>
							<td class='label'>&nbsp;</td>
				<%	}	%>
					</tr>
					<tr>
						<td   class='label'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
						<td   class=querydata ><%=date_of_birth%></td>
						<td   class='label'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
						<td   class=querydata ><%=gender_desc%></td>
					</tr>
			<%	}	%>
					<tr><td colspan='4' class='label'>&nbsp;</td></tr>
			</table>
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

