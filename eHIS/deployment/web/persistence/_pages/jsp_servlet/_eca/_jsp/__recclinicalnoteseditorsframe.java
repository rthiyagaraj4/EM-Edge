package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteseditorsframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesEditorsFrame.jsp", 1740387587665L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </title>\n\t<META content=\"text/html; charset=UTF-8\" http-equiv=Content-Type>\n\t<META content=\"MSHTML 5.00.2920.0\" name=GENERATOR>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<!-- \t<script language=\'javascript\' src=\'../../eCA/js/prototype.js\'></script>  -->\n\t<SCRIPT language=\"javascript\" src=\"../../eCommon/js/RTEditor.js\"></SCRIPT>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script language=\'JavaScript\'>\n\nvar HTMLContent = \"<html><body><form name=\\\'ImageRTEditorForm\\\' id=\\\'ImageRTEditorForm\\\' action = \\\'../../eCA/jsp/RTEditor.jsp\\\' method=\\\'post\\\'>\";\nHTMLContent += \"<textarea name = \\\'RTEText\\\' id = \\\'RTEText\\\' style = \\\'visibility:hidden\\\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</textarea>\";\nHTMLContent += \"<input type = hidden name = \'content_editable_yn\'  id = \'content_editable_yn\' value = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\";\n//HTMLContent += \"<input type = hidden name = \'editor_param\' id = \'editor_param\' value = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\";\nHTMLContent += \"</form></body></html>\";\n\nvar controller = parent.RecClinicalNotesSecControlFrame;\n//controller.document.body.innerHTML = \"\";\ncontroller.document.body.insertAdjacentHTML(\'beforeend\', HTMLContent);\n</script>\n</head>\n<body>\n<!-- <FRAMESET ROWS=\"100%,*\" id = \"frameSetIDPainterEditor\" border=\"0\" > -->\n<IFRAME SRC=\"../../eCommon/html/blank.html\" name=\"RecClinicalNotesRTEditorFrame\" id=\"RecClinicalNotesRTEditorFrame\" noresize style=\"height:93vh;width:99vw\"></IFRAME>\n<!--<FRAME SRC=\"../../eCA/jsp/MedPntredit.jsp?sec_hdg_code=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&image_view_counter=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&curr_sec_hdg_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&curr_child_sec_hdg_code=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&patient_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&encounter_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" NAME=\"RecClinicalNotesMediPainterFrame\" noresize> --> <!--Commented for IN061808 -->\n<IFRAME SRC=\"../../eCA/jsp/MedPntredit.jsp?sec_hdg_code=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" NAME=\"RecClinicalNotesMediPainterFrame\" ID=\"RecClinicalNotesMediPainterFrame\" frameborder=0 style=\"height:0vh;width:99vw;\" noresize></IFRAME> <!-- Added style for IN061808 -->\n<!-- </FRAMESET> -->\n<script language=\"JavaScript\">\n\ngetEditor(); \n\nfunction getEditor()\n{\n\tvar controller = parent.RecClinicalNotesSecControlFrame;\n\tcontroller.document.ImageRTEditorForm.target = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.name;\n\tcontroller.document.ImageRTEditorForm.submit();\n}\n</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
-------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------------------------
14/9/2016	IN061808		Raja S										JRE 1.8 issue
-------------------------------------------------------------------------------------------------------------------------------------------------------
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String image_view_counter		=	"";
String RTEText					=	"";
String sec_hdg_code				=	"";
String doc_exists				=	"";
String strContentEditableYn		=	"";
String curr_sec_hdg_code		=	"";
String curr_section_type		=	"";
String curr_result_link_type	=	"";
String curr_result_link_yn		=	"";
String curr_image_linked_yn		=	"";
String curr_child_sec_hdg_code	=	"";
String patient_id				=	"";
String encounter_id				=	"";
String editor_param				=	"";

sec_hdg_code				=	(request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code"));
curr_image_linked_yn		=	(request.getParameter("curr_image_linked_yn")==null?"":request.getParameter("curr_image_linked_yn"));
curr_result_link_type		=	(request.getParameter("curr_result_link_type")==null?"":request.getParameter("curr_result_link_type"));
curr_result_link_yn			=	(request.getParameter("curr_result_link_yn")==null?"":request.getParameter("curr_result_link_yn"));
curr_sec_hdg_code			=	(request.getParameter("curr_sec_hdg_code")==null?"":request.getParameter("curr_sec_hdg_code"));
curr_section_type			=	(request.getParameter("curr_section_type")==null?"":request.getParameter("curr_section_type"));
curr_child_sec_hdg_code		=	(request.getParameter("curr_child_sec_hdg_code")==null?"":request.getParameter("curr_child_sec_hdg_code"));
image_view_counter			=	(request.getParameter("image_view_counter")==null?"":request.getParameter("image_view_counter"));
RTEText						=	(request.getParameter("RTEText")==null?"":request.getParameter("RTEText"));

doc_exists					=	(request.getParameter("doc_exists")==null?"":request.getParameter("doc_exists"));
strContentEditableYn		=	(request.getParameter("content_editable_yn")==null?"Y":request.getParameter("content_editable_yn"));
patient_id					=	(request.getParameter("patient_id")==null?"Y":request.getParameter("patient_id"));
encounter_id					=	(request.getParameter("encounter_id")==null?"Y":request.getParameter("encounter_id"));
editor_param					=	(request.getParameter("editor_param")==null?"":request.getParameter("editor_param"));

if(strContentEditableYn.equals("") )
	strContentEditableYn = "Y";

//RTEText = java.net.URLEncoder.encode(RTEText);

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(RTEText));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strContentEditableYn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(editor_param));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(image_view_counter));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(image_view_counter));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RichTextEditorandMEDIPainter.label", java.lang.String .class,"key"));
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
