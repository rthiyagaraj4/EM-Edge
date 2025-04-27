<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String fac_id		= (String) session.getValue( "facility_id" ) ;
StringBuffer sql = new StringBuffer("");
String locale = (String)session.getAttribute("LOCALE");
	int maxRecord = 0;

String dayno	=	request.getParameter("dayno") ;
String loccode	=	request.getParameter("loccode") ;
String practcode=	request.getParameter("practcode") ;
String care_locn=	request.getParameter("care_locn") ;
String resource_type=	request.getParameter("resource_type") ;
String speciality=	request.getParameter("speciality") ;
if(dayno == null || dayno.equals("null"))	dayno = "";
if(loccode == null || loccode.equals("null"))	loccode = "";
if(practcode == null || practcode.equals("null"))	practcode = "";
if(care_locn == null || care_locn.equals("null"))	care_locn = "";
if(resource_type == null || resource_type.equals("null"))	resource_type = "";
if(speciality == null || speciality.equals("null"))	speciality = "";

String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
String classValue	 = "";
int start = 0 ;
int end = 0 ;
int i=1;

if ( from == null )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to == null )
	end = 14 ;
else
	end = Integer.parseInt( to ) ;


Statement stmt				= null;
ResultSet rs				= null;
Connection conn = null;	

try {
	conn = ConnectionManager.getConnection(request);	
	stmt = conn.createStatement();
	%>
	<HTML>
	<head>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script src="../../eOA/js/QueryLocnForDay.js"></script>
	
	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
		</head>
	<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
	<form name='QueryLocnForDayResult' id='QueryLocnForDayResult'>

	<%
	
	//sql.append(" where facility_id = '"+fac_id+"' and day_no = nvl('"+dayno+"',day_no) and clinic_code = nvl('"+loccode+"',clinic_code)and CARE_LOCN_TYPE_IND = nvl('"+care_locn+"',CARE_LOCN_TYPE_IND)and RESOURCE_CLASS = nvl('"+resource_type+"',RESOURCE_CLASS) and nvl(practitioner_id,'X') = nvl('"+practcode+"',nvl(practitioner_id,'X')) ") ;
    if(!speciality.equals(""))
	{
		sql.append(" WHERE a.facility_id = b.facility_id AND b.SPECIALITY_CODE='"+speciality+"' AND a.CLINIC_CODE=b.CLINIC_CODE AND a.facility_id = '"+fac_id+"' AND a.day_no = NVL('"+dayno+"',a.day_no) AND a.clinic_code = NVL('"+loccode+"',a.clinic_code) AND a.CARE_LOCN_TYPE_IND = NVL('"+care_locn+"',a.CARE_LOCN_TYPE_IND)AND a.RESOURCE_CLASS = NVL('"+resource_type+"',a.RESOURCE_CLASS) AND NVL(a.practitioner_id,'X') = NVL('"+practcode+"',NVL(a.practitioner_id,'X')) ");
	}
	sql.append(" order by 1,3,6") ;

	if (rs!=null) rs.close();
	rs = stmt.executeQuery("SELECT a.day_no,(SELECT day_of_week FROM SM_DAY_OF_WEEK WHERE day_no = a.day_no) day_of_week,a.CARE_LOCN_TYPE_IND,a.RESOURCE_CLASS,  OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.CLINIC_CODE,'"+locale+"','1') clinic_name, DECODE(a.resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(a.FACILITY_ID, a.PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, TO_CHAR(a.start_time,'hh24:mi') start_time, TO_CHAR(a.end_time,'hh24:mi') end_time, a.max_patients_per_day, NVL(a.max_over_booking,0) max_over_booking, a.phys_roster_reqd_yn roster_reqd, a.alcn_criteria,a.clinic_code,a.practitioner_id,a.srl_no,AM_GET_DESC.AM_SPECIALITY(b.SPECIALITY_CODE,'"+locale+"','2')  SPECIALITY_DESC FROM OA_CLINIC_TIME_TABLE a, OP_CLINIC b "+sql.toString());
	
			 if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
				rs.next() ;
			}

			if ( rs != null ){
				while ( i<=end && rs.next() )
				{
					if(maxRecord==0)
					{
			%>
			<P>
			<table align='right'>
			<tr>
		<%	if ( !(start <= 1) )
				out.println("<td align ='right' id='prev'><A HREF='../../eOA/jsp/QueryLocnForDayResult.jsp?dayno="+dayno+"&care_locn="+care_locn+"&resource_type="+resource_type+"&loccode="+loccode+"&practcode="+practcode+"&speciality="+speciality+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//	if ( !( (start+14) > maxRecord ) )
				out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/QueryLocnForDayResult.jsp?dayno="+dayno+"&care_locn="+care_locn+"&resource_type="+resource_type+"&loccode="+loccode+"&practcode="+practcode+"&speciality="+speciality+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

			sql.setLength(0);
			%>
			</tr>
			</table><br>
			</P>
			<table border="1" width="100%" cellspacing='0' cellpadding='0'>

			<td class='COLUMNHEADER'><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
            <td class='COLUMNHEADER'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.Start.label" bundle="${common_labels}"/><br><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.End.label" bundle="${common_labels}"/><br><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.Max.label" bundle="${common_labels}"/><br><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.Max.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOA.OB.label" bundle="${oa_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="eOA.Roster.label" bundle="${oa_labels}"/><br><fmt:message key="Common.required.label" bundle="${common_labels}"/>?</td>
			
			<% }

			
		
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
					classValue = "QRYODD" ;

					String alcn_criteria = rs.getString("alcn_criteria");
					if(alcn_criteria==null || alcn_criteria.equals("null"))
					   alcn_criteria = "";

					String srl_no = rs.getString("srl_no");
					
					String day_no = rs.getString("day_no");
					String CARE_LOCN2 = rs.getString("CARE_LOCN_TYPE_IND");
					
					/*Rameez for OA - IN#35850 on 23-10-2012 -Begins*/
					//Removed 'CARE_LOCN_TYPE_DESC' from the query 
					String CARE_LOCTYPE="";
					if(CARE_LOCN2.equals("C"))
						CARE_LOCTYPE = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
					else if(CARE_LOCN2.equals("E"))
						CARE_LOCTYPE = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
					else if(CARE_LOCN2.equals("D"))
						CARE_LOCTYPE = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
					/*Rameez for OA - IN#35850 on 23-10-2012 -Ends*/	
						
					String clinic_code = rs.getString("clinic_code");
					String speciality_desc =rs.getString("SPECIALITY_DESC");
					if(speciality_desc==null || speciality_desc.equals("null"))
					   speciality_desc = "";
					String practitioner_id = rs.getString("practitioner_id");
					if(practitioner_id==null || practitioner_id.equals("null"))
					   practitioner_id = "";
						   
					String practname=rs.getString("practitioner_name");
					if(practname==null || practname.equals("null"))
						practname="&nbsp;";
					String resource_code=rs.getString("RESOURCE_CLASS");
					String res_class_desc="";
			if(resource_code.equals("P"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(resource_code.equals("E"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(resource_code.equals("R"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(resource_code.equals("O"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}

			String day_of_week_desc="";
			String day_of_week= rs.getString("day_of_week");
			
			if(day_of_week.equals("MONDAY"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(day_of_week.equals("TUESDAY"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(day_of_week.equals("WEDNESDAY"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(day_of_week.equals("THURSDAY"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(day_of_week.equals("FRIDAY"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(day_of_week.equals("SATURDAY"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(day_of_week.equals("SUNDAY"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

					out.println("<tr><td align='left' class='"+classValue+"'>");
					out.println(day_of_week_desc);
					out.println("</td>");
					/*Rameez for OA - IN#35850 on 23-10-2012 -Begins*/
					//out.println("<td class='"+classValue+"'>" + rs.getString("CARE_LOCN_TYPE_DESC")+"</td>");
					out.println("<td class='"+classValue+"'>" + CARE_LOCTYPE +"</td>"); 
					/*Rameez for OA - IN#35850 on 23-10-2012 -Ends*/
					out.println("<td class='"+classValue+"'>" + rs.getString("clinic_name")+"</td>");
					out.println("<td class='"+classValue+"'>" + rs.getString("SPECIALITY_DESC")+"</td>");
					out.println("<td class='"+classValue+"'>" +res_class_desc+"</td>");
					out.println("<td class='"+classValue+"'>"+practname+"</td>");

					out.println("<td class='"+classValue+"'>"+rs.getString("start_time")+"</td>");
					out.println("<td class='"+classValue+"'>"+rs.getString("end_time")+"</td>");
					out.println("<td align='center' class='"+classValue+"'>");

					if(alcn_criteria == null || alcn_criteria.equals("") || alcn_criteria.equals("null"))
					{
						 out.println(rs.getString("max_patients_per_day"));
						 out.println("&nbsp;");
					}else{
						 %>
						 <a href="javascript:show_allocation_details('<%=alcn_criteria%>','<%=CARE_LOCN2%>','<%=resource_type%>','<%=srl_no%>','<%=day_no%>','<%=clinic_code%>','<%=practitioner_id%>')">  
						 <%
						out.println(rs.getString("max_patients_per_day")+"<a>");
						out.println("&nbsp;");
					}

					out.println("</td>");
									
					out.println("<td align='center' class='"+classValue+"'>"+rs.getString("max_over_booking")+"</td>");
					out.println("<td class='"+classValue+"' align='center'>");

					if (rs.getString("roster_reqd").equalsIgnoreCase("Y"))
					{
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					}
					else
					{
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
					}
					out.println("</td>") ;
					out.println("</tr>");

					i++;
					maxRecord++;
				}// while
		}
	%>
	</table>
	<br><center>
	<%
//	}// outermost if

	if(maxRecord == 0)
	{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
	<%}

	if ( maxRecord < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<%
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}

	if ( rs != null ) rs.close() ;
	if ( stmt != null ) stmt.close() ;
}
catch ( Exception e ){
	e.printStackTrace();
	//out.println("Exception  "+  e);
}

finally{

	if (conn !=null) ConnectionManager.returnConnection(conn,request);
	}
%>
</center>
<script>
parent.frames[1].document.forms[0].select.disabled=false;
</script>

</form>
</body>
</html>

