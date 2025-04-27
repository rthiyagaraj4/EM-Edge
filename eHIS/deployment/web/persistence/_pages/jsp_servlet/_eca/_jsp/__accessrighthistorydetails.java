package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __accessrighthistorydetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AccessRightHistoryDetails.jsp", 1730876441336L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<title>View - Access History for Clinical Studies Patient List</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<SCRIPT>\nfunction colseWindow(){\n\t//window.close();\n\tparent.document.getElementById(\'dialog_tag\').close();\n}\n</SCRIPT>\n</HEAD>\n<BODY>\n\t<TABLE border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" height=\"100%\" align=\'center\'>\n\t\t<TR height=\"5%\">\n\t\t\t<TH  align=\"center\" colspan=\"2\"><font size=\"2\"><B>Access History for Clinical Studies Patient List</B></font></TH>\n\t\t</TR>\n\t\t<TR height=\"5%\">\n\t\t\t<TH  align=\"center\" colspan=\"2\"><font size=\"1\"><B>Practitioner Name : ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</B></font></TH>\n\t\t</TR>\n\t\t</TABLE>\t\t\n\t\t<!-- <TR height=\"85%\">\n\t\t\t<TD colspan=\"2\"> -->\n\t\t\t\t<DIV style=\"width:100%; overflow: auto; height: 80vh;\">\n\t\t\t\t<TABLE border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t\t\t\t\t<TR><TH align=\"center\" >Start Date</TD>\n\t\t\t\t\t\t<TH align=\"center\" >End Date</TD>\n\t\t\t\t\t\t<TH align=\"center\" >Record Created By</TD>\n\t\t\t\t\t\t<TH align=\"center\" >Record Date</TD>\n\t\t\t\t\t\t<TH align=\"center\" >Record Status</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t\t <TR>\n\t\t\t\t\t\t\t\t\t\t<TD>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</TD>\n\t\t\t\t\t\t\t\t\t\t<TD>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</TD>\n\t\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t<TR><TD colspan=\"5\">&nbsp;</TD></TR>\n\t\t\t\t\t\t\t\t<TR><TD colspan=\"5\">&nbsp;</TD></TR>\n\t\t\t\t\t\t\t\t<TR><TD colspan=\"5\" align=\"center\">Access History Not available.</TD></TR>\n\t\t\t\t\t\t\t\t<TR><TD colspan=\"5\">&nbsp;</TD></TR>\n\t\t\t\t\t\t\t\t<TR><TD colspan=\"5\">&nbsp;</TD></TR>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\n\t\t\t\t</TABLE>\n\t\t\t\t</DIV>\n\t\t<!-- \t</TD>\n\t\t</TR> -->\n\t\t<TABLE border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" height=\"100%\" align=\'center\'>\n\t<tr>\n\t<TD align=\"right\" colspan=\"2\">\n\t\t\t\t<input type=\"button\" value=\"Close\" onClick=\"javascript:colseWindow();\" />\n\t</TD>\n\t</tr>\n\t</TABLE>\n</BODY>\t\n</HTML>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	java.sql.Connection		con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet		rs = null;
	
	

	String	practitionerId		=	(request.getParameter("practitionerId")==null?"":request.getParameter("practitionerId"));
	String	facilityId		=	(request.getParameter("facilityId")==null?"":request.getParameter("facilityId"));
	String	practitionerName			=	(request.getParameter("practitionerName")==null?"":request.getParameter("practitionerName"));	
	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(practitionerName));
            _bw.write(_wl_block8Bytes, _wl_block8);
					
						String sql = "SELECT TO_CHAR(CRSAL.RES_FROM_DATE,'dd/MM/yyyy') RES_FROM_DATE,TO_CHAR(CRSAL.RES_TO_DATE,'dd/MM/yyyy') RES_TO_DATE,(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=CRSAL.ADDED_BY_ID) PRACTITIONER_NAME,TO_CHAR(ADDED_DATE,'dd/MM/yyyy') ADDED_DATE,DECODE(ROW_STATUS,'I','Created','U','Modified','D','Deleted') ROWSTATUS FROM CA_RES_STUDY_ALLOWED_LOG CRSAL WHERE CRSAL.PRACTITIONER_ID=? AND CRSAL.FACILITY_ID=?  ORDER BY CRSAL.ADDED_DATE DESC";
						try{
							con	= ConnectionManager.getConnection(request);
							pstmt	= con.prepareStatement(sql);
							pstmt.setString(1, practitionerId);
							pstmt.setString(2, facilityId);
							

							rs = pstmt.executeQuery();
							int i=0;
							if(rs!=null){
								while(rs.next()){
									String resFromDate = rs.getString("RES_FROM_DATE")==null?"":(String)rs.getString("RES_FROM_DATE");
									String resToDate = rs.getString("RES_TO_DATE")==null?"":(String)rs.getString("RES_TO_DATE");
									String practitionerName_ = rs.getString("PRACTITIONER_NAME")==null?"":(String)rs.getString("PRACTITIONER_NAME");
									String addedDate = rs.getString("ADDED_DATE")==null?"":(String)rs.getString("ADDED_DATE");
									String rowStatus = rs.getString("ROWSTATUS")==null?"":(String)rs.getString("ROWSTATUS");
									 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(resFromDate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resToDate ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(practitionerName_));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(addedDate ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rowStatus ));
            _bw.write(_wl_block11Bytes, _wl_block11);

									 i++;
								}
							}
							if(i==0){
								
            _bw.write(_wl_block12Bytes, _wl_block12);

							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							
						}catch(Exception e){
								e.printStackTrace();
							//	out.println("Exception from ClinicalStudiesPatientListHistDetails.jsp " + e.toString());//COMMON-ICN-0181
						}finally{
								if(con != null) ConnectionManager.returnConnection(con, request);
						} 
						
					
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
