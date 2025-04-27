<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%!

public ArrayList getOPAppointments(Connection con, Statement stmt, StringBuffer sqlQuery, String locale) throws Exception
{
	ArrayList opList=new ArrayList();
	ResultSet rset=stmt.executeQuery(sqlQuery.toString());
	SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	StringBuffer sb=new StringBuffer();
	java.util.Date date1=new java.util.Date();

	while(rset.next())
	{		
		if ( rset.getString("facility_name") != null )
		{
			sb.append(rset.getString("facility_name"));
			
		}
		else
		{
			sb.append("&nbsp;");
		}
		sb.append("~");
		if ( rset.getDate("appt_date") != null )
		{
			 date1 = rset.getDate("appt_date");
			 String dateString = formatter.format(date1);
			 dateString=DateUtils.convertDate(dateString,"DMY","en",locale);
			 sb.append(dateString);
		}
		else
		{
			sb.append("&nbsp;");
		}
		sb.append("~");
		if ( rset.getString("appt_slab_from_time") != null )
		{
		sb.append(rset.getString("appt_slab_from_time"));
		}
		else
		{
			sb.append("&nbsp;");
		}
		sb.append("~");
		if ( rset.getString("appt_slab_to_time") != null )
		{

		sb.append(rset.getString("appt_slab_to_time"));
		}
		else
			{
			sb.append("&nbsp;");
		}
		sb.append("~");

		if ( rset.getString("clinic_short_desc") != null )
		{

		sb.append(rset.getString("clinic_short_desc"));
		}
		else
			{
			sb.append("&nbsp;");
		}
		sb.append("~");

		if ( rset.getString("speciality") != null )
		{

		sb.append(rset.getString("speciality"));
		}
		else
			{
			sb.append("&nbsp;");
		}
		sb.append("~");

		if(rset.getString("practitioner_short_name") != null)
		{
			sb.append(rset.getString("practitioner_short_name"));
		}
		else {
			sb.append("&nbsp;");
		}	
		sb.append("~");
		if(rset.getString("contact_reason") != null || !rset.getString("contact_reason").equals(""))
		{
			sb.append(rset.getString("contact_reason"));
		}
		else {
			sb.append("&nbsp;");
		}			
		sb.append("~");
		if(rset.getString("visit_type_short_desc") != null)
		{
			sb.append(rset.getString("visit_type_short_desc"));
		}
		else {
			sb.append("&nbsp;");
		}
		
		//Below Condtion Added for this Bru-HIMS-CRF -177
		
		if(rset.getString("APPT_TYPE_CODE") != null)
		{   sb.append("#");
			sb.append(rset.getString("APPT_TYPE_CODE"));
			sb.append(rset.getString("FACILITY_ID"));
		}
		else {
		    sb.append("#");
			sb.append("&nbsp;");
		}
		//End Bru-HIMS-CRF -177
		
		
		opList.add(sb.toString());
		sb.delete(0,sb.length());
	}
	return opList;
}

public ArrayList getIPBookings(Connection con, Statement stmt, StringBuffer sqlQuery, String locale) throws Exception
{
	ArrayList ipList=new ArrayList();
	ResultSet rset=stmt.executeQuery(sqlQuery.toString());
	StringBuffer sb=new StringBuffer();
	while(rset.next())
	{
		
		if ( rset.getString("facility_name") != null )
		{
			sb.append(rset.getString("facility_name"));
		}
		else
		{
			sb.append("&nbsp;");
		}
		sb.append("~");
		if ( rset.getString("booking_date_time") != null )
		{
			String PreferredDate=rset.getString("booking_date_time");
			PreferredDate=DateUtils.convertDate(PreferredDate,"DMY","en",locale);
			sb.append(PreferredDate);
		}
		else
		{
				sb.append("&nbsp;");
		}
		sb.append("~");
		if ( rset.getString("bkg_lst_ref_no") != null )
		{
			sb.append(rset.getString("bkg_lst_ref_no"));
		}
		else
		{
			sb.append("&nbsp;");
		}
		sb.append("~");
		if ( rset.getString("nursing_unit_short_desc") != null )
		{
			sb.append(rset.getString("nursing_unit_short_desc"));
		}
		else
		{
			sb.append("&nbsp;");
		}
		sb.append("~");
		if ( rset.getString("speciality") != null )
		{

		sb.append(rset.getString("speciality"));
		}
		else
			{
			sb.append("&nbsp;");
		}
		sb.append("~");
		if ( rset.getString("practitioner_short_name") != null )
		{
			sb.append(rset.getString("practitioner_short_name"));
		}
		else
		{
			sb.append("&nbsp;");
		}
		ipList.add(sb.toString());
		sb.delete(0,sb.length());
	}
	return ipList;
}
%>
<html>
<head>
<title>
<%String calling_from=request.getParameter("calling_from")==null?"":request.getParameter("calling_from");
if (calling_from == null)
	calling_from = "";
	if (calling_from.equals("IP"))
	{%><fmt:message key="eIP.FutureAppointments.label" bundle="${ip_labels}"/></title>
	<%}else{%>
<fmt:message key="eOA.OtherAppointments.label" bundle="${oa_labels}"/></title><%}%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function exitContact() 
{
	//window.close();	
	const dialogTag = parent.document.getElementById('dialog_tag');    
	dialogTag.close();
}

</script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
request.setCharacterEncoding("UTF-8");	

		String patientid=request.getParameter("patient_id");
		String appt_ref_no=request.getParameter("appt_ref_no");
		//Added by S.Sathish for IN020737 on Tuesday, June 08, 2010 Starts here
		String appointmentDays=request.getParameter("appointmentDays")==null?"":request.getParameter("appointmentDays");
		String bookingDays=request.getParameter("bookingDays")==null?"":request.getParameter("bookingDays");
	
		//Ends here
		if (appt_ref_no==null) appt_ref_no="";
		
		String locale=(String)session.getAttribute("LOCALE");
		String facility_id= (String) session.getValue("facility_id"); //Added for Bru-HIMS-CRF-177 linked incident [36705]
		Connection con = null;
		Statement stmt = null;
		Statement stmt1 = null;
		ResultSet rset=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String classValue = "";
		StringBuffer sqlmain=new StringBuffer();
		StringBuffer sql=new StringBuffer();		
		String sql1="";
		//int maxRecord = 0;
		ArrayList op_appt_list=new ArrayList();
		ArrayList ip_book_list=new ArrayList();
		int i=1;
		int t = 1;
		Boolean radBookInFutBokngAppt=false;//Added by Suji Keerthi for ML-MMOH-CRF-1442
try
{
			con = ConnectionManager.getConnection(request);
			stmt=con.createStatement();
			
			radBookInFutBokngAppt = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "RAD_APPT_FROM_OR_ORDER_LINE");//Added by Suji Keerthi for ML-MMOH-CRF-1442
			//java.util.HashMap hm=eMP.ChangePatientDetails.getColorCode(con,facility_id); 	//Adde for this CRF Bru-HIMS-CRF-177 linked incident [36705]
			java.util.HashMap hm=getColorCodeDetails(con);
			sqlmain.append("SELECT APPT_DATE, TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') APPT_SLAB_FROM_TIME, TO_CHAR(APPT_SLAB_TO_TIME,'HH24:MI') APPT_SLAB_TO_TIME, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_SHORT_NAME, AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON, OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') VISIT_TYPE_SHORT_DESC, SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"',1)FACILITY_NAME, AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,'"+locale+"','1') SPECIALITY, APPT_TYPE_CODE,FACILITY_ID FROM OA_APPT WHERE PATIENT_ID='"+patientid+"' and rd_appt_yn='N' ");
			
			//Above Query Modified for this Bru-HIMS-CRF- 177 linked incident [36705]
			//If condition added by S.Sathish for IN020737 on Tuesday, June 08, 2010
			if(calling_from.equals("FM")){
				sqlmain.append("AND TRUNC(APPT_DATE) between TRUNC(SYSDATE) and TRUNC (SYSDATE) + '"+appointmentDays+"' AND NVL(APPT_STATUS,1)!='A'");
			}else{
				sqlmain.append("AND TRUNC(APPT_DATE)>=TRUNC(SYSDATE) AND NVL(APPT_STATUS,1)!='A'");
			}

			if (appt_ref_no.equals(""))
			{
				sqlmain.append(" order by appt_date,appt_slab_from_time ");
			}
			else
			{
				sqlmain.append(" and appt_ref_no != '"+appt_ref_no+"'order by appt_date,appt_slab_from_time ");
			}
			op_appt_list=getOPAppointments(con,stmt,sqlmain,locale);
						

			if(rset !=null) rset.close();
			if(rs !=null) rs.close();
			String ip_installed_yn = "";
			sql1="select nvl(install_yn,'N') install_yn from sm_module where module_id = 'IP'";
			rs=stmt.executeQuery(sql1);
			if(rs!=null){
			if(rs.next())
			   ip_installed_yn = rs.getString("install_yn");
			else
			   ip_installed_yn = "N";
			}else{
				ip_installed_yn = "N";
			}
		  
				if(ip_installed_yn.equals("Y"))   
				{
					if(rs !=null) rs.close();
			

			sql.append("select to_char(preferred_date,'dd/mm/yyyy') booking_date_time, bkg_lst_ref_no, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1')  practitioner_short_name, booking_remarks, SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"',1) facility_name,AM_GET_DESC.AM_SPECIALITY(SPECIALTY_CODE,'"+locale+"','1') SPECIALITY from ip_booking_list where patient_id is not null and patient_id='"+patientid+"' ");
			//If condition added by S.Sathish for IN020737 on Tuesday, June 08, 2010
			if(calling_from.equals("FM")){
				sql.append("and trunc(preferred_date) between trunc(sysdate) and trunc(sysdate) + '"+bookingDays+"' and nvl(booking_status,1)=1 order by preferred_date");
			}else{
				sql.append("and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1 order by preferred_date");
			}
			
			rset=stmt.executeQuery(sql.toString());

			ip_book_list=getIPBookings(con,stmt,sql,locale);
			}

			if (!calling_from.equals("IP"))
			{
				%>

				<table border='1' cellpadding='0' cellspacing='0' width='100%' >
				<tr>
				<td class='CAHIGHERLEVELCOLOR' align = 'left' colspan=9><fmt:message key="Common.OutpatientAppointments.label" bundle="${common_labels}"/></td>
				</tr>
					<tr>
				<td class='CAGROUP' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.totime.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
				</tr>
				<%

					Iterator itr = op_appt_list.iterator();
					
					while(itr.hasNext())
					{
						if ( t % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						%><tr><%
						String row=itr.next().toString();
						String columns[]=row.split("~");
						for(int k=0;k<columns.length;k++)
						{
							
						     /*Below code Added for this CRF Bru-HIMS-CRF -177 linked incident [36705]*/
						    String colour_indicator="", retrivedesc="" ,retrivecode="";
						    String retval=columns[k];							
							if(retval==null ||retval.equals("null"))retval="";	
							if(retval.contains("#")){
							String finalvalue[]=retval.split("#");	
                            if(finalvalue.length==2) {                          						
							retrivedesc =finalvalue[0];	
                            retrivecode=finalvalue[1];  
                            }                          							
							if(retrivecode==null ||retrivecode.equals("null"))retrivecode="";
							if(retrivedesc==null ||retrivedesc.equals("null"))retrivedesc="";
							if(!retrivedesc.equals("")) retval=retrivedesc;
							if(!retrivecode.equals(""))colour_indicator =(String)hm.get(retrivecode);							
							}
						    if(retval==null ||retval.equals("null"))retval="";	 			
			                if(colour_indicator==null ||colour_indicator.equals("null"))colour_indicator="";	
							// End Bru-HIMS-CRF -177
						
							%>
							
							<td  nowrap class='<%=classValue%>' style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;"><%=retval%>
						<%
							
						}
						t++;
					}
%>
			</td></tr></table>
			<BR>
			<BR>

			<table border='1' cellpadding='0' cellspacing='0' width='100%' >
			<td class='CAHIGHERLEVELCOLOR' align='left'><fmt:message key="eIP.inpatientbookings.label" bundle="${ip_labels}"/></td>
			</table>

			<table border='1' cellpadding='0' cellspacing='0' width='100%' >
			<td class='CAGROUP' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<%
				itr = ip_book_list.iterator();
   %>

   <%

				while(itr.hasNext())
				{
					if ( t % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					%><tr><%
					String row=itr.next().toString();
					String columns[]=row.split("~");
					for(int k=0;k<columns.length;k++)
					{
						
						%><td class='<%=classValue%>' nowrap><%=columns[k]%>
					<%
						
					}
					t++;
				}

   
//for( int j=1; j<=maxRecord; i++,j++ )
	%>
	</td></tr>
	</table>
	<BR>
	<BR>
<%
			}
			else{
				

			%>
			<table border='1' cellpadding='0' cellspacing='0' width='100%' >
			<td class='CAHIGHERLEVELCOLOR' align='left'><fmt:message key="eIP.inpatientbookings.label" bundle="${ip_labels}"/></td>
			</table>

			<table border='1' cellpadding='0' cellspacing='0' width='100%' >
			<td class='CAGROUP' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<%
				Iterator itr = ip_book_list.iterator();
   %>

   <%
				while(itr.hasNext())
				{
					if ( t % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					%><tr><%
					String row=itr.next().toString();
					String columns[]=row.split("~");
					for(int k=0;k<columns.length;k++)
					{%><td class='<%=classValue%>' nowrap><%=columns[k]%>
					<%
						
					}
					t++;
				}%>
</td></tr>
</table>
<BR>
<BR>
				<table border='1' cellpadding='0' cellspacing='0' width='100%' >
				<tr>
				<td class='CAHIGHERLEVELCOLOR' align = 'left' colspan=9><fmt:message key="Common.OutpatientAppointments.label" bundle="${common_labels}"/></td>
				</tr>
					<tr>
				<td class='CAGROUP' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.totime.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></td>
				<td class='CAGROUP' nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
				</tr>
				<%
					itr=op_appt_list.iterator();
					while(itr.hasNext())
					{
						if ( t % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						%><tr><%
						String row=itr.next().toString();
						String columns[]=row.split("~");
						for(int k=0;k<columns.length;k++)
						{  
						     /*Below code Added for this CRF Bru-HIMS-CRF -177*/
						    String colour_indicator="", retrivedesc="" ,retrivecode="";
						    String retval=columns[k];							
							if(retval==null ||retval.equals("null"))retval="";	
							if(retval.contains("#")){
							String finalvalue[]=retval.split("#");	
                            if(finalvalue.length==2) {                          						
							retrivedesc =finalvalue[0];	
                            retrivecode=finalvalue[1];  
                            }                          							
							if(retrivecode==null ||retrivecode.equals("null"))retrivecode="";
							if(retrivedesc==null ||retrivedesc.equals("null"))retrivedesc="";
							if(!retrivedesc.equals("")) retval=retrivedesc;
							if(!retrivecode.equals(""))colour_indicator =(String)hm.get(retrivecode);							
							}
						    if(retval==null ||retval.equals("null"))retval="";	 			
			                if(colour_indicator==null ||colour_indicator.equals("null"))colour_indicator="";	
							// End Bru-HIMS-CRF -177
						
							%>
							
							<td  nowrap class='<%=classValue%>' style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;"><%=retval%>
						<%
							
						}
						t++;
					}
}
%>
</td></tr>
</table>


<BR>
<BR>
<%
		if(rset !=null) rset.close();
		if(rs !=null) rs.close();
		String radiology_installed_yn = "";
		sql1="select nvl(install_yn,'N') install_yn from sm_module where module_id = 'RD'";
		rs=stmt.executeQuery(sql1);
		if(rs!=null){
		if(rs.next())
		   radiology_installed_yn = rs.getString("install_yn");
		else
		   radiology_installed_yn = "N";
		}else{
			radiology_installed_yn = "N";
		}

		if(radiology_installed_yn.equals("Y")) 
		{    
			if(rs !=null) rs.close();
			//Below Query Added by Suji Keerthi for ML-MMOH-CRF-1442
            if(radBookInFutBokngAppt)
            {               					
			//sql1="SELECT sm_get_desc.sm_facility_param (a.ordering_facility_id,'"+locale+"',1) FACILITY_NAME,b.APPT_REF_NUM, TO_CHAR (b.appt_date_time,'dd/mm/yyyy') APPT_DATE,b.catalog_desc EXAM_DESC,or_get_desc.or_order_type (b.order_type_code,'"+locale+"',2) SECTION_DESC,TO_CHAR (b.appt_date_time,'hh24:mi') APPT_START_TIME,b.ORDER_LINE_STATUS FROM or_order a, or_order_line b  WHERE a.order_id = b.order_id AND ORDER_LINE_STATUS not in ('CN','RJ') and patient_id='"+patientid+"' AND TRUNC (b.appt_date_time) >= TRUNC (SYSDATE) ";
			sql1="SELECT sm_get_desc.sm_facility_param (a.ordering_facility_id,?,1) FACILITY_NAME,b.APPT_REF_NUM, TO_CHAR (b.appt_date_time,'dd/mm/yyyy') APPT_DATE,b.catalog_desc EXAM_DESC,or_get_desc.or_order_type (b.order_type_code,?,2) SECTION_DESC,TO_CHAR (b.appt_date_time,'hh24:mi') APPT_START_TIME,b.ORDER_LINE_STATUS FROM or_order a, or_order_line b  WHERE a.order_id = b.order_id AND ORDER_LINE_STATUS not in ('CN','RJ') and patient_id=? AND TRUNC (b.appt_date_time) >= TRUNC (SYSDATE) ";
            	
			} else {		
               
			//sql1="SELECT A.OPERATING_FACILITY_ID, A.APPT_REF_NUM, to_char(A.APPT_DATE,'dd/mm/yyyy') APPT_DATE, A.CLINIC_CODE, B.SHORT_DESC CLINIC_DESC, A.EXAM_CODE, C.SHORT_DESC EXAM_DESC, A.SECTION_CODE, D.SHORT_DESC SECTION_DESC, TO_CHAR(A.APPT_START_TIME,'HH24:MI') APPT_START_TIME,TO_CHAR(A.APPT_END_TIME,'HH24:MI') APPT_END_TIME,e.FACILITY_NAME  FROM RD_APPT A, rd_clinic B, rd_exams C, rd_section D,sm_facility_param e  where patient_id='"+patientid+"' and a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and a.clinic_code = b.clinic_code and a.exam_code = c.exam_code and a.section_code = d.section_code AND e.FACILITY_ID=A.OPERATING_FACILITY_ID AND TRUNC (a.appt_date) >= TRUNC (SYSDATE)";//Query modified for the CRF - Bru-HIMS-CRF-154 to select only the future RAD Bookings.
			sql1="SELECT A.OPERATING_FACILITY_ID, A.APPT_REF_NUM, to_char(A.APPT_DATE,'dd/mm/yyyy') APPT_DATE, A.CLINIC_CODE, B.SHORT_DESC CLINIC_DESC, A.EXAM_CODE, C.SHORT_DESC EXAM_DESC, A.SECTION_CODE, D.SHORT_DESC SECTION_DESC, TO_CHAR(A.APPT_START_TIME,'HH24:MI') APPT_START_TIME,TO_CHAR(A.APPT_END_TIME,'HH24:MI') APPT_END_TIME,e.FACILITY_NAME  FROM RD_APPT A, rd_clinic B, rd_exams C, rd_section D,sm_facility_param e  where patient_id=? and a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and a.clinic_code = b.clinic_code and a.exam_code = c.exam_code and a.section_code = d.section_code AND e.FACILITY_ID=A.OPERATING_FACILITY_ID AND TRUNC (a.appt_date) >= TRUNC (SYSDATE)";//Query modified for the CRF - Bru-HIMS-CRF-154 to select only the future RAD Bookings.
			
			}
			
			//rset=stmt.executeQuery(sql1);
			pstmt = con.prepareStatement(sql1);
			if(radBookInFutBokngAppt)
            {  
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,patientid);	
			} else {	
			pstmt.setString(1,patientid);
			}
			rset = pstmt.executeQuery();	
			%>
			<table border='1' cellpadding='0' cellspacing='0' width='100%' >
			<td class='CAHIGHERLEVELCOLOR' align='left'><fmt:message key="eOA.RadiologyBookings.label" bundle="${oa_labels}"/></td>
			</table>

			<table border='1' cellpadding='0' cellspacing='0' width='100%' >
			<td class='CAGROUP' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="eOA.ExamDesc.label" bundle="${oa_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="Common.SectionDescription.label" bundle="${common_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="eOA.ApptStartTime.label" bundle="${oa_labels}"/></td>
			<td class='CAGROUP' nowrap><fmt:message key="eOA.ApptEndTime.label" bundle="${oa_labels}"/></td>

	<%

			String rd_facName="";
			String rd_apptRefNo="";
			String rd_apptDate="";
			String rd_examDesc="";
			String rd_sectionDesc = "";
			String rd_apptStrtTime="";
			String rd_apptEndTime="";


			i=1;
			t=1;
	//		for( int j=1; j<=maxRecord; i++,j++ )
			while ( rset.next() )
			{
				if ( t % 2 == 0 )
				  classValue = "QRYEVEN" ;
				else
				  classValue = "QRYODD" ;

				rd_facName=rset.getString("FACILITY_NAME");
				rd_apptRefNo=rset.getString("APPT_REF_NUM");
				rd_apptDate=rset.getString("APPT_DATE");
				rd_apptDate=DateUtils.convertDate(rd_apptDate,"DMY","en",locale);

				rd_examDesc=rset.getString("EXAM_DESC");
				rd_sectionDesc=rset.getString("SECTION_DESC");
				rd_apptStrtTime = rset.getString("APPT_START_TIME");
				rd_apptStrtTime=DateUtils.convertDate(rd_apptStrtTime,"HM","en",locale);
				//Below added by Suji Keerthi for ML-MMOH-CRF-1442
				if(!radBookInFutBokngAppt){
				rd_apptEndTime = rset.getString("APPT_END_TIME");
				rd_apptEndTime=DateUtils.convertDate(rd_apptEndTime,"HM","en",locale);
				}
				

				%><tr><td class='<%=classValue%>' nowrap><%
				if ( rd_facName != null )
				{
					 out.println(rd_facName);
				}
				else
				{
					%>&nbsp;<%
				}
				%></td><td  class='<%=classValue%>' nowrap><%

				if ( rd_apptRefNo != null )
				{
					out.println(rd_apptRefNo);
				}
				else
				{
					%>&nbsp;<%
				}
				%></td><td  class='<%=classValue%>' nowrap><%
				if ( rd_apptDate != null )
				{

					out.println(rd_apptDate);
				}
				else
				{
					%>&nbsp;<%
				}
				%></td><td class='<%=classValue%>' nowrap><%
				if ( rd_examDesc != null )
				{

					out.println(rd_examDesc);
				}
				else
				{
					%>&nbsp;<%
				}
				%></td><td  class='<%=classValue%>' nowrap><%
				if ( rd_sectionDesc != null )
				{

					out.println(rd_sectionDesc);
				}
				else
				{
					%>&nbsp;<%
				}
				%></td><td class='<%=classValue%>' nowrap><%
				if ( rd_apptStrtTime != null )
				{

					out.println(rd_apptStrtTime);
				}
				else
				{
					%>&nbsp;<%
				}
				%></td><td class='<%=classValue%>' nowrap><%
				if ( rd_apptEndTime != null && !radBookInFutBokngAppt ) //Modified by Suji Keerthi for ML-MMOH-CRF-1442
				{

					out.println(rd_apptEndTime);
				}
				else
				{
					%>&nbsp;<%
				}
				%></td><%
			//	i++;
				t++;
			}
		}

		%>
		</td></tr>
		</table>

		<BR>
		<table border='0' cellpadding='0' cellspacing='0' width='5%' align='right'>
		 <tr>

    	<td align='left' width='2%'><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='exitContact()' class="BUTTON">
		</td>
		</tr>
		</table>
		</body>
		</html>
	<%
	if(rs != null) rs.close();
	if(rset != null) rset.close();
	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1.close();
}catch(Exception e) { 
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

%>

<%!
   HashMap getColorCodeDetails(Connection con1)
    {
		java.sql.Statement colorcodestmt		= null;
        ResultSet colorcoderset				= null; 
		 String colour_indicator_code="",visite_code="",facility="";
		   java.util.HashMap colorhm=new java.util.HashMap ();
	  try{
	   String colour_indicator_query1="select VISIT_TYPE_CODE,FACILITY_ID,COLOR_INDICATOR from op_visit_type"; 	  
       colorcodestmt = con1.createStatement();				 
		colorcoderset = colorcodestmt.executeQuery(colour_indicator_query1);
		  while( colorcoderset != null && colorcoderset.next()){
		            String visitcode_facility=""; 
				    visite_code=colorcoderset.getString("VISIT_TYPE_CODE")==null?"":colorcoderset.getString("VISIT_TYPE_CODE");
					facility=colorcoderset.getString("FACILITY_ID")==null?"":colorcoderset.getString("FACILITY_ID");					
				    colour_indicator_code=colorcoderset.getString("COLOR_INDICATOR")==null?"":colorcoderset.getString("COLOR_INDICATOR");
					visitcode_facility=visite_code+facility;
                    if(visitcode_facility==null || visitcode_facility.equals("null")) visitcode_facility="";					
				    colorhm.put(visitcode_facility,colour_indicator_code);									
		  }			
          if(colorcodestmt!=null) colorcodestmt.close();					
		  if(colorcoderset !=null)colorcoderset.close();
	  
	  }catch(Exception e){
	e.printStackTrace();
	}
	   return colorhm;
		
		
		
	}	
		%>

