package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __reppd207form extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/repPD207Form.jsp", 1721995163748L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\t \n<HEAD>\n<TITLE></TITLE>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/CommonCalendar.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../js/repPD207.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</HEAD>\n\n<BODY onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' onLoad=\"mychange()\">\n<br>\n<br>\n<form name=\"RepPD207Form\" id=\"RepPD207Form\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<table width=\'80%\' align=\'center\' valign=\'top\'>\n\n\t\t<th align=\'left\'> Report Criteria\n\t\t</th>\n\n\t<tr>\n\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\n\t\t\t<table width=\'70%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'center\' >\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">  &nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'  >\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan =\'2\'>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\" class=\"label\" > Facility &nbsp;</td>\n\t\t\t\t\t<td colspan =\"3\"> \n\t\t\t\t\t\t\t<select name=\'p_all_facility_id\' id=\'p_all_facility_id\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" <tr>\n\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">  &nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'  >\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan =\'2\'>\n\t\t\t\t</tr>\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">Report Type&nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'>\n\t\t\t\t\t\t <SELECT name=\"p_report_type\" id=\"p_report_type\" onchange=\'mychange()\'>\n\t\t\t\t\t\t <option value=\"M\">Month</option>\n\t\t\t\t\t\t <option value=\"Y\">Year</option>\n\t\t\t\t\t\t </SELECT>\n\t\t\t\t\t</td>\n\t\t\t\t\t <td colspan =\'3\'> \n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">  &nbsp;&nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'  ></td>\n\t\t\t\t\t<td colspan =\'3\'></td>\n\t\t\t\t\t<td colspan =\'3\'></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'left\' id=\'MY1\'class=\"label\"> &nbsp; &nbsp;</td>\n\t\t\t\t\t\t<td align=\'left\' id=\'MY\' > &nbsp; </td><td> </td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">  &nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'  ></td>\n\t\t\t\t\t<td colspan =\'3\'></td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan =\'2\'>\n\t\t\t\t</tr>\n\t\t</table>\n\t</td>\n</tr>\n</table>\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t<input type=\"hidden\" name=\"p_resp_id\" id=\"p_resp_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t<input type=\"hidden\" name=\"p_date_fmt\" id=\"p_date_fmt\"\tvalue=\"\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);

	String p_module_id		= "MR" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	Connection	con		=	null;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
	String p_report_id			=	"MRBPD207";
	Statement stmt;
	ResultSet rset;

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

							String fid="";
							String fname="";
							String sql1="";
							try
							{
								con		=	ConnectionManager.getConnection(request);
							 stmt=con.createStatement();
							 sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					
							rset=stmt.executeQuery(sql1);
							if(rset!=null)
							{
							   while(rset.next())
							   {
								fid=rset.getString("facility_id");
								fname=rset.getString("facility_name");
								if(fid.equals("All"))
								{
								}
								else
								{
									out.println("<option value='"+fid+ "'  >"+fname+"</option>");
								}
							   }
							}
							if(rset!=null)rset.close();
							if(stmt!=null)stmt.close();
							}catch(Exception e)
							{
								//out.println(e);
								e.printStackTrace();
							}
							finally { 
									ConnectionManager.returnConnection(con,request);
									}


						
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_resp_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
