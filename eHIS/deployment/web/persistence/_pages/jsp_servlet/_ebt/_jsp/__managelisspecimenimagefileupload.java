package jsp_servlet._ebt._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __managelisspecimenimagefileupload extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/ManageLISSpecimenImageFileUpload.jsp", 1709115155900L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\t\t\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<!-- Commented by Sanjay for 10.x conversion --> \n<!-- <script src=\"../../eCA/js/CAMessages.js\" language=\"javascript\"></script> -->\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\n<script src=\"../../eBT/js/ManageLISSpecimenImage.js\" language=\"javascript\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\t\t\n</head>\n<body>\n<form name=\'LISImgFileUploadForm\' id=\'LISImgFileUploadForm\' enctype=\'multipart/form-data\'>\n<table class=\'CAGROUP\' border=\'0\' width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' align=\'center\'>\n<tr>\n\n<td align=\'right\'><input type=\'file\' name=\'uploadImageFile\' id=\'uploadImageFile\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\n<td align=\'right\'><input type=\'button\' class=\'button\' name=\'upload\' id=\'upload\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' onclick=\'uploadFile()\'></td>\n\n</tr>\t\t\t\n</table>\n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=\'hidden\' name=\'clientIpAddress\' id=\'clientIpAddress\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=\'hidden\' name=\'addedById\' id=\'addedById\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'sessionId\' id=\'sessionId\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'test\' id=\'test\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'specNum\' id=\'specNum\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'anatomy\' id=\'anatomy\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'sampleId\' id=\'sampleId\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\t \n<input type=\'hidden\' name=\'filePath\' id=\'filePath\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\t \n<input type=\'hidden\' name=\'applServerURL\' id=\'applServerURL\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\t\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\'hidden\' name=\'pathExist\' id=\'pathExist\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\t\n<input type=\'hidden\' name=\'writeAccess\' id=\'writeAccess\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
java.util.Properties p = (Properties) session.getValue("jdbc");
String facilityId = (String) session.getValue( "facility_id" ) ;
String clientIpAddress = p.getProperty("client_ip_address");
String  addedById = p.getProperty( "login_user" );
String sessionId = (String) session.getId();
String appServerURL = "";

Connection con = null;
PreparedStatement pstmt = null;
ResultSet res = null;

// STARTS
PreparedStatement pstmt1 = null;
ResultSet res1 = null;
PreparedStatement pstmt2 = null;
ResultSet res2 = null;
String secCode = "";
String testCode = request.getParameter("test") == null ? "" : request.getParameter("test");
String filePath = "";
String pathExist="";
String writeAccess="";
// ENDS

//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");
//System.out.println("ManageLISSpecimenImageFileUpload.jsp request.getQueryString:" + request.getQueryString());

try
{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM RL_EXT_INTERFACE_PARAM	where EXT_APPL_ID='LBIMG'  ");
	res = pstmt.executeQuery();

	while(res.next())
	{
		appServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
	}

	if(res != null) res.close();
	if(pstmt != null) pstmt.close();

	
	// STARTS
	// Query to get Section Code STARTS here
	/*
				pstmt1 = con.prepareStatement("select section_code from rl_test_code where TEST_CODE = ?");
				pstmt1.setString(1,testCode);
				res1 = pstmt1.executeQuery();
				while(res1.next())
				{
					secCode = res1.getString(1) == null ? "" : res1.getString(1);
				}
				if(res1 != null) res1.close();
				if(pstmt1 != null) pstmt1.close();
				*/
	//System.out.println("ManageLISSpecimenImageFileUpload.jsp secCode:" + secCode);
	// Query to get Section Code ENDS here
	// ENDS

	// Query to get file path for copying uploaded Image STARTS here
	String sqlFilePath = "select IMAGE_FILE_HOME_IDR from RL_SECTION_CTL where OPERATING_FACILITY_ID = ? and SECTION_CODE = ?";
	pstmt2 = con.prepareStatement(sqlFilePath);
	pstmt2.setString(1,facilityId);
	//secCode = "G";//Sanjay
	pstmt2.setString(2,secCode);
	
	res2 = pstmt2.executeQuery();
	while(res2.next())
	{
		filePath = res2.getString(1) == null ? "" : res2.getString(1);
	}
	if(res2 != null) res2.close();
	if(pstmt2 != null) pstmt2.close();
	// Query to get file path for copying uploaded Image ENDS here
	//System.out.println("ManageLISSpecimenImageFileUpload.jsp filePath:" + filePath);
	filePath = filePath.replace("\\", "/");
	String separator = System.getProperty( "file.separator" );
	File f = new File(filePath);
	if(f.exists())
	{
		pathExist="true";
		File file1 = new File(filePath+separator+System.currentTimeMillis()+".txt"); 
		try
		{
			if (file1.createNewFile())
			{
				writeAccess="true";
				file1.delete();
			}
			else
			{
				writeAccess="false";
			}
		}
		catch (IOException e)
        {
			writeAccess="false";
        }
	}
	else
	{
		pathExist="false";
	}
	//System.out.println("ManageLISSpecimenImageFileUpload.jsp filePath after:" + filePath);
	
	
}
catch(Exception e)
{
	//System.out.println("Exception in try of ManageLISSpecimenImageFileUpload.jsp --"+e.toString());
	//out.println("Exception in try of ManageLISSpecimenImageFileUpload.jsp --"+e.toString());
	e.printStackTrace(System.err);
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clientIpAddress));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(addedById));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sessionId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getParameter("test")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getParameter("specNum")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getParameter("anatomy")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getParameter("sampleId")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(filePath));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(appServerURL));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pathExist));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(writeAccess));
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UploadFile.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
