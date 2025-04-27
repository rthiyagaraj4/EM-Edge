package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.net.*;

public final class __querybedoccupancyresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryBedOccupancyResult.jsp", 1742452522406L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>       \n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
String facilityid = (String)session.getValue("facility_id");
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

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
			
			
		
            _bw.write(_wl_block4Bytes, _wl_block4);

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
						
            _bw.write(_wl_block5Bytes, _wl_block5);
 
					}
					else
					{
            _bw.write(_wl_block6Bytes, _wl_block6);

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
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
