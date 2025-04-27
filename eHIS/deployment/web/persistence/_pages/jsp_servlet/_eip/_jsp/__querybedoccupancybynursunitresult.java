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

public final class __querybedoccupancybynursunitresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryBedOccupancyByNursUnitResult.jsp", 1709117852227L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
String facilityid = (String)session.getValue("facility_id");
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

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
		
            _bw.write(_wl_block4Bytes, _wl_block4);

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
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
