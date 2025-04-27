<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.sql.*,java.net.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%String facilityid = (String)session.getValue("facility_id");%>
<html>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<%
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs =null;
			StringBuffer sql = new StringBuffer();
			
			String fromnursingunit = request.getParameter("fr_nursing_unit")==null?"":request.getParameter("fr_nursing_unit");
			String tonursingunit = request.getParameter("to_nursing_unit")==null?"":request.getParameter("to_nursing_unit");
			String frbedclass = request.getParameter("fr_bed_class")==null?"":request.getParameter("fr_bed_class");
			String tobedclass = request.getParameter("to_bed_class")==null?"":request.getParameter("to_bed_class");

			String prevcode = "";
			String className = "";
			StringBuffer whereClause = new StringBuffer();
			int i = 0;

			if(!fromnursingunit.equals("") || !tonursingunit.equals(""))
				whereClause.append(" and nursing_unit_code BETWEEN  NVL('"+fromnursingunit+"','!') AND  NVL('"+tonursingunit+"','~') ");
			if(!frbedclass.equals("") || !tobedclass.equals(""))
				whereClause.append(" and bed_class_code BETWEEN  NVL('"+frbedclass+"','!') AND  NVL('"+tobedclass+"','~') ");
		%>
</head>							
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<%
	try
	{
		con =ConnectionManager.getConnection(request);
		
		out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");

		sql.append(" SELECT NURSING_UNIT_CODE code,NURSING_UNIT_SHORT_DESC,BED_CLASS_CODE, ");
		sql.append("BED_TYPE_CODE,BED_NO,ROOM_NO, decode(SEX_SPEC_IND,'M','Male','F','Female','U','Unknown') SEX_SPEC_IND,OCCUPYING_PATIENT_ID, ");
		sql.append("	to_char(OCCUPIED_UNTIL_DATE_TIME,'dd/mm/rrrr hh24:mi') UNTIL_DATE  ");
		sql.append("	FROM IP_NURSING_UNIT_BED_VW  ");
		sql.append("	WHERE FACILITY_ID = ?  ");
		sql.append(""+whereClause.toString()+"");
		sql.append("	ORDER BY NURSING_UNIT_CODE,BED_CLASS_CODE,BED_NO ");

		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,facilityid);
	
		out.println("<tr><th width='40%' colspan=3 align=center>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels")+"</th><th rowspan=2>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"</th><th rowspan=2>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SexSpecInd.label","ip_labels")+"</th><th rowspan=2>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.OccupyingPatientID.label","ip_labels")+"</th><th rowspan=2>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.UntilDateTime.label","ip_labels")+"</th></tr>");
		out.println("<tr><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Class.label","common_labels")+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels")+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"</th></tr>");
				
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			if(i%2 == 0)
				className = "QRYEVEN";
			else
				className = "QRYODD";
			
			String currcode = rs.getString("code");

			if(!prevcode.equals(currcode))
			{
				out.println("<tr><td colspan=7 class=CAGROUPHEADING>Nursing Unit : "+currcode+"  "+rs.getString("NURSING_UNIT_SHORT_DESC")+"</td></tr>");
			}

			out.println("<tr><td class='"+className+"'>"+rs.getString("BED_CLASS_CODE")+"</td>");
			out.println("<td class='"+className+"'>"+rs.getString("BED_TYPE_CODE")+"</td>");
			out.println("<td class='"+className+"'>"+rs.getString("BED_NO")+"</td>");
			out.println("<td class='"+className+"'>"+rs.getString("ROOM_NO")+"</td>");
			out.println("<td class='"+className+"'>"+(rs.getString("SEX_SPEC_IND")==null?"&nbsp;":rs.getString("SEX_SPEC_IND"))+"</td>");
			out.println("<td class='"+className+"'>"+(rs.getString("OCCUPYING_PATIENT_ID")==null?"&nbsp;":rs.getString("OCCUPYING_PATIENT_ID"))+"</tr>");
			out.println("<td class='"+className+"'>"+(rs.getString("UNTIL_DATE")==null?"&nbsp;":rs.getString("UNTIL_DATE"))+"</td></tr>");
			prevcode = currcode;
			i++;
		}
		out.println("</table>");
		
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();

	}catch(Exception e) {out.println(e.toString());}
	finally
	{
		ConnectionManager.returnConnection(con,request);
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

