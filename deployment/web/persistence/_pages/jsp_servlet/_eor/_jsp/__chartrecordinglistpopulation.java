package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
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
        if (sci.isResourceStale("/eor/jsp/ChartRecordingListPopulation.jsp", 1741325288000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<body>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\tparent.ChartRecordingCriteriaFrame.document.forms[0].start.value= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"\n\tparent.ChartRecordingCriteriaFrame.document.forms[0].end.value= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' != \"SECONDARY_TRIAGE\")\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.ChartRecordingControlsFrame.document.chartRecordingControlsForm.labelCaption.value =  \'\';\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\tparent.ChartRecordingCriteriaFrame.document.forms[0].maxRecord.value = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"\n\tparent.ChartRecordingCriteriaFrame.document.forms[0].flagStringValue.value = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<html>\n\t\t<head>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' type=\'text/css\' />\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t<style>\n\t\t\tA:link\n\t\t\t{\n\t\t\t\tCOLOR: yellow\n\t\t\t}\n\t\t\tA:visited\n\t\t\t{\n\t\t\t\tCOLOR: yellow\n\t\t\t}\n\t\t\tTD.CACHARTQRYEVEN {\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t}\n\n\t\t\tTD.CACHARTFOURTHLEVELCOLOR \n\t\t\t{\n\t\t\t\theight: 12;\n\t\t\t}\n\n\t\t\tTD.CRITICAL{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#D2B48C;\n\t\t\t}\n\n\t\t\tTD.ABNORMAL{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#FFF8DC;\n\t\t\t}\n\t\t\tTD.HIGH{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#FFDAB9\n\t\t\t}\n\t\t\tTD.LOW{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#F0FFFF;\n\t\t\t}\n\t\t\tTD.CRITICALLOW{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#D8BFD8;\n\t\t\t}\n\t\t\tTD.CRITICALHIGH{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#F4A460;\n\t\t\t}\n\t\t\tTD.DELTAFAIL{\n\t\t\t\tFONT-SIZE: 7PT ;\n\t\t\t\tBORDER-STYLE: THIN;\n\t\t\t\tbackground-color:#FFE4E1;\n\t\t\t}\n\t\t</style>\n\t</head>\n\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\'scrollListFrame()\'>\n\t\t\t<form name =\"ChartLayoutListForm\">\n\n\t\t\t<table cellspacing=0 cellpadding=3 border=1 id=\'titleTable\' width=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t<tr id=\'divTitleTable\'>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<script>\n\t\t\t\tvar rowValue = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"\n\t\t\t\t\tvar thRowId = eval(\"document.getElementById(\"rowId\")\"+rowValue)\n\t\t\t\tthRowId.colSpan += 1\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t</tr>\n\n\t\t\t<INPUT TYPE=\"hidden\" name=\"idCount\" id=\"idCount\" value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"summaryYN\" id=\"summaryYN\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"detailYN\" id=\"detailYN\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"defaultYN\" id=\"defaultYN\" value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"patientId\" id=\"patientId\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t\t\t</table>\t\n\t\t\t<input type=\'hidden\' name=\'fromDate\' id=\'fromDate\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<input type=\'hidden\' name=\'function_from\' id=\'function_from\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<input type=\'hidden\' name=\'detailDate\' id=\'detailDate\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t<input type=\'hidden\' name=\'errorAuth\' id=\'errorAuth\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t<input type=\'hidden\' name=\'flagValue\' id=\'flagValue\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t<input type=\'hidden\' name=\'sort_by\' id=\'sort_by\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t<input type=\'hidden\' name=\'flagString\' id=\'flagString\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t<input type=\'hidden\' name=\'adm_date\' id=\'adm_date\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<input type=\'hidden\' name=\'noOfDays\' id=\'noOfDays\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t<input type=\'hidden\' name=\'daySummary\' id=\'daySummary\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\'hidden\' name=\'chartId\' id=\'chartId\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t<input type=\'hidden\' name=\'toDate\' id=\'toDate\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t<input type=\'hidden\' name=\'datesForArray\' id=\'datesForArray\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t<input type=\'hidden\' name=\'tempDatesForArray\' id=\'tempDatesForArray\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t<input type=\'hidden\' name=\'datesForPrevNext\' id=\'datesForPrevNext\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t<input type=\'hidden\' name=\'numOfDates\' id=\'numOfDates\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=\'hidden\' name=\'allDatesForGraph\' id=\'allDatesForGraph\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t<input type=\'hidden\' name=\'numOfPages\' id=\'numOfPages\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t<input type=\'hidden\' name=\'tempCountOfRecs\' id=\'tempCountOfRecs\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t<input type=\'hidden\' name=\'prevFirstDate\' id=\'prevFirstDate\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t<input type=\'hidden\' name=\'qs\' id=\'qs\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t<input type=\'hidden\' name=\'pageNo\' id=\'pageNo\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t\n\t\t</form>\n\t<script>\n\tvar displayString = \'\';\n\tif(";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" != 0)\n\t\t//displayString = \'  Page 1 of \' + \'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\';\n\t\t\n\t\tdisplayString = \'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'+\"  \"+\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\';\n\t\t\n\n\telse\n\t\tdisplayString = \'\';\n\tif(parent.ChartRecordingDetailFrame != null)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' == \'MC\')\n\t\t{\n\t\t\tif(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' == \'Y\')\n\t\t\t\tparent.AEID.cols = \'58%,*\';\n\t\t\telse\n\t\t\t\tparent.AEID.cols = \'40%,*\';\n\t\t}\n\t\tparent.ChartRecordingDetailFrame.document.body.scroll=\"no\";\n\t\tparent.ChartRecordingDetailFrame.document.body.onscroll= \"\";\n\t\tif(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' != \"SECONDARY_TRIAGE\")\n\t\t\tparent.ChartRecordingControlsFrame.document.chartRecordingControlsForm.labelCaption.value =  displayString;\n\t}\n\t</script>\n \t<script>alignHeight();</script> \n\t<script>alignUnitsAndData();</script>\n\t</html>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

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
		PreparedStatement pstmt =null;
	
	String encounterId		=	request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
	String module_id		=	request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String flagFromNext		=	request.getParameter("flagFromNext")==null?"":request.getParameter("flagFromNext");
	String prevNextTen		=	request.getParameter("prevNextTen")==null?"":request.getParameter("prevNextTen");
	String tempCountOfRecs	=	request.getParameter("tempCountOfRecs")==null?"1":request.getParameter("tempCountOfRecs");
	String datesForPrevNextVal =request.getParameter("datesForPrevNext")==null?"":request.getParameter("datesForPrevNext");
	String datesForArray = "";
	String prevFirstDate = request.getParameter("prevFirstDate")==null?"" :request.getParameter("prevFirstDate");

	int intPrevFirstDate = Integer.parseInt(tempCountOfRecs);

	if(encounterId.equals("")) encounterId = "0";

	String function_from = request.getParameter("function_from")==null?"":request.getParameter("function_from");
	String modifyYN= request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");

	ResultSet rs= null;
    HashMap dataHash =new HashMap(); 
	HashMap finalHash = new HashMap();
	ArrayList arrayNext = (ArrayList)session.getValue("arrayNext"+encounterId);
	ArrayList arrayResultType = new ArrayList();
	StringBuffer toolTip = new StringBuffer("Records for Dates :");
	ArrayList tempDateArray = (ArrayList)session.getValue("tempDateArray"+encounterId);
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

	int daySummary=0;
	int noOfDays = request.getParameter("noOfDays")==null?0:Integer.parseInt(request.getParameter("noOfDays"));
	int pageNo = request.getParameter("pageNo")==null?1:Integer.parseInt(request.getParameter("pageNo"));
	
	if(request.getParameter("summaryText")==null || request.getParameter("summaryText").equals(""))
		daySummary=0;
	else
		daySummary=Integer.parseInt(request.getParameter("summaryText"));

	if(function_from.equals("SECONDARY_TRIAGE"))
		daySummary = 1;

	if(daySummary == 0 && !sort_by.equals("A")) 
		adm_date = detailDate + " 00:00";
	else 
		adm_date =request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");

	String tempDetailDate = "";
	
	int start =0;
	int end =0;
	int maxRecord = 0;
	int numOfPages = 0;

	String summaryYN = request.getParameter("summaryYN")==null?"":request.getParameter("summaryYN");
	String detailYN = request.getParameter("detailYN")==null?"Y":request.getParameter("detailYN");
	String from = request.getParameter("start")==null ?"0" : request.getParameter("start");
	String to = request.getParameter("end")==null ? ""+daySummary+"" : request.getParameter("end");
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

            _bw.write(_wl_block1Bytes, _wl_block1);
	
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
StringTokenizer tokenColon = null;

fromDate			=	com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM", locale,"en");
toDate				=	com.ehis.util.DateUtils.convertDate(toDate,"DMYHM", locale,"en");

ArrayList tempArrayList=null;

	try
	{

		int count=0;
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
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.getElementById('labelSummary').style.display='none'</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.summaryYN.style.display='none'</script>");
			}
		}
		else
		{
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.getElementById('labelSummary').style.display='inline'</script>");
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

			sqlDates.append("SELECT  distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,'N' DISCR_MSR_RESULT_TYPE  from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");
			
			if(defaultYN.equals("Y"))
			{
				sqlDates.append("AND B.FACILITY_ID = A.FACILITY_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID  ");
			}

			sqlDates.append("and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.discr_msr_id and   a.facility_id=? and a.patient_id=?  and a.DISCR_MSR_RESULT_TYPE in('C','D','E','N','A','I','L','F','H','T') ");
			//if(daySummary !=0)
			{
				if(fromDate.equals("") && toDate.equals(""))
				{
					if(daySummary != 0 || (sort_by.equals("D") && daySummary == 0))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");				
					}
					else if(sort_by.equals("A") && daySummary == 0)
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  to_date(?,'dd/mm/yyyy hh24:mi') ");
					}
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
								
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi') ");
				}
				else
				{
								
						if(!fromDate.equals(""))
						{
							if(daySummary != 0 || (sort_by.equals("D") && daySummary == 0))
							{
								sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");		
							}
							else if(sort_by.equals("A") && daySummary == 0)
							{
								sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and  to_date(?,'dd/mm/yyyy hh24:mi') + 0.99 ");							
							}
						}
						if(!toDate.equals(""))
						{
							sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
						}
				}
			}
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
				sqlDates.append(" and CONTR_MODULE_TRANS_REF=?");
			}
		  }
	
	if(detailYN.equals("Y") && summaryYN.equals("Y"))
		   sqlDates.append(" UNION ALL");
	if(summaryYN.equals("Y"))
	 {
		sqlDates.append(" SELECT distinct to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi'),a.TEST_OBSERV_DT_TM,a.DISCR_MSR_RESULT_TYPE from CA_ENCNTR_DISCR_MSR a ,"+tempString+" where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' ");

		if(defaultYN.equals("Y"))
		{
			sqlDates.append("AND B.FACILITY_ID = A.FACILITY_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID  ");
		}

		sqlDates.append("and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.SUMMRY_COLUMN and a.facility_id=? and a.patient_id=? and a.DISCR_MSR_RESULT_TYPE ='S'   ");
		 			//if(daySummary !=0)
			{
				if(fromDate.equals("") && toDate.equals(""))
				{
					if(daySummary != 0 || (sort_by.equals("D") && daySummary == 0))
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");				
					}
					else if(sort_by.equals("A") && daySummary == 0)
					{
						sqlDates.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  to_date(?,'dd/mm/yyyy hh24:mi') ");
					}
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
								
						sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi') ");
				}
				else
				{
								
						if(!fromDate.equals(""))
						{
							if(daySummary != 0 || (sort_by.equals("D") && daySummary == 0))
							{
								sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");		
							}
							else if(sort_by.equals("A") && daySummary == 0)
							{
								sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and  to_date(?,'dd/mm/yyyy hh24:mi') + 0.99 ");							
							}
						}
						if(!toDate.equals(""))
						{
							sqlDates.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
						}
				}
			}
			 if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
				sqlDates.append(" and CONTR_MODULE_TRANS_REF=?");
			}
	  }
	 
	  if(sort_by.equals("D"))
	  {
		sqlDates.append(" order by 2 Desc");
	  }
	  else
	  {
		sqlDates.append(" order by 2");
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
//	pstmt =	con.prepareStatement(sqlDates.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);  
	pstmt =	con.prepareStatement(sqlDates.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);  

	if(detailYN.equals("Y"))
	{
			pstmt.setString(++count,chartId);		
			pstmt.setString(++count,facilityId);
			pstmt.setString(++count,patientId);
			//if(daySummary !=0)
			{
				if(fromDate.equals("") && toDate.equals(""))
				{
					if(daySummary != 0 || (sort_by.equals("D") && daySummary == 0))
					{
						pstmt.setString(++count,adm_date);
					}
					else if(sort_by.equals("A") && daySummary == 0)
					{
						tempDetailDate = detailDate + " 23:59";
						pstmt.setString(++count,adm_date);
						pstmt.setString(++count,tempDetailDate);
					}
				}
				if(!fromDate.equals("") && !toDate.equals("")) 
				{
					if(daySummary != 0)
					{
						pstmt.setString(++count,fromDate);
						pstmt.setString(++count,toDate);
					}
					else if(daySummary == 0 && sort_by.equals("D"))
					{
						tempDetailDate = detailDate + " 00:00";
						pstmt.setString(++count,tempDetailDate);
						pstmt.setString(++count,toDate);
					}
					else if(daySummary == 0 && sort_by.equals("A"))
					{
						tempDetailDate = detailDate + " 23:59";
						pstmt.setString(++count,fromDate);
						pstmt.setString(++count,tempDetailDate);
					}
				}
				else
				{	
					if(daySummary != 0)
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
					else if(daySummary == 0)
					{
						if(sort_by.equals("D"))
						{
							 if(!fromDate.equals(""))
							{
								 tempDetailDate = detailDate + " 00:00";
								 pstmt.setString(++count,tempDetailDate);
							}
							if(!toDate.equals(""))
							{
								tempDetailDate = detailDate + " 00:00";
								pstmt.setString(++count,tempDetailDate);
								pstmt.setString(++count,toDate);
							}
						}
						else if(sort_by.equals("A"))
						{
							if(!fromDate.equals(""))
							{
								 tempDetailDate = detailDate + " 23:59";
								 pstmt.setString(++count,fromDate);
								 pstmt.setString(++count,tempDetailDate);
							}
							if(!toDate.equals(""))
							{
								tempDetailDate = detailDate + " 23:59";
								pstmt.setString(++count,adm_date);
								pstmt.setString(++count,tempDetailDate);
							}
						}
					}
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
			pstmt.setString(++count,facilityId);
			pstmt.setString(++count,patientId);
			//if(daySummary !=0)
			{
				if(fromDate.equals("") && toDate.equals(""))
				{
					if(daySummary != 0 || (sort_by.equals("D") && daySummary == 0))
					{
						pstmt.setString(++count,adm_date);
					}
					else if(sort_by.equals("A") && daySummary == 0)
					{
						tempDetailDate = detailDate + " 23:59";
						pstmt.setString(++count,adm_date);
						pstmt.setString(++count,tempDetailDate);
					}
				}
				if(!fromDate.equals("") && !toDate.equals("")) 
				{
					if(daySummary != 0)
					{
						pstmt.setString(++count,fromDate);
						pstmt.setString(++count,toDate);
					}
					else if(daySummary == 0 && sort_by.equals("D"))
					{
						tempDetailDate = detailDate + " 00:00";
						pstmt.setString(++count,tempDetailDate);
						pstmt.setString(++count,toDate);
					}
					else if(daySummary == 0 && sort_by.equals("A"))
					{
						tempDetailDate = detailDate + " 23:59";
						pstmt.setString(++count,fromDate);
						pstmt.setString(++count,tempDetailDate);
					}
				}
				else
				{	
					if(daySummary != 0)
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
					else if(daySummary == 0)
					{
						if(sort_by.equals("D"))
						{
							 if(!fromDate.equals(""))
							{
								 tempDetailDate = detailDate + " 00:00";
								 pstmt.setString(++count,tempDetailDate);
							}
							if(!toDate.equals(""))
							{
								tempDetailDate = detailDate + " 00:00";
								pstmt.setString(++count,tempDetailDate);
								pstmt.setString(++count,toDate);
							}
						}
						else if(sort_by.equals("A"))
						{
							if(!fromDate.equals(""))
							{
								 tempDetailDate = detailDate + " 23:59";
								 pstmt.setString(++count,fromDate);
								 pstmt.setString(++count,tempDetailDate);
							}
							if(!toDate.equals(""))
							{
								tempDetailDate = detailDate + " 23:59";
								pstmt.setString(++count,adm_date);
								pstmt.setString(++count,tempDetailDate);
							}
						}
					}
				}
			}
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
				pstmt.setString(++count,contr_mod_accession_num);
			}
		}
	
		rs = pstmt.executeQuery();	
		maxRecord=0;
		while(rs.next())
		{
			maxRecord++;
		}
		
		if(maxRecord == 0)
		{
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block10Bytes, _wl_block10);

		}
/*Please do not uncomment this ---- the recordset and the statement should NOT be closed at this point...*/
//if(rs !=null) rs.close();
//if(pstmt !=null) pstmt.close();

		if(daySummary==10000)
		{
			daySummary = maxRecord;
		}

		if(!prevNextTen.equals("prevNextTen"))
		{

		if((maxRecord==0) || daySummary >= maxRecord || !flagString.equals("getDay"))
		{
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=''</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.title=''</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.title=''</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=''</script>");		
				
			}
		}
	}//end if if flagFromPrev

		if(flagValue.equals("") ||flagValue.equals("first"))
		{			
			rs.beforeFirst();
			start = 1 ;
			end = daySummary;
			int tempCount=0;
			int tempCountFirst = 0;
			tempDateArray = new ArrayList();
			while(rs.next())
			{			
				date = rs.getString(1)==null?"":rs.getString(1);
				//System.out.println("date from first:"+date+":");
				tokenDate = new StringTokenizer(date," ");
				tempDate = tokenDate.nextToken();
				tempCount ++;
				if(tempDate.equals(prevDate))
				{
					arrayResultType.add(rs.getString(3));
					if(tempCountFirst < 10)
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
					arrayResultType.add(rs.getString(3));
					if(tempCountFirst < 10)
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

			if(!prevNextTen.equals("prevNextTen"))
			{
				if(tempCountFirst > 10)
				{
					for(int j=1;j<=tempCountFirst;j+=10)
					{
						numOfPages++;
					}
				}
				else
				{
					numOfPages = 1;
				}
			}
			else
			{
				numOfPages = request.getParameter("numOfPages") == null ? 1 : Integer.parseInt(request.getParameter("numOfPages"));
			}

			
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
				if(!flagFromNext.equals("flagFromNext") && !flagString.equals("getDay") && intPrevFirstDate <= 1)
				{
					out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].prevTenRecs.disabled=true</script>");
				}
				else
				{
					out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].prevTenRecs.disabled=false</script>");
				}

				if(tempCountFirst <= 10 || intPrevFirstDate == numOfPages)
				{
					out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].nextTenRecs.disabled=true</script>");		
				}
				else
				{
					out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].nextTenRecs.disabled=false</script>");	
				}
			}

			if(!prevNextTen.equals("prevNextTen"))
			{

			if(!((start + daySummary) >= maxRecord) &&  tempCount != maxRecord && daySummary != 0)	
			{
			if(maxRecord !=0 && !(daySummary >= maxRecord) && flagString.equals(""))
			{
				if(!function_from.equals("SECONDARY_TRIAGE"))
				{
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true</script>");
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=''</script>");
					
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true</script>");
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=''</script>");
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.disabled=false</script>");
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.disabled=false</script>");
				}
				arraytempDate = new ArrayList();
				start = 1 ;
				end = daySummary;
				rs.afterLast();
				prevDate = "";
				tempDate="";
				while(rs.previous())
				{			
					date = rs.getString(1)==null?"":rs.getString(1);
					tokenDate = new StringTokenizer(date," ");
					tempDate = tokenDate.nextToken();
					if(tempDate.equals(prevDate))
					{
						if(!arraytempDate.contains(tempDate))
							arraytempDate.add(tempDate);
					}
					else
					{
							if(daySummary !=0)
							if(start > end && ! tempDate.equals(prevDate))  break;
							if(!arraytempDate.contains(tempDate))
							arraytempDate.add(tempDate);
							prevDate = tempDate;  
							start++;
					}
				}
				if(arraytempDate.size() !=0)
				{
				if(arraytempDate.size() > 1)
					toolTip.append((String)arraytempDate.get((arraytempDate.size()-1)) + " - " + (String)arraytempDate.get(0));
					else
					toolTip.append((String)arraytempDate.get(0));	
				}
				
				if(!toolTip.toString().equals("Records for Dates :"))
				{
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{
						out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForLast.value='"+toolTip.toString()+"'</script>");
					}
				}
		
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.title='"+toolTip.toString()+"'</script>");
			}
				toolTip = new StringBuffer("Records for Dates :");
				prevDate = "";
				rs.beforeFirst();
				arrayNext = new ArrayList();
				start = 1;
				end = daySummary;
				arraytempDate.clear();
				if(tempDateArray != null)
				{
					while(rs.next())
					{
						date = rs.getString(1)==null?"":rs.getString(1);
						tokenDate = new StringTokenizer(date," ");
						tempDate = tokenDate.nextToken();
						date = rs.getString(1)==null?"":rs.getString(1);
						tokenDate = new StringTokenizer(date," ");
						tempDate = tokenDate.nextToken();
					if(!tempDateArray.contains(date))
						{
							if(tempDate.equals(prevDate))
							{
										if(!arraytempDate.contains(tempDate))
										arraytempDate.add(tempDate);
							}
							else
							{
									if((start  > end) && !tempDate.equals(prevDate))  break;
									if(!arraytempDate.contains(tempDate))
										arraytempDate.add(tempDate);
									prevDate=tempDate;  	
									start++;

							}
								
						}
					}
					if(arraytempDate.size() !=0)
					{
					if(arraytempDate.size() > 1)
						toolTip.append((String)arraytempDate.get(0) + " - " +(String)arraytempDate.get((arraytempDate.size()-1)));
						else
						toolTip.append((String)arraytempDate.get(0));	
					}
				if(!toolTip.toString().equals("Records for Dates :"))	
				{
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{
						out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.title='"+toolTip.toString()+"'</script>");
					}
				}
				}

			
			}
		}
		else
		{

			if(daySummary == 0)
			{
				if(!function_from.equals("SECONDARY_TRIAGE"))
				{
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=false</script>");
									
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=false</script>");
					
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.disabled=false</script>");
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.disabled=false</script>");

					out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].prevTenRecs.disabled=true</script>");
				}				
			
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.click();</script>");
				
			}
			else
			{

			/**********************************/

			if(!function_from.equals("SECONDARY_TRIAGE") && daySummary != 0 && !prevNextTen.equals("prevNextTen"))
			{
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=''</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.title=''</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.title=''</script>");
			out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=''</script>");
		}
		}//end of else
		}
		}//end of if flagFromPrev
		
			
		}
		if(flagValue.equals("last"))
		{
			arraytempDate = new ArrayList();
			start = 1 ;
			end = daySummary;
			rs.afterLast();
			prevDate = "";
			tempDate="";
			tempDateArray = new ArrayList();
			arrayNext =  new ArrayList();
			while(rs.previous())
			{			
				date = rs.getString(1)==null?"":rs.getString(1);
				tokenDate = new StringTokenizer(date," ");
				tempDate = tokenDate.nextToken();
				if(tempDate.equals(prevDate))
				{
					arraytempDate.add(rs.getString(1) +"~" + rs.getString(3));
					
				}
				else
				{
						if(daySummary !=0)
						if(start > end && ! tempDate.equals(prevDate))  break;
						arraytempDate.add(rs.getString(1) +"~" + rs.getString(3));
						prevDate= tempDate;  
						start++;
				}
			}
			rs.beforeFirst();
			int tempArraySize = 0;
			while(rs.next())
			{
					tempDateArray.add(rs.getString(1));
			}
			for(int i=arraytempDate.size() - 1; i >= 0 ;i--)
			{
				if(tempArraySize < 10)
				{
					tempDate = (String)arraytempDate.get(i)==null ? "" :(String)arraytempDate.get(i);
					
					tokenColon = new StringTokenizer(tempDate,"~");
					tempDate = tokenColon.nextToken().trim();
					dateArray.add(tempDate);
					arrayNext.add(tempDate);
					arrayResultType.add(tokenColon.nextToken().trim());	
				}
				if(tempArraySize == 10)
				{
					datesForArray = tempDate;
				}
				tempArraySize++;
			}

			if(tempArraySize > 10)
			{
				for(int j=1;j<=tempArraySize;j+=10)
				{
					numOfPages++;
				}
			}
			else
			{
				numOfPages = 1;
			}

			if(maxRecord !=0 && !(daySummary > maxRecord))
			{
				
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.disabled=true</script>");
				
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.title=''</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.title=''</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=false</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=false</script>");
			}
				rs.beforeFirst();
				start = 1 ;
				end = daySummary;
				arraytempDate.clear();
				toolTip = new StringBuffer("Records for Dates :");
				while(rs.next())
				{			
					date = rs.getString(1)==null?"":rs.getString(1);
					tokenDate = new StringTokenizer(date," ");
					tempDate = tokenDate.nextToken();
					if(tempDate.equals(prevDate))
					{
						if(!arraytempDate.contains(tempDate))
						arraytempDate.add(tempDate);
					}
					else
					{
							
							if(daySummary !=0)
								if(start > end && ! tempDate.equals(prevDate))  break;
							if(!arraytempDate.contains(tempDate))
								arraytempDate.add(tempDate);
							prevDate=tempDate;  	
							start++;
					}
				}
				if(arraytempDate.size() !=0)
				{
					if(arraytempDate.size() > 1)
						toolTip.append((String)arraytempDate.get(0) + " - " +(String)arraytempDate.get((arraytempDate.size()-1)));
						else
						toolTip.append((String)arraytempDate.get(0));	
				}
				if(!toolTip.toString().equals("Records for Dates :"))
				{
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{	
						out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title='"+toolTip.toString()+"'</script>");
					}
				}
				if(!function_from.equals("SECONDARY_TRIAGE"))
				{
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForFirst.value='"+toolTip.toString()+"'</script>");
				}

			for(int i=0; i < tempDateArray.size();i++)
				{
					tempPrevDate.add(tempDateArray.get(i));
				}
				for(int i=0; i < arrayNext.size();i++)
				{
					tempArrayNext.add(arrayNext.get(i));
				}
				int index =0;
				for(int i=0; i <tempArrayNext.size();i++)
				{
					if((index=tempPrevDate.indexOf((String)tempArrayNext.get(i)))!=-1)
					{
						tempPrevDate.remove(index);
					}
				}
				prevDate ="";
				start = 1;
				toolTip = new StringBuffer("Records for Dates :");
				end = daySummary;
				for(int i=(tempPrevDate.size()-1); i>=0;i--)
				{
					tokenDate = new StringTokenizer((String)tempPrevDate.get(i)," ");
					tempDate =tokenDate.nextToken();
					if(tempDate.equals(prevDate))						
					{
						if(!arraytempDate.contains(tempDate))
							arraytempDate.add(tempDate);
					}
					else
					{
						if(start > end && !tempDate.equals(prevDate)) break;
						if(!arraytempDate.contains(tempDate))
							arraytempDate.add(tempDate);
							prevDate = tempDate;
							start++;
					}

				}
				if(arraytempDate.size() !=0)
				{
					if(arraytempDate.size() > 1)
						toolTip.append((String)arraytempDate.get((arraytempDate.size()-1))+ " - "+(String)arraytempDate.get(0) );
						else
						toolTip.append((String)arraytempDate.get(0));	
				}
				if(!toolTip.toString().equals("Records for Dates :"))
				{
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{
						out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title='"+toolTip.toString()+"'</script>");
					}
				}

			
			}

	}
		if(flagValue.equals("Next"))
		{
			try
			{
			int tempIntNext = 0;
			prevDate = "";
			rs.beforeFirst();
			arrayNext = new ArrayList();
			start = 1;
			end = daySummary;
			arraytempDate = new ArrayList();
			while(rs.next())
			{	
				date = rs.getString(1)==null?"":rs.getString(1);
				tokenDate = new StringTokenizer(date," ");
				tempDate = tokenDate.nextToken();
				if(tempDateArray != null)
				{
						
						if(!tempDateArray.contains(date))
						{
							if(tempDate.equals(prevDate))
							{
										arrayResultType.add(rs.getString(3));
										if(tempIntNext < 10)
										{
											dateArray.add(date);
										}
										if(tempIntNext == 10)
										{
											datesForArray = date;
										}
										if(!tempDateArray.contains(tempDate))
										tempDateArray.add(date);
										arrayNext.add(date);
										
							}
							else
							{
									if((start  > end) && !tempDate.equals(prevDate))  break;
									arrayResultType.add(rs.getString(3));
									if(tempIntNext < 10)
									{
										dateArray.add(date);
									}
									if(tempIntNext == 10)
									{
										datesForArray = date;
									}
									prevDate=tempDate;  	
									tempDateArray.add(date);
									arrayNext.add(date);
									start++;

							}
							tempIntNext++;
						}
				}
		}

		if(tempIntNext > 10)
		{
			for(int j=1;j<=tempIntNext;j+=10)
			{
				numOfPages++;
			}
		}
		else
		{
			numOfPages = 1;
		}

		prevDate = "";
		start = 1;
		end =daySummary;
		toolTip = new StringBuffer("Records for Dates :");
		if(rs.previous())
		while(rs.next())
		{
			date = rs.getString(1)==null?"":rs.getString(1);
			tokenDate = new StringTokenizer(date," ");
			tempDate = tokenDate.nextToken();
			if(tempDate.equals(prevDate))
			{
					if(!arraytempDate.contains(tempDate))
						arraytempDate.add(tempDate);
				
			}
			else
			{
				if((start  > end) && !tempDate.equals(prevDate))  break;
				if(!arraytempDate.contains(tempDate))
					arraytempDate.add(tempDate);
					prevDate=tempDate;  	
					start++;
			}
		}

		if(arraytempDate.size() !=0)
				{
					if(arraytempDate.size() > 1)
						toolTip.append((String)arraytempDate.get(0) + " - " +(String)arraytempDate.get((arraytempDate.size()-1)));
						else
						toolTip.append((String)arraytempDate.get(0));	
				}
				if(!toolTip.toString().equals("Records for Dates :"))
				{	
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{
						out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.title='"+toolTip.toString()+"'</script>");
					}
				}
		toolTip = new StringBuffer("Records for Dates :");
		
		for(int i=0; i < tempDateArray.size();i++)
		{
			tokenDate = new StringTokenizer((String)tempDateArray.get(i)," ");
			tempDate = tokenDate.nextToken();
			if(!tempPrevDate.contains(tempDate))
				tempPrevDate.add(tempDate);
		}
		for(int i=0; i < arrayNext.size();i++)
		{
			tokenDate = new StringTokenizer((String)arrayNext.get(i)," ");
			tempDate = tokenDate.nextToken();
			if(!tempArrayNext.contains(tempDate))
				tempArrayNext.add(tempDate);

		}
		int index =0;
			
		for(int j=0;j <tempArrayNext.size();j++)
				{
						if((index=tempPrevDate.indexOf((String)tempArrayNext.get(j)))!=-1)
						{
							tempPrevDate.remove(index);
						}
				}
				
				if(tempPrevDate.size() !=0)
				{
					if(tempPrevDate.size() > end)
					{
					if(daySummary > 1)	
						{
							for(int i=0,j=0;j<daySummary;j++)
								{
									
										
										tempPrevDate.remove(i);
								}
						}
					}
					
					if(daySummary > 1)
					{
						int i=0,j=0;
						start =1;
						end = daySummary;
						
						if(tempPrevDate.size() > daySummary)
						{
							while(i < tempPrevDate.size())
							{
								if(start > end) break;
								start++;
								i++;
								 tempPrevDate.remove(j);
							}
						}
					if(tempPrevDate.size() > 1)
						{
						toolTip.append((String)tempPrevDate.get(0) + " - " +(String)tempPrevDate.get((tempPrevDate.size()-1)));
						}
						else
						toolTip.append((String)tempPrevDate.get(0));	
					}
					else
					{
						toolTip.append((String)tempPrevDate.get((tempPrevDate.size()-1)));	
					}
				}
				
				if(!toolTip.toString().equals("Records for Dates :"))
				{
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{
						out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title='"+toolTip.toString()+"'</script>");
					}
				}
				if(!function_from.equals("SECONDARY_TRIAGE"))
				{
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=false</script>");
					out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForFirst.value</script>");
				}

		if(tempDateArray.size()==maxRecord)
		{
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
			out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.disabled=true</script>");
			out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.title=''</script>");
			out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.disabled=true</script>");
			out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.title=''</script>");
			}
			
		}
		else
		{
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.disabled=false</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.disabled=false</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.title=parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForLast.value</script>");
			}
		}
		if(tempPrevDate.size()==0)
		{
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=''</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=''</script>");
			}
		}
		else
		{
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=false</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=false</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForFirst.value</script>");
			}
		}

		if(!function_from.equals("SECONDARY_TRIAGE"))
		{
			if(tempIntNext <= 10)
			{
				out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].prevTenRecs.disabled=true</script>");
				out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].nextTenRecs.disabled=true</script>");
			}
			else
			{
				out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].nextTenRecs.disabled=false</script>");
			}
		}		
		}//end of try-next
		catch(Exception nextExcep)
		{
			//out.println("Exception in try-next :"+nextExcep.toString());//COMMON-ICN-0181
			nextExcep.printStackTrace(System.err);
		}
	}
	if(flagValue.equals("Prev"))
	{
		int tempIntPrev = 0;
			start = 1;
			end = daySummary;
			rs.afterLast();
			arraytempDate = new ArrayList();
			prevDate = "";
			tempDate="";
			int index=0;
			if(tempDateArray !=null && arrayNext != null)
			{
					for(int j=0;j <arrayNext.size();j++)
					{
						if((index=tempDateArray.indexOf((String)arrayNext.get(j)))!=-1)
						{
							tempDateArray.remove(index);
						}
					}
			}
			prevDate="";
			for(int i=0; i <arrayNext.size();i++)
				{
					tokenDate =new StringTokenizer((String)arrayNext.get(i)," ");
					tempDate=tokenDate.nextToken();	
					if(!tempArrayNext.contains(tempDate))
					{
						tempArrayNext.add(tempDate);
					}
				}
			for(int i=(tempDateArray.size()-1);i>=0;i--)		
			{
				tokenDate = new StringTokenizer((String)tempDateArray.get(i)," ");
				tempDate = tokenDate.nextToken();
				if(tempDate.equals(prevDate))
						{
							
							arraytempDate.add((String)tempDateArray.get(i));

						}
						else
						{
							if(start > end  && !tempDate.equals(prevDate)) break;
							arraytempDate.add((String)tempDateArray.get(i));
							  prevDate=tempDate;
							start++;		
						}
					
			}
			for(int i=(arraytempDate.size()-1);i>=0;i--)		
			{
				if(tempIntPrev < 10)
				{
					dateArray.add((String)arraytempDate.get(i));
				}
				if(tempIntPrev == 10)
				{
					datesForArray = (String)arraytempDate.get(i);
				}
				tempIntPrev++;
				arrayNext.add((String)arraytempDate.get(i));					
			}

			if(tempIntPrev > 10)
			{
				for(int j=1;j<=tempIntPrev;j+=10)
				{
					numOfPages++;
				}
			}
			else
			{
				numOfPages = 1;
			}

			rs.beforeFirst();
			while(rs.next())
			{
					date = rs.getString(1)==null?"":rs.getString(1);
					//System.out.println("date from Prev:"+date+":");
					if(dateArray.contains(date))
					{
						arrayResultType.add(rs.getString(3));
					}
			}
		
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.disabled=false</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.title=parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForLast.value</script>");
			}

			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
				if(tempIntPrev < 10)
				{
					out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].prevTenRecs.disabled=true</script>");
					out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].nextTenRecs.disabled=true</script>");
				}
				else
				{
					out.println("<script>parent.ChartRecordingControlsFrame.document.forms[0].nextTenRecs.disabled=false</script>");
				}
			}

toolTip = new StringBuffer("Records for Dates :");
	if(tempArrayNext.size() !=0)
				{
					if(tempArrayNext.size() > 1)
						toolTip.append((String)tempArrayNext.get(0) + " - " +(String)tempArrayNext.get((tempArrayNext.size()-1)));
						else
						toolTip.append((String)tempArrayNext.get(0));	
				}
				if(!toolTip.toString().equals("Records for Dates :"))
				{
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{
						out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.title='"+toolTip.toString()+"'</script>");
					}
				}
				for(int i=0; i < arrayNext.size();i++)
				{
					tokenDate = new StringTokenizer((String)arrayNext.get(i)," ");
					tempDate = tokenDate.nextToken();
					if(!tempArrayNext.contains(tempDate))
					tempArrayNext.add(tempDate);
				}
				for(int i=0; i < tempDateArray.size();i++)
				{
					tokenDate = new StringTokenizer((String)tempDateArray.get(i)," ");
					tempDate = tokenDate.nextToken();
					if(!tempPrevDate.contains(tempDate))
					tempPrevDate.add(tempDate);
				}
				for(int i=0;i <tempArrayNext.size();i++)
				{
					if((index=tempPrevDate.indexOf((String)tempArrayNext.get(i)))!=-1)
					{
						tempPrevDate.remove(index);
					}
				}
				
			tempArrayList = new ArrayList();	
			toolTip = new StringBuffer("Records for Dates :");
			start =1;
			end = daySummary;
			for(int i=(tempPrevDate.size()-1); i >=0 ;i--)
			{
				tempArrayList.add((String)tempPrevDate.get(i))	;
				if(start == end) break;
				start++;
			}
			
			if(tempArrayList.size() !=0)
				{
					if(tempArrayList.size() > 1)
					{
					
						toolTip.append((String)tempArrayList.get((tempArrayList.size()-1))+ " - " +(String)tempArrayList.get(0));
					}
						else
						toolTip.append((String)tempArrayList.get(0));	
				}
				if(!toolTip.toString().equals("Records for Dates :"))
				{
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{	out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title='"+toolTip.toString()+"'</script>");
					}
				}
		if(tempDateArray.size()==maxRecord)
		{
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{

				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.title=''</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.title=''</script>");
			}
		}
		else
		{
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{

				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonNext.disabled=false</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.disabled=false</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonLast.title=parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForLast.value</script>");
			}
		}
		if(tempArrayList.size() ==0)
		{
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{

				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.title=''</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=true</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=''</script>");
			}
	
		}
		else
		{
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{

				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonPrev.disabled=false</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.disabled=false</script>");
				out.println("<script>parent.ChartRecordingCriteriaFrame.document.forms[0].buttonFirst.title=parent.ChartRecordingCriteriaFrame.document.forms[0].toolTipForFirst.value</script>");
			}
		}

//modified here


	}
		//Normal Range:     Critical Range: 
		String Normal_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels");
		
		String Critical_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Range.label","common_labels");
		count=0;
		StringBuffer sql = new StringBuffer();
		if(detailYN.equals("Y"))
		{
			//sql.append("select  b.PANEL_DISP_ORDER_SEQ,b.DISCR_DISP_ORDER_SEQ,a.TEST_OBSERV_DT_TM ,a.DISCR_MSR_PANEL_OR_FORM_ID CHART_GROUP_ID, a.DISCR_MSR_ID, a.NORM_ABNORM_IND , to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi') dt   , a.DISCR_MSR_RESULT_TYPE, a.DISCR_MSR_RESULT_NUM , a.DISCR_MSR_RESULT_NUM_UOM ,a.DISCR_MSR_RESULT_STR, a.TEST_OBSERV_DT_TM, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,'HIGH',LOW_STR,'LOW',CRIT_STR,'CRITICAL',ABN_STR,'ABNORMAL',CRIT_HIGH_STR,'CRITICALHIGH',CRIT_LOW_STR  ,'CRITICALLOW','') FROM CR_CLIN_EVENT_PARAM)  normal_range_color,rtrim('Normal Range: '||to_char(NORMAL_LOW)||'~'||to_char(NORMAL_HIGH)||' ' ,'Normal Range: ~ ' ) normal_str, rtrim('Critical Range: '||CRITICAL_LOW   ||'~'||CRITICAL_HIGH||''   , 'Critical Range:  ~ ' ) critical_str from CA_ENCNTR_DISCR_MSR a, "+tempString+"  where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.discr_msr_id and   a.facility_id=? and a.patient_id=?   ");
			  sql.append("select  b.PANEL_DISP_ORDER_SEQ,b.DISCR_DISP_ORDER_SEQ,a.TEST_OBSERV_DT_TM ,a.DISCR_MSR_PANEL_OR_FORM_ID CHART_GROUP_ID, a.DISCR_MSR_ID, a.NORM_ABNORM_IND , to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi') dt   , a.DISCR_MSR_RESULT_TYPE, a.DISCR_MSR_RESULT_NUM , a.DISCR_MSR_RESULT_NUM_UOM ,a.DISCR_MSR_RESULT_STR, a.RESULT_NUM_PREFIX, a.TEST_OBSERV_DT_TM, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,HIGH_COLOR_CODE,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,ABN_COLOR_CODE,CRIT_HIGH_STR,CRIT_HIGH_COLOR_CODE,CRIT_LOW_STR  ,CRIT_LOW_COLOR_CODE,'') FROM CR_CLIN_EVENT_PARAM) normal_range_color,to_char(NORMAL_LOW) NORMAL_LOW ,to_char(NORMAL_HIGH) NORMAL_HIGH , to_char(CRITICAL_LOW) CRITICAL_LOW ,to_char(CRITICAL_HIGH) CRITICAL_HIGH from CA_ENCNTR_DISCR_MSR a, "+tempString+"  where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.discr_msr_id and   a.facility_id=? and a.patient_id=?   ");
			
			if(defaultYN.equals("Y"))
			{
				sql.append(" and   b.ENCOUNTER_ID = ? and  b.FACILITY_ID = ?  ");
			}
			if(daySummary !=0)
			{
				if(fromDate.equals("") && toDate.equals(""))
				{
					sql.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");
				}
				if(!fromDate.equals("") && !toDate.equals(""))
				{
					sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi') ");
				}
				else
				{
					if(!fromDate.equals(""))
							sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");
					if(!toDate.equals(""))
						sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
				}
			}
			else
			{
				if(!detailDate.equals(""))
				{
						sql.append(" and a.TEST_OBSERV_DT_TM  >=  to_date(?,'dd/mm/yyyy')  and a.TEST_OBSERV_DT_TM  <= to_date(?,'dd/mm/yyyy')+(?+0.99) ");
				}
				else
				{
					sql.append(" and a.TEST_OBSERV_DT_TM between trunc(sysdate) and  sysdate ");

				}
			}
	
	//--------Rajan Addition
			sql.append(" and a.DISCR_MSR_RESULT_TYPE in ('C','D','E','N','A','I','L','F','H','T') ");
			if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
			{
				sql.append(" and CONTR_MODULE_TRANS_REF=?");
			}
		}
		if(detailYN.equals("Y") && summaryYN.equals("Y"))
		sql .append(" Union all ");
		if(summaryYN.equals("Y"))
		{
		//sql.append(" select b.PANEL_DISP_ORDER_SEQ,b.DISCR_DISP_ORDER_SEQ,a.TEST_OBSERV_DT_TM ,a.DISCR_MSR_PANEL_OR_FORM_ID CHART_GROUP_ID, B.DISCR_MSR_ID DISCR_MSR_ID, a.NORM_ABNORM_IND , to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi') dt   , a.DISCR_MSR_RESULT_TYPE, a.DISCR_MSR_RESULT_NUM , a.DISCR_MSR_RESULT_NUM_UOM , decode(SUMMARY_TYPE,'AVERAGE','AVG',substr(SUMMARY_TYPE,1,3)) DISCR_MSR_RESULT_STR, a.TEST_OBSERV_DT_TM, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,'HIGH',LOW_STR,'LOW',CRIT_STR,'CRITICAL',ABN_STR,'ABNORMAL',CRIT_HIGH_STR,'CRITICALHIGH',CRIT_LOW_STR  ,'CRITICALLOW','') FROM CR_CLIN_EVENT_PARAM)  normal_range_color,rtrim('Normal Range: '||to_char(NORMAL_LOW)||'~'||to_char(NORMAL_HIGH)||' ' ,'Normal Range: ~ ' ) normal_str, rtrim('Critical Range: '||CRITICAL_LOW   ||'~'||CRITICAL_HIGH||''   , 'Critical Range:  ~ ' ) critical_str from CA_ENCNTR_DISCR_MSR a, "+tempString+"  where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.SUMMRY_COLUMN and  a.facility_id=? and a.patient_id=?   ");
		  sql.append(" select b.PANEL_DISP_ORDER_SEQ,b.DISCR_DISP_ORDER_SEQ,a.TEST_OBSERV_DT_TM ,a.DISCR_MSR_PANEL_OR_FORM_ID CHART_GROUP_ID, B.DISCR_MSR_ID DISCR_MSR_ID, a.NORM_ABNORM_IND , to_char(a.TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi') dt   , a.DISCR_MSR_RESULT_TYPE, a.DISCR_MSR_RESULT_NUM , a.DISCR_MSR_RESULT_NUM_UOM , a.RESULT_NUM_PREFIX, decode(SUMMARY_TYPE,'AVERAGE','AVG',substr(SUMMARY_TYPE,1,3)) DISCR_MSR_RESULT_STR, a.TEST_OBSERV_DT_TM, (select DECODE(a.NORM_ABNORM_IND,HIGH_STR,HIGH_COLOR_CODE,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,ABN_COLOR_CODE,CRIT_HIGH_STR,CRIT_HIGH_COLOR_CODE,CRIT_LOW_STR  ,CRIT_LOW_COLOR_CODE,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_color,to_char(NORMAL_LOW) NORMAL_LOW ,to_char(NORMAL_HIGH) NORMAL_HIGH ,to_char(CRITICAL_LOW) CRITICAL_LOW ,to_char(CRITICAL_HIGH) CRITICAL_HIGH from CA_ENCNTR_DISCR_MSR a, "+tempString+"  where b.CHART_ID=? and nvl(a.ERROR_YN,'N') != 'Y' and a.chart_id=b.chart_id and a.DISCR_MSR_PANEL_OR_FORM_ID=b.PANEL_ID and a.discr_msr_id=b.SUMMRY_COLUMN and  a.facility_id=? and a.patient_id=?   ");
		if(defaultYN.equals("Y"))
		{
			sql.append(" AND   B.ENCOUNTER_ID = ? AND  B.FACILITY_ID = ?  ");
		}
		if(daySummary ==0)
		{
			if(!detailDate.equals(""))
			{
						sql.append(" and a.TEST_OBSERV_DT_TM  >=  to_date(?,'dd/mm/yyyy')  and a.TEST_OBSERV_DT_TM  <= to_date(?,'dd/mm/yyyy')+(?+0.99) ");
			}
			else
			{
					sql.append(" and a.TEST_OBSERV_DT_TM between trunc(sysdate) and  sysdate ");
			}
		}
		else
		{
			if(fromDate.equals("") && toDate.equals(""))
			{
				sql.append("  and a.TEST_OBSERV_DT_TM   between to_date(?,'dd/mm/yyyy hh24:mi') and  trunc(sysdate) + 0.99 ");
			}
			if(!fromDate.equals("") && !toDate.equals(""))
			{
				sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and to_date(?,'dd/mm/yyyy hh24:mi') ");
			}
			else
			{
				if(!fromDate.equals(""))
						sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   trunc(sysdate) + 0.99 ");
				if(!toDate.equals(""))
					sql.append("  and a.TEST_OBSERV_DT_TM between to_date(?,'dd/mm/yyyy hh24:mi') and   to_date(?,'dd/mm/yyyy hh24:mi') ");
			}
		}
		sql.append(" and a.DISCR_MSR_RESULT_TYPE ='S' ");
		if(!(contr_mod_accession_num.equals("")&&module_id.equals("")))
		{
			sql.append(" and CONTR_MODULE_TRANS_REF=?");
		}
	}
	
	 if(sort_by.equals("D"))
		sql.append(" order by  1,2,3 desc ");
	 else 
		sql.append(" order by  1,2,3 ");

	
	try
	{
	pstmt = con.prepareStatement(sql.toString());
	if(detailYN.equals("Y"))
		{
			pstmt.setString(++count,chartId);
			pstmt.setString(++count,facilityId);
			pstmt.setString(++count,patientId);
			
			if(defaultYN.equals("Y"))
			{
					pstmt.setString(++count,encounterId);
					pstmt.setString(++count,facilityId);
			}
			if(daySummary !=0)
			{
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
			}
			else
			{
				if(!detailDate.equals(""))
				{
					pstmt.setString(++count,detailDate);
					pstmt.setString(++count,detailDate);
					pstmt.setInt(++count,noOfDays);
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
	pstmt.setString(++count,facilityId);
	pstmt.setString(++count,patientId);
	

	if(defaultYN.equals("Y"))
	{
		pstmt.setString(++count,encounterId);
		pstmt.setString(++count,facilityId);
		
	}
	if(daySummary ==0)
	{
		if(!detailDate.equals(""))
		{
				pstmt.setString(++count,detailDate);
				pstmt.setString(++count,detailDate);
				pstmt.setInt(++count,noOfDays);
		}
	}
	else
	{
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
		System.out.println("Exception in Encntr - try of ChartRecordingListPopulation.jsp="+encntrExcep.toString());
	}


		String chartGrpId="",eventType="",value="",prefix="";
		String prevGrpId = "";
		String prevDiscrMsrId = "";
		String eventDate = "",discritMsrId ="";
		String normalStr="",normalRangeColor = "",criticalStr = "";
		HashMap setOfValues = null;
		String normal_low,normal_high,critical_low,critical_high;
		while(rs.next())
		{	
			eventDate = rs.getString("dt")==null?"":rs.getString("dt");
		
			for(int i=0;i<dateArray.size();i++)
			{
				tempDate = dateArray.get(i) ==null ? "" :(String) dateArray.get(i);
			
				if(eventDate.equals(tempDate))
				{
					chartGrpId		= rs.getString("CHART_GROUP_ID")==null?"":rs.getString("CHART_GROUP_ID");
					discritMsrId	= rs.getString("DISCR_MSR_ID")==null?"&nbsp;":rs.getString("DISCR_MSR_ID");
					eventType		= rs.getString("DISCR_MSR_RESULT_TYPE")==null?"":rs.getString("DISCR_MSR_RESULT_TYPE");

					if(eventType.equals("L"))
					{
						if(rs.getString("DISCR_MSR_RESULT_NUM") != null || rs.getString("DISCR_MSR_RESULT_STR") != null)	
						{
							value = (rs.getString("DISCR_MSR_RESULT_NUM")==null?" ":rs.getString("DISCR_MSR_RESULT_NUM")) +"||"+(rs.getString("DISCR_MSR_RESULT_STR")==null?"X":rs.getString("DISCR_MSR_RESULT_STR")) ;
						}
						else
							value = "";
					}
					else if(!eventType.equals("S"))
					{					
						if(eventType.equals("N")||eventType.equals("A")||eventType.equals("I"))
						{
							prefix = rs.getString("RESULT_NUM_PREFIX")==null?"":rs.getString("RESULT_NUM_PREFIX");
							value = rs.getString("DISCR_MSR_RESULT_NUM")==null?"":rs.getString("DISCR_MSR_RESULT_NUM");
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
						if(eventType.equals("S"))
							value = rs.getString("DISCR_MSR_RESULT_NUM")==null?"":rs.getString("DISCR_MSR_RESULT_NUM")+(rs.getString("DISCR_MSR_RESULT_STR")==null?"": " ("+rs.getString("DISCR_MSR_RESULT_STR")+")") ;
						else
							value = rs.getString("DISCR_MSR_RESULT_STR")==null?"":rs.getString("DISCR_MSR_RESULT_STR");
					}

			/*	NORM_ABNORM_IND = rs.getString("normal_range_color")==null?"":rs.getString("normal_range_color");
				//
				//out.println("NORM_ABNORM_IND:"+NORM_ABNORM_IND);
				if  (NORM_ABNORM_IND.equals("HIGH"))
					normalRangeColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");										
				else if(NORM_ABNORM_IND.equals("LOW"))
					normalRangeColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels");
				else if(NORM_ABNORM_IND.equals("CRITICAL"))
					normalRangeColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
				else if(NORM_ABNORM_IND.equals("ABNORMAL"))
					normalRangeColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Abnormal.label","ca_labels");
				else if(NORM_ABNORM_IND.equals("CRITICALHIGH"))
					normalRangeColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");
				else if(NORM_ABNORM_IND.equals("CRITICALLOW"))
					normalRangeColor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels");
				else
					normalRangeColor="";
				*/
				//
				normalRangeColor = rs.getString("normal_range_color")==null?"":rs.getString("normal_range_color");

				//normalStr = rs.getString("normal_str")==null?"":rs.getString("normal_str");
				//criticalStr = rs.getString("critical_str")==null?"":rs.getString("critical_str");
				normal_low= rs.getString("NORMAL_LOW")==null?"":rs.getString("NORMAL_LOW");
				normal_high= rs.getString("NORMAL_HIGH")==null?"":rs.getString("NORMAL_HIGH");
				critical_low= rs.getString("CRITICAL_LOW")==null?"":rs.getString("CRITICAL_LOW");
				critical_high= rs.getString("CRITICAL_HIGH")==null?"":rs.getString("CRITICAL_HIGH");
				
				//System.out.println("normal_low..."+normal_low);
				//System.out.println("normal_high..."+normal_high);
				//System.out.println("critical_low..."+critical_low);
				//System.out.println("critical_high..."+critical_high);

				if(!normal_low.equals("")|| !normal_high.equals(""))
				normalStr = Normal_Range+" : "+normal_low+" ~ "+normal_high;
				else
				normalStr =""; //Normal_Range+" : ~ ";
				
				if(!critical_low.equals("")|| !critical_high.equals(""))
				{
				criticalStr = Critical_Range +" : "+ critical_low+" ~ "+normal_low ;
				criticalStr = criticalStr+ " & "+ normal_high+" ~ "+critical_high ;
				}
				else
				criticalStr = "";//Critical_Range +" : ~ " ;
				//change the event
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
				//System.out.println("normalRangeColor ================"+normalRangeColor);	
				setOfValues.put("VALUE_DATE",eventDate);
				ValArray.add(setOfValues);	
				if(!(prevGrpId.equals(chartGrpId))|| !(prevDiscrMsrId.equals(discritMsrId)))
				{
					dataHash.put(chartGrpId+"~"+discritMsrId,ValArray);
					prevGrpId = chartGrpId;
					prevDiscrMsrId=discritMsrId;
					
				}
			}
		 }
		}
	//	if(rs!=null) rs.close();
		//if(pstmt!=null) pstmt.close();		
	}
	
	catch(Exception e)
	{
		//out.println(" from Charting Recording List Population :"+e.toString());//COMMON-ICN-0181
		e.printStackTrace(System.err);
	}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	out.println("<input type='hidden' name='flagValue' id='flagValue' value='"+flagValue+"'>");
	
            _bw.write(_wl_block1Bytes, _wl_block1);
if(dataHash!=null)
{

            _bw.write(_wl_block11Bytes, _wl_block11);

	if(!function_from.equals("SECONDARY_TRIAGE"))
	{

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(flagString));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
}//end of if dataHash != null

            _bw.write(_wl_block15Bytes, _wl_block15);

	
	finalHash = dataHash;
	ArrayList dates = dateArray;
	HashMap hashData = (HashMap)session.getValue("chartEvents"+encounterId);
	ArrayList arrayChartGrp = (ArrayList)session.getValue("chartGrp"+encounterId);

	if(dates.size()>0)
	{
            _bw.write(_wl_block16Bytes, _wl_block16);

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

	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tabWidth));
            _bw.write(_wl_block19Bytes, _wl_block19);

					StringTokenizer tokenizeSpace = null;
					String dt = "";
					String currDate="";
					String prevDateTemp = "";
					//String firstToken = "";
					String dummyDateString = "";
					String datesForPrevNext = "";
					StringBuffer dummyDateStringForGraph = new StringBuffer();
					//StringTokenizer tokenizeColon = null;	
					int ii=0;
					int index=0;
					boolean flag = true;;
					int actualIndex = 0;
					if(dates!=null)
					{
						for(ii=0;ii<dates.size();ii++)
						{
							dt = (String)dates.get(ii);
							if(ii == 0) prevFirstDate = prevFirstDate + "~" +dt;
							
							//out.println("<script>alert('intPrevFirstDate :"+intPrevFirstDate+"       prevFirstDate:"+prevFirstDate+"');</script>");

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
							if(!currDate.equals(prevDateTemp)){
								
								out.println("<td class='columnHeadercenter' width='"+widPc+"px' id='rowId"+index+"'>"+com.ehis.util.DateUtils.convertDate(currDate,"DMY","en",locale)+"</td>");
								prevDateTemp =currDate;
								actualIndex = index;
								index++;
							}
							else
							{
								
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(actualIndex));
            _bw.write(_wl_block21Bytes, _wl_block21);
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
							if(!currDate.equals(prevDateTemp)){
								dummyDateString = currDate1;
								currDate1= currDate1.replace('/','_');
								if(dummyString.equals("S"))currDate="Day Summary";
								if(currDate.equals("Day Summary"))
								{
									anchorObj = "";
									anchorObjEnd = "";								
								}
								else if(!currDate.equals("Day Summary"))
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
								strSuminthai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DaySummary.label","ca_labels");

							
									
								out.println("<td class='columnHeadercenter'  nowrap width='"+120+"px' id='thId"+currDate1+ii+"'> "+anchorObj+" "+strSuminthai+" "+anchorObjEnd+" </td>");
								prevDateTemp =currDate;
								
							}
							else
							{
								
								
								if(dummyString.equals("S"))
									currDate="DAY/SUM";
								String strsum_thai=currDate;
								if(strsum_thai.equals("DAY/SUM"))
									strsum_thai=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Daysum.label","ca_labels");

								out.println("<td class='columnHeadercenter'  width='"+widPc+"px' id='thId"+currDate1+ii+"'>"+strsum_thai+"</td>");
							}
						}
					}
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ii));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(defaultYN));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block29Bytes, _wl_block29);

					ArrayList cols = new ArrayList();
					ArrayList discrArray = new ArrayList();
					HashMap setOfValues = new HashMap();
					String printVal = "";
					String classValue = "CACHARTQRYEVEN";
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
					 String tooltip = "";
					String currEventDate="";
					String hiddenValueForGraph="";
					String hiddenDateForGraph="";
					int z =0 ;int indexK = 0;int k=0;
					int tempIntForGraph = 0;

					for( indexJ= 0 ; indexJ < arrayChartGrp.size();indexJ++){
							flag = true;
							index = 0;
							currGroupId = (String)arrayChartGrp.get(indexJ)==null ? "" : (String)arrayChartGrp.get(indexJ) ;
							discrArray	= (ArrayList)hashData.get(currGroupId); 
							out.println("<tr>");
							for(k=0;k<dates.size();k++)
							{
								out.println("<td width='"+widPc+"px' class='CACHARTFOURTHLEVELCOLOR' >&nbsp;</td>");
							}
							out.println("</tr>");
							for(indexK =0 ;indexK <discrArray.size();indexK++)
							{
								discrMsrId = (String)discrArray.get(indexK);
								out.println("<tr id='tdrowId"+indexJ+indexK+"'>");

								cols = (ArrayList)finalHash.get(currGroupId+"~"+discrMsrId);
								for(k=0,z=0;k<dates.size();k++)
								{
									if(cols != null){
										hiddenDateForGraph = " ";
										hiddenValueForGraph = " ";
									if(cols.size() > z)
										{
										setOfValues = (HashMap)cols.get(z);
										 eventDate = (String)dates.get(k);
										
										 currEventDate = (String)(setOfValues.get("VALUE_DATE"))==null ? "" : (String)(setOfValues.get("VALUE_DATE"));
										if(currEventDate.equals(eventDate))
										{
											printVal = (String)setOfValues.get("VALUE")== null ? "" :(String)setOfValues.get("VALUE") ;
											normalStr = (String)(setOfValues.get("NORMALSTR")==null?"":setOfValues.get("NORMALSTR"));
											normalRangeColor = (String)(setOfValues.get("COLOR")==null?"":setOfValues.get("COLOR"));

											criticalStr = (String)(setOfValues.get("CRITICALSTR")==null?"":setOfValues.get("CRITICALSTR"));
											/*commented by Jyothi on 15/05/2007 as it is not used anywhere. This has been done while fixing the SCF SRR20056-SCF-0386 
											if(!(normalStr.equals("")) || ! (criticalStr.equals("")))
											{

												tokenizeColon = new StringTokenizer(normalStr,":");
												firstToken = tokenizeColon.nextToken();
												firstToken = tokenizeColon.nextToken().trim();
												tokenizeSpace = new StringTokenizer(firstToken,"~");
											}*/
											result_type = (String)(setOfValues.get("RESULT_TYPE")==null?"":setOfValues.get("RESULT_TYPE"));
											if(result_type.equals("L")){
												if(!printVal.equals("")){
													if(printVal.indexOf("||") !=-1){
															tokenizeSpace =  new StringTokenizer(printVal,"||");
															tempString1 = tokenizeSpace.nextToken();

															tempStringTemp = tokenizeSpace.nextToken();
															
															if(tempStringTemp.length() > 9)
															{
																tempStringBuffer = new StringBuffer(tempStringTemp);
																index=0;
																
																	tempStringBuffer = tempStringBuffer.replace(index,index+tempStringTemp.length()," <label title='"+tempStringTemp+"' class='LABELFORDISCRETE'>"+tempStringTemp.substring(0,5) +"..."+" </label> ");
																	printVal = tempStringBuffer.toString();
																	


															}
															 else
															{
																	printVal=tempStringTemp;

															}	
													}
													printVal = tempString1 + " " + printVal;
												}		
											}
											if(flag==true){
												if(!printVal.equals(""))
												{
													if(!normalStr.equals("") && !criticalStr.equals(""))
														tooltip = normalStr+", "+criticalStr;
													else if(!normalStr.equals(""))
														tooltip = normalStr;
													else if(!criticalStr.equals(""))
														tooltip = criticalStr;
													else
														tooltip="";
												}
												else
												{
													tooltip="";
												}
											}
											if(!result_type.equals("S")){
											if(!normalRangeColor.equals(""))
											{
												//classValue = normalRangeColor;
												styleValue = "STYLE= 'FONT-SIZE: 7PT;BORDER-STYLE: THIN ;background-color:"+normalRangeColor+"' ";
											}
											else
											{
													if((indexK%2)==0)
													{
														classValue	=	"CACHARTQRYEVEN";
														styleValue = "class = '"+classValue+"' ";
													}
													else
													{
														classValue	=	"CACHARTQRYEVEN";
														styleValue = "class = '"+classValue+"' ";
													}
												}
											}
											else if(result_type.equals("S"))
											{

												classValue = "CASUMMARY";
												styleValue = "class = '"+classValue+"' ";

											}
											if(printVal.equals(""))
												hiddenValueForGraph = " ";
											else
											{
												if(result_type.equals("L"))
												{
													hiddenValueForGraph = tempString1;										
												}
												else
												{
													hiddenValueForGraph = printVal;
												}
											}

											if(currEventDate.equals(""))
												hiddenDateForGraph = " ";
											else
												hiddenDateForGraph = com.ehis.util.DateUtils.convertDate(currEventDate,"DMYHM","en",locale);

											out.println("<td width='"+widPc+"px' "+styleValue+" title='"+tooltip+"' >"+printVal+"</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"'>");
											
											z++;
											printVal="";
										}
										else
										{
											if((indexK%2)==0)
											{
												classValue	=	"CACHARTQRYEVEN";
												styleValue = "class = '"+classValue+"' ";
											}
											else
											{
												classValue	=	"CACHARTQRYEVEN";
												styleValue = "class = '"+classValue+"' ";
											}
											out.println("<td width='"+widPc+"px' "+styleValue+" >&nbsp;</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"'>");
										}
									}
									else
									{
										if((indexK%2)==0)
										{
											classValue	=	"CACHARTQRYEVEN";
											styleValue = "class = '"+classValue+"' ";
										}
										else
										{
											classValue	=	"CACHARTQRYEVEN";
											styleValue = "class = '"+classValue+"' ";
										}
										out.println("<td width='"+widPc+"px' "+styleValue+" >&nbsp;</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"'>");
									}
								}
								else
								{
									if((indexK%2)==0)
									{
										classValue	=	"CACHARTQRYEVEN";
										styleValue = "class = '"+classValue+"' ";
									}
									else
									{
										classValue	=	"CACHARTQRYEVEN";
										styleValue = "class = '"+classValue+"' ";
									}
									out.println("<td width='"+widPc+"px' "+styleValue+" >&nbsp;</td><input type='hidden' id='values"+tempIntForGraph+"ForGraphs"+k+"' value='"+hiddenDateForGraph+"^%"+hiddenValueForGraph+"'>");
								}
							}
							tempIntForGraph++;
							out.println("</tr>");					
						}
				}

				
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(detailDate));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(errorAuth));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(flagValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(flagString));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(adm_date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(noOfDays));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(daySummary));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(from));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(to));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chartId));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(datesForArray));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(datesForArray));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(datesForPrevNext));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(dateArray.size()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(dummyDateStringForGraph.toString()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(numOfPages));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(tempCountOfRecs));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(prevFirstDate));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pageNo));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(numOfPages));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.page.label","common_labels")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(pageNo));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.of.label","common_labels")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(numOfPages));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block62Bytes, _wl_block62);
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
//if(dataHash != null) dataHash.clear();
if(arrayNext != null) arrayNext.clear();
//if(arrayResultType != null) arrayResultType.clear();
if(tempDateArray != null) tempDateArray.clear();
if(arraytempDate != null) arraytempDate.clear();
//if(ValArray != null) ValArray.clear();
//if(dateArray != null) dateArray.clear();
}//end of try
catch(Exception ee)
{

	System.out.println(" from Charting Recording List Population :"+ee.toString());
	ee.printStackTrace(System.err);
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block63Bytes, _wl_block63);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
