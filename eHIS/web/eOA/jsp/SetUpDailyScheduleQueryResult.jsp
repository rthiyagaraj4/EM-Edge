<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
   
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<Script Language="JavaScript" src="../../eOA/js/SetUpDailySchedule.js"></Script>

	
<HTML><head><%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  class='CONTENT' onLoad='ClearMsg()' onKeyDown = 'lockKey()'>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String strsql2="";
		StringBuffer sql=new StringBuffer();
		StringBuffer where1=new StringBuffer();
		String whereClause =request.getParameter("whereclause");
		 where1=where1.append(whereClause);
		String fmode	   = request.getParameter("mode") ;
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String clinic_date="";
		String res_class_desc="";
		String p_time_table_type_desc="";
		String locale = (String)session.getAttribute("LOCALE");

	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		String p_clinic_code = request.getParameter("clinic_code") == null ? "" : request.getParameter("clinic_code") ;
		String p_clinic_desc = request.getParameter("clinic_desc") == null ? "" : request.getParameter("clinic_desc") ;
		String p_pract_id = request.getParameter("practitioner_id") == null ? "" : request.getParameter("practitioner_id") ;
		String p_pract_name = request.getParameter("practitioner_name") == null ? "" : request.getParameter("practitioner_name") ;
		clinic_date = request.getParameter("clinic_date") == null ? "" : request.getParameter("clinic_date") ;

		clinic_date=DateUtils.convertDate(clinic_date,"DMY",locale,"en");

		String p_locn_type= request.getParameter("locn_type") == null ? "" : request.getParameter("locn_type") ;

		
		String p_resource_type= request.getParameter("resource_type") == null ? "" : request.getParameter("resource_type") ;

						
		String p_time_table_type= request.getParameter("time_table_type");
		if(p_time_table_type ==null) p_time_table_type="0";

	
	


			if ( !(p_clinic_code == null || p_clinic_code.equals("")) )
			{
					p_clinic_code=p_clinic_code.toUpperCase();
					sql =sql.append(" and upper(clinic_code) like upper('"+p_clinic_code+"%')");
					
			}

			if ( !(p_clinic_desc == null || p_clinic_desc.equals("")) )
			{
					sql =sql.append( " and upper(OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1')) like  upper('"+p_clinic_desc+"%') ");
			}


			if ( !(p_pract_id== null || p_pract_id.equals("")) )
			{
					p_pract_id=p_pract_id.toUpperCase();
					sql =sql.append( " and upper(practitioner_id) like upper('"+p_pract_id+"%') ");
			}

			if ( !(p_locn_type== null || p_locn_type.equals("")) )
			{
					p_locn_type=p_locn_type.toUpperCase();
					sql =sql.append( " and upper(care_locn_type_ind) like upper('"+p_locn_type+"%') ");
			}

			if ( !(p_resource_type== null || p_resource_type.equals("")) )
			{
					p_resource_type=p_resource_type.toUpperCase();
					sql =sql.append( " and upper(resource_class) like upper('"+p_resource_type+"%') ");
			}
			

			if ( !(p_pract_name == null || p_pract_name.equals("")) )
			{
					sql =sql.append(" and upper(AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1')) like upper('"+p_pract_name+"%')  ");
			}

			if ( !(clinic_date == null || clinic_date.equals("")) )
			{
					
					sql=sql.append( " and clinic_date =to_date( '"+clinic_date+"' ,'dd/mm/yyyy') ");
			}
		
			
			if ( !(p_time_table_type == null || p_time_table_type.equals("")) )
			{
					sql =sql.append(" and time_table_type like '"+p_time_table_type+"%' ");

			}




		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql.append(" order by ");

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql=sql.append(ord[i]);
			else{
				sql=sql.append(ord[i]);
				sql=sql.append(" ,");
			}}

		}

	}// end if whereClause
	else {
		sql = where1;
		}

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

Connection conn = null;

Statement stmt=null;
//Statement stmt1=null;
//ResultSet rset=null;
//ResultSet rset1=null;
ResultSet rs=null;
int maxRecord = 0;

try
{	
	conn = ConnectionManager.getConnection(request);
	String facilityId = (String) session.getValue( "facility_id" ) ;

	
	stmt=conn.createStatement();
	
 /*Below query commented by venkatesh against GHL-SCF-992 on 18-02-2016 */
	//strsql2	="select clinic_code, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, to_char(clinic_date, 'dd/mm/yyyy') clinic_date_retrival, time_table_type, srl_no, (trunc(clinic_date) - trunc(sysdate)) diff, time_table_type time_table_code, resource_class,care_locn_type_ind,AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_ind,'"+locale+"','1')care_locn_type_desc, resource_class resource_class_desc  from oa_clinic_schedule  where facility_id ='"+facilityId+"' " +sql.toString();
	
	 /* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
	strsql2	="select clinic_code, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, to_char(clinic_date, 'dd/mm/yyyy') clinic_date_retrival, time_table_type, srl_no, (trunc(clinic_date) - trunc(sysdate)) diff, time_table_type time_table_code, resource_class,care_locn_type_ind,AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_ind,'"+locale+"','1')care_locn_type_desc, resource_class resource_class_desc  from oa_clinic_schedule_vw  where facility_id ='"+facilityId+"' AND (eff_status != 'D' OR eff_status IS NULL)" +sql.toString();
	
	
	rs = stmt.executeQuery(strsql2);
	
	
if( ! clinic_date.equals(""))
 {
 
	//stmt1 = conn.createStatement();
}

		if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
		  rs.next() ;
		}

		while ( i<=end && rs.next() )
		{
			if(maxRecord==0)
			{
%>

<P>
<table align='right'>
<tr >
<%
		
if ( !(start <= 1) ) { %>

	<td align ='right' id='prev'><A HREF='../../eOA/jsp/SetUpDailyScheduleQueryResult.jsp?mode=<%=fmode%>&from=<%=start-14%>&to=<%=end-14%>&whereclause=<%=URLEncoder.encode(sql.toString())%>'&text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>
		<%  }

//if ( !( (start+14) > maxRecord ) )
	{ %>
	
	<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/SetUpDailyScheduleQueryResult.jsp?mode=<%=fmode%>&from=<%=start+14%>&to=<%=end+14%>&whereclause=<%=URLEncoder.encode(sql.toString())%>'&text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
		
<%  } %>
</tr>
</table>
<br><br>
</P>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<td class='COLUMNHEADER'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.Location.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eOA.TimeTableType.label" bundle="${oa_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>

	<% }
	
		String classValue = "" ;

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			
			String locn_type=rs.getString("care_locn_type_ind");
			String locn_type_desc=rs.getString("care_locn_type_desc");
			if(locn_type_desc == null) locn_type_desc="";
			String resource_type=rs.getString("resource_class");
			if(resource_type == null) resource_type="";
			String resource_type_desc=rs.getString("resource_class_desc");
			if(resource_type_desc == null) resource_type_desc="";
			String cliniccode 	= rs.getString("clinic_code");
			if(cliniccode == null) cliniccode="";
			String practid    	= rs.getString("practitioner_id");
			if( practid == null ) practid="";
			
			
			String srl_no    = rs.getString("srl_no");
			//String clinic_date1 = rs.getString("clinic_date_retrival");
			String clinic_date1= rs.getString("clinic_date_retrival") == null ? "" : rs.getString("clinic_date_retrival");
			String clinic_date1_disp=DateUtils.convertDate(clinic_date1,"DMY","en",locale);

			String timetablecode    = rs.getString("time_table_code");
			String time_table_type1=rs.getString("time_table_type");
				if(time_table_type1.equals("1"))
		{
			p_time_table_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Slot.label","common_labels");
		}else if(time_table_type1.equals("2"))
		{
			p_time_table_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.slab.label","oa_labels");
		}else if(time_table_type1.equals("3"))
		{
			p_time_table_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FreeFormat.label","common_labels");
		}

			if(resource_type.equals("P"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(resource_type.equals("E"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(resource_type.equals("R"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(resource_type.equals("O"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}


			int diff = rs.getInt("diff");
			if(diff >= 0)
			{%>
			<tr>
			<td class='<%=classValue%>' ><a href=javascript:qryModify('<%=cliniccode%>','<%=practid%>','<%=clinic_date1%>','<%=timetablecode%>','<%=srl_no%>','<%=locn_type%>','<%=resource_type%>')>
			<%=locn_type_desc%></a></td>	

			<td class='<%=classValue%>'>

			<a href=javascript:qryModify('<%=cliniccode%>','<%=practid%>','<%=clinic_date1%>','<%=timetablecode%>','<%=srl_no%>','<%=locn_type%>','<%=resource_type%>')>
			<%=cliniccode%></a>
			</td><td class='<%=classValue%>' >
			<a href=javascript:qryModify('<%=cliniccode%>','<%=practid%>','<%=clinic_date1%>','<%=timetablecode%>','<%=srl_no%>','<%=locn_type%>','<%=resource_type%>')> 
				<%=rs.getString("clinic_name") == null ? "" : rs.getString("clinic_name")%>
			
			</a></td>
			<td class='<%=classValue%>'>
			<a href=javascript:qryModify('<%=cliniccode%>','<%=practid%>','<%=clinic_date1%>','<%=timetablecode%>','<%=srl_no%>','<%=locn_type%>','<%=resource_type%>')> 
			<%=res_class_desc%>&nbsp;</a></td>
			<td class='<%=classValue%>'>
			<a href=javascript:qryModify('<%=cliniccode%>','<%=practid%>','<%=clinic_date1%>','<%=timetablecode%>','<%=srl_no%>','<%=locn_type%>','<%=resource_type%>')> 
			<%=rs.getString("practitioner_id")==null? "&nbsp;" : rs.getString("practitioner_id")%>
				</a></td><td class='<%=classValue%>'>
			<a href=javascript:qryModify('<%=cliniccode%>','<%=practid%>','<%=clinic_date1%>','<%=timetablecode%>','<%=srl_no%>','<%=locn_type%>','<%=resource_type%>')> 
			<%=
			rs.getString("practitioner_name") == null ? "&nbsp;" : rs.getString("practitioner_name")%>
				</a></td><td class='<%=classValue%>'>
			<a href=javascript:qryModify('<%=cliniccode%>','<%=practid%>','<%=clinic_date1%>','<%=timetablecode%>','<%=srl_no%>','<%=locn_type%>','<%=resource_type%>')> 
				<%=p_time_table_type_desc%>
				</a></td><td class='<%=classValue%>'>
			<a href=javascript:qryModify('<%=cliniccode%>','<%=practid%>','<%=clinic_date1%>','<%=timetablecode%>','<%=srl_no%>','<%=locn_type%>','<%=resource_type%>')> 
				<%=clinic_date1_disp%>
			
		</a></td></tr>
			<%
			}
			else
			{ %>
			<%=cliniccode%>
			</td><td class='<%=classValue%>'>
				<%=rs.getString("clinic_name") == null ? "" : rs.getString("clinic_name")%>
				</td><td class='<%=classValue%>'>
		<%
			if(practid.equals("")) 
			   practid = "&nbsp;";
			%>
			<%=practid%>
			</td><td class='<%=classValue%>'>
				<%=rs.getString("practitioner_name") == null ? "&nbsp;" : rs.getString("practitioner_name")%>
				</td><td class='<%=classValue%>' >
			<%=p_time_table_type_desc%>
			</td><td class='<%=classValue%>'>
			<%=clinic_date1_disp%>
			</td></tr>
			<%
			}
			i++;
			maxRecord++;
		}//endwhile

		if(maxRecord == 0)
		{%>
			<script src='../../eCommon/js/common.js' language='javascript'></script>
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


	if(stmt!=null)	stmt.close();
//	if(stmt1!=null)	stmt1.close();
	if(rs!=null)	rs.close();
//	if(rset!=null)	rset.close();
//	if(rset1!=null)	rset1.close();
	sql.setLength(0);
}
catch(Exception e){
		//out.println("hre :" +e.toString());
		e.printStackTrace();
}
finally {
	
	ConnectionManager.returnConnection(conn,request);
}
%>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

