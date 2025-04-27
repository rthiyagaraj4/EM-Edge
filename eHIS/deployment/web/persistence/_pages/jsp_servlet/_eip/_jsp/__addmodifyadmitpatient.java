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
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyadmitpatient extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addModifyAdmitPatient.jsp", 1742365615177L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eMP/jsp/PatientAddressLegends.jsp", 1744875458541L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block7_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block7_2Bytes = _getBytes( _wl_block7_2 );

    private final static java.lang.String  _wl_block8 ="\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../js/AdmitPatient.js\' language=\'javascript\'></script>\n\t<script src=\'../js/AdmitPatient1.js\' language=\'javascript\'></script>\n\t<script src=\'../js/AdmitPatient2.js\' language=\'javascript\'></script>\n\t<script src=\'../js/IPPractitionerComponent.js\' language=\'javascript\'></script>\n\t<!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \t\n\t<script>\n\t\tfunction disableForm()\n\t\t{\n/*\n\t\t\tfor(var i=0; i<document.forms[0].elements.length; i++)\n\t\t\t\tdocument.forms[0].elements[i].disabled = true;\n*/\n\t\t}\n\t</script>\n\n\t<!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->\n\t<style>\n\t.inner_table_site { \n\t\twidth:1020px;  \n\t\theight:380px;\n\t\toverflow-y:auto;\t\n\t} \t\n\t</style>\n\t<!--End ML-MMOH-CRF-0779-->\n\n</head>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n        <body onLoad=\"callLoad();disableForm();\" onKeyDown= \'lockKey()\' onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\">\n        <form name=\'AdmitPatient_form\' id=\'AdmitPatient_form\'  method=\"post\" action=\"../../servlet/eIP.AdmitPatientServlet\" target=\"messageFrame\" >\n\t\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'ADMIT_PAT\'>\n\t\t<input type=\'hidden\' name=\'modified_bed_type\' id=\'modified_bed_type\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'bedtypecode\' id=\'bedtypecode\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'r_bed_no\' id=\'r_bed_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'booking_bed_no\' id=\'booking_bed_no\' value=\'\'><!--Added  for PMG2016-CRF-0002 IN061508�on 23rd Aug 16-->\n        <!-- For Admission Tab -->\n\t\t<input type=\'hidden\' name=\'temp_bed_class\' id=\'temp_bed_class\' value=\'\'>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<a name=\'tab1\' id=\'tab1\'></a>\n\t\t\t<ul id=\"tablist\" class=\"tablist\" style=\"padding-left: 2px;\">\n\t\t\t\t<li class=\"tablistitem\" title=\"Admission Details\">\n\t\t\t\t\t<a onclick=\"tab_click(\'admission_tab\')\" class=\"tabClicked\" id=\"admission_tab\" >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Financial Details\">\n\t\t\t\t\t<a onclick=\"tab_click(\'findtl_tab\')\" class=\"tabA\" id=\"findtl_tab\" >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t</ul>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t <table id=\'reftab\' border=\'0\' cellspacing=\'0\' cellpadding=\'2\' width=\'100%\'  height=\"5%\">\n\t\t <tr>\n\t\t\t<td nowrap class=\"COLUMNHEADER\" colspan=4 id=\"refheading\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t </tr>\n\t\t <tr>\n\t\t\t<td nowrap id=\'refdetails\' style=\'position:relative;\' class=\"label\"></td>\n\t\t </tr> \n\t </table>\n\t <script>\n\t\tdocument.getElementById(\'refheading\').style.visibility=\'hidden\';\n\t\tdocument.getElementById(\'refdetails\').style.visibility=\'hidden\';\n\t\tdocument.getElementById(\'reftab\').deleteRow(0);\n\t\tdocument.getElementById(\'reftab\').deleteRow(0);\n\t </script>\n\n\t <!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->\n\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t <div class=\"inner_table_site\">\n\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t <table border=\"0\" width=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' cellspacing=\'0\' cellpadding=\'2\'>\n\t\t <td nowrap class=\"COLUMNHEADER\" colspan=4 >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t<tr> \n\t\t\t\t<td  class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<td  class=\"fields\" width=\"25%\"><input type=\'text\' size=\'15\' maxLength=\'15\' name=\'SplDesc\' id=\'SplDesc\'  value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onblur=\'BeforegetSpecialty(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"); ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="psychiatryForms();";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' disabled><input type=\'button\' class=\'BUTTON\' name=\'specialty_search\' id=\'specialty_search\' value=\'?\' onClick=\"if(document.forms[0].SplDesc.value == \'\') getSpecialty(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'); ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" disabled><img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t<input type=\'hidden\' name=\'Splcode\' id=\'Splcode\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><input type=\'hidden\' name=\'SplDesc_hid\' id=\'SplDesc_hid\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"></td>\n\t\t\t\t<td  width=\"25%\" class=\"label\"  >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t<td  class=\"fields\" width=\"25%\"><input type=\'text\' name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" maxlength=15 size=15  value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onblur=\"if(this.value==\'\'){document.forms[0].nursing_unit.value=\'\';};BeforeNursingUnitLookup(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\');CheckNursingUnit();\"  disabled ><input type=\'button\' class=\'BUTTON\' name=\"nursing_unit_lookup\" id=\"nursing_unit_lookup\" value=\'?\' onClick=\"if(document.forms[0].nursing_unit_desc.value == \'\') NursingUnitLookup(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\');\" disabled><input type=hidden name=\"nursing_unit\" id=\"nursing_unit\" value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'><img src=\"../../eCommon/images/mandatory.gif\"><input type=\'hidden\' name=\"nurs_unit_desc_hid\" id=\"nurs_unit_desc_hid\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'><input type=\"hidden\" name=\"ServiceFocus\" id=\"ServiceFocus\" value=\"N\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td nowrap class=\"label\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<td nowrap class=\"fields\"><select name=\"service\" id=\"service\" onChange=\'onServiceChange()\'onmousewheel=\'return false;\'><option value=\"\" >--- ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ---</select><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t\t\n\t\t\t\t\t<td nowrap class=\"fields\"><select name=\"service\" id=\"service\"  onChange=\'onServiceChange()\' onmousewheel=\'return false;\'><option value=\"\">--- ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n\t\t\t\t<td nowrap class=\"label\"  >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t<td nowrap class=\"fields\"><select name=\"sub_service\" id=\"sub_service\"  ><option value=\"\">--- ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" ---</select></td>\n\t\t\t</tr>   \n\t\t\t<tr>\n\t\t\t<!--Below line modified for this linked incident [23474] -->\n<!--added onChange=\"onPkgEli(this) for package billing for bed class change-->\n\t\t\t\t<td nowrap class=\"label\" >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t<td nowrap class=\"fields\">\n\t\t\t\t<select name=\'Bedcode\' id=\'Bedcode\' onChange=\'onBedClassChange(this)\' onmousewheel=\'return false;\' dir=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t<option value=\"\" selected>--- ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" ---</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\t\t\t\t\n\t\t\t\t</select><img  src=\'../../eCommon/images/mandatory.gif\'> </td>\n\t\t\t\t<td nowrap class=\"label\" >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t<td nowrap class=\"fields\">\n\t\t\t\t<select name=\"bed_type\" id=\"bed_type\"  onChange=\"onPkgEli(this,\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\')\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t</tr>     \n\t\t\t<tr>\n\t\t\t\t<td nowrap class=\"label\" >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n        ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t<td nowrap class=\"fields\"><input type=\"text\" name=\"bed_no\" id=\"bed_no\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" size=\'8\' maxlength=\'8\' onblur=\"chkbedno() ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =";chkforVacantNormalBed()";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" readOnly><input type=\"button\" class=\"button\" name=\'bed_avail_chart\' id=\'bed_avail_chart\' value=\"?\" onclick=\"callModal(\'BED_AVAIL\')\" ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="onblur=\"chkforVacantNormalBed()\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" disabled><img ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="style=\'visibility:visible\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" style=\'visibility:hidden\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" id=\'bed_mnd\' src=\"../../eCommon/images/mandatory.gif\" /></td>\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<td nowrap class=\"fields\"><input type=\"text\" name=\"bed_no\" id=\"bed_no\" value=\"\" size=\'8\' maxlength=\'8\' onChange=\"return validateFields(this)\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" readOnly><input type=\"button\" class=\"button\" name=\'bed_avail_chart\' id=\'bed_avail_chart\' value=\"?\" onclick=\"callModal(\'BED_AVAIL\')\" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n\t\t\t\t<input type=\"hidden\" name=\"hdd_bed_no\" id=\"hdd_bed_no\" value=\"\">\n\t\t\t\t<td nowrap class=\"label\"  >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t<td nowrap class=\"fields\"><input type=\"text\" name=\"room_no\" id=\"room_no\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" size=10 maxlength=10  readonly onBlur=\"setTabFocus(\'F\',this)\" onKeyPress=\'return CheckForSpecChars(event)\' >          \n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" size=8 maxlength=4  readonly onBlur=\"setTabFocus(\'F\',this)\" onKeyPress=\'return CheckForSpecChars(event)\'  disabled>\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="         \n\t\t\t\t<input type=\"hidden\" name=\"addDepReq\" id=\"addDepReq\" value=\"N\"  >\n\t\t\t\t<input type=\"hidden\" name=\"dly_charge\" id=\"dly_charge\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"dep_amt\" id=\"dep_amt\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t<tr>\t\n\t\t\t<td nowrap class=\"COLUMNHEADER\" colspan=4 >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>              \n\t\t</tr> \n\t\t<tr>\n\t\t<!--modified for GHL-CRF-0020  added Allfunc() ;-->\n\t\t<td nowrap class=\"label\"  >";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t<!-- In below line CheckNumVal(exp_days_stay_id) method added on \"Admissiondate\" field\'s onBlur event modified by Venkatesh.S (em_id-4008) on 29/Sep/2011 for the incident GHL-SCF-453 [IN028804]-->\n\n\t\t<td nowrap class=\"fields\"><input type=\"text\" id= \"Admissiondate\" name=\"visit_adm_date_time\" id=\"visit_adm_date_time\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"  size=15 maxlength=16   onBlur=\" ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" Allfunc(); ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" validateDate(this,\'A\');CheckNumVal(exp_days_stay_id);setDate(this,\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\');validatePatient(this,\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\');\"  ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="><img name=\'AdmitDate\' src=\'../../eCommon/images/CommonCalendar.gif\' id=\'AdmissiondateImg\'  onClick=\"document.forms[0].visit_adm_date_time.focus();return showCalendar(\'Admissiondate\',null,\'hh:mm\');\" disabled />\n\n\t\t\t</td>\n\t\t\t<td nowrap class=\"label\"  >";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t\t<td nowrap class=\"fields\"><select name=\"visit_adm_type\" id=\"visit_adm_type\"  onChange=\"return validateFields(this)\"  ><option value=\"\">--- ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" ---</select><img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td nowrap class=\'label\'  >";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t\t\t<td nowrap class=\"fields\"><select name=\"ambulatory_status\" id=\"ambulatory_status\" ><option value=\"\">--- ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" ---</select></td>\n\t\t\t<td nowrap class=\"label\"  >";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\t\t\t<td nowrap class=\"fields\"><input type=\'text\' id=\'exp_days_stay_id\' name=\'exp_days_stay\' id=\'exp_days_stay\' size=\'3\' maxlength=\'3\' value=\"\" onKeyPress=\'return CheckForSpecChars(event)\'  onBlur=\'CheckNumVal(this);\' ></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td nowrap class=\"label\"  >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t<!--Below line is commented by Akhilesh because unnecessary function used-->\n\t\t\t<!--<td nowrap class=\"fields\" ><input type=\'text\' id = \"expdisdate\" name=\'expecteddischargedate\' id=\'expecteddischargedate\' size=15 maxlength=\'16\' value=\'\' onBlur=\'doChkDisDateTime(this);validateExpDate(this);\' readOnly>-->\n\t\t\t<td nowrap class=\"fields\" ><input type=\'text\' id = \"expdisdate\" name=\'expecteddischargedate\' id=\'expecteddischargedate\' size=15 maxlength=\'16\' value=\'\' onBlur=\'validateExpDate(this);\' readOnly>\n\t\t\t<td nowrap class=\"label\"   nowrap>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t\t\t<td nowrap class=\"fields\"><input type=\"text\" id =\"otdatetime\" name=\"ot_date_time\" id=\"ot_date_time\" size=16 maxlength=16  onBlur=\"doOTDateTimeChk(this)\" value =\"\" ><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'OTDate\'  name=\'OTDate\' onClick=\"document.forms[0].ot_date_time.select();return showCalendar(\'otdatetime\',null,\'hh:mm\');\" disabled />\n\t\t</tr>   \n\t\t<tr>\n\t\t\t<td nowrap class=\"label\" >";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n\t\t\t<td nowrap class=\"fields\" nowrap ><input type=\'text\' name=\'practid_desc\' id=\'practid_desc\' value=\"\" size=\'15\' maxlength=\'30\'  onblur=\"if(this.value==\'\'){document.forms[0].practid.value=\'\';document.forms[0].practid_desc_hid.value=\'\'};BeforeGetPractID1(document.forms[0].pract_id_search,practid_desc);\" disabled><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"if(document.forms[0].practid_desc.value == \'\') getPractID(this,practid_desc);\"  disabled><img src=\"../../eCommon/images/mandatory.gif\"><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"\" size=\'15\' maxlength=\'15\'  ><input type=\'hidden\' name=\'practid_desc_hid\' id=\'practid_desc_hid\' value=\"\" ></td>\n\t\t\t<td nowrap class=\"label\" >";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t\t\t<td nowrap class=\"fields\" ><input type=\'text\' name=\'att_practid_desc\' id=\'att_practid_desc\' value=\"\" size=\'15\' maxlength=\'30\'  onblur=\"if(this.value==\'\'){document.forms[0].att_practid.value=\'\'};BeforeGetPractID2(document.forms[0].att_pract_id_search,att_practid_desc);\"  disabled><input type=\'button\' name=\'att_pract_id_search\' id=\'att_pract_id_search\' value=\'?\' class=\'button\' onClick=\"if(document.forms[0].att_practid_desc.value == \'\')getPractID(this,att_practid_desc);\"  disabled><img style=\'visibility:hidden\' id=\'attend_img\' src=\"../../eCommon/images/mandatory.gif\"><input type=\'hidden\' name=\'att_practid\' id=\'att_practid\' value=\"\" size=\'15\' maxlength=\'15\'><input type=\'hidden\' name=\'att_practid_desc_hid\' id=\'att_practid_desc_hid\' value=\"\" ><input type=\'hidden\' name=\'pat_check_in_allowed_yn\' id=\'pat_check_in_allowed_yn\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'><input type=\'hidden\' name=\'d_referral_id\' id=\'d_referral_id\' value=\'\'><input type=\'hidden\' name=\'d_clinic_code\' id=\'d_clinic_code\' value=\'\'></td>\n\t\t</tr>           \n\t\t<tr>\n\t\t\t<td nowrap class=\"label\" >";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t<td nowrap class=\"fields\"><select name=\"team_id\" id=\"team_id\" ><option value=\'\'>--- ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" ---</select></td>\n\t\t\t <!--Below line modified for this CRF GDOH-CRF-0129-->\n\t\t\t ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t <td nowrap class=\"label\">";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\t\t\t\n\t\t\t</td>\n\t\t\t<!-- Modified for MMS-QH-CRF-0144 - forming ReasonforAdmission field as mandatory based on IPParameter-->\n\t\t\t<td nowrap class=\"fields\"><span name=\"chief_complaint_txt\" id=\"chief_complaint_txt\"><input type=\"text\" name=\'chief_complaint\' id=\'chief_complaint\' size=\"30\" maxLength=\"200\" onblur=\"BeforeReasonLookup();\" onChange=\"refresherrmsg();\" ><input type=button name=\'chfcomp_lookup\' id=\'chfcomp_lookup\' value=\'?\' class=button onClick=\"if(document.forms[0].chief_complaint.value == \'\') ReasonLookup();refresherrmsg();\"><input type=hidden name=\'complaintcode\' id=\'complaintcode\' ><input type=hidden name=\'chief_complaint_hid\' id=\'chief_complaint_hid\' >\n\t\t\t<!--Below line Modified for this CRF GDOH-CRF-0129-->\n\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" id=\'reason_reqd\'>\n\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\t\t\t\n\t\t\t</span>\n\t\t\t<span name=\"assigncare_location_txt\" id=\"assigncare_location_txt\" style=\"visibility:hidden;font-size:11px\"><input type=\"text\" name=\"assigncare_location_desc\" id=\"assigncare_location_desc\" maxlength=\"40\" size=\"25\" value=\"\" > </span>\n\t\t\t</td>\n\t\t\t<input type=hidden name=\'reason_reqd_Flag\' id=\'reason_reqd_Flag\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\t\t\t \n\t\t\t ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t<td nowrap class=\"label\">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\t\t\t\n\t\t\t</td>\n\t\t\t<!-- Modified for MMS-QH-CRF-0144 - forming ReasonforAdmission field as mandatory based on IPParameter-->\n\t\t\t<td nowrap class=\"fields\"><input type=\"text\" name=\'chief_complaint\' id=\'chief_complaint\' size=\"30\" maxLength=\"200\" onblur=\"BeforeReasonLookup();\" onChange=\"refresherrmsg();\" ><input type=button name=\'chfcomp_lookup\' id=\'chfcomp_lookup\' value=\'?\' class=button onClick=\"if(document.forms[0].chief_complaint.value == \'\') ReasonLookup();refresherrmsg();\"><input type=hidden name=\'complaintcode\' id=\'complaintcode\' ><input type=hidden name=\'chief_complaint_hid\' id=\'chief_complaint_hid\' >\n\t\t\t<!--Below line Modified for this CRF GDOH-CRF-0129-->\n\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\t\t\t\n\t\t\t</td>\n\t\t\t<input type=hidden name=\'reason_reqd_Flag\' id=\'reason_reqd_Flag\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\t\t\t\n\t\t\t\n\t\t</tr>\n\t\t<!---->\n\t\t<tr>\n\t\t\t<td nowrap class=\"label\" >";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="&nbsp";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n\t\t\t<td nowrap class=\"fields\"><textarea name=\"admission_remarks\" rows=\"2\"  maxlength=\'250\'   onBlur=\"makeValidString(this);\" onKeyPress=\"/*return CheckForSpecChars_Remarks(event);*/\" onkeyup=\"return imposeMaxLength(this);\" style=\"resize:none;\"></textarea></td>\n\n\t\t\t<!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->\n\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t<td nowrap class=\"fields\"></td>\n\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t<td nowrap class=\'label\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\t\t\t<td>\n\t\t\t\t<div id=\"PsychiatryForm\" style=\"visibility:visible;overflow:auto;height:97px;width:220;border:1px outset white\" align=\"left\" >\n\t\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'75%\' align=\'left\' id=\"PF_display\">\n\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t<!--End ML-MMOH-CRF-0779-->\n\n\t\t</tr>\n\t\t<!---->\n\t\t<!--Added by Kamatchi S for ML-MMOH-CRF-1609-->\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'18%\'>      \n\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="&nbsp;\n\t\t\t</td> \n\t\t\t<td class=\"label\" id=\"out_amt\" style=\"font-weight:bold\"  >\n\t\t\t</td>\n\t\t\t<!--Below added by Suji Keerthi for MMS-DM-CRF-0191 US001-->\n\t\t\t<td nowrap class=\'label\'  >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t\t<td nowrap class=\"fields\"><input type=\"text\" name=\"admission_approval_details\" id=\"admission_approval_details\"  size=15 maxlength=100 value =\"\" onKeyPress=\"return CheckForSpecCharsValidation1(event);\" onBlur=\'CheckSplCharsValidation(this);\' ></td>\n\t\t\t<!--Ended by Suji Keerthi for MMS-DM-CRF-0191 US001-->\n\t\t</tr>\n\t\t\t<td nowrap class=\"COLUMNHEADER\" colspan=\'4\'>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td>\n\t\t<tr>\n\t\t\t<td nowrap class=\'label\'  >";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\t\t\t<td nowrap class=\"fields\"><select name=\"arrival_code\" id=\"arrival_code\" ><option value=\"\">--- ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" ---</select></td><td nowrap class=\"label\" ></td><td nowrap class=\"label\" ></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td nowrap class=\'label\'  >";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t\t<td nowrap class=\"fields\"  ><input type=\"text\" name=\"escort_name\" id=\"escort_name\"  size=15 maxlength=30 value =\"\" onBlur=\'makeValidString(this)\' ></td>\n\t\t\t<td nowrap class=\'label\'  >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\t\t\t<td nowrap class=\"fields\"><input type=\"text\" name=\"escort_tel_num\" id=\"escort_tel_num\"  size=15 maxlength=18 value =\"\" onBlur=\'makeValidString(this)\' ></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td nowrap class=\'label\' >";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t\t<td nowrap class=\"fields\"><input type=\"text\" name=\"escort_mv_regn_no\" id=\"escort_mv_regn_no\"  size=15 maxlength=15 value =\"\" onBlur=\'makeValidString(this)\' ></td>\n\t\t\t<td nowrap class=\'label\'  >";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\t\t\t<td nowrap class=\"fields\"><input type=\"text\" name=\"emergency_detail\" id=\"emergency_detail\" size=\"40\" maxlength=\"500\" onBlur=\"makeValidString(this);\" value =\"\" ></td>\n\t\t</tr>\n\t</table>\n\t<!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->\n\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t</div>\n\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t<!-- Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 Start -->\n\t\t<input type = \'hidden\' name = \'bl_adm_remarks\' id = \'bl_adm_remarks\' value=\"\">\n\t\t<input type = \'hidden\' name = \'bl_bed_request\' id = \'bl_bed_request\' value=\"\">\n\t\t<input type = \'hidden\' name = \'bl_bed_type_code\' id = \'bl_bed_type_code\' value=\"\">\n\t\t<!-- Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 End -->\n\t\t<input type=\'hidden\' name=\'continue_as_mlc_yn\' id=\'continue_as_mlc_yn\' value=\'N\'>\n\t\t<input type=\"hidden\" name=\"confirm_flag\" id=\"confirm_flag\" value=\"\">\n\t\t<input type=\"hidden\" name=\"baby_flag\" id=\"baby_flag\" value=\"\">\n\t\t<input type=\'hidden\' name=\'admissiondate_readonly\' id=\'admissiondate_readonly\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t\t<input type=\'hidden\' name=\'backdated_admission_yn\' id=\'backdated_admission_yn\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t<input type=\'hidden\' name=\'blockflag\' id=\'blockflag\' value=\'\'>\n\t\t<input type=\"hidden\" name=\"currdate\" id=\"currdate\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t\t<input type=\"hidden\" name=\"booking_ref_no\" id=\"booking_ref_no\" value=\"\">\n\t\t<input type=\"hidden\" name=\"bkg_type\" id=\"bkg_type\" value=\"\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"referral_id\" id=\"referral_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"adm_type_ind\" id=\"adm_type_ind\" value=\"\">\n\t\t<input type=\"hidden\" name=\"ancillary_yn\" id=\"ancillary_yn\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t<input type=\"hidden\" name=\"ref_practitioner_name\" id=\"ref_practitioner_name\" value=\"\">\n\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"\">\n\t\t<input type=\"hidden\" name=\"patient_class_id\" id=\"patient_class_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"from_adv_bed_mgmt\" id=\"from_adv_bed_mgmt\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t\t<input type=\"hidden\" name=\"nursing_unit_code\" id=\"nursing_unit_code\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t<input type=\"hidden\" name=\"bed_class_code\" id=\"bed_class_code\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t\t<input type=\"hidden\" name=\"call_func\" id=\"call_func\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t\t<input type=\"hidden\" name=\"gender\" id=\"gender\" value=\"\">\n\t\t<input type=\"hidden\" name=\"age\" id=\"age\" value=\"\">\n\t\t<input type=\'hidden\' name=\'bed_assigned_for_nb_yn\' id=\'bed_assigned_for_nb_yn\' value=\'N\'>\n\t\t<input type=\"hidden\" name=\"contact_details\" id=\"contact_details\" value=\"\">\n\t\t<input type=\'hidden\' name=\'pat_ser_grp_code\' id=\'pat_ser_grp_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'to_speciality_code\' id=\'to_speciality_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'hddfacility\' id=\'hddfacility\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n\t\t<input type=\'hidden\' name=\'recorded_by\' id=\'recorded_by\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'recorded_date\' id=\'recorded_date\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'valuble_remakrs\' id=\'valuble_remakrs\' value=\'\'>\n\t\t<input type=\"hidden\" name=\"valubles\" id=\"valubles\" value=\"\"> \n\t\t<input type=\"hidden\" name=\"rec_diag_yn\" id=\"rec_diag_yn\" value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'> \n\n\t\t<!-- ===== Common address component fields ===== -->\n\t\t<input type=\'hidden\' name=\'change_address\' id=\'change_address\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\'\'>\t\t\n\t\t<input type=\'hidden\' name=\'concat_NatIdDetails_hidden\' id=\'concat_NatIdDetails_hidden\' value=\'\'>\t\t\n\t\t<input type=\'hidden\' name=\'addr1_type\' id=\'addr1_type\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'addr_line1\' id=\'addr_line1\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'addr_line2\' id=\'addr_line2\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'addr_line3\' id=\'addr_line3\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'addr_line4\' id=\'addr_line4\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'res_town_code\' id=\'res_town_code\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'res_town_desc\' id=\'res_town_desc\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'res_area_code\' id=\'res_area_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'res_area_desc\' id=\'res_area_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'postal_code\' id=\'postal_code\' value=\'\' >\t\n\t\t<input type=\'hidden\' name=\'postal_desc\' id=\'postal_desc\' value=\'\' >\t\n\t\t<input type=\'hidden\' name=\'region_code\' id=\'region_code\' value=\'\' >\t\n\t\t<input type=\'hidden\' name=\'region_desc\' id=\'region_desc\' value=\'\' >\t\n\t\t<input type=\'hidden\' name=\'country_code\' id=\'country_code\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'country_desc\' id=\'country_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'invalid1_yn\' id=\'invalid1_yn\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'addr2_type\' id=\'addr2_type\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_addr_line1\' id=\'mail_addr_line1\'  value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_addr_line2\' id=\'mail_addr_line2\'  value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_addr_line3\' id=\'mail_addr_line3\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'mail_addr_line4\' id=\'mail_addr_line4\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'mail_res_town_code\' id=\'mail_res_town_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_res_town_desc\' id=\'mail_res_town_desc\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'mail_res_area_code\' id=\'mail_res_area_code\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'mail_res_area_desc\' id=\'mail_res_area_desc\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'mail_postal_code\' id=\'mail_postal_code\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'mail_postal_desc\' id=\'mail_postal_desc\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'mail_region_code\' id=\'mail_region_code\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'mail_region_desc\' id=\'mail_region_desc\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'mail_country_code\' id=\'mail_country_code\' value=\'\'>\n\t\t<input type=\'hidden\' name =\'mail_country_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'invalid2_yn\' id=\'invalid2_yn\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'contact1_no\' id=\'contact1_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'contact2_no\' id=\'contact2_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'email\' id=\'email\' value=\'\'>\n\t\t<!-- ===== Common address component fields ===== -->\n\t\t\n\t\t<!--Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start-->\n\t\t<input type=\'hidden\' name=\'alt_addr_line1\' id=\'alt_addr_line1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_addr_line2\' id=\'alt_addr_line2\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_addr_line3\' id=\'alt_addr_line3\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_addr_line4\' id=\'alt_addr_line4\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_town_code\' id=\'alt_town_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_town_desc\' id=\'alt_town_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_area_code\' id=\'alt_area_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_area_desc\' id=\'alt_area_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_postal_desc\' id=\'alt_postal_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_region_code\' id=\'alt_region_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_region_desc\' id=\'alt_region_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_country_code\' id=\'alt_country_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_country_desc\' id=\'alt_country_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n\t\t<!--End-->\n\t\t\n\t\t\n\t\t<input type=\'hidden\' name=\'isAttendPractAppl\' id=\'isAttendPractAppl\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'> <!-- added by mujafar for ML-MMOH-SCF-1316 -->\n\n\t\t<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\'Generate_File\'>\n\t\t<input type=\'hidden\' name=\'back_date\' id=\'back_date\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t\t<input type=\'hidden\' name=\'adm_date_chk_days\' id=\'adm_date_chk_days\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n\t\t<input type=\'hidden\' name=\'adm_date_chk_days_type\' id=\'adm_date_chk_days_type\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t\t<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n        <input type=\'hidden\' name=\'isBlInstalled\' id=\'isBlInstalled\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n        <input type=\'hidden\' name=\'isBlInterfaced\' id=\'isBlInterfaced\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n\t\t<input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\"> \n\t\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\n\t\t<!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->\n\t\t<input type = \'hidden\' name = \'PFValue\' value=\"\">\n\n        <input type=\'hidden\' name=\'new_file_no\' id=\'new_file_no\' value=\'\'>\n\t\t<!--Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start-->\n\t\t<input type = \'hidden\' name = \'isForm60Available\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"> \n\t\t<!-- Added by Sangeetha for KDAH-CRF-0347 -->\n\t\t<input type = \'hidden\' name = \'validationForPanCardAvail\' value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"> \n\t\t<input type=\"hidden\" name=\"form60_YN\" id=\"form60_YN\" value=\"\">\n\t\t<!--Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End-->\n         ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t        <a name=\'tab3\' id=\'tab3\' ></a>\n\t\t\t<ul id=\"tablist\" class=\"tablist\" style=\"padding-left: 2px;\">\n\t\t\t<li class=\"tablistitem\" title=\"Admission Details\">\n\t\t\t\t<a onclick=\"tab_click(\'admission_tab2\')\" class=\"tabA\" id=\"admission_tab2\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"\">";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Financial Details\">\n\t\t\t\t<a onclick=\"tab_click(\'findtl_tab2\')\" class=\"tabClicked\" id=\"findtl_tab2\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"\">";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t</ul>\n\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'bl_future_admn_YN\' id=\'bl_future_admn_YN\' value=\'\'>\n<!--                <input type=\'hidden\' name=\'billing_class\' id=\'billing_class\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'employer_code\' id=\'employer_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cash_set_type1\' id=\'cash_set_type1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cash_insmt_ref1\' id=\'cash_insmt_ref1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cash_insmt_date1\' id=\'cash_insmt_date1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cash_insmt_rmks1\' id=\'cash_insmt_rmks1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cust_1\' id=\'cust_1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'credit_doc_date1\' id=\'credit_doc_date1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cust_2\' id=\'cust_2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'credit_doc_ref2\' id=\'credit_doc_ref2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'credit_doc_date2\' id=\'credit_doc_date2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cust_3\' id=\'cust_3\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'policy_type\' id=\'policy_type\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'policy_no\' id=\'policy_no\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'policy_expiry_date\' id=\'policy_expiry_date\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'non_insur_blng_grp\' id=\'non_insur_blng_grp\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cash_set_type2\' id=\'cash_set_type2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cash_insmt_ref2\' id=\'cash_insmt_ref2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cash_insmt_date2\' id=\'cash_insmt_date2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cash_insmt_rmks2\' id=\'cash_insmt_rmks2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cust_4\' id=\'cust_4\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'credit_doc_date3\' id=\'credit_doc_date3\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'setlmt_ind\' id=\'setlmt_ind\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'upd_fin_dtls\' id=\'upd_fin_dtls\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'credit_auth_ref\' id=\'credit_auth_ref\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'credit_auth_date\' id=\'credit_auth_date\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'app_days\' id=\'app_days\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'app_amount\' id=\'app_amount\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'eff_frm_date\' id=\'eff_frm_date\' value=\'\'>-->\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'>\n\t\t\t<input type=\'hidden\' name=\'bl_operation\' id=\'bl_operation\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'pkg_bill_type\' id=\'pkg_bill_type\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'pkg_bill_no\' id=\'pkg_bill_no\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'package_flag\' id=\'package_flag\' value=\'N\'>\n\t\t\t<input type=\'hidden\' name=\'insTrackDtlsExists\' id=\'insTrackDtlsExists\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'P_call_func\' id=\'P_call_func\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\t\t\t\n\t\t\t<input type=\'hidden\' name=\'health_card_expired_yn\' id=\'health_card_expired_yn\' value=\'\'>\n<!--\n\t\t\t<input type=\'hidden\' name=\'annual_income\' id=\'annual_income\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'family_asset\' id=\'family_asset\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'no_of_dependants\' id=\'no_of_dependants\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'resp_for_payment\' id=\'resp_for_payment\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'credit_doc_reqd_yn1\' id=\'credit_doc_reqd_yn1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'credit_doc_reqd_yn2\' id=\'credit_doc_reqd_yn2\' value=\'\'>\n-->\n\t\t\t<input type=\'hidden\' name=\'Chg_to_Visitor_Grp\' id=\'Chg_to_Visitor_Grp\' value=\'N\'>\n\t\t\t<input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\'N\'>\n\t\n\t\t\t<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'upd_user_flag\' id=\'upd_user_flag\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'>\n\n\t\t\t\n\t\t\t<!--<input type=\'hidden\' name=\'cred_st_dt1\' id=\'cred_st_dt1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cred_st_dt2\' id=\'cred_st_dt2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'cred_st_dt3\' id=\'cred_st_dt3\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'gl_holder_name\' id=\'gl_holder_name\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'gl_holder_reln\' id=\'gl_holder_reln\' value=\'\'>-->\n\n\t\t\t<input type=\'hidden\' name=\'financial_detail_ref_id\' id=\'financial_detail_ref_id\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'org_type_ind\' id=\'org_type_ind\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'ADMIT_PAT\'>\t\t\t\n\t\t\t<input type=\'hidden\' name=\'blr_check\' id=\'blr_check\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'bkg_grace_period\' id=\'bkg_grace_period\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n\t\n          <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n          <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\t\t\t<input type = \'hidden\' name = \'sStyle\' value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">  \n\t\t\t<input type = \'hidden\' name = \'locale\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">  \n\t\t\t<input type = \'hidden\' name = \'nurs_unt_auth_val\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">  \n\t\t\t<input type = \'hidden\' name = \'pat_flag\' value=\">\">  \n\t\t\t<input type = \'hidden\' name = \'deactivate_pseudo_bed_yn\' value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">  \n\t\t\t<input type = \'hidden\' name = \'p_hosp_main\' value=\"\">  \n\t\t\t<input type = \'hidden\' name = \'p_hosp_sub\' value=\"\">  \n\t\t\t<input type = \'hidden\' name = \'p_card_id\' value=\"\">  \n\t\t\t<input type = \'hidden\' name = \'p_expiry_date\' value=\"\">  \n\t\t\t<input type = \'hidden\' name = \'p_privl_type_code\' value=\"\">  \n\t\t\t<input type = \'hidden\' name = \'p_all_services\' value=\"\">  \n\t\t\t<input type = \'hidden\' name = \'p_error_text\' value=\"\">  \n\t\t\t<input type = \'hidden\' name = \'p_status\' value=\"\">  \n\t\t\t<input type = \'hidden\' name = \'bed_mandatory_for_admn_yn\' value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">  \n\t\t\t<input type = \'hidden\' name = \'admit_patient_with_bed_yn\' value=\"\">  \n\t\t\t\t<input type = \'hidden\' name = \'package_enabled_yn\' value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">  \n\t\t\t\t<!--Added the below hidden field for IN023629 on 03.08.2010 by Suresh M-->\n\t\t\t\t<input type = \'hidden\' name = \'bl_interfaced_yn\' value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">  \n\t\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t<input type = \'hidden\' name = \'quick_admission_type\' value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">  \n\t\t\t\t<input type = \'hidden\' name = \'quick_adm_referralid\' value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">  \n\t\t\t\t<input type = \'hidden\' name = \'quick_adm\' value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">  \n\t\t\t\t<input type = \'hidden\' name = \'ref_encounter_id\' value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">  \t\t\t\t\n\t\t\t\t<!--Below line added for this CRF GDOH-CRF-0129-->\n\t\t\t\t<input type=\"hidden\" name=\"assigncare_loctype_ind\" id=\"assigncare_loctype_ind\" id=\"assigncare_loctype_ind\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"assigncare_locacode\" id=\"assigncare_locacode\" id=\"assigncare_locacode\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"isReferral\" id=\"isReferral\" id=\"isReferral\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\"> \n\t\t\t\t<!--End GDOH-CRF-0129-->\t\t\t\n\t\t\t\t\n\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t<script>\n\t\t\t\tdocument.forms[0].patient_class_id.value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\';\n\t\t\t\tvalidateFields(document.forms[0].nursing_unit_desc);\n\t\t\t\tchkbedno();\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t</form>\n        </body>\n    ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n</html>\n";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n<!-- Added for MMS-QH-CRF-0144 to do the functions as like \"onchange\" event of \"admission_for\" field -->\n<script> enableFlds();allowedAdmissionType();disableflds(); </script> \n\n";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

   ArrayList fetchContactAddresses(Connection con,  javax.servlet.jsp.JspWriter out,String messageFrame,java.util.Properties p)
    {
		java.sql.Statement stmt		= null;
        ResultSet rset				= null; 
		java.sql.Statement stmt1	= null;
		ResultSet rset1				= null;	
		
		//Added for this CRF ML-MMOH-CRF-0860.2
		boolean increasedaddressLength = false;

        ArrayList return_arrlist = new ArrayList();
        out = out;
		String locale = p.getProperty("LOCALE");
        try
        {
		    //Added for this CRF ML-MMOH-CRF-0860.2
			increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
			
			 String prompt_sql = "SELECT initcap(res_area_prompt) res_area_prompt, initcap(res_town_prompt) res_town_prompt, postal_code_prompt, initcap(region_prompt) region_prompt FROM sm_site_param_LANG_VW where site_id='DS' and language_id='"+locale+"' ";

			String res_area_prompt		= "";
			String res_town_prompt		= "";
			String postal_code_prompt	= "";
			String region_prompt		= "";
			
			stmt1 = con.createStatement() ;
			rset1 = stmt1.executeQuery(prompt_sql) ;
	          
			while(rset1.next())
			{
				res_area_prompt		= rset1.getString("res_area_prompt");
				res_town_prompt		= rset1.getString("res_town_prompt");
				postal_code_prompt	= rset1.getString("postal_code_prompt");
				region_prompt		= rset1.getString("region_prompt");
			}
           
		    /*Below line modified for this CRF ML-MMOH-CRF-0860 (increase the maxlength from 30 to 100)*/		  
			/*String addr_line1 = "<input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='100' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
            String addr_line2 = "<input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='100' size='25' value=\"\" tabIndex='@'onBlur='makeValidString(this)'>";
            String addr_line3 = "<input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='100' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
			*/
            //End this CRF ML-MMOH-CRF-0860
			 
			//below line added for this ML-MMOH-CRF-0860.2
			String addr_line1="";
			String addr_line2="";
			String addr_line3="";
			String town_length="40";
			String rapidreg_nextofkin_addr_line1="";
			String rapidreg_nextofkin_addr_line2="";
			String rapidreg_nextofkin_addr_line3="";
			if(increasedaddressLength){
             town_length="36";			
			/* addr_line1 = "<textarea name='r_addr_line1' rows=3 cols=50 onblur='makeValidString(this);' onpaste='return maxLengthPaste(this,100);' onkeypress='checkMaxLimit(this,100)'></textarea>";
			 addr_line2 = "<textarea name='r_addr_line2' rows=3 cols=50 onblur='makeValidString(this);' onpaste='return maxLengthPaste(this,100);' onkeypress='checkMaxLimit(this,100)'></textarea>";
			 addr_line3 = "<textarea name='r_addr_line3' rows=3 cols=50 onblur='makeValidString(this);' onpaste='return maxLengthPaste(this,100);' onkeypress='checkMaxLimit(this,100)'></textarea>";*/
			 
			 addr_line1 = "<textarea name='r_addr_line1' id='r_addr_line1' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);' onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 addr_line2 = "<textarea name='r_addr_line2' id='r_addr_line2' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);'  onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 addr_line3 = "<textarea name='r_addr_line3' id='r_addr_line3' rows=3 maxlength=100 cols=50 tabIndex='@' onblur='makeValidString(this); maxLengthPaste(this);'  onkeypress='checkMaxLimit(this,100)' onkeyup='RemoveSpecialChar(this)' ></textarea>"; //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			 			 
			}else{			
		     addr_line1 = "<input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			 addr_line2 = "<input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='30' size='25' value=\"\" tabIndex='@'onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
             addr_line3 = "<input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			}			
			//End this ML-MMOH-CRF-0860.2
			
			
			String addr_line4 = "<input type='text' name='r_addr_line4' id='r_addr_line4' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'  onkeyup='RemoveSpecialChar(this)'>";
			System.out.println("res_town_prompt"+res_town_prompt);
             
			String res_town = "<input align='left' type='text' name='r_town_code' id='r_town_code'  size='"+town_length+"'  maxlength='"+town_length+"' onBlur=\"if(this.value != ''){ searchCommonCode(town_code[0],r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_town_code)}\" tabindex='@'><input type='button' name='town_code' id='town_code' value='?' class='button' onclick=\"searchCommonCode(this,r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";	
           
		   
			
			String res_area = "<input align='left' type='text' name='r_area_code' id='r_area_code'  size='27' maxlength='30' onBlur=\"if(this.value != ''){ searchCommonCode(area_code[0],r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')} else { clearCommonCode(r_area_code)}\" tabindex='@'><input type='button' name='area_code' id='area_code' value='?' class='button' onclick=\"searchCommonCode(this,r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";
			String region = "<input align='left' type='text' name='r_region_code' id='r_region_code'  size='27' maxlength='30' onBlur=\"if(this.value != '') {searchCommonCode(region_code[0],r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_region_code)}\" tabindex='@'><input type='button' name='region_code' id='region_code' value='?' class='button' onclick=\"searchCommonCode(this,r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
           	String postal_code = "<input align='left' type='text' name='r_postal_code1' id='r_postal_code1'  size='15' maxlength='15'  onBlur=\"if(this.value != ''){ searchCommonCode(postal_code[0],r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')} else{ clearCommonCode(r_postal_code1)}\"tabindex='@'><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick=\"searchCommonCode(this,r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
            
            String[] prompts        = new String [8];
            String[] elements       = new String [8];
            String[] colnamearray	= new String [8];

            String[] elements_ord =  { "ADDR_LINE1", "ADDR_LINE2", "ADDR_LINE3", "ADDR_LINE4", "RES_TOWN", "RES_AREA", "REGION", "POSTAL_CODE" };
            String[] elements_val =  { addr_line1, addr_line2, addr_line3, addr_line4, res_town, res_area, region, postal_code };
            
            String sql = "SELECT site_id, initcap(addr_line1_prompt) addr_line1_prompt, addr_line1_order, initcap(addr_line2_prompt) addr_line2_prompt, addr_line2_order, initcap(addr_line3_prompt) addr_line3_prompt, addr_line3_order, initcap(addr_line4_prompt) addr_line4_prompt, addr_line4_order, initcap(res_area_prompt) res_area_prompt, res_area_order, initcap(res_town_prompt) res_town_prompt, res_town_order, postal_code_prompt, postal_code_order, region_prompt, region_order, addr_line1_appl_yn, addr_line2_appl_yn, addr_line3_appl_yn, addr_line4_appl_yn, res_area_appl_yn, res_town_appl_yn, region_appl_yn, postal_code_appl_yn FROM sm_site_param_LANG_VW where site_id='DS' AND language_id='"+locale+"'  ";

            stmt = con.createStatement();
            rset = stmt.executeQuery(sql);
            int tot_count = 0;
            
            if(rset != null)
            {
                if(rset.next())
                {
                    ResultSetMetaData rsmd = rset.getMetaData() ;
                    int numberOfColumns = rsmd.getColumnCount();
					String site = "";
					if ( rset.getString("site_id") != null )
						site = rset.getString("site_id");
                    return_arrlist.add(site) ;

                    for(int i=0; i<numberOfColumns; i++)
                    {
                        String columnName = rsmd.getColumnName(i+1) ;
                        
                        if(!columnName.equalsIgnoreCase("site_id"))
                        {
                            if( columnName.indexOf( "_ORDER" ) != -1)
                            {
                                String colname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_PROMPT" ;
								String applcolname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_APPL_YN" ;
								
								String appl_yn = "N";
								int ord = rset.getInt( columnName ) ;
								appl_yn = rset.getString(applcolname);
								if (appl_yn == null) appl_yn = "N";

                                if(ord!= 0 && appl_yn.equals("Y"))
                                {
                                    tot_count++ ;
                                    colnamearray[ord-1] = colname ;
                                    prompts[ord-1] = rset.getString(colname);
                                    if(prompts[ord-1] == null) prompts[ord-1] = "&nbsp;" ;

                                    for( int j=0; j<8;j++)
                                    {
                                        if( colname.indexOf(elements_ord[j]) != -1)
                                        {
                                            elements[ord-1] = elements_val[j] ;
                                            break ;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            String[] prompts_temp       = new String [tot_count];
            String[] elements_temp      = new String [tot_count];
            String[] colnamearray_temp	= new String [tot_count];
			
			
			
            tot_count = 0 ;
            for(int i=0; i<prompts.length; i++)
            {
                if(prompts[i] != null)
                {
                    prompts_temp[tot_count]      = prompts[i] ;
                    elements_temp[tot_count]     = elements[i] ;    
                    colnamearray_temp[tot_count] = colnamearray[i] ;
															
                    tot_count++ ;
                }
            }

            return_arrlist.add(colnamearray_temp);
            return_arrlist.add(prompts_temp);
            return_arrlist.add(elements_temp);
			
			

			if(rset != null) rset.close();
			if(rset1 != null) rset1.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
        }
		catch(Exception e)
        {
         
        e.printStackTrace();		 
         
		}
        return return_arrlist ;
    }
	   ArrayList fetchContactAddressesLocal(Connection con,  javax.servlet.jsp.JspWriter out,String messageFrame,java.util.Properties p)
    {
		java.sql.Statement stmt		= null;
        ResultSet rset				= null; 
		java.sql.Statement stmt1	= null;
		ResultSet rset1				= null;

        ArrayList return_arrlist = new ArrayList();
        out = out;
		String locale = p.getProperty("LOCALE");
        try
        {
			
			 String prompt_sql = "SELECT initcap(res_area_prompt) res_area_prompt, initcap(res_town_prompt) res_town_prompt, postal_code_prompt, initcap(region_prompt) region_prompt FROM sm_site_param_LANG_VW where site_id='DS' and language_id='"+locale+"' ";

			String res_area_prompt		= "";
			String res_town_prompt		= "";
			String postal_code_prompt	= "";
			String region_prompt		= "";
			
			stmt1 = con.createStatement() ;
			rset1 = stmt1.executeQuery(prompt_sql) ;
	
			while(rset1.next())
			{
				res_area_prompt		= rset1.getString("res_area_prompt");
				System.out.println("area"+res_area_prompt);
				res_town_prompt		= rset1.getString("res_town_prompt");
				System.out.println("town"+res_area_prompt);
				postal_code_prompt	= rset1.getString("postal_code_prompt");
				System.out.println("code"+res_area_prompt);
				region_prompt		= rset1.getString("region_prompt");
				System.out.println("region_prompt"+region_prompt);
			}
         
			String addr_line1 = "<input type='text' name='r_addr_line1' id='r_addr_line1' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
            String addr_line2 = "<input type='text' name='r_addr_line2' id='r_addr_line2' maxlength='30' size='25' value=\"\" tabIndex='@'onBlur='makeValidString(this)'>";
            String addr_line3 = "<input type='text' name='r_addr_line3' id='r_addr_line3' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
            String addr_line4 = "<input type='text' name='r_addr_line4' id='r_addr_line4' maxlength='30' size='25' value=\"\" tabIndex='@' onBlur='makeValidString(this)'>";
             
			String res_town = "<input align='left' type='text' name='r_town_code' id='r_town_code'  size='20'  maxlength='40' onBlur=\"if(this.value != ''){ searchCommonCode(town_code[0],r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_town_code)}\" tabindex='@'><input type='button' name='town_code' id='town_code' value='?' class='button' onclick=\"searchCommonCode(this,r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";			
			String res_area = "<input align='left' type='text' name='r_area_code' id='r_area_code'  size='27' maxlength='30' onBlur=\"if(this.value != ''){ searchCommonCode(area_code[0],r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')} else { clearCommonCode(r_area_code)}\" tabindex='@'><input type='button' name='area_code' id='area_code' value='?' class='button' onclick=\"searchCommonCode(this,r_area_code,'"+res_area_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";
			String region = "<input align='left' type='text' name='r_region_code' id='r_region_code'  size='27' maxlength='30' onBlur=\"if(this.value != '') {searchCommonCode(region_code[0],r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_region_code)}\" tabindex='@'><input type='button' name='region_code' id='region_code' value='?' class='button' onclick=\"searchCommonCode(this,r_region_code,'"+region_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
           	String postal_code = "<input align='left' type='text' name='r_postal_code1' id='r_postal_code1'  size='15' maxlength='15'  onBlur=\"if(this.value != ''){ searchCommonCode(postal_code[0],r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')} else{ clearCommonCode(r_postal_code1)}\"tabindex='@'><input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick=\"searchCommonCode(this,r_postal_code1,'"+postal_code_prompt+"','"+messageFrame+"','"+locale+"')\" tabindex='@'>";
            
            String[] prompts        = new String [8];
            String[] elements       = new String [8];
            String[] colnamearray	= new String [8];

            String[] elements_ord =  { "ADDR_LINE1", "ADDR_LINE2", "ADDR_LINE3", "ADDR_LINE4", "RES_TOWN", "RES_AREA", "REGION", "POSTAL_CODE" };
            String[] elements_val =  { addr_line1, addr_line2, addr_line3, addr_line4, res_town, res_area, region, postal_code };
            
            String sql = "SELECT site_id, initcap(addr_line1_prompt) addr_line1_prompt, addr_line1_order, initcap(addr_line2_prompt) addr_line2_prompt, addr_line2_order, initcap(addr_line3_prompt) addr_line3_prompt, addr_line3_order, initcap(addr_line4_prompt) addr_line4_prompt, addr_line4_order, initcap(res_area_prompt) res_area_prompt, res_area_order, initcap(res_town_prompt) res_town_prompt, res_town_order, postal_code_prompt, postal_code_order, region_prompt, region_order, addr_line1_appl_yn, addr_line2_appl_yn, addr_line3_appl_yn, addr_line4_appl_yn, res_area_appl_yn, res_town_appl_yn, region_appl_yn, postal_code_appl_yn FROM sm_site_param_LANG_VW where site_id='DS' AND language_id='"+locale+"'  ";

            stmt = con.createStatement();
            rset = stmt.executeQuery(sql);
            int tot_count = 0;
            
            if(rset != null)
            {
                if(rset.next())
                {
                    ResultSetMetaData rsmd = rset.getMetaData() ;
                    int numberOfColumns = rsmd.getColumnCount();
					String site = "";
					if ( rset.getString("site_id") != null )
						site = rset.getString("site_id");
                    return_arrlist.add(site) ;

                    for(int i=0; i<numberOfColumns; i++)
                    {
                        String columnName = rsmd.getColumnName(i+1) ;
                        
                        if(!columnName.equalsIgnoreCase("site_id"))
                        {
                            if( columnName.indexOf( "_ORDER" ) != -1)
                            {
                                String colname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_PROMPT" ;
								String applcolname = (columnName.substring(0,columnName.indexOf( "_ORDER" )))+"_APPL_YN" ;
								
								String appl_yn = "N";
								int ord = rset.getInt( columnName ) ;
								appl_yn = rset.getString(applcolname);
								if (appl_yn == null) appl_yn = "N";

                                if(ord!= 0 && appl_yn.equals("Y"))
                                {
                                    tot_count++ ;
                                    colnamearray[ord-1] = colname ;
                                    prompts[ord-1] = rset.getString(colname);
                                    if(prompts[ord-1] == null) prompts[ord-1] = "&nbsp;" ;

                                    for( int j=0; j<8;j++)
                                    {
                                        if( colname.indexOf(elements_ord[j]) != -1)
                                        {
                                            elements[ord-1] = elements_val[j] ;
                                            break ;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            String[] prompts_temp       = new String [tot_count];
            String[] elements_temp      = new String [tot_count];
            String[] colnamearray_temp	= new String [tot_count];
            tot_count = 0 ;
            for(int i=0; i<prompts.length; i++)
            {
                if(prompts[i] != null)
                {
                    prompts_temp[tot_count]      = prompts[i] ;
                    elements_temp[tot_count]     = elements[i] ;    
                    colnamearray_temp[tot_count] = colnamearray[i] ;
                    tot_count++ ;
                }
            }

            return_arrlist.add(colnamearray_temp);
            return_arrlist.add(prompts_temp);
            return_arrlist.add(elements_temp);

			if(rset != null) rset.close();
			if(rset1 != null) rset1.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
        }
		catch(Exception e)
        { }
        return return_arrlist ;
    }

	String rec_diag_from_admit_pat_yn="";
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            _bw.write(_wl_block7_2Bytes, _wl_block7_2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block8Bytes, _wl_block8);
	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_id  = (String)session.getValue("facility_id");
	String sStyle		= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale		= (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);


	
	Connection con			= null;
	Statement stmt			= null;
	PreparedStatement pstmt = null;
	Statement ipBlIntfStmt	= null;
	ResultSet ipBlIntfrs	= null; 
	ResultSet rs			= null; 
	ResultSet rset			= null;
	Statement chkinstmt     = null;
	ResultSet chkinrs       = null;
	Statement nbstmt		= null;
	ResultSet nbrs			= null;
	String ServiceDesc		= "";
	String ancillaryyn      = "";
	String bedclasscode     = "";
	String bedno			= "";
	String dlycharge        = "";
	String nursingunitcode  = "";
	String nursingunitdesc	= "";
	String roomno			= "";
	String servicedesc      = "";
	String splty_code		= "";
	String splty_desc		= "";
	String systemDate		= "";
	String systemDate_converted		= "";
	//String bed_assigned_for_nb_yn	= "N";
	String reason_reqd_Flag	= "N";
	
	//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
	String tab_width="100%";

	reason_reqd_Flag	= checkForNull(request.getParameter("reason_reqd_Flag"));	// modified for MMS-QH-CRF-0144
	String backdated_admission_yn	= checkForNull(request.getParameter("backdated_admission_yn"));	
	String nurs_unt_auth_val		= checkForNull(request.getParameter("nurs_unt_auth_val"));	
	String deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"));	
	String back_date				= checkForNull((String)request.getParameter("back_date"));
	String adm_date_chk_days		= checkForNull((String)request.getParameter("adm_date_chk_days"));// Added for PE By Sudhakar
	String adm_date_chk_days_type	= checkForNull((String)request.getParameter("adm_date_chk_days_type"));// Added for PE By Sudhakar
	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"));	
	String bkg_grace_period			= checkForNull(request.getParameter("bkg_grace_period"));	
	String pat_check_in_allowed_yn	= checkForNull(request.getParameter("pat_checkin_yn"));	
	String callfunc					= checkForNull(request.getParameter("P_call_func"));
	String returnvalue				= checkForNull(request.getParameter("P_retval"));
	returnvalue						= returnvalue.replace('|','&');
	//String patientid				= checkForNull(request.getParameter("patient_id"));
	String p_oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String loginUser				= (String)session.getValue("login_user");
	String bl_operational			= (String)session.getValue("bl_operational");
	StringTokenizer st				= new StringTokenizer(returnvalue,"^");
	StringBuffer sqlSb				= new StringBuffer();
        String bed_mandatory_for_admn_yn= checkForNull(request.getParameter("bed_mandatory_for_admn_yn"),"N");
	boolean assignBed_auth			= true;
	//below code added for ABM CRF 643.1 ICN:36736
	String from_adv_bed_mgmt		= checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");
	String bedNo					= checkForNull((String)request.getParameter("bedNo"));
	String nursing_unit				= checkForNull((String)request.getParameter("nursing_unit"));
	String appl_patient_class		= checkForNull((String)request.getParameter("appl_patient_class"));
	
	//Below line added for this CRF GDOH-CRF-0129 	
	Boolean isReferral=false;
	
		/*Below line Added for this CRF  Bru-HIMS-CRF-261*/
	
	boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601

	boolean isAttendPractAppl = false; // added by mujafar against ML-MMOH-SCF-1316

	String quick_admission_type	= checkForNull((String)request.getParameter("quick_admission_type"));
	String quick_adm_referralid	= checkForNull((String)request.getParameter("quick_adm_referralid"));
	String quick_adm= checkForNull((String)request.getParameter("quick_adm"));
	String ref_encounter_id=checkForNull((String)request.getParameter("ref_encounter_id"));
	if (st.hasMoreTokens())
	{				
		nursingunitcode = st.nextToken();
		if (st.hasMoreTokens())
		{
			bedno			= checkForNull(st.nextToken());
			bedclasscode	= checkForNull(st.nextToken());
			roomno			= checkForNull(st.nextToken());
			servicedesc		= checkForNull(st.nextToken());
			ancillaryyn		= checkForNull(st.nextToken());
			dlycharge		= checkForNull(st.nextToken());
			nursingunitdesc = checkForNull(st.nextToken());
			splty_code		= checkForNull(st.nextToken());
			splty_desc		= checkForNull(st.nextToken());
		}
	}
	String f_nursing_unit = checkForNull((String)request.getParameter("f_nursing_unit"));
	if(!f_nursing_unit.equals("")) nursingunitdesc = f_nursing_unit;
	String str_bl_package_enabled_yn="N";
	try
	{
		con =ConnectionManager.getConnection(request);
		Boolean isForm60Available	= CommonBean.isSiteSpecific(con, "MP","REG_PAT_ALT_ID3_PAN_CARD"); //Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799]

		Boolean validationForPanCardAvail	= CommonBean.isSiteSpecific(con,"MP","GENERATE_FORM_60"); //Added by Sangeetha on  10/apr/17 for KDAH-CRF-0347

		Boolean restrictPseudoBed	= CommonBean.isSiteSpecific(con,"IP","RESTRICT_PSEUDO_BED"); //Added by Sangeetha on  23/05/17 for GDOH-CRF-0151

		Boolean isPsychiatryFormAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","PSYCHIATRY_FORM"); //Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
		
		//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
		if(isPsychiatryFormAppl && quick_adm.equals("Quick_admission"))
		{
			tab_width="1020px";
		}

	   //Below line added for this GDOH-CRF-0129
       isReferral=CommonBean.isSiteSpecific(con, "IP","REGISTER_REFERRAL");

	   isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601

	   isAttendPractAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","ATTND_PRACT_FROM_REF_APPL_IP"); //Added by mujafar for ML-MMOH-SCF-1316

/**************Added for package billing **************starts***/	
	//Commented for PE By Sudhakar
	/*try{				
			PreparedStatement pstmt1=con.prepareStatement("select bl_package_enabled_yn('"+facility_id	+"') from dual");	
			ResultSet rs2 = pstmt1.executeQuery();	
			if( rs2 != null ) 
			{
				if( rs2.next() )
				{			
					str_bl_package_enabled_yn  =  rs2.getString(1);	
				}
			}
			if(str_bl_package_enabled_yn == null) str_bl_package_enabled_yn="N";			
			pstmt1.close();
			if(rs2!=null) rs2.close();			
			}catch(Exception e){
			}*/
/**************Added for package billing **************ends***/		
		/*if(!patientid.equals(""))
		{
			nbstmt = con.createStatement();
			nbrs = nbstmt.executeQuery(" select bed_assigned_for_nb_yn from MP_PATIENT where patient_id = '"+patientid+"'");
			
			if(nbrs!=null && nbrs.next())
				bed_assigned_for_nb_yn = checkForNull(nbrs.getString("bed_assigned_for_nb_yn"),"N");

			 if(nbrs!=null) nbrs.close();
			 if(nbstmt!=null) nbstmt.close();
		}*/

		if (!nursingunitcode.equals("") && from_adv_bed_mgmt.equals("N"))
		{
			//stmt = con.createStatement();
			//rs = stmt.executeQuery("Select AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where nursing_unit_code = '"+nursingunitcode+"' and facility_id = '"+facility_id+"'");
			pstmt = con.prepareStatement("Select AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURSING_UNIT where nursing_unit_code =? and facility_id = ?");
			pstmt.setString(1, locale);
			pstmt.setString(2, nursingunitcode);
			pstmt.setString(3, facility_id);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				ServiceDesc = checkForNull(rs.getString("service_short_desc"));
				if(rs!=null) rs.close();
		   }
		}
		String bed_class_code="";
		String bed_class_desc="";
		String bed_type_code="";
		String bed_type_desc="";
		if (from_adv_bed_mgmt.equals("Y")){
			nursingunitcode=nursing_unit;
			bedno=bedNo;
			/*stmt = con.createStatement();
			rs = stmt.executeQuery("Select AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where nursing_unit_code = '"+nursingunitcode+"' and facility_id = '"+facility_id+"'");
			if (rs.next())
			{
				nursingunitdesc = checkForNull(rs.getString("service_short_desc"));
				if(rs!=null) rs.close();
		   }*/
		   
			/* stmt = con.createStatement(); */
			//rs = stmt.executeQuery("Select ip_get_desc.IP_NURSING_UNIT('"+facility_id+"','"+nursingunitcode+"','"+locale+"','2')nursing_unit_short_desc from dual");
			String sql="select ROOM_NO,BED_CLASS_CODE, ip_get_desc.IP_BED_CLASS(bed_class_code,?,'2') bed_class_short_desc,BED_TYPE_CODE,ip_get_desc.IP_BED_TYPE(bed_type_code,?,'2') bed_type_short_desc,ip_get_desc.IP_NURSING_UNIT(facility_id,NURSING_UNIT_CODE,?,'2')nursing_unit_short_desc,SPECIALTY_CODE,am_get_desc.AM_SPECIALITY(specialty_code,?,'2') specialty_short_desc from ip_nursing_unit_bed where bed_no=?";

/* 			rs = stmt.executeQuery(sql); */
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, locale);
			pstmt.setString(2, locale);
			pstmt.setString(3, locale);
			pstmt.setString(4, locale);
			pstmt.setString(5, bedNo);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				nursingunitdesc = checkForNull(rs.getString("nursing_unit_short_desc"));
				roomno=checkForNull(rs.getString("ROOM_NO"));
				bed_class_code=checkForNull(rs.getString("bed_class_code"));
				bed_class_desc=checkForNull(rs.getString("bed_class_short_desc"));
				bed_type_code=checkForNull(rs.getString("bed_type_code"));
				bed_type_desc=checkForNull(rs.getString("bed_type_short_desc"));
				splty_code=checkForNull(rs.getString("SPECIALTY_CODE"));
				splty_desc=checkForNull(rs.getString("specialty_short_desc"));
				if(rs!=null) rs.close();
		   }
		}
		if(rs != null) rs.close();
		//if(stmt != null) stmt.close();
		if(pstmt != null) pstmt.close();

		stmt = con.createStatement();		
		if(adm_date_chk_days_type.equals("H")){
			if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());
			sqlSb.append("Select to_char(sysdate,'dd/mm/rrrr hh24:mi')systemDate");
			if(bl_interfaced_yn.equals("Y"))
				sqlSb.append(",bl_package_enabled_yn(?)bl_package_enable_yn");
			sqlSb.append(",TO_CHAR(SYSDATE-?/24,'dd/mm/rrrr hh24:mi') setup_date from dual");
			pstmt = con.prepareStatement(sqlSb.toString());
			if(bl_interfaced_yn.equals("Y")){
				pstmt.setString(1, facility_id);
				pstmt.setString(2, adm_date_chk_days);
			}else{
				pstmt.setString(1, adm_date_chk_days);	
			}
			
			
			
			rs = pstmt.executeQuery();
			System.out.println("Check 3 if");
//			rs = stmt.executeQuery(sqlSb.toString());
		}else{
			if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());
			sqlSb.append("Select to_char(sysdate,'dd/mm/rrrr hh24:mi')systemDate");
			if(bl_interfaced_yn.equals("Y"))
				sqlSb.append(",bl_package_enabled_yn(?)bl_package_enable_yn");
			sqlSb.append(",TO_CHAR(SYSDATE-?,'dd/mm/rrrr hh24:mi') setup_date from dual");
			pstmt = con.prepareStatement(sqlSb.toString());
			if(bl_interfaced_yn.equals("Y")){
				pstmt.setString(1, facility_id);
				pstmt.setString(2, adm_date_chk_days);
			}else{
				pstmt.setString(1, adm_date_chk_days);
			}
			rs = pstmt.executeQuery();
			//rs = stmt.executeQuery(sqlSb.toString());
		}
		if (rs.next())
		{
			systemDate = checkForNull(rs.getString("systemDate"));
			if(bl_interfaced_yn.equals("Y"))
				str_bl_package_enabled_yn  =  checkForNull(rs.getString("bl_package_enable_yn"),"N");
			back_date  =  checkForNull(rs.getString("setup_date"));
			if(!(systemDate.equals("") || systemDate == null))
				systemDate_converted = DateUtils.convertDate(systemDate,"DMYHM","en",locale); 
		}
		if (servicedesc.equalsIgnoreCase(""))servicedesc = ServiceDesc;
		boolean isBlInterfaced = false;
		if(bl_interfaced_yn.equals("Y"))
			isBlInterfaced = true;
		else 
			isBlInterfaced = false;

		String admissiondate = "";
		if(nurs_unt_auth_val == null || nurs_unt_auth_val.equals("N"))
			assignBed_auth = false;
		if(backdated_admission_yn.equals("N") || backdated_admission_yn==null)
			admissiondate = "readOnly";
		else
			admissiondate = "";
			
		/*Added Below Line code for [AK-SCF-0153] by Senthil */
			String language_direction="";
			if(rs != null) rs.close();
		   // if(stmt != null) stmt.close();
		    if(pstmt != null) pstmt.close();
			int count=0;
			//stmt=con.createStatement() ;
			pstmt=con.prepareStatement("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID=?");
			//preparedStatement pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			pstmt.setString(1, locale);
			
		   rs = pstmt.executeQuery() ;
		   /* rs = stmt.executeQuery("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID='"+locale+"'" ) ; */
				 
			 if ( rs != null && rs.next() ) 
			 {
			 count = rs.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "RTL" ;
			}else
			{
				 language_direction = "LTR" ;
			}
			
			if(rs!=null)rs.close();
			/*Added Above Line code for [AK-SCF-0153] by Senthil */	
			
			
			
			
			
			
	
            _bw.write(_wl_block11Bytes, _wl_block11);
	if(bl_operational.equals("Y"))	
		{	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	}	
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(isPsychiatryFormAppl && quick_adm.equals("Quick_admission")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tab_width));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(splty_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(isPsychiatryFormAppl){
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
if(isPsychiatryFormAppl){
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(splty_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(nursingunitdesc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nursingunitdesc));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
	if(bl_operational.equals("Y"))
				{	
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
	}
				else
				{	
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
	}	
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block45Bytes, _wl_block45);
if(from_adv_bed_mgmt.equals("Y")){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bed_class_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_bl_package_enabled_yn));
            _bw.write(_wl_block53Bytes, _wl_block53);
if(from_adv_bed_mgmt.equals("Y")){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bed_type_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
  // If assign bed authorization is there it will accept the bed no else it will be disabled
			// Modified by Sangeetha on  23/05/17 for GDOH-CRF-0151
			if(assignBed_auth || from_adv_bed_mgmt.equals("Y"))
			{	
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bedno));
            _bw.write(_wl_block57Bytes, _wl_block57);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block58Bytes, _wl_block58);
 }
            _bw.write(_wl_block59Bytes, _wl_block59);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block60Bytes, _wl_block60);
 }
            _bw.write(_wl_block61Bytes, _wl_block61);
if(bed_mandatory_for_admn_yn.equals("Y")){
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
	}
			else
			{	// Modified by Sangeetha on  23/05/17 for GDOH-CRF-0151 
            _bw.write(_wl_block65Bytes, _wl_block65);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block60Bytes, _wl_block60);
 }
            _bw.write(_wl_block66Bytes, _wl_block66);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block60Bytes, _wl_block60);
 }
            _bw.write(_wl_block61Bytes, _wl_block61);
if(bed_mandatory_for_admn_yn.equals("Y")){
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
	}	
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
	if(assignBed_auth || from_adv_bed_mgmt.equals("Y"))
			{	
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block70Bytes, _wl_block70);
	}
			else
			{	
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block71Bytes, _wl_block71);
	}	
            _bw.write(_wl_block72Bytes, _wl_block72);
      if(bl_operational.equals("Y")) 
			{
				out.println("</tr>");
				
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(dlycharge));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(dlycharge));
            _bw.write(_wl_block75Bytes, _wl_block75);
	}	
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(systemDate_converted));
            _bw.write(_wl_block79Bytes, _wl_block79);
if(bl_operational.equals("Y"))	
		{
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(systemDate_converted));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
if(isReferral){
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
 if("Y".equals(reason_reqd_Flag)) {
            _bw.write(_wl_block99Bytes, _wl_block99);
}
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(reason_reqd_Flag));
            _bw.write(_wl_block101Bytes, _wl_block101);
}
			 else{
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
 if("Y".equals(reason_reqd_Flag)) {
            _bw.write(_wl_block99Bytes, _wl_block99);
}
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(reason_reqd_Flag));
            _bw.write(_wl_block105Bytes, _wl_block105);
}
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
if(!isPsychiatryFormAppl){
            _bw.write(_wl_block109Bytes, _wl_block109);
}else{
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
}
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
if(isPsychiatryFormAppl && quick_adm.equals("Quick_admission")){
            _bw.write(_wl_block122Bytes, _wl_block122);
}
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(backdated_admission_yn));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(systemDate));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(ancillaryyn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(from_adv_bed_mgmt));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(callfunc));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(rec_diag_from_admit_pat_yn));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(isAlternateAddressAppl));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(isAttendPractAppl));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(back_date));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(adm_date_chk_days));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(adm_date_chk_days_type));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(isBlInterfaced));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(isBlInterfaced));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(isForm60Available));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(validationForPanCardAvail));
            _bw.write(_wl_block144Bytes, _wl_block144);
if(bl_operational.equals("Y")) {
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
	}	
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(callfunc));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(nurs_unt_auth_val));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(bed_mandatory_for_admn_yn));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(str_bl_package_enabled_yn));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block157Bytes, _wl_block157);
/*Below line Added for this CRF  Bru-HIMS-CRF-261*/
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(quick_admission_type));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(quick_adm_referralid));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(quick_adm));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(ref_encounter_id));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(isReferral));
            _bw.write(_wl_block163Bytes, _wl_block163);

		if(from_adv_bed_mgmt.equals("Y")){
	
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(appl_patient_class));
            _bw.write(_wl_block165Bytes, _wl_block165);

		}
	
            _bw.write(_wl_block166Bytes, _wl_block166);

      
			if(ipBlIntfrs!=null) ipBlIntfrs.close();
			if(rset!=null)  rset.close();
			if(rs!=null)    rs.close();
			if(stmt!=null)  stmt.close();
			if(chkinstmt!=null) chkinstmt.close();
			if(chkinrs!=null) chkinrs.close();
			if(ipBlIntfStmt!=null) ipBlIntfStmt.close();
			if(nbstmt!=null) nbstmt.close();
			if(nbrs!=null) nbrs.close();

        }catch(Exception e)
		{
			//out.println("Exception in addModifyAdmitPatient.jsp : "+e.toString());
            e.printStackTrace();

        }   
        finally   
        {
			if(con != null)
				if(con != null)ConnectionManager.returnConnection(con,request);  
        }
    
            _bw.write(_wl_block167Bytes, _wl_block167);
            _bw.write(_wl_block168Bytes, _wl_block168);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraldetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitDetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.subservice.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounter.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ambulatorystatus.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpdaysofStay.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectesDischargeDate.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ProcedureSurgeryDateTime.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmittingPractitioner.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Referralfrom.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforAdmission.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PsychiatryForm.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outstandingamount.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmissionApprovalDtls.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.EscortAmbulanceService.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeofArrival.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.telno.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MVRegnNo.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.EmergencyDetail.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }
}
