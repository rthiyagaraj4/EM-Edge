<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*,java.net.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
	
    <script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<%
			Connection con = null;
			Statement stmt = null;
			ResultSet rs =null;
			int maxRecord=0;
			int start=1;
			int end=0;
			int records_to_show=14;

    		StringBuffer sql = new StringBuffer();

			String facilityid = (String)session.getValue("facility_id");
			String locale       =(String) session.getAttribute("LOCALE"); 
			String dailymonthly = request.getParameter("daily_monthly");
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			StringBuffer whereClause = new StringBuffer();
			whereClause.append(checkForNull(request.getParameter("whereclause")));
			String nursingunit	= checkForNull(request.getParameter("nursing_unit"));
			String splcode		= checkForNull(request.getParameter("Splcode"));
			String fromdate		= checkForNull(request.getParameter("from_date"));
			if(!fromdate.equals(""))
				fromdate = DateUtils.convertDate(fromdate,"DMY",locale,"en"); 
			String todate		= checkForNull(request.getParameter("to_date"));
			if(!todate.equals(""))
				todate = DateUtils.convertDate(todate,"DMY",locale,"en"); 
			String frommonth	= checkForNull(request.getParameter("from_month"));
			if(!frommonth.equals(""))
				frommonth = DateUtils.convertDate(frommonth,"MY",locale,"en"); 
			String tomonth		= checkForNull(request.getParameter("to_month"));
			if(!tomonth.equals(""))
				tomonth = DateUtils.convertDate(tomonth,"MY",locale,"en"); 
			String servicecode	= checkForNull(request.getParameter("servicecode"));
			String statisticby		= checkForNull(request.getParameter("statisticby"));
			
			String prevcode = "";
			String prevdate = "";
			String className = "";
			String prev_nursing_unit = "";

			int i = 0;
		
			if(statisticby.equals("C"))
			{
				if(!nursingunit.equals("") )
					whereClause.append(" and a.TO_NURSING_UNIT = '"+nursingunit+"' ");
				if(!splcode.equals("") )
					whereClause.append(" and a.TO_SPECIALTY_CODE = '"+splcode+"' ");
				if(!servicecode.equals("") )
					whereClause.append(" and a.TO_SERVICE_CODE = '"+servicecode+"' ");
			}
			else if(statisticby.equals("N"))
			{
				if(!nursingunit.equals("") )
					whereClause.append(" and a.TO_NURSING_UNIT = '"+nursingunit+"' ");
				if(!splcode.equals("") )
					whereClause.append(" and a.TO_SPECIALTY_CODE = '"+splcode+"' ");
				if(!servicecode.equals("") )
					whereClause.append(" and a.TO_SERVICE_CODE = '"+servicecode+"' ");
			}
			else if(statisticby.equals("S"))
			{
				if(!nursingunit.equals("") )
					whereClause.append(" and a.TO_NURSING_UNIT = '"+nursingunit+"' ");
				if(!splcode.equals("") )
					whereClause.append(" and a.TO_SPECIALTY_CODE = '"+splcode+"' ");
				if(!servicecode.equals("") )
					whereClause.append(" and a.TO_SERVICE_CODE = '"+servicecode+"' ");
			}
	
			if(!fromdate.equals("") || !todate.equals(""))
				whereClause.append(" and trunc(trn_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!frommonth.equals("") || !tomonth.equals(""))
				whereClause.append(" and to_date(to_char(trn_date_time,'MM/rrrr'),'mm/rrrr') between to_date(nvl('"+frommonth+"','1/1111'),'mm/rrrr') and to_date(nvl('"+tomonth+"','9/9999'),'mm/rrrr') ");
			
		%>
</head>							
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<%
			try{
				con =ConnectionManager.getConnection(request);

				//Added by Devang for Previous/Next logic
				if(dailymonthly.equals("D"))
				{
					if (sql.length() > 0)
						sql.delete(0, sql.length());

					if(statisticby!=null && statisticby.equals("N"))
						sql.append("SELECT  a.TO_NURSING_UNIT  code,IP_GET_DESC.IP_NURSING_UNIT( A.FACILITY_ID, a.TO_NURSING_UNIT,'"+localeName+"','2') NURSING_UNIT,TO_CHAR(TRN_DATE_TIME,'DD/MM/rrrr') display_date,COUNT(TO_BED_NO) TOT_ADM FROM IP_ADT_TRN A WHERE A.FACILITY_ID = '"+facilityid+"' AND TRN_TYPE='A' AND  ADT_TRN_STATUS !='8' AND TO_BED_NO IS NOT NULL AND PATIENT_CLASS = 'IP' "+whereClause.toString()+" GROUP BY a.to_nursing_unit,ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ),TO_CHAR (trn_date_time, 'DD/MM/rrrr') ORDER BY ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ),TO_DATE (TO_CHAR (trn_date_time, 'DD/MM/rrrr'), 'DD/MM/rrrr')");

					else if(statisticby!=null && statisticby.equals("S"))
						sql.append("SELECT  a.to_specialty_code  code,am_get_desc.am_speciality (a.to_specialty_code, '"+localeName+"', '2') specialty,TO_CHAR (trn_date_time, 'DD/MM/rrrr') display_date, IP_GET_DESC.IP_NURSING_UNIT( A.FACILITY_ID, a.TO_NURSING_UNIT,'"+localeName+"','2') NURSING_UNIT ,COUNT (to_bed_no) tot_adm FROM ip_adt_trn a WHERE A.FACILITY_ID = '"+facilityid+"' AND TRN_TYPE='A' AND  ADT_TRN_STATUS !='8' AND TO_BED_NO IS NOT NULL AND PATIENT_CLASS = 'IP' "+whereClause.toString()+" GROUP BY a.to_specialty_code,am_get_desc.am_speciality (a.to_specialty_code, '"+localeName+"', '2'), TO_CHAR (trn_date_time, 'DD/MM/rrrr'), ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ) ORDER BY am_get_desc.am_speciality (a.to_specialty_code, '"+localeName+"', '2'),ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ),TO_DATE (TO_CHAR (trn_date_time, 'DD/MM/rrrr'), 'DD/MM/rrrr')");

					else if(statisticby!=null && statisticby.equals("C"))
						sql.append("select a.to_service_code code ,am_get_desc.am_service (a.to_service_code, '"+localeName+"', '2') service, TO_CHAR (trn_date_time, 'DD/MM/rrrr') display_date,IP_GET_DESC.IP_NURSING_UNIT( A.FACILITY_ID, a.TO_NURSING_UNIT,'"+localeName+"','2') NURSING_UNIT,  COUNT (to_bed_no) tot_adm FROM ip_adt_trn a WHERE A.FACILITY_ID = '"+facilityid+"' AND TRN_TYPE='A' AND  ADT_TRN_STATUS !='8' AND TO_BED_NO IS NOT NULL AND PATIENT_CLASS = 'IP' "+whereClause.toString()+" GROUP BY a.to_service_code, am_get_desc.am_service (a.to_service_code, '"+localeName+"', '2'), TO_CHAR (trn_date_time, 'DD/MM/rrrr'),ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ) ORDER BY am_get_desc.am_service (a.to_service_code, '"+localeName+"', '2'),ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ), TO_DATE (TO_CHAR (trn_date_time, 'DD/MM/rrrr'), 'DD/MM/rrrr')");
				}
				else
				{
					if (sql.length() > 0)
						sql.delete(0, sql.length());
					

					if(statisticby!=null && statisticby.equals("N"))
						sql.append("SELECT  a.TO_NURSING_UNIT  code,IP_GET_DESC.IP_NURSING_UNIT( A.FACILITY_ID, a.TO_NURSING_UNIT,'"+localeName+"','2') NURSING_UNIT,TO_CHAR(TRN_DATE_TIME,'MM/rrrr') display_date,COUNT(TO_BED_NO) TOT_ADM FROM IP_ADT_TRN A WHERE A.FACILITY_ID = '"+facilityid+"' AND TRN_TYPE='A' AND  ADT_TRN_STATUS !='8' AND TO_BED_NO IS NOT NULL AND PATIENT_CLASS = 'IP' "+whereClause.toString()+" GROUP BY a.to_nursing_unit,ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ),TO_CHAR (trn_date_time, 'MM/rrrr') ORDER BY ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ),TO_DATE (TO_CHAR (trn_date_time, 'MM/rrrr'), 'MM/rrrr')");

					else if(statisticby!=null && statisticby.equals("S"))
						sql.append("SELECT  a.to_specialty_code  code,am_get_desc.am_speciality (a.to_specialty_code, '"+localeName+"', '2') specialty,TO_CHAR (trn_date_time, 'MM/rrrr') display_date, IP_GET_DESC.IP_NURSING_UNIT( A.FACILITY_ID, a.TO_NURSING_UNIT,'"+localeName+"','2') NURSING_UNIT,COUNT (to_bed_no) tot_adm FROM ip_adt_trn a WHERE A.FACILITY_ID = '"+facilityid+"' AND TRN_TYPE='A' AND  ADT_TRN_STATUS !='8' AND TO_BED_NO IS NOT NULL AND PATIENT_CLASS = 'IP' "+whereClause.toString()+" GROUP BY a.to_specialty_code,am_get_desc.am_speciality (a.to_specialty_code, '"+localeName+"', '2'), TO_CHAR (trn_date_time, 'MM/rrrr'),ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ) ORDER BY am_get_desc.am_speciality (a.to_specialty_code, '"+localeName+"', '2'),ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ),TO_DATE (TO_CHAR (trn_date_time, 'MM/rrrr'), 'MM/rrrr')");

					else if(statisticby!=null && statisticby.equals("C"))
						sql.append("select a.to_service_code code ,am_get_desc.am_service (a.to_service_code, '"+localeName+"', '2') service, TO_CHAR (trn_date_time, 'MM/rrrr') display_date,  IP_GET_DESC.IP_NURSING_UNIT( A.FACILITY_ID, a.TO_NURSING_UNIT,'"+localeName+"','2') NURSING_UNIT, COUNT (to_bed_no) tot_adm FROM ip_adt_trn a WHERE A.FACILITY_ID = '"+facilityid+"' AND TRN_TYPE='A' AND  ADT_TRN_STATUS !='8' AND TO_BED_NO IS NOT NULL AND PATIENT_CLASS = 'IP' "+whereClause.toString()+" GROUP BY a.to_service_code, am_get_desc.am_service (a.to_service_code, '"+localeName+"', '2'), TO_CHAR (trn_date_time, 'MM/rrrr'),ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ) ORDER BY am_get_desc.am_service (a.to_service_code, '"+localeName+"', '2'),ip_get_desc.ip_nursing_unit (a.facility_id,a.to_nursing_unit,'"+localeName+"','2' ), TO_DATE (TO_CHAR (trn_date_time, 'MM/rrrr'), 'MM/rrrr')");
				}

	

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

				while(( z < records_to_show) && rs.next())
				{
					if(maxRecord==0)
					{				
						out.println("<p><table align='right'><tr>");
						if ( !(start <= 0) )
							out.println("<td id='prev'><A HREF='../jsp/QueryAdmByNursingUnitSpecialtyResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&daily_monthly="+dailymonthly+"&statisticby="+statisticby+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
						" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
                  
                        out.println("<td id='next' style='visibility:hidden'><A HREF='../jsp/QueryAdmByNursingUnitSpecialtyResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&daily_monthly="+dailymonthly+"&statisticby="+statisticby+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
						+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
						
						out.println("</tr></table></p>");
						out.println("<br><br>");
				
				out.println("<table  cellpadding=0 cellspacing=0 border=1 width='80%' align='center'>");

				if(dailymonthly.equals("D"))
				{
					out.println("<div style='padding-left: 190px;'><font size=2 color=NAVY><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DailyAdmissions.label","ip_labels")+"</b></font></div>");
				}
				else
				{
					out.println("<div style='padding-left: 190px;'><font size=2 color=NAVY><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MonthlyAdmission.label","ip_labels")+"</b></font><div>");
				}
				if(statisticby!=null && statisticby.equals("C"))
					out.println("<tr><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TotalAdmission.label","ip_labels")+"</th></tr>");
				else if(statisticby!=null && statisticby.equals("N"))
					out.println("<tr><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TotalAdmission.label","ip_labels")+"</th></tr>");

				else if(statisticby!=null && statisticby.equals("S"))
					out.println("<tr><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TotalAdmission.label","ip_labels")+"</th></tr>");

				
				}
				
					z++;
					if(i%2 == 0)
						className = "QRYEVEN";
					else
						className = "QRYODD";
					
					String currcode = rs.getString("code");
					String currdate = rs.getString("display_date");

					String currdate_display = rs.getString("display_date");
					String curr_nursing_unit = rs.getString("nursing_unit");
					if(currdate_display == null)
						currdate_display = "";
					else
					{
						if(dailymonthly.equals("D"))
							currdate_display = DateUtils.convertDate(currdate_display,"DMY","en",locale);
						else
							currdate_display = DateUtils.convertDate(currdate_display,"MY","en",locale);
					}
					
					if(!prevcode.equals(currcode) )
					{
						if(statisticby!=null && statisticby.equals("N"))
						{
							out.println("<tr><th colspan=2 align='left' class=CAGROUPHEADING>"+rs.getString("nursing_unit")+"</th></tr>");
							out.println("<tr><td class='"+className+"'>"+currdate_display+"</td>");
							out.println("<td width='15%' align='right' class='"+className+"' >"+rs.getString("tot_adm")+"</td></tr>");
							
						}
						else if(statisticby!=null && statisticby.equals("S"))
						{
							out.println("<tr><th colspan=2 align='left' class=CAGROUPHEADING>"+rs.getString("specialty")+"</th></tr>");
							out.println("<tr><td colspan=2 class=CAGROUPHEADING>"+rs.getString("nursing_unit")+"</td></tr>");
						}
						else if(statisticby!=null && statisticby.equals("C"))
						{
							out.println("<tr><th colspan=2 align='left' class=CAGROUPHEADING>"+rs.getString("service")+"</th></tr>");
							out.println("<tr><td colspan=2 class=CAGROUPHEADING>"+rs.getString("nursing_unit")+"</td></tr>");
						}
						
						
					}
					else if(!prevdate.equals(currdate))
					{
						if(statisticby!=null && statisticby.equals("N"))
						{
							out.println("<tr><td  class='"+className+"'>"+currdate_display+"</td>");
							out.println("<td width='15%' align='right' class='"+className+"' >"+rs.getString("tot_adm")+"</td></tr>");
						}
						if(!prev_nursing_unit.equals(curr_nursing_unit))
						{
							if(statisticby!=null && statisticby.equals("S"))
							{
								out.println("<tr><td colspan=2 class=CAGROUPHEADING>"+rs.getString("nursing_unit")+"</td></tr>");
							}
							else if(statisticby!=null && statisticby.equals("C"))
							{
								out.println("<tr><td colspan=2 class=CAGROUPHEADING>"+rs.getString("nursing_unit")+"</td></tr>");
							}
						}
					}
					
					if(statisticby!=null && statisticby.equals("C"))
						out.println("<tr><td class='"+className+"' >"+currdate_display+"</td>");
					else if(statisticby!=null && statisticby.equals("S"))
						out.println("<tr><td class='"+className+"' >"+currdate_display+"</td>");
					if(statisticby!=null && !statisticby.equals("N"))
						out.println("<td width='15%' align='right' class='"+className+"' >"+rs.getString("tot_adm")+"</td></tr>");
					
					prevcode = currcode;
					prevdate = currdate;
					prev_nursing_unit = curr_nursing_unit;
					i++;
					maxRecord++;
				}

				out.println("</table>");

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
				//}

				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				//if (rs_count != null) rs_count.close();
				//if (pstmt_count != null) pstmt_count.close();

			}catch(Exception e) {out.println(sql);out.println(e.toString());e.printStackTrace();}
			finally
			{
				ConnectionManager.returnConnection(con,request);
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

