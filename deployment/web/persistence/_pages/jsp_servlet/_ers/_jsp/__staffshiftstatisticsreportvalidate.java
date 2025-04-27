package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;

public final class __staffshiftstatisticsreportvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/StaffShiftStatisticsReportValidate.jsp", 1709117448837L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	

	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	
	String role_type	= request.getParameter( "role_type" )==null?"":request.getParameter("role_type");
	String p_staff_type	= request.getParameter( "p_staff_type" )==null?"":request.getParameter("p_staff_type");
	String p_position_code = request.getParameter( "p_position_code" )==null?"":request.getParameter("p_position_code");
	String locale = request.getParameter( "locale" )==null?"":request.getParameter("locale");
	String func_mode = request.getParameter( "func_mode" )==null?"":request.getParameter("func_mode");
	String sql			="";
	ArrayList Staff		= new ArrayList() ;
	String[] record		= null;
	String pos_code = "";
	String pos_desc = "";
		
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;

	try{
			Con = ConnectionManager.getConnection(request);
			if(func_mode.equals("Staff"))
				{
					if(role_type.equalsIgnoreCase("P"))
						{
							sql="SELECT pract_type, desc_userdef FROM am_pract_type WHERE eff_status = 'E' ORDER BY desc_userdef";
			
							pstmt=Con.prepareStatement(sql);
							rslRst = pstmt.executeQuery();
		
							while(rslRst.next())
								{
									record = new String[2];
									record[0]	=rslRst.getString("pract_type");
									record[1]	=rslRst.getString("desc_userdef");
									Staff.add(record) ;
								}
							if (pstmt != null) pstmt.close();
							if (rslRst != null) rslRst.close();
						}
					else if(role_type.equalsIgnoreCase("O"))
						{
							sql="SELECT other_staff_type, short_desc FROM am_other_staff_type WHERE eff_status = 'E' ORDER BY short_desc";
			
							pstmt=Con.prepareStatement(sql);
							rslRst = pstmt.executeQuery();
		
							while(rslRst.next())
								{
									record = new String[2];
									record[0]	=rslRst.getString("other_staff_type");
									record[1]	=rslRst.getString("short_desc");
									Staff.add(record) ;
								}
							if (pstmt != null) 
								pstmt.close();
							if (rslRst != null) 
								rslRst.close();
						}

					for( int i=0 ; i< Staff.size(); i++ ) 
						{
							String[] record1 = (String[])Staff.get(i);
							out.println( "addStaffType(\"" + record1[0] + "\",\"" + record1[1] + "\") ; " ) ;			
						}
				}
			else if(func_mode.equals("Position"))
				{

					sql="select position_code code ,position_desc description from am_position_lang_vw where eff_status = 'E'  and upper(role_type) like upper('"+role_type+"') and upper(staff_type) like upper('"+p_staff_type+"') and upper(position_code) like upper('"+p_position_code+"') and  language_id ='"+locale+"' order by position_desc";
					pstmt=Con.prepareStatement(sql);
					rslRst = pstmt.executeQuery();
	
					while(rslRst.next())
						{
							pos_code	=rslRst.getString("code");
							pos_desc	=rslRst.getString("description");
						}
					if (pstmt != null) 
						pstmt.close();
					if (rslRst != null) 
						rslRst.close();
					out.println( "addPosition(\"" + pos_code + "\",\"" + pos_desc + "\") ; " ) ;		
				}

		}catch(Exception e)
			{
				e.printStackTrace() ;
				throw e ;
			}
		finally 
			{
				if (pstmt != null) pstmt.close();
				if (rslRst != null) rslRst.close();
				ConnectionManager.returnConnection(Con,request);
			}


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
