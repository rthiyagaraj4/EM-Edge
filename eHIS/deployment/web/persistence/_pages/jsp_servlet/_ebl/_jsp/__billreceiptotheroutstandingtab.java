package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __billreceiptotheroutstandingtab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptOtherOutStandingTab.jsp", 1740492220774L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<title>Charge Patient</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/></link>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n\n <script>\n function callOnMouseOver(obj){\n\t\tcurrClass = obj.className ;\n\t\t\tobj.className = \'CASECONDSELECTHORZ\';\n\t}\n\n\tfunction callOnMouseOut(obj){\n\t\tobj.className = currClass;\n\t}\n\n\tfunction changeColor(obj,from_name)\n\t{\n\t\tif(from_name==\"OR_BUTTONS\")\n\t\t\tcellref = criteriaCategoryButtonFrame.document.getElementById(\'tab\').rows[0].cells\n\t\telse if(from_name==\"COMMON\")\n\t\t\tcellref = document.getElementById(\'tab\').rows[0].cells\n\t\tfor(i=0; i<cellref.length; i++)\n\t\t{\n\t\t\t//if(i!=2 && i!=3)\n\t\t\t cellref[i].className = \'CAFIRSTSELECTHORZ\'\n\t\t}\n\t\tobj.className = \"CASECONDSELECTHORZ\"\n\t\tcurrClass =\"CASECONDSELECTHORZ\";\n\t}\n\t\n\tfunction fnTotOutstUnBill(){\n\t\tchangeColor(this,\'COMMON\');\t\t\n\t\tvar queryString = $(\'#queryString\').val();\n\t\t//parent.document.getElementById(\'BL_mainFrame\').rows = parent.document.getElementById(\'allFramesOtherOut\').value;\n\t\tparent.document.getElementById(\'pline\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptTab\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'BillReceiptInfo\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSearch\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderDetails\').style.height=\'62vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSummary\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'messageFrame1\').style.height=\'6vh\';\n\t\t\n\t\t//parent.BillReceiptExisOrderSearch.location.href=\'BillReceiptExistingOrderSearch.jsp?\'+queryString;//patient_id=\'+patient_id+\'&episode_id=\'+episode_id+\'&visit_id=\'+visit_id+\'&encounter_date=\'+encounter_date+\'&encounter_id=\'+encounter_id+\'&episode_type=\'+episode_type;\n\t\tparent.BillReceiptExisOrderDetails.location.href=\'../../eBL/jsp/BillReceiptTotOutstUnBilled.jsp?\'+queryString;\n\t\tparent.BillReceiptExisOrderSummary.location.href=\'../../eCommon/html/blank.html\';\n\t\t//parent.BillReceiptWindow.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.messageFrame1.location.href=\'../../eCommon/jsp/error.jsp\';\t\t\n\t}\n\t\n\tfunction fnOutStBill(){\n\t\tchangeColor(this,\'COMMON\');\t\n\t\tvar queryString = $(\'#queryString\').val();\n\t//\tparent.document.getElementById(\'BL_mainFrame\').rows = parent.document.getElementById(\'allFramesOtherOut\').value;\n\tparent.document.getElementById(\'pline\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptTab\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'BillReceiptInfo\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSearch\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderDetails\').style.height=\'62vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSummary\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'messageFrame1\').style.height=\'6vh\';\n\t\t\n\t\t//parent.BillReceiptExisOrderSearch.location.href=\'BillReceiptUnbillServReq.jsp?\'+queryString;//patient_id=\'+patient_id+\'&episode_id=\'+episode_id+\'&visit_id=\'+visit_id+\'&encounter_date=\'+encounter_date+\'&encounter_id=\'+encounter_id+\'&episode_type=\'+episode_type;\n\t\tparent.BillReceiptExisOrderDetails.location.href=\'../../eBL/jsp/BillReceiptOutstBill.jsp?\'+queryString;\n\t\tparent.BillReceiptExisOrderSummary.location.href=\'../../eCommon/html/blank.html\';\n\t\t//parent.BillReceiptWindow.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.messageFrame1.location.href=\'../../eCommon/jsp/error.jsp\';\t\n\t}\n\t\n\tfunction fnUnBillEpis(){\n\t\tchangeColor(this,\'COMMON\');\t\n\t\tvar queryString = $(\'#queryString\').val();\n\t\t//parent.document.getElementById(\'BL_mainFrame\').rows = parent.document.getElementById(\'allFramesOtherOut\').value;\n\t\tparent.document.getElementById(\'pline\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptTab\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'BillReceiptInfo\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSearch\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderDetails\').style.height=\'62vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSummary\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'messageFrame1\').style.height=\'6vh\';\n\t\t\n\t\tparent.BillReceiptExisOrderDetails.location.href=\'../../eBL/jsp/BillReceiptUnbilledEpisode.jsp?\'+queryString;\n\t\tparent.BillReceiptExisOrderSummary.location.href=\'../../eCommon/html/blank.html\';\n\t\t//parent.BillReceiptWindow.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.messageFrame1.location.href=\'../../eCommon/jsp/error.jsp\';\t\n\t}\n\t\n\tfunction fnUnBillServReq(){\n\t\tchangeColor(this,\'COMMON\');\t\n\t\tvar queryString = $(\'#queryString\').val();\n\t//\tparent.document.getElementById(\'BL_mainFrame\').rows = parent.document.getElementById(\'allFramesOtherOut\').value;\n\t\n\t\tparent.document.getElementById(\'pline\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptTab\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'BillReceiptInfo\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSearch\').style.height=\'68vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderDetails\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSummary\').style.height=\'5vh\';\n\t\tparent.document.getElementById(\'messageFrame1\').style.height=\'6vh\';\n\t\t\n\t\t//parent.BillReceiptExisOrderSearch.location.href=\'BillReceiptUnbillServReq.jsp?\'+queryString;//patient_id=\'+patient_id+\'&episode_id=\'+episode_id+\'&visit_id=\'+visit_id+\'&encounter_date=\'+encounter_date+\'&encounter_id=\'+encounter_id+\'&episode_type=\'+episode_type;\n\t\tparent.BillReceiptExisOrderDetails.location.href=\'../../eBL/jsp/BillReceiptUnbillServReq.jsp?\'+queryString;\n\t\tparent.BillReceiptExisOrderSummary.location.href=\'../../eCommon/html/blank.html\';\n\t\t//parent.BillReceiptWindow.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.messageFrame1.location.href=\'../../eCommon/jsp/error.jsp\';\t\n\t}\n\n </script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!-- Selected stuff should be highlighted in black use:CASECONDSELECTHORZ-->\n<form name=\"ChargePatientEncounterTabsForm\" id=\"ChargePatientEncounterTabsForm\">\n\t<table id=\"tab\" cellspacing=0 cellpadding=\"3\" border=\"0\" width=\"40%\">\n\n\t<tr>\n\t\t\t<td id=\"totOutstUnBill\" \tclass=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"fnTotOutstUnBill();\" nowrap>\n\t\t\t<a style=\'color:white;cursor:pointer\' href=\"#\">Tot. Outst. Unbilled</a>\n\t\t\t</td>\n\t\t\t<td id=\"outStBill\" \tclass=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" style=\"display:\'none\'\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"fnOutStBill();\" nowrap>\n\t\t\t<a  style=\'color:white;cursor:pointer\' href=\"#\">Outstanding Bills</a>\n\t\t\t</td>\n\t\t\t<td id=\"unBillEpis\" \tclass=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" style=\"display:\'none\'\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"fnUnBillEpis();\" nowrap>\n\t\t\t<a  style=\'color:white;cursor:pointer\' href=\"#\">Unbilled Episode</a>\n\t\t\t</td>\n\t\t\t\n\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n</form>\n</body>\n</html> \n\n \n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block5Bytes, _wl_block5);
  
request.setCharacterEncoding("UTF-8");
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String existing_order_class="";
String new_order_class="";
String queryString = (String) request.getQueryString();
String selectedTab=(String)request.getParameter("selectedTab");
if(selectedTab == null) selectedTab="billCumReceipt";

if(selectedTab.equalsIgnoreCase("billCumReceipt")){
	existing_order_class="CASECONDSELECTHORZ";
	new_order_class="CAFIRSTSELECTHORZ";
}else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}
else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}
else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(existing_order_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(new_order_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(new_order_class));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(queryString ));
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
