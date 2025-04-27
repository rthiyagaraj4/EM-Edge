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
import eCommon.XSSRequestWrapper;

public final class __bulktransferappointmentframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/BulkTransferAppointmentFrame.jsp", 1717666116604L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\n<html>\n<head>\n\n\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script language=\'javascript\' src=\'../../eOA/js/BulkTransferAppointment.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\"NO_OPER_STN_FOR_USER\",\"Common\"));\n\t\t\t\t\t//location.href=\'../../eCommon/jsp/home.jsp\';\n\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="  scrolling=\'no\' noresize style=\'height:8vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t<iframe name=\'frame1\' id=\'frame1\' \tsrc=\'../../eOA/jsp/BulkTransferAppointmentcriteria.jsp?oper_stn_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&currentdate=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&tfr_appt_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&book_appt_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&visit_limit_rule=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'   scrolling=\'no\' style=\'height:32vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t<iframe name=\'frame2\' id=\'frame2\' \tsrc=\'../../eCommon/html/blank.html\'  scrolling=\'no\' style=\'height:46vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t<iframe name=\'frame3submit\' id=\'frame3submit\' \tsrc=\'../../eCommon/html/blank.html\'  scrolling=\'no\' style=\'height:4vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\'  noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\' frameborder=\'0\'></iframe>\n\n\t</html>\n\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	
	String source = url + params ;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs=null;
	String facilityid=(String)session.getValue("facility_id");
	String globaluser = (String)session.getValue("login_user");
	String oper_stn_id="";
	String currentdate="";
	//String canc_appt_yn="";
	String tfr_appt_yn="";
	String book_appt_yn="";
	boolean allow_inside=true;
	String visit_limit_rule = "";

	try{

		con = ConnectionManager.getConnection(request);
		 stmt = con.createStatement();
	
		String sql2="SELECT a.oper_stn_id, tfr_appt_yn, book_appt_yn, to_char(sysdate,'dd/mm/yyyy') dt, (select visit_limit_rule from oa_param where module_id='OA') visit_limit_rule FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"'	AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";

		
				rs=stmt.executeQuery(sql2);
				if (rs!=null && rs.next()){
					oper_stn_id = rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
					currentdate = rs.getString("dt")==null?"":rs.getString("dt");
					//canc_appt_yn=rs.getString("canc_appt_yn");
					tfr_appt_yn = rs.getString("tfr_appt_yn")==null?"":rs.getString("tfr_appt_yn");
					book_appt_yn = rs.getString("book_appt_yn")==null?"":rs.getString("book_appt_yn");
					visit_limit_rule = rs.getString("visit_limit_rule")==null?"":rs.getString("visit_limit_rule");
				}else{					
					allow_inside = false;
				
            _bw.write(_wl_block9Bytes, _wl_block9);

				}
	
			
	
            _bw.write(_wl_block10Bytes, _wl_block10);
if(allow_inside){
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block17Bytes, _wl_block17);

	}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
}
catch(Exception es){
	//out.println("Excep" + es);
	es.printStackTrace();
}
finally{
	ConnectionManager.returnConnection(con,request);
}


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
