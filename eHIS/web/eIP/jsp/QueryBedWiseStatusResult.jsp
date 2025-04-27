<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,java.net.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");  %>
<%	
	String facilityid = (String)session.getValue("facility_id");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
	StringBuffer sql	= new StringBuffer();
	int maxRecord		= 0;
	int start			= 1;
	int end				= 0;
	int records_to_show = 25;
	String sex			= "";
	String statusDsply	= "";
	String preferred_date = "";
	String visit_adm_date_time = "";
	String exp_discharge_date_time = "";
	//String discharge_date_time = "";

	String from					= request.getParameter("from");
	String to					= request.getParameter("to");
	String locale				= (String)session.getAttribute("LOCALE");
	String nursing_unit_code	= checkForNull(request.getParameter("nursing_unit_code"));
	String from_date			= checkForNull(request.getParameter("from_date"));
	String to_date				= checkForNull(request.getParameter("to_date"));
	String from_date_converted	= "";
	String to_date_converted	= "";
	if(!(from_date.equals("") || from_date == null))
			from_date_converted = DateUtils.convertDate(from_date,"DMYHM",locale,"en"); 

	if(!(to_date.equals("") || to_date == null))
			to_date_converted = DateUtils.convertDate(to_date,"DMYHM",locale,"en"); 
		
	StringBuffer whereClause	= new StringBuffer();
	whereClause.append(checkForNull(request.getParameter("whereclause")));

	//String prevsplty = "";
	String className = "";
	String status = "";
	
	int i = 0;
%>
</head>							
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%	
try
{
	con = ConnectionManager.getConnection(request);

	/*sql.append(" select (CASE WHEN a.occupying_patient_id IS not null THEN 'O' ELSE 'V' END) status, a.occupying_patient_id patient_id, c.patient_name patient_name, c.sex sex, a.nursing_unit_code nursing_unit_code, a.bed_no bed_no, a.room_no room_no, ");	
	sql.append(" NULL preferred_date, ");
	sql.append(" to_char(b.ADMISSION_DATE_TIME,'dd/mm/rrrr hh24:mi') visit_adm_date_time,");
	sql.append(" to_char(b.EXP_DISCHARGE_DATE_TIME,'dd/mm/rrrr hh24:mi') exp_discharge_date_time ");
	sql.append(" ,null booking_ref_no ");
	sql.append(" ,ip_get_desc.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc ");
	sql.append(" ,ip_get_desc.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') bed_type_short_desc ");
	sql.append(" ,am_get_desc.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specialty_short_desc ");
	sql.append(" FROM ");
	sql.append(" IP_NURSING_UNIT_BED A , IP_OPEN_ENCOUNTER B ,MP_PATIENT C");
	sql.append(" WHERE ");
	sql.append(" a.facility_id = '"+facilityid+"' and a.nursing_unit_code='"+nursing_unit_code+"' and a.facility_id = b.facility_id (+) and a.nursing_unit_Code = b.NURSING_UNIT_CODE (+) and a.occupying_patient_id = b.patient_id (+) and a.occupying_patient_id = c.patient_id (+) ");
	sql.append(" UNION ALL ");
	sql.append(" select 'B' Status, bkglst.patient_id patient_id, bkglst.patient_name patient_name, bkglst.gender sex, bkglst.nursing_unit_code nursing_unit_code, bkg.req_bed_no bed_no, bkg.req_room_no room_no, ");
	sql.append(" to_char(bkglst.PREFERRED_DATE,'dd/mm/rrrr hh24:mi') PREFERRED_DATE,");
	sql.append(" NULL VISIT_ADM_DATE_TIME,");
	sql.append(" to_char(bkglst.expected_discharge_date,'dd/mm/rrrr hh24:mi')EXP_DISCHARGE_DATE_TIME, ");
	sql.append(" bkglst.bkg_lst_ref_no booking_ref_no ");
	sql.append(" ,ip_get_desc.IP_BED_CLASS(bkg.req_bed_class_code,'"+locale+"','2') bed_class_short_desc ");
	sql.append(" ,ip_get_desc.IP_BED_TYPE(bkg.req_bed_type_code,'"+locale+"','2') bed_type_short_desc ");
	sql.append(" ,am_get_desc.AM_SPECIALITY(bkg.req_specialty_code,'"+locale+"','2') specialty_short_desc ");
	sql.append(" FROM ");
	sql.append(" IP_BOOKING_LIST bkglst, IP_BED_BOOKING bkg, MP_PATIENT pat ");
	sql.append(" WHERE ");
	sql.append(" trunc(bkglst.preferred_date) between to_date('"+from_date_converted+"','dd/mm/rrrr') and to_date('"+to_date_converted+"','dd/mm/rrrr') and bkglst.booking_status in ('0','1') and pat.patient_id (+) = bkglst.patient_id and bkglst.facility_id  = bkg.facility_id (+) and bkglst.bkg_lst_ref_no = bkg.bed_booking_ref_no (+) and bkglst.facility_id = '"+facilityid+"' and bkglst.nursing_unit_code='"+nursing_unit_code+"' and bkglst.bed_no is not null ");
	sql.append(" order by room_no, status ");*/

	sql.append(" SELECT  (CASE WHEN a.occupying_patient_id IS NOT NULL ");
	/*Monday, October 25, 2010 ,SRR20056-SCF-5581,IN024324 to display occupied bed as vacant when from date is greater than EDD */
	sql.append("  AND ((b.exp_discharge_date_time) >= TO_DATE ('"+from_date_converted+"', 'dd/mm/rrrr hh24:mi') OR (b.exp_discharge_date_time) IS NULL ) ");
	sql.append(" THEN 'O' when (select 1 from ip_reserved_bed_dtl where facility_id = a.facility_id and reserved_nursing_unit_code = a.nursing_unit_code and reserved_bed_no = a.bed_no ");
	//Monday, October 25, 2010 SRR20056-SCF-5666-IN024457 , to display reserved_bed as vacant when blocked_until_date_time > SYSDATE
	sql.append(" AND reserved_bed_no IN (SELECT req_bed_no  FROM ip_bed_booking  WHERE booking_status IN ('0', '1') AND facility_id = '"+facilityid+"' AND req_nursing_unit_code = '"+nursing_unit_code+"' AND booking_type = 'N' AND (   blocked_until_date_time IS NULL OR blocked_until_date_time >= TO_DATE ('"+from_date_converted+"', 'dd/mm/rrrr hh24:mi') ))");
	sql.append(" and reserved_to_time is null and rownum < 2) = 1 then 'N' ELSE 'V' END) status, (CASE WHEN a.occupying_patient_id IS NOT NULL THEN a.occupying_patient_id ELSE D.patient_id END) patient_id, NVL(c.patient_name,D.PATIENT_NAME) patient_name, nvl(c.sex, d.sex) sex, a.nursing_unit_code nursing_unit_code, a.bed_no bed_no, a.room_no room_no, ");	
	sql.append(" NULL preferred_date, ");
	sql.append(" to_char(NVL(b.ADMISSION_DATE_TIME,D.ADMISSION_DATE_TIME),'dd/mm/rrrr hh24:mi') visit_adm_date_time,");
	sql.append(" to_char(NVL(b.EXP_DISCHARGE_DATE_TIME,D.EXP_DISCHARGE_DATE_TIME),'dd/mm/rrrr hh24:mi') exp_discharge_date_time ");
	sql.append(" ,null booking_ref_no ");
	sql.append(" ,ip_get_desc.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc ");
	sql.append(" ,ip_get_desc.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') bed_type_short_desc ");
	sql.append(" ,  (CASE WHEN a.occupying_patient_id IS NOT NULL THEN am_get_desc.am_speciality(b.specialty_code,'"+locale+"','2') WHEN (select 1 from ip_reserved_bed_dtl where facility_id = a.facility_id and reserved_nursing_unit_code = a.nursing_unit_code AND reserved_bed_no = a.bed_no");
	//Monday, October 25, 2010 SRR20056-SCF-5666-IN024457 , to get specialty_code for reserved_bed
	sql.append(" AND reserved_bed_no IN (SELECT req_bed_no  FROM ip_bed_booking  WHERE booking_status IN ('0', '1') AND facility_id = '"+facilityid+"' AND req_nursing_unit_code = '"+nursing_unit_code+"' AND booking_type = 'N' ");
	sql.append (" AND (   blocked_until_date_time IS NULL OR blocked_until_date_time >= TO_DATE ('"+from_date_converted+"', 'dd/mm/rrrr hh24:mi') ) )");
	sql.append(" and reserved_to_time is null AND ROWNUM < 2) = 1 THEN am_get_desc.am_speciality(d.specialty_code,'"+locale+"','2') ELSE am_get_desc.am_speciality(a.specialty_code,'"+locale+"','2') END) specialty_short_desc ");
	sql.append(" FROM ");
	sql.append(" IP_NURSING_UNIT_BED A , IP_OPEN_ENCOUNTER B ,MP_PATIENT C ");
	sql.append(", (select A.FACILITY_ID, A.REQ_NURSING_UNIT_CODE, A.REQ_BED_NO, a.encounter_id,C.ADMISSION_DATE_TIME,C.EXP_DISCHARGE_DATE_TIME,A.PATIENT_ID, B.PATIENT_NAME, B.SEX,a.req_specialty_code specialty_code from IP_BED_BOOKING A, MP_PATIENT B, IP_OPEN_ENCOUNTER C where A.booking_status in ('0','1') and A.facility_id = '"+facilityid+"' and A.req_nursing_unit_code='"+nursing_unit_code+"' and A.booking_type = 'N' and (A.blocked_until_Date_time is null or A.blocked_until_Date_time > sysdate) AND A.PATIENT_ID = B.PATIENT_ID AND A.FACILITY_ID = C.FACILITY_ID AND A.ENCOUNTER_ID = C.ENCOUNTER_ID  ");
	/*Monday, October 11, 2010 ,SRR20056-SCF-5581,IN024324*/
	//sql.append("AND TRUNC (BOOKING_DATE_TIME) BETWEEN TO_DATE ('"+from_date_converted+"','dd/mm/rrrr') AND TO_DATE ('"+to_date_converted+"','dd/mm/rrrr' ) ");
	sql.append(" ) D ");
	sql.append(" WHERE ");
	sql.append(" a.facility_id = '"+facilityid+"' and a.nursing_unit_code='"+nursing_unit_code+"' and a.facility_id = b.facility_id (+) and a.nursing_unit_Code = b.NURSING_UNIT_CODE (+) and a.occupying_patient_id = b.patient_id (+) and a.occupying_patient_id = c.patient_id (+) ");
	sql.append(" and a.facility_id = d.facility_id (+) and a.nursing_unit_code = d.req_nursing_unit_code (+) and a.bed_no = d.req_bed_no (+) ");
	//Tuesday, November 30, 2010 ,  SRR20056-SCF-6098 [IN:025257] ,added to get reserved bed which is booked earliar before reserving , and to restrict vacant beds which are booked
	sql.append(" AND a.bed_no NOT IN (SELECT req_bed_no FROM ip_bed_booking WHERE BOOKING_STATUS IN ('0', '1')	AND facility_id = '"+facilityid+"' AND booking_type = 'L'  AND REQ_NURSING_UNIT_CODE = a.nursing_unit_code AND REQ_BED_NO = a.BED_NO  AND   (   TO_DATE ('"+from_date_converted+"', 'dd/mm/rrrr hh24:mi') BETWEEN blocked_from_date_time AND blocked_until_date_time  OR TO_DATE ('"+to_date_converted+"', 'dd/mm/rrrr hh24:mi')  BETWEEN blocked_from_date_time  AND blocked_until_date_time  ) and a.occupying_patient_id is null AND req_bed_no NOT IN(SELECT req_bed_no FROM ip_bed_booking WHERE booking_status IN('0', '1') AND booking_type = 'N' AND facility_id = '"+facilityid+"' AND req_nursing_unit_code = a.nursing_unit_code AND req_bed_no = a.bed_no AND TO_DATE('"+from_date_converted+"', 'dd/mm/rrrr hh24:mi') >= blocked_from_date_time AND (TO_DATE('"+to_date_converted+"', 'dd/mm/rrrr hh24:mi') >=  blocked_until_date_time OR blocked_until_date_time IS NULL) AND a.occupying_patient_id IS NULL)) ");
	sql.append("and trunc(a.added_date) <= to_date('"+to_date_converted+"','dd/mm/rrrr hh24:mi')");/*20219 Thursday, March 25, 2010 */
	sql.append(" UNION ALL ");
	sql.append(" select 'B' Status, bkglst.patient_id patient_id, bkglst.patient_name patient_name, bkglst.gender sex, bkglst.nursing_unit_code nursing_unit_code, bkg.req_bed_no bed_no, bkg.req_room_no room_no, ");
	sql.append(" to_char(bkglst.PREFERRED_DATE,'dd/mm/rrrr hh24:mi') PREFERRED_DATE,");
	sql.append(" NULL VISIT_ADM_DATE_TIME,");
	sql.append(" to_char(bkglst.expected_discharge_date,'dd/mm/rrrr hh24:mi')EXP_DISCHARGE_DATE_TIME, ");
	sql.append(" bkglst.bkg_lst_ref_no booking_ref_no ");
	sql.append(" ,ip_get_desc.IP_BED_CLASS(bkg.req_bed_class_code,'"+locale+"','2') bed_class_short_desc ");
	sql.append(" ,ip_get_desc.IP_BED_TYPE(bkg.req_bed_type_code,'"+locale+"','2') bed_type_short_desc ");
	sql.append(" ,am_get_desc.AM_SPECIALITY(bkg.req_specialty_code,'"+locale+"','2') specialty_short_desc ");
	sql.append(" FROM ");
	sql.append(" IP_BOOKING_LIST bkglst, IP_BED_BOOKING bkg ");
	sql.append(" WHERE ");
	//sql.append("  bkglst.preferred_date between to_date('"+from_date_converted+"','dd/mm/rrrr hh24:mi') and to_date('"+to_date_converted+"','dd/mm/rrrr hh24:mi')  ");
	/*Tuesday, February 08, 2011 , SRR20056-SCF-6784 [IN:026334] point 10*/
	sql.append(" ( bkglst.preferred_date between to_date('"+from_date_converted+"','dd/mm/rrrr hh24:mi') and to_date('"+to_date_converted+"','dd/mm/rrrr hh24:mi')  ");
	sql.append(" or TO_DATE ('"+from_date_converted+"', 'dd/mm/rrrr hh24:mi') BETWEEN bkg.blocked_from_date_time AND bkg.blocked_until_date_time  OR TO_DATE ('"+to_date_converted+"', 'dd/mm/rrrr hh24:mi') BETWEEN bkg.blocked_from_date_time  AND bkg.blocked_until_date_time )  ");
	/**/
	sql.append(" and bkglst.booking_status in ('0','1') and bkglst.facility_id  = bkg.facility_id (+) and bkglst.bkg_lst_ref_no = bkg.bed_booking_ref_no (+) and bkglst.facility_id = '"+facilityid+"' and bkglst.nursing_unit_code='"+nursing_unit_code+"' and bkglst.bed_no is not null ");
	//condition added for query tuning
	sql.append(" and bkg.booking_type = 'L' ");
	sql.append(" order by room_no, bed_no , status ");

	stmt = con.createStatement();

	rs = stmt.executeQuery(sql.toString());

	if ( from == null )
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;
	
	if ( to == null )
		end = records_to_show ;
	else
		end = Integer.parseInt( to ) ;
	
	if(start > 1)
	{
		for(int k=0; k < start ;k++)
			rs.next();
	}

	int z=0;
		
	while((z < records_to_show) && rs.next())
	{
		if(maxRecord==0)
		{
			out.println("<p><table align='right'><tr>");
			if ( !(start <= 0) )
				out.println("<td id='prev' align='right'><A HREF='../jsp/QueryBedWiseStatusResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&nursing_unit_code="+nursing_unit_code+"&from_date="+from_date+"&to_date="+to_date+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

			out.println("<td id='next' style='visibility:hidden' align='right'><A HREF='../jsp/QueryBedWiseStatusResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&nursing_unit_code="+nursing_unit_code+"&from_date="+from_date+"&to_date="+to_date+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

			out.println("</tr></table></p>");
			out.println("<br><br>");
			out.println("<table cellpadding=0 cellspacing=0 border=1 width='150%'>");

			out.println("<tr><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"&nbsp;"+"</th>");
		
			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedstatus.label","common_labels")+"&nbsp;"+"</th>");

			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th>");

			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th>");

			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"</th>");

			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingRefNo.label","common_labels")+"&nbsp;"+"</th>");

			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PrefAdmDateTime.label","ip_labels")+"&nbsp;"+"</th>");
			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExpectedDischargeDateTime.label","ip_labels")+"&nbsp;"+"</th>");
			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","Common_labels")+"&nbsp;"+"</th>");

			///*20219 Thursday, March 25, 2010 */out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargedatetime.label","Common_labels")+"&nbsp;"+"</th></tr>");
						
		}
				
		z++;
		if(i%2 == 0)
			className = "QRYEVEN";
		else
			className = "QRYODD";

		sex = checkForNull(rs.getString("sex"));
		if(sex.equalsIgnoreCase("M"))
			sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if(sex.equalsIgnoreCase("F"))
			sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		else if (rs.getString("patient_id") != null)
			sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		else
			sex ="&nbsp;";

		preferred_date = rs.getString("PREFERRED_DATE");
		if(preferred_date == null)
			preferred_date = "&nbsp;";
		else
			preferred_date = DateUtils.convertDate(preferred_date,"DMYHM","en",locale);

		visit_adm_date_time = rs.getString("VISIT_ADM_DATE_TIME");
		if(visit_adm_date_time == null)
			visit_adm_date_time = "&nbsp;";
		else
			visit_adm_date_time = DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);

		exp_discharge_date_time = rs.getString("EXP_DISCHARGE_DATE_TIME");
		if(exp_discharge_date_time == null)
			exp_discharge_date_time = "&nbsp;";
		else
			exp_discharge_date_time = DateUtils.convertDate(exp_discharge_date_time,"DMYHM","en",locale);


		status = rs.getString("status");
		
		if(status.equals("O"))
			statusDsply = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Occupied.label","Common_labels");
		else if(status.equals("V"))
			statusDsply = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Vacant.label","common_labels");
		else if(status.equals("B"))
			statusDsply = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booked.label","common_labels");
		else if(status.equals("N"))
			statusDsply = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reserved.label","common_labels");


		out.println("<tr>");
		if(status.equals("V"))
		{
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("room_no"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("bed_no"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+statusDsply+"</td>");
			out.println("<td class='"+className+"' nowrap>&nbsp;</td>");
			out.println("<td class='"+className+"' nowrap>&nbsp;</td>");
			out.println("<td class='"+className+"' nowrap>&nbsp;</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("bed_class_short_desc"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("bed_type_short_desc"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>&nbsp;</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("booking_ref_no"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>&nbsp;</td>");
			out.println("<td class='"+className+"' nowrap>&nbsp;</td>");	
			out.println("<td class='"+className+"' nowrap>&nbsp;</td>");

		
		}else
		{
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("room_no"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("bed_no"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+statusDsply+"</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("patient_id"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("patient_name"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+sex+"</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("bed_class_short_desc"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("bed_type_short_desc"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("specialty_short_desc"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+checkForNull(rs.getString("booking_ref_no"),"&nbsp;")+"</td>");
			out.println("<td class='"+className+"' nowrap>"+preferred_date+"</td>");
			out.println("<td class='"+className+"' nowrap>"+exp_discharge_date_time+"</td>");	
			out.println("<td class='"+className+"' nowrap>"+visit_adm_date_time+"</td>");
		}
		///*20219 Thursday, March 25, 2010 */out.println("<td class='"+className+"' nowrap>&nbsp;</td>");/*Wednesday, January 06, 2010 , IN017872 , Since  for open encounter Discharge Date/Time will not be present in IP_OPEN_ENCOUNTER */
		out.println("</tr>");

		i++;
		maxRecord++;
	}
	out.println("</table>");

		
	if ( maxRecord < 14 || (!rs.next()) )
	{
		%>
		<script>
		if(document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
		<% 
	}
	else
	{	%>
		<script>
		if(document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
		<%
	}

	if(maxRecord==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
	}

	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	}catch(Exception e) 
	{
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
		out.print("<script>if(parent.frames[1].document.forms[0]!= null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
	}
%>
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

