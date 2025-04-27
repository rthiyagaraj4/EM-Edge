package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.Common.CommonBean;
import java.util.*;
import com.ehis.util.*;

public final class __getrelationship extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/GetRelationship.jsp", 1742369968869L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- @ The Page is from New Born Registration on change of gender field the relation is populated. -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<HEAD>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n\t\t <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t\t</link>\n\t\t<script>\n\t\tfunction callchangeid(val,days,sysdate)\n\t\t{\n\n\t\t}\n\t\t</script>\n\t</HEAD>\n<body CLASS=\'MESSAGE\' onKeyDown=\'lockKey();\'>\n<!-- @ Get The Connection and declare the prepared stmt. -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!-- @ Declare the Variables. -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script>\n\t\tvar frame_ref = \"\";\n\t\tif(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'==\'MAINTAIN_BIRTH\')\n\t\t\tframe_ref=\"parent.frames[1].frames[2]\";\n\t\telse\n\t\t\tframe_ref=\"parent.frames[1].frames[2]\";\n\n\t\t\t//alert(\'from jsp\'+eval(frame_ref).location.href);\n\t\t\t\n\t</script>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script>\n\t\t    if(eval(frame_ref).document.forms[0].relation_child11){\n\t\t\tvar n = eval(frame_ref).document.forms[0].relation_child11.options.length;\n\t\t\tfor(var i=0;i<n;i++)\n\t\t\t{\n\t\t\t\t\teval(frame_ref).document.forms[0].relation_child11.remove(\"relation_child11\");\t\t\t\t\n\t\t\t\n\t\t\t}\t\n\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif(eval(frame_ref).document.forms[0].relation_child11){\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\t\n\t\t\t\t\topt.text=temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\t\teval(frame_ref).document.forms[0].relation_child11.add(opt);\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<script>\n                     eval(frame_ref).document.forms[0].exp_cat_date.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t eval(frame_ref).document.forms[0].exp_cat_date.disabled=false\n\t\t\t\teval(frame_ref).document.getElementById(\'callimag\').disabled=false;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t  <script>\t\n\t\t\t    eval(frame_ref).document.forms[0].exp_cat_date.value=\'\';\teval(frame_ref).document.forms[0].exp_cat_date.disabled=true;\t\t\t\teval(frame_ref).document.getElementById(\'callimag\').disabled=true;\n\t\t\t\t </script>\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n        <script>   \n\tif(eval(frame_ref).document.forms[0].relation_child11){\t\n\teval(frame_ref).document.forms[0].relation_child11.selectedIndex=0;\n\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<script>\nvar varFrom = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' ;\nif(varFrom == \'Birth\')\n{\nvar n = eval(frame_ref).document.forms[0].sltRelationship.options.length;\n}\nelse\n{\n\tvar n = eval(frame_ref).document.forms[0].sltRelationship.options.length;\n}\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\tif(varFrom == \'Birth\')\n\t\t\t{\n\t\t\teval(frame_ref).document.forms[0].sltRelationship.remove(\"sltRelationship\");\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\teval(frame_ref).document.forms[0].sltRelationship.remove(\"sltRelationship\");\t\t\n\t\t\t}\n}\t\t\t\t\t\n\t</script>\t        \n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<script>\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t//\talert(temp);\n\t\t\t//\talert(temp1);\n\t\t\t\tif(varFrom == \'Birth\')\n\t\t\t\t{\n\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\n\t\t\t\t}\n\n\t\t\t\t\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\n\t\t\tif(varFrom == \'Birth\')\n\t\t\t\t{\n\t\t\teval(frame_ref).document.forms[0].sltRelationship.add(opt);\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\teval(frame_ref).document.forms[0].sltRelationship.add(opt);\n\t\t\t\t}\t\n\t\t\t\t//alert(eval(frame_ref).document.forms[0].sltRelationship.value);\n\t\t\t</script>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<script>\n\t\tvar tp = \"--\"+eval(frame_ref).getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---\";\n\t\t\tvar opt=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\topt.text=tp;\n\t\t\topt.value=\"\";\n\t\t\teval(frame_ref).document.forms[0].sltRelationship.add(opt);\n\t\t</script>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\n\t\t\t\tif(varFrom == \'Birth\')\n\t\t\t\t{\n\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\n\t\t\t\t}\t\n\t\t\t\t\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"==temp){\n\t\t\t\t//ert(\'coming\');\n\t\t\t\t    opt.selected=true; \n\t\t\t\t\t}\n\n\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\tif(varFrom == \'Birth\')\n\t\t\t\t{\n\t\t\teval(frame_ref).document.forms[0].sltRelationship.add(opt);\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\teval(frame_ref).document.forms[0].sltRelationship.add(opt);\n\t\t\t\t}\t\t\n\t\t\t</script>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<script>\t\t\n\t\t\tparent.frames[1].frames[2].getNewBornRegnValues(\'pat_id\');\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t  <script>\n\t\t\t  eval(frame_ref).document.getElementById(\'name_moth\').innerText=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"\n\t\t\t  </script>\n          ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t <script>\n\t\t\t\t \n\t\t\t\t  eval(frame_ref).document.forms[0].exp_cat_date.value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\n\t\t\t\t  eval(frame_ref).document.getElementById(\'expcatdate\').disabled=false;\n\t\t\t\t  eval(frame_ref).document.getElementById(\'callimag\').disabled=false;\n\t\t\t\t </script>\n\t\t\t ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t <script>\n\t\t\t\t\n\t\t\t\t  eval(frame_ref).document.forms[0].exp_cat_date.value=\'\';\n\t\t\t\t  eval(frame_ref).document.getElementById(\'expcatdate\').disabled=true;\n\t\t\t\t  eval(frame_ref).document.getElementById(\'callimag\').disabled=true;\n\n\t\t\t\t </script>\n\t\t\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<script>\n\t\tvar n = eval(frame_ref).document.forms[0].relation_child.options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\teval(frame_ref).document.forms[0].relation_child.remove(\"relation_child\");\t\t\n\t\t}\t\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<script>\n\t\t\t\tvar temp1 = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\tvar temp=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\t\n\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\t//alert(\"temp1\"+temp1+\"chkval\"+\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\')\n\t\t\tif(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'==temp){\n\t\t\t\t//ert(\'coming\');\n\t\t\t\t    opt.selected=true; \n\t\t\t}\n\t\t\teval(frame_ref).document.forms[0].relation_child.add(opt);\n\t\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\t\t\t\t\n           \n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n<!-- @ Query For the Relation Ship. -->\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' ;\nvar n = eval(frame_ref).document.forms[0].sltRelationship.options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\t\teval(frame_ref).document.forms[0].sltRelationship.remove(\"sltRelationship\");\t\t\t\t\n\t\t\n\t\t}\t\t\t\t\t\n\t</script>\t        \n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\t\n\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\tif(temp==\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\")\n\t\t\t{\n\t\t\t\t\t opt.selected = true;\n\t\t\t}\n\t\t\teval(frame_ref).document.forms[0].sltRelationship.add(opt);\n\t\t\t\n\t\t\t</script>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<script>\n\t\t\tif(eval(frame_ref).document.forms[0].relation_child11){\n\t\t\tvar n = eval(frame_ref).document.forms[0].relation_child11.options.length;\n\t\t\tfor(var i=0;i<n;i++)\n\t\t\t{\n\t\t\t\t\teval(frame_ref).document.forms[0].relation_child11.remove(\"relation_child11\");\t\t\t\t\n\t\t\t\n\t\t\t}\t\n\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\t\n\t\t\t\t\topt.text=temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\t\teval(frame_ref).document.forms[0].relation_child11.add(opt);\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n        <script> \n\t\t\tif(eval(frame_ref).document.forms[0].relation_child11){\n\t\t\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\t\n\t\t\t\t\topt.text=\"---Select---\";\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\teval(frame_ref).document.forms[0].relation_child11.add(opt);\n\t\t\t\t//eval(frame_ref).document.forms[0].relation_child11.selectedIndex=0;\n\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\t\t eval(frame_ref).document.forms[0].exp_cat_date.disabled=false;\n\t\t\t\teval(frame_ref).document.getElementById(\'callimag\').disabled=false;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t  <script>\t\n\t\t\t    eval(frame_ref).document.forms[0].exp_cat_date.value=\'\';\teval(frame_ref).document.forms[0].exp_cat_date.disabled=true;\n\t\t\t\teval(frame_ref).document.getElementById(\'callimag\').disabled=true;\n\t\t\t\t </script>\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n<!-- @ if No Records Found. -->\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\t\t\n\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\tif(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\t\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\t\n\t\t\t\t\topt.text=temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\t   if(\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"==temp)\n\t\t\t\t\t  opt.selected=true; \n\t\t\t\t\teval(frame_ref).document.forms[0].relation_child11.add(opt);\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n        <script>   \n\t\t\tif(eval(frame_ref).document.forms[0].relation_child11)\n\t\teval(frame_ref).document.forms[0].relation_child11.selectedIndex=0;\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\t\t\t\t eval(frame_ref).document.forms[0].exp_cat_date.disabled=false;\n\t\t\t\t\t eval(frame_ref).document.getElementById(\'callimag\').disabled=false;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t  <script>\t\n\t\t\t\t\teval(frame_ref).document.forms[0].exp_cat_date.value=\'\';\n\t\t\t\t\teval(frame_ref).document.forms[0].exp_cat_date.disabled=true;\n\t\t\t\t\teval(frame_ref).document.getElementById(\'callimag\').disabled=true;\n\t\t\t\t </script>\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n<script>\n   \n    var n = eval(frame_ref).document.forms[0].sltRelationship.options.length;\n\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\teval(frame_ref).document.forms[0].sltRelationship.remove(\"sltRelationship\");\t\t\n\t\t\n\t\t}\t\t\t\t\t\n\t</script>\t        \n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t\t\tvar opt=eval(frame_ref).document.createElement(\"OPTION\");\n\t\t\t\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\t\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"==temp){\n\t\t\t\t//ert(\'coming\');\n\t\t\t\t    opt.selected=true; \n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\teval(frame_ref).document.forms[0].sltRelationship.add(opt);\n\t\t\t\t\n\t\t\t</script>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t<script>\t\t\n\t\t\tparent.frames[1].frames[2].getNewBornRegnValues(\'pat_id\');\n\t\t</script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	public static String singleToDoubleQuotes(String strDB)
	{
		/*
		String strModified="";			
		try
		{
			if((strDB != null) ||(strDB !=""))
			{
				StringBuffer stringbuffer = new StringBuffer(strDB);
				int i = 0;
				for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
				{
					i = strDB.indexOf('\'', i);
					stringbuffer.insert(i + j, "'");
					i++;
				}
				strModified=stringbuffer.toString();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		return strDB.replaceAll("'","''");
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con = null;
	PreparedStatement pstmt1 = null;
	ResultSet rset = null;

            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String locale =((String)session.getAttribute("LOCALE"));
	String facilityId  = (String) session.getValue("facility_id");
   	String strSex = request.getParameter("Sex");
	String strFrom = request.getParameter("from");
    Properties p		= (java.util.Properties) session.getValue("jdbc"); 
	String callfunction = checkForNull(request.getParameter("callfunction"));
	String expdate_from = checkForNull(request.getParameter("expdate_from"));
	String patient_id1 = checkForNull(request.getParameter("patient_id1"));
	String function_id_mg = checkForNull(request.getParameter("function_id_mg"));
	String function_id = checkForNull(request.getParameter("function_id"));
	String outcome = checkForNull(request.getParameter("outcome"));
	String callgetNewBornRegnFn = checkForNull(request.getParameter("callgetNewBornRegnFn"));

	String pat_ser_grp_code = checkForNull(request.getParameter("pat_ser_grp_code"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String mother_nursing_unit = checkForNull(request.getParameter("mother_nursing_unit"));
	String sqlRelation = null;
	String strRelationShip = null;
	String strRelationShipCode = null;
	String pat_code_date="";
	String sysdate="";
	String sysadd="";
	int intFlag = 0;
	
	//newly added

	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id_mg));
            _bw.write(_wl_block9Bytes, _wl_block9);



if(callfunction.equals("patcatprefix"))
{
	try{
		con = ConnectionManager.getConnection(request);
	
            _bw.write(_wl_block10Bytes, _wl_block10);

			ArrayList hash_category=new ArrayList();
			String patient_id=request.getParameter("patient_id11");
			String chkvalue=(request.getParameter("prefix"));
			String relvalue=request.getParameter("relation_child");
			hash_category   = eMP.NewbornDetails.getPatCatogery(con,patient_id,chkvalue,relvalue,p);
		if(hash_category.size()>0)
		{
				for(int i=0;i<hash_category.size();i+=2 )
				{
					
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String) hash_category.get(i+1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String) hash_category.get(i)));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}

		
		
				HashMap hasmap_expdate=new HashMap();
				hasmap_expdate=eMP.NewbornDetails.getExpcatdate(con,(String) hash_category.get(1),p);
				String EXP_VAL_APPL_YN=checkForNull((String)hasmap_expdate.get("EXP_VAL_APPL_YN"));
				String sysaddd=checkForNull((String)hasmap_expdate.get("sysadd"));
				if(EXP_VAL_APPL_YN.equals("Y"))
				{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sysaddd));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
				else
				{
            _bw.write(_wl_block16Bytes, _wl_block16);
}
	}
	else{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
	}catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{	
	  if(con!=null) ConnectionManager.returnConnection(con,request);
	}

} else if(callfunction.equals("callOnlineReports")) {

	try
		{
			String sqlString = "";
			
			//sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' AND B.language_id='"+locale+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facilityId+"')='"+facilityId+"' and A.report_id in ('MPBNBFRM', 'MPBWBLBL') order by 2";  		
			sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' AND B.language_id='"+locale+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facilityId+"')='"+facilityId+"'";  		

			//Modified the below validations against HSA-SCF-0059  - Start
			if(outcome.equals("L")){
				//sqlString = sqlString + " and A.report_id in ('MPBNBFRM','MPBFRNST','MPBFLLBL','MPBIDLBL','MPBWBLBL','MPBPTLBL') order by 2";
				//sqlString = sqlString + " and A.report_id in ('MPBNBFRM','MPBFRNST','MPBIDLBL','MPBWBLBL','MPBPTLBL' ";
				sqlString = sqlString + " and A.report_id in ('MPBNBFRM','MPBWBLBL','MPBPTLBL' ";
			}else{
				//sqlString = sqlString + " and A.report_id in ('MPSTBCER') order by 2";
				sqlString = sqlString + " and A.report_id in ('MPSTBCER' ";
			}
			con 	= ConnectionManager.getConnection(request);
			boolean blocPatientFileExists = CommonBean.isPatientFileExists(con,patient_id1,facilityId);

			Boolean isRemoveReport = CommonBean.isSiteSpecific(con, "MP","REMOVE_REP_FROM_NEWBORN");	// Added By Dharma on May 26th 2015 against HSA-CRF-0228 [IN:050965]
			/*Added by Dharma on May 26th 2015 aginst against HSA-CRF-0228 [IN:050965] Start*/
			/*Removed MPBFRNST, MPBIDLBL report ids from above sqlString variable*/
			if(!isRemoveReport){
				sqlString	= sqlString + " , 'MPBFRNST' , 'MPBIDLBL' ";
			}

			/*Added by Dharma on May 26th 2015 aginst against HSA-CRF-0228 [IN:050965] End*/
			if(blocPatientFileExists)
				sqlString = sqlString + " ,'MPBFLLBL') order by 2";
			else
				sqlString = sqlString + ") order by 2";
			//Modified the validations against HSA-SCF-0059  - End
			
			
			String temp_encounter_id="";
			if(encounter_id.equals("")){
				temp_encounter_id="TEMP*12*";
			}
			String reportParamNames	 = "p_patient_id,p_facility_id,p_encounter_id,p_function_id";
		    String reportParamValues = ""+patient_id1+","+facilityId+","+temp_encounter_id+","+function_id+"";
			String htmlFor = "";
			
			htmlFor = htmlFor +" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>";
			htmlFor = htmlFor +"</head><body class='message'>";
			htmlFor = htmlFor +"<script language = 'JavaScript'>" ;
			htmlFor = htmlFor +"  var dialogHeight    = '30' ;";
			htmlFor = htmlFor + " var dialogWidth = '70' ;";
			htmlFor = htmlFor +"  var arguments =   ''; ";
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			htmlFor = htmlFor +"  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=NEWBORN_REG&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&Patient_ID="+patient_id1+"&dest_locn_type=N&dest_locn_code="+mother_nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&P_function_id="+function_id+"';";
			htmlFor = htmlFor +" var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;";
			htmlFor = htmlFor +"  retVal =   window.showModalDialog(getUrl,arguments,features); ";
			htmlFor = htmlFor +" </script>";
			out.println(htmlFor);			
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if(rset!=null) rset.close();
		if(pstmt1!=null) pstmt1.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

} else if(callfunction.equals("Membership")) {
		if(strSex.equals("M"))
		{			
			sqlRelation = "SELECT relationship_code,SHORT_DESC  FROM MP_RELATIONSHIP_lang_vw  WHERE RELATIONSHIP_CODE = (SELECT NB_MALE_RELNSHIP FROM MP_PARAM) and language_id='"+locale+"'";			
		}
		else if(strSex.equals("F"))
		{			
			sqlRelation = "SELECT relationship_code,short_desc FROM MP_RELATIONSHIP_lang_vw WHERE RELATIONSHIP_CODE =	(SELECT NB_FEMALE_RELNSHIP FROM MP_PARAM) and language_id='"+locale+"'";
		}
		else if(strSex.equals("U"))
		{			
			sqlRelation = "SELECT relationship_code ,short_desc FROM MP_RELATIONSHIP_lang_vw WHERE RELATIONSHIP_CODE =	(SELECT NB_UNKNOWN_RELNSHIP FROM MP_PARAM) and language_id='"+locale+"'";			
		}
		else 
		{
			sqlRelation = "SELECT relationship_code ,short_desc FROM MP_RELATIONSHIP_lang_vw where language_id='"+locale+"'";
		}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strFrom));
            _bw.write(_wl_block19Bytes, _wl_block19);

try{
	con = ConnectionManager.getConnection(request);
	HashMap hash17=new HashMap();
	String patient_id2=request.getParameter("patient_id");	
	hash17=eMP.NewbornDetails.getNewBornInMaintain(con,patient_id2);
	String relationship_to_head=checkForNull((String) hash17.get("RELATIONSHIP_TO_HEAD"));
	

try{
		pstmt1 = con.prepareStatement(sqlRelation);
		rset = pstmt1.executeQuery();		
		if(rset != null)
			{
			
			while(rset.next())
			{
				intFlag = 1;
				strRelationShipCode = rset.getString("RELATIONSHIP_CODE");
				strRelationShip = rset.getString("short_desc");					

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strRelationShipCode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strRelationShip));
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
		}

	}
	catch(Exception e)
	 {
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rset != null)rset.close();
		if(pstmt1 != null)pstmt1.close();
	}
	if(intFlag == 0)
	{
	
            _bw.write(_wl_block23Bytes, _wl_block23);

		try{
		sqlRelation = "SELECT RELATIONSHIP_CODE, SHORT_DESC FROM MP_RELATIONSHIP_lang_vw where EFF_STATUS = 'E' and language_id='"+locale+"'ORDER BY 2";
		pstmt1 = con.prepareStatement(sqlRelation);
		rset = pstmt1.executeQuery();
			if(rset != null)
			{
				while(rset.next())
				{
				intFlag = 1;
				strRelationShipCode = rset.getString("RELATIONSHIP_CODE");
				strRelationShip = rset.getString("short_desc");	

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strRelationShipCode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strRelationShip));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(relationship_to_head));
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
			}
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(rset != null)rset.close();
			if(pstmt1 != null)pstmt1.close();		
		}

	}
}
catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{	
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}


if(intFlag == 0)
	{
		out.println("For The Gender No Relationship found");
	}

	if(callgetNewBornRegnFn.equals("Y")) {
		
            _bw.write(_wl_block26Bytes, _wl_block26);

	}

}	///
else if(callfunction.equals("namechange"))
	{
       try
	    {
		  HashMap hashMap2=new HashMap();
		  String name="";
		  con = ConnectionManager.getConnection(request);
		  hashMap2 = eMP.NewbornDetails.getNBMotherDtls(patient_id1, con,p);
		  name=checkForNull((String)hashMap2.get("q_mother_patient_name"));
		  
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(name));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}

	}
	else if(callfunction.equals("expcatdate"))
	{
		try{
			
			  pat_code_date=checkForNull(request.getParameter("cat_code"));
			 con = ConnectionManager.getConnection(request);
			 String sql="select to_char(sysdate,'dd/mm/yyyy') sysdate11,to_char(sysdate+EXP_PERIOD_IN_DAYS,'dd/mm/yyyy') sysadd, EXP_VAL_APPL_YN,EXP_PERIOD_IN_DAYS from mp_pat_category where PAT_CAT_CODE='"+pat_code_date+"'";
			 pstmt1 = con.prepareStatement(sql);
		     rset = pstmt1.executeQuery();
			 String exp_val_appl_yn="";
			 String exp_period_in_days="";
			 if(rset.next())
			 {
				 exp_val_appl_yn=rset.getString("EXP_VAL_APPL_YN");
				 exp_period_in_days=rset.getString("EXP_PERIOD_IN_DAYS");
				 sysdate=rset.getString("sysdate11");
				 sysadd=rset.getString("sysadd");

			 }
			  if(expdate_from.equals("maintain")){
				  if(exp_val_appl_yn.equals("Y"))
			 {
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sysadd));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
}
			  }
			  else
			  {
			 if(exp_val_appl_yn.equals("Y"))
			 {
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sysadd));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
}}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{	
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
	else{
	
		if(strFrom.equals("NEWBORN")){
			String relvalue="";
			ArrayList hash_category=new ArrayList();

	try{
	      con = ConnectionManager.getConnection(request);
	  try{
       
	    ArrayList arraylist14	=  eMP.NewbornDetails.getRelationship(con,p);
	   HashMap hash	=  eMP.NewbornDetails.getNewBornRelation(con,p);
	   String nb_female_relnship=(String)hash.get("nb_female_relnship");
	  // String female_relation_desc=(String)hash.get("female_relation_desc");
	   String nb_male_relnship=(String)hash.get("nb_male_relnship");
	   //String male_relation_desc=(String)hash.get("male_relation_desc");
	   String nb_unknown_relnship=(String)hash.get("nb_unknown_relnship");
	  // String unknown_relation_desc=(String)hash.get("unknown_relation_desc");
	   String relation_desc="";
	   String relation_code="";
	   String chkvalue="";
	   if(strSex.equals("M")){
		   chkvalue=nb_male_relnship;
	   }
	  else  if(strSex.equals("F")){
		   chkvalue=nb_female_relnship;
	   }
	  else if(strSex.equals("U")){
		   chkvalue=nb_unknown_relnship;
	   }

       relvalue=chkvalue;
		    
	
            _bw.write(_wl_block32Bytes, _wl_block32);

		for(int i=0;i<arraylist14.size();i+=2)
		{
			relation_desc=(String)arraylist14.get(i);
			relation_code=(String)arraylist14.get(i+1);

		
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(relation_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(relation_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(chkvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(chkvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
}catch(Exception e)
		{
			e.printStackTrace();
		}
	 intFlag = 0;

            _bw.write(_wl_block39Bytes, _wl_block39);

String name_prefix_male_nb="";       
String name_prefix_female_nb="";       
String sql="select  name_prefix_male_nb,name_prefix_female_nb from mp_param_lang_vw where language_id='"+localeName+"' and module_id='MP'";

		pstmt1 = con.prepareStatement(sql);
		rset = pstmt1.executeQuery();
		if(rset.next())
		{
               name_prefix_male_nb=rset.getString("name_prefix_male_nb");
               name_prefix_female_nb=rset.getString("NAME_PREFIX_FEMALE_NB");
		}
        if(pstmt1!=null) pstmt1.close();
        if(rset!=null) rset.close();
        String chkvalue="";
			if(strSex.equals("M"))
			   chkvalue=name_prefix_male_nb;
		     else if(strSex.equals("F"))
               chkvalue=name_prefix_female_nb;
        if(locale.toUpperCase().equals("EN"))
		 { 
		if(!strSex.equals("U"))
		sqlRelation="SELECT name_prefix, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E' and PREFIX_SEX in('"+strSex+"','B') order by NAME_PREFIX";
		else
		sqlRelation="SELECT name_prefix, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E'  order by NAME_PREFIX";
		 }else
		  {if(!strSex.equals("U"))
		sqlRelation="SELECT (CASE WHEN NAME_PREFIX_LOC_LANG IS NOT NULL THEN NAME_PREFIX_LOC_LANG ELSE  NAME_PREFIX END) NAME_PREFIX, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E' and PREFIX_SEX in('"+strSex+"','B') order by NAME_PREFIX";
		else
		sqlRelation="SELECT (CASE WHEN NAME_PREFIX_LOC_LANG IS NOT NULL THEN NAME_PREFIX_LOC_LANG ELSE  NAME_PREFIX END) NAME_PREFIX, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E'  order by NAME_PREFIX";
		  
		  }

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strFrom));
            _bw.write(_wl_block40Bytes, _wl_block40);


try{
		pstmt1 = con.prepareStatement(sqlRelation);
		rset = pstmt1.executeQuery();		
		if(rset != null)
			{
			
			while(rset.next())
			{
				intFlag = 1;
				strRelationShipCode = rset.getString("name_prefix");
				//strRelationShip = rset.getString("short_desc");		

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strRelationShipCode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strRelationShipCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chkvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);

			}
		}
		//Newly added by Shyam
		String entitlement_by_pat_cat_ynhd=checkForNull(request.getParameter("entitlement_by_pat_cat_ynhd"));
		if(entitlement_by_pat_cat_ynhd.equals("Y")){
            _bw.write(_wl_block43Bytes, _wl_block43);

		 String patient_id=request.getParameter("patient_id");
        hash_category   = eMP.NewbornDetails.getPatCatogery(con,patient_id,chkvalue,relvalue,p);
		
		if(hash_category.size()>0)
		{
				for(int i=0;i<hash_category.size();i+=2 )
				{
					
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String) hash_category.get(i+1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String) hash_category.get(i)));
            _bw.write(_wl_block44Bytes, _wl_block44);


				}
		}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
		//end
		if(hash_category.size()>0){
				HashMap hasmap_expdate=new HashMap();
				hasmap_expdate=eMP.NewbornDetails.getExpcatdate(con,(String) hash_category.get(1),p);
				String EXP_VAL_APPL_YN=checkForNull((String)hasmap_expdate.get("EXP_VAL_APPL_YN"));
				String sysaddd=checkForNull((String)hasmap_expdate.get("sysadd"));
				if(EXP_VAL_APPL_YN.equals("Y"))
				{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sysaddd));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
				else
				{
            _bw.write(_wl_block47Bytes, _wl_block47);
}
			}
				
		}

	}
	catch(Exception e)
	 {
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rset != null)rset.close();
		if(pstmt1 != null)pstmt1.close();
	}
	
	

	
}
catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{	
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}


            _bw.write(_wl_block48Bytes, _wl_block48);

if(intFlag == 0)
	{
		out.println("For The Gender No Relationship found");
	}
	
}

else{
	  String name_prefix="";
	try{
	      HashMap hash_mp_maintan=new HashMap();
		  String patient_id=request.getParameter("patient_id");
		  con = ConnectionManager.getConnection(request);
		  hash_mp_maintan=eMP.NewbornDetails.getNewBornInMaintain(con,patient_id);
		   name_prefix=checkForNull((String) hash_mp_maintan.get("name_prefix"));
		  String relationship_to_head=checkForNull((String) hash_mp_maintan.get("RELATIONSHIP_TO_HEAD"));
		  String pat_cat_code=checkForNull((String) hash_mp_maintan.get("pat_cat_code"));
		  
		  

	  try{
       
	  ArrayList arraylist14	=  eMP.NewbornDetails.getRelationship(con,p);
	   
	   String relation_desc="";
	   String relation_code="";
	    
            _bw.write(_wl_block32Bytes, _wl_block32);

		for(int i=0;i<arraylist14.size();i+=2)
		{
			relation_desc=(String)arraylist14.get(i);
			relation_code=(String)arraylist14.get(i+1);

		
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(relation_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(relation_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(relationship_to_head));
            _bw.write(_wl_block37Bytes, _wl_block37);

			}
			ArrayList hash_category=new ArrayList();
			String mother_patient_id1=request.getParameter("mother_patient_id1");
			hash_category   = eMP.NewbornDetails.getPatCatogery(con,mother_patient_id1,name_prefix,relationship_to_head,p);
		if(hash_category.size()>0)
		{
				for(int i=0;i<hash_category.size();i+=2 )
				{
					
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String) hash_category.get(i+1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String) hash_category.get(i)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block51Bytes, _wl_block51);


				}
		}
		else{
            _bw.write(_wl_block52Bytes, _wl_block52);
}
			if(hash_category.size()>0){
				HashMap hasmap_expdate=new HashMap();
				hasmap_expdate=eMP.NewbornDetails.getExpcatdate(con,(String) hash_category.get(1),p);
				String EXP_VAL_APPL_YN=checkForNull((String)hasmap_expdate.get("EXP_VAL_APPL_YN"));
				String sysaddd=checkForNull((String)hasmap_expdate.get("sysadd"));
				if(EXP_VAL_APPL_YN.equals("Y"))
				{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sysaddd));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
				else
				{
            _bw.write(_wl_block54Bytes, _wl_block54);
}
			}
						
           
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
     
	

	 intFlag = 0;

            _bw.write(_wl_block39Bytes, _wl_block39);

       if(locale.toUpperCase().equals("EN"))
		{
        if(!strSex.equals("U"))
		sqlRelation="SELECT name_prefix, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E' and PREFIX_SEX in('"+strSex+"','B') order by NAME_PREFIX";
		else
		sqlRelation="SELECT name_prefix, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E'  order by NAME_PREFIX";
		}else
		{
		if(!strSex.equals("U"))
		sqlRelation="SELECT (CASE WHEN NAME_PREFIX_LOC_LANG IS NOT NULL THEN NAME_PREFIX_LOC_LANG ELSE  NAME_PREFIX END) NAME_PREFIX , prefix_sex FROM mp_name_prefix WHERE eff_status = 'E' and PREFIX_SEX in('"+strSex+"','B') order by NAME_PREFIX";
		else
		sqlRelation="SELECT (CASE WHEN NAME_PREFIX_LOC_LANG IS NOT NULL THEN NAME_PREFIX_LOC_LANG ELSE  NAME_PREFIX END) MP_NAME_PREFIX, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E'  order by NAME_PREFIX";
		}

            _bw.write(_wl_block55Bytes, _wl_block55);


try{
		pstmt1 = con.prepareStatement(sqlRelation);
		rset = pstmt1.executeQuery();		
		if(rset != null)
			{
			
			while(rset.next())
			{
				intFlag = 1;
				strRelationShipCode = rset.getString("name_prefix");
				//strRelationShip = rset.getString("short_desc");		

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strRelationShipCode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strRelationShipCode));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block57Bytes, _wl_block57);

			}
		}

	}
	catch(Exception e)
	 {
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rset != null)rset.close();
		if(pstmt1 != null)pstmt1.close();
	}
	
	

	
}
catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{	
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}


            _bw.write(_wl_block48Bytes, _wl_block48);

if(intFlag == 0)
	{
		out.println("For The Gender No Relationship found");
	}
	
}
	if(callgetNewBornRegnFn.equals("Y")) {
		
            _bw.write(_wl_block58Bytes, _wl_block58);

	}
	//Control comes here only when if called from MaintainBirthRegister function
 
}
            _bw.write(_wl_block59Bytes, _wl_block59);
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
