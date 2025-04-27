<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection conn		= null;
	Statement stmt		= null;
	Statement stmt2		= null;
	ResultSet rset		= null;			
	ResultSet rs2		= null;

	String altid1expdate			= "";
	String c_name_prefix_accept_yn	= "";
	String c_first_name_accept_yn	= "";
	String c_second_name_accept_yn	= "";
	String c_third_name_accept_yn	= "";
	String c_family_name_accept_yn	= "";
	String c_name_suffix_accept_yn	= "";
	StringBuffer sqlQuery = new StringBuffer();
	try
	{
		conn	= ConnectionManager.getConnection(request);
		stmt	= conn.createStatement();
		sqlQuery.append("select name_prefix_accept_yn, first_name_accept_yn,second_name_accept_yn,third_name_accept_yn,family_name_accept_yn,name_suffix_accept_yn from mp_param");
		rset	= stmt.executeQuery(sqlQuery.toString());
		if(rset != null && rset.next())
		{
			c_name_prefix_accept_yn		= rset.getString("name_prefix_accept_yn");
			c_first_name_accept_yn		= rset.getString("first_name_accept_yn");
			c_second_name_accept_yn		= rset.getString("second_name_accept_yn");
			c_third_name_accept_yn		= rset.getString("third_name_accept_yn");
			c_family_name_accept_yn		= rset.getString("family_name_accept_yn");
			c_name_suffix_accept_yn		= rset.getString("name_suffix_accept_yn");
		}

		if(rset!=null)		rset.close();
		if(stmt!=null)		stmt.close();

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam2' id='nam2'>");

		int c=0;

		String step		= request.getParameter("step");
		String CA_Pat	= request.getParameter("CA_Pat");

		if(step.equals("P"))
		{
			String patientid	= request.getParameter("pat_id1");
			stmt				= conn.createStatement();
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("SELECT patient_name,national_id_no,alt_id1_no,name_prefix,");
			sqlQuery.append("first_name,second_name,third_name,family_name,name_suffix,sex,to_char(date_of_birth,'dd/mm/rrrr') dateofbirth,");
			sqlQuery.append("b.ADDR1_LINE1 resi_addr_line1,b.ADDR1_LINE2 resi_addr_line2,b.ADDR1_LINE3 resi_addr_line3,");
			sqlQuery.append(" b.ADDR1_LINE4 resi_addr_line4,b.POSTAL1_CODE resi_postal_code,");
			sqlQuery.append(" b.COUNTRY1_CODE resi_country_code,contact1_no prn_tel_no,contact2_no ");
			sqlQuery.append(" orn_tel_no,alt_id1_type,email_id,nationality_code,TO_CHAR(alt_id1_exp_date,'dd/mm/rrrr') alt_id1_exp_date, ");
			sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),1) agey,"); 
			sqlQuery.append(" calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),2) agem, ");
			sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),3) aged ");
			sqlQuery.append(" FROM MP_PATIENT A, MP_PAT_ADDRESSES b WHERE A.patient_id ='"+patientid+"' AND A.PATIENT_ID = b.PATIENT_ID ");
			rset=stmt.executeQuery(sqlQuery.toString());
			if(rset!=null && rset.next()) 
			{
				String patientname		= checkForNull(rset.getString("patient_name"));
				String nationalid		= checkForNull(rset.getString("national_id_no"));
				String alternateid		= checkForNull(rset.getString("alt_id1_no"));
				String prefix			= checkForNull(rset.getString("name_prefix"));
				String firstname		= checkForNull(rset.getString("first_name"));	 
				String secondname		= checkForNull(rset.getString("second_name")); 
				String thirdname		= checkForNull(rset.getString("third_name"));	 
				String familyname		= checkForNull(rset.getString("family_name")); 
				String suffix			= checkForNull(rset.getString("name_suffix"));
				String gender			= checkForNull(rset.getString("sex"));
				String dateofbirth		= checkForNull(rset.getString("dateofbirth"));
				String agey				= checkForNull(rset.getString("agey"));
				String agem				= checkForNull(rset.getString("agem"));
				String aged				= checkForNull(rset.getString("aged"));
				String nationalitycode	= checkForNull(rset.getString("nationality_code"));
					   altid1expdate	= checkForNull(rset.getString("alt_id1_exp_date"));
				
%>
		<script>			
			
			parent.document.frames[1].document.forms[0].patient_id.value="<%=patientid%>";
			parent.document.frames[1].document.forms[0].patient_name.value="<%=patientname%>";
			parent.document.frames[1].document.forms[0].patient_name.readOnly=true;
			<%if(nationalid!=null) {%>
			parent.document.frames[1].document.forms[0].national_id_no.value="<%=nationalid%>";
			<% }
			else {%>
			parent.document.frames[1].document.forms[0].national_id_no.value='';
			<%}%>
			parent.document.frames[1].document.forms[0].national_id_no.readOnly=true;
			<%if(alternateid!=null) {%>
			parent.document.frames[1].document.forms[0].alt_id1_no.value="<%=alternateid%>";
			<%}
			else {%>
			parent.document.frames[1].document.forms[0].alt_id1_no.value='';
			<%}%>
			parent.document.frames[1].document.forms[0].alt_id1_no.readOnly=true;

			<%
			if(c_name_prefix_accept_yn.equals("Y"))
			{
			if(prefix!=null) {%>
			parent.document.frames[1].document.forms[0].name_prefix1.value="<%=prefix%>";
			
			<% }
			else {%>
			parent.document.frames[1].document.forms[0].name_prefix1.value='';
			
			<%}%>
			parent.document.frames[1].document.forms[0].name_prefix1.disabled=true;
			<% } %>

			<% if(c_first_name_accept_yn.equals("Y"))
			{
			if(firstname!=null) {%>
			parent.document.frames[1].document.forms[0].first_name.value="<%=firstname%>";
			<% }
			else {%>
			parent.document.frames[1].document.forms[0].first_name.value='';
			<%}%>
			parent.document.frames[1].document.forms[0].first_name.readOnly=true;
			<% } %>

			<% if(c_second_name_accept_yn.equals("Y"))
			{
			if(secondname!=null) {%>
			parent.document.frames[1].document.forms[0].second_name.value="<%=secondname%>";
			<% }
			else {%>
			parent.document.frames[1].document.forms[0].second_name.value='';
			<%}%>
			parent.document.frames[1].document.forms[0].second_name.readOnly=true;
			<% } %>

			<% if(c_third_name_accept_yn.equals("Y"))
			{
			if(thirdname!=null) {%>
			parent.document.frames[1].document.forms[0].third_name.value="<%=thirdname%>";
			<% }
			else {%>
			parent.document.frames[1].document.forms[0].third_name.value='';
			<%}%>
			parent.document.frames[1].document.forms[0].third_name.readOnly=true;
			<% } %>

			<%if(c_family_name_accept_yn.equals("Y"))
			{
			if(familyname!=null) {%>
			parent.document.frames[1].document.forms[0].family_name.value="<%=familyname%>";
			<% }
			else {%>
			parent.document.frames[1].document.forms[0].family_name.value='';
			<%}%>
			parent.document.frames[1].document.forms[0].family_name.readOnly=true;
			<% } %>

			<% if(c_name_suffix_accept_yn.equals("Y"))
			{
			if(suffix!=null) {%>
			parent.document.frames[1].document.forms[0].name_suffix1.value="<%=suffix%>";
		
			<% }
			else {%>
			parent.document.frames[1].document.forms[0].name_suffix1.value='';
		
			<%}%>
			parent.document.frames[1].document.forms[0].name_suffix1.disabled=true;
			<% } %>
			parent.document.frames[1].document.forms[0].sex.value="<%=gender%>";
		
			parent.document.frames[1].document.forms[0].sex.disabled=true;
			parent.document.frames[1].document.forms[0].date_of_birth.value="<%=dateofbirth%>";
			parent.document.frames[1].document.forms[0].date_of_birth.readOnly=true;
			
			parent.document.frames[1].document.getElementById("dob").disabled=true;
			
			parent.document.frames[1].document.forms[0].b_age.value="<%=agey%>";
			parent.document.frames[1].document.forms[0].b_age.readOnly=true;
			parent.document.frames[1].document.forms[0].b_months.value="<%=agem%>";
			parent.document.frames[1].document.forms[0].b_months.readOnly=true;
			parent.document.frames[1].document.forms[0].b_days.value="<%=aged%>";
			parent.document.frames[1].document.forms[0].b_days.readOnly=true;
			parent.document.frames[1].document.forms[0].nationality_code1.value="<%=nationalitycode%>";
			parent.document.frames[1].document.forms[0].nationality_code1.disabled = true;
			if("<%=altid1expdate%>" != "")
			
			if("<%=CA_Pat%>" == "Y" && parent.document.frames[1].document.getElementById("pref_adm_date"))
				parent.document.frames[1].document.getElementById("pref_adm_date").focus();	
			else if(parent.document.frames[1].document.getElementById("chief_complaint"))
				parent.document.frames[1].document.getElementById("chief_complaint").focus();	
	</script>
<%

		}
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
	}
	else if(step.equals("N")) 
	{
		String nationalid	=request.getParameter("nat_id");
		if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("select national_id_no from mp_patient");
		stmt2	= conn.createStatement();
		rs2		= stmt.executeQuery(sqlQuery.toString());
		java.util.Date date3	= rset.getDate("date_of_birth");
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/rrrr");

		while(rs2.next()) 
		{
			if(rs2.getString("national_id_no") !=null) 
			{
				String nnvalue	= rs2.getString("national_id_no");

				if(nnvalue.equals(nationalid)) 
				{
					if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
					sqlQuery.append("select patient_id,decode('"+localeName+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name,alt_id1_no,name_prefix,first_name,second_name,third_name,family_name,");
					sqlQuery.append("name_suffix,sex,date_of_birth,contact1_no prn_tel_no,contact2_no orn_tel_no,");
					sqlQuery.append(" email_id,nationality_code,to_char(alt_id1_exp_date,'dd/mm/rrrr') alt_id1_exp_date, ");
					sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),1) agey, ");
					sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),2) agem, ");
					sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),3) aged from mp_patient where national_id_no='"+nationalid+"' ");
					rset= stmt.executeQuery(sqlQuery.toString());
					if(rset !=null) 
					{
					rset.next();
					String patientid=rset.getString("patient_id");
					webbeans.op.PatientData patdata = new webbeans.op.PatientData();

					String chkst=checkForNull(patdata.CheckStatus(conn,patientid));
					

					if(chkst.equals("DECEASED")) 
					{
					%>
						<script>
							parent.document.frames[1].document.forms[0].alt_id1_no.value="";
							alert(getMessage("PAT_DECEASED_NOT_ALLOWED","MP"));
							parent.document.frames[1].document.forms[0].alt_id1_no.focus();
						</script>
					<%
					}
					else if(chkst.equals("SUSPENDED"))
					{
					%>
					<script >

						var err_age2 = getMessage( "PAT_SUSPENDED_NOT_ALLOWED","MP" ) ;
						parent.document.frames[1].document.forms[0].alt_id1_no.value="";
						alert(err_age2);
						parent.document.frames[1].document.forms[0].alt_id1_no.focus();
					</script>
			<%
				}
				else if(chkst.equals("INACTIVE")) 
				{
			%>
					<script >
						parent.document.frames[1].document.forms[0].alt_id1_no.value="";
						var err_age3 = getMessage( "PATIENT_INACTIVE","MP" ) ;
						alert(err_age3);
						parent.document.frames[1].document.forms[0].alt_id1_no.focus();
					</script>
			<%
				}
				else 
				{
					if(patientid != null )
					{
						String patientname		= checkForNull(rset.getString("patient_name"));	
						String altid			= checkForNull(rset.getString("alt_id1_no"));																					
						String namepref			= checkForNull(rset.getString("name_prefix"));
						String firstname		= checkForNull(rset.getString("first_name"));
						String secondname		= checkForNull(rset.getString("second_name"));
						String thirdname		= checkForNull(rset.getString ("third_name"));
						String familyname		= checkForNull(rset.getString("family_name"));
						String namesuffix		= checkForNull(rset.getString("name_suffix"));
						String gender			= checkForNull(rset.getString("sex"));
						String nationalitycode	= checkForNull(rset.getString("nationality_code"));
						altid1expdate			= checkForNull(rset.getString("alt_id1_exp_date"));
						date3	= rset.getDate("date_of_birth");
						//SimpleDateFormat 
						formatter2 = new SimpleDateFormat("dd/MM/rrrr");
						String dateofbirth		= formatter2.format(date3);
							   formatter2		= null;

						String agey				= checkForNull(rset.getString("agey"));
						String agem				= checkForNull(rset.getString("agem"));
						String aged				= checkForNull(rset.getString("aged"));
%>
				<script>
					parent.document.frames[1].document.forms[0].patient_id.value="<%=patientid%>";
					parent.document.frames[1].document.forms[0].patient_id.readOnly=true;
					parent.document.frames[1].document.forms[0].patient_name.value="<%=patientname%>";
					parent.document.frames[1].document.forms[0].patient_name.readOnly=true;
					parent.document.frames[1].document.forms[0].national_id_no.readOnly=true;
					<% if(altid!=null) {%>
					parent.document.frames[1].document.forms[0].alt_id1_no.value="<%=altid%>";
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].alt_id1_no.value='';
					<% }%>
					parent.document.frames[1].document.forms[0].alt_id1_no.readOnly=true;

					<%
					if(c_name_prefix_accept_yn.equals("Y"))
					{
					 if(namepref!=null) {%>
					parent.document.frames[1].document.forms[0].name_prefix1.value="<%=namepref%>"; 
	 
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].name_prefix1.value='';
				<%}%>
					parent.document.frames[1].document.forms[0].name_prefix1.disabled=true;
					<% } %>

					<% if(c_first_name_accept_yn.equals("Y"))
					{
					if(firstname!=null) {%>
					parent.document.frames[1].document.forms[0].first_name.value="<%=firstname%>";
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].first_name.value='';
					<%}%>
					parent.document.frames[1].document.forms[0].first_name.readOnly=true;
					<% } %>

					<% if(c_second_name_accept_yn.equals("Y"))
					{
					if(secondname!=null) {%>
					parent.document.frames[1].document.forms[0].second_name.value="<%=secondname%>";
														<% }
					else {%>
					parent.document.frames[1].document.forms[0].second_name.value='';
					<%}%>
					parent.document.frames[1].document.forms[0].second_name.readOnly=true;
					<% } %>

					<% if(c_third_name_accept_yn.equals("Y"))
					{
					if(thirdname!=null) {%>
					parent.document.frames[1].document.forms[0].third_name.value="<%=thirdname%>";
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].third_name.value='';
					<%}%>
					parent.document.frames[1].document.forms[0].third_name.readOnly=true;
					<% } %>

					<%if(c_family_name_accept_yn.equals("Y"))
					{
					if(familyname!=null) {%>
					parent.document.frames[1].document.forms[0].family_name.value="<%=familyname%>";
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].family_name.value='';
					<%}%>
					parent.document.frames[1].document.forms[0].family_name.readOnly=true;
					<% } %>

					<% if(c_name_suffix_accept_yn.equals("Y"))
					{
					if(namesuffix!=null) {%>
					
					parent.document.frames[1].document.forms[0].name_suffix1.value="<%=namesuffix%>";
		
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].name_suffix1.disabled=true;
					<%}%>
					parent.document.frames[1].document.forms[0].name_suffix1.disabled=true;
					<% } %>

					parent.document.frames[1].document.forms[0].sex.value="<%=gender%>";
					parent.document.frames[1].document.forms[0].sex.disabled=true;
					parent.document.frames[1].document.forms[0].date_of_birth.value="<%=dateofbirth%>";
					parent.document.frames[1].document.forms[0].date_of_birth.readOnly=true;
					parent.document.frames[1].document.getElementById("dob").disabled=true;
		
					parent.document.frames[1].document.forms[0].b_age.value="<%=agey%>";
					parent.document.frames[1].document.forms[0].b_age.readOnly=true;
					parent.document.frames[1].document.forms[0].b_months.value="<%=agem%>";
					parent.document.frames[1].document.forms[0].b_months.readOnly=true;
					parent.document.frames[1].document.forms[0].b_days.value="<%=aged%>";
					parent.document.frames[1].document.forms[0].b_days.readOnly=true;

					parent.document.frames[1].document.forms[0].nationality_code1.value="<%=nationalitycode%>"
					parent.document.frames[1].document.forms[0].nationality_code1.disabled = true;
					if("<%=altid1expdate%>" != "")
							<%}%>
		</script>
<%
				}  // end of else
			} // end of rset	 
		}
		}
		}	// end of while
	}
	if(rset != null) rset.close();
	if(rs2 != null) rs2.close();
	if(stmt != null) stmt.close();
	if(stmt2 != null) stmt2.close();
	else if(step.equals("A")) 
	{
		String alternateid	= request.getParameter("alt_id");
		stmt	= conn.createStatement();
		if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("select count(*) as total from mp_patient where alt_id1_no='"+alternateid+"' ");
		rset	= stmt.executeQuery(sqlQuery.toString());
		if(rset != null && rset.next())
		c		= rset.getInt("total");
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		if(c>1) 
		{
		%>
			<script>
				alert(getMessage("MANY_ALT_ID_FOUND","IP"));
				parent.document.frames[1].document.forms[0].alt_id1_no.value='';
				parent.document.frames[1].document.forms[0].alt_id1_no.focus();
			</script>
		<%
		}
		else if(c==0) 
		{
		%>
			<script>
				alert(getMessage("NO_PAT_FOR_ALT_ID","IP"));
				parent.document.frames[1].document.forms[0].alt_id1_no.value='';
				parent.document.frames[1].document.forms[0].alt_id1_no.focus();
			</script>
		<%
		}
		else if(c==1) 
		{
			stmt	= conn.createStatement();
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select patient_id,decode('"+localeName+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name,national_id_no,name_prefix,first_name,second_name,");
			sqlQuery.append("third_name,family_name,name_suffix,sex,to_char(date_of_birth,'dd/mm/rrrr') dateofbirth, contact1_no prn_tel_no,contact2_no orn_tel_no,email_id, ");
			sqlQuery.append(" nationality_code, TO_CHAR(alt_id1_exp_date,'dd/mm/rrrr') alt_id1_exp_date, ");
			sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),1) agey,"); sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),2) agem,"); sqlQuery.append("calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),3) aged from mp_patient where ");
			sqlQuery.append("alt_id1_no='"+alternateid+"' ");
			rset	= stmt.executeQuery(sqlQuery.toString());
			if(rset != null) 
			{
				rset.next();
				String patientid	= rset.getString("patient_id");

				webbeans.op.PatientData patdata = new webbeans.op.PatientData();

				String chkst		= patdata.CheckStatus(conn,patientid);

				if(chkst.equals("DECEASED")) 
				{
				%>
					<script>
						parent.document.frames[1].document.forms[0].alt_id1_no.value="";
						alert(getMessage("PAT_DECEASED_NOT_ALLOWED","MP"));
						parent.document.frames[1].document.forms[0].alt_id1_no.focus();
					</script>
				<%
				}
				else if(chkst.equals("SUSPENDED"))
				{
				%>
					<script >

						var err_age2 = getMessage( "PAT_SUSPENDED_NOT_ALLOWED","MP" ) ;
						parent.document.frames[1].document.forms[0].alt_id1_no.value="";
						alert(err_age2);
						parent.document.frames[1].document.forms[0].alt_id1_no.focus();
					</script>
			<%
				}
				else if(chkst.equals("INACTIVE")) 
				{
			%>
					<script >
						parent.document.frames[1].document.forms[0].alt_id1_no.value="";
						var err_age3 = getMessage( "PATIENT_INACTIVE","MP" ) ;
						alert(err_age3);
						parent.document.frames[1].document.forms[0].alt_id1_no.focus();
					</script>
			<%
				}
				else 
				{
					String patientname		= checkForNull(rset.getString("patient_name"));
					String natid			= checkForNull(rset.getString("national_id_no"));		
					String namepref			= checkForNull(rset.getString("name_prefix"));
					String firstname		= checkForNull(rset.getString("first_name"));
					String secondname		= checkForNull(rset.getString("second_name"));
					String thirdname		= checkForNull(rset.getString("third_name"));
					String familyname		= checkForNull(rset.getString("family_name"));
					String namesuffix		= checkForNull(rset.getString("name_suffix"));
					String gender			= checkForNull(rset.getString("sex"));
					String nationalitycode	= checkForNull(rset.getString("nationality_code"));
					altid1expdate			= checkForNull(rset.getString("alt_id1_exp_date"));
					String dateofbirth1		= checkForNull(rset.getString("dateofbirth"));
					String agey				= checkForNull(rset.getString("agey"));
					String agem				= checkForNull(rset.getString("agem"));
					String aged				= checkForNull(rset.getString("aged"));

	%>
			<script>
					parent.document.frames[1].document.forms[0].patient_id.value="<%=patientid%>";
					parent.document.frames[1].document.forms[0].patient_id.readOnly=true;
					parent.document.frames[1].document.forms[0].patient_name.value="<%=patientname%>";
					parent.document.frames[1].document.forms[0].patient_name.readOnly=true;
					parent.document.frames[1].document.forms[0].national_id_no.value="<%=natid%>";
					parent.document.frames[1].document.forms[0].national_id_no.readOnly=true;
					parent.document.frames[1].document.forms[0].alt_id1_no.readOnly=true;
					<%
					if(c_name_prefix_accept_yn.equals("Y"))
					{
					if(namepref!=null) {%>
					parent.document.frames[1].document.forms[0].name_prefix1.value="<%=namepref%>";
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].name_prefix1.value='';
					<%}%>
					parent.document.frames[1].document.forms[0].name_prefix1.disabled=true;
					<% } %>

					<% if(c_first_name_accept_yn.equals("Y"))
					{
					if(firstname!=null) {%>
					parent.document.frames[1].document.forms[0].first_name.value="<%=firstname%>";
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].first_name.value='';
					<%}%>
					parent.document.frames[1].document.forms[0].first_name.readOnly=true;

					<% } %>

					<% if(c_second_name_accept_yn.equals("Y"))
					{
					if(secondname!=null) {%>
					parent.document.frames[1].document.forms[0].second_name.value="<%=secondname%>";
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].second_name.value='';
					<%}%>
					parent.document.frames[1].document.forms[0].second_name.readOnly=true;
					<% } %>

					<% if(c_third_name_accept_yn.equals("Y"))
					{
					if(thirdname!=null) {%>
					parent.document.frames[1].document.forms[0].third_name.value="<%=thirdname%>";
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].third_name.value='';
					<%}%>
					parent.document.frames[1].document.forms[0].third_name.readOnly=true;
					<% } %>


					<%if(c_family_name_accept_yn.equals("Y"))
					{
					if(familyname!=null) {%>
					parent.document.frames[1].document.forms[0].family_name.value="<%=familyname%>";
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].family_name.value='';
					<%}%>
					parent.document.frames[1].document.forms[0].family_name.readOnly=true;
					<% }%>

					<% if(c_name_suffix_accept_yn.equals("Y"))
					{
					if(namesuffix!=null) {%>
					parent.document.frames[1].document.forms[0].name_suffix1.value="<%=namesuffix%>";
					<% }
					else {%>
					parent.document.frames[1].document.forms[0].name_suffix1.disabled=true;
					<%}%>
					parent.document.frames[1].document.forms[0].name_suffix1.disabled=true;
					<% } %>

					parent.document.frames[1].document.forms[0].sex.value="<%=gender%>";
					parent.document.frames[1].document.forms[0].sex.disabled=true;
					parent.document.frames[1].document.forms[0].date_of_birth.value="<%=dateofbirth1%>";
					parent.document.frames[1].document.forms[0].date_of_birth.readOnly=true;
					
					parent.document.frames[1].document.getElementById("dob").disabled=true;
		
					parent.document.frames[1].document.forms[0].b_age.value="<%=agey%>";
					parent.document.frames[1].document.forms[0].b_age.readOnly=true;
					parent.document.frames[1].document.forms[0].b_months.value="<%=agem%>";
					parent.document.frames[1].document.forms[0].b_months.readOnly=true;
					parent.document.frames[1].document.forms[0].b_days.value="<%=aged%>";
					parent.document.frames[1].document.forms[0].b_days.readOnly=true;
					parent.document.frames[1].document.forms[0].nationality_code1.value="<%=nationalitycode%>";
					parent.document.frames[1].document.forms[0].nationality_code1.disabled = true;
					parent.document.frames[1].document.forms[0].alt_id1_exp_date.value = "<%=altid1expdate%>";	
					if("<%=altid1expdate%>" != "")
					parent.document.frames[1].document.getElementById("alt_id_exp_dt1").innerHTML=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"&nbsp;&nbsp;";
					parent.document.frames[1].document.getElementById("alt_id_exp_dt1").innerHTML="<b><%=altid1expdate%></b>";
			<%}%>
				</script>
<%
			} // e of rset2
		}
	}
if(rset != null) rset.close();
if(stmt != null) stmt.close();
}catch(Exception e) {//out.println(e.toString());
e.printStackTrace();
}
	finally
	{
		try{
		if(rset != null) rset.close();
		if(rs2 != null)	rs2.close();
		if(stmt2 != null) stmt2.close();
		if(stmt != null) stmt.close();
		ConnectionManager.returnConnection(conn,request);
		}catch(Exception ee) {
			//out.println("Error while Closing the connections :"+ee.toString());
			ee.printStackTrace();
			}
	}
%>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

