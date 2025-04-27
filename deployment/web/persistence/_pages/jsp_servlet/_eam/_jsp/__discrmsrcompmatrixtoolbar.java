package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __discrmsrcompmatrixtoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/DiscrMsrCompMatrixToolbar.jsp", 1732544357839L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/common.js\'></SCRIPT>\n\t\t  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t  <script src=\'../../eAM/js/DiscrMsrComp.js\' language=\'javascript\'></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\nfunction checkMatrix()\n{\n\tvar matrix_colSpans = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_colSpans.value;\n\tvar matrix_starting_pos = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_starting_pos.value;\n\tvar matrix_cols = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_cols.value;\n\tvar matrix_rows = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_rows.value;\n\tvar componentDetails = \"\";\n\tvar emptyRowFlag = 0;\n\tvar colHeaders = \"\", rowHeaders = \"\";\n\tvar colHeadersId = \"\",rowHeadersId = \"\";\n\tfor(var i=0;i<matrix_rows;i++)\n\t{\n\t\temptyRowFlag = 0;\n\t\tfor(var j=0;j<matrix_cols;j++)\n\t\t{\n\t\t\tvar componentIdObj = eval(\"parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.member_compID\" + i + j);\t\t\n\t\t\tif(componentIdObj != null)\n\t\t\t{\n\t\t\t\tif(componentIdObj.value == \"\")\n\t\t\t\t\temptyRowFlag++;\n\t\t\t}\n\t\t}\n\t\tif(emptyRowFlag == matrix_cols)\n\t\t{\n\t\t\talert(\'APP-AM10092 Row No...\' + (i+1) + \' does not have all the components defined...\' );\n\t\t\treturn \"\";\n\t\t}\n\t}\n\tvar emptyColumnFlag = 0;\n\tfor(var i=0;i<matrix_cols;i++)\n\t{\n\t\temptyColumnFlag = 0;\n\t\tfor(var j=0;j<matrix_rows;j++)\n\t\t{\n\t\t\tvar componentIdObj = eval(\"parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.member_compID\" + j + i);\t\t\t\n\t\t\tif(componentIdObj != null)\n\t\t\t{\n\t\t\t\tif(componentIdObj.value == \"\")\n\t\t\t\t\temptyColumnFlag++;\n\t\t\t}\n\t\t}\n\t\tif(emptyColumnFlag == matrix_rows)\n\t\t{\n\t\t\talert(\'APP-AM10092 Column No...\' + (i+1) + \' does not have all the components defined...\' );\n\t\t\treturn \"\";\n\t\t}\n\t}\n\tfor(var i=0;i<matrix_rows;i++)\n\t{\t\n\t\tif(componentDetails != \"\")\n\t\t\tcomponentDetails += \"||\";\n\t\tfor(var j=0;j<matrix_cols;j++)\n\t\t{\n\t\t\tvar member_compIDObj = eval(\"parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.member_compID\" + i + j);\n\t\t\tvar member_compDescObj = eval(\"parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.member_compDesc\" + i + j);\n\t\t\tvar member_compTypeObj = eval(\"parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.member_compType\" + i + j);\n\t\t\tif(member_compIDObj != null)\n\t\t\t{\n\t\t\t\tvar temp = (member_compIDObj.value + \"~\" + escape(member_compDescObj.value) + \"~\" + escape(member_compTypeObj.value));\n\t\t\t\ttemp = (temp==\"~~\"?\"9999999999~9999999999~9999999999\":temp);\n\t\t\t\tif(j == 0)\n\t\t\t\t\tcomponentDetails += temp;\n\t\t\t\telse\n\t\t\t\t\tcomponentDetails += (\"|\" + temp);\n\t\t\t}\n\t\t}\n\t}\t\n\tfor(var i =0;i<matrix_cols;i++)\n\t{\n\t\tvar colHeaderObj = eval(\"parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.matrixColHeader_\" + i);\n\t\tvar colHeadersIdObj = eval(\"parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.matrixColHeaderId_C_\" + i);\n\t\tif(colHeaderObj != null )\n\t\t{\n\t\t\tif(colHeaderObj.value == \"\" )\n\t\t\t{\n\t\t\t\talert(\'APP-AM10092 Header for Column \' + (i+1) + \' has not been defined...\' );\n\t\t\t\treturn \"\";\n\t\t\t}\t\t\t\n\t\t\tif(colHeaders == 0)\n\t\t\t{\n\t\t\t\tcolHeaders += escape(colHeaderObj.value);\n\t\t\t\tcolHeadersId += escape(colHeadersIdObj.value);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tcolHeaders += \"~\" + escape(colHeaderObj.value);\n\t\t\t\tcolHeadersId += \"~\" + escape(colHeadersIdObj.value);\n\t\t\t}\n\t\t}\n\t}\n\tfor(var i =0;i<matrix_rows;i++)\n\t{\n\t\tvar rowHeaderObj = eval(\"parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.matrixRowHeader_\" + i);\n\t\tvar rowHeadersIdObj = eval(\"parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm.matrixRowHeaderId_R_\" + i);\n\t\tif(rowHeaderObj != null)\n\t\t{\n\t\t\tif(rowHeaderObj.value == \"\" )\n\t\t\t{\n\t\t\t\talert(\'APP-AM10092 Header for Row \' + (i+1) + \' has not been defined...\' );\n\t\t\t\treturn \"\";\n\t\t\t}\t\t\n\t\t\tif(rowHeaders == 0)\n\t\t\t{\n\t\t\t\trowHeaders += escape(rowHeaderObj.value);\n\t\t\t\trowHeadersId += escape(rowHeadersIdObj.value);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\trowHeaders += \"~\" + escape(rowHeaderObj.value);\n\t\t\t\trowHeadersId += \"~\"+escape(rowHeadersIdObj.value);\n\t\t\t}\n\t\t}\n\t}\n\tvar retVal = matrix_cols + \"$$$\" + matrix_rows + \"$$$\" + matrix_starting_pos + \"$$$\" + matrix_colSpans + \"$$$\" + componentDetails + \"$$$\" + colHeaders + \"$$$\" + rowHeaders+ \"$$$\"+ colHeadersId + \"$$$\" + rowHeadersId;\n\treturn retVal;\n}\nfunction closeAndReturn()\n{\n\tvar matrix_cols = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_cols.value;\n\tvar matrix_rows = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_rows.value;\n\t\n\tif(matrix_cols == \"\" || matrix_rows == \"\")\n\t{\n\t\t//error = (\'APP-CA1050 Please enter all the mandatory fields.... \');\n\t\terror = getMessage(\"AM0169\",\"AM\");\n\n\t\t//messageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\n\t\tparent.messageframe.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\n\t\treturn false;\n\t}else{\n\t\t//messageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp\";\n\t\tparent.messageframe.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n\t}\n\n\tif(matrix_cols == 0)\n\t{\n\t\t\n\t\terror = getMessage(\"AM0170\",\"AM\");\n\t\terror = error.replace(\"$\",\'Matrix Columns\');\n\t\t//messageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\n\t\tparent.messageframe.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\n\t\treturn false;\n\t}else{\n\t\t//messageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp\";\n\t\tparent.messageframe.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n\t}\n\tif(matrix_rows == 0)\n\t{\n\t\t\n\t\terror = getMessage(\"AM0170\",\"AM\");\n\t\terror = error.replace(\"$\",\'Matrix Rows\');\n\t\t//messageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\n\t\tparent.messageframe.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\n\t\treturn false;\n\t}\n    else{\n\t\t//messageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp\";\n    \tparent.messageframe.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n\t}\n\n\tif (parent.templateComponentMatrixAddModifyFrame.document.matrixDefinitionForm){\n\tvar retVal = checkMatrix();\n\tif(retVal != \"\")\n\t{\n\t\t//window.returnValue = retVal;\n\t\t//window.close();\n\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    dialogBody.contentWindow.returnValue = retVal;\n    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close();\n\t}\n}\n}\nfunction onCancel()\n{\n\t//window.close();\n\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    dialogBody.contentWindow.returnValue =  null;\n    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close();\n}\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY onKeyDown = \'lockKey()\'>\n<form name=\"templateComponentMatrixToolbarForm\" id=\"templateComponentMatrixToolbarForm\">\n\t<table width=\"99%\">\n\t\t<tr>\n\t\t\t<td align=\'right\'>\n\t\t\t\t<input type=\"button\" name=\"OK\" id=\"OK\" class=\"button\" value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' onclick=\"closeAndReturn()\">\n\t\t\t\t<input type=\"button\" name=\"Cancel\" id=\"Cancel\" class=\"button\" value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' onclick=\"onCancel()\">\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
