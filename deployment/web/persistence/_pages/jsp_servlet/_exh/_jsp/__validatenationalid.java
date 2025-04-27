package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Enumeration;
import java.io.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.net.*;
import java.util.*;

public final class __validatenationalid extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/validateNationalID.jsp", 1709122395475L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<HTML>\t\n<HEAD>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<meta charset=\"utf-8\">\n\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=11\">\n\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n\t<title> National Id </title>\n\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" type=\"text/css\"/>\n\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<script language=\"javascript\" src=\"https://10.107.203.5:51341/v0/static/js/connector.min.js\"></script>\n\t\n    <script Language=\"JavaScript\">\n\n    ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\n\t$(document).ready(function() {   \n     \n\t /*$(\"#getNID\").click(function() {\t\t*/\t\n\t\tif(";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="){\n\t\t\talert(\"IE Version Support: \"+document.documentMode);\t\t\t\n\t\t}\n\t\twindow.returnValue =  validateNationalID(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' ,\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\', \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\n\t    window.close();\n\t\t\n\t/*})*/\n\t\t\n\t});\n\t\n\tfunction validateNationalID(nationalID, sessionID, facility, loginUser, p_ws_no) {\n\t    var responseStr = \'\';\n\t    var resdata = \'\';\n\t    if(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="){\n\t    \talert(\"Entering into the validateNationalID function\");\n\t    }\n\t    if (nationalID == null || nationalID == \"\") {\n\t    \t\n\t    \t\n\t    \tvar appid = this.document.forms[0].app_id.value;\n\t    \t\n\t    \tif(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="){\n\t\t    \talert(\"Initiating JSConnector by appId: \"+appid);\n\t\t    }\n\n\t        JSConnector.init({\n\t            appID: appid\n\t        },function(data, error) {\n\t        \t\n\t        \tif(error){\n\t        \t\tvar errorJson = jQuery.parseJSON(error);\n\t\t\t\t\tif(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="){\n\t\t\t\t\t\talert(\"Init callback Error: \"+errorJson);\n\t\t\t\t\t}\n\t        \t\t$(\'.jsConnFailed\').append(\'<h5 style=\"color:red\"><p>JS Connector Initialization Failed. \'+errorJson.error.message+\'</p></h5>\');\n\t        \t\treturn errorJson.error.message;\n\t        \t}\t        \t\n\t        \t\n\t        \tresdata = jQuery.parseJSON(data);\n\t        \t\n\n\t        \tif(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="){\n\t\t\t    \talert(\"JSConnector Initiated...\"+resdata);\n\t\t\t    }\n\n\t\t        $(\'.jsConIni\').append(\'<h5 style=\"color:green\"><p>JS Connector Initialized Successfully...</p></h5>\');\n\t        \t\n\t        });\n\t        \n\t        \n\t        \n\t        JSConnector.authorizeCard({}, function(data, error) {\n\t             \n\t        \tif(error){\n\t        \t\tvar errorJson = jQuery.parseJSON(error);\n\t\t\t\t\tif(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="){\n\t\t\t\t\t\talert(\"AuthorizeCard callback Error: \"+errorJson);\n\t\t\t\t\t}\n\t        \t\t$(\'.jsAuthFailed\').append(\'<h5 style=\"color:red\"><p>JS Connector Authorization Failed. \'+errorJson.error.message+\'</p></h5>\');\n\t        \t\treturn errorJson.error.message;\n\t        \t}\n\t             \n\t\t\t\t//var data = \"{\\\"transactionRef\\\": \\\"\\\",\\\"requestID\\\": \\\"651c7936-f017-4210-be02-3603f6a00633\\\"}\";\n\t            //alert(\'error:::\' + error);\n\t            //alert(\'data:::\' + data);\n\t            \n\t            resdata = jQuery.parseJSON(data);\n\n\t            $(\'.jsConAuth\').append(\'<h5 style=\"color:green\"><p>JS Connector Authorized Successfully with Operation UUID : \'+resdata.operationUUID+\'</p></h5>\');\n\t            alert(\'resdata.operationUUID:::\' + resdata.operationUUID);\n\t            $(\'.callingAPI\').append(\'<h5 style=\"color:green\"><p>Passing Operation UUID to Cysheild API</p></h5>\');\n\t            responseStr = GetNationalID(nationalID, resdata, 1, sessionID, facility, loginUser, p_ws_no);\n\t            // return \"S$!^TR455555555555$!^Retrived Successfully$!^Y$!^Y\";\n\t            alert(\'responseStr (1):::\' + responseStr);\n\t            \n\t        });\n\n\n\t    } else {\n\t    \t$(\'.nidtoCyshAPI\').append(\'<h5 style=\"color:green\"><p>Passing national Id to Cysheild API with national Id :\'+nationalID+\'</p></h5>\');\n\t        responseStr = GetNationalID(nationalID, resdata, 2, sessionID, facility, loginUser, p_ws_no);\n\t        // return \"S$!^\" + nationalID + \"$!^Card is not issued$!^N$!^N\";\n\t        alert(\'responseStr (2):::\' + responseStr);\n\t    }\n\t    \n\t    return responseStr;\n\n\t}\n\n\n\tfunction GetNationalID(nationalID, resdata, apiType, sessionID, facility, loginUser, p_ws_no) {\n\t    var rtnResponse = \"\";\n\t    var request_type=\"\";\n\t    \n\t    if(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="){\n\t    \talert(\"Inside GetNationalID function... \"+nationalID+\":\"+resdata+\":\"+apiType+\":\"+sessionID+\":\"+facility+\":\"+loginUser+\":\"+p_ws_no);\n\t    }\n\t    \n\t    request_type=\'MOHAD1\';\n\t    \n\t    \n\t    $.ajax({\n\t        url: \'../../servlet/eXH.InvokeEGLapplication\',\n\t        type: \'POST\',\n\t        cache: false,\n\t        data: {\n\t            callType: \'GetNationalID\',\n\t            TRANS_REF_ID: resdata.operationUUID,\n\t            national_id: nationalID,\n\t            facility_id: facility,\n\t            logged_in_user: loginUser,\n\t            logged_in_ws_no: p_ws_no,\n\t            session_id: sessionID,\n\t            request_type:request_type\n\t        },\n\t        success: function(responseData) {\n\t        \n\t         \tresponseData = responseData.split(\"#\");\n\t            responseData = responseData[0];\n\t            responseData = responseData.trim();\n\t            var resArray = responseData.split(\"$!^\");\n\t            var response = resArray[0];\n\t            \n\n\t            if (response==\"S\" && resArray.length >= 10) {\n\t                if (apiType == 1) {\n\t                    rtnResponse = \"S$!^\"+resdata.operationUUID+\"$!^\" + resArray[8] + \"$!^\" + resArray[9];\n\t            \t\t$(\'.cyshAPIResp\').append(\'<h5 style=\"color:green\"><p>Repsonse From Cyshiled API with National Id :\'+resArray[8]+\'</p></h5>\');\n\t                } else {\n\t                    rtnResponse = \"S$!^\" +resArray[10]+ \"$!^\" + resArray[8] + \"$!^\" + resArray[9];\n\t        \t\t\t$(\'.nidStatus\').append(\'<h5 style=\"color:green\"><p>Repsonse From Cyshiled API with National Id :\'+resArray[8]+\' and card issued status: \' + resArray[10] + \'</p></h5>\');\n\t                }\n\t            } else if (response==\"F\" && resArray.length >= 9) {\n\t            \tvar errorRes = jQuery.parseJSON(resArray[4]);\n\t                if (apiType == 1) {\t                \t\n\t                    rtnResponse = \"F$!^\"+resdata.operationUUID+\"$!^\" + resArray[8] + \"$!^\"+errorRes.statusDescription;\n\t                    $(\'.nidStatus\').append(\'<h5 style=\"color:red\">Failed to receive response from API<p></p></h5>\');\n\t                } else {\n\t                    rtnResponse = \"F$!^null$!^\" + resArray[8] + \"$!^\"+errorRes.statusDescription;\n\t                    $(\'.nidStatus\').append(\'<h5 style=\"color:red\">Failed to receive response from API<p></p></h5>\');\n\t                }\n\t            } else {\n\t                rtnResponse = \"F$!^$!^Response Error (Length: \" + resArray.length + \")$!^$!^\";\n\t            }\n\n\t        },\n\t        dataType: \'text\',\n\t        async: false\n\t    });\n\n\t    return rtnResponse;\n\n\t}\n\t\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n</HEAD>\n<body>\n\t<form>\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align = \'center\' width=\'100%\' height=\'150px\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" class=\"label\">\n\t\t\t\t\t<p class=\'jsConIni text-success\'></p>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" class=\"label\">\n\t\t\t\t\t<p class=\'jsConAuth text-success\'></p>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" class=\"label\">\n\t\t\t\t\t<p class=\'callingAPI text-success\'></p>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" class=\"label\">\n\t\t\t\t\t<p class=\'resAPI text-danger\'></p>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" class=\"label\">\n\t\t\t\t\t<p class=\'cyshAPIResp text-success\'></p>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" class=\"label\">\n\t\t\t\t\t<p class=\'nidtoCyshAPI text-success\'></p>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" class=\"label\">\n\t\t\t\t\t<p class=\'nidStatus\'></p>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" class=\"label\">\n\t\t\t\t\t<p class=\'jsConnFailed text-danger\'></p>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" class=\"label\">\n\t\t\t\t\t<p class=\'jsAuthFailed text-danger\'></p>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align = \'center\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<td><p id=\"demo\" style=\"color:red;\">Kindly wait... Fetching National ID... this window will close automatically...</p></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t\n\t\t<input type=\"hidden\" name=\"app_id\" id=\"app_id\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t</form>\n\t\n</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");   
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
 
    
    String nationalID=request.getParameter("nationalID");
    String sessionID=request.getParameter("sessionID");
    String facility=request.getParameter("facility");
    String loginUser=request.getParameter("loginUser");
    String p_ws_no=request.getParameter("p_ws_no");
    
    Connection conn = null;
    boolean isDebugYN = false;
    try {
        isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN,'N') DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

        System.out.println("***Inside Validate National ID - isDebugYN Flag..." + isDebugYN);
        
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("***Inside Validate National ID - Exception while checking isDebugYN Flag... " + e);
    } finally {
        //ConnectionManager.returnConnection(conn); //V211020
        if (isDebugYN)
            System.out.println("***Inside Validate National ID - Conection closed");
    }
    
    String app_id ="";
    
    String sqlStatement = "";
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
    	conn = ConnectionManager.getConnection();
        sqlStatement = "SELECT DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG WHERE SEGMENT_ID='MOHE1' AND ELEMENT_ID='APP_ID'";
        
        
        pstmt = conn.prepareStatement(sqlStatement);

        rs = pstmt.executeQuery();
        
        if (rs != null) {
            while (rs.next()) {
                app_id = rs.getString("DEFAULT_VALUE");
            }
        }

        if (isDebugYN)
            System.out.println("***Inside Validate National ID - SQL... " + sqlStatement + " ***app_id  : " + app_id);
    } catch (Exception e) {
        System.out.println("***Inside Validate National ID - Exception in fetching App_ID " + e);
    } finally {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        //ConnectionManager.returnConnection(conn);//V211020
        if (isDebugYN)
            System.out.println("***Inside Validate National ID - Conection closed");
    }
    
    
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(nationalID));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sessionID));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_ws_no));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(app_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
