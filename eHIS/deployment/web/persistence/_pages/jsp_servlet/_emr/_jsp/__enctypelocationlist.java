package jsp_servlet._emr._jsp;

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

public final class __enctypelocationlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/EncTypeLocationList.jsp", 1721363796643L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nCRF Reference No     :  ML-MMOH-CRF-1959\nDetected Release  No      :  SEPTEMBER 2023 Release \nFile prepared by          :  SANTHOSH KUMAR N\nFile prepared date        :  20-07-2023\nPurpose of the Change   :  As a MR user, In MR Module, I should be able to have a new function Receive BHT where the discharged records of all patient types can be changed to overdue, Delivered, returned or received.\nScript Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites    \n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<html> \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n    <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t<BODY class=\'Message\' onKeyDown = \'lockKey()\'>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>\n\t\t\t//var opt\t\t=   parent.frames[1].document.forms[0].document.createElement(\"OPTION\");\n\t\t\tvar opt = parent.frames[1].document.createElement(\"OPTION\");\n\t\t\topt.text\t= \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\topt.value\t= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\tparent.frames[1].document.forms[0].locationType.add(opt); \n\t\t</script>\t\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t</body>    \n\t</html>\t \n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

		Connection con		=  null;
		ResultSet rs 		= null;
		PreparedStatement pstmt = null;
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String frame_name="";
	

	
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle	= 
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	try{
			con					= ConnectionManager.getConnection(request); 
			String shortDesc		    = "";
			String locn_type 				= "";
			String encounterType = request.getParameter("encounterType");
			String locTypeCode = encounterType.equals("EM")?"'C'":encounterType.equals("DC")?"'N'":encounterType.equals("OP")?"'C','E'":encounterType.equals("IP")?"'N'":"";
			
			StringBuffer sqlBuf  = new StringBuffer();

			sqlBuf.append("select locn_type, am_get_desc.am_care_locn_type(locn_type,'" + locale
				+ "',2) short_desc, CARE_LOCN_TYPE_IND, to_char(sysdate,'dd/mm/yyyy') sys_date from am_care_locn_type where SYS_USER_DEF_IND='S' and locn_type in ("+locTypeCode+") order by short_desc");
			pstmt   = con.prepareStatement(sqlBuf.toString());
			rs		 = pstmt.executeQuery();
			while(rs!=null && rs.next())
			{	
			locn_type = rs.getString("CARE_LOCN_TYPE_IND");
			shortDesc = rs.getString("short_desc");
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
			} //End of while		 
			if(rs!=null) { rs.close(); rs = null; }   
			if(pstmt!=null) { pstmt.close(); pstmt = null; }  
		 
	   }catch(Exception e)
       { e.toString();   }
	   finally {
				   ConnectionManager.returnConnection(con,request);  
			    }
	
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
