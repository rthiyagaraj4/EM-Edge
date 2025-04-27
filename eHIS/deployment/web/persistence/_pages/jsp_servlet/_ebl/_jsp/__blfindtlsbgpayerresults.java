package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Iterator;
import eBL.BLFinDtlsBGPayerBean;
import java.util.LinkedHashMap;
import eBL.Common.BlRepository;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import java.sql.ResultSet;
import java.net.URLDecoder;
import java.util.*;
import com.ehis.util.*;

public final class __blfindtlsbgpayerresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFinDtlsBGPayerResults.jsp", 1737915965991L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<title>Insert title here</title>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eBL/js/BLFinDtlsBGPayerLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n$(document).ready(function(){\n\t\n\t$(\'.ancTag\').click(function(){\n\t\t//var indx = this.rownum;\n\t\tvar indx = $(this).data(\'rownum\');\n\t\tvar billingGroup = $(\'#blngHdn_\'+indx).val();\n\t\t//parent.window.returnValue = escape(billingGroup);\n\t\t//parent.window.close();\n\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\tdialogBody.contentWindow.returnValue = escape(billingGroup);\n    \n\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\tdialogTag.close();\n\t});\n\t\n\tvar selection = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\tif(selection == \'B\'){\n\t\tvar totalCnt = $(\'#totalCnt\').val();\n\t\tif(totalCnt == 1){\n\t\t\t$(\'.ancTag\').click();\n\t\t}\n\t}\n});\n</script>\n<style type=\"text/css\">\ndiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 125px; \t/* must be greater than tbody*/\n\t\toverflow: scroll;\n\t\tmargin: 0 auto;\n\t}\n\ntable {\n\twidth: 95%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120px;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\nTD.LABEL_LOCAL\n{\n  COLOR:#444444;\n  /*background-color:#FFFFFF;*/\n  background-color:#FFFFFF;\n  FONT-SIZE: 8pt;\n  TEXT-ALIGN: RIGHT;\n  /*TEXT-ALIGN: RIGHT;*/\n  PADDING-LEFT:7px;\n  PADDING-RIGHT:7px\n}\n</style>\n</head>\n<body>\n<form action=\"\">\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\t<table class=\'grid\' border=\'1\' width=\'95%\' cellpadding=\'3\' border=\'1\'  cellspacing=0 align=\"center\" id=\'tblResults\'>\n\t\t\t<div id=\'tableContainer\'> \n\t\t\t<thead>\n\t\t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'40%\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'COLUMNHEADER\' width=\'40%\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</thead>\n\t\t\t \t\n\t\t\t<tbody>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' nowrap>\n\t\t\t\t\t<a href=\'#\' class=\'ancTag\' data-rownum=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t\t<span id=\'blngGrp_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap>\n\t\t\t\t\t<span id=\'blngGrpCode_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap>\n\t\t\t\t\t<span id=\'blngGrpExpl_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span>\n\t\t\t\t</td>\n\t\t\t\t<input type=\'hidden\' name=\'blngHdn_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'blngHdn_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</tbody>\n\t\t\t\t</div>\n\t\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\n\t\t\t<table class=\'grid\' border=\'1\' width=\'95%\' cellpadding=\'3\'  cellspacing=0 align=\"center\" id=\'tblResults\'>\n\t\t\t\t<div id=\'tableContainer\'> \n\t\t\t\t<thead>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'20%\' class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'20%\' class=\'COLUMNHEADER\' nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t\t\t\t<tbody style=\"height: 20px;\">\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' nowrap>\n\t\t\t\t\t\t<a href=\'#\' class=\'ancResults\' data-rownum=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t\t\t\t\t<span id=\'billing_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t</span>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'billingCode_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'billingCode_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' nowrap>\n\t\t\t\t\t\t<span id=\'payerGroup_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t</span>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'payerGroupCode_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'payerGroupCode_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' nowrap>\n\t\t\t\t\t\t<span id=\'payer_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<span id=\'billing_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'payerCode_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'payerCode_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' nowrap>\n\t\t\t\t\t\t<span id=\'policy_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t</span>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'policyCode_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'policyCode_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' nowrap>\n\t\t\t\t\t\t<span id=\'priority_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n<input type=\'hidden\' name=\'payerHdnVal\' id=\"payerHdnVal\" value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=\'hidden\'  name=\'totalCnt\' id=\'totalCnt\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\n\n<input type=\'hidden\' name=\'blngGroupCode\' id=\"blngGroupCode\" value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n<input type=\'hidden\'  name=\'payerGroupCode\' id=\'payerGroupCode\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<input type=\'hidden\' name=\'payerCode\' id=\"payerCode\" value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=\'hidden\'  name=\'policyCode\' id=\'policyCode\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\"patient_id\" value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n<input type=\'hidden\'  name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\n<input type=\'hidden\'  name=\'ext_blng_grp\' id=\'ext_blng_grp\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n<input type=\'hidden\' name=\'function_id\' id=\"function_id\" value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n<input type=\'hidden\'  name=\'blnggrp\' id=\'blnggrp\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n<input type=\'hidden\'  name=\'ageVale\' id=\'ageVale\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'><!-- Added Against V210211 -->\n<input type=\'hidden\' name=\'encounter_date\' id=\"encounter_date\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n<input type=\'hidden\'  name=\'citizen_yn\' id=\'citizen_yn\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n</form>\n</body>\n\t</TBODY>\t\n\t\n\t</div>\n\n\n</html>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

private String decodeParam(String input){
	String output = "";
	if(input!=null){
		output = URLDecoder.decode(input);
	}
	return output;
}

private String checkForNull(String inputString) {
		if(inputString == null || "null".equals(inputString)){
			inputString = "";
		}
		return inputString;
}


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
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
 1           V210211            12033       AMS-CRF-00249            Ram kumar S
*/
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8"); 
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String selection = request.getParameter("selection");
String blngGroup = request.getParameter("blngGroup");
String payerCode = request.getParameter("payerCode");
String payer = request.getParameter("payer");
String policy = request.getParameter("policy");
String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");

String patient_id = request.getParameter("patient_id");
String episode_type = request.getParameter("episode_type");
String function_id = request.getParameter("function_id");
String blnggrp = request.getParameter("blnggrp");
String ageVale = request.getParameter("ageVal");//Added Against V210211
String encounter_date = request.getParameter("encounter_date");
String citizen_yn = request.getParameter("citizen_yn");
String ext_blng_grp = request.getParameter("ext_blng_grp");

String selectClause = "";
String whereClause = "";
String finalQuery = "";
String payerHdnVal = "";
String patientClass = "";

BLFinDtlsBGPayerBean bgPayerBean = null;

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rst = null;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(selection));
            _bw.write(_wl_block9Bytes, _wl_block9);

	int cnt = 0;
	try{
	con = ConnectionManager.getConnection(request);
	blngGroup = decodeParam(blngGroup);
	payerCode = decodeParam(payerCode);
	payer = decodeParam(payer);
	policy = decodeParam(policy);
	
	if("B".equals(selection)){
		patient_id = decodeParam(patient_id);
		episode_type = decodeParam(episode_type);
		function_id = decodeParam(function_id);
		blnggrp = decodeParam(blnggrp);
		encounter_date = decodeParam(encounter_date);
		citizen_yn = decodeParam(citizen_yn);
		ext_blng_grp = decodeParam(ext_blng_grp);
		ageVale=decodeParam(ageVale);//Added Against V210211
		if(ageVale == null) ageVale="";//Added Against V210211
		
		HashMap values = new HashMap();
		values.put("locale",locale);
		values.put("facility_id",facility_id);
		values.put("patient_id",patient_id);
		values.put("episode_type",episode_type);
		values.put("function_id",function_id);
		values.put("blnggrp",blnggrp);
		values.put("encounter_date",encounter_date);
		values.put("citizen_yn",citizen_yn);
		values.put("ext_blng_grp",ext_blng_grp);
		values.put("AgeValidation",ageVale);  //Added Against V210211
		selectClause = BlRepository.getBlKeyValue("SQL_BL_BLNG_GRP_LKUP",values,"BGLKUP_BG_PAYER");
								
		//whereClause = " AND   UPPER (short_desc) like UPPER('"+blngGroup+"%') ";
		whereClause = "";
		finalQuery = selectClause+whereClause;
		pstmt = con.prepareStatement(finalQuery);
		pstmt.setString(1,blngGroup+"%");
		rst = pstmt.executeQuery();
		if(rst!=null){
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			cnt=0;
			String hdnValue="";
			while(rst.next()){ 
				cnt++;
				hdnValue = "";
				hdnValue = 	checkForNull(rst.getString("blng_grp_id"))+"^~^"+
						checkForNull(rst.getString("srt_desc"))+"^~^"+
						checkForNull(rst.getString("dtl_desc"))+"^~^"+
						checkForNull(rst.getString("cap_ref_src_yn"))+"^~^"+
						checkForNull(rst.getString("ref_src_mn_mand_yn"))+"^~^"+
						checkForNull(rst.getString("ref_src_sb_mand_yn"))+"^~^"+
						checkForNull(rst.getString("currency_code"))+"^~^"+
						checkForNull(rst.getString("currency_desc"))+"^~^"+
						checkForNull(rst.getString("pr_payer_employer_id_mand_yn"))+"^~^"+
						checkForNull(rst.getString("package_yn"))+"^~^"+
						checkForNull(rst.getString("pkg_avail_yn"))+"^~^";
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rst.getString("srt_desc") ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rst.getString("blng_grp_id") ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rst.getString("dtl_desc") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(hdnValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
} 
            _bw.write(_wl_block23Bytes, _wl_block23);
}
	}
	else if("P".equals(selection)){
		int start = 0 ;
		int end = 0 ;
		int i=1;
		
		String from = checkForNull(request.getParameter("from"));
		String to = checkForNull(request.getParameter("to"));
		
		
		
		
		if ( from.length()== 0 )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		if ( to.length()==0)
		  	end = 20 ;
		else
			end = Integer.parseInt( to ) ;
		
		patient_id = decodeParam(patient_id);
		episode_type = decodeParam(episode_type);
		function_id = decodeParam(function_id);
		blnggrp = decodeParam(blnggrp);
		encounter_date = decodeParam(encounter_date);
		citizen_yn = decodeParam(citizen_yn);
		ext_blng_grp = decodeParam(ext_blng_grp);
		
		//Convert Episode Type to Patient Class
		if("O".equals(episode_type)){
			patientClass = "OP";
		}
		else if("I".equals(episode_type)){
			patientClass = "IP";
		}
		else if("D".equals(episode_type)){
			patientClass = "DC";		
		}
		else if("E".equals(episode_type)){
			patientClass = "EM";
		}
		else if("R".equals(episode_type)){
			patientClass = "XT";
		}
		BLFinDtlsBGPayerBean callingBean = new BLFinDtlsBGPayerBean();
		LinkedHashMap bgPayerMap = callingBean.getPayerDetails(facility_id, blngGroup, payer, payerCode, policy, patientClass, start, end);
		int totalRecords = 0;
		if(!bgPayerMap.isEmpty()){
			if(bgPayerMap.containsKey("totalRecords")){
				totalRecords =  (Integer) bgPayerMap.get("totalRecords");
				bgPayerMap.remove("totalRecords");
			}
		}
		/*selectClause = "select hdr.blng_grp_id, "+
		        "(select short_desc from BL_BLNG_GRP blng_grp where blng_grp_id = hdr.blng_grp_id) billing_desc, "+
		        "hdr.CUST_GROUP_CODE, "+ 
		        "decode(hdr.CUST_GROUP_CODE,'**','All Payer Group', "+
		            "(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, "+ 
		        "hdr.CUST_CODE, "+ 
		        "decode(hdr.CUST_CODE,'**','All Payer', "+
		            "(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, "+ 
		        "hdr.POLICY_TYPE_CODE, (select pol.long_desc policy_type from bl_ins_policy_types pol "+ 
		             "where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )  policy_type "+
				"from BL_PAYERS_PRIORITY_BY_BG hdr ";
		
		whereClause = "where hdr.operating_facility_id = ? ";
		if(!"".equals(blngGroup)){
			whereClause += " and hdr.blng_grp_id = '"+blngGroup+"' ";
		}
		if(!"".equals(payerCode)){
			whereClause += " and hdr.cust_group_code = '"+payerCode+"' ";		
		}
		if(!"".equals(payer)){
			whereClause += " and hdr.cust_code = '"+payer+"' ";
		}
		if(!"".equals(policy)){
			whereClause += " and hdr.policy_type_code = '"+policy+"' ";
		}
		
		finalQuery = selectClause+whereClause;
		pstmt = con.prepareStatement(finalQuery);
		pstmt.setString(1, facility_id);
		rst = pstmt.executeQuery();*/
		
		
		HashMap values = new HashMap();
		values.put("locale",locale);
		values.put("facility_id",facility_id);
		values.put("patient_id",patient_id);
		values.put("episode_type",episode_type);
		values.put("function_id",function_id);
		values.put("blnggrp",blnggrp);
		values.put("encounter_date",encounter_date);
		values.put("citizen_yn",citizen_yn);
		values.put("ext_blng_grp",ext_blng_grp);
		selectClause = BlRepository.getBlKeyValue("SQL_BL_BLNG_GRP_LKUP",values,"BGLKUP");
								
		whereClause = " AND   blng_grp_id ='"+blngGroup+"' ";
		
		finalQuery = selectClause+whereClause;
		pstmt = con.prepareStatement(finalQuery);
		rst = pstmt.executeQuery();
		if(rst !=null && rst.next()){
			payerHdnVal = 	checkForNull(rst.getString("blng_grp_id"))+"^~^"+
					checkForNull(rst.getString("srt_desc"))+"^~^"+
					checkForNull(rst.getString("dtl_desc"))+"^~^"+
					checkForNull(rst.getString("cap_ref_src_yn"))+"^~^"+
					checkForNull(rst.getString("ref_src_mn_mand_yn"))+"^~^"+
					checkForNull(rst.getString("ref_src_sb_mand_yn"))+"^~^"+
					checkForNull(rst.getString("currency_code"))+"^~^"+
					checkForNull(rst.getString("currency_desc"))+"^~^"+
					checkForNull(rst.getString("pr_payer_employer_id_mand_yn"))+"^~^"+
					checkForNull(rst.getString("package_yn"))+"^~^"+
					checkForNull(rst.getString("pkg_avail_yn"))+"^~^";
		}
		//
		if(!bgPayerMap.isEmpty()){
			
			
			if ( !(start <= 1) )
				out.println("<a href='javascript:movePrevthis("+start+","+end+")'   text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if(totalRecords > end)
				out.println("<a id='nextvalue' href='javascript:moveNextthis("+start+","+end+")'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

				cnt=0;
				for (Iterator iterator = bgPayerMap.keySet().iterator(); iterator.hasNext();) {
					Integer keyValue = (Integer) iterator.next();
					bgPayerBean = (BLFinDtlsBGPayerBean) bgPayerMap.get(keyValue);
					cnt++;
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(checkForNull(bgPayerBean.getBlngGrpDesc()) ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkForNull(bgPayerBean.getBlngGrpCode()) ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checkForNull(bgPayerBean.getCustGrpDesc()) ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkForNull(bgPayerBean.getCustGrpCode()) ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checkForNull(bgPayerBean.getCustDesc()) ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkForNull(bgPayerBean.getCustCode()) ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checkForNull(bgPayerBean.getPolicyDesc()) ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkForNull(bgPayerBean.getPolicyCode()) ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(cnt ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checkForNull(bgPayerBean.getPriority()) ));
            _bw.write(_wl_block44Bytes, _wl_block44);
} 
            _bw.write(_wl_block45Bytes, _wl_block45);
}
	}
	
}
catch(Exception e){
	System.err.println("Exception in getting BLFinDtlsBGPayerResults -> "+e);
}
finally{
	ConnectionManager.returnConnection(con);
}



            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(payerHdnVal));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(blngGroup));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(payerCode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(policy));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ext_blng_grp));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(blnggrp));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ageVale));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(encounter_date));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(citizen_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
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
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EXPLANATORY_NOTE.label", java.lang.String .class,"key"));
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
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingGroup.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
