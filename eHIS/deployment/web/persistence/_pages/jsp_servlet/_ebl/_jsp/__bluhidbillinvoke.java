package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __bluhidbillinvoke extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLUHIDBillInvoke.jsp", 1737916851451L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n12-03-2019     100           \tGayathri       AMRI-CRF-0357.1  \n---------------------------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\"src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script>\n\n\n\n\t$(document).ready(function () {\n\t\tvalidate();\n\t});\n\t\n\n \tfunction validate()\n\t{\n\n\t\tvar patient_id=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n \t\tvar function_id=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n \t\tvar function_type=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n \t\tvar func_act=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n \t\tvar module_id=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\tvar pat_ser_code=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\tvar calledfrmUHID1=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n \t\n \t\t$.ajax({\t\t\n \t\t\ttype:\"POST\",\n \t\t\turl:\"../../servlet/eBL.BLUHIDBillInvokeServlet?patient_id=\"+patient_id+\"&str_pat_ser_code=\"+pat_ser_code+\"&episode_type=R\"+\"&module_id=\"+module_id+\"&function_id=\"+function_id,\n \t\t\tsuccess: function(data){\n \t\t\t\t\n \t\t\t\t\n \t\t\t\tvar retVal = trimString(data).split(\"::\");\n \t\t\t\tvar errorFlag=retVal[0];\n\n \t\t\t\t\n \t\t\t\tif(errorFlag==\'N\'){\n \t\t\t\tvar str_bill_gen_later=retVal[1];\n \t\t\t\tvar bill_gen_later=retVal[2];\n \t\t\t\tvar str_blng_grp=retVal[3];\n \t\t\t\tvar called_frm=retVal[4];\n \t\t\t\tvar bill_doc_type=retVal[7];\n \t\t\t\tvar bill_doc_number=retVal[8];\n \t\t\t\tvar retValue = \"\";\n \t\t\t\tvar dialogHeight = \"40\";\n \t\t\t\tvar dialogWidth = \"70\";\n \t\t\t\tvar dialogTop = \"100\";\n \t\t\t\tvar center = \"1\";\n \t\t\t\tvar status = \"no\";\n \t\t\t\tvar column_sizes = escape(\"\");\n \t\t\t\tvar column_descriptions = \"\";\n \t\t\t\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; scroll: yes \" + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n \t\t\t\tvar arguments = \"\";\n\t\t\t\tvar url = \"../../eBL/jsp/BLCallDiscOrSlmtPage.jsp?bill_doc_type_code=\" + bill_doc_type + \"&bill_doc_num=\" + bill_doc_number + \"&blng_grp=\" + str_blng_grp + \"&module_id=\"+module_id+\"&column_sizes=\" + column_sizes + \"&column_descriptions=\" + column_descriptions+\"&patient_id=\"+patient_id+\"&call_disc_function_yn=\"+str_bill_gen_later+\"&episode_type=R\"+\"&called_frmUHID=Y\";\n \t\t\t\tretValue = window.showModalDialog(url, arguments, features);\n \t\t\t\twhile(retValue==undefined){\n \t\tretValue = window.showModalDialog(url, arguments, features);\n \t\t\t\t}\n\n\n \t\t\t\t}\n\n \t\telse \n \t\t{\n\n \t\tvar error_txt=retVal[2];\n \t\tvar msg_id=retVal[1];\n\n \t\tif(msg_id!=\'\' && msg_id !=\'null\')\n \t\t\t\n \t\t\t{\n \t\t\t\talert(getMessage(msg_id,\"BL\"));\n \t\t\t\n \t\t\t}\n\n \t\telse if (error_txt !=\'\' && error_txt !=\'null\'){\n \t\t\t\n \t\t\talert(error_txt);\n \t\t}\n \t\t}\n\n \t\t\t},\n \t\t\terror: function(data){\t\n \t\t    }\n \t\t});\n\n\n\n\n\t} \n</script>\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);



 String module_id="MP";//request.getParameter("module_id");
String function_id=request.getParameter("function_id");
String function_type=request.getParameter("function_type");
String func_act=request.getParameter("func_act");
String patient_id=request.getParameter("patient_id");
String str_pat_ser_code=request.getParameter("str_pat_ser_code");
String calledfrmUHID="Y";


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(str_pat_ser_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(calledfrmUHID));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
