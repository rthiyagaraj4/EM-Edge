package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __managespatqueuechkout extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ManageSPatQueueChkout.jsp", 1738736833845L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tR.Nanda Kumar \n\tCreated on \t:\t22/12/2000\n\tModule\t\t:\tOut Patient Management\n\tFunction\t:\tThis file is used for dynamically generating toolbar for the\n\t\t\t\tfunction. Here 1 frame is defined for the function.\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>  \n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n    <script src=\"../../eOP/js/ManageSPatQueue.js\"></script>\n\t<script language=\'javascript\' src=\'../../eOP/js/ManageSPatQueueChkout.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n  <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" frameborder=0 scrolling=\'no\' noresize style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'frame1\' id=\'frame1\' src=\'../../eOP/jsp/ManageSPatQueueFr2.jsp?function_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&ChkOut=ChkOut&refresh=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&oper_stn_access_rule=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&oper_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&pat_id_length=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&bl_package_enabled_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&sdate=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' frameborder=0  style=\'height:85vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t<form>\n\t<input type=hidden name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<input type=hidden name=\'mins1_for_wait_time\' id=\'mins1_for_wait_time\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<input type=hidden name=\'mins2_for_wait_time\' id=\'mins2_for_wait_time\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t<input type=hidden name=\'open_search_reqd_yn\' id=\'open_search_reqd_yn\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t</form>\n\t<script>\n\t\trefresh_ChkOut=(";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =");\n\t</script>\n</html>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\n\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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

		Connection con=null;
		int refresh_interval = 0;
		String oper_stn_access_rule="";
		try {
				con=ConnectionManager.getConnection(request);
				Statement stmt=null;
				ResultSet rs=null;
			
				String fac_id    	= (String) session.getValue( "facility_id" ) ;	
				String userid           = (String) session.getValue("login_user");
				String bl_oper_yn = (String)session.getValue("bl_operational")==null?"N":(String)session.getValue("bl_operational");
				StringBuffer sql = new StringBuffer();
				String pat_id_length = "";
				String bl_package_enabled_yn = "N";
				String sdate = "";
				String OsVal = "";
				String open_search_reqd_yn = "N";
				int mins1_for_wait_time=0;
				int mins2_for_wait_time=0;
				//String sql="select queue_refresh_interval,oper_stn_access_rule from op_param where operating_facility_id='"+fac_id+"'";

				sql.append(" select queue_refresh_interval, oper_stn_access_rule, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') osval, (Select patient_id_length from mp_param where module_id = 'MP') pat_id_length,");
			
				if(bl_oper_yn.equals("Y")) {
					sql.append(" (select PACKAGE_ENABLED_YN from bl_parameters where operating_facility_id ='"+fac_id+"') bl_package_enabled_yn, ");
				}
			
				sql.append(" to_char(sysdate,'hh24:mi') sdate,open_search_reqd_yn,MINS1_FOR_WAIT_TIME,MINS2_FOR_WAIT_TIME from op_param where operating_facility_id='"+fac_id+"' ");	
				

				stmt	= con.createStatement();	
				//rs	= stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') FROM dual") ;
				rs	= stmt.executeQuery(sql.toString()) ;
				if(rs!=null && rs.next()) {	

					refresh_interval = (rs.getInt("queue_refresh_interval") * 60)*1000; 			
					oper_stn_access_rule = rs.getString("oper_stn_access_rule") == null?"":rs.getString("oper_stn_access_rule");
					OsVal = rs.getString("osval") == null?"":rs.getString("osval");						

					pat_id_length = rs.getString("pat_id_length") == null?"":rs.getString("pat_id_length");
					mins1_for_wait_time=rs.getInt("mins1_for_wait_time");
					mins2_for_wait_time=rs.getInt("mins2_for_wait_time");
					if(bl_oper_yn.equals("Y")) {
						bl_package_enabled_yn = rs.getString("bl_package_enabled_yn") == null?"N":rs.getString("bl_package_enabled_yn");

					}

					sdate = rs.getString("sdate") == null?"":rs.getString("sdate");	
					open_search_reqd_yn = rs.getString("open_search_reqd_yn") == null?"":rs.getString("open_search_reqd_yn");	
							
				
					if(OsVal.equals("1"))
					{
						out.print(" <script>alert(getMessage('CHECKOUT_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");

					} else if(OsVal.equals("2")) {
						out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					} else  if(OsVal.equals("3")) {
						out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					} else  if(OsVal.equals("4")) {
						out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("5")) {
						out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
					else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
					{
					}
				} else {
					out.println("<script>alert(parent.frames[0].getMessage('OP_PARAM_NOT_FOUND','OP'));window.location.href = '../../eCommon/jsp/dmenu.jsp' ;</script>");
				}
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
					
				String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
				String params = request.getQueryString() ;
				String source = url + params ; 
				String function_id=request.getParameter("function_id");
				if(function_id == null) function_id = "";

            
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(refresh_interval));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(oper_stn_access_rule));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bl_package_enabled_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mins1_for_wait_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mins2_for_wait_time));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(open_search_reqd_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(refresh_interval));
            _bw.write(_wl_block21Bytes, _wl_block21);

if(stmt != null) stmt.close();
if(rs != null) rs.close();
}catch(Exception e) {
	e.printStackTrace();
	out.println(e.toString());
}
finally{
if(con!=null)
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
