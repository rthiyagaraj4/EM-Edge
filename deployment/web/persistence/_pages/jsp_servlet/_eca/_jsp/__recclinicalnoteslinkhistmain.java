package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkhistmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkHistMain.jsp", 1742465297562L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesLinkMed.js\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<title>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<iframe name=\"RecClinicalNotesLinkHistNoteCriteriaFrame\" id=\"RecClinicalNotesLinkHistNoteCriteriaFrame\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkHistNoteCriteria.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></iframe>\n\t\t\t<frameset name=\"TreeFrameSet\" cols=\'30%,70%\'>\n\t\t\t\t<!-- 1st Frame --><iframe name=\"RecClinicalNotesLinkHistNoteTreeFrame\" id=\"RecClinicalNotesLinkHistNoteTreeFrame\" src=\"../../eCommon/html/blank.html\" frameborder=1></iframe>\n\t\t\t\t<frameset id=\'notesexp\' rows = \'40%,10%,40%,10%\' frameborder=1>\n\t\t\t\t<!-- 2nd Frame --><iframe name=\"RecClinicalNotesLinkHistNoteAddTextHdrFrame\" id=\"RecClinicalNotesLinkHistNoteAddTextHdrFrame\" frameborder=\"1\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></iframe>\n\t\t\t\t<!-- 3rd Frame --><iframe name=\"RecClinicalNotesLinkHistNoteAddButtonsFrame\" id=\"RecClinicalNotesLinkHistNoteAddButtonsFrame\" frameborder=\"1\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesLinkHistNoteAddButtons.jsp\" scrolling=\"no\"></iframe>\n\t\t\t\t<!-- 4th Frame --><!--<iframe name=\"RecClinicalNotesLinkHistNoteSelectedTextFrame\" id=\"RecClinicalNotesLinkHistNoteSelectedTextFrame\" frameborder=\"1\" scrolling=\"auto\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkHistNoteSelectedText.jsp\"></iframe>-->\n\t\t\t\t<iframe name=\"RecClinicalNotesLinkHistNoteSelectedTextFrame\" id=\"RecClinicalNotesLinkHistNoteSelectedTextFrame\" frameborder=\"1\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></iframe>\n\t\t\t\t<!-- 5th Frame --><iframe name=\"RecClinicalNotesLinkHistNoteSelectButtons\" id=\"RecClinicalNotesLinkHistNoteSelectButtons\" frameborder=\"1\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkHistNoteSelectButtons.jsp\" scrolling=\"no\"></iframe>\n\t\t\t\n\t\t</frameset>\n\t\t<!-- 3rd Frame --><frame name=\"messageFrameReference\" id=\"messageFrameReference\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t</frameset>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<frameset name=\"notes\" rows = \'23%,*,3%\' id=\'notes\' frameborder=0 >\n\t<!-- ist Frame --><frame name=\"RecClinicalNotesLinkMedCriteriaFrame\" id=\"RecClinicalNotesLinkMedCriteriaFrame\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkMedCriteria.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"></frame>\n\t<frameset  rows=\'61%,30%,9%\' onunLoad=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<!-- 1st Frame --><frame name=\"RecClinicalNotesLinkMedResultFrame\" id=\"RecClinicalNotesLinkMedResultFrame\" src=\"../../eCommon/html/blank.html\" frameborder=0></frame>\n\t<!-- 2 nd Frame --><frame name=\"RecClinicalNotesLinkMedSelectedTextFrame\" id=\"RecClinicalNotesLinkMedSelectedTextFrame\" frameborder=\"1\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t<!-- 3 rd Frame --><frame name=\"RecClinicalNotesLinkMedSelectButtonsFrame\" id=\"RecClinicalNotesLinkMedSelectButtonsFrame\" frameborder=\"1\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkMedSelectButtons.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" scrolling=\"no\"></frame>\n\t</frameset>\n\t<!-- 3rd Frame --><frame name=\"messageFrameReference\" id=\"messageFrameReference\" frameborder=\"0\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t</frameset>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<!-- Modified by kishore kumar N on 10/12/2008 , altered frameset sizes -->\n\t\t<frameset name=\"notes\" rows = \'28%,*,3%\' id=\'notes\' frameborder=0 >\n\t\t<!-- ist Frame --><frame name=\"RecClinicalNotesLinkDiagCriteriaFrame\" id=\"RecClinicalNotesLinkDiagCriteriaFrame\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkDiagCriteria.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></frame>\n\t\t<!-- 2 nd Frame --><!-- <frame name=\"RecClinicalNotesLinkHistNoteResultFrame\" id=\"RecClinicalNotesLinkHistNoteResultFrame\" frameborder=\"0\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame> -->\n\t\t<frameset  rows=\'61%,*%,9%\' onunLoad=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<!-- 1st Frame --><frame name=\"RecClinicalNotesLinkDiagResultFrame\" id=\"RecClinicalNotesLinkDiagResultFrame\" src=\"../../eCommon/html/blank.html\" frameborder=0></frame>\n\t\t<!-- 2 nd Frame --><frame name=\"RecClinicalNotesLinkDiagSelectedTextFrame\" id=\"RecClinicalNotesLinkDiagSelectedTextFrame\" frameborder=\"1\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t\t<!-- 3 rd Frame --><frame name=\"RecClinicalNotesLinkDiagSelectButtonsFrame\" id=\"RecClinicalNotesLinkDiagSelectButtonsFrame\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkDiagSelectButtons.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" scrolling=\"no\"></frame>\n\t\t</frameset>\n\t\t<!-- 3rd Frame --><frame name=\"messageFrameReference\" id=\"messageFrameReference\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t\t</frameset>\n\t\t<!-- ends here. -->\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<frameset name=\"notes\" rows = \'24%,*,3%\' id=\'notes\' frameborder=0 >\n\t\t<!-- ist Frame --><frame name=\"RecClinicalNotesLinkAlrgCriteriaFrame\" id=\"RecClinicalNotesLinkAlrgCriteriaFrame\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkAlrgCriteria.jsp?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></frame>\n\t\t<!-- 2 nd Frame --><!-- <frame name=\"RecClinicalNotesLinkHistNoteResultFrame\" id=\"RecClinicalNotesLinkHistNoteResultFrame\" frameborder=\"0\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame> -->\n\t\t<frameset  rows=\'59%,30%,11%\' onunLoad=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<!-- 1st Frame --><frame name=\"RecClinicalNotesLinkAlrgResultFrame\" id=\"RecClinicalNotesLinkAlrgResultFrame\" src=\"../../eCommon/html/blank.html\" frameborder=0></frame>\n\t\t<!-- 2 nd Frame --><frame name=\"RecClinicalNotesLinkAlrgSelectedTextFrame\" id=\"RecClinicalNotesLinkAlrgSelectedTextFrame\" frameborder=\"1\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t\t<!-- 3 rd Frame --><frame name=\"RecClinicalNotesLinkAlrgSelectButtonsFrame\" id=\"RecClinicalNotesLinkAlrgSelectButtonsFrame\" frameborder=\"1\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkAlrgSelectButtons.jsp?";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" scrolling=\"no\"></frame>\n\t\t</frameset>\n\t\t<!-- 3rd Frame --><frame name=\"messageFrameReference\" id=\"messageFrameReference\" frameborder=\"0\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t\t</frameset>\n\t ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\t\t<frameset name=\"event1\" rows = \'20%,*,3%\' id=\'event1\' frameborder=0 >\n\t\t<frame name=\"RecClinicalNotesLinkFutureEventCriteriaFrame\" id=\"RecClinicalNotesLinkFutureEventCriteriaFrame\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkFutureEventCriteria.jsp?";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></frame>\n\t\t<frameset id=\'tree\' cols=\'14%,86%\' onunLoad=\"\">\n        <frame name=\"RecClinicalNotesLinkFutureApptTreeFrame\" id=\"RecClinicalNotesLinkFutureApptTreeFrame\" src=\"../../eCommon/html/blank.html\" frameborder=1></frame>\n        <frameset  id=\'result\' rows=\'56%,33%,8%\' onunLoad=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n        <frame name=\"RecClinicalNotesLinkFutureApptResultFrame\" id=\"RecClinicalNotesLinkFutureApptResultFrame\" src=\"../../eCommon/html/blank.html\" frameborder=1></frame>\n        <frame name=\"RecClinicalNotesLinkFutureApptSelectedTextFrame\" id=\"RecClinicalNotesLinkFutureApptSelectedTextFrame\" frameborder=\"1\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n        <frame name=\"RecClinicalNotesLinkFutureApptSelectButtonsFrame\" id=\"RecClinicalNotesLinkFutureApptSelectButtonsFrame\" frameborder=\"1\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkFutureApptSelectButtons.jsp?";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" scrolling=\"no\"></frame>\n        </frameset>\n\t\t</frameset>\n\t\t<frame name=\"messageFrameReference\" id=\"messageFrameReference\" frameborder=\"0\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t\t</frameset>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<frameset name=\"born\" rows = \'10%,*,7%,0%\' id=\'born\' frameborder=0  onunLoad=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<frame name=\"RecClinicalNotesLinkBornEnctrFrame\" id=\"RecClinicalNotesLinkBornEnctrFrame\" frameborder=\"0\" scrolling=\"no\"  noresize src = \"../../eCA/jsp/RecClinicalNotesLinkBirthDetails.jsp?";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t</frame>\n\t\t<frame name=\"RecClinicalNotesLinkBornMainFrame\" id=\"RecClinicalNotesLinkBornMainFrame\" frameborder=\"1\" scrolling=\"auto\"  noresize src = \"../../eCommon/html/blank.html\">\n\t\t</frame>\n\t\t<frame name=\"RecClinicalNotesLinkBornSelectButtonsFrame\" id=\"RecClinicalNotesLinkBornSelectButtonsFrame\" frameborder=\"1\" scrolling=\"no\" noresize src =\'../../eCA/jsp/RecClinicalNotesLinkBirthDetailsToolbar.jsp?";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t</frame>\n\t\t<frame name=\"messageFrameReference\" id=\"messageFrameReference\" frameborder=\"0\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t\t</frameset>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t\t<frameset name=\"notes\" rows = \'20%,*,3%\' id=\'notes\' frameborder=0 >\n\t\t\t<frame name=\"RecClinicalNotesLinkChiefCompCriteriaFrame\" id=\"RecClinicalNotesLinkChiefCompCriteriaFrame\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkChiefCompCriteria.jsp?";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></frame> \n\t\t\t<frameset name=\"chief\" rows=\'59%,30%,11%\' onunLoad=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t<frame name=\"RecClinicalNotesLinkChiefCompResultFrame\" id=\"RecClinicalNotesLinkChiefCompResultFrame\" src=\"../../eCommon/html/blank.html\" frameborder=0></frame>\n\t\t\t\t<frame name=\"RecClinicalNotesLinkChiefCompSelectedTextFrame\" id=\"RecClinicalNotesLinkChiefCompSelectedTextFrame\" frameborder=\"1\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t\t\t\t<frame name=\"RecClinicalNotesLinkChiefCompSelectButtonsFrame\" id=\"RecClinicalNotesLinkChiefCompSelectButtonsFrame\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkChiefCompSelectButtons.jsp?";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" scrolling=\"no\"></frame> \n\t\t\t</frameset>\n\t\t\t<frame name=\"messageFrameReference\" id=\"messageFrameReference\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t\t</frameset> \n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<frameset name=\"notes\" rows = \'22%,*,3%\' id=\'notes\' frameborder=0 >\n\t\t<frame name=\"RecClinicalNotesLinkMenstCriteriaFrame\" id=\"RecClinicalNotesLinkMenstCriteriaFrame\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkMenstHistDtlCriteria.jsp?";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"></frame>\n\t\t<frameset  rows=\'48%,*%,6%\' onunLoad=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<frame name=\"RecClinicalNotesLinkMenstResultFrame\" id=\"RecClinicalNotesLinkMenstResultFrame\" src=\"../../eCommon/html/blank.html\" frameborder=0></frame>\n\t\t<frame name=\"RecClinicalNotesLinkMenstSelectedTextFrame\" id=\"RecClinicalNotesLinkMenstSelectedTextFrame\" frameborder=\"1\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t\t<frame name=\"RecClinicalNotesLinkMenstSelectButtonsFrame\" id=\"RecClinicalNotesLinkMenstSelectButtonsFrame\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkMenstSelectButtons.jsp?";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" scrolling=\"no\"></frame>\n\t\t</frameset>\n\t\t<frame name=\"messageFrameReference\" id=\"messageFrameReference\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCommon/html/blank.html\"></frame>\n\t\t</frameset>\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n<!-- <frameset name=\"notes\" rows = \'21%,*,3%\' id=\'notes\' frameborder=0 > -->\n\t\t\t<iframe name=\"RecClinicalNotesLinkHistRepCriteriaFramenew\" id=\"RecClinicalNotesLinkHistRepCriteriaFramenew\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkHistRepCriteria.jsp?";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" style=\'height:17vh;width:100vw\'></iframe> \n<!-- <frameset name=\"notes1\" rows=\'53%,8%,30%,9%\' onunLoad=\"\"> -->\n\t\t\t\t<iframe name=\"RecClinicalNotesLinkHistRepResultFramenew\" id=\"RecClinicalNotesLinkHistRepResultFramenew\" src=\"../../eCommon/html/blank.html\" frameborder=0 style=\'height:45vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\"RecClinicalNotesLinkHistRepShowButtonsFramenew\" id=\"RecClinicalNotesLinkHistRepShowButtonsFramenew\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCA/jsp/RecClinicalNotesLinkHistRepShowButtons.jsp?";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" scrolling=\"no\" style=\'height:6vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\"RecClinicalNotesLinkHistSelectedTextFramenew\" id=\"RecClinicalNotesLinkHistSelectedTextFramenew\" frameborder=\"0\" scrolling=\"auto\" noresize src = \"../../eCommon/html/blank.html\" style=\'height:20vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\"RecClinicalNotesLinkHistRepSelectButtonsFramenew\" id=\"RecClinicalNotesLinkHistRepSelectButtonsFramenew\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCA/jsp/RecClinicalNotesLinkHistRepSelectButtons.jsp?";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" scrolling=\"no\" style=\'height:9vh;width:100vw\'></iframe> \n<!-- </frameset> -->\n\t\t\t<iframe name=\"messageFrameReference\" id=\"messageFrameReference\" frameborder=\"0\" scrolling=\"no\" noresize src = \"../../eCommon/html/blank.html\" style=\'height:3vh;width:100vw\'></iframe>\n<!--</frameset> -->\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</html>\n\n\n\n\n\n\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

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

/*
Date		Edit History	Name				Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------------------------------
26/07/2024    64277		 Gomathi Sivakumar						Ramesh G		MMS-DM-CRF-0260-US005
30/10/2024    70704       Gunasekar R          31/10/2024       Ashwini Ragupathi	   ML-MMOH-CRF-1759
-----------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.RecordSet Bean= null;synchronized(session){
                Bean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("Bean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(Bean==null){
                    Bean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("Bean",Bean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.RecordSet AllergyTypeBean= null;synchronized(session){
                AllergyTypeBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("AllergyTypeBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(AllergyTypeBean==null){
                    AllergyTypeBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("AllergyTypeBean",AllergyTypeBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.RecordSet Beannew= null;synchronized(session){
                Beannew=(webbeans.eCommon.RecordSet)pageContext.getAttribute("Beannew",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(Beannew==null){
                    Beannew=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("Beannew",Beannew,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.RecordSet EventBean= null;synchronized(session){
                EventBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("EventBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(EventBean==null){
                    EventBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("EventBean",EventBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block4Bytes, _wl_block4);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


  String result_linked_rec_type="";

  result_linked_rec_type=	(request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type"));

if(result_linked_rec_type.equals("CLNT"))
{	
	  
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);

}
else if(result_linked_rec_type.equals("MEDN"))
{	
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Bean.clearAll()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);

}
else if(result_linked_rec_type.equals("DIAG"))
{	
	
	  
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Beannew.clearAll()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);

}
else if(result_linked_rec_type.equals("ALGY"))
{	
	  
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(AllergyTypeBean.clearAll()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block21Bytes, _wl_block21);

}   
else if(result_linked_rec_type.equals("FEVT"))
{	
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(EventBean.clearAll()));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block25Bytes, _wl_block25);

}
else if(result_linked_rec_type.equals("NBDT"))
{	
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(AllergyTypeBean.clearAll()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block29Bytes, _wl_block29);

}
//64277 Starts
else if(result_linked_rec_type.equals("CHIC"))
{
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Beannew.clearAll()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block33Bytes, _wl_block33);

}
//64277 Ends

//70704 Start
else if(result_linked_rec_type.equals("MHD"))
{	
	  
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(Beannew.clearAll()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block37Bytes, _wl_block37);

}//70704 End

else
			//if(result_linked_rec_type.equals("LBIN")||result_linked_rec_type.equals("LBRP")||result_linked_rec_type.equals("PTCR")||result_linked_rec_type.equals("RDIN")||result_linked_rec_type.equals("RDRP")||result_linked_rec_type.equals("SUNT")||result_linked_rec_type.equals("TRET")||result_linked_rec_type.equals("FDOC")||result_linked_rec_type.equals("RXIN") ||result_linked_rec_type.equals("BLTF"))
{
	
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block41Bytes, _wl_block41);

}

            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LinkResultDocuments.label", java.lang.String .class,"key"));
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
}
