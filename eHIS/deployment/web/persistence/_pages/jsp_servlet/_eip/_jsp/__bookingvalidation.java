package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class __bookingvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BookingValidation.jsp", 1732267983306L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body CLASS=\"MESSAGE\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"BooingValidation_form\" id=\"BooingValidation_form\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar obj =parent.frames[1].document.forms[0].service;//_desc;\n\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t{\n\t\t\t\t\t\tobj.remove(1);\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar obj =parent.frames[1].document.forms[0].service_desc;\n\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t{\n\t\t\t\t\t\tobj.remove(1);\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\t\n\t\t\t\t\tvar opt= parent.frames[1].document.createElement(\'Option\');\n\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"; \n\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t/*Modified by Dharma on jan 16 2014 for RUT-SCF-0352 [IN:046525]  Start*/\n\t\t\t\t\n\t\t\t\t\t/*if(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" == \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\") \n\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t*/\n\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\") \n\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t/*Modified by Dharma on jan 16 2014 for RUT-SCF-0352 [IN:046525]  End*/\n\t\t\t\t\tobj.add(opt);\n\t\t\t\t\tparent.frames[1].document.createElement(\'Option\');\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar bedclass_obj = \'\';\n\t\t\t\t\tif(parent.frames[1].document.forms[0].Bedcode!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tbedclass_obj =parent.frames[1].document.forms[0].Bedcode;\n\t\t\t\t\t\tvar length  = bedclass_obj.length;\n\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tbedclass_obj.remove(1);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar bedclass_obj = \'\';\n\t\t\t\t\tif(parent.frames[1].document.forms[0].bed_class_desc!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tbedclass_obj =parent.frames[1].document.forms[0].bed_class_desc;\n\t\t\t\t\t\tvar length  = bedclass_obj.length;\n\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tbedclass_obj.remove(1);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<script>\t\n\t\t\t\t\t\t\t\tvar opt= parent.frames[1].document.createElement(\'Option\');\n\t\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"; \n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\t\t\t\tbedclass_obj.add(opt);\n\t\t\t\t\t\t\t\tparent.frames[1].document.createElement(\'Option\');\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\n\t\t\t\t<script>\n\t\t\t\tvar bedtype_obj =parent.frames[1].document.forms[0].bed_type_desc;\n\t\t\t\tvar length  = bedtype_obj.length;\n\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t{\n\t\t\t\t\t\tbedtype_obj.remove(1);\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<!--\n\t\t\t\t\t<script>\t\n\t\t\t\t\t\tvar opt= parent.frames[1].document.createElement(\'Option\');\n\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"; \n\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\t\t\t\tbedtype_obj.add(opt);\n\t\t\t\t\t\tparent.frames[1].document.createElement(\'Option\');\n\t\t\t\t\t</script>-->\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tvar service_obj;\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].service_desc!=null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tservice_obj =parent.frames[1].document.forms[0].service_desc;\n\t\t\t\t\t\t\tvar length  = service_obj.length;\n\t\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tservice_obj.remove(1);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(parent.frames[1].document.forms[0].service!=null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tservice_obj =parent.frames[1].document.forms[0].service;\n\t\t\t\t\t\t\tvar length  = service_obj.length;\n\t\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tservice_obj.remove(1);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\") \n\t\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\tservice_obj.add(opt);\n\t\t\t\t\t\t\t\tparent.frames[1].document.createElement(\'Option\');\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(parent.frames[1].document.forms[0].bed_class_desc!=null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tbedclass_obj =parent.frames[1].document.forms[0].bed_class_desc;\n\t\t\t\t\t\t\t\tvar length  = bedclass_obj.length;\n\t\t\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tbedclass_obj.remove(1);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(parent.frames[1].document.forms[0].Bedcode!=null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tbedclass_obj =parent.frames[1].document.forms[0].Bedcode;\n\t\t\t\t\t\t\t\tvar length  = bedclass_obj.length;\n\t\t\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tbedclass_obj.remove(1);\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar bedClassOpt\t= parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\tbedClassOpt.text\t= \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";;\n\t\t\t\t\t\t\t\tbedClassOpt.value= \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tbedClassOpt.selected = true;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tbedclass_obj.add(bedClassOpt);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar bedTypeOpt\t= parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\tbedTypeOpt.text\t= \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";;\n\t\t\t\t\t\t\t\tbedTypeOpt.value= \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tbedTypeOpt.selected = true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_type_desc.add(bedTypeOpt);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t<script>\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].room_no.value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].Bedcode.value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].bed_class_desc.value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].populateBedType(\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\", \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\");\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<script>\n\t\t\t\tvar bedclass_obj = \'\';\n\t\t\t\t\tif(parent.frames[1].document.forms[0].Bedcode!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tbedclass_obj =parent.frames[1].document.forms[0].Bedcode;\n\t\t\t\t\t\tvar length  = bedclass_obj.length;\n\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tbedclass_obj.remove(1);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t</script>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar bedClassOpt\t= parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\tbedClassOpt.text\t= \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";;\n\t\t\t\t\tbedClassOpt.value= \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\t\t//parent.frames[1].document.forms[0].Bedcode.add(bedClassOpt);\n\t\t\t\t\tbedclass_obj.add(bedClassOpt);\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\t\t\t\tvar opt3=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt3.text=temp1;\n\t\t\t\t\t\topt3.value=temp;          \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\t\t\t\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].referral_source.value=temp1;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].referral_source1.value=temp;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].referral_source.disabled=true;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].referral_source_lkp_but.disabled=true;\n\t\t\t\t\t\t//parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value=temp1;\n\t\t\t\t\t\t//parent.frames[1].document.forms[0].referral_source1.value=temp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tif(parent.frames[1].booking_form)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[1].booking_form.billing_group.value=document.forms[0].billing_group.value;\n\t\t\t\t\t\t\tparent.frames[1].booking_form.bl_future_admn_YN.value=document.forms[0].bl_future_admn_YN.value;\n\t\t\t\t\t\t\tparent.frames[1].booking_form.bl_operation.value=document.forms[0].bl_operation.value;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n</body>\n</form>\n</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String locale					= (String)session.getAttribute("LOCALE");
	String bl_operational			= (String)session.getValue("bl_operational"); 
	//String  loginUser				= (String)session.getAttribute("login_user");

	String module_id = "IP";
	String calling_function_id = "BOOKING";
	String episode_type = "I";


	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	Connection			con			= null;
	Statement			stmt		= null;
	PreparedStatement	pstmt		= null;
	ResultSet			rset		= null;
	ResultSet			rs			= null;
	//Statement			paramStmt	= null;
	//ResultSet			paramRS		= null;
	String	facilityId				= "" ; 
	String	value3					= ""; 
	String	from					= "",		value5					=	"";
	String	sql						= ""; 
	String	roomno					= "";
	String	bedno					= "";	
	String	servicecode				= "",		servicedesc				=	"";
	String patient_id				= "";
	String blng_grp					= "";
	String is_tab_click				= "";
	//String oper_stn_id				= "";
	String confirm_yn				= "";
	String callingfrom				= "";
	
	try
	{
		con						=	ConnectionManager.getConnection(request);
		facilityId				=	(String)session.getValue("facility_id");
		patdata.setFacility_id(facilityId);
		String criteria			=	checkForNull(request.getParameter("criteria"));
		String nursingUnitCode	=	checkForNull(request.getParameter("nursingUnitCode"));
		String bedClass			=	checkForNull(request.getParameter("bedClass"));
		String bedType			=	checkForNull(request.getParameter("bedType"));
		String option_val		=	checkForNull(request.getParameter("option_val"));		
		value3					=	checkForNull(request.getParameter("field3"));
		from					=	checkForNull(request.getParameter("field4"));
		value5					=	checkForNull(request.getParameter("field5"));
		patient_id				=	checkForNull(request.getParameter("patient_id"));
		blng_grp				=	checkForNull(request.getParameter("blng_grp"));
		is_tab_click			=	checkForNull(request.getParameter("is_tab_click"));
		callingfrom  			=	checkForNull(request.getParameter("callingfrom"));

		/*Added by Dharma on jan 16 2014 for RUT-SCF-0352 [IN:046525] Start*/
		String request_service_desc		= 	checkForNull(request.getParameter("request_service_desc"));
		String is_default_service		=	checkForNull(request.getParameter("is_default_service"));
		/*Added by Dharma on jan 16 2014 for RUT-SCF-0352 [IN:046525] End*/
	
		String bed_type_short_desc	= "";
		String bed_type_code		= "";
		
		/*Friday, April 23, 2010 commented for performance tuning ,query executed multiple time*/
/*
		String paramSql = " select deactivate_pseudo_bed_yn from IP_PARAM where facility_id='"+facilityId+"' ";

		paramStmt	= con.createStatement();
		paramRS		= paramStmt.executeQuery(paramSql);

	
		if(paramRS.next())
		{
			deactivate_pseudo_bed_yn = paramRS.getString("deactivate_pseudo_bed_yn");
		}

		if(deactivate_pseudo_bed_yn == null) deactivate_pseudo_bed_yn= "N";
		if(paramRS !=null)    paramRS.close(); 
		if(paramStmt != null) paramStmt.close();

		try
		{
			StringBuffer operSql = new StringBuffer();
			operSql.append("SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='");
			operSql.append(facilityId);	
			operSql.append("' AND a.facility_id = b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='");
			operSql.append(loginUser);
			operSql.append("' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))");
			stmt = con.createStatement();
			rs   = stmt.executeQuery(operSql.toString());
			if(rs!=null)
			{
				if(rs.next())
				{
					oper_stn_id = checkForNull(rs.getString("OPER_STN_ID"));
				}	
			}
				if(rs	 != null)   rs.close(); 
				if(stmt	 != null)   stmt.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		try
		{
			StringBuffer confSql = new StringBuffer();
			confSql.append(" select CREATE_BOOKING_WITH_CONF_YN from AM_OPER_STN where FACILITY_ID = '");
			confSql.append(facilityId);
			confSql.append("' and OPER_STN_ID = '");
			confSql.append(oper_stn_id);
			confSql.append("'");
			stmt	= con.createStatement();
			rs = stmt.executeQuery(confSql.toString());
			if (rs.next())
			{
				confirm_yn = rs.getString("CREATE_BOOKING_WITH_CONF_YN");
			}
		
			if(rs	 != null)   rs.close(); 
			if(stmt	 != null)   stmt.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		// Added by SRIDHAR R On 20 OCT 2004 for Populating Service Values...
*/		
//out.println("<script>alert(\"criteria :"+criteria+"\");</script>");	
		if(criteria.equals("PopulateService"))
		{
			
			if(!nursingUnitCode.equals(""))
			{
				// Query Used for Populating default Service Value...
				confirm_yn				= checkForNull(request.getParameter("create_booking_with_conf_yn"),"N");
				String addlservice = "";
				
				///sql = "Select service_code, short_desc, ancillary_yn from AM_SERVICE_LANG_VW where language_id = '"+locale+"' and  Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"')";
				sql = "Select service_code, am_get_desc.am_service(service_code,'"+locale+"',2)short_desc, ancillary_yn from AM_SERVICE where   Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"')";



				stmt = con.createStatement();
				rset = stmt.executeQuery(sql);

				if(rset != null && rset.next())
				{
					servicecode			=	checkForNull(rset.getString("service_code"));
					servicedesc			=	checkForNull(rset.getString("short_desc"));					
				}
					if(rset !=null) rset.close(); if(stmt != null) stmt.close();
				if(option_val.equals("retrieve")){
			
            _bw.write(_wl_block8Bytes, _wl_block8);

				} else{
			
            _bw.write(_wl_block9Bytes, _wl_block9);
	
				}
				// Query Used for adding Service Values to the prevoius options...

				sql = " select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = ? and nursing_unit_code = ? union select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURSING_UNIT where facility_id = ? and nursing_unit_code = ? order by 2 ";



				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,nursingUnitCode);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,nursingUnitCode);
				rset = pstmt.executeQuery();								
				while (rset.next())
				{
					addlservice	= checkForNull(rset.getString("service_code"));
					servicedesc	= checkForNull(rset.getString("service_short_desc"));
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(addlservice));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(addlservice));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(is_default_service.equals("N")){	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request_service_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(addlservice));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(addlservice));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
		}

				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();

				// Query Used for adding Bed Class Values to the prevoius options
				if(confirm_yn.equals("Y") || (!callingfrom.equals("createBooking"))){
				if(option_val.equals("retrieve")){
				
            _bw.write(_wl_block18Bytes, _wl_block18);

				} else {
				
            _bw.write(_wl_block19Bytes, _wl_block19);

				}			
					//sql = " SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = ? AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code and b.language_id = ? ORDER BY b.short_desc ";
					sql = "SELECT DISTINCT a.bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,?,'2') short_desc FROM ip_nursing_unit_bed a WHERE a.facility_id = ? AND a.eff_status = 'E' AND a.nursing_unit_code = ?  ORDER BY short_desc";



					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,nursingUnitCode);
					rset = pstmt.executeQuery();
					
					if(rset!=null)
					{
						while (rset.next())
						{
							String bed_class_code	= checkForNull(rset.getString("bed_class_code"));
							String bed_class_desc	= checkForNull(rset.getString("short_desc"));

							
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bed_class_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
		}
				}

				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
				
				//  Query Used for adding Bed Type Values to the prevoius options
				
            _bw.write(_wl_block23Bytes, _wl_block23);

				/*Friday, April 23, 2010 commented for performance tuning , query getting executed multiple time*/
				/*sql = " SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b WHERE b.language_id = ? and a.facility_id = ? AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code  AND a.bed_class_code = ? and a.eff_status='E' AND b.eff_status = 'E' AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,nursingUnitCode);
				pstmt.setString(4,bedClass);
				rset = pstmt.executeQuery();
				
				if(rset!=null)
				{
					while (rset.next())
					{
						String bedtype_code	= checkForNull(rset.getString("bed_type_code"));
						String bedtype_shortdesc	= checkForNull(rset.getString("bed_type_short_desc"));
*/
						
            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block26Bytes, _wl_block26);
		//}
				//}

				//if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
			}			 
			}
			session.removeAttribute("ipPatInstructionsMap");// Included for the CRF - RUT-CRF013 - 23396 
			
		}// E.O PopulateService
	
		// Query Used for Populating Bed Type for selected Bed Class...
		if(criteria.equals("PopulateBedType"))
		{
			if((!bedClass.equals(""))&&(!nursingUnitCode.equals("")))
			{
				String bedClass_Sql	="";

				String service_Sql ="";

				String defaultServiceCodeSql ="";
				String deactivate_pseudo_bed_yn = checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
				String service_desc = checkForNull(request.getParameter("service_desc"));
				String validationType = checkForNull(request.getParameter("validationType"));
				// Query Used for Populating default Service Value...
				if(validationType.equals("Bed_Avaibility_Chart_Validation") && service_desc.equals(""))
				{
					/*Friday, April 23, 2010 modified for performance tuining*/
					//defaultServiceCodeSql ="Select service_code, short_desc, ancillary_yn from AM_SERVICE_LANG_VW where language_id = '"+locale+"' and  Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"')";
					defaultServiceCodeSql ="Select service_code, am_get_desc.am_service(service_code,'"+locale+"',2)short_desc, ancillary_yn from AM_SERVICE where   Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"')";



					stmt = con.createStatement();
					rset = stmt.executeQuery(defaultServiceCodeSql);
					
					if(rset != null && rset.next())
					{
						servicecode			=	checkForNull(rset.getString("service_code"));
						servicedesc			=	checkForNull(rset.getString("short_desc"));					
					}
					
					if(rset !=null) rset.close(); if(stmt != null) stmt.close();


					// Query Used for adding Service Values to the prevoius options...
					service_Sql = "select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = ? and nursing_unit_code =? union select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURSING_UNIT where facility_id = ? and nursing_unit_code = ? order by 2 ";
					pstmt = con.prepareStatement(service_Sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,nursingUnitCode);
					pstmt.setString(4,locale);
					pstmt.setString(5,facilityId);
					pstmt.setString(6,nursingUnitCode);
					rset = pstmt.executeQuery();	
					
					if(rset!=null)
					{
						
            _bw.write(_wl_block27Bytes, _wl_block27);

							while (rset.next())
							{
								String service_Code	= checkForNull(rset.getString("service_code"));
								String service_Desc	= checkForNull(rset.getString("service_short_desc"));
							
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(service_Desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(service_Code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(service_Code));
            _bw.write(_wl_block29Bytes, _wl_block29);
		}
						if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
					}
				}

				// Query Used for adding Bed Class Values to the prevoius options...
				if(validationType.equals("Bed_Avaibility_Chart_Validation"))
				{
					//bedClass_Sql = " SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = ? AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code and b.language_id = ? ORDER BY b.short_desc  ";
					/*modified for performance tuning Friday, April 23, 2010*/
					bedClass_Sql = " SELECT DISTINCT a.bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,?,'2') short_desc FROM ip_nursing_unit_bed a WHERE a.facility_id = ? AND a.eff_status = 'E' AND a.nursing_unit_code = ?  ORDER BY short_desc  ";
					pstmt	=	con.prepareStatement(bedClass_Sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,nursingUnitCode);
					rset	=	pstmt.executeQuery();

					if(rset!=null)
					{
						
            _bw.write(_wl_block30Bytes, _wl_block30);

												
						while(rset.next())
						{
							String bed_class_code	= checkForNull(rset.getString("bed_class_code"));
							String bed_class_desc	= checkForNull(rset.getString("short_desc"));
							
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bed_class_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bedClass));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block33Bytes, _wl_block33);

						}// E.O While
							if(rset !=null) rset.close(); 
							if(pstmt != null) pstmt.close();
					}// E.O if

				}
					// Query Used for adding Bed Type Values to the prevoius options...

					if(deactivate_pseudo_bed_yn.equals("Y") )
					{
						//bedClass_Sql = " SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b where b.language_id = ? and a.facility_id = ? AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = ? AND a.eff_status='E' AND b.eff_status = 'E' AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc ";
						bedClass_Sql = "SELECT DISTINCT a.bed_type_code bed_type_code,ip_get_desc.ip_bed_type (a.bed_type_code,?,'2' ) bed_type_short_desc  FROM ip_nursing_unit_bed a  WHERE a.facility_id = ?  AND a.nursing_unit_code = ? AND a.bed_class_code = ? AND a.eff_status = 'E' AND a.psuedo_bed_status = 'N' ORDER BY bed_type_short_desc ";
					}
					else if(deactivate_pseudo_bed_yn.equals("N"))
					{
						//bedClass_Sql = " SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b WHERE b.language_id = ? and a.facility_id = ? AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = ? AND a.eff_status='E' AND b.eff_status = 'E' ORDER BY b.short_desc ";
						/*Friday, April 23, 2010 modified for performance tuning*/
						bedClass_Sql = "SELECT DISTINCT a.bed_type_code bed_type_code,ip_get_desc.ip_bed_type (a.bed_type_code,?,'2' ) bed_type_short_desc  FROM ip_nursing_unit_bed a  WHERE a.facility_id = ?  AND a.nursing_unit_code = ? AND a.bed_class_code = ? AND a.eff_status = 'E' ORDER BY bed_type_short_desc ";
					}
					pstmt	=	con.prepareStatement(bedClass_Sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,nursingUnitCode);
					pstmt.setString(4,bedClass);
					rset	=	pstmt.executeQuery();
					if(rset!=null)
					{
						while(rset.next())
						{
							bed_type_short_desc	= checkForNull(rset.getString("BED_TYPE_SHORT_DESC"));
							bed_type_code		= checkForNull(rset.getString("BED_TYPE_CODE"));
							
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bed_type_short_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bedType));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block36Bytes, _wl_block36);

						}// E.O While
							if(rset !=null) rset.close(); 
							if(pstmt != null) pstmt.close();
					}// E.O if
				
			}
		} // E.O PopulateBedType

		

		if(from.equals("Booking_form"))
		{

			
			String nursingcode  =	value3;
			bedno				=	value5;
			//String from_date		=	checkForNull(request.getParameter("from_date"));
			//String to_date			=	checkForNull(request.getParameter("to_date"));
			if(!bedno.equals(""))
			{
					//int no_of_time_bed_booked = 0;

					
					/*sql	= "select Count(*) no_of_record from ip_bed_booking where booking_status  in ('0','1')  and facility_id = '"+facilityId+"' and req_nursing_unit_code = '"+nursingcode+"' and req_bed_no = '"+bedno+"' AND blocked_from_date_time > SYSDATE AND ((blocked_from_date_time BETWEEN    TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI')    AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN    TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI') AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI')) OR  ( blocked_from_date_time <= TO_DATE('"+from_date+"','DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE('"+to_date+"','DD/MM/YYYY HH24:MI')))";

					out.println("<script>alert(\""+sql+"\");</script>");
					stmt	=	con.createStatement();
					rset	=	stmt.executeQuery(sql);

					if(rset.next())
					{
						no_of_time_bed_booked				= rset.getInt("no_of_record");						
					}
					if(rset !=null) rset.close(); 
					if(stmt != null) stmt.close();*/
				//if(no_of_time_bed_booked == 0)
				//{
						sql	=" select room_no, bed_class_code, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, specialty_code, bed_type_code, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2')  bed_type_short_desc, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') short_desc  from IP_NURSING_UNIT_BED where eff_status = 'E' and  nursing_unit_code = '"+nursingcode+"' and bed_no='"+bedno+"' and facility_id = '"+facilityId+"' ";

						stmt	=	con.createStatement();
						rset	=	stmt.executeQuery(sql);

						if(rset.next())
						{
							roomno				= checkForNull(rset.getString("room_no"));
							String bedClassCode	= checkForNull(rset.getString("bed_class_code"));
							String bedtype_code			= checkForNull(rset.getString("BED_TYPE_CODE"));
						
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bedClassCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bedClassCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bedClassCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bedtype_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
	}
						else
						{
							out.println("<script>alert(getMessage('INVALID_BED','Common'));parent.frames[1].document.forms[0].room_no.value='';parent.frames[1].document.forms[0].bed_no.value='';parent.frames[1].document.forms[0].bed_no.focus();parent.frames[1].document.forms[0].bed_class_desc.value='';parent.frames[1].document.forms[0].bed_no.select(); </script>");
						}
						if(rset !=null) rset.close(); 
						if(stmt != null) stmt.close();
				/*}
				else
				{
					out.println("<script>alert(getMessage('OVERLAP_BLOCK_TIME','IP'));parent.frames[1].document.forms[0].room_no.value='';parent.frames[1].document.forms[0].bed_no.value='';parent.frames[1].document.forms[0].bed_no.focus();parent.frames[1].document.forms[0].bed_class_desc.value='';parent.frames[1].document.forms[0].bed_no.select(); </script>");
				}*/
					
			}
			else if (!nursingcode.equals(""))
			{
				String addlservice = "";
				//sql = " Select service_code, short_desc, ancillary_yn  from AM_SERVICE_LANG_VW where language_id = '"+locale+"' and service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingcode+"') ";
				/*Friday, April 23, 2010 modified for performance tuining*/
				sql = " Select service_code, am_get_desc.am_service(service_code,'"+locale+"',2)short_desc, ancillary_yn from AM_SERVICE where   Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingUnitCode+"') ";



				stmt = con.createStatement();
				rset = stmt.executeQuery(sql);

				if(rset != null && rset.next())
				{
					servicecode			=	checkForNull(rset.getString("service_code"));
					servicedesc			=	checkForNull(rset.getString("short_desc"));
				}
					if(rset !=null) rset.close(); 
					if(stmt != null) stmt.close();
				out.println("<script>");
				out.println("var obj =parent.frames[1].document.forms[0].service;");
				out.println("var length  = obj.length;");
				out.println("for(i=0;i<length;i++) {obj.remove(1);}");

				sql = " select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = ? and nursing_unit_code = ? union select service_code, AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURSING_UNIT where facility_id = ? and nursing_unit_code = ? order by 2  ";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,nursingUnitCode);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,nursingUnitCode);
				rset = pstmt.executeQuery();								
				while (rset.next())
				{
					addlservice			=	checkForNull(rset.getString("service_code"));
					servicedesc			=	checkForNull(rset.getString("service_short_desc"));
					
					
					/*Modified by Dharma on jan 17 2014 for RUT-SCF-0352 [IN:046525] Start*/

					/*out.println ("var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+servicedesc+"\"; opt.value=\""+addlservice+"\";if(\""+servicecode+"\"== \""+addlservice+"\") opt.selected = true;\nobj.add(opt)") ;
					out.println ("parent.frames[1].document.createElement('Option')") ;*/

					out.println ("var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+servicedesc+"\";opt.value=\""+addlservice+"\";");

					if(is_default_service.equals("N")){	
						out.println ("if(\""+request_service_desc+"\"== \""+addlservice+"\") opt.selected = true;\nobj.add(opt)") ;
					}else{
						out.println ("if(\""+servicecode+"\"== \""+addlservice+"\") opt.selected = true;\nobj.add(opt)") ;
					}
					out.println ("parent.frames[1].document.createElement('Option')") ;

					/*Modified by Dharma on jan 17 2014 for RUT-SCF-0352 [IN:046525] End*/


				}
				out.println("</script>");
				if(rset !=null) rset.close(); 
				if(pstmt != null) pstmt.close();

				//generation of bed class
				String BedClass_code = "";
				String BedClass_desc = "";
				// Query Used for Populating bed class Value...
				
            _bw.write(_wl_block43Bytes, _wl_block43);

				//sql =" select distinct a.bed_class_code, b.short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b where b.language_id = ? and a.facility_id = ? AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc ";
				/*Friday, April 23, 2010 modified for performance tuining*/
				sql = "SELECT DISTINCT a.bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,?,'2') short_desc FROM ip_nursing_unit_bed a WHERE a.facility_id = ? AND a.eff_status = 'E' AND a.nursing_unit_code = ? AND a.psuedo_bed_status = 'N' ORDER BY short_desc" ;

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,nursingcode);

				rset = pstmt.executeQuery();

				if(rset != null)
				{
					while(rset.next())
					{
						BedClass_code =	checkForNull(rset.getString("bed_class_code"));
						BedClass_desc =	checkForNull(rset.getString("short_desc"));
			
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(BedClass_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(BedClass_code));
            _bw.write(_wl_block46Bytes, _wl_block46);

					}
				}
				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
				//end of generating bed class
			}
		}	

		// validation of bed no.

		if(from.equals("validate_bed_no"))
		{
			//String nursingcode  =	value3;
			bedno				=	value5;
			//String from_date		=	checkForNull(request.getParameter("from_date"));
			//String to_date			=	checkForNull(request.getParameter("to_date"));
			//String call_function	=	checkForNull(request.getParameter("call_function"));

			if(!bedno.equals(""))
			{
					//int no_of_time_bed_booked = 0;

					
					/*sql	= "select Count(*) no_of_record from ip_bed_booking where booking_status  in ('0','1')  and facility_id = '"+facilityId+"' and req_nursing_unit_code = '"+nursingcode+"' and req_bed_no = '"+bedno+"' AND blocked_from_date_time > SYSDATE AND ((blocked_from_date_time BETWEEN    TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI')    AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI')) OR (blocked_until_date_time BETWEEN    TO_DATE('"+from_date+"', 'DD/MM/YYYY HH24:MI') AND TO_DATE('"+to_date+"', 'DD/MM/YYYY HH24:MI')) OR  ( blocked_from_date_time <= TO_DATE('"+from_date+"','DD/MM/YYYY HH24:MI') and blocked_until_date_time >= TO_DATE('"+to_date+"','DD/MM/YYYY HH24:MI')))";

					
					stmt	=	con.createStatement();
					rset	=	stmt.executeQuery(sql);

					if(rset.next())
					{
						no_of_time_bed_booked				= rset.getInt("no_of_record");						
					}
					if(rset !=null) rset.close(); 
					if(stmt != null) stmt.close();
				
					if(no_of_time_bed_booked>0)
					{

						
							out.println("<script> var msg = getMessage('OVERLAP_BLOCK_TIME','IP');		parent.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=BOOKING&call_func="+call_function+"&function_name=Create%20Booking&function_type=F&access=NYNNN';						parent.frames[2].location.href='../../eIP/jsp/IPError.jsp?err_num='+msg+'&err_value=0&call_func="+call_function+"';</script>");
		
					}
					else
					{*/
						
						out.println("<script>parent.frames[1].callApply();</script>");
					//}
					
			}
			else
			{
				out.println("<script>parent.frames[1].callApply();</script>");
			}

		}
		/*Friday, October 01, 2010 , referral source in Active Booking changed to lookup since AM_REFERRAL has huge data and screen taking time to load*/
		if(from.equals("Active_booking"))
		{
			 String ref_type = request.getParameter("ref_type");
			 if(ref_type==null) ref_type="";
			 StringBuffer sqlFacility = new StringBuffer();
			 String referredFacilityid = "";
			 String referredFacilitydesc = "";
			 if(ref_type.equals("L"))
			 {
				if(sqlFacility.length() > 0) sqlFacility.delete(0,sqlFacility.length());
				sqlFacility.append("Select sm_get_desc.sm_facility_param(facility_id ,'"+locale+"',1) facility_name, facility_id from sm_facility_param Where STATUS = 'E'");
				sqlFacility.append(" and facility_id = '"+facilityId+"' ");
		
				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sqlFacility.toString());
				if(rset.next())
				{
						referredFacilityid				= rset.getString("facility_id");		
						referredFacilitydesc			= rset.getString("facility_name");	
						
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(referredFacilityid));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(referredFacilitydesc));
            _bw.write(_wl_block49Bytes, _wl_block49);

						if(ref_type.equals("L"))
						{
						
            _bw.write(_wl_block50Bytes, _wl_block50);

						}
						
            _bw.write(_wl_block51Bytes, _wl_block51);

				}
				if(rset !=null) rset.close(); 
				if(stmt != null) stmt.close();
			}
			
		}
	/*	if(from.equals("OT"))
		{
			String nursingcode		=	value3;
			String splcode			=	checkForNull(request.getParameter("splCode"));
			String patientclass		=	checkForNull(request.getParameter("patientclass"));
			String practID			=	checkForNull(request.getParameter("practID"));
			String p_oper_stn_id	=	checkForNull(request.getParameter("p_oper_stn_id"));
			String loginUser		=	checkForNull(request.getParameter("loginUser"));


			
					int no_of_user = 0;

					
					sql	= "select count(*) no_of_record from IP_NURSING_UNIT_LANG_VW a, AM_OS_USER_LOCN_ACCESS_VW c ,IP_MED_SER_GRP_NURS_UT_TYPE e, IP_NURS_UNIT_FOR_SPECIALTY f  ,IP_NURSING_UNIT_FOR_PRACT g  where language_id = '"+localeName+"' and a.facility_id ='"+facilityId+"' and a.eff_status = 'E' and  c.facility_id  = a.facility_id  and c.locn_type = 'N' and c.locn_code  = a.nursing_unit_code and  c.appl_user_id = '"+loginUser+"'  and c.oper_stn_id = '"+p_oper_stn_id+"' and e.FACILITY_ID = a.FACILITY_ID and e.NURSING_UNIT_TYPE_CODE = a.NURSING_UNIT_TYPE_CODE and f.FACILITY_ID = a.FACILITY_ID AND f.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND f.SPECIALTY_CODE = '"+splcode+"'  and g.FACILITY_ID = a.FACILITY_ID AND g.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND g.PRACTITIONER_ID = '"+practID+"' and a.NURSING_UNIT_CODE='"+nursingcode+"' and (c.CREATE_BOOKING_YN = 'Y' OR c.CREATE_BOOKING_WITH_CONF_YN = 'Y')  and a.PATIENT_CLASS='"+patientclass+"' ";
					
					out.println("<script>alert(\""+sql+"\");</script>");
					stmt	=	con.createStatement();
					rset	=	stmt.executeQuery(sql);

					if(rset.next())
					{
						no_of_user				= rset.getInt("no_of_record");						
					}
					if(rset !=null) rset.close(); 
					if(stmt != null) stmt.close();
				
					if(no_of_user>0)
					{
					
						//out.println("<script>parent.frames[1].ChangeVal(parent.frames[1].document.forms[0].med_service_grp);parent.frames[1].displayDefaultValue(parent.frames[1].document.forms[0].exp_days_of_stay);parent.frames[1].dateCal(parent.frames[1].document.forms[0].pref_adm_date);</script>");

						//out.println("<script>return true;</script>");
						//out.println("<script> var msg = getMessage('OVERLAP_BLOCK_TIME','IP');		parent.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=BOOKING&call_func="+call_function+"&function_name=Create%20Booking&function_type=F&access=NYNNN';						parent.frames[2].location.href='../../eIP/jsp/IPError.jsp?err_num='+msg+'&err_value=0&call_func="+call_function+"';</script>");		
					}
					else
					{
						//out.println("<script>parent.frames[1].callApply();</script>");
						out.println("<script> var msg = 'User is not associated with Nursing Unit . ';	alert(msg);						parent.window.close();</script>");		
					}
		}*/
		
			//out.println("<script>alert(\""+bl_operational+"\");</script>");
			//out.println("<script>alert(\""+patient_id+"\");</script>");
			//out.println("<script>alert(\""+blng_grp+"\");</script>");
			// Start of billing interface
			if(bl_operational.equals("Y") && !patient_id.equals("") && is_tab_click.equals("Y")) 
			{
				if((blng_grp == null || blng_grp.equals("")))
				{
					
				
				
            _bw.write(_wl_block52Bytes, _wl_block52);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf(module_id
                        )},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(calling_function_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf(episode_type
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block55Bytes, _wl_block55);

				}

					out.println("<script>parent.frames[1].grabFinancialDetails();</script>");

			}
			else if(bl_operational.equals("Y") && patient_id.equals("") && is_tab_click.equals("Y"))
			{
				out.println("<script>parent.frames[1].grabFinancialDetails();</script>");
			}

			//End of Billing Interfacing


	}catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(stmt != null)	stmt.close();
		if(pstmt != null)	pstmt.close();
		if(rset != null )	rset.close();
		if(rs != null )		rs.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block56Bytes, _wl_block56);
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
