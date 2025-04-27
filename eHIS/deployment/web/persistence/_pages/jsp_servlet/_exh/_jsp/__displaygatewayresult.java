package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;

public final class __displaygatewayresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DisplayGatewayResult.jsp", 1733051230824L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'\n\ttype=\'text/css\'></link>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script type=\"text/javascript\" language=\"JAVASCRIPT\"\n\tsrc=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eCommon/js/jquery-3.6.3.js\"></script>\n<script Language=\"JavaScript\" src=\"../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\">\nfunction displayDialogMsg() {\n\t\n\t\talert(\" ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" );\ndocument.forms[0].submit();\n}\n</script>\n<Script src=\"../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n\n\n\n</head>\n<BODY CLASS=\"MESSAGE\" onLoad=\"displayDialogMsg();\"\n\tonMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey()\'>\n\t<form name=\"gatewaydisplayform\" id=\"gatewaydisplayform\"\n\t\taction=\"../servlet/eXH.CentralizedServlet\" method=\"get\">\n\n\t\t<input type=\"hidden\" name=\"gatewayoperation\" id=\"gatewayoperation\" value=\"refresh\"\n\t\t\tid=\"gatewayoperation\"> <input type=\"hidden\"\n\t\t\tname=\"selectedcommunimode\" id=\"selectedcommunimode\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t\t\t<input type=\"hidden\"\n\t\t\tname=\"serverclientid\" id=\"serverclientid\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t\t<input type=\"hidden\"\n\t\t\tname=\"application\" id=\"application\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t<input type=\"hidden\"\n\t\t\tname=\"facility\" id=\"facility\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"frame\" id=\"frame\" value=\"body\">\n\n\t</form>\n</BODY>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	List<String> resultArrayList = new ArrayList<String>();
	String selectedCommuniMode = "";
	String resultMsg = "";
	String clientID="";
	String applicationID="";
	String facilityID="";
	String gatewayOperation = "refresh";
	resultArrayList = (List<String>) request
			.getAttribute("resultArrayList");
	if (resultArrayList != null) {
		
		for(int i=0;i<resultArrayList.size();i++)
		{
			resultMsg=resultMsg+resultArrayList.get(i);
		}
	}
System.out.println("final result...."+resultMsg);
	selectedCommuniMode = request.getParameter("selectedcommunimode");
	clientID = request.getParameter("serverclientid");
	applicationID = request.getParameter("application");
	facilityID = request.getParameter("facility");
	System.out.println("slecte com type..." + selectedCommuniMode);
	System.out.println("clientID com type..." + clientID);
	System.out.println("applicationID com type..." + applicationID);
	System.out.println("facilityID com type..." + facilityID);
	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(resultMsg ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(selectedCommuniMode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(clientID));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(applicationID));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityID));
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
