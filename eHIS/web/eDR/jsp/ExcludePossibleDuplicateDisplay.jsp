<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/PossibleDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
	String locale = (String)session.getAttribute("LOCALE");
	Connection con				= null;
	java.sql.Statement	stmt	= null;
	java.sql.Statement stmt1	= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	

	String p_patient_id		= "";
	String dup_group_id_s	= "";
	String p_patient_id1	= "";
	String p_patient_id2	= "";
	String area_desc		= "";
	String area_sql			= "";
	String p_first_name		= "";
	String p_second_name	= "";
	String p_third_name		= "";
	String p_family_name	= "";
	String p_order_by		= "";
	String sql_pat			= "";
	String sql_count		= "";
	String str				= "";
	String sex				= "";

	int dup_group_id	= 0;
	int count			= 0;
	int dup_count		= 0;
	int loopcnt			= 0;

	try
	{
		con		= ConnectionManager.getConnection(request); 
		stmt	= con.createStatement();
		stmt1	= con.createStatement();

		dup_group_id_s = request.getParameter("p_dup_group_id");
		if (!dup_group_id_s.equals("X"))
		{
			dup_group_id = Integer.parseInt(dup_group_id_s);
		}
		else 
		{
			p_patient_id1 = request.getParameter("p_patient_id1");
			p_patient_id2 = request.getParameter("p_patient_id2");
					
			if(p_patient_id1 == null)
			{
				p_patient_id1 = "";
			}
			if(p_patient_id2 == null)
			{
				p_patient_id2 = "";
			}

			//area_sql = "SELECT (case when trunc(a.regn_date) < trunc(b.regn_date) then a.patient_id else b.patient_id end) patient_id1,(case when trunc(a.regn_date) <  trunc(b.regn_date) then b.patient_id else a.patient_id end) patient_id2 FROM dr_mp_pat_dtls_vw a, dr_mp_pat_dtls_vw b WHERE a.patient_id = '"+p_patient_id1+"' and b.patient_id= '"+p_patient_id2+"'";

			area_sql = "SELECT (case when trunc(a.regn_date) < trunc(b.regn_date) then a.patient_id else b.patient_id end) patient_id1,(case when trunc(a.regn_date) <  trunc(b.regn_date) then b.patient_id else a.patient_id end) patient_id2 FROM mp_patient a, mp_patient b WHERE a.patient_id = '"+p_patient_id1+"' and b.patient_id= '"+p_patient_id2+"'";

			rs1	= stmt1.executeQuery(area_sql);		
			if(rs1.next())
			{
				p_patient_id1 = rs1.getString("patient_id1");
				p_patient_id2 = rs1.getString("patient_id2");
			} if(rs1 != null) rs1.close();
		}

		area_sql = "SELECT LTRIM (RTRIM (res_area_prompt)) res_area_prompt, LTRIM (RTRIM (nvl(first_name_prompt,'First Name'))) first_name_prompt,LTRIM (RTRIM (nvl( second_name_prompt,'Second Name'))) second_name_prompt, LTRIM (RTRIM (nvl(third_name_prompt,'Third Name'))) third_name_prompt,LTRIM (RTRIM (nvl( family_name_prompt,'Family Name'))) family_name_prompt  FROM mp_param_lang_vw a, sm_site_param_lang_vw b WHERE a.language_id = 'en' AND b.language_id = 'en'";
		
		rs1	= stmt1.executeQuery(area_sql);
		if(rs1 != null)
		{
			if(rs1.next() )
			{
				area_desc		= rs1.getString("res_area_prompt");
				p_first_name	= rs1.getString("first_name_prompt");
				p_second_name	= rs1.getString("second_name_prompt");
				p_third_name	= rs1.getString("third_name_prompt");
				p_family_name	= rs1.getString("family_name_prompt");
			}
		} if(rs1 != null) rs1.close();
		
		if(dup_group_id_s.equals("X"))
		{
			count=1;
			for(loopcnt = 1;loopcnt <= 2;loopcnt++)
			{
				if(loopcnt == 1) p_patient_id = p_patient_id1;
				else if(loopcnt == 2) p_patient_id = p_patient_id2;
				
				//sql_pat = "SELECT patient_id, ltrim(rtrim(first_name)) first_name, ltrim(rtrim(second_name)) second_name, ltrim(rtrim(third_name)) third_name, ltrim(rtrim(family_name)) family_name, pat_ser_grp_desc,national_id_no, nationality_desc, decode(sex,'M','Male','F','Female','Unknown') sex, to_char(date_of_birth, 'dd/mm/yyyy') date_of_birth1, ltrim(rtrim(res_area_desc)) res_area_desc, prn_tel_no contact1_no, orn_tel_no contact2_no, regn_facility_id, to_char(regn_date, 'dd/mm/yyyy hh24:mi') mp_patient_added_date1 FROM dr_mp_pat_dtls_vw WHERE patient_id = '"+p_patient_id+"' ";

				sql_pat = "SELECT patient_id, decode('"+locale+"', 'en', first_name, nvl(first_name_loc_lang, first_name)) first_name, decode('"+locale+"', 'en', second_name, nvl(second_name_loc_lang, second_name)) second_name,  decode('"+locale+"', 'en', third_name, nvl(third_name_loc_lang, third_name)) third_name,  decode('"+locale+"', 'en', family_name, nvl(family_name_loc_lang, family_name)) family_name,  mp_get_desc.MP_PAT_SER_GRP(PAT_SER_GRP_CODE,'"+locale+"',2)pat_ser_grp_desc, national_id_no, mp_get_desc.MP_COUNTRY(NATIONALITY_CODE,'"+locale+"',3)nationality_desc, sex,  TO_CHAR(date_of_birth, 'dd/mm/yyyy') date_of_birth1,  mp_get_desc.MP_RES_AREA(RES_AREA_CODE,'"+locale+"',1) res_area_desc, contact1_no, contact2_no,  regn_facility_id, TO_CHAR(regn_date,'dd/mm/yyyy hh24:mi') mp_patient_added_date1 FROM MP_PATIENT PATIENT WHERE patient_id = '"+p_patient_id+"'";
			
				rs	= stmt.executeQuery(sql_pat);
				if(rs != null)
				{
					while(rs.next())
					{
						if(count == 1)
						{
							count = 0;
							%>	
							<br>
	<table border='1' align='left' cellspacing='0' cellpadding='0' width='29%'>
			
			<TR><TD class='label'><b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></b></TD></TR>
			<TR><TD class='label'><b><fmt:message key="eDR.RegnFacility.label" bundle="${dr_labels}"/></b></TD></TR>
			<TR><TD class='label'><b><fmt:message key="Common.regndatetime.label" bundle="${common_labels}"/></b></TD></TR>
			<TR><TD class='label'><b><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></b></TD></TR>
			<TR><TD class='label'><b><fmt:message key="eMP.NationalID.label" bundle="${mp_labels}"/></b></TD></TR>
			<TR><TD class='label'><b><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></b></TD></TR>
								
								<% if(p_first_name != null) { %>
			<TR><TD class='label'><b><%=p_first_name%></b></TD></TR>
								<% } if(p_second_name != null) { %>
			<TR><TD class='label'><b><%=p_second_name%></b></TD></TR>
								<% } if(p_third_name != null) { %>
			<TR><TD class='label'><b><%=p_third_name%></b></TD></TR>
								<% } if(p_family_name != null) { %>
			<TR><TD class='label'><b><%=p_family_name%></b></TD></TR>
								<% } %>
			<TR><TD class='label'><b><fmt:message key="Common.gender.label" bundle="${common_labels}"/></b> </TD></TR>
			<TR><TD class='label'><b><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></b></TD></TR>
								<% if(area_desc != null) { %>
			<TR><TD class='label'><b><%=area_desc%> </b></TD></TR>
								<% } %>
			<TR><TD class='label'><b><fmt:message key="Common.resitelno.label" bundle="${common_labels}"/></b></TD></TR>
			<TR><TD class='label'><b><fmt:message key="Common.othertelno.label" bundle="${common_labels}"/></b></TD></TR>
	</table> 
							<%		
						}

						out.println("<table border='1' align='left' cellspacing='0' cellpadding='0' width='30%'>");
						out.println("<tr><td nowrap  class='label' >");
						if(rs.getString("patient_id") != null)
							out.println(rs.getString("patient_id"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");
						out.println("<tr><td nowrap  class='label'>");
						if(rs.getString("regn_facility_id") != null)
							out.println(rs.getString("regn_facility_id"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");	
						out.println("<tr><td nowrap  class='label'>");
						String mp_patient_added_date1=rs.getString("mp_patient_added_date1")==null?"":rs.getString("mp_patient_added_date1");
					if(!mp_patient_added_date1.equals(""))	
						{	mp_patient_added_date1=DateUtils.convertDate(mp_patient_added_date1,"DMYHM","en",localeName);
						}

						out.println(mp_patient_added_date1);
						out.println("</td></tr>");
						out.println("<tr><td nowrap class='label'>");
						if(rs.getString("pat_ser_grp_desc") != null)
							out.println(rs.getString("pat_ser_grp_desc"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");
						out.println("<tr><td nowrap class='label'>");
						if(rs.getString("national_id_no") != null)
							out.println(rs.getString("national_id_no"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");
						out.println("<tr><td nowrap class='label'>");
						if(rs.getString("nationality_desc") != null)
							out.println(rs.getString("nationality_desc"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");	
						if(p_first_name != null)
						{
							out.println("<tr><td nowrap class='label'>");
							if(rs.getString("first_name") != null)
							out.println(rs.getString("first_name"));
							else
							out.println("&nbsp;");
							out.println("</td></tr>");	
						}
						if(p_second_name != null)
						{
							out.println("<tr><td nowrap class='label'>");
							if(rs.getString("second_name") != null)
								out.println(rs.getString("second_name"));
							else
								out.println("&nbsp;");
							out.println("</td></tr>");
						}
						if(p_third_name != null)
						{
							out.println("<tr><td nowrap class='label'>");
							if(rs.getString("third_name") != null)
								out.println(rs.getString("third_name"));
							else
								out.println("&nbsp;");
							out.println("</td></tr>");	
						}
						if(p_family_name != null)
						{
							out.println("<tr><td nowrap class='label'>");
							if(rs.getString("family_name") != null)
								out.println(rs.getString("family_name"));
							else
								out.println("&nbsp;");
							out.println("</td></tr>");
						}
						out.println("<tr><td nowrap class='label'>");
						sex = rs.getString("sex");
						if(rs.getString("sex") != null)
							out.println(rs.getString("sex"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");	
						
					String date_of_birth1=rs.getString("date_of_birth1")==null?"":rs.getString("date_of_birth1");
					if(!date_of_birth1.equals(""))	
						{	date_of_birth1=DateUtils.convertDate(date_of_birth1,"DMY","en",localeName);
						}

						
					
						
						
						out.println("<tr><td nowrap class='label'>");
						out.println(date_of_birth1);
						out.println("</td></tr>");
						if(area_desc != null)
						{
							out.println("<tr><td nowrap class='label'>");
							if(rs.getString("res_area_desc") != null)
								out.println(rs.getString("res_area_desc"));
							else
								out.println("&nbsp;");
							out.println("</td></tr>");
						}
						out.println("<tr><td nowrap class='label'>");
						if(rs.getString("contact1_no") != null)
							out.println(rs.getString("contact1_no"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");
						out.println("<tr><td nowrap class='label'>");
						if(rs.getString("contact2_no") != null)
							out.println(rs.getString("contact2_no"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");	
						out.println("</table>");	
		
					} if(rs != null) rs.close();
				}
			}
		}// outer most if
		else
		{
			dup_count	= 0;
			sql_count	= "";

			sql_count	= "SELECT pat_count FROM dr_dup_group_vw1 WHERE dup_group_id="+dup_group_id;
			rs1			= stmt1.executeQuery(sql_count);

			if(rs1 != null)
			{
				if(rs1.next())
				{
					dup_count	= rs1.getInt("pat_count");
				}
		   } if(rs1 != null) rs1.close();

		if(dup_count <= 10)
		{
			count	= 1;
			sql_pat	= "";

			str  = "SELECT decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle FROM dr_process_ctl " ;
			rs	 = stmt.executeQuery(str);
			if(rs.next())
			{
				p_order_by = rs.getString("order_by_for_process_cycle");
			} if(rs != null) rs.close();
		
			
			
			
			sql_pat = "SELECT   b.patient_id,  DECODE('"+locale+"', 'en', b.first_name, NVL(b.first_name_loc_lang, b.first_name)) first_name,  DECODE('"+locale+"', 'en', b.second_name, NVL(b.second_name_loc_lang, b.second_name)) second_name,  DECODE('"+locale+"', 'en', b.third_name, NVL(b.third_name_loc_lang, b.third_name)) third_name,  DECODE('"+locale+"', 'en', b.family_name, NVL(b.family_name_loc_lang, b.family_name)) family_name,  mp_get_desc.MP_PAT_SER_GRP(b.PAT_SER_GRP_CODE,'"+locale+"',2) pat_ser_grp_desc,  b.national_id_no,  mp_get_desc.MP_COUNTRY(b.NATIONALITY_CODE,'"+locale+"',3)nationality_desc, sex, TO_CHAR(b.date_of_birth, 'dd/mm/yyyy') date_of_birth1,  mp_get_desc.MP_RES_AREA(b.RES_AREA_CODE,'"+locale+"',1) res_area_desc, b.contact1_no, b.contact2_no, b.regn_facility_id,  TO_CHAR(regn_date,'dd/mm/yyyy hh24:mi') mp_patient_added_date1 FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE a.dup_group_id = "+dup_group_id+" AND a.dup_group_id = b.dup_group_id ORDER BY "+p_order_by;
			
		//	sql_pat = "SELECT patient_id,ltrim(rtrim(first_name))first_name,ltrim(rtrim(second_name))second_name, ltrim(rtrim(third_name))third_name,ltrim(rtrim(family_name))family_name,pat_ser_grp_desc,national_id_no,nationality_desc,decode(sex,'M','Male','F','Female','Unknown') sex,to_char(date_of_birth, 'dd/mm/yyyy')date_of_birth1,ltrim(rtrim(res_area_desc))res_area_desc,prn_tel_no contact1_no,orn_tel_no contact2_no,regn_facility_id,to_char(regn_date, 'dd/mm/yyyy hh24:mi')mp_patient_added_date1 FROM dr_dup_group_vw1 WHERE dup_group_id="+dup_group_id+" order by "+p_order_by+" " ;
			rs = stmt.executeQuery(sql_pat);
			if(rs != null)
			{
				while(rs.next())
				{
					if(count == 1)
					{
						count = 0;
						%>
						<br>
		<table border='1' align='left' cellspacing='0' cellpadding='0'>
					
			<TR><TD class='label' ><b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></b> </TD></TR>
			<TR><TD class='label'><b><fmt:message key="eDR.RegnFacility.label" bundle="${dr_labels}"/> </b></TD></TR>
			<TR><TD class='label'><b><fmt:message key="Common.regndatetime.label" bundle="${common_labels}"/></b></TD></TR>
			<TR><TD class='label'><b><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></b> </TD></TR>
			<TR><TD class='label'><b><fmt:message key="eMP.NationalID.label" bundle="${mp_labels}"/></b> </TD></TR>
			<TR><TD class='label'><b><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></b></TD></TR>
							<% if(p_first_name != null) { %>
			<TR><TD class='label'><b><%=p_first_name%></b></TD></TR>
							<% } if(p_second_name != null) { %>
			<TR><TD class='label'><b><%=p_second_name%></b> </TD></TR>
 							<% } if(p_third_name != null) { %>
			<TR><TD class='label'><b><%=p_third_name%></b> </TD></TR>
							<% } if(p_family_name != null) { %>
			<TR><TD class='label'><b><%=p_family_name%></b> </TD></TR>
							<% } %>
			<TR><TD class='label'><b>Sex</b> </TD></TR>
			<TR><TD class='label'><b><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></b> </TD></TR>
							<% if(area_desc != null) { %>
			<TR><TD class='label'><b><%=area_desc%> </b></TD></TR>
							<% } %>
			<TR><TD class='label'><b><fmt:message key="Common.resitelno.label" bundle="${common_labels}"/></b> </TD></TR>
			<TR><TD class='label'><b><fmt:message key="Common.othertelno.label" bundle="${common_labels}"/></b> </TD></TR>
		</table>
						<%
					}

					out.println("<table border='1' align='left' cellspacing='0' cellpadding='0' >");
					out.println("<tr><td nowrap class='label' >");
					if(rs.getString("patient_id") != null)
						out.println(rs.getString("patient_id"));
					else
						out.println("&nbsp;");
					out.println("</td></tr>");
					out.println("<tr><td nowrap class='label'>");
					if(rs.getString("regn_facility_id") != null)
						out.println(rs.getString("regn_facility_id"));
					else
						out.println("&nbsp;");
					out.println("</td></tr>");	
					
					out.println("<tr><td nowrap class='label'>");
						String mp_patient_added_date1=rs.getString("mp_patient_added_date1")==null?"":rs.getString("mp_patient_added_date1");
					if(!mp_patient_added_date1.equals(""))	
						{	mp_patient_added_date1=DateUtils.convertDate(mp_patient_added_date1,"DMYHM","en",localeName);
						}
					/*if(rs.getString("mp_patient_added_date1") != null)
						out.println(rs.getString("mp_patient_added_date1"));
					else*/
						out.println(mp_patient_added_date1);


					out.println("</td></tr>");
					out.println("<tr><td nowrap class='label'>");
					if(rs.getString("pat_ser_grp_desc") != null)
						out.println(rs.getString("pat_ser_grp_desc"));
					else
						out.println("&nbsp;");
					out.println("</td></tr>");
					out.println("<tr><td nowrap class='label'>");
					if(rs.getString("national_id_no") != null)
					out.println(rs.getString("national_id_no"));
					else
						out.println("&nbsp;");
					out.println("</td></tr>");
					out.println("<tr><td nowrap class='label'>");
					if(rs.getString("nationality_desc") != null)
						out.println(rs.getString("nationality_desc"));
					else
						out.println("&nbsp;");
					out.println("</td></tr>");	
					if(p_first_name != null)
					{
						out.println("<tr><td nowrap class='label'>");
						if(rs.getString("first_name") != null)
							out.println(rs.getString("first_name"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");	
					}
					if(p_second_name != null)
					{
						out.println("<tr><td nowrap class='label'>");
						if(rs.getString("second_name") != null)
							out.println(rs.getString("second_name"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");
					}
					if(p_third_name != null)
					{
						out.println("<tr><td nowrap class='label'>");
						if(rs.getString("third_name") != null)
							out.println(rs.getString("third_name"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");	
					}
					if(p_family_name != null)
					{
						out.println("<tr><td nowrap class='label'>");
						if(rs.getString("family_name") != null)
							out.println(rs.getString("family_name"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");
					}
					out.println("<tr><td nowrap class='label'>");
					if(rs.getString("sex") != null)
						out.println(rs.getString("sex"));
					else
						out.println("&nbsp;");
					out.println("</td></tr>");	
					out.println("<tr><td nowrap class='label'>");
					String date_of_birth1=rs.getString("date_of_birth1")==null?"":rs.getString("date_of_birth1");
					if(!date_of_birth1.equals(""))	
						{	date_of_birth1=DateUtils.convertDate(date_of_birth1,"DMYHM","en",localeName);
						}
					out.println(date_of_birth1);
					out.println("</td></tr>");
					if(area_desc != null)
					{
						out.println("<tr><td nowrap class='label'>");
						if(rs.getString("res_area_desc") != null)
							out.println(rs.getString("res_area_desc"));
						else
							out.println("&nbsp;");
						out.println("</td></tr>");
					}
					out.println("<tr><td nowrap class='label'>");
					if(rs.getString("contact1_no") != null)
						out.println(rs.getString("contact1_no"));
					else
						out.println("&nbsp;");
					out.println("</td></tr>");
					out.println("<tr><td nowrap class='label'>");
					if(rs.getString("contact2_no") != null)
						out.println(rs.getString("contact2_no"));
					else
						out.println("&nbsp;");
					out.println("</td></tr>");	
					out.println("</table>");	
				}
			} if(rs != null) rs.close();
		}
	}//outer else
	%>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<table border='0' cellspacing='0' cellpadding='0' width='100%' >
		<tr><td class=white align='center'><input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='modal_close();'></td></tr>	
	</table>
	<%
		if(rs != null) rs.close();
		if(rs1 != null) rs1.close();
		if(stmt != null) stmt.close();
		if(stmt1 != null) stmt1.close();
	}
	catch(Exception e)
	{
		out.println("Excetion :"+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

