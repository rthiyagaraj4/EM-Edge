package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __serverside extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ServerSide.jsp", 1721107047173L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "utf-8".intern();

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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t<script>\n\t\t\tvar i=2;\n\t\t\tvar len=document.forms[0].b_clinic.options.length;\t\t\t\n\t\t\tvar lBox=document.forms[0].b_clinic; \n\t\t\tlBox.remove(lBox.options[0]);\n\t\t\tvar opt=document.createElement(\'OPTION\')\n\t\t\topt.value=\"\"\n\t\t\topt.text=\'------------------------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'------------------------\';\n\t\t\tlBox.add(opt);\n\n\t\t\twhile(i<= len){\n\t\t\t\tlBox.remove(lBox.options[i]);\n\t\t\t\ti+=1;\n\t\t\t}\n\n\t\t\tdocument.forms[0].identityCheckIn.value=\'\';\n\t\t\tdocument.forms[0].defaultStartTime.value=\'\';\n\t\t\tdocument.forms[0].defaultEndTime.value=\'\';\n\t\t\tdocument.forms[0].defaultDuration.value=\'\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<script>\n\t\t\tvar i=2;\n\t\t\tvar len=parent.frames[1].document.forms[0].location.options.length;\n\t\t\tvar lBox=parent.frames[1].document.forms[0].location; \n\t\t\tlBox.remove(lBox.options[0]);\n\t\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\n\t\t\topt.value=\'\';\n\t\t    opt.text=\'------------------------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'------------------------\';\n\t\t\tlBox.add(opt);\n\n\t\t\twhile(i<= len){\n\t\t\t\tlBox.remove(lBox.options[i]);\n\t\t\t\ti+=1;\n\t\t\t}\n</script>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<script>\n\t\t\tvar i=2;\n\t\t\tvar len=document.forms[0].b_clinic.options.length;\n\t\t\tvar lBox=document.forms[0].b_clinic; \n\t\t\tlBox.remove(lBox.options[0]);\n\t\t\tvar opt=document.createElement(\'OPTION\')\n\t\t\topt.value=\'\';\n\t\t    opt.text=\'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\t\tlBox.add(opt);\n\n\t\t\twhile(i<= len){\n\t\t\t\tlBox.remove(lBox.options[i]);\n\t\t\t\ti+=1;\n\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="    \n\t\t\n\t\t\t\tdocument.forms[0].identityCheckIn.value+=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'\n\t\t\t\tdocument.forms[0].defaultStartTime.value+=\'|";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t\t\tdocument.forms[0].defaultEndTime.value+=\'|";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\t\t\t\tdocument.forms[0].defaultDuration.value+=\'|";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\t\tdocument.forms[0].primary_rec_class.value+=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\tvar opt=document.createElement(\'OPTION\')\n\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"\n\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\n\t\t\t\tdocument.forms[0].b_clinic.add(opt);\n\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="$";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\tparent.frames[1].document.forms[0].location.add(opt);\n\t\t\t\n\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\tvar opt=document.createElement(\'OPTION\')\n\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"\n\t\t\t\tdocument.forms[0].b_clinic.add(opt);\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\n\t\t\t<script>\n\t\t\t var i=2;\n\t\t\t var len=parent.frames[0].document.forms[0].location.options.length;\n\t\t\t var lBox=parent.frames[0].document.forms[0].location; \n\t\t\t lBox.remove(lBox.options[0]);\n\t\t\t var opt=parent.frames[0].document.createElement(\'OPTION\');\n\t\t\t opt.value=\'\';\n\t\t     opt.text=\'------------------------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'------------------------\';\n\t\t\t lBox.add(opt);\n\n\t\t\t while(i<= len){\n\t\t\t\t lBox.remove(lBox.options[i]);\n\t\t\t\t i+=1;\n\t\t\t}   \n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\tvar element = parent.frames[0].document.createElement(\'OPTION\');\n\t\t\t\t\telement.value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="|";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].location.add(element);\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\tparent.frames[0].document.getElementById(\"roster1\").style.visibility=\'visible\';\n\t\t\t\tparent.frames[0].document.getElementById(\"roster\").style.visibility=\'visible\';\n\t\t\t\tparent.frames[0].document.getElementById(\"roster2\").style.visibility=\'visible\';\n\t\t\t\t\t\n\t\t\t\tparent.frames[0].document.getElementById(\"roster1\").style.display=\'\';\n\t\t\t\tparent.frames[0].document.getElementById(\"roster\").style.display=\'\';\n\t\t\t\tparent.frames[0].document.getElementById(\"roster1\").innerHTML=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\tparent.frames[0].document.getElementById(\"roster\").innerHTML=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\t\tparent.frames[0].document.getElementById(\"roster2\").style.display=\'\';\n\t\t\t\t\t\t\t\n\t\t\t\tparent.frames[0].document.getElementById(\"noofdays\").value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\';\n\t\t\t\tparent.frames[0].document.forms[0].resourcek.value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\n\t\t\t\tparent.frames[0].document.forms[0].carelocnk.value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\n\t\t\t\tparent.frames[0].document.forms[0].locationk.value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\n\t\t\t\tparent.frames[0].document.forms[0].practitionerk.value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\n\t\t\t\tparent.frames[0].document.forms[0].roster_defined.value=\'Y\'; \n\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\n\t\t\t\t\tparent.frames[0].document.getElementById(\"roster1\").style.visibility=\'hidden\';\n\t\t\t\t\tparent.frames[0].document.getElementById(\"roster\").style.visibility=\'hidden\';\n\t\t\t\t\tparent.frames[0].document.getElementById(\"roster2\").style.visibility=\'hidden\';\n\n\t\t\t\t\tparent.frames[0].document.getElementById(\"noofdays\").value=\'\';\n\t\t\t\t\n\t\t\t\tparent.frames[0].flag=\"\";\n\t\t\t\tvar m=getMessage(\'ROSTER_NOT_EXISTS\',\'OA\');\n\t\t\t\tparent.frames[0].document.forms[0].checkdtlframe.value=\'NO\';\n\t\t\t\tparent.frames[0].document.forms[0].roster_defined.value=\'N\';\n\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+m;\n\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\t\t\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<script>\n\t\tvar i=2;\n\t\tvar len=parent.frames[1].document.forms[0].locationField.options.length;\n\t\tvar lBox=parent.frames[1].document.forms[0].locationField; \n\t\tlBox.remove(lBox.options[0]);\n\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\n\t\topt.value=\'\';\n\t\topt.text=\'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\tlBox.add(opt);\n\n\t\twhile(i<= len){\n\t\t\tlBox.remove(lBox.options[i]);\n\t\t\ti+=1;\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="    \n\n\t\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\n\t\t\topt.value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\topt.text=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\tparent.frames[1].document.forms[0].locationField.add(opt);\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\tvar element = document.createElement(\'OPTION\');\n\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\tdocument.forms[0].location.add(element);\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t<script>\n\t\tvar i=2;\n\t\tvar len=parent.frames[1].document.forms[0].location.options.length;\n\t\tvar lBox=parent.frames[1].document.forms[0].location; \n\t\tlBox.remove(lBox.options[0]);\n\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\n\t\topt.value=\'\';\n\t\topt.text=\'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\tlBox.add(opt);\n\n\t\twhile(i<= len){\n\t\t\tlBox.remove(lBox.options[i]);\n\t\t\ti+=1;\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="    \n\t\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\t\t\n\t\t\topt.value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\tparent.frames[1].document.forms[0].location.add(opt);\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<script>\n\t\tvar i=2;\n\t\tvar len=parent.frames[1].document.forms[0].b_loc.options.length;\n\t\tvar lBox=parent.frames[1].document.forms[0].b_loc; \n\t\tlBox.remove(lBox.options[0]);\n\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\n\t\topt.value=\'\';\n\t\topt.text=\'-----------------------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'-----------------------\';\n\t\tlBox.add(opt);\n\n\t\twhile(i<= len){\n\t\t\tlBox.remove(lBox.options[i]);\n\t\t\ti+=1;\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t\tparent.frames[1].document.forms[0].b_loc.add(opt);\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t var element = document.createElement(\'OPTION\');\n\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\tvar element = document.createElement(\'OPTION\');\n\t\t\telement.text = \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\t\t\telement.value= \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="%";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\tdocument.forms[0].location.add(element);\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<script>\n\t\tvar i=2;\n\t\tvar len=parent.frames[1].document.forms[0].clinic.options.length;\n\t\tvar lBox=parent.frames[1].document.forms[0].clinic; \n\t\tlBox.remove(lBox.options[0]);\n\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\n\t\topt.value=\'\';\n\t\topt.text=\'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\tlBox.add(opt);\n\n\t\twhile(i<= len){\n\t\t\tlBox.remove(lBox.options[i]);\n\t\t\ti+=1;\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="    \n\n\n\t\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\n\t\t\topt.value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\tparent.frames[1].document.forms[0].clinic.add(opt);\n\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\n\t\tparent.frames[1].document.getElementById(\"res_class\").value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t\tparent.frames[1].document.getElementById(\"pract_type\").innerHTML=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\t\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\n\t\t\tvar element = document.createElement(\'OPTION\');\n\t\t\telement.text = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\tdocument.forms[0].b_loc.add(element);\n\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\tparent.frames[1].document.getElementById(\"res_class\").value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\tparent.frames[1].document.getElementById(\"pract_type1\").innerHTML = \"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\tdocument.getElementById(\"SecResource\").disabled=false;\n\t\t\tdocument.getElementById(\"SecResCheck\").value=\'Y\';\n\t\t\tdocument.getElementById(\"recur_wo_sec_res\").value=\'Y\';\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\tdocument.getElementById(\"SecResource\").disabled=true;\n\t\t\tdocument.getElementById(\"SecResCheck\").value=\'N\';\n\t\t\tdocument.getElementById(\"recur_wo_sec_res\").value=\"\";\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\n\t\tdocument.forms[0].sec_req.value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\tdocument.forms[0].sec_sel.value=\"\";\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t<script>\n\t\tvar i=2;\n\t\tvar len=parent.frames[1].document.forms[0].locationType.options.length;\n\t\tvar lBox=parent.frames[1].document.forms[0].locationType; \n\t\tlBox.remove(lBox.options[0]);\n\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\n\t\topt.value=\'\';\n\t\topt.text=\'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\tlBox.add(opt);\n\n\t\twhile(i<= len){\n\t\t\tlBox.remove(lBox.options[i]);\n\t\t\ti+=1;\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\t\t\tparent.frames[1].document.forms[0].locationType.add(opt);\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n\t\t\t\t\tvar err_age = getMessage( \"AGE_GENDER_NOT_MATCH\" ,\"OA\") ;\n\t\t\t\t\talert(err_age);\n\t\t\t\t\tclear_all_fun1(\"P\");\n\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\tvar err_age = getMessage( \"AGE_GENDER_NOT_MATCH\" ,\"OA\") ;\n\t\t\t\t\talert(err_age);\n\t\t\t\t\tclear_all_fun1(\"P\");\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\tparent.frames[1].document.getElementById(\"resourceType\").value=\'P\';\n\t\t\tif(parent.frames[1].document.getElementById(\"resourceType_1\"))\n\t\t\t{\n\t\t\tparent.frames[1].document.getElementById(\"resourceType_1\").disabled=false;\n\t\t\tparent.frames[1].document.getElementById(\"resourceType_1\").value=\'P\';\n\t\t\t}else\n\t\t\t{\n\t\t\tparent.frames[1].document.getElementById(\"pract_type\").innerHTML=getLabel(\"Common.practitioner.label\",\"Common\");\n\t\t\t}\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\tparent.frames[1].document.getElementById(\"resourceType\").value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\t\tif(parent.frames[1].document.getElementById(\"resourceType_1\"))\n\t\t\t{\n\t\t\tparent.frames[1].document.getElementById(\"resourceType_1\").disabled=false;\n\t\t\tparent.frames[1].document.getElementById(\"resourceType_1\").value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\t\t\t}else\n\t\t\t{\n\t\t\tparent.frames[1].document.getElementById(\"pract_type\").innerHTML=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\t\t}\n\t\t\n\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\tif(parent.frames[1].document.getElementById(\"resourceType_1\"))\n\t\t{\n\t\tif(parent.frames[1].document.getElementById(\"resourceType_1\").value!=\"\")\n\t\t{\n\t\t\tparent.frames[1].document.getElementById(\"practitioner_name\").disabled=false;\n\t\t\tparent.frames[1].document.getElementById(\"search_pract\").disabled=false;\n\t\t}\n\t\t}\n\t\t\tparent.frames[1].document.getElementById(\"specialty_code1\").value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\t\t\tparent.frames[1].document.getElementById(\"locationType1\").value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\t\tparent.frames[1].document.getElementById(\"resourceType1\").value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\t\t\tparent.frames[1].document.getElementById(\"location_code1\").value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\t\t\tif(parent.frames[1].document.getElementById(\"rd_appt_yn\") && parent.frames[1].document.getElementById(\"rd_appt_yn\").value==\"Y\"){\n\t\t\t\tdocument.getElementById(\"ordCatImg\").style.visibility=\'visible\'\n\t\t\t\tparent.frames[1].document.getElementById(\"location_type\").disabled=true;\n\t\t\t}\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\tparent.frames[1].document.getElementById(\"resourceType1\").value=\'P\';\n\t\t\tparent.frames[1].document.getElementById(\"pract_type1\").innerHTML=\'Practitioner\';\n\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\tparent.frames[1].document.getElementById(\"resourceType1\").value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\t\t\tparent.frames[1].document.getElementById(\"pract_type1\").innerHTML=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="var flag;";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" \n\t\t\t\t\tflag=\"T\"; \n\t\t\t\t\tdocument.forms[0].sec_value_count.value=\"Y\"; ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" flag=\"F\";\n\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\n\t\t\t\tif(flag==\'T\'){\n\t\t\t\t\tdocument.forms[0].sec_value_count.value=\"Y\"; \n\t\t\t\t}else{\n\t\t\t\t\tdocument.forms[0].sec_value_count.value=\"N\";\n\t\t\t\t}";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\tflag=\"F\";\n\n\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\tvar err_age = getMessage( \"FIRST_VISIT_ONLY_ALLOWED\",\"OA\" ) ;\n\t\t\t\talert(err_age);\n\t\t\t\tflag=\"T\";\n\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\tvar err_age = getMessage( \"NO_SERVICE_VISIT_FIRST_VISIT_ONLY\",\"OA\" ) ;\n\t\t\t\talert(err_age);\n\t\t\t\tflag=\"T\";\n\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\tif(flag==\'T\'){\n\t\t\t\tif(document.forms[0].REC_VALUE){\n\t\t\t\t\tdocument.forms[0].REC_VALUE.value=\"Y\"; \n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tif(document.forms[0].REC_VALUE){\n\t\t\t\t\tdocument.forms[0].REC_VALUE.value=\"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\tif(document.forms[0].REC_VALUE){\n\t\t\t\t\tdocument.forms[0].REC_VALUE.value=\"N\";\n\t\t\t\t}\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\talert(f_query_add_mod.getMessage(\'ATLEAST_ONE_SELECTED\',\'Common\'));\n\t\t\tvar result=false;\n\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\tvar result=confirm(f_query_add_mod.getMessage(\'DELETE_RECORD\',\'Common\'));\n\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\tdocument.getElementById(\"res_pos_val\").value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'\n\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t<script>\n\t\tvar i=2;\n\t\tvar len=document.forms[0].new_pract.options.length;\n\t\tvar lBox=document.forms[0].new_pract; \n\t\tlBox.remove(lBox.options[0]);\n\t\tvar opt=document.createElement(\'OPTION\');\n\t\topt.value=\'\';\n\t\topt.text=\'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\tlBox.add(opt);\n\n\t\twhile(i<= len){\n\t\t\tlBox.remove(lBox.options[i]);\n\t\t\ti+=1;\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="    \n\n            var tempCode = \"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"; \n\t\t\tvar tempDesc=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";             \n\t\t\tvar opt=document.createElement(\'OPTION\');\n\t\t\topt.value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n\t\t\t//document.forms[0].new_pract.add(opt); \n\t\t\t\n\t\t\tvar temp=";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =";\n\t\t\t if(\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'==tempCode)\n\t\t\t   opt.selected=true;\n\t\t\t \n\t\t\ttemp.add(opt); \n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\tvar v_Flag=0;\t\n\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="v_Flag=1;";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\tv_Flag=0;\n\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\tvar wtlt_Flag=0;";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\twtlt_Flag=1;\n\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\twtlt_Flag=0;";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="var wtlt_Flag=0;\n\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="wtlt_Flag=1;\n\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="wtlt_Flag=0;";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="var resrt_wtlst_Flag=0;\n\t\tvar resrt_wtlst_Flag1=0;\n\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="resrt_wtlst_Flag1=0;";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="resrt_wtlst_Flag1=1;\n\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="resrt_wtlst_Flag=1;\n\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="resrt_wtlst_Flag=0;";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="var sunday_flag=0;";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\tsunday_flag=1;\n\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\tsunday_flag=0;\n\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="var holiday_flag=0;";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\tholiday_flag=1;\n\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\tholiday_flag=0;\n\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t<script>\n\t\t\tvar i=2;\n\t\t\tvar len=document.forms[0].b_clinic.options.length;\n\t\t\tvar lBox=document.forms[0].b_clinic; \n\t\t\tlBox.remove(lBox.options[0]);\n\t\t\tvar opt=document.createElement(\'OPTION\')\n\t\t\topt.value=\'\';\n\t\t    opt.text=\'-----------------------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'-----------------------\';\n\t\t\tvar opt1=document.createElement(\'OPTION\')\n\t\t\topt1.value=\'*A\';\n\t\t    opt1.text=\"*All\";\n\t\t\tlBox.add(opt);\n\t\t\tlBox.add(opt1);\n\t\t\twhile(i<= len){\n\t\t\t\tlBox.remove(lBox.options[i]);\n\t\t\t\ti+=1;\t\n\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t<script>\n\t\t\tvar i=2;\n\t\t\tvar len=document.forms[0].b_clinic.options.length;\n\t\t\tvar lBox=document.forms[0].b_clinic; \n\t\t\tlBox.remove(lBox.options[0]);\n\t\t\tvar opt=document.createElement(\'OPTION\')\n\t\t\topt.value=\'\';\n\t\t    opt.text=\'------------------------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'------------------------\';\n\t\t\tvar opt1=document.createElement(\'OPTION\')\n\t\t\topt1.value=\'*A\';\n\t\t    opt1.text=\"*All\";\n\t\t\tlBox.add(opt);\n\t\t\tlBox.add(opt1);\n\n\t\t\twhile(i<= len){\n\t\t\t\tlBox.remove(lBox.options[i]);\n\t\t\t\ti+=1;\n\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="var opt=document.createElement(\'OPTION\')\n\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"\n\t\t\t\tdocument.forms[0].b_clinic.add(opt);";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="var flag=1;";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\tflag=1;";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\tflag=0;";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t alert(getMessage(\'INVALID_REF_ID\',\'OP\'))\n\t\t document.forms[0].source.value=\'\';\n\t\t ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =" \n\t\talert(getMessage(\'MISMATCH_REFERRALID_CLINIC\',\'COMMON\'));\n\t\t document.forms[0].source.value=\'\';\n\t\t ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\tflag=1;";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\tflag=0;";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\tflag=1;";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\tflag=0;";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="var flag=true;\n\tvar flag1=true;";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\tflag=false;\n\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\tflag=true;\n\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\tflag1=false;\n\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\tflag1=true;\n\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="var Flag=true;";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =" Flag=true;";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" Flag=false;";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\n\t\tframes[1].document.bottom.document.results.document.displayresults.noslots.value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"\n\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\tdocument.forms[0].resource_class1.value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\ndocument.forms[0].resource_class2.value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\";\n\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\tdocument.forms[0].web_no_show_flag.value=false;\n\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\tdocument.forms[0].web_no_show_flag.value=true;\n\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\tvar flag1=true;\n";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\tflag1=true;\n\t\t\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\tflag1=false;\n\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\tflag1=true;\n\t\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\nvar Flag=true;\n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\tvar Obj=document.forms[0].pat_cat;\n\twhile(Obj.options.length >0 ) Obj.remove(Obj.options[0]);\n\topt=document.createElement(\'OPTION\');\n\topt.value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\';\n\topt.text=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\';\n\tObj.add(opt);\n\tdocument.forms[0].pat_cat.disabled=true;\n\tFlag=true;\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\tdocument.apptdetails_form.to_pat_alcn_cat.value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\';\n\tdocument.apptdetails_form.transfer_alcn_yn.value=\'Y\';\n\tdocument.apptdetails_form.tfr_alcn_override_yn.value=\'N\';\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\tdocument.apptdetails_form.to_pat_alcn_cat.value=\'\';\n\tdocument.apptdetails_form.transfer_alcn_yn.value=\'Y\';\n\tdocument.apptdetails_form.tfr_alcn_override_yn.value=\'Y\';\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\tfalse\n\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\ttrue\n\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="var transFlag =1;";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\ttransFlag = 1;\n\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\ttransFlag = 0;\n\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\tvar msg = getMessage(\"WAITLIST_AVA_SPECIALTY\",\"OA\" );\n\t\tmsg = msg.replace(\'$\',\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\');\n\t\tif(confirm(msg)){\n\t\t\topenWaitList();\n\t\t}else{\n\t\t\tcloseWindow();\n\t\t}\n\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\tcloseWindow();\n\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\tvar ptcnclcnt=\"0\";\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\tptcnclcnt=";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =";\n\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\t\n\n";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=utf-8");
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
 
Connection con = null;
ResultSet rs=null;
ResultSet rs1=null;
ResultSet rsw = null;
ResultSet rset2=null;
ResultSet rs3=null;
ResultSet rset_sec_value=null;

ResultSet rposchk=null;
PreparedStatement pstmt =null;
PreparedStatement pstmt1 =null;
PreparedStatement pstmt2 = null;

ResultSet rset12=null;
ResultSet prs=null;
ResultSet rsloc = null;
ResultSet prs1 = null;
ResultSet rs_wtlt=null;
ResultSet	rs_cat=null;
Statement stmtas =null;
Statement stmt3 = null;
Statement pstmtw =null;
Statement sposchk =null;
Statement stmt_wtlt=null;
Statement stmt_cat=null;
Statement stmt = null;
Statement stmt1 = null;

try{
	request.setCharacterEncoding("utf-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
con = ConnectionManager.getConnection(request);
 stmtas = con.createStatement();
 stmt3 = con.createStatement();
 pstmtw =con.createStatement();
 sposchk =con.createStatement();
 stmt_wtlt=con.createStatement();
 stmt_cat=con.createStatement();
 stmt = con.createStatement();
 stmt1 = con.createStatement();
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;

	String facilityId	=(String) session.getValue("facility_id");
	String loginuser 	= (String) session.getValue( "login_user" ) ;
	
	
	String locnval1     =(String) hash.get("locn_val");
	String clinic_type	=(String) hash.get("clinic_type");
	String steps		=(String) hash.get("steps");
	String clinic_type1=(String) hash.get("clinic_type1");	
	String clinic_code1=(String) hash.get("clinic_code1");	
	String resourcek=(String) hash.get("resource1");	
	String wait_clinic_code		=(String) hash.get("wait_clinic_code");
	String pat_id1		=(String) hash.get("pat_id");
	if (resourcek==null)		resourcek="";
	String practitionercode=(String) hash.get("practitionercode");

	String visit_typ_cd1=(String) hash.get("visit_typ_cd");
	String prm_res_class1=(String) hash.get("prm_res_class");
	String pract_id=(String) hash.get("pract_id");
	String clinic_code_rec=(String) hash.get("clinic_code_rec");
	
	String speciality=(String) hash.get("speciality");
	String location=(String)hash.get("location");
	if(location==null) location="";
	
	String or_catalogue_code=(String) hash.get("or_catalogue_code");
	String sec_req=(String) hash.get("sec_req");
	String clinic_code_sec=(String) hash.get("clinic_code");
	String clinic_date_sec = (String) hash.get("clinic_date");
	String facility_id_sec =(String) hash.get("facility_id");
	
	String fromFunc =(String) hash.get("from");
	String currSelHolidays= (String) hash.get("currSelHolidays");
	String recurringdays= (String) hash.get("recurringdays");
	String wait_careLocnTypeInd=(String) hash.get("wait_careLocnTypeInd");
	String efffrom=(String) hash.get("efffrom");
	String practid=(String) hash.get("practid");
	String locncode=(String) hash.get("locncode");
	String locnType=(String) hash.get("locnType");
	String resourceType=(String) hash.get("resourceType");
	String curTime=(String) hash.get("Time");
	String Service_code_rec = (String) hash.get("service1_code");
	String sel_service_code = (String) hash.get("sel_service_code");
	String pat_id_rec = (String) hash.get("pat_id_rec");
	String facilityid_rec= (String) hash.get("facilityid_rec");
	String preferred_date=(String) hash.get("date_val");
	if(preferred_date ==null) preferred_date="";
		String vtype_ind=(String) hash.get("vtype_ind");

	//String speciality_wtlt=(String) hash.get("speciality_wtlt");
	
String speciality_code=(String) hash.get("speciality_code");
if(speciality_code ==null) speciality_code="";
	//String spec_manage_wtlt=(String) hash.get("spec_manage_wtlt");
	
	if (wait_careLocnTypeInd==null) wait_careLocnTypeInd="";

	int cntw;
	if (or_catalogue_code==null)		or_catalogue_code="";

	String sel_sec=(String) hash.get("sel_sec");
	if (sel_sec==null)		sel_sec="";
	String selec_sec_val=(String) hash.get("selec_sec_val");
	if (selec_sec_val==null)		selec_sec_val="";


	String fromtime     =(String) hash.get("fromtime");
	String totime	=(String) hash.get("totime");
	String timeperpatient	=(String) hash.get("timeperpatient");
	String multi_speciality_yn="N";//Changes for the CRF - Bru-HIMS-CRF-0198
	String alert_req_book_appt_yn=""; // added by mujafar for GHL-CRF-0527
	String popup_desc_book_appt = "";


	if (speciality==null)		speciality="";
	String carelocn1=(String) hash.get("carelocn");	
	if (steps==null)		steps="";
	if (clinic_type==null)		clinic_type="";
	if (clinic_code1==null)		clinic_code1="";
	if (wait_clinic_code==null)		wait_clinic_code="";
	if (pat_id1==null)		pat_id1="";
	if (practitionercode==null)		practitionercode="";
	if (carelocn1==null)		carelocn1="";
	//String oper_stn_id=(String) hash.get("oper_stn_id");

	String locale			= (String)session.getAttribute("LOCALE");

	
    ResultSet rssql1=null;
	

	Statement stsql2 = con.createStatement();	
	Statement stsql1 = con.createStatement();
	if(steps.equals("1")){ // TT  & setup daily schedule & holiday
		

		StringBuffer sql  =new StringBuffer("");
		sql.append("Select care_locn_type_ind,a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur,a.PRIMARY_RESOURCE_CLASS from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A'  ");
		
		if ((fromFunc.equals("Holiday") && !clinic_type.equals("all")) || fromFunc.equals("TimeTableScheduling") || fromFunc.equals("SetupDailySchedule")){
			if(clinic_type.equals("D")){
				sql.append(" and a.clinic_type='Y' ");
			}else{
				sql.append(" and a.clinic_type='"+clinic_type+"' ");
			}	
			
			sql.append(" and a.care_locn_type_ind='"+clinic_type+"' and b.locn_type=a.clinic_type  order by a.long_desc");	

		}else{
			sql.append("  and b.locn_type=a.clinic_type  order by a.long_desc");
		}

		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);
		

		if (fromFunc.equals("TimeTableScheduling")){
            _bw.write(_wl_block2Bytes, _wl_block2);
}else if (fromFunc.equals("SetupDailySchedule")){
            _bw.write(_wl_block3Bytes, _wl_block3);
}else if (fromFunc.equals("Holiday")){
            _bw.write(_wl_block4Bytes, _wl_block4);
}	
		
		
		String short_desc="";
		String clinic_code="";
		String open_to_all_pract_yn="";
		String fi_visit_type_appl_yn="";
		String ident_at_checkin="";
		String alcn_criteria="";
		String STime="";
		String ETime="";
		String dur="";
		String care_locn_type_ind="";
		String primary_res_class="";

		while(rs!=null && rs.next() ){

			care_locn_type_ind=rs.getString("care_locn_type_ind");
			short_desc=rs.getString("long_desc");
			clinic_code=rs.getString("clinic_code");
			clinic_type=rs.getString("clinic_type");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
			ident_at_checkin=rs.getString("ident_at_checkin");
			fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn");
			alcn_criteria=rs.getString("alcn_criteria");
			alcn_criteria = (alcn_criteria == null?"":alcn_criteria) ;
			STime=rs.getString("STime");
			ETime=rs.getString("ETime");
			dur =rs.getString("dur");
			primary_res_class = rs.getString("PRIMARY_RESOURCE_CLASS");

			if (fromFunc.equals("TimeTableScheduling")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(ident_at_checkin));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(STime));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(ETime));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(dur));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(primary_res_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else if (fromFunc.equals("SetupDailySchedule")) {
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ident_at_checkin));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fi_visit_type_appl_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(STime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ETime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dur));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(primary_res_class));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else if (fromFunc.equals("Holiday")){
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(care_locn_type_ind));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
		}

}else if(steps.equals("2")){
	
		StringBuffer sql=new StringBuffer("");
		String dat1="";
		String ID1="";
		String clinictype1="";
		String alcncriteria1="";
		String opentoallpractyn1="";
		String identatcheckin1="";
		String fivisit1="";
		String STime="";
		String ETime="";
		String dur="";

		if(((clinic_type1 != null) || !(clinic_type1.equals("")))){ 		

			sql.append("Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type and a.clinic_type='"+clinic_type1+"' and ");
					
					
			if(clinic_type1.equals("Y")){
				sql.append("  a.care_locn_type_ind='D' ");
			}else{
				sql.append(" a.care_locn_type_ind='"+clinic_type1+"' ");
			}	
					
			sql.append(" order by a.long_desc");
				
			if (rs!=null) rs.close();
			rs = stmt.executeQuery(sql.toString()) ;
			sql.setLength(0);
			
            _bw.write(_wl_block19Bytes, _wl_block19);

			if (rs != null){
						
				while(rs.next()){

					dat1=rs.getString("long_desc");
					ID1=rs.getString("clinic_code");
					clinictype1= rs.getString("CLINIC_TYPE");
					opentoallpractyn1 = rs.getString("open_to_all_pract_yn");
					identatcheckin1 = rs.getString("ident_at_checkin");
					fivisit1=rs.getString("fi_visit_type_appl_yn");
					alcncriteria1=rs.getString("alcn_criteria");
					alcncriteria1 = (alcncriteria1 == null?"":alcncriteria1) ;
					STime=rs.getString("STime");
					ETime=rs.getString("ETime");
					dur =rs.getString("dur");	
			
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ID1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(clinictype1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(opentoallpractyn1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(identatcheckin1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fivisit1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(alcncriteria1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(STime));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ETime));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dur));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dat1));
            _bw.write(_wl_block23Bytes, _wl_block23);

				}
			}
		}

	}else if(steps.equals("12")){
		String dayofweek="";
		String dayofweek_desc="";
		
		int i=1;

		if((practitionercode != null) && (!practitionercode.equals("")) ) {

			StringBuffer sql = new StringBuffer("");
			sql.append(" select b.day_of_week day_of_week, a.day_no from oa_clinic_time_table a, sm_day_of_week b 		where facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code1+"' and 			a.practitioner_id  = '"+practitionercode+"' and a.phys_roster_reqd_yn = 'Y' and ");			
				
			if(carelocn1.equals("Y")){
				sql.append(" CARE_LOCN_TYPE_IND='D'");
			}else{
				sql.append(" CARE_LOCN_TYPE_IND='"+carelocn1+"'");
			}
				
				
			sql.append(" and a.day_no = b.day_no order by day_no ") ;

			rset12=stmt.executeQuery(sql.toString());
			sql.setLength(0);
				
			if(rset12.next()){
				
				String yyy="";
													
				String plus="";

				String xxx="<tr id='roster' colspan='6' nowrap><td  class='label' id='roaster' width='10%' valign='right' class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.RosterDays.label","oa_labels")+"</td>";
				String rrr="<td class='label' width='100%' colspan='3'><table border='0' id='id' cellpadding='0' cellspacing='0' align='left' width='100%'>" ;
						
				do{
								
					dayofweek =  rset12.getString("day_of_week");

					if(dayofweek.equals("MONDAY"))
								{
									dayofweek_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(dayofweek.equals("TUESDAY"))
								{
									dayofweek_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(dayofweek.equals("WEDNESDAY"))
								{
									dayofweek_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(dayofweek.equals("THURSDAY"))
								{
									dayofweek_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(dayofweek.equals("FRIDAY"))
								{
									dayofweek_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(dayofweek.equals("SATURDAY"))
								{
									dayofweek_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(dayofweek.equals("SUNDAY"))
								{
									dayofweek_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

							
					dayofweek = dayofweek.substring(0,3);

							
					yyy=" <td width='10%'><font class='label' >&nbsp;&nbsp;"+dayofweek_desc+"</font><br>&nbsp;&nbsp;<input type='checkbox' name=day_"+i+" value="+dayofweek+" checked></td>";
						
					plus=plus+yyy;
							
					i++;
				
				}while(rset12.next());
							
				String bbb="</table></td></tr> " ;
							
				String total=rrr+plus+bbb;
					
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(xxx));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(total));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(resourcek));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(carelocn1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(clinic_code1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(practitionercode));
            _bw.write(_wl_block31Bytes, _wl_block31);

			}else {
            _bw.write(_wl_block32Bytes, _wl_block32);
}
		}

	}else if(steps.equals("4")){ // transfer location schedule
			   
		StringBuffer sql  = new StringBuffer("");
		sql.append("select a.long_desc long_desc, clinic_code, open_to_all_pract_yn,b.short_desc locn_type from op_clinic_lang_vw a, am_care_locn_type b ,am_locn_for_oper_stn c where a.facility_id='"+facilityId+"' and c.OPER_STN_ID =(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and a.language_id='"+locale+"' and a.allow_appt_yn='Y' and a.eff_status='E' and a.level_of_care_ind = 'A' and a.clinic_type = b.locn_type and c.locn_code=a.clinic_code and ");
		
		
		if(clinic_type.equals("D")){
			sql.append("  a.clinic_type='Y' ");
		}else{
			sql.append("  a.clinic_type='"+clinic_type+"' ");
		}
		
		sql.append(" and a.CARE_LOCN_TYPE_IND='"+clinic_type+"' and b.locn_type=a.clinic_type and b.locn_type=c.locn_type  order by a.long_desc");


		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);
		
            _bw.write(_wl_block33Bytes, _wl_block33);
	
		String short_desc="";
		String clinic_code="";
		String open_to_all_pract_yn="";
		String cTyp="";

		while(rs!=null && rs.next() ){
			short_desc=rs.getString("long_desc");
			clinic_code=rs.getString("clinic_code");
			cTyp=rs.getString("locn_type");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cTyp));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
}

	}else if(steps.equals("5")){ // change resource for generated schedule
	   
		StringBuffer sql  =new StringBuffer("");
		sql.append(" select a.long_desc,a.clinic_code,a.clinic_type, a.open_to_all_pract_yn from OP_CLINIC_lang_vw a,am_locn_for_oper_stn b where a.facility_id='"+ facilityId + "' and a.allow_appt_yn='Y' and b.OPER_STN_ID =(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+loginuser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and a.level_of_care_ind = 'A' and a.eff_status='E' and a.language_id='"+locale+"' and  a.clinic_code = b.locn_code and a.clinic_type=b.locn_type and ");
		
		
		if(locnval1.equals("D")){
		  sql.append("  a.clinic_type='Y' ");

		}else{
		  sql.append("  a.clinic_type='"+locnval1+"' ");

		}
		
		sql.append(" and a.CARE_LOCN_TYPE_IND='"+locnval1+"' order by long_desc");

		String short_descc = "";
		String clinic_codec ="";
		String clinic_typec ="";
		String open_to_practc ="";

		if (rs!=null) rs.close();
	
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);

		if(rs!=null) {
			while(rs.next()) {

				short_descc = rs.getString("long_desc");
				clinic_codec = rs.getString("clinic_code"); 
				open_to_practc =rs.getString("open_to_all_pract_yn");
				clinic_typec = rs.getString("clinic_type");

				
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(short_descc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(clinic_codec));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(clinic_typec));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(open_to_practc));
            _bw.write(_wl_block39Bytes, _wl_block39);
   
			}
		}

	}else if(steps.equals("6")){  // Block lift cancelSchedule

		
		StringBuffer sql  = new StringBuffer("");
		sql.append("select a.long_desc long_desc, clinic_code, open_to_all_pract_yn, a.ident_at_checkin,b.short_desc locn_type,a.primary_resource_class  from op_clinic_lang_vw   a, am_care_locn_type b ,am_locn_for_oper_stn c where c.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"'  AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and c.locn_code=a.clinic_code and a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and allow_appt_yn='Y' and a.eff_status='E' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type and  B.LOCN_TYPE=C.LOCN_TYPE AND ");
	   
		if(clinic_type.equals("D")){
			sql.append("  a.clinic_type='Y' ");
		}else{
			sql.append("  a.clinic_type='"+clinic_type+"' ");
		}
	   
		sql.append(" and a.CARE_LOCN_TYPE_IND='"+clinic_type+"' order by a.long_desc");

		if (rs!=null) rs.close();
		
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);
		
            _bw.write(_wl_block40Bytes, _wl_block40);
	
		String identitiy_check_in="";
		String clinic_code="";
		String open_to_all_pract_yn="";
		String cTyp="";
		String short_desc="";
		String primary_resource_class ="";
		

		while(rs!=null && rs.next() ){
			short_desc=rs.getString("long_desc");
			clinic_code=rs.getString("clinic_code");
			cTyp=rs.getString("locn_type");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
			identitiy_check_in=rs.getString("ident_at_checkin");
			primary_resource_class=rs.getString("primary_resource_class");

			
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cTyp));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(identitiy_check_in));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(primary_resource_class));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
}


	}else if(steps.equals("7")){  // query for patients

		
		StringBuffer sql  =new StringBuffer("");
		sql.append("select a.long_desc long_desc, clinic_code, open_to_all_pract_yn from op_clinic_lang_vw a where a.facility_id='"+facilityId+"' and level_of_care_ind = 'A' and  a.eff_status='E' and language_id='"+locale+"' and  ");
	   
	   
		if(clinic_type.equals("D")){
			sql.append("  clinic_type='Y' ");
		}else{
			sql.append("  clinic_type='"+clinic_type+"' ");
		}
	   
		sql.append("  and a.CARE_LOCN_TYPE_IND='"+clinic_type+"' order by a.long_desc");
		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);
		
            _bw.write(_wl_block43Bytes, _wl_block43);
	
		String clinic_code="";
		String open_to_all_pract_yn="";
		String short_desc="";

		

		while(rs!=null && rs.next() ){
			short_desc=rs.getString("long_desc");
			clinic_code=rs.getString("clinic_code");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
}


	}else if(steps.equals("8")){  // Queries- Location for schedule

		

		StringBuffer sql =new StringBuffer("");
		sql.append("select long_desc long_desc, clinic_code, open_to_all_pract_yn,to_char(sysdate,'dd/mm/yyyy')  sydate from op_clinic_lang_vw where facility_id='"+facilityId+"' and level_of_care_ind = 'A' and eff_status='E' and language_id='"+locale+"' and ");

		if(locnval1.equals("D")){
			sql.append("  clinic_type='Y' ");
		}else{
			sql.append("  clinic_type='"+locnval1+"' ");
		}

		sql.append(" and CARE_LOCN_TYPE_IND='"+locnval1+"' order by long_desc");

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);
		String shortdesc2 ="";
		String cliniccode2 ="";
		String opentopract2 ="";

		if(rs!=null) {
			 while(rs.next()) {

				 shortdesc2 = rs.getString("long_desc");
				 cliniccode2 = rs.getString("clinic_code"); 
				 opentopract2 =rs.getString("open_to_all_pract_yn");			

				
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(shortdesc2));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(opentopract2));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cliniccode2));
            _bw.write(_wl_block39Bytes, _wl_block39);
    
			}
		}

	}else if(steps.equals("9")){  // Query Block on Appt

		
			
		StringBuffer sql = new StringBuffer("");
		sql.append("select long_desc long_desc, clinic_code, open_to_all_pract_yn from op_clinic_lang_vw   where facility_id='"+facilityId+"' and level_of_care_ind = 'A'  and eff_status='E' and  language_id='"+locale+"'  and ");

		if(locnval1.equals("D")){
			sql.append("  clinic_type='Y' ");

		}else{
			sql.append("  clinic_type='"+locnval1+"' ");

		}


		sql.append(" and CARE_LOCN_TYPE_IND='"+locnval1+"' order by long_desc");


		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);

		String shortdesc3 ="";
		String cliniccode3 ="";
		String opentopract3="";

		if(rs!=null) {
			while(rs.next()) {

				shortdesc3 = rs.getString("long_desc");
				cliniccode3 = rs.getString("clinic_code"); 
				opentopract3 =rs.getString("open_to_all_pract_yn");


				
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(shortdesc3));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(opentopract3));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cliniccode3));
            _bw.write(_wl_block39Bytes, _wl_block39);
    
			}
		}

	}else if(steps.equals("10")){   // block appt slots
		
		StringBuffer sql  =new StringBuffer("");
		sql.append("Select a.long_desc,a.clinic_code,a.CLINIC_TYPE,a.OPEN_TO_ALL_PRACT_YN,ident_at_checkin  from op_clinic_lang_vw a, am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code  and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and ") ;


		if(locnval1.equals("D")){
			sql.append("  a.clinic_type='Y' ");

		}else{
			sql.append("  a.clinic_type='"+locnval1+"' ");

		}

		sql.append(" and a.CARE_LOCN_TYPE_IND='"+locnval1+"' and a.clinic_type=b.locn_type order by a.long_desc");

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);

		String short_desc="";
		String clinic_code="";

		String open_to_all_pract_yn="";
		String ident_at_checkin ="";

		while(rs!=null && rs.next() ){
			short_desc=rs.getString("long_desc");
			clinic_code=rs.getString("clinic_code");
			clinic_type=rs.getString("CLINIC_TYPE");
			open_to_all_pract_yn=rs.getString("OPEN_TO_ALL_PRACT_YN");
			ident_at_checkin=rs.getString("ident_at_checkin");
			
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ident_at_checkin));
            _bw.write(_wl_block49Bytes, _wl_block49);
    
		}

	}else if(steps.equals("11")){

		

		StringBuffer sql  = new StringBuffer("");
		sql.append("select a.open_to_all_pract_yn,a.long_desc,a.clinic_code from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and (b.book_appt_yn='Y' or b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.language_id='"+locale+"' and a.clinic_type=b.locn_type and ");
		
		if(!speciality.equals("")){
			sql.append(" a.SPECIALITY_CODE='"+speciality+"' and ");
		}
		
		
		
		if(clinic_type.equals("D")){
			sql.append("  a.clinic_type='Y' ");

		}else{
			sql.append("  a.clinic_type='"+clinic_type+"' ");

		}

		sql.append(" and a.CARE_LOCN_TYPE_IND='"+clinic_type+"' order by a.long_desc");
        
		

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);
		
            _bw.write(_wl_block50Bytes, _wl_block50);
	
		String short_desc="";
		String clinic_code="";
		String open_to_all_pract_yn="";

		while(rs!=null && rs.next() ){
			short_desc=rs.getString("long_desc");
			clinic_code=rs.getString("clinic_code");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");

			
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);

		}	


	}else if(steps.equals("X")){
		String sql  = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+facilityId+"'";
        
		String code="";
		String desc="";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);

		while(rs!=null && rs.next()){
			code=rs.getString("primary_resource_class");
			//desc=rs.getString("description");
			if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}

		}
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block55Bytes, _wl_block55);



	}else if(steps.equals("S")){   
		// Transfer Cancel appt & secondary booking for recurring

		


		StringBuffer sql=new StringBuffer("");
		sql.append(" select a.long_desc,a.clinic_code,open_to_all_pract_yn from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.clinic_type=b.locn_type and ");

		if(clinic_type.equals("D")){
		sql.append("  a.clinic_type='Y' ");

		}else{
		sql.append("  a.clinic_type='"+clinic_type+"' ");

		}

		sql.append(" and a.CARE_LOCN_TYPE_IND='"+clinic_type+"' order by a.long_desc");


		rs3	= stmt.executeQuery( sql.toString() ) ;
		sql.setLength(0);

		String cliniccode = "" ;
		String clinicdesc = "" ;
		String open_to_all_pract_yn  = "" ;

		while(rs3 !=null && rs3.next()){
			cliniccode = rs3.getString("clinic_code") ;	
			clinicdesc = rs3.getString("long_desc") ;
			open_to_all_pract_yn = rs3.getString("open_to_all_pract_yn");	
			
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(clinicdesc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block57Bytes, _wl_block57);

		}

	}else if(steps.equals("U")){

		String sql  = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+facilityId+"'";

		String code="";
		String desc="";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);

		while(rs!=null && rs.next()){
			code=rs.getString("primary_resource_class");
			//desc=rs.getString("description");
			if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
		}

		
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block60Bytes, _wl_block60);


	}else if(steps.equals("RES")){
		String sec_resources="";
		String sql  = "select resource_class,resource_type,resource_criteria from op_resource_type_for_appt where facility_id='"+facilityId+"' and visit_type_code='"+visit_typ_cd1+"' and resource_class !='"+prm_res_class1+"'  order by resource_class ";
		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);
		while(rs!=null && rs.next()){
			sec_resources=sec_resources+rs.getString("resource_class");
			sec_resources=sec_resources+"*"+rs.getString("resource_criteria")+"-";
		}
		if(sec_resources.length()>1)
		sec_resources=sec_resources.substring(0,sec_resources.length()-1);
		if(sec_resources.length()>1){
            _bw.write(_wl_block61Bytes, _wl_block61);
}else{
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(sec_resources));
            _bw.write(_wl_block64Bytes, _wl_block64);



	}else if (steps.equals("APPTWTLST")){
	

		StringBuffer sql  = new StringBuffer("");

		if(clinic_type.equals("N")){
			sql.append("Select a.long_desc long_desc, a.NURSING_UNIT_CODE clinic_code from IP_Nursing_unit_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b,ip_nurs_unit_for_specialty c  where B.locn_type = 'N' and a.facility_id='"+facilityId+"' and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE=b.locn_code and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)))  AND A.EFF_STATUS = 'E' and c.SPECIALTY_CODE='"+speciality+"' and c.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and c.facility_id='"+facilityId+"' and a.language_id='"+locale+"' AND b.appl_user_id='"+loginuser+"' AND b.CREATE_WAIT_LIST_YN='Y' order by a.long_desc ");
		}else{
			sql.append("Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur from op_clinic_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and a.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.language_id='"+locale+"' and a.SPECIALITY_CODE='"+speciality+"' and  b.CREATE_WAIT_LIST_YN='Y' and b.appl_user_id='"+loginuser+"' and ") ;

			 if(clinic_type.equals("D")){
			  sql.append("  a.clinic_type='Y' ");

			}else{
			  sql.append(" a.clinic_type='"+clinic_type+"' ");

			}	

			sql.append(" and a.care_locn_type_ind='"+clinic_type+"' and a.clinic_type=b.LOCN_TYPE order by a.long_desc");
		}

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);
		
            _bw.write(_wl_block40Bytes, _wl_block40);
	
		String short_desc="";
		String clinic_code="";
		String open_to_all_pract_yn="";
		String fi_visit_type_appl_yn="";
		String ident_at_checkin="";
		String alcn_criteria="";
		String STime="";
		String ETime="";
		String dur="";

		while(rs!=null && rs.next() ){
			short_desc=rs.getString("long_desc");
			clinic_code=rs.getString("clinic_code");

			if(clinic_type.equals("N")){
				clinic_type="N";
				open_to_all_pract_yn="";
				ident_at_checkin="";
				fi_visit_type_appl_yn="";
				alcn_criteria="";
				STime="";
				ETime="";
				dur ="";
			}else{
				clinic_type=rs.getString("clinic_type");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
				ident_at_checkin=rs.getString("ident_at_checkin");
				fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn");
				alcn_criteria=rs.getString("alcn_criteria");
				alcn_criteria = (alcn_criteria == null?"":alcn_criteria) ;
				STime=rs.getString("STime");
				ETime=rs.getString("ETime");
				dur =rs.getString("dur");
			}

			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ident_at_checkin));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fi_visit_type_appl_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(STime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ETime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dur));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);

		}	

		if (rssql1!=null) rssql1.close();

	}else if(steps.equals("WaitListMgmt")) {
	

		StringBuffer sql  = new StringBuffer("");

		if(clinic_type.equals("N")){
			sql.append("Select a.long_desc long_desc, a.NURSING_UNIT_CODE clinic_code from IP_Nursing_unit_lang_vw a , am_locn_for_oper_stn b,ip_nurs_unit_for_specialty c  where B.locn_type = 'N' and a.facility_id='"+facilityId+"' and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE=b.locn_code and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)))  AND A.EFF_STATUS = 'E' and c.SPECIALTY_CODE='"+speciality+"' and a.language_id='"+locale+"' and c.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and c.facility_id='"+facilityId+"' order by a.long_desc ");
		}else{
			sql.append("Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.language_id='"+locale+"' and a.SPECIALITY_CODE='"+speciality+"' and ") ;

			 if(clinic_type.equals("D")){
			  sql.append("  a.clinic_type='Y' ");

			}else{
			  sql.append(" a.clinic_type='"+clinic_type+"' ");

			}	

			sql.append(" and a.care_locn_type_ind='"+clinic_type+"' and a.clinic_type=b.LOCN_TYPE order by a.long_desc");
		}

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);
		
            _bw.write(_wl_block65Bytes, _wl_block65);
	
		String short_desc="";
		String clinic_code="";
		String open_to_all_pract_yn="";
		String fi_visit_type_appl_yn="";
		String ident_at_checkin="";
		String alcn_criteria="";
		String STime="";
		String ETime="";
		String dur="";

		while(rs!=null && rs.next() ){
			short_desc=rs.getString("long_desc");
			clinic_code=rs.getString("clinic_code");

			if(clinic_type.equals("N")){
				clinic_type="N";
				open_to_all_pract_yn="";
				ident_at_checkin="";
				fi_visit_type_appl_yn="";
				alcn_criteria="";
				STime="";
				ETime="";
				dur ="";
			}else{
				clinic_type=rs.getString("clinic_type");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
				ident_at_checkin=rs.getString("ident_at_checkin");
				fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn");
				alcn_criteria=rs.getString("alcn_criteria");
				alcn_criteria = (alcn_criteria == null?"":alcn_criteria) ;
				STime=rs.getString("STime");
				ETime=rs.getString("ETime");
				dur =rs.getString("dur");
			}

			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ident_at_checkin));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fi_visit_type_appl_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(STime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ETime));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dur));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);

		}	

		if (rssql1!=null) rssql1.close();

	}else if(steps.equals("CreateWaitList")){
					
		String sqlch="";

		if (!wait_careLocnTypeInd.equals("N")){
			sqlch = "select count(1) cnt from op_clinic a where clinic_code ='"+wait_clinic_code+"' and  ((age_group_code is null ) or ((age_group_code is not null) and  exists (select age_group.age_group_code from am_age_group age_group,mp_patient patient where patient.patient_id ='"+pat_id1+"' and age_group.age_group_code=a.age_group_code and nvl(age_group.gender,patient.sex)=patient.sex and trunc(sysdate)-trunc(patient.date_of_birth) between decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.min_age and decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.max_age and age_group.eff_status='E' ))) and facility_id = '"+facilityId+"'" ;

			rsw = pstmtw.executeQuery(sqlch);
			
			if(rsw.next()) {
				cntw = rsw.getInt("cnt");
				if (cntw==0){
				
            _bw.write(_wl_block67Bytes, _wl_block67);

				}
			}
		}else if (wait_careLocnTypeInd.equals("N")){

if(rsw !=null)rsw.close();
			sqlch = "select count(1) cnt from IP_NURSING_UNIT a where NURSING_UNIT_CODE ='"+wait_clinic_code+"' and  ((age_group_code is null ) or ((age_group_code is not null) and  exists (select age_group.age_group_code from am_age_group age_group,mp_patient patient where patient.patient_id ='"+pat_id1+"' and age_group.age_group_code=a.age_group_code and nvl(age_group.gender,patient.sex)=patient.sex and trunc(sysdate)-trunc(patient.date_of_birth) between decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.min_age and decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.max_age and age_group.eff_status='E' ))) and facility_id = '"+facilityId+"'" ;
			
			rsw = pstmtw.executeQuery(sqlch);	

			if(rsw.next()) {
				cntw = rsw.getInt("cnt");

				if (cntw==0){
            _bw.write(_wl_block68Bytes, _wl_block68);

				}
			}


		}

	}else if(steps.equals("XXX")){
		
		String sql  = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+facilityId+"'";
	 
		String code="";
		String desc="";

		
		if (rs!=null) rs.close();		
		rs = stmt.executeQuery(sql);

		while(rs!=null && rs.next()){
			code=rs.getString("primary_resource_class");
	
			
			if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}

		}

	

		if(clinic_type.equals("N")){
            _bw.write(_wl_block69Bytes, _wl_block69);
}else{
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
}
		
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(location));
            _bw.write(_wl_block78Bytes, _wl_block78);


	}else if(steps.equals("managewaitlistreso")){

		String sql  = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+facilityId+"'";

		String code="";
		String desc="";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);

		while(rs!=null && rs.next()){
			code=rs.getString("primary_resource_class");
			
			if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		   desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}

		}
		if(clinic_type.equals("N")){
            _bw.write(_wl_block79Bytes, _wl_block79);
}else{
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block60Bytes, _wl_block60);
}

	}else if(steps.equals("CLR_SESSION")){

		session.removeAttribute("from_wait_list");
		session.removeAttribute("waitListNo");

	}else if(steps.equals("ADD_SEC_TO_SESSION")){
		int sec_count=0;
				
		//String sec_value="";

		
            _bw.write(_wl_block82Bytes, _wl_block82);

		//sec_value="select count(practitioner_id) sum from oa_clinic_schedule where clinic_code='"+clinic_code_sec+"' and  clinic_date=to_date('"+clinic_date_sec+"','dd/mm/yyyy') and facility_id='"+facility_id_sec+"' and primary_resource_yn='N' and resource_class in ("+sec_req+") and time_table_type in (1,2) group by resource_class";

		rset_sec_value=stmtas.executeQuery("select count(practitioner_id) sum from oa_clinic_schedule where clinic_code='"+clinic_code_sec+"' and  clinic_date=to_date('"+clinic_date_sec+"','dd/mm/yyyy') and facility_id='"+facility_id_sec+"' and primary_resource_yn='N' and resource_class in ("+sec_req+") and time_table_type in (1,2) group by resource_class");


		if(rset_sec_value !=null){
			while( rset_sec_value.next()){
				sec_count=rset_sec_value.getInt("sum");
			
				if(sec_count >1){
            _bw.write(_wl_block83Bytes, _wl_block83);

					break ;
				}else{
					
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block85Bytes, _wl_block85);

			}// while
		}// if

		session.putValue("SEC_RES_SEL",sel_sec);

		if(stmtas !=null) stmtas.close();
	}else if(steps.equals("ADD_SECNEXT_TO_SESSION")){

		session.putValue("SEC_EQU_SEL",selec_sec_val);

	}else if(steps.equals("CLEAR_ALL_FROM_SESSION")){
		session.removeAttribute("SEC_RES_SEL");
		session.removeAttribute("REC_RES_SEL");
		session.removeAttribute("SEC_EQU_SEL");
		session.removeAttribute("patInstructionsMap");
		session.removeAttribute("prcInstructionMap");

	}else if(steps.equals("CLEAR_SEC_FROM_SESSION")){
		session.removeAttribute("SEC_RES_SEL");

	}else if(steps.equals("CLEAR_REC_FROM_SESSION")){

		session.removeAttribute("REC_RES_SEL");
		
            _bw.write(_wl_block82Bytes, _wl_block82);

		if(pat_id_rec ==null) pat_id_rec="";
		if(Service_code_rec ==null) Service_code_rec="";
		if(sel_service_code ==null) sel_service_code="";
		if(facilityid_rec ==null) facilityid_rec="";
		String override_vtype_on_epsd_yn="";
		String sql = "select OVERRIDE_VTYPE_ON_EPSD_YN from op_param where OPERATING_FACILITY_ID='"+facilityid_rec+"'" ;
		pstmt1=con.prepareStatement(sql);
		prs=pstmt1.executeQuery();

		int cnt=0;

		if(prs!=null&&prs.next()){
			override_vtype_on_epsd_yn = prs.getString("OVERRIDE_VTYPE_ON_EPSD_YN");
		}
		if(prs!=null)prs.close();

			if (override_vtype_on_epsd_yn.equals("N") && !vtype_ind.equals("F")){
				String sql_one="";
				if(sel_service_code==null || sel_service_code.equals("")){
				sql_one="select count(*) count from pr_encounter where facility_id ='"+facilityid_rec+"'and assign_care_locn_code = '"+clinic_code_rec+"' and patient_id ='"+pat_id_rec+"' and visit_adm_type_ind = 'F' and patient_class = 'OP'";
				}else{
				sql_one="SELECT COUNT (*) COUNT FROM pr_encounter WHERE facility_id = '"+facilityid_rec+"' AND service_code = '"+sel_service_code+"' and patient_id ='"+pat_id_rec+"'   AND visit_adm_type_ind = 'F' AND patient_class = 'OP'";
				}

		  prs1=stmt.executeQuery(sql_one);
		  while(prs1 !=null && prs1.next())
		 {
			cnt=prs1.getInt("count");
		 }
		 if(cnt >=1) {
            _bw.write(_wl_block86Bytes, _wl_block86);
}else{
				if(sel_service_code==null || sel_service_code.equals("")){
            _bw.write(_wl_block87Bytes, _wl_block87);
}else{
            _bw.write(_wl_block88Bytes, _wl_block88);
}
			}
			
            _bw.write(_wl_block89Bytes, _wl_block89);

		}else{
            _bw.write(_wl_block90Bytes, _wl_block90);
}// while
		 

	}else if(steps.equals("ADD_RECC_TO_SESSION")){
		session.putValue("REC_RES_SEL",recurringdays);	


	}else if (steps.equals("Holiday")){
		
		ArrayList selectedHolidays= new ArrayList();

		int currPage=0;

		

			selectedHolidays.add(currPage,currSelHolidays);

		int count=0;
		
		for(int i=0;i< selectedHolidays.size();i++){
			String temp=(String)selectedHolidays.get(i);
			if (temp.equals("")) count++;

		}


		if (selectedHolidays.size()==count){
            _bw.write(_wl_block91Bytes, _wl_block91);
}else{
            _bw.write(_wl_block92Bytes, _wl_block92);
}
selectedHolidays.clear();
	}else if(steps.equals("TRANS_LOCN_SCH_POS")){
		//Changed for PE By Sudhakar
		StringBuffer poschk=new StringBuffer("");
		String posval="";

		poschk.append("select PRIMARY_RESOURCE_YN from oa_clinic_schedule where clinic_date=to_date('"+efffrom+"','dd/mm/yyyy') and clinic_code='"+locncode+"'and care_locn_type_ind='"+locnType+"' and resource_class='"+resourceType+"' ");
		if(practid.equals("")){
			poschk.append(" and practitioner_id is null");
		}else{
			poschk.append(" and practitioner_id='"+practid+"'");
		}

		rposchk=sposchk.executeQuery(poschk.toString());
		poschk.setLength(0);		
		if(rposchk !=null && rposchk.next()){
			posval=rposchk.getString("PRIMARY_RESOURCE_YN");
			if(posval==null || posval.equals("null")) posval="";
		}
		
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(posval));
            _bw.write(_wl_block94Bytes, _wl_block94);



	}else if(steps.equals("CA")){
		
		/*below line added for this CRF PMG2013-CRF-0016 [IN:044523]*/
		String loc_code="";
		String frameref="document.forms[0].new_pract";
		String sql_location="select distinct(a.clinic_code) locaton_code, op_get_desc.op_clinic(facility_id, clinic_code, '"+locale+"','1') short_desc, TO_CHAR (start_time,'hh24:mi') strdate, TO_CHAR (end_time,'hh24:mi') enddate from oa_clinic_schedule a where a.practitioner_id='"+pract_id+"' and a.facility_id='"+facilityId+"' and  a.primary_resource_yn='Y' and a.care_locn_type_ind='"+clinic_type+"' AND a.resource_class = 'P' and trunc(clinic_date,'dd') = trunc(sysdate,'dd') and to_char(sysdate ,'hh24:mi') between to_char(start_time,'hh24:mi') and to_char(end_time,'hh24:mi') order by strdate, enddate, short_desc " ;	
			
		rs = stmt.executeQuery(sql_location);
		if(rs!=null && rs.next()){				
					loc_code=rs.getString("locaton_code")==null?"":rs.getString("locaton_code");
			
		}
		if(rs!=null) rs.close();
		
		if(loc_code.equals("")){
		String sql_location_checkdate="select distinct(a.clinic_code) locaton_code, op_get_desc.op_clinic(facility_id, clinic_code, '"+locale+"','1') short_desc from oa_clinic_schedule a where a.practitioner_id='"+pract_id+"' and a.clinic_date >= trunc(sysdate) and a.facility_id='"+facilityId+"' and  a.primary_resource_yn='Y' and a.care_locn_type_ind='"+clinic_type+"' AND a.resource_class = 'P'  order by short_desc " ;	
						
		rs = stmt.executeQuery(sql_location_checkdate);
		if(rs!=null && rs.next()){			
			 		loc_code=rs.getString("locaton_code")==null?"":rs.getString("locaton_code");
			  
		   }
		}		
		if(rs!=null) rs.close();
		
		
		//End PMG2013-CRF-0016 [IN:044523]
		String sql  ="select distinct(a.clinic_code), op_get_desc.op_clinic(facility_id, clinic_code, '"+locale+"','1') short_desc from oa_clinic_schedule a where a.practitioner_id='"+pract_id+"' and a.facility_id='"+facilityId+"' and a.clinic_date >= trunc(sysdate) and a.primary_resource_yn='Y' and a.care_locn_type_ind='"+clinic_type+"' order by short_desc " ;

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);
		
            _bw.write(_wl_block95Bytes, _wl_block95);
	
		String short_desc="";
		String clinic_code="";
		
		while(rs!=null && rs.next() ){
			short_desc=rs.getString("short_desc");
			clinic_code=rs.getString("clinic_code");		
			/*Below line modified for this CRF PMG2013-CRF-0016 [IN:044523]*/
			
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(frameref));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(loc_code));
            _bw.write(_wl_block101Bytes, _wl_block101);
}
		
	}else if(steps.equals("validateTime")){
            _bw.write(_wl_block102Bytes, _wl_block102);

		
		Statement stTime=con.createStatement();
		ResultSet rsTime=stTime.executeQuery("select 1 from dual where to_char(sysdate,'HH24:MI')>='"+curTime+"' ");
		
		
		if (rsTime !=null &&rsTime.next()){
			
            _bw.write(_wl_block103Bytes, _wl_block103);

		}else{
            _bw.write(_wl_block104Bytes, _wl_block104);
}
		
		if (rsTime!=null) rsTime.close();
		if (stTime!=null) stTime.close();
	}else if(steps.equals("validatepref_date"))
	{
			
            _bw.write(_wl_block105Bytes, _wl_block105);

			int count=0;
if(rs3 !=null)rs3.close();
		StringBuffer sql_pref_val=new StringBuffer("");
			sql_pref_val.append("select (MAX_PATIENTS_PER_DAY- nvl(TOTAL_SLOTS_BOOKED,0)) cnt from oa_clinic_schedule where clinic_date=to_date('"+preferred_date+"','dd/mm/yyyy') and clinic_code='"+locncode+"'  and FACILITY_ID='"+facilityId+"'");
			if(practid.equals("")){
				sql_pref_val.append(" and practitioner_id is null");
			}else{
				sql_pref_val.append(" and practitioner_id ='"+practid+"'");
			}
		
		rs3=stmt3.executeQuery(sql_pref_val.toString());
		sql_pref_val.setLength(0);
		if(rs3 !=null && rs3.next())
		{
			count=rs3.getInt("cnt");
		}
		if(count >0)
		{
            _bw.write(_wl_block106Bytes, _wl_block106);

		}else
		{
            _bw.write(_wl_block107Bytes, _wl_block107);

		}
	}else if(steps.equals("validatepref_date_wait_list"))
	{
			
            _bw.write(_wl_block108Bytes, _wl_block108);

			int count=0;
			if(rs3 !=null)rs3.close();
			StringBuffer sql_pref_val=new StringBuffer("");
		sql_pref_val.append("select (MAX_PATIENTS_PER_DAY- nvl(TOTAL_SLOTS_BOOKED,0)) cnt from oa_clinic_schedule where clinic_date=to_date('"+preferred_date+"','dd/mm/yyyy') and clinic_code='"+locncode+"'  and FACILITY_ID='"+facilityId+"'");	
		if(practid.equals("")){
			sql_pref_val.append(" and practitioner_id is null");
		}else{
			sql_pref_val.append(" and practitioner_id ='"+practid+"'");
		}
		
		rs3=stmt3.executeQuery(sql_pref_val.toString());  
		sql_pref_val.setLength(0);
		if(rs3 !=null && rs3.next())
		{
			count=rs3.getInt("cnt");
		}
		if(count >0)
		{
            _bw.write(_wl_block109Bytes, _wl_block109);

		}else
		{
            _bw.write(_wl_block110Bytes, _wl_block110);

		}
	}else if(steps.equals("RESTRICT_WAIT_LIST"))
	{
		
            _bw.write(_wl_block111Bytes, _wl_block111);

		String spl_code=(String)hash.get("spl_code");
		String patient_id=(String)hash.get("patient_id");
		//String categ_code=(String)hash.get("categ_code");
		int cnt=0;
		String wait_list_status="";
		String sql2="select wait_list_status from pr_wait_list where PATIENT_ID='"+patient_id+"' and SPECIALTY_CODE='"+spl_code+"' ";
		rs3=stmt3.executeQuery(sql2);
			if(rs3 !=null )
			{
				while (rs3.next())
				{
				wait_list_status=rs3.getString("wait_list_status");
				}
			}
			if(rs3 !=null) rs3.close();
		if(wait_list_status.equals("V") )
		{
			
            _bw.write(_wl_block112Bytes, _wl_block112);

		}else if(wait_list_status.equals("C"))
		{
			
            _bw.write(_wl_block112Bytes, _wl_block112);

		}else if(wait_list_status.equals("I") || wait_list_status.equals("S") || wait_list_status.equals("O"))
		{
		String sql="select count(*) count from pr_wait_list where PATIENT_ID='"+patient_id+"' and SPECIALTY_CODE='"+spl_code+"' ";
			rs3=stmt3.executeQuery(sql);
			if(rs3 !=null && rs3.next())
			{
				cnt=rs3.getInt("count");
			}
		

		if(cnt >=1)
		{
            _bw.write(_wl_block113Bytes, _wl_block113);

		}else
		{
            _bw.write(_wl_block112Bytes, _wl_block112);

		}
		}
		
	}else if(steps.equals("RESTRICT_WAIT_LIST_ONE"))
	{
		
            _bw.write(_wl_block111Bytes, _wl_block111);

		String spl_code=(String)hash.get("spl_code");
		String patient_id=(String)hash.get("patient_id");
		String categ_code=(String)hash.get("categ_code");
		String waitlist_cat_one_code=(String)hash.get("waitlist_cat_one_code");
		int cnt=0;
		String sql="select count(*) count from pr_wait_list where PATIENT_ID='"+patient_id+"' and SPECIALTY_CODE='"+spl_code+"' and  WAITLIST_CATEGORY_CODE='"+categ_code+"'";
			rs3=stmt3.executeQuery(sql);
			if(rs3 !=null && rs3.next())
			{
				cnt=rs3.getInt("count");
			}
			if(cnt >0)
		{
            _bw.write(_wl_block114Bytes, _wl_block114);

		}else
		{
            _bw.write(_wl_block115Bytes, _wl_block115);

		}
		if(!waitlist_cat_one_code.equals(categ_code))
		{
		if(cnt >0)
		{
            _bw.write(_wl_block113Bytes, _wl_block113);

		}else
		{
            _bw.write(_wl_block112Bytes, _wl_block112);

		}
		}

	}else if(steps.equals("validatepref_date_sunday"))
	{
		
            _bw.write(_wl_block116Bytes, _wl_block116);

		CallableStatement statement2 =null;
		String date_val=(String)hash.get("date_val");
		String clinic_code=(String)hash.get("clinic_code");
		String facility_id=facilityId;
		if(clinic_code==null) clinic_code="";

		String date_type="D";

					statement2=con.prepareCall("{call GET_WORKING_DAY_WAIT_LIST(?,?,?,?,?,?,?)}");
					statement2.setString( 1,	date_val ) ;
					statement2.setString( 2,	date_val  ) ;
					statement2.setString( 3,	date_type  ) ;
					statement2.setString( 4,	clinic_code  ) ;
					statement2.setString( 5,	facility_id  ) ;
					statement2.registerOutParameter(6,	Types.VARCHAR ) ;
					statement2.registerOutParameter(7,	Types.VARCHAR ) ;
					statement2.execute() ;
					String out1= statement2.getString( 6);
					//String out2=statement2.getString( 5 );
		String wrk_or_holiday=out1.substring(1,2);
		if(wrk_or_holiday.equals("H"))
		{
            _bw.write(_wl_block117Bytes, _wl_block117);

		}else
		{
            _bw.write(_wl_block118Bytes, _wl_block118);

		}
	
	}else if(steps.equals("validatepref_date_sunday_invitation"))
	{
		
            _bw.write(_wl_block116Bytes, _wl_block116);

		CallableStatement statement2 =null;
		String date_val=(String)hash.get("date_val");
		String facility_id=facilityId;
		String wait_list_num=(String)hash.get("wait_list_num");
		String clinic_code="";

		String sql="select locn_code from pr_wait_list where wait_list_no='"+wait_list_num+"' and  FACILITY_ID='"+facilityId+"'";

		rs3=stmt3.executeQuery(sql);
			if(rs3 !=null && rs3.next())
			{
				clinic_code=rs3.getString("locn_code");
			}
	
		String date_type="D";
	
					statement2=con.prepareCall("{call GET_WORKING_DAY_WAIT_LIST(?,?,?,?,?,?,?)}");
					statement2.setString( 1,	date_val ) ;
					statement2.setString( 2,	date_val  ) ;
					statement2.setString( 3,	date_type  ) ;
					statement2.setString( 4,	clinic_code  ) ;
					statement2.setString( 5,	facility_id  ) ;
					statement2.registerOutParameter(6,	Types.VARCHAR ) ;
					statement2.registerOutParameter(7,	Types.VARCHAR ) ;
					statement2.execute() ;
					String out1= statement2.getString( 6);
					//String out2=statement2.getString( 5 );
		String wrk_or_holiday=out1.substring(1,2);
		if(wrk_or_holiday.equals("H"))
		{
            _bw.write(_wl_block117Bytes, _wl_block117);

		}else
		{
            _bw.write(_wl_block118Bytes, _wl_block118);

		}

	}else if(steps.equals("validatepref_date_oaholiday"))
	{
		
            _bw.write(_wl_block119Bytes, _wl_block119);

			String cnt="";
		String date_val=(String)hash.get("date_val");
		String cliniccode=(String)hash.get("cliniccode");
		if(cliniccode ==null) cliniccode="";
		String sql="";
		if(cliniccode.equals("") ||cliniccode=="")
		{
		 sql="Select count(*) count  from oa_holiday where facility_id='"+facilityId+"' AND HOLIDAY_DATE=TO_DATE('"+date_val+"','DD/MM/YYYY')";
		}else
		{
			sql="Select count(*) count  from oa_holiday where facility_id='"+facilityId+"' AND HOLIDAY_DATE=TO_DATE('"+date_val+"','DD/MM/YYYY') and locn_code='"+cliniccode+"'";
		}
		rs3=stmt3.executeQuery(sql);
			if(rs3 !=null && rs3.next())
			{
				cnt=rs3.getString("count");
			}
			if(cnt.equals("1"))
		{
            _bw.write(_wl_block120Bytes, _wl_block120);
}else{
            _bw.write(_wl_block121Bytes, _wl_block121);

		}

	}else if(steps.equals("clearAll"))
	{
		RecordSet	waitlistinvitation	=	null;
		waitlistinvitation	=	(webbeans.eCommon.RecordSet)session.getAttribute("waitlistinvitation");
		RecordSet	waitlistinvitation1	=	null;
		waitlistinvitation1	=	(webbeans.eCommon.RecordSet)session.getAttribute("waitlistinvitation1");
		RecordSet	waitlistinvitation2	=	null;
		waitlistinvitation2	=	(webbeans.eCommon.RecordSet)session.getAttribute("waitlistinvitation2");
		
		RecordSet	waitlistinvitation3	=	null;
		waitlistinvitation3	=	(webbeans.eCommon.RecordSet)session.getAttribute("waitlistinvitation3");
			
			out.println(waitlistinvitation.getObject(0).getClass()) ;


		((HashMap)waitlistinvitation.getObject(0)).clear();
		waitlistinvitation1.clearAll();
		waitlistinvitation2.clearAll();
		waitlistinvitation3.clearAll();

/*
		((HashMap)waitlistinvitation1.getObject(0)).clear();

		((HashMap)waitlistinvitation2.getObject(0)).clear();


		((HashMap)waitlistinvitation3.getObject(0)).clear();
*/
	}else if(steps.equals("holiday_val"))
	{
		StringBuffer sql  =new StringBuffer("");
		sql.append("Select care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a   where    LANGUAGE_ID = '"+locale+"' AND a.clinic_code not in (select locn_code from oa_holiday where facility_id='"+facilityId+"' ) and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and a.level_of_care_ind = 'A'   and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A'");
		
			if(clinic_type.equals("D")){
				sql.append(" and a.clinic_type='Y' ");
			}else{
				sql.append(" and a.clinic_type='"+clinic_type+"' ");
			}	
			
			sql.append(" and a.care_locn_type_ind='"+clinic_type+"'   order by a.long_desc");	

			
		rs = stmt.executeQuery(sql.toString());
		
		sql.setLength(0);
		
            _bw.write(_wl_block122Bytes, _wl_block122);

			String short_desc="";
		String clinic_code="";
		String care_locn_type_ind="";
		while(rs!=null && rs.next() ){
			care_locn_type_ind=rs.getString("care_locn_type_ind");
			short_desc=rs.getString("long_desc");
			clinic_code=rs.getString("clinic_code");
			clinic_type=rs.getString("clinic_type");
			
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(care_locn_type_ind));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
	}else if(steps.equals("holiday_val_date"))
	{
			StringBuffer sql  =new StringBuffer("");
		sql.append("Select a.care_locn_type_ind care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a WHERE a.clinic_code  IN (SELECT locn_code FROM oa_holiday where facility_id='"+facilityId+"')  and a.facility_id='"+facilityId+"'  and language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.ALLOW_APPT_YN='Y'   ");
		
	
			if(clinic_type.equals("D")){
				sql.append(" and a.clinic_type='Y' ");
			}else{
				sql.append(" and a.clinic_type='"+clinic_type+"' ");
			}	
			
			sql.append(" and a.care_locn_type_ind='"+clinic_type+"' order by a.long_desc");
			
		rs = stmt.executeQuery(sql.toString());
		sql.setLength(0);


			
            _bw.write(_wl_block123Bytes, _wl_block123);




		String short_desc="";
		String clinic_code="";
		//String clinic_type="";
		String care_locn_type_ind="";
		

		while(rs!=null && rs.next() ){

			care_locn_type_ind=rs.getString("care_locn_type_ind");
			short_desc=rs.getString("long_desc");
			clinic_code=rs.getString("clinic_code");
			clinic_type=rs.getString("clinic_type");

			
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(care_locn_type_ind));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block125Bytes, _wl_block125);

		}
		

	}else if(steps.equals("slot_slab")){	
		
            _bw.write(_wl_block126Bytes, _wl_block126);

		String time_table_type="";
		String res_type="";
		String practitioner="";
		String clinic_date=(String)hash.get("clinic_date");
		String clinic_type_val="";
		String clinic_code_val="";
		String final_val=(String)hash.get("final_val");
		StringTokenizer value_set=new StringTokenizer(final_val,"$");
		int d_counter=value_set.countTokens();
		for(int i=0;i<d_counter;i++){
			StringTokenizer value=new StringTokenizer(value_set.nextToken(),"|");
			while(value.hasMoreTokens()){
				clinic_type_val=value.nextToken();
				clinic_code_val=value.nextToken();
				res_type=value.nextToken();
				practitioner=value.nextToken();
				if(practitioner.equals("*")){ 
					practitioner="";
				}
				StringBuffer sql1=new StringBuffer();
				sql1.append("SELECT TIME_TABLE_TYPE FROM oa_clinic_schedule WHERE CLINIC_CODE='"+clinic_code_val+"' AND CLINIC_DATE=To_Date('"+clinic_date+"','dd/mm/yyyy') AND facility_id='"+facilityId+"' and care_locn_type_ind ='"+clinic_type_val+"' and resource_class='"+res_type+"' ");
				if(practitioner.equals("")){
						sql1.append(" AND practitioner_id is null ");
					}else{
						sql1.append(" AND practitioner_id='"+practitioner+"' ");
					}
					
				rs = stmt.executeQuery(sql1.toString());
				sql1.setLength(0);
				if(rs !=null && rs.next() ){
					time_table_type=rs.getString("TIME_TABLE_TYPE");
				}else{
					time_table_type="";
				}
				if(rs !=null) rs.close();
				if(time_table_type.equals("1") || time_table_type.equals("2") ){
					int cnt_val=0;
					// Changed for PE By Sudhakar	
					StringBuffer sql2=new StringBuffer();
					sql2.append("SELECT count(*) FROM OA_CLINIC_SCHEDULE_SLOT_SLAB WHERE CLINIC_CODE='"+clinic_code_val+"' AND CLINIC_DATE=To_Date('"+clinic_date+"','dd/mm/yyyy') AND facility_id='"+facilityId+"' and care_locn_type_ind ='"+clinic_type_val+"' and resource_class='"+res_type+"' ");
					if(practitioner.equals("")){
						sql2.append(" AND practitioner_id is null");
					}else{
						sql2.append(" AND practitioner_id='"+practitioner+"' ");
					}

					rs = stmt.executeQuery(sql2.toString());
					sql2.setLength(0);
					while(rs !=null && rs.next()){
						cnt_val=rs.getInt(1);
					}
					if(rs !=null) rs.close();
					if(cnt_val >0)
					{
            _bw.write(_wl_block127Bytes, _wl_block127);

					}else{
					
            _bw.write(_wl_block128Bytes, _wl_block128);

					}
				}
			}
		}
	}else if(steps.equals("validate_CA_referral"))
	{
		
            _bw.write(_wl_block126Bytes, _wl_block126);

		String ref_id=(String) hash.get("ref_id");
		String ca_patient_id=(String)	hash.get("ca_patient_id");
		String clinic_code=(String)	hash.get("clinic_code");
		String type=(String)	hash.get("type");
		if(clinic_code =="null" || clinic_code ==null)
			clinic_code = "";		
		String sql1="";
		String patient_id="";
		String to_locn_code="";
		if(rs !=null) rs.close();
		sql1="select patient_id, to_locn_code from PR_REFERRAL_REGISTER where REFERRAL_ID='"+ref_id+"' and to_facility_id = '"+facilityId+"' ";			
		rs = stmt.executeQuery(sql1);
		if(rs !=null && rs.next())
		{
			patient_id=rs.getString("patient_id");
			to_locn_code=rs.getString("to_locn_code");
		}	
			if(patient_id =="null" || patient_id ==null)	patient_id = "";
		if(to_locn_code =="null" || to_locn_code ==null) to_locn_code = "";
		if(type =="null" || type ==null) type = "";

		if(!ca_patient_id.equals("dummy_patinetID") && !ca_patient_id.equals("") ){
		 if(patient_id == "" || patient_id.equals("")) { 
            _bw.write(_wl_block129Bytes, _wl_block129);

		} else if(type.equals("nonmodel") && !to_locn_code.equals(clinic_code)){
            _bw.write(_wl_block130Bytes, _wl_block130);

		} else {
		if(patient_id.equals(ca_patient_id))
			{
			
            _bw.write(_wl_block131Bytes, _wl_block131);

			}else
			{
			
            _bw.write(_wl_block132Bytes, _wl_block132);

			}
		 }}
		
	}else if(steps.equals("Holiday_date"))
	{
		
            _bw.write(_wl_block126Bytes, _wl_block126);
	
		String strDate=(String) hash.get("strDate");
		String end_date=(String) hash.get("end_date");
		//String out_put="";
		int out_put=0;
		String sql_date="select months_between(to_date('"+end_date+"','dd/mm/yyyy'),to_date('"+strDate+"','dd/mm/yyyy')) from dual";
		rs = stmt.executeQuery(sql_date);

		if(rs !=null)
		{
			while(rs.next())
			{
			out_put=rs.getInt(1);
			}
		}
		if(out_put<1)
		{
            _bw.write(_wl_block133Bytes, _wl_block133);

		}else
		{
			
            _bw.write(_wl_block134Bytes, _wl_block134);

		}

	}else if(steps.equals("chk_unknown_patient"))
	{
	String allow_emer_regn_yn="";
	String pat_dtls_unknown_yn="";
	//String emeg_regn_yn="";
	String id_type="";
	
            _bw.write(_wl_block135Bytes, _wl_block135);

	String patient_id=(String) hash.get("patient_id");
	if(patient_id ==null) patient_id="";

	
	if (rs!=null) rs.close();
	
	String sql2  = "select a.pat_dtls_unknown_yn, a.emeg_regn_yn, b.id_type from mp_patient a, mp_pat_ser_grp b where a.patient_id  = '"+patient_id+"'and a.pat_ser_grp_code = b.pat_ser_grp_code";
		
	rs = stmt.executeQuery(sql2);
	if(rs !=null && rs.next())
	{
		pat_dtls_unknown_yn=rs.getString("PAT_DTLS_UNKNOWN_YN");
		id_type=rs.getString("id_type");
	}

	if(pat_dtls_unknown_yn.equals("Y"))
	{
            _bw.write(_wl_block136Bytes, _wl_block136);
}else
	{
            _bw.write(_wl_block137Bytes, _wl_block137);
}
	if(id_type.equals("E"))
	{	
		String sql  = "select ALLOW_EMER_REGN_YN from op_param where OPERATING_FACILITY_ID = '"+facilityId+"'";
		
		rs = stmt.executeQuery(sql);
		if(rs !=null && rs.next())
		{
			allow_emer_regn_yn=rs.getString("ALLOW_EMER_REGN_YN");
		}
	if(allow_emer_regn_yn.equals("N"))
	{
            _bw.write(_wl_block138Bytes, _wl_block138);
}else { 
            _bw.write(_wl_block139Bytes, _wl_block139);
}
	}
}else if(steps.equals("chk_sch_exists"))
{

            _bw.write(_wl_block140Bytes, _wl_block140);

	String location_type=(String) hash.get("location_type");
	String location_code=(String) hash.get("location_code");
	String resource_Type=(String) hash.get("resourceType");
	String practitioner=(String) hash.get("practitioner");
	String eff_from=(String) hash.get("eff_from");
	String eff_to=(String) hash.get("eff_to");
	String sql="";
	sql= "select '1' from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code='"+location_code+"' and clinic_date BETWEEN to_date('"+eff_from+"', 'dd/mm/yyyy') and to_date('"+eff_to+"', 'dd/mm/yyyy') and  nvl(practitioner_id,'X') =nvl('"+practitioner+"','X') and care_locn_type_ind='"+location_type+"'  and resource_class='"+resource_Type+"'";
rs = stmt.executeQuery(sql);
if(rs !=null && rs.next())
{

            _bw.write(_wl_block141Bytes, _wl_block141);

}else
{

            _bw.write(_wl_block142Bytes, _wl_block142);

}

}else if(steps.equals("blockSlot"))
{

			String inner_string = "";
			String next_string = "";
			String totm ="";
			String totm1 = "";
			String ftime2="";
			String ttime2="";
			int ftm1=0;
			int ttm1=0;
			int confirsttm=ftm1*60;
			int totim = 0;
			int totim1 =0;
			int frmtime1 =0;
			int mainfrmtm =0;
			int totime1 = 0;
			int maintotm = 0;
			int dur = 0;
			int dur1 = 0;
			int noslots =0;
			int durtime=0;
			int totaltm=0;


	StringTokenizer duration = new StringTokenizer(fromtime, ":");
	if(duration.hasMoreTokens())
	{
		 inner_string = duration.nextToken();
		 next_string = duration.nextToken();
		
		 dur = Integer.parseInt(inner_string);
		 dur1 = Integer.parseInt(next_string);
			
	
		StringTokenizer duration2 = new StringTokenizer(totime, ":");
		if(duration2.hasMoreTokens())
		{
			 totm = duration2.nextToken();
			 totm1 = duration2.nextToken();
			 totim = Integer.parseInt(totm);
			 totim1 = Integer.parseInt(totm1);

			 frmtime1 = dur*60;
			 mainfrmtm = frmtime1+dur1;
			 totime1 = totim*60;
			 maintotm = totime1+totim1;

			durtime = maintotm - mainfrmtm;
	
			StringTokenizer duration3 = new StringTokenizer(timeperpatient, ":");
			if(duration3.hasMoreTokens())
			{
				 ftime2=duration3.nextToken();
				 ttime2=duration3.nextToken();

				 ftm1=Integer.parseInt(ftime2);
				 ttm1=Integer.parseInt(ttime2);
				 confirsttm=ftm1*60;
				totaltm = confirsttm + ttm1;

				 noslots = durtime/totaltm;
			}	
		}
	}
	
	
		
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(noslots));
            _bw.write(_wl_block144Bytes, _wl_block144);

	
		
		
}else if(steps.equals("bulk_report"))
{

	String clinic_code=(String) hash.get("clinic_code");
	String from=(String) hash.get("from_part");
	String primary_resource_class="";
		String sql  = "select PRIMARY_RESOURCE_CLASS FROM op_clinic WHERE clinic_code='"+clinic_code+"' and facility_id='"+facilityId+"'";
		
		rs = stmt.executeQuery(sql);
		if(rs !=null && rs.next())
		{
			primary_resource_class=rs.getString("PRIMARY_RESOURCE_CLASS");
		}
		if(from.equals("Locnfrom")) {
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(primary_resource_class));
            _bw.write(_wl_block60Bytes, _wl_block60);
}else
	{
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(primary_resource_class));
            _bw.write(_wl_block147Bytes, _wl_block147);
}
}else if(steps.equals("web_req_noshow")){
	String patient_id     =(String) hash.get("patient_id");
	String preferedDate     =(String) hash.get("preferedDate");
	String speciality_web     =(String) hash.get("splty");
	//String min_ela_per_resc_noshow_in_day="";
	String old_appt_date="";
	String appt_no_show_end_date="";
	int cnt_val=0;
	/*String oa_param_sql="select MIN_ELA_PER_RESC_NOSHOW_IN_DAY from oa_param where module_id='OA'";
	if (rs1!=null) rs1.close();
	rs1=stmt.executeQuery(oa_param_sql);
	if(rs1!=null && rs1.next()){
		min_ela_per_resc_noshow_in_day=rs1.getString("min_ela_per_resc_noshow_in_day");
	}*/
//	String splty_no_show="select to_char(APPT_DATE,'dd/mm/yyyy') appt_date from (SELECT * FROM oa_appt WHERE facility_id='"+facilityId+"' and trunc(appt_date) <= trunc(sysdate)  AND (TO_DATE(TO_CHAR(appt_slab_to_time,'hh24:mi'),'hh24:mi'))<=(TO_DATE(TO_CHAR(sysdate,'hh24:mi'),'hh24:mi'))  speciality_code='"+speciality_web+"'  AND patient_id='"+patient_id+"' AND appt_status !='A' order by trunc(appt_date) desc,TO_CHAR(appt_slab_to_time,'hh24:mi') desc) where rownum  = 1";
	String splty_no_show="SELECT TO_CHAR(max(a.appt_date),'DD/MM/YYYY')appt_date, TO_CHAR(max(a.appt_date+b.MIN_ELA_PER_RESC_NOSHOW_IN_DAY),'DD/MM/YYYY') appt_no_show_end_date FROM oa_appt a, oa_param b WHERE  a.facility_id = '"+facilityId+"' and b.module_id='OA' AND a.appt_date < TRUNC (SYSDATE) AND a.SPECIALITY_CODE = '"+speciality_web+"' AND a.patient_id = '"+patient_id+"' AND a.appt_status != 'A'  AND TRUNC(SYSDATE)-a.APPT_DATE <= b.MIN_ELA_PER_RESC_NOSHOW_IN_DAY";
	if (rs1!=null) rs1.close();
	rs1=stmt.executeQuery(splty_no_show);
	if(rs1!=null && rs1.next()){
		old_appt_date=rs1.getString("appt_date")==null?"":rs1.getString("appt_date");
		appt_no_show_end_date=rs1.getString("appt_no_show_end_date")==null?"":rs1.getString("appt_no_show_end_date");
	}
	if(!old_appt_date.equals("")){
		/*String sql_two="SELECT To_Char(To_Date('"+old_appt_date+"','dd/mm/yyyy')+'"+min_ela_per_resc_noshow_in_day+"' , 'dd/mm/yyyy') appt_no_show_end_date  FROM dual";
		if (rs1!=null) rs1.close();
		rs1=stmt.executeQuery(sql_two);
		if(rs1!=null && rs1.next())
			appt_no_show_end_date=rs1.getString("appt_no_show_end_date");*/
		String sql_chk="SELECT count(*) count FROM dual WHERE To_Date('"+preferedDate+"','dd/mm/yyyy') >= To_Date('"+appt_no_show_end_date+"','dd/mm/yyyy')";
		if (rs1!=null) rs1.close();
		rs1=stmt.executeQuery(sql_chk);
		if(rs1!=null && rs1.next())
		cnt_val=rs1.getInt("count");
		if(cnt_val > 0){
            _bw.write(_wl_block148Bytes, _wl_block148);
}else{
            _bw.write(_wl_block149Bytes, _wl_block149);
}
	}
}else if(steps.equals("chk_noshow_appt")){
	String patient_id     =(String) hash.get("patient_id");
	String clinic_code     =(String) hash.get("clinic_code");
	String appt_to_date     =(String) hash.get("appt_to_date");
	String min_ela_per_resc_noshow_in_day     =(String) hash.get("min_ela_per_resc_noshow_in_day");
	String noshow_ctrl_by_splty_or_clinic     =(String) hash.get("noshow_ctrl_by_splty_or_clinic");
	String p_speciality_code     =(String) hash.get("p_speciality_code");
	String appt_date="";
	String appt_no_show_end_date="";
	int cnt_val=0;

            _bw.write(_wl_block150Bytes, _wl_block150);

	if(min_ela_per_resc_noshow_in_day!=null && !min_ela_per_resc_noshow_in_day.equals("")){
		if(noshow_ctrl_by_splty_or_clinic.equals("L")){
			String str="select to_char(APPT_DATE,'dd/mm/yyyy') appt_date from (SELECT * FROM oa_appt WHERE facility_id='"+facilityId+"' and appt_date <= trunc(sysdate)  AND (TO_DATE(TO_CHAR(appt_slab_to_time,'hh24:mi'),'hh24:mi'))<=(TO_DATE(TO_CHAR(sysdate,'hh24:mi'),'hh24:mi')) AND clinic_code='"+clinic_code+"'  AND patient_id='"+patient_id+"' AND appt_status !='A' order by appt_date desc,TO_CHAR(appt_slab_to_time,'hh24:mi') desc) where rownum  = 1";
			rs = stmt.executeQuery(str);
		}else{
			String str="select to_char(APPT_DATE,'dd/mm/yyyy') appt_date from (SELECT * FROM oa_appt WHERE facility_id='"+facilityId+"' and appt_date <= trunc(sysdate)  AND (TO_DATE(TO_CHAR(appt_slab_to_time,'hh24:mi'),'hh24:mi'))<=(TO_DATE(TO_CHAR(sysdate,'hh24:mi'),'hh24:mi')) AND clinic_code in (SELECT clinic_code  FROM op_clinic WHERE speciality_code='"+p_speciality_code+"')  AND patient_id='"+patient_id+"' AND appt_status !='A' order by appt_date desc,TO_CHAR(appt_slab_to_time,'hh24:mi') desc) where rownum  = 1";
			rs = stmt.executeQuery(str);
		}
		if(rs!=null && rs.next()){
			appt_date=rs.getString("appt_date");
			if(appt_date ==null) appt_date="";
			if(!appt_date.equals("null")||!appt_date.equals("")){
				String sql_two="SELECT To_Char(To_Date('"+appt_date+"','dd/mm/yyyy')+'"+min_ela_per_resc_noshow_in_day+"' , 'dd/mm/yyyy') appt_no_show_end_date  FROM dual";
				rs1 = stmt1.executeQuery(sql_two);
				if(rs1!=null && rs1.next()){
					appt_no_show_end_date=rs1.getString("appt_no_show_end_date");
				}
				if(appt_no_show_end_date==null)appt_no_show_end_date="";
				if(rs1 !=null) rs1.close();
				String sql_chk="SELECT count(*) count FROM dual WHERE To_Date('"+appt_to_date+"','dd/mm/yyyy') >= To_Date('"+appt_no_show_end_date+"','dd/mm/yyyy')";
				rs1 = stmt1.executeQuery(sql_chk);
				if(rs1!=null && rs1.next()){
					cnt_val=rs1.getInt("count");
				}
			}
			if(cnt_val>0){
            _bw.write(_wl_block151Bytes, _wl_block151);
}else{
				if(min_ela_per_resc_noshow_in_day!=null && !min_ela_per_resc_noshow_in_day.equals("")){
            _bw.write(_wl_block152Bytes, _wl_block152);
}
			}
		}else{
            _bw.write(_wl_block153Bytes, _wl_block153);
}
	}
}else if(steps.equals("No_Show_appt")){
		int cnt_val=0;
		String patient_id=(String)hash.get("patient_id");

            _bw.write(_wl_block154Bytes, _wl_block154);

	
String sql="SELECT COUNT(*) count FROM OA_APPT WHERE FACILITY_ID='"+facilityId+"' AND APPT_STATUS='1' AND PATIENT_ID='"+patient_id+"' AND to_date(to_char(APPT_DATE,'dd/mm/yyyy') || ' ' || to_char(APPT_TIME,'HH24:mi'),'dd/mm/yyyy HH24:mi') < sysdate AND APPT_DATE BETWEEN TRUNC(SYSDATE-(SELECT NVL(PER_CHK_FOR_NO_SHOW_ALERT,0) FROM OA_PARAM WHERE MODULE_ID='OA')) AND TRUNC(SYSDATE) having count(*) >= (SELECT NVL(NO_OF_NOSHOW_APPTS_FOR_ALERT,0) FROM OA_PARAM WHERE MODULE_ID='OA') ";
	
	rs1 = stmt1.executeQuery(sql);
		if(rs1!=null && rs1.next()){
			cnt_val=rs1.getInt("count");
			}
if(cnt_val >0)
{

            _bw.write(_wl_block141Bytes, _wl_block141);

}else
{

            _bw.write(_wl_block142Bytes, _wl_block142);

}
}else if(steps.equals("emailvalidation")){
	String patient_id=(String)hash.get("patient_id");
	String emailsql="select  b.EMAIL_APPL_YN PAT_EMAIL_APPL_YN from mp_patient a, mp_pat_ser_grp b where  a.patient_id='"+patient_id+"' and a.pat_ser_grp_code=b.pat_ser_grp_code";
	rs1 = stmt1.executeQuery(emailsql);
	String pat_email_appl_yn="";
	if(rs1!=null && rs1.next())
		pat_email_appl_yn=rs1.getString("pat_email_appl_yn");
	if(pat_email_appl_yn==null || pat_email_appl_yn.equals(""))
		pat_email_appl_yn="N";
	out.write(pat_email_appl_yn);
}else if(steps.equals("stat_grp_dft")){
	String countryCode=(String)hash.get("countryCode");
	String clinic_code=(String)hash.get("clinic_code");
	String clinic_date=(String)hash.get("clinic_date");
	String practitioner_id=(String)hash.get("practitioner_id");
	String grpSql="SELECT A.STAT_GRP_DESC, B.STAT_GRP_ID, B.MEMBER_ID, D.ALCN_CATG_CODE FROM AM_STAT_GROUP A,AM_STAT_GRP_DETAIL B,AM_STAT_GRP_FOR_PROGRAM C,OA_CLINIC_SCHEDULE_DTL D WHERE A.STAT_GRP_CAT = 'N' AND A.STAT_GRP_ID = B.STAT_GRP_ID AND A.STAT_GRP_ID = C.STAT_GRP_ID AND C.PROGRAM_ID = 'TIME_TABLE' AND B.MEMBER_ID = '"+countryCode+"' AND D.FACILITY_ID = '"+facilityId+"' AND D.CLINIC_DATE = TO_DATE('"+clinic_date+"','DD/MM/YYYY') AND D.CLINIC_CODE = '"+clinic_code+"' AND D.ALCN_CRITERIA = 'NG' AND B.STAT_GRP_ID = D.ALCN_CATG_CODE AND D.PRACTITIONER_ID = '"+practitioner_id+"'";
	String alcn_grp_code="";
	String alcn_grp_desc="";
	con = ConnectionManager.getConnection(request);
	stmt1 = con.createStatement();
	rs1 = stmt1.executeQuery(grpSql);
	if(rs1!=null && rs1.next()){
		alcn_grp_code=rs1.getString("ALCN_CATG_CODE");
		alcn_grp_desc=rs1.getString("STAT_GRP_DESC");
	}else{
		alcn_grp_code="*0";
		alcn_grp_desc="Others";
	}

            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(alcn_grp_code));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(alcn_grp_desc));
            _bw.write(_wl_block157Bytes, _wl_block157);
}else if(steps.equals("ALCN_VALIDATION")){
	String countryCode=(String)hash.get("countrycode");
	String clinic_code=(String)hash.get("clinic_code");
	String clinic_date=(String)hash.get("clinic_date");
	String practitioner_id=(String)hash.get("practitioner_id");
	//String slot_appt_ctrl=(String)hash.get("slot_appt_ctrl");
	String alcn_criteria=(String)hash.get("alcn_criteria");
	String statGrpCode="";
	boolean boolanFlag=false;
	String catgrpSQL="select stat_grp_desc,stat_grp_id from am_stat_group where stat_grp_id in(select stat_grp_id from AM_STAT_GRP_DETAIL where MEMBER_ID='"+countryCode+"')";
	if(rs1!=null)rs1.close();
	rs1 = stmt1.executeQuery(catgrpSQL);
	if(rs1!=null && rs1.next()){
		statGrpCode=rs1.getString("stat_grp_id")==null?"":rs1.getString("stat_grp_id");
	}
	String checkcatSQL="";
	if(practitioner_id==null || practitioner_id.equals("")){
		checkcatSQL="select * from oa_clinic_schedule_dtl where facility_id='"+facilityId+"' and ALCN_CRITERIA='"+alcn_criteria+"' and clinic_code='"+clinic_code+"' and practitioner_id is null and CLINIC_DATE=to_date('"+clinic_date+"','dd/mm/yyyy') and ALCN_CATG_CODE='"+statGrpCode+"' and (MAX_PATIENTS-TOTAL_BOOKED_PATIENTS)>0";
	}else{
		checkcatSQL="select * from oa_clinic_schedule_dtl where facility_id='"+facilityId+"' and ALCN_CRITERIA='"+alcn_criteria+"' and clinic_code='"+clinic_code+"' and practitioner_id='"+practitioner_id+"' and CLINIC_DATE=to_date('"+clinic_date+"','dd/mm/yyyy') and ALCN_CATG_CODE='"+statGrpCode+"' and (MAX_PATIENTS-TOTAL_BOOKED_PATIENTS)>0";
	}
	if(rs1!=null)rs1.close();
	rs1 = stmt1.executeQuery(checkcatSQL);
	if(rs1!=null && rs1.next()){
		boolanFlag=true;
	}else{
		boolanFlag=false;
	}
if(boolanFlag){
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(statGrpCode));
            _bw.write(_wl_block159Bytes, _wl_block159);
}else{
            _bw.write(_wl_block160Bytes, _wl_block160);
}
}else if(steps.equals("HolidayExistClinics") || steps.equals("HolidayNewClinics")){
	String locn_type=(String)hash.get("locn_type");
	String locn_type_sch=(String)hash.get("locn_type");
	String holiday_from=(String)hash.get("holiday_from");
	String holiday_end=(String)hash.get("holiday_end");
	StringBuffer sb1=new StringBuffer();
	String clinic_code="";
	String holiday_date="";
	int sch_cnt = 0;
	boolean sch_flag=true;
	String sch_sql = "select count(1) cnt from oa_clinic_schedule where facility_id = ? and clinic_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and clinic_code =?";
	if(locn_type.equals("D")){
		locn_type="Y";
	}
	if(steps.equals("HolidayExistClinics")){
		sb1.append("select a.clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_date from op_clinic_lang_vw a ,(select to_date('"+holiday_from+"','dd/mm/yyyy')+rownum-1  holiday_date from sm_function where rownum <=to_date('"+holiday_end+"','dd/mm/yyyy')-to_date('"+holiday_from+"','dd/mm/yyyy')+1) b where  a.language_id='"+locale+"' and  a.facility_id='"+facilityId+"'  and a.ALLOW_APPT_YN='Y'and a.level_of_care_ind = 'A' and exists(select 1 from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code) AND a.clinic_type = '"+locn_type+"' order by 3,2");
	}else if(steps.equals("HolidayNewClinics")){
		sb1.append("select a.clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_date from op_clinic_lang_vw a ,(select to_date('"+holiday_from+"','dd/mm/yyyy')+rownum-1  holiday_date from sm_function where rownum <=to_date('"+holiday_end+"','dd/mm/yyyy')-to_date('"+holiday_from+"','dd/mm/yyyy')+1) b where  a.language_id='"+locale+"' and  a.facility_id='"+facilityId+"'  and a.ALLOW_APPT_YN='Y'and a.level_of_care_ind = 'A' and not exists(select 1 from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code) AND a.clinic_type = '"+locn_type+"' order by 3,2");
	}
	if(rs!=null)rs.close();
	if(prs!=null)prs.close();
	if(pstmt!=null)pstmt.close();
	rs = stmt.executeQuery(sb1.toString());
	sb1.setLength(0);
	while(rs!=null && rs.next()){
		clinic_code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
		holiday_date=rs.getString("holiday_date")==null?"":rs.getString("holiday_date");
		pstmt=con.prepareStatement(sch_sql);
		pstmt.setString( 1, facilityId ) ;
		pstmt.setString( 2, holiday_date ) ;
		pstmt.setString( 3, locn_type_sch ) ;
		pstmt.setString( 4, clinic_code ) ;
		prs=pstmt.executeQuery();
		if (prs!=null && prs.next()){
			sch_cnt=prs.getInt("cnt");
		}
		if(prs!=null)prs.close();
		if(sch_cnt > 0){
			sch_flag=false;
			break;
		}
		if(pstmt!=null)pstmt.close();

	}
	if(!sch_flag){
            _bw.write(_wl_block161Bytes, _wl_block161);
}else{
            _bw.write(_wl_block162Bytes, _wl_block162);
}
}else if(steps.equals("overbook_validation")){
	String clinic_code=(String)hash.get("clinic_code");
	String appt_date=(String)hash.get("appt_date");
	String practitioner_id=(String)hash.get("practitioner_id");
	String appt_ref_no=(String)hash.get("appt_ref_no");
	//String time_table_type_from=(String)hash.get("time_table_type_from");
	boolean overbookFlag=true;
	String visit_type_ind="";
	int total_first_visits=0;
	int total_other_visits=0;
	int max_first_visits=0;
	int max_other_visits=0;
	String visit_limit_rule="";
	int max_slots_per_day=0;
	int max_patients_per_day=0;
	String time_table_type_to="";
	String apptSQL="select b.visit_type_ind from oa_appt a,op_visit_type b where a.facility_id=? and a.appt_ref_no=? and a.facility_id=b.facility_id and a.appt_type_code=b.visit_type_code";
	String scheduleSQL="";
	if(practitioner_id==null || practitioner_id.equals("")){
		scheduleSQL="select nvl(TOTAL_FIRST_VISIT,0)+nvl(TOTAL_FIRST_VISITS_BLOCKED,0) total_first_visits,nvl(TOTAL_FOLLOW_UP,0)+nvl(TOTAL_ROUTINE,0)+nvl(TOTAL_SERIES,0)+nvl(TOTAL_SERIES,0)+nvl(TOTAL_CONSULT,0)+nvl(TOTAL_EMERGENCY,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0) total_other_visits,max_first_visits,max_other_visits,visit_limit_rule,MAX_SLOTS_PER_DAY,TIME_TABLE_TYPE,MAX_PATIENTS_PER_DAY from oa_clinic_schedule where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id is null";
	}else{
		scheduleSQL="select nvl(TOTAL_FIRST_VISIT,0)+nvl(TOTAL_FIRST_VISITS_BLOCKED,0) total_first_visits,nvl(TOTAL_FOLLOW_UP,0)+nvl(TOTAL_ROUTINE,0)+nvl(TOTAL_SERIES,0)+nvl(TOTAL_SERIES,0)+nvl(TOTAL_CONSULT,0)+nvl(TOTAL_EMERGENCY,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0) total_other_visits,max_first_visits,max_other_visits,visit_limit_rule,MAX_SLOTS_PER_DAY,TIME_TABLE_TYPE,MAX_PATIENTS_PER_DAY from oa_clinic_schedule where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id=?";

	}
	
	if(rs!=null)rs.close();
	if(prs!=null)prs.close();
	if(pstmt!=null)pstmt.close();
	pstmt=con.prepareStatement(apptSQL);
	pstmt.setString( 1, facilityId ) ;
	pstmt.setString( 2, appt_ref_no ) ;
	prs=pstmt.executeQuery();
	if (prs!=null && prs.next()){
		visit_type_ind=prs.getString("visit_type_ind");
	}
	if(prs!=null)prs.close();
	if(pstmt!=null)pstmt.close();
	pstmt=con.prepareStatement(scheduleSQL);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,clinic_code);
	pstmt.setString(3,appt_date);
	if(practitioner_id!=null && !(practitioner_id.equals(""))){
		pstmt.setString(4,practitioner_id);
	}
	rs=pstmt.executeQuery();
	if(rs!=null && rs.next()){
		total_first_visits=Integer.parseInt(rs.getString("total_first_visits")==null?"0":rs.getString("total_first_visits"));
		total_other_visits=Integer.parseInt(rs.getString("total_other_visits")==null?"0":rs.getString("total_other_visits"));
		max_first_visits=Integer.parseInt(rs.getString("max_first_visits")==null?"0":rs.getString("max_first_visits"));
		max_other_visits=Integer.parseInt(rs.getString("max_other_visits")==null?"0":rs.getString("max_other_visits"));
		max_slots_per_day=Integer.parseInt(rs.getString("MAX_SLOTS_PER_DAY")==null?"0":rs.getString("MAX_SLOTS_PER_DAY"));
		max_patients_per_day=Integer.parseInt(rs.getString("MAX_PATIENTS_PER_DAY")==null?"0":rs.getString("MAX_PATIENTS_PER_DAY"));
		visit_limit_rule=rs.getString("visit_limit_rule");
		time_table_type_to=rs.getString("TIME_TABLE_TYPE");
	}
	if(pstmt!=null)pstmt.close();
	//@UAT-3 commented starts
	/*if(visit_type_ind.equals("F")){
		if(total_first_visits < max_first_visits){
			overbookFlag=true;
		}else{
			overbookFlag=false;
		}
	}else{
		if(total_other_visits < max_other_visits){
			overbookFlag=true;
		}else{
			overbookFlag=false;
		}
	}
	if(visit_limit_rule.equals("N")){
		if((total_first_visits +  total_other_visits) < max_slots_per_day)
			overbookFlag=true;
		else
			overbookFlag=false;
	}
	if(time_table_type_to.equals("3")){
		if((total_first_visits +  total_other_visits) < max_patients_per_day){
			overbookFlag=true;
		}else{
			overbookFlag=false;
		}
	}*/
	//@UAT-3 commented Ends
	if(visit_limit_rule.equals("N") || time_table_type_to.equals("3")){//@UAT-3 Starts
		if((total_first_visits + total_other_visits) < max_patients_per_day)
			overbookFlag=true;
		else
			overbookFlag=false;
	}else{
		if(visit_type_ind.equals("F")){
			if(total_first_visits < max_first_visits){
				overbookFlag=true;
			}else{
				overbookFlag=false;
			}
		}else{
			if(total_other_visits < max_other_visits){
				overbookFlag=true;
			}else{
				overbookFlag=false;
			}
		}
	}//@UAT-3 Ends
	if(overbookFlag){
		out.print("0");
	}else{
		if(time_table_type_to.equals("3")){
			out.print("3");
		}else if(visit_type_ind.equals("F")){
			out.print("1");
		}else{
			out.print("2");
		}
	}
}else if(steps.equals("inst_add_session")){

	String recCountStr=(String)hash.get("recCount");
	String prcInschecked=(String)hash.get("prcInschecked");
	String prcIns=(String)hash.get("prcIns");//modified by  munisekhar for [IN:044600]
	if(!(prcIns==null || prcIns.equals(""))){//modified by  munisekhar for [IN:044600]
    prcIns=java.net.URLDecoder.decode(prcIns,"UTF-8");} //modified by  munisekhar for [IN:044555]
	String patient_id=(String)hash.get("patient_id");
	if(prcInschecked==null)prcInschecked="N";
	if(prcIns==null)prcIns="";
	if(patient_id==null)patient_id="";
	int recCountValue=Integer.parseInt(recCountStr);
	
	HashMap patInstructionsMap=(java.util.HashMap)session.getAttribute("patInstructionsMap");
	HashMap prcInstructionMap=(java.util.HashMap)session.getAttribute("prcInstructionMap");
	for(int i=1;i<recCountValue;i++){
		String id="id"+i;
		String intString=(String)hash.get(id);
		String instId="";
		String instorder="";	
	   /*Below Line Added by Senthil on 31-Oct-2011*/
	   intString=java.net.URLDecoder.decode(intString,"UTF-8");	
		instId="";			
		String instDesc="";
		instorder="";					
		String checkYN="";
		if(intString !=null){
			String[] tokens=intString.split("\\|~");
			instId=tokens[0];
			instDesc=tokens[1];
			instorder=tokens[2];
			checkYN=tokens[3];
		}
		String insValue=instId+"|~"+instDesc+"|~"+checkYN;			
		patInstructionsMap.put(instorder,insValue);	
				
	}
	//patInstructionsMap.put("selectedYN","Y");
	//prcInstructionMap.put("patient_id",patient_id);
	prcInstructionMap.put("checked",prcInschecked);
	prcInstructionMap.put("prcIns",prcIns);
	//prcInstructionMap.put("selectedYN","Y");
	session.setAttribute("patInstructionsMap", patInstructionsMap);
	session.setAttribute("prcInstructionMap", prcInstructionMap);
	out.println("2");
}else if(steps.equals("free_formate_check")){
	//int flag=0;
	String strval="";	

	//CallableStatement statement =null;
	PreparedStatement ps=null ;
	ResultSet result=null;
    String clinic_code=(String)hash.get("clinic_code");
	String clinic_date=(String)hash.get("clinic_date");
	pract_id=(String)hash.get("pract_id");
	String from_time=(String)hash.get("from_time");
	String to_time=(String)hash.get("to_time");
	String facilityid=(String)hash.get("facilityid");
	String appt_ref_no=(String)hash.get("appt_ref_no");
	String patientid=(String)hash.get("patientid");
	String clinictype=(String)hash.get("clinic_type");

//String str="select OA_FREE_FORMAT_TIME_VALIDATION('"+facilityid+"','"+clinic_code+"','"+clinic_date+"','"+pract_id+"','"+from_time+"','"+to_time+"') from dual";


ps = con.prepareStatement("select OA_FREE_FORMAT_TIME_VALIDATION('"+facilityid+"','"+clinic_code+"','"+clinic_date+"','"+pract_id+"','"+from_time+"','"+to_time+"','"+appt_ref_no+"') from dual");

if(result!=null) result.close();
	 result= ps.executeQuery();
 while(result.next()){
	 strval=result.getString(1)==null?"Y":result.getString(1);
} 
if(strval.equals("TO_TIME_OVLP_BRK_TIME")){
	strval="1";
}
if(strval.equals("FM_TIME_OVLP_BRK_TIME")){
	strval="2";
}
if(strval.equals("FM_TIME_OVLP_APPT_TIME")){
	strval="3";
}
if(strval.equals("TO_TIME_OVLP_APPT_TIME")){
	strval="4";
}
if(strval.equals("TIME_RANGE_OVLP_APPT_TIME")){
	strval="5";
}
if(strval.equals("TIME_RANGE_OVLP_BRK_TIME")){
	strval="6";
}
if(strval.equals("FM_TIME_OVLP_CLINIC_START_TIME")){
	strval="7";
}
if(strval.equals("FM_TIME_OVLP_CLINIC_END_TIME")){
	strval="8";
}
if(strval.equals("TO_TIME_OVLP_CLINIC_START_TIME")){
	strval="9";
}
if(strval.equals("TO_TIME_OVLP_CLINIC_END_TIME")){
	strval="10";
}
if(strval.equals("SUCCESS")){
	strval="0";
}
if(strval.equals("0")){
	String chk_overlap1= "select '1'  from oa_appt where ((to_date('"+from_time+"','HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date('"+to_time+"','HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date('"+from_time+"','hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date('"+to_time+"','hh24:miss'))) and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patientid+"' and CARE_LOCN_TYPE_IND='"+clinictype+"'" ;
			rs = stmt.executeQuery(chk_overlap1) ;			
			if(rs !=null){
				if(rs.next())
				{					
					strval="11";
				}
				else
				{
				strval="0";
				}
		  }		 
}
if(ps != null) ps.close();
out.print(strval);
}else if(steps.equals("trans_confg_check")){

            _bw.write(_wl_block163Bytes, _wl_block163);

	String language_id=(String)hash.get("language_id");
	String appt_date=(String)hash.get("appt_date");
	String langTransSql ="select no_of_translator*multiply_factor total_translators,(select count(appt_ref_no) from oa_appt where  facility_id=? and appt_date = to_date(?,'dd/mm/yyyy') and language_id =?)sch_translators  from oa_translator_configuration where facility_id=? and language_id =? and to_date (?,'dd/mm/yyyy') between eff_date_from and eff_date_to and eff_status='E'";
	if(rs!=null)rs.close();
	pstmt=con.prepareStatement(langTransSql);
	pstmt.setString(1,facilityId);						
	pstmt.setString(2,appt_date);
	pstmt.setString(3,language_id);
	pstmt.setString(4,facilityId);
	pstmt.setString(5,language_id);
	pstmt.setString(6,appt_date);
	rs = pstmt.executeQuery();
	int total_translators = 0;
	int sch_translators = 0;
	if(rs!=null && rs.next()){
		total_translators	= Integer.parseInt(rs.getString("total_translators"));
		sch_translators		= Integer.parseInt(rs.getString("sch_translators"));
		if(total_translators > sch_translators){
            _bw.write(_wl_block164Bytes, _wl_block164);
}else{
            _bw.write(_wl_block165Bytes, _wl_block165);
}
	}
}else if(steps.equals("spltyWaitListCheck")){
	String waitListCheckSQL="select SPECIALITY_DESC from pr_wait_list_vw where SPECIALTY_CODE='"+speciality_code+"' and facility_id='"+facilityId+"' and WAIT_LIST_STATUS='O' and CARE_LOCN_TYPE_IND !='N' and (trunc(PREFERRED_DATE_TIME)>=trunc(sysdate) or PREFERRED_DATE_TIME is null)";
	System.err.println(waitListCheckSQL);
	if(rs!=null)rs.close();
	pstmt=con.prepareStatement(waitListCheckSQL);
	rs = pstmt.executeQuery();
	String specialty_desc ="";
	if(rs!=null && rs.next()){
		specialty_desc=rs.getString("SPECIALITY_DESC");
	
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(specialty_desc));
            _bw.write(_wl_block167Bytes, _wl_block167);
}else{
            _bw.write(_wl_block168Bytes, _wl_block168);
}
}else if(steps.equals("CHK_PAT_CNCL")){ //changes for CRF - Bru-HIMS-CRF 169 start

            _bw.write(_wl_block169Bytes, _wl_block169);

	String chkPatCnclSql="select APPT_CANCELLED_COUNT from oa_pat_cncl_appt_summary a,oa_param b where patient_id='"+pat_id1+"' and facility_id='"+facilityId+"' and a.APPT_CANCELLED_COUNT >= b.MAX_CANCEL_APPT";
	String patcncl="0";
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	pstmt=con.prepareStatement(chkPatCnclSql);
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		patcncl=rs.getString(1);
	}
	if(patcncl != null && !(patcncl.equals(""))){
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(patcncl));
            _bw.write(_wl_block171Bytes, _wl_block171);
	
	}
}//changes for CRF - Bru-HIMS-CRF 169 end
else if(steps.equals("checkMultiSpec")){ //changes for CRF - Bru-HIMS-CRF 198 start
	String chkMultiSpecSql="select multi_speciality_yn from am_speciality_lang_vw where eff_status = 'E'  and speciality_code = '"+speciality_code+"' and language_id='"+locale+"'";
	pstmt=con.prepareStatement(chkMultiSpecSql);
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		multi_speciality_yn=rs.getString("multi_speciality_yn");
	}	out.println(multi_speciality_yn);
}
else if(steps.equals("get_popup_alert")){ //added by mujafar for GHL-CRF-0527
	String locncode1 = (String) hash.get("locncode1");
	String locn_type1=(String) hash.get("locn_type1");
	String facilityid=(String) hash.get("facilityid");
	if (locncode1==null)		locncode1="";
	if (locn_type1==null)		locn_type1="";
	String getMsgsql=" select ALERT_REQ_BOOK_APPT_YN,POPUP_DESC_BOOK_APPT from op_clinic where clinic_code='"+locncode1+"' and CLINIC_TYPE='"+locn_type1+"' and facility_id='"+facilityid+"'  ";
	pstmt=con.prepareStatement(getMsgsql);
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		alert_req_book_appt_yn=rs.getString("ALERT_REQ_BOOK_APPT_YN");
		popup_desc_book_appt=rs.getString("POPUP_DESC_BOOK_APPT");
	}	
	out.println(alert_req_book_appt_yn+"~~"+popup_desc_book_appt);
}

	if(rs !=null) rs.close();
	if(rs1 !=null) rs1.close();
	if(rs3 !=null) rs3.close();
	if(rset2 !=null)rset2.close();
	if (rset12!=null) rset12.close();
	if (rset_sec_value!=null) rset_sec_value.close();
	if (rposchk!=null) rposchk.close();
	if(rsw!=null) rsw.close();
	if(prs1 !=null)prs1.close();
	if(rsloc !=null)rsloc.close();
	if(prs !=null) prs.close();
	if(rs_cat !=null)rs_cat.close();
	if(rs_wtlt !=null)rs_wtlt.close();
	if(pstmt!=null)pstmt.close();
	if(pstmtw!=null) pstmtw.close();
	if(pstmt1 !=null) pstmt1.close();
	if(stmt3 !=null)stmt3.close();
	if (sposchk!=null) sposchk.close();
	if(stmt !=null) stmt.close();
	if(stmt1 !=null) stmt1.close();
	if(stmtas !=null) stmtas.close();
	if(stmt_wtlt !=null)stmt_wtlt.close();
	if (stsql2!=null) stsql2.close();
	if (stsql1!=null) stsql1.close();
	if(stmt_cat !=null)stmt_cat.close();
	if(pstmt2 !=null)pstmt2.close();
	hash.clear();

}catch( Exception e ){
	System.out.println("Exception Steps :"+e);
	e.printStackTrace();

}finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block172Bytes, _wl_block172);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
