package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __dtlinkencounterdoctypecriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTLinkEncounterDocTypeCriteria.jsp", 1709116820466L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\t\n\n<html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eFM/js/DTLinkEncounterVolumeDocType.js\'></script>\n<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction getResults()\n{\n\tvar doc_folder_id\t\t\t= document.forms[0].doc_folder_id.value;\t\n\tvar patient_id\t\t\t\t= document.forms[0].patient_id.value;\t\n\tvar patient_period_specific\t= document.forms[0].patient_period_specific.value;\t\n\tvar from_period\t\t\t\t=  \"\";\n\tvar to_period\t\t\t\t=  \"\";\n\tif (patient_period_specific==\"D\")\n\t{\n\t\tfrom_period\t\t\t\t= document.forms[0].from_period.value;\t\n\t\tto_period\t\t\t\t= document.forms[0].to_period.value;\t\n\t}\n\tif (doc_folder_id == \"\")\n\t{\n\t\t//alert(\"APP-000001 Document Folder cannot be blank...\");\n\t\tvar msg=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\tmsg=msg.replace(\"$\",getLabel(\"eFM.DocumentFolder.label\",\"FM\"));\n\t\talert(msg);\n\t\tdocument.forms[0].doc_folder_desc.focus();\n\t\treturn;\n\t}\n\telse if (patient_period_specific==\"D\")\n\t{\n\t\tif (document.forms[0].from_period.value == \"\")\n\t\t{\n\t\t\t//alert(\"APP-000001 Period From cannot be blank...\");\n\t\t\tvar msg=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\tmsg=msg.replace(\"$\",getLabel(\"Common.periodfrom.label\",\"common\"));\n\t\t\talert(msg);\n\t\t\tdocument.forms[0].from_period.focus();\n\t\t\treturn;\n\t\t}\n\t\telse if (document.forms[0].to_period.value == \"\")\n\t\t{\n\t\t\t//alert(\"APP-000001 Period To cannot be blank...\");\n\t\t\tvar msg=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\tmsg=msg.replace(\"$\",getLabel(\"Common.periodto.label\",\"common\"));\n\t\t\talert(msg);\n\t\t\tdocument.forms[0].to_period.focus();\n\t\t\treturn;\n\t\t}\n\t}\n\tparent.result_frame.document.location.href=\"../../eFM/jsp/DTLinkEncounterVolumeDocTypeResult.jsp?doc_folder_id=\"+doc_folder_id+\"&action_code=L&maintain_doc_or_file=D&patient_id=\"+patient_id+\"&patient_period_specific=\"+patient_period_specific+\"&from_period=\"+from_period+\"&to_period=\"+to_period;\n\tdocument.forms[0].search.disabled = true;\n}\n</script>\n</head>\n<body onMouseDown = \"CodeArrest();\" onLoad=\"FocusFirstElement();\" onKeyDown = \'lockKey();\'> \n<form name=\'FMLinkEncounterQueryForm\' id=\'FMLinkEncounterQueryForm\' action=\'\' method=\'\'>\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' >\n<tr>\n\t<td class=\"LABEL\" width=\"20%\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t<td class=\'fields\' width=\"20%\"><input type=\'text\' name=\'doc_folder_desc\' id=\'doc_folder_desc\' value=\'\' maxlength=\"30\" size=\"20\" onBlur=\'\' onChange=\'docFolderSearch(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\");\'><input type=\"Hidden\" name=\"doc_folder_id\" id=\"doc_folder_id\" value=\"\"><input type=\'button\' class=\'button\' name=\'doc_fold_search\' id=\'doc_fold_search\' value=\'?\' align=center onClick=\'docFolderSearch(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\");\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t<td class=\"LABEL\"  width=\"15%\" id=\"patient\" >&nbsp;</td>\n\t<td class=\"LABEL\"  width=\"10%\" id=\"patient_detail\" >&nbsp;</td>\n\t<td class=\"LABEL\"  width=\"10%\" id=\"period\"  >&nbsp;</td>\n\t<td class=\"LABEL\"  width=\"20%\" id=\"period_detail\" >&nbsp;</td>\n\t<td  class=\'button\' width=\"5%\"><input type=\'button\' class=\'button\' name=\'search\' id=\'search\' value=\'Search\' onClick=\'getResults();\' style=\'width:60\'>&nbsp;<input type=\'button\' class=\'button\' name=\'clear_page\' id=\'clear_page\' value=\'Clear\' onClick=\'clearAllPage()\' style=\'width:60\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'\'></td>\n</tr>\n</table>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<input type=\"Hidden\" name=\"patient_period_specific\" id=\"patient_period_specific\" value=\"\">\n<input type=\"Hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n<input type=\"Hidden\" name=\"maintain_doc_or_file\" id=\"maintain_doc_or_file\" value=\"D\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection connection			=	null;	

try
{
	String facilityID 	=	(String) session.getAttribute("facility_id");
	if (facilityID==null) facilityID=	"";	
	
	connection		=	ConnectionManager.getConnection(request);	


            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block10Bytes, _wl_block10);

}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{	
	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block11Bytes, _wl_block11);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DocumentFolder.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
