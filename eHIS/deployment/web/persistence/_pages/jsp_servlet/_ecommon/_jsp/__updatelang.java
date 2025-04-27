package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __updatelang extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/UpdateLang.jsp", 1742203198763L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");	
	String lang_id = request.getParameter("language_id");
	String UserId  = (String)session.getValue("login_user");
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String cssName = (request.getParameter("cssName")==null || request.getParameter("cssName")=="")?"IeStyle":request.getParameter("cssName");
int result=0;
	Connection con =null;
	//String short_name="";
	//PreparedStatement pstmt=null ;
	PreparedStatement  pstmt=null;
	//ResultSet reset=null;

	 try{
			con = ConnectionManager.getConnection(request);
			if(lang_id.equals("bu")){
				if(!cssName.contains("_bu")){
					cssName	= cssName+"_bu.css";
				}else{
					cssName	= cssName+".css";
				}
			}else{
				if(cssName.contains("_bu")){
					cssName	= cssName.replace("_bu",".css");
				}else{
					cssName	= cssName+".css";
				}
			}
		
			pstmt = con.prepareStatement("Update sm_appl_user set language_id=?,preferred_style='"+cssName+"' where appl_user_id=?");
						pstmt.setString(1,lang_id);
						pstmt.setString(2,UserId);
						
					result=pstmt.executeUpdate();
						con.commit();
						session.setAttribute("PREFERRED_STYLE",cssName);

			String sql = "select appl_user_name from sm_appl_user_lang_vw where appl_user_id = '"+UserId+"' and language_id = '"+lang_id+"'" ;

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql) ;
				if(rs != null){
					if(rs.next()){
						session.setAttribute("appl_user_name",rs.getString("appl_user_name"));
					}
					rs.close();
				}

			sql = "select facility_name from sm_facility_param_lang_vw where facility_Id = '"+(String)session.getAttribute("facility_id")+"' and language_id = '"+lang_id+"'";
			rs = stmt.executeQuery(sql) ;
				if(rs != null){
					if(rs.next()){
						session.setAttribute("facility_name",rs.getString("facility_name"));
					}
					stmt.close();
					rs.close();
			}

			javax.servlet.jsp.jstl.core.Config.set(session, javax.servlet.jsp.jstl.core.Config.FMT_LOCALE, lang_id);
			javax.servlet.jsp.jstl.core.Config.set(session, javax.servlet.jsp.jstl.core.Config.FMT_FALLBACK_LOCALE, "en");

			session.putValue("LOCALE",lang_id) ;
			Properties p = (Properties)session.getAttribute("jdbc");
			p.setProperty("LOCALE", lang_id);
			session.putValue("jdbc", p);
			/* Added By Vinod - 6/23/2006 10:08 AM
				To remove Thai charset from session for English Language Interface
			*/
			if ( session.getAttribute("javax.servlet.jsp.jstl.fmt.locale.session") != null )
			{
				String val = (String)session.getAttribute("javax.servlet.jsp.jstl.fmt.locale.session");
				if (val.equalsIgnoreCase("en"))
				{
					if ( ( session.getAttribute("javax.servlet.jsp.jstl.fmt.request.charset") != null )  && 
						 ( ((String)session.getAttribute("javax.servlet.jsp.jstl.fmt.request.charset")).equalsIgnoreCase("TIS-620") ) )
					{
						  session.removeAttribute("javax.servlet.jsp.jstl.fmt.request.charset");
					}
				}
			}
for (java.util.Enumeration sessionVaules=session.getAttributeNames(); sessionVaules.hasMoreElements();){
	String name = (String)sessionVaules.nextElement();
	//Object value = session.getAttribute(name);					

}


			if (pstmt != null) pstmt.close();
			if (called_from.equals("CA_PATIENT_CHART"))
			{
				String  ca_practitioner_id =(String)session.getAttribute("ca_practitioner_id");
				pstmt = con.prepareStatement("SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID = ? AND LANGUAGE_ID = ?");
				pstmt.setString(1,ca_practitioner_id);
				pstmt.setString(2,lang_id);
				rs = pstmt.executeQuery();
				if(rs!= null && rs.next())
				{
					session.putValue("practitioner_name",rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME"));
				}
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			}
		}catch(Exception e) { 
			out.println(e.toString());
			e.printStackTrace();
		}
		 finally{ if(con!=null) ConnectionManager.returnConnection(con,request);	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
