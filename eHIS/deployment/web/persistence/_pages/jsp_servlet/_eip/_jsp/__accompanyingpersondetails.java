package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __accompanyingpersondetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AccompanyingPersonDetails.jsp", 1709117685582L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>                         \n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<br>\n    </body>\n</html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	Connection con = null;
	Statement statement		=	null;
	PreparedStatement pstmt = 	null;
	ResultSet resultSet		=	null;
	try
	{
		String facility_id	=	checkForNull((String)session.getValue("facility_id"));
		String encounterId  =	checkForNull(request.getParameter("encounterId"));
		con	= ConnectionManager.getConnection(request);

		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("SELECT a.lodger_ref_no, DECODE (a.attached_to_inpatient_yn, ");
		stringBuffer.append("'Y', 'Attendant', 'N', 'Lodger') accom_categ, ");
		stringBuffer.append("NVL (b.short_desc, 'Other Places') nursing_unit_short_desc, ");
		stringBuffer.append("a.attached_to_inpatient_yn, a.patient_encounter_id, d.patient_id, ");
		stringBuffer.append("a.lodger_patient_id, a.lodger_name, TO_CHAR (check_in_date_time, ");
		stringBuffer.append("'dd/mm/rrrr hh24:mi') check_in_date_time, ");
		stringBuffer.append("check_in_date_time check_in_date_time1, lodger_gender, ");
		stringBuffer.append("e.short_desc reason_for_stay_code, c.encounter_id, ");
		stringBuffer.append("TO_CHAR (period_from_date, 'dd/mm/rrrr hh24:mi') period_from_date, ");
		stringBuffer.append("TO_CHAR (period_to_date, 'dd/mm/rrrr hh24:mi') period_to_date ");
		stringBuffer.append("FROM ip_lodger_detail a, ip_nursing_unit b,pr_encounter c,mp_patient d,");
		stringBuffer.append(" ip_reason_for_lodger_stay e WHERE a.facility_id = ? ");
		//stringBuffer.append(facility_id);
		stringBuffer.append(" AND a.check_out_yn = 'N' and a.patient_encounter_id = ? ");
		//stringBuffer.append(encounterId);
		stringBuffer.append(" AND b.facility_id(+) = a.facility_id ");
		stringBuffer.append("AND b.nursing_unit_code(+) = a.nursing_unit_code ");
		stringBuffer.append("AND c.facility_id(+) = a.facility_id ");
		stringBuffer.append("AND c.encounter_id(+) = a.patient_encounter_id ");
		stringBuffer.append("AND d.patient_id(+) = c.patient_id ");
		stringBuffer.append("AND a.reason_for_stay_code = e.reason_for_stay_code(+) ORDER BY ");
		stringBuffer.append("accom_categ, nursing_unit_short_desc, check_in_date_time1 desc ");

		pstmt = con.prepareStatement(stringBuffer.toString());
		pstmt.setString(1, facility_id);
		pstmt.setString(2, encounterId);
		resultSet = pstmt.executeQuery();
/*         resultSet = statement.executeQuery(stringBuffer.toString()) ; */
		out.println("<table width='100%' cellspacing=0 cellpadding=0 border=1>") ;
		out.println( "<tr>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonID.label","ip_labels")+"</th>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonName.label","ip_labels")+"</th>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.periodfrom.label","common_labels")+"</th>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.periodto.label","common_labels")+"</th>" ) ;
        
		if(resultSet!=null)
        {
			String cname= "QRYEVEN" ;

			while(resultSet.next()) 
            {
                if(cname.equals("QRYEVEN"))
                    cname = "QRYODD" ;
                else
                    cname = "QRYEVEN" ;

				out.println( "<tr>" ) ;
				out.println ( "<td class='"+cname+"'>");
				out.println(resultSet.getString("lodger_patient_id")==null ? "&nbsp; ": resultSet.getString("lodger_patient_id") +"</td>") ;
				out.println ( "<td class='"+cname+"'>"+checkForNull(resultSet.getString("lodger_name"))+"</td>") ;
				out.println ( "<td class='"+cname+"'> "+  (resultSet.getString("PERIOD_FROM_DATE") ==null? "&nbsp;":(resultSet.getString("PERIOD_FROM_DATE")) ) +"</td>" ) ;
				out.println ( "<td class='"+cname+"'> "+  (resultSet.getString("PERIOD_TO_DATE") ==null? "&nbsp;":(resultSet.getString("PERIOD_TO_DATE")) ) +"</td>" ) ;
				out.println( "</tr>" ) ;
			}
		}
			out.println("</table>");
        
			if (resultSet != null)   resultSet.close();  
			if (statement != null) statement.close();
			if (pstmt != null) pstmt.close();
			
		}catch(Exception e) 
		{ 
/* 			out.println(e.toString()); */
			e.printStackTrace();
		}
	    finally 
		{
			ConnectionManager.returnConnection(con,request);
        }
    
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
