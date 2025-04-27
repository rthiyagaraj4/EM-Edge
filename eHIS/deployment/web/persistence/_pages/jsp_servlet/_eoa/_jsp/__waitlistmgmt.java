package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __waitlistmgmt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/WaitListMgmt.jsp", 1731467195447L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n\tDeveloped by \t:\tSuman\n\tCreated on \t:\t24/01/2005\n\tModule\t\t:\tOA\n\tFunction\t:\tManage WaitList\n-->\n\n<html>\n\n<head>\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>\n\t -->\n\t ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script> \n\t<script language=\"javascript\" src=\"../../eOA/js/WaitListMgmt.js\"> </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=no noresize style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\'    src=\'../../eOA/jsp/WaitListInvitationCriteria.jsp?function_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&modify_wait_list_yn=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&cancel_wait_list_yn=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&oper_stn_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&currentdate=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Patient_Id_Length=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&install_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' frameborder=0 noresize scrolling=no style=\'height:55vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'search_static\' id=\'search_static\'    src=\'../../eOA/jsp/WaitListMgmtCriteria.jsp\' frameborder=0 noresize scrolling=no style=\'height:6vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'f_query_add_mod1\' id=\'f_query_add_mod1\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\"auto\" style=\'height:20vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'f_query_add_mod2\' id=\'f_query_add_mod2\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\"auto\" style=\'height:0vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=auto style=\'height:10vh;width:100vw\'></iframe>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\talert(getMessage(\"NO_OPER_STN_FOR_USER\",\"Common\"));\n\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\n</html>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url 	= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source   = url+params ;

	String function_id = request.getParameter("function_id");
	String facilityid=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
	String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user"));
	String modify_wait_list_yn = "" ;
	String cancel_wait_list_yn = "" ;
	String oper_stn_id = "" ;
	String currentdate = "" ; 
	String Patient_Id_Length = "" ; 
	String install_yn = "" ; 
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String sql2="SELECT a.modify_wait_list_yn, a.cancel_wait_list_yn, a.oper_stn_id, to_char(sysdate,'dd/mm/yyyy') currentdate,(Select Patient_Id_Length from mp_param where module_id = 'MP') Patient_Id_Length,(select OPERATIONAL_YN from sm_modules_facility where module_id='OR' and facility_id=?) install_yn FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =?	AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,(sysdate))";
	session.removeAttribute("referral_id_app");
	session.removeAttribute("ref_id");
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,facilityid);
		pstmt.setString(3,globaluser);	 
		rs=pstmt.executeQuery();
		if (rs!=null && rs.next()) {			
			modify_wait_list_yn = rs.getString("modify_wait_list_yn")==null?"N":rs.getString("modify_wait_list_yn");
			cancel_wait_list_yn = rs.getString("cancel_wait_list_yn")==null?"N":rs.getString("cancel_wait_list_yn");
			oper_stn_id = rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
			Patient_Id_Length = rs.getString("Patient_Id_Length")==null?"":rs.getString("Patient_Id_Length");
			currentdate = rs.getString("currentdate")==null?"":rs.getString("currentdate");
			install_yn = rs.getString("install_yn")==null?"N":rs.getString("install_yn");
			
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(source));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(modify_wait_list_yn));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(cancel_wait_list_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);

		} else {				
			
            _bw.write(_wl_block13Bytes, _wl_block13);
}

//	out.println(function_id);		

            _bw.write(_wl_block14Bytes, _wl_block14);

}
catch(Exception es){
	es.printStackTrace();
//out.println(es);
}
finally{
	if(con!=null)rs.close();
	if(con!=null)pstmt.close();
	if(con!=null)con.close();
}


            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
