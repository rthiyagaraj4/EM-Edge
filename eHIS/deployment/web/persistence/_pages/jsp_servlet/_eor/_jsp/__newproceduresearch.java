package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __newproceduresearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcedureSearch.jsp", 1709119750000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../js/NewProcedure.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<SCRIPT LANGUAGE=\"JavaScript\">\n<!--\n/*\tfunction callsubmit(){\n\t\tvar qryStr = document.newproc_search.qryStr.value;\n\t\tvar\tviewScope = document.newproc_search.viewScope.value;\n\t\tvar\trestrict = document.newproc_search.restrict.value;\n\t\tvar\tstatus = document.newproc_search.status.value;\n\t\tvar\tdate_from = document.newproc_search.date_from.value;\n\t\tvar\tdate_to = document.newproc_search.date_to.value;\n\t\tqryStr += \"&view=\"+viewScope+\"&view=\"+viewScope+\"&restrict=\"+restrict+\"&status=\"+status+\"&date_from=\"+date_from+\"&date_to=\"+date_to ;\n\t\tdocument.newproc_search.action = \"../../eOR/jsp/NewProcedureQueryResult.jsp?\"+qryStr;\n\t\tdocument.newproc_search.submit();\n\t}*/\n//-->\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style>\n\t/*\tBODY.CONTENT{BGCOLOR:#E2E3F0}*/\n\t</style>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<form name=\'newproc_search\' id=\'newproc_search\' method=\'post\' action=\'../../eOR/jsp/NewProcedureQueryResult.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' target=\'proc_main_result\'>\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" id=\'tableId\' width=\"100%\" align=center>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<tr>\n\t<td class=\'label\' align=\'right\'> View\n\t</td>\n\t<td class=\'label\' align=\'left\'>\n\t\t<select name=\"viewScope\" id=\"viewScope\">\n\t\t\t<option value=\"A\">All</option>\n\t\t\t<option value=\"S\">Self Related</option>\n\t\t</select>\n\t</td>\n\t<td class=label align=\'right\'>\n\tRestrict To\n\t</td>\n\t<td class=label align=\'left\'>\n\t\t<select name=\'restrict\' id=\'restrict\'>\n\t\t<option value=\'\'>----Select----</option>\t\n\t\t\t\t<option value=\'C\' >Current Encounter</option>\n\t\t\t\t<option value=\'A\' >All Encounters</option>\n\t\t\t\t\n\t\t</select>\t\t\n\t</td>\t\n\t<td class=label align=\'right\'>\n\tStatus\t\n\t</td>\n\t<td class=label align=\'left\'>\n\t\t<select name=\'status\' id=\'status\'>\n\t\t<option value=\'*ALL\'>----All----</option>\t\n\t\t\t\t<option value=\'R\' >Requested</option>\n\t\t\t\t<option value=\'A\' >Appointment Booked</option>\n\t\t\t\t<option value=\'P\' >Partially Completed</option>\n\t\t\t\t<option value=\'C\' >Completed</option>\n\t\t</select>\t\t\n\t</td>\t\n\t</tr>\n\t<tr>\n\t\n\t<td class=\"label\" align=\'right\' colspan=\'\'>\t\n\t\tDate From\n\t\t\n\t</td>\n\t<td class=label align=\'left\'><input type=\"text\" name=\"date_from\" id=\"date_from\" size=\'16\' maxlength=\'16\' OnBlur=\'checkValidDateTime(this)\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'date_from\',null,\'hh:mm\');\">\n\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t</td>\t\n\t<td class=\'label\' align=\'right\' nowrap colspan=\"\"> \n\t\t\tTo\n\t</td>\n\t<td class=label align=\'left\'>\n\t\t<input type=\"text\" name=\"date_to\" id=\"date_to\" size=\'16\' maxlength=\'16\' OnBlur=\'checkValidDateTime(this)\'  value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'date_to\',null,\'hh:mm\');\">\n\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n\t<td class=\'label\' colspan=\"2\">\n\t</td>\n\t</tr>\n\t\n\t<tr>\n\t\t<td class=\'label\' align=\'right\' nowrap colspan=\"6\">\t\n\t\t<input class=\'button\' type=\"submit\" name=\"search\" id=\"search\" onclick=\'\'  value=\'Search\'>\n\t\t<input class=\'button\' type=\"button\" name=\"clear\" id=\"clear\" onclick=\'document.newproc_search.reset()\'  value=\'Clear\'>\n\t\n\t</td>\n\t<input type=\'hidden\' name=\'qryStr\' id=\'qryStr\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" >\t\n\t</tr>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</table>\n</form>\n</body>\n</html>\t\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	Properties property = null;
	String patient_id = request.getParameter("patient_id")==null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("episode_id")==null ? "" : request.getParameter("episode_id");
	String sysdate = "";
	String fromDate = "";
	String homePageCategory=request.getParameter("category")==null ? "" : request.getParameter("category");
	String homePageLocationType=request.getParameter("locationType")==null ? "" : request.getParameter("locationType");
	String homePageLocationCode=request.getParameter("locationCode")==null ? "" : request.getParameter("locationCode");
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy H:mm" ) ;
	String	currentdate			= dateFormat.format(new java.util.Date()) ;
	sysdate						= currentdate ;
	try
	{
		//property = (java.util.Properties) session.getValue( "jdbc" );
	//	sysdate = patTask.getSysdateTime();
	//	fromDate = patTask.getSysdateFromTime();

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()==null?"":request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);

}
catch(Exception ee)
{
	//out.println("Exception from search page.jsp :"+ee.toString());//COMMON-ICN-0181
         ee.printStackTrace();//COMMON-ICN-0181
}


            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
