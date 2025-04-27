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

public final class __transfercancelappointment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/TransferCancelAppointment.jsp", 1722422414446L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script language=\'javascript\' src=\'../../eOA/js/TransferCancelAppointment.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_OPER_STN_FOR_USER\",\"Common\"));\n\t\t\t//location.href=\'../../eCommon/jsp/home.jsp\';\n\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\t\t\t\t\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="  scrolling=\'no\' noresize style=\'height:8vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<iframe name=\'frame1\' id=\'frame1\' \tsrc=\'../../eOA/jsp/TransferCancelAppointmentQueryCriteria.jsp?functionid=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&oper_stn_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&currentdate=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&canc_appt_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&tfr_appt_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&book_appt_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&resch=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' scrolling=\'no\' style=\'height:42vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&called_for=Link&oper_stn_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'  scrolling=\'no\' style=\'height:42vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<iframe name=\'frame2\' id=\'frame2\' \tsrc=\'../../eCommon/html/blank.html\'  scrolling=\'auto\' noresize style=\'height:40vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\' frameborder=\'0\'></iframe>\n<form>\n<input type=\'hidden\' name=\'functionid\' id=\'functionid\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'></input>\n</form>\n</html>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
	String functionid=request.getParameter("function_id");
	String locale=(String)session.getAttribute("LOCALE");
	
	String source = url + params ;
	Connection con = null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	//String oper_stn_access_rule="";
	String facilityid=(String)session.getValue("facility_id");
	String globaluser = (String)session.getValue("login_user");
	/*Below Line Added for this CRF [Bru-HIMS-CRF-0166]*/
	String resch=request.getParameter("resch")==null?"":request.getParameter("resch");
	
	String oper_stn_id="";
	String currentdate="";
	String canc_appt_yn="";
	String tfr_appt_yn="";
	String book_appt_yn="";
	boolean allow_inside=true;
	try{
		con = ConnectionManager.getConnection(request);
		String sql2="SELECT a.oper_stn_id, nvl(canc_appt_yn,'N') canc_appt_yn, nvl(tfr_appt_yn,'N') tfr_appt_yn, nvl(book_appt_yn,'N') book_appt_yn, to_char(sysdate,'dd/mm/yyyy') dt FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
		pstmt=con.prepareStatement(sql2);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,globaluser);
		rs=pstmt.executeQuery();
		if (rs!=null && rs.next()){
			oper_stn_id=rs.getString("oper_stn_id");
			currentdate=rs.getString("dt");
			currentdate=DateUtils.convertDate(currentdate,"DMY","en",locale);			
			canc_appt_yn=rs.getString("canc_appt_yn");
			tfr_appt_yn=rs.getString("tfr_appt_yn");
			book_appt_yn=rs.getString("book_appt_yn");
		}else{					
			allow_inside=false;
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
	if(allow_inside){
		String called_for=request.getParameter("called_for");
		if(called_for==null) called_for="";
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block11Bytes, _wl_block11);
if(called_for.equals("")){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(functionid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(resch));
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(functionid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(resch));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(functionid));
            _bw.write(_wl_block23Bytes, _wl_block23);

}
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();
}catch(Exception es){
	es.printStackTrace();
}finally{
	if (con!=null) ConnectionManager.returnConnection(con,request);
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
