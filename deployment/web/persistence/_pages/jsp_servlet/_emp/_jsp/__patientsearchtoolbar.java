package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __patientsearchtoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatientSearchToolBar.jsp", 1728972633134L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<Script>\n\t\t/*function resetform() {\n\n\t\t   var register_button_yn = \"\";\n\t\t   var soundex = \"\";\n\t\t   var func_act = \"\";\n\t\t   if (parent.frames[1].document.forms[0].register_button_yn)\n\t\t\t\tregister_button_yn = parent.frames[1].document.forms[0].register_button_yn.value;\n\t\t   if (parent.frames[1].document.forms[0].soundex_dflt)\n\t\t   {\n\t\t\t\tsoundex = parent.frames[1].document.forms[0].soundex_dflt.value;\n\t\t\t\tif (soundex==null) soundex=\"\";\n\t\t\t}\n\t\t   if (parent.frames[1].document.forms[0].func_act)\n\t\t\t\tfunc_act = parent.frames[1].document.forms[0].func_act.value;\t\n\n\t\t   if (parent.frames[1].document.forms[0].soundex_dflt)\n\t\t   {\n\t\t\t   parent.frames[1].document.forms[0].reset();\n\t\t\t   parent.frames[1].document.forms[0].Mode.disabled = true;\n\t\t\t   parent.frames[1].document.forms[0].Patient_Id.focus();\n\t\t   }\n\t\t   else\n\t\t\t\tparent.frames[1].location.href = \'../../eMP/jsp/ViewBirthRegisterCriteria.jsp?function_id=\'+parent.frames[1].document.forms[0].function_id.value;\n\n\t\t\tif (parent.frames[1].document.forms[0].apply_oth_name)\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].formatFlds(parent.frames[1].document.forms[0].apply_oth_name);\n\n\t\t   if (parent.frames[1].document.forms[0].newborn_suffix)\n\t\t\t   parent.frames[1].document.forms[0].newborn_suffix.disabled=true;\n\t\t   if (parent.frames[1].document.forms[0].soundex_dflt)\n\t\t\t   parent.frames[2].location.href = \"../../eMP/jsp/SearchToolbar.jsp?register_button_yn=\"+register_button_yn+\"&func_act=\"+func_act+\"\";\n\t\t\telse\n\t\t\t\tparent.frames[2].location.href = \"../../eMP/jsp/ViewBirthSearchToolbar.jsp\";\n\n\t\t   parent.frames[3].location.href = \'../../eCommon/html/blank.html\';\n\t\t   if (parent.frames[1].document.forms[0].Soundex)\n\t\t   {\n\t\t\t   parent.frames[1].document.forms[0].Soundex.value = soundex;\n\t\t\t   parent.frames[1].tab_click(\'simplesearch_tab\');\n\t\t\t}\n\t\t\tif (parent.frames[1].document.forms[0].searchby)\n\t\t\t{\n\t\t\t\tvar soundexval = \"\";\n\t\t\t\tif (parent.frames[1].document.forms[0].Soundex)\n\t\t\t\t\tsoundexval = parent.frames[1].document.forms[0].Soundex.value\n\t\t\t\tif (parent.frames[1].document.forms[0].soundex_val)\n\t\t\t\t\tsoundexval = parent.frames[1].document.forms[0].soundex_val.value\n\t\t\t\t\n\t\t\t\tif (soundexval==\'\')\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].searchby.disabled=false;\n\n\t\t\t\t\t//The following line was commented and one line added on 11/10/2004 for making the search by list box to display --select-- after reset.\n\t\t\t\t\tparent.frames[1].document.forms[0].searchby.value = \"\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].searchby.value = \"\";\n\t\t\t\t\t// The following line was changed to disabled = false for enabling the search by list box after search.\n\t\t\t\t\tparent.frames[1].document.forms[0].searchby.disabled=false;\n\t\t\t\t}\n\t\t\t}\n\t\t\t//parent.frames[1].tab_click3(\'search_tab1\',\'search_tab1\');\n\t\t\t//parent.frames[1].document.forms[0].reset();\n\t\t\t//parent.parent.frames[1].tab_click3(\'simplesearch_tab\');\n\t\t\tparent.frames[1].tab_click3(\'simplesearch_tab\');\n\t\t\t//prevTabObj=null;\n\t\t\t//parent.parent.frames[1].tab_click3(\'simplesearch_tab\');\n\t\t}*/ \n\n\t\tfunction resetform() {\n      \n\t\t\t/*Here Two JspPages are Loading at Pat_Search_Criteria_Frame, i.e to differentiate Two form elements Conditionaly Form Names and Jsp Location was written as follows.\t\tWritten-On--12/24/2008 */\n\t        // var BasicAdvanceForm\t= parent.Pat_Search_Criteria_Frame.document.forms(0);\n\t        var BasicAdvanceForm = parent.Pat_Search_Criteria_Frame.document.forms[0];\n\t\t\tvar REPLC_LOC;\n\t\t\tvar REPLC_FORM_NAME;\n\t\t\tvar patient_class\t= \"\";\n\t\t\t//Below line added for this CRF HSA-CRF-0289\n\t\t\tvar alterIdSearch=\"\";\n\t\t\tvar isAlternateId=\"\";\n\t\t\tif (BasicAdvanceForm.name==\"Advnc_Patient_Search_Form\"){\n\t\t\t\tREPLC_LOC=\"../jsp/PatientSearchCriteria.jsp?\";\n\t\t\t\t//REPLC_FORM_NAME=parent.parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form;\n\t\t\t\tREPLC_FORM_NAME= parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form;\n\t\t\t\t// Added for IN0 by Suresh M on 20.12.2010\n\t\t\t\tpatient_class\t=\tREPLC_FORM_NAME.patient_class.value;\n\t\t\t\t //Below line added for this CRF HSA-CRF-0289\n\t\t\t\tif(REPLC_FORM_NAME.alterIdSearch){\n\t\t\t\t\t  alterIdSearch=REPLC_FORM_NAME.alterIdSearch.value;\n\t\t\t\t}\n\t\t\t\tif(REPLC_FORM_NAME.isAlternateId){\n\t\t\t\t\t  isAlternateId=REPLC_FORM_NAME.isAlternateId.value;\n\t\t\t\t}\n\t\t\t\t \n\t\t\t\t//parent.patsearch.document.all.pat_search.rows=\"20,25,330,20,*\"; commented by vedesh for edge converstion \n\t\t\t\tparent.document.getElementById(\"commontoolbar\").style.height=\"4vh\";\n\t\t\t\tparent.document.getElementById(\"Pat_Search_Tabs_Frame\").style.height=\"3vh\";\n\t\t\t\tparent.document.getElementById(\"Pat_Search_Criteria_Frame\").style.height=\"70vh\";\n\t\t\t\tparent.document.getElementById(\"Pat_Search_Criteria_Frame\").scrolling=\"no\";\n\t\t\t\tparent.document.getElementById(\"Pat_Search_Toolbar_Frame\").style.height=\"20px\";\n\t\t\t\tparent.document.getElementById(\"Pat_Results_Frame\").style.height=\"4vh\";\n\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t\n\t\t\t\t\t//REPLC_FORM_NAME=parent.parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form;\n\t\t\t\t    //REPLC_FORM_NAME = parent.parent.Pat_Search_Criteria_Frame.document.forms[\'Basic_Patient_Search_Form\'];\n\t\t\t\tREPLC_FORM_NAME= parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form;\n\t\t\t\tREPLC_LOC=\"../jsp/BasicPatientSearchCriteria.jsp?\";\n\t\t\t\t\t\n\t\t\t\t\t//Below line added for this CRF HSA-CRF-0289\n\t\t\t\tif(REPLC_FORM_NAME.alterIdSearch){\n\t\t\t\t\t  alterIdSearch=REPLC_FORM_NAME.alterIdSearch.value;\n\t\t\t\t}\n\t\t\t\tif(REPLC_FORM_NAME.isAlternateId){\n\t\t\t\t\t  isAlternateId=REPLC_FORM_NAME.isAlternateId.value;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t//parent.patsearch.document.all.pat_search.rows=\"20,25,245,20,*\";\n\n\t\t\t\t//parent.patsearch.document.getElementById(\"pat_search\").rows=\"20,25,245,20,*\"; commented by vedesh for edge converstion \n\t\t\t\tparent.document.getElementById(\"commontoolbar\").style.height=\"4vh\";\n\t\t\t\tparent.document.getElementById(\"Pat_Search_Tabs_Frame\").style.height=\"3vh\";\n\t\t\t\tparent.document.getElementById(\"Pat_Search_Criteria_Frame\").style.height=\"38vh\";\n\t\t\t\tparent.document.getElementById(\"Pat_Search_Criteria_Frame\").scrolling=\"no\";\n\t\t\t\tparent.document.getElementById(\"Pat_Search_Toolbar_Frame\").style.height=\"4vh\";\n\t\t\t\tparent.document.getElementById(\"Pat_Results_Frame\").style.height=\"40vh\";\n\t\t\t\t\n\t\t\t}\n\t\t\t \n\t\t\tvar cr_jsp_name\t\t=\tREPLC_FORM_NAME.cr_jsp_name.value;\n\t\t\tvar cr_window_styl =\tREPLC_FORM_NAME.cr_window_styl.value;\n\t\t\tvar cr_close_yn\t\t=\tREPLC_FORM_NAME.cr_close_yn.value;\n\t\t\tvar cr_win_top\t\t\t=\tREPLC_FORM_NAME.cr_win_top.value;\n\t\t\tvar cr_win_width\t\t=\tREPLC_FORM_NAME.cr_win_width.value;\n\t\t\tvar cr_win_height\t\t=\tREPLC_FORM_NAME.cr_win_height.value;\n\t\t\tvar cr_act_yn\t\t\t=\tREPLC_FORM_NAME.cr_act_yn.value;\n\t\t\tvar cr_srr\t\t\t\t\t=\tREPLC_FORM_NAME.cr_srr.value;\n\t\t\tvar cr_func_act\t\t\t\t=\tREPLC_FORM_NAME.cr_func_act.value;\n\t\t\tvar cr_defaultgender\t\t\t=\tREPLC_FORM_NAME.cr_defaultgender.value;\n\t\t\tvar cr_enablegenderyn\t\t=\tREPLC_FORM_NAME.cr_enablegenderyn.value;\n\t\t\tvar cr_function_id\t\t\t=\tREPLC_FORM_NAME.cr_function_id.value;\n\t\t\tvar cr_func_idpassed\t\t=\tREPLC_FORM_NAME.cr_func_idpassed.value;\n\t\t\tvar cr_register_button_yn=\"\";\n\t\t\t\n\t\t\tif(REPLC_FORM_NAME.cr_register_button_yn){\n\t\t\t\tcr_register_button_yn=REPLC_FORM_NAME.cr_register_button_yn.value;\n\t\t\t}\n\t\t\tvar register_button_yn=\"\";\n\t\t\tif(parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register_button_yn){\n\t\t\t\tregister_button_yn=parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register_button_yn.value;\n\t\t\t}\n\t\t\tvar toolbar_func_act=\"\";\n\t\t\tif(parent.Pat_Search_Toolbar_Frame.document.search_toolbar.toolbar_func_act){\n\t\t\t\ttoolbar_func_act=parent.Pat_Search_Toolbar_Frame.document.search_toolbar.toolbar_func_act.value\n\t\t\t}\n\t\t\tvar toolbar_dr_function_id=\"\";\n\t\t\tif(parent.Pat_Search_Toolbar_Frame.document.search_toolbar.toolbar_dr_function_id){\n\t\t\t\ttoolbar_dr_function_id=parent.Pat_Search_Toolbar_Frame.document.search_toolbar.toolbar_dr_function_id.value;\n\t\t\t}\n\t\t\t//Below line modified for this CRF HSA-CRF-0289\n\t\t\tparent.Pat_Search_Criteria_Frame.location.href=\"\"+REPLC_LOC+\"jsp_name=\"+cr_jsp_name+\"&window_styl=\"+cr_window_styl+\"&close_yn=\"+cr_close_yn+\"&win_top=\"+cr_win_top+\"&win_width=\"+cr_win_width+\"&win_height=\"+cr_win_height+\"&act_yn=\"+cr_act_yn+\"&srr=\"+cr_srr+\"&register_button_yn=\"+cr_register_button_yn+\"&func_act=\"+cr_func_act+\"&default_gender=\"+cr_defaultgender+\"&enable_gender_yn=\"+cr_enablegenderyn+\"&dr_function_id=\"+cr_function_id+\"&func_idpassed=\"+cr_func_idpassed+\"&patient_class=\"+patient_class+\"&alterIdSearch=\"+alterIdSearch+\"&isAlternateId=\"+isAlternateId;\n\t\t\tparent.Pat_Search_Toolbar_Frame.location.href = \"../jsp/SearchToolbar.jsp?register_button_yn=\"+register_button_yn+\"&func_act=\"+toolbar_func_act+\"&dr_function_id=\"+toolbar_dr_function_id;\n\t\t\tparent.Pat_Results_Frame.location.href = \'../../eCommon/html/blank.html\'\n\t\t\tparent.colurFrame.location.href = \'../../eCommon/html/blank.html\'\n\t\t\tparent.messageFrame.location.href = \'../../eCommon/html/blank.html\'\n\t}\n\t\t\n\t\t// bellow function added by Vedesh A D for edge Converstion \n\t\tfunction closeWidow()\n\t\t{\n\t\t\t/* Code Added by Vedesh A D for Edge Conversion */\n\t\t\tvar dialogTagFrame = \"\";\n\t\t\tvar dialogBodyFrame = \"\";\n\t\t\tconst diagElement = top.document.getElementsByTagName(\"dialog\");\n            var i = 0; var j = 0;\n            for (i = 0; i < diagElement.length; i++) \n    \t\t{\n            \tfor (j = 0; j < diagElement[i].children.length; j++) \n\t\t\t\t{\n            \t\tvar element = diagElement[i].children[j];\n            \t\tlet dialogSrc = element.src;\n            \t\tif (typeof dialogSrc !== \"undefined\")\n            \t\t{ \n        \t    \t\tif (dialogSrc.includes(\"ModelPatientSearch.jsp\") )\n        \t        \t{\n        \t    \t\t\tdialogTagFrame = diagElement[i];\n        \t    \t\t\tdialogTagFrame.close();\n        \t        \t}\n            \t\t}    \t\t\n            \t} \n            }\n\t\t}\n\t\t\n</Script>\n</head>\n<body class=\"COMMON_TOOLBAR\" leftmargin=\'0\' topmargin=\'0\' onKeyDown = \'lockKey()\'>\n\t<table border=0 cellpadding=0 cellspacing=0 width=\"100%\">\n\t\t<tr>\n\t\t\t<td class=\"COMMON_TOOLBAR\" width=\"50%\">\n\t\t\t\t\t<input type=\'button\' onclick=\"resetform()\" value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' class=\'BUTTON\'></input>\n\t\t\t\t\t<input type=\'button\' onclick=\"closeWidow()\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' class=\'BUTTON\'></input>\n\t\t\t</td>\n\t\t\t<td class=\"COMMON_TOOLBAR\" align=\"right\" width=\"50%\">\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reset.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.menu.label", java.lang.String .class,"key"));
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
}
