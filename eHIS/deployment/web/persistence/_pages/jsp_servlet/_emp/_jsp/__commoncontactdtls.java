package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eMP.MPCommonBean;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __commoncontactdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/CommonContactDtls.jsp", 1742478669460L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emp/jsp/PatientAddressLegends.jsp", 1744875458541L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head><title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block8_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block8_2Bytes = _getBytes( _wl_block8_2 );

    private final static java.lang.String  _wl_block9 ="\n\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration3.js\'></Script>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11_0 ="\'></link>\n\t<script src=\'../../eMP/js/RegPatReferral.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\n\t\tasync function searchCountry(obj,target)\n\t\t{\n\t\t\tvar retVal =    new String();\n\t\t\tvar argumentArray  = new Array() ;\n\t\t\t\t\tvar dataNameArray  = new Array() ;\n\t\t\t\t\tvar dataValueArray = new Array() ;\n\t\t\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\t\t\tvar locale=document.forms[0].locale.value;\n\n\t\t\t\t\tvar tit=\"\";\t\t\t\t\n\t\t\t\t\tif(obj.name == \"contry_code\" )\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(target.name == \'nationality_desc\'){\n\t\t\t\t\t\t\ttit=getLabel(\"Common.nationality.label\",\"common\");\n\t\t\t\t\t\t//tit=\"Nationality\"\n\t\t\t\t\t\tsql=\"Select country_code code,long_desc description from Mp_Country_lang_vw where language_id = \'\"+locale+\"\' AND eff_status=\'E\' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?)\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\ttit=getLabel(\"Common.country.label\",\"common\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tsql=\"Select country_code code,long_name description from Mp_Country_lang_vw where language_id = \'\"+locale+\"\' AND eff_status=\'E\' and upper(country_code) like upper(?) and upper(long_name) like upper(?)\";\n\t\t\t\t\t\t}\n\t\t\t\t\t  }\n\t\t\t\t\targumentArray[0] =sql;\n\t\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\t\targumentArray[5] = target.value;\n\t\t\t\t\targumentArray[6] = DESC_LINK  ;\n\t\t\t\t\targumentArray[7] = DESC_CODE ;\n\n\t\t\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\t\t\t\tif(!(retVal== null && retVal== \"\" ))\n\t\t\t\t\t{\n\t\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\t\t\ttarget.value=arr[1];\n\t\t\t\t\t\tif(target.name == \'nationality_desc\')\n\t\t\t\t\t\t   document.forms[0].nationality_code.value= arr[0];\n\t\t\t\t\t\telse if(target.name == \'r_country_desc\')\n\t\t\t\t\t\t  document.forms[0].r_country_code.value= arr[0];\n\t\t\t\t\t\t\t\n\t\t\t\t\t\telse if(target.name == \'m_country_desc\')\n\t\t\t\t\t\t\tdocument.forms[0].m_country_code.value= arr[0];\n\t\t\t\t\t\telse if(target.name == \'first_country_desc\')\n\t\t\t\t\t\t\tdocument.forms[0].first_country_code.value= arr[0];\n\t\t\t\t\t\telse if(target.name == \'next_country_desc\')\n\t\t\t\t\t\t\tdocument.forms[0].next_country_code.value= arr[0];\n\t\t\t\t\t\telse if(target.name == \'empyr_country_desc\')\n\t\t\t\t\t\t\tdocument.forms[0].empyr_country_code.value= arr[0];\n\t\t\t\t\t\t/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/\n\t\t\t\t\t\telse if(target.name == \'a_country_desc\')\n\t\t\t\t\t\t\tdocument.forms[0].a_country_code.value= arr[0];/*End*/\n\t\t\t\t\t}\n\t\t\t\t\tif(retVal==null || retVal==\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\ttarget.value=\'\';\n\t\t\t\t\t\ttarget.focus();\n\t\t\t\t\t}\n\t\t\t\t}\t\n\t  \n\nfunction checkVVC(){\n\n\t\n\tif(document.forms[0].isVirtualConsultation){\n\t\tvar visit_type_code = document.forms[0].visit_type_code.value;\n\t\tvar xmlDoc=\"\"\n\t\tvar xmlHttp = new XMLHttpRequest()\t\t\n\t\tvar fac_id = document.getElementById(\'facility_id\').value;\n\t\txmlStr = \"<root><SEARCH visit_type_code=\\\"\"+visit_type_code+\"\\\" facility_id=\\\"\"+fac_id+\"\\\" action=\'isVirtualVisit\' /></root>\"\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\txmlHttp.open(\"POST\",\"../../eOP/jsp/OPIntermediate.jsp\",false)\n\t\txmlHttp.send(xmlDoc)\n\t\tresponseText = xmlHttp.responseText\n\t\tvar response = trimString(xmlHttp.responseText);\n\t\tdocument.forms[0].isVisitTypeVirtualEnabled.value = response;\n\t}\n}\n\n\t\t\t\tfunction close_me()\n\t\t\t\t{\n\t\t\t\t\tvar isAlternateAddressAppl = document.forms[0].isAlternateAddressAppl.value;//Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601\n\t\t\t\t\tif(document.forms[0].r_addr_line1)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.forms[0].r_addr_line1.value != \"\")\n\t\t\t\t\t\t\tdocument.forms[0].addr1_line1.value\t\t= document.forms[0].r_addr_line1.value; \n\t\t\t\t\t\telse document.forms[0].addr1_line1.value\t=\"\";\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].r_addr_line2)\n\t\t\t\t\t\tdocument.forms[0].addr1_line2.value\t\t= document.forms[0].r_addr_line2.value; \n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].addr1_line2.value\t= \"\";\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].r_addr_line3)\n\t\t\t\t\t\tdocument.forms[0].addr1_line3.value\t= document.forms[0].r_addr_line3.value; \n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].addr1_line3.value\t= \"\";\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].r_addr_line4)\n\t\t\t\t\t\tdocument.forms[0].addr1_line4.value\t= document.forms[0].r_addr_line4.value;\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].addr1_line4.value = \"\";\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].r_town_code != null)\n\t\t\t\t\t{\t\n\t\t\t\t\t\tif(document.forms[0].r_town_code.value != \"\")\n\t\t\t\t\t\t\tdocument.forms[0].res_town_code.value= document.forms[0].r_town_code.value; \n\t\t\t\t\t\tif(document.forms[0].r_town_code == null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_town.value = \"\";\n\t\t\t\t\t\t\tdocument.forms[0].r_town_code.value = \"\";\n\t\t\t\t\t\t\tdocument.forms[0].res_town_code.value = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].r_area_code != null)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.forms[0].r_area_code.value != \"\")\n\t\t\t\t\t\t\tdocument.forms[0].res_area_code.value\t= document.forms[0].r_area.value; \n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_area.value = \"\";\n\t\t\t\t\t\t\tdocument.forms[0].res_area_code.value = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].r_postal_code)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.forms[0].r_postal_code.value != \"\")\n\t\t\t\t\t\tdocument.forms[0].postal1_code.value\t= document.forms[0].r_postal_code.value ;\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].postal1_code.value =\"\";\n\t\t\t\t\t\t\tdocument.forms[0].r_postal_code.value=\"\";\n\t\t\t\t\t\t\tdocument.forms[0].postal1_code.value\t\t=\"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.forms[0].r_region_code.value!=\"\")\n\t\t\t\t\t\t\tdocument.forms[0].region_code1.value= document.forms[0].r_region.value;\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_region.value=\"\";\n\t\t\t\t\t\t\tdocument.forms[0].r_region_code.value = \"\";\n\t\t\t\t\t\t\tdocument.forms[0].region_code1.value= \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].r_country_code)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.forms[0].r_country_code.value != \"\")\n\t\t\t\t\t\t\tdocument.forms[0].country1_code.value = document.forms[0].r_country_code.value;\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_country_desc.value\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].r_country_code.value\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].country1_code.value\t= \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].m_addr_line1)\n\t\t\t\t\t\tdocument.forms[0].addr2_line1.value = document.forms[0].m_addr_line1.value;   \n\t\t\t\t\telse document.forms[0].addr2_line1.value = \"\";\n\t\t\t\t\tif(document.forms[0].m_addr_line2)\n\t\t\t\t\tdocument.forms[0].addr2_line2.value = document.forms[0].m_addr_line2.value;  \n\t\t\t\t\telse document.forms[0].addr2_line2.value = \"\";\n\t\t\t\t\tif(document.forms[0].m_addr_line3)\n\t\t\t\t\tdocument.forms[0].addr2_line3.value\t= document.forms[0].m_addr_line3.value;   \n\t\t\t\t\telse document.forms[0].addr2_line3.value = \"\";\n\t\t\t\t\tif(document.forms[0].m_addr_line4)\n\t\t\t\t\t\tdocument.forms[0].addr2_line4.value = document.forms[0].m_addr_line4.value;   \n\t\t\t\t\telse document.forms[0].addr2_line4.value = \"\";\n\t\t\t\t\tif(document.forms[0].m_town_code)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.forms[0].m_town_code.value != \"\")\n\t\t\t\t\t\t\tdocument.forms[0].res2_town_code.value = document.forms[0].m_town_code.value; \n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].m_town_code.value\t\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].m_town.value\t\t\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].res2_town_code.value\t= \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].m_area_code != null)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.forms[0].m_area_code.value != \"\")\n\t\t\t\t\t\t\tdocument.forms[0].res2_area_code.value\t= document.forms[0].m_area_code.value; \n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].m_area_code.value\t\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].m_area.value\t\t\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].res2_area_code.value\t= \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].m_postal_code)\n\t\t\t\t\t\tdocument.forms[0].postal2_code.value = document.forms[0].m_postal_code.value;\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.forms[0].m_postal_code)\n\t\t\t\t\t\t\tdocument.forms[0].m_postal_code.value = \"\";\n\t\t\t\t\t\tif(document.forms[0].postal2_code)\n\t\t\t\t\t\t\tdocument.forms[0].postal2_code.value = \"\";\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.forms[0].m_region_code.value != \"\")\n\t\t\t\t\t\t\tdocument.forms[0].region2_code.value\t= document.forms[0].m_region_code.value; \n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].m_region_code.value\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].m_region.value\t\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].region2_code.value\t= \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].m_country_code)\n\t\t\t\t\t\tdocument.forms[0].country2_code.value = document.forms[0].m_country_code.value;\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].m_country_code.value\t= \"\";\n\t\t\t\t\t\tdocument.forms[0].m_country_desc.value\t= \"\";\n\t\t\t\t\t\tdocument.forms[0].country2_code.value\t= \"\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(document.forms[0].txtPrimResNo)\n\t\t\t\t\t\tdocument.forms[0].contact1_no.value = document.forms[0].txtPrimResNo.value;\n\t\t\t\t\telse \n\t\t\t\t\t\tdocument.forms[0].contact1_no.value = \"\";\n\t\t\t\t\tif(document.forms[0].txtOtherResNo)\n\t\t\t\t\t\tdocument.forms[0].contact2_no.value\t= document.forms[0].txtOtherResNo.value;\n\t\t\t\t\telse \n\t\t\t\t\t\tdocument.forms[0].contact2_no.value = \"\";\n\t\t\t\t\tif(document.forms[0].txtEmail)\n\t\t\t\t\t\tdocument.forms[0].email.value = document.forms[0].txtEmail.value;\n\t\t\t\t\telse\n\t\t\t\t\t\tdocument.forms[0].email.value = \"\";\n\t\t\t\t\t\n\t\t\t\t\tif(document.forms[0].r_country_desc)\n\t\t\t\t\t{\n\t\t\t\t\t\t if(document.forms[0].r_country_desc.value != \"\")\n\t\t\t\t\t\t\tdocument.forms[0].country1_desc.value = document.forms[0].r_country_desc.value;\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].r_country_desc.value\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].r_country_code.value\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].country1_desc.value\t= \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].m_country_desc)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.forms[0].m_country_desc.value != \"\")\n\t\t\t\t\t\t\tdocument.forms[0].country2_desc.value = document.forms[0].m_country_desc.value;\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].m_country_code.value\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].m_country_code.value\t= \"\";\n\t\t\t\t\t\t\tdocument.forms[0].country2_desc.value\t= \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t//the symbol used to concatenate is ALT 15\n\t\t\t\t\t\n\t\t\t\t\t/*Added by Thamizh selvi on 19th Feb 2018 against ML-MMOH-CRF-0601 Start*/\n\t\t\t\t\tif(isAlternateAddressAppl == \"true\"){\n\t\t\t\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\t\t\t\tif(document.forms[0].a_country_desc && document.forms[0].a_country_desc.value == \"\")\n\t\t\t\t\t\t\tdocument.forms[0].a_country_code.value\t= \"\";\n\t\n\t\t\t\t\t\tif(document.forms[0].a_town_code && document.forms[0].a_town_code.value == \"\")\n\t\t\t\t\t\t\tdocument.forms[0].a_town.value\t= \"\";\n\t\t\t\t\t\n\t\t\t\t\t\tif(document.forms[0].a_area_code && document.forms[0";
    private final static byte[]  _wl_block11_0Bytes = _getBytes( _wl_block11_0 );

    private final static java.lang.String  _wl_block11_1 ="].a_area_code.value == \"\")\n\t\t\t\t\t\t\tdocument.forms[0].a_area.value\t= \"\";\n\t\t\t\t\t\n\t\t\t\t\t\tif(document.forms[0].a_region_code && document.forms[0].a_region_code.value == \"\")\n\t\t\t\t\t\t\tdocument.forms[0].a_region.value\t= \"\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(document.forms[0].alt_postal_code1 && document.forms[0].alt_postal_code1.value == \"\")\n\t\t\t\t\t\t\tdocument.forms[0].alt_postal_code.value\t= \"\";\t\n\t\t\t\t\t}/*End*/\n\n\t\t\t\tvar addr1_line1 = \"\";\n\t\t\t\tvar addr1_line2 = \"\";\n\t\t\t\tvar addr1_line3 = \"\";\n\t\t\t\tvar addr1_line4 = \"\";\n\n\t\t\t\tvar addr2_line1 = \"\";\n\t\t\t\tvar addr2_line2 = \"\";\n\t\t\t\tvar addr2_line3 = \"\";\n\t\t\t\tvar addr2_line4 = \"\";\n\t\t\n\t\t\t\tvar r_town_code_value = \"\";\n\t\t\t\tvar r_town_desc_value = \"\";\n\t\t\t\tvar m_town_code_value = \"\";\n\t\t\t\tvar m_town_desc_value = \"\";\n\n\t\t\t\tvar r_area_code_value = \"\";\n\t\t\t\tvar r_area_desc_value = \"\";\n\t\t\t\tvar m_area_code_value = \"\";\n\t\t\t\tvar m_area_desc_value = \"\";\n\n\t\t\t\tvar r_region_code_value = \"\";\n\t\t\t\tvar r_region_desc_value = \"\";\n\t\t\t\tvar m_region_code_value = \"\";\n\t\t\t\tvar m_region_desc_value = \"\";\n\n\t\t\t\tvar postal1_code = \"\";\n\t\t\t\tvar postal2_code = \"\";\n\t\t\t\tvar cCodeForNxtofKin = \"\";\n\t\t\t\tvar nxtOfKinNo = \"\";\n\t\t\t\t//Added by Ajay Hatwate for ML-MMOH-CRF-1930\n\t\t\t\tvar country = \"\";\n\t\t\t\tvar telCode2 = \"\";\n\t\t\t\t//alert(document.forms[0].country.value + \' country value \' + document.forms[0].telephone.value);\n\t\t\t\tif(document.forms[0].country){\n\t\t\t\t\tcountry = document.forms[0].country.value;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].telephone){\n\t\t\t\t\ttelCode2 = document.forms[0].telephone.value;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(document.forms[0].txtNxtOfKin){\n\t\t\t\t\tnxtOfKinNo = document.forms[0].txtNxtOfKin.value;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].teleCodeHidden){\n\t\t\t\t\tcCodeForNxtofKin = document.forms[0].teleCodeHidden.value;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].countryC12){\n\t\t\t\t\tcCodeForNxtofKin = document.forms[0].countryC12.value;\n\t\t\t\t}\n\n\t\t\t\tif(document.forms[0].addr1_line1!=null)\n\t\t\t\t\taddr1_line1 = document.forms[0].addr1_line1.value;\n\t\t\t\tif(document.forms[0].addr1_line2!=null)\n\t\t\t\t\taddr1_line2 = document.forms[0].addr1_line2.value;\n\t\t\t\tif(document.forms[0].addr1_line3!=null)\n\t\t\t\t\taddr1_line3 = document.forms[0].addr1_line3.value;\n\t\t\t\tif(document.forms[0].addr1_line4!=null)\n\t\t\t\t\taddr1_line4 = document.forms[0].addr1_line4.value;\n\t\t\t\t\n\t\t\t\tif(document.forms[0].addr2_line1!=null)\n\t\t\t\t\taddr2_line1 = document.forms[0].addr2_line1.value;\n\t\t\t\tif(document.forms[0].addr2_line2!=null)\n\t\t\t\t\taddr2_line2 = document.forms[0].addr2_line2.value;\n\t\t\t\tif(document.forms[0].addr2_line3!=null)\n\t\t\t\t\taddr2_line3 = document.forms[0].addr2_line3.value;\n\t\t\t\tif(document.forms[0].addr2_line4!=null)\n\t\t\t\t\taddr2_line4 = document.forms[0].addr2_line4.value;\n\t\t\t\t\n\t\t\t\tif(document.forms[0].r_town_code!=null && document.forms[0].r_town != null) \n\t\t\t\t{\n\t\t\t\t\tr_town_code_value = document.forms[0].r_town.value;\n\t\t\t\t\tr_town_desc_value = document.forms[0].r_town_code.value;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].m_town_code!=null && document.forms[0].m_town != null) \n\t\t\t\t{\n\t\t\t\t\tm_town_code_value = document.forms[0].m_town.value;\n\t\t\t\t\tm_town_desc_value = document.forms[0].m_town_code.value;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].r_area_code!=null && document.forms[0].r_area != null) \n\t\t\t\t{\n\t\t\t\t\tr_area_code_value = document.forms[0].r_area.value;\n\t\t\t\t\tr_area_desc_value = document.forms[0].r_area_code.value;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].m_area_code!=null && document.forms[0].m_area != null) \n\t\t\t\t{\n\t\t\t\t\tm_area_code_value = document.forms[0].m_area.value;\n\t\t\t\t\tm_area_desc_value = document.forms[0].m_area_code.value;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].r_region_code!=null && document.forms[0].r_region!=null)\n\t\t\t\t{\n\t\t\t\t\tr_region_code_value = document.forms[0].r_region.value;\n\t\t\t\t\tr_region_desc_value = document.forms[0].r_region_code.value;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].m_region_code!=null && document.forms[0].m_region!=null) \n\t\t\t\t{\n\t\t\t\t\tm_region_code_value = document.forms[0].m_region.value;\n\t\t\t\t\tm_region_desc_value = document.forms[0].m_region_code.value;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].postal1_code!=null)\n\t\t\t\t\tpostal1_code = document.forms[0].postal1_code.value;\n\t\t\t\tif(document.forms[0].postal2_code!=null)\n\t\t\t\t\tpostal2_code = document.forms[0].postal2_code.value;\n\t\t\t\tvar r_postal_code1=\"\";\n\t\t\t\tvar m_postal_code1=\"\";\n\t\t\t\tif(document.forms[0].r_postal_code1!=null)\n\t\t\t\t\tr_postal_code1 = document.forms[0].r_postal_code1.value;\n\t\t\t\tif(document.forms[0].m_postal_code1!=null)\n\t\t\t\t\tm_postal_code1 = document.forms[0].m_postal_code1.value;\n\n\t\t\t\t/*Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601 Start*/\n\t\t\t\tif(isAlternateAddressAppl == \"true\"){\n\t\t\t\t\tvar addr3_line1 = \"\";\n\t\t\t\t\tvar addr3_line2 = \"\";\n\t\t\t\t\tvar addr3_line3 = \"\";\n\t\t\t\t\tvar addr3_line4 = \"\";\n\t\t\t\t\tvar a_town_code_value = \"\";\n\t\t\t\t\tvar a_town_desc_value = \"\";\n\t\t\t\t\tvar a_area_code_value = \"\";\n\t\t\t\t\tvar a_area_desc_value = \"\";\n\t\t\t\t\tvar a_region_code_value = \"\";\n\t\t\t\t\tvar a_region_desc_value = \"\";\n\t\t\t\t\tvar a_postal_code = \"\";\n\t\t\t\t\tvar a_postal_desc = \"\";\n\t\t\t\t\tvar a_country_code = \"\";\n\t\t\t\t\tvar a_country_desc = \"\";\n\t\t\t\t\t\n\t\t\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\t\t\tif(document.forms[0].a_addr_line1)\n\t\t\t\t\t\taddr3_line1\t\t\t= document.forms[0].a_addr_line1.value;\n\t\t\t\t\tif(document.forms[0].a_addr_line2)\n\t\t\t\t\t\taddr3_line2\t\t\t= document.forms[0].a_addr_line2.value;\n\t\t\t\t\tif(document.forms[0].a_addr_line3)\n\t\t\t\t\t\taddr3_line3\t\t\t= document.forms[0].a_addr_line3.value;\n\t\t\t\t\tif(document.forms[0].a_addr_line4)\n\t\t\t\t\t\taddr3_line4\t\t\t= document.forms[0].a_addr_line4.value;\n\t\t\t\t\tif(document.forms[0].a_town_code){\n\t\t\t\t\t\ta_town_code_value\t= document.forms[0].a_town.value;\n\t\t\t\t\t\ta_town_desc_value\t= document.forms[0].a_town_code.value;\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].a_area_code){\n\t\t\t\t\t\ta_area_code_value\t= document.forms[0].a_area.value;\n\t\t\t\t\t\ta_area_desc_value\t= document.forms[0].a_area_code.value;\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].alt_postal_code1){\n\t\t\t\t\t\ta_postal_code\t\t= document.forms[0].alt_postal_code.value;\n\t\t\t\t\t\ta_postal_desc\t\t= document.forms[0].alt_postal_code1.value;\t\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].a_region_code){\n\t\t\t\t\t\ta_region_code_value = document.forms[0].a_region.value;\n\t\t\t\t\t\ta_region_desc_value = document.forms[0].a_region_code.value;\n\t\t\t\t\t}\t\n\t\t\t\t\tif(document.forms[0].a_country_desc){\n\t\t\t\t\t\ta_country_code\t\t= document.forms[0].a_country_code.value;\n\t\t\t\t\t\ta_country_desc\t\t= document.forms[0].a_country_desc.value;\n\t\t\t\t\t}\n\t\t\t\t}/*End*/\n\n\t\t\tvar concat_vals = document.forms[0].addr1_type.value +\"^^\"\n\t\t\t+addr1_line1 +\"^^\"\n\t\t\t+addr1_line2 +\"^^\"\n\t\t\t+addr1_line3 +\"^^\"\n\t\t\t+addr1_line4 +\"^^\"\t\t\t\t \n\t\t\t+r_town_code_value +\"^^\"\n\t\t\t+r_area_code_value +\"^^\"\n\t\t\t+postal1_code +\"^^\"  \n\t\t\t+r_region_code_value +\"^^\"\n\t\t\t+document.forms[0].r_country_code.value\t+\"^^\"  \n\t\t\t+document.forms[0].contact1_name.value\t+\"^^\"   \n\t\t\t+document.forms[0].invalid1_yn.value +\"^^\"   \n\t\t\t+document.forms[0].addr2_type.value\t+\"^^\"   \n\t\t\t+addr2_line1 +\"^^\"   \n\t\t\t+addr2_line2 +\"^^\"   \n\t\t\t+addr2_line3 +\"^^\"   \n\t\t\t+addr2_line4 +\"^^\"   \n\t\t\t+m_town_code_value +\"^^\"\n\t\t\t+m_area_code_value +\"^^\"\t\t\n\t\t\t+postal2_code +\"^^\"  \n\t\t\t+m_region_code_value +\"^^\"\n\t\t\t+document.forms[0].m_country_code.value\t+\"^^\"  \n\t\t\t+document.forms[0].contact2_name.value +\"^^\" \n\t\t\t+document.forms[0].invalid2_yn.value +\"^^\"\n\t\t\t+document.forms[0].contact1_no.value +\"^^\"\n\t\t\t+document.forms[0].contact2_no.value +\"^^\"\n\t\t\t+document.forms[0].email.value +\"^^\"\n\t\t\t+r_town_desc_value +\"^^\"\n\t\t\t+r_area_desc_value +\"^^\"\n\t\t\t+r_region_desc_value +\"^^\"\n\t\t\t+m_town_desc_value +\"^^\"\n\t\t\t+m_area_desc_value +\"^^\"\n\t\t\t+m_region_desc_value +\"^^\"\n\t\t\t+document.forms[0].country1_desc.value +\"^^\"\n\t\t\t+document.forms[0].country2_desc.value +\"^^\"\n\t\t\t+r_postal_code1+\"^^\"\n\t\t\t+m_postal_code1;\n\t\t\t\n\t\t\t/*Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601 Start*/\n\t\t\tif(isAlternateAddressAppl == \"true\"){\n\t\t\t\tconcat_vals = concat_vals+\"^^\"\n\t\t\t\t+addr3_line1+\"^^\"\n\t\t\t\t+addr3_line2+\"^^\"\n\t\t\t\t+addr3_line3+\"^^\"\n\t\t\t\t+addr3_line4+\"^^\"\n\t\t\t\t+a_town_code_value+\"^^\"\n\t\t\t\t+a_area_code_value+\"^^\"\n\t\t\t\t+a_postal_code+\"^^\"\n\t\t\t\t+a_region_code_value+\"^^\"\n\t\t\t\t+a_country_code+\"^^\"\n\t\t\t\t+a_town_desc_value+\"^^\"\n\t\t\t\t+a_area_desc_value+\"^^\"\n\t\t\t\t+a_postal_desc+\"^^\"\n\t\t\t\t+a_region_desc_value+\"^^\"\n\t\t\t\t+a_country_desc;\n\t\t\t}/*End*/\n\t\t\tconcat_vals = concat_vals+\"^^\"\n\t\t\t+nxtOfKinNo+\"^^\"\n\t\t\t+cCodeForNxtofKin+\"^^\"+country+\"^^\"+telCode2; //added for ML-MMOH-CRF-1930\n\n\t\t\twindow.close();\t\n\t\t\twindow.returnValue =concat_vals;\n\t\t}\n\n\t\t/********************************************************/\n\t\tfunction populateContactdetails()\n\t\t{\n\t\t\t\n\t\t\t\n\t\t\tvar concat_vals=parent.window.dialogArguments;\n\t\t\tif(concat_vals == null || concat_vals == \'null\')\n\t\t\t{\n\t\t\t\tconcat_vals=\'\';\n\t\t\t}\n\t\t\t\n\t\t\tvar arr_concat_vals=concat_vals.split(\"^^\");\n\t\t\tvar change = unescape(arr_concat_vals[36]);\n\t\t\t\t\t\n\t\t\tif(arr_concat_vals[0])\n\t\t\t\tdocument.forms[0].addr1_type.value\t= unescape(arr_concat_vals[0]);      \n\t\t\tif(arr_concat_vals[1])\n\t\t\t\tdocument.forms[0].addr1_line1.value\t= unescape(arr_concat_vals[1]); \n\t\t\tif(arr_concat_vals[2])\n\t\t\t\tdocument.forms[0].addr1_line2.value\t= unescape(arr_concat_vals[2]); \n\t\t\tif(arr_concat_vals[3])\n\t\t\t\tdocument.forms[0].addr1_line3.value\t= unescape(arr_concat_vals[3]); \n\t\t\tif(arr_concat_vals[4])\n\t\t\t\tdocument.forms[0].addr1_line4.value\t= unescape(arr_concat_vals[4]);\n\t\t\tif(arr_concat_vals[5])\n\t\t\t{\n\t\t\t\tdocument.forms[0].r_town.value\t\t\t= unescape(arr_concat_vals[28]);\n\t\t\t\tdocument.forms[0].res_town_code.value\t= unescape(arr_concat_vals[5]);\n\t\t\t}\n\t\t\tif(arr_concat_vals[6])\n\t\t\t{\n\t\t\t\tdocument.forms[0].r_area.value\t\t\t= unescape(arr_concat_vals[6]);\n\t\t\t\tdocument.forms[0].res_area_code.value\t= unescape(arr_concat_vals[27]);\n\t\t\t}\n\t\t\t\n\t\t\tif(arr_concat_vals[7])\n\t\t\t\tdocument.forms[0].postal1_code.value\t= unescape(arr_concat_vals[7]);\n\t\t\tif(arr_concat_vals[8])\n\t\t\t\tdocument.forms[0].r_region.value\t\t= unescape(arr_concat_vals[8]);\n\t\t\t\n\t\t\tif(arr_concat_vals[9])\n\t\t\t{\n\t\t\t\tdocument.forms[0].r_country_code.value\t\t= \n\t\t\t\tunescape(arr_concat_vals[9]);       \n\t\t\t}\n\t\t\tif(arr_concat_vals[10])\n\t\t\t\tdocument.forms[0].contact1_name.value\t= unescape(arr_concat_vals[10]);\n\t\t\tif(arr_concat_vals[11])\n\t\t\t\tdocument.forms[0].invalid1_yn.value\t\t= unescape(arr_concat_vals[11]);\n\t\t\tif(arr_concat_vals[12])\n\t\t\t\tdocument.forms[0].addr2_type.value\t\t= unescape(arr_concat_vals[12]);       \n\t\t\tif(arr_concat_vals[13])\n\t\t\t\tdocument.forms[0].addr2_line1.value\t\t= unescape(arr_concat_vals[13]);   \n\t\t\tif(arr_concat_vals[14])\n\t\t\t\tdocument.forms[0].addr2_line2.value\t\t= unescape(arr_concat_vals[14]);  \n\t\t\tif(arr_concat_vals[15])\n\t\t\t\tdocument.forms[0].addr2_line3.value\t\t= unescape(arr_concat_vals[15]);   \n\t\t\tif(arr_concat_vals[16])\n\t\t\t\tdocument.forms[0].addr2_line4.value\t\t= unescape(arr_concat_vals[16]);   \n\t\t\tif(arr_concat_vals[17])\n\t\t\t{\n\t\t\t\tdocument.forms[0].m_town.value\t= unescape(arr_concat_vals[30]);\n\t\t\t\tdocument.forms[0].res2_town_code.value\t= unescape(arr_concat_vals[17]);\n\t\t\t}\n\t\t\tif(arr_concat_";
    private final static byte[]  _wl_block11_1Bytes = _getBytes( _wl_block11_1 );

    private final static java.lang.String  _wl_block11_2 ="vals[18])\n\t\t\t{\n\t\t\t\tdocument.forms[0].m_area.value\t\t\t= unescape(arr_concat_vals[31]);\n\t\t\t\tdocument.forms[0].res2_area_code.value\t= unescape(arr_concat_vals[18]);\n\t\t\t}\n\t\t\tif(arr_concat_vals[19])\n\t\t\t\tdocument.forms[0].postal2_code.value\t= unescape(arr_concat_vals[19]);\n\t\t\tif(arr_concat_vals[20])\n\t\t\t\tdocument.forms[0].region_code1.value\t= unescape(arr_concat_vals[20]);\n\t\t\tif(arr_concat_vals[21])\n\t\t\t\tdocument.forms[0].country2_code.value\t= unescape(arr_concat_vals[21]);\n\t\t\tif(arr_concat_vals[22])\n\t\t\t\tdocument.forms[0].contact2_name.value\t= unescape(arr_concat_vals[22]);\n\t\t\tif(arr_concat_vals[23])\n\t\t\t\tdocument.forms[0].invalid2_yn.value\t\t= unescape(arr_concat_vals[23]); \n\t\t\tif(arr_concat_vals[24])\n\t\t\t\tdocument.forms[0].txtPrimResNo.value\t= unescape(arr_concat_vals[24]); \n\t\t\tif(arr_concat_vals[25])\n\t\t\t\tdocument.forms[0].txtOtherResNo.value\t= unescape(arr_concat_vals[25]); \n\t\t\tif(arr_concat_vals[26])\n\t\t\t\tdocument.forms[0].txtEmail.value\t\t= unescape(arr_concat_vals[26]); \n\n\t\t\tvar readonly_yn = document.forms[0].readonly_yn.value;\n\t\t\tif(readonly_yn==\"Y\")\n\t\t\t{\n\t\t\t\tif(document.forms[0].r_addr_line1!=null && document.forms[0].m_addr_line1!=null)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_addr_line1.disabled = true;\n\t\t\t\t\tdocument.forms[0].m_addr_line1.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].r_addr_line2!=null && document.forms[0].m_addr_line2!=null)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_addr_line2.disabled = true;\n\t\t\t\t\tdocument.forms[0].m_addr_line2.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].r_addr_line3!=null && document.forms[0].m_addr_line3!=null)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_addr_line3.disabled = true;\n\t\t\t\t\tdocument.forms[0].m_addr_line3.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].r_addr_line4!=null && document.forms[0].m_addr_line4 != null)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_addr_line4.disabled = true;\n\t\t\t\t\tdocument.forms[0].m_addr_line4.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].r_town_code!=null && document.forms[0].m_town_code != null)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town_code.disabled = true;\n\t\t\t\t\tdocument.forms[0].m_town_code.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].r_area_code!=null && document.forms[0].m_area_code != null)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area_code.disabled\t= true;\n\t\t\t\t\tdocument.forms[0].m_area_code.disabled\t= true;\n\t\t\t\t\tdocument.forms[0].area_code.disabled\t= true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].r_region_code!=null && document.forms[0].m_region_code != null)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region_code.disabled\t= true;\n\t\t\t\t\tdocument.forms[0].m_region_code.disabled\t= true;\n\t\t\t\t\tdocument.forms[0].region_code.disabled\t\t= true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].r_postal_code1 != null && document.forms[0].m_postal_code1 != null)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code1.disabled = true;\n\t\t\t\t\tdocument.forms[0].m_postal_code1.disabled = true;\n\t\t\t\t\tdocument.forms[0].postal_code.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].r_country_desc != null)\n\t\t\t\t\tdocument.forms[0].r_country_desc.disabled = true;\n\t\t\t\tif(document.forms[0].m_country_desc != null)\n\t\t\t\t\tdocument.forms[0].m_country_desc.disabled = true;\n\t\t\t\tif(document.forms[0].txtPrimResNo != null)\n\t\t\t\t\tdocument.forms[0].txtPrimResNo.disabled = true;\n\t\t\t\tif(document.forms[0].txtOtherResNo != null)\n\t\t\t\t\tdocument.forms[0].txtOtherResNo.disabled = true;\n\t\t\t\tif(document.forms[0].txtEmail != null)\n\t\t\t\t\tdocument.forms[0].txtEmail.disabled = true;\n\t\t\t\tif(document.getElementById(\'copydet\') != null)\n\t\t\t\t\tdocument.getElementById(\'copydet\').style.visibility = \'hidden\';\n\t\t\t\tif(document.getElementById(\'copydet1\') != null)\n\t\t\t\t\tdocument.getElementById(\'copydet1\').style.visibility = \'hidden\';\n\n\t\t\t\t/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/\n\t\t\t\tif(document.forms[0].a_addr_line1 != null)\n\t\t\t\t\tdocument.forms[0].a_addr_line1.disabled = true;\n\t\t\t\tif(document.forms[0].a_addr_line2 != null)\n\t\t\t\t\tdocument.forms[0].a_addr_line2.disabled = true;\n\t\t\t\tif(document.forms[0].a_addr_line3 != null)\n\t\t\t\t\tdocument.forms[0].a_addr_line3.disabled = true;\n\t\t\t\tif(document.forms[0].a_addr_line4 != null)\n\t\t\t\t\tdocument.forms[0].a_addr_line4.disabled = true;\n\t\t\t\tif(document.forms[0].a_town_code != null)\n\t\t\t\t\tdocument.forms[0].a_town_code.disabled = true;\n\t\t\t\tif(document.forms[0].a_area_code != null)\n\t\t\t\t\tdocument.forms[0].a_area_code.disabled = true;\n\t\t\t\tif(document.forms[0].a_region_code != null)\n\t\t\t\t\tdocument.forms[0].a_region_code.disabled = true;\n\t\t\t\tif(document.forms[0].alt_postal_code != null)\n\t\t\t\t\tdocument.forms[0].alt_postal_code.disabled = true;\n\t\t\t\tif(document.forms[0].a_country_desc != null)\n\t\t\t\t\tdocument.forms[0].a_country_desc.disabled = true;\n\t\t\t\t/*End*/\n\n\t\t\t}\n\n\t\t\t//////////////////////////////////////////////////////////////////\n\n\t\t\tvar addr1_type\t= unescape(arr_concat_vals[0]);\t//addr1_type,          \n\t\t\tvar addr11\t\t= unescape(arr_concat_vals[1]);\t//  addr1_line1,         \n\t\t\tvar addr12\t\t= unescape(arr_concat_vals[2]);\t//  addr1_line2,         \n\t\t\tvar addr13\t\t= unescape(arr_concat_vals[3]);\t// addr1_line3,         \n\t\t\tvar addr14\t\t= unescape(arr_concat_vals[4]);\t//  addr1_line4,         \n\t\t\tvar addr15\t\t= unescape(arr_concat_vals[5]);\t//  town_code,       \n\t\t\tvar addr16\t\t= unescape(arr_concat_vals[6]);\t//  area_code,     \n\t\t\tvar addr17\t\t= unescape(arr_concat_vals[7]);\t//  postal    \n\t\t\tvar addr18\t\t= unescape(arr_concat_vals[8]);\t//  region\n\t\t\tvar addr19\t\t= unescape(arr_concat_vals[9]);\t// country\n\t\t\t\t\t \n\t\t\tif(document.forms[0].r_addr_line1)\n\t\t\t\tif(addr11)\n\t\t\t\t\tdocument.forms[0].r_addr_line1.value = addr11;\n\t\t\tif(document.forms[0].r_addr_line2)\n\t\t\t\tif(addr12)\n\t\t\t\t\tdocument.forms[0].r_addr_line2.value = addr12;\n\t\t\tif(document.forms[0].r_addr_line3)\n\t\t\t\tif(addr13)\n\t\t\t\t\tdocument.forms[0].r_addr_line3.value = addr13;\n\t\t\tif(document.forms[0].r_addr_line4)\n\t\t\t\tif(addr14)\n\t\t\t\t\tdocument.forms[0].r_addr_line4.value = addr14;\n\t\t\tif(document.forms[0].r_town_code)\n\t\t\t\tif(addr15)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = unescape(arr_concat_vals[5]);\n\t\t\t\t\tdocument.forms[0].r_town_code.value = unescape(arr_concat_vals[28]); \n\t\t\t\t}\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tif(addr16)\n\t\t\t\t\tdocument.forms[0].r_area_code.value = unescape(arr_concat_vals[29]); \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t{\n\t\t\t\tif(addr17)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value = addr17;\n\t\t\t\t\t//document.forms[0].r_postal_code1.value = addr17;\n\t\t\t\t\tdocument.forms[0].r_postal_code1.value = unescape(arr_concat_vals[36]);\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tif(addr18)\n\t\t\t\t\tdocument.forms[0].r_region_code.value = unescape(arr_concat_vals[30]); \n\t\t\tif(document.forms[0].r_country_code)\n\t\t\t\tif(addr19)\n\t\t\t\t\tdocument.forms[0].r_country_code.value = addr19;\n\t\t\n\t\t\t///////////////////////////////////////////////////////////\n\t\t\n\t\t\tvar addr21\t= unescape(arr_concat_vals[13]);\t//addr2_line1\n\t\t\tvar addr22\t= unescape(arr_concat_vals[14]);\t//addr2_line2\n\t\t\tvar addr23\t= unescape(arr_concat_vals[15]);\t//addr2_line3\n\t\t\tvar addr24\t= unescape(arr_concat_vals[16]);\t//addr2_line4\n\t\t\tvar addr25\t= unescape(arr_concat_vals[17]);\t//town\n\t\t\tvar addr26\t= unescape(arr_concat_vals[18]);\t//area\n\t\t\tvar addr27\t= unescape(arr_concat_vals[19]);\t//postal\n\t\t\tvar addr28\t= unescape(arr_concat_vals[20]);\t//region\n\t\t\tvar addr29\t= unescape(arr_concat_vals[21]);\t//country\n\n\t\t\tvar countrydesc1\t= unescape(arr_concat_vals[34]);\n\t\t\tvar countrydesc2\t= unescape(arr_concat_vals[35]); \n\n\t\t\tif(document.forms[0].m_addr_line1)\n\t\t\t\tif(addr21)\n\t\t\t\t\tdocument.forms[0].m_addr_line1.value = addr21;\n\t\t\tif(document.forms[0].m_addr_line2)\n\t\t\t\tif(addr22)\n\t\t\t\t\tdocument.forms[0].m_addr_line2.value = addr22;\n\t\t\tif(document.forms[0].m_addr_line3)\n\t\t\t\tif(addr23)\n\t\t\t\t\tdocument.forms[0].m_addr_line3.value = addr23;\n\t\t\tif(document.forms[0].m_addr_line4)\n\t\t\t\tif(addr24)\n\t\t\t\t\tdocument.forms[0].m_addr_line4.value = addr24;\n\t\t\tif(document.forms[0].m_town_code)\n\t\t\t\tif(addr25)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town_code.value = unescape(arr_concat_vals[31]);\n\t\t\t\t\tdocument.forms[0].m_town.value = unescape(arr_concat_vals[17]);\n\t\t\t\t}\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tif(addr26)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area_code.value = unescape(arr_concat_vals[32]);\n\t\t\t\t\tdocument.forms[0].m_area.value = unescape(arr_concat_vals[18]);\n\t\t\t\t}\n\t\t\tif(document.forms[0].m_postal_code1){\n\t\t\t\tif(addr27)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value = addr27;\n\t\t\t\t\t//document.forms[0].m_postal_code1.value = addr27;\n\t\t\t\t\tdocument.forms[0].m_postal_code1.value = unescape(arr_concat_vals[37]);\n\t\t\t\t}\n\t\t\t\t\t}\n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tif(addr28)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region_code.value = unescape(arr_concat_vals[33]);\n\t\t\t\t\tdocument.forms[0].m_region.value = unescape(arr_concat_vals[20]);\n\t\t\t\t}\n\t\t\tif(document.forms[0].m_country_code)\n\t\t\t\tif(addr29)\n\t\t\t\t\tdocument.forms[0].m_country_code.value = addr29;\n\t\t\tif(document.forms[0].r_country_desc)\n\t\t\t\tif(countrydesc1)\n\t\t\t\t\tdocument.forms[0].r_country_desc.value = countrydesc1;\n\t\t\tif(document.forms[0].m_country_code)\n\t\t\t\tif(countrydesc2)\n\t\t\t\t\tdocument.forms[0].m_country_desc.value = countrydesc2;\n\n\t\t\t/*Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601 Start*/\n\t\t\tvar addr31\t\t= unescape(arr_concat_vals[38]);\t//  alt_addr_line1        \n\t\t\tvar addr32\t\t= unescape(arr_concat_vals[39]);\t//  alt_addr_line2         \n\t\t\tvar addr33\t\t= unescape(arr_concat_vals[40]);\t//\talt_addr_line3         \n\t\t\tvar addr34\t\t= unescape(arr_concat_vals[41]);\t//  alt_addr_line4         \n\t\t\tvar addr35\t\t= unescape(arr_concat_vals[42]);\t//  alt_town_code      \n\t\t\tvar addr36\t\t= unescape(arr_concat_vals[43]);\t//  alt_area_code     \n\t\t\tvar addr37\t\t= unescape(arr_concat_vals[44]);\t//  alt_postal_code    \n\t\t\tvar addr38\t\t= unescape(arr_concat_vals[45]);\t//  alt_region_code\n\t\t\tvar addr39\t\t= unescape(arr_concat_vals[46]);\t//\talt_country_code\n\t\t\t\t\n\t\t\tif(document.forms[0].a_addr_line1)\n\t\t\t\tif(addr31)\n\t\t\t\t\tdocument.forms[0].a_addr_line1.value = addr31;\n\t\t\tif(document.forms[0].a_addr_line2)\n\t\t\t\tif(addr32)\n\t\t\t\t\tdocument.forms[0].a_addr_line2.value = addr32;\n\t\t\tif(document.forms[0].a_addr_line3)\n\t\t\t\tif(addr33)\n\t\t\t\t\tdocument.forms[0].a_addr_line3.value = addr33;\n\t\t\tif(document.forms[0].a_addr_line4)\n\t\t\t\tif(addr34)\n\t\t\t\t\tdocument.forms[0].a_addr_line4.value = addr34;\n\t\t\tif(document.forms[0].a_town_code)\n\t\t\t\tif(addr35)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = unescape(arr_concat_vals[42]);\n\t\t\t\t\tdocument.forms[0].a_town_code.value = unescape(arr_concat_vals[47]); \n\t\t\t\t}\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tif(addr36){\n\t\t\t\t\tdocument.forms[0].a_area.value = unescape(arr_concat_vals[43]); \n\t\t\t\t\tdocument.forms[0].a_area_code.value = unescape(arr_concat_vals[48]); \n\t\t\t\t}\n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t{\n\t\t\t\tif(addr37)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value = addr37;\n\t\t\t\t\tdocument.forms[0].alt_postal_code1.value = unescape(arr_concat_vals[49])";
    private final static byte[]  _wl_block11_2Bytes = _getBytes( _wl_block11_2 );

    private final static java.lang.String  _wl_block11_3 =";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tif(addr38){\n\t\t\t\t\tdocument.forms[0].a_region.value = unescape(arr_concat_vals[45]); \n\t\t\t\t\tdocument.forms[0].a_region_code.value = unescape(arr_concat_vals[50]); \n\t\t\t\t}\n\t\t\tif(document.forms[0].a_country_desc) //Modified for AAKH-SCF-0376\n\t\t\t\tif(addr39){\n\t\t\t\t\tdocument.forms[0].a_country_code.value = addr39;\n\t\t\t\t\tdocument.forms[0].a_country_desc.value = unescape(arr_concat_vals[51]);;\n\t\t\t\t}\n\t\t\t/*End*/\n\t\t\tif(document.forms[0].isVirtualConsultation.value == \'true\'){\n\t\t\t\tif(document.forms[0].isAlternateAddressAppl.value == \'true\'){\n\t\t\tvar arr53 = unescape(arr_concat_vals[52]);\n\t\t\t\t\tvar arr54 = unescape(arr_concat_vals[53]);\n\t\t\t\t\tif(arr54 != \'\' && arr54 != \'undefined\'){\n\t\t\t\t\tdocument.forms[0].txtNxtOfKin.value = arr54;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tvar arr55 = unescape(arr_concat_vals[54]);\n\t\t\t\t\tvar arr56 = unescape(arr_concat_vals[55]);\n\t\t\t\t\tvar arr57 = unescape(arr_concat_vals[56]);//next of kin mob country code\n\t\t\t\t\t\n\t\t\t\t\tif(arr55 != \'\'){\n\t\t\t\t\t\tfor( var i = 0; i < document.forms[0].country.options.length; i++ ){\n\t\t\t\t\t\t\tif(document.forms[0].country.options[i].value==arr55){\n\t\t\t\t\t\t\t\tdocument.forms[0].country.options[i].selected = true;\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttelephoneCode2(document.forms[0].country);\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(arr57 != \'\'){\n\t\t\t\t\t\tfor( var i = 0; i < document.forms[0].ccForNxtOfKin.options.length; i++ ){\n\t\t\t\t\t\t\tif(document.forms[0].ccForNxtOfKin.options[i].value==arr57){\n\t\t\t\t\t\t\t\tdocument.forms[0].ccForNxtOfKin.options[i].selected = true;\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\tupdateTelCode(document.forms[0].ccForNxtOfKin);\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\tvar arr53 = unescape(arr_concat_vals[38]);\n\t\t\t\t\tvar arr54 = unescape(arr_concat_vals[39]);\n\t\t\t\t\tif(arr54 != \'\' && arr54 != \'undefined\'){\n\t\t\t\t\tdocument.forms[0].txtNxtOfKin.value = arr54;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tvar arr55 = unescape(arr_concat_vals[40]);\n\t\t\t\t\tvar arr56 = unescape(arr_concat_vals[41]);\n\t\t\t\t\tvar arr57 = unescape(arr_concat_vals[42]);\n\t\t\t\t\t\n\t\t\t\t\tif(arr55 != \'\'){\n\t\t\t\t\t\tfor( var i = 0; i < document.forms[0].country.options.length; i++ ){\n\t\t\t\t\t\t\tif(document.forms[0].country.options[i].value==arr55){\n\t\t\t\t\t\t\t\tdocument.forms[0].country.options[i].selected = true;\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttelephoneCode2(document.forms[0].country);\n\t\t\t\t\t}\n\t\t\t\t\tif(arr57 != \'\'){\n\t\t\t\t\t\tfor( var i = 0; i < document.forms[0].ccForNxtOfKin.options.length; i++ ){\n\t\t\t\t\t\t\tif(document.forms[0].ccForNxtOfKin.options[i].value==arr57){\n\t\t\t\t\t\t\t\tdocument.forms[0].ccForNxtOfKin.options[i].selected = true;\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\tupdateTelCode(document.forms[0].ccForNxtOfKin);\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(document.forms[0].isVirtualConsultation.value == \'true\'){\n\n\t\t\t\tif(arr53 == \'\' || arr53 == \'undefined\'){\n\t\t\t\t\tcheckVVC();\n\t\t\t\t\tarr53 = document.forms[0].isVisitTypeVirtualEnabled.value;\n\t\t\t\t}\n\n\t\t\t\tif(arr53==\'E\'){\n\t\t\t\t\tif(document.forms[0].isAlternateAddressAppl.value == \'true\'){\n\t\t\t\t\t\tdocument.getElementById(\'altAddNxtKinNo\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'mandEmailImg\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'mandMobNoImg\').style.display = \'inline\';\n\t\t\t\t\t}else{\t\n\t\t\t\t\t\tdocument.getElementById(\'mandEmailImg\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'tdNxtOfKin\').style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\'mandMobNoImg\').style.display = \'inline\';\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\tif(document.forms[0].isAlternateAddressAppl.value == \'true\'){\n\t\t\t\t\t\tdocument.getElementById(\'altAddNxtKinNo\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'mandEmailImg\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'mandMobNoImg\').style.display = \'none\';\n\t\t\t\t\t}else{\t\n\t\t\t\t\t\tdocument.getElementById(\'mandEmailImg\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'tdNxtOfKin\').style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\'mandMobNoImg\').style.display = \'none\';\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t}\t\n\t\t\t\tupdateTelCode(document.forms[0].ccForNxtOfKin);\n\t\t\t\ttelephoneCode2(document.forms[0].country);\n\t\t}\t //End of ML-MMOH-CRF-1930\n\t}\n\t\t\n//Below methods added for this SCF AAKH-SCF-0261\nfunction SpecialCharsChk(event){\n    var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode -= 32);\n\treturn true ;\n}\n\nfunction isValidCharacter(elementRef) { \n   var regExp =\"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+\";\n   var checkValue = new String(elementRef.value);     \n\t for (var i=0; i<checkValue.length; i++)\n\t {\t\n\t\tif (regExp.indexOf(checkValue.charAt(i)) == -1) {\t\n\t\t\t\tvar msg = getMessage(\"RES_MOB_NO_SPL_NOT_ALLOWED\",\'MP\');\n\t\t\t\telementRef.value = \"\";\n\t\t\t\talert(msg);\n\t\t\t\telementRef.focus();\n\t\t\t\treturn false;\t\t  \n\t\t}\n\t  \n    }  \n}\n//End AAKH-SCF-0261\t\t\n\t\t\n\t</script>\n</head>\n<body onLoad=\'";
    private final static byte[]  _wl_block11_3Bytes = _getBytes( _wl_block11_3 );

    private final static java.lang.String  _wl_block12 ="telephone2(); updateTeleCodeOnLoad();";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="populateContactdetails()\'onKeyDown=\'lockKey();\' onKeyPress=\'return ChkKey(event);\' >\n\t<form name=\'Contact_Details_form\' id=\'Contact_Details_form\' method=\'post\' action=\'\' target=\'messageFrame\'>\n\t\t<input type=\'hidden\' name=\'readonly_yn\' id=\'readonly_yn\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t<!-- <table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border =0>\n\t\t\t<tr>\n\t\t\t\t<td align=\'left\' class=\'BODYCOLORFILLED\' width=\'1%\'>&nbsp;</td>\n\t\t\t\t<td width=\'65%\' align=\'center\' class=\'BODYCOLORFILLED\' valign=\'top\'> -->\n\t\t\t\t\t<!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<table  width=\'100%\'cellpadding=\'0\' cellspacing=\'0\' border=\'0\' height=\'90%\' align=\'center\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<!--End-->\n\t\t\t\t\t\t<table  width=\'90%\'cellpadding=\'1\' cellspacing=\'1\' border=\'0\' height=\'100%\' align=\'center\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<!--Added by Thamizh selvi on 8th Feb 2018 against ML-MMOH-CRF-0601 Start-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<td align=\'left\' width=\'42%\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<!--End-->\n\t\t\t\t\t\t\t\t<td align=\'left\' width=\'35%\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t<td align=\'left\' width=\'35%\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t\t\t<td align=\'left\' width=\'35%\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<!--End-->\n\t\t\t\t\t\t\t\t<td align=\'left\' width=\'50%\' colspan=\'2\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'r_country_desc\' id=\'r_country_desc\'                       size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\")searchCountry(contry_code[0],r_country_desc);\'  tabindex=\'51\' value=\'\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,r_country_desc)\' tabindex=\'51\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'r_country_code\' id=\'r_country_code\' value=\'\'>\n\t\t\t\t\t\t\t<!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'a_country_desc\' id=\'a_country_desc\'        size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\")searchCountry(contry_code[0],a_country_desc);\'  tabindex=\'59\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,a_country_desc)\' tabindex=\'59\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'a_country_code\' id=\'a_country_code\' value=\'\'><!--End-->\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'fields\'><input type=\'text\' name=\'m_country_desc\' id=\'m_country_desc\'        size=\'15\' maxlength=\'15\' onblur=\'if(this.value !=\"\")searchCountry(contry_code[0],m_country_desc);\'  tabindex=\'67\'><input type=\'button\' name=\'contry_code\' id=\'contry_code\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,m_country_desc)\' tabindex=\'67\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'m_country_code\' id=\'m_country_code\' value=\'\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'15%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=\'fields\' width=\'35%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=\'fields\' width=\'35%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'35%\'><a id=\'copydet1\' name=\'copydet1\' href=\'javascript:copyDetails(7)\'>&nbsp;";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</a>&nbsp;&nbsp;&nbsp;<a id=\'copydet\' name=\'copydet\' href=\'javascript:copyDetails(4)\'>&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</a></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\'4\'>&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'15%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=\'fields\' width=\'35%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'35%\'><a id=\'copydet\' name=\'copydet\' href=\'javascript:copyDetails(4)\'>&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<!--End-->\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=\'COLUMNHEADER\' width=\'35%\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t\t\t\t<!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'35%\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'35%\'>&nbsp;</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<!--End-->\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'50%\' colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" &nbsp;&nbsp;</td>\t<td><input type=\'text\' name=\'txtPrimResNo\' id=\'txtPrimResNo\' size=\'20\' maxlength=\'20\' tabindex=\'68\' onKeyPress=\'return SpecialCharsChk(event);\' onBlur=\'return isValidCharacter(this);\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<img src=\'../../eCommon/images/mandatory.gif\'></img>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" </td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" &nbsp;&nbsp;<span class=\'fields\'>\n\n\t\t\t\t\t\t\t\t<!--Added by Arthi for ML-MMOH-CRF-1930 US004 start -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t<select name=\'country\' id=\'country\' onChange= \'telephoneCode2(this);\'><option value=\'\'>-------------- ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="--------------</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t</select> <input type=\'text\' name=\'telephone\' id=\'telephone\' maxlength=\'6\' size=\'6\' Readonly value=\\\"\\\" >\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t\t<!--Added by Arthi for ML-MMOH-CRF-1930 US004 end -->\n\n\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'txtOtherResNo\' id=\'txtOtherResNo\' size=\'20\' maxlength=\'20\' tabindex=\'69\' onKeyPress=\'return SpecialCharsChk(event);\' onBlur=\'return isValidCharacter(this);\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" <img id=\'mandMobNoImg\' style=\'display:none\' src=\'../../eCommon/images/mandatory.gif\'></img> ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</span></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="<td class=\'label\' colspan=2>&nbsp;</td>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&nbsp;&nbsp;\n\t\t\t\t\t\t\t<span class=\'fields\'><input type=\'text\' name=\'txtEmail\' id=\'txtEmail\' size=\'50\' maxlength=\'50\' tabindex=\'70\'/> <img id=\'mandEmailImg\' style=\'display:none\' src=\'../../eCommon/images/mandatory.gif\'></img> </span></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t<tr id=\'altAddNxtKinNo\' style=\'display:inline\'>\n\t\t\t\t\t\t\t\t<div><td class=\'label\' nowrap>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&nbsp;";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&nbsp;&nbsp;</td><td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t<select name=\'ccForNxtOfKin\' id=\'ccForNxtOfKin\' onChange= \'updateTelCode(this);\'><option value=\'\'>-------------- ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t</select> <input type=\'text\' name=\'teleCodeHidden\' id=\'teleCodeHidden\' maxlength=\'6\' size=\'6\' readonly value=\"\" >\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<span class=\'fields\'><input type=\'text\' name=\'txtNxtOfKin\' id=\'txtNxtOfKin\' size=\'20\' maxlength=\'20\' tabindex=\'71\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' onKeyPress=\'return SpecialCharsChk(event);\' onBlur=\'return isValidCharacter(this);\'></span></td></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t<!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\'4\'>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t  <td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t\t\t  <td  align=\'right\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' onclick=\'close_me();\' class=\'button\' tabindex=\'71\'></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'fields\' ><input type=\'text\' name=\'txtEmail\' id=\'txtEmail\' size=\'50\' maxlength=\'50\' tabindex=\'70\'> <img id=\'mandEmailImg\' style=\'display:none\' src=\'../../eCommon/images/mandatory.gif\'></img> </td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td id=\'tdNxtOfKin\' style=\'display:inline\' class=\'label\' nowrap >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' onKeyPress=\'return SpecialCharsChk(event);\' onBlur=\'return isValidCharacter(this);\'></span></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td colspan=\'2\' ><input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' onclick=\'close_me();\' class=\'button\' tabindex=\'71\'></td>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td colspan=\'2\' >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'fields\' ><input type=\'text\' name=\'txtEmail\' id=\'txtEmail\' size=\'50\' maxlength=\'50\' tabindex=\'70\'> <img id=\'mandEmailImg\' style=\'display:none\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t<td id=\'tdNxtOfKin\' style=\'display:inline\' class=\'label\' nowrap >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td><td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' onKeyPress=\'return SpecialCharsChk(event);\' onBlur=\'return isValidCharacter(this);\'></span></td></div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td colspan=\'2\' align=\"right\"><input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="<!--End-->\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap >";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'fields\' colspan=\'2\'><input type=\'text\' name=\'txtEmail\' id=\'txtEmail\' size=\'50\' maxlength=\'50\' tabindex=\'70\'> <img id=\'mandEmailImg\' style=\'display:none\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t\t<td id=\'tdNxtOfKin\' style=\'display:inline\' class=\'label\' nowrap >";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t\t</select> <input type=\'text\' name=\'teleCodeHidden\' id=\'teleCodeHidden\' maxlength=\'6\' size=\'6\' readonly value=\"\" >\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<span class=\'fields\'><input type=\'text\' name=\'txtNxtOfKin\' id=\'txtNxtOfKin\' size=20\' maxlength=\'20\' tabindex=\'71\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' onKeyPress=\'return SpecialCharsChk(event);\' onBlur=\'return isValidCharacter(this);\'></span></td></div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'change_patient\' id=\'change_patient\' value=\"\">\n\t\t\t\t\t<input type=\'hidden\' name=\'addr1_type\' id=\'addr1_type\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'addr1_line1\' id=\'addr1_line1\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'addr1_line2\' id=\'addr1_line2\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'addr1_line3\' id=\'addr1_line3\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'addr1_line4\' id=\'addr1_line4\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'res_town_code\' id=\'res_town_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'res_town_desc\' id=\'res_town_desc\' value=\'\'>\n\n\t\t\t\t\t<input type=\'hidden\' name=\'res_area_code\' id=\'res_area_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'postal1_code\' id=\'postal1_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'region_code1\' id=\'region_code1\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'country1_code\' id=\'country1_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'invalid1_yn\' id=\'invalid1_yn\' value=\'\'>\n\n\t\t\t\t\t<input type=\'hidden\' name=\'addr2_type\' id=\'addr2_type\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'addr2_line1\' id=\'addr2_line1\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'addr2_line2\' id=\'addr2_line2\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'addr2_line3\' id=\'addr2_line3\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'addr2_line4\' id=\'addr2_line4\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'res2_town_code\' id=\'res2_town_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'res2_area_code\' id=\'res2_area_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'postal2_code\' id=\'postal2_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'region2_code\' id=\'region2_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'country2_code\' id=\'country2_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'invalid2_yn\' id=\'invalid2_yn\' value=\'\'>\n\n\t\t\t\t\t<input type=\'hidden\' name=\'contact1_no\' id=\'contact1_no\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'contact2_no\' id=\'contact2_no\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'email\' id=\'email\' value=\'\'>\n\n\t\t\t\t\t<input type=\'hidden\' name=\'r_postal_code\' id=\'r_postal_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'m_postal_code\' id=\'m_postal_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'r_town\' id=\'r_town\' value=\'\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'r_area\' id=\'r_area\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'r_region\' id=\'r_region\' value=\'\' >\t\n\n\t\t\t\t\t<input type=\'hidden\' name=\'m_town\' id=\'m_town\' value=\'\' maxlength=\'6\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'m_area\' id=\'m_area\' value=\'\' maxlength=\'6\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'m_region\' id=\'m_region\' value=\'\' maxlength=\'8\'>\n\t\t\t\t\t<!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start-->\n\t\t\t\t\t<input type=\'hidden\' name=\'a_town\' id=\'a_town\' value=\'\' maxlength=\'6\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'a_area\' id=\'a_area\' value=\'\' maxlength=\'6\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'a_region\' id=\'a_region\' value=\'\' maxlength=\'8\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t\t\t\t\t<!--End-->\n\t\t\t\t\t<input type=\'hidden\' name=\'country1_desc\' id=\'country1_desc\' value=\'\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'country2_desc\' id=\'country2_desc\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'mail_postal_code_desc\' id=\'mail_postal_code_desc\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'postal_code_desc\' id=\'postal_code_desc\' value=\'\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\n\t\t\t\t\t<input type=\'hidden\' name=\'dflt_nationality_code\' id=\'dflt_nationality_code\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"></input>\n\t\t\t\t\t<input type=\'hidden\' name=\'dflt_nationality_desc\' id=\'dflt_nationality_desc\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"></input>\n\t\t\t\t\t<input type=\'hidden\' name=\'isVirtualConsultation\' id=\'isVirtualConsultation\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'><!-- Added by Ajay for ML-MMOH-CRF-1930 -->\n\t\t\t\t\t<input type=\'hidden\' name=\'isVisitTypeVirtualEnabled\' id=\'isVisitTypeVirtualEnabled\' value=\'\'><!-- Added by Ajay for ML-MMOH-CRF-1930 -->\n\t\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'><!-- Added by Ajay for ML-MMOH-CRF-1930 -->\n\t\t\t\t\t<input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'><!-- Added by Ajay for ML-MMOH-CRF-1930 -->\n\t\t\t\t\t\n\t\t\t\t</table>\n\t\t\t<!-- </tr>\n\t\t</table> -->\n\t</form>\n\t<script>\n\t\tvar readonly_yn = document.forms[0].readonly_yn.value;\n\t\tif(readonly_yn == \'Y\')\n\t\t{\n\t\t\tvar length = document.forms[0].elements.length;\n\t\t\tfor(i=0;i<length;i++)\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"Contact_Details_form\").elements[i].disabled=true;\n\t\t\t}\n\t\t\tdocument.Contact_Details_form.close.disabled=false;\n\t\t}\n\t</script>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);
            _bw.write(_wl_block8_2Bytes, _wl_block8_2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block9Bytes, _wl_block9);
 
  
	Connection con				= null;
	java.sql.Statement oth_stmt = null;
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;
	ResultSet oth_rset			= null;
	ResultSet rs				= null;
	ResultSet prs				= null;
	Properties p		= (java.util.Properties) session.getValue("jdbc");
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String calling_from	= request.getParameter("calling_from"); 
	String readonly_yn	= request.getParameter("readonly_yn");
	String op_call_check= request.getParameter("op_call_check");
	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String visit_type_code			= checkForNull(request.getParameter("visit_type_code"));
	String facility_id=checkForNull((String)session.getAttribute("facility_id"));
	if(op_call_check == null) op_call_check = "";
	String oa_contact_num_reqd_yn="";
	String oa_mob_num_req_yn="";
	String oa_rule_appl_yn="";

	if (calling_from == null) calling_from = "";
	if(readonly_yn == null) readonly_yn = "N";

	String readcheck		= "";
	String Site				= "";
	String sql				= "";

	String def_nat_desc		= "";
	
	if(readonly_yn.equals("Y")) readcheck = "readonly";
	
	ArrayList codes = null;
	ArrayList descs = null; 

	HashMap hashMap2	= new HashMap();
	HashMap hashMap1	= new HashMap();
	String countryCodeFaci = "";

	Object countrydesc[]	= null;
	Object countrycode[]	= null;

	String[] contact_col_names	= null;
	String[] contact_prompts	= null;
	String[] contact_fields		= null;
	
	con			= ConnectionManager.getConnection(request);
	oth_stmt	= con.createStatement();
	stmt		= con.createStatement();

	java.util.ArrayList contact_modes = new java.util.ArrayList();

	ArrayList contact_addr = fetchContactAddresses(con, out,"parent.parent.frames[1]",p) ;

	hashMap2 = eMP.ChangePatientDetails.getCizntNatCode(con,p);
	countryCodeFaci = MPCommonBean.getCountryFrmFacility(con, facility_id, locale);
	hashMap1		= eMP.ChangePatientDetails.getPatientData(patient_id,con,p);
	String codeC = "";
	String nxtOfKin = checkForNull((String)hashMap1.get("nkin_mob_tel_no"));
	String nkin_mob_country_code = checkForNull((String)hashMap1.get("nkin_mob_country_code"));
	if(checkForNull((String)hashMap1.get("contact2_country_code")).equals("")){
		codeC = countryCodeFaci;
	}else{
		codeC = (String)hashMap1.get("contact2_country_code");
	}
	def_nat_desc = checkForNull((String)hashMap2.get("def_nat_desc"));

    Site				= (String) contact_addr.get(0);
    contact_col_names	= (String[]) contact_addr.get(1);
    contact_prompts		= (String[]) contact_addr.get(2);
    contact_fields		= (String[]) contact_addr.get(3);
    contact_addr		= null;

	/* to get the array of nationality*/

	codes = new ArrayList();
	descs = new ArrayList();			
	
	boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601
	boolean isAddressLengthIncAppl = false;//Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0860.2

	//Added by Arthi for ML-MMOH-CRF-1930 US004
	Boolean isVirtualConsultation = false;
	String classcode="";
	String classdesc="";
	String countryC = "";

	
	String cCode = "";
	String cDesc = "";
	String cCodeForKin = "";
	String cDescForKin = "";

	
	try
	{
		isVirtualConsultation=eCommon.Common.CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION");//Added by Arthi for ML-MMOH-CRF-1930 US004

		isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601
		isAddressLengthIncAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");//Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0860.2
		stmt = con.createStatement();
		if(op_call_check!=null && !(op_call_check.equals(""))){
		String oa_sql="select CONTACT_NUM_REQD_YN, MOB_NUM_REQ_YN, RULE_APPL_YN from OA_param";
		if(rs!=null)rs.close();
		rs = stmt.executeQuery(oa_sql);
		if(rs!=null && rs.next()){
			oa_contact_num_reqd_yn=rs.getString("CONTACT_NUM_REQD_YN");
			if(oa_contact_num_reqd_yn==null)oa_contact_num_reqd_yn="";
			oa_mob_num_req_yn=rs.getString("MOB_NUM_REQ_YN");
			if(oa_mob_num_req_yn==null)oa_mob_num_req_yn="";
			oa_rule_appl_yn=rs.getString("RULE_APPL_YN");
			if(oa_rule_appl_yn==null)oa_rule_appl_yn="";
		}
		}
		if(rs!=null)rs.close();
		sql = "Select Country_Code,Long_Desc,long_name short_name from Mp_Country_lang_vw where language_id = '"+locale+"' AND eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 2";
		
		rs = stmt.executeQuery(sql);
	
		String code = "";
		String desc = "";
	
		if(rs != null)
		while(rs.next())
		{
			code = rs.getString("Country_Code");
			desc = rs.getString("Long_Desc");

			codes.add(rs.getString("Country_Code"));
			descs.add(rs.getString("Long_Desc"));
		}

		countrycode  = codes.toArray();
		countrydesc  = descs.toArray();

		codes = null;
		descs = null;						
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11_0Bytes, _wl_block11_0);
            _bw.write(_wl_block11_1Bytes, _wl_block11_1);
            _bw.write(_wl_block11_2Bytes, _wl_block11_2);
            _bw.write(_wl_block11_3Bytes, _wl_block11_3);
if(isVirtualConsultation){
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(readonly_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
 if(isAlternateAddressAppl || isAddressLengthIncAppl){ 
            _bw.write(_wl_block15Bytes, _wl_block15);
 }else{ 
            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(isAddressLengthIncAppl && !isAlternateAddressAppl){ 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 }else{ 
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(isAlternateAddressAppl){ 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 }else{ 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 } 
            _bw.write(_wl_block25Bytes, _wl_block25);

						int num		= 42;
						int num2	= 51;
						int num3    = 60; //Added by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
						
						StringBuffer sb = new StringBuffer();
						StringBuffer sbap = new StringBuffer();
						StringBuffer sbar = new StringBuffer();
						StringBuffer sb1 = new StringBuffer();
						StringBuffer sb2 = new StringBuffer();
						StringBuffer sb3 = new StringBuffer();
						StringBuffer sb4 = new StringBuffer();
						
						for(int i=0;i<contact_col_names.length; i++)
						{
							if(	contact_prompts[i]!=null)
							{
								num = num+1;
								num2 = num2+1;
								String number = String.valueOf(num);
								String number1 = String.valueOf(num2);								
								String number2 = String.valueOf(num3); //Added by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
								out.println("<tr>") ;
								out.println("<td  class='label'  nowrap>"+contact_prompts[i]+"&nbsp;&nbsp;</td>") ;
								String val  = contact_fields[i] ;
								sb1.append(val);
								
								if(sb1.indexOf("@")!=-1) {
									sb1 = sb1.replace(sb1.indexOf("@"),sb1.indexOf("@")+1,number);
								}
								sb3=sb1;	
								
								if(sb3.indexOf("@")!=-1) {
									sb3 = sb3.replace(sb3.indexOf("@"),sb3.indexOf("@")+1,number);
								}	
								
								val = sb3.toString();								
								out.println("<td class='fields'  >"+val+"</td>");
								
								/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
								if(isAlternateAddressAppl){
									val = contact_fields[i] ;
									sb.append(val);
									int j2 = 0 ;
									int j3 = 0 ;
									String old_val1 = "";
									String new_val1 = "" ;
									
									if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
									{
										old_val1 = "r_addr_line1";
										new_val1 = "a_addr_line1";
									}
									else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
									{
										old_val1 = "r_addr_line2";
										new_val1 = "a_addr_line2";
									}
									else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
									{
										old_val1 = "r_addr_line3";
										new_val1 = "a_addr_line3";
									}
									else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
									{
										old_val1 = "r_addr_line4";
										new_val1 = "a_addr_line4";
									}
									else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
									{
										old_val1 = "r_area_code";
										new_val1 = "a_area_code";
									}
									else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{
										old_val1 = "r_town_code";
										new_val1 = "a_town_code";
									}
									else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
									{
										old_val1 = "r_postal_code";
										new_val1 = "alt_postal_code";
									}
									else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
									{
										old_val1 = "r_region_code";
										new_val1 = "a_region_code";
									}
									
									while(val.indexOf(old_val1) != -1)
									{
										j2 = val.indexOf(old_val1,j2);
										sb = sb.replace(j2,(j2+old_val1.length()),new_val1);
										val = sb.toString();
									}
									if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{
										sbap.append(val);
										while(val.indexOf("r_postal_code") != -1)
										{
											j3 = val.indexOf("r_postal_code",j3) ;
											sbap = sbap.replace(j3,(j3+"r_postal_code".length()),"alt_postal_code");
											val = sbap.toString();
									
										}
									}
									if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
									{
										j3 = 0;
										sbar.append(val);
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j3 = val.indexOf("r_postal_code",j3) ;
											
											sbar = sbar.replace(j3,(j3+"r_postal_code".length()),"alt_postal_code");
											val = sbar.toString();
											
										}
									}
									sb2.append(val);			
									
									if(sb2.indexOf("@")!=-1) {
										sb2 = sb2.replace(sb2.indexOf("@"),sb2.indexOf("@")+1,number1);
									}
									sb4=sb2;
			
									if(sb4.indexOf("@")!=-1) {
										sb4 = sb4.replace(sb4.indexOf("@"),sb4.indexOf("@")+1,number1);
									}
									
									val = sb4.toString();
									
									out.println("<td class='fields'>"+val+"</td>");
									
									sbar.setLength(0);
									sbap.setLength(0);
									sb.setLength(0);
									sb1.setLength(0);
									sb2.setLength(0);
								}
								/*End*/

								val = contact_fields[i] ;
								sb.append(val);
								int j = 0 ;
								int j1 = 0 ;
								String old_val = "";
								String new_val = "" ;
								if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
								{
									old_val = "r_addr_line1";
									new_val = "m_addr_line1";
								}
								else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
								{
									old_val = "r_addr_line2";
									new_val = "m_addr_line2";
								}
								else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
								{
									old_val = "r_addr_line3";
									new_val = "m_addr_line3";
								}
								else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
								{
									old_val = "r_addr_line4";
									new_val = "m_addr_line4";
								}
								else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
								{
									old_val = "r_area_code";
									new_val = "m_area_code";
								}
								else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
								{
									old_val = "r_town_code";
									new_val = "m_town_code";
								}
								else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
								{
									old_val = "r_postal_code";
									new_val = "m_postal_code";
								}
								else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
								{
									old_val = "r_region_code";
									new_val = "m_region_code";
								}
								while(val.indexOf(old_val) != -1)
								{
									j = val.indexOf(old_val,j);
									sb = sb.replace(j,(j+old_val.length()),new_val);
									val = sb.toString();
								}
								if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
								{
									sbap.append(val);
									while(val.indexOf("r_postal_code") != -1)
									{
										j1 = val.indexOf("r_postal_code",j1) ;
										sbap = sbap.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
										val = sbap.toString();
								
									}
								}
								if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
								{
									j1 = 0;
									sbar.append(val);
									while(val.indexOf("r_postal_code") != -1)
									{
										
										j1 = val.indexOf("r_postal_code",j1) ;
										
										sbar = sbar.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
										val = sbar.toString();
										
									}
								}
								sb2.append(val);			
								if(sb2.indexOf("@")!=-1) {
									sb2 = sb2.replace(sb2.indexOf("@"),sb2.indexOf("@")+1,number2); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
								}
								sb4=sb2;
								if(sb4.indexOf("@")!=-1) {
									sb4 = sb4.replace(sb4.indexOf("@"),sb4.indexOf("@")+1,number2); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
								}
								
			    				val = sb4.toString();
								
								/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
								if(isAlternateAddressAppl || isAddressLengthIncAppl){
									out.println("<td class='fields' >"+val+"</td>");
								}else{/*End*/
									if(i == 0)
									{
										out.println("<td class='fields'>"+val+"<a id='copydet' name='copydet' href='javascript:copyDetails(4)'>&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.CopyResidenceAddress.label","mp_labels")+"</a> </td>");
									}
									else
									{
										out.println("<td class='fields' >"+val+"</td>");
									}
								}
								
								out.println("</tr>");
								
							}
							sbar.setLength(0);
							sbap.setLength(0);
							sb.setLength(0);
							sb1.setLength(0);
							sb2.setLength(0);
						}
						
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
 if(isAlternateAddressAppl){ 
            _bw.write(_wl_block28Bytes, _wl_block28);
 } 
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(isAlternateAddressAppl){ 
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 }else if(isAddressLengthIncAppl){ 
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
 if(isAlternateAddressAppl){ 
            _bw.write(_wl_block36Bytes, _wl_block36);
 }else{ 
            _bw.write(_wl_block37Bytes, _wl_block37);
 } 
            _bw.write(_wl_block25Bytes, _wl_block25);

						String psql = "select short_desc from mp_contact_mode_lang_vw where language_id = '"+locale+"' AND contact_mode in ('PRN','ORN') and eff_status = 'E' order by contact_mode desc";
						pstmt = con.prepareStatement(psql);
						prs = pstmt.executeQuery();
						if(prs!=null ) 
						{
							while(prs.next())
							{				
								contact_modes.add(prs.getString(1)==null?"":prs.getString(1));
							}
						}	
						
            _bw.write(_wl_block38Bytes, _wl_block38);
 
						int lth = contact_modes.size();	
						
						if(lth > 0)
						{	
							if((String)contact_modes.get(0)!="")
							{	
                                //Modified for this SCF AAKH-SCF-0261  							
								
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)contact_modes.get(0)));
            _bw.write(_wl_block40Bytes, _wl_block40);
if( oa_contact_num_reqd_yn.equals("Y") && op_call_check.equals("OA") ){
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);

							}
							if(lth > 1)
							{
								if((String)contact_modes.get(1) != "") 
								{ 
								   //Modified for this SCF AAKH-SCF-0261
									
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)contact_modes.get(1)));
            _bw.write(_wl_block44Bytes, _wl_block44);
if(isVirtualConsultation){
									try{

									pstmt=con.prepareStatement("select country_code,long_desc from mp_country where eff_status = 'E' order by long_desc asc");
									rs = pstmt.executeQuery();
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
		

											
											if( rs != null )
											{
												while(rs.next()) 
													{
													classcode = rs.getString( "country_code" ) ;
													classdesc = rs.getString( "long_desc" ) ;
													codeC = checkForNull(codeC);
													if(!codeC.equals("")){
														if(codeC.equals(classcode)){
														out.println("<option value=\"" + classcode + "\" selected>" + classdesc );
														}else{ 
															out.println("<option value=\"" + classcode + "\">" + classdesc);
														}
													}else{
														out.println("<option value=\"" + classcode + "\">" + classdesc);
													}
												}
											}
									out.println("<input type='hidden' name='countryC' id='countryC' value=\""+countryC+"\" > ") ;
											} catch(Exception e) { 
												out.println(e.toString());
												e.printStackTrace();
											} finally {
											if (rs != null) rs.close();
											if (pstmt != null) pstmt.close(); 			
											}
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
if( (oa_mob_num_req_yn.equals("Y")&& oa_rule_appl_yn.equals("Y")) && op_call_check.equals("OA")){
            _bw.write(_wl_block41Bytes, _wl_block41);
}else if(isVirtualConsultation){
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block50Bytes, _wl_block50);

								}
							}
							else
							{
								
            _bw.write(_wl_block51Bytes, _wl_block51);
       
							} 
						}
						/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
						if(isAlternateAddressAppl){
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
if(isVirtualConsultation){
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

									try{
									pstmt=con.prepareStatement("select country_code,long_desc from mp_country where eff_status = 'E' order by long_desc asc");
									rs = pstmt.executeQuery();
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
		
											cCodeForKin = (String)hashMap2.get("def_nat_cd");
											cDescForKin = (String)hashMap2.get("def_nat_desc");
											if( rs != null )
											{
												while(rs.next()) 
													{
													cCode = rs.getString( "country_code" ) ;
													cDesc = rs.getString( "long_desc" ) ;
													codeC = checkForNull(codeC);
													nkin_mob_country_code = checkForNull(nkin_mob_country_code);
													if(!nkin_mob_country_code.equals("")){
														if(nkin_mob_country_code.equals(cCode)){ 
															out.println("<option value=\"" + cCode + "\" selected>" + cDesc );
														}else{ 
															out.println("<option value=\"" + cCode + "\">" + cDesc);
														}
													}else{
														if(codeC.equals(cCode)){ 
														out.println("<option value=\"" + cCode + "\" selected>" + cDesc );
														}else{ 
														out.println("<option value=\"" + cCode + "\">" + cDesc);
														}
													}
													}
											}
											out.println("<input type='hidden' name='countryC12' id='countryC12' value=\""+cCodeForKin+"\"  >") ;
											} catch(Exception e) { 
												out.println(e.toString());
												e.printStackTrace();
											} finally {
											if (rs != null) rs.close();
											if (pstmt != null) pstmt.close(); 			
											}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(nxtOfKin ));
            _bw.write(_wl_block59Bytes, _wl_block59);
 } 
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(isAlternateAddressAppl){ 
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
 }else if(isAddressLengthIncAppl){ 
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
if(isVirtualConsultation){ 
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

									try{
									pstmt=con.prepareStatement("select country_code,long_desc from mp_country where eff_status = 'E' order by long_desc asc");
									rs = pstmt.executeQuery();
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
		
											cCodeForKin = (String)hashMap2.get("def_nat_cd");
											cDescForKin = (String)hashMap2.get("def_nat_desc");
											if( rs != null )
											{
												while(rs.next()) 
													{
													cCode = rs.getString( "country_code" ) ;
													cDesc = rs.getString( "long_desc" ) ;
													codeC = checkForNull(codeC);
													nkin_mob_country_code = checkForNull(nkin_mob_country_code);
													if(!nkin_mob_country_code.equals("")){
														if(nkin_mob_country_code.equals(cCode)){ 
															out.println("<option value=\"" + cCode + "\" selected>" + cDesc );
														}else{ 
															out.println("<option value=\"" + cCode + "\">" + cDesc);
														}
													}else{
														if(codeC.equals(cCode)){ 
														out.println("<option value=\"" + cCode + "\" selected>" + cDesc );
														}else{ 
														out.println("<option value=\"" + cCode + "\">" + cDesc);
														}
													}
													}
											}
											out.println("<input type='hidden' name='countryC12' id='countryC12' value=\""+cCodeForKin+"\"  ") ;
											} catch(Exception e) { 
												out.println(e.toString());
												e.printStackTrace();
											} finally {
											if (rs != null) rs.close();
											if (pstmt != null) pstmt.close(); 			
											}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(nxtOfKin ));
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
 }
						else if(isVirtualConsultation){
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
if(isVirtualConsultation){ 
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

									try{
									pstmt=con.prepareStatement("select country_code,long_desc from mp_country where eff_status = 'E' order by long_desc asc");
									rs = pstmt.executeQuery();
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
		
											cCodeForKin = (String)hashMap2.get("def_nat_cd");
											cDescForKin = (String)hashMap2.get("def_nat_desc");
											if( rs != null )
											{
												while(rs.next()) 
													{
													cCode = rs.getString( "country_code" ) ;
													cDesc = rs.getString( "long_desc" ) ;
													codeC = checkForNull(codeC);
													nkin_mob_country_code = checkForNull(nkin_mob_country_code);
													if(!nkin_mob_country_code.equals("")){
														if(nkin_mob_country_code.equals(cCode)){ 
															out.println("<option value=\"" + cCode + "\" selected>" + cDesc );
														}else{ 
															out.println("<option value=\"" + cCode + "\">" + cDesc);
														}
													}else{
														if(codeC.equals(cCode)){ 
														out.println("<option value=\"" + cCode + "\" selected>" + cDesc );
														}else{ 
														out.println("<option value=\"" + cCode + "\">" + cDesc);
														}
													}
													}
											}
											out.println("<input type='hidden' name='countryC12' id='countryC12' value=\""+cCodeForKin+"\"  ") ;
											} catch(Exception e) { 
												out.println(e.toString());
												e.printStackTrace();
											} finally {
											if (rs != null) rs.close();
											if (pstmt != null) pstmt.close(); 			
											}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(nxtOfKin ));
            _bw.write(_wl_block75Bytes, _wl_block75);
}
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
 }else{ 
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
if(isVirtualConsultation){ 
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

									try{
									pstmt=con.prepareStatement("select country_code,long_desc from mp_country where eff_status = 'E' order by long_desc asc");
									rs = pstmt.executeQuery();
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
		
											cCodeForKin = (String)hashMap2.get("def_nat_cd");
											cDescForKin = (String)hashMap2.get("def_nat_desc");
											if( rs != null )
											{
												while(rs.next()) 
													{
													cCode = rs.getString( "country_code" ) ;
													cDesc = rs.getString( "long_desc" ) ;
													codeC = checkForNull(codeC);
													nkin_mob_country_code = checkForNull(nkin_mob_country_code);
													if(!nkin_mob_country_code.equals("")){
														if(nkin_mob_country_code.equals(cCode)){ 
															out.println("<option value=\"" + cCode + "\" selected>" + cDesc );
														}else{ 
															out.println("<option value=\"" + cCode + "\">" + cDesc);
														}
													}else{
														if(codeC.equals(cCode)){ 
														out.println("<option value=\"" + cCode + "\" selected>" + cDesc );
														}else{ 
														out.println("<option value=\"" + cCode + "\">" + cDesc);
														}
													}
													}
											}
											out.println("<input type='hidden' name='countryC12' id='countryC12' value=\""+cCodeForKin+"\"  ") ;
											} catch(Exception e) { 
												out.println(e.toString());
												e.printStackTrace();
											} finally {
											if (rs != null) rs.close();
											if (pstmt != null) pstmt.close(); 			
											}
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(nxtOfKin ));
            _bw.write(_wl_block81Bytes, _wl_block81);
}
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
 } 
            _bw.write(_wl_block82Bytes, _wl_block82);

						if(stmt != null) stmt.close();
						if(oth_stmt != null) oth_stmt.close();
						if(pstmt != null)pstmt.close();
						if(prs != null) prs.close();
						if(oth_rset != null) oth_rset.close();
						if(rs != null) rs.close();
			        }
					catch(Exception e)
					{
						out.print(e.toString());
						e.printStackTrace();
					}
					finally
					{
						ConnectionManager.returnConnection(con,request);
					} 
					
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(isAlternateAddressAppl));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf((String)hashMap2.get("def_nat_cd")));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(checkForNull((String)hashMap2.get("def_nat_desc"))));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(isVirtualConsultation));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block90Bytes, _wl_block90);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residence.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residence.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AlternateAddress.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mailing.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mailing.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyAlternateAddress.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyResidenceAddress.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CopyResidenceAddress.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ContactModes.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mobile.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mobile.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mobile.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mobile.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}
