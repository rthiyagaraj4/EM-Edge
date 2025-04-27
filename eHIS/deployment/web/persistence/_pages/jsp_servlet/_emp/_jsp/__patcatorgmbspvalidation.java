package jsp_servlet._emp._jsp;

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
import eCommon.Common.*;

public final class __patcatorgmbspvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatCatOrgMbspValidation.jsp", 1743485019710L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n <Script src=\"../../eMP/js/PatientRegistration4.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n <Script>\n function checkForEmpSrvNum(obj) { \n alert(\"inside patcatmbspvalidation.jsp page 17\");\nvar pract_id=parent.frames[1].frames[1].document.forms[0].loginUser.value\nvar empServNumCode=parent.frames[1].frames[1].document.forms[0].alt_id1_type.value;  \nvar empservno=parent.frames[1].frames[1].document.forms[0].alt_id1_no.value;\nvar family_link_no=\'\'; //parent.frames[1].frames[1].document.forms[0].family_link_no.value;\n\n\t//if (family_link_no!=\"\" && empservno!=\"\") {\n\t\tvar xmlDoc = \"\";\n\t\tvar xmlHttp = new XMLHttpRequest()\n\t\txmlStr =\"<root><SEARCH action=\\\"EmpServNo\\\" /></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\'POST\',\'../../eMP/jsp/MPIntermediate.jsp?empServNumCode=\'+empServNumCode+\'&empservno=\'+empservno+\'&headId=\'+obj.value+\'&pract_id=\'+pract_id+\'&fieldName=\'+obj.name,false);\t\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText=xmlHttp.responseText;\n\t\tresponseText=TrimStr(responseText); \n\t\tif(responseText==\"\" || responseText==\"null\"){\t \n\t\tparent.frames[1].frames[1].document.forms[0].emp_service_no.value=\'\';\t\n\t\t}\n\t\telse if(responseText!=\"\"){ \n\t\tparent.frames[1].frames[1].document.forms[0].emp_service_no.value=responseText;\n\t\t}\n}\n\n </Script>\n</head>\n<body class=MESSAGE onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\n\t\tvar n=parent.frames[1].document.forms[0].sub_org.options.length;\n\t\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\tparent.frames[1].document.forms[0].sub_org.remove(0);\n\t\t}\n\t\tvar tp =\" --------- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---------- \"\n\t\tvar opt=parent.frames[1].document.createElement(\"OPTION\");\n\t\topt.text=tp;\n\t\topt.value=\"\";\n\t\tparent.frames[1].document.forms[0].sub_org.add(opt);\n\n\t\tvar opt1=parent.frames[1].document.createElement(\"OPTION\");\n\t\topt1.text=\" ALL \";\n\t\topt1.value=\"*ALL\";\n\t\tparent.frames[1].document.forms[0].sub_org.add(opt1);\n\n\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar oOption = parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\toOption.text=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\toOption.value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].sub_org.add(oOption);\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n        <script>\n\t\t\tparent.sub_frame.document.forms[0].sub_org.value=\'*ALL\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<script>\n\t\tvar n=parent.sub_frame.document.forms[0].sub_org.options.length;\n\t\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\tparent.sub_frame.document.forms[0].sub_org.remove(0);\n\t\t}\n\t\tvar tp =\" --------- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---------- \"\n\t\tvar opt=parent.sub_frame.document.createElement(\"OPTION\");\n\t\topt.text=tp;\n\t\topt.value=\"\";\n\t\tparent.sub_frame.document.forms[0].sub_org.add(opt);\n\n\t\tvar opt1=parent.sub_frame.document.createElement(\"OPTION\");\n\t\topt1.text=\" ALL \";\n\t\topt1.value=\"*ALL\";\n\t\tparent.sub_frame.document.forms[0].sub_org.add(opt1);\n\n\t</script>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar oOption = parent.sub_frame.document.createElement(\"OPTION\");\n\t\t\t\t\t\toOption.text=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\t\tif(oOption.value==\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" && \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"!=\'\')\n                            oOption.selected=true; \n\t\t\t\t\t\tparent.sub_frame.document.forms[0].sub_org.add(oOption);\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n        <script>parent.sub_frame.document.forms[0].sub_org.value=\'*ALL\';</script>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<!--\n\t   <script>\n\t\tvar n=parent.frames[1].frames[1].document.forms[0].sub_organization.options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.remove(0);\n\t\t}\n\t\tvar tp =\" -- ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" -- \"\n\t\tvar opt=parent.frames[1].frames[1].document.createElement(\"OPTION\");\n\t\topt.text=tp;\n\t\topt.value=\"\";\n\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.add(opt);\n\n\t\t</script>\n\t\t-->\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<script>\t\t\t\n\t\tvar sel = parent.frames[1].frames[1].document.forms[0].selected_sub.value;\t\t\n\t\tif ( sel != \'\' )\n\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.value = sel;\n\t\t\t\n\t\tvar fType = parent.frames[1].frames[1].document.forms[0].CalledFromFunction.value;\n\t\tvar mem_type = parent.frames[1].frames[1].document.forms[0].family_org_membership.value;\n\t\tvar prev_mem_type = parent.frames[1].frames[1].document.forms[0].prev_mem_type.value;\n\t\tif  (fType==\'ChangePatDtls\')  \n\t\t{\t\n\t\t\tif ( ((mem_type==\'2\') || (mem_type==\'3\') || (mem_type==\'4\')) && (prev_mem_type!=\'1\') )\n\t\t\t{\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.disabled=true;  \n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=true;  \n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=true;  \n\t\t\t\tparent.frames[1].frames[1].document.forms[0].organization.disabled=true;\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=true;\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].rel.style.visibility=\'visible\';\n\t\t\t\tif ( (mem_type==\'4\') && (parent.frames[1].frames[1].document.forms[0].family_link_no.value==\'\') )\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].rel.style.visibility=\'hidden\';\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.disabled=false;\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=false;\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=false;\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].organization.disabled=false;\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=false;\n\t\t\t\tif (parent.frames[1].frames[1].document.forms[0].family_link_no==\'\')\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"relationship_to_head\").value = parent.frames[1].frames[1].document.getElementById(\"org_member_relationship_code\").value;\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].relationship_to_head.disabled=true;\n\t\t\t\t}\n\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].rel)\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].rel.style.visibility=\'hidden\';\n\t\t\t}\n\t\t}\n\t\t/*If called from  MP-> Register Patient->Query->Change Demographics*/\n\t\tif (parent.frames[1].frames[1].document.getElementById(\"function_id\").value == \'PAT_REG\')\n\t\t{\n\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.disabled=true;  \n\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=true;  \n\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=true;  \n\t\t\tparent.frames[1].frames[1].document.forms[0].organization.disabled=true;\n\t\t\tparent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=true;\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\t   \n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].pat_cat_code_exp_date.value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].exp_val_appl_yn.value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].pat_cat_code_exp_date.disabled=false;\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].imgCatExpDate.disabled=false;\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].imgCatExpDateMan.style.visibility=\'visible\';\n\t\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t   \n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].pat_cat_code_exp_date.value=\t\"\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].exp_val_appl_yn.value=\"\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].pat_cat_code_exp_date.disabled=true;\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].imgCatExpDate.disabled=true;\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].imgCatExpDateMan.style.visibility=\'hidden\';\n\t\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t <script>\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].employ_addr_line1)\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].employ_addr_line1.value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" ;\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].employ_addr_line2)\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].employ_addr_line2.value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" ;\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].employ_addr_line3)\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].employ_addr_line3.value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" ;\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].employ_addr_line4)\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].employ_addr_line4.value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" ;\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].contact3_res_town_code)\n\t\t\t{\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].contact3_res_town_code.value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].e_town.value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t}\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].contact3_region_code)\n\t\t\t{\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].contact3_region_code.value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].e_region.value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t}\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].contact3_res_area_code)\n\t\t\t{\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].contact3_res_area_code.value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].e_area.value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t}\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].employ_postal_code)\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].employ_postal_code.value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].empyr_country_desc)\n\t\t\t{\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].empyr_country_desc.value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].empyr_country_code.value = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t}\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].res3_tel_no)\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].res3_tel_no.value = \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\tif(parent.frames[1].frames[1].document.forms[0].empyr_off_tel_no)\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].empyr_off_tel_no.value = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\tif (parent.frames[1].frames[1].document.forms[0].empyr_contact_name)\n\t\t\tparent.frames[1].frames[1].document.forms[0].empyr_contact_name.value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t <script>\n\t\t\t\t\t\t\talert(getMessage(\"REL_MEM_EXISTS\",\'MP\'));\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].prev_mem_type.value=\"1\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].alt_id1_no.value=parent.frames[1].frames[1].document.forms[0].alt_id1_db.value;\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].alt_id1_no.disabled=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].family_org_membership.focus();\n\t\t\t\t\t\t\tself.location.href = \"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t  </script>\n\t\t\t\t  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t<script>\t\t\n\t\t\t\t\talert(getMessage(\"DUP_ALTID_FOR_MEMBER\",\'MP\'));//\" Duplicate Organization Member ID - Cannot Proceed\");\n\t\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"alt_id1_no\").value=parent.frames[1].frames[1].document.forms[0].alt_id1_db.value;\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].alt_id1_no.focus();\n\t\t\t\t\tself.location.href = \"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t</script>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<script>\t\t\t\n\t\t\t if ((parent.frames[1].frames[1].document.getElementById(\"family_org_membership\"))&&(parent.frames[1].frames[1].document.forms[0].family_org_membership.value==\'1\'))\n\t\t\t {\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\talert(getMessage(\"DUP_ALTID_FOR_MEMBER\",\'MP\'));//\" Duplicate Organization Member ID - Cannot Proceed\");\n\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"family_org_membership\").value=\'\';\n\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"alt_id1_no\").value=\'\';\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].alt_id1_no.focus();\n\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].relationship_to_head_desc)\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].relationship_to_head_desc.value=\'\';\n\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].relationship_to_head)\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].relationship_to_head.value=\'\';\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.disabled=true;\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=true;\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=true;\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_desc.value=\'\';\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.value=\'\';\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].org_sub_org.style.visibility=\'hidden\';\n\t\t\t\tself.location.href = \"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t }\n\t\t\t</script>\n\t\t\t\n\t\t\t<!-- Added by Thamizh selvi on 13th Jan 2017 against MO-CRF-20119 Start-->\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t if ((parent.frames[1].frames[1].document.getElementById(\"family_org_membership\"))&&((parent.frames[1].frames[1].document.forms[0].family_org_membership.value==\'2\') || (parent.frames[1].frames[1].document.forms[0].family_org_membership.value==\'3\') ))\n\t\t\t\t\t {\t\n\t\t\t\t\t\talert(getMessage(\"ORG_MEMB_ID_SUSPENDED\",\'MP\'));\n\t\t\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"family_org_membership\").value=\'\';\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"alt_id1_no\").value=\'\';\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].alt_id1_no.focus();\n\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].rel.style.visibility=\'hidden\';\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].alt1_gif.style.visibility=\'hidden\';\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].org_sub_org.style.visibility=\'hidden\';\n\t\t\t\t\t\tself.location.href = \"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t }\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<!-- Added by Thamizh selvi on 13th Jan 2017 against MO-CRF-20119 End-->\n\t\t  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].organization.disabled=false;\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=false;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].organization.disabled=true;\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=true;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" \n\t\t\t\t  <script>\n\t\t\t\t   parent.frames[1].frames[1].document.forms[0].sub_organization.disabled=false\n\t\t\t\t   parent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=false\n\t\t\t\t   parent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=false\n\t\t\t\t  </script>\n\t\t\t\t  ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t<!--\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar oOption = parent.frames[1].frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\toOption.text=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =";\n\t\t\t\t\t\toOption.value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.add(oOption);\n\t\t\t\t\t</script>\n\t\t\t\t\t-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t//var oOption = parent.frames[1].frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t//oOption.text=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t\t\t\t//oOption.value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\t\t\t//parent.frames[1].frames[1].document.forms[0].sub_organization.add(oOption);\t\t\t  \n\t\t\t\t\t//parent.frames[1].frames[1].document.forms[0].sub_organization.selectedIndex=1;\t\t\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=true;\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=true;\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_desc.value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].organization.disabled=false;\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=false;\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].organization.value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].org_id.value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].organization.disabled=true;\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=true;\n\t\t\t\t   </script>\n\t\t\t\t ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="  <script>\n\t\t\t\t\t if (parent.frames[1].frames[1].document.forms[0].family_link_no)\n\t\t\t\t\t{\t\t\t\t\t \n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].family_link_no.value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"head_pat_name\").innerText=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].family_link_no.disabled=true;\n\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\tcheckForEmpSrvNum(parent.frames[1].frames[1].document.forms[0].family_link_no);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[1].getPatCategory();\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].head_pat_search_reg.disabled=true;\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].relationship_to_head_desc)\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].relationship_to_head_desc.disabled=false;\n\t\t\t\t\t\t//parent.frames[1].frames[1].document.forms[0].relationship_to_head_desc.focus();\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].relationship_to_head_id.disabled=false;\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].relationship_to_head_code_id)\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].relationship_to_head_code_id.focus();\n\t\t\t\t\t\t//parent.frames[1].frames[1].document.forms[0].relationship_to_head.disabled=false;\n\t\t\t\t\t\t//parent.frames[1].frames[1].document.forms[0].relationship_to_head.focus();\n\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t<!--\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar n=parent.frames[1].frames[1].document.forms[0].sub_organization.options.length;\n\t\t\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.remove(0);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tvar tp =\" --- ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" --- \"\n\t\t\t\t\t\t\tvar opt=parent.frames[1].frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\t\topt.value=\"\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.add(opt);\n\t\t\t\t\t\t\t-->\n\n\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\talert(getMessage(\"ORG_MEM_NOT_EXISTS\",\'MP\'));\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].family_org_membership.value=\'\';\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].alt_id1_no.value=\'\';\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].alt_id1_no.focus();\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.disabled=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_org_desc.value=\'\';\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].sub_organization.value=\'\';\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].organization.value=\"\";\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].family_link_no)\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].family_link_no.value=\"\";\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].relationship_to_head)\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].relationship_to_head.value=\"\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].organization.disabled=true;\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=true;\n\t\t\t\t\t\t</script>\n\t\t\t\t ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t <script>\n\t\t\t\tif (parent.frames[1].frames[1].document.forms[0].family_org_membership.value != \"1\")\n\t\t\t\t{\t  \n\t\t\t\t\t\talert(getMessage(\"REL_MEM_EXISTS\",\'MP\'));\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].family_org_membership.value=\"1\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].prev_mem_type.value=\"1\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].alt_id1_no.disabled=true;\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].family_org_membership.focus();\n\t\t\t\t\t\tself.location.href = \"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t}\n\t\t\t  </script>\n\t\t\t  ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t<script>parent.frames[1].frames[1].makeOrgMandate(parent.frames[1].frames[1].document.forms[0].family_org_membership)</script>\n\t\t\t  ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<!--\n\t   <script>\n\t\tvar n=parent.frames[1].document.Patient_Search_Form.sub_organization.options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\tparent.frames[1].document.Patient_Search_Form.sub_organization.remove(0);\n\t\t}\n\t\tvar tp =\"--- ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" --- \"\n\t\tvar opt=parent.frames[1].document.createElement(\"OPTION\");\n\t\topt.text=tp;\n\t\topt.value=\"\";\n\t\tparent.frames[1].document.Patient_Search_Form.sub_organization.add(opt);\n\t\t</script>\n\t\t-->\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t<script>\n\t\t\t//parent.frames[1].document.Patient_Search_Form.sub_organization.disabled=false;\n\t\t\tparent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.sub_org_desc.disabled=false;\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t<!--\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar oOption = parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\toOption.text=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\n\t\t\t\t\t\tparent.frames[1].document.Patient_Search_Form.sub_organization.add(oOption);\n\t\t\t\t\t</script>\n\t\t\t\t-->\n\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	public String singleToDoubleQuotes(String strDB)
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int count=0;
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String param = request.getParameter("param")==null?"":request.getParameter("param");
	String subid=request.getParameter("subid")==null?"":request.getParameter("subid");
	String defaultSelect1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
	
		String organization = request.getParameter("organization")==null?"":request.getParameter("organization");
		String code = "";
		String desc = "";

		Boolean isSuspendReinstateRelative = CommonBean.isSiteSpecific(con,"MP","SUSPEND_REINSTATE_RELATIONSHIP");//Added by Thamizh selvi on 11th Jan 2017 against MO-CRF-20119


	if(param.equals("QUERY"))
	{	 
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		String record_exist="";
		String	sql = " select FAMILY_ORG_SUB_ID, FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where language_id='"+locale+"' and FAMILY_ORG_ID = '"+organization+"' and EFF_STATUS = 'E' order by FAMILY_ORG_SUB_NAME  ";
		rs = stmt.executeQuery(sql);
		if( rs!=null )
		{
			while(rs.next())
			{
				code = rs.getString("FAMILY_ORG_SUB_ID");
				desc = rs.getString("FAMILY_ORG_SUB_NAME");
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(code));
            _bw.write(_wl_block12Bytes, _wl_block12);
 record_exist="true";
			}
		}
		if(record_exist.equals(""))
            _bw.write(_wl_block13Bytes, _wl_block13);

	}
	else
	if(param.equals("CREATE"))
	{
		
            _bw.write(_wl_block14Bytes, _wl_block14);

		String record_exist="";
		String	sql = " select FAMILY_ORG_SUB_ID, FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where language_id='"+locale+"' and FAMILY_ORG_ID = '"+organization+"' and EFF_STATUS = 'E' order by FAMILY_ORG_SUB_NAME  ";
		rs = stmt.executeQuery(sql);
		if( rs!=null )
		{
			while(rs.next())
			{
				code = rs.getString("FAMILY_ORG_SUB_ID");
				desc = rs.getString("FAMILY_ORG_SUB_NAME");
				
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(subid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(subid));
            _bw.write(_wl_block18Bytes, _wl_block18);

						record_exist="true";
			}

		}
		if(subid.equals("*ALL"))
            _bw.write(_wl_block19Bytes, _wl_block19);
}
	else
	if(param.equals("PATREG"))  /*If the function is called from Patient Registration Or ChangePatDtls*/
	{
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(defaultSelect1));
            _bw.write(_wl_block21Bytes, _wl_block21);


		int no_of_rec = 0;

	    String	sql = " select FAMILY_ORG_SUB_ID, FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where language_id='"+locale+"' and FAMILY_ORG_ID = '"+organization+"' and EFF_STATUS = 'E' order by FAMILY_ORG_SUB_NAME  ";
		rs = stmt.executeQuery(sql);
		if( rs!=null )
		{
			while(rs.next())
			{
				no_of_rec++;

				code = rs.getString("FAMILY_ORG_SUB_ID");
				desc = rs.getString("FAMILY_ORG_SUB_NAME");
				//out.println("<script>	var oOption = parent.frames[1].frames[1].document.createElement('OPTION');						oOption.text='"+desc+"';						oOption.value='"+code+"';	parent.frames[1].frames[1].document.forms[0].sub_organization.add(oOption);		</script> ");
			}
		}/*If called from Change Pat Details the previous value should be assigned*/

		if(no_of_rec==1)
		{			out.println("<script>parent.frames[1].frames[1].document.forms[0].sub_organization.value ='"+code+"';parent.frames[1].frames[1].document.forms[0].sub_org_desc.value ='"+desc+"';parent.frames[1].frames[1].document.forms[0].selected_sub.value='"+code+"'; parent.frames[1].frames[1].getPatCategory();</script>");
		}

		
            _bw.write(_wl_block22Bytes, _wl_block22);

	}
	else
	 if (param.equals("CATEXP"))
	{
		String category = checkForNull(request.getParameter("category"),"");
		String entitlement_by_pat_cat_yn = checkForNull(request.getParameter("entitlement_by_pat_cat_yn"),"N");
		String sql = "SELECT pat_cat_code, exp_val_appl_yn, to_char(sysdate+exp_period_in_days,'dd/mm/yyyy') exp_date FROM mp_pat_category,dual WHERE eff_status = 'E' ORDER BY 2";
		rs = stmt.executeQuery(sql);
		if( rs!=null )
		{
			while(rs.next())
			{
				code = rs.getString("pat_cat_code");
				if (category.equals(code))
				{
					String exp_val_appl_yn =  checkForNull(rs.getString("exp_val_appl_yn"),"N");
					String exp_date =  rs.getString("exp_date");
					if 	( (entitlement_by_pat_cat_yn.equals("Y")) && (exp_val_appl_yn.equals("Y")))
					{
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(exp_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(exp_val_appl_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
		
			        } else {
		
            _bw.write(_wl_block26Bytes, _wl_block26);

					}
			}
		}
	}
	}
	else
	 if (param.equals("COPYEMP"))
	{
		 String org_id = checkForNull(request.getParameter("org_id"));
		 String org_sub_id = checkForNull(request.getParameter("org_sub_id"));
		 String family_org_sub_id		= "";
		 String family_org_sub_name		= "";
		 String org_contact_name		= "";
		 String org_addr_line_1			= "";
		 String org_addr_line_2			= "";
		 String  org_addr_line_3		= "";
		 String org_addr_line_4			= "";
		 String  res_area_code			= ""; 
		 String res_town_code			= ""; 
		 String region_code				= "";
		 String  postal_code			= "";
		 String country_code			= ""; 
		 String res_tel_no				= ""; 
		 String off_tel_no				= "";
		 String res_area_desc			= "";
		 String res_town_desc			= "";
		 String res_region_desc			= "";
		 String res_country_desc		= "";
		  if(!org_sub_id.equals(""))
		  {
	 		String sql="SELECT a.family_org_id, a.family_org_sub_id, a.family_org_sub_name,a.org_contact_name, a.org_addr_line_1, a.org_addr_line_2,a.org_addr_line_3, a.org_addr_line_4, a.res_area_code res_area_code,(SELECT long_desc FROM mp_res_area_lang_vw WHERE language_id='"+locale+"' and res_area_code = a.res_area_code) res_area_desc,  a.res_town_code res_town_code,(SELECT long_desc FROM mp_res_town_lang_vw  WHERE language_id='"+locale+"' and res_town_code = a.res_town_code) res_town_desc,a.region_code region_code,(SELECT short_desc FROM mp_region_lang_vw WHERE language_id='"+locale+"' and region_code = a.region_code) res_region_desc,a.postal_code postal_code, a.country_code,(SELECT long_name FROM mp_country_lang_vw  WHERE language_id='"+locale+"' and country_code = a.country_code) res_country_desc, a.res_tel_no,  a.off_tel_no FROM mp_family_org_sub_lang_vw a where language_id='"+locale+"' and a.FAMILY_ORG_SUB_ID='"+org_sub_id+"' and a.family_org_id='"+org_id+ "'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next())
	        {
               org_id						= checkForNull(rs.getString("FAMILY_ORG_ID"));
               family_org_sub_id		= checkForNull(rs.getString("FAMILY_ORG_SUB_ID"));
               family_org_sub_name	= checkForNull(rs.getString("FAMILY_ORG_SUB_NAME"));
               org_contact_name		= checkForNull(rs.getString("ORG_CONTACT_NAME"));
               org_addr_line_1			= checkForNull(rs.getString("ORG_ADDR_LINE_1"));
               org_addr_line_2			= checkForNull(rs.getString("ORG_ADDR_LINE_2"));
               org_addr_line_3			= checkForNull(rs.getString("ORG_ADDR_LINE_3"));
               org_addr_line_4			= checkForNull(rs.getString("ORG_ADDR_LINE_4"));
               res_area_code			= checkForNull(rs.getString("RES_AREA_CODE"));
               res_town_code			= checkForNull(rs.getString("RES_TOWN_CODE"));
               region_code				= checkForNull(rs.getString("REGION_CODE"));
               postal_code				= checkForNull(rs.getString("POSTAL_CODE"));
               country_code			= checkForNull(rs.getString("COUNTRY_CODE"));
               res_tel_no				= checkForNull(rs.getString("RES_TEL_NO"));
               off_tel_no				= checkForNull(rs.getString("OFF_TEL_NO"));
			   res_area_desc			= checkForNull(rs.getString("res_area_desc"));
			   res_town_desc			= checkForNull(rs.getString("res_town_desc"));
			   res_region_desc		= checkForNull(rs.getString("res_region_desc"));
			   res_country_desc		= checkForNull(rs.getString("res_country_desc"));
              
			}
		 }
		 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(org_addr_line_1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(org_addr_line_2));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(org_addr_line_3));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(org_addr_line_4));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(res_region_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(res_tel_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(off_tel_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(org_contact_name));
            _bw.write(_wl_block43Bytes, _wl_block43);

	  }
	else
	if (param.equals("CHKMEMBERSHIP"))
	{
		String patient_name="";
		String sql = "";
		String CalledFromFunction = checkForNull(request.getParameter("CalledFromFunction"),"");
		String alt_id1_no = checkForNull(request.getParameter("alt_id1_no"),"");
		String alt_id1_db = checkForNull(request.getParameter("alt_id1_db"),"");
		String patient_id = checkForNull(request.getParameter("patient_id"),"");
		String family_org_id_accept_yn = checkForNull(request.getParameter("family_org_id_accept_yn"),"");
		String membership_type = checkForNull(request.getParameter("membership_type"),"");
		ResultSet rset = null;

		if ( (family_org_id_accept_yn.equals("Y")) && (membership_type.equals("1")) && (CalledFromFunction.equals("ChangePatDtls")) && (!alt_id1_db.equals(alt_id1_no)) )
		{
			sql = " select count(*) count from mp_patient where (FAMILY_ORG_MEMBERSHIP='2' or FAMILY_ORG_MEMBERSHIP='3' ) and ALT_ID1_NO = '"+alt_id1_db+"'";
			rset = stmt.executeQuery(sql);
			if(rset.next())
			count = rset.getInt("count");
			if (rset != null) rset.close(); 
			if (count<0) 
			{
			  
            _bw.write(_wl_block44Bytes, _wl_block44);

			}
			/*To check for Organization member records with the given membership ID */
			sql = " select count(*) count from mp_patient where family_org_membership='1' and  ALT_ID1_NO = '"+alt_id1_no+"'";
			rset = stmt.executeQuery(sql);
			if(rset.next())
			count = rset.getInt("count");
			if (rset != null) rset.close();
			if (count>=1) 
			{
			  
            _bw.write(_wl_block45Bytes, _wl_block45);

			 }
	 }
	 else
	 {
		if (!patient_id.equals(""))
		 sql = " select count(*) count from mp_patient where family_org_membership='1' and	patient_id !='"+patient_id+"' and ALT_ID1_NO = '"+alt_id1_no+"'";
		else
		   sql = " select count(*) count from mp_patient where family_org_membership='1' and  ALT_ID1_NO = '"+alt_id1_no+"'";
		rset = stmt.executeQuery(sql);
		if(rset.next())
		count = rset.getInt("count");
		if (rset != null) rset.close();
		if (count>=1) 
		{
		  
            _bw.write(_wl_block46Bytes, _wl_block46);

			if(isSuspendReinstateRelative)
			{
				sql = "SELECT COUNT (*) COUNT FROM mp_patient WHERE family_org_membership ='1' AND alt_id1_no = '"+alt_id1_no+"' AND suspend_yn = 'Y'";
				rset = stmt.executeQuery(sql);
				if(rset.next())
				count = rset.getInt("count");
				if (rset != null) rset.close();
				if (count>=1) 
				{
				  
            _bw.write(_wl_block47Bytes, _wl_block47);
 } 
			} 
            _bw.write(_wl_block48Bytes, _wl_block48);

			sql = " select patient_id,decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  patient_name,family_org_id, family_org_sub_id from mp_patient where family_org_membership='1' and alt_id1_no = '"+alt_id1_no+"'";
			rset = stmt.executeQuery(sql);
			if (rset!=null)
			{
				rset.next();
				patient_id =  checkForNull(rset.getString("patient_id"));
				patient_name =  checkForNull(rset.getString("patient_name"));
				String family_org_id =  checkForNull(rset.getString("family_org_id"),"N");
				String family_org_sub_id =  checkForNull(rset.getString("family_org_sub_id"));
				if (family_org_id.equals(""))
				{
					
            _bw.write(_wl_block49Bytes, _wl_block49);

				}
				else
				{
					
            _bw.write(_wl_block50Bytes, _wl_block50);

				}
				if (family_org_sub_id.equals(""))
				{
					int no_of_rec = 0;
					sql = " select FAMILY_ORG_SUB_ID, FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_lang_vw where language_id='"+locale+"' and FAMILY_ORG_ID = '"+family_org_id+"' and EFF_STATUS = 'E' order by FAMILY_ORG_SUB_NAME ";
				   rset = stmt.executeQuery(sql);
				  
            _bw.write(_wl_block51Bytes, _wl_block51);

				  while(rset.next())
				  {
					code = rset.getString("FAMILY_ORG_SUB_ID");
					desc = rset.getString("FAMILY_ORG_SUB_NAME");
					no_of_rec++;
					
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(code));
            _bw.write(_wl_block54Bytes, _wl_block54);

					}

					if(no_of_rec==1)
					{			out.println("<script>parent.frames[1].frames[1].document.forms[0].sub_organization.value ='"+code+"';parent.frames[1].frames[1].document.forms[0].sub_org_desc.value ='"+desc+"';</script>");
					}

					if (rset != null) rset.close();
				}
				else
				{
					String 	 org_name = "";
					sql = " select  a.family_org_name, b.family_org_sub_name from mp_family_org_lang_vw a, mp_family_org_sub_lang_vw b where b.language_id='"+locale+"' and a.family_org_id = '"+family_org_id+"' and a.family_org_id = b.family_org_id and family_org_sub_id='"+family_org_sub_id+"'";
					rset = stmt.executeQuery(sql);
					if (rset.next())
					{
						  org_name = rset.getString("family_org_name");
						  desc = rset.getString("family_org_sub_name");
					}
				 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(family_org_sub_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(family_org_sub_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(org_name));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(family_org_id));
            _bw.write(_wl_block61Bytes, _wl_block61);

				}
				 
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block64Bytes, _wl_block64);

			}
			if (rset != null) rset.close();
	 }
	else //  Count == 0 and Organization membership flag is checked
	if ( (count==0) && (family_org_id_accept_yn.equals("Y")) && ((membership_type.equals("2")) || (membership_type.equals("3"))) )
			{
				
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(defaultSelect1));
            _bw.write(_wl_block66Bytes, _wl_block66);

			}
	}
	}
	else
	if (param.equals("CHK_RELATED_MEM"))
	{
		String alt_id1_no = checkForNull(request.getParameter("alt_id1_no"),"");
		String sql = " select count(*) count from mp_patient where (FAMILY_ORG_MEMBERSHIP='2' or FAMILY_ORG_MEMBERSHIP='3' ) and ALT_ID1_NO = '"+alt_id1_no+"'";
		ResultSet rset = null;
		 count = 0;
		rset = stmt.executeQuery(sql);
		if(rset.next())
		count = rset.getInt("count");
		if (rset != null) rset.close(); 
		if (count>0) 
		{
		  
            _bw.write(_wl_block67Bytes, _wl_block67);

		}
		  else
            _bw.write(_wl_block68Bytes, _wl_block68);

	}
	else
	if(param.equals("PATSEARCH"))  /*If the function is called from Patient Search*/
	{
		
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(defaultSelect1));
            _bw.write(_wl_block70Bytes, _wl_block70);

			int no_of_rec = 0;
	   String	sql = " select FAMILY_ORG_SUB_ID, FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where language_id='"+locale+"' and FAMILY_ORG_ID = '"+organization+"' and EFF_STATUS = 'E' order by FAMILY_ORG_SUB_NAME  ";
		rs = stmt.executeQuery(sql);
		if( rs!=null )
		{
		
            _bw.write(_wl_block71Bytes, _wl_block71);

			while(rs.next())
			{
				code = rs.getString("FAMILY_ORG_SUB_ID");
				desc = rs.getString("FAMILY_ORG_SUB_NAME");
				no_of_rec++;
				
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(code));
            _bw.write(_wl_block73Bytes, _wl_block73);

			}
		}
		if(no_of_rec==1)
		{	
			out.println("<script>parent.frames[2].document.forms[0].sub_organization.value ='"+code+"';parent.frames[2].document.forms[0].sub_org_desc.value ='"+desc+"';</script>");
		}		
	}
	}catch (Exception e){
		out.println(e);
	}
	finally{
		if(stmt != null) stmt.close();
		if(rs!=null) rs.close();
		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block74Bytes, _wl_block74);
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
