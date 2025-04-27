package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __aepathistorymlcdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEPatHistoryMLCDetails.jsp", 1709113843491L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html> \n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<title>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</title>\n</head>\n<body style=\'background-color:#E2E3F0;\' onKeyDown = \'lockKey()\' >\n<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'0\' align=center>\n\t<tr>\n\t\t<td align=\'left\' class=\'label\' width=\'10%\'></td>\n\t</tr>\n\t<tr>\n\t\t<td><textarea rows=8 cols=50 readonly>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</textarea></td>\n\t</tr>\n</table>\n\t<center><input type=\'Button\' class=\'Button\' name=\'Ok\' id=\'Ok\' value=\'  OK  \' onClick=\'window.close();\'></center>\t\n\n</body>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
	String mlc_details	=	"";
    String title		= request.getParameter("call_from");
          title			= (title==null)?"":title;

		  if(!title.equals("") && title.equalsIgnoreCase("MLC"))
		      title = "MLC Details";
		  else if(!title.equals("") && title.equalsIgnoreCase("IR"))
			  title = "Incident Remarks";
		 else title ="";
	
	String facilityId			 = (String)session.getValue("facility_id");
	String encid				 =	request.getParameter("encid");
	String sqlMLC				 =	"select medico_legal_details from ae_pat_emergency_detail b where facility_id=? and encounter_id=?";
	sqlMLC=sqlMLC+" AND B.RECORDED_DATE=(SELECT MAX(RECORDED_DATE) FROM AE_PAT_EMERGENCY_DETAIL WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id AND rownum < 2)";
    
	Connection con	=	null;
	PreparedStatement stmt	=	null;
	ResultSet rset	=	null;
	
	try{
                con                  = ConnectionManager.getConnection(request);
				stmt = con.prepareStatement(sqlMLC);
				stmt.setString(1,facilityId);
				stmt.setString(2,encid);
				rset = stmt.executeQuery();
				
				rset.next();
				mlc_details			 = rset.getString(1);
				mlc_details			 = (mlc_details == null)?"":mlc_details;

				if(rset!=null)  rset.close();
				if(stmt!=null)  stmt.close();
					
		
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(title));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(mlc_details));
            _bw.write(_wl_block6Bytes, _wl_block6);

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

            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
