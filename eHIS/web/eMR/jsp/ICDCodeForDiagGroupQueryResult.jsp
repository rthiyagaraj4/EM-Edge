<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %><!--,oracle.jdbc.driver.*-->
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%
	 request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' class='CONTENT' >");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer() ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql = new StringBuffer();
	String diag_group_code = request.getParameter("diag_group_code");
	String diag_group_desc = request.getParameter("diag_group_desc");
	String diag_code = request.getParameter("diag_code");
	String title_desc = request.getParameter("title_desc");
	String speciality_code = request.getParameter("speciality_code");
	String speciality_desc = request.getParameter("speciality_desc");
	String facility_id = request.getParameter("facility_id");
	String facility_name = request.getParameter("facility_name");
	String practitioner_id = request.getParameter("practitioner_id");
	String practitioner_name = request.getParameter("practitioner_name");

		if ( !(diag_group_code == null || diag_group_code.equals("")) )
		{
			sql.append("and  b.diag_group_code like '"+diag_group_code.toUpperCase()+"%'");
		}

		if ( !(diag_group_desc == null || diag_group_desc.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(b.diag_group_desc)  like  upper('"+diag_group_desc+"%') ");
		}

		if ( !(diag_code == null || diag_code.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(c.diag_code)  like  upper( '"+diag_code+"%') ");
		}

		if ( !(title_desc == null || title_desc.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(c.short_desc)  like  upper('"+title_desc+"%') ");

		}

		if ( !(speciality_code == null || speciality_code.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(b.speciality_code)  like  upper('"+speciality_code.toUpperCase()+"%') ");

		}
		if ( !(speciality_desc == null || speciality_desc.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(e.short_desc)  like  upper('"+speciality_desc+"%') ");
		}

		if ( !(facility_id == null || facility_id.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(b.facility_id) like upper('"+facility_id.toUpperCase()+"%') ");
		}

		if ( !(facility_name == null || facility_name.equals("")) )
		{
			sql.append( " and ");
			sql.append(" upper(f.facility_name)  like  upper('"+facility_name+"%') ");
		}

		if ( !(practitioner_id == null || practitioner_id.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(b.practitioner_id)  like  upper('"+practitioner_id+"%') ");
		}

		if ( !(practitioner_name == null || practitioner_name.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(g.practitioner_name)  like  upper('"+practitioner_name+"%') ");
		}


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

	}
	else {
		sql = new StringBuffer();
		sql.append(whereClause);
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
		Connection conn =null;
		Statement stmt=null;
		//ResultSet rset=null;
		ResultSet rs=null;
		int maxRecord = 0;

try{
		conn=ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		//String strsql1=" select /*+ INDEX(c MR_ICD_CODE_PK) */ count(*) as total from "+
		/*	" mr_icd_code c, "+
			" mr_diag_group_dtl a, "+
			" mr_diag_group b, "+			
			" am_speciality e , "+
			" sm_facility_param f, "+
			" am_practitioner g   "+
			" where  "+
			" c.diag_srl_no = a.diag_srl_no "+	
			" and c.diag_srl_no like '%%' "+
			" and c.diag_code_scheme = b.diag_code_scheme "+
			" and a.DIAG_GROUP_CODE = b.DIAG_GROUP_CODE "+						
			" and b.speciality_code = e.speciality_code (+)  "+
			" and b.facility_id =f.facility_id  (+) "+
			" and b.practitioner_id = g.practitioner_id (+) "+sql;
			
		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");
	
	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
*/
		String strsql2=" select /*+ INDEX(c MR_ICD_CODE_PK) */ b.diag_group_code,b.diag_group_desc,c.DIAG_CODE   			, "+
			" c.short_desc title,b.speciality_code,e.short_desc,b.facility_id, "+
			" f.facility_name,b.practitioner_id,g.practitioner_name  from "+
			" mr_icd_code c, "+
			" mr_diag_group_dtl a, "+
			" mr_diag_group b, "+			
			" am_speciality e , "+
			" sm_facility_param f, "+
			" am_practitioner g   "+
			" where  "+
			" c.diag_srl_no = a.diag_srl_no "+
			" and c.diag_srl_no like '%%' "+
			" and c.diag_code_scheme = b.diag_code_scheme "+
			" and a.DIAG_GROUP_CODE = b.DIAG_GROUP_CODE "+
			" and b.speciality_code = e.speciality_code (+)  "+
			" and b.facility_id =f.facility_id  (+) "+
			" and b.practitioner_id = g.practitioner_id (+) "+sql.toString();
	
		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ ){
				rs.next() ;
			}

		while (i<=end && rs.next())
		{
			if (maxRecord==0)
			{
				
%>
<P>
<table align='right'>
<tr>

<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/ICDCodeForDiagGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/ICDCodeForDiagGroupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
<br><br>
</P>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="eMR.DiagGrpCode.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="eMR.DiagGrpDesc.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="Common.ICDCode.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eMP.SpecialityDesc.label" bundle="${mp_labels}"/></th>
<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>

<%
			}
 	/*if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }*/
	  String classValue="";
//while ( rs.next() && i<=end )
//{
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;
	out.println("<tr><td  class='" + classValue + "'>");

	String diag_group_code =rs.getString("diag_group_code");
		if(diag_group_code == null) diag_group_code="&nbsp;";
	String diag_group_desc =rs.getString("diag_group_desc");
		if(diag_group_desc == null) diag_group_desc="&nbsp;";
	String diag_code =rs.getString("diag_code");
		if(diag_code == null) diag_code="&nbsp;";
				

	String long_desc =rs.getString("title");
		if(long_desc == null) long_desc="&nbsp;";
	String speciality_code =rs.getString("speciality_code");
		if(speciality_code == null) speciality_code="&nbsp;";
	String short_desc =rs.getString("short_desc");
		if(short_desc == null) short_desc="&nbsp;";
	String facility_id =rs.getString("facility_id");
		if(facility_id == null) facility_id="&nbsp;";
	String facility_name =rs.getString("facility_name");
		if(facility_name == null) facility_name="&nbsp;";
	String practitioner_id =rs.getString("practitioner_id");
		if(practitioner_id == null) practitioner_id="&nbsp;";
	String practitioner_name =rs.getString("practitioner_name");
		if(practitioner_name == null) practitioner_name="&nbsp;";
	
	
	out.println(diag_group_code+"</a></td><td  class='" + classValue + "'>");
	out.println(diag_group_desc );
	out.println("</td><td  class='" + classValue + "'>");
	out.println( diag_code );
	out.println("</td><td  class='" + classValue + "'>");
	out.println(long_desc );
	out.println("</td><td  class='" + classValue + "'>");
	out.println(speciality_code);
	out.println("</td><td  class='" + classValue + "'>");
	out.println(short_desc);
	out.println("</td><td  class='" + classValue + "'>");
	out.println(facility_id);
	out.println("</td><td  class='" + classValue + "'>");
	out.println(facility_name);
	out.println("</td><td  class='" + classValue + "'>");
	out.println(practitioner_id);
	out.println("</td><td  class='" + classValue + "'>");
	out.println(practitioner_name);
	out.println("</td></tr>");
	
	i++;
	maxRecord++;
}
		

	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	if ( maxRecord < 14 || (!rs.next()) )
	{
		%>
		<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
		</script>
		<% 
	}
	else
	{%>
		<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
		</script>
	<%
	}

}catch(Exception e){ /* out.println(e); */
		e.toString();
		e.printStackTrace();
}
	finally   {
	if(stmt!=null)
	stmt.close();
	if(rs!=null)
	rs.close();
	//if(rset!=null)
	//rset.close();
	ConnectionManager.returnConnection(conn,request);
	}
	
%>
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

