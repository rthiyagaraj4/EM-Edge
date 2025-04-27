package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import org.json.simple.*;
import webbeans.op.CurrencyFormat;
import blopin.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __medrecrequestrecorddetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedRecRequestRecordDetail.jsp", 1736318011344L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" <!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<!DOCTYPE html>\n<!-- Last modified Date : 10/1/2005 10:26 AM -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n<script> \n\n\nfunction sendToValidation(Val,areaobj,messageFrame)  \n{ \n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\tif ( Val == 7 )\n\t{  \n        if(areaobj.value !=\'\')\n        {\n           \n\t\t\tif(messageFrame==\"parent.parent.messageFrame\")\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"7\\\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\txmlStr+=\" process_id=\\\"20\\\"\";\n\t\t\t}\n\n\t\t\tvar mode =areaobj.name;\n\t\t\t\n\t\t\t\n\t\t\tif (mode==\"r_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"r_region\").value+\"\\\"\";\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"m_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"m_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact1_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"n_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact2_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"f_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif( mode==\"contact3_region_code\") {\n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"e_region\").value+\"\\\"\";\n\t\t\t}\n\t\t\t\t\n\t\t\tif (mode==\"r_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"r_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"m_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"n_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"f_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"e_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"r_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"r_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"m_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"m_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact1_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"n_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact2_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"f_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif( mode==\"contact3_res_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"e_town\").value+\"\\\"\";\n\t\t\t\t\n\t\t\t//Below line added for ML-MMOH-CRF-0601\n            if (mode==\"a_town_code\")\n\t\t\t\txmlStr+=\" res_town_code=\\\"\"+document.getElementById(\"a_town\").value+\"\\\"\";\t\n    \n            if( mode==\"a_area_code\")\n\t\t\t\txmlStr+=\" res_area_code=\\\"\"+document.getElementById(\"a_area\").value+\"\\\"\";\n\t\t\t\t\n\t\t\tif (mode==\"a_region_code\") \n\t\t\t\txmlStr+=\" region_code=\\\"\"+document.getElementById(\"a_region\").value+\"\\\"\";\t\n\t\t    //End this ML-MMOH-CRF-0601\t\n\t\t\t\n\t\t   \n\t\t\t\n\t\t//Below line modified for ML-MMOH-CRF-0601\t\t\n\t\tif (mode==\"r_postal_code\" || mode==\"m_postal_code\" || mode==\"alt_postal_code\" || mode==\"next_postal_code\" || mode==\"first_postal_code\" || mode==\"employ_postal_code\")\n\t\t\t\txmlStr+=\" postal_code=\\\"\"+areaobj.value+\"\\\"\";\n\t\t\t           \n           xmlStr+=\" mode=\\\"\"+mode+\"\\\"\";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\t//alert(xmlHttp);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t//alert(xmlHttp.responseText);\n\t\t\teval(xmlHttp.responseText);\n        }\n        \n} \n}\n\nfunction fun1()\n{\n}\n \t\nasync function searchCommonCode(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\tvar serverlet=new String();\n\tif(messageFrame===\"parent.messageFrame\")\n\t{\n\t\tserverlet=\"yes\";\n\t}\n\telse\n\t{\n\t\tserverlet=\"no\";\n\t}\t\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\tretVal\t= await AddressLookup( tit, obj.name ,target.value,serverlet);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}el";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="se if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n} \n\n\nasync function searchCommonCodenew(obj,target,title,messageFrame,locale){ \n\tvar retVal\t= new String();                \n\tvar tit\t\t= title;\n\t//alert(\"Inside PatientAddressdLegends.jsp\");\n\talert(obj);\n\talert(target);\n\talert(title);\n\talert(messageFrame);\n\talert(locale);\n\tretVal\t= await AddressLookupnew( tit, obj.name ,target.value);\n\t//alert(retVal);\n\tvar arr\t= new Array();\n    if(retVal != null && retVal != \"\"){  \n\t\tvar ret1 = unescape(retVal);\n\t\tarr = ret1.split(\"::\");\n\t\ttarget.value=arr[1];\n\t\t\n\t\tif(target.name == \'r_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].r_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].r_postal_code,messageFrame);\n\t\t}else if(target.name == \'m_postal_code1\'){\n\t\t\tdocument.forms[0].m_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].m_postal_code,messageFrame);\n\t\t}else if(target.name == \'next_postal_code1\'){\n\t\t\tdocument.forms[0].next_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].next_postal_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code1\'){\n\t\t\tdocument.forms[0].n_ma_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_ma_postal_code,messageFrame);\n\t\t}else if(target.name == \'fst_no_ma_pos_cod1\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_no_ma_pos_cod,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'first_postal_code1\'){\n\t\t\tdocument.forms[0].first_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].first_postal_code,messageFrame);\n\t\t}else if(target.name == \'employ_postal_code1\'){\n\t\t\tdocument.forms[0].employ_postal_code.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].employ_postal_code,messageFrame);\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= arr[0];\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_region_code)\n\t\t\t\t//document.forms[0].r_region_code.value=\"\";\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].r_area_code,messageFrame);\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_region_code)\n\t\t\t\t//document.forms[0].m_region_code.value=\"\";\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_area_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_area_code,messageFrame);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_area_code,messageFrame);\n\t\t}else if(target.name == \'fst_to_no_ma_area_code\'){\n\t\t\tdocument.forms[0].contact2_res_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_area_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_area_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_area_code,messageFrame);\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tprev_region = document.forms[0].r_region.value;\n\t\t\tdocument.forms[0].r_region.value= arr[0];\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].r_postal_code1)\n\t\t\t\t//document.forms[0].r_postal_code1.value=\"\";\t\n\t\t\t//End\n\t\t\tsendToValidation(\'7\', document.forms[0].r_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tprev_region = document.forms[0].m_region.value;\t  \n\t\t\tdocument.forms[0].m_region.value= arr[0];\t\t\t\t\n\t\t\t//Added by santhosh for AMRI-SCF-0714\n\t\t\t//if(document.forms[0].m_postal_code1)\n\t\t\t\t//document.forms[0].m_postal_code1.value=\"\";\n\t\t\t//End\n\t\t\tsendToValidation(7, document.forms[0].m_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tprev_region = document.forms[0].n_region.value;\n\t\t\tdocument.forms[0].n_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_region_code,messageFrame,prev_region);\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tprev_region = document.forms[0].contact1_region.value;\n\t\t\tdocument.forms[0].contact1_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contac_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'fst_to_no_ma_reg_cod\'){\n\t\t\tprev_region = document.forms[0].contact2_region.value;\n\t\t\tdocument.forms[0].contact2_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_reg_cod,messageFrame,prev_region);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_region_code\'){\n\t\t\tprev_region = document.forms[0].f_region.value;\n\t\t\tdocument.forms[0].f_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tprev_region = document.forms[0].e_region.value;\n\t\t\tdocument.forms[0].e_region.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_region_code,messageFrame,prev_region);\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value= arr[0];\t\n            //Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].r_region_code)\n\t\t\t\tdocument.forms[0].r_region_code.value=\"\";\n\t\t\tif(document.forms[0].r_area_code)\n\t\t\t\tdocument.forms[0].r_area_code.value=\"\"; \n\t\t\tif(document.forms[0].r_postal";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block7_2 ="_code1)\n\t\t\t\tdocument.forms[0].r_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].r_town_code,messageFrame);\n\t\t}else if(target.name == \'m_town_code\'){\n\t\t\tdocument.forms[0].m_town.value= arr[0];\n\t\t\t//Added for ML-MMOH-CRF-0860.2\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].m_region_code)\n\t\t\t\tdocument.forms[0].m_region_code.value=\"\";\n\t\t\tif(document.forms[0].m_area_code)\n\t\t\t\tdocument.forms[0].m_area_code.value=\"\";\n\t\t\tif(document.forms[0].m_postal_code1)\n\t\t\t\tdocument.forms[0].m_postal_code1.value=\"\";\n\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].m_town_code,messageFrame);\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact1_res_town_code,messageFrame);\n\t\t\t\n\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].n_contact_ma_town_code,messageFrame);\n\t\t\t\n\t\t}else if(target.name == \'fst_to_no_ma_town_code\'){\n\t\t\tdocument.forms[0].contact2_res_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].fst_to_no_ma_town_code,messageFrame);\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact2_res_town_code,messageFrame);\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value= arr[0];\n\t\t\tsendToValidation(7, document.forms[0].contact3_res_town_code,messageFrame);\n\t\t/*Below line added for this CRF ML-MMOH-CRF-0860.2*/\t\n\t\t}else if(target.name == \'alt_postal_code1\'){\t \t\t\t\t\n\t\t\tdocument.forms[0].alt_postal_code.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].alt_postal_code,messageFrame);\n\t\t}else if(target.name == \'a_area_code\'){\n\t\t\tdocument.forms[0].a_area.value= arr[0];\t\n\t\t\tsendToValidation(7, document.forms[0].a_area_code,messageFrame);\n\t\t}else if(target.name == \'a_town_code\'){\n\t\t\tdocument.forms[0].a_town.value= arr[0];\t\n\t\t\t//Below code modified on 30th May 2018 against ML-MMOH-SCF-0995 by Thamizh selvi \n\t\t\tif(document.forms[0].a_region_code)\n\t\t\t\tdocument.forms[0].a_region_code.value=\"\";\n\t\t\tif(document.forms[0].a_area_code)\n\t\t\t\tdocument.forms[0].a_area_code.value=\"\";  \n\t\t\tif(document.forms[0].alt_postal_code1)\n\t\t\t\tdocument.forms[0].alt_postal_code1.value=\"\";\t\t\t\n\t\t\tsendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t}else if(target.name == \'a_region_code\'){\n\t\t\tprev_region = document.forms[0].a_region.value;\n\t\t\tdocument.forms[0].a_region.value= arr[0];\n\t\t\tsendToValidation(\'7\', document.forms[0].a_region_code,messageFrame,prev_region);\n\t\t}\n\t\t//else if(target.name == \'a_town_code\'){\n\t\t\t//document.forms[0].a_town.value= arr[0];\n\t\t\t//sendToValidation(7, document.forms[0].a_town_code,messageFrame);\n\t\t//}\n\t\t//End this ML-MMOH-CRF-0860.2\n\t\t\n\t}else{  \n\t\tif(target.name == \'r_postal_code\'){\n\t\t\tdocument.forms[0].r_postal_code=\'\';\n\t\t}else if(target.name == \'m_postal_code\'){\n\t\t\tdocument.forms[0].m_postal_code=\'\';\n\t\t}else if(target.name == \'next_postal_code\'){\n\t\t\tdocument.forms[0].next_postal_code=\'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_ma_postal_code\'){\n\t\t\tdocument.forms[0].n_ma_postal_code=\'\';\n\t\t}else if(target.name == \'fst_no_ma_pos_cod\'){\n\t\t\tdocument.forms[0].fst_no_ma_pos_cod=\'\';\n         //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'first_postal_code\'){\n\t\t\tdocument.forms[0].first_postal_code=\'\';\n\t\t}else if(target.name == \'employ_postal_code\'){\n\t\t\tdocument.forms[0].employ_postal_code=\'\';\n\t\t}else if(target.name == \'r_area_code\'){\n\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t}else if(target.name == \'m_area_code\'){\n\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t}else if(target.name == \'contact1_res_area_code\'){\n\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_area_code\'){\n\t\t\tdocument.forms[0].nkma_area.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_area_code\'){\n\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t}else if(target.name == \'contact3_res_area_code\'){\n\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t}else if(target.name == \'r_region_code\'){\n\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t}else if(target.name == \'m_region_code\'){\n\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t}else if(target.name == \'contact1_region_code\'){\n\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contac_region_code\'){\n\t\t\tdocument.forms[0].contact1_region.value = \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name==\'contact2_region_code\'){\n\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t}else if(target.name == \'contact3_region_code\'){\n\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t}else if(target.name == \'r_town_code\'){\n\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t}else if(target.name == \'m_town_code\'){  \n\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t}else if(target.name == \'contact1_res_town_code\'){\n\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'n_contact_ma_town_code\'){\n\t\t\tdocument.forms[0].nkma_town.value= \'\';\n        //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008\n\t\t}else if(target.name == \'contact2_res_town_code\'){\n\t\t\tdocument.forms[0].f_town.value = \'\';\n\t\t}else if(target.name == \'contact3_res_town_code\'){\n\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t}\n\t\t//}\n\t\ttarget.value = \'\';\n\t}\n}\nfunction clearCommonCode(target){ \n \n\t            if(target.name == \'r_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'next_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].next_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'first_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].first_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'employ_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].employ_postal_code.value=\'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_area.value = \'\';\n\t\t\t\t}\n  \t\t\t\telse if(target.name == \'contact2_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_area.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name==\'contact2_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_region.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'r_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].r_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'m_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].m_town.value = \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact1_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].n_town.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact2_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].f_town.value = \'\';\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'contact3_res_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].e_town.value = \'\';\n\t\t\t\t//Below line added for this CRF ML-MMOH-CRF-0601\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_town_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_town.value = \'\';\n\t\t\t\t\t\n\t\t\t\t}else if(target.name == \'a_area_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_area.value= \'\';\n\t\t\t\t}\n\t\t\t\telse if(target.name == \'a_region_code\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].a_region.value = \'\';\n\t\t\t\t}\n                else if(target.name == \'alt_postal_code1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].alt_postal_code.value=\'\';\n\t\t\t\t} \t\t\t\t\n\t\t\t\t//Above line added for this CRF ML-MMOH-CRF-0601\n}\n \n//ML-MMOH-CRF-0860\nfunction maxLengthPaste(obj)\n { \n\tvar mlength=obj.getAttribute? parseInt(obj.getAttribute(\"maxlength\")) : \"\"\n\tif (obj.getAttribute && obj.value.length>mlength)\n\t{\n    \tvar errors1 = getMessage(\"EXCEED_MAX_LENGTH\", \"Sm\",null);\n        alert(errors1);\t\n\t\tobj.value=obj.value.substring(0,mlength);\n\t}\n }\n \n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"~\")!=-1){\n\t\t //txtVal.value = txtVal.value.replace(\"~\", \'\'); \n          txtVal.value = txtVal.value.replace(/~/g, \'\');\n          //txtVal.value = txtVal.value.replace(new RegExp(\'hello\', \'g\'), \'hi\');\t\t \n\t}\n } \n \n//End ML-MMOH-CRF-0860\n</script>\n";
    private final static byte[]  _wl_block7_2Bytes = _getBytes( _wl_block7_2 );

    private final static java.lang.String  _wl_block8 ="\n\n<html>\n<head>\n    <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\"></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\"../../eMR/js/MedRecRequestButtons.js\" language=\'javascript\'></script>\n\t<script src=\"../../eMR/js/MedRecRequestDetails.js\" language=\'javascript\'></script>\n\t<script src=\"../../eMR/js/MRPractitionerComponent.js\" language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n\t\t\n<script>\n\n \n\nfunction allowAlphaNumeric(event){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316\n\tvar strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\';\n\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\tkey = String.fromCharCode(whichCode);  \n\tif (strCheck.indexOf(key) == -1) return false;  \n\treturn true ;\n}\n\nfunction CheckNumberFormat(obj) \n{\n    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) \n\t{\n        return true;\n    }\n    else {\n        if ( obj.value.length > 0 ) {\n            alert(getMessage(\"NUM_ALLOWED\",\"SM\"));\n            obj.value= \"\";\n            obj.focus();\n            return false;\n        }\n    }\n}\n/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/\nasync function showChecklistDetails(isDisable)\n{ \n\t\n\tvar request_type= document.forms[0].req_type.value;  // added by mujafar for ML-MMOH-CRF-0762\n\tvar requestor_code = document.forms[0].hdd_requestor_code.value; // added by mujafar for ML-MMOH-CRF-0762\n\t\n\t\n\t\n\t\n\tvar call_function\t= document.forms[0].call_function.value; \n    \tvar retVal\t\t\t= new String();\n\tvar center\t\t\t= \"3\" ;\n\tvar dialogTop\t\t= \"0vh\"; \n\tvar dialogHeight = \"50vh\";\n\tvar dialogWidth\t = \"35vw\";\n\t//Modified the condition by Kamatchi S ML-MMOH-CRF-1464\n\tif(document.forms[0].classification_appl_yn.value==\"true\")\n\t{\n\t\tdialogHeight\t= \"50vh\"; // modified by mujafar for ML-MMOH-CRF-0762\n\t\tdialogWidth\t\t= \"35vw\";\n\t}\n\telse\n\t{\n\t\tdialogHeight\t= \"50vh\";\t\n\t\tdialogWidth\t\t= \"35vw\";\n\t}\n\tvar status\t\t\t= \"no\";\n\tvar arguments\t= \"\" ;\n\tvar features\t\t= \" dialogHeight:\"+dialogHeight+\"; scroll=no; dialogWidth:\"+dialogWidth+\"; center:\"+center+\"; status=no; dialogTop:\"+dialogTop;\n\t\n\tif(document.forms[0].classification_appl_yn.value == \"true\"  )\n\t{ // added by mujafar for ML-MMOH-CRF-0762\t\t\n\t\t\t\tif(document.forms[0].req_type.value == \"\")\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\tvar msg = getMessage(\"CAN_NOT_BE_BLANK\",\"COMMON\");\n\t\t\t\tvar msgg = msg.replace(\"$\",getLabel(\"eMR.RequestorType.label\",\"MR\"));\n\t\t\t\t\n\t\t\t\talert(msgg);\n\t\t\t\treturn;\t\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].req_type.value != \"\")\n\t\t\t\t{  \n\t\t\t\t\tif(document.forms[0].req_type_status.value ==\"\" || document.forms[0].req_type_status.value == \"O\" )\n\t\t\t\t\t{ \n\t\t\t\t\t\tif(document.forms[0].classification_ind.value == \"\" || document.forms[0].classification_ind.value == \"O\")\n\t\t\t\t\t\tif(document.forms[0].requestor_desc.value == \"\")\n\t\t\t\t\t\t{ \n\t\t\t\t\t\t\tvar msg1 = getMessage(\"CAN_NOT_BE_BLANK\",\"COMMON\");\n\t\t\t\t\t\t\tvar msgg1 = msg1.replace(\"$\",getLabel(\"Common.Requestor.label\",\"Common\"));\n\t\t\t\t\t\n\t\t\t\t\t\t\talert(msgg1);\n\t\t\t\t\t\t\treturn;\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\tvar xmlDoc = \"\"\n\t\tvar xmlHttp = new XMLHttpRequest()\n\t\txmlStr =\"<root><SEARCH request_type=\\\"\"+request_type+\"\\\" requestor_code=\\\"\"+requestor_code+\"\\\" action=\'ChecklistCount\' /></root>\"\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\txmlHttp.open(\"POST\",\"../../eMR/jsp/MRIntermediate.jsp\",false)\n\t\txmlHttp.send(xmlDoc)\n\t\tresponseText=xmlHttp.responseText\n\t\tresponseText = trimString(responseText)\n\t\t \n\t\tif(responseText == 0)alert(getMessage(\'CHK_LIST_NOT_DEFINED\',\'MR\'));\n\t\t\n\t\t\n\t\n\t\tif(responseText > 0)\n\t\t{\n\t\t\tretVal=await window.showModalDialog(\"../../eMR/jsp/ChargesDetails.jsp?request_id=\"+document.forms[0].request_id.value+\"&call_function=\"+document.forms[0].call_function.value+\"&requestor_desc=\"+document.forms[0].requestor_desc.value+\"+&req_code=\"+document.forms[0].hdd_requestor_code.value+\"+&req_type=\"+document.forms[0].req_type.value+\"+&classification_appl_yn=\"+document.forms[0].classification_appl_yn.value+\"+&toShow=ChecklistDetails&call_function=\"+document.forms[0].call_function.value+\"&isDisable=\"+isDisable+\"&arrgu=\"+document.forms[0].ret_val1.value,arguments,features);\n\t\t\t // modified by mujafar for ML-MMOH-CRF-0762\n\t\t\tif(retVal != undefined)\n\t\t\t\tdocument.forms[0].ret_val1.value= retVal;\n\t\t\t\t\n\t\t}\n\t\t\t\t\n\t}\n\t\n\telse\n\t{\n\tretVal=await window.showModalDialog(\"../../eMR/jsp/ChargesDetails.jsp?toShow=ChecklistDetails&call_function=\"+document.forms[0].call_function.value+\"&isDisable=\"+isDisable+\"&arrgu=\"+document.forms[0].ret_val.value,arguments,features);\n\tif(retVal != undefined)\n\tdocument.forms[0].ret_val.value= retVal;\n\t} // added by mujafar for ML-MMOH-CRF-0762 end\n\t\n\t\n}\n/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/\n\nfunction populateRecptDate(obj, dateObj, dateImg)\n{\n\tif(document.forms[0].medrep_pay_int_mode.value == \"X\")\n\t{\n\t\tif(document.forms[0].call_function.value  == \"MEDICAL_REPORT_REQUEST\")\n\t\t{\n\t\t\tif(obj != \"\")\n\t\t\t{\n\n\t\t\t\t//dateObj.value = document.forms[0].sysdate.value;\n\t\t\t\tdateObj.value = convertDate(document.forms[0].sysdate.value,\'DMYHM\',\'en\',localeName);\n\n\t\t\t}\n\t\t\telse\n\t\t\t\tdateObj.value = \"\";\n\t\t}\n\t\telse if(document.forms[0].call_function.value  == \"MEDICAL_REPORT_STATUS\")\n\t\t{\n\t\t\tif(obj != \"\")\n\t\t\t{\n\t\t\t\tdateObj.disabled = false;\n\t\t\t\tdateImg.disabled = false;\n\t\t\t\tdateObj.focus();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdateObj.value = \"\";\n\t\t\t\tdateObj.disabled = true;\n\t\t\t\tdateImg.disabled = true;\n\t\t\t}\n\t\t}\n\t}\n}\n\n\n\nfunction validateRecptDateTime(from,to)\n{\n\tfrom = from.value;\n\tto   = to.value;\n\tvar a=  from.split(\" \");\n\tsplitdate=a[0];\n\tsplittime=a[1];\n\tvar splitdateA =splitdate.split(\"/\");\n\tvar splittimeA= splittime.split(\":\");\n\tvar from_date  =new Date(eval(splitdateA[2]), eval(splitdateA[1])-1, eval(splitdateA[0]), eval(splittimeA[0]), eval(splittimeA[1]));\n\n\tvar b=  to.split(\" \");\n\tsplitdate=b[0];\n\tsplittime=b[1];\n\tvar splitdateB =splitdate.split(\"/\");\n\tvar splittimeB= splittime.split(\":\");\n\tvar to_date  =new Date(eval(splitdateB[2]), eval(splitdateB[1])-1, eval(splitdateB[0]), eval(splittimeB[0]), eval(splittimeB[1]));\n\n\tif(Date.parse(to_date) <= Date.parse(from_date))\n\t\treturn false;\n\telse\n\t\treturn true;\n}\n\n\nfunction recptDateValidations(obj, reqDate, sysDate)\n{\n\t//var result = \"Pass\";\n\t//var recptDate = obj.value;\n\t//var systemDate = sysDate.value;\n\tvar requestDate = reqDate.value;\n\n\t/*if(recptDate != \'\' )\n\t{\n\t\tif(!doDateTimeChk(obj))\n\t\t{\n\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"));\n\t\t\tobj.value = \"\";\n\t\t\tresult = \"Fail\";\n\t\t\tobj.focus();\n\t\t\treturn ;\n\t\t}\n\t}*/\n\n\tif(!validDateObj(obj,\'DMYHM\',localeName))\n\t{\n\t\tobj.value = \"\";\n\t\t//result = \"Fail\";\n\t\t//obj.focus();\n\t\treturn false;\n\t}\n\t//if(result == \"Pass\" && recptDate != \'\')\n\telse\n\t{\n\t\t\tvar greg_receiptDateTime = convertDate(obj.value,\'DMYHM\',localeName,\'en\');\n\t\t\tif(isAfterNow(greg_receiptDateTime,\'DMYHM\',\'en\'))\n\t\t\t//if(validateRecptDateTime(sysDate,obj))\n\t\t\t{\n\t\t\t\tvar error=getMessage(\"MRDATE1_GT_DATE2\",\"MR\");\n\t\t\t\terror= error.replace(\'$\',getLabel(\"Common.receiptdate.label\",\"Common\"));\n\t\t\t\terror= error.replace(\'#\',getLabel(\"Common.SystemDateTime.label\",\"Common\"));\n\t\t\t\talert(error);\n\t\t\t\t//Receipt date shud nnot be greater than system date ...\n\t\t\t\tobj.value = \"\";\n\t\t\t\t//obj.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t//else if(validateRecptDateTime(obj,reqDate))\n\t\t\telse if(isBefore(greg_receiptDateTime,requestDate,\'DMYHM\',\'en\'))\n\t\t\t{\n\t\t\t\tvar error=getMessage(\"MRDATE1_LT_DATE2\",\"MR\");\n\t\t\t\terror= error.replace(\'$\',getLabel(\"Common.receiptdate.label\",\"Common\"));\n\t\t\t\terror= error.replace(\'#\',getLabel(\"Common.RequestDate.label\",\"Common\"));\n\t\t\t\talert(error);\n\t\t\t\t//Receipt date shud not be lass than Request date ...\n\t\t\t\tobj.value = \"\";\n\t\t\t\t//obj.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t\treturn true;\n\t}\n}\n// added for ML-MMOH-CRF-0704 START\nfunction isHoliday(obj)\n{ \n\tif(document.forms[0].isMedicalReportDurationAppl.value == \"true\" && document.forms[0].appl_status.value == \'2\' )\n\t{\n\t\t\n\t\tvar appl_col_date = obj.value ;\n\t\tvar appl_type_val = document.forms[0].appl_type.value;\n\t\tvar appl_col_flag = \'C\';\n\t\tif(appl_col_date!=\"\")\n\t\t{\n\t\t\n\t\t\n\t\t\n\t\tvar xmlDoc = \"\"\n\t\tvar xmlHttp = new XMLHttpRequest()\n\t\txmlStr =\"<root><SEARCH appl_col_date=\\\"\"+appl_col_date+\"\\\" appl_type_val=\\\"\"+appl_type_val+\"\\\" appl_col_flag=\\\"\"+appl_col_flag+\"\\\" action=\'isHoliday\' /></root>\"\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\txmlHttp.open(\"POST\",\"../../eIP/jsp/IPintermediate.jsp\",false)\n\t\txmlHttp.send(xmlDoc)\n\t\tresponseText=xmlHttp.responseText\n\t\tresponseText = trimString(responseText)\n\t\t\n\t\tif(responseText == \"Entered date is Holiday\"){\n\t\t\tvar msg = getMessage(\"ENTER_DATE_HOLIDAY\",\"MR\");\n\t\t\talert(msg);\n\t\t\tobj.value=\"\";\n\t\t\tobj.focus();\n\t\t\t\n\t\t}\n\t\t\n\t\t}\n\t\t\n\t}\n\t\n}\nfunction chkCollectDate2()\n{\n\tif((document.forms[0].isMedicalReportDurationAppl && document.forms[0].isMedicalReportDurationAppl.value == \"true\") && (document.forms[0].appl_status &&document.forms[0].appl_status.value == \'2\'))\n\t{ \n\tdocument.forms[0].appl_comp_date.onblur();\n\t}\n}\nfunction compare_from(from,to)\n{ \nif(document.forms[0].isMedicalReportDurationAppl.value == \"true\" && document.forms[0].appl_status.value == \'2\' )\n\t{\n\t\tif(from.value!=\"\" && to.value!=\"\" )\n\t\t{ \n\t\n\t\t\tif(isBefore(from.value,to.value,\'DMYHM\',localeName)==false)\n\t\t\t\t{\n\t\t\t\tvar error=getMessage(\"MRDATE1_LT_DATE2\",\'MR\');\n\t\t\t\terror= error.replace(\'$\',getLabel(\"eMR.CollectDate.label\",\"MR\"));\n\t\t\t\terror= error.replace(\'#\',getLabel(\"eMR.ApplicationCompletionDates.label\",\"MR\"));\n\t\t\t\talert(error);\n\t\t\t\tto.value=\"\";\n\t\t\t\tto.select();\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse\n\t\t\t\treturn true;\n\t\t}\n\t}\n}\nfunction validate_date_from(from)\n{\n\tif(document.forms[0].isMedicalReportDurationAppl.value == \"true\" && document.forms[0].appl_status.value == \'2\' )\n\t{\n\t\tvar sys=document.forms[0].sysdate;\n\t\tif(from.value!=\"\")\n\t\t{\n\t\t\tif(!validDateObj(from,\"DMYHM\",localeName)){\n\t\t\t\t\tfrom.value=\"\";\n\t\t\t\t\treturn ;\n\t\t\t}\n\t\tvar obj1=convertDate(from.value,\"DMYHM\",localeName,\"en\");\n\t\t\tif(isBefore(sys.value,obj1,\'DMYHM\',localeName)==false){\n\t\t\t\tvar error=getMessage(\"MRDATE1_LT_DATE2\",\'MR\');\n\t\t\t\t\t\t\t\t\t\n\t\t\t\tif(from.name == \"appln_col_date\") \n\t\t\t\t\t{\n\t\t\t\t\t\terror= error.replace(\'$\',getLabel(\"eMR.ApplicationCompletionDates.label\",\"MR\"));\n\t\t\t\t\t\terror= error.replace(\'#\',getLabel(\"Common.SystemDate.lab";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="el\",\"Common\"));\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\terror= error.replace(\'$\',getLabel(\"eMR.CollectDate.label\",\"MR\"));\n\t\t\t\t\t\terror= error.replace(\'#\',getLabel(\"Common.SystemDate.label\",\"Common\"));\n\t\t\t\t\t}\n\t\t\t\t\talert(error);\n\t\t\t\t\tfrom.value=\"\";\n\t\t\t\t\tfrom.select();\t\n\t\t\t\t\treturn false;\n\t\t\t }\n\t\t\t\telse\n\t\t\t\t\treturn true;\n\n\t\t}\n\t}\n}\nfunction chkCollectDate1(obj)\n{\n\t\n\tif(document.forms[0].isMedicalReportDurationAppl.value == \"true\" && document.forms[0].appl_status.value == \'2\' )\n\t{\n\t\n\t\n\tvar ret_collect_date = chkCollectDate(obj);\n\t\n\t\tif(ret_collect_date != \'Entered date is Holiday\')\n\t\tdocument.forms[0].collection_date.value = ret_collect_date;\n\t\telse\n\t\tdocument.forms[0].collection_date.value =\"\";\n\t\tif(document.forms[0].collection_date.value  != \'undefined\')\n\t\tdocument.forms[0].collect_date.value = document.forms[0].collection_date.value;\n\t}\n}\n\nfunction chkCollectDate(obj)\n{ \n\tif(document.forms[0].isMedicalReportDurationAppl.value == \"true\" && document.forms[0].appl_status.value == \'2\' )\n\t{ \n\t\t\n\t\tvar appl_col_date = obj.value ;\n\t\t\n\t\tvar appl_type_val = document.forms[0].appl_type.value;\n\t\tvar appl_col_flag = \'A\';\n\t\tif(appl_col_date!=\"\")\n\t\t{ \n\t\t\n\t\t\n\t\t\n\t\tvar xmlDoc = \"\"\n\t\tvar xmlHttp = new XMLHttpRequest()\n\t\txmlStr =\"<root><SEARCH appl_col_date=\\\"\"+appl_col_date+\"\\\" appl_type_val=\\\"\"+appl_type_val+\"\\\" appl_col_flag=\\\"\"+appl_col_flag+\"\\\" action=\'calCollectDate\' /></root>\"\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\txmlHttp.open(\"POST\",\"../../eIP/jsp/IPintermediate.jsp\",false)\n\t\txmlHttp.send(xmlDoc)\n\t\tresponseText=xmlHttp.responseText\n\t\tresponseText = trimString(responseText)\n\t\t\n\t\tif(responseText == \"Entered date is Holiday\"){\n\t\t\tvar msg = getMessage(\"ENTER_DATE_HOLIDAY\",\"MR\");\n\t\t\talert(msg);\n\t\t\tobj.value=\"\";\n\t\t\tobj.focus();\n\t\t\t\n\t\t}\n\t\telse{\n\t\t\t\n\t\t\t\n\t\t}\n\t\t\n\t\treturn responseText;\n\t\t\n\t\t}\n\t\t\n\t\t\n\t\t\n\t}\n\t\n}\n// added for ML-MMOH-CRF-0704 END\nfunction CheckZeroVal(obj) \n{\n    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {\n        return true;\n    }\n    else {\n        if ( obj.value.length > 0 && obj.value==0) {\n            alert(getMessage(\"VALUE_SHOULD_BE_GR_ZERO\",\"Common\"));\n            obj.select();\n            obj.focus();\n            return false;\n        }\n    }\n}\n\n\nfunction enableOtherDetails(name, value)\n{\n\tmedrep_pay_int_mode = document.forms[0].medrep_pay_int_mode.value;\n\tif(medrep_pay_int_mode == \"X\")\n\t{\n\t\tif(name == \'charges_appllicable\')\n\t\t{\n\t\t\tif(value ==\'Y\')\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'amount\').value = \"\";\n\t\t\t\tdocument.getElementById(\'amount\').disabled = false;\n\t\t\t\tdocument.getElementById(\"chargeImg2\").style.visibility = \"visible\";\n\t\t\t\tdocument.getElementById(\'recp_no\').value = \"\";\n\t\t\t\tdocument.getElementById(\'recp_no\').disabled = false;\n\t\t\t\tdocument.getElementById(\'recp_dat\').value = \"\";\n\t\t\t\tdocument.getElementById(\'recp_dat\').disabled = true;\n\t\t\t\tdocument.getElementById(\"recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t\telse if(value ==\'N\' || value ==\'\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].amount.value = \"\";\n\t\t\t\tdocument.forms[0].amount.disabled = true;\n\t\t\t\tdocument.getElementById(\"chargeImg2\").style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t}\n\t\telse if(name == \'additional_charges\')\n\t\t{\n\t\t\tif(value ==\'Y\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].add_amount.value = \"\";\n\t\t\t\tdocument.forms[0].add_amount.disabled = false;\n\t\t\t\tdocument.forms[0].add_recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_no.disabled = false;\n\t\t\t\tdocument.forms[0].add_recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"add_recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t\telse if(value ==\'N\' || value ==\'\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].add_amount.value = \"\";\n\t\t\t\tdocument.forms[0].add_amount.disabled = true;\n\t\t\t\tdocument.forms[0].add_recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].add_recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"add_recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t}\n\t}\n\telse if(medrep_pay_int_mode == \"B\")\n\t{\n\t\tif(name == \'charges_appllicable\')\n\t\t{\n\t\t\tif(value ==\'Y\')\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'amount\').value = \"\";\n\t\t\t\tdocument.getElementById(\'amount\').disabled = false;\n\t\t\t\tdocument.getElementById(\"chargeImg2\").style.visibility = \"visible;\";\n\t\t\t\tdocument.forms[0].recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t\telse if(value ==\'N\' || value ==\'\')\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'amount\').value = \"\";\n\t\t\t\tdocument.getElementById(\'amount\').disabled = true;\n\t\t\t\tdocument.getElementById(\"chargeImg2\").style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t}\n\t\telse if(name == \'additional_charges\')\n\t\t{\n\t\t\tif(value ==\'Y\')\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'add_amount\').value = \"\";\n\t\t\t\tdocument.getElementById(\'add_amount\').disabled = false;\n\t\t\t\tdocument.getElementById(\"addtlChargeImg2\").style.visibility = \"visible\";\n\t\t\t\tdocument.forms[0].add_recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].add_recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"add_recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t\telse if(value ==\'N\' || value ==\'\')\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'add_amount\').value = \"\";\n\t\t\t\tdocument.getElementById(\'add_amount\').disabled = true;\n\t\t\t\tdocument.getElementById(\"addtlChargeImg2\").style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].add_recp_no.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_no.disabled = true;\n\t\t\t\tdocument.forms[0].add_recp_dat.value = \"\";\n\t\t\t\tdocument.forms[0].add_recp_dat.disabled = true;\n\t\t\t\tdocument.getElementById(\"add_recp_dat_img\").disabled = true;\n\t\t\t}\n\t\t}\t\n\t}\n}\n\n\nasync function showDateDetails()\n{\n\tvar call_function\t= document.forms[0].call_function.value;\n\n\tvar retVal\t\t\t= new String();\n\tvar center\t\t\t= \"3\" ;\n\tvar dialogTop\t\t= \"0vh\";\n\tvar dialogHeight\t= \"39vh\";\n\tvar dialogWidth\t\t= \"40vw\";\n\tvar status\t\t\t= \"no\";\n\tvar arguments\t= \"\" ;\n\tvar features\t\t= \" dialogHeight:\"+dialogHeight+\"; scroll=no; dialogWidth:\"+dialogWidth+\"; center:\"+center+\"; status=no; dialogTop:\"+dialogTop;\n\n\tretVal =await window.showModalDialog(\"../../eMR/jsp/ChargesDetails.jsp?toShow=DateDetails&call_function=\"+document.forms[0].call_function.value+\"&PrepareDate=\"+document.forms[0].prepareDate.value+\"&applCompletionDate=\"+document.forms[0].applCompletionDate.value+\"&RequestDate=\"+document.forms[0].RequestDate.value+\"&ReceivedDate=\"+document.forms[0].ReceivedDate.value+\"&applSubmissionDate=\"+document.forms[0].applSubmissionDate.value+\"&DeliveredDate=\"+document.forms[0].DeliveredDate.value,arguments,features);\n}\n\n\nasync function showChargeDetails()\n{\n\tvar call_function\t= document.forms[0].call_function.value;\n\n\tvar retVal\t\t\t= new String();\n\tvar center\t\t\t= \"3\" ;\n\tvar dialogTop\t\t= \"0vh\";\n\tvar dialogHeight\t= \"39vh\";\n\tvar dialogWidth\t\t= \"40vw\";\n\tvar status\t\t\t= \"no\";\n\tvar arguments\t= \"\" ;\n\tvar features\t\t= \" dialogHeight:\"+dialogHeight+\"; scroll=no; dialogWidth:\"+dialogWidth+\"; center:\"+center+\"; status=no; dialogTop:\"+dialogTop;\n\n\tretVal =await window.showModalDialog(\"../../eMR/jsp/ChargesDetails.jsp?toShow=ChargeDetails&call_function=\"+document.forms[0].call_function.value+\"&charges_appl_yn=\"+document.forms[0].hdd_charges_appl_yn.value+\"&addl_charges_yn=\"+document.forms[0].hdd_addl_charges_yn.value+\"&receipt_no=\"+document.forms[0].hdd_receipt_no.value+\"&addl_receipt_no=\"+document.forms[0].hdd_addl_receipt_no.value+\"&amount=\"+document.forms[0].hdd_amount.value+\"&addl_amount=\"+document.forms[0].hdd_addl_amount.value+\"&receipt_date=\"+document.forms[0].hdd_receipt_date.value+\"&addl_receipt_date=\"+document.forms[0].hdd_addl_receipt_date.value,arguments,features);\n}\n\n\nfunction disableAll()\n{\n\tvar call_function\t= document.forms[0].call_function.value;\n\tif(call_function == \"MEDICAL_REPORT_CANCELLED\")\n\t{ \n\t\tdocument.forms[0].appl_type.disabled = true;\n\t\tdocument.forms[0].appln_date.disabled = true;\n\t\tdocument.forms[0].ApplnImg.disabled = true;\n\t\tdocument.forms[0].appl_name.disabled = true;\n\t\tdocument.forms[0].appl_refno.disabled = true;\n\t\tdocument.forms[0].relationship_type.disabled = true;\n\t\tdocument.forms[0].relationship.disabled = true;\n\t\tdocument.forms[0].req_type.disabled = true;\n\t\tdocument.forms[0].requestor_desc.disabled = true;\n\t\tdocument.forms[0].search_Requestor.disabled = true;\n\t\tif(document.forms[0].cons_letter)\n\t\t\tdocument.forms[0].cons_letter.disabled = true;\n\t\tdocument.forms[0].for_attn.disabled = true;\n\t\tdocument.forms[0].appl_no.disabled = true;\n\t\tdocument.forms[0].charges_appllicable.disabled = true;\n\t\tdocument.forms[0].additional_charges.disabled = true;\n\t\tdocument.forms[0].amount.disabled = true;\n\t\tdocument.forms[0].add_amount.disabled = true;\n\t\tdocument.forms[0].recp_no.disabled = true;\n\t\tdocument.forms[0].add_recp_no.disabled = true;\n\t\tdocument.forms[0].recp_dat.disabled = true;\n\t\tdocument.forms[0].recp_dat_img.disabled = true;\n\t\tdocument.forms[0].add_recp_dat.disabled = true;\n\t\tdocument.forms[0].add_recp_dat_img.disabled = true;\n\t\tdocument.forms[0].appl_status.disabled = true;\n\t\tdocument.forms[0].pract_desc.disabled = true;\n\t\tdocument.forms[0].pract_id_search.disabled = true;\n\t\tdocument.forms[0].reqd_docs.disabled = true;\n\t\t/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/\n\t\tvar isIncompReqCancelApplicable = document.forms[0].isIncompReqCancelApplicable.value;\n\t\tvar requestStatus\t\t\t\t= document.forms[0].requestStatus.value;\n\t\tif(isIncompReqCancelApplicable == \"true\" && requestStatus == \"8\"){\n\t\t\tdocument.getElementById(\"appln_col1\").innerText = getLabel(\"Common.cancelledby.label\",\"Common\");\n\t\t\tdocument.getElementById(\"appln_col2\").innerText = document.forms[0].cancelledBy.value;\n\t\t\t//Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108\n\t\t\t//document.getElementById(\"cncl_date_lbl\").innerText = getLabel(\"Common.cancelled.label\",\"Common\")+\" \"+getLabel(\"Common.on.label\",\"Common\");\n\t\t\tdocument.getElementById(\"cncl_date_lbl\").innerText = getLabel(\"Common.CancelledOn.label\",\"Common\");\n\t\t\tdocument.getElementById(\"cncl_date\").innerText = document.forms[0].cancelledDate.value;\n\t\t\t\n\t\t\tdocument.getElementById(\'hideRow\').style.display = \"block\";\n\t\t\tdocument.getElementById(\"cncl_reason_lbl\").innerText ";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block9_2 ="= getLabel(\"Common.ReasonforCancellation.label\",\"Common\");\n\t\t\tdocument.getElementById(\"cancel_reason\").style.visibility = \"visible\";\n\t\t\tdocument.forms[0].cancel_reason.disabled = true;\n\t\t\tvar reasonCode\t\t= document.forms[0].cancelledReason.value;\n\t\t\tfor(var i=0;i<document.forms[0].cancel_reason.options.length;i++ )\n\t\t\t{\n\t\t\t\tif(document.forms[0].cancel_reason.options[i].value == reasonCode)\n\t\t\t\t\tdocument.forms[0].cancel_reason.options[i].selected=true;\n\t\t\t}\n\t\t}\n\t\t/*End*/\n\t}\n\t\n}\n\nfunction showMsgSpecialty(){\n\t var specialtyEffStatus = document.forms[0].specialtyEffStatus.value;\n\t var specialtyMRApplYN = document.forms[0].specialtyMRApplYN.value;\n\t var Splcode\t\t\t= document.forms[0].Splcode.value;\n\t \n\t \n\t if(Splcode!=\"\"){\n\t \tif(specialtyEffStatus!=\"E\" ||specialtyMRApplYN!=\"Y\" ){\n\t \t\tvar msg = getMessage(\"SPL_NOT_COFIGURED\",\"MR\");\n\t\t\tvar msgg = msg.replace(\"#\",document.forms[0].dept_spl.value);\n\t\t\tdocument.forms[0].Splcode.value = \"\";\n\t\t\tdocument.forms[0].dept_spl.value =\"\";\n\t\t\talert(msgg);\n\t\t\treturn;\n\t \t}\n\t }\n\t \n\t\n\n}\n\n\n/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/\nfunction transMode()\n{\n\tvar call_function = document.forms[0].call_function.value;\n\tvar isChckLstApplicable = document.forms[0].isChckLstApplicable.value;\n\tif(isChckLstApplicable == \"true\") {\n\t\tif(call_function == \"DELIVER_MEDICAL_REPORT\" || call_function == \"MEDICAL_REPORT_COMPLETED\") { \n\t\t\tdocument.forms[0].applic_mode.value\t\t= document.forms[0].applicationMode.value;\n\t\t\tdocument.forms[0].collectn_mode.value\t= document.forms[0].collectionMode.value;\n\t\t\tdocument.forms[0].notific_mode.value\t= document.forms[0].notificationMode.value;\n\t\t\t\n\t\t}\n\t\t/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 Start*/\n\t\tif(call_function == \"MEDICAL_REPORT_COMPLETED\"){\n\t\t\tvar Despatch_mode\t= document.forms[0].Despatch_mode.value;\n\t\t\tif(Despatch_mode==\"P\"){\n\t\t\t\tdocument.getElementById(\"natIDRow\").style.display\t= \'block\';\n\t\t\t\tdocument.getElementById(\"lblDelDateTD\").style.display\t= \'block\';\n\t\t\t\tdocument.getElementById(\"fldDelDateTD\").style.display\t= \'block\';\n\t\t\t\tdocument.getElementById(\"altIDRow\").style.display\t= \'block\';\n\t\t\t\tdocument.getElementById(\"lblDatePostedTD\").style.display\t= \'none\';\n\t\t\t\tdocument.getElementById(\"fldDatePostedTD\").style.display\t= \'none\';\n\t\t\t\tdocument.getElementById(\"postAgeNoRow\").style.display = \'none\';\n\t\t\t\t\n\t\t\t}else if(Despatch_mode==\"O\"){\n\t\t\t\tdocument.getElementById(\"natIDRow\").style.display\t= \'none\';\n\t\t\t\tdocument.getElementById(\"lblDelDateTD\").style.display\t= \'none\';\n\t\t\t\tdocument.getElementById(\"fldDelDateTD\").style.display\t= \'none\';\n\t\t\t\tdocument.getElementById(\"altIDRow\").style.display\t= \'none\';\n\t\t\t\tdocument.getElementById(\"lblDatePostedTD\").style.display\t= \'block\';\n\t\t\t\tdocument.getElementById(\"fldDatePostedTD\").style.display\t= \'block\';\n\t\t\t\tdocument.getElementById(\"postAgeNoRow\").style.display = \'block\';\n\n\t\t\t}\n\t\t}\n\t\t/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 End*/\n\n\t}\n}\n/*ML-MMOH-CRF-0963 START*/\nfunction frwdtoPractMedicalReport()\n{\n\t   \nif(document.forms[0].isMedicalReportRequest && document.forms[0].isMedicalReportRequest.value==\"true\")\n{\n\tif(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==true )\n\t{\n\t\t  if(document.forms[0].remarks){\n\t\t\t\tdocument.forms[0].remarks.value=\"\";\n\t\t\t\tdocument.forms[0].remarks.disabled = true;\n\t\t\t}\n\t\t\tif(document.forms[0].fwd_pract_desc){\n\t\t\t\t\t\t\t\t\t   \n\t\t\t\tdocument.forms[0].fwd_pract_desc.disabled = true;\n\t\t\t}\n\t\t\t\t\t\t\n\t\t\tif(document.forms[0].fwd_pract_id_search) document.forms[0].fwd_pract_id_search.disabled = true; \n\t\t\t\n\t\t\t\n\t\t\tif(document.forms[0].prep_pract_desc){\n\t\t\t\tdocument.forms[0].prep_pract_desc.value=\"\"; \t\t\t\t\t   \n\t\t\t\tdocument.forms[0].prep_pract_desc.disabled = true;\n\t\t\t}\n\t\t\tif(document.forms[0].prep_practitioner_id) document.forms[0].prep_practitioner_id.value=\"\";\t\t\n\t\t\t\n\t\t\tif(document.forms[0].prep_pract_id_search) document.forms[0].prep_pract_id_search.disabled = true; \n\t\t\tif(document.forms[0].prep_pract_desc_Img) document.forms[0].prep_pract_desc_Img.style.visibility = \"hidden\";  \n\t\t\t\n\t\t\tif(document.forms[0].prepare_date)  document.forms[0].prepare_date.disabled = true;\n        \n\t\t    document.getElementById(\"cancelby_medical_report\").innerText = getLabel(\"Common.cancelledby.label\",\"Common\");\n\t\t\tdocument.getElementById(\"cancelby_med_rep_user\").innerText = document.forms[0].loginUser.value;\n\t\t\t//Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108\n\t\t\t//document.getElementById(\"cancelon_medical_report\").innerText = getLabel(\"Common.cancelled.label\",\"Common\")+\" \"+getLabel(\"Common.on.label\",\"Common\");\n\t\t\tdocument.getElementById(\"cancelon_medical_report\").innerText = getLabel(\"Common.CancelledOn.label\",\"Common\");\n\t\t\t\t\n\t\t\tdocument.getElementById(\"cancelondate_medical_report\").innerText = getCurrentDate(\"DMYHM\",\"en\");\n\t\t\t\n\t\t\tdocument.getElementById(\"cancel_medrep_reason\").innerText = getLabel(\"Common.ReasonforCancellation.label\",\"Common\");\n\t\t\tif(document.getElementById(\"cancel_medical_rep_reason\"))document.getElementById(\"cancel_medical_rep_reason\").style.visibility = \"visible\";\n\t\t\tdocument.getElementById(\"cancel_medical_rep_reason_img\").style.visibility = \"visible\";\n\t\t\t\n\t\t\tif(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value=\"Y\";\n\t\t\t\n\t\t\t\t\n\t\t}if(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==false)\n\t\t{\n\t\t    if(document.forms[0].remarks) document.forms[0].remarks.disabled = false;\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\tif(document.forms[0].fwd_pract_desc) document.forms[0].fwd_pract_desc.disabled = false;\n\t\t\t\t\t\t\t\n\t\t\tif(document.forms[0].fwd_pract_id_search) document.forms[0].fwd_pract_id_search.disabled = false; \n\t\t\t\n\t\t\tif(document.forms[0].prepare_date)  document.forms[0].prepare_date.disabled = false;\n\t\t\tif(document.forms[0].prep_pract_desc){\n\t\t\t\tdocument.forms[0].prep_pract_desc.value=\"\"; \t\t\t\t\t   \n\t\t\t\tdocument.forms[0].prep_pract_desc.disabled = false;\n\t\t\t}\n\t\t\tif(document.forms[0].prep_pract_id_search) document.forms[0].prep_pract_id_search.disabled = false; \n\t\t\tif(document.forms[0].prep_pract_desc_Img) document.forms[0].prep_pract_desc_Img.style.visibility = \"visible\";\n\t\t\t\n\t\t\tdocument.getElementById(\"cancelby_medical_report\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cancelby_med_rep_user\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cancelon_medical_report\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cancelondate_medical_report\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cancel_medrep_reason\").innerText = \"\";\n\t\t\tif(document.getElementById(\"cancel_medical_rep_reason\"))document.getElementById(\"cancel_medical_rep_reason\").options[0].selected=true;\n\t\t\tdocument.getElementById(\"cancel_medical_rep_reason\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"cancel_medical_rep_reason_img\").style.visibility = \"hidden\";\n\t\t\t if(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value=\"N\"; \t\t\t\n\t\t\t\n\t\t}\n\t}\n\t\n\t\n\t\n\t\n}\n\n\n/*ML-MMOH-CRF-0963 END*/\n/*Below line added for this CRF ML-MMOH-CRF-0712*/\nfunction medicalReport(){ \n\tvar isSpecialtyDefaultApp = document.forms[0].isSpecialtyDefaultApp.value;\n\tif(document.forms[0].isMedicalReportRequest && document.forms[0].isMedicalReportRequest.value==\"true\"){\n\t\tif(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==true ){\n\t\t\t\t/*Commented By Dharma on 18th Dec 2019 against  ML-MMOH-CRF-1454 Start*/\n\t\t\t    /*if(document.forms[0].appl_type) document.forms[0].appl_type.disabled = true;\t\t\t\t\t\t\t\t\t\t\n\t\t\t\tif(document.forms[0].appln_date) document.forms[0].appln_date.disabled = true;\t               \t\t\t\t\n\t\t\t\tif(document.forms[0].ApplnImg) document.forms[0].ApplnImg.disabled = true;\n\t\t\t\tif(document.forms[0].appl_name) document.forms[0].appl_name.disabled = true;\n\t\t\t\tif(document.forms[0].appl_refno) document.forms[0].appl_refno.disabled = true;\n\t\t\t\tif(document.forms[0].relationship_type) document.forms[0].relationship_type.disabled = true;\n\t\t\t\tif(document.forms[0].relationship) document.forms[0].relationship.disabled = true;\n\t\t\t\tif(document.forms[0].req_type) document.forms[0].req_type.disabled = true;\n\t\t\t\tif(document.forms[0].requestor_desc) document.forms[0].requestor_desc.disabled = true;\n\t\t\t\tif(document.forms[0].search_Requestor) document.forms[0].search_Requestor.disabled = true;\n\t\t\t\tif(document.forms[0].cons_letter) document.forms[0].cons_letter.disabled = true;\n\t\t\t\tif(document.forms[0].for_attn) document.forms[0].for_attn.disabled = true;\n\t\t\t\tif(document.forms[0].appl_no) document.forms[0].appl_no.disabled = true;*/\n\t\t\t\t/*Commented By Dharma on 18th Dec 2019 against  ML-MMOH-CRF-1454 End*/\n\t\t\t\tif(document.forms[0].rep_type){\n\t\t\t\t       document.forms[0].rep_type.value=\"\";\n\t\t\t\t       document.forms[0].rep_type.disabled = true;\n\t\t\t\t}\n\t\t\t\n\t\t\t\tif(document.forms[0].dept_spl){ \n\t\t\t\t\tif(isSpecialtyDefaultApp==\"false\"){\n\t\t\t\t       document.forms[0].dept_spl.value=\"\";\n\t\t\t\t\t}\n\t\t\t\t       document.forms[0].dept_spl.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].search_spl) document.forms[0].search_spl.disabled = true;\n\t\t\t\tif(document.forms[0].remarks){\n\t\t\t\t       document.forms[0].remarks.value=\"\"; \n\t\t\t\t       document.forms[0].remarks.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].fwd_hod_desc){\n\t\t\t\t       document.forms[0].fwd_hod_desc.value=\"\";\n\t\t\t\t       document.forms[0].fwd_hod_desc.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].fwd_hod_id_search) document.forms[0].fwd_hod_id_search.disabled = true;\n\t\t\t\t\n\t\t\t\t\t//added by mujafar for ML-MMOH-CRF-0716\n\t\t\t\t\tif((document.forms[0].call_function.value ==\"FORWARD_MEDICAL_REPORT\" || document.forms[0].call_function.value ==\"REJECTED_BY_PRACT_TO_MRD\") && document.forms[0].isMedicalTeamApplicable.value == \"true\") // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316\n\t\t\t\t\t{ \n\t\t\t\t\tif(document.getElementById(\"medical_team_val\"))\n\t\t\t\t\t{document.getElementById(\"medical_team_val\").options[0].selected=true;\n\t\t\t\t\tdocument.getElementById(\"medical_team_val\").disabled = true;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(document.getElementById(\"medical_team_val1\")){document.getElementById(\"medical_team_val1\").options[0].selected=true;\n\t\t\t\t\tdocument.getElementById(\"medical_team_val1\").disabled = true;\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(document.forms[0].inform_hod_desc){\n\t\t\t\t       document.forms[0].inform_hod_desc.value=\"\";\n\t\t\t\t       document.forms[0].inform_hod_desc.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].inform_hod_pract_id_search) document.forms[0].inform_hod_pract_id_search.disabled = true;\n\t\t\t\tif(document.forms[0].pract_desc) document.forms[0].pract_desc.disabled = true;\n\t\t\t\tif(document.forms[0].pract_id_search) document.forms[0].pract_id_search.disabled = true;\n\t\t\t\t\t\t\t\t\n\t\t\n\t\t\t\tdocument.getElementById(\"cancelby_medical_report\").innerText = getLabel(\"Common.cancelledby.label\",\"Common\");\n\t\t\t\tdo";
    private final static byte[]  _wl_block9_2Bytes = _getBytes( _wl_block9_2 );

    private final static java.lang.String  _wl_block9_3 ="cument.getElementById(\"cancelby_med_rep_user\").innerText = document.forms[0].loginUser.value;\n\t\t\t\t//Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108\n\t\t\t\t//document.getElementById(\"cancelon_medical_report\").innerText = getLabel(\"Common.cancelled.label\",\"Common\")+\" \"+getLabel(\"Common.on.label\",\"Common\");\n\t\t\t\tdocument.getElementById(\"cancelon_medical_report\").innerText = getLabel(\"Common.CancelledOn.label\",\"Common\");\n\t\t\t\t//document.getElementById(\"cancelondate_medical_report\").innerText = document.forms[0].sysdate.value;\t\t\t\t\n\t\t\t\tdocument.getElementById(\"cancelondate_medical_report\").innerText = getCurrentDate(\"DMYHM\",\"en\");\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\"cancel_medrep_reason\").innerText = getLabel(\"Common.ReasonforCancellation.label\",\"Common\");\n\t\t\t\tif(document.getElementById(\"cancel_medical_rep_reason\"))document.getElementById(\"cancel_medical_rep_reason\").style.visibility = \"visible\";\n\t\t\t\tdocument.getElementById(\"cancel_medical_rep_reason_img\").style.visibility = \"visible\";\t\n\t\t\t\t/*if(document.getElementById(\"appl_type_mandatory\"))document.getElementById(\"appl_type_mandatory\").style.visibility = \"hidden\"; \t\t\t\t\n\t\t\t\tif(document.getElementById(\"appl_date_madndatory\")) document.getElementById(\"appl_date_madndatory\").style.visibility = \"hidden\";*/\t\t\t\t\n\t\t\t\tif(document.getElementById(\"ReportTypeImg\")) document.getElementById(\"ReportTypeImg\").style.visibility = \"hidden\"; \n\t\t\t\tif(document.getElementById(\"DeptImg\")) document.getElementById(\"DeptImg\").style.visibility = \"hidden\";\n                if(document.getElementById(\"fwd_hod_img\")) document.getElementById(\"fwd_hod_img\").style.visibility = \"hidden\";\t\n                if(document.getElementById(\"inform_hod_img\")) document.getElementById(\"inform_hod_img\").style.visibility = \"hidden\"; \n\t\t\t\tif(document.forms[0].fwd_hod_id)document.forms[0].fwd_hod_id.value=\"\";\n\t\t\t\tif(document.forms[0].inform_hod_practitioner_id)document.forms[0].inform_hod_practitioner_id.value=\"\";\n\t\t\t\t\n\t\t\t\t/*isSpecialtyDefaultApp condition added By Dharma on 3rd Dec 2019 against ML-MMOH-CRF-1454*/\n\t\t\t\tif(isSpecialtyDefaultApp==\"false\"){\n\t\t\t\t\tif(document.forms[0].Splcode)document.forms[0].Splcode.value=\"\";\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value=\"Y\";\n    \t\t\t\t\n\t\t\t\t\n\t\t}if(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==false){\n\t\t      /*Commented By Dharma on 18th Dec 2019 against  ML-MMOH-CRF-1454 Start*/\n\t\t\t    /*if(document.forms[0].appl_type) document.forms[0].appl_type.disabled = false;\t\t\t\t\n\t\t\t\tif(document.forms[0].appln_date) document.forms[0].appln_date.disabled = false;\t\t\t\t\n\t\t\t\tif(document.forms[0].ApplnImg) document.forms[0].ApplnImg.disabled = false;\n\t\t\t\tif(document.forms[0].appl_name) document.forms[0].appl_name.disabled = false;\n\t\t\t\tif(document.forms[0].appl_refno) document.forms[0].appl_refno.disabled = false;\n\t\t\t\tif(document.forms[0].relationship_type) document.forms[0].relationship_type.disabled = false;\n\t\t\t\tif(document.forms[0].relationship) document.forms[0].relationship.disabled = false;\n\t\t\t\tif(document.forms[0].req_type) document.forms[0].req_type.disabled = false;\n\t\t\t\tif(document.forms[0].requestor_desc) document.forms[0].requestor_desc.disabled = false;\n\t\t\t\tif(document.forms[0].search_Requestor) document.forms[0].search_Requestor.disabled = false;\n\t\t\t\tif(document.forms[0].cons_letter) document.forms[0].cons_letter.disabled = false;\n\t\t\t\tif(document.forms[0].for_attn) document.forms[0].for_attn.disabled = false;\n\t\t\t\tif(document.forms[0].appl_no) document.forms[0].appl_no.disabled = false;*/\n\t\t\t\t/*Commented By Dharma on 18th Dec 2019 against  ML-MMOH-CRF-1454 End*/\n\t\t\t\tif(document.forms[0].rep_type) document.forms[0].rep_type.disabled = false;\n\t\t\t\tif(document.forms[0].dept_spl) document.forms[0].dept_spl.disabled = false;\n\t\t\t\tif(document.forms[0].search_spl) document.forms[0].search_spl.disabled = false;\n\t\t\t\tif(document.forms[0].remarks) document.forms[0].remarks.disabled = false;\n\t\t\t\tif(document.forms[0].fwd_hod_desc) document.forms[0].fwd_hod_desc.disabled = false;\n\t\t\t\tif(document.forms[0].fwd_hod_id_search) document.forms[0].fwd_hod_id_search.disabled = false;\n\t\t\t\t//if(document.forms[0].reqd_docs) document.forms[0].reqd_docs.disabled = false;\n\t\t\t\tif((document.forms[0].call_function.value ==\"FORWARD_MEDICAL_REPORT\" || document.forms[0].call_function.value ==\"REJECTED_BY_PRACT_TO_MRD\" )&& document.forms[0].isMedicalTeamApplicable.value == \"true\")\n\t\t\t\t{ //added by mujafar for ML-MMOH-CRF-0716\n\t\t\t\t// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316\n\t\t\t\t\tdocument.getElementById(\"medical_team_val\").disabled = false;\n\t\t\t\t\tdocument.getElementById(\"medical_team_val1\").disabled = false;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].inform_hod_desc) document.forms[0].inform_hod_desc.disabled = false;\n\t\t\t\tif(document.forms[0].inform_hod_pract_id_search) document.forms[0].inform_hod_pract_id_search.disabled = false;\n\t\t\t\tif(document.forms[0].pract_desc) document.forms[0].pract_desc.disabled = false;\n\t\t\t\tif(document.forms[0].pract_id_search) document.forms[0].pract_id_search.disabled = false;\t\t\n\t\t\n\t\t\t\tdocument.getElementById(\"cancelby_medical_report\").innerText = \"\";\n\t\t\t\tdocument.getElementById(\"cancelby_med_rep_user\").innerText = \"\";\n\t\t\t\tdocument.getElementById(\"cancelon_medical_report\").innerText = \"\";\n\t\t\t\tdocument.getElementById(\"cancelondate_medical_report\").innerText = \"\";\n\t\t\t\tdocument.getElementById(\"cancel_medrep_reason\").innerText = \"\";\n\t\t\t\tif(document.getElementById(\"cancel_medical_rep_reason\"))document.getElementById(\"cancel_medical_rep_reason\").options[0].selected=true;\n\t\t\t\tdocument.getElementById(\"cancel_medical_rep_reason\").style.visibility = \"hidden\";\n\t\t\t\tdocument.getElementById(\"cancel_medical_rep_reason_img\").style.visibility = \"hidden\";\n\t\t\t\t\n\t\t\t\t/*if(document.getElementById(\"appl_type_mandatory\"))document.getElementById(\"appl_type_mandatory\").style.visibility = \"visible\"; \t\t\t\t\n\t\t\t\tif(document.getElementById(\"appl_date_madndatory\")) document.getElementById(\"appl_date_madndatory\").style.visibility = \"visible\";*/\t\t\t\t\n\t\t\t\t\n\t\t\t\tif(document.getElementById(\"ReportTypeImg\")) document.getElementById(\"ReportTypeImg\").style.visibility = \"visible\"; \n\t\t\t\tif(document.getElementById(\"DeptImg\")) document.getElementById(\"DeptImg\").style.visibility = \"visible\";\n                if(document.getElementById(\"fwd_hod_img\")) document.getElementById(\"fwd_hod_img\").style.visibility = \"visible\";\t\n                if(document.getElementById(\"inform_hod_img\")) document.getElementById(\"inform_hod_img\").style.visibility = \"visible\";\n\t\t\t\t\n\t\t\t\tif(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value=\"N\";\n\t\t\t\t\n\t\t}\n\t}\n}\n\n\nfunction frwdtoHodMedicalReport(){   \nif(document.forms[0].isMedicalReportRequest && document.forms[0].isMedicalReportRequest.value==\"true\"){\n\tif(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==true ){\n\t\t  if(document.forms[0].remarks){\n\t\t\t\tdocument.forms[0].remarks.value=\"\";\n\t\t\t\tdocument.forms[0].remarks.disabled = true;\n\t\t\t}\n\t\t\t\n\t\t\tif(document.forms[0].img_remarks && document.forms[0].status && document.forms[0].status.value==\"R\"){ \n\t\t\t\tdocument.getElementById(\"img_remarks\").style.visibility = \"hidden\"; \t\t\t\t\n\t\t    }\n\t\t\t\n\t\t\tif(document.forms[0].status_imag){ \n\t\t\t\tdocument.getElementById(\"status_imag\").style.visibility = \"hidden\"; \t\n\t\t\t\tdocument.forms[0].status.disabled = true;\n\t\t\t}\t\n\t\t\t// Added by Shaik Mujafar for ML-MMOH-CRF-0713 start\n\t\t\tif(document.forms[0].isRejectRequestApplicable.value==\"true\" && document.forms[0].reject_medical_rep_reason && document.forms[0].status.value==\"R\"){ \n\t\t\t\t\t\n\t\t\t\tdocument.forms[0].reject_medical_rep_reason.disabled = true;\n\t\t\t\tdocument.forms[0].reject_medical_rep_reason_img.style.visibility = \"hidden\";\n\t\t\t}\t\n\t\t\t// end\n\t\t\tif(document.forms[0].fwd_pract_desc){\n\t\t\t\tdocument.forms[0].fwd_pract_desc.value=\"\"; \t\t\t\t\t   \n\t\t\t\tdocument.forms[0].fwd_pract_desc.disabled = true;\n\t\t\t}\n\t\t\tif(document.forms[0].fwd_practitioner_id) document.forms[0].fwd_practitioner_id.value=\"\";\t\t\t\t\n\t\t\tif(document.forms[0].fwd_pract_id_search) document.forms[0].fwd_pract_id_search.disabled = true; \n\t\t\tif(document.forms[0].ack_hod_co_ord_desc){\n\t\t\t\tdocument.forms[0].ack_hod_co_ord_desc.value=\"\"; \t\t\t\t\t   \n\t\t\t\tdocument.forms[0].ack_hod_co_ord_desc.disabled = true;\n\t\t\t}\n\t\t\tif(document.forms[0].ack_hod_co_ord_id) document.forms[0].ack_hod_co_ord_id.value=\"\";\t\t\t\t\n\t\t\tif(document.forms[0].ack_hod_co_ord_search) document.forms[0].ack_hod_co_ord_search.disabled = true;\t\t\t\t\n\t\t\tif(document.getElementById(\"acknow_coordinator_img\"))document.getElementById(\"acknow_coordinator_img\").style.visibility = \"hidden\";\n\t\t\t\n\t\t\t\n\t\t\tif(document.forms[0].isMedicalTeamApplicable.value == \"true\")\n\t\t\t{ //added by mujafar for ML-MMOH-CRF-0716\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\"medical_team_val_ack\").options[0].selected=true;\n\t\t\t\t\tdocument.getElementById(\"medical_team_val_ack\").disabled = true;\n\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t\tif(document.forms[0].inform_to_pract_desc){\n\t\t\t\tdocument.forms[0].inform_to_pract_desc.value=\"\"; \t\t\t\t\t   \n\t\t\t\tdocument.forms[0].inform_to_pract_desc.disabled = true;\n\t\t\t}\n\t\t\tif(document.forms[0].inform_to_pract_id) document.forms[0].inform_to_pract_id.value=\"\";\t\t\t\t\n\t\t\tif(document.forms[0].inform_to_pract_search) document.forms[0].inform_to_pract_search.disabled = true;\t\n\t\t\tif(document.getElementById(\"informtopract_img\"))\n\t\t\tdocument.getElementById(\"informtopract_img\").style.visibility = \"hidden\";\t\n        \n\t\t    document.getElementById(\"cancelby_medical_report\").innerText = getLabel(\"Common.cancelledby.label\",\"Common\");\n\t\t\tdocument.getElementById(\"cancelby_med_rep_user\").innerText = document.forms[0].loginUser.value;\n\t\t\t//Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108\n\t\t\t//document.getElementById(\"cancelon_medical_report\").innerText = getLabel(\"Common.cancelled.label\",\"Common\")+\" \"+getLabel(\"Common.on.label\",\"Common\");\n\t\t\tdocument.getElementById(\"cancelon_medical_report\").innerText = getLabel(\"Common.CancelledOn.label\",\"Common\");\n\t\t\t//document.getElementById(\"cancelondate_medical_report\").innerText = document.forms[0].sysdate.value;\t\t\n\t\t\tdocument.getElementById(\"cancelondate_medical_report\").innerText = getCurrentDate(\"DMYHM\",\"en\");\n\t\t\t\n\t\t\tdocument.getElementById(\"cancel_medrep_reason\").innerText = getLabel(\"Common.ReasonforCancellation.label\",\"Common\");\n\t\t\tif(document.getElementById(\"cancel_medical_rep_reason\"))document.getElementById(\"cancel_medical_rep_reason\").style.visibility = \"visible\";\n\t\t\tdocument.getElementById(\"cancel_medical_rep_reason_img\").style.visibility = \"visible\";\n\t\t\t\n\t\t\tif(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value=\"Y\";\n\t\t\t\n\t\t\t\t\n\t\t}if(document.forms[0].cancel_medical_report && document.forms[0].cance";
    private final static byte[]  _wl_block9_3Bytes = _getBytes( _wl_block9_3 );

    private final static java.lang.String  _wl_block9_4 ="l_medical_report.checked==false){\n\t\t    if(document.forms[0].remarks) document.forms[0].remarks.disabled = false;\t\t\t\n\t\t\tif(document.forms[0].status)  document.forms[0].status.disabled = false;\n\t\t\t\n\t\t\tif(document.forms[0].status_imag){ \n\t\t\t\tdocument.getElementById(\"status_imag\").style.visibility = \"visible\"; \t\t\t\t\n\t\t\t}\t\n\t\t\tif(document.forms[0].status && document.forms[0].status.value==\"A\" || document.forms[0].status && document.forms[0].status.value==\"S\"){ // modified by mujafar for ML-MMOH-CRF-0718\n\t\t\tif(document.forms[0].fwd_pract_desc) document.forms[0].fwd_pract_desc.disabled = false;\n\t\t\tif(document.forms[0].fwd_practitioner_id) document.forms[0].fwd_practitioner_id.value=\"\";\t\t\t\t\n\t\t\tif(document.forms[0].fwd_pract_id_search) document.forms[0].fwd_pract_id_search.disabled = false; \n\t\t\tif(document.forms[0].ack_hod_co_ord_desc) document.forms[0].ack_hod_co_ord_desc.disabled = false;   \n\t\t\t\n\t\t\tif(document.forms[0].isMedicalTeamApplicable.value == \"true\")\n\t\t\t{ //added by mujafar for ML-MMOH-CRF-0716\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\"medical_team_val_ack\").options[0].selected=true;\n\t\t\t\t\tdocument.getElementById(\"medical_team_val_ack\").disabled = false;\n\t\t\t\t\n\t\t\t}\n\t\t\tif(document.forms[0].ack_hod_co_ord_id) document.forms[0].ack_hod_co_ord_id.value=\"\";\t\t\t\t\n\t\t\tif(document.forms[0].ack_hod_co_ord_search) document.forms[0].ack_hod_co_ord_search.disabled = false;\t\t\t\t\n\t\t\tif(document.getElementById(\"acknow_coordinator_img\"))document.getElementById(\"acknow_coordinator_img\").style.visibility = \"visible\";\t\t\t\t\n\t\t\tif(document.forms[0].inform_to_pract_desc) document.forms[0].inform_to_pract_desc.disabled = false; \t\t\t\t\t   \n\t\t\tif(document.forms[0].inform_to_pract_id) document.forms[0].inform_to_pract_id.value=\"\";\t\t\t\t\n\t\t\tif(document.forms[0].inform_to_pract_search) document.forms[0].inform_to_pract_search.disabled = false;\n\t\t\tif(document.getElementById(\"informtopract_img\"))\n\t\t\tdocument.getElementById(\"informtopract_img\").style.visibility = \"visible\";\n\t\t\tif(document.forms[0].status && document.forms[0].status.value==\"S\" && document.forms[0].isSelfStatusMRPApplicable.value == \"true\")\n\t\t\t{ // added by mujafar for ML-MMOH-CRF-0718 \n\t\t\tvar loginID=document.forms[0].loginUserID.value;\n\t\t\tif(loginID!=\"\")\n\t\t\tgetSelfPractitioner(loginID);\t\n\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t\tif(document.forms[0].img_remarks && document.forms[0].status && document.forms[0].status.value==\"R\"){ \n\t\t\t\tdocument.getElementById(\"img_remarks\").style.visibility = \"visible\"; \t\t\t\t\n\t\t    }\n\t\t\t// Added by Shaik Mujafar for ML-MMOH-CRF-0713 start\n\t\t\tif(document.forms[0].isRejectRequestApplicable.value==\"true\" && document.forms[0].reject_medical_rep_reason && document.forms[0].status.value==\"R\"){\n\t\t\t\t\t\n\t\t\t\tdocument.forms[0].reject_medical_rep_reason.disabled = false;\n\t\t\t\tdocument.forms[0].reject_medical_rep_reason_img.style.visibility = \"visible\";\n\t\t\t}\t\n\t\t\t// end\n\t\t\tdocument.getElementById(\"cancelby_medical_report\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cancelby_med_rep_user\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cancelon_medical_report\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cancelondate_medical_report\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cancel_medrep_reason\").innerText = \"\";\n\t\t\tif(document.getElementById(\"cancel_medical_rep_reason\"))document.getElementById(\"cancel_medical_rep_reason\").options[0].selected=true;\n\t\t\tdocument.getElementById(\"cancel_medical_rep_reason\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"cancel_medical_rep_reason_img\").style.visibility = \"hidden\";\n\n            if(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value=\"N\"; \t\t\t\n\t\t\t\n\t\t}\n\t}\n}\n//End this CRF ML-MMOH-CRF-0712 \n</script>\n</head>\n";
    private final static byte[]  _wl_block9_4Bytes = _getBytes( _wl_block9_4 );

    private final static java.lang.String  _wl_block10_0 ="\n\n<script>\nfunction setDate(Status)\n{\t\n\tvar isIncompReqCancelApplicable = document.forms[0].isIncompReqCancelApplicable.value;//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719\n\tvar isChckLstApplicable = document.forms[0].isChckLstApplicable.value;//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708\n\tvar isSpecialtyDefaultApp = document.forms[0].isSpecialtyDefaultApp.value;\n\tif(isSpecialtyDefaultApp == \"true\"){\n\t\tif(document.forms[0].dept_spl!=null){\n\t\t\tdocument.forms[0].dept_spl.disabled= false;\n\t\t\tdocument.forms[0].search_spl.disabled= false;\n\t\t\tdocument.getElementById(\"DeptImg\").style.visibility = \"visible\";\n\t\t\tdocument.forms[0].pract_desc.disabled= false;\n\t\t\tdocument.forms[0].pract_id_search.disabled= false;\n\t\t}\n\t\t\n\t}\n\tif(Status == \'1\')\n\t{ \n\t\tdocument.getElementById(\"collectImg\").style.visibility = \"Hidden\";\n\t\tdocument.forms[0].collect_date.value = \"\";\n\t\tdocument.forms[0].collect_date.disabled = true;\n\t\tdocument.getElementById(\"collect_img\").disabled = true;\n\t\t\n\n\t\t// below if-else block added by mujafar for ML-MMOH-CRF-0704\n\t\t\tif(document.forms[0].isMedicalReportDurationAppl.value == \"true\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"appln_col1\").innerHTML=getLabel(\"eMR.ApplicationCompletionDates.label\",\"MR\");\n\t\t\t\tdocument.getElementById(\"appln_col2\").innerHTML=\"<input type=\'text\' id =\'appl_comp_date\' name=\'appln_col_date\' id=\'appln_col_date\'  maxlength=16 size=16 onblur =\'\' onKeyPress=\'return(ChkDateNumberInput(this,event,2))\' value =\'\' style=\'visibility:hidden\' ><img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'application_date_img\' onClick=\'document.forms[0].appln_col_date.focus();return  showCalendar(\'appl_comp_date\',null,\'hh:mm\');\' style=\'visibility:hidden\' /><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'applCompImg\'   style=\'visibility:hidden\'></img>\";\n\t\t\t\tdocument.getElementById(\'appln_col1\').style.display = \"none\";\n\t\t        document.getElementById(\'appln_col2\').style.display = \"none\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"appln_col1\").innerText = \"\";\n\t\t\t\tdocument.getElementById(\"appln_col2\").innerText = \"\";\n\t\t\t}\n\t\t\n\t\t/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/\n\t\tif(isIncompReqCancelApplicable == \"true\"){\n\t\t\tdocument.getElementById(\"cncl_date_lbl\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cncl_date\").innerText = \"\";\n\t\t\t\n\t\t\tdocument.getElementById(\'hideRow\').style.display = \"none\";\n\t\t\tdocument.getElementById(\"cncl_reason_lbl\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cancel_reason\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"cancel_reason_img\").style.visibility = \"hidden\";\n\t\t}\n\t\t/*End*/\n\n\t\t/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/\n\t\tif(isChckLstApplicable == \"true\"){\n\t\t\tdocument.getElementById(\'hideFields\').style.display = \"none\";\n\t\t\tdocument.getElementById(\"appl_mode_lbl\").innerText = \"\";\n\t\t\tdocument.getElementById(\"application_mode\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"appl_mode_img\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"collec_mode_lbl\").innerText = \"\";\n\t\t\tdocument.getElementById(\"collection_mode\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"collec_mode_img\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"notifi_mode_lbl\").innerText = \"\";\n\t\t\tdocument.getElementById(\"notification_mode\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"notifi_mode_img\").style.visibility = \"hidden\";\n\t\t}\n\t\t/*ML-MMOH-CRF-0708 End*/\n\n\t}\n\telse if(Status == \'2\')\n\t{   \n\t\tdocument.getElementById(\"collectImg\").style.visibility = \"visible\";\n\t\t\n\t\t/*Modified by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/\n\t\tdocument.forms[0].collect_date.disabled = false;\n\t\tdocument.getElementById(\"collect_img\").disabled = false;\n\n\t\tdocument.getElementById(\"appln_col1\").innerText = getLabel(\"eMR.ApplicationCompletionDates.label\",\"MR\");\n\t\t\n\t\t/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/\n\t\tif(isIncompReqCancelApplicable == \"true\"){\n\t\t\tdocument.getElementById(\"cncl_date_lbl\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cncl_date\").innerText = \"\";\n\t\t\t\n\t\t\tdocument.getElementById(\'hideRow\').style.display = \"none\";\n\t\t\tdocument.getElementById(\"cncl_reason_lbl\").innerText = \"\";\n\t\t\tdocument.getElementById(\"cancel_reason\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"cancel_reason_img\").style.visibility = \"hidden\";\n\t\t}\n\t\t/*End*/\n\n\t\t/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/\n\t\tif(isChckLstApplicable == \"true\"){\n\t\t\tdocument.getElementById(\'hideFields\').style.display = \"block\";\n\t\t\tdocument.getElementById(\"appl_mode_lbl\").innerText = getLabel(\"Common.ApplicationMode.label\",\"Common\");\n\t\t\tdocument.getElementById(\"application_mode\").style.visibility = \"visible\";\n\t\t\tdocument.getElementById(\"appl_mode_img\").style.visibility = \"visible\";\n\t\t\tdocument.getElementById(\"collec_mode_lbl\").innerText = getLabel(\"Common.CollectionMode.label\",\"Common\");\n\t\t\tdocument.getElementById(\"collection_mode\").style.visibility = \"visible\";\n\t\t\tdocument.getElementById(\"collec_mode_img\").style.visibility = \"visible\";\n\t\t\tdocument.getElementById(\"notifi_mode_lbl\").innerText = getLabel(\"Common.NotificationMode.label\",\"Common\");\n\t\t\tdocument.getElementById(\"notification_mode\").style.visibility = \"visible\";\n\t\t\tdocument.getElementById(\"notifi_mode_img\").style.visibility = \"visible\";\n\t\t}\n\t\t/*ML-MMOH-CRF-0708 End*/\n\n\t\t// below if-else block added by mujafar for ML-MMOH-CRF-0704\n\t\tif(document.forms[0].isMedicalReportDurationAppl.value == \"true\")  \n\t\t{\n\t\tdocument.getElementById(\'appln_col1\').innerHTML= getLabel(\"eMR.ApplicationCompletionDates.label\",\"MR\");\n\t\t\n\t\t\tdocument.getElementById(\"appln_col2\").innerHTML=\"<input type=\'text\' id =\'appl_comp_date\' name=\'appln_col_date\' id=\'appln_col_date\'  maxlength=16 size=16 onblur =\\\"validate_date_from(this);chkCollectDate1(this); \\\" onKeyPress=\\\"return(ChkDateNumberInput(this,event,2))\\\" value =\'\' style=\'visibility:hidden\' ><img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'application_date_img\' onClick=\\\"document.forms[0].appln_col_date.focus();return  showCalendar(\'appl_comp_date\',null,\'hh:mm\');\\\" style=\'visibility:hidden\' /><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'applCompImg\'   style=\'visibility:hidden\'></img>\";\n\t\tdocument.getElementById(\'appln_col1\').style.display = \"block\";\n\t\tdocument.getElementById(\'appln_col2\').style.display = \"block\";\n\t\t\n\t\tdocument.getElementById(\'appl_comp_date\').style.visibility=\"visible\";\n\t\tdocument.getElementById(\'application_date_img\').style.visibility=\"visible\";   \n\t\tdocument.getElementById(\'applCompImg\').style.visibility=\"visible\";\n\t\tdocument.forms[0].appln_col_date.value = document.forms[0].SystemDate_display.value;\n\t\t\n\t\tdocument.forms[0].appl_comp_dat.value=document.forms[0].appln_col_date.value;\n\t\t\n\t\tvar ret_collect_date = chkCollectDate(document.forms[0].appln_col_date);\n\t\t\n\t\tif(ret_collect_date != \'Entered date is Holiday\')\n\t\tdocument.forms[0].collection_date.value = ret_collect_date;\n\t\telse\n\t\tdocument.forms[0].collection_date.value =\"\";\n\t\n\tif(document.forms[0].collection_date.value  != \'undefined\')\n\t\tdocument.forms[0].collect_date.value = document.forms[0].collection_date.value;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\"appln_col2\").innerText = convertDate(document.forms[0].sysdate.value,\'DMYHM\',\'en\',localeName);\n\t\t\t\n\t\t\tdocument.forms[0].collect_date.value = document.forms[0].collection_date.value;\n\t\t}\n\t\t\n\t}\n\telse\n\t{ \n\t\tdocument.getElementById(\"collectImg\").style.visibility = \"hidden\";\n\t\tdocument.forms[0].collect_date.value = \"\";\n\t\tdocument.forms[0].collect_date.disabled = true;\n\t\tdocument.getElementById(\"collect_img\").disabled = true;\n\t\t/*Added by Dharma on 19th Dec 2019 against ML-MMOH-CRF-1454 Start*/\n\t\tif(isSpecialtyDefaultApp == \"true\"){\n\t\t\tif(document.forms[0].dept_spl!=null){\n\t\t\t\tdocument.forms[0].dept_spl.disabled= true;\n\t\t\t\tdocument.forms[0].search_spl.disabled= true;\n\t\t\t\tdocument.getElementById(\"DeptImg\").style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].pract_desc.disabled= true;\n\t\t\t\t/*document.forms[0].pract_desc.value = \'\';\n\t\t\t\tdocument.forms[0].practitioner_id.value=\'\';*/\n\t\t\t\tdocument.forms[0].pract_id_search.disabled= true;\n\t\t\t}\n\t\t\t\n\t\t}\n\t\t/*Added by Dharma on 19th Dec 2019 against ML-MMOH-CRF-1454 End*/\n\t\t\n\t\t/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/\n\t\t\n\t\tif(isIncompReqCancelApplicable == \"true\"){ \n\t\t\tif(Status == \'3\'){  // below 4 lines modified by mujafar for ML-MMOH-CRF-0704\n\t\t\t\tdocument.getElementById(\"appln_col1\").innerHTML = getLabel(\"Common.cancelledby.label\",\"Common\");\n\t\t\t\tdocument.getElementById(\"appln_col2\").innerHTML = document.forms[0].loginUser.value;\n\t\t\t\tdocument.getElementById(\'appln_col1\').style.display = \"block\";\n\t\t        document.getElementById(\'appln_col2\').style.display = \"block\";\n\t\t\t\t//Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108\n\t\t\t\t//document.getElementById(\"cncl_date_lbl\").innerText = getLabel(\"Common.cancelled.label\",\"Common\")+\" \"+getLabel(\"Common.on.label\",\"Common\");\n\t\t\t\tdocument.getElementById(\"cncl_date_lbl\").innerText = getLabel(\"Common.CancelledOn.label\",\"Common\");\n\t\t\t\tdocument.getElementById(\"cncl_date\").innerText = convertDate(document.forms[0].sysdate.value,\'DMYHM\',\'en\',localeName);\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\'hideRow\').style.display = \"block\";\n\t\t\t\tdocument.getElementById(\"cncl_reason_lbl\").innerText = getLabel(\"Common.ReasonforCancellation.label\",\"Common\");\n\t\t\t\tdocument.getElementById(\"cancel_reason\").style.visibility = \"visible\";\n\t\t\t\tdocument.getElementById(\"cancel_reason_img\").style.visibility = \"visible\";\n\n\t\t\t\t/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/\n\t\t\t\tif(isChckLstApplicable == \"true\"){\n\t\t\t\t\tdocument.getElementById(\'hideFields\').style.display = \"none\";\n\t\t\t\t\tdocument.getElementById(\"appl_mode_lbl\").innerText = \"\";\n\t\t\t\t\tdocument.getElementById(\"application_mode\").style.visibility = \"hidden\";\n\t\t\t\t\tdocument.getElementById(\"appl_mode_img\").style.visibility = \"hidden\";\n\t\t\t\t\tdocument.getElementById(\"collec_mode_lbl\").innerText = \"\";\n\t\t\t\t\tdocument.getElementById(\"collection_mode\").style.visibility = \"hidden\";\n\t\t\t\t\tdocument.getElementById(\"collec_mode_img\").style.visibility = \"hidden\";\n\t\t\t\t\tdocument.getElementById(\"notifi_mode_lbl\").innerText = \"\";\n\t\t\t\t\tdocument.getElementById(\"notification_mode\").style.visibility = \"hidden\";\n\t\t\t\t\tdocument.getElementById(\"notifi_mode_img\").style.visibility = \"hidden\";\n\t\t\t\t}\n\t\t\t\t/*ML-MMOH-CRF-0708 End*/\n\n\t\t\t}else{\n\t\t\t\t// below if-else block added by mujafar for ML-MMOH-CRF-0704\n\t\t\t\tif(document.forms[0].isMedicalReportDurationAppl.value == \"true\")\n\t\t\t\t{\n\t\t\t\tdocument.getElementById(\"appln_col1\").innerHTML=getLabel(\"eMR.ApplicationCompletionDates.label\",\"MR\");\n\t\t\t\tdocument.getElementById(\"appln_col2\").innerHTML=\"<input type=\'text\' id =\'appl_comp_date\' na";
    private final static byte[]  _wl_block10_0Bytes = _getBytes( _wl_block10_0 );

    private final static java.lang.String  _wl_block10_1 ="me=\'appln_col_date\' id=\'appln_col_date\'  maxlength=16 size=16 onblur =\'\' onKeyPress=\'return(ChkDateNumberInput(this,event,2))\' value =\'\' style=\'visibility:hidden\' ><img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'application_date_img\' onClick=\'document.forms[0].appln_col_date.focus();return  showCalendar(\'document.forms[0].appl_comp_date\',null,\'hh:mm\');\' style=\'visibility:hidden\' /><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'applCompImg\'   style=\'visibility:hidden\'></img><input type=\'hidden\'  id=\'applcompdat\' name=\'appl_comp_dat\' id=\'appl_comp_dat\' size=15 maxlength=15 value=\'\'>\";\n\t\t\t\tdocument.getElementById(\'appln_col1\').style.display = \"none\";\n\t\t        document.getElementById(\'appln_col2\').style.display = \"none\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tdocument.getElementById(\"appln_col1\").innerText = \"\";\n\t\t\t\tdocument.getElementById(\"appln_col2\").innerText = \"\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\"cncl_date_lbl\").innerText = \"\";\n\t\t\t\tdocument.getElementById(\"cncl_date\").innerText = \"\";\n\n\t\t\t\tdocument.getElementById(\'hideRow\').style.display = \"none\";\n\t\t\t\tdocument.getElementById(\"cncl_reason_lbl\").innerText = \"\";\n\t\t\t\tdocument.getElementById(\"cancel_reason\").style.visibility = \"hidden\";\n\t\t\t\tdocument.getElementById(\"cancel_reason_img\").style.visibility = \"hidden\";\n\n\t\t\t\t/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/\n\t\t\t\tif(isChckLstApplicable == \"true\"){\n\t\t\t\t\tdocument.getElementById(\'hideFields\').style.display = \"none\";\n\t\t\t\t\tdocument.getElementById(\"appl_mode_lbl\").innerText = \"\";\n\t\t\t\t\tdocument.getElementById(\"application_mode\").style.visibility = \"hidden\";\n\t\t\t\t\tdocument.getElementById(\"appl_mode_img\").style.visibility = \"hidden\";\n\t\t\t\t\tdocument.getElementById(\"collec_mode_lbl\").innerText = \"\";\n\t\t\t\t\tdocument.getElementById(\"collection_mode\").style.visibility = \"hidden\";\n\t\t\t\t\tdocument.getElementById(\"collec_mode_img\").style.visibility = \"hidden\";\n\t\t\t\t\tdocument.getElementById(\"notifi_mode_lbl\").innerText = \"\";\n\t\t\t\t\tdocument.getElementById(\"notification_mode\").style.visibility = \"hidden\";\n\t\t\t\t\tdocument.getElementById(\"notifi_mode_img\").style.visibility = \"hidden\";\n\t\t\t\t}\n\t\t\t\t/*ML-MMOH-CRF-0708 End*/\n\t\t\t}\n\t\t}/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/\n\t\telse if(isChckLstApplicable == \"true\"){\n\t\t\tdocument.getElementById(\'hideFields\').style.display = \"none\";\n\t\t\tdocument.getElementById(\"appl_mode_lbl\").innerText = \"\";\n\t\t\tdocument.getElementById(\"application_mode\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"appl_mode_img\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"collec_mode_lbl\").innerText = \"\";\n\t\t\tdocument.getElementById(\"collection_mode\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"collec_mode_img\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"notifi_mode_lbl\").innerText = \"\";\n\t\t\tdocument.getElementById(\"notification_mode\").style.visibility = \"hidden\";\n\t\t\tdocument.getElementById(\"notifi_mode_img\").style.visibility = \"hidden\";\n\t\t}\n\t\t/*ML-MMOH-CRF-0708 End*/\n\t\telse{ \n\t\t\t// below if-else block added by mujafar for ML-MMOH-CRF-0704\n\t\t\tif(document.forms[0].isMedicalReportDurationAppl.value == \"true\")\n\t\t\t{\n\t\t\t\t\n\t\t\t\n\t\t\tdocument.getElementById(\"appln_col1\").innerHTML= getLabel(\"eMR.ApplicationCompletionDates.label\",\"MR\");\n\t\t\tdocument.getElementById(\"appln_col2\").innerHTML=\"<input type=\'text\' id =\'appl_comp_date\' name=\'appln_col_date\' id=\'appln_col_date\'  maxlength=16 size=16 onblur =\'\' onKeyPress=\'return(ChkDateNumberInput(this,event,2))\' value =\'\' style=\'visibility:hidden\' ><img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'application_date_img\' onClick=\'document.forms[0].appln_col_date.focus();return  showCalendar(\'appl_comp_date\',null,\'hh:mm\');\' style=\'visibility:hidden\' /><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'applCompImg\'   style=\'visibility:hidden\'></img><input type=\'hidden\'  id=\'applcompdat\' name=\'appl_comp_dat\' id=\'appl_comp_dat\' size=15 maxlength=15 value=\'";
    private final static byte[]  _wl_block10_1Bytes = _getBytes( _wl_block10_1 );

    private final static java.lang.String  _wl_block11 ="\'>\";\n\t\t\tdocument.getElementById(\'appln_col1\').style.display = \"none\";\n\t\t    document.getElementById(\'appln_col2\').style.display = \"none\";\n\t\t\t}\n\t\t\telse{\n\t\t\t\tdocument.getElementById(\"appln_col1\").innerText = \"\";\n\t\t\t\tdocument.getElementById(\"appln_col2\").innerText = \"\";\n\t\t\t}\n\t\t}\n\t\t/*End*/\n\t}\n}\n\n// Added by Sridhar on 7 AUG 2004\n// Function will check for empty values before calling up the common lookup func..\nfunction beforeGetAuthorised(target_id,target)\n{\n\tif(document.forms[0].Authorised_hid.value != document.forms[0].authorised_by.value)\n\t{\n\t\tif(document.forms[0].authorised_by.value != \"\")\n\t\t\t getAuthoriser(target_id,target);\n\t}\n}\n\nasync function getAuthoriser(target_id,target)\n{\n\tvar facility_id = document.forms[0].facility_id.value;\n\tvar title = getLabel(\"Common.authorizedby.label\",\"Common\");\n\tvar locale = document.forms[0].locale.value;\n\tvar argumentArray=new Array(8);\n \n\targumentArray[0] = \" select appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where LANGUAGE_ID =\'\"+locale+\"\' and EFF_STATUS like ? and APPL_USER_ID like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) \";\n\n\targumentArray[1]=new Array(\"EFF_STATUS\");\n\targumentArray[2]=new Array(\"E\");\n\targumentArray[3]=new Array(STRING,STRING);\n\targumentArray[4]=\"2,3\";\n\targumentArray[5]=target.value;\n\targumentArray[6]=CODE_DESC_LINK;\n\targumentArray[7]=CODE_DESC;\n\n\t\t\t\n\tvar retVal=await CommonLookup(title,argumentArray);\n\tvar ret1=unescape(retVal);\n\t var arr=ret1.split(\",\");\n\t\tif(arr[1]==undefined) \n\t\t{\n\t\t\tarr[0]=\"\";\t\n\t\t\tarr[1]=\"\";\t\n\t\t}\n\t\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\tdocument.forms[0].Authorised_hid.value\t= arr[0];\n\t\tdocument.forms[0].authorised_by.value\t= arr[1];\n\t\t/*document.forms[0].authorised_by.focus();\n\t\tdocument.forms[0].Authorised_hid.value\t= document.forms[0].Authorised_hid.value;*/\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].Authorised_hid.value\t= \"\";\t\t\n\t\tdocument.forms[0].authorised_by.value\t= \"\";\n\t}\n}\n\n\nasync function ShowEncounter()\n{\n\t/*var parem = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\talert(parem)*/\n\t\n\t\tvar encounterid=document.forms[0].encounterid.value;\n\t\t\t\n\t\t\tvar LastDet=document.forms[0].LastDet.value\n\t\t\t\tvar call_function=document.forms[0].call_function.value\n\t\n\tvar retVal\t\t= new String();\n\tvar dialogHeight= \"80vh\";\n\tvar dialogWidth\t= \"80vw\";\t\t\n\tvar dialogTop\t= \"72\";\n\tvar center\t\t= \"\";\n\tvar status\t\t= \"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=auto; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ; \n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\tretVal = await window.showModalDialog(\"../../eMR/jsp/vwMedRecEncounterDetails.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&PatientId=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&selitem=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&from=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&to=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&finalSelect=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&chkSelect=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&call_function=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&request_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",arguments,features);\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\n\t\t\n\t\tretVal =await  window.showModalDialog(\"../../eMR/jsp/MedRecRequestResult.jsp?";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&flag=true&request_id=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\",arguments,features);\n\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n}\n\n</script>\n<!--Onload Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708-->\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<body OnMouseDown=\'CodeArrest();\' onKeyDown=\'lockKey()\' onload=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<form name=\'MedicalRecordReqForm\' id=\'MedicalRecordReqForm\'  method=post target=\'messageFrame\'>  <!-- target added by Sangeetha for ML-MMOH-SCF-0669 --> \n\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t<tr>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td class=\'label\' width=\"25%\" >&nbsp;</td>\n\t\t\t<td class=querydata width=\"25%\" >&nbsp;</td>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t<td class=querydata width=\"25%\" >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<input type=hidden name=\"reg_no\" id=\"reg_no\" size=15 maxlength=15 readonly value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\t\t\t<td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<td class=\'querydata\' width=\"25%\" >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n</tr>\n\n<!-- Added by Arthi on 18-Jul-2022 for ML-MMOH-CRF-1906 -->\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n<tr>\n\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t<td class=querydata width=\"25%\" >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n</tr>\n<tr>\n\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t<td class=querydata colspan = \'3\' width=\"25%\" style=\'word-wrap:break-word;width:700px;\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td> \n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t <td class=querydata width=\"25%\" >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\n    <td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" </td>\n\t<td class=querydata width=\"25%\" >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="Y</td>\n</tr>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n<!-- End ML-MMOH-CRF-1906 -->\n\n</table>\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t\n</table>\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t<tr>\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<td  class=\'label\' width=\"25%\"  >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t<td  class=\'querydata\' width=\"25%\" >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<td class=\'label\' width=\"25%\" >&nbsp;</td>\n\t\t\t<td class=\'label\' width=\"25%\" >&nbsp;</td>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t<td  class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t<td class=\'label\' width=\"25%\" >&nbsp;</td>\n\t\t\t\t<td class=\'label\' width=\"25%\" >&nbsp;</td>\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t</tr>\n\t<tr>\n\t\t<td class=DEFAULTBLANKROW2PT colspan=\'3\' width=\"100%\" >&nbsp;</td>\n\t\t<td  class=label nowrap><a href=\"javascript:ShowEncounter();\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</a></td>\n\t</tr>\n</table>\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n<tr><td class=DEFAULTBLANKROW2PT colspan=\'4\' ></td></tr>\n<tr>\n\t<td colspan=\'5\' class=\"columnheader\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n</tr>\n<tr>\n\t<td width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t<td width=\"25%\" class=\"fields\"><select name=\"appl_type\" id=\"appl_type\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="  onchange=\"chkCollectDate2();\" >\n\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" -----\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"appl_type_mandatory\" \n\t\tname=\"appl_type_mandatory\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" ></img></td> \n\t\t<!--Modified for this CRF ML-MMOH-CRF-0712--> \n\t\t<td width=\"25%\"  class=\"label\"  nowrap>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t<td width=\"25%\"  class=\"fields\"  >\n\t\t<!-- Added By Dharma on 20th Dec 2019 against ML-MMOH-CRF-1454 Start -->\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t<!-- Added By Dharma on 20th Dec 2019 against ML-MMOH-CRF-1454 End -->\n\t\t<!--\tBelow Line is commented by Akhilesh because unnecessary function is called --> \n\t\t<!--<input type=\"text\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" id=\'applnDt\' name=\"appln_date\" maxlength=16 size=16 onblur=\"chkDateVal(this);CompareRegnDate(this,document.forms[0].sysdate);\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"> -->\n\t\t<input type=\"text\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" id=\'applnDt\' name=\"appln_date\" maxlength=16 size=16 onblur=\"CompareRegnDate(this,document.forms[0].sysdate);\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"><img id=\"ApplnImg\" src=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" onClick=\"document.forms[0].appln_date.focus();return showCalendar(\'applnDt\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'   id=\"appl_date_madndatory\" name=\"appl_date_madndatory\" ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" ></img></td>\n\t\t<!--Modified for this CRF ML-MMOH-CRF-0712--> \n</tr>\n\n<tr>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t<td class=\"fields\" ><input type=text name=\"appl_name\" id=\"appl_name\"   size=30 maxlength=80 ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="  value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" ><input type = \'hidden\' name = \'applname\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" /></td>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\n<td class=\'label\'>&nbsp;</td>\n\t<td class=\"fields\" >&nbsp;</td>\n\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\n\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t<!--Modified by Ashwini on 11-Oct-2019 for ML-MMOH-CRF-1359-->\n\t\n\t<td class=\"fields\">\n\t\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t<input type=text name=\"appl_refno\" id=\"appl_refno\" size=25 maxlength=30  ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" onKeyup=\"return ChangeUpperCase(this);\" onblur = \"ChangeUpperCase(this);\" />\n\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t<input type=text name=\"appl_refno\" id=\"appl_refno\" size=15 maxlength=15 ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" onKeyPress=\"return MedRecReqCheckForSpecChars(event);\" onblur = \"SpeCharCheck(this);\">\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t</td>\n\t<!-- Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 Start -->\n\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t<td class=\"fields\"  nowrap ><b>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</b></td>\n\t\t\n\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t<!-- Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 End -->\n</tr>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\n<tr>\n\t<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->\n\t<td class=\'label\' width=\"23%\" >";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\t<td class=\"fields\" width=\"27%\" >\n\t\t<select name=\"req_type\" id=\"req_type\" ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" style=\"width:150px;\" onchange=\"document.forms[0].requestor_desc.value=\'\';document.forms[0].Requestor_Code.value=\'\';EnDisRelation(this.value);\">\n\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" -----</option>\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t</select>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"requestorTypeImg\" style=\"visibility:visible\" ></img>\n\t</td>  \n\n\t<td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t<td class=\'fields\' width=\"10%\" ><input type=text name=\"requestor_desc\" id=\"requestor_desc\" size=20 maxlength=15 onblur=\"beforeLookupSearch();\" ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" ><input type=button class=button name=\'search_Requestor\' id=\'search_Requestor\' value=\'?\' onclick=\"LookupSearch()\" ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="><input type=hidden name=\"Requestor_desc_hid\" id=\"Requestor_desc_hid\" value=\'\'><input type=hidden name=\"Requestor_Code\" id=\"Requestor_Code\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"><input type=hidden name=\"requestor_validation\" id=\"requestor_validation\" value=\"\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"requestorImg\" style=\"visibility:hidden\" ></img></td>\n\t\n\t\n\t<td class=\'fields\' width=\"15%\" align=left><input type=text name=\"appl_name\" id=\"appl_name\"   size=20 maxlength=80 ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" /></td>\n\t\n\t\n\t</tr>\n\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n<tr>\n\t<!--Added By Ashwini on 21-Aug-2017 for\tML-MMOH-CRF-0708-->\n\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t<td  class=\'label\'>\n\t\t<!--Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108-->\n\t\t<!--";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="-->\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t</td>\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t<td  class=\'label\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t<td class=\"fields\">\n\t\t<select name=\"relationship_type\" id=\"relationship_type\"  onchange=\"populateApplName(this.value);enDisRequestor(this.value);popApplAddress(this.value)\" ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" onmousewheel=\'return false;\'>\n\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" -----</option>\n\t\t<option value=\'0\'>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</option>\n\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</option>\n\t\t<option value=\'2\'>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</option>\n\t\t<option value=\'3\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</option>\n\t\t<option value=\'4\'>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</option>\n\t\t</select>\n\t</td>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\n\t<td  class=\'label\'>";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t<td class=\"fields\"><select name=\'relationship\' id=\'relationship\' ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =">\n\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" -----</option>\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"relationImg\" style=\"visibility:hidden\" ></img></td>\n\t\n\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="&nbsp;</td>\n\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\'  name=\"contact2_nat_id_no\" id=\"contact2_nat_id_no\"  ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="  value = \"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" onkeypress=\'return allowValidNumber(this,event,2, 0);\'  maxlength=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' onblur=\"makeValidString(this);\"  size=\'20\'  ></td>\n\n\n\n\t\t ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\n</tr>\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\n          <tr>\n\t\t  <td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t\t   <td  class=\'fields\'  width=\'25%\'>&nbsp;</td>\n\t\t  <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</td>\n              <td  class=\'fields\'  >\n\t\t\t\t\t<select name=\'contact1_oth_alt_id_type\' id=\'contact1_oth_alt_id_type\' onChange=\'enableOtherAltIdText(this.value)\' ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="  > \n  \t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="---\n\t\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n                      <td class=\'fields\' >  <input type=\'text\' name=\'contact1_oth_alt_id_no\' id=\'contact1_oth_alt_id_no\' ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =" value=\'\' maxlength=\'20\' size=\'20\' onblur=\'makeValidString(this);\'   value = \"\">\n              </td>\n\t\t  </tr>\n\t\t  \n\t\t  ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n<tr>\n\t<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n\t<td class=\"fields\">\n\t\t<select name=\"req_type\" id=\"req_type\" ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =" onchange=\"document.forms[0].requestor_desc.value=\'\';document.forms[0].Requestor_Code.value=\'\';EnDisRelation(this.value);\">\n\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t</select>\n\t</td>  \n\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</td>\n\t<td class=\"fields\"><input type=text name=\"requestor_desc\" id=\"requestor_desc\" size=15 maxlength=15 onblur=\"beforeLookupSearch();\" ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="><input type=hidden name=\"Requestor_desc_hid\" id=\"Requestor_desc_hid\" value=\'\'><input type=hidden name=\"Requestor_Code\" id=\"Requestor_Code\" value=\"\"><input type=hidden name=\"requestor_validation\" id=\"requestor_validation\" value=\"\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"requestorImg\" style=\"visibility:hidden\" ></img></td>\n</tr>\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n<tr>\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\n\t<td class=\"fields\">\n\t\t<SELECT name=\"cons_letter\" id=\"cons_letter\" ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 =">\n\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</option>\n\t\t</SELECT>\n\t</td>\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</td>\n\t<td class=\"fields\" ><input type=text name=\"for_attn\" id=\"for_attn\" size=25 maxlength=50 ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" onblur=\"tab_click(\'requestor_details\')\"></td>\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n</tr>\n<tr>\n\t<td class=\"label\">&nbsp;</td>\n\t<td class=\"label\">&nbsp;</td>\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\t<!--Modified by Ashwini on 11-Oct-2019 for ML-MMOH-CRF-1359-->\n\t<td class=\"fields\"><input type=text name=\"appl_no\" id=\"appl_no\" size=15 maxlength=15 ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" onKeyPress=\"return MedRecReqCheckForSpecChars(event);\" onblur = \"SpeCharCheck(this);\"></td>\n</tr>\n\t<tr>\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start-->\n\t\t<td class=\"button\"><input type=\"button\" name=\"checkList\" id=\"checkList\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" class=\'button\' onclick=\"showChecklistDetails(\'Y\');\"></td>\n\t\t<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End-->\n\t\t\n\t\t<td class=\"button\" ><input type=\"button\" name=\"Dates\" id=\"Dates\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" class=\'button\' onclick=\"showDateDetails();\" ></td>\n\t\t<td class=\"button\" ><input type=\"button\" name=\"Charges\" id=\"Charges\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" class=\'button\' onclick=\"showChargeDetails();\" ></td>\n\t\t<td class=\"button\"><input type=\"button\" name=\"appl_addr\" id=\"appl_addr\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" class=\'button\' ";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="onclick=\"DisplayApplAddress(relationship_type.value);\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="onclick=\"DisplayAddress();\" ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" onblur=\"tab_click(\'requestor_details\')\"></td> \n\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t<td class=\"label\">&nbsp;</td>\n\t\t<td class=\"label\">&nbsp;</td>\n\t\t<td class=\"label\">&nbsp;</td>\n\t\t<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start-->\n\t\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t<td class=\"button\"><input type=\"button\" name=\"checkList\" id=\"checkList\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" class=\'button\' onclick=\"showChecklistDetails(\'N\');\"></td>\n\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End-->\n\t\t\n\t\t<!--Added By Ashwini on 21-Aug-2017 for\tML-MMOH-CRF-0708-->\n\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\n\t\t<td class=\"button\"><input type=\"button\" name=\"appl_addr\" id=\"appl_addr\"  ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="   value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =" onblur=\"tab_click(\'requestor_details\')\"></td> \n";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t</tr>\n</table>\n\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t\t<tr>\n\t\t\t<td class=\"columnheader\" colspan=\'4\'>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</td>\n\t\t</tr>\n\t\t\n\t\t<!--Added By Ashwini on 20-Jun-2022 for ML-MMOH-CRF-1905-->\n\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t<tr>\n\t\t\t<td width=\"25%\" class=\'label\'>     \n\t\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="&nbsp;\n\t\t\t</td> \n\t\t\t<td width=\'25%\' class=\'fields\' style=\'position:relative;\'>\n\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t<b>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</b>\n\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t<!--End ML-MMOH-CRF-1905-->\n\n\t\t<tr>\n\t\t\t<td  width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\"><select name=\"charges_appllicable\" id=\"charges_appllicable\" onchange=\"enableOtherDetails(this.name,this.value)\">\n\t\t\t\t<option value=\'Y\'>";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</option>\n\t\t\t\t<option value=\'N\' selected>";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</option>\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg1\"></img></td>\n\n\n\t\t\t<td width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\"><select name=\"additional_charges\" id=\"additional_charges\"  ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =" onchange=\"enableOtherDetails(this.name,this.value)\">\n\t\t\t\t<option value=\'Y\'>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</option>\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg1\" ></img></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</td>\n\t\t\t<td class=\"fields\"><input type=text name=\'amount\' id=\'amount\' size=15 maxlength=13  value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" disabled\n\t\t\tonBlur=\"CheckZeroVal(this);CheckNumberFormat(this);allowValidNumber(this,event,10,2);return fillDecimal(this,10,2);\" onKeyPress=\"ChkDateNumberInput(this,event,2); return allowValidNumber(this,event,10,2);\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg2\"></img></td>\n\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n\t\t\t<td class=\"fields\"><input type=text name=\'add_amount\'  id=\'add_amount\' size=15 maxlength=13 disabled value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" onKeyPress=\"ChkDateNumberInput(this,event,2); return allowValidNumber(this,event,10,2)\" onBlur=\"CheckZeroVal(this);CheckNumberFormat(this);allowValidNumber(this,event,10,2);return fillDecimal(this,10,2);\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg2\"></img></td>\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="</td>\n\t\t\t<td class=\"fields\"><input type=text name=recp_no id=recp_no size=15 maxlength=15 disabled value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" onblur=populateRecptDate(this.value,document.forms[0].recp_dat,document.getElementById(\"recp_dat_img\"))><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg3\"></img></td>\n\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\n\t\t\t<td class=\"fields\"><input type=text name=add_recp_no id=add_recp_no size=15 maxlength=15 disabled value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" onblur=populateRecptDate(this.value,document.forms[0].add_recp_dat,document.getElementById(\"add_recp_dat_img\"))><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"addtlChargeImg3\"></img></td>\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</td>\n\t\t\t<td class=\"fields\"><input type=text name=recp_dat id=recp_dat size=16 maxlength=16 onblur=\"recptDateValidations(this,document.forms[0].request_date,document.forms[0].sysdate)\" disabled value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"><img disabled src=\"../../eCommon/images/CommonCalendar.gif\" id=\"recp_dat_img\" onClick=\"document.forms[0].recp_dat.focus();return showCalendar(\'recp_dat\',null,\'hh:mm\');\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\"visibility:hidden\" id=\"chargeImg4\"></img></td>\n\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</td>\n\t\t\t<td class=\"fields\"><input type=text name=add_recp_dat id=add_recp_dat size=16 maxlength=16 onblur=\"recptDateValidations(this,document.forms[0].request_date,document.forms[0].sysdate)\" disabled value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\"><img disabled src=\"../../eCommon/images/CommonCalendar.gif\" id=\"add_recp_dat_img\" onClick=\"document.forms[0].add_recp_dat.focus();return showCalendar(\'add_recp_dat\',null,\'hh:mm\');\" disabled ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' style=\"visibility:hidden\" id=\"addtlChargeImg4\"></img></td>\n\t\t</tr>\n\n";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t<script>\n\t\t\t\t\n\t\t\t\tdocument.forms[0].charges_appllicable.value = \"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\";\n\t\t\t\tdocument.forms[0].additional_charges.value = \"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\";\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t<script>\n\t\t\tif(document.forms[0].charges_appllicable.value == \"Y\")\n\t\t\t{\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" == \"X\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].amount.disabled = false;\n\t\t\t\t\tdocument.forms[0].recp_no.disabled = false;\n\t\t\t\t\tdocument.forms[0].recp_dat.disabled = false;\n\t\t\t\t\tdocument.getElementById(\"recp_dat_img\").disabled = false;\n\t\t\t\t}\n\t\t\t\telse if(\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" == \"B\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].amount.disabled = false;\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n\n\t\t<script>\n\t\t\tif(document.forms[0].additional_charges.value == \"Y\")\n\t\t\t{\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" == \"X\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].add_amount.disabled = false;\n\t\t\t\t\tdocument.forms[0].add_recp_no.disabled = false;\n\t\t\t\t\tdocument.forms[0].add_recp_dat.disabled = false;\n\t\t\t\t\tdocument.getElementById(\"add_recp_dat_img\").disabled = false;\n\t\t\t\t}\n\t\t\t\telse if(\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" == \"B\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].add_amount.disabled = false;\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\t\t</table>\n";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t<input type=\'hidden\' name=\'charges_appllicable\' id=\'charges_appllicable\' value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'>\n";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t<tr><td class=\"columnheader\" colspan=4>&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t<tr><td class=\"columnheader\" colspan=5>\n\t<!--Modified By Dharma on Apr 9th 2020 against ML-MMOH-CRF-1314-->\n\t<!--";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="-->\n\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t</td></tr>\n\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t<tr><td class=\"columnheader\" colspan=4>&nbsp;</td></tr>\n\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\n\t<tr>\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="</td>\n\t\t<td  class=\"fields\" width=\"25%\">\n\t\t\t<SELECT name=\"rep_type\" id=\"rep_type\" ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 =" >\n\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 =" -----</option>\n\t";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t</SELECT><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"ReportTypeImg\" ";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="></img></td>\n\t\t\t<!-- Modified By Dharma on Nov 30th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start-->   \n\t\t\t<!--<td width=\"25%\" class=\'label\'>&nbsp;</td>\n\t\t\t<td width=\"25%\" class=\'label\'>&nbsp;</td>-->\n\t\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t<td width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="</td>\n\t\t\t\t<td width=\"25%\" class=\'label\'>\n\t\t\t\t\t<select name=\"status\" id=\"status\"  onchange=\"check_status();\" ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 =">\n\t\t\t\t\t\t<option value=\'A\' selected>";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</option>\n\t\t\t\t\t\t<option value=\'R\' >";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t<option value=\'S\' >";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t\t\t\t\n\t\t\t\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' name=\"status_imag\" id=\"status_imag\" ></img>\n\t\t\t\t\t<!--Added for this CRF ML-MMOH-CRF-0712-->\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n\t\t\t\t<td width=\"25%\" class=\'label\'>&nbsp;</td>\n\t\t\t\t<td width=\"25%\" class=\'label\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t<td width=\"7%\" class=\'label\'>&nbsp;</td>";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="</td>\n\t\t\t<td  class=\"fields\" width=\"25%\" ><input ";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 =" type=text name=\"dept_spl\" size=15 maxlength=15  value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" onblur=\"BeforeGetSpecialtyValue(this, \'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\');\" ><input type=hidden class=label name=\"Splcode\" id=\"Splcode\" value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\"><input ";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 =" type=button class=button name=\'search_spl\' value=\'?\' onclick=\"getSpecialtyValue(dept_spl, \'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\')\" ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"DeptImg\"   style=\"visibility:hidden\"></img></td>\n\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t\t<!-- Modified By Dharma on Nov 30th 2015 against ML-MMOH-CRF-0391 [IN:057157] End--> \n\t\t</tr>\n\t\t<!--Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708-->\n\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</td>\n\t\t\t\t<td class=\'querydata\' width=\"25%\" > \n\t\t\t\t\t<!--<select name=\"applic_mode\" id=\"applic_mode\" ";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =">-->\n\t\t\t\t\t<select name=\"applic_mode\" id=\"applic_mode\" disabled>\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 =" -----</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<!--";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="-->\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="</td>\n\t\t\t\t<td class=\'querydata\' width=\"25%\" >\n\t\t\t\t\t<!--<select name=\"collectn_mode\" id=\"collectn_mode\" ";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 =">-->\n\t\t\t\t\t<select name=\"collectn_mode\" id=\"collectn_mode\" disabled>\n\t\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<!--\n\t\t\t\t\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\n\t\t\t\t\t-->\n\t\t\t\t</td>\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\'label\'  width=\"25%\" >";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</td>\n\t\t\t<td class=\'querydata\'>\n\t\t\t\t<!--<select name=\"notific_mode\" id=\"notific_mode\" ";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 =">-->\n\t\t\t\t<select name=\"notific_mode\" id=\"notific_mode\" disabled>\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 =" -----</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t\t</select>\n\t\t\t\t<!--\n\t\t\t\t";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="-->\n\t\t\t</td>\n\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n\t\t<!--ML-MMOH-CRF-0708 End-->\n\t\t\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="</td>\n\t\t\t<td  class=\"fields\"><input ";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\')\" ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"DeptImg\"   style=\"visibility:hidden\"></img></td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="&nbsp;&nbsp;&nbsp;</td><td width=\"25%\" colspan=\"2\" class=\"fields\"><input type=\'text\'  id=\'fwd_hod_desc\' name=\'fwd_hod_desc\' id=\'fwd_hod_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeFwdGetFwdHod();\' value=\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\' ><input type=\'hidden\' name=\'fwd_hod_id\' id=\'fwd_hod_id\' value=\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\'><input type=\'button\' id = \'fwd_hod_id_search\' name=\'fwd_hod_id_search\' id=\'fwd_hod_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' >\n\t\t";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\t\n\t\t<select name=\"medical_team_val\" id=\"medical_team_val\" id=\"medical_team_val\" onchange=\"mrteam_change()\">\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 =" -----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\t\t\t\t</select>\n\t\t\n\t\t";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\t\n\t\t\t\n\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' id=\"fwd_hod_img\" name=\"fwd_hod_img\"></img></td>\t\n\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="&nbsp;&nbsp;</td><td nowrap class=\'querydata\' id=\'forward1\' width=\'25%\' >&nbsp;";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="<input type=\'hidden\' name=\'forwarded_hod_cord_date\' id=\'forwarded_hod_cord_date\' value=\'";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\'></td>\n\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="&nbsp;&nbsp;&nbsp;</td><td width=\"25%\" colspan=\"2\"  class=\"fields\"><input type=\'text\' id=\'inform_hod_desc\'  name=\'inform_hod_desc\' id=\'inform_hod_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeInformGetPractitioner();\' value=\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\' ><input type=\'hidden\' name=\'inform_hod_practitioner_id\' id=\'inform_hod_practitioner_id\' value=\'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\'><input type=\'button\' id=\'inform_hod_pract_id_search\' name=\'inform_hod_pract_id_search\' id=\'inform_hod_pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' >\n\t\t\t";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\t\n\t\t\t<select name=\"medical_team_val1\" id=\"medical_team_val1\" id=\"medical_team_val1\" onchange=\"mrteam_change()\">\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n\t\t\t\t</select>\n\t\t\t";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\n\t\t\t\n\t\t\t</td>\n\t\t\t\n\t\t<td align=\'right\' class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="&nbsp;&nbsp;</td>\n\t\t\t<td class=\'QueryData\'  colspan=\'8\' align=\'left\' width=\'25%\'>";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="&nbsp;</td>\n\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\t\t\n\t\t\t\t\t\n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="&nbsp;&nbsp;&nbsp;</td><td width=\"35%\" class=\"fields\"><input type=\'text\'  name=\'fwd_hod_desc\' id=\'fwd_hod_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeFwdGetFwdHod();\' value=\'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\' disabled><input type=\'hidden\' name=\'fwd_hod_id\' id=\'fwd_hod_id\' value=\'";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\'><input type=\'button\' name=\'fwd_hod_id_search\' id=\'fwd_hod_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' disabled >\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\t\n\t\t<select name=\"medical_team_val\" id=\"medical_team_val\" id=\"medical_team_val\"   ";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 =" onchange=\"mrteam_change()\">\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\t\n\t\t\t\t\n\t\t\t\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\n\t\t\n\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="&nbsp;&nbsp;&nbsp;</td><td width=\"25%\" class=\"fields\"><input type=\'text\'  name=\'inform_hod_desc2\' id=\'inform_hod_desc2\' ";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 =" size=\'30\' maxlength=\'30\' onblur=\'BeforeInformGetPractitioner();\' value=\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\'   ><input type=\'hidden\' name=\'inform_hod_practitioner_id2\' id=\'inform_hod_practitioner_id2\' value=\'";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\'><input type=\'button\' name=\'inform_hod_pract_id_search2\' id=\'inform_hod_pract_id_search2\' ";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 =" value=\'?\' class=\'button\'  onClick=\'getPractID(this);\' >\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\t\n\t\t<select name=\"medical_team_val2\" id=\"medical_team_val2\" id=\"medical_team_val2\"  ";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="   onchange=\"mrteam_change()\">\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\t\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\n\t\t<td align=\'right\' class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\n\t\t\t</tr>\n<!-- -->\n\n";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\n\t\t<tr>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="</td>\n\t\t\t<td class=\"fields\" colspan=3 ><textarea name=\'MedicalMembers\' rows=2 cols=\'60\' onblur= \"makeValidString(this);chklim(this,200)\" value=\"\" ></textarea></td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\n\t\t\n\t</table>\n\n\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'4\'>\n\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\n\t\n\t\n\t\n\t";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\n\t<tr>\n\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t<td class=\"fields\" width=\"20%\"><input type=\"text\" name=\"disp_col_date\" id=\"disp_col_date\" maxlength=16 size=16 value =\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\" disabled ><img src=\"../../eCommon/images/CommonCalendar.gif\" disabled></td>\n";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\n\t\t<td class=\"label\" width=\"20%\">";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="</td>\n\t\t<TD class=\'QueryData\' width=\"30%\">";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="</td>\n";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\n\t\t<td class=\"label\" width=\"25%\" >&nbsp;</td>\n\t\t<td class=\'label\' width=\"25%\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\n\t</tr>\n\t";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\n\n<tr>\n\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="</td>\n\t<td colspan=\"\" class=\"fields\" width=\"25%\" ><textarea name=\'remarks\' rows=2 cols=\'40\' colspan=\'2\' ";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="  onblur=\"makeValidString(this);chklim(this,200);tab_click(\'report_details\');\"  >";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="</textarea>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' id=\"img_remarks\"   style=\"visibility:hidden\"></img></td>\n\t<td class=\"label\" width=\"25%\" >&nbsp;</td>\n\t<td class=\"label\" width=\"25%\" >&nbsp;</td>\n\t</tr>\n\n\n\n\n\n";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\n\t<tr><td class=\"columnheader\" colspan=5 width=\'100%\' >\n\t";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\t \n\t\t\n\t\t";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\n\t\t ";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\n\t</td></tr>\n\n\t";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="  <tr>\n\t\t\t\t<td width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="</td>\n\t\t\t\t<td width=\"25%\" class=\'fields\'>\n\t\t\t\t";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\n\t\t\t\t\t<select name=\"status\" id=\"status\"  onchange=\"check_status();\" ";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="</option>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\n\t\t\t\t<select name=\"status\" id=\"status\"  onchange=\"check_status1();\" ";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\n\t\t\t\t\t\t\n\t\t\t\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' name=\"status_imag\" id=\"status_imag\" ></img>\n\t\t\t\t\t<!--Added for this CRF ML-MMOH-CRF-0712-->\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\n\t\t\t\t<td class=\'label\' id=\"collectImg5\" width=\'23%\'  ><span id=\"acc\" >";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="</span><span id=\"rej\" Style=\"display:none;\">";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="</span>&nbsp; </td>\n\t\t\t\t<td nowrap class=\'querydata\'   id=\"collectImg6\"   width=\'25%\' >&nbsp;";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="</td><input type=\'hidden\' name=\'accpt_rejct_date\' id=\'accpt_rejct_date\' value=\'";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\'> \n\t\t\t\t";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\n\t\t\t\t<td class=\"label\" width=\"25%\" >&nbsp;</td>\n\t\t\t\t<td class=\'fields\' width=\"25%\" >&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\n\t\t\t<tr>\n\t\t\t<td  class=\'label\' id=\"accept1\"  width=\"25%\">\n\t\t\t\t<span id=\"asnpract\" >";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="</span><span id=\"reject_reason_1\" Style=\"display:none;\" >";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="</span>\n\t\t\t</td>\n\t\t\t<td class=\"fields\" id=\"accept2\"  width=\"25%\" >\t\t\t\n\t\t\t\t<input type=\'text\' name=\'fwd_pract_desc\' id=\'fwd_pract_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeFwdGetPractitioner();\' value=\"\" ><input type=\'hidden\' name=\'fwd_practitioner_id\' id=\'fwd_practitioner_id\' value=\"\"><input type=\'button\' name=\'fwd_pract_id_search\' id=\'fwd_pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' >\n\t\t\t</td>\n\t\t\t\n\t\t\t\t<td nowrap class=\'querydata\' width=\'25%\' name=\"reject_medrep_reason_desc\" id=\"reject_medrep_reason_desc\"  style=\"display:none;\" >\n\t\t\t<select name=\"reject_medical_rep_reason\" id=\"reject_medical_rep_reason\" style=\"visibility:hidden;width:150px;\" > <!-- added by mujafar for ML-MMOH-CRF-0716 -->\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"  id=\'reject_medical_rep_reason_img\' align=\'center\'></img>\n\t\t\t</td>\n\t\t\t\n\t\t\t\n\t\t\t<td width=\'25%\' align=\'center\' class=\'label\' width=\'25%\' id=\"reject_by_1\" style=\"display:none;\">\n\t\t\t\t";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\n\t\t\t</td> <!-- label changed for ML-MMOH-CRF-0713 -->\n\t\t\t<td width=\'25%\'  class=\'QueryData\'  colspan=\'8\' align=\'left\' id=\"reject_by_2\" style=\"display:none;\">\n\t\t\t\t";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\n\t\t\t</td> \n\t\t\t\n\t\t\t<td class=\'label\' id=\"practImg1\" width=\'23%\'  >\n\t\t\t<span id=\"pracdate\" Style=\"display:none;\" >";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="</span>\n\t\t\t</td>\n\t\t\t<td nowrap class=\'querydata\'   id=\"practImg2\" Style=\"display:none;\"   width=\'25%\' >\n\t\t\t\t<span   id=\'pract_ass_date\' name=\'pract_ass_date\'  readonly  ></span>\n\t\t\t</td>\n\t\t\t<input type=\'hidden\' name=\'pract_assign_date\' id=\'pract_assign_date\' value=\'\'  >\n\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\n\t\t   \n\t\t   <tr>    \n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="&nbsp;&nbsp;&nbsp;</td><td width=\"25%\" class=\"fields\"><input type=\'text\' ";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="  name=\'ack_hod_co_ord_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeGetAckHOD();\' value=\'";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\'  /><input type=\'hidden\' name=\'ack_hod_co_ord_id\' id=\'ack_hod_co_ord_id\' value=\'";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\'><input type=\'button\' name=\"ack_hod_co_ord_search\" id=\"ack_hod_co_ord_search\" value=\'?\' ";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 =" class=\'button\' onClick=\'getPractID(this);\'  > <!-- added by mujafar for ML-MMOH-CRF-0716 -->\n\t\t\t\t";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\n\t\t\t\t</td>\n\t\t\t\t\n\t\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="&nbsp;&nbsp;&nbsp;</td><td width=\"25%\" class=\"fields\">&nbsp;<input type=\'text\'  name=\'inform_to_pract_desc\' id=\'inform_to_pract_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeInformToPract();\' value=\'";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\' ><input type=\'hidden\' name=\'inform_to_pract_id\' id=\'inform_to_pract_id\' value=\'";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\'><input type=\'button\' name=\'inform_to_pract_search\' id=\'inform_to_pract_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' >&nbsp;<!-- <img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' id=\"informtopract_img\" name=\"informtopract_img\"></img> --></td>\t\t\t\n\t\t\t\t\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\n\t\t\t\n";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\n\t<tr>\t\n\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="</td>\n\t<td colspan=\"\" class=\"fields\" width=\"25%\" ><textarea name=\'remarks_hod\' rows=2 cols=\'40\' ";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="</textarea></td>\n\t\n\t</tr>\n";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\n\t<tr>\n\t<td class=\'label\'  width=\"25%\" >";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="</td>\n\t<td colspan=\"3\" class=\"fields\"  ><textarea name=\'remarks\' rows=2 cols=\'60\'  onblur=\"makeValidString(this);chklim(this,200);tab_click(\'report_details\');\"  >";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="</textarea>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' id=\"img_remarks\"   style=\"visibility:hidden\"></img></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\n\t\t\n\t\t\n\t";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\n\n\t\n     \n\t \n\t";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\n\t\t<!--Maheshwaran K added for the ML-MMOH-CRF-0391 starts-->\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'4\'>\n\t\t\n\t\t\t<tr>  \n\t\t\t";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="&nbsp;&nbsp;&nbsp;</td><td width=\"25%\" colspan=\"2\" class=\"fields\">&nbsp;<input type=\'text\'  id=\'fwd_hod_desc\' name=\'fwd_hod_desc\' id=\'fwd_hod_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeFwdGetFwdHod();\' value=\'";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\'><input type=\'button\' id = \'fwd_hod_id_search\' name=\'fwd_hod_id_search\' id=\'fwd_hod_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' >\n\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' id=\"fwd_hod_img\" name=\"fwd_hod_img\"></img></td> <!--Modified for this CRF ML-MMOH-CRF-0712-->\n\t\t\t<td width=\'30%\' colspan=\'6\'>&nbsp;</td>\n\t\t\t\t<td width=\'20%\' colspan=\'6\'>&nbsp;</td>\t\n\t        </tr>\n\n\t\t    <tr>\n\t\t\t<td class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="&nbsp;&nbsp;</td><td   class=\"fields\" colspan=\"3\" width=\'57%\'>&nbsp;<textarea   name=\'reqd_docs\'  id=\'reqd_docs\' rows=2 cols=\'60\' colspan=\"3\" onblur=\"makeValidString(this);chklim(this,100);tab_click(\'report_details\');\"  disabled></textarea></td>\n\t\t\t\t<td width=\'20%\' colspan=\'8\'>&nbsp;</td>\n\t\t\t\t\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="&nbsp;&nbsp;&nbsp;</td><td width=\"25%\" colspan=\"2\"  class=\"fields\">&nbsp;<input type=\'text\' id=\'inform_hod_desc\'  name=\'inform_hod_desc\' id=\'inform_hod_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeInformGetPractitioner();\' value=\'";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\'><input type=\'button\' id=\'inform_hod_pract_id_search\' name=\'inform_hod_pract_id_search\' id=\'inform_hod_pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' >\n\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' name=\"inform_hod_img\" id=\"inform_hod_img\"></img></td> <!--Modified for this CRF ML-MMOH-CRF-0712 -->\n\t\t\t<td width=\'30%\' colspan=\'6\'>&nbsp;</td>\n\t\t\t\t<td width=\'20%\' colspan=\'6\'>&nbsp;</td>\t\n\t\t\t\n\t\t\t\t\n           </tr>\n\n\t\t <tr>  \n\t\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\'></td>\n\t\t\t<td align=\'right\' class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="&nbsp;</td>\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td class=\'label\' id=\"collectImg5\" width=\'23%\'  >\n\t\t\t\t<span id=\"acc\" >";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="</span>\n\t\t\t\t<span id=\"rej\" Style=\"display:none;\">";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\n\t\t\t\t</span>&nbsp;";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 =" \n\t\t\t\t</td>\n\t\t\t\t<td nowrap class=\'querydata\'   id=\"collectImg6\"   width=\'25%\' >&nbsp;";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\'> \n\t\t\t\t<td id=\"collectImg7\" width=\'23%\' style=\"display:none;\" >&nbsp;</td>\n\t\t\t\t<td id=\"collectImg8\" width=\'25%\' style=\"display:none;\" >&nbsp;</td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\n\n\t\n\t\t\t\n  <!--Below line added for this CRF ML-MMOH-CRF-0712-->\n\t";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\n\t<tr>  \n\t\t\t<td class=\"label\" width=\"25%\" >\n\t\t\t<!--Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108-->\n\t\t\t<!--";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="&nbsp;";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="&nbsp;&nbsp;&nbsp;-->\n\t\t\t";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="</td>\n\t\t\t<td nowrap class=\'querydata\' width=\'25%\' >&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<input type=\'checkbox\' name=\"cancel_medical_report\" id=\"cancel_medical_report\" id=\"cancel_medical_report\" onclick=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="cancelMedicalReport();";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="medicalReport();";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\"></td>\n\t\t\t<td align=\'right\' class=\'label\' width=\'25%\'  id=\"cancelby_medical_report\">&nbsp;&nbsp;</td>\n\t\t\t<td class=\'QueryData\'  colspan=\'8\' align=\'left\' width=\'20%\' id=\"cancelby_med_rep_user\" style=\'word-wrap: break-word;width:275px\'>&nbsp;</td>\t\t\t\n\t\t</tr>\n        <tr>  \n\t\t\t<td class=\"label\" width=\"25%\" name=\"cancel_medrep_reason\" id=\"cancel_medrep_reason\" >&nbsp;&nbsp;</td>\n\t\t\t<td nowrap class=\'querydata\' width=\'25%\' name=\"cancel_medrep_reason_desc\" id=\"cancel_medrep_reason_desc\" >\n\t\t\t<select name=\"cancel_medical_rep_reason\" id=\"cancel_medical_rep_reason\" style=\"visibility:hidden\">\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"  id=\'cancel_medical_rep_reason_img\' align=\'center\'></img>\n\t\t\t</td>\n\t\t\t<td align=\'right\' class=\'label\' width=\'25%\' name=\"cancelon_medical_report\" id=\"cancelon_medical_report\">&nbsp;&nbsp;</td>\n\t\t\t<td class=\'QueryData\'  colspan=\'8\' align=\'left\' width=\'20%\' name=\"cancelondate_medical_report\" id=\"cancelondate_medical_report\">&nbsp;</td>\t\t\n\t</tr>\t\t\t\n\t";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\n\n</table>\n\n\t\t";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\n\t ";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\n\t\t\t<tr>    \n\t\t\t\n\t\t\t\t<td  class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="</td>\n\t\t\t\t<td class=\"fields\" width=\"25%\"><input type=\'text\' name=\'fwd_pract_desc\' id=\'fwd_pract_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeFwdGetPractitioner();\' value=\"\" ><input type=\'hidden\' name=\'fwd_practitioner_id\' id=\'fwd_practitioner_id\' value=\"\"><input type=\'button\' name=\'fwd_pract_id_search\' id=\'fwd_pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' ></td>\n\t\t\t\t<td width=\'30%\' colspan=\'6\'>&nbsp;</td>\n\t\t\t\t<td width=\'20%\' colspan=\'6\'>&nbsp;</td>\t\t\t\t\t\t\n           </tr>\n\t\t\t<tr>  \n\t\t\t\t\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="&nbsp;&nbsp;&nbsp;</td><td width=\"35%\" class=\"fields\">&nbsp;<input type=\'text\'  name=\'fwd_hod_desc\' id=\'fwd_hod_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeFwdGetFwdHod();\' value=\'";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\'><input type=\'button\' name=\'fwd_hod_id_search\' id=\'fwd_hod_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' disabled >\n\t\t\t\t</td>\n           </tr>\n\t\t\t<!--Below line alignment for RequestedPractitioner column-->\n\t\t\t<tr>    \n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="&nbsp;&nbsp;&nbsp;</td><td width=\"25%\" class=\"fields\">&nbsp;<input type=\'text\'  name=\'inform_hod_desc\' id=\'inform_hod_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeInformGetPractitioner();\' value=\'";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\' disabled ><input type=\'hidden\' name=\'inform_hod_practitioner_id\' id=\'inform_hod_practitioner_id\' value=\'";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\'><input type=\'button\' name=\'inform_hod_pract_id_search\' id=\'inform_hod_pract_id_search\' value=\'?\' class=\'button\' disabled onClick=\'getPractID(this);\' >\n\t\t\t\t</td>\n\t\t\t\t<td width=\'25%\' align=\'center\' class=\'label\' >";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="</td>\n\t\t\t\t<td width=\'25%\'  class=\'QueryData\'  colspan=\'8\' align=\'left\'><input type=\'text\' name=\'pract_desc\' id=\'pract_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeGetPractitioner();\' value=\"";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\" disabled><input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\"><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' width=\'25%\'  value=\'?\' class=\'button\' onClick=\'getPractID(this);\' disabled></td>\t\t\t\t\t\t\n           </tr>\n\t\t   ";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\n\t\t   <tr>    \n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="&nbsp;&nbsp;&nbsp;</td><td width=\"25%\" class=\"fields\">&nbsp;<input type=\'text\' ";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 =" class=\'button\' onClick=\'getPractID(this);\'  > <!-- added by mujafar for ML-MMOH-CRF-0716 -->\n\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' id=\"acknow_coordinator_img\" name=\"acknow_coordinator_img\"></img></td>\n\t\t\t\t<!-- commented and below code added by mujafar for ML-MMOH-CRF-0713 -->\n\t\t\t\t<!--<td width=\'30%\' colspan=\'6\'>&nbsp;</td>\n\t\t\t\t<td width=\'20%\' colspan=\'6\'>&nbsp;</td>   -->\n\t\t\t\n           </tr>\n\t\n\t\t   <tr> \n\t\t\t\t\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\'><input type=\'button\' name=\'inform_to_pract_search\' id=\'inform_to_pract_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\' id=\"informtopract_img\" name=\"informtopract_img\"></img></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\n\t\t   </tr>\n\t\t   <tr>\n\t\t\t\t<td class=\'label\' id=\"collectImg5\" width=\'23%\'  >\n\t\t\t\t<span id=\"acc\" >";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\'> \n\t\t\t\t<td id=\"collectImg7\" width=\'23%\' style=\"display:none;\" >&nbsp;</td>\n\t\t\t\t<td id=\"collectImg8\" width=\'25%\' style=\"display:none;\" >&nbsp;</td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\n\t\t\t\t\t<tr>\n\t\t\t\t<td width=\'25%\' align=\'center\' class=\'label\' width=\'25%\' id=\"reject_on_1\" style=\"display:none;\" >";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="<input type=\'hidden\' name=\'accpt_rejct_date1\' id=\'accpt_rejct_date1\' value=\'";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\'></td> <!-- label changed for ML-MMOH-CRF-0713 -->\n\t\t\t\t<td width=\'25%\'  class=\'QueryData\'  colspan=\'8\' align=\'left\' id=\"reject_on_2\" style=\"display:none;\">";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\n\t\t\t<!--Below line added for this CRF ML-MMOH-CRF-0712-->\n\n\t\n\t\n<!--End this CRF ML-MMOH-CRF-0712-->\n\t\t\n\t";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\n</table>\n\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="</td>\n\t\t\t<td class=\"fields\"><select name=\"appl_status\" id=\"appl_status\" onchange=\"setDate(this.value)\">\n\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 =" -----</option>\n\t\t\t<option value=\'2\'>";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="</option>\n\t\t\t<option value=\'1\' ";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 =">";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="</option>\n\t\t\t<option value=\'3\'";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="</option>\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' id=\'appln_status_Img\' align=\'center\'></img></td>\n\t\t\t<td width=\"25%\" class=\'label\' id=\'appln_col1\' ></td>\n\t\t\t<!-- below if-else block added by mujafar for ML-MMOH-CRF-0704 -->\n\t\t\t";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\n\t\t\t<td width=\"25%\" class=\'querydata\' id=\'appln_col2\'><input type=\"text\" id =\'appl_comp_date\' name=\'appln_col_date\' id=\'appln_col_date\'  maxlength=16 size=16 onblur =\"\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" value =\"\" style=\"visibility:hidden\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  id=\'application_date_img\' onClick=\"document.forms[0].appln_col_date.focus();return  showCalendar(\'appl_comp_date\',null,\'hh:mm\');\" style=\"visibility:hidden\" /><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"applCompImg\"   style=\"visibility:hidden\"></img></td> \n\t\t\t";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\n\t\t\t<td width=\"25%\" class=\'querydata\' id=\'appln_col2\' ></td>\n\t\t\t";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\n\t\t\t<input type=hidden  id=\'applcompdat\' name=\"appl_comp_dat\" id=\"appl_comp_dat\" size=15 maxlength=15 value=\'";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\'>\n\t\t</tr>\n";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\t<input type=\"hidden\" name=\"collection_date\" id=\"collection_date\" value=\"";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\">\t\n\t\t<tr>\n\t\t\t<td class=\"label\"  nowrap width=\"25%\">";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="</td>\n\t\t\t<td class=\"fields\">\n\t\t\t<!-- Below code is commented by Akhilesh because unnecessary function is calling -->\n\t\t\t<!--<input type=\"text\" id=\'collectDt\' name=\"collect_date\" id=\"collect_date\" disabled maxlength=16 size=16 onblur =\"chkDateVal(this);CompareSysDate(this,document.forms[0].sysdate);\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" value =\"\"> --> \n\t\t\t<!--onblur modified by mujafar for  ML-MMOH-CRF-0704 -->\n\t\t\t<input type=\"text\" id=\'collectDt\' name=\"collect_date\" id=\"collect_date\" disabled maxlength=16 size=16 onblur =\"if(\'";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\'){validate_date_from(this);compare_from(appln_col_date,this);}CompareSysDate(this,document.forms[0].sysdate);isHoliday(this);\" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" value =\"\"><img src=\"../../eCommon/images/CommonCalendar.gif\" disabled id=\'collect_img\' onClick=\"document.forms[0].collect_date.focus();return  showCalendar(\'collectDt\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"collectImg\"   style=\"visibility:hidden\"></img></td>\n\t\t\t<!--<td class=\"label\">&nbsp;</td>\n\t\t\t<td class=\"label\">&nbsp;</td>-->\n\t\t\t<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->\n\t\t\t";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\n\t\t\t\t<td width=\"25%\" class=\'label\' id=\'cncl_date_lbl\' ></td>\n\t\t\t\t<td width=\"25%\" class=\'querydata\' id=\'cncl_date\' >\n\t\t\t\t<input type=hidden  id=\'cancelDate\' name=\"cancelDate\" id=\"cancelDate\" size=15 maxlength=15 value=\'";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\'></td>\n\t\t\t";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\n\t\t\t<!--End-->\n\t\t</tr>\n\t\t\n\t\t<!--Added By Ashwini on 21-Aug-2017 for\tML-MMOH-CRF-0708-->\n\t\t";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\n\t\t\t<tbody id=\'hideFields\' style=\"display:none;\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"25%\" class=\'label\' id=\'appl_mode_lbl\'></td>\n\t\t\t\t\t<td class=\'querydata\' id=\'appl_mode\' >\n\t\t\t\t\t<select name=\"application_mode\" id=\"application_mode\" style=\"visibility:hidden\" >\n\t\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"  id=\'appl_mode_img\' align=\'center\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"25%\" class=\'label\' id=\'collec_mode_lbl\'></td>\n\t\t\t\t\t<td class=\'querydata\' id=\'collec_mode\' >\n\t\t\t\t\t<select name=\"collection_mode\" id=\"collection_mode\" style=\"visibility:hidden\" >\n\t\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"  id=\'collec_mode_img\' align=\'center\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td width=\"25%\" class=\'label\' id=\'notifi_mode_lbl\'></td>\n\t\t\t\t\t<td class=\'querydata\' id=\'notifi_mode\' >\n\t\t\t\t\t<select name=\"notification_mode\" id=\"notification_mode\" style=\"visibility:hidden\" >\n\t\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"  id=\'notifi_mode_img\' align=\'center\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</tbody>\n\t\t";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\t\n\t\t\t<!--ML-MMOH-CRF-0708 End-->\n\n\t\t<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->\n\t\t";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\n\t\t</table>\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t\t<tbody id=\'hideRow\' style=\"display:none;\">\n\t\t\t<tr>\n\t\t\t\t<td width=\"25%\" class=\'label\' id=\'cncl_reason_lbl\' ></td>\n\t\t\t\t<td class=\'querydata\' id=\'cncl_reason\' >\n\t\t\t\t<select name=\"cancel_reason\" id=\"cancel_reason\" style=\"visibility:hidden\" >\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"  id=\'cancel_reason_img\' align=\'center\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</tbody>\n\t\t</table>\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t\t";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\n\t\t<!--End-->\n";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\n\t\t<!-- Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 Start-->\n\t\t";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="</td>\n\t\t\t<td class=\"fields\"><input type=text name=\"dept_spl\" id=\"dept_spl\" size=15 maxlength=15";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 =" disabled";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\"><input type=button class=button name=\'search_spl\' id=\'search_spl\' value=\'?\' onclick=\"getSpecialtyValue(dept_spl, \'";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\')\" ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\"DeptImg\"></img></td>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t</tr>\n\t\t<!-- Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 End-->\n\t\t";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="</td>\n\t\t\t<td class=\"fields\"><input type=\'text\' name=\'pract_desc\' id=\'pract_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeGetPractitioner();\' value=\"";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\" ><input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\"><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' ></td>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\n\t\t<tr>\n\t\t\t<td  class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="</td>\n\t\t\t<td class=\'QueryData\' width=\"25%\">";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="</td>\n\t\t\t<td class=\"label\" width=\"18%\">";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t\t<td width=\"32%\" class=\"fields\" nowrap>&nbsp;<input type=\'text\'  name=\'fwd_hod_desc\' id=\'fwd_hod_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeFwdGetFwdHod();\' value=\'";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\' disabled /><input type=\'hidden\' name=\'fwd_hod_id\' id=\'fwd_hod_id\' value=\'";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\' /><input type=\'button\' name=\'fwd_hod_id_search\' id=\'fwd_hod_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' disabled />\n\t\t\t";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\t\n\t\t\t\t<select name=\"medical_team_val\" id=\"medical_team_val\" id=\"medical_team_val\"   ";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="  onchange=\"mrteam_change()\">\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\n\t\t\t\t</select>";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\n\t\t<tr>\n\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="</td>\n\t\t\t<td class=\"fields\" colspan=\"3\" ><textarea name=\'reqd_docs\' id=\'reqd_docs\' style=\"resize: none;\" rows=2 cols=\'60\' onblur=\"makeValidString(this);chklim(this,100);tab_click(\'report_details\');\"  > </textarea></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\n</table>\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t\n";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t<td class=\"fields\" width=\"25%\"><input type=\"text\" name=\"disp_col_date\" id=\"disp_col_date\" maxlength=16 size=16 value =\"";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="</td>\n\t\t<td class=\'QueryData\' width=\"30%\">";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\n\t\t<td class=label>&nbsp;</td>\n\t\t<td class=label>&nbsp;</td>\n";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\n\t</tr>\n";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\n\t\t<td  class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="&nbsp;&nbsp;&nbsp;</td>\n\t";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\n\t<td  class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\n\t\t<td class=\"fields\" width=\"25%\">\n\t\t<input type=\'text\' name=\'fwd_pract_desc\' id=\'fwd_pract_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeFwdGetPractitioner();\' value=\"";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\" ";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="><input type=\'hidden\' name=\'fwd_practitioner_id\' id=\'fwd_practitioner_id\' value=\"";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\"><input type=\'button\' name=\'fwd_pract_id_search\' id=\'fwd_pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' ";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="> <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\n\t\t<td  class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="</td>\n\t\t<td class=\"fields\" width=\"25%\"><input type=\'text\' name=\'prep_pract_desc\' id=\'prep_pract_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforePrepGetPractitioner();\' value=\"";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\" ><input type=\'hidden\' name=\'prep_practitioner_id\' id=\'prep_practitioner_id\' value=\"";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\" ><input type=\'button\' name=\'prep_pract_id_search\' id=\'prep_pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' ><img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:visible\" id=\'prep_pract_desc_Img\' align=\'center\'></img></td> <!-- style added by mujafar for ML-MMOH-CRF-0963 -->\n\t\t\n\t\t";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\n\t\t<td class=\'label\'  width=\'25%\'  >\n\t\t\t";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\n\t\t\t</td>\n\t\t\t<td nowrap class=\'querydata\'      width=\'25%\' >";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="</td>\n\t\t";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\n\t<tr>    \n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t\t<td width=\"33%\" class=\"fields\"><input type=\'text\'  name=\'fwd_hod_desc\' id=\'fwd_hod_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeFwdGetFwdHod();\' value=\'";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\'><input type=\'button\' name=\'fwd_hod_search\' id=\'fwd_hod_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' disabled>\n\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="  style=\"width:120px;\" onchange=\"mrteam_change()\">\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\n\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t\t\t<td width=\'20%\' colspan=\'6\' >&nbsp;</td>\n\t\t\t\t<td width=\'10%\' colspan=\'6\' >&nbsp;</td>\t\t\t\t\t\t\n           </tr>\n\t\n\t\n\t";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\n\t<tr>\n\t\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t<td class=\"fields\" width=\"25%\">\n\t\t<!-- Below code is commented by Akhilesh because unnecessary function is calling -->\n\t\t<!--<input type=\"text\" id=\'prepareDt\' name=\"prepare_date\" id=\"prepare_date\" maxlength=16 size=16 onblur=\"chkDateVal(this);CompareReqDate(this,document.forms[0].request_date);CompareSysDatePrp(this);CompareCollectDate(document.forms[0].hdd_CollectDate,this);\" value =\"";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\"> -->\n\t\t<input type=\"text\" id=\'prepareDt\' name=\"prepare_date\" id=\"prepare_date\" maxlength=16 size=16 onblur=\"CompareReqDate(this,document.forms[0].request_date);CompareSysDatePrp(this);CompareCollectDate(document.forms[0].hdd_CollectDate,this);\" value =\"";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\"><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].prepare_date.focus();return showCalendar(\'prepareDt\',null,\'hh:mm\');\" ><img src=\'../../eCommon/images/mandatory.gif\' id=\'prepare_date_Img\' align=\'center\'></img></td>\n\t\t<td align=\'right\' class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="&nbsp;&nbsp;</td>\n\t\t<td class=\"fields\" width=\"25%\"><input type=\'text\' name=\'pract_desc\' id=\'pract_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeGetPractitioner();\' value=\"";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\"><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(this);\' disabled></td>\n\t\t\t\n\t</tr>\n\t<tr>    \n\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="&nbsp;&nbsp;&nbsp;</td><td width=\"33%\" class=\"fields\">&nbsp;<input type=\'text\'  name=\'fwd_hod_desc\' id=\'fwd_hod_desc\' size=\'30\' maxlength=\'30\' onblur=\'BeforeFwdGetFwdHod();\' value=\'";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\n\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t\t\t<td width=\'20%\' colspan=\'6\' >&nbsp;</td>\n\t\t\t\t<td width=\'10%\' colspan=\'6\' >&nbsp;</td>\t\t\t\t\t\t\n           </tr>\n\n\t\t    <tr>\n\t\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="&nbsp;&nbsp;</td><td   class=\"fields\" colspan=\"3\" width=\'57%\'>&nbsp;<textarea   name=\'reqd_docs\' id=\'reqd_docs\' rows=2 cols=\'60\' colspan=\"3\" onblur=\"makeValidString(this);chklim(this,100);tab_click(\'report_details\');\"  disabled></textarea></td>\n\t\t\t\t<td width=\'20%\' colspan=\'8\'>&nbsp;</td>\n\t\t\t\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\n<tr>\t\n\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="</td>\n\t<td colspan=\"\" class=\"fields\"  ><textarea name=\'remarks_hod\' rows=2 cols=\'40\' disabled  onblur=\"makeValidString(this);chklim(this,200);tab_click(\'report_details\');\"  >";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="</textarea></td>\n\t\n\t</tr>\n\n\n";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\t\t\t\t\n";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\n\t\t<tr>  \n\t\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t\t<td nowrap class=\'querydata\' width=\'25%\' >\n\t\t\t<input type=\'checkbox\' name=\"cancel_medical_report\" id=\"cancel_medical_report\" id=\"cancel_medical_report\" onclick=\"frwdtoPractMedicalReport()\"></td>\n\t\t\t<td align=\'right\' class=\'label\' width=\'25%\'  id=\"cancelby_medical_report\">&nbsp;&nbsp;</td>\n\t\t\t<td class=\'QueryData\'  colspan=\'8\' align=\'left\' width=\'20%\' id=\"cancelby_med_rep_user\" style=\'word-wrap: break-word;width:275px\'>&nbsp;</td>\t\t\t\n\t\t</tr>\n        <tr>  \n\t\t\t<td class=\"label\" width=\"25%\" name=\"cancel_medrep_reason\" id=\"cancel_medrep_reason\" >&nbsp;&nbsp;</td>\n\t\t\t<td nowrap class=\'querydata\' width=\'25%\' name=\"cancel_medrep_reason_desc\" id=\"cancel_medrep_reason_desc\" >\n\t\t\t<select name=\"cancel_medical_rep_reason\" id=\"cancel_medical_rep_reason\" style=\"visibility:hidden\">\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"  id=\'cancel_medical_rep_reason_img\' align=\'center\'></img>\n\t\t\t</td>\n\t\t\t<td align=\'right\' class=\'label\' width=\'25%\' name=\"cancelon_medical_report\" id=\"cancelon_medical_report\">&nbsp;&nbsp;</td>\n\t\t\t<td class=\'QueryData\'  colspan=\'8\' align=\'left\' width=\'20%\' name=\"cancelondate_medical_report\" id=\"cancelondate_medical_report\">&nbsp;</td>\t\t\n\t</tr>\n\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\n<tr>\n<td class=\"columnheader\" colspan=5>\n<!--";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="-->\n";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\n</td>\n</tr>\n<tr>\n<td width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="</td>\n\t\t\t\t<td width=\"25%\" class=\'label\'>\n\t\t\t\t\t<select name=\"prac_status\" id=\"prac_status\"  onchange=\"check_pract_status();\" >\n\t\t\t\t\t\t<option value=\'AP\' selected>";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="</option>\n\t\t\t\t\t\t<option value=\'RM\' >";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="</option>\n\t\t\t\t\t\t<option value=\'RH\' >";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="</option>\t\n\t\t\t\t\t</select>\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\"   width=\"25%\"><span id=\"prep_date\" Style=\"display:inline;\" >";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="</span><span id=\"prep_date1\" Style=\"display:none;\" >";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="</span><span id=\"prep_date2\" Style=\"display:none;\" >";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="</span></td>\n\t\t<td class=\"fields\"  width=\"25%\">\n\t\t<span id=\"prep_date3\" Style=\"display:inline;\" ><input type=\"text\" id=\'prepareDt\' name=\"prepare_date\" id=\"prepare_date\" maxlength=16 size=16 onblur=\"CompareReqDate(this,document.forms[0].request_date);CompareSysDatePrp(this);CompareCollectDate(document.forms[0].hdd_CollectDate,this);\" value =\"";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\"><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].prepare_date.focus();return showCalendar(\'prepareDt\',null,\'hh:mm\');\" ><img src=\'../../eCommon/images/mandatory.gif\' id=\'prepare_date_Img\' align=\'center\'></img></span>\n\t\t<span id=\"prep_date4\" Style=\"display:none;\" >\n\t\t<select name=\"reject_medical_rep_reason_1\" id=\"reject_medical_rep_reason_1\"  >\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'   id=\'reject_medical_rep_reason_img_1\' align=\'center\'></img>\n\t\t</span>\n\t\t</td>\n\t\t\t\t\n</tr>\n<tr>\n<td  class=\'label\' width=\"25%\" ><span id=\"Prep\" Style=\"display:inline;\" >";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 =" </span><span id=\"Rejec\" Style=\"display:none;\">";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="</span><span id=\"Returnb\" Style=\"display:none;\">";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="</span></td>\n<td class=\"QueryData\" width=\"25%\">&nbsp;";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="<input type=\'hidden\' name=\'prep_practitioner_id\' id=\'prep_practitioner_id\' value=\"";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\" ></td>\n<!-- loginUserName Modified By Dharma on 4th Mar 2020 against ML-MMOH-CRF-1473 -->\n<td class=\'label\'  width=\'25%\'  ><span id=\"Prep1\" Style=\"display:inline;\" >\n";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="</span>\n<span id=\"Rejec1\" Style=\"display:none;\">";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="</span>\n<span id=\"Returnb1\" Style=\"display:none;\">";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 =" </span>&nbsp;\n</td><td nowrap class=\'querydata\'  width=\'25%\' >&nbsp;";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="</td>\n<input type=\'hidden\' name=\'acc_rej_ret_date\' id=\'acc_rej_ret_date\' value=\'";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\'> \n\n</tr>\n<tr>\n<td class=\"label\" width=\"25%\" >\n\t<!--";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\n\t</td>\n\t<td colspan=\"\" class=\"fields\" width=\"25%\" ><textarea name=\'remarks_pract\' rows=2 cols=\'40\'   onblur=\"makeValidString(this);chklim(this,200);tab_click(\'report_details\');\"  >";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="</textarea></td>\n\n</tr>\n<!-- commented by mujafar for ML-MMOH-CRF-1279\n<tr>\n<td class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="</td>\n<td   class=\"fields\" colspan=\"3\" width=\'25%\'><textarea   name=\'reqd_docs\' rows=2 cols=\'60\' colspan=\"3\" onblur=\"makeValidString(this);chklim(this,100);tab_click(\'report_details\');\"  disabled></textarea></td>\n</tr>\n-->\n";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\n\t<tr>\n\t\t<td class=\"label\" width=\"20%\" nowrap>";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="</td>\n\t\t<td class=\'querydata\' width=\"15%\">";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="</td>\n\t\t<td class=\"label\" id=\"receive_date_chk_1\" width=\"20%\" nowrap>\n\t\t";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\n\t\t\t";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\n\t\t</td> <!-- added by mujafar for ML-MMOH-CRF-0714 -->\n\t\t<td class=\"fields\" id=\"receive_date_chk_2\" width=\"25%\"><input type=\"text\" id=\'ReceiveDt\' name=\"receive_date\" id=\"receive_date\" maxlength=16 size=16 onblur =\"chkDateVal(this);validateDate(this);CompareSysforRecdDate(this);\" value =\"\"><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'ReceiveDt_img\'  onClick=\"document.forms[0].receive_date.focus();return showCalendar(\'ReceiveDt\',null,\'hh:mm\');\" ><img src=\'../../eCommon/images/mandatory.gif\' id=\'receive_date_Img\' align=\'center\'></img></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="</td> \n\t\t<td class=\'querydata\' >";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="</td>\n\t\t<td class=\"label\">&nbsp;</td>\n\t\t<td class=\"label\">&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\' width=\"25%\">\n\t\t<!-- Below Condition Added By Dharma on 26th Mar 2020 against ML-MMOH-CRF-1473-->\n\t\t";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\n\t\t&nbsp;&nbsp;&nbsp;</td>\n\t\t<td class=\"QueryData\" width=\"25%\">";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="</td>\n\t\t<td  class=\'label\' width=\"20%\" >";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="</td>\n\t\t<td class=\"QueryData\" width=\"25%\">";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\n\t<tr>\n\t<td class=\"label\">&nbsp;</td><td class=\"label\">&nbsp;</td>\n\t<td width=\'20%\' align=\'center\' class=\'label\' width=\'25%\' id=\"reject_by_3\" style=\"display:none;\">";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="</td> <!-- label changed for ML-MMOH-CRF-0713 -->\n\t<td width=\'30%\'  class=\'QueryData\'  colspan=\'8\' align=\'left\' id=\"reject_by_4\" style=\"display:none;\">";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="</td> \n\t</tr>\n\t<tr>\n\t<td class=\"label\">&nbsp;</td><td class=\"label\">&nbsp;</td>\n\t<td width=\'20%\' align=\'center\' class=\'label\' width=\'25%\' id=\"reject_on_3\" style=\"display:none;\" >";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\'></td> <!-- label changed for ML-MMOH-CRF-0713 -->\n\t<td width=\'30%\'  class=\'QueryData\'  colspan=\'8\' align=\'left\' id=\"reject_on_4\" style=\"display:none;\">";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="</td>\n\t</tr>\n\t<tr>\n\t<td class=\"label\">&nbsp;</td><td class=\"label\">&nbsp;</td>\n\t<td width=\'20%\' align=\'center\' class=\'label\' width=\'25%\' id=\"reject_reason_3\" style=\"display:none;\" >";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="</td>\n\t\t\t\t<td nowrap class=\'querydata\' width=\'30%\' name=\"reject_medrep_reason_desc_1\" id=\"reject_medrep_reason_desc_1\"  style=\"display:none;\" >\n\t\t\t<select name=\"reject_medical_rep_reason_1\" id=\"reject_medical_rep_reason_1\" style=\"visibility:hidden\" >\n\t\t\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"  id=\'reject_medical_rep_reason_img_1\' align=\'center\'></img>\n\t\t\t</td>\n\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\n</table>\n";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t<!-- Below Condition Added By Dharma on 13th Apr 2020 against ML-MMOH-CRF-1314 -->\n\t";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\n\t<tr>\n\t\t\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="</td> \n\t\t\t<TD class=\'querydata\' width=\"25%\">";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="</td>\n\t\t\t<td class=\"label\"  nowrap width=\"25%\">";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="</td>\n\t\t\t<TD class=\'querydata\' width=\"25%\">";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="</td>\n\t</tr>\n\t\n\t<tr>\n\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="</td>\n\t\t<td class=\"fields\">\n\t\t\t<input type=\"text\" id=\'deliveredDt\' name=\"delivered_date\" id=\"delivered_date\" maxlength=16 size=16 onblur =\"chkDateVal(this);validateDate(this);CompareSysforRecdDate(this);\" value =\"";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\" />\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].delivered_date.focus();return showCalendar(\'deliveredDt\',null,\'hh:mm\');\" id=\'del_img\'></img>\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' id=\'delivered_date_Img\' align=\'center\'></img>\n\t\t</td>\n\t\t\n\t\t\n\t\t\n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\n\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\n\t\t<td class=\"fields\">\n\t\t\t<select name=\"Despatch_mode\" id=\"Despatch_mode\" onchange=\"enableDisableObjs(this.value)\" onblur=\"tab_click(\'report_details\');\" ";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 =">\n\t\t\t<option value=\"\">----- ";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\n\t\t\t\t<option value=\'P\'>";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="</option>\n\t\t\t\t<option value=\'O\'>";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\n\t\t\t</select>\n\t\t\t<script>document.forms[0].Despatch_mode.value = \"";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\";</script> ";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="<img src=\'../../eCommon/images/mandatory.gif\' ></img>";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="</td>\n\t\t<td  class=\'label\' id=\"lblDatePostedTD\">";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="</td>\n\t\t<td class=\"fields\" id=\"fldDatePostedTD\"><input disabled type=\"text\" id=\'postedDt\' name=\"posted_date\" id=\"posted_date\" maxlength=16 size=16 onblur=\"chkDateVal(this);\" value=\"";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\"  ";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 =" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].posted_date.focus();return showCalendar(\'postedDt\',null,\'hh:mm\');\" id=\'postImg\' disabled > ";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="</td>\n\t\t<!-- isAcceptRequestByPractAppl condition added by Dharma on 29th Sep 2020 against Incident 74135-->\n\t\t";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\n\t\t<td class=\"label\"  nowrap id=\"lblDelDateTD\" style=\"display:none;\">";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="</td>\n\t\t<td class=\"fields\" id=\"fldDelDateTD\" style=\"display:none;\" ><input type=\"text\" id=\'deliveredDt\' name=\"delivered_date\" id=\"delivered_date\" maxlength=16 size=16 onblur =\"chkDateVal(this);validateDate(this);CompareSysforRecdDate(this);\" value =\"";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].delivered_date.focus();return showCalendar(\'deliveredDt\',null,\'hh:mm\');\" id=\"del_img\" ><img src=\'../../eCommon/images/mandatory.gif\' id=\'delivered_date_Img\' align=\'center\'></img></td>\n\t\t";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="\n\t</tr>\n\t<tr id=\"natIDRow\" style = \'display:block;\'>\n";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="</td>\n\t\t<td  class=\"fields\"><input type=text name=\"del_nric_no\" id=\"del_nric_no\" size=\"20\" maxlength=\"20\" value=\"";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\" onBlur=\"CheckNumberFormat(this);\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' disabled ></td>\n";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t<td class=\"label\">&nbsp;</td>\n";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\n\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 ="</td>\n\t\t<td  class=\"fields\"><input type=text name=\"report_taken\" id=\"report_taken\" size=\'20\' value=\"";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="\" maxlength=\"30\" disabled ></td>\n\n\n\t</tr>\n\t<tr id =\'altIDRow\' style = \'display:block;\'>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="</td>\n\t\t<td  class=\"fields\"><select name=\"del_oth_alt_type\" id=\"del_oth_alt_type\" Disabled onchange=\'if(this.value!=\"\"){document.forms[0].del_oth_alt_id.value = \"\";document.forms[0].del_oth_alt_id.disabled=false;}else{document.forms[0].del_oth_alt_id.value = \"\";document.forms[0].del_oth_alt_id.disabled=true}\'>\n\t\t\t <option value=\'\'>---- ";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 =" ----\n\t\t ";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 ="\t\t</select>\n\t\t<script>\n\t\t\tdocument.forms[0].del_oth_alt_type.value=\"";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="\";\n\t\t</script>\n\t\t</td>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 ="</td>\t\n\t\t<td class=\"fields\"><input type=text name=\"del_oth_alt_id\" id=\"del_oth_alt_id\" size=\'20\' maxlength=\"20\"  value=\"";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="\" disabled onblur=\"tab_click(\'report_details\');validateSplchars(this)\" ></td>\t\t\n\t</tr>\n\t<tr id=\"postAgeNoRow\" style = \'display:block;\'>\n\t\t";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 ="</td>\n\t\t<td class=\"fields\">\n\t\t<!--onKeyPress=\'return allowAlphaNumeric(event)\' Removed By Dharma on Apr 15th 2020 against ML-MMOH-CRF-1314 -->\n\t\t<input type=text name=\"file_no\" id=\"file_no\" size=\'20\' maxlength=\"30\" value=\"";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="\" disabled  onblur=\"tab_click(\'report_details\')\">";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="\t\t\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 ="</td>\n\t\t<td class=\"fields\"><input type=text name=\"file_no\" id=\"file_no\" size=\'20\' maxlength=\"20\" value=\"";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 ="\" disabled onKeyPress=\'return(ChkNumberInput(this,event,0))\' onblur=\"tab_click(\'report_details\')\"></td>\n\t\t";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 ="\n\t\t<td  class=\'label\'>&nbsp;</td>\n\t\t<td class=\"fields\"><input class=button type=\"button\" name=\"address\" id=\"address\" ";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="value=\"";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 ="\"";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 ="onclick=\"popAddress();\" disabled></td>\n\t\t\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\' width=\"25%\">\n\t\t<!-- Below Condition Added By Dharma on 26th Mar 2020 against ML-MMOH-CRF-1473-->\n\t\t";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="\n\t\t</td>\n\t\t<td class=\"QueryData\" width=\"25%\">";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="</td>\n\t\t<td  class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="</td>\n\t</tr>\n\t<!-- Added By Dharma on 13th Apr 2020 against ML-MMOH-CRF-1314 Start-->\n\t";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 ="</td>\n\t\t\t<td class=\"label\"  nowrap width=\"25%\">\n\t\t\t<!--";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="-->\n\t\t\t";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="\n\t\t\t\n\t\t\t</td>\n\t\t\t<TD class=\'querydata\' width=\"25%\">";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\n\t<!-- Added By Dharma on 13th Apr 2020 against ML-MMOH-CRF-1314 End-->\n\t<tr>\n\t\t<td  class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="</td> <!-- modified by mujafar for ML-MMOH-CRF-0716 -->\n\t</tr>\n\t<!-- Added By Dharma on 13th Apr 2020 against ML-MMOH-CRF-1314 Start-->\n\t";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="\n\n\t<tr>\n\t\t<td class=\'label\'  width=\"25%\" >";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 ="</td>\n\t\t<td colspan=\"3\" class=\"fields\"><textarea name=\'delivery_remarks\' rows=2 cols=\'60\'  onblur=\"makeValidString(this);chklim(this,200);\" ";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 =" >";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 ="</textarea>&nbsp;</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="\n\t<!-- Added By Dharma on 13th Apr 2020 against ML-MMOH-CRF-1314 End-->\n\t\n</table>\n";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 ="  \n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"  nowrap width=\"25%\">";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 ="</td>\n\t\t\t\t<td class=\"fields\" width=\"25%\"><input type=\"text\" id=\'RevisedCollectdDt\' name=\"revised_collect_date\" id=\"revised_collect_date\" maxlength=16 size=16 onblur=\"chkDateVal(this);validateDate(this);\" value =\"\"><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].revised_collect_date.focus();return showCalendar(\'RevisedCollectdDt\',null,\'hh:mm\');\" ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="</td>\n\t\t\t\t<td class=\"fields\" width=\"25%\"><input type=\"text\" name=\"authorised_by\" id=\"authorised_by\" maxlength=16 size=16 value=\"\" onBlur=\'beforeGetAuthorised(document.forms[0].Authorised_hid,this);\'><input type=button class=button name=\'search_Authorised\' id=\'search_Authorised\' value=\'?\' onclick=\"getAuthoriser(document.forms[0].Authorised_hid,document.forms[0].authorised_by)\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img><input type=hidden name=\"Authorised_hid\" id=\"Authorised_hid\" value=\'\'></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\n\t\t</table>\n";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="\n<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->  \n<input type=\"hidden\" name=\"cancelledBy\" id=\"cancelledBy\" value=\"";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\" >\n<input type=\"hidden\" name=\"cancelledDate\" id=\"cancelledDate\" value=\"";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\" >\n<input type=\"hidden\" name=\"cancelledReason\" id=\"cancelledReason\" value=\"";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="\" >\n<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\'";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 ="\'>\n<input type=\'hidden\' name=\'isIncompReqCancelApplicable\' id=\'isIncompReqCancelApplicable\' value=\'";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\'>\n<input type=\'hidden\' name=\'requestStatus\' id=\'requestStatus\' value=\'";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

    private final static java.lang.String  _wl_block598 ="\'>\n<!--End--> \n<input type=\'hidden\' name=\'isAcceptRequestByPractAppl\' id=\'isAcceptRequestByPractAppl\' value=\'";
    private final static byte[]  _wl_block598Bytes = _getBytes( _wl_block598 );

    private final static java.lang.String  _wl_block599 ="\'><!-- added by mujafar for ML-MMOH-CRF-1316 -->\n<!-- added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 -->\n<input type=\'hidden\' name=\'loginUserID\' id=\'loginUserID\' value=\'";
    private final static byte[]  _wl_block599Bytes = _getBytes( _wl_block599 );

    private final static java.lang.String  _wl_block600 ="\'><!-- added by mujafar for ML-MMOH-CRF-0718 -->\n<input type=\'hidden\' name=\'isSelfStatusMRPApplicable\' id=\'isSelfStatusMRPApplicable\' value=\'";
    private final static byte[]  _wl_block600Bytes = _getBytes( _wl_block600 );

    private final static java.lang.String  _wl_block601 ="\'> <!-- added by mujafar for ML-MMOH-CRF-0718 --> \n<input type=\'hidden\' name=\'isMedicalTeamApplicable\' id=\'isMedicalTeamApplicable\' value=\'";
    private final static byte[]  _wl_block601Bytes = _getBytes( _wl_block601 );

    private final static java.lang.String  _wl_block602 ="\'> <!-- added by mujafar for ML-MMOH-CRF-0716 -->\n\n<input type=\'hidden\' name=\'isRejectRequestApplicable\' id=\'isRejectRequestApplicable\' value=\'";
    private final static byte[]  _wl_block602Bytes = _getBytes( _wl_block602 );

    private final static java.lang.String  _wl_block603 ="\'> <!-- added by mujafar for ML-MMOH-CRF-0713 -->\n<input type=\'hidden\' name=\'isRejectReportApplicable\' id=\'isRejectReportApplicable\' value=\'";
    private final static byte[]  _wl_block603Bytes = _getBytes( _wl_block603 );

    private final static java.lang.String  _wl_block604 ="\'> <!-- added by mujafar for ML-MMOH-CRF-0714 -->\n<input type=\'hidden\' name=\'isMedicalReportDurationAppl\' id=\'isMedicalReportDurationAppl\' value=\'";
    private final static byte[]  _wl_block604Bytes = _getBytes( _wl_block604 );

    private final static java.lang.String  _wl_block605 ="\'> <!-- added by mujafar for ML-MMOH-CRF-0704 -->\t\n<input type=\"hidden\" name=\"medrep_pay_int_mode\" id=\"medrep_pay_int_mode\" value=\"";
    private final static byte[]  _wl_block605Bytes = _getBytes( _wl_block605 );

    private final static java.lang.String  _wl_block606 ="\" >\n<input type=\"hidden\" name=\"prepareDate\" id=\"prepareDate\" value=\"";
    private final static byte[]  _wl_block606Bytes = _getBytes( _wl_block606 );

    private final static java.lang.String  _wl_block607 ="\" >\n<input type=\"hidden\" name=\"applCompletionDate\" id=\"applCompletionDate\" value=\"";
    private final static byte[]  _wl_block607Bytes = _getBytes( _wl_block607 );

    private final static java.lang.String  _wl_block608 ="\" >\n<input type=\"hidden\" name=\"RequestDate\" id=\"RequestDate\" value=\"";
    private final static byte[]  _wl_block608Bytes = _getBytes( _wl_block608 );

    private final static java.lang.String  _wl_block609 ="\" >\n<input type=\"hidden\" name=\"ReceivedDate\" id=\"ReceivedDate\" value=\"";
    private final static byte[]  _wl_block609Bytes = _getBytes( _wl_block609 );

    private final static java.lang.String  _wl_block610 ="\" >\n<input type=\"hidden\" name=\"DeliveredDate\" id=\"DeliveredDate\" value=\"";
    private final static byte[]  _wl_block610Bytes = _getBytes( _wl_block610 );

    private final static java.lang.String  _wl_block611 ="\" >\n<input type=\"hidden\" name=\"applSubmissionDate\" id=\"applSubmissionDate\" value=\"";
    private final static byte[]  _wl_block611Bytes = _getBytes( _wl_block611 );

    private final static java.lang.String  _wl_block612 ="\" >\n\n<input type=\"hidden\" name=\"hdd_charges_appl_yn\" id=\"hdd_charges_appl_yn\" value=\"";
    private final static byte[]  _wl_block612Bytes = _getBytes( _wl_block612 );

    private final static java.lang.String  _wl_block613 ="\" >\n<input type=\"hidden\" name=\"hdd_addl_charges_yn\" id=\"hdd_addl_charges_yn\" value=\"";
    private final static byte[]  _wl_block613Bytes = _getBytes( _wl_block613 );

    private final static java.lang.String  _wl_block614 ="\" >\n<input type=\"hidden\" name=\"hdd_receipt_no\" id=\"hdd_receipt_no\" value=\"";
    private final static byte[]  _wl_block614Bytes = _getBytes( _wl_block614 );

    private final static java.lang.String  _wl_block615 ="\" >\n<input type=\"hidden\" name=\"hdd_addl_receipt_no\" id=\"hdd_addl_receipt_no\" value=\"";
    private final static byte[]  _wl_block615Bytes = _getBytes( _wl_block615 );

    private final static java.lang.String  _wl_block616 ="\" >\n<input type=\"hidden\" name=\"hdd_amount\" id=\"hdd_amount\" value=\"";
    private final static byte[]  _wl_block616Bytes = _getBytes( _wl_block616 );

    private final static java.lang.String  _wl_block617 ="\" >\n<input type=\"hidden\" name=\"hdd_addl_amount\" id=\"hdd_addl_amount\" value=\"";
    private final static byte[]  _wl_block617Bytes = _getBytes( _wl_block617 );

    private final static java.lang.String  _wl_block618 ="\" >\n<input type=\"hidden\" name=\"hdd_receipt_date\" id=\"hdd_receipt_date\" value=\"";
    private final static byte[]  _wl_block618Bytes = _getBytes( _wl_block618 );

    private final static java.lang.String  _wl_block619 ="\" >\n<input type=\"hidden\" name=\"hdd_addl_receipt_date\" id=\"hdd_addl_receipt_date\" value=\"";
    private final static byte[]  _wl_block619Bytes = _getBytes( _wl_block619 );

    private final static java.lang.String  _wl_block620 ="\" >\n<input type=\'hidden\' name=\"isSpecialtyDefaultApp\" id=\"isSpecialtyDefaultApp\" value=\"";
    private final static byte[]  _wl_block620Bytes = _getBytes( _wl_block620 );

    private final static java.lang.String  _wl_block621 ="\" />\n<input type=\'hidden\' name=\"specialtyEffStatus\" id=\"specialtyEffStatus\" value=\"";
    private final static byte[]  _wl_block621Bytes = _getBytes( _wl_block621 );

    private final static java.lang.String  _wl_block622 ="\" />\n<input type=\'hidden\' name=\"specialtyMRApplYN\" id=\"specialtyMRApplYN\" value=\"";
    private final static byte[]  _wl_block622Bytes = _getBytes( _wl_block622 );

    private final static java.lang.String  _wl_block623 ="\" />\n\n<input type=\'hidden\' name=\'isRequestorAddrDispApp\' id=\'isRequestorAddrDispApp\' value=\'";
    private final static byte[]  _wl_block623Bytes = _getBytes( _wl_block623 );

    private final static java.lang.String  _wl_block624 ="\'> <!-- Added By Dharma on 13th Dec 2019 against ML-MMOH-CRF-1362 -->\n<!--Below line added for this CRF ML-MMOH-CRF-0712-->  \n<input type=\"hidden\" name=\"isMedicalReportRequest\" id=\"isMedicalReportRequest\" value=\"";
    private final static byte[]  _wl_block624Bytes = _getBytes( _wl_block624 );

    private final static java.lang.String  _wl_block625 ="\" > \n<input type=\"hidden\" name=\"medRequestChkbox\" id=\"medRequestChkbox\" value=\"N\"> \n<!--End this CRF ML-MMOH-CRF-0712-->\n\t\n\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block625Bytes = _getBytes( _wl_block625 );

    private final static java.lang.String  _wl_block626 ="\">\n\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value=\"";
    private final static byte[]  _wl_block626Bytes = _getBytes( _wl_block626 );

    private final static java.lang.String  _wl_block627 ="\">\n\t<input type=\'hidden\' name=\'next_of_kin_name\' id=\'next_of_kin_name\' value=\"";
    private final static byte[]  _wl_block627Bytes = _getBytes( _wl_block627 );

    private final static java.lang.String  _wl_block628 ="\">  <!-- added by mujafar for ML-MMOH-CRF-0762  start-->\n\t<input type=\'hidden\' name=\'next_of_kin_nat_id_no\' id=\'next_of_kin_nat_id_no\' value=\"";
    private final static byte[]  _wl_block628Bytes = _getBytes( _wl_block628 );

    private final static java.lang.String  _wl_block629 ="\">\n\t<input type=\'hidden\' name=\'next_of_kin_alt_id_type\' id=\'next_of_kin_alt_id_type\' value=\"";
    private final static byte[]  _wl_block629Bytes = _getBytes( _wl_block629 );

    private final static java.lang.String  _wl_block630 ="\"> \n\t<input type=\'hidden\' name=\'next_of_kin_relation_code\' id=\'next_of_kin_relation_code\' value=\"";
    private final static byte[]  _wl_block630Bytes = _getBytes( _wl_block630 );

    private final static java.lang.String  _wl_block631 ="\"> \n\t<input type=\'hidden\' name=\'next_of_kin_alt_id_no\' id=\'next_of_kin_alt_id_no\' value=\"";
    private final static byte[]  _wl_block631Bytes = _getBytes( _wl_block631 );

    private final static java.lang.String  _wl_block632 ="\"> \n\t<input type=\'hidden\' name=\'classification_ind\' id=\'classification_ind\' value=\"";
    private final static byte[]  _wl_block632Bytes = _getBytes( _wl_block632 );

    private final static java.lang.String  _wl_block633 ="\"> \n\t<input type=\'hidden\'  name=\"ret_val1\" id=\"ret_val1\"  value=\"";
    private final static byte[]  _wl_block633Bytes = _getBytes( _wl_block633 );

    private final static java.lang.String  _wl_block634 ="~";
    private final static byte[]  _wl_block634Bytes = _getBytes( _wl_block634 );

    private final static java.lang.String  _wl_block635 ="\" > <!-- added by mujafar for ML-MMOH-CRF-0762 end --><!--Modified by mujafar for ML-MMOH-CRF-0762 -->\n\t<input type=\'hidden\' name=\'encounterid\' id=\'encounterid\' value=\"";
    private final static byte[]  _wl_block635Bytes = _getBytes( _wl_block635 );

    private final static java.lang.String  _wl_block636 ="\">\n\t<input type=\'hidden\' name=\'LastDet\' id=\'LastDet\' value=\"";
    private final static byte[]  _wl_block636Bytes = _getBytes( _wl_block636 );

    private final static java.lang.String  _wl_block637 ="\">\n\t\n\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block637Bytes = _getBytes( _wl_block637 );

    private final static java.lang.String  _wl_block638 ="\"> \n\t<input type=\'hidden\' name=\'request_id\' id=\'request_id\' value=\"";
    private final static byte[]  _wl_block638Bytes = _getBytes( _wl_block638 );

    private final static java.lang.String  _wl_block639 ="\">\n\t<input type=\'hidden\' name=\'EncounterIDS\' id=\'EncounterIDS\' value=\"\">\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block639Bytes = _getBytes( _wl_block639 );

    private final static java.lang.String  _wl_block640 ="\">\n\t<input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\'";
    private final static byte[]  _wl_block640Bytes = _getBytes( _wl_block640 );

    private final static java.lang.String  _wl_block641 ="\'>\n\t<input type=\'hidden\' name=\'SystemDate_display\' id=\'SystemDate_display\' value=\'";
    private final static byte[]  _wl_block641Bytes = _getBytes( _wl_block641 );

    private final static java.lang.String  _wl_block642 ="\'>\n\t<input type=\'hidden\' name=\'request_date\' id=\'request_date\' value=\'";
    private final static byte[]  _wl_block642Bytes = _getBytes( _wl_block642 );

    private final static java.lang.String  _wl_block643 ="\'>\n\t<input type=\'hidden\' name=\'hdd_Request_desc\' id=\'hdd_Request_desc\' value=\"";
    private final static byte[]  _wl_block643Bytes = _getBytes( _wl_block643 );

    private final static java.lang.String  _wl_block644 ="\">\n\t<input type=\'hidden\' name=\'hdd_Medical_members\' id=\'hdd_Medical_members\' value=\"";
    private final static byte[]  _wl_block644Bytes = _getBytes( _wl_block644 );

    private final static java.lang.String  _wl_block645 ="\">\n\t<input type=\'hidden\' name=\'hdd_Pract_name\' id=\'hdd_Pract_name\' value=\"";
    private final static byte[]  _wl_block645Bytes = _getBytes( _wl_block645 );

    private final static java.lang.String  _wl_block646 ="\">\n\t<input type=\'hidden\' name=\'hdd_team_desc\' id=\'hdd_team_desc\' value=\"";
    private final static byte[]  _wl_block646Bytes = _getBytes( _wl_block646 );

    private final static java.lang.String  _wl_block647 ="\">\n\t<input type=\'hidden\' name=\'hdd_CollectDate\' id=\'hdd_CollectDate\' value=\"";
    private final static byte[]  _wl_block647Bytes = _getBytes( _wl_block647 );

    private final static java.lang.String  _wl_block648 ="\">\n\t<input type=\'hidden\' name=\'hdd_PrepareDate\' id=\'hdd_PrepareDate\' value=\"";
    private final static byte[]  _wl_block648Bytes = _getBytes( _wl_block648 );

    private final static java.lang.String  _wl_block649 ="\">\n\t<input type=\'hidden\' name=\'hdd_RecieveDate\' id=\'hdd_RecieveDate\' value=\"";
    private final static byte[]  _wl_block649Bytes = _getBytes( _wl_block649 );

    private final static java.lang.String  _wl_block650 ="\">\n\t<input type=\'hidden\' name=\'hdd_remarks\' id=\'hdd_remarks\' value=\"";
    private final static byte[]  _wl_block650Bytes = _getBytes( _wl_block650 );

    private final static java.lang.String  _wl_block651 ="\">\n\t<input type=\'hidden\' name=\'hdd_requestor_code\' id=\'hdd_requestor_code\' value=\"";
    private final static byte[]  _wl_block651Bytes = _getBytes( _wl_block651 );

    private final static java.lang.String  _wl_block652 ="\">\n\t<input type=\'hidden\' name=\'hdd_team_code\' id=\'hdd_team_code\' value=\"";
    private final static byte[]  _wl_block652Bytes = _getBytes( _wl_block652 );

    private final static java.lang.String  _wl_block653 ="\">\n\t<input type=\'hidden\' name=\'hdd_pract_code\' id=\'hdd_pract_code\' value=\"";
    private final static byte[]  _wl_block653Bytes = _getBytes( _wl_block653 );

    private final static java.lang.String  _wl_block654 ="\">\n\t<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\"";
    private final static byte[]  _wl_block654Bytes = _getBytes( _wl_block654 );

    private final static java.lang.String  _wl_block655 ="\">\n\t<input type=\'hidden\' name=\'event_status\' id=\'event_status\' value=\"";
    private final static byte[]  _wl_block655Bytes = _getBytes( _wl_block655 );

    private final static java.lang.String  _wl_block656 ="\">\n\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block656Bytes = _getBytes( _wl_block656 );

    private final static java.lang.String  _wl_block657 ="\">\n\t<input type=\'hidden\' name=\'new_func_id\' id=\'new_func_id\' value=\"";
    private final static byte[]  _wl_block657Bytes = _getBytes( _wl_block657 );

    private final static java.lang.String  _wl_block658 ="\">\n\t<input type=\'hidden\' name=\'old_revised_collect_date\' id=\'old_revised_collect_date\' value=\"";
    private final static byte[]  _wl_block658Bytes = _getBytes( _wl_block658 );

    private final static java.lang.String  _wl_block659 ="\">\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\"insert\"> <!-- used for address --> \n\n\t<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start--> \n\t<input type=hidden  name=\"ret_val\" id=\"ret_val\"  value=\"";
    private final static byte[]  _wl_block659Bytes = _getBytes( _wl_block659 );

    private final static java.lang.String  _wl_block660 ="\" />\n\t<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End-->\n\n\t<!--Added By Ashwini on 21-Aug-2017 for\tML-MMOH-CRF-0708-->\n\t<input type=\'hidden\' name=\'isChckLstApplicable\' id=\'isChckLstApplicable\' value=\"";
    private final static byte[]  _wl_block660Bytes = _getBytes( _wl_block660 );

    private final static java.lang.String  _wl_block661 ="\">\n\t<input type=\"hidden\" name=\"applicationMode\" id=\"applicationMode\" value=\"";
    private final static byte[]  _wl_block661Bytes = _getBytes( _wl_block661 );

    private final static java.lang.String  _wl_block662 ="\" >\n\t<input type=\"hidden\" name=\"collectionMode\" id=\"collectionMode\" value=\"";
    private final static byte[]  _wl_block662Bytes = _getBytes( _wl_block662 );

    private final static java.lang.String  _wl_block663 ="\" >\n\t<input type=\"hidden\" name=\"notificationMode\" id=\"notificationMode\" value=\"";
    private final static byte[]  _wl_block663Bytes = _getBytes( _wl_block663 );

    private final static java.lang.String  _wl_block664 ="\" >\n\t<!--ML-MMOH-CRF-0708 End-->\n\n";
    private final static byte[]  _wl_block664Bytes = _getBytes( _wl_block664 );

    private final static java.lang.String  _wl_block665 ="\n\t\t\t<input type=\'hidden\' name=\'hid_revised_collect_date\' id=\'hid_revised_collect_date\' value=\"";
    private final static byte[]  _wl_block665Bytes = _getBytes( _wl_block665 );

    private final static java.lang.String  _wl_block666 ="\">\n";
    private final static byte[]  _wl_block666Bytes = _getBytes( _wl_block666 );

    private final static java.lang.String  _wl_block667 ="\n\n<!-- ===== Common address component fields ===== -->\n\t<input type=\'hidden\' name=\'change_address\' id=\'change_address\' value=\'\'>\n\t<input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\'\'>\t\t\n\t<input type=\'hidden\' name=\'concat_NatIdDetails_hidden\' id=\'concat_NatIdDetails_hidden\' value=\'\'>\t\t\n\t<input type=\'hidden\' name=\'addr1_type\' id=\'addr1_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'addr_line1\' id=\'addr_line1\' value=\'\' >\n\t<input type=\'hidden\' name=\'addr_line2\' id=\'addr_line2\' value=\'\' >\n\t<input type=\'hidden\' name=\'addr_line3\' id=\'addr_line3\' value=\'\' >\n\t<input type=\'hidden\' name=\'addr_line4\' id=\'addr_line4\' value=\'\' >\n\t<input type=\'hidden\' name=\'res_town_code\' id=\'res_town_code\' value=\'\' >\n\t<input type=\'hidden\' name=\'res_town_desc\' id=\'res_town_desc\' value=\'\' >\n\t<input type=\'hidden\' name=\'res_area_code\' id=\'res_area_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'res_area_desc\' id=\'res_area_desc\' value=\'\'>\n\t<input type=\'hidden\' name=\'postal_code\' id=\'postal_code\' value=\'\' >\t\n\t<input type=\'hidden\' name=\'region_code\' id=\'region_code\' value=\'\' >\t\n\t<input type=\'hidden\' name=\'region_desc\' id=\'region_desc\' value=\'\' >\t\n\t<input type=\'hidden\' name=\'country_code\' id=\'country_code\' value=\'\' >\n\t<input type=\'hidden\' name=\'country_desc\' id=\'country_desc\' value=\'\'>\n\t<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'invalid1_yn\' id=\'invalid1_yn\' value=\'\'>\n\t<input type=\'hidden\' name=\'addr2_type\' id=\'addr2_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'mail_addr_line1\' id=\'mail_addr_line1\'  value=\'\'>\n\t<input type=\'hidden\' name=\'mail_addr_line2\' id=\'mail_addr_line2\'  value=\'\'>\n\t<input type=\'hidden\' name=\'mail_addr_line3\' id=\'mail_addr_line3\' value=\'\' >\n\t<input type=\'hidden\' name=\'mail_addr_line4\' id=\'mail_addr_line4\' value=\'\' >\n\t<input type=\'hidden\' name=\'mail_res_town_code\' id=\'mail_res_town_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'mail_res_town_desc\' id=\'mail_res_town_desc\' value=\'\' >\n\t<input type=\'hidden\' name=\'mail_res_area_code\' id=\'mail_res_area_code\' value=\'\' >\n\t<input type=\'hidden\' name=\'mail_res_area_desc\' id=\'mail_res_area_desc\' value=\'\' >\n\t<input type=\'hidden\' name=\'mail_postal_code\' id=\'mail_postal_code\' value=\'\' >\n\t<input type=\'hidden\' name=\'mail_region_code\' id=\'mail_region_code\' value=\'\' >\n\t<input type=\'hidden\' name=\'mail_region_desc\' id=\'mail_region_desc\' value=\'\' >\n\t<input type=\'hidden\' name=\'mail_country_code\' id=\'mail_country_code\' value=\'\'>\n\t<input type=\'hidden\' name =\'mail_country_desc\' value=\'\'>\n\t<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'invalid2_yn\' id=\'invalid2_yn\' value=\'\'>\n\t<input type=\'hidden\' name=\'contact1_no\' id=\'contact1_no\' value=\'\'>\n\t<input type=\'hidden\' name=\'contact2_no\' id=\'contact2_no\' value=\'\'>\n\t<input type=\'hidden\' name=\'email\' id=\'email\' value=\'\'>\n\t<input type=\'hidden\' name=\'Pat_name\' id=\'Pat_name\' value=\'";
    private final static byte[]  _wl_block667Bytes = _getBytes( _wl_block667 );

    private final static java.lang.String  _wl_block668 ="\'>\n\t<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\'";
    private final static byte[]  _wl_block668Bytes = _getBytes( _wl_block668 );

    private final static java.lang.String  _wl_block669 ="\'>\n\t<input type=\'hidden\' name=\'classification_appl_yn\' id=\'classification_appl_yn\' value=\'";
    private final static byte[]  _wl_block669Bytes = _getBytes( _wl_block669 );

    private final static java.lang.String  _wl_block670 ="\'> <!-- added by mujafar for ML-MMOH-CRF-0762 start -->\n\t<input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\'";
    private final static byte[]  _wl_block670Bytes = _getBytes( _wl_block670 );

    private final static java.lang.String  _wl_block671 ="\'>\n\t<input type=\'hidden\' name=\'oth_alt_id_type\' id=\'oth_alt_id_type\' value=\'";
    private final static byte[]  _wl_block671Bytes = _getBytes( _wl_block671 );

    private final static java.lang.String  _wl_block672 ="\'>\n\t<input type=\'hidden\' name=\'oth_alt_id_no\' id=\'oth_alt_id_no\' value=\'";
    private final static byte[]  _wl_block672Bytes = _getBytes( _wl_block672 );

    private final static java.lang.String  _wl_block673 ="\'>\n\t<input type=\'hidden\' name=\'req_type_status\' id=\'req_type_status\' value=\'\'>\n\t<input type=\'hidden\' name=\'oth_alt_type\' id=\'oth_alt_type\' value=\'";
    private final static byte[]  _wl_block673Bytes = _getBytes( _wl_block673 );

    private final static java.lang.String  _wl_block674 ="\'> \n\t<input type=\'hidden\' name=\'oth_alt_id\' id=\'oth_alt_id\' value=\'";
    private final static byte[]  _wl_block674Bytes = _getBytes( _wl_block674 );

    private final static java.lang.String  _wl_block675 ="\' > \n\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block675Bytes = _getBytes( _wl_block675 );

    private final static java.lang.String  _wl_block676 ="\' > <!-- added by mujafar for ML-MMOH-CRF-0762 end -->\n\n\t<!-- ADDRESS FIELDS FOR APPLICANT ... -->\n\t<input type=\'hidden\' name=\'appl_addr_line1\' id=\'appl_addr_line1\' value=\"";
    private final static byte[]  _wl_block676Bytes = _getBytes( _wl_block676 );

    private final static java.lang.String  _wl_block677 ="\" >\n\t<input type=\'hidden\' name=\'appl_addr_line2\' id=\'appl_addr_line2\' value=\"";
    private final static byte[]  _wl_block677Bytes = _getBytes( _wl_block677 );

    private final static java.lang.String  _wl_block678 ="\" >\n\t<input type=\'hidden\' name=\'appl_addr_line3\' id=\'appl_addr_line3\' value=\"";
    private final static byte[]  _wl_block678Bytes = _getBytes( _wl_block678 );

    private final static java.lang.String  _wl_block679 ="\" >\n\t<input type=\'hidden\' name=\'appl_addr_line4\' id=\'appl_addr_line4\' value=\"";
    private final static byte[]  _wl_block679Bytes = _getBytes( _wl_block679 );

    private final static java.lang.String  _wl_block680 ="\" >\n\t<input type=\'hidden\' name=\'appl_res_town_code\' id=\'appl_res_town_code\' value=\"";
    private final static byte[]  _wl_block680Bytes = _getBytes( _wl_block680 );

    private final static java.lang.String  _wl_block681 ="\" >\n\t<input type=\'hidden\' name=\'appl_res_town_desc\' id=\'appl_res_town_desc\' value=\"";
    private final static byte[]  _wl_block681Bytes = _getBytes( _wl_block681 );

    private final static java.lang.String  _wl_block682 ="\" >\n\t<input type=\'hidden\' name=\'appl_res_area_code\' id=\'appl_res_area_code\' value=\"";
    private final static byte[]  _wl_block682Bytes = _getBytes( _wl_block682 );

    private final static java.lang.String  _wl_block683 ="\" >\n\t<input type=\'hidden\' name=\'appl_res_area_desc\' id=\'appl_res_area_desc\' value=\"";
    private final static byte[]  _wl_block683Bytes = _getBytes( _wl_block683 );

    private final static java.lang.String  _wl_block684 ="\" >\n\t<input type=\'hidden\' name=\'appl_region_code\' id=\'appl_region_code\' value=\"";
    private final static byte[]  _wl_block684Bytes = _getBytes( _wl_block684 );

    private final static java.lang.String  _wl_block685 ="\" >\n\t<input type=\'hidden\' name=\'appl_region_desc\' id=\'appl_region_desc\' value=\"";
    private final static byte[]  _wl_block685Bytes = _getBytes( _wl_block685 );

    private final static java.lang.String  _wl_block686 ="\" >\n\t<input type=\'hidden\' name=\'appl_postal_code\' id=\'appl_postal_code\' value=\"";
    private final static byte[]  _wl_block686Bytes = _getBytes( _wl_block686 );

    private final static java.lang.String  _wl_block687 ="\" >\n\t<input type=\'hidden\' name=\'appl_postal_desc\' id=\'appl_postal_desc\' value=\"";
    private final static byte[]  _wl_block687Bytes = _getBytes( _wl_block687 );

    private final static java.lang.String  _wl_block688 ="\" >\n\t<input type=\'hidden\' name=\'appl_country_desc\' id=\'appl_country_desc\' value=\"";
    private final static byte[]  _wl_block688Bytes = _getBytes( _wl_block688 );

    private final static java.lang.String  _wl_block689 ="\" >\n\t<input type=\'hidden\' name=\'appl_country_code\' id=\'appl_country_code\' value=\"";
    private final static byte[]  _wl_block689Bytes = _getBytes( _wl_block689 );

    private final static java.lang.String  _wl_block690 ="\" >\n\n\t<!-- ADDRESS FIELDS FOR OTHERS ... -->\n\t<input type=\'hidden\' name=\'Oth_appl_addr_line1\' id=\'Oth_appl_addr_line1\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_addr_line2\' id=\'Oth_appl_addr_line2\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_addr_line3\' id=\'Oth_appl_addr_line3\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_addr_line4\' id=\'Oth_appl_addr_line4\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_res_town_desc\' id=\'Oth_appl_res_town_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_res_town_code\' id=\'Oth_appl_res_town_code\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_res_area_desc\' id=\'Oth_appl_res_area_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_res_area_code\' id=\'Oth_appl_res_area_code\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_region_desc\' id=\'Oth_appl_region_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_region_code\' id=\'Oth_appl_region_code\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_postal_desc\' id=\'Oth_appl_postal_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_postal_code\' id=\'Oth_appl_postal_code\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_country_desc\' id=\'Oth_appl_country_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'Oth_appl_country_code\' id=\'Oth_appl_country_code\' value=\"\">\n\n\t<!-- ADDRESS FIELDS FOR PERSONAL DELIVERY ... -->\n\t<input type=\'hidden\' name=\'personal_del_addr_line1\' id=\'personal_del_addr_line1\' value=\"";
    private final static byte[]  _wl_block690Bytes = _getBytes( _wl_block690 );

    private final static java.lang.String  _wl_block691 ="\">\n\t<input type=\'hidden\' name=\'personal_del_addr_line2\' id=\'personal_del_addr_line2\' value=\"";
    private final static byte[]  _wl_block691Bytes = _getBytes( _wl_block691 );

    private final static java.lang.String  _wl_block692 ="\">\n\t<input type=\'hidden\' name=\'personal_del_addr_line3\' id=\'personal_del_addr_line3\' value=\"";
    private final static byte[]  _wl_block692Bytes = _getBytes( _wl_block692 );

    private final static java.lang.String  _wl_block693 ="\">\n\t<input type=\'hidden\' name=\'personal_del_addr_line4\' id=\'personal_del_addr_line4\' value=\"";
    private final static byte[]  _wl_block693Bytes = _getBytes( _wl_block693 );

    private final static java.lang.String  _wl_block694 ="\">\n\t<input type=\'hidden\' name=\'personal_del_res_town_desc\' id=\'personal_del_res_town_desc\' value=\"";
    private final static byte[]  _wl_block694Bytes = _getBytes( _wl_block694 );

    private final static java.lang.String  _wl_block695 ="\">\n\t<input type=\'hidden\' name=\'personal_del_res_town_code\' id=\'personal_del_res_town_code\' value=\"";
    private final static byte[]  _wl_block695Bytes = _getBytes( _wl_block695 );

    private final static java.lang.String  _wl_block696 ="\">\n\t<input type=\'hidden\' name=\'personal_del_res_area_desc\' id=\'personal_del_res_area_desc\' value=\"";
    private final static byte[]  _wl_block696Bytes = _getBytes( _wl_block696 );

    private final static java.lang.String  _wl_block697 ="\">\n\t<input type=\'hidden\' name=\'personal_del_res_area_code\' id=\'personal_del_res_area_code\' value=\"";
    private final static byte[]  _wl_block697Bytes = _getBytes( _wl_block697 );

    private final static java.lang.String  _wl_block698 ="\">\n\t<input type=\'hidden\' name=\'personal_del_region_desc\' id=\'personal_del_region_desc\' value=\"";
    private final static byte[]  _wl_block698Bytes = _getBytes( _wl_block698 );

    private final static java.lang.String  _wl_block699 ="\">\n\t<input type=\'hidden\' name=\'personal_del_region_code\' id=\'personal_del_region_code\' value=\"";
    private final static byte[]  _wl_block699Bytes = _getBytes( _wl_block699 );

    private final static java.lang.String  _wl_block700 ="\">\n\t<input type=\'hidden\' name=\'personal_del_postal_desc\' id=\'personal_del_postal_desc\' value=\"";
    private final static byte[]  _wl_block700Bytes = _getBytes( _wl_block700 );

    private final static java.lang.String  _wl_block701 ="\">\n\t<input type=\'hidden\' name=\'personal_del_postal_code\' id=\'personal_del_postal_code\' value=\"";
    private final static byte[]  _wl_block701Bytes = _getBytes( _wl_block701 );

    private final static java.lang.String  _wl_block702 ="\">\n\t<input type=\'hidden\' name=\'personal_del_country_desc\' id=\'personal_del_country_desc\' value=\"";
    private final static byte[]  _wl_block702Bytes = _getBytes( _wl_block702 );

    private final static java.lang.String  _wl_block703 ="\">\n\t<input type=\'hidden\' name=\'personal_del_country_code\' id=\'personal_del_country_code\' value=\"";
    private final static byte[]  _wl_block703Bytes = _getBytes( _wl_block703 );

    private final static java.lang.String  _wl_block704 ="\">\n\n\n<!-- ADDRESS FIELDS FOR Requestor DELIVERY ... -->\n\t<input type=\'hidden\' name=\'requestor_addr_line1\' id=\'requestor_addr_line1\' value=\"";
    private final static byte[]  _wl_block704Bytes = _getBytes( _wl_block704 );

    private final static java.lang.String  _wl_block705 ="\">\n\t<input type=\'hidden\' name=\'requestor_addr_line2\' id=\'requestor_addr_line2\' value=\"";
    private final static byte[]  _wl_block705Bytes = _getBytes( _wl_block705 );

    private final static java.lang.String  _wl_block706 ="\">\n\t<input type=\'hidden\' name=\'requestor_addr_line3\' id=\'requestor_addr_line3\' value=\"";
    private final static byte[]  _wl_block706Bytes = _getBytes( _wl_block706 );

    private final static java.lang.String  _wl_block707 ="\">\n\t<input type=\'hidden\' name=\'requestor_addr_line4\' id=\'requestor_addr_line4\' value=\"";
    private final static byte[]  _wl_block707Bytes = _getBytes( _wl_block707 );

    private final static java.lang.String  _wl_block708 ="\">\n\t<input type=\'hidden\' name=\'requestor_res_town_desc\' id=\'requestor_res_town_desc\' value=\"";
    private final static byte[]  _wl_block708Bytes = _getBytes( _wl_block708 );

    private final static java.lang.String  _wl_block709 ="\">\n\t<input type=\'hidden\' name=\'requestor_res_town_code\' id=\'requestor_res_town_code\' value=\"";
    private final static byte[]  _wl_block709Bytes = _getBytes( _wl_block709 );

    private final static java.lang.String  _wl_block710 ="\">\n\t<input type=\'hidden\' name=\'requestor_res_area_desc\' id=\'requestor_res_area_desc\' value=\"";
    private final static byte[]  _wl_block710Bytes = _getBytes( _wl_block710 );

    private final static java.lang.String  _wl_block711 ="\">\n\t<input type=\'hidden\' name=\'requestor_res_area_code\' id=\'requestor_res_area_code\' value=\"";
    private final static byte[]  _wl_block711Bytes = _getBytes( _wl_block711 );

    private final static java.lang.String  _wl_block712 ="\">\n\t<input type=\'hidden\' name=\'requestor_region_desc\' id=\'requestor_region_desc\' value=\"";
    private final static byte[]  _wl_block712Bytes = _getBytes( _wl_block712 );

    private final static java.lang.String  _wl_block713 ="\">\n\t<input type=\'hidden\' name=\'requestor_region_code\' id=\'requestor_region_code\' value=\"";
    private final static byte[]  _wl_block713Bytes = _getBytes( _wl_block713 );

    private final static java.lang.String  _wl_block714 ="\">\n\t<input type=\'hidden\' name=\'requestor_postal_desc\' id=\'requestor_postal_desc\' value=\"";
    private final static byte[]  _wl_block714Bytes = _getBytes( _wl_block714 );

    private final static java.lang.String  _wl_block715 ="\">\n\t<input type=\'hidden\' name=\'requestor_postal_code\' id=\'requestor_postal_code\' value=\"";
    private final static byte[]  _wl_block715Bytes = _getBytes( _wl_block715 );

    private final static java.lang.String  _wl_block716 ="\">\n\t<input type=\'hidden\' name=\'requestor_country_desc\' id=\'requestor_country_desc\' value=\"";
    private final static byte[]  _wl_block716Bytes = _getBytes( _wl_block716 );

    private final static java.lang.String  _wl_block717 ="\">\n\t<input type=\'hidden\' name=\'requestor_country_code\' id=\'requestor_country_code\' value=\"";
    private final static byte[]  _wl_block717Bytes = _getBytes( _wl_block717 );

    private final static java.lang.String  _wl_block718 ="\">\n\n\t<!-- ADDRESS FIELDS FOR OTHER DELIVERY ... -->\n\t<input type=\'hidden\' name=\'other_del_addr_line1\' id=\'other_del_addr_line1\' value=\"";
    private final static byte[]  _wl_block718Bytes = _getBytes( _wl_block718 );

    private final static java.lang.String  _wl_block719 ="\">\n\t<input type=\'hidden\' name=\'other_del_addr_line2\' id=\'other_del_addr_line2\' value=\"";
    private final static byte[]  _wl_block719Bytes = _getBytes( _wl_block719 );

    private final static java.lang.String  _wl_block720 ="\">\n\t<input type=\'hidden\' name=\'other_del_addr_line3\' id=\'other_del_addr_line3\' value=\"";
    private final static byte[]  _wl_block720Bytes = _getBytes( _wl_block720 );

    private final static java.lang.String  _wl_block721 ="\">\n\t<input type=\'hidden\' name=\'other_del_addr_line4\' id=\'other_del_addr_line4\' value=\"";
    private final static byte[]  _wl_block721Bytes = _getBytes( _wl_block721 );

    private final static java.lang.String  _wl_block722 ="\">\n\t<input type=\'hidden\' name=\'other_del_res_town_desc\' id=\'other_del_res_town_desc\' value=\"";
    private final static byte[]  _wl_block722Bytes = _getBytes( _wl_block722 );

    private final static java.lang.String  _wl_block723 ="\">\n\t<input type=\'hidden\' name=\'other_del_res_town_code\' id=\'other_del_res_town_code\' value=\"";
    private final static byte[]  _wl_block723Bytes = _getBytes( _wl_block723 );

    private final static java.lang.String  _wl_block724 ="\">\n\t<input type=\'hidden\' name=\'other_del_res_area_desc\' id=\'other_del_res_area_desc\' value=\"";
    private final static byte[]  _wl_block724Bytes = _getBytes( _wl_block724 );

    private final static java.lang.String  _wl_block725 ="\">\n\t<input type=\'hidden\' name=\'other_del_res_area_code\' id=\'other_del_res_area_code\' value=\"";
    private final static byte[]  _wl_block725Bytes = _getBytes( _wl_block725 );

    private final static java.lang.String  _wl_block726 ="\">\n\t<input type=\'hidden\' name=\'other_del_region_desc\' id=\'other_del_region_desc\' value=\"";
    private final static byte[]  _wl_block726Bytes = _getBytes( _wl_block726 );

    private final static java.lang.String  _wl_block727 ="\">\n\t<input type=\'hidden\' name=\'other_del_region_code\' id=\'other_del_region_code\' value=\"";
    private final static byte[]  _wl_block727Bytes = _getBytes( _wl_block727 );

    private final static java.lang.String  _wl_block728 ="\">\n\t<input type=\'hidden\' name=\'other_del_postal_desc\' id=\'other_del_postal_desc\' value=\"";
    private final static byte[]  _wl_block728Bytes = _getBytes( _wl_block728 );

    private final static java.lang.String  _wl_block729 ="\">\n\t<input type=\'hidden\' name=\'other_del_postal_code\' id=\'other_del_postal_code\' value=\"";
    private final static byte[]  _wl_block729Bytes = _getBytes( _wl_block729 );

    private final static java.lang.String  _wl_block730 ="\">\n\t<input type=\'hidden\' name=\'other_del_country_desc\' id=\'other_del_country_desc\' value=\"";
    private final static byte[]  _wl_block730Bytes = _getBytes( _wl_block730 );

    private final static java.lang.String  _wl_block731 ="\">\n\t<input type=\'hidden\' name=\'other_del_country_code\' id=\'other_del_country_code\' value=\"";
    private final static byte[]  _wl_block731Bytes = _getBytes( _wl_block731 );

    private final static java.lang.String  _wl_block732 ="\">\n\n\t<!-- ADDRESS FIELDS FOR NKIN ...  -->\n\t<input type=\'hidden\' name=\'nkin_addr_line1\' id=\'nkin_addr_line1\' value=\"";
    private final static byte[]  _wl_block732Bytes = _getBytes( _wl_block732 );

    private final static java.lang.String  _wl_block733 ="\">\n\t<input type=\'hidden\' name=\'nkin_addr_line2\' id=\'nkin_addr_line2\' value=\"";
    private final static byte[]  _wl_block733Bytes = _getBytes( _wl_block733 );

    private final static java.lang.String  _wl_block734 ="\">\n\t<input type=\'hidden\' name=\'nkin_addr_line3\' id=\'nkin_addr_line3\' value=\"";
    private final static byte[]  _wl_block734Bytes = _getBytes( _wl_block734 );

    private final static java.lang.String  _wl_block735 ="\">\n\t<input type=\'hidden\' name=\'nkin_addr_line4\' id=\'nkin_addr_line4\' value=\"";
    private final static byte[]  _wl_block735Bytes = _getBytes( _wl_block735 );

    private final static java.lang.String  _wl_block736 ="\">\n\t<input type=\'hidden\' name=\'nkin_res_town_desc\' id=\'nkin_res_town_desc\' value=\"";
    private final static byte[]  _wl_block736Bytes = _getBytes( _wl_block736 );

    private final static java.lang.String  _wl_block737 ="\">\n\t<input type=\'hidden\' name=\'nkin_res_town_code\' id=\'nkin_res_town_code\' value=\"";
    private final static byte[]  _wl_block737Bytes = _getBytes( _wl_block737 );

    private final static java.lang.String  _wl_block738 ="\">\n\t<input type=\'hidden\' name=\'nkin_res_area_desc\' id=\'nkin_res_area_desc\' value=\"";
    private final static byte[]  _wl_block738Bytes = _getBytes( _wl_block738 );

    private final static java.lang.String  _wl_block739 ="\">\n\t<input type=\'hidden\' name=\'nkin_res_area_code\' id=\'nkin_res_area_code\' value=\"";
    private final static byte[]  _wl_block739Bytes = _getBytes( _wl_block739 );

    private final static java.lang.String  _wl_block740 ="\">\n\t<input type=\'hidden\' name=\'nkin_region_desc\' id=\'nkin_region_desc\' value=\"";
    private final static byte[]  _wl_block740Bytes = _getBytes( _wl_block740 );

    private final static java.lang.String  _wl_block741 ="\">\n\t<input type=\'hidden\' name=\'nkin_region_code\' id=\'nkin_region_code\' value=\"";
    private final static byte[]  _wl_block741Bytes = _getBytes( _wl_block741 );

    private final static java.lang.String  _wl_block742 ="\">\n\t<input type=\'hidden\' name=\'nkin_postal_desc\' id=\'nkin_postal_desc\' value=\"";
    private final static byte[]  _wl_block742Bytes = _getBytes( _wl_block742 );

    private final static java.lang.String  _wl_block743 ="\"> \n\t<input type=\'hidden\' name=\'nkin_postal_code\' id=\'nkin_postal_code\' value=\"";
    private final static byte[]  _wl_block743Bytes = _getBytes( _wl_block743 );

    private final static java.lang.String  _wl_block744 ="\"> \n\t<input type=\'hidden\' name=\'nkin_country_desc\' id=\'nkin_country_desc\' value=\"";
    private final static byte[]  _wl_block744Bytes = _getBytes( _wl_block744 );

    private final static java.lang.String  _wl_block745 ="\"> \n\t<input type=\'hidden\' name=\'nkin_country_code\' id=\'nkin_country_code\' value=\"";
    private final static byte[]  _wl_block745Bytes = _getBytes( _wl_block745 );

    private final static java.lang.String  _wl_block746 ="\"> \n\n\t<!-- ADDRESS FIELDS FOR FTON ...  -->\n\t<input type=\'hidden\' name=\'fton_addr_line1\' id=\'fton_addr_line1\' value=\"";
    private final static byte[]  _wl_block746Bytes = _getBytes( _wl_block746 );

    private final static java.lang.String  _wl_block747 ="\">\n\t<input type=\'hidden\' name=\'fton_addr_line2\' id=\'fton_addr_line2\' value=\"";
    private final static byte[]  _wl_block747Bytes = _getBytes( _wl_block747 );

    private final static java.lang.String  _wl_block748 ="\">\n\t<input type=\'hidden\' name=\'fton_addr_line3\' id=\'fton_addr_line3\' value=\"";
    private final static byte[]  _wl_block748Bytes = _getBytes( _wl_block748 );

    private final static java.lang.String  _wl_block749 ="\">\n\t<input type=\'hidden\' name=\'fton_addr_line4\' id=\'fton_addr_line4\' value=\"";
    private final static byte[]  _wl_block749Bytes = _getBytes( _wl_block749 );

    private final static java.lang.String  _wl_block750 ="\">\n\t<input type=\'hidden\' name=\'fton_res_town_desc\' id=\'fton_res_town_desc\' value=\"";
    private final static byte[]  _wl_block750Bytes = _getBytes( _wl_block750 );

    private final static java.lang.String  _wl_block751 ="\">\n\t<input type=\'hidden\' name=\'fton_res_town_code\' id=\'fton_res_town_code\' value=\"";
    private final static byte[]  _wl_block751Bytes = _getBytes( _wl_block751 );

    private final static java.lang.String  _wl_block752 ="\">\n\t<input type=\'hidden\' name=\'fton_res_area_desc\' id=\'fton_res_area_desc\' value=\"";
    private final static byte[]  _wl_block752Bytes = _getBytes( _wl_block752 );

    private final static java.lang.String  _wl_block753 ="\">\n\t<input type=\'hidden\' name=\'fton_res_area_code\' id=\'fton_res_area_code\' value=\"";
    private final static byte[]  _wl_block753Bytes = _getBytes( _wl_block753 );

    private final static java.lang.String  _wl_block754 ="\">\n\t<input type=\'hidden\' name=\'fton_region_desc\' id=\'fton_region_desc\' value=\"";
    private final static byte[]  _wl_block754Bytes = _getBytes( _wl_block754 );

    private final static java.lang.String  _wl_block755 ="\">\n\t<input type=\'hidden\' name=\'fton_region_code\' id=\'fton_region_code\' value=\"";
    private final static byte[]  _wl_block755Bytes = _getBytes( _wl_block755 );

    private final static java.lang.String  _wl_block756 ="\">\n\t<input type=\'hidden\' name=\'fton_postal_desc\' id=\'fton_postal_desc\' value=\"";
    private final static byte[]  _wl_block756Bytes = _getBytes( _wl_block756 );

    private final static java.lang.String  _wl_block757 ="\"> \n\t<input type=\'hidden\' name=\'fton_postal_code\' id=\'fton_postal_code\' value=\"";
    private final static byte[]  _wl_block757Bytes = _getBytes( _wl_block757 );

    private final static java.lang.String  _wl_block758 ="\"> \n\t<input type=\'hidden\' name=\'fton_country_desc\' id=\'fton_country_desc\' value=\"";
    private final static byte[]  _wl_block758Bytes = _getBytes( _wl_block758 );

    private final static java.lang.String  _wl_block759 ="\"> \n\t<input type=\'hidden\' name=\'fton_country_code\' id=\'fton_country_code\' value=\"";
    private final static byte[]  _wl_block759Bytes = _getBytes( _wl_block759 );

    private final static java.lang.String  _wl_block760 ="\"> \n\n\t<!-- ADDRESS FIELDS FOR EMPLR ...  -->\n\t<input type=\'hidden\' name=\'emplr_addr_line1\' id=\'emplr_addr_line1\' value=\"";
    private final static byte[]  _wl_block760Bytes = _getBytes( _wl_block760 );

    private final static java.lang.String  _wl_block761 ="\">\n\t<input type=\'hidden\' name=\'emplr_addr_line2\' id=\'emplr_addr_line2\' value=\"";
    private final static byte[]  _wl_block761Bytes = _getBytes( _wl_block761 );

    private final static java.lang.String  _wl_block762 ="\">\n\t<input type=\'hidden\' name=\'emplr_addr_line3\' id=\'emplr_addr_line3\' value=\"";
    private final static byte[]  _wl_block762Bytes = _getBytes( _wl_block762 );

    private final static java.lang.String  _wl_block763 ="\">\n\t<input type=\'hidden\' name=\'emplr_addr_line4\' id=\'emplr_addr_line4\' value=\"";
    private final static byte[]  _wl_block763Bytes = _getBytes( _wl_block763 );

    private final static java.lang.String  _wl_block764 ="\">\n\t<input type=\'hidden\' name=\'emplr_res_town_desc\' id=\'emplr_res_town_desc\' value=\"";
    private final static byte[]  _wl_block764Bytes = _getBytes( _wl_block764 );

    private final static java.lang.String  _wl_block765 ="\">\n\t<input type=\'hidden\' name=\'emplr_res_town_code\' id=\'emplr_res_town_code\' value=\"";
    private final static byte[]  _wl_block765Bytes = _getBytes( _wl_block765 );

    private final static java.lang.String  _wl_block766 ="\">\n\t<input type=\'hidden\' name=\'emplr_res_area_desc\' id=\'emplr_res_area_desc\' value=\"";
    private final static byte[]  _wl_block766Bytes = _getBytes( _wl_block766 );

    private final static java.lang.String  _wl_block767 ="\">\n\t<input type=\'hidden\' name=\'emplr_res_area_code\' id=\'emplr_res_area_code\' value=\"";
    private final static byte[]  _wl_block767Bytes = _getBytes( _wl_block767 );

    private final static java.lang.String  _wl_block768 ="\">\n\t<input type=\'hidden\' name=\'emplr_region_desc\' id=\'emplr_region_desc\' value=\"";
    private final static byte[]  _wl_block768Bytes = _getBytes( _wl_block768 );

    private final static java.lang.String  _wl_block769 ="\">\n\t<input type=\'hidden\' name=\'emplr_region_code\' id=\'emplr_region_code\' value=\"";
    private final static byte[]  _wl_block769Bytes = _getBytes( _wl_block769 );

    private final static java.lang.String  _wl_block770 ="\">\n\t<input type=\'hidden\' name=\'emplr_postal_desc\' id=\'emplr_postal_desc\' value=\"";
    private final static byte[]  _wl_block770Bytes = _getBytes( _wl_block770 );

    private final static java.lang.String  _wl_block771 ="\"> \n\t<input type=\'hidden\' name=\'emplr_postal_code\' id=\'emplr_postal_code\' value=\"";
    private final static byte[]  _wl_block771Bytes = _getBytes( _wl_block771 );

    private final static java.lang.String  _wl_block772 ="\"> \n\t<input type=\'hidden\' name=\'emplr_country_desc\' id=\'emplr_country_desc\' value=\"";
    private final static byte[]  _wl_block772Bytes = _getBytes( _wl_block772 );

    private final static java.lang.String  _wl_block773 ="\"> \n\t<input type=\'hidden\' name=\'emplr_country_code\' id=\'emplr_country_code\' value=\"";
    private final static byte[]  _wl_block773Bytes = _getBytes( _wl_block773 );

    private final static java.lang.String  _wl_block774 ="\"> \n<!-- ===== Common address component fields ===== -->\n\n\t<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->\n\t<input type=\'hidden\' name=\'indicator_req\' id=\'indicator_req\' value=\"";
    private final static byte[]  _wl_block774Bytes = _getBytes( _wl_block774 );

    private final static java.lang.String  _wl_block775 ="\">  \n\t<input type=\'hidden\' name=\'requestor_type_ind\' id=\'requestor_type_ind\' value=\"";
    private final static byte[]  _wl_block775Bytes = _getBytes( _wl_block775 );

    private final static java.lang.String  _wl_block776 ="\"> <!-- added by mujafar for ML-MMOH-CRF-0762  -->\n\n\t<!--Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707-->\n\n\t<input type=\'hidden\' name=\'self_contact_no1\' id=\'self_contact_no1\' value=\"";
    private final static byte[]  _wl_block776Bytes = _getBytes( _wl_block776 );

    private final static java.lang.String  _wl_block777 ="\">\n\t<input type=\'hidden\' name=\'self_contact_no2\' id=\'self_contact_no2\' value=\"";
    private final static byte[]  _wl_block777Bytes = _getBytes( _wl_block777 );

    private final static java.lang.String  _wl_block778 ="\">\n\t<input type=\'hidden\' name=\'self_appl_email_id\' id=\'self_appl_email_id\' value=\"";
    private final static byte[]  _wl_block778Bytes = _getBytes( _wl_block778 );

    private final static java.lang.String  _wl_block779 ="\">\n\n\t<input type=\'hidden\' name=\'nkin_contact_no1\' id=\'nkin_contact_no1\' value=\"";
    private final static byte[]  _wl_block779Bytes = _getBytes( _wl_block779 );

    private final static java.lang.String  _wl_block780 ="\">\n\t<input type=\'hidden\' name=\'nkin_contact_no2\' id=\'nkin_contact_no2\' value=\"";
    private final static byte[]  _wl_block780Bytes = _getBytes( _wl_block780 );

    private final static java.lang.String  _wl_block781 ="\">\n\t<input type=\'hidden\' name=\'nkin_appl_email_id\' id=\'nkin_appl_email_id\' value=\"";
    private final static byte[]  _wl_block781Bytes = _getBytes( _wl_block781 );

    private final static java.lang.String  _wl_block782 ="\">\n\n\t<input type=\'hidden\' name=\'fton_contact_no1\' id=\'fton_contact_no1\' value=\"";
    private final static byte[]  _wl_block782Bytes = _getBytes( _wl_block782 );

    private final static java.lang.String  _wl_block783 ="\">\n\t<input type=\'hidden\' name=\'fton_contact_no2\' id=\'fton_contact_no2\' value=\"";
    private final static byte[]  _wl_block783Bytes = _getBytes( _wl_block783 );

    private final static java.lang.String  _wl_block784 ="\">\n\t<input type=\'hidden\' name=\'fton_appl_email_id\' id=\'fton_appl_email_id\' value=\"";
    private final static byte[]  _wl_block784Bytes = _getBytes( _wl_block784 );

    private final static java.lang.String  _wl_block785 ="\">\n\n\t<input type=\'hidden\' name=\'emplr_contact_no1\' id=\'emplr_contact_no1\' value=\"";
    private final static byte[]  _wl_block785Bytes = _getBytes( _wl_block785 );

    private final static java.lang.String  _wl_block786 ="\">\n\t<input type=\'hidden\' name=\'emplr_contact_no2\' id=\'emplr_contact_no2\' value=\"";
    private final static byte[]  _wl_block786Bytes = _getBytes( _wl_block786 );

    private final static java.lang.String  _wl_block787 ="\">\n\t<input type=\'hidden\' name=\'emplr_appl_email_id\' id=\'emplr_appl_email_id\' value=\"\">\n\n\t<input type=\'hidden\' name=\'other_contact_no1\' id=\'other_contact_no1\' value=\"\">\n\t<input type=\'hidden\' name=\'other_contact_no2\' id=\'other_contact_no2\' value=\"\">\n\t<input type=\'hidden\' name=\'other_appl_email_id\' id=\'other_appl_email_id\' value=\"\">\n\n\t<input type=\'hidden\' name=\'requestor_contact_no1\' id=\'requestor_contact_no1\' value=\"\">\n\t<input type=\'hidden\' name=\'requestor_contact_no2\' id=\'requestor_contact_no2\' value=\"\">\n\t<input type=\'hidden\' name=\'requestor_appl_email_id\' id=\'requestor_appl_email_id\' value=\"\">\n\t\n\t<input type=\'hidden\' name=\'other_application_ref_no\' id=\'other_application_ref_no\' value=\"";
    private final static byte[]  _wl_block787Bytes = _getBytes( _wl_block787 );

    private final static java.lang.String  _wl_block788 ="\"><!-- Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 -->\n\t<!--ML-MMOH-CRF-0707-->\n\t\n\t<input type=\'hidden\' name=\'temp_pract\' id=\'temp_pract\' value=\"\"> <!--added by mujafar for ML-MMOH-CRF-1302 -->\n\t\n\t<!--Below line added for this ML-MMOH-CRF-0860.2-->\n\t<input type=\'hidden\' name=\'increasedaddressLength\' id=\'increasedaddressLength\' value=\"";
    private final static byte[]  _wl_block788Bytes = _getBytes( _wl_block788 );

    private final static java.lang.String  _wl_block789 ="\"> \n\t<!--End this ML-MMOH-CRF-0860.2-->\n\t<input type=\'hidden\' name=\'tot_amount\' id=\'tot_amount\' value=\"";
    private final static byte[]  _wl_block789Bytes = _getBytes( _wl_block789 );

    private final static java.lang.String  _wl_block790 ="\" />\n\t\n<script>\n// Patient Address Details for Button ...\n\t//parent.DetailFrame.document.MedicalRecordReqForm.charges_appllicable= \"";
    private final static byte[]  _wl_block790Bytes = _getBytes( _wl_block790 );

    private final static java.lang.String  _wl_block791 ="\";\n\tdocument.forms[0].addr_line1.value=\"";
    private final static byte[]  _wl_block791Bytes = _getBytes( _wl_block791 );

    private final static java.lang.String  _wl_block792 ="\";\n\tdocument.forms[0].addr_line2.value=\"";
    private final static byte[]  _wl_block792Bytes = _getBytes( _wl_block792 );

    private final static java.lang.String  _wl_block793 ="\";\n\tdocument.forms[0].addr_line3.value=\"";
    private final static byte[]  _wl_block793Bytes = _getBytes( _wl_block793 );

    private final static java.lang.String  _wl_block794 ="\";\n\tdocument.forms[0].addr_line4.value=\"";
    private final static byte[]  _wl_block794Bytes = _getBytes( _wl_block794 );

    private final static java.lang.String  _wl_block795 ="\";\n\tdocument.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block795Bytes = _getBytes( _wl_block795 );

    private final static java.lang.String  _wl_block796 ="\";\n\tdocument.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block796Bytes = _getBytes( _wl_block796 );

    private final static java.lang.String  _wl_block797 ="\";\n\tdocument.forms[0].res_area_code.value=\"";
    private final static byte[]  _wl_block797Bytes = _getBytes( _wl_block797 );

    private final static java.lang.String  _wl_block798 ="\";\n\tdocument.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block798Bytes = _getBytes( _wl_block798 );

    private final static java.lang.String  _wl_block799 ="\";\n\tdocument.forms[0].region_code.value=\"";
    private final static byte[]  _wl_block799Bytes = _getBytes( _wl_block799 );

    private final static java.lang.String  _wl_block800 ="\";\n\tdocument.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block800Bytes = _getBytes( _wl_block800 );

    private final static java.lang.String  _wl_block801 ="\";\n\tdocument.forms[0].country_code.value=\"";
    private final static byte[]  _wl_block801Bytes = _getBytes( _wl_block801 );

    private final static java.lang.String  _wl_block802 ="\";\n\tdocument.forms[0].country_desc.value=\"";
    private final static byte[]  _wl_block802Bytes = _getBytes( _wl_block802 );

    private final static java.lang.String  _wl_block803 ="\";\n\tdocument.forms[0].postal_code.value=\"";
    private final static byte[]  _wl_block803Bytes = _getBytes( _wl_block803 );

    private final static java.lang.String  _wl_block804 ="\";\n\tdocument.forms[0].contact1_name.value=\"\";\n\tdocument.forms[0].addr2_type.value=\"\";\n\tdocument.forms[0].mail_addr_line1.value=\"";
    private final static byte[]  _wl_block804Bytes = _getBytes( _wl_block804 );

    private final static java.lang.String  _wl_block805 ="\";\n\tdocument.forms[0].mail_addr_line2.value=\"";
    private final static byte[]  _wl_block805Bytes = _getBytes( _wl_block805 );

    private final static java.lang.String  _wl_block806 ="\";\n\tdocument.forms[0].mail_addr_line3.value=\"";
    private final static byte[]  _wl_block806Bytes = _getBytes( _wl_block806 );

    private final static java.lang.String  _wl_block807 ="\";\n\tdocument.forms[0].mail_addr_line4.value=\"";
    private final static byte[]  _wl_block807Bytes = _getBytes( _wl_block807 );

    private final static java.lang.String  _wl_block808 ="\";\n\tdocument.forms[0].mail_res_town_code.value=\"";
    private final static byte[]  _wl_block808Bytes = _getBytes( _wl_block808 );

    private final static java.lang.String  _wl_block809 ="\";\n\tdocument.forms[0].mail_res_town_desc.value=\"";
    private final static byte[]  _wl_block809Bytes = _getBytes( _wl_block809 );

    private final static java.lang.String  _wl_block810 ="\";\n\tdocument.forms[0].mail_res_area_code.value=\"";
    private final static byte[]  _wl_block810Bytes = _getBytes( _wl_block810 );

    private final static java.lang.String  _wl_block811 ="\";\n\tdocument.forms[0].mail_res_area_desc.value=\"";
    private final static byte[]  _wl_block811Bytes = _getBytes( _wl_block811 );

    private final static java.lang.String  _wl_block812 ="\";\n\tdocument.forms[0].mail_postal_code.value=\"";
    private final static byte[]  _wl_block812Bytes = _getBytes( _wl_block812 );

    private final static java.lang.String  _wl_block813 ="\";\n\tdocument.forms[0].mail_region_code.value=\"";
    private final static byte[]  _wl_block813Bytes = _getBytes( _wl_block813 );

    private final static java.lang.String  _wl_block814 ="\";\n\tdocument.forms[0].mail_region_desc.value=\"";
    private final static byte[]  _wl_block814Bytes = _getBytes( _wl_block814 );

    private final static java.lang.String  _wl_block815 ="\";\n\tdocument.forms[0].mail_country_code.value=\"";
    private final static byte[]  _wl_block815Bytes = _getBytes( _wl_block815 );

    private final static java.lang.String  _wl_block816 ="\";\n\tdocument.forms[0].mail_country_desc.value=\"";
    private final static byte[]  _wl_block816Bytes = _getBytes( _wl_block816 );

    private final static java.lang.String  _wl_block817 ="\";\n\tdocument.forms[0].contact2_name.value=\"\";\n\tdocument.forms[0].contact1_no.value=\"";
    private final static byte[]  _wl_block817Bytes = _getBytes( _wl_block817 );

    private final static java.lang.String  _wl_block818 ="\";\n\tdocument.forms[0].contact2_no.value=\"";
    private final static byte[]  _wl_block818Bytes = _getBytes( _wl_block818 );

    private final static java.lang.String  _wl_block819 ="\";\t\n\tdocument.forms[0].email.value=\"";
    private final static byte[]  _wl_block819Bytes = _getBytes( _wl_block819 );

    private final static java.lang.String  _wl_block820 ="\";\n\t/*parent.DetailFrame.document.MedicalRecordReqForm.addr_line1=\"";
    private final static byte[]  _wl_block820Bytes = _getBytes( _wl_block820 );

    private final static java.lang.String  _wl_block821 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.addr_line2=\"";
    private final static byte[]  _wl_block821Bytes = _getBytes( _wl_block821 );

    private final static java.lang.String  _wl_block822 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.addr_line3=\"";
    private final static byte[]  _wl_block822Bytes = _getBytes( _wl_block822 );

    private final static java.lang.String  _wl_block823 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.addr_line4=\"";
    private final static byte[]  _wl_block823Bytes = _getBytes( _wl_block823 );

    private final static java.lang.String  _wl_block824 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.res_town_code=\"";
    private final static byte[]  _wl_block824Bytes = _getBytes( _wl_block824 );

    private final static java.lang.String  _wl_block825 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.res_town_desc=\"";
    private final static byte[]  _wl_block825Bytes = _getBytes( _wl_block825 );

    private final static java.lang.String  _wl_block826 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.res_area_code=\"";
    private final static byte[]  _wl_block826Bytes = _getBytes( _wl_block826 );

    private final static java.lang.String  _wl_block827 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.res_area_desc=\"";
    private final static byte[]  _wl_block827Bytes = _getBytes( _wl_block827 );

    private final static java.lang.String  _wl_block828 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.region_code=\"";
    private final static byte[]  _wl_block828Bytes = _getBytes( _wl_block828 );

    private final static java.lang.String  _wl_block829 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.region_desc=\"";
    private final static byte[]  _wl_block829Bytes = _getBytes( _wl_block829 );

    private final static java.lang.String  _wl_block830 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.country_code=\"";
    private final static byte[]  _wl_block830Bytes = _getBytes( _wl_block830 );

    private final static java.lang.String  _wl_block831 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.country_desc=\"";
    private final static byte[]  _wl_block831Bytes = _getBytes( _wl_block831 );

    private final static java.lang.String  _wl_block832 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.postal_code=\"";
    private final static byte[]  _wl_block832Bytes = _getBytes( _wl_block832 );

    private final static java.lang.String  _wl_block833 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.contact1_name=\"\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.addr2_type=\"\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_addr_line1=\"";
    private final static byte[]  _wl_block833Bytes = _getBytes( _wl_block833 );

    private final static java.lang.String  _wl_block834 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_addr_line2=\"";
    private final static byte[]  _wl_block834Bytes = _getBytes( _wl_block834 );

    private final static java.lang.String  _wl_block835 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_addr_line3=\"";
    private final static byte[]  _wl_block835Bytes = _getBytes( _wl_block835 );

    private final static java.lang.String  _wl_block836 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_addr_line4=\"";
    private final static byte[]  _wl_block836Bytes = _getBytes( _wl_block836 );

    private final static java.lang.String  _wl_block837 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_res_town_code=\"";
    private final static byte[]  _wl_block837Bytes = _getBytes( _wl_block837 );

    private final static java.lang.String  _wl_block838 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_res_town_desc=\"";
    private final static byte[]  _wl_block838Bytes = _getBytes( _wl_block838 );

    private final static java.lang.String  _wl_block839 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_res_area_code=\"";
    private final static byte[]  _wl_block839Bytes = _getBytes( _wl_block839 );

    private final static java.lang.String  _wl_block840 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_res_area_desc=\"";
    private final static byte[]  _wl_block840Bytes = _getBytes( _wl_block840 );

    private final static java.lang.String  _wl_block841 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_country_code=\"";
    private final static byte[]  _wl_block841Bytes = _getBytes( _wl_block841 );

    private final static java.lang.String  _wl_block842 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_postal_code=\"";
    private final static byte[]  _wl_block842Bytes = _getBytes( _wl_block842 );

    private final static java.lang.String  _wl_block843 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_region_code=\"";
    private final static byte[]  _wl_block843Bytes = _getBytes( _wl_block843 );

    private final static java.lang.String  _wl_block844 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_region_desc=\"";
    private final static byte[]  _wl_block844Bytes = _getBytes( _wl_block844 );

    private final static java.lang.String  _wl_block845 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.mail_country_desc=\"";
    private final static byte[]  _wl_block845Bytes = _getBytes( _wl_block845 );

    private final static java.lang.String  _wl_block846 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.contact2_name=\"\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.contact1_no=\"";
    private final static byte[]  _wl_block846Bytes = _getBytes( _wl_block846 );

    private final static java.lang.String  _wl_block847 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.contact2_no=\"";
    private final static byte[]  _wl_block847Bytes = _getBytes( _wl_block847 );

    private final static java.lang.String  _wl_block848 ="\";\n\tparent.DetailFrame.document.MedicalRecordReqForm.email=\"";
    private final static byte[]  _wl_block848Bytes = _getBytes( _wl_block848 );

    private final static java.lang.String  _wl_block849 ="\";*/\n// End of Address Details Display \n</script>\n\n";
    private final static byte[]  _wl_block849Bytes = _getBytes( _wl_block849 );

    private final static java.lang.String  _wl_block850 ="\n\n\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block850Bytes = _getBytes( _wl_block850 );

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


	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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


/**
 *	MODULE			:	Medical Records..(MR)
 *	Function Name	:	Medical Report
 *	[Request/Prepare/Status/Forward/Receive/Deliver/Revise]
 *	Created On		:	22 JULY 2004
 *	Created By		:	SRIDHAR R

 *	CALL_FUNCTION && REQUEST_STATUS
	******************************
 *	MEDICAL_REPORT_REQUEST 	-  1
 *	MEDICAL_REPORT_STATUS 	-  2
 *  	FORWARD_TO_HOD		-  9 Added By Dharma
 *  	REQUEST_RETURNED	-  10 Added By Dharma 
 * 	 REQUEST_ACCEPTED	-  11 Added By Dharma
 *	FORWARD_MEDICAL_REPORT	-  3
 *	PREPARE_MEDICAL_REPORT	-  4
 *	RECEIVE_MEDICAL_REPORT 	-  5
 *	DELIVER_MEDICAL_REPORT 	-  6
 *	REVISE_MEDICAL_REPORT 	-  7
**/
//isAcceptRequestByPractAppl - Used for ML-MMOH-CRF-1473 & ML-MMOH-CRF-1314 - Dharma

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);
 String Facility_Id = (String) session.getValue("facility_id");
            _bw.write(_wl_block0Bytes, _wl_block0);
 String locale = (String) session.getValue("LOCALE");
            _bw.write(_wl_block0Bytes, _wl_block0);
 String loginUser = (String) session.getValue("login_user");
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block0Bytes, _wl_block0);
 request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            _bw.write(_wl_block7_2Bytes, _wl_block7_2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
   java.util.Properties propertiesBill = (java.util.Properties) session.getValue( "jdbc" );//Added By Ashwini on 20-Jun-2022 for ML-MMOH-CRF-1905

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);
            _bw.write(_wl_block9_2Bytes, _wl_block9_2);
            _bw.write(_wl_block9_3Bytes, _wl_block9_3);
            _bw.write(_wl_block9_4Bytes, _wl_block9_4);
//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	Statement appl_typeStmt = null;
	ResultSet appl_typeRS = null;

	Statement oth_stmt = null;
	ResultSet oth_rset = null;
	StringBuffer sqlBuff=new StringBuffer();
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	String medrep_pay_int_mode = "X";
	
	String no_of_days = "";
	String SystemDate		= "";
	String SystemDate_display = "";
	String disable1="";
	Boolean isIncompReqCancelApplicable = false;//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
	Boolean   isRejectRequestApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0713
	Boolean isMedicalReportDurationAppl = false; //  Added by Shaik Mujafar for ML-MMOH-CRF-0704

	Boolean isChckLstApplicable = false; //Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708
	
	Boolean isMedicalReportRequest = false; //Added for this CRF ML-MMOH-CRF-0712
	
	Boolean isSelfStatusMRPApplicable = false; //  Added by Mujafar for ML-MMOH-CRF-0718
	Boolean isRejectReportApplicable = false; //  Added by Mujafar for ML-MMOH-CRF-0714
	Boolean isMedicalTeamApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0716	
	boolean increasedaddressLength = false; //Added for this CRF ML-MMOH-CRF-0860.2
	Boolean classification_appl_yn = false; //Added for this CRF ML-MMOH-CRF-0762
	Boolean isAcceptRequestByPractAppl = false; // added by mujafar for ML-MMOH-CRF-1315
	/*Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 Start*/
	String mr_hdr_line7 = "";
	boolean isOurRefApplicable = false; 
	String ourRefDtlsDisp		= "";
	/*Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 End*/
	/*Added By Dharma on 4th Dec 2019 against  ML-MMOH-CRF-1454 Start*/
	boolean isSpecialtyDefaultApp	= false;
	String specialtyCodeMedicalTeam	= "";
	String specialtyEffStatus		= "";
	String specialtyMRApplYN		= "";
	/*Added By Dharma on 4th Dec 2019 against  ML-MMOH-CRF-1454 End*/
	String delivery_remarks		= "";//Added By Dharma on 15th Apr 2020 against  ML-MMOH-CRF-1314
	int tot_amount				= 0;
	boolean isRequestorAddrDispApp	= false;//Added By Dharma on 13th Dec 2019 against  ML-MMOH-CRF-1362
	
	//Added By Ashwini on 20-Jun-2022 for ML-MMOH-CRF-1905
	boolean isOutstandingAmtMedRepAppl = false;
	String bl_install_yn = checkForNull((String)session.getValue("bl_operational"));
	double outst_amt = 0;
	String outst_amt1 = "0";

	//Added by Arthi on 18-Jul-2022 for ML-MMOH-CRF-1906
	Boolean isPatDtlMedRepAppl = false;
	String patt_name		= "";
	String patient_gender	= "";
	String patient_age		= "";
    String genderdesc		= "";

try 
{
	isIncompReqCancelApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","AUTO_CANCEL_INCOMPLETE_REQUEST");//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
	isMedicalReportDurationAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","HOLIDAY_DURATION"); //  Added by Shaik Mujafar for ML-MMOH-CRF-0704
	isRejectRequestApplicable =    eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REQUEST_MRP"); //Added by Shaik Mujafar for ML-MMOH-CRF-0713
	isSelfStatusMRPApplicable =    eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MRP_STATUS_SELF"); //Added by Shaik Mujafar for ML-MMOH-CRF-0718
	isRejectReportApplicable =     eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REPORT_MRP"); //  Added by Mujafar for ML-MMOH-CRF-0714
	isChckLstApplicable = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CHCKLST_TRANS_MODE_MED_REPORT");//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
	isMedicalTeamApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MEDICAL_TEAM_APPLICABLE"); //Added by Shaik Mujafar for ML-MMOH-CRF-0716
	classification_appl_yn =   eCommon.Common.CommonBean.isSiteSpecific(con, "MR","CLASSIFICATION_APPL_YN"); // added by mujafar for ML-MMOH-CRF-0762 start
	isOurRefApplicable =   eCommon.Common.CommonBean.isSiteSpecific(con, "MR","OUR_REF_APPL_YN"); //Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
	isRequestorAddrDispApp =   eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MR_REQUESTOR_ADDR_DISPLAY_YN"); //Added By Dharma on 13th Dec 2019 against  ML-MMOH-CRF-1362
	String next_of_kin_name = "";
	isSpecialtyDefaultApp	= 	eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MR_SPECIALTY_DEF_APPL_YN"); //Added By Dharma on 4th Dec 2019 against  ML-MMOH-CRF-1454
	String next_of_kin_relation_code=""; // added by mujafar for ML-MMOH-CRF-0762
	String next_of_kin_nat_id_no= "";
	String oth_alt_id_type="";
	String oth_alt_id_no="";
	String next_of_kin_alt_id_type = "";
	String next_of_kin_alt_id_no = ""; // added by mujafar for ML-MMOH-CRF-0762 end
	
	isAcceptRequestByPractAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","ACCEPT_REJECT_BY_PRACT_APPL"); // added by mujafar for ML-MMOH-CRF-1315
	
	
	//Below line added for this CRF ML-MMOH-CRF-0712
	isMedicalReportRequest = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CANCEL_MEDICAL_REQUEST");	
	
	//Added for this CRF ML-MMOH-CRF-0860.2
    increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");

	isOutstandingAmtMedRepAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","OUTSTANDING_AMT_MED_REP"); //Added By Ashwini on 20-Jun-2022 for ML-MMOH-CRF-1905
	
	/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
	JSONArray TransApplModeJsonArr = new JSONArray();
	TransApplModeJsonArr  = eMR.MRCommonBean.getTransModeListForApplMode(con);

	JSONArray TransCollModeJsonArr = new JSONArray();
	TransCollModeJsonArr  = eMR.MRCommonBean.getTransModeListForCollMode(con);	
	
	JSONArray TransNotifiModeJsonArr = new JSONArray();
	TransNotifiModeJsonArr  = eMR.MRCommonBean.getTransModeListForNotifiMode(con);
	/*ML-MMOH-CRF-0708 End*/	
	String params		= request.getQueryString();

	String PatientId	= checkForNull(request.getParameter("PatientId"));

	//Added by Arthi on 18-Jul-2022 for ML-MMOH-CRF-1906
	isPatDtlMedRepAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MR", "DIS_PATDTL_MEDREP_FUN");
	JSONObject Json	= eMR.MRCommonBean.getPatDtlMedRep(con,locale,PatientId);
	patt_name = (String) Json.get("patient_name");
	patient_gender = (String) Json.get("patient_gender");
	patient_age = (String) Json.get("patient_age");
	

	/*Added By Ashwini on 20-Jun-2022 for ML-MMOH-CRF-1905*/
	if(bl_install_yn.equals("Y"))
	{
		BLFunctionalValidation blFunction = new BLFunctionalValidation();
		Hashtable blData = new Hashtable();
		blData.put("patient",PatientId);
		blData.put("facilityid",Facility_Id);
		blData.put("bl_install_yn",bl_install_yn);
		blData.put("bl_interface_yn",'Y');
		Hashtable blResult = blFunction.billPatientService(propertiesBill,con,blData); 

		if (blResult != null)
			outst_amt = ((Float)blResult.get("outst_amt")).floatValue();
		else
			outst_amt = 0;
				
		blFunction = null;
		blData.clear();
		blResult.clear();
		
		outst_amt1 = ""+outst_amt;
		CurrencyFormat cf1 = new CurrencyFormat();
		outst_amt1 = cf1.formatCurrency(outst_amt1, 2);
	}
	/*End ML-MMOH-CRF-1905*/

	try
	{	
		
		String mrParamSql = " select mr_hdr_line7,medrep_pay_int_mode, to_char(sysdate,'dd/mm/yyyy hh24:mi')SystemDate from MR_PARAMETER ";
		if (rs != null) rs.close();

		rs	=	stmt.executeQuery(mrParamSql);
		if (rs.next() && rs != null)
		{
			medrep_pay_int_mode = rs.getString("medrep_pay_int_mode");
			SystemDate = rs.getString("SystemDate");
			ourRefDtlsDisp	= checkForNull(rs.getString("mr_hdr_line7"));
			if(!ourRefDtlsDisp.equals("")){
				ourRefDtlsDisp	= ourRefDtlsDisp+"-"+PatientId;
			}
		}
		
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}catch(Exception e) 
	{
		//out.println("Exception in MR_PARAMETER Query : "+e);
		e.printStackTrace();
	}

	
	
	//String patientId	= checkForNull(request.getParameter("patientId"));

	
	String encounterid	= checkForNull(request.getParameter("encounter_id"));
	String LastDet	= checkForNull(request.getParameter("LastDet"));
	//String call_function	= checkForNull(request.getParameter("call_function"));



	String new_func_id	= checkForNull(request.getParameter("new_func_id"));
	String finalSelect	= checkForNull(request.getParameter("finalSelect"));
	//String chkSelect	= checkForNull(request.getParameter("chkSelect"));
	String request_id	= checkForNull(request.getParameter("request_id"));

	

	String selitem		= checkForNull(request.getParameter("selitem"));
	String from			= checkForNull(request.getParameter("from"));

	String to			= checkForNull(request.getParameter("to"));
	String called_from	= checkForNull(request.getParameter("called_from"));
	String call_function= checkForNull(request.getParameter("call_function"));
	String dis = "";
	String disabled = "";
	
	String dis_req = ""; // added by mujafar for ML-MMOH-CRF-0762
	
	SystemDate_display = DateUtils.convertDate(SystemDate,"DMYHM","en",locale);
	if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD")  || call_function.equals("REQUEST_RETURNED")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		dis = "";
	else
		dis = "disabled";
	
	//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708	
	String disableModes = "";
	if(call_function.equals("MEDICAL_REPORT_COMPLETED"))
	{
		disableModes = "disabled";
	}else{
		disableModes = "";
	}

	String disabledAttribute = "";
	if(call_function.equals("MEDICAL_REPORT_REQUEST") || call_function.equals("MEDICAL_REPORT_STATUS"))
		disabledAttribute = "";
	else
		disabledAttribute = "disabled";

	if(call_function.equals("MEDICAL_REPORT_REQUEST"))
		//disabled = "";
	      disable1 = "disabled";
	else
		//disabled = "disabled";
	    disable1 = "";
	
	/*Added By Dharma on Dec 8th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
	//if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REQUEST_ACCEPTED")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	if(!call_function.equals("MEDICAL_REPORT_REQUEST"))	
		disabled = "disabled";
	else
		 disabled = "";
	/*Added By Dharma on Dec 8th 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/
	
	/*Below line addded for this CRF ML-MMOH-CRF-0712*/
	  String visibility_img ="style='visibility:visible'";
	  if(isMedicalReportRequest && (call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD")) ){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	      visibility_img ="style='visibility:hidden'";
	  }
	//End this CRF ML-MMOH-CRF-0712
	
	String addr_line1 = "";			String addr_line2 = "";
	String addr_line3 = "";			String addr_line4 = "";
	String res_town_code = "";		String res_town_desc = "";
	String res_area_code = "";		String res_area_desc = "";
	String region_code = "";		String region_desc = "";
	String postal_code = "";		
	String res_country_desc = "";
	String res_country_code = "";	String mail_addr_line1 = "";
	String mail_addr_line2 = "";	String mail_addr_line3 = "";
	String mail_addr_line4 = "";	String mail_res_town_code = "";
	String mail_res_town_desc = "";	String mail_res_area_code = "";
	String mail_res_area_desc = "";	String mail_postal_code = "";
	String mail_region_code = "";	String mail_region_desc = "";
	String mail_country_code = "";	String mail_country_desc = "";
	String contact1_no = "";		
	String contact2_no = "";
	String email = "";


	/*ADDRESS for NKIN*/
	String nkin_addr_line1 = ""; 	String nkin_addr_line2 = ""; 
	String nkin_addr_line3 = ""; 	String nkin_addr_line4 = ""; 
	String nkin_res_town_desc = ""; String nkin_res_town_code = ""; 
	String nkin_res_area_desc = ""; String nkin_res_area_code = ""; 
	String nkin_region_desc = ""; 	String nkin_region_code = ""; 
	String nkin_postal_code = ""; 	String nkin_country_desc = ""; 
	String nkin_country_code = ""; 	
	/*ADDRESS for FTON*/
	String fton_addr_line1 = ""; 	String fton_addr_line2 = ""; 
	String fton_addr_line3 = ""; 	String fton_addr_line4 = ""; 
	String fton_res_town_desc = ""; String fton_res_town_code = ""; 
	String fton_res_area_desc = ""; String fton_res_area_code = ""; 
	String fton_region_desc = ""; 
	String fton_region_code = ""; 	String fton_postal_code = ""; 
	String fton_country_desc = ""; 	String fton_country_code = ""; 
	/*ADDRESS for EMPLR*/
	String emplr_addr_line1 = ""; 	String emplr_addr_line2 = ""; 
	String emplr_addr_line3 = ""; 	String emplr_addr_line4 = ""; 
	String emplr_res_town_desc = "";String emplr_res_town_code = ""; 
	String emplr_res_area_desc = "";String emplr_res_area_code = ""; 
	String emplr_region_desc = ""; 	String emplr_region_code = ""; 
	String emplr_postal_code = ""; 	String emplr_country_desc = ""; 
	String emplr_country_code = ""; 	
	//Maheshwaran K added for the ML-MMOH-CRF-0391
	String forwarded_hod_cord_id="";
	String forwarded_hod_cord_date="";
	String forwarded_hod_cord_name = "";
	String inform_hod_cord_id="";
	String forwarded_medical_team=""; //added by mujafar for ML-MMOH-CRF-0716
	String forwarded_medical_team_desc = ""; //added by mujafar for ML-MMOH-CRF-0710
	String inform_medical_team=""; //added by mujafar for ML-MMOH-CRF-0716
	String inform_hod_cord_name="";
	String PREPARE_PRACT_NAME="";
	String accept_national_id_no_yn	= "";
	String accession_num	= "";	
	String alt_id1_no		= "";
	String alt_id1_type		= "";	
	String CollectDate		= "";
	String CollectDate_Converted = "";
	String Medical_members	= "";	
	String nat_id_prompt	= "";	
	String nat_id_length    = ""; // added by mujafar for ML-MMOH-CRF-0762 start
	String accept_oth_alt_id_yn = "";
	StringBuffer sqlAlt = new StringBuffer(); // added by mujafar for ML-MMOH-CRF-0762 end
	String national_id_no	= "";
	String Pat_name			= "";
	String patient_name		= "";	
	String pract_code		= "";
	String Pract_name		= "";	
	String prepareDate		= "";
	String prepareDate_Converted = "";
	String RecdDate			= "";
	String RecdDate_Converted = "";
	String remarks			= "";
	String remarks_hod = ""; // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	String remarks_pract = "";
	String Pract_Assign_Date="";
	String reqDate			= "";
	String reqDate_converted= "";
	String Request_desc		= "";
	String requestor_code	= "";	
	String revised_collect_date = "";
	String revised_collect_date_converted = "";
	String team_code		= "";	
	String team_desc		= "";

	/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/

	String self_contact_no1		= "";
	String self_contact_no2		= "";
	String self_appl_email_id	= "";

	String nkin_contact_no1		= "";
	String nkin_contact_no2		= "";
	String nkin_appl_email_id	= "";

	String fton_contact_no1		= "";
	String fton_contact_no2		= "";
	String fton_appl_email_id	= "";

	String emplr_contact_no1	= "";
	String emplr_contact_no2	= "";

	/*ML-MMOH-CRF-0707*/

/********************************************************************/
//VALUES TO BE FETCHED FORM HDR_VW AND ASSIGN TO FIELDS...
/********************************************************************/
	String relationship_type	= ""; 		
	String relationship_code	= "";		String requestor_desc		= ""; 
	String appl_type_code		= ""; 		String appl_no				= ""; 
	String applicant_name		= ""; 		String application_date		= ""; 
	String cons_letter			= ""; 		String application_ref_no	= ""; 
	String for_attn_of			= ""; 		String report_type_code		= ""; 
	String specialty_code		= ""; 		String indicator			= ""; 
	String requestor_type_ind = ""; // added by mujafar for ML-MMOH-CRF-0762
	String required_docs		= ""; 		String appl_completion_date	= ""; 
	String forwarded_pract_name = "";		String requesting_pract_name= "";
	String forwarded_pract_id   = "";		String requesting_pract_id  = "";
	String event_status			= "";		String amount				= "";
	String receipt_no			= "";		String receipt_date			= "";
	String addl_amount			= "";		String addl_receipt_no		= "";
	String addl_receipt_date	= "";		String charges_appl_yn		= "N";
	String addl_charges_yn		= "N";		String ca_install_yn		= "";
	String delivered_date		= "";		String applSubmissionDate	= "";
	String posted_date			= "";		String dispatch_mode		= "";
	String sec_file_no			= "";		String report_taken_by		= "";
	String rtb_national_id_no	= "";		String rtb_alt_id_type		= "";
	String rtb_alt_id__no		= "";		String receipt_date_converted = "";
	String addl_receipt_date_converted = "";String delivered_date_converted = "";
	
	String pat_national_id_no=""; // added by mujafar for ML-MMOH-CRF-0762 start
	String next_of_nat_id_no = "";
	String pat_other_alt_id_type = "";
	String pat_other_alt_id_no = "";
	String next_of_other_alt_id_type = "";
	String next_of_other_alt_id_no = "";
	String classification_ind = "";
	int count = 0;
			String		nat_id = "";
			String		oth_alt_type="";
			String		oth_alt_id = ""; // added by mujafar for ML-MMOH-CRF-0762 end
	
	/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
	String cancelledDate	= "";
	String cancelledBy		= "";
	String cancelledReason	= "";
	String loginUserName	= "";
	String req_status		= "";
	/*End*/

	/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
	String applicationMode	= "";
	String collectionMode	= "";
	String notificationMode	= "";
	/*ML-MMOH-CRF-0708 End*/

	/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
	String requestor_type_desc	= "";

	/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
	String chklst_payment				= "N";
	String chklst_consent_fr_embsy		= "N";
	String chklst_stat_dec				= "N";
	String chklst_marital_cert			= "N";
	String chklst_consent_fr_pat		= "N";
	String chklst_ident_doc				= "N";
	String ack_hod_cord_id				= "";  
	String ack_medical_team =""; //added by mujafar for ML-MMOH-CRF-0716
	String ack_hod_cord_name			= "";
	String inform_to_pract_id			= "";
	String inform_to_pract_name			= "";
	String specialty_short_desc			= "";
	/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/

	/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
	String	collection_date				= "";
	/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
	
	// added by mujafar for ML-MMOH-CRF-0762 start
		String check_list1_status = "N";
		String check_list2_status = "N";
		String check_list3_status= "N";
		String check_list4_status= "N";
		String check_list5_status= "N";
		String check_list6_status= "N";
		String check_list7_status= "N";
		String check_list8_status= "N";
		String check_list9_status= "N";
		String check_list10_status= "N";
		//Added by Kamatchi S for ML-MMOH-CRF-1464 start
		String check_list11_status= "N";
		String check_list12_status= "N";
		String check_list13_status= "N";
		String check_list14_status= "N";
		String check_list15_status= "N";
		String check_list16_status= "N";
		String check_list17_status= "N";
		String check_list18_status= "N";
		String check_list19_status= "N";
		String check_list20_status= "N";
		String check_list21_status= "N";
		String check_list22_status= "N";
		String check_list23_status= "N";
		String check_list24_status= "N";
		String check_list25_status= "N";
		//Added by Kamatchi S for ML-MMOH-CRF-1464 end
		JSONObject jsonObj1 = eMR.MRCommonBean.getCheckListStatus(con,PatientId,request_id,Facility_Id);
		//below lines modified for ML-MMOH-CRF-1464 by Kamatchi S
		check_list1_status = checkForNull(((String) jsonObj1.get("check_list1_status")),"N");
		check_list2_status = checkForNull(((String) jsonObj1.get("check_list2_status")),"N");
		check_list3_status = checkForNull(((String) jsonObj1.get("check_list3_status")),"N");
		check_list4_status = checkForNull(((String) jsonObj1.get("check_list4_status")),"N");
		check_list5_status = checkForNull(((String) jsonObj1.get("check_list5_status")),"N");
		check_list6_status = checkForNull(((String) jsonObj1.get("check_list6_status")),"N");
		check_list7_status = checkForNull(((String) jsonObj1.get("check_list7_status")),"N");
		check_list8_status = checkForNull(((String) jsonObj1.get("check_list8_status")),"N");
	    check_list9_status = checkForNull(((String) jsonObj1.get("check_list9_status")),"N");
        check_list10_status= checkForNull(((String) jsonObj1.get("check_list10_status")),"N");
		//Added by Kamatchi S for ML-MMOH-CRF-1464 Start
        check_list11_status= checkForNull(((String) jsonObj1.get("check_list11_status")),"N");
        check_list12_status= checkForNull(((String) jsonObj1.get("check_list12_status")),"N");
		check_list13_status= checkForNull(((String) jsonObj1.get("check_list13_status")),"N");
        check_list14_status= checkForNull(((String) jsonObj1.get("check_list14_status")),"N");
        check_list15_status= checkForNull(((String) jsonObj1.get("check_list15_status")),"N");
        check_list16_status= checkForNull(((String) jsonObj1.get("check_list16_status")),"N");
        check_list17_status= checkForNull(((String) jsonObj1.get("check_list17_status")),"N");
        check_list18_status= checkForNull(((String) jsonObj1.get("check_list18_status")),"N");
        check_list19_status= checkForNull(((String) jsonObj1.get("check_list19_status")),"N");
        check_list20_status= checkForNull(((String) jsonObj1.get("check_list20_status")),"N");
        check_list21_status= checkForNull(((String) jsonObj1.get("check_list21_status")),"N");
        check_list22_status= checkForNull(((String) jsonObj1.get("check_list22_status")),"N");
        check_list23_status= checkForNull(((String) jsonObj1.get("check_list23_status")),"N");
        check_list24_status= checkForNull(((String) jsonObj1.get("check_list24_status")),"N");
        check_list25_status= checkForNull(((String) jsonObj1.get("check_list25_status")),"N");
		//Added by Kamatchi S for ML-MMOH-CRF-1464 end
		//Commented for ML-MMOH-CRF-1464
		/*if(check_list1_status == null || check_list1_status.equals("")) check_list1_status = "N"; 
		if(check_list2_status == null || check_list2_status.equals("")) check_list2_status = "N"; 
		if(check_list3_status == null || check_list3_status.equals("")) check_list3_status = "N"; 
		if(check_list4_status == null || check_list4_status.equals("")) check_list4_status = "N"; 
		if(check_list5_status == null || check_list5_status.equals("")) check_list5_status = "N"; 
		if(check_list6_status == null || check_list6_status.equals("")) check_list6_status = "N"; 
		if(check_list7_status == null || check_list7_status.equals("")) check_list7_status = "N"; 
		if(check_list8_status == null || check_list8_status.equals("")) check_list8_status = "N"; 
		if(check_list9_status == null || check_list9_status.equals("")) check_list9_status = "N"; 
		if(check_list10_status == null || check_list10_status.equals("")) check_list10_status = "N"; */

	try
	{	
		String CAinstall = " select install_yn FROM SM_MODULE WHERE module_id = 'CA' ";
		stmt = con.createStatement();
		rs	=	stmt.executeQuery(CAinstall);

		if ((rs != null) && (rs.next()))
		{
			ca_install_yn = rs.getString("install_yn");
			if(ca_install_yn == null) ca_install_yn ="N";
			
		}
		if(rs	 != null)   rs.close();
		if(stmt	 != null)   stmt.close();

		if(call_function.equals("ACCEPTED_BY_PRACTITIONER")||call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT"))
		{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			if(sqlBuff.length() > 0) sqlBuff.delete(0,sqlBuff.length());
			sqlBuff.append("select a.EVENT_STATUS, a.ACCESSION_NUM from CA_ENCNTR_NOTE a ");
			sqlBuff.append(" where a.patient_id='"+PatientId+"' and a.ACCESSION_NUM= ");
			sqlBuff.append("(select ACCESSION_NUM from MR_REPORT_REQUEST_HDR where ");
			sqlBuff.append("facility_id='"+Facility_Id+"' and patient_id ='"+PatientId+"'");
			sqlBuff.append(" and REQUEST_ID ='"+request_id+"')");

			stmt = con.createStatement();
			rs	=	stmt.executeQuery(sqlBuff.toString());
			if (rs.next() && rs != null)
			{
				accession_num = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
				event_status= rs.getString("EVENT_STATUS")==null?"":rs.getString("EVENT_STATUS");
			}
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
		}
	}catch(Exception e) 
	{
		//out.println("Exception in Query 1 : "+e);
		e.printStackTrace();
	}
	try
	{
		if(!request_id.equals(""))
		{
			if(sqlBuff.length() > 0) sqlBuff.delete(0,sqlBuff.length());

			sqlBuff.append(" SELECT ");
			sqlBuff.append("		Addl_Amount,");
			sqlBuff.append("        Addl_Charges_yn,");
			sqlBuff.append("        Addl_Receipt_No,");
			sqlBuff.append("        Am_Get_desc.Am_medical_team(Prepare_Team_Id,'"+Facility_Id+"','"+locale+"','1') Team_Short_desc,");
			sqlBuff.append("        Am_Get_desc.Am_practitioner(Forwarded_prAct_Id,'"+locale+"','1') Forwarded_prAct_Name,");
			sqlBuff.append("        Am_Get_desc.Am_practitioner(RequestIng_prAct_Id,'"+locale+"','1') RequestIng_prAct_Name,");
			sqlBuff.append("        Specialty_Code,Am_Get_desc.Am_speciality(Specialty_Code,'"+locale+"','1') Specialty_Short_desc,");
			if(isSpecialtyDefaultApp){
				
				sqlBuff.append(" (SELECT eff_status FROM am_speciality WHERE speciality_code = SPECIALTY_CODE ) specialtyEffStatus, ");
				sqlBuff.append(" (SELECT MR_APPL_YN FROM am_speciality WHERE speciality_code = SPECIALTY_CODE ) specialtyMRApplYN, ");
			}
			
			sqlBuff.append("        Amount,");
			sqlBuff.append("        Applicant_Name,");
			sqlBuff.append("        Application_ref_No,");
			sqlBuff.append("        Charges_apPl_yn,");
			sqlBuff.append("        Consent_Letter_apPl,");
			sqlBuff.append("        Dispatch_Mode, ");
			sqlBuff.append("        For_Attn_Of,");
			sqlBuff.append("        Forwarded_prAct_Id,");
			sqlBuff.append("        Patient_Name,");
			sqlBuff.append("        Prepare_Team_Id,");
			sqlBuff.append("        Prepare_prAct_Id,");
			sqlBuff.append("        Receipt_No,");
			sqlBuff.append("        Relationship_Code,");
			sqlBuff.append("        Relationship_Type,");
			sqlBuff.append("        Remarks,");
			sqlBuff.append("        remarks_hod,"); // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			sqlBuff.append("        remarks_pract,");
			
			sqlBuff.append("        To_char(PRACT_ASSIGN_DATE,'dd/mm/yyyy hh24:mi') Pract_Assign_Date,");
			
			
			sqlBuff.append("        Report_Taken_By,");
			sqlBuff.append("        Report_Type_Code,");
			sqlBuff.append("        RequestIng_prAct_Id,");
			sqlBuff.append("        a.RequestOr_Code,");
			sqlBuff.append("    MR_GET_DESC.MR_REQUESTOR('"+Facility_Id+"',a.RequestOr_Code,'"+locale+"','2')requestor_short_desc,");
			sqlBuff.append("        Required_Docs,");
			sqlBuff.append("        To_char(Addl_Receipt_Date,'dd/mm/yyyy hh24:mi') Addl_Receipt_Date,");
			sqlBuff.append("        To_char(Application_Date,'dd/mm/yyyy hh24:MI') Application_Date,");
			sqlBuff.append("        To_char(Collect_Date,'dd/mm/yyyy hh24:mi') Collect_Date,");
			sqlBuff.append("        To_char(Delivered_Date,'dd/mm/yyyy hh24:mi') Delivered_Date,");
			sqlBuff.append("        To_char(Posted_Date,'dd/mm/yyyy hh24:mi') Posted_Date,");
			sqlBuff.append("        To_char(Prepared_Date,'dd/mm/yyyy hh24:mi') Prepared_Date,");
			sqlBuff.append("        To_char(Receipt_Date,'dd/mm/yyyy hh24:mi') Receipt_Date,");
			sqlBuff.append("        To_char(Received_Date,'dd/mm/yyyy hh24:mi') Received_Date,");
			sqlBuff.append("        To_char(Request_Date,'dd/mm/yyyy hh24:mi') Request_Date,");
			sqlBuff.append("        To_char(Revised_Collect_Date,'dd/mm/yyyy hh24:mi') Revised_Collect_Date,");
			sqlBuff.append("        To_char(apPl_Completion_Date,'dd/mm/yyyy hh24:mi') apPl_Completion_Date,");
			sqlBuff.append("        To_char(apPl_Submitted_Date,'dd/mm/yyyy hh24:mi') apPlSubmissionDate,");
			sqlBuff.append("        Trunc(Nvl(Delivered_Date,SYSDATE) - Received_Date) Delivered,");
			sqlBuff.append("        Trunc(Prepared_Date - apPl_Completion_Date) No_Of_Days,");
			/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
			sqlBuff.append("        To_char(cancelled_date,'dd/mm/yyyy hh24:mi') cancelled_date,");
			sqlBuff.append("        cancel_reason_code, sm_get_desc.sm_appl_user(cancelled_by,'"+locale+"','1') cancelled_by,");
			sqlBuff.append("        sm_get_desc.sm_appl_user('"+loginUser+"','"+locale+"','1') loginUserName,");
			/*End*/
			/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
			sqlBuff.append("        application_mode,");
			sqlBuff.append("        collection_mode,");
			sqlBuff.append("        notification_mode,");
			/*ML-MMOH-CRF-0708 End*/
			sqlBuff.append("        apPl_No,");
			sqlBuff.append("        apPl_Type_Code,");
			/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
			sqlBuff.append("        c.indicator, (select long_desc from mr_requestor_type where REQUESTOR_TYPE_CODE = c.indicator) indicator_desc,a.REQUESTOR_TYPE_IND,(select CLASSIFICATION_IND from mr_requestor_type WHERE requestor_type_code = A.REQUESTOR_TYPE_IND )classification_ind,NATIONAL_ID_NO,NEXT_NATIONAL_ID_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,NEXT_OTH_ALT_ID_TYPE,NEXT_OTH_ALT_ID_NO, "); // added by mujafar for ML-MMOH-CRF-0762
			sqlBuff.append("        rtb_national_id_no,");
			sqlBuff.append("        rTb_alt_Id_Type,");
			sqlBuff.append("        rTb_alt_Id__No,");
			sqlBuff.append("        sec_File_No, ");
			//Maheshwarn K added for ML-MMOH-CRF-0391	
			sqlBuff.append("        FORWARDED_HOD_CORD_ID,	INFORM_HOD_CORD_ID,FORWARDED_MEDICAL_TEAM,(select SHORT_DESC from am_medical_team where FACILITY_ID= a.FACILITY_ID and team_id=a.forwarded_medical_team )forwarded_medical_team_desc,INFORM_MEDICAL_TEAM,to_char(FORWARDED_HOD_CORD_DATE,'dd/mm/yyyy hh24:mi') FORWARDED_HOD_CORD_DATE, "); //added by mujafar for ML-MMOH-CRF-0716		
			sqlBuff.append("   (CASE   WHEN inform_hod_cord_id IS NOT NULL  THEN (SELECT practitioner_name   FROM am_practitioner  WHERE practitioner_id = inform_hod_cord_id) END ) inform_hod_cord_name , (CASE   WHEN forwarded_hod_cord_id IS NOT NULL  THEN (SELECT practitioner_name   FROM am_practitioner  WHERE practitioner_id = forwarded_hod_cord_id) END ) forwarded_hod_cord_name , (CASE   WHEN PREPARE_PRACT_ID IS NOT NULL  THEN (SELECT practitioner_name   FROM am_practitioner  WHERE practitioner_id = PREPARE_PRACT_ID) END ) PREPARE_PRACT_NAME , ACK_HOD_CORD_ID,ACK_MEDICAL_TEAM,INFORM_TO_PRACT_ID, (CASE   WHEN ACK_HOD_CORD_ID IS NOT NULL  THEN (SELECT practitioner_name   FROM am_practitioner  WHERE practitioner_id = ACK_HOD_CORD_ID) END ) ack_hod_cord_name, (CASE   WHEN INFORM_TO_PRACT_ID IS NOT NULL  THEN (SELECT practitioner_name   FROM am_practitioner  WHERE practitioner_id = INFORM_TO_PRACT_ID) END ) inform_to_pract_name ,");
			// ML-MMOH-CRF-0391 Ends
			sqlBuff.append("		chklst_consent_fr_pat, chklst_ident_doc, chklst_marital_cert, chklst_stat_dec, chklst_consent_fr_embsy,chklst_payment ");//Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157]
			sqlBuff.append(" ,OTHER_APPLICATION_REF_NO ");//Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
			sqlBuff.append(" ,delivery_remarks ");//Added By Dharma on 15th Apr 2020 against ML-MMOH-CRF-1314
			sqlBuff.append(" ,(nvl(amount,0) + nvl(addl_amount,0)) tot_amount ");
			sqlBuff.append(" FROM ");
			sqlBuff.append(" MR_REPORT_REQUEST_HDR a, MR_REQUESTOR c ");
			sqlBuff.append(" WHERE  a.Facility_Id = '"+Facility_Id+"'");
			sqlBuff.append("        AND a.Patient_Id = '"+PatientId+"'");
			sqlBuff.append("        AND a.Request_Id = '"+request_id+"'");
			sqlBuff.append("        AND c.REQUESTOR_CODE (+) = a.REQUESTOR_CODE ");
			
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
			stmt = con.createStatement();
			rs	=	stmt.executeQuery(sqlBuff.toString());
			if (rs.next() && rs != null)
			{
				Request_desc			= checkForNull(rs.getString("REQUESTOR_SHORT_DESC"));
				reqDate					= checkForNull(rs.getString("REQUEST_DATE"));
				
				if(!(reqDate==null || reqDate.equals("")))
					reqDate_converted	= DateUtils.convertDate(reqDate,"DMYHM","en",locale);

				remarks					= checkForNull(rs.getString("REMARKS"));
				remarks_hod             = checkForNull(rs.getString("remarks_hod")); // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				remarks_pract             = checkForNull(rs.getString("remarks_pract"));
				Pract_Assign_Date = checkForNull(rs.getString("Pract_Assign_Date"));
				application_date		= checkForNull(rs.getString("application_date")); 
				if(!(application_date==null || application_date.equals("")))
				application_date		= DateUtils.convertDate(application_date,"DMYHM","en",locale);


				RecdDate				= checkForNull(rs.getString("RECEIVED_DATE")); 
				if(!(RecdDate==null || RecdDate.equals("")))
				RecdDate_Converted		= DateUtils.convertDate(RecdDate,"DMYHM","en",locale);

				revised_collect_date	= checkForNull(rs.getString("REVISED_COLLECT_DATE"));
				if(!(revised_collect_date==null || revised_collect_date.equals("")))
				revised_collect_date_converted= DateUtils.convertDate(revised_collect_date,"DMYHM","en",locale);

				prepareDate				= checkForNull(rs.getString("PREPARED_DATE"));
				if(!(prepareDate==null || prepareDate.equals("")))
				prepareDate_Converted= DateUtils.convertDate(prepareDate,"DMYHM","en",locale);

				team_desc				= checkForNull(rs.getString("TEAM_SHORT_DESC"));
				Pat_name				= checkForNull(rs.getString("PATIENT_NAME"));
				applSubmissionDate		= checkForNull(rs.getString("applSubmissionDate"));

				CollectDate				= checkForNull(rs.getString("COLLECT_DATE"));
				if(!(CollectDate==null || CollectDate.equals("")))
					CollectDate_Converted	= DateUtils.convertDate(CollectDate,"DMYHM","en",locale);

				/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
				cancelledDate			= checkForNull(rs.getString("cancelled_date"));
				cancelledBy				= checkForNull(rs.getString("cancelled_by"));
				cancelledReason			= checkForNull(rs.getString("cancel_reason_code"));
				loginUserName			= checkForNull(rs.getString("loginUserName"));
				/*End*/

				/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
				applicationMode			= checkForNull(rs.getString("application_mode"));
				collectionMode			= checkForNull(rs.getString("collection_mode"));
				notificationMode		= checkForNull(rs.getString("notification_mode"));
				/*ML-MMOH-CRF-0708 End*/
				
				appl_completion_date	= checkForNull(rs.getString("appl_completion_date"));
				team_code				= checkForNull(rs.getString("PREPARE_TEAM_ID"));
				pract_code				= checkForNull(rs.getString("PREPARE_PRACT_ID"));
				requestor_code			= checkForNull(rs.getString("REQUESTOR_CODE"));
				amount					= checkForNull(rs.getString("AMOUNT"));
				receipt_no				= checkForNull(rs.getString("RECEIPT_NO"));

				receipt_date			= checkForNull(rs.getString("RECEIPT_DATE"));
				if(!(receipt_date == null || receipt_date.equals("")))
				receipt_date_converted	= DateUtils.convertDate(receipt_date,"DMYHM","en",locale);

				addl_amount				= checkForNull(rs.getString("ADDL_AMOUNT"));
				addl_receipt_no			= checkForNull(rs.getString("ADDL_RECEIPT_NO"));
				
				tot_amount				= rs.getInt("tot_amount");

				addl_receipt_date		= checkForNull(rs.getString("ADDL_RECEIPT_DATE"));
				if(!(addl_receipt_date == null || addl_receipt_date.equals("")))
				addl_receipt_date_converted = DateUtils.convertDate(addl_receipt_date,"DMYHM","en",locale);

				charges_appl_yn			= checkForNull(rs.getString("CHARGES_APPL_YN"),"N");
				addl_charges_yn			= checkForNull(rs.getString("ADDL_CHARGES_YN"),"N");
				relationship_type		= checkForNull(rs.getString("RELATIONSHIP_TYPE"));
				relationship_code		= checkForNull(rs.getString("RELATIONSHIP_CODE"));  
				requestor_desc			= checkForNull(rs.getString("REQUESTOR_SHORT_DESC"));
				appl_type_code			= checkForNull(rs.getString("APPL_TYPE_CODE"));
				appl_no					= checkForNull(rs.getString("APPL_NO"));
				applicant_name			= checkForNull(rs.getString("APPLICANT_NAME"));
				cons_letter				= checkForNull(rs.getString("CONSENT_LETTER_APPL"));
				application_ref_no		= checkForNull(rs.getString("APPLICATION_REF_NO"));
				for_attn_of				= checkForNull(rs.getString("FOR_ATTN_OF"));
				report_type_code		= checkForNull(rs.getString("REPORT_TYPE_CODE"));
				specialty_short_desc	= checkForNull(rs.getString("SPECIALTY_SHORT_DESC"));
				specialty_code			= checkForNull(rs.getString("Specialty_Code"));
				
				if(isSpecialtyDefaultApp){
					specialtyCodeMedicalTeam	= specialty_code;
					specialtyEffStatus	= checkForNull(rs.getString("specialtyEffStatus"));
					specialtyMRApplYN	= checkForNull(rs.getString("specialtyMRApplYN"));
					
				}
				
				indicator				= checkForNull(rs.getString("indicator"));
				/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
					requestor_type_ind= checkForNull(rs.getString("REQUESTOR_TYPE_IND")); // added by mujafar for ML-MMOH-CRF-0762 start
					
					JSONArray checkListJsonArr = new JSONArray();
					checkListJsonArr							= eMR.MRCommonBean.getChecklistValues(con,requestor_type_ind,requestor_code);
			
					 count = checkListJsonArr.size();
					
					
					
					pat_national_id_no= checkForNull(rs.getString("NATIONAL_ID_NO"));
					next_of_nat_id_no= checkForNull(rs.getString("NEXT_NATIONAL_ID_NO"));
					pat_other_alt_id_type= checkForNull(rs.getString("OTH_ALT_ID_TYPE"));
					pat_other_alt_id_no= checkForNull(rs.getString("OTH_ALT_ID_NO"));
					next_of_other_alt_id_type= checkForNull(rs.getString("NEXT_OTH_ALT_ID_TYPE"));
					next_of_other_alt_id_no= checkForNull(rs.getString("NEXT_OTH_ALT_ID_NO"));
					classification_ind = checkForNull(rs.getString("classification_ind"));
					
					if(classification_appl_yn)
					{ 
					
						if(classification_ind.equals("N"))
						{
							nat_id = next_of_nat_id_no;
							oth_alt_type = next_of_other_alt_id_type;
							oth_alt_id = next_of_other_alt_id_no;
							
						}
						else
						if(classification_ind.equals("P"))
						{
							nat_id = pat_national_id_no;
							oth_alt_type=pat_other_alt_id_type;
							oth_alt_id = pat_other_alt_id_no;
							
						}
						
						
						if(call_function.equals("MEDICAL_REPORT_REQUEST") )
						dis_req = "";
						else
						dis_req = "disabled";
						
						
					
					}
					
					
					// added by mujafar for ML-MMOH-CRF-0762 end
					
					
					
					
				requestor_type_desc		= checkForNull(rs.getString("indicator_desc"));
				required_docs			= checkForNull(rs.getString("required_docs"));
							
				forwarded_pract_name	= checkForNull(rs.getString("FORWARDED_PRACT_NAME"));
				requesting_pract_name	= checkForNull(rs.getString("REQUESTING_PRACT_NAME"));
				forwarded_pract_id		= checkForNull(rs.getString("FORWARDED_PRACT_ID"));
				requesting_pract_id		= checkForNull(rs.getString("REQUESTING_PRACT_ID"));

				delivered_date			= checkForNull(rs.getString("DELIVERED_DATE"));
				if(!(delivered_date == null || delivered_date.equals("")))
				delivered_date_converted = DateUtils.convertDate(delivered_date,"DMYHM","en",locale);

				posted_date				= checkForNull(rs.getString("POSTED_DATE"));
				if(!(posted_date == null || posted_date.equals("")))
					posted_date			= DateUtils.convertDate(posted_date,"DMYHM","en",locale);

				dispatch_mode			= checkForNull(rs.getString("DISPATCH_MODE"));
				sec_file_no				= checkForNull(rs.getString("SEC_FILE_NO"));
				report_taken_by			= checkForNull(rs.getString("REPORT_TAKEN_BY"));
				rtb_national_id_no		= checkForNull(rs.getString("RTB_NATIONAL_ID_NO"));
				rtb_alt_id_type			= checkForNull(rs.getString("RTB_ALT_ID_TYPE"));
				rtb_alt_id__no			= checkForNull(rs.getString("RTB_ALT_ID__NO"));
				no_of_days				= checkForNull(rs.getString("no_of_days"));

				/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
				chklst_consent_fr_pat	= checkForNull(rs.getString("chklst_consent_fr_pat"),"N");
				chklst_ident_doc		= checkForNull(rs.getString("chklst_ident_doc"),"N");
				chklst_marital_cert		= checkForNull(rs.getString("chklst_marital_cert"),"N");
				chklst_stat_dec			= checkForNull(rs.getString("chklst_stat_dec"),"N");
				chklst_consent_fr_embsy	=checkForNull(rs.getString("chklst_consent_fr_embsy"),"N");
				chklst_payment			= checkForNull(rs.getString("chklst_payment"),"N");
				ack_hod_cord_id			= checkForNull(rs.getString("ack_hod_cord_id"));
				ack_medical_team        = checkForNull(rs.getString("ack_medical_team")); //added by mujafar for ML-MMOH-CRF-0716
				ack_hod_cord_name		= checkForNull(rs.getString("ack_hod_cord_name"));
				ourRefDtlsDisp			 = checkForNull(rs.getString("OTHER_APPLICATION_REF_NO"));//Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
				delivery_remarks		 = checkForNull(rs.getString("delivery_remarks"));//Added By Dharma on Apr 15th 2020 against ML-MMOH-CRF-1314
				inform_to_pract_id		= checkForNull(rs.getString("inform_to_pract_id"));
				inform_to_pract_name	= checkForNull(rs.getString("inform_to_pract_name"));
				/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/
				//Maheshwaran K added for ML-MMOH-CRF-0391
				forwarded_hod_cord_date	= checkForNull(rs.getString("FORWARDED_HOD_CORD_DATE"));
				forwarded_hod_cord_id	= checkForNull(rs.getString("FORWARDED_HOD_CORD_ID"));
				forwarded_hod_cord_name	= checkForNull(rs.getString("FORWARDED_HOD_CORD_NAME"));
				inform_hod_cord_id	= checkForNull(rs.getString("INFORM_HOD_CORD_ID"));
				inform_hod_cord_name	= checkForNull(rs.getString("INFORM_HOD_CORD_NAME"));
				forwarded_medical_team = checkForNull(rs.getString("forwarded_medical_team")); //added by mujafar for ML-MMOH-CRF-0716
				forwarded_medical_team_desc = checkForNull(rs.getString("forwarded_medical_team_desc"));
				inform_medical_team = checkForNull(rs.getString("inform_medical_team")); //added by mujafar for ML-MMOH-CRF-0716
				PREPARE_PRACT_NAME	= checkForNull(rs.getString("PREPARE_PRACT_NAME"));
				
				
			}
		}
	}catch(Exception e) 
	{
		//out.println("Exception in Query 2 : "+e);
		e.printStackTrace();
	}

	try
	{
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		
		String patSql=" select alt_id1_no, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, national_id_no, oth_alt_id_no, oth_alt_id_type from MP_PATIENT where patient_id='"+PatientId+"' ";


		stmt= con.createStatement();
		rs	= stmt.executeQuery(patSql);
		
		if(rs.next() && rs != null)
		{
			patient_name	= checkForNull(rs.getString("PATIENT_NAME"));
			national_id_no	= checkForNull(rs.getString("NATIONAL_ID_NO"));
			alt_id1_no		= checkForNull(rs.getString("ALT_ID1_NO"));
			oth_alt_id_type= checkForNull(rs.getString("oth_alt_id_type")); // added by mujafar for ML-MMOH-CRF-0762
			oth_alt_id_no  = checkForNull(rs.getString("oth_alt_id_no")); // added by mujafar for ML-MMOH-CRF-0762
		}

		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}
	catch(Exception e) 
	{
		//out.println("Exception in Query 3 : "+e);
		e.printStackTrace();
	}

	try
	{
		String contactSql=" SELECT a.short_desc, b.nat_id_prompt,b.nat_id_length, b.accept_national_id_no_yn, b.alt_id1_type, b.accept_oth_alt_id_yn FROM MP_ALTERNATE_ID_TYPE_LANG_VW a , MP_PARAM b WHERE a.alt_id_type = b.alt_id1_type and b.module_id='MP' and a.language_id='"+locale+"' "; 

		stmt= con.createStatement();
		rs	= stmt.executeQuery(contactSql);

		if(rs.next() && rs != null)
		{
			nat_id_prompt			= checkForNull(rs.getString("nat_id_prompt"));
			accept_national_id_no_yn= checkForNull(rs.getString("accept_national_id_no_yn"));
			alt_id1_type			= checkForNull(rs.getString("short_desc"));
			nat_id_length           = checkForNull(rs.getString("nat_id_length")); // added by mujafar for ML-MMOH-CRF-0762
			accept_oth_alt_id_yn    = checkForNull(rs.getString("accept_oth_alt_id_yn")); // added by mujafar for ML-MMOH-CRF-0762
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();

	}catch(Exception e) 
	{
		//out.println("Exception in Query 4 : "+e);
		e.printStackTrace();
	}

	try
	{
		if(sqlBuff.length() > 0) sqlBuff.delete(0,sqlBuff.length());
/*
		sqlBuff.append(" SELECT ");
		sqlBuff.append("		Contact1_Region_Code,");
		sqlBuff.append("        Contact1_res_Area_Code,");
		sqlBuff.append("        Contact1_res_Town_Code,");
		sqlBuff.append("        Contact2_Region_Code,");
		sqlBuff.append("        Contact2_res_Area_Code,");
		sqlBuff.append("        Contact2_res_Town_Code,");
		sqlBuff.append("        Contact3_Region_Code,");
		sqlBuff.append("        Contact3_res_Area_Code,");
		sqlBuff.append("        Contact3_res_Town_Code,");
		sqlBuff.append("        Mail_Addr_Line1,");
		sqlBuff.append("        Mail_Addr_Line2,");
		sqlBuff.append("        Mail_Addr_Line3,");
		sqlBuff.append("        Mail_Addr_Line4,");
		sqlBuff.append("        Mail_Country_Code,");
		sqlBuff.append("        Mail_Postal_Code,");
		sqlBuff.append("        Mail_Region_Code,");
		sqlBuff.append("        Mail_res_Area,");
		sqlBuff.append("        Mail_res_Town,");
		sqlBuff.append("        Orn_tel_No,");
		sqlBuff.append("        RESI_POSTAL_CODE,");
		sqlBuff.append("        Region_Code,");
		sqlBuff.append("        eMail_Id,");
		sqlBuff.append("        emPlr_Addr_Line1,");
		sqlBuff.append("        emPlr_Addr_Line2,");
		sqlBuff.append("        emPlr_Addr_Line3,");
		sqlBuff.append("        emPlr_Addr_Line4,");
		sqlBuff.append("        emPlr_Country_Code,");
		sqlBuff.append("        emPlr_Postal_Code,");
		sqlBuff.append("        fTon_Addr_Line1,");
		sqlBuff.append("        fTon_Addr_Line2,");
		sqlBuff.append("        fTon_Addr_Line3,");
		sqlBuff.append("        fTon_Addr_Line4,");
		sqlBuff.append("        fTon_Area_desc,");
		sqlBuff.append("        fTon_Country_Code,");
		sqlBuff.append("        fTon_Postal_Code,");
		sqlBuff.append("        mp_Get_desc.Mp_country(emPlr_Country_Code,'"+locale+"','2') emPlr_Country_Name,");
		sqlBuff.append("        mp_Get_desc.Mp_country(fTon_Country_Code,'"+locale+"','1') Mail_Country_Name,");
		sqlBuff.append("        mp_Get_desc.Mp_country(fTon_Country_Code,'"+locale+"','1') fTon_Country_Name,");
		sqlBuff.append("        mp_Get_desc.Mp_country(resi_Country_Code,'"+locale+"','2') nKin_Country_Name,");
		sqlBuff.append("        mp_Get_desc.Mp_country(resi_Country_Code,'"+locale+"','2') resi_Country_Name,");
		sqlBuff.append("        mp_Get_desc.Mp_region(Contact1_Region_Code,'"+locale+"','2') nKin_Region_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_region(Contact2_Region_Code,'"+locale+"','2') fTon_Region_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_region(Contact3_Region_Code,'"+locale+"','2') emPlr_Region_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_region(Mail_Region_Code,'"+locale+"','2') Mail_Region_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_region(Region_Code,'"+locale+"','1') Region_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_area(Contact1_res_Area_Code,'"+locale+"','2') nKin_Area_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_area(Contact3_res_Area_Code,'"+locale+"','2') emPlr_Area_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_area(Mail_res_Area,'"+locale+"','2') Mail_res_Area_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_area(res_Area_Code,'"+locale+"','2') res_Area_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_town(Contact1_res_Town_Code,'"+locale+"','2') nKin_Town_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_town(Contact2_res_Town_Code,'"+locale+"','2') fTon_Town_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_town(Contact3_res_Town_Code,'"+locale+"','2') emPlr_Town_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_town(Mail_res_Town,'"+locale+"','2') Mail_res_Town_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_town(res_Town_Code,'"+locale+"','2') res_Town_desc,");
		sqlBuff.append("        nKin_Addr_Line1,");
		sqlBuff.append("        nKin_Addr_Line2,");
		sqlBuff.append("        nKin_Addr_Line3,");
		sqlBuff.append("        nKin_Addr_Line4,");
		sqlBuff.append("        nKin_Country_Code,");
		sqlBuff.append("        nKin_Postal_Code,");
		sqlBuff.append("        prn_tel_No,");
		sqlBuff.append("        res_Area_Code,");
		sqlBuff.append("        res_Town_Code,");
		sqlBuff.append("        resi_Addr_Line1,");
		sqlBuff.append("        resi_Addr_Line2,");
		sqlBuff.append("        resi_Addr_Line3,");
		sqlBuff.append("        resi_Addr_Line4,");
		sqlBuff.append("        resi_Country_Code");
		sqlBuff.append(" FROM ");
		sqlBuff.append("		MP_CHG_PAT_DTLS_VW");
		sqlBuff.append(" WHERE  ");
		sqlBuff.append("		Patient_Id = '"+patientId+"' ");
*/

		sqlBuff.append(" SELECT PAT_RL_CON.CONTACT1_RELATION next_of_kin_relation_code,PAT_RL_CON.CONTACT1_REGION_CODE,PAT_RL_CON.contact1_name next_of_kin_name,PAT_RL_CON.CONTACT1_NAT_ID_NO next_of_kin_nat_id_no,PAT_RL_CON.CONTACT1_OTH_ALT_ID_TYPE next_of_kin_alt_id_type,PAT_RL_CON.CONTACT1_OTH_ALT_ID_NO next_of_kin_alt_id_no ,PAT_RL_CON.CONTACT1_RES_AREA_CODE, PAT_RL_CON.CONTACT1_RES_TOWN_CODE, PAT_RL_CON.CONTACT2_REGION_CODE, PAT_RL_CON.CONTACT2_RES_AREA_CODE, PAT_RL_CON.CONTACT2_RES_TOWN_CODE, PAT_RL_CON.CONTACT3_REGION_CODE, PAT_RL_CON.CONTACT3_RES_AREA_CODE, PAT_RL_CON.CONTACT3_RES_TOWN_CODE, PAT_ADDR.ADDR2_LINE1 Mail_Addr_Line1, PAT_ADDR.ADDR2_LINE2 Mail_Addr_Line2, PAT_ADDR.ADDR2_LINE3 Mail_Addr_Line3, PAT_ADDR.ADDR2_LINE4 Mail_Addr_Line4, PAT_ADDR.COUNTRY2_CODE Mail_Country_Code, PAT_ADDR.POSTAL2_CODE Mail_Postal_Code, PAT_ADDR.REGION2_CODE Mail_Region_Code, PAT_ADDR.RES_AREA2_CODE Mail_res_Area, PAT_ADDR.RES_TOWN2_CODE Mail_res_Town, PATIENT.CONTACT2_NO Orn_tel_No, PAT_ADDR.POSTAL1_CODE RESI_POSTAL_CODE, PATIENT.REGION_CODE Region_Code, PATIENT.EMAIL_ID eMail_Id, PAT_RL_CON.ADDR3_LINE1 emPlr_Addr_Line1, PAT_RL_CON.ADDR3_LINE2 emPlr_Addr_Line2, PAT_RL_CON.ADDR3_LINE3 emPlr_Addr_Line3, PAT_RL_CON.ADDR3_LINE4 emPlr_Addr_Line4, PAT_RL_CON.COUNTRY3_CODE emPlr_Country_Code, PAT_RL_CON.POSTAL3_CODE emPlr_Postal_Code, PAT_RL_CON.ADDR2_LINE1 fTon_Addr_Line1, PAT_RL_CON.ADDR2_LINE2 fTon_Addr_Line2, PAT_RL_CON.ADDR2_LINE3 fTon_Addr_Line3, PAT_RL_CON.ADDR2_LINE4 fTon_Addr_Line4, mp_Get_desc.Mp_res_area(PAT_RL_CON.CONTACT2_RES_AREA_CODE, '"+locale+"', '1') fTon_Area_desc, PAT_RL_CON.COUNTRY2_CODE fTon_Country_Code, PAT_RL_CON.POSTAL2_CODE fTon_Postal_Code, mp_Get_desc.Mp_country(PAT_RL_CON.COUNTRY3_CODE, '"+locale+"', '1') emPlr_Country_Name, mp_Get_desc.Mp_country(PAT_ADDR.COUNTRY2_CODE, '"+locale+"', '1') Mail_Country_Name, mp_Get_desc.Mp_country(PAT_RL_CON.COUNTRY2_CODE, '"+locale+"', '1') fTon_Country_Name, mp_Get_desc.Mp_country(PAT_RL_CON.COUNTRY1_CODE, '"+locale+"', '2') nKin_Country_Name, mp_Get_desc.Mp_country(PAT_ADDR.COUNTRY1_CODE, '"+locale+"', '2') resi_Country_Name, mp_Get_desc.Mp_region(PAT_RL_CON.CONTACT1_REGION_CODE, '"+locale+"', '2') nKin_Region_desc, mp_Get_desc.Mp_region(PAT_RL_CON.CONTACT2_REGION_CODE, '"+locale+"', '2') fTon_Region_desc, mp_Get_desc.Mp_region(PAT_RL_CON.CONTACT3_REGION_CODE, '"+locale+"', '2') emPlr_Region_desc, mp_Get_desc.Mp_region(PAT_ADDR.REGION2_CODE, '"+locale+"', '2') Mail_Region_desc, mp_Get_desc.Mp_region(Region_Code, '"+locale+"', '1') Region_desc, mp_Get_desc.Mp_res_area(PAT_RL_CON.CONTACT1_RES_AREA_CODE, '"+locale+"', '2') nKin_Area_desc, mp_Get_desc.Mp_res_area(PAT_RL_CON.CONTACT3_RES_AREA_CODE, '"+locale+"', '2') emPlr_Area_desc, mp_Get_desc.Mp_res_area(PAT_ADDR.RES_AREA2_CODE, '"+locale+"', '2') Mail_res_Area_desc, mp_Get_desc.Mp_res_area(res_Area_Code, '"+locale+"', '2') res_Area_desc, mp_Get_desc.Mp_res_town(PAT_RL_CON.CONTACT1_RES_TOWN_CODE, '"+locale+"', '1') nKin_Town_desc, mp_Get_desc.Mp_res_town(PAT_RL_CON.CONTACT2_RES_TOWN_CODE, '"+locale+"', '2') fTon_Town_desc, mp_Get_desc.Mp_res_town(PAT_RL_CON.CONTACT3_RES_TOWN_CODE, '"+locale+"', '2') emPlr_Town_desc, mp_Get_desc.Mp_res_town(PAT_ADDR.RES_TOWN2_CODE, '"+locale+"', '2') Mail_res_Town_desc, mp_Get_desc.Mp_res_town(res_Town_Code, '"+locale+"', '2') res_Town_desc, PAT_RL_CON.ADDR1_LINE1 nKin_Addr_Line1, PAT_RL_CON.ADDR1_LINE2 nKin_Addr_Line2, PAT_RL_CON.ADDR1_LINE3 nKin_Addr_Line3, PAT_RL_CON.ADDR1_LINE4 nKin_Addr_Line4, PAT_RL_CON.COUNTRY1_CODE nKin_Country_Code, PAT_RL_CON.POSTAL1_CODE nKin_Postal_Code, PATIENT.CONTACT1_NO prn_tel_No, PATIENT.RES_AREA_CODE res_Area_Code, PATIENT.RES_TOWN_CODE res_Town_Code, PAT_ADDR.ADDR1_LINE1 resi_Addr_Line1, PAT_ADDR.ADDR1_LINE2 resi_Addr_Line2, PAT_ADDR.ADDR1_LINE3 resi_Addr_Line3, PAT_ADDR.ADDR1_LINE4 resi_Addr_Line4, PAT_ADDR.COUNTRY1_CODE resi_Country_Code, "); 
		 // MODIFIED by mujafar for ML-MMOH-CRF-0762
		
		//Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707
		sqlBuff.append(" PATIENT.CONTACT1_NO self_contact_no1, PATIENT.CONTACT2_NO self_contact_no2, PATIENT.EMAIL_ID self_appl_email_id, PAT_RL_CON.CONTACT1_MOB_TEL_NO nkin_contact_no2, PAT_RL_CON.RES1_TEL_NO nkin_contact_no1, PAT_RL_CON.CONTACT1_EMAIL_ID nkin_appl_email_id, PAT_RL_CON.CONTACT2_MOB_TEL_NO fton_contact_no2, PAT_RL_CON.RES2_TEL_NO fton_contact_no1, PAT_RL_CON.CONTACT2_EMAIL_ID fton_appl_email_id, PAT_RL_CON.RES3_TEL_NO emplr_contact_no1, PAT_RL_CON.OFF3_TEL_NO emplr_contact_no2 ");
		
		sqlBuff.append(" FROM MP_PATIENT PATIENT, MP_PAT_ADDRESSES PAT_ADDR, MP_PAT_REL_CONTACTS PAT_RL_CON WHERE PATIENT.PATIENT_ID = PAT_ADDR.PATIENT_ID(+) AND PATIENT.PATIENT_ID = PAT_RL_CON.PATIENT_ID(+) AND PATIENT.Patient_Id = '"+PatientId+"'  ");

		stmt= con.createStatement();
		rs	= stmt.executeQuery(sqlBuff.toString());

		if(rs.next() && rs != null)
		{
			addr_line1	= checkForNull(rs.getString("resi_addr_line1"));
			addr_line2	= checkForNull(rs.getString("resi_addr_line2"));
			addr_line3	= checkForNull(rs.getString("resi_addr_line3"));
			addr_line4	= checkForNull(rs.getString("resi_addr_line4"));
			contact1_no = checkForNull(rs.getString("prn_tel_no")); 
			contact2_no = checkForNull(rs.getString("orn_tel_no")); 
			email = checkForNull(rs.getString("email_id")); 
			emplr_addr_line1 = checkForNull(rs.getString("EMPLR_ADDR_LINE1")); 
			emplr_addr_line2 = checkForNull(rs.getString("EMPLR_ADDR_LINE2")); 
			emplr_addr_line3 = checkForNull(rs.getString("EMPLR_ADDR_LINE3")); 
			emplr_addr_line4 = checkForNull(rs.getString("EMPLR_ADDR_LINE4")); 
			emplr_country_code = checkForNull(rs.getString("EMPLR_COUNTRY_CODE")); 
			emplr_country_desc = checkForNull(rs.getString("EMPLR_COUNTRY_NAME")); 
			emplr_postal_code = checkForNull(rs.getString("EMPLR_POSTAL_CODE")); 
			emplr_region_code = checkForNull(rs.getString("CONTACT3_REGION_CODE")); 
			emplr_region_desc = checkForNull(rs.getString("EMPLR_REGION_DESC")); 
			emplr_res_area_code = checkForNull(rs.getString("CONTACT3_RES_AREA_CODE")); 
			emplr_res_area_desc = checkForNull(rs.getString("EMPLR_AREA_DESC")); 
			emplr_res_town_code = checkForNull(rs.getString("CONTACT3_RES_TOWN_CODE")); 
			emplr_res_town_desc = checkForNull(rs.getString("EMPLR_TOWN_DESC")); 
			fton_addr_line1 = checkForNull(rs.getString("FTON_ADDR_LINE1")); 
			fton_addr_line2 = checkForNull(rs.getString("FTON_ADDR_LINE2")); 
			fton_addr_line3 = checkForNull(rs.getString("FTON_ADDR_LINE3")); 
			fton_addr_line4 = checkForNull(rs.getString("FTON_ADDR_LINE4")); 
			fton_country_code = checkForNull(rs.getString("FTON_COUNTRY_CODE")); 
			fton_country_desc = checkForNull(rs.getString("FTON_COUNTRY_NAME")); 
			fton_postal_code = checkForNull(rs.getString("FTON_POSTAL_CODE")); 
			fton_region_code = checkForNull(rs.getString("CONTACT2_REGION_CODE")); 
			fton_region_desc = checkForNull(rs.getString("FTON_REGION_DESC")); 
			fton_res_area_code = checkForNull(rs.getString("CONTACT2_RES_AREA_CODE")); 
			fton_res_area_desc = checkForNull(rs.getString("FTON_AREA_DESC")); 
			fton_res_town_code = checkForNull(rs.getString("CONTACT2_RES_TOWN_CODE")); 
			fton_res_town_desc = checkForNull(rs.getString("FTON_TOWN_DESC")); 
			mail_addr_line1 = checkForNull(rs.getString("mail_addr_line1")); 
			mail_addr_line2 = checkForNull(rs.getString("mail_addr_line2")); 
			mail_addr_line3 = checkForNull(rs.getString("mail_addr_line3")); 
			mail_addr_line4 = checkForNull(rs.getString("mail_addr_line4")); 
			mail_country_code = checkForNull(rs.getString("mail_country_code")); 
			mail_country_desc = checkForNull(rs.getString("mail_country_name")); 
			mail_postal_code = checkForNull(rs.getString("mail_postal_code")); 
			mail_region_code = checkForNull(rs.getString("mail_region_code")); 
			mail_region_desc = checkForNull(rs.getString("mail_region_desc")); 
			mail_res_area_code = checkForNull(rs.getString("mail_res_area")); 
			mail_res_area_desc = checkForNull(rs.getString("mail_res_area_desc")); 
			mail_res_town_code = checkForNull(rs.getString("mail_res_town")); 
			mail_res_town_desc = checkForNull(rs.getString("mail_res_town_desc")); 
			nkin_addr_line1 = checkForNull(rs.getString("NKIN_ADDR_LINE1")); 
			nkin_addr_line2 = checkForNull(rs.getString("NKIN_ADDR_LINE2")); 
			nkin_addr_line3 = checkForNull(rs.getString("NKIN_ADDR_LINE3")); 
			nkin_addr_line4 = checkForNull(rs.getString("NKIN_ADDR_LINE4")); 
			nkin_country_code = checkForNull(rs.getString("NKIN_COUNTRY_CODE")); 
			nkin_country_desc = checkForNull(rs.getString("NKIN_COUNTRY_NAME")); 
			nkin_postal_code = checkForNull(rs.getString("NKIN_POSTAL_CODE")); 
			nkin_region_code = checkForNull(rs.getString("CONTACT1_REGION_CODE")); 
			nkin_region_desc = checkForNull(rs.getString("NKIN_REGION_DESC")); 
			nkin_res_area_code = checkForNull(rs.getString("CONTACT1_RES_AREA_CODE")); 
			nkin_res_area_desc = checkForNull(rs.getString("NKIN_AREA_DESC")); 
			nkin_res_town_code = checkForNull(rs.getString("CONTACT1_RES_TOWN_CODE")); 
			nkin_res_town_desc = checkForNull(rs.getString("NKIN_TOWN_DESC")); 
			postal_code = checkForNull(rs.getString("resi_postal_code")); 
			region_code		= checkForNull(rs.getString("region_code"));
			region_desc		= checkForNull(rs.getString("region_desc"));
			res_area_code	= checkForNull(rs.getString("res_area_code"));
			res_area_desc	= checkForNull(rs.getString("res_area_desc"));
			res_country_code = checkForNull(rs.getString("resi_country_code")); 
			res_country_desc = checkForNull(rs.getString("resi_country_name")); 
			res_town_code	= checkForNull(rs.getString("res_town_code"));
			res_town_desc	= checkForNull(rs.getString("res_town_desc"));

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/

			self_contact_no1		= checkForNull(rs.getString("self_contact_no1"));
			self_contact_no2		= checkForNull(rs.getString("self_contact_no2"));
			self_appl_email_id		= checkForNull(rs.getString("self_appl_email_id"));

			nkin_contact_no1		= checkForNull(rs.getString("nkin_contact_no1"));
			nkin_contact_no2		= checkForNull(rs.getString("nkin_contact_no2")); 
			nkin_appl_email_id		= checkForNull(rs.getString("nkin_appl_email_id")); 

			fton_contact_no1		= checkForNull(rs.getString("fton_contact_no1"));
			fton_contact_no2		= checkForNull(rs.getString("fton_contact_no2"));
			fton_appl_email_id		= checkForNull(rs.getString("fton_appl_email_id")); 

			emplr_contact_no1		= checkForNull(rs.getString("emplr_contact_no1"));
			emplr_contact_no2		= checkForNull(rs.getString("emplr_contact_no2"));

			/*ML-MMOH-CRF-0707*/
			next_of_kin_name  = checkForNull(rs.getString("next_of_kin_name")); // added by mujafar for ML-MMOH-CRF-0762 start
			next_of_kin_nat_id_no = checkForNull(rs.getString("next_of_kin_nat_id_no"));
			next_of_kin_alt_id_type = checkForNull(rs.getString("next_of_kin_alt_id_type"));
			next_of_kin_relation_code = checkForNull(rs.getString("next_of_kin_relation_code")); // added by mujafar for ML-MMOH-CRF-0762
			next_of_kin_alt_id_no   = checkForNull(rs.getString("next_of_kin_alt_id_no")); // added by mujafar for ML-MMOH-CRF-0762 end
		}

		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();

	}catch(Exception e) 
	{
		//out.println("Exception in Query 6 : "+e);
		e.printStackTrace();
	}
	finally
	{
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}

            _bw.write(_wl_block10_0Bytes, _wl_block10_0);
            _bw.write(_wl_block10_1Bytes, _wl_block10_1);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block12Bytes, _wl_block12);
	if(!request_id.equals(""))
	{	
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(selitem));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(from));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
	}			
	else
	{	
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(params));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);

StringBuffer requestorType=new StringBuffer("RequestorTypeValue();");
if(call_function.equals("MEDICAL_REPORT_CANCELLED")){ 
	requestorType.append("disableAll();");
}if(call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED"))  {
	requestorType.append("transMode();");
}
if(call_function.equals("MEDICAL_REPORT_STATUS") && isSpecialtyDefaultApp)  {
	requestorType.append("showMsgSpecialty();");	
}
JSONArray medicalrepteamJsonArr 		= new JSONArray();
JSONArray medicalrepteamJsonArrView 	= new JSONArray();
if(isMedicalTeamApplicable) {
	medicalrepteamJsonArr  		= eMR.MRCommonBean.getMedicalTeamList(con,Facility_Id,specialtyCodeMedicalTeam,"E",locale);//Modified By Dharma on 9th Dec 2019 against ML-MMOH-CRF-1454
	medicalrepteamJsonArrView  	= eMR.MRCommonBean.getMedicalTeamList(con,Facility_Id,specialtyCodeMedicalTeam,"",locale);//Modified By Dharma on 9th Dec 2019 against ML-MMOH-CRF-1454
}




            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(requestorType.toString()));
            _bw.write(_wl_block28Bytes, _wl_block28);
	if(call_function.equals("MEDICAL_REPORT_REQUEST"))
		{	
            _bw.write(_wl_block29Bytes, _wl_block29);
	}
		else
		{	
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
	}	
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
		if(call_function.equals("MEDICAL_REPORT_REQUEST"))
		{	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block32Bytes, _wl_block32);
	}else{	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(reqDate_converted));
            _bw.write(_wl_block32Bytes, _wl_block32);
	}	
            _bw.write(_wl_block37Bytes, _wl_block37);
if(isPatDtlMedRepAppl){
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patt_name));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
 if(patient_gender.equals("M"))
		{
			genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}
		else if(patient_gender.equals("F")) {
			genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}
		else if(patient_gender.equals("U")) {
			genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
     
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(genderdesc));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
	if(accept_national_id_no_yn.equals("Y"))
		{	
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
	}else{	
            _bw.write(_wl_block50Bytes, _wl_block50);
	}	
            _bw.write(_wl_block51Bytes, _wl_block51);
	if(!alt_id1_type.equals(""))
		{	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
	}else{	
            _bw.write(_wl_block53Bytes, _wl_block53);
	}	
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
				
		String data = "";
		String code = "";
		String sel = "";

		appl_typeStmt=con.createStatement();
		appl_typeRS=appl_typeStmt.executeQuery(" select appl_type_code, short_desc from MR_APPL_TYPE_LANG_VW where eff_status = 'E' and language_id = '"+locale+"' order by SHORT_DESC ");
		if(appl_typeRS!=null)
		{
			sel="";
			while(appl_typeRS.next())
			{
				data = appl_typeRS.getString("SHORT_DESC");
				code = appl_typeRS.getString("APPL_TYPE_CODE");
				if(appl_type_code.equals(code))
					sel = "selected";
				else
					sel="";

				out.println("<option value='"+code+"' "+sel+">"+data+"</option>");
			}
		}	
		
		if(appl_typeRS != null)appl_typeRS.close();
		if(appl_typeStmt != null)appl_typeStmt.close();
	
		
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(visibility_img));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

		String letterDateTime	= application_date;
		if(call_function.equals("MEDICAL_REPORT_REQUEST")){
			letterDateTime	= SystemDate_display;
		}
		
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(letterDateTime));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(visibility_img));
            _bw.write(_wl_block69Bytes, _wl_block69);


if(!classification_appl_yn) // added by mujafar for ML-MMOH-CRF-0762 start
{

            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(applicant_name));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(applicant_name));
            _bw.write(_wl_block74Bytes, _wl_block74);
}
//else block commented By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
/*else
{

            _bw.write(_wl_block75Bytes, _wl_block75);
} // added by mujafar for ML-MMOH-CRF-0762 end
*/

            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
if(isSpecialtyDefaultApp){
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(application_ref_no));
            _bw.write(_wl_block80Bytes, _wl_block80);
}else{ 
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(application_ref_no));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block83Bytes, _wl_block83);
 
	
	if(isOurRefApplicable){
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(ourRefDtlsDisp));
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block87Bytes, _wl_block87);
if(classification_appl_yn)
{ // added by mujafar for ML-MMOH-CRF-0762
		
	
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(dis_req));
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

				JSONArray RequestorTypeJsonArr = new JSONArray();
				RequestorTypeJsonArr  = eMR.MRCommonBean.getRequestorTypeForRequestor(con);

				for(int i = 0 ; i < RequestorTypeJsonArr.size() ; i++) 
				{
					JSONObject json	= (JSONObject)RequestorTypeJsonArr.get(i);
					String requestor_type_code  = (String) json.get("requestor_type_code");
					String long_desc  = (String) json.get("long_desc");
					out.println("<option value='"+requestor_type_code+ "'>"+long_desc+"</option>");	
				}		
			
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(dis_req));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(requestor_desc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(dis_req));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(requestor_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(dis_req));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(applicant_name));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(applicant_name));
            _bw.write(_wl_block97Bytes, _wl_block97);
} // added by mujafar for ML-MMOH-CRF-0762 end


            _bw.write(_wl_block98Bytes, _wl_block98);
if(isChckLstApplicable){
	if(!classification_appl_yn) 
	{ // added by mujafar for ML-MMOH-CRF-0762
		
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
}}else{
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block104Bytes, _wl_block104);

	if(!classification_appl_yn)
	{ // added by mujafar for ML-MMOH-CRF-0762
	
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
	
if(!call_function.equals(""))
{
	if(relationship_type.equals(""))
		out.println("<script>document.getElementById('relationship_type').options[0].selected=true;</script>");
	else if(relationship_type.equals("0"))
		out.println("<script>document.getElementById('relationship_type').options[1].selected=true;</script>");	
	else if(relationship_type.equals("1"))
		out.println("<script>document.getElementById('relationship_type').options[2].selected=true;</script>");
	else if(relationship_type.equals("2"))
		out.println("<script>document.getElementById('relationship_type').options[3].selected=true;</script>");
	else if(relationship_type.equals("3"))
		out.println("<script>document.getElementById('relationship_type').options[4].selected=true;</script>");
	else if(relationship_type.equals("4"))
		out.println("<script>document.getElementById('relationship_type').options[5].selected=true;</script>");
}	
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(disable1));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

		String rel_sel ="";                                     
		String rel_data ="";                                     
		String rel_code ="";    
		
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();

		String rel_sql = " select relationship_code, short_desc from MP_RELATIONSHIP_LANG_VW where eff_status='E' and language_id = '"+locale+"' order by short_desc ";

		stmt = con.createStatement();
		rs = stmt.executeQuery (rel_sql) ;
		if(rs != null)
		{
			while(rs.next())
			{
				rel_data = rs.getString("SHORT_DESC");
				rel_code = rs.getString("relationship_code");
					if(relationship_code.equals(rel_code))
						rel_sel = "selected";
					else
						rel_sel="";
	
				out.println("<option value='"+rel_code+"' "+rel_sel+">"+rel_data+"</option>");
			}
		}	
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();

            _bw.write(_wl_block117Bytes, _wl_block117);
if(classification_appl_yn)
	{ // added by mujafar for ML-MMOH-CRF-0762
		 if(accept_national_id_no_yn.equals("Y") ){
		
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(dis_req));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(nat_id));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block122Bytes, _wl_block122);
}}
            _bw.write(_wl_block123Bytes, _wl_block123);

if(classification_appl_yn)
{ // added by mujafar for ML-MMOH-CRF-0762 start
	
	if(accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(dis_req));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

					  sqlAlt.append("select alt_id_type,mp_get_desc.mp_alternate_id_type(alt_id_type,'"+locale+"','1') short_desc from  mp_alternate_id_type where  alt_id_type not in (select alt_id1_type   from mp_param where module_id='MP' union select  nvl(alt_id2_type,1) from mp_param where module_id='MP' union  select nvl(alt_id3_type,2) from mp_param where module_id='MP' union select nvl(alt_id4_type,3) from  mp_param where module_id='MP') and eff_status='E' order by 2");
					  oth_stmt = con.createStatement();
					  oth_rset = oth_stmt.executeQuery(sqlAlt.toString());	
				
					  if(oth_rset != null)
					  {
						while (oth_rset.next())
						{          
						  out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
						}
					  }
                     if(oth_rset!=null) oth_rset.close();
                     if(oth_stmt!=null) oth_stmt.close();

				    
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(dis_req));
            _bw.write(_wl_block129Bytes, _wl_block129);

}} // added by mujafar for ML-MMOH-CRF-0762 end

            _bw.write(_wl_block1Bytes, _wl_block1);
if(!classification_appl_yn)
{ // added by mujafar for ML-MMOH-CRF-0762

            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

				JSONArray RequestorTypeJsonArr = new JSONArray();
				RequestorTypeJsonArr  = eMR.MRCommonBean.getRequestorTypeForRequestor(con);

				for(int i = 0 ; i < RequestorTypeJsonArr.size() ; i++) 
				{
					JSONObject json	= (JSONObject)RequestorTypeJsonArr.get(i);
					String requestor_type_code  = (String) json.get("requestor_type_code");
					String long_desc  = (String) json.get("long_desc");
					out.println("<option value='"+requestor_type_code+ "'>"+long_desc+"</option>");	
				}		
			
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(requestor_desc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block135Bytes, _wl_block135);
}
            _bw.write(_wl_block136Bytes, _wl_block136);

//Below Condition Added By Dharma on Apr 9th against ML-MMOH-CRF-1314	
if(!isAcceptRequestByPractAppl){
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

	if(!call_function.equals(""))
	{	
		if(cons_letter.equals(""))
			out.println("<script>document.getElementById('cons_letter').options[0].selected=true;</script>");
		if(cons_letter.equals("0"))
			out.println("<script>document.getElementById('cons_letter').options[1].selected=true;</script>");
		else if(cons_letter.equals("1"))
			out.println("<script>document.getElementById('cons_letter').options[2].selected=true;</script>");
		else if(cons_letter.equals("2"))
			out.println("<script>document.getElementById('cons_letter').options[3].selected=true;</script>");
	}

	if(call_function.equals("MEDICAL_REPORT_STATUS"))
		out.println("<script>document.getElementById('cons_letter').disabled=false;</script>");
}

            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(for_attn_of));
            _bw.write(_wl_block141Bytes, _wl_block141);

//Below Condition Added By Dharma on Apr 9th against ML-MMOH-CRF-1314	
if(!isAcceptRequestByPractAppl){
            _bw.write(_wl_block142Bytes, _wl_block142);
}
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(appl_no));
            _bw.write(_wl_block144Bytes, _wl_block144);
	if(!call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MEDICAL_REPORT_STATUS"))
	
	{	
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckList.label","mr_labels")));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DateDetails.label","mr_labels")));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ChargesDetails.label","mr_labels")));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicantAddress.label","mr_labels")));
            _bw.write(_wl_block149Bytes, _wl_block149);
if(!classification_appl_yn){
            _bw.write(_wl_block150Bytes, _wl_block150);
}else{
            _bw.write(_wl_block151Bytes, _wl_block151);
}
            _bw.write(_wl_block152Bytes, _wl_block152);
	}else{
            _bw.write(_wl_block153Bytes, _wl_block153);
if(call_function.equals("MEDICAL_REPORT_STATUS")){
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckList.label","mr_labels")));
            _bw.write(_wl_block155Bytes, _wl_block155);
}else{
            _bw.write(_wl_block156Bytes, _wl_block156);
}
            _bw.write(_wl_block157Bytes, _wl_block157);
if(isChckLstApplicable){
            _bw.write(_wl_block158Bytes, _wl_block158);
if(call_function.equals("MEDICAL_REPORT_REQUEST")){
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckList.label","mr_labels")));
            _bw.write(_wl_block155Bytes, _wl_block155);
}
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(disable1));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicantAddress.label","mr_labels")));
            _bw.write(_wl_block149Bytes, _wl_block149);
if(!classification_appl_yn){
            _bw.write(_wl_block150Bytes, _wl_block150);
}else{
            _bw.write(_wl_block151Bytes, _wl_block151);
}
            _bw.write(_wl_block161Bytes, _wl_block161);
	}	
            _bw.write(_wl_block162Bytes, _wl_block162);
	if(call_function.equals("MEDICAL_REPORT_REQUEST") || call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
	{	
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);
 if(isOutstandingAmtMedRepAppl){ 
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
 if (bl_install_yn.equals("Y") && (outst_amt > 0)) {
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(outst_amt1));
            _bw.write(_wl_block168Bytes, _wl_block168);
 } 
            _bw.write(_wl_block169Bytes, _wl_block169);
 } 
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(disabledAttribute));
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(amount));
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(addl_amount));
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(receipt_no));
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(addl_receipt_no));
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(receipt_date_converted));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block187Bytes, _wl_block187);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(addl_receipt_date_converted));
            _bw.write(_wl_block189Bytes, _wl_block189);

		if(!call_function.equals(""))
		{	
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(charges_appl_yn));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(addl_charges_yn));
            _bw.write(_wl_block192Bytes, _wl_block192);
	}	
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block197Bytes, _wl_block197);
	
		if(call_function.equals("MEDICAL_REPORT_REQUEST"))
		{
			for( int i=0; i<10; i++)
			{
				out.println("<tr><td class=label colspan='4'>&nbsp;</td></tr>");
			}
		}

            _bw.write(_wl_block198Bytes, _wl_block198);
	}	

/*Added by Ashwini on 16-Aug-2018 for ML-MMOH-CRF-0722*/
else
{ 
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(charges_appl_yn));
            _bw.write(_wl_block200Bytes, _wl_block200);
 }
/*End ML-MMOH-CRF-0722*/

if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
{	
            _bw.write(_wl_block201Bytes, _wl_block201);
}
if(!call_function.equals("MEDICAL_REPORT_STATUS") && !call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MEDICAL_REPORT_CANCELLED"))
{	
            _bw.write(_wl_block202Bytes, _wl_block202);

	if(isAcceptRequestByPractAppl)
	{// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		
	
            _bw.write(_wl_block203Bytes, _wl_block203);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);
if(call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED")){
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
}else{
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block205Bytes, _wl_block205);
}else{
            _bw.write(_wl_block206Bytes, _wl_block206);
}
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);

		if(ca_install_yn.equals("Y"))
		{
			Statement stm = null;
			ResultSet rss = null;
			String repType_sel = "";
			try
			{
				String sqlrep = " select NOTE_TYPE, NOTE_TYPE_DESC from CA_NOTE_TYPE where note_group_id in (select note_group from ca_note_group where appl_task_id = 'MR_MEDICAL_REPORT') and EFF_STATUS = 'E' order by NOTE_TYPE_DESC ";
				stm = con.createStatement();
				rss = stm.executeQuery(sqlrep);
				if(rss!=null)
				{
					while(rss.next())
					{
						String repcode = rss.getString("NOTE_TYPE");
						String repdesc = rss.getString("NOTE_TYPE_DESC");
						if(report_type_code.equals(repcode))
							repType_sel = "selected";
						else
							repType_sel="";

						out.println("<option value='"+repcode+"' "+repType_sel+">"+repdesc+"</option>");
					}
				}
			}
			catch(Exception e)
			{
				//out.println("Exception in rep_type : "+e.toString());
				e.printStackTrace();
			}
			finally
			{
				if(rss!=null) rss.close();
				if(stm!=null) stm.close();
			}
		}
		
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(visibility_img));
            _bw.write(_wl_block212Bytes, _wl_block212);

			if(!isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REQUEST_ACCEPTED") || call_function.equals("RECEIVE_MEDICAL_REPORT") && isRejectReportApplicable) { // added by mujafar for ML-MMOH-CRF-0714
			//String selectStatus	= "";
			String enableStatus	= "";
			if(call_function.equals("REQUEST_ACCEPTED")){
				enableStatus	= "disabled";
			}
			
			
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(enableStatus));
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);
if(call_function.equals("FORWARD_TO_HOD") && isSelfStatusMRPApplicable){ // added by mujafar for ML-MMOH-CRF-0718 
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);
}
            _bw.write(_wl_block219Bytes, _wl_block219);
}else{
            _bw.write(_wl_block220Bytes, _wl_block220);
}
			
			}else{
				if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD")|| call_function.equals("REQUEST_RETURNED")){	
				
            _bw.write(_wl_block221Bytes, _wl_block221);
}
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block228Bytes, _wl_block228);
}
            _bw.write(_wl_block229Bytes, _wl_block229);
if(call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED"))
		{
			if(isChckLstApplicable){
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(disableModes));
            _bw.write(_wl_block232Bytes, _wl_block232);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);

								for(int i = 0 ; i < TransApplModeJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)TransApplModeJsonArr.get(i);
									String transport_mode  = (String) json.get("transport_mode");;
									String short_desc  = (String) json.get("short_desc");;
									out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
									}		
							
            _bw.write(_wl_block234Bytes, _wl_block234);
if(call_function.equals("DELIVER_MEDICAL_REPORT")){
            _bw.write(_wl_block235Bytes, _wl_block235);
}
            _bw.write(_wl_block236Bytes, _wl_block236);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(disableModes));
            _bw.write(_wl_block238Bytes, _wl_block238);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);

								for(int i = 0 ; i < TransCollModeJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)TransCollModeJsonArr.get(i);
									String transport_mode  = (String) json.get("transport_mode");;
									String short_desc  = (String) json.get("short_desc");;
									out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
									}		
							
            _bw.write(_wl_block239Bytes, _wl_block239);
if(call_function.equals("DELIVER_MEDICAL_REPORT")){
            _bw.write(_wl_block235Bytes, _wl_block235);
}
            _bw.write(_wl_block240Bytes, _wl_block240);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(disableModes));
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);

							for(int i = 0 ; i < TransNotifiModeJsonArr.size() ; i++) 
								{
								JSONObject json	= (JSONObject)TransNotifiModeJsonArr.get(i);
								String transport_mode  = (String) json.get("transport_mode");;
								String short_desc  = (String) json.get("short_desc");;
								out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
								}		
						
            _bw.write(_wl_block244Bytes, _wl_block244);
if(call_function.equals("DELIVER_MEDICAL_REPORT")){
            _bw.write(_wl_block245Bytes, _wl_block245);
}
            _bw.write(_wl_block246Bytes, _wl_block246);
}
		}
            _bw.write(_wl_block247Bytes, _wl_block247);
if(!isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block250Bytes, _wl_block250);
}else{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 start
				
				
				
				if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD") || call_function.equals("REQUEST_RETURNED"))
				{
            _bw.write(_wl_block251Bytes, _wl_block251);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(forwarded_hod_cord_name));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(forwarded_hod_cord_id));
            _bw.write(_wl_block254Bytes, _wl_block254);
if(isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716 
            _bw.write(_wl_block255Bytes, _wl_block255);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

								
									for(int i = 0 ; i < medicalrepteamJsonArr.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArr.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										out.println("<option value='"+teamCode+ "' title='"+pract_list+"'>"+teamDesc+"</option>");
										
								}		
					
            _bw.write(_wl_block257Bytes, _wl_block257);
}
            _bw.write(_wl_block258Bytes, _wl_block258);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block261Bytes, _wl_block261);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(inform_hod_cord_name));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(inform_hod_cord_id));
            _bw.write(_wl_block264Bytes, _wl_block264);
if(isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716 
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

									for(int i = 0 ; i < medicalrepteamJsonArr.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArr.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										out.println("<option value='"+teamCode+ "' title='"+pract_list+"'>"+teamDesc+"</option>");
										
								}
					
            _bw.write(_wl_block266Bytes, _wl_block266);
}
            _bw.write(_wl_block267Bytes, _wl_block267);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block269Bytes, _wl_block269);
}
				else if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REQUEST_ACCEPTED") ) {
					
					
					
					String dis_inf_hod = ""; //added by mujafar for ML-MMOH-CRF-1279 
				String dis_inf_team = "";
				if(!inform_hod_cord_id.equals("") && inform_medical_team.equals(""))
					dis_inf_team = "disabled";
				if(inform_hod_cord_id.equals("") && !inform_medical_team.equals(""))
					dis_inf_hod = "disabled"; 
			
            _bw.write(_wl_block270Bytes, _wl_block270);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(forwarded_hod_cord_name));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(forwarded_hod_cord_id));
            _bw.write(_wl_block273Bytes, _wl_block273);
if(isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716 
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block275Bytes, _wl_block275);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

																
								String sel_1 = "";
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++)	{
									JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
									String teamCode  = (String) json1.get("team_id");
									String teamDesc  = (String) json1.get("short_desc");
									String pract_list  = (String) json1.get("pract_list");
									if(forwarded_medical_team.equals(teamCode))
										sel_1 = "selected";
									else
										sel_1 = "";
									out.println("<option value='"+teamCode+ "'  "+sel_1+"   title='"+pract_list+"'>"+teamDesc+"</option>");
									
							}
								
								
								
					
            _bw.write(_wl_block257Bytes, _wl_block257);
}
            _bw.write(_wl_block276Bytes, _wl_block276);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(dis_inf_hod));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(inform_hod_cord_name));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(inform_hod_cord_id));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(dis_inf_hod));
            _bw.write(_wl_block281Bytes, _wl_block281);
if(isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716 
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(dis_inf_team));
            _bw.write(_wl_block283Bytes, _wl_block283);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

																
								String sel_2 = "";
								
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										if(inform_medical_team.equals(teamCode))
											sel_2 = "selected";
										else
											sel_2 = "";
										out.println("<option value='"+teamCode+ "'  "+sel_2+" title='"+pract_list+"' >"+teamDesc+"</option>");
										
								}
					
            _bw.write(_wl_block257Bytes, _wl_block257);
}
            _bw.write(_wl_block284Bytes, _wl_block284);
if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REQUEST_RETURNED")
					|| call_function.equals("REQUEST_ACCEPTED") ){
				
				
            _bw.write(_wl_block285Bytes, _wl_block285);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block286Bytes, _wl_block286);
}
            _bw.write(_wl_block287Bytes, _wl_block287);
}}
// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 end

            _bw.write(_wl_block288Bytes, _wl_block288);

		if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REQUEST_RETURNED"))
			out.println("<script>document.getElementById('DeptImg').style.visibility = 'visible';</script>");		

            _bw.write(_wl_block104Bytes, _wl_block104);
	if(new_func_id.equals("APP_FOR_MED_BOARD"))
		{
		
            _bw.write(_wl_block289Bytes, _wl_block289);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block290Bytes, _wl_block290);
	}	
            _bw.write(_wl_block291Bytes, _wl_block291);

	if(isAcceptRequestByPractAppl)
	{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	 String mrd_disp="";
	 if(!(call_function.equals("FORWARD_MEDICAL_REPORT")|| call_function.equals("REJECTED_BY_PRACT_TO_MRD") )) mrd_disp= "disabled";

	
            _bw.write(_wl_block292Bytes, _wl_block292);
	/////////////////////////////// DISPLAY ONLY ////////////////////////
if(call_function.equals("PREPARE_MEDICAL_REPORT") || 
call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED") ||
call_function.equals("REVISE_MEDICAL_REPORT")  ||
call_function.equals("QUERY_DELAY_IN_MRR") || call_function.equals("ACCEPTED_BY_PRACTITIONER") )
{	
if(isAcceptRequestByPractAppl){

            _bw.write(_wl_block293Bytes, _wl_block293);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(CollectDate_Converted));
            _bw.write(_wl_block295Bytes, _wl_block295);
	if(!revised_collect_date.equals(""))
	{	
            _bw.write(_wl_block296Bytes, _wl_block296);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(revised_collect_date_converted));
            _bw.write(_wl_block298Bytes, _wl_block298);
	}else{	
            _bw.write(_wl_block299Bytes, _wl_block299);
	}	
            _bw.write(_wl_block300Bytes, _wl_block300);

}}
// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316

            _bw.write(_wl_block301Bytes, _wl_block301);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(mrd_disp));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block304Bytes, _wl_block304);




	if(!(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REVISE_MEDICAL_REPORT"))){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316

	 if(!call_function.equals("REJECTED_BY_PRACT_TO_MRD"))
	 {
            _bw.write(_wl_block305Bytes, _wl_block305);
if(isAcceptRequestByPractAppl && ((call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED"))&& !called_from.equals("CA"))){
            _bw.write(_wl_block306Bytes, _wl_block306);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
}else{
            _bw.write(_wl_block307Bytes, _wl_block307);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block308Bytes, _wl_block308);

	 }
if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD")  || call_function.equals("REQUEST_ACCEPTED") || call_function.equals("RECEIVE_MEDICAL_REPORT") && isRejectReportApplicable) { // added by mujafar for ML-MMOH-CRF-0714
			
			String enableStatus	= "";
			if(call_function.equals("REQUEST_ACCEPTED")){
				enableStatus	= "disabled";
			}
			

			
			
            _bw.write(_wl_block309Bytes, _wl_block309);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block310Bytes, _wl_block310);
if(call_function.equals("RECEIVE_MEDICAL_REPORT")){
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(enableStatus));
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);
}else{
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(enableStatus));
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);
}
            _bw.write(_wl_block314Bytes, _wl_block314);
if((call_function.equals("FORWARD_TO_HOD")|| call_function.equals("REJECTED_BY_PRACT_TO_HOD") )&& isSelfStatusMRPApplicable){ // added by mujafar for ML-MMOH-CRF-0718 
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);
}
            _bw.write(_wl_block315Bytes, _wl_block315);
if(!call_function.equals("RECEIVE_MEDICAL_REPORT")){
            _bw.write(_wl_block316Bytes, _wl_block316);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block317Bytes, _wl_block317);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block320Bytes, _wl_block320);
}else{
            _bw.write(_wl_block321Bytes, _wl_block321);
}
            _bw.write(_wl_block322Bytes, _wl_block322);

				if(isRejectRequestApplicable && (call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REQUEST_ACCEPTED")) )
				{ // added by mujafar for ML-MMOH-CRF-0713
				// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
			
            _bw.write(_wl_block323Bytes, _wl_block323);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block324Bytes, _wl_block324);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block325Bytes, _wl_block325);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

								JSONArray medicalreprejectreasonJsonArr = new JSONArray();
								medicalreprejectreasonJsonArr  = eMR.MRCommonBean.getRejectReasonList(con);	
								
								for(int i = 0 ; i < medicalreprejectreasonJsonArr.size() ; i++) 
								{
										JSONObject json1	= (JSONObject)medicalreprejectreasonJsonArr.get(i);
										String reasonCode  = (String) json1.get("reasonCode");;
										String reasonDesc  = (String) json1.get("reasonDesc");;
										out.println("<option value='"+reasonCode+ "'>"+reasonDesc+"</option>");
										
								}		
					
            _bw.write(_wl_block326Bytes, _wl_block326);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block328Bytes, _wl_block328);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block329Bytes, _wl_block329);

				String dis_ack_hod = ""; //added by mujafar for ML-MMOH-CRF-0716 start
				String dis_ack_team = "";
				if(!ack_hod_cord_id.equals("") && ack_medical_team.equals(""))
					dis_ack_team = "disabled";
				if(ack_hod_cord_id.equals("") && !ack_medical_team.equals(""))
					dis_ack_hod = "disabled"; //added by mujafar for ML-MMOH-CRF-0716 end
				
				
            _bw.write(_wl_block330Bytes, _wl_block330);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(dis_ack_hod));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(ack_hod_cord_name));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(ack_hod_cord_id));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(dis_ack_hod));
            _bw.write(_wl_block335Bytes, _wl_block335);
            _bw.write(_wl_block336Bytes, _wl_block336);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(inform_to_pract_name));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(inform_to_pract_id));
            _bw.write(_wl_block339Bytes, _wl_block339);
}
            _bw.write(_wl_block340Bytes, _wl_block340);
}
if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") ||call_function.equals("REQUEST_ACCEPTED")||call_function.equals("REQUEST_RETURNED"))
{
	String selectStatus	= "";
				if(!call_function.equals("FORWARD_TO_HOD") && !call_function.equals("REJECTED_BY_PRACT_TO_HOD") && !call_function.equals("REQUEST_ACCEPTED")){
					
				selectStatus	= "disabled";
			}

            _bw.write(_wl_block341Bytes, _wl_block341);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(selectStatus));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(remarks_hod));
            _bw.write(_wl_block343Bytes, _wl_block343);

	}
}
            _bw.write(_wl_block104Bytes, _wl_block104);
}else{
            _bw.write(_wl_block344Bytes, _wl_block344);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block346Bytes, _wl_block346);
}
            _bw.write(_wl_block347Bytes, _wl_block347);
} 
            _bw.write(_wl_block348Bytes, _wl_block348);
	if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD") || call_function.equals("REQUEST_RETURNED"))
		{	
		
	
            _bw.write(_wl_block349Bytes, _wl_block349);
if(!isAcceptRequestByPractAppl){
			// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			
            _bw.write(_wl_block350Bytes, _wl_block350);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(forwarded_hod_cord_name));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(forwarded_hod_cord_id));
            _bw.write(_wl_block352Bytes, _wl_block352);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block353Bytes, _wl_block353);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(inform_hod_cord_name));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(inform_hod_cord_id));
            _bw.write(_wl_block355Bytes, _wl_block355);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block356Bytes, _wl_block356);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block357Bytes, _wl_block357);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block358Bytes, _wl_block358);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block359Bytes, _wl_block359);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block361Bytes, _wl_block361);
}
            _bw.write(_wl_block362Bytes, _wl_block362);

	
	if(isMedicalReportRequest && (call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD"))){
	// modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	//Modified By Dharma on 25th Mar 2020 against ML-MMOH-CRF-1473
	
            _bw.write(_wl_block363Bytes, _wl_block363);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block364Bytes, _wl_block364);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block365Bytes, _wl_block365);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block366Bytes, _wl_block366);
if(call_function.equals("FORWARD_TO_HOD")){
            _bw.write(_wl_block367Bytes, _wl_block367);
}else{
            _bw.write(_wl_block368Bytes, _wl_block368);
}
            _bw.write(_wl_block369Bytes, _wl_block369);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

								JSONArray medicalrepreasonJsonArr = new JSONArray();
								medicalrepreasonJsonArr  = eMR.MRCommonBean.getReasonList(con);	
								
								for(int i = 0 ; i < medicalrepreasonJsonArr.size() ; i++) 
								{
										JSONObject json1	= (JSONObject)medicalrepreasonJsonArr.get(i);
										String reasonCode  = (String) json1.get("reasonCode");;
										String reasonDesc  = (String) json1.get("reasonDesc");;
										out.println("<option value='"+reasonCode+ "'>"+reasonDesc+"</option>");
										
								}		
					
            _bw.write(_wl_block370Bytes, _wl_block370);
}
            _bw.write(_wl_block371Bytes, _wl_block371);
	}
	else if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REQUEST_ACCEPTED") ) 
	{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
	
	
            _bw.write(_wl_block372Bytes, _wl_block372);
if(!isAcceptRequestByPractAppl){
		
		
            _bw.write(_wl_block373Bytes, _wl_block373);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block374Bytes, _wl_block374);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(forwarded_hod_cord_name));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(forwarded_hod_cord_id));
            _bw.write(_wl_block376Bytes, _wl_block376);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(inform_hod_cord_name));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(inform_hod_cord_id));
            _bw.write(_wl_block379Bytes, _wl_block379);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(requesting_pract_id));
            _bw.write(_wl_block382Bytes, _wl_block382);

		  		String dis_ack_hod = ""; //added by mujafar for ML-MMOH-CRF-0716 start
				String dis_ack_team = "";
				if(!ack_hod_cord_id.equals("") && ack_medical_team.equals(""))
					dis_ack_team = "disabled";
				if(ack_hod_cord_id.equals("") && !ack_medical_team.equals(""))
					dis_ack_hod = "disabled"; //added by mujafar for ML-MMOH-CRF-0716 end
				
				
            _bw.write(_wl_block383Bytes, _wl_block383);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(dis_ack_hod));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(ack_hod_cord_name));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(ack_hod_cord_id));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(dis_ack_hod));
            _bw.write(_wl_block385Bytes, _wl_block385);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(inform_to_pract_name));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(inform_to_pract_id));
            _bw.write(_wl_block386Bytes, _wl_block386);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block358Bytes, _wl_block358);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block359Bytes, _wl_block359);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block387Bytes, _wl_block387);
}
				if(isRejectRequestApplicable && call_function.equals("FORWARD_TO_HOD") ) {	
				
            _bw.write(_wl_block388Bytes, _wl_block388);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block391Bytes, _wl_block391);
}
            _bw.write(_wl_block392Bytes, _wl_block392);
}
            _bw.write(_wl_block393Bytes, _wl_block393);
	
String selectStatus_C="";
if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
	{	

	/*
	SRR20056-SCF-2925 Friday, April 03, 2009
	*/
	req_status=checkForNull(request.getParameter("req_status"));
	
	String selectStatus_I="";
	 if(req_status.equals("7"))
		 selectStatus_I="selected";
	 if(req_status.equals("8") || req_status.equals("99")) //Modified by Thamizh selvi on 17th July 2017 for ML-MMOH-CRF-0719
		 selectStatus_C="selected";
	 /*
	SRR20056-SCF-2925 Friday, April 03, 2009
	*/

		 
            _bw.write(_wl_block289Bytes, _wl_block289);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block394Bytes, _wl_block394);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block395Bytes, _wl_block395);

            if (_jsp__tag130(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(selectStatus_I));
            _bw.write(_wl_block397Bytes, _wl_block397);

            if (_jsp__tag131(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(selectStatus_C));
            _bw.write(_wl_block397Bytes, _wl_block397);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block399Bytes, _wl_block399);
if(isMedicalReportDurationAppl)
			{
				
            _bw.write(_wl_block400Bytes, _wl_block400);

			}
			else
			{
			
            _bw.write(_wl_block401Bytes, _wl_block401);

			collection_date =  eCommon.Common.CommonBean.getCollectionDate(con);
			}
			
			
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block403Bytes, _wl_block403);
 //collection_date =  eCommon.Common.CommonBean.getCollectionDate(con);/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/

            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(collection_date));
            _bw.write(_wl_block405Bytes, _wl_block405);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(isMedicalReportDurationAppl));
            _bw.write(_wl_block407Bytes, _wl_block407);
 if(isIncompReqCancelApplicable){ 
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block409Bytes, _wl_block409);
 } 
            _bw.write(_wl_block410Bytes, _wl_block410);
if(isChckLstApplicable){
            _bw.write(_wl_block411Bytes, _wl_block411);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);

								for(int i = 0 ; i < TransApplModeJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)TransApplModeJsonArr.get(i);
									String transport_mode  = (String) json.get("transport_mode");;
									String short_desc  = (String) json.get("short_desc");;
									out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
									}		
							
            _bw.write(_wl_block412Bytes, _wl_block412);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);

								for(int i = 0 ; i < TransCollModeJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)TransCollModeJsonArr.get(i);
									String transport_mode  = (String) json.get("transport_mode");;
									String short_desc  = (String) json.get("short_desc");;
									out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
									}		
							
            _bw.write(_wl_block413Bytes, _wl_block413);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);
	
								for(int i = 0 ; i < TransNotifiModeJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)TransNotifiModeJsonArr.get(i);
									String transport_mode  = (String) json.get("transport_mode");;
									String short_desc  = (String) json.get("short_desc");;
									out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
									}		
							
            _bw.write(_wl_block414Bytes, _wl_block414);
}
            _bw.write(_wl_block415Bytes, _wl_block415);
 if(isIncompReqCancelApplicable){ 
            _bw.write(_wl_block416Bytes, _wl_block416);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

								JSONArray reasonJsonArr = new JSONArray();
								reasonJsonArr  = eMR.MRCommonBean.getReasonList(con);	
								
								for(int i = 0 ; i < reasonJsonArr.size() ; i++) 
								{
										JSONObject json	= (JSONObject)reasonJsonArr.get(i);
										String reasonCode  = (String) json.get("reasonCode");;
										String reasonDesc  = (String) json.get("reasonDesc");;
										out.println("<option value='"+reasonCode+ "'>"+reasonDesc+"</option>");
										
								}		
					
            _bw.write(_wl_block417Bytes, _wl_block417);
 } 
            _bw.write(_wl_block418Bytes, _wl_block418);
		}	
		// commented for ML-MMOH-CRF-0391
		if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
		//if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
		{	
            _bw.write(_wl_block419Bytes, _wl_block419);
if(isSpecialtyDefaultApp){
            _bw.write(_wl_block420Bytes, _wl_block420);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block421Bytes, _wl_block421);
if(!selectStatus_C.equals("")){ 
            _bw.write(_wl_block422Bytes, _wl_block422);
} 
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block424Bytes, _wl_block424);
} 
            _bw.write(_wl_block420Bytes, _wl_block420);

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(requesting_pract_id));
            _bw.write(_wl_block427Bytes, _wl_block427);
	}	
		if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REQUEST_RETURNED"))
		{	
			for( int i=0; i<10; i++)
			{
				out.println("<tr><td class=label colspan='4'>&nbsp;</td></tr>");
			}
		}

		if(call_function.equals("RECEIVE_MEDICAL_REPORT"))
		{	
            _bw.write(_wl_block428Bytes, _wl_block428);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block430Bytes, _wl_block430);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(forwarded_hod_cord_name));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(forwarded_hod_cord_id));
            _bw.write(_wl_block433Bytes, _wl_block433);
if(isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716
				disabled = "disabled";
				
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block435Bytes, _wl_block435);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

																
								String sel_1 = "";
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										if(forwarded_medical_team.equals(teamCode))
											sel_1 = "selected";
										else
											sel_1 = "";
										out.println("<option value='"+teamCode+ "'  "+sel_1+" title= '"+pract_list+"' >"+teamDesc+"</option>");
										
								}
					
            _bw.write(_wl_block436Bytes, _wl_block436);
}
            _bw.write(_wl_block437Bytes, _wl_block437);
	}

		if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
		{	
		if(!isAcceptRequestByPractAppl){
	
            _bw.write(_wl_block438Bytes, _wl_block438);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block439Bytes, _wl_block439);

		}
	for( int i=0; i<10; i++)
	{
		out.println("<tr><td class=label colspan='4'>&nbsp;</td></tr>");
	}
}	
            _bw.write(_wl_block440Bytes, _wl_block440);
	/////////////////////////////// DISPLAY ONLY ////////////////////////
if(call_function.equals("PREPARE_MEDICAL_REPORT") || 
call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED") ||
call_function.equals("REVISE_MEDICAL_REPORT")  ||
call_function.equals("QUERY_DELAY_IN_MRR") )
{	
if(!isAcceptRequestByPractAppl)
{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316

            _bw.write(_wl_block293Bytes, _wl_block293);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(CollectDate_Converted));
            _bw.write(_wl_block295Bytes, _wl_block295);
	if(!revised_collect_date.equals(""))
	{	
            _bw.write(_wl_block296Bytes, _wl_block296);

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(revised_collect_date_converted));
            _bw.write(_wl_block298Bytes, _wl_block298);
	}else{	
            _bw.write(_wl_block443Bytes, _wl_block443);
	}	
            _bw.write(_wl_block444Bytes, _wl_block444);

}	
}if(call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("ACCEPTED_BY_PRACTITIONER") || call_function.equals("ACCEPTED_BY_PRACTITIONER")) 
{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
	/*Added By Dharma on Jan 18th 2016 against ML-MMOH-CRF-0390 [IN:057155] Start*/
		String isDisabledFwdPract	= "";
		//if(!called_from.equals("CA")) //Commented By Dharma on 19th Dec 2019 aginst ML-MMOH-CRF-1454
			isDisabledFwdPract		= "disabled";
	/*Added By Dharma on Jan 18th 2016 against ML-MMOH-CRF-0390 [IN:057155] End*/
	
	
            _bw.write(_wl_block445Bytes, _wl_block445);
if(isAcceptRequestByPractAppl){
	// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	
            _bw.write(_wl_block446Bytes, _wl_block446);

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block447Bytes, _wl_block447);
}else{
            _bw.write(_wl_block448Bytes, _wl_block448);

            if (_jsp__tag147(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block447Bytes, _wl_block447);
}
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(forwarded_pract_name));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(isDisabledFwdPract));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(forwarded_pract_id));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(isDisabledFwdPract));
            _bw.write(_wl_block453Bytes, _wl_block453);
if(!isAcceptRequestByPractAppl){
		// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		
            _bw.write(_wl_block454Bytes, _wl_block454);

            if (_jsp__tag148(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(PREPARE_PRACT_NAME));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(pract_code));
            _bw.write(_wl_block457Bytes, _wl_block457);
}else{
            _bw.write(_wl_block458Bytes, _wl_block458);

            if (_jsp__tag149(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(Pract_Assign_Date));
            _bw.write(_wl_block460Bytes, _wl_block460);
}
            _bw.write(_wl_block461Bytes, _wl_block461);
if(isAcceptRequestByPractAppl){
	// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	
            _bw.write(_wl_block462Bytes, _wl_block462);

            if (_jsp__tag150(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(forwarded_hod_cord_name));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(forwarded_hod_cord_id));
            _bw.write(_wl_block464Bytes, _wl_block464);
if((call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("ACCEPTED_BY_PRACTITIONER")) && isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716
				
				disabled = "disabled";
				
				
				
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block465Bytes, _wl_block465);

            if (_jsp__tag151(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

								
								String sel_1 = "";
								
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										if(forwarded_medical_team.equals(teamCode))
											sel_1 = "selected";
										else
											sel_1 = "";
										out.println("<option value='"+teamCode+ "'  "+sel_1+" title='"+pract_list+"' >"+teamDesc+"</option>");
										
								}
					
            _bw.write(_wl_block257Bytes, _wl_block257);
}
            _bw.write(_wl_block466Bytes, _wl_block466);
}
            _bw.write(_wl_block104Bytes, _wl_block104);
if(!isAcceptRequestByPractAppl){
	// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	
            _bw.write(_wl_block467Bytes, _wl_block467);

            if (_jsp__tag152(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block470Bytes, _wl_block470);

            if (_jsp__tag153(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(requesting_pract_id));
            _bw.write(_wl_block472Bytes, _wl_block472);

            if (_jsp__tag154(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(forwarded_hod_cord_name));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(forwarded_hod_cord_id));
            _bw.write(_wl_block464Bytes, _wl_block464);
if(call_function.equals("PREPARE_MEDICAL_REPORT") && isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716
				
				disabled = "disabled";
				
				
				
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block465Bytes, _wl_block465);

            if (_jsp__tag155(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

								
								String sel_1 = "";
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										
										if(forwarded_medical_team.equals(teamCode))
											sel_1 = "selected";
										else
											sel_1 = "";
										out.println("<option value='"+teamCode+ "'  "+sel_1+" title='"+pract_list+"' >"+teamDesc+"</option>");
										
								}
					
            _bw.write(_wl_block257Bytes, _wl_block257);
}
            _bw.write(_wl_block474Bytes, _wl_block474);

            if (_jsp__tag156(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block475Bytes, _wl_block475);
}else{
// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316

            _bw.write(_wl_block476Bytes, _wl_block476);

            if (_jsp__tag157(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(remarks_hod));
            _bw.write(_wl_block478Bytes, _wl_block478);
}
            _bw.write(_wl_block0Bytes, _wl_block0);
/*
}
	if(call_function.equals("PREPARE_MEDICAL_REPORT") && called_from.equals("CA"))
	{	*/
            _bw.write(_wl_block479Bytes, _wl_block479);
	
	
	// below if else block added by mujafar for ML-MMOH-CRF-0963
	if(!isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	if(isMedicalReportRequest && call_function.equals("PREPARE_MEDICAL_REPORT") && called_from.equals("CA"))
	{ 
		
            _bw.write(_wl_block480Bytes, _wl_block480);

            if (_jsp__tag158(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block364Bytes, _wl_block364);

            if (_jsp__tag159(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block481Bytes, _wl_block481);

            if (_jsp__tag160(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

								JSONArray medicalrepreasonJsonArr = new JSONArray();
								medicalrepreasonJsonArr  = eMR.MRCommonBean.getReasonList(con);	
								
								for(int i = 0 ; i < medicalrepreasonJsonArr.size() ; i++) 
								{
										JSONObject json1	= (JSONObject)medicalrepreasonJsonArr.get(i);
										String reasonCode  = (String) json1.get("reasonCode");;
										String reasonDesc  = (String) json1.get("reasonDesc");;
										out.println("<option value='"+reasonCode+ "'>"+reasonDesc+"</option>");
										
								}		
					
            _bw.write(_wl_block482Bytes, _wl_block482);

	}
	else
	{
	for( int i=0; i<10; i++)
	{
		out.println("<tr><td class=label colspan='4'>&nbsp;</td></tr>");
	} 	
	}
	}

if(isAcceptRequestByPractAppl){
// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316

            _bw.write(_wl_block483Bytes, _wl_block483);

            if (_jsp__tag161(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block364Bytes, _wl_block364);

            if (_jsp__tag162(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block484Bytes, _wl_block484);

            if (_jsp__tag163(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block485Bytes, _wl_block485);

            if (_jsp__tag164(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block364Bytes, _wl_block364);

            if (_jsp__tag165(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block486Bytes, _wl_block486);

            if (_jsp__tag166(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block487Bytes, _wl_block487);

            if (_jsp__tag167(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block488Bytes, _wl_block488);

            if (_jsp__tag168(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block489Bytes, _wl_block489);

            if (_jsp__tag169(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block490Bytes, _wl_block490);

            if (_jsp__tag170(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block491Bytes, _wl_block491);

            if (_jsp__tag171(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block493Bytes, _wl_block493);

            if (_jsp__tag172(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

								/*JSONArray medicalreprejectreasonJsonArr_1 = new JSONArray();
								medicalreprejectreasonJsonArr_1  = eMR.MRCommonBean.getRejectReportReasonList(con);	
								
								for(int i = 0 ; i < medicalreprejectreasonJsonArr_1.size() ; i++) 
								{
										JSONObject json11	= (JSONObject)medicalreprejectreasonJsonArr_1.get(i);
										String reasonCode1  = (String) json11.get("reasonCode");;
										String reasonDesc1  = (String) json11.get("reasonDesc");;
										out.println("<option value='"+reasonCode1+ "'>"+reasonDesc1+"</option>");
										
								}*/		
					
            _bw.write(_wl_block494Bytes, _wl_block494);

            if (_jsp__tag173(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block495Bytes, _wl_block495);

            if (_jsp__tag174(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block496Bytes, _wl_block496);

            if (_jsp__tag175(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(loginUserName));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block499Bytes, _wl_block499);

            if (_jsp__tag176(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block500Bytes, _wl_block500);

            if (_jsp__tag177(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block501Bytes, _wl_block501);

            if (_jsp__tag178(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag179(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block502Bytes, _wl_block502);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block503Bytes, _wl_block503);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block504Bytes, _wl_block504);

            if (_jsp__tag180(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block364Bytes, _wl_block364);

            if (_jsp__tag181(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag182(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(remarks_pract));
            _bw.write(_wl_block506Bytes, _wl_block506);

            if (_jsp__tag183(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block507Bytes, _wl_block507);
}
}else if(call_function.equals("RECEIVE_MEDICAL_REPORT")) 
{	
            _bw.write(_wl_block508Bytes, _wl_block508);

            if (_jsp__tag184(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(prepareDate_Converted));
            _bw.write(_wl_block510Bytes, _wl_block510);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block511Bytes, _wl_block511);

            if (_jsp__tag185(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
}else{
            _bw.write(_wl_block511Bytes, _wl_block511);

            if (_jsp__tag186(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block512Bytes, _wl_block512);

            if (_jsp__tag187(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block514Bytes, _wl_block514);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag188(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
}else{
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag189(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(forwarded_pract_name));
            _bw.write(_wl_block516Bytes, _wl_block516);

            if (_jsp__tag190(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(PREPARE_PRACT_NAME));
            _bw.write(_wl_block518Bytes, _wl_block518);
if(isRejectReportApplicable) { // added by mujafar for ML-MMOH-CRF-0714
            _bw.write(_wl_block519Bytes, _wl_block519);

            if (_jsp__tag191(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block521Bytes, _wl_block521);

            if (_jsp__tag192(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block523Bytes, _wl_block523);

            if (_jsp__tag193(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block524Bytes, _wl_block524);

            if (_jsp__tag194(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

								JSONArray medicalreprejectreasonJsonArr_1 = new JSONArray();
								medicalreprejectreasonJsonArr_1  = eMR.MRCommonBean.getRejectReportReasonList(con,"reject");	
								
								for(int i = 0 ; i < medicalreprejectreasonJsonArr_1.size() ; i++) 
								{
										JSONObject json11	= (JSONObject)medicalreprejectreasonJsonArr_1.get(i);
										String reasonCode1  = (String) json11.get("reasonCode");;
										String reasonDesc1  = (String) json11.get("reasonDesc");;
										out.println("<option value='"+reasonCode1+ "'>"+reasonDesc1+"</option>");
										
								}		
					
            _bw.write(_wl_block525Bytes, _wl_block525);
}
            _bw.write(_wl_block0Bytes, _wl_block0);

	for( int i=0; i<10; i++)
	{
		out.println("<tr><td class=label colspan='4'>&nbsp;</td></tr>");
	}

            _bw.write(_wl_block526Bytes, _wl_block526);
	
}else if(call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED"))
{	
            _bw.write(_wl_block527Bytes, _wl_block527);
if(!isAcceptRequestByPractAppl){
            _bw.write(_wl_block528Bytes, _wl_block528);

            if (_jsp__tag195(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(prepareDate_Converted));
            _bw.write(_wl_block530Bytes, _wl_block530);

            if (_jsp__tag196(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(RecdDate_Converted));
            _bw.write(_wl_block532Bytes, _wl_block532);

            if (_jsp__tag197(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(delivered_date_converted));
            _bw.write(_wl_block534Bytes, _wl_block534);
}
            _bw.write(_wl_block535Bytes, _wl_block535);
if(isAcceptRequestByPractAppl){
		// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		
            _bw.write(_wl_block536Bytes, _wl_block536);

            if (_jsp__tag198(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block460Bytes, _wl_block460);
}else{
            _bw.write(_wl_block536Bytes, _wl_block536);

            if (_jsp__tag199(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block460Bytes, _wl_block460);
}
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(disableModes));
            _bw.write(_wl_block538Bytes, _wl_block538);

            if (_jsp__tag200(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block539Bytes, _wl_block539);

            if (_jsp__tag201(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block540Bytes, _wl_block540);

            if (_jsp__tag202(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);
}else{
            _bw.write(_wl_block539Bytes, _wl_block539);

            if (_jsp__tag203(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block540Bytes, _wl_block540);

            if (_jsp__tag204(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);
}
            _bw.write(_wl_block541Bytes, _wl_block541);
            out.print( String.valueOf(dispatch_mode));
            _bw.write(_wl_block542Bytes, _wl_block542);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block543Bytes, _wl_block543);
}
            _bw.write(_wl_block544Bytes, _wl_block544);

            if (_jsp__tag205(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(posted_date));
            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(disableModes));
            _bw.write(_wl_block547Bytes, _wl_block547);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block543Bytes, _wl_block543);
}
            _bw.write(_wl_block548Bytes, _wl_block548);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block549Bytes, _wl_block549);

            if (_jsp__tag206(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block550Bytes, _wl_block550);
            out.print( String.valueOf(delivered_date_converted));
            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(disableModes));
            _bw.write(_wl_block551Bytes, _wl_block551);
}
            _bw.write(_wl_block552Bytes, _wl_block552);
	if(accept_national_id_no_yn.equals("Y"))
	{	
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block554Bytes, _wl_block554);
            out.print( String.valueOf(rtb_national_id_no));
            _bw.write(_wl_block555Bytes, _wl_block555);
	}else{	
            _bw.write(_wl_block556Bytes, _wl_block556);
	}	
            _bw.write(_wl_block557Bytes, _wl_block557);

            if (_jsp__tag207(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block558Bytes, _wl_block558);
            out.print( String.valueOf(report_taken_by));
            _bw.write(_wl_block559Bytes, _wl_block559);

            if (_jsp__tag208(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block560Bytes, _wl_block560);

            if (_jsp__tag209(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block561Bytes, _wl_block561);

				String altIDsql = " select alt_id_type, long_desc short_desc from MP_ALTERNATE_ID_TYPE_LANG_VW where alt_id_type not in (select alt_id1_type from mp_param union select nvl(alt_id2_type,1) from MP_PARAM union select nvl(alt_id3_type,2) from MP_PARAM union select nvl(alt_id4_type,3) from MP_PARAM ) and eff_status = 'E' and language_id = '"+locale+"' order by 2 ";

				oth_stmt = con.createStatement();
				oth_rset = oth_stmt.executeQuery(altIDsql);	
				if(oth_rset != null)
				{
					while (oth_rset.next())
					{
						out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\">"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
					}
				}
			
			if(oth_rset != null) oth_rset.close();
			if(oth_stmt != null) oth_stmt.close();


            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(rtb_alt_id_type));
            _bw.write(_wl_block563Bytes, _wl_block563);

            if (_jsp__tag210(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block564Bytes, _wl_block564);
            out.print( String.valueOf(rtb_alt_id__no));
            _bw.write(_wl_block565Bytes, _wl_block565);
if(isAcceptRequestByPractAppl){
		// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		
            _bw.write(_wl_block553Bytes, _wl_block553);

            if (_jsp__tag211(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block566Bytes, _wl_block566);
            out.print( String.valueOf(sec_file_no));
            _bw.write(_wl_block567Bytes, _wl_block567);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block543Bytes, _wl_block543);
}
            _bw.write(_wl_block568Bytes, _wl_block568);
}else{
            _bw.write(_wl_block553Bytes, _wl_block553);

            if (_jsp__tag212(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(sec_file_no));
            _bw.write(_wl_block570Bytes, _wl_block570);
}
            _bw.write(_wl_block571Bytes, _wl_block571);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block572Bytes, _wl_block572);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DeliveryPostageAddress.label","mr_labels")));
            _bw.write(_wl_block546Bytes, _wl_block546);
}else{
            _bw.write(_wl_block572Bytes, _wl_block572);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DeliveryDispatchAdd.label","mr_labels")));
            _bw.write(_wl_block573Bytes, _wl_block573);
}
            _bw.write(_wl_block574Bytes, _wl_block574);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag213(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
}else{
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag214(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
}
            _bw.write(_wl_block575Bytes, _wl_block575);
            out.print( String.valueOf(forwarded_pract_name));
            _bw.write(_wl_block576Bytes, _wl_block576);

            if (_jsp__tag215(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(PREPARE_PRACT_NAME));
            _bw.write(_wl_block577Bytes, _wl_block577);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block528Bytes, _wl_block528);

            if (_jsp__tag216(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(prepareDate_Converted));
            _bw.write(_wl_block578Bytes, _wl_block578);

            if (_jsp__tag217(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block579Bytes, _wl_block579);

            if (_jsp__tag218(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block580Bytes, _wl_block580);
            out.print( String.valueOf(RecdDate_Converted));
            _bw.write(_wl_block518Bytes, _wl_block518);
}
            _bw.write(_wl_block581Bytes, _wl_block581);

            if (_jsp__tag219(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block576Bytes, _wl_block576);

            if (_jsp__tag220(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(forwarded_hod_cord_name));
            out.print( String.valueOf(forwarded_medical_team_desc));
            _bw.write(_wl_block582Bytes, _wl_block582);
if(isAcceptRequestByPractAppl){
            _bw.write(_wl_block583Bytes, _wl_block583);

            if (_jsp__tag221(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block584Bytes, _wl_block584);
            out.print( String.valueOf(disableModes));
            _bw.write(_wl_block585Bytes, _wl_block585);
            out.print( String.valueOf(delivery_remarks));
            _bw.write(_wl_block586Bytes, _wl_block586);
}
            _bw.write(_wl_block587Bytes, _wl_block587);
	} if(call_function.equals("REVISE_MEDICAL_REPORT")) {	
            _bw.write(_wl_block588Bytes, _wl_block588);

            if (_jsp__tag222(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block589Bytes, _wl_block589);

            if (_jsp__tag223(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block590Bytes, _wl_block590);

				for( int i=0; i<10; i++) {
					out.println("<tr><td class=label colspan='4'>&nbsp;</td>");
				}
			
            _bw.write(_wl_block591Bytes, _wl_block591);
 } 
            _bw.write(_wl_block592Bytes, _wl_block592);
            out.print( String.valueOf(cancelledBy));
            _bw.write(_wl_block593Bytes, _wl_block593);
            out.print( String.valueOf(cancelledDate));
            _bw.write(_wl_block594Bytes, _wl_block594);
            out.print( String.valueOf(cancelledReason));
            _bw.write(_wl_block595Bytes, _wl_block595);
            out.print( String.valueOf(loginUserName));
            _bw.write(_wl_block596Bytes, _wl_block596);
            out.print( String.valueOf(isIncompReqCancelApplicable));
            _bw.write(_wl_block597Bytes, _wl_block597);
            out.print( String.valueOf(req_status));
            _bw.write(_wl_block598Bytes, _wl_block598);
            out.print( String.valueOf(isAcceptRequestByPractAppl));
            _bw.write(_wl_block599Bytes, _wl_block599);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block600Bytes, _wl_block600);
            out.print( String.valueOf(isSelfStatusMRPApplicable));
            _bw.write(_wl_block601Bytes, _wl_block601);
            out.print( String.valueOf(isMedicalTeamApplicable));
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(isRejectRequestApplicable));
            _bw.write(_wl_block603Bytes, _wl_block603);
            out.print( String.valueOf(isRejectReportApplicable));
            _bw.write(_wl_block604Bytes, _wl_block604);
            out.print( String.valueOf(isMedicalReportDurationAppl));
            _bw.write(_wl_block605Bytes, _wl_block605);
            out.print( String.valueOf(medrep_pay_int_mode));
            _bw.write(_wl_block606Bytes, _wl_block606);
            out.print( String.valueOf(prepareDate));
            _bw.write(_wl_block607Bytes, _wl_block607);
            out.print( String.valueOf(appl_completion_date));
            _bw.write(_wl_block608Bytes, _wl_block608);
            out.print( String.valueOf(reqDate));
            _bw.write(_wl_block609Bytes, _wl_block609);
            out.print( String.valueOf(RecdDate));
            _bw.write(_wl_block610Bytes, _wl_block610);
            out.print( String.valueOf(delivered_date));
            _bw.write(_wl_block611Bytes, _wl_block611);
            out.print( String.valueOf(applSubmissionDate));
            _bw.write(_wl_block612Bytes, _wl_block612);
            out.print( String.valueOf(charges_appl_yn));
            _bw.write(_wl_block613Bytes, _wl_block613);
            out.print( String.valueOf(addl_charges_yn));
            _bw.write(_wl_block614Bytes, _wl_block614);
            out.print( String.valueOf(receipt_no));
            _bw.write(_wl_block615Bytes, _wl_block615);
            out.print( String.valueOf(addl_receipt_no));
            _bw.write(_wl_block616Bytes, _wl_block616);
            out.print( String.valueOf(amount));
            _bw.write(_wl_block617Bytes, _wl_block617);
            out.print( String.valueOf(addl_amount));
            _bw.write(_wl_block618Bytes, _wl_block618);
            out.print( String.valueOf(receipt_date));
            _bw.write(_wl_block619Bytes, _wl_block619);
            out.print( String.valueOf(addl_receipt_date));
            _bw.write(_wl_block620Bytes, _wl_block620);
            out.print( String.valueOf(isSpecialtyDefaultApp));
            _bw.write(_wl_block621Bytes, _wl_block621);
            out.print( String.valueOf(specialtyEffStatus));
            _bw.write(_wl_block622Bytes, _wl_block622);
            out.print( String.valueOf(specialtyMRApplYN));
            _bw.write(_wl_block623Bytes, _wl_block623);
            out.print( String.valueOf(isRequestorAddrDispApp));
            _bw.write(_wl_block624Bytes, _wl_block624);
            out.print( String.valueOf(isMedicalReportRequest));
            _bw.write(_wl_block625Bytes, _wl_block625);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block626Bytes, _wl_block626);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block627Bytes, _wl_block627);
            out.print( String.valueOf(next_of_kin_name));
            _bw.write(_wl_block628Bytes, _wl_block628);
            out.print( String.valueOf(next_of_kin_nat_id_no));
            _bw.write(_wl_block629Bytes, _wl_block629);
            out.print( String.valueOf(next_of_kin_alt_id_type));
            _bw.write(_wl_block630Bytes, _wl_block630);
            out.print( String.valueOf(next_of_kin_relation_code));
            _bw.write(_wl_block631Bytes, _wl_block631);
            out.print( String.valueOf(next_of_kin_alt_id_no));
            _bw.write(_wl_block632Bytes, _wl_block632);
            out.print( String.valueOf(classification_ind));
            _bw.write(_wl_block633Bytes, _wl_block633);
            out.print( String.valueOf(check_list1_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list2_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list3_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list4_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list5_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list6_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list7_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list8_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list9_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list10_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list11_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list12_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list13_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list14_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list15_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list16_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list17_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list18_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list19_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list20_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list21_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list22_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list23_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list24_status));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(check_list25_status));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block636Bytes, _wl_block636);
            out.print( String.valueOf(LastDet));
            _bw.write(_wl_block637Bytes, _wl_block637);
            out.print( String.valueOf(Facility_Id));
            _bw.write(_wl_block638Bytes, _wl_block638);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block639Bytes, _wl_block639);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block640Bytes, _wl_block640);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block641Bytes, _wl_block641);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block642Bytes, _wl_block642);
            out.print( String.valueOf(reqDate));
            _bw.write(_wl_block643Bytes, _wl_block643);
            out.print( String.valueOf(Request_desc));
            _bw.write(_wl_block644Bytes, _wl_block644);
            out.print( String.valueOf(Medical_members));
            _bw.write(_wl_block645Bytes, _wl_block645);
            out.print( String.valueOf(Pract_name));
            _bw.write(_wl_block646Bytes, _wl_block646);
            out.print( String.valueOf(team_desc));
            _bw.write(_wl_block647Bytes, _wl_block647);
            out.print( String.valueOf(CollectDate));
            _bw.write(_wl_block648Bytes, _wl_block648);
            out.print( String.valueOf(prepareDate));
            _bw.write(_wl_block649Bytes, _wl_block649);
            out.print( String.valueOf(RecdDate));
            _bw.write(_wl_block650Bytes, _wl_block650);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block651Bytes, _wl_block651);
            out.print( String.valueOf(requestor_code));
            _bw.write(_wl_block652Bytes, _wl_block652);
            out.print( String.valueOf(team_code));
            _bw.write(_wl_block653Bytes, _wl_block653);
            out.print( String.valueOf(pract_code));
            _bw.write(_wl_block654Bytes, _wl_block654);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block655Bytes, _wl_block655);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block656Bytes, _wl_block656);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block657Bytes, _wl_block657);
            out.print( String.valueOf(new_func_id));
            _bw.write(_wl_block658Bytes, _wl_block658);
            out.print( String.valueOf(revised_collect_date));
            _bw.write(_wl_block659Bytes, _wl_block659);
            out.print( String.valueOf(chklst_consent_fr_pat));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(chklst_ident_doc));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(chklst_marital_cert));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(chklst_stat_dec));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(chklst_consent_fr_embsy));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(chklst_payment));
            _bw.write(_wl_block660Bytes, _wl_block660);
            out.print( String.valueOf(isChckLstApplicable));
            _bw.write(_wl_block661Bytes, _wl_block661);
            out.print( String.valueOf(applicationMode));
            _bw.write(_wl_block662Bytes, _wl_block662);
            out.print( String.valueOf(collectionMode));
            _bw.write(_wl_block663Bytes, _wl_block663);
            out.print( String.valueOf(notificationMode));
            _bw.write(_wl_block664Bytes, _wl_block664);
	if(!revised_collect_date.equals(""))
	{	
            _bw.write(_wl_block665Bytes, _wl_block665);
            out.print( String.valueOf(revised_collect_date));
            _bw.write(_wl_block666Bytes, _wl_block666);
	}	
            _bw.write(_wl_block667Bytes, _wl_block667);
            out.print( String.valueOf(Pat_name));
            _bw.write(_wl_block668Bytes, _wl_block668);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block669Bytes, _wl_block669);
            out.print( String.valueOf(classification_appl_yn));
            _bw.write(_wl_block670Bytes, _wl_block670);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block671Bytes, _wl_block671);
            out.print( String.valueOf(oth_alt_id_type));
            _bw.write(_wl_block672Bytes, _wl_block672);
            out.print( String.valueOf(oth_alt_id_no));
            _bw.write(_wl_block673Bytes, _wl_block673);
            out.print( String.valueOf(oth_alt_type));
            _bw.write(_wl_block674Bytes, _wl_block674);
            out.print( String.valueOf(oth_alt_id));
            _bw.write(_wl_block675Bytes, _wl_block675);
            out.print( String.valueOf(count));
            _bw.write(_wl_block676Bytes, _wl_block676);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block677Bytes, _wl_block677);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block678Bytes, _wl_block678);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block679Bytes, _wl_block679);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block680Bytes, _wl_block680);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block681Bytes, _wl_block681);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block682Bytes, _wl_block682);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block683Bytes, _wl_block683);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block684Bytes, _wl_block684);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block685Bytes, _wl_block685);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block686Bytes, _wl_block686);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block687Bytes, _wl_block687);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block688Bytes, _wl_block688);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block689Bytes, _wl_block689);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block690Bytes, _wl_block690);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block691Bytes, _wl_block691);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block692Bytes, _wl_block692);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block693Bytes, _wl_block693);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block694Bytes, _wl_block694);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block695Bytes, _wl_block695);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block696Bytes, _wl_block696);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block697Bytes, _wl_block697);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block698Bytes, _wl_block698);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block699Bytes, _wl_block699);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block700Bytes, _wl_block700);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block701Bytes, _wl_block701);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block702Bytes, _wl_block702);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block703Bytes, _wl_block703);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block704Bytes, _wl_block704);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block705Bytes, _wl_block705);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block706Bytes, _wl_block706);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block707Bytes, _wl_block707);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block708Bytes, _wl_block708);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block709Bytes, _wl_block709);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block710Bytes, _wl_block710);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block711Bytes, _wl_block711);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block712Bytes, _wl_block712);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block713Bytes, _wl_block713);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block714Bytes, _wl_block714);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block715Bytes, _wl_block715);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block716Bytes, _wl_block716);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block717Bytes, _wl_block717);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block718Bytes, _wl_block718);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block719Bytes, _wl_block719);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block720Bytes, _wl_block720);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block721Bytes, _wl_block721);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block722Bytes, _wl_block722);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block723Bytes, _wl_block723);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block724Bytes, _wl_block724);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block725Bytes, _wl_block725);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block726Bytes, _wl_block726);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block727Bytes, _wl_block727);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block728Bytes, _wl_block728);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block729Bytes, _wl_block729);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block730Bytes, _wl_block730);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block731Bytes, _wl_block731);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block732Bytes, _wl_block732);
            out.print( String.valueOf(nkin_addr_line1));
            _bw.write(_wl_block733Bytes, _wl_block733);
            out.print( String.valueOf(nkin_addr_line2));
            _bw.write(_wl_block734Bytes, _wl_block734);
            out.print( String.valueOf(nkin_addr_line3));
            _bw.write(_wl_block735Bytes, _wl_block735);
            out.print( String.valueOf(nkin_addr_line4));
            _bw.write(_wl_block736Bytes, _wl_block736);
            out.print( String.valueOf(nkin_res_town_desc));
            _bw.write(_wl_block737Bytes, _wl_block737);
            out.print( String.valueOf(nkin_res_town_code));
            _bw.write(_wl_block738Bytes, _wl_block738);
            out.print( String.valueOf(nkin_res_area_desc));
            _bw.write(_wl_block739Bytes, _wl_block739);
            out.print( String.valueOf(nkin_res_area_code));
            _bw.write(_wl_block740Bytes, _wl_block740);
            out.print( String.valueOf(nkin_region_desc));
            _bw.write(_wl_block741Bytes, _wl_block741);
            out.print( String.valueOf(nkin_region_code));
            _bw.write(_wl_block742Bytes, _wl_block742);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block743Bytes, _wl_block743);
            out.print( String.valueOf(nkin_postal_code));
            _bw.write(_wl_block744Bytes, _wl_block744);
            out.print( String.valueOf(nkin_country_desc));
            _bw.write(_wl_block745Bytes, _wl_block745);
            out.print( String.valueOf(nkin_country_code));
            _bw.write(_wl_block746Bytes, _wl_block746);
            out.print( String.valueOf(fton_addr_line1));
            _bw.write(_wl_block747Bytes, _wl_block747);
            out.print( String.valueOf(fton_addr_line2));
            _bw.write(_wl_block748Bytes, _wl_block748);
            out.print( String.valueOf(fton_addr_line3));
            _bw.write(_wl_block749Bytes, _wl_block749);
            out.print( String.valueOf(fton_addr_line4));
            _bw.write(_wl_block750Bytes, _wl_block750);
            out.print( String.valueOf(fton_res_town_desc));
            _bw.write(_wl_block751Bytes, _wl_block751);
            out.print( String.valueOf(fton_res_town_code));
            _bw.write(_wl_block752Bytes, _wl_block752);
            out.print( String.valueOf(fton_res_area_desc));
            _bw.write(_wl_block753Bytes, _wl_block753);
            out.print( String.valueOf(fton_res_area_code));
            _bw.write(_wl_block754Bytes, _wl_block754);
            out.print( String.valueOf(fton_region_desc));
            _bw.write(_wl_block755Bytes, _wl_block755);
            out.print( String.valueOf(fton_region_code));
            _bw.write(_wl_block756Bytes, _wl_block756);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block757Bytes, _wl_block757);
            out.print( String.valueOf(fton_postal_code));
            _bw.write(_wl_block758Bytes, _wl_block758);
            out.print( String.valueOf(fton_country_desc));
            _bw.write(_wl_block759Bytes, _wl_block759);
            out.print( String.valueOf(fton_country_code));
            _bw.write(_wl_block760Bytes, _wl_block760);
            out.print( String.valueOf(emplr_addr_line1));
            _bw.write(_wl_block761Bytes, _wl_block761);
            out.print( String.valueOf(emplr_addr_line2));
            _bw.write(_wl_block762Bytes, _wl_block762);
            out.print( String.valueOf(emplr_addr_line3));
            _bw.write(_wl_block763Bytes, _wl_block763);
            out.print( String.valueOf(emplr_addr_line4));
            _bw.write(_wl_block764Bytes, _wl_block764);
            out.print( String.valueOf(emplr_res_town_desc));
            _bw.write(_wl_block765Bytes, _wl_block765);
            out.print( String.valueOf(emplr_res_town_code));
            _bw.write(_wl_block766Bytes, _wl_block766);
            out.print( String.valueOf(emplr_res_area_desc));
            _bw.write(_wl_block767Bytes, _wl_block767);
            out.print( String.valueOf(emplr_res_area_code));
            _bw.write(_wl_block768Bytes, _wl_block768);
            out.print( String.valueOf(emplr_region_desc));
            _bw.write(_wl_block769Bytes, _wl_block769);
            out.print( String.valueOf(emplr_region_code));
            _bw.write(_wl_block770Bytes, _wl_block770);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block771Bytes, _wl_block771);
            out.print( String.valueOf(emplr_postal_code));
            _bw.write(_wl_block772Bytes, _wl_block772);
            out.print( String.valueOf(emplr_country_desc));
            _bw.write(_wl_block773Bytes, _wl_block773);
            out.print( String.valueOf(emplr_country_code));
            _bw.write(_wl_block774Bytes, _wl_block774);
            out.print( String.valueOf(indicator));
            _bw.write(_wl_block775Bytes, _wl_block775);
            out.print( String.valueOf(requestor_type_ind));
            _bw.write(_wl_block776Bytes, _wl_block776);
            out.print( String.valueOf(self_contact_no1));
            _bw.write(_wl_block777Bytes, _wl_block777);
            out.print( String.valueOf(self_contact_no2));
            _bw.write(_wl_block778Bytes, _wl_block778);
            out.print( String.valueOf(self_appl_email_id));
            _bw.write(_wl_block779Bytes, _wl_block779);
            out.print( String.valueOf(nkin_contact_no1));
            _bw.write(_wl_block780Bytes, _wl_block780);
            out.print( String.valueOf(nkin_contact_no2));
            _bw.write(_wl_block781Bytes, _wl_block781);
            out.print( String.valueOf(nkin_appl_email_id));
            _bw.write(_wl_block782Bytes, _wl_block782);
            out.print( String.valueOf(fton_contact_no1));
            _bw.write(_wl_block783Bytes, _wl_block783);
            out.print( String.valueOf(fton_contact_no2));
            _bw.write(_wl_block784Bytes, _wl_block784);
            out.print( String.valueOf(fton_appl_email_id));
            _bw.write(_wl_block785Bytes, _wl_block785);
            out.print( String.valueOf(emplr_contact_no1));
            _bw.write(_wl_block786Bytes, _wl_block786);
            out.print( String.valueOf(emplr_contact_no2));
            _bw.write(_wl_block787Bytes, _wl_block787);
            out.print( String.valueOf(ourRefDtlsDisp));
            _bw.write(_wl_block788Bytes, _wl_block788);
            out.print( String.valueOf(increasedaddressLength));
            _bw.write(_wl_block789Bytes, _wl_block789);
            out.print( String.valueOf(tot_amount ));
            _bw.write(_wl_block790Bytes, _wl_block790);
            out.print( String.valueOf(charges_appl_yn));
            _bw.write(_wl_block791Bytes, _wl_block791);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block792Bytes, _wl_block792);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block793Bytes, _wl_block793);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block794Bytes, _wl_block794);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block795Bytes, _wl_block795);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block796Bytes, _wl_block796);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block797Bytes, _wl_block797);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block798Bytes, _wl_block798);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block799Bytes, _wl_block799);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block800Bytes, _wl_block800);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block801Bytes, _wl_block801);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block802Bytes, _wl_block802);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block803Bytes, _wl_block803);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block804Bytes, _wl_block804);
            out.print( String.valueOf(mail_addr_line1));
            _bw.write(_wl_block805Bytes, _wl_block805);
            out.print( String.valueOf(mail_addr_line2));
            _bw.write(_wl_block806Bytes, _wl_block806);
            out.print( String.valueOf(mail_addr_line3));
            _bw.write(_wl_block807Bytes, _wl_block807);
            out.print( String.valueOf(mail_addr_line4));
            _bw.write(_wl_block808Bytes, _wl_block808);
            out.print( String.valueOf(mail_res_town_code));
            _bw.write(_wl_block809Bytes, _wl_block809);
            out.print( String.valueOf(mail_res_town_desc));
            _bw.write(_wl_block810Bytes, _wl_block810);
            out.print( String.valueOf(mail_res_area_code));
            _bw.write(_wl_block811Bytes, _wl_block811);
            out.print( String.valueOf(mail_res_area_desc));
            _bw.write(_wl_block812Bytes, _wl_block812);
            out.print( String.valueOf(mail_postal_code));
            _bw.write(_wl_block813Bytes, _wl_block813);
            out.print( String.valueOf(mail_region_code));
            _bw.write(_wl_block814Bytes, _wl_block814);
            out.print( String.valueOf(mail_region_desc));
            _bw.write(_wl_block815Bytes, _wl_block815);
            out.print( String.valueOf(mail_country_code));
            _bw.write(_wl_block816Bytes, _wl_block816);
            out.print( String.valueOf(mail_country_desc));
            _bw.write(_wl_block817Bytes, _wl_block817);
            out.print( String.valueOf(contact1_no));
            _bw.write(_wl_block818Bytes, _wl_block818);
            out.print( String.valueOf(contact2_no));
            _bw.write(_wl_block819Bytes, _wl_block819);
            out.print( String.valueOf(email));
            _bw.write(_wl_block820Bytes, _wl_block820);
            out.print( String.valueOf(addr_line1));
            _bw.write(_wl_block821Bytes, _wl_block821);
            out.print( String.valueOf(addr_line2));
            _bw.write(_wl_block822Bytes, _wl_block822);
            out.print( String.valueOf(addr_line3));
            _bw.write(_wl_block823Bytes, _wl_block823);
            out.print( String.valueOf(addr_line4));
            _bw.write(_wl_block824Bytes, _wl_block824);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block825Bytes, _wl_block825);
            out.print( String.valueOf(res_town_desc));
            _bw.write(_wl_block826Bytes, _wl_block826);
            out.print( String.valueOf(res_area_code));
            _bw.write(_wl_block827Bytes, _wl_block827);
            out.print( String.valueOf(res_area_desc));
            _bw.write(_wl_block828Bytes, _wl_block828);
            out.print( String.valueOf(region_code));
            _bw.write(_wl_block829Bytes, _wl_block829);
            out.print( String.valueOf(region_desc));
            _bw.write(_wl_block830Bytes, _wl_block830);
            out.print( String.valueOf(res_country_code));
            _bw.write(_wl_block831Bytes, _wl_block831);
            out.print( String.valueOf(res_country_desc));
            _bw.write(_wl_block832Bytes, _wl_block832);
            out.print( String.valueOf(postal_code));
            _bw.write(_wl_block833Bytes, _wl_block833);
            out.print( String.valueOf(mail_addr_line1));
            _bw.write(_wl_block834Bytes, _wl_block834);
            out.print( String.valueOf(mail_addr_line2));
            _bw.write(_wl_block835Bytes, _wl_block835);
            out.print( String.valueOf(mail_addr_line3));
            _bw.write(_wl_block836Bytes, _wl_block836);
            out.print( String.valueOf(mail_addr_line4));
            _bw.write(_wl_block837Bytes, _wl_block837);
            out.print( String.valueOf(mail_res_town_code));
            _bw.write(_wl_block838Bytes, _wl_block838);
            out.print( String.valueOf(mail_res_town_desc));
            _bw.write(_wl_block839Bytes, _wl_block839);
            out.print( String.valueOf(mail_res_area_code));
            _bw.write(_wl_block840Bytes, _wl_block840);
            out.print( String.valueOf(mail_res_area_desc));
            _bw.write(_wl_block841Bytes, _wl_block841);
            out.print( String.valueOf(mail_country_code));
            _bw.write(_wl_block842Bytes, _wl_block842);
            out.print( String.valueOf(mail_postal_code));
            _bw.write(_wl_block843Bytes, _wl_block843);
            out.print( String.valueOf(mail_region_code));
            _bw.write(_wl_block844Bytes, _wl_block844);
            out.print( String.valueOf(mail_region_desc));
            _bw.write(_wl_block845Bytes, _wl_block845);
            out.print( String.valueOf(mail_country_desc));
            _bw.write(_wl_block846Bytes, _wl_block846);
            out.print( String.valueOf(contact1_no));
            _bw.write(_wl_block847Bytes, _wl_block847);
            out.print( String.valueOf(contact2_no));
            _bw.write(_wl_block848Bytes, _wl_block848);
            out.print( String.valueOf(email));
            _bw.write(_wl_block849Bytes, _wl_block849);



}catch(Exception e)
{
	//out.println("err in try catch : "+e.toString());
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block850Bytes, _wl_block850);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.registrationno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.regndatetime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ViewEncounterDetails.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicantInformation.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicationType.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.LetterDateTime.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicantName.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referenceno.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.OurReferenceNo.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestorType.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Requestor.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ApplicationCategory.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RelationshipType.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employer.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.self.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestorType.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Requestor.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ConsentLetter.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.available.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notavailable.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notrequired.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Attentionto.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicationNo.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charges.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outstandingamount.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ChargesApplicable.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdditionalCharges.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.receiptno.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.receiptno.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.receiptdate.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.receiptdate.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MedicalRecordTask.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicationStatus.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MedicalRecordTask.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reporttype.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accept.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reject.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SelfPrepare.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DepartmentSpecialty.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ApplicationMode.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CollectionMode.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NotificationMode.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DepartmentSpecialty.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedHOD.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedHODDate.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.InformToHOD.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedHOD.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.InformToHOD.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MedicalBoardMembers.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CollectDate.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RevisedCollectDate.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MRDRemarks.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeliveryDetails.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.HODCoordinatorTask.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accept.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reject.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AcceptedbyHOD.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RejectedbyHOD.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SelfPrepare.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AcceptDateTime.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RejectDateTime.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }

    private boolean _jsp__tag97(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag97 = null ;
        int __result__tag97 = 0 ;

        if (__tag97 == null ){
            __tag97 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag97);
        }
        __tag97.setPageContext(pageContext);
        __tag97.setParent(null);
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AssignReAssignPractitioner.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag97;
        __result__tag97 = __tag97.doStartTag();

        if (__result__tag97!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag97== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag97.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag97);
            return true;
        }
        _activeTag=__tag97.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag97);
        __tag97.release();
        return false;
    }

    private boolean _jsp__tag98(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag98 = null ;
        int __result__tag98 = 0 ;

        if (__tag98 == null ){
            __tag98 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag98);
        }
        __tag98.setPageContext(pageContext);
        __tag98.setParent(null);
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforRejection.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag98;
        __result__tag98 = __tag98.doStartTag();

        if (__result__tag98!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag98== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag98.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag98);
            return true;
        }
        _activeTag=__tag98.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag98);
        __tag98.release();
        return false;
    }

    private boolean _jsp__tag99(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag99 = null ;
        int __result__tag99 = 0 ;

        if (__tag99 == null ){
            __tag99 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag99);
        }
        __tag99.setPageContext(pageContext);
        __tag99.setParent(null);
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag99;
        __result__tag99 = __tag99.doStartTag();

        if (__result__tag99!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag99== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag99.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag99);
            return true;
        }
        _activeTag=__tag99.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag99);
        __tag99.release();
        return false;
    }

    private boolean _jsp__tag100(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag100 = null ;
        int __result__tag100 = 0 ;

        if (__tag100 == null ){
            __tag100 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag100);
        }
        __tag100.setPageContext(pageContext);
        __tag100.setParent(null);
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RejectedBy.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag100;
        __result__tag100 = __tag100.doStartTag();

        if (__result__tag100!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag100== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag100.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag100);
            return true;
        }
        _activeTag=__tag100.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag100);
        __tag100.release();
        return false;
    }

    private boolean _jsp__tag101(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag101 = null ;
        int __result__tag101 = 0 ;

        if (__tag101 == null ){
            __tag101 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag101);
        }
        __tag101.setPageContext(pageContext);
        __tag101.setParent(null);
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PractitionerAssignedDate.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag101;
        __result__tag101 = __tag101.doStartTag();

        if (__result__tag101!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag101== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag101.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag101);
            return true;
        }
        _activeTag=__tag101.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag101);
        __tag101.release();
        return false;
    }

    private boolean _jsp__tag102(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag102 = null ;
        int __result__tag102 = 0 ;

        if (__tag102 == null ){
            __tag102 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag102);
        }
        __tag102.setPageContext(pageContext);
        __tag102.setParent(null);
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AcknowledgedByHODCoordinator.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag102;
        __result__tag102 = __tag102.doStartTag();

        if (__result__tag102!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag102== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag102.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag102);
            return true;
        }
        _activeTag=__tag102.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag102);
        __tag102.release();
        return false;
    }

    private boolean _jsp__tag103(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag103 = null ;
        int __result__tag103 = 0 ;

        if (__tag103 == null ){
            __tag103 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag103);
        }
        __tag103.setPageContext(pageContext);
        __tag103.setParent(null);
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.InformToPractitioner.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag103;
        __result__tag103 = __tag103.doStartTag();

        if (__result__tag103!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag103== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag103.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag103);
            return true;
        }
        _activeTag=__tag103.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag103);
        __tag103.release();
        return false;
    }

    private boolean _jsp__tag104(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag104 = null ;
        int __result__tag104 = 0 ;

        if (__tag104 == null ){
            __tag104 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag104);
        }
        __tag104.setPageContext(pageContext);
        __tag104.setParent(null);
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.HODCoordinatorRemarks.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag104;
        __result__tag104 = __tag104.doStartTag();

        if (__result__tag104!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag104== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag104.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag104);
            return true;
        }
        _activeTag=__tag104.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag104);
        __tag104.release();
        return false;
    }

    private boolean _jsp__tag105(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag105 = null ;
        int __result__tag105 = 0 ;

        if (__tag105 == null ){
            __tag105 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag105);
        }
        __tag105.setPageContext(pageContext);
        __tag105.setParent(null);
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag105;
        __result__tag105 = __tag105.doStartTag();

        if (__result__tag105!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag105== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag105.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag105);
            return true;
        }
        _activeTag=__tag105.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag105);
        __tag105.release();
        return false;
    }

    private boolean _jsp__tag106(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag106 = null ;
        int __result__tag106 = 0 ;

        if (__tag106 == null ){
            __tag106 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag106);
        }
        __tag106.setPageContext(pageContext);
        __tag106.setParent(null);
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedHOD.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag106;
        __result__tag106 = __tag106.doStartTag();

        if (__result__tag106!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag106== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag106.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag106);
            return true;
        }
        _activeTag=__tag106.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag106);
        __tag106.release();
        return false;
    }

    private boolean _jsp__tag107(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag107 = null ;
        int __result__tag107 = 0 ;

        if (__tag107 == null ){
            __tag107 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag107);
        }
        __tag107.setPageContext(pageContext);
        __tag107.setParent(null);
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequiredDocuments.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag107;
        __result__tag107 = __tag107.doStartTag();

        if (__result__tag107!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag107== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag107.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag107);
            return true;
        }
        _activeTag=__tag107.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag107);
        __tag107.release();
        return false;
    }

    private boolean _jsp__tag108(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag108 = null ;
        int __result__tag108 = 0 ;

        if (__tag108 == null ){
            __tag108 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag108);
        }
        __tag108.setPageContext(pageContext);
        __tag108.setParent(null);
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.InformToHOD.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag108;
        __result__tag108 = __tag108.doStartTag();

        if (__result__tag108!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag108== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag108.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag108);
            return true;
        }
        _activeTag=__tag108.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag108);
        __tag108.release();
        return false;
    }

    private boolean _jsp__tag109(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag109 = null ;
        int __result__tag109 = 0 ;

        if (__tag109 == null ){
            __tag109 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag109);
        }
        __tag109.setPageContext(pageContext);
        __tag109.setParent(null);
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedHODDate.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag109;
        __result__tag109 = __tag109.doStartTag();

        if (__result__tag109!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag109== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag109.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag109);
            return true;
        }
        _activeTag=__tag109.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag109);
        __tag109.release();
        return false;
    }

    private boolean _jsp__tag110(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag110 = null ;
        int __result__tag110 = 0 ;

        if (__tag110 == null ){
            __tag110 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag110);
        }
        __tag110.setPageContext(pageContext);
        __tag110.setParent(null);
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag110;
        __result__tag110 = __tag110.doStartTag();

        if (__result__tag110!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag110== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag110.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag110);
            return true;
        }
        _activeTag=__tag110.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag110);
        __tag110.release();
        return false;
    }

    private boolean _jsp__tag111(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag111 = null ;
        int __result__tag111 = 0 ;

        if (__tag111 == null ){
            __tag111 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag111);
        }
        __tag111.setPageContext(pageContext);
        __tag111.setParent(null);
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accept.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag111;
        __result__tag111 = __tag111.doStartTag();

        if (__result__tag111!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag111== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag111.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag111);
            return true;
        }
        _activeTag=__tag111.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag111);
        __tag111.release();
        return false;
    }

    private boolean _jsp__tag112(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag112 = null ;
        int __result__tag112 = 0 ;

        if (__tag112 == null ){
            __tag112 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag112);
        }
        __tag112.setPageContext(pageContext);
        __tag112.setParent(null);
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reject.label", java.lang.String .class,"key"));
        __tag112.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag112;
        __result__tag112 = __tag112.doStartTag();

        if (__result__tag112!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag112== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag112.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag112);
            return true;
        }
        _activeTag=__tag112.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag112);
        __tag112.release();
        return false;
    }

    private boolean _jsp__tag113(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag113 = null ;
        int __result__tag113 = 0 ;

        if (__tag113 == null ){
            __tag113 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag113);
        }
        __tag113.setPageContext(pageContext);
        __tag113.setParent(null);
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag113.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag113;
        __result__tag113 = __tag113.doStartTag();

        if (__result__tag113!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag113== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag113.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag113);
            return true;
        }
        _activeTag=__tag113.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag113);
        __tag113.release();
        return false;
    }

    private boolean _jsp__tag114(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag114 = null ;
        int __result__tag114 = 0 ;

        if (__tag114 == null ){
            __tag114 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag114);
        }
        __tag114.setPageContext(pageContext);
        __tag114.setParent(null);
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag114;
        __result__tag114 = __tag114.doStartTag();

        if (__result__tag114!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag114== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag114.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag114);
            return true;
        }
        _activeTag=__tag114.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag114);
        __tag114.release();
        return false;
    }

    private boolean _jsp__tag115(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag115 = null ;
        int __result__tag115 = 0 ;

        if (__tag115 == null ){
            __tag115 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag115);
        }
        __tag115.setPageContext(pageContext);
        __tag115.setParent(null);
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Request.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag115;
        __result__tag115 = __tag115.doStartTag();

        if (__result__tag115!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag115== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag115.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag115);
            return true;
        }
        _activeTag=__tag115.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag115);
        __tag115.release();
        return false;
    }

    private boolean _jsp__tag116(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag116 = null ;
        int __result__tag116 = 0 ;

        if (__tag116 == null ){
            __tag116 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag116);
        }
        __tag116.setPageContext(pageContext);
        __tag116.setParent(null);
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelRequest.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag116;
        __result__tag116 = __tag116.doStartTag();

        if (__result__tag116!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag116== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag116.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag116);
            return true;
        }
        _activeTag=__tag116.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag116);
        __tag116.release();
        return false;
    }

    private boolean _jsp__tag117(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag117 = null ;
        int __result__tag117 = 0 ;

        if (__tag117 == null ){
            __tag117 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag117);
        }
        __tag117.setPageContext(pageContext);
        __tag117.setParent(null);
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag117;
        __result__tag117 = __tag117.doStartTag();

        if (__result__tag117!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag117== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag117.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag117);
            return true;
        }
        _activeTag=__tag117.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag117);
        __tag117.release();
        return false;
    }

    private boolean _jsp__tag118(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag118 = null ;
        int __result__tag118 = 0 ;

        if (__tag118 == null ){
            __tag118 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag118);
        }
        __tag118.setPageContext(pageContext);
        __tag118.setParent(null);
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedPractitioner.label", java.lang.String .class,"key"));
        __tag118.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag118;
        __result__tag118 = __tag118.doStartTag();

        if (__result__tag118!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag118== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag118.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag118);
            return true;
        }
        _activeTag=__tag118.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag118);
        __tag118.release();
        return false;
    }

    private boolean _jsp__tag119(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag119 = null ;
        int __result__tag119 = 0 ;

        if (__tag119 == null ){
            __tag119 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag119);
        }
        __tag119.setPageContext(pageContext);
        __tag119.setParent(null);
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedHOD.label", java.lang.String .class,"key"));
        __tag119.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag119;
        __result__tag119 = __tag119.doStartTag();

        if (__result__tag119!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag119== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag119.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag119);
            return true;
        }
        _activeTag=__tag119.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag119);
        __tag119.release();
        return false;
    }

    private boolean _jsp__tag120(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag120 = null ;
        int __result__tag120 = 0 ;

        if (__tag120 == null ){
            __tag120 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag120);
        }
        __tag120.setPageContext(pageContext);
        __tag120.setParent(null);
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.InformToHOD.label", java.lang.String .class,"key"));
        __tag120.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag120;
        __result__tag120 = __tag120.doStartTag();

        if (__result__tag120!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag120== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag120.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag120);
            return true;
        }
        _activeTag=__tag120.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag120);
        __tag120.release();
        return false;
    }

    private boolean _jsp__tag121(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag121 = null ;
        int __result__tag121 = 0 ;

        if (__tag121 == null ){
            __tag121 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag121);
        }
        __tag121.setPageContext(pageContext);
        __tag121.setParent(null);
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
        __tag121.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag121;
        __result__tag121 = __tag121.doStartTag();

        if (__result__tag121!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag121== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag121.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag121);
            return true;
        }
        _activeTag=__tag121.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag121);
        __tag121.release();
        return false;
    }

    private boolean _jsp__tag122(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag122 = null ;
        int __result__tag122 = 0 ;

        if (__tag122 == null ){
            __tag122 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag122);
        }
        __tag122.setPageContext(pageContext);
        __tag122.setParent(null);
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AcknowledgedByHODCoordinator.label", java.lang.String .class,"key"));
        __tag122.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag122;
        __result__tag122 = __tag122.doStartTag();

        if (__result__tag122!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag122== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag122.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag122);
            return true;
        }
        _activeTag=__tag122.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag122);
        __tag122.release();
        return false;
    }

    private boolean _jsp__tag123(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag123 = null ;
        int __result__tag123 = 0 ;

        if (__tag123 == null ){
            __tag123 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag123);
        }
        __tag123.setPageContext(pageContext);
        __tag123.setParent(null);
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.InformToPractitioner.label", java.lang.String .class,"key"));
        __tag123.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag123;
        __result__tag123 = __tag123.doStartTag();

        if (__result__tag123!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag123== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag123.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag123);
            return true;
        }
        _activeTag=__tag123.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag123);
        __tag123.release();
        return false;
    }

    private boolean _jsp__tag124(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag124 = null ;
        int __result__tag124 = 0 ;

        if (__tag124 == null ){
            __tag124 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag124);
        }
        __tag124.setPageContext(pageContext);
        __tag124.setParent(null);
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accept.label", java.lang.String .class,"key"));
        __tag124.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag124;
        __result__tag124 = __tag124.doStartTag();

        if (__result__tag124!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag124== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag124.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag124);
            return true;
        }
        _activeTag=__tag124.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag124);
        __tag124.release();
        return false;
    }

    private boolean _jsp__tag125(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag125 = null ;
        int __result__tag125 = 0 ;

        if (__tag125 == null ){
            __tag125 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag125);
        }
        __tag125.setPageContext(pageContext);
        __tag125.setParent(null);
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reject.label", java.lang.String .class,"key"));
        __tag125.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag125;
        __result__tag125 = __tag125.doStartTag();

        if (__result__tag125!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag125== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag125.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag125);
            return true;
        }
        _activeTag=__tag125.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag125);
        __tag125.release();
        return false;
    }

    private boolean _jsp__tag126(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag126 = null ;
        int __result__tag126 = 0 ;

        if (__tag126 == null ){
            __tag126 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag126);
        }
        __tag126.setPageContext(pageContext);
        __tag126.setParent(null);
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag126.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag126;
        __result__tag126 = __tag126.doStartTag();

        if (__result__tag126!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag126== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag126.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag126);
            return true;
        }
        _activeTag=__tag126.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag126);
        __tag126.release();
        return false;
    }

    private boolean _jsp__tag127(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag127 = null ;
        int __result__tag127 = 0 ;

        if (__tag127 == null ){
            __tag127 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag127);
        }
        __tag127.setPageContext(pageContext);
        __tag127.setParent(null);
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RejectedOn.label", java.lang.String .class,"key"));
        __tag127.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag127;
        __result__tag127 = __tag127.doStartTag();

        if (__result__tag127!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag127== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag127.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag127);
            return true;
        }
        _activeTag=__tag127.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag127);
        __tag127.release();
        return false;
    }

    private boolean _jsp__tag128(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag128 = null ;
        int __result__tag128 = 0 ;

        if (__tag128 == null ){
            __tag128 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag128);
        }
        __tag128.setPageContext(pageContext);
        __tag128.setParent(null);
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicationStatus.label", java.lang.String .class,"key"));
        __tag128.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag128;
        __result__tag128 = __tag128.doStartTag();

        if (__result__tag128!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag128== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag128.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag128);
            return true;
        }
        _activeTag=__tag128.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag128);
        __tag128.release();
        return false;
    }

    private boolean _jsp__tag129(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag129 = null ;
        int __result__tag129 = 0 ;

        if (__tag129 == null ){
            __tag129 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag129);
        }
        __tag129.setPageContext(pageContext);
        __tag129.setParent(null);
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag129.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag129;
        __result__tag129 = __tag129.doStartTag();

        if (__result__tag129!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag129== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag129.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag129);
            return true;
        }
        _activeTag=__tag129.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag129);
        __tag129.release();
        return false;
    }

    private boolean _jsp__tag130(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag130 = null ;
        int __result__tag130 = 0 ;

        if (__tag130 == null ){
            __tag130 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag130);
        }
        __tag130.setPageContext(pageContext);
        __tag130.setParent(null);
        __tag130.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.complete.label", java.lang.String .class,"key"));
        __tag130.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag130;
        __result__tag130 = __tag130.doStartTag();

        if (__result__tag130!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag130== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag130.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag130);
            return true;
        }
        _activeTag=__tag130.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag130);
        __tag130.release();
        return false;
    }

    private boolean _jsp__tag131(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag131 = null ;
        int __result__tag131 = 0 ;

        if (__tag131 == null ){
            __tag131 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag131);
        }
        __tag131.setPageContext(pageContext);
        __tag131.setParent(null);
        __tag131.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.incomplete.label", java.lang.String .class,"key"));
        __tag131.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag131;
        __result__tag131 = __tag131.doStartTag();

        if (__result__tag131!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag131== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag131.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag131);
            return true;
        }
        _activeTag=__tag131.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag131);
        __tag131.release();
        return false;
    }

    private boolean _jsp__tag132(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag132 = null ;
        int __result__tag132 = 0 ;

        if (__tag132 == null ){
            __tag132 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag132);
        }
        __tag132.setPageContext(pageContext);
        __tag132.setParent(null);
        __tag132.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancelled.label", java.lang.String .class,"key"));
        __tag132.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag132;
        __result__tag132 = __tag132.doStartTag();

        if (__result__tag132!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag132== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag132.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag132);
            return true;
        }
        _activeTag=__tag132.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag132);
        __tag132.release();
        return false;
    }

    private boolean _jsp__tag133(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag133 = null ;
        int __result__tag133 = 0 ;

        if (__tag133 == null ){
            __tag133 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag133);
        }
        __tag133.setPageContext(pageContext);
        __tag133.setParent(null);
        __tag133.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CollectDate.label", java.lang.String .class,"key"));
        __tag133.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag133;
        __result__tag133 = __tag133.doStartTag();

        if (__result__tag133!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag133== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag133.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag133);
            return true;
        }
        _activeTag=__tag133.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag133);
        __tag133.release();
        return false;
    }

    private boolean _jsp__tag134(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag134 = null ;
        int __result__tag134 = 0 ;

        if (__tag134 == null ){
            __tag134 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag134);
        }
        __tag134.setPageContext(pageContext);
        __tag134.setParent(null);
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag134.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag134;
        __result__tag134 = __tag134.doStartTag();

        if (__result__tag134!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag134== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag134.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag134);
            return true;
        }
        _activeTag=__tag134.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag134);
        __tag134.release();
        return false;
    }

    private boolean _jsp__tag135(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag135 = null ;
        int __result__tag135 = 0 ;

        if (__tag135 == null ){
            __tag135 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag135);
        }
        __tag135.setPageContext(pageContext);
        __tag135.setParent(null);
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag135.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag135;
        __result__tag135 = __tag135.doStartTag();

        if (__result__tag135!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag135== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag135.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag135);
            return true;
        }
        _activeTag=__tag135.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag135);
        __tag135.release();
        return false;
    }

    private boolean _jsp__tag136(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag136 = null ;
        int __result__tag136 = 0 ;

        if (__tag136 == null ){
            __tag136 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag136);
        }
        __tag136.setPageContext(pageContext);
        __tag136.setParent(null);
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag136.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag136;
        __result__tag136 = __tag136.doStartTag();

        if (__result__tag136!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag136== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag136.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag136);
            return true;
        }
        _activeTag=__tag136.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag136);
        __tag136.release();
        return false;
    }

    private boolean _jsp__tag137(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag137 = null ;
        int __result__tag137 = 0 ;

        if (__tag137 == null ){
            __tag137 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag137);
        }
        __tag137.setPageContext(pageContext);
        __tag137.setParent(null);
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag137.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag137;
        __result__tag137 = __tag137.doStartTag();

        if (__result__tag137!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag137== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag137.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag137);
            return true;
        }
        _activeTag=__tag137.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag137);
        __tag137.release();
        return false;
    }

    private boolean _jsp__tag138(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag138 = null ;
        int __result__tag138 = 0 ;

        if (__tag138 == null ){
            __tag138 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag138);
        }
        __tag138.setPageContext(pageContext);
        __tag138.setParent(null);
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DepartmentSpecialty.label", java.lang.String .class,"key"));
        __tag138.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag138;
        __result__tag138 = __tag138.doStartTag();

        if (__result__tag138!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag138== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag138.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag138);
            return true;
        }
        _activeTag=__tag138.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag138);
        __tag138.release();
        return false;
    }

    private boolean _jsp__tag139(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag139 = null ;
        int __result__tag139 = 0 ;

        if (__tag139 == null ){
            __tag139 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag139);
        }
        __tag139.setPageContext(pageContext);
        __tag139.setParent(null);
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
        __tag139.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag139;
        __result__tag139 = __tag139.doStartTag();

        if (__result__tag139!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag139== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag139.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag139);
            return true;
        }
        _activeTag=__tag139.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag139);
        __tag139.release();
        return false;
    }

    private boolean _jsp__tag140(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag140 = null ;
        int __result__tag140 = 0 ;

        if (__tag140 == null ){
            __tag140 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag140);
        }
        __tag140.setPageContext(pageContext);
        __tag140.setParent(null);
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
        __tag140.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag140;
        __result__tag140 = __tag140.doStartTag();

        if (__result__tag140!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag140== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag140.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag140);
            return true;
        }
        _activeTag=__tag140.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag140);
        __tag140.release();
        return false;
    }

    private boolean _jsp__tag141(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag141 = null ;
        int __result__tag141 = 0 ;

        if (__tag141 == null ){
            __tag141 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag141);
        }
        __tag141.setPageContext(pageContext);
        __tag141.setParent(null);
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedHOD.label", java.lang.String .class,"key"));
        __tag141.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag141;
        __result__tag141 = __tag141.doStartTag();

        if (__result__tag141!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag141== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag141.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag141);
            return true;
        }
        _activeTag=__tag141.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag141);
        __tag141.release();
        return false;
    }

    private boolean _jsp__tag142(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag142 = null ;
        int __result__tag142 = 0 ;

        if (__tag142 == null ){
            __tag142 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag142);
        }
        __tag142.setPageContext(pageContext);
        __tag142.setParent(null);
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag142.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag142;
        __result__tag142 = __tag142.doStartTag();

        if (__result__tag142!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag142== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag142.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag142);
            return true;
        }
        _activeTag=__tag142.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag142);
        __tag142.release();
        return false;
    }

    private boolean _jsp__tag143(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag143 = null ;
        int __result__tag143 = 0 ;

        if (__tag143 == null ){
            __tag143 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag143);
        }
        __tag143.setPageContext(pageContext);
        __tag143.setParent(null);
        __tag143.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequiredDocuments.label", java.lang.String .class,"key"));
        __tag143.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag143;
        __result__tag143 = __tag143.doStartTag();

        if (__result__tag143!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag143== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag143.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag143);
            return true;
        }
        _activeTag=__tag143.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag143);
        __tag143.release();
        return false;
    }

    private boolean _jsp__tag144(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag144 = null ;
        int __result__tag144 = 0 ;

        if (__tag144 == null ){
            __tag144 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag144);
        }
        __tag144.setPageContext(pageContext);
        __tag144.setParent(null);
        __tag144.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CollectDate.label", java.lang.String .class,"key"));
        __tag144.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag144;
        __result__tag144 = __tag144.doStartTag();

        if (__result__tag144!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag144== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag144.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag144);
            return true;
        }
        _activeTag=__tag144.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag144);
        __tag144.release();
        return false;
    }

    private boolean _jsp__tag145(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag145 = null ;
        int __result__tag145 = 0 ;

        if (__tag145 == null ){
            __tag145 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag145);
        }
        __tag145.setPageContext(pageContext);
        __tag145.setParent(null);
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RevisedCollectDate.label", java.lang.String .class,"key"));
        __tag145.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag145;
        __result__tag145 = __tag145.doStartTag();

        if (__result__tag145!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag145== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag145.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag145);
            return true;
        }
        _activeTag=__tag145.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag145);
        __tag145.release();
        return false;
    }

    private boolean _jsp__tag146(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag146 = null ;
        int __result__tag146 = 0 ;

        if (__tag146 == null ){
            __tag146 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag146);
        }
        __tag146.setPageContext(pageContext);
        __tag146.setParent(null);
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AssignReAssignPractitioner.label", java.lang.String .class,"key"));
        __tag146.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag146;
        __result__tag146 = __tag146.doStartTag();

        if (__result__tag146!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag146== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag146.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag146);
            return true;
        }
        _activeTag=__tag146.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag146);
        __tag146.release();
        return false;
    }

    private boolean _jsp__tag147(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag147 = null ;
        int __result__tag147 = 0 ;

        if (__tag147 == null ){
            __tag147 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag147);
        }
        __tag147.setPageContext(pageContext);
        __tag147.setParent(null);
        __tag147.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedPractitioner.label", java.lang.String .class,"key"));
        __tag147.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag147;
        __result__tag147 = __tag147.doStartTag();

        if (__result__tag147!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag147== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag147.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag147);
            return true;
        }
        _activeTag=__tag147.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag147);
        __tag147.release();
        return false;
    }

    private boolean _jsp__tag148(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag148 = null ;
        int __result__tag148 = 0 ;

        if (__tag148 == null ){
            __tag148 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag148);
        }
        __tag148.setPageContext(pageContext);
        __tag148.setParent(null);
        __tag148.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PreparedbyPractitioner.label", java.lang.String .class,"key"));
        __tag148.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag148;
        __result__tag148 = __tag148.doStartTag();

        if (__result__tag148!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag148== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag148.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag148);
            return true;
        }
        _activeTag=__tag148.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag148);
        __tag148.release();
        return false;
    }

    private boolean _jsp__tag149(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag149 = null ;
        int __result__tag149 = 0 ;

        if (__tag149 == null ){
            __tag149 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag149);
        }
        __tag149.setPageContext(pageContext);
        __tag149.setParent(null);
        __tag149.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PractitionerAssignedDate.label", java.lang.String .class,"key"));
        __tag149.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag149;
        __result__tag149 = __tag149.doStartTag();

        if (__result__tag149!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag149== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag149.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag149);
            return true;
        }
        _activeTag=__tag149.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag149);
        __tag149.release();
        return false;
    }

    private boolean _jsp__tag150(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag150 = null ;
        int __result__tag150 = 0 ;

        if (__tag150 == null ){
            __tag150 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag150);
        }
        __tag150.setPageContext(pageContext);
        __tag150.setParent(null);
        __tag150.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedHOD.label", java.lang.String .class,"key"));
        __tag150.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag150;
        __result__tag150 = __tag150.doStartTag();

        if (__result__tag150!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag150== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag150.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag150);
            return true;
        }
        _activeTag=__tag150.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag150);
        __tag150.release();
        return false;
    }

    private boolean _jsp__tag151(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag151 = null ;
        int __result__tag151 = 0 ;

        if (__tag151 == null ){
            __tag151 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag151);
        }
        __tag151.setPageContext(pageContext);
        __tag151.setParent(null);
        __tag151.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag151.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag151;
        __result__tag151 = __tag151.doStartTag();

        if (__result__tag151!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag151== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag151.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag151);
            return true;
        }
        _activeTag=__tag151.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag151);
        __tag151.release();
        return false;
    }

    private boolean _jsp__tag152(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag152 = null ;
        int __result__tag152 = 0 ;

        if (__tag152 == null ){
            __tag152 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag152);
        }
        __tag152.setPageContext(pageContext);
        __tag152.setParent(null);
        __tag152.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrepareDate.label", java.lang.String .class,"key"));
        __tag152.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag152;
        __result__tag152 = __tag152.doStartTag();

        if (__result__tag152!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag152== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag152.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag152);
            return true;
        }
        _activeTag=__tag152.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag152);
        __tag152.release();
        return false;
    }

    private boolean _jsp__tag153(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag153 = null ;
        int __result__tag153 = 0 ;

        if (__tag153 == null ){
            __tag153 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag153);
        }
        __tag153.setPageContext(pageContext);
        __tag153.setParent(null);
        __tag153.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
        __tag153.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag153;
        __result__tag153 = __tag153.doStartTag();

        if (__result__tag153!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag153== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag153.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag153);
            return true;
        }
        _activeTag=__tag153.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag153);
        __tag153.release();
        return false;
    }

    private boolean _jsp__tag154(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag154 = null ;
        int __result__tag154 = 0 ;

        if (__tag154 == null ){
            __tag154 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag154);
        }
        __tag154.setPageContext(pageContext);
        __tag154.setParent(null);
        __tag154.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedHOD.label", java.lang.String .class,"key"));
        __tag154.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag154;
        __result__tag154 = __tag154.doStartTag();

        if (__result__tag154!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag154== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag154.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag154);
            return true;
        }
        _activeTag=__tag154.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag154);
        __tag154.release();
        return false;
    }

    private boolean _jsp__tag155(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag155 = null ;
        int __result__tag155 = 0 ;

        if (__tag155 == null ){
            __tag155 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag155);
        }
        __tag155.setPageContext(pageContext);
        __tag155.setParent(null);
        __tag155.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag155.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag155;
        __result__tag155 = __tag155.doStartTag();

        if (__result__tag155!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag155== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag155.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag155);
            return true;
        }
        _activeTag=__tag155.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag155);
        __tag155.release();
        return false;
    }

    private boolean _jsp__tag156(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag156 = null ;
        int __result__tag156 = 0 ;

        if (__tag156 == null ){
            __tag156 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag156);
        }
        __tag156.setPageContext(pageContext);
        __tag156.setParent(null);
        __tag156.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequiredDocuments.label", java.lang.String .class,"key"));
        __tag156.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag156;
        __result__tag156 = __tag156.doStartTag();

        if (__result__tag156!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag156== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag156.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag156);
            return true;
        }
        _activeTag=__tag156.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag156);
        __tag156.release();
        return false;
    }

    private boolean _jsp__tag157(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag157 = null ;
        int __result__tag157 = 0 ;

        if (__tag157 == null ){
            __tag157 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag157);
        }
        __tag157.setPageContext(pageContext);
        __tag157.setParent(null);
        __tag157.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.HODCoordinatorRemarks.label", java.lang.String .class,"key"));
        __tag157.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag157;
        __result__tag157 = __tag157.doStartTag();

        if (__result__tag157!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag157== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag157.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag157);
            return true;
        }
        _activeTag=__tag157.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag157);
        __tag157.release();
        return false;
    }

    private boolean _jsp__tag158(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag158 = null ;
        int __result__tag158 = 0 ;

        if (__tag158 == null ){
            __tag158 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag158);
        }
        __tag158.setPageContext(pageContext);
        __tag158.setParent(null);
        __tag158.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag158.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag158;
        __result__tag158 = __tag158.doStartTag();

        if (__result__tag158!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag158== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag158.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag158);
            return true;
        }
        _activeTag=__tag158.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag158);
        __tag158.release();
        return false;
    }

    private boolean _jsp__tag159(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag159 = null ;
        int __result__tag159 = 0 ;

        if (__tag159 == null ){
            __tag159 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag159);
        }
        __tag159.setPageContext(pageContext);
        __tag159.setParent(null);
        __tag159.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Request.label", java.lang.String .class,"key"));
        __tag159.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag159;
        __result__tag159 = __tag159.doStartTag();

        if (__result__tag159!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag159== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag159.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag159);
            return true;
        }
        _activeTag=__tag159.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag159);
        __tag159.release();
        return false;
    }

    private boolean _jsp__tag160(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag160 = null ;
        int __result__tag160 = 0 ;

        if (__tag160 == null ){
            __tag160 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag160);
        }
        __tag160.setPageContext(pageContext);
        __tag160.setParent(null);
        __tag160.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag160.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag160;
        __result__tag160 = __tag160.doStartTag();

        if (__result__tag160!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag160== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag160.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag160);
            return true;
        }
        _activeTag=__tag160.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag160);
        __tag160.release();
        return false;
    }

    private boolean _jsp__tag161(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag161 = null ;
        int __result__tag161 = 0 ;

        if (__tag161 == null ){
            __tag161 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag161);
        }
        __tag161.setPageContext(pageContext);
        __tag161.setParent(null);
        __tag161.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag161.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag161;
        __result__tag161 = __tag161.doStartTag();

        if (__result__tag161!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag161== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag161.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag161);
            return true;
        }
        _activeTag=__tag161.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag161);
        __tag161.release();
        return false;
    }

    private boolean _jsp__tag162(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag162 = null ;
        int __result__tag162 = 0 ;

        if (__tag162 == null ){
            __tag162 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag162);
        }
        __tag162.setPageContext(pageContext);
        __tag162.setParent(null);
        __tag162.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Task.label", java.lang.String .class,"key"));
        __tag162.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag162;
        __result__tag162 = __tag162.doStartTag();

        if (__result__tag162!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag162== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag162.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag162);
            return true;
        }
        _activeTag=__tag162.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag162);
        __tag162.release();
        return false;
    }

    private boolean _jsp__tag163(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag163 = null ;
        int __result__tag163 = 0 ;

        if (__tag163 == null ){
            __tag163 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag163);
        }
        __tag163.setPageContext(pageContext);
        __tag163.setParent(null);
        __tag163.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PractitionerTask.label", java.lang.String .class,"key"));
        __tag163.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag163;
        __result__tag163 = __tag163.doStartTag();

        if (__result__tag163!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag163== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag163.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag163);
            return true;
        }
        _activeTag=__tag163.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag163);
        __tag163.release();
        return false;
    }

    private boolean _jsp__tag164(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag164 = null ;
        int __result__tag164 = 0 ;

        if (__tag164 == null ){
            __tag164 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag164);
        }
        __tag164.setPageContext(pageContext);
        __tag164.setParent(null);
        __tag164.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag164.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag164;
        __result__tag164 = __tag164.doStartTag();

        if (__result__tag164!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag164== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag164.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag164);
            return true;
        }
        _activeTag=__tag164.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag164);
        __tag164.release();
        return false;
    }

    private boolean _jsp__tag165(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag165 = null ;
        int __result__tag165 = 0 ;

        if (__tag165 == null ){
            __tag165 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag165);
        }
        __tag165.setPageContext(pageContext);
        __tag165.setParent(null);
        __tag165.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag165.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag165;
        __result__tag165 = __tag165.doStartTag();

        if (__result__tag165!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag165== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag165.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag165);
            return true;
        }
        _activeTag=__tag165.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag165);
        __tag165.release();
        return false;
    }

    private boolean _jsp__tag166(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag166 = null ;
        int __result__tag166 = 0 ;

        if (__tag166 == null ){
            __tag166 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag166);
        }
        __tag166.setPageContext(pageContext);
        __tag166.setParent(null);
        __tag166.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AcceptedbyPractitioner.label", java.lang.String .class,"key"));
        __tag166.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag166;
        __result__tag166 = __tag166.doStartTag();

        if (__result__tag166!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag166== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag166.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag166);
            return true;
        }
        _activeTag=__tag166.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag166);
        __tag166.release();
        return false;
    }

    private boolean _jsp__tag167(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag167 = null ;
        int __result__tag167 = 0 ;

        if (__tag167 == null ){
            __tag167 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag167);
        }
        __tag167.setPageContext(pageContext);
        __tag167.setParent(null);
        __tag167.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RejectedbyPractitionertoMRD.label", java.lang.String .class,"key"));
        __tag167.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag167;
        __result__tag167 = __tag167.doStartTag();

        if (__result__tag167!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag167== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag167.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag167);
            return true;
        }
        _activeTag=__tag167.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag167);
        __tag167.release();
        return false;
    }

    private boolean _jsp__tag168(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag168 = null ;
        int __result__tag168 = 0 ;

        if (__tag168 == null ){
            __tag168 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag168);
        }
        __tag168.setPageContext(pageContext);
        __tag168.setParent(null);
        __tag168.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RejectedbyPractitionertoHOD.label", java.lang.String .class,"key"));
        __tag168.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag168;
        __result__tag168 = __tag168.doStartTag();

        if (__result__tag168!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag168== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag168.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag168);
            return true;
        }
        _activeTag=__tag168.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag168);
        __tag168.release();
        return false;
    }

    private boolean _jsp__tag169(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag169 = null ;
        int __result__tag169 = 0 ;

        if (__tag169 == null ){
            __tag169 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag169);
        }
        __tag169.setPageContext(pageContext);
        __tag169.setParent(null);
        __tag169.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrepareDate.label", java.lang.String .class,"key"));
        __tag169.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag169;
        __result__tag169 = __tag169.doStartTag();

        if (__result__tag169!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag169== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag169.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag169);
            return true;
        }
        _activeTag=__tag169.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag169);
        __tag169.release();
        return false;
    }

    private boolean _jsp__tag170(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag170 = null ;
        int __result__tag170 = 0 ;

        if (__tag170 == null ){
            __tag170 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag170);
        }
        __tag170.setPageContext(pageContext);
        __tag170.setParent(null);
        __tag170.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforRejection.label", java.lang.String .class,"key"));
        __tag170.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag170;
        __result__tag170 = __tag170.doStartTag();

        if (__result__tag170!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag170== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag170.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag170);
            return true;
        }
        _activeTag=__tag170.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag170);
        __tag170.release();
        return false;
    }

    private boolean _jsp__tag171(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag171 = null ;
        int __result__tag171 = 0 ;

        if (__tag171 == null ){
            __tag171 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag171);
        }
        __tag171.setPageContext(pageContext);
        __tag171.setParent(null);
        __tag171.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ReasonforReturn.label", java.lang.String .class,"key"));
        __tag171.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag171;
        __result__tag171 = __tag171.doStartTag();

        if (__result__tag171!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag171== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag171.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag171);
            return true;
        }
        _activeTag=__tag171.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag171);
        __tag171.release();
        return false;
    }

    private boolean _jsp__tag172(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag172 = null ;
        int __result__tag172 = 0 ;

        if (__tag172 == null ){
            __tag172 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag172);
        }
        __tag172.setPageContext(pageContext);
        __tag172.setParent(null);
        __tag172.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag172.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag172;
        __result__tag172 = __tag172.doStartTag();

        if (__result__tag172!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag172== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag172.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag172);
            return true;
        }
        _activeTag=__tag172.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag172);
        __tag172.release();
        return false;
    }

    private boolean _jsp__tag173(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag173 = null ;
        int __result__tag173 = 0 ;

        if (__tag173 == null ){
            __tag173 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag173);
        }
        __tag173.setPageContext(pageContext);
        __tag173.setParent(null);
        __tag173.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PreparedbyPractitioner.label", java.lang.String .class,"key"));
        __tag173.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag173;
        __result__tag173 = __tag173.doStartTag();

        if (__result__tag173!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag173== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag173.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag173);
            return true;
        }
        _activeTag=__tag173.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag173);
        __tag173.release();
        return false;
    }

    private boolean _jsp__tag174(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag174 = null ;
        int __result__tag174 = 0 ;

        if (__tag174 == null ){
            __tag174 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag174);
        }
        __tag174.setPageContext(pageContext);
        __tag174.setParent(null);
        __tag174.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Rejectedbypractitioner.label", java.lang.String .class,"key"));
        __tag174.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag174;
        __result__tag174 = __tag174.doStartTag();

        if (__result__tag174!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag174== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag174.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag174);
            return true;
        }
        _activeTag=__tag174.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag174);
        __tag174.release();
        return false;
    }

    private boolean _jsp__tag175(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag175 = null ;
        int __result__tag175 = 0 ;

        if (__tag175 == null ){
            __tag175 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag175);
        }
        __tag175.setPageContext(pageContext);
        __tag175.setParent(null);
        __tag175.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Returnedbypractitioner.label", java.lang.String .class,"key"));
        __tag175.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag175;
        __result__tag175 = __tag175.doStartTag();

        if (__result__tag175!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag175== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag175.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag175);
            return true;
        }
        _activeTag=__tag175.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag175);
        __tag175.release();
        return false;
    }

    private boolean _jsp__tag176(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag176 = null ;
        int __result__tag176 = 0 ;

        if (__tag176 == null ){
            __tag176 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag176);
        }
        __tag176.setPageContext(pageContext);
        __tag176.setParent(null);
        __tag176.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AcceptDateTime.label", java.lang.String .class,"key"));
        __tag176.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag176;
        __result__tag176 = __tag176.doStartTag();

        if (__result__tag176!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag176== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag176.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag176);
            return true;
        }
        _activeTag=__tag176.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag176);
        __tag176.release();
        return false;
    }

    private boolean _jsp__tag177(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag177 = null ;
        int __result__tag177 = 0 ;

        if (__tag177 == null ){
            __tag177 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag177);
        }
        __tag177.setPageContext(pageContext);
        __tag177.setParent(null);
        __tag177.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RejectDateTime.label", java.lang.String .class,"key"));
        __tag177.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag177;
        __result__tag177 = __tag177.doStartTag();

        if (__result__tag177!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag177== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag177.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag177);
            return true;
        }
        _activeTag=__tag177.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag177);
        __tag177.release();
        return false;
    }

    private boolean _jsp__tag178(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag178 = null ;
        int __result__tag178 = 0 ;

        if (__tag178 == null ){
            __tag178 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag178);
        }
        __tag178.setPageContext(pageContext);
        __tag178.setParent(null);
        __tag178.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.returned.label", java.lang.String .class,"key"));
        __tag178.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag178;
        __result__tag178 = __tag178.doStartTag();

        if (__result__tag178!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag178== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag178.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag178);
            return true;
        }
        _activeTag=__tag178.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag178);
        __tag178.release();
        return false;
    }

    private boolean _jsp__tag179(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag179 = null ;
        int __result__tag179 = 0 ;

        if (__tag179 == null ){
            __tag179 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag179);
        }
        __tag179.setPageContext(pageContext);
        __tag179.setParent(null);
        __tag179.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
        __tag179.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag179;
        __result__tag179 = __tag179.doStartTag();

        if (__result__tag179!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag179== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag179.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag179);
            return true;
        }
        _activeTag=__tag179.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag179);
        __tag179.release();
        return false;
    }

    private boolean _jsp__tag180(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag180 = null ;
        int __result__tag180 = 0 ;

        if (__tag180 == null ){
            __tag180 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag180);
        }
        __tag180.setPageContext(pageContext);
        __tag180.setParent(null);
        __tag180.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag180.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag180;
        __result__tag180 = __tag180.doStartTag();

        if (__result__tag180!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag180== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag180.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag180);
            return true;
        }
        _activeTag=__tag180.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag180);
        __tag180.release();
        return false;
    }

    private boolean _jsp__tag181(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag181 = null ;
        int __result__tag181 = 0 ;

        if (__tag181 == null ){
            __tag181 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag181);
        }
        __tag181.setPageContext(pageContext);
        __tag181.setParent(null);
        __tag181.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag181.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag181;
        __result__tag181 = __tag181.doStartTag();

        if (__result__tag181!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag181== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag181.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag181);
            return true;
        }
        _activeTag=__tag181.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag181);
        __tag181.release();
        return false;
    }

    private boolean _jsp__tag182(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag182 = null ;
        int __result__tag182 = 0 ;

        if (__tag182 == null ){
            __tag182 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag182);
        }
        __tag182.setPageContext(pageContext);
        __tag182.setParent(null);
        __tag182.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PractitionerRemarks.label", java.lang.String .class,"key"));
        __tag182.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag182;
        __result__tag182 = __tag182.doStartTag();

        if (__result__tag182!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag182== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag182.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag182);
            return true;
        }
        _activeTag=__tag182.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag182);
        __tag182.release();
        return false;
    }

    private boolean _jsp__tag183(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag183 = null ;
        int __result__tag183 = 0 ;

        if (__tag183 == null ){
            __tag183 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag183);
        }
        __tag183.setPageContext(pageContext);
        __tag183.setParent(null);
        __tag183.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequiredDocuments.label", java.lang.String .class,"key"));
        __tag183.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag183;
        __result__tag183 = __tag183.doStartTag();

        if (__result__tag183!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag183== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag183.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag183);
            return true;
        }
        _activeTag=__tag183.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag183);
        __tag183.release();
        return false;
    }

    private boolean _jsp__tag184(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag184 = null ;
        int __result__tag184 = 0 ;

        if (__tag184 == null ){
            __tag184 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag184);
        }
        __tag184.setPageContext(pageContext);
        __tag184.setParent(null);
        __tag184.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ReportPreparedDate.label", java.lang.String .class,"key"));
        __tag184.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag184;
        __result__tag184 = __tag184.doStartTag();

        if (__result__tag184!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag184== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag184.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag184);
            return true;
        }
        _activeTag=__tag184.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag184);
        __tag184.release();
        return false;
    }

    private boolean _jsp__tag185(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag185 = null ;
        int __result__tag185 = 0 ;

        if (__tag185 == null ){
            __tag185 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag185);
        }
        __tag185.setPageContext(pageContext);
        __tag185.setParent(null);
        __tag185.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ReportCompletionDate.label", java.lang.String .class,"key"));
        __tag185.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag185;
        __result__tag185 = __tag185.doStartTag();

        if (__result__tag185!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag185== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag185.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag185);
            return true;
        }
        _activeTag=__tag185.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag185);
        __tag185.release();
        return false;
    }

    private boolean _jsp__tag186(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag186 = null ;
        int __result__tag186 = 0 ;

        if (__tag186 == null ){
            __tag186 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag186);
        }
        __tag186.setPageContext(pageContext);
        __tag186.setParent(null);
        __tag186.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedDate.label", java.lang.String .class,"key"));
        __tag186.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag186;
        __result__tag186 = __tag186.doStartTag();

        if (__result__tag186!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag186== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag186.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag186);
            return true;
        }
        _activeTag=__tag186.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag186);
        __tag186.release();
        return false;
    }

    private boolean _jsp__tag187(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag187 = null ;
        int __result__tag187 = 0 ;

        if (__tag187 == null ){
            __tag187 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag187);
        }
        __tag187.setPageContext(pageContext);
        __tag187.setParent(null);
        __tag187.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DaystoComplete.label", java.lang.String .class,"key"));
        __tag187.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag187;
        __result__tag187 = __tag187.doStartTag();

        if (__result__tag187!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag187== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag187.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag187);
            return true;
        }
        _activeTag=__tag187.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag187);
        __tag187.release();
        return false;
    }

    private boolean _jsp__tag188(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag188 = null ;
        int __result__tag188 = 0 ;

        if (__tag188 == null ){
            __tag188 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag188);
        }
        __tag188.setPageContext(pageContext);
        __tag188.setParent(null);
        __tag188.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AssignReAssignPractitioner.label", java.lang.String .class,"key"));
        __tag188.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag188;
        __result__tag188 = __tag188.doStartTag();

        if (__result__tag188!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag188== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag188.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag188);
            return true;
        }
        _activeTag=__tag188.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag188);
        __tag188.release();
        return false;
    }

    private boolean _jsp__tag189(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag189 = null ;
        int __result__tag189 = 0 ;

        if (__tag189 == null ){
            __tag189 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag189);
        }
        __tag189.setPageContext(pageContext);
        __tag189.setParent(null);
        __tag189.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedPractitioner.label", java.lang.String .class,"key"));
        __tag189.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag189;
        __result__tag189 = __tag189.doStartTag();

        if (__result__tag189!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag189== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag189.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag189);
            return true;
        }
        _activeTag=__tag189.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag189);
        __tag189.release();
        return false;
    }

    private boolean _jsp__tag190(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag190 = null ;
        int __result__tag190 = 0 ;

        if (__tag190 == null ){
            __tag190 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag190);
        }
        __tag190.setPageContext(pageContext);
        __tag190.setParent(null);
        __tag190.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PreparedbyPractitioner.label", java.lang.String .class,"key"));
        __tag190.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag190;
        __result__tag190 = __tag190.doStartTag();

        if (__result__tag190!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag190== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag190.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag190);
            return true;
        }
        _activeTag=__tag190.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag190);
        __tag190.release();
        return false;
    }

    private boolean _jsp__tag191(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag191 = null ;
        int __result__tag191 = 0 ;

        if (__tag191 == null ){
            __tag191 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag191);
        }
        __tag191.setPageContext(pageContext);
        __tag191.setParent(null);
        __tag191.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RejectedBy.label", java.lang.String .class,"key"));
        __tag191.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag191;
        __result__tag191 = __tag191.doStartTag();

        if (__result__tag191!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag191== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag191.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag191);
            return true;
        }
        _activeTag=__tag191.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag191);
        __tag191.release();
        return false;
    }

    private boolean _jsp__tag192(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag192 = null ;
        int __result__tag192 = 0 ;

        if (__tag192 == null ){
            __tag192 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag192);
        }
        __tag192.setPageContext(pageContext);
        __tag192.setParent(null);
        __tag192.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RejectedOn.label", java.lang.String .class,"key"));
        __tag192.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag192;
        __result__tag192 = __tag192.doStartTag();

        if (__result__tag192!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag192== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag192.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag192);
            return true;
        }
        _activeTag=__tag192.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag192);
        __tag192.release();
        return false;
    }

    private boolean _jsp__tag193(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag193 = null ;
        int __result__tag193 = 0 ;

        if (__tag193 == null ){
            __tag193 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag193);
        }
        __tag193.setPageContext(pageContext);
        __tag193.setParent(null);
        __tag193.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforRejection.label", java.lang.String .class,"key"));
        __tag193.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag193;
        __result__tag193 = __tag193.doStartTag();

        if (__result__tag193!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag193== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag193.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag193);
            return true;
        }
        _activeTag=__tag193.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag193);
        __tag193.release();
        return false;
    }

    private boolean _jsp__tag194(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag194 = null ;
        int __result__tag194 = 0 ;

        if (__tag194 == null ){
            __tag194 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag194);
        }
        __tag194.setPageContext(pageContext);
        __tag194.setParent(null);
        __tag194.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag194.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag194;
        __result__tag194 = __tag194.doStartTag();

        if (__result__tag194!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag194== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag194.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag194);
            return true;
        }
        _activeTag=__tag194.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag194);
        __tag194.release();
        return false;
    }

    private boolean _jsp__tag195(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag195 = null ;
        int __result__tag195 = 0 ;

        if (__tag195 == null ){
            __tag195 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag195);
        }
        __tag195.setPageContext(pageContext);
        __tag195.setParent(null);
        __tag195.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrepareDate.label", java.lang.String .class,"key"));
        __tag195.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag195;
        __result__tag195 = __tag195.doStartTag();

        if (__result__tag195!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag195== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag195.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag195);
            return true;
        }
        _activeTag=__tag195.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag195);
        __tag195.release();
        return false;
    }

    private boolean _jsp__tag196(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag196 = null ;
        int __result__tag196 = 0 ;

        if (__tag196 == null ){
            __tag196 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag196);
        }
        __tag196.setPageContext(pageContext);
        __tag196.setParent(null);
        __tag196.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedDate.label", java.lang.String .class,"key"));
        __tag196.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag196;
        __result__tag196 = __tag196.doStartTag();

        if (__result__tag196!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag196== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag196.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag196);
            return true;
        }
        _activeTag=__tag196.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag196);
        __tag196.release();
        return false;
    }

    private boolean _jsp__tag197(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag197 = null ;
        int __result__tag197 = 0 ;

        if (__tag197 == null ){
            __tag197 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag197);
        }
        __tag197.setPageContext(pageContext);
        __tag197.setParent(null);
        __tag197.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeliveredDate.label", java.lang.String .class,"key"));
        __tag197.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag197;
        __result__tag197 = __tag197.doStartTag();

        if (__result__tag197!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag197== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag197.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag197);
            return true;
        }
        _activeTag=__tag197.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag197);
        __tag197.release();
        return false;
    }

    private boolean _jsp__tag198(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag198 = null ;
        int __result__tag198 = 0 ;

        if (__tag198 == null ){
            __tag198 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag198);
        }
        __tag198.setPageContext(pageContext);
        __tag198.setParent(null);
        __tag198.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeliveryMode.label", java.lang.String .class,"key"));
        __tag198.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag198;
        __result__tag198 = __tag198.doStartTag();

        if (__result__tag198!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag198== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag198.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag198);
            return true;
        }
        _activeTag=__tag198.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag198);
        __tag198.release();
        return false;
    }

    private boolean _jsp__tag199(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag199 = null ;
        int __result__tag199 = 0 ;

        if (__tag199 == null ){
            __tag199 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag199);
        }
        __tag199.setPageContext(pageContext);
        __tag199.setParent(null);
        __tag199.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeliverDispatchMode.label", java.lang.String .class,"key"));
        __tag199.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag199;
        __result__tag199 = __tag199.doStartTag();

        if (__result__tag199!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag199== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag199.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag199);
            return true;
        }
        _activeTag=__tag199.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag199);
        __tag199.release();
        return false;
    }

    private boolean _jsp__tag200(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag200 = null ;
        int __result__tag200 = 0 ;

        if (__tag200 == null ){
            __tag200 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag200);
        }
        __tag200.setPageContext(pageContext);
        __tag200.setParent(null);
        __tag200.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag200.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag200;
        __result__tag200 = __tag200.doStartTag();

        if (__result__tag200!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag200== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag200.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag200);
            return true;
        }
        _activeTag=__tag200.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag200);
        __tag200.release();
        return false;
    }

    private boolean _jsp__tag201(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag201 = null ;
        int __result__tag201 = 0 ;

        if (__tag201 == null ){
            __tag201 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag201);
        }
        __tag201.setPageContext(pageContext);
        __tag201.setParent(null);
        __tag201.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Counter.label", java.lang.String .class,"key"));
        __tag201.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag201;
        __result__tag201 = __tag201.doStartTag();

        if (__result__tag201!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag201== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag201.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag201);
            return true;
        }
        _activeTag=__tag201.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag201);
        __tag201.release();
        return false;
    }

    private boolean _jsp__tag202(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag202 = null ;
        int __result__tag202 = 0 ;

        if (__tag202 == null ){
            __tag202 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag202);
        }
        __tag202.setPageContext(pageContext);
        __tag202.setParent(null);
        __tag202.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Post.label", java.lang.String .class,"key"));
        __tag202.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag202;
        __result__tag202 = __tag202.doStartTag();

        if (__result__tag202!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag202== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag202.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag202);
            return true;
        }
        _activeTag=__tag202.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag202);
        __tag202.release();
        return false;
    }

    private boolean _jsp__tag203(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag203 = null ;
        int __result__tag203 = 0 ;

        if (__tag203 == null ){
            __tag203 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag203);
        }
        __tag203.setPageContext(pageContext);
        __tag203.setParent(null);
        __tag203.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Personal.label", java.lang.String .class,"key"));
        __tag203.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag203;
        __result__tag203 = __tag203.doStartTag();

        if (__result__tag203!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag203== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag203.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag203);
            return true;
        }
        _activeTag=__tag203.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag203);
        __tag203.release();
        return false;
    }

    private boolean _jsp__tag204(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag204 = null ;
        int __result__tag204 = 0 ;

        if (__tag204 == null ){
            __tag204 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag204);
        }
        __tag204.setPageContext(pageContext);
        __tag204.setParent(null);
        __tag204.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag204.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag204;
        __result__tag204 = __tag204.doStartTag();

        if (__result__tag204!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag204== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag204.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag204);
            return true;
        }
        _activeTag=__tag204.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag204);
        __tag204.release();
        return false;
    }

    private boolean _jsp__tag205(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag205 = null ;
        int __result__tag205 = 0 ;

        if (__tag205 == null ){
            __tag205 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag205);
        }
        __tag205.setPageContext(pageContext);
        __tag205.setParent(null);
        __tag205.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DatePosted.label", java.lang.String .class,"key"));
        __tag205.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag205;
        __result__tag205 = __tag205.doStartTag();

        if (__result__tag205!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag205== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag205.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag205);
            return true;
        }
        _activeTag=__tag205.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag205);
        __tag205.release();
        return false;
    }

    private boolean _jsp__tag206(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag206 = null ;
        int __result__tag206 = 0 ;

        if (__tag206 == null ){
            __tag206 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag206);
        }
        __tag206.setPageContext(pageContext);
        __tag206.setParent(null);
        __tag206.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeliveredDate.label", java.lang.String .class,"key"));
        __tag206.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag206;
        __result__tag206 = __tag206.doStartTag();

        if (__result__tag206!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag206== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag206.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag206);
            return true;
        }
        _activeTag=__tag206.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag206);
        __tag206.release();
        return false;
    }

    private boolean _jsp__tag207(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag207 = null ;
        int __result__tag207 = 0 ;

        if (__tag207 == null ){
            __tag207 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag207);
        }
        __tag207.setPageContext(pageContext);
        __tag207.setParent(null);
        __tag207.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ReportTakenBy.label", java.lang.String .class,"key"));
        __tag207.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag207;
        __result__tag207 = __tag207.doStartTag();

        if (__result__tag207!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag207== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag207.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag207);
            return true;
        }
        _activeTag=__tag207.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag207);
        __tag207.release();
        return false;
    }

    private boolean _jsp__tag208(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag208 = null ;
        int __result__tag208 = 0 ;

        if (__tag208 == null ){
            __tag208 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag208);
        }
        __tag208.setPageContext(pageContext);
        __tag208.setParent(null);
        __tag208.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
        __tag208.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag208;
        __result__tag208 = __tag208.doStartTag();

        if (__result__tag208!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag208== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag208.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag208);
            return true;
        }
        _activeTag=__tag208.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag208);
        __tag208.release();
        return false;
    }

    private boolean _jsp__tag209(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag209 = null ;
        int __result__tag209 = 0 ;

        if (__tag209 == null ){
            __tag209 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag209);
        }
        __tag209.setPageContext(pageContext);
        __tag209.setParent(null);
        __tag209.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag209.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag209;
        __result__tag209 = __tag209.doStartTag();

        if (__result__tag209!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag209== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag209.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag209);
            return true;
        }
        _activeTag=__tag209.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag209);
        __tag209.release();
        return false;
    }

    private boolean _jsp__tag210(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag210 = null ;
        int __result__tag210 = 0 ;

        if (__tag210 == null ){
            __tag210 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag210);
        }
        __tag210.setPageContext(pageContext);
        __tag210.setParent(null);
        __tag210.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
        __tag210.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag210;
        __result__tag210 = __tag210.doStartTag();

        if (__result__tag210!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag210== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag210.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag210);
            return true;
        }
        _activeTag=__tag210.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag210);
        __tag210.release();
        return false;
    }

    private boolean _jsp__tag211(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag211 = null ;
        int __result__tag211 = 0 ;

        if (__tag211 == null ){
            __tag211 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag211);
        }
        __tag211.setPageContext(pageContext);
        __tag211.setParent(null);
        __tag211.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PostageNo.label", java.lang.String .class,"key"));
        __tag211.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag211;
        __result__tag211 = __tag211.doStartTag();

        if (__result__tag211!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag211== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag211.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag211);
            return true;
        }
        _activeTag=__tag211.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag211);
        __tag211.release();
        return false;
    }

    private boolean _jsp__tag212(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag212 = null ;
        int __result__tag212 = 0 ;

        if (__tag212 == null ){
            __tag212 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag212);
        }
        __tag212.setPageContext(pageContext);
        __tag212.setParent(null);
        __tag212.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SectionFileNo.label", java.lang.String .class,"key"));
        __tag212.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag212;
        __result__tag212 = __tag212.doStartTag();

        if (__result__tag212!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag212== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag212.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag212);
            return true;
        }
        _activeTag=__tag212.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag212);
        __tag212.release();
        return false;
    }

    private boolean _jsp__tag213(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag213 = null ;
        int __result__tag213 = 0 ;

        if (__tag213 == null ){
            __tag213 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag213);
        }
        __tag213.setPageContext(pageContext);
        __tag213.setParent(null);
        __tag213.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AssignReAssignPractitioner.label", java.lang.String .class,"key"));
        __tag213.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag213;
        __result__tag213 = __tag213.doStartTag();

        if (__result__tag213!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag213== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag213.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag213);
            return true;
        }
        _activeTag=__tag213.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag213);
        __tag213.release();
        return false;
    }

    private boolean _jsp__tag214(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag214 = null ;
        int __result__tag214 = 0 ;

        if (__tag214 == null ){
            __tag214 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag214);
        }
        __tag214.setPageContext(pageContext);
        __tag214.setParent(null);
        __tag214.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedPractitioner.label", java.lang.String .class,"key"));
        __tag214.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag214;
        __result__tag214 = __tag214.doStartTag();

        if (__result__tag214!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag214== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag214.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag214);
            return true;
        }
        _activeTag=__tag214.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag214);
        __tag214.release();
        return false;
    }

    private boolean _jsp__tag215(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag215 = null ;
        int __result__tag215 = 0 ;

        if (__tag215 == null ){
            __tag215 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag215);
        }
        __tag215.setPageContext(pageContext);
        __tag215.setParent(null);
        __tag215.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PreparedbyPractitioner.label", java.lang.String .class,"key"));
        __tag215.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag215;
        __result__tag215 = __tag215.doStartTag();

        if (__result__tag215!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag215== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag215.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag215);
            return true;
        }
        _activeTag=__tag215.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag215);
        __tag215.release();
        return false;
    }

    private boolean _jsp__tag216(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag216 = null ;
        int __result__tag216 = 0 ;

        if (__tag216 == null ){
            __tag216 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag216);
        }
        __tag216.setPageContext(pageContext);
        __tag216.setParent(null);
        __tag216.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrepareDate.label", java.lang.String .class,"key"));
        __tag216.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag216;
        __result__tag216 = __tag216.doStartTag();

        if (__result__tag216!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag216== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag216.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag216);
            return true;
        }
        _activeTag=__tag216.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag216);
        __tag216.release();
        return false;
    }

    private boolean _jsp__tag217(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag217 = null ;
        int __result__tag217 = 0 ;

        if (__tag217 == null ){
            __tag217 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag217);
        }
        __tag217.setPageContext(pageContext);
        __tag217.setParent(null);
        __tag217.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedDate.label", java.lang.String .class,"key"));
        __tag217.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag217;
        __result__tag217 = __tag217.doStartTag();

        if (__result__tag217!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag217== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag217.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag217);
            return true;
        }
        _activeTag=__tag217.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag217);
        __tag217.release();
        return false;
    }

    private boolean _jsp__tag218(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag218 = null ;
        int __result__tag218 = 0 ;

        if (__tag218 == null ){
            __tag218 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag218);
        }
        __tag218.setPageContext(pageContext);
        __tag218.setParent(null);
        __tag218.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ReportCompletionDate.label", java.lang.String .class,"key"));
        __tag218.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag218;
        __result__tag218 = __tag218.doStartTag();

        if (__result__tag218!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag218== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag218.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag218);
            return true;
        }
        _activeTag=__tag218.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag218);
        __tag218.release();
        return false;
    }

    private boolean _jsp__tag219(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag219 = null ;
        int __result__tag219 = 0 ;

        if (__tag219 == null ){
            __tag219 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag219);
        }
        __tag219.setPageContext(pageContext);
        __tag219.setParent(null);
        __tag219.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
        __tag219.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag219;
        __result__tag219 = __tag219.doStartTag();

        if (__result__tag219!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag219== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag219.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag219);
            return true;
        }
        _activeTag=__tag219.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag219);
        __tag219.release();
        return false;
    }

    private boolean _jsp__tag220(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag220 = null ;
        int __result__tag220 = 0 ;

        if (__tag220 == null ){
            __tag220 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag220);
        }
        __tag220.setPageContext(pageContext);
        __tag220.setParent(null);
        __tag220.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ForwardedHOD.label", java.lang.String .class,"key"));
        __tag220.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag220;
        __result__tag220 = __tag220.doStartTag();

        if (__result__tag220!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag220== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag220.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag220);
            return true;
        }
        _activeTag=__tag220.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag220);
        __tag220.release();
        return false;
    }

    private boolean _jsp__tag221(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag221 = null ;
        int __result__tag221 = 0 ;

        if (__tag221 == null ){
            __tag221 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag221);
        }
        __tag221.setPageContext(pageContext);
        __tag221.setParent(null);
        __tag221.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeliveryRemarks.label", java.lang.String .class,"key"));
        __tag221.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag221;
        __result__tag221 = __tag221.doStartTag();

        if (__result__tag221!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag221== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag221.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag221);
            return true;
        }
        _activeTag=__tag221.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag221);
        __tag221.release();
        return false;
    }

    private boolean _jsp__tag222(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag222 = null ;
        int __result__tag222 = 0 ;

        if (__tag222 == null ){
            __tag222 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag222);
        }
        __tag222.setPageContext(pageContext);
        __tag222.setParent(null);
        __tag222.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RevisedCollectDate.label", java.lang.String .class,"key"));
        __tag222.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag222;
        __result__tag222 = __tag222.doStartTag();

        if (__result__tag222!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag222== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag222.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag222);
            return true;
        }
        _activeTag=__tag222.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag222);
        __tag222.release();
        return false;
    }

    private boolean _jsp__tag223(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag223 = null ;
        int __result__tag223 = 0 ;

        if (__tag223 == null ){
            __tag223 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag223);
        }
        __tag223.setPageContext(pageContext);
        __tag223.setParent(null);
        __tag223.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
        __tag223.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag223;
        __result__tag223 = __tag223.doStartTag();

        if (__result__tag223!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag223== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag223.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag223);
            return true;
        }
        _activeTag=__tag223.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag223);
        __tag223.release();
        return false;
    }
}
