<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCA/js/ProgressNotesTree.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src='../../eCA/js/ProgressNotes.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="">

<%

	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String sel_progression_no=request.getParameter("sel_progression_no") == null ? "0" : request.getParameter("sel_progression_no");
//	String cycle_status=request.getParameter("cycle_status");
	String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
	String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");

	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String progression_ref_req = request.getParameter("progression_ref") == null ? "" : request.getParameter("progression_ref");



//	int cycle_no=0;
	int i=0;
	String facility_id = (String) session.getValue("facility_id"); 
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	boolean flag = true;

	String progression_ref = "";
	String progression_no = "";
	String pre_progression_no = "";
	String speciality_code = "";
	String note_type_desc = "";
	String note_group = "";
	String note_group_desc = "";
	String progression_status = "";
	String speciality_name = "";
	String boldText = "";
	String progress_note_type = "";
	String event_date = "";
	String acc_num = "";
	String acc_num_id = "";
	String event_status = "";
	String event_date_disp = "";

/*	String note_type_desc_dtl = "";
	String progress_note_type_dtl = "";
	String note_group_desc_dtl = "";
	String note_group_dtl = "";*/
	String start_progress_note_type = "";
	String access_yn = "";
	String eff_status = "";
	String patient_class_yn = "";

	StringBuffer menu_sql =new StringBuffer();
	StringBuffer menu_sql_hdr =new StringBuffer();
	StringBuffer menu_sql_dtl =new StringBuffer();
	StringBuffer menu_sql_dtl2 =new StringBuffer();
	StringBuffer menu_sql_dtl3 =new StringBuffer();

	// menu_sql.append("select PROGRESSION_REF, PROGRESSION_CYCLE_NO,SPECIALITY_CODE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) speciality_name,START_PROGRESS_NOTE_TYPE,(select NOTE_TYPE_DESC from ca_note_type_lang where NOTE_TYPE =START_PROGRESS_NOTE_TYPE and LANGUAGE_ID = ? ) note_type_desc,(select NOTE_GROUP_ID from ca_note_type where NOTE_TYPE = START_PROGRESS_NOTE_TYPE) note_group,(select ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) from ca_note_type where NOTE_TYPE = START_PROGRESS_NOTE_TYPE) note_group_desc,PROGRESSION_STATUS from CA_PAT_PROGRESSION_HDR K where PATIENT_ID=? and MODULE_ID = ? and FACILITY_ID = ? ");

	  menu_sql_hdr.append(" select PROGRESSION_REF, PROGRESSION_CYCLE_NO,SPECIALITY_CODE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) speciality_name,  START_PROGRESS_NOTE_TYPE,CA_GET_DESC.CA_NOTE_TYPE(START_PROGRESS_NOTE_TYPE,?,2) note_type_desc,(select NOTE_GROUP_ID from ca_note_type  where NOTE_TYPE = START_PROGRESS_NOTE_TYPE) note_group,(select ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) from ca_note_type where NOTE_TYPE = START_PROGRESS_NOTE_TYPE) note_group_desc,(select EFF_STATUS from ca_note_type  where NOTE_TYPE = START_PROGRESS_NOTE_TYPE) EFF_STATUS,( SELECT decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN) from CA_NOTE_TYPE where note_type=START_PROGRESS_NOTE_TYPE)  patient_class_yn , PROGRESSION_STATUS,NVL2(SPECIALITY_CODE,CA_GET_PROGRESSION_ACCESS_YN(?,?,SPECIALITY_CODE),'Y') access_yn from CA_PAT_PROGRESSION_HDR K where PATIENT_ID= ? and MODULE_ID = ? and FACILITY_ID = ?  ");  // union 
	  menu_sql_dtl.append( " select distinct  NOTE_GROUP_ID,ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) note_group_desc,  PROGRESSION_STATUS from CA_PAT_PROGRESSION_HDR D,CA_PAT_PROGRESSION_DTL E,CA_ENCNTR_NOTE F,ca_note_type G  where D.PROGRESSION_REF=E.PROGRESSION_REF   and E.ACCESSION_NUM =F.ACCESSION_NUM   and F.NOTE_TYPE=G.NOTE_TYPE and NOTE_GROUP_ID not in ( select  j.NOTE_GROUP_ID from ca_note_type j where j.NOTE_TYPE = START_PROGRESS_NOTE_TYPE )   AND G.NOTE_TYPE != START_PROGRESS_NOTE_TYPE  and D.PATIENT_ID= ? and D.MODULE_ID = ? and D.FACILITY_ID = ? and D.PROGRESSION_REF = ? and F.EVENT_STATUS !=9 order by note_group_desc ");
	  menu_sql_dtl2.append( " select distinct D.PROGRESSION_REF, PROGRESSION_CYCLE_NO,SPECIALITY_CODE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) speciality_name,  F.NOTE_TYPE, CA_GET_DESC.CA_NOTE_TYPE(F.NOTE_TYPE,?,2) note_type_desc,NOTE_GROUP_ID,ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) note_group_desc,  PROGRESSION_STATUS from CA_PAT_PROGRESSION_HDR D,CA_PAT_PROGRESSION_DTL E,CA_ENCNTR_NOTE F,ca_note_type G  where D.PROGRESSION_REF=E.PROGRESSION_REF   and E.ACCESSION_NUM =F.ACCESSION_NUM   and F.NOTE_TYPE=G.NOTE_TYPE   AND G.NOTE_TYPE != START_PROGRESS_NOTE_TYPE  and D.PATIENT_ID= ? and D.MODULE_ID = ? and D.FACILITY_ID = ? and D.PROGRESSION_REF = ? and F.EVENT_STATUS !=9 order by NOTE_TYPE_DESC ");
	  menu_sql_dtl3.append( " select distinct D.PROGRESSION_REF, PROGRESSION_CYCLE_NO,SPECIALITY_CODE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) speciality_name,  F.NOTE_TYPE, CA_GET_DESC.CA_NOTE_TYPE(F.NOTE_TYPE,?,2) note_type_desc,NOTE_GROUP_ID,ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) note_group_desc,  PROGRESSION_STATUS from CA_PAT_PROGRESSION_HDR D,CA_PAT_PROGRESSION_DTL E,CA_ENCNTR_NOTE F,ca_note_type G  where D.PROGRESSION_REF=E.PROGRESSION_REF   and E.ACCESSION_NUM =F.ACCESSION_NUM   and F.NOTE_TYPE=G.NOTE_TYPE   AND G.NOTE_TYPE != START_PROGRESS_NOTE_TYPE  and D.PATIENT_ID= ? and D.MODULE_ID = ? and D.FACILITY_ID = ? and D.PROGRESSION_REF = ? and F.EVENT_STATUS !=9 and G.EFF_STATUS='E' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' ");




	 if(sel_progression_no.equals("S"))
	 {
		menu_sql_hdr.append(" and PROGRESSION_STATUS= 'O' "); 
		//menu_sql_dtl.append(" and PROGRESSION_STATUS= 'O' "); 
	 }
	 else if(sel_progression_no.equals("C"))
	 {
		menu_sql_hdr.append(" and PROGRESSION_STATUS= 'C' "); 
		//menu_sql_dtl.append(" and PROGRESSION_STATUS= 'C' "); 
	 }
	 else if(!sel_progression_no.equals("A"))
	 {
		if(called_from.equals("OH_TREATMENT"))
		 {
			menu_sql_hdr.append(" and PROGRESSION_REF = ?  ");
		 }
		 else
		 {
		menu_sql_hdr.append(" and PROGRESSION_CYCLE_NO = ?  "); 
		 }
		//menu_sql_dtl.append(" and PROGRESSION_CYCLE_NO = ?  "); 
	 }
	 if(called_from.equals("OH_TREATMENT"))
	 {
		menu_sql_hdr.append(" and CALLED_FROM = 'OH_TREATMENT' ");
	 }
	 else
	 {
		menu_sql_hdr.append(" and CALLED_FROM = 'OH_CHARTING' ");
	 }

	 menu_sql.append(menu_sql_hdr );
	 //menu_sql.append(" Union " );
	// menu_sql.append(menu_sql_dtl );
	 menu_sql.append(" ORDER  BY PROGRESSION_CYCLE_NO " );

	String prog_dtl=" select B.NOTE_TYPE,A.ACCESSION_NUM,to_char(b.EVENT_DATE_TIME,'DD/MM/YY') ENCNTR_DATE,EVENT_STATUS from  CA_PAT_PROGRESSION_DTL A ,CA_ENCNTR_NOTE B where PROGRESSION_REF=? and a.ACCESSION_NUM=b.ACCESSION_NUM and b.EVENT_STATUS!=9 order by b.EVENT_DATE_TIME ";
%>
<FORM METHOD=POST ACTION="" name="maternityMenu" id="maternityMenu">
<script>
<%
	try
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(menu_sql.toString());

		int count=1;
		pstmt.setString(count++,locale);
		pstmt.setString(count++,locale);
		pstmt.setString(count++,locale);
		pstmt.setString(count++,patient_class);
		pstmt.setString(count++,ca_practitioner_id);
		pstmt.setString(count++,facility_id);
		pstmt.setString(count++,patient_id);
		pstmt.setString(count++,module_id);
		pstmt.setString(count++,facility_id);

		if(called_from.equals("OH_TREATMENT"))
		{
			pstmt.setString(count++,progression_ref_req);
		}
		else if(!(sel_progression_no.equals("S"))&&!(sel_progression_no.equals("C"))&&!(sel_progression_no.equals("A")))
		{
			pstmt.setString(count++,sel_progression_no);
		}
	/*pstmt.setString(count++,locale);
		pstmt.setString(count++,locale);
		pstmt.setString(count++,locale);
		pstmt.setString(count++,patient_id);
		pstmt.setString(count++,module_id);
		pstmt.setString(count++,facility_id);

		if(!(sel_progression_no.equals("S"))&&!(sel_progression_no.equals("C"))&&!(sel_progression_no.equals("A")))
		{
			
			pstmt.setString(count++,sel_progression_no);
		} */

		rs	 = pstmt.executeQuery();

		while(rs.next())
		{

			flag = false;
			progression_ref = rs.getString("PROGRESSION_REF")==null?"1":rs.getString("PROGRESSION_REF");
			progression_no = rs.getString("PROGRESSION_CYCLE_NO")==null?"0":rs.getString("PROGRESSION_CYCLE_NO");
			speciality_code = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
			note_type_desc = rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
			eff_status = rs.getString("EFF_STATUS")==null?"":rs.getString("EFF_STATUS");
			patient_class_yn = rs.getString("patient_class_yn")==null?"":rs.getString("patient_class_yn");
			progress_note_type = rs.getString("START_PROGRESS_NOTE_TYPE")==null?"":rs.getString("START_PROGRESS_NOTE_TYPE");
			note_group_desc = rs.getString("note_group_desc")==null?"":rs.getString("note_group_desc");
			note_group = rs.getString("note_group")==null?"":rs.getString("note_group");
			progression_status = rs.getString("PROGRESSION_STATUS")==null?"":rs.getString("PROGRESSION_STATUS");
			speciality_name = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");
			
			access_yn = rs.getString("access_yn")==null?"":rs.getString("access_yn");

			 start_progress_note_type = progress_note_type ;
		
		%>	
				
		var obj<%=i%>;
		obj<%=i%> = new dTree('obj<%=i%>');
		obj<%=i%>.add(0,-1,'');
		obj<%=i%>.config.useStatusText=true;
<%
	 
		if(access_yn.equals("Y")){
%>
		obj<%=i%>.add('<%=progression_ref%>NG^<%=note_group%>','0','<b><%=note_group_desc%></b>','../../eCA/jsp/ProgressNotesView.jsp?<%=queryString%>&note_group=<%=note_group%>&progression_ref=<%=progression_ref%>&level=NG&note_group_desc=<%=note_group_desc%>','<%=note_group_desc%>','workAreaFrame','','','','R');
<%	}else {	%>

		obj<%=i%>.add('<%=progression_ref%>NG^<%=note_group%>','0','<b><%=note_group_desc%></b>','../../eCA/jsp/ProgressNotesAccessMsg.jsp','<%=note_group_desc%>','workAreaFrame','','','','R');

<%}%>
	
		obj<%=i%>.add('<%=progression_ref%><%=progress_note_type%>','<%=progression_ref%>NG^<%=note_group%>','<b><%=note_type_desc%></b>','','<%=note_type_desc%>','workAreaFrame','','','','R');
		
	<%

		if(!progression_ref.equals(""))
			{
				
				pstmt2 = con.prepareStatement(menu_sql_dtl.toString());
				//pstmt2.setString(1,locale);
				//pstmt2.setString(2,locale);
				pstmt2.setString(1,locale);
				pstmt2.setString(2,patient_id);
				pstmt2.setString(3,module_id);
				pstmt2.setString(4,facility_id);
				pstmt2.setString(5,progression_ref);
				rs2	 = pstmt2.executeQuery();
				while(rs2.next())
				{

					//progression_ref = rs.getString("PROGRESSION_REF")==null?"1":rs.getString("PROGRESSION_REF");
					//progression_no = rs.getString("PROGRESSION_CYCLE_NO")==null?"0":rs.getString("PROGRESSION_CYCLE_NO");
					//speciality_code = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
					//note_type_desc = rs2.getString("note_type_desc")==null?"":rs2.getString("note_type_desc");
					//progress_note_type = rs2.getString("NOTE_TYPE")==null?"":rs2.getString("NOTE_TYPE");
					note_group_desc = rs2.getString("note_group_desc")==null?"":rs2.getString("note_group_desc");
					note_group = rs2.getString("NOTE_GROUP_ID")==null?"":rs2.getString("NOTE_GROUP_ID");
					//progression_status = rs.getString("PROGRESSION_STATUS")==null?"":rs.getString("PROGRESSION_STATUS");
					//speciality_name = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");

					if(access_yn.equals("Y")){

				%>
				
				obj<%=i%>.add('<%=progression_ref%>NG^<%=note_group%>','0','<b><%=note_group_desc%></b>','../../eCA/jsp/ProgressNotesView.jsp?<%=queryString%>&note_group=<%=note_group%>&progression_ref=<%=progression_ref%>&level=NG&note_group_desc=<%=note_group_desc%>','<%=note_group_desc%>','workAreaFrame','','','','R');
				//obj<%=i%>.add('<%=progression_ref%><%=note_group%>','0','<b><%=note_group_desc%></b>','../../eCA/jsp/ProgressNotesAccessMsg.jsp','<%=note_group_desc%>','workAreaFrame','','','','R');

				<% }else{ %>
				
				obj<%=i%>.add('<%=progression_ref%>NG^<%=note_group%>','0','<b><%=note_group_desc%></b>','../../eCA/jsp/ProgressNotesAccessMsg.jsp','<%=note_group_desc%>','workAreaFrame','','','','R');
				//obj<%=i%>.add('<%=progression_ref%><%=note_group%>','0','<b><%=note_group_desc%></b>','../../eCA/jsp/ProgressNotesView.jsp?<%=queryString%>&note_group=<%=note_group%>&progression_ref=<%=progression_ref%>&level=NG&note_group_desc=<%=note_group_desc%>','<%=note_group_desc%>','workAreaFrame','','','','R');
				
				<% } %>
				//obj<%=i%>.add('<%=progression_ref%><%=progress_note_type%>','<%=progression_ref%><%=note_group%>','<b><%=note_type_desc%></b>','','<%=note_type_desc%>','workAreaFrame','','','','R');
				
				<%

				}

				if(rs2!=null)	rs2.close();
				if(pstmt2!=null)	pstmt2.close();


				pstmt2 = con.prepareStatement(menu_sql_dtl2.toString());
				pstmt2.setString(1,locale);
				pstmt2.setString(2,locale);
				pstmt2.setString(3,locale);
				pstmt2.setString(4,patient_id);
				pstmt2.setString(5,module_id);
				pstmt2.setString(6,facility_id);
				pstmt2.setString(7,progression_ref);
				rs2	 = pstmt2.executeQuery();
				while(rs2.next())
				{

					//progression_ref = rs.getString("PROGRESSION_REF")==null?"1":rs.getString("PROGRESSION_REF");
					//progression_no = rs.getString("PROGRESSION_CYCLE_NO")==null?"0":rs.getString("PROGRESSION_CYCLE_NO");
					//speciality_code = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
					note_type_desc = rs2.getString("note_type_desc")==null?"":rs2.getString("note_type_desc");
					progress_note_type = rs2.getString("NOTE_TYPE")==null?"":rs2.getString("NOTE_TYPE");
					note_group_desc = rs2.getString("note_group_desc")==null?"":rs2.getString("note_group_desc");
					note_group = rs2.getString("NOTE_GROUP_ID")==null?"":rs2.getString("NOTE_GROUP_ID");
					//progression_status = rs.getString("PROGRESSION_STATUS")==null?"":rs.getString("PROGRESSION_STATUS");
					//speciality_name = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");

				%>
					
				obj<%=i%>.add('<%=progression_ref%><%=progress_note_type%>','<%=progression_ref%>NG^<%=note_group%>','<b><%=note_type_desc%></b>','','<%=note_type_desc%>','workAreaFrame','','','','R');

				<%

				
				
				}

				if(rs2!=null)	rs2.close();
				if(pstmt2!=null)	pstmt2.close();
				
				pstmt1 = con.prepareStatement(prog_dtl);
				pstmt1.setString(1,progression_ref);
				rs1	 = pstmt1.executeQuery();
				 
				while(rs1.next())
				{

					
					acc_num = rs1.getString("ACCESSION_NUM")==null?"":rs1.getString("ACCESSION_NUM");
					progress_note_type = rs1.getString("NOTE_TYPE")==null?"":rs1.getString("NOTE_TYPE");
					event_date = rs1.getString("ENCNTR_DATE")==null?"":rs1.getString("ENCNTR_DATE");
					event_status = rs1.getString("EVENT_STATUS")==null?"":rs1.getString("EVENT_STATUS");

					event_date_disp = event_date;
					
					if(event_status.equals("4")||event_status.equals("5"))
					{
						
						acc_num_id ="$$SIGN##"+acc_num;
						//event_date_disp= "<img src='../images/MCT_Chart.gif' alt='' /> "+event_date+" "; 
						
					}
				    else
					{
						acc_num_id ="$$RECD##"+acc_num;
						//event_date_disp=" <img src='../images/MI_Diagnosis.gif' alt='' /> "+event_date+" ";	
					}
					if(access_yn.equals("Y"))
					{
						if(progression_status.equals("O"))
						{
	%>
							obj<%=i%>.add('<%=acc_num_id%>','<%=progression_ref%><%=progress_note_type%>','<%=event_date_disp%>','../../eCA/jsp/RecClinicalNotesModal.jsp?<%=queryString%>&note_type=<%=progress_note_type%>&accession_num=<%=acc_num%>&function_id=SPCL_NOTE&contr_mod_accession_num=OH!<%=progression_ref%>&rec_flag=N','<%=event_date_disp%>','workAreaFrame','','','','R');
	<%					} 
						else
						{

	%>
							obj<%=i%>.add('<%=acc_num_id%>','<%=progression_ref%><%=progress_note_type%>','<%=event_date_disp%>','../../eCA/jsp/ProgressNotesView.jsp?<%=queryString%>&note_group=<%=note_group%>&progression_ref=<%=progression_ref%>&level=NT&note_group_desc=<%=note_group_desc%>&accession_num=<%=acc_num%>','<%=event_date_disp%>','workAreaFrame','','','','R');
	<%



	
						}
					}
					else
					{
	%>
							obj<%=i%>.add('<%=acc_num_id%>','<%=progression_ref%><%=progress_note_type%>','<%=event_date_disp%>','../../eCA/jsp/ProgressNotesAccessMsg.jsp','<%=event_date_disp%>','workAreaFrame','','','','R');
	<%
					}

				}
				if(rs1!=null)	rs1.close();
				if(pstmt1!=null)	pstmt1.close();

		// for Add new

				pstmt2 = con.prepareStatement(menu_sql_dtl3.toString());
				pstmt2.setString(1,locale);
				pstmt2.setString(2,locale);
				pstmt2.setString(3,locale);
				pstmt2.setString(4,patient_id);
				pstmt2.setString(5,module_id);
				pstmt2.setString(6,facility_id);
				pstmt2.setString(7,progression_ref);
				pstmt2.setString(8,patient_class);
				rs2	 = pstmt2.executeQuery();
				while(rs2.next())
				{

					//progression_ref = rs.getString("PROGRESSION_REF")==null?"1":rs.getString("PROGRESSION_REF");
					//progression_no = rs.getString("PROGRESSION_CYCLE_NO")==null?"0":rs.getString("PROGRESSION_CYCLE_NO");
					//speciality_code = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
					note_type_desc = rs2.getString("note_type_desc")==null?"":rs2.getString("note_type_desc");
					progress_note_type = rs2.getString("NOTE_TYPE")==null?"":rs2.getString("NOTE_TYPE");
					note_group_desc = rs2.getString("note_group_desc")==null?"":rs2.getString("note_group_desc");
					note_group = rs2.getString("NOTE_GROUP_ID")==null?"":rs2.getString("NOTE_GROUP_ID");
					//progression_status = rs.getString("PROGRESSION_STATUS")==null?"":rs.getString("PROGRESSION_STATUS");
					//speciality_name = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");

				if(progression_status.equals("O"))
				{
				if(access_yn.equals("Y")){

				%>
				//obj<%=i%>.add('<%=progression_ref%><%=note_group%>','0','<b><%=note_group_desc%></b>','../../eCA/jsp/ProgressNotesView.jsp?<%=queryString%>&note_group=<%=note_group%>&progression_ref=<%=progression_ref%>&level=NG&note_group_desc=<%=note_group_desc%>','<%=note_group_desc%>','workAreaFrame','','','','R');
				obj<%=i%>.add('PROGRESSNOTE<%=progress_note_type%>','<%=progression_ref%><%=progress_note_type%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")%>','../../eCA/jsp/RecClinicalNotes.jsp?<%=queryString%>&p_note_type=<%=progress_note_type%>&note_type=<%=progress_note_type%>&function_id=SPCL_NOTE&contr_mod_accession_num=OH!<%=progression_ref%>','Add New','workAreaFrame','','','','R');
				
				<%
				}else {
				%>
				obj<%=i%>.add('PROGRESSNOTE<%=progress_note_type%>','<%=progression_ref%><%=progress_note_type%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")%>','../../eCA/jsp/ProgressNotesAccessMsg.jsp','Add New','workAreaFrame','','','','R');

				<%
				}
				}
				else
				{
				%>
				//obj<%=i%>.add('PROGRESSNOTE<%=progress_note_type%>','<%=progression_ref%><%=progress_note_type%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")%>','','Add New','workAreaFrame','','','','R');
				<%

				}
				}

				if(rs2!=null)	rs2.close();
				if(pstmt2!=null)	pstmt2.close();



		//  Add new ends.

			}

		
		if(progression_status.equals("O"))
		{

		
			if(access_yn.equals("Y")){
				if(eff_status.equals("E")&&patient_class_yn.equals("Y")){
			
			%>
				obj<%=i%>.add('PROGRESSNOTEA','<%=progression_ref%><%=start_progress_note_type%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")%>','../../eCA/jsp/RecClinicalNotes.jsp?<%=queryString%>&p_note_type=<%=start_progress_note_type%>&note_type=<%=start_progress_note_type%>&function_id=SPCL_NOTE&contr_mod_accession_num=OH!<%=progression_ref%>','Add New','workAreaFrame','','','','R');
			<%
				}	
			%>	
				obj<%=i%>.add('PROGRESSNOTEB','0','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")%>','../../eCA/jsp/RecClinicalNotes.jsp?<%=queryString%>&contr_mod_accession_num=OH!<%=progression_ref%>','Add New','workAreaFrame','','','','R');


				obj<%=i%>.add('OUTCOME','0','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RecordOutcome.label","ca_labels")%>','../../eCA/jsp/ProgressNotesOutcome.jsp?<%=queryString%>&progression_ref=<%=progression_ref%>&progression_no=<%=progression_no%>','Record Outcome','workAreaFrame','','','','R');

			<%
			} 
			else
			{
			
				if(eff_status.equals("E")&&patient_class_yn.equals("Y")){
			%>
	
				obj<%=i%>.add('PROGRESSNOTEA','<%=progression_ref%><%=start_progress_note_type%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")%>','../../eCA/jsp/ProgressNotesAccessMsg.jsp','Add New','workAreaFrame','','','','R');
			<% 
				} 
			%>	
				obj<%=i%>.add('PROGRESSNOTEB','0','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")%>','../../eCA/jsp/ProgressNotesAccessMsg.jsp','Add New','workAreaFrame','','','','R');
	
	
				obj<%=i%>.add('OUTCOME','0','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RecordOutcome.label","ca_labels")%>','../../eCA/jsp/ProgressNotesAccessMsg.jsp','Record Outcome','workAreaFrame','','','','R');

	<%		}
		}
	else
		{
	%>
		
		
		//obj<%=i%>.add('PROGRESSNOTEA','<%=progression_ref%><%=progress_note_type%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")%>','','Add New','workAreaFrame','','','','R');
		
		//obj<%=i%>.add('PROGRESSNOTEB','<%=progression_ref%><%=note_group%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")%>','','Add New','workAreaFrame','','','','R');
		
		//obj<%=i%>.add('OUTCOME','0','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RecordOutcome.label","ca_labels")%>','','Record Outcome','workAreaFrame','','','','R');

	<%  
	

		}
		if(progression_status.equals("O"))
		{
			if(!speciality_name.equals("")){
				boldText = "<a href=javascript:viewProgression("+progression_ref+",'"+access_yn+"') > <b> Progression "+progression_no+"( "+speciality_name+" )</b></a>";	
			}
			else
			{
				boldText = "<a href=javascript:viewProgression("+progression_ref+",'"+access_yn+"') > <b> Progression "+progression_no+" </b></a>";		
			}
		}
		else
		{
			if(!speciality_name.equals("")){
				boldText = " <a href=javascript:viewProgression("+progression_ref+",'"+access_yn+"') >Progression "+progression_no+"( "+speciality_name+" ) </a> ";
			}
			else
			{
				boldText = " <a href=javascript:viewProgression("+progression_ref+",'"+access_yn+"') >Progression "+progression_no+" </a> ";
			}
		}

		if(!progression_no.equals(pre_progression_no))
		{
	%>

		var html="<TABLE width='95%' align='center' border=0 cellspacing=0>";
		html=html+"<TR>";
		html=html+"<TD background='../../eCA/images/MCT_FullStrip.gif' style='height:32' onclick=\"hideShowNodes('<%=i%>')\">&nbsp;<%=boldText%>";
		html=html+"</TD>";
		html=html+"</TR></TABLE>";
		parent.maternitytreeframe.document.write(html); 

		
		document.write("<TABLE width='95%' height='45%' align='center' border=0 cellspacing=0><TR VALIGN=TOP><TD id='tdId<%=i%>' style='display;BACKGROUND-IMAGE:url(../../eCA/images/MCT_MenuBgImage.jpg)'>"+obj<%=i%>+"</td></tr></TABLE>");
<%
			
	  }
  			

%>
		
	obj<%=i%>.openAll();
		
	<%
	   i++;
		pre_progression_no = progression_no;
		
		}
		
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		


	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs!= null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			if(con!= null) ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

%>
</script>
<%
if(flag)
		{

		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'))</script>");
			
		}
%>


<input type=hidden name='noOfEvents' id='noOfEvents' value='<%=i%>'>
</FORM>
</body>
</html>

