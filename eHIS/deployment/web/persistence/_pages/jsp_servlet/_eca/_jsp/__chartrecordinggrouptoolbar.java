package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordinggrouptoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingGroupToolBar.jsp", 1709115671762L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onKeyDown=\"lockKey()\">\n\t\t<form name=\'groupCloseForm\' id=\'groupCloseForm\'>\n\t\t\t<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\'>\n\t\t\t\t\t\t<input class=\'button\' type=\'button\' name=\'grpButtonPrint\' id=\'grpButtonPrint\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' onclick=\'printing()\' >\n\t\t\t\t\t\t<input class=\'button\' type=\'button\' name=\'grpButtonClose\' id=\'grpButtonClose\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' onclick=\'window.close()\' >\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\'hidden\' name=\'selected_events_uom\' id=\'selected_events_uom\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t<input type=\'hidden\' name=\'no_of_selections\' id=\'no_of_selections\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t<input type=\'hidden\' name=\'noOfGroups\' id=\'noOfGroups\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t<input type=\'hidden\' name=\'grpDetails\' id=\'grpDetails\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t<input type=\'hidden\' name=\'pat_line\' id=\'pat_line\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	//String btnDisplay = request.getParameter("btnDisplay") == null ? "Y" : request.getParameter("btnDisplay");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");

	
	//newly added
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/*
		The below Query was changed by
		Name   : DINESH T
		Date   : 2010-08-05
		INCNO  : 23119
		Changes: used decode function in the query to get the thai value from the patient details if thai 
		         character is available and if not get the english character itself.
		*/
		String sql = "select decode(?,'en',a.patient_name,nvl(a.patient_name_loc_lang,a.patient_name)) patient_name, a.sex, GET_AGE(a.date_of_birth) age from mp_patient a where patient_id = ?";
		String patient_name = "",		age = "";
		String sex = "",pat_line ="";

		try
		{
			//con = ConnectionManager.getConnection(p);
			con = ConnectionManager.getConnection(request);
			if(con != null)
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,localeName);
				pstmt.setString(2,patient_id.trim());
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					patient_name = rs.getString(1)== null ? "" : rs.getString(1);
					sex = rs.getString(2)== null ? "" : rs.getString(2);
					age = rs.getString(3)== null ? "" : rs.getString(3);
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	
						
			if(sex.equals("M"))
			sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else
			if(sex.equals("F"))
			sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			
			pat_line = patient_name+","+age+","+sex+","+patient_id;

			
		
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}

	// new add ends....

	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getParameter("selected_events_uom")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getParameter("no_of_selections")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getParameter("noOfGroups")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getParameter("grpDetails")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(pat_line,"UTF-8")));
            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
