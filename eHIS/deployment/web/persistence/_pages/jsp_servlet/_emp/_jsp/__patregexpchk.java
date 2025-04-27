package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __patregexpchk extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatRegExpChk.jsp", 1742365849826L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/23/2005 11:29 AM -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<SCRIPT>\n\t\t\t\t\tvar obj = parent.frames[0].document.forms[0].locationValue;\n\t\t\t\t\tvar len = Math.abs(obj.length);\n\t\t\t\t\tfor(i=0;i<len;i++) obj.remove(0);\n\t\t\t\t\tvar opt = parent.frames[0].document.createElement(\"OPTION\");\n\t\t\t\t\topt.text = \'---\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'---\';\n\t\t\t\t\topt.value = \'\';\n\t\t\t\t\tparent.frames[0].document.forms[0].locationValue.add(opt);\n\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\t\t\tvar opt = parent.frames[0].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t\t\topt.value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\t\t\tparent.frames[0].document.forms[0].locationValue.add(opt);\n\t\t\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\tvar obj = parent.frames[0].document.forms[0].locationValue;\n\t\t\t\t\t\tvar len = Math.abs(obj.length);\n\t\t\t\t\t\tfor(i=0;i<len;i++) obj.remove(0);\n\t\t\t\t\t\tvar opt = parent.frames[0].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text = \'---\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'---\';\n\t\t\t\t\t\topt.value = \'\';\n\t\t\t\t\t\tparent.frames[0].document.forms[0].locationValue.add(opt);\n\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t//parent.frames[1].frames[0].document.forms[0].patient_id.value = parent.frames[1].frames[0].document.forms[0].refIDValue.value;\n\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<script>alert(getMessage(\"INVALID_PATIENT\",\"MP\"));\n\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].refIDValue.value=\'\';\n\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].refIDValue.focus();\n\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\tsetTimeout(\"parent.frames[1].frames[0].callResultPage(parent.frames[1].frames[0].document.forms[0].refIDValue.value)\",2000);\n\t\t\t\t//\tparent.frames[1].frames[0].callResultPage(parent.frames[1].frames[0].document.forms[0].refIDValue.value);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tsetTimeout(\"parent.frames[1].frames[0].callResultPage(parent.frames[1].frames[0].document.forms[0].refIDValue.value)\",2000);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar msg = getMessage(\'INVALID_VALUE\',\'Common\');\n\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' != \'P\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' == \'A\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tmsg = msg.replace(\'#\',getLabel(\"Common.Appt.RefNo.label\",\"common\"));\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' == \'I\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tmsg = msg.replace(\'#\',getLabel(\"Common.BookingRefNo.label\",\"common\"));\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' == \'L\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tmsg = msg.replace(\'#\',getLabel(\"Common.referralid.label\",\"common\"));\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' == \'R\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tmsg = msg.replace(\'#\',\'RD \'+getLabel(\"Common.referralid.label\",\"common\"));\n\t\t\t\t\t\t}\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].refIDValue.value = \'\';\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t    \tmsg = parent.f_query_add_mod.patient_sub.getMessage(\"ALT_ID_EXP_WITH_GRACE\",\'MP\')\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'== 1)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId1Desc\').value)\n\t\t\t\t\t\t\t\t//msg = msg.replace(\'$\',\"HC.Expiry\")\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'== 2)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId2Desc\').value)\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'== 3)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId3Desc\').value)\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'== 4)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId4Desc\').value)\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'== 1)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id2_no\').focus();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'== 2)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id3_no\').focus();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'== 3)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id4_no\').focus();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'== 4)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.patient_sub.document.getElementById(\'family_link_no\').focus();\n\t\t\t\t\t\t\t}\t\n\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar alt_days = \'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\';\n\t\t\t\t\t\t\t\tvar p_alt_id_diff_days = \'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\n\t\t\t\t\t\t\t\t//alert(parent.f_query_add_mod.patient_sub.getMessage(\"ALT_ID_EXP_WITHIN\")+alt_days+\' days\');\n\t\t\t\t\t\t\t\tmsg = parent.f_query_add_mod.patient_sub.getMessage(\"ALT_ID_EXP_WITHIN\",\'MP\')\n\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'== 1)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId1Desc\').value)\n\t\t\t\t\t\t\t\t\t//msg = msg.replace(\'$\',\'HC.Expiry\')\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'== 2)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId2Desc\').value)\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'== 3)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId3Desc\').value)\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'== 4)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId4Desc\').value)\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\talert( (msg +\" \"+p_alt_id_diff_days+\' days\') );\n\t\t\t\t\t\t\t\tlocation.href = \'../../eCommon/jsp/error.jsp\'\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<script>\n\t\t\t\t\tmsg = parent.f_query_add_mod.patient_sub.getMessage(\'ALT_ID_EXPIRED\',\'MP\')\n\t\t\t\t\tvar eval_txts= \"\";\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'== 1)\n\t\t\t\t\t{\n\t\t\t\t\t\teval_txts = \"parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_exp_date\').focus();\"+\"parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_exp_date\').select();\"\n\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId1Desc\').value)\n\t\t\t\t\t\t//msg = msg.replace(\'$\',\'HC.Expiry\')\n\t\t\t\t\t}\n\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'== 2)\n\t\t\t\t\t{\n\t\t\t\t\t\teval_txts = \"parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id2_exp_date\').focus();\"+\"parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id2_exp_date\').select();\"\n\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId2Desc\').value)\n\t\t\t\t\t}\n\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'== 3)\n\t\t\t\t\t{\n\t\t\t\t\t\teval_txts = \"parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id3_exp_date\').focus();\"+\"parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id3_exp_date\').select();\"\n\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId3Desc\').value)\n\t\t\t\t\t}\n\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'== 4)\n\t\t\t\t\t{\n\t\t\t\t\t\teval_txts = \"parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_exp_date\').focus();\"+\n\t\t\t\t\t\t\"parent.f_query_add_mod.patient_sub.document.getElementById(\'alt_id1_exp_date\').select();\"\n\t\t\t\t\t\tmsg = msg.replace(\'$\',parent.f_query_add_mod.patient_sub.document.getElementById(\'altId4Desc\').value)\n\t\t\t\t\t}\n\t\t\t\t\talert(msg);\n\t\t\t\t\t//Commented by kumar on 15/10/2002 for displaying Expired as Warning always.\n\t\t\t\t\t//eval(eval_txts)\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" : inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	
	try
	{
		request.setCharacterEncoding("UTF-8");
		String facility_id = (String) session.getValue("facility_id");
		String funcId = request.getParameter("funcId");
		if(funcId == null) funcId = "";
		con = ConnectionManager.getConnection(request);
		boolean pat_exists = false;
		if(funcId.equals("registerPatient"))
		{
			java.sql.Statement stmt1 = null;
			ResultSet rst1  = null;
			stmt1 = con.createStatement();
			String short_desc = "";
			String clinic_code = "";
			String nursing_unit_code = "";
			String wing_code = "";

			String calledFor = request.getParameter("calledFor");
			if(calledFor == null || calledFor.equals("null")) calledFor = "";
		
			if(calledFor.equals("popLocation"))
			{
				String location = request.getParameter("location");
				if(location == null) location = "";
		
				if(location.equals("C"))
				{
					
            _bw.write(_wl_block8Bytes, _wl_block8);

					rst1 = stmt1.executeQuery(" SELECT long_desc, clinic_code FROM op_clinic WHERE facility_id = '"+facility_id+"' AND care_locn_type_ind = 'C' AND clinic_type = 'C' AND level_of_care_ind = 'A' AND eff_status = 'E' ORDER BY 1");
				
					if(rst1 != null)
					{ 
						while(rst1.next())
						{ 							
							short_desc = rst1.getString("long_desc");
							clinic_code = rst1.getString("clinic_code");
							if(short_desc == null) short_desc = "";
							if(clinic_code == null) clinic_code = "";
							
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block11Bytes, _wl_block11);

						} 
					}if(rst1 !=null) rst1.close();
				}
				else if(location.equals("E"))
				{
					
            _bw.write(_wl_block8Bytes, _wl_block8);

					rst1 = stmt1.executeQuery(" SELECT long_desc, clinic_code FROM op_clinic WHERE facility_id = '"+facility_id+"' AND care_locn_type_ind = 'E' AND clinic_type = 'E' AND level_of_care_ind = 'A' AND eff_status = 'E' ORDER BY 1");
				
					if(rst1 != null)
					{ 
						while(rst1.next())
						{ 
							
							short_desc = rst1.getString("long_desc");
							clinic_code = rst1.getString("clinic_code");
							if(short_desc == null) short_desc = "";
							if(clinic_code == null) clinic_code = "";
							
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block11Bytes, _wl_block11);

						} 
					}if(rst1 !=null) rst1.close();
				}
				else if(location.equals("Y"))
				{
					
            _bw.write(_wl_block8Bytes, _wl_block8);

					rst1 = stmt1.executeQuery(" SELECT long_desc, clinic_code FROM op_clinic WHERE facility_id = '"+facility_id+"' AND care_locn_type_ind = 'D' AND clinic_type = 'Y' AND level_of_care_ind = 'A' AND eff_status = 'E' ORDER BY 1");
					
					if(rst1 != null)
					{ 
						while(rst1.next())
						{ 
							
							short_desc = rst1.getString("long_desc");
							clinic_code = rst1.getString("clinic_code");
							if(short_desc == null) short_desc = "";
							if(clinic_code == null) clinic_code = "";
							
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block11Bytes, _wl_block11);

						} 
					}if(rst1 !=null) rst1.close();
				}
				else if(location.equals("N"))
				{ 
					
            _bw.write(_wl_block12Bytes, _wl_block12);

					rst1 = stmt1.executeQuery(" SELECT long_desc short_desc, nursing_unit_code FROM ip_nursing_unit_lang_vw WHERE facility_id = '"+facility_id+"' and language_id='"+localeName+"' AND locn_type = 'N' AND patient_class = 'IP' AND eff_status = 'E' ORDER BY 1");
					
					if(rst1 != null)
					{ 
						while(rst1.next())
						{ 
							short_desc = rst1.getString("short_desc");
							nursing_unit_code = rst1.getString("nursing_unit_code");
							if(short_desc == null) short_desc = "";
							if(nursing_unit_code == null) nursing_unit_code = "";
							
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block11Bytes, _wl_block11);

						} 
					}if(rst1 !=null) rst1.close();
				}
				else if(location.equals("W"))
				{ 
					
            _bw.write(_wl_block12Bytes, _wl_block12);

					rst1 = stmt1.executeQuery(" SELECT short_desc, wing_code FROM rd_wings WHERE operating_facility_id = '"+facility_id+"' AND int_or_ext = 'I' AND status IS null ORDER BY 1");
					
					if(rst1 != null)
					{ 
						while(rst1.next())
						{ 
							short_desc = rst1.getString("short_desc");
							wing_code = rst1.getString("wing_code");
							if(short_desc == null) short_desc = "";
							if(wing_code == null) wing_code = "";
							
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(wing_code));
            _bw.write(_wl_block11Bytes, _wl_block11);

						} 
					}if(rst1 !=null) rst1.close();
				}
				if(stmt1 !=null) stmt1.close();
			}
			else
			{
				String RefVal = "";
				String  refrlAappt = request.getParameter("refrlAappt");
				if(refrlAappt == null) refrlAappt = "";
				String  refIDValue = request.getParameter("refIDValue");
				if(refIDValue == null) refIDValue = "";
				
				

				if(refrlAappt.equals("P"))
				{
				
            _bw.write(_wl_block13Bytes, _wl_block13);

						rst1 = stmt1.executeQuery(" select 'X' from mp_patient where patient_id='"+refIDValue+"'");
					if(rst1 != null && rst1.next())
					{
						pat_exists = true;
	
					} if(rst1 !=null) rst1.close();

					if(!pat_exists)
					{
            _bw.write(_wl_block14Bytes, _wl_block14);
					
					}
					else
					{
					
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
				}
				else
				{
				if(refrlAappt.equals("A"))
				{

					rst1 = stmt1.executeQuery(" SELECT 1 AS RefVal FROM oa_appt WHERE facility_id  = '"+facility_id+"' AND appt_ref_no = '"+refIDValue+"' AND appt_status = '1' AND trunc(appt_date) >= trunc(sysdate) AND patient_id IS NULL ");
					if(rst1 != null && rst1.next())
					{
						RefVal = rst1.getString("RefVal");
						if(RefVal == null || RefVal.equals("null")) RefVal = "";
					} if(rst1 !=null) rst1.close();
				}
				else if(refrlAappt.equals("L"))
				{
					rst1 = stmt1.executeQuery(" SELECT 1 AS RefVal FROM pr_referral_register WHERE referral_id = '"+refIDValue+"' AND status = 'O' AND to_facility_id = '"+facility_id+"'  AND ( preferred_treatment_date is null or trunc(preferred_treatment_date) >= trunc(sysdate)) AND patient_id IS NULL");
					
					if(rst1 != null && rst1.next())
					{
						RefVal = rst1.getString("RefVal");
						if(RefVal == null || RefVal.equals("null")) RefVal = "";
					} if(rst1 !=null) rst1.close();
				}
				else if(refrlAappt.equals("I"))
				{
					rst1 = stmt1.executeQuery(" SELECT 1 AS RefVal FROM ip_booking_list WHERE bkg_lst_ref_no = '"+refIDValue+"' AND booking_status = '1'  AND facility_id = '"+facility_id+"' AND  trunc(preferred_date) >= trunc(sysdate) AND patient_id IS NULL");
					
					if(rst1 != null && rst1.next())
					{
						RefVal = rst1.getString("RefVal");
						if(RefVal == null || RefVal.equals("null")) RefVal = "";
					} if(rst1 !=null) rst1.close();
				}
				else if(refrlAappt.equals("R"))
				{
					rst1 = stmt1.executeQuery(" SELECT 1 AS RefVal FROM rd_appt WHERE operating_Facility_id = '"+facility_id+"' AND appt_ref_num = '"+refIDValue+"' AND trunc(appt_date) >= trunc(sysdate) AND patient_id IS NULL AND appt_status = '1' ");
					
					if(rst1 != null && rst1.next())
					{
						RefVal = rst1.getString("RefVal");
						if(RefVal == null || RefVal.equals("null")) RefVal = "";
					} if(rst1 !=null) rst1.close();
				}
				if(RefVal.equals("1"))
				{ 
					
            _bw.write(_wl_block16Bytes, _wl_block16);

				}
				else 
				{	
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(refrlAappt));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(refrlAappt));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(refrlAappt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(refrlAappt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(refrlAappt));
            _bw.write(_wl_block22Bytes, _wl_block22);

					}
				}
			}
		}
		else
		{
			java.sql.Date current_date = null ;
			String  alt_id_exp_date = request.getParameter("expiry_date") ;
			if (localeName.equals("th"))
			{
					alt_id_exp_date = DateUtils.convertDate(alt_id_exp_date,"DMY","th","en");
			}
			String alt_id_exp_warn_yn = "" ;
			String alt_id_adv_alert_reqd_yn = "";
			int alt_id_adv_alert_days = 0 ;
			int  alt_id_exp_grace_days = 0 ;
			java.util.Date p_alt_id_total_exp_date = null ;
			int  IdNo  = Integer.parseInt(request.getParameter("expdateno")) ;
			int p_alt_id_diff_days = 0;
			java.sql.Date p_alt_id_exp_date1 = null;
			String flag = "true";

			java.sql.Statement stmt = con.createStatement() ;
			ResultSet rset = null ;

			StringBuffer expsql=new StringBuffer("");
						
			if(IdNo == 1) 
			{
				expsql.append("Select alt_id1_exp_warn_yn,alt_id1_exp_grace_days, alt_id1_adv_alert_reqd_yn, nvl(alt_id1_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ,");
			}
			if(IdNo == 2) 
			{
				expsql.append("Select alt_id2_exp_warn_yn,alt_id2_exp_grace_days, alt_id2_adv_alert_reqd_yn, nvl(alt_id2_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ," );
			}
			if(IdNo == 3) 
			{
				expsql.append("Select alt_id3_exp_warn_yn,alt_id3_exp_grace_days, alt_id3_adv_alert_reqd_yn, nvl(alt_id3_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ," );
			}
			if(IdNo == 4 ) 
			{
				expsql.append("Select alt_id4_exp_warn_yn,alt_id4_exp_grace_days, alt_id4_adv_alert_reqd_yn, nvl(alt_id4_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/yyyy')-trunc(sysdate) p_alt_id_exp_date ,") ;
			}
			expsql.append(" trunc(sysdate),to_date( '"+alt_id_exp_date+"','dd/mm/yyyy') from mp_param");
			rset = stmt.executeQuery( expsql.toString());
			if(rset.next()) 
			{
				alt_id_exp_warn_yn=rset.getString(1);if(alt_id_exp_warn_yn==null)alt_id_exp_warn_yn="";
				alt_id_exp_grace_days=rset.getInt(2);
				alt_id_adv_alert_reqd_yn = rset.getString(3);if(alt_id_adv_alert_reqd_yn==null) alt_id_adv_alert_reqd_yn="";
				alt_id_adv_alert_days = rset.getInt(4);
				p_alt_id_diff_days = rset.getInt(5);
				current_date=rset.getDate(6);
				p_alt_id_exp_date1 = rset.getDate(7);
			}
			if((expsql != null) && (expsql.length()> 0))
			{
				expsql.delete(0,expsql.length());
			}
			if(alt_id_exp_warn_yn.equals("Y"))
			{
				p_alt_id_total_exp_date=new java.util.Date(p_alt_id_exp_date1.getTime());
				p_alt_id_total_exp_date.setDate(p_alt_id_exp_date1.getDate()+alt_id_exp_grace_days);   
				if((p_alt_id_exp_date1.compareTo(current_date))< 0)
				{
					if((p_alt_id_total_exp_date.compareTo(current_date))< 0)
					{
						flag="false";
					}
					else
					{
						
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block31Bytes, _wl_block31);

					}
				}
			}
				
			if(alt_id_adv_alert_reqd_yn.equals("Y"))
			{
				if((p_alt_id_exp_date1.compareTo(current_date))> 0)
				{
					if (p_alt_id_diff_days > 0) 
					{
						if ( p_alt_id_diff_days <= alt_id_adv_alert_days)
						{
							
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(alt_id_adv_alert_days));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_alt_id_diff_days));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block38Bytes, _wl_block38);

						}
					}
				}
			}
			if(flag.equals("false"))
			{
				
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block43Bytes, _wl_block43);

			}
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
		}
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block44Bytes, _wl_block44);
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
