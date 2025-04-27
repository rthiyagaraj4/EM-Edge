<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,java.net.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<%String facilityid = (String)session.getValue("facility_id");%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
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

		sql.append(" SELECT NURSING_UNIT_CODE,NURSING_UNIT_SHORT_DESC,BED_CLASS_CODE, ");
		sql.append(" BED_CLASS_SHORT_DESC,COUNT(BED_CLASS_CODE) BEDS_SETUP, ");
		sql.append(" SUM(CASE  WHEN PSEUDO_BED_YN ='Y' THEN 1 ELSE 0  END ) PSEUDO_BEDS, ");
		sql.append(" SUM(CASE  WHEN CURRENT_STATUS ='O'  THEN 1 ELSE 0  END ) OCCUPIED_BEDS, ");
		sql.append(" COUNT(BED_CLASS_CODE)+SUM(CASE  ");
		sql.append(" WHEN PSEUDO_BED_YN ='Y' THEN 1 ELSE 0  END ) - ");
		sql.append(" SUM(CASE  WHEN CURRENT_STATUS ='O'  THEN 1 ELSE 0  END ) AVAILABLE ");
		sql.append(" FROM IP_NURSING_UNIT_BED_VW ");
		sql.append(" WHERE FACILITY_ID = ? ");
		sql.append(" "+whereClause.toString()+" ");
		sql.append(" GROUP BY NURSING_UNIT_CODE,NURSING_UNIT_SHORT_DESC, ");
		sql.append(" BED_CLASS_CODE, BED_CLASS_SHORT_DESC ");

		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,facilityid);
	
		out.println("<tr><th rowspan=2>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</th><th rowspan=2>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"</th><th colspan=4 align=center>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Beds.label","ip_labels")+"</th></tr>");
		out.println("<tr><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.setup.label","common_labels")+"</th>	<th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Pseudo.label","ip_labels")+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Occupied.label","common_labels")+"</th><th align=right>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.available.label","common_labels")+"</th></tr>");
				
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			if(i%2 == 0)
				className = "QRYEVEN";
			else
				className = "QRYODD";
			
			out.println("<tr><td class='"+className+"'>"+rs.getString("NURSING_UNIT_CODE")+"&nbsp;&nbsp;"+rs.getString("NURSING_UNIT_SHORT_DESC")+"</td>");
			out.println("<td class='"+className+"'>"+rs.getString("BED_CLASS_CODE")+"&nbsp;&nbsp;"+rs.getString("BED_CLASS_SHORT_DESC")+"</td>");
			out.println("<td align=right width='10%' class='"+className+"'>"+rs.getString("BEDS_SETUP")+"</td>");
			out.println("<td align=right width='10%' class='"+className+"'>"+rs.getString("PSEUDO_BEDS")+"</td>");
			out.println("<td align=right width='10%' class='"+className+"'>"+rs.getString("OCCUPIED_BEDS")+"</td>");
			out.println("<td align=right width='10%' class='"+className+"'>"+rs.getString("AVAILABLE")+"</td></tr>");
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

