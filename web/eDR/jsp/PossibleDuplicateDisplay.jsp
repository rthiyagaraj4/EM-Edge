<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
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
<%
		String locale=(String)session.getAttribute("LOCALE");
		ResultSet rs                =    null;
		java.sql.Statement stmt     =    null;
		ResultSet rs1               =    null;
		java.sql.Statement stmt1    =    null;
		Connection con              =    null;

		String p_patient_id1s	    =    "";
		//String area_sql				=    "";
		String sql_pat				=    "";
		String p_nationality        =    "";
		String p_alt_id             =    "";
		String sql1                 =    "";
		String Citizen_yn           =    "";
		String Legal_yn             =    "";	
		String Sex                  =    "";
		//String p_first_name			=    "";
		//String p_second_name	    =    "";
		//String p_third_name			=    "";
		//String p_family_name	    =    "";

		int dup_group_id            =    0;
		int count					=	 0;
		
 try
	{
		
		con							=    ConnectionManager.getConnection(request);
		stmt						=    con.createStatement();
		stmt1						=	 con.createStatement();

		dup_group_id=Integer.parseInt(checkForNull(request.getParameter("p_dup_group_id")));
		p_patient_id1s = (request.getParameter("p_patient_id1"));
		
		/*area_sql="select ltrim(rtrim(res_area_prompt))res_area_prompt,ltrim(rtrim(first_name_prompt))first_name_prompt,ltrim(rtrim(second_name_prompt))second_name_prompt,ltrim(rtrim(third_name_prompt))third_name_prompt,ltrim(rtrim(family_name_prompt))family_name_prompt from mp_param,sm_site_param";
		rs1=stmt1.executeQuery(area_sql);
		if(rs1!=null)
		{
			if(rs1.next() )
			{
				area_desc	    =   checkForNull(rs1.getString("res_area_prompt"));
				p_first_name	=	checkForNull(rs1.getString("first_name_prompt"));
				p_second_name	=	checkForNull(rs1.getString("second_name_prompt"));
				p_third_name	=	checkForNull(rs1.getString("third_name_prompt"));
				p_family_name	=	checkForNull(rs1.getString("family_name_prompt"));
				
			}
		}
		if (rs1 != null) rs1 .close();*/
		//sql1="select NVL(a.nat_id_prompt,'National ID No') nat_id_prompt,b.short_desc alt_id1_type_desc from mp_param a, mp_alternate_id_type b where a.alt_id1_type=b.alt_id_type";

		sql1="SELECT  NVL(nat_id_prompt,'National ID No') nat_id_prompt,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"',1) alt_id1_type_desc FROM mp_param_lang_vw where language_id = '"+locale+"'";

		rs1=stmt1.executeQuery(sql1);
		if(rs1!=null)
		{
			if(rs1.next())
			{
				 p_nationality= checkForNull(rs1.getString("NAT_ID_PROMPT"));
				 p_alt_id	  = checkForNull(rs1.getString("ALT_ID1_TYPE_DESC"));
			}
		}if (rs1 != null) rs1 .close();
		

		
		  count=1;

		      //sql_pat="select patient_id,patient_name, ALT_ID1_NO, decode(OTH_ALT_ID_NO,null, null, OTH_ALT_ID_TYPE_DESC || '-'||OTH_ALT_ID_NO) ALT_NO,PLACE_OF_BIRTH,decode(CITIZEN_YN,'Y','Citizen','Non-citizen') citizen_yn,decode(LEGAL_YN,'Y','Legal','Illegal') legal_yn,RACE_DESC,ETHNIC_GRP_DESC,MAR_STATUS_DESC,RELGN_DESC,ltrim(rtrim(first_name))first_name,ltrim(rtrim(second_name))second_name,ltrim(rtrim(third_name))third_name,ltrim(rtrim(family_name))family_name,pat_ser_grp_desc,national_id_no,nationality_desc,decode(sex,'M','Male','F','Female','Unknown') sex,to_char(date_of_birth, 'dd/mm/yyyy')date_of_birth1,ltrim(rtrim(res_area_desc))res_area_desc,contact1_no,contact2_no,regn_facility_id,to_char(mp_patient_added_date, 'dd/mm/yyyy hh24:mi')mp_patient_added_date1, blood_grp, rh_Factor  from dr_dup_group_vw1 where dup_group_id="+dup_group_id+" and  patient_id in("+p_patient_id1s+") order by MP_PATIENT_ADDED_DATE,patient_id";

			  sql_pat="SELECT b.patient_id, decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.ALT_ID1_NO, DECODE(b.OTH_ALT_ID_NO, NULL, NULL,  mp_get_desc.MP_ALTERNATE_ID_TYPE(b.OTH_ALT_ID_TYPE,'"+locale+"',1)|| '-'||d.OTH_ALT_ID_NO) ALT_NO,  PLACE_OF_BIRTH, citizen_yn, legal_yn, mp_get_desc.MP_RACE(d.race_code,'"+locale+"',2)RACE_DESC,  mp_get_desc.MP_ETHNIC_GROUP(d.ETHNIC_GRP_CODE,'"+locale+"',2) ETHNIC_GRP_DESC,  mp_get_desc.MP_MARITAL_STATUS(d.MAR_STATUS_CODE,'"+locale+"',2 )MAR_STATUS_DESC,  mp_get_desc.MP_REGION(d.RELGN_CODE,'"+locale+"',2)RELGN_DESC,  DECODE('"+locale+"', 'en', d.first_name, NVL(d.first_name_loc_lang, d.first_name)) first_name, DECODE('"+locale+"', 'en', d.second_name, NVL(d.second_name_loc_lang, d.second_name)) second_name,  DECODE('"+locale+"', 'en', d.third_name, NVL(d.third_name_loc_lang, d.third_name)) third_name,  DECODE('"+locale+"', 'en', d.family_name, NVL(d.family_name_loc_lang, d.family_name)) family_name, mp_get_desc.MP_PAT_SER_GRP(B.PAT_SER_GRP_CODE,'"+locale+"',2)pat_ser_grp_desc, b.national_id_no,  mp_get_desc.MP_COUNTRY(B.NATIONALITY_CODE,'"+locale+"',3)nationality_desc, b.sex, TO_CHAR(b.date_of_birth,  'dd/mm/yyyy') date_of_birth1, mp_get_desc.MP_RES_AREA(b.RES_AREA_CODE,'"+locale+"',1) res_area_desc,  b.contact1_no, b.contact2_no, b.regn_facility_id, TO_CHAR(mp_patient_added_date, 'dd/mm/yyyy hh24:mi')mp_patient_added_date1, blood_grp, mr_get_desc.MR_RHESUS_FACTOR(C.RH_FACTOR,'"+locale+"',2) rh_Factor FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B,MP_PAT_OTH_DTLS C,MP_PATIENT D WHERE   A.DUP_GROUP_ID = B.DUP_GROUP_ID AND  B.PATIENT_ID = C.PATIENT_ID  AND B.PATIENT_ID = D.PATIENT_ID AND   a.dup_group_id='"+dup_group_id+"' AND b.patient_id IN("+p_patient_id1s+") ORDER BY MP_PATIENT_ADDED_DATE,b.patient_id";	


			 rs=stmt.executeQuery(sql_pat);
		      if(rs!=null)
			   {
		         while(rs.next())
		          {
		            if(count==1)
					{
		              count=0;
		
	
%>	
<body onMouseDown="CodeArrest()" onKeyDown ="lockKey()">
<br>
<div style="display:flex;">
<table border='1' align='left' cellspacing='0' cellpadding='0' width='30%' style="flex-shrink: 0 !important;flex-grow: 0 !important;flex-basis: auto;">
	<TR><TD class='querydata'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></TD></TR>
	<TR><TD class='querydata'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></TD></TR>
	<TR><TD class='querydata'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></b></TD></TR>
	<TR><TD class='querydata'><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></TD></TR>
	<TR><TD class='querydata'><%=p_nationality%></TD></TR>
	<TR><TD class='querydata'><%=p_alt_id%></TD></TR>

		<TR><TD class='querydata'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></TD></TR>
		<TR><TD class='querydata'><fmt:message key="eDR.PlaceofBirth.label" bundle="${dr_labels}"/></TD></TR>

		<TR><TD class='querydata'><fmt:message key="Common.residency.label" bundle="${common_labels}"/> </TD></TR>
		<TR><TD class='querydata'><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD></TR>
	    <TR><TD class='querydata'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></TD></TR>
	    <TR><TD class='querydata'><fmt:message key="Common.race.label" bundle="${common_labels}"/></TD></TR>
	    <TR><TD class='querydata'><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></TD></TR>
    	
	    <TR><TD class='querydata'><fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/></TD></TR>
	    <TR><TD class='querydata'><fmt:message key="Common.religion.label" bundle="${common_labels}"/></TD></TR>
		<TR><TD class='querydata'><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></TD></TR>
		<TR><TD class='querydata'><fmt:message key="Common.regndatetime.label" bundle="${common_labels}"/></TD></TR>
</table> 
	
<%		
        }
		out.println("<table border='1' align='left' cellspacing='0' cellpadding='0' width='35%' style='flex-shrink: 0 !important;flex-grow: 0 !important;flex-basis: auto;''>");
		out.println("<tr><td nowrap  class='querydata' >");
	if(rs.getString("patient_id") !=null && !rs.getString("patient_id").equals("null"))
					  {
		out.println("<a href=javascript:viewPatientDetails('"+rs.getString("patient_id")+"')>"+rs.getString("patient_id")+"</a>");
		
					  }
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
		out.println("<tr><td nowrap  class='label'>");
	if(rs.getString("patient_name") !=null && !rs.getString("patient_name").equals("null"))
		out.println(rs.getString("patient_name"));
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
		out.println("<tr><td nowrap  class='label'>");
	
	Sex = rs.getString("sex");

	if(Sex.equals("M"))		
	Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(Sex.equals("F"))				  							Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(Sex.equals("U"))				  							Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

	if(( Sex !=null) && (! Sex.equals("null")))
		out.println(Sex);
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
		out.println("<tr><td nowrap class='label'>");
	if(rs.getString("date_of_birth1") !=null && !rs.getString("date_of_birth1").equals("null"))
		  {String date_of_birth1=rs.getString("date_of_birth1");
		   date_of_birth1=DateUtils.convertDate(date_of_birth1,"DMY","en",locale);
		   out.println(date_of_birth1);}
	else
		  {	out.println("&nbsp;");}
		out.println("</td></tr>");
		out.println("<tr><td nowrap class='label'>");
	if(rs.getString("national_id_no") !=null && !rs.getString("national_id_no").equals("null"))
		out.println(rs.getString("national_id_no"));
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
		out.println("<tr><td nowrap class='label'>");
    if(rs.getString("ALT_ID1_NO") !=null && !rs.getString("ALT_ID1_NO").equals("null"))
		out.println(rs.getString("ALT_ID1_NO"));
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
		out.println("<tr><td nowrap class='label'>");
	if(rs.getString("ALT_NO") !=null && !rs.getString("ALT_NO").equals("null"))
					  {	out.println(rs.getString("ALT_NO"));
	                   }
	   
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
		out.println("<tr><td nowrap class='label'>");
	if(rs.getString("PLACE_OF_BIRTH") !=null && !rs.getString("PLACE_OF_BIRTH").equals("null"))
		out.println(rs.getString("PLACE_OF_BIRTH"));
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
		out.println("<tr><td nowrap class='label'>");

	Citizen_yn = rs.getString("CITIZEN_YN");
		
	if(Citizen_yn.equals("Y"))		
	Citizen_yn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.citizen.label","common_labels");
	else if(Citizen_yn.equals("N"))				  							Citizen_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.noncitizen.label","common_labels");

	if(Citizen_yn !=null && !Citizen_yn.equals("null"))
		out.println(Citizen_yn);
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
		out.println("<tr><td nowrap class='label'>");

	Legal_yn = rs.getString("LEGAL_YN");

	if(Legal_yn.equals("Y"))		
	Legal_yn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.legal.label","common_labels");
	else if(Legal_yn.equals("N"))				  							Legal_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.illegal.label","common_labels");

	if( Legal_yn !=null && !(Legal_yn.equals("null")))
		out.println(Legal_yn);
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
		out.println("<tr><td nowrap class='label'>");
	if(rs.getString("nationality_desc") !=null && !rs.getString("nationality_desc").equals("null"))
		out.println(rs.getString("nationality_desc"));
	else
		out.println("&nbsp;");
		out.println("</td></tr>");	
	out.println("<tr><td nowrap class='label'>");
	if(rs.getString("RACE_DESC") !=null && !rs.getString("RACE_DESC").equals("null"))
		out.println(rs.getString("RACE_DESC"));
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
	out.println("<tr><td nowrap class='label'>");
	if(rs.getString("ETHNIC_GRP_DESC") !=null && !rs.getString("ETHNIC_GRP_DESC").equals("null"))
		out.println(rs.getString("ETHNIC_GRP_DESC"));
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
	
		out.println("<tr><td nowrap class='label'>");
	if(rs.getString("MAR_STATUS_DESC") !=null && !rs.getString("MAR_STATUS_DESC").equals("null"))
		out.println(rs.getString("MAR_STATUS_DESC"));
	else
		out.println("&nbsp;");
		out.println("</td></tr>");

		out.println("<tr><td nowrap class='label'>");
	if(rs.getString("RELGN_DESC") !=null && !rs.getString("RELGN_DESC").equals("null"))
		out.println(rs.getString("RELGN_DESC"));
	else
		out.println("&nbsp;");
		out.println("</td></tr>");
		out.println("<tr><td nowrap class='label'>");
	if(rs.getString("blood_grp") !=null && !rs.getString("blood_grp").equals("null"))
		out.println(rs.getString("blood_grp"));
	if(rs.getString("rh_factor") !=null && !rs.getString("rh_Factor").equals("null"))
		out.println(" "+rs.getString("rh_Factor"));
	else
		out.println("&nbsp;");  
		out.println("</td></tr>");
		out.println("<tr><td nowrap class='label'>");
	if(rs.getString("mp_patient_added_date1") !=null && !rs.getString("mp_patient_added_date1").equals("null"))
					  {String mp_patient_added_date1=rs.getString("mp_patient_added_date1");
		               mp_patient_added_date1=DateUtils.convertDate(mp_patient_added_date1,"DMYHM","en",locale);	
	                   out.println(mp_patient_added_date1);
					  }else
					  {out.println("&nbsp;");}
		out.println("</td></tr>");
		out.println("</table>");
	
	    }//E.O.While()
          }if (rs != null) rs .close();
		  //E.o.rs
       //E.O.Loop
	
   // outer most if
  ///outer else
%>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
<table border='0' cellspacing='0' cellpadding='0' width='100%' >
<tr><td class=white align='center'><input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='modal_close();'></td></tr>	
</table>
<%
 
        if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		if(rs1 !=null) rs1.close();
		if(stmt1 !=null) stmt1.close();}
catch(Exception e)
{
	out.println("Exception In The File PossibleDuplicateDisplay :" + e.toString());
}
finally
	{
		
		ConnectionManager.returnConnection(con,request);
    }


%>

</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")))? "" : inputString);
}


%>

