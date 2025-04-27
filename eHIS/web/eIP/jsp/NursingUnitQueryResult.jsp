<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown='lockKey()';>");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ((whereClause == null || whereClause.equals("")))
	{
		if(sql.length() > 0) sql.delete(0,sql.length());

		String nursingunitcode = checkForNull(request.getParameter("nursing_unit_code"));
		String physical_location = checkForNull(request.getParameter("physical_location"));
		String shortdesc = checkForNull(request.getParameter("long_desc"));
		String effstatus = checkForNull(request.getParameter("eff_status"));

		/* ADDED LEVEL OF CARE CODE & DESC ON 25 FEB 2004 by SRIDHAR */
		String level_of_care_code = checkForNull(request.getParameter("level_of_care_code"));
		String level_of_care_desc = request.getParameter("level_of_care_desc");

		String nursing_unit_type_code  = checkForNull(request.getParameter("nursing_unit_type_code"));
		String nursing_unit_type_desc = checkForNull(request.getParameter("nursing_unit_type_desc"));

		String dept_code = checkForNull(request.getParameter("dept_code"));
		String dept_short_desc = checkForNull(request.getParameter("dept_short_desc"));
		
		String service_code = checkForNull(request.getParameter("service_code"));
		String service_short_desc = checkForNull(request.getParameter("service_short_desc"));
		
		String age_group_code = checkForNull(request.getParameter("age_group_code"));

		String check_same_sex_in_room_yn = checkForNull(request.getParameter("check_same_sex_in_room_yn"));
		
		String allow_pseudo_bed_srl_yn = checkForNull(request.getParameter("allow_pseudo_bed_srl_yn"));

		String online_mr_notfn_yn = checkForNull(request.getParameter("online_mr_notfn_yn"));

		String auto_file_transfer_yn = checkForNull(request.getParameter("auto_file_transfer_yn"));

		String applicable_to = checkForNull(request.getParameter("applicable_to"));

		nursingunitcode=nursingunitcode.toUpperCase();

		if ( !(nursingunitcode == null || nursingunitcode.equals("")) )
		sql.append(" and upper(nursing_unit_code) like upper('"+nursingunitcode+"%')");

		if ( !(shortdesc == null || shortdesc.equals("")) )
		sql.append(" and upper(nursing_unit_short_desc) like upper('"+shortdesc+"%')");

		if ( !(nursing_unit_type_code == null || nursing_unit_type_code.equals("")) )
		sql.append(" and upper(nursing_unit_type_code) like upper('"+nursing_unit_type_code+"%')");

		if ( !(nursing_unit_type_desc == null || nursing_unit_type_desc.equals("")) )
		sql.append(" and upper(nursing_unit_type_short_desc) like upper('"+nursing_unit_type_desc+"%')");

		/* ADDED LEVEL OF CARE CODE & DESC ON 25 FEB 2004 by SRIDHAR */
		if ( !(level_of_care_code == null || level_of_care_code.equals("")) )
		sql.append(" and upper(level_of_care_code) like upper('"+level_of_care_code+"%')");

		if ( !(level_of_care_desc == null || level_of_care_desc.equals("")) )
		sql.append(" and upper(level_of_care_desc) like upper('"+level_of_care_desc+"%')");


		if ( !(physical_location == null || physical_location.equals("")) )
		sql.append(" and upper(physical_location) like upper('"+physical_location+"%')");


		if ( !(dept_code == null || dept_code.equals("")) )
		sql.append(" and upper(dept_code) like upper('"+dept_code+"%')");

		if ( !(dept_short_desc == null || dept_short_desc.equals("")) )
		sql.append(" and upper(dept_short_desc) like upper('"+dept_short_desc+"%')");

		if ( !(service_code == null || service_code.equals("")) )
		sql.append(" and upper(service_code) like upper('"+service_code+"%')");

		if ( !(service_short_desc == null || service_short_desc.equals("")) )
		sql.append(" and upper(service_short_desc) like upper('"+service_short_desc+"%')");

		if ( !(age_group_code == null || age_group_code.equals("")) )
		sql.append(" and upper(age_group_code) like upper('"+age_group_code+"%')");

//Added BY SRIDHAR on 10 MAY 2004
//Nursing Unit Applicable To either INPATIENT or DAY CARE 
		if ( !(applicable_to == null || applicable_to.equals("")) )
		sql.append(" and upper(PATIENT_CLASS) like upper('"+applicable_to+"%')");

		if ( !(check_same_sex_in_room_yn == null || check_same_sex_in_room_yn.equals("")) )
		sql.append(" and upper(check_same_sex_in_room_yn) like upper('"+check_same_sex_in_room_yn+"%')");

		if ( !(allow_pseudo_bed_srl_yn == null || allow_pseudo_bed_srl_yn.equals("")) )
		sql.append(" and upper(allow_pseudo_bed_yn) like upper('"+allow_pseudo_bed_srl_yn+"%')");

		if ( !(effstatus == null || effstatus.equals("")) )
		{
		   if ( effstatus.equals("E") )
				sql.append(" and eff_status='E'");
		   if ( effstatus.equals("D") )
				sql.append(" and eff_status='D'");
	    }

		if ( !(online_mr_notfn_yn == null || online_mr_notfn_yn.equals("")) )
		{
		   if ( online_mr_notfn_yn.equals("Y") )
				sql.append(" and online_mr_notfn_yn='Y'");
		   if ( online_mr_notfn_yn.equals("N") )
				sql.append(" and online_mr_notfn_yn='N'");
	    }

		if ( !(auto_file_transfer_yn == null || auto_file_transfer_yn.equals("")) )
		{
		   if ( auto_file_transfer_yn.equals("Y") )
				sql.append(" and auto_file_transfer_yn='Y'");
		   if ( auto_file_transfer_yn.equals("N") )
				sql.append(" and auto_file_transfer_yn='N'");
	    }
		//appending order by clause

		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql.append(ord[i]);
			else
				sql.append(ord[i]+",");
			}
		}
	} //end of where clause IF
	else
		sql.append(whereClause);

// To display 14 records in a page

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
	ResultSet rs=null;
	int maxRecord = 0;

	try{
			conn = ConnectionManager.getConnection(request);
			stmt = conn.createStatement();
			
			/*StringBuffer strsql1 = new StringBuffer();
			strsql1.append("select count(*) as total from ip_nursing_unit_vw where facility_id = '"+facilityId+"' "+sql.toString());
			rs = stmt.executeQuery(strsql1.toString());
			rs.next();
			maxRecord = rs.getInt("total");
if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}else{*/
			StringBuffer strsql2 = new StringBuffer();
			strsql2.append("select * from IP_NURSING_UNIT_VW where facility_id = '"+facilityId+"' "+sql.toString());
			rs = stmt.executeQuery(strsql2.toString());

			if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		  }

		 while (  i<=end && rs.next())
		{
			 if (maxRecord==0)
			{
	%>
				<P>
				<table align='right'>
					<tr>
							<%
								if ( !(start <= 1) )
									out.println("<td align ='right' id='prev'><A HREF='NursingUnitQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
							
								//if ( !( (start+14) > maxRecord ) )
									out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='NursingUnitQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
							%>			
					</tr>
				</table>
				</P>
				<br>
				<br>

				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.levelofcare.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th> 
				<th><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.MRSectionType.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.PhysicalLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	<%		}
	/*if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		  }*/

			String classValue = "" ;

	//while ( rs.next() && i<=end )
	//{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			String	 nursingunitcode = checkForNull(rs.getString("NURSING_UNIT_CODE"));
			String effstatus = checkForNull(rs.getString("EFF_STATUS"));
			
			String nursingUnitTypeCode = checkForNull(rs.getString("nursing_unit_type_code"));
			
			String nursingUnitTypeDesc = checkForNull(rs.getString("nursing_unit_type_short_desc"));
			
			/* ADDED LEVEL OF CARE CODE & DESC ON 25 FEB 2004 by SRIDHAR */
//			String LevelCode = checkForNull(rs.getString("LEVEL_OF_CARE_CODE"),"&nbsp;");

			String LevelDesc = checkForNull(rs.getString("LEVEL_OF_CARE_DESC"),"&nbsp;");

			String deptCode  = checkForNull(rs.getString("dept_code"),"&nbsp;");
			
			String deptDesc  = checkForNull(rs.getString("dept_short_desc"),"&nbsp;");
			
			String serviceCode  = checkForNull(rs.getString("service_code"),"&nbsp;");
			
			String serviceDesc  = checkForNull(rs.getString("service_short_desc"),"&nbsp;");

			String ageGroupCode  = checkForNull(rs.getString("age_group_short_desc"),"&nbsp;");
			
//++++++++++++++++++ applicable_to INPATIENT or DAY CARE +++++++++++++++++++++
			String applicableTo = checkForNull(rs.getString("PATIENT_CLASS"),"&nbsp;");
			if(applicableTo == null) applicableTo="&nbsp;";

			String physical_location = checkForNull(rs.getString("physical_location"),"&nbsp;");
			String mrSectionDesc = checkForNull(rs.getString("MR_SECTION_SHORT_DESC"),"&nbsp;");

			String mrSectionType  = checkForNull(rs.getString("MR_SECTION_TYPE"),"&nbsp;");

			if(mrSectionType.equals("C") ) mrSectionType="Central";
			else
			if(mrSectionType.equals("D") ) mrSectionType="Department";

			out.println("<tr><td nowrap class='" + classValue + "'>");
			out.println("<a href='addModifyNursingUnit.jsp?nursing_unit_code="+nursingunitcode+"&facility_id="+facilityId+"' target='f_query_add_mod' >");
			out.println(nursingunitcode+"</a></td><td  nowrap class='" + classValue + "'>");
			out.println(rs.getString("nursing_unit_long_desc")+"</td><td nowrap class='" + classValue + "'>");
			out.println(rs.getString("nursing_unit_short_desc")+"</td><td nowrap class='" + classValue + "'>");
			out.println(nursingUnitTypeCode+"</td><td nowrap class='" + classValue + "'>");
			out.println(nursingUnitTypeDesc+"</td><td nowrap class='" + classValue + "'>");
			out.println(deptCode+"</td><td nowrap class='" + classValue + "'>");
			out.println(deptDesc+"</td><td nowrap class='" + classValue + "'>");
			out.println(serviceCode+"</td><td nowrap class='" + classValue + "'>");
			out.println(serviceDesc+"</td><td nowrap class='" + classValue + "'>");
			out.println(LevelDesc+"</td><td nowrap class='" + classValue + "'>");
	 		out.println(ageGroupCode+"</td><td nowrap  class='" + classValue + "'>");
			out.println(applicableTo+"</td><td nowrap  class='" + classValue + "'>");
			out.println(mrSectionType+"</td><td nowrap   class='" + classValue + "'>");
			out.println(mrSectionDesc+"</td><td nowrap   class='" + classValue + "'>");
			out.println(physical_location+"</td><td nowrap   class='" + classValue + "'>");
			if(effstatus.equals("E"))
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		i++;
		maxRecord++;

		}//endwhile

		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}

		boolean flag = false;
		if ( maxRecord < 14 || (!rs.next()) )
			{
				%>
					<script >
					if (document.getElementById('next'))
						document.getElementById('next').style.visibility='hidden';
					</script>
				<% flag = true;
			}
			else
			{%>
					<script >
					if (document.getElementById('next'))
						document.getElementById('next').style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%
			}	
	//}
	}catch(Exception e)
		{
		e.toString();
		out.println(e);
		}
		finally   
		{
			if(stmt!=null) 	stmt.close();
			if(rs!=null) 		rs.close();
			ConnectionManager.returnConnection(conn,request);
		}
%>

			</td></tr>
			</table>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>
	</BODY>
</HTML>

