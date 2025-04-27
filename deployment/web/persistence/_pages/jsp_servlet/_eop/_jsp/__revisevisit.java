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

public final class __revisevisit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ReviseVisit.jsp", 1728375849945L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eOP/js/ReviseVisit.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script><!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013-->\n\t<script language=\"javascript\" src=\"../../eOP/js/Checkblockscheduleforpract.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013-->\n\t\t\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t    <iframe name=\'group_head\' id=\'group_head\'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'no\' src=\'../../eOP/jsp/SearchVisitQueryCriteria.jsp?function_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&oper_id=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&StartDate=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&Canceldays=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&Patient_Id_Length=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&bl_interfaced_yn=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&package_enabled_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&build_episode_rule=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&assign_queue_num_by=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&queue_date=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&p_mode=REVISEVISIT\' style=\'height:16vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\'   src=\'../../eCommon/html/blank.html\'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'auto\' style=\'height:68vh;width:99vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'billingfr\' id=\'billingfr\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'no\' style=\'height:0vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</html>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n";
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

	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
    	String source = url + params ;
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
		String userid           = (String) session.getValue("login_user");
		String function_id=request.getParameter("function_id");
		Connection con=null;
		//String revise_visit_yn="";	
		
	try {
       con=ConnectionManager.getConnection(request);        
       Statement stmt=null;
	   ResultSet rs=null;			
	   
	   String OsVal="";
	   String StartDate="";
	   String Canceldays="";	     
	   String Patient_Id_Length="";
	   String package_enabled_yn="";
	   String bl_interfaced_yn="";
	   String queue_date="";
	   String assign_queue_num_by="";
	   String build_episode_rule="";
	   String bl_install_yn = (String) session.getValue("bl_operational")==null?"N":(String)session.getValue("bl_operational");;
	   StringBuffer sqlquery = new StringBuffer();	   
		 
		sqlquery.append("Select a.bl_interfaced_yn,to_char(sysdate ,'dd/mm/yyyy') sys,		to_char(sysdate-a.VISIT_REV_CANCEL_DAYS,'dd/mm/yyyy') sys_1 , build_episode_rule,  assign_queue_num_by,  to_char(sysdate,'dd/mm/yyyy') queue_date,AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','REVISE_VISIT_YN') OsVal, (Select patient_id_length from mp_param where module_id='MP') PatIdLen");
		if(bl_install_yn.equals("Y"))
			sqlquery.append(", b.package_enabled_yn package_enabled_yn from bl_parameters b ,op_param a where a.operating_facility_id='"+fac_id+"' and a.operating_facility_id = b.operating_facility_id");
		else
			sqlquery.append(" from op_param a where a.operating_facility_id='"+fac_id+"' ");		 

        stmt	= con.createStatement();	
		rs	= stmt.executeQuery(sqlquery.toString()) ;
		if(rs!=null && rs.next()) {									
			
			OsVal=rs.getString("OsVal");     
			StartDate=rs.getString("sys");
			Canceldays=rs.getString("sys_1");			
			Patient_Id_Length=rs.getString("PatIdLen");
			if(bl_install_yn.equals("Y"))
				package_enabled_yn=rs.getString("package_enabled_yn");
			bl_interfaced_yn=rs.getString("bl_interfaced_yn");
			build_episode_rule=rs.getString("build_episode_rule");
			assign_queue_num_by=rs.getString("assign_queue_num_by");
			queue_date=rs.getString("queue_date");			

		    if(OsVal.equals("1")) {			
				out.print("<script>alert(getMessage('REVISIT_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/			dmenu.jsp';	</script>");
		    }else if(OsVal.equals("2")) 	{
			    out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			} else  if(OsVal.equals("3")) {
			     out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4")) {
			out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("5")) {
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
            else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4"))) {
				
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(StartDate));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Canceldays));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(package_enabled_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(assign_queue_num_by));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
		} else {
              out.println("<script>alert(parent.frames[0].getMessage('OP_PARAM_NOT_FOUND','OP'));window.location.href = '../../eCommon/jsp/dmenu.jsp' ;</script>");
         }
          

            _bw.write(_wl_block16Bytes, _wl_block16);

	if (stmt != null)    stmt.close();
          if (rs != null)       rs.close();
}catch(Exception e) {e.printStackTrace();}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
