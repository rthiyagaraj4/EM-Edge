package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __qa_code_setup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QA_Code_Setup.jsp", 1742817546080L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\'></link>\n\n\t<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<style>\n\t\tA:active { \n\t\t\tCOLOR: white; \n\t\t}\n\t</style>\n\t\t\n\t<script language=\"JavaScript\">\n\t\tvar count = 0;\n\t\tvar prev=0;\n\t\tvar prevcol=\'MENUSUBLEVELCOLOR\';\n\t\tvar sec_hdg_cd=new Array();\n\t\tvar logic_seq_no=new Array();\n\tfunction goHomePage(){\n\t\t\t\tparent.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t}\n\t\tfunction goHomePage(){\n\t\t\t\tparent.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t}\n\t\t\n\t\tfunction chcol(ro)\n\t\t{\n\t\t\t\tdocument.getElementById(\"t\").rows(prev).cells(0).className=prevcol;\n\t\t\t\tprevcol=ro.cells(0).className;\n\t\t\t\tro.cells(0).className=\"MENUSELECTEDCOLOR\"\n\t\t\t\tprev=ro.rowIndex;\n\t\t\t\n\t\t}\n\n\t\tfunction callJSPs(val)\n\t\t{\n\t\t\t\n\t\t\tif(val == \'QA_QIND_GROUP\'){\n\t\t\t parent.frames[1].location.href =\'../../eQA/jsp/QAIndicatorGroup.jsp?module_id=QA&function_id=QA_QIND_GROUP&function_name=Indicator Group&function_type=F&access=YYYNN\';\n\t\t\t\n\t\t\t}\n\n\t\t\tif(val == \'QA_QIND_CLIND\'){\n\t\t\t parent.frames[1].location.href=\'../../eQA/jsp/QAIndicator.jsp?module_id=QA&function_id=QA_QIND_CLIND&function_name=Indicator&function_type=F&access=YYYNN\';\n\t\t\t\n\t\t\t}\n\t\t\tif(val == \'QA_QIND_DISCIPLINE\'){\n\t\t\t parent.frames[1].location.href=\'../../eQA/jsp/QADiscipline.jsp?module_id=QA&function_id=QA_QIND_DISCIPLINE&function_name=Discipline&function_type=F&access=YYYNN\';\n\t\t\t\n\t\t\t\n\t\t\t}\n\t\t\n\n\t\t\tif(val == \'QA_QIND_FACILITY_CLIND\'){\n\t\t\t parent.frames[1].location.href=\'../../eQA/jsp/QAIndicatorsForFacility.jsp?module_id=QA&function_id=QA_QIND_ASSOCIATE_FACILITY&function_name=Indicators for Facility&function_type=F&access=YYYNN\';\n\t\t\t\n\t\t\t\n\t\t\t}\n\t\t\tif(val == \'QA_ASSO_COMP_IND\'){\n\t\t\t\tparent.frames[1].location.href=\'../../eQA/jsp/QAComplicationsForIndicator.jsp?module_id=QA&function_id=QA_ASSO_COMP_IND&function_name=Complications for Indicator&function_type=F&access=YYYNN\';\n\t\t\t\n\t\t\t\n\t\t\t}\n          \n\t\t  if(val == \'QA_QIND_CLIND_DIAG_PROC\'){\n\t\t\t\tparent.frames[1].location.href=\'../../eQA/jsp/QADiagProcForIndicator.jsp?module_id=QA&function_id=QA_ASSO_COMP_IND&function_name=Diag/Procedures for Indicator&function_type=F&access=YYYNN\';\n\t\t\t\n\t\t\t\n\t\t\t}\n\t\t\tif(val == \'QA_QIND_DISCIPLINE_CLIND\'){\n\t\t\t\tparent.frames[1].location.href=\'../../eQA/jsp/QAIndicatorsForDiscipline.jsp?module_id=QA&function_id=QA_ASSO_COMP_IND&function_name=Indicators for Discipline&function_type=F&access=YYYNN\';\n\t\t\t\t\t\n\t\t\t}\n\t\t\n\t\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body style=\"background-color:dimgray;\" onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >\n\t<form name=\"SMMasterMenu_form\" id=\"SMMasterMenu_form\">\n\t<table cellspacing=1 cellpadding=2 width=\'100%\' border=0 id=\'t\'>\n\n\t\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'QA_QIND_GROUP\')\" >Indicator Group</a></td>\n\t\t\t</tr>\n\t\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'QA_QIND_CLIND\')\" > Indicator</a></td>\n\t\t\t</tr>\n\t\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'QA_QIND_CLIND_DIAG_PROC\')\" >Diag/Procedures for Indicator</a></td>\n\t\t\t</tr>\n\t\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'QA_QIND_DISCIPLINE\')\" >Discipline</a></td>\n\t\t\t</tr>\n\n\t\t\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'QA_QIND_DISCIPLINE_CLIND\')\" >Indicators for Discipline</a></td>\n\t\t</tr>\n\n\t\t\n\t\t\n\t\t\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"QA_QIND_FACILITY_CLIND\")\' >Indicators for Facility</a></td>\n\t\t</tr>\n\t\t\n\t\t\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"QA_ASSO_COMP_IND\")\' >Complications for Indicator</a></td>\n\t\t</tr>\n\t\t \n\t\t\n\t\t<tr>\n\t\t\t<td class=\'MENUHIGHERLEVELCOLOR\'><a href=javascript:goHomePage() style=\'color:white;\'><b>MENU</b></a></td> \n\t</tr>\n\t\t</table>\n\n\t</body>\n\t\n\t</form>\n</html>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
