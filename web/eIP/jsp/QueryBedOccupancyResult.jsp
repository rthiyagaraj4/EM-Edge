<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,java.net.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<%String facilityid = (String)session.getValue("facility_id");%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>       
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<%
			Connection con = null;
			Statement stmt = null;
			//PreparedStatement pstmt = null;
			//PreparedStatement pstmt_count = null;
			ResultSet rs =null;
			//ResultSet rs_count =null;
			//StringBuffer sql_count = new StringBuffer();
			StringBuffer sql = new StringBuffer();

			//int total_count=0;
			int maxRecord=0;
			int start=1;
			int end=0;
			int records_to_show=14;

			String from = request.getParameter("from");
			String to = request.getParameter("to");
			StringBuffer whereClause	= new StringBuffer();
			whereClause.append(checkForNull(request.getParameter("whereclause")));
			String splcode			= checkForNull(request.getParameter("Splcode"));
			String fromnursingunit	= checkForNull(request.getParameter("fr_nursing_unit"));
			String tonursingunit	= checkForNull(request.getParameter("to_nursing_unit"));
			String locale			= (String)session.getAttribute("LOCALE");
			
			String prevsplty = "";
			String className = "";
			
			int i = 0;

			if(!fromnursingunit.equals("") || !tonursingunit.equals(""))
				whereClause.append(" and a.nursing_unit_code BETWEEN  NVL('"+fromnursingunit+"','!') AND  NVL('"+tonursingunit+"','~') ");
			if(!splcode.equals(""))
				whereClause.append(" and a.specialty_code = '"+splcode+"'");
			
			
		%>
</head>							
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<%
			try
			{
				con =ConnectionManager.getConnection(request);
				
				//sql.append("SELECT AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specailty_short_desc, IP_GET_DESC.IP_NURSING_UNIT(A.facility_id, A.nursing_unit_code,'"+locale+"','2') Nursing_Unit, count(bed_no) total,count(decode(current_status,'O','Occupied')) bed_occupied, count(decode(current_status,'A','Available')) bed_available FROM IP_NURSING_UNIT_BED A WHERE A.facility_id= '"+facilityid+"' and a.pseudo_bed_yn = 'N' "+whereClause.toString()+" GROUP BY  AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') ,IP_GET_DESC.IP_NURSING_UNIT(A.facility_id, A.nursing_unit_code,'"+locale+"','2') ORDER BY specailty_short_desc, Nursing_Unit ");

				sql.append(" SELECT AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specailty_short_desc, IP_GET_DESC.IP_NURSING_UNIT(A.facility_id, A.nursing_unit_code,'"+locale+"','2') nursing_unit, COUNT (a.bed_no) total,COUNT (DECODE (a.current_status, 'O', 'Occupied')) bed_occupied,COUNT (DECODE (a.current_status, 'A', 'Available'))- count(b.req_bed_no) bed_available,count(b.req_bed_no) blocked FROM IP_NURSING_UNIT_BED_VW a,(select facility_id, req_nursing_unit_code, req_bed_no  from IP_BED_BOOKING where facility_id = '"+facilityid+"' and booking_status = '0' and sysdate between blocked_from_date_time and blocked_until_date_time) b WHERE a.facility_id = '"+facilityid+"'AND a.pseudo_bed_yn = 'N' AND a.appl_patient_class = 'IP' and a.nursing_unit_code = b.req_nursing_unit_code (+)and a.bed_no = b.req_bed_no(+) "+whereClause.toString()+" GROUP BY AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2'), IP_GET_DESC.IP_NURSING_UNIT(A.facility_id, A.nursing_unit_code,'"+locale+"','2') ORDER BY specailty_short_desc, nursing_unit ");

				//out.println("sql:"+sql.toString());
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql.toString());

				if ( from == null )
                    start = 0 ;
                else
                    start = Integer.parseInt( from ) ;
                
                if ( to == null )
                    end = records_to_show ;
                else
                    end = Integer.parseInt( to ) ;

				if(start > 1)
				{
					for(int k=0; k < start ;k++)
						rs.next();
				}

				int z=0;

				while((z < records_to_show) && rs.next())
				{
					if(maxRecord==0)
					{
						out.println("<p><table align='right'><tr>");
						if ( !(start <= 0) )
						out.println("<td id='prev'><A HREF='../jsp/QueryBedOccupancyResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
						" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

						out.println("<td id='next' style='visibility:hidden'><A HREF='../jsp/QueryBedOccupancyResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
						+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
						out.println("</tr></table></p>");
						out.println("<br><br>");

						out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");
						out.println("<tr><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TotalBeds.label","ip_labels")+"&nbsp;"+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Occupied.label","common_labels")+"&nbsp;"+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.blocked.label","common_labels")+"&nbsp;"+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Vacant.label","common_labels")+"&nbsp;"+"</th></tr>");
					}

					z++;
					if(i%2 == 0)
					className = "QRYEVENCEN";
					else
					className = "QRYODDCEN";

					int blocked_count = rs.getInt("total") - rs.getInt("bed_occupied") - rs.getInt("bed_available");
					String currsplty = rs.getString("specailty_short_desc");
					if (currsplty==null) currsplty = "";

					if(!prevsplty.equals(currsplty) && !currsplty.equals(""))
					{
					out.println("<tr><td colspan=5 class=CAGROUPHEADING>"+currsplty+"</td></tr>");
					}
					if (currsplty.equals("") && !prevsplty.equals("blank"))
					{
					out.println("<tr><td colspan=5 class=CAGROUPHEADING>*"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AllSPLTY.label","ip_labels")+"*</td></tr>");
					}

					out.println("<tr><td class='"+className+"' style='text-align:left;' >&nbsp;&nbsp;"+rs.getString("Nursing_Unit")+"</td>");
					out.println("<td width='20%' class='"+className+"'>"+rs.getString("total")+"</td>");
					out.println("<td width='20%' class='"+className+"'>"+rs.getString("bed_occupied")+"</td>");
					out.println("<td width='20%' class='"+className+"'>"+blocked_count+"</td>");
					out.println("<td width='20%' class='"+className+"'>"+rs.getString("bed_available")+"</td></tr>");
					if (!currsplty.equals(""))
					prevsplty = currsplty;
					else
					prevsplty = "blank";
					i++;
					maxRecord++;
					}
				out.println("</table>");
				//}

					
				if ( maxRecord < 14 || (!rs.next()) )
					{
						%>
						<script >
							if (document.getElementById('next'))
								document.getElementById('next').style.visibility='hidden';
						</script>
						<% 
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
				if(maxRecord==0)
				{
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}

				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				//if (pstmt != null) pstmt.close();
				//if (rs_count != null) rs_count.close();
				//if (pstmt_count != null) pstmt_count.close();
			}catch(Exception e) 
			{
				out.println(e.toString());
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);

				//added on 20-10-2003 by dhanasekaran
				out.print("<script>if(parent.frames[1].document.forms[0]!= null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
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

