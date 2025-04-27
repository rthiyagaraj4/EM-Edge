package jsp_servlet._eae._jsp;

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
import eCommon.XSSRequestWrapper;

public final class __aeeventquerymain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEEventQueryMain.jsp", 1709113832960L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<!--\n\t@Get The Connection\n\t@Prepare The Statement and Execute The Query\n-->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<frameset rows=\'12%,*\'>\n\t<frame src=\"../../eAE/jsp/AEEventQueryEncDtls.jsp?EncounterId=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&Facility_Id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" name=\"PatientLine_frame\" scrolling=NO noresize>\n\t\t <frameset cols=\'20%,*\' >\n\t\t\t<frame name=\'view1\' id=\'view1\' src=\'../../eAE/jsp/AEEventQueryDetails.jsp?Patient_ID=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&EncounterId=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' frameborder=0 scrolling=\'no\' noresize>\n\t\t\t<frame name=\'view2\' id=\'view2\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'NO\' noresize>\n\t\t</frameset>\n</frameset>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\tvar msg = \tgetMessage( \"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\');\t\n\t\t\talert(msg);\n\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String encounter_id  =	""; 
	String facility_id  =	"";	
	facility_id		=	(String)	session.getValue("facility_id");     
	encounter_id 	=	(request.getParameter("episode_id")==null)	?	""	:	request.getParameter("episode_id");
	
	String strPatientId = request.getParameter("patient_id");

            _bw.write(_wl_block2Bytes, _wl_block2);

  String qryCount = "SELECT COUNT(*) ae_count FROM AE_PAT_EMERGENCY_DETAIL b WHERE ENCOUNTER_ID='"+encounter_id+"' and facility_id = '"+facility_id+"'"; 
  qryCount=qryCount+" AND B.RECORDED_DATE=(SELECT MAX(RECORDED_DATE) FROM AE_PAT_EMERGENCY_DETAIL WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id AND rownum < 2)";


            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int intCount = 0;
try{
	conn = webbeans.eCommon.ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement(qryCount);
	rs = pstmt.executeQuery();

	 while(rs.next())
	{
			intCount  = rs.getInt("ae_count");
	}
	if(rs!=null)rs.close();
	if(pstmt != null)pstmt.close();
	}catch(Exception e)
	{
		e.printStackTrace();
    }
	finally
	{
		if(rs!=null)rs.close();
		if(pstmt != null)pstmt.close();
		if(conn != null)webbeans.eCommon.ConnectionManager.returnConnection(conn,request);
	}
		if(intCount==1)
		{
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
		else
		{

            _bw.write(_wl_block9Bytes, _wl_block9);

		}

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
