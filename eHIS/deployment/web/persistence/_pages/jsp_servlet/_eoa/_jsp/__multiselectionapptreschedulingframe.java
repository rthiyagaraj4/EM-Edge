package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;

public final class __multiselectionapptreschedulingframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/MultiSelectionApptReschedulingFrame.jsp", 1745479495540L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--Created by Ashwini on 05-Apr-2024 for ML-MMOH-CRF-2060-->\r\n<!DOCTYPE html>\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\r\n<html>\r\n<head>\r\n\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\r\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\r\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\'javascript\' src=\'../../eOA/js/MultiSelectionApptRescheduling.js\'></script>\r\n\t\r\n</head>\r\n\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\t\t\r\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" frameborder=0 scrolling=\'no\' noresize frameborder=\'0\' style=\'height:6vh;width:100vw\'></iframe>\r\n\t\t\t<iframe name=\'frame1\' id=\'frame1\' \tsrc=\'../../eOA/jsp/MultiSelectionApptReschedulingCriteria.jsp?oper_stn_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&currentdate=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&tfr_appt_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&book_appt_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&visit_limit_rule=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=0  scrolling=\'no\' frameborder=\'0\' style=\'height:25vh;width:100vw\'></iframe>\r\n\t\t\t<iframe name=\'frame2\' id=\'frame2\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' frameborder=\'0\' style=\'height:35vh;width:100vw\'></iframe>\r\n\t\t\t<iframe name=\'frame3submit\' id=\'frame3submit\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' frameborder=\'0\' style=\'height:25vh;width:100vw\'></iframe>\r\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' frameborder=\'0\' style=\'height:8vh;width:100vw\'></iframe>\r\n\t\t\r\n\r\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\r\n\t\r\n\t\t<script>\r\n\t\t\talert(getMessage(\"NO_OPER_STN_FOR_USER\",\"Common\"));\r\n\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\r\n\t\t</script>\r\n\r\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\r\n\r\n</html>\r\n\r\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\r\n\r\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

public static JSONObject getAMOperatorStationSetupDtls(Connection con, String facilityid, String globaluser) throws Exception{

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String oper_stn_id = "";
	String currentdate = "";
	String tfr_appt_yn = "";
	String book_appt_yn = "";
	String visit_limit_rule = "";
	String allow_inside = "";
	
	JSONObject jsonObj = new JSONObject();

	try{
		String sql = "SELECT a.oper_stn_id, tfr_appt_yn, book_appt_yn, TO_CHAR (SYSDATE, 'dd/mm/yyyy') dt, (SELECT visit_limit_rule FROM oa_param WHERE module_id = 'OA') visit_limit_rule FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id = ? AND a.facility_id = b.facility_id AND a.oper_stn_id = b.oper_stn_id AND b.appl_user_id = ? AND TRUNC (SYSDATE) BETWEEN b.eff_date_from AND NVL (b.eff_date_to, TRUNC (SYSDATE))";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1,facilityid);
		pstmt.setString(2,globaluser);
		
		rs	= pstmt.executeQuery();

		if(rs!=null && rs.next()){
			oper_stn_id = rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
			currentdate = rs.getString("dt")==null?"":rs.getString("dt");
			tfr_appt_yn = rs.getString("tfr_appt_yn")==null?"":rs.getString("tfr_appt_yn");
			book_appt_yn = rs.getString("book_appt_yn")==null?"":rs.getString("book_appt_yn");
			visit_limit_rule = rs.getString("visit_limit_rule")==null?"":rs.getString("visit_limit_rule");
			allow_inside = "Y";
		}else{
			allow_inside = "N";
		}

		jsonObj.put("oper_stn_id",oper_stn_id);
		jsonObj.put("currentdate",currentdate);
		jsonObj.put("tfr_appt_yn",tfr_appt_yn);
		jsonObj.put("book_appt_yn",book_appt_yn);
		jsonObj.put("visit_limit_rule",visit_limit_rule);
		jsonObj.put("allow_inside",allow_inside);
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception ex){
			System.err.println("Exception in getAMOperatorStationSetupDtls - "+ex.getMessage());
			ex.printStackTrace();
		}
	}
	return jsonObj;
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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8"); 

request = new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	
String url = "../../eCommon/jsp/commonToolbar.jsp?";
String params = request.getQueryString();
String source = url + params;

String facilityid = (String)session.getValue("facility_id");
String globaluser = (String)session.getValue("login_user");

Connection con = null;
String oper_stn_id = "";
String currentdate = "";
String tfr_appt_yn = "";
String book_appt_yn = "";
String visit_limit_rule = "";
String allow_inside = "";

try{

	con = ConnectionManager.getConnection(request);

	JSONObject json = getAMOperatorStationSetupDtls(con,facilityid,globaluser);
	oper_stn_id = (String) json.get("oper_stn_id");			
	currentdate = (String) json.get("currentdate");
	tfr_appt_yn = (String) json.get("tfr_appt_yn");
	book_appt_yn = (String) json.get("book_appt_yn");
	visit_limit_rule = (String) json.get("visit_limit_rule");
	allow_inside = (String) json.get("allow_inside");

	if(allow_inside.equals("Y")){
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);


}catch(Exception es){
	es.printStackTrace();
}
finally{
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
