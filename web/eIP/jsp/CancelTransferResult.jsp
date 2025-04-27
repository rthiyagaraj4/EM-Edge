<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ include file="ForSplChars.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;

	String facility_id = (String)session.getValue("facility_id");
	if( facility_id == null) facility_id="";
	String login_user = (String)session.getValue("login_user");
	if( login_user == null) login_user="";
	String responsibility_id = (String)session.getValue("responsibility_id");
	if( responsibility_id == null) responsibility_id="";
	
	String oper_stn_id = "";
try{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
%>
<html>
	<head>
	<%
			String call_function =request.getParameter("param");
			if( call_function == null) call_function="";
	%>
		
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>

			function resetValues()
			{					
					form1 =  parent.frames[1].document.forms[0];
					form1.nursing_unit_lookup.disabled = false;
					form1.specialty_lookup.disabled = false;
					form1.pract_id_search.disabled = false;
					form1.from_date.readOnly = false;
					form1.to_date.readOnly = false;
					form1.encounter_id.readOnly = false;
					form1.patient_id.readOnly = false;
					form1.patient_search.disabled = false;
					form1.gender.disabled = false;
					form1.soundex.disabled = false;
					form1.search.disabled = false;
					form1.clear.disabled = false;
			}

			function closeWin(enc,patid,changefunc)
			{
				showModalCurEnc(enc,patid,changefunc);
			}
			var locn;
			
			async function showModal(enc,patid,practid,IPval,sex,pract_count,srlNo,country)
			{	
				var chk_jsp=document.forms[0].jsp_name.value;
				var tot_count=document.forms[0].total_count.value;
				if( document.forms[0].modal.value != 'yes')
				    {						
						var jsp_name=document.forms[0].jsp_name.value;
						var win_height=document.forms[0].win_height.value;
						if(win_height == "") win_height="33.4";
						var dialogTop=document.forms[0].dialogTop.value;
						if(dialogTop == "") dialogTop="65";
						var win_width=document.forms[0].win_width.value;
						if(win_width == "") win_width="40";							
						var model_window=document.forms[0].model_window.value;
						if( model_window == "") model_window ="";						
						if( model_window == 'NO')
							{														parent.parent.frames[1].document.location.href="../../eIP/jsp/"+jsp_name+"?encounterId="+enc+"&patientId="+patid+"&Practitioner_Id="+escape(practid)+"&callfrom=IP&call_function=<%=call_function%>&srlno="+srlNo+"&country="+country+"&Sex="+sex;
							}
							else if( model_window == 'N')
							{
							parent.frames[3].document.location.href="../../eIP/jsp/"+jsp_name+"?encounterId="+enc+"&patientId="+patid+"&Practitioner_Id="+escape(practid)+"&callfrom=IP&call_function=<%=call_function%>&srlno="+srlNo+"&country="+country+"&Sex="+sex;
							}
							else 
							{												
								var retVal = 	new String();							
								var dialogHeight= win_height;
								var dialogWidth	= "49.6";
								var dialogTop = dialogTop;							
								var center = "1" ;
								var status="no";							
								var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
								var arguments	= "" ;
								retVal = 	await window.showModalDialog("../../eIP/jsp/"+jsp_name+"?location_code="+IPval+"&encounterId="+enc+"&patientId="+patid+"&Practitioner_Id="+escape(practid)+"&callfrom=IP&call_function=<%=call_function%>&srlno="+srlNo+"&country="+country+"&Sex="+sex+"&mode=modal",arguments,features);							
						}
						parent.frames[2].document.location.reload();
				}
			}
			async function showModalCurEnc(enc,patid,changefunc)
			{				
				var call_function = document.forms[0].call_function.value;
				var jsp_name="CurrentEncounterMain.jsp";
				var win_height=document.forms[0].win_height.value;
				if(win_height == "") win_height="33.4";
				var win_width=document.forms[0].win_width.value;
				if(win_width == "") win_width="49.8";
				var retVal = 	new String();
				var dialogHeight= win_height ;
				var dialogWidth	= win_width ;
				var dialogTop = "65" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				retVal = await window.showModalDialog("../../eIP/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid,arguments,features);
				if(retVal!=null && retVal!='')
				parent.frames[2].document.location.reload();
			}
		</script>

		<%
			try{
			String nurs_unit_code	="";
			StringBuffer where_criteria = new StringBuffer();
			String sql = "";
			String class_val = "QRYEVEN";
			String whereClause = request.getParameter("whereclause");
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
			
			String soundex_type			=request.getParameter("soundex");
			String no_of_days			=request.getParameter("no_of_days");
			if(no_of_days == null)   no_of_days = "";

			String nursing_unit_code	="";
			nursing_unit_code=request.getParameter("nursing_unit");
			if( nursing_unit_code == null) nursing_unit_code="";
			String speciality_code		=request.getParameter("Splcode");
			String encounter_id			=request.getParameter("encounter_id");
			String practitioner_id			=request.getParameter("practid");
			String from_date					=request.getParameter("from_date");
			String to_date						=request.getParameter("to_date");
			String patient_id					=request.getParameter("patient_id");
			String gender					=request.getParameter("gender");
			String name_prefix				=request.getParameter("name_prefix");
			String name_suffix				=request.getParameter("name_suffix");
			String first_name				=request.getParameter("first_name");
			String second_name				=request.getParameter("second_name");
			String third_name				=request.getParameter("third_name");
			String family_name				=request.getParameter("family_name");

			String strSerialNumber = "";	
			String strCountry = "";
			String patient_name	="";
			String nursing_unit_short_desc="";
			String bed_no="";			
			String specialty_short_desc="";
			String practitioner_name="";
			String prev_val="";
			String prev_val2="";
			String Sex="";
			String admission_date_time="";
			String discharge_date_time= "";		

				if(name_prefix == null) name_prefix = "";
				if(name_suffix == null) name_suffix = "";
				if(nursing_unit_code == null) nursing_unit_code = "";
				if(speciality_code == null) speciality_code = "";
				if(practitioner_id == null) practitioner_id = "";
				name_prefix=singleToDoubleQuotes(name_prefix);
				name_suffix=singleToDoubleQuotes(name_suffix);
				nursing_unit_code=singleToDoubleQuotes(nursing_unit_code);
				speciality_code=singleToDoubleQuotes(speciality_code);
				practitioner_id=singleToDoubleQuotes(practitioner_id);				
	
			String jsp_name =request.getParameter("jsp_name");
			if( jsp_name == null) jsp_name="";
			String window_styl=request.getParameter("window_styl");
			if( window_styl == null) window_styl="";
			String close_yn	=request.getParameter("close_yn");
			if( close_yn == null) close_yn="";
			String win_top =request.getParameter("win_top");
			if( win_top == null) win_top="";
			String win_height =request.getParameter("win_height");
			if(win_height ==null) win_height="";

			String dialogTop =request.getParameter("dialogTop");
			if(dialogTop ==null) dialogTop="";

			String win_width =request.getParameter("win_width");
			if( win_width == null) win_width="";

			String modal=request.getParameter("modal");
			if(modal == null) modal="";		

			String model_window=request.getParameter("model_window");
			if( model_window == null) model_window="";			

			String p_practitioner_id=request.getParameter("practitioner_id");
			if( p_practitioner_id == null) p_practitioner_id="";

			String call_func=request.getParameter("call_function");
			if(call_func == null) call_func="";
			
			String count_practitioner = "";
			
	%>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='iplookupqueryresult' id='iplookupqueryresult'>
			<%
				 

				
				
				String operSql =" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facility_id+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+login_user+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ";
				
	 rs = stmt.executeQuery(operSql);
				
    while(rs.next())
    {
		  oper_stn_id = rs.getString("OPER_STN_ID");
	}
if(oper_stn_id == null) oper_stn_id = "";




				if(whereClause==null)
				{
					//facility_id
					where_criteria.append(" where  A.facility_id ='"+facility_id+"'");
					//nursing_unit_code	
					if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
					where_criteria.append(" and A.to_nursing_unit ='"+nursing_unit_code+"' ");
					else
							where_criteria.append(" and (A.to_nursing_unit in (Select n.nursing_unit_code from ip_nursing_unit n, am_os_user_locn_access_vw b where n.facility_id='"+facility_id+"' and n.facility_id=b.facility_id and n.nursing_unit_code=b.locn_code and n.locn_type=b.locn_type and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"')  or A.to_nursing_unit is null)");
					//speciality_code
					if(speciality_code!=null && !speciality_code.equals(""))
					where_criteria.append(" and A.to_specialty_code='"+speciality_code+"' ");
					//practitioner_id
					if(p_practitioner_id!=null && !p_practitioner_id.equals(""))
					where_criteria.append(" and A.to_practitioner_id='"+practitioner_id+"' ");
					//from_date
					if(from_date!=null && !from_date.equals(""))
					where_criteria.append(" and trunc(A.trn_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
					//to_date
					if(to_date!=null && !to_date.equals(""))
					where_criteria.append(" and trunc(A.trn_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
					//patient_id
					if(patient_id!=null && !patient_id.equals(""))
					where_criteria.append(" and A.patient_id like '"+patient_id+"%' ");
					//encounter_id
					if(encounter_id != null && !encounter_id.equals(""))
					where_criteria.append(" and A.encounter_id='"+encounter_id+"' ");
					//gender
					if(gender!=null && !gender.equals(""))
						where_criteria.append(" and B.sex='"+gender+"' ");			
					
					//name_prefix
					if(name_prefix!=null && !name_prefix.equals(""))
						where_criteria.append(" and B.name_prefix='"+name_prefix+"' ");

					//name_suffix
					if(name_suffix!=null && !name_suffix.equals(""))
						where_criteria.append(" and B.name_suffix='"+name_suffix+"' ");


	if(soundex_type.equals("E"))
				{
                
				//first_name
                    if(first_name!=null && !first_name.equals(""))
                        where_criteria.append(" and upper(ethnic_soundex(B.first_name)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");

                    //second_name
                    if(second_name!=null && !second_name.equals(""))
                        where_criteria.append(" and upper(ethnic_soundex(B.second_name)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");

                    //third_name
                    if(third_name!=null && !third_name.equals(""))
                       where_criteria.append(" and upper(ethnic_soundex(B.third_name)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");

                    //family_name
                    if(family_name!=null && !family_name.equals(""))
                       where_criteria.append(" and upper(ethnic_soundex(B.family_name)) like upper(ethnic_soundex('" +family_name+"')) || '%' ");
				}
				else
				{
                    //first_name
                    if(first_name!=null && !first_name.equals(""))
                       where_criteria.append(" and upper(soundex(B.first_name)) like upper(soundex('" +first_name +"')) || '%' ");

                    //second_name
                    if(second_name!=null && !second_name.equals(""))
                        where_criteria.append(" and upper(soundex(B.second_name)) like upper(soundex('" + second_name +"')) || '%' ");

                    //third_name
                    if(third_name!=null && !third_name.equals(""))
                        where_criteria.append(" and upper(soundex(B.third_name)) like upper(soundex('"+ third_name+"')) || '%' ");

                    //family_name
                    if(family_name!=null && !family_name.equals(""))
                        where_criteria.append(" and upper(soundex(B.family_name)) like upper(soundex('" +family_name+"')) || '%' ");
				}

				}
				else
				{
					where_criteria.append(whereClause);
				}
				int start = 0 ;
				int end = 0 ;
				int i=1;

				if ( from == null )
					start = 1 ;
				else
					start = Integer.parseInt( from ) ;

				if ( to == null )
				  	end = 9 ;
				else
					end = Integer.parseInt( to ) ;
			
				//sql = "SELECT COUNT(*) FROM ip_adt_trn A,MP_PATIENT B "+where_criteria.toString()+" and A.patient_id=b.patient_id and (A.encounter_id,A.srl_no) IN (SELECT X.encounter_id ,MAX(X.srl_no) FROM IP_ADT_TRN X, ip_open_encounter Y WHERE X.Facility_id = '"+facility_id+"' AND X.Trn_type = 'T' AND X.Facility_id = Y.Facility_id AND X.Encounter_id = Y.Encounter_id GROUP BY X.encounter_id ) AND A.Trn_type = 'T' and A.adt_trn_status != '9' and A.encounter_id not in (select encounter_id from ip_discharge_advice where facility_id = '"+facility_id+"' and dis_adv_status = '0') and A.encounter_id not in (select encounter_id from ip_bed_booking WHERE facility_id = '"+facility_id+"' and BOOKING_TYPE='T' AND booking_status='0' AND BLOCKED_UNTIL_DATE_TIME > SYSDATE) " ;
				
				sql = "SELECT count(*) FROM ip_adt_trn A, MP_PATIENT B, IP_NURSING_UNIT C, AM_PRACTITIONER D, AM_SPECIALITY E, mp_country F, IP_OPEN_ENCOUNTER G "+where_criteria.toString()+" and A.FACILITY_ID = G.FACILITY_ID AND A.ENCOUNTER_ID = G.ENCOUNTER_ID AND  A.patient_id=b.patient_id and A.facility_id=C.facility_id and A.to_nursing_unit = C.nursing_unit_code and A.to_practitioner_id = D.practitioner_id (+) and A.to_specialty_code = E.speciality_code  (+)  and (A.encounter_id,A.srl_no) IN (SELECT X.encounter_id ,MAX(X.srl_no) FROM IP_ADT_TRN X, ip_open_encounter Y WHERE X.Facility_id = '"+facility_id+"' AND X.Trn_type = 'T' AND X.Facility_id = Y.Facility_id AND X.Encounter_id = Y.Encounter_id GROUP BY X.encounter_id ) AND A.Trn_type = 'T' AND B.NATIONALITY_CODE = F.country_code and nvl(A.adt_trn_status,'x') !='9' AND A.encounter_id not in (select encounter_id from ip_discharge_advice T where facility_id =  '"+facility_id+"' and t.encounter_id = a.encounter_id and dis_adv_status = '0' ) and A.encounter_id not in (select encounter_id from  ip_bed_booking U WHERE facility_id = '"+facility_id+"' and BOOKING_TYPE='T' AND booking_status='0'  and U.ENCOUNTER_ID = A.ENCOUNTER_ID AND BLOCKED_UNTIL_DATE_TIME > SYSDATE) group by to_char(A.trn_date_time,'dd/mm/rrrr hh24:mi') , A.trn_date_time, A.encounter_id, A.patient_id, B.patient_name, B.sex, A.to_nursing_unit, C.short_desc , A.to_practitioner_id , D.practitioner_name , E.short_desc , A.to_bed_no,F.SHORT_NAME";
				rs = stmt.executeQuery(sql);
				int maxRecord=0;
				if(rs.next())
				{
					maxRecord = rs.getInt(1);
				}
				if(stmt!=null)	stmt.close();
				if(rs!=null)		rs.close();
		
				if(maxRecord == 0)
				{
				%>
					<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
					resetValues();
					</script>
				<%
					return;
				}
		
				//sql = "SELECT to_char(A.trn_date_time,'dd/mm/rrrr hh24:mi') trn_date_time, A.trn_date_time datetime,A.encounter_id, A.patient_id, B.patient_name, B.sex, A.to_nursing_unit, C.short_desc to_nursing_unit_short_desc , A.to_practitioner_id , D.practitioner_name practitioner_name, E.short_desc to_specialty_short_desc, A.to_bed_no ,A.srl_no ,F.SHORT_NAME countryname FROM ip_adt_trn A,MP_PATIENT B, IP_NURSING_UNIT C,AM_PRACTITIONER D,AM_SPECIALITY E, mp_country F   "+where_criteria+" and A.patient_id=b.patient_id and A.facility_id=C.facility_id and A.to_nursing_unit = C.nursing_unit_code and A.to_practitioner_id = D.practitioner_id (+) and A.to_specialty_code = E.speciality_code (+) and (A.encounter_id,A.srl_no) IN (SELECT X.encounter_id ,MAX(X.srl_no) FROM IP_ADT_TRN X, ip_open_encounter Y WHERE X.Facility_id = '"+facility_id+"' AND X.Trn_type = 'T' AND X.Facility_id = Y.Facility_id AND X.Encounter_id = Y.Encounter_id GROUP BY X.encounter_id ) AND A.Trn_type = 'T'   AND B.NATIONALITY_CODE = F.country_code    and A.adt_trn_status !='9' and A.encounter_id not in (select encounter_id from ip_discharge_advice where facility_id = '"+facility_id+"' and dis_adv_status = '0') and A.encounter_id not in (select encounter_id from ip_bed_booking WHERE facility_id = '"+facility_id+"' and BOOKING_TYPE='T' AND booking_status='0' AND BLOCKED_UNTIL_DATE_TIME > SYSDATE) Order by datetime desc ";

				sql = "SELECT to_char(A.trn_date_time,'dd/mm/rrrr hh24:mi') trn_date_time, A.trn_date_time datetime, A.encounter_id, A.patient_id, decode('"+localeName+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, B.sex, A.to_nursing_unit, C.short_desc to_nursing_unit_short_desc , A.to_practitioner_id , D.practitioner_name practitioner_name, E.short_desc to_specialty_short_desc, A.to_bed_no, max(srl_no) srl_no, F.SHORT_NAME countryname FROM ip_adt_trn A, MP_PATIENT B, IP_NURSING_UNIT C, AM_PRACTITIONER D, AM_SPECIALITY E, mp_country F, IP_OPEN_ENCOUNTER G "+where_criteria.toString()+" and A.FACILITY_ID = G.FACILITY_ID AND A.ENCOUNTER_ID = G.ENCOUNTER_ID AND  A.patient_id=b.patient_id and A.facility_id=C.facility_id and A.to_nursing_unit = C.nursing_unit_code and A.to_practitioner_id = D.practitioner_id (+) and A.to_specialty_code = E.speciality_code  (+)  and (A.encounter_id,A.srl_no) IN (SELECT X.encounter_id ,MAX(X.srl_no) FROM IP_ADT_TRN X, ip_open_encounter Y WHERE X.Facility_id = '"+facility_id+"' AND X.Trn_type = 'T' AND X.Facility_id = Y.Facility_id AND X.Encounter_id = Y.Encounter_id GROUP BY X.encounter_id ) AND A.Trn_type = 'T' AND B.NATIONALITY_CODE = F.country_code and nvl(A.adt_trn_status,'x') !='9' AND A.encounter_id not in (select encounter_id from ip_discharge_advice T where facility_id =  '"+facility_id+"' and t.encounter_id = a.encounter_id and dis_adv_status = '0' ) and A.encounter_id not in (select encounter_id from  ip_bed_booking U WHERE facility_id = '"+facility_id+"' and BOOKING_TYPE='T' AND booking_status='0' and U.ENCOUNTER_ID = A.ENCOUNTER_ID AND BLOCKED_UNTIL_DATE_TIME > SYSDATE) group by to_char(A.trn_date_time,'dd/mm/rrrr hh24:mi') , A.trn_date_time, A.encounter_id, A.patient_id, B.patient_name, B.sex, A.to_nursing_unit, C.short_desc , A.to_practitioner_id , D.practitioner_name , E.short_desc , A.to_bed_no,F.SHORT_NAME";
			  
				stmt = con.createStatement();

				rs= stmt. executeQuery(sql);
				
				if (( !(start <= 1) ) || ( !( (start+9) > maxRecord ) ))
				{
					out.println("<p><table align='right'><tr><td>");
					if ( !(start <= 1) )
						out.println("<A HREF='../jsp/CancelTransferResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start-9)+"&to="+(end-9)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					if ( !( (start+9) > maxRecord ) )
						out.println("<A HREF='../jsp/CancelTransferResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start+9)+"&to="+(end+9)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						out.println("</td></tr></table></p>");
						out.println("<br><br>");	
				}
						out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
						out.println("<tr>");
						out.println("<th>&nbsp;</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransactionDateTime.label","ip_labels")+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"</th>");
						out.println("</tr>");
				if(rs!=null)
					{
						if ( start != 1 )
						for( int j=1; j<start; i++,j++ )
						{
						rs.next() ;
						}						
						while ( rs!=null && rs.next() && i<=end ) 
						{							
														
							admission_date_time=rs.getString("trn_date_time");
							if(admission_date_time == null) admission_date_time="&nbsp;";
							
							specialty_short_desc=rs.getString("To_specialty_short_desc");
							if(specialty_short_desc == null) specialty_short_desc="&nbsp;";

							encounter_id=rs.getString("encounter_id");
							if(encounter_id == null) encounter_id="";

							strSerialNumber = rs.getString("srl_no");
							if(strSerialNumber == null)strSerialNumber="";
							
							
							strCountry = rs.getString("countryname");
							if(strCountry == null )strCountry = "";

							Sex =rs.getString("sex");
							if( Sex == null )Sex="";

							patient_id = rs.getString("patient_id");
							if( patient_id == null) patient_id="";

							patient_name=rs.getString("patient_name");
							if(patient_name == null) patient_name="&nbsp;";

							nurs_unit_code =rs.getString("to_nursing_unit");
							if( nurs_unit_code == null) nurs_unit_code="";
							nursing_unit_short_desc=rs.getString("to_nursing_unit_short_desc");
							if(nursing_unit_short_desc== null) nursing_unit_short_desc="&nbsp;";

							bed_no = rs.getString("to_bed_no");
							if( bed_no == null) bed_no="&nbsp;";

							practitioner_id=rs.getString("to_practitioner_id");
							if(practitioner_id == null) practitioner_id="";

							practitioner_name=rs.getString("practitioner_name");
							if(practitioner_name == null) practitioner_name="";
						
							if(class_val.equals("QRYEVEN"))
								class_val = "QRYODD";
							else
								class_val = "QRYEVEN";

							out.println("<tr>");

							if( ! (jsp_name.equals("") && modal.equals("") ) )
							{
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									out.println("<td class='CAGROUPHEADING' colspan='8' align='left'>"+specialty_short_desc+"/"+practitioner_name+"</td></tr><tr>");
								}
								out.println("<td class='"+class_val+"' nowrap> ");									
								out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','N')\">");
								out.print("+</a></td>" );
								out.println("<td class='"+class_val+"' nowrap>"+admission_date_time+"</td>");
								out.println("<td class='"+class_val+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+count_practitioner+"','"+strSerialNumber+"','"+strCountry+"')\">"+encounter_id+"</a></td>");						
							}
							else
							{
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									out.println("<td class='CAGROUPHEADING' colspan='8' align='left'>"+specialty_short_desc+"/"+practitioner_name+"</td></tr><tr>");
								}
						
								out.println("<td nowrap class='"+class_val+"'> ");
								String changeCallFunc = "";
								if( !no_of_days.equals("") && discharge_date_time != "&nbsp;")
									changeCallFunc = "Y";
								else
									changeCallFunc = "N";
													
								out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','"+changeCallFunc+"')\">");									
						
								out.print("+</a></td>" );								
								out.println("<td nowrap class='"+class_val+"' nowrap>"+admission_date_time+"</td>");
								out.println("<td nowrap class='"+class_val+"'>"+encounter_id+"</td>");
								
							}
							out.println("<td nowrap class='"+class_val+"'>"+patient_id+"</td>");
							out.println("<td nowrap class='"+class_val+"'>"+patient_name+"</td>");
							out.println("<td nowrap class='"+class_val+"'>"+Sex+"</td>");
							out.println("<td nowrap class='"+class_val+"'>"+nursing_unit_short_desc+"</td>");
							out.println("<td nowrap class='"+class_val+"'>"+bed_no+"</td>");
							out.println("</tr>");

							prev_val=specialty_short_desc;
							prev_val2=practitioner_name;							
							i++;
						}
					}
				out.println("</table>");
				if(stmt!=null)	stmt.close();
				if(rs!=null)		rs.close();

				out.println("<script> resetValues(); </script>");
			%>
	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
	<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
	<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
	<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
	<input type='hidden' name='modal' id='modal' value="<%=modal%>" >	
	<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
	<input type='hidden' name='no_of_days' id='no_of_days' value="<%=no_of_days%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >	
	<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=p_practitioner_id%>" >
	<input type='hidden' name='total_count' id='total_count' value="<%=(i-1)%>" >

	</form>
	</body>
<% } 
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
} 
	catch(Exception e)
	{
				out.println(e);
	}
	finally
	{	
		ConnectionManager.returnConnection(con,request);
	}	
%>
</html>
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

