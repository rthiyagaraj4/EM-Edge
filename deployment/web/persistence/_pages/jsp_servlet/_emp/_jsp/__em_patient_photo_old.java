package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHQueryRender;
import eXH.XHDBAdapter;
import eXH.XHUtil;
import java.util.*;
import com.ehis.util.*;

public final class __em_patient_photo_old extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/EM_Patient_Photo_old.jsp", 1742536600784L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>Capture Patient Photo</title>\n</head>\n<body onUnLoad=\'window.returnValue=\"close\"\'>\n\t<br>\n\t\t<table align=\"center\" border=\"4\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 700px;\">\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<applet code=\"PatientPhotoApplet.class\"\n\t\t\t\t\t\tcodebase=\"../CamImage/\" archive=\"PatientPhotoImage.jar\" width=\"700\"\n\t\t\t\t\t\theight=\"325\">\n\t\t\t\t\t\t<PARAM name=\"servletPath\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" />\n\t\t\t\t\t\t<PARAM name=\"patient_id\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" />\n\t\t\t\t\t\t<PARAM name=\"module_id\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" />\n\t\t\t\t\t\t<PARAM name=\"patient_name\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" />\n\t\t\t\t\t\t<PARAM name=\"image_width\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" />\n\t\t\t\t\t\t<PARAM name=\"image_height\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" />\n\t\t\t\t\t\t<PARAM name=\"resize_factor\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" />\n\t\t\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\t\t\tSorry, Your browser does not support Java applet!\n\t\t\t\t\t</applet>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\t\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));	

	if(isDebugYN.equals("Y"))
		System.out.println(" - - -  Inside EM_Patient_Photo.jsp  - - - ");
	
	String l_facility_id = (String) session.getValue("facility_id");
	
	if(isDebugYN.equals("Y"))
		System.out.println(" - - -  l_facility_id  - - - "+l_facility_id);

	String appPath = request.getRequestURL().toString();
	String contextPath = request.getContextPath();

	appPath = appPath.substring(0, appPath.indexOf(contextPath)	+ contextPath.length());

	String patientid = "", moduleid = "", patientname = "";

	patientid = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");

	moduleid = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");

	patientname = request.getParameter("patient_name") == null ? "" : request.getParameter("patient_name");
	
	if(isDebugYN.equals("Y"))
		System.out.println(" ::: appPath ::: " + appPath + " ::: patientid ::: " + patientid + " ::: patientname ::: " + patientname + "::: moduleid ::: " + moduleid );
	
	Connection dbConn = null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	String l_event_query = "";
	
	int l_photo_width = 320, l_photo_height = 240;
	double l_resize_factor = 0;

	try
	{ 
		dbConn = ConnectionManager.getConnection(request);
		
		l_event_query = "Select PAT_PHOTO_WIDTH, PAT_PHOTO_HEIGHT, RESIZE_FACTOR from SM_PATIENT_DOC_PARAM  "
				+"	where FACILITY_ID = ? ";

		if(isDebugYN.equals("Y"))
			System.out.println("l_event_query...."+l_event_query);
		
		pstmt = dbConn.prepareStatement(l_event_query);
		pstmt.setString(1, l_facility_id);
			
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			l_photo_width = rs.getInt("PAT_PHOTO_WIDTH"); 
			l_photo_height =  rs.getInt("PAT_PHOTO_HEIGHT");	
			l_resize_factor = rs.getDouble("RESIZE_FACTOR");
		}
		
		if(isDebugYN.equals("Y"))
			System.out.println("l_photo_width...."+l_photo_width+" l_photo_height...."+l_photo_height);		
		
	}
	catch(Exception exp) {
		System.out.println(" Error in fetching Patient Photo Width & Height ::: "+exp.getMessage());	
		l_photo_width = 320;
		l_photo_height = 240;
		l_resize_factor = 0;
	}	
	finally
	{
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();	
			}
		}
		catch(Exception e) {
			System.out.println(" Error in closing DB Resources ::: "+e.getMessage());	
		}
	  	ConnectionManager.returnConnection(dbConn);	  
	}
	

	//session.getServletContext().getRealPath("/");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(appPath));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(l_photo_width));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(l_photo_height));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(l_resize_factor));
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
