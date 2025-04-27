package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __motherline extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/motherline.jsp", 1709118630307L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 10/4/2005 10:01 AM --> \n\n<html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t</head>\n\t<body onKeyDown = \'lockKey()\'>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<form name=\"f\" id=\"f\">\n\t\t<table  width=\'100%\' height=\'100%\' style=\"\" border=0 valign=\'top\' CELLSPACING=0 CELLPADDING=0>\n\t\t\t<tr>\n\t\t\t\t<td colspan=2 align=left class=\'PATIENTLINECOLOROTHLANG\' nowrap>\n\t\t\t\t<FONT size=\'2\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=left class=\'PATIENTLINECOLOROTHLANG\' nowrap>\n\t\t\t\t<font size=\'-1\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t<td  align=right class=\'PATIENTLINECOLOROTHLANG\' nowrap>\n\t\t\t\t<font size=\'-1\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n\t\t</table> \n\t\t<input type=\"hidden\" name=\"mother_name_age_gender\" id=\"mother_name_age_gender\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		Connection con			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;

		con = ConnectionManager.getConnection(request);

		String motherid		= request.getParameter("mother_id") == null ? "" : request.getParameter("mother_id");
		String encounterid	= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		String nursingunit	= request.getParameter("nursing_unit") == null ? "" : request.getParameter("nursing_unit");

		if(!encounterid.equals("")) encounterid = "Encounter ID :"+encounterid;
		if(!nursingunit.equals("")) nursingunit = "Nursing Unit :"+nursingunit;
		
            _bw.write(_wl_block7Bytes, _wl_block7);

			String name				= "";
			String id				= "";
			String op_install_yn	= "";
			String pid				= "";

			try
			{
				pstmt = con.prepareStatement("SELECT install_yn FROM sm_module WHERE module_id = 'OP'");
				rs = pstmt.executeQuery();
				if(rs != null && rs.next())
				{
					op_install_yn = rs.getString(1);
					if(op_install_yn == null) op_install_yn = "";
				}
			}
			catch(Exception ex)
			{
				out.println(ex.toString());
			}
		
			try
			{
				String strToken = "";

				if(op_install_yn.equals("Y"))
				{
					pstmt = con.prepareStatement("SELECT get_patient.get_line_detail('"+motherid+"','"+localeName+"') Pline FROM dual");

					strToken = "|";
					rs = pstmt.executeQuery();

					if(rs != null)
					{
						if(rs.next())
						{
							String s = rs.getString("Pline");
							StringTokenizer token = new StringTokenizer(s,strToken);
							while(token.hasMoreTokens())
							{
								name	= token.nextToken();
								id		= token.nextToken();
							}
						}
					}
					pid = motherid;
				}
				else
				{
					pstmt = con.prepareStatement("SELECT get_patient_line('"+motherid+"','"+localeName+"') Pline FROM dual");	

					strToken = ",";
					rs = pstmt.executeQuery();
					if(rs != null)
					{
						if(rs.next())
						{
							String s				= rs.getString("Pline");
							StringTokenizer token	= new StringTokenizer(s,strToken);
							while(token.hasMoreTokens())
							{
								name += token.nextToken();
							}
						}
						name = name.substring(0,name.length()-6);
					}
					pid = "";
				}
			}
			catch(Exception e){out.println(e.toString());}
			finally
			{
				if(pstmt!=null)	pstmt.close();
				if(rs!=null)	rs.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
  			}
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(name+", "+pid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursingunit));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(name));
            _bw.write(_wl_block12Bytes, _wl_block12);
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
