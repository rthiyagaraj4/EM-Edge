package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eBL.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blgenrcptforvendorsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLGenRcptForVendorsMain.jsp", 1737916018306L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n28-JAN-2019      100           \tAravindh.H          Created\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eBL/js/BLGenRcptForVendorsScript.js\'></script>\n\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'genRcptForVendorsSrch\' id=\'genRcptForVendorsSrch\' id=\'genRcptForVendorsSrch\' src=\'../../eBL/jsp/BLGenRcptForVendorsSearch.jsp\' frameborder=0 noresize scrolling=\'no\' style=\'height:30vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\"genRcptForVendorsRslt\" id=\"genRcptForVendorsRslt\" id=\'genRcptForVendorsRslt\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\'height:52vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\n<body>\n</body>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

private String nulltoStr(String inputString) {
	if (inputString == null) {
		return "";
	} else {
		return inputString;
	}
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;
	System.out.println("Aravindh->BLGenRcptForVendorsMain.jsp: " + source);
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	CallableStatement cstmt = null;
	
	String practoCashCounterCode = "", practoUser = "", practoSlmtType = "", cashCtrCode = "", cashierShift = "", errorCode = "";
	try {
		con = ConnectionManager.getConnection(request);
		boolean siteSpecCashCtrChk = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_VLDT_CSH_CTR_CHK");
		boolean flagDefChk = true;
		String facilityId = (String) session.getAttribute("facility_id");
		String locale = (String) session.getAttribute("LOCALE");
		Properties p = (Properties) session.getValue( "jdbc" ) ;
		String clientIpAddress	= p.getProperty("client_ip_address");
		if(siteSpecCashCtrChk) {
			
			String sql = "SELECT def_practo_cash_ctr_code, def_practo_user, def_practo_slmt_type FROM bl_parameters WHERE operating_facility_id = '"+facilityId+"'";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()) {
				practoCashCounterCode = nulltoStr(rst.getString("def_practo_cash_ctr_code"));
				practoUser = nulltoStr(rst.getString("def_practo_user"));
				practoSlmtType = nulltoStr(rst.getString("def_practo_slmt_type"));
			}
			
			if("".equals(practoCashCounterCode)) {
				flagDefChk = false;
				out.println("<script>var msg = getMessage('BL0804', 'BL'); msg = msg.replace('$', 'Cash Counter');alert(msg);</script>");
			} else if("".equals(practoUser)) {
				flagDefChk = false;
				out.println("<script>var msg = getMessage('BL0804', 'BL'); msg = msg.replace('$', 'Cash Counter User');alert(msg);</script>");
			} else if("".equals(practoSlmtType)) {
				flagDefChk = false;
				out.println("<script>var msg = getMessage('BL0804', 'BL'); msg = msg.replace('$', 'Settlement Type');alert(msg);</script>");
			}
			
			if(flagDefChk) {
				cstmt = con.prepareCall("{ call bl_user_check_for_cash_counter(?,?,?,?,?,?,?) }");
				cstmt.setString(1, facilityId);
				cstmt.setString(2, "R");
				cstmt.setString(3, practoUser);
				cstmt.setString(4, clientIpAddress);
				cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
				
				cstmt.execute();
				
				cashCtrCode = nulltoStr(cstmt.getString(5));
				cashierShift = nulltoStr(cstmt.getString(6));
				errorCode = nulltoStr(cstmt.getString(7));
				
				if(!"".equals(errorCode)) {
					flagDefChk = false;
					Hashtable messageHashtable=new Hashtable();
					messageHashtable = MessageManager.getMessage(locale, errorCode, "BL");
					String msg= (String)messageHashtable.get("message");
					out.println("<script>alert('"+msg+"');</script>");
				}
			}
			System.out.println("Printing line in main.jsp");
		}

            _bw.write(_wl_block8Bytes, _wl_block8);
 if(flagDefChk) { 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source));
            _bw.write(_wl_block10Bytes, _wl_block10);
} 
            _bw.write(_wl_block11Bytes, _wl_block11);

	} catch(Exception e) {
			System.err.println("Error in BLGenRcptForVendorsMain: "+e);
			e.printStackTrace();
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
