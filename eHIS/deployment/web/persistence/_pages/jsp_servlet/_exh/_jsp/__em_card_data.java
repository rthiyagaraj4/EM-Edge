package jsp_servlet._exh._jsp;

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

public final class __em_card_data extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/EM_Card_Data.jsp", 1709117573151L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n</head>\n<body align=\"center\" style=\"font-size: 10px; font-style: verdana;\">\n\n    <table border=\"0\" align=\"center\" width=\"85%\">        \n        <tr>\n            <td>\n                <table width=\"100%\" border1=\"1\" margin1=\"0\" cellpadding1=\"0\"\n                    cellspacing1=\"0\"\n                    style=\"background-color: #cfd8fd; border: solid 1px gray\"\n                    align=\"center\">\n                    <tr>\n                        <td>\n                            <table>\n                                <tr>\n                                    <td align=\"center\"><APPLET style=\"border: solid 1px gray\"\n                                            id=\"EIDAWebComponent\" name=\"EIDAWebComponent\"\n                                            CODE=\"emiratesid.ae.webcomponents.EIDAApplet\"\n                                            ARCHIVE=\"EIDA_IDCard_Applet.jar\" WIDTH=\"130\" HEIGHT=\"154\">\n                                            This browser does not support Applets. </APPLET>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td>\n                                        <table>\n                                            <tr>\n                                                <td><span>ID Type:&nbsp;</span>\n                                                </td>\n                                                <td>\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" </td>\n                                            </tr>\n                                            <tr>\n                                                <td><span>CSN:&nbsp;</span>\n                                                </td>\n                                                <td>\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\n                                                </span>\n                                                </td>\n                                            </tr>\n                                            <tr>\n                                                <td><span>ID Number:&nbsp;</span>\n                                                </td>\n                                                <td>\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"\n                                                </td>\n                                            </tr>\n                                            <tr>\n                                                <td><span>Card Number:&nbsp;</span>\n                                                </td>\n                                                <td>\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"\n                                                </td>\n                                            </tr>\n                                            <tr>\n                                                <td><span>Issue Date:&nbsp;</span>\n                                                </td>\n                                                <td>\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"\n                                                </td>\n                                            </tr>\n                                            <tr>\n                                                <td><span>Expiry Date:&nbsp;</span>\n                                                </td>\n                                                <td>\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\n                                                </td>\n                                            </tr>\n                                        </table>\n                                    </td>\n                                </tr>\n                            </table>\n                        </td>\n                        <td>\n                            <table>\n                                <tr>\n                                    <td><span>sex:&nbsp;</span>\n                                    </td>\n                                     <td>\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Date of Birth:&nbsp;</span>\n                                    </td>\n                                    <td>\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Full Name (Ar):&nbsp;</span>\n                                    </td>\n                                    <td>\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Full Name:&nbsp;</span>\n                                    </td>\n                                    <td>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Marital Status:&nbsp;</span>\n                                    </td>\n                                    <td>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Occupation:&nbsp;</span>\n                                    </td>\n                                    <td>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Title (Ar):&nbsp;</span>\n                                    </td>\n                                    <td>\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Title:&nbsp;</span>\n                                    </td>\n                                    <td>\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Nationality (Ar):&nbsp;</span>\n                                    </td>\n                                    <td>\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Nationality:&nbsp;</span>\n                                    </td>\n                                    <td>\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"\n                                    </td>\n                                </tr>\n\n                            </table>\n                        </td>\n                        <td>\n                            <table>\n                                <tr>\n                                    <td><span>Mother First Name (Ar):&nbsp;</span>\n                                    </td>\n                                    <td><span id=\"ArabicMotherFirstName_PDLabel\"><b>--</b>\n                                    </span>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Mother First Name:&nbsp;</span>\n                                    </td>\n                                    <td><span id=\"MotherFirstName_PDLabel\"><b>--</b> </span>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Familly ID:&nbsp;</span>\n                                    </td>\n                                    <td><span id=\"FamilyID_PDLabel\"><b>--</b> </span>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Husband IDN:&nbsp;</span>\n                                    </td>\n                                    <td><span id=\"HusbandIDN_PDLabel\"><b>--</b> </span>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Sponsor Type:&nbsp;</span>\n                                    </td>\n                                    <td><span id=\"SponsorType_PDLabel\"><b>--</b> </span>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Sponsor Number:&nbsp;</span>\n                                    </td>\n                                    <td><span id=\"SponsorNumber_PDLabel\"><b>--</b> </span>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Sponsor Name:&nbsp;</span>\n                                    </td>\n                                    <td><span id=\"SponsorName_PDLabel\"><b>--</b> </span>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Residency Type:&nbsp;</span>\n                                    </td>\n                                    <td><span id=\"ResidencyType_PDLabel\"><b>--</b> </span>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Residency Number:&nbsp;</span>\n                                    </td>\n                                    <td><span id=\"ResidencyNumber_PDLabel\"><b>--</b> </span>\n                                    </td>\n                                </tr>\n                                <tr>\n                                    <td><span>Residency Expiry Date:&nbsp;</span>\n                                    </td>\n                                    <td><span id=\"ResidencyExpiryDate_PDLabel\"><b>--</b>\n                                    </span>\n                                    </td>\n                                </tr>\n                            </table>\n                        </td>\n                    </tr>\n                </table>\n            </td>\n        </tr>         \n    </table> \n\n</body>\n</html>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);

	String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));	

	if(isDebugYN.equals("Y"))
		System.out.println(" - - -  Inside EM_Card_Data.jsp  - - - ");

	String summary = "";

	String getTitleUsr = "", fullName = "", sex = "",  EID = "", Dob = "", Nationality = "", HomeAddress = "",  City = "", Mb = "", Visa = "", VisaExp = "", Country = "";

	String idType = "", CSN = "", idNumber = "", cardNumber = "",  issueDate = "", expDate = "";

	summary = request.getParameter("summary") == null ? "" : request.getParameter("summary");

	String delims = "$!^";
	StringTokenizer st = new StringTokenizer(summary,delims );

	ArrayList<String> cardData = new ArrayList<String>();

	while (st.hasMoreElements()) {
		cardData.add(st.nextToken().toString());			
	}

	if (cardData.size()>0)
	{
		if(isDebugYN.equals("Y"))
			System.out.println(" - - -  Card Data size ::: "+cardData.size());
		
		idType = cardData.get(1);
		CSN = cardData.get(2);
		idNumber = cardData.get(3);
		cardNumber = cardData.get(4);
		issueDate = cardData.get(5);
		expDate = cardData.get(6);

		getTitleUsr = "";
		fullName = cardData.get(7);
		sex = cardData.get(8);
		EID = cardData.get(10);
		Dob = cardData.get(11);
		HomeAddress = cardData.get(13);
		City = cardData.get(14);
		Mb = cardData.get(15);
		Visa = cardData.get(16);
		VisaExp = cardData.get(17);
		Country = cardData.get(18);
	}

	
	


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(idType));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(CSN));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(idNumber));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(cardNumber));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(issueDate));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(expDate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fullName));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(getTitleUsr));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(getTitleUsr));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Nationality));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Nationality));
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
