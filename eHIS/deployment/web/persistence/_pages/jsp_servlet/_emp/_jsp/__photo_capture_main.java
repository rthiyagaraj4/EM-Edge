package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.*;
import com.ehis.util.*;

public final class __photo_capture_main extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/photo_capture_main.jsp", 1709118692590L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n   \t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n\t<script language=\"JavaScript\" src=\"../../eMP/js/ViewPatDetails.js\"></script>\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HEAD>\n<title> Capture Patient Photo\t</title>\n</HEAD>\n<body onKeyDown=\'lockKey()\'>\n<form name=\'patPhotoMain\' id=\'patPhotoMain\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<br>\n<table cellspacing=0 cellpadding=4 width=\'70%\' align=\'center\' border=0 height=\'20%\'>\n    <tr>\n        <td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td>\n    </tr>\n\t<tr>\t\t\n\t\t<td width=\'25%\'  class=\'label\' nowrap>\n\t\tWebCam\n\t\t<td width=\'25%\'  class=\'label\'><input type=\'radio\' name=\'cam\' id=\'cam\' value=\'C\' onClick=\"select_cam(this)\" checked></td>\n\t\t\n\t\t<td width=\'25%\'  class=\'label\' nowrap>\n\t\t\tUpload File\n\t\t\t<td width=\'25%\'  class=\'label\'><input type=\'radio\' name=\'uplfile\' id=\'uplfile\' value=\'U\' onClick=\"select_upload(this)\"></td>\n\t</tr>\n\t<tr>\t\t\n\t\t<td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td><td width=\'25%\'  class=\'button\' align=\'left\' nowrap>\n\t\t\t<input type=\'button\' name=\'OK\' id=\'OK\' value=\'OK\' onclick=\'callsubmit()\'> \n\t\t\t<input type=\'button\' name=\'CANCEL\' id=\'CANCEL\' value=\'Cancel\' onclick=\'callcancle()\'></td>\n\t</tr>\n\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n</table>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table cellspacing=0 cellpadding=4 width=\'70%\' align=\'center\' border=0 height=\'20%\'>\n<tr rowspan=\'4\'><td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td></tr>\n<tr><td width=\'25%\'  class=\'label\' nowrap> Capture Patient Photo\t\t\t\n\t\t\t<td class=\'fields\' nowrap><input type=\'checkbox\' name=\'changephoto\' id=\'changephoto\' value=\'N\' onclick=\'changephotofun(this)\'></td><td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td></tr>\n    <tr>\n        <td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td>\n    </tr>\n\t<tr>\t\t\n\t\t<td width=\'25%\' class=\'label\' nowrap>\n\t\t\t\tWebCam\n\t\t\t\t<td width=\'25%\' class=\'label\'><input type=\'radio\' name=\'cam\' id=\'cam\' value=\'C\' onClick=\"select_cam(this)\" disabled checked></td>\n\t\t\n\t\t<td width=\'25%\'  class=\'label\' nowrap>\n\t\t\tUpload File\n\t\t\t<td width=\'25%\'  class=\'label\'><input type=\'radio\' name=\'uplfile\' id=\'uplfile\' value=\'U\' onClick=\"select_upload(this)\" disabled></td>\n\t</tr>\n\t<tr>\t\t\n\t\t<td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td><td class=\'label\' width=\'25%\'>&nbsp;</td><td width=\'25%\'  class=\'button\' align=\'left\' nowrap>\n\t\t\t<input type=\'button\' name=\'OK\' id=\'OK\' \tvalue=\'OK\' onclick=\'callsubmit()\' disabled>\n\t\t\t<input type=\'button\' name=\'CANCEL\' id=\'CANCEL\' value=\'Cancel\' onclick=\'callcancle()\'></td>\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=\"hidden\" name=\"photoCount\" id=\"photoCount\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<!-- Code added by Sethu for 64523\tPMG2017-COMN-CRF-0005\tPatient Photo capture in EM -->\n<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\"hidden\" name=\"user_id\" id=\"user_id\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\"hidden\" name=\"ws_no\" id=\"ws_no\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\n\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	//String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	//System.out.println(" sStyle : "+sStyle);

            _bw.write(_wl_block5Bytes, _wl_block5);
 
String patient_id = request.getParameter("patient_id"); 
// Code added by Sethu for 64523	PMG2017-COMN-CRF-0005	Patient Photo capture in EM 
String patient_name = request.getParameter("patient_name");
String module_id = request.getParameter("module_id");

String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
String user_id = request.getParameter("user_id") == null ? "" : request.getParameter("user_id");
String ws_no = request.getParameter("ws_no") == null ? "" : request.getParameter("ws_no");
String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");


System.out.println(" Patient ID : "+patient_id+" Patient Name : "+patient_name+" Module ID : "+module_id);
System.out.println(" facility_id : "+facility_id+" user_id : "+user_id+" ws_no : "+ws_no+" locale : "+locale);


String photoCount="0";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs=null;
String pStatement = "";
try{

	con = ConnectionManager.getConnection();

	if (module_id.equals("BD")){
		pStatement = "select count(*) count from MP_EXT_PERSON_PHOTO where PERSON_ID=?";
	}
	else if (module_id.equals("MP")){
		pStatement = "select count(*) count from mp_patient_photo where PATIENT_ID=?";
	}

	pstmt = con.prepareStatement(pStatement);
	pstmt.setString(1, patient_id);
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next())
		photoCount=rs.getString("count");
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
}catch(Exception e){
	e.printStackTrace();
} finally {
	if (con != null)
		ConnectionManager.returnConnection(con);
		
}		

            _bw.write(_wl_block6Bytes, _wl_block6);
if(photoCount!=null && photoCount.equals("0")){
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(photoCount));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ws_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
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
