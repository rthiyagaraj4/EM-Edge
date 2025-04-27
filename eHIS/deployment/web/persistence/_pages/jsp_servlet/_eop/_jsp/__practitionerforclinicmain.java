package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __practitionerforclinicmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/PractitionerForClinicMain.jsp", 1715832410803L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t<body CLASS=\'MESSAGE\' onKeyDown = \'lockKey();\'>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\tparent.document.f_query_add_mod.document.forms[0].reslookup_butt.disabled=true;\n                parent.document.f_query_add_mod.document.forms[0].res_type.disabled=false; \n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- <script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar opt=\"\";\n\t\t\t\t\t\t\t\topt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\t\t\tif(parent.document.f_query_add_mod.document.forms[0].res_unit != null)\n\t\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].res_unit.add(opt);\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<script>\n\t\t\t\tparent.document.f_query_add_mod.document.forms[0].res_type.disabled=false;\n\t\t\t\t</script>\n\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t var opt=parent.document.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\t\t\tif(parent.document.f_query_add_mod.document.forms[0].res_type != null)\n\t\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].res_type.add(opt);\n\n\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" != \"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].res_type.value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].res_type.disabled=true;\n\n\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.forms[0].res_type.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' ==\"W\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\teval(parent.f_query_add_mod.document.getElementById(\"week_appl_day_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")).innerText=getLabel(\'Common.specific.label\',\'Common\');\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\teval(parent.f_query_add_mod.document.getElementById(\"week_appl_day_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\")).innerText=getLabel(\'Common.all.label\',\'Common\');;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].pract_week_appl_day_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\").value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].working_week_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="_day_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\").value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\n\t\t\t\t\t\t\t\t\tif(eval(\"parent.f_query_add_mod.document.forms[0].working_week_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\").value == \"W\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].working_week_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\").checked = true;\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse if(eval(\"parent.f_query_add_mod.document.forms[0].working_week_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\").value ==\"N\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].working_week_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\").checked = false;\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse if(eval(\"parent.f_query_add_mod.document.forms[0].working_week_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\").value ==\"H\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].working_week_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\").checked = false;\n\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="1\").value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\n\t\t\t\t\t\t\t\t\tif(eval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\").value == \"W\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\").checked = true;\n\t\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\").disabled = false;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse if(eval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\").value ==\"N\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\").checked = false;\n\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\").disabled = true;\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse if(eval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\").value ==\"H\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\").checked = false;\n\t\t\t\t\t\t\t\t\t\teval(\"parent.f_query_add_mod.document.forms[0].pract_working_week_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\").disabled = true;\n\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar opt1=parent.f_query_add_mod.document.createElement(\"OPTION\");\t\t\t\t\n\t\t\t\t\t\t\t\topt1.text=getLabel(\'Common.room.label\',\'Common\');\n\t\t\t\t\t\t\t\topt1.value=\"R\";\t\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].res_class.add(opt1);\t\n\t\t\t\t\t\t\t\topt1=parent.f_query_add_mod.document.createElement(\"OPTION\");\t\n\t\t\t\t\t\t\t\topt1.text=getLabel(\'Common.equipment.label\',\'Common\');\n\t\t\t\t\t\t\t\topt1.value=\"E\";\t\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].res_class.add(opt1);\n\t\t\t\t\t\t\t\topt1=parent.f_query_add_mod.document.createElement(\"OPTION\");\t\n\t\t\t\t\t\t\t\topt1.text=getLabel(\'Common.other.label\',\'Common\');\n\t\t\t\t\t\t\t\topt1.value=\"O\";\t\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].res_class.add(opt1);\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar opt1=parent.f_query_add_mod.document.createElement(\"OPTION\");\t\n\t\t\t\t\t\t\t\topt1.text=getLabel(\'Common.practitioner.label\',\'Common\');\n\t\t\t\t\t\t\t\topt1.value=\"P\";\t\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].res_class.add(opt1);\n\t\t\t\t\t\t\t\topt1=parent.f_query_add_mod.document.createElement(\"OPTION\");\t\n\t\t\t\t\t\t\t\topt1.text=getLabel(\'Common.room.label\',\'Common\');\n\t\t\t\t\t\t\t\topt1.value=\"R\";\t\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].res_class.add(opt1);\t\n\t\t\t\t\t\t\t\topt1=parent.f_query_add_mod.document.createElement(\"OPTION\");\t\n\t\t\t\t\t\t\t\topt1.text=getLabel(\'Common.equipment.label\',\'Common\');\n\t\t\t\t\t\t\t\topt1.value=\"E\";\t\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].res_class.add(opt1);\n\t\t\t\t\t\t\t\topt1=parent.f_query_add_mod.document.createElement(\"OPTION\");\t\n\t\t\t\t\t\t\t\topt1.text=getLabel(\'Common.other.label\',\'Common\');\n\t\t\t\t\t\t\t\topt1.value=\"O\";\t\n\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].res_class.add(opt1);\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tvar routine=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\';\n\t\t\t\t\t    var first=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\';\n\t\t\t\t\t\tvar fwup=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\';\n\t\t\t\t\t\tvar ser=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\';\n\t\t\t\t\t\tvar consul=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\';\n\t\t\t\t\t\tvar emer=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\';\n\t\t\t\t\t\t\n\n\t\t\t\t\t\t   if(routine==\"N\"){\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].routine.checked=false;\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].routine.value=\'N\';\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].routine1.value=\'N\';\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].routine.disabled=true;  \n\t\t\t\t\t\t   }else{\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].routine.disabled=false;  \n\t\t\t\t\t\t   parent.f_query_add_mod.document.forms[0].routine.checked=true;\n\t\t\t\t\t\t   parent.f_query_add_mod.document.forms[0].routine.value=\'Y\';\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].routine1.value=\'Y\';\n\t\t\t\t\t\n\t\t\t\t\t\t   }\n\t\t\t\t\t\tif(first==\"N\"){\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].first.checked=false;\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].first.disabled=true;  \n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].first.value=\'N\';\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].first1.value=\'N\';  \n\t\t\t\t\t\t\n\t\t\t\t\t\t   }else{\n\t\t\t\t\t\t\t  parent.f_query_add_mod.document.forms[0].first.value=\'Y\';\n\t\t\t\t\t\t    parent.f_query_add_mod.document.forms[0].first1.value=\'Y\';\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].first.disabled=false;  \n\t\t\t\t\t\t   parent.f_query_add_mod.document.forms[0].first.checked=true;\n\t\t\t\t\t\t   }\n\t\t\t\t\t\tif(fwup==\"N\"){\n\t\t\t\t\t\t\t parent.f_query_add_mod.document.forms[0].follow.value=\'N\';\n\t\t\t\t\t\t    parent.f_query_add_mod.document.forms[0].follow1.value=\'N\';\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].follow.checked=false;\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].follow.disabled=true;  \n\t\t\t\t\t\t   }else{\n\t\t\t\t\t\t\t    parent.f_query_add_mod.document.forms[0].follow.value=\'Y\';\n\t\t\t\t\t\t    parent.f_query_add_mod.document.forms[0].follow1.value=\'Y\';\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].follow.disabled=false;  \n\t\t\t\t\t\t   parent.f_query_add_mod.document.forms[0].follow.checked=true;\n\t\t\t\t\t\t   }\n\t\t\t\t\t\tif(ser==\"N\"){\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].series.value=\'N\';\n\t\t\t\t\t\t    parent.f_query_add_mod.document.forms[0].series1.value=\'N\';\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].series.checked=false;\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].series.disabled=true;  \n\t\t\t\t\t\t   }else{\n\t\t\t\t\t\t\t   parent.f_query_add_mod.document.forms[0].series.value=\'Y\';\n\t\t\t\t\t\t    parent.f_query_add_mod.document.forms[0].series1.value=\'Y\';\n\t\t\t\t\t\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].series.disabled=false;  \n\t\t\t\t\t\t   parent.f_query_add_mod.document.forms[0].series.checked=true;\n\t\t\t\t\t\t   }\n\t\t\t\t\t\tif(consul==\"N\"){\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].consult.value=\'N\';\n\t\t\t\t\t\t    parent.f_query_add_mod.document.forms[0].consult1.value=\'N\';\n\t\t\t\t\t\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].consult.checked=false;\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].consult.disabled=true;  \n\t\t\t\t\t\t   }else{\n\t\t\t\t\t\t\t   \n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].consult.value=\'Y\';\n\t\t\t\t\t\t    parent.f_query_add_mod.document.forms[0].consult1.value=\'Y\';\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].consult.disabled=false;  \n\t\t\t\t\t\t   parent.f_query_add_mod.document.forms[0].consult.checked=true;\n\t\t\t\t\t\t   }\n\t\t\t\t\t\tif(emer==\"N\"){\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].emergency.value=\'N\';\n\t\t\t\t\t\t    parent.f_query_add_mod.document.forms[0].emergency1.value=\'N\';\n\t\t\t\t\t\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].emergency.checked=false;\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].emergency.disabled=true;  \n\t\t\t\t\t\t   }else{\n\t\t\t\t\t\t\t   parent.f_query_add_mod.document.forms[0].emergency.value=\'Y\';\n\t\t\t\t\t\t    parent.f_query_add_mod.document.forms[0].emergency1.value=\'Y\';\n\t\t\t\t\t\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].emergency.disabled=false;  \n\t\t\t\t\t\t   parent.f_query_add_mod.document.forms[0].emergency.checked=true;\n\t\t\t\t\t\t   }\n\n\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t<script>\t\t\n\t\t\t\t\t\t parent.f_query_add_mod.document.forms[0].rd_appl_yn.value=\"Y\";\n\t\t\t\t\t\t parent.f_query_add_mod.document.forms[0].res_class.selectedIndex=3;\n\t\t\t\t\t\t parent.f_query_add_mod.document.forms[0].res_class.onchange();\n\t\t\t\t\t\t parent.f_query_add_mod.document.forms[0].res_class.disabled=true;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

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

		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String facilityid=(String)session.getValue("facility_id");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		StringBuffer sql1= new StringBuffer();
		
	try
	{
		con=ConnectionManager.getConnection(request);
		String step=request.getParameter("step");
		String funcid=request.getParameter("fun_name");
		String carelocntype="";
	
		if(step.equals("1"))
		{
			String unittype=request.getParameter("unittype");
			
			/*if(unittype.equals("C"))
			{
				sql="select clinic_code , long_desc from op_clinic where care_locn_type_ind='C' and facility_id='"+facilityid+"' and eff_status='E' order by long_desc";	
				
			}
			else if(unittype.equals("E"))
			{
				sql="select clinic_code , long_desc from op_clinic where care_locn_type_ind='E' and facility_id='"+facilityid+"' and eff_status='E' order by long_desc";

			}
			else if(unittype.equals("Y"))
			{
				sql="select clinic_code , long_desc from op_clinic where care_locn_type_ind='D' and facility_id='"+facilityid+"' and eff_status='E' order by long_desc";
			} */	
			
			if(unittype.equals(""))
			{
			
            _bw.write(_wl_block8Bytes, _wl_block8);
}
			String desc="";
			String code="";
			
			/*if(!sql.equals(""))
			{
				String desc="";
				String code="";
				try{
					
					pstmt=con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					if(rs != null)
					{
						while(rs.next())
						{
							desc=rs.getString(2);
							code=rs.getString(1);*/
						 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(code));
            _bw.write(_wl_block11Bytes, _wl_block11);

						/*}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

				}catch(Exception e)
				{
					
				}
			}*/
		}
		else if(step.equals("2"))
		{
			String resourceclass=request.getParameter("resourceclass");
			String res_unit=request.getParameter("res_unit");
			
			String practtype="";


			String clsql="select pract_type from op_clinic where clinic_code='"+res_unit+"' and primary_resource_class ='"+resourceclass+"' ";

			pstmt=con.prepareStatement(clsql);
			rs=pstmt.executeQuery();
			if(rs != null && rs.next())
			{
				practtype=(rs.getString("pract_type") == null)?"":rs.getString("pract_type");
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			
			if(resourceclass.equals("P"))
			{
				sql="select pract_type, desc_sysdef from am_pract_type where eff_status='E' order by desc_sysdef";
			}
			else if(resourceclass.equals("R"))
			{
				sql="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' order by short_desc";
			}			
			else if(resourceclass.equals("E"))
			{
				sql="select resource_type,short_desc from am_resource_type where resource_class='E' order by short_desc";
			}
			else if(resourceclass.equals("O"))
			{
				sql="select resource_type,short_desc from am_resource_type where resource_class='O' order by short_desc";
			}
			
			if(resourceclass.equals(""))
			{
            _bw.write(_wl_block12Bytes, _wl_block12);
}
			
			if(!sql.equals(""))
			{
				String desc="";
				String code="";
			try{
					pstmt=con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					if(rs != null)
					{
						while(rs.next())
						{
							code=rs.getString(1);
							desc=rs.getString(2);
							
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(practtype));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(practtype));
            _bw.write(_wl_block16Bytes, _wl_block16);

						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		else if(step.equals("3"))
		{			
			String callfunc=(request.getParameter("callfunc") == null)?"":request.getParameter("callfunc");
			String unittype="";
			String resunit="";
			String resclass="";
			String opentoallpract="";
					
			
			
			if(callfunc.equals("Pract_for_clinic"))
			{
				unittype="C";
				resunit=request.getParameter("clinic");
				funcid="insert";
				carelocntype=request.getParameter("carelocntype");
				
			}
			else if(callfunc.equals("Resource_unit"))
			{
				unittype=request.getParameter("unittype");
				resunit=request.getParameter("resourceunit");
				carelocntype=request.getParameter("carelocntype");
			}
			
			
			try{
				
				String firstvisit="";
				String followup="";
				String series="";
				String routine="";
				String emergency="";
				String consult="";
				String speciality_code="";
				String rd_appl_yn="";

				if(!callfunc.equals(""))
				{
					sql1.append("select clinic_code,working_week_1_day_1,working_week_1_day_2,working_week_1_day_3,working_week_1_day_4,working_week_1_day_5,working_week_1_day_6,working_week_1_day_7");
					sql1.append(",working_week_2_day_1,working_week_2_day_2,working_week_2_day_3,working_week_2_day_4,working_week_2_day_5,working_week_2_day_6,working_week_2_day_7");
					sql1.append(",working_week_3_day_1,working_week_3_day_2,working_week_3_day_3,working_week_3_day_4,working_week_3_day_5,working_week_3_day_6,working_week_3_day_7");
					sql1.append(",working_week_4_day_1,working_week_4_day_2,working_week_4_day_3,working_week_4_day_4,working_week_4_day_5,working_week_4_day_6,working_week_4_day_7");
					sql1.append(",working_week_5_day_1,working_week_5_day_2,working_week_5_day_3,working_week_5_day_4,working_week_5_day_5,working_week_5_day_6,working_week_5_day_7 ");
					sql1.append(",working_week_appl_day_1,working_week_appl_day_2,working_week_appl_day_3,working_week_appl_day_4,working_week_appl_day_5,working_week_appl_day_6,working_week_appl_day_7 ");
					sql1.append(",working_day_1,working_day_2,working_day_3,working_day_4,working_day_5,working_day_6,working_day_7 ,open_to_all_pract_yn ,primary_resource_class ");

					sql1.append(",FI_VISIT_TYPE_APPL_YN, FU_VISIT_TYPE_APPL_YN, RT_VISIT_TYPE_APPL_YN, SR_VISIT_TYPE_APPL_YN, CS_VISIT_TYPE_APPL_YN, EM_VISIT_TYPE_APPL_YN,SPECIALITY_CODE,rd_appl_yn ");
					sql1.append(" from op_clinic where care_locn_type_ind = '"+carelocntype+"' and clinic_type='"+unittype+"' and  clinic_code='"+resunit+"' and facility_id='"+facilityid+"'");
					
					
					pstmt=con.prepareStatement(sql1.toString());
					rs=pstmt.executeQuery();
					rs.next();
										
						firstvisit=rs.getString("FI_VISIT_TYPE_APPL_YN");
						followup=rs.getString("FU_VISIT_TYPE_APPL_YN");
						routine=rs.getString("RT_VISIT_TYPE_APPL_YN");
						series=rs.getString("SR_VISIT_TYPE_APPL_YN");
						consult=rs.getString("CS_VISIT_TYPE_APPL_YN");
                        emergency=rs.getString("EM_VISIT_TYPE_APPL_YN");
                        speciality_code = rs.getString("SPECIALITY_CODE");
                        rd_appl_yn = rs.getString("rd_appl_yn");

					 	out.println("<script>if(parent.f_query_add_mod.document.forms[0].speciality_code){parent.f_query_add_mod.document.forms[0].speciality_code.value='"+speciality_code+"';}</script>");
					
						
						for(int i=1;i<=5;i++)
						{
							for(int j=1;j<=7;j++)
							{
							
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rs.getString("working_week_appl_day_"+j)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(j));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(j));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("working_week_appl_day_"+j)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("working_week_"+i+"_day_"+j)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("working_week_"+i+"_day_"+j)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("working_week_"+i+"_day_"+j)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block43Bytes, _wl_block43);
										
							}
						}

						opentoallpract=rs.getString("OPEN_TO_ALL_PRACT_YN");
						resclass=rs.getString("PRIMARY_RESOURCE_CLASS");
						
						
						if(!unittype.equals("Y"))
					{
						if(funcid.equals("insert")&&callfunc.equals("Resource_unit"))
						{
					
					if(opentoallpract.equals("Y") && resclass.equals("P"))
						{
								
            _bw.write(_wl_block44Bytes, _wl_block44);

								

						}
						else
						{
							
            _bw.write(_wl_block45Bytes, _wl_block45);

						}
						
						}
					}
					if(funcid.equals("insert"))
					{
					
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(routine));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(firstvisit));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(followup));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(series));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(consult));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(emergency));
            _bw.write(_wl_block52Bytes, _wl_block52);


						}
						if(unittype.equals("E") && rd_appl_yn.equals("Y")){
            _bw.write(_wl_block53Bytes, _wl_block53);
}

					

					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();

					sql1.setLength(0);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
  	 }
	}catch(Exception e)
	{
e.printStackTrace();	}
	finally{

		if(con != null)
			ConnectionManager.returnConnection(con,request);

	}
	
            _bw.write(_wl_block54Bytes, _wl_block54);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
