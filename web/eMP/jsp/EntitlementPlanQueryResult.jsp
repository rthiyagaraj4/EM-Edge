<!DOCTYPE html>
<!-- 
	Query Criteria for Entitlement Plan
	Created		: 2/10/2006 11:08 AM
	Modified		: 2/10/2006 11:08 AM
	Created By	: Vinod Babu MV
-->


<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
    out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'><form name='EntiltlementQueryReult' id='EntiltlementQueryReult'>");

	String whereClause = request.getParameter("whereclause");
	
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
    String entitlement_criteria  =  checkForNull(request.getParameter("ENTITLEMENT_CRITERIA"),"");
	entitlement_criteria = entitlement_criteria.toUpperCase();
	entitlement_criteria = entitlement_criteria.trim();
	String pat_cat_code = "";
	String entitlement_facility_id = "";
	String entitlement_criteria_code = "";
	String entitlement_care_locn_ind = "";
 if ( (whereClause == null || whereClause.equals("")) )
 {
	pat_cat_code =    checkForNull(request.getParameter("PAT_CAT_CODE"),"");
	entitlement_facility_id =  checkForNull(request.getParameter("ENTITLEMENT_FACILITY_ID"),"");
	entitlement_facility_id = entitlement_facility_id.toUpperCase();
	entitlement_criteria_code= checkForNull(request.getParameter("ENTITLEMENT_CRITERIA_CODE"),"");
	entitlement_care_locn_ind = checkForNull(request.getParameter("ENTITLEMENT_CARE_LOCN_IND"),"");
	entitlement_care_locn_ind = entitlement_care_locn_ind.trim();

	sbQuery.append("SELECT  initcap(ent_by) ent_by, pat_cat_code,pat_cat_desc ");
	sbQuery.append(", entitlement_criteria_code, entitlement_criteria_desc");
	sbQuery.append(", facility_name ");
	sbQuery.append(", loc_type");
	sbQuery.append(" FROM mp_entitlement_criteria_vw a WHERE a.entitlement_criteria LIKE '"+entitlement_criteria+"%'");

   if (!pat_cat_code.equals(""))
	  sbQuery.append(" AND a.pat_cat_code IN ( SELECT pat_cat_code FROM mp_pat_category WHERE UPPER (short_desc) LIKE  UPPER ('"+pat_cat_code+"%') AND pat_cat_code = a.pat_cat_code)");

   if (!entitlement_facility_id.equals(""))
	  sbQuery.append(" AND a.entitlement_facility_id IN ( select facility_id from sm_facility_param where facility_id  = a.entitlement_facility_id  and upper(facility_name) like upper('"+entitlement_facility_id+"%'))");

	if (!entitlement_care_locn_ind.equals(""))
		sbQuery.append(" AND a.entitlement_care_locn_ind IN ( select locn_type from am_care_locn_type where locn_type  = a.entitlement_care_locn_ind  and upper(locn_type) like upper('"+entitlement_care_locn_ind+"%'))");

	if (!entitlement_criteria_code.equals(""))
	{
		 if (entitlement_criteria.equals("1"))
		 {
			 sbQuery.append(" AND  a.entitlement_criteria_code  in ( SELECT speciality_code FROM am_speciality WHERE UPPER (short_desc) LIKE UPPER ('"+entitlement_criteria_code+"%') AND speciality_code = a.entitlement_criteria_code)");
		 }
		 else
    	 if (entitlement_criteria.equals("2"))
		 {	 
			 sbQuery.append(" AND a.entitlement_criteria_code LIKE (SELECT clinic_code FROM op_clinic WHERE UPPER (short_desc) LIKE UPPER ('"+entitlement_criteria_code+"%') AND facility_id = a.entitlement_facility_id  and clinic_code = a.entitlement_criteria_code) ");
		 }
		 else
		 if (entitlement_criteria.equals("3"))
		 {
			 sbQuery.append("  AND a.entitlement_criteria_code LIKE (SELECT bed_class_code FROM ip_bed_class WHERE UPPER (short_desc) LIKE UPPER ('"+entitlement_criteria_code+"%') AND bed_class_code = a.entitlement_criteria_code)");
		 }
		 else
		{	
			sbQuery.append(" AND ( a.entitlement_criteria_code  in ( SELECT speciality_code FROM am_speciality WHERE UPPER (short_desc) LIKE UPPER ('"+entitlement_criteria_code+"%') AND speciality_code = a.entitlement_criteria_code) OR UPPER (a.entitlement_criteria_code) LIKE (SELECT clinic_code FROM op_clinic WHERE UPPER (short_desc) LIKE UPPER ('"+entitlement_criteria_code+"%') AND facility_id = a.entitlement_facility_id  and clinic_code = a.entitlement_criteria_code) OR UPPER (a.entitlement_criteria_code) LIKE (SELECT bed_class_code FROM ip_bed_class WHERE UPPER (short_desc) LIKE UPPER ('"+entitlement_criteria_code+"%') AND bed_class_code = a.entitlement_criteria_code))");
		}
	}
 }
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	if ( !(ord == null || ord .equals("")) )
	{
			sbQuery.append(" order by ");
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					if (ord[i].equals("entitlement_criteria"))
					   sbQuery.append("ent_by");
					else
						sbQuery.append("a."+ord[i]);
				}else{
					if (ord[i].equals("entitlement_criteria"))
					   sbQuery.append("ent_by");
					else
					sbQuery.append("a."+ord[i]);
					sbQuery.append(",");
				}
			}
	} //end of where clause IF
	else
	{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
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

PreparedStatement pstmt=null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
try{
	 conn = ConnectionManager.getConnection(request);
try{
	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	rs = stmt.executeQuery(sbQuery.toString());
	if (rs != null)
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}

if (maxRecord==0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
try{
	pstmt =conn.prepareStatement(sbQuery.toString()); 
	rs = pstmt.executeQuery();
%>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eMP/jsp/EntitlementPlanQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&ENTITLEMENT_CRITERIA="+entitlement_criteria+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eMP/jsp/EntitlementPlanQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&ENTITLEMENT_CRITERIA="+entitlement_criteria+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<BR><BR>
</P>

<center>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.category.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eMP.EntitlementBy.label" bundle="${mp_labels}"/></th>
<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/> </th>
<th><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<%

 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
    String classValue = "" ;
while ( rs.next() && i<=end )
{
	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;

	out.println("<tr><td align='left' class='" + classValue + "'>");
	out.println(rs.getString("pat_cat_desc")+"</td>" );
	out.println("<td align='left' class='" + classValue + "'>");
	out.println(rs.getString("ent_by")+"</td><td class='" + classValue + "'>");
	if (!(entitlement_criteria.equals("1")) && !(entitlement_criteria.equals("3")) )
	{
		out.println(checkForNull(rs.getString("facility_name"),"&nbsp;"));
	}
	else
	    out.println("&nbsp;");
	out.println("</td><td class='" + classValue + "'>");
	if (!(entitlement_criteria.equals("1")) && !(entitlement_criteria.equals("3")) )
	{
		out.println(checkForNull(rs.getString("Loc_type"),"&nbsp;"));
	}
	else
	    out.println("&nbsp;");
	out.println("</td><td class='" + classValue + "' align='left'>");
		out.println( rs.getString("entitlement_criteria_code") );
	out.println("</td><td class='" + classValue + "' align='left'>");
	out.println(checkForNull(rs.getString("entitlement_criteria_desc"),"&nbsp;"));
	out.println("</td>");

	i++;
} %>

</td></tr>
</table>
</center>
<br>
<%
}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}
}catch(Exception e) { out.println(e.toString());}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
</form>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

