package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __termcodebutton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TermCodeButton.jsp", 1737458528740L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\' />\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eMR/js/NoteTerminologyCode.js\"></script>\n<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script>\t\n<script language=\"javascript\">\n\nfunction ok() {\n\tvar frmObj = parent.lookup_detail.document.all;\n\tvar chkValues = frmObj.chkValues1.value;\n\t\n\t\n\tif(parent.lookup_detail.document)\n\t{\n\t\tif(frmObj.term_code_associated != null)\n\t\t{\n\t\t\tretVal =\"\";\n\t\t\tretVal = frmObj.temp_term_code.value;\n\t\t\t\n\t\t\t\n\t\t\tvar ret_term_code =\"\";\n\t\t\tret_term_code = frmObj.term_code_associated.value;\n\t\t\t\n\t\t\tvar cnt = \"\";\n\t\t\t\n\t\t\tif ( parent.lookup_detail.document.all.cnt != null)\n\t\t\t\t\tcnt = parent.lookup_detail.document.all.cnt.value;\n\t\t\telse\n\t\t\t\tcnt = 0;\n\t\t\tvar test_code2=\"\";\n\t\t\tif ( cnt != 0 )    /* If no records are selected or found, nothing should be returned from window.*/\n\t\t\t{\n\t\t\t  for(var i=2;i<cnt;i++)\n\t\t\t  { \n\t\t\t\tif(eval(\"frmObj.term_chk\"+i).checked){\n\t\t\t\t\tvar code1=frmObj.result_tbl.rows[i-1].cells[0].innerText;\n\t\t\t\t\tvar test_code1 = code1+\"~\";\n\t\t\t\t\tif(eval(\"frmObj.term_chk\"+i).disabled==true)\n\t\t\t\t\t{}\n\t\t\t\t\telse\n\t\t\t\t\t\t{test_code2 += code1+\"~\"; }\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tvar returnVal2=frmObj.returnVal2.value;\n\t\t\ttest_code2=returnVal2+\"\"+chkValues;\t\n\t\t\tif(test_code2==\'\')\n\t\t\t\t{\n\t\t\t\ttest_code2=\' \';\n\t\t\t\t}\t\n\t\t\tvar term_group_id=frmObj.term_group_id1.value;\n\t\t\tif(term_group_id==\'\')\n\t\t\t\t{\n\t\t\t\tterm_group_id=\' \';\n\t\t\t\t}\n\t\t\tvar term_set_id=frmObj.term_set_id1.value;\n\t\t\tparent.window.returnValue = test_code2+\"$\"+term_group_id+\"$\"+term_set_id;\n\t\t}\n\t    //parent.window.close();\n\t\tconst dialogTag = top.dialogArray[top.dialogArray.length - 1];\n\t    dialogTag.close(); \n\t}\n}\n\nfunction closew() {\n   // parent.window.close ;\n\tconst dialogTag = top.dialogArray[top.dialogArray.length - 1];\n    dialogTag.close(); \n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<div align=\'right\'>\n<table  cellpadding=\'0\' cellspacing=\'0\' >\n\t<tr>\n\t<td class=\'button\'>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<input type=\'button\' name=\'ok\' id=\'ok\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' onClick=\'ok()\'  class=\'button\'>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' onClick=\'closew()\' class=\'button\'>\n\t\t</td>\n\t</tr>\n</table>\n</div>\n</body>\n</html>\n\n";
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

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
 String mulitple_yn = request.getParameter("mulitple_yn")==null?"":request.getParameter("mulitple_yn");

            _bw.write(_wl_block5Bytes, _wl_block5);
if(mulitple_yn.equals("Y")){
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block7Bytes, _wl_block7);
}
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
