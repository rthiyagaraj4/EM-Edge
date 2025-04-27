package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCA.PatTaskListRepository;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __pattasklistdiscretemeasureatomic extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatTaskListDiscreteMeasureAtomic.jsp", 1709116028982L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------\nDate       Edit History      Name        \tDescription\n-----------------------------------------------------------------------\n?             100            ?           \tcreated\n28/06/2012    IN032687\t\t Nijitha S\t\tAll the associated elements in the Discrete measure Panel is not Displayed in\n\t\t\t\t\t\t\t\t\t\t\tintervention in Task List.\n-----------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script src=\'../../eCA/js/CAMessages.js\' language=\'javascript\'></SCRIPT>\n\t<script language=\"javascript\" src=\"../../eCA/js/PatTaskList.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<script language=\'javascript\'>\n\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\'patTaskListDiscreteForm\' id=\'patTaskListDiscreteForm\' action=\'../../servlet/eCA.PatTaskListServlet\' method=\'post\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" id=\'tableId\' width=\"100%\" align=\'center\'>\n\t\n\t<tr>\n\t\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td width=\'25%\' class=\'fields\'>\t\n\t\t\t\t<INPUT TYPE=\"text\" name=\"dateTime\" id=\"dateTime\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' size=\'20\' maxlength=\'16\' OnBlur=\'checkForCurrentDate();CheckDateTime(this);\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'dateTime\')\">\t\t\n\t\t\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\n\t\t</td>\n\t\t<td width=\'25%\' class=\'label\'>\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t<td width=\'25%\' class=\'fields\'>\t\n\t\t\t\t<INPUT TYPE=\"text\" name=\"practitonerName\" id=\"practitonerName\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' size=\'20\' maxlength=\'16\' readOnly>\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"practitonerId\" id=\"practitonerId\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"locale\" id=\"locale\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<input type=\'button\' class=\'button\' name=\'buttonPractitioner\' id=\'buttonPractitioner\' value=\'?\' OnClick=\'getPractitionerDiscreteMeasure()\' >\n\t\t\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t</td>\n\t</tr>\n\t\n\t<tr>\n\t\t<td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<td class=\'fields\' colspan=3>\t\n\n\t\t\t\t<TEXTAREA NAME=\"remarks\" ROWS=\"3\" COLS=\"50\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" OnKeyDown=\'return checkTheLength(this)\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</TEXTAREA>\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</td>\n\t</tr>\n\t\t\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<script>\n\t//\tdocument.getElementById(\"tableId\").border=\'1\'\n\t\t</script>\n<tr>\n<td colspan=\'6\' width=\'100%\'>\n\n<table id=\'tableID\' width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'0\'>\n\t<script>\n\t\tdocument.getElementById(\"tableID\").border=\'1\'\n\t\t</script>\n\t\t<tr>\n\t\t<td colspan=\'6\'  align =\'left\' class=\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\n\t\t\n\t\t<tr>\n\t\t<td colspan=\'6\'  align =\'left\' class=\'label\'><B>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</B></td>\t\n\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t<tr>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\t\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n\t<td align=\'right\'>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<input type=\'button\' name=\'buttonRecord\' id=\'buttonRecord\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' class=\'button\' OnClick=\'recordingForDiscrete()\'>\n\t\t<input type=\'button\' name=\'buttonRecord\' id=\'buttonRecord\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' class=\'button\' OnClick=\'cancel()\'>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<input type=\'button\' name=\'buttonClose\' id=\'buttonClose\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t</td>\n\t</tr>\n</table>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" id=\'tableId\' width=\"100%\" >\n\t<script>\n\t\tdocument.body.scroll=\"no\";\n\t\tdocument.body.onscroll= \"\";\n\t</script>\n\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t<tr>\n\n\t<td colspan=\'4\'align=\'right\' class=\'label\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t<td align=\'left\'><INPUT TYPE=\"text\" name=\"dateTime\" id=\"dateTime\" value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' size=\'20\' maxlength=\'16\'  readOnly></td>\n\t</tr>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<tr>\n\t\t<td colspan=\'4\'align=\'right\' class=\'label\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t<td align=\'left\'>\t\n\t\t\t\t<INPUT TYPE=\"text\" name=\"practitonerName\" id=\"practitonerName\" value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' size=\'30\'   readOnly>\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"practitonerId\" id=\"practitonerId\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<!-- <input type=\'button\' class=\'button\' name=\'buttonPractitioner\' id=\'buttonPractitioner\' value=\'?\' OnClick=\'getPractitioner()\'><img align=center src=\'../../eCommon/images/mandatory.gif\'></img> -->\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t</td>\n\t</tr>\n\t<tr>\n\t<td colspan=\'6\'>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=\'4\'align=\'right\' class=\'label\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;&nbsp; \n\t\t</td>\n\t\t\t<td align=\'left\'>\t\n\t\t\t\t<TEXTAREA NAME=\"remarks\" ROWS=\"3\" COLS=\"50\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" OnKeyDown=\'return checkTheLength(this)\' STYLE=\"overflow:hidden\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</TEXTAREA>\n\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t</td>\n\t</tr>\n\t<tr>\n\t<td colspan=\'6\'>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\t\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n\t<td align=\'right\'>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' class=\'button\' OnClick=\'recordingForNotPerform()\'>\n\t\t<input type=\'button\' name=\'buttonRecord\' id=\'buttonRecord\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\n\n\n\t</td>\n\t</tr>\n\t\t\n</table>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n<INPUT TYPE=\"hidden\" name=\"status\" id=\"status\" value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n<INPUT TYPE=\"hidden\" name=\"patientId\" id=\"patientId\" value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n<INPUT TYPE=\"hidden\" name=\"taskCode\" id=\"taskCode\" value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n<INPUT TYPE=\"hidden\" name=\"taskType\" id=\"taskType\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n<INPUT TYPE=\"hidden\" name=\"pract_type\" id=\"pract_type\" value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n<INPUT TYPE=\"hidden\" name=\"sysdate\" id=\"sysdate\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n<INPUT TYPE=\"hidden\" name=\"taskSrlNo\" id=\"taskSrlNo\" value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n<INPUT TYPE=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<INPUT TYPE=\"hidden\" name=\"result_id\" id=\"result_id\" value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            eCA.PatTaskListRepository patTask= null;{
                patTask=(eCA.PatTaskListRepository)pageContext.getAttribute("patTask");
                if(patTask==null){
                    patTask=new eCA.PatTaskListRepository();
                    pageContext.setAttribute("patTask",patTask);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

String encounter_id =  request.getParameter("encounter_id")==null ? "" :request.getParameter("encounter_id");
String status = request.getParameter("status")==null ? "" :request.getParameter("status");
String dateTime =request.getParameter("p_start_date_time")==null ? "" :request.getParameter("p_start_date_time");

String task  =request.getParameter("task")==null ? "" :request.getParameter("task");
String taskType  =request.getParameter("taskType")==null ? "" :request.getParameter("taskType");
String patientId =request.getParameter("patient_id")==null ? "" :request.getParameter("patient_id");

String pract_type =(String) session.getValue("practitioner_type");
String taskSrlNo =request.getParameter("taskSrlNo")==null ? "" :request.getParameter("taskSrlNo");
String sysdate = patTask.getSysdate();
String performedId=request.getParameter("performedId")==null ? "" :request.getParameter("performedId");
String detail  =request.getParameter("detail")==null ? "" :request.getParameter("detail");
String readOnly ="";
ArrayList retArray= null;
String resultType= request.getParameter("resultType")==null ? "" :request.getParameter("resultType");
String resultId  = request.getParameter("Chart_Id")==null ? "" :request.getParameter("Chart_Id");

HashMap hashData = patTask.getQueryForDiscrete(request);

if(!detail.equals(""))
{
	readOnly="ReadOnly";
}
try
	{
		
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		String practitioner_id ="";
		practitioner_id = (String) session.getValue("ca_practitioner_id");
		String name="";
		if(performedId.equals(""))
		{
			name	=(String)session.getValue("practitioner_name");
		}
		else
		{
			name = performedId;
		}

		String remarks= "";
		if(!status.equals(""))
		{

				if(status.equals("P"))
				{
						remarks=request.getParameter("remarks")==null ? "" :request.getParameter("remarks");
					
		

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dateTime));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block13Bytes, _wl_block13);
if(detail.equals("")){ 
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(detail.equals("")){ 
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(detail.equals("")){ 
            _bw.write(_wl_block25Bytes, _wl_block25);
} 
            _bw.write(_wl_block26Bytes, _wl_block26);

			if(resultType.equals("DP") || resultType.equals("DA"))
			{
					
	
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);


		if(!resultType.equals("DA"))
			{

	
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(resultId));
            _bw.write(_wl_block30Bytes, _wl_block30);

			}
		
            _bw.write(_wl_block31Bytes, _wl_block31);

			String classValue = "";	
			String  maxSize = "";
			String  minSize = "";
			String decSize = "";
			String mandatory="";	
			int index = 0;
			ArrayList arrayCode=null;
			ArrayList arrayDesc= null;

            _bw.write(_wl_block1Bytes, _wl_block1);
	
		for(int 	count=0; count < hashData.size();count++)//IN032687
				{
					
					if(count % 2 == 0 )
					classValue = "QRYEVEN";
					else
					classValue = "QRYODD";

					maxSize = patTask.checkForNull((String)hashData.get("num_digits_max"+count));
					minSize = patTask.checkForNull((String)hashData.get("num_digits_min"+count));
					decSize = patTask.checkForNull((String)hashData.get("num_digits_dec"+count));
					mandatory= patTask.checkForNull((String)hashData.get("mandatory_yn"+count));
					
					if(maxSize.equals(""))
					{
						maxSize ="20";
					}
					if(minSize.equals(""))
					{
						minSize ="0";
					}
					if(decSize.equals(""))
					{
						decSize = "0";
					}
					if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("N")||patTask.checkForNull((String)hashData.get("result_type"+count)).equals("I"))
					{
						out.println("<tr>");
						out.println("<td colspan='2' class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
						
						out.println("<td colspan='2' class='"+classValue+"'><input type='text'  name='comp_"+count+"' id='comp_"+count+"' size='"+maxSize+"' maxlength='"+maxSize+"' value=''    onkeypress=\"return allowValidNumber(this, event, '"+maxSize+"','"+decSize+"')\" onblur=\"setText(this,"+count+")\"> ");
						out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
						if(mandatory.equals("Y"))
						{
								out.println("<img src ='../../eCommon/images/mandatory.gif'></img>");
						}
						out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
						out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
						out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
						out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
						out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
						out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
						out.println("</td>");
						out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
						out.println("</tr>");
					}
					else if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("L"))
						{
							out.println("<tr>");							
								retArray =  patTask.getListItemsForDiscreteMeasure(patTask.checkForNull((String)hashData.get("discr_msr_id"+count)));
								out.println("<td colspan='2' class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
								out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
								out.println("<td colspan='2' >");
								out.println("<Select name='comp_"+count+"' id='comp_"+count+"' OnChange='setValueforText(this,"+count+")'>");
								
								out.println("<option value=''>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option>");
								if(retArray != null)
								{
									arrayCode = (ArrayList)retArray.get(0);
									arrayDesc =  (ArrayList)retArray.get(1);
									while(index < arrayCode.size())
									{
										out.println("<option value='"+patTask.checkForNull((String)arrayCode.get(index))+"'>"+patTask.checkForNull((String)arrayDesc.get(index))+"</option>");
											index++;
									}
								}

								out.println("</Select>");
								if(mandatory.equals("Y"))
								{
									out.println("<img src ='../../eCommon/images/mandatory.gif'></img>");
								}
						out.println("</td>");
						out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
						out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
						out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
						out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
						out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
						out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
						out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
						out.println("</tr>");
						}
						else
						if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("C"))
						{
							out.println("<tr>");
							out.println("<td colspan='2' class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
							out.println("<td colspan='2' class='"+classValue+"'><input type='checkBox'  name='comp_"+count+"' id='comp_"+count+"'  value='' OnClick='evalCheckBox(this)'> ");
							out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
						if(mandatory.equals("Y"))
						{
								out.println("<img src ='../../eCommon/images/mandatory.gif'></img>");
						}
						out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
						out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
						out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
						out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
						out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
						out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
						out.println("</td>");
						out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
						out.println("</tr>");
						}
						else 
							if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("D"))
							{
									out.println("<tr>");
									out.println("<td colspan='2' class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
									out.println("<td colspan='2' class='"+classValue+"'><input type='text' name='comp_"+count+"' id='comp_"+count+"' size='10' maxlength='10' value='' onblur= 'checkDateForDetail(this)'><input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick='return showCalendarValidateForDate(\"comp_"+count+"\")'> ");
									out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
									if(mandatory.equals("Y"))
									{
										out.println("<img src 	='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
									out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
									out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
									out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
									out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
									out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
								out.println("</td>");
								out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
								out.println("</tr>");
							}
						else if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("E"))
								{
									out.println("<tr>");
									out.println("<td colspan='2'  class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
									out.println("<td colspan='2' class='"+classValue+"'><input type='text' name='comp_"+count+"' id='comp_"+count+"' size='16' maxlength='16' value='' onblur= 'CheckDateTime(this)'><input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick='return showCalendarValidate(\"comp_"+count+"\")'>");
									out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
									if(mandatory.equals("Y"))
									{
										out.println("<img src 	='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
									out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
									out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
									out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
									out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
									out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
								out.println("</td>");
								out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
								out.println("</tr>");
							}
						else if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("T"))
						{
							out.println("<tr>");
									out.println("<td colspan='2'  class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
									out.println("<td colspan='2' class='"+classValue+"'><input type='text' name='comp_"+count+"' id='comp_"+count+"' size='5' maxlength='5' value='' onblur= 'chkValidityOfTime(this)'>");
									out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
									if(mandatory.equals("Y"))
									{
										out.println("<img src 	='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
									out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
									out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
									out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
									out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
									out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
								out.println("</td>");
								out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
								out.println("</tr>");
						}
						else if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("F"))
						{
							out.println("<tr>");
									out.println("<td colspan='2'  class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
									out.println("<td colspan='2' class='"+classValue+"'><input type='text' name='comp_"+count+"' id='comp_"+count+"' size='20' maxlength='20' onblur=\"setText(this,"+count+")\" value='' >");
									out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
									if(mandatory.equals("Y"))
									{
										out.println("<img src 	='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
									out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
									out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
									out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
									out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
									out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
								out.println("</td>");
								out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
								out.println("</tr>");
						}

				}
				if (arrayCode != null)
					arrayCode.clear();
				if (arrayDesc != null)
					arrayDesc.clear();

				out.println("<input type='hidden' name='count' id='count' value='"+ hashData.size()+"'>");
				out.println("<INPUT TYPE='hidden' name='resultType' id='resultType' value='"+resultType+"'>");
				out.println("</table>");			
				out.println("</td>");
				out.println("</tr>");

		}
		
	
            _bw.write(_wl_block32Bytes, _wl_block32);
if(detail.equals("")){ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else
		{
		
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);

		}
		
            _bw.write(_wl_block37Bytes, _wl_block37);
			}
				else
				{
					

					remarks=request.getParameter("remarks")==null ? "" :request.getParameter("remarks");
		

            _bw.write(_wl_block38Bytes, _wl_block38);
if(!detail.equals("")){ 
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dateTime));
            _bw.write(_wl_block41Bytes, _wl_block41);
} 

            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
if(detail.equals("")){ 
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block50Bytes, _wl_block50);
if(detail.equals("")){ 
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
if(detail.equals("")){ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else
		{
		
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);

		}
		
            _bw.write(_wl_block54Bytes, _wl_block54);
			}
		}


            _bw.write(_wl_block1Bytes, _wl_block1);

	}
	catch(Exception ee)
	{
		//out.println("Exception from PatTaskListDiscreteMeasureAtomic.jsp :"+ee.toString());//common-icn-0181
		 ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if (retArray != null)
			retArray.clear();
		if (hashData != null)
			hashData.clear();
	
	}

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(status));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(taskType));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(task));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(taskSrlNo));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(resultId));
            _bw.write(_wl_block64Bytes, _wl_block64);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PerformedDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Result.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
