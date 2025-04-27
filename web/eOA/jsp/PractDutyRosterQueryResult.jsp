<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<HTML><head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>  -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head>
<BODY  onmousedown= 'CodeArrest' class='CONTENT' onKeyDown = 'lockKey()'>
<!--onLoad='Clear_Msg()'-->
<%
request.setCharacterEncoding("UTF-8");
StringBuffer where1=new StringBuffer();	
String whereClause = request.getParameter("whereclause");
where1=where1.append(whereClause);
StringBuffer sql=new StringBuffer() ;
String from = request.getParameter( "from" ) ;

String to = request.getParameter( "to" ) ;
String locale=(String)session.getAttribute("LOCALE");

if ( (whereClause == null || whereClause.equals("")) ){
	
	String carelocn1 = request.getParameter("care_locn_type_ind");
	String ccode = request.getParameter("clinic_code1");
	String cdesc = request.getParameter("clinic_desc");
	String resource = request.getParameter("resource_class");
	
	String day_of_week = request.getParameter("day_of_week");
	String resource2 =request.getParameter("practitioner_Id");
	String practname =request.getParameter("practitioner_name");
	String practitionername = practname.toUpperCase();
	resource2 = resource2.toUpperCase();
	carelocn1 = carelocn1.toUpperCase();
	resource = resource.toUpperCase();
	String locncode = ccode.toUpperCase();
	String locndesc = cdesc.toUpperCase();
	

	if ( !(resource2 == null || resource2.equals("")) ){
		resource2=resource2.toUpperCase();
		sql.append(" and UPPER(practitioner_id)  like '"+resource2+"%'");
	}

	if ( !(practitionername == null || practitionername.equals("")) ){
		sql.append(" and upper(AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1')) like '"+practitionername+"%'");
	}

	if ( !(locncode == null || locncode.equals("")) ){
		sql.append(" and UPPER(clinic_code) like  '"+locncode+"%'") ;
	}

	if ( !(locndesc == null || locndesc.equals("")) ){
		sql.append(" and UPPER(op_get_desc.op_clinic(facility_id, clinic_code,'"+locale+"','1'))  like '"+locndesc+"%'" );
	}

	if(!(day_of_week == null || day_of_week.equals("")) ){
		sql.append(" and to_char(ON_DUTY_DATE,'d') = '"+day_of_week+"'");
	}

	if(!(carelocn1 == null || carelocn1.equals("")) ){
			sql.append(" and to_char(CARE_LOCN_TYPE_IND) = '"+carelocn1+"'");
	}

	if (resource!=null && !resource.equals("") && !resource.equals("0")){
		   resource = resource.toUpperCase();
		   sql.append(" and upper(resource_class) = '"+resource+"' ");
	}


	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) ){
		sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ ){
	
			if ( i == ord.length - 1 )
				sql.append(ord[i]);
			else
				sql.append(ord[i]+",");
		}
	}
}else{     //end of where clause IF
	sql.append(where1);
}

where1.setLength(0);

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

Statement stmt=null;
ResultSet rs=null;
Connection conn=null;
PreparedStatement pstmt=null;
int maxRecord = 0;
try{

	conn = ConnectionManager.getConnection(request);
	String facilityId = (String) session.getValue("facility_id");

	stmt=conn.createStatement();
	StringBuffer strsql2=new StringBuffer("");
	
	/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
	//strsql2.append("select practitioner_id, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, resource_class, clinic_code, op_get_desc.op_clinic(facility_id, clinic_code,'"+locale+"','1') clinic_name, am_get_desc.am_care_locn_type(care_locn_type_ind,'"+locale+"','1') care_locn_type_desc, care_locn_type_ind, resource_class rsource, to_char(on_duty_date,'dd/mm/yyyy') on_duty_date, initcap(to_char(on_duty_date,'day')) on_duty_day from oa_roster_for_pract where facility_id='"+facilityId+"'");
	
	/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
	//strsql2.append("select practitioner_id, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, resource_class, clinic_code, op_get_desc.op_clinic(facility_id, clinic_code,'"+locale+"','1') clinic_name, am_get_desc.am_care_locn_type(care_locn_type_ind,'"+locale+"','1') care_locn_type_desc, care_locn_type_ind, resource_class rsource, to_char(on_duty_date,'dd/mm/yyyy') on_duty_date, initcap(to_char(on_duty_date,'day')) on_duty_day from oa_roster_for_pract_vw where facility_id='"+facilityId+"' AND (eff_status != 'D' OR eff_status IS NULL)");	
	//strsql2.append(sql.toString());
	//rs = stmt.executeQuery(strsql2.toString());
	String sql1 = "select practitioner_id, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) practitioner_name, resource_class, clinic_code, op_get_desc.op_clinic(facility_id, clinic_code,?,'1') clinic_name, am_get_desc.am_care_locn_type(care_locn_type_ind,?,'1') care_locn_type_desc, care_locn_type_ind, resource_class rsource, to_char(on_duty_date,'dd/mm/yyyy') on_duty_date, initcap(to_char(on_duty_date,'day')) on_duty_day from oa_roster_for_pract_vw where facility_id=? AND (eff_status != 'D' OR eff_status IS NULL)";
	pstmt = conn.prepareStatement(sql1);
	pstmt.setString(1,locale);
	pstmt.setString(2,locale);
	pstmt.setString(3,locale);
	pstmt.setString(4,locale);
	pstmt.setString(5,locale);
	pstmt.setString(6,facilityId);
	rs = pstmt.executeQuery();
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ ){
		rs.next() ;
	}

	while ( i<=end && rs.next()){
		if(maxRecord==0)
		{
	%>
	
	<p>
	<table align='right'>
	<tr>
	<%

	if ( !(start <= 1) ) {%>
		<td align ='right' id='prev'><A HREF="../../eOA/jsp/PractDutyRosterQueryResult.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>" text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>
	<%}

	//if ( !( (start+14) > maxRecord ) )
		{%>
		<td align ='right' id='next' style='visibility:hidden'><A HREF="../../eOA/jsp/PractDutyRosterQueryResult.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>" text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
	<%}%>
	
	<%sql.setLength(0);%>

	</tr>
	</table>
	<br><br>
	</p>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<td class='COLUMNHEADER'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.dayofweek.label" bundle="${common_labels}"/></td>

	<% }
	
	
	 String classValue = "" ;

		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
		%>

		<tr><td  class='<%=classValue %>'>
		<%
		String carelocndesc  = rs.getString("CARE_LOCN_TYPE_DESC");
		String practid  = rs.getString("PRACTITIONER_ID");
		String practname = rs.getString("PRACTITIONER_NAME");
		String ccode=rs.getString("CLINIC_CODE");
		String cname=rs.getString("clinic_name");
		String dutydate=rs.getString("ON_DUTY_DATE");
		String dutydate_disp=DateUtils.convertDate(dutydate,"DMY","en",locale);

		String on_duty_day=rs.getString("ON_DUTY_DAY");
		on_duty_day=on_duty_day.trim();
		String day_of_week_desc="";
			if(on_duty_day.equalsIgnoreCase("Monday"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(on_duty_day.equalsIgnoreCase("Tuesday"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(on_duty_day.equalsIgnoreCase("Wednesday"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(on_duty_day.equalsIgnoreCase("Thursday"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(on_duty_day.equalsIgnoreCase("Friday"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(on_duty_day.equalsIgnoreCase("Saturday"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(on_duty_day.equalsIgnoreCase("Sunday"))
								{
									day_of_week_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

		String clinic_type=rs.getString("CARE_LOCN_TYPE_IND");
		String resourceq=rs.getString("rsource");

		if(resourceq.equals("P"))
			{
				 resourceq=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			 }
			 else if(resourceq.equals("E"))
			{
				resourceq=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			  }
			  else if(resourceq.equals("R"))
			{
				resourceq=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}
			else if(resourceq.equals("O"))
			{
				resourceq=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}

		String resource7=rs.getString("RESOURCE_CLASS");
	
		if (practname == null ) practname ="&nbsp";
		
		%><a href="../../eOA/jsp/addmodifyPractDutyRoster.jsp?pract_id=<%=practid%>&cname=<%=cname%>&clinic_type=<%=carelocndesc%>&c_code=<%=ccode%>&operating_facility_id=<%=facilityId%>&practname=<%=practname%>&carelocnind=<%=clinic_type%>&onduty_date=<%=dutydate%>&resource7=<%=resource7%>&resourceq=<%=resourceq%>&on_duty_day=<%=on_duty_day%>"  target='f_query_add_mod'>
		<%=carelocndesc%></td><td  class='<%=classValue%>'>
		<%=ccode%></a></td><td  class='<%=classValue%>'>	
		<%=cname%></td><td  class='<%=classValue%>'>
		<%=resourceq%></td><td  class='<%=classValue%>'>
		
		<a href="../../eOA/jsp/addmodifyPractDutyRoster.jsp?pract_id=<%=practid%>&cname=<%=cname%>&clinic_type=<%=carelocndesc%>&c_code=<%=ccode%>&operating_facility_id=<%=facilityId%>&carelocnind=<%=clinic_type%>&onduty_date=<%=dutydate%>&resource7=<%=resource7%>&resourceq=<%=resourceq%>&practname=<%=practname%>&on_duty_day=<%=on_duty_day%>"  target='f_query_add_mod'>
		<%=practid%></a></td><td  class='<%=classValue%>'>
		<%=practname %></td><td   class='<%=classValue%>'>
		<%=dutydate_disp%></td><td  class='<%=classValue%>'>
		<%=day_of_week_desc%></td>
		<%
 
		i++;
		maxRecord++;

	}//endwhile

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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%}

	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();

}catch(Exception e){
	//out.print(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally {
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>

</td></tr>
</table>
<br><center>


</center>
</BODY>
</HTML>

