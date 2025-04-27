package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __test extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/Test.jsp", 1743587143232L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eXH/jsp/CommonIncludeSession.jsp", 1733051185073L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="<!DOCTYPE html>\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n<HEAD>\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eCommon/js/common.js\'> </Script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\"../../eCommon/js/ValidateControl.js\"></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eXH/js/Validate.js\'></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\"../../eCommon/js/CommonLookup.js\"></Script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<HTML>\n<SCRIPT language=\"javascript\">\n\tasync function callDocuArch()\n\t{\n\t\tvar dialogHeight = \"250\";\t\t\t    \n\t\tvar dialogWidth  = \"250\";\n\t\tvar dialogTop    = \"230\";\n\t\tvar dialogLeft   = \"230\";\n\t\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\t\tvar arguments  = new Array();\n\t\tvar url = \"docuarch.jsp?patientID=123456\";\n\t\targuments[0] = \'test\';\n\t\tvar returnval = await window.showModalDialog(url,null,features);\t\n\t\talert(returnval);\n\t}\n</SCRIPT>\n\n<style type=\"text/css\">\n#mydiv {\n    position:fixed;\n    top: 20%;\n    left: 45%;\n    margin-top: -3em; /*set to a negative number 1/2 of your height*/\n    margin-left: -9em; /*set to a negative number 1/2 of your width*/\n}\n</style>\n\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\"../../eSM/js/login.js\" language=\"javascript\"></script>\n<script src=\"../../eXH/js/ExternalApplication.js\" language=\"javascript\"></script>\n<script src=\"../../eXH/js/GatewayServer.js\" language=\"javascript\"></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eCommon/js/CommonCalendar.js\'> </Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<HEAD>\n\n</head>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n<form name=\"dmsSimulator\" id=\"dmsSimulator\" id=\"dmsSimulator\">\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey()\'>\n<TABLE ID=\"mydiv\">\n <TR>\n\t<TD>Patient ID</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_PATIENT_ID\" id=\"P_PATIENT_ID\" VALUE=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"></TD>\n </TR>\n  <TR>\n\t<TD>Username</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_USE_ID\" id=\"P_USE_ID\" VALUE=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"></TD>\n </TR>\n <TR>\n\t<TD>Encounter ID</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_EPISODE_ID\" id=\"P_EPISODE_ID\" VALUE=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></TD>\n</TR>\n <TR>\n\t<TD>Encounter Date</TD>\n\t<TD>\n\t\t<INPUT TYPE=\"text\" name=\"P_ENCNTR_DATE\" id=\"P_ENCNTR_DATE\" ID=\"P_ENCNTR_DATE\" SIZE=\"11\" VALUE=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t<INPUT TYPE=\'image\' ID=\"P_ENC_DATE_Calendar\" SRC=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'P_ENCNTR_DATE\',\'dd/mm/y hh:mm\');\">\n\t</TD>\n </TR>\n <!-- <TR>\n\t<TD>Location Type</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_LOCN_TYPE\" id=\"P_LOCN_TYPE\" VALUE=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"></TD>\n</TR>\n <TR>\t\n\t<TD>Location Code</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_LOCN_CODE\" id=\"P_LOCN_CODE\" VALUE=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></TD>\n</TR>\n <TR>\t\n\t<TD>Location Desc</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_LOCN_DESC\" id=\"P_LOCN_DESC\" VALUE=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></TD>\n </TR>\n <TR>\n\t<TD>Encounter Status</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_ENC_STATUS\" id=\"P_ENC_STATUS\" VALUE=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></TD>\n </TR>\n <TR>\n\t<TD>Document Type</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_DOC_TYPE\" id=\"P_DOC_TYPE\" VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></TD>\n </TR>\n <TR>\n\t<TD>Order ID</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_ORDER_ID\" id=\"P_ORDER_ID\" VALUE=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></TD>\n </TR>\n <TR>\n\t<TD>Specimen No</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_SPECIMEN_NO\" id=\"P_SPECIMEN_NO\" VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></TD>\n </TR>-->\n <TR>\n\t<TD>Facility ID</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_FACILITY_ID\" id=\"P_FACILITY_ID\" VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></TD>\n </TR>\n  <TR>\n\t<TD>Card Number</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_CC_NUMBER\" id=\"P_CC_NUMBER\" VALUE=\"\"></TD>\n </TR>\n  <TR>\n\t<TD>Total Bill Amount</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_TOTAL_BILL_AMOUNT\" id=\"P_TOTAL_BILL_AMOUNT\" VALUE=\"\"></TD>\n </TR>\n  <TR>\n\t<TD>Bill Number</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_BILL_NUMBER\" id=\"P_BILL_NUMBER\" VALUE=\"\"></TD>\n </TR>\n  <TR>\n\t<TD>Bill date</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"p_doc_date\" id=\"p_doc_date\" VALUE=\"\"></TD>\n </TR>\n  <TR>\n\t<TD>Reciept Number</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_RECEIPT_NUMBER\" id=\"P_RECEIPT_NUMBER\" VALUE=\"\"></TD>\n </TR>\n <TR>\n\t<TD>Reciept date</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_RECEIPT_DATE\" id=\"P_RECEIPT_DATE\" VALUE=\"\"></TD>\n </TR>\n  <TR>\n\t<TD>Bill Amount</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_BILL_AMOUNT\" id=\"P_BILL_AMOUNT\" VALUE=\"\"></TD>\n </TR>\n <TR>\n\t<TD>Bill Doc Type</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_Bill_Doc_Type\" id=\"P_Bill_Doc_Type\" VALUE=\"\"></TD>\n </TR>\n <TR>\n\t<TD>Bill Doc Num</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_Bill_Doc_Num\" id=\"P_Bill_Doc_Num\" VALUE=\"\"></TD>\n </TR>\n  <TR>\n\t<TD>Settlement Type</TD>\n\t<TD><INPUT TYPE=\"text\" name=\"P_settlement_type\" id=\"P_settlement_type\" VALUE=\"\"></TD>\n </TR>\n\n <TR ALIGN=\"right\">\n\t<TD COLSPAN=\"2\"><INPUT TYPE=\"button\" VALUE=\"Submit\" onClick=\"invokeEMExternalAppServlet(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\"></TD>\n<!-- <TD><INPUT TYPE=\"button\" VALUE=\"Invoke DocuArch(servlet)\" onClick=\"callDocuArch()\"></TD> -->\n </TR>\n</TABLE>\n<INPUT TYPE=\"HIDDEN\" name=\"callFrom\" id=\"callFrom\" VALUE=\"INTERFACE_SIM\">\t\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'patientID\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'userID\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'episodeID\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'encounterDate\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'locationType\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'locationCode\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'locationDate\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'encounterStatus\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'documentType\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'orderID\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'specimenNo\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${documentInfo[\'facilityID\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
