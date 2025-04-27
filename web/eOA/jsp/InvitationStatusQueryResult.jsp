<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>
<% 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String fac_id		= (String) session.getValue( "facility_id" ) ;
		String locale=(String)session.getAttribute("LOCALE");
		StringBuffer sql=new StringBuffer("") ;
		String mon	=   request.getParameter("mon")== null?"":request.getParameter("mon");
		String yr	=	request.getParameter("yr")== null?"":request.getParameter("yr");
		String dt	=	request.getParameter("dt")== null?"":request.getParameter("dt");
		String prd = request.getParameter("prd")==null?"":request.getParameter("prd");
		String date_val=dt+"/"+mon+"/"+yr;
		if(date_val ==null) date_val="";
		String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String ALCN_CRITERIA_YN=request.getParameter("ALCN_CRITERIA_YN");
		if(ALCN_CRITERIA_YN ==null) ALCN_CRITERIA_YN="";
		String nat_id_no=request.getParameter("nat_id_no");
		if(nat_id_no ==null) nat_id_no="";
		String alt_id1_no=request.getParameter("alt_id1_no");
		if(alt_id1_no ==null) alt_id1_no="";
		String alt_id1_type=request.getParameter("alt_id1_type");
		if(alt_id1_type ==null) alt_id1_type="";
		String alt_id2_no=request.getParameter("alt_id2_no"); 
		if(alt_id2_no ==null) alt_id2_no="";
		String alt_id2_type=request.getParameter("alt_id2_type");
		if(alt_id2_type ==null) alt_id2_type="";
		String alt_id3_no=request.getParameter("alt_id3_no");
		if(alt_id3_no ==null) alt_id3_no="";
		String alt_id3_type=request.getParameter("alt_id3_type");
		if(alt_id3_type ==null) alt_id3_type="";
		String alt_id4_no=request.getParameter("alt_id4_no");
		if(alt_id4_no ==null) alt_id4_no="";
		String alt_id4_type=request.getParameter("alt_id4_type");
		if(alt_id4_type ==null) alt_id4_type="";
		String other_alt_Id=request.getParameter("other_alt_Id");
		if(other_alt_Id ==null) other_alt_Id="";
		String other_alt_type=request.getParameter("other_alt_type");
		if(other_alt_type ==null) other_alt_type="";

		String nat_id_code=request.getParameter("nat_id_code");
		if(nat_id_code ==null) nat_id_code="";
		String r_area_code=request.getParameter("r_area");
		if(r_area_code ==null) r_area_code="";
		String m_area_code=request.getParameter("m_area");
		if(m_area_code ==null) m_area_code="";
		String r_region_code=request.getParameter("r_region");
		if(r_region_code ==null) r_region_code="";
		String m_region_code=request.getParameter("m_region");
		if(m_region_code ==null) m_region_code="";
		String r_town_code=request.getParameter("r_town");
		if(r_town_code ==null) r_town_code="";
		String m_town_code=request.getParameter("m_town");
		if(m_town_code ==null) m_town_code="";

		String wait_list_priority=request.getParameter("wait_list_priority");
		if(wait_list_priority ==null) wait_list_priority="";
			
		String classValue	 = "";
		String classValue1="";
		String waitListNo="";
		String priority="";
		String priority_desc="";
		String patientId="";
		String patientName="";
		String preferedDate="";
		String Gender="";
		String gender1="";
		String wait_list_status_code="";
		String age="";
		String waitlist_category_code="";
		String waitlist_cat_desc="";
		String waitlist_category_code_prev="";


		Statement stmt				= null;
		ResultSet rs				= null;
		Connection conn=null;
		Statement st=null;
		PreparedStatement pstmt=null;
		ResultSet rsSet=null;
		ResultSet rsSet1=null;
			java.util.ArrayList arrlst=new java.util.ArrayList();

	%>
	<HTML>
	 <head>
		<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
		<script src="../../eOA/js/QueryLocnForDay.js"></script>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		
        <script src='../../eOA/js/WaitListInvitation.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

		<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()'  onscroll='scrollTitle2()' >
		<form name='QueryApptForPatient' id='QueryApptForPatient' >
		<%
try
{
			conn = ConnectionManager.getConnection(request);
			stmt	 = conn.createStatement();
			StringBuffer sql3 = new StringBuffer();
			String sqlmain="";
			String  first_encounter_date_display="";
			String wait_list_status="";
			String first_encounter_date="";
			StringBuffer sqlmain2= new StringBuffer();
			//sqlmain="select 'I' WAIT_STATUS,count(*) count from pr_wait_list where facility_id = '"+fac_id+"'  and  INVITED_DATE_TIME=to_date('"+date_val+"','dd/mm/yyyy') and WAIT_LIST_STATUS ='I' UNION Select 'S' WAIT_STATUS,COUNT (*) count FROM pr_wait_list  WHERE facility_id ='"+fac_id+"'  and wait_list_status='S'  and to_date(to_char(preferred_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  between   trunc(sysdate - '"+prd+"' )  and  trunc(sysdate+1) UNION Select  'O' WAIT_STATUS, count(*) count FROM pr_wait_list WHERE facility_id = '"+fac_id+"'  and  preferred_date_time   between trunc(sysdate - '"+prd+"' ) and trunc(sysdate+1)  and wait_list_status='O' ORDER BY WAIT_STATUS ";
			sqlmain="select 'I' WAIT_STATUS,count(*) count from pr_wait_list where facility_id = ? and  INVITED_DATE_TIME=to_date(?,'dd/mm/yyyy') and WAIT_LIST_STATUS ='I' UNION Select 'S' WAIT_STATUS,COUNT (*) count FROM pr_wait_list  WHERE facility_id =?  and wait_list_status='S'  and to_date(to_char(preferred_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  between   trunc(sysdate - ? )  and  trunc(sysdate+1) UNION Select  'O' WAIT_STATUS, count(*) count FROM pr_wait_list WHERE facility_id = ?  and  preferred_date_time   between trunc(sysdate - ? ) and trunc(sysdate+1)  and wait_list_status='O' ORDER BY WAIT_STATUS ";
						
			//st= conn.createStatement();
			rsSet=null;
			//rsSet 	= st.executeQuery(sqlmain);
			pstmt = conn.prepareStatement(sqlmain);
			pstmt.setString(1,fac_id);
			pstmt.setString(2,date_val);
			pstmt.setString(3,fac_id);
			pstmt.setString(4,prd);
			pstmt.setString(5,fac_id);
			pstmt.setString(6,prd);
			rsSet = pstmt.executeQuery();
			if (rsSet!=null)
			{
				while(rsSet.next())
				{			
					arrlst.add(rsSet.getString("count"));
				}
			}
			if(arrlst.size()>0)
				{%>

				<table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
				<th  nowrap width='7%'><div  id='head1' class='myClass'>&nbsp;</div></th>
				<th  nowrap width='25%'><div  id='head2' class='myClass'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></div></th>
				<th nowrap width='25%'><div  id='head3' class='myClass'>
				<fmt:message key="Common.first.label" bundle="${common_labels}"/><fmt:message key="eOA.ArrivalDate.label" bundle="${oa_labels}"/></div></th>
				<th align='center' nowrap width='25%'><div  id='head4' class='myClass'><fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/></div></th>
				<th   nowrap width='25%'><div  id='head5' class='myClass'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></div></th>
				<th align='center' nowrap width='25%'><div  id='head6' class='myClass'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></div></th>
				<th  nowrap width='25%'><div  id='head7' class='myClass'><fmt:message key="Common.age.label" bundle="${common_labels}"/></div></th>
				<th  nowrap width='25%'><div  id='head8' class='myClass'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></div></th>
				<th  nowrap width='25%'><div  id='head9' class='myClass'><fmt:message key="Common.WaitList.label" bundle="${common_labels}"/><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></th>
				
					
				<%
				sql.append("select wait_list_no,WAIT_LIST_PRIORITY priority,patient_id,decode('"+locale+"','en',PATIENT_NAME, nvl(patient_name_loc_lang, patient_name)) patient_name,to_char(PREFERRED_DATE_TIME,'dd/mm/yyyy') pref_date_time,GENDER, get_age(DATE_OF_BIRTH)age,WAIT_LIST_STATUS, WAITLIST_CATEGORY_CODE, OA_GET_DESC.OA_WAITLIST_CATEGORY(WAITLIST_CATEGORY_CODE,'"+locale+"','1') waitlist_cat_desc,to_char(FIRST_ENCOUNTER_DATE,'dd/mm/yyyy')FIRST_ENCOUNTER_DATE  from pr_wait_list where facility_id = '"+fac_id+"'  and  ( INVITED_DATE_TIME=to_date('"+date_val+"','dd/mm/yyyy') AND wait_list_status='I') or wait_list_status IN ('O', 'S') and preferred_date_time between trunc(sysdate - '"+prd+"' ) and trunc(sysdate+1)");
					
				sqlmain2.append(sql.toString()+sql3.toString());
				sql3.setLength(0);
				sql.setLength(0);
				
				sqlmain2.append(" ORDER BY WAITLIST_CATEGORY_CODE,WAIT_LIST_PRIORITY DESC ,to_number(WAIT_LIST_NO),PREFERRED_DATE_TIME");
				rs = null;
							
				rs 	= stmt.executeQuery(sqlmain2.toString());
				sqlmain2.setLength(0);
				int rowcolor=0;
				
				if(rs != null)
				{
					int k=0;
					while ( rs.next() )
					{
						waitListNo =rs.getString("wait_list_no");
						if(waitListNo ==null) waitListNo="";
						priority = rs.getString("priority");
						if(priority ==null) priority="";
						if(priority.equals("U"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
						}else if(priority.equals("S"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiurgent.label","common_labels");
						}else if(priority.equals("N"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
						}
						patientId = rs.getString("patient_id");	
						if(patientId==null) patientId="";
						patientName	=rs.getString("patient_name");	
						if (patientName==null) patientName="";
						else
						if (patientName.length() >= 25) patientName=patientName.substring(0,25);
						preferedDate =rs.getString("pref_date_time");
						if(preferedDate ==null) preferedDate="";
						age=rs.getString("age");
						if(age==null) age="";
						
						wait_list_status_code=rs.getString("WAIT_LIST_STATUS");
						if(wait_list_status_code ==null) wait_list_status_code="";

						if(wait_list_status_code.equals("O") )
						{
							wait_list_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
						}else if(wait_list_status_code.equals("I"))
						{
							wait_list_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.invited.label","oa_labels");
						}else if(wait_list_status_code.equals("S"))
						{
							wait_list_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Selected.label","common_labels");
						}

						
						Gender=rs.getString("GENDER");
						if(Gender ==null) Gender="";
						if(Gender.equals("M") )
						{
							gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						}else if(Gender.equals("F"))
						{
							gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						}else if(Gender.equals("U"))
						{
							gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						}
						waitlist_category_code =rs.getString("WAITLIST_CATEGORY_CODE");
						if(waitlist_category_code ==null) waitlist_category_code="";
						first_encounter_date=rs.getString("FIRST_ENCOUNTER_DATE");
						if(first_encounter_date ==null) first_encounter_date="";
						first_encounter_date_display=DateUtils.convertDate(first_encounter_date,"DMY","en",locale);
						waitlist_cat_desc=rs.getString("WAITLIST_CAT_DESC");
						if(waitlist_cat_desc ==null) waitlist_cat_desc="";
						
						
						

						if ( rowcolor % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						if(wait_list_status_code.equals("O"))
						{
							classValue1="EMERGENT";
						}else if(wait_list_status_code.equals("S"))
						{
							classValue1="ORBROWN";
						}else if(wait_list_status_code.equals("I"))
						{
							classValue1="MRHYPERIII";
						}
						%>
						
						
						<%
							int cnt_wait_list=0;
							int cnt_invited_list=0;
							int cnt_uninvited_list=0;
							//String oldest_arr_date="";
							//String latest_arr_date="";
							//String lat_invited="";
							
							
							if(!waitlist_category_code.equals(waitlist_category_code_prev)) {
								
								//String sql2="select count(*) count from pr_wait_list where wait_list_status='O' and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL('"+waitlist_category_code+"','X') AND facility_id = '"+fac_id+"' and  preferred_date_time between trunc(sysdate - '"+prd+"' ) and trunc(sysdate+1)";
								//rsSet1 	= st.executeQuery(sql2);
								String sql2="select count(*) count from pr_wait_list where wait_list_status='O' and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL(?,'X') AND facility_id = ? and  preferred_date_time between trunc(sysdate - ? ) and trunc(sysdate+1)";
								pstmt = conn.prepareStatement(sql2);
								pstmt.setString(1,waitlist_category_code);
								pstmt.setString(2,fac_id);
								pstmt.setString(3,prd);
								rsSet1 = pstmt.executeQuery();
								if(rsSet1 !=null && rsSet1.next())
								{
									cnt_wait_list=rsSet1.getInt("count");
								}
								if(rsSet1 !=null)rsSet1.close();
								//String sql4="select count(*) count from pr_wait_list where wait_list_status='I' AND  invited_date_time = TO_DATE ('"+date_val+"', 'dd/mm/yyyy') and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL('"+waitlist_category_code+"','X')";
								//rsSet1 	= st.executeQuery(sql4);
								String sql4="select count(*) count from pr_wait_list where wait_list_status='I' AND  invited_date_time = TO_DATE (?, 'dd/mm/yyyy') and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL(?,'X')";
								pstmt = conn.prepareStatement(sql4);
								pstmt.setString(1,date_val);
								pstmt.setString(2,waitlist_category_code);
								rsSet1 = pstmt.executeQuery();
								if(rsSet1 !=null && rsSet1.next())
								{
									cnt_invited_list=rsSet1.getInt("count");
								}
								if(rsSet1 !=null)rsSet1.close();
								//String sql5="select count(*) count from pr_wait_list where wait_list_status='I' AND to_date(to_char(invited_date_time,'mm/yyyy'),'mm/yyyy') = TO_DATE (to_char(sysdate,'mm/yyyy'), 'mm/yyyy') and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL('"+waitlist_category_code+"','X')";
								//rsSet1 	= st.executeQuery(sql5);
								String sql5="select count(*) count from pr_wait_list where wait_list_status='I' AND to_date(to_char(invited_date_time,'mm/yyyy'),'mm/yyyy') = TO_DATE (to_char(sysdate,'mm/yyyy'), 'mm/yyyy') and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL(? ,'X')";
								pstmt = conn.prepareStatement(sql5);
								pstmt.setString(1,waitlist_category_code);
								rsSet1 = pstmt.executeQuery();
								if(rsSet1 !=null && rsSet1.next())
								{
									cnt_uninvited_list=rsSet1.getInt("count");
								}
								if(rsSet1 !=null)rsSet1.close();
								
								if(rsSet1 !=null)rsSet1.close();
							 %>
							<tr onMouseOver='hideToolTip()'>
							<td class='MRHEADER' width='7%' nowrap colspan='9'><%=waitlist_cat_desc%>&nbsp;<fmt:message key="eOA.TotalWaitListed.label" bundle="${oa_labels}"/>:<%=cnt_wait_list%>&nbsp;<fmt:message key="eOA.TotalInvited.label" bundle="${oa_labels}"/>: <%=cnt_invited_list%>&nbsp;
							<fmt:message key="eOA.TotalInvitedForCurrentMonth.label" bundle="${oa_labels}"/> :<%=cnt_uninvited_list%></td>
							</tr>
								<tr onMouseOver='hideToolTip()'>
						<td class='<%=classValue1%>' width='7%' nowrap>&nbsp;</td>
						<td class='<%=classValue%>' width='14%' nowrap>	<%=priority_desc%> </td>
						<td class='<%=classValue%>' width='14%' nowrap>	<%=first_encounter_date_display%>&nbsp; </td>
						<td class='<%=classValue%>' width='8%'  nowrap> 
						<%=waitListNo%>&nbsp;<input type='hidden' name='wait_num' id='wait_num' value='<%=waitListNo%>'></td>	
						<td class="<%=classValue%>" nowrap onClick=hideToolTip() width='11%'><%=patientId%>&nbsp;</td>
						<td class="<%=classValue%>"  nowrap width='10%'>
						<%=patientName%>&nbsp;</td>
						<td class='<%=classValue%>' width='12%'><%=age%>&nbsp; </td>
						<td class='<%=classValue%>' width='10%'><%=gender1%> </td>
						<td class='<%=classValue%>' width='10%'><%=wait_list_status%></td>
						<input type='hidden' name='ret_value' id='ret_value' value='<%=waitListNo%>' >
							</tr>
							<%}else {%>
						<tr onMouseOver='hideToolTip()'>
						<td class='<%=classValue1%>' width='7%' nowrap>&nbsp;</td>
						<td class='<%=classValue%>' width='14%' nowrap>	<%=priority_desc%> </td>
						<td class='<%=classValue%>' width='14%' nowrap>	<%=first_encounter_date_display%>&nbsp; </td>
						<td class='<%=classValue%>' width='8%'  nowrap> 
						<%=waitListNo%>&nbsp;<input type='hidden' name='wait_num' id='wait_num' value='<%=waitListNo%>'></td>	
						<td class="<%=classValue%>" nowrap onClick=hideToolTip() width='11%'><%=patientId%>&nbsp;</td>
						<td class="<%=classValue%>"  nowrap width='10%'>
						<%=patientName%>&nbsp;</td>
						<td class='<%=classValue%>' width='12%'>	<%=age%>&nbsp; </td>
						<td class='<%=classValue%>' width='10%'><%=gender1%> </td>
						<td class='<%=classValue%>' width='10%'><%=wait_list_status%></td>
						<input type='hidden' name='ret_value' id='ret_value' value='<%=waitListNo%>' >
						</tr>
							
						
						
					<%}
					
					waitlist_category_code_prev=rs.getString("WAITLIST_CATEGORY_CODE");
					if(waitlist_category_code_prev ==null) waitlist_category_code_prev="";
					
					
					k=k+1;
					rowcolor++;

				}//while loop
		}//if
				
		%>
			
			<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
			<input type='hidden' name='ALCN_CRITERIA_YN' id='ALCN_CRITERIA_YN' value='<%=ALCN_CRITERIA_YN%>'>
					
			
			</table>
				<tr></tr>
				<tr></tr><tr></tr>
				<table border='0' align='right' width='6%'>

	</table>
  <%}// any rec present
arrlst.clear();
	if ( rs != null ) rs.close() ;
	if ( rsSet!=null) rsSet.close();
	if ( stmt != null ) stmt.close() ;
	if ( st != null ) st.close();

}	catch ( Exception e ){
	//out.println(e);
	e.printStackTrace();
}finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>  

<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:15%; visibility:hidden;' bgcolor='blue'>
<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
<tr><td width='100%' id='t'></td></tr>
</table>
</div>	 
</center>
</form>
</body>
</html>

