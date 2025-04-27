<!DOCTYPE html>
  
<!--
	Developed by 	:	R.Nanda Kumar
	Created on 	:	26/02/2001
	Module		:	OA
	Function	:
-->

  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eOA/js/TimeTable.js"></Script>

<%
Connection conn = null;
Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;

%>
<HTML><head><%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%         
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
 String locnDesc="";
			String resourceTypeDes="";
            String cliniccode 	= "";
			String practid    	= "";
			String dayno	  	= "";
			String timetabletype = "";
			String resourceType = "";
			String locnCode		="";
	String strsql2="";
	StringBuffer sql=new StringBuffer();
	//String strsql1=" ";
	StringBuffer where1= new StringBuffer();
	String whereClause = request.getParameter("whereclause");
	where1=where1.append(whereClause);
	String fmode	   = request.getParameter("mode") ;

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
		String locationCode	= request.getParameter("care_locn_type_ind");
		
		resourceType		= request.getParameter("resource_class");
		String p_clinic_code    = request.getParameter("clinic_code");
		String p_clinic_desc 	= request.getParameter("clinic_desc");
		String p_pract_id	= request.getParameter("practitioner_id");
		String p_pract_name	= request.getParameter("practitioner_name") ;
		String p_day_code	= request.getParameter("day_code");
		String p_time_table_type= request.getParameter("time_table_type");
		String phys_roster_reqd_yn = request.getParameter("phys_roster_reqd_yn");


		if(phys_roster_reqd_yn == null) phys_roster_reqd_yn="";
		    if (locationCode !=null && !locationCode.equals("")){
				locationCode=locationCode.toUpperCase();
				sql.append(" and upper(care_locn_type_ind) = '"+locationCode+"'  ");
			}

			if ( !(p_clinic_code == null || p_clinic_code.equals("")) )
			{
					p_clinic_code=p_clinic_code.toUpperCase();
					sql.append( " and upper(clinic_code) like '"+p_clinic_code+"%'  ");
			}

			if ( !(p_clinic_desc == null || p_clinic_desc.equals("")) )
			{
					sql.append(" and upper(clinic_name) like  upper('"+p_clinic_desc+"%')  ");
			}

           if (resourceType!=null && !resourceType.equals("") && !resourceType.equals("0")){
			   resourceType = resourceType.toUpperCase();
			   sql.append(" and upper(resource_class) = '"+resourceType+"' ");
		   }


			if ( !(p_pract_id== null || p_pract_id.equals("")) )
			{
					p_pract_id=p_pract_id.toUpperCase();
					sql.append(" and upper(practitioner_id) like '"+p_pract_id+"%'  ");
			}

			if ( !(p_pract_name == null || p_pract_name.equals("")) )
			{
					sql.append(" and upper(practitioner_full_name) like  upper('"+p_pract_name+"%')  ");
			}

			if ( !(p_day_code == null || p_day_code.equals("0") || p_day_code.equals("")) )
			{
					sql.append(" and day_no ="+p_day_code+"  ");
			}

			if ( !(p_time_table_type == null || p_time_table_type.equals("0")) )
			{
					sql.append(" and time_table_type like '"+p_time_table_type+"%'  ");
			}

			if (phys_roster_reqd_yn.equals("Y"))
			{
					sql.append(" and phys_roster_reqd_yn = 'Y'  ");
			}
			else if(phys_roster_reqd_yn.equals("N"))
			{
					sql.append(" and phys_roster_reqd_yn = 'N'  ");
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

	}// end if whereClause
	else {
		sql.append(where1);

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


int maxRecord = 0;

try
{

	conn = ConnectionManager.getConnection(request);
	String facilityId = (String) session.getValue( "facility_id" ) ;
	stmt = conn.createStatement();

	%>

	<%
	//rs.close() ;
	
	/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
	//strsql2="select care_locn_type_ind,CARE_LOCN_TYPE_DESC, clinic_code,clinic_name,resource_class,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,nvl(practitioner_id,'&nbsp;')practitioner_id,nvl(practitioner_id,' ') pract_id,nvl(PRACTITIONER_FULL_NAME,'&nbsp;')practitioner_name,day_no,day_of_week,decode(time_table_type,'1','Slot','2','Slab','3','Free Format') time_table_type,time_table_type time_table_type_no,phys_roster_reqd_yn from oa_clinic_time_table_vw where facility_id ='"+facilityId+"'"+  sql.toString();
	
    /* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
	strsql2="select care_locn_type_ind,CARE_LOCN_TYPE_DESC, clinic_code,clinic_name,resource_class,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,nvl(practitioner_id,'&nbsp;')practitioner_id,nvl(practitioner_id,' ') pract_id,nvl(PRACTITIONER_FULL_NAME,'&nbsp;')practitioner_name,day_no,day_of_week,decode(time_table_type,'1','Slot','2','Slab','3','Free Format') time_table_type,time_table_type time_table_type_no,phys_roster_reqd_yn from oa_clinic_time_table_vw where facility_id ='"+facilityId+"' AND (EFF_STATUS!='D' OR EFF_STATUS IS NULL)"+  sql.toString();
	
	rs = stmt.executeQuery(strsql2);

	if ( start != 1 )
		
		 for( int j=1; j<start; i++,j++ ){
		  rs.next() ;
		  }

		  if(rs !=null)
	{
			while ( i<=end && rs.next() )
		{
				if(maxRecord==0)
			{
%>

<BODY  class='CONTENT' onLoad='ClearMsg()' onKeyDown = 'lockKey()'>
<P>
<table align='right'>
<tr >

<%
if ( !(start <= 1) ) { %>
	<td align ='right' id='prev'><A HREF='../../eOA/jsp/TimeTableQueryResult.jsp?mode=<%=fmode%>&from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>'text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A> </td>
<% }

//if ( !( (start+14) > maxRecord ) ) { %>
	
<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/TimeTableQueryResult.jsp?mode=<%=fmode%>&from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>'text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
<%// }
	
%>
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
	<td class='COLUMNHEADER'><fmt:message key="Common.days.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eOA.RosterRequired.label" bundle="${oa_labels}"/></td>

	<% }
	

		String classValue = "" ;

	
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;



			%>
			<tr>
			<td class='<%=classValue%>' nowrap>
				<%  locnCode		= rs.getString("care_locn_type_ind");

			        locnDesc		= rs.getString("CARE_LOCN_TYPE_DESC");
					resourceType	= rs.getString("resource_class");
					resourceTypeDes= rs.getString("resource_class_desc")==null?"":rs.getString("resource_class_desc");
					 cliniccode 	= rs.getString("clinic_code");
					 practid    	= rs.getString("pract_id");
					 dayno	    	= rs.getString("day_no");
					 timetabletype  = rs.getString("time_table_type_no");


				 
				 
				 %>
    <a href="javascript:qryModify('<%=locnDesc%>','<%=locnCode%>','<%=resourceType%>','<%=cliniccode%>','<%=practid%>','<%=dayno%>','<%=timetabletype%>')">
			<%= locnDesc %></a></td>
			
			 <td class='<%=classValue%>' >
				
				<%
			

			if (fmode.equals("modify"))
			{
				%>
					
				<a href="javascript:qryModify('<%=locnDesc%>','<%=locnCode%>','<%=resourceType%>','<%=cliniccode%>','<%=practid%>','<%=dayno%>','<%=timetabletype%>')">
			<%
			}
			else if (fmode.equals("delete"))
			{
				%>
				<a href="javascript:qryDelete('<%=locnDesc%>','<%=locnCode%>','<%=resourceType%>','<%=cliniccode%>','<%=practid%>','<%=dayno%>','<%=timetabletype%>')">
				<%
			}
				
			out.println(cliniccode+"</a>");
			%>
			</td><td class=<%=classValue%>>
				
			
			<a href="javascript:qryModify('<%=locnDesc%>','<%=locnCode%>','<%=resourceType%>','<%=cliniccode%>','<%=practid%>','<%=dayno%>','<%=timetabletype%>')">
					<%
			
			out.println( rs.getString("clinic_name"));
			%>
			</a></td><td class='<%=classValue%>' >
				
    <a href="javascript:qryModify('<%=locnDesc%>','<%=locnCode%>','<%=resourceType%>','<%=cliniccode%>','<%=practid%>','<%=dayno%>','<%=timetabletype%>')">
			<%= resourceTypeDes %>&nbsp;</a></td><td class=<%=classValue%> >
			<a href="javascript:qryModify('<%=locnDesc%>','<%=locnCode%>','<%=resourceType%>','<%=cliniccode%>','<%=practid%>','<%=dayno%>','<%=timetabletype%>')">
			<%
			out.println(rs.getString("practitioner_id"));
			%>
			</a></td><td nowrap class=<%=classValue%>>
				
			<a href="javascript:qryModify('<%=locnDesc%>','<%=locnCode%>','<%=resourceType%>','<%=cliniccode%>','<%=practid%>','<%=dayno%>','<%=timetabletype%>')">
			<%
			out.println(rs.getString("practitioner_name"));
			%>
			</a></td><td class=<%=classValue%> nowrap>
			<a href="javascript:qryModify('<%=locnDesc%>','<%=locnCode%>','<%=resourceType%>','<%=cliniccode%>','<%=practid%>','<%=dayno%>','<%=timetabletype%>')">
				<%
			out.println(rs.getString("time_table_type"));
			%>
			</a></td><td class=<%=classValue%> >
			<a href="javascript:qryModify('<%=locnDesc%>','<%=locnCode%>','<%=resourceType%>','<%=cliniccode%>','<%=practid%>','<%=dayno%>','<%=timetabletype%>')">
				<%
			out.println(rs.getString("day_of_week"));
			%>
			</a></td> 
			<td align='center' class=<%=classValue%>>
				<%
		if ( rs.getString("phys_roster_reqd_yn").equals("Y") )
			%>
			<img src='../../eCommon/images/enabled.gif'></img>
			<%
		else

			%>
				<img src='../../eCommon/images/RRnwd.gif'></img>

			
			</td></tr>

				<%
			i++;
			maxRecord++;

		}//end od while
}

		if(maxRecord == 0)
		{%>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
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

		sql.setLength(0);
	if(stmt!=null)stmt.close();
	if(rs!=null)rs.close();
	if(rset!=null)rset.close();
}
catch(Exception e){
		//out.println(e.toString());
		 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally {

	ConnectionManager.returnConnection(conn,request);

}
%>

</td></tr>
</table>
</BODY>
</HTML>

