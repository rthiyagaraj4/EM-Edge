package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __newproctermcodebtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcTermCodeBtn.jsp", 1743590077742L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\' />\n\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOR/js/NewProcedureTermCode.js\"></script>\n<script language=\"javascript\">\nfunction ok() {\n\n\tvar frmObj =parent.lookup_detail.document;\n\tif(parent.lookup_detail.document.forms[0] && parent.lookup_detail.document.forms[0].multiple_yn.value == \"Y\")\n\t{\n\t\t/*if(frmObj.term_code_associated != null)\n\t\t{\n\t\t\tretVal =\"\";\n\t\t\tretVal = frmObj.temp_term_code.value;\n\t\t\tvar ret_term_code =\"\";\n\t\t\tret_term_code = frmObj.term_code_associated.value;\n\t\t\t//alert(ret_term_code+\"==\"+retVal);\n\t\t\tvar cnt = \"\";\n\t\t\tif ( parent.lookup_detail.document.getElementById(\"cnt\") != null)\n\t\t\t\t\tcnt = parent.lookup_detail.document.getElementById(\"cnt\").value;\n\t\t\telse\n\t\t\t\tcnt = 0;\n\t\n\t\t\tif ( cnt != 0 )    // If no records are selected or found, nothing should be returned from window.\n\t\t\t{\n\t\t\t  for(var i=2;i<cnt;i++)\n\t\t\t  { \n\t\t\t\tif(eval(\"frmObj.term_chk\"+i).checked){\n\t\t\t\t\tvar code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;\n\t\t\t\t\tvar test_code1 = code1+\"~\";\n\t\t\t\t\t//alert(retVal+\"==\"+test_code1+\"===\"+ret_term_code);\n\t\t\t\t\tif(retVal.indexOf(test_code1) == -1 && ret_term_code.indexOf(code1) == -1){\n\t\t\t\t\t\tretVal += code1+\"~\";\n\t\t\t\t\t\tvar code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;\n\t\t\t\t\t\tvar code2=frmObj.result_tbl.rows(i-1).cells[1].innerText;\n\t\t\t\t\t\tvar code3=frmObj.result_tbl.rows(i-1).cells[2].innerText;\n\t\t\t\t\t\tvar code4=frmObj.result_tbl.rows(i-1).cells[3].children(0).value;\n\t\t\t\t\t\tret_term_code += code1 + \"||\" + code2 + \"||\" + code3 + \"||\" + code4 +\"~\";\n\t\t\t\t\t\t\n\t\t\t\t\t\t//alert(\"===\"+ret_term_code);\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\tvar code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;\n\t\t\t\t\t\n\t\t\t\t\tif(retVal.indexOf(code1) != -1){\n\t\t\t\t\t\tvar ind = retVal.indexOf(code1);\n\t\t\t\t\t\tvar tmp_equ, tmp_equ1 ,tmp_equ2 ;\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(ind != 0){\n\t\t\t\t\t\t\ttmp_equ = retVal.substring(0,ind);\n\t\t\t\t\t\t\ttmp_equ2= retVal.substring(ind , retVal.length);\n\t\t\t\t\t\t\ttmp_equ1= tmp_equ2.substring(0 , (tmp_equ2.indexOf(\"~\")));\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\ttmp_equ1 = retVal.substring(0,(retVal.indexOf(\"~\")));\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//alert(\"retVal===\"+retVal+\"code1==\"+code1+\"==tmp_equ1=\"+tmp_equ1+\"==\");\n\t\t\t\t\t\tif(code1 == tmp_equ1){\n\t\t\t\t\t\t\tvar tmp=\"\";var tmp1=\"\";\n\t\t\t\t\t\t\tvar tmp_desc_equ =\"\", tmp_desc_equ1=\"\" ,tmp_desc_equ2=\"\" ;\n\t\t\t\t\t\t\tif((retVal.indexOf(code1)) != 0){\n\t\t\t\t\t\t\t\ttmp=retVal.substring(0,(retVal.indexOf(code1)));\n\t\t\t\t\t\t\t\tvar tmp_1= retVal.substring((retVal.indexOf(code1))+1,retVal.length);\n\t\t\t\t\t\t\t\ttmp1 = tmp_1.substring((tmp_1.indexOf(\"~\"))+1,tmp_1.length );\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\ttmp_desc_equ =ret_term_code.substring(0,(ret_term_code.indexOf(code1)));\n\t\t\t\t\t\t\t//alert(tmp_desc_equ+\"=============\"+ret_term_code+\"===code1=======\"+code1);\n\t\t\t\t\t\t\t\tvar tmp_desc = ret_term_code.substring((ret_term_code.indexOf(code1)),ret_term_code.length);\n\t\t\t\t\t\t\t//alert(tmp_desc+\"=============\"+ret_term_code+\"===code1=======\"+code1)\n\t\t\t\t\t\t\t\ttmp_desc_equ1 = tmp_desc.substring((tmp_desc.indexOf(\"~\"))+1,tmp_desc.length );\n\t\t\t\t\t\t\t\t//alert(tmp_desc_equ1+\"=============\"+ret_term_code+\"===code1=======\"+code1)\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\ttmp = retVal.substring((retVal.indexOf(\"~\"))+1,retVal.length );\n\t\t\t\t\t\t\t\ttmp_desc_equ = ret_term_code.substring((ret_term_code.indexOf(\"~\"))+1,ret_term_code.length );\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tretVal = tmp + tmp1;\n\t\t\t\t\t\t\t//alert(tmp_desc_equ+\"=\"+tmp_desc_equ1+\"===ret_term_code=======\"+ret_term_code)\n\t\t\t\t\t\t\tret_term_code = tmp_desc_equ + tmp_desc_equ1;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t}\n\t\t\tvar tmp_retArr = ret_term_code.split(\"~\");\n\t\t\t//alert(ret_term_code+\"==\"+tmp_retArr.length+\"====\"+retVal+\"===\");\n\t\t\tif(tmp_retArr.length >11){\n\t\t\t\talert(\"APP-MR0023 Only Ten Selections are allowed\");\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t\n\t\t\ttop.window.returnValue = ret_term_code ;\n\t\t}*/\n\t\tretainCodeChk();\n\t\ttop.window.returnValue = \"C\" ;\n\t    parent.window.close();\n\t}else if(parent.lookup_group.document.forms[0]){\n\t\tretainGrpChk()\n\t\ttop.window.returnValue = \"G\" ;\n\t\tparent.window.close();\n\t}\n}\nfunction closew() {\n\tcall(\"close_values\",\"\");\n\ttop.window.returnValue = parent.lookup_head.document.CriteriaForm.tmp_radioval.value;\n    parent.window.close();\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<div align=\'right\'>\n<table  cellpadding=\'0\' cellspacing=\'0\' >\n\t<tr>\n\t<td >\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<input type=\'button\' name=\'ok\' id=\'ok\' value=\'Ok\' onClick=\'ok()\'  class=\'button\'>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<input type=\'button\' name=\'close\' id=\'close\' value=\'Close\' onClick=\'closew()\' class=\'button\'>\n\t\t</td>\n\t</tr>\n</table>\n</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
 String mulitple_yn = request.getParameter("mulitple_yn")==null?"":request.getParameter("mulitple_yn");
            _bw.write(_wl_block4Bytes, _wl_block4);
if(mulitple_yn.equals("Y")){
            _bw.write(_wl_block5Bytes, _wl_block5);
}
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
