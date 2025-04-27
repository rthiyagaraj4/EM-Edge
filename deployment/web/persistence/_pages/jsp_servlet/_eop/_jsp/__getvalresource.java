package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __getvalresource extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/GetValResource.jsp", 1715249797710L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<script language=\"javascript\">\n\tvar counter,arrayServiceName,arrayServiceCode,arraySectionName,arraySectionCode,selectServiceCodeIndex,sectionLength=0,serviceLength=0;\n</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="       \n            <script language=\"javascript\">\n             arrayServiceCode=new Array();\n             arrayServiceName=new Array();\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\tarrayServiceCode.push(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\");\n\t\t\tarrayServiceName.push(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\");\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\nserviceLength=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =";\n </script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n<script language=\"javascript\">\narraySectionCode=new Array();\narraySectionName=new Array();\t\n\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n \t\t\t    arraySectionCode.push(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\");\n\t\t\t    arraySectionName.push(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\");\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\tsectionLength=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =";\n\t</script>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n<script language=\"javascript\">\nfunction onLoadAction()\n{\n\tvar n=parent.f_query_add_mod.document.clinic_sub.document.forms[0].service.options.length;\n\tfor(var i=0;i<n;i++)\t\n\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].service.remove(\"service\");\n\t\tn=parent.f_query_add_mod.document.clinic_sub.document.forms[0].section.options.length;\n\tfor(var i=0;i<n;i++)\t\n\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].section.remove(\"section\");\n\tif(parent.f_query_add_mod.frames[0].document.clinic_main_resource_form.eff_status.checked==true)\n\t{\n\t\tvar optService=parent.document.f_query_add_mod.document.clinic_sub.document.createElement(\"OPTION\");\n\t\toptService.text=\"  --------\"+getLabel(\'Common.defaultSelect.label\',\'Common\')+\"--------  \";\n\t\toptService.value=\"\";\n\t\toptService.selected=true;\n\n\t\tvar optSection=parent.document.f_query_add_mod.document.clinic_sub.document.createElement(\"OPTION\");\n\t\toptSection.text=\"  -------- \"+getLabel(\'Common.defaultSelect.label\',\'Common\')+\" --------  \";\n\t\toptSection.value=\"\";\n\t\toptSection.selected=true;\n\t\t\n\t\t\n\t\tif(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].service != null)\n\t\t\tparent.document.f_query_add_mod.document.clinic_sub.document.forms[0].service.add(optService); \n\t\t\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\n\t\tif(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].section != null)\tparent.document.f_query_add_mod.document.clinic_sub.document.forms[0].section.add(optSection); \n\t\t\t\n\t\tvar counter;\n\t\tif(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].section != null)\n\t\tfor(counter=0;counter<sectionLength;counter++){\t\t\toptSection=parent.document.f_query_add_mod.document.clinic_sub.document.createElement(\"OPTION\");\n\t\toptSection.text=arraySectionName.pop();\n\t\toptSection.value=arraySectionCode.pop();\n\t\tparent.document.f_query_add_mod.document.clinic_sub.document.forms[0].section.add(optSection);\n\t\t}\n\t\t\n\n\t\tif(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].service != null)\n\t\tfor(counter=0;counter<serviceLength;counter++){\t\t\toptService=parent.document.f_query_add_mod.document.clinic_sub.document.createElement(\"OPTION\");\n\t\toptService.text=arrayServiceName.pop();\n\t\toptService.value=arrayServiceCode.pop();\n\t\tparent.document.f_query_add_mod.document.clinic_sub.document.forms[0].service.add(optService);\n\t\t}\n\t\t\t\t\t\t\n\t}\n\n}";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</script>           \n</head>\n<body onload=\"onLoadAction();\" CLASS=\'MESSAGE\' onKeyDown = \'lockKey();\'>\n<form name=\'nam1\' id=\'nam1\'>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<script>\n\t\t\t\tvar opt=parent.document.\n\t\t\t\tf_query_add_mod.document.clinic_sub.document.createElement(\"OPTION\");\n                opt.text=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].mr_section.add(opt);\n\t\t\t\t</script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="                                  \n<script>\n\t\t\n\t\tvar opt=parent.document.f_query_add_mod.document.clinic_sub.document.createElement(\"OPTION\");\n\t                   \n</script>           \n\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<script>\n\t\tvar temp = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\tvar temp1=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\tvar opt=parent.document.f_query_add_mod.document.clinic_sub.document.createElement(\"OPTION\");\n\t\topt.text=temp1;\n\t\topt.value=temp;\n\t parent.document.f_query_add_mod.document.clinic_sub.document.clinic_resource_form.mr_location_code.value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\n\t\tif(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].mr_location_code != null)\n\t\tparent.document.f_query_add_mod.document.clinic_sub.document.forms[0].mr_location_code.add(opt);\n\n</script>\n\t\t\t\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<script language =\'javascript\'>\n\t\t\t\t\tvar objlength=parent.f_query_add_mod.document.clinic_sub.document.forms[0].vitalsignsb.length;\n\t\n\t\t\t\t\tfor(i=1;i<objlength;i++)\n\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.clinic_sub.document.forms[0].vitalsignsb.item(i).value == \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" )\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].vitalsignsb.item(i).selected=true;\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<script>\n\t\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].multi_speciality_yn.value=\'Y\';\n\t\t\t\tif(parent.f_query_add_mod.document.clinic_sub.document.forms[0].centralValue.value!=\'Y\'){\n\t\t\t\t\tif(parent.f_query_add_mod.document.clinic_sub.document.forms[0].function_name.value==\'modify\'){\n\t\t\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_class.remove(1);\n\t\t\t\t\tvar opt1=document.createElement(\"OPTION\");\n\t\t\t\t\topt1.text=getLabel(\"Common.room.label\",\"Common\");\n\t\t\t\t\topt1.value=\"R\";\n\t\t\t\t\t\t\n\t\t\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_class.add(opt1);\n\t\t\t\t\t}\n\t\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_class.value=\'R\';\n\t\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_class.disabled=true;\n\t\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_class.onchange();\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t</script>\t\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t  <script>\n\t\t\t\t\t\tvar opt= parent.f_query_add_mod.document.clinic_sub.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].dflt_file_type.add(opt);\n\t\t\t\t\t  </script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t<script>\n\t\t\tvar len=parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.length;\t\n\t\t\t for(i=1;i<len;i++)\n\t\t    parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.remove(1);\n\t\t\t var opt=document.createElement(\"OPTION\");\n\t\t\tvar opt1=document.createElement(\"OPTION\");\n\t\t\topt1.text=getLabel(\'eOP.NotIdentifiable.label\',\'OP\');\t\t\t\t\n\t\t\topt1.value=\"X\";\n\t\t\topt.text=getLabel(\'Common.resource.label\',\'Common\');\t\t\t\t\n\t\t\topt.value=\"P\";\n\t        parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt1);\n\t        parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);\n\t\t\t \n\t\t\t </script>\n\t\t\t\t ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="<script>\n\t\t\t\tvar \nopt=document.createElement(\"OPTION\");\n\t\t\t\topt.text=getLabel(\'eOP.NotIdentifiable.label\',\'OP\');\t\n\t\t\t\topt.value=\"X\";\n\t\t\t\topt.selected=true;\n\t\t\t\topt.disabled=true;\n\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);\n\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.disabled=true;\n\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.checked=true;\t\n\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="<script>\n\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.disabled=false;\n\t\t parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.checked=false;\n\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_type.disabled=false;\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t<script>\n\t\t\tvar len=parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.length;\t\n\t\t\t for(i=1;i<len;i++)\n\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.remove(1);\n\t\t\n\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\tvar opt1=document.createElement(\"OPTION\");\n\t\t\topt1.text=getLabel(\'eOP.NotIdentifiable.label\',\'OP\');\t\n\t\t\topt1.value=\"X\";\n\t\t\topt.text=getLabel(\'Common.resource.label\',\'Common\');\n\t\t\topt.value=\"P\";\n\t parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt1);\n\t parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);\n\t parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.disabled=false;\n\t\t\t\t </script>\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<script>\n\t\t\t\tvar \nopt=document.createElement(\"OPTION\");\n\t\t\t\topt.text=getLabel(\'eOP.NotIdentifiable.label\',\'OP\');\t\n\t\t\t\topt.value=\"X\";\n\t\t\t\topt.selected=true;\n\t\t\t\topt.disabled=true;\n\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<script>\n\t\t\tvar len=parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.length;\n\t for(i=1;i<len;i++)\n\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.remove(1);\n\t\t\tvar opt=document.createElement(\"OPTION\");\n\t\t\topt.text=getLabel(\'Common.resource.label\',\'Common\');\n\t\t\topt.value=\"P\";\n\t\t\topt.selected=true;\n\t  parent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);\n\t  parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.disabled=true;\n\t  parent.f_query_add_mod.document.clinic_sub.document.forms[0].open_to_all_pract_yn.checked=false;\n\t  parent.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_type.disabled=false;\n\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="<script>\n\t\t\t\tvar \nopt=document.createElement(\"OPTION\");\n\t\t\t\topt.text=getLabel(\'eOP.NotIdentifiable.label\',\'OP\');\n\t\t\t\topt.value=\"X\";\n\t\t\t\topt.selected=true;\n\t\t\t\topt.disabled=true;\n\t\t\t\tparent.f_query_add_mod.document.clinic_sub.document.forms[0].ident_at_checkin.add(opt);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t var opt=parent.document.f_query_add_mod.document.clinic_sub.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\t\t\t\tif(parent.document.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_type != null)\n\t\t\t\t\t\t\tparent.document.f_query_add_mod.document.clinic_sub.document.forms[0].primary_res_type.add(opt);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<script>\n\t\t\t\t var opt=parent.document.frames[1].document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t opt.text=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\t\t\t\t opt.value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\t\t \n\t\t\t\t parent.document.frames[1].document.frames[1].document.forms[0].other_type.add(opt);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<script>\n\t\t\talert(getMessage(\'PRACT_WORKING_CAN_NOT_UNCHECK\',\'OP\'));\n\t\t\teval(\"parent.f_query_add_mod.clinic_sub.document.forms[0].\"+\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\").checked=true;\n\t\t\teval(\"parent.f_query_add_mod.clinic_sub.document.forms[0].\"+\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\").value=\"W\";\n\t\t\teval(\"parent.f_query_add_mod.clinic_sub.document.forms[0].\"+\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"+\"1\").value=\"W\";\n\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<script>\n\t\t\t\n\t\teval(\"parent.f_query_add_mod.clinic_sub.document.forms[0].working_week_\"+\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"+\"_day_\"+\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\").checked=true;\n\t\teval(\"parent.f_query_add_mod.clinic_sub.document.forms[0].working_week_\"+\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t<script>\n\t\t\t\teval(\"parent.f_query_add_mod.clinic_sub.document.forms[0].working_week_\"+\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\").checked=false;\n\t\teval(\"parent.f_query_add_mod.clinic_sub.document.forms[0].working_week_\"+\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"+\"1\").value=\"N\";\n\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="          \n            \n            \n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
          
            request.setCharacterEncoding("UTF-8"); 
			request= new XSSRequestWrapper(request);
	        response.addHeader("X-XSS-Protection", "1; mode=block");
	        response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con = null;
            Statement stmt = null;
            ResultSet rset=null;
			Statement dfstmt=null;
			ResultSet dfrset=null;
						
			String default_code="";
			String default_desc="";
			String fmInstallyn="";
			String mrcode="";
			String mrdesc="";
			String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
try
{
	con=ConnectionManager.getConnection(request);
    stmt = con.createStatement();
	String servicecode="";
	String servicedesc="";

	String common=request.getParameter("Common_Text");
	String srv_code=request.getParameter("srv_code");
	String srv_desc=request.getParameter("srv_desc");
	String sectionType = request.getParameter("sectionType");
	String defaultlocn=request.getParameter("defaultlocn");
	if(defaultlocn == null) defaultlocn="";
	String centralValue=request.getParameter("centralValue");
       if(centralValue==null)centralValue="";
	fmInstallyn=request.getParameter("fminstall");
	if(sectionType == null) sectionType="";
	String toPopulatefs = request.getParameter("toPopulatefs");
	if(toPopulatefs == null) toPopulatefs="";

	String mrsectionName=request.getParameter("mrsectionName");
	if(mrsectionName==null)mrsectionName="";
	String seperatefile=request.getParameter("seperatefile");
	if(seperatefile==null)seperatefile="";
	String sormid=request.getParameter("sormfiles");
	if(sormid==null)sormid="";

	String speciality=request.getParameter("speciality");
	if(speciality == null) speciality = "";
	String callfunction=request.getParameter("callfunction");
	String levelfcare=(request.getParameter("levelfcare")==null)?"":request.getParameter("levelfcare");

	String clinicSectionName=null, clinicSectionSql, clinicSectionCode=null;
	String facilityid=(String)session.getValue("facility_id");
    String sectionPop=request.getParameter("sectionpop");
	 if(sectionPop==null)sectionPop="";
	 String revisVisitFlag = request.getParameter("revisVisitFlag")==null?"":request.getParameter("revisVisitFlag");
	 String p_to_locn_code = request.getParameter("p_to_locn_code")==null?"":request.getParameter("p_to_locn_code");
	 String p_referral_id = request.getParameter("p_referral_id")==null?"":request.getParameter("p_referral_id");
	 String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	 String callingfrom = request.getParameter("callingfrom")==null?"":request.getParameter("callingfrom");
	 String multi_speciality_yn = request.getParameter("multi_speciality_yn")==null?"N":request.getParameter("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
	  String sql_1="";
	  String sql_2="";
	  String to_locn_code="";
	  String p_patient_id="";

	 
	if(revisVisitFlag.equals("Y")) {
		String refSql = "select to_locn_code,patient_id from PR_REFERRAL_REGISTER where REFERRAL_ID= '"+p_referral_id+"' and to_facility_id = '"+facilityid +"'  ";		
		
		rset=stmt.executeQuery(refSql.toString());
		if ( !rset.next() ) 
		{
			if(!callingfrom.equals("IP")){
			out.println("<script>alert(getMessage('INVALID_REF_ID','OP'));parent.frames[2].document.forms[0].referal_id1.value='';</script>");	out.println("<script>parent.frames[3].location.href='../../eCommon/jsp/error.jsp';</script>");	
			} else {				out.println("<script>alert(getMessage('INVALID_REF_ID','OP'));parent.frames[1].document.forms[0].referral_id.value='';</script>");	out.println("<script>parent.frames[2].location.href='../../eCommon/jsp/error.jsp';</script>");	
			}
		} else {
			to_locn_code = rset.getString("to_locn_code");
			p_patient_id = rset.getString("patient_id");
			if(to_locn_code=="null" || to_locn_code==null) to_locn_code = "";
			if(p_patient_id=="null" || p_patient_id==null) p_patient_id = "";			
			
			 if(!p_patient_id.equals(patient_id)){
				  out.println("<script>alert(getMessage('MISMATCH_REFERRALID_PATIENTID','COMMON'))</script>");	
				  if(!callingfrom.equals("IP"))
				    out.println("<script>parent.frames[2].document.forms[0].referal_id1.value='';</script>");	
				  else
					  out.println("<script>parent.frames[1].document.forms[0].referral_id.value='';</script>");	
			  } else if(!to_locn_code.equals(p_to_locn_code)){
				  out.println("<script>alert(getMessage('MISMATCH_REFERRALID_CLINIC','COMMON'))</script>");	
				  if(!callingfrom.equals("IP"))
				    out.println("<script>parent.frames[2].document.forms[0].referal_id1.value='';</script>");	
				  else
					  out.println("<script>parent.frames[1].document.forms[0].referral_id.value='';</script>");	
			  }
			if(!callingfrom.equals("IP")){
			 out.println("<script>parent.frames[3].location.href='../../eCommon/jsp/error.jsp';</script>");	
			} else {
				out.println("<script>parent.frames[2].location.href='../../eCommon/jsp/error.jsp';</script>");	
			}
		} 
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
  }
	
	if(sectionPop.equals("sectionPop"))
	{
	if(toPopulatefs.equals(""))
	{
		if(srv_code == null) srv_code="";
		if(srv_desc == null) srv_desc="";
		
		String sql = "select service_code,service_short_desc from am_facility_service_vw where eff_status = 'E' and operating_facility_id ='"+facilityid+"' and medical_yn='Y' and dept_Code='" + common.trim() + "' order by service_short_desc desc";
		rset = stmt.executeQuery(sql);          
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
				
		clinicSectionSql="Select clinicSection.SHORT_DESC clinicSectionName, clinicSection.SECTION_CODE clinicSectionCode from am_dept_section clinicSection, am_facility_section facilitySection where clinicSection.DEPT_CODE = facilitySection.DEPT_CODE and clinicSection.SECTION_CODE = facilitySection.SECTION_CODE and clinicSection.EFF_STATUS = 'E' and clinicSection.DEPT_CODE = '"+common.trim()+"' and facilitySection.OPERATING_FACILITY_ID='"+facilityid+"' order by 1 desc";

		   
			

            _bw.write(_wl_block7Bytes, _wl_block7);

  	  if(rset != null) 
		{    

            _bw.write(_wl_block8Bytes, _wl_block8);

	  	int counter=0;
		while( rset.next() ) 
		{
			counter++;
			servicecode=rset.getString("service_code");
			servicedesc=rset.getString("service_short_desc");
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block11Bytes, _wl_block11);

    	}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
      if(rset != null )rset.close();
	 
	  rset=stmt.executeQuery(clinicSectionSql);
	
		if(rset!=null)
		{
		

            _bw.write(_wl_block14Bytes, _wl_block14);

			int counter=0;
			while(rset.next())
			{
				counter++;
				clinicSectionName=rset.getString("clinicSectionName");
				clinicSectionCode=rset.getString("clinicSectionCode");
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clinicSectionCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clinicSectionName));
            _bw.write(_wl_block17Bytes, _wl_block17);
                
			}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}

      if(rset != null )rset.close();
	 

            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);

	
}
}
else if(mrsectionName.equals("mr_section_type"))
	{
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'  onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
	   if(!sectionType.equals("")){
		   	   
	   if(sectionType.equals("C"))
		{
	    if(seperatefile.equals("N")){
			
		sql_2="select mr_section_code,short_name from mr_section where facility_id='"+facilityid+"' and mr_section_type ='C'  and eff_status='E' order by short_name";
		rset=stmt.executeQuery(sql_2);
		}
		}else if(sectionType.equals("D"))
		{
		sql_2="select mr_section_code,short_name from mr_section where facility_id='"+facilityid+"' and mr_section_type = 'D' and eff_status='E' order by short_name";
		rset=stmt.executeQuery(sql_2);
		}
		
		if(rset!=null)
			{
			while(rset.next())
				{
				  mrcode=rset.getString(1);
				  mrdesc=rset.getString(2);
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(mrdesc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(mrcode));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
			}

		 if(rset != null ) rset.close();
		 
	 if(toPopulatefs.equals("populatefs"))
    {
	 
	  if(sectionType.equals("C")){
	  sql_1 =" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityid+"' and  permanent_file_area_yn='N' and locn_identity = '"+centralValue+"' and eff_status = 'E' order by short_desc ";
	  }else if(sectionType.equals("D")){
	  sql_1 ="Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityid+"' and eff_status = 'E' and MR_LOCN_YN='Y' and permanent_file_area_yn='Y' and locn_identity = '"+centralValue+"' order by short_desc ";
	  
	  }
	rset = stmt.executeQuery(sql_1);  
	if(rset != null) 
	{

            _bw.write(_wl_block26Bytes, _wl_block26);
              
		while( rset.next() ) 
		{
		String fs_locn_code=rset.getString("fs_locn_code");
		String short_desc=rset.getString("short_desc");     	

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(fs_locn_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block30Bytes, _wl_block30);
     		
		}
	}           
 
         if(rset != null ) rset.close();
	}
  }
  else
  {	    		
	 if(toPopulatefs.equals("populatefs"))
    { 	 
	  sql_1 =" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityid+"' and  permanent_file_area_yn='N' and locn_identity = '"+centralValue+"' and eff_status = 'E' order by short_desc "; 
    }
	rset = stmt.executeQuery(sql_1);  
	if(rset != null) 
	{

            _bw.write(_wl_block26Bytes, _wl_block26);
              
		while( rset.next() ) 
		{
		String fs_locn_code=rset.getString("fs_locn_code");
		String short_desc=rset.getString("short_desc");     	

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(fs_locn_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block30Bytes, _wl_block30);
     		
		}
	}           
 
         if(rset != null ) rset.close();
	}


}
else if(toPopulatefs.equals("populatevs"))
{
	 String vitalsgncode="";
	 out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");

	 String sql="select vital_signs_battery_id,multi_speciality_yn from am_speciality where eff_status='E' and speciality_code='"+speciality+"' order by short_desc";//modified for the crf - Bru-HIMS-CRF-0198
			
	   rset = stmt.executeQuery(sql);  
	 	 if(rset != null)
			{
				while (rset.next())
				{
					vitalsgncode=rset.getString("vital_signs_battery_id");
					multi_speciality_yn=rset.getString("multi_speciality_yn");//Added for the CRf - Bru-HIMS-CRf-0198
				}
				
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(vitalsgncode));
            _bw.write(_wl_block32Bytes, _wl_block32);

				//Added for the CRF - Bru-HIMS - CRF - 0198
				if(multi_speciality_yn.equals("Y")){
            _bw.write(_wl_block33Bytes, _wl_block33);
}
			}

		if(rset != null )rset.close();
	   
		}else if(toPopulatefs.equals("populateDF"))
		{
		
		StringBuffer dfsql=new StringBuffer();

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
		
		if(fmInstallyn.equals("Y"))
		{
			dfsql.append("select a.file_type_code file_type_code,b.short_desc  file_type_desc from fm_file_type_for_fsl a,mr_file_type b where b.facility_id ='"+facilityid+"'  and a.facility_id = b.facility_id and a.fs_locn_code ='"+defaultlocn+"' and a.file_type_code = b.file_type_code "); 
		   if((levelfcare.equals("A"))&&(!callfunction.equals("DaycareUnit")))
			 dfsql.append(" and b.appl_to_op='Y'");
			else if((levelfcare.equals("A"))&&(callfunction.equals("DaycareUnit")))
			 dfsql.append(" and b.appl_to_dc='Y'");
			else if(levelfcare.equals("E"))
             dfsql.append(" and b.appl_to_em='Y'");
		}
		else if(fmInstallyn.equals("N"))
		{
			dfsql.append("select file_type_code,SHORT_DESC file_type_desc from mr_file_type  	where facility_id ='"+facilityid+"' and EFF_STATUS = 'E'");
			if((levelfcare.equals("A"))&&(!callfunction.equals("DaycareUnit")))
			 dfsql.append(" and appl_to_op='Y'");
			else if((levelfcare.equals("A"))&&(callfunction.equals("DaycareUnit")))
			 dfsql.append(" and appl_to_dc='Y'");
			else if(levelfcare.equals("E"))
             dfsql.append(" and appl_to_em='Y'");
		} 
			dfsql.append(" order by file_type_desc ");
		 
		
			dfstmt=con.createStatement();
			dfrset=dfstmt.executeQuery(dfsql.toString());

			if(dfrset!=null)
			{
				while(dfrset.next())
				{
					  default_code=dfrset.getString("file_type_code");
					  default_desc=dfrset.getString("file_type_desc");
					  
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(default_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(default_code));
            _bw.write(_wl_block36Bytes, _wl_block36);

				}
			}
		     if(dfrset != null )dfrset.close();
			 if(dfstmt != null )dfstmt.close();
			 dfsql.setLength(0);
			 
		}
		 else if(toPopulatefs.equals("populatept"))
		{
			String sql="";
			String primaryrestype="";
			String primaryrestypedesc="";
			String primaryresclass=(request.getParameter("primary_res_class") == null)?"":request.getParameter("primary_res_class");
			out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
			if(primaryresclass.equals(""))
			{
			
            _bw.write(_wl_block37Bytes, _wl_block37);

				if(levelfcare.equals("E"))
				{
					
            _bw.write(_wl_block38Bytes, _wl_block38);

				}else{
		 
		 
            _bw.write(_wl_block39Bytes, _wl_block39);

			}
			}
			if(!primaryresclass.equals(""))
			{
			if(primaryresclass.equals("P"))
			{
			  if(levelfcare.equals("A")){
			 
            _bw.write(_wl_block40Bytes, _wl_block40);

			  }else	 if(levelfcare.equals("E"))
				{
					
            _bw.write(_wl_block41Bytes, _wl_block41);

				}

				 sql="select pract_type, desc_sysdef from am_pract_type where eff_status='E' order by seq_no";
			}
			else {
				
				if(levelfcare.equals("A")){
				
            _bw.write(_wl_block42Bytes, _wl_block42);

			}else if(levelfcare.equals("E"))
				{
					
            _bw.write(_wl_block43Bytes, _wl_block43);

				}
			if(primaryresclass.equals("R"))
			{
			sql="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' order by short_desc";
			}else if(primaryresclass.equals("E"))
			{
				
				sql="select resource_type,short_desc from am_resource_type where resource_class='E' order by short_desc";
			 }else if(primaryresclass.equals("O"))
			{
				sql="select resource_type,short_desc from am_resource_type where resource_class='O' order by short_desc";
			}
		
			}
				rset=stmt.executeQuery(sql);
				if(rset != null)
				{
					while(rset.next())
					{
						primaryrestype=rset.getString(1);
						primaryrestypedesc=rset.getString(2);
						
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(primaryrestypedesc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(primaryrestype));
            _bw.write(_wl_block46Bytes, _wl_block46);


					}
				}				
			
			if(rset != null ) rset.close();
			
			}
			
		}
		else if(toPopulatefs.equals("populateOther"))
	{
		String oth_class=request.getParameter("oth_class");
		if(oth_class == null) oth_class="";
	

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
		String osql="";
		String othres="";
		String othresDesc="";
		if(!oth_class.equals(""))
		{
		if(oth_class.equals("R"))
			{
			osql="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' order by short_desc";
			}else if(oth_class.equals("E"))
			{
				
				osql="select resource_type,short_desc from am_resource_type where resource_class='E' order by short_desc";
			 }else if(oth_class.equals("O"))
			{
				osql="select resource_type,short_desc from am_resource_type where resource_class='O' order by short_desc";
			}
			rset=stmt.executeQuery(osql);
			if(rset != null)
			{
				while(rset.next())
				{
				  othres=rset.getString(1);
				  othresDesc=rset.getString(2);
				  
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(othresDesc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(othres));
            _bw.write(_wl_block49Bytes, _wl_block49);

				}
			}
		}
			if(rset != null) rset.close();
	}else if(toPopulatefs.equals("pract_check"))
	{
		String pract_name=request.getParameter("pract_obj");
		if(pract_name == null) pract_name="";
		String cliniccode=request.getParameter("cliniccode");
		if(cliniccode == null) cliniccode="";
		int practcnt=0;
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");

		String sql="select count(*) from op_pract_for_clinic where clinic_code='"+cliniccode+"' and resource_class='P' and "+pract_name+" ='W' ";

		rset=stmt.executeQuery(sql);
		if(rset != null)
		{
			if(rset.next())
			{
				practcnt=rset.getInt(1);
			}
		}
		if(rset != null) rset.close();
		if(practcnt > 0)
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
	}else if(toPopulatefs.equals("pract_check1"))
	{
		String pract_name=request.getParameter("pract_obj");
		if(pract_name == null) pract_name="";
		String cliniccode=request.getParameter("cliniccode");
		if(cliniccode == null) cliniccode="";
		int practcnt=0;
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
		
		for(int i=1;i<=5;i++)
		{

		String sql="select count(*) from op_pract_for_clinic where clinic_code='"+cliniccode+"' and resource_class='P' and working_week_"+i+"_day_"+pract_name+" ='W' ";
		rset=stmt.executeQuery(sql);
		if(rset != null)
		{
			if(rset.next())
			{
				practcnt=rset.getInt(1);
			}
		}
		if(rset != null) rset.close();
		if(practcnt > 0)
		{
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
}else{
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
	}
  }	
if (stmt != null) stmt.close();   
	
}catch(Exception e) { 
	e.printStackTrace();
		}
    finally
    {
		try{

			if(rset != null) rset.close();
			if(stmt != null) stmt.close();

		}catch(Exception e){
			e.printStackTrace();
		}
       if(con!=null) ConnectionManager.returnConnection(con,request);
    }
        out.println("</form></body></html>");       
                            

            _bw.write(_wl_block60Bytes, _wl_block60);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
