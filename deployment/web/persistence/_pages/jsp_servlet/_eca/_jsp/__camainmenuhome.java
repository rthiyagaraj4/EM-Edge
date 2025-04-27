package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __camainmenuhome extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainMenuHome.jsp", 1738424447013L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n\t<script src=\'../../eCA/js/CASummaryMenu.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCA/js/CAMenu.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script> \n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script Language=\"JavaScript\" src=\"../../eCommon/js/logout.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</script>\n\t<script>\n\t\t//IN052053 Start.\n        $(document).ready(function() {\n                setInterval(function() {\n                        $(\'#SummaryDtl\').load(\"../../eCA/jsp/CAMainHomePageTree.jsp?desktopID=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\").fadeIn(\"slow\");\n                }, Number(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="));\n        });\n\t\t//IN052053 End.\n      //IN066237 starts\n\t\tif(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" &&(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="!= \"\" && ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="!=null)) {\n        \tmyVar = setInterval(function(){ selfNoteAutoRefresh(); }, Number(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="));\t\t\n\t\t}\n      \n        function selfNoteAutoRefresh() { \n        \tvar summ_id=\"HPC_NT_RVP\";\n\t\t\tvar deskid=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\txmlStr =\"<root><SEARCH \" ;\t\n\t\t\txmlStr += \"summ_id=\\\"\"+ summ_id + \"\\\" \" ;\t\t\n\t\t\txmlStr += \"desktopID=\\\"\"+ deskid + \"\\\" \" ;\n\t\t\txmlStr +=\" /></root>\" ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\n\t\t\txmlHttp.open( \"POST\", \"CAMainMenuIntermediate.jsp\", false ) ;\n\t\t\txmlHttp.send(xmlDoc ) ;\n\t\t\tresponseText=trimString(xmlHttp.responseText);\n\n\t\t\tvar resultStr =responseText.split(\"|\");\n\t\t\tif(responseText!=\'\'){\n\t\t\n\t\t\tdocument.getElementById(resultStr[0]).innerHTML =\"&nbsp;&nbsp;&nbsp;&nbsp;\"+resultStr[1];\t\t\t\t\t\t\n\t\t\t}\n\t\t}\n\t\t//IN066237 ends\n\t\t//5125 Start.\n\t\tif(";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =") {\n        \tmyVar = setInterval(function(){ outPatientAutoRefresh(); }, Number(300000));\t\t\n\t\t}\n\t\tfunction outPatientAutoRefresh() { \n        \tvar summ_id=\"HPC_PL_OP\";\n\t\t\tvar deskid=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\txmlStr =\"<root><SEARCH \" ;\t\n\t\t\txmlStr += \"summ_id=\\\"\"+ summ_id + \"\\\" \" ;\t\t\n\t\t\txmlStr += \"desktopID=\\\"\"+ deskid + \"\\\" \" ;\n\t\t\txmlStr +=\" /></root>\" ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\n\t\t\txmlHttp.open( \"POST\", \"CAMainMenuIntermediate.jsp\", false ) ;\n\t\t\txmlHttp.send(xmlDoc ) ;\n\t\t\tresponseText=trimString(xmlHttp.responseText);\n\n\t\t\tvar resultStr =responseText.split(\"|\");\n\t\t\tif(responseText!=\'\'){\n\t\t\t\tvar outResultStr=\"&nbsp;&nbsp;&nbsp;&nbsp;\"+resultStr[1];\n\t\t\t\tif(resultStr[2]>0 || resultStr[3]>0)\n\t\t\t\t\toutResultStr=outResultStr+\"&nbsp;<img src=\'../../eCA/images/bellIcon.png\' alt=\'Patients Waiting for Virtual Consultation\'/>\";\n\t\t\t\tdocument.getElementById(\'resultStr\').innerHTML =outResultStr;\n\t\t\t}\n\t\t\tif(resultStr[2]>0)\n\t\t\t\talert(\"Patient Arrived - A patient has joined the C4C meeting and is currently waiting in the virtual waiting area. Your attention is needed for the scheduled conslultation.\");\n\t\t}\n\t\t//51215 End.\n        \n</script>\n<!-- IN061885 Changes starts -->\n<style>\nDIV.divslideActive1\n{\n\t position:absolute;\t\t\t\t\t\n\t width:217px;\t\t\t\t\t \t\n\t height:21px;\t\t\t\t\t\n\tbackground-image:url(\'../../eCommon/images/Sliding-active.jpg\');\n\tbackground-repeat: repeat-x;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 9pt;\n\tcolor: #000000;\n\tfont-weight:bold;\n\ttext-align:left;\n\tpadding-left:5px;\n\tpadding-right:0px;\n\tvertical-align:top;\n\tborder-left:2px;\n\tborder-right:2px;\n\tborder-top:2px;\n\tborder-bottom:2px;\n\tborder-color:#A2C1C6;\n\tborder-style:solid;\n\tmargin:0;\n\tborder-collapse: collapse;\n}\nDIV.divslideInActive1\n{\n\t position:absolute;\t\t\t\t\t\n\t width:217px;\t\t\t\t\t \t \n\t height:21px;\t\t\t\t\t\n\tbackground-image:url(\'../../eCommon/images/Sliding-normal.jpg\');\n\tbackground-repeat: repeat-x;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 9pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:5px;\n\tpadding-right:0px;\n\tvertical-align:top;\n\tborder-left:2px;\n\tborder-right:2px;\n\tborder-top:2px;\n\tborder-bottom:2px;\n\tborder-color:#A2C1C6;\n\tborder-style:solid;\n\tmargin:0;\n\tborder-collapse: collapse;\n}\n</style>\n<!-- IN061885 Changes Ends -->\n</head>\n\n<body  class=\"NavigIconsBorder\" OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload=\"setCustLayout(\'Summary\',\'SummaryDtl\',\'Navigation\',\'Desktop\')\">\n<div id=\"master\" STYLE=\"position:absolute; left:0; top:0;\" >\n\t<TABLE width=\"100%\" CELLSPACING=0 class=\"COMMON_TOOLBAR\" cellpadding=\"0\" border=1>\n\t<TR ><TD >\n\t\t\t\t<!-- Modified by Dharma 16th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start-->\n\t\t\t\t<!--<IMG style=\"cursor:pointer\" SRC=\"../../eCommon/images/Logout.gif\" BORDER=0 ALT=\"\" align=\"absmiddle\"   TITLE=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onclick=\"imagetoolFunction(1)\">-->\n\t\t\t\t<IMG style=\"cursor:pointer\" SRC=\"../../eCommon/images/Logout.gif\" BORDER=0 ALT=\"\" align=\"absmiddle\"   TITLE=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onclick=\"imagetoolFunction(1,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\">\n\t\t\t\t<!-- Modified by Dharma 16th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End-->\n\t\t\t\t<IMG style=\"cursor:pointer\" SRC=\"../../eCommon/images/switch_resp.gif\" BORDER=0 ALT=\"\" align=\"absmiddle\" onclick=\"imagetoolFunction(2)\" TITLE=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t<IMG style=\"cursor:pointer\" SRC=\"../../eCommon/images/personalize02.gif\" BORDER=0 ALT=\"\" align=\"absmiddle\"  onclick=\"imagetoolFunction(3)\"  TITLE=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t</TD>\n\t\t</TR>\n\t</table>\n</div>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t \n\t\t <div id=\"mainDIV\" >\t\t\n\t\t\t<div id=\"Summary\" class=\"divslideActive1\" style=\"top:20px\" title=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' onclick=\"slidPanelOnclick(this,\'Navigation\',\'SummaryDtl\',\'Desktop\')\" ><!--Summary IN035912--> <!-- Changed class divslideActive to divslideActive1 IN061885-->\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t<!-- IN035912-->   \n\t\t\t \n\t\t  </div>\t\n\t\n\t\t  <div id=\"SummaryDtl\" \n\t\t\t  style=\"position:absolute;\n\t\t\t\t\t width:222px;\n\t\t\t\t\t height:400px;           \n\t\t\t\t\t top:40px;\n\t\t\t\t\t left:0px;\n\t\t\t\t\t background:#FFFFFF;\n\t\t\t\t\t overflow:auto;display\"> <!-- Changed width 197 to 217 IN061885-->\n\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\n\t\t  </div>\t\n\t\t  \n\t\t\t\t<div id=\"Navigation\" class=\"divslideActive1\"\ttitle=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' style=\"top: 430px;height: 20px;\" onclick=\"slidPanelOnclick(this,\'Summary\',\'Desktop\',\'SummaryDtl\')\">\n\t\t\t\t<!--Navigation IN035912-->   <!-- Changed class divslideActive to divslideActive1 IN061885-->\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<!--IN035912-->\t\t\t\t \n\t\t\t  </div>\n\t\t\t  <div id=\"Desktop\" \n\t\t\t\t  style=\"position:absolute;\n\t\t\t\t\t\t width:222px;\n\t\t\t\t\t\t height:415px;\n\t\t\t\t\t\t top:60px;\n\t\t\t\t\t\t left:0px;\n\t\t\t\t\t\t background:#FFFFFF;\t\t\t\t\t\t \n\t\t\t\t\t\t overflow:auto;\"> <!-- Changed width 197 to 217 IN061885-->\n\t\t\t\t\t\t<!--IN057229 starts-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\t\t\t\t\t\t<!--IN057229 ends-->\t\t\t\t\n\t\t  </div>\t\t  \n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\n\t\t\t\t\n\t\t<div id=\"mainDIV\" >\t\t\n\t\t\t<div id=\"Summary\" class=\"divslideActive1\" style=\"top:20px;display:none\" >\t\t\t   \n\t\t\t<!--Summary IN035912--> <!-- Changed class divslideActive to divslideActive1 IN061885-->\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t<!-- IN035912-->  \n\t\t  </div>\t\t\n\t\t  <div id=\"SummaryDtl\" \n\t\t\t  style=\"position:absolute;\n\t\t\t\t\t width:222px;\n\t\t\t\t\t height:400px;           \n\t\t\t\t\t top:40px;\n\t\t\t\t\t left:0px;\n\t\t\t\t\t background:#FFFFFF;\n\t\t\t\t\t overflow:auto;display:none\"> \t\t <!-- Changed width 197 to 217 IN061885-->\n\t\t\t\n\t\t  </div>\t\n\t\t  \n\t\t\t\t<div id=\"Navigation\" class=\"divslideActive1\"\tstyle=\"top:430px\" >\n\t\t\t\t<!--Navigation IN035912-->  <!-- Changed class divslideActive to divslideActive1 IN061885-->\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<!--IN035912-->\t\t\t\t \n\t\t\t  </div>\n\t\t\t  <div id=\"Desktop\" \n\t\t\t\t  style=\"position:absolute;\n\t\t\t\t\t\t width:217px;\n\t\t\t\t\t\t height:444px;\n\t\t\t\t\t\t top:40px;\n\t\t\t\t\t\t left:0px;\n\t\t\t\t\t\t background:#FFFFFF;\n\t\t\t\t\t\t \n\t\t\t\t\t\t overflow:auto;\"> <!-- Changed width 197 to 217 IN061885-->\n\t\t\t\t\t\t <!--IN057229 starts-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t<!--IN057229 ends-->\n\t\t  </div>\t\t\n\t\t  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n\t<div id=\"persMenuFrm\" class=\"NavigIconsBorder\" style=\"position:absolute;\n\t\t\t\t\t\t width:217px;\n\t\t\t\t\t\t height:150px;\n\t\t\t\t\t\t top:525px;\n\t\t\t\t\t\t left:0px;\n\t\t\t\t\t\t background:#FFFFFF;\n\t\t\t\t\t\t overflow:auto;\n\t\t\t\t\t\tdisplay:none;\">\t\t <!-- Changed width 197 to 217 IN061885-->\t\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t</div>\n <FORM name=\'desktopParam\' id=\'desktopParam\'>\n <input type=hidden name=\"layoutValue\" id=\"layoutValue\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n <input type=hidden name=\"desktop_id\" id=\"desktop_id\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n </FORM>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           										created
21/11/2012		IN035912		Nijitha												CHL Hospital suggested that the
																					presentation of the Clinician desktop be changed and more appealing. Keeping the display of information more clear and visible.   								 
06/08/2013		IN036733		Nijitha												Bru-HIMS-CRF-328 	

28/08/2015		IN057229		Vijayakumar K		28/08/2015		Ramesh Goli		Regression-EM-Alpha-Unable to access 
																					CA functions in Desktop as well as in patient Chart.
05/08/2016		IN052053		Ramesh G											AAKH-CRF-0062																					
18/07/2017		IN061885		Raja S			18/07/2017		Ramesh G			ML-MMOH-CRF-0537
08/05/2018		IN066237	   Prakash C 		08/05/2018		Ramesh G			MMS-DM-CRF-0123
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String styleMap = "";
		
		//IN035912 Starts
		Connection			con			=	null;
		PreparedStatement	pstmt		=	null;
		ResultSet			rs			=	null;
		String summDesc	= "";
		String navigDesc = "";
		String specialty_id		= (String)session.getValue("specialty_id");
		String pract_id		= (String)session.getValue("ca_practitioner_id");
		String pract_type_id		= (String)session.getValue("practitioner_type");		
		String facility_id		= (String)session.getValue("facility_id");		//IN036733	
		String autoRefNumber ="600000"; //IN052053
		String selfnotesnumber ="";//IN066237
		boolean 	Self_Notes_flag = false;
		boolean 	outPatient_flag=false; //51215
		String login_user 			= (String) session.getValue( "login_user" ) ;//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]

		try
		{
			con	= ConnectionManager.getConnection();
			 	Self_Notes_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","SELF_NOTE_REFRESH");//IN066237
				outPatient_flag=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION_SDG");  //51215
			//pstmt	=	con.prepareStatement("SELECT ca_get_menu_navig(?,?,?,?) summ_navig FROM DUAL");  //IN036733 - commented
			pstmt	=	con.prepareStatement("SELECT ca_get_menu_navig(?,?,?,?,?) summ_navig FROM DUAL");  //IN036733
			pstmt.setString	(	1,	specialty_id);
			pstmt.setString	(	2,	""	);
			pstmt.setString	(	3,	pract_id );
			pstmt.setString	(	4,	pract_type_id);
			pstmt.setString	(	5,	facility_id);		//IN036733
			
			rs		=	pstmt.executeQuery();
			
			if (rs.next()){
			String str = (String)rs.getString("summ_navig");
			
			String[] temp_ = str.split("~");
			
			summDesc = temp_[0];
			navigDesc = temp_[1];
			}
			//IN052053 Start.
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();			
			//pstmt	=	con.prepareStatement("SELECT (SUM_MENU_AUTO_REF*60)*1000 AUTOREFNUM FROM CA_PARAM");
			pstmt	=	con.prepareStatement("SELECT (SUM_MENU_AUTO_REF*60)*1000 AUTOREFNUM,(SELF_NOTES_AUTO_REF*60)*1000 SELFNOTESNUM FROM CA_PARAM");//IN066237
			rs		=	pstmt.executeQuery();			
			if (rs.next()){
			autoRefNumber = (String)rs.getString("AUTOREFNUM");
			selfnotesnumber = (String)rs.getString("SELFNOTESNUM");//IN066237
			}
			//IN052053 End.
		}catch(Exception e) {
		e.printStackTrace();
		}
		finally{
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		//IN035912 Ends
		if(sStyle.equals("IeStyleBlue.css"))
		{
			styleMap = "Blue";
		}
		else if(sStyle.equals("IeStyleLime.css"))
		{
			styleMap = "Lime";
		}
		else if(sStyle.equals("IeStyleOrange.css"))
		{
			styleMap = "Orange";
		}
		else if(sStyle.equals("IeStyleVoilet.css"))
		{
			styleMap = "Violet";
		}
		else
		{
			styleMap = "";
		}
	
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	String layout_value=request.getParameter("layoutValue")==null? "" : request.getParameter("layoutValue");	
	String desktop_id = request.getParameter("deskTopID") == null ? "" : request.getParameter("deskTopID");	
	String dfltFunctionId = request.getParameter("dfltFunctionId") == null ? "" : request.getParameter("dfltFunctionId");	
	String menu_id = request.getParameter("menuId")==null?"MED_DFLT":request.getParameter("menuId");
	String screensize = request.getParameter("screensize")==null?"0":request.getParameter("screensize");//IN057229

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desktop_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(autoRefNumber ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Self_Notes_flag));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(selfnotesnumber));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(selfnotesnumber));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(selfnotesnumber));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(desktop_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(outPatient_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(desktop_id));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
	
if(!desktop_id.equals("") ){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(summDesc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(summDesc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            {java.lang.String __page ="../../eCA/jsp/CAMainHomePageTree.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("desktopID"), weblogic.utils.StringUtils.valueOf(desktop_id
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(navigDesc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(navigDesc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            {java.lang.String __page ="../../eCA/jsp/CAMainMenu.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("dfltFunctionId"), weblogic.utils.StringUtils.valueOf(dfltFunctionId
                        )},{ weblogic.utils.StringUtils.valueOf("menuId"), weblogic.utils.StringUtils.valueOf(menu_id
                        )},{ weblogic.utils.StringUtils.valueOf("screensize"), weblogic.utils.StringUtils.valueOf(screensize
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block34Bytes, _wl_block34);
 } if(desktop_id.equals("")) {
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(summDesc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(navigDesc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            {java.lang.String __page ="../../eCA/jsp/CAMainMenu.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("dfltFunctionId"), weblogic.utils.StringUtils.valueOf(dfltFunctionId
                        )},{ weblogic.utils.StringUtils.valueOf("menuId"), weblogic.utils.StringUtils.valueOf(menu_id
                        )},{ weblogic.utils.StringUtils.valueOf("screensize"), weblogic.utils.StringUtils.valueOf(screensize
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block38Bytes, _wl_block38);
 } 
            _bw.write(_wl_block39Bytes, _wl_block39);
            {java.lang.String __page ="../../eCommon/jsp/PersonalizeList.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("persFrom"), weblogic.utils.StringUtils.valueOf("HomeSummary")},{ weblogic.utils.StringUtils.valueOf("called_from"), weblogic.utils.StringUtils.valueOf("CA")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(layout_value));
            _bw.write(_wl_block41Bytes, _wl_block41);
 if(!desktop_id.equals("") ){ 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(desktop_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
 } 
            _bw.write(_wl_block43Bytes, _wl_block43);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.logout.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.logout.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.switchResponsibility.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.personalize.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
