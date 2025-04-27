package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __newpractlookupbtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewPractLookupBtn.jsp", 1709238818000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n\n<script>\nfunction ok()\n{\n  var retVal= new String();\n /* for(var i=0;i<14;i++){\n\t\t\n\t  if(eval(parent.frames[1].document.getElementById(\"chk\"+i)).checked == true){\n\t\t\t\n\t\t  var pract_id = eval(parent.frames[1].document.getElementById(\"pract_id\"+i)).value;\t\n\t\t  var Name = eval(parent.frames[1].document.getElementById(\"pract_name\"+i)).value;\t\n\t\t  var tel_no = eval(parent.frames[1].document.getElementById(\"tel_no\"+i)).value;\t\n\t\t  var mobile_no = eval(parent.frames[1].document.getElementById(\"mobile_no\"+i)).value;\t\n\t\t  var pager_no = eval(parent.frames[1].document.getElementById(\"pager_no\"+i)).value;\t\n\t\t  var job_title = eval(parent.frames[1].document.getElementById(\"job_title_practDetails\"+i)).value;\t\n\t\t  var pract_type = eval(parent.frames[1].document.getElementById(\"pract_type\"+i)).value;\t\n\t\t  var pract_type_desc = eval(parent.frames[1].document.getElementById(\"pract_type_desc\"+i)).value;\n\t\t  var position_code = eval(parent.frames[1].document.getElementById(\"job_code\"+i)).value;\t\n\t\t  var position_desc = eval(parent.frames[1].document.getElementById(\"job_title\"+i)).value;\t\n\t\t// alert(unescape(Name));\n\t\t  while(Name.indexOf(\"+\")!=-1)\n\t\t  {\n\t\t\tName=Name.replace(\'+\',\" \");\n\t\t  }\n\t\t   \n\t\t  while(pract_type_desc.indexOf(\"+\")!=-1)\n\t\t  {\n\t\t\tpract_type_desc=pract_type_desc.replace(\'+\',\" \");\n\t\t  }\n\t\t  retVal +=pract_id+\"~\"+unescape(Name)+\"~\"+tel_no+\"~\"+mobile_no+\"~\"+pager_no+\"~\"+job_title+\"~\"+pract_type+\"~\"+pract_type_desc+\"~\"+position_code+\"~\"+position_desc+\"||\"\n\n\t  }\n\n  }*/\n  var pract_retval= eval(parent.frames[1].document.getElementById(\"pract_retval\")).value;\t\n  \n   for(var i=0;i<14;i++){\n\t   \n\t  if(eval(parent.frames[1].document.getElementById(\"chk\"+i)).checked == true){\n\t\t\t\n\t\t  var pract_id = eval(parent.frames[1].document.getElementById(\"pract_id\"+i)).value;\t\n\t\t  var Name = eval(parent.frames[1].document.getElementById(\"pract_name\"+i)).value;\t\n\t\t  var tel_no = eval(parent.frames[1].document.getElementById(\"tel_no\"+i)).value;\t\n\t\t  var mobile_no = eval(parent.frames[1].document.getElementById(\"mobile_no\"+i)).value;\t\n\t\t  var pager_no = eval(parent.frames[1].document.getElementById(\"pager_no\"+i)).value;\t\n\t\t  var job_title = eval(parent.frames[1].document.getElementById(\"job_title_practDetails\"+i)).value;\t\n\t\t  var pract_type = eval(parent.frames[1].document.getElementById(\"pract_type\"+i)).value;\t\n\t\t  var pract_type_desc = eval(parent.frames[1].document.getElementById(\"pract_type_desc\"+i)).value;\n\t\t  var position_code = eval(parent.frames[1].document.getElementById(\"job_code\"+i)).value;\t\n\t\t  var position_desc = eval(parent.frames[1].document.getElementById(\"job_title\"+i)).value;\t\n\t\t// alert(unescape(Name));\n\t\t  while(Name.indexOf(\"+\")!=-1)\n\t\t  {\n\t\t\tName=Name.replace(\'+\',\" \");\n\t\t  }\n\t\t   \n\t\t  while(pract_type_desc.indexOf(\"+\")!=-1)\n\t\t  {\n\t\t\tpract_type_desc=pract_type_desc.replace(\'+\',\" \");\n\t\t  }\n\t\t  \n\t\t  if(pract_retval.indexOf(pract_id) == -1){\n\t\t  pract_retval += pract_id+\"~\"+unescape(Name)+\"~\"+tel_no+\"~\"+mobile_no+\"~\"+pager_no+\"~\"+job_title+\"~\"+pract_type+\"~\"+pract_type_desc+\"~\"+position_code+\"~\"+position_desc+\"||\";\n\t\t  }\n\t\t // alert(\"==in if part===\"+pract_retval);\n\n\t  }else{\n\n\t\t\tvar pract_id = eval(parent.frames[1].document.getElementById(\"pract_id\"+i)).value;\n\t\t\tif(pract_retval.indexOf(pract_id) != -1){\n\t\t\t\tvar int_val= pract_retval.indexOf(pract_id);\n\t\t\t\tvar tmp_retval=\"\";\n\t\t\t\tif(int_val!=0){\n\t\t\t\t\ttmp_retval= pract_retval.substring(0,int_val);\n\t\t\t\t\t//alert(\"tmp_retval==\"+tmp_retval+\"===\"+pract_retval);\n\t\t\t\t\tvar tmp_retval1= pract_retval.substring(int_val,(pract_retval.length));\n\t\t\t\t\t//alert(\"tmp_retval1==\"+unescape(tmp_retval1));\n\t\t\t\t\tvar int_val1= unescape(tmp_retval1).indexOf(\"||\");\n\t\t\t\t\t//alert(int_val);\n\t\t\t\t\tvar tmp_retval2= unescape(tmp_retval1).substring((int_val+2),(tmp_retval1.length));\n\t\t\t\t\t//alert(\"tmp_retval1==\"+tmp_retval+\"===\"+tmp_retval2);\n\t\t\t\t\t\n\t\t\t\t\tpract_retval = tmp_retval+tmp_retval2;\n\t\t\t\t}else{\n\t\t\t\t\tvar int_val= unescape(pract_retval).indexOf(\"||\");\n\t\t\t\t\tvar tmp_retval2= unescape(pract_retval).substring((int_val+2),(pract_retval.length));\n\t\t\t\t\t//alert(\"tmp_retval2====\"+tmp_retval2);\n\t\t\t\t\tpract_retval = tmp_retval2;\n\t\t\t\t}\n\t\t\t\t//alert(\"==in else part===\"+pract_retval);\n\t\t   }\n\n\t  }\n\n  }\n  //alert(retVal);\n  retVal = pract_retval.substring(0,(pract_retval.length-2));\n // alert(\"==\"+retVal.length+\"===\");\n  \n  window.parent.parent.returnValue=retVal;\n  window.parent.close();\n}\nfunction closew()\n{\n  \n  window.parent.parent.returnValue=null;\n  window.parent.close();\n}\n</script>\n \n<body OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n<div align=\'right\'>\n<table  cellpadding=\'0\' cellspacing=\'0\' >\n\t\t\t<tr>\n\t\t\t    <td class=\'button\'>\n\t\t\t\t\t<input type=\'button\' name=\'close\' id=\'close\' value=\'Ok\' onClick=\'ok()\' class=\'button\'>\n\t\t\t\t\t<input type=\'button\' name=\'close\' id=\'close\' value=\'Close\' onClick=\'closew()\' class=\'button\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n</table>\n</div>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
