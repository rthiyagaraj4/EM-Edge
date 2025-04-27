package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __getvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/GetValues.jsp", 1712140609760L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\tdocument.getElementById(\'locnimg\').style.visibility = \'hidden\';\n\t\t\t\t\tdocument.getElementById(\'locnimg1\').style.visibility = \'hidden\';\t\t\t\t\n\t\t\t\t\tvar tp =\"  -----------\" +getLabel(\"Common.defaultSelect.label\",\"Common\")+ \"--------\"\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].report_id.add(opt);\t\t\t\t\t\n\n\t\t\t\t\tvar facility =\"-----------\" +getLabel(\"Common.defaultSelect.label\",\"Common\")+ \"--------\"\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=facility;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].facility_id.add(opt);\n\n\t\t\t\t\tvar dest_locn_type =\"  -----------\" +getLabel(\"Common.defaultSelect.label\",\"Common\")+ \"--------\"\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=dest_locn_type;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\n\t\t\t\t\tvar dest_locn_code =\"  -----------\" +getLabel(\"Common.defaultSelect.label\",\"Common\")+ \"--------\"\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\t\t\t\t\t\t\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\t\n\t\t\t\t\t\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\t\t\t\t\t\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\t\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.forms[0].report_id.add(opt);\t\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\tvar n=document.forms[0].facility_id.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].facility_id.remove(\"facility_id\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar tp1 =\"  -----------\" +getLabel(\"Common.defaultSelect.label\",\"Common\")+ \"--------\"\n\t\t\t\t\t\tvar opt1=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt1.text=tp1;\n\t\t\t\t\t\topt1.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].facility_id.add(opt1);\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t/*document.forms[0].man.height=0;\n\t\t\t\t\t\tdocument.forms[0].man.width=0;\n\t\t\t\t\t\tdocument.forms[0].man.src =\'\';*/\n\n\t\t\t\t\t\tdocument.forms[0].facility_id.disabled = true;\n\t\t\t\t\t\tdocument.getElementById(\'facimg\').style.visibility = \'hidden\'; \n\t\t\t\t\t\t\n\n\t\t\t\t\t\tvar m=document.forms[0].dest_locn_code.options.length;\n\t\t\t\t\t\tfor(var i=0;i<m;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.remove(\"dest_locn_code\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\tvar n=document.forms[0].facility_id.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].facility_id.remove(\"facility_id\");\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.forms[0].facility_id.disabled = false;\n\t\t\t\t\t\tdocument.getElementById(\'facimg\').style.visibility = \'visible\';\n\t\t\t\t\t\tdocument.forms[0].facilityYN.value=\"Y\";\t\n\n\t\t\t\t\t\tvar tp =\"-----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+ \"--------\"\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].facility_id.add(opt);\n\t\t\t\t\t\t/*document.forms[0].man.height=10\n\t\t\t\t\t\tdocument.forms[0].man.width=10\n\t\t\t\t\t\tdocument.forms[0].man.src =\'../../eCommon/images/mandatory.gif\';*/\n\n\t\t\t\t\t\tvar m=document.forms[0].dest_locn_code.options.length;\n\t\t\t\t\t\tfor(var i=0;i<m;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.remove(\"dest_locn_code\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=  temp1;\n\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\tdocument.forms[0].facility_id.add(opt);\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar txt = new Array(\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\",getLabel(\"Common.clinic.label\",\"Common\"));\n\t\t\t\t\t\t\t\tvar values = new Array(\"\",\"C\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor(var i=0;i<txt.length;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text=txt[i];\n\t\t\t\t\t\t\t\t\topt.value=values[i];\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tvar dest_locn_code =\" ----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------- \";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\tvar txt = new Array(\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\",getLabel(\"Common.clinic.label\",\"Common\"),getLabel(\"Common.ProcedureUnit.label\",\"Common\"));\n\t\t\t\t\t\t\t\tvar values = new Array(\"\",\"C\",\"E\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor(var i=0;i<txt.length;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text=txt[i];\n\t\t\t\t\t\t\t\t\topt.value=values[i];\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tvar dest_locn_code =\" ----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------- \";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t\t\t\t\t\t\tvar txt = new Array(\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\",getLabel(\"Common.DaycareUnit.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"));\n\t\t\t\t\t\t\t\t\tvar values = new Array(\"\",\"Y\",\"N\");\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor(var i=0;i<txt.length;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text=txt[i];\n\t\t\t\t\t\t\t\t\topt.value=values[i];\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tvar dest_locn_code =\" ----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------- \";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\t\t\t\t\t\t\tvar txt = new Array(\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\",getLabel(\"Common.clinic.label\",\"Common\"),getLabel(\"Common.DaycareUnit.label\",\"Common\"),getLabel(\"Common.ProcedureUnit.label\",\"Common\"));\n\t\t\t\t\t\t\t\t\tvar values = new Array(\"\",\"C\",\"Y\",\"E\");\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor(var i=0;i<txt.length;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text=txt[i];\n\t\t\t\t\t\t\t\t\topt.value=values[i];\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tvar dest_locn_code =\" ----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------- \";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t\t\t\t\t\t\tvar txt = new Array(\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\",getLabel(\"Common.DaycareUnit.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.ProcedureUnit.label\",\"Common\"));\n\t\t\t\t\t\t\t\t\tvar values = new Array(\"\",\"Y\",\"N\",\"E\");\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor(var i=0;i<txt.length;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text=txt[i];\n\t\t\t\t\t\t\t\t\topt.value=values[i];\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tvar dest_locn_code =\" ----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------- \";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t\t\t\t\t\t\t\tvar txt = new Array(\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\",getLabel(\"Common.clinic.label\",\"Common\"),getLabel(\"Common.DaycareUnit.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"eFM.PermanentFSLocation.label\",\"FM\"),getLabel(\"Common.ProcedureUnit.label\",\"Common\"));\n\t\t\t\t\t\t\t\t\tvar values = new Array(\"\",\"C\",\"Y\",\"N\",\"F\",\"E\");\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor(var i=0;i<txt.length;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text=txt[i];\n\t\t\t\t\t\t\t\t\topt.value=values[i];\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tvar dest_locn_code =\" ----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------- \";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t\t\t\t\t\t\t\tvar txt = new Array(\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\",getLabel(\"Common.clinic.label\",\"Common\"),getLabel(\"Common.DaycareUnit.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.ProcedureUnit.label\",\"Common\"));\n\t\t\t\t\t\t\t\t\tvar values = new Array(\"\",\"C\",\"Y\",\"N\",\"E\");\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor(var i=0;i<txt.length;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text=txt[i];\n\t\t\t\t\t\t\t\t\topt.value=values[i];\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tvar dest_locn_code =\" ----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------- \";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t\t\t\t\t\t\tvar txt = new Array(\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\",getLabel(\"Common.clinic.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.ProcedureUnit.label\",\"Common\"),getLabel(\"Common.external.label\",\"Common\"));\n\t\t\t\t\t\t\t\t\tvar values = new Array(\"\",\"C\",\"N\",\"E\",\"R\");\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor(var i=0;i<txt.length;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text=txt[i];\n\t\t\t\t\t\t\t\t\topt.value=values[i];\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tvar dest_locn_code =\" ----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------- \";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\t\t\t\t\t\t\t\tvar txt = new Array(\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\",getLabel(\"Common.clinic.label\",\"Common\"),getLabel(\"Common.DaycareUnit.label\",\"Common\"),getLabel(\"Common.nursingUnit.label\",\"Common\"),getLabel(\"Common.pharmacy.label\",\"Common\"),getLabel(\"Common.ProcedureUnit.label\",\"Common\"),getLabel(\"Common.Store.label\",\"Common\"));\n\t\t\t\t\t\t\t\tvar values = new Array(\"\",\"C\",\"Y\",\"N\",\"P\",\"E\",\"S\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor(var i=0;i<txt.length;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text=txt[i];\n\t\t\t\t\t\t\t\t\topt.value=values[i];\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tvar dest_locn_code =\" ----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------- \";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\t\t\t\t\t\t\tdocument.getElementById(\'locnimg\').style.visibility = \'hidden\';\n\t\t\t\t\t\t\tdocument.getElementById(\'locnimg1\').style.visibility = \'hidden\';\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=getLabel(\"Common.Location.label\",\"Common\");\n\t\t\t\t\t\t\topt.value=\"L\";\n\t\t\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\n\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled=false;\n\t\t\t\t\t\t\tdocument.getElementById(\'locnimg1\').style.visibility = \'visible\';\n\t\t\t\t\t\t\tdocument.getElementById(\'locnimg\').style.visibility = \'hidden\';\n\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled=true;\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\tdocument.forms[0].reportclass.value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'\n\t    \t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\tvar n=document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=getLabel(\"eSM.Bitmap.label\",\"SM\");\n\t\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=getLabel(\"eSM.Character.label\",\"SM\");;\n\t\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\tvar n=document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=getLabel(\"eSM.Character.label\",\"SM\");\n\t\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=getLabel(\"eSM.Bitmap.label\",\"SM\");\n\t\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\tvar dest_locn_code1 =\" ----------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"---------- \";\n\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\topt.text=dest_locn_code1;\n\t\t\t\topt.value=\"\";\n\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\n\n\t\t\t\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t\t\t\n\t\t\t\tdocument.getElementById(\'locnimg\').style.visibility = \'visible\';\n\t\t\t\tdocument.getElementById(\'locnimg1\').style.visibility = \'hidden\';\n\t\t\t\tvar common1 = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\tvar err=getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\t\t\t\t\t\t\t\terr=err.replace(\'$\',getLabel(\"Common.facility.label\",\"Common\"));\n\t\t\t\t\t\t\t\tdocument.write(err);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.value=\'\';\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = true;\t\t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar tp =\" -------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" -------\";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\t\t\n\t\t\t\t\t\n\t\t\t\t\tvar tp1 =\"*\"+getLabel(\"Common.all.label\",\"Common\");\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp1;\n\t\t\t\t\topt.value=\"*A\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t                         \n\t\t\t\t\t\t\t var temp = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text= \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\talert(getMessage(\'OP_NOT_INSTALLED\',\'SM\'));\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\talert(getMessage(\'OP_NOT_INSTALLED\',\'SM\'));\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.value=\'\';\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = true;\t\t\t   \n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar tp =\" -------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" -------\";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\n\t\t\t\t\tvar tp1 =\"*\"+getLabel(\"Common.all.label\",\"Common\");\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp1;\n\t\t\t\t\topt.value=\"*A\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\n\t\t\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\talert(getMessage(\'IP_NOT_INSTALLED\',\'SM\'));\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\talert(getMessage(\'IP_NOT_INSTALLED\',\'SM\'));\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.value=\'\';\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = true;\t\t\t   \n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar tp =\" -------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" -------\";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\t\t\n\n\t\t\t\t\tvar tp1 =\"*\"+getLabel(\"Common.all.label\",\"Common\");\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp1;\n\t\t\t\t\topt.value=\"*A\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t   alert(getMessage(\'PH_NOT_INSTALLED\',\'SM\'));\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\talert(getMessage(\'PH_NOT_INSTALLED\',\'SM\'));\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.value=\'\';\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = true;\t\t\t   \n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar tp =\" -------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" -------\";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\t\t\n\n\t\t\t\t\tvar tp1 =\"*\"+getLabel(\"Common.all.label\",\"Common\");\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp1;\n\t\t\t\t\topt.value=\"*A\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\talert(getMessage(\'ST_NOT_INSTALLED\',\'SM\'));\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\talert(getMessage(\'ST_NOT_INSTALLED\',\'SM\'));\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\talert(getMessage(\'OR_NOT_INSTALLED\',\'SM\'));\n\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\talert(getMessage(\'OR_NOT_INSTALLED\',\'SM\'));\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.value=\'\';\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = true;\t\t\t   \n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar tp =\" -------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" -------\";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\t\t\t\t\t\n\n\t\t\t\t\tvar tp1 =\"*\"+getLabel(\"Common.all.label\",\"Common\");\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp1;\n\t\t\t\t\topt.value=\"*A\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.value=\'\';\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = true;\t\t\t   \n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\tvar tp =\" -------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" -------\";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\t\t\t\t\t\n\n\t\t\t\t\tvar tp1 =\"*\"+getLabel(\"Common.all.label\",\"Common\");\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp1;\n\t\t\t\t\topt.value=\"*A\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.value=\'\';\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled =true ;\t\t\t   \n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar tp =\" -------\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" -------\";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\t\t\t\t\t\n\n\t\t\t\t\tvar tp1 =\"*\"+getLabel(\"Common.all.label\",\"Common\");\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp1;\n\t\t\t\t\topt.value=\"*A\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar temp =\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\talert(getMessage(\'FM_NOT_INSTALLED\',\'FM\'));\n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\talert(getMessage(\'FM_NOT_INSTALLED\',\'FM\'));\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t//var temp =\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\t\t\t\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = false;\t\t\n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = true;\t\t\n\t\t\t\t\tdocument.getElementById(\'locnimg\').style.visibility = \'hidden\';\t\t\t\t\t\n\t\t\t\t\tif(document.forms[0].dest_locn_type.value != \'L\')\n\t\t\t\t\t\tdocument.getElementById(\'locnimg1\').style.visibility = \'hidden\';\n\t\t\t\t\telse\n\t\t\t\t\t   document.getElementById(\'locnimg1\').style.visibility = \'visible\';\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"BitMap\";\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"Character\";\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t<script>\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=getLabel(\"eSM.Character.label\",\"SM\");\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=getLabel(\"eSM.Bitmap.label\",\"SM\");\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\n\t\t\t\t\t</script>\n\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t<script>\n\n\t\t\t\t\t\tvar n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=getLabel(\"eSM.Character.label\",\"SM\");\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=getLabel(\"eSM.Bitmap.label\",\"SM\");\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\n\n\t\t\t\t\t</script>\n\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n\t\t\t\t\t<script>\n\n\t\t\t\t\t\tvar n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=getLabel(\"eSM.Bitmap.label\",\"SM\");\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=getLabel(\"eSM.Character.label\",\"SM\");\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t</script>\n\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n\t\t\t\t\t<script>\n\n\t\t\t\t\t\tvar n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=getLabel(\"eSM.Bitmap.label\",\"SM\");\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=getLabel(\"eSM.Character.label\",\"SM\");\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t</script>\n\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=getLabel(\"eSM.Character.label\",\"SM\");\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=getLabel(\"eSM.Bitmap.label\",\"SM\");\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t       </script>\n\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t//\talert(getMessage(\'CANT_MODIFY_MENU\',\'SM\'));\n\t\t\t\t\t//parent.frames[1].document.forms[0].Menu.options(0).selected=true;\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\tdocument.forms[0].norows.value=\'N\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\tdocument.forms[0].norows.value=\'Y\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\n\t\t\t\t\tvar rootyn= \'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\';\n\t\t\t\t\tvar spc=\"\" ;\n\t\t\t\t\tdocument.forms[0].root_menu.value = rootyn;\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\tvar opt_type=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\";\n\t\t\t\t\tif(document.forms[0].root_menu.value == \'N\')\n\t\t\t\t\t\t\tspc=\"              \" ;\n\t\t\t\t\tif(opt_type==\"F\") opt.text= spc  +  \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" ;\n\t\t\t\t\telse opt.text= spc  +\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" ;\n\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" + \"#\" + \"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" + \"#\" + opt_type ;\n\t\t\t\t\tdocument.forms[0].MainMenus.add(opt);\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n\t\t\t\t\t\t\t\tvar spc=\"             \";\n\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\tif(document.forms[0].root_menu.value == \'N\')\n\t\t\t\t\t\t\t\tspc=\"                        \";\n\t\t\t\t\t\t\t\tvar opt_type=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\";\n\t\t\t\t\t\t\t\tif(opt_type==\"F\") opt.text= spc +  \"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" ;\n\t\t\t\t\t\t\t\telse opt.text=spc +\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" ;\n\t\t\t\t\t\t\t\topt.style.color=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" + \"#\" + opt_type ;\n\t\t\t\t\t\t\t\tdocument.forms[0].MainMenus.add(opt);\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" spc+=\"              \";";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\t\t\tvar opt_type=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tif(opt_type==\"F\") opt.text= spc +\"              \"+ \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" ;\n\t\t\t\t\t\t\t\t\t\t\t\telse opt.text=spc+\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" ;\n\t\t\t\t\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" + \"#\" + \"S\" ;\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].MainMenus.add(opt);\n\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" \n\t\t\t\t\t\t\t\t\tspc+=\"              \";\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t//commanded and Added below line by Senthil on 10-Oct-2011 for this incident[IN:027210] \n\t\t\t\t\t//opt.text=  \"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" ;\t\t\t\t\t\n\t\t\t\t\topt.text=  \"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"+\" [\"+\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"+\"]\" ;\n\t\t\t\t\topt.value=\"\" + \"#\" + \"\" + \"#\" + \"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" + \"#\" + \"M\";\t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].SubMenus.add(opt);\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\t\t\t\t\t\t\n\t\t\t\t\t\topt.text=  \"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" ;\t\t\t\t\t\t\n\t\t\t\t\t\topt.value= \"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" + \"#\" + \"\" + \"#\" + \"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";\n\t\t\t\t\t\tdocument.forms[0].Functions.add(opt);\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\t\t\t\t\t\t\n\t\t\t\t\t\tvar spc=\"             \";\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\tif(document.forms[0].root_menu.value == \'N\')\n\t\t\t\t\t\t\tspc=\"                        \";\n\t\t\t\t\t\t\tvar indx=";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =";\n\t\t\t\t\t\t\tvar n=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\t\t\t\t\t\t\tvar opt_type=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\t\t\t\t\t\tif(opt_type==\"F\"){\n\t\t\t\t\t\t\t\topt.text=spc+ \"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" ;\n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" + \"#\" + opt_type ;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse {\n\t\t\t\t\t\t\t\topt.text=spc+\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" ;\n\t\t\t\t\t\t\t\topt.style.color=\"RED\";\n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" + \"#\" + \"S\" ;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t if(n==\"T\") document.forms[0].MainMenus.add(opt);\n\t\t\t\t\t\t\telse document.forms[0].MainMenus.add(opt,indx+1); \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.frames[1].Delete(\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\');\n\t\t\t\t\t\t\n\t\t\t\t\t\talert(top.header.getMessage(\'CANNOT_ATTACH_SUBMENU\',\'SM\'));\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\tvar tp =\"----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"----\";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].Report_Id.add(opt);\n\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=  \"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" ;\n\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\";\n\t\t\t\t\t\tdocument.forms[0].Report_Id.add(opt);\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
												   
			Connection con=null;
			con = ConnectionManager.getConnection(request);
			Hashtable hash = (Hashtable)obj.parseXMLString( request );
		 	hash = (Hashtable)hash.get("SEARCH") ;
            request.setCharacterEncoding("UTF-8");
			String Log_user= (String) session.getValue("login_user");
			String responsibility_id= (String) session.getValue("responsibility_id");
			String facilityId = (String) session.getValue("facility_id");
			java.sql.Statement stmt= con.createStatement();
			java.sql.Statement stmt1 = con.createStatement();
			java.sql.Statement stmt2 = con.createStatement();
			java.sql.Statement mystmt = con.createStatement();
			java.sql.Statement rootstmt= con.createStatement();
			ResultSet rset=null;
			ResultSet rs=null;
			ResultSet rset1=null;
			ResultSet rootrset=null;
			ResultSet myrset=null;
			int cntr=0;

			String moduleid="";
			String moduledesc="";
			String chksrc = (String) hash.get("Chksrc") ;
			if(chksrc == null) chksrc=""; 
			String common = (String) hash.get("Common_Text") ;
			
			if(common == null) common="";
			String common1 = (String) hash.get("Common_Text1") ;	
			
			String mod_id=(String) hash.get("mod_id") ;
			if(mod_id == null) mod_id="";	

			if(common1 == null) common1="";			
			String menu_id="";
			String option_type="";
			String module_id="";
			String function_id="";
			String submenu_id ="";
			String option_descriptor="";
			String array[][]=null;
			String root_yn="";
	try
	{
			if(chksrc.trim().equals("one"))
	    	{
		    	String sql = "select report_id,report_desc from sm_report where ACCEPT_ADHOC_EMAILID_YN='N' and module_id='" + common.trim() + "' order by report_desc";
			

				rset = stmt1.executeQuery(sql);		
				
				if(rset != null) 			
				{

            _bw.write(_wl_block2Bytes, _wl_block2);
				
				    while( rset.next() ) 
				    {
				      	moduleid = rset.getString( "report_id" ) ;	
				       	moduledesc= rset.getString( "report_desc" ) ;
					

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block5Bytes, _wl_block5);
			  					}
					}
			}
			else if(chksrc.trim().equals("two"))
		    {
		    	String sql="SELECT FACILITY_BASED_YN FROM SM_REPORT WHERE REPORT_ID='"+ common1.trim() +"'";
				
				
				
				if(rset!=null)rset.close();
				rset = stmt1.executeQuery(sql);
				if(rset.next())
				{
					String str=rset.getString("FACILITY_BASED_YN").trim();					
					if (str.equals("N"))
					{
						
            _bw.write(_wl_block6Bytes, _wl_block6);

					}
					else
					{
						
            _bw.write(_wl_block7Bytes, _wl_block7);
						
						String sql1= "select a.facility_id, b.facility_name from sm_report_for_fcy a, sm_facility_param b where a.facility_id = b.facility_id and module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"' ORDER BY b.facility_name";
						
									if(rset!=null)rset.close();
						rset = stmt1.executeQuery(sql1);
						if(rset != null)
						{
					        while( rset.next() )
					        {
					        	moduleid = rset.getString( "facility_id" ) ;
								moduledesc=rset.getString( "facility_name" ) ;
								
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block10Bytes, _wl_block10);

							}
						 }
					}
		        }

	    		String sql2= "select transaction_based_yn from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				if(rset!=null)rset.close();
				
				rset = stmt1.executeQuery(sql2);
				if(rset != null)
				{
			        if( rset.next() )
			        {
			        	moduleid = rset.getString( "transaction_based_yn" ) ;

				 	
						 if(moduleid.equals("Y"))
				 		 {

							 if(common.equals("AE")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}else if(common.equals("OP")){
            _bw.write(_wl_block12Bytes, _wl_block12);
}else if(common.equals("IP")){
            _bw.write(_wl_block13Bytes, _wl_block13);
}else if(common.equals("OA")){
            _bw.write(_wl_block14Bytes, _wl_block14);
}else if(common.equals("DS")){
            _bw.write(_wl_block15Bytes, _wl_block15);
}else if(common.equals("FM")){
            _bw.write(_wl_block16Bytes, _wl_block16);
}else if(common.equals("OR")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}else if(common.equals("RL")){
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

					  	}
				  	  	else
				  	  	{

            _bw.write(_wl_block21Bytes, _wl_block21);

				  	  	}
					}
				}
    			if(rset!=null)rset.close();
               String stl="";
				String sl= "select report_class from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
			
				rset = stmt1.executeQuery(sl);
				if(rset.next())
				{
				stl=rset.getString("report_class");
				 }
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(stl));
            _bw.write(_wl_block23Bytes, _wl_block23);
String sl2= "select dflt_report_mode from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";

		

				if(rset!=null)rset.close();
				rset = stmt1.executeQuery(sl2);
				if(rset != null)
				{
			        while( rset.next() )
			        {
			        	moduleid = rset.getString( "dflt_report_mode" ) ;
						if(moduleid.equals("B"))
						{

            _bw.write(_wl_block24Bytes, _wl_block24);

						}
						else
						{

            _bw.write(_wl_block25Bytes, _wl_block25);

						}
					}
				 }
				 if(common1.equals("")||common1==null){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
			}
			else if(chksrc.trim().equals("three"))
			{


            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(common1));
            _bw.write(_wl_block28Bytes, _wl_block28);

				String fid ="";
				String rid ="";				
				StringTokenizer st = new StringTokenizer(common1,"#");
				while(st.hasMoreTokens()){
						fid = st.nextToken();
						if (st.hasMoreTokens())
							rid = st.nextToken();
				}
				
				String sql="";
				String facid="";
				String code = "";
				String desc = "";
				sql="SELECT FACILITY_BASED_YN,TRANSACTION_BASED_YN FROM SM_REPORT WHERE REPORT_ID='"+ rid.trim() +"'";
				if(rset!=null)rset.close();					
				rset = stmt1.executeQuery(sql);			
				if(rset.next())
				{
					String facyn=rset.getString("FACILITY_BASED_YN").trim();
					String tranyn = rset.getString("TRANSACTION_BASED_YN").trim();					
					if (facyn.equals("N") && tranyn.equals("Y"))
							facid=facilityId;
					else if(facyn.equals("Y") && tranyn.equals("Y")){
							if(fid.equals(" ") || fid == null || fid.equals(""))
							{
								
            _bw.write(_wl_block29Bytes, _wl_block29);

							}
							else
								facid=fid;
					}
				}	
				if(common.trim().equals("C"))
		   		{
					
            _bw.write(_wl_block30Bytes, _wl_block30);
			
					sql = "select INSTALL_YN from sm_module where MODULE_ID='OP' " ;
					if(rset!=null)rset.close();
					
					rset = stmt1.executeQuery(sql);
					sql="";
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{	
							if(mod_id.equals("AE")){								
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'C' and LEVEL_OF_CARE_IND='E' order by short_desc "; 
							}else{
														
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'C' and LEVEL_OF_CARE_IND in('A','E') order by short_desc ";
							}

					
							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "clinic_code" ) ;	
									desc = rs.getString( "short_desc" ) ;	
	                    						
						 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
				   	  
								}
							}if(rs!=null)rs.close();
						}
						else 
            _bw.write(_wl_block34Bytes, _wl_block34);
				}
					else
					{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
					}

				}
		   		else if(common.trim().equals("N"))
				{
			
            _bw.write(_wl_block36Bytes, _wl_block36);
			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='IP' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select nursing_unit_code,short_desc from ip_nursing_unit  where facility_id = '"+facid.trim()+"' and eff_status = 'E'  order by short_desc";	
							if(rset!=null)rset.close();
							rset = stmt1.executeQuery(sql);			
			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "nursing_unit_code" ) ;	
									desc = rset.getString( "short_desc" ) ;	
									
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
				   	  	}
							}
						}
						else 
            _bw.write(_wl_block39Bytes, _wl_block39);
					}
					else 
            _bw.write(_wl_block40Bytes, _wl_block40);
				}
				else if(common.trim().equals("P"))
				{
					
            _bw.write(_wl_block41Bytes, _wl_block41);
			
					sql = "select INSTALL_YN from sm_module where MODULE_ID='PH' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select DISP_LOCN_CODE PHARMACY_CODE,SHORT_DESC PHARMACY_DESC from ph_disp_locn where EFF_STATUS = 'E' and facility_id = '"+facid.trim()+"' order by SHORT_DESC";	
							if(rset!=null)rset.close();
							rset = stmt1.executeQuery(sql);			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "PHARMACY_CODE" ) ;	
									desc = rset.getString( "PHARMACY_DESC" ) ;	
								
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
				   	  
								}	
		    				}
		 					
					   }
					   else 
            _bw.write(_wl_block43Bytes, _wl_block43);

					 }
						else 
            _bw.write(_wl_block44Bytes, _wl_block44);

				}
				else if(common.trim().equals("S"))
				{
					
					
            _bw.write(_wl_block45Bytes, _wl_block45);
			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='ST' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
						
							sql= "select store_code, short_desc from mm_store where eff_status = 'E' and facility_id = '"+facid.trim()+"' order by SHORT_DESC";	
							if(rset!=null)rset.close();
							rset = stmt1.executeQuery(sql);			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "store_code" ) ;	
									desc = rset.getString( "short_desc" ) ;	
									
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
				   	  
								}
							}							
						}
						else 
            _bw.write(_wl_block47Bytes, _wl_block47);
	}
					else 
            _bw.write(_wl_block48Bytes, _wl_block48);
	}
				else if(common.trim().equals("O"))
				{
					
            _bw.write(_wl_block45Bytes, _wl_block45);
			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='OR' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select SERVICE_LOCATION_CODE, SHORT_DESC from or_service_location where eff_status = 'E'  order by SHORT_DESC";	
							if(rset!=null)rset.close();
							rset = stmt1.executeQuery(sql);			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "SERVICE_LOCATION_CODE" ) ;	
									desc = rset.getString( "SHORT_DESC" ) ;	
									
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
				   	  
								}
							}							
						}
						else 
            _bw.write(_wl_block50Bytes, _wl_block50);
	}
					else 
            _bw.write(_wl_block51Bytes, _wl_block51);
	}
				else if(common.trim().equals("E"))
				{
					
            _bw.write(_wl_block52Bytes, _wl_block52);
			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='OP' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					sql="";
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							

							if(mod_id.equals("AE")){								
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'E' and LEVEL_OF_CARE_IND='E' order by short_desc "; 
							}else{
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'E' and LEVEL_OF_CARE_IND in('A','E') order by short_desc "; 
							}


							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "clinic_code" ) ;	
									desc = rs.getString( "short_desc" ) ;	
	
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
				   	  
								}
							}if(rs!=null)rs.close();
						}
						else 
            _bw.write(_wl_block34Bytes, _wl_block34);
				}
					else
					{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
					}

				}
				else if(common.trim().equals("Y"))
				{
					
            _bw.write(_wl_block54Bytes, _wl_block54);
			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='OP' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					sql="";
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							
							if(mod_id.equals("AE")){
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'D' and LEVEL_OF_CARE_IND='E' order by short_desc "; 
							}else{
								sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) and care_locn_type_ind = 'D' and LEVEL_OF_CARE_IND in('A','E') order by short_desc "; 
							}

					
							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "clinic_code" ) ;	
									desc = rs.getString( "short_desc" ) ;	
	
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
				   	  
								}
							}if(rs!=null)rs.close();
						}
						else 
            _bw.write(_wl_block34Bytes, _wl_block34);
				}
					else
					{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
					}

				}
				else if(common.trim().equals("F"))
				{
					
            _bw.write(_wl_block55Bytes, _wl_block55);
			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='FM' " ;
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql);
					sql="";
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
				
					sql="SELECT fs_locn_code, short_desc long_desc FROM fm_storage_locn WHERE eff_status = 'E' AND mr_locn_yn='Y' AND permanent_file_area_yn = 'Y' and  facility_id = '"+facid.trim()+"' ORDER BY 2";
							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "fs_locn_code") ;	
									desc = rs.getString( "long_desc") ;	
	
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
				   	  
								}
							}if(rs!=null)rs.close();
						}
						else 
            _bw.write(_wl_block57Bytes, _wl_block57);
				}
					else
					{ 
            _bw.write(_wl_block58Bytes, _wl_block58);
					}

				}else if(common.trim().equals("R"))	{
				
					
            _bw.write(_wl_block55Bytes, _wl_block55);
			

								
					sql=" SELECT referral_code , long_desc short_desc   FROM am_referral  WHERE  eff_status = 'E' AND NVL (applicability_for_direct_ord, 'N') != 'N'    ORDER BY 2";

					
							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "referral_code") ;	
									desc = rs.getString( "short_desc") ;	
	
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(code));
            _bw.write(_wl_block61Bytes, _wl_block61);
				   	  
								}
							}
							
							if(rs!=null)rs.close();
						

				}else
		   		{
					//modified by Chitra on 11/9/2001	
					
            _bw.write(_wl_block62Bytes, _wl_block62);
	
				}
			}
			else if(chksrc.trim().equals("five"))
			{

	    		String sql1= "select dflt_report_mode from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				
				if(rset!=null)rset.close();
				rset = stmt1.executeQuery(sql1);
		   		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				if(rset != null)
				{
				        while( rset.next() )
				        {
				        	moduleid = rset.getString( "dflt_report_mode" ) ;

						if(moduleid.equals("B"))
						{


            _bw.write(_wl_block63Bytes, _wl_block63);

						}
						else
						{


            _bw.write(_wl_block64Bytes, _wl_block64);



						}

					}
				 }
				 out.println("</form></body></html>");



			}else if(chksrc.trim().equals("six")){

		    		String common2=request.getParameter("Common_Text2");

				out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
		    		if(common.trim().equals("B"))
		    		{

		    			String sql1= "select executable_name_bm from sm_report where module_id='" + common1.trim() + "'and report_id='"+ common2.trim() +"'";
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql1);

					if(rset.getString("executable_name_bm")==null)
					{

            _bw.write(_wl_block65Bytes, _wl_block65);


					}
					else
					{

            _bw.write(_wl_block66Bytes, _wl_block66);
			}
		}else if(common.trim().equals("C"))
   		{

		    			String sql1= "select executable_name_ch from sm_report where module_id='" + common1.trim() + "'and report_id='"+ common2.trim() +"'";
					if(rset!=null)rset.close();
					rset = stmt1.executeQuery(sql1);
		   			rset.next();
					if((rset.getString("executable_name_ch")==null ))
					{



            _bw.write(_wl_block67Bytes, _wl_block67);


					}
					else
					{

            _bw.write(_wl_block68Bytes, _wl_block68);
			}
				}
			 out.println("</form></body></html>");
			}
			else if(chksrc.trim().equals("seven")) 
			{
				String dev_tool="";
				//String sys_defined_yn ="";
		
			//	String rootsql=" select ROOT_MENU_YN,dev_tool,sys_defined_yn  from sm_menu_hdr  where MENU_ID='" + common.trim() + "' ";

			/*Above query Commented by Senthil on 11-10-2011 incident[27210]*/

				String rootsql=" select ROOT_MENU_YN,dev_tool from sm_menu_hdr  where MENU_ID='" + common.trim() + "' ";
				
				rootrset=rootstmt.executeQuery(rootsql);
				if(rootrset.next()) {
						root_yn = rootrset.getString(1);
						dev_tool=rootrset.getString(2);
						//sys_defined_yn =rootrset.getString("sys_defined_yn");
				}
				/*Commented by Senthil on 11-10-2011 incident[27210]*/
                //if(sys_defined_yn.equals("Y")){
					
            _bw.write(_wl_block69Bytes, _wl_block69);

				//}else{
				/*commented End*/
				String countsql="select count(*) from Sm_Menu_Dtl where Menu_Id='" + common.trim() + "'";
				rset1=stmt1.executeQuery(countsql);
				if(rset1.next()) {
					int row=rset1.getInt(1);

					if(rset1!=null)rset1.close();
					array=new String[row][6];
					if(row==0) 
					{
            _bw.write(_wl_block70Bytes, _wl_block70);
}
					else
					{
            _bw.write(_wl_block71Bytes, _wl_block71);

					}

				}
				String sql = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor from Sm_Menu_Dtl where Menu_Id='" + common.trim() + "' order by option_sequence_no, srl_no"; 
				
				/*Above query modified for this incident RUT-SCF-0252 [IN:038574] */
				
				
				
				rset = stmt1.executeQuery(sql);
		   		
				if(rset != null) 
				{
					int row=0;
				    while( rset.next() ) 
					{
						array[row][0]=rset.getString(1);
						array[row][1]=rset.getString(2);
						array[row][2]=rset.getString(3);
						array[row][3]=rset.getString(4);
						array[row][4]=rset.getString(5);
						array[row][5]=rset.getString(6);
						row++;
					}
				}
				for(int i=0;i<array.length;i++) 
				{
					menu_id = array[i][0]==null ? "" : array[i][0];
					option_type = array[i][1]==null ? "" : array[i][1];
					module_id = array[i][2]==null ? "" : array[i][2];
					function_id = array[i][3]==null ? "" : array[i][3];
					submenu_id = array[i][4]==null ? "" : array[i][4];
					option_descriptor = array[i][5]==null ? "" : array[i][5];

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(root_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(option_type));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(submenu_id));
            _bw.write(_wl_block78Bytes, _wl_block78);

					String colour = "";
					String sql1 = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor from Sm_Menu_Dtl where Menu_Id='" + submenu_id.trim() + "' order by option_sequence_no,srl_no";
					
					rset1 = stmt1.executeQuery(sql1);

					if(rset1 != null) {
						while( rset1.next() ) {
							menu_id = rset1.getString( "menu_id" )==null ? "" :  rset1.getString( "menu_id" );
							option_type = rset1.getString( "option_type" )==null ? "" :  rset1.getString( "option_type" );
							module_id = rset1.getString("module_id")==null ? "" : rset1.getString("module_id");
							function_id = rset1.getString("function_id")==null ? "" : rset1.getString("function_id");
							submenu_id = rset1.getString("submenu_id")==null ? "" : rset1.getString("submenu_id");
							option_descriptor = rset1.getString( "option_descriptor" )==null ? "" : rset1.getString( "option_descriptor" );
							if(submenu_id == null || submenu_id.equals(""))
								colour = "";
							else{
								colour="RED";
								option_type="S";
							}

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(option_type));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(colour));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(submenu_id));
            _bw.write(_wl_block84Bytes, _wl_block84);

						
            _bw.write(_wl_block85Bytes, _wl_block85);

								while(!(submenu_id.equals("") || submenu_id == null ))
								{
									cntr=0;
									String subsql = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor from Sm_Menu_Dtl where Menu_Id='" + submenu_id.trim() + "' order by option_sequence_no,srl_no";
									
									myrset = mystmt.executeQuery(subsql);
									//if(myrset != null) {
									
										//while( myrset.next() ) {
										
										while(myrset!=null && myrset.next()){
											cntr=cntr++;
											menu_id = myrset.getString( "menu_id" )==null ? "" :  myrset.getString( "menu_id" );
											option_type = myrset.getString( "option_type" )==null ? "" :  myrset.getString( "option_type" );
											module_id = myrset.getString("module_id")==null ? "" : myrset.getString("module_id");
											function_id = myrset.getString("function_id")==null ? "" : myrset.getString("function_id");
											submenu_id = myrset.getString("submenu_id")==null ? "" : myrset.getString("submenu_id");
											option_descriptor = myrset.getString( "option_descriptor" )==null ? "" : myrset.getString( "option_descriptor" );
											if(!(submenu_id == null || submenu_id.equals("")))
											{ 
            _bw.write(_wl_block86Bytes, _wl_block86);
}

				
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(option_type));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(submenu_id));
            _bw.write(_wl_block91Bytes, _wl_block91);

										}
									//}
									if(myrset != null) myrset.close();
									
            _bw.write(_wl_block92Bytes, _wl_block92);

									if(cntr==0){
										break;
									}
								}// end while
						}
					}if(rset1!=null)rset1.close();
					}
			String Role="";
		
			try{
			String sqlResp="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"'";
			ResultSet rsResp=stmt.executeQuery(sqlResp);
			if (rsResp !=null)
			{
				while (rsResp.next())
				{
					Role=rsResp.getString(1);
					if(Role==null) Role="";
				}
			}
			
			if(rsResp!=null)rsResp.close();
			}//try
			catch(Exception ee){
			out.println(ee.toString());
			ee.printStackTrace();
			}
				StringBuffer sql1=new StringBuffer();
				//if (Role.equalsIgnoreCase("MEDADMIN"))
				//{
					if(dev_tool.equals("F"))
					sql1.append("select menu_id,menu_name from sm_menu_hdr where root_menu_yn='N' and menu_id <> '" + common.trim() + "' and dev_tool='"+dev_tool+"' order by menu_name");
					else
					sql1.append("select menu_id,menu_name from sm_menu_hdr where root_menu_yn='N' and menu_id <> '" + common.trim() + "' order by menu_name");
				/*}
				else
				{
					if(dev_tool.equals("F"))
					{
					sql1.append("select  a.menu_id,a.menu_name  from sm_menu_hdr a");
					sql1.append("  where ");
					sql1.append("  a.menu_id <> '"+ common.trim()+"' and dev_tool='"+dev_tool+"' and a.root_menu_yn='N' and a.resp_group_id in (select  resp_group_id  from sm_menu_admin where menu_admin_id='"+Log_user+"')  order by a.menu_name");
					}
					else
					{
					sql1.append("select  a.menu_id,a.menu_name  from sm_menu_hdr a");
					sql1.append("  where ");
					sql1.append("  a.menu_id <> '"+ common.trim()+"'  and a.root_menu_yn='N' and a.resp_group_id in (select  resp_group_id  from sm_menu_admin where menu_admin_id='"+Log_user+"')  order by a.menu_name");
					
					}
				}*/

				
				rset1 = stmt1.executeQuery(sql1.toString());
				if(rset1 != null) {
				        while( rset1.next() ) {
				        	menu_id = rset1.getString( "menu_id" ) ;
				        	String menu_name = rset1.getString( "menu_name" ) ;

            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(menu_name));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(menu_name));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block97Bytes, _wl_block97);

					}
				 }
			   //}
			}

			//This is for Menu Details
			else if(chksrc.trim().equals("eight")) 
			{
				String menuID = request.getParameter("menuID");
				if(menuID == null) menuID="";
				module_id=common.trim();
				String Role="";
				StringBuffer sqlfun=new StringBuffer();
				String sqlResp="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"'";
				ResultSet rsResp=stmt.executeQuery(sqlResp);
				if (rsResp !=null)
				{
					while (rsResp.next())
					{
						Role=rsResp.getString(1);
						if(Role==null) Role="";
					}
				}if(rsResp!=null)rsResp.close();
				String sql12=" select dev_tool from sm_menu_hdr where menu_id = '"+menuID+"' ";
			    java.sql.Statement stmt12=con.createStatement();
				ResultSet rset12 = stmt12.executeQuery(sql12);
				String devTool="";
				if(rset12.next())
					devTool=rset12.getString(1);
			    if(rset12 !=null)rset12.close();
				if(stmt12 != null) stmt12.close();
			
				//if (Role.equalsIgnoreCase("MEDADMIN"))
				//{
					if(devTool.equals("F"))
					sqlfun.append("select function_id,function_name,function_type from Sm_Function where module_id='" + module_id + "' and dev_tool = '"+devTool+"' order by function_name");
					else
					sqlfun.append("select function_id,function_name,function_type from Sm_Function where module_id='" + module_id + "'  order by function_name");
			/*	}
				else
				{
					if(devTool.equals("F"))
					{
					sqlfun.append("select a.FUNCTION_ID,a.FUNCTION_NAME,a.function_type  from Sm_Function a");
					sqlfun.append(",sm_func_by_resp_grp b where a.function_id=b.function_id ");
					sqlfun.append(" and b.resp_group_id in (select  resp_group_id  from sm_menu_admin where menu_admin_id='"+Log_user+"')");
					sqlfun.append(" and a.module_id='"+module_id+"' and dev_tool = '"+devTool+"'");
					}
					else
					{
					sqlfun.append("select a.FUNCTION_ID,a.FUNCTION_NAME,a.function_type  from Sm_Function a");
					sqlfun.append(",sm_func_by_resp_grp b where a.function_id=b.function_id ");
					sqlfun.append(" and b.resp_group_id in (select  resp_group_id  from sm_menu_admin where menu_admin_id='"+Log_user+"')");
					sqlfun.append(" and a.module_id='"+module_id+"' ");
					}

				}*/
				
				if(rset!=null)rset.close();
				rset = stmt1.executeQuery(sqlfun.toString());
				if(rset != null) {
			        while( rset.next() ) {
			        	String function_name = rset.getString( "function_name" ) ;
			        	function_id = rset.getString( "function_id" ) ;
						String function_type=rset.getString( "function_type" ) ;

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(function_type));
            _bw.write(_wl_block101Bytes, _wl_block101);

					}
				 }
			}
			else if(chksrc.trim().equals("nine")) 
			{
				int index=Integer.parseInt((String) hash.get("Index"));
				String minus="F";
				if(index==-1) minus="T";


				String sql1 = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor from Sm_Menu_Dtl where Menu_Id='" + common.trim() + "' order by option_sequence_no,srl_no";
				if(rset1!=null)rset1.close();
				rset1 = stmt1.executeQuery(sql1);
					if( rset1.next() ) {
					do{
						menu_id = rset1.getString( "menu_id" )==null ? "" :  rset1.getString( "menu_id" );
						option_type = rset1.getString( "option_type" )==null ? "" :  rset1.getString( "option_type" );
						module_id = rset1.getString("module_id")==null ? "" : rset1.getString("module_id");
						function_id = rset1.getString("function_id")==null ? "" : rset1.getString("function_id");
						submenu_id = rset1.getString("submenu_id")==null ? "" : rset1.getString("submenu_id");
						option_descriptor = rset1.getString( "option_descriptor" )==null ? "" : rset1.getString( "option_descriptor" );

            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(index));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(minus));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(option_type));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(submenu_id));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(submenu_id));
            _bw.write(_wl_block109Bytes, _wl_block109);

					index++;
					}while(rset1.next());	
			
					}
					else
					{
						index--;
						
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(index));
            _bw.write(_wl_block111Bytes, _wl_block111);
}
			}
			else 
			{
		    	String sql = "select Report_Id,Report_Desc from Sm_Report where facility_based_YN ='Y' and Module_Id='" + common.trim()+"' order by Report_Desc";
				if(rset!=null)rset.close();
				rset = stmt1.executeQuery(sql);		   		
				if(rset != null) {

            _bw.write(_wl_block112Bytes, _wl_block112);

				    while( rset.next() ) {
				       	String reportid = rset.getString( "Report_Id" ) ;
				       	String reportdesc = rset.getString( "Report_Desc" );
						
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(reportdesc));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(reportid));
            _bw.write(_wl_block115Bytes, _wl_block115);

					}
				 }
			}
			hash.clear();
			if(rset != null) rset.close();
			if(rset1 != null) rset1.close();
			
			if(rootrset!=null)rootrset.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
			if(stmt2 != null) stmt2.close();
			
			
			if(mystmt != null) mystmt.close();
			if(rootstmt !=null) rootstmt.close();

		}catch(Exception e){
			out.println(e);
			e.printStackTrace();
			}
		finally { 
			ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block116Bytes, _wl_block116);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
