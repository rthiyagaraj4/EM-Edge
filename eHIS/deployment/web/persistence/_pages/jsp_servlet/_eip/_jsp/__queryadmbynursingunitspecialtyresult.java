package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import java.net.*;

public final class __queryadmbynursingunitspecialtyresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eip/jsp/QueryAdmByNursingUnitSpecialtyResult.jsp", 1742452489208L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n    <script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

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
			
		
            _bw.write(_wl_block8Bytes, _wl_block8);

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
						
            _bw.write(_wl_block9Bytes, _wl_block9);
 
					}
					else
					{
            _bw.write(_wl_block10Bytes, _wl_block10);

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
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
