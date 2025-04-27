package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __cancelvisit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/CancelVisit.jsp", 1728017164723L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \tFunction Name Cancel Visit\n\tCreated by M.Sathis Kumar on 28/02/2000 -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n    <meta http-equiv=\"Expires\" content=\"0\">\n  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t<Script src=\"../../eOP/js/CancelVisit.js\" language=\"JavaScript\"></Script>\n\t\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\n\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'group_head\' id=\'group_head\'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'no\' src=\'../../eOP/jsp/SearchVisitQueryCriteria.jsp?function_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&oper_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&StartDate=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&Canceldays=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&bl_interfaced_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&inc_arrive_cons_start_pats_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&Patient_Id_Length=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&p_mode=CANCELVISIT\' style=\'height:21vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\'   src=\'../../eCommon/html/blank.html\'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'auto\' style=\'height:62vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:8vh;width:100vw\'></iframe>\t\t\t\n\t\t\t\n\t\t    ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</html>\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		//String url1 = "../../eOP/jsp/CancelVisitFrameset1.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;		
		String function_id = request.getParameter("function_id");
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
            con=ConnectionManager.getConnection(request);		
			String fac_id       = (String) session.getValue( "facility_id" ) ;
			String userid           = (String) session.getValue("login_user");			
			String OsVal="";
			String Patient_Id_Length="";			
			String StartDate="";
			String Canceldays="";
			String inc_arrive_cons_start_pats_yn="";
			String bl_interfaced_yn="";

			String sqlquery = "select bl_interfaced_yn, to_char(sysdate ,'dd/mm/yyyy')sys, to_char(sysdate-a.VISIT_REV_CANCEL_DAYS,'dd/mm/yyyy')sys_1, inc_arrive_cons_start_pats_yn, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CANCEL_VISIT_YN') OsVal, (Select patient_id_length from mp_param where module_id='MP') Patient_Id_Length from op_param a where operating_facility_id='"+fac_id+"' "	;			
			stmt	= con.createStatement();	
			rs	= stmt.executeQuery(sqlquery) ;
			if(rs!=null && rs.next()) {					
				OsVal=rs.getString("OsVal");        	
				StartDate=rs.getString("sys");
				Canceldays=rs.getString("sys_1");
				inc_arrive_cons_start_pats_yn=rs.getString("inc_arrive_cons_start_pats_yn");
				Patient_Id_Length=rs.getString("Patient_Id_Length");        	
				bl_interfaced_yn=rs.getString("bl_interfaced_yn");   
				
				if(OsVal.equals("1"))	{													
					out.print("<script>alert(getMessage('CANCEL_VISIT_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/		dmenu.js p';</script>");
				}else if(OsVal.equals("2")) {
					out.print(" <script>					alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("3")) {
					out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("4")) {
					out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("5")) {
					out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5"))) {	   
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(StartDate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Canceldays));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(inc_arrive_cons_start_pats_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block16Bytes, _wl_block16);
}  
		 } else {
               out.println("<script>alert(parent.frames[0].getMessage('OP_PARAM_NOT_FOUND','OP'));window.location.href = '../../eCommon/jsp/dmenu.jsp' ;</script>");
         }
					
            _bw.write(_wl_block17Bytes, _wl_block17);

        }catch(Exception e) {e.printStackTrace();}
finally{	
	if (stmt != null)    stmt.close();
    if (rs != null)       rs.close();
	if(con!=null)
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
