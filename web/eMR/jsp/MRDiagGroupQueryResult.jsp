<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
	
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>



<%
	request.setCharacterEncoding("UTF-8");
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()'  onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	sql = new StringBuffer();
	sql.append(" where a.facility_id = b.facility_id (+) and a.speciality_code=c.speciality_code (+) and a.practitioner_id = d.practitioner_id (+) ");

	if ( (whereClause == null || whereClause.equals("")) )
	{
	
	String diag_group_code = request.getParameter("diag_group_code");
	String diag_group_desc = request.getParameter("diag_group_desc");
	String speciality_code  = request.getParameter("speciality_code");
	String speciality_desc = request.getParameter("speciality_desc");
	String facility_id = request.getParameter("facility_id");
	String facility_name = request.getParameter("facility_name");
	String practitioner_id = request.getParameter("practitioner_id");
	String practitioner_name = request.getParameter("practitioner_name");
	String group_type = request.getParameter("group_type");


	if ( !(group_type.equals("B")) )
			{
			sql.append(" and   upper(a.group_type) like  upper('"+group_type.toUpperCase()+"%') ");
			}

	if ( !(diag_group_code == null || diag_group_code.equals("")) )
			{
			sql.append( " and   upper(a.diag_group_code) like  upper('"+diag_group_code.toUpperCase()+"%') ");
		}

	if ( !(diag_group_desc == null || diag_group_desc.equals("")) )
		{
				sql.append(" and ");
				sql.append(" upper(a.diag_group_desc) like  upper('"+diag_group_desc+"%') ");
		}

	if ( !(speciality_code == null || speciality_code.equals("")) )
		{
				sql.append(" and ");
				sql.append("a.speciality_code like  '"+speciality_code.toUpperCase()+"%'");
		}

	if ( !(speciality_desc == null || speciality_desc.equals("")) )
		{
				sql.append(" and ");
				sql.append(" upper(c.short_desc)  like  upper('"+speciality_desc+"%') ");
		}

	if ( !(facility_id == null || facility_id.equals("")) )
		{
				sql.append(" and ");
				sql.append("a.facility_id like  '"+facility_id.toUpperCase()+"%'");
		}	
	
	if ( !(facility_name == null || facility_name.equals("")) )
		{
				sql.append(" and ");
				sql.append(" upper(b.facility_name)  like  upper('"+facility_name+"%') ");
		}	
		
	if ( !(practitioner_id == null || practitioner_id.equals("")) )
		{
				sql.append(" and ");
				sql.append(" upper(a.practitioner_id)  like  upper('"+practitioner_id+"%') ");
		}			

	if ( !(practitioner_name == null || practitioner_name.equals("")) )
		{
				sql.append(" and ");
				sql.append(" upper(d.practitioner_name)  like  upper('"+practitioner_name+"%') ");
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
	Connection conn = null;
	Statement stmt=null;
	ResultSet rset=null;
	//ResultSet rs=null;
	int maxRecord = 0;

try{
	conn=ConnectionManager.getConnection(request);
/*stmt = conn.createStatement();
String strsql1="select count(*) as total from mr_diag_group a,sm_facility_param b,am_speciality c,am_practitioner d  "+sql.toString();

rs = stmt.executeQuery(strsql1); 
rs.next();
maxRecord = rs.getInt("total");

if(rs!=null)
	rs.close();
if(stmt!=null)
	stmt.close();

	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
*/
		String strsql2="select a.group_type,decode(a.group_type,'D','Diagnosis','Procedure') group_type_value,a.diag_group_code, a.diag_group_desc,c.speciality_code, c.short_desc, b.facility_id, "+	" b.facility_name,d.practitioner_id,d.practitioner_name from mr_diag_group a,sm_facility_param b,am_speciality c,am_practitioner d "+sql.toString();
		stmt = conn.createStatement();
		rset = stmt.executeQuery(strsql2); 

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ ){
				rset.next() ;
					}
		while (i<=end && rset.next())
		{
			if (maxRecord==0)
			{
%>							       
		<P>							       
		<table align='right'>					
		<tr>
		
<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/MRDiagGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/MRDiagGroupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>

			</tr>
			</table>
			<br><br>
			</P>

			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<th><fmt:message key="Common.GroupType.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eMR.GroupDesc.label" bundle="${mr_labels}"/></th>
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
	  rset.next() ;
	  }*/
			 String classValue="";
			 String group_type_value = null;
			 String pract_name = null;
			String group_type = null;
			

//while ( rset.next() && i<=end )
//{
			pract_name=(rset.getString("practitioner_name")==null
			?"":rset.getString("practitioner_name"));
			group_type_value=(rset.getString("group_type_value")==null ?"&nbsp;":rset.getString("group_type_value"));
			group_type = rset.getString("group_type");

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			/*if (pract_name != null || pract_name!="") {

				pract_name = pract_name;
			}*/

					

			if (group_type != null && group_type!="") {
				group_type = group_type;
			}
			
	//group_type_value = rset.getString("group_type_value");
			out.println("<tr><td nowrap class='" + classValue + "'>");
			/*out.println("<a href=\"../../eMR/jsp/addModifyMRDiagGroup.jsp?diagGroupCode="+rset.getString("diag_group_code")+"&pract_name="+pract_name+"&group_type="+group_type+"\" target='f_query_add_mod' >");
			out.println(group_type_value+"</a></td><td nowrap class='" + classValue + "'>");
			out.println("<a href=\"../../eMR/jsp/addModifyMRDiagGroup.jsp?diagGroupCode="+rset.getString("diag_group_code")+"&pract_name="+pract_name+"&group_type="+group_type+"\" target='f_query_add_mod' >");*/

			out.println("<a href=\"../../eMR/jsp/addModifyMRDiagGroup.jsp?diagGroupCode="+rset.getString("diag_group_code")+"&group_type="+group_type+"\" target='f_query_add_mod' >");
			out.println(group_type_value+"</a></td><td nowrap class='" + classValue + "'>");
			out.println("<a href=\"../../eMR/jsp/addModifyMRDiagGroup.jsp?diagGroupCode="+rset.getString("diag_group_code")+"&group_type="+group_type+"\" target='f_query_add_mod' >");
			
			out.println(rset.getString("diag_group_code")+"</a></td><td nowrap class='" + classValue + "'>");
			out.println(rset.getString("diag_group_desc")+"</td><td nowrap class='" + classValue + "'>");
			out.println(rset.getString("speciality_code")==null ?"&nbsp;":rset.getString("speciality_code") );
			out.println("</td><td nowrap align='left' class='" + classValue + "'>");
			out.println(rset.getString("short_desc")==null ?"&nbsp;":rset.getString("short_desc") );
			out.println("</td><td  nowrap align='left' class='" + classValue + "'>");
			out.println(rset.getString("facility_id")==null ?"&nbsp;":rset.getString("facility_id") );
			out.println("</td><td nowrap align='left' class='" + classValue + "'>");
			out.println(rset.getString("facility_name")==null ?"&nbsp;":rset.getString("facility_name") );
			out.println("</td><td nowrap align='left' class='" + classValue + "'>");
			out.println(rset.getString("practitioner_id")==null ?"&nbsp;":rset.getString("practitioner_id") );
			out.println("</td><td nowrap align='left' class='" + classValue + "'>");
			//out.println(pract_name );
			out.println(rset.getString("practitioner_name")==null ?"&nbsp;":rset.getString("practitioner_name")  );
			out.println("</td></tr>");
	
			i++;
			maxRecord++;
		}//endwhile
%>

			</td></tr>
			</table>
			<br><center>
<%
			if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			if ( maxRecord < 14 || (!rset.next()) )
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%
			}
//rs.close();
%>

</center>
</BODY>
</HTML>
<%
}catch(Exception e){
	//out.println(e);
	e.toString();
	e.printStackTrace();
}
	finally   {
	if(stmt!=null)
	stmt.close();
	//if(rs!=null)
	//rs.close();
	if(rset!=null)
	rset.close();
	ConnectionManager.returnConnection(conn,request);
	}

%>

