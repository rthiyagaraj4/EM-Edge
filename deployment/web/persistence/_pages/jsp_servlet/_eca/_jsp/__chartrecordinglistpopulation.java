package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.math.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordinglistpopulation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingListPopulation.jsp", 1724674340306L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<head>\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\tparent.ChartRecordingCriteriaFrame.document.forms[0].start.value= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"\n\tparent.ChartRecordingCriteriaFrame.document.forms[0].end.value= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].maxRecord.value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"\n\t\t\t\tparent.ChartRecordingCriteriaFrame.document.forms[0].flagStringValue.value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<html>\n\t\t<head>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' type=\'text/css\' />\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t<style>\n\t\t\tA:link\n\t\t\t{\n\t\t\t\tCOLOR: #FFFFFF;\n\t\t\t\tFONT-SIZE: 7PT;\n\t\t\t\tfont-family: Verdana;\n\t\t\t\tfont-weight:normal;\n\t\t\t\ttext-align:left;\n\t\t\t}\n\t\t\tA:visited\n\t\t\t{\n\t\t\t\tCOLOR: #FFFFFF;\n\t\t\t\tFONT-SIZE: 7PT;\n\t\t\t\tfont-family: Verdana;\n\t\t\t\tfont-weight:normal;\n\t\t\t\ttext-align:left;\n\t\t\t}\n\t\t\t\n\t\t\tTD.CACHARTQRYEVEN {\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t}\n\n\t\t\tTD.CACHARTFOURTHLEVELCOLOR \n\t\t\t{\n\t\t\t\tBACKGROUND-COLOR: #A6C2C8 ;\n\t\t\t\tCOLOR:WHITE;\n\t\t\t\tBORDER-STYLE: SOLID;\n\t\t\t\tBORDER-COLOR:\t#A6C2C8;\n\t\t\t\tBORDER-RIGHT-COLOR: #A6C2C8;\n\t\t\t\tBORDER-TOP-COLOR: #A6C2C8;\n\t\t\t\tBORDER-BOTTOM-COLOR: #A6C2C8;\n\t\t\t\tFONT-WEIGHT: BOLD ;\n\t\t\t}\n\n\t\t\tTD.CRITICAL{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#D2B48C;\n\t\t\t}\n\n\t\t\tTD.ABNORMAL{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#FFF8DC;\n\t\t\t}\n\t\t\tTD.HIGH{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#FFDAB9\n\t\t\t}\n\t\t\tTD.LOW{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#F0FFFF;\n\t\t\t}\n\t\t\tTD.CRITICALLOW{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#D8BFD8;\n\t\t\t}\n\t\t\tTD.CRITICALHIGH{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#F4A460;\n\t\t\t}\n\t\t\tTD.DELTAFAIL{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#FFE4E1;\n\t\t\t}\n\t\t</style>\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\'scrollListFrame()\'>\n\t\t<form name =\"ChartLayoutListForm\">\n\n\t\t<table id=\'titleTable\' width=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' class=\'grid\'>\n\t\t<tr id=\'divTitleTable\'>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<script>\n\t\tvar rowValue = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"\n\t\tvar thRowId = eval(document.getElementById(\"rowId\"+rowValue));\n\t\tthRowId.colSpan += 1\n\t</script>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</tr>\n\n\t<INPUT TYPE=\"hidden\" name=\"idCount\" id=\"idCount\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<INPUT TYPE=\"hidden\" name=\"summaryYN\" id=\"summaryYN\" value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t<INPUT TYPE=\"hidden\" name=\"detailYN\" id=\"detailYN\" value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t<INPUT TYPE=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t<INPUT TYPE=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t<INPUT TYPE=\"hidden\" name=\"defaultYN\" id=\"defaultYN\" value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t<INPUT TYPE=\"hidden\" name=\"patientId\" id=\"patientId\" value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</table>\t\n\t\t\t<input type=\'hidden\' name=\'fromDate\' id=\'fromDate\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t<input type=\'hidden\' name=\'function_from\' id=\'function_from\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\'hidden\' name=\'detailDate\' id=\'detailDate\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<input type=\'hidden\' name=\'errorAuth\' id=\'errorAuth\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<input type=\'hidden\' name=\'flagValue\' id=\'flagValue\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t<input type=\'hidden\' name=\'sort_by\' id=\'sort_by\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t<input type=\'hidden\' name=\'flagString\' id=\'flagString\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t<input type=\'hidden\' name=\'adm_date\' id=\'adm_date\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t<input type=\'hidden\' name=\'noOfDays\' id=\'noOfDays\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t<input type=\'hidden\' name=\'daySummary\' id=\'daySummary\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t<input type=\'hidden\' name=\'chartId\' id=\'chartId\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t<input type=\'hidden\' name=\'toDate\' id=\'toDate\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\'hidden\' name=\'datesForArray\' id=\'datesForArray\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t<input type=\'hidden\' name=\'tempDatesForArray\' id=\'tempDatesForArray\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t<input type=\'hidden\' name=\'datesForPrevNext\' id=\'datesForPrevNext\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t<input type=\'hidden\' name=\'numOfDates\' id=\'numOfDates\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t<input type=\'hidden\' name=\'allDatesForGraph\' id=\'allDatesForGraph\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t<input type=\'hidden\' name=\'numOfPages\' id=\'numOfPages\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=\'hidden\' name=\'tempCountOfRecs\' id=\'tempCountOfRecs\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t<input type=\'hidden\' name=\'prevFirstDate\' id=\'prevFirstDate\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t<input type=\'hidden\' name=\'qs\' id=\'qs\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t<input type=\'hidden\' name=\'pageNo\' id=\'pageNo\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t<input type=\'hidden\' name=\'modifyYN\' id=\'modifyYN\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t</form>\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\'  style=\'position:absolute; width:35%; visibility:hidden;\' bgcolor=\'yellow\'>\n\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' class=\'gridTooltipData\' id=\'t\' nowrap></td>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t</div>\n\t\t<script>\n\t\n\t\tif(parent.ChartRecordingDetailFrame != null)\n\t\t{\n\t\t\tif(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' == \'MC\')\n\t\t\t{\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' == \'Y\')\n\t\t\t\t{\n\t\t\t\t\tparent.AEID.cols = \'50%,*\';\n\t\t\t\t\tparent.colBarID.cols = \'50%,*\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.AEID.cols = \'40%,*\';\n\t\t\t\t\tparent.colBarID.cols = \'40%,*\';\n\t\t\t\t}\n\t\t\t}\n\t\t\tparent.ChartRecordingDetailFrame.document.body.scroll=\"yes\";\n\t\t\tparent.ChartRecordingDetailFrame.document.body.onscroll= \"\";\n\t\t\tparent.ChartRecordingDetailFrame.document.forms[0].innerHTML = parent.ChartRecordingDetailFrame.document.forms[0].innerHTML + \"<div id=\'extraTD\' style=\'position:absolute; width:30%; visibility:hidden;\'></div>\";\n\t\t}\n\t\t</script>\n \t\t<script>\n\t\t\talignHeight();\n\t\t\talignUnitsAndData();\n\t\t</script>\n\t</body>\n\t</html>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History     Name      Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
15/04/2014	IN047647	Chowminya								Thai Login screen, Page of chart details disappear and unable to click in next page button
22/02/2016	IN057209	Ramesh G								Intake And Output Chart Shift Total
07/03/2016	IN059461	Ramesh G								This issue happens when chart recorded exactly on shift timings.

31/10/2016	IN065535	Ramesh G								ML-MMOH-SCF-0848		
19/04/2018	IN067307	Raja S		19/04/2018		Raja S			ML-MMOH-SCF-0976
21/09/2018  IN067534	sivabagyam M 21/09/2018		Ramesh G		ML-MMOH-CRF-1107
21/01/2019  IN067541    Sivabagyam M  21/01/2019    Ramesh G        ML-MMOH-CRF-1159
24/01/2019  IN069575    Sivabagyam M  24/01/2019    Ramesh G        CA-Common-Record Charts
24/11/2020	8186		Ramesh Goli		21/11/2020	Ramesh G		SKR-SCF-8186
29/01/2020	6777		Nijitha S	  29/01/2020	Nijitha S		SKR-SCF-1458
07/05/2022	30869		Ramesh Goli									KAUH-SCF-0359 
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
Connection con = null;
try
{
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	con = ConnectionManager.getConnection(request);
	ArrayList tempPrevDate = new ArrayList();
	ArrayList tempArrayNext = new ArrayList();
	PreparedStatement pstmt = null;

	String encounterId		=	request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
	String module_id		=	request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String prevNextTen		=	request.getParameter("prevNextTen")==null?"":request.getParameter("prevNextTen");

	String tempCountOfRecs	=	request.getParameter("tempCountOfRecs")==null?"1":request.getParameter("tempCountOfRecs");
	String datesForPrevNextVal =request.getParameter("datesForPrevNext")==null?"":request.getParameter("datesForPrevNext");
	String datesForArray = "";
	String prevFirstDate = request.getParameter("prevFirstDate")==null?"" :request.getParameter("prevFirstDate");

	if(encounterId.equals("")) encounterId = "0";

	String function_from = request.getParameter("function_from")==null?"":request.getParameter("function_from");
	String modifyYN= request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");

	ResultSet rs = null;
	HashMap dataHash = new HashMap(); 
	HashMap finalHash = new HashMap();
	ArrayList arrayNext = (ArrayList)session.getValue("arrayNext"+encounterId) == null ? new ArrayList() : (ArrayList)session.getValue("arrayNext"+encounterId);
	ArrayList arrayResultType = new ArrayList();
	ArrayList resultTypeArr = new ArrayList(); //IN057209
	ArrayList tempDateArray = (ArrayList)session.getValue("tempDateArray"+encounterId) == null ? new ArrayList() : (ArrayList)session.getValue("tempDateArray"+encounterId);

	String prevDate="";
	String tempDate="";
	ArrayList arraytempDate = null;
	ArrayList ValArray = null;
	ArrayList dateArray = new ArrayList();

	String detailDate	=  request.getParameter("detailDate")==null?"":request.getParameter("detailDate");
	String errorAuth	=  request.getParameter("errorAuth")==null?"":request.getParameter("errorAuth");
	String flagValue	= request.getParameter("flagValue")==null?"":request.getParameter("flagValue");
	String sort_by		= request.getParameter("sort_by")==null?"D":request.getParameter("sort_by");
	String flagString	= request.getParameter("flagString")==null?"":request.getParameter("flagString");

	String contr_mod_accession_num	= request.getParameter("contr_mod_accession_num")==null?"":request.getParameter("contr_mod_accession_num");
	String adm_date		= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");

	int daySummary = 0;
	int noOfDays =  request.getParameter("noOfDays")==null?0:Integer.parseInt(request.getParameter("noOfDays"));
	int pageNo = request.getParameter("pageNo")==null?1:Integer.parseInt(request.getParameter("pageNo"));

	if(function_from.equals("SECONDARY_TRIAGE"))
	daySummary = 1;
	
	String result_uom = "";

	int start =0;
	int end =0;
	int maxRecord = 0;
	int numOfPages = 0;

	String summaryYN = request.getParameter("summaryYN")==null?"":request.getParameter("summaryYN");
	String detailYN = request.getParameter("detailYN")==null?"Y":request.getParameter("detailYN");
	String from = request.getParameter("start")==null ?"0" : request.getParameter("start");
	String to = request.getParameter("end")==null ? ""+daySummary+"" : request.getParameter("end");
    System.out.println(from+" --   "+to);
	//converstion is done IN047647
	if(!"0".equals(from) && !"".equals(from))
	from =	com.ehis.util.DateUtils.convertDate(from,"DMYHM", locale,"en");
	if(!"1".equals(to) && !"".equals(to))
	to	=	com.ehis.util.DateUtils.convertDate(to,"DMYHM", locale,"en");
	
	if(!function_from.equals("SECONDARY_TRIAGE"))
	{

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(from));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(to));
            _bw.write(_wl_block8Bytes, _wl_block8);

	}	
	if(summaryYN.equals("N") && detailYN.equals("N"))
	{
		out.println("<script>");	
		out.println("parent.ChartRecordingListFrame.location.href='../../eCommon/html/blank.html'</script>");
	}
	else
	{
		StringTokenizer tokenDate = null;
		String facilityId = (String)session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");
		String SummaryYN = "";
		String patientId = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String chartId = request.getParameter("chartId")==null?"":request.getParameter("chartId");
		String fromDate = request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String tempString = "";
		String toDate = request.getParameter("toDate")==null?"":request.getParameter("toDate");
		String defaultYN = request.getParameter("DEFINE_MODIFIABLE_AT_TRN_YN")==null?"":request.getParameter("DEFINE_MODIFIABLE_AT_TRN_YN");

		String date = "";	
		StringBuffer sqlDates = new StringBuffer();
		String legend_type = "";
		String remarks = "";
		String remStrDisplay = "";
		
		fromDate =	com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM", locale,"en");
		toDate	=	com.ehis.util.DateUtils.convertDate(toDate,"DMYHM", locale,"en");
		try
		{
			int count = 0;
			sqlDates.append(" select SUMMARY_REQ_YN  from ca_chart where chart_id = ? and eff_status='E' ");
			pstmt = con.prepareStatement(sqlDates.toString());
			pstmt.setString(1,chartId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				SummaryYN = rs.getString(1)==null ? "N" :rs.getString(1) ;
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(SummaryYN.equals("N"))
			{
				if(!function_from.equals("SECONDARY_TRIAGE"))
				{
					
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.getElementById(\"labelSummary\").style.display='none';</script>");
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.summaryYN.style.display='none'</script>");
				}
			}
			else
			{
				if(!function_from.equals("SECONDARY_TRIAGE"))
				{
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.getElementById(\"labelSummary\").style.display='inline'</script>");
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.summaryYN.style.display='inline'</script>");
				}
			}
			sqlDates = new StringBuffer();
			if(defaultYN.equals("Y"))
			{
				tempString = " CA_ENCNTR_CHART_DRAFT B ";
			}
			else
			{
				tempString = "  CA_CHART_SECTION_COMP B ";
			}
			if(detailYN.equals("Y"))
			{
				//IN057209 Start.
				//sqlDates.append("SELECT  distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,'N' DISCR_MSR_RESULT_TYPE,a.discr_msr_result_type result_type  from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");
				sqlDates.append("SELECT  distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,decode(discr_msr_result_type,'S',4,'S1',3,'S2',2,'S3',1,0) RANK,'N' DISCR_MSR_RESULT_TYPE, decode(a.discr_msr_result_type,'S','S','S1','S1','S2','S2','S3','S3','N') result_type  from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");
				//IN057209 End.
				if(defaultYN.equals("Y"))
				{
					if(!module_id.equals("MC"))
					{
						sqlDates.append("AND B.FACILITY_ID = A.FACILITY_ID ");
					}
					sqlDates.append("AND B.ENCOUNTER_ID = A.ENCOUNTER_ID  ");//6777 //removed commentted for 30869
				}

				sqlDates.append("and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.discr_msr_id ");
				
				if(!module_id.equals("MC"))
				{
					sqlDates.append("and   a.facility_id=? ");
				}
			
				sqlDates.append(" and a.patient_id=?  and A.ENCOUNTER_ID = ? and a.DISCR_MSR_RESULT_TYPE in('C','D','E','N','A','I','L','F','H','T') ");//6777 Added Encounter Id
				
				if(fromDate.equals("") && toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi') +0.00068287 ");
				}
				else
				{
					if(!fromDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");	
					}
					if(!toDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
					}
				}
				if(!(contr_mod_accession_num.equals("") && module_id.equals("")))
				{
					sqlDates.append(" and CONTR_MODULE_TRANS_REF=?");
				}
			}
	
			if(detailYN.equals("Y") && summaryYN.equals("Y"))
				{
				sqlDates.append(" UNION ALL");
				
				}
			if(summaryYN.equals("Y"))
			{
				//IN057209 Start.
				//sqlDates.append(" SELECT distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,a.DISCR_MSR_RESULT_TYPE,a.discr_msr_result_type result_type from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");
				sqlDates.append(" SELECT distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,decode(discr_msr_result_type,'S',4,'S1',3,'S2',2,'S3',1,0) RANK,a.DISCR_MSR_RESULT_TYPE,decode(a.discr_msr_result_type,'S','S','S1','S1','S2','S2','S3','S3','N') result_type from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");
				//IN057209 End.
				if(defaultYN.equals("Y"))
				{
					if(!module_id.equals("MC"))
						sqlDates.append("AND B.FACILITY_ID = A.FACILITY_ID ");
					sqlDates.append(" AND B.ENCOUNTER_ID = A.ENCOUNTER_ID  ");//6777 //removed commentted for 30869
					
				}
				sqlDates.append("and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.SUMMRY_COLUMN ");
				
				if(!module_id.equals("MC"))
					{
					sqlDates.append(" and a.facility_id=? ");
					
					}
				sqlDates.append(" and a.patient_id=? and A.ENCOUNTER_ID = ? and a.DISCR_MSR_RESULT_TYPE  IN ('S','S1','S2','S3')   ");//6777 Added Encounter Id
				
				if(fromDate.equals("") && toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");	
					
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
					sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi') +0.00068287");
					
				}
				else
				{
					if(!fromDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");
						
					}
					if(!toDate.equals(""))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
						
					}
				}
				if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
				{
					sqlDates.append(" and CONTR_MODULE_TRANS_REF=?");
					
				}
			}
			if(sort_by.equals("D"))
			{
				//IN057209 Start.
				//sqlDates.append(" order by 2 Desc");
				sqlDates.append(" order by 2 Desc, 3 ASC");				
				//IN057209 End.
			}
			else
			{
				//sqlDates.append(" order by 2");//IN069575 
				sqlDates.append(" order by 2 asc,3 desc");//IN069575 
				
			}
			
			if(function_from.equals("CP"))
			{	
				PreparedStatement psSelect = con.prepareStatement("select to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') from pr_encounter where facility_id = ? and encounter_id = ? ");
				
				
				psSelect.setString(1,facilityId);				
				psSelect.setString(2,encounterId);
				
				ResultSet rsSelect = 	psSelect.executeQuery();
				if(rsSelect.next())
				{
					adm_date = rsSelect.getString(1)== null ? "" :  rsSelect.getString(1);
				}
				if(rsSelect != null)rsSelect.close();
				if(psSelect != null)psSelect.close();
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			
			pstmt =	con.prepareStatement(sqlDates.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);  
			
			if(detailYN.equals("Y"))
			{
				pstmt.setString(++count,chartId);		
				
				if(!module_id.equals("MC"))
				{
					pstmt.setString(++count,facilityId);
				}
				pstmt.setString(++count,patientId);			
				pstmt.setString(++count,encounterId);//6777	
				if(fromDate.equals("") && toDate.equals(""))
				{
					pstmt.setString(++count,adm_date);					
				}
				if(!fromDate.equals("") && !toDate.equals("")) 
				{
					pstmt.setString(++count,fromDate);
					pstmt.setString(++count,toDate);					
				}
				else
				{	
					if(!fromDate.equals(""))
					{
						 pstmt.setString(++count,fromDate);
					}
					 if(!toDate.equals(""))
					{
						pstmt.setString(++count,adm_date);
						pstmt.setString(++count,toDate);
					}
				}
				if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
				{
					pstmt.setString(++count,contr_mod_accession_num);
				}
			}
			
			if(summaryYN.equals("Y"))
			{
				pstmt.setString(++count,chartId);	
				if(!module_id.equals("MC")){
					pstmt.setString(++count,facilityId);					
				}			
				pstmt.setString(++count,patientId);	
				pstmt.setString(++count,encounterId);//6777	
			
				if(fromDate.equals("") && toDate.equals(""))
				{
					pstmt.setString(++count,adm_date);
				}
				if(!fromDate.equals("") && !toDate.equals("")) 
				{
					pstmt.setString(++count,fromDate);
					pstmt.setString(++count,toDate);
				}
				else
				{	
					if(!fromDate.equals(""))
					{
						pstmt.setString(++count,fromDate);
					}
					if(!toDate.equals(""))
					{
						pstmt.setString(++count,adm_date);
						pstmt.setString(++count,toDate);						
					}
				}
				if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
				{
					pstmt.setString(++count,contr_mod_accession_num);
					
				}
			}
	
			rs = pstmt.executeQuery();	
			maxRecord = 0;
			while(rs.next())
			{
				maxRecord++;
				start = 1 ;
				end = daySummary;
				int tempCount=0;
				int tempCountFirst = 0;
				tempDateArray = new ArrayList();
						
				date = rs.getString(1)==null?"":rs.getString(1);
				tokenDate = new StringTokenizer(date," ");
				tempDate = tokenDate.nextToken();
				tempCount ++;
				if(tempDate.equals(prevDate))
				{
					//arrayResultType.add(rs.getString(3));
					arrayResultType.add(rs.getString(4));
					resultTypeArr.add(rs.getString(5));
					if(dateArray.size() < 10)
					{
						dateArray.add(date);
					}
					if(tempCountFirst == 10)
					{
						datesForArray = date;
					}
					tempDateArray.add(date);
					tempCountFirst++;
				}
				else
				{
					if(daySummary !=0)
					{
						if(start > end && ! tempDate.equals(prevDate)) break;
					}
					//arrayResultType.add(rs.getString(3));
					arrayResultType.add(rs.getString(4));
					resultTypeArr.add(rs.getString(5));
					if(dateArray.size() < 10)
					{
						dateArray.add(date);
					}
					if(tempCountFirst == 10)
					{
						datesForArray = date;
					}
					prevDate=tempDate;  	
					tempDateArray.add(date);
					start++;
					tempCountFirst++;
				}
			}
		
			if(daySummary==10000)
			{
				daySummary = maxRecord;
			}
		
			String Normal_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels");
			String Critical_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
			count = 0;
			StringBuffer sql = new StringBuffer();
		
			if(detailYN.equals("Y"))
			{
				//IN057209 Start.
				//sql.append("select  b.PANEL_DISP_ORDER_SEQ,b.DISCR_DISP_ORDER_SEQ,a.TEST_OBSERV_DT_TM ,a.DISCR_MSR_PANEL_OR_FORM_ID CHART_GROUP_ID, a.DISCR_MSR_ID, a.NORM_ABNORM_IND , to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi') dt   , a.DISCR_MSR_RESULT_TYPE, a.DISCR_MSR_RESULT_NUM , a.DISCR_MSR_RESULT_NUM_UOM ,a.DISCR_MSR_RESULT_STR, a.RESULT_NUM_PREFIX, a.TEST_OBSERV_DT_TM, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,HIGH_COLOR_CODE,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,ABN_COLOR_CODE,CRIT_HIGH_STR,CRIT_HIGH_COLOR_CODE,CRIT_LOW_STR  ,CRIT_LOW_COLOR_CODE,'') FROM CR_CLIN_EVENT_PARAM) normal_range_color,to_char(NORMAL_LOW) NORMAL_LOW ,to_char(NORMAL_HIGH) NORMAL_HIGH , to_char(CRITICAL_LOW) CRITICAL_LOW ,to_char(CRITICAL_HIGH) CRITICAL_HIGH,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMING_PRACT_ID,?,1) added_by_name, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, (select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE, a.REMARKS from CA_ENCNTR_DISCR_MSR a, "+tempString+"  where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.discr_msr_id and a.patient_id=?   ");
				sql.append("select  b.PANEL_DISP_ORDER_SEQ,b.DISCR_DISP_ORDER_SEQ,a.TEST_OBSERV_DT_TM ,decode(discr_msr_result_type,'S',4,'S1',3,'S2',2,'S3',1,0) RANK,a.DISCR_MSR_PANEL_OR_FORM_ID CHART_GROUP_ID, a.DISCR_MSR_ID, a.NORM_ABNORM_IND , to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi') dt   , a.DISCR_MSR_RESULT_TYPE, a.DISCR_MSR_RESULT_NUM , a.DISCR_MSR_RESULT_NUM_UOM ,a.DISCR_MSR_RESULT_STR, a.RESULT_NUM_PREFIX, a.TEST_OBSERV_DT_TM, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,HIGH_COLOR_CODE,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,ABN_COLOR_CODE,CRIT_HIGH_STR,CRIT_HIGH_COLOR_CODE,CRIT_LOW_STR  ,CRIT_LOW_COLOR_CODE,'') FROM CR_CLIN_EVENT_PARAM) normal_range_color,to_char(NORMAL_LOW) NORMAL_LOW ,to_char(NORMAL_HIGH) NORMAL_HIGH , to_char(CRITICAL_LOW) CRITICAL_LOW ,to_char(CRITICAL_HIGH) CRITICAL_HIGH,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMING_PRACT_ID,?,1) added_by_name, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, (select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE, a.REMARKS, decode(a.discr_msr_result_type,'S','S','S1','S1','S2','S2','S3','S3','N') result_type from CA_ENCNTR_DISCR_MSR a, "+tempString+"  where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.discr_msr_id and a.patient_id=?   ");
				//IN057209 End.
				if(!module_id.equals("MC"))
					{
					sql.append(" AND   a.facility_id=? ");
					
					}
			
				if(defaultYN.equals("Y"))
				{
					sql.append(" and   b.ENCOUNTER_ID = ?  ");
					
					if(!module_id.equals("MC"))
						{
						
						sql.append(" AND   b.FACILITY_ID = ?  ");
						}
				}
			
				if(fromDate.equals("") && toDate.equals(""))
				{
					sql.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");
					
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
					sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi') +0.00068287 ");
					
				}
				else
				{
					if(!fromDate.equals(""))
							{
						sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");
						
							}
					if(!toDate.equals(""))
						{
						sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
						
						}
				}
				sql.append(" and a.DISCR_MSR_RESULT_TYPE in ('C','D','E','N','A','I','L','F','H','T') ");
				if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
				{
					sql.append(" and CONTR_MODULE_TRANS_REF=?");
					
				}
			}
			if(detailYN.equals("Y") && summaryYN.equals("Y"))
			{
				sql .append(" Union all ");
				
			}
			if(summaryYN.equals("Y"))
			{
				//IN057209 Start.
				//sql.append(" select b.PANEL_DISP_ORDER_SEQ,b.DISCR_DISP_ORDER_SEQ,a.TEST_OBSERV_DT_TM ,a.DISCR_MSR_PANEL_OR_FORM_ID CHART_GROUP_ID, B.DISCR_MSR_ID DISCR_MSR_ID, a.NORM_ABNORM_IND , to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi') dt   , a.DISCR_MSR_RESULT_TYPE, a.DISCR_MSR_RESULT_NUM , a.DISCR_MSR_RESULT_NUM_UOM , a.RESULT_NUM_PREFIX, decode(SUMMARY_TYPE,'AVERAGE','AVG',substr(SUMMARY_TYPE,1,3)) DISCR_MSR_RESULT_STR, a.TEST_OBSERV_DT_TM, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,HIGH_COLOR_CODE,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,ABN_COLOR_CODE,CRIT_HIGH_STR,CRIT_HIGH_COLOR_CODE,CRIT_LOW_STR  ,CRIT_LOW_COLOR_CODE,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_color,to_char(NORMAL_LOW) NORMAL_LOW ,to_char(NORMAL_HIGH) NORMAL_HIGH ,to_char(CRITICAL_LOW) CRITICAL_LOW ,to_char(CRITICAL_HIGH) CRITICAL_HIGH, am_get_desc.AM_PRACTITIONER(a.ADDED_BY_ID,?,1) added_by_name, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR  ,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, (select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE, a.REMARKS from CA_ENCNTR_DISCR_MSR a, "+tempString+"  where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.SUMMRY_COLUMN and   a.patient_id=?   ");
				sql.append(" select b.PANEL_DISP_ORDER_SEQ,b.DISCR_DISP_ORDER_SEQ,a.TEST_OBSERV_DT_TM ,decode(discr_msr_result_type,'S',4,'S1',3,'S2',2,'S3',1,0) RANK,a.DISCR_MSR_PANEL_OR_FORM_ID CHART_GROUP_ID, B.DISCR_MSR_ID DISCR_MSR_ID, a.NORM_ABNORM_IND , to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi') dt   , a.DISCR_MSR_RESULT_TYPE, a.DISCR_MSR_RESULT_NUM , a.DISCR_MSR_RESULT_NUM_UOM , a.RESULT_NUM_PREFIX, decode(SUMMARY_TYPE,'AVERAGE','AVG',substr(SUMMARY_TYPE,1,3)) DISCR_MSR_RESULT_STR, a.TEST_OBSERV_DT_TM, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,HIGH_COLOR_CODE,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,ABN_COLOR_CODE,CRIT_HIGH_STR,CRIT_HIGH_COLOR_CODE,CRIT_LOW_STR  ,CRIT_LOW_COLOR_CODE,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_color,to_char(NORMAL_LOW) NORMAL_LOW ,to_char(NORMAL_HIGH) NORMAL_HIGH ,to_char(CRITICAL_LOW) CRITICAL_LOW ,to_char(CRITICAL_HIGH) CRITICAL_HIGH, am_get_desc.AM_PRACTITIONER(a.ADDED_BY_ID,?,1) added_by_name, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR  ,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, (select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE, a.REMARKS,decode(a.discr_msr_result_type,'S','S','S1','S1','S2','S2','S3','S3','N') result_type from CA_ENCNTR_DISCR_MSR a, "+tempString+"  where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.SUMMRY_COLUMN and   a.patient_id=?   ");
				//IN057209 End.
				if(!module_id.equals("MC"))
					{
					sql.append(" AND   a.facility_id=? ");
					
					}

				if(defaultYN.equals("Y"))
				{
					sql.append(" AND   B.ENCOUNTER_ID = ?   ");
					
					if(!module_id.equals("MC"))
						{
						sql.append(" AND   B.FACILITY_ID = ? ");
						
						}
				}
		
				if(fromDate.equals("") && toDate.equals(""))
				{
					sql.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");
					
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
					sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi') +0.00068287 ");
					
				}
				else
				{
					if(!fromDate.equals(""))
							{
						sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");
							}
					if(!toDate.equals(""))
						{
						sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
						}
				}
				sql.append(" and a.DISCR_MSR_RESULT_TYPE  IN ('S','S1','S2','S3') ");
				if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
				{
					sql.append(" and CONTR_MODULE_TRANS_REF=?");
				}
			}
	
			if(sort_by.equals("D"))
			{
				//IN057209 Start.
				//sql.append(" order by  1,2,3 desc ");
				sql.append(" order by  1,2,3 desc,4 ASC ");
				//IN057209 Start.				
			}
			else 
				{
				//sql.append(" order by  1,2,3");//IN069575
				sql.append(" order by  1,2,3 ASC,4 desc");//IN069575
				
				}
			
			try
			{
				pstmt = con.prepareStatement(sql.toString());
				if(detailYN.equals("Y"))
				{
					pstmt.setString(++count,locale);
					pstmt.setString(++count,chartId);
					pstmt.setString(++count,patientId);
					if(!module_id.equals("MC")){
						pstmt.setString(++count,facilityId);
					}
					if(defaultYN.equals("Y"))
					{
						pstmt.setString(++count,encounterId);
						if(!module_id.equals("MC")){
							pstmt.setString(++count,facilityId);
						}
					}
			
					if(fromDate.equals("") && toDate.equals(""))
					{
						pstmt.setString(++count,adm_date);
					}
					if(!fromDate.equals("") && !toDate.equals("")) 
					{
						pstmt.setString(++count,fromDate);
						pstmt.setString(++count,toDate);
					}
					else
					{
						 if(!fromDate.equals(""))
						{
								pstmt.setString(++count,fromDate);
						}
						 if(!toDate.equals(""))
						{
							pstmt.setString(++count,adm_date);
							pstmt.setString(++count,toDate);
						}
					}
			
					if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
					{
						pstmt.setString(++count,contr_mod_accession_num);
					}
				}
				if(summaryYN.equals("Y"))
				{
					pstmt.setString(++count,locale);
					pstmt.setString(++count,chartId);
					pstmt.setString(++count,patientId);
					if(!module_id.equals("MC")){
					pstmt.setString(++count,facilityId);
					}
					if(defaultYN.equals("Y"))
					{
						pstmt.setString(++count,encounterId);
						if(!module_id.equals("MC"))
						{
							pstmt.setString(++count,facilityId);
						}
					}
	
					if(fromDate.equals("") && toDate.equals(""))
					{
						pstmt.setString(++count,adm_date);
					}
					if(!fromDate.equals("") && !toDate.equals("")) 
					{
						pstmt.setString(++count,fromDate);
						pstmt.setString(++count,toDate);
					}
					else
					{
						if(!fromDate.equals(""))
						{
							pstmt.setString(++count,fromDate);
						}
						if(!toDate.equals(""))
						{
							pstmt.setString(++count,adm_date);
							pstmt.setString(++count,toDate);
						}
					}
					if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
					{
						pstmt.setString(++count,contr_mod_accession_num);
					}
				}
				rs = pstmt.executeQuery();
			}//end of try
			catch(Exception encntrExcep)
			{
				encntrExcep.printStackTrace() ;
			}
			
			String chartGrpId="",eventType="",value="",prefix="";
			String resultType="";
			String prevGrpId = "";
			String prevDiscrMsrId = "";
			String eventDate = "",discritMsrId ="";
			String normalStr="",normalRangeColor = "",criticalStr = "";
			HashMap setOfValues = null;
			String normal_low,normal_high,critical_low,critical_high;
			String added_by_name ="";
			while(rs.next())
			{	
				eventDate = rs.getString("dt")==null?"":rs.getString("dt");			
				resultType		= rs.getString("result_type")==null?"":rs.getString("result_type");
				for(int i=0;i<dateArray.size();i++)
				{
					tempDate = dateArray.get(i) ==null ? "" :(String) dateArray.get(i);					
					if(eventDate.equals(tempDate) && resultType.equals((String)resultTypeArr.get(i)))
					{
						chartGrpId		= rs.getString("CHART_GROUP_ID")==null?"":rs.getString("CHART_GROUP_ID");
						discritMsrId	= rs.getString("DISCR_MSR_ID")==null?"&nbsp;":rs.getString("DISCR_MSR_ID");
						eventType		= rs.getString("DISCR_MSR_RESULT_TYPE")==null?"":rs.getString("DISCR_MSR_RESULT_TYPE");
				
						if(eventType.equals("L"))
						{
							if(rs.getString("DISCR_MSR_RESULT_NUM") != null || rs.getString("DISCR_MSR_RESULT_STR") != null)	
							{
								//IN067307 changes starts
								//value = (rs.getString("DISCR_MSR_RESULT_NUM")==null?" ":rs.getString("DISCR_MSR_RESULT_NUM")) +"||"+(rs.getString("DISCR_MSR_RESULT_STR")==null?"X":rs.getString("DISCR_MSR_RESULT_STR")) ;//commented for IN067307
								String discr_val ="";
								BigDecimal val =rs.getBigDecimal("DISCR_MSR_RESULT_NUM");
								if(val!=null)
									discr_val=val.toString();
								else
									discr_val=" ";
								value = discr_val +"||"+(rs.getString("DISCR_MSR_RESULT_STR")==null?"X":rs.getString("DISCR_MSR_RESULT_STR")) ;
								//IN067307 changes ends
							}
							else
								value = "";
						}
						else if(!eventType.equals("S") && !eventType.equals("S1")  && !eventType.equals("S2") && !eventType.equals("S3"))
						{					
							if(eventType.equals("N")||eventType.equals("A")||eventType.equals("I"))
							{
								prefix = rs.getString("RESULT_NUM_PREFIX")==null?"":rs.getString("RESULT_NUM_PREFIX");								
								//IN067307 changes starts
								//value = rs.getString("DISCR_MSR_RESULT_NUM")==null?"":rs.getString("DISCR_MSR_RESULT_NUM");
								BigDecimal val =rs.getBigDecimal("DISCR_MSR_RESULT_NUM");
								if(val!=null)
									value=val.toString();
								else
									value="";
								//IN067307 changes ends
								if(prefix != null || !prefix.equals(""))
									value = prefix + value;
							}
							else
							{
								value = rs.getString("DISCR_MSR_RESULT_STR")==null?"":rs.getString("DISCR_MSR_RESULT_STR");

								if(eventType.equals("D") )
									value = com.ehis.util.DateUtils.convertDate(value,"DMY","en",locale);
								else if(eventType.equals("E") )
									value = com.ehis.util.DateUtils.convertDate(value,"DMYHM","en",locale);
							}
						}
						else
						{
							if(eventType.equals("S") || eventType.equals("S1")||eventType.equals("S2")||eventType.equals("S3")){
								//IN067307 changes starts
								//value = rs.getString("DISCR_MSR_RESULT_NUM")==null?"":rs.getString("DISCR_MSR_RESULT_NUM")+(rs.getString("DISCR_MSR_RESULT_STR")==null?"": " ("+rs.getString("DISCR_MSR_RESULT_STR")+")") ;
								String discr_val ="";
								BigDecimal val =rs.getBigDecimal("DISCR_MSR_RESULT_NUM");
								if(val!=null)
									discr_val=val.toString();
								else
									discr_val="";
								value = discr_val+(rs.getString("DISCR_MSR_RESULT_STR")==null?"": " ("+rs.getString("DISCR_MSR_RESULT_STR")+")") ;
								//IN067307 changes ends

							}
							else
							{
								value = rs.getString("DISCR_MSR_RESULT_STR")==null?"":rs.getString("DISCR_MSR_RESULT_STR");
							}
								
						}
						
						
						result_uom = rs.getString("DISCR_MSR_RESULT_NUM_UOM")==null?"":rs.getString("DISCR_MSR_RESULT_NUM_UOM");

						legend_type = rs.getString("legend_type")==null?"S":rs.getString("legend_type");
						remarks = rs.getString("remarks")==null?"":rs.getString("remarks");
						normalRangeColor = rs.getString("normal_range_color")==null?"":rs.getString("normal_range_color");
						if(legend_type.equals("S"))
							normalRangeColor = rs.getString("normal_range_symbol")==null?"":rs.getString("normal_range_symbol");

						normal_low = rs.getString("NORMAL_LOW")==null?"":rs.getString("NORMAL_LOW");
						normal_high = rs.getString("NORMAL_HIGH")==null?"":rs.getString("NORMAL_HIGH");
						critical_low = rs.getString("CRITICAL_LOW")==null?"":rs.getString("CRITICAL_LOW");
						critical_high = rs.getString("CRITICAL_HIGH")==null?"":rs.getString("CRITICAL_HIGH");
						if(!eventType.equals("S"))
						{
							added_by_name= rs.getString("added_by_name")==null?"":rs.getString("added_by_name");
						}

						//Added by Jyothi.G on 09/12/2010 to fix IN025310
						if(!normal_low.equals("") && !normal_high.equals(""))
							normalStr = Normal_Range + " : " + normal_low + " - " + normal_high + " " + result_uom;
						else if(!normal_low.equals("") && normal_high.equals(""))
							normalStr = Normal_Range + " : (>=" + normal_low + " " + result_uom + ")";
						else if(normal_low.equals("") && !normal_high.equals(""))
							normalStr = Normal_Range + " : (<=" + normal_high + " " + result_uom + ")";
						else
							normalStr = "";

						if(!critical_low.equals("") && !critical_high.equals(""))
						{
							criticalStr = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ critical_low + " " + result_uom+") & "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + critical_high + " " + result_uom+")" ;
						}
						else if(!critical_low.equals("") && critical_high.equals(""))
						{
							criticalStr = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ critical_low + " " + result_uom+")" ;
						}
						else if(critical_low.equals("") && !critical_high.equals(""))
						{
							criticalStr = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + critical_high + " " + result_uom+")" ;
						}
						else
							criticalStr = "";//END

						if(!(prevGrpId.equals(chartGrpId))|| !(prevDiscrMsrId.equals(discritMsrId)))
						{
							ValArray =new ArrayList();
						}
						setOfValues = new HashMap();
						setOfValues.put("CHART_GRP_ID",chartGrpId);
						setOfValues.put("DISCR_MSR_ID",discritMsrId);	
							
						setOfValues.put("VALUE",value);
						setOfValues.put("COLOR",normalRangeColor);
						setOfValues.put("NORMALSTR",normalStr);
						setOfValues.put("CRITICALSTR",criticalStr);
						setOfValues.put("RESULT_TYPE",eventType);
						setOfValues.put("VALUE_DATE",eventDate);
						setOfValues.put("added_by_name",added_by_name);
						setOfValues.put("legend_type",legend_type);
						setOfValues.put("normal_low",normal_low);
						setOfValues.put("normal_high",normal_high);
						setOfValues.put("remarks",remarks);
						String tempResultType = resultTypeArr.get(i) ==null ? "" :(String) resultTypeArr.get(i); //IN057209	
						if("S".equals(eventType)||"S1".equals(eventType)||"S2".equals(eventType)||"S3".equals(eventType)){
							if(eventType.equals(tempResultType)){ //IN057209								
								ValArray.add(setOfValues);
							}
						}else{
							ValArray.add(setOfValues);							
						}						
						
						if(!(prevGrpId.equals(chartGrpId))|| !(prevDiscrMsrId.equals(discritMsrId)))
						{
							dataHash.put(chartGrpId+"~"+discritMsrId,ValArray);
							prevGrpId = chartGrpId;
							prevDiscrMsrId=discritMsrId;
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}
		out.println("<input type='hidden' name='flagValue' id='flagValue' value='"+flagValue+"'>");
		
		if(dataHash!=null)
		{

            _bw.write(_wl_block9Bytes, _wl_block9);

			if(!function_from.equals("SECONDARY_TRIAGE"))
			{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(flagString));
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
		}//end of if dataHash != null

            _bw.write(_wl_block13Bytes, _wl_block13);

		finalHash = dataHash;
		ArrayList dates = dateArray;
		HashMap hashData = (HashMap)session.getValue("chartEvents"+encounterId);
		ArrayList arrayChartGrp = (ArrayList)session.getValue("chartGrp"+encounterId);

		if(dates.size()>0)
		{

            _bw.write(_wl_block14Bytes, _wl_block14);

			int tabWidth = 0;
			int widPc = 0;
			if(dates.size() <= 5)
			{
				tabWidth = dates.size() * 100;//only for GUI purpose...no specific reason to set it to 100...
			}
			else
			{
				tabWidth = dates.size() * 80;
			}
			widPc = tabWidth/dates.size();

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tabWidth));
            _bw.write(_wl_block17Bytes, _wl_block17);

		StringTokenizer tokenizeSpace = null;
		String dt = "";
		String currDate="";
		String prevDateTemp = "";
		String dummyDateString = "";
		String datesForPrevNext = "";
		StringBuffer dummyDateStringForGraph = new StringBuffer();
		int ii=0;
		int index=0;
		boolean flag = true;
		int actualIndex = 0;

		if(dates != null)
		{
			for(ii=0;ii<dates.size();ii++)
			{
				dt = (String)dates.get(ii);
				if(ii == 0) prevFirstDate = prevFirstDate + "~" +dt;
				
				if(!prevNextTen.equals("prevNextTen"))
				{
					if(!datesForPrevNext.equals(""))
						datesForPrevNext = datesForPrevNext + "`" +dt;
					else
						datesForPrevNext = dt;
				}
				else
				{
					datesForPrevNext = datesForPrevNextVal;
				}
				tokenizeSpace = new StringTokenizer(dt," ");
				currDate = tokenizeSpace.nextToken();

				if(!currDate.equals(prevDateTemp))
				{
					out.println("<td class='DateLink' width='"+widPc+"px' id='rowId"+index+"'>"+com.ehis.util.DateUtils.convertDate(currDate,"DMY","en",locale)+"</td>");
					prevDateTemp =currDate;
					actualIndex = index;
					index++;
				}
				else
				{

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(actualIndex));
            _bw.write(_wl_block19Bytes, _wl_block19);
				
				}
			}
			out.println("<input type='hidden' name='noOfHrRows' id='noOfHrRows' value='"+index+"'>");
		}
		String dummyString="";
		String currDate1="";
		String anchorObj = "";
		String anchorObjEnd = "";
		out.println("</tr>");
		out.println("<tr id='divTitleTable1'>");
		if(dates!=null)
		{
			for( ii=0;ii<dates.size();ii++)
			{
				dt = (String)dates.get(ii);
				dummyString=(String)arrayResultType.get(ii);
                
				tokenizeSpace = new StringTokenizer(dt," ");
				currDate1 = tokenizeSpace.nextToken();
				currDate = tokenizeSpace.nextToken();
							
				dummyDateString = currDate1;
				currDate1= currDate1.replace('/','_');
				if(dummyString.equals("S")){					
					currDate="Day Summary";
				}
				//IN057209 Start.
                if(dummyString.equals("S1")){					
					currDate="Shift1 Summary";
				}
                if(dummyString.equals("S2")){					
					currDate="Shift2 Summary";
				}
                if(dummyString.equals("S3")){					
					currDate="Shift3 Summary";
				}
              	//IN057209 End.
				if(currDate.equals("Day Summary") || currDate.equals("Shift1 Summary") || currDate.equals("Shift2 Summary") || currDate.equals("Shift3 Summary"))
				{
					anchorObj = "";
					anchorObjEnd = "";								
				}
				else if(!currDate.equals("Day Summary") || currDate.equals("Shift1 Summary") || currDate.equals("Shift2 Summary") || currDate.equals("Shift3 Summary"))
				{
					dummyDateStringForGraph.append(com.ehis.util.DateUtils.convertDate(dt,"DMYHM","en",locale)+"$$");
					if(errorAuth.equals("A"))
					{
						if(modifyYN.equals("N"))
						{
							anchorObj = "";
							anchorObjEnd = "";
						}
						else
						{
							anchorObj = "<a href='javascript:callAmend(\""+dt+"\")'  title = 'Click here for Amend/Mark as error' >";
							anchorObjEnd = "</a>";
						}
					}
				}
				else
				{
					anchorObj = "";
					anchorObjEnd = "";							
				}
				String strSuminthai = currDate;
				if(strSuminthai.equals("Day Summary"))
				{
					strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DaySummary.label","ca_labels");
				}
				//IN057209 Start.
				if(strSuminthai.equals("Shift1 Summary"))
				{
					//strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ShiftOne.label","ca_labels");//IN067541
					strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AMShift.label","ca_labels");//IN067541
				}
				if(strSuminthai.equals("Shift2 Summary"))
				{
					//strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ShiftTwo.label","ca_labels");//IN067541
					strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PMShift.label","ca_labels");//IN067541
				}
				if(strSuminthai.equals("Shift3 Summary"))
				{
					//strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ShiftThree.label","ca_labels");//IN067541
					strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ONShift.label","ca_labels");//IN067541
				}	
				//IN057209 End.
				out.println("<td class='TimeLink'  nowrap width='90px' id='thId"+currDate1+ii+"'> "+anchorObj+" "+strSuminthai+" "+anchorObjEnd+" </td>");
				prevDateTemp = currDate;
			}
		}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ii));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(defaultYN));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block27Bytes, _wl_block27);

		ArrayList cols = new ArrayList();
		ArrayList discrArray = new ArrayList();
		HashMap setOfValues = new HashMap();
		String printVal = "";
		String classValue = "gridDataChart";
		String styleValue = "";
		StringBuffer tempStringBuffer = null;
		String result_type = "";
		String discrMsrId = "";
		String tempStringTemp = "";
		String tempString1 = "";
		int indexJ = 0;
		String normalStr="",normalRangeColor = "",criticalStr = "";
		String currGroupId ="";
		String eventDate = "";
		String resultTypeTemp="";//IN067541
		String tooltip = "";
		String colspanval ="3";//IN067534 //commented for checkstyle IN067534
		String outdata="";//IN067534
		String printdata="";//IN067534
		String showpopup="";//IN067534 //commented for checkstyle IN067534
		String currEventDate="";
		String normalLow="";
		String normalHigh="";
		String hiddenValueForGraph="";
		String hiddenDateForGraph="";
		StringBuffer loginUserName = new StringBuffer("");
		int z =0 ;int indexK = 0;int k=0;
		int tempIntForGraph = 0;
				
		String recordedBy = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels");
		loginUserName.append(recordedBy+" : ");
		String added_by_name="";
		//IN067534 starts
		outdata = outdata+"<table class='grid' cellspacing=0 cellpadding=0 width='100%'>";		
		printdata = printdata +outdata;
		String tempStyle = "";//IN067541
		//IN067534ends
		for( indexJ= 0 ; indexJ < arrayChartGrp.size();indexJ++)
		{
			
			flag = true;
			index = 0;
			currGroupId = (String)arrayChartGrp.get(indexJ)==null ? "" : (String)arrayChartGrp.get(indexJ) ;
			discrArray	= (ArrayList)hashData.get(currGroupId); 
			out.println("<tr>");
			for(k=0;k<dates.size();k++)
			{
				//edited for style sheet
				//out.println("<td width='"+widPc+"px' class='CACHARTFOURTHLEVELCOLOR' >&nbsp;</td>");
			out.println("<td width='"+widPc+"px' class='CACHARTFOURTHLEVELCOLOR' ></td>");
			}
			out.println("</tr>");
			for(indexK =0 ;indexK <discrArray.size();indexK++)
			{
				discrMsrId = (String)discrArray.get(indexK);
				out.println("<tr id='tdrowId"+indexJ+indexK+"'>");

				cols = (ArrayList)finalHash.get(currGroupId+"~"+discrMsrId);
				for(k=0,z=0;k<dates.size();k++)
				{	
					remarks = "";
					remStrDisplay = "";
					tempStyle ="";//IN067541
					resultTypeTemp = (String)resultTypeArr.get(k);//IN067541
					if(cols != null)
					{
						hiddenDateForGraph = " ";
						hiddenValueForGraph = " ";
						remStrDisplay = "";
						
						if(cols.size() > z)
						{
							setOfValues = (HashMap)cols.get(z);
							eventDate = (String)dates.get(k);						
									currEventDate = (String)(setOfValues.get("VALUE_DATE"))==null ? "" : (String)(setOfValues.get("VALUE_DATE"));
									added_by_name =((String)(setOfValues.get("added_by_name")==null?"":setOfValues.get("added_by_name")));
								if(currEventDate.equals(eventDate))
									{ 
										//IN065535 Start.
										result_type = (String)(setOfValues.get("RESULT_TYPE")==null?"":setOfValues.get("RESULT_TYPE"));
										if((!result_type.equals("S") && !result_type.equals("S1") && !result_type.equals("S2") && !result_type.equals("S3")) ||
											((result_type.equals("S") || result_type.equals("S1") || result_type.equals("S2") || result_type.equals("S3")) && (result_type.equals(arrayResultType.get(k))))){
											//IN065535 End.
											printVal = (String)setOfValues.get("VALUE")== null ? "" :(String)setOfValues.get("VALUE") ;
											normalLow = (String)setOfValues.get("normal_low")== null ? "" :(String)setOfValues.get("normal_low") ;
											normalHigh = (String)setOfValues.get("normal_high")== null ? "" :(String)setOfValues.get("normal_high") ;
											normalStr = (String)(setOfValues.get("NORMALSTR")==null?"":setOfValues.get("NORMALSTR"));
											normalRangeColor = (String)(setOfValues.get("COLOR")==null?"":setOfValues.get("COLOR"));
											legend_type = (String)(setOfValues.get("legend_type")==null?"S":setOfValues.get("legend_type"));
											remarks = (String)(setOfValues.get("remarks")==null?"":setOfValues.get("remarks"));
											criticalStr = (String)(setOfValues.get("CRITICALSTR")==null?"":setOfValues.get("CRITICALSTR"));
											result_type = (String)(setOfValues.get("RESULT_TYPE")==null?"":setOfValues.get("RESULT_TYPE"));
		
											if(!remarks.equals("")) 
											{										
												remStrDisplay = "<a style='color:blue' title = 'Click here to view comments' id = 'anc"+tempIntForGraph+"ID"+k+"' href='javascript:showRemarks(\""+tempIntForGraph+"\",\""+k+"\")'><font size='2'>R</font></a>";
											}else{
													remStrDisplay = "";
											}										
											if(result_type.equals("L")){
												if(!printVal.equals("")){	
													if(printVal.indexOf("||") !=-1){													
														tokenizeSpace =  new StringTokenizer(printVal,"||");
														tempString1 = tokenizeSpace.nextToken();													
														tempStringTemp = tokenizeSpace.nextToken();														
														if(tempStringTemp.length() > 9){
															tempStringBuffer = new StringBuffer(tempStringTemp);
															index=0;														
															tempStringBuffer = tempStringBuffer.replace(index,index+tempStringTemp.length()," <label title='"+tempStringTemp+"' class='LABELFORDISCRETE'>"+tempStringTemp.substring(0,5) +"..."+" </label> ");
															printVal = tempStringBuffer.toString();
														}else{
															printVal=tempStringTemp;														
														}	
													}
													printVal = tempString1 + " " + printVal;												
												}		
											}
											if(flag==true){											
												if(!printVal.equals("")){
													if(!normalStr.equals("") && !criticalStr.equals(""))
														tooltip = normalStr+"<br> "+criticalStr+"<br>"+loginUserName.toString()+added_by_name;
													else if(!normalStr.equals(""))
														tooltip = normalStr+"<br>"+loginUserName.toString()+added_by_name;
													else if(!criticalStr.equals(""))
														tooltip = criticalStr+"<br>"+loginUserName.toString()+added_by_name;
													else
														tooltip = "";
												}else{
													tooltip="";
												}
											}
											if(!result_type.equals("S")){											
												if(!normalRangeColor.equals("")){
													styleValue = "STYLE= 'FONT-SIZE: 7PT;BORDER-STYLE: THIN ";
												}else{
													if((indexK%2)==0){
														classValue	=	"gridDataChart";
														styleValue = "class = '"+classValue+"' ";													
													}else{
														classValue	=	"gridDataChart";
														styleValue = "class = '"+classValue+"' ";
													}
												}
											}else if(result_type.equals("S") || result_type.equals("S1") || result_type.equals("S2") || result_type.equals("S3")){						
												classValue = "CASUMMARY";
												styleValue = "class = '"+classValue+"' ";											
											}										
											//IN067541 STARTS
											if(result_type.equals("S")||resultTypeTemp.equals("S1") || resultTypeTemp.equals("S2") || resultTypeTemp.equals("S3")){
												tempStyle="style='background-color:#d3d3d3;'";
											}
											//IN067541 ENDS
											if(printVal.equals(""))
												hiddenValueForGraph = " ";
											else{
												if(result_type.equals("L")){
													hiddenValueForGraph = tempString1;													
												}else{
													hiddenValueForGraph = printVal;												
												}
											}		
											if(currEventDate.equals("")){
												hiddenDateForGraph = " ";
											}else{
												hiddenDateForGraph = com.ehis.util.DateUtils.convertDate(currEventDate,"DMYHM","en",locale);
											}										
											if(!printVal.equals("")){											
												if(!normalRangeColor.equals("")){
													if(legend_type.equals("S"))
														printVal = "<font  style='background-image:url(\"../../eCA/images/"+normalRangeColor+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + printVal;
													else
														printVal = "<font  style='background-color:"+normalRangeColor+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + printVal;
												}else if(!normalLow.equals("") && !normalHigh.equals("")){
													if(Float.parseFloat(printVal) > 0){
														if((Float.parseFloat(printVal) >= Float.parseFloat(normalLow)) && (Float.parseFloat(printVal) <= Float.parseFloat(normalHigh))){
															if(legend_type.equals("S"))
																printVal = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + printVal;
															else
																printVal = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + printVal;
														}
													}
												}
												else if(!normalLow.equals("") && normalHigh.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
												{
													if(Float.parseFloat(printVal) > 0)
													{
														if(Float.parseFloat(printVal) >= Float.parseFloat(normalLow)) 
														{
															if(legend_type.equals("S"))
																printVal = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + printVal;
															else
																printVal = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + printVal;
														}
													}
												}
												else if(normalLow.equals("") && !normalHigh.equals(""))
												{
													if(Float.parseFloat(printVal) > 0)
													{
														if(Float.parseFloat(printVal) <= Float.parseFloat(normalHigh))
														{
															if(legend_type.equals("S"))
																printVal = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + printVal;
															else
																printVal = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + printVal;
														}
													}
												}//END
											}
											//IN059461 Start.
											//out.println("<td class='gridDataChart' width='"+widPc+"px' onmouseover=\"displayToolTip('"+tooltip+"',this)\" onMouseOut =hideToolTip(this)>"+printVal+"&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");
					//out.println("<td class='gridDataChart' width='5' onMouseOut ='hidePopUp(this)' onMouseOut='hideToolTip(this)'onmouseover=\"return showPopUp('tooltip','Performed By: "+added_by_name+"')\">"+printVal+"&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067534
					//out.println("<td class='gridDataChart' "+tempStyle+" width='5' onMouseOut ='hidePopUp(this)' onMouseOut='hideToolTip(this)'onmouseover=\"return showPopUp('tooltip','Performed By: "+added_by_name+"')\">"+printVal+"&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067534//IN067541
					//8186 Start.
					//out.println("<td class='gridDataChart' "+tempStyle+" width='5' onMouseOut ='hidePopUp(this),hideToolTip(this)' onMouseOver=\"return showPopUp('tooltip','Performed By: "+added_by_name+"'),displayToolTip('"+tooltip+"',this)\">"+printVal+"&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067541
					out.println("<td class='gridDataChart' "+tempStyle+" width='"+widPc+"px' onMouseOut ='hidePopUp(this),hideToolTip(this)' onMouseOver=\"return showPopUp('tooltip','Performed By: "+added_by_name+"'),displayToolTip('"+tooltip+"',this)\">"+printVal+"&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");
					//8186 End.
											//IN059461 End.
											z++;
											printVal="";
										//IN065535 Start.
										}else{
											if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1") || resultTypeTemp.equals("S2") || resultTypeTemp.equals("S3")){
												tempStyle="style='background-color:#d3d3d3;'";
											}//IN067541 ENDS
											if((indexK%2)==0){
												classValue	=	"gridDataChart";
												styleValue = "class = '"+classValue+"' ";
											}else{
												classValue	=	"gridDataChart";
												styleValue = "class = '"+classValue+"' ";
											}
											//out.println("<td width='"+widPc+"px' "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067541
											out.println("<td width='"+widPc+"px' "+tempStyle+" "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067541
										}
										//IN065535 End.
									}else{	
										if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1") || resultTypeTemp.equals("S2") || resultTypeTemp.equals("S3")){
											tempStyle="style='background-color:#d3d3d3;'";
										}//IN067541 ENDS
										if((indexK%2)==0){
											classValue	=	"gridDataChart";
											styleValue = "class = '"+classValue+"' ";
										}else{
											classValue	=	"gridDataChart";
											styleValue = "class = '"+classValue+"' ";
										}
										//IN059461 Start.
										//out.println("<td width='"+widPc+"px' "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");
										//out.println("<td   width='"+widPc+"px' "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067541
										out.println("<td   width='"+widPc+"px' "+tempStyle+" "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067541
										//IN059461 End.
									}
						}else{//IN067541 STARTS
							if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1") || resultTypeTemp.equals("S2") || resultTypeTemp.equals("S3")){
								tempStyle="style='background-color:#d3d3d3;'";
							}//IN067541 ENDS
							if((indexK%2)==0){
								classValue	=	"gridDataChart";
								styleValue = "class = '"+classValue+"' ";
							}else{
								classValue	=	"gridDataChart";
								styleValue = "class = '"+classValue+"' ";
							}
							//IN059461 Start.
							//out.println("<td width='"+widPc+"px' "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");
							//out.println("<td width='"+widPc+"px'  "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067541
							out.println("<td "+tempStyle+" width='"+widPc+"px'  "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067541
							//IN059461 End.
						}
					}else{
						//IN067541 STARTS
							if(resultTypeTemp.equals("S")||resultTypeTemp.equals("S1") || resultTypeTemp.equals("S2") || resultTypeTemp.equals("S3")){
								tempStyle="style='background-color:#d3d3d3;'";
							}//IN067541 ENDS
						if((indexK%2)==0){
							classValue	=	"gridDataChart";
							styleValue = "class = '"+classValue+"' ";
						}else{
							classValue	=	"gridDataChart";
							styleValue = "class = '"+classValue+"' ";
						}
						//IN059461 Start.
						//out.println("<td width='"+widPc+"px' "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");
						//out.println("<td width='"+widPc+"px' "+styleValue+" >&nbsp; "+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");//IN067541
						out.println("<td width='"+widPc+"px' "+tempStyle+" "+styleValue+" >&nbsp;"+remStrDisplay+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"^%"+result_type+"'><input type='hidden' id='remarks"+tempIntForGraph+"ForDisp"+k+"' value='"+remarks+"'>");
						//IN059461 End.
					}
				}
				tempIntForGraph++;
				out.println("</tr>");					
			}
		}

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(detailDate));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(flagValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(flagString));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(adm_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(noOfDays));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(daySummary));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(from));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(to));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chartId));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(datesForArray));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(datesForArray));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(datesForPrevNext));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dateArray.size()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(dummyDateStringForGraph.toString()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(numOfPages));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(tempCountOfRecs));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(prevFirstDate));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pageNo));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block56Bytes, _wl_block56);
		}
	}//end of if-summay-YN= N
	if(!prevNextTen.equals("prevNextTen"))
	{
		session.putValue("tempDateArray"+encounterId,tempDateArray);
		session.putValue("arrayNext"+encounterId,arrayNext);
	}
	session.putValue("arrayResultType"+encounterId,arrayResultType);
	session.putValue("dateArray"+encounterId,dateArray);
	session.putValue("dataHash"+encounterId,dataHash);

	if(tempPrevDate != null) tempPrevDate.clear();
	if(tempArrayNext != null) tempArrayNext.clear();
	if(arrayNext != null) arrayNext.clear();
	if(tempDateArray != null) tempDateArray.clear();
	if(arraytempDate != null) arraytempDate.clear();
}//end of try
catch(Exception ee)
{
	ee.printStackTrace();
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block57Bytes, _wl_block57);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
