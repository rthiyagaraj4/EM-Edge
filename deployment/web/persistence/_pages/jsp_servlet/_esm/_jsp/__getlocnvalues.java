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

public final class __getlocnvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/GetLocnValues.jsp", 1741326054072L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\tdocument.getElementById(\'locnimg\').style.visibility = \'hidden\';\n\t\t\t\t\tdocument.getElementById(\'locnimg1\').style.visibility = \'hidden\';\t\t\t\t\n\t\t\t\t\tvar tp =\"  --------------------------------- Select ---------------------------------  \";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].report_id.add(opt);\t\t\t\t\t\n\n\t\t\t\t\tvar facility =\" ---------- Select ---------- \";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=facility;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].facility_id.add(opt);\n\n\t\t\t\t\tvar dest_locn_type =\" -- Select -- \";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=dest_locn_type;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\n\t\t\t\t\tvar dest_locn_code =\" ---------- Select ---------- \";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=dest_locn_code;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tdocument.forms[0].report_id.add(opt);\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\tvar n=parent.document.frames[1].document.forms[0].facility_id.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.document.frames[1].document.forms[0].facility_id.remove(\"facility_id\");\n\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\tparent.document.frames[1].document.forms[0].facility_id.disabled = true;\n\n\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\t\t\n\t\t\t\t<script>\n\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar n=parent.document.frames[1].document.forms[0].facility_id.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].facility_id.remove(\"facility_id\");\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].facility_id.disabled = false;\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar tp =\" ---------- Select ---------- \";\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].facility_id.add(opt);\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t\t\t\t<script>\t\t\t\t\n\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=  temp1;\n\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].facility_id.add(opt);\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\t\t\t\t\n\t\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"Clinic\";\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dest_locn_code1.disabled=true;\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dest_locn_code.disabled=false;\n\t\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\n\t\t\t\t\t\t\t<script>\t\n\t\t\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=\"Location\";\n\t\t\t\t\t\t\t\topt.value=\"L\";\n\t\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dest_locn_type.add(opt);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dest_locn_code1.disabled=false;\n\t\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dest_locn_code.disabled=true;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<script>\n\t\t\t\t\t\tvar tp =\"-------------------------- Select ---------------------------\";\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id.add(opt);\t\t\t\t\t\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id2.add(opt);\t\t\t\t\t\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id3.add(opt);\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t</script>\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<script>\t\t\t\t\n\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\topt.text= temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\n\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id.add(opt);\n\t\t\t\t\tvar opt2=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\topt2.text= temp1;\n\t\t\t\t\topt2.value=temp;\n\t\t\t\t\t\n\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id2.add(opt2);\n\t\t\t\t\tvar opt3=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\topt3.text= temp1;\n\t\t\t\t\topt3.value=temp;\n\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id3.add(opt3);\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<script>\n\t\t\t\t\t\tvar tp =\"-------------------------- Select ---------------------------\";\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id.add(opt);\t\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id2.add(opt);\t\t\t\t\t\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id3.add(opt);\t\t\n\n\t\t\t\t</script>\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<script>\t\t\t\t\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].printer_id.add(opt);\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\t\n\n\t\t\t\t \t\n\t\t\t\t\t<script>\t\n\t\t\t\t\t\n\t\t\t\t\t\tvar n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"BitMap\";\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\t\t\t\t\t\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"Character\";\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<script>\t\t\t\t\n\t\n\t\t\t\t\t\tvar n=parent.document.frames[1].document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"Character\";\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\t\t\t\t\n\t\n\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"BitMap\";\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tparent.document.frames[1].document.forms[0].dflt_report_mode.add(opt);\n\n\t\t\t\t\n\t\t\t\t\t</script>\t\t\t\t\t\t\t\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\tdocument.getElementById(\'locnimg\').style.visibility = \'visible\';\n\t\t\t\tdocument.getElementById(\'locnimg1\').style.visibility = \'hidden\';\n\t\t\t\tvar common1 = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\tvar err=getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\t\t\t\t\t\t\t\terr=err.replace(\'$\',\'Facility\');\n\t\t\t\t\t\t\t\tdocument.write(err);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = true;\t\t\t   \n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar tp =\" ---------- Select ---------- \";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt.text= \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\talert(getMessage(\'OP_NOT_INSTALLED\',\'SM\'));\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\talert(getMessage(\'OP_NOT_INSTALLED\',\'SM\'));\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = true;\t\t\t   \n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar tp =\" ---------- Select ---------- \";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\n\t\t\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\talert(getMessage(\'IP_NOT_INSTALLED\',\'SM\'));\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\talert(getMessage(\'IP_NOT_INSTALLED\',\'SM\'));\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = true;\t\t\t   \n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar tp =\" ---------- Select ---------- \";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t   alert(getMessage(\'PH_NOT_INSTALLED\',\'SM\'));\n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\talert(getMessage(\'PH_NOT_INSTALLED\',\'SM\'));\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = true;\t\t\t   \n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = false;\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar tp =\" ---------- Select ---------- \";\n\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=tp;\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dest_locn_code.add(opt);\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\talert(getMessage(\'ST_NOT_INSTALLED\',\'SM\'));\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\talert(getMessage(\'ST_NOT_INSTALLED\',\'SM\'));\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\talert(getMessage(\'OR_NOT_INSTALLED\',\'SM\'));\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\talert(getMessage(\'OR_NOT_INSTALLED\',\'SM\'));\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\t\t\t\n\t\t\t\t\tdocument.forms[0].dest_locn_code1.disabled = false;\t\t\n\t\t\t\t\tdocument.forms[0].dest_locn_code.disabled = true;\t\tdocument.getElementById(\'locnimg\').style.visibility = \'hidden\';\n\t\t\t\t\tdocument.getElementById(\'locnimg1\').style.visibility = \'hidden\';\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\n\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=\"BitMap\";\n\t\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n\t\t\t\t\t\n\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=\"Character\";\n\t\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=\"Character\";\n\t\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\t\t\n\t\t\n\t\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=\"BitMap\";\n\t\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\n\t\t\t\t\t\tvar n=document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"Character\";\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n\t\t\t\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"BitMap\";\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\t\t\t\t\n\t\t\t\t\t\tvar n=document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"BitMap\";\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n\t\t\t\t\t\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"Character\";\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n\t\t\t\t\t\tvar n=document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"BitMap\";\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n\t\t\t\t\t\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"Character\";\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\t\t\t\t\n\t\t\t\t\t\tvar n=document.forms[0].dflt_report_mode.options.length;\n\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.remove(\"dflt_report_mode\");\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"Character\";\n\t\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n\t\t\t\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"BitMap\";\n\t\t\t\t\t\topt.value=\"B\";\n\t\t\t\t\t\tdocument.forms[0].dflt_report_mode.add(opt);\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<script>\t\t\t\t\n\t\t\t\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=  \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" ;\n\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\t\t\t\tdocument.forms[0].Report_Id.add(opt);\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

         request.setCharacterEncoding("UTF-8");
		Connection con = null;
		try
		{

			con = ConnectionManager.getConnection(request);

			Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
		 	hash = (Hashtable)hash.get("SEARCH") ;

			String facilityId = (String) session.getValue("facility_id");
			java.sql.Statement stmt1 = con.createStatement();
			java.sql.Statement stmt2 = con.createStatement();
			ResultSet rset=null;
			ResultSet rs=null;
			String moduleid="";
			String moduledesc="";
			String chksrc = (String) hash.get("Chksrc") ;
			if(chksrc == null) chksrc="";
			String common = (String) hash.get("Common_Text") ;
			if(common == null) common="";
			String common1 = (String) hash.get("Common_Text1") ;
			if(common1 == null) common1="";			
			
	    	if(chksrc.trim().equals("one"))   	{
				
				
		    	
		    	String sql = "select report_id,report_desc from sm_report where module_id='" + common.trim() + "' order by report_desc";
				rset = stmt1.executeQuery(sql);			
				if(rset != null) 			
				{

            _bw.write(_wl_block3Bytes, _wl_block3);
				
				    while( rset.next() ) 
				    {
				      	moduleid = rset.getString( "report_id" ) ;	
				       	moduledesc= rset.getString( "report_desc" ) ;

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block6Bytes, _wl_block6);
			   	  
					}
				 if(rset!=null)rset.close();
				 if(stmt1!=null)stmt1.close();
				 }
			}			
			else if(chksrc.trim().equals("two")) 
			{
				String sql="SELECT FACILITY_BASED_YN,TRANSACTION_BASED_YN FROM SM_REPORT WHERE REPORT_ID='"+ common1.trim() +"'";

				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sql);			
				out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				if(rset.next())
				{
					String str=rset.getString("FACILITY_BASED_YN").trim();
					
					if (str.equals("N"))
					{

            _bw.write(_wl_block7Bytes, _wl_block7);
				
					}
					else
					{

            _bw.write(_wl_block8Bytes, _wl_block8);
						String sql1= "select facility_id from sm_report_for_fcy where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
						if(rset!=null)rset.close();
						rset = stmt1.executeQuery(sql1);			
	   					out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
						if(rset != null) 
						{
						        while( rset.next() ) 
						        {
						        	moduleid = rset.getString( "facility_id" ) ;
						
						String sg="select facility_name from sm_facility_param where facility_id='"+moduleid+"'";
						rset=stmt1.executeQuery(sg);	
						rset.next();
						
							moduledesc=rset.getString( "facility_name" ) ;

							if(rset!=null)rset.close();

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
				   	  
							}
						 }
						 
						 if(stmt1!=null)stmt1.close();
						
						 out.println("</form></body></html>");	
					}
					
					
					
				   if(rset!=null)rset.close();
				   if(stmt1!=null)stmt1.close();
					
			       }


				 
		    	
		    		String sql2= "select transaction_based_yn from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sql2);			
		   		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				
				
				if(rset != null) 
				{
				        if( rset.next() ) 
				        {
							moduleid = rset.getString( "transaction_based_yn" ) ;	
				 			if(moduleid.equals("Y"))
				 			{

            _bw.write(_wl_block12Bytes, _wl_block12);
	
					  	}
				  	  	else
				  	  	{

            _bw.write(_wl_block13Bytes, _wl_block13);
		
				  	  	}
					}
					 out.println("</form></body></html>");		
    				if(rset!=null)rset.close();
    				if(stmt1!=null)stmt1.close();
				}
							 
//CODE ADDED
		
    				
    				
		    String sl= "select report_class from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sl);			
		   		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				
				out.println(sl);
				if(rset.next()) 
				{
					
					String stl=rset.getString("report_class");
								
					if(stl.equals("R"))
					{
						

            _bw.write(_wl_block14Bytes, _wl_block14);

						
						
						String sqq="select printer_id,printer_name from sm_printer where printer_type<>'L' order by printer_name";
						ResultSet rst=stmt1.executeQuery(sqq);	
				
				
				   	     while( rst.next() ) 
				   	     {
				   		     	moduleid = rset.getString( "printer_id" ) ;	
				   		     	moduledesc=rset.getString( "printer_name" ) ;	
									


            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
			   	  
					     }
					    if(rst!=null)rst.close();
					    if(stmt1!=null)stmt1.close();
					    
				 	}
				 	else
				 	{
						

            _bw.write(_wl_block18Bytes, _wl_block18);

			
					String sq="select printer_id,printer_name from sm_printer order by printer_name";
					ResultSet rst=stmt1.executeQuery(sq);	
				
				   	     while( rst.next() ) 
				   	     {
			   		     	moduleid = rset.getString( "printer_id" ) ;
			   		     	moduledesc=rset.getString("printer_name");
			

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block20Bytes, _wl_block20);
			   	  
					    }	
					if(rst!=null)rst.close();
					if(stmt1!=null)stmt1.close();

				 	
				 	}
				 	
				 if(rset!=null)rset.close();
				 if(stmt1!=null)stmt1.close();
				 	
				 }
				 out.println("</form></body></html>");		
		


//CODE SECOND

		    	
		    		String sl2= "select dflt_report_mode from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sl2);			
		   		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				
								
				
				if(rset != null) 
				{
				        while( rset.next() ) 
				        {
				        	moduleid = rset.getString( "dflt_report_mode" ) ;	
			
						
						if(moduleid.equals("B"))
						{
					

            _bw.write(_wl_block21Bytes, _wl_block21);
			   	  
						}
						else
						{
						

            _bw.write(_wl_block22Bytes, _wl_block22);

		
						}
					
					}
				 if(rset!=null)rset.close();
				 if(stmt1!=null)stmt1.close();
				 }
				 out.println("</form></body></html>");
			}
			else if(chksrc.trim().equals("three")) 
		    {

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(common1));
            _bw.write(_wl_block24Bytes, _wl_block24);

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
				//modified by Chitra on 3/8/2001 
				sql="SELECT FACILITY_BASED_YN,TRANSACTION_BASED_YN FROM SM_REPORT WHERE REPORT_ID='"+ rid.trim() +"'";
				stmt1 = con.createStatement();
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
								
            _bw.write(_wl_block25Bytes, _wl_block25);

							}
							else
								facid=fid;
					}
				if(rset!=null)rset.close();
				if(stmt1!=null)stmt1.close();
				}	
				if(common.trim().equals("C"))
		   		{
					
            _bw.write(_wl_block26Bytes, _wl_block26);
			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='OP' " ;
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql);
					sql="";
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select clinic_code,short_desc  from op_clinic where eff_status='E' and facility_id='"+facid.trim()+"' and sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr')) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr')) order by short_desc "; 
					
							rs = stmt2.executeQuery(sql);			
							sql="";
							if(rs != null)
							{
								while( rs.next() ) 
								{
									code = rs.getString( "clinic_code" ) ;	
									desc = rs.getString( "short_desc" ) ;	
	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
				   	  
								}
							}
							if(rs!=null)rs.close();
							if(stmt2!=null)stmt2.close();
						}
						else 
            _bw.write(_wl_block30Bytes, _wl_block30);
				if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
}
					else
					{ 
            _bw.write(_wl_block31Bytes, _wl_block31);
					}
				}
		   		else if(common.trim().equals("N"))
				{
			
            _bw.write(_wl_block32Bytes, _wl_block32);
			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='IP' " ;
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select nursing_unit_code,short_desc from ip_nursing_unit  where facility_id = '"+facid.trim()+"' and eff_status = 'E'  order by short_desc";	

							rset = stmt1.executeQuery(sql);			
			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "nursing_unit_code" ) ;	
									desc = rset.getString( "short_desc" ) ;	
									
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
				   	  	}
							}
							if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
						}
						else 
            _bw.write(_wl_block35Bytes, _wl_block35);
					if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
			}
					else 
            _bw.write(_wl_block36Bytes, _wl_block36);
				}
				else if(common.trim().equals("P"))
				{
					
            _bw.write(_wl_block37Bytes, _wl_block37);
			
					sql = "select INSTALL_YN from sm_module where MODULE_ID='PH' " ;
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select PHARMACY_CODE,PHARMACY_DESC from ph_pharmacy where EFF_STATUS = 'E' and facility_id = '"+facid.trim()+"' order by PHARMACY_DESC";	
							rset = stmt1.executeQuery(sql);			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "PHARMACY_CODE" ) ;	
									desc = rset.getString( "PHARMACY_DESC" ) ;	
								
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
				   	  
								}	
		    				}
							if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
		 					
					   }
					   else 
            _bw.write(_wl_block39Bytes, _wl_block39);

					if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
					 }
						else 
            _bw.write(_wl_block40Bytes, _wl_block40);

				}
				else if(common.trim().equals("S"))
				{
					
            _bw.write(_wl_block41Bytes, _wl_block41);
			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='ST' " ;
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select store_code, short_desc from st_store where eff_status = 'E' and facility_id = '"+facid.trim()+"' order by SHORT_DESC";	
							rset = stmt1.executeQuery(sql);			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "store_code" ) ;	
									desc = rset.getString( "short_desc" ) ;	
									
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
				   	  
								}
							}
							if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
						}
						else 
            _bw.write(_wl_block43Bytes, _wl_block43);

					if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
				}
					else 
            _bw.write(_wl_block44Bytes, _wl_block44);
	}
				else if(common.trim().equals("O"))
				{
					
            _bw.write(_wl_block41Bytes, _wl_block41);
			

					sql = "select INSTALL_YN from sm_module where MODULE_ID='OR' " ;
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql);
					if(rset.next())
					{
						String installyn = rset.getString("INSTALL_YN");
						if(installyn.equals("Y"))
						{
							sql= "select SERVICE_LOCATION_CODE, SHORT_DESC from or_service_location where eff_status = 'E'  order by SHORT_DESC";	
							rset = stmt1.executeQuery(sql);			
							if(rset != null)
							{
								while( rset.next() ) 
								{
									code = rset.getString( "SERVICE_LOCATION_CODE" ) ;	
									desc = rset.getString( "SHORT_DESC" ) ;	
									
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
				   	  
								}
							}	
							if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
						}
						else 
            _bw.write(_wl_block46Bytes, _wl_block46);
	
					if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
					}
					else 
            _bw.write(_wl_block47Bytes, _wl_block47);
	}
				else
		   		{
					//modified by Chitra on 11/9/2001	
					
            _bw.write(_wl_block48Bytes, _wl_block48);
	
				}
			}
			else if(chksrc.trim().equals("five")) 
			{		    	
		    	String sql1= "select dflt_report_mode from sm_report where module_id='" + common.trim() + "'and report_id='"+ common1.trim() +"'";
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sql1);			
				if(rset != null) 
				{
			        while( rset.next() ) 
			        {
			        	moduleid = rset.getString( "dflt_report_mode" ) ;	
						if(moduleid.equals("B"))
						{
					
            _bw.write(_wl_block49Bytes, _wl_block49);
			   	  
						}
						else
						{
					
            _bw.write(_wl_block50Bytes, _wl_block50);

						}					
					}
				 if(rset!=null)rset.close();
				if(stmt1!=null)stmt1.close();
				 }
			}			
			else if(chksrc.trim().equals("six")) 
			{
		    		
	    		String common2 = (String) hash.get("Common_Text2") ;
				if(common2 == null) common2="";			
	    		if(common.trim().equals("B")) 
	    		{		    		
		    		String sql1= "select executable_name_bm from sm_report where module_id='" + common1.trim() + "'and report_id='"+ common2.trim() +"'";
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql1);			
		   			rset.next();	
					if(rset.getString("executable_name_bm")==null) 
					{
						
            _bw.write(_wl_block51Bytes, _wl_block51);
			   	  				
					}
					else
					{
						
            _bw.write(_wl_block52Bytes, _wl_block52);

					}
						if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
				}
	    		else if(common.trim().equals("C")) 
	    		{
		    		
		    		String sql1= "select executable_name_ch from sm_report where module_id='" + common1.trim() + "'and report_id='"+ common2.trim() +"'";
					stmt1 = con.createStatement();
					rset = stmt1.executeQuery(sql1);			
		   			rset.next();	
					if((rset.getString("executable_name_ch")==null ))
					{
						
            _bw.write(_wl_block53Bytes, _wl_block53);
			   	  				
					}
					else
					{
						
            _bw.write(_wl_block54Bytes, _wl_block54);

					}
						if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
				}
			}
		    else 
			{
				//add for four !..................................
		    	String sql = "select Report_Id,Report_Desc from Sm_Report where Module_Id='" + common.trim() + "'";
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sql);			
				if(rset != null) 
				{
					while( rset.next() ) 
					{
				       	String reportid = rset.getString( "Report_Id" ) ;	
				       	String reportdesc = rset.getString( "Report_Desc" );
						
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(reportdesc));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(reportid));
            _bw.write(_wl_block57Bytes, _wl_block57);

					}
					if(rset!=null)rset.close();
					if(stmt1!=null)stmt1.close();
				 }
			}
			hash.clear();
			
		}
		catch(Exception e){out.println(e);}
		finally 
		{ 
			ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block58Bytes, _wl_block58);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
